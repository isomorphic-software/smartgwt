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
 
package com.smartgwt.client.widgets.form.fields;

import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.form.DynamicForm;

public interface PastedValueTransformer {

    /** 
     * Notification fired in response to a clipboard "paste" event on freeform text items, giving developers an opportunity to
     * reformat the pasted text. The  <code>pastedValue</code> argument contains the text pasted from the clipboard. This
     * method should return the text value to actually insert into the input element.
     *
     * @param item Item into which the user pasted a value
     * @param form Pointer to the item's form
     * @param pastedValue Pasted text value
     * @return Reformatted version of the pasted text.
     */
	public String transformPastedValue(FormItem item, DynamicForm form, String pastedValue);
} 
