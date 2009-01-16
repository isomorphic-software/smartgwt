/*
 * SmartGWT (GWT for SmartClient)
 * Copyright 2008 and beyond, Isomorphic Software, Inc.
 *
 * SmartGWT is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License version 3
 * as published by the Free Software Foundation.  SmartGWT is also
 * available under typical commercial license terms - see
 * smartclient.com/license.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 */

package com.smartgwt.client.core;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.Window;
import com.smartgwt.client.types.ValueEnum;
import com.smartgwt.client.util.JSOHelper;
import com.smartgwt.client.util.SC;

import java.util.Date;
import java.util.Map;

public abstract class BaseClass {

    protected String id;
    protected JavaScriptObject config = JSOHelper.createObject();

    public BaseClass() {
        id = SC.generateID();
        setAttribute("ID", id, false);
    }

    protected BaseClass(JavaScriptObject jsObj) {
        String nativeID = JSOHelper.getAttribute(jsObj, "ID");
        this.id = nativeID;
    }

    /**
     * Return the ID
     *
     * @return the ID
     */
    public String getID() {
        return id;
    }

    public void setID(String id) {
        this.id = id;
        setAttribute("ID", id, false);
    }

    public JavaScriptObject getConfig() {
        return config;
    }

    public native boolean isCreated()/*-{
        var id = this.@com.smartgwt.client.core.BaseClass::getID()();
        var obj = $wnd.window[id];
        // && $wnd.isc.isA.Canvas(obj) === true
        return id != null && obj != null && obj !== undefined;
    }-*/;

    public native JavaScriptObject getJsObj()/*-{
        var id = this.@com.smartgwt.client.core.BaseClass::getID()();
        if($wnd.window[id] != null && $wnd.window[id]!== undefined) {
            return $wnd.window[id];
        } else {
            return null;
        }
    }-*/;

    public JavaScriptObject getOrCreateJsObj() {
        if (!isCreated()) {
            JavaScriptObject jsObj = create();
            JSOHelper.setAttribute(jsObj, SC.REF, this);
            onInit();            
            return jsObj;
        } else {
            return getJsObj();            
        }
    }

    public static BaseClass getRef(JavaScriptObject jsObj) {
        return jsObj == null ? null : (BaseClass) JSOHelper.getAttributeAsObject(jsObj, SC.REF);
    }
	
	/**
	 * Destroy this object.
	 */
    public native void destroy()/*-{
		var self = this.@com.smartgwt.client.core.BaseClass::getJsObj()();
		self.destroy();
	}-*/;	

    private void error(String attribute, String value, boolean allowPostCreate) throws IllegalStateException {
        if (allowPostCreate) {
            error("Cannot change configuration property '" + attribute + "' to " + value + " after the component has been rendered.");
        } else {
            error("Cannot change configuration property '" + attribute + "' to " + value + " after the component has been created.");
        }
    }

    protected void errorIfNotCreated(String property) throws IllegalStateException {
        if (!isCreated()) {
            throw new IllegalStateException("Cannot access property " + property + " before the component has been created.");
        }
    }

    protected void error(String message) throws IllegalStateException {
        if (!GWT.isScript()) {
            Window.alert("Error :" + message);
            throw new IllegalStateException(message);
        }
    }

    protected abstract JavaScriptObject create();

    protected void onInit() {}


    protected String getAttribute(String attribute) {
        return getAttributeAsString(attribute);
    }

    protected String getAttributeAsString(String attribute) {
        if (isCreated()) {
            return getPropertyAsString(attribute);
        } else {
            return JSOHelper.getAttribute(config, attribute);
        }
    }

    protected Double getAttributeAsDouble(String attribute) {
        if (isCreated()) {
            return getPropertyAsDouble(attribute);
        } else {
            return JSOHelper.getAttributeAsDouble(config, attribute);
        }
    }

    protected Element getAttributeAsElement(String attribute) {
        if (isCreated()) {
            return getPropertyAsElement(attribute);
        } else {
            return JSOHelper.getAttributeAsElement(config, attribute);
        }
    }

    protected JavaScriptObject getAttributeAsJavaScriptObject(String attribute) {
        if (isCreated()) {
            return getPropertyAsJSO(attribute);
        } else {
            return JSOHelper.getAttributeAsJavaScriptObject(config, attribute);
        }
    }

    protected Integer getAttributeAsInt(String attribute) {
        if (isCreated()) {
            return getPropertyAsInt(attribute);
        } else {
            return JSOHelper.getAttributeAsInt(config, attribute);
        }
    }

    protected Float getAttributeAsFloat(String attribute) {
        if (isCreated()) {
            return getPropertyAsFloat(attribute);
        } else {
            return JSOHelper.getAttributeAsFloat(config, attribute);
        }
    }

    protected Boolean getAttributeAsBoolean(String attribute) {
        if (isCreated()) {
            return getPropertyAsBoolean(attribute);
        } else {
            return JSOHelper.getAttributeAsBoolean(config, attribute);
        }
    }
    
    private native String getPropertyAsString(String property)/*-{
        var widget = this.@com.smartgwt.client.core.BaseClass::getJsObj()();
        var ret = widget.getProperty(property);
        return ret === undefined ? null : ret;
    }-*/;

    private native Date getPropertyAsDate(String property)/*-{
        var widget = this.@com.smartgwt.client.core.BaseClass::getJsObj()();
        var ret = widget.getProperty(property);
        return ret == null || ret === undefined ? null : @com.smartgwt.client.util.JSOHelper::toDate(D)(ret.getTime());
    }-*/;

    private native Integer getPropertyAsInt(String property)/*-{
        var widget = this.@com.smartgwt.client.core.BaseClass::getJsObj()();
        var ret = widget.getProperty(property);
        return ret == null || ret === undefined ? null : @com.smartgwt.client.util.JSOHelper::toInteger(I)(ret);
    }-*/;

    private native Double getPropertyAsDouble(String property)/*-{
        var widget = this.@com.smartgwt.client.core.BaseClass::getJsObj()();
        var ret = widget.getProperty(property);
        return ret == null || ret === undefined ? null : @com.smartgwt.client.util.JSOHelper::toDouble(D)(ret);
    }-*/;

    private native Element getPropertyAsElement(String property)/*-{
        var widget = this.@com.smartgwt.client.core.BaseClass::getJsObj()();
        var ret = widget.getProperty(property);
        return ret === undefined ? null : ret;
    }-*/;

    private native JavaScriptObject getPropertyAsJSO(String property)/*-{
        var widget = this.@com.smartgwt.client.core.BaseClass::getJsObj()();
        var ret = widget.getProperty(property);
        return ret === undefined ? null : ret;
    }-*/;

    private native Float getPropertyAsFloat(String property)/*-{
        var widget = this.@com.smartgwt.client.core.BaseClass::getJsObj()();
        var ret = widget.getProperty(property);
        return ret == null || ret === undefined ? null : @com.smartgwt.client.util.JSOHelper::toFloat(F)(ret);
    }-*/;

    private native Boolean getPropertyAsBoolean(String property)/*-{
        var widget = this.@com.smartgwt.client.core.BaseClass::getJsObj()();
        var ret = widget.getProperty(property);
        return ret == null || ret === undefined ? null : @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(ret);
    }-*/;


    protected void setAttribute(String attribute, String value, boolean allowPostCreate) {
        if (!isCreated()) {
            JSOHelper.setAttribute(config, attribute, value);
        } else if (allowPostCreate) {
            setProperty(attribute, value);
        } else {
            error(attribute, value, allowPostCreate);
        }
    }

    protected void setAttribute(String attribute, Boolean value, boolean allowPostCreate) {
        if (!isCreated()) {
            JSOHelper.setAttribute(config, attribute, value);
        } else if (allowPostCreate) {
            setProperty(attribute, value);
        } else {
            error(attribute, value.toString(), allowPostCreate);
        }
    }

    protected void setAttribute(String attribute, Map value, boolean allowPostCreate) {
        if (!isCreated()) {
            JSOHelper.setAttribute(config, attribute, JSOHelper.convertMapToJavascriptObject(value));
        } else if (allowPostCreate) {
            setProperty(attribute, JSOHelper.convertMapToJavascriptObject(value));
        } else {
            error(attribute, value.toString(), allowPostCreate);
        }
    }

    protected void setAttribute(String attribute, int[] value, boolean allowPostCreate) {
        if (!isCreated()) {
            JSOHelper.setAttribute(config, attribute, JSOHelper.convertToJavaScriptArray(value));
        } else if (allowPostCreate) {
            setProperty(attribute, JSOHelper.convertToJavaScriptArray(value));
        } else {
            error(attribute, value.toString(), allowPostCreate);
        }
    }

    protected void setAttribute(String attribute, BaseClass[] value, boolean allowPostCreate) {
        if (!isCreated()) {
            JSOHelper.setAttribute(config, attribute, JSOHelper.convertToJavaScriptArray(value));
        } else if (allowPostCreate) {
            setProperty(attribute, JSOHelper.convertToJavaScriptArray(value));
        } else {
            error(attribute, value.toString(), allowPostCreate);
        }
    }

    protected void setAttribute(String attribute, DataClass[] value, boolean allowPostCreate) {
        if (!isCreated()) {
            JSOHelper.setAttribute(config, attribute, JSOHelper.convertToJavaScriptArray(value));
        } else if (allowPostCreate) {
            setProperty(attribute, JSOHelper.convertToJavaScriptArray(value));
        } else {
            error(attribute, value.toString(), allowPostCreate);
        }
    }


    protected void setAttribute(String attribute, double value, boolean allowPostCreate) {
        if (!isCreated()) {
            JSOHelper.setAttribute(config, attribute, value);
        } else if (allowPostCreate) {
            setProperty(attribute, value);
        } else {
            error(attribute, String.valueOf(value), allowPostCreate);
        }
    }

    protected void setAttribute(String attribute, int value, boolean allowPostCreate) {
        if (!isCreated()) {
            JSOHelper.setAttribute(config, attribute, value);
        } else if (allowPostCreate) {
            setProperty(attribute, value);
        } else {
            error(attribute, String.valueOf(value), allowPostCreate);
        }
    }

    protected void setAttribute(String attribute, Date value, boolean allowPostCreate) {
        if (!isCreated()) {
            JSOHelper.setAttribute(config, attribute, value);
        } else if (allowPostCreate) {
            setProperty(attribute, JSOHelper.convertToJavaScriptDate(value));
        } else {
            error(attribute, String.valueOf(value), allowPostCreate);
        }
    }

    protected void setAttribute(String attribute, ValueEnum[] value, boolean allowPostCreate) {
        if (!isCreated()) {
            JSOHelper.setAttribute(config, attribute, value);
        } else if (allowPostCreate) {
            setProperty(attribute, JSOHelper.convertToJavaScriptArray(value));
        } else {
            error(attribute, String.valueOf(value), allowPostCreate);
        }
    }

    protected void setAttribute(String attribute, DataClass value, boolean allowPostCreate) {
        if (!isCreated()) {
            JSOHelper.setAttribute(config, attribute, value.getJsObj());
        } else if (allowPostCreate) {
            setProperty(attribute, value.getJsObj());
        } else {
            error(attribute, String.valueOf(value), allowPostCreate);
        }
    }

    protected void setAttribute(String attribute, JavaScriptObject value, boolean allowPostCreate) {
        if (!isCreated()) {
            JSOHelper.setAttribute(config, attribute, value);
        } else if (allowPostCreate) {
            setProperty(attribute, value);
        } else {
            error(attribute, String.valueOf(value), allowPostCreate);
        }
    }

    protected void setAttribute(String attribute, String[] value, boolean allowPostCreate) {
        if (!isCreated()) {
            JSOHelper.setAttribute(config, attribute, JSOHelper.convertToJavaScriptArray(value));
        } else if (allowPostCreate) {
            setProperty(attribute, JSOHelper.convertToJavaScriptArray(value));
        } else {
            error(attribute, String.valueOf(value), allowPostCreate);
        }
    }

    protected void setAttribute(String attribute, boolean value, boolean allowPostCreate) {
        if (!isCreated()) {
            JSOHelper.setAttribute(config, attribute, value);
        } else if (allowPostCreate) {
            setProperty(attribute, value);
        } else {
            error(attribute, String.valueOf(value), allowPostCreate);
        }
    }

    protected void setAttribute(String attribute, Element value, boolean allowPostCreate) {
        if (!isCreated()) {
            JSOHelper.setAttribute(config, attribute, value);
        } else if (allowPostCreate) {
            setProperty(attribute, value);
        } else {
            error(attribute, String.valueOf(value), allowPostCreate);
        }
    }

    public native void setProperty(String property, String value)/*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getJsObj()();
        self.setProperty(property, value);
    }-*/;

    public native void setProperty(String property, boolean value)/*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getJsObj()();
        self.setProperty(property, value);
    }-*/;

    public native void setProperty(String property, double value)/*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getJsObj()();
        self.setProperty(property, value);
    }-*/;

    public native void setProperty(String property, JavaScriptObject value)/*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getJsObj()();
        self.setProperty(property, value);
    }-*/;
}
