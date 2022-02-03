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
 * Dictates the appearance of form items when {@link com.smartgwt.client.widgets.form.fields.FormItem#getCanEdit
 * FormItem.canEdit} is set to <code>false</code>.
 */
public enum ReadOnlyDisplayAppearance implements ValueEnum {
    /**
     * Item value should appear within the form as a static block of text, similar to the default appearance of a {@link
     * com.smartgwt.client.widgets.form.fields.StaticTextItem}. This appearance may be modified via {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getReadOnlyTextBoxStyle FormItem.readOnlyTextBoxStyle} and {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getClipStaticValue FormItem.clipStaticValue}.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "static".
     */
    STATIC("static"),
    /**
     * Item should appear unchanged, but user interaction to edit the item will be disallowed. Note that some interactions will
     * be allowed, such as selecting text within a read-only {@link com.smartgwt.client.widgets.form.fields.TextItem} for copy
     * and paste. Exact implementation may vary by form item type.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "readOnly".
     */
    READONLY("readOnly"),
    /**
     * Item will appear disabled.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "disabled".
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
