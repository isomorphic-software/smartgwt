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
import com.smartgwt.client.data.DSRequest;

public interface HasFileCallback {

    /** 
     * A {@link com.smartgwt.client.docs.Callback} fired when {@link com.smartgwt.client.data.DataSource#hasFile
     * DataSource.hasFile} completes.
     *
     * @param dsResponse A {@link com.smartgwt.client.data.DSResponse} instance with metadata about the                                returned
     * data.
     * @param data Whether the file exists.
     * @param dsRequest The {@link com.smartgwt.client.data.DSRequest} that was sent.
     */
	public void execute(DSResponse dsResponse, boolean data, DSRequest dsRequest);
} 
