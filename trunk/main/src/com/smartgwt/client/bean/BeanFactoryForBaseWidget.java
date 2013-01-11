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

import com.smartgwt.client.widgets.BaseWidget;
import com.smartgwt.client.util.JSOHelper;
import com.smartgwt.client.util.SC;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class BeanFactoryForBaseWidget<BeanClass extends BaseWidget>
                extends BeanFactory<BeanClass> {

    // Note that this doesn't check for whether post-create setting of the
    // property is allowed, since we only call this in circumstances where we don't
    // know anything about the property.  But we would know the property if it is
    // documented, so parsing metadata from the documentation won't help. Note that
    // we can't call bean.setAttribute directly, because it is protected
    // in BaseWidget.
    protected void setJavascriptProperty (BeanClass bean, String propertyName, Object value) {
        if (bean.isCreated()) {
            // BaseWidget.setProperty doesn't do any dynamic conversion, so we
            // do that here first.
            bean.setProperty(propertyName, BeanValueType.convertToJavaScriptObject(value));
        } else {
            // Note that setAttribute by itself does less conversion than we'd
            // like, so we do some extra conversion first.
            JSOHelper.setAttribute(bean.getConfig(), propertyName, BeanValueType.convertToJavaScriptObject(value));
        }
    }
    
    // Copied from BaseWidget because it is not public there
    protected native JavaScriptObject getAttributeAsJavaScriptObject(BeanClass bean, String property)/*-{
        var ret;
        if (bean.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            var widget = bean.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            ret = widget.getProperty(property);
        } else {
            var config = bean.@com.smartgwt.client.widgets.BaseWidget::config;
            if (config[property] != undefined) {
                ret = config[property];
            } else {
               var scClassName = bean.@com.smartgwt.client.widgets.BaseWidget::scClassName;
               ret = $wnd.isc[scClassName].getInstanceProperty(property);
            }
        }
        return ret === undefined ? null : ret;
    }-*/;

    @SuppressWarnings("unchecked")
    public JavaScriptObject doGetOrCreateJsObj (Object bean) {
        // The cast should be fine, as we'll only get here if we've picked
        // the right factory.
        return ((BaseWidget) bean).getOrCreateJsObj();
    }
}
