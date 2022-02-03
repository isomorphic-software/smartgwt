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
 
package com.smartgwt.client.widgets.com.smartgwt.client.widgets.events;

import com.google.gwt.event.shared.EventHandler;

public interface PreviewShownHandler extends EventHandler {
    /**
     * Notification method fired when the {@link com.smartgwt.client.widgets.BatchUploader#getGrid grid} is populated with a
     * new set of data for the user to preview before commit. <P> This notification occurs after the user has uploaded a new
     * data file, the data has been processed on the server, and the preview grid populated with the data ready for committing.
     * Developers may use this notification to examine or modify the data set to be uploaded. The {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getData ListGrid.data} object will be populated with the array of uploaded
     * records, and standard grid APIs such as  {@link com.smartgwt.client.widgets.grid.ListGrid#getRowErrors
     * ListGrid.getRowErrors()}, {@link com.smartgwt.client.widgets.grid.ListGrid#setEditValue ListGrid.setEditValue()}, etc
     * may be used  to interact with this data. <P> Note that developers wishing to manipulate the uploaded data can also do
     * this on the server side when user hits the commit button to submit the data to the {@link
     * com.smartgwt.client.widgets.BatchUploader#getUploadDataSource uploadDataSource}. This can be achieved by setting the 
     * {@link com.smartgwt.client.widgets.BatchUploader#getUploadOperation uploadOperation} to call a custom  {@link
     * com.smartgwt.client.data.DataSource#getOperationBindings "add" type operation} on the target dataSource.
     *
     * @param event the event
     */
    void onPreviewShown(com.smartgwt.client.widgets.com.smartgwt.client.widgets.events.PreviewShownEvent event);
}
