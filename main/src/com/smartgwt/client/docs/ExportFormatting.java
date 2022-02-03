
package com.smartgwt.client.docs;

/**
 * <h3>Exports &amp; Formatting</h3>
 * This topic explains the default rules for whether date, numeric and other formatting settings
 * are applied when performing various types of exports, and how to override the default behavior.
 * <p> For server-based exports (e.g. {@link com.smartgwt.client.widgets.grid.ListGrid#exportData
 * ListGrid.exportData()} or {@link com.smartgwt.client.data.DataSource#exportData
 * DataSource.exportData()}): <ul> <li> if {@link com.smartgwt.client.data.DSRequest#getExportAs
 * exportAs} is a spreadsheet format (XLS or OOXML),      {@link
 * com.smartgwt.client.data.DataSourceField#getFormat dsField.format} or       {@link
 * com.smartgwt.client.data.DataSourceField#getExportFormat dsField.exportFormat} will be used if 
 * specified, otherwise, {@link com.smartgwt.client.data.DataSourceField#getDateFormatter
 * DataSourceField.dateFormatter} will be used if specified,      otherwise, no formatting will be
 * applied and the date or number will be shown in the      spreadsheet program's default
 * formatting. <li> if targetting CSV, XML or JSON, by default, formatting declarations are
 * ignored and      standard formats are used, because the expectation is that this type of export
 * is      intended for data interchange with other systems and not for direct viewing by end     
 * users.  Specifically, date and datetime values use standard       <a
 * href='http://www.w3.org/TR/xmlschema-2/#dateTime' target='_blank'>XML Schema date and time
 * formats</a>      and CSV export uses the "yyyy-MM-dd HH:mm:ss" expected by Microsoft Excel and
 * similar      tools that consume CSV, with only the date or time part of the format being used
 * for      fields that are of type "date" or "time" rather than "datetime".  If you instead set  
 * {@link com.smartgwt.client.data.DSRequest#getExportRawValues DSRequest.exportRawValues} to
 * false, format settings available to server will be used,      exactly as explained above for
 * spreadsheet exports with <code>exportData()</code>. </ul> For a client-driven export (e.g.
 * {@link com.smartgwt.client.widgets.grid.ListGrid#exportClientData ListGrid.exportClientData()}
 * or {@link com.smartgwt.client.data.DataSource#exportClientData DataSource.exportClientData()}:
 * <ul> <li> if {@link com.smartgwt.client.data.DSRequest#getExportAs exportAs} is a spreadsheet
 * format (XLS or OOXML),      rules are the same as for server-driven export, except that if no  
 * {@link com.smartgwt.client.data.DataSourceField#getFormat dsField.format} or       {@link
 * com.smartgwt.client.data.DataSourceField#getExportFormat dsField.exportFormat} is specified,   
 * <code>dateFormatter</code> settings on client-side UI components will be used if a     
 * built-in formatter is used (for example, if {@link
 * com.smartgwt.client.widgets.grid.ListGridField#getDateFormatter ListGridField.dateFormatter} is
 * set to      the built-in formatter "toEuropeanShortDate").  If you need date or number values
 * to      appear <b>exactly</b> as shown to the user, set      {@link
 * com.smartgwt.client.data.DSRequest#getExportDatesAsFormattedString
 * DSRequest.exportDatesAsFormattedString} or      {@link
 * com.smartgwt.client.data.DSRequest#getExportNumbersAsFormattedString
 * DSRequest.exportNumbersAsFormattedString}, respectively, but see the docs for      these
 * properties for the drawbacks of doing this.</li> <li> for CSV, XML or JSON exports, whatever is
 * shown to the end user is used (since it's      assumed the reason for calling
 * <code>exportClientData()</code> rather than      <code>exportData()</code> is precisely to
 * create a fully formatted export).  If you      instead set {@link
 * com.smartgwt.client.widgets.grid.ListGrid#getExportRawValues ListGrid.exportRawValues} to true,
 * only standard formats appropriate      to data interchange are used, the same as described for
 * <code>exportData()</code> above. </li></ul> These different default behaviors for different
 * export formats can be overriden by use of  {@link
 * com.smartgwt.client.widgets.grid.ListGrid#getExportRawValues ListGrid.exportRawValues}.  If you
 * only want to override the default behaviors for  numeric values, you can use {@link
 * com.smartgwt.client.widgets.grid.ListGrid#getExportRawNumbers ListGrid.exportRawNumbers} (note,
 * the  <code>exportRawNumbers</code> setting has no effect if <code>exportRawValues</code> is set
 * to true) <p> Use {@link com.smartgwt.client.data.DSRequest#getExportPropertyIdentifier
 * DSRequest.exportPropertyIdentifier} to override the default behavior for a server or
 * client-driven export and force either component field names or titles to be exported. <P>
 * <h3>Display-mapped fields</h3> Smart GWT supports a number of ways to declaratively map
 * underlying data values to  "display values" that have more meaning to a user.  This mapping can
 * be achieved using a {@link com.smartgwt.client.data.DataSourceField#getDisplayField
 * displayField} in the same record, a {@link com.smartgwt.client.types.ValueMap}  or an {@link
 * com.smartgwt.client.widgets.grid.ListGridField#getOptionDataSource optionDataSource}.  The
 * table below shows what values get exported for each of these possibilities, in combination with
 * the  {@link com.smartgwt.client.data.DSRequest#getExportValueFields exportValueFields} flag and
 * whether you are using  client-driven or server-driven export:<p> <table width="700"
 * style="font-size:11px;border:1px solid black;"> <tr><td
 * style="color:white;background-color:black;width:560px"><b>Use case</b></td>     <td
 * align="center" style="color:white;background-color:black;width:70px;"><b>Exports value
 * field</b></td>     <td align="center"
 * style="color:white;background-color:black;width:70px;"><b>Exports display field</b></td></tr>
 * <tr><td>exportClientData(), in-record displayField, exportValueFields=true</td><td
 * align="center">&#x2713;</td><td align="center">&#x2713;</td></tr> <tr
 * style="background-color:#ddd;"><td>exportClientData(), in-record displayField,
 * exportValueFields=false</td><td align="center">&nbsp;</td><td align="center">&#x2713;</td></tr>
 * <tr><td>exportClientData(), valueMap declared in DataSource, exportValueFields=true</td><td
 * align="center">&nbsp;</td><td align="center">&#x2713;</td></tr> <tr
 * style="background-color:#ddd;"><td>exportClientData(), valueMap declared in DataSource,
 * exportValueFields=false</td><td align="center">&nbsp;</td><td align="center">&#x2713</td></tr>
 * <tr><td>exportClientData(), valueMap defined in code, exportValueFields=true</td><td
 * align="center">&nbsp;</td><td align="center">&#x2713;</td></tr> <tr
 * style="background-color:#ddd;"><td>exportClientData(), valueMap defined in code,
 * exportValueFields=false</td><td align="center">&nbsp;</td><td align="center">&#x2713</td></tr>
 * <tr><td>exportClientData(), optionDataSource, exportValueFields=true</td><td
 * align="center">&#x2713;</td><td align="center">&#x2713;</td></tr> <tr
 * style="background-color:#ddd;"><td>exportClientData(), optionDataSource,
 * exportValueFields=false</td><td align="center">&nbsp;</td><td align="center">&#x2713;</td></tr>
 * <tr><td>exportData(), in-record displayField (must be declared in DataSource),
 * exportValueFields not specified</td><td align="center">&#x2713</td><td
 * align="center">&#x2713</td></tr> <tr style="background-color:#ddd;"><td>exportData(), in-record
 * displayField (must be declared in DataSource), exportValueFields=true</td><td
 * align="center">&#x2713</td><td align="center">&nbsp;</td></tr> <tr><td>exportData(), in-record
 * displayField (must be declared in DataSource), exportValueFields=false</td><td
 * align="center">&nbsp;</td><td align="center">&#x2713</td></tr> <tr
 * style="background-color:#ddd;"><td>exportData(), valueMap declared in DataSource</td><td
 * align="center">&#x2713;</td><td align="center">&nbsp;</td></tr> <tr><td>exportData(), valueMap
 * defined in code</td><td align="center">&#x2713;</td><td align="center">&nbsp;</td></tr> <tr
 * style="background-color:#ddd;"><td>exportData(), optionDataSource</td><td
 * align="center">&#x2713;</td><td align="center">&nbsp;</td></tr> </table>
 * @see com.smartgwt.client.data.DSRequest#getExportRawValues
 * @see com.smartgwt.client.data.DSRequest#getExportPropertyIdentifier
 * @see com.smartgwt.client.data.DSRequest#getExportDatesAsFormattedString
 * @see com.smartgwt.client.data.DSRequest#getExportNumbersAsFormattedString
 * @see com.smartgwt.client.data.DSRequest#getExportTZ
 * @see com.smartgwt.client.widgets.cube.CubeGrid#getValueFormat
 * @see com.smartgwt.client.widgets.cube.CubeGrid#getValueExportFormat
 * @see com.smartgwt.client.widgets.viewer.DetailViewerField#getFormat
 * @see com.smartgwt.client.widgets.viewer.DetailViewerField#getExportFormat
 * @see com.smartgwt.client.widgets.grid.ListGridField#getFormat
 * @see com.smartgwt.client.widgets.grid.ListGridField#getExportFormat
 * @see com.smartgwt.client.data.SimpleType#getFormat
 * @see com.smartgwt.client.data.SimpleType#getExportFormat
 * @see com.smartgwt.client.widgets.form.fields.FormItem#getExportFormat
 */
public interface ExportFormatting {
}
