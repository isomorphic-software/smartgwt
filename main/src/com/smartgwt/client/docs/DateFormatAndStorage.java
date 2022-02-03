
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
 * <a href='http://www.w3.org/TR/xmlschema-2/#dateTime' target='_blank'>XML Schema date format</a>
 * - 
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
 * {@link com.smartgwt.client.util.DateUtil#setNormalDisplayFormat
 * DateUtil.setNormalDisplayFormat()} and {@link
 * com.smartgwt.client.util.DateUtil#setShortDisplayFormat DateUtil.setShortDisplayFormat()}
 * methods.
 *  <P>
 *  <h3>"datetime" handling</h3>
 *  <P>
 * Fields of type {@link com.smartgwt.client.types.FieldType datetime} are dates with full time
 * information.
 *  In the browser, values for datetime fields are stored as Date objects.
 *  <P>
 *  When using the Smart GWT server framework, "datetime" values are automatically transmitted
 *  such that the resulting Date object has the same GMT/UTC timestamp.  This value is referred
 *  to elsewhere in these discussions as an "epoch value", and it is precisely defined as: the 
 *  number of milliseconds since midnight on January 1st 1970 in the UTC timezone
 *  (because 1970-01-01 00:00:00 UTC is "the epoch").
 *  <P>
 *  When sent or received in XML or JSON, datetime field values should be serialized out as full
 *  datetimes using the standard
 * <a href='http://www.w3.org/TR/xmlschema-2/#dateTime' target='_blank'>XML Schema datetime
 * format</a>
 *  (EG:<code>2006-01-10T12:22:04-04:00</code>).  If no timezone offset is supplied, the value
 *  is assumed to be GMT/UTC.
 *  <P>
 *  System wide formatting for datetimes may be controlled via the
 * {@link com.smartgwt.client.util.DateUtil#setShortDatetimeDisplayFormat
 * DateUtil.setShortDatetimeDisplayFormat()} method.  Datetimes will be displayed to the
 *  user in browser local time by default (see also timezone notes below).
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
 * <a href='http://www.w3.org/TR/xmlschema-2/#dateTime' target='_blank'>XML Schema time format</a>
 * -
 *  <code>"22:01:45"</code>.  Timezone is not relevant and should be omitted.
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
 *  specifying a custom timezone may therefore wish to modify the 
 * {@link com.smartgwt.client.util.DateUtil#setNormalDisplayFormat
 * DateUtil.setNormalDisplayFormat()} to avoid using a native JS Date formatter function.
 *  <P>
 *  Note that in addition to the system-wide date, datetime and time-formatting settings described
 *  above, databound components also support applying custom display formats for date values.
 *  Typically this can be achieved via a custom <code>dateFormatter</code> or
 * <code>timeFormatter</code> at the field level (see {@link
 * com.smartgwt.client.data.DataSourceField#getDateFormatter DataSourceField.dateFormatter},
 * {@link com.smartgwt.client.data.DataSourceField#getTimeFormatter DataSourceField.timeFormatter}
 * and for example {@link com.smartgwt.client.widgets.grid.ListGridField#getDateFormatter
 * ListGridField.dateFormatter}).
 *  Date formatting may also be configured at the component level by setting the
 *  <code>dateFormatter</code>, <code>datetimeFormatter</code> and <code>timeFormatter</code>
 * attributes (See for example {@link com.smartgwt.client.widgets.grid.ListGrid#getDateFormatter
 * ListGrid.dateFormatter}, {@link com.smartgwt.client.widgets.grid.ListGrid#getTimeFormatter
 * ListGrid.timeFormatter},
 * and {@link com.smartgwt.client.widgets.grid.ListGrid#getDatetimeFormatter
 * ListGrid.datetimeFormatter}).
 *  <P>
 *  <h3>Database storage of datetime values by Smart GWT Server</h3>
 *  <P>
 *  Support for timezones and datetime values varies across the database vendors.  There is
 *  a standard approach proposed by the SQL:1999 standard, but as is often the case with SQL 
 *  standards, support is far from universal and there are many idiosyncrasies.  This leads 
 *  to a situation where different databases offer different ways for an internationalized 
 *  application to store datetimes, and some offer facilities that others lack.  For example,
 *  PostgreSQL supports the SQL:1999 standard TIMESTAMP WITH TIME ZONE syntax; MySQL allows 
 *  you to achieve the same end by providing proprietary methods to set a timezone globally 
 *  or per-connection; Informix has no explicit timezone support at all.  For these 
 *  reasons, Smart GWT Server implements framework-level support for difficult datetime 
 *  issues like timezones and Daylight Saving Time, and does not rely on any native database
 *  features.
 *  <P>
 *  <h4>Database storage of datetimes in a nutshell</h4>
 *  <ol>
 *  <li>Smart GWT stores datetime values by formatting them as a string, and retrieves them 
 *  by asking the database to format as a string.  Smart GWT uses the same timezone for 
 *  formatting and for reading from the database, avoiding any shift in the datetime value from
 *  storing and retrieving the date.
 *  <li>Smart GWT is unaware of the actual timezone used by the database, and does not specify
 *  a timezone when storing or retrieving values.  Depending on your database settings, your 
 *  database may be interpreting the datetime strings stored by Smart GWT as server local time,
 *  UTC, or another timezone.  Thus, if you use JDBC directly or a SQL querying tool to read 
 *  datetime values from your database, the value you get may be different from what is 
 *  retrieved via Smart GWT.  If it's important to make these values match, you can configure
 *  Smart GWT and your database to read and write using the same timezone - see the more 
 *  detailed discussion below</li>
 *  </ol>
 *  <P>
 *  <h4>Database storage of datetimes in detail</h4>
 *  Every database supported by Smart GWT handles datetimes as human-readable strings of text 
 *  like '2012-05-13 16:48:20' (in terms of the SQL interface, that is - doubtless many of them 
 *  implement datetimes internally as epoch values).  Of course this is perfectly reasonable, 
 *  but viewed globally it is also vague unless you specify a timezone, and support for doing 
 *  that varies across the database vendors as described above.  If you are using the SQL storage
 *  engine built in to Smart GWT Server (Pro or better only), uniform support for the storage 
 *  of datetime values in database tables is provided at the framework level.
 *  <p>
 *  As previously discussed, datetime values are transmitted between client and server by 
 *  encoding and decoding in UTC, ensuring that there is no shift in the datetime value.  If the
 *  browser and server are in different timezones, Date.toString() on the server will show a 
 *  different date and time than you see in the browser, but the underlying datetime value is 
 *  the same.
 *  <P>
 *  Then, for storing to a database, Smart GWT's storage behavior is governed by the 
 *  <code>server.properties</code> flag <code>sql.{database-name}.useUTCDateTimes</code>. For 
 *  example:<pre>
 *      sql.defaultDatabase: AppDatabase
 *      sql.AppDatabase.database.type: mysql
 *      sql.AppDatabase.driver: com.mysql.jdbc.jdbc2.optional.MysqlDataSource
 *      <b>sql.AppDatabase.useUTCDateTimes: true</b>
 *      etc
 *  </pre>
 *  If the <code>useUTCDateTimes</code> flag is set, Smart GWT generates SQL that renders 
 *  datetimes as UTC values; otherwise it generates SQL that renders datetime values in the 
 *  JVM's local timezone.  This process is reversed when datetime values are fetched back out
 *  of the database, so values round-trip correctly.
 *  <p>
 *  To aid understanding, consider this round-trip example.  We have a user in New York and a 
 *  user in London; the server is in San Francisco and is configured to use the US Pacific 
 *  timezone (this is mentioned explicitly because servers are often configured to use UTC, 
 *  wherever they are in the world).  Our New York user saves a record representing an online 
 *  meeting to take place on May 23 2016 at 2pm local time.  This is what happens:<ul>
 *  <li>Client code uses local time '2016-05-23 14:00:00' in the user's local timezone (EDT, US 
 *  Eastern Daylight Time, which is GMT-0400) to derive the epoch value 1464026400000, which 
 *  also represents '2016-05-23 18:00:00' UTC (as you would expect, since EDT is GMT-0400)</li>
 *  <li>If the <code>useUTCDateTimes</code> flag is set, the server renders this epoch value as
 *  a UTC time when generating the SQL.  It is important to understand that this concept of the 
 *  datetime being UTC is something we are doing at the framework level; the database may think 
 *  it is storing a local datetime, or a UTC datetime, or it may not consider the issue of 
 *  timezones at all.  The important thing is, we told it to insert '2016-05-23 18:00:00', so 
 *  we can reasonably expect that this is the value we will get out of it when we read the row
 *  back</li>
 *  <li>If the <code>useUTCDateTimes</code> flag is not set, the server renders this epoch value
 *  as a time in the JVM's local timezone when generating the SQL.  Again, keep in mind that the
 *  concept of the datetime being in a particular timezone is something we are doing at the 
 *  framework level; as above, the important thing is, we told it to insert '2016-05-23 11:00:00'
 *  (because it is May so San Francisco is on Pacific Daylight Time, which is GMT-0700), so that 
 *  is what we will get back when we read it (there are cases where this may not be true; see 
 *  the section "Store using UTC or local timezone?" below)</li>
 *  <li>Now our user in London comes along and reads the same record.  The row is read and an 
 *  epoch time is derived, by treating the value read from the database as either a UTC datetime
 *  or a time in the JVM's local timezone, depending on the <code>useUTCDateTimes</code> flag 
 *  (in fact, it isn't always that straightforward behind the scenes because some databases/JDBC 
 *  drivers perform automatic conversions on datetime values that cannot be suppressed, but 
 *  Smart GWT Server compensates for such cases)</li>
 *  <li>The UTC epoch value delivered from the server is now used to create a Date object on the
 *  client; built-in datetime converters and/or Smart GWT facilities like the 
 *  String will be used to derive a 
 *  display value applicable to the London user, for whom the equivalent datetime is 
 *  '2016-05-23 19:00:00' (London is on British Summer Time, GMT+0100, in May)</li>
 *  </ul>
 *  As the above example shows, the process is actually fairly straightforward.  However, you 
 *  need to consider that it is the Smart GWT framework that ensures that datetimes coming out
 *  of the database are converted using the same timezone that was used when they went into the 
 *  database.  Any non-Smart GWT systems that read the same database tables will have to do 
 *  any necessary conversions manually.
 *  <P>
 *  <h3>Store using UTC or local timezone?</h3>
 *  <P>
 *  As described above, Smart GWT Server can be configured to store datetimes using either
 *  UTC or the JVM's local timezone.  On the face of it, there is little to choose between the
 *  two: Smart GWT will ensure that values are consistent across server and client regardless
 *  of which you choose.  However, we recommend that you choose UTC as your storage strategy, 
 *  for two compelling reasons<ul>
 *  <li>Because storage using the JVM's local timezone just uses whatever the local timezone 
 *  happens to be at the time of writing or reading, changing the operating system or JVM 
 *  timezone will change the meaning of the datetimes already stored.For example, if you change
 *  your server's timezone from US Eastern to US Pacific, any datetimes you have already stored
 *  will effectively be shifted forward by three hours.  This does not happen if you choose UTC
 *  as your Smart GWT storage strategy, because it is independent of server timezone</li>
 *  <li>As most people know, Daylight Saving Time is a scheme used by many countries worldwide
 *  to maximize the number of usable hours of daylight in the summer months.  This involves 
 *  shifting clocks forward in Spring (typically by one hour, but other values are used) and 
 *  then back again in autumn.  This leads to two different but related problems if you choose 
 *  to use any ordinary local timezone for storage of datetimes<ul>
 *    <li>In Spring, there is a missing hour, usually the hour between 1am and 2am on the day
 *    of transition to DST.  If you are using a real local timezone for storage of datetimes, 
 *    it is not possible to record any datetime value occuring within that hour</li>
 *    <li>In Autumn, there is an extra hour, usually created by setting the time back to 1am
 *    when 2am is reached on the day of DST transition.  If you are using a real local timezone 
 *    for storage of datetimes, it is not possible to unambiguously record any datetime value 
 *    occurring within that two-hour period</li>
 *    </ul>
 *  Because UTC is a fixed reference point and not a "real" timezone, DST is not relevant and 
 *  all datetimes can be recorded unambiguously without exceptions or edge cases.
 *  </ul>
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
 * to {@link com.smartgwt.client.data.DataSource#fetchData DataSource.fetchData()} and inspect the
 * data in the callback)
 *  <li> what value does the FormItem or other editing widget report before saving is attempted?
 *  <li> what value is reported right before the value is serialized for transmission to the
 * server ({@link com.smartgwt.client.data.DataSource#transformRequest
 * DataSource.transformRequest()} is a good place to check)
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
