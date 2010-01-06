package com.smartgwt.client.widgets.grid;

/**
 * Group title renderer function.
 */
public interface GroupTitleRenderer {

    /**
     * Return the title that should be shown to the user for the group with the groupValue passed as a parameter.
     * <p>
     * Default title is the groupValue itself.
     *
     * @param groupValue the value from the group is created, the result of {@link com.smartgwt.client.widgets.grid.GroupValueFunction#getGroupValue(Object, ListGridRecord, ListGridField, String, ListGrid)}
     * @param groupNode the node in the grid containing the group
     * @param field the field object for which to get group value
     * @param fieldName The name of the field
     * @param grid the ListGrid displaying the cell
     *
     * @return the group value to which this record belongs
     */
    String getGroupTitle(Object groupValue, GroupNode groupNode, ListGridField field, String fieldName, ListGrid grid);
}
