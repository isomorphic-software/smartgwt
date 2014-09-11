/*
 * SmartGWT (GWT for SmartClient)
 * Copyright 2008 and beyond, Isomorphic Software, Inc.
 *
 * SmartGWT is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License version 3
 * as published by the Free Software Foundation.  SmartGWT is also
 * available under typical commercial license terms - see
 * http://smartclient.com/license
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 */

package com.smartgwt.client.widgets.grid;

import com.smartgwt.client.data.Record;

/**
 * Function to produce a summary value based on field values within a record. Example usage is record-level summaries in
 * "summary" type ListGrid fields.
 *
 * @see com.smartgwt.client.types.RecordSummaryFunctionType
 */
public interface RecordSummaryFunction {
    /**
     * Function to produce a summary value based on field values within a record.
     *  
     * @param record the record for which the value is being calculated
     * @param fields array of listGridFields from which summaries should be calculated
     * @param summaryField pointer to the summary type field on which the summary function is being run
     * @return summary value
     */
    Object getSummaryValue(Record record, ListGridField[] fields, ListGridField summaryField);
}
