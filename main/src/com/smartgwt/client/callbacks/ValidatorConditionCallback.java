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

import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.widgets.form.validator.Validator;
import java.util.Map;
import java.util.Map;

public interface ValidatorConditionCallback {

    /** 
     * {@link com.smartgwt.client.docs.Callback} required for the property {@link
     * com.smartgwt.client.widgets.form.validator.Validator#getCondition Validator.condition} and 
     * ValidatorDefinition.condition.
     *
     * @param item FormItem, DataSourceField or                                           ListGridField on which this validator was        
     * declared.  NOTE: FormItem will not                                          be available during a save performed without
     * a                                          form (eg programmatic save) or if the field                                  
     *         is not available in the form.
     * @param validator Validator declaration from eg                              {@link com.smartgwt.client.data.DataSourceField#getValidators
     * DataSourceField.validators}.
     * @param value value to validate
     * @param record Field values for record being validated.
     * @param additionalContext Object containing extra context which may be useful to the                                    condition function. 
     * Contains the following properties:<br>                    component: the DynamicForm or ListGrid being validated<br>    
     * rowNum: the row number of the cell being validated (only if component is a ListGrid)<br>                    colNum: the
     * column number of the cell being validated (only if component is a ListGrid)
     * @return whether the value passed validation.  True for passed, false for fail.
     */
	public boolean execute(DataSourceField item, Validator validator, Object value, Map record, Map additionalContext);
} 
