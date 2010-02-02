/*
 * Smart GWT (GWT for SmartClient)
 * Copyright 2008 and beyond, Isomorphic Software, Inc.
 *
 * Smart GWT is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License version 3
 * as published by the Free Software Foundation.  Smart GWT is also
 * available under typical commercial license terms - see
 * http://smartclient.com/license
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 */

package com.smartgwt.client.widgets.form;

import com.smartgwt.client.data.Record;
import com.smartgwt.client.widgets.form.fields.FormItem;


public interface FormItemValueParser {
    /**
     *
     * @param value value as entered by the user
     * @param form pointer to the dynamicForm containing this item
     * @param item pointer to this item
     *
     * @return Data value to store for this item
     */
    Object parseValue(String value, DynamicForm form, FormItem item);
}
