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

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;
import com.smartgwt.client.util.*;
import com.google.gwt.event.shared.*;
import com.google.gwt.event.shared.HasHandlers;

/**
 * An object literal with a particular set of properties used to configure the display of and interaction with the rows of
 * a {@link com.smartgwt.client.widgets.viewer.DetailViewer}.
 */
public class DetailViewerField extends DataClass {

    public static DetailViewerField getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        return new DetailViewerField(jsObj);
    }

    public DetailViewerField(){
        
    }

    public DetailViewerField(JavaScriptObject jsObj){
        super(jsObj);
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
     *
     * @return Boolean
     */
    public Boolean getCanExport()  {
        return getAttributeAsBoolean("canExport");
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
     *
     * @return Integer
     */
    public Integer getHeight()  {
        return getAttributeAsInt("height");
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
     * @param imageURLPrefix imageURLPrefix Default value is null
     * @see com.smartgwt.client.docs.ImageColumns ImageColumns overview and related methods
     */
    public void setImageURLPrefix(String imageURLPrefix) {
        setAttribute("imageURLPrefix", imageURLPrefix);
    }

    /**
     * If this field has type set to <code>"image"</code> and the URL for the image displayed is not absolute, the path of the
     * URL will be relative to this string<br>
     *
     *
     * @return String
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
     *
     * @return Boolean
     */
    public Boolean getShowFileInline()  {
        return getAttributeAsBoolean("showFileInline");
    }

    /**
     * The title of the field as displayed on the left-hand side.  If left unspecified, the title of the field is derived by
     * looking up the value of {@link com.smartgwt.client.widgets.viewer.DetailViewer#getFieldIdProperty fieldIdProperty} on
     * this field.  So, by default, the title of a field is the value of its "name" property.
     *
     * @param title title Default value is null
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
     *
     * @return String
     * @see com.smartgwt.client.widgets.viewer.DetailViewer#getFieldIdProperty
     */
    public String getTitle()  {
        return getAttributeAsString("title");
    }

    /**
     * Specifies the type of this DetailViewerField.  By default (value is <code>null</code>) the field shows a field title on
     * the left and the field value on the right.  There are two special values for this attribute: <ul> <li>"header" - If you
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
     * com.smartgwt.client.widgets.viewer.DetailViewerField#getImageHeight imageHeight} </ul>
     *
     * @param type type Default value is null
     */
    public void setType(String type) {
        setAttribute("type", type);
    }

    /**
     * Specifies the type of this DetailViewerField.  By default (value is <code>null</code>) the field shows a field title on
     * the left and the field value on the right.  There are two special values for this attribute: <ul> <li>"header" - If you
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
     * com.smartgwt.client.widgets.viewer.DetailViewerField#getImageHeight imageHeight} </ul>
     *
     *
     * @return String
     */
    public String getType()  {
        return getAttributeAsString("type");
    }

    /**
     * When a field specifies its {@link com.smartgwt.client.widgets.viewer.DetailViewerField#getType type} to be "header", the
     * value of this attribute specifies the header text.
     *
     * @param value value Default value is "undefined"
     */
    public void setValue(String value) {
        setAttribute("value", value);
    }

    /**
     * When a field specifies its {@link com.smartgwt.client.widgets.viewer.DetailViewerField#getType type} to be "header", the
     * value of this attribute specifies the header text.
     *
     *
     * @return String
     */
    public String getValue()  {
        return getAttributeAsString("value");
    }

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************
        
    // ***********************************************************        


    /**
     * Set the cellStyle.
     *
     * @param cellStyle the cellStyle
     */
    public void setCellStyle(String cellStyle) {
        setAttribute("cellStyle", cellStyle);
    }

    /**
     * Return the cellStyle.
     *
     * @return the cellStyle
     */
    public String getCellStyle() {
        return getAttribute("cellStyle");
    }


    public void setName(String name) {
        setAttribute("name", name);
    }

    public String getName() {
        return getAttributeAsString("name");
    }

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
            var recordsJ = @com.smartgwt.client.widgets.viewer.DetailViewerField::convertToDetailViewerRecordArray(Lcom/google/gwt/core/client/JavaScriptObject;)(records);
            return showIf.@com.smartgwt.client.widgets.viewer.DetailViewerFieldIfFunction::execute(Lcom/smartgwt/client/widgets/viewer/DetailViewer;[Lcom/smartgwt/client/widgets/viewer/DetailViewerRecord;)(viewerJ, recordsJ);
        }));
    }-*/;

    private static DetailViewerRecord[] convertToDetailViewerRecordArray(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new DetailViewerRecord[]{};
        }
        JavaScriptObject[] componentsj = JSOHelper.toArray(nativeArray);
        DetailViewerRecord[] objects = new DetailViewerRecord[componentsj.length];
        for (int i = 0; i < componentsj.length; i++) {
            JavaScriptObject componentJS = componentsj[i];
            DetailViewerRecord obj = (DetailViewerRecord) RefDataClass.getRef(componentJS);
            if (obj == null) obj = new DetailViewerRecord(componentJS);
            objects[i] = obj;
        }
        return objects;
    }

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



