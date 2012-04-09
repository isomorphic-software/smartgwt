package com.smartgwt.rebind;

import com.google.gwt.core.ext.Generator;
import com.google.gwt.core.ext.GeneratorContext;
import com.google.gwt.core.ext.TreeLogger;
import com.google.gwt.core.ext.UnableToCompleteException;
import com.google.gwt.core.ext.typeinfo.JClassType;
import com.google.gwt.core.ext.typeinfo.NotFoundException;
import com.google.gwt.core.ext.typeinfo.TypeOracle;
import com.google.gwt.user.rebind.ClassSourceFileComposerFactory;
import com.google.gwt.user.rebind.SourceWriter;

import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Set;

/**
 * Generator that allows reflection like capabilities to get and set Canvas property types in GWT applications. It aslo
 * makes sure that the class in question is automatically registered with the {@link com.smartgwt.client.bean.CanvasRegistry}.
 */
public class PropertyHelperGenerator extends Generator {

    public String generate(TreeLogger logger, GeneratorContext context, String typeName) throws UnableToCompleteException {

        TypeOracle typeOracle = context.getTypeOracle();
        JClassType classType;
        try {
            classType = typeOracle.getType(typeName);
        } catch (NotFoundException e) {
            logger.log(TreeLogger.ERROR, "Cannot find typeName '" + typeName + "'", e);
            throw new UnableToCompleteException();
        }
        SourceWriter source = getSourceWriter(logger, context, classType);
        final String qualifiedClassName = classType.getParameterizedQualifiedSourceName();
        String className = qualifiedClassName + "PropertyHelper";

        if (source == null) {
            return className;
        } else {
            writeBeanAccessor(classType, source);

            Set<BeanProperty> properties = BeanProperty.getProperties(logger, classType);
            String simpleAdapterClassName = classType.getSimpleSourceName() + "PropertyHelper";
            writeConstructor(qualifiedClassName, simpleAdapterClassName, source);
            writeAccessors(source, properties);
            writeAttributeGetters(classType, source, properties);
            writeAttributeSetters(classType, source, properties);
            writeRecordDef(source, properties);
            source.println();
            source.outdent();
            source.println("}");

            source.commit(logger);
            return className;
        }
    }

    private void writeConstructor(String className, String adapterClassName, SourceWriter source) {
        source.println("public " + adapterClassName + "() {");
        source.indent();
        source.println("CanvasRegistry.register(" + className + ".class, this);");
        source.outdent();
        source.println("}");
        source.println();
    }

    private void writeBeanAccessor(JClassType classType, SourceWriter source) {
        String simpleName = classType.getSimpleSourceName();
        source.indent();
        source.println("private " + simpleName + " bean;");
        source.println();
        source.println("private void setBean(Object bean) {");
        source.indent();
        source.println("this.bean = (" + simpleName + ") bean;");
        source.outdent();
        source.println("}");
        source.println();
        source.println("private Object getBean() {");
        source.indent();
        source.println("return this.bean;");
        source.outdent();
        source.println("}");
        source.println();
    }

    private void writeAccessors(SourceWriter source, Set<BeanProperty> properties) {
        for (Iterator<BeanProperty> beanPropertyIterator = properties.iterator(); beanPropertyIterator.hasNext(); ) {
            BeanProperty beanProperty = beanPropertyIterator.next();
            beanProperty.writeAccessor(source);
        }
    }

    private void writeAttributeSetters(JClassType classType, SourceWriter source, Set<BeanProperty> properties) throws UnableToCompleteException {
        source.println("public void setProperty(Object bean, String attr, String value) {");
        source.indent();
        String simpleName = classType.getSimpleSourceName();
        source.println("setBean((" + simpleName + ") bean);");
        BeanProperty.writeAttributeSetters(source, properties);
        source.outdent();
        source.println("}");
    }

    private void writeAttributeGetters(JClassType classType, SourceWriter source, Set<BeanProperty> properties) throws UnableToCompleteException {
        source.println("public String getProperty(Object bean, String attr) {");
        source.indent();
        String simpleName = classType.getSimpleSourceName();
        source.println("setBean((" + simpleName + ") bean);");
        BeanProperty.writeAttributeGetters(source, properties);
        source.outdent();
        source.println("}");
        source.println();
    }

    private void writeRecordDef(SourceWriter source, Set<BeanProperty> properties) throws UnableToCompleteException {
        source.println("public Property[] getProperties() {");
        source.indent();
        source.println("return new Property[] {");

        BeanProperty.writeRecordDefs(source, properties);

        source.println("};");
        source.println("}");

        source.println("public String[] getPropertyNames() {");
        source.indent();
        source.println("Property[] properties = getProperties();");
        source.println("String propertyNames[] = new String[properties.length];");
        source.println("for(int i =0;i<properties.length;i++) {");
        source.indent();
        source.println("propertyNames[i] = properties[i].getName();");
        source.println("}");
        source.println("return propertyNames;");
        source.outdent();
    }

    public SourceWriter getSourceWriter(TreeLogger logger, GeneratorContext context, JClassType classType) {
        String packageName = classType.getPackage().getName();
        String simpleName = classType.getSimpleSourceName() + "PropertyHelper";
        ClassSourceFileComposerFactory composer = new ClassSourceFileComposerFactory(packageName, simpleName);
        composer.addImplementedInterface("com.smartgwt.client.bean.PropertyHelper");
        composer.addImport("com.smartgwt.client.data.*");
        composer.addImport("com.smartgwt.client.bean.*");
        composer.addImport("java.util.ArrayList");
        composer.addImport("java.util.List");
        composer.addImport("com.google.gwt.core.client.GWT");

        PrintWriter printWriter = context.tryCreate(logger, packageName,
                simpleName);
        if (printWriter == null) {
            return null;
        } else {
            return composer.createSourceWriter(context, printWriter);
        }
    }
}
