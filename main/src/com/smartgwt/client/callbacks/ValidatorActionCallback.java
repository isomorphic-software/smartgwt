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
import com.smartgwt.client.data.Record;
import com.smartgwt.client.widgets.DataBoundComponent;

public interface ValidatorActionCallback {

    /** 
     * {@link com.smartgwt.client.docs.Callback} required for the property  ValidatorDefinition.action.
     *
     * @param result The result of the validator. The value will be null if                              the validator was skipped because of
     * conditional criteria.
     * @param item FormItem or DataSourceField on which this                                          validator was declared.  NOTE:
     * FormItem will not                                          be available during a save performed without a               
     *      form (eg programmatic save) or if the field                                           is not available in the form.
     * @param validator Validator declaration from eg                              {@link com.smartgwt.client.data.DataSourceField#getValidators
     * DataSourceField.validators}.
     * @param record Record that was validated
     * @param component The DataBoundComponent holding the item such                                       DynamicForm or ListGrid.
     */
	public void execute(boolean result, DataSourceField item, Validator validator, Record record, DataBoundComponent component);
} 
