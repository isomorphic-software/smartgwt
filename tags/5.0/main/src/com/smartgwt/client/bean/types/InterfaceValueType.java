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

public abstract class InterfaceValueType<ValueType> extends BeanValueType<ValueType> {
    // Subclasses will be generated, since there isn't any (easy) way to test
    // isAssignableFrom for an interface without instanceof, and instanceof
    // requires the class name, rather than the class object (that is, 
    // you can't use instanceof dynamically at run-time -- it has to have
    // a single value at compile-time).

    @Override
    public Convertability convertabilityFrom (Object value) {
        if (value == null) return Convertability.SUPPORTED;

        // We're testing whether the value implements the interface. If so, we
        // return preferred rather than exact, so that valueTypes which are
        // actually the value's class can win.
        if (isAssignableFrom(value)) return Convertability.PREFERRED;
        
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
