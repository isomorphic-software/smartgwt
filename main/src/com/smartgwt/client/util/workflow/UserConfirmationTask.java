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
 * Chooses one or another next process element based on confirmation of a message shown to user. <P> If the user clicks OK,
 * the {@link com.smartgwt.client.util.workflow.UserConfirmationTask#getNextElement nextElement} is chosen, otherwise the
 * choice is {@link com.smartgwt.client.util.workflow.UserConfirmationTask#getFailureElement failureElement}.
 */
@BeanFactory.FrameworkClass
@BeanFactory.ScClassName("UserConfirmationTask")
public class UserConfirmationTask extends ProcessElement {

    public static UserConfirmationTask getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        BaseClass obj = BaseClass.getRef(jsObj);
        if(obj != null) {
            return (UserConfirmationTask) obj;
        } else {
            return new UserConfirmationTask(jsObj);
        }
    }
        


    public UserConfirmationTask(){
        scClassName = "UserConfirmationTask";
    }

    public UserConfirmationTask(JavaScriptObject jsObj){
        scClassName = "UserConfirmationTask";
        setJavaScriptObject(jsObj);
    }

    public native JavaScriptObject create()/*-{
        var config = this.@com.smartgwt.client.core.BaseClass::getConfig()();
        var scClassName = this.@com.smartgwt.client.core.BaseClass::scClassName;
        return $wnd.isc[scClassName].create(config);
    }-*/;

    // ********************* Properties / Attributes ***********************

    /**
     * ID of the next sequence or element to proceed to if the criteria do not match.
     *
     * @param failureElement New failureElement value. Default value is null
     * @return {@link com.smartgwt.client.util.workflow.UserConfirmationTask UserConfirmationTask} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public UserConfirmationTask setFailureElement(String failureElement)  throws IllegalStateException {
        return (UserConfirmationTask)setAttribute("failureElement", failureElement, false);
    }

    /**
     * ID of the next sequence or element to proceed to if the criteria do not match.
     *
     * @return Current failureElement value. Default value is null
     */
    public String getFailureElement()  {
        return getAttributeAsString("failureElement");
    }
    

    /**
     * Message to display to the user for confirmation. To display a dynamic message see {@link
     * com.smartgwt.client.util.workflow.UserConfirmationTask#getTextFormula textFormula}.
     *
     * @param message New message value. Default value is null
     * @return {@link com.smartgwt.client.util.workflow.UserConfirmationTask UserConfirmationTask} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public UserConfirmationTask setMessage(String message)  throws IllegalStateException {
        return (UserConfirmationTask)setAttribute("message", message, false);
    }

    /**
     * Message to display to the user for confirmation. To display a dynamic message see {@link
     * com.smartgwt.client.util.workflow.UserConfirmationTask#getTextFormula textFormula}.
     *
     * @return Current message value. Default value is null
     */
    public String getMessage()  {
        return getAttributeAsString("message");
    }
    

    /**
     * Next {@link com.smartgwt.client.util.workflow.Process#getSequences sequence} or {@link
     * com.smartgwt.client.util.workflow.Process#getElements element} to execute if the criteria match the process state.   <p>
     * <code>nextElement</code> does not need to be specified if this gateway is part of a {@link
     * com.smartgwt.client.util.workflow.Process#getSequences sequence} and has a next element in the sequence. <p> Note that
     * if there is both a <code>sequence</code> and a normal <code>element</code> with the same name in the current
     * <code>Process</code>, the <code>sequence</code> will be used.
     *
     * @param nextElement New nextElement value. Default value is null
     * @return {@link com.smartgwt.client.util.workflow.UserConfirmationTask UserConfirmationTask} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public UserConfirmationTask setNextElement(String nextElement)  throws IllegalStateException {
        return (UserConfirmationTask)setAttribute("nextElement", nextElement, false);
    }

    /**
     * Next {@link com.smartgwt.client.util.workflow.Process#getSequences sequence} or {@link
     * com.smartgwt.client.util.workflow.Process#getElements element} to execute if the criteria match the process state.   <p>
     * <code>nextElement</code> does not need to be specified if this gateway is part of a {@link
     * com.smartgwt.client.util.workflow.Process#getSequences sequence} and has a next element in the sequence. <p> Note that
     * if there is both a <code>sequence</code> and a normal <code>element</code> with the same name in the current
     * <code>Process</code>, the <code>sequence</code> will be used.
     *
     * @return Current nextElement value. Default value is null
     */
    public String getNextElement()  {
        return getAttributeAsString("nextElement");
    }
    

    /**
     * Formula to be used to calculate the message contents. Use {@link
     * com.smartgwt.client.util.workflow.UserConfirmationTask#getMessage message} property to assign a static message instead.
     * <p>  Available fields for use in the formula are the current {@link com.smartgwt.client.widgets.Canvas#getRuleScope rule
     * context}.
     *
     * @param textFormula New textFormula value. Default value is null
     * @return {@link com.smartgwt.client.util.workflow.UserConfirmationTask UserConfirmationTask} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public UserConfirmationTask setTextFormula(UserSummary textFormula)  throws IllegalStateException {
        return (UserConfirmationTask)setAttribute("textFormula", textFormula == null ? null : textFormula.getJsObj(), false);
    }

    /**
     * Formula to be used to calculate the message contents. Use {@link
     * com.smartgwt.client.util.workflow.UserConfirmationTask#getMessage message} property to assign a static message instead.
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
