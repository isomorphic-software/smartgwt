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
 
package com.smartgwt.client.widgets.rte;


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
import com.smartgwt.client.widgets.tab.*;
import com.smartgwt.client.widgets.toolbar.*;
import com.smartgwt.client.widgets.tree.*;
import com.smartgwt.client.widgets.tree.events.*;
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
import com.smartgwt.logicalstructure.widgets.tab.*;
import com.smartgwt.logicalstructure.widgets.tableview.*;
import com.smartgwt.logicalstructure.widgets.toolbar.*;
import com.smartgwt.logicalstructure.widgets.tree.*;
import com.smartgwt.logicalstructure.widgets.viewer.*;
import com.smartgwt.logicalstructure.widgets.calendar.*;
import com.smartgwt.logicalstructure.widgets.cube.*;
import com.smartgwt.logicalstructure.widgets.tools.*;

/**
 * Pane containing controls for editing the style of HTML lists in a {@link com.smartgwt.client.widgets.RichTextEditor}.
 * <p> Cannot be directly used; shown in documentation only for skinning purposes.
 */
@BeanFactory.FrameworkClass
@BeanFactory.ScClassName("ListPropertiesPane")
public class ListPropertiesPane extends Layout implements com.smartgwt.client.widgets.rte.events.HasListPropertiesChangedHandlers {

    public static ListPropertiesPane getOrCreateRef(JavaScriptObject jsObj) {
        if (jsObj == null) return null;
        final BaseWidget refInstance = BaseWidget.getRef(jsObj);
        if (refInstance == null) {
            return new ListPropertiesPane(jsObj);
        } else {
            assert refInstance instanceof ListPropertiesPane;
            return (ListPropertiesPane)refInstance;
        }
    }


    /**
     * Changes the defaults for Canvas AutoChildren named <code>autoChildName</code>.
     *
     * @param autoChildName name of an AutoChild to customize the defaults for.
     * @param defaults Canvas defaults to apply. These defaults override any existing properties
     * without destroying or wiping out non-overridden properties.
     * @see com.smartgwt.client.docs.AutoChildUsage
     */
    public static native void changeAutoChildDefaults(String autoChildName, Canvas defaults) /*-{
        $wnd.isc.ListPropertiesPane.changeDefaults(autoChildName + "Defaults", defaults.@com.smartgwt.client.widgets.Canvas::getConfig()());
    }-*/;

    /**
     * Changes the defaults for FormItem AutoChildren named <code>autoChildName</code>.
     *
     * @param autoChildName name of an AutoChild to customize the defaults for.
     * @param defaults FormItem defaults to apply. These defaults override any existing properties
     * without destroying or wiping out non-overridden properties.
     * @see com.smartgwt.client.docs.AutoChildUsage
     */
    public static native void changeAutoChildDefaults(String autoChildName, FormItem defaults) /*-{
        $wnd.isc.ListPropertiesPane.changeDefaults(autoChildName + "Defaults", defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getJsObj()());
    }-*/;

    public ListPropertiesPane(){
        scClassName = "ListPropertiesPane";
    }

    public ListPropertiesPane(JavaScriptObject jsObj){
        scClassName = "ListPropertiesPane";
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
     * <b>Note :</b> This API is non-functional (always returns null) and exists only to make
     * you aware that this MultiAutoChild exists.  See {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}
     * for details.
     * <p>
     * Tile used to demonstrate each bullet style.
     *
     * @return null
     */
    public Canvas getSampleTile()  {
        return null;
    }
    

    /**
     * Shows available bullet options as a series of tiles.
     * <p>
     * For an overview of how to use and configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return TileLayout
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public TileLayout getSampleTileLayout() throws IllegalStateException {
        errorIfNotCreated("sampleTileLayout");
        return (TileLayout)TileLayout.getByJSObject(getAttributeAsJavaScriptObject("sampleTileLayout"));
    }
    

    /**
     * {@link com.smartgwt.client.widgets.form.fields.SpinnerItem} used to modify the starting value of the list. <p> {@link
     * com.smartgwt.client.widgets.rte.ListPropertiesPane#getStartNumberFieldTitle startNumberFieldTitle} is a {@link
     * com.smartgwt.client.docs.AutoChildUsage passthrough} for the field's {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getTitle title}.
     * <p>
     * For an overview of how to use and configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return SpinnerItem
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public SpinnerItem getStartNumberField() throws IllegalStateException {
        errorIfNotCreated("startNumberField");
        return SpinnerItem.getOrCreateRef(getAttributeAsJavaScriptObject("startNumberField"));
    }
    

    /**
     * The {@link com.smartgwt.client.widgets.form.fields.FormItem#getTitle title} of the {@link
     * com.smartgwt.client.widgets.rte.ListPropertiesPane#getStartNumberField startNumberField}.
     *
     * @param startNumberFieldTitle  Default value is "Start at"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setStartNumberFieldTitle(String startNumberFieldTitle)  throws IllegalStateException {
        setAttribute("startNumberFieldTitle", startNumberFieldTitle, false);
    }

    /**
     * The {@link com.smartgwt.client.widgets.form.fields.FormItem#getTitle title} of the {@link
     * com.smartgwt.client.widgets.rte.ListPropertiesPane#getStartNumberField startNumberField}.
     *
     * @return String
     */
    public String getStartNumberFieldTitle()  {
        return getAttributeAsString("startNumberFieldTitle");
    }
    

    /**
     * Form used to show the {@link com.smartgwt.client.widgets.rte.ListPropertiesPane#getStartNumberField startNumberField}
     * for configuring the starting value of a list.
     * <p>
     * For an overview of how to use and configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return DynamicForm
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public DynamicForm getStartNumberForm() throws IllegalStateException {
        errorIfNotCreated("startNumberForm");
        return (DynamicForm)DynamicForm.getByJSObject(getAttributeAsJavaScriptObject("startNumberForm"));
    }
    

    // ********************* Methods ***********************
    /**
     * Add a listPropertiesChanged handler.
     * <p>
     * Notification method fired when the pane's {@link com.smartgwt.client.widgets.rte.ListPropertiesPane#getListProperties
     * listProperties} changes.
     *
     * @param handler the listPropertiesChanged handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addListPropertiesChangedHandler(com.smartgwt.client.widgets.rte.events.ListPropertiesChangedHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.rte.events.ListPropertiesChangedEvent.getType()) == 0) setupListPropertiesChangedEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.rte.events.ListPropertiesChangedEvent.getType());
    }

    private native void setupListPropertiesChangedEvent() /*-{
        var obj = null;
        var selfJ = this;
        var listPropertiesChanged = $entry(function(){
            var param = {"listProperties" : arguments[0]};

                var event = @com.smartgwt.client.widgets.rte.events.ListPropertiesChangedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            });
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            obj.addProperties({listPropertiesChanged:  listPropertiesChanged              });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.listPropertiesChanged =  listPropertiesChanged             ;
        }
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
     * @param listPropertiesPaneProperties properties that should be used as new defaults when instances of this class are created
     */
    public static native void setDefaultProperties(ListPropertiesPane listPropertiesPaneProperties) /*-{
    	var properties = $wnd.isc.addProperties({},listPropertiesPaneProperties.@com.smartgwt.client.widgets.BaseWidget::getConfig()());
        @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(properties,false);
        $wnd.isc.ListPropertiesPane.addProperties(properties);
    }-*/;

    // ***********************************************************

    public LogicalStructureObject setLogicalStructure(ListPropertiesPaneLogicalStructure s) {
        super.setLogicalStructure(s);
        try {
            s.startNumberFieldTitle = getAttributeAsString("startNumberFieldTitle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "ListPropertiesPane.startNumberFieldTitle:" + t.getMessage() + "\n";
        }
        return s;
    }

    public LogicalStructureObject getLogicalStructure() {
        ListPropertiesPaneLogicalStructure s = new ListPropertiesPaneLogicalStructure();
        setLogicalStructure(s);
        return s;
    }
}

