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
 * An object representing a user-created and user-modifiable formula, which can be created and edited with a FormulaBuilder
 * either directly or via the {@link com.smartgwt.client.widgets.grid.ListGrid#getCanAddFormulaFields
 * ListGrid.canAddFormulaFields} behavior. <p> Note that the current implementation of UserFormula simply executes {@link
 * com.smartgwt.client.widgets.UserFormula#getText text} as a JavaScript string after making special variables and methods
 * available to the formula. It is safe to allow users to define formulas for themselves (since an end user can always
 * execute whatever JavaScript they want via the browser's built-in developer tools), and is safe to allow formulas to be
 * shared between trusted users.  However it would not be safe to allow an untrusted user to create formulas that are
 * shared to other users. <p> Also, while the current implementation would allow creation of a formula that calls
 * JavaScript functions that are not part of the standard or custom  MathFunctions, this should not be relied upon, as
 * future versions of the formula engine may prohibit such calls.
 */
@BeanFactory.FrameworkClass
public class UserFormula extends DataClass {

    public static UserFormula getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        return new UserFormula(jsObj);
    }
        


    public UserFormula(){
        
    }

    public UserFormula(JavaScriptObject jsObj){
        
        setJavaScriptObject(jsObj);
    }


    public UserFormula(String text) {
        setText(text);
                
    }


    public UserFormula(String text, Map formulaVars) {
        setText(text);
		setFormulaVars(formulaVars);
                
    }


    // ********************* Properties / Attributes ***********************

    /**
     * Object mapping from variable names to fieldNames.  All variable names must be single-letter
     *  capital characters (eg A).  For example, for a formula that should divide the field
     *  "population" over the field "area", the formula might be "E/L" and formula vars would be:
     *  
     *  
     *  <pre>
     *    Map vars = new HashMap();
     *    vars.put("E", "population");
     *    vars.put("L", "area");
     *  </pre>
     *  
     *  <p>
     * When used in {@link com.smartgwt.client.widgets.grid.ListGridField#getUserFormula ListGridField.userFormula} context,
     * field names are evaluated against the
     *  grid record.
     *  <p>
     * When used in {@link com.smartgwt.client.widgets.form.fields.FormItem#getFormula FormItem.formula} or {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getEditorFormula ListGridField.editorFormula} this property is
     *  not used for formula mapping. Instead, field names are evaluated directly against the
     *  current {@link com.smartgwt.client.widgets.Canvas#getRuleScope rule context}.
     *
     * @param formulaVars New formulaVars value. Default value is null
     * @return {@link com.smartgwt.client.widgets.UserFormula UserFormula} instance, for chaining setter calls
     */
    public UserFormula setFormulaVars(Map formulaVars) {
        return (UserFormula)setAttribute("formulaVars", formulaVars);
    }

    /**
     * Object mapping from variable names to fieldNames.  All variable names must be single-letter
     *  capital characters (eg A).  For example, for a formula that should divide the field
     *  "population" over the field "area", the formula might be "E/L" and formula vars would be:
     *  
     *  
     *  <pre>
     *    Map vars = new HashMap();
     *    vars.put("E", "population");
     *    vars.put("L", "area");
     *  </pre>
     *  
     *  <p>
     * When used in {@link com.smartgwt.client.widgets.grid.ListGridField#getUserFormula ListGridField.userFormula} context,
     * field names are evaluated against the
     *  grid record.
     *  <p>
     * When used in {@link com.smartgwt.client.widgets.form.fields.FormItem#getFormula FormItem.formula} or {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getEditorFormula ListGridField.editorFormula} this property is
     *  not used for formula mapping. Instead, field names are evaluated directly against the
     *  current {@link com.smartgwt.client.widgets.Canvas#getRuleScope rule context}.
     *
     * @return Current formulaVars value. Default value is null
     */
    public Map getFormulaVars()  {
        return getAttributeAsMap("formulaVars");
    }
    

    /**
     * Formula to be evaluated. <P> There are two contexts where a UserFormula is used: {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getUserFormula ListGridField.userFormula} and {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getFormula FormItem.formula} or {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getEditorFormula ListGridField.editorFormula}. For the grid field formula
     * all variables used by the formula must be single-letter capital characters (eg A). These are derived from field values
     * for the record in question - see {@link com.smartgwt.client.widgets.UserFormula#getFormulaVars formulaVars}. <P> In
     * addition to these variables, the keyword <code>record</code> may be used to refer directly to the record for which the
     * formula is being displayed. <P> In the second usage context variables are dot-separated (.) names representing the
     * nested hierarchy path to the desired value within the {@link com.smartgwt.client.widgets.Canvas#getRuleScope rule
     * context}. No mapping with {@link com.smartgwt.client.widgets.UserFormula#getFormulaVars formulaVars} is needed. <P> The
     * formula text must be valid JavaScript code and may only call either the built-in  MathFunctions or a  custom\n function.
     *
     * @param text New text value. Default value is null
     * @return {@link com.smartgwt.client.widgets.UserFormula UserFormula} instance, for chaining setter calls
     */
    public UserFormula setText(String text) {
        return (UserFormula)setAttribute("text", text);
    }

    /**
     * Formula to be evaluated. <P> There are two contexts where a UserFormula is used: {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getUserFormula ListGridField.userFormula} and {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getFormula FormItem.formula} or {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getEditorFormula ListGridField.editorFormula}. For the grid field formula
     * all variables used by the formula must be single-letter capital characters (eg A). These are derived from field values
     * for the record in question - see {@link com.smartgwt.client.widgets.UserFormula#getFormulaVars formulaVars}. <P> In
     * addition to these variables, the keyword <code>record</code> may be used to refer directly to the record for which the
     * formula is being displayed. <P> In the second usage context variables are dot-separated (.) names representing the
     * nested hierarchy path to the desired value within the {@link com.smartgwt.client.widgets.Canvas#getRuleScope rule
     * context}. No mapping with {@link com.smartgwt.client.widgets.UserFormula#getFormulaVars formulaVars} is needed. <P> The
     * formula text must be valid JavaScript code and may only call either the built-in  MathFunctions or a  custom\n function.
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
