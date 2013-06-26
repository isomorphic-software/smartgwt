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
 * An object representing the start of a given Fiscal Year in the current locale. <P> See {@link
 * com.smartgwt.client.widgets.FiscalCalendar} for more information on how FiscalYears are set up and used.
 */
public class FiscalYear extends RefDataClass {

    public static FiscalYear getOrCreateRef(JavaScriptObject jsObj) {

        if(jsObj == null) return null;

        RefDataClass obj = RefDataClass.getRef(jsObj);


        if(obj != null) {
            obj.setJsObj(jsObj);
            return (FiscalYear) obj;
        } else {
            return new FiscalYear(jsObj);
        }
    }

    public void setJavaScriptObject(JavaScriptObject jsObj) {
        this.jsObj = jsObj;
    }



    public FiscalYear(){
        
    }

    public FiscalYear(JavaScriptObject jsObj){
        
        setJavaScriptObject(jsObj);
        
    }

    public FiscalYear(int year, int month, int date) {
        setYear(year);
		setMonth(month);
		setDate(date);
        
    }

    public FiscalYear(int fiscalYear, int year, int month, int date) {
        setFiscalYear(fiscalYear);
		setYear(year);
		setMonth(month);
		setDate(date);
        
    }


    // ********************* Properties / Attributes ***********************


    /**
     * The one-based day-number in the {@link com.smartgwt.client.widgets.FiscalYear#getMonth specified month} when this fiscal
     * year starts.
     *
     * @param date date Default value is null
     */
    public void setDate(Integer date) {
        setAttribute("date", date);
    }

    /**
     * The one-based day-number in the {@link com.smartgwt.client.widgets.FiscalYear#getMonth specified month} when this fiscal
     * year starts.
     *
     * @return Integer
     */
    public Integer getDate()  {
        return getAttributeAsInt("date");
    }


    /**
     * The actual fiscal year that this date relates to. <P> A fiscal year ends when the next one begins. A fiscal year may
     * span the boundary between two calendar years in which case the {@link
     * com.smartgwt.client.widgets.FiscalYear#getFiscalYear fiscalYear} value may not match the {@link
     * com.smartgwt.client.widgets.FiscalYear#getYear year} value. <P> For example fiscalYear 2020 may start in July of 2019
     * and end in July of 2020. In this case the <code>fiscalYear</code> would be set to <code>2020</code> and the {@link
     * com.smartgwt.client.widgets.FiscalYear#getYear year} would be set to <code>2019</code>
     *
     * @param fiscalYear fiscalYear Default value is null
     */
    public void setFiscalYear(Integer fiscalYear) {
        setAttribute("fiscalYear", fiscalYear);
    }

    /**
     * The actual fiscal year that this date relates to. <P> A fiscal year ends when the next one begins. A fiscal year may
     * span the boundary between two calendar years in which case the {@link
     * com.smartgwt.client.widgets.FiscalYear#getFiscalYear fiscalYear} value may not match the {@link
     * com.smartgwt.client.widgets.FiscalYear#getYear year} value. <P> For example fiscalYear 2020 may start in July of 2019
     * and end in July of 2020. In this case the <code>fiscalYear</code> would be set to <code>2020</code> and the {@link
     * com.smartgwt.client.widgets.FiscalYear#getYear year} would be set to <code>2019</code>
     *
     * @return Integer
     */
    public Integer getFiscalYear()  {
        return getAttributeAsInt("fiscalYear");
    }


    /**
     * The zero-based month-number when this fiscal year starts.
     *
     * @param month month Default value is null
     */
    public void setMonth(Integer month) {
        setAttribute("month", month);
    }

    /**
     * The zero-based month-number when this fiscal year starts.
     *
     * @return Integer
     */
    public Integer getMonth()  {
        return getAttributeAsInt("month");
    }


    /**
     * The 4-digit calendar year when this fiscal year starts.
     *
     * @param year year Default value is null
     */
    public void setYear(Integer year) {
        setAttribute("year", year);
    }

    /**
     * The 4-digit calendar year when this fiscal year starts.
     *
     * @return Integer
     */
    public Integer getYear()  {
        return getAttributeAsInt("year");
    }

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************

    // ***********************************************************

}



