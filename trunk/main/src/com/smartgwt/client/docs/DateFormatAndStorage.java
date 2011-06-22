
package com.smartgwt.client.docs;

/**
 * <h3>Date and Time Format and Storage</h3>
 * The Smart GWT system has the following features for handling Date and Time type values within DataSources and databound
 * components. <P> DataSources and databound components may define fields of type <code>date</code>, <code>time</code>, or
 * <code>datetime</code>. <P> <h3>"date" handling</h3> <P> Fields of type {@link com.smartgwt.client.types.FieldType date}
 * are considered to be logical Dates with no time value, such as a holiday or birthday.  In the browser, values for "date"
 * fields are stored as Date objects, but when formatted for display to the user, they are typically displayed without any
 * time information. <P> When using the Smart GWT server framework, "date" values are automatically transmitted  with year,
 * month and day preserved and time value ignored. <P> When sent or received in XML or JSON, date field values should be
 * serialized in the  <a target=_blank href="http://www.w3.org/TR/xmlschema-2/#dateTime">XML Schema date format</a> -
 * <code>YYYY-MM-DD</code> - are expected to be received in the same format.  Any time value present for a "date" field is
 * ignored. <P> System wide formatting for dates may be controlled via the  Date.setNormalDisplayFormat and 
 * Date.setShortDisplayFormat methods. <P> <h3>"datetime" handling</h3> <P> Fields of type {@link
 * com.smartgwt.client.types.FieldType datetime} are dates with full time information.  In the browser, values for datetime
 * fields are stored as Date objects.  <P> When using the Smart GWT server framework, "datetime" values are automatically
 * transmitted such that the resulting Date object has the same GMT/UTC timestamp (milliseconds since epoch). <P> When sent
 * or received in XML or JSON, datetime field values should be serialized out as full datetimes using the standard  <a
 * target=_blank href="http://www.w3.org/TR/xmlschema-2/#dateTime">XML Schema date format</a> 
 * (EG:<code>2006-01-10T12:22:04-04:00</code>).  If no timezone offset is supplied, the value is assumed to be GMT/UTC. <P>
 * System wide formatting for datetimes may be controlled via the  Date.setShortDatetimeDisplayFormat method.  Datetimes
 * will be displayed to the user in browser local time by default (see also timezone notes below). <P> <h3>"time"
 * handling</h3> <P> Fields of type {@link com.smartgwt.client.types.FieldType time} are time values in the absence of a
 * day, such as the beginning of the workday (9:00).  In the browser, values for "time" fields are stored as Date objects
 * with the time in browser local time.  The date information has no meaning and only the time information is displayed to
 * the user. <P> Time formatting is handled by the String class APIs. <br> When using the Smart GWT server framework,
 * "time" values are automatically transmitted such that the resulting Date object has the same hour, minute and second
 * values in local time, and year/month/day is ignored. <P> When sent or received in XML or JSON, date field values should
 * be serialized as hours, minutes and seconds using the standard <a target=_blank
 * href="http://www.w3.org/TR/xmlschema-2/#dateTime">XML Schema time format</a> - <code>"22:01:45"</code>.  Timezone is not
 * relevant and should be omitted. <P> <h3>Timezone settings and Daylight Savings Time</h3> <P> By default, "datetime"
 * values will be shown to the user in browser local time, as derived from the native browser locale.  Developers may
 * modify this behavior by specifying an explicit display timezone via String.  <P> Note that depending on the specific
 * date being displayed, a Daylight Savings Time offset may also be applied based on the browser locale.  To disable this
 * behavior set String to false. <P> If a custom timezone is specified, it will be respected by all {@link
 * com.smartgwt.client.types.TimeDisplayFormat}s, and by the standard short {@link
 * com.smartgwt.client.types.DateDisplayFormat}s when formatting dates representing datetime type values. However native
 * JavaScript Date formatters,  including <code>toLocaleString()</code> will not respect the specified timezone. Developers
 * specifying a custom timezone may therefore wish to modify the  Date.setNormalDisplayFormat to avoid using a native JS
 * Date formatter function. <P> Note that in addition to the system-wide date, datetime and time-formatting settings
 * described above, databound components also support applying custom display formats for date values. Typically this can
 * be achieved via a custom <code>dateFormatter</code> or <code>timeFormatter</code> at the field level (see {@link
 * com.smartgwt.client.data.DataSourceField#getDateFormatter dateFormatter},  {@link
 * com.smartgwt.client.data.DataSourceField#getTimeFormatter timeFormatter} and for example {@link
 * com.smartgwt.client.widgets.grid.ListGridField#getDateFormatter dateFormatter}). Date formatting may also be configured
 * at the component level by setting the <code>dateFormatter</code>, <code>datetimeFormatter</code> and
 * <code>timeFormatter</code> attributes (See for example {@link com.smartgwt.client.widgets.grid.ListGrid#getDateFormatter
 * dateFormatter}, {@link com.smartgwt.client.widgets.grid.ListGrid#getTimeFormatter timeFormatter}, and {@link
 * com.smartgwt.client.widgets.grid.ListGrid#getDatetimeFormatter datetimeFormatter}).
 */
public interface DateFormatAndStorage {
}
