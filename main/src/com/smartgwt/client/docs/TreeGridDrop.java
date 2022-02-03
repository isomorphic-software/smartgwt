
package com.smartgwt.client.docs;

/**
 * <h3>TreeGrid drag and drop</h3>
 * TreeGrids support drag and drop interactions to reorder or reparent nodes within the data tree,
 * or to add new data to the tree. <P> As with listGrid, drag and drop capabilities may be enabled
 * via properties such as {@link
 * com.smartgwt.client.widgets.tree.TreeGrid#getCanAcceptDroppedRecords
 * TreeGrid.canAcceptDroppedRecords},  {@link
 * com.smartgwt.client.widgets.tree.TreeGrid#getCanReorderRecords TreeGrid.canReorderRecords} and
 * {@link com.smartgwt.client.widgets.tree.TreeGrid#getCanDragRecordsOut
 * TreeGrid.canDragRecordsOut}. <P> For an overview of how the data is added or moved when a drop
 * event occurs see {@link com.smartgwt.client.widgets.tree.TreeGrid#folderDrop
 * TreeGrid.folderDrop()}.<br> For details of how data transfer to another DataBoundComponent is
 * handled, see {@link com.smartgwt.client.widgets.tree.TreeGrid#transferDragData
 * TreeGrid.transferDragData()} and {@link com.smartgwt.client.widgets.grid.ListGrid#getDragData
 * ListGrid.getDragData()}. <P> The {@link
 * com.smartgwt.client.widgets.tree.TreeGrid#getShowDropIcons TreeGrid.showDropIcons} and {@link
 * com.smartgwt.client.widgets.layout.Layout#getShowDropLines ListGrid.showDropLines} enable 
 * customization of the grid appearance during drag interactions. <P> By default users may drop
 * data after the last node in the grid. The  {@link
 * com.smartgwt.client.widgets.tree.TreeGrid#getCanDropSiblingAfterLastNode
 * TreeGrid.canDropSiblingAfterLastNode} feature allows data to be added as either  a sibling of
 * the last node, or to the tree's root node. The {@link
 * com.smartgwt.client.widgets.tree.TreeGrid#getShowDropEndSpace TreeGrid.showDropEndSpace} 
 * causes a spacer to be written out after the last node during drag, so there is space  available
 * to accept the drop even if the data fills the TreeGrid viewport. To entirely disable this
 * behavior, set {@link com.smartgwt.client.widgets.grid.ListGrid#getCanDropInEmptyArea
 * ListGrid.canDropInEmptyArea} to false
 * @see com.smartgwt.client.widgets.tree.TreeGrid#willAcceptDrop
 * @see com.smartgwt.client.widgets.tree.events.FolderDropEvent
 * @see com.smartgwt.client.widgets.tree.TreeGrid#folderDrop
 * @see com.smartgwt.client.widgets.tree.TreeGrid#transferNodes
 * @see com.smartgwt.client.widgets.tree.TreeGrid#getCanDragRecordsOut
 * @see com.smartgwt.client.widgets.tree.TreeGrid#getCanAcceptDroppedRecords
 * @see com.smartgwt.client.widgets.tree.TreeGrid#getCanReorderRecords
 * @see com.smartgwt.client.widgets.tree.TreeGrid#getCanDropOnLeaves
 * @see com.smartgwt.client.widgets.tree.TreeGrid#getCanReparentNodes
 * @see com.smartgwt.client.widgets.tree.TreeGrid#getDragDataAction
 * @see com.smartgwt.client.widgets.tree.TreeGrid#getShowDropEndSpace
 */
public interface TreeGridDrop {
}
