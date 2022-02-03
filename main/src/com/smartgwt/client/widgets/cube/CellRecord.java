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
 
package com.smartgwt.client.widgets.cube;


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
 * A CellRecord represents the data for one cell of the body area. <P> Each CellRecord should be an object that minimally
 * has a property named after each visible facetId with the value being a facetValueId from that facet, and also a value
 * for {@link com.smartgwt.client.widgets.cube.CubeGrid#getValueProperty CubeGrid.valueProperty}. <P> Cell records can
 * contain any other properties desired, such as cell ids, or values for facets not initially shown.
 */
@BeanFactory.FrameworkClass
public class CellRecord extends ListGridRecord {

    public static CellRecord getOrCreateRef(JavaScriptObject jsObj) {
        if (jsObj == null) return null;

        final RefDataClass existingObj = RefDataClass.getRef(jsObj);

        if (existingObj instanceof CellRecord) {
            existingObj.setJsObj(jsObj);
            return (CellRecord)existingObj;
        } else

        {
            return new CellRecord(jsObj);
        }
    }
        


    public CellRecord(){
        
    }

    public CellRecord(JavaScriptObject jsObj){
        
        setJavaScriptObject(jsObj);
    }


    // ********************* Properties / Attributes ***********************

    /**
     * Default property name denoting whether this record is enabled. Property name may be modified for some grid via {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getRecordEnabledProperty ListGrid.recordEnabledProperty}.
     *
     * @param enabled New enabled value. Default value is null
     * @return {@link com.smartgwt.client.widgets.cube.CellRecord CellRecord} instance, for chaining setter calls
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#grid_interaction_disabled_rows" target="examples">Disabled rows Example</a>
     */
    public CellRecord setEnabled(Boolean enabled) {
        return (CellRecord)setAttribute("enabled", enabled);
    }

    /**
     * Default property name denoting whether this record is enabled. Property name may be modified for some grid via {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getRecordEnabledProperty ListGrid.recordEnabledProperty}.
     *
     * @return Current enabled value. Default value is null
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#grid_interaction_disabled_rows" target="examples">Disabled rows Example</a>
     */
    public Boolean getEnabled()  {
        return getAttributeAsBoolean("enabled", true);
    }
    

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************

    // ***********************************************************

}
