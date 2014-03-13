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

import com.smartgwt.client.util.JSOHelper;

public class ListGridRemoveField extends ListGridField {
    public ListGridRemoveField(ListGrid referenceListGrid, String name) {
        this(referenceListGrid, name, referenceListGrid.getRemoveFieldTitle());
    }

    public ListGridRemoveField(ListGrid referenceListGrid, String name, String title) {
        this(referenceListGrid, name, title, JSOHelper.getAttributeAsInt(referenceListGrid.getRemoveFieldDefaults(), "width"));
    }

    public ListGridRemoveField(ListGrid referenceListGrid, String name, String title, int width) {
        super(referenceListGrid.getRemoveFieldDefaults());
        setName(name);
        setTitle(title);
        setWidth(width);
        setCellIcon("[SKIN]/actions/remove.png");
        setIconWidth(16);
        setIconHeight(16);
    }
}
