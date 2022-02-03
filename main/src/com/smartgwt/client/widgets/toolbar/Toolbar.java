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
 
package com.smartgwt.client.widgets.toolbar;


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
 * A Toolbar creates a vertical or horizontal strip of similar components (typically Buttons) and provides managed resizing
 * and reordering behavior over those components. <p> If you are creating a bar with a mixture of different elements (eg
 * some MenuButtons, some Labels, some Buttons, some custom components), you want to use a {@link
 * com.smartgwt.client.widgets.toolbar.ToolStrip}.  A Toolbar is better suited for managing a set of highly similar,
 * interchangeable components, such as ListGrid headers.
 */
@BeanFactory.FrameworkClass
@BeanFactory.ScClassName("Toolbar")
public class Toolbar extends Layout implements com.smartgwt.client.widgets.toolbar.events.HasItemDragResizedHandlers, com.smartgwt.client.widgets.toolbar.events.HasItemClickHandlers {

    public static Toolbar getOrCreateRef(JavaScriptObject jsObj) {
        if (jsObj == null) return null;
        final BaseWidget refInstance = BaseWidget.getRef(jsObj);
        if (refInstance == null) {
            return new Toolbar(jsObj);
        } else {
            assert refInstance instanceof Toolbar;
            return (Toolbar)refInstance;
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(Toolbar.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "Canvas");
        }
        defaults.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
        var cleanDefaultsJS = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(defaults.@com.smartgwt.client.widgets.BaseWidget::getConfig()(), true);
        $wnd.isc.Toolbar.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(Toolbar.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "FormItem");
        }
        defaults.@com.smartgwt.client.widgets.form.fields.FormItem::setConfigOnly(Z)(true);
    	var cleanDefaultsJS = defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getEditorTypeConfig()();
        $wnd.isc.Toolbar.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
    }-*/;

    public Toolbar(){
        scClassName = "Toolbar";
    }

    public Toolbar(JavaScriptObject jsObj){
        scClassName = "Toolbar";
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
     * If true, items (buttons) can be dropped into this toolbar, and the toolbar will show a drop line at the drop location. 
     * Override drop() to decide what happens when the item is dropped.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param canAcceptDrop New canAcceptDrop value. Default value is false
     * @return {@link com.smartgwt.client.widgets.toolbar.Toolbar Toolbar} instance, for chaining setter calls
     */
    public Toolbar setCanAcceptDrop(Boolean canAcceptDrop) {
        return (Toolbar)setAttribute("canAcceptDrop", canAcceptDrop, true);
    }

    /**
     * If true, items (buttons) can be dropped into this toolbar, and the toolbar will show a drop line at the drop location. 
     * Override drop() to decide what happens when the item is dropped.
     *
     * @return Current canAcceptDrop value. Default value is false
     */
    public Boolean getCanAcceptDrop()  {
        Boolean result = getAttributeAsBoolean("canAcceptDrop");
        return result == null ? false : result;
    }
    

    /**
     * If true, items can be reordered by dragging on them.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param canReorderItems New canReorderItems value. Default value is false
     * @return {@link com.smartgwt.client.widgets.toolbar.Toolbar Toolbar} instance, for chaining setter calls
     */
    public Toolbar setCanReorderItems(Boolean canReorderItems) {
        return (Toolbar)setAttribute("canReorderItems", canReorderItems, true);
    }

    /**
     * If true, items can be reordered by dragging on them.
     *
     * @return Current canReorderItems value. Default value is false
     */
    public Boolean getCanReorderItems()  {
        Boolean result = getAttributeAsBoolean("canReorderItems");
        return result == null ? false : result;
    }
    

    /**
     * If true, items (buttons) can be resized by dragging on them.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Setter for updating {@link com.smartgwt.client.widgets.toolbar.Toolbar#getCanResizeItems canResizeItems} at runtime.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param canResizeItems New value for this.canResizeItems. Default value is false
     * @return {@link com.smartgwt.client.widgets.toolbar.Toolbar Toolbar} instance, for chaining setter calls
     */
    public Toolbar setCanResizeItems(Boolean canResizeItems) {
        return (Toolbar)setAttribute("canResizeItems", canResizeItems, true);
    }

    /**
     * If true, items (buttons) can be resized by dragging on them.
     *
     * @return Current canResizeItems value. Default value is false
     */
    public Boolean getCanResizeItems()  {
        Boolean result = getAttributeAsBoolean("canResizeItems");
        return result == null ? false : result;
    }
    

    /**
     * If set to true, causes child buttons to be created during initialization, instead of waiting until draw(). <p> This
     * property principally exists for backwards compatibility; the default behavior of waiting  until draw makes certain
     * pre-draw operations more efficient (such as adding, removing or  reordering buttons).  However, if you have code that
     * assumes Buttons are created early and crashes if they are not, <code>createButtonsOnInit</code> will allow that code to
     * continue working, with a minor performance penalty.
     *
     * @param createButtonsOnInit New createButtonsOnInit value. Default value is null
     * @return {@link com.smartgwt.client.widgets.toolbar.Toolbar Toolbar} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public Toolbar setCreateButtonsOnInit(Boolean createButtonsOnInit)  throws IllegalStateException {
        return (Toolbar)setAttribute("createButtonsOnInit", createButtonsOnInit, false);
    }

    /**
     * If set to true, causes child buttons to be created during initialization, instead of waiting until draw(). <p> This
     * property principally exists for backwards compatibility; the default behavior of waiting  until draw makes certain
     * pre-draw operations more efficient (such as adding, removing or  reordering buttons).  However, if you have code that
     * assumes Buttons are created early and crashes if they are not, <code>createButtonsOnInit</code> will allow that code to
     * continue working, with a minor performance penalty.
     *
     * @return Current createButtonsOnInit value. Default value is null
     */
    public Boolean getCreateButtonsOnInit()  {
        return getAttributeAsBoolean("createButtonsOnInit");
    }
    

    /**
     * Indicates whether the buttons are drawn horizontally from left to right (false), or vertically from top to bottom
     * (true).
     *
     * @param vertical New vertical value. Default value is false
     * @return {@link com.smartgwt.client.widgets.toolbar.Toolbar Toolbar} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Toolbar setVertical(Boolean vertical) {
        return (Toolbar)setAttribute("vertical", vertical, true);
    }

    /**
     * Indicates whether the buttons are drawn horizontally from left to right (false), or vertically from top to bottom
     * (true).
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
     * Called when one of the buttons receives a double-click event
     * @param item pointer to the button in question
     * @param itemNum number of the button in question
     */
    public native void itemDoubleClick(Button item, int itemNum) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "itemDoubleClick", "Button,int");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.itemDoubleClick(item == null ? null : item.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()(), itemNum);
    }-*/;

    /**
     * Add a itemDragResized handler.
     * <p>
     * Called when one of the Toolbar buttons is drag resized.
     *
     * @param handler the itemDragResized handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addItemDragResizedHandler(com.smartgwt.client.widgets.toolbar.events.ItemDragResizedHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.toolbar.events.ItemResizedEvent.getType()) == 0) setupItemDragResizedEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.toolbar.events.ItemResizedEvent.getType());
    }

    private native void setupItemDragResizedEvent() /*-{
        var obj;
        var selfJ = this;
        var hasDefaultHandler;
        var itemDragResized = $entry(function(){
            var param = {"_this": this, "itemNum" : arguments[0], "newSize" : arguments[1]};
            var event = @com.smartgwt.client.widgets.toolbar.events.ItemResizedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            selfJ.@com.smartgwt.client.widgets.toolbar.Toolbar::handleTearDownItemDragResizedEvent()();
            if (hasDefaultHandler) this.Super("itemDragResized", arguments);
        });
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            hasDefaultHandler = $wnd.isc.isA.Function(obj.getProperty("itemDragResized"));
            obj.addProperties({itemDragResized:  itemDragResized              });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
            hasDefaultHandler = $wnd.isc.isA.Function($wnd.isc[scClassName].getInstanceProperty("itemDragResized"));
            obj.itemDragResized =  itemDragResized             ;
        }
    }-*/;

    private void handleTearDownItemDragResizedEvent() {
        if (getHandlerCount(com.smartgwt.client.widgets.toolbar.events.ItemResizedEvent.getType()) == 0) tearDownItemDragResizedEvent();
    }

    private native void tearDownItemDragResizedEvent() /*-{
        var obj;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }
        if (obj && obj.hasOwnProperty("itemDragResized")) delete obj.itemDragResized;
    }-*/;

    /**
     * Add a itemClick handler.
     * <p>
     * Called when one of the buttons receives a click event.
     *
     * @param handler the itemClick handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addItemClickHandler(com.smartgwt.client.widgets.toolbar.events.ItemClickHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.toolbar.events.ItemClickEvent.getType()) == 0) setupItemClickEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.toolbar.events.ItemClickEvent.getType());
    }

    private native void setupItemClickEvent() /*-{
        var obj;
        var selfJ = this;
        var hasDefaultHandler;
        var itemClick = $entry(function(){
            var param = {"_this": this, "targetCanvas" : arguments[0], "itemNum" : arguments[1]};
            var event = @com.smartgwt.client.widgets.toolbar.events.ItemClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            selfJ.@com.smartgwt.client.widgets.toolbar.Toolbar::handleTearDownItemClickEvent()();
            if (hasDefaultHandler) this.Super("itemClick", arguments);
        });
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            hasDefaultHandler = $wnd.isc.isA.Function(obj.getProperty("itemClick"));
            obj.addProperties({itemClick:  itemClick              });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
            hasDefaultHandler = $wnd.isc.isA.Function($wnd.isc[scClassName].getInstanceProperty("itemClick"));
            obj.itemClick =  itemClick             ;
        }
    }-*/;

    private void handleTearDownItemClickEvent() {
        if (getHandlerCount(com.smartgwt.client.widgets.toolbar.events.ItemClickEvent.getType()) == 0) tearDownItemClickEvent();
    }

    private native void tearDownItemClickEvent() /*-{
        var obj;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }
        if (obj && obj.hasOwnProperty("itemClick")) delete obj.itemClick;
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
     * @param toolbarProperties properties that should be used as new defaults when instances of this class are created
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public static native void setDefaultProperties(Toolbar toolbarProperties) /*-{
        if (toolbarProperties.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Class;)(Toolbar.@java.lang.Object::getClass()(), "setDefaultProperties", toolbarProperties.@java.lang.Object::getClass()());
        }
        toolbarProperties.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
    	var properties = toolbarProperties.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        properties = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(properties,true);
        $wnd.isc.Toolbar.addProperties(properties);
    }-*/;

    // ***********************************************************

    /**
     * Setter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject setLogicalStructure(ToolbarLogicalStructure s) {
        super.setLogicalStructure(s);
        try {
            s.canAcceptDrop = getAttributeAsString("canAcceptDrop");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Toolbar.canAcceptDrop:" + t.getMessage() + "\n";
        }
        try {
            s.canReorderItems = getAttributeAsString("canReorderItems");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Toolbar.canReorderItems:" + t.getMessage() + "\n";
        }
        try {
            s.canResizeItems = getAttributeAsString("canResizeItems");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Toolbar.canResizeItems:" + t.getMessage() + "\n";
        }
        try {
            s.createButtonsOnInit = getAttributeAsString("createButtonsOnInit");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Toolbar.createButtonsOnInit:" + t.getMessage() + "\n";
        }
        try {
            s.vertical = getAttributeAsString("vertical");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Toolbar.vertical:" + t.getMessage() + "\n";
        }
        return s;
    }

    /**
     * Getter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject getLogicalStructure() {
        ToolbarLogicalStructure s = new ToolbarLogicalStructure();
        setLogicalStructure(s);
        return s;
    }
}
