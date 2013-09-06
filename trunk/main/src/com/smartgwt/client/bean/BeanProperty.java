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

// Class that represents a logical property. Each logical property is uniquely
// a combination of a bean class and a property name. 
public abstract class BeanProperty<BeanClass> {    
    // The name of the property. The generator normalizes the name, so that a
    // getter like getHorizontalPadding would become a property name like
    // "horizontalPadding". However, getHPadding would become "HPadding", and
    // getID would become "ID". Also, getWidthAsString becomes "width", so long
    // as there is also a getWidth to be found, and it returns a different
    // type.
    protected String name;

    public BeanProperty (String name) {
        this.name = name;
    }

    public String getName () {
        return name;
    }

    // These are the methods that choose amongst getters and setters. The
    // BeanPropertySingle subclass handles cases where there is no more than
    // one of each, and BeanPropertyMultiple handles cases where we have a
    // choice of two or more.
    protected abstract BeanMethod<BeanClass, ?> defaultGetter ();
    protected abstract BeanMethod<BeanClass, ?> getterForString (); 
    protected abstract BeanMethod<BeanClass, ?> setterForValue (Object value);

    public Object getProperty (BeanClass bean) {
        final BeanMethod<BeanClass, ?> getter = defaultGetter();
        if (getter == null) {
            throw new IllegalStateException("No default getter for " + getNameWithBean(bean));
        }  
        return getter.getProperty(bean);
    }

    public String getPropertyAsString (BeanClass bean) {
        final BeanMethod<BeanClass, ?> getter = getterForString();  
        if (getter == null) {
            throw new IllegalStateException("No string getter for " + getNameWithBean(bean));
        }
        return getter.getPropertyAsString(bean);
    }

    public void setProperty (BeanClass bean, Object value) {
        BeanMethod<BeanClass, ?> setter = setterForValue(value); 
        if (setter == null) {
            throw new IllegalArgumentException(
                "No setter for " + getNameWithBean(bean) + 
                " given value of type " + (value == null ? "null" : value.getClass().getName())
            );
        }
        
        try {
            setter.setProperty(bean, value);
        }
        catch (IllegalArgumentException ex) {
            final String message = "Could not set property " + getNameWithBean(bean) + 
                                   " given value of type " + (value == null ? "null" : value.getClass().getName());
            throw new IllegalArgumentException (message, ex);
        }
    }

    private String getNameWithBean (BeanClass bean) {
        return bean.getClass().getName() + "." + this.getName();
    }    
}
