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


/**
 * Export data currently shown in a grid keeping all grid-specific formatting.
 * @see com.smartgwt.client.widgets.grid.ListGrid#exportClientData
 */
@BeanFactory.FrameworkClass
@BeanFactory.ScClassName("GridExportClientDataTask")
public class GridExportClientDataTask extends ComponentTask {

    public static GridExportClientDataTask getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        BaseClass obj = BaseClass.getRef(jsObj);
        if(obj != null) {
            return (GridExportClientDataTask) obj;
        } else {
            return new GridExportClientDataTask(jsObj);
        }
    }
        


    public GridExportClientDataTask(){
        scClassName = "GridExportClientDataTask";
    }

    public GridExportClientDataTask(JavaScriptObject jsObj){
        scClassName = "GridExportClientDataTask";
        setJavaScriptObject(jsObj);
    }

    public native JavaScriptObject create()/*-{
        var config = this.@com.smartgwt.client.core.BaseClass::getConfig()();
        var scClassName = this.@com.smartgwt.client.core.BaseClass::scClassName;
        return $wnd.isc[scClassName].create(config);
    }-*/;

    // ********************* Properties / Attributes ***********************

    /**
     * Additional properties to set on the DSRequest that will be issued to perform client-side export.
     *
     * @param requestProperties New requestProperties value. Default value is null
     * @return {@link com.smartgwt.client.util.workflow.GridExportClientDataTask GridExportClientDataTask} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public GridExportClientDataTask setRequestProperties(DSRequest requestProperties)  throws IllegalStateException {
        JavaScriptObject config = JSOHelper.createObject();
        if (requestProperties != null) {
            JSOHelper.addProperties(config, requestProperties.getJsObj());
        }
        return (GridExportClientDataTask)setAttribute("requestProperties", requestProperties == null ? null : config, false);
    }

    /**
     * Additional properties to set on the DSRequest that will be issued to perform client-side export.
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
