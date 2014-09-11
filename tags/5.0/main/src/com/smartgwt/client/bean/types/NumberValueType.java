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

public class NumberValueType<ValueType extends java.lang.Number>
       extends BeanValueType<ValueType> {

    // Note that this is both a superclass for the numeric types and
    // potentially a type of its own. 
    public static void registerValueType () { 
        // We check first to see if it's already registered, to avoid
        // constructing the singleton over and over again. This will
        // be called multiple times as various BeanFactories initialize
        // themselves.
        if (BeanValueType.getBeanValueType(Number.class) == null) {
            BeanValueType.registerBeanValueType(new NumberValueType<Number>());
        }
    }

    @Override
    protected Class getValueType () {
        return Number.class;
    }

    @Override
    protected boolean isAssignableFrom (Object value) {
        return value == null || value instanceof Number;
    }

    @Override
    public Convertability convertabilityFrom (Object value) {
        if (value instanceof Number) return Convertability.EXACT;
        if (value instanceof String) return Convertability.SUPPORTED;
        if (value instanceof Boolean) return Convertability.SUPPORTED;

        return super.convertabilityFrom(value);
    }

    @Override
    @SuppressWarnings("unchecked")
    public ValueType convertFrom (Object value) {
        if (value instanceof Number) {
            // This is safe, because the type-specific sublcasses deal with it
            // -- we'll only reach it here in the case where we actually want
            // to return a Number -- that is, where ValueType is Number.
            return (ValueType) value;
        } else if (value instanceof String) {
            // Again, safe because subclasses deal with it.
            return (ValueType) convertStringToNumber((String) value);
        } else if (value instanceof Boolean) {
            // We can't return 1 or 0 directly, since they would be Integer
            // and subclasses might need a Long etc. But we can recursively
            // call convertFrom on an Integer.
            return convertFrom((Boolean) value ? 1 : 0);
        } else {
            return super.convertFrom(value);
        }
    }

    public Number convertStringToNumber (String value) {
        // We need to figure out what kind of number to produce, since it would
        // be legal to return any (since this code is reachable only when the
        // caller wants a Number).
        if (value.contains(".")) {
            // We first create the Double, and then convert it to a Float if
            // it is within bounds for a Float. Of course, we can't check for
            // the bounds without creating a number, and the number has to be
            // of the biggest possible type.
            Double doubleValue = Double.valueOf(value);
            if (doubleValue > 0) {
                if (doubleValue < Float.MAX_VALUE && doubleValue > Float.MIN_VALUE) {
                    return doubleValue.floatValue();
                } else {
                    return doubleValue;
                }
            } else {
                if (doubleValue > -Float.MAX_VALUE && doubleValue < -Float.MIN_VALUE) {
                    return doubleValue.floatValue();
                } else {
                    return doubleValue;
                }
            }
        } else {
            // First create a Long, and then convert it to Integer if within
            // bounds for an Integer. Of course, we can't check for
            // the bounds without creating a number, and the number has to be
            // of the biggest possible type.
            Long longValue = Long.valueOf(value);
            if (longValue < Integer.MAX_VALUE && longValue > Integer.MIN_VALUE) {
                return longValue.intValue();
            } else {
                return longValue;
            }
        }
    }
}
