package com.smartgwt.client.widgets.grid;

import com.smartgwt.client.widgets.grid.GroupNode;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;

/**
 * If {@link ListGrid#getShowGroupSummary()} is true, and this method is specified it will be
 * called to generate the field summary value to be displayed for each group level summary row.
 * Note that this is called instead of making use of the ListGridField.summaryFunction.
 * <P>
 * 
 */
public abstract class GroupSummaryCustomizer {
	
	/**
	 * 
	 * @param recordsrecords for which a summary is being generated (so all records in the group).
	 * @param field pointer to the field for which summary value is being generated
	 * @param groupNode object with specified groupValue and groupName for this group
	 * @return This method may return an array of results - in this case the group will show multiple summary
     *         rows, with each entry in the array showing up in a different record.
	 */
    public abstract Object[] getGroupSummary(ListGridRecord[] records, ListGridField field, GroupNode groupNode);
}
