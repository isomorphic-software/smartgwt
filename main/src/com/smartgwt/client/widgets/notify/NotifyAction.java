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
 
package com.smartgwt.client.widgets.notify;


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
 * Represents an action that's associated with a message.  Similar to the object form of {@link
 * com.smartgwt.client.docs.Callback}, except a title must also be specified, which is rendered as a clickable link in the
 * message (unless {@link com.smartgwt.client.widgets.notify.NotifyAction#getWholeMessage wholeMessage} is set).
 * @see com.smartgwt.client.widgets.notify.Notify#configureMessages
 */
@BeanFactory.FrameworkClass
public class NotifyAction extends DataClass {

    public static NotifyAction getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        return new NotifyAction(jsObj);
    }
        


    public NotifyAction(){
        
    }

    public NotifyAction(JavaScriptObject jsObj){
        
        setJavaScriptObject(jsObj);
    }


    // ********************* Properties / Attributes ***********************
    

    /**
     * Overrides {@link com.smartgwt.client.widgets.notify.NotifySettings#getActionSeparator NotifySettings.actionSeparator}
     * for this action.
     *
     * @param separator New separator value. Default value is null
     * @return {@link com.smartgwt.client.widgets.notify.NotifyAction NotifyAction} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public NotifyAction setSeparator(String separator) {
        return (NotifyAction)setAttribute("separator", separator);
    }

    /**
     * Overrides {@link com.smartgwt.client.widgets.notify.NotifySettings#getActionSeparator NotifySettings.actionSeparator}
     * for this action.
     *
     * @return Current separator value. Default value is null
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public String getSeparator()  {
        return getAttributeAsString("separator");
    }
    
    

    /**
     * The title of the action to render into the message.
     *
     * @param title New title value. Default value is null
     * @return {@link com.smartgwt.client.widgets.notify.NotifyAction NotifyAction} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public NotifyAction setTitle(String title) {
        return (NotifyAction)setAttribute("title", title);
    }

    /**
     * The title of the action to render into the message.
     *
     * @return Current title value. Default value is null
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public String getTitle()  {
        return getAttributeAsString("title");
    }
    

    /**
     * Allows a click anywhere on the notification to execute the action.  If true, the action won't be rendered as a link.
     *
     * @param wholeMessage New wholeMessage value. Default value is null
     * @return {@link com.smartgwt.client.widgets.notify.NotifyAction NotifyAction} instance, for chaining setter calls
     */
    public NotifyAction setWholeMessage(Boolean wholeMessage) {
        return (NotifyAction)setAttribute("wholeMessage", wholeMessage);
    }

    /**
     * Allows a click anywhere on the notification to execute the action.  If true, the action won't be rendered as a link.
     *
     * @return Current wholeMessage value. Default value is null
     */
    public Boolean getWholeMessage()  {
        return getAttributeAsBoolean("wholeMessage", true);
    }
    

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************

    // ***********************************************************



    private NotifyActionCallback callback;

    /**
     * The callback to fire when the action is executed.
     *
     * @param callback
     */
    public native void setActionCallback(NotifyActionCallback callback) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.method = $debox($entry(function () {
            callback.@com.smartgwt.client.widgets.notify.NotifyActionCallback::execute()();
        }));
        this.@com.smartgwt.client.widgets.notify.NotifyAction::callback = callback;
    }-*/;

    /**
     * The callback to fire when the action is executed.
     *
     * @return callback
     */
    public NotifyActionCallback getActionCallback()  {
        return callback;
    }
    

}
