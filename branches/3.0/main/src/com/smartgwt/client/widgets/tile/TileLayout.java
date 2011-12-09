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
 
package com.smartgwt.client.widgets.tile;



import com.smartgwt.client.event.*;
import com.smartgwt.client.core.*;
import com.smartgwt.client.types.*;
import com.smartgwt.client.data.*;
import com.smartgwt.client.data.events.*;
import com.smartgwt.client.rpc.*;
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
import com.smartgwt.client.widgets.tab.*;
import com.smartgwt.client.widgets.toolbar.*;
import com.smartgwt.client.widgets.tree.*;
import com.smartgwt.client.widgets.tree.events.*;
import com.smartgwt.client.widgets.viewer.*;
import com.smartgwt.client.widgets.calendar.*;
import com.smartgwt.client.widgets.calendar.events.*;
import com.smartgwt.client.widgets.cube.*;

import java.util.*;

import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;
import com.smartgwt.client.util.*;
import com.google.gwt.event.shared.*;
import com.google.gwt.event.shared.HasHandlers;

/**
 * Lays out a series of components, calls "tiles", in a grid with multiple tiles per row.
 */
public class TileLayout extends Canvas {

    public static TileLayout getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        BaseWidget obj = BaseWidget.getRef(jsObj);
        if(obj != null) {
            return (TileLayout) obj;
        } else {
            return new TileLayout(jsObj);
        }
    }

    public TileLayout(){
        scClassName = "TileLayout";
    }

    public TileLayout(JavaScriptObject jsObj){
        super(jsObj);
    }

    protected native JavaScriptObject create()/*-{
        var config = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
        var widget = $wnd.isc[scClassName].create(config);
        this.@com.smartgwt.client.widgets.BaseWidget::doInit()();
        return widget;
    }-*/;
    // ********************* Properties / Attributes ***********************

    /**
     * If set, tiles animate to their new positions when a tile is added, removed, or reordered via drag and drop.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param animateTileChange animateTileChange Default value is true
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setAnimateTileChange(Boolean animateTileChange) {
        setAttribute("animateTileChange", animateTileChange, true);
    }

    /**
     * If set, tiles animate to their new positions when a tile is added, removed, or reordered via drag and drop.
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Boolean getAnimateTileChange()  {
        return getAttributeAsBoolean("animateTileChange");
    }

    /**
     * When {@link com.smartgwt.client.types.LayoutPolicy} is "flow", should we automatically start a new line when there's not
     * enough room to fit the next tile on the same line? <P> If set to false, a new line will only be started if a tile
     * specifies tile.startLine or tile.endLine.
     *
     * @param autoWrapLines autoWrapLines Default value is true
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setAutoWrapLines(Boolean autoWrapLines)  throws IllegalStateException {
        setAttribute("autoWrapLines", autoWrapLines, false);
    }

    /**
     * When {@link com.smartgwt.client.types.LayoutPolicy} is "flow", should we automatically start a new line when there's not
     * enough room to fit the next tile on the same line? <P> If set to false, a new line will only be started if a tile
     * specifies tile.startLine or tile.endLine.
     *
     *
     * @return Boolean
     */
    public Boolean getAutoWrapLines()  {
        return getAttributeAsBoolean("autoWrapLines");
    }

    /**
     * Indicates what to do with data dragged into another DataBoundComponent. See          DragDataAction type for details.
     *
     * @param dragDataAction dragDataAction Default value is Canvas.MOVE
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#grid_interaction_drag_move" target="examples">Drag move Example</a>
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#grid_interaction_drag_copy" target="examples">Drag copy Example</a>
     */
    public void setDragDataAction(DragDataAction dragDataAction) {
        setAttribute("dragDataAction", dragDataAction.getValue(), true);
    }

    /**
     * Indicates what to do with data dragged into another DataBoundComponent. See          DragDataAction type for details.
     *
     *
     * @return DragDataAction
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#grid_interaction_drag_move" target="examples">Drag move Example</a>
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#grid_interaction_drag_copy" target="examples">Drag copy Example</a>
     */
    public DragDataAction getDragDataAction()  {
        return EnumUtil.getEnum(DragDataAction.values(), getAttribute("dragDataAction"));
    }

    /**
     * With {@link com.smartgwt.client.types.LayoutPolicy}:"fit", should margins be expanded so that tiles fill the available
     * space in the TileLayout on the breadth axis? This can also affect {@link
     * com.smartgwt.client.widgets.tile.TileLayout#getTileWidth tileWidth} or {@link
     * com.smartgwt.client.widgets.tile.TileLayout#getTileHeight tileHeight}. See those properties for details.
     *
     * @param expandMargins expandMargins Default value is true
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setExpandMargins(Boolean expandMargins)  throws IllegalStateException {
        setAttribute("expandMargins", expandMargins, false);
    }

    /**
     * With {@link com.smartgwt.client.types.LayoutPolicy}:"fit", should margins be expanded so that tiles fill the available
     * space in the TileLayout on the breadth axis? This can also affect {@link
     * com.smartgwt.client.widgets.tile.TileLayout#getTileWidth tileWidth} or {@link
     * com.smartgwt.client.widgets.tile.TileLayout#getTileHeight tileHeight}. See those properties for details.
     *
     *
     * @return Boolean
     */
    public Boolean getExpandMargins()  {
        return getAttributeAsBoolean("expandMargins");
    }

    /**
     * A margin left around the outside of all tiles.
     *
     * @param layoutMargin layoutMargin Default value is 5
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setLayoutMargin(int layoutMargin)  throws IllegalStateException {
        setAttribute("layoutMargin", layoutMargin, false);
    }

    /**
     * A margin left around the outside of all tiles.
     *
     *
     * @return int
     */
    public int getLayoutMargin()  {
        return getAttributeAsInt("layoutMargin");
    }

    /**
     * Direction of tiling.  See also {@link com.smartgwt.client.types.TileLayoutPolicy}.
     *
     * @param orientation orientation Default value is "horizontal"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setOrientation(Orientation orientation)  throws IllegalStateException {
        setAttribute("orientation", orientation.getValue(), false);
    }

    /**
     * Direction of tiling.  See also {@link com.smartgwt.client.types.TileLayoutPolicy}.
     *
     *
     * @return Orientation
     */
    public Orientation getOrientation()  {
        return EnumUtil.getEnum(Orientation.values(), getAttribute("orientation"));
    }

    /**
     * Normal {@link com.smartgwt.client.types.Overflow} settings can be used on TileLayouts, for example, an overflow:auto
     * TileLayout will scroll if members exceed its specified size, whereas an overflow:visible TileLayout will grow to
     * accommodate members.
     *
     * @param overflow overflow Default value is "auto"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.Sizing Sizing overview and related methods
     */
    public void setOverflow(Overflow overflow)  throws IllegalStateException {
        setAttribute("overflow", overflow.getValue(), false);
    }

    /**
     * Normal {@link com.smartgwt.client.types.Overflow} settings can be used on TileLayouts, for example, an overflow:auto
     * TileLayout will scroll if members exceed its specified size, whereas an overflow:visible TileLayout will grow to
     * accommodate members.
     *
     *
     * @return Overflow
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
     * <P> Note that {@link com.smartgwt.client.widgets.layout.Layout#getLayoutMargin layoutMargin} if specified, takes
     * precedence over this value.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param paddingAsLayoutMargin paddingAsLayoutMargin Default value is true
     */
    public void setPaddingAsLayoutMargin(Boolean paddingAsLayoutMargin) {
        setAttribute("paddingAsLayoutMargin", paddingAsLayoutMargin, true);
    }

    /**
     * If this widget has padding specified (as {@link com.smartgwt.client.widgets.Canvas#getPadding this.padding} or in the
     * CSS style applied to this layout), should it show up as space outside the members, similar to layoutMargin? <P> If this
     * setting is false, padding will not affect member positioning (as CSS padding normally does not affect absolutely
     * positioned children).  Leaving this setting true allows a designer to more effectively control layout purely from CSS.
     * <P> Note that {@link com.smartgwt.client.widgets.layout.Layout#getLayoutMargin layoutMargin} if specified, takes
     * precedence over this value.
     *
     *
     * @return Boolean
     */
    public Boolean getPaddingAsLayoutMargin()  {
        return getAttributeAsBoolean("paddingAsLayoutMargin");
    }

    /**
     * Height of each tile in pixels.  See {@link com.smartgwt.client.widgets.tile.TileLayout#getTileSize tileSize}. If {@link
     * com.smartgwt.client.types.LayoutPolicy} is "fit", {@link com.smartgwt.client.widgets.tile.TileLayout#getExpandMargins
     * expandMargins} is false, {@link com.smartgwt.client.widgets.tile.TileLayout#getTilesPerLine tilesPerLine} is set, 
     * {@link com.smartgwt.client.types.Orientation} is "vertical", and tileHeight is not set, tileHeight will be computed
     * automatically based on {@link com.smartgwt.client.widgets.tile.TileLayout#getTilesPerLine tilesPerLine}.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * sets the height of tiles
     *
     * @param tileHeight height. Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.Sizing Sizing overview and related methods
     */
    public void setTileHeight(Integer tileHeight)  throws IllegalStateException {
        setAttribute("tileHeight", tileHeight, false);
    }

    /**
     * Height of each tile in pixels.  See {@link com.smartgwt.client.widgets.tile.TileLayout#getTileSize tileSize}. If {@link
     * com.smartgwt.client.types.LayoutPolicy} is "fit", {@link com.smartgwt.client.widgets.tile.TileLayout#getExpandMargins
     * expandMargins} is false, {@link com.smartgwt.client.widgets.tile.TileLayout#getTilesPerLine tilesPerLine} is set, 
     * {@link com.smartgwt.client.types.Orientation} is "vertical", and tileHeight is not set, tileHeight will be computed
     * automatically based on {@link com.smartgwt.client.widgets.tile.TileLayout#getTilesPerLine tilesPerLine}.
     *
     *
     * @return Integer
     * @see com.smartgwt.client.docs.Sizing Sizing overview and related methods
     */
    public Integer getTileHeight()  {
        return getAttributeAsInt("tileHeight");
    }

    /**
     * Horizontal margin in between tiles.  See {@link com.smartgwt.client.widgets.tile.TileLayout#getTileMargin tileMargin}.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * sets the horizontal margin of tiles
     *
     * @param tileHMargin width. Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setTileHMargin(Integer tileHMargin)  throws IllegalStateException {
        setAttribute("tileHMargin", tileHMargin, false);
    }

    /**
     * Horizontal margin in between tiles.  See {@link com.smartgwt.client.widgets.tile.TileLayout#getTileMargin tileMargin}.
     *
     *
     * @return Integer
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
     * sets the vertical and horizontal margin of tiles
     *
     * @param tileMargin margin. Default value is 10
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setTileMargin(int tileMargin)  throws IllegalStateException {
        setAttribute("tileMargin", tileMargin, false);
    }

    /**
     * Margin in between tiles.  Can be set on a per-axis basis with {@link
     * com.smartgwt.client.widgets.tile.TileLayout#getTileHMargin tileHMargin} and {@link
     * com.smartgwt.client.widgets.tile.TileLayout#getTileVMargin tileVMargin}.
     *
     *
     * @return int
     */
    public int getTileMargin()  {
        return getAttributeAsInt("tileMargin");
    }

    /**
     * Size of each tile in pixels.  Depending on the {@link com.smartgwt.client.types.LayoutPolicy}, <code>tileSize</code> may
     * be taken as a maximum, minimum or exact size of tiles, or may be irrelevant. <P> Width and height may be separately set
     * via {@link com.smartgwt.client.widgets.tile.TileLayout#getTileHeight tileHeight} and {@link
     * com.smartgwt.client.widgets.tile.TileLayout#getTileWidth tileWidth}.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * sets the height and width of tiles
     *
     * @param tileSize size. Default value is 50
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.Sizing Sizing overview and related methods
     */
    public void setTileSize(int tileSize)  throws IllegalStateException {
        setAttribute("tileSize", tileSize, false);
    }

    /**
     * Size of each tile in pixels.  Depending on the {@link com.smartgwt.client.types.LayoutPolicy}, <code>tileSize</code> may
     * be taken as a maximum, minimum or exact size of tiles, or may be irrelevant. <P> Width and height may be separately set
     * via {@link com.smartgwt.client.widgets.tile.TileLayout#getTileHeight tileHeight} and {@link
     * com.smartgwt.client.widgets.tile.TileLayout#getTileWidth tileWidth}.
     *
     *
     * @return int
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
     * @param tilesPerLine tilesPerLine Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setTilesPerLine(Integer tilesPerLine)  throws IllegalStateException {
        setAttribute("tilesPerLine", tilesPerLine, false);
    }

    /**
     * Number of tiles to show in each line.  Auto-derived from {@link com.smartgwt.client.widgets.tile.TileLayout#getTileSize
     * tileSize} for some layout modes.  See {@link com.smartgwt.client.types.TileLayoutPolicy}. This can also affect {@link
     * com.smartgwt.client.widgets.tile.TileLayout#getTileWidth tileWidth} or {@link
     * com.smartgwt.client.widgets.tile.TileLayout#getTileHeight tileHeight}. See those properties for details.
     *
     *
     * @return Integer
     */
    public Integer getTilesPerLine()  {
        return getAttributeAsInt("tilesPerLine");
    }

    /**
     * Vertical margin in between tiles.  See {@link com.smartgwt.client.widgets.tile.TileLayout#getTileMargin tileMargin}.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * sets the vertical margin of tiles
     *
     * @param tileVMargin width. Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setTileVMargin(Integer tileVMargin)  throws IllegalStateException {
        setAttribute("tileVMargin", tileVMargin, false);
    }

    /**
     * Vertical margin in between tiles.  See {@link com.smartgwt.client.widgets.tile.TileLayout#getTileMargin tileMargin}.
     *
     *
     * @return Integer
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
     * sets the width of tiles
     *
     * @param tileWidth width. Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.Sizing Sizing overview and related methods
     */
    public void setTileWidth(Integer tileWidth)  throws IllegalStateException {
        setAttribute("tileWidth", tileWidth, false);
    }

    /**
     * Width of each tile in pixels.  See {@link com.smartgwt.client.widgets.tile.TileLayout#getTileSize tileSize}. If {@link
     * com.smartgwt.client.types.LayoutPolicy} is "fit", {@link com.smartgwt.client.widgets.tile.TileLayout#getExpandMargins
     * expandMargins} is false, {@link com.smartgwt.client.widgets.tile.TileLayout#getTilesPerLine tilesPerLine} is set, {@link
     * com.smartgwt.client.types.Orientation} is "horizontal", and tileWidth is not set, tileWidth will be computed
     * automatically based on {@link com.smartgwt.client.widgets.tile.TileLayout#getTilesPerLine tilesPerLine}.
     *
     *
     * @return Integer
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
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.addTile(tile.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()());
    }-*/;

    /**
     * Add a tile to the layout, dynamically.
     * @param tile new tile to add
     * @param index position where the tile should be added.  Defaults to adding the tile at the end.
     */
    public native void addTile(Canvas tile, int index) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.addTile(tile.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()(), index);
    }-*/;
            
    /**
     * Retrieve a tile by index.   <P> The TileLayout consistently uses this method to access tiles, in order to allow
     * subclasses to create tiles on demand.
     * @param index index of the tile
     *
     * @return the tile
     */
    public native Canvas getTile(int index) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getTile(index);
        if(ret == null || ret === undefined) return null;
        var retVal = @com.smartgwt.client.widgets.BaseWidget::getRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
        if(retVal == null) {
            retVal = @com.smartgwt.client.widgets.Canvas::new(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
        }
        return retVal;
    }-*/;

    // ********************* Static Methods ***********************
    /**
     * Class level method to set the default properties of this class. If set, then all subsequent instances of this
     * class will automatically have the default properties that were set when this method was called. This is a powerful
     * feature that eliminates the need for users to create a separate hierarchy of subclasses that only alter the default
     * properties of this class. Can also be used for skinning / styling purposes.
     * <P>
     * <b>Note:</b> This method is intended for setting default attributes only and will effect all instances of the
     * underlying class (including those automatically generated in JavaScript). 
     * This method should not be used to apply standard EventHandlers or override methods for
     * a class - use a custom subclass instead.
     *
     * @param tileLayoutProperties properties that should be used as new defaults when instances of this class are created
     */
    public static native void setDefaultProperties(TileLayout tileLayoutProperties) /*-{
    	var properties = $wnd.isc.addProperties({},tileLayoutProperties.@com.smartgwt.client.widgets.BaseWidget::getConfig()());
    	delete properties.ID;
        $wnd.isc.TileLayout.addProperties(properties);
    }-*/;
        
    // ***********************************************************        


    /**
     * List of tiles to lay out.
     *
     * @param tiles tiles Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setTiles(Canvas... tiles) throws IllegalStateException {
        setAttribute("tiles", tiles, false);
    }

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

}



