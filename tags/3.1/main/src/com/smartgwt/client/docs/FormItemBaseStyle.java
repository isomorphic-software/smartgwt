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
 
/**
 * This string is the base css class name applied to a FormItem (or some part of a form item). The style name will be
 * modified as the 'state' of the form item changes. Specifically:<ul> <li>If {@link
 * com.smartgwt.client.widgets.form.fields.FormItem#getShowFocused showFocused} is true, when the form item receives focus,
 * this     style will be have the suffix <code>"Focused"</code> appended to it.</li> <li>If {@link
 * com.smartgwt.client.widgets.form.fields.FormItem#getShowErrorStyle showErrorStyle} is true, if the form item has errors,
 * this     style will be have the suffix <code>"Error"</code> appended to it.</li> <li>If {@link
 * com.smartgwt.client.widgets.form.fields.FormItem#getShowDisabled showDisabled} is true, when the form item is disabled,
 * this     style will be have the suffix <code>"Disabled"</code> appended to it.</li></ul> So for example if the
 * <code>cellStyle</code> for some form item is set to <code>"formCell"</code> and <code>FormItem.showFocused</code> is
 * true, when the form item receives focus, the form item's cell will have the <code>"formCellDisabled"</code> style
 * applied to it.
 */
public interface FormItemBaseStyle  {
}
        
