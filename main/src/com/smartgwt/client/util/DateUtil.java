package com.smartgwt.client.util;

import java.util.Date;

import com.google.gwt.core.client.JavaScriptObject;
import com.smartgwt.client.data.RelativeDate;
import com.smartgwt.client.types.DateDisplayFormat;
import com.smartgwt.client.types.RelativeDateRangePosition;
import com.smartgwt.client.widgets.FiscalCalendar;
import com.smartgwt.client.widgets.FiscalYear;


/**
 * Date related utility methods.
 */
public class DateUtil {

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
     * @param offset offset from UTC. This should be a string in the format <code>+/-HH:MM</code> for example <code>"-08:00"
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
     * is commonly modified for localization of applications. See {@link http://en.wikipedia.org/wiki/Date_format_by_country}
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
     * This property is commonly modified for localization of applications. See {@link http://en.wikipedia.org/wiki/Date_format_by_country}
     * for a useful overview of standard date formats per country.
     *
     * @param format the DateDisplayFormat
     * @deprecated This method is deprecated in favor of {@link setShortDatetimeDisplayFormatter(DateDisplayFormatter)}.
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

    // Wrappers for the standard Date format / parser functions applied to the Date class in SC.
    // Note that GWT has date parsing and formatting functions via Java util classes - just exposing these
    // for completeness as they're the standards used by components by default
    
    /**
     * Parse a formatted date string into a Date object.
     * <P>
     * This calls the default parsing function used by SmartGWT components.
     * <P>
     * If {@link #setDateInputFormat(String)} or {@link #setDateParser(DateParser)} 
     * has been specified it will be respected.
     * 
     * @param dateString string to parse into a Date
     * @return date value from the string (or null if the string passed in could not be converted to a date).
     */
    public static native Date parseInput(String dateString) /*-{
        var jsDate = $wnd.Date.parseInput(dateString);
        if (jsDate == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toDate(D)(jsDate.getTime());
        
    }-*/; 

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
     * standard {@link #setDateInputFormat(String),input format}.
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
     *     {@link #setShortDateDisplayFormat(DateDisplayFormat),short date display format}. For 
     *     example if the short display format has been set to "toEuropeanShortDate" the input format will default
     *     to "DMY".</li>
     * <li>The default date parsing functionality built into SmartGWT will handle dates presented
     *     with any separator string, and can 1 or 2 digit day and month values and 2 or 4 digit year values. This
     *     means that in many cases custom date display formats can be parsed back to Date values without the need
     *     for explicit custom formatter functions. However if more sophisticated parsing logic is required an
     *      entirely custom parser function may be applied via {@link setDateParser()}.</li>
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
    //  specified relative date? This applies to shortcuts which do not specify a specific
    //  moment (such as <code>$today</code>) - it does not apply to shortcuts which 
    //  already specify a specific moment such as <code>$startOfToday</code>. If unspecified 
    //  rangePosition is always assumed to be "start"
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
     * Get a logical date - a value appropriate for a DataSourceField of type "date" - from a
     * datetime value (a value from a DataSourceField of type "datetime").
     * <P>
     * This method correctly takes into account the current display timezone
     * (see {@link setDefaultDisplayTimezone()}),, specifically, the returned Date
     * will reflect the day, month and year that appears when the datetime is rendered
     * by a SmartGWT component rather than the date values that would be returned by
     * Date.getDay() et al (which can differ, since getDay() uses the browser's local timezone).
     * <P>
     * For further background on date, time and datetime types, storage and transmission, see
     * {@link com.smartgwt.client.docs.DateFormatAndStorage, this overview}.
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
     * Get a logical time - a value appropriate for a DataSourceField of type "time" - from a
     * datetime value (a value from a DataSourceField of type "datetime").
     * <P>
     * This method correctly takes into account the current display timezone
     * (see {@link setDefaultDisplayTimezone()}),
     * specifically, the returned Date will
     * reflect the hour, minute and second that appears when the datetime
     * is rendered by a SmartGWT component rather than the time values that would be returned by
     * Date.getHours() et al (which can differ, since getHours() uses the browser's local timezone).
     * <P>
     * For further background on date, time and datetime types, storage and transmission, see the
     * {@link com.smartgwt.client.docs.DateFormatAndStorage, this overview}.
     */
    public static native LogicalTime getLogicalTimeOnly(Date date) /*-{
        var jsD = $wnd.isc.Date.getLogicalTimeOnly(@com.smartgwt.client.util.JSOHelper::convertToJavaScriptDate(Ljava/util/Date;)(date));
        if (jsD == null || jsD === undefined) {
            return null;
        } else {
            return @com.smartgwt.client.util.LogicalTime::new(D)(jsD.getTime());
        }
    }-*/;

    /**
     * Combine a logical date (a value appropriate for a DataSourceField of type "date") with a
     * logical time (a value appropriate for a DataSourceField of type "time") into a datetime
     * value (a value appropriate for a DataSourceField of type "datetime")
     * <P>
     * This method correctly takes into account the current display timezone
     * (see {@link setDefaultDisplayTimezone()}), specifically, the returned datetime
     * value will show the same date and time as the passed date and time objects when rendered by
     * a SmartGWT component that has been configured with a field of type "datetime".
     * <P>
     * For further background on date, time and datetime types, storage
     * {@link com.smartgwt.client.docs.DateFormatAndStorage, this overview}.
     * @param date
     * @param time
     * @return
     */
    public static native Date combineLogicalDateAndTime(Date date, Date time) /*-{
        var jsDate = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptDate(Ljava/util/Date;)(date);
        var jsTime = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptDate(Ljava/util/Date;)(time);

        var jsDatetime = $wnd.Date.combineLogicalDateAndTime(jsDate, jsTime);
        if (jsDatetime == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toDate(D)(jsDatetime.getTime());
    }-*/;


/* -- fiscal year support --*/

    /**
     * Set the system wide {@link com.cmartget.client.widgets.FiscalCalendar} for use when working with Dates.
     *
     * @param fiscalCalendar the FiscalCalendar
     */
    public static native void setFiscalCalendar(FiscalCalendar fiscalCalendar) /*-{
        var jsCalendar = fiscalCalendar.@com.smartgwt.client.widgets.FiscalCalendar::getJsObj()();
        $wnd.isc.Date.setFiscalCalendar(jsCalendar);
    }-*/;

    /**
     * Get the system wide {@link com.cmartget.client.widgets.FiscalCalendar}.
     *
     * @return
     */
    public static native FiscalCalendar getFiscalCalendar() /*-{
        var jsCalendar = $wnd.isc.Date.getFiscalCalendar();
        return @com.smartgwt.client.widgets.FiscalCalendar::new(Lcom/google/gwt/core/client/JavaScriptObject;)(jsCalendar);
    }-*/;

    /**
     * Get the start date of the fiscal period in which the passed date exists.
     *
     * @return
     */
    public static native Date getFiscalStartDate(Date date, FiscalCalendar fiscalCalendar) /*-{
        var jsDate = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptDate(Ljava/util/Date;)(date);
        var jsCalendar = null;
        if (fiscalCalendar != null) {
            jsCalendar = fiscalCalendar.@com.smartgwt.client.widgets.FiscalCalendar::getJsObj()();
        }
        var startDate = $wnd.isc.Date.getFiscalStartDate(jsDate, jsCalendar);
        return @com.smartgwt.client.util.JSOHelper::toDate(D)(startDate.getTime());
    }-*/;
    
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
     * Get the fiscal year object in which the passed date exists.
     *
     * @return
     */
    public static native FiscalYear getFiscalYear(Date date, FiscalCalendar fiscalCalendar) /*-{
        var jsDate = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptDate(Ljava/util/Date;)(date);
        var jsCalendar = null;
        if (fiscalCalendar != null) {
            jsCalendar = fiscalCalendar.@com.smartgwt.client.widgets.FiscalCalendar::getJsObj()();
        }
        var jsFiscalYear = $wnd.isc.Date.getFiscalYear(jsDate, jsCalendar);
        return @com.smartgwt.client.widgets.FiscalYear::new(Lcom/google/gwt/core/client/JavaScriptObject;)(jsFiscalYear);
    }-*/;

    /**
     * Get the fiscal year object for the passed year.
     *
     * @return
     */
    public static native FiscalYear getFiscalYear(Integer year, FiscalCalendar fiscalCalendar) /*-{
        var jsCalendar = null;
        if (fiscalCalendar != null) {
            jsCalendar = fiscalCalendar.@com.smartgwt.client.widgets.FiscalCalendar::getJsObj()();
        }
        var jsFiscalYear = $wnd.isc.Date.getFiscalYear(year, jsCalendar);
        return @com.smartgwt.client.widgets.FiscalYear::new(Lcom/google/gwt/core/client/JavaScriptObject;)(jsFiscalYear);
    }-*/;

    /**
     * Get the fiscal week in the period in which the passed date exists.
     *
     * @return
     */
    public static native Integer getFiscalWeek(Date date, FiscalCalendar fiscalCalendar) /*-{
        var jsDate = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptDate(Ljava/util/Date;)(date);
        var jsCalendar = null;
        if (fiscalCalendar != null) {
            jsCalendar = fiscalCalendar.@com.smartgwt.client.widgets.FiscalCalendar::getJsObj()();
        }
        return $wnd.isc.Date.getFiscalWeek(jsDate, jsCalendar);
    }-*/;
    
    /**
     * Should the Fiscal Year picker be displayed by default in all DateChoosers?
     *
     */
    public static native void setShowChooserFiscalYearPickers (boolean showFiscalYearPickers) /*-{
        $wnd.isc.Date.setShowChooserFiscalYearPickers(showFiscalYearPickers);
    }-*/;
    
    /**
     * Should the Week picker be displayed by default in all DateChoosers?
     *
     */
    public static native void setShowChooserWeekPickers (boolean showWeekPickers) /*-{
        $wnd.isc.Date.setShowChooserWeekPickers(showWeekPickers);
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
        if(ret == null || ret === undefined) return null;
        return @com.smartgwt.client.util.ConvertTo::arrayOfInteger(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

	/**
     * Sets the days that are considered {@link com.smartgwt.client.util.Date#weekendDays weekend days}.  The parameter  should
     * be array of the integers returned by the JavaScript built-in Date.getDay(), eg, 0 is  Sunday and 6 is Saturday. 
     * Override to accommodate different workweeks such as Saudi Arabia  (Saturday -> Wednesday) or Israel (Sunday ->
     * Thursday).
     * @param weekendDays the array of day-numbers to assign as weekend days
     */
    public static native void setWeekendDays(Integer[] weekendDays) /*-{
        $wnd.isc.Date.setWeekendDays(weekendDays);
    }-*/;

}
