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
 
package com.smartgwt.client.widgets.grid;

import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridRecord;

public interface GroupSortNormalizer {

    /** 
     * When {@link com.smartgwt.client.widgets.grid.ListGrid#getSortByGroupFirst sortByGroupFirst} is active, the sorting 
     * {@link com.smartgwt.client.data.SortSpecifier#getNormalizer normalizer} applied for implicit sorting by the field(s)
     * used for grouping. <P> No default implementation.
     *
     * @param record record to normalize
     * @param fieldName name of the field on which sorting occurred.
     * See {@link com.smartgwt.client.docs.FieldName FieldName}
     * @param context the grid is passed to allow property and method access
     * @return normalized value for sorting
     * @see com.smartgwt.client.widgets.grid.ListGrid#setSortByGroupFirst
     * @see com.smartgwt.client.widgets.grid.ListGrid#setGroupSortDirection
     */
	public Object normalize(ListGridRecord record, String fieldName, ListGrid context);
} 
