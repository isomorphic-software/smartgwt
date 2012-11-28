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
 * Function to produce a summary value based on an array of records and a field definition. An example usage is the listGrid
 * summary row, where a row is shown at the bottom of the listGrid containing summary information about each column.
 *
 * @see com.smartgwt.client.types.SummaryFunctionType
 */
public interface SummaryFunction {

    /**
     * Function to produce a summary value based on an array of records and a field definition.
     * @param records the array of records
     * @param field the field definition for which the summary is required
     * @return the summary value
     */
    Object getSummaryValue(Record[] records, ListGridField field);
}
