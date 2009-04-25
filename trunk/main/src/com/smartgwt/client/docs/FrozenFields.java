
package com.smartgwt.client.docs;

/**
 * Frozen fields are fields that do not scroll horizontally with other fields, remaining on&#010 the screen while other fields may be scrolled off.  This feature is typically used to&#010 allow basic identifying information (like an "accountId") to remain on screen while the&#010 user scrolls through a large number of related fields.&#010 <P>&#010 Fields can be programmatically frozen via setting&#010 {@link com.smartgwt.client.widgets.grid.ListGridField#getFrozen frozen} to true when the grid is created, or&#010 dynamically frozen and unfrozen via {@link com.smartgwt.client.widgets.grid.ListGrid#freezeField} and&#010 {@link com.smartgwt.client.widgets.grid.ListGrid#unfreezeField}.&#010 The setting {@link com.smartgwt.client.widgets.grid.ListGrid#getCanFreezeFields canFreezeFields} enables a user interface to&#010 allow end users to dynamically freeze and unfreeze fields.&#010 <P>&#010 The frozen fields feature is not compatible with the following features:&#010 <ul>&#010 <li> variable height auto-sizing records&#010      ({@link com.smartgwt.client.widgets.grid.ListGrid#getFixedRecordHeights fixedRecordHeights})&#010 <li> headers that autoFit to titles (normally enabled via&#010      <code>field.overflow:"visible"</code>)&#010 <li> the {@link com.smartgwt.client..CubeGrid} subclass of ListGrid&#010 <li> nested grids&#010 </ul>&#010 The frozen fields feature <b>is</b> compatible with column resize and reorder, selection&#010 and multi-selection, loading data on demand, inline editing, drag and drop and reorder&#010 of records, the {@link com.smartgwt.client.widgets.tree.TreeGrid} subclass of ListGrid, and all dynamic styling-related and&#010 formatting-related features.
 * @see com.smartgwt.client.widgets.grid.ListGrid#freezeField
 * @see com.smartgwt.client.widgets.grid.ListGrid#unfreezeField
 * @see com.smartgwt.client.widgets.grid.ListGrid#toggleFrozen
 * @see com.smartgwt.client.widgets.grid.ListGridField#getFrozen
 * @see com.smartgwt.client.widgets.grid.ListGrid#getFrozenBaseStyle
 * @see com.smartgwt.client.widgets.grid.ListGrid#getShrinkForFreeze
 * @see com.smartgwt.client.widgets.grid.ListGrid#getFrozenHeaderBaseStyle
 * @see com.smartgwt.client.widgets.grid.ListGrid#getFrozenHeaderTitleStyle
 * @see com.smartgwt.client.widgets.grid.ListGrid#getCanFreezeFields
 */
public interface FrozenFields {
}
