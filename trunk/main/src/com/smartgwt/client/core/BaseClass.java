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
import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.Window;
import com.smartgwt.client.types.ValueEnum;
import com.smartgwt.client.util.IDManager;
import com.smartgwt.client.util.JSOHelper;
import com.smartgwt.client.util.ObjectFactory;
import com.smartgwt.client.util.SC;

import java.util.Date;
import java.util.Map;

public abstract class BaseClass {

    protected String id;
    protected JavaScriptObject config = JSOHelper.createObject();
    protected String scClassName;

    public BaseClass() {
        internalSetID(SC.generateID(getClass().getName()), true);
    }

    protected BaseClass(JavaScriptObject jsObj) {
        internalSetID(jsObj);
    }

    /**
     * Return the ID
     *
     * @return the ID
     */
    public String getID() {
        return id;
    }

    // Some BaseClass descendants don't want to register IDs globally, so
    // create an override point here to control that.  For safety, we always
    // want to unregister; it's OK if the object wasn't registered.
    protected void registerID(String id, boolean skipUniqueJSIdentifierCheck) {
        IDManager.registerID(this, id, skipUniqueJSIdentifierCheck);
    }

    protected void internalSetID(JavaScriptObject jsObj) {
        if (this.id != null) {
            IDManager.unregisterID(this, this.id);
        }
        String  id   = JSOHelper.getAttribute         (jsObj,              "ID");
        boolean auto = JSOHelper.getAttributeAsBoolean(jsObj, "_autoAssignedID");
        if (id != null) registerID(id, true);
        this.id = id;
        JSOHelper.setAttribute(config,              "ID",   id);
        JSOHelper.setAttribute(config, "_autoAssignedID", auto);
    }

    protected void internalSetID(String id, boolean autoAssigned) {
        if (this.id != null) {
            IDManager.unregisterID(this, this.id);
        }
        registerID(id, false);
        this.id = id;
        setAttribute("ID",                        id, false);
        setAttribute("_autoAssignedID", autoAssigned, false);
    }

    public void setID(String id) {
        internalSetID(id, false);
    }

    /**
     * Returns the javascript class name.
     * @return
     */
    public String getClassName(){
        return JSOHelper.getClassName(config);
    }

    /**
     * Get the name of the underlying SmartClient class
     *
     * @return the SmartClient class name
     */
    public String getScClassName() {
        return scClassName;
    }

    /**
     * Set the name of the underlying SmartClient class. This is an advanced setting.
     *
     * @param scClassName the SmartClient class
     */
    public void setScClassName(String scClassName) {
        this.scClassName = scClassName;
    }

    public JavaScriptObject getConfig() {
        return config;
    }

    public native boolean isCreated()/*-{
        var id = this.@com.smartgwt.client.core.BaseClass::getID()();
        var obj = $wnd.window[id];
        return id != null && obj != null;
    }-*/;

    public native JavaScriptObject getJsObj()/*-{
        var id = this.@com.smartgwt.client.core.BaseClass::getID()();
        if($wnd.window[id] != null && $wnd.window[id]!== undefined) {
            return $wnd.window[id];
        } else {
            return null;
        }
    }-*/;

    protected JavaScriptObject createJsObj() {
        if (id == null) internalSetID(SC.generateID(getClass().getName()), true);
        JSOHelper.setObjectAttribute(config, SC.REF, this);
        return create();
    }

    public JavaScriptObject getOrCreateJsObj() {
        if (!isCreated()) {
            JavaScriptObject jsObj = createJsObj();
            doInit();
            return jsObj;
        } else {
            return getJsObj();
        }
    }

    public static BaseClass getRef(JavaScriptObject jsObj) {
        return jsObj == null ? null : (BaseClass) JSOHelper.getAttributeAsObject(jsObj, SC.REF);
    }

    /**
     * Returns the existing SGWT component, or creates and returns one if none exist,
     * associated with the supplied {@link com.google.gwt.core.client.JavaScriptObject}.  If
     * the supplied object is not representable as a SGWT component descended from BaseClass,
     * or if this method is not capable of creating the SGWT wrapper, a warning will be logged
     * and null returned.  In the latter case, you must call asSGWTComponent on a more specific
     * class (e.g. {@link com.smartgwt.client.data.ResultSet#asSGWTComponent
     * ResultSet.asSGWTComponent}), or if no such method exists, simply build the wrapper with
     * new, supplying the {@link com.google.gwt.core.client.JavaScriptObject}.
     *
     * @param jsObj SmartClient component whose wrapper is wanted
     *
     * @return wrapping SGWT component (instance of BaseClass-descended class) or null
     */
    public static native <T extends BaseClass> T asSGWTComponent(JavaScriptObject jsObj) /*-{
       if (!$wnd.isc.isAn.Instance(jsObj)) {
           @com.smartgwt.client.util.SC::logWarn(Ljava/lang/String;)("asSGWTComponent(): " +
               "The supplied JS object was not an instance of a SmartClient Class");
           return null;
       }
       return @com.smartgwt.client.core.BaseClass::asSGWTComponentHelper(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(jsObj.getScClassName(),jsObj);
    }-*/;

    private static BaseClass asSGWTComponentHelper(String scClassName, JavaScriptObject jsObj) {
        BaseClass baseClass = null;
        try {
            if ((baseClass = getRef(jsObj)) == null) {
                baseClass = ObjectFactory.createBaseClass(scClassName, jsObj, false);
            }
            if (baseClass == null) SC.logWarn("BaseClass.asSGWTComponent(): unable to wrap " +
                "the supplied JS object of class " + scClassName + "; call a more specific " +
                "version of asSGWTComponent() or, if none exists, call new on the SGWT class.");
        } catch (ClassCastException e) {
            SC.logWarn("BaseClass.asSGWTComponent(): the supplied JS object of class " +
                       scClassName + " cannot be wrapped with a BaseClass-descended class.");
        }
        return baseClass;
    }

	/**
	 * Destroy this object.
	 */
    public native void destroy() /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getJsObj()();
        if (self != null && self.__sgwtDestroy) {
            delete self.__sgwtDestroy;
            if (self.destroy) self.destroy();
        }
        var id = this.@com.smartgwt.client.core.BaseClass::getID()();
        if (id != null) {
            this.@com.smartgwt.client.core.BaseClass::clearID()();
        }
        this.@com.smartgwt.client.core.BaseClass::clearConfigRef()();
    }-*/;

    private void clearID() {
        if (JSOHelper.getAttributeAsBoolean(config, "_autoAssignedID") &&
            getRef(this.config) == null) SC.releaseID(getClass().getName(), this.id);
        IDManager.unregisterID(this, this.id);
        this.id = null;
        JSOHelper.setNullAttribute(config, "ID");
        JSOHelper.setNullAttribute(config, "_autoAssignedID");
    }

    private void clearConfigRef() {
        JSOHelper.setNullAttribute(this.config, SC.REF);
    }

    protected void error(String attribute, String value, boolean allowPostCreate) throws IllegalStateException {
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

    private native void wrapDestroy() /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        if (self && self.__sgwtDestroy == null) self.__sgwtDestroy = function () {
            var jObj = this.__ref;
            if (jObj != null) jObj.@com.smartgwt.client.core.BaseClass::destroy()();
        }
    }-*/;

    protected final native void doInit()/*-{
        this.@com.smartgwt.client.core.BaseClass::wrapDestroy()();
        this.@com.smartgwt.client.core.BaseClass::onInit()();
    }-*/;

    protected void onInit() {}

    // install callbacks for a live SC object
    protected void onBind() {
        wrapDestroy();
    }

    public String getAttribute(String attribute) {
        return getAttributeAsString(attribute);
    }

    public native String getAttributeAsString(String property)/*-{
        var ret;
        if(this.@com.smartgwt.client.core.BaseClass::isCreated()()) {
            var widget = this.@com.smartgwt.client.core.BaseClass::getJsObj()();
            ret = widget.getProperty(property);
        } else {
            var config = this.@com.smartgwt.client.core.BaseClass::config;
            if(config[property] != undefined) {
                ret = config[property];
            } else {
               var scClassName = this.@com.smartgwt.client.core.BaseClass::scClassName;
               ret = $wnd.isc[scClassName].getInstanceProperty(property);
            }
        }
        return ret;
    }-*/;

    public native Date getAttributeAsDate(String property)/*-{
        var ret;
        if(this.@com.smartgwt.client.core.BaseClass::isCreated()()) {
            var widget = this.@com.smartgwt.client.core.BaseClass::getJsObj()();
            ret = widget.getProperty(property);
        } else {
            var config = this.@com.smartgwt.client.core.BaseClass::config;
            if(config[property] != undefined) {
                ret = config[property];
            } else {
               var scClassName = this.@com.smartgwt.client.core.BaseClass::scClassName;
               ret = $wnd.isc[scClassName].getInstanceProperty(property);
            }
        }
        return ret == null ? null : @com.smartgwt.client.util.JSOHelper::toDate(D)(ret.getTime());
    }-*/;

    public native Integer getAttributeAsInt(String property)/*-{
        var ret;
        if(this.@com.smartgwt.client.core.BaseClass::isCreated()()) {
            var widget = this.@com.smartgwt.client.core.BaseClass::getJsObj()();
            ret = widget.getProperty(property);
        } else {
            var config = this.@com.smartgwt.client.core.BaseClass::config;
            if(config[property] != undefined) {
                ret = config[property];
            } else {
               var scClassName = this.@com.smartgwt.client.core.BaseClass::scClassName;
               ret = $wnd.isc[scClassName].getInstanceProperty(property);
            }
        }
        return ret == null ? null : @com.smartgwt.client.util.JSOHelper::toInteger(I)(ret);
    }-*/;

    public native Double getAttributeAsDouble(String property)/*-{
        var ret;
        if(this.@com.smartgwt.client.core.BaseClass::isCreated()()) {
            var widget = this.@com.smartgwt.client.core.BaseClass::getJsObj()();
            ret = widget.getProperty(property);
        } else {
            var config = this.@com.smartgwt.client.core.BaseClass::config;
            if(config[property] != undefined) {
                ret = config[property];
            } else {
               var scClassName = this.@com.smartgwt.client.core.BaseClass::scClassName;
               ret = $wnd.isc[scClassName].getInstanceProperty(property);
            }
        }
        return ret == null ? null : @com.smartgwt.client.util.JSOHelper::toDouble(D)(ret);
    }-*/;

    public native Element getAttributeAsElement(String property)/*-{
        var ret;
        if(this.@com.smartgwt.client.core.BaseClass::isCreated()()) {
            var widget = this.@com.smartgwt.client.core.BaseClass::getJsObj()();
            ret = widget.getProperty(property);
        } else {
            var config = this.@com.smartgwt.client.core.BaseClass::config;
            if(config[property] != undefined) {
                ret = config[property];
            } else {
               var scClassName = this.@com.smartgwt.client.core.BaseClass::scClassName;
               ret = $wnd.isc[scClassName].getInstanceProperty(property);
            }
        }
        return ret;
    }-*/;

    public native JavaScriptObject getAttributeAsJavaScriptObject(String property)/*-{
        var ret;
        if(this.@com.smartgwt.client.core.BaseClass::isCreated()()) {
            var widget = this.@com.smartgwt.client.core.BaseClass::getJsObj()();
            ret = widget.getProperty(property);
        } else {
            var config = this.@com.smartgwt.client.core.BaseClass::config;
            if(config[property] != undefined) {
                ret = config[property];
            } else {
               var scClassName = this.@com.smartgwt.client.core.BaseClass::scClassName;
               ret = $wnd.isc[scClassName].getInstanceProperty(property);
            }
        }
        return ret;
    }-*/;

    public native Float getAttributeAsFloat(String property)/*-{
        var ret;
        if(this.@com.smartgwt.client.core.BaseClass::isCreated()()) {
            var widget = this.@com.smartgwt.client.core.BaseClass::getJsObj()();
            ret = widget.getProperty(property);
        } else {
            var config = this.@com.smartgwt.client.core.BaseClass::config;
            if(config[property] != undefined) {
                ret = config[property];
            } else {
               var scClassName = this.@com.smartgwt.client.core.BaseClass::scClassName;
               ret = $wnd.isc[scClassName].getInstanceProperty(property);
            }
        }
        return ret == null ? null : @com.smartgwt.client.util.JSOHelper::toFloat(F)(ret);
    }-*/;

    public native Boolean getAttributeAsBoolean(String property)/*-{
        var ret;
        if(this.@com.smartgwt.client.core.BaseClass::isCreated()()) {
            var widget = this.@com.smartgwt.client.core.BaseClass::getJsObj()();
            ret = widget.getProperty(property);
        } else {
            var config = this.@com.smartgwt.client.core.BaseClass::config;
            if(config[property] != undefined) {
                ret = config[property];
            } else {
               var scClassName = this.@com.smartgwt.client.core.BaseClass::scClassName;
               ret = $wnd.isc[scClassName].getInstanceProperty(property);
            }
        }
        return ret == null ? null : @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(ret);
    }-*/;

    protected native String[] getAttributeAsStringArray(String property)/*-{
        var ret;
        if(this.@com.smartgwt.client.core.BaseClass::isCreated()()) {
            var widget = this.@com.smartgwt.client.core.BaseClass::getJsObj()();
            ret = widget.getProperty(property);
        } else {
            var config = this.@com.smartgwt.client.core.BaseClass::config;
            if(config[property] != undefined) {
                ret = config[property];
            } else {
               var scClassName = this.@com.smartgwt.client.core.BaseClass::scClassName;
               ret = $wnd.isc[scClassName].getInstanceProperty(property);
            }
        }
        return ret == null ? null : @com.smartgwt.client.util.JSOHelper::convertToJavaStringArray(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

    public Map getAttributeAsMap(String property) {
        return JSOHelper.getAttributeAsMap(getOrCreateJsObj(), property);
    }


    public void setAttribute(String attribute, String value, boolean allowPostCreate) {
        if (!isCreated()) {
            JSOHelper.setAttribute(config, attribute, value);
        } else if (allowPostCreate) {
            setProperty(attribute, value);
        } else {
            error(attribute, value, allowPostCreate);
        }
    }

    public void setAttribute(String attribute, Boolean value, boolean allowPostCreate) {
        if (!isCreated()) {
            JSOHelper.setAttribute(config, attribute, value);
        } else if (allowPostCreate) {
            setProperty(attribute, value);
        } else {
            error(attribute, value.toString(), allowPostCreate);
        }
    }

    public void setAttribute(String attribute, Map value, boolean allowPostCreate) {
        if (!isCreated()) {
            JSOHelper.setAttribute(config, attribute, JSOHelper.convertMapToJavascriptObject(value));
        } else if (allowPostCreate) {
            setProperty(attribute, JSOHelper.convertMapToJavascriptObject(value));
        } else {
            error(attribute, value.toString(), allowPostCreate);
        }
    }

    public void setAttribute(String attribute, int[] value, boolean allowPostCreate) {
        if (!isCreated()) {
            JSOHelper.setAttribute(config, attribute, JSOHelper.convertToJavaScriptArray(value));
        } else if (allowPostCreate) {
            setProperty(attribute, JSOHelper.convertToJavaScriptArray(value));
        } else {
            error(attribute, value.toString(), allowPostCreate);
        }
    }

    public void setAttribute(String attribute, BaseClass[] value, boolean allowPostCreate) {
        if (!isCreated()) {
            JSOHelper.setAttribute(config, attribute, JSOHelper.convertToJavaScriptArray(value));
        } else if (allowPostCreate) {
            setProperty(attribute, JSOHelper.convertToJavaScriptArray(value));
        } else {
            error(attribute, value.toString(), allowPostCreate);
        }
    }

    public void setAttribute(String attribute, DataClass[] value, boolean allowPostCreate) {
        if (!isCreated()) {
            JSOHelper.setAttribute(config, attribute, JSOHelper.convertToJavaScriptArray(value));
        } else if (allowPostCreate) {
            setProperty(attribute, JSOHelper.convertToJavaScriptArray(value));
        } else {
            error(attribute, value.toString(), allowPostCreate);
        }
    }


    public void setAttribute(String attribute, double value, boolean allowPostCreate) {
        if (!isCreated()) {
            JSOHelper.setAttribute(config, attribute, value);
        } else if (allowPostCreate) {
            setProperty(attribute, value);
        } else {
            error(attribute, String.valueOf(value), allowPostCreate);
        }
    }

    public void setAttribute(String attribute, int value, boolean allowPostCreate) {
        if (!isCreated()) {
            JSOHelper.setAttribute(config, attribute, value);
        } else if (allowPostCreate) {
            setProperty(attribute, value);
        } else {
            error(attribute, String.valueOf(value), allowPostCreate);
        }
    }

    public void setAttribute(String attribute, Date value, boolean allowPostCreate) {
        if (!isCreated()) {
            JSOHelper.setAttribute(config, attribute, value);
        } else if (allowPostCreate) {
            setProperty(attribute, JSOHelper.convertToJavaScriptDate(value));
        } else {
            error(attribute, String.valueOf(value), allowPostCreate);
        }
    }

    public void setAttribute(String attribute, ValueEnum[] value, boolean allowPostCreate) {
        if (!isCreated()) {
            JSOHelper.setAttribute(config, attribute, value);
        } else if (allowPostCreate) {
            setProperty(attribute, JSOHelper.convertToJavaScriptArray(value));
        } else {
            error(attribute, String.valueOf(value), allowPostCreate);
        }
    }

    public void setAttribute(String attribute, DataClass value, boolean allowPostCreate) {
        if (!isCreated()) {
            JSOHelper.setAttribute(config, attribute, value.getJsObj());
        } else if (allowPostCreate) {
            setProperty(attribute, value.getJsObj());
        } else {
            error(attribute, String.valueOf(value), allowPostCreate);
        }
    }

    public void setAttribute(String attribute, JavaScriptObject value, boolean allowPostCreate) {
        if (!isCreated()) {
            JSOHelper.setAttribute(config, attribute, value);
        } else if (allowPostCreate) {
            setProperty(attribute, value);
        } else {
            error(attribute, String.valueOf(value), allowPostCreate);
        }
    }

    public void setAttribute(String attribute, String[] value, boolean allowPostCreate) {
        if (!isCreated()) {
            JSOHelper.setAttribute(config, attribute, JSOHelper.convertToJavaScriptArray(value));
        } else if (allowPostCreate) {
            setProperty(attribute, JSOHelper.convertToJavaScriptArray(value));
        } else {
            error(attribute, String.valueOf(value), allowPostCreate);
        }
    }

    protected void setAttribute(String attribute, Float[] value, boolean allowPostCreate) {
        if (!isCreated()) {
            JSOHelper.setAttribute(config, attribute, value);
        } else if (allowPostCreate) {
            setProperty(attribute, JSOHelper.convertToJavaScriptArray(value));
        } else {
            error(attribute, value.toString(), allowPostCreate);
        }
    }

    protected void setAttribute(String attribute, Double[] value, boolean allowPostCreate) {
        if (!isCreated()) {
            JSOHelper.setAttribute(config, attribute, value);
        } else if (allowPostCreate) {
            setProperty(attribute, JSOHelper.convertToJavaScriptArray(value));
        } else {
            error(attribute, value.toString(), allowPostCreate);
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

    public void setAttribute(String attribute, Element value, boolean allowPostCreate) {
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

    //event handling ode
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
