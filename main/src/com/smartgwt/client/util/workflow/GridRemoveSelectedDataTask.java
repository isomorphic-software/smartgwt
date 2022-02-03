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
 * Remove data that is selected in a grid.
 * @see com.smartgwt.client.widgets.grid.ListGrid#removeSelectedData
 */
@BeanFactory.FrameworkClass
@BeanFactory.ScClassName("GridRemoveSelectedDataTask")
public class GridRemoveSelectedDataTask extends ComponentTask {

    public static GridRemoveSelectedDataTask getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        BaseClass obj = BaseClass.getRef(jsObj);
        if(obj != null) {
            return (GridRemoveSelectedDataTask) obj;
        } else {
            return new GridRemoveSelectedDataTask(jsObj);
        }
    }
        


    public GridRemoveSelectedDataTask(){
        scClassName = "GridRemoveSelectedDataTask";
    }

    public GridRemoveSelectedDataTask(JavaScriptObject jsObj){
        scClassName = "GridRemoveSelectedDataTask";
        setJavaScriptObject(jsObj);
    }

    public native JavaScriptObject create()/*-{
        var config = this.@com.smartgwt.client.core.BaseClass::getConfig()();
        var scClassName = this.@com.smartgwt.client.core.BaseClass::scClassName;
        return $wnd.isc[scClassName].create(config);
    }-*/;

    // ********************* Properties / Attributes ***********************

    /**
     * Can multiple records be removed? If not and multiple records are selected, the {@link
     * com.smartgwt.client.util.workflow.GridRemoveSelectedDataTask#getRefuseMultiRemoveMessage refuseMultiRemoveMessage} is
     * shown as a warning and the workflow is terminated. <p> Default is true unless set to <code>false</code>.
     *
     * @param allowMultiRecordRemove New allowMultiRecordRemove value. Default value is null
     * @return {@link com.smartgwt.client.util.workflow.GridRemoveSelectedDataTask GridRemoveSelectedDataTask} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public GridRemoveSelectedDataTask setAllowMultiRecordRemove(Boolean allowMultiRecordRemove)  throws IllegalStateException {
        return (GridRemoveSelectedDataTask)setAttribute("allowMultiRecordRemove", allowMultiRecordRemove, false);
    }

    /**
     * Can multiple records be removed? If not and multiple records are selected, the {@link
     * com.smartgwt.client.util.workflow.GridRemoveSelectedDataTask#getRefuseMultiRemoveMessage refuseMultiRemoveMessage} is
     * shown as a warning and the workflow is terminated. <p> Default is true unless set to <code>false</code>.
     *
     * @return Current allowMultiRecordRemove value. Default value is null
     */
    public Boolean getAllowMultiRecordRemove()  {
        return getAttributeAsBoolean("allowMultiRecordRemove");
    }
    

    /**
     * Message shown to user to confirm deleting a single record on a bound grid. <P> This is a dynamic string - text within
     * <code>&#36;{...}</code> are dynamic variables and will  be evaluated as JS code when the message is displayed. <P> Only
     * three dynamic variables, dsTitle; dsPluralTitle and recordTitle, are available and represent the bound {@link
     * com.smartgwt.client.data.DataSource#getTitle DataSource.title} and {@link
     * com.smartgwt.client.data.DataSource#getPluralTitle DataSource.pluralTitle} and the value of the {@link
     * com.smartgwt.client.data.DataSource#getTitleField DataSource.titleField} from the first selected record.
     *
     * @param confirmationMessage New confirmationMessage value. Default value is "Delete ${dsTitle} ${recordTitle}"
     * @return {@link com.smartgwt.client.util.workflow.GridRemoveSelectedDataTask GridRemoveSelectedDataTask} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public GridRemoveSelectedDataTask setConfirmationMessage(String confirmationMessage)  throws IllegalStateException {
        return (GridRemoveSelectedDataTask)setAttribute("confirmationMessage", confirmationMessage, false);
    }

    /**
     * Message shown to user to confirm deleting a single record on a bound grid. <P> This is a dynamic string - text within
     * <code>&#36;{...}</code> are dynamic variables and will  be evaluated as JS code when the message is displayed. <P> Only
     * three dynamic variables, dsTitle; dsPluralTitle and recordTitle, are available and represent the bound {@link
     * com.smartgwt.client.data.DataSource#getTitle DataSource.title} and {@link
     * com.smartgwt.client.data.DataSource#getPluralTitle DataSource.pluralTitle} and the value of the {@link
     * com.smartgwt.client.data.DataSource#getTitleField DataSource.titleField} from the first selected record.
     *
     * @return Current confirmationMessage value. Default value is "Delete ${dsTitle} ${recordTitle}"
     */
    public String getConfirmationMessage()  {
        return getAttributeAsString("confirmationMessage");
    }
    

    /**
     * ID of the next sequence or element to proceed to if a failure condition arises from operation.
     *
     * @param failureElement New failureElement value. Default value is null
     * @return {@link com.smartgwt.client.util.workflow.GridRemoveSelectedDataTask GridRemoveSelectedDataTask} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public GridRemoveSelectedDataTask setFailureElement(String failureElement)  throws IllegalStateException {
        return (GridRemoveSelectedDataTask)setAttribute("failureElement", failureElement, false);
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
     * Message shown to user to confirm deleting a group of records on a bound grid. <P> This is a dynamic string - text within
     * <code>&#36;{...}</code> are dynamic variables and will  be evaluated as JS code when the message is displayed. <P> Only
     * two dynamic variables, dsTitle and dsPluralTitle, are available and represent the bound {@link
     * com.smartgwt.client.data.DataSource#getTitle DataSource.title} and {@link
     * com.smartgwt.client.data.DataSource#getPluralTitle DataSource.pluralTitle} .
     *
     * @param multipleConfirmationMessage New multipleConfirmationMessage value. Default value is "Delete multiple ${dsPluralTitle}?"
     * @return {@link com.smartgwt.client.util.workflow.GridRemoveSelectedDataTask GridRemoveSelectedDataTask} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public GridRemoveSelectedDataTask setMultipleConfirmationMessage(String multipleConfirmationMessage)  throws IllegalStateException {
        return (GridRemoveSelectedDataTask)setAttribute("multipleConfirmationMessage", multipleConfirmationMessage, false);
    }

    /**
     * Message shown to user to confirm deleting a group of records on a bound grid. <P> This is a dynamic string - text within
     * <code>&#36;{...}</code> are dynamic variables and will  be evaluated as JS code when the message is displayed. <P> Only
     * two dynamic variables, dsTitle and dsPluralTitle, are available and represent the bound {@link
     * com.smartgwt.client.data.DataSource#getTitle DataSource.title} and {@link
     * com.smartgwt.client.data.DataSource#getPluralTitle DataSource.pluralTitle} .
     *
     * @return Current multipleConfirmationMessage value. Default value is "Delete multiple ${dsPluralTitle}?"
     */
    public String getMultipleConfirmationMessage()  {
        return getAttributeAsString("multipleConfirmationMessage");
    }
    

    /**
     * Message to be shown when multiple records are selected for removal but  {@link
     * com.smartgwt.client.util.workflow.GridRemoveSelectedDataTask#getAllowMultiRecordRemove allowMultiRecordRemove} is not
     * set.
     *
     * @param refuseMultiRemoveMessage New refuseMultiRemoveMessage value. Default value is "Only one record may be removed at a time"
     * @return {@link com.smartgwt.client.util.workflow.GridRemoveSelectedDataTask GridRemoveSelectedDataTask} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public GridRemoveSelectedDataTask setRefuseMultiRemoveMessage(String refuseMultiRemoveMessage)  throws IllegalStateException {
        return (GridRemoveSelectedDataTask)setAttribute("refuseMultiRemoveMessage", refuseMultiRemoveMessage, false);
    }

    /**
     * Message to be shown when multiple records are selected for removal but  {@link
     * com.smartgwt.client.util.workflow.GridRemoveSelectedDataTask#getAllowMultiRecordRemove allowMultiRecordRemove} is not
     * set.
     *
     * @return Current refuseMultiRemoveMessage value. Default value is "Only one record may be removed at a time"
     */
    public String getRefuseMultiRemoveMessage()  {
        return getAttributeAsString("refuseMultiRemoveMessage");
    }
    

    /**
     * Additional properties to set on the {@link com.smartgwt.client.widgets.grid.ListGrid#removeSelectedData
     * removeSelectedData} call to perform removal. <p> Note that <code>willHandleError</code> will always be set
     * <code>true</code>.
     *
     * @param requestProperties New requestProperties value. Default value is null
     * @return {@link com.smartgwt.client.util.workflow.GridRemoveSelectedDataTask GridRemoveSelectedDataTask} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public GridRemoveSelectedDataTask setRequestProperties(DSRequest requestProperties)  throws IllegalStateException {
        JavaScriptObject config = JSOHelper.createObject();
        if (requestProperties != null) {
            JSOHelper.addProperties(config, requestProperties.getJsObj());
        }
        return (GridRemoveSelectedDataTask)setAttribute("requestProperties", requestProperties == null ? null : config, false);
    }

    /**
     * Additional properties to set on the {@link com.smartgwt.client.widgets.grid.ListGrid#removeSelectedData
     * removeSelectedData} call to perform removal. <p> Note that <code>willHandleError</code> will always be set
     * <code>true</code>.
     *
     * @return Current requestProperties value. Default value is null
     */
    public DSRequest getRequestProperties()  {
        return new DSRequest(getAttributeAsJavaScriptObject("requestProperties"));
    }
    

    /**
     * Should we show a confirmation message before removal and allow the user to cancel the operation? If user cancels the
     * removal the workflow is terminated. <p> Message to be shown is defined in the properties: {@link
     * com.smartgwt.client.util.workflow.GridRemoveSelectedDataTask#getConfirmationMessage confirmationMessage}, {@link
     * com.smartgwt.client.util.workflow.GridRemoveSelectedDataTask#getUnboundConfirmationMessage unboundConfirmationMessage},
     * {@link com.smartgwt.client.util.workflow.GridRemoveSelectedDataTask#getMultipleConfirmationMessage
     * multipleConfirmationMessage} and {@link
     * com.smartgwt.client.util.workflow.GridRemoveSelectedDataTask#getUnboundMultipleConfirmationMessage
     * unboundMultipleConfirmationMessage}. The appropriate message is chosen based on the grid configuration and the number of
     * records being removed.
     *
     * @param showConfirmation New showConfirmation value. Default value is null
     * @return {@link com.smartgwt.client.util.workflow.GridRemoveSelectedDataTask GridRemoveSelectedDataTask} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public GridRemoveSelectedDataTask setShowConfirmation(Boolean showConfirmation)  throws IllegalStateException {
        return (GridRemoveSelectedDataTask)setAttribute("showConfirmation", showConfirmation, false);
    }

    /**
     * Should we show a confirmation message before removal and allow the user to cancel the operation? If user cancels the
     * removal the workflow is terminated. <p> Message to be shown is defined in the properties: {@link
     * com.smartgwt.client.util.workflow.GridRemoveSelectedDataTask#getConfirmationMessage confirmationMessage}, {@link
     * com.smartgwt.client.util.workflow.GridRemoveSelectedDataTask#getUnboundConfirmationMessage unboundConfirmationMessage},
     * {@link com.smartgwt.client.util.workflow.GridRemoveSelectedDataTask#getMultipleConfirmationMessage
     * multipleConfirmationMessage} and {@link
     * com.smartgwt.client.util.workflow.GridRemoveSelectedDataTask#getUnboundMultipleConfirmationMessage
     * unboundMultipleConfirmationMessage}. The appropriate message is chosen based on the grid configuration and the number of
     * records being removed.
     *
     * @return Current showConfirmation value. Default value is null
     */
    public Boolean getShowConfirmation()  {
        return getAttributeAsBoolean("showConfirmation");
    }
    

    /**
     * Message shwon to user to confirm deleting a single record on an unbound grid. <P> This is a dynamic string - text within
     * <code>&#36;{...}</code> are dynamic variables and will  be evaluated as JS code when the message is displayed. <P> Only
     * one dynamic variable, recordTitle, is available and represents the value of the {@link
     * com.smartgwt.client.data.DataSource#getTitleField DataSource.titleField} from the first selected record.
     *
     * @param unboundConfirmationMessage New unboundConfirmationMessage value. Default value is "Delete record?"
     * @return {@link com.smartgwt.client.util.workflow.GridRemoveSelectedDataTask GridRemoveSelectedDataTask} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public GridRemoveSelectedDataTask setUnboundConfirmationMessage(String unboundConfirmationMessage)  throws IllegalStateException {
        return (GridRemoveSelectedDataTask)setAttribute("unboundConfirmationMessage", unboundConfirmationMessage, false);
    }

    /**
     * Message shwon to user to confirm deleting a single record on an unbound grid. <P> This is a dynamic string - text within
     * <code>&#36;{...}</code> are dynamic variables and will  be evaluated as JS code when the message is displayed. <P> Only
     * one dynamic variable, recordTitle, is available and represents the value of the {@link
     * com.smartgwt.client.data.DataSource#getTitleField DataSource.titleField} from the first selected record.
     *
     * @return Current unboundConfirmationMessage value. Default value is "Delete record?"
     */
    public String getUnboundConfirmationMessage()  {
        return getAttributeAsString("unboundConfirmationMessage");
    }
    

    /**
     * Message shown to user to confirm deleting a group of records on an unbound grid. <P> This is a dynamic string - text
     * within <code>&#36;{...}</code> are dynamic variables and will  be evaluated as JS code when the message is displayed.
     * <P> Only one dynamic variable, recordTitle, is available and represents the value of the {@link
     * com.smartgwt.client.data.DataSource#getTitleField DataSource.titleField} from the first selected record.
     *
     * @param unboundMultipleConfirmationMessage New unboundMultipleConfirmationMessage value. Default value is "Delete multiple records?"
     * @return {@link com.smartgwt.client.util.workflow.GridRemoveSelectedDataTask GridRemoveSelectedDataTask} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public GridRemoveSelectedDataTask setUnboundMultipleConfirmationMessage(String unboundMultipleConfirmationMessage)  throws IllegalStateException {
        return (GridRemoveSelectedDataTask)setAttribute("unboundMultipleConfirmationMessage", unboundMultipleConfirmationMessage, false);
    }

    /**
     * Message shown to user to confirm deleting a group of records on an unbound grid. <P> This is a dynamic string - text
     * within <code>&#36;{...}</code> are dynamic variables and will  be evaluated as JS code when the message is displayed.
     * <P> Only one dynamic variable, recordTitle, is available and represents the value of the {@link
     * com.smartgwt.client.data.DataSource#getTitleField DataSource.titleField} from the first selected record.
     *
     * @return Current unboundMultipleConfirmationMessage value. Default value is "Delete multiple records?"
     */
    public String getUnboundMultipleConfirmationMessage()  {
        return getAttributeAsString("unboundMultipleConfirmationMessage");
    }
    

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************

    // ***********************************************************

}
