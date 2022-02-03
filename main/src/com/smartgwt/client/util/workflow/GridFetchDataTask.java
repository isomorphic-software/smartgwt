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
 * Fetch data matching specified criteria into grid.
 * @see com.smartgwt.client.widgets.grid.ListGrid#fetchData
 */
@BeanFactory.FrameworkClass
@BeanFactory.ScClassName("GridFetchDataTask")
public class GridFetchDataTask extends ComponentTask {

    public static GridFetchDataTask getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        BaseClass obj = BaseClass.getRef(jsObj);
        if(obj != null) {
            return (GridFetchDataTask) obj;
        } else {
            return new GridFetchDataTask(jsObj);
        }
    }
        


    public GridFetchDataTask(){
        scClassName = "GridFetchDataTask";
    }

    public GridFetchDataTask(JavaScriptObject jsObj){
        scClassName = "GridFetchDataTask";
        setJavaScriptObject(jsObj);
    }

    public native JavaScriptObject create()/*-{
        var config = this.@com.smartgwt.client.core.BaseClass::getConfig()();
        var scClassName = this.@com.smartgwt.client.core.BaseClass::scClassName;
        return $wnd.isc[scClassName].create(config);
    }-*/;

    // ********************* Properties / Attributes ***********************

    /**
     * Should criteria be applied to the grid as {@link com.smartgwt.client.widgets.grid.ListGrid#getImplicitCriteria implicit
     * criteria}? When criteria is applied this way, it is not shown to the user and cannot be changed by the user.
     *
     * @param applyToImplicitCriteria New applyToImplicitCriteria value. Default value is null
     * @return {@link com.smartgwt.client.util.workflow.GridFetchDataTask GridFetchDataTask} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public GridFetchDataTask setApplyToImplicitCriteria(Boolean applyToImplicitCriteria)  throws IllegalStateException {
        return (GridFetchDataTask)setAttribute("applyToImplicitCriteria", applyToImplicitCriteria, false);
    }

    /**
     * Should criteria be applied to the grid as {@link com.smartgwt.client.widgets.grid.ListGrid#getImplicitCriteria implicit
     * criteria}? When criteria is applied this way, it is not shown to the user and cannot be changed by the user.
     *
     * @return Current applyToImplicitCriteria value. Default value is null
     */
    public Boolean getApplyToImplicitCriteria()  {
        return getAttributeAsBoolean("applyToImplicitCriteria");
    }
    

    /**
     * Criteria to use for fetch. If criteria is <code>null</code> or empty, the filter criteria of the grid will be cleared.
     *
     * @param criteria New criteria value. Default value is null
     * @return {@link com.smartgwt.client.util.workflow.GridFetchDataTask GridFetchDataTask} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public GridFetchDataTask setCriteria(Criteria criteria)  throws IllegalStateException {
        if (criteria instanceof Criterion) {
            criteria.setAttribute("_constructor", "AdvancedCriteria");
        }
        return (GridFetchDataTask)setAttribute("criteria", criteria == null ? null : criteria.getJsObj(), false);
    }

    /**
     * Criteria to use for fetch. If criteria is <code>null</code> or empty, the filter criteria of the grid will be cleared.
     *
     * @return Current criteria value. Default value is null
     */
    public Criteria getCriteria()  {
        return new Criteria(getAttributeAsJavaScriptObject("criteria"));
    }
    

    /**
     * Additional properties to set on the DSRequest that will be issued to perform the fetch or clear criteria.
     *
     * @param requestProperties New requestProperties value. Default value is null
     * @return {@link com.smartgwt.client.util.workflow.GridFetchDataTask GridFetchDataTask} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public GridFetchDataTask setRequestProperties(DSRequest requestProperties)  throws IllegalStateException {
        JavaScriptObject config = JSOHelper.createObject();
        if (requestProperties != null) {
            JSOHelper.addProperties(config, requestProperties.getJsObj());
        }
        return (GridFetchDataTask)setAttribute("requestProperties", requestProperties == null ? null : config, false);
    }

    /**
     * Additional properties to set on the DSRequest that will be issued to perform the fetch or clear criteria.
     *
     * @return Current requestProperties value. Default value is null
     */
    public DSRequest getRequestProperties()  {
        return new DSRequest(getAttributeAsJavaScriptObject("requestProperties"));
    }
    

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************

    // ***********************************************************

}
