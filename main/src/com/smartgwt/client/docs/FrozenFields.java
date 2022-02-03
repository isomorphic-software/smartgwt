
package com.smartgwt.client.docs;

/**
 * <h3>Frozen Fields</h3>
 * Frozen fields are fields that do not scroll horizontally with other fields, remaining on the
 * screen while other fields may be scrolled off.  This feature is typically used to allow basic
 * identifying information (like an "accountId") to remain on screen while the user scrolls
 * through a large number of related fields. <P> Fields can be programmatically frozen via setting
 * {@link com.smartgwt.client.widgets.grid.ListGridField#getFrozen field.frozen} to true when the
 * grid is created, or dynamically frozen and unfrozen via {@link
 * com.smartgwt.client.widgets.grid.ListGrid#freezeField freezeField()} and {@link
 * com.smartgwt.client.widgets.grid.ListGrid#unfreezeField unfreezeField()}. The setting {@link
 * com.smartgwt.client.widgets.grid.ListGrid#getCanFreezeFields canFreezeFields} enables a user
 * interface to allow end users to dynamically freeze and unfreeze fields. <P> The frozen fields
 * feature is not compatible with the following features: <ul> <li> {@link
 * com.smartgwt.client.docs.AutoFitData}:"horizontal", as well as headers that autoFit to titles  
 * (normally enabled via <code>field.overflow:"visible"</code>) <li> the {@link
 * com.smartgwt.client.widgets.cube.CubeGrid} subclass of ListGrid <li> nested grids </ul> The
 * frozen fields feature <b>is</b> compatible with column resize and reorder, selection and
 * multi-selection, loading data on demand, inline editing, drag and drop and reorder of records,
 * the {@link com.smartgwt.client.widgets.tree.TreeGrid} subclass of ListGrid, and all dynamic
 * styling-related and formatting-related features. <P> The {@link
 * com.smartgwt.client.widgets.grid.ListGrid#getFrozenFieldsMaxWidth
 * ListGrid.frozenFieldsMaxWidth} property may be used to specify a maximum size for the frozen
 * fields. If their combined width exceeds this, a  horizontal scrollbar will be displayed,
 * allowing the user to scroll the frozen fields independently of the other fields in the grid.
 * <P> Troubleshooting tip: If you encounter misalignment between rows in frozen and unfrozen 
 * columns, this is likely due to one of the following causes: <ul><li>Inconsistent
 * border/padding: all cells in a row in a table must have the same     top and bottom border
 * thickness, and all cells in a column must have the same      horizontal border and padding
 * width, or the table is invalid,      with no clear rules for rendering it.  The HTML/CSS spec
 * doesn't say what to      do in this situation, and browser engines behave inconsistently.</li>
 * <li>For grids with  fixedRecordHeights:true, the cell contents,     inclusive of border and
 * padding, needs to be less than your configured      {@link
 * com.smartgwt.client.widgets.grid.ListGrid#getCellHeight ListGrid.cellHeight}, or you need to
 * set  FrozenFields.enforceVClipping to cause us      to clip it as necessary. Breaking this rule
 * can cause misalignment between rows in     frozen and unfrozen columns as some fields have
 * cells with taller content.     (This does not apply for grids with
 * <code>fixedRecordHeights</code> set to false). </li></ul>
 * @see com.smartgwt.client.widgets.grid.ListGridField#getAutoFreezePosition
 * @see com.smartgwt.client.widgets.grid.ListGrid#freezeField
 * @see com.smartgwt.client.widgets.grid.ListGrid#unfreezeField
 * @see com.smartgwt.client.widgets.grid.ListGrid#toggleFrozen
 * @see com.smartgwt.client.widgets.grid.ListGridField#getFrozen
 * @see com.smartgwt.client.widgets.grid.ListGridField#getCanFreeze
 * @see com.smartgwt.client.widgets.grid.ListGridField#getAutoFreeze
 * @see com.smartgwt.client.widgets.grid.ListGrid#getFrozenBaseStyle
 * @see com.smartgwt.client.widgets.grid.ListGrid#getShrinkForFreeze
 * @see com.smartgwt.client.widgets.grid.ListGrid#getFrozenHeaderBaseStyle
 * @see com.smartgwt.client.widgets.grid.ListGrid#getFrozenHeaderTitleStyle
 * @see com.smartgwt.client.widgets.grid.ListGrid#getCanFreezeFields
 */
public interface FrozenFields {
}
