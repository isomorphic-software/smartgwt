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

package com.smartgwt.client.widgets;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.shared.*;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import com.smartgwt.client.core.BaseClass;
import com.smartgwt.client.core.DataClass;
import com.smartgwt.client.core.Function;
import com.smartgwt.client.types.Positioning;
import com.smartgwt.client.types.ValueEnum;
import com.smartgwt.client.util.DOMUtil;
import com.smartgwt.client.util.JSOHelper;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.events.DrawEvent;
import com.smartgwt.client.widgets.events.DrawHandler;

import java.util.Date;
import java.util.Map;

public abstract class BaseWidget extends Widget implements HasHandlers {

    private Function onRenderFn;

    static {
        init();
    }

    private static native void init()/*-{
        $wnd.isc.setAutoDraw(false);
    }-*/;

    protected String id;
    protected JavaScriptObject config = JSOHelper.createObject();
    protected boolean isElementSet = false;

    protected boolean configOnly;

    //event handling code
    //can be removed when GWT issue http://code.google.com/p/google-web-toolkit/issues/detail?id=3378
    //is fixed
    private HandlerManager manager;

    public void fireEvent(GwtEvent<?> event) {
        if (manager != null) {
            manager.fireEvent(event);
        }
    }

    /**
     * Adds this handler to the widget.
     *
     * @param <H>     the type of handler to add
     * @param type    the event type
     * @param handler the handler
     * @return {@link HandlerRegistration} used to remove the handler
     */
    protected final <H extends EventHandler> HandlerRegistration doAddHandler(
            final H handler, GwtEvent.Type<H> type) {
        return ensureHandlers().addHandler(type, handler);
    }

    /**
     * Ensures the existence of the handler manager.
     *
     * @return the handler manager
     */
    HandlerManager ensureHandlers() {
        return manager == null ? manager = new HandlerManager(this)
                : manager;
    }

    HandlerManager getManager() {
        return manager;
    }

    public int getHandlerCount(GwtEvent.Type<?> type) {
        return manager == null ? 0 : manager.getHandlerCount(type);
    }

    public BaseWidget() {
        id = SC.generateID();
        setAttribute("ID", id, false);
    }

    protected BaseWidget(JavaScriptObject jsObj) {
        id = JSOHelper.getAttribute(jsObj, "ID");
    }

    public BaseWidget(String id) {
        this.id = id;
        setAttribute("ID", id, false);
    }

    public static BaseWidget getRef(JavaScriptObject jsObj) {
        return jsObj == null ? null : (BaseWidget) JSOHelper.getAttributeAsObject(jsObj, SC.REF);
    }

    protected void setElement(Element elem) {
        super.setElement(elem);
        isElementSet = true;
    }

    protected final native void doInit()/*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.__setDragTracker = self.setDragTracker;
        self.setDragTracker = function() {
            var jObj = this.__ref;
            return jObj.@com.smartgwt.client.widgets.BaseWidget::setDragTracker()();
        };

        self.__getInnerHTML = self.getInnerHTML;
        self.getInnerHTML = function() {
            var jObj = this.__ref;
            return jObj.@com.smartgwt.client.widgets.BaseWidget::getInnerHTML()();
        };

        self.__draw = self.draw;
        self.draw = function() {
            var jObj = this.__ref;
            //jObj.@com.smartgwt.client.widgets.BaseWidget::draw()();
            this.__draw();
            jObj.@com.smartgwt.client.widgets.BaseWidget::rendered()();
        };

        self.__destroy = self.destroy;
        self.destroy = function() {
            var jObj = this.__ref;
            jObj.@com.smartgwt.client.widgets.BaseWidget::destroy()();
        };

        this.@com.smartgwt.client.widgets.BaseWidget::onInit()();
    }-*/;

    protected void onInit() {

    }

    public boolean isConfigOnly() {
        return configOnly;
    }

    public void setConfigOnly(boolean configOnly) {
        this.configOnly = configOnly;
    }

    protected native boolean setDragTracker() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        return !!self.__setDragTracker();
    }-*/;

    /**
     * Return the inner HTML for this canvas. Called when the canvas is drawn or redrawn;
     * override to customize.
     * <p>
     * <b>Note</b> : {@link Canvas#setRedrawOnResize} should be set to true for components whose inner HTML
     * will not automatically reflow to fit the component's new size.
     *
     * @return HTML contents of this canvas
     */
    public native String getInnerHTML() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        return self.__getInnerHTML();
    }-*/;

    /**
     * Draws the widget on the page.&#010
     */
    public native void draw() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.draw();
    }-*/;

    public native void destroy() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.__destroy();
        this.@com.smartgwt.client.widgets.Canvas::onDestroy()();
    }-*/;

    public void doOnRender(Function function) {
        onRenderFn = function;
    }

    private void rendered() {
        onDraw();
        fireEvent(new DrawEvent(getID()));
        if (onRenderFn != null) {
            onRenderFn.execute();
        }
    }

    public HandlerRegistration addDrawHandler(DrawHandler handler) {
        return doAddHandler(handler, DrawEvent.getType());
    }

    protected void onDraw() {

    }

    protected void onDestroy() {

    }

    public Element getElement() {
        return getElement(true);
    }

    public Element getElement(boolean allowPreRender) {

        if (!isElementSet) {
            JavaScriptObject jsObj = getJsObj();
            if (!allowPreRender) {
                error("This method should only be called after the component has been rendered");
            }

            if (jsObj == null) {
                getOrCreateJsObj();
            }

            Element wrapperDiv = DOM.createDiv();
            DOMUtil.setID(wrapperDiv, getID() + "_wrapper");
            //the wrapper div must be attached to the dom, or else this widgets children don't get
            //a handle to this widgets dom element (via getHandle()). For example if this self is a
            // HLayout and containts a Canvas and IButton child member.
            RootPanel.getBodyElement().appendChild(wrapperDiv);

            Canvas self = ((Canvas) this);
            //need to set properties before calling clear else the properties are not set on the jsObj (it ends up on the config)
            setProperty("position", Positioning.RELATIVE.getValue());
            setProperty("redrawOnResize", true);
            setProperty("htmlElement", wrapperDiv);
            self.clear();
            self.draw();
            setElement(wrapperDiv);
            return wrapperDiv;

        }
        return super.getElement();
    }

    public void setPosition(String position) {
        setAttribute("position", position, false);
    }

    public void setHtmlElement(Element element) {
        setAttribute("htmlElement", element, false);
    }

    public native Element getDOM()/*-{
        var widget = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        return widget.getHandle();
    }-*/;


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

    public void setConfig(JavaScriptObject config) {
        this.config = config;
    }

    public native boolean isCreated()/*-{
        var id = this.@com.smartgwt.client.widgets.BaseWidget::getID()();
        var obj = $wnd.window[id];
        return id != null && obj != null && obj !== undefined && $wnd.isc.isA.Canvas(obj) === true;
    }-*/;

    protected Boolean isDrawn() {
        return isCreated() && doIsDrawn();
    }

    private native boolean doIsDrawn()/*-{
        var widget = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        return widget.isDrawn();
    }-*/;

    public native JavaScriptObject getJsObj()/*-{
        var id = this.@com.smartgwt.client.widgets.BaseWidget::getID()();
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
            return jsObj;
        } else {
            return getJsObj();
        }
    }

    protected native JavaScriptObject create()/*-{
        var config = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        return $wnd.isc.Canvas.create(config);
    }-*/;

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

    protected Date getAttributeAsDate(String attribute) {
        if (isCreated()) {
            return getPropertyAsDate(attribute);
        } else {
            return JSOHelper.getAttributeAsDate(config, attribute);
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
        var widget = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        var ret = widget.getProperty(property);
        return ret === undefined ? null : String(ret) ;
    }-*/;

    private native Date getPropertyAsDate(String property)/*-{
        var widget = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        var ret = widget.getProperty(property);
        return ret == null || ret === undefined ? null : @com.smartgwt.client.util.JSOHelper::toDate(D)(ret.getTime());
    }-*/;

    private native Integer getPropertyAsInt(String property)/*-{
        var widget = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        var ret = widget.getProperty(property);
        return ret == null || ret === undefined ? null : @com.smartgwt.client.util.JSOHelper::toInteger(I)(ret);
    }-*/;

    private native Double getPropertyAsDouble(String property)/*-{
        var widget = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        var ret = widget.getProperty(property);
        return ret == null || ret === undefined ? null : @com.smartgwt.client.util.JSOHelper::toDouble(D)(ret);
    }-*/;

    private native Element getPropertyAsElement(String property)/*-{
        var widget = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        var ret = widget.getProperty(property);
        return ret === undefined ? null : ret;
    }-*/;

    private native JavaScriptObject getPropertyAsJSO(String property)/*-{
        var widget = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        var ret = widget.getProperty(property);
        return ret === undefined ? null : ret;
    }-*/;

    private native Float getPropertyAsFloat(String property)/*-{
        var widget = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        var ret = widget.getProperty(property);
        return ret == null || ret === undefined ? null : @com.smartgwt.client.util.JSOHelper::toFloat(F)(ret);
    }-*/;

    private native Boolean getPropertyAsBoolean(String property)/*-{
        var widget = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        var ret = widget.getProperty(property);
        return ret == null || ret === undefined ? null : @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(ret);
    }-*/;

    private void error(String attribute, String value) throws IllegalStateException {
        error("Cannot change configuration property '" + attribute + "' to " + value + " after the component has been created.");
    }

    protected void errorIfNotCreated(String property) throws IllegalStateException {
        if (!isCreated()) {
            throw new IllegalStateException("Cannot access property " + property + " before the widget has been created.");
        }
    }

    protected void error(String message) throws IllegalStateException {
        if (!GWT.isScript()) {
            Window.alert("Error :" + message);
            throw new IllegalStateException(message);
        }
    }

    protected void setAttribute(String attribute, String value, boolean allowPostCreate) {
        if (!isCreated()) {
            JSOHelper.setAttribute(config, attribute, value);
        } else if (allowPostCreate) {
            setProperty(attribute, value);
        } else {
            error(attribute, value);
        }
    }

    protected void setAttribute(String attribute, ValueEnum value, boolean allowPostCreate) {
        if (!isCreated()) {
            JSOHelper.setAttribute(config, attribute, value.getValue());
        } else if (allowPostCreate) {
            setProperty(attribute, value.getValue());
        } else {
            error(attribute, value.getValue());
        }
    }

    protected void setAttribute(String attribute, BaseWidget value, boolean allowPostCreate) {
        JavaScriptObject valueJS = value.isConfigOnly() ? value.getConfig() : value.getOrCreateJsObj();
        if (!isCreated()) {
            JSOHelper.setAttribute(config, attribute, valueJS);
        } else if (allowPostCreate) {
            setProperty(attribute, valueJS);
        } else {
            error(attribute, value.toString());
        }
    }

    protected void setAttribute(String attribute, Map value, boolean allowPostCreate) {
        if (!isCreated()) {
            JSOHelper.setAttribute(config, attribute, value);
        } else if (allowPostCreate) {
            setProperty(attribute, JSOHelper.convertMapToJavascriptObject(value));
        } else {
            error(attribute, value.toString());
        }
    }

    protected void setAttribute(String attribute, int[] value, boolean allowPostCreate) {
        if (!isCreated()) {
            JSOHelper.setAttribute(config, attribute, value);
        } else if (allowPostCreate) {
            setProperty(attribute, JSOHelper.convertToJavaScriptArray(value));
        } else {
            error(attribute, value.toString());
        }
    }

    protected void setAttribute(String attribute, DataClass value, boolean allowPostCreate) {

        if (!isCreated()) {
            JSOHelper.setAttribute(config, attribute, value.getJsObj());
        } else if (allowPostCreate) {
            setProperty(attribute, value.getJsObj());
        } else {
            error(attribute, value.toString());
        }
    }

    protected void setAttribute(String attribute, DataClass[] value, boolean allowPostCreate) {

        if (!isCreated()) {
            JSOHelper.setAttribute(config, attribute, JSOHelper.convertToJavaScriptArray(value));
        } else if (allowPostCreate) {
            setProperty(attribute, JSOHelper.convertToJavaScriptArray(value));
        } else {
            error(attribute, value.toString());
        }
    }

    protected void setAttribute(String attribute, JavaScriptObject[] value, boolean allowPostCreate) {

        if (!isCreated()) {
            JSOHelper.setAttribute(config, attribute, JSOHelper.convertToJavaScriptArray(value));
        } else if (allowPostCreate) {
            setProperty(attribute, JSOHelper.convertToJavaScriptArray(value));
        } else {
            error(attribute, value.toString());
        }
    }

    protected void setAttribute(String attribute, BaseClass[] value, boolean allowPostCreate) {

        if (!isCreated()) {
            JSOHelper.setAttribute(config, attribute, JSOHelper.convertToJavaScriptArray(value));
        } else if (allowPostCreate) {
            setProperty(attribute, JSOHelper.convertToJavaScriptArray(value));
        } else {
            error(attribute, value.toString());
        }
    }

    protected void setAttribute(String attribute, BaseWidget[] value, boolean allowPostCreate) {

        if (!isCreated()) {
            JSOHelper.setAttribute(config, attribute, JSOHelper.convertToJavaScriptArray(value));
        } else if (allowPostCreate) {
            setProperty(attribute, JSOHelper.convertToJavaScriptArray(value));
        } else {
            error(attribute, value.toString());
        }
    }

    protected void setAttribute(String attribute, float value, boolean allowPostCreate) {
        if (!isCreated()) {
            JSOHelper.setAttribute(config, attribute, value);
        } else if (allowPostCreate) {
            setProperty(attribute, value);
        } else {
            error(attribute, String.valueOf(value));
        }
    }

    protected void setAttribute(String attribute, double value, boolean allowPostCreate) {
        if (!isCreated()) {
            JSOHelper.setAttribute(config, attribute, value);
        } else if (allowPostCreate) {
            setProperty(attribute, value);
        } else {
            error(attribute, String.valueOf(value));
        }
    }

    protected void setAttribute(String attribute, Integer value, boolean allowPostCreate) {
        if (!isCreated()) {
            JSOHelper.setAttribute(config, attribute, value);
        } else if (allowPostCreate) {
            if (value == null) {
                setNullProperty(attribute);
            } else {
                setProperty(attribute, value.intValue());
            }
        } else {
            error(attribute, String.valueOf(value));
        }
    }

    public native void setNullProperty(String property)/*-{
        var widget = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        widget.setProperty(property, null);
    }-*/;

    public native void setProperty(String property, String value)/*-{
        var widget = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        widget.setProperty(property, value);
    }-*/;

    public native void setProperty(String property, boolean value)/*-{
        var widget = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        widget.setProperty(property, value);
    }-*/;

    public native void setProperty(String property, int value)/*-{
        var widget = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        widget.setProperty(property, value);
    }-*/;

    public native void setProperty(String property, float value)/*-{
        var widget = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        widget.setProperty(property, value);
    }-*/;

    public native void setProperty(String property, double value)/*-{
        var widget = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        widget.setProperty(property, value);
    }-*/;

    public native void setProperty(String property, Element value)/*-{
        var widget = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        widget.setProperty(property, value);
    }-*/;

    public native void setProperty(String property, JavaScriptObject value)/*-{
        var widget = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        widget.setProperty(property, value);
    }-*/;

    protected void setAttribute(String attribute, Date value, boolean allowPostCreate) {
        if (!isCreated()) {
            JSOHelper.setAttribute(config, attribute, value);
        } else if (allowPostCreate) {
            if (value == null) {
                setNullProperty(attribute);
            } else {
                setProperty(attribute, JSOHelper.convertToJavaScriptDate(value));
            }
        } else {
            error(attribute, String.valueOf(value));
        }
    }

    protected void setAttribute(String attribute, JavaScriptObject value, boolean allowPostCreate) {
        if (!isCreated()) {
            JSOHelper.setAttribute(config, attribute, value);
        } else if (allowPostCreate) {
            setProperty(attribute, value);
        } else {
            error(attribute, String.valueOf(value));
        }
    }

    protected void setAttribute(String attribute, String[] value, boolean allowPostCreate) {
        if (!isCreated()) {
            JSOHelper.setAttribute(config, attribute, JSOHelper.convertToJavaScriptArray(value));
        } else if (allowPostCreate) {
            setProperty(attribute, JSOHelper.convertToJavaScriptArray(value));
        } else {
            error(attribute, String.valueOf(value));
        }
    }

    protected void setAttribute(String attribute, Object[] value, boolean allowPostCreate) {
        if (!isCreated()) {
            JSOHelper.setAttribute(config, attribute, JSOHelper.convertToJavaScriptArray(value));
        } else if (allowPostCreate) {
            setProperty(attribute, JSOHelper.convertToJavaScriptArray(value));
        } else {
            error(attribute, String.valueOf(value));
        }
    }

    protected void setAttribute(String attribute, Boolean value, boolean allowPostCreate) {
        if (!isCreated()) {
            JSOHelper.setAttribute(config, attribute, value);
        } else if (allowPostCreate) {
            if (value == null) {
                setNullProperty(attribute);
            } else {
                setProperty(attribute, value.booleanValue());
            }
        } else {
            error(attribute, String.valueOf(value));
        }
    }

    protected void setAttribute(String attribute, Element value, boolean allowPostCreate) {
        if (!isCreated()) {
            JSOHelper.setAttribute(config, attribute, value);
        } else if (allowPostCreate) {
            setProperty(attribute, value);
        } else {
            error(attribute, String.valueOf(value));
        }
    }

    //override default behavior of setting title for SmartGWT widgets
    public void setTitle(String title) {
        //do nothing
    }

    public String getTitle() {
        return "";
    }

    public String toString() {
        if (true || !isDrawn()) {
            return "<<SmartGWT Component>>::" + getClass() + ", ID:" + getID();
        } else {
            return super.toString();
        }
    }

    public boolean equals(Object obj) {
        if (obj instanceof BaseWidget) {
            if (obj == this) {
                return true;
            } else {
                BaseWidget other = (BaseWidget) obj;
                if (other.getID().equals(getID())) {
                    return true;
                }
            }
            return false;
        } else {
            return false;
        }
    }

    public int hashCode() {
        return getID().hashCode();
    }

}
