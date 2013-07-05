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
 
package com.smartgwt.client.widgets;


import com.smartgwt.client.event.*;
import com.smartgwt.client.core.*;
import com.smartgwt.client.types.*;
import com.smartgwt.client.data.*;
import com.smartgwt.client.data.events.*;
import com.smartgwt.client.rpc.*;
import com.smartgwt.client.callbacks.*;
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
import com.smartgwt.client.widgets.tab.*;
import com.smartgwt.client.widgets.toolbar.*;
import com.smartgwt.client.widgets.tree.*;
import com.smartgwt.client.widgets.tree.events.*;
import com.smartgwt.client.widgets.viewer.*;
import com.smartgwt.client.widgets.calendar.*;
import com.smartgwt.client.widgets.calendar.events.*;
import com.smartgwt.client.widgets.cube.*;
import com.smartgwt.client.widgets.drawing.*;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashMap;

import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;
import com.smartgwt.client.util.*;
import com.smartgwt.client.util.workflow.*;
import com.google.gwt.event.shared.*;
import com.google.gwt.event.shared.HasHandlers;
import com.smartgwt.logicalstructure.core.*;
import com.smartgwt.logicalstructure.widgets.*;
import com.smartgwt.logicalstructure.widgets.drawing.*;
import com.smartgwt.logicalstructure.widgets.plugins.*;
import com.smartgwt.logicalstructure.widgets.form.*;
import com.smartgwt.logicalstructure.widgets.tile.*;
import com.smartgwt.logicalstructure.widgets.grid.*;
import com.smartgwt.logicalstructure.widgets.chart.*;
import com.smartgwt.logicalstructure.widgets.layout.*;
import com.smartgwt.logicalstructure.widgets.menu.*;
import com.smartgwt.logicalstructure.widgets.tab.*;
import com.smartgwt.logicalstructure.widgets.tableview.*;
import com.smartgwt.logicalstructure.widgets.toolbar.*;
import com.smartgwt.logicalstructure.widgets.tree.*;
import com.smartgwt.logicalstructure.widgets.viewer.*;
import com.smartgwt.logicalstructure.widgets.calendar.*;
import com.smartgwt.logicalstructure.widgets.cube.*;

/**
 * An object representing a user-created and user-modifiable summary, which can be created and edited with a SummaryBuilder
 * either directly or via the {@link com.smartgwt.client.widgets.grid.ListGrid#getCanAddSummaryFields canAddSummaryFields}
 * behavior.
 */
public class UserSummary extends DataClass {

    public static UserSummary getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        return new UserSummary(jsObj);
    }

    public void setJavaScriptObject(JavaScriptObject jsObj) {
        this.jsObj = jsObj;
    }



    public UserSummary(){
        
    }

    public UserSummary(JavaScriptObject jsObj){
        
        setJavaScriptObject(jsObj);
        
    }

    public UserSummary(String text) {
        setText(text);
        
    }

    public UserSummary(String text, Map summaryVars) {
        setText(text);
		setSummaryVars(summaryVars);
        
    }


    // ********************* Properties / Attributes ***********************


    /**
     * Map from the all-capital letter names used as summary variables in the {@link
     * com.smartgwt.client.widgets.UserSummary#getSummary summary} String to the fieldNames these variables should represent in
     * the context where the summary is evaluated.
     *
     * @param summaryVars summaryVars Default value is null
     */
    public void setSummaryVars(Map summaryVars) {
        setAttribute("summaryVars", summaryVars);
    }

    /**
     * Map from the all-capital letter names used as summary variables in the {@link
     * com.smartgwt.client.widgets.UserSummary#getSummary summary} String to the fieldNames these variables should represent in
     * the context where the summary is evaluated.
     *
     * @return Map
     */
    public Map getSummaryVars()  {
        return getAttributeAsMap("summaryVars");
    }


    /**
     * Summary to be evaluated.  All variables used by the summary must be all-capital letter names surrounded by braces and
     * escaped with a # sign (eg #{A}).  These are derived from field values for the record in question - see {@link
     * com.smartgwt.client.widgets.UserSummary#getSummaryVars summaryVars}.
     *
     * @param text . See {@link com.smartgwt.client.docs.String String}. Default value is null
     */
    public void setText(String text) {
        setAttribute("text", text);
    }

    /**
     * Summary to be evaluated.  All variables used by the summary must be all-capital letter names surrounded by braces and
     * escaped with a # sign (eg #{A}).  These are derived from field values for the record in question - see {@link
     * com.smartgwt.client.widgets.UserSummary#getSummaryVars summaryVars}.
     *
     * @return . See {@link com.smartgwt.client.docs.String String}
     */
    public String getText()  {
        return getAttributeAsString("text");
    }

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************

    // ***********************************************************

}


