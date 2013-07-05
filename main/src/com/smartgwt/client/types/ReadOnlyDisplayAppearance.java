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
 
/**
 * Dictates the appearance of FormItems when {@link com.smartgwt.client.widgets.form.fields.FormItem#getCanEdit canEdit} is
 * set to <code>false</code>.
 */
public enum ReadOnlyDisplayAppearance implements ValueEnum {
    /**
     * Item value should appear within the form as a static block of text, similar to the default appearance of a {@link
     * com.smartgwt.client.widgets.form.fields.StaticTextItem}. Appearance may be modified via {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getReadOnlyTextBoxStyle readOnlyTextBoxStyle} and {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getReadOnlyClipValue readOnlyClipValue}.
     */
    STATIC("static"),
    /**
     * Item should appear unchanged, but user interaction to edit the item will be disallowed. Note that some interactions will
     * be allowed, such as selecting text within a read-only TextItem for copy and paste. Exact implementation may vary by
     * FormItem type.
     */
    READONLY("readonly"),
    /**
     * Item will appear disabled when marked as <code>canEdit:false</code>.
     */
    DISABLED("disabled");
    private String value;

    ReadOnlyDisplayAppearance(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
