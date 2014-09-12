package com.smartgwt.client.types;


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
 * For PickList items with {@link com.smartgwt.client.types.PickListItemIconPlacement} set such that the pickList does not
 * render near-origin, possible location for rendering formItemIcons.
 */
public enum PickListItemIconPlacement implements ValueEnum {
    /**
     * icon will be displayed in the {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem#getPickerNavigationBar
     * pickerNavigationBar} only (and not rendered inline within the formItem itself)
     */
    PICKERNAVIGATIONBAR("pickerNavigationBar"),
    /**
     * icon will be displayed inline within the form item itself (and not within the {@link
     * com.smartgwt.client.widgets.form.fields.ComboBoxItem#getPickerNavigationBar pickerNavigationBar}
     */
    FORMITEM("formItem"),
    /**
     * icon will be displayed both inline (within the form item itself) and within the {@link
     * com.smartgwt.client.widgets.form.fields.ComboBoxItem#getPickerNavigationBar pickerNavigationBar}
     */
    BOTH("both");
    private String value;

    PickListItemIconPlacement(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
