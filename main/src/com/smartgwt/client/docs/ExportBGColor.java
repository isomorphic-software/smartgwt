
package com.smartgwt.client.docs;

/**
 * <h3>Exports &amp; Cell Background Color</h3>
 * Several APIs and settings influence the background color which will be used for
 * spreadsheetcells when exporting to Excel/OpenOffice formats using {@link
 * com.smartgwt.client.widgets.grid.ListGrid#exportData ListGrid.exportData} or{@link
 * com.smartgwt.client.widgets.grid.ListGrid#exportClientData ListGrid.exportClientData}.  The
 * following APIs are called in the order shown, so <code>hilite.backgroundColor</code> takes
 * precedence over  <code>exportDefaultBGColor</code>, for example. <ol> <li> {@link
 * com.smartgwt.client.widgets.grid.ListGrid#getExportBGColor getExportBGColor(rowNum, colNum,
 * record)} <li> {@link com.smartgwt.client.data.Hilite#getBackgroundColor backgroundColor} <li>
 * {@link com.smartgwt.client.widgets.grid.ListGrid#getExportRowBGColor
 * getExportRowBGColor(rowNum, record)} <li> {@link
 * com.smartgwt.client.widgets.grid.ListGrid#getExportColumnBGColor
 * getExportColumnBGColor(colNum)} <li> {@link
 * com.smartgwt.client.widgets.grid.ListGrid#getExportAlternateRowBGColor
 * exportAlternateRowBGColor} <li> {@link
 * com.smartgwt.client.widgets.grid.ListGrid#getExportDefaultBGColor exportDefaultBGColor} </ol>If
 * overriding any of the above methods, return null to allow methods later in the precedenceorder
 * to influence background color.  For example, if you want certain rows to have aspecial
 * background color but also want to show alternating colors per row, overridegetExportRowBGColor
 * and return null for all rows that should just show normal alternatingcolors, and not a special
 * color.
 */
public interface ExportBGColor {
}
