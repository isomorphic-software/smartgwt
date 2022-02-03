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

import com.smartgwt.client.util.workflow.Process;

public interface ProcessCallback {

    /** 
     * A {@link com.smartgwt.client.docs.Callback} to evaluate when a Process has been loaded via  {@link
     * com.smartgwt.client.util.workflow.Process#loadProcess Process.loadProcess()}.
     *
     * @param process the loaded Process
     * @see com.smartgwt.client.util.workflow.Process
     * @see com.smartgwt.client.rpc.RPCResponse
     */
	public void execute(Process process);
} 
