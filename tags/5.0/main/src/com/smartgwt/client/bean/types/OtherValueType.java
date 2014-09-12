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

// Class which deals with arbitrary value types. We take the class literal in
// the constructor so that we can do some reflection at run-time.
public class OtherValueType<ValueType> extends BeanValueType<ValueType> {

    public static <T> void registerOtherValueType (Class<T> klass) { 
        // We check first to see if it's already registered, to avoid
        // constructing the singleton over and over again. This will
        // be called multiple times as various BeanFactories initialize
        // themselves.
        if (BeanValueType.getBeanValueType(klass) == null) {
            BeanValueType.registerBeanValueType(new OtherValueType<T>(klass));
        }
    }

    Class<ValueType> valueType;

    protected OtherValueType (Class<ValueType> valueType) {
        this.valueType = valueType;
    }
    
    @Override
    protected Class getValueType () {
        return valueType;
    }
    
    @Override
    protected boolean isAssignableFrom (Object value) {
        if (value == null) return true;
        
        // Subclasses might do something different, but we'll just compare
        // classes. For ValueTypes which are interfaces, a subclass will need
        // to generate a method, because isAssignableFrom(Class, Class) won't
        // work for them. For non-interfaces, this whould work.
        return isAssignableFrom(valueType, value.getClass());
    }

    @Override
    public Convertability convertabilityFrom (Object value) {
        if (value == null) return Convertability.SUPPORTED;
        if (value.getClass() == valueType) return Convertability.EXACT;
        if (isAssignableFrom(valueType, value)) return Convertability.PREFERRED;
        
        return super.convertabilityFrom(value);
    }

    @Override
    @SuppressWarnings("unchecked")
    public ValueType convertFrom (Object value) {
        if (isAssignableFrom(value)) {
            // The cast should be safe, since isAssignableFrom is the check
            return (ValueType) value;
        } else {
            return super.convertFrom(value);
        }
    }
}
