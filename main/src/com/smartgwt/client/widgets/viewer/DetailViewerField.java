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
 
package com.smartgwt.client.widgets.viewer;


import com.smartgwt.client.event.*;
import com.smartgwt.client.core.*;
import com.smartgwt.client.types.*;
import com.smartgwt.client.data.*;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.data.events.*;
import com.smartgwt.client.rpc.*;
import com.smartgwt.client.callbacks.*;
import com.smartgwt.client.tools.*;
import com.smartgwt.client.bean.*;
import com.smartgwt.client.widgets.*;
import com.smartgwt.client.widgets.events.*;
import com.smartgwt.client.widgets.form.*;
import com.smartgwt.client.widgets.form.validator.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.tile.*;
import com.smartgwt.client.widgets.tile.events.*;
import com.smartgwt.client.widgets.grid.*;
import com.smartgwt.client.widgets.grid.events.*;
import com.smartgwt.client.widgets.chart.*;
import com.smartgwt.client.widgets.layout.*;
import com.smartgwt.client.widgets.layout.events.*;
import com.smartgwt.client.widgets.menu.*;
import com.smartgwt.client.widgets.rte.*;
import com.smartgwt.client.widgets.rte.events.*;
import com.smartgwt.client.widgets.ace.*;
import com.smartgwt.client.widgets.ace.events.*;
import com.smartgwt.client.widgets.tab.*;
import com.smartgwt.client.widgets.toolbar.*;
import com.smartgwt.client.widgets.tree.*;
import com.smartgwt.client.widgets.tree.events.*;
import com.smartgwt.client.widgets.tableview.*;
import com.smartgwt.client.widgets.viewer.*;
import com.smartgwt.client.widgets.calendar.*;
import com.smartgwt.client.widgets.calendar.events.*;
import com.smartgwt.client.widgets.cube.*;
import com.smartgwt.client.widgets.drawing.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.gwt.event.shared.*;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.core.client.JavaScriptObject;

import com.smartgwt.client.util.*;
import com.smartgwt.client.util.events.*;
import com.smartgwt.client.util.workflow.*;
import com.smartgwt.client.util.workflow.Process; // required to override java.lang.Process


/**
 * An object literal with a particular set of properties used to configure the display of and interaction with the rows of
 * a {@link com.smartgwt.client.widgets.viewer.DetailViewer}.
 */
@BeanFactory.FrameworkClass
public class DetailViewerField extends DBCField {

    public static DetailViewerField getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        return new DetailViewerField(jsObj);
    }
        


    public DetailViewerField(){
        
    }

    public DetailViewerField(JavaScriptObject jsObj){
        
        setJavaScriptObject(jsObj);
    }


    public DetailViewerField(String name) {
        setName(name);
                
    }


    public DetailViewerField(String name, String title) {
        setName(name);
		setTitle(title);
                
    }


    // ********************* Properties / Attributes ***********************

    /**
     * Dictates whether the data in this field be exported.  Explicitly set this  to false to prevent exporting.  Has no effect
     * if the underlying   {@link com.smartgwt.client.data.DataSourceField#getCanExport dataSourceField} is explicitly set to  
     * canExport: false.
     *
     * @param canExport New canExport value. Default value is null
     * @return {@link com.smartgwt.client.widgets.viewer.DetailViewerField DetailViewerField} instance, for chaining setter calls
     */
    public DetailViewerField setCanExport(Boolean canExport) {
        return (DetailViewerField)setAttribute("canExport", canExport);
    }

    /**
     * Dictates whether the data in this field be exported.  Explicitly set this  to false to prevent exporting.  Has no effect
     * if the underlying   {@link com.smartgwt.client.data.DataSourceField#getCanExport dataSourceField} is explicitly set to  
     * canExport: false.
     *
     * @return Current canExport value. Default value is null
     */
    public Boolean getCanExport()  {
        return getAttributeAsBoolean("canExport", true);
    }
    

    /**
     * Determines whether this field can be hilited.  Set to false to prevent this field from appearing in HiliteEditor.
     *
     * @param canHilite New canHilite value. Default value is null
     * @return {@link com.smartgwt.client.widgets.viewer.DetailViewerField DetailViewerField} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.Hiliting Hiliting overview and related methods
     */
    public DetailViewerField setCanHilite(Boolean canHilite) {
        return (DetailViewerField)setAttribute("canHilite", canHilite);
    }

    /**
     * Determines whether this field can be hilited.  Set to false to prevent this field from appearing in HiliteEditor.
     *
     * @return Current canHilite value. Default value is null
     * @see com.smartgwt.client.docs.Hiliting Hiliting overview and related methods
     */
    public Boolean getCanHilite()  {
        return getAttributeAsBoolean("canHilite", true);
    }
    

    /**
     * If specified, cells in this field will be rendered using this css className rather than {@link
     * com.smartgwt.client.widgets.viewer.DetailViewer#getCellStyle DetailViewer.cellStyle}
     *
     * @param cellStyle New cellStyle value. Default value is null
     * @return {@link com.smartgwt.client.widgets.viewer.DetailViewerField DetailViewerField} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public DetailViewerField setCellStyle(String cellStyle) {
        return (DetailViewerField)setAttribute("cellStyle", cellStyle);
    }

    /**
     * If specified, cells in this field will be rendered using this css className rather than {@link
     * com.smartgwt.client.widgets.viewer.DetailViewer#getCellStyle DetailViewer.cellStyle}
     *
     * @return Optional method to return the CSS class for cells in this field. If specified, this method will be called from {@link
     * com.smartgwt.client.widgets.viewer.DetailViewer#getCellStyle DetailViewer.getCellStyle()}, and should return a css class
     * name. Default value is null
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public String getCellStyle()  {
        return getAttributeAsString("cellStyle");
    }
    

    /**
     * dataPath property allows this field to display detail from nested data structures
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param dataPath New dataPath value. Default value is null
     * @return {@link com.smartgwt.client.widgets.viewer.DetailViewerField DetailViewerField} instance, for chaining setter calls
     */
    public DetailViewerField setDataPath(String dataPath) {
        return (DetailViewerField)setAttribute("dataPath", dataPath);
    }

    /**
     * dataPath property allows this field to display detail from nested data structures
     *
     * @return Current dataPath value. Default value is null
     */
    public String getDataPath()  {
        return getAttributeAsString("dataPath");
    }
    

    /**
     * Display format to use for date type values within this field.  <P> The {@link
     * com.smartgwt.client.widgets.viewer.DetailViewerField#getTimeFormatter timeFormatter} may also be used to format
     * underlying Date values as times (omitting the date part entirely). If both <code>dateFormatter</code> and
     * <code>timeFormatter</code> are specified on a field, for fields specified as {@link
     * com.smartgwt.client.widgets.viewer.DetailViewerField#getType type "time"} the <code>timeFormatter</code> will be used,
     * otherwise the <code>dateFormatter</code> <P> If <code>field.dateFormatter</code> and <code>field.timeFormatter</code> is
     * unspecified, date display format may be defined at the component level via {@link
     * com.smartgwt.client.widgets.viewer.DetailViewer#getDateFormatter DetailViewer.dateFormatter}, or for fields of type
     * <code>"datetime"</code> {@link com.smartgwt.client.widgets.viewer.DetailViewer#getDatetimeFormatter
     * DetailViewer.datetimeFormatter}. Otherwise the default is to use the system-wide default normal date format, configured
     * via {@link com.smartgwt.client.util.DateUtil#setNormalDisplayFormat DateUtil.setNormalDisplayFormat()}.  Specify any
     * valid  {@link com.smartgwt.client.types.DateDisplayFormat} to change the format used by this item.
     *
     * @param dateFormatter New dateFormatter value. Default value is null
     * @return {@link com.smartgwt.client.widgets.viewer.DetailViewerField DetailViewerField} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.grid.ListGrid#setDateFormatter
     * @see com.smartgwt.client.widgets.grid.ListGrid#setDatetimeFormatter
     * @see com.smartgwt.client.widgets.grid.ListGridField#setTimeFormatter
     */
    public DetailViewerField setDateFormatter(DateDisplayFormat dateFormatter) {
        return (DetailViewerField)setAttribute("dateFormatter", dateFormatter == null ? null : dateFormatter.getValue());
    }

    /**
     * Display format to use for date type values within this field.  <P> The {@link
     * com.smartgwt.client.widgets.viewer.DetailViewerField#getTimeFormatter timeFormatter} may also be used to format
     * underlying Date values as times (omitting the date part entirely). If both <code>dateFormatter</code> and
     * <code>timeFormatter</code> are specified on a field, for fields specified as {@link
     * com.smartgwt.client.widgets.viewer.DetailViewerField#getType type "time"} the <code>timeFormatter</code> will be used,
     * otherwise the <code>dateFormatter</code> <P> If <code>field.dateFormatter</code> and <code>field.timeFormatter</code> is
     * unspecified, date display format may be defined at the component level via {@link
     * com.smartgwt.client.widgets.viewer.DetailViewer#getDateFormatter DetailViewer.dateFormatter}, or for fields of type
     * <code>"datetime"</code> {@link com.smartgwt.client.widgets.viewer.DetailViewer#getDatetimeFormatter
     * DetailViewer.datetimeFormatter}. Otherwise the default is to use the system-wide default normal date format, configured
     * via {@link com.smartgwt.client.util.DateUtil#setNormalDisplayFormat DateUtil.setNormalDisplayFormat()}.  Specify any
     * valid  {@link com.smartgwt.client.types.DateDisplayFormat} to change the format used by this item.
     *
     * @return Current dateFormatter value. Default value is null
     * @see com.smartgwt.client.widgets.grid.ListGrid#getDateFormatter
     * @see com.smartgwt.client.widgets.grid.ListGrid#getDatetimeFormatter
     * @see com.smartgwt.client.widgets.grid.ListGridField#getTimeFormatter
     */
    public DateDisplayFormat getDateFormatter()  {
        return EnumUtil.getEnum(DateDisplayFormat.values(), getAttribute("dateFormatter"));
    }
    

    /**
     * Applies only to fields of type "float" and enforces a minimum number of digits shown after the decimal point. <P> For
     * example, a field value of 343.1, 343.104 and 343.09872677 would all be shown as 343.10 if decimalPad is 2. <P> The
     * original unpadded value is always shown when the value is edited.
     *
     * @param decimalPad New decimalPad value. Default value is null
     * @return {@link com.smartgwt.client.widgets.viewer.DetailViewerField DetailViewerField} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public DetailViewerField setDecimalPad(Integer decimalPad) {
        return (DetailViewerField)setAttribute("decimalPad", decimalPad);
    }

    /**
     * Applies only to fields of type "float" and enforces a minimum number of digits shown after the decimal point. <P> For
     * example, a field value of 343.1, 343.104 and 343.09872677 would all be shown as 343.10 if decimalPad is 2. <P> The
     * original unpadded value is always shown when the value is edited.
     *
     * @return Current decimalPad value. Default value is null
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Integer getDecimalPad()  {
        return getAttributeAsInt("decimalPad");
    }
    

    /**
     * Applies only to fields of type "float" and affects how many significant digits are shown. <P> For example, with
     * decimalPrecision 3, if the field value is 343.672677, 343.673 is shown. <P> If the value is 125.2, 125.2 is shown -
     * decimalPrecision will not cause extra zeros to be added.  Use {@link
     * com.smartgwt.client.data.DataSourceField#getDecimalPad DataSourceField.decimalPad} for this. <P> A number is always
     * shown with its original precision when edited.
     *
     * @param decimalPrecision New decimalPrecision value. Default value is null
     * @return {@link com.smartgwt.client.widgets.viewer.DetailViewerField DetailViewerField} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public DetailViewerField setDecimalPrecision(Integer decimalPrecision) {
        return (DetailViewerField)setAttribute("decimalPrecision", decimalPrecision);
    }

    /**
     * Applies only to fields of type "float" and affects how many significant digits are shown. <P> For example, with
     * decimalPrecision 3, if the field value is 343.672677, 343.673 is shown. <P> If the value is 125.2, 125.2 is shown -
     * decimalPrecision will not cause extra zeros to be added.  Use {@link
     * com.smartgwt.client.data.DataSourceField#getDecimalPad DataSourceField.decimalPad} for this. <P> A number is always
     * shown with its original precision when edited.
     *
     * @return Current decimalPrecision value. Default value is null
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Integer getDecimalPrecision()  {
        return getAttributeAsInt("decimalPrecision");
    }
    

    /**
     * If <code>displayField</code> is defined for the field then the DetailViewer will display the <code>displayField</code>
     * attribute of records instead of the attribute given by the {@link
     * com.smartgwt.client.widgets.viewer.DetailViewerField#getName name} of the field.
     *
     * @param displayField New displayField value. Default value is null
     * @return {@link com.smartgwt.client.widgets.viewer.DetailViewerField DetailViewerField} instance, for chaining setter calls
     */
    public DetailViewerField setDisplayField(String displayField) {
        return (DetailViewerField)setAttribute("displayField", displayField);
    }

    /**
     * If <code>displayField</code> is defined for the field then the DetailViewer will display the <code>displayField</code>
     * attribute of records instead of the attribute given by the {@link
     * com.smartgwt.client.widgets.viewer.DetailViewerField#getName name} of the field.
     *
     * @return Current displayField value. Default value is null
     */
    public String getDisplayField()  {
        return getAttributeAsString("displayField");
    }
    

    /**
     * The value to display for a cell whose value is null or the empty string after applying formatCellValue and valueMap (if
     * any). <p> This is the field-specific attribute.  You may also set the emptyCellValue at the viewer level to define the
     * emptyCellValue for all empty fields in the viewer.
     *
     * @param emptyCellValue New emptyCellValue value. Default value is null
     * @return {@link com.smartgwt.client.widgets.viewer.DetailViewerField DetailViewerField} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.viewer.DetailViewer#setEmptyCellValue
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public DetailViewerField setEmptyCellValue(String emptyCellValue) {
        return (DetailViewerField)setAttribute("emptyCellValue", emptyCellValue);
    }

    /**
     * The value to display for a cell whose value is null or the empty string after applying formatCellValue and valueMap (if
     * any). <p> This is the field-specific attribute.  You may also set the emptyCellValue at the viewer level to define the
     * emptyCellValue for all empty fields in the viewer.
     *
     * @return Current emptyCellValue value. Default value is null
     * @see com.smartgwt.client.widgets.viewer.DetailViewer#getEmptyCellValue
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getEmptyCellValue()  {
        return getAttributeAsString("emptyCellValue");
    }
    

    /**
     * By default HTML values in DetailViewer cells will be interpreted by the browser. Setting this flag to true will causes
     * HTML characters to be escaped, meaning the raw value of the field (for example <code>"&lt;b&gt;AAA&lt;/b&gt;"</code>) is
     * displayed to the user rather than the interpreted HTML (for example <code>"<b>AAA</b>"</code>)
     *
     * @param escapeHTML New escapeHTML value. Default value is null
     * @return {@link com.smartgwt.client.widgets.viewer.DetailViewerField DetailViewerField} instance, for chaining setter calls
     */
    public DetailViewerField setEscapeHTML(Boolean escapeHTML) {
        return (DetailViewerField)setAttribute("escapeHTML", escapeHTML);
    }

    /**
     * By default HTML values in DetailViewer cells will be interpreted by the browser. Setting this flag to true will causes
     * HTML characters to be escaped, meaning the raw value of the field (for example <code>"&lt;b&gt;AAA&lt;/b&gt;"</code>) is
     * displayed to the user rather than the interpreted HTML (for example <code>"<b>AAA</b>"</code>)
     *
     * @return Current escapeHTML value. Default value is null
     */
    public Boolean getEscapeHTML()  {
        return getAttributeAsBoolean("escapeHTML", true);
    }
    

    /**
     * {@link com.smartgwt.client.docs.FormatString} used during exports for numeric or date formatting.  See {@link
     * com.smartgwt.client.data.DataSourceField#getExportFormat DataSourceField.exportFormat}.
     *
     * @param exportFormat New exportFormat value. Default value is null
     * @return {@link com.smartgwt.client.widgets.viewer.DetailViewerField DetailViewerField} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.FormatString FormatString 
     * @see com.smartgwt.client.docs.ExportFormatting ExportFormatting overview and related methods
     */
    public DetailViewerField setExportFormat(String exportFormat) {
        return (DetailViewerField)setAttribute("exportFormat", exportFormat);
    }

    /**
     * {@link com.smartgwt.client.docs.FormatString} used during exports for numeric or date formatting.  See {@link
     * com.smartgwt.client.data.DataSourceField#getExportFormat DataSourceField.exportFormat}.
     *
     * @return Current exportFormat value. Default value is null
     * @see com.smartgwt.client.docs.FormatString FormatString 
     * @see com.smartgwt.client.docs.ExportFormatting ExportFormatting overview and related methods
     */
    public String getExportFormat()  {
        return getAttributeAsString("exportFormat");
    }
    

    /**
     * Dictates whether the data in this field should be exported raw by {@link
     * com.smartgwt.client.widgets.viewer.DetailViewer#exportClientData exportClientData()}.  If set to true for a field, the
     * values in the field-formatters will not be executed for data in this field.
     *
     * @param exportRawValues New exportRawValues value. Default value is null
     * @return {@link com.smartgwt.client.widgets.viewer.DetailViewerField DetailViewerField} instance, for chaining setter calls
     */
    public DetailViewerField setExportRawValues(Boolean exportRawValues) {
        return (DetailViewerField)setAttribute("exportRawValues", exportRawValues);
    }

    /**
     * Dictates whether the data in this field should be exported raw by {@link
     * com.smartgwt.client.widgets.viewer.DetailViewer#exportClientData exportClientData()}.  If set to true for a field, the
     * values in the field-formatters will not be executed for data in this field.
     *
     * @return Current exportRawValues value. Default value is null
     */
    public Boolean getExportRawValues()  {
        return getAttributeAsBoolean("exportRawValues", true);
    }
    

    /**
     * {@link com.smartgwt.client.docs.FormatString} for numeric or date formatting.  See {@link
     * com.smartgwt.client.data.DataSourceField#getFormat DataSourceField.format}.
     *
     * @param format New format value. Default value is null
     * @return {@link com.smartgwt.client.widgets.viewer.DetailViewerField DetailViewerField} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.FormatString FormatString 
     * @see com.smartgwt.client.docs.ExportFormatting ExportFormatting overview and related methods
     */
    public DetailViewerField setFormat(String format) {
        return (DetailViewerField)setAttribute("format", format);
    }

    /**
     * {@link com.smartgwt.client.docs.FormatString} for numeric or date formatting.  See {@link
     * com.smartgwt.client.data.DataSourceField#getFormat DataSourceField.format}.
     *
     * @return Current format value. Default value is null
     * @see com.smartgwt.client.docs.FormatString FormatString 
     * @see com.smartgwt.client.docs.ExportFormatting ExportFormatting overview and related methods
     */
    public String getFormat()  {
        return getAttributeAsString("format");
    }
    

    /**
     * For {@link com.smartgwt.client.widgets.viewer.DetailViewerField#getType type}: <code>"separator"</code>, this attribute
     * specifies the height of the separator.
     *
     * @param height New height value. Default value is null
     * @return {@link com.smartgwt.client.widgets.viewer.DetailViewerField DetailViewerField} instance, for chaining setter calls
     */
    public DetailViewerField setHeight(Integer height) {
        return (DetailViewerField)setAttribute("height", height);
    }

    /**
     * For {@link com.smartgwt.client.widgets.viewer.DetailViewerField#getType type}: <code>"separator"</code>, this attribute
     * specifies the height of the separator.
     *
     * @return Current height value. Default value is null
     */
    public Integer getHeight()  {
        return getAttributeAsInt("height");
    }
    

    /**
     * Height for hilite icons for this field. Overrides {@link
     * com.smartgwt.client.widgets.viewer.DetailViewer#getHiliteIconSize DetailViewer.hiliteIconSize}, {@link
     * com.smartgwt.client.widgets.viewer.DetailViewer#getHiliteIconHeight DetailViewer.hiliteIconHeight}, and {@link
     * com.smartgwt.client.widgets.viewer.DetailViewerField#getHiliteIconSize hiliteIconSize}.
     *
     * @param hiliteIconHeight New hiliteIconHeight value. Default value is null
     * @return {@link com.smartgwt.client.widgets.viewer.DetailViewerField DetailViewerField} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.Hiliting Hiliting overview and related methods
     */
    public DetailViewerField setHiliteIconHeight(Integer hiliteIconHeight) {
        return (DetailViewerField)setAttribute("hiliteIconHeight", hiliteIconHeight);
    }

    /**
     * Height for hilite icons for this field. Overrides {@link
     * com.smartgwt.client.widgets.viewer.DetailViewer#getHiliteIconSize DetailViewer.hiliteIconSize}, {@link
     * com.smartgwt.client.widgets.viewer.DetailViewer#getHiliteIconHeight DetailViewer.hiliteIconHeight}, and {@link
     * com.smartgwt.client.widgets.viewer.DetailViewerField#getHiliteIconSize hiliteIconSize}.
     *
     * @return Current hiliteIconHeight value. Default value is null
     * @see com.smartgwt.client.docs.Hiliting Hiliting overview and related methods
     */
    public Integer getHiliteIconHeight()  {
        return getAttributeAsInt("hiliteIconHeight");
    }
    

    /**
     * How much padding should there be on the left of {@link com.smartgwt.client.widgets.viewer.DetailViewer#getHiliteIcons
     * hilite icons}  for this field? Overrides {@link com.smartgwt.client.widgets.viewer.DetailViewer#getHiliteIconLeftPadding
     * DetailViewer.hiliteIconLeftPadding}
     *
     * @param hiliteIconLeftPadding New hiliteIconLeftPadding value. Default value is null
     * @return {@link com.smartgwt.client.widgets.viewer.DetailViewerField DetailViewerField} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.Hiliting Hiliting overview and related methods
     */
    public DetailViewerField setHiliteIconLeftPadding(Integer hiliteIconLeftPadding) {
        return (DetailViewerField)setAttribute("hiliteIconLeftPadding", hiliteIconLeftPadding);
    }

    /**
     * How much padding should there be on the left of {@link com.smartgwt.client.widgets.viewer.DetailViewer#getHiliteIcons
     * hilite icons}  for this field? Overrides {@link com.smartgwt.client.widgets.viewer.DetailViewer#getHiliteIconLeftPadding
     * DetailViewer.hiliteIconLeftPadding}
     *
     * @return Current hiliteIconLeftPadding value. Default value is null
     * @see com.smartgwt.client.docs.Hiliting Hiliting overview and related methods
     */
    public Integer getHiliteIconLeftPadding()  {
        return getAttributeAsInt("hiliteIconLeftPadding");
    }
    

    /**
     * When {@link com.smartgwt.client.widgets.viewer.DetailViewer#getHiliteIcons DetailViewer.hiliteIcons} are present, where
     * the hilite icon will be placed  relative to the field value.  See {@link com.smartgwt.client.types.HiliteIconPosition}.
     * Overrides {@link com.smartgwt.client.widgets.viewer.DetailViewer#getHiliteIconPosition DetailViewer.hiliteIconPosition}
     *
     * @param hiliteIconPosition New hiliteIconPosition value. Default value is null
     * @return {@link com.smartgwt.client.widgets.viewer.DetailViewerField DetailViewerField} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.Hiliting Hiliting overview and related methods
     */
    public DetailViewerField setHiliteIconPosition(HiliteIconPosition hiliteIconPosition) {
        return (DetailViewerField)setAttribute("hiliteIconPosition", hiliteIconPosition == null ? null : hiliteIconPosition.getValue());
    }

    /**
     * When {@link com.smartgwt.client.widgets.viewer.DetailViewer#getHiliteIcons DetailViewer.hiliteIcons} are present, where
     * the hilite icon will be placed  relative to the field value.  See {@link com.smartgwt.client.types.HiliteIconPosition}.
     * Overrides {@link com.smartgwt.client.widgets.viewer.DetailViewer#getHiliteIconPosition DetailViewer.hiliteIconPosition}
     *
     * @return Current hiliteIconPosition value. Default value is null
     * @see com.smartgwt.client.docs.Hiliting Hiliting overview and related methods
     */
    public HiliteIconPosition getHiliteIconPosition()  {
        return EnumUtil.getEnum(HiliteIconPosition.values(), getAttribute("hiliteIconPosition"));
    }
    

    /**
     * How much padding should there be on the right of {@link com.smartgwt.client.widgets.viewer.DetailViewer#getHiliteIcons
     * hilite icons}  for this field? Overrides {@link
     * com.smartgwt.client.widgets.viewer.DetailViewer#getHiliteIconRightPadding DetailViewer.hiliteIconRightPadding}
     *
     * @param hiliteIconRightPadding New hiliteIconRightPadding value. Default value is null
     * @return {@link com.smartgwt.client.widgets.viewer.DetailViewerField DetailViewerField} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.Hiliting Hiliting overview and related methods
     */
    public DetailViewerField setHiliteIconRightPadding(Integer hiliteIconRightPadding) {
        return (DetailViewerField)setAttribute("hiliteIconRightPadding", hiliteIconRightPadding);
    }

    /**
     * How much padding should there be on the right of {@link com.smartgwt.client.widgets.viewer.DetailViewer#getHiliteIcons
     * hilite icons}  for this field? Overrides {@link
     * com.smartgwt.client.widgets.viewer.DetailViewer#getHiliteIconRightPadding DetailViewer.hiliteIconRightPadding}
     *
     * @return Current hiliteIconRightPadding value. Default value is null
     * @see com.smartgwt.client.docs.Hiliting Hiliting overview and related methods
     */
    public Integer getHiliteIconRightPadding()  {
        return getAttributeAsInt("hiliteIconRightPadding");
    }
    

    /**
     * Default width and height of {@link com.smartgwt.client.widgets.viewer.DetailViewer#getHiliteIcons hilite icons} in this
     * field. Takes precedence over hiliteIconWidth, hiliteIconHeight and hiliteIconSize specified at the component level. Can
     * be overridden via {@link com.smartgwt.client.widgets.viewer.DetailViewerField#getHiliteIconWidth hiliteIconWidth} and
     * {@link com.smartgwt.client.widgets.viewer.DetailViewerField#getHiliteIconHeight hiliteIconHeight}
     *
     * @param hiliteIconSize New hiliteIconSize value. Default value is null
     * @return {@link com.smartgwt.client.widgets.viewer.DetailViewerField DetailViewerField} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.viewer.DetailViewer#setHiliteIconSize
     * @see com.smartgwt.client.widgets.viewer.DetailViewerField#setHiliteIconWidth
     * @see com.smartgwt.client.widgets.viewer.DetailViewerField#setHiliteIconHeight
     * @see com.smartgwt.client.docs.Hiliting Hiliting overview and related methods
     */
    public DetailViewerField setHiliteIconSize(Integer hiliteIconSize) {
        return (DetailViewerField)setAttribute("hiliteIconSize", hiliteIconSize);
    }

    /**
     * Default width and height of {@link com.smartgwt.client.widgets.viewer.DetailViewer#getHiliteIcons hilite icons} in this
     * field. Takes precedence over hiliteIconWidth, hiliteIconHeight and hiliteIconSize specified at the component level. Can
     * be overridden via {@link com.smartgwt.client.widgets.viewer.DetailViewerField#getHiliteIconWidth hiliteIconWidth} and
     * {@link com.smartgwt.client.widgets.viewer.DetailViewerField#getHiliteIconHeight hiliteIconHeight}
     *
     * @return Current hiliteIconSize value. Default value is null
     * @see com.smartgwt.client.widgets.viewer.DetailViewer#getHiliteIconSize
     * @see com.smartgwt.client.widgets.viewer.DetailViewerField#getHiliteIconWidth
     * @see com.smartgwt.client.widgets.viewer.DetailViewerField#getHiliteIconHeight
     * @see com.smartgwt.client.docs.Hiliting Hiliting overview and related methods
     */
    public Integer getHiliteIconSize()  {
        return getAttributeAsInt("hiliteIconSize");
    }
    

    /**
     * Width for hilite icons for this field. Overrides {@link
     * com.smartgwt.client.widgets.viewer.DetailViewer#getHiliteIconSize DetailViewer.hiliteIconSize}, {@link
     * com.smartgwt.client.widgets.viewer.DetailViewer#getHiliteIconWidth DetailViewer.hiliteIconWidth}, and {@link
     * com.smartgwt.client.widgets.viewer.DetailViewerField#getHiliteIconSize hiliteIconSize}.
     *
     * @param hiliteIconWidth New hiliteIconWidth value. Default value is null
     * @return {@link com.smartgwt.client.widgets.viewer.DetailViewerField DetailViewerField} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.Hiliting Hiliting overview and related methods
     */
    public DetailViewerField setHiliteIconWidth(Integer hiliteIconWidth) {
        return (DetailViewerField)setAttribute("hiliteIconWidth", hiliteIconWidth);
    }

    /**
     * Width for hilite icons for this field. Overrides {@link
     * com.smartgwt.client.widgets.viewer.DetailViewer#getHiliteIconSize DetailViewer.hiliteIconSize}, {@link
     * com.smartgwt.client.widgets.viewer.DetailViewer#getHiliteIconWidth DetailViewer.hiliteIconWidth}, and {@link
     * com.smartgwt.client.widgets.viewer.DetailViewerField#getHiliteIconSize hiliteIconSize}.
     *
     * @return Current hiliteIconWidth value. Default value is null
     * @see com.smartgwt.client.docs.Hiliting Hiliting overview and related methods
     */
    public Integer getHiliteIconWidth()  {
        return getAttributeAsInt("hiliteIconWidth");
    }
    

    /**
     * Height of image shown for fieldTypes image in this field. <P> If set to a String, assumed to be a property on each
     * record that specifies the image height.  For example, if <code>field.imageHeight</code> is "logoHeight",
     * <code>record.logoHeight</code> will control the height of the image.
     *
     * @param imageHeight New imageHeight value. Default value is null
     * @return {@link com.smartgwt.client.widgets.viewer.DetailViewerField DetailViewerField} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.viewer.DetailViewerField#setImageSize
     * @see com.smartgwt.client.widgets.viewer.DetailViewerField#setImageWidth
     * @see com.smartgwt.client.docs.ImageColumns ImageColumns overview and related methods
     */
    public DetailViewerField setImageHeight(Integer imageHeight) {
        return (DetailViewerField)setAttribute("imageHeight", imageHeight);
    }

    /**
     * Height of image shown for fieldTypes image in this field. <P> If set to a String, assumed to be a property on each
     * record that specifies the image height.  For example, if <code>field.imageHeight</code> is "logoHeight",
     * <code>record.logoHeight</code> will control the height of the image.
     *
     * @return Current imageHeight value. Default value is null
     * @see com.smartgwt.client.widgets.viewer.DetailViewerField#getImageSize
     * @see com.smartgwt.client.widgets.viewer.DetailViewerField#getImageWidth
     * @see com.smartgwt.client.docs.ImageColumns ImageColumns overview and related methods
     */
    public Integer getImageHeight()  {
        return getAttributeAsInt("imageHeight");
    }

    /**
     * Height of image shown for fieldTypes image in this field. <P> If set to a String, assumed to be a property on each
     * record that specifies the image height.  For example, if <code>field.imageHeight</code> is "logoHeight",
     * <code>record.logoHeight</code> will control the height of the image.
     *
     * @param imageHeight New imageHeight value. Default value is null
     * @return {@link com.smartgwt.client.widgets.viewer.DetailViewerField DetailViewerField} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.viewer.DetailViewerField#setImageSize
     * @see com.smartgwt.client.widgets.viewer.DetailViewerField#setImageWidth
     * @see com.smartgwt.client.docs.ImageColumns ImageColumns overview and related methods
     */
    public DetailViewerField setImageHeight(String imageHeight) {
        return (DetailViewerField)setAttribute("imageHeight", imageHeight);
    }

    /**
     * Height of image shown for fieldTypes image in this field. <P> If set to a String, assumed to be a property on each
     * record that specifies the image height.  For example, if <code>field.imageHeight</code> is "logoHeight",
     * <code>record.logoHeight</code> will control the height of the image.
     *
     * @return Current imageHeight value. Default value is null
     * @see com.smartgwt.client.widgets.viewer.DetailViewerField#getImageSize
     * @see com.smartgwt.client.widgets.viewer.DetailViewerField#getImageWidth
     * @see com.smartgwt.client.docs.ImageColumns ImageColumns overview and related methods
     */
    public String getImageHeightAsString()  {
        return getAttributeAsString("imageHeight");
    }
    

    /**
     * Size of images shown for fieldTypes image in this field. <P> If set to a String, assumed to be a property on each record
     * that specifies the image height.  For example, if <code>field.imageSize</code> is "logoSize",
     * <code>record.logoSize</code> will control the size of the image.
     *
     * @param imageSize New imageSize value. Default value is null
     * @return {@link com.smartgwt.client.widgets.viewer.DetailViewerField DetailViewerField} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.viewer.DetailViewerField#setImageWidth
     * @see com.smartgwt.client.widgets.viewer.DetailViewerField#setImageHeight
     * @see com.smartgwt.client.docs.ImageColumns ImageColumns overview and related methods
     */
    public DetailViewerField setImageSize(Integer imageSize) {
        return (DetailViewerField)setAttribute("imageSize", imageSize);
    }

    /**
     * Size of images shown for fieldTypes image in this field. <P> If set to a String, assumed to be a property on each record
     * that specifies the image height.  For example, if <code>field.imageSize</code> is "logoSize",
     * <code>record.logoSize</code> will control the size of the image.
     *
     * @return Current imageSize value. Default value is null
     * @see com.smartgwt.client.widgets.viewer.DetailViewerField#getImageWidth
     * @see com.smartgwt.client.widgets.viewer.DetailViewerField#getImageHeight
     * @see com.smartgwt.client.docs.ImageColumns ImageColumns overview and related methods
     */
    public Integer getImageSize()  {
        return getAttributeAsInt("imageSize");
    }

    /**
     * Size of images shown for fieldTypes image in this field. <P> If set to a String, assumed to be a property on each record
     * that specifies the image height.  For example, if <code>field.imageSize</code> is "logoSize",
     * <code>record.logoSize</code> will control the size of the image.
     *
     * @param imageSize New imageSize value. Default value is null
     * @return {@link com.smartgwt.client.widgets.viewer.DetailViewerField DetailViewerField} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.viewer.DetailViewerField#setImageWidth
     * @see com.smartgwt.client.widgets.viewer.DetailViewerField#setImageHeight
     * @see com.smartgwt.client.docs.ImageColumns ImageColumns overview and related methods
     */
    public DetailViewerField setImageSize(String imageSize) {
        return (DetailViewerField)setAttribute("imageSize", imageSize);
    }

    /**
     * Size of images shown for fieldTypes image in this field. <P> If set to a String, assumed to be a property on each record
     * that specifies the image height.  For example, if <code>field.imageSize</code> is "logoSize",
     * <code>record.logoSize</code> will control the size of the image.
     *
     * @return Current imageSize value. Default value is null
     * @see com.smartgwt.client.widgets.viewer.DetailViewerField#getImageWidth
     * @see com.smartgwt.client.widgets.viewer.DetailViewerField#getImageHeight
     * @see com.smartgwt.client.docs.ImageColumns ImageColumns overview and related methods
     */
    public String getImageSizeAsString()  {
        return getAttributeAsString("imageSize");
    }
    

    /**
     * If this field has type set to <code>"image"</code> and the URL for the image displayed is not absolute, the path of the
     * URL will be relative to this string.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param imageURLPrefix New imageURLPrefix value. Default value is null
     * @return {@link com.smartgwt.client.widgets.viewer.DetailViewerField DetailViewerField} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.ImageColumns ImageColumns overview and related methods
     */
    public DetailViewerField setImageURLPrefix(String imageURLPrefix) {
        return (DetailViewerField)setAttribute("imageURLPrefix", imageURLPrefix);
    }

    /**
     * If this field has type set to <code>"image"</code> and the URL for the image displayed is not absolute, the path of the
     * URL will be relative to this string.
     *
     * @return Current imageURLPrefix value. Default value is null
     * @see com.smartgwt.client.docs.ImageColumns ImageColumns overview and related methods
     */
    public String getImageURLPrefix()  {
        return getAttributeAsString("imageURLPrefix");
    }
    

    /**
     * If this field has type set to <code>"image"</code>, the value of this property will be appended to the end of the URL
     * for the icon displayed.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param imageURLSuffix New imageURLSuffix value. Default value is null
     * @return {@link com.smartgwt.client.widgets.viewer.DetailViewerField DetailViewerField} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.ImageColumns ImageColumns overview and related methods
     */
    public DetailViewerField setImageURLSuffix(String imageURLSuffix) {
        return (DetailViewerField)setAttribute("imageURLSuffix", imageURLSuffix);
    }

    /**
     * If this field has type set to <code>"image"</code>, the value of this property will be appended to the end of the URL
     * for the icon displayed.
     *
     * @return Current imageURLSuffix value. Default value is null
     * @see com.smartgwt.client.docs.ImageColumns ImageColumns overview and related methods
     */
    public String getImageURLSuffix()  {
        return getAttributeAsString("imageURLSuffix");
    }
    

    /**
     * Width of images shown for fieldTypes image in this field. <P> If set to a String, assumed to be a property on each
     * record that specifies the image width.  For example, if <code>field.imageWidth</code> is "logoWidth",
     * <code>record.logoWidth</code> will control the width of the image.
     *
     * @param imageWidth New imageWidth value. Default value is null
     * @return {@link com.smartgwt.client.widgets.viewer.DetailViewerField DetailViewerField} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.viewer.DetailViewerField#setImageSize
     * @see com.smartgwt.client.widgets.viewer.DetailViewerField#setImageHeight
     * @see com.smartgwt.client.docs.ImageColumns ImageColumns overview and related methods
     */
    public DetailViewerField setImageWidth(Integer imageWidth) {
        return (DetailViewerField)setAttribute("imageWidth", imageWidth);
    }

    /**
     * Width of images shown for fieldTypes image in this field. <P> If set to a String, assumed to be a property on each
     * record that specifies the image width.  For example, if <code>field.imageWidth</code> is "logoWidth",
     * <code>record.logoWidth</code> will control the width of the image.
     *
     * @return Current imageWidth value. Default value is null
     * @see com.smartgwt.client.widgets.viewer.DetailViewerField#getImageSize
     * @see com.smartgwt.client.widgets.viewer.DetailViewerField#getImageHeight
     * @see com.smartgwt.client.docs.ImageColumns ImageColumns overview and related methods
     */
    public Integer getImageWidth()  {
        return getAttributeAsInt("imageWidth");
    }

    /**
     * Width of images shown for fieldTypes image in this field. <P> If set to a String, assumed to be a property on each
     * record that specifies the image width.  For example, if <code>field.imageWidth</code> is "logoWidth",
     * <code>record.logoWidth</code> will control the width of the image.
     *
     * @param imageWidth New imageWidth value. Default value is null
     * @return {@link com.smartgwt.client.widgets.viewer.DetailViewerField DetailViewerField} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.viewer.DetailViewerField#setImageSize
     * @see com.smartgwt.client.widgets.viewer.DetailViewerField#setImageHeight
     * @see com.smartgwt.client.docs.ImageColumns ImageColumns overview and related methods
     */
    public DetailViewerField setImageWidth(String imageWidth) {
        return (DetailViewerField)setAttribute("imageWidth", imageWidth);
    }

    /**
     * Width of images shown for fieldTypes image in this field. <P> If set to a String, assumed to be a property on each
     * record that specifies the image width.  For example, if <code>field.imageWidth</code> is "logoWidth",
     * <code>record.logoWidth</code> will control the width of the image.
     *
     * @return Current imageWidth value. Default value is null
     * @see com.smartgwt.client.widgets.viewer.DetailViewerField#getImageSize
     * @see com.smartgwt.client.widgets.viewer.DetailViewerField#getImageHeight
     * @see com.smartgwt.client.docs.ImageColumns ImageColumns overview and related methods
     */
    public String getImageWidthAsString()  {
        return getAttributeAsString("imageWidth");
    }
    

    /**
     * Indicates this field's values come from another, related DataSource.   The individual field will inherit settings such
     * as {@link com.smartgwt.client.widgets.viewer.DetailViewerField#getType field.type} and {@link
     * com.smartgwt.client.widgets.viewer.DetailViewerField#getTitle field.title} from the related DataSource just like fields
     * from the primary DataSource.
     *
     * @param includeFrom New includeFrom value. Default value is null
     * @return {@link com.smartgwt.client.widgets.viewer.DetailViewerField DetailViewerField} instance, for chaining setter calls
     */
    public DetailViewerField setIncludeFrom(String includeFrom) {
        return (DetailViewerField)setAttribute("includeFrom", includeFrom);
    }

    /**
     * Indicates this field's values come from another, related DataSource.   The individual field will inherit settings such
     * as {@link com.smartgwt.client.widgets.viewer.DetailViewerField#getType field.type} and {@link
     * com.smartgwt.client.widgets.viewer.DetailViewerField#getTitle field.title} from the related DataSource just like fields
     * from the primary DataSource.
     *
     * @return Current includeFrom value. Default value is null
     */
    public String getIncludeFrom()  {
        return getAttributeAsString("includeFrom");
    }
    

    /**
     * The HTML to display for values of this field if the field type is set to "link".  <P> This property sets linkText that
     * will be the same for all records.  You can set linkText on a per-record basis via {@link
     * com.smartgwt.client.widgets.viewer.DetailViewerRecord#getLinkText DetailViewerRecord.linkText}.
     *
     * @param linkText New linkText value. Default value is null
     * @return {@link com.smartgwt.client.widgets.viewer.DetailViewerField DetailViewerField} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.viewer.DetailViewerField#setType
     * @see com.smartgwt.client.widgets.viewer.DetailViewerRecord#setLinkText
     * @see com.smartgwt.client.widgets.viewer.DetailViewer#setLinkTextProperty
     * @see com.smartgwt.client.widgets.viewer.DetailViewerField#setLinkTextProperty
     */
    public DetailViewerField setLinkText(String linkText) {
        return (DetailViewerField)setAttribute("linkText", linkText);
    }

    /**
     * The HTML to display for values of this field if the field type is set to "link".  <P> This property sets linkText that
     * will be the same for all records.  You can set linkText on a per-record basis via {@link
     * com.smartgwt.client.widgets.viewer.DetailViewerRecord#getLinkText DetailViewerRecord.linkText}.
     *
     * @return Current linkText value. Default value is null
     * @see com.smartgwt.client.widgets.viewer.DetailViewerField#getType
     * @see com.smartgwt.client.widgets.viewer.DetailViewerRecord#getLinkText
     * @see com.smartgwt.client.widgets.viewer.DetailViewer#getLinkTextProperty
     * @see com.smartgwt.client.widgets.viewer.DetailViewerField#getLinkTextProperty
     */
    public String getLinkText()  {
        return getAttributeAsString("linkText");
    }
    

    /**
     * Name of the property in a DetailViewerRecord that holds the HTML to display for values of this field if the field type
     * is set to "link".
     *
     * @param linkTextProperty New linkTextProperty value. Default value is null
     * @return {@link com.smartgwt.client.widgets.viewer.DetailViewerField DetailViewerField} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.viewer.DetailViewerField#setType
     * @see com.smartgwt.client.widgets.viewer.DetailViewerRecord#setLinkText
     * @see com.smartgwt.client.widgets.viewer.DetailViewerField#setLinkText
     * @see com.smartgwt.client.widgets.viewer.DetailViewer#setLinkTextProperty
     */
    public DetailViewerField setLinkTextProperty(String linkTextProperty) {
        return (DetailViewerField)setAttribute("linkTextProperty", linkTextProperty);
    }

    /**
     * Name of the property in a DetailViewerRecord that holds the HTML to display for values of this field if the field type
     * is set to "link".
     *
     * @return Current linkTextProperty value. Default value is null
     * @see com.smartgwt.client.widgets.viewer.DetailViewerField#getType
     * @see com.smartgwt.client.widgets.viewer.DetailViewerRecord#getLinkText
     * @see com.smartgwt.client.widgets.viewer.DetailViewerField#getLinkText
     * @see com.smartgwt.client.widgets.viewer.DetailViewer#getLinkTextProperty
     */
    public String getLinkTextProperty()  {
        return getAttributeAsString("linkTextProperty");
    }
    

    /**
     * If this field has type set to <code>"link"</code>, setting this property will apply a standard prefix to the link URL
     * when displaying values of this field.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param linkURLPrefix New linkURLPrefix value. Default value is null
     * @return {@link com.smartgwt.client.widgets.viewer.DetailViewerField DetailViewerField} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.viewer.DetailViewerField#setType
     */
    public DetailViewerField setLinkURLPrefix(String linkURLPrefix) {
        return (DetailViewerField)setAttribute("linkURLPrefix", linkURLPrefix);
    }

    /**
     * If this field has type set to <code>"link"</code>, setting this property will apply a standard prefix to the link URL
     * when displaying values of this field.
     *
     * @return Current linkURLPrefix value. Default value is null
     * @see com.smartgwt.client.widgets.viewer.DetailViewerField#getType
     */
    public String getLinkURLPrefix()  {
        return getAttributeAsString("linkURLPrefix");
    }
    

    /**
     * If this field has type set to <code>"link"</code>, setting this property will apply a standard suffix to the link URL
     * when displaying values of this field.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param linkURLSuffix New linkURLSuffix value. Default value is null
     * @return {@link com.smartgwt.client.widgets.viewer.DetailViewerField DetailViewerField} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.viewer.DetailViewerField#setType
     */
    public DetailViewerField setLinkURLSuffix(String linkURLSuffix) {
        return (DetailViewerField)setAttribute("linkURLSuffix", linkURLSuffix);
    }

    /**
     * If this field has type set to <code>"link"</code>, setting this property will apply a standard suffix to the link URL
     * when displaying values of this field.
     *
     * @return Current linkURLSuffix value. Default value is null
     * @see com.smartgwt.client.widgets.viewer.DetailViewerField#getType
     */
    public String getLinkURLSuffix()  {
        return getAttributeAsString("linkURLSuffix");
    }
    

    /**
     * Name property used to identify the field, and determines which attribute from records will be displayed in this field.
     * <P> Must be unique within the DetailViewer as well as a valid JavaScript identifier - see {@link
     * com.smartgwt.client.docs.FieldName} for details and how to check for validity. <P> The attribute of the records to
     * display in this field may also be set by {@link com.smartgwt.client.widgets.viewer.DetailViewerField#getDisplayField
     * displayField}.
     *
     * @param name New name value. Default value is null
     * @return {@link com.smartgwt.client.widgets.viewer.DetailViewerField DetailViewerField} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.FieldName FieldName 
     */
    public DetailViewerField setName(String name) {
        return (DetailViewerField)setAttribute("name", name);
    }

    /**
     * Name property used to identify the field, and determines which attribute from records will be displayed in this field.
     * <P> Must be unique within the DetailViewer as well as a valid JavaScript identifier - see {@link
     * com.smartgwt.client.docs.FieldName} for details and how to check for validity. <P> The attribute of the records to
     * display in this field may also be set by {@link com.smartgwt.client.widgets.viewer.DetailViewerField#getDisplayField
     * displayField}.
     *
     * @return Current name value. Default value is null
     * @see com.smartgwt.client.docs.FieldName FieldName 
     */
    public String getName()  {
        return getAttributeAsString("name");
    }
    

    /**
     * If specified, when generating print HTML for this detailViewer,  cells in this field will be rendered using this css
     * className rather than {@link com.smartgwt.client.widgets.viewer.DetailViewer#getPrintCellStyle
     * DetailViewer.printCellStyle}
     *
     * @param printCellStyle New printCellStyle value. Default value is null
     * @return {@link com.smartgwt.client.widgets.viewer.DetailViewerField DetailViewerField} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public DetailViewerField setPrintCellStyle(String printCellStyle) {
        return (DetailViewerField)setAttribute("printCellStyle", printCellStyle);
    }

    /**
     * If specified, when generating print HTML for this detailViewer,  cells in this field will be rendered using this css
     * className rather than {@link com.smartgwt.client.widgets.viewer.DetailViewer#getPrintCellStyle
     * DetailViewer.printCellStyle}
     *
     * @return Current printCellStyle value. Default value is null
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public String getPrintCellStyle()  {
        return getAttributeAsString("printCellStyle");
    }
    

    /**
     * For a field of type:"imageFile", indicates whether to stream the image and display it inline or to display the View and
     * Download icons.
     *
     * @param showFileInline New showFileInline value. Default value is null
     * @return {@link com.smartgwt.client.widgets.viewer.DetailViewerField DetailViewerField} instance, for chaining setter calls
     */
    public DetailViewerField setShowFileInline(Boolean showFileInline) {
        return (DetailViewerField)setAttribute("showFileInline", showFileInline);
    }

    /**
     * For a field of type:"imageFile", indicates whether to stream the image and display it inline or to display the View and
     * Download icons.
     *
     * @return Current showFileInline value. Default value is null
     */
    public Boolean getShowFileInline()  {
        return getAttributeAsBoolean("showFileInline", true);
    }
    

    /**
     * By default, clicking a link rendered by this item opens it in a new browser window.  You  can alter this behavior by
     * setting this property.  The value of this property will be  passed as the value to the <code>target</code> attribute of
     * the anchor tag used to render  the link.  <code>target</code> is applicable only if the field type is set to "link".
     *
     * @param target New target value. Default value is "_blank"
     * @return {@link com.smartgwt.client.widgets.viewer.DetailViewerField DetailViewerField} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.viewer.DetailViewerField#setType
     */
    public DetailViewerField setTarget(String target) {
        return (DetailViewerField)setAttribute("target", target);
    }

    /**
     * By default, clicking a link rendered by this item opens it in a new browser window.  You  can alter this behavior by
     * setting this property.  The value of this property will be  passed as the value to the <code>target</code> attribute of
     * the anchor tag used to render  the link.  <code>target</code> is applicable only if the field type is set to "link".
     *
     * @return Current target value. Default value is "_blank"
     * @see com.smartgwt.client.widgets.viewer.DetailViewerField#getType
     */
    public String getTarget()  {
        return getAttributeAsString("target");
    }
    

    /**
     * Time-format to apply to date type values within this field.  If specified, any dates displayed in this field will be
     * formatted as times using the appropriate format. This is most commonly only applied to fields specified as type
     * <code>"time"</code> though if no explicit {@link com.smartgwt.client.widgets.viewer.DetailViewerField#getDateFormatter
     * dateFormatter} is specified it will be respected for other  fields as well. <P> If unspecified, a timeFormatter may be
     * defined  {@link com.smartgwt.client.widgets.viewer.DetailViewer#getTimeFormatter at the component level} and will be
     * respected by fields of type <code>"time"</code>.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param timeFormatter New timeFormatter value. Default value is null
     * @return {@link com.smartgwt.client.widgets.viewer.DetailViewerField DetailViewerField} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public DetailViewerField setTimeFormatter(TimeDisplayFormat timeFormatter) {
        return (DetailViewerField)setAttribute("timeFormatter", timeFormatter == null ? null : timeFormatter.getValue());
    }

    /**
     * Time-format to apply to date type values within this field.  If specified, any dates displayed in this field will be
     * formatted as times using the appropriate format. This is most commonly only applied to fields specified as type
     * <code>"time"</code> though if no explicit {@link com.smartgwt.client.widgets.viewer.DetailViewerField#getDateFormatter
     * dateFormatter} is specified it will be respected for other  fields as well. <P> If unspecified, a timeFormatter may be
     * defined  {@link com.smartgwt.client.widgets.viewer.DetailViewer#getTimeFormatter at the component level} and will be
     * respected by fields of type <code>"time"</code>.
     *
     * @return Current timeFormatter value. Default value is null
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public TimeDisplayFormat getTimeFormatter()  {
        return EnumUtil.getEnum(TimeDisplayFormat.values(), getAttribute("timeFormatter"));
    }
    

    /**
     * The title of the field as displayed on the left-hand side.  If left unspecified, the title of the field is derived by
     * looking up the value of {@link com.smartgwt.client.widgets.viewer.DetailViewer#getFieldIdProperty
     * DetailViewer.fieldIdProperty} on this field.  So, by default, the title of a field is the value of its "name" property.
     *
     * @param title New title value. Default value is null
     * @return {@link com.smartgwt.client.widgets.viewer.DetailViewerField DetailViewerField} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.viewer.DetailViewer#setFieldIdProperty
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public DetailViewerField setTitle(String title) {
        return (DetailViewerField)setAttribute("title", title);
    }

    /**
     * The title of the field as displayed on the left-hand side.  If left unspecified, the title of the field is derived by
     * looking up the value of {@link com.smartgwt.client.widgets.viewer.DetailViewer#getFieldIdProperty
     * DetailViewer.fieldIdProperty} on this field.  So, by default, the title of a field is the value of its "name" property.
     *
     * @return Current title value. Default value is null
     * @see com.smartgwt.client.widgets.viewer.DetailViewer#getFieldIdProperty
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public String getTitle()  {
        return getAttributeAsString("title");
    }
    

    /**
     * Specifies the type of this DetailViewerField.  By default (value is <code>null</code>) the field shows a field title on
     * the left and the field value on the right.  There are four special values for this attribute: <ul> <li>"header" - If you
     * specify type "header", the field spans both the field name and field value columns and contains text defined in the
     * {@link com.smartgwt.client.widgets.viewer.DetailViewerField#getValue value} attribute with the style specified by {@link
     * com.smartgwt.client.widgets.viewer.DetailViewer#getHeaderStyle DetailViewer.headerStyle}.  You can use this field type
     * as a titled separator. <li>"separator" - If you specify type "separator", the field spans both the field name and the
     * field value columns with no text, and is styled using the style specified via {@link
     * com.smartgwt.client.widgets.viewer.DetailViewer#getSeparatorStyle DetailViewer.separatorStyle}.  The height of the
     * separator field can be controlled via {@link com.smartgwt.client.widgets.viewer.DetailViewerField#getHeight height}.
     * <li>"image" For viewing, a thumbnail image is rendered in the field.  The URL of the image is the value of the field,
     * and should be absolute. The size of the image is controlled by {@link
     * com.smartgwt.client.widgets.viewer.DetailViewerField#getImageSize imageSize}, {@link
     * com.smartgwt.client.widgets.viewer.DetailViewerField#getImageWidth imageWidth}, {@link
     * com.smartgwt.client.widgets.viewer.DetailViewerField#getImageHeight imageHeight} <li><p>"link" For viewing, a clickable
     * html link (using an HTML anchor tag: &lt;A&gt;) is rendered in the field.  The target URL is the value of the field,
     * which is also the default display value.  You can override the display value by setting {@link
     * com.smartgwt.client.widgets.viewer.DetailViewerRecord#getLinkText DetailViewerRecord.linkText} or {@link
     * com.smartgwt.client.widgets.viewer.DetailViewerField#getLinkText linkText}.</p> <p> Clicking the link opens the URL in a
     * new window by default.  To change this behavior, you can set <code>field.target</code>, which works identically to the
     * "target" attribute on an HTML anchor (&lt;A&gt;) tag.  See {@link
     * com.smartgwt.client.widgets.viewer.DetailViewerField#getTarget target} for more information.</p></li> </ul>
     *
     * @param type New type value. Default value is null
     * @return {@link com.smartgwt.client.widgets.viewer.DetailViewerField DetailViewerField} instance, for chaining setter calls
     */
    public DetailViewerField setType(String type) {
        return (DetailViewerField)setAttribute("type", type);
    }

    /**
     * Specifies the type of this DetailViewerField.  By default (value is <code>null</code>) the field shows a field title on
     * the left and the field value on the right.  There are four special values for this attribute: <ul> <li>"header" - If you
     * specify type "header", the field spans both the field name and field value columns and contains text defined in the
     * {@link com.smartgwt.client.widgets.viewer.DetailViewerField#getValue value} attribute with the style specified by {@link
     * com.smartgwt.client.widgets.viewer.DetailViewer#getHeaderStyle DetailViewer.headerStyle}.  You can use this field type
     * as a titled separator. <li>"separator" - If you specify type "separator", the field spans both the field name and the
     * field value columns with no text, and is styled using the style specified via {@link
     * com.smartgwt.client.widgets.viewer.DetailViewer#getSeparatorStyle DetailViewer.separatorStyle}.  The height of the
     * separator field can be controlled via {@link com.smartgwt.client.widgets.viewer.DetailViewerField#getHeight height}.
     * <li>"image" For viewing, a thumbnail image is rendered in the field.  The URL of the image is the value of the field,
     * and should be absolute. The size of the image is controlled by {@link
     * com.smartgwt.client.widgets.viewer.DetailViewerField#getImageSize imageSize}, {@link
     * com.smartgwt.client.widgets.viewer.DetailViewerField#getImageWidth imageWidth}, {@link
     * com.smartgwt.client.widgets.viewer.DetailViewerField#getImageHeight imageHeight} <li><p>"link" For viewing, a clickable
     * html link (using an HTML anchor tag: &lt;A&gt;) is rendered in the field.  The target URL is the value of the field,
     * which is also the default display value.  You can override the display value by setting {@link
     * com.smartgwt.client.widgets.viewer.DetailViewerRecord#getLinkText DetailViewerRecord.linkText} or {@link
     * com.smartgwt.client.widgets.viewer.DetailViewerField#getLinkText linkText}.</p> <p> Clicking the link opens the URL in a
     * new window by default.  To change this behavior, you can set <code>field.target</code>, which works identically to the
     * "target" attribute on an HTML anchor (&lt;A&gt;) tag.  See {@link
     * com.smartgwt.client.widgets.viewer.DetailViewerField#getTarget target} for more information.</p></li> </ul>
     *
     * @return Current type value. Default value is null
     */
    public String getType()  {
        return getAttributeAsString("type");
    }
    

    /**
     * When a field specifies its {@link com.smartgwt.client.widgets.viewer.DetailViewerField#getType type} to be "header", the
     * value of this attribute specifies the header text.
     *
     * @param value New value value. Default value is "undefined"
     * @return {@link com.smartgwt.client.widgets.viewer.DetailViewerField DetailViewerField} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public DetailViewerField setValue(String value) {
        return (DetailViewerField)setAttribute("value", value);
    }

    /**
     * When a field specifies its {@link com.smartgwt.client.widgets.viewer.DetailViewerField#getType type} to be "header", the
     * value of this attribute specifies the header text.
     *
     * @return Current value value. Default value is "undefined"
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public String getValue()  {
        return getAttributeAsString("value");
    }
    

    /**
     * A property list (or an expression that evaluates to a property list) specifying a mapping of internal values to display
     * values for the field (row).
     *
     * @param valueMap New valueMap value. Default value is null
     * @return {@link com.smartgwt.client.widgets.viewer.DetailViewerField DetailViewerField} instance, for chaining setter calls
     */
    public DetailViewerField setValueMap(Map valueMap) {
        return (DetailViewerField)setAttribute("valueMap", valueMap);
    }
    

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************

    // ***********************************************************



    /**
     * If specified on a field, this method is evaluated at draw time to determine whether or not to show this
     * particular field. <p> This method can be specified either as a function or a string that will be auto-converted
     * to a function.
     * @param showIf the showIf criteria
     */
    public native void setShowIfCondition(DetailViewerFieldIfFunction showIf) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.showIf = $debox($entry(function(viewer, records) {
            var viewerJ = @com.smartgwt.client.widgets.BaseWidget::getRef(Lcom/google/gwt/core/client/JavaScriptObject;)(viewer);
            var recordsJ = @com.smartgwt.client.util.ConvertTo::arrayOfDetailViewerRecord(Lcom/google/gwt/core/client/JavaScriptObject;)(records);
            return showIf.@com.smartgwt.client.widgets.viewer.DetailViewerFieldIfFunction::execute(Lcom/smartgwt/client/widgets/viewer/DetailViewer;[Lcom/smartgwt/client/widgets/viewer/DetailViewerRecord;)(viewerJ, recordsJ);
        }));
    }-*/;

    public native void setDetailFormatter(DetailFormatter formatter) /*-{
            var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
            self.formatCellValue = $debox($entry(function(value, record, field) {
                var recordJ = @com.smartgwt.client.data.Record::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(record);
                var valueJ = $wnd.SmartGWT.convertToJavaType(value);
                var fieldJ = @com.smartgwt.client.widgets.viewer.DetailViewerField::new(Lcom/google/gwt/core/client/JavaScriptObject;)(field);
                return formatter.@com.smartgwt.client.widgets.viewer.DetailFormatter::format(Ljava/lang/Object;Lcom/smartgwt/client/data/Record;Lcom/smartgwt/client/widgets/viewer/DetailViewerField;)(valueJ, recordJ, fieldJ);
            }));
    }-*/;

    /**
     * Return the CSS class for a cell. Not implemented by default. The state of the record is indicated by adding a
     * suffix to the base style. There are three independant boolean states, which are combined in the order given: <ol>
     * <li>"Selected" : whether cell is selected; enable by passing a Selection object as "selection" <li>"Over" : mouse
     * is over this cell; enable with showRollovers <li>"Down" : mouse button is down over this cell </ol> For example,
     * with a baseStyle of "myCell", a cell which is selected, which the mouse is over, will get a styleName of
     * myCellSelectedOver. <p> Cell Styles customizable by: <ul> <li>implementing this function  <li>setting {@link
     * com.smartgwt.client.widgets.viewer.DetailViewer#getCellStyle cellStyle} <li>overriding {@link
     * com.smartgwt.client.widgets.viewer.DetailViewer#getCellStyle} </ul>
     */
    public native void setCellStyleHandler(CellStyleHandler handler) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.getCellStyle = $debox($entry(function(value, field, record, viewer) {
            var valueJ = $wnd.SmartGWT.convertToJavaType(value);
            var fieldJ = @com.smartgwt.client.widgets.viewer.DetailViewerField::new(Lcom/google/gwt/core/client/JavaScriptObject;)(field);
            var recordJ = @com.smartgwt.client.widgets.viewer.DetailViewerRecord::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(record);
            return handler.@com.smartgwt.client.widgets.viewer.CellStyleHandler::execute(Ljava/lang/Object;Lcom/smartgwt/client/widgets/viewer/DetailViewerField;Lcom/smartgwt/client/data/Record;)(valueJ, fieldJ, recordJ);
        }));
    }-*/;

}
