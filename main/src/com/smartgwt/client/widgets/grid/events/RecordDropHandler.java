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
 
package com.smartgwt.client.widgets.grid.events;

import com.google.gwt.event.shared.EventHandler;

public interface RecordDropHandler extends EventHandler {
    /**
     * Process a drop of one or more records on a ListGrid record. <P> This method can be overridden to provide custom drop
     * behaviors, and is a more appropriate override point than the lower level {@link com.smartgwt.client.widgets.Canvas#drop
     * Canvas.drop()} handler. <P> If this is a self-drop, records are simply reordered. <P> For a drop from another widget,
     * {@link com.smartgwt.client.widgets.grid.ListGrid#transferDragData transferDragData()} is called, which depending on the
     * {@link com.smartgwt.client.widgets.grid.ListGrid#getDragDataAction dragDataAction} specified on the source widget, may
     * either remove the source records from the original list (<code>dragDataAction:"move"</code>) or just provide a copy to
     * this list (<code>dragDataAction:"copy"</code>). <P> If this grid is databound, the new records will be added to the
     * dataset by calling {@link com.smartgwt.client.data.DataSource#addData DataSource.addData()}.  Further, if the new
     * records were dragged from another databound component, and {@link
     * com.smartgwt.client.widgets.DataBoundComponent#getAddDropValues addDropValues} is true, {@link
     * com.smartgwt.client.widgets.DataBoundComponent#getDropValues getDropValues} will be called for every item being dropped.
     * <P> For multi-record drops, Queuing is automatically used to combine all DSRequests into a single HTTP Request (see
     * QuickStart Guide, Server Framework chapter).  This allows the server to persist all changes caused by the drop in a
     * single transaction (and this is automatically done when using the built-in server DataSources with Power Edition and
     * above). <P> Note that reordering records has no effect on a databound grid. <P> The newly dropped data is then selected
     * automatically. <P> If these default persistence behaviors are undesirable, Call {@link com.smartgwt.client.widgets.grid.events.RecordDropEvent#cancel()} from within {@link com.smartgwt.client.widgets.grid.events.RecordDropHandler#onRecordDrop} to cancel them, then and
     * implement your own behavior, typically by using grid.updateData() or addData() to add new records. <p><b>NOTE:</b> the
     * records you receive in this event are the actual Records from the source component.  Use {@link
     * com.smartgwt.client.data.DataSource#copyRecords DataSource.copyRecords()} to create a copy before modifying the records
     * or using them with updateData() or addData(). <P> NOTE: for a drop beyond the last visible record of a ListGrid,
     * <code>targetRecord</code> will be null and the <code>index</code> will be one higher than the last record.  This
     * includes a drop into an empty ListGrid, where <code>index</code> will be 0.
     *
     * @param event the event
     */
    void onRecordDrop(com.smartgwt.client.widgets.grid.events.RecordDropEvent event);
}
