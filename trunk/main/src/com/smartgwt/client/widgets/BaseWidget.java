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
import com.smartgwt.client.core.NativeObject;
import com.smartgwt.client.core.LogicalStructure;
import com.smartgwt.client.types.Positioning;
import com.smartgwt.client.types.ValueEnum;
import com.smartgwt.client.util.DOMUtil;
import com.smartgwt.client.util.IDManager;
import com.smartgwt.client.util.JSOHelper;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.events.DrawEvent;
import com.smartgwt.client.widgets.events.DrawHandler;
import com.smartgwt.logicalstructure.core.LogicalStructureObject;
import com.smartgwt.logicalstructure.widgets.BaseWidgetLogicalStructure;

import java.util.Date;
import java.util.Map;

public abstract class BaseWidget extends Widget implements HasHandlers, LogicalStructure {

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
    protected String scClassName;
    protected boolean configOnly;

    //event handling code
    //can be removed when GWT issue http://code.google.com/p/google-web-toolkit/issues/detail?id=3378
    //is fixed
    private HandlerManager manager;

    public void fireEvent(GwtEvent<?> event) {
        if (manager != null && id != null) {
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
        /*empty*/
    }

    protected BaseWidget(JavaScriptObject jsObj) {
        id = JSOHelper.getAttribute(jsObj, "ID");
    }

    public BaseWidget(String id) {
        setID(id);
    }

    public static BaseWidget getRef(JavaScriptObject jsObj) {
        return jsObj == null ? null : (BaseWidget) JSOHelper.getAttributeAsObject(jsObj, SC.REF);
    }

    protected void setElement(Element elem) {
        super.setElement(elem);
        isElementSet = true;
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

        if (self.shouldRedrawOnResize == $wnd.isc.Canvas.getPrototype().shouldRedrawOnResize) {
        	self.shouldRedrawOnResize = function(deltaX, deltaY) {
        		var redrawOnResize = self.redrawOnResize;
        		if (redrawOnResize == null) {
        			redrawOnResize = !((self.children != null && self.children.length > 0 &&
										!self.allowContentAndChildren) ||
										// we want to redrawOnResize if we have dynamic content
										// Check for getInnerHTML() having been overridden for this (javascript) Canvas subclass
										// This handles SC subclasses (EG detailViewer) where redrawOnResize is required.
										// If the developer overrides the java getInnerHTML() method rely on them
										// explicitly setting redrawOnResize if required.
										(self.__getInnerHTML == $wnd.isc.Canvas.getPrototype().getInnerHTML &&
										!$wnd.isc.isA.Function(self.contents)));
				}
				return redrawOnResize;
			}
    	}

        // onDraw() - undocumented method called from draw() as a draw-complete notification
        // Override this rather than overriding draw() directly - the latter adds a layer to the
        // stack depth on draw and when drawing deeply nested layouts etc increases the likelyhood
        // of seeing an out of stack depth error in IE7 and 8
        self.onDraw = function () {
            var jObj = this.__ref;
            if (jObj != null) jObj.@com.smartgwt.client.widgets.BaseWidget::rendered()();
        }

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

    /**
     * Permanently destroy a Canvas and all of it's children / members, recursively.
     * <P>
     * Like {@link Canvas#clear()} calling <code>destroy()</code> removes all HTML for the component;
     * unlike clear(), a destroyed Canvas is permanently unusable: it cannot be draw()'n again and
     * cannot be referenced by its global ID. This method also removes all JavaScript references to
     * the Canvas outside of application code, making it eligible for garbage collection (though
     * developers will need to release any references to the canvas held in application code themselves).
     * <P>
     * Any attempt to call a method on a destroyed Canvas will generally result in an error.  If your
     * application is forced to hold onto Canvas's that might be destroy()d without warning, you can
     * avoid errors by checking for the {@link Canvas#getDestroyed()} property.  If you override certain Canvas
     * methods, your code may be called while a Canvas is being destroy()d; in this case you can avoid
     * extra work (and possibly errors) by checking for the +{@link Canvas#getDestroying()} property.
     * <P>
     * Note that <code>destroy()</code> should not be called directly in event handling code for this
     * canvas. For this reason, wherever possible we recommend using {@link Canvas#markForDestroy()}
     * instead of calling this method directly.
     * <P>
     * <b>Note</b>: This is an override point
     */
    public native void destroy() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var id = self.ID;
        self.__destroy();
        @com.smartgwt.client.util.IDManager::unregisterID(Ljava/lang/String;)(id);
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
        if (id == null) {
            // Generate an ID because one was requested by the caller.
            internalSetID(SC.generateID(getClass().getName()), false);
            setAttribute("_autoAssignedID", true, false);
        }
        assert id != null;
        return id;
    }

    private void internalSetID(String id, boolean skipUniqueJSIdentifierCheck) {
        if (this.id != null) {
            IDManager.unregisterID(this.id);
        }
        IDManager.registerID(id, skipUniqueJSIdentifierCheck);
        if (!skipUniqueJSIdentifierCheck) setAttribute("ID", id, false);
        this.id = id;
    }

    public void setID(String id) {
        internalSetID(id, false);
        setAttribute("_autoAssignedID", false, false);
    }

    public JavaScriptObject getConfig() {
        return config;
    }

    public void setConfig(JavaScriptObject config) {
        this.config = config;
    }

    public native boolean isCreated()/*-{
        var id = this.@com.smartgwt.client.widgets.BaseWidget::id;
        var obj;
        return id != null && (obj = $wnd.window[id]) != null && obj !== undefined && $wnd.isc.isA.Canvas(obj) === true;
    }-*/;

    protected Boolean isDrawn() {
        return isCreated() && doIsDrawn();
    }

    private native boolean doIsDrawn()/*-{
        var widget = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        return widget.isDrawn();
    }-*/;

    public native JavaScriptObject getJsObj()/*-{
        var id = this.@com.smartgwt.client.widgets.BaseWidget::id;
        if (id != null && $wnd.window[id] != null && $wnd.window[id] !== undefined) {
            return $wnd.window[id];
        } else {
            return null;
        }
    }-*/;

    public JavaScriptObject getOrCreateJsObj() {
        if (!isCreated()) {
            JavaScriptObject jsObj = create();
            JSOHelper.setObjectAttribute(jsObj, SC.REF, this);
            return jsObj;
        } else {
            return getJsObj();
        }
    }

    protected native JavaScriptObject create()/*-{
        var config = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        var widget = $wnd.isc.Canvas.create(config);
        this.@com.smartgwt.client.widgets.BaseWidget::internalSetID(Ljava/lang/String;Z)(widget.getID(), true);
        return widget;
    }-*/;

    public String getAttribute(String attribute) {
        return getAttributeAsString(attribute);
    }


    protected native String getAttributeAsString(String property)/*-{
        var ret;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            var widget = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            ret = widget.getProperty(property);
        } else {
            var config = this.@com.smartgwt.client.widgets.BaseWidget::config;
            if(config[property] != undefined) {
                ret = config[property];
            } else {
               var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
               ret = $wnd.isc[scClassName].getInstanceProperty(property);
            }
        }
        return ret == null || ret === undefined ? null : String(ret) ;
    }-*/;

    protected native String[] getAttributeAsStringArray(String property)/*-{
        var ret;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            var widget = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            ret = widget.getProperty(property);
        } else {
            var config = this.@com.smartgwt.client.widgets.BaseWidget::config;
            if(config[property] != undefined) {
                ret = config[property];
            } else {
               var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
               ret = $wnd.isc[scClassName].getInstanceProperty(property);
            }
        }
        return ret === undefined ? null : @com.smartgwt.client.util.JSOHelper::convertToJavaStringArray(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

    protected native int[] getAttributeAsIntArray(String property)/*-{
        var ret;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            var widget = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            ret = widget.getProperty(property);
        } else {
            var config = this.@com.smartgwt.client.widgets.BaseWidget::config;
            if(config[property] != undefined) {
                ret = config[property];
            } else {
               var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
               ret = $wnd.isc[scClassName].getInstanceProperty(property);
            }
        }
        return ret === undefined ? null : @com.smartgwt.client.util.JSOHelper::convertToJavaIntArray(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

    protected native Float[] getAttributeAsFloatArray(String property)/*-{
        var ret;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            var widget = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            ret = widget.getProperty(property);
        } else {
            var config = this.@com.smartgwt.client.widgets.BaseWidget::config;
            if(config[property] != undefined) {
                ret = config[property];
            } else {
               var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
               ret = $wnd.isc[scClassName].getInstanceProperty(property);
            }
        }
        return ret === undefined ? null : @com.smartgwt.client.util.JSOHelper::convertToJavaFloatArray(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

    protected native Date getAttributeAsDate(String property)/*-{
        var ret;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            var widget = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            ret = widget.getProperty(property);
        } else {
            var config = this.@com.smartgwt.client.widgets.BaseWidget::config;
            if(config[property] != undefined) {
                ret = config[property];
            } else {
               var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
               ret = $wnd.isc[scClassName].getInstanceProperty(property);
            }
        }
        return ret == null || ret === undefined ? null : @com.smartgwt.client.util.JSOHelper::toDate(D)(ret.getTime());
    }-*/;

    protected native Date[] getAttributeAsDateArray(String property)/*-{

        var ret;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            var widget = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            ret = widget.getProperty(property);
        } else {
            var config = this.@com.smartgwt.client.widgets.BaseWidget::config;
            if(config[property] != undefined) {
                ret = config[property];
            } else {
               var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
               ret = $wnd.isc[scClassName].getInstanceProperty(property);
            }
        }
        if (!$wnd.isc.isA.Array(ret)) return null;

        return @com.smartgwt.client.util.JSOHelper::convertToJavaDateArray(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);

    }-*/;

    protected native Integer getAttributeAsInt(String property)/*-{
        var ret;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            var widget = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            ret = widget.getProperty(property);
        } else {
            var config = this.@com.smartgwt.client.widgets.BaseWidget::config;
            if(config[property] != undefined) {
                ret = config[property];
            } else {
               var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
               ret = $wnd.isc[scClassName].getInstanceProperty(property);
            }
        }
        return ret == null || ret === undefined ? null : @com.smartgwt.client.util.JSOHelper::toInteger(I)(ret);
    }-*/;

    protected native Double getAttributeAsDouble(String property)/*-{
        var ret;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            var widget = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            ret = widget.getProperty(property);
        } else {
            var config = this.@com.smartgwt.client.widgets.BaseWidget::config;
            if(config[property] != undefined) {
                ret = config[property];
            } else {
               var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
               ret = $wnd.isc[scClassName].getInstanceProperty(property);
            }
        }
        return ret == null || ret === undefined ? null : @com.smartgwt.client.util.JSOHelper::toDouble(D)(ret);
    }-*/;

    protected native Element getAttributeAsElement(String property)/*-{
        var ret;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            var widget = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            ret = widget.getProperty(property);
        } else {
            var config = this.@com.smartgwt.client.widgets.BaseWidget::config;
            if(config[property] != undefined) {
                ret = config[property];
            } else {
               var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
               ret = $wnd.isc[scClassName].getInstanceProperty(property);
            }
        }
        return ret === undefined ? null : ret;
    }-*/;

    protected native JavaScriptObject getAttributeAsJavaScriptObject(String property)/*-{
        var ret;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            var widget = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            ret = widget.getProperty(property);
        } else {
            var config = this.@com.smartgwt.client.widgets.BaseWidget::config;
            if(config[property] != undefined) {
                ret = config[property];
            } else {
               var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
               ret = $wnd.isc[scClassName].getInstanceProperty(property);
            }
        }
        return ret === undefined ? null : ret;
    }-*/;

    protected native Float getAttributeAsFloat(String property)/*-{
        var ret;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            var widget = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            ret = widget.getProperty(property);
        } else {
            var config = this.@com.smartgwt.client.widgets.BaseWidget::config;
            if(config[property] != undefined) {
                ret = config[property];
            } else {
               var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
               ret = $wnd.isc[scClassName].getInstanceProperty(property);
            }
        }
        return ret == null || ret === undefined ? null : @com.smartgwt.client.util.JSOHelper::toFloat(F)(ret);
    }-*/;

    protected native Boolean getAttributeAsBoolean(String property)/*-{
        var ret;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            var widget = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            ret = widget.getProperty(property);
        } else {
            var config = this.@com.smartgwt.client.widgets.BaseWidget::config;
            if(config[property] != undefined) {
                ret = config[property];
            } else {
               var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
               ret = $wnd.isc[scClassName].getInstanceProperty(property);
            }
        }
        return ret == null || ret === undefined ? null : @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(ret);
    }-*/;

    protected native Map getAttributeAsMap(String property)/*-{
        var ret;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            var widget = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            ret = widget.getProperty(property);
        } else {
            var config = this.@com.smartgwt.client.widgets.BaseWidget::config;
            if(config[property] != undefined) {
                ret = config[property];
            } else {
               var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
               ret = $wnd.isc[scClassName].getInstanceProperty(property);
            }
        }
        return ret == null || ret === undefined ? null : @com.smartgwt.client.util.JSOHelper::convertToMap(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
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

    protected void setAttribute(String attribute, float[] value, boolean allowPostCreate) {
        if (!isCreated()) {
            JSOHelper.setAttribute(config, attribute, value);
        } else if (allowPostCreate) {
            setProperty(attribute, JSOHelper.convertToJavaScriptArray(value));
        } else {
            error(attribute, value.toString());
        }
    }

    protected void setAttribute(String attribute, Float[] value, boolean allowPostCreate) {
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

    public native String toString()/*-{
        try {
            var self;
            if (this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
                self = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            } else {
                self = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            }
            return $wnd.isc.echo(self);
        } catch (e) {
            return "ERROR: " + e.name + " -- " + e.message;
        }
    }-*/;

    public boolean equals(Object obj) {
        if (obj instanceof BaseWidget) {
            if (obj == this) {
                return true;
            } else {
                BaseWidget other = (BaseWidget) obj;
                if (other.id == null || id == null) return false;
                if (other.id.equals(id)) {
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

    public NativeObject nativeObject;

    public LogicalStructureObject setLogicalStructure(LogicalStructureObject s) {
        s.scClassName = getScClassName();
        return s;
    }

    public LogicalStructureObject getLogicalStructure() {
        BaseWidgetLogicalStructure s = new BaseWidgetLogicalStructure();
        setLogicalStructure(s);
        return s;
    }

    public void initNativeObject() {
        this.nativeObject = new NativeObject(this);
    }
}
