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
 * Show an informational message and wait for the user to acknowledge.
 */
@BeanFactory.FrameworkClass
@BeanFactory.ScClassName("ShowMessageTask")
public class ShowMessageTask extends ProcessElement {

    public static ShowMessageTask getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        BaseClass obj = BaseClass.getRef(jsObj);
        if(obj != null) {
            return (ShowMessageTask) obj;
        } else {
            return new ShowMessageTask(jsObj);
        }
    }
        


    public ShowMessageTask(){
        scClassName = "ShowMessageTask";
    }

    public ShowMessageTask(JavaScriptObject jsObj){
        scClassName = "ShowMessageTask";
        setJavaScriptObject(jsObj);
    }

    public native JavaScriptObject create()/*-{
        var config = this.@com.smartgwt.client.core.BaseClass::getConfig()();
        var scClassName = this.@com.smartgwt.client.core.BaseClass::scClassName;
        return $wnd.isc[scClassName].create(config);
    }-*/;

    // ********************* Properties / Attributes ***********************

    /**
     * Message to display. To display a dynamic message see {@link
     * com.smartgwt.client.util.workflow.ShowMessageTask#getTextFormula textFormula}.
     *
     * @param message New message value. Default value is null
     * @return {@link com.smartgwt.client.util.workflow.ShowMessageTask ShowMessageTask} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public ShowMessageTask setMessage(String message)  throws IllegalStateException {
        return (ShowMessageTask)setAttribute("message", message, false);
    }

    /**
     * Message to display. To display a dynamic message see {@link
     * com.smartgwt.client.util.workflow.ShowMessageTask#getTextFormula textFormula}.
     *
     * @return Current message value. Default value is null
     */
    public String getMessage()  {
        return getAttributeAsString("message");
    }
    

    /**
     * Formula to be used to calculate the message contents. Use {@link
     * com.smartgwt.client.util.workflow.ShowMessageTask#getMessage message} property to assign a static message instead. <p> 
     * Available fields for use in the formula are the current {@link com.smartgwt.client.widgets.Canvas#getRuleScope rule
     * context}.
     *
     * @param textFormula New textFormula value. Default value is null
     * @return {@link com.smartgwt.client.util.workflow.ShowMessageTask ShowMessageTask} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public ShowMessageTask setTextFormula(UserSummary textFormula)  throws IllegalStateException {
        return (ShowMessageTask)setAttribute("textFormula", textFormula == null ? null : textFormula.getJsObj(), false);
    }

    /**
     * Formula to be used to calculate the message contents. Use {@link
     * com.smartgwt.client.util.workflow.ShowMessageTask#getMessage message} property to assign a static message instead. <p> 
     * Available fields for use in the formula are the current {@link com.smartgwt.client.widgets.Canvas#getRuleScope rule
     * context}.
     *
     * @return Current textFormula value. Default value is null
     */
    public UserSummary getTextFormula()  {
        return new UserSummary(getAttributeAsJavaScriptObject("textFormula"));
    }
    

    /**
     * Message type.
     *
     * @param type New type value. Default value is "normal"
     * @return {@link com.smartgwt.client.util.workflow.ShowMessageTask ShowMessageTask} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public ShowMessageTask setType(ShowMessageType type)  throws IllegalStateException {
        return (ShowMessageTask)setAttribute("type", type == null ? null : type.getValue(), false);
    }

    /**
     * Message type.
     *
     * @return Current type value. Default value is "normal"
     */
    public ShowMessageType getType()  {
        return EnumUtil.getEnum(ShowMessageType.values(), getAttribute("type"));
    }
    

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************

    // ***********************************************************

}
