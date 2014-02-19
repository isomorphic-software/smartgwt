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



public interface FormItemValueFormatter {
    /**
     *
     * @param value Underlying data value to format. May be null.
     * @param record The record currently being edited by this form. Essentially the form's current values object.
     * @param form pointer to the DynamicForm
     * @param item pointer to the FormItem
     *
     * @return Display value to show
     */
    String formatValue(Object value, Record record, DynamicForm form, FormItem item);
}
