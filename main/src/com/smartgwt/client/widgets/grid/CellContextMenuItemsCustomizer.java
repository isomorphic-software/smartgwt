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
package com.smartgwt.client.widgets.grid;

import com.smartgwt.client.data.Record;
import com.smartgwt.client.widgets.menu.*;
import java.lang.Integer;

public interface CellContextMenuItemsCustomizer {

    /** 
     * Returns the list of MenuItems to display in a contextMenu for a specific grid-cell.
     *
     * @param record record for which menuItems are being gathered
     * @param rowNum rowNum for the passed cell
     * @param colNum colNum for the passed cell
     * @param defaultItems array of default items for the passed cell
     * @return Array of {@link com.smartgwt.client.widgets.menu.MenuItem}s for the passed cell.
     */
	public MenuItem[] getCellContextMenuItems(Record record, Integer rowNum, Integer colNum, MenuItem[] defaultItems);
} 
