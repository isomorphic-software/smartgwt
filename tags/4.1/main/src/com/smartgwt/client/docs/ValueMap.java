package com.smartgwt.client.docs;


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
 
/**
 * A ValueMap defines the set of legal values for a field, and optionally allows you to provide a mapping from stored
 * values to values as seen by the end user. <P> A valueMap can be specified as either an Array of legal values, or as an
 * {@link java.lang.Object} where each property maps a stored value to a user-displayable value.  See {@link
 * com.smartgwt.client.data.DataSourceField#getValueMap valueMap} for how to express a ValueMap in {@link
 * com.smartgwt.client.docs.ComponentXML Component XML}. <P> A ValueMap can be entirely static or entirely dynamic, with
 * many options in between.  For example, a ValueMap may be: <ul> <li> statically defined in a JavaScript or XML file. 
 * Such a valueMap changes only when application code is upgraded. <li> generated dynamically by server code when the
 * application first loads, for example, by generating JavaScript or XML dynamically in a .jsp or .asp file.  Such a
 * valueMap may be different for each session and for each user. <li> loaded on demand from a DataSource, via the 
 * optionDataSource property, or via a call to {@link com.smartgwt.client.data.DataSource#fetchData DataSource.fetchData}
 * where a valueMap is derived dynamically from the returned data (see {@link com.smartgwt.client.data.DataSource#fetchData
 * DataSource.fetchData} for an example).  Such a valueMap may be updated at any time, for example, every time the user
 * changes a related field while editing data. </ul> See also the {@link com.smartgwt.client.docs.SmartArchitecture Smart
 * GWT Architecture Overview} to understand the best architecture from a performance and caching perspective.
 */
public interface ValueMap  {
}
