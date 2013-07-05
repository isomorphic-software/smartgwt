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
 
package com.smartgwt.client.util;


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
 * Extensions to the Date class, including added static methods on the Date object, and  additional instance methods
 * available on all date instances.
 */
public class DateUtil {


    // ********************* Properties / Attributes ***********************

    // ********************* Methods ***********************
	/**
     * Returns the fiscal week number of the current date, according to the global {@link
     * com.smartgwt.client.util.Date#setFiscalCalendar FiscalCalendar}.
     *
     * @return the week number, offset from the start of the fiscal period
     */
    public native int getFiscalWeek() /*-{
        var ret = self.getFiscalWeek();
        return ret;
    }-*/;
	/**
     * Returns the fiscal week number of the current date, according to the global {@link
     * com.smartgwt.client.util.Date#setFiscalCalendar FiscalCalendar}.
     * @param fiscalCalendar the object representing the starts of fiscal years
     *
     * @return the week number, offset from the start of the fiscal period
     */
    public native int getFiscalWeek(FiscalCalendar fiscalCalendar) /*-{
        var ret = self.getFiscalWeek(fiscalCalendar == null ? null : fiscalCalendar.@com.smartgwt.client.core.DataClass::getJsObj()());
        return ret;
    }-*/;
	/**
     * Returns the {@link com.smartgwt.client.widgets.FiscalYear} object appropriate for the the current date, according to the
     * {@link com.smartgwt.client.widgets.FiscalCalendar FiscalCalendar}.
     *
     * @return the fiscal year object
     */
    public native FiscalYear getFiscalYear() /*-{
        var ret = self.getFiscalYear();
        if(ret == null) return null;
        return @com.smartgwt.client.widgets.FiscalYear::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;
	/**
     * Return the abbreviated (up to 3 chars) day of week name for this date (Mon, Tue, etc). To modify the value returned by
     * this method, set {@link com.smartgwt.client.util.Date#shortDayNames shortDayNames}
     * @param length Number of characters to return (Defaults to 3, can't be                                  longer than 3)
     *
     * @return Abbreviated day name
     */
    public native String getShortDayName(int length) /*-{
        var ret = self.getShortDayName(length);
        return ret;
    }-*/;
	/**
     * Return the abbreviated (up to 3 chars) name of the month for this date (Jan, Feb, etc) To modify the value returned by
     * this method, set {@link com.smartgwt.client.util.Date#shortMonthNames shortMonthNames}
     * @param length Number of characters to return (Defaults to 3, can't be                                  longer than 3)
     *
     * @return Abbreviated month name (3 character string)
     */
    public native String getShortMonthName(int length) /*-{
        var ret = self.getShortMonthName(length);
        return ret;
    }-*/;
	/**
     * Return a 2 digit year for this date.
     *
     * @return year number, padded to 2 characters
     */
    public native String getShortYear() /*-{
        var ret = self.getShortYear();
        return ret;
    }-*/;
	/**
     * Returns an integer containing the week number
     *
     * @return week number, starting with 1
     */
    public native int getWeek() /*-{
        var ret = self.getWeek();
        return ret;
    }-*/;
	/**
     * Set the formatter for this date object to the method name passed in.  After this call  wherever appropriate Smart GWT
     * components will use this formatter function to return  the date as a string.
     * @param functionName name of a date formatter method on this Date
     * @deprecated As of Smart GWT 5.5 use the static methods              {@link com.smartgwt.client.util.Date#setNormalDisplayFormat
     * Date.setNormalDisplayFormat} and              {@link com.smartgwt.client.util.Date#setShortDisplayFormat
     * Date.setShortDisplayFormat} to set default formatters for all dates
     */
    public native void setFormatter(String functionName) /*-{
        self.setFormatter(functionName);
    }-*/;
	/**
     * Return this date in the format (UTC timezone):    <code><i>YYYYMMDD</i>T<i>HHMMSS</i>[Z]</code>
     *
     * @return formatted date string
     */
    public native String toDateStamp() /*-{
        var ret = self.toDateStamp();
        return ret;
    }-*/;
	/**
     * Return this date in the format: <code>DD/MM/YYYY</code>
     *
     * @return formatted date string
     */
    public native String toEuropeanShortDate() /*-{
        var ret = self.toEuropeanShortDate();
        return ret;
    }-*/;
	/**
     * Return this date in the format: <code>DD/MM/YYYY HH:MM</code>.
     *
     * @return formatted date string
     */
    public native String toEuropeanShortDateTime() /*-{
        var ret = self.toEuropeanShortDateTime();
        return ret;
    }-*/;
	/**
     * Return the date in this format: <code>YYYY/MM/DD</code>
     *
     * @return formatted date string
     */
    public native String toJapanShortDate() /*-{
        var ret = self.toJapanShortDate();
        return ret;
    }-*/;
	/**
     * Return this date in the format: <code>YYYY/MM/DD HH:MM:SS</code>
     *
     * @return formatted date string
     */
    public native String toJapanShortDateTime() /*-{
        var ret = self.toJapanShortDateTime();
        return ret;
    }-*/;
	/**
     * Returns the date as a formatted string using the format set up via the <code>setNormalDisplayFormat()</code> method.
     * Note that the default formatter for this method is <code>"toLocaleString"</code>.
     * @param format Optional Format for the date returned
     *
     * @return formatted date string
     */
    public native String toNormalDate(DateDisplayFormat format) /*-{
        var ret = self.toNormalDate(format.@com.smartgwt.client.types.DateDisplayFormat::getValue()());
        return ret;
    }-*/;
	/**
     * Returns the datetime as a formatted string using the format set up via the <code>setNormalDatetimeDisplayFormat()</code>
     * method.
     * @param format Optional Format for the date returned
     *
     * @return formatted date string
     */
    public native String toNormalDatetime(DateDisplayFormat format) /*-{
        var ret = self.toNormalDatetime(format.@com.smartgwt.client.types.DateDisplayFormat::getValue()());
        return ret;
    }-*/;
	/**
     * Returns the datetime as a formatted string using the format set up via the <code>setNormalDatetimeDisplayFormat()</code>
     * method.
     * @param format Optional Format for the date returned
     * @param useCustomTimezone If a custom timezone has been set via   Time.setDefaultDisplayTimezone(), by default date formatters will respect this
     * timezone.   To suppress this behavior, this parameter should be set to false.
     *
     * @return formatted date string
     */
    public native String toNormalDatetime(DateDisplayFormat format, Boolean useCustomTimezone) /*-{
        var ret = self.toNormalDatetime(format.@com.smartgwt.client.types.DateDisplayFormat::getValue()(), useCustomTimezone == null ? null : useCustomTimezone.@java.lang.Boolean::booleanValue()());
        return ret;
    }-*/;
	/**
     * Return this date in the format: <code>MM/DD/YY HH:MM</code>
     *
     * @return formatted date string
     * @deprecated As of Smart GWT 5.5 use {@link com.smartgwt.client.util.Date#toShortDate Date.toShortDate} instead
     */
    public native String toPrettyString() /*-{
        var ret = self.toPrettyString();
        return ret;
    }-*/;
	/**
     * Return this date in 'serialized' format <code>YYYY-MM-DD HH:MM:SS</code>
     *
     * @return formatted date string
     */
    public native String toSerializeableDate() /*-{
        var ret = self.toSerializeableDate();
        return ret;
    }-*/;
	/**
     * Returns the date as a formatted string using the format set up via the <code>setShortDisplayFormat()</code> method.
     * @param format Optional Format for the date returned
     *
     * @return formatted date string
     */
    public native String toShortDate(DateDisplayFormat format) /*-{
        var ret = self.toShortDate(format.@com.smartgwt.client.types.DateDisplayFormat::getValue()());
        return ret;
    }-*/;
	/**
     * Returns the date as a formatted string using the format set up via the <code>setShortDisplayFormat()</code> method.
     * @param format Optional Format for the date returned
     * @param useCustomTimezone If a custom timezone has been set via   Time.setDefaultDisplayTimezone(), by default date formatters will respect this
     * timezone.   to suppress this behavior, this parameter should be set to false.
     *
     * @return formatted date string
     */
    public native String toShortDate(DateDisplayFormat format, Boolean useCustomTimezone) /*-{
        var ret = self.toShortDate(format.@com.smartgwt.client.types.DateDisplayFormat::getValue()(), useCustomTimezone == null ? null : useCustomTimezone.@java.lang.Boolean::booleanValue()());
        return ret;
    }-*/;
	/**
     * Returns the datetime as a formatted string using the format set up via the <code>setShortDatetimeDisplayFormat()</code>
     * method.
     * @param format Optional Format for the date returned
     *
     * @return formatted date string
     */
    public native String toShortDateTime(DateDisplayFormat format) /*-{
        var ret = self.toShortDateTime(format.@com.smartgwt.client.types.DateDisplayFormat::getValue()());
        return ret;
    }-*/;
	/**
     * Returns the datetime as a formatted string using the format set up via the <code>setShortDatetimeDisplayFormat()</code>
     * method.
     * @param format Optional Format for the date returned
     * @param useCustomTimezone If a custom timezone has been set via   Time.setDefaultDisplayTimezone(), by default date formatters will respect this
     * timezone.   to suppress this behavior, this parameter should be set to false.
     *
     * @return formatted date string
     */
    public native String toShortDateTime(DateDisplayFormat format, Boolean useCustomTimezone) /*-{
        var ret = self.toShortDateTime(format.@com.smartgwt.client.types.DateDisplayFormat::getValue()(), useCustomTimezone == null ? null : useCustomTimezone.@java.lang.Boolean::booleanValue()());
        return ret;
    }-*/;
	/**
     * Return this date in the format: <code>MM/DD/YYYY</code>
     *
     * @return formatted date string
     */
    public native String toUSShortDate() /*-{
        var ret = self.toUSShortDate();
        return ret;
    }-*/;
	/**
     * Return this date in the format: <code>MM/DD/YYYY HH:MM</code>
     *
     * @return formatted date string
     */
    public native String toUSShortDateTime() /*-{
        var ret = self.toUSShortDateTime();
        return ret;
    }-*/;

    // ********************* Static Methods ***********************
	/**
     * Compare two dates; returns 0 if equal, -1 if the first date is greater (later), or 1 if the second date is greater.  If
     * either value is not a Date object, it is treated as the epoch (midnight on Jan 1 1970) for comparison purposes.
     * @param date1 first date to compare
     * @param date2 second date to compare
     *
     * @return 0 if equal, -1 if first date &gt; second date, 1 if second date &gt; first date
     */
    public static native int compareDates(Date date1, Date date2) /*-{
        var ret = $wnd.isc.Date.compareDates(@com.smartgwt.client.util.JSOHelper::convertToJavaScriptDate(Ljava/util/Date;)(date1), @com.smartgwt.client.util.JSOHelper::convertToJavaScriptDate(Ljava/util/Date;)(date2));
        return ret;
    }-*/;
	/**
     * Compare two dates, normalizing out the time elements so that only the date elements are considered; returns 0 if equal,
     * -1 if the first date is greater (later), or 1 if the second date is greater.
     * @param date1 first date to compare
     * @param date2 second date to compare
     *
     * @return 0 if equal, -1 if first date &gt; second date, 1 if second date &gt;                      first date.  Returns false if
     * either argument is not a date
     */
    public static native int compareLogicalDates(Date date1, Date date2) /*-{
        var ret = $wnd.isc.Date.compareLogicalDates(@com.smartgwt.client.util.JSOHelper::convertToJavaScriptDate(Ljava/util/Date;)(date1), @com.smartgwt.client.util.JSOHelper::convertToJavaScriptDate(Ljava/util/Date;)(date2));
        return ret;
    }-*/;
	/**
     * Create a new <code>Date</code> object - synonym for <code>new Date(arguments)</code>
     *
     * @return Date object
     */
    public static native Date create() /*-{
        var ret = $wnd.isc.Date.create();
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toDate(D)(ret.getTime());
    }-*/;
	/**
     * Returns the global attribute that dictates which day should be treated as the first day of  the week in calendars and
     * date calculations.  The parameter is expected to be an integer  value between 0 (Sunday) and 6 (Saturday). <P> The
     * default value is picked up from the current locale.
     *
     * @return the number of the day being used as the first day of the week
     */
    public static native int getFirstDayOfWeek() /*-{
        var ret = $wnd.isc.Date.getFirstDayOfWeek();
        return ret;
    }-*/;
	/**
     * Returns the global {@link com.smartgwt.client.widgets.FiscalCalendar FiscalCalendar object} representing the start month
     * and date of the fiscal year in the current locale.
     *
     * @return the FiscalCalendar object
     */
    public static native FiscalCalendar getFiscalCalendar() /*-{
        var ret = $wnd.isc.Date.getFiscalCalendar();
        if(ret == null) return null;
        return @com.smartgwt.client.widgets.FiscalCalendar::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;
	/**
     * Returns the start date of the fiscal year for the passed date.
     * @param date the date, or the year-number, to get the fiscal year for
     *
     * @return the start of the fiscal year for the passed date and fiscalCalendar
     */
    public static native Date getFiscalStartDate(Date date) /*-{
        var ret = $wnd.isc.Date.getFiscalStartDate(@com.smartgwt.client.util.JSOHelper::convertToJavaScriptDate(Ljava/util/Date;)(date));
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toDate(D)(ret.getTime());
    }-*/;
	/**
     * Returns the start date of the fiscal year for the passed date.
     * @param date the date, or the year-number, to get the fiscal year for
     * @param fiscalCalendar the object representing the starts of one or more                              fiscal years
     *
     * @return the start of the fiscal year for the passed date and fiscalCalendar
     */
    public static native Date getFiscalStartDate(Date date, FiscalCalendar fiscalCalendar) /*-{
        var ret = $wnd.isc.Date.getFiscalStartDate(@com.smartgwt.client.util.JSOHelper::convertToJavaScriptDate(Ljava/util/Date;)(date), fiscalCalendar == null ? null : fiscalCalendar.@com.smartgwt.client.core.DataClass::getJsObj()());
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toDate(D)(ret.getTime());
    }-*/;
	/**
     * Returns a date's week-number, according to the fiscal calendar
     * @param date the date to get the fiscal year for
     *
     * @return the fiscal week for the passed date
     */
    public static native int getFiscalWeek(Date date) /*-{
        var ret = $wnd.isc.Date.getFiscalWeek(@com.smartgwt.client.util.JSOHelper::convertToJavaScriptDate(Ljava/util/Date;)(date));
        return ret;
    }-*/;
	/**
     * Returns a date's week-number, according to the fiscal calendar
     * @param date the date to get the fiscal year for
     * @param fiscalCalendar the object representing the starts of fiscal years
     *
     * @return the fiscal week for the passed date
     */
    public static native int getFiscalWeek(Date date, FiscalCalendar fiscalCalendar) /*-{
        var ret = $wnd.isc.Date.getFiscalWeek(@com.smartgwt.client.util.JSOHelper::convertToJavaScriptDate(Ljava/util/Date;)(date), fiscalCalendar == null ? null : fiscalCalendar.@com.smartgwt.client.core.DataClass::getJsObj()());
        return ret;
    }-*/;
	/**
     * Returns the {@link com.smartgwt.client.widgets.FiscalYear} object for the fiscal year in which the passed date exists.
     * @param date the date to get the fiscal year for
     *
     * @return the {@link com.smartgwt.client.widgets.FiscalYear} object for the passed date
     */
    public static native FiscalYear getFiscalYear(Date date) /*-{
        var ret = $wnd.isc.Date.getFiscalYear(@com.smartgwt.client.util.JSOHelper::convertToJavaScriptDate(Ljava/util/Date;)(date));
        if(ret == null) return null;
        return @com.smartgwt.client.widgets.FiscalYear::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;
	/**
     * Returns the {@link com.smartgwt.client.widgets.FiscalYear} object for the fiscal year in which the passed date exists.
     * @param date the date to get the fiscal year for
     * @param fiscalCalendar the object representing the start of the fiscal period
     *
     * @return the {@link com.smartgwt.client.widgets.FiscalYear} object for the passed date
     */
    public static native FiscalYear getFiscalYear(Date date, FiscalCalendar fiscalCalendar) /*-{
        var ret = $wnd.isc.Date.getFiscalYear(@com.smartgwt.client.util.JSOHelper::convertToJavaScriptDate(Ljava/util/Date;)(date), fiscalCalendar == null ? null : fiscalCalendar.@com.smartgwt.client.core.DataClass::getJsObj()());
        if(ret == null) return null;
        return @com.smartgwt.client.widgets.FiscalYear::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;
	/**
     * Retrieves the default format for strings being parsed into dates via <code>Date.parseInput()</code>
     *
     * @return the current inputFormat for dates
     * @see com.smartgwt.client.util.Date#setInputFormat
     */
    public static native String getInputFormat() /*-{
        var ret = $wnd.isc.Date.getInputFormat();
        return ret;
    }-*/;
	/**
     * Return an array of days that are considered "weekend" days. Values will be the integers returned by the JavaScript
     * built-in Date.getDay(), eg, 0 is Sunday and 6 is Saturday. Override {@link com.smartgwt.client.util.Date#weekendDays
     * weekendDays} to accommodate different workweeks such as Saudi Arabia (Saturday -> Wednesday) or  Israel (Sunday ->
     * Thursday).
     *
     * @return array of weekend days
     */
    public static native Integer[] getWeekendDays() /*-{
        var ret = $wnd.isc.Date.getWeekendDays();
        if(ret == null) return null;
        return @com.smartgwt.client.util.ConvertTo::arrayOfInteger(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;
	/**
     * Parse a date passed in as a string, returning the appropriate date object.
     * @param dateString date value as a string
     *
     * @return date value, or null if the string could not be parsed to a valid date.
     */
    public static native Date parseInput(String dateString) /*-{
        var ret = $wnd.isc.Date.parseInput(dateString);
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toDate(D)(ret.getTime());
    }-*/;

	/**
	 * @see {@link Date#parseInput()}
	 */
	public Date parseInput(String dateString, String format){
		return parseInput(dateString,format,(Integer) null,null);
	}

	/**
	 * @see {@link Date#parseInput()}
	 */
	public Date parseInput(String dateString, String format, Integer centuryThreshold){
		return parseInput(dateString,format,centuryThreshold,null);
	}
	/**
     * Parse a date passed in as a string, returning the appropriate date object.
     * @param dateString date value as a string
     * @param format Format of the date string being passed.                                      If not passed, the default date input
     * format as set up                                      via setInputFormat() will be used.. See {@link com.smartgwt.client.docs.DateInputFormat DateInputFormat}
     * @param centuryThreshold For date formats that support a 2 digit                                  year, if parsed year is 2 digits and less than
     * this                                  number, assume year to be 20xx rather than 19xx
     * @param suppressConversion If the string passed in was not a valid date, in some cases we can convert to a          valid date (for example
     * incrementing the year if the month is greater than 12).          This optional parameter will suppress such conversions
     * - anything that doesn't          parse directly to a valid date will simply return null.
     *
     * @return date value, or null if the string could not be parsed to a valid date.
     */
    public static native Date parseInput(String dateString, String format, Integer centuryThreshold, Boolean suppressConversion) /*-{
        var ret = $wnd.isc.Date.parseInput(dateString, format, centuryThreshold == null ? null : centuryThreshold.@java.lang.Integer::intValue()(), suppressConversion == null ? null : suppressConversion.@java.lang.Boolean::booleanValue()());
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toDate(D)(ret.getTime());
    }-*/;
	/**
     * Sets the global attribute that dictates which day should be treated as the first day of the week in calendars and date
     * calculations.  The parameter is expected to be an integer value  between 0 (Sunday) and 6 (Saturday). <P> The default
     * value is picked up from the current locale.
     * @param firstDayOfWeek the number of the day to use as the first day of the week
     */
    public static native void setFirstDayOfWeek(int firstDayOfWeek) /*-{
        $wnd.isc.Date.setFirstDayOfWeek(firstDayOfWeek);
    }-*/;
	/**
     * Sets the global fiscal calendar, which is used for all calls to getFiscalYear() / getFiscalWeek() if those methods
     * aren't passed a fiscalCalander.
     * @param fiscalCalendar the object representing the start month and date of           the fiscal year in the current locale
     */
    public static native void setFiscalCalendar(FiscalCalendar fiscalCalendar) /*-{
        $wnd.isc.Date.setFiscalCalendar(fiscalCalendar.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;
	/**
     * Sets up the default system-wide input format for strings being parsed into dates via <code>Date.parseInput()</code>.
     * This will effect how Smart GWT components showing editable date or datetime fields parse user-entered values into live
     * Date objects. <P> The input format can be specified as a DateInputFormat - a 3 character string like <code>"MDY"</code>
     * indicating the order of the Month, Day and Year components of date strings. <P> As an example - an input format of "MDY"
     * would parse "01/02/1999" to Jan 2nd 1999<br> This standard parsing logic will also handle date-time strings such as
     * "01/02/1999 08:45", or "01/02/1999 16:21:05". <P> Notes: <ul> <li>If the inputFormat is not explicitly set,the system
     * automatically determines     the standard input format will be based on the specified {@link
     * com.smartgwt.client.util.Date#getShortDisplayFormat shortDisplayFormat}     wherever possible.     For example if the
     * short display format has been set to "toEuropeanShortDate" the input     format will default to "DMY".</li> <li>The
     * default date parsing functionality built into Smart GWT will handle dates presented     with any separator string, and
     * can handle 1 or 2 digit day and month values and 2 or 4     digit year values. This means that in many cases custom date
     * display formats can be parsed     back to Date values without the need for a custom parser function. However if more    
     * sophisticated parsing logic is required, a function may be passed into this method. In     this case the parser function
     * should be able to handle parsing date and datetime values     formatted via {@link
     * com.smartgwt.client.util.Date#toShortDate Date.toShortDate} and {@link com.smartgwt.client.util.Date#toShortDateTime
     * Date.toShortDateTime}.</li> <li>Date parsing and formatting logic may be overridden at the component level by setting   
     *  properties directly on the component or field in question.</li> </ul>
     * @param format Default format for strings to be parsed into Dates.. See {@link com.smartgwt.client.docs.DateInputFormat DateInputFormat}
     * @see com.smartgwt.client.util.Date#parseInput
     * 
     * 
     */
    public static native void setInputFormat(String format) /*-{
        $wnd.isc.Date.setInputFormat(format);
    }-*/;
	/**
     * Set the default normal format for datetime values. After calling this method, subsequent calls to {@link
     * com.smartgwt.client.util.Date#toNormalDatetime Date.toNormalDatetime} will return a string formatted according to this
     * format specification. Note that this will be the standard datetime format used by Smart GWT components. <P> The
     * <code>format</code> parameter may be either a {@link com.smartgwt.client.types.DateDisplayFormat} string, or a function.
     * If passed a function, this function will be executed in the scope of the Date and should return the formatted string.
     * @param format new formatter
     * 
     * 
     */
    public static native void setNormalDatetimeDisplayFormat(DateDisplayFormat format) /*-{
        $wnd.isc.Date.setNormalDatetimeDisplayFormat(format.@com.smartgwt.client.types.DateDisplayFormat::getValue()());
    }-*/;
	/**
     * Set the default formatter for date objects to the method name passed in.  After calling this method, subsequent calls to
     * {@link com.smartgwt.client.util.Date#toNormalDate Date.toNormalDate} will return a string formatted according to this
     * format specification. Note: this will be the standard long date format used by Smart GWT components.<br> The
     * <code>format</code> parameter may be either a {@link com.smartgwt.client.types.DateDisplayFormat} string, or a function.
     * If passed a function, this function will be executed in the scope of the Date and should return the formatted
     * string.<br> Initial default normalDisplayFormat is <code>"toLocaleString"</code>
     * @param format new formatter
     */
    public static native void setNormalDisplayFormat(DateDisplayFormat format) /*-{
        $wnd.isc.Date.setNormalDisplayFormat(format.@com.smartgwt.client.types.DateDisplayFormat::getValue()());
    }-*/;
	/**
     * Set the default short format for dates. After calling this method, subsequent calls to {@link
     * com.smartgwt.client.util.Date#toShortDate Date.toShortDate} will return a string formatted according to this format
     * specification. Note that this will be the standard short date format used by Smart GWT components. <P> The
     * <code>format</code> parameter may be either a {@link com.smartgwt.client.types.DateDisplayFormat} string, or a function.
     * If passed a function, this function will be executed in the scope of the Date and should return the formatted string.
     * <P> Initial default shortDateFormat is <code>"toUSShortDate"</code>. This property is commonly modified for localization
     * of applications. See <a href='http://en.wikipedia.org/wiki/Date_format_by_country'
     * onclick="window.open('http://en.wikipedia.org/wiki/Date_format_by_country');return
     * false;">http://en.wikipedia.org/wiki/Date_format_by_country</a> for a useful overview of standard date formats per
     * country.
     * @param format new formatter
     * 
     * 
     */
    public static native void setShortDisplayFormat(DateDisplayFormat format) /*-{
        $wnd.isc.Date.setShortDisplayFormat(format.@com.smartgwt.client.types.DateDisplayFormat::getValue()());
    }-*/;
	/**
     * Sets the global attribute that dictates whether the {@link com.smartgwt.client.widgets.DateChooser choosers} shelled
     * from {@link com.smartgwt.client.widgets.form.fields.DateItem DateItems} show a UI for working with Fiscal Years.
     * @param showChooserFiscalYearPickers whether to show Fiscal Year pickers in DateChoosers by default
     */
    public static native void setShowChooserFiscalYearPickers(boolean showChooserFiscalYearPickers) /*-{
        $wnd.isc.Date.setShowChooserFiscalYearPickers(showChooserFiscalYearPickers == null ? false : showChooserFiscalYearPickers);
    }-*/;
	/**
     * Sets the global attribute that dictates whether the {@link com.smartgwt.client.widgets.DateChooser choosers} shelled
     * from {@link com.smartgwt.client.widgets.form.fields.DateItem DateItems} show a UI for working with Weeks.
     * @param showChooserWeekPickers whether to show Fiscal Week pickers in DateChoosers by default
     */
    public static native void setShowChooserWeekPickers(boolean showChooserWeekPickers) /*-{
        $wnd.isc.Date.setShowChooserWeekPickers(showChooserWeekPickers == null ? false : showChooserWeekPickers);
    }-*/;
	/**
     * Sets the days that are considered {@link com.smartgwt.client.util.Date#weekendDays weekend days}.  The parameter  should
     * be array of the integers returned by the JavaScript built-in Date.getDay(), eg, 0 is  Sunday and 6 is Saturday. 
     * Override to accommodate different workweeks such as Saudi Arabia  (Saturday -> Wednesday) or Israel (Sunday ->
     * Thursday).
     * @param weekendDays the array of day-numbers to assign as weekend days
     */
    public static native void setWeekendDays(Integer[] weekendDays) /*-{
        $wnd.isc.Date.setWeekendDays(@com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(weekendDays));
    }-*/;

    // ***********************************************************



/**
 * Date related utility methods.
 */

    private static final class NativeDateDisplayFormatter implements DateDisplayFormatter {

        private String functionName;

        public NativeDateDisplayFormatter(String functionName) {
            this.functionName = functionName;
        }

        @Override
        public native String format(Date date) /*-{
            if (date == null) {
                return null;
            } else {
                var functionName = this.@com.smartgwt.client.util.DateUtil.NativeDateDisplayFormatter::functionName;
                var dateJS = @com.smartgwt.client.util.JSOHelper::toDateJS(Ljava/util/Date;)(date);
                return $wnd.isc.Date.prototype[functionName].call(dateJS);
            }
        }-*/;

        /*
         * The native function name of is a <code>String</code> such that
         * <code>$wnd.isc.isA.Function($wnd.isc.Date.prototype[fnName])</code> is true.
         */
        public String getNativeFunctionName() {
            return functionName;
        }

        public static String nativeNameOf(DateDisplayFormatter formatter) {
            if (formatter instanceof NativeDateDisplayFormatter) {
                return ((NativeDateDisplayFormatter) formatter).getNativeFunctionName();
            } else {
                return null;
            }
        }
    }

    /**
     * Default native browser 'toString()' implementation. May vary by browser.<br> <i>Example</i>: <code>Fri Nov 04 2005
     * 11:03:00 GMT-0800 (Pacific Standard Time)</code>
     */
    public static final DateDisplayFormatter TOSTRING = new NativeDateDisplayFormatter("toString");

    /**
     * Default native browser 'toLocaleString()' implementation. May vary by browser. <i>Example</i>: <code>Friday, November
     * 04, 2005 11:03:00 AM</code>
     */
    public static final DateDisplayFormatter TOLOCALESTRING = new NativeDateDisplayFormatter("toLocaleString");

    /**
     * Normal date format for the locale
     */
    public static final DateDisplayFormatter TONORMALDATE = new NativeDateDisplayFormatter("toNormalDate");

    /**
     * Normal datetime format for the locale
     */
    public static final DateDisplayFormatter TONORMALDATETIME = new NativeDateDisplayFormatter("toNormalDatetime");

    /**
     * Short date in format MM/DD/YYYY.<br> <i>Example</i>: <code>11/4/2005</code>
     */
    public static final DateDisplayFormatter TOUSSHORTDATE = new NativeDateDisplayFormatter("toUSShortDate");

    /**
     * Short date with time in format MM/DD/YYYY HH:MM<br> <i>Example</i>: <code>11/4/2005 11:03</code>
     */
    public static final DateDisplayFormatter TOUSSHORTDATETIME = new NativeDateDisplayFormatter("toUSShortDatetime");

    /**
     * Short date in format DD/MM/YYYY.<br> <i>Example</i>: <code>4/11/2005</code>
     */
    public static final DateDisplayFormatter TOEUROPEANSHORTDATE = new NativeDateDisplayFormatter("toEuropeanShortDate");

    /**
     * Short date with time in format DD/MM/YYYY HH:MM<br> <i>Example</i>: <code>4/11/2005 11:03</code>
     */
    public static final DateDisplayFormatter TOEUROPEANSHORTDATETIME = new NativeDateDisplayFormatter("toEuropeanShortDatetime");

    /**
     * Short date in format YYYY/MM/DD.<br> <i>Example</i>: <code>2005/11/4</code>
     */
    public static final DateDisplayFormatter TOJAPANSHORTDATE = new NativeDateDisplayFormatter("toJapanShortDate");

    /**
     * Short date with time in format YYYY/MM/DD HH:MM<br> <i>Example</i>: <code>2005/11/4 11:03</code>
     */
    public static final DateDisplayFormatter TOJAPANSHORTDATETIME = new NativeDateDisplayFormatter("toJapanShortDatetime");

    /**
     * Date in the format YYYY-MM-DD HH:MM:SS<br> <i>Example</i>: <code>2005-11-04 11:09:15</code>
     */
    public static final DateDisplayFormatter TOSERIALIZEABLEDATE = new NativeDateDisplayFormatter("toSerializeableDate");

    /**
     * Date in the format &lt;YYYYMMDD&gt;T&lt;HHMMSS&gt;Z <i>Example</i>: <code>20051104T111001Z</code>
     */
    public static final DateDisplayFormatter TODATESTAMP = new NativeDateDisplayFormatter("toDateStamp");

    /*
     * Convert the supplied date display formatter to a JavaScript function.  If the formatter
     * happens to correspond to a native JavaScript date function then the returned value is
     * the string name of that native JavaScript function.  The return value is
     * suitable for passing to $wnd.isc.Date.prototype.setNormalDisplayFormat(), setShortDisplayFormat(), or
     * setShortDatetimeDisplayFormat().
     */
    private static final native Object convertDateDisplayFormatterToJS(DateDisplayFormatter formatter) /*-{
        var functionName = @com.smartgwt.client.util.DateUtil.NativeDateDisplayFormatter::nativeNameOf(Lcom/smartgwt/client/util/DateDisplayFormatter;)(formatter);
        return functionName || function () {
                var date = this;
                var dateJ = date == null || date === undefined ? null : @com.smartgwt.client.util.JSOHelper::toDate(D)(date.getTime());
                return formatter.@com.smartgwt.client.util.DateDisplayFormatter::format(Ljava/util/Date;)(dateJ);
            };
    }-*/;

    private static final class NativeTimeDisplayFormatter implements DateDisplayFormatter {

        private String functionName;

        public NativeTimeDisplayFormatter(String functionName) {
            this.functionName = functionName;
        }

        @Override
        public native String format(Date date) /*-{
            if (date == null) {
                return null;
            } else {
                var functionName = this.@com.smartgwt.client.util.DateUtil.NativeTimeDisplayFormatter::functionName;
                var dateJS = @com.smartgwt.client.util.JSOHelper::toDateJS(Ljava/util/Date;)(date);
                return $wnd.isc.Time.format.call($wnd.isc.Time, dateJS, functionName);
            }
        }-*/;

        public String getNativeFunctionName() {
            return functionName;
        }

        public static String nativeNameOf(DateDisplayFormatter formatter) {
            if (formatter instanceof NativeTimeDisplayFormatter) {
                return ((NativeTimeDisplayFormatter) formatter).getNativeFunctionName();
            } else {
                return null;
            }
        }
    }

    /**
     * String will display with seconds and am/pm indicator: <code>[H]H:MM:SS am|pm</code>. <br> Example: <code>3:25:15
     * pm</code>
     */
    public static final DateDisplayFormatter TOTIME = new NativeTimeDisplayFormatter("toTime");

    /**
     * String will display with seconds in 24 hour time: <code>[H]H:MM:SS</code>. <br> Example: <code>15:25:15</code>
     */
    public static final DateDisplayFormatter TO24HOURTIME = new NativeTimeDisplayFormatter("to24HourTime");

    /**
     * String will display with seconds, with a 2 digit hour and am/pm indicator: <code>HH:MM:SS am|pm</code>. <br> Example:
     * <code>03:25:15 pm</code>
     */
    public static final DateDisplayFormatter TOPADDEDTIME = new NativeTimeDisplayFormatter("toPaddedTime");

    /**
     * String will display with seconds, with a 2 digit hour in 24 hour format: <code>HH:MM:SS</code>. <br> Examples:
     * <code>15:25:15</code>, <code>03:16:45</code>
     */
    public static final DateDisplayFormatter TOPADDED24HOURTIME = new NativeTimeDisplayFormatter("toPadded24HourTime");

    /**
     * String will have no seconds and be in 12 hour format: <code>[H]H:MM am|pm</code>.<br> Example: <code>3:25 pm</code>
     */
    public static final DateDisplayFormatter TOSHORTTIME = new NativeTimeDisplayFormatter("toShortTime");

    /**
     * String will have no seconds and be in 24 hour format: <code>[H]H:MM</code>.<br> Example:<code>15:25</code>
     */
    public static final DateDisplayFormatter TOSHORT24HOURTIME = new NativeTimeDisplayFormatter("toShort24HourTime");

    /**
     * String will have no seconds and will display a 2 digit hour, in 12 hour clock format: <code>HH:MM am|pm</code>.<br>
     * Example: <code>03:25 pm</code>
     */
    public static final DateDisplayFormatter TOSHORTPADDEDTIME = new NativeTimeDisplayFormatter("toShortPaddedTime");

    /**
     * String will have no seconds and will display with a 2 digit hour in 24 hour clock format: <code>HH:MM</code>.<br>
     * Examples: <code>15:25</code>, <code>03:16</code>
     */
    public static final DateDisplayFormatter TOSHORTPADDED24HOURTIME = new NativeTimeDisplayFormatter("toShortPadded24HourTime");

    /*
     * Convert the supplied date display formatter to a JavaScript function.  If the formatter
     * happens to correspond to a SmartClient time function then the returned value is
     * the string name of that function.  The return value is suitable for passing to
     * $wnd.isc.Time.setShortDisplayFormat() or setNormalDisplayFormat().
     */
    private static final native Object convertTimeDisplayFormatterToJS(DateDisplayFormatter formatter) /*-{
        var functionName = @com.smartgwt.client.util.DateUtil.NativeTimeDisplayFormatter::nativeNameOf(Lcom/smartgwt/client/util/DateDisplayFormatter;)(formatter);
        return functionName || function () {
                var date = this;
                var dateJ = date == null || date === undefined ? null : @com.smartgwt.client.util.JSOHelper::toDate(D)(date.getTime());
                return formatter.@com.smartgwt.client.util.DateDisplayFormatter::format(Ljava/util/Date;)(dateJ);
            };
    }-*/;

    /**
     * Globally sets the offset from UTC to use when formatting values of type datetime and time with
     * standard display formatters. This property effects how dates are displayed and also the
     * assumed timezone for user-input.
     * <P>
     * If this method is never called, the default display timezone for times and datetimes will be
     * derived from the native
     * browser local timezone.
     * <p>
     * Note that by default daylight savings time adjustments (based on browser locale) may also be
     * applied when formatting datetimes.
     * {@link #setAdjustForDST(boolean)} may be used to disable this adjustment.
     *
     * @param offset offset from UTC. This should be a string in the format <code>+/-HH:MM</code> for example <code>"-08:00"</code>
     */
    public static native void setDefaultDisplayTimezone(String offset) /*-{
        $wnd.isc.Time.setDefaultDisplayTimezone(offset);
    }-*/;

    /**
     *
     * Determines whether, when formatting values of type datetime and time,
     * the effect of Daylight Saving Time should be considered when computing offsets from UTC.
     * By default, this flag is set during framework initialization if SmartGWT detects that
     * it is running in a locale that is observing DST this year.
     * If you do not want DST adjustments to be applied, set this flag to false.<p>
     * Note that setting this flag to true will have no effect unless you are in a locale
     * that is observing Daylight Saving Time this year; this is because we rely on the
     * browser for offset information, and browsers are only capable of returning local date
     * and time information for the computer's current locale.
     *
     * @param whether time and datetimes should account for daylight savings time in this application
     */
    public static native void setAdjustForDST(boolean adjustForDST) /*-{
        $wnd.isc.Time.adjustForDST = adjustForDST;
    }-*/;

    /**
     * Sets a new default separator that will be used when formatting dates. By default, this is a forward slash character: "/"
     *
     * @param separator the date separator
     */
    public static native void setDefaultDateSeparator(String separator) /*-{
        $wnd.Date.setDefaultDateSeparator(separator);
    }-*/;

    /**
     * Returns the default date separator.
     *
     * @return the default date separator
     */
    public static native String getDefaultDateSeparator() /*-{
        return $wnd.Date.getDefaultDateSeperator();
    }-*/;

    /**
     * Set the default format for date objects to the DateDisplayFormat passed in. After calling this method, subsequent calls to Date.toNormalDate will return a string formatted according to this format specification.
     * <br>
     * <b>Note</b>: this will be the standard long date format used by SmartGWT components.
     * Initial default normalDisplayFormat is "toLocaleString"
     *
     * @param format the DateDisplayFormat
     * @deprecated This method is deprecated in favor of {@link #setNormalDateDisplayFormatter(DateDisplayFormatter)}.
     */
    @Deprecated
    public static native void setNormalDateDisplayFormat(DateDisplayFormat format) /*-{
        $wnd.Date.setNormalDisplayFormat(format.@com.smartgwt.client.types.DateDisplayFormat::getValue()());
    }-*/;

    /**
     * Set the default datetime format for date objects to the DateDisplayFormat passed in. After calling this method, subsequent calls to Date.toNormalDate will return a string formatted according to this format specification.
     * <br>
     * <b>Note</b>: this will be the standard long datetime format used by SmartGWT components.
     * Initial default normalDatetimeDisplayFormat is "toLocaleString"
     *
     * @param format the DateDisplayFormatter
     */
    public static native void setNormalDatetimeDisplayFormatter(DateDisplayFormatter formatter) /*-{
        var formatterJS = @com.smartgwt.client.util.DateUtil::convertDateDisplayFormatterToJS(Lcom/smartgwt/client/util/DateDisplayFormatter;)(formatter);
        $wnd.Date.setNormalDatetimeDisplayFormat(formatterJS);
    }-*/;

    /**
     * Set the default formatter for date objects to the custom DateDisplayFormatter passed in.
     * After calling this method, subsequent calls to Date.toNormalDate will return a string
     * formatted according to this formatter specification.
     * <P>
     * When writing custom date formatting and parsing logic, developers may find the
     * {@link com.google.gwt.i18n.client.DateTimeFormat} class helpful.
     *
     * SmartGWT includes several built-in DateDisplayFormatters for common formats - see
     * {@link DateDisplayFormatter} for details.
     *
     * Sample code :
     * <pre>
     * DateUtil.setNormalDateDisplayFormatter(new DateDisplayFormatter() {
     *     public String format(Date date) {
     *         if(date == null) return null;
     *         final DateTimeFormat dateFormatter = DateTimeFormat.getFormat("yyyy.MM.dd HH:mm:ss");
     *         String format = dateFormatter.format(date);
     *         return format;
     *     }
     * });
     * </pre>
     *
     * @param formatter the DateDisplayFormatter
     */
    public static native void setNormalDateDisplayFormatter(DateDisplayFormatter formatter) /*-{
        var formatterJS = @com.smartgwt.client.util.DateUtil::convertDateDisplayFormatterToJS(Lcom/smartgwt/client/util/DateDisplayFormatter;)(formatter);
        $wnd.Date.setNormalDisplayFormat(formatterJS);
    }-*/;

    /**
     * Set the system wide default short date format.
     * The specified format will be used by default by SmartGwt components when formatting date values to
     * short date format (and by {@link #formatAsShortDate(Date)}).
     * <P>
     * This method, together with {@link DateUtil#setDefaultDateSeparator(String)} provide support for most
     * standard "short date" formats. However if a custom format which doesn't match any of the specified
     * {@link DateDisplayFormat} types is required, a custom formatting function may be provided via
     * {@link #setShortDateDisplayFormatter(DateDisplayFormatter)}.
     * <P>
     * Note that the default short date format is initially set to DateDisplayFormat.TOUSSHORTDATE. This property
     * is commonly modified for localization of applications. See <a href="http://en.wikipedia.org/wiki/Date_format_by_country">Date format by country</a>
     * for a useful overview of standard date formats per country.
     *
     * @param format the DateDisplayFormat
     * @deprecated This method is deprecated in favor of {@link #setShortDateDisplayFormatter(DateDisplayFormatter)}.
     */
    @Deprecated
    public static native void setShortDateDisplayFormat(DateDisplayFormat format) /*-{
        $wnd.Date.setShortDisplayFormat(format.@com.smartgwt.client.types.DateDisplayFormat::getValue()());
    }-*/;


    /**
     * Set up a system wide default short date formatting function.
     * The formatter passed in will be used by default by SmartGwt components when formatting date values
     * to short date format (and by {@link #formatAsShortDate(Date)}).
     * <P>
     * If a custom short date formatter is applied, bear in mind that it will be applied by default when
     * editing date values, so the system will need to be able to parse an edited date string in this format
     * back to a live date object. Developers calling this method will therefore also commonly want to
     * apply custom parsing logic via {@link #setDateInputFormat(String)} or {@link #setDateParser(DateParser)}.
     * <P>
     * When writing custom date formatting and parsing logic, developers may find the
     * {@link com.google.gwt.i18n.client.DateTimeFormat} class helpful.
     *
     * SmartGWT includes several built-in DateDisplayFormatters for common formats - see
     * {@link DateDisplayFormatter} for details.
     *
     * Sample code :
     * <pre>
     * DateUtil.setShortDateDisplayFormatter(new DateDisplayFormatter() {
     *     public String format(Date date) {
     *         if(date == null) return null;
     *         final DateTimeFormat dateFormatter = DateTimeFormat.getFormat("MMM d, yyyy");
     *         String format = dateFormatter.format(date);
     *         return format;
     *     }
     * });
     * </pre>
     *
     * @param formatter the DateDisplayFormatter
     */
    public static native void setShortDateDisplayFormatter(DateDisplayFormatter formatter) /*-{
        var formatterJS = @com.smartgwt.client.util.DateUtil::convertDateDisplayFormatterToJS(Lcom/smartgwt/client/util/DateDisplayFormatter;)(formatter);
        $wnd.Date.setShortDisplayFormat(formatterJS);
    }-*/;

    /**
     * Set the system wide default short datetime format.
     * The specified format will be used by default by SmartGwt components when formatting datetime field values to
     * short datetime format (and by {@link #formatAsShortDatetime(Date)}).
     * <P>
     * This method, together with {@link DateUtil#setDefaultDateSeparator(String)} provide support for most
     * standard "short date" formats. However if a custom format which doesn't match any of the specified
     * {@link DateDisplayFormat} types is required, a custom formatting function may be provided via
     * {@link #setShortDatetimeDisplayFormatter(DateDisplayFormatter)}.
     * <P>
     * Note that the default short datetime format is initially set to {@link DateDisplayFormat#TOUSSHORTDATETIME}.
     * This property is commonly modified for localization of applications. See <a href="http://en.wikipedia.org/wiki/Date_format_by_country">Date format by country</a>
     * for a useful overview of standard date formats per country.
     *
     * @param format the DateDisplayFormat
     * @deprecated This method is deprecated in favor of {@link #setShortDatetimeDisplayFormatter(DateDisplayFormatter)}.
     */
    @Deprecated
    public static native void setShortDatetimeDisplayFormat(DateDisplayFormat format) /*-{
        $wnd.Date.setShortDatetimeDisplayFormat(format.@com.smartgwt.client.types.DateDisplayFormat::getValue()());
    }-*/;


    /**
     * Set up a system wide default short datetime formatting function.
     * The formatter passed in will be used by default by SmartGwt components when formatting date values
     * to short datetime format (and by {@link #formatAsShortDatetime(Date)}).
     * <P>
     * If a custom short datetime formatter is applied, bear in mind that it will be applied by default when
     * editing date values, so the system will need to be able to parse an edited date string in this format
     * back to a live date object. Developers calling this method will therefore also commonly want to
     * apply custom parsing logic via {@link #setDateInputFormat(String)} or {@link #setDateParser(DateParser)}.
     * <P>
     * When writing custom date formatting and parsing logic, developers may find the
     * {@link com.google.gwt.i18n.client.DateTimeFormat} class helpful.
     *
     * SmartGWT includes several built-in DateDisplayFormatters for common formats - see
     * {@link DateDisplayFormatter} for details.
     *
     * @param formatter the DateDisplayFormatter
     */
    public static native void setShortDatetimeDisplayFormatter(DateDisplayFormatter formatter) /*-{
        var formatterJS = @com.smartgwt.client.util.DateUtil::convertDateDisplayFormatterToJS(Lcom/smartgwt/client/util/DateDisplayFormatter;)(formatter);
        $wnd.Date.setShortDatetimeDisplayFormat(formatterJS);
    }-*/;

    /**
     * Create a new Date to represent a logical date value (rather than a specific datetime value),
     *  typically for display in a +link{DataSourceField.type,date type field}. The generated
     *  Date value will have year, month and date set to the specified values (in browser native local time).
     *  <P>
     * See the {@link com.smartgwt.client.docs.DateFormatAndStorage docs} for a discussion of the difference between
     * datetime field values and logical date field values, logical time field values.
     *
     *  @param year
     *  @param month
     *  @param date
     *  @return LogicalDate representing a logical date.
     */
    public static native LogicalDate createLogicalDate(int year, int month, int date) /*-{
        var jsDate = $wnd.Date.createLogicalDate(year, month, date);
        if (jsDate == null) return null;
        return @com.smartgwt.client.util.LogicalDate::new(D)(jsDate.getTime());
    }-*/;

    /**
     * Create a new Date object to represent a logical time value (rather than a specific datetime
     * value), typically for display in a +link{DataSourceField.type,time type field}. The generated
     * Date value will have year, month and date set to the epoch date (Jan 1 1970), and time
     * elements set to the supplied hour, minute and second (in browser native local time).
     * <P>
     * See the {@link com.smartgwt.client.docs.DateFormatAndStorage docs} for a discussion of the difference between
     * datetime field values and logical date field values, logical time field values.
     *
     * @param hour (0-23)
     * @param minute (0-59)
     * @param second (0-59)
     * @param millisecond (0-999)
     * @return new LogicalTime representing the time in question
     */
    public static native LogicalTime createLogicalTime(int hour, int minute, int second, int millisecond) /*-{
        var jsDate = $wnd.Date.createLogicalTime(hour, minute, second, millisecond);
        if (jsDate == null) return null;
        return @com.smartgwt.client.util.LogicalTime::new(D)(jsDate.getTime());
    }-*/;

    /**
     * Get a logical date - a value appropriate for a DataSourceField of type "date" - from a datetime value (a value from a
     * DataSourceField of type "datetime"). <P> This method correctly takes into account the current String, specifically, the
     * returned Date  will reflect the day, month and year that appears when the datetime is rendered by a Smart GWT component
     * rather than the date values that would be returned by Date.getDay() et al (which can differ, since getDay() uses the
     * browser's local timezone). <P> For further background on date, time and datetime types, storage and transmission, see 
     * {@link com.smartgwt.client.docs.DateFormatAndStorage this overview}.
     * @param date a Date instance representing a datetime value
     *
     * @return a Date instance representing just the date portion of the datetime value, as                a logical date
     */
    public static native LogicalDate getLogicalDateOnly(Date date) /*-{
        var jsD = $wnd.isc.Date.getLogicalDateOnly(@com.smartgwt.client.util.JSOHelper::convertToJavaScriptDate(Ljava/util/Date;)(date));
        if (jsD == null || jsD === undefined) {
            return null;
        } else {
            return @com.smartgwt.client.util.LogicalDate::new(D)(jsD.getTime());
        }
    }-*/;

    /**
     * Get a logical time - a value appropriate for a DataSourceField of type "time" - from a datetime value (a value from a
     * DataSourceField of type "datetime"). <P> This method correctly takes into account the current String, specifically, the
     * returned Date will reflect the hour, minute and second that appears when the datetime is rendered by a Smart GWT
     * component rather than the time values that would be returned by Date.getHours() et al (which can differ, since
     * getHours() uses the browser's local timezone). <P> For further background on date, time and datetime types, storage and
     * transmission, see {@link com.smartgwt.client.docs.DateFormatAndStorage this overview}.
     * @param date a Date instance representing a datetime value
     *
     * @return a Date instance representing just the time portion of the datetime value, as                a logical time
     */
    public static native LogicalTime getLogicalTimeOnly(Date date) /*-{
        var jsD = $wnd.isc.Date.getLogicalTimeOnly(@com.smartgwt.client.util.JSOHelper::convertToJavaScriptDate(Ljava/util/Date;)(date));
        if (jsD == null || jsD === undefined) {
            return null;
        } else {
            return @com.smartgwt.client.util.LogicalTime::new(D)(jsD.getTime());
        }
    }-*/;

    // Wrappers for the standard Date format / parser functions applied to the Date class in SC.
    // Note that GWT has date parsing and formatting functions via Java util classes - just exposing these
    // for completeness as they're the standards used by components by default
    /**
     * Format a date as a string according to the format specified by
     * {@link #setShortDateDisplayFormat(DateDisplayFormat)} or
     * {@link #setShortDateDisplayFormatter(DateDisplayFormatter)}.
     * <P>
     * This calls the standard date formatting function used by SmartGWT components to display short-formatted
     * dates.
     *
     * @param date
     * @return
     */
    public static native String formatAsShortDate(Date date) /*-{
        if (date == null) return "";
        var jsDate = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptDate(Ljava/util/Date;)(date);
        return jsDate.toShortDate();

    }-*/;

    /**
     * Format a date as a string according to the format specified by
     * {@link #setShortDatetimeDisplayFormat(DateDisplayFormat)} or
     * {@link #setShortDatetimeDisplayFormatter(DateDisplayFormatter)}.
     * <P>
     * This calls the standard date formatting function used by SmartGWT components to display short-formatted
     * date-times.
     *
     * @param date
     * @return
     */
    public static native String formatAsShortDatetime(Date date) /*-{
        if (date == null) return "";
        var jsDate = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptDate(Ljava/util/Date;)(date);
        return jsDate.toShortDateTime();

    }-*/;

    /**
     * Format a date as a string according to the format specified by
     * {@link #setNormalDateDisplayFormat(DateDisplayFormat)} or
     * {@link #setNormalDateDisplayFormatter(DateDisplayFormatter)}.
     * <P>
     * This calls the standard date formatting function used by SmartGWT components to display short-formatted
     * dates.
     *
     * @param date
     * @return
     */
    public static native String format(Date date) /*-{
        if (date == null) return "";
        var jsDate = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptDate(Ljava/util/Date;)(date);
        return jsDate.toShortDate();

    }-*/;

    /**
     * Format a date as a string according to the format specified by
     * {@link #setNormalDateDisplayFormat(DateDisplayFormat)} or
     * {@link #setNormalDateDisplayFormatter(DateDisplayFormatter)}.
     * <P>
     * This calls the standard date formatting function used by SmartGWT components to display normal-formatted
     * dates.
     *
     * @param date
     * @return Returns a String containing the formatted date
     */
    public static native String formatAsNormalDate(Date date) /*-{
        if (date == null) return "";
        var jsDate = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptDate(Ljava/util/Date;)(date);
        return jsDate.toNormalDate();
    }-*/;

    /**
     * Sets up the default format for strings being parsed into dates via DateUtil.parseInput
     * <br>
     * Sample code :
     * <pre>
     * DateUtil.setDateInputFormatter(new DateInputFormatter() {
     *    public Date format(String dateString) {
     *       final DateTimeFormat dateFormatter = DateTimeFormat.getFormat("MMM d, yyyy");
     *       Date date = dateFormatter.parse(dateString);
     *       return date;
     *    }
     * });
     * </pre>
     *
     * @param formatter the DateInputFormatter
     * @deprecated in favor of setDateParser()
     */
    public static native void setDateInputFormatter(DateInputFormatter formatter) /*-{
        $wnd.Date.setInputFormat(function(dateStr) {
                var dateJ = formatter.@com.smartgwt.client.util.DateInputFormatter::parse(Ljava/lang/String;)(dateStr);
                if(dateJ == null) return null;
                return @com.smartgwt.client.util.JSOHelper::toDateJS(Ljava/util/Date;)(dateJ);
            }
        );
    }-*/;

    /**
     * Sets up a custom parsing function to use by default when converting dates or datetimes from
     * formatted string values to Dates. This custom parser will be used by SmartGwt components
     * parsing editable date or datetime type values back to live dates by default.
     * The string passed in will be formatted according to the standard "short date"
     * or "short datetime" format (which may be customized via
     * {@link #setShortDateDisplayFormat(DateDisplayFormat)} or
     * {@link #setShortDateDisplayFormatter(DateDisplayFormatter)} and
     * {@link #setShortDatetimeDisplayFormat(DateDisplayFormat)} or
     * {@link #setShortDatetimeDisplayFormatter(DateDisplayFormatter)} methods.
     * <P>
     * Note that the default date parsing logic already handles all standard short date formats, including
     * those formatted with custom separators. In most cases rather than applying an entirely custom
     * date parser method, desired behavior can be achieved via changing the
     * standard {@link #setDateInputFormat(String) input format}.
     * <P>
     * When writing custom date formatting and parsing logic, developers may find the
     * {@link com.google.gwt.i18n.client.DateTimeFormat} class helpful.
     * <P>
     * Sample code :
     * <pre>
     * DateUtil.setDateParser(new DateParser() {
     *    public Date parse(String dateString) {
     *       final DateTimeFormat format = DateTimeFormat.getFormat("MMM d, yyyy");
     *       Date date = format.parse(dateString);
     *       return date;
     *    }
     * });
     * </pre>
     * <P>
     * Individual components may also override date formatting and parsing functions directly.
     *
     * @param parser
     */
    public static native void setDateParser(DateParser parser) /*-{
        $wnd.Date.setInputFormat(function(dateStr) {
                var dateJ = parser.@com.smartgwt.client.util.DateParser::parse(Ljava/lang/String;)(dateStr);
                if(dateJ == null) return null;
                return @com.smartgwt.client.util.JSOHelper::toDateJS(Ljava/util/Date;)(dateJ);
            }
        );
    }-*/;

    /**
     * Sets up the default system-wide input format for strings being parsed into dates via SmartGWT
     * utilities and components (see {@link #parseInput(String)}). This input format is respected when
     * parsing formatted strings to "date" or "datetime" type values.
     * <P>
     * This method takes a 3 character string like <code>"MDY"</code> indicating the
     * order of the Month, Day and Year components of date strings.
     * <P>
     * As an example - an input format of "MDY" would parse "01/02/1999" to Jan 2nd 1999<br>
     * This standard parsing logic will also handle date-time strings such as "01/02/1999 08:45", or
     * "01/02/1999 16:21:05".
     * <P>
     * Notes:
     * <ul>
     * <li>If this method is never called, the system attempts to automatically determine the standard input
     *     format will be automatically determined based on the specified
     *     {@link #setShortDateDisplayFormat(DateDisplayFormat) short date display format}. For
     *     example if the short display format has been set to "toEuropeanShortDate" the input format will default
     *     to "DMY".</li>
     * <li>The default date parsing functionality built into SmartGWT will handle dates presented
     *     with any separator string, and can 1 or 2 digit day and month values and 2 or 4 digit year values. This
     *     means that in many cases custom date display formats can be parsed back to Date values without the need
     *     for explicit custom formatter functions. However if more sophisticated parsing logic is required an
     *      entirely custom parser function may be applied via {@link #setDateParser()}.</li>
     * <li>Date parsing and formatting logic may be overridden at the component level by setting properties
     *     directly on the component or field in question.</li>
     * </ul>
     *
     * @param inputFormat
     */
    public static native void setDateInputFormat(String inputFormat) /*-{
        $wnd.Date.setInputFormat(inputFormat);
    }-*/;

    /**
     * Converts a RelativeDate shortcut string such as <code>"$today"</code> to a RelativeDateString such as <code>"+0D"</code>
     * @param relativeDateShortcut shortcut string to convert
     * @param position  Are we interested in the start or end of the
     *  specified relative date? This applies to shortcuts which do not specify a specific
     *  moment (such as <code>$today</code>) - it does not apply to shortcuts which
     *  already specify a specific moment such as <code>$startOfToday</code>. If unspecified
     *  rangePosition is always assumed to be "start"
     * @return converted relative date string
     */
    public static native String mapRelativeDateShortcut(String relativeDateShortcut, RelativeDateRangePosition position) /*-{
        if (position != null) position = position.@com.smartgwt.client.types.RelativeDateRangePosition::getValue()();
        return $wnd.isc.DateUtil.mapRelativeDateShortcut(relativeDateShortcut, position);
    }-*/;

    public static String mapRelativeDateShortcut(String relativeDateShortcut) {
        return mapRelativeDateShortcut(relativeDateShortcut, null);
    }

    /**
     *  Converts a RelativeDate to a concrete Date.
     * @return
     */
    public static Date getAbsoluteDate(RelativeDate relativeDate) {
        return getAbsoluteDate(relativeDate, null, null);
    }
    /**
     *  Converts a RelativeDate to a concrete Date.
     * @return
     */
    public static native Date getAbsoluteDate(RelativeDate relativeDate, Date baseDate, RelativeDateRangePosition position) /*-{
        relativeDate = relativeDate.@com.smartgwt.client.data.RelativeDate::getJsObj()();
        if (baseDate != null) {
            baseDate = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptDate(Ljava/util/Date;)(baseDate);
        }
        if (position != null) position = position.@com.smartgwt.client.types.RelativeDateRangePosition::getValue()();

        var jsDate = $wnd.isc.DateUtil.getAbsoluteDate(relativeDate, baseDate, position);
        if (jsDate == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toDate(D)(jsDate.getTime());
    }-*/;

    /**
     * Set up a system wide default normal time formatting function.
     * After calling this method, subsequent calls to <code>isc.Time.toTime()</code> will return
     * a string formatted according to this formatter specification.
     * <b>Note</b>: this will be the standard time format used by SmartGWT components.
     * The initial default normal time display formatter is <code>DateUtil.TOTIME</code>.
     * <P>
     * SmartGWT includes several built-in DateDisplayFormatters for common formats - see
     * {@link DateDisplayFormatter} for details.
     *
     * @param formatter the DateDisplayFormatter
     */
    public static native void setNormalTimeDisplayFormatter(DateDisplayFormatter formatter) /*-{
        var formatterJS = @com.smartgwt.client.util.DateUtil::convertTimeDisplayFormatterToJS(Lcom/smartgwt/client/util/DateDisplayFormatter;)(formatter);
        $wnd.isc.Time.setNormalDisplayFormat(formatterJS);
    }-*/;

    /**
     * Set up a system wide default short time formatting function.
     * After calling this method, subsequent calls to <code>isc.Time.toShortTime()</code> will return
     * a string formatted according to this formatter specification.
     * <b>Note</b>: this will be the standard time format used by SmartGWT components.
     * The initial default normal time display formatter is <code>DateUtil.TOSHORTTIME</code>.
     * <P>
     * SmartGWT includes several built-in DateDisplayFormatters for common formats - see
     * {@link DateDisplayFormatter} for details.
     *
     * @param formatter the DateDisplayFormatter
     */
    public static native void setShortTimeDisplayFormatter(DateDisplayFormatter formatter) /*-{
        var formatterJS = @com.smartgwt.client.util.DateUtil::convertTimeDisplayFormatterToJS(Lcom/smartgwt/client/util/DateDisplayFormatter;)(formatter);
        $wnd.isc.Time.setShortDisplayFormat(formatterJS);
    }-*/;

    /**
     * Combine a logical date (a value appropriate for a DataSourceField of type "date") with a
     * logical time (a value appropriate for a DataSourceField of type "time") into a datetime
     * value (a value appropriate for a DataSourceField of type "datetime")
     * <P>
     * This method correctly takes into account the current display timezone
     * (see {@link #setDefaultDisplayTimezone()}), specifically, the returned datetime
     * value will show the same date and time as the passed date and time objects when rendered by
     * a SmartGWT component that has been configured with a field of type "datetime".
     * <P>
     * For further background on date, time and datetime types, storage
     * {@link com.smartgwt.client.docs.DateFormatAndStorage this overview}.
     * @param date
     * @param time
     * @return
     */
    public static native Date combineLogicalDateAndTime (Date date, Date time) /*-{
        var jsDate = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptDate(Ljava/util/Date;)(date);
        var jsTime = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptDate(Ljava/util/Date;)(time);

        var jsDatetime = $wnd.Date.combineLogicalDateAndTime(jsDate, jsTime);
        if (jsDatetime == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toDate(D)(jsDatetime.getTime());

    }-*/;

/* -- fiscal year support --*/

    /**
     * Get the start date of the fiscal period for the passed year.
     *
     * @return
     */
    public static native Date getFiscalStartDate(Integer year, FiscalCalendar fiscalCalendar) /*-{
        var jsCalendar = null;
        if (fiscalCalendar != null) {
            jsCalendar = fiscalCalendar.@com.smartgwt.client.widgets.FiscalCalendar::getJsObj()();
        }
        var startDate = $wnd.isc.Date.getFiscalStartDate(year, jsCalendar);
        return @com.smartgwt.client.util.JSOHelper::toDate(D)(startDate.getTime());
    }-*/;

    /**
     * Use the GWT LocaleInfo class to auto-detect the various formats for dates and times.
     *
     */
    public static void autoDetectFormats() {
        // rather than using the default US locale, use the GWT defaults for the current locale
        com.google.gwt.i18n.client.DateTimeFormatInfo i = com.google.gwt.i18n.client.LocaleInfo.getCurrentLocale().getDateTimeFormatInfo();

        final String shortDate = i.dateFormatShort();
        final String shortDateTime = shortDate + " " + i.timeFormatShort();
        final String normalDate = shortDate;

        final com.google.gwt.i18n.client.DateTimeFormat shortDateFormat = com.google.gwt.i18n.client.DateTimeFormat.getFormat(shortDate);
        final com.google.gwt.i18n.client.DateTimeFormat shortDateTimeFormat = com.google.gwt.i18n.client.DateTimeFormat.getFormat(shortDateTime);
        final com.google.gwt.i18n.client.DateTimeFormat normalDateFormat = shortDateFormat;

        DateUtil.setShortDateDisplayFormatter(new DateDisplayFormatter() {
            @Override
            public String format(Date date) {
                if (date == null)
                    return null;
                return shortDateFormat.format(date);
            }
        });

        DateUtil.setShortDatetimeDisplayFormatter(new DateDisplayFormatter() {
            @Override
            public String format(Date date) {
                if (date == null)
                    return null;
                return shortDateTimeFormat.format(date);
            }
        });

        DateUtil.setNormalDateDisplayFormatter(new DateDisplayFormatter() {
            @Override
            public String format(Date date) {
                if(date == null)
                    return null;
                return normalDateFormat.format(date);
            }
        });

        // try to guess DMY, MDY or YMD from shortDate ...
        StringBuilder dmy = new StringBuilder();
        for(char c : shortDate.toCharArray()) {
            switch(c) {
                case 'd':
                    if(dmy.indexOf("D") == -1)
                        dmy.append("D");
                    break;
                case 'M':
                    if(dmy.indexOf("M") == -1)
                        dmy.append("M");
                    break;
                case 'y':
                    if(dmy.indexOf("Y") == -1)
                        dmy.append("Y");
                    break;
            }
            if(dmy.length() == 3) {
                DateUtil.setDateInputFormat(dmy.toString());
                break;
            }
        }
    }

}



