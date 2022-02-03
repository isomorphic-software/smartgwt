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
 
package com.smartgwt.client.data;


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


/**
 * A subclass of {@link com.smartgwt.client.data.ResultSet} designed to provide a synchronously filterable List interface
 * for an array of data. <P> Developers should set {@link com.smartgwt.client.data.FilteredList#getAllRows allRows} to the
 * full set of data objects, and use {@link com.smartgwt.client.data.ResultSet#getCriteria criteria} to the apply criteria
 * to the data set. Standard List APIs  such as {@link com.smartgwt.client.data.List#get List.get()}, {@link
 * com.smartgwt.client.data.List#getLength List.getLength()}, {@link com.smartgwt.client.data.List#getRange
 * List.getRange()}, etc will then  allow access to a filtered subset of this data. <P> The {@link
 * com.smartgwt.client.data.FilteredList#getDataSource dataSource} attribute may be used to specify the format of records
 * to be stored within this list, but this is not required. If no DataSource is explicitly specified, filteredList will
 * automatically generate its own DataSource with {@link com.smartgwt.client.data.DataSource#getDropUnknownCriteria
 * dropUnknownCriteria} set to false.
 */
@BeanFactory.FrameworkClass
@BeanFactory.ScClassName("FilteredList")
public class FilteredList extends ResultSet {

    public static FilteredList getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        BaseClass obj = BaseClass.getRef(jsObj);
        if(obj != null) {
            return (FilteredList) obj;
        } else {
            return new FilteredList(jsObj);
        }
    }
        


    public FilteredList(){
        scClassName = "FilteredList";
    }

    public FilteredList(JavaScriptObject jsObj){
        scClassName = "FilteredList";
        setJavaScriptObject(jsObj);
    }

    public native JavaScriptObject create()/*-{
        var config = this.@com.smartgwt.client.core.BaseClass::getConfig()();
        var scClassName = this.@com.smartgwt.client.core.BaseClass::scClassName;
        return $wnd.isc[scClassName].create(config);
    }-*/;

    // ********************* Properties / Attributes ***********************

    /**
     * Complete set of records for this filteredList. Sorting and filtering of this list will occur synchronously on the
     * client.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Updates {@link com.smartgwt.client.data.FilteredList#getAllRows allRows} at run time.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param allRows New set of unfiltered cache data. Default value is []
     * @return {@link com.smartgwt.client.data.FilteredList FilteredList} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public FilteredList setAllRows(Record... allRows)  throws IllegalStateException {
        return (FilteredList)setAttribute("allRows", allRows, false);
    }

    /**
     * Complete set of records for this filteredList. Sorting and filtering of this list will occur synchronously on the
     * client.
     *
     * @return Current allRows value. Default value is []
     */
    public Record[] getAllRows()  {
        return com.smartgwt.client.util.ConvertTo.arrayOfRecord(getAttributeAsJavaScriptObject("allRows"));
    }
    

    /**
     * Optional dataSource to specifying field names and types for records within this List. Note that since a full data set
     * should be provided to the list via {@link com.smartgwt.client.data.FilteredList#getAllRows allRows}, this filteredList
     * will not issue fetch requests against this DataSource. <P> If no DataSource was explicitly specified, filteredList will
     * automatically generate its own DataSource with {@link com.smartgwt.client.data.DataSource#getDropUnknownCriteria
     * dropUnknownCriteria} set to false.
     *
     * @param dataSource New dataSource value. Default value is null
     * @return {@link com.smartgwt.client.data.FilteredList FilteredList} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public FilteredList setDataSource(DataSource dataSource)  throws IllegalStateException {
        return (FilteredList)setAttribute("dataSource", dataSource == null ? null : dataSource.getOrCreateJsObj(), false);
    }

    /**
     * Optional dataSource to specifying field names and types for records within this List. Note that since a full data set
     * should be provided to the list via {@link com.smartgwt.client.data.FilteredList#getAllRows allRows}, this filteredList
     * will not issue fetch requests against this DataSource. <P> If no DataSource was explicitly specified, filteredList will
     * automatically generate its own DataSource with {@link com.smartgwt.client.data.DataSource#getDropUnknownCriteria
     * dropUnknownCriteria} set to false.
     *
     * @return Current dataSource value. Default value is null
     */
    public DataSource getDataSource()  {
        return DataSource.getOrCreateRef(getAttributeAsJavaScriptObject("dataSource"));
    }
    

    /**
     * When true, allows the ResultSet to be modified by list APIs {@link com.smartgwt.client.data.List#addAt List.addAt()},
     * {@link com.smartgwt.client.data.List#set List.set()}, and {@link com.smartgwt.client.data.List#removeAt
     * List.removeAt()}.  Only applies to  {@link com.smartgwt.client.data.ResultSet#getFetchMode fetchMode}:"local"
     * ResultSets, since in all other cases, such modifications would break the consistency of server and client row numbering
     * needed for data paging, and also create some issues with automatic cache synchronization.  See the "Modifying
     * ResultSets" subtopic in the {@link com.smartgwt.client.data.ResultSet ResultSet Overview} for the alternative approach
     * of updating the {@link com.smartgwt.client.data.DataSource}. <P> One known case where modification can be useful is when
     * an array has been passed to {@link com.smartgwt.client.widgets.grid.ListGrid#setData ListGrid.setData()} for a ListGrid
     * with {@link com.smartgwt.client.widgets.grid.ListGrid#getFilterLocalData ListGrid.filterLocalData}:true.  If the data is
     * filtered using the {@link com.smartgwt.client.widgets.grid.ListGrid#getShowFilterEditor filterEditor}, then a new local
     * ResultSet will be created as {@link com.smartgwt.client.widgets.grid.ListGrid#getData data} to reflect the filtering.
     *
     * @param modifiable New modifiable value. Default value is true
     * @return {@link com.smartgwt.client.data.FilteredList FilteredList} instance, for chaining setter calls
     * @see com.smartgwt.client.data.DataSource#addData
     * @see com.smartgwt.client.data.DataSource#removeData
     * @see com.smartgwt.client.data.DataSource#updateCaches
     */
    public FilteredList setModifiable(boolean modifiable) {
        return (FilteredList)setAttribute("modifiable", modifiable, true);
    }

    /**
     * When true, allows the ResultSet to be modified by list APIs {@link com.smartgwt.client.data.List#addAt List.addAt()},
     * {@link com.smartgwt.client.data.List#set List.set()}, and {@link com.smartgwt.client.data.List#removeAt
     * List.removeAt()}.  Only applies to  {@link com.smartgwt.client.data.ResultSet#getFetchMode fetchMode}:"local"
     * ResultSets, since in all other cases, such modifications would break the consistency of server and client row numbering
     * needed for data paging, and also create some issues with automatic cache synchronization.  See the "Modifying
     * ResultSets" subtopic in the {@link com.smartgwt.client.data.ResultSet ResultSet Overview} for the alternative approach
     * of updating the {@link com.smartgwt.client.data.DataSource}. <P> One known case where modification can be useful is when
     * an array has been passed to {@link com.smartgwt.client.widgets.grid.ListGrid#setData ListGrid.setData()} for a ListGrid
     * with {@link com.smartgwt.client.widgets.grid.ListGrid#getFilterLocalData ListGrid.filterLocalData}:true.  If the data is
     * filtered using the {@link com.smartgwt.client.widgets.grid.ListGrid#getShowFilterEditor filterEditor}, then a new local
     * ResultSet will be created as {@link com.smartgwt.client.widgets.grid.ListGrid#getData data} to reflect the filtering.
     *
     * @return Current modifiable value. Default value is true
     * @see com.smartgwt.client.data.DataSource#addData
     * @see com.smartgwt.client.data.DataSource#removeData
     * @see com.smartgwt.client.data.DataSource#updateCaches
     */
    public boolean getModifiable()  {
        Boolean result = getAttributeAsBoolean("modifiable");
        return result == null ? true : result;
    }
    

    // ********************* Methods ***********************
	/**
     * Invoking invalidateCache() will have no effect on a filteredList. To drop the <i>allRows</i> cache of data, consider
     * passing an empty array to  {@link com.smartgwt.client.data.FilteredList#setAllRows setAllRows()}.
     */
    public native void invalidateCache() /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "invalidateCache", "");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.invalidateCache();
    }-*/;


    // ********************* Static Methods ***********************

    // ***********************************************************

}
