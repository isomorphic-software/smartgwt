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
import com.smartgwt.client.types.ValueEnum;
import java.lang.Enum;

public class ValueEnumValueType<ValueType extends Enum<ValueType> & ValueEnum> 
       extends EnumValueType<ValueType> {

    @SuppressWarnings("unchecked")
    // Should be safe because the generated code will use the appropriate class
    public static void registerValueType (Class klass) { 
        // We check first to see if it's already registered, to avoid
        // constructing the singleton over and over again. This will
        // be called multiple times as various BeanFactories initialize
        // themselves.
        if (BeanValueType.getBeanValueType(klass) == null) {
            BeanValueType.registerBeanValueType(new ValueEnumValueType(klass));
        }
    }

    protected ValueEnumValueType (Class<ValueType> valueType) {
        super(valueType);
    }

    // The only difference between ValueEnum and Enum for our purposes is that
    // ValueEnum has getValue()
    
    @Override
    protected String doConvertToString (ValueType value) {
        return value == null ? null : value.getValue();
    }
}
