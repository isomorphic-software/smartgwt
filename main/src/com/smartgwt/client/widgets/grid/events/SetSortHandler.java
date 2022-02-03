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

public interface SetSortHandler extends EventHandler {
    /**
     * Optional notification fired when either user or framework code calls 
     * {@link com.smartgwt.client.widgets.grid.ListGrid#setSort setSort()}.  This notification fires before the default
     * behavior; 
     *  
     *  use <code>event.cancel()</code> to cancel the default behavior.  Note,
     *  the notification is fired before the default functionality, but <em>after</em> prechecks 
     *  have completed; your method will only be called if the default behavior would have been
     *  called.  For example, if there are pending edits and the user does not confirm that these 
     *  should be saved, normal sorting would not have gone ahead, so equally your handler will 
     *  not be called.
     *  <P>
     *  The default <code>setSort()</code> method does two things to reflect the set of 
     *  {@link com.smartgwt.client.data.SortSpecifier sortSpecifier}s passed to it:<ul>
     *  <li>Change the grid UI (show directional arrows, numerals to indicate sort priority, etc)</li>
     *  <li>Actually sort the grid data</li>
     *  </ul>
     *  If your reason for implementing a custom <code>setSortHandler()</code> is to inhibit or 
     *  replace one of those behaviors, you should cancel the default behavior and directly invoke
     *  just that part of it you require.  The following implementation will replicate the default
     *  behavior:
     *  <pre>
     *    grid.addSetSortHandler(new SetSortHandler() {
     *        public void onSetSort(SetSortEvent event) {
     *            displaySort(event.getSortSpecifiers());
     *            applySortToData(event.getSortSpecifiers());
     *            event.cancel();  // Prevent the framework from running its own default impl
     *        }
     *    });</pre>
     * 
     * 
     *
     * @param event the event
     */
    void onSetSort(com.smartgwt.client.widgets.grid.events.SetSortEvent event);
}
