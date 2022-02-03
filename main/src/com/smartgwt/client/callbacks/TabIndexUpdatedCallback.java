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


public interface TabIndexUpdatedCallback {

    /** 
     * A notification {@link com.smartgwt.client.docs.Callback} fired by the TabIndexManager to allow  application code to
     * react to the numeric tab-index of some registered target being modified.
     *
     * @param ID the ID String passed to {@link com.smartgwt.client.widgets.TabIndexManager#addTarget TabIndexManager.addTarget()} when  
     *                 the callback was registered.
     */
	public void execute(String ID);
} 
