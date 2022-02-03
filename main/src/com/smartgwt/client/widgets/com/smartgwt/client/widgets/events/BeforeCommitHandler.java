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

public interface BeforeCommitHandler extends EventHandler {
    /**
     * Notification method fired when the {@link com.smartgwt.client.widgets.BatchUploader#getCommitButton commitButton} is
     * clicked. <P> This notification occurs before actually committing data to the server. It allows to make changes to the
     * data after user edits, but before it will be sent to server. <P> Read also {@link
     * com.smartgwt.client.widgets.BatchUploader#addPreviewShownHandler BatchUploader.previewShown()} docs for details how to
     * change data in grid and for possibility to interrupt upload process on the server as well.
     *
     * @param event the event
     */
    void onBeforeCommit(com.smartgwt.client.widgets.com.smartgwt.client.widgets.events.BeforeCommitEvent event);
}
