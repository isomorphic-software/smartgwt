
package com.smartgwt.client.docs;

/**
 * <h3>Frozen Fields</h3>
 * Frozen fields are fields that do not scroll horizontally with other fields, remaining on the screen while other fields
 * may be scrolled off.  This feature is typically used to allow basic identifying information (like an "accountId") to
 * remain on screen while the user scrolls through a large number of related fields. <P> Fields can be programmatically
 * frozen via setting {@link com.smartgwt.client.widgets.grid.ListGridField#getFrozen field.frozen} to true when the grid
 * is created, or dynamically frozen and unfrozen via {@link com.smartgwt.client.widgets.grid.ListGrid#freezeField
 * freezeField()} and {@link com.smartgwt.client.widgets.grid.ListGrid#unfreezeField unfreezeField()}. The setting {@link
 * com.smartgwt.client.widgets.grid.ListGrid#getCanFreezeFields canFreezeFields} enables a user interface to allow end
 * users to dynamically freeze and unfreeze fields. <P> The frozen fields feature is not compatible with the following
 * features: <ul> <li> variable height auto-sizing records      ({@link
 * com.smartgwt.client.widgets.grid.ListGrid#getFixedRecordHeights fixedRecordHeights:false}) <li> {@link
 * com.smartgwt.client.docs.AutoFitData}:"horizontal", as well as headers that autoFit to titles      (normally enabled via
 * <code>field.overflow:"visible"</code>) <li> the {@link com.smartgwt.client.widgets.cube.CubeGrid} subclass of ListGrid
 * <li> nested grids </ul> The frozen fields feature <b>is</b> compatible with column resize and reorder, selection and
 * multi-selection, loading data on demand, inline editing, drag and drop and reorder of records, the {@link
 * com.smartgwt.client.widgets.tree.TreeGrid} subclass of ListGrid, and all dynamic styling-related and formatting-related
 * features.
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
