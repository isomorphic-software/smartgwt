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
 * A TileGrid is a {@link com.smartgwt.client.widgets.DataBoundComponent} that displays a list of objects as a set of
 * "tiles", where each tile represents one object, and the tiles are laid out in a grid with multiple tiles per row.  Each
 * tile displays one or more properties of the object it represents.
 */
@BeanFactory.FrameworkClass
@BeanFactory.ScClassName("TileGrid")
public class TileGrid extends TileLayout implements DataBoundComponent, com.smartgwt.client.widgets.tile.events.HasDataArrivedHandlers, com.smartgwt.client.widgets.tile.events.HasRecordClickHandlers, com.smartgwt.client.widgets.tile.events.HasRecordContextClickHandlers, com.smartgwt.client.widgets.tile.events.HasRecordDoubleClickHandlers, com.smartgwt.client.widgets.tile.events.HasSelectionChangedHandlers {

    public static TileGrid getOrCreateRef(JavaScriptObject jsObj) {
        if (jsObj == null) return null;
        final BaseWidget refInstance = BaseWidget.getRef(jsObj);
        if (refInstance == null) {
            return new TileGrid(jsObj);
        } else {
            assert refInstance instanceof TileGrid;
            return (TileGrid)refInstance;
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(TileGrid.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "Canvas");
        }
        defaults.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
        var cleanDefaultsJS = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(defaults.@com.smartgwt.client.widgets.BaseWidget::getConfig()(), true);
        $wnd.isc.TileGrid.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(TileGrid.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "FormItem");
        }
        defaults.@com.smartgwt.client.widgets.form.fields.FormItem::setConfigOnly(Z)(true);
    	var cleanDefaultsJS = defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getEditorTypeConfig()();
        $wnd.isc.TileGrid.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
    }-*/;

    public TileGrid(){
        scClassName = "TileGrid";
    }

    public TileGrid(JavaScriptObject jsObj){
        scClassName = "TileGrid";
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
     * If set, when the dataset changes due to filtering, sorting or other actions, any tiles that were showing before and
     * after the change will animate from their old positions to their new positions.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param animateTileChange New animateTileChange value. Default value is true
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setAnimateTileChange(Boolean animateTileChange) {
        setAttribute("animateTileChange", animateTileChange, true);
    }

    /**
     * If set, when the dataset changes due to filtering, sorting or other actions, any tiles that were showing before and
     * after the change will animate from their old positions to their new positions.
     *
     * @return Current animateTileChange value. Default value is true
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Boolean getAnimateTileChange()  {
        Boolean result = getAttributeAsBoolean("animateTileChange");
        return result == null ? true : result;
    }
    
    
    

    /**
     * Indicates whether records can be dropped into this TileGrid.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Setter for {@link com.smartgwt.client.widgets.tile.TileGrid#getCanAcceptDroppedRecords canAcceptDroppedRecords}.
     *
     * @param canAcceptDroppedRecords New canAcceptDroppedRecords value. Default value is false
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#effects_dd_move_list" target="examples">Drag list (move) Example</a>
     */
    public void setCanAcceptDroppedRecords(Boolean canAcceptDroppedRecords) {
        setAttribute("canAcceptDroppedRecords", canAcceptDroppedRecords, true);
    }

    /**
     * Indicates whether records can be dropped into this TileGrid.
     *
     * @return Current canAcceptDroppedRecords value. Default value is false
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#effects_dd_move_list" target="examples">Drag list (move) Example</a>
     */
    public Boolean getCanAcceptDroppedRecords()  {
        Boolean result = getAttributeAsBoolean("canAcceptDroppedRecords");
        return result == null ? false : result;
    }
    

    /**
     * Indicates whether tiles can be dragged from this <code>TileGrid</code> and dropped elsewhere. <p> <strong>NOTE:</strong>
     * If <code>canDragTilesOut</code> is initially enabled or might be {@link
     * com.smartgwt.client.widgets.tile.TileGrid#setCanDragTilesOut dynamically enabled} after the grid is created, it may be
     * desirable to disable {@link com.smartgwt.client.widgets.Canvas#getUseTouchScrolling touch scrolling} so that
     * touch-dragging a tile starts a drag operation rather than a scroll. If {@link
     * com.smartgwt.client.widgets.Canvas#getDisableTouchScrollingForDrag Canvas.disableTouchScrollingForDrag} is set to
     * <code>true</code>, then touch scrolling will be disabled automatically. However, for {@link
     * com.smartgwt.client.docs.Accessibility accessibility} reasons, it is recommended to leave touch scrolling enabled and
     * provide an alternative set of controls that can be used to perform drag and drop of tiles out of the grid.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Setter for {@link com.smartgwt.client.widgets.tile.TileGrid#getCanDragTilesOut canDragTilesOut}.
     *
     * @param canDragTilesOut New canDragTilesOut value. Default value is false
     */
    public void setCanDragTilesOut(Boolean canDragTilesOut) {
        setAttribute("canDragTilesOut", canDragTilesOut, true);
    }

    /**
     * Indicates whether tiles can be dragged from this <code>TileGrid</code> and dropped elsewhere. <p> <strong>NOTE:</strong>
     * If <code>canDragTilesOut</code> is initially enabled or might be {@link
     * com.smartgwt.client.widgets.tile.TileGrid#setCanDragTilesOut dynamically enabled} after the grid is created, it may be
     * desirable to disable {@link com.smartgwt.client.widgets.Canvas#getUseTouchScrolling touch scrolling} so that
     * touch-dragging a tile starts a drag operation rather than a scroll. If {@link
     * com.smartgwt.client.widgets.Canvas#getDisableTouchScrollingForDrag Canvas.disableTouchScrollingForDrag} is set to
     * <code>true</code>, then touch scrolling will be disabled automatically. However, for {@link
     * com.smartgwt.client.docs.Accessibility accessibility} reasons, it is recommended to leave touch scrolling enabled and
     * provide an alternative set of controls that can be used to perform drag and drop of tiles out of the grid.
     *
     * @return Current canDragTilesOut value. Default value is false
     */
    public Boolean getCanDragTilesOut()  {
        Boolean result = getAttributeAsBoolean("canDragTilesOut");
        return result == null ? false : result;
    }
    

    /**
     * Indicates whether tiles can be reordered by dragging within this <code>TileGrid</code>. <p> <strong>NOTE:</strong> If
     * <code>canReorderTiles</code> is initially enabled or might be {@link
     * com.smartgwt.client.widgets.tile.TileGrid#setCanReorderTiles dynamically enabled} after the grid is created, it may be
     * desirable to disable {@link com.smartgwt.client.widgets.Canvas#getUseTouchScrolling touch scrolling} so that
     * touch-dragging a tile starts a reorder operation rather than a scroll. If {@link
     * com.smartgwt.client.widgets.Canvas#getDisableTouchScrollingForDrag Canvas.disableTouchScrollingForDrag} is set to
     * <code>true</code>, then touch scrolling will be disabled automatically. However, for {@link
     * com.smartgwt.client.docs.Accessibility accessibility} reasons, it is recommended to leave touch scrolling enabled and
     * provide an alternative set of controls that can be used to perform drag-reordering of tiles.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Setter for {@link com.smartgwt.client.widgets.tile.TileGrid#getCanReorderTiles canReorderTiles}.
     *
     * @param canReorderTiles New canReorderTiles value. Default value is false
     */
    public void setCanReorderTiles(Boolean canReorderTiles) {
        setAttribute("canReorderTiles", canReorderTiles, true);
    }

    /**
     * Indicates whether tiles can be reordered by dragging within this <code>TileGrid</code>. <p> <strong>NOTE:</strong> If
     * <code>canReorderTiles</code> is initially enabled or might be {@link
     * com.smartgwt.client.widgets.tile.TileGrid#setCanReorderTiles dynamically enabled} after the grid is created, it may be
     * desirable to disable {@link com.smartgwt.client.widgets.Canvas#getUseTouchScrolling touch scrolling} so that
     * touch-dragging a tile starts a reorder operation rather than a scroll. If {@link
     * com.smartgwt.client.widgets.Canvas#getDisableTouchScrollingForDrag Canvas.disableTouchScrollingForDrag} is set to
     * <code>true</code>, then touch scrolling will be disabled automatically. However, for {@link
     * com.smartgwt.client.docs.Accessibility accessibility} reasons, it is recommended to leave touch scrolling enabled and
     * provide an alternative set of controls that can be used to perform drag-reordering of tiles.
     *
     * @return Current canReorderTiles value. Default value is false
     */
    public Boolean getCanReorderTiles()  {
        Boolean result = getAttributeAsBoolean("canReorderTiles");
        return result == null ? false : result;
    }
    

    /**
     * A List of TileRecord objects, specifying the data to be used to create the tiles.   <p> This property will typically not
     * be explicitly specified for databound TileGrids, where the data is returned from the server via databound component
     * methods such as {@link com.smartgwt.client.widgets.tile.TileGrid#fetchData fetchData()}. In this case the data objects
     * will be set to a  {@link com.smartgwt.client.data.ResultSet resultSet} rather than a simple array.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Provides a new data set to the TileGrid after the grid has been created or drawn. The TileGrid will redraw to show the new data automatically.
     *
     * @param data data to show in the list. Default value is null
     * @see com.smartgwt.client.widgets.tile.TileRecord
     */
    public void setData(Record[] data) {
        setAttribute("data", data, true);
    }

    /**
     * A List of TileRecord objects, specifying the data to be used to create the tiles.   <p> This property will typically not
     * be explicitly specified for databound TileGrids, where the data is returned from the server via databound component
     * methods such as {@link com.smartgwt.client.widgets.tile.TileGrid#fetchData fetchData()}. In this case the data objects
     * will be set to a  {@link com.smartgwt.client.data.ResultSet resultSet} rather than a simple array.
     *
     * @return Current data value. Default value is null
     * @see com.smartgwt.client.widgets.tile.TileRecord
     */
    public Record[] getData()  {
        return com.smartgwt.client.util.ConvertTo.arrayOfRecord(getAttributeAsJavaScriptObject("data"));
    }

    /**
     * A List of TileRecord objects, specifying the data to be used to create the tiles.   <p> This property will typically not
     * be explicitly specified for databound TileGrids, where the data is returned from the server via databound component
     * methods such as {@link com.smartgwt.client.widgets.tile.TileGrid#fetchData fetchData()}. In this case the data objects
     * will be set to a  {@link com.smartgwt.client.data.ResultSet resultSet} rather than a simple array.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Provides a new data set to the TileGrid after the grid has been created or drawn. The TileGrid will redraw to show the new data automatically.
     *
     * @param data data to show in the list. Default value is null
     * @see com.smartgwt.client.widgets.tile.TileRecord
     */
    public void setData(TileRecord[] data) {
        setAttribute("data", data, true);
    }

    /**
     * A List of TileRecord objects, specifying the data to be used to create the tiles.   <p> This property will typically not
     * be explicitly specified for databound TileGrids, where the data is returned from the server via databound component
     * methods such as {@link com.smartgwt.client.widgets.tile.TileGrid#fetchData fetchData()}. In this case the data objects
     * will be set to a  {@link com.smartgwt.client.data.ResultSet resultSet} rather than a simple array.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Provides a new data set to the TileGrid after the grid has been created or drawn. The TileGrid will redraw to show the new data automatically.
     *
     * @param data data to show in the list. Default value is null
     * @see com.smartgwt.client.widgets.tile.TileRecord
     */
    public void setData(RecordList data) {
        setAttribute("data", data == null ? null : data.getOrCreateJsObj(), true);
    }
    

    /**
     * How to fetch and manage records retrieve from the server.  See {@link com.smartgwt.client.types.FetchMode}. <P> This
     * setting only applies to the {@link com.smartgwt.client.data.ResultSet} automatically created by calling {@link
     * com.smartgwt.client.widgets.grid.ListGrid#fetchData fetchData()}.  If a pre-existing ResultSet is passed to setData()
     * instead, it's existing setting for {@link com.smartgwt.client.data.ResultSet#getFetchMode ResultSet.fetchMode} applies.
     *
     * @param dataFetchMode New dataFetchMode value. Default value is "paged"
     * @see com.smartgwt.client.docs.Databinding Databinding overview and related methods
     */
    public void setDataFetchMode(FetchMode dataFetchMode) {
        setAttribute("dataFetchMode", dataFetchMode == null ? null : dataFetchMode.getValue(), true);
    }

    /**
     * How to fetch and manage records retrieve from the server.  See {@link com.smartgwt.client.types.FetchMode}. <P> This
     * setting only applies to the {@link com.smartgwt.client.data.ResultSet} automatically created by calling {@link
     * com.smartgwt.client.widgets.grid.ListGrid#fetchData fetchData()}.  If a pre-existing ResultSet is passed to setData()
     * instead, it's existing setting for {@link com.smartgwt.client.data.ResultSet#getFetchMode ResultSet.fetchMode} applies.
     *
     * @return Current dataFetchMode value. Default value is "paged"
     * @see com.smartgwt.client.docs.Databinding Databinding overview and related methods
     */
    public FetchMode getDataFetchMode()  {
        return EnumUtil.getEnum(FetchMode.values(), getAttribute("dataFetchMode"));
    }
    

    /**
     * The DataSource that this component should bind to for default fields and for performing {@link
     * com.smartgwt.client.data.DSRequest DataSource requests}. <P> Can be specified as either a DataSource instance or the
     * String ID of a DataSource.
     *
     * @param dataSource New dataSource value. Default value is null
     * @see com.smartgwt.client.docs.Databinding Databinding overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#grid_databinding_ds_fields" target="examples">DataSource fields Example</a>
     */
    public void setDataSource(DataSource dataSource) {
        setAttribute("dataSource", dataSource == null ? null : dataSource.getOrCreateJsObj(), true);
    }

    /**
     * The DataSource that this component should bind to for default fields and for performing {@link
     * com.smartgwt.client.data.DSRequest DataSource requests}. <P> Can be specified as either a DataSource instance or the
     * String ID of a DataSource.
     *
     * @param dataSource New dataSource value. Default value is null
     * @see com.smartgwt.client.docs.Databinding Databinding overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#grid_databinding_ds_fields" target="examples">DataSource fields Example</a>
     */
    public void setDataSource(String dataSource) {
        setAttribute("dataSource", dataSource, true);
    }
    

    /**
     * DetailViewer instance used to render the content shown in Tiles by default.
     * <p>
     * This component is an AutoChild named "detailViewer".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current detailViewer value. Default value is null
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public DetailViewer getDetailViewer() throws IllegalStateException {
        errorIfNotCreated("detailViewer");
        return (DetailViewer)DetailViewer.getByJSObject(getAttributeAsJavaScriptObject("detailViewer"));
    }
    

    /**
     * Properties for the {@link com.smartgwt.client.widgets.viewer.DetailViewer} that is automatically created to render the
     * contents of tiles by default.
     *
     * @param detailViewerProperties New detailViewerProperties value. Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public void setDetailViewerProperties(DetailViewer detailViewerProperties)  throws IllegalStateException {
        if (detailViewerProperties != null) {
            if (detailViewerProperties.isCreated()) {
                ConfigUtil.warnOfPreConfigInstantiation(TileGrid.class, "setDetailViewerProperties", "DetailViewer");
            }                                                                       
            detailViewerProperties.setConfigOnly(true);
        }
        JavaScriptObject config = detailViewerProperties == null ? null : detailViewerProperties.getConfig();
        setAttribute("detailViewerProperties", JSOHelper.cleanProperties(config, true), false);
    }

    /**
     * Properties for the {@link com.smartgwt.client.widgets.viewer.DetailViewer} that is automatically created to render the
     * contents of tiles by default.
     *
     * @return Current detailViewerProperties value. Default value is null
     */
    public DetailViewer getDetailViewerProperties()  {
        DetailViewer properties = new DetailViewer();
        properties.setConfigOnly(true);
        properties.setConfig(getAttributeAsJavaScriptObject("detailViewerProperties"));
        return properties;
    }
    
    
    

    /**
     * If drawing all tiles would cause no more than <code>drawAllMaxTiles</code> tiles to be rendered, the full dataset will
     * instead be drawn even if {@link com.smartgwt.client.widgets.tile.TileGrid#getShowAllRecords showAllRecords} is false and
     * incremental rendering would have otherwise been used. <P> The <code>drawAllMaxTiles</code> setting prevents incremental
     * rendering from being used in situations where it's really unnecessary, such as a 25 record dataset which happens to be
     * in a grid with a viewport showing only 15 or so tiles.  Incremental rendering causes a brief "flash" during scrolling as
     * the visible portion of the dataset is redrawn, and a better  scrolling experience can be obtained in this situation by
     * drawing the entire dataset up front, which in this example would have negligible effect on initial draw time. <P>
     * <code>drawAllMaxTiles:0</code> disables this features.  You may want to disable this feature if performance is an issue
     * and: <ul> <li> you very frequently redraw a grid <li> you do a lot of computation when rendering each tile <li> you are
     * showing many grids on one screen and the user won't scroll most of them </ul>
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param drawAllMaxTiles New drawAllMaxTiles value. Default value is 25
     * @see com.smartgwt.client.widgets.tile.TileGrid#setTileConstructor
     */
    public void setDrawAllMaxTiles(Integer drawAllMaxTiles) {
        setAttribute("drawAllMaxTiles", drawAllMaxTiles, true);
    }

    /**
     * If drawing all tiles would cause no more than <code>drawAllMaxTiles</code> tiles to be rendered, the full dataset will
     * instead be drawn even if {@link com.smartgwt.client.widgets.tile.TileGrid#getShowAllRecords showAllRecords} is false and
     * incremental rendering would have otherwise been used. <P> The <code>drawAllMaxTiles</code> setting prevents incremental
     * rendering from being used in situations where it's really unnecessary, such as a 25 record dataset which happens to be
     * in a grid with a viewport showing only 15 or so tiles.  Incremental rendering causes a brief "flash" during scrolling as
     * the visible portion of the dataset is redrawn, and a better  scrolling experience can be obtained in this situation by
     * drawing the entire dataset up front, which in this example would have negligible effect on initial draw time. <P>
     * <code>drawAllMaxTiles:0</code> disables this features.  You may want to disable this feature if performance is an issue
     * and: <ul> <li> you very frequently redraw a grid <li> you do a lot of computation when rendering each tile <li> you are
     * showing many grids on one screen and the user won't scroll most of them </ul>
     *
     * @return Current drawAllMaxTiles value. Default value is 25
     * @see com.smartgwt.client.widgets.tile.TileGrid#getTileConstructor
     */
    public Integer getDrawAllMaxTiles()  {
        return getAttributeAsInt("drawAllMaxTiles");
    }
    

    /**
     * The string to display in the body of a tileGrid with an empty data array, if {@link
     * com.smartgwt.client.widgets.tile.TileGrid#getShowEmptyMessage showEmptyMessage} is true.
     *
     * @param emptyMessage New emptyMessage value. Default value is "No tiles to show."
     * @see com.smartgwt.client.widgets.tile.TileGrid#setShowEmptyMessage
     * @see com.smartgwt.client.widgets.tile.TileGrid#setEmptyMessageStyle
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public void setEmptyMessage(String emptyMessage) {
        setAttribute("emptyMessage", emptyMessage, true);
    }

    /**
     * The string to display in the body of a tileGrid with an empty data array, if {@link
     * com.smartgwt.client.widgets.tile.TileGrid#getShowEmptyMessage showEmptyMessage} is true.
     *
     * @return Current emptyMessage value. Default value is "No tiles to show."
     * @see com.smartgwt.client.widgets.tile.TileGrid#getShowEmptyMessage
     * @see com.smartgwt.client.widgets.tile.TileGrid#getEmptyMessageStyle
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public String getEmptyMessage()  {
        return getAttributeAsString("emptyMessage");
    }
    

    /**
     * The CSS style name applied to the {@link com.smartgwt.client.widgets.tile.TileGrid#getEmptyMessage emptyMessage} if
     * displayed.
     *
     * @param emptyMessageStyle New emptyMessageStyle value. Default value is "emptyMessage"
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public void setEmptyMessageStyle(String emptyMessageStyle) {
        setAttribute("emptyMessageStyle", emptyMessageStyle, true);
    }

    /**
     * The CSS style name applied to the {@link com.smartgwt.client.widgets.tile.TileGrid#getEmptyMessage emptyMessage} if
     * displayed.
     *
     * @return Current emptyMessageStyle value. Default value is "emptyMessage"
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public String getEmptyMessageStyle()  {
        return getAttributeAsString("emptyMessageStyle");
    }
    

    /**
     * Array of field definitions to control the default rendering of tiles.
     *  <P>
     *  If not specified, if the DataSource has an {@link com.smartgwt.client.data.DataSource#getIconField iconField}, only the
     *  <code>iconField</code> and {@link com.smartgwt.client.data.DataSource#getTitleField titleField} will be shown.
     *  Otherwise, all non-{@link com.smartgwt.client.data.DataSourceField#getHidden hidden}
     * non-{@link com.smartgwt.client.data.DataSourceField#getDetail detail} fields will be shown, similar to the default set
     * of
     *  fields shown by a {@link com.smartgwt.client.widgets.grid.ListGrid}.
     *  <P>
     *  Only applicable if using the default {@link com.smartgwt.client.widgets.tile.SimpleTile} class for tiles.
     *  <P>
     * For SimpleTiles, it is possible to use {@link com.smartgwt.client.widgets.viewer.DetailViewerField#getCellStyle
     * DetailViewerField.getCellStyle()} and 
     * {@link com.smartgwt.client.widgets.StatefulCanvas#getStateSuffix StatefulCanvas.getStateSuffix()} to make a single field
     * statefully styled:
     *  <pre>
     *  
     *  
     *  final TileGrid tileGrid = new TileGrid();
     *  DetailViewerField animalNameField = new DetailViewerField("countryName");  
     *  animalNameField.setCellStyleHandler(new CellStyleHandler() {  
     *      public String execute(Object value, DetailViewerField field, Record record) {
     *          SimpleTile tile = tileGrid.getCurrentTile();
     *          if (value == "Tiger") return "tigerStyle" + tile.getStateSuffix();
     *          else return "nonTigerStyle" + tile.getStateSuffix();
     *      }  
     *  });  
     *  tileGrid.setFields(animalNameField);  
     *  
     *  </pre>
     *
     * @param fields New fields value. Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setFields(DetailViewerField... fields)  throws IllegalStateException {
        setAttribute("fields", fields, false);
    }
    
    
    

    /**
     * If you have a databound tileGrid and you scroll out of the currently loaded dataset, by default you will see blank tiles
     * until the server returns the data for those rows.  The loadingMessage attribute allows you to specify arbitrary html
     * that will be shown in each such "blank" tile while the data for that tile is loading. (e.g. "&lt;DIV
     * ALIGN='CENTER'&gt;LOADING&lt;/DIV&gt;")
     *
     * @param loadingMessage New loadingMessage value. Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public void setLoadingMessage(String loadingMessage)  throws IllegalStateException {
        setAttribute("loadingMessage", loadingMessage, false);
    }

    /**
     * If you have a databound tileGrid and you scroll out of the currently loaded dataset, by default you will see blank tiles
     * until the server returns the data for those rows.  The loadingMessage attribute allows you to specify arbitrary html
     * that will be shown in each such "blank" tile while the data for that tile is loading. (e.g. "&lt;DIV
     * ALIGN='CENTER'&gt;LOADING&lt;/DIV&gt;")
     *
     * @return Current loadingMessage value. Default value is null
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public String getLoadingMessage()  {
        return getAttributeAsString("loadingMessage");
    }
    

    /**
     * How many tiles should be present in a line when printing?
     *
     * @param printTilesPerLine New printTilesPerLine value. Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setPrintTilesPerLine(Integer printTilesPerLine)  throws IllegalStateException {
        setAttribute("printTilesPerLine", printTilesPerLine, false);
    }

    /**
     * How many tiles should be present in a line when printing?
     *
     * @return Current printTilesPerLine value. Default value is null
     */
    public Integer getPrintTilesPerLine()  {
        return getAttributeAsInt("printTilesPerLine");
    }
    

    /**
     * This property determines whether tiles that are no longer visible (due to scrolling) are recycled, allowing a large
     * number of records to be displayed using a (potentially) much smaller set of tiles. <P> Recyling tiles may significantly
     * reduce the number of live tile widgets needed to support a particular TileGrid, but may also result in extra work when
     * the TileGrid is scrolled, as a scroll that brings off-screen tiles into view will require recycling tiles that have left
     * the view, even if the new tiles have been visited before (in previous scrolling). <P> Recycling will occur when {@link
     * com.smartgwt.client.widgets.tile.TileGrid#getTile getTile()} is called, unless the supplied record (or record specifed
     * by index) is currently bound to an existing tile.  Even if recycling is not enabled, the record associated with a given
     * tile may change if the TileGrid data changes. <P> For more control over the tile creation and recycling process,  see
     * {@link com.smartgwt.client.widgets.tile.TileGrid#createTile createTile()} and {@link
     * com.smartgwt.client.widgets.tile.TileGrid#updateTile updateTile()}.
     *
     * @param recycleTiles New recycleTiles value. Default value is true
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setRecycleTiles(Boolean recycleTiles)  throws IllegalStateException {
        setAttribute("recycleTiles", recycleTiles, false);
    }

    /**
     * This property determines whether tiles that are no longer visible (due to scrolling) are recycled, allowing a large
     * number of records to be displayed using a (potentially) much smaller set of tiles. <P> Recyling tiles may significantly
     * reduce the number of live tile widgets needed to support a particular TileGrid, but may also result in extra work when
     * the TileGrid is scrolled, as a scroll that brings off-screen tiles into view will require recycling tiles that have left
     * the view, even if the new tiles have been visited before (in previous scrolling). <P> Recycling will occur when {@link
     * com.smartgwt.client.widgets.tile.TileGrid#getTile getTile()} is called, unless the supplied record (or record specifed
     * by index) is currently bound to an existing tile.  Even if recycling is not enabled, the record associated with a given
     * tile may change if the TileGrid data changes. <P> For more control over the tile creation and recycling process,  see
     * {@link com.smartgwt.client.widgets.tile.TileGrid#createTile createTile()} and {@link
     * com.smartgwt.client.widgets.tile.TileGrid#updateTile updateTile()}.
     *
     * @return Current recycleTiles value. Default value is true
     */
    public Boolean getRecycleTiles()  {
        Boolean result = getAttributeAsBoolean("recycleTiles");
        return result == null ? true : result;
    }
    

    /**
     * Defines a tileGrid's clickable-selection behavior.
     *
     * @param selectionType New selectionType value. Default value is Selection.MULTIPLE
     * @see com.smartgwt.client.types.SelectionStyle
     * @see com.smartgwt.client.docs.Selection Selection overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#tiling_editing" target="examples">Editing Example</a>
     */
    public void setSelectionType(SelectionStyle selectionType) {
        setAttribute("selectionType", selectionType == null ? null : selectionType.getValue(), true);
    }

    /**
     * Defines a tileGrid's clickable-selection behavior.
     *
     * @return Current selectionType value. Default value is Selection.MULTIPLE
     * @see com.smartgwt.client.types.SelectionStyle
     * @see com.smartgwt.client.docs.Selection Selection overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#tiling_editing" target="examples">Editing Example</a>
     */
    public SelectionStyle getSelectionType()  {
        return EnumUtil.getEnum(SelectionStyle.values(), getAttribute("selectionType"));
    }
    

    /**
     * Whether tiles are created and drawn for all records, or only for those currently visible.
     *
     * @param showAllRecords New showAllRecords value. Default value is false
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.Basics Basics overview and related methods
     */
    public void setShowAllRecords(Boolean showAllRecords)  throws IllegalStateException {
        setAttribute("showAllRecords", showAllRecords, false);
    }

    /**
     * Whether tiles are created and drawn for all records, or only for those currently visible.
     *
     * @return Current showAllRecords value. Default value is false
     * @see com.smartgwt.client.docs.Basics Basics overview and related methods
     */
    public Boolean getShowAllRecords()  {
        Boolean result = getAttributeAsBoolean("showAllRecords");
        return result == null ? false : result;
    }
    

    /**
     * By default, TileGrids will not show fields marked {@link com.smartgwt.client.data.DataSourceField#getDetail detail:true}
     * in the DataSource.  See also {@link com.smartgwt.client.widgets.tile.TileGrid#getFields fields}.
     *
     * @param showDetailFields New showDetailFields value. Default value is false
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setShowDetailFields(Boolean showDetailFields)  throws IllegalStateException {
        setAttribute("showDetailFields", showDetailFields, false);
    }

    /**
     * By default, TileGrids will not show fields marked {@link com.smartgwt.client.data.DataSourceField#getDetail detail:true}
     * in the DataSource.  See also {@link com.smartgwt.client.widgets.tile.TileGrid#getFields fields}.
     *
     * @return Current showDetailFields value. Default value is false
     */
    public Boolean getShowDetailFields()  {
        Boolean result = getAttributeAsBoolean("showDetailFields");
        return result == null ? false : result;
    }
    

    /**
     * Indicates whether the text of the emptyMessage property should be displayed if no data is available.
     *
     * @param showEmptyMessage New showEmptyMessage value. Default value is true
     * @see com.smartgwt.client.widgets.tile.TileGrid#setEmptyMessage
     */
    public void setShowEmptyMessage(Boolean showEmptyMessage) {
        setAttribute("showEmptyMessage", showEmptyMessage, true);
    }

    /**
     * Indicates whether the text of the emptyMessage property should be displayed if no data is available.
     *
     * @return Current showEmptyMessage value. Default value is true
     * @see com.smartgwt.client.widgets.tile.TileGrid#getEmptyMessage
     */
    public Boolean getShowEmptyMessage()  {
        Boolean result = getAttributeAsBoolean("showEmptyMessage");
        return result == null ? true : result;
    }
    

    /**
     * Style for the overall TileGrid component.
     *
     * @param styleName New styleName value. Default value is "tileGrid"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setStyleName(String styleName)  throws IllegalStateException {
        setAttribute("styleName", styleName, false);
    }

    /**
     * Style for the overall TileGrid component.
     *
     * @return Current styleName value. Default value is "tileGrid"
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getStyleName()  {
        return getAttributeAsString("styleName");
    }
    

    /**
     * <b>Note :</b> This API is non-functional (always returns null) and exists only to make
     * you aware that this MultiAutoChild exists.  See {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}
     * for details.
     * <p>
     * A TileGrid automatically creates one tile per record in the dataset, via the
     *  {@link com.smartgwt.client.types.AutoChild} pattern.
     *  <P>
     * By default, the {@link com.smartgwt.client.widgets.tile.SimpleTile} class will be used, and will contain content as
     * rendered
     * by a {@link com.smartgwt.client.widgets.viewer.DetailViewer}, based on the provided {@link
     * com.smartgwt.client.widgets.tile.TileGrid#getFields fields} (or on the default
     *  set of fields).
     *  <P>
     *  
     *  
     * To create a completely different appearance set {@link com.smartgwt.client.widgets.tile.TileGrid#getTileConstructor
     * tileConstructor} to custom Canvas
     *  class name. You can use SmartGWT classes too with help of Reflection. For example, you can
     *  extend a DynamicForm with any layout:
     *  <pre>
     *    public class CarTile extends DynamicForm {
     *      public CarTile() {
     *        StaticTextItem name = new StaticTextItem("name");
     *        name.setShowTitle(false);
     *        StaticTextItem price = new StaticTextItem("price");
     *        price.setShowTitle(false);
     *        this.setFields(pictureItem, name, price);
     *      }
     *    }
     *  </pre>
     *  Register the class factory and use it by passing it's class to tileConstructor
     *  <pre>
     *    public interface CarTileMetaFactory extends BeanFactory.MetaFactory {
     *      BeanFactory<CarTile> getCarTileFactory();
     *    }
     *    public void onModuleLoad() {
     *      GWT.create(CarTileMetaFactory.class);
     *      TileGrid tileGrid = new TileGrid();
     *      tileGrid.setTileConstructor(CarTile.class.getName());
     *      tileGrid.draw();
     *    }
     *  </pre>
     * 
     *
     * @return null
     */
    public SimpleTile getTile()  {
        return null;
    }
    

    /**
     * Classname of a Smart GWT component to use for each tile rendered by this TileGrid.  Tiles are created by the {@link
     * com.smartgwt.client.types.AutoChild} pattern; see {@link com.smartgwt.client.widgets.tile.TileGrid#getTile tile}. <P> 
     * Any subclass of Canvas is allowed, but typically any custom class will derive from {@link
     * com.smartgwt.client.widgets.tile.SimpleTile}. <p> When using a custom component for tileConstructor, DataBoundComponents
     * that display multiple Records (ListGrid, DetailViewer) will have data provided via {@link
     * com.smartgwt.client.widgets.grid.ListGrid#setData ListGrid.setData()}, and components that display a single Record
     * (DynamicForm) will have {@link com.smartgwt.client.widgets.form.DynamicForm#setValues DynamicForm.setValues()} called on
     * them. <p> If the component is not a recognized DataBoundComponent subclass, the Record can be accessed via    
     * <code>this.getAttributeAsRecord("record").</code> <p> If you implement particularly simple or particularly complex tile
     * interfaces, you may wish to adjust the property {@link com.smartgwt.client.widgets.tile.TileGrid#getDrawAllMaxTiles
     * drawAllMaxTiles}.
     *
     * @param tileConstructor New tileConstructor value. Default value is "SimpleTile"
     * @see com.smartgwt.client.docs.SCClassName SCClassName 
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#tiling_custom" target="examples">Custom Tiles Example</a>
     */
    public void setTileConstructor(String tileConstructor) {
        setAttribute("tileConstructor", tileConstructor, true);
    }

    /**
     * Classname of a Smart GWT component to use for each tile rendered by this TileGrid.  Tiles are created by the {@link
     * com.smartgwt.client.types.AutoChild} pattern; see {@link com.smartgwt.client.widgets.tile.TileGrid#getTile tile}. <P> 
     * Any subclass of Canvas is allowed, but typically any custom class will derive from {@link
     * com.smartgwt.client.widgets.tile.SimpleTile}. <p> When using a custom component for tileConstructor, DataBoundComponents
     * that display multiple Records (ListGrid, DetailViewer) will have data provided via {@link
     * com.smartgwt.client.widgets.grid.ListGrid#setData ListGrid.setData()}, and components that display a single Record
     * (DynamicForm) will have {@link com.smartgwt.client.widgets.form.DynamicForm#setValues DynamicForm.setValues()} called on
     * them. <p> If the component is not a recognized DataBoundComponent subclass, the Record can be accessed via    
     * <code>this.getAttributeAsRecord("record").</code> <p> If you implement particularly simple or particularly complex tile
     * interfaces, you may wish to adjust the property {@link com.smartgwt.client.widgets.tile.TileGrid#getDrawAllMaxTiles
     * drawAllMaxTiles}.
     *
     * @return Current tileConstructor value. Default value is "SimpleTile"
     * @see com.smartgwt.client.docs.SCClassName SCClassName 
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#tiling_custom" target="examples">Custom Tiles Example</a>
     */
    public String getTileConstructor()  {
        return getAttributeAsString("tileConstructor");
    }
    

    /**
     * Visual appearance to show when the tile is being dragged.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param tileDragAppearance New tileDragAppearance value. Default value is EventHandler.TRACKER
     * @see com.smartgwt.client.widgets.Canvas#setDragAppearance
     * @see com.smartgwt.client.docs.Dragdrop Dragdrop overview and related methods
     */
    public void setTileDragAppearance(DragAppearance tileDragAppearance) {
        setAttribute("tileDragAppearance", tileDragAppearance == null ? null : tileDragAppearance.getValue(), true);
    }

    /**
     * Visual appearance to show when the tile is being dragged.
     *
     * @return Current tileDragAppearance value. Default value is EventHandler.TRACKER
     * @see com.smartgwt.client.widgets.Canvas#getDragAppearance
     * @see com.smartgwt.client.docs.Dragdrop Dragdrop overview and related methods
     */
    public DragAppearance getTileDragAppearance()  {
        return EnumUtil.getEnum(DragAppearance.values(), getAttribute("tileDragAppearance"));
    }
    

    /**
     * Common properties to use when creating every tile.
     *
     * @param tileProperties New tileProperties value. Default value is null
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public void setTileProperties(Canvas tileProperties) {
        if (tileProperties != null) {
            if (tileProperties.isCreated()) {
                ConfigUtil.warnOfPreConfigInstantiation(TileGrid.class, "setTileProperties", "Canvas");
            }                                                                       
            tileProperties.setConfigOnly(true);
        }
        JavaScriptObject config = tileProperties == null ? null : tileProperties.getConfig();
        setAttribute("tileProperties", JSOHelper.cleanProperties(config, true), true);
    }

    /**
     * Common properties to use when creating every tile.
     *
     * @return Current tileProperties value. Default value is null
     */
    public Canvas getTileProperties()  {
        Canvas properties = new Canvas();
        properties.setConfigOnly(true);
        properties.setConfig(getAttributeAsJavaScriptObject("tileProperties"));
        return properties;
    }
    

    /**
     * List of tiles that may be used by the TileGrid to show its current data set.  Note that the Smart GWT framework manages
     * this array for optimal performance, and not all tiles in the array are necessarily visible or assigned a record.  This
     * is true regardless of whether {@link com.smartgwt.client.widgets.tile.TileGrid#getRecycleTiles recycleTiles} is set or
     * not. <P> The number of records in the <code>TileGrid</code>'s current {@link
     * com.smartgwt.client.widgets.tile.TileGrid#getData data set} may be determined by calling {@link
     * com.smartgwt.client.data.List#getLength getLength()} on it.
     *
     * @param tiles New tiles value. Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.tile.TileGrid#setRecycleTiles
     * @see com.smartgwt.client.widgets.tile.TileGrid#setTileConstructor
     */
    public void setTiles(Canvas... tiles)  throws IllegalStateException {
        setAttribute("tiles", tiles, false);
    }

    /**
     * List of tiles that may be used by the TileGrid to show its current data set.  Note that the Smart GWT framework manages
     * this array for optimal performance, and not all tiles in the array are necessarily visible or assigned a record.  This
     * is true regardless of whether {@link com.smartgwt.client.widgets.tile.TileGrid#getRecycleTiles recycleTiles} is set or
     * not. <P> The number of records in the <code>TileGrid</code>'s current {@link
     * com.smartgwt.client.widgets.tile.TileGrid#getData data set} may be determined by calling {@link
     * com.smartgwt.client.data.List#getLength getLength()} on it.
     *
     * @return Current tiles value. Default value is null
     * @see com.smartgwt.client.widgets.tile.TileGrid#getRecycleTiles
     * @see com.smartgwt.client.widgets.tile.TileGrid#getTileConstructor
     */
    public Canvas[] getTiles()  {
        return com.smartgwt.client.util.ConvertTo.arrayOfCanvas(getAttributeAsJavaScriptObject("tiles"));
    }
    

    /**
     * Horizontal alignment for tile values: "left", "right" or "center".
     *
     * @param tileValueAlign New tileValueAlign value. Default value is "center"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setTileValueAlign(String tileValueAlign)  throws IllegalStateException {
        setAttribute("tileValueAlign", tileValueAlign, false);
    }

    /**
     * Horizontal alignment for tile values: "left", "right" or "center".
     *
     * @return Current tileValueAlign value. Default value is "center"
     */
    public String getTileValueAlign()  {
        return getAttributeAsString("tileValueAlign");
    }
    

    /**
     * When using the default {@link com.smartgwt.client.widgets.tile.SimpleTile}, CSS style for each value shown within a
     * tile.
     *
     * @param tileValueStyle New tileValueStyle value. Default value is "tileValue"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public void setTileValueStyle(String tileValueStyle)  throws IllegalStateException {
        setAttribute("tileValueStyle", tileValueStyle, false);
    }

    /**
     * When using the default {@link com.smartgwt.client.widgets.tile.SimpleTile}, CSS style for each value shown within a
     * tile.
     *
     * @return Current tileValueStyle value. Default value is "tileValue"
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public String getTileValueStyle()  {
        return getAttributeAsString("tileValueStyle");
    }
    

    /**
     * Should tile values change state when the mouse goes down on them?
     *
     * @param valuesShowDown New valuesShowDown value. Default value is false
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setValuesShowDown(boolean valuesShowDown)  throws IllegalStateException {
        setAttribute("valuesShowDown", valuesShowDown, false);
    }

    /**
     * Should tile values change state when the mouse goes down on them?
     *
     * @return Current valuesShowDown value. Default value is false
     */
    public boolean getValuesShowDown()  {
        Boolean result = getAttributeAsBoolean("valuesShowDown");
        return result == null ? false : result;
    }
    

    /**
     * Should tile values change state when the mouse goes over them?
     *
     * @param valuesShowRollOver New valuesShowRollOver value. Default value is false
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setValuesShowRollOver(boolean valuesShowRollOver)  throws IllegalStateException {
        setAttribute("valuesShowRollOver", valuesShowRollOver, false);
    }

    /**
     * Should tile values change state when the mouse goes over them?
     *
     * @return Current valuesShowRollOver value. Default value is false
     */
    public boolean getValuesShowRollOver()  {
        Boolean result = getAttributeAsBoolean("valuesShowRollOver");
        return result == null ? false : result;
    }
    

    /**
     * Should tile values change state when they are selected?
     *
     * @param valuesShowSelected New valuesShowSelected value. Default value is true
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setValuesShowSelected(boolean valuesShowSelected)  throws IllegalStateException {
        setAttribute("valuesShowSelected", valuesShowSelected, false);
    }

    /**
     * Should tile values change state when they are selected?
     *
     * @return Current valuesShowSelected value. Default value is true
     */
    public boolean getValuesShowSelected()  {
        Boolean result = getAttributeAsBoolean("valuesShowSelected");
        return result == null ? true : result;
    }
    

    /**
     * Whether values should be allowed to wrap by default, or should be shown on one line regardless of length.
     *
     * @param wrapValues New wrapValues value. Default value is false
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setWrapValues(Boolean wrapValues)  throws IllegalStateException {
        setAttribute("wrapValues", wrapValues, false);
    }

    /**
     * Whether values should be allowed to wrap by default, or should be shown on one line regardless of length.
     *
     * @return Current wrapValues value. Default value is false
     */
    public Boolean getWrapValues()  {
        Boolean result = getAttributeAsBoolean("wrapValues");
        return result == null ? false : result;
    }
    

    // ********************* Methods ***********************
	/**
     * Perform a DataSource "add" operation to add new records to this component's DataSource.
     * @param newRecord new record
     * @see com.smartgwt.client.docs.DataBoundComponentMethods DataBoundComponentMethods overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#grid_dataoperations_add" target="examples">Databound add Example</a>
     */
    public native void addData(Record newRecord) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "addData", "Record");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.addData(newRecord.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;

    /**
     * @see TileGrid#addData
     */
    public void addData(Record newRecord, DSCallback callback){
        addData(newRecord, callback, null);
    }

	/**
     * Perform a DataSource "add" operation to add new records to this component's DataSource.
     * @param newRecord new record
     * @param callback method to call on operation completion
     * @param requestProperties additional properties to set on the DSRequest                                          that will be issued
     * @see com.smartgwt.client.docs.DataBoundComponentMethods DataBoundComponentMethods overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#grid_dataoperations_add" target="examples">Databound add Example</a>
     */
    public native void addData(Record newRecord, DSCallback callback, DSRequest requestProperties) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "addData", "Record,DSCallback,DSRequest");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.addData(newRecord.@com.smartgwt.client.core.DataClass::getJsObj()(), 
			$entry( function(dsResponse, data, dsRequest) { 
				if(callback!=null) callback.@com.smartgwt.client.data.DSCallback::execute(Lcom/smartgwt/client/data/DSResponse;Ljava/lang/Object;Lcom/smartgwt/client/data/DSRequest;)(
					@com.smartgwt.client.data.DSResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsResponse), 
					data, 
					@com.smartgwt.client.data.DSRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsRequest)
				);
			}), requestProperties == null ? null : requestProperties.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;
	
	/**
     * This is not allowed for tileGrid. Instead, use {@link com.smartgwt.client.widgets.tile.TileGrid#addData addData()}.
     */
    public native void addTile() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "addTile", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.addTile();
    }-*/;

    /**
     * Add a dataArrived handler.
     * <p>
     * Notification method fired when new data arrives from the server to be displayed in this tileGrid, (for example in
     * response to the user scrolling a new set of tiles into view). Only applies to databound tileGrid where the {@link
     * com.smartgwt.client.widgets.tile.TileGrid#getData data} attribute is a {@link com.smartgwt.client.data.ResultSet}. This
     * method is fired directly in response to {@link com.smartgwt.client.data.ResultSet#addDataArrivedHandler dataArrived()}
     * firing on the data object.
     *
     * @param handler the dataArrived handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addDataArrivedHandler(com.smartgwt.client.widgets.tile.events.DataArrivedHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.tile.events.DataArrivedEvent.getType()) == 0) setupDataArrivedEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.tile.events.DataArrivedEvent.getType());
    }

    private native void setupDataArrivedEvent() /*-{
        var obj;
        var selfJ = this;
        var hasDefaultHandler;
        var dataArrived = $entry(function(){
            var param = {"_this": this, "startRecord" : arguments[0], "endRecord" : arguments[1]};
            var event = @com.smartgwt.client.widgets.tile.events.DataArrivedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            selfJ.@com.smartgwt.client.widgets.tile.TileGrid::handleTearDownDataArrivedEvent()();
            if (hasDefaultHandler) this.Super("dataArrived", arguments);
        });
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            hasDefaultHandler = $wnd.isc.isA.Function(obj.getProperty("dataArrived"));
            obj.addProperties({dataArrived:  dataArrived              });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
            hasDefaultHandler = $wnd.isc.isA.Function($wnd.isc[scClassName].getInstanceProperty("dataArrived"));
            obj.dataArrived =  dataArrived             ;
        }
    }-*/;

    private void handleTearDownDataArrivedEvent() {
        if (getHandlerCount(com.smartgwt.client.widgets.tile.events.DataArrivedEvent.getType()) == 0) tearDownDataArrivedEvent();
    }

    private native void tearDownDataArrivedEvent() /*-{
        var obj;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }
        if (obj && obj.hasOwnProperty("dataArrived")) delete obj.dataArrived;
    }-*/;

	/**
     * Deselect a contiguous range of records by index. <P> This is a synonym for <code>selectRange(startRow, endRow,
     * false);</code>
     * @param startRow start of selection range
     * @param endRow end of selection range (non-inclusive)
     * @see com.smartgwt.client.docs.Selection Selection overview and related methods
     */
    public native void deselectRange(int startRow, int endRow) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "deselectRange", "int,int");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.deselectRange(startRow, endRow);
    }-*/;

	/**
     * Returns the tile currently under the mouse.
     *
     * @return the tile currently under the mouse
     */
    public native SimpleTile getCurrentTile() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getCurrentTile", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getCurrentTile();
        return @com.smartgwt.client.widgets.Canvas::getByJSObject(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

	/**
     * Return "title" HTML to display as a drag tracker when the user drags some record.<br> Default implementation will
     * display the cell value for the title field (see  {@link com.smartgwt.client.widgets.grid.ListGrid#getTitleField
     * ListGrid.getTitleField()}) for the record(s) being dragged (including any icons / custom formatting / styling, etc). <p>
     * Note: Only called if {@link com.smartgwt.client.widgets.grid.ListGrid#getDragTrackerMode ListGrid.dragTrackerMode} is
     * set to <code>"title"</code>.
     * @param record First selected record being dragged
     * @param rowNum row index of first record being dragged
     *
     * @return Title for the row. Default implementation looks at the value of the                  title-field cell for the row.
     */
    public native String getDragTrackerTitle(ListGridRecord record, int rowNum) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getDragTrackerTitle", "ListGridRecord,int");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getDragTrackerTitle(record.@com.smartgwt.client.core.DataClass::getJsObj()(), rowNum);
        return ret;
    }-*/;

	/**
     * Returns a snapshot of the current presentation of this grid's fields as  a {@link
     * com.smartgwt.client.docs.ListGridFieldState} object. <P> This object can be passed to {@link
     * com.smartgwt.client.widgets.tile.TileGrid#setFieldState setFieldState()} to reset this grid's fields to the current
     * state. <P> Note that the information stored includes the current width and visibility of each of this  grid's fields.
     *
     * @return current state of this grid's fields.
     * See {@link com.smartgwt.client.docs.ListGridFieldState ListGridFieldState}
     * @see com.smartgwt.client.widgets.tile.TileGrid#setFieldState
     */
    public native String getFieldState() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getFieldState", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getFieldState();
        return ret;
    }-*/;

	/**
     * Returns the first selected record in this component. <p> <strong>NOTE:</strong> If a record is returned, it should be
     * treated as read-only and not modified.
     *
     * @return first selected record, or null if nothing selected
     * @see com.smartgwt.client.docs.Selection Selection overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#grid_dataoperations_remove" target="examples">Databound remove Example</a>
     */
    public native TileRecord getSelectedRecord() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getSelectedRecord", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getSelectedRecord();
        if(ret == null) return null;
        return @com.smartgwt.client.widgets.tile.TileRecord::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

	/**
     * Returns the index of the specified tile.
     * @param tile Tile you want to get the index for
     *
     * @return index of the tile in this tileGrid. Will return -1 if the specified tile is not displayed within this grid.
     */
    public native int getTileIndex(Canvas tile) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getTileIndex", "Canvas");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getTileIndex(tile == null ? null : tile.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()());
        return ret;
    }-*/;

	/**
     * Given a tile within this this tile-grid, this method will return the associated record.
     * @param tile Tile you want to get the record for
     *
     * @return Record associated with the specified tile
     */
    public native TileRecord getTileRecord(Canvas tile) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getTileRecord", "Canvas");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getTileRecord(tile == null ? null : tile.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()());
        if(ret == null) return null;
        return @com.smartgwt.client.widgets.tile.TileRecord::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

    /**
     * Add a recordClick handler.
     * <p>
     * Executed when the tileGrid receives a 'click' event on a tile. The default implementation does nothing -- override to
     * perform some action when any record is clicked.<br> A record event handler can be specified either as a function to
     * execute, or as a string of script to evaluate. If the handler is defined as a string of script, all the parameters below
     * will be available as variables for use in the script.<br> If you want to cancel the click based on the parameters, Call
     * {@link com.smartgwt.client.widgets.tile.events.RecordClickEvent#cancel()} from within {@link
     * com.smartgwt.client.widgets.tile.events.RecordClickHandler#onRecordClick}. Otherwise, return  true so that the click
     * event be registered with the tile.
     *
     * @param handler the recordClick handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addRecordClickHandler(com.smartgwt.client.widgets.tile.events.RecordClickHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.tile.events.RecordClickEvent.getType()) == 0) setupRecordClickEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.tile.events.RecordClickEvent.getType());
    }

    private native void setupRecordClickEvent() /*-{
        var obj;
        var selfJ = this;
        var hasDefaultHandler;
        var recordClick = $entry(function(){
            var param = {"_this": this, "viewer" : arguments[0], "tile" : arguments[1], "record" : arguments[2]};
            var event = @com.smartgwt.client.widgets.tile.events.RecordClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            selfJ.@com.smartgwt.client.widgets.tile.TileGrid::handleTearDownRecordClickEvent()();
            if (hasDefaultHandler) this.Super("recordClick", arguments);
        });
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            hasDefaultHandler = $wnd.isc.isA.Function(obj.getProperty("recordClick"));
            obj.addProperties({recordClick:  recordClick              });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
            hasDefaultHandler = $wnd.isc.isA.Function($wnd.isc[scClassName].getInstanceProperty("recordClick"));
            obj.recordClick =  recordClick             ;
        }
    }-*/;

    private void handleTearDownRecordClickEvent() {
        if (getHandlerCount(com.smartgwt.client.widgets.tile.events.RecordClickEvent.getType()) == 0) tearDownRecordClickEvent();
    }

    private native void tearDownRecordClickEvent() /*-{
        var obj;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }
        if (obj && obj.hasOwnProperty("recordClick")) delete obj.recordClick;
    }-*/;

    /**
     * Add a recordContextClick handler.
     * <p>
     * Executed when the tileGrid receives a context-click (right mouse button) event on a tile. The default implementation
     * does nothing -- override to perform some action when any record is right-clicked.<br>  Cancel the event to suppress the
     * native browser context menu. <P> A record event handler can be specified either as a function to execute, or as a string
     * of script to evaluate. If the handler is defined as a string of script, all the parameters below will be available as
     * variables for use in the script.<br> If you want to cancel the click based on the parameters, Call {@link
     * com.smartgwt.client.widgets.tile.events.RecordContextClickEvent#cancel()} from within {@link
     * com.smartgwt.client.widgets.tile.events.RecordContextClickHandler#onRecordContextClick}. Otherwise, return  true so that
     * the click event be registered with the tile.
     *
     * @param handler the recordContextClick handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addRecordContextClickHandler(com.smartgwt.client.widgets.tile.events.RecordContextClickHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.tile.events.RecordContextClickEvent.getType()) == 0) setupRecordContextClickEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.tile.events.RecordContextClickEvent.getType());
    }

    private native void setupRecordContextClickEvent() /*-{
        var obj;
        var selfJ = this;
        var hasDefaultHandler;
        var recordContextClick = $debox($entry(function(param){
            var event = @com.smartgwt.client.widgets.tile.events.RecordContextClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            selfJ.@com.smartgwt.client.widgets.tile.TileGrid::handleTearDownRecordContextClickEvent()();
            var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
            return !ret;
        }));
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            hasDefaultHandler = $wnd.isc.isA.Function(obj.getProperty("recordContextClick"));
            obj.addProperties({recordContextClick: 
                function () {
                    var param = {"_this": this, "viewer" : arguments[0], "tile" : arguments[1], "record" : arguments[2]};
                    var ret = recordContextClick(param) == true;
                    if (ret && hasDefaultHandler) {
                        ret = this.Super("recordContextClick", arguments);
                    }
                    return ret;
                }
             });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
            hasDefaultHandler = $wnd.isc.isA.Function($wnd.isc[scClassName].getInstanceProperty("recordContextClick"));
            obj.recordContextClick = 
                function () {
                    var param = {"_this": this, "viewer" : arguments[0], "tile" : arguments[1], "record" : arguments[2]};
                    var ret = recordContextClick(param) == true;
                    if (ret && hasDefaultHandler) {
                        ret = this.Super("recordContextClick", arguments);
                    }
                    return ret;
                }
            ;
        }
    }-*/;

    private void handleTearDownRecordContextClickEvent() {
        if (getHandlerCount(com.smartgwt.client.widgets.tile.events.RecordContextClickEvent.getType()) == 0) tearDownRecordContextClickEvent();
    }

    private native void tearDownRecordContextClickEvent() /*-{
        var obj;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }
        if (obj && obj.hasOwnProperty("recordContextClick")) delete obj.recordContextClick;
    }-*/;

    /**
     * Add a recordDoubleClick handler.
     * <p>
     * Executed when the tileGrid receives a 'doubleclick' event on a tile. The default implementation does nothing -- override
     * to perform some action when any record is doubleclicked.<br> A record event handler can be specified either as a
     * function to execute, or as a string of script to evaluate. If the handler is defined as a string of script, all the
     * parameters below will be available as variables for use in the script.<br> If you want to cancel the doubleclick based
     * on the parameters, Call {@link com.smartgwt.client.widgets.tile.events.RecordDoubleClickEvent#cancel()} from within
     * {@link com.smartgwt.client.widgets.tile.events.RecordDoubleClickHandler#onRecordDoubleClick}. Otherwise, return  true so
     * that the doubleclick event be registered with the tile.
     *
     * @param handler the recordDoubleClick handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addRecordDoubleClickHandler(com.smartgwt.client.widgets.tile.events.RecordDoubleClickHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.tile.events.RecordDoubleClickEvent.getType()) == 0) setupRecordDoubleClickEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.tile.events.RecordDoubleClickEvent.getType());
    }

    private native void setupRecordDoubleClickEvent() /*-{
        var obj;
        var selfJ = this;
        var hasDefaultHandler;
        var recordDoubleClick = $entry(function(){
            var param = {"_this": this, "viewer" : arguments[0], "tile" : arguments[1], "record" : arguments[2]};
            var event = @com.smartgwt.client.widgets.tile.events.RecordDoubleClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            selfJ.@com.smartgwt.client.widgets.tile.TileGrid::handleTearDownRecordDoubleClickEvent()();
            if (hasDefaultHandler) this.Super("recordDoubleClick", arguments);
        });
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            hasDefaultHandler = $wnd.isc.isA.Function(obj.getProperty("recordDoubleClick"));
            obj.addProperties({recordDoubleClick:  recordDoubleClick              });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
            hasDefaultHandler = $wnd.isc.isA.Function($wnd.isc[scClassName].getInstanceProperty("recordDoubleClick"));
            obj.recordDoubleClick =  recordDoubleClick             ;
        }
    }-*/;

    private void handleTearDownRecordDoubleClickEvent() {
        if (getHandlerCount(com.smartgwt.client.widgets.tile.events.RecordDoubleClickEvent.getType()) == 0) tearDownRecordDoubleClickEvent();
    }

    private native void tearDownRecordDoubleClickEvent() /*-{
        var obj;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }
        if (obj && obj.hasOwnProperty("recordDoubleClick")) delete obj.recordDoubleClick;
    }-*/;

	/**
     * Perform a DataSource "remove" operation to remove records from this component's DataSource.
     * @param data primary key values of record to delete,                                           (or complete record)
     * @see com.smartgwt.client.docs.DataBoundComponentMethods DataBoundComponentMethods overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#grid_dataoperations_remove" target="examples">Databound remove Example</a>
     */
    public native void removeData(Record data) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "removeData", "Record");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.removeData(data.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;

    /**
     * @see TileGrid#removeData
     */
    public void removeData(Record data, DSCallback callback){
        removeData(data, callback, null);
    }

	/**
     * Perform a DataSource "remove" operation to remove records from this component's DataSource.
     * @param data primary key values of record to delete,                                           (or complete record)
     * @param callback method to call on operation completion
     * @param requestProperties additional properties to set on the DSRequest                                          that will be issued
     * @see com.smartgwt.client.docs.DataBoundComponentMethods DataBoundComponentMethods overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#grid_dataoperations_remove" target="examples">Databound remove Example</a>
     */
    public native void removeData(Record data, DSCallback callback, DSRequest requestProperties) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "removeData", "Record,DSCallback,DSRequest");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.removeData(data.@com.smartgwt.client.core.DataClass::getJsObj()(), 
			$entry( function(dsResponse, data, dsRequest) { 
				if(callback!=null) callback.@com.smartgwt.client.data.DSCallback::execute(Lcom/smartgwt/client/data/DSResponse;Ljava/lang/Object;Lcom/smartgwt/client/data/DSRequest;)(
					@com.smartgwt.client.data.DSResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsResponse), 
					data, 
					@com.smartgwt.client.data.DSRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsRequest)
				);
			}), requestProperties == null ? null : requestProperties.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;
	
	/**
     * This is not allowed for tileGrid. Instead, use {@link com.smartgwt.client.widgets.tile.TileGrid#removeData
     * removeData()}.
     */
    public native void removeTile() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "removeTile", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.removeTile();
    }-*/;

    /**
     * Add a selectionChanged handler.
     * <p>
     * Called when selection changes within this tileGrid. Note this method fires for each record for which selection is
     * modified - so when a user clicks inside a tileGrid this method will typically fire twice (once for the old record being
     * deselected, and once for the new record being selected).
     *
     * @param handler the selectionChanged handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addSelectionChangedHandler(com.smartgwt.client.widgets.tile.events.SelectionChangedHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.tile.events.SelectionChangedEvent.getType()) == 0) setupSelectionChangedEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.tile.events.SelectionChangedEvent.getType());
    }

    private native void setupSelectionChangedEvent() /*-{
        var obj;
        var selfJ = this;
        var hasDefaultHandler;
        var selectionChanged = $entry(function(){
            var param = {"_this": this, "record" : arguments[0], "state" : arguments[1]};
            var event = @com.smartgwt.client.widgets.tile.events.SelectionChangedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            selfJ.@com.smartgwt.client.widgets.tile.TileGrid::handleTearDownSelectionChangedEvent()();
            if (hasDefaultHandler) this.Super("selectionChanged", arguments);
        });
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            hasDefaultHandler = $wnd.isc.isA.Function(obj.getProperty("selectionChanged"));
            obj.addProperties({selectionChanged:  selectionChanged              });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
            hasDefaultHandler = $wnd.isc.isA.Function($wnd.isc[scClassName].getInstanceProperty("selectionChanged"));
            obj.selectionChanged =  selectionChanged             ;
        }
    }-*/;

    private void handleTearDownSelectionChangedEvent() {
        if (getHandlerCount(com.smartgwt.client.widgets.tile.events.SelectionChangedEvent.getType()) == 0) tearDownSelectionChangedEvent();
    }

    private native void tearDownSelectionChangedEvent() /*-{
        var obj;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }
        if (obj && obj.hasOwnProperty("selectionChanged")) delete obj.selectionChanged;
    }-*/;

	/**
     * Select a contiguous range of records by index
     * @param startRow start of selection range
     * @param endRow end of selection range (non-inclusive)
     * @see com.smartgwt.client.docs.Selection Selection overview and related methods
     */
    public native void selectRange(int startRow, int endRow) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "selectRange", "int,int");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.selectRange(startRow, endRow);
    }-*/;

	/**
     * Select a contiguous range of records by index
     * @param startRow start of selection range
     * @param endRow end of selection range (non-inclusive)
     * @param newState new selection state (if null, defaults to true)
     * @see com.smartgwt.client.docs.Selection Selection overview and related methods
     */
    public native void selectRange(int startRow, int endRow, boolean newState) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "selectRange", "int,int,boolean");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.selectRange(startRow, endRow, newState);
    }-*/;
	
	/**
     * Sets some presentation properties (visibility, width, userFormula and userSummary) of the  grid fields based on the
     * {@link com.smartgwt.client.docs.ListGridFieldState} object passed in.<br> Used to restore previous state retrieved from
     * the grid by a call to {@link com.smartgwt.client.widgets.tile.TileGrid#getFieldState getFieldState()}.
     * @param fieldState state to apply to the grid's fields.
     * See {@link com.smartgwt.client.docs.ListGridFieldState ListGridFieldState}
     * @see com.smartgwt.client.widgets.tile.TileGrid#getFieldState
     * @see com.smartgwt.client.docs.ListGridFieldState ListGridFieldState
     */
    public native void setFieldState(String fieldState) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "setFieldState", "String");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setFieldState(fieldState);
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
     * @param tileGridProperties properties that should be used as new defaults when instances of this class are created
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public static native void setDefaultProperties(TileGrid tileGridProperties) /*-{
        if (tileGridProperties.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Class;)(TileGrid.@java.lang.Object::getClass()(), "setDefaultProperties", tileGridProperties.@java.lang.Object::getClass()());
        }
        tileGridProperties.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
    	var properties = tileGridProperties.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        properties = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(properties,true);
        $wnd.isc.TileGrid.addProperties(properties);
    }-*/;

    // ***********************************************************


	protected void onInit () {
		super.onInit();
		onInit_TileGrid();
	}
    protected native void onInit_TileGrid() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self._getTileHTML = self.getTileHTML;
        self.getTileHTML = $debox($entry(function(record) {
            var jObj = this.__ref;
            var recordJ = @com.smartgwt.client.data.Record::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(record);
            return jObj.@com.smartgwt.client.widgets.tile.TileGrid::getTileHTML(Lcom/smartgwt/client/data/Record;)(recordJ);
        }));

        self._getTile = self.getTile;
        self.getTile = $debox($entry(function(record) {
            var jObj = this.__ref;
            if(!$wnd.isc.isA.Number(record)) {
                var recordJ = @com.smartgwt.client.data.Record::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(record);
                var tile =  jObj.@com.smartgwt.client.widgets.tile.TileGrid::getTile(Lcom/smartgwt/client/data/Record;)(recordJ);
                return tile == null ? null : tile.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            } else {
                var tile =  jObj.@com.smartgwt.client.widgets.tile.TileGrid::getTile(I)(record);
                return tile == null ? null : tile.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            }
        }));
    }-*/;

    /**
     * This method provides the HTML to
     * be displayed within each tile.  See {@link com.smartgwt.client.widgets.tile.TileGrid#getTile tile}.
     * <p/>
     * <b>This is an override point.</b>
     *
     * @param record the tile for which HTML should be retrieved
     * @return HTML contents for the tile, as a String
     */
    protected native String getTileHTML(Record record) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        return self._getTileHTML(record.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;

    /**
     * Returns the tile for the passed record or record index.
     * <P>
     * Note that this method may be overridden but developers should be aware that this
     * method may be called repeatedly for the same record each time the TileGrid refreshes
     * that row. If you override this API, you will need to cache and re-use the same
     * tile objects per record. Typically this would be achieved by storing a pool of Tile
     * objects that are re-used if a Record with the same primaryKey is passed to getTile().
     * <P>
     * When calling this method directly, if {@link com.smartgwt.client.widgets.tile.TileGrid@showAllRecords} is false, this may
     * return null for records that are not currently visible.
     *
     * @param tile (TileRecord) record
     * @return (Canvas) tile for this record
     */
    public native Canvas getTile(Record record) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var canvasJS = self._getTile(record.@com.smartgwt.client.core.DataClass::getJsObj()());
        if(canvasJS == null) return null;
        return @com.smartgwt.client.widgets.Canvas::getByJSObject(Lcom/google/gwt/core/client/JavaScriptObject;)(canvasJS);
    }-*/;

    /**
     * Returns the tile for the passed record or record index.
     * <P>
     * Note that this method may be overridden but developers should be aware that this
     * method may be called repeatedly for the same record each time the TileGrid refreshes
     * that row. If you override this API, you will need to cache and re-use the same
     * tile objects per record. Typically this would be achieved by storing a pool of Tile
     * objects that are re-used if a Record with the same primaryKey is passed to getTile().
     * <P>
     * When calling this method directly, if +link{showAllRecords} is false, this may
     * return null for records that are not currently visible.
     * <P>
     * This is an override point
     * @param tile (int) index of record in this.data
     * @return (Canvas) tile for this record
     */
    public native Canvas getTile(int recordNum) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var canvasJS = self._getTile(recordNum);
        if(canvasJS == null) return null;
        return @com.smartgwt.client.widgets.Canvas::getByJSObject(Lcom/google/gwt/core/client/JavaScriptObject;)(canvasJS);
    }-*/;

    /**
     * Return the tileGrid data as a {@link com.smartgwt.client.data.RecordList}. If the component is
     * bound to a DataSource,
     * the actual type of the RecordList instance will be a {@link com.smartgwt.client.data.ResultSet}.
     *
     * @return the data
     */
    public RecordList getDataAsRecordList() {
        return getRecordList();
    }

    /**
     * Sort data by property.
     *
     * @param property  property
     * @param ascending direction
     */
    public native void sortByProperty(String property, boolean ascending) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.data.sortByProperty(property, ascending);
    }-*/;

    /**
     * Remove the currently selected records from this component. If this is a databound grid, the records will be removed directly from the DataSource. <P> If no records are selected, no action is taken. The grid will automatically be updated if the record deletion succeeds.
     */
    public native void removeSelectedData() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.removeSelectedData();
    }-*/;

    /**
     * Returns all selected records, as an Array.
     *
     * @return list of records, empty list if nothing selected
     */
    public native Record[] getSelection() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var selection =  self.getSelection();
        return @com.smartgwt.client.util.ConvertTo::arrayOfRecord(Lcom/google/gwt/core/client/JavaScriptObject;)(selection);
    }-*/;

    /**
     * Bind to a DataSource.
     * <P>
     * Binding to a DataSource means that the component will use the DataSource to provide default data for
     * its fields.
     * <P>
     * When binding to a new DataSource, if the component has any existing "fields" or has a dataset,
     * these will be discarded by default, since it is assumed the new DataSource may represent a completely
     * unrelated set of objects. If the old "fields" are still relevant, pass them to setDataSource().
     * @param dataSource
     * @param fields
     */
    public void setDataSource(DataSource dataSource, DetailViewerField... fields) {
        if (!isCreated()) {
            setFields(fields);
            setDataSource(dataSource);
        } else {
            JavaScriptObject jsFields = null;
            if (fields != null) {
                jsFields = JSOHelper.createJavaScriptArray();
                for (int i = 0; i < fields.length; i++) {
                    JSOHelper.setArrayValue(jsFields, i, fields[i].getJsObj());
                }
            }
            setDataSourceJS(dataSource.getOrCreateJsObj(), jsFields);
        }
    }
    private native void setDataSourceJS(JavaScriptObject dataSource, JavaScriptObject fields) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setDataSource(dataSource, fields);
    }-*/;


	/**
     * Set customizer that defines 
     * {@link com.smartgwt.client.widgets.tile.CreateTileCustomizer#createTile createTile}.
     * That method will be called when a new tile is required.
     * @param CreateTileCustomizer customizer
     * @see com.smartgwt.client.widgets.tile.CreateTileCustomizer#createTile
     * @see com.smartgwt.client.widgets.tile.TileGrid#getRecycleTiles
     */
    public native void setCreateTileCustomizer(CreateTileCustomizer customizer) /*-{
        var self;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            self = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            self = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }
        // stick a reference to the TileGrid on the customizer
        customizer.@com.smartgwt.client.widgets.tile.CreateTileCustomizer::setGrid(Lcom/smartgwt/client/widgets/tile/TileGrid;)(this);
        // there is no default implementation of isc.TileGrid.createTile()
        self.createTile = $debox($entry(function(recordJS, tileIndexJS) {
            var    recordJ =    recordJS == null ? null : @com.smartgwt.client.data.Record::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(recordJS),
                tileIndexJ = tileIndexJS == null ? null : @com.smartgwt.client.util.JSOHelper::toInteger(I)(tileIndexJS);
        	var returnValue = customizer.@com.smartgwt.client.widgets.tile.CreateTileCustomizer::createTile(Lcom/smartgwt/client/data/Record;Ljava/lang/Integer;)(recordJ, tileIndexJ);
        	return returnValue == null ? null : returnValue.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
    	}));
    }-*/;

	/**
     * Set customizer that defines 
     * {@link com.smartgwt.client.widgets.tile.UpdateTileCustomizer#updateTile updateTile}.
     * If both that method and 
     * {@link com.smartgwt.client.widgets.tile.CreateTileCustomizer#createTile createTile} 
     * have been defined and
     * {@link com.smartgwt.client.widgets.tile.TileGrid#getRecycleTiles recycleTiles} is true,
     * this customizer method will be called when the framework needs to recycle a tile to be
     * used with a new record.  This notification provides an opportunity to update any widget
     * properties that depend on the specifics of the record.
     * @param UpdateTileCustomizer customizer
     * @see com.smartgwt.client.widgets.tile.CreateTileCustomizer#updateTile
     * @see com.smartgwt.client.widgets.tile.TileGrid#getRecycleTiles
     */
    public native void setUpdateTileCustomizer(UpdateTileCustomizer customizer) /*-{
        var self;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            self = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            self = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }
        // stick a reference to the TileGrid on the customizer
        customizer.@com.smartgwt.client.widgets.tile.UpdateTileCustomizer::setGrid(Lcom/smartgwt/client/widgets/tile/TileGrid;)(this);
        // there is no default implementation of isc.TileGrid.updateTile()
        self.updateTile = $debox($entry(function(recordJS, tileIndexJS, canvasJS) {
            var    recordJ =    recordJS == null ? null : @com.smartgwt.client.data.Record::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(recordJS),
                tileIndexJ = tileIndexJS == null ? null : @com.smartgwt.client.util.JSOHelper::toInteger(I)(tileIndexJS),
                   canvasJ =    canvasJS == null ? null : @com.smartgwt.client.widgets.Canvas::getByJSObject(Lcom/google/gwt/core/client/JavaScriptObject;)(canvasJS);
        	customizer.@com.smartgwt.client.widgets.tile.UpdateTileCustomizer::updateTile(Lcom/smartgwt/client/data/Record;Ljava/lang/Integer;Lcom/smartgwt/client/widgets/Canvas;)(recordJ, tileIndexJ, canvasJ);
    	}));
    }-*/;



    // ********************* DataBoundComponent Properties / Attributes ***********************

    public void setDataPageSize(int dataPageSize) {
        setAttribute("dataPageSize", dataPageSize, true);
    }

    public int getDataPageSize() {
        Integer dataPageSize = getAttributeAsInt("dataPageSize");
        return dataPageSize == null ? 0 : dataPageSize;
    }

    public void setUseAllDataSourceFields(Boolean useAllDataSourceFields) {
        setAttribute("useAllDataSourceFields", useAllDataSourceFields, true);
    }

    public Boolean getUseAllDataSourceFields() {
        return getAttributeAsBoolean("useAllDataSourceFields");
    }

    public void setShowHiddenFields(Boolean showHiddenFields) {
        setAttribute("showHiddenFields", showHiddenFields, true);
    }

    public Boolean getShowHiddenFields() {
        return getAttributeAsBoolean("showHiddenFields");
    }

    public void setShowComplexFields(Boolean showComplexFields) {
        setAttribute("showComplexFields", showComplexFields, true);
    }

    public Boolean getShowComplexFields() {
        return getAttributeAsBoolean("showComplexFields");
    }

    public void setFetchOperation(String fetchOperation) {
        setAttribute("fetchOperation", fetchOperation, true);
    }

    public String getFetchOperation() {
        return getAttributeAsString("fetchOperation");
    }

    public void setUpdateOperation(String updateOperation) {
        setAttribute("updateOperation", updateOperation, true);
    }

    public String getUpdateOperation() {
        return getAttributeAsString("updateOperation");
    }

    public void setAddOperation(String addOperation) {
        setAttribute("addOperation", addOperation, true);
    }

    public String getAddOperation() {
        return getAttributeAsString("addOperation");
    }

    public void setRemoveOperation(String removeOperation) {
        setAttribute("removeOperation", removeOperation, true);
    }

    public String getRemoveOperation() {
        return getAttributeAsString("removeOperation");
    }

    public void setExportFields(String[] exportFields) {
        setAttribute("exportFields", exportFields, true);
    }

    public String[] getExportFields() {
        return getAttributeAsStringArray("exportFields");
    }

    public void setExportAll(Boolean exportAll) {
        setAttribute("exportAll", exportAll, true);
    }

    public Boolean getExportAll() {
        return getAttributeAsBoolean("exportAll");
    }

    public void setExportIncludeSummaries(Boolean exportIncludeSummaries) {
        setAttribute("exportIncludeSummaries", exportIncludeSummaries, true);
    }

    public Boolean getExportIncludeSummaries() {
        return getAttributeAsBoolean("exportIncludeSummaries");
    }

    public void setPreventDuplicates(Boolean preventDuplicates) throws IllegalStateException {
        setAttribute("preventDuplicates", preventDuplicates, false);
    }

    public Boolean getPreventDuplicates() {
        return getAttributeAsBoolean("preventDuplicates");
    }

    public void setDuplicateDragMessage(String duplicateDragMessage) throws IllegalStateException {
        setAttribute("duplicateDragMessage", duplicateDragMessage, false);
    }

    public String getDuplicateDragMessage() {
        return getAttributeAsString("duplicateDragMessage");
    }

    public void setAddDropValues(Boolean addDropValues) {
        setAttribute("addDropValues", addDropValues, true);
    }

    public Boolean getAddDropValues() {
        return getAttributeAsBoolean("addDropValues");
    }

    public void setDropValues(Map dropValues) {
        setAttribute("dropValues", dropValues, true);
    }

    public Map getDropValues() {
        return getAttributeAsMap("dropValues");
    }

    /**
     * Indicates whether or not this component will load its data {@link DataSource#setProgressiveLoading() progressively}
     * 
     * @see com.smartgwt.client.docs.ProgressiveLoading  
     * @see com.smartgwt.client.data.DataSource#setProgressiveLoading
     * @param progressiveLoading
     */
    public void setProgressiveLoading(Boolean progressiveLoading) {
        setAttribute("progressiveLoading", progressiveLoading, false);
    }

    /**
     * Indicates whether or not this component will load its data {@link DataSource#getProgressiveLoading() progressively}
     * 
     * @see com.smartgwt.client.docs.ProgressiveLoading
     * @see com.smartgwt.client.data.DataSource#getProgressiveLoading
     * @return
     */
    public Boolean getProgressiveLoading() {
        return getAttributeAsBoolean("progressiveLoading");
    }

    public void setUseFlatFields(Boolean useFlatFields) throws IllegalStateException {
        setAttribute("useFlatFields", useFlatFields, false);
    }

    public Boolean getUseFlatFields() {
        return getAttributeAsBoolean("useFlatFields");
    }

    public void setHiliteProperty(String hiliteProperty) {
        setAttribute("hiliteProperty", hiliteProperty, true);
    }

    public String getHiliteProperty() {
        return getAttributeAsString("hiliteProperty");
    }

    /** 
     * Shows a FieldPicker interface allowing end-users to rearrange the order and visibiility
     * of the fields in the associated DataBoundComponent.
     */
    public native void editFields() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.editFields();
    }-*/;

    /**
     * Shows a HiliteEditor interface allowing end-users to edit the data-hilites currently in use by this DataBoundComponent.
     */
    public native void editHilites() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.editHilites();
    }-*/;

    /**
     * Get the current hilites encoded as a String, for saving.
     *
     * @return the hilite state
     */
    public native String getHiliteState()  /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        return self.getHiliteState();
    }-*/;

    /**
     * Set the current hilites based on a hiliteState String previously returned from getHilitesState.
     *
     * @param hiliteState hilites state encoded as a String
     */
    public native void setHiliteState(String hiliteState)  /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        return self.setHiliteState(hiliteState);
    }-*/;

    /**
     * Accepts an array of hilite objects and applies them to this DataBoundComponent. See also {@link #getHilites() getHilites} for a method of
     * retrieving the hilite array for storage, including hilites manually added by the user.
     *
     * @param hilites array of hilite objects
     */
    public native void setHilites(Hilite[] hilites)/*-{
        var isCreated = this.@com.smartgwt.client.widgets.BaseWidget::isCreated()();
        var hilitesJS = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(hilites);
        if (isCreated) {
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.setHilites(hilitesJS);
        } else {
            var obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.hilites = hilitesJS;
        }
    }-*/;

    /**
     * Return the set of hilite-objects currently applied to this DataBoundComponent. These can be saved for
     * storage and then restored to a component later via setHilites().
     *
     * @return array of hilite objects
     */
    public native Hilite[] getHilites()/*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var hilitesJS = self.getHilites();
        return @com.smartgwt.client.util.ConvertTo::arrayOfHilite(Lcom/google/gwt/core/client/JavaScriptObject;)(hilitesJS);
    }-*/;

    public void setDragDataAction(DragDataAction dragDataAction) {
        setAttribute("dragDataAction", dragDataAction.getValue(), true);
    }

    public DragDataAction getDragDataAction() {
        return EnumUtil.getEnum(DragDataAction.values(), getAttribute("dragDataAction"));
    }

    public void setDragTrackerStyle(String dragTrackerStyle) {
        setAttribute("dragTrackerStyle", dragTrackerStyle, true);
    }

    public String getDragTrackerStyle() {
        return getAttributeAsString("dragTrackerStyle");
    }

    public void setCanAddFormulaFields(Boolean canAddFormulaFields) {
        setAttribute("canAddFormulaFields", canAddFormulaFields, true);
    }

    public native void addSummaryField() /*-{
         var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
         self.addSummaryField();
     }-*/;

    public native void addFormulaField() /*-{
       var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
       self.addFormulaField();
    }-*/;

    public Boolean getCanAddFormulaFields() {
        return getAttributeAsBoolean("canAddFormulaFields");
    }

    public void setAddFormulaFieldText(String addFormulaFieldText) {
        setAttribute("addFormulaFieldText", addFormulaFieldText, true);
    }

    public String getAddFormulaFieldText() {
        return getAttributeAsString("addFormulaFieldText");
    }

    public void setEditFormulaFieldText(String editFormulaFieldText) {
        setAttribute("editFormulaFieldText", editFormulaFieldText, true);
    }

    public String getEditFormulaFieldText() {
        return getAttributeAsString("editFormulaFieldText");
    }

    public void setCanAddSummaryFields(Boolean canAddSummaryFields) {
        setAttribute("canAddSummaryFields", canAddSummaryFields, true);
    }

    public Boolean getCanAddSummaryFields() {
        return getAttributeAsBoolean("canAddSummaryFields");
    }

    public void setAddSummaryFieldText(String addSummaryFieldText) {
        setAttribute("addSummaryFieldText", addSummaryFieldText, true);
    }

    public String getAddSummaryFieldText() {
        return getAttributeAsString("addSummaryFieldText");
    }

    public void setEditSummaryFieldText(String editSummaryFieldText) {
        setAttribute("editSummaryFieldText", editSummaryFieldText, true);
    }

    public String getEditSummaryFieldText() {
        return getAttributeAsString("editSummaryFieldText");
    }

    // ********************* Methods ***********************
    /**
     * Filters all objects according to the AdvancedCriteria passed
     *
     * @param adCriteria AdvancedCriteria to use to filter results
     *
     * @return all matching Objects or null if none found
     */
    public native Record[] findAll(AdvancedCriteria adCriteria) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordsJS = self.findAll(adCriteria.@com.smartgwt.client.core.DataClass::getJsObj()());
        if(@com.smartgwt.client.data.Criterion::instanceOf(Ljava/lang/Object;)(adCriteria)){
    		var criteriaJ = adCriteria.@com.smartgwt.client.core.DataClass::getJsObj()();
	    	@com.smartgwt.client.util.JSOHelper::setAttribute(Lcom/google/gwt/core/client/JavaScriptObject;Ljava/lang/String;Ljava/lang/String;)(criteriaJ,"_constructor","AdvancedCriteria");
	    }
        return recordsJS == null ? null : @com.smartgwt.client.data.Record::convertToRecordArray(Lcom/google/gwt/core/client/JavaScriptObject;)(recordsJS);
    }-*/;
    
    /**
     * Filters all objects according to the AdvancedCriteria passed and returns the first matching object or null if not found
     *
     * @param adCriteria AdvancedCriteria to use to filter results
     *
     * @return first matching object or null if not found
     */
    public native Record find(AdvancedCriteria adCriteria) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordJS = self.find(adCriteria.@com.smartgwt.client.core.DataClass::getJsObj()());
        if(@com.smartgwt.client.data.Criterion::instanceOf(Ljava/lang/Object;)(adCriteria)){
    		var criteriaJ = adCriteria.@com.smartgwt.client.core.DataClass::getJsObj()();
	    	@com.smartgwt.client.util.JSOHelper::setAttribute(Lcom/google/gwt/core/client/JavaScriptObject;Ljava/lang/String;Ljava/lang/String;)(criteriaJ,"_constructor","AdvancedCriteria");
	    }
        return recordJS == null ? null : @com.smartgwt.client.data.Record::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(recordJS);
    }-*/;
    
    /**
     * Finds the index of the first Record that matches with the AdvacendCriteria passed.
     * @param adCriteria AdvancedCriteria to use to filter results
     *
     * @return index of the first matching Record or -1 if not found
     */
    public native int findIndex(AdvancedCriteria adCriteria) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        if(@com.smartgwt.client.data.Criterion::instanceOf(Ljava/lang/Object;)(adCriteria)){
    		var criteriaJ = adCriteria.@com.smartgwt.client.core.DataClass::getJsObj()();
	    	@com.smartgwt.client.util.JSOHelper::setAttribute(Lcom/google/gwt/core/client/JavaScriptObject;Ljava/lang/String;Ljava/lang/String;)(criteriaJ,"_constructor","AdvancedCriteria");
	    }
        return self.findIndex(adCriteria.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;
    
    /**
     * Like {@link RecordList#findIndex}, but considering the startIndex and endIndex parameters.
     * @param startIndex first index to consider
     * @param adCriteria AdvancedCriteria to use to filter results
     * @param endIndex last index to consider
     * 
     * @return index of the first matching Record or -1 if not found
     */
    public native int findNextIndex(int startIndex, AdvancedCriteria adCriteria, int endIndex) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        if(@com.smartgwt.client.data.Criterion::instanceOf(Ljava/lang/Object;)(adCriteria)){
    		var criteriaJ = adCriteria.@com.smartgwt.client.core.DataClass::getJsObj()();
	    	@com.smartgwt.client.util.JSOHelper::setAttribute(Lcom/google/gwt/core/client/JavaScriptObject;Ljava/lang/String;Ljava/lang/String;)(criteriaJ,"_constructor","AdvancedCriteria");
	    }
        return self.findNextIndex(startIndex, adCriteria.@com.smartgwt.client.core.DataClass::getJsObj()(), null, endIndex);
    }-*/;
    
    /**
     * Like {@link RecordList#findIndex}, but considering the startIndex parameter.
     * @param startIndex first index to consider
     * @param adCriteria AdvancedCriteria to use to filter results
     * 
     * @return index of the first matching Record or -1 if not found
     */
    public native int findNextIndex(int startIndex, AdvancedCriteria adCriteria) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        if(@com.smartgwt.client.data.Criterion::instanceOf(Ljava/lang/Object;)(adCriteria)){
    		var criteriaJ = adCriteria.@com.smartgwt.client.core.DataClass::getJsObj()();
	    	@com.smartgwt.client.util.JSOHelper::setAttribute(Lcom/google/gwt/core/client/JavaScriptObject;Ljava/lang/String;Ljava/lang/String;)(criteriaJ,"_constructor","AdvancedCriteria");
	    }
        return self.findNextIndex(startIndex, adCriteria.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;

    public native void selectRecord(Record record)/*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordJS = record.@com.smartgwt.client.data.Record::getJsObj()();
        self.selectRecord(recordJS);
     }-*/;

    public native void selectRecord(int record)/*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.selectRecord(record);
     }-*/;

    public native void selectRecord(int record, boolean newState)/*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.selectRecord(record, newState);
     }-*/;

    public native void selectRecord(Record record, boolean newState)/*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordJS = record.@com.smartgwt.client.data.Record::getJsObj()();
        self.selectRecord(recordJS, newState);
     }-*/;

    public native void selectRecords(int[] records)/*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordsJS = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([I)(records);
        self.selectRecord(recordsJS);
     }-*/;

    public native void selectRecords(int[] records, boolean newState)/*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordsJS = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([I)(records);
        self.selectRecords(recordsJS, newState);
     }-*/;

    public native void selectRecords(Record[] records)/*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordsJS = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(records);
        self.selectRecords(recordsJS);
     }-*/;

    public native void selectRecords(Record[] records, boolean newState)/*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordsJS = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(records);
        self.selectRecords(recordsJS, newState);
     }-*/;

    public native void deselectRecord(Record record)/*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordJS = record.@com.smartgwt.client.data.Record::getJsObj()();
        self.deselectRecord(recordJS);
     }-*/;

    public native void deselectRecord(int record)/*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.deselectRecord(record);
     }-*/;

    public native void deselectRecords(int[] records)/*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordsJS = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([I)(records);
        self.deselectRecords(recordsJS);
     }-*/;

    public native void deselectRecords(Record[] records)/*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordsJS = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(records);
        self.deselectRecords(recordsJS);
     }-*/;

    public native void selectAllRecords() /*-{
         var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
         self.selectAllRecords();
     }-*/;

    public native void deselectAllRecords() /*-{
         var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
         self.deselectAllRecords();
     }-*/;

    public native Boolean anySelected() /*-{
         var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
         var retVal =self.anySelected();
         if(retVal == null) {
             return null;
         } else {
             return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
         }
     }-*/;

    public native void enableHilite(String hiliteID) /*-{
         var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
         self.enableHilite(hiliteID);
     }-*/;

    public native void enableHilite(String hiliteID, boolean enable) /*-{
         var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
         self.enableHilite(hiliteID, enable);
     }-*/;

    public native void disableHilite(String hiliteID) /*-{
         var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
         self.disableHilite(hiliteID);
     }-*/;

    public native void enableHiliting() /*-{
         var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
         self.enableHiliting();
     }-*/;

    public native void enableHiliting(boolean enable) /*-{
         var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
         self.enableHiliting(enable);
     }-*/;

    public native void disableHiliting() /*-{
         var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
         self.disableHiliting();
     }-*/;

    public native Record[] getDragData() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordsJS = self.getDragData();
        return @com.smartgwt.client.data.Record::convertToRecordArray(Lcom/google/gwt/core/client/JavaScriptObject;)(recordsJS);
     }-*/;

    public native void transferSelectedData(DataBoundComponent source) /*-{
         var self = this.@com.smartgwt.client.widgets.DataBoundComponent::getOrCreateJsObj()();
         self.transferSelectedData(source.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()());
     }-*/;

    public native void transferSelectedData(DataBoundComponent source, int index) /*-{
         var self = this.@com.smartgwt.client.widgets.DataBoundComponent::getOrCreateJsObj()();
         self.transferSelectedData(source.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()(), index);
     }-*/;

    public native int getRecordIndex(Record record) /*-{
         var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
         return self.getRecordIndex(record.@com.smartgwt.client.core.DataClass::getJsObj()());
     }-*/;

    public native String getTitleFieldValue(Record record) /*-{
         var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
         return self.getTitleFieldValue(record);
     }-*/;

    public void setTitleField(String titleField) {
        setAttribute("titleField", titleField, true);
    }

    public String getTitleField() {
        return getAttributeAsString("titleField");
    }

    public native DataSource getDataSource() /*-{
        var dataSourceJS = this.@com.smartgwt.client.widgets.grid.ListGrid::getAttributeAsJavaScriptObject(Ljava/lang/String;)("dataSource");
        if ($wnd.isc.isA.String(dataSourceJS)) dataSourceJS = $wnd.isc.DataSource.get(dataSourceJS);
        return @com.smartgwt.client.data.DataSource::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(dataSourceJS);
    }-*/;

    public void setAutoFetchData(Boolean autoFetchData) throws IllegalStateException {
        setAttribute("autoFetchData", autoFetchData, false);
    }

    public Boolean getAutoFetchData() {
        return getAttributeAsBoolean("autoFetchData");
    }

    public void setAutoFetchTextMatchStyle(TextMatchStyle autoFetchTextMatchStyle) throws IllegalStateException {
        setAttribute("autoFetchTextMatchStyle", autoFetchTextMatchStyle.getValue(), false);
    }

    public TextMatchStyle getAutoFetchTextMatchStyle() {
        return TextMatchStyle.valueOf(getAttributeAsString("autoFetchTextMatchStyle"));
    }

    public void setAutoFetchAsFilter(Boolean autoFetchAsFilter) throws IllegalStateException {
        setAttribute("autoFetchAsFilter", autoFetchAsFilter, false);
    }

    public Boolean getAutoFetchAsFilter() {
        return getAttributeAsBoolean("autoFetchAsFilter");
    }

    public void setInitialCriteria(Criteria initialCriteria) throws IllegalStateException {
        setAttribute("initialCriteria", initialCriteria.getJsObj(), false);
    }

    public Criteria getInitialCriteria() {
        return new Criteria(getAttributeAsJavaScriptObject("initialCriteria"));
    }

    public void setImplicitCriteria(Criteria implicitCriteria) {
        if (implicitCriteria instanceof Criterion) {
            implicitCriteria.setAttribute("_constructor", "AdvancedCriteria");
        }
        setAttribute("implicitCriteria", implicitCriteria == null ? 
                     null : implicitCriteria.getJsObj(), true);
    }

    public Criteria getImplicitCriteria()  {
        return new Criteria(getAttributeAsJavaScriptObject("implicitCriteria"));
    }
    
    public native void fetchData() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.fetchData();
    }-*/;

    public native void fetchData(Criteria criteria) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        if(@com.smartgwt.client.data.Criterion::instanceOf(Ljava/lang/Object;)(criteria)){
    		var criteriaJ = criteria.@com.smartgwt.client.core.DataClass::getJsObj()();
	    	@com.smartgwt.client.util.JSOHelper::setAttribute(Lcom/google/gwt/core/client/JavaScriptObject;Ljava/lang/String;Ljava/lang/String;)(criteriaJ,"_constructor","AdvancedCriteria");
	    }
        self.fetchData(criteria == null ? null : criteria.@com.smartgwt.client.data.Criteria::getJsObj()());
    }-*/;

    public native void fetchData(Criteria criteria, DSCallback callback) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var critJS = criteria == null ? null : criteria.@com.smartgwt.client.data.Criteria::getJsObj()();
        if(@com.smartgwt.client.data.Criterion::instanceOf(Ljava/lang/Object;)(criteria)){
    		var criteriaJ = criteria.@com.smartgwt.client.core.DataClass::getJsObj()();
	    	@com.smartgwt.client.util.JSOHelper::setAttribute(Lcom/google/gwt/core/client/JavaScriptObject;Ljava/lang/String;Ljava/lang/String;)(criteriaJ,"_constructor","AdvancedCriteria");
	    }
        self.fetchData(critJS, $entry(function (dsResponse, data, dsRequest) {
            var responseJ = @com.smartgwt.client.data.DSResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsResponse);
            var requestJ = @com.smartgwt.client.data.DSRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsRequest);
            if(callback != null) callback.@com.smartgwt.client.data.DSCallback::execute(Lcom/smartgwt/client/data/DSResponse;Ljava/lang/Object;Lcom/smartgwt/client/data/DSRequest;)(responseJ, data, requestJ);
        }));
    }-*/;

    public native void fetchData(Criteria criteria, DSCallback callback, DSRequest requestProperties) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var critJS = criteria == null ? null : criteria.@com.smartgwt.client.data.Criteria::getJsObj()();
        var requestPropertiesJS = requestProperties == null ? null : requestProperties.@com.smartgwt.client.core.DataClass::getJsObj()();
    	if(@com.smartgwt.client.data.Criterion::instanceOf(Ljava/lang/Object;)(criteria)){
    		var criteriaJ = criteria.@com.smartgwt.client.core.DataClass::getJsObj()();
	    	@com.smartgwt.client.util.JSOHelper::setAttribute(Lcom/google/gwt/core/client/JavaScriptObject;Ljava/lang/String;Ljava/lang/String;)(criteriaJ,"_constructor","AdvancedCriteria");
	    }
        self.fetchData(critJS, $entry(function (dsResponse, data, dsRequest) {
            var responseJ = @com.smartgwt.client.data.DSResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsResponse);
            var requestJ = @com.smartgwt.client.data.DSRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsRequest);
            if(callback != null) callback.@com.smartgwt.client.data.DSCallback::execute(Lcom/smartgwt/client/data/DSResponse;Ljava/lang/Object;Lcom/smartgwt/client/data/DSRequest;)(responseJ, data, requestJ);
        }), requestPropertiesJS);
    }-*/;

    public native void filterData() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.filterData();
    }-*/;

    public native void filterData(Criteria criteria) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.filterData(criteria == null ? null : criteria.@com.smartgwt.client.data.Criteria::getJsObj()());
    }-*/;

    public native void filterData(Criteria criteria, DSCallback callback) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var critJS = criteria == null ? null : criteria.@com.smartgwt.client.data.Criteria::getJsObj()();
        if(@com.smartgwt.client.data.Criterion::instanceOf(Ljava/lang/Object;)(criteria)){
    		var criteriaJ = criteria.@com.smartgwt.client.core.DataClass::getJsObj()();
	    	@com.smartgwt.client.util.JSOHelper::setAttribute(Lcom/google/gwt/core/client/JavaScriptObject;Ljava/lang/String;Ljava/lang/String;)(criteriaJ,"_constructor","AdvancedCriteria");
	    }
        self.filterData(critJS, $entry(function (dsResponse, data, dsRequest) {
            var responseJ = @com.smartgwt.client.data.DSResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsResponse);
            var requestJ = @com.smartgwt.client.data.DSRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsRequest);
            if(callback != null) callback.@com.smartgwt.client.data.DSCallback::execute(Lcom/smartgwt/client/data/DSResponse;Ljava/lang/Object;Lcom/smartgwt/client/data/DSRequest;)(responseJ, data, requestJ);
        }));
    }-*/;

    public native void filterData(Criteria criteria, DSCallback callback, DSRequest requestProperties) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var critJS = criteria == null ? null : criteria.@com.smartgwt.client.data.Criteria::getJsObj()();
        var requestPropertiesJS = requestProperties == null ? null : requestProperties.@com.smartgwt.client.core.DataClass::getJsObj()();
        if(@com.smartgwt.client.data.Criterion::instanceOf(Ljava/lang/Object;)(criteria)){
    		var criteriaJ = criteria.@com.smartgwt.client.core.DataClass::getJsObj()();
	    	@com.smartgwt.client.util.JSOHelper::setAttribute(Lcom/google/gwt/core/client/JavaScriptObject;Ljava/lang/String;Ljava/lang/String;)(criteriaJ,"_constructor","AdvancedCriteria");
	    }
        self.filterData(critJS, $entry(function (dsResponse, data, dsRequest) {
            var responseJ = @com.smartgwt.client.data.DSResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsResponse);
            var requestJ = @com.smartgwt.client.data.DSRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsRequest);
            if(callback != null) callback.@com.smartgwt.client.data.DSCallback::execute(Lcom/smartgwt/client/data/DSResponse;Ljava/lang/Object;Lcom/smartgwt/client/data/DSRequest;)(responseJ, data, requestJ);
        }), requestPropertiesJS);
    }-*/;

    public native void invalidateCache() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.invalidateCache();
    }-*/;

    public ResultSet getResultSet() {
        JavaScriptObject dataJS = getAttributeAsJavaScriptObject("data");
        if(dataJS == null) return null;
        if(!ResultSet.isResultSet(dataJS)) {
            SC.logWarn("getResultSet(): data is not a ResultSet; returning null " +
                "(if grouped, use getOriginalResultSet(); if unbound, use getRecordList(); " +
                "can only be called on DataBoundComponents after initial data has been fetched)");
            return null;
        }
        return ResultSet.getOrCreateRef(dataJS);
    }

    public native RecordList getRecordList() /*-{
        var dataJS = this.@com.smartgwt.client.widgets.DataBoundComponent::getDataAsJSList()();
        if (dataJS == null) return null;
        if ($wnd.isc.isA.ResultSet(dataJS)) {
            return this.@com.smartgwt.client.widgets.DataBoundComponent::getResultSet()();
        } else if ($wnd.isc.isA.ResultTree(dataJS)) {
            return @com.smartgwt.client.widgets.tree.ResultTree::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(dataJS);
        } else if ($wnd.isc.isA.Tree(dataJS)) {
            return @com.smartgwt.client.widgets.tree.Tree::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(dataJS);
        }
        return @com.smartgwt.client.data.RecordList::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dataJS);
    }-*/;

    public native JavaScriptObject getDataAsJSList() /*-{
    	var self = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
    	if (self == null) return null;
    	return self.getDataAsList();
    	
    }-*/;

    public native void exportData() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.exportData();
    }-*/;

    public native void exportData(DSRequest requestProperties) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.exportData(requestProperties.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;

    /**
     * Add a fetchData handler.
     * <p>
     * Notification function fired on fetchData() or filterData()
     *
     * @param handler the filterData handler
     * @return {@link com.google.gwt.event.shared.HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addFetchDataHandler(FetchDataHandler handler) {
        if(getHandlerCount(FetchDataEvent.getType()) == 0) setupFetchDataEvent();
        return doAddHandler(handler, FetchDataEvent.getType());
    }

    private native void setupFetchDataEvent() /*-{
        var obj = null;
        var selfJ = this;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            obj.addProperties({onFetchData:$debox($entry(function(){
                    var param = {"_this": this, "criteria" : arguments[0], "requestProperties" : arguments[1]};
                    var event = @com.smartgwt.client.widgets.events.FetchDataEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                }))
            });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.onFetchData = $debox($entry(function(){
                var param = {"_this": this, "criteria" : arguments[0], "requestProperties" : arguments[1]};
                var event = @com.smartgwt.client.widgets.events.FetchDataEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            }));
        }
    }-*/;

    /**
     * Add a {@link com.smartgwt.client.widgets.DropCompleteHandler}.  See that class's documentation for a definition of "drop complete",
     * and how it differs from "drag complete" ({@link com.smartgwt.client.widgets.DragCompleteHandler}).
     *
     * @param handler the DropCompleteHandler
     * @return {@link com.google.gwt.event.shared.HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addDropCompleteHandler(DropCompleteHandler handler) {
        if(getHandlerCount(DropCompleteEvent.getType()) == 0) setupDropCompleteEvent();
        return doAddHandler(handler, DropCompleteEvent.getType());
    }

    private native void setupDropCompleteEvent() /*-{
        var obj = null;
        var selfJ = this;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            obj.addProperties({dropComplete:$debox($entry(function(){
                    var param = {"_this": this, "transferredRecords" : arguments[0]};
                    var event = @com.smartgwt.client.widgets.events.DropCompleteEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                }))
            });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.dropComplete = $debox($entry(function(){
                var param = {"_this": this, "transferredRecords" : arguments[0]};
                var event = @com.smartgwt.client.widgets.events.DropCompleteEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            }));
        }
    }-*/;

    /**
     * Add a {@link com.smartgwt.client.widgets.DragCompleteHandler}.  See that class's documentation for a definition of "drag complete",
     * and how it differs from "drop complete" ({@link com.smartgwt.client.widgets.DropCompleteHandler}).
     *
     * @param handler the DropCompleteHandler
     * @return {@link com.google.gwt.event.shared.HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addDragCompleteHandler(DragCompleteHandler handler) {
        if(getHandlerCount(DragCompleteEvent.getType()) == 0) setupDragCompleteEvent();
        return doAddHandler(handler, DragCompleteEvent.getType());
    }

    private native void setupDragCompleteEvent() /*-{
        var obj = null;
        var selfJ = this;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            obj.addProperties({dragComplete:$debox($entry(function(){
                    var param = {"_this": this};
                    var event = @com.smartgwt.client.widgets.events.DragCompleteEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                }))
            });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.dragComplete = $debox($entry(function(){
                var param = {"_this": this, "transferredRecords" : arguments[0]};
                var event = @com.smartgwt.client.widgets.events.DragCompleteEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            }));
        }
    }-*/;

    public native Alignment[] getFieldAlignments()/*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var alignJS = self.getFieldAlignments();
        return @com.smartgwt.client.util.ConvertTo::arrayOfAlignment(Lcom/google/gwt/core/client/JavaScriptObject;)(alignJS);
    }-*/;

    public Boolean getDeepCloneOnEdit() {
        return getAttributeAsBoolean("deepCloneOnEdit");
    }

    public void setDeepCloneOnEdit(Boolean deepCloneOnEdit) {
        setAttribute("deepCloneOnEdit", deepCloneOnEdit, true);
    }

    public void setFields(JavaScriptObject... fields) {
        if (fields != null) for(int i = 0; i < fields.length; i++) {
            fields[i] = duplicateFieldConfig(JSOHelper.cleanProperties(fields[i], false));
        }
        setAttribute("fields", fields, true);
    }

    private native JavaScriptObject duplicateFieldConfig(JavaScriptObject config) /*-{
        return $wnd.isc.shallowClone(config);
    }-*/;

    public JavaScriptObject[] getFieldsAsJavaScriptObjects() {
        JavaScriptObject fieldsJsArray = getAttributeAsJavaScriptObject("fields");
        return JSOHelper.isArray(fieldsJsArray) ? JSOHelper.toArray(fieldsJsArray) : null;
    }

    public int getFieldCount() {
        JavaScriptObject[] fields = getFieldsAsJavaScriptObjects();
        return fields != null ? fields.length : 0;
    }
    
    /**
     * During a drag-and-drop interaction, this method returns the set of records being dragged
     * out of the component.  In the default implementation, this is the list of currently
     * selected records.<p>
     * This method is consulted by
     * {@link com.smartgwt.client.widgets.grid.ListGrid#willAcceptDrop willAcceptDrop()}.
     * @param DragDataCustomizer customizer
     */
    public native void setDragDataCustomizer(DragDataCustomizer customizer) /*-{
        var self;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            self = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            self = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }
        var componentJ = this;
        self.getDragData = $debox($entry(function() {
        	var returnJ = customizer.@com.smartgwt.client.widgets.DragDataCustomizer::getDragData(Lcom/smartgwt/client/widgets/DataBoundComponent;)(componentJ);
        	return @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(returnJ);
    	}));
    }-*/;


    /**
     * Setter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject setLogicalStructure(TileGridLogicalStructure s) {
        super.setLogicalStructure(s);
        try {
            s.animateTileChange = getAttributeAsString("animateTileChange");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TileGrid.animateTileChange:" + t.getMessage() + "\n";
        }
        try {
            s.canAcceptDroppedRecords = getAttributeAsString("canAcceptDroppedRecords");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TileGrid.canAcceptDroppedRecords:" + t.getMessage() + "\n";
        }
        try {
            s.canDragTilesOut = getAttributeAsString("canDragTilesOut");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TileGrid.canDragTilesOut:" + t.getMessage() + "\n";
        }
        try {
            s.canReorderTiles = getAttributeAsString("canReorderTiles");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TileGrid.canReorderTiles:" + t.getMessage() + "\n";
        }
        try {
            s.dataFetchMode = getAttributeAsString("dataFetchMode");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TileGrid.dataFetchMode:" + t.getMessage() + "\n";
        }
        try {
            s.drawAllMaxTiles = getAttributeAsString("drawAllMaxTiles");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TileGrid.drawAllMaxTiles:" + t.getMessage() + "\n";
        }
        try {
            s.emptyMessage = getAttributeAsString("emptyMessage");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TileGrid.emptyMessage:" + t.getMessage() + "\n";
        }
        try {
            s.emptyMessageStyle = getAttributeAsString("emptyMessageStyle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TileGrid.emptyMessageStyle:" + t.getMessage() + "\n";
        }
        try {
            s.loadingMessage = getAttributeAsString("loadingMessage");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TileGrid.loadingMessage:" + t.getMessage() + "\n";
        }
        try {
            s.printTilesPerLine = getAttributeAsString("printTilesPerLine");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TileGrid.printTilesPerLine:" + t.getMessage() + "\n";
        }
        try {
            s.recycleTiles = getAttributeAsString("recycleTiles");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TileGrid.recycleTiles:" + t.getMessage() + "\n";
        }
        try {
            s.selectionType = getAttributeAsString("selectionType");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TileGrid.selectionType:" + t.getMessage() + "\n";
        }
        try {
            s.showAllRecords = getAttributeAsString("showAllRecords");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TileGrid.showAllRecords:" + t.getMessage() + "\n";
        }
        try {
            s.showDetailFields = getAttributeAsString("showDetailFields");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TileGrid.showDetailFields:" + t.getMessage() + "\n";
        }
        try {
            s.showEmptyMessage = getAttributeAsString("showEmptyMessage");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TileGrid.showEmptyMessage:" + t.getMessage() + "\n";
        }
        try {
            s.styleName = getAttributeAsString("styleName");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TileGrid.styleName:" + t.getMessage() + "\n";
        }
        try {
            s.tileConstructor = getAttributeAsString("tileConstructor");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TileGrid.tileConstructor:" + t.getMessage() + "\n";
        }
        try {
            s.tileDragAppearance = getAttributeAsString("tileDragAppearance");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TileGrid.tileDragAppearance:" + t.getMessage() + "\n";
        }
        try {
            s.tiles = getTiles();
        } catch (Throwable t) {
            s.logicalStructureErrors += "TileGrid.tilesArray:" + t.getMessage() + "\n";
        }
        try {
            s.tileValueAlign = getAttributeAsString("tileValueAlign");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TileGrid.tileValueAlign:" + t.getMessage() + "\n";
        }
        try {
            s.tileValueStyle = getAttributeAsString("tileValueStyle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TileGrid.tileValueStyle:" + t.getMessage() + "\n";
        }
        try {
            s.valuesShowDown = getAttributeAsString("valuesShowDown");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TileGrid.valuesShowDown:" + t.getMessage() + "\n";
        }
        try {
            s.valuesShowRollOver = getAttributeAsString("valuesShowRollOver");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TileGrid.valuesShowRollOver:" + t.getMessage() + "\n";
        }
        try {
            s.valuesShowSelected = getAttributeAsString("valuesShowSelected");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TileGrid.valuesShowSelected:" + t.getMessage() + "\n";
        }
        try {
            s.wrapValues = getAttributeAsString("wrapValues");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TileGrid.wrapValues:" + t.getMessage() + "\n";
        }
        return s;
    }

    /**
     * Getter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject getLogicalStructure() {
        TileGridLogicalStructure s = new TileGridLogicalStructure();
        setLogicalStructure(s);
        return s;
    }
}
