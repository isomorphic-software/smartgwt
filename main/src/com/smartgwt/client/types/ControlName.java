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
 * Names for the standard controls built into the RichTextEditor.  You can use these <code>ControlNames</code> in APIs like
 * {@link com.smartgwt.client.widgets.RichTextEditor#getStyleControls styleControls} to control the order in which controls
 * appear, to omit default controls or to show controls that are not shown by default. <p> Every <code>ControlName</code>
 * is also the name of an {@link com.smartgwt.client.types.AutoChild}, so all the built-in controls can be skinned or
 * otherwise customized via the {@link com.smartgwt.client.docs.AutoChildUsage AutoChild system}. Note that the AutoChild
 * name in each case is the camelCaps version of the <code>ControlName</code> value.  For example, use "boldSelection" as
 * the name of the AutoChildren for the bold button, not "BOLDSELECTION".
 */
public enum ControlName implements ValueEnum {
    /**
     * A button to make the current selection bold.
     */
    BOLDSELECTION("boldSelection"),
    /**
     * A button to make the current selection italic.
     */
    ITALICSELECTION("italicSelection"),
    /**
     * A button to make the current selection underlined.
     */
    UNDERLINESELECTION("underlineSelection"),
    /**
     * A select item allowing the user to change the font of the current text selection.
     */
    FONTSELECTOR("fontSelector"),
    /**
     * A select item allowing the user to change the font size of the current text selection.
     */
    FONTSIZESELECTOR("fontSizeSelector"),
    /**
     * A button to left-align the selected text.
     */
    ALIGNLEFT("alignLeft"),
    /**
     * A button to right-align the selected text.
     */
    ALIGNRIGHT("alignRight"),
    /**
     * A button to center the selected text.
     */
    ALIGNCENTER("alignCenter"),
    /**
     * A button to justify the selected line of text.
     */
    JUSTIFY("justify"),
    /**
     * A color-picker allowing the user to set the text color.
     */
    COLOR("color"),
    /**
     * A color picker allowing the user to set the text background color.
     */
    BACKGROUNDCOLOR("backgroundColor"),
    /**
     * Within text, indents the paragraph. Within a list, increases the list level.
     */
    INDENT("indent"),
    /**
     * Within text, outdents the paragraph. Within a list, decreases the list level.
     */
    OUTDENT("outdent"),
    /**
     * Turns the current selection into an ordered list (HTML &lt;ol&gt;) or converts an unordered list to an ordered list.
     */
    ORDEREDLIST("orderedList"),
    /**
     * Turns the current selection into an unordered list (HTML &lt;ul&gt;) or converts an ordered list to an unordered list.
     */
    UNORDEREDLIST("unorderedList"),
    /**
     * Shows the {@link com.smartgwt.client.widgets.RichTextEditor#getListPropertiesDialog listPropertiesDialog} to allow
     * configuring the options of the currently selected HTML list.
     */
    LISTPROPERTIES("listProperties");
    private String value;

    ControlName(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
