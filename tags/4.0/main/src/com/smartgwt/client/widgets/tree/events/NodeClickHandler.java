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
 
package com.smartgwt.client.widgets.tree.events;

import com.google.gwt.event.shared.EventHandler;

public interface NodeClickHandler extends EventHandler {
    /**
     * This method is called when a leaf or folder record is clicked on.  Note that if you set up a callback for
     * <code>nodeClick()</code> and e.g. {@link com.smartgwt.client.widgets.tree.TreeGrid#addLeafClickHandler
     * TreeGrid.leafClick}, then both will fire (in that order) if a leaf is clicked on.
     *
     * @param event the event
     */
    void onNodeClick(com.smartgwt.client.widgets.tree.events.NodeClickEvent event);
}
