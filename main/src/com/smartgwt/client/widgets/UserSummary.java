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
 
package com.smartgwt.client.widgets;


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
 * An object representing a user-created and user-modifiable summary, which can be created and edited with a SummaryBuilder
 * either directly or via the {@link com.smartgwt.client.widgets.grid.ListGrid#getCanAddSummaryFields
 * ListGrid.canAddSummaryFields} behavior.
 */
@BeanFactory.FrameworkClass
public class UserSummary extends DataClass {

    public static UserSummary getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        return new UserSummary(jsObj);
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
     * Map from the all-capital letter names used as summary variables in the {@link com.smartgwt.client.widgets.UserSummary}
     * String to the fieldNames these variables should represent in the context where the summary is evaluated. <p> When used
     * in {@link com.smartgwt.client.widgets.grid.ListGridField#getUserSummary ListGridField.userSummary} context, field names
     * are evaluated against the grid record. <p> When used in {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getTextFormula FormItem.textFormula} or {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getEditorTextFormula ListGridField.editorTextFormula} this property is
     * not used for summary mapping. Instead, field names are evaluated directly against the current {@link
     * com.smartgwt.client.widgets.Canvas#getRuleScope rule context}.
     *
     * @param summaryVars New summaryVars value. Default value is null
     */
    public void setSummaryVars(Map summaryVars) {
        setAttribute("summaryVars", summaryVars);
    }

    /**
     * Map from the all-capital letter names used as summary variables in the {@link com.smartgwt.client.widgets.UserSummary}
     * String to the fieldNames these variables should represent in the context where the summary is evaluated. <p> When used
     * in {@link com.smartgwt.client.widgets.grid.ListGridField#getUserSummary ListGridField.userSummary} context, field names
     * are evaluated against the grid record. <p> When used in {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getTextFormula FormItem.textFormula} or {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getEditorTextFormula ListGridField.editorTextFormula} this property is
     * not used for summary mapping. Instead, field names are evaluated directly against the current {@link
     * com.smartgwt.client.widgets.Canvas#getRuleScope rule context}.
     *
     * @return Current summaryVars value. Default value is null
     */
    public Map getSummaryVars()  {
        return getAttributeAsMap("summaryVars");
    }
    

    /**
     * Summary to be evaluated. <P> There are two contexts where a UserSummary is used: {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getUserSummary ListGridField.userSummary} and {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getTextFormula FormItem.textFormula} or {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getEditorTextFormula ListGridField.editorTextFormula}. For the grid field
     * summary all variables used by the summary must be all-capital letter names surrounded by braces and escaped with a #
     * sign (eg #{A}). These are derived from field values for the record in question - see {@link
     * com.smartgwt.client.widgets.UserSummary#getSummaryVars summaryVars}. <P> In the second usage context variables are
     * dot-separated (.) names representing the nested hierarchy path to the desired value within the {@link
     * com.smartgwt.client.widgets.Canvas#getRuleScope rule context}. No mapping with {@link
     * com.smartgwt.client.widgets.UserSummary#getSummaryVars summaryVars} is needed.
     *
     * @param text New text value. Default value is null
     */
    public void setText(String text) {
        setAttribute("text", text);
    }

    /**
     * Summary to be evaluated. <P> There are two contexts where a UserSummary is used: {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getUserSummary ListGridField.userSummary} and {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getTextFormula FormItem.textFormula} or {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getEditorTextFormula ListGridField.editorTextFormula}. For the grid field
     * summary all variables used by the summary must be all-capital letter names surrounded by braces and escaped with a #
     * sign (eg #{A}). These are derived from field values for the record in question - see {@link
     * com.smartgwt.client.widgets.UserSummary#getSummaryVars summaryVars}. <P> In the second usage context variables are
     * dot-separated (.) names representing the nested hierarchy path to the desired value within the {@link
     * com.smartgwt.client.widgets.Canvas#getRuleScope rule context}. No mapping with {@link
     * com.smartgwt.client.widgets.UserSummary#getSummaryVars summaryVars} is needed.
     *
     * @return Current text value. Default value is null
     */
    public String getText()  {
        return getAttributeAsString("text");
    }
    

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************

    // ***********************************************************

}
