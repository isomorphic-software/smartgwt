
package com.smartgwt.client.docs;

/**
 * <h3>Exports &amp; Formatting</h3>
 * This topic explains the default rules for whether date, numeric and other formatting settings
 * are applied when performing various types of exports, and how to override the default behavior.
 * <p> For server-based exports ({@link com.smartgwt.client.widgets.grid.ListGrid#exportData
 * ListGrid} or DataSource.exportData()): <ul> <li> if {@link
 * com.smartgwt.client.data.DSRequest#getExportAs exportAs} is a spreadsheet format (XLS or
 * OOXML),      {@link com.smartgwt.client.data.DataSourceField#getFormat dsField.format or
 * dsField.exportFormat} will be used if      specified, otherwise, {@link
 * com.smartgwt.client.data.DataSourceField#getDateFormatter dateFormatter} will be used if
 * specified,      otherwise, no formatting will be applied and the date or number will be shown
 * in the      spreadsheet program's default formatting. <li> if targetting CSV, XML or JSON, by
 * default, formatting declarations are ignored and      standard formats are used, because the
 * expectation is that this type of export is      intended for data interchange with other
 * systems and not for direct viewing by end      users.  Specifically, date and datetime values
 * use standard       <a href='http://www.w3.org/TR/xmlschema-2/#dateTime'
 * onclick="window.open('http://www.w3.org/TR/xmlschema-2/#dateTime');return false;">XML Schema
 * date and time formats</a>      and CSV export uses the "yyyy-MM-dd HH:mm:ss" expected by
 * Microsoft Excel and similar      tools that consume CSV, with only the date or time part of the
 * format being used for      fields that are of type "date" or "time" rather than "datetime".  If
 * you instead set      {@link com.smartgwt.client.data.DSRequest#getExportRawValues
 * exportRawValues} to false, format settings available to server will be used,      exactly as
 * explained above for spreadsheet exports with <code>exportData()</code>. </ul> For a
 * client-driven export (eg {@link com.smartgwt.client.widgets.grid.ListGrid#exportClientData
 * ListGrid.exportClientData}): <ul> <li> if {@link com.smartgwt.client.data.DSRequest#getExportAs
 * exportAs} is a spreadsheet format (XLS or OOXML),      rules are the same as for server-driven
 * export except that <code>dateFormatter</code>      settings on client-side UI components will
 * be used if a built-in formatter is used (for      example, if {@link
 * com.smartgwt.client.widgets.grid.ListGridField#getDateFormatter dateFormatter} is set to the
 * built-in formatter      "toEuropeanShortDate")).  If you need date values to appear
 * <b>exactly</b> as shown to      the user, set {@link
 * com.smartgwt.client.data.DSRequest#getExportDatesAsFormattedString
 * exportDatesAsFormattedString}, but see the docs for this property for the      drawbacks of
 * doing this. <li> for CSV, XML or JSON exports, whatever is shown to the end user is used (since
 * it's      assumed the reason for calling <code>exportClientData()</code> rather than     
 * <code>exportData()</code> is precisely to create a fully formatted export).  If you     
 * instead set {@link com.smartgwt.client.widgets.grid.ListGrid#getExportRawValues
 * exportRawValues} to true, only standard formats appropriate      to data interchange are used,
 * the same as described for <code>exportData()</code> above. </ul>
 * @see com.smartgwt.client.widgets.form.fields.FormItem#getFormat
 * @see com.smartgwt.client.widgets.form.fields.FormItem#getExportFormat
 * @see com.smartgwt.client.data.DSRequest#getExportRawValues
 * @see com.smartgwt.client.data.DSRequest#getExportDatesAsFormattedString
 * @see com.smartgwt.client.widgets.viewer.DetailViewerField#getFormat
 * @see com.smartgwt.client.widgets.viewer.DetailViewerField#getExportFormat
 * @see com.smartgwt.client.widgets.grid.ListGridField#getFormat
 * @see com.smartgwt.client.widgets.grid.ListGridField#getExportFormat
 * @see com.smartgwt.client.data.SimpleType#getFormat
 * @see com.smartgwt.client.data.SimpleType#getExportFormat
 */
public interface ExportFormatting {
}
