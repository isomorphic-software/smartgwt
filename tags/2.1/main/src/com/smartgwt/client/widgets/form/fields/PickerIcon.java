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

    public static Picker CLEAR = new Picker("[SKIN]/pickers/clear_picker.png");
    public static Picker COMBO_BOX = new Picker("[SKIN]/pickers/comboBoxPicker.png");
    public static Picker DATE = new Picker("[SKIN]/pickers/date_picker.png");
    public static Picker REFRESH = new Picker("[SKIN]/pickers/refresh_picker.png");
    public static Picker SEARCH = new Picker("[SKIN]/pickers/search_picker.png");

    /**
     * Create a new HeaderControl with the specific icon.
     *
     * @param icon the icon
     */
    public PickerIcon(Picker icon) {
        setSrc(icon.url);
        setWidth(18);
        setHeight(22);
        setAttribute("hspace", 0);
    }

    /**
     * Create a new HeaderControl with the specific icon.
     *
     * @param icon         the icon
     * @param clickHandler the header control click handler
     */
    public PickerIcon(Picker icon, FormItemClickHandler clickHandler) {
        this(icon);
        addFormItemClickHandler(clickHandler);
    }

    public static class Picker {
        private String url;

        public Picker(String url) {
            this.url = url;
        }
    }
}
