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

import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DSRequest;

public interface DSCallback {

    /** 
     * Callback fired when DataSource methods that send DSRequests complete (such as {@link
     * com.smartgwt.client.data.DataSource#fetchData DataSource.fetchData}).
     *
     * @param dsResponse a {@link com.smartgwt.client.data.DSResponse} instance with metadata about the returned data
     * @param data data returned to satisfy the DataSource request. See the         {@link com.smartgwt.client.docs.DataSourceOperations
     * DataSource operations} topic for expected results        for each type of DataSource operation
     * @param dsRequest the {@link com.smartgwt.client.data.DSRequest} that was sent. You can use        {@link
     * com.smartgwt.client.data.DSRequest#getClientContext clientContext} to track state during the server turnaround.
     */
	public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest);
} 
