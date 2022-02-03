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
import com.smartgwt.client.data.Record;
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

import com.google.gwt.event.shared.*;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.core.client.JavaScriptObject;

import com.smartgwt.client.util.*;
import com.smartgwt.client.util.events.*;
import com.smartgwt.client.util.workflow.*;
import com.smartgwt.client.util.workflow.Process; // required to override java.lang.Process

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
 * The Progressbar widget class extends the StretchImg class to implement image-based progress bars (graphical bars whose
 * lengths represent percentages, typically of task completion).
 */
@BeanFactory.FrameworkClass
@BeanFactory.ScClassName("Progressbar")
public class Progressbar extends StretchImg implements com.smartgwt.client.widgets.events.HasPercentChangedHandlers {

    public static Progressbar getOrCreateRef(JavaScriptObject jsObj) {
        if (jsObj == null) return null;
        final BaseWidget refInstance = BaseWidget.getRef(jsObj);
        if (refInstance == null) {
            return new Progressbar(jsObj);
        } else {
            assert refInstance instanceof Progressbar;
            return (Progressbar)refInstance;
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(Progressbar.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "Canvas");
        }
        defaults.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
        var cleanDefaultsJS = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(defaults.@com.smartgwt.client.widgets.BaseWidget::getConfig()(), true);
        $wnd.isc.Progressbar.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(Progressbar.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "FormItem");
        }
        defaults.@com.smartgwt.client.widgets.form.fields.FormItem::setConfigOnly(Z)(true);
    	var cleanDefaultsJS = defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getEditorTypeConfig()();
        $wnd.isc.Progressbar.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
    }-*/;

    public Progressbar(){
        scClassName = "Progressbar";
    }

    public Progressbar(JavaScriptObject jsObj){
        scClassName = "Progressbar";
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
     * {@link com.smartgwt.client.widgets.StatefulCanvas#getBaseStyle Base style} for this Progressbar.  Only used when  {@link
     * com.smartgwt.client.widgets.Progressbar#getUseCssStyles useCssStyles} is true.
     *
     * @param baseStyle New baseStyle value. Default value is "progressbar"
     * @return {@link com.smartgwt.client.widgets.Progressbar Progressbar} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public Progressbar setBaseStyle(String baseStyle)  throws IllegalStateException {
        return (Progressbar)setAttribute("baseStyle", baseStyle, false);
    }

    /**
     * {@link com.smartgwt.client.widgets.StatefulCanvas#getBaseStyle Base style} for this Progressbar.  Only used when  {@link
     * com.smartgwt.client.widgets.Progressbar#getUseCssStyles useCssStyles} is true.
     *
     * @return Current baseStyle value. Default value is "progressbar"
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public String getBaseStyle()  {
        return getAttributeAsString("baseStyle");
    }
    

    /**
     * Thickness of the progressbar in pixels. This is effectively width for a vertical progressbar, or height for a horizontal
     * progressbar. <P> This property must be set instead of setting <code>width</code> or <code>height</code>.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets the breadth of the progressbar to newLength. This is the height of a horizontal progressbar, or the width of a vertical progressbar.
     *
     * @param breadth the new breadth of the progressbar. Default value is 20
     * @return {@link com.smartgwt.client.widgets.Progressbar Progressbar} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Progressbar setBreadth(int breadth) {
        return (Progressbar)setAttribute("breadth", breadth, true);
    }

    /**
     * Thickness of the progressbar in pixels. This is effectively width for a vertical progressbar, or height for a horizontal
     * progressbar. <P> This property must be set instead of setting <code>width</code> or <code>height</code>.
     *
     * @return Returns the current height of a horizontal progressbar, or width of a vertical progressbar. Default value is 20
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public int getBreadth()  {
        return getAttributeAsInt("breadth");
    }
    

    /**
     * Default class used to construct the {@link com.smartgwt.client.tools.EditProxy} for this component when the component is
     * {@link com.smartgwt.client.widgets.Canvas#setEditMode first placed into edit mode}.
     *
     * @param editProxyConstructor New editProxyConstructor value. Default value is "ProgressbarProxy"
     * @return {@link com.smartgwt.client.widgets.Progressbar Progressbar} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.SCClassName SCClassName 
     */
    public Progressbar setEditProxyConstructor(String editProxyConstructor)  throws IllegalStateException {
        return (Progressbar)setAttribute("editProxyConstructor", editProxyConstructor, false);
    }

    /**
     * Default class used to construct the {@link com.smartgwt.client.tools.EditProxy} for this component when the component is
     * {@link com.smartgwt.client.widgets.Canvas#setEditMode first placed into edit mode}.
     *
     * @return Current editProxyConstructor value. Default value is "ProgressbarProxy"
     * @see com.smartgwt.client.docs.SCClassName SCClassName 
     */
    public String getEditProxyConstructor()  {
        return getAttributeAsString("editProxyConstructor");
    }
    

    /**
     * Length of the progressbar in pixels. This is effectively height for a vertical progressbar, or width for a horizontal
     * progressbar. <P> This property must be set instead of setting <code>width</code> or <code>height</code>.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets the length of the progressbar to newLength. This is the width of a horizontal progressbar, or the height of a vertical progressbar.
     *
     * @param length the new length of the progressbar. Default value is 100
     * @return {@link com.smartgwt.client.widgets.Progressbar Progressbar} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Progressbar setLength(int length) {
        return (Progressbar)setAttribute("length", length, true);
    }

    /**
     * Length of the progressbar in pixels. This is effectively height for a vertical progressbar, or width for a horizontal
     * progressbar. <P> This property must be set instead of setting <code>width</code> or <code>height</code>.
     *
     * @return Returns the current width of a horizontal progressbar, or height of a vertical progressbar. Default value is 100
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public int getLength()  {
        return getAttributeAsInt("length");
    }

    /**
     * Length of the progressbar in pixels. This is effectively height for a vertical progressbar, or width for a horizontal
     * progressbar. <P> This property must be set instead of setting <code>width</code> or <code>height</code>.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets the length of the progressbar to newLength. This is the width of a horizontal progressbar, or the height of a vertical progressbar.
     *
     * @param length the new length of the progressbar. Default value is 100
     * @return {@link com.smartgwt.client.widgets.Progressbar Progressbar} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Progressbar setLength(String length) {
        return (Progressbar)setAttribute("length", length, true);
    }
    

    /**
     * Number from 0 to 100, inclusive, for the percentage to be displayed graphically in this progressbar.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets percentDone to newPercent.
     *
     * @param percentDone percent to show as done (0-100). Default value is 0
     * @return {@link com.smartgwt.client.widgets.Progressbar Progressbar} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Progressbar setPercentDone(int percentDone) {
        return (Progressbar)setAttribute("percentDone", percentDone, true);
    }

    /**
     * Number from 0 to 100, inclusive, for the percentage to be displayed graphically in this progressbar.
     *
     * @return Current percentDone value. Default value is 0
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public int getPercentDone()  {
        return getAttributeAsInt("percentDone");
    }
    

    /**
     * {@link com.smartgwt.client.widgets.StatefulCanvas#getBaseStyle Base style} used to style the percentage-done portion of
     * this Progressbar.  Only used when {@link com.smartgwt.client.widgets.Progressbar#getUseCssStyles useCssStyles} is true.
     *
     * @param progressStyle New progressStyle value. Default value is "progressbarProgress"
     * @return {@link com.smartgwt.client.widgets.Progressbar Progressbar} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public Progressbar setProgressStyle(String progressStyle)  throws IllegalStateException {
        return (Progressbar)setAttribute("progressStyle", progressStyle, false);
    }

    /**
     * {@link com.smartgwt.client.widgets.StatefulCanvas#getBaseStyle Base style} used to style the percentage-done portion of
     * this Progressbar.  Only used when {@link com.smartgwt.client.widgets.Progressbar#getUseCssStyles useCssStyles} is true.
     *
     * @return Current progressStyle value. Default value is "progressbarProgress"
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public String getProgressStyle()  {
        return getAttributeAsString("progressStyle");
    }
    

    /**
     * The base file name for the progressbar image.
     *
     * @param src New src value. Default value is "[SKIN]progressbar.gif"
     * @return {@link com.smartgwt.client.widgets.Progressbar Progressbar} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Progressbar setSrc(String src) {
        return (Progressbar)setAttribute("src", src, true);
    }

    /**
     * The base file name for the progressbar image.
     *
     * @return Current src value. Default value is "[SKIN]progressbar.gif"
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getSrc()  {
        return getAttributeAsString("src");
    }
    

    /**
     * When set to true, styles the Progressbar via the {@link com.smartgwt.client.widgets.Progressbar#getBaseStyle base} and 
     * {@link com.smartgwt.client.widgets.Progressbar#getProgressStyle progress} CSS styles.
     *
     * @param useCssStyles New useCssStyles value. Default value is false
     * @return {@link com.smartgwt.client.widgets.Progressbar Progressbar} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public Progressbar setUseCssStyles(boolean useCssStyles)  throws IllegalStateException {
        return (Progressbar)setAttribute("useCssStyles", useCssStyles, false);
    }

    /**
     * When set to true, styles the Progressbar via the {@link com.smartgwt.client.widgets.Progressbar#getBaseStyle base} and 
     * {@link com.smartgwt.client.widgets.Progressbar#getProgressStyle progress} CSS styles.
     *
     * @return Current useCssStyles value. Default value is false
     */
    public boolean getUseCssStyles()  {
        Boolean result = getAttributeAsBoolean("useCssStyles");
        return result == null ? false : result;
    }
    

    /**
     * Indicates whether this is a vertical or horizontal progressbar.
     *
     * @param vertical New vertical value. Default value is false
     * @return {@link com.smartgwt.client.widgets.Progressbar Progressbar} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Progressbar setVertical(Boolean vertical) {
        return (Progressbar)setAttribute("vertical", vertical, true);
    }

    /**
     * Indicates whether this is a vertical or horizontal progressbar.
     *
     * @return Current vertical value. Default value is false
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Boolean getVertical()  {
        Boolean result = getAttributeAsBoolean("vertical");
        return result == null ? false : result;
    }
    

    // ********************* Methods ***********************
    /**
     * Add a percentChanged handler.
     * <p>
     * This method is called when the percentDone value changes.  Call this method to be notified upon a change to the
     * percentDone value.
     *
     * @param handler the percentChanged handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addPercentChangedHandler(com.smartgwt.client.widgets.events.PercentChangedHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.events.PercentChangedEvent.getType()) == 0) setupPercentChangedEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.events.PercentChangedEvent.getType());
    }

    private native void setupPercentChangedEvent() /*-{
        var obj;
        var selfJ = this;
        var hasDefaultHandler;
        var percentChanged = $entry(function(){
            var param = {"_this": this};
            var event = @com.smartgwt.client.widgets.events.PercentChangedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            selfJ.@com.smartgwt.client.widgets.Progressbar::handleTearDownPercentChangedEvent()();
            if (hasDefaultHandler) this.Super("percentChanged", arguments);
        });
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            hasDefaultHandler = $wnd.isc.isA.Function(obj.getProperty("percentChanged"));
            obj.addProperties({percentChanged:  percentChanged              });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
            hasDefaultHandler = $wnd.isc.isA.Function($wnd.isc[scClassName].getInstanceProperty("percentChanged"));
            obj.percentChanged =  percentChanged             ;
        }
    }-*/;

    private void handleTearDownPercentChangedEvent() {
        if (getHandlerCount(com.smartgwt.client.widgets.events.PercentChangedEvent.getType()) == 0) tearDownPercentChangedEvent();
    }

    private native void tearDownPercentChangedEvent() /*-{
        var obj;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }
        if (obj && obj.hasOwnProperty("percentChanged")) delete obj.percentChanged;
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
     * @param progressbarProperties properties that should be used as new defaults when instances of this class are created
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public static native void setDefaultProperties(Progressbar progressbarProperties) /*-{
        if (progressbarProperties.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Class;)(Progressbar.@java.lang.Object::getClass()(), "setDefaultProperties", progressbarProperties.@java.lang.Object::getClass()());
        }
        progressbarProperties.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
    	var properties = progressbarProperties.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        properties = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(properties,true);
        $wnd.isc.Progressbar.addProperties(properties);
    }-*/;

    // ***********************************************************


    
    public String getLengthAsString()  {
        return getAttributeAsString("length");
    }

    /**
     * Setter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject setLogicalStructure(ProgressbarLogicalStructure s) {
        super.setLogicalStructure(s);
        try {
            s.baseStyle = getAttributeAsString("baseStyle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Progressbar.baseStyle:" + t.getMessage() + "\n";
        }
        try {
            s.breadth = getAttributeAsString("breadth");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Progressbar.breadth:" + t.getMessage() + "\n";
        }
        try {
            s.editProxyConstructor = getAttributeAsString("editProxyConstructor");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Progressbar.editProxyConstructor:" + t.getMessage() + "\n";
        }
        try {
            s.percentDone = getAttributeAsString("percentDone");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Progressbar.percentDone:" + t.getMessage() + "\n";
        }
        try {
            s.progressStyle = getAttributeAsString("progressStyle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Progressbar.progressStyle:" + t.getMessage() + "\n";
        }
        try {
            s.src = getAttributeAsString("src");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Progressbar.src:" + t.getMessage() + "\n";
        }
        try {
            s.useCssStyles = getAttributeAsString("useCssStyles");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Progressbar.useCssStyles:" + t.getMessage() + "\n";
        }
        try {
            s.vertical = getAttributeAsString("vertical");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Progressbar.vertical:" + t.getMessage() + "\n";
        }
        return s;
    }

    /**
     * Getter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject getLogicalStructure() {
        ProgressbarLogicalStructure s = new ProgressbarLogicalStructure();
        setLogicalStructure(s);
        return s;
    }
}
