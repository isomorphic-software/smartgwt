/*
 * Smart GWT (GWT for SmartClient)
 * Copyright 2008 and beyond, Isomorphic Software, Inc.
 *
 * Smart GWT is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License version 3
 * is published by the Free Software Foundation.  Smart GWT is also
 * available under typical commercial license terms - see
 * http://smartclient.com/license
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 */

package com.smartgwt.rebind;

import com.google.gwt.core.ext.Generator;
import com.google.gwt.core.ext.GeneratorContext;
import com.google.gwt.core.ext.TreeLogger;
import com.google.gwt.core.ext.UnableToCompleteException;
import com.google.gwt.core.ext.typeinfo.JClassType;
import com.google.gwt.core.ext.typeinfo.JType;
import com.google.gwt.core.ext.typeinfo.JMethod;
import com.google.gwt.core.ext.typeinfo.JPrimitiveType;
import com.google.gwt.core.ext.typeinfo.NotFoundException;
import com.google.gwt.core.ext.typeinfo.TypeOracle;
import com.google.gwt.user.rebind.ClassSourceFileComposerFactory;
import com.google.gwt.user.rebind.SourceWriter;

import com.smartgwt.rebind.BeanProperty;
import com.smartgwt.rebind.BeanMethod;
import com.smartgwt.rebind.BeanValueType;
import com.smartgwt.client.widgets.BaseWidget;
import com.smartgwt.client.core.DataClass;
import com.smartgwt.client.bean.BeanFactory;
import com.smartgwt.client.bean.BeanFactoryForBaseWidget;
import com.smartgwt.client.bean.BeanFactoryForDataClass;

import java.util.Set;
import java.util.List;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.HashSet;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.Map;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Collection;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

import java.io.PrintWriter;

// Class which represents a BeanClass for which a factory is being generated.
// This is separated from the actual generator because we sometimes want to
// generate more than one of these (i.e. for superclasses).
public class BeanClass {
    private JClassType beanClassType;
    private TypeOracle typeOracle;
    private BeanClass superclass;
    private JClassType factoryClass;
    private SourceWriter source;

    private Map<String, BeanProperty> properties;
    
    // A global list of our methods ... we write them out as JSNI functions,
    // so that properties can refer to them (and call them) by index.
    private LinkedList<BeanMethod> methods;

    // A set of property names which we don't want to include in the factory
    private static final Set<String> excludedPropertyNames = new HashSet<String> (
        Arrays.asList(
            "logicalStructure",
            "orCreateJsObj",
            // containerWidget causes problems in FormItem because there is a
            // getter but no setter, and the process for creating FormItems
            // sometimes calls the setter. By excluding it here, we fall
            // through to setting a JavaScript attribute, which is what we
            // want. The alternative would be to *generally* fall through
            // to setting a JavaScript attribute in situations where there
            // is a getter but no setter. Or, doing so in particular cases
            // that we would identify somehow.
            "containerWidget"
        )
    );

    public BeanClass (JClassType beanClassType, TypeOracle typeOracle) {
        this.beanClassType = beanClassType;
        this.typeOracle = typeOracle;

        final JClassType baseWidgetType = typeOracle.findType(BaseWidget.class.getCanonicalName());
        final JClassType dataClassType = typeOracle.findType(DataClass.class.getCanonicalName());
        
        if (beanClassType.isAssignableTo(baseWidgetType)) {
            this.factoryClass = typeOracle.findType(BeanFactoryForBaseWidget.class.getCanonicalName());
        } else if (beanClassType.isAssignableTo(dataClassType)) {
            this.factoryClass = typeOracle.findType(BeanFactoryForDataClass.class.getCanonicalName());
        }

        // We'll look for superclasses up to BaseWidget or DataClass, and make sure that we
        // generate factories for them as well. That way, we can keep track of
        // just our own properties.
        if (beanClassType != baseWidgetType && beanClassType != dataClassType) {
            JClassType beanSuperclassType = this.beanClassType.getSuperclass();
            if (beanSuperclassType != null) {
                this.superclass = new BeanClass(beanSuperclassType, typeOracle);
            }
        }

        // We use a TreeMap to sort the properties ... not really necessary,
        // but it's nice for debugging!
        properties = new TreeMap<String, BeanProperty>();
        methods = new LinkedList<BeanMethod>();

        // Iterate through our methods, and create properties from them
        for (JMethod method : beanClassType.getMethods()) {
            BeanMethod beanMethod = new BeanMethod(method, typeOracle);
            String propertyName = beanMethod.getName();
            
            if (!excludedPropertyNames.contains(propertyName)) {
                if (beanMethod.isGetter() || beanMethod.isSetter()) {
                    BeanProperty property = properties.get(propertyName);
                    if (property == null) {
                        property = new BeanProperty(propertyName, this);
                        properties.put(propertyName, property);
                    }
                    // This will call back to add the method to our global list as well
                    property.addMethod(beanMethod);
                }
            }
        }

        // Now that we have our properties, iterate through them and make a few
        // adjustments We create a list for new properties, since we can't
        // modify the properties HashMap while iterating through it.
        LinkedList<BeanProperty> additionalProperties = new LinkedList<BeanProperty>();
        for (BeanProperty property : properties.values()) {
            // Check if a superclass has the same property.  If so, copy its
            // methods here if they are not overridden.  This simplifies the
            // run-time logic -- if the property is here, we can just use it,
            // and if it's not, we check the superclasses. But we don't have to
            // consolidate methods at run-time.
            //
            // Essentially, this deals with the case where a subclass overrides
            // one overloaded method but not others.
            BeanProperty superProperty = findPropertyInSuperclass(property.getName());
            if (superProperty != null) property.mergeProperty(superProperty);

            // If the name might be overloaded (e.g. getWidthAsString), then
            // check whether we have the unoverloaded property, or a superclass
            // does. If so, merge the overloaded property into the main
            // property. Note that we don't delete the overloaded property, so
            // it still can be used separately (though with limited types -- we
            // don't merge the main property into the overloaded property).
            if (property.getMaybeOverloadedGetter()) {
                BeanProperty mainProperty = properties.get(property.getNameWithoutOverload());

                if (mainProperty == null) {
                    // If no main property, check superclasses as well.  
                    superProperty = findPropertyInSuperclass(property.getNameWithoutOverload());
                    if (superProperty != null) {
                        // If there is a superclass property, then create a new
                        // property here for the overload and then merge the
                        // superProperty.  If there is no superclass property
                        // either, then we just leave things alone.
                        mainProperty = new BeanProperty(property.getNameWithoutOverload(), this);
                        
                        // We need to add the first getter of the super property first,
                        // because that will be the default getter.
                        mainProperty.addMethod(superProperty.firstGetter());

                        // For the rest, merge the overloaded property first,
                        // so it has priority over the superProperty
                        mainProperty.mergeProperty(property);
                        mainProperty.mergeProperty(superProperty);
                        
                        // Add it to the list of additional properties, since we can't modify the
                        // properties HashMap while we're iterating over it.
                        additionalProperties.add(mainProperty);
                    }
                } else {
                    // If there already was a mainProperty, then just merge the
                    // overloaded methods
                    mainProperty.mergeProperty(property);
                }
            }
        }

        // If we created any additionalProperties, add them now that iteration is done
        for (BeanProperty additionalProperty : additionalProperties) {
            properties.put(additionalProperty.getName(), additionalProperty);
        }
    }

    // This finds the first superclass with the specified property. We only
    // need one, because we're consolidating at each level -- it will already
    // consolidate further superclasses.
    public BeanProperty findPropertyInSuperclass (String propertyName) {
        BeanClass iterator = superclass;
        while (iterator != null) {
            BeanProperty superProperty = iterator.getProperty(propertyName); 
            if (superProperty != null) return superProperty;
            iterator = iterator.superclass;
        }
        return null;
    }

    public BeanProperty getProperty (String propertyName) {
        return properties.get(propertyName);
    }

    public void addMethod (BeanMethod method) {
        // This would be more efficient if methods were a set, but we need
        // the indexOf method, which the Set variants don't seem to have.
        if (methods.contains(method)) return;
        methods.add(method);
    }

    public void removeMethod (BeanMethod method) {
        methods.remove(method);
    }

    public int indexOfMethod (BeanMethod method) {
        return methods.indexOf(method);
    }

    public String generateFactory (TreeLogger logger, GeneratorContext context) {
        final String packageName = beanClassType.getPackage().getName();
        final String factoryName = getSimpleFactoryName();
        ClassSourceFileComposerFactory composer = new ClassSourceFileComposerFactory(packageName, factoryName);

        // We use class literals so that we fail early if the class isn't found
        composer.addImport("com.smartgwt.client.bean.types.*");
        composer.addImport(com.smartgwt.client.bean.BeanFactory.class.getCanonicalName());
        composer.addImport(com.smartgwt.client.bean.BeanFactoryForBaseWidget.class.getCanonicalName());
        composer.addImport(com.smartgwt.client.bean.BeanFactoryForDataClass.class.getCanonicalName());
        composer.addImport(com.google.gwt.core.client.JavaScriptObject.class.getCanonicalName());
        composer.addImport(com.google.gwt.core.client.JsArray.class.getCanonicalName());
        composer.addImport(com.google.gwt.core.client.UnsafeNativeLong.class.getCanonicalName());
        composer.addImport(com.smartgwt.client.bean.BeanProperty1Getter1Setter.class.getCanonicalName());
        composer.addImport(com.smartgwt.client.bean.BeanProperty1Getter.class.getCanonicalName());
        composer.addImport(com.smartgwt.client.bean.BeanProperty1Setter.class.getCanonicalName());
        composer.addImport(com.smartgwt.client.bean.BeanPropertyMultiple.class.getCanonicalName());
        composer.addImport(com.smartgwt.client.bean.BeanProperty.class.getCanonicalName());
        composer.addImport(com.smartgwt.client.bean.BeanMethod.class.getCanonicalName());

        // Import our beanClass ... makes the generated code prettier ...
        composer.addImport(getQualifiedBeanClassName());
        
        // We inherit from just one class -- we will have a reference to an object for the
        // superclass, rather than it being our superclass.
        composer.setSuperclass(factoryClass.getSimpleSourceName() +  "<" + beanClassType.getSimpleSourceName() + ">");

        PrintWriter printWriter = context.tryCreate(logger, packageName, factoryName);
        if (printWriter != null) {        
            source = composer.createSourceWriter(context, printWriter);
             
            source.println("// This class lovingly generated by com.smartgwt.rebind.BeanFactoryGenerator");
            writeBlankLine();

            writeStaticCreate();
            writeBlankLine();

            writeGetBeanClass();
            writeBlankLine();

            if (superclass == null) {
                source.println("// No relevant superclass, so not generating getSuperclassName or createSuperclassFactory");
                writeBlankLine();
            } else {
                writeGetSuperclass();
                writeBlankLine();

                writeCreateSuperclassFactory();
                writeBlankLine();
            }

            writeNewInstance();
            writeBlankLine();

            writeMetadata();

            writeRegisterValueTypes(logger, context);
            writeBlankLine();

            writeGetPropertiesAndGetMethods();

            source.commit(logger);
            
            // Note that this won't do much if the factory has already been
            // generated, which will quite often be the case. Also, note that
            // we only need to generate our immediate superclass, since it will
            // in turn generate its superclass.
            if (superclass != null) {
                superclass.generateFactory(logger, context);
            }
        }

        return composer.getCreatedClassName();
    }
    
    public String getSimpleBeanClassName () {
        return beanClassType.getSimpleSourceName();
    }

    public String getQualifiedBeanClassName () {
        return beanClassType.getParameterizedQualifiedSourceName(); 
    }

    public String getSimpleFactoryName () { 
        StringBuilder builder = new StringBuilder();
        JClassType iterator = beanClassType;
        while (iterator != null) {
            if (iterator != beanClassType) builder.insert(0, "_");
            builder.insert(0, iterator.getSimpleSourceName());
            iterator = iterator.getEnclosingType();
        }
        builder.append("BeanFactory");
        return builder.toString();
    }

    public String getQualifiedFactoryName () {
        return beanClassType.getPackage().getName() + "." + getSimpleFactoryName();
    }

    private void writeBlankLine () {
        source.println("");
    }
    
    private void writeStaticCreate () {
        // We check whether a BeanFactory has already been registered for our
        // beanClass.  This can happen if GWT.create is called first on a
        // subclass of our beanClass and then later on our beanClass as well
        // (since the subclass will have generated factories for its
        // superclasses).
        //
        // If a factory has already been registered, we can leave this one
        // uninitialized.  We don't do anything with the result of the
        // GWT.create, so there's no need to actually initialize it.
        source.println("public static BeanFactory create (boolean forSuperclass) {");
        source.indent();
        source.println("BeanFactory factory = BeanFactory.getFactory(" + getSimpleBeanClassName() + ".class);");

        source.println("if (factory == null) factory = new " + getSimpleFactoryName() + "();");
        
        // We register our class name with SGWTFactory only if we're not for a superclass
        source.println("if (!forSuperclass) factory.registerClassNameWithSGWTFactory();");
        source.println("return factory;");
        source.outdent();
        source.println("}");
    }

    private void writeGetBeanClass () {
        String beanClassName = getSimpleBeanClassName();
        source.println("@Override public Class<" + beanClassName + "> getBeanClass () {");
        source.indent();
        source.println("return " + beanClassName + ".class;");
        source.outdent();
        source.println("}");
    }

    private void writeMetadata () {
        if (beanClassType.isAnnotationPresent(BeanFactory.FrameworkClass.class)) {
            source.println("@Override public boolean isFrameworkClass () {");
            source.indent();
            source.println("return true;");
            source.outdent();
            source.println("}");
            writeBlankLine();
        }

        BeanFactory.ScClassName scClass = beanClassType.getAnnotation(BeanFactory.ScClassName.class);
        if (scClass != null) {
            String className = scClass.value();
            if (className != null && !className.equals("")) {
                source.println("@Override public String getDefaultScClassName () {");
                source.indent();
                source.println("return \"" + className + "\";");
                source.outdent();
                source.println("}");
                writeBlankLine();
            }
        }
    }

    private void writeGetPropertiesAndGetMethods () {
        String beanClassName = getSimpleBeanClassName();
        
        source.println("@Override protected BeanProperty<" + beanClassName + ">[] getProperties (JsArray<JavaScriptObject> methods) {");
        source.indent();

        source.println("// Note that we cast to the generic array type, since you can't create generic array types directly.");
        source.println("return (BeanProperty<" + beanClassName + ">[]) new BeanProperty[] {");
        source.indent();

        Iterator<BeanProperty> prop = properties.values().iterator();
        while (prop.hasNext()) {
            BeanProperty property = prop.next();
            property.writeConstructor(source, prop.hasNext());
        }

        source.outdent();
        source.println("};");

        source.outdent();
        source.println("}");

        writeBlankLine();
       
        source.println("// Any native longs are safe because we're not actually manipulating them in Javascript");
        source.println("// We will reference some deprecated methods ... we could exclude them if desired");
        source.println("@Override @UnsafeNativeLong @SuppressWarnings(\"deprecation\")");
        source.println("protected native JsArray<JavaScriptObject> getMethods () /*-{");
        source.indent();
        source.println("return [");
        source.indent();

        Iterator<BeanMethod> i = methods.iterator();
        while (i.hasNext()) {
            BeanMethod method = i.next();
            method.writeJSNIFunction(source, i.hasNext());
        }

        source.outdent();
        source.println("];");
        source.outdent();
        source.println("}-*/;");
    }

    public Collection<BeanValueType> getValueTypes () {
        HashMap<JType, BeanValueType> result = new HashMap<JType, BeanValueType>();
        for (BeanMethod method : methods) {
            JType type = method.getValueType();
            if (!result.containsKey(type)) {
                result.put(type, new BeanValueType(type, typeOracle));
            }
        }
        return result.values();
    }

    private void writeRegisterValueTypes (TreeLogger logger, GeneratorContext context) {
        source.println("@Override protected void registerValueTypes () {");
        source.indent();
        for (BeanValueType valueType : getValueTypes()) {
            // Create the types ... the constructor won't register more than one
            valueType.writeRegisterValueType(source, logger, context);
        }
        source.outdent();
        source.println("}");
    }

    private void writeGetSuperclass () {
        if (superclass == null) return;

        source.println("@Override protected Class getSuperclass () {");
        source.indent();
        source.println("return " + superclass.getQualifiedBeanClassName() + ".class" + ";");
        source.outdent();
        source.println("}");
    }

    private void writeCreateSuperclassFactory () {
        if (superclass == null) return;

        source.println("@Override protected BeanFactory<?> createSuperclassFactory () {");
        source.indent();
        source.println("return " + superclass.getQualifiedFactoryName() + ".create(true);");
        source.outdent();
        source.println("}");
    }

    private void writeNewInstance() {
        source.println("@Override public " + getSimpleBeanClassName() + " newInstance() {");
        source.indent();
        
        if (beanClassType.isAbstract()) {
            source.println("// The base class is abstract, so we'll return null.");
            source.println("return null;");
        } else {
            source.println("return new " + getSimpleBeanClassName() + "();");
        }
        
        source.outdent();
        source.println("}");
    }
}
