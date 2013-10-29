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

import com.google.gwt.core.client.JavaScriptObject;
import com.smartgwt.client.bean.BeanValueType;

// Deals with ValueTypes that literally take JavaScriptObjects as parameters
// (as opposed to JsoWrapperValueType, which deals with ValueTypes that
// can be constructed via JavaScriptObjects).
public class JsoValueType<ValueType extends JavaScriptObject> extends OtherValueType<ValueType> {

    public static <T extends JavaScriptObject> void registerJsoValueType (Class<T> klass) { 
        // We check first to see if it's already registered, to avoid
        // constructing the singleton over and over again. This will
        // be called multiple times as various BeanFactories initialize
        // themselves.
        if (BeanValueType.getBeanValueType(klass) == null) {
            BeanValueType.registerBeanValueType(new JsoValueType<T>(klass));
        }
    }

    protected JsoValueType (Class<ValueType> valueType) {
        super(valueType);
    }

    @Override
    public Convertability convertabilityFrom (Object value) {
        if (value instanceof JavaScriptObject) {
            // If it's actually a JavaScriptObject, then it needs to be typed
            // correctly, which is what the superclass will check
            return super.convertabilityFrom(value);
        } else {
            // If it's not a JavaScriptObject, then actually anything can
            // be converted to a JavaScriptObject.
            return Convertability.SUPPORTED;
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public ValueType convertFrom (Object value) {
        if (value instanceof JavaScriptObject) {
            // If it's actually a JavaScriptObject, then the superclass will
            // check whether it's typed correctly.
            return super.convertFrom(value);
        } else {
            // If not, then we can theoretically convert anything to a
            // JavaScriptObject. Though, the methods may be expecting a
            // particular kind of JavaScriptObject ... we may need to check.
            return (ValueType) convertToJavaScriptObject(value);
        }
    }
}
