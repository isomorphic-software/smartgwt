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
 
package com.smartgwt.client.widgets.viewer;


import com.smartgwt.client.event.*;
import com.smartgwt.client.core.*;
import com.smartgwt.client.types.*;
import com.smartgwt.client.data.*;
import com.smartgwt.client.data.events.*;
import com.smartgwt.client.rpc.*;
import com.smartgwt.client.callbacks.*;
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
import com.smartgwt.client.widgets.tab.*;
import com.smartgwt.client.widgets.toolbar.*;
import com.smartgwt.client.widgets.tree.*;
import com.smartgwt.client.widgets.tree.events.*;
import com.smartgwt.client.widgets.viewer.*;
import com.smartgwt.client.widgets.calendar.*;
import com.smartgwt.client.widgets.calendar.events.*;
import com.smartgwt.client.widgets.cube.*;
import com.smartgwt.client.widgets.drawing.*;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashMap;

import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;
import com.smartgwt.client.util.*;
import com.smartgwt.client.util.workflow.*;
import com.google.gwt.event.shared.*;
import com.google.gwt.event.shared.HasHandlers;
import com.smartgwt.logicalstructure.core.*;
import com.smartgwt.logicalstructure.widgets.*;
import com.smartgwt.logicalstructure.widgets.drawing.*;
import com.smartgwt.logicalstructure.widgets.plugins.*;
import com.smartgwt.logicalstructure.widgets.form.*;
import com.smartgwt.logicalstructure.widgets.tile.*;
import com.smartgwt.logicalstructure.widgets.grid.*;
import com.smartgwt.logicalstructure.widgets.chart.*;
import com.smartgwt.logicalstructure.widgets.layout.*;
import com.smartgwt.logicalstructure.widgets.menu.*;
import com.smartgwt.logicalstructure.widgets.tab.*;
import com.smartgwt.logicalstructure.widgets.tableview.*;
import com.smartgwt.logicalstructure.widgets.toolbar.*;
import com.smartgwt.logicalstructure.widgets.tree.*;
import com.smartgwt.logicalstructure.widgets.viewer.*;
import com.smartgwt.logicalstructure.widgets.calendar.*;
import com.smartgwt.logicalstructure.widgets.cube.*;

/**
 * An object literal with a particular set of properties used to configure the display of and interaction with the rows of
 * a {@link com.smartgwt.client.widgets.viewer.DetailViewer}.
 */
public class DetailViewerField extends DataClass {

    public static DetailViewerField getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        return new DetailViewerField(jsObj);
    }

    public void setJavaScriptObject(JavaScriptObject jsObj) {
        this.jsObj = jsObj;
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
     * @param canExport canExport Default value is null
     */
    public void setCanExport(Boolean canExport) {
        setAttribute("canExport", canExport);
    }

    /**
     * Dictates whether the data in this field be exported.  Explicitly set this  to false to prevent exporting.  Has no effect
     * if the underlying   {@link com.smartgwt.client.data.DataSourceField#getCanExport dataSourceField} is explicitly set to  
     * canExport: false.
     *
     * @return Boolean
     */
    public Boolean getCanExport()  {
        return getAttributeAsBoolean("canExport");
    }


    /**
     * Determines whether this field can be hilited.  Set to false to prevent this field from appearing in HiliteEditor.
     *
     * @param canHilite canHilite Default value is null
     * @see com.smartgwt.client.docs.Hiliting Hiliting overview and related methods
     */
    public void setCanHilite(Boolean canHilite) {
        setAttribute("canHilite", canHilite);
    }

    /**
     * Determines whether this field can be hilited.  Set to false to prevent this field from appearing in HiliteEditor.
     *
     * @return Boolean
     * @see com.smartgwt.client.docs.Hiliting Hiliting overview and related methods
     */
    public Boolean getCanHilite()  {
        return getAttributeAsBoolean("canHilite");
    }


    /**
     * If specified, cells in this field will be rendered using this css className rather than {@link
     * com.smartgwt.client.widgets.viewer.DetailViewer#getCellStyle cellStyle}
     *
     * @param cellStyle . See {@link com.smartgwt.client.docs.CSSClassName CSSClassName}. Default value is null
     */
    public void setCellStyle(String cellStyle) {
        setAttribute("cellStyle", cellStyle);
    }

    /**
     * If specified, cells in this field will be rendered using this css className rather than {@link
     * com.smartgwt.client.widgets.viewer.DetailViewer#getCellStyle cellStyle}
     *
     * @return Optional method to return the CSS class for cells in this field. If specified, this method will be called from {@link
     * com.smartgwt.client.widgets.viewer.DetailViewer#getCellStyle DetailViewer.getCellStyle}, and should return a css class
     * name.. See {@link com.smartgwt.client.docs.CSSClassName CSSClassName}
     */
    public String getCellStyle()  {
        return getAttributeAsString("cellStyle");
    }


    /**
     * dataPath property allows this field to display detail from nested data structures
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param dataPath . See {@link com.smartgwt.client.docs.String String}. Default value is null
     */
    public void setDataPath(String dataPath) {
        setAttribute("dataPath", dataPath);
    }

    /**
     * dataPath property allows this field to display detail from nested data structures
     *
     * @return . See {@link com.smartgwt.client.docs.String String}
     */
    public String getDataPath()  {
        return getAttributeAsString("dataPath");
    }


    /**
     * Display format to use for date type values within this field.  <P> The {@link
     * com.smartgwt.client.widgets.viewer.DetailViewerField#getTimeFormatter timeFormatter} may also be used to format
     * underlying Date values as times (ommitting the date part entirely). If both <code>dateFormatter</code> and
     * <code>timeFormatter</code> are specified on a field, for fields specified as {@link
     * com.smartgwt.client.widgets.viewer.DetailViewerField#getType type "time"} the <code>timeFormatter</code> will be used,
     * otherwise the <code>dateFormatter</code> <P> If <code>field.dateFormatter</code> and <code>field.timeFormatter</code> is
     * unspecified, date display format may be defined at the component level via {@link
     * com.smartgwt.client.widgets.viewer.DetailViewer#getDateFormatter dateFormatter}, or for fields of type
     * <code>"datetime"</code> {@link com.smartgwt.client.widgets.viewer.DetailViewer#getDatetimeFormatter datetimeFormatter}.
     * Otherwise the default is to use the system-wide default normal date format, configured via {@link
     * com.smartgwt.client.util.Date#setNormalDisplayFormat Date.setNormalDisplayFormat}.  Specify any valid {@link
     * com.smartgwt.client.types.DateDisplayFormat} to  change the format used by this item.
     *
     * @param dateFormatter dateFormatter Default value is null
     * @see com.smartgwt.client.widgets.grid.ListGrid#setDateFormatter
     * @see com.smartgwt.client.widgets.grid.ListGrid#setDatetimeFormatter
     * @see com.smartgwt.client.widgets.grid.ListGridField#setTimeFormatter
     */
    public void setDateFormatter(DateDisplayFormat dateFormatter) {
        setAttribute("dateFormatter", dateFormatter == null ? null : dateFormatter.getValue());
    }

    /**
     * Display format to use for date type values within this field.  <P> The {@link
     * com.smartgwt.client.widgets.viewer.DetailViewerField#getTimeFormatter timeFormatter} may also be used to format
     * underlying Date values as times (ommitting the date part entirely). If both <code>dateFormatter</code> and
     * <code>timeFormatter</code> are specified on a field, for fields specified as {@link
     * com.smartgwt.client.widgets.viewer.DetailViewerField#getType type "time"} the <code>timeFormatter</code> will be used,
     * otherwise the <code>dateFormatter</code> <P> If <code>field.dateFormatter</code> and <code>field.timeFormatter</code> is
     * unspecified, date display format may be defined at the component level via {@link
     * com.smartgwt.client.widgets.viewer.DetailViewer#getDateFormatter dateFormatter}, or for fields of type
     * <code>"datetime"</code> {@link com.smartgwt.client.widgets.viewer.DetailViewer#getDatetimeFormatter datetimeFormatter}.
     * Otherwise the default is to use the system-wide default normal date format, configured via {@link
     * com.smartgwt.client.util.Date#setNormalDisplayFormat Date.setNormalDisplayFormat}.  Specify any valid {@link
     * com.smartgwt.client.types.DateDisplayFormat} to  change the format used by this item.
     *
     * @return DateDisplayFormat
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
     * @param decimalPad decimalPad Default value is null
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setDecimalPad(Integer decimalPad) {
        setAttribute("decimalPad", decimalPad);
    }

    /**
     * Applies only to fields of type "float" and enforces a minimum number of digits shown after the decimal point. <P> For
     * example, a field value of 343.1, 343.104 and 343.09872677 would all be shown as 343.10 if decimalPad is 2. <P> The
     * original unpadded value is always shown when the value is edited.
     *
     * @return Integer
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Integer getDecimalPad()  {
        return getAttributeAsInt("decimalPad");
    }


    /**
     * Applies only to fields of type "float" and affects how many significant digits are shown. <P> For example, with
     * decimalPrecision 3, if the field value is 343.672677, 343.673 is shown. <P> If the value is 125.2, 125.2 is shown -
     * decimalPrecision will not cause extra zeros to be added.  Use {@link
     * com.smartgwt.client.data.DataSourceField#getDecimalPad decimalPad} for this. <P> A number is always shown with its
     * original precision when edited.
     *
     * @param decimalPrecision decimalPrecision Default value is null
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setDecimalPrecision(Integer decimalPrecision) {
        setAttribute("decimalPrecision", decimalPrecision);
    }

    /**
     * Applies only to fields of type "float" and affects how many significant digits are shown. <P> For example, with
     * decimalPrecision 3, if the field value is 343.672677, 343.673 is shown. <P> If the value is 125.2, 125.2 is shown -
     * decimalPrecision will not cause extra zeros to be added.  Use {@link
     * com.smartgwt.client.data.DataSourceField#getDecimalPad decimalPad} for this. <P> A number is always shown with its
     * original precision when edited.
     *
     * @return Integer
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
     * @param displayField . See {@link com.smartgwt.client.docs.String String}. Default value is null
     */
    public void setDisplayField(String displayField) {
        setAttribute("displayField", displayField);
    }

    /**
     * If <code>displayField</code> is defined for the field then the DetailViewer will display the <code>displayField</code>
     * attribute of records instead of the attribute given by the {@link
     * com.smartgwt.client.widgets.viewer.DetailViewerField#getName name} of the field.
     *
     * @return . See {@link com.smartgwt.client.docs.String String}
     */
    public String getDisplayField()  {
        return getAttributeAsString("displayField");
    }


    /**
     * By default HTML values in DetailViewer cells will be interpreted by the browser. Setting this flag to true will causes
     * HTML characters to be escaped, meaning the raw value of the field (for example <code>"&lt;b&gt;AAA&lt;/b&gt;"</code>) is
     * displayed to the user rather than the interpreted HTML (for example <code>"<b>AAA</b>"</code>)
     *
     * @param escapeHTML escapeHTML Default value is null
     */
    public void setEscapeHTML(Boolean escapeHTML) {
        setAttribute("escapeHTML", escapeHTML);
    }

    /**
     * By default HTML values in DetailViewer cells will be interpreted by the browser. Setting this flag to true will causes
     * HTML characters to be escaped, meaning the raw value of the field (for example <code>"&lt;b&gt;AAA&lt;/b&gt;"</code>) is
     * displayed to the user rather than the interpreted HTML (for example <code>"<b>AAA</b>"</code>)
     *
     * @return Boolean
     */
    public Boolean getEscapeHTML()  {
        return getAttributeAsBoolean("escapeHTML");
    }


    /**
     * For {@link com.smartgwt.client.widgets.viewer.DetailViewerField#getType type}: <code>"separator"</code>, this attribute
     * specifies the height of the separator.
     *
     * @param height height Default value is null
     */
    public void setHeight(Integer height) {
        setAttribute("height", height);
    }

    /**
     * For {@link com.smartgwt.client.widgets.viewer.DetailViewerField#getType type}: <code>"separator"</code>, this attribute
     * specifies the height of the separator.
     *
     * @return Integer
     */
    public Integer getHeight()  {
        return getAttributeAsInt("height");
    }


    /**
     * Height for hilite icons for this field. Overrides {@link
     * com.smartgwt.client.widgets.viewer.DetailViewer#getHiliteIconSize hiliteIconSize}, {@link
     * com.smartgwt.client.widgets.viewer.DetailViewer#getHiliteIconHeight hiliteIconHeight}, and {@link
     * com.smartgwt.client.widgets.viewer.DetailViewerField#getHiliteIconSize hiliteIconSize}.
     *
     * @param hiliteIconHeight hiliteIconHeight Default value is null
     * @see com.smartgwt.client.docs.Hiliting Hiliting overview and related methods
     */
    public void setHiliteIconHeight(Integer hiliteIconHeight) {
        setAttribute("hiliteIconHeight", hiliteIconHeight);
    }

    /**
     * Height for hilite icons for this field. Overrides {@link
     * com.smartgwt.client.widgets.viewer.DetailViewer#getHiliteIconSize hiliteIconSize}, {@link
     * com.smartgwt.client.widgets.viewer.DetailViewer#getHiliteIconHeight hiliteIconHeight}, and {@link
     * com.smartgwt.client.widgets.viewer.DetailViewerField#getHiliteIconSize hiliteIconSize}.
     *
     * @return Integer
     * @see com.smartgwt.client.docs.Hiliting Hiliting overview and related methods
     */
    public Integer getHiliteIconHeight()  {
        return getAttributeAsInt("hiliteIconHeight");
    }


    /**
     * How much padding should there be on the left of {@link com.smartgwt.client.widgets.viewer.DetailViewer#getHiliteIcons
     * hilite icons}  for this field? Overrides {@link com.smartgwt.client.widgets.viewer.DetailViewer#getHiliteIconLeftPadding
     * hiliteIconLeftPadding}
     *
     * @param hiliteIconLeftPadding hiliteIconLeftPadding Default value is null
     * @see com.smartgwt.client.docs.Hiliting Hiliting overview and related methods
     */
    public void setHiliteIconLeftPadding(Integer hiliteIconLeftPadding) {
        setAttribute("hiliteIconLeftPadding", hiliteIconLeftPadding);
    }

    /**
     * How much padding should there be on the left of {@link com.smartgwt.client.widgets.viewer.DetailViewer#getHiliteIcons
     * hilite icons}  for this field? Overrides {@link com.smartgwt.client.widgets.viewer.DetailViewer#getHiliteIconLeftPadding
     * hiliteIconLeftPadding}
     *
     * @return Integer
     * @see com.smartgwt.client.docs.Hiliting Hiliting overview and related methods
     */
    public Integer getHiliteIconLeftPadding()  {
        return getAttributeAsInt("hiliteIconLeftPadding");
    }


    /**
     * When {@link com.smartgwt.client.widgets.viewer.DetailViewer#getHiliteIcons hiliteIcons} are present, where the hilite
     * icon will be placed  relative to the field value.  See {@link com.smartgwt.client.types.HiliteIconPosition}. Overrides
     * {@link com.smartgwt.client.widgets.viewer.DetailViewer#getHiliteIconPosition hiliteIconPosition}
     *
     * @param hiliteIconPosition hiliteIconPosition Default value is null
     * @see com.smartgwt.client.docs.Hiliting Hiliting overview and related methods
     */
    public void setHiliteIconPosition(HiliteIconPosition hiliteIconPosition) {
        setAttribute("hiliteIconPosition", hiliteIconPosition == null ? null : hiliteIconPosition.getValue());
    }

    /**
     * When {@link com.smartgwt.client.widgets.viewer.DetailViewer#getHiliteIcons hiliteIcons} are present, where the hilite
     * icon will be placed  relative to the field value.  See {@link com.smartgwt.client.types.HiliteIconPosition}. Overrides
     * {@link com.smartgwt.client.widgets.viewer.DetailViewer#getHiliteIconPosition hiliteIconPosition}
     *
     * @return HiliteIconPosition
     * @see com.smartgwt.client.docs.Hiliting Hiliting overview and related methods
     */
    public HiliteIconPosition getHiliteIconPosition()  {
        return EnumUtil.getEnum(HiliteIconPosition.values(), getAttribute("hiliteIconPosition"));
    }


    /**
     * How much padding should there be on the right of {@link com.smartgwt.client.widgets.viewer.DetailViewer#getHiliteIcons
     * hilite icons}  for this field? Overrides {@link
     * com.smartgwt.client.widgets.viewer.DetailViewer#getHiliteIconRightPadding hiliteIconRightPadding}
     *
     * @param hiliteIconRightPadding hiliteIconRightPadding Default value is null
     * @see com.smartgwt.client.docs.Hiliting Hiliting overview and related methods
     */
    public void setHiliteIconRightPadding(Integer hiliteIconRightPadding) {
        setAttribute("hiliteIconRightPadding", hiliteIconRightPadding);
    }

    /**
     * How much padding should there be on the right of {@link com.smartgwt.client.widgets.viewer.DetailViewer#getHiliteIcons
     * hilite icons}  for this field? Overrides {@link
     * com.smartgwt.client.widgets.viewer.DetailViewer#getHiliteIconRightPadding hiliteIconRightPadding}
     *
     * @return Integer
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
     * @param hiliteIconSize hiliteIconSize Default value is null
     * @see com.smartgwt.client.widgets.viewer.DetailViewer#setHiliteIconSize
     * @see com.smartgwt.client.widgets.viewer.DetailViewerField#setHiliteIconWidth
     * @see com.smartgwt.client.widgets.viewer.DetailViewerField#setHiliteIconHeight
     * @see com.smartgwt.client.docs.Hiliting Hiliting overview and related methods
     */
    public void setHiliteIconSize(Integer hiliteIconSize) {
        setAttribute("hiliteIconSize", hiliteIconSize);
    }

    /**
     * Default width and height of {@link com.smartgwt.client.widgets.viewer.DetailViewer#getHiliteIcons hilite icons} in this
     * field. Takes precedence over hiliteIconWidth, hiliteIconHeight and hiliteIconSize specified at the component level. Can
     * be overridden via {@link com.smartgwt.client.widgets.viewer.DetailViewerField#getHiliteIconWidth hiliteIconWidth} and
     * {@link com.smartgwt.client.widgets.viewer.DetailViewerField#getHiliteIconHeight hiliteIconHeight}
     *
     * @return Integer
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
     * com.smartgwt.client.widgets.viewer.DetailViewer#getHiliteIconSize hiliteIconSize}, {@link
     * com.smartgwt.client.widgets.viewer.DetailViewer#getHiliteIconWidth hiliteIconWidth}, and {@link
     * com.smartgwt.client.widgets.viewer.DetailViewerField#getHiliteIconSize hiliteIconSize}.
     *
     * @param hiliteIconWidth hiliteIconWidth Default value is null
     * @see com.smartgwt.client.docs.Hiliting Hiliting overview and related methods
     */
    public void setHiliteIconWidth(Integer hiliteIconWidth) {
        setAttribute("hiliteIconWidth", hiliteIconWidth);
    }

    /**
     * Width for hilite icons for this field. Overrides {@link
     * com.smartgwt.client.widgets.viewer.DetailViewer#getHiliteIconSize hiliteIconSize}, {@link
     * com.smartgwt.client.widgets.viewer.DetailViewer#getHiliteIconWidth hiliteIconWidth}, and {@link
     * com.smartgwt.client.widgets.viewer.DetailViewerField#getHiliteIconSize hiliteIconSize}.
     *
     * @return Integer
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
     * @param imageHeight imageHeight Default value is null
     * @see com.smartgwt.client.widgets.viewer.DetailViewerField#setImageSize
     * @see com.smartgwt.client.widgets.viewer.DetailViewerField#setImageWidth
     * @see com.smartgwt.client.docs.ImageColumns ImageColumns overview and related methods
     */
    public void setImageHeight(Integer imageHeight) {
        setAttribute("imageHeight", imageHeight);
    }

    /**
     * Height of image shown for fieldTypes image in this field. <P> If set to a String, assumed to be a property on each
     * record that specifies the image height.  For example, if <code>field.imageHeight</code> is "logoHeight",
     * <code>record.logoHeight</code> will control the height of the image.
     *
     * @return Integer
     * @see com.smartgwt.client.widgets.viewer.DetailViewerField#getImageSize
     * @see com.smartgwt.client.widgets.viewer.DetailViewerField#getImageWidth
     * @see com.smartgwt.client.docs.ImageColumns ImageColumns overview and related methods
     */
    public Integer getImageHeight()  {
        return getAttributeAsInt("imageHeight");
    }


    /**
     * Size of images shown for fieldTypes image in this field. <P> If set to a String, assumed to be a property on each record
     * that specifies the image height.  For example, if <code>field.imageSize</code> is "logoSize",
     * <code>record.logoSize</code> will control the size of the image.
     *
     * @param imageSize imageSize Default value is null
     * @see com.smartgwt.client.widgets.viewer.DetailViewerField#setImageWidth
     * @see com.smartgwt.client.widgets.viewer.DetailViewerField#setImageHeight
     * @see com.smartgwt.client.docs.ImageColumns ImageColumns overview and related methods
     */
    public void setImageSize(Integer imageSize) {
        setAttribute("imageSize", imageSize);
    }

    /**
     * Size of images shown for fieldTypes image in this field. <P> If set to a String, assumed to be a property on each record
     * that specifies the image height.  For example, if <code>field.imageSize</code> is "logoSize",
     * <code>record.logoSize</code> will control the size of the image.
     *
     * @return Integer
     * @see com.smartgwt.client.widgets.viewer.DetailViewerField#getImageWidth
     * @see com.smartgwt.client.widgets.viewer.DetailViewerField#getImageHeight
     * @see com.smartgwt.client.docs.ImageColumns ImageColumns overview and related methods
     */
    public Integer getImageSize()  {
        return getAttributeAsInt("imageSize");
    }


    /**
     * If this field has type set to <code>"image"</code> and the URL for the image displayed is not absolute, the path of the
     * URL will be relative to this string<br>
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param imageURLPrefix . See {@link com.smartgwt.client.docs.String String}. Default value is null
     * @see com.smartgwt.client.docs.ImageColumns ImageColumns overview and related methods
     */
    public void setImageURLPrefix(String imageURLPrefix) {
        setAttribute("imageURLPrefix", imageURLPrefix);
    }

    /**
     * If this field has type set to <code>"image"</code> and the URL for the image displayed is not absolute, the path of the
     * URL will be relative to this string<br>
     *
     * @return . See {@link com.smartgwt.client.docs.String String}
     * @see com.smartgwt.client.docs.ImageColumns ImageColumns overview and related methods
     */
    public String getImageURLPrefix()  {
        return getAttributeAsString("imageURLPrefix");
    }


    /**
     * Width of images shown for fieldTypes image in this field. <P> If set to a String, assumed to be a property on each
     * record that specifies the image width.  For example, if <code>field.imageWidth</code> is "logoWidth",
     * <code>record.logoWidth</code> will control the width of the image.
     *
     * @param imageWidth imageWidth Default value is null
     * @see com.smartgwt.client.widgets.viewer.DetailViewerField#setImageSize
     * @see com.smartgwt.client.widgets.viewer.DetailViewerField#setImageHeight
     * @see com.smartgwt.client.docs.ImageColumns ImageColumns overview and related methods
     */
    public void setImageWidth(Integer imageWidth) {
        setAttribute("imageWidth", imageWidth);
    }

    /**
     * Width of images shown for fieldTypes image in this field. <P> If set to a String, assumed to be a property on each
     * record that specifies the image width.  For example, if <code>field.imageWidth</code> is "logoWidth",
     * <code>record.logoWidth</code> will control the width of the image.
     *
     * @return Integer
     * @see com.smartgwt.client.widgets.viewer.DetailViewerField#getImageSize
     * @see com.smartgwt.client.widgets.viewer.DetailViewerField#getImageHeight
     * @see com.smartgwt.client.docs.ImageColumns ImageColumns overview and related methods
     */
    public Integer getImageWidth()  {
        return getAttributeAsInt("imageWidth");
    }


    /**
     * Indicates this field's values come from another, related DataSource.   The individual field will inherit settings such
     * as {@link com.smartgwt.client.widgets.viewer.DetailViewerField#getType field.type} and {@link
     * com.smartgwt.client.widgets.viewer.DetailViewerField#getTitle field.title} from the related DataSource just like fields
     * from the primary DataSource.
     *
     * @param includeFrom . See {@link com.smartgwt.client.docs.String String}. Default value is null
     */
    public void setIncludeFrom(String includeFrom) {
        setAttribute("includeFrom", includeFrom);
    }

    /**
     * Indicates this field's values come from another, related DataSource.   The individual field will inherit settings such
     * as {@link com.smartgwt.client.widgets.viewer.DetailViewerField#getType field.type} and {@link
     * com.smartgwt.client.widgets.viewer.DetailViewerField#getTitle field.title} from the related DataSource just like fields
     * from the primary DataSource.
     *
     * @return . See {@link com.smartgwt.client.docs.String String}
     */
    public String getIncludeFrom()  {
        return getAttributeAsString("includeFrom");
    }


    /**
     * The HTML to display for values of this field if the field type is set to "link".  <P> This property sets linkText that
     * will be the same for all records.  You can set linkText on a per-record basis via {@link
     * com.smartgwt.client.widgets.viewer.DetailViewerRecord#getLinkText linkText}.
     *
     * @param linkText . See {@link com.smartgwt.client.docs.String String}. Default value is null
     * @see com.smartgwt.client.widgets.viewer.DetailViewerField#setType
     * @see com.smartgwt.client.widgets.viewer.DetailViewerRecord#setLinkText
     * @see com.smartgwt.client.widgets.viewer.DetailViewer#setLinkTextProperty
     * @see com.smartgwt.client.widgets.viewer.DetailViewerField#setLinkTextProperty
     */
    public void setLinkText(String linkText) {
        setAttribute("linkText", linkText);
    }

    /**
     * The HTML to display for values of this field if the field type is set to "link".  <P> This property sets linkText that
     * will be the same for all records.  You can set linkText on a per-record basis via {@link
     * com.smartgwt.client.widgets.viewer.DetailViewerRecord#getLinkText linkText}.
     *
     * @return . See {@link com.smartgwt.client.docs.String String}
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
     * @param linkTextProperty . See {@link com.smartgwt.client.docs.String String}. Default value is null
     * @see com.smartgwt.client.widgets.viewer.DetailViewerField#setType
     * @see com.smartgwt.client.widgets.viewer.DetailViewerRecord#setLinkText
     * @see com.smartgwt.client.widgets.viewer.DetailViewerField#setLinkText
     * @see com.smartgwt.client.widgets.viewer.DetailViewer#setLinkTextProperty
     */
    public void setLinkTextProperty(String linkTextProperty) {
        setAttribute("linkTextProperty", linkTextProperty);
    }

    /**
     * Name of the property in a DetailViewerRecord that holds the HTML to display for values of this field if the field type
     * is set to "link".
     *
     * @return . See {@link com.smartgwt.client.docs.String String}
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
     * @param linkURLPrefix . See {@link com.smartgwt.client.docs.String String}. Default value is null
     * @see com.smartgwt.client.widgets.viewer.DetailViewerField#setType
     */
    public void setLinkURLPrefix(String linkURLPrefix) {
        setAttribute("linkURLPrefix", linkURLPrefix);
    }

    /**
     * If this field has type set to <code>"link"</code>, setting this property will apply a standard prefix to the link URL
     * when displaying values of this field.
     *
     * @return . See {@link com.smartgwt.client.docs.String String}
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
     * @param linkURLSuffix . See {@link com.smartgwt.client.docs.String String}. Default value is null
     * @see com.smartgwt.client.widgets.viewer.DetailViewerField#setType
     */
    public void setLinkURLSuffix(String linkURLSuffix) {
        setAttribute("linkURLSuffix", linkURLSuffix);
    }

    /**
     * If this field has type set to <code>"link"</code>, setting this property will apply a standard suffix to the link URL
     * when displaying values of this field.
     *
     * @return . See {@link com.smartgwt.client.docs.String String}
     * @see com.smartgwt.client.widgets.viewer.DetailViewerField#getType
     */
    public String getLinkURLSuffix()  {
        return getAttributeAsString("linkURLSuffix");
    }


    /**
     * Name property used to identify the field, and determines which attribute from records will be displayed in this field.
     * <P> Must be unique within the DetailViewer as well as a valid JavaScript identifier, as specified by ECMA-262 Section
     * 7.6 (the  StringUtil.isValidID() function can be used to test whether a name is a valid JavaScript identifier). <P> The
     * attribute of the records to display in this field may also be set by {@link
     * com.smartgwt.client.widgets.viewer.DetailViewerField#getDisplayField displayField}.
     *
     * @param name . See {@link com.smartgwt.client.docs.String String}. Default value is null
     */
    public void setName(String name) {
        setAttribute("name", name);
    }

    /**
     * Name property used to identify the field, and determines which attribute from records will be displayed in this field.
     * <P> Must be unique within the DetailViewer as well as a valid JavaScript identifier, as specified by ECMA-262 Section
     * 7.6 (the  StringUtil.isValidID() function can be used to test whether a name is a valid JavaScript identifier). <P> The
     * attribute of the records to display in this field may also be set by {@link
     * com.smartgwt.client.widgets.viewer.DetailViewerField#getDisplayField displayField}.
     *
     * @return . See {@link com.smartgwt.client.docs.String String}
     */
    public String getName()  {
        return getAttributeAsString("name");
    }


    /**
     * If specified, when generating print HTML for this detailViewer,  cells in this field will be rendered using this css
     * className rather than {@link com.smartgwt.client.widgets.viewer.DetailViewer#getPrintCellStyle printCellStyle}
     *
     * @param printCellStyle . See {@link com.smartgwt.client.docs.CSSClassName CSSClassName}. Default value is null
     */
    public void setPrintCellStyle(String printCellStyle) {
        setAttribute("printCellStyle", printCellStyle);
    }

    /**
     * If specified, when generating print HTML for this detailViewer,  cells in this field will be rendered using this css
     * className rather than {@link com.smartgwt.client.widgets.viewer.DetailViewer#getPrintCellStyle printCellStyle}
     *
     * @return . See {@link com.smartgwt.client.docs.CSSClassName CSSClassName}
     */
    public String getPrintCellStyle()  {
        return getAttributeAsString("printCellStyle");
    }


    /**
     * For a field of type:"imageFile", indicates whether to stream the image and display it inline or to display the View and
     * Download icons.
     *
     * @param showFileInline showFileInline Default value is null
     */
    public void setShowFileInline(Boolean showFileInline) {
        setAttribute("showFileInline", showFileInline);
    }

    /**
     * For a field of type:"imageFile", indicates whether to stream the image and display it inline or to display the View and
     * Download icons.
     *
     * @return Boolean
     */
    public Boolean getShowFileInline()  {
        return getAttributeAsBoolean("showFileInline");
    }


    /**
     * By default, clicking a link rendered by this item opens it in a new browser window.  You  can alter this behavior by
     * setting this property.  The value of this property will be  passed as the value to the <code>target</code> attribute of
     * the anchor tag used to render  the link.  <code>target</code> is applicable only if the field type is set to "link".
     *
     * @param target . See {@link com.smartgwt.client.docs.String String}. Default value is "_blank"
     * @see com.smartgwt.client.widgets.viewer.DetailViewerField#setType
     */
    public void setTarget(String target) {
        setAttribute("target", target);
    }

    /**
     * By default, clicking a link rendered by this item opens it in a new browser window.  You  can alter this behavior by
     * setting this property.  The value of this property will be  passed as the value to the <code>target</code> attribute of
     * the anchor tag used to render  the link.  <code>target</code> is applicable only if the field type is set to "link".
     *
     * @return . See {@link com.smartgwt.client.docs.String String}
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
     * @param timeFormatter timeFormatter Default value is null
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setTimeFormatter(TimeDisplayFormat timeFormatter) {
        setAttribute("timeFormatter", timeFormatter == null ? null : timeFormatter.getValue());
    }

    /**
     * Time-format to apply to date type values within this field.  If specified, any dates displayed in this field will be
     * formatted as times using the appropriate format. This is most commonly only applied to fields specified as type
     * <code>"time"</code> though if no explicit {@link com.smartgwt.client.widgets.viewer.DetailViewerField#getDateFormatter
     * dateFormatter} is specified it will be respected for other  fields as well. <P> If unspecified, a timeFormatter may be
     * defined  {@link com.smartgwt.client.widgets.viewer.DetailViewer#getTimeFormatter at the component level} and will be
     * respected by fields of type <code>"time"</code>.
     *
     * @return TimeDisplayFormat
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public TimeDisplayFormat getTimeFormatter()  {
        return EnumUtil.getEnum(TimeDisplayFormat.values(), getAttribute("timeFormatter"));
    }


    /**
     * The title of the field as displayed on the left-hand side.  If left unspecified, the title of the field is derived by
     * looking up the value of {@link com.smartgwt.client.widgets.viewer.DetailViewer#getFieldIdProperty fieldIdProperty} on
     * this field.  So, by default, the title of a field is the value of its "name" property.
     *
     * @param title . See {@link com.smartgwt.client.docs.HTMLString HTMLString}. Default value is null
     * @see com.smartgwt.client.widgets.viewer.DetailViewer#setFieldIdProperty
     */
    public void setTitle(String title) {
        setAttribute("title", title);
    }

    /**
     * The title of the field as displayed on the left-hand side.  If left unspecified, the title of the field is derived by
     * looking up the value of {@link com.smartgwt.client.widgets.viewer.DetailViewer#getFieldIdProperty fieldIdProperty} on
     * this field.  So, by default, the title of a field is the value of its "name" property.
     *
     * @return . See {@link com.smartgwt.client.docs.HTMLString HTMLString}
     * @see com.smartgwt.client.widgets.viewer.DetailViewer#getFieldIdProperty
     */
    public String getTitle()  {
        return getAttributeAsString("title");
    }


    /**
     * Specifies the type of this DetailViewerField.  By default (value is <code>null</code>) the field shows a field title on
     * the left and the field value on the right.  There are four special values for this attribute: <ul> <li>"header" - If you
     * specify type "header", the field spans both the field name and field value columns and contains text defined in the
     * {@link com.smartgwt.client.widgets.viewer.DetailViewerField#getValue value} attribute with the style specified by {@link
     * com.smartgwt.client.widgets.viewer.DetailViewer#getHeaderStyle headerStyle}.  You can use this field type as a titled
     * separator. <li>"separator" - If you specify type "separator", the field spans both the field name and the field value
     * columns with no text, and is styled using the style specified via {@link
     * com.smartgwt.client.widgets.viewer.DetailViewer#getSeparatorStyle separatorStyle}.  The height of the separator field
     * can be controlled via {@link com.smartgwt.client.widgets.viewer.DetailViewerField#getHeight height}. <li>"image" For
     * viewing, a thumbnail image is rendered in the field.  The URL of the image is the value of the field, and should be
     * absolute. The size of the image is controlled by {@link
     * com.smartgwt.client.widgets.viewer.DetailViewerField#getImageSize imageSize}, {@link
     * com.smartgwt.client.widgets.viewer.DetailViewerField#getImageWidth imageWidth}, {@link
     * com.smartgwt.client.widgets.viewer.DetailViewerField#getImageHeight imageHeight} <li><p>"link" For viewing, a clickable
     * html link (using an HTML anchor tag: &lt;A&gt;) is rendered in the field.  The target URL is the value of the field,
     * which is also the default display value.  You can override the display value by setting {@link
     * com.smartgwt.client.widgets.viewer.DetailViewerRecord#getLinkText linkText} or {@link
     * com.smartgwt.client.widgets.viewer.DetailViewerField#getLinkText linkText}.</p> <p> Clicking the link opens the URL in a
     * new window by default.  To change this behavior, you can set <code>field.target</code>, which works identically to the
     * "target" attribute on an HTML anchor (&lt;A&gt;) tag.  See {@link
     * com.smartgwt.client.widgets.viewer.DetailViewerField#getTarget target} for more information.</p></li> </ul>
     *
     * @param type . See {@link com.smartgwt.client.docs.String String}. Default value is null
     */
    public void setType(String type) {
        setAttribute("type", type);
    }

    /**
     * Specifies the type of this DetailViewerField.  By default (value is <code>null</code>) the field shows a field title on
     * the left and the field value on the right.  There are four special values for this attribute: <ul> <li>"header" - If you
     * specify type "header", the field spans both the field name and field value columns and contains text defined in the
     * {@link com.smartgwt.client.widgets.viewer.DetailViewerField#getValue value} attribute with the style specified by {@link
     * com.smartgwt.client.widgets.viewer.DetailViewer#getHeaderStyle headerStyle}.  You can use this field type as a titled
     * separator. <li>"separator" - If you specify type "separator", the field spans both the field name and the field value
     * columns with no text, and is styled using the style specified via {@link
     * com.smartgwt.client.widgets.viewer.DetailViewer#getSeparatorStyle separatorStyle}.  The height of the separator field
     * can be controlled via {@link com.smartgwt.client.widgets.viewer.DetailViewerField#getHeight height}. <li>"image" For
     * viewing, a thumbnail image is rendered in the field.  The URL of the image is the value of the field, and should be
     * absolute. The size of the image is controlled by {@link
     * com.smartgwt.client.widgets.viewer.DetailViewerField#getImageSize imageSize}, {@link
     * com.smartgwt.client.widgets.viewer.DetailViewerField#getImageWidth imageWidth}, {@link
     * com.smartgwt.client.widgets.viewer.DetailViewerField#getImageHeight imageHeight} <li><p>"link" For viewing, a clickable
     * html link (using an HTML anchor tag: &lt;A&gt;) is rendered in the field.  The target URL is the value of the field,
     * which is also the default display value.  You can override the display value by setting {@link
     * com.smartgwt.client.widgets.viewer.DetailViewerRecord#getLinkText linkText} or {@link
     * com.smartgwt.client.widgets.viewer.DetailViewerField#getLinkText linkText}.</p> <p> Clicking the link opens the URL in a
     * new window by default.  To change this behavior, you can set <code>field.target</code>, which works identically to the
     * "target" attribute on an HTML anchor (&lt;A&gt;) tag.  See {@link
     * com.smartgwt.client.widgets.viewer.DetailViewerField#getTarget target} for more information.</p></li> </ul>
     *
     * @return . See {@link com.smartgwt.client.docs.String String}
     */
    public String getType()  {
        return getAttributeAsString("type");
    }


    /**
     * When a field specifies its {@link com.smartgwt.client.widgets.viewer.DetailViewerField#getType type} to be "header", the
     * value of this attribute specifies the header text.
     *
     * @param value . See {@link com.smartgwt.client.docs.HTMLString HTMLString}. Default value is "undefined"
     */
    public void setValue(String value) {
        setAttribute("value", value);
    }

    /**
     * When a field specifies its {@link com.smartgwt.client.widgets.viewer.DetailViewerField#getType type} to be "header", the
     * value of this attribute specifies the header text.
     *
     * @return . See {@link com.smartgwt.client.docs.HTMLString HTMLString}
     */
    public String getValue()  {
        return getAttributeAsString("value");
    }


    // ********************* Methods ***********************

    // ********************* Static Methods ***********************

    // ***********************************************************




    /**
     * A property list (or an expression that evaluates to a property list) specifying a mapping of internal values to
     * display values for the field (row).
     *
     * @param valueMap valueMap Default value is null
     */
    public void setValueMap(Map valueMap) {
        setAttribute("valueMap", valueMap);
    }


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


