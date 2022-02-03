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
 * Show a component next to some other component.
 * @see com.smartgwt.client.widgets.Canvas#showNextTo
 */
@BeanFactory.FrameworkClass
@BeanFactory.ScClassName("ShowNextToComponentTask")
public class ShowNextToComponentTask extends ComponentTask {

    public static ShowNextToComponentTask getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        BaseClass obj = BaseClass.getRef(jsObj);
        if(obj != null) {
            return (ShowNextToComponentTask) obj;
        } else {
            return new ShowNextToComponentTask(jsObj);
        }
    }
        


    public ShowNextToComponentTask(){
        scClassName = "ShowNextToComponentTask";
    }

    public ShowNextToComponentTask(JavaScriptObject jsObj){
        scClassName = "ShowNextToComponentTask";
        setJavaScriptObject(jsObj);
    }

    public native JavaScriptObject create()/*-{
        var config = this.@com.smartgwt.client.core.BaseClass::getConfig()();
        var scClassName = this.@com.smartgwt.client.core.BaseClass::scClassName;
        return $wnd.isc[scClassName].create(config);
    }-*/;

    // ********************* Properties / Attributes ***********************

    /**
     * Can this component can be positioned on top of the other component if there isn't room to show next to it?
     *
     * @param canOcclude New canOcclude value. Default value is null
     * @return {@link com.smartgwt.client.util.workflow.ShowNextToComponentTask ShowNextToComponentTask} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public ShowNextToComponentTask setCanOcclude(Boolean canOcclude)  throws IllegalStateException {
        return (ShowNextToComponentTask)setAttribute("canOcclude", canOcclude, false);
    }

    /**
     * Can this component can be positioned on top of the other component if there isn't room to show next to it?
     *
     * @return Current canOcclude value. Default value is null
     */
    public Boolean getCanOcclude()  {
        return getAttributeAsBoolean("canOcclude");
    }
    

    /**
     * The other component where this component will show.
     *
     * @param nextToComponentId New nextToComponentId value. Default value is null
     * @return {@link com.smartgwt.client.util.workflow.ShowNextToComponentTask ShowNextToComponentTask} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     * @see com.smartgwt.client.docs.GlobalId GlobalId 
     */
    public ShowNextToComponentTask setNextToComponentId(String nextToComponentId)  throws IllegalStateException {
        return (ShowNextToComponentTask)setAttribute("nextToComponentId", nextToComponentId, false);
    }

    /**
     * The other component where this component will show.
     *
     * @return Current nextToComponentId value. Default value is null
     * @see com.smartgwt.client.docs.GlobalId GlobalId 
     */
    public String getNextToComponentId()  {
        return getAttributeAsString("nextToComponentId");
    }
    

    /**
     * Which side of the other canvas should we show? Options are "top", "bottom", "left", "right". (Defaults to "right")
     *
     * @param side New side value. Default value is null
     * @return {@link com.smartgwt.client.util.workflow.ShowNextToComponentTask ShowNextToComponentTask} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public ShowNextToComponentTask setSide(String side)  throws IllegalStateException {
        return (ShowNextToComponentTask)setAttribute("side", side, false);
    }

    /**
     * Which side of the other canvas should we show? Options are "top", "bottom", "left", "right". (Defaults to "right")
     *
     * @return Current side value. Default value is null
     */
    public String getSide()  {
        return getAttributeAsString("side");
    }
    

    /**
     * Set to <code>false</code> to not use animation to show component.
     *
     * @param skipAnimation New skipAnimation value. Default value is null
     * @return {@link com.smartgwt.client.util.workflow.ShowNextToComponentTask ShowNextToComponentTask} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public ShowNextToComponentTask setSkipAnimation(Boolean skipAnimation)  throws IllegalStateException {
        return (ShowNextToComponentTask)setAttribute("skipAnimation", skipAnimation, false);
    }

    /**
     * Set to <code>false</code> to not use animation to show component.
     *
     * @return Current skipAnimation value. Default value is null
     */
    public Boolean getSkipAnimation()  {
        return getAttributeAsBoolean("skipAnimation");
    }
    

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************

    // ***********************************************************

}
