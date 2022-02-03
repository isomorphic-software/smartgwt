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
 
package com.smartgwt.client.util.workflow;


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
 * Select or deselect one or more records as specified by criteria. Target records will also be scrolled into view or, for
 * a tree, parent folders will be opened to reveal the node. <p> Task Output: <ul>   <li>On a select, the set of newly
 * selected records is the output, even if other records       are also selected.   <li>On a deselect, the entire set of
 * de-selected records is the output. </ul>
 */
@BeanFactory.FrameworkClass
@BeanFactory.ScClassName("GridSelectRecordsTask")
public class GridSelectRecordsTask extends ComponentTask {

    public static GridSelectRecordsTask getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        BaseClass obj = BaseClass.getRef(jsObj);
        if(obj != null) {
            return (GridSelectRecordsTask) obj;
        } else {
            return new GridSelectRecordsTask(jsObj);
        }
    }
        


    public GridSelectRecordsTask(){
        scClassName = "GridSelectRecordsTask";
    }

    public GridSelectRecordsTask(JavaScriptObject jsObj){
        scClassName = "GridSelectRecordsTask";
        setJavaScriptObject(jsObj);
    }

    public native JavaScriptObject create()/*-{
        var config = this.@com.smartgwt.client.core.BaseClass::getConfig()();
        var scClassName = this.@com.smartgwt.client.core.BaseClass::scClassName;
        return $wnd.isc[scClassName].create(config);
    }-*/;

    // ********************* Properties / Attributes ***********************

    /**
     * Criteria defining the records that should be selected or deselected. All records are selected or deselected if not
     * specified. <P> To target a single record just specify criteria for its primary key.
     *
     * @param criteria New criteria value. Default value is null
     * @return {@link com.smartgwt.client.util.workflow.GridSelectRecordsTask GridSelectRecordsTask} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public GridSelectRecordsTask setCriteria(Criteria criteria)  throws IllegalStateException {
        if (criteria instanceof Criterion) {
            criteria.setAttribute("_constructor", "AdvancedCriteria");
        }
        return (GridSelectRecordsTask)setAttribute("criteria", criteria == null ? null : criteria.getJsObj(), false);
    }

    /**
     * Criteria defining the records that should be selected or deselected. All records are selected or deselected if not
     * specified. <P> To target a single record just specify criteria for its primary key.
     *
     * @return Current criteria value. Default value is null
     */
    public Criteria getCriteria()  {
        return new Criteria(getAttributeAsJavaScriptObject("criteria"));
    }
    

    /**
     * For grids that allow multiple selection, should any existing selection be retained? Only applies when selecting records.
     *
     * @param keepExistingSelection New keepExistingSelection value. Default value is null
     * @return {@link com.smartgwt.client.util.workflow.GridSelectRecordsTask GridSelectRecordsTask} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public GridSelectRecordsTask setKeepExistingSelection(Boolean keepExistingSelection)  throws IllegalStateException {
        return (GridSelectRecordsTask)setAttribute("keepExistingSelection", keepExistingSelection, false);
    }

    /**
     * For grids that allow multiple selection, should any existing selection be retained? Only applies when selecting records.
     *
     * @return Current keepExistingSelection value. Default value is null
     */
    public Boolean getKeepExistingSelection()  {
        return getAttributeAsBoolean("keepExistingSelection");
    }
    

    /**
     * Set to <code>false</code> to prevent the first affected record from being scrolled into view.
     *
     * @param scrollIntoView New scrollIntoView value. Default value is null
     * @return {@link com.smartgwt.client.util.workflow.GridSelectRecordsTask GridSelectRecordsTask} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public GridSelectRecordsTask setScrollIntoView(Boolean scrollIntoView)  throws IllegalStateException {
        return (GridSelectRecordsTask)setAttribute("scrollIntoView", scrollIntoView, false);
    }

    /**
     * Set to <code>false</code> to prevent the first affected record from being scrolled into view.
     *
     * @return Current scrollIntoView value. Default value is null
     */
    public Boolean getScrollIntoView()  {
        return getAttributeAsBoolean("scrollIntoView");
    }
    

    /**
     * Set to <code>false</code> to clear selection.
     *
     * @param select New select value. Default value is null
     * @return {@link com.smartgwt.client.util.workflow.GridSelectRecordsTask GridSelectRecordsTask} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public GridSelectRecordsTask setSelect(Boolean select)  throws IllegalStateException {
        return (GridSelectRecordsTask)setAttribute("select", select, false);
    }

    /**
     * Set to <code>false</code> to clear selection.
     *
     * @return Current select value. Default value is null
     */
    public Boolean getSelect()  {
        return getAttributeAsBoolean("select");
    }
    

    /**
     * Should multiple records matching {@link com.smartgwt.client.data.Criteria} be affected? If set to <code>false</code>
     * only the first matching record is affected.
     *
     * @param selectMultiple New selectMultiple value. Default value is null
     * @return {@link com.smartgwt.client.util.workflow.GridSelectRecordsTask GridSelectRecordsTask} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public GridSelectRecordsTask setSelectMultiple(Boolean selectMultiple)  throws IllegalStateException {
        return (GridSelectRecordsTask)setAttribute("selectMultiple", selectMultiple, false);
    }

    /**
     * Should multiple records matching {@link com.smartgwt.client.data.Criteria} be affected? If set to <code>false</code>
     * only the first matching record is affected.
     *
     * @return Current selectMultiple value. Default value is null
     */
    public Boolean getSelectMultiple()  {
        return getAttributeAsBoolean("selectMultiple");
    }
    

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************

    // ***********************************************************

}
