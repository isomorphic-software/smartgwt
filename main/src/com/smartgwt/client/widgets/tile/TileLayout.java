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
 * Lays out a series of components, called "tiles", in a grid with multiple tiles per row.
 */
@BeanFactory.FrameworkClass
@BeanFactory.ScClassName("TileLayout")
public class TileLayout extends Canvas {

    public static TileLayout getOrCreateRef(JavaScriptObject jsObj) {
        if (jsObj == null) return null;
        final BaseWidget refInstance = BaseWidget.getRef(jsObj);
        if (refInstance == null) {
            return new TileLayout(jsObj);
        } else {
            assert refInstance instanceof TileLayout;
            return (TileLayout)refInstance;
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(TileLayout.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "Canvas");
        }
        defaults.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
        var cleanDefaultsJS = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(defaults.@com.smartgwt.client.widgets.BaseWidget::getConfig()(), true);
        $wnd.isc.TileLayout.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(TileLayout.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "FormItem");
        }
        defaults.@com.smartgwt.client.widgets.form.fields.FormItem::setConfigOnly(Z)(true);
    	var cleanDefaultsJS = defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getEditorTypeConfig()();
        $wnd.isc.TileLayout.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
    }-*/;

    public TileLayout(){
        scClassName = "TileLayout";
    }

    public TileLayout(JavaScriptObject jsObj){
        scClassName = "TileLayout";
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
     * If set, tiles animate to their new positions when a tile is added, removed, or reordered via drag and drop.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param animateTileChange New animateTileChange value. Default value is true
     * @return {@link com.smartgwt.client.widgets.tile.TileLayout TileLayout} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public TileLayout setAnimateTileChange(Boolean animateTileChange) {
        return (TileLayout)setAttribute("animateTileChange", animateTileChange, true);
    }

    /**
     * If set, tiles animate to their new positions when a tile is added, removed, or reordered via drag and drop.
     *
     * @return Current animateTileChange value. Default value is true
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Boolean getAnimateTileChange()  {
        Boolean result = getAttributeAsBoolean("animateTileChange");
        return result == null ? true : result;
    }
    

    /**
     * When {@link com.smartgwt.client.types.LayoutPolicy} is "flow", should we automatically start a new line when there's not
     * enough room to fit the next tile on the same line? <P> If set to false, a new line will only be started if a tile
     * specifies {@link com.smartgwt.client.widgets.Canvas#getStartLine tile.startLine} or {@link
     * com.smartgwt.client.widgets.Canvas#getEndLine tile.endLine}.
     *
     * @param autoWrapLines New autoWrapLines value. Default value is true
     * @return {@link com.smartgwt.client.widgets.tile.TileLayout TileLayout} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public TileLayout setAutoWrapLines(Boolean autoWrapLines)  throws IllegalStateException {
        return (TileLayout)setAttribute("autoWrapLines", autoWrapLines, false);
    }

    /**
     * When {@link com.smartgwt.client.types.LayoutPolicy} is "flow", should we automatically start a new line when there's not
     * enough room to fit the next tile on the same line? <P> If set to false, a new line will only be started if a tile
     * specifies {@link com.smartgwt.client.widgets.Canvas#getStartLine tile.startLine} or {@link
     * com.smartgwt.client.widgets.Canvas#getEndLine tile.endLine}.
     *
     * @return Current autoWrapLines value. Default value is true
     */
    public Boolean getAutoWrapLines()  {
        Boolean result = getAttributeAsBoolean("autoWrapLines");
        return result == null ? true : result;
    }
    

    /**
     * Indicates what to do with data dragged into another DataBoundComponent. See DragDataAction type for details.
     *
     * @param dragDataAction New dragDataAction value. Default value is Canvas.MOVE
     * @return {@link com.smartgwt.client.widgets.tile.TileLayout TileLayout} instance, for chaining setter calls
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#grid_interaction_drag_move" target="examples">Drag move Example</a>
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#grid_interaction_drag_copy" target="examples">Drag copy Example</a>
     */
    public TileLayout setDragDataAction(DragDataAction dragDataAction) {
        return (TileLayout)setAttribute("dragDataAction", dragDataAction == null ? null : dragDataAction.getValue(), true);
    }

    /**
     * Indicates what to do with data dragged into another DataBoundComponent. See DragDataAction type for details.
     *
     * @return Current dragDataAction value. Default value is Canvas.MOVE
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#grid_interaction_drag_move" target="examples">Drag move Example</a>
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#grid_interaction_drag_copy" target="examples">Drag copy Example</a>
     */
    public DragDataAction getDragDataAction()  {
        return EnumUtil.getEnum(DragDataAction.values(), getAttribute("dragDataAction"));
    }
    

    /**
     * Canvas used to display a drop indicator when a another canvas is dragged over this widget.
     * <p>
     * This component is an AutoChild named "dragLine".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current dragLine value. Default value is null
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public Canvas getDragLine() throws IllegalStateException {
        errorIfNotCreated("dragLine");
        return (Canvas)Canvas.getByJSObject(getAttributeAsJavaScriptObject("dragLine"));
    }
    

    /**
     * With {@link com.smartgwt.client.types.LayoutPolicy}:"fit", should margins be expanded so that tiles fill the available
     * space in the TileLayout on the breadth axis? This can also affect {@link
     * com.smartgwt.client.widgets.tile.TileLayout#getTileWidth tileWidth} or {@link
     * com.smartgwt.client.widgets.tile.TileLayout#getTileHeight tileHeight}. See those properties for details.
     *
     * @param expandMargins New expandMargins value. Default value is true
     * @return {@link com.smartgwt.client.widgets.tile.TileLayout TileLayout} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public TileLayout setExpandMargins(Boolean expandMargins)  throws IllegalStateException {
        return (TileLayout)setAttribute("expandMargins", expandMargins, false);
    }

    /**
     * With {@link com.smartgwt.client.types.LayoutPolicy}:"fit", should margins be expanded so that tiles fill the available
     * space in the TileLayout on the breadth axis? This can also affect {@link
     * com.smartgwt.client.widgets.tile.TileLayout#getTileWidth tileWidth} or {@link
     * com.smartgwt.client.widgets.tile.TileLayout#getTileHeight tileHeight}. See those properties for details.
     *
     * @return Current expandMargins value. Default value is true
     */
    public Boolean getExpandMargins()  {
        Boolean result = getAttributeAsBoolean("expandMargins");
        return result == null ? true : result;
    }
    

    /**
     * A margin left around the outside of all tiles.
     *
     * @param layoutMargin New layoutMargin value. Default value is 5
     * @return {@link com.smartgwt.client.widgets.tile.TileLayout TileLayout} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public TileLayout setLayoutMargin(Integer layoutMargin)  throws IllegalStateException {
        return (TileLayout)setAttribute("layoutMargin", layoutMargin, false);
    }

    /**
     * A margin left around the outside of all tiles.
     *
     * @return Current layoutMargin value. Default value is 5
     */
    public Integer getLayoutMargin()  {
        return getAttributeAsInt("layoutMargin");
    }
    
    

    /**
     * Direction of tiling.  See also {@link com.smartgwt.client.types.TileLayoutPolicy}.
     *
     * @param orientation New orientation value. Default value is "horizontal"
     * @return {@link com.smartgwt.client.widgets.tile.TileLayout TileLayout} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public TileLayout setOrientation(Orientation orientation)  throws IllegalStateException {
        return (TileLayout)setAttribute("orientation", orientation == null ? null : orientation.getValue(), false);
    }

    /**
     * Direction of tiling.  See also {@link com.smartgwt.client.types.TileLayoutPolicy}.
     *
     * @return Current orientation value. Default value is "horizontal"
     */
    public Orientation getOrientation()  {
        return EnumUtil.getEnum(Orientation.values(), getAttribute("orientation"));
    }
    

    /**
     * Normal {@link com.smartgwt.client.types.Overflow} settings can be used on TileLayouts, for example, an overflow:auto
     * TileLayout will scroll if members exceed its specified size, whereas an overflow:visible TileLayout will grow to
     * accommodate members.
     *
     * @param overflow New overflow value. Default value is "auto"
     * @return {@link com.smartgwt.client.widgets.tile.TileLayout TileLayout} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.Sizing Sizing overview and related methods
     */
    public TileLayout setOverflow(Overflow overflow) {
        return (TileLayout)setAttribute("overflow", overflow == null ? null : overflow.getValue(), true);
    }

    /**
     * Normal {@link com.smartgwt.client.types.Overflow} settings can be used on TileLayouts, for example, an overflow:auto
     * TileLayout will scroll if members exceed its specified size, whereas an overflow:visible TileLayout will grow to
     * accommodate members.
     *
     * @return Current overflow value. Default value is "auto"
     * @see com.smartgwt.client.docs.Sizing Sizing overview and related methods
     */
    public Overflow getOverflow()  {
        return EnumUtil.getEnum(Overflow.values(), getAttribute("overflow"));
    }
    

    /**
     * If this widget has padding specified (as {@link com.smartgwt.client.widgets.Canvas#getPadding this.padding} or in the
     * CSS style applied to this layout), should it show up as space outside the members, similar to layoutMargin? <P> If this
     * setting is false, padding will not affect member positioning (as CSS padding normally does not affect absolutely
     * positioned children).  Leaving this setting true allows a designer to more effectively control layout purely from CSS.
     * <P> Note that {@link com.smartgwt.client.widgets.layout.Layout#getLayoutMargin Layout.layoutMargin} if specified, takes
     * precedence over this value.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param paddingAsLayoutMargin New paddingAsLayoutMargin value. Default value is true
     * @return {@link com.smartgwt.client.widgets.tile.TileLayout TileLayout} instance, for chaining setter calls
     */
    public TileLayout setPaddingAsLayoutMargin(Boolean paddingAsLayoutMargin) {
        return (TileLayout)setAttribute("paddingAsLayoutMargin", paddingAsLayoutMargin, true);
    }

    /**
     * If this widget has padding specified (as {@link com.smartgwt.client.widgets.Canvas#getPadding this.padding} or in the
     * CSS style applied to this layout), should it show up as space outside the members, similar to layoutMargin? <P> If this
     * setting is false, padding will not affect member positioning (as CSS padding normally does not affect absolutely
     * positioned children).  Leaving this setting true allows a designer to more effectively control layout purely from CSS.
     * <P> Note that {@link com.smartgwt.client.widgets.layout.Layout#getLayoutMargin Layout.layoutMargin} if specified, takes
     * precedence over this value.
     *
     * @return Current paddingAsLayoutMargin value. Default value is true
     */
    public Boolean getPaddingAsLayoutMargin()  {
        Boolean result = getAttributeAsBoolean("paddingAsLayoutMargin");
        return result == null ? true : result;
    }
    

    /**
     * Height of each tile in pixels.  See {@link com.smartgwt.client.widgets.tile.TileLayout#getTileSize tileSize}. If {@link
     * com.smartgwt.client.types.LayoutPolicy} is "fit", {@link com.smartgwt.client.widgets.tile.TileLayout#getExpandMargins
     * expandMargins} is false, {@link com.smartgwt.client.widgets.tile.TileLayout#getTilesPerLine tilesPerLine} is set, 
     * {@link com.smartgwt.client.types.Orientation} is "vertical", and tileHeight is not set, tileHeight will be computed
     * automatically based on {@link com.smartgwt.client.widgets.tile.TileLayout#getTilesPerLine tilesPerLine}.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets the height of tiles.
     *
     * @param tileHeight height. Default value is null
     * @return {@link com.smartgwt.client.widgets.tile.TileLayout TileLayout} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.Sizing Sizing overview and related methods
     */
    public TileLayout setTileHeight(Integer tileHeight)  throws IllegalStateException {
        return (TileLayout)setAttribute("tileHeight", tileHeight, false);
    }

    /**
     * Height of each tile in pixels.  See {@link com.smartgwt.client.widgets.tile.TileLayout#getTileSize tileSize}. If {@link
     * com.smartgwt.client.types.LayoutPolicy} is "fit", {@link com.smartgwt.client.widgets.tile.TileLayout#getExpandMargins
     * expandMargins} is false, {@link com.smartgwt.client.widgets.tile.TileLayout#getTilesPerLine tilesPerLine} is set, 
     * {@link com.smartgwt.client.types.Orientation} is "vertical", and tileHeight is not set, tileHeight will be computed
     * automatically based on {@link com.smartgwt.client.widgets.tile.TileLayout#getTilesPerLine tilesPerLine}.
     *
     * @return Current tileHeight value. Default value is null
     * @see com.smartgwt.client.docs.Sizing Sizing overview and related methods
     */
    public Integer getTileHeight()  {
        return getAttributeAsInt("tileHeight");
    }
    

    /**
     * Horizontal margin in between tiles.  See {@link com.smartgwt.client.widgets.tile.TileLayout#getTileMargin tileMargin}.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets the horizontal margin of tiles.
     *
     * @param tileHMargin margin. Default value is null
     * @return {@link com.smartgwt.client.widgets.tile.TileLayout TileLayout} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public TileLayout setTileHMargin(Integer tileHMargin)  throws IllegalStateException {
        return (TileLayout)setAttribute("tileHMargin", tileHMargin, false);
    }

    /**
     * Horizontal margin in between tiles.  See {@link com.smartgwt.client.widgets.tile.TileLayout#getTileMargin tileMargin}.
     *
     * @return Current tileHMargin value. Default value is null
     */
    public Integer getTileHMargin()  {
        return getAttributeAsInt("tileHMargin");
    }
    

    /**
     * Margin in between tiles.  Can be set on a per-axis basis with {@link
     * com.smartgwt.client.widgets.tile.TileLayout#getTileHMargin tileHMargin} and {@link
     * com.smartgwt.client.widgets.tile.TileLayout#getTileVMargin tileVMargin}.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets the vertical and horizontal margin of tiles.
     *
     * @param tileMargin margin. Default value is 10
     * @return {@link com.smartgwt.client.widgets.tile.TileLayout TileLayout} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public TileLayout setTileMargin(int tileMargin)  throws IllegalStateException {
        return (TileLayout)setAttribute("tileMargin", tileMargin, false);
    }

    /**
     * Margin in between tiles.  Can be set on a per-axis basis with {@link
     * com.smartgwt.client.widgets.tile.TileLayout#getTileHMargin tileHMargin} and {@link
     * com.smartgwt.client.widgets.tile.TileLayout#getTileVMargin tileVMargin}.
     *
     * @return Current tileMargin value. Default value is 10
     */
    public int getTileMargin()  {
        return getAttributeAsInt("tileMargin");
    }
    

    /**
     * List of tiles to lay out.
     *
     * @param tiles New tiles value. Default value is null
     * @return {@link com.smartgwt.client.widgets.tile.TileLayout TileLayout} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public TileLayout setTiles(Canvas... tiles)  throws IllegalStateException {
        return (TileLayout)setAttribute("tiles", tiles, false);
    }
    

    /**
     * Size of each tile in pixels.  Depending on the {@link com.smartgwt.client.types.LayoutPolicy}, <code>tileSize</code> may
     * be taken as a maximum, minimum or exact size of tiles, or may be irrelevant. <P> Width and height may be separately set
     * via {@link com.smartgwt.client.widgets.tile.TileLayout#getTileHeight tileHeight} and {@link
     * com.smartgwt.client.widgets.tile.TileLayout#getTileWidth tileWidth}.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets the height and width of tiles.
     *
     * @param tileSize size. Default value is 100
     * @return {@link com.smartgwt.client.widgets.tile.TileLayout TileLayout} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.Sizing Sizing overview and related methods
     */
    public TileLayout setTileSize(int tileSize)  throws IllegalStateException {
        return (TileLayout)setAttribute("tileSize", tileSize, false);
    }

    /**
     * Size of each tile in pixels.  Depending on the {@link com.smartgwt.client.types.LayoutPolicy}, <code>tileSize</code> may
     * be taken as a maximum, minimum or exact size of tiles, or may be irrelevant. <P> Width and height may be separately set
     * via {@link com.smartgwt.client.widgets.tile.TileLayout#getTileHeight tileHeight} and {@link
     * com.smartgwt.client.widgets.tile.TileLayout#getTileWidth tileWidth}.
     *
     * @return Current tileSize value. Default value is 100
     * @see com.smartgwt.client.docs.Sizing Sizing overview and related methods
     */
    public int getTileSize()  {
        return getAttributeAsInt("tileSize");
    }
    

    /**
     * Number of tiles to show in each line.  Auto-derived from {@link com.smartgwt.client.widgets.tile.TileLayout#getTileSize
     * tileSize} for some layout modes.  See {@link com.smartgwt.client.types.TileLayoutPolicy}. This can also affect {@link
     * com.smartgwt.client.widgets.tile.TileLayout#getTileWidth tileWidth} or {@link
     * com.smartgwt.client.widgets.tile.TileLayout#getTileHeight tileHeight}. See those properties for details.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets the number of tiles per line.
     *
     * @param tilesPerLine New {@link com.smartgwt.client.widgets.tile.TileLayout#getTilesPerLine tilesPerLine} value. Default value is null
     * @return {@link com.smartgwt.client.widgets.tile.TileLayout TileLayout} instance, for chaining setter calls
     */
    public TileLayout setTilesPerLine(Integer tilesPerLine) {
        return (TileLayout)setAttribute("tilesPerLine", tilesPerLine, true);
    }

    /**
     * Number of tiles to show in each line.  Auto-derived from {@link com.smartgwt.client.widgets.tile.TileLayout#getTileSize
     * tileSize} for some layout modes.  See {@link com.smartgwt.client.types.TileLayoutPolicy}. This can also affect {@link
     * com.smartgwt.client.widgets.tile.TileLayout#getTileWidth tileWidth} or {@link
     * com.smartgwt.client.widgets.tile.TileLayout#getTileHeight tileHeight}. See those properties for details.
     *
     * @return Current tilesPerLine value. Default value is null
     */
    public Integer getTilesPerLine()  {
        return getAttributeAsInt("tilesPerLine");
    }
    

    /**
     * Vertical margin in between tiles.  See {@link com.smartgwt.client.widgets.tile.TileLayout#getTileMargin tileMargin}.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets the vertical margin of tiles.
     *
     * @param tileVMargin margin. Default value is null
     * @return {@link com.smartgwt.client.widgets.tile.TileLayout TileLayout} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public TileLayout setTileVMargin(Integer tileVMargin)  throws IllegalStateException {
        return (TileLayout)setAttribute("tileVMargin", tileVMargin, false);
    }

    /**
     * Vertical margin in between tiles.  See {@link com.smartgwt.client.widgets.tile.TileLayout#getTileMargin tileMargin}.
     *
     * @return Current tileVMargin value. Default value is null
     */
    public Integer getTileVMargin()  {
        return getAttributeAsInt("tileVMargin");
    }
    

    /**
     * Width of each tile in pixels.  See {@link com.smartgwt.client.widgets.tile.TileLayout#getTileSize tileSize}. If {@link
     * com.smartgwt.client.types.LayoutPolicy} is "fit", {@link com.smartgwt.client.widgets.tile.TileLayout#getExpandMargins
     * expandMargins} is false, {@link com.smartgwt.client.widgets.tile.TileLayout#getTilesPerLine tilesPerLine} is set, {@link
     * com.smartgwt.client.types.Orientation} is "horizontal", and tileWidth is not set, tileWidth will be computed
     * automatically based on {@link com.smartgwt.client.widgets.tile.TileLayout#getTilesPerLine tilesPerLine}.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets the width of tiles.
     *
     * @param tileWidth width. Default value is null
     * @return {@link com.smartgwt.client.widgets.tile.TileLayout TileLayout} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.Sizing Sizing overview and related methods
     */
    public TileLayout setTileWidth(Integer tileWidth)  throws IllegalStateException {
        return (TileLayout)setAttribute("tileWidth", tileWidth, false);
    }

    /**
     * Width of each tile in pixels.  See {@link com.smartgwt.client.widgets.tile.TileLayout#getTileSize tileSize}. If {@link
     * com.smartgwt.client.types.LayoutPolicy} is "fit", {@link com.smartgwt.client.widgets.tile.TileLayout#getExpandMargins
     * expandMargins} is false, {@link com.smartgwt.client.widgets.tile.TileLayout#getTilesPerLine tilesPerLine} is set, {@link
     * com.smartgwt.client.types.Orientation} is "horizontal", and tileWidth is not set, tileWidth will be computed
     * automatically based on {@link com.smartgwt.client.widgets.tile.TileLayout#getTilesPerLine tilesPerLine}.
     *
     * @return Current tileWidth value. Default value is null
     * @see com.smartgwt.client.docs.Sizing Sizing overview and related methods
     */
    public Integer getTileWidth()  {
        return getAttributeAsInt("tileWidth");
    }
    

    // ********************* Methods ***********************
	/**
     * Add a tile to the layout, dynamically.
     * @param tile new tile to add
     */
    public native void addTile(Canvas tile) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "addTile", "Canvas");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.addTile(tile == null ? null : tile.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()());
    }-*/;

	/**
     * Add a tile to the layout, dynamically.
     * @param tile new tile to add
     * @param index position where the tile should be added.  Defaults to adding the tile at the end.
     */
    public native void addTile(Canvas tile, Integer index) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "addTile", "Canvas,Integer");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.addTile(tile == null ? null : tile.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()(), index == null ? null : index.@java.lang.Integer::intValue()());
    }-*/;
	
	/**
     * Retrieve a tile by index.   <P> The TileLayout consistently uses this method to access tiles, in order to allow
     * subclasses to create tiles on demand.
     * @param index index of the tile
     *
     * @return the tile
     */
    public native Canvas getTile(int index) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getTile", "int");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getTile(index);
        return @com.smartgwt.client.widgets.Canvas::getByJSObject(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
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
     * @param tileLayoutProperties properties that should be used as new defaults when instances of this class are created
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public static native void setDefaultProperties(TileLayout tileLayoutProperties) /*-{
        if (tileLayoutProperties.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Class;)(TileLayout.@java.lang.Object::getClass()(), "setDefaultProperties", tileLayoutProperties.@java.lang.Object::getClass()());
        }
        tileLayoutProperties.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
    	var properties = tileLayoutProperties.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        properties = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(properties,true);
        $wnd.isc.TileLayout.addProperties(properties);
    }-*/;

    // ***********************************************************



    /**
     * Policy for laying out tiles.  See {@link com.smartgwt.client.types.TileLayoutPolicy} for options.
     *
     * @param layoutPolicy layoutPolicy Default value is ""
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setLayoutPolicy(TileLayoutPolicy layoutPolicy) throws IllegalStateException {
        setAttribute("layoutPolicy", layoutPolicy.getValue(), false);
    }

    /**
     * Remove a tile from the layout.
     *
     * @param tileIndex index or String ID of the tile
     * @return whether a tile was found and removed
     */
    public native boolean removeTile(int tileIndex) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        return !!self.removeTile(tileIndex);
    }-*/;

    /**
     * Remove a tile from the layout.
     *
     * @param tileID index or String ID of the tile
     * @return whether a tile was found and removed
     */
    public native boolean removeTile(String tileID) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        return !!self.removeTile(tileID);
    }-*/;

    /**
     * Remove a tile from the layout.
     *
     * @param tile index or String ID of the tile
     * @return whether a tile was found and removed
     */
    public native boolean removeTile(Canvas tile) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var tileJS = tile.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        return !!self.removeTile(tileJS);
    }-*/;

    /**
     * Forces layout out the tiles
     */
    public native void layoutTiles() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.layoutTiles();
    }-*/;

    /**
     * Setter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject setLogicalStructure(TileLayoutLogicalStructure s) {
        super.setLogicalStructure(s);
        try {
            s.animateTileChange = getAttributeAsString("animateTileChange");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TileLayout.animateTileChange:" + t.getMessage() + "\n";
        }
        try {
            s.autoWrapLines = getAttributeAsString("autoWrapLines");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TileLayout.autoWrapLines:" + t.getMessage() + "\n";
        }
        try {
            s.dragDataAction = getAttributeAsString("dragDataAction");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TileLayout.dragDataAction:" + t.getMessage() + "\n";
        }
        try {
            s.expandMargins = getAttributeAsString("expandMargins");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TileLayout.expandMargins:" + t.getMessage() + "\n";
        }
        try {
            s.layoutMargin = getAttributeAsString("layoutMargin");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TileLayout.layoutMargin:" + t.getMessage() + "\n";
        }
        try {
            s.layoutPolicy = getAttributeAsString("layoutPolicy");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TileLayout.layoutPolicy:" + t.getMessage() + "\n";
        }
        try {
            s.orientation = getAttributeAsString("orientation");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TileLayout.orientation:" + t.getMessage() + "\n";
        }
        try {
            s.overflow = getAttributeAsString("overflow");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TileLayout.overflow:" + t.getMessage() + "\n";
        }
        try {
            s.paddingAsLayoutMargin = getAttributeAsString("paddingAsLayoutMargin");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TileLayout.paddingAsLayoutMargin:" + t.getMessage() + "\n";
        }
        try {
            s.tileHeight = getAttributeAsString("tileHeight");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TileLayout.tileHeight:" + t.getMessage() + "\n";
        }
        try {
            s.tileHMargin = getAttributeAsString("tileHMargin");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TileLayout.tileHMargin:" + t.getMessage() + "\n";
        }
        try {
            s.tileMargin = getAttributeAsString("tileMargin");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TileLayout.tileMargin:" + t.getMessage() + "\n";
        }
        try {
            s.tileSize = getAttributeAsString("tileSize");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TileLayout.tileSize:" + t.getMessage() + "\n";
        }
        try {
            s.tilesPerLine = getAttributeAsString("tilesPerLine");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TileLayout.tilesPerLine:" + t.getMessage() + "\n";
        }
        try {
            s.tileVMargin = getAttributeAsString("tileVMargin");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TileLayout.tileVMargin:" + t.getMessage() + "\n";
        }
        try {
            s.tileWidth = getAttributeAsString("tileWidth");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TileLayout.tileWidth:" + t.getMessage() + "\n";
        }
        return s;
    }

    /**
     * Getter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject getLogicalStructure() {
        TileLayoutLogicalStructure s = new TileLayoutLogicalStructure();
        setLogicalStructure(s);
        return s;
    }
}
