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
 * Saves changes made in a form (validates first).
 * @see com.smartgwt.client.widgets.form.DynamicForm#saveData
 */
@BeanFactory.FrameworkClass
@BeanFactory.ScClassName("FormSaveDataTask")
public class FormSaveDataTask extends ComponentTask {

    public static FormSaveDataTask getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        BaseClass obj = BaseClass.getRef(jsObj);
        if(obj != null) {
            return (FormSaveDataTask) obj;
        } else {
            return new FormSaveDataTask(jsObj);
        }
    }
        


    public FormSaveDataTask(){
        scClassName = "FormSaveDataTask";
    }

    public FormSaveDataTask(JavaScriptObject jsObj){
        scClassName = "FormSaveDataTask";
        setJavaScriptObject(jsObj);
    }

    public native JavaScriptObject create()/*-{
        var config = this.@com.smartgwt.client.core.BaseClass::getConfig()();
        var scClassName = this.@com.smartgwt.client.core.BaseClass::scClassName;
        return $wnd.isc[scClassName].create(config);
    }-*/;

    // ********************* Properties / Attributes ***********************

    /**
     * The default message to be shown when a target form is bound to a DataSource.
     *
     * @param boundNotifyMessage New boundNotifyMessage value. Default value is "${dsTitle} saved successfully"
     * @return {@link com.smartgwt.client.util.workflow.FormSaveDataTask FormSaveDataTask} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public FormSaveDataTask setBoundNotifyMessage(String boundNotifyMessage)  throws IllegalStateException {
        return (FormSaveDataTask)setAttribute("boundNotifyMessage", boundNotifyMessage, false);
    }

    /**
     * The default message to be shown when a target form is bound to a DataSource.
     *
     * @return Current boundNotifyMessage value. Default value is "${dsTitle} saved successfully"
     */
    public String getBoundNotifyMessage()  {
        return getAttributeAsString("boundNotifyMessage");
    }
    

    /**
     * The form be {@link com.smartgwt.client.widgets.form.DynamicForm#clearValues cleared} after a successful save unless this
     * property is set to <code>false</code>.
     *
     * @param clearAfterSave New clearAfterSave value. Default value is true
     * @return {@link com.smartgwt.client.util.workflow.FormSaveDataTask FormSaveDataTask} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public FormSaveDataTask setClearAfterSave(Boolean clearAfterSave)  throws IllegalStateException {
        return (FormSaveDataTask)setAttribute("clearAfterSave", clearAfterSave, false);
    }

    /**
     * The form be {@link com.smartgwt.client.widgets.form.DynamicForm#clearValues cleared} after a successful save unless this
     * property is set to <code>false</code>.
     *
     * @return Current clearAfterSave value. Default value is true
     */
    public Boolean getClearAfterSave()  {
        Boolean result = getAttributeAsBoolean("clearAfterSave");
        return result == null ? true : result;
    }
    

    /**
     * ID of the next sequence or element to proceed to if a failure condition arises from operation.
     *
     * @param failureElement New failureElement value. Default value is null
     * @return {@link com.smartgwt.client.util.workflow.FormSaveDataTask FormSaveDataTask} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public FormSaveDataTask setFailureElement(String failureElement)  throws IllegalStateException {
        return (FormSaveDataTask)setAttribute("failureElement", failureElement, false);
    }

    /**
     * ID of the next sequence or element to proceed to if a failure condition arises from operation.
     *
     * @return Current failureElement value. Default value is null
     */
    public String getFailureElement()  {
        return getAttributeAsString("failureElement");
    }
    

    /**
     * The message to be shown when save completes if {@link
     * com.smartgwt.client.util.workflow.FormSaveDataTask#getShowNotification showNotification} is set. If no message is
     * configured a default message is used based on the whether the form is bound to a DataSource or not: {@link
     * com.smartgwt.client.util.workflow.FormSaveDataTask#getBoundNotifyMessage boundNotifyMessage} or {@link
     * com.smartgwt.client.util.workflow.FormSaveDataTask#getUnboundNotifyMessage unboundNotifyMessage}.
     *
     * @param notifyMessage New notifyMessage value. Default value is null
     * @return {@link com.smartgwt.client.util.workflow.FormSaveDataTask FormSaveDataTask} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public FormSaveDataTask setNotifyMessage(String notifyMessage)  throws IllegalStateException {
        return (FormSaveDataTask)setAttribute("notifyMessage", notifyMessage, false);
    }

    /**
     * The message to be shown when save completes if {@link
     * com.smartgwt.client.util.workflow.FormSaveDataTask#getShowNotification showNotification} is set. If no message is
     * configured a default message is used based on the whether the form is bound to a DataSource or not: {@link
     * com.smartgwt.client.util.workflow.FormSaveDataTask#getBoundNotifyMessage boundNotifyMessage} or {@link
     * com.smartgwt.client.util.workflow.FormSaveDataTask#getUnboundNotifyMessage unboundNotifyMessage}.
     *
     * @return Current notifyMessage value. Default value is null
     */
    public String getNotifyMessage()  {
        return getAttributeAsString("notifyMessage");
    }
    

    /**
     * Where to show the message, specified as an edge ("T", "B", "R", "L") similar to {@link
     * com.smartgwt.client.widgets.Canvas#getSnapTo Canvas.snapTo}, or "C" for center.  The message will be shown at the center
     * of the edge specified (or the very center for "C").
     *
     * @param notifyPosition New notifyPosition value. Default value is "T"
     * @return {@link com.smartgwt.client.util.workflow.FormSaveDataTask FormSaveDataTask} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public FormSaveDataTask setNotifyPosition(String notifyPosition)  throws IllegalStateException {
        return (FormSaveDataTask)setAttribute("notifyPosition", notifyPosition, false);
    }

    /**
     * Where to show the message, specified as an edge ("T", "B", "R", "L") similar to {@link
     * com.smartgwt.client.widgets.Canvas#getSnapTo Canvas.snapTo}, or "C" for center.  The message will be shown at the center
     * of the edge specified (or the very center for "C").
     *
     * @return Current notifyPosition value. Default value is "T"
     */
    public String getNotifyPosition()  {
        return getAttributeAsString("notifyPosition");
    }
    

    /**
     * NotifyType for {@link com.smartgwt.client.util.workflow.FormSaveDataTask#getNotifyMessage notifyMessage}.
     *
     * @param notifyType New notifyType value. Default value is "message"
     * @return {@link com.smartgwt.client.util.workflow.FormSaveDataTask FormSaveDataTask} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     * @see com.smartgwt.client.docs.NotifyType NotifyType 
     */
    public FormSaveDataTask setNotifyType(String notifyType)  throws IllegalStateException {
        return (FormSaveDataTask)setAttribute("notifyType", notifyType, false);
    }

    /**
     * NotifyType for {@link com.smartgwt.client.util.workflow.FormSaveDataTask#getNotifyMessage notifyMessage}.
     *
     * @return Current notifyType value. Default value is "message"
     * @see com.smartgwt.client.docs.NotifyType NotifyType 
     */
    public String getNotifyType()  {
        return getAttributeAsString("notifyType");
    }
    

    /**
     * Does this processElement pass through output from the last executed task (i.e. transient state)? <P> See {@link
     * com.smartgwt.client.docs.TaskInputExpression taskInputExpressions} for details on the transient state outputs. <p> Note
     * that this property does not affect the task at all but is an indicator to the user and to the workflow editor of the
     * behavior of the task as coded (See {@link com.smartgwt.client.util.workflow.Process#passThruTaskOutput
     * Process.passThruTaskOutput()}).
     *
     * @param passThruOutput New passThruOutput value. Default value is false
     * @return {@link com.smartgwt.client.util.workflow.FormSaveDataTask FormSaveDataTask} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public FormSaveDataTask setPassThruOutput(Boolean passThruOutput)  throws IllegalStateException {
        return (FormSaveDataTask)setAttribute("passThruOutput", passThruOutput, false);
    }

    /**
     * Does this processElement pass through output from the last executed task (i.e. transient state)? <P> See {@link
     * com.smartgwt.client.docs.TaskInputExpression taskInputExpressions} for details on the transient state outputs. <p> Note
     * that this property does not affect the task at all but is an indicator to the user and to the workflow editor of the
     * behavior of the task as coded (See {@link com.smartgwt.client.util.workflow.Process#passThruTaskOutput
     * Process.passThruTaskOutput()}).
     *
     * @return Current passThruOutput value. Default value is false
     */
    public Boolean getPassThruOutput()  {
        Boolean result = getAttributeAsBoolean("passThruOutput");
        return result == null ? false : result;
    }
    

    /**
     * Additional properties to set on the DSRequest that will be issued to perform save. <p> Note that
     * <code>willHandleError</code> will always be set <code>true</code>.
     *
     * @param requestProperties New requestProperties value. Default value is null
     * @return {@link com.smartgwt.client.util.workflow.FormSaveDataTask FormSaveDataTask} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public FormSaveDataTask setRequestProperties(DSRequest requestProperties)  throws IllegalStateException {
        JavaScriptObject config = JSOHelper.createObject();
        if (requestProperties != null) {
            JSOHelper.addProperties(config, requestProperties.getJsObj());
        }
        return (FormSaveDataTask)setAttribute("requestProperties", requestProperties == null ? null : config, false);
    }

    /**
     * Additional properties to set on the DSRequest that will be issued to perform save. <p> Note that
     * <code>willHandleError</code> will always be set <code>true</code>.
     *
     * @return Current requestProperties value. Default value is null
     */
    public DSRequest getRequestProperties()  {
        return new DSRequest(getAttributeAsJavaScriptObject("requestProperties"));
    }
    

    /**
     * Should a notification message (defined as notifyMessage) be shown after save completes successfully?
     *
     * @param showNotification New showNotification value. Default value is null
     * @return {@link com.smartgwt.client.util.workflow.FormSaveDataTask FormSaveDataTask} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public FormSaveDataTask setShowNotification(Boolean showNotification)  throws IllegalStateException {
        return (FormSaveDataTask)setAttribute("showNotification", showNotification, false);
    }

    /**
     * Should a notification message (defined as notifyMessage) be shown after save completes successfully?
     *
     * @return Current showNotification value. Default value is null
     */
    public Boolean getShowNotification()  {
        return getAttributeAsBoolean("showNotification");
    }
    

    /**
     * The default message to be shown when a target form is not bound to a DataSource.
     *
     * @param unboundNotifyMessage New unboundNotifyMessage value. Default value is "Saved successfully"
     * @return {@link com.smartgwt.client.util.workflow.FormSaveDataTask FormSaveDataTask} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public FormSaveDataTask setUnboundNotifyMessage(String unboundNotifyMessage)  throws IllegalStateException {
        return (FormSaveDataTask)setAttribute("unboundNotifyMessage", unboundNotifyMessage, false);
    }

    /**
     * The default message to be shown when a target form is not bound to a DataSource.
     *
     * @return Current unboundNotifyMessage value. Default value is "Saved successfully"
     */
    public String getUnboundNotifyMessage()  {
        return getAttributeAsString("unboundNotifyMessage");
    }
    

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************

    // ***********************************************************

}
