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

/**
 * Settings to control optional {@link com.smartgwt.client.data.DataSource#load DataSource loading} features.
 * @see com.smartgwt.client.data.DataSource#load
 */
@BeanFactory.FrameworkClass
public class DSLoadSettings extends DataClass {

    public static DSLoadSettings getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        return new DSLoadSettings(jsObj);
    }
        


    public DSLoadSettings(){
        
    }

    public DSLoadSettings(JavaScriptObject jsObj){
        
        setJavaScriptObject(jsObj);
    }


    // ********************* Properties / Attributes ***********************

    /**
     * Forcibly reload a dataSource if it's already loaded.
     *
     * @param forceReload New forceReload value. Default value is null
     */
    public void setForceReload(Boolean forceReload) {
        setAttribute("forceReload", forceReload);
    }

    /**
     * Forcibly reload a dataSource if it's already loaded.
     *
     * @return Current forceReload value. Default value is null
     */
    public Boolean getForceReload()  {
        return getAttributeAsBoolean("forceReload", true);
    }
    

    /**
     * Load parent DataSources
     *
     * @param loadParents New loadParents value. Default value is null
     */
    public void setLoadParents(Boolean loadParents) {
        setAttribute("loadParents", loadParents);
    }

    /**
     * Load parent DataSources
     *
     * @return Current loadParents value. Default value is null
     */
    public Boolean getLoadParents()  {
        return getAttributeAsBoolean("loadParents", true);
    }
    

    /**
     * Place loaded DataSource into {@link com.smartgwt.client.data.DataSource#getMockMode mockMode}
     *
     * @param mockMode New mockMode value. Default value is null
     */
    public void setMockMode(Boolean mockMode) {
        setAttribute("mockMode", mockMode);
    }

    /**
     * Place loaded DataSource into {@link com.smartgwt.client.data.DataSource#getMockMode mockMode}
     *
     * @return Current mockMode value. Default value is null
     */
    public Boolean getMockMode()  {
        return getAttributeAsBoolean("mockMode", true);
    }
    

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************

    // ***********************************************************

}
