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
 
package com.smartgwt.client.tools;


import com.smartgwt.client.event.*;
import com.smartgwt.client.core.*;
import com.smartgwt.client.types.*;
import com.smartgwt.client.data.*;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.data.events.*;
import com.smartgwt.client.browser.window.*;
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
import com.smartgwt.client.widgets.tour.*;
import com.smartgwt.client.widgets.notify.*;
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
import com.smartgwt.client.widgets.notify.*;
import com.smartgwt.client.widgets.drawing.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.gwt.event.shared.*;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.core.client.JavaScriptObject;

import com.smartgwt.client.util.*;
import com.smartgwt.client.util.events.*;
import com.smartgwt.client.util.workflow.*;
import com.smartgwt.client.util.workflow.Process; // required to override java.lang.Process
import com.smartgwt.client.util.tour.*;

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
import com.smartgwt.logicalstructure.widgets.tour.*;

/**
 * A widget for visually editing CSS gradients. <p> <b>Note:</b> this feature requires <a
 * href='https://www.smartclient.com/product/' target='_blank'>Smart GWT Enterprise</a>.
 */
@BeanFactory.FrameworkClass
@BeanFactory.ScClassName("GradientEditor")
public class GradientEditor extends VLayout implements com.smartgwt.client.widgets.tools.events.HasGradientChangedHandlers {

    public static GradientEditor getOrCreateRef(JavaScriptObject jsObj) {
        if (jsObj == null) return null;
        final BaseWidget refInstance = BaseWidget.getRef(jsObj);
        if (refInstance == null) {
            return new GradientEditor(jsObj);
        } else {
            assert refInstance instanceof GradientEditor;
            return (GradientEditor)refInstance;
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(GradientEditor.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "Canvas");
        }
        defaults.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
        var cleanDefaultsJS = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(defaults.@com.smartgwt.client.widgets.BaseWidget::getConfig()(), true);
        $wnd.isc.GradientEditor.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(GradientEditor.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "FormItem");
        }
        defaults.@com.smartgwt.client.widgets.form.fields.FormItem::setConfigOnly(Z)(true);
    	var cleanDefaultsJS = defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getEditorTypeConfig()();
        $wnd.isc.GradientEditor.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
    }-*/;

    public GradientEditor(){
        scClassName = "GradientEditor";
    }

    public GradientEditor(JavaScriptObject jsObj){
        scClassName = "GradientEditor";
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

    /**
     * The angle by which drag-rotating a linear-gradient in the preview should snap.  The  default of 1 means a
     * linear-gradient can be positioned to any exact degree of a circle.
     *
     * @param dragSnapAngle New dragSnapAngle value. Default value is 1
     * @return {@link com.smartgwt.client.tools.GradientEditor GradientEditor} instance, for chaining setter calls
     */
    public GradientEditor setDragSnapAngle(int dragSnapAngle) {
        return (GradientEditor)setAttribute("dragSnapAngle", dragSnapAngle, true);
    }

    /**
     * The angle by which drag-rotating a linear-gradient in the preview should snap.  The  default of 1 means a
     * linear-gradient can be positioned to any exact degree of a circle.
     *
     * @return Current dragSnapAngle value. Default value is 1
     */
    public int getDragSnapAngle()  {
        return getAttributeAsInt("dragSnapAngle");
    }
    

    /**
     * The CSS gradient-statement to work with.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Parses the passed <code>gradient</code> and applies it to the UI for editing.
     *
     * @param gradient CSS gradient string. Default value is null
     * @return {@link com.smartgwt.client.tools.GradientEditor GradientEditor} instance, for chaining setter calls
     */
    public GradientEditor setGradient(String gradient) {
        return (GradientEditor)setAttribute("gradient", gradient, true);
    }

    /**
     * The CSS gradient-statement to work with.
     *
     * @return Returns the current state of the widget as a CSS gradient. Default value is null
     */
    public String getGradient()  {
        return getAttributeAsString("gradient");
    }
    

    /**
     * A DynamicForm that shows the gradient-string produced by this editor.
     * <p>
     * This component is an AutoChild named "outputForm".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current outputForm value. Default value is null
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public DynamicForm getOutputForm() throws IllegalStateException {
        errorIfNotCreated("outputForm");
        return (DynamicForm)DynamicForm.getByJSObject(getAttributeAsJavaScriptObject("outputForm"));
    }
    

    /**
     * An {@link com.smartgwt.client.types.AutoChild} of type {@link com.smartgwt.client.widgets.Canvas}, used to display the
     * gradient according to  the defined color-stops.  The canvas supports drag and click mouse interactions to update a
     * gradient's rotation and origin.
     * <p>
     * This component is an AutoChild named "previewCanvas".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current previewCanvas value. Default value is null
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public Canvas getPreviewCanvas() throws IllegalStateException {
        errorIfNotCreated("previewCanvas");
        return (Canvas)Canvas.getByJSObject(getAttributeAsJavaScriptObject("previewCanvas"));
    }
    

    /**
     * Whether to show the {@link com.smartgwt.client.tools.GradientEditor#getPreviewCanvas preview canvas}, used to display 
     * the gradient.
     *
     * @param showPreviewCanvas New showPreviewCanvas value. Default value is true
     * @return {@link com.smartgwt.client.tools.GradientEditor GradientEditor} instance, for chaining setter calls
     */
    public GradientEditor setShowPreviewCanvas(Boolean showPreviewCanvas) {
        return (GradientEditor)setAttribute("showPreviewCanvas", showPreviewCanvas, true);
    }

    /**
     * Whether to show the {@link com.smartgwt.client.tools.GradientEditor#getPreviewCanvas preview canvas}, used to display 
     * the gradient.
     *
     * @return Current showPreviewCanvas value. Default value is true
     */
    public Boolean getShowPreviewCanvas()  {
        Boolean result = getAttributeAsBoolean("showPreviewCanvas");
        return result == null ? true : result;
    }
    

    // ********************* Methods ***********************
    /**
     * Add a gradientChanged handler.
     * <p>
     * Notification fired whenever a user updates the gradient.
     *
     * @param handler the gradientChanged handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addGradientChangedHandler(com.smartgwt.client.widgets.tools.events.GradientChangedHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.tools.events.GradientChangedEvent.getType()) == 0) setupGradientChangedEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.tools.events.GradientChangedEvent.getType());
    }

    private native void setupGradientChangedEvent() /*-{
        var obj;
        var selfJ = this;
        var hasDefaultHandler;
        var gradientChanged = $entry(function(){
            var param = {"_this": this, "gradient" : arguments[0]};
            var event = @com.smartgwt.client.widgets.tools.events.GradientChangedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            selfJ.@com.smartgwt.client.tools.GradientEditor::handleTearDownGradientChangedEvent()();
            if (hasDefaultHandler) this.Super("gradientChanged", arguments);
        });
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            hasDefaultHandler = $wnd.isc.isA.Function(obj.getProperty("gradientChanged"));
            obj.addProperties({gradientChanged:  gradientChanged              });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
            hasDefaultHandler = $wnd.isc.isA.Function($wnd.isc[scClassName].getInstanceProperty("gradientChanged"));
            obj.gradientChanged =  gradientChanged             ;
        }
    }-*/;

    private void handleTearDownGradientChangedEvent() {
        if (getHandlerCount(com.smartgwt.client.widgets.tools.events.GradientChangedEvent.getType()) == 0) tearDownGradientChangedEvent();
    }

    private native void tearDownGradientChangedEvent() /*-{
        var obj;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }
        if (obj && obj.hasOwnProperty("gradientChanged")) delete obj.gradientChanged;
    }-*/;


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
     * @param gradientEditorProperties properties that should be used as new defaults when instances of this class are created
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public static native void setDefaultProperties(GradientEditor gradientEditorProperties) /*-{
        if (gradientEditorProperties.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Class;)(GradientEditor.@java.lang.Object::getClass()(), "setDefaultProperties", gradientEditorProperties.@java.lang.Object::getClass()());
        }
        gradientEditorProperties.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
    	var properties = gradientEditorProperties.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        properties = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(properties,true);
        $wnd.isc.GradientEditor.addProperties(properties);
    }-*/;

    // ***********************************************************

    /**
     * Setter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject setLogicalStructure(GradientEditorLogicalStructure s) {
        super.setLogicalStructure(s);
        try {
            s.dragSnapAngle = getAttributeAsString("dragSnapAngle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "GradientEditor.dragSnapAngle:" + t.getMessage() + "\n";
        }
        try {
            s.gradient = getAttributeAsString("gradient");
        } catch (Throwable t) {
            s.logicalStructureErrors += "GradientEditor.gradient:" + t.getMessage() + "\n";
        }
        try {
            s.showPreviewCanvas = getAttributeAsString("showPreviewCanvas");
        } catch (Throwable t) {
            s.logicalStructureErrors += "GradientEditor.showPreviewCanvas:" + t.getMessage() + "\n";
        }
        return s;
    }

    /**
     * Getter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject getLogicalStructure() {
        GradientEditorLogicalStructure s = new GradientEditorLogicalStructure();
        setLogicalStructure(s);
        return s;
    }
}
