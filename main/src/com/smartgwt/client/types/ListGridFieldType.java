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
 * ListGrids format data for viewing and editing based on the <i>type</i> attribute of the field.  This table describes how
 * the ListGrid deals with the various built-in types.
 */
public enum ListGridFieldType implements ValueEnum {
    /**
     * Simple text rendering for view. For editing a text entry field is shown. If the length of the field (as specified by the
     * {@link com.smartgwt.client.data.DataSourceField#getLength DataSourceField.length} attribute) is larger than the value
     * specified by {@link com.smartgwt.client.widgets.grid.ListGrid#getLongTextEditorThreshold
     * ListGrid.longTextEditorThreshold}, a text input icon is shown that, when clicked on (or field is focused in) opens a
     * larger editor that expands outside the boundaries of the cell (textarea by default, but overrideable via {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getLongTextEditorType ListGrid.longTextEditorType}).
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "text".
     */
    TEXT("text"),
    /**
     * For viewing and editing a checkbox is shown with a check mark for the <code>true</code> value and no check mark for the
     * <code>false</code> value. This behavior may be suppressed by setting {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getSuppressValueIcon ListGridField.suppressValueIcon} for the field. See
     * {@link com.smartgwt.client.widgets.grid.ListGrid#getBooleanTrueImage ListGrid.booleanTrueImage} for customization.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "boolean".
     */
    BOOLEAN("boolean"),
    /**
     * A whole number, e.g. <code>123</code>. Consider setting {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getEditorType editorType} to use a {@link
     * com.smartgwt.client.widgets.form.fields.SpinnerItem}.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "integer".
     */
    INTEGER("integer"),
    /**
     * A floating point (decimal) number, e.g. <code>1.23</code>. Consider setting {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getEditorType editorType} to use a {@link
     * com.smartgwt.client.widgets.form.fields.SpinnerItem}.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "float".
     */
    FLOAT("float"),
    /**
     * Field value should be a <code>Date</code> instance representing a logical date, with no time of day information. See
     * {@link com.smartgwt.client.docs.DateFormatAndStorage} for details of the logical date type and how it is represented and
     * manipulated. <P> Dates will be formatted using {@link com.smartgwt.client.widgets.grid.ListGridField#getDateFormatter
     * ListGridField.dateFormatter} if specified, otherwise {@link com.smartgwt.client.widgets.grid.ListGrid#getDateFormatter
     * ListGrid.dateFormatter}. If both these attributes are unset, dates are formatted using the standard {@link
     * com.smartgwt.client.util.DateUtil#setShortDisplayFormat short display format} for dates. <P> For editing, by default a
     * {@link com.smartgwt.client.widgets.form.fields.DateItem} is used with {@link
     * com.smartgwt.client.widgets.form.fields.DateItem#getUseTextField DateItem.useTextField} set to true, providing textual
     * date entry plus a pop-up date picker. The {@link com.smartgwt.client.widgets.form.fields.DateItem#getDateFormatter
     * dateFormatter} and {@link com.smartgwt.client.widgets.form.fields.DateItem#getInputFormat inputFormat} for the editor
     * will be picked up from the ListGridField, if specified.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "date".
     */
    DATE("date"),
    /**
     * Field value should be a <code>Date</code> instance representing a logical time, meaning time value that does not have a
     * specific day and also has no timezone. See {@link com.smartgwt.client.docs.DateFormatAndStorage} for details of the
     * logical time type and how it is represented and manipulated. <P> Times will be formatted using {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getTimeFormatter ListGridField.timeFormatter} if specified, otherwise
     * {@link com.smartgwt.client.widgets.grid.ListGrid#getTimeFormatter ListGrid.timeFormatter}. <P> If both these attributes
     * are unset, times are formatted using the standard String for times. <P> For editing, by default a {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem} is used. The {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getTimeFormatter timeFormatter} for the editor will be picked up from
     * the ListGridField, if specified.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "time".
     */
    TIME("time"),
    /**
     * Field value should be a <code>Date</code> instance representing a specific date and time value. See {@link
     * com.smartgwt.client.docs.DateFormatAndStorage} for details of the datetime type and how it is represented and
     * manipulated. <P> Dates will be formatted using {@link com.smartgwt.client.widgets.grid.ListGridField#getDateFormatter
     * ListGridField.dateFormatter} if specified, otherwise {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getDatetimeFormatter ListGrid.datetimeFormatter}. If both these attributes are
     * unset, dates are formatted using the standard {@link com.smartgwt.client.util.DateUtil#setShortDatetimeDisplayFormat
     * short display format} for datetime values. <P> For editing, by default a {@link
     * com.smartgwt.client.widgets.form.fields.DateTimeItem} is used, providing textual date entry plus a pop-up date picker.
     * The {@link com.smartgwt.client.widgets.form.fields.DateItem#getDateFormatter dateFormatter} and {@link
     * com.smartgwt.client.widgets.form.fields.DateItem#getInputFormat inputFormat} for the editor will be picked up from the
     * ListGridField, if specified.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "datetime".
     */
    DATETIME("datetime"),
    /**
     * Same as <code>text</code>
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "sequence".
     */
    SEQUENCE("sequence"),
    /**
     * Renders a clickable html link (using an HTML anchor tag: &lt;A&gt;). The target URL is the value of the field, which is
     * also the default display value. You can override the display value by setting {@link
     * com.smartgwt.client.widgets.grid.ListGridRecord#getLinkText ListGridRecord.linkText} or {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getLinkText ListGridField.linkText}. <P> Clicking the link opens the URL
     * in a new window by default. To change this behavior, you can set <code>field.target</code>, which works identically to
     * the "target" attribute on an HTML anchor (&lt;A&gt;) tag. See {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getTarget ListGridField.target} for more information. <P> In inline edit
     * mode, this type works like a text field. <P> To create a link not covered by this feature, consider using {@link
     * com.smartgwt.client.widgets.grid.ListGridField#setCellFormatter ListGridField.setCellFormatter()} along with {@link
     * com.smartgwt.client.widgets.Canvas#linkHTML Canvas.linkHTML()}, or simply {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getCellStyle styling the field} to look like a link, and providing
     * interactivity via {@link com.smartgwt.client.widgets.grid.ListGridField#addRecordClickHandler field.recordClick()}.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "link".
     */
    LINK("link"),
    /**
     * Renders a different image in each row based on the value of the field. If this URL is not absolute, it is assumed to be
     * relative to {@link com.smartgwt.client.widgets.grid.ListGridField#getImageURLPrefix ListGridField.imageURLPrefix} if
     * specified. The size of the image is controlled by {@link com.smartgwt.client.widgets.grid.ListGridField#getImageSize
     * ListGridField.imageSize}, {@link com.smartgwt.client.widgets.grid.ListGridField#getImageWidth ListGridField.imageWidth},
     * {@link com.smartgwt.client.widgets.grid.ListGridField#getImageHeight ListGridField.imageHeight} (and by the
     * similarly-named global default attributes on the ListGrid itself). <P> You can also specify the following attributes on
     * the field: <code>activeAreaHTML</code>, and <code>extraStuff</code> - these are passed to {@link
     * com.smartgwt.client.widgets.Canvas#imgHTML Canvas.imgHTML()} to generate the final URL. <P> Note if you want to display
     * icons <b>in addition to</b> the normal cell value, you can use {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getValueIcons valueIcons} instead.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "image".
     */
    IMAGE("image"),
    /**
     * Shows {@link com.smartgwt.client.widgets.grid.ListGridField#getIcon field.icon} in every cell, and also in the header.
     * Useful for a field that is used as a button, for example, launches a detail window or removes a row. Implement a {@link
     * com.smartgwt.client.widgets.grid.ListGridField#addRecordClickHandler field.recordClick} to define a behavior for the
     * button. <P> NOTE: for a field that shows different icons depending on the field value, see {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getValueIcons ListGridField.valueIcons}. <P> <code>type:"icon"</code>
     * also defaults to a small field width, accommodating just the icon with padding, and to a blank header title, so that the
     * header shows the icon only. <P> {@link com.smartgwt.client.widgets.grid.ListGridField#getIconWidth field.iconWidth} and
     * related properties configure the size of the icon both in the header and in body cells. <P> If you want the icon to
     * appear only in body cells and not in the header, set {@link com.smartgwt.client.widgets.grid.ListGridField#getCellIcon
     * field.cellIcon} instead, leaving field.icon null.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "icon".
     */
    ICON("icon"),
    /**
     * For viewing, the grid renders a 'view' icon (looking glass) followed by a 'download' icon and then the name of the file
     * is displayed in text. If the user clicks the 'view' icon, a new browser window is opened and the file is streamed to
     * that browser instance, using {@link com.smartgwt.client.data.DataSource#viewFile DataSource.viewFile()}. For images and
     * other file types with known handlers, the content is typically displayed inline - otherwise the browser will ask the
     * user how to handle the content. If the download icon is clicked, {@link com.smartgwt.client.data.DataSource#downloadFile
     * DataSource.downloadFile()} is used to cause the browser to show a "save" dialog. There is no inline editing mode for
     * this field type.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "binary".
     */
    BINARY("binary"),
    /**
     * Same as <code>binary</code>
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "imageFile".
     */
    IMAGEFILE("imageFile"),
    /**
     * Show a calculated summary based on other field values within the current record. See {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getRecordSummaryFunction ListGridField.recordSummaryFunction} for more
     * information
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "summary".
     */
    SUMMARY("summary"),
    /**
     * Fields of this type can contain any data value and have no default formatting or validation behavior. This is useful as
     * the  {@link com.smartgwt.client.data.SimpleType#getInheritsFrom parent type} for SimpleTypes where you do not want any
     * of the standard validation or formatting logic to be inherited from the standard built-in types.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "any".
     */
    ANY("any"),
    /**
     * An integer number with locale-based formatting, e.g. <code>12,345,678</code>. See {@link
     * com.smartgwt.client.docs.LocalizedNumberFormatting Localized Number Formatting} for more info.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "localeInt".
     */
    LOCALEINT("localeInt"),
    /**
     * A float number with locale-based formatting, e.g. <code>12,345.67</code>. See {@link
     * com.smartgwt.client.docs.LocalizedNumberFormatting Localized Number Formatting} for more info.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "localeFloat".
     */
    LOCALEFLOAT("localeFloat"),
    /**
     * A float number with locale-based formatting and using currency symbol, e.g. <code>$12,345.67</code>. See {@link
     * com.smartgwt.client.docs.LocalizedNumberFormatting Localized Number Formatting} for more info.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "localeCurrency".
     */
    LOCALECURRENCY("localeCurrency"),
    /**
     * A telephone number. Uses {@link com.smartgwt.client.widgets.form.fields.FormItem#getBrowserInputType
     * FormItem.browserInputType} "tel" to hint to the device to restrict input. On most mobile devices that have
     *  software keyboards, this cause a specialized keyboard to appear which
     *  only allows entry of normal phone numbers. When displayed read-only,
     *  a "phoneNumber" renders as an HTML link with the "tel:" URL scheme,
     *  which will invoke the native phone dialing interface on most mobile
     *  devices. In addition, the CSS style "sc_phoneNumber" is applied.
     *  <p>
     *  By default, "phoneNumber" fields do not include validators, however the
     *  following validator definition would limit to digits, dashes and the
     *  "+" character:
     *  xml:
     *  <p>
     *  &lt;validator type="regexp" expression="^(\(?\+?[0-9]*\)?)?[0-9_\- \(\)]*$"
     *  errorMessage="Phone number should be in the correct format e.g. +#(###)###-##-##" /&gt;
     *  
     *  
     *  <p>
     *  or directly in Java:
     *  <p>
     *  <pre>
     *  RegExpValidator v = new RegExpValidator();
     *  v.setType(ValidatorType.REGEXP);
     *  v.setErrorMessage("Phone number should be in the correct format e.g. +#(###)###-##-##");
     *  v.setExpression("^(\\(?\\+?[0-9]*\\)?)?[0-9_\\- \\(\\)]*$");
     *  </pre>
     *  
     *  and adding "#" and "*" to the regular expressions above would allow for
     *  users to enter special keys sometimes used for extension numbers or
     *  pauses
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "phoneNumber".
     */
    PHONENUMBER("phoneNumber");
    private String value;

    ListGridFieldType(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
