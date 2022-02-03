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

import com.smartgwt.client.rpc.Project;
import com.smartgwt.client.rpc.Project;
import com.smartgwt.client.rpc.RPCResponse;

public interface LoadProjectCallback {

    /** 
     * A {@link com.smartgwt.client.docs.Callback} to evaluate after {@link com.smartgwt.client.rpc.RPCManager#loadProject
     * RPCManager.loadProject()} completes. <P> If {@link com.smartgwt.client.rpc.LoadProjectSettings#getWillHandleError
     * LoadProjectSettings.willHandleError} is set, the callback will fire even if the requested projects could not be
     * retrieved.  You can call {@link com.smartgwt.client.rpc.RPCManager#getLoadProjectErrorStatus
     * RPCManager.getLoadProjectErrorStatus()} or {@link com.smartgwt.client.rpc.RPCManager#getLoadProjectErrorMessage
     * RPCManager.getLoadProjectErrorMessage()} in this case for more information.
     *
     * @param project the first project loaded
     * @param projects array of all projects loaded
     * @param rpcResponse server response
     */
	public void execute(Project project, Project[] projects, RPCResponse rpcResponse);
} 
