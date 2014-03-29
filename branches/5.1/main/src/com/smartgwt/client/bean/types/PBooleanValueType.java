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
import com.smartgwt.client.bean.types.BooleanValueType;
import com.smartgwt.client.bean.BeanValueType;

public class PBooleanValueType extends BooleanValueType {
    public static void registerValueType () { 
        // We check first to see if it's already registered, to avoid
        // constructing the singleton over and over again. This will
        // be called multiple times as various BeanFactories initialize
        // themselves.
        if (BeanValueType.getBeanValueType(boolean.class) == null) {
            BeanValueType.registerBeanValueType(new PBooleanValueType());
        }
    }

    @Override
    protected Class getValueType () {
        return boolean.class;
    }

    @Override
    protected Boolean nullValue () {
        return false;
    }     
}
