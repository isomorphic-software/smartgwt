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
package com.smartgwt.client.widgets;

import com.smartgwt.client.data.Record;

public interface DragDataCustomizer {

    /** 
     * During a drag-and-drop interaction, this method returns the set of records being dragged
     * out of the component.  In the default implementation, this is the list of currently
     * selected records.
     * <p>
     * This method is consulted by
     * {@link com.smartgwt.client.widgets.grid.ListGrid#willAcceptDrop willAcceptDrop()}.
     *
     * @param source source component from which the records will be transferred
     * @return Array of {@link com.smartgwt.client.data.Record}s that are currently selected.
     */
	public Record[] getDragData(DataBoundComponent source);
} 
