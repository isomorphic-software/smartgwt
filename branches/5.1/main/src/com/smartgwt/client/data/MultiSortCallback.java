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

package com.smartgwt.client.data;

/**
 * Called when the user defines and accepts one or more SortSpecifiers in the {@link com.smartgwt.client.data.MultiSortDialog}. Single parameter sortLevels is an
 * Array of SortSpecifier or null if the user cancelled the dialog.
 *
 * @see com.smartgwt.client.data.MultiSortDialog#askForSort(com.smartgwt.client.widgets.DataBoundComponent, SortSpecifier[], MultiSortCallback)
 */
public interface MultiSortCallback {

    /**
     * Called when the user defines and accepts one or more SortSpecifiers. Single parameter sortLevels is an Array of SortSpecifier or null if the user cancelled the dialog.
     *
     * @param sortLevels the sortLevels
     * @see com.smartgwt.client.data.MultiSortDialog#askForSort(com.smartgwt.client.widgets.DataBoundComponent, SortSpecifier[], MultiSortCallback)
     */
    void execute(SortSpecifier[] sortLevels);
}
