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

import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.util.workflow.Process;

public interface ProcessCallback {

    /** 
     * A {@link com.smartgwt.client.docs.Callback} to evaluate when an {Process.loadProcess} method completes. <p> Loaded
     * process passed as a parameter to this callback are:
     *
     * @param dsResponse a {@link com.smartgwt.client.data.DSResponse} instance with metadata about the returned data
     * @param process 
     */
	public void execute(DSResponse dsResponse, Process process);
} 
