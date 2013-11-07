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

import com.smartgwt.client.bean.types.NumberValueType;
import com.smartgwt.client.bean.BeanValueType.Convertability;
import com.smartgwt.client.bean.BeanValueType;

public class LongValueType extends NumberValueType<Long> {
    public static void registerValueType () { 
        // We check first to see if it's already registered, to avoid
        // constructing the singleton over and over again. This will
        // be called multiple times as various BeanFactories initialize
        // themselves.
        if (BeanValueType.getBeanValueType(Long.class) == null) {
            BeanValueType.registerBeanValueType(new LongValueType());
        }
        
        // Register the primitive type as well, since we can't do that via
        // an interface.
        PLongValueType.registerValueType();
    }

    @Override
    protected Class getValueType () {
        return Long.class;
    }

    @Override
    protected boolean isAssignableFrom (Object value) {
        return value == null || value instanceof Long;
    }

    @Override
    public Convertability convertabilityFrom (Object value) {
        if (value instanceof Long) return Convertability.EXACT;
        if (value instanceof String) return Convertability.SUPPORTED;
        if (value instanceof Number) return Convertability.PREFERRED;

        return super.convertabilityFrom(value);
    }

    @Override
    public Long convertFrom (Object value) {
        if (value instanceof Number) {
            return ((Number) value).longValue();
        } else if (value instanceof String) {
            return Long.valueOf((String) value);
        } else {
            return super.convertFrom(value);
        }
    }
}
