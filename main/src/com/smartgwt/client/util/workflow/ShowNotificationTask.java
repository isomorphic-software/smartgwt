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
 * Show a message which fades out automatically using {@link com.smartgwt.client.widgets.notify.Notify}.
 */
@BeanFactory.FrameworkClass
@BeanFactory.ScClassName("ShowNotificationTask")
public class ShowNotificationTask extends ProcessElement {

    public static ShowNotificationTask getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        BaseClass obj = BaseClass.getRef(jsObj);
        if(obj != null) {
            return (ShowNotificationTask) obj;
        } else {
            return new ShowNotificationTask(jsObj);
        }
    }
        


    public ShowNotificationTask(){
        scClassName = "ShowNotificationTask";
    }

    public ShowNotificationTask(JavaScriptObject jsObj){
        scClassName = "ShowNotificationTask";
        setJavaScriptObject(jsObj);
    }

    public native JavaScriptObject create()/*-{
        var config = this.@com.smartgwt.client.core.BaseClass::getConfig()();
        var scClassName = this.@com.smartgwt.client.core.BaseClass::scClassName;
        return $wnd.isc[scClassName].create(config);
    }-*/;

    // ********************* Properties / Attributes ***********************

    /**
     * Auto-dismiss message after a short duration.
     *
     * @param autoDismiss New autoDismiss value. Default value is true
     * @return {@link com.smartgwt.client.util.workflow.ShowNotificationTask ShowNotificationTask} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public ShowNotificationTask setAutoDismiss(Boolean autoDismiss)  throws IllegalStateException {
        return (ShowNotificationTask)setAttribute("autoDismiss", autoDismiss, false);
    }

    /**
     * Auto-dismiss message after a short duration.
     *
     * @return Current autoDismiss value. Default value is true
     */
    public Boolean getAutoDismiss()  {
        Boolean result = getAttributeAsBoolean("autoDismiss");
        return result == null ? true : result;
    }
    

    /**
     * Message to display. To display a dynamic message see {@link
     * com.smartgwt.client.util.workflow.ShowNotificationTask#getTextFormula textFormula}.
     *
     * @param message New message value. Default value is null
     * @return {@link com.smartgwt.client.util.workflow.ShowNotificationTask ShowNotificationTask} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public ShowNotificationTask setMessage(String message)  throws IllegalStateException {
        return (ShowNotificationTask)setAttribute("message", message, false);
    }

    /**
     * Message to display. To display a dynamic message see {@link
     * com.smartgwt.client.util.workflow.ShowNotificationTask#getTextFormula textFormula}.
     *
     * @return Current message value. Default value is null
     */
    public String getMessage()  {
        return getAttributeAsString("message");
    }
    

    /**
     * NotifyType for message.
     *
     * @param notifyType New notifyType value. Default value is "message"
     * @return {@link com.smartgwt.client.util.workflow.ShowNotificationTask ShowNotificationTask} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     * @see com.smartgwt.client.docs.NotifyType NotifyType 
     */
    public ShowNotificationTask setNotifyType(String notifyType)  throws IllegalStateException {
        return (ShowNotificationTask)setAttribute("notifyType", notifyType, false);
    }

    /**
     * NotifyType for message.
     *
     * @return Current notifyType value. Default value is "message"
     * @see com.smartgwt.client.docs.NotifyType NotifyType 
     */
    public String getNotifyType()  {
        return getAttributeAsString("notifyType");
    }
    

    /**
     * Where to show the message, specified as an edge ("T", "B", "R", "L") similar to {@link
     * com.smartgwt.client.widgets.Canvas#getSnapTo Canvas.snapTo}, or "C" for center.  The message will be shown at the center
     * of the edge specified (or the very center for "C").
     *
     * @param position New position value. Default value is "T"
     * @return {@link com.smartgwt.client.util.workflow.ShowNotificationTask ShowNotificationTask} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public ShowNotificationTask setPosition(String position)  throws IllegalStateException {
        return (ShowNotificationTask)setAttribute("position", position, false);
    }

    /**
     * Where to show the message, specified as an edge ("T", "B", "R", "L") similar to {@link
     * com.smartgwt.client.widgets.Canvas#getSnapTo Canvas.snapTo}, or "C" for center.  The message will be shown at the center
     * of the edge specified (or the very center for "C").
     *
     * @return Current position value. Default value is "T"
     */
    public String getPosition()  {
        return getAttributeAsString("position");
    }
    

    /**
     * Formula to be used to calculate the message contents. Use {@link
     * com.smartgwt.client.util.workflow.ShowNotificationTask#getMessage message} property to assign a static message instead.
     * <p>  Available fields for use in the formula are the current {@link com.smartgwt.client.widgets.Canvas#getRuleScope rule
     * context}.
     *
     * @param textFormula New textFormula value. Default value is null
     * @return {@link com.smartgwt.client.util.workflow.ShowNotificationTask ShowNotificationTask} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public ShowNotificationTask setTextFormula(UserSummary textFormula)  throws IllegalStateException {
        return (ShowNotificationTask)setAttribute("textFormula", textFormula == null ? null : textFormula.getJsObj(), false);
    }

    /**
     * Formula to be used to calculate the message contents. Use {@link
     * com.smartgwt.client.util.workflow.ShowNotificationTask#getMessage message} property to assign a static message instead.
     * <p>  Available fields for use in the formula are the current {@link com.smartgwt.client.widgets.Canvas#getRuleScope rule
     * context}.
     *
     * @return Current textFormula value. Default value is null
     */
    public UserSummary getTextFormula()  {
        return new UserSummary(getAttributeAsJavaScriptObject("textFormula"));
    }
    

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************

    // ***********************************************************

}
