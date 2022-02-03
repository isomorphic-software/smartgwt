/*
 * Smart GWT (GWT for SmartClient)
 * Copyright 2008 and beyond, Isomorphic Software, Inc.
 *
 * Smart GWT is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License version 3
 * is published by the Free Software Foundation.  Smart GWT is also
 * available under typical commercial license terms - see
 * http://smartclient.com/license
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 */

package com.smartgwt.client.widgets.form.fields;

import com.smartgwt.client.types.PickerIconName;
import com.smartgwt.client.util.JSOHelper;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.form.fields.events.FormItemClickHandler;

/**
 * Convenience class for setting pickers for form fields. This is a specialized subclass of FormItemIcon
 * that sets up the correct picker dimensions and spacing.
 * <p>
 * A set of standard pickers are provided as a part of the library.
 *
 * @see FormItem#setIcons(FormItemIcon...)
 */
public class PickerIcon extends FormItemIcon {

    public static PickerIconName CLEAR = PickerIconName.CLEAR;
    public static PickerIconName COMBO_BOX = PickerIconName.COMBOBOX;
    public static PickerIconName DATE = PickerIconName.DATE;
    public static PickerIconName REFRESH = PickerIconName.REFRESH;
    public static PickerIconName SEARCH = PickerIconName.SEARCH;

    /**
     * Create a new FormItemIcon with the specific icon.
     *
     * @param name  the icon name
     */
    public PickerIcon(PickerIconName name) {
    	FormItemIcon icon = FormItem.getPickerIcon(name);
        if (icon != null) {
    	    JSOHelper.addProperties(getJsObj(), JSOHelper.cleanProperties(icon.getJsObj(), false));
        }
    }

    /**
     * Create a new FormItemIcon with the specific icon.
     *
     * @param name         the icon
     * @param clickHandler the header control click handler
     */
    public PickerIcon(PickerIconName name, FormItemClickHandler clickHandler) {
        this(name);
        addFormItemClickHandler(clickHandler);
    }
}
