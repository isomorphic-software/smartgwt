/*
 * SmartGWT (GWT for SmartClient)
 * Copyright 2008 and beyond, Isomorphic Software, Inc.
 *
 * SmartGWT is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License version 3
 * as published by the Free Software Foundation.  SmartGWT is also
 * available under typical commercial license terms - see
 * http://smartclient.com/license
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 */

package com.smartgwt.client.core;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.smartgwt.client.types.ValueEnum;
import com.smartgwt.client.util.JSOHelper;
import com.smartgwt.client.widgets.BaseWidget;

import java.util.Date;
import java.util.Map;

public class DataClass extends JsObject {

    public DataClass() {
        super(JSOHelper.createObject());
    }

    public DataClass(JavaScriptObject jsObj) {
        super(jsObj);
    }

    public JavaScriptObject getJsObj() {
        return jsObj;
    }

    public void setAttribute(String property, String value) {
        JSOHelper.setAttribute(jsObj, property, value);
    }

    public String getAttribute(String property) {
        return JSOHelper.getAttribute(jsObj, property);
    }

    public String getAttributeAsString(String property) {
        return JSOHelper.getAttribute(jsObj, property);
    }

    public void setAttribute(String property, int value) {
        JSOHelper.setAttribute(jsObj, property, value);
    }

    public void setAttribute(String property, double value) {
        JSOHelper.setAttribute(jsObj, property, value);
    }

    public Integer getAttributeAsInt(String property) {
        return JSOHelper.getAttributeAsInt(jsObj, property);
    }

    public void setAttribute(String property, boolean value) {
        JSOHelper.setAttribute(jsObj, property, value);
    }

    public Boolean getAttributeAsBoolean(String property) {
        return JSOHelper.getAttributeAsBoolean(jsObj, property);
    }

    public Double getAttributeAsDouble(String property) {
        return JSOHelper.getAttributeAsDouble(jsObj, property);
    }
    
    public double[] getAttributeAsDoubleArray(String property) {
        return JSOHelper.getAttributeAsDoubleArray(jsObj, property);
    }

    public void setAttribute(String property, int[] value) {
        JSOHelper.setAttribute(jsObj, property, value);
    }

    public void setAttribute(String property, DataClass[] value) {
        JSOHelper.setAttribute(jsObj, property, JSOHelper.convertToJavaScriptArray(value));
    }

    public void setAttribute(String property, BaseClass[] value) {
        JSOHelper.setAttribute(jsObj, property, JSOHelper.convertToJavaScriptArray(value));
    }

    public void setAttribute(String property, BaseWidget[] value) {
        JSOHelper.setAttribute(jsObj, property, JSOHelper.convertToJavaScriptArray(value));
    }


    public int[] getAttributeAsIntArray(String property) {
        return JSOHelper.getAttributeAsIntArray(jsObj, property);
    }

    public void setAttribute(String property, String[] value) {
        JSOHelper.setAttribute(jsObj, property, value);
    }

    public String[] getAttributeAsStringArray(String property) {
        return JSOHelper.getAttributeAsStringArray(jsObj, property);
    }

    public void setAttribute(String property, DataClass value) {
        JSOHelper.setAttribute(jsObj, property, value.getJsObj());
    }

    public void setAttribute(String property, BaseClass value) {
        JSOHelper.setAttribute(jsObj, property, value.getOrCreateJsObj());
    }


    public void setAttribute(String property, JavaScriptObject value) {
        JSOHelper.setAttribute(jsObj, property, value);
    }

    public void setAttribute(String property, Date value) {
        JSOHelper.setAttribute(jsObj, property, value);
    }
    
    public void setAttribute(String property, double[] value) {
    	JSOHelper.setAttribute(jsObj, property, value);
    }

    public void setAttribute(String property, Boolean value) {
        JSOHelper.setAttribute(jsObj, property, value);
    }

    public void setAttribute(String property, Map value) {
        JSOHelper.setAttribute(jsObj, property, value);
    }

    public void setAttribute(String property, ValueEnum[] value) {
        JSOHelper.setAttribute(jsObj, property, value);
    }

    public void setAttribute(String property, ValueEnum value) {
        JSOHelper.setAttribute(jsObj, property, value.getValue());
    }

    public void setAttribute(String property, Object value) {
        JSOHelper.setAttribute(jsObj, property, value);
    }

    public void setAttribute(String property, Double value) {
        JSOHelper.setAttribute(jsObj, property, value);
    }

    public void setAttribute(String property, Integer value) {
        JSOHelper.setAttribute(jsObj, property, value);
    }

    public void setAttribute(String property, Float value) {
        JSOHelper.setAttribute(jsObj, property, value);
    }


    public Float getAttributeAsFloat(String property) {
        return JSOHelper.getAttributeAsFloat(jsObj, property);
    }

    public Date getAttributeAsDate(String property) {
        return JSOHelper.getAttributeAsDate(jsObj, property);
    }

    public Object getAttributeAsObject(String property) {
        return JSOHelper.getAttributeAsObject(jsObj, property);
    }

    public Map getAttributeAsMap(String property) {
        return JSOHelper.getAttributeAsMap(jsObj, property);
    }

    public JavaScriptObject getAttributeAsJavaScriptObject(String property) {
        return JSOHelper.getAttributeAsJavaScriptObject(jsObj, property);
    }
    
    public String[] getAttributes() {
        return JSOHelper.getProperties(jsObj);
    }

    //event handling code
    private HandlerManager manager = null;

    public void fireEvent(GwtEvent<?> event) {
        if (manager != null) {
            manager.fireEvent(event);
        }
    }

    protected final <H extends EventHandler> HandlerRegistration doAddHandler(
           final H handler, GwtEvent.Type<H> type) {
        return ensureHandlers().addHandler(type, handler);
    }

    /**
     * Ensures the existence of the handler manager.
     *
     * @return the handler manager
     **/
    HandlerManager ensureHandlers() {
        return manager == null ? manager = new HandlerManager(this)
        : manager;
    }

    HandlerManager getManager() {
        return manager;
    }

    public int getHandlerCount(GwtEvent.Type<?> type) {
        return manager == null? 0 : manager.getHandlerCount(type);
    }
}
