/*
 * SmartGWT (GWT for SmartClient)
 * Copyright 2008 and beyond, Isomorphic Software, Inc.
 *
 * SmartGWT is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License version 3
 * as published by the Free Software Foundation.  SmartGWT is also
 * available under typical commercial license terms - see
 * http://smartclient.com/license
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 */

package com.smartgwt.client.types;

/**
 * ListGrids format data for viewing and editing based on the <i>type</i> attribute of the&#010 field.  This table
 * describes how the ListGrid deals with the various built-in types.
 */

public enum ListGridFieldType implements ValueEnum {
    /**
     * Simple text rendering for view.  For editing a text entry field is shown. If the length of the field (as
     * specified by the {@link com.smartgwt.client.data.DataSourceField#setLength(Integer) length} &#010 attribute) is larger than the
     * value specified by {@link com.smartgwt.client.widgets.grid.ListGrid#setLongTextEditorThreshold(int) longTextEditorThreshold}, a&#010 text input icon is
     * shown that, when clicked on (or field is focused in) opens a larger&#010 editor that expands outside the
     * boundaries of the cell (textarea by default, but&#010 overrideable via {@link com.smartgwt.client.widgets.grid.ListGrid#setLongTextEditorType(String) longTextEditorType}.
     */
    TEXT("text"),
    /**
     * For viewing and editing a checkbox is shown with a check mark for the <code>true</code> value and no check mark
     * for the <code>false</code> value.  See&#010 {@link com.smartgwt.client.widgets.grid.ListGrid#setBooleanTrueImage(String) booleanTrueImage} for
     * customization.
     */
    BOOLEAN("boolean"),
    /**
     * Same as <code>text</code>.  Consider setting {@link com.smartgwt.client.widgets.grid.ListGridField#setEditorType(com.smartgwt.client.widgets.form.fields.FormItem) editorType }
     * to use a {@link com.smartgwt.client.widgets.form.fields.SpinnerItem}.
     */
    INTEGER("integer"),
    /**
     * Same as <code>text</code>.  Consider setting {@link com.smartgwt.client.widgets.grid.ListGridField#setEditorType(com.smartgwt.client.widgets.form.fields.FormItem) editorType}
     * to use a {@link com.smartgwt.client.widgets.form.fields.SpinnerItem}.
     */
    FLOAT("float"),
    /**
     * Expected to contain <code>Date</code> type data. Dates will be formatted using&#010
     * ${isc.DocUtils.linkForRef('attr:ListGridField.displayFormat')} if specified, otherwise
     * {@link com.smartgwt.client.widgets.grid.ListGrid#setDateFormatter(DateDisplayFormat) dateFormatter}.&#010 If both these attributes are unset, dates are
     * formatted using the standard &#010 ${isc.DocUtils.linkForRef('classMethod:Date.setShortDisplayFormat','short
     * display format')} for dates.<br>&#010 For editing, by default a {@link com.smartgwt.client.widgets.form.fields.DateItem} is
     * used with {@link com.smartgwt.client.widgets.form.fields.DateItem#setUseTextField(Boolean) useTextField} set&#010 to true, providing textual date entry
     * plus a pop-up date picker. The&#010 {@link com.smartgwt.client.widgets.form.fields.DateItem#setDisplayFormat(DateDisplayFormat) displayFormat} and
     * {@link com.smartgwt.client.widgets.form.fields.DateItem#setInputFormat(String) inputFormat} &#010 for the editor will be picked up from
     * the ListGridField, if specified.
     */
    DATE("date"),
    /**
     * Expected to contain Time data encoded in javascript <code>Date</code> objects.&#010 Times will be formatted using
     * ${isc.DocUtils.linkForRef('attr:ListGridField.displayFormat')} if specified, &#010 otherwise
     * ${isc.DocUtils.linkForRef('attr:ListGrid.timeFormatter')}.<br>&#010 If both these attributes are unset, times are
     * formatted using the standard &#010 ${isc.DocUtils.linkForRef('classAttr:Time.shortDisplayFormat','short display
     * format')} for times.<br>&#010 For editing, by default a {@link com.smartgwt.client.widgets.form.fields.TimeItem} is used.
     * The&#010 {@link com.smartgwt.client.widgets.form.fields.TimeItem#setDisplayFormat(TimeFormatter) displayFormat} for the editor will be picked
     * up from &#010 the ListGridField, if specified.
     */
    TIME("time"),
    /**
     * Same as <code>text</code>
     */
    SEQUENCE("sequence"),
    /**
     * For viewing, the field value is rendered as a clickable html link (using an HTML anchor tag: &lt;A&gt;). The
     * target URL is the value of the field, which&#010 is also default display value. You can override the display
     * value by setting&#010 {@link com.smartgwt.client.widgets.grid.ListGridRecord#setLinkText(String) linkText } or
     * {@link com.smartgwt.client.widgets.grid.ListGridField#setLinkText(String) linkText} .<BR>&#010 Clicking the link opens the URL in a new
     * window by default.  To change this behavior,&#010 you can set <code>field.target</code>, which works indentically
     * to the target"&#010 attribute on an HTML anchor (&lt;A&gt;) tag.<br>&#010 In inline edit mode, this type works
     * like a text field.<br>&#010 To create a link not covered by this feature, consider using&#010
     * ${isc.DocUtils.linkForRef('method:ListGridField.formatCellValue')} along with
     * ${isc.DocUtils.linkForRef('method:Canvas.linkHTML')}, or simply&#010 ${isc.DocUtils.linkForRef('method:ListGrid.getCellStyle','styling
     * the field')} to look like a link, and providing&#010 interactivity via ${isc.DocUtils.linkForRef('method:ListGridField.recordClick','field.recordClick()')}.
     */
    LINK("link"),
    /**
     * For viewing, a thumbnail image is rendered in the field.  The URL of the image is the value of the field. If this
     * URL is not absolute, it is assumed to be relative&#010 to ${isc.DocUtils.linkForRef('attr:ListGridField.imageURLPrefix')}
     * if specified. The size of the image is controlled by&#010  ${isc.DocUtils.linkForRef('attr:ListGridField.imageSize')},
     * ${isc.DocUtils.linkForRef('attr:ListGridField.imageWidth')},&#010  ${isc.DocUtils.linkForRef('attr:ListGridField.imageHeight')}
     * (and by the similarly-named global default&#010  attributes on the ListGrid itself).<br>&#010  You can also
     * specify&#010  the following attributes on the field: <code>activeAreaHTML</code>, and&#010
     * <code>extraStuff</code> - these are passed to ${isc.DocUtils.linkForRef('method:Canvas.imgHTML')} to generate
     * the&#010  final URL.
     */
    IMAGE("image"),

    /**
     * Shows {@link com.smartgwt.client.widgets.grid.ListGridField#setIcon(String) field.icon} in every cell, and also in the header.
     * Useful for a field that is used as a button, for example, launches a detail&amp;#010 window or removes a row.
     * Implement a {@link com.smartgwt.client.widgets.grid.ListGridField#addRecordClickHandler(com.smartgwt.client.widgets.grid.events.RecordClickHandler)} #010 to define a
     * behavior for the button.#010 &lt;P&gt;#010 NOTE: for a field that shows different icons depending on the
     * field value, see {@link com.smartgwt.client.widgets.grid.ListGridField#setValueIcons(java.util.Map) valueIcons}.
     * also defaults to a small field width, accomodating just the icon&amp;#010 with padding, and to a blank header title,
     * so that the header shows the icon only.  #010 <P&gt;#010
     * {@link com.smartgwt.client.widgets.grid.ListGridField#setIconWidth(Integer)} iconWidth} and related properties configure&amp;#010
     * the size of the icon both in the header and in body cells.#010 <P&gt; #010 If you want the icon to appear
     * only in body cells and not in the header, set {@link com.smartgwt.client.widgets.grid.ListGridField#setCellIcon(String) cellIcon}
     * instead, leaving field.icon null.
     */
    ICON("icon"),
    /**
     * For viewing, the grid renders a 'view' icon (looking glass) followed by a 'download' icon and then the name of
     * the file is displayed in text.  If the user clicks the&#010 'view' icon, a new browser window is opened and the
     * file is streamed to that browser&#010 instance.  For images and other file types with known handlers, the content
     * is typically&#010 displayed inline - otherwise the browser will ask the user how to handle the content.  If
     * the&#010 download icon is clicked, the browser opens a 'Save' dialog. There is no inline editing mode&#010 for
     * this field type.
     */
    BINARY("binary"),
    /**
     * Same as <code>binary</code>
     */
    IMAGEFILE("imageFile"),
    /**
     * Show a calculated summary based on other field values within the current record.      * Show a calculated summary based on other field values within the current record.
     * See {@link com.smartgwt.client.widgets.grid.ListGridField#setRecordSummaryFunction(com.smartgwt.client.widgets.grid.RecordSummaryFunction)} for more information. 
     */
    SUMMARY("summary");

    private String value;

    ListGridFieldType(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}

