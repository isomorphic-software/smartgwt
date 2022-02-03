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
 
package com.smartgwt.client.callbacks;


public interface ShiftFocusCallback {

    /** 
     * A {@link com.smartgwt.client.docs.Callback} fired by the TabIndexManager when application code or user action attempts
     * to synthetically shift focus to some registered target.  See {@link
     * com.smartgwt.client.widgets.TabIndexManager#shiftFocus TabIndexManager.shiftFocus()}. <P> A typical implementation will
     * shift focus to some native element associated with the registered target, or if this is not currently possible, return
     * false.
     *
     * @param ID The ID String passed to {@link com.smartgwt.client.widgets.TabIndexManager#addTarget TabIndexManager.addTarget()} when  
     *                 the callback was registered.
     * @return Return true if focus could be successfully moved to the desired                  target. Returning false indicates the
     * target could not accept focus and                  will often cause the TabIndexManager to find the next registered
     * target                  and attempt to shift focus there.
     */
	public boolean execute(String ID);
} 
