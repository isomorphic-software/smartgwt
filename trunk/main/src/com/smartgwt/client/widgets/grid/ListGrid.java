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
    * A ListGrid is a ${isc.DocUtils.linkForRef('interface:DataBoundComponent')} that displays a list of objects in a grid, where each row represents one object and each cell in the row represents one property.

    */

























public class ListGrid extends Canvas  implements DataBoundComponent, com.smartgwt.client.widgets.grid.events.HasFieldStateChangedHandlers, com.smartgwt.client.widgets.grid.events.HasEditCompleteHandlers, com.smartgwt.client.widgets.grid.events.HasEditFailedHandlers, com.smartgwt.client.widgets.grid.events.HasEditorExitHandlers, com.smartgwt.client.widgets.grid.events.HasRowEditorEnterHandlers, com.smartgwt.client.widgets.grid.events.HasRowEditorExitHandlers, com.smartgwt.client.widgets.grid.events.HasEditorEnterHandlers, com.smartgwt.client.widgets.grid.events.HasCellSavedHandlers, com.smartgwt.client.widgets.grid.events.HasCellOutHandlers, com.smartgwt.client.widgets.grid.events.HasCellOverHandlers, com.smartgwt.client.widgets.grid.events.HasCellContextClickHandlers, com.smartgwt.client.widgets.grid.events.HasCellMouseDownHandlers, com.smartgwt.client.widgets.grid.events.HasCellMouseUpHandlers, com.smartgwt.client.widgets.grid.events.HasCellClickHandlers, com.smartgwt.client.widgets.grid.events.HasCellDoubleClickHandlers, com.smartgwt.client.widgets.grid.events.HasRowOutHandlers, com.smartgwt.client.widgets.grid.events.HasRowOverHandlers, com.smartgwt.client.widgets.grid.events.HasRowContextClickHandlers, com.smartgwt.client.widgets.grid.events.HasRowMouseDownHandlers, com.smartgwt.client.widgets.grid.events.HasRowMouseUpHandlers, com.smartgwt.client.widgets.grid.events.HasRecordClickHandlers, com.smartgwt.client.widgets.grid.events.HasRecordDoubleClickHandlers, com.smartgwt.client.widgets.grid.events.HasCellHoverHandlers, com.smartgwt.client.widgets.grid.events.HasRowHoverHandlers, com.smartgwt.client.widgets.grid.events.HasSelectionChangedHandlers {

    public static ListGrid getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        BaseWidget obj = BaseWidget.getRef(jsObj);
        if(obj != null) {
            return (ListGrid) obj;
        } else {
            return new ListGrid(jsObj);
        }
    }


    public ListGrid(){
        
    }

    public ListGrid(JavaScriptObject jsObj){
        super(jsObj);
    }

    protected native JavaScriptObject create()/*-{
        var config = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        var widget = $wnd.isc.ListGrid.create(config);
        this.@com.smartgwt.client.widgets.BaseWidget::doInit()();
        return widget;
    }-*/;
    // ********************* Properties / Attributes ***********************

    /**
    * If true, when this component is first drawn, automatically call <code>this.fetchData()</code>
    *
    * @param autoFetchData autoFetchData Default value is false
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setAutoFetchData(Boolean autoFetchData)  throws IllegalStateException {
        setAttribute("autoFetchData", autoFetchData, false);
    }
    /**
     * If true, when this component is first drawn, automatically call <code>this.fetchData()</code>
     *
     *
     * @return Boolean
     *
     */
    public Boolean getAutoFetchData()  {
        return getAttributeAsBoolean("autoFetchData");
    }
 

    /**
    * Whether to speed up dynamic styling at the expense of slightly slower drawing. <P> <code>fastCellUpdates</code> speeds up the dynamic styling system used by rollovers, selections, and custom styling that calls {@link com.smartgwt.client.grid.GridRenderer#refreshCellStyle}, at the cost of slightly slower draw() and redraw() times.
    *
    * @param fastCellUpdates fastCellUpdates Default value is false
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setFastCellUpdates(Boolean fastCellUpdates)  throws IllegalStateException {
        setAttribute("fastCellUpdates", fastCellUpdates, false);
    }

    /**
    * Default CSS class
    *
    * @param styleName styleName Default value is "listGrid"
    */
    public void setStyleName(String styleName) {
        setAttribute("styleName", styleName, true);
    }
    /**
     * Default CSS class
     *
     *
     * @return String
     *
     */
    public String getStyleName()  {
        return getAttributeAsString("styleName");
    }

    /**
    * If true, automatically fetches a valueMap if an {@link com.smartgwt.client.widgets.grid.ListGridField#getOptionDataSource optionDataSource} is set for a ListGrid field. <P> If set to false, valueMaps will not be automatically fetched.  In this case, setting field.optionDataSource on a is effectively a shortcut for setting optionDataSource on the editor via ${isc.DocUtils.linkForRef('field.editorProperties')}. <P> Can also be disabled on a per-field basis with {@link com.smartgwt.client.widgets.grid.ListGridField#getAutoFetchDisplayMap autoFetchDisplayMap}.
    *
    * @param autoFetchDisplayMap autoFetchDisplayMap Default value is true
    */
    public void setAutoFetchDisplayMap(Boolean autoFetchDisplayMap) {
        setAttribute("autoFetchDisplayMap", autoFetchDisplayMap, true);
    }
    /**
     * If true, automatically fetches a valueMap if an {@link com.smartgwt.client.widgets.grid.ListGridField#getOptionDataSource optionDataSource} is set for a ListGrid field. <P> If set to false, valueMaps will not be automatically fetched.  In this case, setting field.optionDataSource on a is effectively a shortcut for setting optionDataSource on the editor via ${isc.DocUtils.linkForRef('field.editorProperties')}. <P> Can also be disabled on a per-field basis with {@link com.smartgwt.client.widgets.grid.ListGridField#getAutoFetchDisplayMap autoFetchDisplayMap}.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getAutoFetchDisplayMap()  {
        return getAttributeAsBoolean("autoFetchDisplayMap");
    }

    /**
    * For grids with a specified ${isc.DocUtils.linkForRef('ListGrid.datasource')}, this property can be set to  <code>true</code> to avoid the grid from attempting to save / retrieve data from the server.  In this case the grid's data should be specified as an array via  the {@link com.smartgwt.client.widgets.grid.ListGrid#getData data} attribute, and the datasource will simply act as a schema to describe the set of fields visible in the grid.  {@link com.smartgwt.client.widgets.grid.ListGrid#getCanEdit canEdit}, or removals via the {@link com.smartgwt.client.widgets.grid.ListGrid#getCanRemoveRecords canRemoveRecords} mechanism will update the local data array rather than attempting to perform operations against the dataSource.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param saveLocally saveLocally Default value is null
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setSaveLocally(Boolean saveLocally)  throws IllegalStateException {
        setAttribute("saveLocally", saveLocally, false);
    }
    /**
     * For grids with a specified ${isc.DocUtils.linkForRef('ListGrid.datasource')}, this property can be set to  <code>true</code> to avoid the grid from attempting to save / retrieve data from the server.  In this case the grid's data should be specified as an array via  the {@link com.smartgwt.client.widgets.grid.ListGrid#getData data} attribute, and the datasource will simply act as a schema to describe the set of fields visible in the grid.  {@link com.smartgwt.client.widgets.grid.ListGrid#getCanEdit canEdit}, or removals via the {@link com.smartgwt.client.widgets.grid.ListGrid#getCanRemoveRecords canRemoveRecords} mechanism will update the local data array rather than attempting to perform operations against the dataSource.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getSaveLocally()  {
        return getAttributeAsBoolean("saveLocally");
    }

    /**
    * If true, the set of fields given by the "default binding" (see  {@link com.smartgwt.client..DataBoundComponent#getFields fields}) is used, with any fields specified in <code>component.fields</code> acting as overrides that can suppress or modify the display of individual fields, without having to list the entire set of fields that should be shown. <P> If <code>component.fields</code> contains fields that are not found in the DataSource, they will be shown after the most recently referred to DataSource field.  If the new fields appear first, they will be shown first. <P> ${isc.DocUtils.linkForExampleId('validationFieldBinding', 'This example')} shows a mixture of component fields and DataSource fields, and how they interact for validation.
    *
    * @param useAllDataSourceFields useAllDataSourceFields Default value is null
    */
    public void setUseAllDataSourceFields(Boolean useAllDataSourceFields) {
        setAttribute("useAllDataSourceFields", useAllDataSourceFields, true);
    }
    /**
     * If true, the set of fields given by the "default binding" (see  {@link com.smartgwt.client..DataBoundComponent#getFields fields}) is used, with any fields specified in <code>component.fields</code> acting as overrides that can suppress or modify the display of individual fields, without having to list the entire set of fields that should be shown. <P> If <code>component.fields</code> contains fields that are not found in the DataSource, they will be shown after the most recently referred to DataSource field.  If the new fields appear first, they will be shown first. <P> ${isc.DocUtils.linkForExampleId('validationFieldBinding', 'This example')} shows a mixture of component fields and DataSource fields, and how they interact for validation.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getUseAllDataSourceFields()  {
        return getAttributeAsBoolean("useAllDataSourceFields");
    }

    /**
    * Whether to include fields marked <code>detail:true</code> from this component's  <code>DataSource</code>. <P> Fields may also be included directly in this component's <code>fields</code> array in which case they will be present regardless of the <code>detail</code> attribute. <p> When this property is <code>true</code>, <code>ListGrid</code>s will include all  detail fields, but they will be initially hidden.  The user may show these fields via the default header context menu ({@link com.smartgwt.client.widgets.grid.ListGrid#getShowHeaderContextMenu showHeaderContextMenu}). Setting this property to false will completely exclude all detail fields from the list grid's fields array, such that they cannot be shown by the user or programmatically. <P> To override the visibility of individual fields, use the standard {@link com.smartgwt.client.widgets.grid.ListGrid#showField}, {@link com.smartgwt.client.widgets.grid.ListGrid#hideField} and {@link com.smartgwt.client.widgets.grid.ListGridField#showIf} APIs, for example, set showIf:"true" to show a detail field initially.
    *
    * @param showDetailFields showDetailFields Default value is true
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setShowDetailFields(Boolean showDetailFields)  throws IllegalStateException {
        setAttribute("showDetailFields", showDetailFields, false);
    }
    /**
     * Whether to include fields marked <code>detail:true</code> from this component's  <code>DataSource</code>. <P> Fields may also be included directly in this component's <code>fields</code> array in which case they will be present regardless of the <code>detail</code> attribute. <p> When this property is <code>true</code>, <code>ListGrid</code>s will include all  detail fields, but they will be initially hidden.  The user may show these fields via the default header context menu ({@link com.smartgwt.client.widgets.grid.ListGrid#getShowHeaderContextMenu showHeaderContextMenu}). Setting this property to false will completely exclude all detail fields from the list grid's fields array, such that they cannot be shown by the user or programmatically. <P> To override the visibility of individual fields, use the standard {@link com.smartgwt.client.widgets.grid.ListGrid#showField}, {@link com.smartgwt.client.widgets.grid.ListGrid#hideField} and {@link com.smartgwt.client.widgets.grid.ListGridField#showIf} APIs, for example, set showIf:"true" to show a detail field initially.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getShowDetailFields()  {
        return getAttributeAsBoolean("showDetailFields");
    }

    /**
    * Best field to use for a user-visible title for an individual record from this grid. If {@link com.smartgwt.client.widgets.grid.ListGrid#getDataSource dataSource} is non null, this property may be specified on the  dataSource instead. <p> If not explicitly set, titleField looks for fields named "title", "name", and "id"  in that order.  If a field exists with one of those names, it becomes the titleField.   If not, then the first field is designated as the titleField.
    *
    * @param titleField titleField Default value is see below
    */
    public void setTitleField(String titleField) {
        setAttribute("titleField", titleField, true);
    }
    /**
     * Best field to use for a user-visible title for an individual record from this grid. If {@link com.smartgwt.client.widgets.grid.ListGrid#getDataSource dataSource} is non null, this property may be specified on the  dataSource instead. <p> If not explicitly set, titleField looks for fields named "title", "name", and "id"  in that order.  If a field exists with one of those names, it becomes the titleField.   If not, then the first field is designated as the titleField.
     *
     *
     * @return Method to return the fieldName which represents the "title" for records in this ListGrid.<br> If this.titleField is explicitly specified it will always be used. Otherwise, default implementation will check {@link com.smartgwt.client.data.DataSource#getTitleField titleField} for databound grids.<br> For non dataotherwise returns the first defined field name of <code>"title"</code>,  <code>"name"</code>, or <code>"id"</code>. If we dont find any field-names that match these titles, the first field in the grid will be used instead.
     *
     */
    public String getTitleField()  {
        return getAttributeAsString("titleField");
    }

    /**
    * The CSS style that group rows will have
    *
    * @param groupNodeStyle groupNodeStyle Default value is "groupNode"
    */
    public void setGroupNodeStyle(String groupNodeStyle) {
        setAttribute("groupNodeStyle", groupNodeStyle, true);
    }
    /**
     * The CSS style that group rows will have
     *
     *
     * @return String
     *
     */
    public String getGroupNodeStyle()  {
        return getAttributeAsString("groupNodeStyle");
    }

    /**
    * The URL of the base icon for the group icons in this treegrid.
    *
    * @param groupIcon groupIcon Default value is "[SKINIMG]/TreeGrid/opener.gif"
    */
    public void setGroupIcon(String groupIcon) {
        setAttribute("groupIcon", groupIcon, true);
    }
    /**
     * The URL of the base icon for the group icons in this treegrid.
     *
     *
     * @return String
     *
     */
    public String getGroupIcon()  {
        return getAttributeAsString("groupIcon");
    }

    /**
    * Default width and height of group icons for this ListGrid.
    *
    * @param groupIconSize groupIconSize Default value is 16
    */
    public void setGroupIconSize(int groupIconSize) {
        setAttribute("groupIconSize", groupIconSize, true);
    }
    /**
     * Default width and height of group icons for this ListGrid.
     *
     *
     * @return int
     *
     */
    public int getGroupIconSize()  {
        return getAttributeAsInt("groupIconSize");
    }

    /**
    * Default number of pixels by which to indent subgroups relative to parent group.
    *
    * @param groupIndentSize groupIndentSize Default value is 20
    */
    public void setGroupIndentSize(int groupIndentSize) {
        setAttribute("groupIndentSize", groupIndentSize, true);
    }
    /**
     * Default number of pixels by which to indent subgroups relative to parent group.
     *
     *
     * @return int
     *
     */
    public int getGroupIndentSize()  {
        return getAttributeAsInt("groupIndentSize");
    }

    /**
    * Default number of pixels by which to indent all groups.
    *
    * @param groupLeadingIndent groupLeadingIndent Default value is 20
    */
    public void setGroupLeadingIndent(int groupLeadingIndent) {
        setAttribute("groupLeadingIndent", groupLeadingIndent, true);
    }
    /**
     * Default number of pixels by which to indent all groups.
     *
     *
     * @return int
     *
     */
    public int getGroupLeadingIndent()  {
        return getAttributeAsInt("groupLeadingIndent");
    }

    /**
    * If false, grouping via context menu will be disabled.
    *
    * @param canGroupBy canGroupBy Default value is true
    */
    public void setCanGroupBy(Boolean canGroupBy) {
        setAttribute("canGroupBy", canGroupBy, true);
    }
    /**
     * If false, grouping via context menu will be disabled.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getCanGroupBy()  {
        return getAttributeAsBoolean("canGroupBy");
    }

    /**
    * Maximum number of records to which a groupBy can be applied. If there are more records, grouping will not be available via the default header context menu, and calls to  {@link com.smartgwt.client.widgets.grid.ListGrid#groupBy} will be ignored.
    *
    * @param groupByMaxRecords groupByMaxRecords Default value is 1000
    */
    public void setGroupByMaxRecords(int groupByMaxRecords) {
        setAttribute("groupByMaxRecords", groupByMaxRecords, true);
    }
    /**
     * Maximum number of records to which a groupBy can be applied. If there are more records, grouping will not be available via the default header context menu, and calls to  {@link com.smartgwt.client.widgets.grid.ListGrid#groupBy} will be ignored.
     *
     *
     * @return int
     *
     */
    public int getGroupByMaxRecords()  {
        return getAttributeAsInt("groupByMaxRecords");
    }

    /**
     * True if this listgrid is grouped, false otherwise
     *
     * <b>Note :</b> This method should be called only after the widget has been rendered.
     *
     * @return Boolean
     *
     * @throws IllegalStateException if widget has not yet been rendered.
     */
    public Boolean getIsGrouped() throws IllegalStateException {
        errorIfNotCreated("isGrouped");
        return getAttributeAsBoolean("isGrouped");
    }

    /**
    * Default alias to use for groups with no value
    *
    * @param nullGroupTitle nullGroupTitle Default value is '-none-'
    */
    public void setNullGroupTitle(String nullGroupTitle) {
        setAttribute("nullGroupTitle", nullGroupTitle, true);
    }
    /**
     * Default alias to use for groups with no value
     *
     *
     * @return String
     *
     */
    public String getNullGroupTitle()  {
        return getAttributeAsString("nullGroupTitle");
    }

    /**
    * Default width and height of value icons for this ListGrid. Can be overridden at the listGrid level via explicit {@link com.smartgwt.client.widgets.grid.ListGrid#getValueIconWidth valueIconWidth} and {@link com.smartgwt.client.widgets.grid.ListGrid#getValueIconHeight valueIconHeight}, or at the field level via {@link com.smartgwt.client.widgets.grid.ListGridField#getValueIconSize valueIconSize}, {@link com.smartgwt.client.widgets.grid.ListGridField#getValueIconWidth valueIconWidth} and {ListGridField.valueIconHeight}
    *
    * @param valueIconSize valueIconSize Default value is 16
    */
    public void setValueIconSize(int valueIconSize) {
        setAttribute("valueIconSize", valueIconSize, true);
    }
    /**
     * Default width and height of value icons for this ListGrid. Can be overridden at the listGrid level via explicit {@link com.smartgwt.client.widgets.grid.ListGrid#getValueIconWidth valueIconWidth} and {@link com.smartgwt.client.widgets.grid.ListGrid#getValueIconHeight valueIconHeight}, or at the field level via {@link com.smartgwt.client.widgets.grid.ListGridField#getValueIconSize valueIconSize}, {@link com.smartgwt.client.widgets.grid.ListGridField#getValueIconWidth valueIconWidth} and {ListGridField.valueIconHeight}
     *
     *
     * @return int
     *
     */
    public int getValueIconSize()  {
        return getAttributeAsInt("valueIconSize");
    }

    /**
    * Width for value icons for this listGrid. Overrides {@link com.smartgwt.client.widgets.grid.ListGrid#getValueIconSize valueIconSize}. Can be overridden at the field level
    *
    * @param valueIconWidth valueIconWidth Default value is null
    */
    public void setValueIconWidth(Integer valueIconWidth) {
        setAttribute("valueIconWidth", valueIconWidth, true);
    }
    /**
     * Width for value icons for this listGrid. Overrides {@link com.smartgwt.client.widgets.grid.ListGrid#getValueIconSize valueIconSize}. Can be overridden at the field level
     *
     *
     * @return Integer
     *
     */
    public Integer getValueIconWidth()  {
        return getAttributeAsInt("valueIconWidth");
    }

    /**
    * Height for value icons for this listGrid. Overrides {@link com.smartgwt.client.widgets.grid.ListGrid#getValueIconSize valueIconSize}. Can be overridden at the field level
    *
    * @param valueIconHeight valueIconHeight Default value is null
    */
    public void setValueIconHeight(Integer valueIconHeight) {
        setAttribute("valueIconHeight", valueIconHeight, true);
    }
    /**
     * Height for value icons for this listGrid. Overrides {@link com.smartgwt.client.widgets.grid.ListGrid#getValueIconSize valueIconSize}. Can be overridden at the field level
     *
     *
     * @return Integer
     *
     */
    public Integer getValueIconHeight()  {
        return getAttributeAsInt("valueIconHeight");
    }

    /**
    * How much padding should there be on the left of valueIcons by default Can be overridden at the field level
    *
    * @param valueIconLeftPadding valueIconLeftPadding Default value is 2
    */
    public void setValueIconLeftPadding(int valueIconLeftPadding) {
        setAttribute("valueIconLeftPadding", valueIconLeftPadding, true);
    }
    /**
     * How much padding should there be on the left of valueIcons by default Can be overridden at the field level
     *
     *
     * @return int
     *
     */
    public int getValueIconLeftPadding()  {
        return getAttributeAsInt("valueIconLeftPadding");
    }

    /**
    * How much padding should there be on the right of valueIcons by default
    *
    * @param valueIconRightPadding valueIconRightPadding Default value is 2
    */
    public void setValueIconRightPadding(int valueIconRightPadding) {
        setAttribute("valueIconRightPadding", valueIconRightPadding, true);
    }
    /**
     * How much padding should there be on the right of valueIcons by default
     *
     *
     * @return int
     *
     */
    public int getValueIconRightPadding()  {
        return getAttributeAsInt("valueIconRightPadding");
    }

    /**
    * Default size of thumbnails shown for fieldTypes image and imageFile.  Overrideable on a per-field basis via {@link com.smartgwt.client.widgets.grid.ListGridField#getImageSize imageSize} or {@link com.smartgwt.client.widgets.grid.ListGridField#getImageWidth imageWidth}/{@link com.smartgwt.client.widgets.grid.ListGridField#getImageHeight imageHeight}
    *
    * @param imageSize imageSize Default value is 16
    */
    public void setImageSize(int imageSize) {
        setAttribute("imageSize", imageSize, true);
    }
    /**
     * Default size of thumbnails shown for fieldTypes image and imageFile.  Overrideable on a per-field basis via {@link com.smartgwt.client.widgets.grid.ListGridField#getImageSize imageSize} or {@link com.smartgwt.client.widgets.grid.ListGridField#getImageWidth imageWidth}/{@link com.smartgwt.client.widgets.grid.ListGridField#getImageHeight imageHeight}
     *
     *
     * @return int
     *
     */
    public int getImageSize()  {
        return getAttributeAsInt("imageSize");
    }

    /**
    * Default height for a {@link com.smartgwt.client.widgets.grid.ListGrid#getHeaderSpans headerSpans} with no height specified. <P> If <code>headerSpanHeight</code> is not specified (the default), headerSpans will be 1/2 of {@link com.smartgwt.client.widgets.grid.ListGrid#getHeaderHeight headerHeight}.
    *
    * @param headerSpanHeight headerSpanHeight Default value is null
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setHeaderSpanHeight(Integer headerSpanHeight)  throws IllegalStateException {
        setAttribute("headerSpanHeight", headerSpanHeight, false);
    }
    /**
     * Default height for a {@link com.smartgwt.client.widgets.grid.ListGrid#getHeaderSpans headerSpans} with no height specified. <P> If <code>headerSpanHeight</code> is not specified (the default), headerSpans will be 1/2 of {@link com.smartgwt.client.widgets.grid.ListGrid#getHeaderHeight headerHeight}.
     *
     *
     * @return Integer
     *
     */
    public Integer getHeaderSpanHeight()  {
        return getAttributeAsInt("headerSpanHeight");
    }

    /**
    * When {@link com.smartgwt.client.widgets.grid.ListGrid#getHeaderSpans headerSpans} are in use, whether to show a hierarchical column picker that includes both headerSpans and normal headers, with normal headers indented under headerSpans similarly to how a {@link com.smartgwt.client.widgets.tree.TreeGrid} displays a Tree. <P> If <code>showTreeColumnPicker</code> is false, no column picker will be shown on the headerSpan itself, and the column picker for a clicked on a normal field header will include only normal fields.
    *
    * @param showTreeColumnPicker showTreeColumnPicker Default value is true
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setShowTreeColumnPicker(Boolean showTreeColumnPicker)  throws IllegalStateException {
        setAttribute("showTreeColumnPicker", showTreeColumnPicker, false);
    }
    /**
     * When {@link com.smartgwt.client.widgets.grid.ListGrid#getHeaderSpans headerSpans} are in use, whether to show a hierarchical column picker that includes both headerSpans and normal headers, with normal headers indented under headerSpans similarly to how a {@link com.smartgwt.client.widgets.tree.TreeGrid} displays a Tree. <P> If <code>showTreeColumnPicker</code> is false, no column picker will be shown on the headerSpan itself, and the column picker for a clicked on a normal field header will include only normal fields.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getShowTreeColumnPicker()  {
        return getAttributeAsBoolean("showTreeColumnPicker");
    }

    /**
    * If this property is true, any mouse click outside of the open cell editors      will end editing mode, hiding the cell editors and saving any changes to those      cell values.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param modalEditing modalEditing Default value is null
    */
    public void setModalEditing(Boolean modalEditing) {
        setAttribute("modalEditing", modalEditing, true);
    }
    /**
     * If this property is true, any mouse click outside of the open cell editors      will end editing mode, hiding the cell editors and saving any changes to those      cell values.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getModalEditing()  {
        return getAttributeAsBoolean("modalEditing");
    }

    /**
    * If we're showing the filterEditor (+link(listGrid.showFilterEditor) is true), and we're re-filtering on every keypress (+link(listGrid.filterOnKeypress) is true), this  property is the delay in milliseconds between the user changing the filter and the  filter request being kicked off. If multiple changes are made to the filter  within this fetch delay, only the most recent will actually cause a re-filter
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param fetchDelay fetchDelay Default value is 300
    */
    public void setFetchDelay(int fetchDelay) {
        setAttribute("fetchDelay", fetchDelay, true);
    }
    /**
     * If we're showing the filterEditor (+link(listGrid.showFilterEditor) is true), and we're re-filtering on every keypress (+link(listGrid.filterOnKeypress) is true), this  property is the delay in milliseconds between the user changing the filter and the  filter request being kicked off. If multiple changes are made to the filter  within this fetch delay, only the most recent will actually cause a re-filter
     *
     *
     * @return int
     *
     */
    public int getFetchDelay()  {
        return getAttributeAsInt("fetchDelay");
    }

    /**
    * Whether all rows should be drawn all at once, or only rows visible in the viewport.<br><br> Drawing all rows causes longer initial rendering time, but allows smoother vertical scrolling. With a very large number of rows, showAllRows will become too slow.
    *
    * @param showAllRecords showAllRecords Default value is false
    */
    public void setShowAllRecords(Boolean showAllRecords) {
        setAttribute("showAllRecords", showAllRecords, true);
    }
    /**
     * Whether all rows should be drawn all at once, or only rows visible in the viewport.<br><br> Drawing all rows causes longer initial rendering time, but allows smoother vertical scrolling. With a very large number of rows, showAllRows will become too slow.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getShowAllRecords()  {
        return getAttributeAsBoolean("showAllRecords");
    }

    /**
    * If drawing all rows would cause less than <code>drawAllMaxCells</code> cells to be rendered, the full dataset will instead be drawn even if {@link com.smartgwt.client.widgets.grid.ListGrid#getShowAllRecords showAllRecords} is false and the viewport size and {@link com.smartgwt.client.widgets.grid.ListGrid#getDrawAheadRatio drawAheadRatio} setting would normally have caused incremental rendering to be used. <P> The <code>drawAllMaxCells</code> setting prevents incremental rendering from being used in situations where it's really unnecessary, such as a 40 row, 5 column dataset (only 200 cells) which happens to be in a grid with a viewport showing only 20 or so rows. Incremental rendering causes a brief "flash" during scrolling as the visible portion of the dataset is redrawn, and a better scrolling experience can be obtained in this situation by drawing the entire dataset up front, which in this example would have neglible effect on initial draw time. <P> <code>drawAllMaxCells:0</code> disables this features.  You may want to disable this feature if performance is an issue and: <ul> <li> you are very frequently redraw a grid <li> you do a lot of computation when rendering each cell (eg formulas) <li> you are showing many grids on one screen and the user won't scroll most of them </ul>
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param drawAllMaxCells drawAllMaxCells Default value is 250
    */
    public void setDrawAllMaxCells(int drawAllMaxCells) {
        setAttribute("drawAllMaxCells", drawAllMaxCells, true);
    }
    /**
     * If drawing all rows would cause less than <code>drawAllMaxCells</code> cells to be rendered, the full dataset will instead be drawn even if {@link com.smartgwt.client.widgets.grid.ListGrid#getShowAllRecords showAllRecords} is false and the viewport size and {@link com.smartgwt.client.widgets.grid.ListGrid#getDrawAheadRatio drawAheadRatio} setting would normally have caused incremental rendering to be used. <P> The <code>drawAllMaxCells</code> setting prevents incremental rendering from being used in situations where it's really unnecessary, such as a 40 row, 5 column dataset (only 200 cells) which happens to be in a grid with a viewport showing only 20 or so rows. Incremental rendering causes a brief "flash" during scrolling as the visible portion of the dataset is redrawn, and a better scrolling experience can be obtained in this situation by drawing the entire dataset up front, which in this example would have neglible effect on initial draw time. <P> <code>drawAllMaxCells:0</code> disables this features.  You may want to disable this feature if performance is an issue and: <ul> <li> you are very frequently redraw a grid <li> you do a lot of computation when rendering each cell (eg formulas) <li> you are showing many grids on one screen and the user won't scroll most of them </ul>
     *
     *
     * @return int
     *
     */
    public int getDrawAllMaxCells()  {
        return getAttributeAsInt("drawAllMaxCells");
    }

    /**
    * How far should we render rows ahead of the currently visible area?  This is expressed as a ratio from viewport size to rendered area size.<br><br>  Tweaking drawAheadRatio allows you to make tradeoffs between continuous scrolling speed vs initial render time and render time when scrolling by large amounts.<br><br> NOTE: Only applies when showAllRows is false.
    *
    * @param drawAheadRatio drawAheadRatio Default value is 1.3
    */
    public void setDrawAheadRatio(float drawAheadRatio) {
        setAttribute("drawAheadRatio", drawAheadRatio, true);
    }
    /**
     * How far should we render rows ahead of the currently visible area?  This is expressed as a ratio from viewport size to rendered area size.<br><br>  Tweaking drawAheadRatio allows you to make tradeoffs between continuous scrolling speed vs initial render time and render time when scrolling by large amounts.<br><br> NOTE: Only applies when showAllRows is false.
     *
     *
     * @return float
     *
     */
    public float getDrawAheadRatio()  {
        return getAttributeAsFloat("drawAheadRatio");
    }

    /**
    * Alternative to {@link com.smartgwt.client.widgets.grid.ListGrid#getDrawAheadRatio drawAheadRatio}, to be used when the user is rapidly changing the grids viewport (for example drag scrolling through the grid). If unspecified {@link com.smartgwt.client.widgets.grid.ListGrid#getDrawAheadRatio drawAheadRatio} will be used in all cases
    *
    * @param quickDrawAheadRatio quickDrawAheadRatio Default value is 1.3
    */
    public void setQuickDrawAheadRatio(float quickDrawAheadRatio) {
        setAttribute("quickDrawAheadRatio", quickDrawAheadRatio, true);
    }
    /**
     * Alternative to {@link com.smartgwt.client.widgets.grid.ListGrid#getDrawAheadRatio drawAheadRatio}, to be used when the user is rapidly changing the grids viewport (for example drag scrolling through the grid). If unspecified {@link com.smartgwt.client.widgets.grid.ListGrid#getDrawAheadRatio drawAheadRatio} will be used in all cases
     *
     *
     * @return float
     *
     */
    public float getQuickDrawAheadRatio()  {
        return getAttributeAsFloat("quickDrawAheadRatio");
    }

    /**
    * While drag scrolling in an incrementally rendered grid, time in milliseconds to wait before redrawing, after the last mouse movement by the user.
    *
    * @param scrollRedrawDelay scrollRedrawDelay Default value is 75
    */
    public void setScrollRedrawDelay(int scrollRedrawDelay) {
        setAttribute("scrollRedrawDelay", scrollRedrawDelay, true);
    }
    /**
     * While drag scrolling in an incrementally rendered grid, time in milliseconds to wait before redrawing, after the last mouse movement by the user.
     *
     *
     * @return int
     *
     */
    public int getScrollRedrawDelay()  {
        return getAttributeAsInt("scrollRedrawDelay");
    }

    /**
    * When using data paging, how many records to fetch at a time.  The value of this attribute is passed on to the auto-constructed {@link com.smartgwt.client.data.ResultSet} object for this component.  In effect, this gives you control over the {@link com.smartgwt.client.data.ResultSet#getResultSize resultSize} attribute for this component.
    *
    * @param dataPageSize dataPageSize Default value is 75
    */
    public void setDataPageSize(int dataPageSize) {
        setAttribute("dataPageSize", dataPageSize, true);
    }
    /**
     * When using data paging, how many records to fetch at a time.  The value of this attribute is passed on to the auto-constructed {@link com.smartgwt.client.data.ResultSet} object for this component.  In effect, this gives you control over the {@link com.smartgwt.client.data.ResultSet#getResultSize resultSize} attribute for this component.
     *
     *
     * @return int
     *
     */
    public int getDataPageSize()  {
        return getAttributeAsInt("dataPageSize");
    }
             
    /**
    * Overflow setting for the "body", that is, the area of the grid where data values are rendered. <P> By setting both the grid itself and the body to overflow:visible, it is possible to "auto-fit" to the rendered height or width of the rows.  Note that in this case <code>grid.width</code> and <code>grid.height</code> act as minimums.
    * Update the {@link com.smartgwt.client.widgets.grid.ListGrid#getBodyOverflow bodyOverflow} for this listGrid.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param bodyOverflow new overflow setting for the body. Default value is Canvas.AUTO
    */
    public void setBodyOverflow(Overflow bodyOverflow) {
        setAttribute("bodyOverflow", bodyOverflow.getValue(), true);
    }
    /**
     * Overflow setting for the "body", that is, the area of the grid where data values are rendered. <P> By setting both the grid itself and the body to overflow:visible, it is possible to "auto-fit" to the rendered height or width of the rows.  Note that in this case <code>grid.width</code> and <code>grid.height</code> act as minimums.
     *
     *
     * @return Overflow
     *
     */
    public Overflow getBodyOverflow()  {
        return (Overflow) EnumUtil.getEnum(Overflow.values(), getAttribute("bodyOverflow"));
    }

    /**
    * Background color applied to the ListGrid body (that is, the area of the grid where data values are rendered).<br> Note that this will typically not be visible to the user unless there are few enough rows that there is visible space in the body below the last row. To style data cells, override {@link com.smartgwt.client.widgets.grid.ListGrid#getBaseStyle baseStyle} instead.
    *
    * @param bodyBackgroundColor bodyBackgroundColor Default value is "white"
    */
    public void setBodyBackgroundColor(String bodyBackgroundColor) {
        setAttribute("bodyBackgroundColor", bodyBackgroundColor, true);
    }
    /**
     * Background color applied to the ListGrid body (that is, the area of the grid where data values are rendered).<br> Note that this will typically not be visible to the user unless there are few enough rows that there is visible space in the body below the last row. To style data cells, override {@link com.smartgwt.client.widgets.grid.ListGrid#getBaseStyle baseStyle} instead.
     *
     *
     * @return String
     *
     */
    public String getBodyBackgroundColor()  {
        return getAttributeAsString("bodyBackgroundColor");
    }

    /**
    * CSS style used for the body of this grid.  If applying a background-color to the body via a CSS style applied using this property, be sure to set  {@link com.smartgwt.client.widgets.grid.ListGrid#getBodyBackgroundColor bodyBackgroundColor} to <code>null</code>.
    * Update the {@link com.smartgwt.client.widgets.grid.ListGrid#getBodyStyleName bodyStyleName} for this listGrid.
    *
    * @param bodyStyleName new body style name. Default value is null
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setBodyStyleName(String bodyStyleName)  throws IllegalStateException {
        setAttribute("bodyStyleName", bodyStyleName, false);
    }
    /**
     * CSS style used for the body of this grid.  If applying a background-color to the body via a CSS style applied using this property, be sure to set  {@link com.smartgwt.client.widgets.grid.ListGrid#getBodyBackgroundColor bodyBackgroundColor} to <code>null</code>.
     *
     *
     * @return String
     *
     */
    public String getBodyStyleName()  {
        return getAttributeAsString("bodyStyleName");
    }

    /**
    * The value to display for cells whose value is null or the empty string after applying formatCellValue and valueMap (if any). <p> This is the grid-wide attribute.  You may also set the emptyCellValue on a per-field basis.
    *
    * @param emptyCellValue emptyCellValue Default value is "&nbsp;"
    */
    public void setEmptyCellValue(String emptyCellValue) {
        setAttribute("emptyCellValue", emptyCellValue, true);
    }
    /**
     * The value to display for cells whose value is null or the empty string after applying formatCellValue and valueMap (if any). <p> This is the grid-wide attribute.  You may also set the emptyCellValue on a per-field basis.
     *
     *
     * @return String
     *
     */
    public String getEmptyCellValue()  {
        return getAttributeAsString("emptyCellValue");
    }

    /**
    * The default height of each row in pixels.
    *
    * @param cellHeight cellHeight Default value is 20
    */
    public void setCellHeight(int cellHeight) {
        setAttribute("cellHeight", cellHeight, true);
    }
    /**
     * The default height of each row in pixels.
     *
     *
     * @return int
     *
     */
    public int getCellHeight()  {
        return getAttributeAsInt("cellHeight");
    }

    /**
    * Should we vertically clip cell contents, or allow rows to expand vertically to show all contents? <P> If we allow rows to expand, the row height as derived from {@link com.smartgwt.client.grid.GridRenderer#getRowHeight} or the default {@link com.smartgwt.client.widgets.grid.ListGrid#getCellHeight cellHeight} is treated as a minimum.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param fixedRecordHeights fixedRecordHeights Default value is true
    */
    public void setFixedRecordHeights(Boolean fixedRecordHeights) {
        setAttribute("fixedRecordHeights", fixedRecordHeights, true);
    }
    /**
     * Should we vertically clip cell contents, or allow rows to expand vertically to show all contents? <P> If we allow rows to expand, the row height as derived from {@link com.smartgwt.client.grid.GridRenderer#getRowHeight} or the default {@link com.smartgwt.client.widgets.grid.ListGrid#getCellHeight cellHeight} is treated as a minimum.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getFixedRecordHeights()  {
        return getAttributeAsBoolean("fixedRecordHeights");
    }

    /**
    * If {@link com.smartgwt.client.widgets.grid.ListGrid#getAutoFitData autoFitData} is set to <code>"vertical"</code> or <code>"both"</code> this property provides an upper limit on how far the ListGrid will expand vertically to accomodate its content. If content exceeds this height, scrollbars will be introduced as usual.   In addition to this property, {@link com.smartgwt.client.widgets.grid.ListGrid#getAutoFitMaxRecords autoFitMaxRecords} allows you to limit vertical expansion based on the number of rows to be rendered.
    * Setter for {@link com.smartgwt.client.widgets.grid.ListGrid#getAutoFitMaxHeight autoFitMaxHeight}.
    *
    * @param autoFitMaxHeight Maximum height in px we'll expand to accomodate if  {@link com.smartgwt.client.widgets.grid.ListGrid#getAutoFitData autoFitData} is enabled vertically.. Default value is null
    */
    public void setAutoFitMaxHeight(Integer autoFitMaxHeight) {
        setAttribute("autoFitMaxHeight", autoFitMaxHeight, true);
    }
    /**
     * If {@link com.smartgwt.client.widgets.grid.ListGrid#getAutoFitData autoFitData} is set to <code>"vertical"</code> or <code>"both"</code> this property provides an upper limit on how far the ListGrid will expand vertically to accomodate its content. If content exceeds this height, scrollbars will be introduced as usual.   In addition to this property, {@link com.smartgwt.client.widgets.grid.ListGrid#getAutoFitMaxRecords autoFitMaxRecords} allows you to limit vertical expansion based on the number of rows to be rendered.
     *
     *
     * @return Integer
     *
     */
    public Integer getAutoFitMaxHeight()  {
        return getAttributeAsInt("autoFitMaxHeight");
    }

    /**
    * if {@link com.smartgwt.client.widgets.grid.ListGrid#getAutoFitData autoFitData} is set to <code>"vertical"</code> or <code>"both"</code> this property provides the maximum number of records for which the ListGrid will expand. If more records are present, scrolling will be introduced to reach them as normal. If unset, by default the ListGrid will expand to accomodate as many records as are present.
    * Setter for {@link com.smartgwt.client.widgets.grid.ListGrid#getAutoFitMaxRecords autoFitMaxRecords}.
    *
    * @param autoFitMaxRecords Maximum number of rows we'll expand to accomodate if  {@link com.smartgwt.client.widgets.grid.ListGrid#getAutoFitData autoFitData} is enabled vertically.. Default value is 50
    */
    public void setAutoFitMaxRecords(int autoFitMaxRecords) {
        setAttribute("autoFitMaxRecords", autoFitMaxRecords, true);
    }
    /**
     * if {@link com.smartgwt.client.widgets.grid.ListGrid#getAutoFitData autoFitData} is set to <code>"vertical"</code> or <code>"both"</code> this property provides the maximum number of records for which the ListGrid will expand. If more records are present, scrolling will be introduced to reach them as normal. If unset, by default the ListGrid will expand to accomodate as many records as are present.
     *
     *
     * @return int
     *
     */
    public int getAutoFitMaxRecords()  {
        return getAttributeAsInt("autoFitMaxRecords");
    }

    /**
    * If {@link com.smartgwt.client.widgets.grid.ListGrid#getAutoFitData autoFitData} is set to <code>"horizontal"</code> or <code>"both"</code> this property provides an upper limit on how far the ListGrid will expand horizontally to accomodate its content.  If content exceeds this width, scrollbars will be introduced as usual.   In addition to this property, {@link com.smartgwt.client.widgets.grid.ListGrid#getAutoFitMaxColumns autoFitMaxColumns} allows you to limit  horizontal expansion based on the number of columns to be rendered.
    * Setter for {@link com.smartgwt.client.widgets.grid.ListGrid#getAutoFitMaxWidth autoFitMaxWidth}.
    *
    * @param autoFitMaxWidth Width in px we'll expand to accomodate if  {@link com.smartgwt.client.widgets.grid.ListGrid#getAutoFitData autoFitData} is enabled horizontally.. Default value is null
    */
    public void setAutoFitMaxWidth(Integer autoFitMaxWidth) {
        setAttribute("autoFitMaxWidth", autoFitMaxWidth, true);
    }
    /**
     * If {@link com.smartgwt.client.widgets.grid.ListGrid#getAutoFitData autoFitData} is set to <code>"horizontal"</code> or <code>"both"</code> this property provides an upper limit on how far the ListGrid will expand horizontally to accomodate its content.  If content exceeds this width, scrollbars will be introduced as usual.   In addition to this property, {@link com.smartgwt.client.widgets.grid.ListGrid#getAutoFitMaxColumns autoFitMaxColumns} allows you to limit  horizontal expansion based on the number of columns to be rendered.
     *
     *
     * @return Integer
     *
     */
    public Integer getAutoFitMaxWidth()  {
        return getAttributeAsInt("autoFitMaxWidth");
    }

    /**
    * if {@link com.smartgwt.client.widgets.grid.ListGrid#getAutoFitData autoFitData} is set to <code>"horizontal"</code> or <code>"both"</code> this property provides the maximum number of columns for which the ListGrid will expand. If more columns are present, scrolling will be introduced to reach them as normal. If unset the ListGrid will expand to accomodate as many columns as are defined for the grid.
    * Setter for {@link com.smartgwt.client.widgets.grid.ListGrid#getAutoFitMaxColumns autoFitMaxColumns}.
    *
    * @param autoFitMaxColumns Maximum number of fields we'll expand to accomodate if  {@link com.smartgwt.client.widgets.grid.ListGrid#getAutoFitData autoFitData} is enabled horizontally.. Default value is 50
    */
    public void setAutoFitMaxColumns(int autoFitMaxColumns) {
        setAttribute("autoFitMaxColumns", autoFitMaxColumns, true);
    }
    /**
     * if {@link com.smartgwt.client.widgets.grid.ListGrid#getAutoFitData autoFitData} is set to <code>"horizontal"</code> or <code>"both"</code> this property provides the maximum number of columns for which the ListGrid will expand. If more columns are present, scrolling will be introduced to reach them as normal. If unset the ListGrid will expand to accomodate as many columns as are defined for the grid.
     *
     *
     * @return int
     *
     */
    public int getAutoFitMaxColumns()  {
        return getAttributeAsInt("autoFitMaxColumns");
    }

    /**
    * Whether to leave a gap for the vertical scrollbar, even when it's not present. <P> Note that if leaveScrollbarGap is false and vertical scrolling is introduced, fields will be resized to fit the smaller body area if possible, in order to avoid horizontal scrolling also being required.
    *
    * @param leaveScrollbarGap leaveScrollbarGap Default value is true
    */
    public void setLeaveScrollbarGap(Boolean leaveScrollbarGap) {
        setAttribute("leaveScrollbarGap", leaveScrollbarGap, true);
    }
    /**
     * Whether to leave a gap for the vertical scrollbar, even when it's not present. <P> Note that if leaveScrollbarGap is false and vertical scrolling is introduced, fields will be resized to fit the smaller body area if possible, in order to avoid horizontal scrolling also being required.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getLeaveScrollbarGap()  {
        return getAttributeAsBoolean("leaveScrollbarGap");
    }

    /**
    * Should content within cells be allowed to wrap?
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param wrapCells wrapCells Default value is false
    */
    public void setWrapCells(Boolean wrapCells) {
        setAttribute("wrapCells", wrapCells, true);
    }
    /**
     * Should content within cells be allowed to wrap?
     *
     *
     * @return Boolean
     *
     */
    public Boolean getWrapCells()  {
        return getAttributeAsBoolean("wrapCells");
    }

    /**
    * The amount of empty space, in pixels, surrounding each value in its cell.
    *
    * @param cellPadding cellPadding Default value is 2
    */
    public void setCellPadding(int cellPadding) {
        setAttribute("cellPadding", cellPadding, true);
    }
    /**
     * The amount of empty space, in pixels, surrounding each value in its cell.
     *
     *
     * @return int
     *
     */
    public int getCellPadding()  {
        return getAttributeAsInt("cellPadding");
    }
             
    /**
    * Display format to use for fields specified as type 'date'.  Default is to use the system-wide default short date format, configured via {@link com.smartgwt.client..Date#setShortDisplayFormat}.  Specify any valid ${isc.DocUtils.linkForRef('type:DateDisplayFormat')}, or function to change the display format for dates used by this grid. If specified as  a function, this function will be executed in the scope of the Date and should return the formatted string.<br> May also be specified at the field level via {@link com.smartgwt.client.widgets.grid.ListGridField#getDisplayFormat displayFormat}.<br> If this field is editable the dateFormatter will also be passed to the editor created to edit this field as {@link com.smartgwt.client.widgets.form.fields.DateItem#getDisplayFormat displayFormat}. In this case you may also need to set {@link com.smartgwt.client.widgets.grid.ListGrid#getDateInputFormat dateInputFormat}.
    *
    * @param dateFormatter dateFormatter Default value is null
    */
    public void setDateFormatter(DateDisplayFormat dateFormatter) {
        setAttribute("dateFormatter", dateFormatter.getValue(), true);
    }
    /**
     * Display format to use for fields specified as type 'date'.  Default is to use the system-wide default short date format, configured via {@link com.smartgwt.client..Date#setShortDisplayFormat}.  Specify any valid ${isc.DocUtils.linkForRef('type:DateDisplayFormat')}, or function to change the display format for dates used by this grid. If specified as  a function, this function will be executed in the scope of the Date and should return the formatted string.<br> May also be specified at the field level via {@link com.smartgwt.client.widgets.grid.ListGridField#getDisplayFormat displayFormat}.<br> If this field is editable the dateFormatter will also be passed to the editor created to edit this field as {@link com.smartgwt.client.widgets.form.fields.DateItem#getDisplayFormat displayFormat}. In this case you may also need to set {@link com.smartgwt.client.widgets.grid.ListGrid#getDateInputFormat dateInputFormat}.
     *
     *
     * @return DateDisplayFormat
     *
     */
    public DateDisplayFormat getDateFormatter()  {
        return (DateDisplayFormat) EnumUtil.getEnum(DateDisplayFormat.values(), getAttribute("dateFormatter"));
    }

    /**
    * Property name on a record that will hold the link text for that record. <br> This property is configurable to avoid possible collision with data values in the record.
    *
    * @param linkTextProperty linkTextProperty Default value is "linkText"
    */
    public void setLinkTextProperty(String linkTextProperty) {
        setAttribute("linkTextProperty", linkTextProperty, true);
    }
    /**
     * Property name on a record that will hold the link text for that record. <br> This property is configurable to avoid possible collision with data values in the record.
     *
     *
     * @return String
     *
     */
    public String getLinkTextProperty()  {
        return getAttributeAsString("linkTextProperty");
    }

    /**
    * A base name for the CSS class applied to cells when editing has failed.<br>  If this listGrid is editable, this style will be applied to any edited cells for which  validation failed.<br>  As with the default 'baseStyle' property, this style will have "Dark", "Over", "Selected",   or "Disabled" appended to it according to the state of the cell.<br> If null, cells for which editing has failed will be rendered using the normal base style classNames, but with custom CSSText applied as derived from <code>this.editFailedCSSText</code>
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param editFailedBaseStyle editFailedBaseStyle Default value is null
    */
    public void setEditFailedBaseStyle(String editFailedBaseStyle) {
        setAttribute("editFailedBaseStyle", editFailedBaseStyle, true);
    }
    /**
     * A base name for the CSS class applied to cells when editing has failed.<br>  If this listGrid is editable, this style will be applied to any edited cells for which  validation failed.<br>  As with the default 'baseStyle' property, this style will have "Dark", "Over", "Selected",   or "Disabled" appended to it according to the state of the cell.<br> If null, cells for which editing has failed will be rendered using the normal base style classNames, but with custom CSSText applied as derived from <code>this.editFailedCSSText</code>
     *
     *
     * @return String
     *
     */
    public String getEditFailedBaseStyle()  {
        return getAttributeAsString("editFailedBaseStyle");
    }

    /**
    * Custom CSS text to be applied to cells when editing has failed.<br>  If this listGrid is editable, this css text will be applied to any edited cells for which  validation failed, on top of the base style for the cell.<br> For further customization of styling for cells that failed editing validation, use <code>this.editFailedBaseStyle</code> instead.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param editFailedCSSText editFailedCSSText Default value is "color:red;border:1px solid red;"
    */
    public void setEditFailedCSSText(String editFailedCSSText) {
        setAttribute("editFailedCSSText", editFailedCSSText, true);
    }
    /**
     * Custom CSS text to be applied to cells when editing has failed.<br>  If this listGrid is editable, this css text will be applied to any edited cells for which  validation failed, on top of the base style for the cell.<br> For further customization of styling for cells that failed editing validation, use <code>this.editFailedBaseStyle</code> instead.
     *
     *
     * @return String
     *
     */
    public String getEditFailedCSSText()  {
        return getAttributeAsString("editFailedCSSText");
    }

    /**
     * A base name for the CSS class applied to cells containing pending (unsaved) edits<br>  As with the default 'baseStyle' property, this style will have "Dark", "Over", "Selected",   or "Disabled" appended to it according to the state of the cell.  If this property is null, cells with pending edits will pick up custom css text to  be applied on top of the normal base style from <code>this.editPendingCSSText</code>
     *
     * <b>Note :</b> This method should be called only after the widget has been rendered.
     *
     * @return String
     *
     * @throws IllegalStateException if widget has not yet been rendered.
     */
    public String getEditPendingBaseStyle() throws IllegalStateException {
        errorIfNotCreated("editPendingBaseStyle");
        return getAttributeAsString("editPendingBaseStyle");
    }

    /**
    * Custom CSS text to be applied to cells with pending edits that have not yet been  submitted.<br> For further customization of styling for cells with pending edits use <code>this.editPendingBaseStyle</code> instead.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param editPendingCSSText editPendingCSSText Default value is "border:color:#0066CC;"
    */
    public void setEditPendingCSSText(String editPendingCSSText) {
        setAttribute("editPendingCSSText", editPendingCSSText, true);
    }
    /**
     * Custom CSS text to be applied to cells with pending edits that have not yet been  submitted.<br> For further customization of styling for cells with pending edits use <code>this.editPendingBaseStyle</code> instead.
     *
     *
     * @return String
     *
     */
    public String getEditPendingCSSText()  {
        return getAttributeAsString("editPendingCSSText");
    }

    /**
    * This attribute allows custom base styles to be displayed on a per-record basis. To specify a custom base-style for some record set  <code>record[listGrid.recordBaseStyleProperty]</code> to the desired base style name -  for example if <code>recordBaseStyleProperty</code> is <code>"_baseStyle"</code>, set <code>record._baseStyle</code> to the custom base style name.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param recordBaseStyleProperty recordBaseStyleProperty Default value is "_baseStyle"
    */
    public void setRecordBaseStyleProperty(String recordBaseStyleProperty) {
        setAttribute("recordBaseStyleProperty", recordBaseStyleProperty, true);
    }
    /**
     * This attribute allows custom base styles to be displayed on a per-record basis. To specify a custom base-style for some record set  <code>record[listGrid.recordBaseStyleProperty]</code> to the desired base style name -  for example if <code>recordBaseStyleProperty</code> is <code>"_baseStyle"</code>, set <code>record._baseStyle</code> to the custom base style name.
     *
     *
     * @return String
     *
     */
    public String getRecordBaseStyleProperty()  {
        return getAttributeAsString("recordBaseStyleProperty");
    }

    /**
    * If this listGrid contains any frozen fields, this property can be used to apply a custom baseStyle to all cells in those frozen fields. If unset, the standard base style will be used for both frozen and unfrozen cells.
    *
    * @param frozenBaseStyle frozenBaseStyle Default value is null
    */
    public void setFrozenBaseStyle(String frozenBaseStyle) {
        setAttribute("frozenBaseStyle", frozenBaseStyle, true);
    }
    /**
     * If this listGrid contains any frozen fields, this property can be used to apply a custom baseStyle to all cells in those frozen fields. If unset, the standard base style will be used for both frozen and unfrozen cells.
     *
     *
     * @return String
     *
     */
    public String getFrozenBaseStyle()  {
        return getAttributeAsString("frozenBaseStyle");
    }

    /**
    * If this list grid is showing any {@link com.smartgwt.client.widgets.grid.ListGridField#getFrozen frozen} fields, and a horizontal scrollbar is visible at the bottom of the liquid columns, should an equivalent scrollbar gap be left visible below the frozen columns?<br> Note that if set to <code>true</code> any backgroundColor or border applied to the ListGrid will show up below the bottom row of the frozen column(s).
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param shrinkForFreeze shrinkForFreeze Default value is false
    */
    public void setShrinkForFreeze(Boolean shrinkForFreeze) {
        setAttribute("shrinkForFreeze", shrinkForFreeze, true);
    }
    /**
     * If this list grid is showing any {@link com.smartgwt.client.widgets.grid.ListGridField#getFrozen frozen} fields, and a horizontal scrollbar is visible at the bottom of the liquid columns, should an equivalent scrollbar gap be left visible below the frozen columns?<br> Note that if set to <code>true</code> any backgroundColor or border applied to the ListGrid will show up below the bottom row of the frozen column(s).
     *
     *
     * @return Boolean
     *
     */
    public Boolean getShrinkForFreeze()  {
        return getAttributeAsBoolean("shrinkForFreeze");
    }

    /**
    * Whether alternating rows should be drawn in alternating styles, in order to create a "ledger" effect for easier reading.  If enabled, the cell style for alternate rows will have "Dark" appended to it.
    * Setter for {@link com.smartgwt.client.widgets.grid.ListGrid#getAlternateRecordStyles alternateRecordStyles}
    *
    * @param alternateRecordStyles New value for <code>this.alternateRecordStyles</code>. Default value is false
    */
    public void setAlternateRecordStyles(Boolean alternateRecordStyles) {
        setAttribute("alternateRecordStyles", alternateRecordStyles, true);
    }
    /**
     * Whether alternating rows should be drawn in alternating styles, in order to create a "ledger" effect for easier reading.  If enabled, the cell style for alternate rows will have "Dark" appended to it.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getAlternateRecordStyles()  {
        return getAttributeAsBoolean("alternateRecordStyles");
    }

    /**
    * Optional css style to apply to the body if {@link com.smartgwt.client.widgets.grid.ListGrid#getAlternateRecordStyles alternateRecordStyles} is true  for this grid. If unset {@link com.smartgwt.client.widgets.grid.ListGrid#getBodyStyleName bodyStyleName} will be used to style the body regardless of the {@link com.smartgwt.client.widgets.grid.ListGrid#getAlternateRecordStyles alternateRecordStyles} setting.
    * Update the {@link com.smartgwt.client.widgets.grid.ListGrid#getAlternateBodyStyleName alternateBodyStyleName} for this listGrid.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param alternateBodyStyleName new body style name when showing alternateRecordStyles. Default value is null
    */
    public void setAlternateBodyStyleName(String alternateBodyStyleName) {
        setAttribute("alternateBodyStyleName", alternateBodyStyleName, true);
    }
    /**
     * Optional css style to apply to the body if {@link com.smartgwt.client.widgets.grid.ListGrid#getAlternateRecordStyles alternateRecordStyles} is true  for this grid. If unset {@link com.smartgwt.client.widgets.grid.ListGrid#getBodyStyleName bodyStyleName} will be used to style the body regardless of the {@link com.smartgwt.client.widgets.grid.ListGrid#getAlternateRecordStyles alternateRecordStyles} setting.
     *
     *
     * @return String
     *
     */
    public String getAlternateBodyStyleName()  {
        return getAttributeAsString("alternateBodyStyleName");
    }

    /**
    * The number of consecutive rows to draw in the same style before alternating, when alternateRowStyles is true.
    *
    * @param alternateRecordFrequency alternateRecordFrequency Default value is 1
    */
    public void setAlternateRecordFrequency(int alternateRecordFrequency) {
        setAttribute("alternateRecordFrequency", alternateRecordFrequency, true);
    }
    /**
     * The number of consecutive rows to draw in the same style before alternating, when alternateRowStyles is true.
     *
     *
     * @return int
     *
     */
    public int getAlternateRecordFrequency()  {
        return getAttributeAsInt("alternateRecordFrequency");
    }

    /**
    * If true, when the user navigates to a cell using arrow keys and hits space,  the cell will respond to a click event.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param generateClickOnSpace generateClickOnSpace Default value is true
    */
    public void setGenerateClickOnSpace(Boolean generateClickOnSpace) {
        setAttribute("generateClickOnSpace", generateClickOnSpace, true);
    }
    /**
     * If true, when the user navigates to a cell using arrow keys and hits space,  the cell will respond to a click event.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getGenerateClickOnSpace()  {
        return getAttributeAsBoolean("generateClickOnSpace");
    }

    /**
    * If true, when the user navigates to a cell using arrow keys and hits Enter,  the cell will respond to a click event.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param generateClickOnEnter generateClickOnEnter Default value is false
    */
    public void setGenerateClickOnEnter(Boolean generateClickOnEnter) {
        setAttribute("generateClickOnEnter", generateClickOnEnter, true);
    }
    /**
     * If true, when the user navigates to a cell using arrow keys and hits Enter,  the cell will respond to a click event.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getGenerateClickOnEnter()  {
        return getAttributeAsBoolean("generateClickOnEnter");
    }

    /**
    * If true, when the user navigates to a cell using arrow keys and hits Space,  the cell will respond to a double click event.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param generateDoubleClickOnSpace generateDoubleClickOnSpace Default value is false
    */
    public void setGenerateDoubleClickOnSpace(Boolean generateDoubleClickOnSpace) {
        setAttribute("generateDoubleClickOnSpace", generateDoubleClickOnSpace, true);
    }
    /**
     * If true, when the user navigates to a cell using arrow keys and hits Space,  the cell will respond to a double click event.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getGenerateDoubleClickOnSpace()  {
        return getAttributeAsBoolean("generateDoubleClickOnSpace");
    }

    /**
    * If true, when the user navigates to a cell using arrow keys and hits Enter,  the cell will respond to a double click event.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param generateDoubleClickOnEnter generateDoubleClickOnEnter Default value is true
    */
    public void setGenerateDoubleClickOnEnter(Boolean generateDoubleClickOnEnter) {
        setAttribute("generateDoubleClickOnEnter", generateDoubleClickOnEnter, true);
    }
    /**
     * If true, when the user navigates to a cell using arrow keys and hits Enter,  the cell will respond to a double click event.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getGenerateDoubleClickOnEnter()  {
        return getAttributeAsBoolean("generateDoubleClickOnEnter");
    }

    /**
    * Action to perform when the listGrid has keyboard focus (but not editing focus) and a user presses the up or down arrow key. Possible values are: <ul> <li><code>select</code> : select the next row in the list (calls <code>recordClick</code> handler)</li> <li><code>focus</code> : move focus to the next row in the list without changing the selection</li> <li><code>activate</code> : select and activate the next row in the list (calls  <code>recordDoubleClick</code> handler)</li> <li><code>none</code> : no action</li> </ul>
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param arrowKeyAction arrowKeyAction Default value is "select"
    */
    public void setArrowKeyAction(String arrowKeyAction) {
        setAttribute("arrowKeyAction", arrowKeyAction, true);
    }
    /**
     * Action to perform when the listGrid has keyboard focus (but not editing focus) and a user presses the up or down arrow key. Possible values are: <ul> <li><code>select</code> : select the next row in the list (calls <code>recordClick</code> handler)</li> <li><code>focus</code> : move focus to the next row in the list without changing the selection</li> <li><code>activate</code> : select and activate the next row in the list (calls  <code>recordDoubleClick</code> handler)</li> <li><code>none</code> : no action</li> </ul>
     *
     *
     * @return String
     *
     */
    public String getArrowKeyAction()  {
        return getAttributeAsString("arrowKeyAction");
    }

    /**
    * Should we show different styling for the cell the mouse is over? <br> If true, the cell style will have the suffix "Over" appended.
    *
    * @param showRollOver showRollOver Default value is true
    */
    public void setShowRollOver(Boolean showRollOver) {
        setAttribute("showRollOver", showRollOver, true);
    }
    /**
     * Should we show different styling for the cell the mouse is over? <br> If true, the cell style will have the suffix "Over" appended.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getShowRollOver()  {
        return getAttributeAsBoolean("showRollOver");
    }

    /**
    * If true, cellHover and rowHover events will fire when the user leaves the mouse over a  row / cell.
    *
    * @param canHover canHover Default value is null
    */
    public void setCanHover(Boolean canHover) {
        setAttribute("canHover", canHover, true);
    }
    /**
     * If true, cellHover and rowHover events will fire when the user leaves the mouse over a  row / cell.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getCanHover()  {
        return getAttributeAsBoolean("canHover");
    }

    /**
    * If true, and canHover is also true, when the user hovers over a cell, hover text will pop up next to the mouse.  The contents of the hover is determined by {@link com.smartgwt.client.widgets.grid.ListGrid#cellHoverHTML}.
    *
    * @param showHover showHover Default value is true
    */
    public void setShowHover(Boolean showHover) {
        setAttribute("showHover", showHover, true);
    }
    /**
     * If true, and canHover is also true, when the user hovers over a cell, hover text will pop up next to the mouse.  The contents of the hover is determined by {@link com.smartgwt.client.widgets.grid.ListGrid#cellHoverHTML}.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getShowHover()  {
        return getAttributeAsBoolean("showHover");
    }

    /**
    * Style to apply to hovers shown over this grid.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param hoverStyle hoverStyle Default value is "gridHover"
    */
    public void setHoverStyle(String hoverStyle) {
        setAttribute("hoverStyle", hoverStyle, true);
    }
    /**
     * Style to apply to hovers shown over this grid.
     *
     *
     * @return String
     *
     */
    public String getHoverStyle()  {
        return getAttributeAsString("hoverStyle");
    }
             
    /**
    * How selection of rows should be presented to the user. <P> If using "checkbox", see also {@link com.smartgwt.client.widgets.grid.ListGrid#getCheckboxField checkboxField} for customization APIs.
    *
    * @param selectionAppearance selectionAppearance Default value is "rowStyle"
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setSelectionAppearance(SelectionAppearance selectionAppearance)  throws IllegalStateException {
        setAttribute("selectionAppearance", selectionAppearance.getValue(), false);
    }
    /**
     * How selection of rows should be presented to the user. <P> If using "checkbox", see also {@link com.smartgwt.client.widgets.grid.ListGrid#getCheckboxField checkboxField} for customization APIs.
     *
     *
     * @return SelectionAppearance
     *
     */
    public SelectionAppearance getSelectionAppearance()  {
        return (SelectionAppearance) EnumUtil.getEnum(SelectionAppearance.values(), getAttribute("selectionAppearance"));
    }
             
    /**
    * Defines a listGrid's clickable-selection behavior. The selection appearance is governed by {@link com.smartgwt.client.widgets.grid.ListGrid#getSelectionAppearance selectionAppearance}. If selectionAppearance is "checkbox", this will be "simple", otherwise, this will be "multiple".
    *
    * @param selectionType selectionType Default value is null
    */
    public void setSelectionType(SelectionStyle selectionType) {
        setAttribute("selectionType", selectionType.getValue(), true);
    }
    /**
     * Defines a listGrid's clickable-selection behavior. The selection appearance is governed by {@link com.smartgwt.client.widgets.grid.ListGrid#getSelectionAppearance selectionAppearance}. If selectionAppearance is "checkbox", this will be "simple", otherwise, this will be "multiple".
     *
     *
     * @return SelectionStyle
     *
     */
    public SelectionStyle getSelectionType()  {
        return (SelectionStyle) EnumUtil.getEnum(SelectionStyle.values(), getAttribute("selectionType"));
    }

    /**
    * If this property is true, users can drag the mouse to select several rows or cells.  This is mutually exclusive with rearranging rows or cells by dragging.
    *
    * @param canDragSelect canDragSelect Default value is false
    */
    public void setCanDragSelect(Boolean canDragSelect) {
        setAttribute("canDragSelect", canDragSelect, true);
    }
    /**
     * If this property is true, users can drag the mouse to select several rows or cells.  This is mutually exclusive with rearranging rows or cells by dragging.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getCanDragSelect()  {
        return getAttributeAsBoolean("canDragSelect");
    }

    /**
    * Indicates whether the text of the emptyMessage property should be displayed if no data is available.
    *
    * @param showEmptyMessage showEmptyMessage Default value is true
    */
    public void setShowEmptyMessage(Boolean showEmptyMessage) {
        setAttribute("showEmptyMessage", showEmptyMessage, true);
    }
    /**
     * Indicates whether the text of the emptyMessage property should be displayed if no data is available.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getShowEmptyMessage()  {
        return getAttributeAsBoolean("showEmptyMessage");
    }

    /**
    * The string to display in the body of a listGrid with an empty data array, if showEmptyMessage is true.
    *
    * @param emptyMessage emptyMessage Default value is "No items to show."
    */
    public void setEmptyMessage(String emptyMessage) {
        setAttribute("emptyMessage", emptyMessage, true);
    }
    /**
     * The string to display in the body of a listGrid with an empty data array, if showEmptyMessage is true.
     *
     *
     * @return String
     *
     */
    public String getEmptyMessage()  {
        return getAttributeAsString("emptyMessage");
    }

    /**
    * The CSS style name applied to the {@link com.smartgwt.client.widgets.grid.ListGrid#getEmptyMessage emptyMessage} if displayed.
    *
    * @param emptyMessageStyle emptyMessageStyle Default value is "emptyMessage"
    */
    public void setEmptyMessageStyle(String emptyMessageStyle) {
        setAttribute("emptyMessageStyle", emptyMessageStyle, true);
    }
    /**
     * The CSS style name applied to the {@link com.smartgwt.client.widgets.grid.ListGrid#getEmptyMessage emptyMessage} if displayed.
     *
     *
     * @return String
     *
     */
    public String getEmptyMessageStyle()  {
        return getAttributeAsString("emptyMessageStyle");
    }

    /**
    * The string to display in the body of a listGrid while data is being loaded.
    *
    * @param loadingDataMessage loadingDataMessage Default value is "Loading data..."
    */
    public void setLoadingDataMessage(String loadingDataMessage) {
        setAttribute("loadingDataMessage", loadingDataMessage, true);
    }
    /**
     * The string to display in the body of a listGrid while data is being loaded.
     *
     *
     * @return String
     *
     */
    public String getLoadingDataMessage()  {
        return getAttributeAsString("loadingDataMessage");
    }

    /**
    * The CSS style name applied to the loadingDataMessage string if displayed.
    *
    * @param loadingDataMessageStyle loadingDataMessageStyle Default value is "loadingDataMessage"
    */
    public void setLoadingDataMessageStyle(String loadingDataMessageStyle) {
        setAttribute("loadingDataMessageStyle", loadingDataMessageStyle, true);
    }
    /**
     * The CSS style name applied to the loadingDataMessage string if displayed.
     *
     *
     * @return String
     *
     */
    public String getLoadingDataMessageStyle()  {
        return getAttributeAsString("loadingDataMessageStyle");
    }

    /**
    * If you have a databound listGrid and you scroll out of the currently loaded dataset, by default you will see blank rows until the server returns the data for those rows.  The loadingMessage attribute allows you to specify arbitrary html that will be shown in each such "blank" record while the data for that record is loading.
    *
    * @param loadingMessage loadingMessage Default value is "\&nbsp;"
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setLoadingMessage(String loadingMessage)  throws IllegalStateException {
        setAttribute("loadingMessage", loadingMessage, false);
    }
    /**
     * If you have a databound listGrid and you scroll out of the currently loaded dataset, by default you will see blank rows until the server returns the data for those rows.  The loadingMessage attribute allows you to specify arbitrary html that will be shown in each such "blank" record while the data for that record is loading.
     *
     *
     * @return String
     *
     */
    public String getLoadingMessage()  {
        return getAttributeAsString("loadingMessage");
    }

    /**
    * If <code>record[this.singleCellValueProperty]</code> is set for some record, the  record will be displayed as a single cell spanning every column in the grid, with  contents set to the value of <code>record[this.singleCellValueProperty]</code>.
    *
    * @param singleCellValueProperty singleCellValueProperty Default value is "singleCellValue"
    */
    public void setSingleCellValueProperty(String singleCellValueProperty) {
        setAttribute("singleCellValueProperty", singleCellValueProperty, true);
    }
    /**
     * If <code>record[this.singleCellValueProperty]</code> is set for some record, the  record will be displayed as a single cell spanning every column in the grid, with  contents set to the value of <code>record[this.singleCellValueProperty]</code>.
     *
     *
     * @return String
     *
     */
    public String getSingleCellValueProperty()  {
        return getAttributeAsString("singleCellValueProperty");
    }

    /**
    * If <code>record[this.isSeparatorProperty]</code> is set for some record, the  record will be displayed as a simple separator row.
    *
    * @param isSeparatorProperty isSeparatorProperty Default value is "isSeparator"
    */
    public void setIsSeparatorProperty(String isSeparatorProperty) {
        setAttribute("isSeparatorProperty", isSeparatorProperty, true);
    }
    /**
     * If <code>record[this.isSeparatorProperty]</code> is set for some record, the  record will be displayed as a simple separator row.
     *
     *
     * @return String
     *
     */
    public String getIsSeparatorProperty()  {
        return getAttributeAsString("isSeparatorProperty");
    }

    /**
    * Should this listGrid display a filter row.  If true, this ListGrid    will be drawn with a single editable row, (separate from the body).  Values entered    into this row are used as filter criteria to filter this List's data.
    * Setter for the {@link com.smartgwt.client.widgets.grid.ListGrid#getShowFilterEditor showFilterEditor} property. Allows the filter editor to be shown or hidden at runtime.
    *
    * @param showFilterEditor true if the filter editor should be shown, false if it should be hidden. Default value is null
    */
    public void setShowFilterEditor(Boolean showFilterEditor) {
        setAttribute("showFilterEditor", showFilterEditor, true);
    }
    /**
     * Should this listGrid display a filter row.  If true, this ListGrid    will be drawn with a single editable row, (separate from the body).  Values entered    into this row are used as filter criteria to filter this List's data.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getShowFilterEditor()  {
        return getAttributeAsBoolean("showFilterEditor");
    }

    /**
    * Height for the filterEditor, if shown.
    *
    * @param filterEditorHeight filterEditorHeight Default value is 22
    */
    public void setFilterEditorHeight(int filterEditorHeight) {
        setAttribute("filterEditorHeight", filterEditorHeight, true);
    }
    /**
     * Height for the filterEditor, if shown.
     *
     *
     * @return int
     *
     */
    public int getFilterEditorHeight()  {
        return getAttributeAsInt("filterEditorHeight");
    }

    /**
    * Can the user edit cells in this listGrid? Can be set for the listGrid, and overridden for       individual fields.<br>      If 'canEdit' is false at the listGrid level, fields can never be edited - in this case      the canEdit property on individual fields will be ignored.<br>      If 'canEdit' is set to true at the listGrid level, setting the 'canEdit' property to      false at the field level will prevent the field from being edited inline.<br>      If 'canEdit' is not set at the listGrid level, setting 'canEdit' to true at the field       level enables the field to be edited inline.
    *
    * @param canEdit canEdit Default value is null
    */
    public void setCanEdit(Boolean canEdit) {
        setAttribute("canEdit", canEdit, true);
    }
    /**
     * Can the user edit cells in this listGrid? Can be set for the listGrid, and overridden for       individual fields.<br>      If 'canEdit' is false at the listGrid level, fields can never be edited - in this case      the canEdit property on individual fields will be ignored.<br>      If 'canEdit' is set to true at the listGrid level, setting the 'canEdit' property to      false at the field level will prevent the field from being edited inline.<br>      If 'canEdit' is not set at the listGrid level, setting 'canEdit' to true at the field       level enables the field to be edited inline.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getCanEdit()  {
        return getAttributeAsBoolean("canEdit");
    }

    /**
    * Property name on a record that should be checked to determine whether the record may be edited. <br> This property is configurable to avoid possible collision with data values in record. With the default setting of "_canEdit", a record can be set non-editable by ensuring record._canEdit == false. <br> For controlling editability for the entire grid or for a field, set grid.canEdit or field.canEdit.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param recordEditProperty recordEditProperty Default value is "_canEdit"
    */
    public void setRecordEditProperty(String recordEditProperty) {
        setAttribute("recordEditProperty", recordEditProperty, true);
    }
    /**
     * Property name on a record that should be checked to determine whether the record may be edited. <br> This property is configurable to avoid possible collision with data values in record. With the default setting of "_canEdit", a record can be set non-editable by ensuring record._canEdit == false. <br> For controlling editability for the entire grid or for a field, set grid.canEdit or field.canEdit.
     *
     *
     * @return String
     *
     */
    public String getRecordEditProperty()  {
        return getAttributeAsString("recordEditProperty");
    }

    /**
    * Determines whether when the user edits a cell in this listGrid the entire row becomes      editable, or just the cell that recieved the edit event.<br><br>      No effect if this.canEdit is false or null.
    *
    * @param editByCell editByCell Default value is null
    */
    public void setEditByCell(Boolean editByCell) {
        setAttribute("editByCell", editByCell, true);
    }
    /**
     * Determines whether when the user edits a cell in this listGrid the entire row becomes      editable, or just the cell that recieved the edit event.<br><br>      No effect if this.canEdit is false or null.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getEditByCell()  {
        return getAttributeAsBoolean("editByCell");
    }

    /**
    * Whether edits should be saved whenever the user moves between cells in the current edit row. <P> If unset, defaults to this.editByCell. <P> To avoid automatic saving entirely, set {@link com.smartgwt.client.widgets.grid.ListGrid#getAutoSaveEdits autoSaveEdits}:false.
    *
    * @param saveByCell saveByCell Default value is null
    */
    public void setSaveByCell(Boolean saveByCell) {
        setAttribute("saveByCell", saveByCell, true);
    }
    /**
     * Whether edits should be saved whenever the user moves between cells in the current edit row. <P> If unset, defaults to this.editByCell. <P> To avoid automatic saving entirely, set {@link com.smartgwt.client.widgets.grid.ListGrid#getAutoSaveEdits autoSaveEdits}:false.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getSaveByCell()  {
        return getAttributeAsBoolean("saveByCell");
    }

    /**
    * Whether client-side validation checks should be performed when the user moves between cells in the current edit row.  If unset, defaults to {@link com.smartgwt.client.widgets.grid.ListGrid#getEditByCell editByCell}.<br> Note that if false validation occurs on row-transition rather than cell transitions. Validation also always occurs when a row is to be saved.
    *
    * @param validateByCell validateByCell Default value is null
    */
    public void setValidateByCell(Boolean validateByCell) {
        setAttribute("validateByCell", validateByCell, true);
    }
    /**
     * Whether client-side validation checks should be performed when the user moves between cells in the current edit row.  If unset, defaults to {@link com.smartgwt.client.widgets.grid.ListGrid#getEditByCell editByCell}.<br> Note that if false validation occurs on row-transition rather than cell transitions. Validation also always occurs when a row is to be saved.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getValidateByCell()  {
        return getAttributeAsBoolean("validateByCell");
    }

    /**
    * If true, validation will be perfomed on each edited cell when each editor's  "change" handler is fired.<br>
    *
    * @param validateOnChange validateOnChange Default value is null
    */
    public void setValidateOnChange(Boolean validateOnChange) {
        setAttribute("validateOnChange", validateOnChange, true);
    }
    /**
     * If true, validation will be perfomed on each edited cell when each editor's  "change" handler is fired.<br>
     *
     *
     * @return Boolean
     *
     */
    public Boolean getValidateOnChange()  {
        return getAttributeAsBoolean("validateOnChange");
    }

    /**
    * If true, validation will not occur as a result of cell editing for this grid.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param neverValidate neverValidate Default value is null
    */
    public void setNeverValidate(Boolean neverValidate) {
        setAttribute("neverValidate", neverValidate, true);
    }
    /**
     * If true, validation will not occur as a result of cell editing for this grid.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getNeverValidate()  {
        return getAttributeAsBoolean("neverValidate");
    }

    /**
    * If set, provide UI for the user to remove records from the grid. This is achieved by rendering an additional field in the listGrid which, when clicked, will remove the record associated with the clicked row via a call to {@link com.smartgwt.client.widgets.grid.ListGrid#removeData}. <P> If {@link com.smartgwt.client.widgets.grid.ListGrid#getAnimateRemoveRecord animateRemoveRecord} is true, the removed record will appear to shrink out of view when it is removed. <P> By default the field will display the {@link com.smartgwt.client.widgets.grid.ListGrid#getRemoveIcon removeIcon} next to each record, and will be rendered as the leftmost column. Two mechanisms exist to further modify this field: <ul> <li>To change the position of the remove-field, include an explicitly specified field with     the attribute {@link com.smartgwt.client.widgets.grid.ListGridField#getIsRemoveField isRemoveField} set. This will then     be used as the remove field instead of adding a field to the beginning of the set of     columns.</li> <li>Additional direct configuration of the remove field may be achieved by modifying     {@link com.smartgwt.client.widgets.grid.ListGrid#getRemoveFieldProperties removeFieldProperties}.</li> </ul>
    *
    * @param canRemoveRecords canRemoveRecords Default value is false
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setCanRemoveRecords(Boolean canRemoveRecords)  throws IllegalStateException {
        setAttribute("canRemoveRecords", canRemoveRecords, false);
    }
    /**
     * If set, provide UI for the user to remove records from the grid. This is achieved by rendering an additional field in the listGrid which, when clicked, will remove the record associated with the clicked row via a call to {@link com.smartgwt.client.widgets.grid.ListGrid#removeData}. <P> If {@link com.smartgwt.client.widgets.grid.ListGrid#getAnimateRemoveRecord animateRemoveRecord} is true, the removed record will appear to shrink out of view when it is removed. <P> By default the field will display the {@link com.smartgwt.client.widgets.grid.ListGrid#getRemoveIcon removeIcon} next to each record, and will be rendered as the leftmost column. Two mechanisms exist to further modify this field: <ul> <li>To change the position of the remove-field, include an explicitly specified field with     the attribute {@link com.smartgwt.client.widgets.grid.ListGridField#getIsRemoveField isRemoveField} set. This will then     be used as the remove field instead of adding a field to the beginning of the set of     columns.</li> <li>Additional direct configuration of the remove field may be achieved by modifying     {@link com.smartgwt.client.widgets.grid.ListGrid#getRemoveFieldProperties removeFieldProperties}.</li> </ul>
     *
     *
     * @return Boolean
     *
     */
    public Boolean getCanRemoveRecords()  {
        return getAttributeAsBoolean("canRemoveRecords");
    }

    /**
    * When {@link com.smartgwt.client.widgets.grid.ListGrid#getCanRemoveRecords canRemoveRecords} is enabled, default icon to show in the auto-generated field that allows removing records.
    *
    * @param removeIcon removeIcon Default value is "[SKIN]/actions/remove.png"
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setRemoveIcon(String removeIcon)  throws IllegalStateException {
        setAttribute("removeIcon", removeIcon, false);
    }
    /**
     * When {@link com.smartgwt.client.widgets.grid.ListGrid#getCanRemoveRecords canRemoveRecords} is enabled, default icon to show in the auto-generated field that allows removing records.
     *
     *
     * @return String
     *
     */
    public String getRemoveIcon()  {
        return getAttributeAsString("removeIcon");
    }

    /**
    * When {@link com.smartgwt.client.widgets.grid.ListGrid#getCanRemoveRecords canRemoveRecords} is enabled, should records be animated out of view when they are removed by the user?
    *
    * @param animateRemoveRecord animateRemoveRecord Default value is true
    */
    public void setAnimateRemoveRecord(Boolean animateRemoveRecord) {
        setAttribute("animateRemoveRecord", animateRemoveRecord, true);
    }
    /**
     * When {@link com.smartgwt.client.widgets.grid.ListGrid#getCanRemoveRecords canRemoveRecords} is enabled, should records be animated out of view when they are removed by the user?
     *
     *
     * @return Boolean
     *
     */
    public Boolean getAnimateRemoveRecord()  {
        return getAttributeAsBoolean("animateRemoveRecord");
    }

    /**
    * When animating record removal  {@link com.smartgwt.client.widgets.grid.ListGrid#getAnimateRemoveRecord animateRemoveRecord}, if  {@link com.smartgwt.client.widgets.grid.ListGrid#getAnimateRemoveSpeed animateRemoveSpeed} is not set, this property designates the duration of the animation in ms.
    *
    * @param animateRemoveTime animateRemoveTime Default value is 100
    */
    public void setAnimateRemoveTime(int animateRemoveTime) {
        setAttribute("animateRemoveTime", animateRemoveTime, true);
    }
    /**
     * When animating record removal  {@link com.smartgwt.client.widgets.grid.ListGrid#getAnimateRemoveRecord animateRemoveRecord}, if  {@link com.smartgwt.client.widgets.grid.ListGrid#getAnimateRemoveSpeed animateRemoveSpeed} is not set, this property designates the duration of the animation in ms.
     *
     *
     * @return int
     *
     */
    public int getAnimateRemoveTime()  {
        return getAttributeAsInt("animateRemoveTime");
    }

    /**
    * When {@link com.smartgwt.client.widgets.grid.ListGrid#getAnimateRemoveRecord animateRemoveRecord}, this property  designates the speed of the animation in pixels per second. Takes presidence over the {@link com.smartgwt.client.widgets.grid.ListGrid#getAnimateRemoveTime animateRemoveTime} property, which allows the developer to specify a duration for the animation rather than a speed.
    *
    * @param animateRemoveSpeed animateRemoveSpeed Default value is 200
    */
    public void setAnimateRemoveSpeed(int animateRemoveSpeed) {
        setAttribute("animateRemoveSpeed", animateRemoveSpeed, true);
    }
    /**
     * When {@link com.smartgwt.client.widgets.grid.ListGrid#getAnimateRemoveRecord animateRemoveRecord}, this property  designates the speed of the animation in pixels per second. Takes presidence over the {@link com.smartgwt.client.widgets.grid.ListGrid#getAnimateRemoveTime animateRemoveTime} property, which allows the developer to specify a duration for the animation rather than a speed.
     *
     *
     * @return int
     *
     */
    public int getAnimateRemoveSpeed()  {
        return getAttributeAsInt("animateRemoveSpeed");
    }

    /**
    * If we're showing the filterEditor (this.showFilterEditor is true), this property  determines whether this list should be filtered every time the user puts focus in a different field in the filter editor.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param filterByCell filterByCell Default value is null
    */
    public void setFilterByCell(Boolean filterByCell) {
        setAttribute("filterByCell", filterByCell, true);
    }
    /**
     * If we're showing the filterEditor (this.showFilterEditor is true), this property  determines whether this list should be filtered every time the user puts focus in a different field in the filter editor.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getFilterByCell()  {
        return getAttributeAsBoolean("filterByCell");
    }

    /**
    * If we're showing the filterEditor (this.showFilterEditor is true), this property  determines whether this list should be filtered every time the user modifies the value in a field of the filter-editor. Can also be set at the field level.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param filterOnKeypress filterOnKeypress Default value is null
    */
    public void setFilterOnKeypress(Boolean filterOnKeypress) {
        setAttribute("filterOnKeypress", filterOnKeypress, true);
    }
    /**
     * If we're showing the filterEditor (this.showFilterEditor is true), this property  determines whether this list should be filtered every time the user modifies the value in a field of the filter-editor. Can also be set at the field level.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getFilterOnKeypress()  {
        return getAttributeAsBoolean("filterOnKeypress");
    }

    /**
    * If this is an editable listGrid, this property determines whether the user will be able to dismiss the edit form, or navigate to another cell while the save is in  process (before the asynchronous server response returns).
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param waitForSave waitForSave Default value is false
    */
    public void setWaitForSave(Boolean waitForSave) {
        setAttribute("waitForSave", waitForSave, true);
    }
    /**
     * If this is an editable listGrid, this property determines whether the user will be able to dismiss the edit form, or navigate to another cell while the save is in  process (before the asynchronous server response returns).
     *
     *
     * @return Boolean
     *
     */
    public Boolean getWaitForSave()  {
        return getAttributeAsBoolean("waitForSave");
    }

    /**
    * If this is an editable listGrid, this property determines how failure to save due to  validation errors should be displayed to the user. <P> If this property is true, when validation errors occur the errors will be displayed to the user in an alert, and focus will be returned to the first cell to fail validation. <P> If false, this the cells that failed validation will be silently styled with the  editFailedBaseStyle.<br> <b>Note:</b> stopOnErrors being set to true implies that 'waitForSave' is also true. We will not dismiss the editor until save has completed if stopOnErrors is true.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param stopOnErrors stopOnErrors Default value is false
    */
    public void setStopOnErrors(Boolean stopOnErrors) {
        setAttribute("stopOnErrors", stopOnErrors, true);
    }
    /**
     * If this is an editable listGrid, this property determines how failure to save due to  validation errors should be displayed to the user. <P> If this property is true, when validation errors occur the errors will be displayed to the user in an alert, and focus will be returned to the first cell to fail validation. <P> If false, this the cells that failed validation will be silently styled with the  editFailedBaseStyle.<br> <b>Note:</b> stopOnErrors being set to true implies that 'waitForSave' is also true. We will not dismiss the editor until save has completed if stopOnErrors is true.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getStopOnErrors()  {
        return getAttributeAsBoolean("stopOnErrors");
    }

    /**
    * If this ListGrid is editable, should edits be saved out when the user finishes editing a row (or a cell if {@link com.smartgwt.client.widgets.grid.ListGrid#getSaveByCell saveByCell} is true). <P> The default of <code>true</code> indicates that edits will be {@link com.smartgwt.client.widgets.grid.ListGrid#getSaveByCell saveByCell} as the user navigates through the grid and/or ${isc.DocUtils.linkForRef('type:EnterKeyEditAction','hits 'Enter'')} to end editing.  See the Grid Editing overview for details.  <P> Setting <code>autoSaveEdits</code> false creates a "mass update" / "mass delete" interaction where edits will be retained for all edited cells (across rows if appropriate) until {@link com.smartgwt.client.widgets.grid.ListGrid#saveEdits} is called to save a particular row, or {@link com.smartgwt.client.widgets.grid.ListGrid#saveAllEdits} is called to save all changes in a batch.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param autoSaveEdits autoSaveEdits Default value is true
    */
    public void setAutoSaveEdits(Boolean autoSaveEdits) {
        setAttribute("autoSaveEdits", autoSaveEdits, true);
    }
    /**
     * If this ListGrid is editable, should edits be saved out when the user finishes editing a row (or a cell if {@link com.smartgwt.client.widgets.grid.ListGrid#getSaveByCell saveByCell} is true). <P> The default of <code>true</code> indicates that edits will be {@link com.smartgwt.client.widgets.grid.ListGrid#getSaveByCell saveByCell} as the user navigates through the grid and/or ${isc.DocUtils.linkForRef('type:EnterKeyEditAction','hits 'Enter'')} to end editing.  See the Grid Editing overview for details.  <P> Setting <code>autoSaveEdits</code> false creates a "mass update" / "mass delete" interaction where edits will be retained for all edited cells (across rows if appropriate) until {@link com.smartgwt.client.widgets.grid.ListGrid#saveEdits} is called to save a particular row, or {@link com.smartgwt.client.widgets.grid.ListGrid#saveAllEdits} is called to save all changes in a batch.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getAutoSaveEdits()  {
        return getAttributeAsBoolean("autoSaveEdits");
    }

    /**
    * If this is an editable listGrid, when the user attempts to cancel an edit, should we display a confirmation prompt before discarding the edited values for the record?
    *
    * @param confirmCancelEditing confirmCancelEditing Default value is false
    */
    public void setConfirmCancelEditing(Boolean confirmCancelEditing) {
        setAttribute("confirmCancelEditing", confirmCancelEditing, true);
    }
    /**
     * If this is an editable listGrid, when the user attempts to cancel an edit, should we display a confirmation prompt before discarding the edited values for the record?
     *
     *
     * @return Boolean
     *
     */
    public Boolean getConfirmCancelEditing()  {
        return getAttributeAsBoolean("confirmCancelEditing");
    }

    /**
    * If this is an editable listGrid, and <code>this.confirmCancelEditing</code> is true this property is used as the message to display in the confirmation dismissal prompt.
    *
    * @param cancelEditingConfirmationMessage cancelEditingConfirmationMessage Default value is Cancelling this edit will clear unsaved edit values for this record. Continue?
    */
    public void setCancelEditingConfirmationMessage(String cancelEditingConfirmationMessage) {
        setAttribute("cancelEditingConfirmationMessage", cancelEditingConfirmationMessage, true);
    }
    /**
     * If this is an editable listGrid, and <code>this.confirmCancelEditing</code> is true this property is used as the message to display in the confirmation dismissal prompt.
     *
     *
     * @return String
     *
     */
    public String getCancelEditingConfirmationMessage()  {
        return getAttributeAsString("cancelEditingConfirmationMessage");
    }

    /**
    * For editable listGrids, outstanding unsaved edits when the user performs a new filter or sort will be discarded. This flag determines whether we should display a confirmation dialog with options to save or discard the edits, or cancel the action in this case.
    *
    * @param confirmDiscardEdits confirmDiscardEdits Default value is true
    */
    public void setConfirmDiscardEdits(Boolean confirmDiscardEdits) {
        setAttribute("confirmDiscardEdits", confirmDiscardEdits, true);
    }
    /**
     * For editable listGrids, outstanding unsaved edits when the user performs a new filter or sort will be discarded. This flag determines whether we should display a confirmation dialog with options to save or discard the edits, or cancel the action in this case.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getConfirmDiscardEdits()  {
        return getAttributeAsBoolean("confirmDiscardEdits");
    }

    /**
    * If <code>this.confirmDiscardEdits</code> is true, this property can be used to customize the error message string displayed to the user in a dialog with options to  cancel the action, or save or discard pending edits in response to sort/filter actions that would otherwise drop unsaved edit values.
    *
    * @param confirmDiscardEditsMessage confirmDiscardEditsMessage Default value is "This action will discard all unsaved edited values for this list."
    */
    public void setConfirmDiscardEditsMessage(String confirmDiscardEditsMessage) {
        setAttribute("confirmDiscardEditsMessage", confirmDiscardEditsMessage, true);
    }
    /**
     * If <code>this.confirmDiscardEdits</code> is true, this property can be used to customize the error message string displayed to the user in a dialog with options to  cancel the action, or save or discard pending edits in response to sort/filter actions that would otherwise drop unsaved edit values.
     *
     *
     * @return String
     *
     */
    public String getConfirmDiscardEditsMessage()  {
        return getAttributeAsString("confirmDiscardEditsMessage");
    }

    /**
    * If {@link com.smartgwt.client.widgets.grid.ListGrid#getConfirmDiscardEdits confirmDiscardEdits} is true this is the title for the save button appearing in the lost edits confirmation dialog. Override this for localization if necessary.
    *
    * @param discardEditsSaveButtonTitle discardEditsSaveButtonTitle Default value is "Save"
    */
    public void setDiscardEditsSaveButtonTitle(String discardEditsSaveButtonTitle) {
        setAttribute("discardEditsSaveButtonTitle", discardEditsSaveButtonTitle, true);
    }
    /**
     * If {@link com.smartgwt.client.widgets.grid.ListGrid#getConfirmDiscardEdits confirmDiscardEdits} is true this is the title for the save button appearing in the lost edits confirmation dialog. Override this for localization if necessary.
     *
     *
     * @return String
     *
     */
    public String getDiscardEditsSaveButtonTitle()  {
        return getAttributeAsString("discardEditsSaveButtonTitle");
    }
             
    /**
    * If the user is editing a record in this listGrid, and attempts to navigate to a field beyond the end of the row, via tab (or shift-tab off the first editable field), this  property determines what action to take:<ul> <li>"next": start editing the next (or previous) record in the list <li>"same": put focus back into the first editable field of the same record. <li>"done": hide the editor <li>"stop": leave focus in the cell being edited </ul>
    *
    * @param rowEndEditAction rowEndEditAction Default value is "next"
    */
    public void setRowEndEditAction(RowEndEditAction rowEndEditAction) {
        setAttribute("rowEndEditAction", rowEndEditAction.getValue(), true);
    }
    /**
     * If the user is editing a record in this listGrid, and attempts to navigate to a field beyond the end of the row, via tab (or shift-tab off the first editable field), this  property determines what action to take:<ul> <li>"next": start editing the next (or previous) record in the list <li>"same": put focus back into the first editable field of the same record. <li>"done": hide the editor <li>"stop": leave focus in the cell being edited </ul>
     *
     *
     * @return RowEndEditAction
     *
     */
    public RowEndEditAction getRowEndEditAction()  {
        return (RowEndEditAction) EnumUtil.getEnum(RowEndEditAction.values(), getAttribute("rowEndEditAction"));
    }
             
    /**
    * If the user is editing the last record in this listGrid, and attempts to navigate  beyond the last row either by tabbing off the last editable field, or using the down arrow key, this property determines what action to take:<ul> <li>"next": start editing a new record at the end of the list. <li>"done": hide the editor <li>"stop": leave focus in the cell being edited </ul>
    *
    * @param listEndEditAction listEndEditAction Default value is "stop"
    */
    public void setListEndEditAction(RowEndEditAction listEndEditAction) {
        setAttribute("listEndEditAction", listEndEditAction.getValue(), true);
    }
    /**
     * If the user is editing the last record in this listGrid, and attempts to navigate  beyond the last row either by tabbing off the last editable field, or using the down arrow key, this property determines what action to take:<ul> <li>"next": start editing a new record at the end of the list. <li>"done": hide the editor <li>"stop": leave focus in the cell being edited </ul>
     *
     *
     * @return RowEndEditAction
     *
     */
    public RowEndEditAction getListEndEditAction()  {
        return (RowEndEditAction) EnumUtil.getEnum(RowEndEditAction.values(), getAttribute("listEndEditAction"));
    }
             
    /**
    * What to do when a user hits enter while editing a cell: <ul> <li>"nextCell": start editing the next editable cell in this record (or the first     editable cell in the next record if focus is in the last editable cell in the row) <li>"nextRow": start editing the same field in the next row (skipping any rows where      that would be a non-editable cell. <li>"nextRowStart": start editing the first editable cell in the next row. <li>"done": hide the editor (editing is complete) </ul> Note that if this.autoSaveEdits is true, this may cause a save of the current edit values
    *
    * @param enterKeyEditAction enterKeyEditAction Default value is "done"
    */
    public void setEnterKeyEditAction(EnterKeyEditAction enterKeyEditAction) {
        setAttribute("enterKeyEditAction", enterKeyEditAction.getValue(), true);
    }
    /**
     * What to do when a user hits enter while editing a cell: <ul> <li>"nextCell": start editing the next editable cell in this record (or the first     editable cell in the next record if focus is in the last editable cell in the row) <li>"nextRow": start editing the same field in the next row (skipping any rows where      that would be a non-editable cell. <li>"nextRowStart": start editing the first editable cell in the next row. <li>"done": hide the editor (editing is complete) </ul> Note that if this.autoSaveEdits is true, this may cause a save of the current edit values
     *
     *
     * @return EnterKeyEditAction
     *
     */
    public EnterKeyEditAction getEnterKeyEditAction()  {
        return (EnterKeyEditAction) EnumUtil.getEnum(EnterKeyEditAction.values(), getAttribute("enterKeyEditAction"));
    }
             
    /**
    * What to do when a user hits escape while editing a cell:<ul> <li>"cancel": close the editor and discard the current set of edit values <li>"done": just close the editor (the edit is complete, but the edited values are retained). </ul> Note that if {@link com.smartgwt.client.widgets.grid.ListGrid#getAutoSaveEdits autoSaveEdits} is true, this may cause a save of the current edit values
    *
    * @param escapeKeyEditAction escapeKeyEditAction Default value is "cancel"
    */
    public void setEscapeKeyEditAction(EscapeKeyEditAction escapeKeyEditAction) {
        setAttribute("escapeKeyEditAction", escapeKeyEditAction.getValue(), true);
    }
    /**
     * What to do when a user hits escape while editing a cell:<ul> <li>"cancel": close the editor and discard the current set of edit values <li>"done": just close the editor (the edit is complete, but the edited values are retained). </ul> Note that if {@link com.smartgwt.client.widgets.grid.ListGrid#getAutoSaveEdits autoSaveEdits} is true, this may cause a save of the current edit values
     *
     *
     * @return EscapeKeyEditAction
     *
     */
    public EscapeKeyEditAction getEscapeKeyEditAction()  {
        return (EscapeKeyEditAction) EnumUtil.getEnum(EscapeKeyEditAction.values(), getAttribute("escapeKeyEditAction"));
    }
             
    /**
    * Event that will trigger inline editing, see ${isc.DocUtils.linkForRef('type:ListGridEditEvent')} for options. <P> Note this setting has no effect unless {@link com.smartgwt.client.widgets.grid.ListGrid#getCanEdit canEdit} has been set to enable editing. <P> See also {@link com.smartgwt.client.widgets.grid.ListGrid#getEditOnFocus editOnFocus} and {@link com.smartgwt.client.widgets.grid.ListGrid#startEditing}.
    *
    * @param editEvent editEvent Default value is "doubleClick"
    */
    public void setEditEvent(ListGridEditEvent editEvent) {
        setAttribute("editEvent", editEvent.getValue(), true);
    }
    /**
     * Event that will trigger inline editing, see ${isc.DocUtils.linkForRef('type:ListGridEditEvent')} for options. <P> Note this setting has no effect unless {@link com.smartgwt.client.widgets.grid.ListGrid#getCanEdit canEdit} has been set to enable editing. <P> See also {@link com.smartgwt.client.widgets.grid.ListGrid#getEditOnFocus editOnFocus} and {@link com.smartgwt.client.widgets.grid.ListGrid#startEditing}.
     *
     *
     * @return ListGridEditEvent
     *
     */
    public ListGridEditEvent getEditEvent()  {
        return (ListGridEditEvent) EnumUtil.getEnum(ListGridEditEvent.values(), getAttribute("editEvent"));
    }

    /**
    * Should we start editing when this widget recieves focus (if this ListGrid supports editing)? <P> Note that this property being set to true will cause editing to occur on a single click, even if {@link com.smartgwt.client.widgets.grid.ListGrid#getEditEvent editEvent} is <code>"doubleClick"</code>, because single clicking the grid will place keyboard focus there automatically.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param editOnFocus editOnFocus Default value is null
    */
    public void setEditOnFocus(Boolean editOnFocus) {
        setAttribute("editOnFocus", editOnFocus, true);
    }
    /**
     * Should we start editing when this widget recieves focus (if this ListGrid supports editing)? <P> Note that this property being set to true will cause editing to occur on a single click, even if {@link com.smartgwt.client.widgets.grid.ListGrid#getEditEvent editEvent} is <code>"doubleClick"</code>, because single clicking the grid will place keyboard focus there automatically.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getEditOnFocus()  {
        return getAttributeAsBoolean("editOnFocus");
    }

    /**
    * When the user starts editing a row, should the data in that row also be selected?
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param selectOnEdit selectOnEdit Default value is true
    */
    public void setSelectOnEdit(Boolean selectOnEdit) {
        setAttribute("selectOnEdit", selectOnEdit, true);
    }
    /**
     * When the user starts editing a row, should the data in that row also be selected?
     *
     *
     * @return Boolean
     *
     */
    public Boolean getSelectOnEdit()  {
        return getAttributeAsBoolean("selectOnEdit");
    }

    /**
    * When the length of the field specified by {@link com.smartgwt.client.data.DataSourceField#getLength length} exceeds this value, the ListGrid shows an edit field of type {@link com.smartgwt.client.widgets.grid.ListGrid#getLongTextEditorType longTextEditorType} rather than the standard text field when the field enters inline edit mode.
    *
    * @param longTextEditorThreshold longTextEditorThreshold Default value is 255
    */
    public void setLongTextEditorThreshold(int longTextEditorThreshold) {
        setAttribute("longTextEditorThreshold", longTextEditorThreshold, true);
    }
    /**
     * When the length of the field specified by {@link com.smartgwt.client.data.DataSourceField#getLength length} exceeds this value, the ListGrid shows an edit field of type {@link com.smartgwt.client.widgets.grid.ListGrid#getLongTextEditorType longTextEditorType} rather than the standard text field when the field enters inline edit mode.
     *
     *
     * @return int
     *
     */
    public int getLongTextEditorThreshold()  {
        return getAttributeAsInt("longTextEditorThreshold");
    }

    /**
    * When the length of the field specified by {@link com.smartgwt.client.data.DataSourceField#getLength length} exceeds  <code>this.longTextEditorThreshold</code> show an edit field of this type rather than the standard text field when the field enters inline edit mode.
    *
    * @param longTextEditorType longTextEditorType Default value is "PopUpTextAreaItem"
    */
    public void setLongTextEditorType(String longTextEditorType) {
        setAttribute("longTextEditorType", longTextEditorType, true);
    }
    /**
     * When the length of the field specified by {@link com.smartgwt.client.data.DataSourceField#getLength length} exceeds  <code>this.longTextEditorThreshold</code> show an edit field of this type rather than the standard text field when the field enters inline edit mode.
     *
     *
     * @return String
     *
     */
    public String getLongTextEditorType()  {
        return getAttributeAsString("longTextEditorType");
    }

    /**
    * The height of this listGrid's header, in pixels.
    * Modify the height of a listGrid. To hide the header set height to zero.
    *
    * @param headerHeight new height for the header. Default value is 22
    */
    public void setHeaderHeight(int headerHeight) {
        setAttribute("headerHeight", headerHeight, true);
    }
    /**
     * The height of this listGrid's header, in pixels.
     *
     *
     * @return int
     *
     */
    public int getHeaderHeight()  {
        return getAttributeAsInt("headerHeight");
    }

    /**
    * Should we show the header for this ListGrid?
    * Show or hide the ListGrid header.
    *
    * @param showHeader true to show the header, false to hide it.. Default value is true
    */
    public void setShowHeader(Boolean showHeader) {
        setAttribute("showHeader", showHeader, true);
    }
    /**
     * Should we show the header for this ListGrid?
     *
     *
     * @return Boolean
     *
     */
    public Boolean getShowHeader()  {
        return getAttributeAsBoolean("showHeader");
    }

    /**
    * Set the CSS style used for the header as a whole.
    *
    * @param headerBarStyle headerBarStyle Default value is null
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setHeaderBarStyle(String headerBarStyle)  throws IllegalStateException {
        setAttribute("headerBarStyle", headerBarStyle, false);
    }
    /**
     * Set the CSS style used for the header as a whole.
     *
     *
     * @return String
     *
     */
    public String getHeaderBarStyle()  {
        return getAttributeAsString("headerBarStyle");
    }

    /**
    * BackgroundColor for the header toolbar. Typically this is set to match the color of the header buttons.
    *
    * @param headerBackgroundColor headerBackgroundColor Default value is "#CCCCCC"
    */
    public void setHeaderBackgroundColor(String headerBackgroundColor) {
        setAttribute("headerBackgroundColor", headerBackgroundColor, true);
    }
    /**
     * BackgroundColor for the header toolbar. Typically this is set to match the color of the header buttons.
     *
     *
     * @return String
     *
     */
    public String getHeaderBackgroundColor()  {
        return getAttributeAsString("headerBackgroundColor");
    }

    /**
    * {@link com.smartgwt.client.widgets.Button#getBaseStyle baseStyle} to apply to the buttons in the header, and the sorter, for  this ListGrid. Note that depending on the {@link com.smartgwt.client.widgets.grid.ListGrid#getHeaderButtonConstructor headerButtonConstructor} of the header buttons you may also need to set {@link com.smartgwt.client.widgets.grid.ListGrid#getHeaderTitleStyle headerTitleStyle}.
    *
    * @param headerBaseStyle headerBaseStyle Default value is null
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setHeaderBaseStyle(String headerBaseStyle)  throws IllegalStateException {
        setAttribute("headerBaseStyle", headerBaseStyle, false);
    }
    /**
     * {@link com.smartgwt.client.widgets.Button#getBaseStyle baseStyle} to apply to the buttons in the header, and the sorter, for  this ListGrid. Note that depending on the {@link com.smartgwt.client.widgets.grid.ListGrid#getHeaderButtonConstructor headerButtonConstructor} of the header buttons you may also need to set {@link com.smartgwt.client.widgets.grid.ListGrid#getHeaderTitleStyle headerTitleStyle}.
     *
     *
     * @return String
     *
     */
    public String getHeaderBaseStyle()  {
        return getAttributeAsString("headerBaseStyle");
    }

    /**
    * {@link com.smartgwt.client.widgets.StretchImgButton#getTitleStyle titleStyle} to apply to the buttons in the header, and the sorter, for this ListGrid. Note that this will typically only have an effect if  {@link com.smartgwt.client.widgets.grid.ListGrid#getHeaderButtonConstructor headerButtonConstructor} is set to {@link com.smartgwt.client.widgets.StretchImgButton} or a subclass  thereof.
    *
    * @param headerTitleStyle headerTitleStyle Default value is null
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setHeaderTitleStyle(String headerTitleStyle)  throws IllegalStateException {
        setAttribute("headerTitleStyle", headerTitleStyle, false);
    }
    /**
     * {@link com.smartgwt.client.widgets.StretchImgButton#getTitleStyle titleStyle} to apply to the buttons in the header, and the sorter, for this ListGrid. Note that this will typically only have an effect if  {@link com.smartgwt.client.widgets.grid.ListGrid#getHeaderButtonConstructor headerButtonConstructor} is set to {@link com.smartgwt.client.widgets.StretchImgButton} or a subclass  thereof.
     *
     *
     * @return String
     *
     */
    public String getHeaderTitleStyle()  {
        return getAttributeAsString("headerTitleStyle");
    }

    /**
    * If this listGrid contains any frozen fields, this property can be used to apply a custom headerBaseStyle to the frozen fields set of fields. If unset, the standard headerBaseStyle will be used for both frozen and unfrozen cells.
    *
    * @param frozenHeaderBaseStyle frozenHeaderBaseStyle Default value is null
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setFrozenHeaderBaseStyle(String frozenHeaderBaseStyle)  throws IllegalStateException {
        setAttribute("frozenHeaderBaseStyle", frozenHeaderBaseStyle, false);
    }
    /**
     * If this listGrid contains any frozen fields, this property can be used to apply a custom headerBaseStyle to the frozen fields set of fields. If unset, the standard headerBaseStyle will be used for both frozen and unfrozen cells.
     *
     *
     * @return String
     *
     */
    public String getFrozenHeaderBaseStyle()  {
        return getAttributeAsString("frozenHeaderBaseStyle");
    }

    /**
    * If this listGrid contains any frozen fields, this property can be used to apply a custom headerTitleStyle to the frozen fields set of fields. If unset, the standard headerTitleStyle will be used for both frozen and unfrozen cells.
    *
    * @param frozenHeaderTitleStyle frozenHeaderTitleStyle Default value is null
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setFrozenHeaderTitleStyle(String frozenHeaderTitleStyle)  throws IllegalStateException {
        setAttribute("frozenHeaderTitleStyle", frozenHeaderTitleStyle, false);
    }
    /**
     * If this listGrid contains any frozen fields, this property can be used to apply a custom headerTitleStyle to the frozen fields set of fields. If unset, the standard headerTitleStyle will be used for both frozen and unfrozen cells.
     *
     *
     * @return String
     *
     */
    public String getFrozenHeaderTitleStyle()  {
        return getAttributeAsString("frozenHeaderTitleStyle");
    }

    /**
    * Enables or disables interactive sorting behavior for this listGrid. Does not          affect sorting by direct calls to the sort method.
    *
    * @param canSort canSort Default value is true
    */
    public void setCanSort(Boolean canSort) {
        setAttribute("canSort", canSort, true);
    }
    /**
     * Enables or disables interactive sorting behavior for this listGrid. Does not          affect sorting by direct calls to the sort method.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getCanSort()  {
        return getAttributeAsBoolean("canSort");
    }
             
    /**
    * Sorting direction of this ListGrid. If specified when the ListGrid is initialized, this property will be the default sorting direction for the {@link com.smartgwt.client.widgets.grid.ListGrid#getSortField sortField}. May be overridden by specifying {@link com.smartgwt.client.widgets.grid.ListGridField#getSortDirection sortDirection}. <P> After initialization, this property will be updated on {@link com.smartgwt.client.widgets.grid.ListGrid#sort} to reflect the current sort direction of the grid.
    *
    * @param sortDirection sortDirection Default value is Array.ASCENDING
    */
    public void setSortDirection(SortDirection sortDirection) {
        setAttribute("sortDirection", sortDirection.getValue(), true);
    }
    /**
     * Sorting direction of this ListGrid. If specified when the ListGrid is initialized, this property will be the default sorting direction for the {@link com.smartgwt.client.widgets.grid.ListGrid#getSortField sortField}. May be overridden by specifying {@link com.smartgwt.client.widgets.grid.ListGridField#getSortDirection sortDirection}. <P> After initialization, this property will be updated on {@link com.smartgwt.client.widgets.grid.ListGrid#sort} to reflect the current sort direction of the grid.
     *
     *
     * @return SortDirection
     *
     */
    public SortDirection getSortDirection()  {
        return (SortDirection) EnumUtil.getEnum(SortDirection.values(), getAttribute("sortDirection"));
    }
             
    /**
    * Indicates whether a sorting arrow should appear for the listGrid, and its          location. See SortArrow type for details.<br>          Clicking the sort arrow reverses the direction of sorting for the current sort          column (if any), or sorts the listGrid by its first sortable column. The arrow          image on the button indicates the current direction of sorting.          If undefined, the sort arrow will show up in the sorted field, and the          corner sort button will be displayed if a vertical scrollbar is being displayed
    *
    * @param showSortArrow showSortArrow Default value is null
    */
    public void setShowSortArrow(SortArrow showSortArrow) {
        setAttribute("showSortArrow", showSortArrow.getValue(), true);
    }
    /**
     * Indicates whether a sorting arrow should appear for the listGrid, and its          location. See SortArrow type for details.<br>          Clicking the sort arrow reverses the direction of sorting for the current sort          column (if any), or sorts the listGrid by its first sortable column. The arrow          image on the button indicates the current direction of sorting.          If undefined, the sort arrow will show up in the sorted field, and the          corner sort button will be displayed if a vertical scrollbar is being displayed
     *
     *
     * @return SortArrow
     *
     */
    public SortArrow getShowSortArrow()  {
        return (SortArrow) EnumUtil.getEnum(SortArrow.values(), getAttribute("showSortArrow"));
    }

    /**
    * Whether an interface should be shown to allow user is allowed to dynamically "freeze" or "unfreeze" columns with respect to horizontally scrolling. If unset, this property defaults to <code>true</code> unless:<ul> <li>{@link com.smartgwt.client.widgets.grid.ListGrid#getFixedRecordHeights fixedRecordHeights} is <code>false</code></li> <li>{@link com.smartgwt.client.widgets.grid.ListGrid#getBodyOverflow bodyOverflow} is <code>"visible"</code></li> <li>{@link com.smartgwt.client.widgets.grid.ListGrid#getAutoFitData autoFitData} is set to <code>"horizontal"</code> or  <code>"both"</code></li> <li>Any field has overflow set to <code>"visible"</code></li></ul> <P> Note that the <code>canFreezeFields</code> setting enables or disables the user interface for freezing and unfreezing fields only.  Fields can be programmatically frozen via setting {@link com.smartgwt.client.widgets.grid.ListGridField#getFrozen frozen} to true when the grid is created, or dynamically frozen and unfrozen via {@link com.smartgwt.client.widgets.grid.ListGrid#freezeField} and {@link com.smartgwt.client.widgets.grid.ListGrid#unfreezeField}.
    * Setter method for {@link com.smartgwt.client.widgets.grid.ListGrid#getCanFreezeFields canFreezeFields}
    *
    * @param canFreezeFields New value for <code>listGrid.canFreezeFields</code>. Default value is null
    */
    public void setCanFreezeFields(Boolean canFreezeFields) {
        setAttribute("canFreezeFields", canFreezeFields, true);
    }
    /**
     * Whether an interface should be shown to allow user is allowed to dynamically "freeze" or "unfreeze" columns with respect to horizontally scrolling. If unset, this property defaults to <code>true</code> unless:<ul> <li>{@link com.smartgwt.client.widgets.grid.ListGrid#getFixedRecordHeights fixedRecordHeights} is <code>false</code></li> <li>{@link com.smartgwt.client.widgets.grid.ListGrid#getBodyOverflow bodyOverflow} is <code>"visible"</code></li> <li>{@link com.smartgwt.client.widgets.grid.ListGrid#getAutoFitData autoFitData} is set to <code>"horizontal"</code> or  <code>"both"</code></li> <li>Any field has overflow set to <code>"visible"</code></li></ul> <P> Note that the <code>canFreezeFields</code> setting enables or disables the user interface for freezing and unfreezing fields only.  Fields can be programmatically frozen via setting {@link com.smartgwt.client.widgets.grid.ListGridField#getFrozen frozen} to true when the grid is created, or dynamically frozen and unfrozen via {@link com.smartgwt.client.widgets.grid.ListGrid#freezeField} and {@link com.smartgwt.client.widgets.grid.ListGrid#unfreezeField}.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getCanFreezeFields()  {
        return getAttributeAsBoolean("canFreezeFields");
    }

    /**
    * Whether to show a context menu on the header with standard items for showing and hiding fields.
    *
    * @param showHeaderContextMenu showHeaderContextMenu Default value is true
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setShowHeaderContextMenu(Boolean showHeaderContextMenu)  throws IllegalStateException {
        setAttribute("showHeaderContextMenu", showHeaderContextMenu, false);
    }
    /**
     * Whether to show a context menu on the header with standard items for showing and hiding fields.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getShowHeaderContextMenu()  {
        return getAttributeAsBoolean("showHeaderContextMenu");
    }

    /**
    * If set to true and {@link com.smartgwt.client.widgets.grid.ListGrid#getShowHeaderContextMenu showHeaderContextMenu} is true, the {@link com.smartgwt.client.widgets.grid.ListGrid#getHeaderMenuButton headerMenuButton} will be displayed when the user rolls over the header buttons in this grid.
    *
    * @param showHeaderMenuButton showHeaderMenuButton Default value is false
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setShowHeaderMenuButton(Boolean showHeaderMenuButton)  throws IllegalStateException {
        setAttribute("showHeaderMenuButton", showHeaderMenuButton, false);
    }
    /**
     * If set to true and {@link com.smartgwt.client.widgets.grid.ListGrid#getShowHeaderContextMenu showHeaderContextMenu} is true, the {@link com.smartgwt.client.widgets.grid.ListGrid#getHeaderMenuButton headerMenuButton} will be displayed when the user rolls over the header buttons in this grid.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getShowHeaderMenuButton()  {
        return getAttributeAsBoolean("showHeaderMenuButton");
    }

    /**
    * If {@link com.smartgwt.client.widgets.grid.ListGrid#getShowHeaderMenuButton showHeaderMenuButton} is true, this property governs the icon shown on the auto-generated <code>headerMenuButton</code>
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param headerMenuButtonIcon headerMenuButtonIcon Default value is "[SKIN]/ListGrid/sort_descending.gif"
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setHeaderMenuButtonIcon(String headerMenuButtonIcon)  throws IllegalStateException {
        setAttribute("headerMenuButtonIcon", headerMenuButtonIcon, false);
    }
    /**
     * If {@link com.smartgwt.client.widgets.grid.ListGrid#getShowHeaderMenuButton showHeaderMenuButton} is true, this property governs the icon shown on the auto-generated <code>headerMenuButton</code>
     *
     *
     * @return String
     *
     */
    public String getHeaderMenuButtonIcon()  {
        return getAttributeAsString("headerMenuButtonIcon");
    }

    /**
    * If {@link com.smartgwt.client.widgets.grid.ListGrid#getShowHeaderMenuButton showHeaderMenuButton} is true, this property governs the width of the icon shown on the auto-generated <code>headerMenuButton</code>
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param headerMenuButtonIconWidth headerMenuButtonIconWidth Default value is 7
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setHeaderMenuButtonIconWidth(int headerMenuButtonIconWidth)  throws IllegalStateException {
        setAttribute("headerMenuButtonIconWidth", headerMenuButtonIconWidth, false);
    }
    /**
     * If {@link com.smartgwt.client.widgets.grid.ListGrid#getShowHeaderMenuButton showHeaderMenuButton} is true, this property governs the width of the icon shown on the auto-generated <code>headerMenuButton</code>
     *
     *
     * @return int
     *
     */
    public int getHeaderMenuButtonIconWidth()  {
        return getAttributeAsInt("headerMenuButtonIconWidth");
    }

    /**
    * If {@link com.smartgwt.client.widgets.grid.ListGrid#getShowHeaderMenuButton showHeaderMenuButton} is true, this property governs the height of the icon shown on the auto-generated <code>headerMenuButton</code>
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param headerMenuButtonIconHeight headerMenuButtonIconHeight Default value is 7
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setHeaderMenuButtonIconHeight(int headerMenuButtonIconHeight)  throws IllegalStateException {
        setAttribute("headerMenuButtonIconHeight", headerMenuButtonIconHeight, false);
    }
    /**
     * If {@link com.smartgwt.client.widgets.grid.ListGrid#getShowHeaderMenuButton showHeaderMenuButton} is true, this property governs the height of the icon shown on the auto-generated <code>headerMenuButton</code>
     *
     *
     * @return int
     *
     */
    public int getHeaderMenuButtonIconHeight()  {
        return getAttributeAsInt("headerMenuButtonIconHeight");
    }

    /**
    * If {@link com.smartgwt.client.widgets.grid.ListGrid#getShowHeaderMenuButton showHeaderMenuButton} is true, this property governs the width of the  auto-generated <code>headerMenuButton</code>
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param headerMenuButtonWidth headerMenuButtonWidth Default value is 16
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setHeaderMenuButtonWidth(int headerMenuButtonWidth)  throws IllegalStateException {
        setAttribute("headerMenuButtonWidth", headerMenuButtonWidth, false);
    }
    /**
     * If {@link com.smartgwt.client.widgets.grid.ListGrid#getShowHeaderMenuButton showHeaderMenuButton} is true, this property governs the width of the  auto-generated <code>headerMenuButton</code>
     *
     *
     * @return int
     *
     */
    public int getHeaderMenuButtonWidth()  {
        return getAttributeAsInt("headerMenuButtonWidth");
    }

    /**
    * If {@link com.smartgwt.client.widgets.grid.ListGrid#getShowHeaderMenuButton showHeaderMenuButton} is true, this property governs the height of the  auto-generated <code>headerMenuButton</code>
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param headerMenuButtonHeight headerMenuButtonHeight Default value is "100%"
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setHeaderMenuButtonHeight(int headerMenuButtonHeight)  throws IllegalStateException {
        setAttribute("headerMenuButtonHeight", headerMenuButtonHeight, false);
    }
    /**
     * If {@link com.smartgwt.client.widgets.grid.ListGrid#getShowHeaderMenuButton showHeaderMenuButton} is true, this property governs the height of the  auto-generated <code>headerMenuButton</code>
     *
     *
     * @return int
     *
     */
    public int getHeaderMenuButtonHeight()  {
        return getAttributeAsInt("headerMenuButtonHeight");
    }

    /**
    * Indicates whether records can be dragged from this listGrid and dropped elsewhere.
    *
    * @param canDragRecordsOut canDragRecordsOut Default value is false
    */
    public void setCanDragRecordsOut(Boolean canDragRecordsOut) {
        setAttribute("canDragRecordsOut", canDragRecordsOut, true);
    }
    /**
     * Indicates whether records can be dragged from this listGrid and dropped elsewhere.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getCanDragRecordsOut()  {
        return getAttributeAsBoolean("canDragRecordsOut");
    }

    /**
    * Indicates whether records can be dropped into this listGrid.
    *
    * @param canAcceptDroppedRecords canAcceptDroppedRecords Default value is false
    */
    public void setCanAcceptDroppedRecords(Boolean canAcceptDroppedRecords) {
        setAttribute("canAcceptDroppedRecords", canAcceptDroppedRecords, true);
    }
    /**
     * Indicates whether records can be dropped into this listGrid.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getCanAcceptDroppedRecords()  {
        return getAttributeAsBoolean("canAcceptDroppedRecords");
    }

    /**
    * Indicates whether records can be reordered by dragging within this listGrid.
    *
    * @param canReorderRecords canReorderRecords Default value is false
    */
    public void setCanReorderRecords(Boolean canReorderRecords) {
        setAttribute("canReorderRecords", canReorderRecords, true);
    }
    /**
     * Indicates whether records can be reordered by dragging within this listGrid.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getCanReorderRecords()  {
        return getAttributeAsBoolean("canReorderRecords");
    }

    /**
    * Indicates whether fields in this listGrid can be reordered by dragging and          dropping header fields.
    *
    * @param canReorderFields canReorderFields Default value is true
    */
    public void setCanReorderFields(Boolean canReorderFields) {
        setAttribute("canReorderFields", canReorderFields, true);
    }
    /**
     * Indicates whether fields in this listGrid can be reordered by dragging and          dropping header fields.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getCanReorderFields()  {
        return getAttributeAsBoolean("canReorderFields");
    }

    /**
    * Indicates whether fields in this listGrid can be resized by dragging header          fields.
    * Setter method for updating {@link com.smartgwt.client.widgets.grid.ListGrid#getCanResizeFields canResizeFields} at runtime.
    *
    * @param canResizeFields new value for this.canResizeFields. Default value is true
    */
    public void setCanResizeFields(Boolean canResizeFields) {
        setAttribute("canResizeFields", canResizeFields, true);
    }
    /**
     * Indicates whether fields in this listGrid can be resized by dragging header          fields.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getCanResizeFields()  {
        return getAttributeAsBoolean("canResizeFields");
    }
             
    /**
    * When records are being dragged from within a ListGrid, what sort of drag-tracker should be displayed?<br> Note that if multiple records are being dragged the displayed tracker will be based on the first selected record.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param dragTrackerMode dragTrackerMode Default value is "icon"
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setDragTrackerMode(DragTrackerMode dragTrackerMode)  throws IllegalStateException {
        setAttribute("dragTrackerMode", dragTrackerMode.getValue(), false);
    }
    /**
     * When records are being dragged from within a ListGrid, what sort of drag-tracker should be displayed?<br> Note that if multiple records are being dragged the displayed tracker will be based on the first selected record.
     *
     *
     * @return DragTrackerMode
     *
     */
    public DragTrackerMode getDragTrackerMode()  {
        return (DragTrackerMode) EnumUtil.getEnum(DragTrackerMode.values(), getAttribute("dragTrackerMode"));
    }

    /**
    * True == we redraw the list viewer in real time as fields are being resized.  This can be slow with a large list and/or on some platforms.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param resizeFieldsInRealTime resizeFieldsInRealTime Default value is Browser.isIE && isc.Browser.isWin
    */
    public void setResizeFieldsInRealTime(Boolean resizeFieldsInRealTime) {
        setAttribute("resizeFieldsInRealTime", resizeFieldsInRealTime, true);
    }
    /**
     * True == we redraw the list viewer in real time as fields are being resized.  This can be slow with a large list and/or on some platforms.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getResizeFieldsInRealTime()  {
        return getAttributeAsBoolean("resizeFieldsInRealTime");
    }
             
    /**
    * Indicates what to do with data dragged into another DataBoundComponent. See          DragDataAction type for details.
    *
    * @param dragDataAction dragDataAction Default value is Canvas.MOVE
    */
    public void setDragDataAction(DragDataAction dragDataAction) {
        setAttribute("dragDataAction", dragDataAction.getValue(), true);
    }
    /**
     * Indicates what to do with data dragged into another DataBoundComponent. See          DragDataAction type for details.
     *
     *
     * @return DragDataAction
     *
     */
    public DragDataAction getDragDataAction()  {
        return (DragDataAction) EnumUtil.getEnum(DragDataAction.values(), getAttribute("dragDataAction"));
    }

    /**
    * Where do 'skin' images (those provided with the class) live?
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param skinImgDir skinImgDir Default value is "images/ListGrid/"
    */
    public void setSkinImgDir(String skinImgDir) {
        setAttribute("skinImgDir", skinImgDir, true);
    }
    /**
     * Where do 'skin' images (those provided with the class) live?
     *
     *
     * @return String
     *
     */
    public String getSkinImgDir()  {
        return getAttributeAsString("skinImgDir");
    }
            
    /**
    * Default image to use for the dragTracker when things are dragged within or out of this  list. See ${isc.DocUtils.linkForRef('object:ImgProperties')} for format.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param trackerImage trackerImage Default value is {...}
    */
    public void setTrackerImage(ImgProperties trackerImage) {
        setAttribute("trackerImage", trackerImage.getJsObj(), true);
    }
    /**
     * Default image to use for the dragTracker when things are dragged within or out of this  list. See ${isc.DocUtils.linkForRef('object:ImgProperties')} for format.
     *
     *
     * @return ImgProperties
     *
     */
    public ImgProperties getTrackerImage()  {
        return new ImgProperties(getAttributeAsJavaScriptObject("trackerImage"));
    }

    /**
    * Image to display for a true value in a boolean field. <P> To turn this off explicitly set {@link com.smartgwt.client.widgets.grid.ListGridField#getSuppressValueIcon suppressValueIcon} to true. <P> If this and {@link com.smartgwt.client.widgets.grid.ListGrid#getBooleanFalseImage booleanFalseImage} are undefined, this will be set to {@link com.smartgwt.client.widgets.form.fields.CheckboxItem#getCheckedImage checkedImage}.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param booleanTrueImage booleanTrueImage Default value is null
    */
    public void setBooleanTrueImage(String booleanTrueImage) {
        setAttribute("booleanTrueImage", booleanTrueImage, true);
    }
    /**
     * Image to display for a true value in a boolean field. <P> To turn this off explicitly set {@link com.smartgwt.client.widgets.grid.ListGridField#getSuppressValueIcon suppressValueIcon} to true. <P> If this and {@link com.smartgwt.client.widgets.grid.ListGrid#getBooleanFalseImage booleanFalseImage} are undefined, this will be set to {@link com.smartgwt.client.widgets.form.fields.CheckboxItem#getCheckedImage checkedImage}.
     *
     *
     * @return String
     *
     */
    public String getBooleanTrueImage()  {
        return getAttributeAsString("booleanTrueImage");
    }

    /**
    * Image to display for a false value in a boolean field. Default <code>null</code> value means no image will be displayed <P> To turn this off explicitly set {@link com.smartgwt.client.widgets.grid.ListGridField#getSuppressValueIcon suppressValueIcon} to true <P> If this and {@link com.smartgwt.client.widgets.grid.ListGrid#getBooleanTrueImage booleanTrueImage} are undefined, this will be set to {@link com.smartgwt.client.widgets.form.fields.CheckboxItem#getUncheckedImage uncheckedImage}.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param booleanFalseImage booleanFalseImage Default value is null
    */
    public void setBooleanFalseImage(String booleanFalseImage) {
        setAttribute("booleanFalseImage", booleanFalseImage, true);
    }
    /**
     * Image to display for a false value in a boolean field. Default <code>null</code> value means no image will be displayed <P> To turn this off explicitly set {@link com.smartgwt.client.widgets.grid.ListGridField#getSuppressValueIcon suppressValueIcon} to true <P> If this and {@link com.smartgwt.client.widgets.grid.ListGrid#getBooleanTrueImage booleanTrueImage} are undefined, this will be set to {@link com.smartgwt.client.widgets.form.fields.CheckboxItem#getUncheckedImage uncheckedImage}.
     *
     *
     * @return String
     *
     */
    public String getBooleanFalseImage()  {
        return getAttributeAsString("booleanFalseImage");
    }

    /**
    * Width for the {@link com.smartgwt.client.widgets.grid.ListGrid#getBooleanTrueImage booleanTrueImage} and {@link com.smartgwt.client.widgets.grid.ListGrid#getBooleanFalseImage booleanFalseImage}
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param booleanImageWidth booleanImageWidth Default value is 16
    */
    public void setBooleanImageWidth(int booleanImageWidth) {
        setAttribute("booleanImageWidth", booleanImageWidth, true);
    }
    /**
     * Width for the {@link com.smartgwt.client.widgets.grid.ListGrid#getBooleanTrueImage booleanTrueImage} and {@link com.smartgwt.client.widgets.grid.ListGrid#getBooleanFalseImage booleanFalseImage}
     *
     *
     * @return int
     *
     */
    public int getBooleanImageWidth()  {
        return getAttributeAsInt("booleanImageWidth");
    }

    /**
    * Height for the {@link com.smartgwt.client.widgets.grid.ListGrid#getBooleanTrueImage booleanTrueImage} and the {@link com.smartgwt.client.widgets.grid.ListGrid#getBooleanFalseImage booleanFalseImage}
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param booleanImageHeight booleanImageHeight Default value is 16
    */
    public void setBooleanImageHeight(int booleanImageHeight) {
        setAttribute("booleanImageHeight", booleanImageHeight, true);
    }
    /**
     * Height for the {@link com.smartgwt.client.widgets.grid.ListGrid#getBooleanTrueImage booleanTrueImage} and the {@link com.smartgwt.client.widgets.grid.ListGrid#getBooleanFalseImage booleanFalseImage}
     *
     *
     * @return int
     *
     */
    public int getBooleanImageHeight()  {
        return getAttributeAsInt("booleanImageHeight");
    }

    /**
    * CSS Style to apply to the drag tracker when dragging occurs on this grid.
    *
    * @param dragTrackerStyle dragTrackerStyle Default value is "gridDragTracker"
    */
    public void setDragTrackerStyle(String dragTrackerStyle) {
        setAttribute("dragTrackerStyle", dragTrackerStyle, true);
    }
    /**
     * CSS Style to apply to the drag tracker when dragging occurs on this grid.
     *
     *
     * @return String
     *
     */
    public String getDragTrackerStyle()  {
        return getAttributeAsString("dragTrackerStyle");
    }

    /**
    * If we're showing a {@link com.smartgwt.client.widgets.grid.ListGrid#getShowHeaderContextMenu showHeaderContextMenu} for this grid and {@link com.smartgwt.client.widgets.grid.ListGrid#getCanFreezeFields canFreezeFields} is true, this string will be shown as the title for the menu item to freeze fields on the right of the scrollable body.
    *
    * @param freezeOnRightText freezeOnRightText Default value is "Freeze on right"
    */
    public void setFreezeOnRightText(String freezeOnRightText) {
        setAttribute("freezeOnRightText", freezeOnRightText, true);
    }
    /**
     * If we're showing a {@link com.smartgwt.client.widgets.grid.ListGrid#getShowHeaderContextMenu showHeaderContextMenu} for this grid and {@link com.smartgwt.client.widgets.grid.ListGrid#getCanFreezeFields canFreezeFields} is true, this string will be shown as the title for the menu item to freeze fields on the right of the scrollable body.
     *
     *
     * @return String
     *
     */
    public String getFreezeOnRightText()  {
        return getAttributeAsString("freezeOnRightText");
    }

    /**
    * If we're showing a {@link com.smartgwt.client.widgets.grid.ListGrid#getShowHeaderContextMenu showHeaderContextMenu} for this grid and {@link com.smartgwt.client.widgets.grid.ListGrid#getCanFreezeFields canFreezeFields} is true, this string will be shown as the title for the menu item to freeze fields on the left of the scrollable body.
    *
    * @param freezeOnLeftText freezeOnLeftText Default value is "Freeze on left"
    */
    public void setFreezeOnLeftText(String freezeOnLeftText) {
        setAttribute("freezeOnLeftText", freezeOnLeftText, true);
    }
    /**
     * If we're showing a {@link com.smartgwt.client.widgets.grid.ListGrid#getShowHeaderContextMenu showHeaderContextMenu} for this grid and {@link com.smartgwt.client.widgets.grid.ListGrid#getCanFreezeFields canFreezeFields} is true, this string will be shown as the title for the menu item to freeze fields on the left of the scrollable body.
     *
     *
     * @return String
     *
     */
    public String getFreezeOnLeftText()  {
        return getAttributeAsString("freezeOnLeftText");
    }

    /**
    * If we're showing a {@link com.smartgwt.client.widgets.grid.ListGrid#getShowHeaderContextMenu showHeaderContextMenu} for this grid, this attribute will be shown as the menu item title to sort a field in ascending order.
    *
    * @param sortFieldAscendingText sortFieldAscendingText Default value is "Sort Ascending"
    */
    public void setSortFieldAscendingText(String sortFieldAscendingText) {
        setAttribute("sortFieldAscendingText", sortFieldAscendingText, true);
    }
    /**
     * If we're showing a {@link com.smartgwt.client.widgets.grid.ListGrid#getShowHeaderContextMenu showHeaderContextMenu} for this grid, this attribute will be shown as the menu item title to sort a field in ascending order.
     *
     *
     * @return String
     *
     */
    public String getSortFieldAscendingText()  {
        return getAttributeAsString("sortFieldAscendingText");
    }

    /**
    * If we're showing a {@link com.smartgwt.client.widgets.grid.ListGrid#getShowHeaderContextMenu showHeaderContextMenu} for this grid, this attribute will be shown as the menu item title to sort a field in descending order.
    *
    * @param sortFieldDescendingText sortFieldDescendingText Default value is "Sort Descending"
    */
    public void setSortFieldDescendingText(String sortFieldDescendingText) {
        setAttribute("sortFieldDescendingText", sortFieldDescendingText, true);
    }
    /**
     * If we're showing a {@link com.smartgwt.client.widgets.grid.ListGrid#getShowHeaderContextMenu showHeaderContextMenu} for this grid, this attribute will be shown as the menu item title to sort a field in descending order.
     *
     *
     * @return String
     *
     */
    public String getSortFieldDescendingText()  {
        return getAttributeAsString("sortFieldDescendingText");
    }

    /**
    * If we're showing a {@link com.smartgwt.client.widgets.grid.ListGrid#getShowHeaderContextMenu showHeaderContextMenu} for this grid, and {@link com.smartgwt.client.widgets.grid.ListGrid#getCanPickFields canPickFields} is true, this attribute will be shown as the title for the menu item which contains a submenu with items  allowing the user to show and hide fields in the grid.
    *
    * @param fieldVisibilitySubmenuTitle fieldVisibilitySubmenuTitle Default value is "Columns"
    */
    public void setFieldVisibilitySubmenuTitle(String fieldVisibilitySubmenuTitle) {
        setAttribute("fieldVisibilitySubmenuTitle", fieldVisibilitySubmenuTitle, true);
    }
    /**
     * If we're showing a {@link com.smartgwt.client.widgets.grid.ListGrid#getShowHeaderContextMenu showHeaderContextMenu} for this grid, and {@link com.smartgwt.client.widgets.grid.ListGrid#getCanPickFields canPickFields} is true, this attribute will be shown as the title for the menu item which contains a submenu with items  allowing the user to show and hide fields in the grid.
     *
     *
     * @return String
     *
     */
    public String getFieldVisibilitySubmenuTitle()  {
        return getAttributeAsString("fieldVisibilitySubmenuTitle");
    }

    /**
    * If we're showing a {@link com.smartgwt.client.widgets.grid.ListGrid#getShowHeaderContextMenu showHeaderContextMenu} for this grid and {@link com.smartgwt.client.widgets.grid.ListGrid#getCanFreezeFields canFreezeFields} is true, this string will be shown as the title for the menu item to freeze a currently unfrozen field. <P> This is a dynamic string - text within <code>\${...}</code> will be evaluated as JS code when the message is displayed, with <code>viewer</code> available as a variable mapped to the ListGrid instance, and <code>field</code> as a variable pointing to the ListGrid field. <P> Default value returns "Freeze " + the field's summary title.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param freezeFieldText freezeFieldText Default value is "Freeze \${viewer.getSummaryTitle(field)}"
    */
    public void setFreezeFieldText(String freezeFieldText) {
        setAttribute("freezeFieldText", freezeFieldText, true);
    }
    /**
     * If we're showing a {@link com.smartgwt.client.widgets.grid.ListGrid#getShowHeaderContextMenu showHeaderContextMenu} for this grid and {@link com.smartgwt.client.widgets.grid.ListGrid#getCanFreezeFields canFreezeFields} is true, this string will be shown as the title for the menu item to freeze a currently unfrozen field. <P> This is a dynamic string - text within <code>\${...}</code> will be evaluated as JS code when the message is displayed, with <code>viewer</code> available as a variable mapped to the ListGrid instance, and <code>field</code> as a variable pointing to the ListGrid field. <P> Default value returns "Freeze " + the field's summary title.
     *
     *
     * @return String
     *
     */
    public String getFreezeFieldText()  {
        return getAttributeAsString("freezeFieldText");
    }

    /**
    * If we're showing a {@link com.smartgwt.client.widgets.grid.ListGrid#getShowHeaderContextMenu showHeaderContextMenu} for this grid and {@link com.smartgwt.client.widgets.grid.ListGrid#getCanFreezeFields canFreezeFields} is true, this string will be shown as the title for the menu item to unfreeze a currently frozen field. <P> This is a dynamic string - text within <code>\${...}</code> will be evaluated as JS code when the message is displayed, with <code>viewer</code> available as a variable mapped to the ListGrid instance, and <code>field</code> as a variable pointing to the ListGrid field. <P> Default value returns "Unfreeze " + the field's summary title.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param unfreezeFieldText unfreezeFieldText Default value is "Unfreeze \${viewer.getSummaryTitle(field)}"
    */
    public void setUnfreezeFieldText(String unfreezeFieldText) {
        setAttribute("unfreezeFieldText", unfreezeFieldText, true);
    }
    /**
     * If we're showing a {@link com.smartgwt.client.widgets.grid.ListGrid#getShowHeaderContextMenu showHeaderContextMenu} for this grid and {@link com.smartgwt.client.widgets.grid.ListGrid#getCanFreezeFields canFreezeFields} is true, this string will be shown as the title for the menu item to unfreeze a currently frozen field. <P> This is a dynamic string - text within <code>\${...}</code> will be evaluated as JS code when the message is displayed, with <code>viewer</code> available as a variable mapped to the ListGrid instance, and <code>field</code> as a variable pointing to the ListGrid field. <P> Default value returns "Unfreeze " + the field's summary title.
     *
     *
     * @return String
     *
     */
    public String getUnfreezeFieldText()  {
        return getAttributeAsString("unfreezeFieldText");
    }

    /**
    * If we're showing a {@link com.smartgwt.client.widgets.grid.ListGrid#getShowHeaderContextMenu showHeaderContextMenu} for this grid and {@link com.smartgwt.client.widgets.grid.ListGrid#getCanGroupBy canGroupBy} is true, this string will be shown as the title for the menu item to toggle the group by setting for a field. <P> This is a dynamic string - text within <code>\${...}</code> will be evaluated as JS code when the message is displayed, with <code>viewer</code> available as a variable mapped to the ListGrid instance, and <code>field</code> as a variable pointing to the ListGrid field. <P> Default value returns "Group by " + the field's summary title.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param groupByText groupByText Default value is "Group by \${viewer.getSummaryTitle(field)}"
    */
    public void setGroupByText(String groupByText) {
        setAttribute("groupByText", groupByText, true);
    }
    /**
     * If we're showing a {@link com.smartgwt.client.widgets.grid.ListGrid#getShowHeaderContextMenu showHeaderContextMenu} for this grid and {@link com.smartgwt.client.widgets.grid.ListGrid#getCanGroupBy canGroupBy} is true, this string will be shown as the title for the menu item to toggle the group by setting for a field. <P> This is a dynamic string - text within <code>\${...}</code> will be evaluated as JS code when the message is displayed, with <code>viewer</code> available as a variable mapped to the ListGrid instance, and <code>field</code> as a variable pointing to the ListGrid field. <P> Default value returns "Group by " + the field's summary title.
     *
     *
     * @return If we're showing a {@link com.smartgwt.client.widgets.grid.ListGrid#getShowHeaderContextMenu showHeaderContextMenu} for this grid and {@link com.smartgwt.client.widgets.grid.ListGrid#getCanGroupBy canGroupBy} is true, this string will be shown as the title for the menu item to toggle the group by setting for a field.<br> Default implementation evaulates and returns the dynamic {@link com.smartgwt.client.widgets.grid.ListGrid#getGroupByText groupByText} string.
     *
     */
    public String getGroupByText()  {
        return getAttributeAsString("groupByText");
    }

    /**
    * If we're showing a {@link com.smartgwt.client.widgets.grid.ListGrid#getShowHeaderContextMenu showHeaderContextMenu} for this grid, and {@link com.smartgwt.client.widgets.grid.ListGrid#getIsGrouped isGrouped} is true, this attribute will be shown as the title for the menu item to ungroup the grid.
    *
    * @param ungroupText ungroupText Default value is "Ungroup"
    */
    public void setUngroupText(String ungroupText) {
        setAttribute("ungroupText", ungroupText, true);
    }
    /**
     * If we're showing a {@link com.smartgwt.client.widgets.grid.ListGrid#getShowHeaderContextMenu showHeaderContextMenu} for this grid, and {@link com.smartgwt.client.widgets.grid.ListGrid#getIsGrouped isGrouped} is true, this attribute will be shown as the title for the menu item to ungroup the grid.
     *
     *
     * @return String
     *
     */
    public String getUngroupText()  {
        return getAttributeAsString("ungroupText");
    }

    // ********************* Methods ***********************


        /**
         * Uses a "fetch" operation on the current {@link com.smartgwt.client.data.DataSource} to retrieve data that matches the current filter and sort criteria for this component, then exports the  resulting data to a file or window in the requested format. <P> This method takes an optional callback parameter (set to a ${isc.DocUtils.linkForRef('type:DSCallback')}) to fire when the fetch completes. <P>
         */
        public native void exportData() /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.exportData();
        }-*/;

        /**
         * Uses a "fetch" operation on the current {@link com.smartgwt.client.data.DataSource} to retrieve data that matches the current filter and sort criteria for this component, then exports the  resulting data to a file or window in the requested format. <P> This method takes an optional callback parameter (set to a ${isc.DocUtils.linkForRef('type:DSCallback')}) to fire when the fetch completes. <P>
         * @param callback callback to invoke when a export is complete. Fires                                          only if server contact was required
     * @param requestProperties additional properties to set on the DSRequest                                            that will be issued
         */
        public native void exportData(DSCallback callback, DSRequest requestProperties) /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.exportData(callback, requestProperties.@com.smartgwt.client.core.DataClass::getJsObj()());
        }-*/;




        /**
         * Invalidate the current data cache for this databound component via a call to <code>this.data.invalidateCache()</code>. If necessary, this will cause a new fetch to  be performed with the current set of criteria for this component. <P> Has no effect if this component is not showing a set of filtered data.
         */
        public native void invalidateCache() /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.invalidateCache();
        }-*/;





        /**
         * Return the first selected record in this component.<br><br> This method is appropriate if <code>{@link com.smartgwt.client.widgets.grid.ListGrid#getSelectionType selectionType}</code> is <code>"single"</code>, or if you only care about the first selected record in a multiple-record selection. To access all selected records, use <code>{@link com.smartgwt.client.widgets.grid.ListGrid#getSelection}</code> instead.
         *
         * @return first selected record, or null if nothing selected
         */
        public native ListGridRecord getSelectedRecord() /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            var ret = self.getSelectedRecord();
            if(ret == null || ret === undefined) return null;
            var retVal = @com.smartgwt.client.core.RefDataClass::getRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
            if(retVal == null) {
                retVal = @com.smartgwt.client.widgets.grid.ListGridRecord::new(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
            }
            return retVal;
        }-*/;





        /**
         * Refresh the styling of an individual cell without redrawing the grid. <P> The cell's CSS class and CSS text will be refreshed, to the current values returned by getCellStyle() and getCellCSSText() respectively. <P> The cell's contents (as returned by getCellValue()) will <b>not</b> be refreshed.  To refresh both styling and contents, call refreshCell() instead.
         * @param rowNum row number of cell to refresh
     * @param colNum column number of cell to refresh
         */
        public native void refreshCellStyle(int rowNum, int colNum) /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.refreshCellStyle(rowNum, colNum);
        }-*/;




        /**
         * Add a cellOver handler.
         *
         * @param handler the cellOver handler
         */
        public HandlerRegistration addCellOverHandler(com.smartgwt.client.widgets.grid.events.CellOverHandler handler) {
            if(manager.getHandlerCount(com.smartgwt.client.widgets.grid.events.CellOverEvent.getType()) == 0) setupCellOverEvent();
            return manager.addHandler(com.smartgwt.client.widgets.grid.events.CellOverEvent.getType(), handler);
        }
        private native void setupCellOverEvent() /*-{
            var obj = null;
            var managerJ = this.@com.smartgwt.client.widgets.BaseWidget::manager;
            if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
                obj.addProperties({cellOver:function(){
                        var param = {"record" : arguments[0], "rowNum" : arguments[1], "colNum" : arguments[2]};
                        var event = @com.smartgwt.client.widgets.grid.events.CellOverEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        managerJ.@com.google.gwt.event.shared.HandlerManager::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                        var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                        return !ret;
                    }
                });
            } else {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
                obj.cellOver = function(){
                    var param = {"record" : arguments[0], "rowNum" : arguments[1], "colNum" : arguments[2]};
                    var event = @com.smartgwt.client.widgets.grid.events.CellOverEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    managerJ.@com.google.gwt.event.shared.HandlerManager::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                    return !ret;
                };
            }
        }-*/;




        /**
         * Add a rowOver handler.
         *
         * @param handler the rowOver handler
         */
        public HandlerRegistration addRowOverHandler(com.smartgwt.client.widgets.grid.events.RowOverHandler handler) {
            if(manager.getHandlerCount(com.smartgwt.client.widgets.grid.events.RowOverEvent.getType()) == 0) setupRowOverEvent();
            return manager.addHandler(com.smartgwt.client.widgets.grid.events.RowOverEvent.getType(), handler);
        }
        private native void setupRowOverEvent() /*-{
            var obj = null;
            var managerJ = this.@com.smartgwt.client.widgets.BaseWidget::manager;
            if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
                obj.addProperties({rowOver:function(){
                        var param = {"record" : arguments[0], "rowNum" : arguments[1], "colNum" : arguments[2]};
                        var event = @com.smartgwt.client.widgets.grid.events.RowOverEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        managerJ.@com.google.gwt.event.shared.HandlerManager::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                        var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                        return !ret;
                    }
                });
            } else {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
                obj.rowOver = function(){
                    var param = {"record" : arguments[0], "rowNum" : arguments[1], "colNum" : arguments[2]};
                    var event = @com.smartgwt.client.widgets.grid.events.RowOverEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    managerJ.@com.google.gwt.event.shared.HandlerManager::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                    return !ret;
                };
            }
        }-*/;




        /**
         * Add a cellOut handler.
         *
         * @param handler the cellOut handler
         */
        public HandlerRegistration addCellOutHandler(com.smartgwt.client.widgets.grid.events.CellOutHandler handler) {
            if(manager.getHandlerCount(com.smartgwt.client.widgets.grid.events.CellOutEvent.getType()) == 0) setupCellOutEvent();
            return manager.addHandler(com.smartgwt.client.widgets.grid.events.CellOutEvent.getType(), handler);
        }
        private native void setupCellOutEvent() /*-{
            var obj = null;
            var managerJ = this.@com.smartgwt.client.widgets.BaseWidget::manager;
            if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
                obj.addProperties({cellOut:function(){
                        var param = {"record" : arguments[0], "rowNum" : arguments[1], "colNum" : arguments[2]};
                        var event = @com.smartgwt.client.widgets.grid.events.CellOutEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        managerJ.@com.google.gwt.event.shared.HandlerManager::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                        var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                        return !ret;
                    }
                });
            } else {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
                obj.cellOut = function(){
                    var param = {"record" : arguments[0], "rowNum" : arguments[1], "colNum" : arguments[2]};
                    var event = @com.smartgwt.client.widgets.grid.events.CellOutEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    managerJ.@com.google.gwt.event.shared.HandlerManager::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                    return !ret;
                };
            }
        }-*/;




        /**
         * Add a rowOut handler.
         *
         * @param handler the rowOut handler
         */
        public HandlerRegistration addRowOutHandler(com.smartgwt.client.widgets.grid.events.RowOutHandler handler) {
            if(manager.getHandlerCount(com.smartgwt.client.widgets.grid.events.RowOutEvent.getType()) == 0) setupRowOutEvent();
            return manager.addHandler(com.smartgwt.client.widgets.grid.events.RowOutEvent.getType(), handler);
        }
        private native void setupRowOutEvent() /*-{
            var obj = null;
            var managerJ = this.@com.smartgwt.client.widgets.BaseWidget::manager;
            if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
                obj.addProperties({rowOut:function(){
                        var param = {"record" : arguments[0], "rowNum" : arguments[1], "colNum" : arguments[2]};
                        var event = @com.smartgwt.client.widgets.grid.events.RowOutEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        managerJ.@com.google.gwt.event.shared.HandlerManager::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                        var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                        return !ret;
                    }
                });
            } else {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
                obj.rowOut = function(){
                    var param = {"record" : arguments[0], "rowNum" : arguments[1], "colNum" : arguments[2]};
                    var event = @com.smartgwt.client.widgets.grid.events.RowOutEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    managerJ.@com.google.gwt.event.shared.HandlerManager::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                    return !ret;
                };
            }
        }-*/;




        /**
         * Add a cellHover handler.
         *
         * @param handler the cellHover handler
         */
        public HandlerRegistration addCellHoverHandler(com.smartgwt.client.widgets.grid.events.CellHoverHandler handler) {
            if(manager.getHandlerCount(com.smartgwt.client.widgets.grid.events.CellHoverEvent.getType()) == 0) setupCellHoverEvent();
            return manager.addHandler(com.smartgwt.client.widgets.grid.events.CellHoverEvent.getType(), handler);
        }
        private native void setupCellHoverEvent() /*-{
            var obj = null;
            var managerJ = this.@com.smartgwt.client.widgets.BaseWidget::manager;
            if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
                obj.addProperties({cellHover:function(){
                        var param = {"record" : arguments[0], "rowNum" : arguments[1], "colNum" : arguments[2]};
                        var event = @com.smartgwt.client.widgets.grid.events.CellHoverEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        managerJ.@com.google.gwt.event.shared.HandlerManager::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                        var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                        return !ret;
                    }
                });
            } else {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
                obj.cellHover = function(){
                    var param = {"record" : arguments[0], "rowNum" : arguments[1], "colNum" : arguments[2]};
                    var event = @com.smartgwt.client.widgets.grid.events.CellHoverEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    managerJ.@com.google.gwt.event.shared.HandlerManager::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                    return !ret;
                };
            }
        }-*/;




        /**
         * Add a rowHover handler.
         *
         * @param handler the rowHover handler
         */
        public HandlerRegistration addRowHoverHandler(com.smartgwt.client.widgets.grid.events.RowHoverHandler handler) {
            if(manager.getHandlerCount(com.smartgwt.client.widgets.grid.events.RowHoverEvent.getType()) == 0) setupRowHoverEvent();
            return manager.addHandler(com.smartgwt.client.widgets.grid.events.RowHoverEvent.getType(), handler);
        }
        private native void setupRowHoverEvent() /*-{
            var obj = null;
            var managerJ = this.@com.smartgwt.client.widgets.BaseWidget::manager;
            if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
                obj.addProperties({rowHover:function(){
                        var param = {"record" : arguments[0], "rowNum" : arguments[1], "colNum" : arguments[2]};
                        var event = @com.smartgwt.client.widgets.grid.events.RowHoverEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        managerJ.@com.google.gwt.event.shared.HandlerManager::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                        var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                        return !ret;
                    }
                });
            } else {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
                obj.rowHover = function(){
                    var param = {"record" : arguments[0], "rowNum" : arguments[1], "colNum" : arguments[2]};
                    var event = @com.smartgwt.client.widgets.grid.events.RowHoverEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    managerJ.@com.google.gwt.event.shared.HandlerManager::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                    return !ret;
                };
            }
        }-*/;





        /**
         * Add a cellContextClick handler.
         *
         * @param handler the cellContextClick handler
         */
        public HandlerRegistration addCellContextClickHandler(com.smartgwt.client.widgets.grid.events.CellContextClickHandler handler) {
            if(manager.getHandlerCount(com.smartgwt.client.widgets.grid.events.CellContextClickEvent.getType()) == 0) setupCellContextClickEvent();
            return manager.addHandler(com.smartgwt.client.widgets.grid.events.CellContextClickEvent.getType(), handler);
        }
        private native void setupCellContextClickEvent() /*-{
            var obj = null;
            var managerJ = this.@com.smartgwt.client.widgets.BaseWidget::manager;
            if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
                obj.addProperties({cellContextClick:function(){
                        var param = {"record" : arguments[0], "rowNum" : arguments[1], "colNum" : arguments[2]};
                        var event = @com.smartgwt.client.widgets.grid.events.CellContextClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        managerJ.@com.google.gwt.event.shared.HandlerManager::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                        var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                        return !ret;
                    }
                });
            } else {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
                obj.cellContextClick = function(){
                    var param = {"record" : arguments[0], "rowNum" : arguments[1], "colNum" : arguments[2]};
                    var event = @com.smartgwt.client.widgets.grid.events.CellContextClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    managerJ.@com.google.gwt.event.shared.HandlerManager::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                    return !ret;
                };
            }
        }-*/;




        /**
         * Add a rowContextClick handler.
         *
         * @param handler the rowContextClick handler
         */
        public HandlerRegistration addRowContextClickHandler(com.smartgwt.client.widgets.grid.events.RowContextClickHandler handler) {
            if(manager.getHandlerCount(com.smartgwt.client.widgets.grid.events.RowContextClickEvent.getType()) == 0) setupRowContextClickEvent();
            return manager.addHandler(com.smartgwt.client.widgets.grid.events.RowContextClickEvent.getType(), handler);
        }
        private native void setupRowContextClickEvent() /*-{
            var obj = null;
            var managerJ = this.@com.smartgwt.client.widgets.BaseWidget::manager;
            if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
                obj.addProperties({rowContextClick:function(){
                        var param = {"record" : arguments[0], "rowNum" : arguments[1], "colNum" : arguments[2]};
                        var event = @com.smartgwt.client.widgets.grid.events.RowContextClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        managerJ.@com.google.gwt.event.shared.HandlerManager::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                        var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                        return !ret;
                    }
                });
            } else {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
                obj.rowContextClick = function(){
                    var param = {"record" : arguments[0], "rowNum" : arguments[1], "colNum" : arguments[2]};
                    var event = @com.smartgwt.client.widgets.grid.events.RowContextClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    managerJ.@com.google.gwt.event.shared.HandlerManager::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                    return !ret;
                };
            }
        }-*/;




        /**
         * Add a cellMouseDown handler.
         *
         * @param handler the cellMouseDown handler
         */
        public HandlerRegistration addCellMouseDownHandler(com.smartgwt.client.widgets.grid.events.CellMouseDownHandler handler) {
            if(manager.getHandlerCount(com.smartgwt.client.widgets.grid.events.CellMouseDownEvent.getType()) == 0) setupCellMouseDownEvent();
            return manager.addHandler(com.smartgwt.client.widgets.grid.events.CellMouseDownEvent.getType(), handler);
        }
        private native void setupCellMouseDownEvent() /*-{
            var obj = null;
            var managerJ = this.@com.smartgwt.client.widgets.BaseWidget::manager;
            if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
                obj.addProperties({cellMouseDown:function(){
                        var param = {"record" : arguments[0], "rowNum" : arguments[1], "colNum" : arguments[2]};
                        var event = @com.smartgwt.client.widgets.grid.events.CellMouseDownEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        managerJ.@com.google.gwt.event.shared.HandlerManager::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                        var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                        return !ret;
                    }
                });
            } else {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
                obj.cellMouseDown = function(){
                    var param = {"record" : arguments[0], "rowNum" : arguments[1], "colNum" : arguments[2]};
                    var event = @com.smartgwt.client.widgets.grid.events.CellMouseDownEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    managerJ.@com.google.gwt.event.shared.HandlerManager::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                    return !ret;
                };
            }
        }-*/;




        /**
         * Add a rowMouseDown handler.
         *
         * @param handler the rowMouseDown handler
         */
        public HandlerRegistration addRowMouseDownHandler(com.smartgwt.client.widgets.grid.events.RowMouseDownHandler handler) {
            if(manager.getHandlerCount(com.smartgwt.client.widgets.grid.events.RowMouseDownEvent.getType()) == 0) setupRowMouseDownEvent();
            return manager.addHandler(com.smartgwt.client.widgets.grid.events.RowMouseDownEvent.getType(), handler);
        }
        private native void setupRowMouseDownEvent() /*-{
            var obj = null;
            var managerJ = this.@com.smartgwt.client.widgets.BaseWidget::manager;
            if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
                obj.addProperties({rowMouseDown:function(){
                        var param = {"record" : arguments[0], "rowNum" : arguments[1], "colNum" : arguments[2]};
                        var event = @com.smartgwt.client.widgets.grid.events.RowMouseDownEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        managerJ.@com.google.gwt.event.shared.HandlerManager::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                        var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                        return !ret;
                    }
                });
            } else {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
                obj.rowMouseDown = function(){
                    var param = {"record" : arguments[0], "rowNum" : arguments[1], "colNum" : arguments[2]};
                    var event = @com.smartgwt.client.widgets.grid.events.RowMouseDownEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    managerJ.@com.google.gwt.event.shared.HandlerManager::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                    return !ret;
                };
            }
        }-*/;




        /**
         * Add a cellMouseUp handler.
         *
         * @param handler the cellMouseUp handler
         */
        public HandlerRegistration addCellMouseUpHandler(com.smartgwt.client.widgets.grid.events.CellMouseUpHandler handler) {
            if(manager.getHandlerCount(com.smartgwt.client.widgets.grid.events.CellMouseUpEvent.getType()) == 0) setupCellMouseUpEvent();
            return manager.addHandler(com.smartgwt.client.widgets.grid.events.CellMouseUpEvent.getType(), handler);
        }
        private native void setupCellMouseUpEvent() /*-{
            var obj = null;
            var managerJ = this.@com.smartgwt.client.widgets.BaseWidget::manager;
            if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
                obj.addProperties({cellMouseUp:function(){
                        var param = {"record" : arguments[0], "rowNum" : arguments[1], "colNum" : arguments[2]};
                        var event = @com.smartgwt.client.widgets.grid.events.CellMouseUpEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        managerJ.@com.google.gwt.event.shared.HandlerManager::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                        var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                        return !ret;
                    }
                });
            } else {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
                obj.cellMouseUp = function(){
                    var param = {"record" : arguments[0], "rowNum" : arguments[1], "colNum" : arguments[2]};
                    var event = @com.smartgwt.client.widgets.grid.events.CellMouseUpEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    managerJ.@com.google.gwt.event.shared.HandlerManager::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                    return !ret;
                };
            }
        }-*/;




        /**
         * Add a rowMouseUp handler.
         *
         * @param handler the rowMouseUp handler
         */
        public HandlerRegistration addRowMouseUpHandler(com.smartgwt.client.widgets.grid.events.RowMouseUpHandler handler) {
            if(manager.getHandlerCount(com.smartgwt.client.widgets.grid.events.RowMouseUpEvent.getType()) == 0) setupRowMouseUpEvent();
            return manager.addHandler(com.smartgwt.client.widgets.grid.events.RowMouseUpEvent.getType(), handler);
        }
        private native void setupRowMouseUpEvent() /*-{
            var obj = null;
            var managerJ = this.@com.smartgwt.client.widgets.BaseWidget::manager;
            if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
                obj.addProperties({rowMouseUp:function(){
                        var param = {"record" : arguments[0], "rowNum" : arguments[1], "colNum" : arguments[2]};
                        var event = @com.smartgwt.client.widgets.grid.events.RowMouseUpEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        managerJ.@com.google.gwt.event.shared.HandlerManager::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                        var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                        return !ret;
                    }
                });
            } else {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
                obj.rowMouseUp = function(){
                    var param = {"record" : arguments[0], "rowNum" : arguments[1], "colNum" : arguments[2]};
                    var event = @com.smartgwt.client.widgets.grid.events.RowMouseUpEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    managerJ.@com.google.gwt.event.shared.HandlerManager::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                    return !ret;
                };
            }
        }-*/;




        /**
         * Add a cellClick handler.
         *
         * @param handler the cellClick handler
         */
        public HandlerRegistration addCellClickHandler(com.smartgwt.client.widgets.grid.events.CellClickHandler handler) {
            if(manager.getHandlerCount(com.smartgwt.client.widgets.grid.events.CellClickEvent.getType()) == 0) setupCellClickEvent();
            return manager.addHandler(com.smartgwt.client.widgets.grid.events.CellClickEvent.getType(), handler);
        }
        private native void setupCellClickEvent() /*-{
            var obj = null;
            var managerJ = this.@com.smartgwt.client.widgets.BaseWidget::manager;
            if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
                obj.addProperties({cellClick:function(){
                        var param = {"record" : arguments[0], "rowNum" : arguments[1], "colNum" : arguments[2]};
                        var event = @com.smartgwt.client.widgets.grid.events.CellClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        managerJ.@com.google.gwt.event.shared.HandlerManager::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                        var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                        return !ret;
                    }
                });
            } else {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
                obj.cellClick = function(){
                    var param = {"record" : arguments[0], "rowNum" : arguments[1], "colNum" : arguments[2]};
                    var event = @com.smartgwt.client.widgets.grid.events.CellClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    managerJ.@com.google.gwt.event.shared.HandlerManager::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                    return !ret;
                };
            }
        }-*/;




        /**
         * Add a cellDoubleClick handler.
         *
         * @param handler the cellDoubleClick handler
         */
        public HandlerRegistration addCellDoubleClickHandler(com.smartgwt.client.widgets.grid.events.CellDoubleClickHandler handler) {
            if(manager.getHandlerCount(com.smartgwt.client.widgets.grid.events.CellDoubleClickEvent.getType()) == 0) setupCellDoubleClickEvent();
            return manager.addHandler(com.smartgwt.client.widgets.grid.events.CellDoubleClickEvent.getType(), handler);
        }
        private native void setupCellDoubleClickEvent() /*-{
            var obj = null;
            var managerJ = this.@com.smartgwt.client.widgets.BaseWidget::manager;
            if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
                obj.addProperties({cellDoubleClick:function(){
                        var param = {"record" : arguments[0], "rowNum" : arguments[1], "colNum" : arguments[2]};
                        var event = @com.smartgwt.client.widgets.grid.events.CellDoubleClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        managerJ.@com.google.gwt.event.shared.HandlerManager::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                        var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                        return !ret;
                    }
                });
            } else {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
                obj.cellDoubleClick = function(){
                    var param = {"record" : arguments[0], "rowNum" : arguments[1], "colNum" : arguments[2]};
                    var event = @com.smartgwt.client.widgets.grid.events.CellDoubleClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    managerJ.@com.google.gwt.event.shared.HandlerManager::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                    return !ret;
                };
            }
        }-*/;


















        /**
         * If the filter editor ({@link com.smartgwt.client.widgets.grid.ListGrid#getShowFilterEditor showFilterEditor}) is visible for this grid,  this method will explictly put focus into the specified field in the filter editor.
         */
        public native void focusInFilterEditor() /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.focusInFilterEditor();
        }-*/;

        /**
         * If the filter editor ({@link com.smartgwt.client.widgets.grid.ListGrid#getShowFilterEditor showFilterEditor}) is visible for this grid,  this method will explictly put focus into the specified field in the filter editor.
         * @param fieldName Name of the field to put focus into. If unspecified focus will go                             to the first field in the editor
         */
        public native void focusInFilterEditor(String fieldName) /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.focusInFilterEditor(fieldName);
        }-*/;

        /**
         * If the filter editor ({@link com.smartgwt.client.widgets.grid.ListGrid#getShowFilterEditor showFilterEditor}) is visible for this grid,  this method will perform a filter based on the current values in the editor.
         */
        public native void filterByEditor() /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.filterByEditor();
        }-*/;



        /**
         * Identifies whether the passed-in field is the specially generated {@link com.smartgwt.client.widgets.grid.ListGrid#getCheckboxField checkboxField} used when ${isc.DocUtils.linkForRef('type:SelectionAppearance')} is "checkbox".  Use this method in your custom event handlers to avoid inappropriately performing actions when the checkboxField is clicked on.
         * @param field field to test
         *
         * @return whether the provided field is the checkbox field
         */
        public native Boolean isCheckboxField(ListGridField field) /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            var retVal =self.isCheckboxField(field.@com.smartgwt.client.core.DataClass::getJsObj()());
            if(retVal == null || retVal === undefined) {
                return null;
            } else {
                return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
            }
        }-*/;







        /**
         * Re-evaluates {@link com.smartgwt.client.widgets.grid.ListGridField#showIf} for each field, dynamically showing and  hiding the appropriate set of fields
         */
        public native void refreshFields() /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.refreshFields();
        }-*/;







        /**
         * Event handler for when rows in the body are clicked upon. The default implementation handles firing {@link com.smartgwt.client.widgets.grid.ListGrid#startEditing} if appropriate, and fires {@link com.smartgwt.client.widgets.grid.ListGridField#recordClick} and/or {@link com.smartgwt.client.widgets.grid.ListGrid#recordClick} if set. Developers should typically implement recordClick rather than overriding this method.
         * @param record record object returned from getCellRecord()
     * @param recordNum index of the row where the click occurred
     * @param fieldNum index of the col where the click occurred
         *
         * @return 
         */
        public native Boolean rowClick(ListGridRecord record, int recordNum, int fieldNum) /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            var retVal =self.rowClick(record.@com.smartgwt.client.core.DataClass::getJsObj()(), recordNum, fieldNum);
            if(retVal == null || retVal === undefined) {
                return null;
            } else {
                return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
            }
        }-*/;

        /**
         * Event handler for when rows in the body are clicked upon. The default implementation handles firing {@link com.smartgwt.client.widgets.grid.ListGrid#startEditing} if appropriate, and fires {@link com.smartgwt.client.widgets.grid.ListGridField#recordClick} and/or {@link com.smartgwt.client.widgets.grid.ListGrid#recordClick} if set. Developers should typically implement recordClick rather than overriding this method.
         * @param record record object returned from getCellRecord()
     * @param recordNum index of the row where the click occurred
     * @param fieldNum index of the col where the click occurred
     * @param keyboardGenerated indicates whether this was a synthesized record                                              click in response to a keyboard event
         *
         * @return 
         */
        public native Boolean rowClick(ListGridRecord record, int recordNum, int fieldNum, boolean keyboardGenerated) /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            var retVal =self.rowClick(record.@com.smartgwt.client.core.DataClass::getJsObj()(), recordNum, fieldNum, keyboardGenerated);
            if(retVal == null || retVal === undefined) {
                return null;
            } else {
                return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
            }
        }-*/;

        /**
         * Event handler for when a body record is double-clicked. <P> Default implementation fires 'editCell' if appropriate, and handles firing 'recordDoubleClick' stringMethod if defined at the field or LG level (That method has a different signature from this one)
         * @param record record object returned from getCellRecord()
     * @param recordNum index of the row where the click occurred
     * @param fieldNum index of the col where the click occurred
         *
         * @return false if first click not on same record; true otherwise
         */
        public native Boolean rowDoubleClick(ListGridRecord record, int recordNum, int fieldNum) /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            var retVal =self.rowDoubleClick(record.@com.smartgwt.client.core.DataClass::getJsObj()(), recordNum, fieldNum);
            if(retVal == null || retVal === undefined) {
                return null;
            } else {
                return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
            }
        }-*/;

        /**
         * Event handler for when a body record is double-clicked. <P> Default implementation fires 'editCell' if appropriate, and handles firing 'recordDoubleClick' stringMethod if defined at the field or LG level (That method has a different signature from this one)
         * @param record record object returned from getCellRecord()
     * @param recordNum index of the row where the click occurred
     * @param fieldNum index of the col where the click occurred
     * @param keyboardGenerated indicates whether this was a synthesized record                                              doubleclick in response to a keyboard event
         *
         * @return false if first click not on same record; true otherwise
         */
        public native Boolean rowDoubleClick(ListGridRecord record, int recordNum, int fieldNum, boolean keyboardGenerated) /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            var retVal =self.rowDoubleClick(record.@com.smartgwt.client.core.DataClass::getJsObj()(), recordNum, fieldNum, keyboardGenerated);
            if(retVal == null || retVal === undefined) {
                return null;
            } else {
                return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
            }
        }-*/;





        /**
         * Select all records
         */
        public native void selectAllRecords() /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.selectAllRecords();
        }-*/;

        /**
         * Deselect all records
         */
        public native void deselectAllRecords() /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.deselectAllRecords();
        }-*/;

        /**
         * Whether at least one item is selected
         *
         * @return true == at least one item is selected        false == nothing at all is selected
         */
        public native Boolean anySelected() /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            var retVal =self.anySelected();
            if(retVal == null || retVal === undefined) {
                return null;
            } else {
                return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
            }
        }-*/;



        /**
         * Get the row that currently has keyboard focus.  Arrow key navigation moves relative to this row.
         *
         * @return rowNum of the current focus row
         */
        public native int getFocusRow() /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            return self.getFocusRow();
        }-*/;








        /**
         * Add a recordClick handler.
         *
         * @param handler the recordClick handler
         */
        public HandlerRegistration addRecordClickHandler(com.smartgwt.client.widgets.grid.events.RecordClickHandler handler) {
            if(manager.getHandlerCount(com.smartgwt.client.widgets.grid.events.RecordClickEvent.getType()) == 0) setupRecordClickEvent();
            return manager.addHandler(com.smartgwt.client.widgets.grid.events.RecordClickEvent.getType(), handler);
        }
        private native void setupRecordClickEvent() /*-{
            var obj = null;
            var managerJ = this.@com.smartgwt.client.widgets.BaseWidget::manager;
            if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
                obj.addProperties({recordClick:function(){
                        var param = {"viewer" : arguments[0], "record" : arguments[1], "recordNum" : arguments[2], "field" : arguments[3], "fieldNum" : arguments[4], "value" : arguments[5], "rawValue" : arguments[6]};
                        var event = @com.smartgwt.client.widgets.grid.events.RecordClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        managerJ.@com.google.gwt.event.shared.HandlerManager::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    }
                });
            } else {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
                obj.recordClick = function(){
                    var param = {"viewer" : arguments[0], "record" : arguments[1], "recordNum" : arguments[2], "field" : arguments[3], "fieldNum" : arguments[4], "value" : arguments[5], "rawValue" : arguments[6]};
                    var event = @com.smartgwt.client.widgets.grid.events.RecordClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    managerJ.@com.google.gwt.event.shared.HandlerManager::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                };
            }
        }-*/;








        /**
         * Add a recordDoubleClick handler.
         *
         * @param handler the recordDoubleClick handler
         */
        public HandlerRegistration addRecordDoubleClickHandler(com.smartgwt.client.widgets.grid.events.RecordDoubleClickHandler handler) {
            if(manager.getHandlerCount(com.smartgwt.client.widgets.grid.events.RecordDoubleClickEvent.getType()) == 0) setupRecordDoubleClickEvent();
            return manager.addHandler(com.smartgwt.client.widgets.grid.events.RecordDoubleClickEvent.getType(), handler);
        }
        private native void setupRecordDoubleClickEvent() /*-{
            var obj = null;
            var managerJ = this.@com.smartgwt.client.widgets.BaseWidget::manager;
            if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
                obj.addProperties({recordDoubleClick:function(){
                        var param = {"viewer" : arguments[0], "record" : arguments[1], "recordNum" : arguments[2], "field" : arguments[3], "fieldNum" : arguments[4], "value" : arguments[5], "rawValue" : arguments[6]};
                        var event = @com.smartgwt.client.widgets.grid.events.RecordDoubleClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        managerJ.@com.google.gwt.event.shared.HandlerManager::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    }
                });
            } else {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
                obj.recordDoubleClick = function(){
                    var param = {"viewer" : arguments[0], "record" : arguments[1], "recordNum" : arguments[2], "field" : arguments[3], "fieldNum" : arguments[4], "value" : arguments[5], "rawValue" : arguments[6]};
                    var event = @com.smartgwt.client.widgets.grid.events.RecordDoubleClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    managerJ.@com.google.gwt.event.shared.HandlerManager::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                };
            }
        }-*/;




        /**
         * Can this cell be edited? <P> The default implementation of <code>canEditCell()</code> respects the various property settings affecting editability: {@link com.smartgwt.client.widgets.grid.ListGridField#getCanEdit canEdit} disables editing for a field, a record with the {@link com.smartgwt.client.widgets.grid.ListGrid#getRecordEditProperty recordEditProperty} set to false is not editable, and disabled records are not editable. <P> You can override this method to control editability on a cell-by-cell basis.  For example, if you had a grid that allows editing of "orders", and you had a field "shipDate" that is normally editable, but should not be editable if the order is already "complete", you might implement <code>canEditCell()</code> as follows: <P> <pre>   isc.ListGrid.create({       ...       canEditCell : function (rowNum, colNum) {           var record = this.getRecord(rowNum),               fieldName = this.getFieldName(colNum);           if (fieldName == "shipDate" &&                record.orderStatus == "complete")            {               return false;              }           // use default rules for all other fields           return this.Super("canEditCell", arguments);       }   }); </pre> <P> Notes on providing custom implementations: <ul> <li> In order to allow complete control over editing, <code>canEditCell()</code> is called very frequently.  If you see delays on row to row navigation, check that your implementation is efficient <li> If you change the editability of a cell on the fly, for example, during  {@link com.smartgwt.client.widgets.grid.ListGrid#editorExit} on another cell, call refreshCell() to show or hide the editor <li> If this ListGrid allows new records to be created, <code>canEditCell()</code> may be called when there is no record available.  The values input so far by the user are available via {@link com.smartgwt.client.widgets.grid.ListGrid#getEditValues}.  </ul>
         * @param rowNum row number for the cell
     * @param colNum column number of the cell
         *
         * @return Whether to allow editing this cell
         */
        public native Boolean canEditCell(int rowNum, int colNum) /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            var retVal =self.canEditCell(rowNum, colNum);
            if(retVal == null || retVal === undefined) {
                return null;
            } else {
                return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
            }
        }-*/;

        /**
         * Start inline editing at the provided coordinates. <p> Invoked when a cell is editable and the <code>editEvent</code> occurs on that cell.  Can also be invoked explicitly. <P> If this method is called while editing is already in progress, the value from the current editCell will either be stored locally as a temporary edit value, or saved via 'saveEdits()' depending on <code>this.saveByCell</code>, and the position of the new edit cell.<br> Will update the UI to show the editor for the new cell, and put focus in it unless  explicitly suppressed by the optional <code>suppressFocus</code> parameter.
         *
         * @return true if we are editing the cell, false if not editing for some reason
         */
        public native Boolean startEditing() /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            var retVal =self.startEditing();
            if(retVal == null || retVal === undefined) {
                return null;
            } else {
                return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
            }
        }-*/;

        /**
         * Start inline editing at the provided coordinates. <p> Invoked when a cell is editable and the <code>editEvent</code> occurs on that cell.  Can also be invoked explicitly. <P> If this method is called while editing is already in progress, the value from the current editCell will either be stored locally as a temporary edit value, or saved via 'saveEdits()' depending on <code>this.saveByCell</code>, and the position of the new edit cell.<br> Will update the UI to show the editor for the new cell, and put focus in it unless  explicitly suppressed by the optional <code>suppressFocus</code> parameter.
         * @param rowNum Row number of the cell to edit.  Defaults to first                                  editable row
     * @param colNum Column number of the cell to edit.  Defaults to first                                  editable column
     * @param suppressFocus If passed this parameter suppresses the default                                   behavior of focussing in the edit form item when                                   the editor is shown.
         *
         * @return true if we are editing the cell, false if not editing for some reason
         */
        public native Boolean startEditing(int rowNum, int colNum, boolean suppressFocus) /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            var retVal =self.startEditing(rowNum, colNum, suppressFocus);
            if(retVal == null || retVal === undefined) {
                return null;
            } else {
                return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
            }
        }-*/;

        /**
         * Notification that the user is no longer hovering over some cell. Hides the current hover canvas if one is showing.
         */
        public native void stopHover() /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.stopHover();
        }-*/;





        /**
         * Refresh an individual cell without redrawing the grid. <P> The cell's value, CSS class, and CSS text will be refreshed, to the current values returned by getCellValue(), getCellStyle() and getCellCSSText() respectively.
         * @param rowNum row number of cell to refresh
     * @param colNum column number of cell to refresh
         */
        public native void refreshCell(int rowNum, int colNum) /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.refreshCell(rowNum, colNum);
        }-*/;

        /**
         * Refresh an entire row of cells without redrawing the grid. <P> The cells' values, CSS classes, and CSS text will be refreshed, to the current values returned by getCellValue(), getCellStyle() and getCellCSSText() respectively.
         * @param rowNum row number of cell to refresh
         */
        public native void refreshRow(int rowNum) /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.refreshRow(rowNum);
        }-*/;










        /**
         * Returns the index of the row being edited or null if there is no current edit row.
         *
         * @return Index of the current edit row
         */
        public native int getEditRow() /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            return self.getEditRow();
        }-*/;

        /**
         * Returns the index of the column being edited or null if there is no edit col.
         *
         * @return Index of the current edit column
         */
        public native int getEditCol() /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            return self.getEditCol();
        }-*/;


        /**
         * Cancel the current edit without saving.
         */
        public native void cancelEditing() /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.cancelEditing();
        }-*/;

        /**
         * Complete the current edit by storing the value and hiding the inline editor. Note that if {@link com.smartgwt.client.widgets.grid.ListGrid#getAutoSaveEdits autoSaveEdits} is true, the value will be saved to the server.
         */
        public native void endEditing() /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.endEditing();
        }-*/;


        /**
         * Cancel outstanding edits for the specified rows, discarding edit values, and hiding editors  if appropriate.<br> Note that if this method is called on a new edit row (created via  {@link com.smartgwt.client.widgets.grid.ListGrid#startEditingNew} for example), which has not yet been saved, this method will remove the row entirely.
         * @param rowNum Row to cancel
     * @param colNum Column to cancel. Note that this parameter is ignored in ListGrids but                        may be required in subclasses of ListGrid where each cell represents                        one record in the data set (EG CubeGrid)
         */
        public native void discardEdits(int rowNum, int colNum) /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.discardEdits(rowNum, colNum);
        }-*/;

        /**
         * Cancel outstanding edits for the specified rows, discarding edit values, and hiding editors  if appropriate.<br> Note that if this method is called on a new edit row (created via  {@link com.smartgwt.client.widgets.grid.ListGrid#startEditingNew} for example), which has not yet been saved, this method will remove the row entirely.
         * @param rowNum Row to cancel
     * @param colNum Column to cancel. Note that this parameter is ignored in ListGrids but                        may be required in subclasses of ListGrid where each cell represents                        one record in the data set (EG CubeGrid)
     * @param dontHideEditor By default this method will hide the editor if                              it is currently showing for the row in question. Passing in                              this parameter will leave the editor visible (and just reset                              the edit values underneath the editor).
         */
        public native void discardEdits(int rowNum, int colNum, boolean dontHideEditor) /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.discardEdits(rowNum, colNum, dontHideEditor);
        }-*/;


        /**
         * If this listGrid can be edited, this method will return true if the row passed in has been edited, but the edits have not yet been saved to the ListGrid's data object.
         * @param rowNum index of row to check for changes
         *
         * @return true if the row has changes.
         */
        public native Boolean rowHasChanges(int rowNum) /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            var retVal =self.rowHasChanges(rowNum);
            if(retVal == null || retVal === undefined) {
                return null;
            } else {
                return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
            }
        }-*/;

        /**
         * Whether the grid as a whole has any unsaved edits, in any row.
         *
         * @return returns true of any unsaved edits are present
         */
        public native Boolean hasChanges() /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            var retVal =self.hasChanges();
            if(retVal == null || retVal === undefined) {
                return null;
            } else {
                return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
            }
        }-*/;

        /**
         * If this listGrid can be edited, this method will return true if the cell passed in has been edited, but the edits have not yet been saved to the ListGrid's data object.
         * @param rowNum index of row to check for changes
     * @param colNum index of the col to check for changes
         *
         * @return returns true if the cell has unsaved edits
         */
        public native Boolean cellHasChanges(int rowNum, int colNum) /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            var retVal =self.cellHasChanges(rowNum, colNum);
            if(retVal == null || retVal === undefined) {
                return null;
            } else {
                return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
            }
        }-*/;





        /**
         * Does this grid currently have errors associated with editValues for any row in the grid.
         *
         * @return true if there are unresolved errors, false otherwise
         */
        public native Boolean hasErrors() /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            var retVal =self.hasErrors();
            if(retVal == null || retVal === undefined) {
                return null;
            } else {
                return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
            }
        }-*/;

        /**
         * Does the specified row have unresolved errors?
         * @param rowNum rowNum to check for errors
         *
         * @return true if there are unresolved errors, false otherwise
         */
        public native Boolean rowHasErrors(int rowNum) /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            var retVal =self.rowHasErrors(rowNum);
            if(retVal == null || retVal === undefined) {
                return null;
            } else {
                return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
            }
        }-*/;







        /**
         * Clear any stored validation errors for some row
         * @param rowNum index of row to clear validation error for
         */
        public native void clearRowErrors(int rowNum) /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.clearRowErrors(rowNum);
        }-*/;




        /**
         * Return "title" HTML to display as a drag tracker when the user drags some record.<br> Default implementation will display the cell value for the title field (see  {@link com.smartgwt.client.widgets.grid.ListGrid#getTitleField}) for the record(s) being dragged (including any icons / custom formatting / styling, etc). <p> Note: Only called if {@link com.smartgwt.client.widgets.grid.ListGrid#getDragTrackerMode dragTrackerMode} is set to <code>"title"</code>.
         * @param record First selected record being dragged
     * @param rowNum row index of first record being dragged
         *
         * @return Title for the row. Default implementation looks at the value of the                  title-field cell for the row.
         */
        public native String getDragTrackerTitle(ListGridRecord record, int rowNum) /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            return self.getDragTrackerTitle(record.@com.smartgwt.client.core.DataClass::getJsObj()(), rowNum);
        }-*/;

        /**
         * This method overrides {@link com.smartgwt.client.widgets.Canvas#willAcceptDrop} and works as follows:<br> <ul> <li>If {@link com.smartgwt.client.widgets.Canvas#willAcceptDrop} (the superclass definition) returns false, this      method always returns false.  This allows ${isc.DocUtils.linkForRef('canvas.dragTypes')} and     {@link com.smartgwt.client.widgets.Canvas#getDropTypes dropTypes} to be used to configure eligibility for drop.  By default,     a ListGrid has no dropTypes configured and so this check will not prevent a drop.</li> <li>If this is a self-drop, that is, the user is dragging a record within this list, this is     an attempted drag-reorder.  If {@link com.smartgwt.client.widgets.grid.ListGrid#getCanReorderRecords canReorderRecords} is      false, this method returns false.</li> <li>If the ${isc.DocUtils.linkForRef('EH.getDragTarget','dragTarget')} is another widget, if     {@link com.smartgwt.client.widgets.grid.ListGrid#getCanAcceptDroppedRecords canAcceptDroppedRecords} is false this method returns false.</li> <li>If a call to {@link com.smartgwt.client.widgets.grid.ListGrid#getDragData} on the <code>dragTarget</code> fails to return     an record object or an array of records, this method returns false.</li>  <li>If a the drop target record is disabled or has {@link com.smartgwt.client.widgets.grid.ListGridRecord#getCanAcceptDrop canAcceptDrop}      set to false, return false.</li> </ul> Note that this method may be called repeatedly during a drag-drop interaction to update the UI and notify the user as to when they may validly drop data.
         *
         * @return true if this component will accept a drop of the dragData
         */
        public native Boolean willAcceptDrop() /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            var retVal =self.willAcceptDrop();
            if(retVal == null || retVal === undefined) {
                return null;
            } else {
                return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
            }
        }-*/;

        /**
         * Simulates a drag / drop type transfer of the selected records in some other component to this component, without requiring any user interaction.  This method acts on the dropped records  exactly as if they had been dropped in an actual drag / drop interaction, including any  special databound behavior invoked by calling {@link com.smartgwt.client..DataBoundComponent#getDropValues} for each dropped record. <P> To transfer <b>all</b> data in, for example, a {@link com.smartgwt.client.widgets.grid.ListGrid}, call grid.selection.selectAll() first. <P> See the ${isc.DocUtils.linkForRef('group:dragging')} documentation for an overview of list grid drag/drop data transfer.
         * @param source source component from which the records will be tranferred
         */
        public native void transferSelectedData(DataBoundComponent source) /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.transferSelectedData(source);
        }-*/;

        /**
         * Simulates a drag / drop type transfer of the selected records in some other component to this component, without requiring any user interaction.  This method acts on the dropped records  exactly as if they had been dropped in an actual drag / drop interaction, including any  special databound behavior invoked by calling {@link com.smartgwt.client..DataBoundComponent#getDropValues} for each dropped record. <P> To transfer <b>all</b> data in, for example, a {@link com.smartgwt.client.widgets.grid.ListGrid}, call grid.selection.selectAll() first. <P> See the ${isc.DocUtils.linkForRef('group:dragging')} documentation for an overview of list grid drag/drop data transfer.
         * @param source source component from which the records will be tranferred
     * @param index target index (drop position) of the rows within this grid.
         */
        public native void transferSelectedData(DataBoundComponent source, int index) /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.transferSelectedData(source, index);
        }-*/;




        /**
         * Return the pointer to a particular record by record number. Synonym for {@link com.smartgwt.client.widgets.grid.ListGrid#getCellRecord}.
         * @param recordNum row index of record to return.
         *
         * @return Record object for the row.
         */
        public native ListGridRecord getRecord(int recordNum) /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            var ret = self.getRecord(recordNum);
            if(ret == null || ret === undefined) return null;
            var retVal = @com.smartgwt.client.core.RefDataClass::getRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
            if(retVal == null) {
                retVal = @com.smartgwt.client.widgets.grid.ListGridRecord::new(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
            }
            return retVal;
        }-*/;









        /**
         * Get the index of the provided record. <P> This is essentially the same as calling listGrid.data.indexOf(record), except that  the currently visible range of records is checked first.  This is important for responsiveness in functions that respond to user actions when the user is working near the end of a very large dataset (eg 500k records).
         * @param record the record whose index is to be retrieved
         *
         * @return indexindex of the record, or -1 if not found
         */
        public native int getRecordIndex(ListGridRecord record) /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            return self.getRecordIndex(record.@com.smartgwt.client.core.DataClass::getJsObj()());
        }-*/;

        /**
         * Returns the row number of the most recent mouse event.
         *
         * @return row number, or -2 if beyond last drawn row
         */
        public native int getEventRow() /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            return self.getEventRow();
        }-*/;

        /**
         * Returns the row number of the most recent mouse event.
         * @param y optional y-coordinate to obtain row number, in lieue of the y                        coordinate of the last mouse event
         *
         * @return row number, or -2 if beyond last drawn row
         */
        public native int getEventRow(int y) /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            return self.getEventRow(y);
        }-*/;

        /**
         * Returns the column number of the most recent mouse event.
         *
         * @return column number, or -2 if beyond last drawn column
         */
        public native int getEventColumn() /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            return self.getEventColumn();
        }-*/;

        /**
         * Returns the column number of the most recent mouse event.
         * @param x optional x-coordinate to obtain column number for, in lieue of the x                        coordinate of the last mouse event
         *
         * @return column number, or -2 if beyond last drawn column
         */
        public native int getEventColumn(int x) /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            return self.getEventColumn(x);
        }-*/;




        /**
         * Add a selectionChanged handler.
         *
         * @param handler the selectionChanged handler
         */
        public HandlerRegistration addSelectionChangedHandler(com.smartgwt.client.widgets.grid.events.SelectionChangedHandler handler) {
            if(manager.getHandlerCount(com.smartgwt.client.widgets.grid.events.SelectionEvent.getType()) == 0) setupSelectionChangedEvent();
            return manager.addHandler(com.smartgwt.client.widgets.grid.events.SelectionEvent.getType(), handler);
        }
        private native void setupSelectionChangedEvent() /*-{
            var obj = null;
            var managerJ = this.@com.smartgwt.client.widgets.BaseWidget::manager;
            if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
                obj.addProperties({selectionChanged:function(){
                        var param = {"record" : arguments[0], "state" : arguments[1]};
                        var event = @com.smartgwt.client.widgets.grid.events.SelectionEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        managerJ.@com.google.gwt.event.shared.HandlerManager::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    }
                });
            } else {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
                obj.selectionChanged = function(){
                    var param = {"record" : arguments[0], "state" : arguments[1]};
                    var event = @com.smartgwt.client.widgets.grid.events.SelectionEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    managerJ.@com.google.gwt.event.shared.HandlerManager::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                };
            }
        }-*/;







        /**
         * Handle a click in the list header. <P> By default, calls {@link com.smartgwt.client.widgets.grid.ListGrid#sort} to sort by the field that was clicked, or to reverse the direction of sorting if already sorted by that field.
         * @param fieldNum field number for the header that was clicked
         */
        public native void headerClick(int fieldNum) /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.headerClick(fieldNum);
        }-*/;

        /**
         * Reorder a particular field
         * @param fieldNum Number of the field to reorder
     * @param moveToPosition New position for that field
         */
        public native void reorderField(int fieldNum, int moveToPosition) /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.reorderField(fieldNum, moveToPosition);
        }-*/;

        /**
         * Reorder a set of adjacent fields, from start to end exclusive at the end, by distance moveDelta.<br><br> NOTE: start and end coordinates are in terms of the currently visible fields, not the full set of fields.
         * @param start Start of the range of fields to move, inclusive
     * @param end End of the range of fields to move, non-inclusive
     * @param moveDelta Distance to move by
         */
        public native void reorderFields(int start, int end, int moveDelta) /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.reorderFields(start, end, moveDelta);
        }-*/;


        /**
         * Resize a particular field to a new width.
         * @param fieldNum Number of the field to resize
     * @param newWidth New width of the field
         */
        public native void resizeField(int fieldNum, int newWidth) /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.resizeField(fieldNum, newWidth);
        }-*/;


        /**
         * If we're showing a {@link com.smartgwt.client.widgets.grid.ListGrid#getShowHeaderContextMenu showHeaderContextMenu} for this grid and {@link com.smartgwt.client.widgets.grid.ListGrid#getCanFreezeFields canFreezeFields} is true, this string will be shown as the title for the menu item to toggle whether a field is frozen or unfrozen. <P> Default implementation evaluates and returns {@link com.smartgwt.client.widgets.grid.ListGrid#getFreezeFieldText freezeFieldText} or {@link com.smartgwt.client.widgets.grid.ListGrid#getUnfreezeFieldText unfreezeFieldText} depending on whether the field is currently frozen.
         * @param field field to get the menu item title for
         *
         * @return Title to show in the menu item
         */
        public native String getToggleFreezeText(ListGridField field) /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            return self.getToggleFreezeText(field.@com.smartgwt.client.core.DataClass::getJsObj()());
        }-*/;




        /**
         * Turn sorting off, typically because data has changed and is no longer sorted. <p> Calling <code>unsort()</code> disables visual indication of which column is the sort column, and calls <code>unsort()</code> on the underlying dataset. <P> Note that a grid viewing a paged dataset may not be able to support <code>unsort()</code> because the sort order is what establishes the row numbering that allows data to be fetched in batches. <P> <code>unsort()</code> is automatically called when records are dropped or value of the sorted column is changed.
         */
        public native void unsort() /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.unsort();
        }-*/;







        /**
         * Removes the grouping from the listgrid, restoring its original data
         */
        public native void ungroup() /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.ungroup();
        }-*/;


        /**
         * Update the title of a {@link com.smartgwt.client.widgets.grid.ListGrid#getHeaderSpans headerSpans} dynamically.
         * @param name name of the headerSpan, as specified via {@link com.smartgwt.client..HeaderSpan#getName name}.
     * @param newTitle new title for the headerSpan
         */
        public native void setHeaderSpanTitle(String name, String newTitle) /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.setHeaderSpanTitle(name, newTitle);
        }-*/;







        /**
         * Add a cellChanged handler.
         *
         * @param handler the cellChanged handler
         */
        public HandlerRegistration addCellSavedHandler(com.smartgwt.client.widgets.grid.events.CellSavedHandler handler) {
            if(manager.getHandlerCount(com.smartgwt.client.widgets.grid.events.CellSavedEvent.getType()) == 0) setupCellSavedEvent();
            return manager.addHandler(com.smartgwt.client.widgets.grid.events.CellSavedEvent.getType(), handler);
        }
        private native void setupCellSavedEvent() /*-{
            var obj = null;
            var managerJ = this.@com.smartgwt.client.widgets.BaseWidget::manager;
            if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
                obj.addProperties({cellChanged:function(){
                        var param = {"record" : arguments[0], "newValue" : arguments[1], "oldValue" : arguments[2], "rowNum" : arguments[3], "colNum" : arguments[4], "grid" : arguments[5]};
                        var event = @com.smartgwt.client.widgets.grid.events.CellSavedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        managerJ.@com.google.gwt.event.shared.HandlerManager::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    }
                });
            } else {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
                obj.cellChanged = function(){
                    var param = {"record" : arguments[0], "newValue" : arguments[1], "oldValue" : arguments[2], "rowNum" : arguments[3], "colNum" : arguments[4], "grid" : arguments[5]};
                    var event = @com.smartgwt.client.widgets.grid.events.CellSavedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    managerJ.@com.google.gwt.event.shared.HandlerManager::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                };
            }
        }-*/;







        /**
         * Add a editComplete handler.
         *
         * @param handler the editComplete handler
         */
        public HandlerRegistration addEditCompleteHandler(com.smartgwt.client.widgets.grid.events.EditCompleteHandler handler) {
            if(manager.getHandlerCount(com.smartgwt.client.widgets.grid.events.EditCompleteEvent.getType()) == 0) setupEditCompleteEvent();
            return manager.addHandler(com.smartgwt.client.widgets.grid.events.EditCompleteEvent.getType(), handler);
        }
        private native void setupEditCompleteEvent() /*-{
            var obj = null;
            var managerJ = this.@com.smartgwt.client.widgets.BaseWidget::manager;
            if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
                obj.addProperties({editComplete:function(){
                        var param = {"rowNum" : arguments[0], "colNum" : arguments[1], "newValues" : arguments[2], "oldValues" : arguments[3], "editCompletionEvent" : arguments[4], "dsResponse" : arguments[5]};
                        var event = @com.smartgwt.client.widgets.grid.events.EditCompleteEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        managerJ.@com.google.gwt.event.shared.HandlerManager::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    }
                });
            } else {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
                obj.editComplete = function(){
                    var param = {"rowNum" : arguments[0], "colNum" : arguments[1], "newValues" : arguments[2], "oldValues" : arguments[3], "editCompletionEvent" : arguments[4], "dsResponse" : arguments[5]};
                    var event = @com.smartgwt.client.widgets.grid.events.EditCompleteEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    managerJ.@com.google.gwt.event.shared.HandlerManager::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                };
            }
        }-*/;







        /**
         * Add a editFailed handler.
         *
         * @param handler the editFailed handler
         */
        public HandlerRegistration addEditFailedHandler(com.smartgwt.client.widgets.grid.events.EditFailedHandler handler) {
            if(manager.getHandlerCount(com.smartgwt.client.widgets.grid.events.EditFailedEvent.getType()) == 0) setupEditFailedEvent();
            return manager.addHandler(com.smartgwt.client.widgets.grid.events.EditFailedEvent.getType(), handler);
        }
        private native void setupEditFailedEvent() /*-{
            var obj = null;
            var managerJ = this.@com.smartgwt.client.widgets.BaseWidget::manager;
            if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
                obj.addProperties({editFailed:function(){
                        var param = {"rowNum" : arguments[0], "colNum" : arguments[1], "newValues" : arguments[2], "oldValues" : arguments[3], "editCompletionEvent" : arguments[4], "dsResponse" : arguments[5]};
                        var event = @com.smartgwt.client.widgets.grid.events.EditFailedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        managerJ.@com.google.gwt.event.shared.HandlerManager::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    }
                });
            } else {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
                obj.editFailed = function(){
                    var param = {"rowNum" : arguments[0], "colNum" : arguments[1], "newValues" : arguments[2], "oldValues" : arguments[3], "editCompletionEvent" : arguments[4], "dsResponse" : arguments[5]};
                    var event = @com.smartgwt.client.widgets.grid.events.EditFailedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    managerJ.@com.google.gwt.event.shared.HandlerManager::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                };
            }
        }-*/;





        /**
         * Add a editorEnter handler.
         *
         * @param handler the editorEnter handler
         */
        public HandlerRegistration addEditorEnterHandler(com.smartgwt.client.widgets.grid.events.EditorEnterHandler handler) {
            if(manager.getHandlerCount(com.smartgwt.client.widgets.grid.events.EditorEnterEvent.getType()) == 0) setupEditorEnterEvent();
            return manager.addHandler(com.smartgwt.client.widgets.grid.events.EditorEnterEvent.getType(), handler);
        }
        private native void setupEditorEnterEvent() /*-{
            var obj = null;
            var managerJ = this.@com.smartgwt.client.widgets.BaseWidget::manager;
            if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
                obj.addProperties({editorEnter:function(){
                        var param = {"record" : arguments[0], "value" : arguments[1], "rowNum" : arguments[2], "colNum" : arguments[3]};
                        var event = @com.smartgwt.client.widgets.grid.events.EditorEnterEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        managerJ.@com.google.gwt.event.shared.HandlerManager::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    }
                });
            } else {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
                obj.editorEnter = function(){
                    var param = {"record" : arguments[0], "value" : arguments[1], "rowNum" : arguments[2], "colNum" : arguments[3]};
                    var event = @com.smartgwt.client.widgets.grid.events.EditorEnterEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    managerJ.@com.google.gwt.event.shared.HandlerManager::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                };
            }
        }-*/;




        /**
         * Add a rowEditorEnter handler.
         *
         * @param handler the rowEditorEnter handler
         */
        public HandlerRegistration addRowEditorEnterHandler(com.smartgwt.client.widgets.grid.events.RowEditorEnterHandler handler) {
            if(manager.getHandlerCount(com.smartgwt.client.widgets.grid.events.RowEditorEnterEvent.getType()) == 0) setupRowEditorEnterEvent();
            return manager.addHandler(com.smartgwt.client.widgets.grid.events.RowEditorEnterEvent.getType(), handler);
        }
        private native void setupRowEditorEnterEvent() /*-{
            var obj = null;
            var managerJ = this.@com.smartgwt.client.widgets.BaseWidget::manager;
            if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
                obj.addProperties({rowEditorEnter:function(){
                        var param = {"record" : arguments[0], "editValues" : arguments[1], "rowNum" : arguments[2]};
                        var event = @com.smartgwt.client.widgets.grid.events.RowEditorEnterEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        managerJ.@com.google.gwt.event.shared.HandlerManager::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    }
                });
            } else {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
                obj.rowEditorEnter = function(){
                    var param = {"record" : arguments[0], "editValues" : arguments[1], "rowNum" : arguments[2]};
                    var event = @com.smartgwt.client.widgets.grid.events.RowEditorEnterEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    managerJ.@com.google.gwt.event.shared.HandlerManager::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                };
            }
        }-*/;






        /**
         * Add a editorExit handler.
         *
         * @param handler the editorExit handler
         */
        public HandlerRegistration addEditorExitHandler(com.smartgwt.client.widgets.grid.events.EditorExitHandler handler) {
            if(manager.getHandlerCount(com.smartgwt.client.widgets.grid.events.EditorExitEvent.getType()) == 0) setupEditorExitEvent();
            return manager.addHandler(com.smartgwt.client.widgets.grid.events.EditorExitEvent.getType(), handler);
        }
        private native void setupEditorExitEvent() /*-{
            var obj = null;
            var managerJ = this.@com.smartgwt.client.widgets.BaseWidget::manager;
            if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
                obj.addProperties({editorExit:function(){
                        var param = {"editCompletionEvent" : arguments[0], "record" : arguments[1], "newValue" : arguments[2], "rowNum" : arguments[3], "colNum" : arguments[4]};
                        var event = @com.smartgwt.client.widgets.grid.events.EditorExitEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        managerJ.@com.google.gwt.event.shared.HandlerManager::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                        var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                        return !ret;
                    }
                });
            } else {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
                obj.editorExit = function(){
                    var param = {"editCompletionEvent" : arguments[0], "record" : arguments[1], "newValue" : arguments[2], "rowNum" : arguments[3], "colNum" : arguments[4]};
                    var event = @com.smartgwt.client.widgets.grid.events.EditorExitEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    managerJ.@com.google.gwt.event.shared.HandlerManager::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                    return !ret;
                };
            }
        }-*/;





        /**
         * Add a rowEditorExit handler.
         *
         * @param handler the rowEditorExit handler
         */
        public HandlerRegistration addRowEditorExitHandler(com.smartgwt.client.widgets.grid.events.RowEditorExitHandler handler) {
            if(manager.getHandlerCount(com.smartgwt.client.widgets.grid.events.RowEditorExitEvent.getType()) == 0) setupRowEditorExitEvent();
            return manager.addHandler(com.smartgwt.client.widgets.grid.events.RowEditorExitEvent.getType(), handler);
        }
        private native void setupRowEditorExitEvent() /*-{
            var obj = null;
            var managerJ = this.@com.smartgwt.client.widgets.BaseWidget::manager;
            if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
                obj.addProperties({rowEditorExit:function(){
                        var param = {"editCompletionEvent" : arguments[0], "record" : arguments[1], "newValues" : arguments[2], "rowNum" : arguments[3]};
                        var event = @com.smartgwt.client.widgets.grid.events.RowEditorExitEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        managerJ.@com.google.gwt.event.shared.HandlerManager::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                        var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                        return !ret;
                    }
                });
            } else {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
                obj.rowEditorExit = function(){
                    var param = {"editCompletionEvent" : arguments[0], "record" : arguments[1], "newValues" : arguments[2], "rowNum" : arguments[3]};
                    var event = @com.smartgwt.client.widgets.grid.events.RowEditorExitEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    managerJ.@com.google.gwt.event.shared.HandlerManager::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                    return !ret;
                };
            }
        }-*/;




        /**
         * Add a fieldStateChanged handler.
         *
         * @param handler the fieldStateChanged handler
         */
        public HandlerRegistration addFieldStateChangedHandler(com.smartgwt.client.widgets.grid.events.FieldStateChangedHandler handler) {
            if(manager.getHandlerCount(com.smartgwt.client.widgets.grid.events.FieldStateChangedEvent.getType()) == 0) setupFieldStateChangedEvent();
            return manager.addHandler(com.smartgwt.client.widgets.grid.events.FieldStateChangedEvent.getType(), handler);
        }
        private native void setupFieldStateChangedEvent() /*-{
            var obj = null;
            var managerJ = this.@com.smartgwt.client.widgets.BaseWidget::manager;
            if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
                obj.addProperties({fieldStateChanged:function(){
                        var param = {};
                        var event = @com.smartgwt.client.widgets.grid.events.FieldStateChangedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        managerJ.@com.google.gwt.event.shared.HandlerManager::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    }
                });
            } else {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
                obj.fieldStateChanged = function(){
                    var param = {};
                    var event = @com.smartgwt.client.widgets.grid.events.FieldStateChangedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    managerJ.@com.google.gwt.event.shared.HandlerManager::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                };
            }
        }-*/;

    // ********************* Static Methods ***********************





    protected native void onInit() /*-{

        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self._getCellCSSText = self.getCellCSSText;
        self.getCellCSSText = function(record, rowNum, colNum) {
            var jObj = this.__ref;
            var recordJ = @com.smartgwt.client.widgets.grid.ListGridRecord::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(record);
            return jObj.@com.smartgwt.client.widgets.grid.ListGrid::getCellCSSText(Lcom/smartgwt/client/widgets/grid/ListGridRecord;II)(recordJ, rowNum, colNum);
        };

        self._getBaseStyle = self.getBaseStyle;
        self.getBaseStyle = function(record, rowNum, colNum) {
            var jObj = this.__ref;
            var recordJ = @com.smartgwt.client.widgets.grid.ListGridRecord::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(record);
            return jObj.@com.smartgwt.client.widgets.grid.ListGrid::getBaseStyle(Lcom/smartgwt/client/widgets/grid/ListGridRecord;II)(recordJ, rowNum, colNum);
        };

        self.__getHeaderContextMenuItems = self.getHeaderContextMenuItems;
        self.getHeaderContextMenuItems = function(fieldNum) {
            var jObj = this.__ref;
            var fieldNumJ = fieldNum == null ? null : @com.smartgwt.client.util.JSOHelper::toInteger(I)(fieldNum);
            var menuItemsJ = jObj.@com.smartgwt.client.widgets.grid.ListGrid::getHeaderContextMenuItems(Ljava/lang/Integer;)(fieldNumJ);
            var menuItemsJS = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(menuItemsJ);
            return menuItemsJS;
        };
    }-*/;


    /**
     * Return CSS text for styling this cell, which will be applied in addition to the CSS class for the cell, as
     * overrides. <p> "CSS text" means semicolon-separated style settings, suitable for inclusion in a CSS stylesheet or
     * in a STYLE attribute of an HTML element.
     * <br><b>Note: This is an override point</b>
     *
     *
     * @param record cell record as returned by getCellRecord
     * @param rowNum row number for the cell
     * @param colNum column number of the cell
     * @return CSS text for this cell
     */
    protected native String getCellCSSText(ListGridRecord record, int rowNum, int colNum) /*-{

        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        return self._getCellCSSText(record == null ? null : record.@com.smartgwt.client.core.DataClass::getJsObj()(), rowNum, colNum);
    }-*/;

    /**
     * If ListGrid.showHeaderContextMenu is true this method returns the menu items to be displayed in the default header context menu.
     * <br>
     * This method will be called each time the menu is displayed, allowing for dynamic content depending on the current state of the fields.
     * <br>
     * The default set of menu items will includes menu items for freezing fields, showing and hiding fields, grouping by fields, or other listGrid features
     * <br><b>Note: This is an override point</b>
     *
     * @param fieldNum index of the field the user clicked in the fields array. Note: if the user right-clicked the sorter button this parameter will be null.
     * @return Array of MenuItem
     */
    protected native MenuItem[] getHeaderContextMenuItems(Integer fieldNum) /*-{

        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var index = fieldNum == null ? null : fieldNum.@java.lang.Integer::intValue()();
        var menuItemsJS = self.__getHeaderContextMenuItems(index);
        var menuItemsJ = @com.smartgwt.client.widgets.menu.Menu::convertToMenuItemArray(Lcom/google/gwt/core/client/JavaScriptObject;)(menuItemsJS);
        return menuItemsJ;
    }-*/;

    /**
     * Return the base stylename for this cell. Has the following implementation by default: <ul> <li>If
     * this.editFailedBaseStyle is defined, and the cell is displaying a validation error return this value.</li> <li>If
     * this.editFailedPendingStyle is defined, and the cell is displaying an edit value that has not yet been saved (see
     * ListGrid.autoSaveEdits) return this value.</li> <li>Otherwise return record[listGrid.recordBaseStyleProperty], if
     * defined, otherwise field.baseStyle, or finally this.baseStyle</li> </ul>
     * <br><b>Note: This is an override point</b>
     *
     * @param record the record
     * @param rowNum the row num
     * @param colNum the colum num
     * @return the CSS class for this cell
     */
    protected native String getBaseStyle(ListGridRecord record, int rowNum, int colNum) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        return self._getBaseStyle(record == null ? null : record.@com.smartgwt.client.core.DataClass::getJsObj()(), rowNum, colNum);
    }-*/;

      /**
    * The base name for the CSS class applied to cells. This style will have "Dark",  "Over", "Selected", or "Disabled" appended to it according to the state of the cell.
    *
    * @param baseStyle baseStyle Default value is "cell"
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setBaseStyle(String baseStyle)  throws IllegalStateException {
        setAttribute("baseStyle", baseStyle, false);
    }
    
    /**
     * The base name for the CSS class applied to cells. This style will have "Dark",  "Over", "Selected", or "Disabled" appended to it according to the state of the cell.
     *
     *
     * @return Return the base stylename for this cell.  Has the following implementation by default: <ul> <li>If {@link com.smartgwt.client.widgets.grid.ListGrid#getEditFailedBaseStyle editFailedBaseStyle} is defined, and the     cell is displaying a validation error return this value.</li> <li>If {@link com.smartgwt.client.widgets.grid.ListGrid#getEditPendingBaseStyle editPendingBaseStyle} is defined, and     the cell is displaying an edit value that has not yet been saved (see      {@link com.smartgwt.client.widgets.grid.ListGrid#getAutoSaveEdits autoSaveEdits}) return this value.</li> <li>Otherwise return {@link com.smartgwt.client.widgets.grid.ListGrid#getRecordBaseStyleProperty recordBaseStyleProperty},     if defined, otherwise {@link com.smartgwt.client.widgets.grid.ListGridField#getBaseStyle baseStyle},      or finally {@link com.smartgwt.client.widgets.grid.ListGrid#getBaseStyle baseStyle}</li> </ul>
     *
     */
    public String getBaseStyle()  {
        return JSOHelper.getAttribute(config, "baseStyle");
    }


    /**
     * The DataSource that this component should bind to for default fields and for performing&#010 DataSource
     * requests.
     *
     * @param dataSource dataSource Default value is null
     */
    public void setDataSource(DataSource dataSource) {
        setAttribute("dataSource", dataSource.getOrCreateJsObj(), true);
    }

    /**
     * If this is an editable listGrid, this property will specify the {@link com.smartgwt.client.widgets.form.fields.DateItem#setInputFormat(String) inputFormat}
     * applied to editors for fields of type "date"
     *
     * 3 character string containing the "M", "D" and "Y" characters to indicate the format of strings being parsed into Date instances via Date.parseInput().
     *
     * <p>
     * As an example - an input format of "MDY" would parse "01/02/1999" to Jan 2nd 1999
     *
     * @param dateInputFormat the dateInputFormat
     */
    public void setDateInputFormat(String dateInputFormat) {
        setAttribute("dateInputFormat", "dateInputFormat", true);
    }
    
    /**
     * The DataSource that this component should bind to for default fields and for performing {@link com.smartgwt.client.data.DSRequest}. <P> Can be specified as either a DataSource instance or the String ID of a DataSource.
     *
     * @return DataSource
     */
    public DataSource getDataSource() {
        return DataSource.getOrCreateRef(getAttributeAsJavaScriptObject("dataSource"));
    }    

    /**
     * An array of field objects, specifying the order, layout, formatting, and sorting behavior of each field in the
     * listGrid object.  In ListGrids, the fields array specifies columns.  Each field in the fields array is a
     * ListGridField object.  Any listGrid that will display data should have at least one visible field. <p> If {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getDataSource dataSource} is also set, this value acts as a set of
     * overrides as explained in {@link com.smartgwt.client..DataBoundComponent#getFields fields}. Sets the fields array
     * and/or field widths to newFields and sizes, respectively.<br><br> If newFields is specified, it is assumed that
     * the new fields may have nothing in common with the old fields, and the component is substantially rebuilt.
     * Consider the following methods for more efficient, more incremental changes: resizeField, reorderField,
     * showField, hideField, setFieldProperty.
     *
     * @param fields array of fields to draw. Default value is null
     */
    public void setFields(ListGridField... fields) {
        setAttribute("fields", fields, true);
    }

    /**
     * A List of ListGridRecord objects, specifying the data to be used to populate the ListGrid.  In ListGrids, the
     * data array specifies rows. Note that ListGrids automatically observe changes to the data List and redraw
     * accordingly. <p> This property is settable directly only as part of a {@link
     * com.smartgwt.client.widgets.grid.ListGrid} constructor.  If you want to change the {@link
     * com.smartgwt.client.widgets.grid.ListGrid}'s data after initial creation, call {@link
     * com.smartgwt.client.widgets.grid.ListGrid#setData}. <p> This property will typically not be explicitly specified
     * for databound ListGrids, where the data is returned from the server via databound component methods such as
     * {@link com.smartgwt.client.widgets.grid.ListGrid#fetchData}. In this case the data objects will be set to a
     * {@link com.smartgwt.client.data.ResultSet} rather than a simple array. Initialize the data object with the given
     * array. Observes methods of the data object so that when the data changes, the listGrid will redraw
     * automatically.
     *
     * @param data data to show in the list. Default value is null
     */
    public void setData(ListGridRecord[] records) {
        setAttribute("data", records, true);
    }

    /**
     * Synonym for {@link #setData(ListGridRecord[])}
     *
     * @param records
     */
    public void setRecords(ListGridRecord[] records) {
        setAttribute("data", records, true);
    }

    public ListGridRecord[] getRecords() {
        JavaScriptObject dataJS = getAttributeAsJavaScriptObject("data");
        ListGridRecord[] data = convertToListGridRecordArray(dataJS);
        return data;
    }

    /**
     * Should this ListGrid automatically expand to accomodate its content? <P> Valid settings are
     * <ul><li><code>"vertical"</code>: expand vertically to accomodate records.</li>     <li><code>"horizontal"</code>:
     * expand horizontally to accomodate fields.</li>     <li><code>"both"</code>: expand horizontally and vertically to
     * accomodate content.</li> </ul> Note that how far the ListGrid will expand may be limited via the following
     * properties: {@link com.smartgwt.client.widgets.grid.ListGrid#getAutoFitMaxHeight autoFitMaxHeight}, {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getAutoFitMaxRecords autoFitMaxRecords}, {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getAutoFitMaxWidth autoFitMaxWidth}, {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getAutoFitMaxColumns autoFitMaxColumns}. Setter for {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getAutoFitData autoFitData}.
     *
     * @param autoFitData One of <code>"vertical"</code>, <code>"horizontal"</code>  or <code>"both"</code>. To disable
     *                    auto fit behavior, pass in <code>null</code>.. Default value is null
     */
    public void setAutoFitData(Autofit autoFitData) {
        setAttribute("autoFitData", autoFitData.getValue(), true);
    }

    /**
     * Should this ListGrid automatically expand to accomodate its content? <P> Valid settings are
     * <ul><li><code>"vertical"</code>: expand vertically to accomodate records.</li>     <li><code>"horizontal"</code>:
     * expand horizontally to accomodate fields.</li>     <li><code>"both"</code>: expand horizontally and vertically to
     * accomodate content.</li> </ul> Note that how far the ListGrid will expand may be limited via the following
     * properties: {@link com.smartgwt.client.widgets.grid.ListGrid#getAutoFitMaxHeight autoFitMaxHeight}, {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getAutoFitMaxRecords autoFitMaxRecords}, {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getAutoFitMaxWidth autoFitMaxWidth}, {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getAutoFitMaxColumns autoFitMaxColumns}.
     *
     * @return String
     */
    public Autofit getAutoFitData() {
        return Autofit.valueOf(getAttributeAsString("autoFitData"));
    }

    /**
     * Specifies the field by which this grid should be initially sorted.
     *
     * @param fieldName the field Name
     */
    public void setSortField(String fieldName) {
        setAttribute("sortField", fieldName, true);
    }

    /**
     * The field by which this grid should be initially sorted.
     *
     * @return the sort field
     */
    public String getSortField() {
        return getAttribute("sortField");
    }

    /**
     * Criteria to be used when {@link com.smartgwt.client.widgets.grid.ListGrid#getAutoFetchData autoFetchData} is
     * set.
     *
     * @param initialCriteria initialCriteria Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setInitialCriteria(Criteria initialCriteria) throws IllegalStateException {
        setAttribute("initialCriteria", initialCriteria.getJsObj(), false);
    }

    /**
     * Specifies the field by which this grid should be initially sorted. Note that if sortField is initally specified
     * as a number, it will be converted to a string (field name) after list grid initialization.
     *
     * @param fieldIndex the field index
     */
    public void setSortField(int fieldIndex) {
        setAttribute("sortField", fieldIndex, true);
    }

    /**
     * Header spans are a second level of headers that appear above the normal ListGrid headers, spanning one or more
     * listGrid fields in a manner similar to a column-spanning cell in an  HTML table. <P> A header span can be created
     * by simply naming the fields the header should span.  The example below creates a headerSpan that spans the first
     * two fields of the ListGrid. <pre>    isc.ListGrid.create({        headerHeight:40,        fields : [            {
     * name:"field1" },            { name:"field2" },            { name:"field3" }        ],        headerSpans : [
     *       {                 fields: ["field1", "field2"],                title: "Field 1 and 2"            }        ]
     *    }); </pre> Header spans will automatically react to resizing of the headers they span, and will be hidden
     * automatically when all of the spanned fields are hidden. <P> Header spans appear in the {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getHeader header} area of the ListGrid, sharing space with the existing
     * headers, so it's typical to set {@link com.smartgwt.client.widgets.grid.ListGrid#getHeaderHeight headerHeight} to
     * approximately double its normal height when using headerSpans. <P> See ${isc.DocUtils.linkForRef('object:HeaderSpan')}
     * for many properties that allow the control of the appearance of headerSpans.  Note that headerSpans are created
     * via the ${isc.DocUtils.linkForRef('type:AutoChild')} pattern, hence you can change the SmartClient component
     * being used, or any of it's properties. <P> Neither headerSpans themselves nor the fields within them may be drag
     * reordered, but other unspanned headers may be. <P> Note that headerSpans primarily provide a visual cue for
     * grouping multiple headers  together.  If you have an OLAP, data "cube" or multi-dimensional data model, the
     * {@link com.smartgwt.client..CubeGrid} component is the right choice.
     * Update the headerSpans configuration on the grid dynamically.
     *
     * @param headerSpans same configuration block as that passed to                                   {@link
     *                    com.smartgwt.client.widgets.grid.ListGrid#getHeaderSpans headerSpans}.. Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setHeaderSpans(HeaderSpan... headerSpans) throws IllegalStateException {
        setAttribute("headerSpans", headerSpans, false);
    }

    /**
     * List of fields to group grid records. If only a single field is used, that field may be specified as a string.
     * After initialization, use {@link com.smartgwt.client.widgets.grid.ListGrid#groupBy}  to update the grouping field
     * list, instead of modifying groupByField directly.
     *
     * @param groupByField groupByField Default value is see below
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setGroupByField(String field) throws IllegalStateException {
        setAttribute("groupByField", field, false);
    }

    /**
     * Describes the default state of ListGrid groups when groupBy is called. Possible values are: <ul> <li>"all": open
     * all groups </li><li>"first": open the first group </li><li>"none": start with all groups closed </li><li>Array of
     * values that should be opened </li> </ul>
     *
     * @param group the group
     */
    public void setGroupStartOpen(String group) {
        setAttribute("groupStartOpen", group, true);
    }

    /**
     * @param groupValues Array of values that should be opened
     */
    public void setGroupStartOpen(String... groupValues) {
        setAttribute("groupStartOpen", groupValues, true);
    }

    /**
     * Return the total number of rows in the grid. <P> Note that, when creating new rows via inline editing, this can
     * be more than the total number of rows in the dataset (that is, grid.data.getLength())
     *
     * @return the total rows
     */
    public native int getTotalRows() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        return self.getTotalRows();
    }-*/;

    /**
     * Scroll to the specified row number.
     *
     * @param rowNum the row num
     */
    public void scrollToRow(int rowNum) {
        int cellHeight = getCellHeight();
        scrollBodyTo(null, (rowNum - 1) * cellHeight);
    }

    /**
     * Scroll the body of the grid to the scified coordinates.
     *
     * @param left the left position
     * @param top the top position
     */
    public native void scrollBodyTo(Integer left, Integer top)/*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var body = self.body;

        body.scrollTo(left, top);
     }-*/;

    /**
     * Force a field to be shown. NOTE: If a field.showIf expression exists, it will be destroyed.
     *
     * @param fieldName the field name
     */
    public native void showField(String fieldName) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.showField(fieldName);
    }-*/;

    /**
     * Force a field to be shown. NOTE: If a field.showIf expression exists, it will be destroyed.
     *
     * @param fieldName        the field name
     * @param suppressRelayout if true, don't relayout non-explicit sized fields to fit the available space
     */
    public native void showField(String fieldName, boolean suppressRelayout) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.showField(fieldName, suppressRelayout);
    }-*/;

    /**
     * Change the title of a field after the grid is created.
     *
     * @param fieldNum name of the field, or index.
     * @param title    new title
     */
    public native void setFieldTitle(String fieldName, String title) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setFieldTitle(fieldName, title);
    }-*/;

    /**
     * Change the title of a field after the grid is created.
     *
     * @param fieldNum name of the field, or index.
     * @param title    new title
     */
    public native void setFieldTitle(int fieldNum, String title) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setFieldTitle(fieldNum, title);
    }-*/;

    /**
     * Force a field to be hidden. NOTE: If a field.showIf expression exists, it will be destroyed.
     *
     * @param fieldName the field name
     */
    public native void hideField(String fieldName) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.hideField(fieldName);
    }-*/;

    /**
     * Force a field to be hidden. NOTE: If a field.showIf expression exists, it will be destroyed.
     *
     * @param fieldName        the field name
     * @param suppressRelayout if true, don't relayout non-explicit sized fields to fit the available space
     */
    public native void hideField(String fieldName, boolean suppressRelayout) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.hideField(fieldName, suppressRelayout);
    }-*/;

    /**
     * Start editing a new row, after the last pre-existing record in the current set of data. This new row will be
     * saved via the "add" DataSource operation. If editing is already underway elsewhere in the grid, startEditingNew()
     * behaves just like {@link com.smartgwt.client.widgets.grid.ListGrid#startEditing()}.
     */
    public native void startEditingNew() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.startEditingNew();
    }-*/;

    /**
     * Given a field or field id, return it's index in the fields array
     *
     * @param fieldID field number or field.name
     * @return index of the field within this.fields
     */
    public native int getFieldNum(String fieldName) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        return self.getFieldNum(fieldName);
    }-*/;

    /**
     * Given a column number or field id, return the field name of a field.
     *
     * @param colNum number or id of the field.
     * @return Name of the field.
     */
    public native String getFieldName(String fieldName) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        return self.getFieldName(fieldName);
    }-*/;

    /**
     * Given a column number or field id, return the field name of a field.
     *
     * @param colNum number or id of the field.
     * @return Name of the field.
     */
    public native String getFieldName(int colNum) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        return self.getFieldName(colNum);
    }-*/;

    /**
     * Given a column number or field name, return the field definition. <P> When using {@link
     * com.smartgwt.client..DataBoundComponent#getFields fields}, the field definition may be a mix of information
     * derived from {@link com.smartgwt.client.widgets.grid.ListGrid#getFields fields} and {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getDataSource dataSource}.
     *
     * @param colNum number or id of the field.
     * @return field definition
     */
    public native ListGridField getField(String fieldName) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var field = self.getField(fieldName);

        if(field == null || field === undefined) return null;
        var fieldJ = @com.smartgwt.client.widgets.grid.ListGridField::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(field);        
        return fieldJ;
    }-*/;

    /**
     * Given a column number or field name, return the field definition. <P> When using {@link
     * com.smartgwt.client..DataBoundComponent#getFields fields}, the field definition may be a mix of information
     * derived from {@link com.smartgwt.client.widgets.grid.ListGrid#getFields fields} and {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getDataSource dataSource}.
     *
     * @param colNum number or id of the field.
     * @return field definition
     */
    public native ListGridField getField(int colNum) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var field = self.getField(colNum);
        if(field == null || field === undefined) return null;
        var fieldJ = @com.smartgwt.client.widgets.grid.ListGridField::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(field);
        return fieldJ;
    }-*/;

    /**
     * The selection associated with the listGrid.
     *
     * @return the selection
     */
    public native ListGridRecord[] getSelection() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var selectionJS =  self.getSelection();
        return @com.smartgwt.client.widgets.grid.ListGrid::convertToListGridRecordArray(Lcom/google/gwt/core/client/JavaScriptObject;)(selectionJS);
    }-*/;

    /**
     * Deselect a ${isc.DocUtils.linkForRef('object:Record')} passed in explicitly, or by index. <P> Synonym for
     * <code>selectRecord(record, false)</code>
     *
     * @param record record (or row number) to deselect
     */
    public native void deselectRecord(Record record)/*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordJS = record.@com.smartgwt.client.data.Record::getJsObj()();
        self.deselectRecord(recordJS);
     }-*/;

    /**
     * Deselect a ${isc.DocUtils.linkForRef('object:Record')} passed in explicitly, or by index. <P> Synonym for
     * <code>selectRecord(record, false)</code>
     *
     * @param record record (or row number) to deselect
     */
    public native void deselectRecord(int record)/*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.selectRecord(record);
     }-*/;

    /**
     * Deselect a list of ${isc.DocUtils.linkForRef('object:Record')}s passed in explicitly, or by index. <P> Synonym
     * for <code>selectRecords(records, false)</code>
     *
     * @param records records (or row numbers) to deselect
     */
    public native void deselectRecords(int[] records)/*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordsJS = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([I)(records);
        self.deselectRecords(recordsJS);
     }-*/;

    /**
     * Deselect a list of ${isc.DocUtils.linkForRef('object:Record')}s passed in explicitly, or by index. <P> Synonym
     * for <code>selectRecords(records, false)</code>
     *
     * @param records records (or row numbers) to deselect
     */
    public native void deselectRecords(Record[] records)/*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordsJS = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(records);
        self.deselectRecords(recordsJS);
     }-*/;

    /**
     * Select/deselect a ${isc.DocUtils.linkForRef('object:Record')} passed in explicitly, or by index.
     *
     * @param record record (or row number) to select
     */
    public native void selectRecord(Record record)/*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordJS = record.@com.smartgwt.client.data.Record::getJsObj()();
        self.selectRecord(recordJS);
     }-*/;

    /**
     * Select/deselect a ${isc.DocUtils.linkForRef('object:Record')} passed in explicitly, or by index.
     *
     * @param record record (or row number) to select
     */
    public native void selectRecord(int record)/*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.selectRecord(record);
     }-*/;

    /**
     * Select/deselect a ${isc.DocUtils.linkForRef('object:Record')} passed in explicitly, or by index.
     *
     * @param record   record (or row number) to select
     * @param newState new selection state (if null, defaults to true)
     */
    public native void selectRecord(int record, boolean newState)/*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.selectRecord(record, newState);
     }-*/;

    /**
     * Select/deselect a ${isc.DocUtils.linkForRef('object:Record')} passed in explicitly, or by index.
     *
     * @param record   record (or row number) to select
     * @param newState new selection state (if null, defaults to true)
     */
    public native void selectRecord(Record record, boolean newState)/*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordJS = record.@com.smartgwt.client.data.Record::getJsObj()();
        self.selectRecord(recordJS, newState);
     }-*/;

    /**
     * Select/deselect a list of ${isc.DocUtils.linkForRef('object:Record')}s passed in explicitly, or by index.
     *
     * @param records records (or row numbers) to select
     */
    public native void selectRecords(int[] records)/*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordsJS = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([I)(records);
        self.selectRecord(recordsJS);
     }-*/;

    /**
     * Select/deselect a list of ${isc.DocUtils.linkForRef('object:Record')}s passed in explicitly, or by index.
     *
     * @param records records (or row numbers) to select
     */
    public native void selectRecords(int[] records, boolean newState)/*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordsJS = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([I)(records);
        self.selectRecords(recordsJS, newState);
     }-*/;

    /**
     * Select/deselect a list of ${isc.DocUtils.linkForRef('object:Record')}s passed in explicitly, or by index.
     *
     * @param records records (or row numbers) to select
     */
    public native void selectRecords(Record[] records)/*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordsJS = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(records);
        self.selectRecords(recordsJS);
     }-*/;

    /**
     * Select/deselect a list of ${isc.DocUtils.linkForRef('object:Record')}s passed in explicitly, or by index.
     *
     * @param records  records (or row numbers) to select
     * @param newState new selection state (if null, defaults to true)
     */
    public native void selectRecords(Record[] records, boolean newState)/*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordsJS = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(records);
        self.selectRecords(recordsJS, newState);
     }-*/;


    private static ListGridRecord[] convertToListGridRecordArray(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new ListGridRecord[]{};
        }
        JavaScriptObject[] componentsj = JSOHelper.toArray(nativeArray);
        ListGridRecord[] objects = new ListGridRecord[componentsj.length];
        for (int i = 0; i < componentsj.length; i++) {
            JavaScriptObject componentJS = componentsj[i];
            ListGridRecord obj = (ListGridRecord) RefDataClass.getRef(componentJS);
            if (obj == null) obj = new ListGridRecord(componentJS);
            objects[i] = obj;
        }
        return objects;
    }


    /**
     * The ListGrid fields
     *
     * @return the fields
     */
    public native ListGridField[] getFields() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var fieldsJS = self.getProperty('fields');
        return @com.smartgwt.client.widgets.grid.ListGrid::convertToListGridFieldArray(Lcom/google/gwt/core/client/JavaScriptObject;)(fieldsJS);
    }-*/;

    private static ListGridField[] convertToListGridFieldArray(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new ListGridField[]{};
        }
        JavaScriptObject[] componentsj = JSOHelper.toArray(nativeArray);
        ListGridField[] objects = new ListGridField[componentsj.length];
        for (int i = 0; i < componentsj.length; i++) {
            JavaScriptObject componentJS = componentsj[i];
            //ListGridField obj = (ListGridField) RefDataClass.getRef(componentJS);
            //if (obj == null)
            ListGridField obj = new ListGridField(componentJS);
            objects[i] = obj;
        }
        return objects;
    }

    /**
     * Uses a "fetch" operation on the current {@link com.smartgwt.client.data.DataSource} to retrieve data that matches
     * the provided criteria, and displays the matching data in this component. <P> If there are a large number of
     * matching records, paging will automatically be enabled, so that initially a smaller number of records will be
     * retrieved and further records will be fetched as the user navigates the dataset. <P> When first called, this
     * method will create a {@link com.smartgwt.client.data.ResultSet}, which will be configured based on component
     * settings such as {@link com.smartgwt.client..DataBoundComponent#getFetchOperation fetchOperation} and {@link
     * com.smartgwt.client..DataBoundComponent#getDataPageSize dataPageSize}, as well as the general purpose {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getDataProperties dataProperties}.  The ResultSet is then available as
     * <code>component.data</code>. <P> Subsequent calls to fetchData() will simply call {@link
     * com.smartgwt.client.data.ResultSet#setCriteria} on the created ResultSet with the passed criteria. <P> In some
     * cases fetchData() will not need to context the server as the new criteria can be satisfied by performing a
     * client-side filter against the currently cached set of data. You can determine whether criteria will cause a
     * fetch by calling  {@link com.smartgwt.client.data.ResultSet#willFetchData}. <P> If you need to force a server
     * fetch, you can call {@link com.smartgwt.client.data.ResultSet#invalidateCache} via
     * <code>component.data.invalidateCache()</code> to do so.   <P> This method takes an optional callback parameter
     * (set to a ${isc.DocUtils.linkForRef('type:DSCallback')}) to fire when the fetch completes. Note that this
     * callback will not fire if no server fetch is performed. In this case the data is updated synchronously, so as
     * soon as this method completes you can interact with the new data. If necessary we recomment using  {@link
     * com.smartgwt.client.data.ResultSet#willFetchData} before calling this method to determine whether or not a server
     * fetch will occur. <P> In addition to the callback parameter for this method, developers can use  {@link
     * com.smartgwt.client.data.ResultSet#dataArrived} to be notified every time ResultSet data is loaded.  A
     * <code>dataArrived</code> method can be installed in the automatically created ResultSet by adding it to {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getDataProperties dataProperties}.
     */
    public native void fetchData() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.fetchData();
    }-*/;

    /**
     * Uses a "fetch" operation on the current {@link com.smartgwt.client.data.DataSource} to retrieve data that matches
     * the provided criteria, and displays the matching data in this component. <P> If there are a large number of
     * matching records, paging will automatically be enabled, so that initially a smaller number of records will be
     * retrieved and further records will be fetched as the user navigates the dataset. <P> When first called, this
     * method will create a {@link com.smartgwt.client.data.ResultSet}, which will be configured based on component
     * settings such as {@link com.smartgwt.client..DataBoundComponent#getFetchOperation fetchOperation} and {@link
     * com.smartgwt.client..DataBoundComponent#getDataPageSize dataPageSize}, as well as the general purpose {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getDataProperties dataProperties}.  The ResultSet is then available as
     * <code>component.data</code>. <P> Subsequent calls to fetchData() will simply call {@link
     * com.smartgwt.client.data.ResultSet#setCriteria} on the created ResultSet with the passed criteria. <P> In some
     * cases fetchData() will not need to context the server as the new criteria can be satisfied by performing a
     * client-side filter against the currently cached set of data. You can determine whether criteria will cause a
     * fetch by calling  {@link com.smartgwt.client.data.ResultSet#willFetchData}. <P> If you need to force a server
     * fetch, you can call {@link com.smartgwt.client.data.ResultSet#invalidateCache} via
     * <code>component.data.invalidateCache()</code> to do so.   <P> This method takes an optional callback parameter
     * (set to a ${isc.DocUtils.linkForRef('type:DSCallback')}) to fire when the fetch completes. Note that this
     * callback will not fire if no server fetch is performed. In this case the data is updated synchronously, so as
     * soon as this method completes you can interact with the new data. If necessary we recomment using  {@link
     * com.smartgwt.client.data.ResultSet#willFetchData} before calling this method to determine whether or not a server
     * fetch will occur. <P> In addition to the callback parameter for this method, developers can use  {@link
     * com.smartgwt.client.data.ResultSet#dataArrived} to be notified every time ResultSet data is loaded.  A
     * <code>dataArrived</code> method can be installed in the automatically created ResultSet by adding it to {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getDataProperties dataProperties}.
     *
     * @param criteria Search criteria.                       If a {@link com.smartgwt.client.widgets.form.DynamicForm}
     *                 is passed in as this argument                      instead of a raw criteria object, will be
     *                 derived by calling                      {@link com.smartgwt.client.widgets.form.DynamicForm#getValuesAsCriteria}
     */
    public native void fetchData(Criteria criteria) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.fetchData(criteria == null ? null : criteria.@com.smartgwt.client.data.Criteria::getJsObj()());
    }-*/;

    /**
     * Uses a "fetch" operation on the current {@link com.smartgwt.client.data.DataSource} to retrieve data that matches
     * the provided criteria, and displays the matching data in this component. <P> If there are a large number of
     * matching records, paging will automatically be enabled, so that initially a smaller number of records will be
     * retrieved and further records will be fetched as the user navigates the dataset. <P> When first called, this
     * method will create a {@link com.smartgwt.client.data.ResultSet}, which will be configured based on component
     * settings such as {@link com.smartgwt.client..DataBoundComponent#getFetchOperation fetchOperation} and {@link
     * com.smartgwt.client..DataBoundComponent#getDataPageSize dataPageSize}, as well as the general purpose {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getDataProperties dataProperties}.  The ResultSet is then available as
     * <code>component.data</code>. <P> Subsequent calls to fetchData() will simply call {@link
     * com.smartgwt.client.data.ResultSet#setCriteria} on the created ResultSet with the passed criteria. <P> In some
     * cases fetchData() will not need to context the server as the new criteria can be satisfied by performing a
     * client-side filter against the currently cached set of data. You can determine whether criteria will cause a
     * fetch by calling  {@link com.smartgwt.client.data.ResultSet#willFetchData}. <P> If you need to force a server
     * fetch, you can call {@link com.smartgwt.client.data.ResultSet#invalidateCache} via
     * <code>component.data.invalidateCache()</code> to do so.   <P> This method takes an optional callback parameter
     * (set to a ${isc.DocUtils.linkForRef('type:DSCallback')}) to fire when the fetch completes. Note that this
     * callback will not fire if no server fetch is performed. In this case the data is updated synchronously, so as
     * soon as this method completes you can interact with the new data. If necessary we recomment using  {@link
     * com.smartgwt.client.data.ResultSet#willFetchData} before calling this method to determine whether or not a server
     * fetch will occur. <P> In addition to the callback parameter for this method, developers can use  {@link
     * com.smartgwt.client.data.ResultSet#dataArrived} to be notified every time ResultSet data is loaded.  A
     * <code>dataArrived</code> method can be installed in the automatically created ResultSet by adding it to {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getDataProperties dataProperties}.
     *
     * @param criteria Search criteria.                       If a {@link com.smartgwt.client.widgets.form.DynamicForm}
     *                 is passed in as this argument                      instead of a raw criteria object, will be
     *                 derived by calling                      {@link com.smartgwt.client.widgets.form.DynamicForm#getValuesAsCriteria}
     * @param callback callback to invoke when a fetch is complete.  Fires                                          only
     *                 if server contact was required
     */
    public native void fetchData(Criteria criteria, DSCallback callback) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var critJS = criteria == null ? null : criteria.@com.smartgwt.client.data.Criteria::getJsObj()();
        self.fetchData(critJS, function (dsResponse, data, dsRequest) {
            var responseJ = @com.smartgwt.client.data.DSResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsResponse);
            var requestJ = @com.smartgwt.client.data.DSRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsRequest);
            if(callback != null) callback.@com.smartgwt.client.data.DSCallback::execute(Lcom/smartgwt/client/data/DSResponse;Ljava/lang/Object;Lcom/smartgwt/client/data/DSRequest;)(responseJ, data, requestJ);
        });
    }-*/;

    /**
     * Uses a "fetch" operation on the current {@link com.smartgwt.client.data.DataSource} to retrieve data that matches
     * the provided criteria, and displays the matching data in this component. <P> If there are a large number of
     * matching records, paging will automatically be enabled, so that initially a smaller number of records will be
     * retrieved and further records will be fetched as the user navigates the dataset. <P> When first called, this
     * method will create a {@link com.smartgwt.client.data.ResultSet}, which will be configured based on component
     * settings such as {@link com.smartgwt.client..DataBoundComponent#getFetchOperation fetchOperation} and {@link
     * com.smartgwt.client..DataBoundComponent#getDataPageSize dataPageSize}, as well as the general purpose {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getDataProperties dataProperties}.  The ResultSet is then available as
     * <code>component.data</code>. <P> Subsequent calls to fetchData() will simply call {@link
     * com.smartgwt.client.data.ResultSet#setCriteria} on the created ResultSet with the passed criteria. <P> In some
     * cases fetchData() will not need to context the server as the new criteria can be satisfied by performing a
     * client-side filter against the currently cached set of data. You can determine whether criteria will cause a
     * fetch by calling  {@link com.smartgwt.client.data.ResultSet#willFetchData}. <P> If you need to force a server
     * fetch, you can call {@link com.smartgwt.client.data.ResultSet#invalidateCache} via
     * <code>component.data.invalidateCache()</code> to do so.   <P> This method takes an optional callback parameter
     * (set to a ${isc.DocUtils.linkForRef('type:DSCallback')}) to fire when the fetch completes. Note that this
     * callback will not fire if no server fetch is performed. In this case the data is updated synchronously, so as
     * soon as this method completes you can interact with the new data. If necessary we recomment using  {@link
     * com.smartgwt.client.data.ResultSet#willFetchData} before calling this method to determine whether or not a server
     * fetch will occur. <P> In addition to the callback parameter for this method, developers can use  {@link
     * com.smartgwt.client.data.ResultSet#dataArrived} to be notified every time ResultSet data is loaded.  A
     * <code>dataArrived</code> method can be installed in the automatically created ResultSet by adding it to {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getDataProperties dataProperties}.
     *
     * @param criteria          Search criteria.                       If a {@link com.smartgwt.client.widgets.form.DynamicForm}
     *                          is passed in as this argument                      instead of a raw criteria object,
     *                          will be derived by calling                      {@link com.smartgwt.client.widgets.form.DynamicForm#getValuesAsCriteria}
     * @param callback          callback to invoke when a fetch is complete.  Fires
     *                          only if server contact was required
     * @param requestProperties additional properties to set on the DSRequest
     *                          that will be issued
     */
    public native void fetchData(Criteria criteria, DSCallback callback, DSRequest requestProperties) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var critJS = criteria == null ? null : criteria.@com.smartgwt.client.data.Criteria::getJsObj()();
        var requestPropertiesJS = requestProperties == null ? null : requestProperties.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.fetchData(critJS, function (dsResponse, data, dsRequest) {
            var responseJ = @com.smartgwt.client.data.DSResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsResponse);
            var requestJ = @com.smartgwt.client.data.DSRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsRequest);
            if(callback != null) callback.@com.smartgwt.client.data.DSCallback::execute(Lcom/smartgwt/client/data/DSResponse;Ljava/lang/Object;Lcom/smartgwt/client/data/DSRequest;)(responseJ, data, requestJ);
        }, requestPropertiesJS);
    }-*/;

    /**
     * Retrieves data that matches the provided criteria and displays the matching data in this component. <P> This
     * method behaves exactly like {@link com.smartgwt.client.widgets.grid.ListGrid#fetchData} except that {@link
     * com.smartgwt.client.data.DSRequest#getTextMatchStyle textMatchStyle} is automatically set to "substring" so that
     * String-valued fields are matched by case-insensitive substring comparison.
     *
     * @param criteria Search criteria.                       If a {@link com.smartgwt.client.widgets.form.DynamicForm}
     *                 is passed in as this argument                      instead of a raw criteria object, will be
     *                 derived by calling                      {@link com.smartgwt.client.widgets.form.DynamicForm#getValuesAsCriteria}
     */
    public native void filterData(Criteria criteria) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.filterData(criteria == null ? null : criteria.@com.smartgwt.client.data.Criteria::getJsObj()());
    }-*/;

    /**
     * Retrieves data that matches the provided criteria and displays the matching data in this component. <P> This
     * method behaves exactly like {@link com.smartgwt.client.widgets.grid.ListGrid#fetchData} except that {@link
     * com.smartgwt.client.data.DSRequest#getTextMatchStyle textMatchStyle} is automatically set to "substring" so that
     * String-valued fields are matched by case-insensitive substring comparison.
     *
     * @param criteria Search criteria.                       If a {@link com.smartgwt.client.widgets.form.DynamicForm}
     *                 is passed in as this argument                      instead of a raw criteria object, will be
     *                 derived by calling                      {@link com.smartgwt.client.widgets.form.DynamicForm#getValuesAsCriteria}
     * @param callback callback to invoke when a fetch is complete.  Fires                                          only
     *                 if server contact was required; see                                          {@link
     *                 com.smartgwt.client..DataBoundComponent#fetchData} for details
     */
    public native void filterData(Criteria criteria, DSCallback callback) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var critJS = criteria == null ? null : criteria.@com.smartgwt.client.data.Criteria::getJsObj()();
        self.filterData(critJS, function (dsResponse, data, dsRequest) {
            var responseJ = @com.smartgwt.client.data.DSResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsResponse);
            var requestJ = @com.smartgwt.client.data.DSRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsRequest);
            if(callback != null) callback.@com.smartgwt.client.data.DSCallback::execute(Lcom/smartgwt/client/data/DSResponse;Ljava/lang/Object;Lcom/smartgwt/client/data/DSRequest;)(responseJ, data, requestJ);
        });
    }-*/;

    /**
     * Retrieves data that matches the provided criteria and displays the matching data in this component. <P> This
     * method behaves exactly like {@link com.smartgwt.client.widgets.grid.ListGrid#fetchData} except that {@link
     * com.smartgwt.client.data.DSRequest#getTextMatchStyle textMatchStyle} is automatically set to "substring" so that
     * String-valued fields are matched by case-insensitive substring comparison.
     *
     * @param criteria          Search criteria.                       If a {@link com.smartgwt.client.widgets.form.DynamicForm}
     *                          is passed in as this argument                      instead of a raw criteria object,
     *                          will be derived by calling                      {@link com.smartgwt.client.widgets.form.DynamicForm#getValuesAsCriteria}
     * @param callback          callback to invoke when a fetch is complete.  Fires
     *                              only if server contact was required; see
     *                          {@link com.smartgwt.client..DataBoundComponent#fetchData} for details
     * @param requestProperties for databound components only - optional                            additional
     *                          properties to set on the DSRequest that will be issued
     */
    public native void filterData(Criteria criteria, DSCallback callback, DSRequest requestProperties) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var critJS = criteria == null ? null : criteria.@com.smartgwt.client.data.Criteria::getJsObj()();
        var requestPropertiesJS = requestProperties == null ? null : requestProperties.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.filterData(critJS, function (dsResponse, data, dsRequest) {
            var responseJ = @com.smartgwt.client.data.DSResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsResponse);
            var requestJ = @com.smartgwt.client.data.DSRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsRequest);
            if(callback != null) callback.@com.smartgwt.client.data.DSCallback::execute(Lcom/smartgwt/client/data/DSResponse;Ljava/lang/Object;Lcom/smartgwt/client/data/DSRequest;)(responseJ, data, requestJ);
        }, requestPropertiesJS);
    }-*/;

    /**
     * Open the current record detail grid inline,
     *
     * @param record
     * @param detailDataSource the detail deta source
     */
    public native void openRecordDetailGrid(ListGridRecord record, DataSource detailDataSource)/*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordJS = record.@com.smartgwt.client.widgets.grid.ListGridRecord::getJsObj()();
        var datasourceJS = detailDataSource.@com.smartgwt.client.data.DataSource::getOrCreateJsObj()();
        self.openRecordDetailGrid(recordJS, datasourceJS);
     }-*/;

    /**
     * Close the inline detail grid assoicated with the record.
     *
     * @param record the record
     */
    public native void closeRecord(ListGridRecord record)/*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordJS = record.@com.smartgwt.client.widgets.grid.ListGridRecord::getJsObj()();
        self.closeRecord(recordJS);
     }-*/;

    /**
     * Open the record editor associated with the record.
     *
     * @param record the record
     */
    public native void openRecordEditor(ListGridRecord record)/*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordJS = record.@com.smartgwt.client.widgets.grid.ListGridRecord::getJsObj()();
        self.openRecordEditor(recordJS);
     }-*/;

    /**
     * Perform a DataSource "add" operation to add new records to this component's DataSource.
     *
     * @param newRecord new record
     */
    public native void addData(Record record) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordJS = record.@com.smartgwt.client.data.Record::getJsObj()();
        self.addData(recordJS);
    }-*/;

    /**
     * Perform a DataSource "add" operation to add new records to this component's DataSource.
     *
     * @param newRecord new record
     * @param callback  method to call on operation completion
     */
    public native void addData(Record record, DSCallback callback) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordJS = record.@com.smartgwt.client.data.Record::getJsObj()();
        self.addData(recordJS, function (dsResponse, data, dsRequest) {
            var responseJ = @com.smartgwt.client.data.DSResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsResponse);
            var requestJ = @com.smartgwt.client.data.DSRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsRequest);
            if(callback != null) callback.@com.smartgwt.client.data.DSCallback::execute(Lcom/smartgwt/client/data/DSResponse;Ljava/lang/Object;Lcom/smartgwt/client/data/DSRequest;)(responseJ, data, requestJ);
        });
    }-*/;

    /**
     * Perform a DataSource "add" operation to add new records to this component's DataSource.
     *
     * @param newRecord         new record
     * @param callback          method to call on operation completion
     * @param requestProperties additional properties to set on the DSRequest
     *                          that will be issued
     */
    public native void addData(Record record, DSCallback callback, DSRequest requestProperties) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordJS = record.@com.smartgwt.client.data.Record::getJsObj()();
        var requestPropertiesJS = requestProperties == null ? null : requestProperties.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.addData(recordJS, function (dsResponse, data, dsRequest) {
            var responseJ = @com.smartgwt.client.data.DSResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsResponse);
            var requestJ = @com.smartgwt.client.data.DSRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsRequest);
            if(callback != null) callback.@com.smartgwt.client.data.DSCallback::execute(Lcom/smartgwt/client/data/DSResponse;Ljava/lang/Object;Lcom/smartgwt/client/data/DSRequest;)(responseJ, data, requestJ);
        }, requestPropertiesJS);
    }-*/;

    /**
     * Perform a DataSource "update" operation to update existing records in this component's DataSource.
     *
     * @param updatedRecord updated record
     */
    public native void updateData(Record record) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordJS = record.@com.smartgwt.client.data.Record::getJsObj()();
        self.updateData(recordJS);
    }-*/;

    /**
     * Perform a DataSource "update" operation to update existing records in this component's DataSource.
     *
     * @param updatedRecord updated record
     * @param callback      method to call on operation completion
     */
    public native void updateData(Record record, DSCallback callback) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordJS = record.@com.smartgwt.client.data.Record::getJsObj()();
        self.updateData(recordJS, function (dsResponse, data, dsRequest) {
            var responseJ = @com.smartgwt.client.data.DSResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsResponse);
            var requestJ = @com.smartgwt.client.data.DSRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsRequest);
            if(callback != null) callback.@com.smartgwt.client.data.DSCallback::execute(Lcom/smartgwt/client/data/DSResponse;Ljava/lang/Object;Lcom/smartgwt/client/data/DSRequest;)(responseJ, data, requestJ);
        });
    }-*/;

    /**
     * Perform a DataSource "update" operation to update existing records in this component's DataSource.
     *
     * @param updatedRecord     updated record
     * @param callback          method to call on operation completion
     * @param requestProperties additional properties to set on the DSRequest
     *                          that will be issued
     */
    public native void updateData(Record record, DSCallback callback, DSRequest requestProperties) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordJS = record.@com.smartgwt.client.data.Record::getJsObj()();
        var requestPropertiesJS = requestProperties == null ? null : requestProperties.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.updateData(recordJS, function (dsResponse, data, dsRequest) {
            var responseJ = @com.smartgwt.client.data.DSResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsResponse);
            var requestJ = @com.smartgwt.client.data.DSRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsRequest);
            if(callback != null) callback.@com.smartgwt.client.data.DSCallback::execute(Lcom/smartgwt/client/data/DSResponse;Ljava/lang/Object;Lcom/smartgwt/client/data/DSRequest;)(responseJ, data, requestJ);
        }, requestPropertiesJS);
    }-*/;

    /**
     * Perform a DataSource "remove" operation to remove records from this component's DataSource.
     *
     * @param data primary key values of record to delete,                                           (or complete
     *             record)
     */
    public native void removeData(Record record) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordJS = record.@com.smartgwt.client.data.Record::getJsObj()();
        self.removeData(recordJS);
    }-*/;

    /**
     * Perform a DataSource "remove" operation to remove records from this component's DataSource.
     *
     * @param data     primary key values of record to delete,                                           (or complete
     *                 record)
     * @param callback method to call on operation completion
     */
    public native void removeData(Record record, DSCallback callback) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordJS = record.@com.smartgwt.client.data.Record::getJsObj()();
        self.removeData(recordJS, function (dsResponse, data, dsRequest) {
            var responseJ = @com.smartgwt.client.data.DSResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsResponse);
            var requestJ = @com.smartgwt.client.data.DSRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsRequest);
            if(callback != null) callback.@com.smartgwt.client.data.DSCallback::execute(Lcom/smartgwt/client/data/DSResponse;Ljava/lang/Object;Lcom/smartgwt/client/data/DSRequest;)(responseJ, data, requestJ);
        });
    }-*/;

    /**
     * Perform a DataSource "remove" operation to remove records from this component's DataSource.
     *
     * @param data              primary key values of record to delete,                                           (or
     *                          complete record)
     * @param callback          method to call on operation completion
     * @param requestProperties additional properties to set on the DSRequest
     *                          that will be issued
     */
    public native void removeData(Record record, DSCallback callback, DSRequest requestProperties) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordJS = record.@com.smartgwt.client.data.Record::getJsObj()();
        var requestPropertiesJS = requestProperties == null ? null : requestProperties.@com.smartgwt.client.core.DataClass::getJsObj()();       
        self.removeData(recordJS, function (dsResponse, data, dsRequest) {
            var responseJ = @com.smartgwt.client.data.DSResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsResponse);
            var requestJ = @com.smartgwt.client.data.DSRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsRequest);
            if(callback != null) callback.@com.smartgwt.client.data.DSCallback::execute(Lcom/smartgwt/client/data/DSResponse;Ljava/lang/Object;Lcom/smartgwt/client/data/DSRequest;)(responseJ, data, requestJ);
        }, requestPropertiesJS);
    }-*/;

    /**
     * Remove the currently selected records from this component. If this is a databound grid, the records will be
     * removed directly from the DataSource. <P> If no records are selected, no action is taken. The grid will
     * automatically be updated if the record deletion succeeds.
     */
    public native void removeSelectedData() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.removeSelectedData();
    }-*/;

    /**
     * Remove the currently selected records from this component. If this is a databound grid, the records will be
     * removed directly from the DataSource. <P> If no records are selected, no action is taken. The grid will
     * automatically be updated if the record deletion succeeds.
     *
     * @param callback          callback to fire when the data has been removed
     * @param requestProperties additional properties to set on the DSRequest
     *                          that will be issued
     */
    public native void removeSelectedData(DSCallback callback, DSRequest requestProperties) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var requestPropertiesJS = requestProperties == null ? null : requestProperties.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.removeData(function (dsResponse, data, dsRequest) {
            var responseJ = @com.smartgwt.client.data.DSResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsResponse);
            var requestJ = @com.smartgwt.client.data.DSRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsRequest);
            if(callback != null) callback.@com.smartgwt.client.data.DSCallback::execute(Lcom/smartgwt/client/data/DSResponse;Ljava/lang/Object;Lcom/smartgwt/client/data/DSRequest;)(responseJ, data, requestJ);
        }, requestPropertiesJS);
    }-*/;

    /**
     * Display the current set of records grouped by their values for the given field or fields. With no arguments,
     * disables all grouping. <P> Grouping tranforms the current dataset into a Tree on the fly, then provides a
     * familiar tree interface for exploring the grouped data. <P> Grouping works automatically with any dataset,
     * providing simple default grouping based on each field's declared type.  However, you can use the {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getGroupValue} API to control how records are grouped, and the
     * {@link com.smartgwt.client.widgets.grid.ListGridField#getGroupTitle} API to control how groups are titled. <P>
     * Grouping can be performed programmatically via this API, or you can set {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getCanGroupBy canGroupBy} to enable menus that allow the user to
     * performing grouping. To group a grid automatically, instantiate the grid with a  {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getGroupByField groupByField} setting. <P> While grouped, the
     * automatically created Tree is available as {@link com.smartgwt.client.widgets.grid.ListGrid#getGroupTree
     * groupTree} and the original dataset is availabe as {@link com.smartgwt.client.widgets.grid.ListGrid#getOriginalData
     * originalData}.
     */
    public native void groupBy(String... fields) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        fieldsJS = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(fields);
        self.groupBy(fieldsJS);
    }-*/;

    /**
     * Clear the current criteria used to filter data.
     */
    public native void clearCriteria() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.clearCriteria();
    }-*/;

    /**
     * Clear the current criteria used to filter data.
     *
     * @param callback          callback to invoke on completion
     * @param requestProperties additional properties to set on the DSRequest
     *                          that will be issued
     */
    public native void clearCriteria(DSCallback callback, DSRequest requestProperties) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var requestPropertiesJS = requestProperties == null ? null : requestProperties.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.clearCriteria(function (dsResponse, data, dsRequest) {
            var responseJ = @com.smartgwt.client.data.DSResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsResponse);
            var requestJ = @com.smartgwt.client.data.DSRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsRequest);
            if(callback != null) callback.@com.smartgwt.client.data.DSCallback::execute(Lcom/smartgwt/client/data/DSResponse;Ljava/lang/Object;Lcom/smartgwt/client/data/DSRequest;)(responseJ, data, requestJ);
        }, requestPropertiesJS);
    }-*/;

    /**
     * Sort data by given property.
     *
     * @param property  the name
     * @param ascending direction
     */
    public native void sortByProperty(String property, boolean ascending) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.data.sortByProperty(property, ascending);
    }-*/;

    /**
     * Save a number of outstanding edits for this ListGrid. If no rows are specifed, all  outstanding edits will be
     * saved
     */
    public native void saveAllEdits() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.saveAllEdits();
    }-*/;

    /**
     * Cancel outstanding edits, discarding edit values, and hiding editors for the record[s] passed in if appropriate.
     * If no rows are passed in all outstanding edit values will be dropped.
     */
    public native void discardAllEdits() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.discardAllEdits();
    }-*/;

    /**
     * Freeze the indicated field, so that it remains in place and visible when horizontal scrolling occurs.
     *
     * @param field
     */
    public native void freezeField(String fieldName) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.freezeField(fieldName);
    }-*/;

    /**
     * Freeze the indicated field, so that it remains in place and visible when horizontal scrolling occurs.
     *
     * @param field
     */
    public native void freezeField(int colNum) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.freezeField(colNum);
    }-*/;

    /**
     * Unfreeze a frozen field, so that it will now scroll along with other fields when horizontal scrolling occurs.
     *
     * @param field
     */
    public native void unfreezeField(String fieldName) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.freezeField(fieldName);
    }-*/;

    /**
     * Unfreeze a frozen field, so that it will now scroll along with other fields when horizontal scrolling occurs.
     *
     * @param field
     */
    public native void unfreezeField(int colNum) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.freezeField(colNum);
    }-*/;

    /**
     * Refresh an individual cell without redrawing the grid. <P> The cell's value, CSS class, and CSS text will be
     * refreshed, to the current values returned by getCellValue(), getCellStyle() and getCellCSSText() respectively.
     *
     * @param rowNum row number of cell to refresh
     * @param colNum column number of cell to refresh
         */
    public native void refreshCell(int rowNum, int colNum, boolean refreshingRow, boolean allowEditCellRefresh) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.refreshCell(rowNum, colNum, refreshingRow, allowEditCellRefresh);
    }-*/;

    /**
     * Get the rows that are currently visible in the viewport, as an array of  [firstRowNum, lastRowNum]. If the grid contains no records, will return [-1,-1];
     *
     * @return the visible rows
     */
    public native Integer[] getVisibleRows() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getVisibleRows();
        return @com.smartgwt.client.util.JSOHelper::convertToJavaInterArray(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

    /**
     * Get the rows that are currently drawn (exist in the DOM), as an array of [firstRowNum, lastRowNum].   <P> The drawn rows differ from the {@link com.smartgwt.client.widgets.grid.ListGrid#getVisibleRows} because of {@link com.smartgwt.client.widgets.grid.ListGrid#getDrawAheadRatio drawAheadRatio}.  The drawn rows are the apppropriate range to consider if you need to, eg, using {@link com.smartgwt.client.widgets.grid.ListGrid#refreshCell} to update all the cells in a column. <P> If the grid is undrawn or the {@link com.smartgwt.client.widgets.grid.ListGrid#getEmptyMessage emptyMessage} is currently shown, returns [null,null];
     *
     * @return the drawn rows
     */
    public native Integer[] getDrawnRows() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getDrawnRows();
        return @com.smartgwt.client.util.JSOHelper::convertToJavaInterArray(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

    /**
     * Based on the relationship between the DataSource this component is bound to and the DataSource specified as the
     * "schema" argument, call fetchData() to retrieve records in this grid that are related to the passed-in record.
     * <p/>
     * Relationships between DataSources are declared via DataSourceField.foreignKey.
     * <p/>
     * For example, given a DataSource "orders" and another DataSource "orderItems", where "orderItems" declared a field
     * "orderId" pointing to the primary key field of the "orders" DataSource", there is a set of records from the
     * "orderItems" DataSource related to any given record from the "order" DataSource. If this component were bound to
     * "orderItems" and a record from the "orders".
     *
     * @param record     the DataSource record
     * @param dataSource the schema of the DataSource record
     */
    public native void fetchRelatedData(Record record, DataSource dataSource) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordJS = record.@com.smartgwt.client.data.Record::getJsObj()();
        var datasourceJS = dataSource.@com.smartgwt.client.data.DataSource::getOrCreateJsObj()();
        self.fetchRelatedData(recordJS, datasourceJS);
    }-*/;

    /**
     * Based on the relationship between the DataSource this component is bound to and the DataSource specified as the
     * "schema" argument, call fetchData() to retrieve records in this grid that are related to the passed-in record.
     * <p/>
     * Relationships between DataSources are declared via DataSourceField.foreignKey.
     * <p/>
     * For example, given a DataSource "orders" and another DataSource "orderItems", where "orderItems" declared a field
     * "orderId" pointing to the primary key field of the "orders" DataSource", there is a set of records from the
     * "orderItems" DataSource related to any given record from the "order" DataSource. If this component were bound to
     * "orderItems" and a record from the "orders".
     *
     * @param record            the DataSource record
     * @param dataSource        the schema of the DataSource record
     * @param callback          callback to invoke on completion
     * @param requestProperties additional properties to set on the DSRequest that will be issued
     */
    public native void fetchRelatedData(Record record, DataSource dataSource, DSCallback callback, DSRequest requestProperties) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordJS = record.@com.smartgwt.client.data.Record::getJsObj()();
        var datasourceJS = dataSource.@com.smartgwt.client.data.DataSource::getOrCreateJsObj()();
        var requestPropertiesJS = requestProperties == null ? null : requestProperties.@com.smartgwt.client.core.DataClass::getJsObj()();

        self.fetchRelatedData(recordJS, datasourceJS, function (dsResponse, data, dsRequest) {
            var responseJ = @com.smartgwt.client.data.DSResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsResponse);
            var requestJ = @com.smartgwt.client.data.DSRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsRequest);
            if(callback != null) callback.@com.smartgwt.client.data.DSCallback::execute(Lcom/smartgwt/client/data/DSResponse;Ljava/lang/Object;Lcom/smartgwt/client/data/DSRequest;)(responseJ, data, requestJ);
        }, requestPropertiesJS);

    }-*/;
    

}





