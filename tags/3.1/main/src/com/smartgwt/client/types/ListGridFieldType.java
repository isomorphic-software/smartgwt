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
 * ListGrids format data for viewing and editing based on the <i>type</i> attribute of the field.  This table describes how
 * the ListGrid deals with the various built-in types.
 */
public enum ListGridFieldType implements ValueEnum {
    /**
     * Simple text rendering for view. For editing a text entry field is shown. If the length of the field (as specified by the
     * {@link com.smartgwt.client.data.DataSourceField#getLength length} attribute) is larger than the value specified by
     * {@link com.smartgwt.client.widgets.grid.ListGrid#getLongTextEditorThreshold longTextEditorThreshold}, a text input icon
     * is shown that, when clicked on (or field is focused in) opens a larger editor that expands outside the boundaries of the
     * cell (textarea by default, but overrideable via {@link com.smartgwt.client.widgets.grid.ListGrid#getLongTextEditorType
     * longTextEditorType}).
     */
    TEXT("text"),
    /**
     * For viewing and editing a checkbox is shown with a check mark for the <code>true</code> value and no check mark for the
     * <code>false</code> value. This behavior may be suppressed by setting link{listGridField.suppressValueIcon} for the
     * field. See {@link com.smartgwt.client.widgets.grid.ListGrid#getBooleanTrueImage booleanTrueImage} for customization.
     */
    BOOLEAN("boolean"),
    /**
     * Same as <code>text</code>. Consider setting {@link com.smartgwt.client.widgets.grid.ListGridField#getEditorType
     * editorType} to use a {@link com.smartgwt.client.widgets.form.fields.SpinnerItem}.
     */
    INTEGER("integer"),
    /**
     * Same as <code>text</code>. Consider setting {@link com.smartgwt.client.widgets.grid.ListGridField#getEditorType
     * editorType} to use a {@link com.smartgwt.client.widgets.form.fields.SpinnerItem}.
     */
    FLOAT("float"),
    /**
     * Field value should be a <code>Date</code> instance representing a logical date, with no time of day information. See
     * {@link com.smartgwt.client.docs.DateFormatAndStorage} for  details of the logical date type and how it is represented
     * and manipulated. <P> Dates will be formatted using {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getDateFormatter ListGridField.dateFormatter}  if specified, otherwise
     * {@link com.smartgwt.client.widgets.grid.ListGrid#getDateFormatter ListGrid.dateFormatter}.  If both these attributes are
     * unset, dates are formatted using the standard  short display format for dates. <P> For editing, by default a {@link
     * com.smartgwt.client.widgets.form.fields.DateItem} is used with {@link
     * com.smartgwt.client.widgets.form.fields.DateItem#getUseTextField useTextField} set to true, providing textual date entry
     * plus a pop-up date picker. The {@link com.smartgwt.client.widgets.form.fields.DateItem#getDateFormatter dateFormatter}
     * and {@link com.smartgwt.client.widgets.form.fields.DateItem#getInputFormat inputFormat} for the editor will be picked up
     * from the ListGridField, if specified.
     */
    DATE("date"),
    /**
     * Field value should be a <code>Date</code> instance representing a logical time, meaning time value that does not have a
     * specific day and also has no timezone. See {@link com.smartgwt.client.docs.DateFormatAndStorage} for details of the
     * logical time type and how it is represented and manipulated. <P> Times will be formatted using {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getTimeFormatter ListGridField.timeFormatter} if specified,  otherwise
     * {@link com.smartgwt.client.widgets.grid.ListGrid#getTimeFormatter ListGrid.timeFormatter}. <P> If both these attributes
     * are unset, times are formatted using the standard  String for times. <P> For editing, by default a {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem} is used. The {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getTimeFormatter timeFormatter} for the editor will be picked up from 
     * the ListGridField, if specified.
     */
    TIME("time"),
    /**
     * Field value should be a <code>Date</code> instance representing a specific date and time value. See {@link
     * com.smartgwt.client.docs.DateFormatAndStorage} for details of the datetime type and how it is represented and
     * manipulated. <P> Dates will be formatted using {@link com.smartgwt.client.widgets.grid.ListGridField#getDateFormatter
     * ListGridField.dateFormatter} if specified, otherwise {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getDatetimeFormatter ListGrid.datetimeFormatter}.  If both these attributes
     * are unset, dates are formatted using the standard  short display format for datetime values. <P> For editing, by default
     * a {@link com.smartgwt.client.widgets.form.fields.DateTimeItem} is used, providing textual date entry plus a pop-up date
     * picker. The {@link com.smartgwt.client.widgets.form.fields.DateItem#getDateFormatter dateFormatter} and {@link
     * com.smartgwt.client.widgets.form.fields.DateItem#getInputFormat inputFormat} for the editor will be picked up from the
     * ListGridField, if specified.
     */
    DATETIME("datetime"),
    /**
     * Same as <code>text</code>
     */
    SEQUENCE("sequence"),
    /**
     * Renders a clickable html link (using an HTML anchor tag: &lt;A&gt;). The target URL is the value of the field, which is
     * also the default display value. You can override the display value by setting {@link
     * com.smartgwt.client.widgets.grid.ListGridRecord#getLinkText linkText} or {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getLinkText linkText}. <P> Clicking the link opens the URL in a new
     * window by default. To change this behavior, you can set <code>field.target</code>, which works identically to the
     * "target" attribute on an HTML anchor (&lt;A&gt;) tag. See {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getTarget target} for more information. <P> In inline edit mode, this
     * type works like a text field. <P> To create a link not covered by this feature, consider using {@link
     * com.smartgwt.client.widgets.grid.ListGridField#formatCellValue ListGridField.formatCellValue} along with {@link
     * com.smartgwt.client.widgets.Canvas#linkHTML Canvas.linkHTML}, or simply {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getCellStyle styling the field} to look like a link, and providing
     * interactivity via {@link com.smartgwt.client.widgets.grid.ListGridField#addRecordClickHandler field.recordClick()}.
     */
    LINK("link"),
    /**
     * Renders a different image in each row based on the value of the field. If this URL is not absolute, it is assumed to be
     * relative to {@link com.smartgwt.client.widgets.grid.ListGridField#getImageURLPrefix imageURLPrefix} if specified. The
     * size of the image is controlled by {@link com.smartgwt.client.widgets.grid.ListGridField#getImageSize imageSize}, {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getImageWidth imageWidth}, {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getImageHeight imageHeight} (and by the similarly-named global default
     * attributes on the ListGrid itself). <P> You can also specify the following attributes on the field:
     * <code>activeAreaHTML</code>, and <code>extraStuff</code> - these are passed to {@link
     * com.smartgwt.client.widgets.Canvas#imgHTML Canvas.imgHTML} to generate the final URL. <P> Note if you want to display
     * icons <b>in addition to</b> the normal cell value, you can use {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getValueIcons valueIcons} instead.
     */
    IMAGE("image"),
    /**
     * Shows {@link com.smartgwt.client.widgets.grid.ListGridField#getIcon field.icon} in every cell, and also in the header.
     * Useful for a field that is used as a button, for example, launches a detail window or removes a row. Implement a {@link
     * com.smartgwt.client.widgets.grid.ListGridField#addRecordClickHandler field.recordClick} to define a behavior for the
     * button. <P> NOTE: for a field that shows different icons depending on the field value, see {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getValueIcons valueIcons}. <P> <code>type:"icon"</code> also defaults to
     * a small field width, accommodating just the icon with padding, and to a blank header title, so that the header shows the
     * icon only.  <P> {@link com.smartgwt.client.widgets.grid.ListGridField#getIconWidth field.iconWidth} and related
     * properties configure the size of the icon both in the header and in body cells. <P>  If you want the icon to appear only
     * in body cells and not in the header, set {@link com.smartgwt.client.widgets.grid.ListGridField#getCellIcon
     * field.cellIcon} instead, leaving field.icon null.
     */
    ICON("icon"),
    /**
     * For viewing, the grid renders a 'view' icon (looking glass) followed by a 'download' icon and then the name of the file
     * is displayed in text. If the user clicks the 'view' icon, a new browser window is opened and the file is streamed to
     * that browser instance, using {@link com.smartgwt.client.data.DataSource#viewFile DataSource.viewFile}. For images and
     * other file types with known handlers, the content is typically displayed inline - otherwise the browser will ask the
     * user how to handle the content. If the download icon is clicked, {@link com.smartgwt.client.data.DataSource#downloadFile
     * DataSource.downloadFile} is used to cause the browser to show a "save" dialog. There is no inline editing mode for this
     * field type.
     */
    BINARY("binary"),
    /**
     * Same as <code>binary</code>
     */
    IMAGEFILE("imageFile"),
    /**
     * Show a calculated summary based on other field values within the current record. See {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getRecordSummaryFunction recordSummaryFunction} for more information
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
        
