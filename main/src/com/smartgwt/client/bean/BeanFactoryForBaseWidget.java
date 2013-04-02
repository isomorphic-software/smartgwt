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
    // documented, so parsing metadata from the documentation won't help. 
    @Override
    protected void setJavascriptProperty (BeanClass bean, String propertyName, Object value) {
        if (bean.isCreated()) {
            setNativeProperty(bean, propertyName, value);
        } else {
            setNativeAttribute(bean.getConfig(), propertyName, value);
        }
    }

    protected native void setNativeProperty (BeanClass bean, String propertyName, Object value) /*-{
        var widget = bean.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        var wrappedValue = @com.smartgwt.client.bean.BeanValueType::wrapInJavascriptArray(Ljava/lang/Object;)(value);
        widget.setProperty(propertyName, wrappedValue[0]);
    }-*/;

    protected native void setNativeAttribute (JavaScriptObject config, String propertyName, Object value) /*-{
        var wrappedValue = @com.smartgwt.client.bean.BeanValueType::wrapInJavascriptArray(Ljava/lang/Object;)(value);
        config[propertyName] = wrappedValue[0];
    }-*/;
    
    @Override
    protected native Object getJavascriptProperty (BeanClass bean, String property)/*-{
        var prop;

        if (bean.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            var widget = bean.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            prop = widget.getProperty(property);
        } else {
            var config = bean.@com.smartgwt.client.widgets.BaseWidget::config;
            if (config[property] != undefined) {
                prop = config[property];
            } else {
                var scClassName = bean.@com.smartgwt.client.widgets.BaseWidget::scClassName;
                prop = $wnd.isc[scClassName].getInstanceProperty(property);
            }
        }
        
        var sgwtModule = @com.smartgwt.client.bean.BeanFactory::getSGWTModule()();
        return sgwtModule.convertToJava(prop);
    }-*/;

    @SuppressWarnings("unchecked")
    @Override
    public JavaScriptObject doGetOrCreateJsObj (Object bean) {
        // The cast should be fine, as we'll only get here if we've picked
        // the right factory.
        return ((BaseWidget) bean).getOrCreateJsObj();
    }
}
