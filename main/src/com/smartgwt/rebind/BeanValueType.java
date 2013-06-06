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

import com.google.gwt.core.ext.typeinfo.JType;
import com.google.gwt.core.ext.typeinfo.JMethod;
import com.google.gwt.core.ext.typeinfo.JClassType;
import com.google.gwt.core.ext.typeinfo.JPrimitiveType;
import com.google.gwt.core.ext.typeinfo.JArrayType;
import com.google.gwt.core.ext.typeinfo.JEnumType;
import com.google.gwt.core.ext.typeinfo.JConstructor;
import com.google.gwt.core.ext.typeinfo.TypeOracle;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.ext.Generator;
import com.google.gwt.core.ext.GeneratorContext;
import com.google.gwt.core.ext.TreeLogger;
import com.google.gwt.core.ext.UnableToCompleteException;
import com.google.gwt.user.rebind.ClassSourceFileComposerFactory;
import com.google.gwt.user.rebind.SourceWriter;

import com.smartgwt.rebind.BeanProperty;
import com.smartgwt.rebind.BeanMethod;

import com.smartgwt.client.bean.types.*;
import com.smartgwt.client.widgets.BaseWidget;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.types.ValueEnum;

import java.lang.reflect.Method;
import java.io.PrintWriter;
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;
import java.util.Date;

// Generates a class which represents a type which is used by some bean method
// as a parameter type. This is mainly so that we can use instanceof for
// interfaces, without having to repetitively generate code to do so. We can't
// test arbitrary objects at run-time to see if they implement an arbitrary
// interface, since Class.isAssignableFrom is not implemented, and instanceof
// requires a class literal (i.e. not a Class object stored in a variable).
//
// For class parameters (i.e. not interfaces) we can simulate isAssignableFrom
// by looking at the superclasses. However, that doesn't help for interfaces.
public class BeanValueType {
    // The type which we are wrapping
    private JType valueType;

    // The generic type equivalent, if the type is a primitive. For some array
    // types, the generic type is the componentType.
    private JClassType genericType;
    
    // The constructor which takes a JavaScriptObject, if any
    private JConstructor jsObjConstructor; 

    // Whether the class is declared abstract
    private boolean isAbstract;

    // Whether there is a setJavaScriptObject(jsObj) function
    private boolean hasSetJavaScriptObject;

    // Whether there is a static getOrCreateRef(jsObj) function
    private boolean hasGetOrCreateRef; 

    // The default getScClassName for objects of the type
    private String scClassName;

    // Which pre-written class should we use or generate a subclass for?
    private JClassType beanValueType;

    // Do we need to generate a subclass?
    private boolean requiresGeneration;

    // Does the constructor for the beanValueType take the class literal as a parameter?
    private boolean constructorTakesClassLiteral;

    // Does the constructor for the beanValueType require an empty array?
    private boolean constructorTakesEmptyArray;

    // If the valueType is an array, what is the component type?
    private JType componentType;

    // If the valueType is an array, the BeanValueType for the componentType
    private BeanValueType componentValueType;

    // Cache the TypeOracle
    private TypeOracle oracle;
    
    public boolean requiresGeneration () {
        return requiresGeneration;
    }

    public BeanValueType (JType valueType, TypeOracle oracle) {
        this.valueType = valueType;
        this.oracle = oracle;

        JClassType classType = valueType.isClass();
        if (classType != null) {
            jsObjConstructor = classType.findConstructor(new JType[] {
                findType(com.google.gwt.core.client.JavaScriptObject.class)
            });

            isAbstract = classType.isAbstract();

            JMethod getRef = classType.findMethod("getOrCreateRef", new JType[] {
                findType(com.google.gwt.core.client.JavaScriptObject.class)
            });
            hasGetOrCreateRef = getRef != null && getRef.isStatic();
        }

        initializeBeanValueType();
        assert beanValueType != null;
        assert genericType != null;
        
        // If the constructor doesn't take an empty array, then check if it
        // wants a class literal (it's one or the other, or neither).
        if (!constructorTakesEmptyArray) {
            JConstructor noArgConstructor = beanValueType.findConstructor(new JType[] {});
            constructorTakesClassLiteral = noArgConstructor == null;
        }
    }

    // Finds a type using the TypeOracle, based on a class. This allows us to
    // import the classes, thus failing fast if we have a typo.
    private JClassType findType (Class<?> klass) {
        JClassType type = oracle.findType(klass.getCanonicalName());
        assert type != null : "Could not find type for " + klass.getCanonicalName();
        return type;
    }

    private void initializeBeanValueType () {
        requiresGeneration = false;

        final JPrimitiveType primitiveType = valueType.isPrimitive();
        if (primitiveType != null) {
            if (primitiveType == JPrimitiveType.BOOLEAN) {
                beanValueType = findType(PBooleanValueType.class);
                genericType = findType(Boolean.class); 
            } else if (primitiveType == JPrimitiveType.FLOAT) {
                beanValueType = findType(PFloatValueType.class);
                genericType = findType(Float.class); 
            } else if (primitiveType == JPrimitiveType.DOUBLE) {
                beanValueType = findType(PDoubleValueType.class);
                genericType = findType(Double.class); 
            } else if (primitiveType == JPrimitiveType.INT) {
                beanValueType = findType(PIntegerValueType.class);
                genericType = findType(Integer.class); 
            } else if (primitiveType == JPrimitiveType.LONG) {
                beanValueType = findType(PLongValueType.class);
                genericType = findType(Long.class); 
            }
            return;
        }

        final JEnumType enumType = valueType.isEnum();
        if (enumType != null) {
            genericType = enumType;

            final JType valueEnumType = findType(ValueEnum.class);
            if (Arrays.asList(enumType.getImplementedInterfaces()).contains(valueEnumType)) {
                beanValueType = findType(ValueEnumValueType.class);
            } else {
                beanValueType = findType(EnumValueType.class);
            }
            return;
        }

        final JArrayType arrayType = valueType.isArray();
        if (arrayType != null) {
            genericType = arrayType; 
            componentType = arrayType.getComponentType();
            assert componentType != null;
            
            componentValueType = new BeanValueType(componentType, oracle);
            assert componentValueType != null;

            if (componentType.isPrimitive() != null) {
                if (componentType == JPrimitiveType.BOOLEAN) {
                    beanValueType = findType(PBooleanArrayValueType.class);
                } else if (componentType == JPrimitiveType.DOUBLE) {
                    beanValueType = findType(PDoubleArrayValueType.class);
                } else if (componentType == JPrimitiveType.FLOAT) {
                    beanValueType = findType(PFloatArrayValueType.class);
                } else if (componentType == JPrimitiveType.INT) {
                    beanValueType = findType(PIntegerArrayValueType.class);
                } else if (componentType == JPrimitiveType.LONG) {
                    beanValueType = findType(PLongArrayValueType.class);
                }
            } else if (componentType.isInterface() != null) { 
                beanValueType = findType(InterfaceArrayValueType.class);

                // We have to generate for isAssignableFrom to work
                requiresGeneration = true;

                // The generic type for the subclass is the component type,
                // rather than the array type
                genericType = componentType.isInterface();
            } else if (componentType instanceof JClassType) {
                beanValueType = findType(ObjectArrayValueType.class);
                constructorTakesEmptyArray = true;
                genericType = (JClassType) componentType;
            } else {
                throw new IllegalStateException(
                    "componentType " + 
                    componentType.getQualifiedSourceName() +
                    " is not a primitive, an interface, or a class"
                );
            }
            
            return;
        }

        final JClassType classType = valueType.isClass();
        if (classType != null) {
            genericType = classType;
           
            if (classType == findType(Integer.class)) {
                beanValueType = findType(IntegerValueType.class);
            } else if (classType == findType(Boolean.class)) {
                beanValueType = findType(BooleanValueType.class);
            } else if (classType == findType(Float.class)) {
                beanValueType = findType(FloatValueType.class);
            } else if (classType == findType(Double.class)) {
                beanValueType = findType(DoubleValueType.class);
            } else if (classType == findType(Long.class)) {
                beanValueType = findType(LongValueType.class);
            } else if (classType == findType(Number.class)) {
                beanValueType = findType(NumberValueType.class);
            } else if (classType == findType(String.class)) {
                beanValueType = findType(StringValueType.class);
            } else if (classType == findType(Date.class)) {
                beanValueType = findType(DateValueType.class);
            } else if (classType.isAssignableTo(findType(JavaScriptObject.class))) {
                beanValueType = findType(JsoValueType.class);
            } else if (classType.isAssignableTo(findType(DataSource.class))) {
                beanValueType = findType(DataSourceBaseValueType.class);
                // Need to generate, in order to get newInstance(JavaScriptObject object)
                requiresGeneration = true;
                hasSetJavaScriptObject = true;
            } else if (classType.isAssignableTo(findType(Canvas.class))) {
                beanValueType = findType(CanvasBaseValueType.class);
                // Need to generate, in order to get newInstance(JavaScriptObject object)
                requiresGeneration = true;
                hasSetJavaScriptObject = true;
            } else if (jsObjConstructor != null) {    
                beanValueType = findType(JsoWrapperValueType.class);
                // Need to generate, in order to get newInstance(JavaScriptObject object)
                requiresGeneration = true;
            } else {
                beanValueType = findType(OtherValueType.class);
            }
            return;
        }

        final JClassType interfaceType = valueType.isInterface();
        if (interfaceType != null) {
            genericType = interfaceType;
            beanValueType = findType(InterfaceValueType.class);

            // Need to generate, because otherwise we can't use instanceof
            requiresGeneration = true;

            return;
        }

        System.out.println("No specific BeanValueType subclass for " + getQualifiedTypeName());
    }

    public String getSimpleTypeName () {
        return valueType.getSimpleSourceName();
    }

    public String getQualifiedTypeName () {
        return valueType.getQualifiedSourceName();
    }

    public String getSimpleFactoryName () {
        if (requiresGeneration) {
            if (valueType instanceof JClassType) {
                StringBuilder builder = new StringBuilder();
                JClassType iterator = (JClassType) valueType;
                while (iterator != null) {
                    if (iterator != valueType) builder.insert(0, "_");
                    builder.insert(0, iterator.getSimpleSourceName());
                    iterator = iterator.getEnclosingType();
                }
                builder.append("ValueType");
                return builder.toString().replace("[]", "Array");
            } else {
                // This can't really happen, but ...
                return (valueType.getSimpleSourceName() + "ValueType").replace("[]", "Array");
            }
        } else {
            return beanValueType.getSimpleSourceName();
        }
    }

    public String getFactoryPackage () {
        if (componentValueType == null) {
            if (valueType instanceof JClassType) {
                String factoryPackage = ((JClassType) valueType).getPackage().getName();
                // Avoid putting things in the "java" namespace
                if (factoryPackage.startsWith("java")) {
                    return "com.smartgwt.client.bean.types." + factoryPackage.replace(".", "_");
                } else {
                    return factoryPackage;
                }
            } else {
                throw new IllegalStateException("No package for valueType");
            }
        } else {
            return componentValueType.getFactoryPackage();
        }
    }

    public String getQualifiedFactoryName () {
        return getFactoryPackage() + "." + getSimpleFactoryName();
    }

    public String getQualifiedGenericName () {
        return genericType.getQualifiedSourceName();
    }

    public String getSimpleGenericName () {
        return genericType.getSimpleSourceName();
    }

    public String getQualifiedValueTypeLiteral () {
        return getQualifiedTypeName() + ".class";
    }

    public String getSimpleValueTypeLiteral () {
        return getSimpleTypeName() + ".class";
    }

    public void writeRegisterValueType (SourceWriter source, TreeLogger logger, GeneratorContext context) {
        source.println(
            // We import all the pre-written BeanValueType classes, but we need to 
            // use the qualified name of ones that we are generating ...
            (requiresGeneration ? getQualifiedFactoryName() : getSimpleFactoryName()) + 
            ".registerValueType(" + 
            // Will take either class literal, empty array, or neither (but not both)
            (constructorTakesClassLiteral ? getQualifiedValueTypeLiteral() : "") +
            // Add the empty array parameter if we are an array ...
            (constructorTakesEmptyArray ? "new " + getQualifiedGenericName().replace("[]", "[0]") + "[0]" : "") +
            ");"
        );

        // If we have a component type, we'll need to make sure to register that as well.
        if (componentValueType != null) {
            componentValueType.writeRegisterValueType(source, logger, context);
        }

        // Make sure we're generated if we are referenced
        if (requiresGeneration) {
            generateFactory(logger, context);            
        }
    }

    public String generateFactory (TreeLogger logger, GeneratorContext context) {
        final String packageName = getFactoryPackage();
        final String factoryName = getSimpleFactoryName(); 
        ClassSourceFileComposerFactory composer = new ClassSourceFileComposerFactory(packageName, factoryName);

        composer.addImport(com.smartgwt.client.bean.BeanValueType.class.getCanonicalName());
        composer.addImport(com.google.gwt.core.client.JavaScriptObject.class.getCanonicalName());
        
        // Import our valueType, but without the [] designation
        composer.addImport(getQualifiedTypeName().replace("[]", ""));
        
        composer.addImport(beanValueType.getQualifiedSourceName());
        composer.setSuperclass(beanValueType.getSimpleSourceName() + "<" + getSimpleGenericName() + ">");

        PrintWriter printWriter = context.tryCreate(logger, packageName, factoryName);
        if (printWriter != null) {        
            SourceWriter source = composer.createSourceWriter(context, printWriter);
             
            source.println("// This class lovingly generated by com.smartgwt.rebind.BeanValueType\n");
            source.println("public static void registerValueType () {");

            source.indent();
            source.println ("// We check first to see if it's already registered, to avoid\n" +
                            "// constructing the singleton over and over again. This will\n" +
                            "// be called multiple times as various BeanFactories initialize\n" +
                            "// themselves.");
            source.println("if (BeanValueType.getBeanValueType(" + getSimpleValueTypeLiteral() + ") == null) {");
            
            source.indent();
            source.println("BeanValueType.registerBeanValueType(new " + getSimpleFactoryName() + "());");
            
            source.outdent();
            source.println("}");
            
            source.outdent();
            source.println("}\n");

            source.println("@Override public Class<" + getSimpleTypeName() + "> getValueType () {");
            source.indent();
            source.println("return " + getSimpleTypeName() + ".class;");
            source.outdent();
            source.println("}\n");

            source.println("@Override public boolean isAssignableFrom (Object value) {");
            source.indent();
            source.println("return value == null || value instanceof " + getSimpleTypeName() + ";");
            source.outdent();
            source.println("}");

            if (componentType != null) {
                source.println(
                    "\nprivate " + 
                    getSimpleTypeName() + 
                    " emptyArray = new " + 
                    componentType.getSimpleSourceName() + 
                    "[0];"
                );
                source.println("\n@Override public " + getSimpleTypeName() + " emptyArray () {");
                source.indent();
                source.println("return emptyArray;");
                source.outdent();
                source.println("}");
            }

            if (scClassName != null) {
                source.println("\n@Override public String getScClassName () {");
                source.indent();
                source.println("return \"" + scClassName + "\";");
                source.outdent();
                source.println("}");
            }

            // Try to write a newInstance function that takes a JavaScriptObject
            if (isAbstract) {
                // If the type is abstract, our only hope is if it has a static getOrCreateRef method
                if (hasGetOrCreateRef) {
                    source.println("\n@Override public " + getSimpleTypeName() + " newInstance (JavaScriptObject jsObject) {");
                    source.indent();
                    source.println("return " + getSimpleTypeName() + ".getOrCreateRef(jsObject);");
                    source.outdent();
                    source.println("}");
                }
            } else {
                if (jsObjConstructor != null) {
                    // If it has the right kind of constructor, then use that
                    source.println("\n@Override public " + getSimpleTypeName() + " newInstance (JavaScriptObject jsObject) {");
                    source.indent();
                    source.println("return new " + getSimpleTypeName() + "(jsObject);");
                    source.outdent();
                    source.println("}");
                } else if (hasSetJavaScriptObject) {
                    // Custom subclasses likely won't have the constructor, but may have a a setJavaScriptObject method
                    source.println("\n@Override public " + getSimpleTypeName() + " newInstance (JavaScriptObject jsObject) {");
                    source.indent();
                    source.println(getSimpleTypeName() + " value = new " + getSimpleTypeName() + "();");
                    source.println("value.setJavaScriptObject(jsObject);");
                    source.println("return value;");
                    source.outdent();
                    source.println("}");
                } else if (hasGetOrCreateRef) {
                    // And may as well fall back to getOrCreateRef if it exists
                    source.println("\n@Override public " + getSimpleTypeName() + " newInstance (JavaScriptObject jsObject) {");
                    source.indent();
                    source.println("return " + getSimpleTypeName() + ".getOrCreateRef(jsObject);");
                    source.outdent();
                    source.println("}");
                }
            }

            source.commit(logger);
        }
        
        return composer.getCreatedClassName();
    }
}
