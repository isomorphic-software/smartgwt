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
import com.smartgwt.client.types.ValueEnum;
import com.smartgwt.client.util.JSOHelper;

/**
 * This class is used used to specify a datetime offset within SmartGWT, for example for use in the
 * {@link com.smartgwt.client.widgets.form.fields.RelativeDateItem} class.
 * <P>
 * The value attribute is set to a string which specifies the offset from some base date (typically 
 * the current date as returned from a call to <code>new Date();</code>).
 * See {@link #RelativeDate(String)} for details on the expected format of the string passed in.
 *
 * @see com.smartgwt.client.data.DateRange#setRelativeStartDate(RelativeDate)
 * @see com.smartgwt.client.data.DateRange#setRelativeEndDate(RelativeDate)
 */
public class RelativeDate extends DataClass {
    private String value;

    /**
     * Builtin option for this moment - equivalent to calling
     * <code>new RelativeDate(RelativeDateShortcut.NOW);</code>
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
     * Builtin option for the end of tomorrow (one millisecond before the {@link #START_OF_TOMORROW})
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

    /**
     * The value attribute of a RelativeDate object is a string that should be specified in one of 2 formats:
     * <P>
     * There are a number of standard preset shortcut date-offset strings. These include the following
     * <ul>
     * <li> $now - this moment </li>
     * <li> $today - the current day. By default this resolves to the start of the current day though
     * an explicit +link{RelativeDateRangePosition} may be used to specify the end of the current day.</li>
     * <li> $startOfToday - the start of today</li>
     * <li> $endOfToday - the end of today (one millisecond before the $startOfTomorrow) </li>
     * <li> $yesterday - the previous day.</li>
     * <li> $startOfYesterday - the start of yesterday</li>
     * <li> $endOfYesterday - the end of yesterday (one millisecond before the $startOfToday) </li>
     * <li> $tomorrow - the following day</li>
     * <li> $startOfTomorrow - the start of tomorrow </li>
     * <li> $endOfTomorrow - the end of tomorrow </li>
     * <li> $startOfWeek - the start of the current week </li>
     * <li> $endOfWeek - the end of the current week </li>
     * <li> $startOfMonth - the start of the current month </li>
     * <li> $endOfMonth - the end of the current month </li>
     * <li> $startOfYear - the start of the current year </li>
     * <li> $endOfYear - the end of the current year </li>
     * </ul>
     * Note that some shortcuts indicate a time period but do not directly indicate whether the value 
     * refers to the start or end of the time period in question (for example "$today"). This 
     * ambiguity can be resolved by specifying an explicit RelativeDateRangePosition when calling APIs
     * that convert from RelativeDates to absolute date values.<br>
     * <P>
     * Alternatively the value can be a special RelativeDateString comprised of the following parts:
     * <ul>
     * <li>direction: the direction in which the quantity applies - one of + or - </li>
     * <li>quantity: the number of units of time to apply - a number </li>
     * <li>timeUnit: an abbreviated timeUnit to use - one of ms/MS (millisecond), s/S (second),
     *      mn/MN (minute), h/H (hour), d/D (day), w/W (week), m/M (month), q/Q (quarter, 3-months),
     *      y/Y (year), dc/DC (decade) or c/C (century). <br>
     *      The timeUnit is case sensitive. A lowercase timeUnit implies an exact offset, so <code>+1d</code>
     *      refers to the current date / time increased by exactly 24 hours. If the timeUnit is
     *      uppercase, it refers to the start or end boundary of the period of time in question, so
     *      <code>+1D</code> would refer to the end of the day (23:39:59:999) tomorrow, and
     *      <code>-1D</code> would refer to the start of the day (00:00:00:000) yesterday.</li>
     * <li>[qualifier]: an optional timeUnit encapsulated in square-brackets and used to offset
     *     the calculation - eg. if +1d is "plus one day", +1d[W] is "plus one day from the
     *     end of the current week".  You may also specify another complete RelativeDateString as the
     *     [qualifier], which offers more control - eg, +1d[+1W] indicates "plus one day from
     *     the end of NEXT week".</li>
     * </ul>
     * <P>
     * This format is very flexible. Here are a few example relative date strings:<br>
     * <code>+0D</code>: End of today. There are often multiple ways to represent the same time
     *  using this system - for example this could also be written as <code>-1ms[+1D]</code><br>
     *  <code>-0D</code>: Beginning of today.<br>
     *  <code>+1W</code>: End of next week.<br>
     *  <code>+1ms[+0W]</code>: Beginning of next week.<br>
     *  <code>+1w[-0D]</code>: Beginning of the current day of next week.
     *  
     * @param value string representation of the relative date
     */
    public RelativeDate(String value) {
        //TODO add regex based assert to validate base syntax, along supported with built in types
        this.value = value;
    }

    public RelativeDate(JavaScriptObject jsObj) {
        super(jsObj);
        value = JSOHelper.getAttribute(jsObj, "value");
    }

    /**
     * @return the string representation of the relative date
     * @see #RelativeDate(String)
     */
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
