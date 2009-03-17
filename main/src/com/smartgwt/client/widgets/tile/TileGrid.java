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
import com.smartgwt.client.widgets.layout.*;
import com.smartgwt.client.widgets.menu.*;
import com.smartgwt.client.widgets.tab.*;
import com.smartgwt.client.widgets.toolbar.*;
import com.smartgwt.client.widgets.tree.*;
import com.smartgwt.client.widgets.tree.events.*;
import com.smartgwt.client.widgets.viewer.*;
import com.smartgwt.client.widgets.calendar.*;
import com.smartgwt.client.widgets.calendar.events.*;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;
import com.smartgwt.client.util.JSOHelper;
import com.smartgwt.client.util.EnumUtil;
import com.google.gwt.event.shared.*;
import com.google.gwt.event.shared.HasHandlers;
   /**
    * A TileGrid is a ${isc.DocUtils.linkForRef('interface:DataBoundComponent')} that displays a list of objects as a set of "tiles", where each tile represents one object, and the tiles are laid out in a grid with multiple tiles per row.  Each tile displays one or more properties of the object it represents.

    */


public class TileGrid extends TileLayout  implements DataBoundComponent, com.smartgwt.client.widgets.tile.events.HasRecordClickHandlers, com.smartgwt.client.widgets.tile.events.HasSelectionChangedHandlers {

    public static TileGrid getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        BaseWidget obj = BaseWidget.getRef(jsObj);
        if(obj != null) {
            return (TileGrid) obj;
        } else {
            return new TileGrid(jsObj);
        }
    }


    public TileGrid(){
        
    }

    public TileGrid(JavaScriptObject jsObj){
        super(jsObj);
    }

    protected native JavaScriptObject create()/*-{
        var config = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        var widget = $wnd.isc.TileGrid.create(config);
        this.@com.smartgwt.client.widgets.BaseWidget::doInit()();
        return widget;
    }-*/;
    // ********************* Properties / Attributes ***********************

    /**
    * By default, TileGrids will not show fields marked {@link com.smartgwt.client.data.DataSourceField#getDetail detail} in the DataSource.  See also {@link com.smartgwt.client.widgets.tile.TileGrid#getFields fields}.
    *
    * @param showDetailFields showDetailFields Default value is false
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setShowDetailFields(Boolean showDetailFields)  throws IllegalStateException {
        setAttribute("showDetailFields", showDetailFields, false);
    }
    /**
     * By default, TileGrids will not show fields marked {@link com.smartgwt.client.data.DataSourceField#getDetail detail} in the DataSource.  See also {@link com.smartgwt.client.widgets.tile.TileGrid#getFields fields}.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getShowDetailFields()  {
        return getAttributeAsBoolean("showDetailFields");
    }

    /**
    * When using the default {@link com.smartgwt.client..SimpleTile}, CSS style for each value shown within a tile.
    *
    * @param tileValueStyle tileValueStyle Default value is "tileValue"
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setTileValueStyle(String tileValueStyle)  throws IllegalStateException {
        setAttribute("tileValueStyle", tileValueStyle, false);
    }
    /**
     * When using the default {@link com.smartgwt.client..SimpleTile}, CSS style for each value shown within a tile.
     *
     *
     * @return String
     *
     */
    public String getTileValueStyle()  {
        return getAttributeAsString("tileValueStyle");
    }

    /**
    * Horizontal alignment for tile values: "left", "right" or "center".
    *
    * @param tileValueAlign tileValueAlign Default value is "center"
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setTileValueAlign(String tileValueAlign)  throws IllegalStateException {
        setAttribute("tileValueAlign", tileValueAlign, false);
    }
    /**
     * Horizontal alignment for tile values: "left", "right" or "center".
     *
     *
     * @return String
     *
     */
    public String getTileValueAlign()  {
        return getAttributeAsString("tileValueAlign");
    }

    /**
    * If true, when this component is first drawn, automatically call <code>this.fetchData()</code> or <code>this.filterData()</code> depending on {@link com.smartgwt.client.widgets.tile.TileGrid#getAutoFetchAsFilter autoFetchAsFilter}. Criteria for this fetch may be picked up from {@link com.smartgwt.client.widgets.tile.TileGrid#getInitialCriteria initialCriteria}.
    *
    * @param autoFetchData autoFetchData Default value is false
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setAutoFetchData(Boolean autoFetchData)  throws IllegalStateException {
        setAttribute("autoFetchData", autoFetchData, false);
    }
    /**
     * If true, when this component is first drawn, automatically call <code>this.fetchData()</code> or <code>this.filterData()</code> depending on {@link com.smartgwt.client.widgets.tile.TileGrid#getAutoFetchAsFilter autoFetchAsFilter}. Criteria for this fetch may be picked up from {@link com.smartgwt.client.widgets.tile.TileGrid#getInitialCriteria initialCriteria}.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getAutoFetchData()  {
        return getAttributeAsBoolean("autoFetchData");
    }

    /**
    * If {@link com.smartgwt.client.widgets.tile.TileGrid#getAutoFetchData autoFetchData} is <code>true</code>, this attribute determines whether the initial fetch operation should be performed via {@link com.smartgwt.client.widgets.tile.TileGrid#fetchData} or ${isc.DocUtils.linkForRef('filterData')}
    *
    * @param autoFetchAsFilter autoFetchAsFilter Default value is false
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setAutoFetchAsFilter(Boolean autoFetchAsFilter)  throws IllegalStateException {
        setAttribute("autoFetchAsFilter", autoFetchAsFilter, false);
    }
    /**
     * If {@link com.smartgwt.client.widgets.tile.TileGrid#getAutoFetchData autoFetchData} is <code>true</code>, this attribute determines whether the initial fetch operation should be performed via {@link com.smartgwt.client.widgets.tile.TileGrid#fetchData} or ${isc.DocUtils.linkForRef('filterData')}
     *
     *
     * @return Boolean
     *
     */
    public Boolean getAutoFetchAsFilter()  {
        return getAttributeAsBoolean("autoFetchAsFilter");
    }
             
    /**
    * Defines a tileGrid's clickable-selection behavior.
    *
    * @param selectionType selectionType Default value is Selection.MULTIPLE
    */
    public void setSelectionType(SelectionStyle selectionType) {
        setAttribute("selectionType", selectionType.getValue(), true);
    }
    /**
     * Defines a tileGrid's clickable-selection behavior.
     *
     *
     * @return SelectionStyle
     *
     */
    public SelectionStyle getSelectionType()  {
        return (SelectionStyle) EnumUtil.getEnum(SelectionStyle.values(), getAttribute("selectionType"));
    }

    /**
    * Whether tiles are created and drawn for all records, or only for those currently visible.
    *
    * @param showAllRecords showAllRecords Default value is false
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setShowAllRecords(Boolean showAllRecords)  throws IllegalStateException {
        setAttribute("showAllRecords", showAllRecords, false);
    }
    /**
     * Whether tiles are created and drawn for all records, or only for those currently visible.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getShowAllRecords()  {
        return getAttributeAsBoolean("showAllRecords");
    }
 

    /**
    * Style for the overall TileGrid component.
    *
    * @param styleName styleName Default value is "tileGrid"
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setStyleName(String styleName)  throws IllegalStateException {
        setAttribute("styleName", styleName, false);
    }
    /**
     * Style for the overall TileGrid component.
     *
     *
     * @return String
     *
     */
    public String getStyleName()  {
        return getAttributeAsString("styleName");
    }
             
    /**
    * Indicates what to do with data dragged into another DataBoundComponent. See          DragDataAction type for details.
    *
    * @param dragDataAction dragDataAction Default value is Canvas.MOVE
    */
    public void setDragDataAction(DragDataAction dragDataAction) {
        setAttribute("dragDataAction", dragDataAction.getValue(), true);
    }
    /**
     * Indicates what to do with data dragged into another DataBoundComponent. See          DragDataAction type for details.
     *
     *
     * @return DragDataAction
     *
     */
    public DragDataAction getDragDataAction()  {
        return (DragDataAction) EnumUtil.getEnum(DragDataAction.values(), getAttribute("dragDataAction"));
    }

    // ********************* Methods ***********************

        /**
         * Uses a "fetch" operation on the current {@link com.smartgwt.client..DataBoundComponent#getDataSource dataSource} to  retrieve data that matches the current filter and sort criteria for this component, then  exports the resulting data to a file or window in the requested format. <P> For more information on exporting data, see {@link com.smartgwt.client.data.DataSource#exportData}.
         */
        public native void exportData() /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.exportData();
        }-*/;

        /**
         * Uses a "fetch" operation on the current {@link com.smartgwt.client..DataBoundComponent#getDataSource dataSource} to  retrieve data that matches the current filter and sort criteria for this component, then  exports the resulting data to a file or window in the requested format. <P> For more information on exporting data, see {@link com.smartgwt.client.data.DataSource#exportData}.
         * @param requestProperties additional properties to set on the DSRequest                                            that will be issued
         */
        public native void exportData(DSRequest requestProperties) /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.exportData(requestProperties.@com.smartgwt.client.core.DataClass::getJsObj()());
        }-*/;




        /**
         * Return the first selected record in this component
         *
         * @return first selected record, or null if nothing selected
         */
        public native TileRecord getSelectedRecord() /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            var ret = self.getSelectedRecord();
            if(ret == null || ret === undefined) return null;
            var retVal = @com.smartgwt.client.core.RefDataClass::getRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
            if(retVal == null) {
                retVal = @com.smartgwt.client.widgets.tile.TileRecord::new(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
            }
            return retVal;
        }-*/;





        /**
         * Select all records
         */
        public native void selectAllRecords() /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.selectAllRecords();
        }-*/;

        /**
         * Deselect all records
         */
        public native void deselectAllRecords() /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.deselectAllRecords();
        }-*/;

        /**
         * Whether at least one item is selected
         *
         * @return true == at least one item is selected        false == nothing at all is selected
         */
        public native Boolean anySelected() /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            var retVal =self.anySelected();
            if(retVal == null || retVal === undefined) {
                return null;
            } else {
                return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
            }
        }-*/;






        /**
         * Add a recordClick handler.
         * <p>
         * Executed when the tileGrid receives a 'click' event on a tile. The default implementation does nothing -- override to perform some action when any record is clicked.<br> A record event handler can be specified either as a function to execute, or as a string of script to evaluate. If the handler is defined as a string of script, all the parameters below will be available as variables for use in the script.<br> If you want to cancel the click based on the parameters, return false. Otherwise, return  true so that the click event be registered with the tile.
         *
         * @param handler the recordClick handler
         */
        public HandlerRegistration addRecordClickHandler(com.smartgwt.client.widgets.tile.events.RecordClickHandler handler) {
            if(getHandlerCount(com.smartgwt.client.widgets.tile.events.RecordClickEvent.getType()) == 0) setupRecordClickEvent();
            return doAddHandler(handler, com.smartgwt.client.widgets.tile.events.RecordClickEvent.getType());
        }
        private native void setupRecordClickEvent() /*-{
            var obj = null;
            var selfJ = this;
            if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
                obj.addProperties({recordClick:function(){
                        var param = {"viewer" : arguments[0], "tile" : arguments[1], "record" : arguments[2]};
                        var event = @com.smartgwt.client.widgets.tile.events.RecordClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    }
                });
            } else {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
                obj.recordClick = function(){
                    var param = {"viewer" : arguments[0], "tile" : arguments[1], "record" : arguments[2]};
                    var event = @com.smartgwt.client.widgets.tile.events.RecordClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                };
            }
        }-*/;



        /**
         * Add a selectionChanged handler.
         * <p>
         * Called when selection changes within this tileGrid. Note this method fires for each record for which selection is modified - so when a user clicks inside a tileGrid this method will typically fire twice (once for the old record being deselected, and once for the new record being selected).
         *
         * @param handler the selectionChanged handler
         */
        public HandlerRegistration addSelectionChangedHandler(com.smartgwt.client.widgets.tile.events.SelectionChangedHandler handler) {
            if(getHandlerCount(com.smartgwt.client.widgets.tile.events.SelectionChangedEvent.getType()) == 0) setupSelectionChangedEvent();
            return doAddHandler(handler, com.smartgwt.client.widgets.tile.events.SelectionChangedEvent.getType());
        }
        private native void setupSelectionChangedEvent() /*-{
            var obj = null;
            var selfJ = this;
            if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
                obj.addProperties({selectionChanged:function(){
                        var param = {"record" : arguments[0], "state" : arguments[1]};
                        var event = @com.smartgwt.client.widgets.tile.events.SelectionChangedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    }
                });
            } else {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
                obj.selectionChanged = function(){
                    var param = {"record" : arguments[0], "state" : arguments[1]};
                    var event = @com.smartgwt.client.widgets.tile.events.SelectionChangedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                };
            }
        }-*/;

        /**
         * This is not allowed for tileGrid. Instead, use {@link com.smartgwt.client.widgets.tile.TileGrid#addData}.
         */
        public native void addTile() /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.addTile();
        }-*/;

        /**
         * This is not allowed for tileGrid. Instead, use {@link com.smartgwt.client.widgets.tile.TileGrid#removeData}.
         */
        public native void removeTile() /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.removeTile();
        }-*/;






    // ********************* Static Methods ***********************





    /**
     * Set the animateTileChange.
     *
     * @param animateTileChange the animateTileChange
     */
    public void setAnimateTileChange(Boolean animateTileChange) {
        setAttribute("animateTileChange", animateTileChange, true);
    }

    /**
     * Return the animateTileChange.
     *
     * @return the animateTileChange
     */
    public Boolean getAnimateTileChange() {
        return getAttributeAsBoolean("animateTileChange");
    }


    protected native void onInit() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self._getTileHTML = self.getTileHTML;
        self.getTileHTML = function(record) {
            var jObj = this.__ref;
            var recordJ = @com.smartgwt.client.widgets.tile.TileRecord::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(record);
            return jObj.@com.smartgwt.client.widgets.tile.TileGrid::getTileHTML(Lcom/smartgwt/client/widgets/tile/TileRecord;)(recordJ);
        };

        self._getTile = self.getTile;
        self.getTile = function(record) {
            var jObj = this.__ref;
            if(!$wnd.isc.isA.Number(record)) {
                var recordJ = @com.smartgwt.client.widgets.tile.TileRecord::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(record);
                var tile =  jObj.@com.smartgwt.client.widgets.tile.TileGrid::getTile(Lcom/smartgwt/client/widgets/tile/TileRecord;)(recordJ);
                return tile == null ? null : tile.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            } else {
                var tile =  jObj.@com.smartgwt.client.widgets.tile.TileGrid::getTile(I)(record);
                return tile == null ? null : tile.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            }
        };
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
    protected native String getTileHTML(TileRecord record) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        return self._getTileHTML(record.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;

    public native Canvas getTile(TileRecord record) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var canvasJS = self._getTile(record.@com.smartgwt.client.core.DataClass::getJsObj()());
        if(canvasJS == null) return null;
         var canvas = @com.smartgwt.client.widgets.Canvas::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(canvasJS);
        return canvas;
    }-*/;

    /**
     * This is an override point
     */
    public native Canvas getTile(int recordNum) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var canvasJS = self._getTile(recordNum);
        if(canvasJS == null) return null;
        var canvas = @com.smartgwt.client.widgets.Canvas::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(canvasJS);
        
        return canvas;
    }-*/;

    /**
     * The DataSource that this component should bind to for default fields and for performing&#010 DataSource
     * requests<P>
     *
     * @param dataSource dataSource Default value is null
     */
    public void setDataSource(DataSource dataSource) {
        setAttribute("dataSource", dataSource.getOrCreateJsObj(), true);
    }

    /**
     * The DataSource that this component should bind to for default fields and for performing {@link com.smartgwt.client.data.DSRequest}. <P> Can be specified as either a DataSource instance or the String ID of a DataSource.
     *
     * @return DataSource
     */
    public DataSource getDataSource() {
        return DataSource.getOrCreateRef(getAttributeAsJavaScriptObject("dataSource"));
    }

    /**
     * Array of field definitions to control the default rendering of tiles. <P> If not specified, if the DataSource has
     * an {@link com.smartgwt.client.data.DataSource#getIconField iconField}, only the <code>iconField</code> and {@link
     * com.smartgwt.client.data.DataSource#getTitleField titleField} will be shown. Otherwise, all non-{@link
     * com.smartgwt.client.data.DataSourceField#getHidden hidden} non-{@link com.smartgwt.client.data.DataSourceField#getDetail
     * detail} fields will be shown, similar to the default set of fields shown by a {@link
     * com.smartgwt.client.widgets.grid.ListGrid}. <P> Only applicable if using the default {@link
     * com.smartgwt.client..SimpleTile} class for tiles. <P> For SimpleTiles, it is possible to use {@link
     * com.smartgwt.client.widgets.viewer.DetailViewerField#getCellStyle} and  {@link
     * com.smartgwt.client.widgets.StatefulCanvas#getStateSuffix} to make a single field statefully styled: <pre>
     * isc.TileGrid.create({      fields:[          {name:'animalName'           getCellStyle : function (value, field,
     * record, viewer) {                  if (value == "Tiger") return "tigerStyle" +
     * viewer.currentTile.getStateSuffix();                    else return view.tileGrid.tileValueStyle +
     * viewer.currentTile.getStateSuffix();           }          }      ] }); </pre>
     *
     * @param fields fields Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setFields(DetailViewerField... fields) throws IllegalStateException {
        setAttribute("fields", fields, false);
    }

    /**
     * A List of TileRecord objects, specifying the data to be used to create the tiles.   <p> This property will
     * typically not be explicitly specified for databound TileGrids, where the data is returned from the server via
     * databound component methods such as {@link com.smartgwt.client.widgets.tile.TileGrid#fetchData}. In this case the
     * data objects will be set to a  {@link com.smartgwt.client.data.ResultSet} rather than a simple array.
     *
     * @param data data Default value is null
     */
    public void setData(TileRecord[] data) {
        setAttribute("data", data, false);
    }


    /**
     * A List of TileRecord objects, specifying the data to be used to create the tiles.
     *
     * @return the records in the TileGrid
     */
    public TileRecord[] getData() {
        JavaScriptObject dataJS = getAttributeAsJavaScriptObject("data");
        TileRecord[] data = convertToTileRecordRecordArray(dataJS);
        return data;
    }

    private static TileRecord[] convertToTileRecordRecordArray(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new TileRecord[]{};
        }
        JavaScriptObject[] componentsj = JSOHelper.toArray(nativeArray);
        TileRecord[] objects = new TileRecord[componentsj.length];
        for (int i = 0; i < componentsj.length; i++) {
            JavaScriptObject componentJS = componentsj[i];
            TileRecord obj = (TileRecord) RefDataClass.getRef(componentJS);
            if (obj == null) obj = new TileRecord(componentJS);
            objects[i] = obj;
        }
        return objects;
    }

    /**
     * Criteria to be used when {@link com.smartgwt.client.widgets.tile.TileGrid#getAutoFetchData autoFetchData} is
     * set.
     *
     * @param initialCriteria initialCriteria Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setInitialCriteria(Criteria initialCriteria) throws IllegalStateException {
        setAttribute("initialCriteria", initialCriteria.getJsObj(), false);
    }


    /**
     * Uses a "fetch" operation on the current {@link com.smartgwt.client.data.DataSource} to retrieve data that matches
     * the provided criteria, and displays the matching data in this component. <P> If there are a large number of
     * matching records, paging will automatically be enabled, so that initially a smaller number of records will be
     * retrieved and further records will be fetched as the user navigates the dataset. <P> When first called, this
     * method will create a {@link com.smartgwt.client.data.ResultSet}, which will be configured based on component
     * settings such as {@link com.smartgwt.client..DataBoundComponent#getFetchOperation fetchOperation} and {@link
     * com.smartgwt.client..DataBoundComponent#getDataPageSize dataPageSize}, as well as the general purpose {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getDataProperties dataProperties}.  The ResultSet is then available as
     * <code>component.data</code>. <P> Subsequent calls to fetchData() will simply call {@link
     * com.smartgwt.client.data.ResultSet#setCriteria} on the created ResultSet with the passed criteria. <P> In some
     * cases fetchData() will not need to context the server as the new criteria can be satisfied by performing a
     * client-side filter against the currently cached set of data. You can determine whether criteria will cause a
     * fetch by calling  {@link com.smartgwt.client.data.ResultSet#willFetchData}. <P> If you need to force a server
     * fetch, you can call {@link com.smartgwt.client.data.ResultSet#invalidateCache} via
     * <code>component.data.invalidateCache()</code> to do so.   <P> This method takes an optional callback parameter
     * (set to a ${isc.DocUtils.linkForRef('type:DSCallback')}) to fire when the fetch completes. Note that this
     * callback will not fire if no server fetch is performed. In this case the data is updated synchronously, so as
     * soon as this method completes you can interact with the new data. If necessary we recomment using  {@link
     * com.smartgwt.client.data.ResultSet#willFetchData} before calling this method to determine whether or not a server
     * fetch will occur. <P> In addition to the callback parameter for this method, developers can use  {@link
     * com.smartgwt.client.data.ResultSet#dataArrived} to be notified every time ResultSet data is loaded.  A
     * <code>dataArrived</code> method can be installed in the automatically created ResultSet by adding it to {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getDataProperties dataProperties}.
     */
    public native void fetchData() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.fetchData();
    }-*/;

    /**
     * Uses a "fetch" operation on the current {@link com.smartgwt.client.data.DataSource} to retrieve data that matches
     * the provided criteria, and displays the matching data in this component. <P> If there are a large number of
     * matching records, paging will automatically be enabled, so that initially a smaller number of records will be
     * retrieved and further records will be fetched as the user navigates the dataset. <P> When first called, this
     * method will create a {@link com.smartgwt.client.data.ResultSet}, which will be configured based on component
     * settings such as {@link com.smartgwt.client..DataBoundComponent#getFetchOperation fetchOperation} and {@link
     * com.smartgwt.client..DataBoundComponent#getDataPageSize dataPageSize}, as well as the general purpose {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getDataProperties dataProperties}.  The ResultSet is then available as
     * <code>component.data</code>. <P> Subsequent calls to fetchData() will simply call {@link
     * com.smartgwt.client.data.ResultSet#setCriteria} on the created ResultSet with the passed criteria. <P> In some
     * cases fetchData() will not need to context the server as the new criteria can be satisfied by performing a
     * client-side filter against the currently cached set of data. You can determine whether criteria will cause a
     * fetch by calling  {@link com.smartgwt.client.data.ResultSet#willFetchData}. <P> If you need to force a server
     * fetch, you can call {@link com.smartgwt.client.data.ResultSet#invalidateCache} via
     * <code>component.data.invalidateCache()</code> to do so.   <P> This method takes an optional callback parameter
     * (set to a ${isc.DocUtils.linkForRef('type:DSCallback')}) to fire when the fetch completes. Note that this
     * callback will not fire if no server fetch is performed. In this case the data is updated synchronously, so as
     * soon as this method completes you can interact with the new data. If necessary we recomment using  {@link
     * com.smartgwt.client.data.ResultSet#willFetchData} before calling this method to determine whether or not a server
     * fetch will occur. <P> In addition to the callback parameter for this method, developers can use  {@link
     * com.smartgwt.client.data.ResultSet#dataArrived} to be notified every time ResultSet data is loaded.  A
     * <code>dataArrived</code> method can be installed in the automatically created ResultSet by adding it to {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getDataProperties dataProperties}.
     *
     * @param criteria Search criteria.                       If a {@link com.smartgwt.client.widgets.form.DynamicForm}
     *                 is passed in as this argument                      instead of a raw criteria object, will be
     *                 derived by calling                      {@link com.smartgwt.client.widgets.form.DynamicForm#getValuesAsCriteria}
     */
    public native void fetchData(Criteria criteria) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.fetchData(criteria == null ? null : criteria.@com.smartgwt.client.data.Criteria::getJsObj()());
    }-*/;

    /**
     * Uses a "fetch" operation on the current {@link com.smartgwt.client.data.DataSource} to retrieve data that matches
     * the provided criteria, and displays the matching data in this component. <P> If there are a large number of
     * matching records, paging will automatically be enabled, so that initially a smaller number of records will be
     * retrieved and further records will be fetched as the user navigates the dataset. <P> When first called, this
     * method will create a {@link com.smartgwt.client.data.ResultSet}, which will be configured based on component
     * settings such as {@link com.smartgwt.client..DataBoundComponent#getFetchOperation fetchOperation} and {@link
     * com.smartgwt.client..DataBoundComponent#getDataPageSize dataPageSize}, as well as the general purpose {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getDataProperties dataProperties}.  The ResultSet is then available as
     * <code>component.data</code>. <P> Subsequent calls to fetchData() will simply call {@link
     * com.smartgwt.client.data.ResultSet#setCriteria} on the created ResultSet with the passed criteria. <P> In some
     * cases fetchData() will not need to context the server as the new criteria can be satisfied by performing a
     * client-side filter against the currently cached set of data. You can determine whether criteria will cause a
     * fetch by calling  {@link com.smartgwt.client.data.ResultSet#willFetchData}. <P> If you need to force a server
     * fetch, you can call {@link com.smartgwt.client.data.ResultSet#invalidateCache} via
     * <code>component.data.invalidateCache()</code> to do so.   <P> This method takes an optional callback parameter
     * (set to a ${isc.DocUtils.linkForRef('type:DSCallback')}) to fire when the fetch completes. Note that this
     * callback will not fire if no server fetch is performed. In this case the data is updated synchronously, so as
     * soon as this method completes you can interact with the new data. If necessary we recomment using  {@link
     * com.smartgwt.client.data.ResultSet#willFetchData} before calling this method to determine whether or not a server
     * fetch will occur. <P> In addition to the callback parameter for this method, developers can use  {@link
     * com.smartgwt.client.data.ResultSet#dataArrived} to be notified every time ResultSet data is loaded.  A
     * <code>dataArrived</code> method can be installed in the automatically created ResultSet by adding it to {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getDataProperties dataProperties}.
     *
     * @param criteria Search criteria.                       If a {@link com.smartgwt.client.widgets.form.DynamicForm}
     *                 is passed in as this argument                      instead of a raw criteria object, will be
     *                 derived by calling                      {@link com.smartgwt.client.widgets.form.DynamicForm#getValuesAsCriteria}
     * @param callback callback to invoke when a fetch is complete.  Fires                                          only
     *                 if server contact was required
     */
    public native void fetchData(Criteria criteria, DSCallback callback) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var critJS = criteria == null ? null : criteria.@com.smartgwt.client.data.Criteria::getJsObj()();
        self.fetchData(critJS, function (dsResponse, data, dsRequest) {
            var responseJ = @com.smartgwt.client.data.DSResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsResponse);
            var requestJ = @com.smartgwt.client.data.DSRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsRequest);
            if(callback != null) callback.@com.smartgwt.client.data.DSCallback::execute(Lcom/smartgwt/client/data/DSResponse;Ljava/lang/Object;Lcom/smartgwt/client/data/DSRequest;)(responseJ, data, requestJ);
        });
    }-*/;

    /**
     * Uses a "fetch" operation on the current {@link com.smartgwt.client.data.DataSource} to retrieve data that matches
     * the provided criteria, and displays the matching data in this component. <P> If there are a large number of
     * matching records, paging will automatically be enabled, so that initially a smaller number of records will be
     * retrieved and further records will be fetched as the user navigates the dataset. <P> When first called, this
     * method will create a {@link com.smartgwt.client.data.ResultSet}, which will be configured based on component
     * settings such as {@link com.smartgwt.client..DataBoundComponent#getFetchOperation fetchOperation} and {@link
     * com.smartgwt.client..DataBoundComponent#getDataPageSize dataPageSize}, as well as the general purpose {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getDataProperties dataProperties}.  The ResultSet is then available as
     * <code>component.data</code>. <P> Subsequent calls to fetchData() will simply call {@link
     * com.smartgwt.client.data.ResultSet#setCriteria} on the created ResultSet with the passed criteria. <P> In some
     * cases fetchData() will not need to context the server as the new criteria can be satisfied by performing a
     * client-side filter against the currently cached set of data. You can determine whether criteria will cause a
     * fetch by calling  {@link com.smartgwt.client.data.ResultSet#willFetchData}. <P> If you need to force a server
     * fetch, you can call {@link com.smartgwt.client.data.ResultSet#invalidateCache} via
     * <code>component.data.invalidateCache()</code> to do so.   <P> This method takes an optional callback parameter
     * (set to a ${isc.DocUtils.linkForRef('type:DSCallback')}) to fire when the fetch completes. Note that this
     * callback will not fire if no server fetch is performed. In this case the data is updated synchronously, so as
     * soon as this method completes you can interact with the new data. If necessary we recomment using  {@link
     * com.smartgwt.client.data.ResultSet#willFetchData} before calling this method to determine whether or not a server
     * fetch will occur. <P> In addition to the callback parameter for this method, developers can use  {@link
     * com.smartgwt.client.data.ResultSet#dataArrived} to be notified every time ResultSet data is loaded.  A
     * <code>dataArrived</code> method can be installed in the automatically created ResultSet by adding it to {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getDataProperties dataProperties}.
     *
     * @param criteria          Search criteria.                       If a {@link com.smartgwt.client.widgets.form.DynamicForm}
     *                          is passed in as this argument                      instead of a raw criteria object,
     *                          will be derived by calling                      {@link com.smartgwt.client.widgets.form.DynamicForm#getValuesAsCriteria}
     * @param callback          callback to invoke when a fetch is complete.  Fires
     *                          only if server contact was required
     * @param requestProperties additional properties to set on the DSRequest
     *                          that will be issued
     */
    public native void fetchData(Criteria criteria, DSCallback callback, DSRequest requestProperties) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var critJS = criteria == null ? null : criteria.@com.smartgwt.client.data.Criteria::getJsObj()();
        var requestPropertiesJS = requestProperties == null ? null : requestProperties.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.fetchData(critJS, function (dsResponse, data, dsRequest) {
            var responseJ = @com.smartgwt.client.data.DSResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsResponse);
            var requestJ = @com.smartgwt.client.data.DSRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsRequest);
            if(callback != null) callback.@com.smartgwt.client.data.DSCallback::execute(Lcom/smartgwt/client/data/DSResponse;Ljava/lang/Object;Lcom/smartgwt/client/data/DSRequest;)(responseJ, data, requestJ);
        }, requestPropertiesJS);
    }-*/;

    /**
     * Perform a DataSource "add" operation to add new records to this component's DataSource.
     *
     * @param record new record
     */
    public native void addData(Record record) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordJS = record.@com.smartgwt.client.data.Record::getJsObj()();
        self.addData(recordJS);
    }-*/;

    /**
     * Perform a DataSource "add" operation to add new records to this component's DataSource.
     *
     * @param record new record
     * @param callback  method to call on operation completion
     */
    public native void addData(Record record, DSCallback callback) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordJS = record.@com.smartgwt.client.data.Record::getJsObj()();
        self.addData(recordJS, function (dsResponse, data, dsRequest) {
            var responseJ = @com.smartgwt.client.data.DSResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsResponse);
            var requestJ = @com.smartgwt.client.data.DSRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsRequest);
            if(callback != null) callback.@com.smartgwt.client.data.DSCallback::execute(Lcom/smartgwt/client/data/DSResponse;Ljava/lang/Object;Lcom/smartgwt/client/data/DSRequest;)(responseJ, data, requestJ);
        });
    }-*/;

    /**
     * Perform a DataSource "add" operation to add new records to this component's DataSource.
     *
     * @param record         new record
     * @param callback          method to call on operation completion
     * @param requestProperties additional properties to set on the DSRequest
     *                          that will be issued
     */
    public native void addData(Record record, DSCallback callback, DSRequest requestProperties) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordJS = record.@com.smartgwt.client.data.Record::getJsObj()();
        var requestPropertiesJS = requestProperties == null ? null : requestProperties.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.addData(recordJS, function (dsResponse, data, dsRequest) {
            var responseJ = @com.smartgwt.client.data.DSResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsResponse);
            var requestJ = @com.smartgwt.client.data.DSRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsRequest);
            if(callback != null) callback.@com.smartgwt.client.data.DSCallback::execute(Lcom/smartgwt/client/data/DSResponse;Ljava/lang/Object;Lcom/smartgwt/client/data/DSRequest;)(responseJ, data, requestJ);
        }, requestPropertiesJS);
    }-*/;

    /**
     * Perform a DataSource "remove" operation to remove records from this component's DataSource.
     *
     * @param record primary key values of record to delete,                                           (or complete
     *             record)
     */
    public native void removeData(Record record) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordJS = record.@com.smartgwt.client.data.Record::getJsObj()();
        self.removeData(recordJS);
    }-*/;

    /**
     * Perform a DataSource "remove" operation to remove records from this component's DataSource.
     *
     * @param record     primary key values of record to delete,                                           (or complete
     *                 record)
     * @param callback method to call on operation completion
     */
    public native void removeData(Record record, DSCallback callback) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordJS = record.@com.smartgwt.client.data.Record::getJsObj()();
        self.removeData(recordJS, function (dsResponse, data, dsRequest) {
            var responseJ = @com.smartgwt.client.data.DSResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsResponse);
            var requestJ = @com.smartgwt.client.data.DSRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsRequest);
            if(callback != null) callback.@com.smartgwt.client.data.DSCallback::execute(Lcom/smartgwt/client/data/DSResponse;Ljava/lang/Object;Lcom/smartgwt/client/data/DSRequest;)(responseJ, data, requestJ);
        });
    }-*/;

    /**
     * Perform a DataSource "remove" operation to remove records from this component's DataSource.
     *
     * @param record              primary key values of record to delete,                                           (or
     *                          complete record)
     * @param callback          method to call on operation completion
     * @param requestProperties additional properties to set on the DSRequest
     *                          that will be issued
     */
    public native void removeData(Record record, DSCallback callback, DSRequest requestProperties) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordJS = record.@com.smartgwt.client.data.Record::getJsObj()();
        var requestPropertiesJS = requestProperties == null ? null : requestProperties.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.removeData(recordJS, function (dsResponse, data, dsRequest) {
            var responseJ = @com.smartgwt.client.data.DSResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsResponse);
            var requestJ = @com.smartgwt.client.data.DSRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsRequest);
            if(callback != null) callback.@com.smartgwt.client.data.DSCallback::execute(Lcom/smartgwt/client/data/DSResponse;Ljava/lang/Object;Lcom/smartgwt/client/data/DSRequest;)(responseJ, data, requestJ);
        }, requestPropertiesJS);
    }-*/;

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
     * Simulates a drag / drop type transfer of the selected records in some other component to this component, without requiring any user interaction.  This method acts on the dropped records  exactly as if they had been dropped in an actual drag / drop interaction, including any  special databound behavior invoked by calling {@link com.smartgwt.client.widgets.DataBoundComponent#getDropValues} for each dropped record. <P> To transfer <b>all</b> data in, for example, a {@link com.smartgwt.client.widgets.grid.ListGrid}, call grid.selection.selectAll() first. <P> See the ${isc.DocUtils.linkForRef('group:dragging')} documentation for an overview of list grid drag/drop data transfer.
     *
     * @param source source component from which the records will be tranferred
     */
    public native void transferSelectedData(DataBoundComponent source) /*-{
            var self = this.@com.smartgwt.client.widgets.DataBoundComponent::getOrCreateJsObj()();
            self.transferSelectedData(source.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()());
        }-*/;

    /**
     * Simulates a drag / drop type transfer of the selected records in some other component to this component, without requiring any user interaction.  This method acts on the dropped records  exactly as if they had been dropped in an actual drag / drop interaction, including any  special databound behavior invoked by calling {@link com.smartgwt.client.widgets.DataBoundComponent#getDropValues} for each dropped record. <P> To transfer <b>all</b> data in, for example, a {@link com.smartgwt.client.widgets.grid.ListGrid}, call grid.selection.selectAll() first. <P> See the ${isc.DocUtils.linkForRef('group:dragging')} documentation for an overview of list grid drag/drop data transfer.
     *
     * @param source source component from which the records will be tranferred
     * @param index  target index (drop position) of the rows within this grid.
     */
    public native void transferSelectedData(DataBoundComponent source, int index) /*-{
            var self = this.@com.smartgwt.client.widgets.DataBoundComponent::getOrCreateJsObj()();
            self.transferSelectedData(source.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()(), index);
        }-*/;

    /**
     * Returns all selected records, as an Array.
     *
     * @return list of records, empty list if nothing selected
     */
    public native TileRecord[] getSelection() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var selection =  self.getSelection();
        return @com.smartgwt.client.widgets.tile.TileGrid::convertToTileRecordArray(Lcom/google/gwt/core/client/JavaScriptObject;)(selection);
    }-*/;

    private static TileRecord[] convertToTileRecordArray(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new TileRecord[]{};
        }
        JavaScriptObject[] componentsj = JSOHelper.toArray(nativeArray);
        TileRecord[] objects = new TileRecord[componentsj.length];
        for (int i = 0; i < componentsj.length; i++) {
            JavaScriptObject componentJS = componentsj[i];
            TileRecord obj = (TileRecord) RefDataClass.getRef(componentJS);
            if (obj == null) obj = new TileRecord(componentJS);
            objects[i] = obj;
        }
        return objects;
    }

    /**
     * Deselect a ${isc.DocUtils.linkForRef('object:Record')} passed in explicitly, or by index. <P> Synonym for
     * <code>selectRecord(record, false)</code>
     *
     * @param record record (or row number) to deselect
     */
    public native void deselectRecord(Record record)/*-{
       var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
       var recordJS = record.@com.smartgwt.client.data.Record::getJsObj()();
       self.deselectRecord(recordJS);
    }-*/;

    /**
     * Deselect a ${isc.DocUtils.linkForRef('object:Record')} passed in explicitly, or by index. <P> Synonym for
     * <code>selectRecord(record, false)</code>
     *
     * @param record record (or row number) to deselect
     */
    public native void deselectRecord(int record)/*-{
       var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
       self.selectRecord(record);
    }-*/;

    /**
     * Deselect a list of ${isc.DocUtils.linkForRef('object:Record')}s passed in explicitly, or by index. <P> Synonym
     * for <code>selectRecords(records, false)</code>
     *
     * @param records records (or row numbers) to deselect
     */
    public native void deselectRecords(int[] records)/*-{
       var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
       var recordsJS = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([I)(records);
       self.deselectRecords(recordsJS);
    }-*/;

    /**
     * Deselect a list of ${isc.DocUtils.linkForRef('object:Record')}s passed in explicitly, or by index. <P> Synonym
     * for <code>selectRecords(records, false)</code>
     *
     * @param records records (or row numbers) to deselect
     */
    public native void deselectRecords(Record[] records)/*-{
       var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
       var recordsJS = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(records);
       self.deselectRecords(recordsJS);
    }-*/;

    /**
     * Select/deselect a ${isc.DocUtils.linkForRef('object:Record')} passed in explicitly, or by index.
     *
     * @param record record (or row number) to select
     */
    public native void selectRecord(Record record)/*-{
       var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
       var recordJS = record.@com.smartgwt.client.data.Record::getJsObj()();
       self.selectRecord(recordJS);
    }-*/;

    /**
     * Select/deselect a ${isc.DocUtils.linkForRef('object:Record')} passed in explicitly, or by index.
     *
     * @param record record (or row number) to select
     */
    public native void selectRecord(int record)/*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.selectRecord(record);
    }-*/;

    /**
     * Select/deselect a ${isc.DocUtils.linkForRef('object:Record')} passed in explicitly, or by index.
     *
     * @param record   record (or row number) to select
     * @param newState new selection state (if null, defaults to true)
     */
    public native void selectRecord(int record, boolean newState)/*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.selectRecord(record, newState);
    }-*/;

    /**
     * Select/deselect a ${isc.DocUtils.linkForRef('object:Record')} passed in explicitly, or by index.
     *
     * @param record   record (or row number) to select
     * @param newState new selection state (defaults to true)
     */
    public native void selectRecord(Record record, boolean newState)/*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordJS = record.@com.smartgwt.client.data.Record::getJsObj()();
        self.selectRecord(recordJS, newState);
    }-*/;

    /**
     * Select/deselect a list of ${isc.DocUtils.linkForRef('object:Record')}s passed in explicitly, or by index.
     *
     * @param records records (or row numbers) to select
     */
    public native void selectRecords(int[] records)/*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordsJS = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([I)(records);
        self.selectRecord(recordsJS);
    }-*/;

    /**
     * Select/deselect a list of ${isc.DocUtils.linkForRef('object:Record')}s passed in explicitly, or by index.
     *
     * @param records records (or row numbers) to select
     * @param newState new selection state (defaults to true)
     */
    public native void selectRecords(int[] records, boolean newState)/*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordsJS = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([I)(records);
        self.selectRecords(recordsJS, newState);
    }-*/;

    /**
     * Select/deselect a list of ${isc.DocUtils.linkForRef('object:Record')}s passed in explicitly, or by index.
     *
     * @param records records (or row numbers) to select
     */
    public native void selectRecords(Record[] records)/*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordsJS = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(records);
        self.selectRecords(recordsJS);
     }-*/;

    /**
     * Select/deselect a list of ${isc.DocUtils.linkForRef('object:Record')}s passed in explicitly, or by index.
     *
     * @param records  records (or row numbers) to select
     * @param newState new selection state (defaults to true)
     */
    public native void selectRecords(Record[] records, boolean newState)/*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordsJS = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(records);
        self.selectRecords(recordsJS, newState);
     }-*/;


}





