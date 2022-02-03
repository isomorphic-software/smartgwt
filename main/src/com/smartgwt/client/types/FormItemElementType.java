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
 * HTML elements that make up a complete FormItem (note, not all FormItems use all of  these elements) <P>
 */
public enum FormItemElementType implements ValueEnum {
    /**
     * The form item as a whole, including the text element, any icons, and any hint text for the item. This is the cell
     * containing the  form item
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "cell".
     */
    CELL("cell"),
    /**
     * The "control" cell containing the text box and picker
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "control".
     */
    CONTROL("control"),
    /**
     * The cell containing the item's picker icon, if it has one
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "pickerIcon".
     */
    PICKER_ICON("pickerIcon"),
    /**
     * The item's native text box, if it has one
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "textBox".
     */
    TEXT_BOX("textBox"),
    /**
     * The cell containing the title
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "title".
     */
    TITLE("title");
    private String value;

    FormItemElementType(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
