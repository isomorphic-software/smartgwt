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

import java.util.Map;
import com.smartgwt.client.data.DataSourceField;

public interface GetFieldValueCallback {

    /** 
     * {@link com.smartgwt.client.docs.Callback} required for the property {@link
     * com.smartgwt.client.data.DataSourceField#getFieldValue DataSourceField.getFieldValue}.
     *
     * @param record record object selected from web service response data                                     by {@link
     * com.smartgwt.client.data.OperationBinding#getRecordXPath recordXPath}
     * @param value default value derived by the method described in                    {@link
     * com.smartgwt.client.data.DataSourceField#getValueXPath DataSourceField.valueXPath}
     * @param field DataSourceField definition
     * @param fieldName name of the DataSource field.
     * See {@link com.smartgwt.client.docs.FieldName FieldName}
     */
	public void execute(Map record, Object value, DataSourceField field, String fieldName);
} 
