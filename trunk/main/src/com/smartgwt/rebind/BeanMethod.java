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
import com.google.gwt.core.ext.typeinfo.JEnumType;
import com.google.gwt.core.ext.typeinfo.JClassType;
import com.google.gwt.core.ext.typeinfo.JArrayType;
import com.google.gwt.core.ext.typeinfo.JPrimitiveType;
import com.google.gwt.core.ext.typeinfo.JMethod;
import com.google.gwt.core.ext.typeinfo.TypeOracle;
import com.google.gwt.user.rebind.SourceWriter;

import com.google.gwt.core.client.JavaScriptObject;

import com.smartgwt.rebind.BeanProperty;
import com.smartgwt.client.types.ValueEnum;
import com.smartgwt.client.widgets.BaseWidget;
import com.smartgwt.client.bean.types.*;

import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.HashSet;
import java.util.Set;
import java.util.Arrays;
import java.util.Date;

// We import the run-time value types to fail fast if there are typos
import com.smartgwt.client.bean.types.*;

public class BeanMethod {
    // The method
    private JMethod method;

    // The type we return, or take
    private JType valueType;

    // The class literal for the valueType
    private String classLiteral;

    // The generic type equivalent to the valueType, if the valueType is
    // primitive
    private JType genericType;

    // Are we a setter or a getter?
    private boolean setter = false;
    private boolean getter = false;
 
    // Our name, with get, set or is cut off, and recapitalized
    // But, we keep any As... suffix for now
    private String name;

    // Our prefix ... i.e. "get", "set" or "is"
    private String prefix;

    // A fragment which deboxes for setting primitive values, since
    // we always box the signature.
    private String deboxer = "";

    public JType getValueType () {
        return valueType;
    }

    public JType getGenericType () {
        return genericType;
    }
    
    public boolean isSetter () {
        return setter;
    }
    
    public boolean isGetter () {
        return getter;
    }
    
    public String getName () {
        return name;
    }
    
    public String getPrefix () {
        return prefix;
    }
    
    public JMethod getMethod () {
        return method;
    }
    
    public boolean isPrimitive () {
        return valueType.isPrimitive() != null;
    }

    // Determines whether the method might be a custom getter, considering
    // everything but name
    private boolean couldBeCustomGetter () {
        // We may be able to optimize later in various ways to avoid calling
        // setters or getters that ultimately just set or get a value on the
        // underlying JSO (which is what we will do by default anyway).
        return method.getReturnType() != JPrimitiveType.VOID &&
               method.isPublic() &&
               !method.isAbstract() &&
               !method.isStatic() &&
               method.getParameters().length == 0;
    }

    // Determines whether the method might be a custom setter, considering
    // everything but name
    private boolean couldBeCustomSetter () {
        // We may be able to optimize later in various ways to avoid calling
        // setters or getters that ultimately just set or get a value on the
        // underlying JSO (which is what we will do by default anyway).
        return method.getReturnType() == JPrimitiveType.VOID &&
               method.isPublic() &&
               !method.isAbstract() &&
               !method.isStatic() &&
               method.getParameters().length == 1;
    }

    // We lowercase the first character, unless the second character is
    // uppercase.  This catches cases like ID, or HAlign and VAlign
    private String recapitalize(String propertyName) {
        if (Character.isUpperCase(propertyName.charAt(1))) {
            return propertyName;
        } else {
            return propertyName.substring(0,1).toLowerCase() + propertyName.substring(1);
        }
    }
    
    // Some regexes to use in recognizing getters and setters
    final static Pattern getterPattern = Pattern.compile("^(get|is)([A-Z].*)");
    final static Pattern setterPattern = Pattern.compile("^set([A-Z].*)");

    public BeanMethod (JMethod method, TypeOracle typeOracle) {
        this.method = method;

        if (couldBeCustomSetter()) {
            Matcher matcher = setterPattern.matcher(method.getName());
            if (matcher.matches()) {
                valueType = method.getParameters()[0].getType();
                setter = true;
                name = recapitalize(matcher.group(1));
                prefix = "set";
            }
        } else if (couldBeCustomGetter()) {
            Matcher matcher = getterPattern.matcher(method.getName());
            if (matcher.matches()) {
                valueType = method.getReturnType();
                getter = true;
                prefix = matcher.group(1);
                name = recapitalize(matcher.group(2));
            }
        }

        if (valueType != null) {
            JPrimitiveType primitiveType = valueType.isPrimitive();
            if (primitiveType == null) {
                genericType = valueType;
                classLiteral = valueType.getQualifiedSourceName() + ".class";
            } else {
                if (primitiveType == JPrimitiveType.BOOLEAN) {
                    genericType = typeOracle.findType(Boolean.class.getCanonicalName());
                    classLiteral = boolean.class.getCanonicalName() + ".class";
                    deboxer = ".@" + genericType.getQualifiedSourceName() + "::booleanValue()()";
                } else if (primitiveType == JPrimitiveType.FLOAT) {
                    genericType = typeOracle.findType(Float.class.getCanonicalName());
                    classLiteral = float.class.getCanonicalName() + ".class"; 
                    deboxer = ".@" + genericType.getQualifiedSourceName() + "::floatValue()()";
                } else if (primitiveType == JPrimitiveType.DOUBLE) {
                    genericType = typeOracle.findType(Double.class.getCanonicalName());
                    classLiteral = double.class.getCanonicalName() + ".class"; 
                    deboxer = ".@" + genericType.getQualifiedSourceName() + "::doubleValue()()";
                } else if (primitiveType == JPrimitiveType.INT) {
                    genericType = typeOracle.findType(Integer.class.getCanonicalName());
                    classLiteral = int.class.getCanonicalName() + ".class"; 
                    deboxer = ".@" + genericType.getQualifiedSourceName() + "::intValue()()";
                } else if (primitiveType == JPrimitiveType.LONG) {
                    genericType = typeOracle.findType(Long.class.getCanonicalName());
                    classLiteral = long.class.getCanonicalName() + ".class"; 
                    deboxer = ".@" + genericType.getQualifiedSourceName() + "::longValue()()";
                }
            }
        }
    }

    public String jsniGetter () {
       return "b.@" + method.getEnclosingType().getQualifiedSourceName() +
              "::" + method.getName() + "()()";
    }

    public String box (String basicGetter) {
        if (isPrimitive()) {
            return "@" + genericType.getQualifiedSourceName() + "::new(" +
                   valueType.getJNISignature() + ")(" + basicGetter + ")";
        } else {
            return basicGetter;
        }
    }

    public void writeJSNIFunction (SourceWriter source, boolean addComma) {
        if (isGetter()) {
            source.println("function (b) {return " + box(jsniGetter()) + "}" + (addComma ? "," : ""));
        } else {
            source.println(
                "function (b,v) {b.@" +
                method.getEnclosingType().getQualifiedSourceName() +
                "::" +
                method.getName() +
                "(" + valueType.getJNISignature() + ")" +
                "(v" + deboxer + ")}" + 
                (addComma ? "," : "")
            );
        }
    }

    public void writeNew (SourceWriter source, String beanClassName, Integer getterMethodNumber, Integer setterMethodNumber, boolean addComma) {
        // This should look like this:
        // new BeanMethod<Canvas, Integer>(Integer.class, 27, 35),  
        StringBuilder s = new StringBuilder();

        s.append("new BeanMethod<");
        s.append(beanClassName);
        s.append(", ");
        s.append(genericType.getQualifiedSourceName());
        s.append(">(");
        s.append(classLiteral);
        s.append(", ");
        s.append(getterMethodNumber == null ? "null" : ("methods.get(" + getterMethodNumber.toString() + ")"));
        s.append(", ");
        s.append(setterMethodNumber == null ? "null" : ("methods.get(" + setterMethodNumber.toString() + ")"));
        s.append(")");
        if (addComma) s.append(",");

        source.println(s.toString());
    }
}
