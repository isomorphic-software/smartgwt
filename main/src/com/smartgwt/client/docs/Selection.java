
package com.smartgwt.client.docs;

/**
 * <h3>Selection</h3>
 * APIs for marking {@link com.smartgwt.client.data.Record}s as selected and retrieving the selected record or records. <P>
 * Only applicable to a {@link com.smartgwt.client.widgets.DataBoundComponent} that manages a list of Records, or manages a
 * data model that can be viewed as a list (for example, the current list of visible nodes on a tree can be treated as a
 * list for selection purposes).
 * @see #getEventRow
 * @see #getEventColumn
 * @see #facetValueSelectionChanged
 * @see #getSelectedCells
 * @see #getSelectedCellIds
 * @see #anyCellSelected
 * @see #cellIsSelected
 * @see #selectCell
 * @see #deselectCell
 * @see #selectCells
 * @see #deselectCells
 * @see #selectAllCells
 * @see #deselectAllCells
 * @see #getSelectedFacetValues
 * @see #facetValuesSelected
 * @see #facetHasSelection
 * @see #getFacetsHavingSelection
 * @see #selectFacetValues
 * @see #deselectFacetValues
 * @see #selectFacetValue
 * @see #deselectFacetValue
 * @see #selectAllFacetValues
 * @see #deselectAllFacetValues
 * @see #deselectAll
 * @see #cellSelectionChanged
 * @see #isSelected
 * @see #isPartiallySelected
 * @see #anySelected
 * @see #multipleSelected
 * @see #getSelection
 * @see #getSelectedRecord
 * @see #setSelected
 * @see #select
 * @see #deselect
 * @see #selectSingle
 * @see #selectList
 * @see #deselectList
 * @see #selectAll
 * @see #deselectAll
 * @see #selectItem
 * @see #deselectItem
 * @see #selectRange
 * @see #deselectRange
 * @see com.smartgwt.client.grid.GridRenderer#cellIsEnabled
 * @see com.smartgwt.client.grid.GridRenderer#getEventRow
 * @see com.smartgwt.client.grid.GridRenderer#getEventColumn
 * @see com.smartgwt.client.grid.GridRenderer#getNearestRowToEvent
 * @see com.smartgwt.client.grid.GridRenderer#getNearestColToEvent
 * @see com.smartgwt.client.grid.GridRenderer#selectionChanged
 * @see com.smartgwt.client.grid.GridRenderer#cellSelectionChanged
 * @see com.smartgwt.client.widgets.grid.ListGrid#selectRecord
 * @see com.smartgwt.client.widgets.grid.ListGrid#deselectRecord
 * @see com.smartgwt.client.widgets.grid.ListGrid#selectRecords
 * @see com.smartgwt.client.widgets.grid.ListGrid#deselectRecords
 * @see com.smartgwt.client.widgets.grid.ListGrid#selectAllRecords
 * @see com.smartgwt.client.widgets.grid.ListGrid#deselectAllRecords
 * @see com.smartgwt.client.widgets.grid.ListGrid#anySelected
 * @see com.smartgwt.client.widgets.grid.ListGrid#selectSingleRecord
 * @see com.smartgwt.client.widgets.grid.ListGrid#selectionChanged
 * @see com.smartgwt.client.widgets.tile.TileGrid#getSelection
 * @see com.smartgwt.client.widgets.tile.TileGrid#getSelectedRecord
 * @see com.smartgwt.client.widgets.tile.TileGrid#selectRecord
 * @see com.smartgwt.client.widgets.tile.TileGrid#deselectRecord
 * @see com.smartgwt.client.widgets.tile.TileGrid#selectRecords
 * @see com.smartgwt.client.widgets.tile.TileGrid#deselectRecords
 * @see com.smartgwt.client.widgets.tile.TileGrid#selectAllRecords
 * @see com.smartgwt.client.widgets.tile.TileGrid#deselectAllRecords
 * @see com.smartgwt.client.widgets.tile.TileGrid#anySelected
 * @see com.smartgwt.client.widgets.tile.TileGrid#selectionChanged
 * @see com.smartgwt.client.widgets.grid.ColumnTree#selectRecord
 * @see com.smartgwt.client.widgets.grid.ColumnTree#deselectRecord
 * @see com.smartgwt.client.widgets.grid.ColumnTree#selectRecords
 * @see com.smartgwt.client.widgets.grid.ColumnTree#deselectRecords
 * @see com.smartgwt.client.widgets.grid.ColumnTree#selectAllRecords
 * @see com.smartgwt.client.widgets.grid.ColumnTree#deselectAllRecords
 * @see com.smartgwt.client.widgets.grid.ColumnTree#anySelected
 * @see #cellIsSelected
 * @see #anySelected
 * @see #getSelectedCells
 * @see #selectCell
 * @see #deselectCell
 * @see #selectCellList
 * @see #deselectCellList
 * @see #selectSingleCell
 * @see com.smartgwt.client.widgets.grid.ListGrid#getSelection
 * @see com.smartgwt.client.widgets.grid.ListGrid#getSelectedRecord
 * @see com.smartgwt.client.widgets.grid.ListGrid#isSelected
 * @see com.smartgwt.client.widgets.grid.ListGrid#isPartiallySelected
 * @see com.smartgwt.client.widgets.DataBoundComponent#selectRecord
 * @see com.smartgwt.client.widgets.DataBoundComponent#selectSingleRecord
 * @see com.smartgwt.client.widgets.DataBoundComponent#deselectRecord
 * @see com.smartgwt.client.widgets.DataBoundComponent#selectRecords
 * @see com.smartgwt.client.widgets.DataBoundComponent#deselectRecords
 * @see com.smartgwt.client.widgets.DataBoundComponent#selectAllRecords
 * @see com.smartgwt.client.widgets.DataBoundComponent#deselectAllRecords
 * @see com.smartgwt.client.widgets.DataBoundComponent#anySelected
 * @see com.smartgwt.client.widgets.DataBoundComponent#selectionUpdated
 * @see com.smartgwt.client.widgets.toolbar.Toolbar#selectButton
 * @see com.smartgwt.client.widgets.toolbar.Toolbar#deselectButton
 * @see com.smartgwt.client.widgets.form.fields.PickTreeItem#getCanSelectParentItems
 * @see com.smartgwt.client.widgets.grid.ListGrid#getSelection
 * @see com.smartgwt.client.widgets.grid.ListGrid#getSelectionAppearance
 * @see com.smartgwt.client.widgets.grid.ListGrid#getCanSelectAll
 * @see com.smartgwt.client.widgets.grid.ListGrid#getSelectionType
 * @see com.smartgwt.client.widgets.grid.ListGrid#getSelectionProperty
 * @see com.smartgwt.client.widgets.grid.ListGrid#getCanDragSelect
 * @see com.smartgwt.client.widgets.grid.ListGrid#getCanDragSelectText
 * @see com.smartgwt.client.widgets.tree.TreeGrid#getSelectionProperty
 * @see com.smartgwt.client.widgets.menu.Menu#getCanSelectParentItems
 * @see com.smartgwt.client.widgets.tile.TileGrid#getSelectionType
 * @see com.smartgwt.client.types.SelectionStyle
 */
public interface Selection {
}
