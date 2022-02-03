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

package com.smartgwt.client.widgets;

import com.smartgwt.client.data.Record;

/**
 * Called when the transferRecords() method completes.  A callback is necessary because transferRecords() is an asynchronous process that may require
 * one or more server roundtrips
 *
 * @see com.smartgwt.client.DataBoundComponent#transferRecords(Record[], Record, int, Canvas, TransferRecordsCallback)
 */
public interface TransferRecordsCallback {

    /**
     * Called when the transferRecords() method completes.  A callback is necessary because transferRecords() is asynchronous 
     *
     * @param records the nodes we just transferred
     */
    void execute(Record[] records);
}
