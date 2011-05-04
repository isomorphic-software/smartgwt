package com.smartgwt.client.util;

import java.util.Date;

import com.smartgwt.client.data.RelativeDate;
import com.smartgwt.client.types.DateDisplayFormat;
import com.smartgwt.client.types.RelativeDateRangePosition;

/**
 * Date related utility methods.
 */
public class DateUtil {

    /**
     * Globally sets the offset from UTC to use when formatting values of type datetime and time with standard display formatters.
     *
     * If this method is never called, the default display timezone for times and datetimes will be derived from the native
     * browser local timezone.
     * <p>
     * Note that by default daylight savings time adjustments (based on browser locale) may also be applied when formatting times
     * and datetimes. {@link #setAdjustForDST(boolean)} may be used to disable this adjustment.
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
     * Set the default formatter for date objects to the method name passed in. After calling this method, subsequent calls to Date.toNormalDate will return a string formatted according to this format specification.
     * <br>
     * <b>Note</b>: this will be the standard long date format used by SmartGWT components.
     * Initial default normalDisplayFormat is "toLocaleString"
     *
     * @param format the DateDisplayFormat
     */
    public static native void setNormalDateDisplayFormat(DateDisplayFormat format) /*-{
        $wnd.Date.setNormalDisplayFormat(format.@com.smartgwt.client.types.DateDisplayFormat::getValue()());
    }-*/;

    /**
     * Set the default formatter for date objects to the method name passed in. After calling this method, subsequent calls to Date.toNormalDate will return a string formatted according to this format specification.
     * <br>
     * <b>Note</b>: this will be the standard long date format used by SmartGWT components.
     * The DateDisplayFormatter function will be executed in the scope of the Date and should return the formatted string.
     * <p/>
     * Initial default normalDisplayFormat is "toLocaleString"
     *
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
        $wnd.Date.setNormalDisplayFormat(function() {
                var date = this;
                var dateJ = date == null || date === undefined ? null : @com.smartgwt.client.util.JSOHelper::toDate(D)(date.getTime());
                return formatter.@com.smartgwt.client.util.DateDisplayFormatter::format(Ljava/util/Date;)(dateJ);
            }
        );
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
     * Note that the default short date format is initially set to "toUSShortDate".
     *
     * @param format the DateDisplayFormat
     */    
    public static native void setShortDateDisplayFormat(DateDisplayFormat format) /*-{
        $wnd.Date.setShortDisplayFormat(format.@com.smartgwt.client.types.DateDisplayFormat::getValue()());
    }-*/;


    /**
     * Set up a system wide default short date formatting function.
     * The formatter passed in will be used by default by SmartGwt components when formatting date values
     * to short date format (and by {@link #formatAsShortDate(Date)}).
     * <P>
     * Note that {@link DateUtil#setShortDateDisplayFormat(DateDisplayFormat)} 
     * and {@link DateUtil#setDefaultDateSeparator(String)} already provide support for most standard "short date"
     * formats without the need for a custom formatter.
     * <P>
     * If a custom short date formatter is applied, bear in mind that it will be applied by default when
     * editing date values, so the system will need to be able to parse an edited date string in this format
     * back to a live date object. Developers calling this method will therefore also commonly want to
     * apply custom parsing logic via {@link #setDateInputFormat(String)} or {@link #setDateParser(DateParser)}.
     * <P>
     * When writing custom date formatting and parsing logic, developers may find the 
     * {@link com.google.gwt.i18n.client.DateTimeFormat} class helpful.
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
        $wnd.Date.setShortDisplayFormat(function() {
                var date = this;
                var dateJ = date == null || date === undefined ? null : @com.smartgwt.client.util.JSOHelper::toDate(D)(date.getTime());
                return formatter.@com.smartgwt.client.util.DateDisplayFormatter::format(Ljava/util/Date;)(dateJ);
            }
        );
    }-*/;
    
    /**
     * Set the system wide default short datetime format.
     * The specified format will be used by default by SmartGwt components when formatting datetime field values to 
     * short datetime format (and by {@link #formatAsShortDateTime(Date)}).
     * <P>
     * This method, together with {@link DateUtil#setDefaultDateSeparator(String)} provide support for most
     * standard "short date" formats. However if a custom format which doesn't match any of the specified
     * {@link DateDisplayFormat} types is required, a custom formatting function may be provided via
     * {@link #setShortDatetimeDisplayFormatter(DateDisplayFormatter)}.
     * <P>
     * Note that the default short datetime format is initially set to "toUSShortDateTime".
     *
     * @param format the DateDisplayFormat
     */    
    public static native void setShortDatetimeDisplayFormat(DateDisplayFormat format) /*-{
        $wnd.Date.setShortDatetimeDisplayFormat(format.@com.smartgwt.client.types.DateDisplayFormat::getValue()());
    }-*/;


    /**
     * Set up a system wide default short datetime formatting function.
     * The formatter passed in will be used by default by SmartGwt components when formatting date values
     * to short datetime format (and by {@link #formatAsShortDatetime(Date)}).
     * <P>
     * Note that {@link DateUtil#setShortDatetimeDisplayFormat(DateDisplayFormat)} 
     * and {@link DateUtil#setDefaultDateSeparator(String)} already provide support for most standard "short date"
     * formats without the need for a custom formatter.
     * <P>
     * If a custom short datetime formatter is applied, bear in mind that it will be applied by default when
     * editing date values, so the system will need to be able to parse an edited date string in this format
     * back to a live date object. Developers calling this method will therefore also commonly want to
     * apply custom parsing logic via {@link #setDateInputFormat(String)} or {@link #setDateParser(DateParser)}.
     * <P>
     * When writing custom date formatting and parsing logic, developers may find the 
     * {@link com.google.gwt.i18n.client.DateTimeFormat} class helpful.
     *
     * @param formatter the DateDisplayFormatter
     */
    public static native void setShortDatetimeDisplayFormatter(DateDisplayFormatter formatter) /*-{
        $wnd.Date.setShortDatetimeDisplayFormat(function() {
                var date = this;
                var dateJ = date == null || date === undefined ? null : @com.smartgwt.client.util.JSOHelper::toDate(D)(date.getTime());
                return formatter.@com.smartgwt.client.util.DateDisplayFormatter::format(Ljava/util/Date;)(dateJ);
            }
        );
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
     * Sets up the a custom parsing function to use by default when converting dates or datetimes from 
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
}
