/*
 * SmartGWT (GWT for SmartClient)
 * Copyright 2008 and beyond, Isomorphic Software, Inc.
 *
 * SmartGWT is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License version 3
 * as published by the Free Software Foundation.  SmartGWT is also
 * available under typical commercial license terms - see
 * http://smartclient.com/license
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 */
 
package com.smartgwt.client.widgets.tree.events;

import com.smartgwt.client.event.*;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;

public interface HasFolderDropHandlers extends HasHandlers {
    /**
     * Notification method fired when treeNode(s) are dropped into a folder of this TreeGrid.&#010 This method fires before the standard {@link com.smartgwt.client.widgets.tree.TreeGrid#folderDrop} processing occurs&#010 and returning false will suppress that default behavior.&#010
     *
     * @param handler the onFolderDrop handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    HandlerRegistration addFolderDropHandler(FolderDropHandler handler);
}
