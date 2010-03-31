
package com.smartgwt.client.docs;

/**
 * <h3>Selection</h3>
 * APIs for marking {@link com.smartgwt.client.data.Record}s as selected and retrieving the selected record or records. <P>
 * Only applicable to a {@link com.smartgwt.client.widgets.DataBoundComponent} that manages a list of Records, or manages a
 * data model that can be viewed as a list (for example, the current list of visible nodes on a tree can be treated as a
 * list for selection purposes).
 * @see com.smartgwt.client..CubeGrid#getEventRow
 * @see com.smartgwt.client..CubeGrid#getEventColumn
 * @see com.smartgwt.client..CubeGrid#facetValueSelectionChanged
 * @see com.smartgwt.client..CubeGrid#getSelectedCells
 * @see com.smartgwt.client..CubeGrid#getSelectedCellIds
 * @see com.smartgwt.client..CubeGrid#anyCellSelected
 * @see com.smartgwt.client..CubeGrid#cellIsSelected
 * @see com.smartgwt.client..CubeGrid#selectCell
 * @see com.smartgwt.client..CubeGrid#deselectCell
 * @see com.smartgwt.client..CubeGrid#selectCells
 * @see com.smartgwt.client..CubeGrid#deselectCells
 * @see com.smartgwt.client..CubeGrid#selectAllCells
 * @see com.smartgwt.client..CubeGrid#deselectAllCells
 * @see com.smartgwt.client..CubeGrid#getSelectedFacetValues
 * @see com.smartgwt.client..CubeGrid#facetValuesSelected
 * @see com.smartgwt.client..CubeGrid#facetHasSelection
 * @see com.smartgwt.client..CubeGrid#getFacetsHavingSelection
 * @see com.smartgwt.client..CubeGrid#selectFacetValues
 * @see com.smartgwt.client..CubeGrid#deselectFacetValues
 * @see com.smartgwt.client..CubeGrid#selectFacetValue
 * @see com.smartgwt.client..CubeGrid#deselectFacetValue
 * @see com.smartgwt.client..CubeGrid#selectAllFacetValues
 * @see com.smartgwt.client..CubeGrid#deselectAllFacetValues
 * @see com.smartgwt.client..CubeGrid#deselectAll
 * @see com.smartgwt.client..CubeGrid#cellSelectionChanged
 * @see com.smartgwt.client..Selection#isSelected
 * @see com.smartgwt.client..Selection#isPartiallySelected
 * @see com.smartgwt.client..Selection#anySelected
 * @see com.smartgwt.client..Selection#multipleSelected
 * @see com.smartgwt.client..Selection#getSelection
 * @see com.smartgwt.client..Selection#getSelectedRecord
 * @see com.smartgwt.client..Selection#setSelected
 * @see com.smartgwt.client..Selection#select
 * @see com.smartgwt.client..Selection#deselect
 * @see com.smartgwt.client..Selection#selectSingle
 * @see com.smartgwt.client..Selection#selectList
 * @see com.smartgwt.client..Selection#deselectList
 * @see com.smartgwt.client..Selection#selectAll
 * @see com.smartgwt.client..Selection#deselectAll
 * @see com.smartgwt.client..Selection#selectItem
 * @see com.smartgwt.client..Selection#deselectItem
 * @see com.smartgwt.client..Selection#selectRange
 * @see com.smartgwt.client..Selection#deselectRange
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
 * @see com.smartgwt.client..CellSelection#cellIsSelected
 * @see com.smartgwt.client..CellSelection#anySelected
 * @see com.smartgwt.client..CellSelection#getSelectedCells
 * @see com.smartgwt.client..CellSelection#selectCell
 * @see com.smartgwt.client..CellSelection#deselectCell
 * @see com.smartgwt.client..CellSelection#selectCellList
 * @see com.smartgwt.client..CellSelection#deselectCellList
 * @see com.smartgwt.client..CellSelection#selectSingleCell
 * @see com.smartgwt.client.widgets.grid.ListGrid#getSelection
 * @see com.smartgwt.client.widgets.grid.ListGrid#getSelectedRecord
 * @see com.smartgwt.client.widgets.DataBoundComponent#selectRecord
 * @see com.smartgwt.client.widgets.DataBoundComponent#selectSingleRecord
 * @see com.smartgwt.client.widgets.DataBoundComponent#deselectRecord
 * @see com.smartgwt.client.widgets.DataBoundComponent#selectRecords
 * @see com.smartgwt.client.widgets.DataBoundComponent#deselectRecords
 * @see com.smartgwt.client.widgets.DataBoundComponent#selectAllRecords
 * @see com.smartgwt.client.widgets.DataBoundComponent#deselectAllRecords
 * @see com.smartgwt.client.widgets.DataBoundComponent#anySelected
 * @see com.smartgwt.client.widgets.toolbar.Toolbar#selectButton
 * @see com.smartgwt.client.widgets.toolbar.Toolbar#deselectButton
 * @see com.smartgwt.client.widgets.form.fields.PickTreeItem#getCanSelectParentItems
 * @see com.smartgwt.client.widgets.grid.ListGrid#getSelection
 * @see com.smartgwt.client.widgets.grid.ListGrid#getSelectionAppearance
 * @see com.smartgwt.client.widgets.grid.ListGrid#getCanSelectAll
 * @see com.smartgwt.client.widgets.grid.ListGrid#getSelectionType
 * @see com.smartgwt.client.widgets.grid.ListGrid#getCanDragSelect
 * @see com.smartgwt.client.widgets.grid.ListGrid#getCanDragSelectText
 * @see com.smartgwt.client.widgets.menu.Menu#getCanSelectParentItems
 * @see com.smartgwt.client.widgets.tile.TileGrid#getSelectionType
 * @see com.smartgwt.client.types.SelectionStyle
 */
public interface Selection {
}
