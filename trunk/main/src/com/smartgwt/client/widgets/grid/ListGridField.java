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
 
package com.smartgwt.client.widgets.grid;



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
import com.smartgwt.client.widgets.layout.*;
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
import com.smartgwt.client.util.JSOHelper;
import com.smartgwt.client.util.EnumUtil;
import com.google.gwt.event.shared.*;
import com.google.gwt.event.shared.HasHandlers;
   /**
    * An ordinary JavaScript object containing properties that configures the display of&#010 and interaction with the columns of a {@link com.smartgwt.client.widgets.grid.ListGrid}.

    */





public class ListGridField extends DataClass  implements com.smartgwt.client.widgets.grid.events.HasCellSavedHandlers, com.smartgwt.client.widgets.grid.events.HasChangeHandlers, com.smartgwt.client.widgets.grid.events.HasChangedHandlers, com.smartgwt.client.widgets.grid.events.HasEditorEnterHandlers, com.smartgwt.client.widgets.grid.events.HasEditorExitHandlers, com.smartgwt.client.widgets.grid.events.HasRecordClickHandlers {

    public static ListGridField getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        return new ListGridField(jsObj);
    }


    public ListGridField(){
        
    }

    public ListGridField(JavaScriptObject jsObj){
        super(jsObj);
    }

    public ListGridField(String name) {
        setName(name);
        
    }

    public ListGridField(String name, int width) {
        setName(name);
		setWidth(width);
        
    }

    public ListGridField(String name, String title) {
        setName(name);
		setTitle(title);
        
    }

    public ListGridField(String name, String title, int width) {
        setName(name);
		setTitle(title);
		setWidth(width);
        
    }

    // ********************* Properties / Attributes ***********************

    /**
    * For a field that allows multiple {@link com.smartgwt.client.widgets.grid.ListGridField#getGroupingModes 'grouping modes'}, &#010 the current grouping mode.&#010 <P>&#010 This property is set when a user chooses a particular grouping mode, and may be set on&#010 ListGrid creation to affect the initial grouping.
    *
    * @param groupingMode groupingMode Default value is null
    */
    public void setGroupingMode(String groupingMode) {
        setAttribute("groupingMode", groupingMode);
    }
    /**
     * For a field that allows multiple {@link com.smartgwt.client.widgets.grid.ListGridField#getGroupingModes 'grouping modes'}, &#010 the current grouping mode.&#010 <P>&#010 This property is set when a user chooses a particular grouping mode, and may be set on&#010 ListGrid creation to affect the initial grouping.
     *
     *
     * @return String
     *
     */
    public String getGroupingMode()  {
        return getAttributeAsString("groupingMode");
    }

    /**
    * Default groupingMode used when the user does not specify a mode or grouping is triggered&#010 programmatically and {@link com.smartgwt.client.widgets.grid.ListGridField#getGroupingMode 'field.groupingMode'} is unset.&#010 See {@link com.smartgwt.client.widgets.grid.ListGridField#getGroupingModes 'field.groupingModes'}.
    *
    * @param defaultGroupingMode defaultGroupingMode Default value is null
    */
    public void setDefaultGroupingMode(String defaultGroupingMode) {
        setAttribute("defaultGroupingMode", defaultGroupingMode);
    }
    /**
     * Default groupingMode used when the user does not specify a mode or grouping is triggered&#010 programmatically and {@link com.smartgwt.client.widgets.grid.ListGridField#getGroupingMode 'field.groupingMode'} is unset.&#010 See {@link com.smartgwt.client.widgets.grid.ListGridField#getGroupingModes 'field.groupingModes'}.
     *
     *
     * @return String
     *
     */
    public String getDefaultGroupingMode()  {
        return getAttributeAsString("defaultGroupingMode");
    }

    /**
    * For fields of type:"float" or derived from float, number of digits after the decimal point&#010 to consider when grouping.&#010 <P>&#010 For example, <code>groupPrecision:2</code> indicates that 45.238 and 45.231 group together,&#010 but 45.22 and 45.27 are separate.&#010 <P>&#010 See also {@link com.smartgwt.client.widgets.grid.ListGridField#getGroupGranularity 'groupGranularity'} for grouping by broader&#010 ranges.
    *
    * @param groupPrecision groupPrecision Default value is null
    */
    public void setGroupPrecision(Integer groupPrecision) {
        setAttribute("groupPrecision", groupPrecision);
    }
    /**
     * For fields of type:"float" or derived from float, number of digits after the decimal point&#010 to consider when grouping.&#010 <P>&#010 For example, <code>groupPrecision:2</code> indicates that 45.238 and 45.231 group together,&#010 but 45.22 and 45.27 are separate.&#010 <P>&#010 See also {@link com.smartgwt.client.widgets.grid.ListGridField#getGroupGranularity 'groupGranularity'} for grouping by broader&#010 ranges.
     *
     *
     * @return Integer
     *
     */
    public Integer getGroupPrecision()  {
        return getAttributeAsInt("groupPrecision");
    }

    /**
    * Granularity of grouping for numeric fields.&#010 <P>&#010 Groups will be formed based on ranges of values of size <code>groupGranularity</code>.  For&#010 example, if groupGranularity were 1000, groups would be 0-1000, 1000-2000, etc.
    *
    * @param groupGranularity groupGranularity Default value is null
    */
    public void setGroupGranularity(Integer groupGranularity) {
        setAttribute("groupGranularity", groupGranularity);
    }
    /**
     * Granularity of grouping for numeric fields.&#010 <P>&#010 Groups will be formed based on ranges of values of size <code>groupGranularity</code>.  For&#010 example, if groupGranularity were 1000, groups would be 0-1000, 1000-2000, etc.
     *
     *
     * @return Integer
     *
     */
    public Integer getGroupGranularity()  {
        return getAttributeAsInt("groupGranularity");
    }

    /**
    * Determines whether this field will be groupable in the header context menu.
    *
    * @param canGroupBy canGroupBy Default value is true
    */
    public void setCanGroupBy(Boolean canGroupBy) {
        setAttribute("canGroupBy", canGroupBy);
    }
    /**
     * Determines whether this field will be groupable in the header context menu.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getCanGroupBy()  {
        return getAttributeAsBoolean("canGroupBy");
    }

    /**
    * When true, this field can only be used for sorting if the data is entirely client-side.
    *
    * @param canSortClientOnly canSortClientOnly Default value is false
    */
    public void setCanSortClientOnly(Boolean canSortClientOnly) {
        setAttribute("canSortClientOnly", canSortClientOnly);
    }
    /**
     * When true, this field can only be used for sorting if the data is entirely client-side.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getCanSortClientOnly()  {
        return getAttributeAsBoolean("canSortClientOnly");
    }

    /**
    * Default width and height of value icons in this field.&#010 Takes precidence over valueIconWidth, valueIconHeight and valueIconSize specified at&#010 the ListGrid level.&#010 Can be overridden via {@link com.smartgwt.client.widgets.grid.ListGridField#getValueIconWidth valueIconWidth} and {ListGridField.valueIconHeight}
    *
    * @param valueIconSize valueIconSize Default value is null
    */
    public void setValueIconSize(Integer valueIconSize) {
        setAttribute("valueIconSize", valueIconSize);
    }
    /**
     * Default width and height of value icons in this field.&#010 Takes precidence over valueIconWidth, valueIconHeight and valueIconSize specified at&#010 the ListGrid level.&#010 Can be overridden via {@link com.smartgwt.client.widgets.grid.ListGridField#getValueIconWidth valueIconWidth} and {ListGridField.valueIconHeight}
     *
     *
     * @return Integer
     *
     */
    public Integer getValueIconSize()  {
        return getAttributeAsInt("valueIconSize");
    }

    /**
    * Width for value icons for this listGrid field.&#010 Overrides {@link com.smartgwt.client.widgets.grid.ListGrid#getValueIconSize valueIconSize}, {@link com.smartgwt.client.widgets.grid.ListGrid#getValueIconWidth valueIconWidth}, and&#010 {@link com.smartgwt.client.widgets.grid.ListGridField#getValueIconSize valueIconSize}.
    *
    * @param valueIconWidth valueIconWidth Default value is null
    */
    public void setValueIconWidth(Integer valueIconWidth) {
        setAttribute("valueIconWidth", valueIconWidth);
    }
    /**
     * Width for value icons for this listGrid field.&#010 Overrides {@link com.smartgwt.client.widgets.grid.ListGrid#getValueIconSize valueIconSize}, {@link com.smartgwt.client.widgets.grid.ListGrid#getValueIconWidth valueIconWidth}, and&#010 {@link com.smartgwt.client.widgets.grid.ListGridField#getValueIconSize valueIconSize}.
     *
     *
     * @return Integer
     *
     */
    public Integer getValueIconWidth()  {
        return getAttributeAsInt("valueIconWidth");
    }

    /**
    * Height for value icons for this listGrid field.&#010 Overrides {@link com.smartgwt.client.widgets.grid.ListGrid#getValueIconSize valueIconSize}, {@link com.smartgwt.client.widgets.grid.ListGrid#getValueIconHeight valueIconHeight}, and&#010 {@link com.smartgwt.client.widgets.grid.ListGridField#getValueIconSize valueIconSize}.
    *
    * @param valueIconHeight valueIconHeight Default value is null
    */
    public void setValueIconHeight(Integer valueIconHeight) {
        setAttribute("valueIconHeight", valueIconHeight);
    }
    /**
     * Height for value icons for this listGrid field.&#010 Overrides {@link com.smartgwt.client.widgets.grid.ListGrid#getValueIconSize valueIconSize}, {@link com.smartgwt.client.widgets.grid.ListGrid#getValueIconHeight valueIconHeight}, and&#010 {@link com.smartgwt.client.widgets.grid.ListGridField#getValueIconSize valueIconSize}.
     *
     *
     * @return Integer
     *
     */
    public Integer getValueIconHeight()  {
        return getAttributeAsInt("valueIconHeight");
    }

    /**
    * How much padding should there be on the left of valueIcons for this field&#010 Overrides {@link com.smartgwt.client.widgets.grid.ListGrid#getValueIconLeftPadding valueIconLeftPadding}
    *
    * @param valueIconLeftPadding valueIconLeftPadding Default value is null
    */
    public void setValueIconLeftPadding(Integer valueIconLeftPadding) {
        setAttribute("valueIconLeftPadding", valueIconLeftPadding);
    }
    /**
     * How much padding should there be on the left of valueIcons for this field&#010 Overrides {@link com.smartgwt.client.widgets.grid.ListGrid#getValueIconLeftPadding valueIconLeftPadding}
     *
     *
     * @return Integer
     *
     */
    public Integer getValueIconLeftPadding()  {
        return getAttributeAsInt("valueIconLeftPadding");
    }

    /**
    * How much padding should there be on the right of valueIcons for this field&#010 Overrides {@link com.smartgwt.client.widgets.grid.ListGrid#getValueIconRightPadding valueIconRightPadding}
    *
    * @param valueIconRightPadding valueIconRightPadding Default value is null
    */
    public void setValueIconRightPadding(Integer valueIconRightPadding) {
        setAttribute("valueIconRightPadding", valueIconRightPadding);
    }
    /**
     * How much padding should there be on the right of valueIcons for this field&#010 Overrides {@link com.smartgwt.client.widgets.grid.ListGrid#getValueIconRightPadding valueIconRightPadding}
     *
     *
     * @return Integer
     *
     */
    public Integer getValueIconRightPadding()  {
        return getAttributeAsInt("valueIconRightPadding");
    }

    /**
    * When some cell in this field is being edited, setting this property will specify the&#010 width for value icons in the cell's editor. If unset, the editor's valueIcon width and&#010 height will be determined in the same way as it would be for a static cell.
    *
    * @param editorValueIconWidth editorValueIconWidth Default value is null
    */
    public void setEditorValueIconWidth(Integer editorValueIconWidth) {
        setAttribute("editorValueIconWidth", editorValueIconWidth);
    }
    /**
     * When some cell in this field is being edited, setting this property will specify the&#010 width for value icons in the cell's editor. If unset, the editor's valueIcon width and&#010 height will be determined in the same way as it would be for a static cell.
     *
     *
     * @return Integer
     *
     */
    public Integer getEditorValueIconWidth()  {
        return getAttributeAsInt("editorValueIconWidth");
    }

    /**
    * When some cell in this field is being edited, setting this property will specify the&#010 height for value icons in the cell's editor. If unset, the editor's valueIcon width and&#010 height will be determined in the same way as it would be for a static cell.
    *
    * @param editorValueIconHeight editorValueIconHeight Default value is null
    */
    public void setEditorValueIconHeight(Integer editorValueIconHeight) {
        setAttribute("editorValueIconHeight", editorValueIconHeight);
    }
    /**
     * When some cell in this field is being edited, setting this property will specify the&#010 height for value icons in the cell's editor. If unset, the editor's valueIcon width and&#010 height will be determined in the same way as it would be for a static cell.
     *
     *
     * @return Integer
     *
     */
    public Integer getEditorValueIconHeight()  {
        return getAttributeAsInt("editorValueIconHeight");
    }

    /**
    * If this field has a valueIcons property specified, setting this property causes &#010 the valueIcon for each value to be displayed in the cell without also showing the&#010 record's value for the field.&#010 <P>&#010 If unset the default behavior is to show the icon only if an explicit valueMap is&#010 specified as well in addition to a valueIcons map, otherwise show both the valueIcon and&#010 value for the cell.&#010 <P>&#010 Note that if this field is editable {@link com.smartgwt.client.widgets.form.fields.FormItem#getShowValueIconOnly showValueIconOnly} will be passed&#010 through to editors displayed in this field.
    *
    * @param showValueIconOnly showValueIconOnly Default value is null
    */
    public void setShowValueIconOnly(Boolean showValueIconOnly) {
        setAttribute("showValueIconOnly", showValueIconOnly);
    }
    /**
     * If this field has a valueIcons property specified, setting this property causes &#010 the valueIcon for each value to be displayed in the cell without also showing the&#010 record's value for the field.&#010 <P>&#010 If unset the default behavior is to show the icon only if an explicit valueMap is&#010 specified as well in addition to a valueIcons map, otherwise show both the valueIcon and&#010 value for the cell.&#010 <P>&#010 Note that if this field is editable {@link com.smartgwt.client.widgets.form.fields.FormItem#getShowValueIconOnly showValueIconOnly} will be passed&#010 through to editors displayed in this field.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getShowValueIconOnly()  {
        return getAttributeAsBoolean("showValueIconOnly");
    }

    /**
    * If this field has a valueIcons property specified, setting this property to true will &#010 prevent the valueIcon being written out into this field's cells.
    *
    * @param suppressValueIcon suppressValueIcon Default value is null
    */
    public void setSuppressValueIcon(Boolean suppressValueIcon) {
        setAttribute("suppressValueIcon", suppressValueIcon);
    }
    /**
     * If this field has a valueIcons property specified, setting this property to true will &#010 prevent the valueIcon being written out into this field's cells.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getSuppressValueIcon()  {
        return getAttributeAsBoolean("suppressValueIcon");
    }

    /**
    * If we're showing a valueIcon for this field should it appear to the left or the right&#010 of the text?  By default the icon will appear to the left of the textual value - &#010 set this to "right" to show the icon on the right of the text.&#010 Has no effect if {@link com.smartgwt.client.widgets.grid.ListGridField#getShowValueIconOnly showValueIconOnly} is true
    *
    * @param valueIconOrientation valueIconOrientation Default value is null
    */
    public void setValueIconOrientation(String valueIconOrientation) {
        setAttribute("valueIconOrientation", valueIconOrientation);
    }
    /**
     * If we're showing a valueIcon for this field should it appear to the left or the right&#010 of the text?  By default the icon will appear to the left of the textual value - &#010 set this to "right" to show the icon on the right of the text.&#010 Has no effect if {@link com.smartgwt.client.widgets.grid.ListGridField#getShowValueIconOnly showValueIconOnly} is true
     *
     *
     * @return String
     *
     */
    public String getValueIconOrientation()  {
        return getAttributeAsString("valueIconOrientation");
    }

    /**
    * If this field has type [{@link com.smartgwt.client.types.ListGridFieldType}] set to <code>"image"</code>&#010 and the URL for the image displayed is not absolute, the path of the URL will be relative &#010 to this string<br>&#010 Alternatively, if this field displays any valueIcons, this prefix will be applied to&#010 the beginning of any {@link com.smartgwt.client.widgets.grid.ListGridField#getValueIcons valueIcons} when determining the&#010 URL for the image.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param imageURLPrefix imageURLPrefix Default value is null
    */
    public void setImageURLPrefix(String imageURLPrefix) {
        setAttribute("imageURLPrefix", imageURLPrefix);
    }
    /**
     * If this field has type [{@link com.smartgwt.client.types.ListGridFieldType}] set to <code>"image"</code>&#010 and the URL for the image displayed is not absolute, the path of the URL will be relative &#010 to this string<br>&#010 Alternatively, if this field displays any valueIcons, this prefix will be applied to&#010 the beginning of any {@link com.smartgwt.client.widgets.grid.ListGridField#getValueIcons valueIcons} when determining the&#010 URL for the image.
     *
     *
     * @return String
     *
     */
    public String getImageURLPrefix()  {
        return getAttributeAsString("imageURLPrefix");
    }

    /**
    * If any cells in this field are showing a value icon (see: {@link com.smartgwt.client.widgets.grid.ListGridField#getValueIcons valueIcons})&#010 or this is has {@link com.smartgwt.client.types.ListGridFieldType} set to <code>"image"</code>, this the value&#010 of this property will be appended to the end of the URL for the icon displayed.<br>&#010 Typical usage might be to append a file type such as <code>".gif"</code> to the&#010 filename of the image.<br>&#010 For editable fields, this property will also be passed through to any editors as&#010 {@link com.smartgwt.client.widgets.form.fields.FormItem#getImageURLSuffix imageURLSuffix}.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param imageURLSuffix imageURLSuffix Default value is null
    */
    public void setImageURLSuffix(String imageURLSuffix) {
        setAttribute("imageURLSuffix", imageURLSuffix);
    }
    /**
     * If any cells in this field are showing a value icon (see: {@link com.smartgwt.client.widgets.grid.ListGridField#getValueIcons valueIcons})&#010 or this is has {@link com.smartgwt.client.types.ListGridFieldType} set to <code>"image"</code>, this the value&#010 of this property will be appended to the end of the URL for the icon displayed.<br>&#010 Typical usage might be to append a file type such as <code>".gif"</code> to the&#010 filename of the image.<br>&#010 For editable fields, this property will also be passed through to any editors as&#010 {@link com.smartgwt.client.widgets.form.fields.FormItem#getImageURLSuffix imageURLSuffix}.
     *
     *
     * @return String
     *
     */
    public String getImageURLSuffix()  {
        return getAttributeAsString("imageURLSuffix");
    }

    /**
    * When some cell in this field is being edited, this property can be used to apply &#010 an explicit {@link com.smartgwt.client.widgets.form.fields.FormItem#getImageURLPrefix imageURLPrefix} to the editor in question. &#010 This can be used to modify the valueIcons within the editor.<br>&#010 If unset, but {@link com.smartgwt.client.widgets.grid.ListGridField#getImageURLPrefix imageURLPrefix} is specified, that will be used&#010 instead.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param editorImageURLPrefix editorImageURLPrefix Default value is null
    */
    public void setEditorImageURLPrefix(String editorImageURLPrefix) {
        setAttribute("editorImageURLPrefix", editorImageURLPrefix);
    }
    /**
     * When some cell in this field is being edited, this property can be used to apply &#010 an explicit {@link com.smartgwt.client.widgets.form.fields.FormItem#getImageURLPrefix imageURLPrefix} to the editor in question. &#010 This can be used to modify the valueIcons within the editor.<br>&#010 If unset, but {@link com.smartgwt.client.widgets.grid.ListGridField#getImageURLPrefix imageURLPrefix} is specified, that will be used&#010 instead.
     *
     *
     * @return String
     *
     */
    public String getEditorImageURLPrefix()  {
        return getAttributeAsString("editorImageURLPrefix");
    }

    /**
    * When some cell in this field is being edited, this property can be used to apply &#010 an explicit {@link com.smartgwt.client.widgets.form.fields.FormItem#getImageURLSuffix imageURLSuffix} to the editor in question. &#010 This can be used to modify the valueIcons within the editor.<br>&#010 If unset, but {@link com.smartgwt.client.widgets.grid.ListGridField#getImageURLPrefix imageURLPrefix} is specified, that will be used&#010 instead.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param editorImageURLSuffix editorImageURLSuffix Default value is null
    */
    public void setEditorImageURLSuffix(String editorImageURLSuffix) {
        setAttribute("editorImageURLSuffix", editorImageURLSuffix);
    }
    /**
     * When some cell in this field is being edited, this property can be used to apply &#010 an explicit {@link com.smartgwt.client.widgets.form.fields.FormItem#getImageURLSuffix imageURLSuffix} to the editor in question. &#010 This can be used to modify the valueIcons within the editor.<br>&#010 If unset, but {@link com.smartgwt.client.widgets.grid.ListGridField#getImageURLPrefix imageURLPrefix} is specified, that will be used&#010 instead.
     *
     *
     * @return String
     *
     */
    public String getEditorImageURLSuffix()  {
        return getAttributeAsString("editorImageURLSuffix");
    }

    /**
    * Size of images shown for fieldTypes image and imageFile in this field.&#010 This setting overrides the global ListGrid default {@link com.smartgwt.client.widgets.grid.ListGrid#getImageSize imageSize}.&#010 <P>&#010 If set to a String, assumed to be a property on each record that specifies the image&#010 height.  For example, if <code>field.imageSize</code> is "logoSize",&#010 <code>record.logoSize</code> will control the size of the image.
    *
    * @param imageSize imageSize Default value is 16
    */
    public void setImageSize(int imageSize) {
        setAttribute("imageSize", imageSize);
    }
    /**
     * Size of images shown for fieldTypes image and imageFile in this field.&#010 This setting overrides the global ListGrid default {@link com.smartgwt.client.widgets.grid.ListGrid#getImageSize imageSize}.&#010 <P>&#010 If set to a String, assumed to be a property on each record that specifies the image&#010 height.  For example, if <code>field.imageSize</code> is "logoSize",&#010 <code>record.logoSize</code> will control the size of the image.
     *
     *
     * @return int
     *
     */
    public int getImageSize()  {
        return getAttributeAsInt("imageSize");
    }

    /**
    * Width of images shown for fieldTypes image and imageFile in this field.&#010 <P>&#010 If set to a String, assumed to be a property on each record that specifies the image&#010 width.  For example, if <code>field.imageWidth</code> is "logoWidth",&#010 <code>record.logoWidth</code> will control the width of the image.
    *
    * @param imageWidth imageWidth Default value is 16
    */
    public void setImageWidth(int imageWidth) {
        setAttribute("imageWidth", imageWidth);
    }
    /**
     * Width of images shown for fieldTypes image and imageFile in this field.&#010 <P>&#010 If set to a String, assumed to be a property on each record that specifies the image&#010 width.  For example, if <code>field.imageWidth</code> is "logoWidth",&#010 <code>record.logoWidth</code> will control the width of the image.
     *
     *
     * @return int
     *
     */
    public int getImageWidth()  {
        return getAttributeAsInt("imageWidth");
    }

    /**
    * Height of image shown for fieldTypes image and imageFile in this field.&#010 <P>&#010 If set to a String, assumed to be a property on each record that specifies the image&#010 height.  For example, if <code>field.imageHeight</code> is "logoHeight",&#010 <code>record.logoHeight</code> will control the heigt of the image.
    *
    * @param imageHeight imageHeight Default value is 16
    */
    public void setImageHeight(int imageHeight) {
        setAttribute("imageHeight", imageHeight);
    }
    /**
     * Height of image shown for fieldTypes image and imageFile in this field.&#010 <P>&#010 If set to a String, assumed to be a property on each record that specifies the image&#010 height.  For example, if <code>field.imageHeight</code> is "logoHeight",&#010 <code>record.logoHeight</code> will control the heigt of the image.
     *
     *
     * @return int
     *
     */
    public int getImageHeight()  {
        return getAttributeAsInt("imageHeight");
    }
             
    /**
    * ListGrids picks a renderer for the view and edit mode of a field based on this attribute.
    *
    * @param type type Default value is "text"
    */
    public void setType(ListGridFieldType type) {
        setAttribute("type", type.getValue());
    }
    /**
     * ListGrids picks a renderer for the view and edit mode of a field based on this attribute.
     *
     *
     * @return ListGridFieldType
     *
     */
    public ListGridFieldType getType()  {
        return (ListGridFieldType) EnumUtil.getEnum(ListGridFieldType.values(), getAttribute("type"));
    }

    /**
    * Name of this field.  Must be unique within this ListGrid.&#010 <P>&#010 The name of field is also the property in each record which holds the value for that&#010 field.&#010 <P>&#010 If a {@link com.smartgwt.client.widgets.grid.ListGrid#getDataSource dataSource} is specified and the DataSource has a field with the&#010 same name, the ListGridField and DataSourceField are merged so that properties on the&#010 ListGridField
    *
    * @param name name Default value is null
    */
    public void setName(String name) {
        setAttribute("name", name);
    }
    /**
     * Name of this field.  Must be unique within this ListGrid.&#010 <P>&#010 The name of field is also the property in each record which holds the value for that&#010 field.&#010 <P>&#010 If a {@link com.smartgwt.client.widgets.grid.ListGrid#getDataSource dataSource} is specified and the DataSource has a field with the&#010 same name, the ListGridField and DataSourceField are merged so that properties on the&#010 ListGridField
     *
     *
     * @return String
     *
     */
    public String getName()  {
        return getAttributeAsString("name");
    }

    /**
    * A title for this field, to display in the header of the listGrid object.  Alternately you can&#010 specify a {@link com.smartgwt.client.widgets.grid.ListGridField#getFieldTitle} method on the field to return the HTML for the field title.
    *
    * @param title title Default value is null
    */
    public void setTitle(String title) {
        setAttribute("title", title);
    }
    /**
     * A title for this field, to display in the header of the listGrid object.  Alternately you can&#010 specify a {@link com.smartgwt.client.widgets.grid.ListGridField#getFieldTitle} method on the field to return the HTML for the field title.
     *
     *
     * @return String
     *
     */
    public String getTitle()  {
        return getAttributeAsString("title");
    }

    /**
    * By default, clicking a link rendered by this item opens it in a new browser window.  You &#010 can alter this behavior by setting this property.  The value of this property will be &#010 passed as the value to the <code>target</code> attribute of the anchor tag used to render &#010 the link.&#010 <P>&#010 If you set listGridField.target to "javascript", the default behaviour is to catch and &#010 consume mouse-clicks that would result in the link being followed.  Instead, the&#010 {@link com.smartgwt.client.widgets.grid.ListGrid#addCellClickHandler} event is fired for the containing cell.
    *
    * @param target target Default value is "_blank"
    */
    public void setTarget(String target) {
        setAttribute("target", target);
    }
    /**
     * By default, clicking a link rendered by this item opens it in a new browser window.  You &#010 can alter this behavior by setting this property.  The value of this property will be &#010 passed as the value to the <code>target</code> attribute of the anchor tag used to render &#010 the link.&#010 <P>&#010 If you set listGridField.target to "javascript", the default behaviour is to catch and &#010 consume mouse-clicks that would result in the link being followed.  Instead, the&#010 {@link com.smartgwt.client.widgets.grid.ListGrid#addCellClickHandler} event is fired for the containing cell.
     *
     *
     * @return String
     *
     */
    public String getTarget()  {
        return getAttributeAsString("target");
    }

    /**
    * Whether this field should be "frozen" for the purposes of horizontal scrolling.  See&#010 {@link com.smartgwt.client.docs.FrozenFields}.
    *
    * @param frozen frozen Default value is null
    */
    public void setFrozen(Boolean frozen) {
        setAttribute("frozen", frozen);
    }
    /**
     * Whether this field should be "frozen" for the purposes of horizontal scrolling.  See&#010 {@link com.smartgwt.client.docs.FrozenFields}.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getFrozen()  {
        return getAttributeAsBoolean("frozen");
    }

    /**
    * Whether this field should display freezing/unfreezing options in its header context menu. &#010 See {@link com.smartgwt.client.docs.FrozenFields}.
    *
    * @param canFreeze canFreeze Default value is null
    */
    public void setCanFreeze(Boolean canFreeze) {
        setAttribute("canFreeze", canFreeze);
    }
    /**
     * Whether this field should display freezing/unfreezing options in its header context menu. &#010 See {@link com.smartgwt.client.docs.FrozenFields}.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getCanFreeze()  {
        return getAttributeAsBoolean("canFreeze");
    }

    /**
    * Whether this field can be hidden via the header context menu.
    *
    * @param canHide canHide Default value is null
    */
    public void setCanHide(Boolean canHide) {
        setAttribute("canHide", canHide);
    }
    /**
     * Whether this field can be hidden via the header context menu.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getCanHide()  {
        return getAttributeAsBoolean("canHide");
    }

    /**
    * Optional icon to show next to the title for this field. &#010 Should be set to a URL to an image. Relative paths will be evaluated starting at&#010 the imgDir of this component. This URL is partial - it may be updated to indicate&#010 the current disabled (etc) state of the field.&#010 <P>&#010 If {@link com.smartgwt.client.widgets.grid.ListGridField#getType 'field.type'} is set to "icon", this icon will also be shown&#010 in every cell of this field - see also {@link com.smartgwt.client.widgets.grid.ListGridField#getCellIcon 'field.cellIcon'}.
    *
    * @param icon icon Default value is null
    */
    public void setIcon(String icon) {
        setAttribute("icon", icon);
    }
    /**
     * Optional icon to show next to the title for this field. &#010 Should be set to a URL to an image. Relative paths will be evaluated starting at&#010 the imgDir of this component. This URL is partial - it may be updated to indicate&#010 the current disabled (etc) state of the field.&#010 <P>&#010 If {@link com.smartgwt.client.widgets.grid.ListGridField#getType 'field.type'} is set to "icon", this icon will also be shown&#010 in every cell of this field - see also {@link com.smartgwt.client.widgets.grid.ListGridField#getCellIcon 'field.cellIcon'}.
     *
     *
     * @return String
     *
     */
    public String getIcon()  {
        return getAttributeAsString("icon");
    }

    /**
    * If {@link com.smartgwt.client.widgets.grid.ListGridField#getIcon icon} is specified, this property can be used to specify the &#010 size of the icon to be displayed in the ListGrid header button. &#010 (See {@link com.smartgwt.client.widgets.StatefulCanvas#getIconSize iconSize})
    *
    * @param iconSize iconSize Default value is null
    */
    public void setIconSize(Integer iconSize) {
        setAttribute("iconSize", iconSize);
    }
    /**
     * If {@link com.smartgwt.client.widgets.grid.ListGridField#getIcon icon} is specified, this property can be used to specify the &#010 size of the icon to be displayed in the ListGrid header button. &#010 (See {@link com.smartgwt.client.widgets.StatefulCanvas#getIconSize iconSize})
     *
     *
     * @return Integer
     *
     */
    public Integer getIconSize()  {
        return getAttributeAsInt("iconSize");
    }

    /**
    * If {@link com.smartgwt.client.widgets.grid.ListGridField#getIcon icon} is specified, this property can be used to specify the &#010 width of the icon to be displayed in the ListGrid header button. &#010 (See {@link com.smartgwt.client.widgets.StatefulCanvas#getIconWidth iconWidth})<br>&#010 If this field is editable, and {@link com.smartgwt.client.widgets.grid.ListGridField#getEditorIconWidth editorIconWidth} is unset, this &#010 property will be passed onto the editors for this field as {@link com.smartgwt.client.widgets.form.fields.FormItem#getIconWidth iconWidth}, &#010 which will effect the default size for {@link com.smartgwt.client.widgets.grid.ListGridField#getIcons 'icons'} displayed &#010 in the editor.
    *
    * @param iconWidth iconWidth Default value is null
    */
    public void setIconWidth(Integer iconWidth) {
        setAttribute("iconWidth", iconWidth);
    }
    /**
     * If {@link com.smartgwt.client.widgets.grid.ListGridField#getIcon icon} is specified, this property can be used to specify the &#010 width of the icon to be displayed in the ListGrid header button. &#010 (See {@link com.smartgwt.client.widgets.StatefulCanvas#getIconWidth iconWidth})<br>&#010 If this field is editable, and {@link com.smartgwt.client.widgets.grid.ListGridField#getEditorIconWidth editorIconWidth} is unset, this &#010 property will be passed onto the editors for this field as {@link com.smartgwt.client.widgets.form.fields.FormItem#getIconWidth iconWidth}, &#010 which will effect the default size for {@link com.smartgwt.client.widgets.grid.ListGridField#getIcons 'icons'} displayed &#010 in the editor.
     *
     *
     * @return Integer
     *
     */
    public Integer getIconWidth()  {
        return getAttributeAsInt("iconWidth");
    }

    /**
    * If {@link com.smartgwt.client.widgets.grid.ListGridField#getIcon icon} is specified, this property can be used to specify the &#010 height of the icon to be displayed in the ListGrid header button. &#010 (See {@link com.smartgwt.client.widgets.StatefulCanvas#getIconHeight iconHeight})<br>&#010 If this field is editable, and {@link com.smartgwt.client.widgets.grid.ListGridField#getEditorIconHeight editorIconHeight} is unset, this &#010 property will be passed onto the editors for this field as {@link com.smartgwt.client.widgets.form.fields.FormItem#getIconWidth iconWidth}, &#010 which will effect the default size for {@link com.smartgwt.client.widgets.grid.ListGridField#getIcons 'icons'} displayed &#010 in the editor.
    *
    * @param iconHeight iconHeight Default value is null
    */
    public void setIconHeight(Integer iconHeight) {
        setAttribute("iconHeight", iconHeight);
    }
    /**
     * If {@link com.smartgwt.client.widgets.grid.ListGridField#getIcon icon} is specified, this property can be used to specify the &#010 height of the icon to be displayed in the ListGrid header button. &#010 (See {@link com.smartgwt.client.widgets.StatefulCanvas#getIconHeight iconHeight})<br>&#010 If this field is editable, and {@link com.smartgwt.client.widgets.grid.ListGridField#getEditorIconHeight editorIconHeight} is unset, this &#010 property will be passed onto the editors for this field as {@link com.smartgwt.client.widgets.form.fields.FormItem#getIconWidth iconWidth}, &#010 which will effect the default size for {@link com.smartgwt.client.widgets.grid.ListGridField#getIcons 'icons'} displayed &#010 in the editor.
     *
     *
     * @return Integer
     *
     */
    public Integer getIconHeight()  {
        return getAttributeAsInt("iconHeight");
    }

    /**
    * If this field is showing an icon, should it appear to the left or right of the title?<br>&#010 Valid options are <code>"left"</code> or <code>"right"</code>
    *
    * @param iconOrientation iconOrientation Default value is "left"
    */
    public void setIconOrientation(String iconOrientation) {
        setAttribute("iconOrientation", iconOrientation);
    }
    /**
     * If this field is showing an icon, should it appear to the left or right of the title?<br>&#010 Valid options are <code>"left"</code> or <code>"right"</code>
     *
     *
     * @return String
     *
     */
    public String getIconOrientation()  {
        return getAttributeAsString("iconOrientation");
    }

    /**
    * Pixels between icon and title text.
    *
    * @param iconSpacing iconSpacing Default value is 6
    */
    public void setIconSpacing(int iconSpacing) {
        setAttribute("iconSpacing", iconSpacing);
    }
    /**
     * Pixels between icon and title text.
     *
     *
     * @return int
     *
     */
    public int getIconSpacing()  {
        return getAttributeAsInt("iconSpacing");
    }

    /**
    * If using an icon for this button, whether to switch the icon image if the button becomes&#010 disabled.
    *
    * @param showDisabledIcon showDisabledIcon Default value is true
    */
    public void setShowDisabledIcon(Boolean showDisabledIcon) {
        setAttribute("showDisabledIcon", showDisabledIcon);
    }
    /**
     * If using an icon for this button, whether to switch the icon image if the button becomes&#010 disabled.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getShowDisabledIcon()  {
        return getAttributeAsBoolean("showDisabledIcon");
    }

    /**
    * If using an icon for this button, whether to switch the icon image on mouse rollover.
    *
    * @param showRollOverIcon showRollOverIcon Default value is false
    */
    public void setShowRollOverIcon(Boolean showRollOverIcon) {
        setAttribute("showRollOverIcon", showRollOverIcon);
    }
    /**
     * If using an icon for this button, whether to switch the icon image on mouse rollover.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getShowRollOverIcon()  {
        return getAttributeAsBoolean("showRollOverIcon");
    }

    /**
    * If using an icon for this button, whether to switch the icon image when the button&#010 recieves focus.&#010 <P>&#010 If {@link com.smartgwt.client.widgets.StatefulCanvas#getShowFocusedAsOver showFocusedAsOver} is true, the <code>"Over"</code> icon will be&#010 displayed when the canvas has focus, otherwise a seperate <code>"Focused"</code> icon&#010 will be displayed
    *
    * @param showFocusedIcon showFocusedIcon Default value is false
    */
    public void setShowFocusedIcon(Boolean showFocusedIcon) {
        setAttribute("showFocusedIcon", showFocusedIcon);
    }
    /**
     * If using an icon for this button, whether to switch the icon image when the button&#010 recieves focus.&#010 <P>&#010 If {@link com.smartgwt.client.widgets.StatefulCanvas#getShowFocusedAsOver showFocusedAsOver} is true, the <code>"Over"</code> icon will be&#010 displayed when the canvas has focus, otherwise a seperate <code>"Focused"</code> icon&#010 will be displayed
     *
     *
     * @return Boolean
     *
     */
    public Boolean getShowFocusedIcon()  {
        return getAttributeAsBoolean("showFocusedIcon");
    }

    /**
    * If using an icon for this button, whether to switch the icon image when the mouse goes&#010 down on the button.
    *
    * @param showDownIcon showDownIcon Default value is false
    */
    public void setShowDownIcon(Boolean showDownIcon) {
        setAttribute("showDownIcon", showDownIcon);
    }
    /**
     * If using an icon for this button, whether to switch the icon image when the mouse goes&#010 down on the button.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getShowDownIcon()  {
        return getAttributeAsBoolean("showDownIcon");
    }

    /**
    * If using an icon for this button, whether to switch the icon image when the button&#010 becomes selected.
    *
    * @param showSelectedIcon showSelectedIcon Default value is false
    */
    public void setShowSelectedIcon(Boolean showSelectedIcon) {
        setAttribute("showSelectedIcon", showSelectedIcon);
    }
    /**
     * If using an icon for this button, whether to switch the icon image when the button&#010 becomes selected.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getShowSelectedIcon()  {
        return getAttributeAsBoolean("showSelectedIcon");
    }

    /**
    * For a field of type:"icon" only, set the icon that appears in body cells.  Unless&#010 setting {@link com.smartgwt.client.widgets.grid.ListGridField#getIcon 'field.icon'}, setting field.cellIcon will not show an&#010 icon in the header.
    *
    * @param cellIcon cellIcon Default value is null
    */
    public void setCellIcon(String cellIcon) {
        setAttribute("cellIcon", cellIcon);
    }
    /**
     * For a field of type:"icon" only, set the icon that appears in body cells.  Unless&#010 setting {@link com.smartgwt.client.widgets.grid.ListGridField#getIcon 'field.icon'}, setting field.cellIcon will not show an&#010 icon in the header.
     *
     *
     * @return String
     *
     */
    public String getCellIcon()  {
        return getAttributeAsString("cellIcon");
    }

    /**
    * For a field of type:"imageFile", indicates whether to stream the image and display it&#010 inline or to display the View and Download icons.
    *
    * @param showFileInline showFileInline Default value is null
    */
    public void setShowFileInline(Boolean showFileInline) {
        setAttribute("showFileInline", showFileInline);
    }
    /**
     * For a field of type:"imageFile", indicates whether to stream the image and display it&#010 inline or to display the View and Download icons.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getShowFileInline()  {
        return getAttributeAsBoolean("showFileInline");
    }

    /**
    * If this field is editable, this property will be passed to editors displayed for&#010 cells within this field as {@link com.smartgwt.client.widgets.form.fields.FormItem#getIconWidth iconWidth}.<br>&#010 If this property unset, the iconWidth property from the editor can be picked up from &#010 {@link com.smartgwt.client.widgets.grid.ListGridField#getIconWidth iconWidth} instead.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param editorIconWidth editorIconWidth Default value is null
    */
    public void setEditorIconWidth(Integer editorIconWidth) {
        setAttribute("editorIconWidth", editorIconWidth);
    }
    /**
     * If this field is editable, this property will be passed to editors displayed for&#010 cells within this field as {@link com.smartgwt.client.widgets.form.fields.FormItem#getIconWidth iconWidth}.<br>&#010 If this property unset, the iconWidth property from the editor can be picked up from &#010 {@link com.smartgwt.client.widgets.grid.ListGridField#getIconWidth iconWidth} instead.
     *
     *
     * @return Integer
     *
     */
    public Integer getEditorIconWidth()  {
        return getAttributeAsInt("editorIconWidth");
    }

    /**
    * If this field is editable, this property will be passed to editors displayed for&#010 cells within this field as {@link com.smartgwt.client.widgets.form.fields.FormItem#getIconHeight iconHeight}.<br>&#010 If this property unset, the iconHeight property from the editor can be picked up from &#010 {@link com.smartgwt.client.widgets.grid.ListGridField#getIconHeight iconHeight} instead.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param editorIconHeight editorIconHeight Default value is null
    */
    public void setEditorIconHeight(Integer editorIconHeight) {
        setAttribute("editorIconHeight", editorIconHeight);
    }
    /**
     * If this field is editable, this property will be passed to editors displayed for&#010 cells within this field as {@link com.smartgwt.client.widgets.form.fields.FormItem#getIconHeight iconHeight}.<br>&#010 If this property unset, the iconHeight property from the editor can be picked up from &#010 {@link com.smartgwt.client.widgets.grid.ListGridField#getIconHeight iconHeight} instead.
     *
     *
     * @return Integer
     *
     */
    public Integer getEditorIconHeight()  {
        return getAttributeAsInt("editorIconHeight");
    }

    /**
    * If this field is editable, this property will be passed to editors displayed for&#010 cells within this field as {@link com.smartgwt.client.widgets.form.fields.FormItem#getDefaultIconSrc defaultIconSrc}.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param defaultIconSrc defaultIconSrc Default value is null
    */
    public void setDefaultIconSrc(String defaultIconSrc) {
        setAttribute("defaultIconSrc", defaultIconSrc);
    }
    /**
     * If this field is editable, this property will be passed to editors displayed for&#010 cells within this field as {@link com.smartgwt.client.widgets.form.fields.FormItem#getDefaultIconSrc defaultIconSrc}.
     *
     *
     * @return String
     *
     */
    public String getDefaultIconSrc()  {
        return getAttributeAsString("defaultIconSrc");
    }

    /**
    * If this field is editable, this property will be passed to editors displayed for&#010 cells within this field as {@link com.smartgwt.client.widgets.form.fields.FormItem#getIconVAlign iconVAlign}.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param iconVAlign iconVAlign Default value is null
    */
    public void setIconVAlign(String iconVAlign) {
        setAttribute("iconVAlign", iconVAlign);
    }
    /**
     * If this field is editable, this property will be passed to editors displayed for&#010 cells within this field as {@link com.smartgwt.client.widgets.form.fields.FormItem#getIconVAlign iconVAlign}.
     *
     *
     * @return String
     *
     */
    public String getIconVAlign()  {
        return getAttributeAsString("iconVAlign");
    }

    /**
    * Optional long summary title for this field, provided in addition to &#010 {@link com.smartgwt.client.widgets.grid.ListGridField#getTitle title}. This gives the developer an option to use a very short,&#010 or empty title for the ListGrid column (where space may be a factor), but have a longer &#010 value available to be used elsewhere.<br>&#010 By default this value will be used for the title of the context-menu item&#010 for showing/hiding the listGrid field when the user right-clicks on the ListGrid header.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param summaryTitle summaryTitle Default value is null
    */
    public void setSummaryTitle(String summaryTitle) {
        setAttribute("summaryTitle", summaryTitle);
    }
    /**
     * Optional long summary title for this field, provided in addition to &#010 {@link com.smartgwt.client.widgets.grid.ListGridField#getTitle title}. This gives the developer an option to use a very short,&#010 or empty title for the ListGrid column (where space may be a factor), but have a longer &#010 value available to be used elsewhere.<br>&#010 By default this value will be used for the title of the context-menu item&#010 for showing/hiding the listGrid field when the user right-clicks on the ListGrid header.
     *
     *
     * @return Optional string method to return a long summary title for this field, if a dynamic&#010 summary title is required for this field.  &#010&#010
     *
     */
    public String getSummaryTitle()  {
        return getAttributeAsString("summaryTitle");
    }

    /**
    * Custom base style to apply to this field's header button instead of &#010 {@link com.smartgwt.client.widgets.grid.ListGrid#getHeaderBaseStyle headerBaseStyle}.<br>&#010 Note that depending on the header button constructor, you may have to override&#010 {@link com.smartgwt.client.widgets.grid.ListGridField#getHeaderTitleStyle headerTitleStyle} as well.
    *
    * @param headerBaseStyle headerBaseStyle Default value is null
    */
    public void setHeaderBaseStyle(String headerBaseStyle) {
        setAttribute("headerBaseStyle", headerBaseStyle);
    }
    /**
     * Custom base style to apply to this field's header button instead of &#010 {@link com.smartgwt.client.widgets.grid.ListGrid#getHeaderBaseStyle headerBaseStyle}.<br>&#010 Note that depending on the header button constructor, you may have to override&#010 {@link com.smartgwt.client.widgets.grid.ListGridField#getHeaderTitleStyle headerTitleStyle} as well.
     *
     *
     * @return String
     *
     */
    public String getHeaderBaseStyle()  {
        return getAttributeAsString("headerBaseStyle");
    }

    /**
    * Custom titleStyle to apply to this field's header button instead of &#010 {@link com.smartgwt.client.widgets.grid.ListGrid#getHeaderTitleStyle headerTitleStyle}.<br>&#010 Note that this will typically only have an effect if &#010 {@link com.smartgwt.client.widgets.grid.ListGrid#getHeaderButtonConstructor headerButtonConstructor} is set to {@link com.smartgwt.client.widgets.StretchImgButton} or a subclass &#010 thereof.
    *
    * @param headerTitleStyle headerTitleStyle Default value is null
    */
    public void setHeaderTitleStyle(String headerTitleStyle) {
        setAttribute("headerTitleStyle", headerTitleStyle);
    }
    /**
     * Custom titleStyle to apply to this field's header button instead of &#010 {@link com.smartgwt.client.widgets.grid.ListGrid#getHeaderTitleStyle headerTitleStyle}.<br>&#010 Note that this will typically only have an effect if &#010 {@link com.smartgwt.client.widgets.grid.ListGrid#getHeaderButtonConstructor headerButtonConstructor} is set to {@link com.smartgwt.client.widgets.StretchImgButton} or a subclass &#010 thereof.
     *
     *
     * @return String
     *
     */
    public String getHeaderTitleStyle()  {
        return getAttributeAsString("headerTitleStyle");
    }
             
    /**
    * Horizontal alignment for cells in this field's column: "left", "right"&#010 or "center".<br>&#010 If null, alignment is derived from {@link com.smartgwt.client.widgets.grid.ListGridField#getAlign align}. If this field is editable, &#010 the alignment of cells in the body will also be reflected in any editors for the field.
    *
    * @param cellAlign cellAlign Default value is null
    */
    public void setCellAlign(Alignment cellAlign) {
        setAttribute("cellAlign", cellAlign.getValue());
    }
    /**
     * Horizontal alignment for cells in this field's column: "left", "right"&#010 or "center".<br>&#010 If null, alignment is derived from {@link com.smartgwt.client.widgets.grid.ListGridField#getAlign align}. If this field is editable, &#010 the alignment of cells in the body will also be reflected in any editors for the field.
     *
     *
     * @return Alignment
     *
     */
    public Alignment getCellAlign()  {
        return (Alignment) EnumUtil.getEnum(Alignment.values(), getAttribute("cellAlign"));
    }

    /**
    * Custom base style to apply to all cells in this field instead of {@link com.smartgwt.client.widgets.grid.ListGrid#getBaseStyle baseStyle}&#010  To override the baseStyle at the row level, use &#010  {@link com.smartgwt.client.widgets.grid.ListGrid#getRecordBaseStyleProperty 'record[listGrid.recordBaseStyleProperty]'}&#010  instead.
    *
    * @param baseStyle baseStyle Default value is null
    */
    public void setBaseStyle(String baseStyle) {
        setAttribute("baseStyle", baseStyle);
    }
    /**
     * Custom base style to apply to all cells in this field instead of {@link com.smartgwt.client.widgets.grid.ListGrid#getBaseStyle baseStyle}&#010  To override the baseStyle at the row level, use &#010  {@link com.smartgwt.client.widgets.grid.ListGrid#getRecordBaseStyleProperty 'record[listGrid.recordBaseStyleProperty]'}&#010  instead.
     *
     *
     * @return String
     *
     */
    public String getBaseStyle()  {
        return getAttributeAsString("baseStyle");
    }

    /**
    * Enables or disables sorting by this column. If false, neither interactive&#010  nor scripted (via the sort() method) instructions will sort the listGrid by this&#010  column.
    *
    * @param canSort canSort Default value is true
    */
    public void setCanSort(Boolean canSort) {
        setAttribute("canSort", canSort);
    }
    /**
     * Enables or disables sorting by this column. If false, neither interactive&#010  nor scripted (via the sort() method) instructions will sort the listGrid by this&#010  column.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getCanSort()  {
        return getAttributeAsBoolean("canSort");
    }

    /**
    * Can this field be edited? May be overridden by setting the&#010      'canEdit' property at the listGrid level
    *
    * @param canEdit canEdit Default value is null
    */
    public void setCanEdit(Boolean canEdit) {
        setAttribute("canEdit", canEdit);
    }
    /**
     * Can this field be edited? May be overridden by setting the&#010      'canEdit' property at the listGrid level
     *
     *
     * @return Boolean
     *
     */
    public Boolean getCanEdit()  {
        return getAttributeAsBoolean("canEdit");
    }
             
    /**
    * What to do when a user hits enter while editing this field?<br>&#010 Overrides the <code>enterKeyEditAction</code> as specified at the listGrid level while &#010 focus is in this field.
    *
    * @param enterKeyEditAction enterKeyEditAction Default value is "done"
    */
    public void setEnterKeyEditAction(EnterKeyEditAction enterKeyEditAction) {
        setAttribute("enterKeyEditAction", enterKeyEditAction.getValue());
    }
    /**
     * What to do when a user hits enter while editing this field?<br>&#010 Overrides the <code>enterKeyEditAction</code> as specified at the listGrid level while &#010 focus is in this field.
     *
     *
     * @return EnterKeyEditAction
     *
     */
    public EnterKeyEditAction getEnterKeyEditAction()  {
        return (EnterKeyEditAction) EnumUtil.getEnum(EnterKeyEditAction.values(), getAttribute("enterKeyEditAction"));
    }
             
    /**
    * What to do when a user hits escape while editing this field?<br>&#010 Overrides the <code>escapeKeyEditAction</code> as specified at the listGrid level while &#010 focus is in this field.
    *
    * @param escapeKeyEditAction escapeKeyEditAction Default value is "cancel"
    */
    public void setEscapeKeyEditAction(EscapeKeyEditAction escapeKeyEditAction) {
        setAttribute("escapeKeyEditAction", escapeKeyEditAction.getValue());
    }
    /**
     * What to do when a user hits escape while editing this field?<br>&#010 Overrides the <code>escapeKeyEditAction</code> as specified at the listGrid level while &#010 focus is in this field.
     *
     *
     * @return EscapeKeyEditAction
     *
     */
    public EscapeKeyEditAction getEscapeKeyEditAction()  {
        return (EscapeKeyEditAction) EnumUtil.getEnum(EscapeKeyEditAction.values(), getAttribute("escapeKeyEditAction"));
    }

    /**
    * If set to true, any {@link com.smartgwt.client.widgets.grid.ListGridField#getValidators validators} for this field will be run whenever&#010 the value of the field is changed.&#010 <P>&#010 Analgous to the {@link com.smartgwt.client.widgets.form.fields.FormItem#getValidateOnChange validateOnChange} property.
    *
    * @param validateOnChange validateOnChange Default value is null
    */
    public void setValidateOnChange(Boolean validateOnChange) {
        setAttribute("validateOnChange", validateOnChange);
    }
    /**
     * If set to true, any {@link com.smartgwt.client.widgets.grid.ListGridField#getValidators validators} for this field will be run whenever&#010 the value of the field is changed.&#010 <P>&#010 Analgous to the {@link com.smartgwt.client.widgets.form.fields.FormItem#getValidateOnChange validateOnChange} property.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getValidateOnChange()  {
        return getAttributeAsBoolean("validateOnChange");
    }

    /**
    * When the user edits cells in this field, is this value required to be non-empty &#010 in order for validation to pass.<br>&#010 Note: for databound listGrids, this property may be specified on the &#010 {@link com.smartgwt.client.data.DataSourceField}, enabling both client and server side validation.
    *
    * @param required required Default value is null
    */
    public void setRequired(Boolean required) {
        setAttribute("required", required);
    }
    /**
     * When the user edits cells in this field, is this value required to be non-empty &#010 in order for validation to pass.<br>&#010 Note: for databound listGrids, this property may be specified on the &#010 {@link com.smartgwt.client.data.DataSourceField}, enabling both client and server side validation.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getRequired()  {
        return getAttributeAsBoolean("required");
    }

    /**
    * If set to true and {@link com.smartgwt.client.widgets.grid.ListGrid#getCanRemoveRecords canRemoveRecords} is true, this field will be rendered&#010 as the remove-field for this grid. In most common usage scenarios this field will essentially&#010 be a placeholder indicating where the remove field should be rendered, meaning properties &#010 other than <code>isRemoveField</code>, such as <code>name</code> or <code>title</code>, may&#010 be left unset.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param isRemoveField isRemoveField Default value is null
    */
    public void setIsRemoveField(Boolean isRemoveField) {
        setAttribute("isRemoveField", isRemoveField);
    }
    /**
     * If set to true and {@link com.smartgwt.client.widgets.grid.ListGrid#getCanRemoveRecords canRemoveRecords} is true, this field will be rendered&#010 as the remove-field for this grid. In most common usage scenarios this field will essentially&#010 be a placeholder indicating where the remove field should be rendered, meaning properties &#010 other than <code>isRemoveField</code>, such as <code>name</code> or <code>title</code>, may&#010 be left unset.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getIsRemoveField()  {
        return getAttributeAsBoolean("isRemoveField");
    }

    /**
    * If showing a filter row for this ListGrid, should the filter criteria for this &#010      field be editable
    *
    * @param canFilter canFilter Default value is null
    */
    public void setCanFilter(Boolean canFilter) {
        setAttribute("canFilter", canFilter);
    }
    /**
     * If showing a filter row for this ListGrid, should the filter criteria for this &#010      field be editable
     *
     *
     * @return Boolean
     *
     */
    public Boolean getCanFilter()  {
        return getAttributeAsBoolean("canFilter");
    }

    /**
    * If we're showing the filterEditor (listGrid.showFilterEditor is true), this property &#010 determines whether this list should be filtered every time the user edits the value of&#010 the filter editor for this field.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param filterOnKeypress filterOnKeypress Default value is null
    */
    public void setFilterOnKeypress(Boolean filterOnKeypress) {
        setAttribute("filterOnKeypress", filterOnKeypress);
    }
    /**
     * If we're showing the filterEditor (listGrid.showFilterEditor is true), this property &#010 determines whether this list should be filtered every time the user edits the value of&#010 the filter editor for this field.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getFilterOnKeypress()  {
        return getAttributeAsBoolean("filterOnKeypress");
    }

    /**
    * The HTML to display in cells of this field if the fieldType is set to link. Can be&#010  overridden by {@link com.smartgwt.client.widgets.grid.ListGridRecord#getLinkText linkText}.
    *
    * @param linkText linkText Default value is null
    */
    public void setLinkText(String linkText) {
        setAttribute("linkText", linkText);
    }
    /**
     * The HTML to display in cells of this field if the fieldType is set to link. Can be&#010  overridden by {@link com.smartgwt.client.widgets.grid.ListGridRecord#getLinkText linkText}.
     *
     *
     * @return String
     *
     */
    public String getLinkText()  {
        return getAttributeAsString("linkText");
    }

    /**
    * The value to display for a cell whose value is null or the empty&#010 string after applying formatCellValue and valueMap (if any).&#010 <p>&#010 This is the field-specific attribute.  You may also set the emptyCellValue at the grid&#010 level to define the emptyCellValue for all empty fields in the grid.
    *
    * @param emptyCellValue emptyCellValue Default value is "&amp;nbsp;"
    */
    public void setEmptyCellValue(String emptyCellValue) {
        setAttribute("emptyCellValue", emptyCellValue);
    }
    /**
     * The value to display for a cell whose value is null or the empty&#010 string after applying formatCellValue and valueMap (if any).&#010 <p>&#010 This is the field-specific attribute.  You may also set the emptyCellValue at the grid&#010 level to define the emptyCellValue for all empty fields in the grid.
     *
     *
     * @return String
     *
     */
    public String getEmptyCellValue()  {
        return getAttributeAsString("emptyCellValue");
    }

    /**
    * If true, automatically fetches records and derives a valueMap from&#010 {@link com.smartgwt.client.widgets.grid.ListGridField#getOptionDataSource optionDataSource}.&#010 <p>&#010 Same as {@link com.smartgwt.client.widgets.grid.ListGrid#getAutoFetchDisplayMap autoFetchDisplayMap}, but defined on a per-field basis.
    *
    * @param autoFetchDisplayMap autoFetchDisplayMap Default value is null
    */
    public void setAutoFetchDisplayMap(Boolean autoFetchDisplayMap) {
        setAttribute("autoFetchDisplayMap", autoFetchDisplayMap);
    }
    /**
     * If true, automatically fetches records and derives a valueMap from&#010 {@link com.smartgwt.client.widgets.grid.ListGridField#getOptionDataSource optionDataSource}.&#010 <p>&#010 Same as {@link com.smartgwt.client.widgets.grid.ListGrid#getAutoFetchDisplayMap autoFetchDisplayMap}, but defined on a per-field basis.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getAutoFetchDisplayMap()  {
        return getAttributeAsBoolean("autoFetchDisplayMap");
    }

    /**
    * For fields with an {@link com.smartgwt.client.widgets.grid.ListGridField#getOptionDataSource optionDataSource}, where&#010 ${isc.DocUtils.linkForRef('listGTridField.autoFetchDisplayMap')} is true, this property will govern&#010 the <code>textMatchStyle</code> attribute of the {@link com.smartgwt.client.data.DSRequest} parameter passed to &#010 {@link com.smartgwt.client.data.DataSource#fetchData} when retrieving the remote data set to be used as &#010 a basis for thiis field's valueMap.
    *
    * @param optionTextMatchStyle optionTextMatchStyle Default value is null
    */
    public void setOptionTextMatchStyle(String optionTextMatchStyle) {
        setAttribute("optionTextMatchStyle", optionTextMatchStyle);
    }
    /**
     * For fields with an {@link com.smartgwt.client.widgets.grid.ListGridField#getOptionDataSource optionDataSource}, where&#010 ${isc.DocUtils.linkForRef('listGTridField.autoFetchDisplayMap')} is true, this property will govern&#010 the <code>textMatchStyle</code> attribute of the {@link com.smartgwt.client.data.DSRequest} parameter passed to &#010 {@link com.smartgwt.client.data.DataSource#fetchData} when retrieving the remote data set to be used as &#010 a basis for thiis field's valueMap.
     *
     *
     * @return String
     *
     */
    public String getOptionTextMatchStyle()  {
        return getAttributeAsString("optionTextMatchStyle");
    }

    /**
    * If this field has an optionDataSource specified and &#010 {@link com.smartgwt.client.widgets.grid.ListGridField#getAutoFetchDisplayMap 'autoFetchDisplayMap'} is set, this attribute&#010 provides a way to customize the {@link com.smartgwt.client.data.DSRequest#getOperationId operationId} passed to &#010 <code>dataSource.fetchData()</code> when retrieving the display map from the option &#010 dataSource.
    *
    * @param optionOperationId optionOperationId Default value is null
    */
    public void setOptionOperationId(String optionOperationId) {
        setAttribute("optionOperationId", optionOperationId);
    }
    /**
     * If this field has an optionDataSource specified and &#010 {@link com.smartgwt.client.widgets.grid.ListGridField#getAutoFetchDisplayMap 'autoFetchDisplayMap'} is set, this attribute&#010 provides a way to customize the {@link com.smartgwt.client.data.DSRequest#getOperationId operationId} passed to &#010 <code>dataSource.fetchData()</code> when retrieving the display map from the option &#010 dataSource.
     *
     *
     * @return String
     *
     */
    public String getOptionOperationId()  {
        return getAttributeAsString("optionOperationId");
    }

    /**
    * Specifies the {@link com.smartgwt.client.widgets.grid.ListGridField#getOptionDataSource optionDataSource} field used to retrieve the stored&#010 values that are to be mapped to the display values (specified by&#010 {@link com.smartgwt.client.widgets.grid.ListGridField#getDisplayField displayField}). Note that if this field is editable this will also&#010 be applied to this field's editors.
    *
    * @param valueField valueField Default value is null
    */
    public void setValueField(String valueField) {
        setAttribute("valueField", valueField);
    }
    /**
     * Specifies the {@link com.smartgwt.client.widgets.grid.ListGridField#getOptionDataSource optionDataSource} field used to retrieve the stored&#010 values that are to be mapped to the display values (specified by&#010 {@link com.smartgwt.client.widgets.grid.ListGridField#getDisplayField displayField}). Note that if this field is editable this will also&#010 be applied to this field's editors.
     *
     *
     * @return String
     *
     */
    public String getValueField()  {
        return getAttributeAsString("valueField");
    }

    /**
    * Specifies the {@link com.smartgwt.client.widgets.grid.ListGridField#getOptionDataSource optionDataSource} field used to retrieve the display&#010 values that are to be mapped from the internal values specified by {@link com.smartgwt.client.widgets.grid.ListGridField#getValueField valueField}.<br>&#010 If no <code>optionDataSource</code> is defined for the field, the cell will display&#010 the displayField value for the current record instead of the underlying value for&#010 this field. Note that if this field is editable this will also&#010 be applied to this field's editors.&#010 <p>&#010 The display value for a record with a specified <code>displayField</code> can be &#010 picked up via {@link com.smartgwt.client.widgets.grid.ListGrid#getDisplayValue}.
    *
    * @param displayField displayField Default value is null
    */
    public void setDisplayField(String displayField) {
        setAttribute("displayField", displayField);
    }
    /**
     * Specifies the {@link com.smartgwt.client.widgets.grid.ListGridField#getOptionDataSource optionDataSource} field used to retrieve the display&#010 values that are to be mapped from the internal values specified by {@link com.smartgwt.client.widgets.grid.ListGridField#getValueField valueField}.<br>&#010 If no <code>optionDataSource</code> is defined for the field, the cell will display&#010 the displayField value for the current record instead of the underlying value for&#010 this field. Note that if this field is editable this will also&#010 be applied to this field's editors.&#010 <p>&#010 The display value for a record with a specified <code>displayField</code> can be &#010 picked up via {@link com.smartgwt.client.widgets.grid.ListGrid#getDisplayValue}.
     *
     *
     * @return String
     *
     */
    public String getDisplayField()  {
        return getAttributeAsString("displayField");
    }

    /**
    * Whether to show hovers for this field.  The default hover will be the contents of the&#010 cell the user is hovering over, and can be customized via&#010 {@link com.smartgwt.client.widgets.grid.ListGridField#hoverHTML}.&#010 <P>&#010 {@link com.smartgwt.client.widgets.grid.ListGrid#getCanHover canHover} can be set to true to cause hovers to be shown for all fields&#010 by default.  In this case, <code>field.showHover</code> can be set to false to suppress&#010 hovers for an individual field.&#010 <P>&#010 All hovers can be disabled, regardless of other settings, by setting&#010 {@link com.smartgwt.client.widgets.grid.ListGrid#getShowHover showHover} to false.
    *
    * @param showHover showHover Default value is null
    */
    public void setShowHover(Boolean showHover) {
        setAttribute("showHover", showHover);
    }
    /**
     * Whether to show hovers for this field.  The default hover will be the contents of the&#010 cell the user is hovering over, and can be customized via&#010 {@link com.smartgwt.client.widgets.grid.ListGridField#hoverHTML}.&#010 <P>&#010 {@link com.smartgwt.client.widgets.grid.ListGrid#getCanHover canHover} can be set to true to cause hovers to be shown for all fields&#010 by default.  In this case, <code>field.showHover</code> can be set to false to suppress&#010 hovers for an individual field.&#010 <P>&#010 All hovers can be disabled, regardless of other settings, by setting&#010 {@link com.smartgwt.client.widgets.grid.ListGrid#getShowHover showHover} to false.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getShowHover()  {
        return getAttributeAsBoolean("showHover");
    }

    /**
    * Allows a boolean or {@link com.smartgwt.client..ValueMap} field to be edited without going into&#010 edit mode. When this attribute is set, if clicking on the field will change the value - for&#010 boolean fields toggling between <code>true</code> and <code>false</code>, and for valueMapped&#010 fields, advancing the value to the next option in the valueMap.&#010 <P>&#010 To enable this feature, {@link com.smartgwt.client.widgets.grid.ListGrid#getCanEdit canEdit} must be set to true.  Note that you can&#010 enable toggling only (without allowing the user to edit other fields) by just setting&#010 {@link com.smartgwt.client.widgets.grid.ListGrid#getEditEvent 'grid.editEvent:"none"'}.&#010 <P>&#010 If {@link com.smartgwt.client.widgets.grid.ListGrid#getEditEvent editEvent} is set to "click", when the user clicks on the field, &#010 the value will be toggled, and inline editing will be triggered as usual.&#010 Otherwise the toggled value will be saved immediately to the server, or if &#010 {@link com.smartgwt.client.widgets.grid.ListGrid#getAutoSaveEdits autoSaveEdits} has been set to false, will be stored as an edit value&#010 for the record.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param canToggle canToggle Default value is null
    */
    public void setCanToggle(Boolean canToggle) {
        setAttribute("canToggle", canToggle);
    }
    /**
     * Allows a boolean or {@link com.smartgwt.client..ValueMap} field to be edited without going into&#010 edit mode. When this attribute is set, if clicking on the field will change the value - for&#010 boolean fields toggling between <code>true</code> and <code>false</code>, and for valueMapped&#010 fields, advancing the value to the next option in the valueMap.&#010 <P>&#010 To enable this feature, {@link com.smartgwt.client.widgets.grid.ListGrid#getCanEdit canEdit} must be set to true.  Note that you can&#010 enable toggling only (without allowing the user to edit other fields) by just setting&#010 {@link com.smartgwt.client.widgets.grid.ListGrid#getEditEvent 'grid.editEvent:"none"'}.&#010 <P>&#010 If {@link com.smartgwt.client.widgets.grid.ListGrid#getEditEvent editEvent} is set to "click", when the user clicks on the field, &#010 the value will be toggled, and inline editing will be triggered as usual.&#010 Otherwise the toggled value will be saved immediately to the server, or if &#010 {@link com.smartgwt.client.widgets.grid.ListGrid#getAutoSaveEdits autoSaveEdits} has been set to false, will be stored as an edit value&#010 for the record.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getCanToggle()  {
        return getAttributeAsBoolean("canToggle");
    }

    // ********************* Methods ***********************



        /**
         * If your derivation of the field title is more complex than specifying a static string,&#010 you can specify a getFieldTitle() method on your field to return the title string.&#010 Otherwise you can use the {@link com.smartgwt.client.widgets.grid.ListGridField#getTitle title} attribute on the field to specify the title.&#010 <P>&#010 You can use {@link com.smartgwt.client.widgets.grid.ListGrid#setFieldProperties} to dynamically&#010 update the title.&#010&#010
         * @param viewer pointer back to the ListGrid
     * @param fieldNum index of this field in the grid's fields array.
         */
        public native void getFieldTitle(ListGrid viewer, int fieldNum) /*-{
            var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
            self.getFieldTitle(viewer.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()(), fieldNum);
        }-*/;





        /**
         * Add a editorEnter handler.
         * <p>
         * Callback fired when the user first starts editing a cell.&#010 <P>&#010 This callback is typically used to establish dynamic default values via&#010 {@link com.smartgwt.client.widgets.grid.ListGrid#setEditValue} or {@link com.smartgwt.client.widgets.grid.ListGrid#setEditValues}.&#010&#010
         *
         * @param handler the editorEnter handler
         * @return {@link HandlerRegistration} used to remove this handler
         */
        public HandlerRegistration addEditorEnterHandler(com.smartgwt.client.widgets.grid.events.EditorEnterHandler handler) {
            if(getHandlerCount(com.smartgwt.client.widgets.grid.events.EditorEnterEvent.getType()) == 0) setupEditorEnterEvent();
            return doAddHandler(handler, com.smartgwt.client.widgets.grid.events.EditorEnterEvent.getType());
        }
        private native void setupEditorEnterEvent() /*-{
            var obj = null;
                obj = this.@com.smartgwt.client.core.DataClass::getJsObj()();
                var selfJ = this;
                obj.editorEnter = function(){
                    var param = {"record" : arguments[0], "value" : arguments[1], "rowNum" : arguments[2], "colNum" : arguments[3], "grid" : arguments[4]};
                    var event = @com.smartgwt.client.widgets.grid.events.EditorEnterEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    selfJ.@com.smartgwt.client.core.DataClass::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                };
        }-*/;

        /**
         * Add a editorExit handler.
         * <p>
         * Callback fired when the user attempts to navigate away from the current edit cell, &#010 or complete the current edit.<br>&#010 Return false from this method to cancel the default behavior (Saving / cancelling the&#010 current edit / moving to the next edit cell)&#010&#010
         *
         * @param handler the editorExit handler
         * @return {@link HandlerRegistration} used to remove this handler
         */
        public HandlerRegistration addEditorExitHandler(com.smartgwt.client.widgets.grid.events.EditorExitHandler handler) {
            if(getHandlerCount(com.smartgwt.client.widgets.grid.events.EditorExitEvent.getType()) == 0) setupEditorExitEvent();
            return doAddHandler(handler, com.smartgwt.client.widgets.grid.events.EditorExitEvent.getType());
        }
        private native void setupEditorExitEvent() /*-{
            var obj = null;
                obj = this.@com.smartgwt.client.core.DataClass::getJsObj()();
                var selfJ = this;
                obj.editorExit = function(){
                    var param = {"editCompletionEvent" : arguments[0], "record" : arguments[1], "newValue" : arguments[2], "rowNum" : arguments[3], "colNum" : arguments[4], "grid" : arguments[5]};
                    var event = @com.smartgwt.client.widgets.grid.events.EditorExitEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    selfJ.@com.smartgwt.client.core.DataClass::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                    return !ret;
                };
        }-*/;


        /**
         * Add a recordClick handler.
         * <p>
         * &#010 Executed when this field is clicked on.  Note that if {@link com.smartgwt.client.widgets.grid.ListGrid#addRecordClickHandler} is&#010 also defined, it will be fired for fields that define a recordClick handler if the&#010 field-level handler returns true. Return false to prevent the grid-level handler from firing.&#010&#010
         *
         * @param handler the recordClick handler
         * @return {@link HandlerRegistration} used to remove this handler
         */
        public HandlerRegistration addRecordClickHandler(com.smartgwt.client.widgets.grid.events.RecordClickHandler handler) {
            if(getHandlerCount(com.smartgwt.client.widgets.grid.events.RecordClickEvent.getType()) == 0) setupRecordClickEvent();
            return doAddHandler(handler, com.smartgwt.client.widgets.grid.events.RecordClickEvent.getType());
        }
        private native void setupRecordClickEvent() /*-{
            var obj = null;
                obj = this.@com.smartgwt.client.core.DataClass::getJsObj()();
                var selfJ = this;
                obj.recordClick = function(){
                    var param = {"viewer" : arguments[0], "record" : arguments[1], "recordNum" : arguments[2], "field" : arguments[3], "fieldNum" : arguments[4], "value" : arguments[5], "rawValue" : arguments[6]};
                    var event = @com.smartgwt.client.widgets.grid.events.RecordClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    selfJ.@com.smartgwt.client.core.DataClass::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                    return !ret;
                };
        }-*/;






        /**
         * Add a change handler.
         * <p>
         * If this field is editable, any {@link com.smartgwt.client.widgets.form.fields.FormItem#addChangeHandler} handler specified&#010 on the ListGridField will be passed onto the editors for this field.&#010
         *
         * @param handler the change handler
         * @return {@link HandlerRegistration} used to remove this handler
         */
        public HandlerRegistration addChangeHandler(com.smartgwt.client.widgets.grid.events.ChangeHandler handler) {
            if(getHandlerCount(com.smartgwt.client.widgets.grid.events.ChangeEvent.getType()) == 0) setupChangeEvent();
            return doAddHandler(handler, com.smartgwt.client.widgets.grid.events.ChangeEvent.getType());
        }
        private native void setupChangeEvent() /*-{
            var obj = null;
                obj = this.@com.smartgwt.client.core.DataClass::getJsObj()();
                var selfJ = this;
                obj.change = function(){
                    var param = {"form" : arguments[0], "item" : arguments[1], "value" : arguments[2], "oldValue" : arguments[3]};
                    var event = @com.smartgwt.client.widgets.grid.events.ChangeEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    selfJ.@com.smartgwt.client.core.DataClass::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                };
        }-*/;

        /**
         * Add a changed handler.
         * <p>
         * If this field is editable, any {@link com.smartgwt.client.widgets.form.fields.FormItem#addChangedHandler} handler specified&#010 on the ListGridField will be passed onto the editors for this field.&#010
         *
         * @param handler the changed handler
         * @return {@link HandlerRegistration} used to remove this handler
         */
        public HandlerRegistration addChangedHandler(com.smartgwt.client.widgets.grid.events.ChangedHandler handler) {
            if(getHandlerCount(com.smartgwt.client.widgets.grid.events.ChangedEvent.getType()) == 0) setupChangedEvent();
            return doAddHandler(handler, com.smartgwt.client.widgets.grid.events.ChangedEvent.getType());
        }
        private native void setupChangedEvent() /*-{
            var obj = null;
                obj = this.@com.smartgwt.client.core.DataClass::getJsObj()();
                var selfJ = this;
                obj.changed = function(){
                    var param = {"form" : arguments[0], "item" : arguments[1], "value" : arguments[2]};
                    var event = @com.smartgwt.client.widgets.grid.events.ChangedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    selfJ.@com.smartgwt.client.core.DataClass::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                };
        }-*/;



    // ********************* Static Methods ***********************






    /**
     * If this ListGrid is showing a filter row, this property can be used to apply a default value to show in the filter editor for this field.
     *
     * @param defaultFilterValue the default filter value
     */
    public void setDefaultFilterValue(String defaultFilterValue) {
        setAttribute("defaultFilterValue", defaultFilterValue);
    }

    /**
     * If this ListGrid is showing a filter row, this property can be used to apply a default value to show in the filter editor for this field.
     *
     * @param defaultFilterValue the default filter value
     */
    public void setDefaultFilterValue(Integer defaultFilterValue) {
        setAttribute("defaultFilterValue", defaultFilterValue);
    }

    /**
     * If this ListGrid is showing a filter row, this property can be used to apply a default value to show in the filter editor for this field.
     *
     * @param defaultFilterValue the default filter value
     */
    public void setDefaultFilterValue(Float defaultFilterValue) {
        setAttribute("defaultFilterValue", defaultFilterValue);
    }

    /**
     * If this ListGrid is showing a filter row, this property can be used to apply a default value to show in the filter editor for this field.
     *
     * @param defaultFilterValue the default filter value
     */
    public void setDefaultFilterValue(Boolean defaultFilterValue) {
        setAttribute("defaultFilterValue", defaultFilterValue);
    }

    /**
     * If this ListGrid is showing a filter row, this property can be used to apply a default value to show in the filter editor for this field.
     *
     * @param defaultFilterValue the default filter value
     */
    public void setDefaultFilterValue(Date defaultFilterValue) {
        setAttribute("defaultFilterValue", defaultFilterValue);
    }

    /**
    * Display format to use for fields specified as type 'date'.  Default is to use the system-wide default short date format, configured via {@link com.smartgwt.client..Date#setShortDisplayFormat}.  Specify any valid {@link com.smartgwt.client.types.DateDisplayFormat}, or function to change the display format for dates used by this grid. If specified as  a function, this function will be executed in the scope of the Date and should return the formatted string.<br> May also be specified at the field level via {@link com.smartgwt.client.widgets.grid.ListGridField#getDisplayFormat displayFormat}.<br> If this field is editable the dateFormatter will also be passed to the editor created to edit this field as {@link com.smartgwt.client.widgets.form.fields.DateItem#getDisplayFormat displayFormat}. In this case you may also need to set {@link com.smartgwt.client.widgets.grid.ListGrid#getDateInputFormat dateInputFormat}.
    *
    * @param dateFormatter dateFormatter Default value is null
    */
    public void setDateFormatter(DateDisplayFormat dateFormatter) {
        setAttribute("dateFormatter", dateFormatter.getValue());
    }

    /**
     * Display format to use for fields specified as type 'date'.  Default is to use the system-wide default short date format, configured via {@link com.smartgwt.client.util.DateUtil#setShortDateDisplayFormatter(com.smartgwt.client.util.DateDisplayFormatter)}.  Specify any valid {@link com.smartgwt.client.types.DateDisplayFormat}, or function to change the display format for dates used by this grid. If specified as  a function, this function will be executed in the scope of the Date and should return the formatted string.<br> May also be specified at the field level via {@link com.smartgwt.client.widgets.grid.ListGridField#getDisplayFormat displayFormat}.<br> If this field is editable the dateFormatter will also be passed to the editor created to edit this field as {@link com.smartgwt.client.widgets.form.fields.DateItem#getDisplayFormat displayFormat}. In this case you may also need to set {@link com.smartgwt.client.widgets.grid.ListGrid#getDateInputFormat dateInputFormat}.
     *
     *
     * @return DateDisplayFormat
     *
     */
    public DateDisplayFormat getDateFormatter()  {
        return (DateDisplayFormat) EnumUtil.getEnum(DateDisplayFormat.values(), getAttribute("dateFormatter"));
    }

    /**
     * If this field is editable, this property can be used to specify  {@link com.smartgwt.client.widgets.form.fields.FormItem#getIcons
     * icons} to be displayed in the editors displayed for this field <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param icons icons Default value is null
     */
    public void setIcons(FormItemIcon... icons) {
        setAttribute("icons", icons);
    }

    /**
    * If set, provides several possible styles of grouping that are valid for this field.  For&#010 example, a field of type:"date" might be able to be grouped by week, month, or by day of&#010 week.&#010 <P>&#010 If <code>groupingModes</code> are present and&#010 {@link com.smartgwt.client.widgets.grid.ListGrid#getCanGroupBy canGroupBy}, the menu for this field includes a&#010 submenu of possible grouping modes generated from the <code>groupingModes</code> valueMap.&#010 When the user selects a particular grouping mode,&#010 {@link com.smartgwt.client.widgets.grid.ListGridField#getGroupingMode groupingMode} is set to the user's chosen mode,&#010 and this choice can be detected via the <code>field</code> parameter to&#010 {@link com.smartgwt.client.widgets.grid.ListGridField#getGroupValue} in order to provide different modes of grouping.&#010 <P>&#010 The user may also choose to group records without specifying a grouping mode, in this case,&#010 the {@link com.smartgwt.client.widgets.grid.ListGridField#getDefaultGroupingMode defaultGroupingMode} is used.&#010 <P>&#010 Note that <code>getGroupValue</code>, <code>groupingModes</code> et al can be specified on&#010 {@link com.smartgwt.client.data.SimpleType} declaration, and the different grouping modes that are offered&#010 automatically for various common types are defined this way.
    *
    * @param groupingModes groupingModes Default value is null
    */
    public void setGroupingModes(Map groupingModes) {
        setAttribute("groupingModes", groupingModes);
    }
    /**
     * If set, provides several possible styles of grouping that are valid for this field.  For&#010 example, a field of type:"date" might be able to be grouped by week, month, or by day of&#010 week.&#010 <P>&#010 If <code>groupingModes</code> are present and&#010 {@link com.smartgwt.client.widgets.grid.ListGrid#getCanGroupBy canGroupBy}, the menu for this field includes a&#010 submenu of possible grouping modes generated from the <code>groupingModes</code> valueMap.&#010 When the user selects a particular grouping mode,&#010 {@link com.smartgwt.client.widgets.grid.ListGridField#getGroupingMode groupingMode} is set to the user's chosen mode,&#010 and this choice can be detected via the <code>field</code> parameter to&#010 {@link com.smartgwt.client.widgets.grid.ListGridField#getGroupValue} in order to provide different modes of grouping.&#010 <P>&#010 The user may also choose to group records without specifying a grouping mode, in this case,&#010 the {@link com.smartgwt.client.widgets.grid.ListGridField#getDefaultGroupingMode defaultGroupingMode} is used.&#010 <P>&#010 Note that <code>getGroupValue</code>, <code>groupingModes</code> et al can be specified on&#010 {@link com.smartgwt.client.data.SimpleType} declaration, and the different grouping modes that are offered&#010 automatically for various common types are defined this way.
     *
     *
     * @return the value map
     *
     */
    public Map getGroupingModes()  {
        return getAttributeAsMap("groupingModes");
    }

    /**
     * * Return the HTML to display in cells of this field. <P> Given the raw value for this field as taken from the
     * record Formatter to apply to the static values displayed in cells for this field. <P> <i>Example usage</i>:
     * formatting a currency value stored in cents (so "100" to "$1.00")<br> The value passed to this method is the raw
     * value for the cell.<br> Takes precedence over <code>formatCellValue</code> defined at the grid level for cells in
     * this field. <P> Note: this formatter will not be applied to the values displayed in cells being edited. The
     * {@link com.smartgwt.client.widgets.grid.ListGridField#formatEditorValue} is provided for that purpose.
     *
     * @param formatter the formatter
     */
    public native void setCellFormatter(CellFormatter formatter) /*-{
            var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
            self.formatCellValue = function(value, record, rowNum, colNum) {
                var recordJ = @com.smartgwt.client.widgets.grid.ListGridRecord::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(record);
                var valueJ = $wnd.SmartGWT.convertToJavaType(value);
                return formatter.@com.smartgwt.client.widgets.grid.CellFormatter::format(Ljava/lang/Object;Lcom/smartgwt/client/widgets/grid/ListGridRecord;II)(valueJ, recordJ, rowNum, colNum);
            };
    }-*/;

    /**
     * Optional function to return the value that should be used when sorting this field. <P> Note that, if the dataset
     * exceeds {@link com.smartgwt.client.widgets.grid.ListGrid#getDataPageSize dataPageSize} and hence paging is
     * introduced, the grid relies on the server to provide sorting, and the sortNormalizer will no longer be called.
     *
     * @param normalizer the sort normalizer
     */
    public native void setSortNormalizer(SortNormalizer normalizer) /*-{
            var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
            self.sortNormalizer = function(record, fieldName) {
                var recordJ = @com.smartgwt.client.widgets.grid.ListGridRecord::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(record);
                var value = normalizer.@com.smartgwt.client.widgets.grid.SortNormalizer::normalize(Lcom/smartgwt/client/widgets/grid/ListGridRecord;Ljava/lang/String;)(recordJ, fieldName);
                if(value == null) return null;
                if(typeof value == 'string') {
                    return value;
                } else {
                    return @com.smartgwt.client.widgets.grid.ListGridField::normalizedValue(Ljava/lang/Number;)(value);
                }
            };
    }-*/;

    private static double normalizedValue(Number number) {
        return number.doubleValue();
    }

    /**
     * * HTML to be shown in hovers over cells in the column described by this field.
     *
     * @param hoverCustomizer the hover customizer
     */
    public native void setHoverCustomizer(HoverCustomizer hoverCustomizer) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.hoverHTML = function(record, value, rowNum, colNum, grid) {
            var recordJ = @com.smartgwt.client.widgets.grid.ListGridRecord::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(record);            
            var valueJ = $wnd.SmartGWT.convertToJavaType(value);
            return hoverCustomizer.@com.smartgwt.client.widgets.grid.HoverCustomizer::hoverHTML(Ljava/lang/Object;Lcom/smartgwt/client/widgets/grid/ListGridRecord;II)(valueJ, recordJ, rowNum, colNum);
        };
    }-*/;

    /**
     * Horizontal alignment for field's column header: "left", "right" or "center". Applied to the column header title
     * and cells by default. A separate alignment for cells can be specified via {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getCellAlign cellAlign}.<br> If null, values are left-aligned. If
     * this field is editable, the alignment of cells in the body will also be reflected in any editors for the field.
     *
     * @param align align Default value is null
     */
    public void setAlign(Alignment align) {
        setAttribute("align", align.getValue());
    }

    /**
     * Horizontal alignment for field's column header: "left", "right" or "center". Applied to the column header title
     * and cells by default. A separate alignment for cells can be specified via {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getCellAlign cellAlign}.<br> If null, values are left-aligned. If
     * this field is editable, the alignment of cells in the body will also be reflected in any editors for the field.
     *
     * @return String
     */
    public Alignment getAlign() {
        return (Alignment) EnumUtil.getEnum(Alignment.values(), getAttribute("align"));
    }

    /**
     * The width of this field, specified as either an absolute number of pixels,  a percentage of the remaining space,
     * or "*" to allocate an equal portion of the  remaining space. <br>  ListGrid field widths may also be set when the
     * fields are instantiated via the   listGrid.setFields() method by passing an array of numbers (absolute pixel
     * sizes only)   as the second parameter
     *
     * @param width width Default value is "*"
     */
    public void setWidth(int width) {
        setAttribute("width", width);
    }

    /**
     * The width of this field, specified as either an absolute number of pixels,  a percentage of the remaining space,
     * or "*" to allocate an equal portion of the  remaining space. <br>  ListGrid field widths may also be set when the
     * fields are instantiated via the   listGrid.setFields() method by passing an array of numbers (absolute pixel
     * sizes only)   as the second parameter
     *
     * @param width width Default value is "*"
     */
    public void setWidth(String width) {
        setAttribute("width", width);
    }

    /**
     * Return the width of the field. 
     *
     * @return the field width as a String
     */
    public String getWidth() {
        return getAttribute("width");
    }



    public void setHidden(boolean hidden) {
        setAttribute("showIf", hidden ? "false" : "true");
    }

    public void setImgDir(String imgDir) {
        setAttribute("imgDir", imgDir);
    }

    public void setPrompt(String prompt) {
        setAttribute("prompt", prompt);
    }

    public void setDefaultValue(String defaultValue) {
        setAttribute("defaultValue", defaultValue);
    }

    public void setDefaultValue(Integer defaultValue) {
        setAttribute("defaultValue", defaultValue);
    }

    public void setDefaultValue(Boolean defaultValue) {
        setAttribute("defaultValue", defaultValue);
    }

    public void setDefaultValue(Float defaultValue) {
        setAttribute("defaultValue", defaultValue);
    }

    public void setDefaultValue(Date defaultValue) {
        setAttribute("defaultValue", defaultValue);
    }

    /**
     * Name of form item type to use for the form item created to edit this field. (Only used if this field is
     * editable). Note: If this is not specified, the edit-form item type may be derived from the editorType property,
     * typically inherited from datasource fields, or from the type of the field (showing the appropriate form item for
     * the data-type). See the Grid Editing overview for more on editing ListGrid fields.
     *
     * @param editorType the editor type
     */
    public void setEditorType(FormItem editorType) {
        setAttribute("editorType", editorType.getType());
        JavaScriptObject editorConfig = editorType.getConfig();
        setAttribute("editorProperties", editorConfig);
    }

    /**
     * If this ListGrid is showing a filter row, this property can be used to specify the form item class to use
     * for the filter form item associated with this field (Only used if this field is not canFilter:false).
     * <br>
     *
     * <b>Note</b>: If this is not specified, the edit-form item type may be derived from the 'editorType' property,
     * typically inherited from datasource fields, or from the 'type' of the field (showing the appropriate form item for the data-type).
     *
     * @param filterEditorType the filter editor type
     */
    public void setFilterEditorType(FormItem filterEditorType) {
        setAttribute("filterEditorType", filterEditorType.getType());
        JavaScriptObject editorConfig = filterEditorType.getConfig();
        setAttribute("filterEditorProperties", editorConfig);
    }

    /**
     * If this listGrid is showing a filter row, this property can be used to specify a mapping of internal data to/from display
     * values to be in the appropriate filter row form item.
     *
     * @param filterEditorValueMap the filter editor value map
     */
    public void setFilterEditorValueMap(Map filterEditorValueMap) {
        setAttribute("filterEditorValueMap", filterEditorValueMap);
    }

    /**
     * When using a valueMap, set multiple to true if a select list box is desired instead of a combobox when editing the cell.
     *
     * @param multiple true for select list
     */
    public void setMultiple(boolean multiple) {
        setAttribute("multiple", multiple);
    }

    /**
     * A valueMap to use for editors shown for this field. By default if this is not specified field.valueMap will be used instead.
     *
     * <p>
     * Dynamic valueMaps can be provided by implementing ListGrid.getEditorValueMap().
     *
     * @param editorValueMap the editor value map
     */
    public void setEditorValueMap(Map editorValueMap) {
        setAttribute("editorValueMap", editorValueMap);
    }

    /**
     * Array of {@link com.smartgwt.client.widgets.form.validator.Validator} objects for this field.  When the user
     * edits cells in this field, these validators will be applied to the edited value.<br> Note: for databound
     * listGrids, this property may be specified on the  {@link com.smartgwt.client.data.DataSourceField}, enabling both
     * client and server side validation.
     *
     * @param validators validators Default value is null
     */
    public void setValidators(Validator... validators) {
        setAttribute("validators", validators);
    }

    /**
     * Array of legal values for this field, or an Object where each property maps a stored value to a user-displayable
     * value.<br> Note that if this field is editable (see {@link com.smartgwt.client.widgets.grid.ListGrid#getCanEdit
     * canEdit},  {@link com.smartgwt.client.widgets.grid.ListGridField#getCanEdit canEdit}), editors displayed for this
     * field will pick up their valueMap either from this value or from {@link com.smartgwt.client.widgets.grid.ListGridField#getEditorValueMap
     * editorValueMap}. <P> See also {@link com.smartgwt.client.data.DataSourceField#getValueMap valueMap}.
     *
     * @param valueMap valueMap Default value is null
     */
    public void setValueMap(Map valueMap) {
        setAttribute("valueMap", valueMap);
    }

    /**
     * Array of legal values for this field, or an Object where each property maps a stored value to a user-displayable
     * value.<br> Note that if this field is editable (see {@link com.smartgwt.client.widgets.grid.ListGrid#getCanEdit
     * canEdit},  {@link com.smartgwt.client.widgets.grid.ListGridField#getCanEdit canEdit}), editors displayed for this
     * field will pick up their valueMap either from this value or from {@link com.smartgwt.client.widgets.grid.ListGridField#getEditorValueMap
     * editorValueMap}. <P> See also {@link com.smartgwt.client.data.DataSourceField#getValueMap valueMap}.
     *
     * @param valueMap valueMap Default value is null
     */
    public void setValueMap(String... valueMap) {
        setAttribute("valueMap", valueMap);
    }

    /**
     * This property is a mapping between data values and URLs of icons to display. If specified, for every cell in this
     * field where the data value matches an entry in the valueIcons map, an icon with the appropriate URL will be
     * displayed.<br> By default any editors displayed for this field will have the same valueIcons object applied to
     * them. This may be overridden by explicitly setting  {@link com.smartgwt.client.widgets.grid.ListGridField#getEditorValueIcons
     * editorValueIcons}.<br> Note that the following attributes related to valueIcon styling will also be picked up by
     * the editor from the ListGridField object unless explicitly specified via the equivalent <code>editor_</code>
     * attributes:<br> {@link com.smartgwt.client.widgets.grid.ListGridField#getValueIconWidth valueIconWidth}<br>
     * {@link com.smartgwt.client.widgets.grid.ListGridField#getValueIconHeight valueIconHeight}<br> {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getValueIconSize valueIconSize}<br> {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getValueIconLeftPadding valueIconLeftPadding}<br> {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getValueIconRightPadding valueIconRightPadding}<br>
     * {@link com.smartgwt.client.widgets.grid.ListGridField#getImageURLPrefix imageURLPrefix}<br>     {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getImageURLSuffix imageURLSuffix}
     *
     * @param valueIcons valueIcons Default value is null
     */
    public void setValueIcons(Map<String, String> valueIcons) {
        setAttribute("valueIcons", valueIcons);
    }

    /**
     * When some cell in this field is being edited, setting this property will specify the value icons to display in
     * the cell's editor. If unset, the editor's valueIcons will be determined in the same way as it would be for a
     * static cell.
     *
     * @param editorValueIcons editorValueIcons Default value is null
     */
    public void setEditorValueIcons(Map<String, String> editorValueIcons) {
        setAttribute("editorValueIcons", editorValueIcons);
    }


    /**
    * Derive a ValueMap by fetching records from another DataSource and extracting the
     * {@link com.smartgwt.client.widgets.grid.ListGridField#getValueField valueField} and
     * {@link com.smartgwt.client.widgets.grid.ListGridField#getDisplayField displayField} in the loaded records,
     * to derive one valueMap entry per record loaded from the optionDataSource. <P> Unlike the similar use of
     * {@link com.smartgwt.client..PickList#getOptionDataSource optionDataSource} for
     * pickLists used during editing or filtering, <code>listGridField.optionDataSource</code> causes the entire set of
     * records from the optionDataSource to be fetched, without paging.   Hence listGridField.optionDataSource is
     * appropriate only for smaller valueMaps.  For very large valueMap situations, such as an accountId field that should be
     * displayed as an accountName where there are thousands of accounts, the recommended approach is: <ul> <li> do not set
     * listGridField.optionDataSource <li> declare two fields in the DataSource, eg "accountId" and "accountName". <li>
     * Set the {@link com.smartgwt.client.widgets.grid.ListGridField#getDisplayField displayField} attribute on the data field to the
     * name of the display field. <li> When fetching records for display in a grid, have your server send back values for both fields,
     * but show only the data field ("accountId") in the grid. </ul> In this case the cells in the accountId field will show the record
     * value from the accountName field. This approach means the valueMap will never be loaded in its entirety, instead, each loaded
     * record contains the valueMapping for that one record, as a pair of fields within the record. <P> Note that it is key that the server
     * return <b>both</b> the underlying stored value <b>and</b> the display value, as suggested above, because this approach allows the
     * {@link com.smartgwt.client..PickList#getOptionDataSource optionDataSource} property to be used to provide paged valueMaps during inline
     * editing and {@link com.smartgwt.client.widgets.grid.ListGrid#getShowFilterEditor showFilterEditor}.  Note that pickList.optionDataSource
     * is a distinct setting from listGridField.optionDataSource, settable via {@link com.smartgwt.client.widgets.grid.ListGridField#getEditorProperties editorProperties}
     * (for editing) and  {@link com.smartgwt.client.widgets.grid.ListGridField#getFilterEditorProperties filterEditorProperties} (for filtering).
    *
    * @param optionDataSource optionDataSource Default value is null
    */
    public void setOptionDataSource(DataSource optionDataSource) {
        optionDataSource.getOrCreateJsObj();
        setAttribute("optionDataSource", optionDataSource.getID());
    }

    /**
     * A function, if provided, is evaluated to conditionally determine whether this field should be displayed. Evaluated on initial draw,
     * then reevaluated on explicit calls to listGrid.refreshFields() or listGrid.setFields().
     * <p>
     * Use 'showIf:"false"' to set a ListGrid field to initially hidden.
     * <p>
     * Note that explicit calls to grid.showField() or hideField() will wipe out the showIf expression, as will the end
     * user showing and hiding columns via the header contextMenu.
     * <p>
     * Also note that fields marked as detail:true will be hidden by default even if ListGrid.showDetailFields is true. To show detail fields inherited from a DataSource, include an explicit field definition for the field and set this property to return true.

     * @param showIf showIf criteria
     */
    public native void setShowIfCondition(ListGridFieldIfFunction showIf) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.showIf = function(grid, field, fieldNum) {
            var gridJ = @com.smartgwt.client.widgets.grid.ListGrid::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(grid);
            var fieldJ = @com.smartgwt.client.widgets.grid.ListGridField::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(field);        
            return showIf.@com.smartgwt.client.widgets.grid.ListGridFieldIfFunction::execute(Lcom/smartgwt/client/widgets/grid/ListGrid;Lcom/smartgwt/client/widgets/grid/ListGridField;I)(gridJ, fieldJ, fieldNum);

        };
    }-*/;

    /**
    * Specifies the default sorting direction for this column. If specified on the {@link com.smartgwt.client.widgets.grid.ListGrid#getSortField sortField} for the listGrid, sorting occurs automatically, otherwise this will be the default direction when the user clicks the field header, or calls {@link com.smartgwt.client.widgets.grid.ListGrid#sort} without specifying an explicit sort direction. <P> Overrides ListGrid.sortDirection
    *
    * @param sortDirection sortDirection Default value is null
    */
    public void setSortDirection(SortDirection sortDirection) {
        if(sortDirection == null) {
            setAttribute("sortDirection", (Boolean)null);
        } else {
            setAttribute("sortDirection", sortDirection == SortDirection.ASCENDING);
        }
    }
    
    /**
     * Specifies the default sorting direction for this column. If specified on the {@link com.smartgwt.client.widgets.grid.ListGrid#getSortField sortField} for the listGrid, sorting occurs automatically, otherwise this will be the default direction when the user clicks the field header, or calls {@link com.smartgwt.client.widgets.grid.ListGrid#sort} without specifying an explicit sort direction. <P> Overrides ListGrid.sortDirection
     *
     *
     * @return SortDirection
     *
     */
    public SortDirection getSortDirection()  {
        Boolean sortDir = getAttributeAsBoolean("sortDirection");
        if(sortDir == null) return null;
        return sortDir ? SortDirection.ASCENDING : SortDirection.DESCENDING;
    }

    /**
    * If this field has an optionDataSource specified and &#010 {@link com.smartgwt.client.widgets.grid.ListGridField#getAutoFetchDisplayMap autoFetchDisplayMap} is set, this attribute&#010 provides a way to customize the dataSource request issued to fetch the display map from&#010 the option dataSource.
    *
    * @param optionFilterContext optionFilterContext Default value is null
    */
    public void setOptionFilterContext(DSRequest optionFilterContext) {
        setAttribute("optionFilterContext", optionFilterContext);
    }

    /**
     * If this field has an optionDataSource specified and &#010 {@link com.smartgwt.client.widgets.grid.ListGridField#getAutoFetchDisplayMap autoFetchDisplayMap} is set, this attribute&#010 provides a way to customize the dataSource request issued to fetch the display map from&#010 the option dataSource.
     *
     * @return DSRequest Properties
     *
     */
    public DSRequest getOptionFilterContext()  {
        JavaScriptObject jsObj = getAttributeAsJavaScriptObject("optionFilterContext");
        return jsObj == null ? null : new DSRequest(jsObj);
    }

    /**
     * Add a cellSaved handler.
     * <p>
     * Callback fired when field changes value as the result of a cell edit.  Fired only on&#010  successful save of edit, when the new value doesn't match the value before editing.<br>&#010  <p>&#010  Same signature as {@link com.smartgwt.client.widgets.grid.ListGrid#addCellChangedHandler}, but defined on a per-field basis.&#010&#010
     *
     * @param handler the cellSaved handler
     * @return {@link com.google.gwt.event.shared.HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addCellSavedHandler(com.smartgwt.client.widgets.grid.events.CellSavedHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.grid.events.CellSavedEvent.getType()) == 0) setupCellSavedEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.grid.events.CellSavedEvent.getType());
    }
    private native void setupCellSavedEvent() /*-{
        var obj = null;
            obj = this.@com.smartgwt.client.core.DataClass::getJsObj()();
            var selfJ = this;
            obj.cellChanged = function(){
                var param = {"record" : arguments[0], "newValue" : arguments[1], "oldValue" : arguments[2], "rowNum" : arguments[3], "colNum" : arguments[4]};
                var event = @com.smartgwt.client.widgets.grid.events.CellSavedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                selfJ.@com.smartgwt.client.core.DataClass::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            };
    }-*/;

   /**
    * Renderer that returns the title that should be shown to the user for the group with the groupValue passed as a parameter.
    * <p/>
    * Default title is the groupValue itself.
    *
    * @param groupTitleRenderer the group title renderer
    */
   public native void setGroupTitleRenderer(GroupTitleRenderer groupTitleRenderer) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.getGroupTitle = function(groupValue, groupNode, field, fieldName, grid) {
            var groupValueJ =  $wnd.SmartGWT.convertToJavaType(groupValue);
            var groupNodeJ = @com.smartgwt.client.widgets.grid.GroupNode::new(Lcom/google/gwt/core/client/JavaScriptObject;)(groupNode);
            var fieldJ = @com.smartgwt.client.widgets.grid.ListGridField::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(field);
            var gridJ = @com.smartgwt.client.widgets.grid.ListGrid::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(grid);
            return groupTitleRenderer.@com.smartgwt.client.widgets.grid.GroupTitleRenderer::getGroupTitle(Ljava/lang/Object;Lcom/smartgwt/client/widgets/grid/GroupNode;Lcom/smartgwt/client/widgets/grid/ListGridField;Ljava/lang/String;Lcom/smartgwt/client/widgets/grid/ListGrid;)(groupValueJ, groupNodeJ, fieldJ, fieldName, gridJ);
        };
    }-*/;

   /**
    * Function that returns the value which records should be grouped by.
    * <p>
    * All records that for which getGroupValue() returns the same value appear in the same group. Default is the result
    * of ListGrid.getCellValue().
    * <p>
    * While any type of value may be returned, avoiding the use of string values may result in improved performance.
    * In this case, {@link GroupTitleRenderer#getGroupTitle(Object, GroupNode, ListGridField, String, ListGrid)}  may be implemented to map a numeric group value into a
    * legible string.
    *
    * @param groupValueFunction the group value function
    */
   public native void setGroupValueFunction(GroupValueFunction groupValueFunction) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.getGroupValue = function(value, record, field, fieldName, grid) {
            var valueJ =  $wnd.SmartGWT.convertToJavaType(value);
            var recordJ = @com.smartgwt.client.widgets.grid.ListGridRecord::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(record);
            var fieldJ = @com.smartgwt.client.widgets.grid.ListGridField::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(field);
            var gridJ = @com.smartgwt.client.widgets.grid.ListGrid::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(grid);
            return groupValueFunction.@com.smartgwt.client.widgets.grid.GroupValueFunction::getGroupValue(Ljava/lang/Object;Lcom/smartgwt/client/widgets/grid/ListGridRecord;Lcom/smartgwt/client/widgets/grid/ListGridField;Ljava/lang/String;Lcom/smartgwt/client/widgets/grid/ListGrid;)(valueJ, recordJ, fieldJ, fieldName, gridJ);
        };
    }-*/;

    /**
     * This function method will be called from ListGrid.getEditorValueMap() and the resulting valueMap will be used instead of any static specified valueMap for the field.
     *
     * @param editorValueMapFunction the editor value map function
     */
   public native void setEditorValueMapFunction(EditorValueMapFunction editorValueMapFunction) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.getEditorValueMap = function(values, field, grid) {
            var valuesJ =  @com.smartgwt.client.util.JSOHelper::convertToMap(Lcom/google/gwt/core/client/JavaScriptObject;)(values);
            var fieldJ = @com.smartgwt.client.widgets.grid.ListGridField::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(field);
            var gridJ = @com.smartgwt.client.widgets.grid.ListGrid::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(grid);
            var map = editorValueMapFunction.@com.smartgwt.client.widgets.grid.EditorValueMapFunction::getEditorValueMap(Ljava/util/Map;Lcom/smartgwt/client/widgets/grid/ListGridField;Lcom/smartgwt/client/widgets/grid/ListGrid;)(valuesJ, fieldJ, gridJ);
            return @com.smartgwt.client.util.JSOHelper::convertMapToJavascriptObject(Ljava/util/Map;)(map);
        };
    }-*/;


}



