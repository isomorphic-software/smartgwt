package com.smartgwt.client.widgets.grid;

/**
 * Defines the HTML that's displayed in the cells of a 
 * {@link com.smartgwt.client.widgets.grid.ListGridField} or entire 
 * {@link com.smartgwt.client.widgets.grid.ListGrid}.
 * @see com.smartgwt.client.widgets.grid.ListGrid#setCellFormatter
 * @see com.smartgwt.client.widgets.grid.ListGridField#setCellFormatter
 */
public interface CellFormatter {

	/**
     * Returns the HTML to display in the cells of the field (or entire grid if so applied).
     * Given the raw value for a field as taken from the record, <code>format()</code> returns
     * a display value as HTML.  The value passed to this method is the raw value for the cell.
     * A {@link com.smartgwt.client.widgets.grid.CellFormatter} defined at the field level takes
     * precedence over one defined at the grid level for the cells of that field.<P>
     * <i>Example usage</i>: formatting a currency value stored in cents (so "100" to "$1.00")
     * <P>Note: this formatter will not be applied to the values displayed in cells being
     * edited.  Define a {@link com.smartgwt.client.widgets.grid.CellEditValueFormatter} and
     * apply it to the field.
     * @param value raw value for the cell, from the record for the row
     * @param record Record object for the cell. Note: If this is a new row that has not been
     * saved, in an   editable grid, it has no associated record object. In this case the edit
     * values will   be passed in as this parameter (see {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getEditValues ListGrid.getEditValues()})
     * @param rowNum row number for the cell
     * @param colNum column number for the cell.
     *
     * @return HTML to display in the cell
     * @see com.smartgwt.client.widgets.grid.ListGridField#setEditValueFormatter
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#grid_appearance_format_values"
     *       target="examples">Format values Example</a>
     */
    String format(Object value, ListGridRecord record, int rowNum, int colNum);
}
