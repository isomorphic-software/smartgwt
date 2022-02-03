/*
 * Smart GWT (GWT for SmartClient)
 * Copyright 2008 and beyond, Isomorphic Software, Inc.
 *
 * Smart GWT is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License version 3
 * as published by the Free Software Foundation.  Smart GWT is also
 * available under typical commercial license terms - see
 * http://smartclient.com/license
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 */
/* sgwtgen */
 
package com.smartgwt.client.widgets;


import com.smartgwt.client.event.*;
import com.smartgwt.client.core.*;
import com.smartgwt.client.types.*;
import com.smartgwt.client.data.*;
import com.smartgwt.client.data.events.*;
import com.smartgwt.client.rpc.*;
import com.smartgwt.client.callbacks.*;
import com.smartgwt.client.tools.*;
import com.smartgwt.client.bean.*;
import com.smartgwt.client.widgets.*;
import com.smartgwt.client.widgets.events.*;
import com.smartgwt.client.widgets.form.*;
import com.smartgwt.client.widgets.form.validator.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.tile.*;
import com.smartgwt.client.widgets.tile.events.*;
import com.smartgwt.client.widgets.grid.*;
import com.smartgwt.client.widgets.grid.events.*;
import com.smartgwt.client.widgets.chart.*;
import com.smartgwt.client.widgets.layout.*;
import com.smartgwt.client.widgets.layout.events.*;
import com.smartgwt.client.widgets.menu.*;
import com.smartgwt.client.widgets.rte.*;
import com.smartgwt.client.widgets.rte.events.*;
import com.smartgwt.client.widgets.ace.*;
import com.smartgwt.client.widgets.ace.events.*;
import com.smartgwt.client.widgets.tab.*;
import com.smartgwt.client.widgets.toolbar.*;
import com.smartgwt.client.widgets.tree.*;
import com.smartgwt.client.widgets.tree.events.*;
import com.smartgwt.client.widgets.tableview.*;
import com.smartgwt.client.widgets.viewer.*;
import com.smartgwt.client.widgets.calendar.*;
import com.smartgwt.client.widgets.calendar.events.*;
import com.smartgwt.client.widgets.cube.*;
import com.smartgwt.client.widgets.drawing.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;
import com.smartgwt.client.util.*;
import com.smartgwt.client.util.events.*;
import com.smartgwt.client.util.workflow.*;
import com.google.gwt.event.shared.*;
import com.google.gwt.event.shared.HasHandlers;
import com.smartgwt.logicalstructure.core.*;
import com.smartgwt.logicalstructure.widgets.*;
import com.smartgwt.logicalstructure.widgets.drawing.*;
import com.smartgwt.logicalstructure.widgets.plugins.*;
import com.smartgwt.logicalstructure.widgets.form.*;
import com.smartgwt.logicalstructure.widgets.tile.*;
import com.smartgwt.logicalstructure.widgets.grid.*;
import com.smartgwt.logicalstructure.widgets.chart.*;
import com.smartgwt.logicalstructure.widgets.layout.*;
import com.smartgwt.logicalstructure.widgets.menu.*;
import com.smartgwt.logicalstructure.widgets.rte.*;
import com.smartgwt.logicalstructure.widgets.ace.*;
import com.smartgwt.logicalstructure.widgets.tab.*;
import com.smartgwt.logicalstructure.widgets.tableview.*;
import com.smartgwt.logicalstructure.widgets.toolbar.*;
import com.smartgwt.logicalstructure.widgets.tree.*;
import com.smartgwt.logicalstructure.widgets.viewer.*;
import com.smartgwt.logicalstructure.widgets.calendar.*;
import com.smartgwt.logicalstructure.widgets.cube.*;
import com.smartgwt.logicalstructure.widgets.tools.*;

/**
 * Base class for {@link com.smartgwt.client.widgets.Canvas} and {@link com.smartgwt.client.widgets.drawing.DrawItem}.
 */
@BeanFactory.FrameworkClass
@BeanFactory.ScClassName("BaseWidget")
public class BaseWidget extends com.google.gwt.user.client.ui.Widget implements com.google.gwt.event.shared.HasHandlers, com.smartgwt.client.core.LogicalStructure {

    public static BaseWidget getOrCreateRef(JavaScriptObject jsObj) {
        if (jsObj == null) return null;
        final BaseWidget refInstance = BaseWidget.getRef(jsObj);
        if (refInstance == null) {
            return new BaseWidget(jsObj);
        } else {
            assert refInstance instanceof BaseWidget;
            return (BaseWidget)refInstance;
        }
    }
        


    /**
     * Changes the defaults for Canvas AutoChildren named <code>autoChildName</code>.
     *
     * @param autoChildName name of an AutoChild to customize the defaults for.
     * @param defaults Canvas defaults to apply. These defaults override any existing properties
     * without destroying or wiping out non-overridden properties.  For usage tips on this
     * param, see {@link com.smartgwt.client.docs.SGWTProperties}.
     * @see com.smartgwt.client.docs.AutoChildUsage
     */
    public static native void changeAutoChildDefaults(String autoChildName, Canvas defaults) /*-{
        if (defaults.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(BaseWidget.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "Canvas");
        }
        defaults.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
        var cleanDefaultsJS = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(defaults.@com.smartgwt.client.widgets.BaseWidget::getConfig()(), true);
        $wnd.isc.BaseWidget.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
    }-*/;

    /**
     * Changes the defaults for FormItem AutoChildren named <code>autoChildName</code>.
     *
     * @param autoChildName name of an AutoChild to customize the defaults for.
     * @param defaults FormItem defaults to apply. These defaults override any existing properties
     * without destroying or wiping out non-overridden properties.  For usage tips on this
     * param, see {@link com.smartgwt.client.docs.SGWTProperties}.
     * @see com.smartgwt.client.docs.AutoChildUsage
     */
    public static native void changeAutoChildDefaults(String autoChildName, FormItem defaults) /*-{
        if (defaults.@com.smartgwt.client.widgets.form.fields.FormItem::isCreated()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(BaseWidget.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "FormItem");
        }
        defaults.@com.smartgwt.client.widgets.form.fields.FormItem::setConfigOnly(Z)(true);
    	var cleanDefaultsJS = defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getEditorTypeConfig()();
        $wnd.isc.BaseWidget.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
    }-*/;

    public BaseWidget(){
        
        // We immediately pick up any properties which BeanFactory has stashed.
        // We can't pick them up later (for instance, at getOrCreateJsObj()
        // time), because the constructor could create *other* objects first
        // and trigger getOrCreateJsObj() on them -- in which case, the global
        // would be applied to the wrong object. So, we need to pick up the
        // global at the earliest moment after the constructor is called --
        // which is here, since superclass constructors get called before
        // subclass constructors.
        //
        // We only need to deal with the no-arg constructor because that is the
        // one which BeanFactory uses. An alternative would be to use a
        // constructor which takes a JavaScriptObject, but that would mean that
        // developers would need to implement that constructor for custom
        // classes, and it's undesirable to force them to do so.
        //
        // We don't apply the properties immediately, because we're at the very
        // beginning of the base class constructor -- the setters may rely on
        // further construction having taken place. So we delay as long as
        // possible -- either until getOrCreateJsObj() is called, or the object
        // is fully constructed, whichever comes first.
        //
        // We test the factoryPropertiesClass to avoid applying properties
        // intended for a different class. This can occur if a static
        // initializer creates objects, since the static initializer can run
        // after the properties are stashed but before the constructor runs.
        // Checking the factoryPropertiesClass at least limits the problem to
        // cases where the static initializer creates objects of the same class.
        if (getClass() == BeanFactory.getFactoryPropertiesClass()) {
            factoryProperties = BeanFactory.getFactoryProperties();
            BeanFactory.clearFactoryProperties();
        }
scClassName = "BaseWidget";
    }

    public BaseWidget(JavaScriptObject jsObj){
        scClassName = "BaseWidget";
        setJavaScriptObject(jsObj);
    }

    protected native JavaScriptObject create()/*-{
        var config = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
        var widget = $wnd.isc[scClassName].create(config);
        if ($wnd.isc.keepGlobals) this.@com.smartgwt.client.widgets.BaseWidget::internalSetID(Lcom/google/gwt/core/client/JavaScriptObject;)(widget);
        this.@com.smartgwt.client.widgets.BaseWidget::doInit()();
        return widget;
    }-*/;

    // ********************* Properties / Attributes ***********************

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************

    /** 
     * Class level method to set the default properties of this class.  If set, then all
     * existing and subsequently created instances of this class will automatically have
     * default properties corresponding to
     * the properties set on the SmartGWT class instance passed to this function before its
     * underlying SmartClient JS object was created.
     * This is a powerful feature that eliminates the need for users to create a separate
     * hierarchy of subclasses that only alter the default properties of this class. Can also
     * be used for skinning / styling purposes.  <P> <b>Note:</b> This method is intended for
     * setting default attributes only and will affect all instances of the underlying class
     * (including those automatically generated in JavaScript).  This method should not be used
     * to apply standard EventHandlers or override methods for a class - use a custom subclass
     * instead.  Calling this method after instances have been created can result in undefined
     * behavior, since it bypasses any setters and a class instance may have already examined 
     * a particular property and not be expecting any changes through this route.
     *
     * @param baseWidgetProperties properties that should be used as new defaults when instances of this class are created
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public static native void setDefaultProperties(BaseWidget baseWidgetProperties) /*-{
        if (baseWidgetProperties.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Class;)(BaseWidget.@java.lang.Object::getClass()(), "setDefaultProperties", baseWidgetProperties.@java.lang.Object::getClass()());
        }
        baseWidgetProperties.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
    	var properties = baseWidgetProperties.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        properties = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(properties,true);
        $wnd.isc.BaseWidget.addProperties(properties);
    }-*/;

    // ***********************************************************



    static {
        init();
    }

    private static String FALSE_PLACEHOLDER;

    private static native void init()/*-{
        $wnd.isc.setAutoDraw(false);
        @com.smartgwt.client.widgets.BaseWidget::FALSE_PLACEHOLDER = new String("false");
    }-*/;

    /**
     * Retrieve a BaseWidget by its global {@link com.smartgwt.client.widgets.Canvas#getID ID}.
     * @param ID global ID of the BaseWidget
     *
     * @return the Canvas, or null if not found
     */
    public static native BaseWidget getById(String ID) /*-{
        var ret = $wnd.isc.Canvas.getById(ID);
        return @com.smartgwt.client.widgets.BaseWidget::getByJSObject(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

    /**
     * Retrieve a BaseWidget from its {@link com.google.gwt.core.client.JavaScriptObject}.
     * @param jsObj SmartClient object associated with Canvas
     *
     * @return the BaseWidget, or null if not found
     */
    public static native BaseWidget getByJSObject(JavaScriptObject jsObj) /*-{
        if (jsObj == null || jsObj.getScClassName == null) return null;
        // note that SC.REF will be set automatically on the JS object by the constructors that take a JavaScriptObject; no need to do it here
        return @com.smartgwt.client.util.ObjectFactory::createCanvas(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(jsObj.getScClassName(), jsObj);
    }-*/;

    private Function onRenderFn;

    protected String id;
    protected JavaScriptObject config = JSOHelper.createObject();
    protected String scClassName;
    protected boolean configOnly;

    // Properties stashed by BeanFactory when calling the no-arg constructor.
    // We pick them up immediately in the constructor so that they don't get
    // applied to the wrong object (in case the constructor of a subclass
    // triggers the construction of some other object).  Fortunately, our
    // constructor is called first! The properties get applied when
    // getOrCreateJsObj() is called (checked below), or when all constructors
    // have finished (checked by BeanFactory), whichever comes first.
    protected Map<String, Object> factoryProperties;

    // Tracks whether this object was created by a BeanFactory. The BeanFactory
    // code will set this property via the reflection mechanism when creating
    // an instance. Thus, it can check whether the property has been correctly
    // applied. (That is, if factoryCreated is false for an object which 
    // BeanFactory creates, then BeanFactory knows something went wrong).
    //
    // There is one known case where properties are not correctly applied via
    // reflection: when (a) a class has a static initializer; (b) the static
    // initializer is not triggered before the use of reflection to create an
    // object of that class; and (c) the static initializer itself creates an
    // object of that class. 
    //
    // We can't detect that case directly, but we can at least detect the
    // resulting failure and try to recover (and generate a useful error
    // message).
    protected boolean factoryCreated;

    public BaseWidget(String id) {
        setID(id);
        scClassName = "BaseWidget";
    }

    public void setFactoryCreated (boolean createdByBeanFactory) {
        factoryCreated = createdByBeanFactory;
    }

    public boolean isFactoryCreated () {
        return factoryCreated;
    }

    /**
     * Adds this handler to the widget.
     *
     * @param <H>     the type of handler to add
     * @param type    the event type
     * @param handler the handler
     * @return {@link HandlerRegistration} used to remove the handler
     */
    protected final <H extends com.google.gwt.event.shared.EventHandler> HandlerRegistration doAddHandler(final H handler, GwtEvent.Type<H> type) {
    	return addHandler(handler, type);
    }

    public int getHandlerCount(GwtEvent.Type<?> type) {
    	return super.getHandlerCount(type);
    };

    public void setJavaScriptObject(JavaScriptObject jsObj) {
        internalSetID(jsObj);
        JSOHelper.setObjectAttribute(jsObj, SC.REF, this);
        JSOHelper.setObjectAttribute(jsObj, SC.MODULE, BeanFactory.getSGWTModule());
        if (!JSOHelper.isScClassInstance(jsObj)) {
            setConfig(jsObj);
            return;
        }
        JSOHelper.setObjectAttribute(getConfig(), SC.REF, this);
        JSOHelper.setObjectAttribute(getConfig(), SC.MODULE, BeanFactory.getSGWTModule());
        onBind();
    }

    public static BaseWidget getRef(JavaScriptObject jsObj) {
        if (jsObj == null) {
            return null;
        } else {
            final Object ref = JSOHelper.getAttributeAsObject((JavaScriptObject)jsObj, SC.REF);
            if (ref instanceof BaseWidget) {
                return (BaseWidget)ref;
            } else {
                return null;
            }
        }
    }

    public static boolean hasAutoAssignedID(JavaScriptObject jsObj) {
        return jsObj == null ? false : JSOHelper.getAttributeAsBoolean(jsObj, SC.AUTOID);
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

    private native void wrapDestroy() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        if (self == null) {
            var config = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            $wnd.isc.logWarn("wrapDestroy(): the JavaScriptObject is null unexpectedly for " +
                $wnd.isc.echo(config) + " with " + this.@java.lang.Object::getClass()() +
                ".  This may lead to an ID collision after the widget is destroy()ed.");
            return;
        }
        if (self.__sgwtDestroy == null) self.__sgwtDestroy = function () {
            var jObj = this.__ref;
            if (jObj != null) jObj.@com.smartgwt.client.widgets.BaseWidget::destroy()();
        }
    }-*/;

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
            this.__getInnerHTMLArguments = arguments;
            try {
                var ret = jObj.@com.smartgwt.client.widgets.BaseWidget::getInnerHTML()();
                if (ret === @com.smartgwt.client.widgets.BaseWidget::FALSE_PLACEHOLDER) {
                    return false;
                } else {
                	// Call "String(...)" [note this is not the constructor "new String(...)"]
                	// This will ensure we map any String object to the primitive
                	// (Equivalent to calling someStringObject.valueOf()). This makes sure our
                	// SmartClient String extensions get applied as necessary downstream.
                    return ret == null ? null : String(ret);
                }
            } finally {
                this.__getInnerHTMLArguments = null;
            }
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

        this.@com.smartgwt.client.widgets.BaseWidget::wrapDestroy()();
        this.@com.smartgwt.client.widgets.BaseWidget::onInit()();
    }-*/;

    protected void onInit() {}

    // install callbacks for a live SC widget
    protected void onBind() {
        wrapDestroy();
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
        var ret = self.__getInnerHTML.apply(self, self.__getInnerHTMLArguments);
        
        if (ret === false) {
            ret = @com.smartgwt.client.widgets.BaseWidget::FALSE_PLACEHOLDER;
        }
        return ret;
    }-*/;

    /**
     * Draws the widget on the page.&#010
     */
    public native void draw() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "draw", "");
        }
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
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
	    if (self != null && self.__sgwtDestroy) {
            delete self.__sgwtDestroy;
            if (self.destroy) self.destroy();
        }
	    var id = this.@com.smartgwt.client.widgets.BaseWidget::id;
        if (id != null) {
            this.@com.smartgwt.client.widgets.BaseWidget::clearID()();
            this.@com.smartgwt.client.widgets.Canvas::onDestroy()();
        }
        this.@com.smartgwt.client.widgets.BaseWidget::clearConfigRef()();
    }-*/;

    private void clearID() {
        IDManager.unregisterID(this, this.id);
        this.id = null;
        JSOHelper.setNullAttribute(config, SC.AUTOIDCLASS);
    	JSOHelper.setNullAttribute(config, "ID");
    	JSOHelper.setNullAttribute(config, SC.AUTOID);
    }

    private void clearConfigRef() {
        JSOHelper.setNullAttribute(this.config, SC.REF);
        JSOHelper.setNullAttribute(this.config, SC.MODULE);
    }

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
    	setupDrawHandlerEvent();
        return doAddHandler(handler, DrawEvent.getType());
    }

    private native void setupDrawHandlerEvent() /*-{
        var obj = null;
        var selfJ = this;
        var drawn = $entry(function(){
            selfJ.@com.smartgwt.client.widgets.BaseWidget::rendered()();
        });
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            obj.addProperties({onDraw: drawn});
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.onDraw = drawn;
        }
    }-*/;

    protected void onDraw() {
    }

    protected void onDestroy() {
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
            final String className = SC.getAUTOIDClass(getClass().getName());
            setAttribute("AUTOIDClass", className, false);
            internalSetID(SC.generateID(className), true);
        }
        assert id != null;
        return id;
    }

    protected final void internalSetID(JavaScriptObject jsObj) {
        boolean requireJsObjID = JSOHelper.isScClassInstance(jsObj);

        if (this.id != null) {
            IDManager.unregisterID(this, this.id);
        }
        String id = JSOHelper.getAttribute(jsObj, "ID");
        if (this.id != null && !this.id.equals(id) && getAttributeAsBoolean(SC.AUTOID)) {
            SC.releaseID(getClass().getName(), this.id);
        }
        boolean auto = JSOHelper.getAttributeAsBoolean(jsObj, SC.AUTOID);
        String className = JSOHelper.getAttribute(jsObj, SC.AUTOIDCLASS);

        // always try to register an Instance's ID, and skip Framework-side unique ID check
        if (id != null || requireJsObjID) IDManager.registerID(this, id, requireJsObjID);
        this.id = id;

        JSOHelper.setAttribute(config,       "ID",       id);
        JSOHelper.setAttribute(config, SC.AUTOID,      auto);
        JSOHelper.setAttribute(config, SC.AUTOIDCLASS, className);
    }

    protected final void internalSetID(String id, boolean autoAssigned) {
        // prevent transaction from being started if it cannot complete successfully
        if (isCreated()) {
            error("Attempt to call internalSetID to change id from " + this.id +
                  " to " + id + " after the SC widget has already been created");
            return;
        }
        if (this.id != null) {
            IDManager.unregisterID(this, this.id);
        }
        IDManager.registerID(this, id, false);
        // If we previously auto-assigned an ID, release the ID back to SmartClient if the new
        // ID is different.
        if (this.id != null && !this.id.equals(id) && getAttributeAsBoolean(SC.AUTOID)) {
            SC.releaseID(getClass().getName(), this.id);
        }
        this.id = id;
        setAttribute(     "ID",           id, false);
        setAttribute(SC.AUTOID, autoAssigned, false);
        if (!autoAssigned) setAttribute(SC.AUTOIDCLASS, (String)null, false);
    }

    public void setID(String id) {
        internalSetID(id, false);
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
        return id != null && (obj = $wnd.window[id]) != null && obj !== undefined && $wnd.isc.isA.BaseWidget(obj) === true;
    }-*/;

	/**
     * Returns the boolean true if the widget has been completely drawn, and false otherwise.
     *
     * @return true if drawn, false if not drawn
     * @see com.smartgwt.client.docs.Drawing Drawing overview and related methods
     */
    public Boolean isDrawn() {
        return isCreated() && doIsDrawn();
    }

    private native boolean doIsDrawn()/*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "isDrawn", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        return self.isDrawn();
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
            if (id == null) {
                final String className = SC.getAUTOIDClass(getClass().getName());
                setAttribute("AUTOIDClass", className, false);
                internalSetID(SC.generateID(className), true);
            }
            // The SC.REF property will already be set if new was called on a SmartClient
            // JS properties object; warn here if we actually attempt to create() it.
            if (getRef(config) == this) {
                SC.logWarn("Instantiating in SGWT a properties object from the SmartClient " +
                           "side may lead to undefined behavior if the SmartClient Framework " +
                           "is expecting to perform the instantiation itself.");
            } else {
                JSOHelper.setObjectAttribute(config, SC.REF, this);
                JSOHelper.setObjectAttribute(config, SC.MODULE, BeanFactory.getSGWTModule());
            }

            // Apply the properties provided by BeanFactory if they haven't
            // already been applied. We do this before calling create(), since
            // the constructor on the SmartClient side may be expecting some
            // of these properties.
            applyFactoryProperties();

            JavaScriptObject jsObj = create();
            return jsObj;
        } else {
            return getJsObj();
        }
    }

    /**
     * Commits a widget to being an actual live instance instead of being used as a
     * configuration template with various APIs that accept a properties object.
     * <P>
     * A widget will be automatically instantiated in some circumstances, such as:<ul>
     * <li>when it's drawn
     * <li>when it's added as a member of a <code>Layout</code> or child of a parent widget
     * <li>when it's asked to perform any kind of network request (e.g.
     * {@link com.smartgwt.client.widgets.grid.ListGrid#fetchData listGrid.fetchData()}, etc.)
     * </ul><P>
     * In general, completeCreation() will also occur automatically as a result of methods that
     * require the object to derive or calculate any kind of value.  The object will remain in
     * the uncreated state (still usable as just a configuration object) as long as the only
     * methods that are called either set properties or retrieve properties previously set.
     * <P>
     * Note that if the object has already been used as a configuration template, say by being
     * passed to a method such as {@link
     * com.smartgwt.client.widgets.Canvas#changeAutoChildDefaults Canvas.changeAutoChildDfaults()}
     * as the properties object argument, then it is an error to call this method.
     * <P>
     * For a discussion of when a widget should  be treated as a properties object rather than a
     * live instance, see {@link com.smartgwt.client.docs.SGWTProperties SmartGWT Properties}.
     */
    public void completeCreation() {
        if (isConfigOnly()) {
            ConfigUtil.warnOfPostConfigInstantiation(getClass(), "completeCreation", "");
        }
        // force creation, discard result
        getOrCreateJsObj();
    }

    // Apply any properties provided by BeanFactory before it called the no-arg
    // constructor. We call this before constructing the jsObj. Otherwise, the
    // constructor on the SmartClient side may be missing some properties it
    // expected to be supplied. If all the SmartGWT constructors finish and
    // getOrCreateJsObj() hasn't been triggered yet, then BeanFactory will call
    // this with the fully-constructed object.
    // 
    // Note that the factoryProperties may be a mix of values that will be
    // passed through to the config object (either because there is no SmartGWT
    // setter or because that's what the SmartGWT setter does), and values
    // which are actually handled by SmartGWT itself. In principle, we could
    // delay applying the latter until later, but we can't really tell one from
    // the other, especially for developer subclasses.
    public void applyFactoryProperties () {
        if (factoryProperties != null) {
            // Make sure that this is re-entrant without infinite loop
            Map<String, Object> properties = factoryProperties;
            factoryProperties = null;

            BeanFactory.setProperties(this, properties);
        }
    }

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
            if(config[property] !== undefined) {
                ret = config[property];
            } else {
               var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
               ret = $wnd.isc[scClassName].getInstanceProperty(property);
            }
        }
        return ret == null ? null : String(ret) ;
    }-*/;

    protected native String[] getAttributeAsStringArray(String property)/*-{
        var ret;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            var widget = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            ret = widget.getProperty(property);
        } else {
            var config = this.@com.smartgwt.client.widgets.BaseWidget::config;
            if(config[property] !== undefined) {
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
            if(config[property] !== undefined) {
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
            if(config[property] !== undefined) {
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
            if(config[property] !== undefined) {
                ret = config[property];
            } else {
               var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
               ret = $wnd.isc[scClassName].getInstanceProperty(property);
            }
        }
        return ret == null ? null : @com.smartgwt.client.util.JSOHelper::toDate(D)(ret.getTime());
    }-*/;

    protected native Date[] getAttributeAsDateArray(String property)/*-{

        var ret;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            var widget = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            ret = widget.getProperty(property);
        } else {
            var config = this.@com.smartgwt.client.widgets.BaseWidget::config;
            if(config[property] !== undefined) {
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
            if(config[property] !== undefined) {
                ret = config[property];
            } else {
               var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
               ret = $wnd.isc[scClassName].getInstanceProperty(property);
            }
        }
        return ret == null ? null : @com.smartgwt.client.util.JSOHelper::toInteger(I)(ret);
    }-*/;

    protected native Double getAttributeAsDouble(String property)/*-{
        var ret;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            var widget = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            ret = widget.getProperty(property);
        } else {
            var config = this.@com.smartgwt.client.widgets.BaseWidget::config;
            if(config[property] !== undefined) {
                ret = config[property];
            } else {
               var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
               ret = $wnd.isc[scClassName].getInstanceProperty(property);
            }
        }
        return ret == null ? null : @com.smartgwt.client.util.JSOHelper::toDouble(D)(ret);
    }-*/;

    protected native Element getAttributeAsElement(String property)/*-{
        var ret;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            var widget = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            ret = widget.getProperty(property);
        } else {
            var config = this.@com.smartgwt.client.widgets.BaseWidget::config;
            if(config[property] !== undefined) {
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
            if(config[property] !== undefined) {
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
            if(config[property] !== undefined) {
                ret = config[property];
            } else {
               var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
               ret = $wnd.isc[scClassName].getInstanceProperty(property);
            }
        }
        return ret == null ? null : @com.smartgwt.client.util.JSOHelper::toFloat(F)(ret);
    }-*/;

    protected native Boolean getAttributeAsBoolean(String property)/*-{
        var ret;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            var widget = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            ret = widget.getProperty(property);
        } else {
            var config = this.@com.smartgwt.client.widgets.BaseWidget::config;
            if(config[property] !== undefined) {
                ret = config[property];
            } else {
               var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
               ret = $wnd.isc[scClassName].getInstanceProperty(property);
            }
        }
        return ret == null ? null : @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(ret);
    }-*/;

    protected native Map getAttributeAsMap(String property)/*-{
        var ret;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            var widget = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            ret = widget.getProperty(property);
        } else {
            var config = this.@com.smartgwt.client.widgets.BaseWidget::config;
            if(config[property] !== undefined) {
                ret = config[property];
            } else {
               var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
               ret = $wnd.isc[scClassName].getInstanceProperty(property);
            }
        }
        return ret == null ? null : @com.smartgwt.client.util.JSOHelper::convertToMap(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

    protected native Record getAttributeAsRecord(String property)/*-{
        var ret;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            var widget = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            ret = widget.getProperty(property);
        } else {
            var config = this.@com.smartgwt.client.widgets.BaseWidget::config;
            if(config[property] !== undefined) {
                ret = config[property];
            } else {
               var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
               ret = $wnd.isc[scClassName].getInstanceProperty(property);
            }
        }
        return ret == null ? null : @com.smartgwt.client.data.Record::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

    private void error(String attribute, String value) throws IllegalStateException {
        error("Cannot change configuration property '" + attribute + "' to " + value + " now that component " + id + " has been created.");
    }

    protected void errorIfNotCreated(String property) throws IllegalStateException {
        if (!isCreated()) {
            throw new IllegalStateException("Cannot access property " + property + " before the widget has been created.");
        }
    }

    protected void error(String message) throws IllegalStateException {
        if (!com.google.gwt.core.client.GWT.isScript()) {
            com.google.gwt.user.client.Window.alert("Error :" + message);
            throw new IllegalStateException(message);
        } else {
            SC.logWarn(message);
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

    protected void setAttribute(String attribute, double[] value, boolean allowPostCreate) {
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

    public void initNativeObject() {
        this.nativeObject = new NativeObject(this);
    }

    // ---------------------------------------
    // Dynamic Properties

    /**
     * Sets up the value of <code>propertyName</code> to be dynamically derived from the
     * {@link com.smartgwt.client.widgets.Canvas#getRuleScope ruleScope}, by either a simple
     * {@link com.smartgwt.client.docs.DataPath} into the ruleScope or via a textual
     * or numeric formula using the ruleScope as available formula inputs.
     * <p>
     * The dataPath or formula is evaluated immediately when addDynamicProperty() is called, then re-evaluated
     * every time the ruleScope changes.
     * <p>
     * It is invalid usage to use <code>addDynamicProperty()</code> on a property that is not runtime settable,
     * however, <code>addDynamicProperty()</code> will not throw an error or log a warning if this is done.
     * <p>
     * If a property is already dynamic and addDynamicProperty() is called again, the new dynamic behavior
     * replaces the old.  If a property should no longer be dynamic, call +link{clearDynamicProperty()}.
     * <p>
     * Dynamic properties can also be declared together via {@link dynamicProperties}.
     *
     * @param propertyName name of a settable property on this instance
     * @param source dataPath
     */
    public native void addDynamicProperty (String propertyName, String source) /*-{
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            var widget = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            widget.addDynamicProperty(propertyName, source);
        } else {
            var config = this.@com.smartgwt.client.widgets.BaseWidget::config;
            if(config["dynamicProperties"] === undefined) {
                config["dynamicProperties"] = {};
            }
            config["dynamicProperties"][propertyName] = (source == null ? null : String(source));
        }
    }-*/;

    /**
     * Sets up the value of <code>propertyName</code> to be dynamically derived from the
     * {@link com.smartgwt.client.widgets.Canvas#getRuleScope ruleScope}, by either a simple
     * {@link com.smartgwt.client.docs.DataPath} into the ruleScope or via a textual
     * or numeric formula using the ruleScope as available formula inputs.
     * <p>
     * The dataPath or formula is evaluated immediately when addDynamicProperty() is called, then re-evaluated
     * every time the ruleScope changes.
     * <p>
     * It is invalid usage to use <code>addDynamicProperty()</code> on a property that is not runtime settable,
     * however, <code>addDynamicProperty()</code> will not throw an error or log a warning if this is done.
     * <p>
     * If a property is already dynamic and addDynamicProperty() is called again, the new dynamic behavior
     * replaces the old.  If a property should no longer be dynamic, call +link{clearDynamicProperty()}.
     * <p>
     * Dynamic properties can also be declared together via {@link dynamicProperties}.
     *
     * @param propertyName name of a settable property on this instance
     * @param source UserFormula
     */
    public native void addDynamicProperty (String propertyName, UserFormula source) /*-{
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            var widget = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            widget.addDynamicProperty(propertyName, source);
        } else {
            var config = this.@com.smartgwt.client.widgets.BaseWidget::config;
            if(config["dynamicProperties"] === undefined) {
                config["dynamicProperties"] = {};
            }
            var jsObj = (source == null ? null : source.@com.smartgwt.client.widgets.UserFormula::getJsObj()());
            config["dynamicProperties"][propertyName] = source;
        }
    }-*/;

    /**
     * Sets up the value of <code>propertyName</code> to be dynamically derived from the
     * {@link com.smartgwt.client.widgets.Canvas#getRuleScope ruleScope}, by either a simple
     * {@link com.smartgwt.client.docs.DataPath} into the ruleScope or via a textual
     * or numeric formula using the ruleScope as available formula inputs.
     * <p>
     * The dataPath or formula is evaluated immediately when addDynamicProperty() is called, then re-evaluated
     * every time the ruleScope changes.
     * <p>
     * It is invalid usage to use <code>addDynamicProperty()</code> on a property that is not runtime settable,
     * however, <code>addDynamicProperty()</code> will not throw an error or log a warning if this is done.
     * <p>
     * If a property is already dynamic and addDynamicProperty() is called again, the new dynamic behavior
     * replaces the old.  If a property should no longer be dynamic, call +link{clearDynamicProperty()}.
     * <p>
     * Dynamic properties can also be declared together via {@link dynamicProperties}.
     *
     * @param propertyName name of a settable property on this instance
     * @param source UserSummary
     */
    public native void addDynamicProperty (String propertyName, UserSummary source) /*-{
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            var widget = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            widget.addDynamicProperty(propertyName, source);
        } else {
            var config = this.@com.smartgwt.client.widgets.BaseWidget::config;
            if(config["dynamicProperties"] === undefined) {
                config["dynamicProperties"] = {};
            }
            var jsObj = (source == null ? null : source.@com.smartgwt.client.widgets.UserSummary::getJsObj()());
            config["dynamicProperties"][propertyName] = source;
        }
    }-*/;


    /**
     * Clears a dynamic property previously established via {@link addDynamicProperty}.
     * <p>
     * If the property is not currently dynamic, nothing will be done (and no warning logged).
     * <p>
     * The current value of the property will not be changed by this call.
     * 
     * @param propertyName name of the dynamic property to clear
     */
    public native void clearDynamicProperty (String propertyName) /*-{
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            var widget = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            widget.clearDynamicProperty(propertyName);
        } else {
            var config = this.@com.smartgwt.client.widgets.BaseWidget::config;
            if(config["dynamicProperties"] !== undefined) {
                delete config["dynamicProperties"][propertyName];
            }
        }
    }-*/;

    /**
     * Returns true if the property is dynamic.
     * 
     * @param propertyName name of the dynamic property to check
     * @return boolean true if the property is dynamic
     */
    public native boolean hasDynamicProperty (String propertyName) /*-{
        var ret = false;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            var widget = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            ret = widget.hasDynamicProperty(propertyName);
        } else {
            var config = this.@com.smartgwt.client.widgets.BaseWidget::config;
            if(config["dynamicProperties"] !== undefined) {
                ret = (config["dynamicProperties"][propertyName] != null);
            }
        }
        return ret;
    }-*/;

    /**
     * Setter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject setLogicalStructure(BaseWidgetLogicalStructure s) {
        s.scClassName = getScClassName();
        return s;
    }

    /**
     * Getter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject getLogicalStructure() {
        BaseWidgetLogicalStructure s = new BaseWidgetLogicalStructure();
        setLogicalStructure(s);
        return s;
    }
}
