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
import com.google.gwt.core.client.JsArray;

import com.smartgwt.client.bean.BeanProperty;
import com.smartgwt.client.bean.BeanValueType;

import com.smartgwt.client.core.DataClass;
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.util.JSOHelper;
import com.smartgwt.client.util.SC;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class BeanFactoryForDataClass<BeanClass extends DataClass>
                extends BeanFactory<BeanClass> {

    protected void setJavascriptProperty (BeanClass bean, String propertyName, Object value) {
        bean.setAttribute(propertyName, BeanValueType.convertToJavaScriptObject(value));
    }
    
    protected JavaScriptObject getAttributeAsJavaScriptObject (BeanClass bean, String property) {
        return bean.getAttributeAsJavaScriptObject(property);
    }

    @SuppressWarnings("unchecked")
    public JavaScriptObject doGetOrCreateJsObj (Object bean) {
        // The cast should be fine, as we'll only get here if we've picked
        // the right factory.
        return ((DataClass) bean).getJsObj();
    }
}
