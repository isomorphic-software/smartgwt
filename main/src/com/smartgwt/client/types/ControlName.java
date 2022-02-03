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
 * {@link com.smartgwt.client.widgets.RichTextEditor#getStyleControls RichTextEditor.styleControls} to control the order in
 * which controls appear, to omit default controls or to show controls that are not shown by default. <p> Every
 * <code>ControlName</code> is also the name of an {@link com.smartgwt.client.types.AutoChild}, so all the built-in
 * controls can be skinned or otherwise customized via the {@link com.smartgwt.client.docs.AutoChildUsage AutoChild
 * system}. Note that the AutoChild name in each case is the camelCaps version of the <code>ControlName</code> value.  For
 * example, use "boldSelection" as the name of the AutoChild for the bold button, not "BOLDSELECTION".
 */
public enum ControlName implements ValueEnum {
    /**
     * A button to make the current selection bold.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "boldSelection".
     */
    BOLDSELECTION("boldSelection"),
    /**
     * A button to make the current selection italic.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "italicSelection".
     */
    ITALICSELECTION("italicSelection"),
    /**
     * A button to make the current selection underlined.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "underlineSelection".
     */
    UNDERLINESELECTION("underlineSelection"),
    /**
     * A select item allowing the user to change the font of the current text selection.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "fontSelector".
     */
    FONTSELECTOR("fontSelector"),
    /**
     * A select item allowing the user to change the font size of the current text selection.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "fontSizeSelector".
     */
    FONTSIZESELECTOR("fontSizeSelector"),
    /**
     * A button to left-align the selected text.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "alignLeft".
     */
    ALIGNLEFT("alignLeft"),
    /**
     * A button to right-align the selected text.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "alignRight".
     */
    ALIGNRIGHT("alignRight"),
    /**
     * A button to center the selected text.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "alignCenter".
     */
    ALIGNCENTER("alignCenter"),
    /**
     * A button to justify the selected line of text.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "justify".
     */
    JUSTIFY("justify"),
    /**
     * A color-picker allowing the user to set the text color.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "color".
     */
    COLOR("color"),
    /**
     * A color picker allowing the user to set the text background color.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "backgroundColor".
     */
    BACKGROUNDCOLOR("backgroundColor"),
    /**
     * Within text, indents the paragraph. Within a list, increases the list level.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "indent".
     */
    INDENT("indent"),
    /**
     * Within text, outdents the paragraph. Within a list, decreases the list level.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "outdent".
     */
    OUTDENT("outdent"),
    /**
     * Turns the current selection into an ordered list (HTML &lt;ol&gt;) or converts an unordered list to an ordered list.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "orderedList".
     */
    ORDEREDLIST("orderedList"),
    /**
     * Turns the current selection into an unordered list (HTML &lt;ul&gt;) or converts an ordered list to an unordered list.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "unorderedList".
     */
    UNORDEREDLIST("unorderedList"),
    /**
     * Shows the {@link com.smartgwt.client.widgets.RichTextEditor#getListPropertiesDialog listPropertiesDialog} to allow
     * configuring the options of the currently selected HTML list.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "listProperties".
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
