package com.smartgwt.client.widgets.grid;

import com.smartgwt.client.widgets.grid.GroupNode;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;

/**
 * If ListGrid.showGridSummary is true, and this method is specified it
 * will be called to generate the summary value to be displayed in the grid
 * summary row. Note that this is called instead of making use of the
 * {@link ListGridField#setSummaryFunction(SummaryFunction)}.
 * 
 */
public abstract class GridSummaryCustomizer {
	
	/**
	 * If this grid is grouped, and +link{listGrid.showGroupSummary} is true, this
	 * method will be passed a third parameter - an array of group-level summaries.
	 * 
	 * @param recordsrecords, records for which a summary is being generated.
	 * @param field, pointer to the field for which summary value is being generated
	 * @param groupSummary, If this grid is grouped and
	 *        ListGrid.showGridSummary is specified, this parameter contains
	 *        an array of already- calculated summary values for each group in the
	 *        grid. Each element in this array will be an object containing
	 *        calculated summary values for each field in the grid, as well as a
	 *        specified groupValue and groupName, allowing the developer to
	 *        determine which group this summary value comes from
	 * @return  As with ListGrid.getGridSummary() this method may return an array of
	 * 	        results - in this case each result will show up in a separate row in the
	 *          ListGrid.summaryRow grid.
	 */
    public abstract Object[] getGroupSummary(ListGridRecord[] records, ListGridField field, GroupSummary groupSummary);
}
