
package com.smartgwt.client.docs;

/**
 * <h3>Date and Time Format and Storage</h3>
 * The Smart GWT system has the following features for handling Date and Time type values within DataSources and databound
 * components. <P> DataSources and databound components may define fields of type <code>date</code>, <code>time</code>, or
 * <code>datetime</code>. <P> Fields of type {@link com.smartgwt.client.types.FieldType date} are considered to be logical
 * Dates. System wide formatting for dates may be controlled via the  Date.setNormalDisplayFormat and 
 * Date.setShortDisplayFormat methods.  Components also support applying custom display formats for specific date fields,
 * typically achieved via the <code>dateFormatter</code> or <code>field.displayFormat</code> attributes. <P> On the client
 * date type fields are stored as JavaScript Date objects. When formatted for display to the user, they are typically
 * displayed without any time information. <P> When communicating with a non Smart GWT server via an "xml" DataSource, date
 * field values in requests will be serialized out as logical date information only (omitting time) in the standard
 * truncated <a target=_blank href="http://www.w3.org/TR/xmlschema-2/#dateTime">XML Schema date format</a> -
 * <code>YYYY-MM-DD</code>. Date values received from the server in responses are expected to be in the same format, though
 * if time information is included in the returned date-string it will be understood.  This matches the default date
 * serialization behavior for "json" dataSources, though dates may also be communicated as a JavaScript date instantiation
 * string  (EG: <code>new Date(1238792738633)</code>). See {@link com.smartgwt.client.util.JSONEncoder#getDateFormat
 * dateFormat}. <P> Fields of type {@link com.smartgwt.client.types.FieldType datetime} are dates with full time
 * information. System wide formatting for datetimes may be controlled via the  Date.setShortDatetimeDisplayFormat method,
 * or at a component level by <code>datetimeFormatter</code> or <code>field.displayFormat</code> attributes. DateTimes
 * willbe displayed to the user in local time as set up via  {@link java.lang.String#setDefaultDisplayTimezone
 * Time.setDefaultDisplayTimezone}. Note that if not explicitly set, this will default to the browser native timezone. <P>
 * On the client datetime type fields are stored as JavaScript Date objects.  When communicating with a non Smart GWT
 * server via an "xml" DataSource, datetime field values in requests will be serialized out as full datetimes in UTC using
 * the standard <a target=_blank href="http://www.w3.org/TR/xmlschema-2/#dateTime">XML Schema date format</a> -
 * <code>YYYY-MM-DDTHH:MM:SS</code>. Date values received from the server in responses are expected to also be in XML
 * Schema date format - and assumed to be in UTC time unless an explicit timezone offset is specified on the datetime
 * string (EG:<code>2006-01-10T12:22:04-04:00</code>). As with dates, "json" format dataSources use the same XML Schema
 * format by default but may use JavaScript date instantiation strings instead. <P> Fields of type {@link
 * com.smartgwt.client.types.FieldType time} are logical time values. These are stored on the client as JavaScript date
 * objects, but only the time information is displayed to the user. Time formatting is handled by the {@link
 * java.lang.String} class APIs. By default times are displayed to users in the display timezone set up via {@link
 * java.lang.String#setDefaultDisplayTimezone Time.setDefaultDisplayTimezone} [if not explicitly set, defaults to native
 * browser local time].<br> When communicating with a non Smart GWT server via an "xml" DataSource, time field values in
 * requests will be serialized out as full times in UTC using the standard <a target=_blank
 * href="http://www.w3.org/TR/xmlschema-2/#dateTime">XML Schema date / time format</a> - <code>HH:MM:SS</code>. Note that
 * the flag {@link com.smartgwt.client.data.DataSource#serializeTimeAsDatetime serializeTimeAsDatetime} may be set to
 * serialize all times as full datetimes rather than just time strings. Time values received from the server in responses
 * are expected to be in the same format, in UTC, or with an explicit timezone offset specified (for example
 * <code>"22:01:45-01:00"</code>) <P> When communicating with the Smart GWT server fields of type <code>date</code>,
 * <code>datetime</code> and <code>time</code> are all automatically translated to Java date objects on the server side.
 */
public interface DateFormatAndStorage {
}
