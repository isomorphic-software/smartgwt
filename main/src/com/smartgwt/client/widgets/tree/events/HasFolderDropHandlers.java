/*
 * Smart GWT (GWT for SmartClient)
 * Copyright 2008 and beyond, Isomorphic Software, Inc.
 *
 * Smart GWT is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License version 3
 * as published by the Free Software Foundation.  Smart GWT is also
 * available under typical commercial license terms - see
 * http://smartclient.com/license
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 */
/* sgwtgen */
 
package com.smartgwt.client.widgets.tree.events;

import com.smartgwt.client.event.*;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;
public interface HasFolderDropHandlers extends HasHandlers {
    /**
     * Process a drop of one or more nodes on a TreeGrid folder.   Add logic in your drop handler to perform custom drop
     * behaviors; to suppress the built-in  behavior described below, use <code>event.cancel()</code>  <P> The default behavior
     * is to simply delegate to the {@link com.smartgwt.client.widgets.tree.TreeGrid#transferNodes transferNodes()} method;
     * thus, the  correct way to perform a programmatic folder drop, with all the built-in behaviors described below, is to
     * call <code>transferNodes()</code> <P> If this is a self-drop, nodes are simply reordered. An "update" operation will be
     * submitted to update the {@link com.smartgwt.client.widgets.tree.Tree#getParentIdField parentId} field of the moved
     * node(s).  <P> For a drop from another widget, {@link com.smartgwt.client.widgets.tree.TreeGrid#transferDragData
     * transferDragData()} is called which, depending on the {@link com.smartgwt.client.widgets.tree.TreeGrid#getDragDataAction
     * dragDataAction} specified on the source widget, may either remove the source nodes from the original list
     * (<code>dragDataAction:"move"</code>) or just provide a copy to this tree (<code>dragDataAction:"copy"</code>). <P> In
     * either case the new row(s) appear in the <code>folder</code> at the <code>index</code> specified by the arguments of the
     * same name. <P> If this grid is databound, the new nodes will be added to the dataset by calling {@link
     * com.smartgwt.client.data.DataSource#addData DataSource.addData()}.  Further, if the new nodes were dragged from another
     * databound component, and {@link com.smartgwt.client.widgets.DataBoundComponent#getAddDropValues addDropValues} is true,
     * {@link com.smartgwt.client.widgets.DataBoundComponent#getDropValues getDropValues} will be called for every item being
     * dropped. <P> As a special case, if the <code>sourceWidget</code> is also databound and a {@link
     * com.smartgwt.client.data.DataSourceField#getForeignKey foreignKey} relationship is declared from the
     * <code>sourceWidget</code>'s DataSource to this TreeGrid's DataSource, the interaction will be treated as a "drag
     * recategorization" use case such as files being placed in folders, employees being assigned to teams, etc.  "update"
     * DSRequests will be submitted that change the foreignKey field in the dropped records to point to the tree folder that
     * was the target of the drop.  In this case no change will be made to the Tree data as such, only to the dropped records. 
     * <P> For multi-record drops, Queuing is automatically used to combine all DSRequests into a single HTTP Request (see
     * QuickStart Guide, Server Framework chapter).  This allows the server to persist all changes caused by the drop in a
     * single transaction (and this is automatically done when using the built-in server DataSources with Power Edition and
     * above). <P> If these default persistence behaviors are undesirable,   use <code>event.cancel()</code>, then implement
     * your own behavior,  typically by using grid.updateData() or addData() to add new records. <p><b>NOTE:</b> the records
     * you receive in this event are the actual Records from the source component.  Use {@link
     * com.smartgwt.client.data.DataSource#copyRecords DataSource.copyRecords()} to create a copy before modifying the records
     * or using them with updateData() or addData().
     *
     * @param handler the folderDrop handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    HandlerRegistration addFolderDropHandler(FolderDropHandler handler);
}
