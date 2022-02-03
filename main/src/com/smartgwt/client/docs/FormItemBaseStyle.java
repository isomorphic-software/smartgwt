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
 * This string is the base CSS class name applied to a FormItem  (or some part of a form item).  See the {@link
 * com.smartgwt.client.docs.FormItemStyling formItem styling overview} for more information about styling formItems. <P>
 * The specified style name will be modified as the 'state' of the form item changes.  Developers should provide
 * appropriately named CSS classes for each stateful style described below:<ul> <li>If {@link
 * com.smartgwt.client.widgets.form.fields.FormItem#getShowPending FormItem.showPending} is true, when the current value
 * differs from the     value that would be restored by a call to {@link
 * com.smartgwt.client.widgets.form.DynamicForm#resetValues DynamicForm.resetValues()}, this style     will have the suffix
 * "Pending"  appended to it.</li> <li>If {@link com.smartgwt.client.widgets.form.fields.FormItem#getShowFocused
 * FormItem.showFocused} is true, when the form item receives focus, this     style will have the suffix "Focused" appended
 * to it.</li> <li>If {@link com.smartgwt.client.widgets.form.fields.FormItem#getShowOver FormItem.showOver} is true,
 * roll-over will be indicated by appending the     suffix "Over" appended to the style name. This applies to the    
 * {@link com.smartgwt.client.widgets.form.fields.FormItem#getTextBoxStyle textBoxStyle} and     {@link
 * com.smartgwt.client.widgets.form.fields.FormItem#getControlStyle controlStyle} only.</li> <li>If {@link
 * com.smartgwt.client.widgets.form.fields.FormItem#getShowErrorStyle FormItem.showErrorStyle} is true, if the form item
 * has errors, this     style will have the suffix "Error" appended to it.</li> <li>If {@link
 * com.smartgwt.client.widgets.form.fields.FormItem#getShowDisabled FormItem.showDisabled} is true, when the form item is
 * disabled, this     style will have the suffix "Disabled" appended to it.</li> <li>Finally, if {@link
 * com.smartgwt.client.widgets.form.fields.FormItem#getShowRTL FormItem.showRTL} is true, when the form item is in RTL
 * mode, this     style will have the suffix "RTL" appended to it.</ul> So for example if the cellStyle for some form item
 * is set to "formCell" and showFocused is true, when the form item receives focus, the form item's cell will have the
 * "formCellFocused" style applied to it.
 */
public interface FormItemBaseStyle  {
}
