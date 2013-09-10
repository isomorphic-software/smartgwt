package com.smartgwt.client.widgets.grid;

/**
 * Function to return the value which records should be grouped by.
 */
public interface GroupValueFunction {

    /**
     * Return the value which records should be grouped by.
     * <p>
     * All records that for which getGroupValue() returns the same value appear in the same group. Default is the result
     * of ListGrid.getCellValue().
     * <p>
     * While any type of value may be returned, avoiding the use of string values may result in improved performance.
     * In this case, {@link GroupTitleRenderer#getGroupTitle(Object, GroupNode, ListGridField, String, ListGrid)}   may be implemented to map a numeric group value into a
     * legible string.
     *
     * @param value raw value for the cell, from the record for the row
     * @param record Record object for the cell. Note: If this is a new row that has not been saved, in an editable grid, it has no associated record object. In this case the edit values will
     * be passed in as this parameter
     * @param field  Field object for which to get group value
     * @param fieldName The name of the field
     * @param grid the ListGrid displaying the cell
     * @return Group value to which this record belongs
     */
    Object getGroupValue(Object value, ListGridRecord record, ListGridField field, String fieldName, ListGrid grid);

}
