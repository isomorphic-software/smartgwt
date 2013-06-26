
package com.smartgwt.client.docs;

/**
 * <h3>Date and Time Format and Storage</h3>
 * The Smart GWT system has the following features for handling Date and Time type values
 *  within DataSources and databound components.
 *  <P>
 *  DataSources and databound components may define fields of type <code>date</code>,
 *  <code>time</code>, or <code>datetime</code>.
 *  <P>
 *  <h3>"date" handling</h3>
 *  <P>
 * Fields of type {@link com.smartgwt.client.types.FieldType date} are considered to be logical
 * Dates with no time
 *  value, such as a holiday or birthday.  In the browser, values for "date" fields are stored
 *  as Date objects, but when formatted for display to the user, they are typically displayed
 *  without any time information.
 *  <P>
 *  When using the Smart GWT server framework, "date" values are automatically transmitted
 *  with year, month and day preserved and time value ignored.
 *  <P>
 *  When sent or received in XML or JSON, date field values should be serialized in the
 * <a target=_blank href="http://www.w3.org/TR/xmlschema-2/#dateTime">XML Schema date format</a> -
 *  <code>YYYY-MM-DD</code> - are expected to be received in the same format.  Any time value
 *  present for a "date" field is ignored.
 *  
 *  
 *  <P>
 *  The DateUtil.createLogicalDate() method may be used to create a new Date object to represent
 *  a logical date value on the browser.
 *  
 *  <P>
 *  System wide formatting for dates may be controlled via the
 * {@link com.smartgwt.client.util.Date#setNormalDisplayFormat Date.setNormalDisplayFormat} and
 * {@link com.smartgwt.client.util.Date#setShortDisplayFormat Date.setShortDisplayFormat} methods.
 *  <P>
 *  <h3>"datetime" handling</h3>
 *  <P>
 * Fields of type {@link com.smartgwt.client.types.FieldType datetime} are dates with full time
 * information.
 *  In the browser, values for datetime fields are stored as Date objects.
 *  <P>
 *  When using the Smart GWT server framework, "datetime" values are automatically transmitted
 *  such that the resulting Date object has the same GMT/UTC timestamp (milliseconds since
 *  epoch).
 *  <P>
 *  When sent or received in XML or JSON, datetime field values should be serialized out as full
 *  datetimes using the standard
 *  <a target=_blank href="http://www.w3.org/TR/xmlschema-2/#dateTime">XML Schema date format</a>
 *  (EG:<code>2006-01-10T12:22:04-04:00</code>).  If no timezone offset is supplied, the value
 *  is assumed to be GMT/UTC.
 *  <P>
 *  System wide formatting for datetimes may be controlled via the
 * {@link com.smartgwt.client.util.Date#setShortDatetimeDisplayFormat
 * Date.setShortDatetimeDisplayFormat} method.  Datetimes will be displayed to the user
 *  in browser local time by default (see also timezone notes below).
 *  <P>
 *  <h3>"time" handling</h3>
 *  <P>
 * Fields of type {@link com.smartgwt.client.types.FieldType time} are time values in the absence
 * of a day, such as
 *  the beginning of the workday (9:00).  In the browser, values for "time" fields are stored as
 *  Date objects with the time in browser local time.  The date information has no meaning and
 *  only the time information is displayed to the user.
 *  <P>
 *  Time formatting is handled by the String class APIs.
 *  <br>
 *  When using the Smart GWT server framework, "time" values are automatically transmitted
 *  such that the resulting Date object has the same hour, minute and second values in local
 *  time, and year/month/day is ignored.
 *  <P>
 *  When sent or received in XML or JSON, date field values should be serialized as hours,
 *  minutes and seconds using the standard
 *  <a target=_blank href="http://www.w3.org/TR/xmlschema-2/#dateTime">XML Schema time
 *  format</a> - <code>"22:01:45"</code>.  Timezone is not relevant and should be omitted.
 *  
 *  
 *  <P>
 *  The DateUtil.createLogicalTime() method may be used to create a new Date object to represent
 *  a logical time value on the browser.
 *  
 *  <P>
 *  <h3>Timezone settings and Daylight Savings Time</h3>
 *  <P>
 *  By default, "datetime" values will be shown to the user in browser local time, as derived
 *  from the native browser locale.  Developers may modify this behavior by specifying an
 *  explicit display timezone via String.
 *  <P>
 *  Note that depending on the specific date being displayed, a Daylight Savings Time offset may
 *  also be applied based on the browser locale.  To disable this behavior set
 *  String to false.
 *  <P>
 * If a custom timezone is specified, it will be respected by all {@link
 * com.smartgwt.client.types.TimeDisplayFormat}s, and
 * by the standard short {@link com.smartgwt.client.types.DateDisplayFormat}s when formatting
 * dates representing datetime
 *  type values. However native JavaScript Date formatters,
 *  including <code>toLocaleString()</code> will not respect the specified timezone. Developers
 * specifying a custom timezone may therefore wish to modify the {@link
 * com.smartgwt.client.util.Date#setNormalDisplayFormat Date.setNormalDisplayFormat}
 *  to avoid using a native JS Date formatter function.
 *  <P>
 *  Note that in addition to the system-wide date, datetime and time-formatting settings described
 *  above, databound components also support applying custom display formats for date values.
 *  Typically this can be achieved via a custom <code>dateFormatter</code> or
 * <code>timeFormatter</code> at the field level (see {@link
 * com.smartgwt.client.data.DataSourceField#getDateFormatter dateFormatter},
 * {@link com.smartgwt.client.data.DataSourceField#getTimeFormatter timeFormatter} and for example
 * {@link com.smartgwt.client.widgets.grid.ListGridField#getDateFormatter dateFormatter}).
 *  Date formatting may also be configured at the component level by setting the
 *  <code>dateFormatter</code>, <code>datetimeFormatter</code> and <code>timeFormatter</code>
 * attributes (See for example {@link com.smartgwt.client.widgets.grid.ListGrid#getDateFormatter
 * dateFormatter}, {@link com.smartgwt.client.widgets.grid.ListGrid#getTimeFormatter
 * timeFormatter},
 *  and {@link com.smartgwt.client.widgets.grid.ListGrid#getDatetimeFormatter datetimeFormatter}).
 *  <P>
 *  <h3>Troubleshooting Date and Time values</h3>
 *  <P>
 *  Date and time storage and timezones can be confusing, and Isomorphic receives a steady
 *  stream of false bug reports from users that are incorrectly analyzing logs and diagnostics.
 *  Please consider the following points when troubleshooting issues such as date values
 *  changing to a different day, or datetime value shifting when saved and reloaded:
 *  <P>
 *  <h4>1. compare values for "datetime" fields via date.getTime()</h4>
 *  <P>
 *  Whenever you use Date.toString() (client or server-side) the value you get is based on the
 *  server or browser timezone.
 *  <P>
 *  Perhaps you are troubleshooting an issue with datetimes and you try to log the value of a
 *  Date like this:
 *  <pre>
 *     Date someDate = &lt;<i>some expression</i>&gt;;
 *     log("date value is: " + someDate);
 *  </pre>
 *  Code like this will show the datetime value in the server's timezone if executed
 *  server-side, and in the client's timezone if executed client-side.  If they are in different
 *  timezones, the hour or day will be different, <b>whereas the actual datetime value -
 *  milliseconds since epoch as retrieved by Date.getTime() - is the same</b>.  To correctly
 *  compare two datetime values, compare the result of getTime().
 *  <P>
 *  <h4>2. "date" and "time" field values <b>cannot</b> be compared via getTime()</h4>
 *  <P>
 *  This is the inverse situation as for "datetime" values.  As explained above, "date" values
 *  have no meaningful values for time fields (hours/minutes/seconds) and "time" values have no
 *  meaningful values for date fields (month/day/year).  Here, the result of Date.getTime() is
 *  not meaningful, and values should be compared via getHours(), getMonth() et al.
 *  <P>
 *  <h4>3. the display timezone does not affect Date.getHours(), Date.getDay() et al</h4>
 *  <P>
 *  If you've called setDefaultDisplayTimezone() to cause all datetime values to be rendered in
 *  a particular timezone, this does not affect the return values of Date.getHours(), which will
 *  still return values for the browser's current timezone.  Hence it is not a bug if you have a
 *  "datetime" value which is displaying as 4am, but getHours() returns 10 or some other
 *  number.  This just reflects the timezone offset between the timezone passed to
 *  setDefaultDisplayTimezone() and the browser's local timezone.
 *  <P>
 *  <h4>4. use correct DataSourceField types and use the matching FormItem type</h4>
 *  <P>
 *  If you declare a field as type "date" but values you provide actually contain specific
 *  hours, minutes and seconds, these will not be preserved.  The system will discard or reset
 *  the hours, minutes and seconds in the course of serialization or editing.  Likewise
 *  if you declare a field as type "time" but actually provide values where year, month and day
 *  have meaning, these values will be dropped.
 *  <P>
 *  Similarly, DateItem expects values for "date" fields, TimeItem expects values for "time"
 *  fields, and DateTimeItem expects values for "datetime" fields.  Providing the wrong type of
 *  value to a control, such as providing a value from a "datetime" field to a DateItem, will
 *  have unspecified results.
 *  <P>
 *  
 *  
 *  If you want to take the date and time aspects of a "datetime" value and edit them in separate
 *  FormItems, use
 *  <code>getLogicalDateOnly()</code> and <code>DateUtil.getLogicalTimeOnly()</code> to
 *  split a datetime value into date and time values, and use
 *  <code>DateUtil.combineLogicalDateAndTime()</code> to re-combine
 *  such values. Otherwise it is very
 *  easy to make mistakes related to timezone offsets.
 *  
 *  <P>
 *  <h4>5. check data at every phase when troubleshooting</h4>
 *  <P>
 *  If you're having a problem with round-tripping "datetime" values or "date" values shifting
 *  to another day, you need to isolate the problem to a specific layer.  Bearing in mind the
 *  techniques above for comparing values, you potentially need to look at any/all of the
 *  following:
 *  <ol>
 *  <li> what value do I have on the server-side before it's sent to the client?
 *  <li> what value is being transmitted to the client? (use the RPC Tab of the Developer
 *  Console to see the actual data sent)
 *  <ul>
 *  <li> was the value shifted to a different time/date by my serialization approach?
 *  <li> does it have the right format? (see above for correct JSON/XML formats)
 *  </ul>
 *  <li> what value do I have on the client before it gets to any widgets (eg, do a direct call
 * to {@link com.smartgwt.client.data.DataSource#fetchData DataSource.fetchData} and inspect the
 * data in the callback)
 *  <li> what value does the FormItem or other editing widget report before saving is attempted?
 *  <li> what value is reported right before the value is serialized for transmission to the
 * server ({@link com.smartgwt.client.data.DataSource#transformRequest
 * DataSource.transformRequest} is a good place to check)
 *  <li> what value is being transmitted to the server? (use the RPC tab - same concerns as for
 *  server-to-client transmission above)
 *  <li> what value does the server have after de-serialization, before saving to the database
 *  or other permanent storage?
 *  <li> what value is sent to the database or permanent storage?  If generating SQL or another
 *  similar query language, does the value in the SQL statement include an explicit timezone?
 *  If not, how will the database interpret it?
 *  </ol>
 */
public interface DateFormatAndStorage {
}
