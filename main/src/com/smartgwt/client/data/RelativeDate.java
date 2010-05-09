/*
 * Smart GWT (GWT for SmartClient)
 * Copyright 2008 and beyond, Isomorphic Software, Inc.
 *
 * Smart GWT is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License version 3
 * is published by the Free Software Foundation.  Smart GWT is also
 * available under typical commercial license terms - see
 * http://smartclient.com/license
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 */

package com.smartgwt.client.data;

import com.google.gwt.core.client.JavaScriptObject;
import com.smartgwt.client.core.DataClass;
import com.smartgwt.client.util.JSOHelper;

public class RelativeDate extends DataClass {
    private String value;

    /**
     * Builtin option for this moment
     */
    public static RelativeDate NOW = new RelativeDate("$now");

    /**
     * Builtin option for the start of today 
     */
    public static RelativeDate TODAY = new RelativeDate("$today");

    /**
     * Builtin option for the start of today (same as {@link #TODAY})
     */
    public static RelativeDate START_OF_TODAY = new RelativeDate("$startOfToday");

    /**
     * Builtin option for the end of today (one millisecond before the {@link #START_OF_TODAY}
     */
    public static RelativeDate END_OF_TODAY = new RelativeDate("$endOfToday");

    /**
     * Builtin option for the start of yesterday 
     */
    public static RelativeDate YESTERDAY = new RelativeDate("$yesterday");

    /**
     * Builtin option for the start of yesterday (same as {@link #YESTERDAY})
     */
    public static RelativeDate START_OF_YESTERDAY = new RelativeDate("$startOfYesterday");

    /**
     * Builtin option for the end of yesterday (one millisecond before the {@link #START_OF_YESTERDAY}) 
     */
    public static RelativeDate END_OF_YESTERDAY = new RelativeDate("$endOfYesterday");

    /**
     * Builtin option for the start of tomorrow
     */
    public static RelativeDate TOMORROW = new RelativeDate("$tomorrow");

    /**
     * Builtin option for the start of tomorrow (same as {@link #TOMORROW})
     */
    public static RelativeDate START_OF_TOMORROW = new RelativeDate("$startOfTomorrow");

    /**
     * Builtin option for the end of tomorrow (one millisecond before the {@link START_OF_TOMORROW})
     */
    public static RelativeDate END_OF_TOMORROW = new RelativeDate("$endOfTomorrow");

    /**
     * Builtin option for the start of the current week 
     */
    public static RelativeDate START_OF_WEEK = new RelativeDate("$startOfWeek");

    /**
     * Builtin option for the end of the current week 
     */
    public static RelativeDate END_OF_WEEK = new RelativeDate("$endOfWeek");

    /**
     * Builtin option for this moment
     */
    public static RelativeDate START_OF_MONTH = new RelativeDate("$startOfMonth");

    /**
     * Builtin option for the end of the current month 
     */
    public static RelativeDate END_OF_MONTH = new RelativeDate("$endOfMonth");

    /**
     * Builtin option for the start of the current year
     */
    public static RelativeDate START_OF_YEAR = new RelativeDate("$startOfYear");

    /**
     * Builtin option for the end of the current year 
     */
    public static RelativeDate END_OF_YEAR = new RelativeDate("$endOfYear");    


    public RelativeDate(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    private native String mapRelativeDateShortcut(String relativeDateString)/*-{
        return $wnd.isc.RelativeDateItem.mapRelativeDateShortcut(relativeDateString);
    }-*/;

    @Override
    public JavaScriptObject getJsObj() {
        JavaScriptObject jsObj = JavaScriptObject.createObject();
        JSOHelper.setAttribute(jsObj, "_constructor", "RelativeDate");
        JSOHelper.setAttribute(jsObj, "value", mapRelativeDateShortcut(value));
        return jsObj;
    }
}
