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

package com.smartgwt.client.bean;

import com.smartgwt.client.bean.BeanProperty;
import com.smartgwt.client.bean.BeanMethod;

// This is a subclass of BeanProperty which can be used in cases where
// there is one method type, and it implements only the getter.
public class BeanProperty1Getter<BeanClass> extends BeanProperty<BeanClass> {

    private BeanMethod<BeanClass, ?> method;

    public BeanProperty1Getter (String name, BeanMethod<BeanClass, ?> method) {
        super(name);
        
        this.method = method;
    }

    @Override
    protected BeanMethod<BeanClass, ?> defaultGetter () {
        return method;
    }
    
    @Override
    protected BeanMethod<BeanClass, ?> getterForString () {
        return method;
    }
    
    @Override
    protected BeanMethod<BeanClass, ?> setterForValue (Object value) {
        return null;
    }
}
