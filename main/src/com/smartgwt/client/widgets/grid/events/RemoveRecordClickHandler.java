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
 
package com.smartgwt.client.widgets.grid.events;

import com.google.gwt.event.shared.EventHandler;

public interface RemoveRecordClickHandler extends EventHandler {
    /**
     * Handler fired when the user clicks the "remove" icon if {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getCanRemoveRecords canRemoveRecords} is true. Default behavior will remove
     * the record from the data set, or if we're {@link com.smartgwt.client.widgets.grid.ListGrid#getDeferRemoval deferring
     * removal} mark record as removed [or for records already  marked as removed, clear this removed marker]. <P> If {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getWarnOnRemoval warnOnRemoval} is set, this method will also show a warning
     * dialog to users allowing them to cancel the removal. <P> This event may be cancelled to suppress the default behavior.
     *
     * @param event the event
     */
    void onRemoveRecordClick(com.smartgwt.client.widgets.grid.events.RemoveRecordClickEvent event);
}
