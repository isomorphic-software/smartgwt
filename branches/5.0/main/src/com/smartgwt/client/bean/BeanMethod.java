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

import com.google.gwt.core.client.JavaScriptObject;
import com.smartgwt.client.bean.BeanValueType.Convertability;
import com.smartgwt.client.types.ValueEnum;
import java.util.Date;
import java.util.Map;


// Class that represents a BeanProperty's getter and/or setter with the same type
// (that is, return type or parameter type).
//
// Many properties will have just one BeanMethod, but some will have more than
// one if they implement multiple getters (get...As...) or multiple
// (overloaded) setters.
public class BeanMethod<BeanClass, ValueType> {
    // Note that for methods that take primitive types, we use the wrapper type
    // as the ValueType, since you can't use primitive types as generic types.
    //
    // For getting and setting the property, the generated JSNI function for
    // primitive types takes care of boxing and unboxing.

    // We call our methods via JSNI function pointers. The main alternative
    // would be to generate callback-style functions via anonymous subclasses.
    // That works, but increases code-size by about one-third.
    private JavaScriptObject getter;
    private JavaScriptObject setter;

    // The beanValueType represents the type of our parameter -- it handles
    // conversions.
    private BeanValueType beanValueType;

    public BeanMethod (Class<?> valueType, JavaScriptObject getter, JavaScriptObject setter) {
        this.beanValueType = BeanValueType.getBeanValueType(valueType);
        this.getter = getter;
        this.setter = setter;
    }

    protected Convertability convertabilityFrom (Object value) {
        return beanValueType.convertabilityFrom(value);
    }

    protected Convertability convertabilityToString () {
        return beanValueType.convertabilityToString();
    }

    protected native ValueType getPropertyFromBean (BeanClass bean) /*-{
        return this.@com.smartgwt.client.bean.BeanMethod::getter.call(this, bean);
    }-*/;

    protected native void setPropertyOnBean (BeanClass bean, ValueType value) /*-{
        this.@com.smartgwt.client.bean.BeanMethod::setter.call(this, bean, value);
    }-*/;

    protected Object getProperty (BeanClass bean) {
        return getPropertyFromBean(bean);
    }

    protected String getPropertyAsString (BeanClass bean) {
        return beanValueType.convertToString(getPropertyFromBean(bean));
    }   

    @SuppressWarnings("unchecked")
    protected void setProperty (BeanClass bean, Object value) {
        // The cast should be safe, because we'll only get here with the
        // correct kind of BeanValueType
        setPropertyOnBean(bean, (ValueType) beanValueType.convertFrom(value));
    } 
}

