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
import java.lang.Enum;

public class EnumValueType<ValueType extends Enum<ValueType>>
       extends OtherValueType<ValueType> {
    
    public static <T extends Enum<T>> void registerValueType (Class<T> klass) { 
        // We check first to see if it's already registered, to avoid
        // constructing the singleton over and over again. This will
        // be called multiple times as various BeanFactories initialize
        // themselves.
        if (BeanValueType.getBeanValueType(klass) == null) {
            BeanValueType.registerBeanValueType(new EnumValueType<T>(klass));
        }
    }

    protected EnumValueType (Class<ValueType> valueType) {
        super(valueType);
    }
    
    @Override
    public Convertability convertabilityFrom (Object value) {
        if (value instanceof String) return Convertability.SUPPORTED;

        // The superclass will check whether we are of a correct enum type
        return super.convertabilityFrom(value);
    }

    @Override
    public ValueType convertFrom (Object value) {
        if (value instanceof String) {
            // "-" isn't legal in an enum, so replace it with "_"
            String noDashes = ((String) value).replace("-", "_");
            try {
                // By convention, enums are in all-caps
                return Enum.valueOf(valueType, noDashes.toUpperCase());
            }
            catch (IllegalArgumentException e) {
                // But we may as well try the lowercase version if that doesn't work
                return Enum.valueOf(valueType, noDashes);
            }
        } else {
            // The superclass will deal with the case where the value is
            // the correct subclass of Enum
            return super.convertFrom(value);
        }
    }
 
    @Override
    protected String doConvertToString (ValueType value) {
        return value == null ? null : value.name();
    }
}
