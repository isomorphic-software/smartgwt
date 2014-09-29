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

/**
 * An object representing the start date for fiscal years in the current locale. <P> A fiscal year spans a configurable
 * date range - it may not exactly match a calendar year in length and it can start on any date within the calendar year
 * and potentially end in the next calendar year. <P> Developers may specify explicit fiscal year start dates by adding
 * {@link com.smartgwt.client.widgets.FiscalYear} objects to the {@link
 * com.smartgwt.client.widgets.FiscalCalendar#getFiscalYears fiscal years array}. If none are provided, or if there is no
 * entry for the given year, one is manufactured based on the default {@link
 * com.smartgwt.client.widgets.FiscalCalendar#getDefaultMonth month}  and {@link
 * com.smartgwt.client.widgets.FiscalCalendar#getDefaultDate date}.
 */
public class FiscalCalendar extends RefDataClass {

    public static FiscalCalendar getOrCreateRef(JavaScriptObject jsObj) {
    
        if(jsObj == null) return null;

        RefDataClass obj = RefDataClass.getRef(jsObj);

 
        if(obj != null) {
            obj.setJsObj(jsObj);
            return (FiscalCalendar) obj;
        } else {
            return new FiscalCalendar(jsObj);
        }
    }

    public void setJavaScriptObject(JavaScriptObject jsObj) {
        this.jsObj = jsObj;
    }


    public FiscalCalendar(){
        
    }

    public FiscalCalendar(JavaScriptObject jsObj){
        setJavaScriptObject(jsObj);
    }

    public FiscalCalendar(int defaultMonth, int defaultDate) {
        setDefaultMonth(defaultMonth);
		setDefaultDate(defaultDate);
        
    }

    // ********************* Properties / Attributes ***********************

    /**
     * The default one-based day-number in the {@link com.smartgwt.client.widgets.FiscalCalendar#getDefaultMonth specified
     * month} to use for calculating fiscal dates when no {@link com.smartgwt.client.widgets.FiscalCalendar#getFiscalYears
     * fiscal years}  are provided. This value together with {@link com.smartgwt.client.widgets.FiscalCalendar#getDefaultMonth
     * defaultMonth} will be used as the start date for the fiscal years where no explicitly specified fiscalYear configuration
     * is present. <br> See also {@link com.smartgwt.client.widgets.FiscalCalendar#getDefaultYearMode defaultYearMode}.
     *
     * @param defaultDate defaultDate Default value is null
     */
    public void setDefaultDate(Integer defaultDate) {
        setAttribute("defaultDate", defaultDate);
    }

    /**
     * The default one-based day-number in the {@link com.smartgwt.client.widgets.FiscalCalendar#getDefaultMonth specified
     * month} to use for calculating fiscal dates when no {@link com.smartgwt.client.widgets.FiscalCalendar#getFiscalYears
     * fiscal years}  are provided. This value together with {@link com.smartgwt.client.widgets.FiscalCalendar#getDefaultMonth
     * defaultMonth} will be used as the start date for the fiscal years where no explicitly specified fiscalYear configuration
     * is present. <br> See also {@link com.smartgwt.client.widgets.FiscalCalendar#getDefaultYearMode defaultYearMode}.
     *
     *
     * @return Integer
     */
    public Integer getDefaultDate()  {
        return getAttributeAsInt("defaultDate");
    }

    /**
     * The default zero-based month-number to use for calculating fiscal dates when no  {@link
     * com.smartgwt.client.widgets.FiscalCalendar#getFiscalYears fiscal years} are provided. This value together with {@link
     * com.smartgwt.client.widgets.FiscalCalendar#getDefaultDate defaultDate} will be used as the start date for the fiscal
     * years where no explicitly specified fiscalYear configuration is present. <br> See also {@link
     * com.smartgwt.client.widgets.FiscalCalendar#getDefaultYearMode defaultYearMode}.
     *
     * @param defaultMonth defaultMonth Default value is null
     */
    public void setDefaultMonth(Integer defaultMonth) {
        setAttribute("defaultMonth", defaultMonth);
    }

    /**
     * The default zero-based month-number to use for calculating fiscal dates when no  {@link
     * com.smartgwt.client.widgets.FiscalCalendar#getFiscalYears fiscal years} are provided. This value together with {@link
     * com.smartgwt.client.widgets.FiscalCalendar#getDefaultDate defaultDate} will be used as the start date for the fiscal
     * years where no explicitly specified fiscalYear configuration is present. <br> See also {@link
     * com.smartgwt.client.widgets.FiscalCalendar#getDefaultYearMode defaultYearMode}.
     *
     *
     * @return Integer
     */
    public Integer getDefaultMonth()  {
        return getAttributeAsInt("defaultMonth");
    }

    /**
     * This attribute controls how the displayed fiscalYear value should be calculated for dates falling within a period not
     * explicitly listed in the +lik{fiscalCalendar.fiscalYears,fiscal years array}. <P> The {@link
     * com.smartgwt.client.widgets.FiscalCalendar#getDefaultMonth defaultMonth} and {@link
     * com.smartgwt.client.widgets.FiscalCalendar#getDefaultDate defaultDate} will be used to calculate the start of the fiscal
     * year period. The defaultYearMode  determines whether the reported fiscalYear for this period matches the year in which
     * the period starts or the year in which it ends (so whether a fiscal year spanning dates within both 2020 and 2021 is
     * reported as fiscalYear 2020 or 2021).
     *
     * @param defaultYearMode defaultYearMode Default value is "end"
     */
    public void setDefaultYearMode(FiscalYearMode defaultYearMode) {
        setAttribute("defaultYearMode", defaultYearMode == null ? null : defaultYearMode.getValue());
    }

    /**
     * This attribute controls how the displayed fiscalYear value should be calculated for dates falling within a period not
     * explicitly listed in the +lik{fiscalCalendar.fiscalYears,fiscal years array}. <P> The {@link
     * com.smartgwt.client.widgets.FiscalCalendar#getDefaultMonth defaultMonth} and {@link
     * com.smartgwt.client.widgets.FiscalCalendar#getDefaultDate defaultDate} will be used to calculate the start of the fiscal
     * year period. The defaultYearMode  determines whether the reported fiscalYear for this period matches the year in which
     * the period starts or the year in which it ends (so whether a fiscal year spanning dates within both 2020 and 2021 is
     * reported as fiscalYear 2020 or 2021).
     *
     *
     * @return FiscalYearMode
     */
    public FiscalYearMode getDefaultYearMode()  {
        return EnumUtil.getEnum(FiscalYearMode.values(), getAttribute("defaultYearMode"));
    }

    /**
     * An array of {@link com.smartgwt.client.widgets.FiscalYear FiscalYear objects} which each represent the start date of a 
     * single fiscal year.
     *
     * @param fiscalYears fiscalYears Default value is null
     */
    public void setFiscalYears(FiscalYear... fiscalYears) {
        setAttribute("fiscalYears", fiscalYears);
    }

    /**
     * An array of {@link com.smartgwt.client.widgets.FiscalYear FiscalYear objects} which each represent the start date of a 
     * single fiscal year.
     *
     *
     * @return FiscalYear
     */
    public FiscalYear[] getFiscalYears()  {
        return FiscalYear.convertToFiscalYearArray(getAttributeAsJavaScriptObject("fiscalYears"));
    }

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************
        
    // ***********************************************************        

}



