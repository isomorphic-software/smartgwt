
package com.smartgwt.client.docs;

/**
 * <h3>Selection</h3>
 * APIs for marking {@link com.smartgwt.client.data.Record}s as selected and retrieving the
 * selected record or records. <P> Only applicable to a {@link
 * com.smartgwt.client.widgets.DataBoundComponent} that manages a list of Records, or manages a
 * data model that can be viewed as a list (for example, the current list of visible nodes on a
 * tree can be treated as a list for selection purposes).
 * @see com.smartgwt.client.types.SelectionStyle
 * @see com.smartgwt.client.widgets.cube.CubeGrid#getEventRow
 * @see com.smartgwt.client.widgets.cube.CubeGrid#getEventColumn
 * @see com.smartgwt.client.widgets.cube.events.FacetValueSelectionChangedEvent
 * @see com.smartgwt.client.widgets.cube.CubeGrid#getSelectedCells
 * @see com.smartgwt.client.widgets.cube.CubeGrid#getSelectedCellIds
 * @see com.smartgwt.client.widgets.cube.CubeGrid#anyCellSelected
 * @see com.smartgwt.client.widgets.cube.CubeGrid#cellIsSelected
 * @see com.smartgwt.client.widgets.cube.CubeGrid#selectCell
 * @see com.smartgwt.client.widgets.cube.CubeGrid#deselectCell
 * @see com.smartgwt.client.widgets.cube.CubeGrid#selectCells
 * @see com.smartgwt.client.widgets.cube.CubeGrid#deselectCells
 * @see com.smartgwt.client.widgets.cube.CubeGrid#selectAllCells
 * @see com.smartgwt.client.widgets.cube.CubeGrid#deselectAllCells
 * @see com.smartgwt.client.widgets.cube.CubeGrid#getSelectedFacetValues
 * @see com.smartgwt.client.widgets.cube.CubeGrid#facetValuesSelected
 * @see com.smartgwt.client.widgets.cube.CubeGrid#facetHasSelection
 * @see com.smartgwt.client.widgets.cube.CubeGrid#getFacetsHavingSelection
 * @see com.smartgwt.client.widgets.cube.CubeGrid#selectFacetValues
 * @see com.smartgwt.client.widgets.cube.CubeGrid#deselectFacetValues
 * @see com.smartgwt.client.widgets.cube.CubeGrid#selectFacetValue
 * @see com.smartgwt.client.widgets.cube.CubeGrid#deselectFacetValue
 * @see com.smartgwt.client.widgets.cube.CubeGrid#selectAllFacetValues
 * @see com.smartgwt.client.widgets.cube.CubeGrid#deselectAllFacetValues
 * @see com.smartgwt.client.widgets.cube.CubeGrid#deselectAll
 * @see com.smartgwt.client.widgets.cube.CubeGrid#cellSelectionChanged
 * @see com.smartgwt.client.widgets.grid.ListGrid#getSelectedRecord
 * @see com.smartgwt.client.widgets.grid.ListGrid#getSelectedRecords
 * @see com.smartgwt.client.widgets.grid.ListGrid#isSelected
 * @see com.smartgwt.client.widgets.grid.ListGrid#isPartiallySelected
 * @see com.smartgwt.client.widgets.grid.ListGrid#selectRecord
 * @see com.smartgwt.client.widgets.grid.ListGrid#deselectRecord
 * @see com.smartgwt.client.widgets.grid.ListGrid#selectRecords
 * @see com.smartgwt.client.widgets.grid.ListGrid#deselectRecords
 * @see com.smartgwt.client.widgets.grid.ListGrid#deselectAllRecords
 * @see com.smartgwt.client.widgets.grid.ListGrid#selectRange
 * @see com.smartgwt.client.widgets.grid.ListGrid#deselectRange
 * @see com.smartgwt.client.widgets.grid.ListGrid#anySelected
 * @see com.smartgwt.client.widgets.grid.ListGrid#selectSingleRecord
 * @see com.smartgwt.client.widgets.grid.events.CellSelectionChangedEvent
 * @see com.smartgwt.client.widgets.grid.events.SelectionEvent
 * @see com.smartgwt.client.widgets.grid.events.SelectionUpdatedEvent
 * @see com.smartgwt.client.widgets.grid.ListGrid#getSelection
 * @see com.smartgwt.client.widgets.tile.TileGrid#getSelection
 * @see com.smartgwt.client.widgets.tile.TileGrid#getSelectedRecord
 * @see com.smartgwt.client.widgets.tile.TileGrid#selectRecord
 * @see com.smartgwt.client.widgets.tile.TileGrid#deselectRecord
 * @see com.smartgwt.client.widgets.tile.TileGrid#selectRecords
 * @see com.smartgwt.client.widgets.tile.TileGrid#selectRange
 * @see com.smartgwt.client.widgets.tile.TileGrid#deselectRecords
 * @see com.smartgwt.client.widgets.tile.TileGrid#deselectRange
 * @see com.smartgwt.client.widgets.tile.TileGrid#selectAllRecords
 * @see com.smartgwt.client.widgets.tile.TileGrid#deselectAllRecords
 * @see com.smartgwt.client.widgets.tile.TileGrid#anySelected
 * @see com.smartgwt.client.widgets.tile.events.SelectionChangedEvent
 * @see com.smartgwt.client.widgets.grid.ColumnTree#selectRecord
 * @see com.smartgwt.client.widgets.grid.ColumnTree#deselectRecord
 * @see com.smartgwt.client.widgets.grid.ColumnTree#selectRecords
 * @see com.smartgwt.client.widgets.grid.ColumnTree#deselectRecords
 * @see com.smartgwt.client.widgets.grid.ColumnTree#selectAllRecords
 * @see com.smartgwt.client.widgets.grid.ColumnTree#deselectAllRecords
 * @see com.smartgwt.client.widgets.grid.ColumnTree#anySelected
 * @see com.smartgwt.client.widgets.grid.CellSelection#cellIsSelected
 * @see com.smartgwt.client.widgets.grid.CellSelection#anySelected
 * @see com.smartgwt.client.widgets.grid.CellSelection#getSelectedCells
 * @see com.smartgwt.client.widgets.grid.CellSelection#getSelectedRecord
 * @see com.smartgwt.client.widgets.grid.CellSelection#selectionChanged
 * @see com.smartgwt.client.widgets.grid.CellSelection#selectCell
 * @see com.smartgwt.client.widgets.grid.CellSelection#deselectCell
 * @see com.smartgwt.client.widgets.grid.CellSelection#selectCellList
 * @see com.smartgwt.client.widgets.grid.CellSelection#deselectCellList
 * @see com.smartgwt.client.widgets.grid.CellSelection#selectSingleCell
 * @see com.smartgwt.client.widgets.toolbar.Toolbar#selectButton
 * @see com.smartgwt.client.widgets.toolbar.Toolbar#deselectButton
 * @see com.smartgwt.client.widgets.grid.ListGrid#getSelection
 * @see com.smartgwt.client.widgets.grid.ListGrid#getSelectionManager
 * @see com.smartgwt.client.widgets.grid.ListGrid#getSelectionAppearance
 * @see com.smartgwt.client.widgets.grid.ListGrid#getCanSelectAll
 * @see com.smartgwt.client.widgets.grid.ListGrid#getShowHeaderPartialSelection
 * @see com.smartgwt.client.widgets.grid.ListGrid#getCanSelectGroups
 * @see com.smartgwt.client.widgets.grid.ListGrid#getShowPartialSelection
 * @see com.smartgwt.client.widgets.grid.ListGrid#getDeselectOnPartialCheckboxClick
 * @see com.smartgwt.client.widgets.grid.ListGrid#getSelectionType
 * @see com.smartgwt.client.widgets.grid.ListGrid#getSelectionProperty
 * @see com.smartgwt.client.widgets.grid.ListGrid#getCanDragSelect
 * @see com.smartgwt.client.widgets.grid.ListGrid#getCanDragSelectText
 * @see com.smartgwt.client.widgets.tree.TreeGrid#getSelectionProperty
 * @see com.smartgwt.client.widgets.tree.TreeGrid#getCanSelectAll
 * @see com.smartgwt.client.widgets.menu.Menu#getCanSelectParentItems
 * @see com.smartgwt.client.widgets.tile.TileGrid#getSelectionType
 * @see com.smartgwt.client.widgets.form.fields.PickTreeItem#getCanSelectParentItems
 */
public interface Selection {
}
