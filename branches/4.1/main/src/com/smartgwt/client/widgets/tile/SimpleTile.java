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
 
package com.smartgwt.client.widgets.tile;


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
 * Default class used by a {@link com.smartgwt.client.widgets.tile.TileGrid} to render each tile.  See {@link
 * com.smartgwt.client.widgets.tile.TileGrid#getTile tile}. <P> SimpleTiles should not be created directly, instead, use a
 * TileGrid and provide data and SimpleTile instances are created for you.
 */
@BeanFactory.FrameworkClass
@BeanFactory.ScClassName("SimpleTile")
public class SimpleTile extends StatefulCanvas {

    public static SimpleTile getOrCreateRef(JavaScriptObject jsObj) {
        if (jsObj == null) return null;
        final BaseWidget refInstance = BaseWidget.getRef(jsObj);
        if (refInstance == null) {
            return new SimpleTile(jsObj);
        } else {
            assert refInstance instanceof SimpleTile;
            return (SimpleTile)refInstance;
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
        $wnd.isc.SimpleTile.changeDefaults(autoChildName + "Defaults", defaults.@com.smartgwt.client.widgets.Canvas::getConfig()());
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
        $wnd.isc.SimpleTile.changeDefaults(autoChildName + "Defaults", defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getJsObj()());
    }-*/;

    public SimpleTile(){
        scClassName = "SimpleTile";
    }

    public SimpleTile(JavaScriptObject jsObj){
        scClassName = "SimpleTile";
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
     * CSS style for the tile as a whole.  As with {@link com.smartgwt.client.widgets.StatefulCanvas#getBaseStyle baseStyle},
     * suffixes are appended to this style to represent various states ("Over", "Selected", etc).
     *
     * @param baseStyle  See {@link com.smartgwt.client.docs.CSSClassName CSSClassName} . Default value is "simpleTile"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setBaseStyle(String baseStyle)  throws IllegalStateException {
        setAttribute("baseStyle", baseStyle, false);
    }

    /**
     * CSS style for the tile as a whole.  As with {@link com.smartgwt.client.widgets.StatefulCanvas#getBaseStyle baseStyle},
     * suffixes are appended to this style to represent various states ("Over", "Selected", etc).
     *
     * @return  See {@link com.smartgwt.client.docs.CSSClassName CSSClassName} 
     */
    public String getBaseStyle()  {
        return getAttributeAsString("baseStyle");
    }

    /**
     * The {@link com.smartgwt.client.widgets.tile.TileGrid} that created this SimpleTile.
     *
     * @param creator  Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setCreator(TileGrid creator)  throws IllegalStateException {
        setAttribute("creator", creator == null ? null : creator.getOrCreateJsObj(), false);
    }

    /**
     * The {@link com.smartgwt.client.widgets.tile.TileGrid} that created this SimpleTile.
     *
     * @return TileGrid
     */
    public TileGrid getCreator()  {
        return (TileGrid)TileGrid.getByJSObject(getAttributeAsJavaScriptObject("creator"));
    }

    // ********************* Methods ***********************
	/**
     * Return the record that this tile should render. <P> NOTE: a TileGrid that is doing data paging may reuse tiles with
     * different records, so a subclass of SimpleTile should not cache the record returned by getRecord(). <P>
     *
     * @return the TileRecord associated with this tile
     */
    public native TileRecord getRecord() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getRecord();
        if(ret == null) return null;
        return @com.smartgwt.client.widgets.tile.TileRecord::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
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
     * @param simpleTileProperties properties that should be used as new defaults when instances of this class are created
     */
    public static native void setDefaultProperties(SimpleTile simpleTileProperties) /*-{
    	var properties = $wnd.isc.addProperties({},simpleTileProperties.@com.smartgwt.client.widgets.BaseWidget::getConfig()());
        @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(properties,false);
        $wnd.isc.SimpleTile.addProperties(properties);
    }-*/;

    // ***********************************************************

    public LogicalStructureObject setLogicalStructure(SimpleTileLogicalStructure s) {
        super.setLogicalStructure(s);
        try {
            s.baseStyle = getAttributeAsString("baseStyle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "SimpleTile.baseStyle:" + t.getMessage() + "\n";
        }
        try {
            s.creator = getCreator();
        } catch (Throwable t) {
            s.logicalStructureErrors += "SimpleTile.creator:" + t.getMessage() + "\n";
        }
        return s;
    }

    public LogicalStructureObject getLogicalStructure() {
        SimpleTileLogicalStructure s = new SimpleTileLogicalStructure();
        setLogicalStructure(s);
        return s;
    }
}

