package com.smartgwt.client.util;

import com.smartgwt.client.types.DateDisplayFormat;

/**
 * Date related utility methods.
 */
public class DateUtil {

    /**
     * Globally sets the offset from UTC to use when formatting values of type datetime and time with standard display formatters.
     *
     * If this method is never called, the default display timezone for times and datetimes will be derived from the native
     * browser local timezone.
     *
     * @param offset offset from UTC. This should be a string in the format <code>+/-HH:MM</code> for example <code>"-08:00"
     */
    public static native void setDefaultDisplayTimezone(String offset) /*-{
        $wnd.isc.Time.setDefaultDisplayTimezone(offset);
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
     * Set the default formatter for date objects to the method name passed in. After calling this method, subsequent calls to Date.toShortDate will return a string formatted according to this format specification.
     * <br>
     * <b>Note</b>: this will be the standard long date format used by SmartGWT components.
     * Initial default normalDisplayFormat is "toUSShortDate"
     *
     * @param format the DateDisplayFormat
     */    
    public static native void setShortDateDisplayFormat(DateDisplayFormat format) /*-{
        $wnd.Date.setShortDisplayFormat(format.@com.smartgwt.client.types.DateDisplayFormat::getValue()());
    }-*/;


    /**
     * Set the default formatter for date objects to the method name passed in. After calling this method, subsequent calls to Date.toShortDate will return a string formatted according to this format specification.
     * <br>
     * <b>Note</b>: this will be the standard long date format used by SmartGWT components.
     * The DateDisplayFormatter function will be executed in the scope of the Date and should return the formatted string.
     * <p/>
     * Initial default normalDisplayFormat is "toUSShortDate"
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
     * Sets up the default format for strings being parsed into dates via Date.parseInput
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
     */
    public static native void setDateInputFormatter(DateInputFormatter formatter) /*-{
        $wnd.Date.setInputFormat(function(dateStr) {
                var dateJ = formatter.@com.smartgwt.client.util.DateInputFormatter::parse(Ljava/lang/String;)(dateStr);
                if(dateJ == null) return null;
                return @com.smartgwt.client.util.JSOHelper::toDateJS(Ljava/util/Date;)(dateJ);
            }
        );
    }-*/;
}
