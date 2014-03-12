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
import com.smartgwt.client.widgets.tab.*;
import com.smartgwt.client.widgets.toolbar.*;
import com.smartgwt.client.widgets.tree.*;
import com.smartgwt.client.widgets.tree.events.*;
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
import com.smartgwt.client.util.workflow.*;
import com.google.gwt.event.shared.*;
import com.google.gwt.event.shared.HasHandlers;

/**
 * An object representing a user-created and user-modifiable formula, which can be created and edited with a FormulaBuilder
 * either directly or via the {@link com.smartgwt.client.widgets.grid.ListGrid#getCanAddFormulaFields canAddFormulaFields}
 * behavior.
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
     * Map from the single-letter capital letters used as formula variables in the {@link
     * com.smartgwt.client.widgets.UserFormula} String to the fieldNames these variables should represent in the context where
     * the formula is evaluated.
     *
     * @param formulaVars  Default value is null
     */
    public void setFormulaVars(Map formulaVars) {
        setAttribute("formulaVars", formulaVars);
    }

    /**
     * Map from the single-letter capital letters used as formula variables in the {@link
     * com.smartgwt.client.widgets.UserFormula} String to the fieldNames these variables should represent in the context where
     * the formula is evaluated.
     *
     * @return Map
     */
    public Map getFormulaVars()  {
        return getAttributeAsMap("formulaVars");
    }

    /**
     * Formula to be evaluated.  All variables used by the formula must be single-letter capital characters (eg A). These are
     * derived from field values for the record in question - see {@link com.smartgwt.client.widgets.UserFormula#getFormulaVars
     * formulaVars}. <P> In addition to these variables, the keyword <code>record</code> may be used to refer directly to the
     * record for which the formula is being displayed.
     *
     * @param text  Default value is null
     */
    public void setText(String text) {
        setAttribute("text", text);
    }

    /**
     * Formula to be evaluated.  All variables used by the formula must be single-letter capital characters (eg A). These are
     * derived from field values for the record in question - see {@link com.smartgwt.client.widgets.UserFormula#getFormulaVars
     * formulaVars}. <P> In addition to these variables, the keyword <code>record</code> may be used to refer directly to the
     * record for which the formula is being displayed.
     *
     * @return String
     */
    public String getText()  {
        return getAttributeAsString("text");
    }

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************

    // ***********************************************************

}


