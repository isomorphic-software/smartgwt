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

import com.smartgwt.rebind.BeanMethod;
import com.google.gwt.core.ext.typeinfo.JClassType;
import com.google.gwt.core.ext.typeinfo.JType;
import com.google.gwt.core.ext.typeinfo.JPrimitiveType;
import com.google.gwt.core.ext.typeinfo.TypeOracle;
import com.google.gwt.user.rebind.SourceWriter;

import com.smartgwt.rebind.BeanClass;

import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Iterator;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class BeanProperty { 
    private final String name;
    private final String nameWithoutOverload;
    private final LinkedList<BeanMethod> getters;
    private final LinkedList<BeanMethod> setters;
    private final BeanClass beanClass;

    private final static Pattern checkOverloadedName = Pattern.compile("^(.*)As[A-Z].*$");
   
    public BeanProperty (String name, BeanClass beanClass) {
        this.name = name;
        this.beanClass = beanClass;
            
        Matcher matcher = checkOverloadedName.matcher(name);
        if (matcher.matches()) {
            nameWithoutOverload = matcher.group(1);
        } else {
            nameWithoutOverload = name;
        }

        getters = new LinkedList<BeanMethod>();
        setters = new LinkedList<BeanMethod>();
    }

    public String getName () {
        return name;
    }

    public String getNameWithBeanClass () {
        return beanClass.getSimpleBeanClassName() + "." + name;
    }

    public String getNameWithoutOverload () {
        return nameWithoutOverload;
    }

    // Checks whether this might be a "get...As..." property (e.g.
    // getWidthAsString), without looking for the main property.
    public boolean getMaybeOverloadedGetter () {
        // An overloaded getter property would have one getter and no setters,
        // since the convention would be to write the overloaded setter on the
        // main property, not the "As..." property.
        if (getters.size() != 1 || setters.size() != 0) return false;

        // An overloaded getter would have a different overloaded name.
        // Note that we can use object identity here.
        if (name == nameWithoutOverload) return false;

        // In principle, the As... part should be a reference to the return
        // type of the getter (e.g. AsString). But that won't necessarily be
        // true, so we don't check it.
        return true;
    }

    public BeanMethod firstGetter () {
        if (getters.size() == 0) {
            return null;
        } else {
            return getters.get(0);
        }
    }

    public void addMethod (BeanMethod method) {
        if (method == null) {
            return;
        } else if (method.isGetter()) {
            addGetter(method);
        } else if (method.isSetter()) {
            addSetter(method);
        }
    }

    public void addGetter (BeanMethod method) {
        if (method == null || !method.isGetter()) return;

        // If there is already a getter with the same type, we reject the
        // new getter, unless the current one is an "is..." and the new one
        // is a "get..." (e.g.  isEnabled vs. getEnabled). In those cases,
        // the "get" version generally reflects the property of this
        // particular object, whereas the "is" version reflects more
        // dynamic factors, such as the containment hierarchy.
        //
        // With that exception, we prefer current getters with the same
        // type to new ones. Thus, as we merge methods from superclasses,
        // we will prefer the subclass method unless the superclass method
        // has a different type. (Which would only occur, for getters, in
        // the "get...As..." case.)
        //
        // We use the genericType so that boolean and Boolean will be
        // equal (etc.)
        BeanMethod existingGetter = getterForGenericType(method.getGenericType());
        if (existingGetter != null) {
            if (existingGetter.getPrefix().equals("is")) {
                // If the existingGetter is an "is..." then remove it
                // and fall through to add the new one.
                getters.remove(existingGetter);
                beanClass.removeMethod(existingGetter);
            } else {
                // Otherwise, we prefer the existing getter, so we
                // return and don't add the new one.
                return;
            }
        }

        // Actually add the getter, both here and in the global list for the BeanClass
        getters.addLast(method);
        beanClass.addMethod(method);
    }

    public void addSetter (BeanMethod method) {
        if (method == null || !method.isSetter()) return;

        // For setters, we always prefer existing setters if the signature type is the same.
        BeanMethod existingSetter = setterForGenericType(method.getGenericType());
        if (existingSetter == null) {
            setters.addLast(method);
            beanClass.addMethod(method);
        }
    }

    // Finds the getter with the specified signature type (where the signature
    // type equates boolean and Boolean etc.
    public BeanMethod getterForGenericType (JType type) {
        for (BeanMethod getter : getters) {
            if (getter.getGenericType() == type) return getter;
        }
        return null;
    }

    // Finds the setter with the specified signature type (where the signature
    // type equates boolean and Boolean etc.
    public BeanMethod setterForGenericType (JType type) {
        for (BeanMethod setter : setters) {
            if (setter.getGenericType() == type) return setter;
        }
        return null;
    }

    // Copy methods from another property into this property.  Note that
    // addMethod will check for duplicate types and reject duplicates. Thus,
    // methods already on the property will be preferred to methods merged from
    // elsewhere (superclasses or alternate types).
    public void mergeProperty (BeanProperty otherProperty) {
        for (BeanMethod method : otherProperty.getters) {
            addMethod(method);
        }

        for (BeanMethod method : otherProperty.setters) {
            addMethod(method);
        }
    }

    public void writeConstructor (SourceWriter source, boolean addComma) {
        if (getters.size() == 0 && setters.size() == 0) {
            source.println("// Skipping because there are no getters and no setters: " + getName());
            return;
        }

        if (
            getters.size() == 1 && 
            setters.size() == 1 && 
            setters.get(0).getValueType() == getters.get(0).getValueType()
        ) {
            writeSingleConstructor(source, "BeanProperty1Getter1Setter", getters.get(0), setters.get(0), addComma);
        } else if (getters.size() == 1 && setters.size() == 0) {
            writeSingleConstructor(source, "BeanProperty1Getter", getters.get(0), null, addComma);
        } else if (setters.size() == 1 && getters.size() == 0) {
            writeSingleConstructor(source, "BeanProperty1Setter", null, setters.get(0), addComma);
        } else {
            writeMultipleConstructor(source, addComma);
        }
    }

    private int getMethodIndex (BeanMethod method) {
        return beanClass.indexOfMethod(method);
    }

    // This is called when there is at most one getter and one setter, and they
    // have the same type.  Thus, it will be the usual case.
    public void writeSingleConstructor (SourceWriter source, String propertyType, BeanMethod getter, BeanMethod setter, boolean addComma) {
        final String beanClassName = beanClass.getSimpleBeanClassName();
 
        source.println("new " + propertyType + "<" + beanClassName + "> (\"" + getName() + "\",");
        source.indent();
        
        if (getter != null && setter != null) {
            getter.writeNew(source, beanClassName, getMethodIndex(getter), getMethodIndex(setter), false);
        } else if (getter != null) {
            getter.writeNew(source, beanClassName, getMethodIndex(getter), null, false);
        } else if (setter != null) {
            setter.writeNew(source, beanClassName, null, getMethodIndex(setter), false);
        }

        source.outdent();
        source.println(")" + (addComma ? "," : ""));
    }

    public void writeMultipleConstructor (SourceWriter source, boolean addComma) {
        final String beanClassName = beanClass.getSimpleBeanClassName();
        
        source.println("new BeanPropertyMultiple<" + beanClassName + "> (\"" + getName() + "\",");
        source.indent();

        if (getters.size() == 0) {
            source.println("null, // no getters");
        } else {
            source.println("new BeanMethod[] {");
            source.indent();

            Iterator<BeanMethod> iterator = getters.iterator();
            while (iterator.hasNext()) {
                BeanMethod getter = iterator.next();
                getter.writeNew(source, beanClassName, getMethodIndex(getter), null, iterator.hasNext());
            }
            
            source.outdent();
            source.println("},");
        }

        if (setters.size() == 0) {
            source.println("null // no setters");
        } else {
            source.println("new BeanMethod[] {");
            source.indent();
            
            Iterator<BeanMethod> iterator = setters.iterator();
            while (iterator.hasNext()) {
                BeanMethod setter = iterator.next();
                setter.writeNew(source, beanClassName, null, getMethodIndex(setter), iterator.hasNext());
            }
            
            source.outdent();
            source.println("}");
        }

        source.outdent();
        source.println(")" + (addComma ? "," : ""));
    }
}
