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

package com.smartgwt.client.bean.types;

import com.smartgwt.client.bean.BeanValueType;
import com.smartgwt.client.bean.BeanValueType.Convertability;
import com.smartgwt.client.util.DateUtil;
import com.smartgwt.client.util.JSOHelper;

import com.google.gwt.core.client.JavaScriptObject;

import java.util.Date;
import java.util.Iterator;
import java.util.Arrays;

public class StringValueType extends BeanValueType<String> {
    public static void registerValueType () { 
        // We check first to see if it's already registered, to avoid
        // constructing the singleton over and over again. This will
        // be called multiple times as various BeanFactories initialize
        // themselves.
        if (BeanValueType.getBeanValueType(String.class) == null) {
            BeanValueType.registerBeanValueType(new StringValueType());
        }
    }

    @Override
    protected Class getValueType () {
        return String.class;
    }
    
    @Override
    protected boolean isAssignableFrom (Object value) {
        return value == null || value instanceof String;
    }

    @Override
    public Convertability convertabilityFrom (Object value) {
        if (value instanceof String) {
            // Indicate a preference if the value is a string ...
            return Convertability.EXACT;
        } else {
            // In principle, everything can be converted to a string ...
            return Convertability.SUPPORTED;
        }
    }

    @Override
    protected Convertability convertabilityToString () {
        // Indicate that we're a preferred converter for strings!
        return Convertability.EXACT;
    }

    // We need to call this because there is code that doesn't deal with
    // String objects well -- sometimes it is assumed that all strings
    // are primitive.
    public native String convertToPrimitiveString (String string) /*-{
        if (typeof string == "string") {
            return string;
        } else if (string == null) {
            return null;
        } else {
            return String(string);
        }
    }-*/;

    @Override
    public String convertFrom (Object value) {
        if (value == null) return null;

        // Instead of the usual discriminator, we can turn things inside-out a little.
        if (value.getClass().isArray()) {
            // If it's an array, then recurse on the elements
            if (value instanceof Object[]) {
                // If it's composed of objects, then it's easy
                StringBuilder builder = new StringBuilder();
                builder.append("[");
                
                Iterator<Object> iter = Arrays.asList((Object[]) value).iterator();
                while (iter.hasNext()) {
                    // Recursively stringify each element
                    builder.append(convertFrom(iter.next()));

                    // Add a comma if we're not done
                    if (iter.hasNext()) builder.append(", ");
                }
                
                builder.append("]");
                return convertToPrimitiveString(builder.toString());
            } else {
                // If it's a primitive array, then we need to tediously type ...
                return convertToPrimitiveString(convertFromPrimitiveArray(value));
            }
        } else if (value instanceof Class) {
            // If the value is a Class object (not an instance), and we want a
            // String, then this is probably a _constructor-like field and we
            // should supply the name of the class.
            return convertToPrimitiveString(((Class) value).getName());
        } else if (value instanceof JavaScriptObject) {
            // If the value is a SmartClient Class object (the Class itself,
            // not an instance), and we want a String, then it's probably a
            // constructor field, so we should provide the name of the class.
            if (JSOHelper.isScClassObject((JavaScriptObject) value)) {
                return convertToPrimitiveString(JSOHelper.getClassName((JavaScriptObject) value));
            }
        }
        
        // If we haven't returned anything yet, then just make use of any
        // doConvertToString methods we may have defined ...
        return convertToPrimitiveString(convertToString(value));
    }

    protected String convertFromPrimitiveArray (Object value) {
        if (value instanceof boolean[]) {
            return convertFromArray((boolean[]) value);
        } else if (value instanceof double[]) {
            return convertFromArray((double[]) value);
        } else if (value instanceof float[]) {
            return convertFromArray((float[]) value);
        } else if (value instanceof int[]) {
            return convertFromArray((int[]) value);
        } else if (value instanceof long[]) {
            return convertFromArray((long[]) value);
        } else {
            // We don't handle the other primitive types yet
            throw new IllegalArgumentException("Arrays of this type are not supported: " + value.getClass().getName());
        }
    }
    
    // These are a little tedious, but it's hard to deal with
    // primitive values generically
    protected String convertFromArray (boolean[] value) {
        String[] stringArray = new String[value.length];
        for (int x = 0; x < value.length; x++) {
            stringArray[x] = String.valueOf(value[x]);
        }
        return convertFrom(stringArray);
    }

    protected String convertFromArray (double[] value) {
        String[] stringArray = new String[value.length];
        for (int x = 0; x < value.length; x++) {
            stringArray[x] = String.valueOf(value[x]);
        }
        return convertFrom(stringArray);
    }

    protected String convertFromArray (float[] value) {
        String[] stringArray = new String[value.length];
        for (int x = 0; x < value.length; x++) {
            stringArray[x] = String.valueOf(value[x]);
        }
        return convertFrom(stringArray);
    }

    protected String convertFromArray (int[] value) {
        String[] stringArray = new String[value.length];
        for (int x = 0; x < value.length; x++) {
            stringArray[x] = String.valueOf(value[x]);
        }
        return convertFrom(stringArray);
    }

    protected String convertFromArray (long[] value) {
        String[] stringArray = new String[value.length];
        for (int x = 0; x < value.length; x++) {
            stringArray[x] = String.valueOf(value[x]);
        }
        return convertFrom(stringArray);
    }
}
