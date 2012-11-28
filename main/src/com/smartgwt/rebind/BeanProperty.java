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

import com.google.gwt.core.ext.TreeLogger;
import com.google.gwt.core.ext.UnableToCompleteException;
import com.google.gwt.core.ext.typeinfo.JClassType;
import com.google.gwt.core.ext.typeinfo.JMethod;
import com.google.gwt.core.ext.typeinfo.JPrimitiveType;
import com.google.gwt.core.ext.typeinfo.JType;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.rebind.SourceWriter;

import java.util.*;

/**
 * Class that captures a bean property name and accessor metadata.
 */
public class BeanProperty implements Comparable {
    private JMethod setter;
    private JMethod getter;
    private String name;
    public static TreeLogger logger;

    private static Set<String> excludedProperties = new HashSet<String>();

    static {
        excludedProperties.add("ID");
    }

    public BeanProperty(String capitalizedName, JMethod getter, JMethod setter) {
        this.name = recapitalize(capitalizedName);
        this.getter = getter;
        this.setter = setter;
    }

    public String getName() {
        return name;
    }

    public JMethod getGetter() {
        return getter;
    }

    public JMethod getSetter() {
        return setter;
    }

    public JType getValueType() {
        return getter.getReturnType();
    }

    public JClassType getEnclosingType() {
        return getter.getEnclosingType();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BeanProperty that = (BeanProperty) o;
        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    public int compareTo(Object o) {
        if (o instanceof BeanProperty) {
            return this.name.compareTo(((BeanProperty) o).getName());
        }
        return -1;
    }

    private static String recapitalize(String capitalized) {
        StringBuffer buffer = new StringBuffer(capitalized);
        char first = buffer.charAt(0);
        char recap = Character.isUpperCase(first) ? Character.toLowerCase(first) : Character.toUpperCase(first);
        buffer.setCharAt(0, Character.toLowerCase(recap));
        return buffer.toString();
    }

    private static boolean isSupportedType(JMethod getter) {
        JType type = getter.getReturnType();
        if (!getter.isAbstract() && !getter.isStatic()) {
            if (type.getSimpleSourceName().equals("String")) {
                return true;
            } else if (type.getSimpleSourceName().equals("int")) {
                return true;
            } else if (type.getSimpleSourceName().equals("byte")) {
                return true;
            } else if (type.getSimpleSourceName().equals("short")) {
                return true;
            } else if (type.getSimpleSourceName().equals("long")) {
                return true;
            } else if (type.getSimpleSourceName().equals("float")) {
                return true;
            } else if (type.getSimpleSourceName().equals("double")) {
                return true;
            } else if (type.getSimpleSourceName().equals("boolean")) {
                return true;
            } else if (type.getSimpleSourceName().equals("char")) {
                return true;
            } else if (type.getSimpleSourceName().equals("Integer")) {
                return true;
            } else if (type.getQualifiedSourceName().equals("java.math.BigInteger")) {
                return true;
            } else if (type.getSimpleSourceName().equals("Byte")) {
                return true;
            } else if (type.getSimpleSourceName().equals("Short")) {
                return true;
            } else if (type.getSimpleSourceName().equals("Long")) {
                return true;
            } else if (type.getSimpleSourceName().equals("Float")) {
                return true;
            } else if (type.getSimpleSourceName().equals("Double")) {
                return true;
            } else if (type.getQualifiedSourceName().equals("java.math.BigDecimal")) {
                return true;
            } else if (type.getSimpleSourceName().equals("Boolean")) {
                return true;
            } else if (type.getSimpleSourceName().equals("Character")) {
                return true;
            } else if (type.getSimpleSourceName().equals("Date")) {
                return true;
            } else if (type.isEnum() != null) {
                return true;
            } else {
                BeanProperty.logger.log(TreeLogger.INFO, "Unhandled type'" + type.getQualifiedSourceName(), new Exception());
                return false;
            }
        } else {
            return false;
        }
    }

    public JType getType() {
        return getter.getReturnType();
    }

    /**
     * Methods that returns all the BeanProperty values for a given class.
     *
     * @param logger the logger
     * @param cls    the class
     * @return a set of BeanProperty values of the class
     */
    public static Set<BeanProperty> getProperties(TreeLogger logger, JClassType cls) {
        BeanProperty.logger = logger;

        Set<BeanProperty> properties = new TreeSet<BeanProperty>();
        List<JMethod> methodsList = new ArrayList<JMethod>();
        methodsList.addAll(Arrays.asList(cls.getMethods()));
        JClassType langObject = cls.getOracle().getJavaLangObject();
        JClassType clazz = cls;
        while (true) {
            clazz = clazz.getSuperclass();
            if (clazz == null || clazz.equals(langObject) || clazz.getQualifiedSourceName().equals(Widget.class.getName()))
                break;
            JMethod[] clsMethods = clazz.getMethods();
            methodsList.addAll(Arrays.asList(clsMethods));
        }

        for (JMethod getter : methodsList) {
            String getterName = getter.getName();
            if ((getterName.startsWith("get") || getterName.startsWith("is")) &&
                    getter.getParameters().length == 0 && getter.isPublic() &&
                    !getter.isAbstract() &&
                    !getter.isStatic() && isSupportedType(getter)) {
                JType type = getter.getReturnType();

                String capitalizedName = null;
                if (getterName.startsWith("is")) {
                    if (type.getSimpleSourceName().equals("boolean") || type.getSimpleSourceName().equals("Boolean")) {
                        capitalizedName = getterName.substring(2);
                    } else {
                        continue;
                    }
                } else {
                    capitalizedName = getterName.substring(3);
                }
                if (excludedProperties.contains(capitalizedName.toUpperCase())) {
                    continue;
                }

                String setterName = "set" + capitalizedName;
                JMethod setter = findMethod(cls, setterName, type);
                if (setter != null && setter.getReturnType().equals(JPrimitiveType.VOID)
                        && setter.isPublic() &&
                        !setter.isAbstract() &&
                        !setter.isStatic()) {
                    properties.add(new BeanProperty(capitalizedName, getter, setter));
                }
            }
        }
        return properties;
    }


    public static JMethod findMethod(JClassType cls, String setterName, JType type) {
        JClassType langObject = cls.getOracle().getJavaLangObject();
        while (true) {
            JMethod setter = cls.findMethod(setterName, new JType[]{type});
            if (setter != null) {
                return setter;
            } else {
                JClassType superClass = cls.getSuperclass();
                if (superClass == null || superClass.equals(langObject)) {
                    return null;
                } else {
                    cls = superClass;
                }
            }
        }
    }

    public void writeAttributeGetter(List getterPrefixes, SourceWriter source) throws UnableToCompleteException {
        String dotProperty = getDotProperty(getterPrefixes);
        source.println("if (attr.equals(\""
                + dotProperty
                + "\")) {");
        source.indent();

        if (getterPrefixes.size() > 0) {
            String nullCheck = getNotNullCheck(getterPrefixes);
            source.println("if(" + nullCheck + ") {");
            source.println("return " + convertToString(getType(), getGetterProperty(getterPrefixes)) + ";");
            source.println("} else {");
            source.println("return null;");
            source.println("}");
        } else {
            source.println("return " + convertToString(getType(), getGetterProperty(getterPrefixes)) + ";");
        }

        source.outdent();
        source.print("} else ");
    }

    private String getDotProperty(List getterPrefixes) {
        String getterName = getter.getName();
        String capitalized = getterName.startsWith("get") ? getterName.substring(3) : getterName.substring(2);
        String property = recapitalize(capitalized);

        String prefixProperty = "";

        for (int i = getterPrefixes.size() - 1; i >= 0; i--) {
            JMethod jMethod = (JMethod) getterPrefixes.get(i);
            String gName = jMethod.getName();
            String prop = gName.startsWith("get") ? gName.substring(3) : gName.substring(2);
            prefixProperty = recapitalize(prop) + "." + prefixProperty;
        }
        return prefixProperty + property;
    }

    private String getGetterProperty(List getterPrefixes) {
        String getterProperty = getter.getName();
        String prefixProperty = "";
        for (int i = getterPrefixes.size() - 1; i >= 0; i--) {
            JMethod jMethod = (JMethod) getterPrefixes.get(i);
            prefixProperty = jMethod.getName() + "()." + prefixProperty;
        }
        return prefixProperty + getterProperty + "()";
    }

    private String getSetterProperty(List getterPrefixes) {
        String getterProperty = setter.getName();
        String prefixProperty = "";
        for (int i = getterPrefixes.size() - 1; i >= 0; i--) {
            JMethod jMethod = (JMethod) getterPrefixes.get(i);
            prefixProperty = jMethod.getName() + "()." + prefixProperty;
        }
        return prefixProperty + getterProperty;
    }

    private static String convertToString(JType type, String value) throws UnableToCompleteException {
        if (type.getSimpleSourceName().equals("String")) {
            return value;
        } else if (type.getSimpleSourceName().equals("int")) {
            return "Integer.toString(" + value + ")";
        } else if (type.getSimpleSourceName().equals("byte")) {
            return "Byte.toString(" + value + ")";
        } else if (type.getSimpleSourceName().equals("short")) {
            return "Short.toString(" + value + ")";
        } else if (type.getSimpleSourceName().equals("long")) {
            return "Long.toString(" + value + ")";
        } else if (type.getSimpleSourceName().equals("float")) {
            return "Float.toString(" + value + ")";
        } else if (type.getSimpleSourceName().equals("double")) {
            return "Double.toString(" + value + ")";
        } else if (type.getSimpleSourceName().equals("boolean")) {
            return "Boolean.toString(" + value + ")";
        } else if (type.getSimpleSourceName().equals("char")) {
            return "Character.toString(" + value + ")";
        } else if (type.getSimpleSourceName().equals("Integer")) {
            return value + " == null ? null : " + value + ".toString()";
        } else if (type.getQualifiedSourceName().equals("java.math.BigInteger")) {
            return value + " == null ? null : " + "Integer.toString(" + value + ".intValue())";
        } else if (type.getSimpleSourceName().equals("Byte")) {
            return value + " == null ? null : " + value + ".toString()";
        } else if (type.getSimpleSourceName().equals("Short")) {
            return value + " == null ? null : " + value + ".toString()";
        } else if (type.getSimpleSourceName().equals("Long")) {
            return value + " == null ? null : " + value + ".toString()";
        } else if (type.getSimpleSourceName().equals("Float")) {
            return value + " == null ? null : " + value + ".toString()";
        } else if (type.getSimpleSourceName().equals("Double")) {
            return value + " == null ? null : " + value + ".toString()";
        } else if (type.getQualifiedSourceName().equals("java.math.BigDecimal")) {
            return value + " == null ? null : " + "Double.toString(" + value + ".doubleValue())";
        } else if (type.getSimpleSourceName().equals("Boolean")) {
            return value + " == null ? null : " + value + ".toString()";
        } else if (type.getSimpleSourceName().equals("Character")) {
            return value + " == null ? null : " + value + ".toString()";
        } else if (type.getSimpleSourceName().equals("Date")) {
            return value + " == null ? null : " + "null";// "dateFormat.format(" + value + ")";
        } else if (type.isEnum() != null) {
            return value + " == null ? null : " + value + ".getValue()";
        } else {
            BeanProperty.logger.log(TreeLogger.ERROR, "Unhandled type'" + type.getQualifiedSourceName() + "' for value " + value, new Exception());
            return value + " == null ? null : " + value + ".toString().toString()";
            //throw new UnableToCompleteException();
        }
    }

    public void writeAttributeSetter(List getterPrefixes, SourceWriter source) throws UnableToCompleteException {
        String dotProperty = getDotProperty(getterPrefixes);
        source.println("if (attr.equals(\""
                + dotProperty
                + "\")) {");
        source.indent();
        if (getterPrefixes.size() > 0) {
            String nullCheck = getNotNullCheck(getterPrefixes);
            source.println("if(" + nullCheck + ") {");
            source.println(getSetterProperty(getterPrefixes) + "(" + convertFromString(getType(), "value") + ");");
            source.println("} else {");
            source.println(" throw new NullPointerException(\"Nested property " + dotProperty + " cannot be set as it references a null object\");");
            source.println("}");
        } else {
            source.println(getSetterProperty(getterPrefixes) + "(" + convertFromString(getType(), "value") + ");");
        }
        source.outdent();
        source.print("} else ");
    }

    private String getNotNullCheck(List getterPrefixes) {
        List notNullList = getNotNullCriteriaList(new ArrayList(getterPrefixes), new ArrayList());
        String criteria = null;
        for (int i = 0; i < notNullList.size(); i++) {
            List getters = (List) notNullList.get(i);
            String subCriteria = null;
            for (int j = 0; j < getters.size(); j++) {
                JMethod getter = (JMethod) getters.get(j);
                if (subCriteria == null) {
                    subCriteria = getter.getName() + "()";
                } else {
                    subCriteria = subCriteria + "." + getter.getName() + "()";
                }
            }
            subCriteria = subCriteria + " != null";
            criteria = (criteria == null) ? subCriteria : (criteria + " && " + subCriteria);
        }
        return criteria;
    }

    private List getNotNullCriteriaList(List getterPrefixes, List prefixList) {
        if (getterPrefixes.size() == 0) {
            return prefixList;
        } else {
            JMethod getter = (JMethod) getterPrefixes.remove(0);
            if (prefixList.size() > 0) {
                List prevList = (List) prefixList.get(prefixList.size() - 1);
                ArrayList list = new ArrayList(prevList);
                list.add(getter);
                prefixList.add(list);
            } else {
                ArrayList list = new ArrayList();
                list.add(getter);
                prefixList.add(list);
            }
            return getNotNullCriteriaList(getterPrefixes, prefixList);
        }
    }

    private static String convertFromString(JType type, String value) throws UnableToCompleteException {
        if (type.getSimpleSourceName().equals("String")) {
            return value;
        } else if (type.getSimpleSourceName().equals("int")) {
            return "(" + value + "== null || value.equals(\"\")) ? 0 : Integer.parseInt(" + value + ")";
        } else if (type.getSimpleSourceName().equals("byte")) {
            return "(" + value + "== null || value.equals(\"\")) ? 0 : Byte.parseByte(" + value + ")";
        } else if (type.getSimpleSourceName().equals("short")) {
            return "(" + value + "== null || value.equals(\"\")) ? 0 : Short.parseShort(" + value + ")";
        } else if (type.getSimpleSourceName().equals("long")) {
            return "(" + value + "== null || value.equals(\"\")) ? 0 : Long.parseLong(" + value + ")";
        } else if (type.getSimpleSourceName().equals("float")) {
            return "(" + value + "== null || value.equals(\"\")) ? 0 : Float.parseFloat(" + value + ")";
        } else if (type.getSimpleSourceName().equals("double")) {
            return "(" + value + "== null || value.equals(\"\")) ? 0 : Double.parseDouble(" + value + ")";
        } else if (type.getSimpleSourceName().equals("boolean")) {
            return "((" + value + " != null) && " + value + ".equalsIgnoreCase(\"true\"))";
        } else if (type.getSimpleSourceName().equals("char")) {
            return "(" + value + "== null || value.equals(\"\")) ? 0 : " + value + ".charAt(0)";
        } else if (type.getSimpleSourceName().equals("Integer")) {
            return value + " ==null || " + value + ".equals(\"\") ? null: new Integer(Integer.parseInt(" + value + "))";
        } else if (type.getQualifiedSourceName().equals("java.math.BigInteger")) {
            return value + " ==null || " + value + ".equals(\"\") ? null: new java.math.BigInteger(" + value + ")";
        } else if (type.getSimpleSourceName().equals("Byte")) {
            return value + " ==null || " + value + ".equals(\"\") ? null: new Byte(Byte.parseByte(" + value + "))";
        } else if (type.getSimpleSourceName().equals("Short")) {
            return value + " ==null || " + value + ".equals(\"\") ? null: new Short(Short.parseShort(" + value + "))";
        } else if (type.getSimpleSourceName().equals("Long")) {
            return value + " ==null || " + value + ".equals(\"\") ? null: new Long(Long.parseLong(" + value + "))";
        } else if (type.getSimpleSourceName().equals("Float")) {
            return value + " ==null || " + value + ".equals(\"\") ? null: new Float(Float.parseFloat(" + value + "))";
        } else if (type.getSimpleSourceName().equals("Double")) {
            return value + " ==null || " + value + ".equals(\"\") ? null: new Double(Double.parseDouble(" + value + "))";
        } else if (type.getQualifiedSourceName().equals("java.math.BigDecimal")) {
            return value + " ==null || " + value + ".equals(\"\") ? null: new java.math.BigDecimal(Double.parseDouble(" + value + "))";
        } else if (type.getSimpleSourceName().equals("Boolean")) {
            return value + " ==null || " + value + ".equals(\"\") ? null: new Boolean(((" + value + " != null) && " + value + ".equalsIgnoreCase(\"true\")))";
        } else if (type.getSimpleSourceName().equals("Character")) {
            return value + " ==null || " + value + ".equals(\"\") ? null: new Character(" + value + ".charAt(0))";
        } else if (type.getSimpleSourceName().equals("Date")) {
            return value + " ==null || " + value + ".equals(\"\") ? null: new java.util.Date(" + value + ")";
        } else if (type.isEnum() != null) {
            return value + " ==null || " + value + ".equals(\"\") ? null: com.smartgwt.client.util.EnumUtil.getEnum(" + type.getQualifiedSourceName() + ".values(), " + value + ")";
        } else {
            BeanProperty.logger.log(TreeLogger.ERROR, "Unhandled type'" + type.getQualifiedSourceName() + "' for value " + value, new Exception());
            throw new UnableToCompleteException();
        }
    }

    private static String getFeildDef(JType type, String property) throws UnableToCompleteException {
        String sourceName = type.getSimpleSourceName();
        String qualifiedSourceName = type.getQualifiedSourceName();

        if (sourceName.equals("String") || sourceName.equals("char") || sourceName.equals("Character") /*|| type.isEnum() != null*/) {
            return "new Property(\"" + property + "\", " + qualifiedSourceName + ".class)";
        } else if (sourceName.equals("int") || sourceName.equals("byte") || sourceName.equals("long") || sourceName.equals("short") ||
                sourceName.equals("Integer") || sourceName.equals("Byte") || sourceName.equals("Long") || sourceName.equals("Short")) {
            return "new Property(\"" + property + "\", " + qualifiedSourceName + ".class)";
        } else if (sourceName.equals("float") || sourceName.equals("Float") || sourceName.equals("double") || sourceName.equals("Double")) {
            return "new Property(\"" + property + "\", " + qualifiedSourceName + ".class)";
        } else if (sourceName.equals("boolean") || sourceName.equals("Boolean")) {
            return "new Property(\"" + property + "\", " + qualifiedSourceName + ".class)";
        } else if (sourceName.equals("Date")) {
            return "new Property(\"" + property + "\", " + qualifiedSourceName + ".class)";
        } else if (type.isEnum() != null) {
            return "new Property(\"" + property + "\", " + qualifiedSourceName + ".class)";
        } else {
            BeanProperty.logger.log(TreeLogger.ERROR, "Unhandled type'" + type.getQualifiedSourceName() + "' for property " + property, new Exception());
            throw new UnableToCompleteException();
        }
    }

    public void writeFieldDef(ArrayList getterPrefixes, SourceWriter source) throws UnableToCompleteException {
        String dotProperty = getDotProperty(getterPrefixes);
        source.println(getFeildDef(getType(), dotProperty));
    }

    public void writeAccessor(SourceWriter source) {
        source.println(getter.getReadableDeclaration() + " {");
        source.indent();
        source.println("return bean." + getter.getName() + "();");
        source.outdent();
        source.println("}");

        if (setter != null) {
            source.println();

            source.println(setter.getReadableDeclaration() + " {");
            source.indent();
            source.println("bean." + setter.getName() + "(" + setter.getParameters()[0].getName() + ");");
            source.outdent();
            source.println("}");
        }
    }

    public static void writeAttributeGetters(SourceWriter source, Set<BeanProperty> properties) throws UnableToCompleteException {
        writeAttributeGetters(new ArrayList(), source, properties);
        source.println("{");
        source.indent();
        source.println("throw new IllegalArgumentException(\"Invalid attribute \" + attr);");
        source.outdent();
        source.println("}");
    }

    public static void writeAttributeGetters(List getterPrefixes, SourceWriter source, Set<BeanProperty> properties) throws UnableToCompleteException {
        for (BeanProperty beanProperty : properties) {
            beanProperty.writeAttributeGetter(getterPrefixes, source);
        }
    }

    public static void writeAttributeSetters(SourceWriter source, Set<BeanProperty> properties) throws UnableToCompleteException {
        writeAttributeSetters(new ArrayList(), source, properties);
        source.println("{");
        source.println("String msg = \"Invalid or read-only attribute \" + attr + \" with value \" + value;");
        source.println("GWT.log(msg, new Exception());");
        source.println("}");
    }

    public static void writeAttributeSetters(List getterPrefixes, SourceWriter source, Set<BeanProperty> properties) throws UnableToCompleteException {
        for (BeanProperty beanProperty : properties) {
            if (beanProperty.getSetter() != null) {
                beanProperty.writeAttributeSetter(getterPrefixes, source);
            }
        }
    }

    public static void writeRecordDefs(SourceWriter source, Set<BeanProperty> properties) throws UnableToCompleteException {
        writeRecordDefs(new ArrayList(), source, properties);
    }

    private static void writeRecordDefs(ArrayList getterPrefixes, SourceWriter source, Set<BeanProperty> properties) throws UnableToCompleteException {
        int i = 0;
        for (BeanProperty beanProperty : properties) {
            source.indent();
            beanProperty.writeFieldDef(getterPrefixes, source);
            if (i != properties.size() - 1) {
                source.print(",");
            }
            source.outdent();
            i++;
        }
    }
}
