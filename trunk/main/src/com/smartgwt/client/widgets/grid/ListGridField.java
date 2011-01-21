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
 * An ordinary JavaScript object containing properties that configures the display of and interaction with the columns of a
 * {@link com.smartgwt.client.widgets.grid.ListGrid}.
 * @see com.smartgwt.client.widgets.grid.ListGrid#getFields
 * @see com.smartgwt.client.widgets.grid.ListGrid#setFields
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
     * If true, automatically fetches records and derives a valueMap from {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getOptionDataSource optionDataSource}. <p> Same as {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getAutoFetchDisplayMap autoFetchDisplayMap}, but defined on a per-field basis.
     *
     * @param autoFetchDisplayMap autoFetchDisplayMap Default value is null
     * @see com.smartgwt.client.widgets.grid.ListGrid#setAutoFetchDisplayMap
     */
    public void setAutoFetchDisplayMap(Boolean autoFetchDisplayMap) {
        setAttribute("autoFetchDisplayMap", autoFetchDisplayMap);
    }

    /**
     * If true, automatically fetches records and derives a valueMap from {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getOptionDataSource optionDataSource}. <p> Same as {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getAutoFetchDisplayMap autoFetchDisplayMap}, but defined on a per-field basis.
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.widgets.grid.ListGrid#getAutoFetchDisplayMap
     */
    public Boolean getAutoFetchDisplayMap()  {
        return getAttributeAsBoolean("autoFetchDisplayMap");
    }

    /**
     * Enables autofitting to values or titles for this field.. This overrides the {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getAutoFitFieldWidths autoFitFieldWidths} attribute on a per-field basis.
     *
     * @param autoFitWidth autoFitWidth Default value is null
     */
    public void setAutoFitWidth(Boolean autoFitWidth) {
        setAttribute("autoFitWidth", autoFitWidth);
    }

    /**
     * Enables autofitting to values or titles for this field.. This overrides the {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getAutoFitFieldWidths autoFitFieldWidths} attribute on a per-field basis.
     *
     *
     * @return Boolean
     */
    public Boolean getAutoFitWidth()  {
        return getAttributeAsBoolean("autoFitWidth");
    }

    /**
     * When a user requests column autofitting via the  {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getGetHeaderContextMenuItems header contextmenu} or via a  {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getHeaderAutoFitEvent mouse gesture}, what autofit approach is used. If
     * set, this setting overrides the autoFitWidthApproach specified at the ListGrid level.
     *
     * @param autoFitWidthApproach autoFitWidthApproach Default value is null
     */
    public void setAutoFitWidthApproach(AutoFitWidthApproach autoFitWidthApproach) {
        setAttribute("autoFitWidthApproach", autoFitWidthApproach.getValue());
    }

    /**
     * When a user requests column autofitting via the  {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getGetHeaderContextMenuItems header contextmenu} or via a  {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getHeaderAutoFitEvent mouse gesture}, what autofit approach is used. If
     * set, this setting overrides the autoFitWidthApproach specified at the ListGrid level.
     *
     *
     * @return AutoFitWidthApproach
     */
    public AutoFitWidthApproach getAutoFitWidthApproach()  {
        return EnumUtil.getEnum(AutoFitWidthApproach.values(), getAttribute("autoFitWidthApproach"));
    }

    /**
     * Whether this field should be automatically frozen when other fields are frozen.  When true, the field will be
     * automatically frozen to the extreme of the grid.  The automatically generated {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getCheckboxField checkbox}, {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getExpansionField expansion} and  {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getRowNumberField rowNumber} fields are examples of fields that specify
     * <code>autoFreeze: true</code>. <P> You can control the position of this field in the array of frozen fields by providing
     * a {@link com.smartgwt.client.widgets.grid.ListGridField#getAutoFreezePosition ListGridField.getAutoFreezePosition}
     * implementation.
     *
     * @param autoFreeze autoFreeze Default value is null
     * @see com.smartgwt.client.docs.FrozenFields FrozenFields overview and related methods
     */
    public void setAutoFreeze(Boolean autoFreeze) {
        setAttribute("autoFreeze", autoFreeze);
    }

    /**
     * Whether this field should be automatically frozen when other fields are frozen.  When true, the field will be
     * automatically frozen to the extreme of the grid.  The automatically generated {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getCheckboxField checkbox}, {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getExpansionField expansion} and  {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getRowNumberField rowNumber} fields are examples of fields that specify
     * <code>autoFreeze: true</code>. <P> You can control the position of this field in the array of frozen fields by providing
     * a {@link com.smartgwt.client.widgets.grid.ListGridField#getAutoFreezePosition ListGridField.getAutoFreezePosition}
     * implementation.
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.docs.FrozenFields FrozenFields overview and related methods
     */
    public Boolean getAutoFreeze()  {
        return getAttributeAsBoolean("autoFreeze");
    }

    /**
     * Custom base style to apply to all cells in this field instead of {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getBaseStyle baseStyle}  To override the baseStyle at the row level, use  
     * {@link com.smartgwt.client.widgets.grid.ListGrid#getRecordBaseStyleProperty record[listGrid.recordBaseStyleProperty]} 
     * instead.
     *
     * @param baseStyle baseStyle Default value is null
     * @see com.smartgwt.client.widgets.grid.ListGrid#setRecordBaseStyleProperty
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#effects_lf_grid_cells" target="examples">Grid cells Example</a>
     */
    public void setBaseStyle(String baseStyle) {
        setAttribute("baseStyle", baseStyle);
    }

    /**
     * Custom base style to apply to all cells in this field instead of {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getBaseStyle baseStyle}  To override the baseStyle at the row level, use  
     * {@link com.smartgwt.client.widgets.grid.ListGrid#getRecordBaseStyleProperty record[listGrid.recordBaseStyleProperty]} 
     * instead.
     *
     *
     * @return String
     * @see com.smartgwt.client.widgets.grid.ListGrid#getRecordBaseStyleProperty
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#effects_lf_grid_cells" target="examples">Grid cells Example</a>
     */
    public String getBaseStyle()  {
        return getAttributeAsString("baseStyle");
    }

    /**
     * Whether this field can be dragResized using the mouse.  If unset, the default behavior is governed by {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getCanResizeFields canResizeFields}.
     *
     * @param canDragResize canDragResize Default value is null
     */
    public void setCanDragResize(Boolean canDragResize) {
        setAttribute("canDragResize", canDragResize);
    }

    /**
     * Whether this field can be dragResized using the mouse.  If unset, the default behavior is governed by {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getCanResizeFields canResizeFields}.
     *
     *
     * @return Boolean
     */
    public Boolean getCanDragResize()  {
        return getAttributeAsBoolean("canDragResize");
    }

    /**
     * Can this field be edited? May be overridden by setting the      'canEdit' property at the listGrid level
     *
     * @param canEdit canEdit Default value is null
     * @see com.smartgwt.client.widgets.grid.ListGrid#setCanEdit
     * @see com.smartgwt.client.widgets.grid.ListGrid#setRecordEditProperty
     * @see com.smartgwt.client.widgets.grid.ListGrid#canEditCell
     * @see com.smartgwt.client.docs.Editing Editing overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#grid_editing_disable" target="examples">Disable editing Example</a>
     */
    public void setCanEdit(Boolean canEdit) {
        setAttribute("canEdit", canEdit);
    }

    /**
     * Can this field be edited? May be overridden by setting the      'canEdit' property at the listGrid level
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.widgets.grid.ListGrid#getCanEdit
     * @see com.smartgwt.client.widgets.grid.ListGrid#getRecordEditProperty
     * @see com.smartgwt.client.widgets.grid.ListGrid#canEditCell
     * @see com.smartgwt.client.docs.Editing Editing overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#grid_editing_disable" target="examples">Disable editing Example</a>
     */
    public Boolean getCanEdit()  {
        return getAttributeAsBoolean("canEdit");
    }

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
     * If showing a filter row for this ListGrid, should the filter criteria for this       field be editable
     *
     * @param canFilter canFilter Default value is null
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#grid_sortfilter_disable_filter" target="examples">Disable filter Example</a>
     */
    public void setCanFilter(Boolean canFilter) {
        setAttribute("canFilter", canFilter);
    }

    /**
     * If showing a filter row for this ListGrid, should the filter criteria for this       field be editable
     *
     *
     * @return Boolean
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#grid_sortfilter_disable_filter" target="examples">Disable filter Example</a>
     */
    public Boolean getCanFilter()  {
        return getAttributeAsBoolean("canFilter");
    }

    /**
     * Whether this field should display freezing/unfreezing options in its header context menu.  See {@link
     * com.smartgwt.client.docs.FrozenFields}.
     *
     * @param canFreeze canFreeze Default value is null
     * @see com.smartgwt.client.widgets.grid.ListGrid#getHeaderContextMenuItems
     * @see com.smartgwt.client.docs.FrozenFields FrozenFields overview and related methods
     */
    public void setCanFreeze(Boolean canFreeze) {
        setAttribute("canFreeze", canFreeze);
    }

    /**
     * Whether this field should display freezing/unfreezing options in its header context menu.  See {@link
     * com.smartgwt.client.docs.FrozenFields}.
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.widgets.grid.ListGrid#getHeaderContextMenuItems
     * @see com.smartgwt.client.docs.FrozenFields FrozenFields overview and related methods
     */
    public Boolean getCanFreeze()  {
        return getAttributeAsBoolean("canFreeze");
    }

    /**
     * Determines whether this field will be groupable in the header context menu.
     *
     * @param canGroupBy canGroupBy Default value is true
     * @see com.smartgwt.client.widgets.grid.ListGrid#groupBy
     */
    public void setCanGroupBy(Boolean canGroupBy) {
        setAttribute("canGroupBy", canGroupBy);
    }

    /**
     * Determines whether this field will be groupable in the header context menu.
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.widgets.grid.ListGrid#groupBy
     */
    public Boolean getCanGroupBy()  {
        return getAttributeAsBoolean("canGroupBy");
    }

    /**
     * Whether this field can be hidden via the header context menu.
     *
     * @param canHide canHide Default value is null
     * @see com.smartgwt.client.widgets.grid.ListGrid#getHeaderContextMenuItems
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setCanHide(Boolean canHide) {
        setAttribute("canHide", canHide);
    }

    /**
     * Whether this field can be hidden via the header context menu.
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.widgets.grid.ListGrid#getHeaderContextMenuItems
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Boolean getCanHide()  {
        return getAttributeAsBoolean("canHide");
    }

    /**
     * Whether this field can be reordered using the mouse.  If unset, the default behavior is governed by {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getCanReorderFields canReorderFields}.  Note that setting this property to 
     * <code>false</code> will lock this field from being moved - that is, the user is  prevented from moving this field
     * directly by dragging with the mouse, or by dropping another  field onto this field.  However, unless this field is at
     * the extreme edge of the grid,  or all fields between it and the extreme edge of the grid are also <code>canReorder:
     * false</code>, (ie, if there are unlocked fields on either side of this field), then it is possible that this locked
     * field may be  reordered automatically, as a result of the user dragging one unlocked field onto another  unlocked field.
     *
     * @param canReorder canReorder Default value is null
     */
    public void setCanReorder(Boolean canReorder) {
        setAttribute("canReorder", canReorder);
    }

    /**
     * Whether this field can be reordered using the mouse.  If unset, the default behavior is governed by {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getCanReorderFields canReorderFields}.  Note that setting this property to 
     * <code>false</code> will lock this field from being moved - that is, the user is  prevented from moving this field
     * directly by dragging with the mouse, or by dropping another  field onto this field.  However, unless this field is at
     * the extreme edge of the grid,  or all fields between it and the extreme edge of the grid are also <code>canReorder:
     * false</code>, (ie, if there are unlocked fields on either side of this field), then it is possible that this locked
     * field may be  reordered automatically, as a result of the user dragging one unlocked field onto another  unlocked field.
     *
     *
     * @return Boolean
     */
    public Boolean getCanReorder()  {
        return getAttributeAsBoolean("canReorder");
    }

    /**
     * Enables or disables sorting by this column. If false, neither interactive  nor scripted (via the sort() method)
     * instructions will sort the listGrid by this  column.
     *
     * @param canSort canSort Default value is true
     * @see com.smartgwt.client.widgets.grid.ListGrid#sort
     * @see com.smartgwt.client.widgets.grid.ListGrid#setCanSort
     */
    public void setCanSort(Boolean canSort) {
        setAttribute("canSort", canSort);
    }

    /**
     * Enables or disables sorting by this column. If false, neither interactive  nor scripted (via the sort() method)
     * instructions will sort the listGrid by this  column.
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.widgets.grid.ListGrid#sort
     * @see com.smartgwt.client.widgets.grid.ListGrid#getCanSort
     */
    public Boolean getCanSort()  {
        return getAttributeAsBoolean("canSort");
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
     */
    public Boolean getCanSortClientOnly()  {
        return getAttributeAsBoolean("canSortClientOnly");
    }

    /**
     * Allows a boolean or  valueMapped field to be edited without going into edit mode. When this attribute is set, clicking
     * on the field will change the value - for boolean fields toggling between <code>true</code> and <code>false</code>, and
     * for valueMapped fields, advancing the value to the next option in the valueMap. <P> To enable this feature, {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getCanEdit canEdit} must be set to true. For boolean type fields
     * <code>canToggle</code> is true by default, meaning setting <code>canEdit</code> to true implies the user can toggle the
     * value via a single click without going into edit mode. You can disable this by explicitly setting <code>canToggle</code>
     * to false for a boolean field.<br> Note that you can enable toggling only (without allowing the user to edit other
     * fields) by just setting {@link com.smartgwt.client.widgets.grid.ListGrid#getEditEvent grid.editEvent:"none"}. <P> If
     * {@link com.smartgwt.client.widgets.grid.ListGrid#getEditEvent editEvent} is set to "click", when the user clicks on the
     * field,  the value will be toggled, and inline editing will be triggered as usual. Otherwise the toggled value will be
     * saved immediately to the server, or if  {@link com.smartgwt.client.widgets.grid.ListGrid#getAutoSaveEdits autoSaveEdits}
     * has been set to false, will be stored as an edit value for the record.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param canToggle canToggle Default value is varies
     * @see com.smartgwt.client.docs.Editing Editing overview and related methods
     */
    public void setCanToggle(Boolean canToggle) {
        setAttribute("canToggle", canToggle);
    }

    /**
     * Allows a boolean or  valueMapped field to be edited without going into edit mode. When this attribute is set, clicking
     * on the field will change the value - for boolean fields toggling between <code>true</code> and <code>false</code>, and
     * for valueMapped fields, advancing the value to the next option in the valueMap. <P> To enable this feature, {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getCanEdit canEdit} must be set to true. For boolean type fields
     * <code>canToggle</code> is true by default, meaning setting <code>canEdit</code> to true implies the user can toggle the
     * value via a single click without going into edit mode. You can disable this by explicitly setting <code>canToggle</code>
     * to false for a boolean field.<br> Note that you can enable toggling only (without allowing the user to edit other
     * fields) by just setting {@link com.smartgwt.client.widgets.grid.ListGrid#getEditEvent grid.editEvent:"none"}. <P> If
     * {@link com.smartgwt.client.widgets.grid.ListGrid#getEditEvent editEvent} is set to "click", when the user clicks on the
     * field,  the value will be toggled, and inline editing will be triggered as usual. Otherwise the toggled value will be
     * saved immediately to the server, or if  {@link com.smartgwt.client.widgets.grid.ListGrid#getAutoSaveEdits autoSaveEdits}
     * has been set to false, will be stored as an edit value for the record.
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.docs.Editing Editing overview and related methods
     */
    public Boolean getCanToggle()  {
        return getAttributeAsBoolean("canToggle");
    }

    /**
     * Horizontal alignment for cells in this field's column: "left", "right" or "center".<br> If null, alignment is derived
     * from {@link com.smartgwt.client.widgets.grid.ListGridField#getAlign align}. If this field is editable,  the alignment of
     * cells in the body will also be reflected in any editors for the field.
     *
     * @param cellAlign cellAlign Default value is null
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setCellAlign(Alignment cellAlign) {
        setAttribute("cellAlign", cellAlign.getValue());
    }

    /**
     * Horizontal alignment for cells in this field's column: "left", "right" or "center".<br> If null, alignment is derived
     * from {@link com.smartgwt.client.widgets.grid.ListGridField#getAlign align}. If this field is editable,  the alignment of
     * cells in the body will also be reflected in any editors for the field.
     *
     *
     * @return Alignment
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Alignment getCellAlign()  {
        return EnumUtil.getEnum(Alignment.values(), getAttribute("cellAlign"));
    }

    /**
     * For a field of type:"icon" only, set the icon that appears in body cells.  Unless setting {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getIcon field.icon}, setting field.cellIcon will not show an icon in the
     * header.
     *
     * @param cellIcon cellIcon Default value is null
     */
    public void setCellIcon(String cellIcon) {
        setAttribute("cellIcon", cellIcon);
    }

    /**
     * For a field of type:"icon" only, set the icon that appears in body cells.  Unless setting {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getIcon field.icon}, setting field.cellIcon will not show an icon in the
     * header.
     *
     *
     * @return String
     */
    public String getCellIcon()  {
        return getAttributeAsString("cellIcon");
    }

    /**
     * Default groupingMode used when the user does not specify a mode or grouping is triggered programmatically and {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getGroupingMode field.groupingMode} is unset. See {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getGroupingModes field.groupingModes}.
     *
     * @param defaultGroupingMode defaultGroupingMode Default value is null
     */
    public void setDefaultGroupingMode(String defaultGroupingMode) {
        setAttribute("defaultGroupingMode", defaultGroupingMode);
    }

    /**
     * Default groupingMode used when the user does not specify a mode or grouping is triggered programmatically and {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getGroupingMode field.groupingMode} is unset. See {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getGroupingModes field.groupingModes}.
     *
     *
     * @return String
     */
    public String getDefaultGroupingMode()  {
        return getAttributeAsString("defaultGroupingMode");
    }

    /**
     * If this field is editable, this property will be passed to editors displayed for cells within this field as {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getDefaultIconSrc defaultIconSrc}.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param defaultIconSrc defaultIconSrc Default value is null
     * @see com.smartgwt.client.widgets.grid.ListGridField#setIcons
     * @see com.smartgwt.client.docs.Editing Editing overview and related methods
     */
    public void setDefaultIconSrc(String defaultIconSrc) {
        setAttribute("defaultIconSrc", defaultIconSrc);
    }

    /**
     * If this field is editable, this property will be passed to editors displayed for cells within this field as {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getDefaultIconSrc defaultIconSrc}.
     *
     *
     * @return String
     * @see com.smartgwt.client.widgets.grid.ListGridField#getIcons
     * @see com.smartgwt.client.docs.Editing Editing overview and related methods
     */
    public String getDefaultIconSrc()  {
        return getAttributeAsString("defaultIconSrc");
    }

    /**
     * Specifies the {@link com.smartgwt.client.widgets.grid.ListGridField#getOptionDataSource optionDataSource} field used to
     * retrieve the display values that are to be mapped from the internal values specified by {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getValueField valueField}. <P> If no <code>optionDataSource</code> is
     * defined for the field, the cell will display the displayField value for the current record instead of the underlying
     * value for this field.  This approach can be used for situations where field values need a stored value to displayed
     * value mapping, but the set of all possible values is too large to load as a ValueMap - see {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getOptionDataSource optionDataSource} for more details on this approach. 
     * Note that if this field is editable this will also be applied to this field's editors.  <a
     * href="http://www.smartclient.com/smartgwtee/showcase/#large_valuemap_sql" target="examples">This sample</a> illustrates
     * this approach achieved via a server-side SQL join. <p> The display value for a record with a specified
     * <code>displayField</code> can be  picked up via {@link com.smartgwt.client.widgets.grid.ListGrid#getDisplayValue
     * ListGrid.getDisplayValue}.
     *
     * @param displayField displayField Default value is null
     */
    public void setDisplayField(String displayField) {
        setAttribute("displayField", displayField);
    }

    /**
     * Specifies the {@link com.smartgwt.client.widgets.grid.ListGridField#getOptionDataSource optionDataSource} field used to
     * retrieve the display values that are to be mapped from the internal values specified by {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getValueField valueField}. <P> If no <code>optionDataSource</code> is
     * defined for the field, the cell will display the displayField value for the current record instead of the underlying
     * value for this field.  This approach can be used for situations where field values need a stored value to displayed
     * value mapping, but the set of all possible values is too large to load as a ValueMap - see {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getOptionDataSource optionDataSource} for more details on this approach. 
     * Note that if this field is editable this will also be applied to this field's editors.  <a
     * href="http://www.smartclient.com/smartgwtee/showcase/#large_valuemap_sql" target="examples">This sample</a> illustrates
     * this approach achieved via a server-side SQL join. <p> The display value for a record with a specified
     * <code>displayField</code> can be  picked up via {@link com.smartgwt.client.widgets.grid.ListGrid#getDisplayValue
     * ListGrid.getDisplayValue}.
     *
     *
     * @return String
     */
    public String getDisplayField()  {
        return getAttributeAsString("displayField");
    }

    /**
     * If this field is editable, this property will be passed to editors displayed for cells within this field as {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getIconHeight iconHeight}.<br> If this property unset, the iconHeight
     * property from the editor can be picked up from  {@link com.smartgwt.client.widgets.grid.ListGridField#getIconHeight
     * iconHeight} instead.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param editorIconHeight editorIconHeight Default value is null
     * @see com.smartgwt.client.widgets.grid.ListGridField#setIcons
     * @see com.smartgwt.client.docs.Editing Editing overview and related methods
     */
    public void setEditorIconHeight(Integer editorIconHeight) {
        setAttribute("editorIconHeight", editorIconHeight);
    }

    /**
     * If this field is editable, this property will be passed to editors displayed for cells within this field as {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getIconHeight iconHeight}.<br> If this property unset, the iconHeight
     * property from the editor can be picked up from  {@link com.smartgwt.client.widgets.grid.ListGridField#getIconHeight
     * iconHeight} instead.
     *
     *
     * @return Integer
     * @see com.smartgwt.client.widgets.grid.ListGridField#getIcons
     * @see com.smartgwt.client.docs.Editing Editing overview and related methods
     */
    public Integer getEditorIconHeight()  {
        return getAttributeAsInt("editorIconHeight");
    }

    /**
     * If this field is editable, this property will be passed to editors displayed for cells within this field as {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getIconWidth iconWidth}.<br> If this property unset, the iconWidth
     * property from the editor can be picked up from  {@link com.smartgwt.client.widgets.grid.ListGridField#getIconWidth
     * iconWidth} instead.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param editorIconWidth editorIconWidth Default value is null
     * @see com.smartgwt.client.widgets.grid.ListGridField#setIcons
     * @see com.smartgwt.client.docs.Editing Editing overview and related methods
     */
    public void setEditorIconWidth(Integer editorIconWidth) {
        setAttribute("editorIconWidth", editorIconWidth);
    }

    /**
     * If this field is editable, this property will be passed to editors displayed for cells within this field as {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getIconWidth iconWidth}.<br> If this property unset, the iconWidth
     * property from the editor can be picked up from  {@link com.smartgwt.client.widgets.grid.ListGridField#getIconWidth
     * iconWidth} instead.
     *
     *
     * @return Integer
     * @see com.smartgwt.client.widgets.grid.ListGridField#getIcons
     * @see com.smartgwt.client.docs.Editing Editing overview and related methods
     */
    public Integer getEditorIconWidth()  {
        return getAttributeAsInt("editorIconWidth");
    }

    /**
     * When some cell in this field is being edited, this property can be used to apply  an explicit {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getImageURLPrefix imageURLPrefix} to the editor in question.  This can
     * be used to modify the valueIcons within the editor.<br> If unset, but {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getImageURLPrefix imageURLPrefix} is specified, that will be used
     * instead.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param editorImageURLPrefix editorImageURLPrefix Default value is null
     * @see com.smartgwt.client.docs.Editing Editing overview and related methods
     */
    public void setEditorImageURLPrefix(String editorImageURLPrefix) {
        setAttribute("editorImageURLPrefix", editorImageURLPrefix);
    }

    /**
     * When some cell in this field is being edited, this property can be used to apply  an explicit {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getImageURLPrefix imageURLPrefix} to the editor in question.  This can
     * be used to modify the valueIcons within the editor.<br> If unset, but {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getImageURLPrefix imageURLPrefix} is specified, that will be used
     * instead.
     *
     *
     * @return String
     * @see com.smartgwt.client.docs.Editing Editing overview and related methods
     */
    public String getEditorImageURLPrefix()  {
        return getAttributeAsString("editorImageURLPrefix");
    }

    /**
     * When some cell in this field is being edited, this property can be used to apply  an explicit {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getImageURLSuffix imageURLSuffix} to the editor in question.  This can
     * be used to modify the valueIcons within the editor.<br> If unset, but {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getImageURLPrefix imageURLPrefix} is specified, that will be used
     * instead.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param editorImageURLSuffix editorImageURLSuffix Default value is null
     * @see com.smartgwt.client.docs.Editing Editing overview and related methods
     */
    public void setEditorImageURLSuffix(String editorImageURLSuffix) {
        setAttribute("editorImageURLSuffix", editorImageURLSuffix);
    }

    /**
     * When some cell in this field is being edited, this property can be used to apply  an explicit {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getImageURLSuffix imageURLSuffix} to the editor in question.  This can
     * be used to modify the valueIcons within the editor.<br> If unset, but {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getImageURLPrefix imageURLPrefix} is specified, that will be used
     * instead.
     *
     *
     * @return String
     * @see com.smartgwt.client.docs.Editing Editing overview and related methods
     */
    public String getEditorImageURLSuffix()  {
        return getAttributeAsString("editorImageURLSuffix");
    }

    /**
     * When some cell in this field is being edited, setting this property will specify the height for value icons in the
     * cell's editor. If unset, the editor's valueIcon width and height will be determined in the same way as it would be for a
     * static cell.
     *
     * @param editorValueIconHeight editorValueIconHeight Default value is null
     * @see com.smartgwt.client.docs.ImageColumns ImageColumns overview and related methods
     */
    public void setEditorValueIconHeight(Integer editorValueIconHeight) {
        setAttribute("editorValueIconHeight", editorValueIconHeight);
    }

    /**
     * When some cell in this field is being edited, setting this property will specify the height for value icons in the
     * cell's editor. If unset, the editor's valueIcon width and height will be determined in the same way as it would be for a
     * static cell.
     *
     *
     * @return Integer
     * @see com.smartgwt.client.docs.ImageColumns ImageColumns overview and related methods
     */
    public Integer getEditorValueIconHeight()  {
        return getAttributeAsInt("editorValueIconHeight");
    }

    /**
     * When some cell in this field is being edited, setting this property will specify the width for value icons in the cell's
     * editor. If unset, the editor's valueIcon width and height will be determined in the same way as it would be for a static
     * cell.
     *
     * @param editorValueIconWidth editorValueIconWidth Default value is null
     * @see com.smartgwt.client.docs.ImageColumns ImageColumns overview and related methods
     */
    public void setEditorValueIconWidth(Integer editorValueIconWidth) {
        setAttribute("editorValueIconWidth", editorValueIconWidth);
    }

    /**
     * When some cell in this field is being edited, setting this property will specify the width for value icons in the cell's
     * editor. If unset, the editor's valueIcon width and height will be determined in the same way as it would be for a static
     * cell.
     *
     *
     * @return Integer
     * @see com.smartgwt.client.docs.ImageColumns ImageColumns overview and related methods
     */
    public Integer getEditorValueIconWidth()  {
        return getAttributeAsInt("editorValueIconWidth");
    }

    /**
     * The value to display for a cell whose value is null or the empty string after applying formatCellValue and valueMap (if
     * any). <p> This is the field-specific attribute.  You may also set the emptyCellValue at the grid level to define the
     * emptyCellValue for all empty fields in the grid.
     *
     * @param emptyCellValue emptyCellValue Default value is "&amp;nbsp;"
     * @see com.smartgwt.client.widgets.grid.ListGrid#setEmptyCellValue
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#grid_appearance_empty_values" target="examples">Empty values Example</a>
     */
    public void setEmptyCellValue(String emptyCellValue) {
        setAttribute("emptyCellValue", emptyCellValue);
    }

    /**
     * The value to display for a cell whose value is null or the empty string after applying formatCellValue and valueMap (if
     * any). <p> This is the field-specific attribute.  You may also set the emptyCellValue at the grid level to define the
     * emptyCellValue for all empty fields in the grid.
     *
     *
     * @return String
     * @see com.smartgwt.client.widgets.grid.ListGrid#getEmptyCellValue
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#grid_appearance_empty_values" target="examples">Empty values Example</a>
     */
    public String getEmptyCellValue()  {
        return getAttributeAsString("emptyCellValue");
    }

    /**
     * What to do when a user hits enter while editing this field?<br> Overrides the <code>enterKeyEditAction</code> as
     * specified at the listGrid level while  focus is in this field.
     *
     * @param enterKeyEditAction enterKeyEditAction Default value is "done"
     * @see com.smartgwt.client.docs.Editing Editing overview and related methods
     */
    public void setEnterKeyEditAction(EnterKeyEditAction enterKeyEditAction) {
        setAttribute("enterKeyEditAction", enterKeyEditAction.getValue());
    }

    /**
     * What to do when a user hits enter while editing this field?<br> Overrides the <code>enterKeyEditAction</code> as
     * specified at the listGrid level while  focus is in this field.
     *
     *
     * @return EnterKeyEditAction
     * @see com.smartgwt.client.docs.Editing Editing overview and related methods
     */
    public EnterKeyEditAction getEnterKeyEditAction()  {
        return EnumUtil.getEnum(EnterKeyEditAction.values(), getAttribute("enterKeyEditAction"));
    }

    /**
     * What to do when a user hits escape while editing this field?<br> Overrides the <code>escapeKeyEditAction</code> as
     * specified at the listGrid level while  focus is in this field.
     *
     * @param escapeKeyEditAction escapeKeyEditAction Default value is "cancel"
     * @see com.smartgwt.client.docs.Editing Editing overview and related methods
     */
    public void setEscapeKeyEditAction(EscapeKeyEditAction escapeKeyEditAction) {
        setAttribute("escapeKeyEditAction", escapeKeyEditAction.getValue());
    }

    /**
     * What to do when a user hits escape while editing this field?<br> Overrides the <code>escapeKeyEditAction</code> as
     * specified at the listGrid level while  focus is in this field.
     *
     *
     * @return EscapeKeyEditAction
     * @see com.smartgwt.client.docs.Editing Editing overview and related methods
     */
    public EscapeKeyEditAction getEscapeKeyEditAction()  {
        return EnumUtil.getEnum(EscapeKeyEditAction.values(), getAttribute("escapeKeyEditAction"));
    }

    /**
     * Dictates whether the data in this field should be exported raw by  {@link
     * com.smartgwt.client.widgets.DataBoundComponent#exportClientData exportClientData()}.  If set to true for a  field, the
     * values in the field-formatters will not be executed for data in this field. Decreases the time taken for large exports.
     *
     * @param exportRawValues exportRawValues Default value is null
     */
    public void setExportRawValues(Boolean exportRawValues) {
        setAttribute("exportRawValues", exportRawValues);
    }

    /**
     * Dictates whether the data in this field should be exported raw by  {@link
     * com.smartgwt.client.widgets.DataBoundComponent#exportClientData exportClientData()}.  If set to true for a  field, the
     * values in the field-formatters will not be executed for data in this field. Decreases the time taken for large exports.
     *
     *
     * @return Boolean
     */
    public Boolean getExportRawValues()  {
        return getAttributeAsBoolean("exportRawValues");
    }

    /**
     * If we're showing the filterEditor (listGrid.showFilterEditor is true), this property  determines whether this list
     * should be filtered every time the user edits the value of the filter editor for this field.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param filterOnKeypress filterOnKeypress Default value is null
     */
    public void setFilterOnKeypress(Boolean filterOnKeypress) {
        setAttribute("filterOnKeypress", filterOnKeypress);
    }

    /**
     * If we're showing the filterEditor (listGrid.showFilterEditor is true), this property  determines whether this list
     * should be filtered every time the user edits the value of the filter editor for this field.
     *
     *
     * @return Boolean
     */
    public Boolean getFilterOnKeypress()  {
        return getAttributeAsBoolean("filterOnKeypress");
    }

    /**
     * With the {@link com.smartgwt.client.widgets.grid.ListGrid#getShowFilterEditor FilterEditor} showing, the Operator to 
     * use when matching values for this field. <P> Note that you can set all FilterEditor fields to default to either
     * substring or exact  match via {@link com.smartgwt.client.widgets.grid.ListGrid#getAutoFetchAsFilter autoFetchAsFilter},
     * but if you want a mix of exact vs substring  match on different fields, you need to use this property, and your ListGrid
     * will produce {@link com.smartgwt.client.data.AdvancedCriteria} rather than the simpler {@link
     * com.smartgwt.client.data.Criteria} format.  This is automatically and transparently handled by the Smart GWT Server's
     * SQLDataSource and HibernateDataSource in Power Edition or above, but if you have your own filtering implementation, it
     * will need to be able to handle AdvancedCriteria.
     *
     * @param filterOperator filterOperator Default value is null
     */
    public void setFilterOperator(OperatorId filterOperator) {
        setAttribute("filterOperator", filterOperator.getValue());
    }

    /**
     * With the {@link com.smartgwt.client.widgets.grid.ListGrid#getShowFilterEditor FilterEditor} showing, the Operator to 
     * use when matching values for this field. <P> Note that you can set all FilterEditor fields to default to either
     * substring or exact  match via {@link com.smartgwt.client.widgets.grid.ListGrid#getAutoFetchAsFilter autoFetchAsFilter},
     * but if you want a mix of exact vs substring  match on different fields, you need to use this property, and your ListGrid
     * will produce {@link com.smartgwt.client.data.AdvancedCriteria} rather than the simpler {@link
     * com.smartgwt.client.data.Criteria} format.  This is automatically and transparently handled by the Smart GWT Server's
     * SQLDataSource and HibernateDataSource in Power Edition or above, but if you have your own filtering implementation, it
     * will need to be able to handle AdvancedCriteria.
     *
     *
     * @return OperatorId
     */
    public OperatorId getFilterOperator()  {
        return EnumUtil.getEnum(OperatorId.values(), getAttribute("filterOperator"));
    }

    /**
     * Whether this field should be "frozen" for the purposes of horizontal scrolling.  See {@link
     * com.smartgwt.client.docs.FrozenFields}.
     *
     * @param frozen frozen Default value is null
     * @see com.smartgwt.client.docs.FrozenFields FrozenFields overview and related methods
     */
    public void setFrozen(Boolean frozen) {
        setAttribute("frozen", frozen);
    }

    /**
     * Whether this field should be "frozen" for the purposes of horizontal scrolling.  See {@link
     * com.smartgwt.client.docs.FrozenFields}.
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.docs.FrozenFields FrozenFields overview and related methods
     */
    public Boolean getFrozen()  {
        return getAttributeAsBoolean("frozen");
    }

    /**
     * Granularity of grouping for numeric fields. <P> Groups will be formed based on ranges of values of size
     * <code>groupGranularity</code>.  For example, if groupGranularity were 1000, groups would be 0-1000, 1000-2000, etc.
     *
     * @param groupGranularity groupGranularity Default value is null
     */
    public void setGroupGranularity(Integer groupGranularity) {
        setAttribute("groupGranularity", groupGranularity);
    }

    /**
     * Granularity of grouping for numeric fields. <P> Groups will be formed based on ranges of values of size
     * <code>groupGranularity</code>.  For example, if groupGranularity were 1000, groups would be 0-1000, 1000-2000, etc.
     *
     *
     * @return Integer
     */
    public Integer getGroupGranularity()  {
        return getAttributeAsInt("groupGranularity");
    }

    /**
     * For a field that allows multiple {@link com.smartgwt.client.widgets.grid.ListGridField#getGroupingModes grouping modes},
     * the current grouping mode. <P> This property is set when a user chooses a particular grouping mode, and may be set on
     * ListGrid creation to affect the initial grouping.
     *
     * @param groupingMode groupingMode Default value is null
     */
    public void setGroupingMode(String groupingMode) {
        setAttribute("groupingMode", groupingMode);
    }

    /**
     * For a field that allows multiple {@link com.smartgwt.client.widgets.grid.ListGridField#getGroupingModes grouping modes},
     * the current grouping mode. <P> This property is set when a user chooses a particular grouping mode, and may be set on
     * ListGrid creation to affect the initial grouping.
     *
     *
     * @return String
     */
    public String getGroupingMode()  {
        return getAttributeAsString("groupingMode");
    }

    /**
     * For fields of type:"float" or derived from float, number of digits after the decimal point to consider when grouping.
     * <P> For example, <code>groupPrecision:2</code> indicates that 45.238 and 45.231 group together, but 45.22 and 45.27 are
     * separate. <P> See also {@link com.smartgwt.client.widgets.grid.ListGridField#getGroupGranularity groupGranularity} for
     * grouping by broader ranges.
     *
     * @param groupPrecision groupPrecision Default value is null
     */
    public void setGroupPrecision(Integer groupPrecision) {
        setAttribute("groupPrecision", groupPrecision);
    }

    /**
     * For fields of type:"float" or derived from float, number of digits after the decimal point to consider when grouping.
     * <P> For example, <code>groupPrecision:2</code> indicates that 45.238 and 45.231 group together, but 45.22 and 45.27 are
     * separate. <P> See also {@link com.smartgwt.client.widgets.grid.ListGridField#getGroupGranularity groupGranularity} for
     * grouping by broader ranges.
     *
     *
     * @return Integer
     */
    public Integer getGroupPrecision()  {
        return getAttributeAsInt("groupPrecision");
    }

    /**
     * Custom base style to apply to this field's header button instead of  {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getHeaderBaseStyle headerBaseStyle}.<br> Note that depending on the header
     * button constructor, you may have to override {@link com.smartgwt.client.widgets.grid.ListGridField#getHeaderTitleStyle
     * headerTitleStyle} as well.
     *
     * @param headerBaseStyle headerBaseStyle Default value is null
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setHeaderBaseStyle(String headerBaseStyle) {
        setAttribute("headerBaseStyle", headerBaseStyle);
    }

    /**
     * Custom base style to apply to this field's header button instead of  {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getHeaderBaseStyle headerBaseStyle}.<br> Note that depending on the header
     * button constructor, you may have to override {@link com.smartgwt.client.widgets.grid.ListGridField#getHeaderTitleStyle
     * headerTitleStyle} as well.
     *
     *
     * @return String
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getHeaderBaseStyle()  {
        return getAttributeAsString("headerBaseStyle");
    }

    /**
     * Custom titleStyle to apply to this field's header button instead of  {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getHeaderTitleStyle headerTitleStyle}.<br> Note that this will typically only
     * have an effect if  {@link com.smartgwt.client.widgets.grid.ListGrid#getHeaderButtonConstructor headerButtonConstructor}
     * is set to {@link com.smartgwt.client.widgets.StretchImgButton} or a subclass  thereof.
     *
     * @param headerTitleStyle headerTitleStyle Default value is null
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setHeaderTitleStyle(String headerTitleStyle) {
        setAttribute("headerTitleStyle", headerTitleStyle);
    }

    /**
     * Custom titleStyle to apply to this field's header button instead of  {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getHeaderTitleStyle headerTitleStyle}.<br> Note that this will typically only
     * have an effect if  {@link com.smartgwt.client.widgets.grid.ListGrid#getHeaderButtonConstructor headerButtonConstructor}
     * is set to {@link com.smartgwt.client.widgets.StretchImgButton} or a subclass  thereof.
     *
     *
     * @return String
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getHeaderTitleStyle()  {
        return getAttributeAsString("headerTitleStyle");
    }

    /**
     * Optional icon to show next to the title for this field.  Should be set to a URL to an image. Relative paths will be
     * evaluated starting at the imgDir of this component. This URL is partial - it may be updated to indicate the current
     * disabled (etc) state of the field. <P> If {@link com.smartgwt.client.widgets.grid.ListGridField#getType field.type} is
     * set to "icon", this icon will also be shown in every cell of this field - see also {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getCellIcon field.cellIcon}.
     *
     * @param icon icon Default value is null
     */
    public void setIcon(String icon) {
        setAttribute("icon", icon);
    }

    /**
     * Optional icon to show next to the title for this field.  Should be set to a URL to an image. Relative paths will be
     * evaluated starting at the imgDir of this component. This URL is partial - it may be updated to indicate the current
     * disabled (etc) state of the field. <P> If {@link com.smartgwt.client.widgets.grid.ListGridField#getType field.type} is
     * set to "icon", this icon will also be shown in every cell of this field - see also {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getCellIcon field.cellIcon}.
     *
     *
     * @return String
     */
    public String getIcon()  {
        return getAttributeAsString("icon");
    }

    /**
     * If {@link com.smartgwt.client.widgets.grid.ListGridField#getIcon icon} is specified, this property can be used to
     * specify the  height of the icon to be displayed in the ListGrid header button.  (See {@link
     * com.smartgwt.client.widgets.StatefulCanvas#getIconHeight iconHeight})<br> If this field is editable, and {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getEditorIconHeight editorIconHeight} is unset, this  property will be
     * passed onto the editors for this field as {@link com.smartgwt.client.widgets.form.fields.FormItem#getIconWidth
     * iconWidth},  which will effect the default size for {@link com.smartgwt.client.widgets.grid.ListGridField#getIcons
     * icons} displayed  in the editor.
     *
     * @param iconHeight iconHeight Default value is null
     * @see com.smartgwt.client.widgets.grid.ListGridField#setIcon
     * @see com.smartgwt.client.widgets.grid.ListGridField#setIcons
     */
    public void setIconHeight(Integer iconHeight) {
        setAttribute("iconHeight", iconHeight);
    }

    /**
     * If {@link com.smartgwt.client.widgets.grid.ListGridField#getIcon icon} is specified, this property can be used to
     * specify the  height of the icon to be displayed in the ListGrid header button.  (See {@link
     * com.smartgwt.client.widgets.StatefulCanvas#getIconHeight iconHeight})<br> If this field is editable, and {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getEditorIconHeight editorIconHeight} is unset, this  property will be
     * passed onto the editors for this field as {@link com.smartgwt.client.widgets.form.fields.FormItem#getIconWidth
     * iconWidth},  which will effect the default size for {@link com.smartgwt.client.widgets.grid.ListGridField#getIcons
     * icons} displayed  in the editor.
     *
     *
     * @return Integer
     * @see com.smartgwt.client.widgets.grid.ListGridField#getIcon
     * @see com.smartgwt.client.widgets.grid.ListGridField#getIcons
     */
    public Integer getIconHeight()  {
        return getAttributeAsInt("iconHeight");
    }

    /**
     * If this field is showing an icon, should it appear to the left or right of the title?<br> Valid options are
     * <code>"left"</code> or <code>"right"</code>
     *
     * @param iconOrientation iconOrientation Default value is "left"
     * @see com.smartgwt.client.widgets.grid.ListGridField#setIcon
     */
    public void setIconOrientation(String iconOrientation) {
        setAttribute("iconOrientation", iconOrientation);
    }

    /**
     * If this field is showing an icon, should it appear to the left or right of the title?<br> Valid options are
     * <code>"left"</code> or <code>"right"</code>
     *
     *
     * @return String
     * @see com.smartgwt.client.widgets.grid.ListGridField#getIcon
     */
    public String getIconOrientation()  {
        return getAttributeAsString("iconOrientation");
    }

    /**
     * If {@link com.smartgwt.client.widgets.grid.ListGridField#getIcon icon} is specified, this property can be used to
     * specify the  size of the icon to be displayed in the ListGrid header button.  (See {@link
     * com.smartgwt.client.widgets.StatefulCanvas#getIconSize iconSize})
     *
     * @param iconSize iconSize Default value is null
     * @see com.smartgwt.client.widgets.grid.ListGridField#setIcon
     */
    public void setIconSize(Integer iconSize) {
        setAttribute("iconSize", iconSize);
    }

    /**
     * If {@link com.smartgwt.client.widgets.grid.ListGridField#getIcon icon} is specified, this property can be used to
     * specify the  size of the icon to be displayed in the ListGrid header button.  (See {@link
     * com.smartgwt.client.widgets.StatefulCanvas#getIconSize iconSize})
     *
     *
     * @return Integer
     * @see com.smartgwt.client.widgets.grid.ListGridField#getIcon
     */
    public Integer getIconSize()  {
        return getAttributeAsInt("iconSize");
    }

    /**
     * Pixels between icon and title text.
     *
     * @param iconSpacing iconSpacing Default value is 6
     * @see com.smartgwt.client.widgets.grid.ListGridField#setIcon
     * @see com.smartgwt.client.docs.ButtonIcon ButtonIcon overview and related methods
     */
    public void setIconSpacing(int iconSpacing) {
        setAttribute("iconSpacing", iconSpacing);
    }

    /**
     * Pixels between icon and title text.
     *
     *
     * @return int
     * @see com.smartgwt.client.widgets.grid.ListGridField#getIcon
     * @see com.smartgwt.client.docs.ButtonIcon ButtonIcon overview and related methods
     */
    public int getIconSpacing()  {
        return getAttributeAsInt("iconSpacing");
    }

    /**
     * If this field is editable, this property will be passed to editors displayed for cells within this field as {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getIconVAlign iconVAlign}.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param iconVAlign iconVAlign Default value is null
     * @see com.smartgwt.client.widgets.grid.ListGridField#setIcons
     * @see com.smartgwt.client.docs.Editing Editing overview and related methods
     */
    public void setIconVAlign(String iconVAlign) {
        setAttribute("iconVAlign", iconVAlign);
    }

    /**
     * If this field is editable, this property will be passed to editors displayed for cells within this field as {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getIconVAlign iconVAlign}.
     *
     *
     * @return String
     * @see com.smartgwt.client.widgets.grid.ListGridField#getIcons
     * @see com.smartgwt.client.docs.Editing Editing overview and related methods
     */
    public String getIconVAlign()  {
        return getAttributeAsString("iconVAlign");
    }

    /**
     * If {@link com.smartgwt.client.widgets.grid.ListGridField#getIcon icon} is specified, this property can be used to
     * specify the  width of the icon to be displayed in the ListGrid header button.  (See {@link
     * com.smartgwt.client.widgets.StatefulCanvas#getIconWidth iconWidth})<br> If this field is editable, and {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getEditorIconWidth editorIconWidth} is unset, this  property will be
     * passed onto the editors for this field as {@link com.smartgwt.client.widgets.form.fields.FormItem#getIconWidth
     * iconWidth},  which will effect the default size for {@link com.smartgwt.client.widgets.grid.ListGridField#getIcons
     * icons} displayed  in the editor.
     *
     * @param iconWidth iconWidth Default value is null
     * @see com.smartgwt.client.widgets.grid.ListGridField#setIcon
     * @see com.smartgwt.client.widgets.grid.ListGridField#setIcons
     */
    public void setIconWidth(Integer iconWidth) {
        setAttribute("iconWidth", iconWidth);
    }

    /**
     * If {@link com.smartgwt.client.widgets.grid.ListGridField#getIcon icon} is specified, this property can be used to
     * specify the  width of the icon to be displayed in the ListGrid header button.  (See {@link
     * com.smartgwt.client.widgets.StatefulCanvas#getIconWidth iconWidth})<br> If this field is editable, and {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getEditorIconWidth editorIconWidth} is unset, this  property will be
     * passed onto the editors for this field as {@link com.smartgwt.client.widgets.form.fields.FormItem#getIconWidth
     * iconWidth},  which will effect the default size for {@link com.smartgwt.client.widgets.grid.ListGridField#getIcons
     * icons} displayed  in the editor.
     *
     *
     * @return Integer
     * @see com.smartgwt.client.widgets.grid.ListGridField#getIcon
     * @see com.smartgwt.client.widgets.grid.ListGridField#getIcons
     */
    public Integer getIconWidth()  {
        return getAttributeAsInt("iconWidth");
    }

    /**
     * Height of image shown for fieldTypes image and imageFile in this field. <P> If set to a String, assumed to be a property
     * on each record that specifies the image height.  For example, if <code>field.imageHeight</code> is "logoHeight",
     * <code>record.logoHeight</code> will control the height of the image.
     *
     * @param imageHeight imageHeight Default value is 16
     * @see com.smartgwt.client.widgets.grid.ListGrid#setImageSize
     * @see com.smartgwt.client.widgets.grid.ListGridField#setImageSize
     * @see com.smartgwt.client.widgets.grid.ListGridField#setImageWidth
     * @see com.smartgwt.client.docs.ImageColumns ImageColumns overview and related methods
     */
    public void setImageHeight(int imageHeight) {
        setAttribute("imageHeight", imageHeight);
    }

    /**
     * Height of image shown for fieldTypes image and imageFile in this field. <P> If set to a String, assumed to be a property
     * on each record that specifies the image height.  For example, if <code>field.imageHeight</code> is "logoHeight",
     * <code>record.logoHeight</code> will control the height of the image.
     *
     *
     * @return int
     * @see com.smartgwt.client.widgets.grid.ListGrid#getImageSize
     * @see com.smartgwt.client.widgets.grid.ListGridField#getImageSize
     * @see com.smartgwt.client.widgets.grid.ListGridField#getImageWidth
     * @see com.smartgwt.client.docs.ImageColumns ImageColumns overview and related methods
     */
    public int getImageHeight()  {
        return getAttributeAsInt("imageHeight");
    }

    /**
     * Size of images shown for fieldTypes image and imageFile in this field. This setting overrides the global ListGrid
     * default {@link com.smartgwt.client.widgets.grid.ListGrid#getImageSize imageSize}. <P> If set to a String, assumed to be
     * a property on each record that specifies the image height.  For example, if <code>field.imageSize</code> is "logoSize",
     * <code>record.logoSize</code> will control the size of the image.
     *
     * @param imageSize imageSize Default value is 16
     * @see com.smartgwt.client.widgets.grid.ListGridField#setImageWidth
     * @see com.smartgwt.client.widgets.grid.ListGridField#setImageHeight
     * @see com.smartgwt.client.docs.ImageColumns ImageColumns overview and related methods
     */
    public void setImageSize(int imageSize) {
        setAttribute("imageSize", imageSize);
    }

    /**
     * Size of images shown for fieldTypes image and imageFile in this field. This setting overrides the global ListGrid
     * default {@link com.smartgwt.client.widgets.grid.ListGrid#getImageSize imageSize}. <P> If set to a String, assumed to be
     * a property on each record that specifies the image height.  For example, if <code>field.imageSize</code> is "logoSize",
     * <code>record.logoSize</code> will control the size of the image.
     *
     *
     * @return int
     * @see com.smartgwt.client.widgets.grid.ListGridField#getImageWidth
     * @see com.smartgwt.client.widgets.grid.ListGridField#getImageHeight
     * @see com.smartgwt.client.docs.ImageColumns ImageColumns overview and related methods
     */
    public int getImageSize()  {
        return getAttributeAsInt("imageSize");
    }

    /**
     * If this field has type [{@link com.smartgwt.client.types.ListGridFieldType}] set to <code>"image"</code> and the URL for
     * the image displayed is not absolute, the path of the URL will be relative  to this string<br> Alternatively, if this
     * field displays any valueIcons, this prefix will be applied to the beginning of any {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getValueIcons valueIcons} when determining the URL for the image.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param imageURLPrefix imageURLPrefix Default value is null
     * @see com.smartgwt.client.docs.ImageColumns ImageColumns overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#grid_datatypes_image" target="examples">Image Example</a>
     */
    public void setImageURLPrefix(String imageURLPrefix) {
        setAttribute("imageURLPrefix", imageURLPrefix);
    }

    /**
     * If this field has type [{@link com.smartgwt.client.types.ListGridFieldType}] set to <code>"image"</code> and the URL for
     * the image displayed is not absolute, the path of the URL will be relative  to this string<br> Alternatively, if this
     * field displays any valueIcons, this prefix will be applied to the beginning of any {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getValueIcons valueIcons} when determining the URL for the image.
     *
     *
     * @return String
     * @see com.smartgwt.client.docs.ImageColumns ImageColumns overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#grid_datatypes_image" target="examples">Image Example</a>
     */
    public String getImageURLPrefix()  {
        return getAttributeAsString("imageURLPrefix");
    }

    /**
     * If any cells in this field are showing a value icon (see: {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getValueIcons valueIcons}) or this is has {@link
     * com.smartgwt.client.types.ListGridFieldType} set to <code>"image"</code>, this the value of this property will be
     * appended to the end of the URL for the icon displayed.<br> Typical usage might be to append a file type such as
     * <code>".gif"</code> to the filename of the image.<br> For editable fields, this property will also be passed through to
     * any editors as {@link com.smartgwt.client.widgets.form.fields.FormItem#getImageURLSuffix imageURLSuffix}.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param imageURLSuffix imageURLSuffix Default value is null
     * @see com.smartgwt.client.docs.ImageColumns ImageColumns overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#grid_datatypes_image" target="examples">Image Example</a>
     */
    public void setImageURLSuffix(String imageURLSuffix) {
        setAttribute("imageURLSuffix", imageURLSuffix);
    }

    /**
     * If any cells in this field are showing a value icon (see: {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getValueIcons valueIcons}) or this is has {@link
     * com.smartgwt.client.types.ListGridFieldType} set to <code>"image"</code>, this the value of this property will be
     * appended to the end of the URL for the icon displayed.<br> Typical usage might be to append a file type such as
     * <code>".gif"</code> to the filename of the image.<br> For editable fields, this property will also be passed through to
     * any editors as {@link com.smartgwt.client.widgets.form.fields.FormItem#getImageURLSuffix imageURLSuffix}.
     *
     *
     * @return String
     * @see com.smartgwt.client.docs.ImageColumns ImageColumns overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#grid_datatypes_image" target="examples">Image Example</a>
     */
    public String getImageURLSuffix()  {
        return getAttributeAsString("imageURLSuffix");
    }

    /**
     * Width of images shown for fieldTypes image and imageFile in this field. <P> If set to a String, assumed to be a property
     * on each record that specifies the image width.  For example, if <code>field.imageWidth</code> is "logoWidth",
     * <code>record.logoWidth</code> will control the width of the image.
     *
     * @param imageWidth imageWidth Default value is 16
     * @see com.smartgwt.client.widgets.grid.ListGrid#setImageSize
     * @see com.smartgwt.client.widgets.grid.ListGridField#setImageSize
     * @see com.smartgwt.client.widgets.grid.ListGridField#setImageHeight
     * @see com.smartgwt.client.docs.ImageColumns ImageColumns overview and related methods
     */
    public void setImageWidth(int imageWidth) {
        setAttribute("imageWidth", imageWidth);
    }

    /**
     * Width of images shown for fieldTypes image and imageFile in this field. <P> If set to a String, assumed to be a property
     * on each record that specifies the image width.  For example, if <code>field.imageWidth</code> is "logoWidth",
     * <code>record.logoWidth</code> will control the width of the image.
     *
     *
     * @return int
     * @see com.smartgwt.client.widgets.grid.ListGrid#getImageSize
     * @see com.smartgwt.client.widgets.grid.ListGridField#getImageSize
     * @see com.smartgwt.client.widgets.grid.ListGridField#getImageHeight
     * @see com.smartgwt.client.docs.ImageColumns ImageColumns overview and related methods
     */
    public int getImageWidth()  {
        return getAttributeAsInt("imageWidth");
    }

    /**
     * If a listGrid is showing a field of type summary, should this field be passed to the recordSummaryFunction when
     * calculating the summary value to display. If unset, fields are included if they are of type "integer" or "float" only
     * (since most summary functions perform numeric calculations). See also {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getIncludeInRecordSummaryFields includeInRecordSummaryFields}.
     *
     * @param includeInRecordSummary includeInRecordSummary Default value is null
     */
    public void setIncludeInRecordSummary(Boolean includeInRecordSummary) {
        setAttribute("includeInRecordSummary", includeInRecordSummary);
    }

    /**
     * If a listGrid is showing a field of type summary, should this field be passed to the recordSummaryFunction when
     * calculating the summary value to display. If unset, fields are included if they are of type "integer" or "float" only
     * (since most summary functions perform numeric calculations). See also {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getIncludeInRecordSummaryFields includeInRecordSummaryFields}.
     *
     *
     * @return Boolean
     */
    public Boolean getIncludeInRecordSummary()  {
        return getAttributeAsBoolean("includeInRecordSummary");
    }

    /**
     * If set to true and {@link com.smartgwt.client.widgets.grid.ListGrid#getCanRemoveRecords canRemoveRecords} is true, this
     * field will be rendered as the remove-field for this grid. In most common usage scenarios this field will essentially be
     * a placeholder indicating where the remove field should be rendered, meaning properties  other than
     * <code>isRemoveField</code>, such as <code>name</code> or <code>title</code>, may be left unset.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param isRemoveField isRemoveField Default value is null
     * @see com.smartgwt.client.widgets.grid.ListGrid#setCanRemoveRecords
     */
    public void setIsRemoveField(Boolean isRemoveField) {
        setAttribute("isRemoveField", isRemoveField);
    }

    /**
     * If set to true and {@link com.smartgwt.client.widgets.grid.ListGrid#getCanRemoveRecords canRemoveRecords} is true, this
     * field will be rendered as the remove-field for this grid. In most common usage scenarios this field will essentially be
     * a placeholder indicating where the remove field should be rendered, meaning properties  other than
     * <code>isRemoveField</code>, such as <code>name</code> or <code>title</code>, may be left unset.
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.widgets.grid.ListGrid#getCanRemoveRecords
     */
    public Boolean getIsRemoveField()  {
        return getAttributeAsBoolean("isRemoveField");
    }

    /**
     * The HTML to display in cells of this field if the fieldType is set to link. Can be  overridden by {@link
     * com.smartgwt.client.widgets.grid.ListGridRecord#getLinkText linkText}.
     *
     * @param linkText linkText Default value is null
     * @see com.smartgwt.client.types.ListGridFieldType
     * @see com.smartgwt.client.types.FieldType
     * @see com.smartgwt.client.widgets.grid.ListGridRecord#setLinkText
     * @see com.smartgwt.client.widgets.grid.ListGrid#setLinkTextProperty
     * @see com.smartgwt.client.widgets.grid.ListGridField#setLinkTextProperty
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#grid_datatypes_link_image" target="examples">Link (image) Example</a>
     */
    public void setLinkText(String linkText) {
        setAttribute("linkText", linkText);
    }

    /**
     * The HTML to display in cells of this field if the fieldType is set to link. Can be  overridden by {@link
     * com.smartgwt.client.widgets.grid.ListGridRecord#getLinkText linkText}.
     *
     *
     * @return String
     * @see com.smartgwt.client.types.ListGridFieldType
     * @see com.smartgwt.client.types.FieldType
     * @see com.smartgwt.client.widgets.grid.ListGridRecord#getLinkText
     * @see com.smartgwt.client.widgets.grid.ListGrid#getLinkTextProperty
     * @see com.smartgwt.client.widgets.grid.ListGridField#getLinkTextProperty
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#grid_datatypes_link_image" target="examples">Link (image) Example</a>
     */
    public String getLinkText()  {
        return getAttributeAsString("linkText");
    }

    /**
     * The HTML to display in cells of this field if the fieldType is set to link. Can be  overridden by {@link
     * com.smartgwt.client.widgets.grid.ListGridRecord#getLinkText linkText}.
     *
     * @param linkTextProperty linkTextProperty Default value is null
     * @see com.smartgwt.client.types.ListGridFieldType
     * @see com.smartgwt.client.types.FieldType
     * @see com.smartgwt.client.widgets.grid.ListGridRecord#setLinkText
     * @see com.smartgwt.client.widgets.grid.ListGridField#setLinkText
     * @see com.smartgwt.client.widgets.grid.ListGrid#setLinkTextProperty
     */
    public void setLinkTextProperty(String linkTextProperty) {
        setAttribute("linkTextProperty", linkTextProperty);
    }

    /**
     * The HTML to display in cells of this field if the fieldType is set to link. Can be  overridden by {@link
     * com.smartgwt.client.widgets.grid.ListGridRecord#getLinkText linkText}.
     *
     *
     * @return String
     * @see com.smartgwt.client.types.ListGridFieldType
     * @see com.smartgwt.client.types.FieldType
     * @see com.smartgwt.client.widgets.grid.ListGridRecord#getLinkText
     * @see com.smartgwt.client.widgets.grid.ListGridField#getLinkText
     * @see com.smartgwt.client.widgets.grid.ListGrid#getLinkTextProperty
     */
    public String getLinkTextProperty()  {
        return getAttributeAsString("linkTextProperty");
    }

    /**
     * If this field has type [{@link com.smartgwt.client.types.ListGridFieldType}] set to <code>"link"</code>, setting this
     * property will apply a standard prefix to the link URL for cells in this field.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param linkURLPrefix linkURLPrefix Default value is null
     */
    public void setLinkURLPrefix(String linkURLPrefix) {
        setAttribute("linkURLPrefix", linkURLPrefix);
    }

    /**
     * If this field has type [{@link com.smartgwt.client.types.ListGridFieldType}] set to <code>"link"</code>, setting this
     * property will apply a standard prefix to the link URL for cells in this field.
     *
     *
     * @return String
     */
    public String getLinkURLPrefix()  {
        return getAttributeAsString("linkURLPrefix");
    }

    /**
     * If this field has type [{@link com.smartgwt.client.types.ListGridFieldType}] set to <code>"link"</code>, setting this
     * property will apply a standard suffix to the link URL for cells in this field.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param linkURLSuffix linkURLSuffix Default value is null
     */
    public void setLinkURLSuffix(String linkURLSuffix) {
        setAttribute("linkURLSuffix", linkURLSuffix);
    }

    /**
     * If this field has type [{@link com.smartgwt.client.types.ListGridFieldType}] set to <code>"link"</code>, setting this
     * property will apply a standard suffix to the link URL for cells in this field.
     *
     *
     * @return String
     */
    public String getLinkURLSuffix()  {
        return getAttributeAsString("linkURLSuffix");
    }

    /**
     * Name of this field.  Must be unique within this ListGrid. <P> The name of field is also the property in each record
     * which holds the value for that field. <P> If a {@link com.smartgwt.client.widgets.grid.ListGrid#getDataSource
     * dataSource} is specified and the DataSource has a field with the same name, the ListGridField and DataSourceField are
     * merged so that properties on the ListGridField
     *
     * @param name name Default value is null
     */
    public void setName(String name) {
        setAttribute("name", name);
    }

    /**
     * Name of this field.  Must be unique within this ListGrid. <P> The name of field is also the property in each record
     * which holds the value for that field. <P> If a {@link com.smartgwt.client.widgets.grid.ListGrid#getDataSource
     * dataSource} is specified and the DataSource has a field with the same name, the ListGridField and DataSourceField are
     * merged so that properties on the ListGridField
     *
     *
     * @return String
     */
    public String getName()  {
        return getAttributeAsString("name");
    }

    /**
     * If {@link com.smartgwt.client.widgets.grid.ListGridField#getOptionDataSource optionDataSource} is set for this
     * ListGridField, criteria specified in this attribute will be passed to the dataSource when performing the fetch operation
     * to determine data-value to display-value mappings
     *
     * @param optionCriteria optionCriteria Default value is null
     */
    public void setOptionCriteria(Criteria optionCriteria) {
        setAttribute("optionCriteria", optionCriteria.getJsObj());
    }

    /**
     * If {@link com.smartgwt.client.widgets.grid.ListGridField#getOptionDataSource optionDataSource} is set for this
     * ListGridField, criteria specified in this attribute will be passed to the dataSource when performing the fetch operation
     * to determine data-value to display-value mappings
     *
     *
     * @return Criteria
     */
    public Criteria getOptionCriteria()  {
        return new Criteria(getAttributeAsJavaScriptObject("optionCriteria"));
    }

    /**
     * If this field has an optionDataSource specified and  {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getAutoFetchDisplayMap autoFetchDisplayMap} is set, this attribute
     * provides a way to customize the {@link com.smartgwt.client.data.DSRequest#getOperationId operationId} passed to 
     * <code>dataSource.fetchData()</code> when retrieving the display map from the option  dataSource.
     *
     * @param optionOperationId optionOperationId Default value is null
     */
    public void setOptionOperationId(String optionOperationId) {
        setAttribute("optionOperationId", optionOperationId);
    }

    /**
     * If this field has an optionDataSource specified and  {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getAutoFetchDisplayMap autoFetchDisplayMap} is set, this attribute
     * provides a way to customize the {@link com.smartgwt.client.data.DSRequest#getOperationId operationId} passed to 
     * <code>dataSource.fetchData()</code> when retrieving the display map from the option  dataSource.
     *
     *
     * @return String
     */
    public String getOptionOperationId()  {
        return getAttributeAsString("optionOperationId");
    }

    /**
     * For fields with an {@link com.smartgwt.client.widgets.grid.ListGridField#getOptionDataSource optionDataSource}, where
     * {@link com.smartgwt.client.widgets.grid.ListGridField#getAutoFetchDisplayMap autoFetchDisplayMap} is true, this property
     * will govern the <code>textMatchStyle</code> attribute of the {@link com.smartgwt.client.data.DSRequest} parameter passed
     * to  {@link com.smartgwt.client.data.DataSource#fetchData DataSource.fetchData} when retrieving the remote data set to be
     * used as  a basis for this field's valueMap.
     *
     * @param optionTextMatchStyle optionTextMatchStyle Default value is null
     */
    public void setOptionTextMatchStyle(TextMatchStyle optionTextMatchStyle) {
        setAttribute("optionTextMatchStyle", optionTextMatchStyle.getValue());
    }

    /**
     * For fields with an {@link com.smartgwt.client.widgets.grid.ListGridField#getOptionDataSource optionDataSource}, where
     * {@link com.smartgwt.client.widgets.grid.ListGridField#getAutoFetchDisplayMap autoFetchDisplayMap} is true, this property
     * will govern the <code>textMatchStyle</code> attribute of the {@link com.smartgwt.client.data.DSRequest} parameter passed
     * to  {@link com.smartgwt.client.data.DataSource#fetchData DataSource.fetchData} when retrieving the remote data set to be
     * used as  a basis for this field's valueMap.
     *
     *
     * @return TextMatchStyle
     */
    public TextMatchStyle getOptionTextMatchStyle()  {
        return EnumUtil.getEnum(TextMatchStyle.values(), getAttribute("optionTextMatchStyle"));
    }

    /**
     * Only applies to fields of type <code>"summary"</code>. This attribute is set on a summary field, when calculating the
     * summary value from some record, the summary function will only be passed the fields before this summary field. This may
     * be useful for displaying running totals across a record. <P> Note that this feature would typically be used with {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getCanReorderFields canReorderFields:false}
     *
     * @param partialSummary partialSummary Default value is null
     */
    public void setPartialSummary(Boolean partialSummary) {
        setAttribute("partialSummary", partialSummary);
    }

    /**
     * Only applies to fields of type <code>"summary"</code>. This attribute is set on a summary field, when calculating the
     * summary value from some record, the summary function will only be passed the fields before this summary field. This may
     * be useful for displaying running totals across a record. <P> Note that this feature would typically be used with {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getCanReorderFields canReorderFields:false}
     *
     *
     * @return Boolean
     */
    public Boolean getPartialSummary()  {
        return getAttributeAsBoolean("partialSummary");
    }

    /**
     * Causes a tooltip hover to appear on the header generated for this field (effectively sets {@link
     * com.smartgwt.client.widgets.Canvas#getPrompt prompt} for the header).
     *
     * @param prompt prompt Default value is null
     */
    public void setPrompt(String prompt) {
        setAttribute("prompt", prompt);
    }

    /**
     * Causes a tooltip hover to appear on the header generated for this field (effectively sets {@link
     * com.smartgwt.client.widgets.Canvas#getPrompt prompt} for the header).
     *
     *
     * @return String
     */
    public String getPrompt()  {
        return getAttributeAsString("prompt");
    }

    /**
     * When the user edits cells in this field, is this value required to be non-empty  in order for validation to pass.<br>
     * Note: for databound listGrids, this property may be specified on the  {@link com.smartgwt.client.data.DataSourceField},
     * enabling both client and server side validation.
     *
     * @param required required Default value is null
     * @see com.smartgwt.client.widgets.grid.ListGridField#setValidators
     * @see com.smartgwt.client.docs.GridValidation GridValidation overview and related methods
     */
    public void setRequired(Boolean required) {
        setAttribute("required", required);
    }

    /**
     * When the user edits cells in this field, is this value required to be non-empty  in order for validation to pass.<br>
     * Note: for databound listGrids, this property may be specified on the  {@link com.smartgwt.client.data.DataSourceField},
     * enabling both client and server side validation.
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.widgets.grid.ListGridField#getValidators
     * @see com.smartgwt.client.docs.GridValidation GridValidation overview and related methods
     */
    public Boolean getRequired()  {
        return getAttributeAsBoolean("required");
    }

    /**
     * Whether this field should be included in the printable representation of the grid.
     *
     * @param shouldPrint shouldPrint Default value is null
     * @see com.smartgwt.client.docs.Printing Printing overview and related methods
     */
    public void setShouldPrint(Boolean shouldPrint) {
        setAttribute("shouldPrint", shouldPrint);
    }

    /**
     * Whether this field should be included in the printable representation of the grid.
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.docs.Printing Printing overview and related methods
     */
    public Boolean getShouldPrint()  {
        return getAttributeAsBoolean("shouldPrint");
    }

    /**
     * When set to false, don't apply alternate-row styling to this field.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param showAlternateStyle showAlternateStyle Default value is null
     */
    public void setShowAlternateStyle(Boolean showAlternateStyle) {
        setAttribute("showAlternateStyle", showAlternateStyle);
    }

    /**
     * When set to false, don't apply alternate-row styling to this field.
     *
     *
     * @return Boolean
     */
    public Boolean getShowAlternateStyle()  {
        return getAttributeAsBoolean("showAlternateStyle");
    }

    /**
     * When set to false, this field will not show a context menu in it's header.
     *
     * @param showDefaultContextMenu showDefaultContextMenu Default value is true
     */
    public void setShowDefaultContextMenu(Boolean showDefaultContextMenu) {
        setAttribute("showDefaultContextMenu", showDefaultContextMenu);
    }

    /**
     * When set to false, this field will not show a context menu in it's header.
     *
     *
     * @return Boolean
     */
    public Boolean getShowDefaultContextMenu()  {
        return getAttributeAsBoolean("showDefaultContextMenu");
    }

    /**
     * If using an icon for this button, whether to switch the icon image if the button becomes disabled.
     *
     * @param showDisabledIcon showDisabledIcon Default value is true
     * @see com.smartgwt.client.widgets.grid.ListGridField#setIcon
     * @see com.smartgwt.client.docs.ButtonIcon ButtonIcon overview and related methods
     */
    public void setShowDisabledIcon(Boolean showDisabledIcon) {
        setAttribute("showDisabledIcon", showDisabledIcon);
    }

    /**
     * If using an icon for this button, whether to switch the icon image if the button becomes disabled.
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.widgets.grid.ListGridField#getIcon
     * @see com.smartgwt.client.docs.ButtonIcon ButtonIcon overview and related methods
     */
    public Boolean getShowDisabledIcon()  {
        return getAttributeAsBoolean("showDisabledIcon");
    }

    /**
     * If using an icon for this button, whether to switch the icon image when the mouse goes down on the button.
     *
     * @param showDownIcon showDownIcon Default value is false
     * @see com.smartgwt.client.widgets.grid.ListGridField#setIcon
     * @see com.smartgwt.client.docs.ButtonIcon ButtonIcon overview and related methods
     */
    public void setShowDownIcon(Boolean showDownIcon) {
        setAttribute("showDownIcon", showDownIcon);
    }

    /**
     * If using an icon for this button, whether to switch the icon image when the mouse goes down on the button.
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.widgets.grid.ListGridField#getIcon
     * @see com.smartgwt.client.docs.ButtonIcon ButtonIcon overview and related methods
     */
    public Boolean getShowDownIcon()  {
        return getAttributeAsBoolean("showDownIcon");
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
     * If using an icon for this button, whether to switch the icon image when the button receives focus. <P> If {@link
     * com.smartgwt.client.widgets.StatefulCanvas#getShowFocusedAsOver showFocusedAsOver} is true, the <code>"Over"</code> icon
     * will be displayed when the canvas has focus, otherwise a separate <code>"Focused"</code> icon will be displayed
     *
     * @param showFocusedIcon showFocusedIcon Default value is false
     * @see com.smartgwt.client.widgets.grid.ListGridField#setIcon
     * @see com.smartgwt.client.docs.ButtonIcon ButtonIcon overview and related methods
     */
    public void setShowFocusedIcon(Boolean showFocusedIcon) {
        setAttribute("showFocusedIcon", showFocusedIcon);
    }

    /**
     * If using an icon for this button, whether to switch the icon image when the button receives focus. <P> If {@link
     * com.smartgwt.client.widgets.StatefulCanvas#getShowFocusedAsOver showFocusedAsOver} is true, the <code>"Over"</code> icon
     * will be displayed when the canvas has focus, otherwise a separate <code>"Focused"</code> icon will be displayed
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.widgets.grid.ListGridField#getIcon
     * @see com.smartgwt.client.docs.ButtonIcon ButtonIcon overview and related methods
     */
    public Boolean getShowFocusedIcon()  {
        return getAttributeAsBoolean("showFocusedIcon");
    }

    /**
     * If {@link com.smartgwt.client.widgets.grid.ListGrid#getShowGridSummary showGridSummary} is true, should this field show
     * a summary value. If unset, this field will show a summary value in the summary row if an explicit {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getSummaryFunction summaryFunction} is specified or if a {@link
     * com.smartgwt.client.data.SimpleType#getDefaultSummaryFunction default summary function} is defined for the specified
     * field type.
     *
     * @param showGridSummary showGridSummary Default value is null
     */
    public void setShowGridSummary(Boolean showGridSummary) {
        setAttribute("showGridSummary", showGridSummary);
    }

    /**
     * If {@link com.smartgwt.client.widgets.grid.ListGrid#getShowGridSummary showGridSummary} is true, should this field show
     * a summary value. If unset, this field will show a summary value in the summary row if an explicit {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getSummaryFunction summaryFunction} is specified or if a {@link
     * com.smartgwt.client.data.SimpleType#getDefaultSummaryFunction default summary function} is defined for the specified
     * field type.
     *
     *
     * @return Boolean
     */
    public Boolean getShowGridSummary()  {
        return getAttributeAsBoolean("showGridSummary");
    }

    /**
     * If {@link com.smartgwt.client.widgets.grid.ListGrid#getShowGroupSummary showGroupSummary} is true, should this field
     * show a summary value in a summary row when the grid is grouped? If unset, this field will show a summary value in the
     * summary row if an explicit {@link com.smartgwt.client.widgets.grid.ListGridField#getSummaryFunction summaryFunction} is
     * specified or if a {@link com.smartgwt.client.data.SimpleType#getDefaultSummaryFunction default summary function} is
     * defined for the specified field type.
     *
     * @param showGroupSummary showGroupSummary Default value is null
     */
    public void setShowGroupSummary(Boolean showGroupSummary) {
        setAttribute("showGroupSummary", showGroupSummary);
    }

    /**
     * If {@link com.smartgwt.client.widgets.grid.ListGrid#getShowGroupSummary showGroupSummary} is true, should this field
     * show a summary value in a summary row when the grid is grouped? If unset, this field will show a summary value in the
     * summary row if an explicit {@link com.smartgwt.client.widgets.grid.ListGridField#getSummaryFunction summaryFunction} is
     * specified or if a {@link com.smartgwt.client.data.SimpleType#getDefaultSummaryFunction default summary function} is
     * defined for the specified field type.
     *
     *
     * @return Boolean
     */
    public Boolean getShowGroupSummary()  {
        return getAttributeAsBoolean("showGroupSummary");
    }

    /**
     * Whether to show hovers for this field.  The default hover will be the contents of the cell the user is hovering over,
     * and can be customized via {@link com.smartgwt.client.widgets.grid.ListGridField#hoverHTML field.hoverHTML()}. <P> {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getCanHover canHover} can be set to true to cause hovers to be shown for all
     * fields by default.  In this case, <code>field.showHover</code> can be set to false to suppress hovers for an individual
     * field. <P> All hovers can be disabled, regardless of other settings, by setting {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getShowHover showHover} to false.
     *
     * @param showHover showHover Default value is null
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#grid_interaction_value_hover" target="examples">Value hover tips Example</a>
     */
    public void setShowHover(Boolean showHover) {
        setAttribute("showHover", showHover);
    }

    /**
     * Whether to show hovers for this field.  The default hover will be the contents of the cell the user is hovering over,
     * and can be customized via {@link com.smartgwt.client.widgets.grid.ListGridField#hoverHTML field.hoverHTML()}. <P> {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getCanHover canHover} can be set to true to cause hovers to be shown for all
     * fields by default.  In this case, <code>field.showHover</code> can be set to false to suppress hovers for an individual
     * field. <P> All hovers can be disabled, regardless of other settings, by setting {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getShowHover showHover} to false.
     *
     *
     * @return Boolean
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#grid_interaction_value_hover" target="examples">Value hover tips Example</a>
     */
    public Boolean getShowHover()  {
        return getAttributeAsBoolean("showHover");
    }

    /**
     * If using an icon for this button, whether to switch the icon image on mouse rollover.
     *
     * @param showRollOverIcon showRollOverIcon Default value is false
     * @see com.smartgwt.client.widgets.grid.ListGridField#setIcon
     * @see com.smartgwt.client.docs.ButtonIcon ButtonIcon overview and related methods
     */
    public void setShowRollOverIcon(Boolean showRollOverIcon) {
        setAttribute("showRollOverIcon", showRollOverIcon);
    }

    /**
     * If using an icon for this button, whether to switch the icon image on mouse rollover.
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.widgets.grid.ListGridField#getIcon
     * @see com.smartgwt.client.docs.ButtonIcon ButtonIcon overview and related methods
     */
    public Boolean getShowRollOverIcon()  {
        return getAttributeAsBoolean("showRollOverIcon");
    }

    /**
     * If using an icon for this button, whether to switch the icon image when the button becomes selected.
     *
     * @param showSelectedIcon showSelectedIcon Default value is false
     * @see com.smartgwt.client.widgets.grid.ListGridField#setIcon
     * @see com.smartgwt.client.docs.ButtonIcon ButtonIcon overview and related methods
     */
    public void setShowSelectedIcon(Boolean showSelectedIcon) {
        setAttribute("showSelectedIcon", showSelectedIcon);
    }

    /**
     * If using an icon for this button, whether to switch the icon image when the button becomes selected.
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.widgets.grid.ListGridField#getIcon
     * @see com.smartgwt.client.docs.ButtonIcon ButtonIcon overview and related methods
     */
    public Boolean getShowSelectedIcon()  {
        return getAttributeAsBoolean("showSelectedIcon");
    }

    /**
     * If this field has a valueIcons property specified, setting this property causes  the valueIcon for each value to be
     * displayed in the cell without also showing the record's value for the field. <P> If unset the default behavior is to
     * show the icon only if an explicit valueMap is specified as well in addition to a valueIcons map, otherwise show both the
     * valueIcon and value for the cell. <P> Note that if this field is editable {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getShowValueIconOnly showValueIconOnly} will be passed through to
     * editors displayed in this field.
     *
     * @param showValueIconOnly showValueIconOnly Default value is null
     * @see com.smartgwt.client.widgets.grid.ListGridField#setValueIcons
     * @see com.smartgwt.client.widgets.grid.ListGridField#setSuppressValueIcon
     * @see com.smartgwt.client.docs.ImageColumns ImageColumns overview and related methods
     */
    public void setShowValueIconOnly(Boolean showValueIconOnly) {
        setAttribute("showValueIconOnly", showValueIconOnly);
    }

    /**
     * If this field has a valueIcons property specified, setting this property causes  the valueIcon for each value to be
     * displayed in the cell without also showing the record's value for the field. <P> If unset the default behavior is to
     * show the icon only if an explicit valueMap is specified as well in addition to a valueIcons map, otherwise show both the
     * valueIcon and value for the cell. <P> Note that if this field is editable {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getShowValueIconOnly showValueIconOnly} will be passed through to
     * editors displayed in this field.
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.widgets.grid.ListGridField#getValueIcons
     * @see com.smartgwt.client.widgets.grid.ListGridField#getSuppressValueIcon
     * @see com.smartgwt.client.docs.ImageColumns ImageColumns overview and related methods
     */
    public Boolean getShowValueIconOnly()  {
        return getAttributeAsBoolean("showValueIconOnly");
    }

    /**
     * For a field with <code>displayField</code> configured, should client-side sorting be performed on the display field
     * value? Unless explicitly set to <code>false</code> the display field value is used.
     *
     * @param sortByDisplayField sortByDisplayField Default value is null
     */
    public void setSortByDisplayField(Boolean sortByDisplayField) {
        setAttribute("sortByDisplayField", sortByDisplayField);
    }

    /**
     * For a field with <code>displayField</code> configured, should client-side sorting be performed on the display field
     * value? Unless explicitly set to <code>false</code> the display field value is used.
     *
     *
     * @return Boolean
     */
    public Boolean getSortByDisplayField()  {
        return getAttributeAsBoolean("sortByDisplayField");
    }

    /**
     * Optional long summary title for this field, provided in addition to  {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getTitle title}. This gives the developer an option to use a very short,
     * or empty title for the ListGrid column (where space may be a factor), but have a longer  value available to be used
     * elsewhere.<br> By default this value will be used for the title of the context-menu item for showing/hiding the listGrid
     * field when the user right-clicks on the ListGrid header.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param summaryTitle summaryTitle Default value is null
     * @see com.smartgwt.client.widgets.grid.ListGridField#setTitle
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setSummaryTitle(String summaryTitle) {
        setAttribute("summaryTitle", summaryTitle);
    }

    /**
     * Optional long summary title for this field, provided in addition to  {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getTitle title}. This gives the developer an option to use a very short,
     * or empty title for the ListGrid column (where space may be a factor), but have a longer  value available to be used
     * elsewhere.<br> By default this value will be used for the title of the context-menu item for showing/hiding the listGrid
     * field when the user right-clicks on the ListGrid header.
     *
     *
     * @return Optional string method to return a long summary title for this field, if a dynamic summary title is required for this
     * field.
     * @see com.smartgwt.client.widgets.grid.ListGridField#getTitle
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getSummaryTitle()  {
        return getAttributeAsString("summaryTitle");
    }

    /**
     * If this field has a valueIcons property specified, setting this property to true will  prevent the valueIcon being
     * written out into this field's cells.
     *
     * @param suppressValueIcon suppressValueIcon Default value is null
     * @see com.smartgwt.client.widgets.grid.ListGridField#setValueIcons
     * @see com.smartgwt.client.widgets.grid.ListGridField#setShowValueIconOnly
     * @see com.smartgwt.client.docs.ImageColumns ImageColumns overview and related methods
     */
    public void setSuppressValueIcon(Boolean suppressValueIcon) {
        setAttribute("suppressValueIcon", suppressValueIcon);
    }

    /**
     * If this field has a valueIcons property specified, setting this property to true will  prevent the valueIcon being
     * written out into this field's cells.
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.widgets.grid.ListGridField#getValueIcons
     * @see com.smartgwt.client.widgets.grid.ListGridField#getShowValueIconOnly
     * @see com.smartgwt.client.docs.ImageColumns ImageColumns overview and related methods
     */
    public Boolean getSuppressValueIcon()  {
        return getAttributeAsBoolean("suppressValueIcon");
    }

    /**
     * By default, clicking a link rendered by this item opens it in a new browser window.  You  can alter this behavior by
     * setting this property.  The value of this property will be  passed as the value to the <code>target</code> attribute of
     * the anchor tag used to render  the link. <P> If you set listGridField.target to "javascript", the default behavior is to
     * catch and  consume mouse-clicks that would result in the link being followed.  Instead, the {@link
     * com.smartgwt.client.widgets.grid.ListGrid#addCellClickHandler ListGrid.cellClick} event is fired for the containing
     * cell.
     *
     * @param target target Default value is "_blank"
     */
    public void setTarget(String target) {
        setAttribute("target", target);
    }

    /**
     * By default, clicking a link rendered by this item opens it in a new browser window.  You  can alter this behavior by
     * setting this property.  The value of this property will be  passed as the value to the <code>target</code> attribute of
     * the anchor tag used to render  the link. <P> If you set listGridField.target to "javascript", the default behavior is to
     * catch and  consume mouse-clicks that would result in the link being followed.  Instead, the {@link
     * com.smartgwt.client.widgets.grid.ListGrid#addCellClickHandler ListGrid.cellClick} event is fired for the containing
     * cell.
     *
     *
     * @return String
     */
    public String getTarget()  {
        return getAttributeAsString("target");
    }

    /**
     * A title for this field, to display in the header of the listGrid object.  Alternately you can specify a {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getFieldTitle ListGridField.getFieldTitle} method on the field to return
     * the HTML for the field title.
     *
     * @param title title Default value is null
     * @see com.smartgwt.client.widgets.grid.ListGridField#getFieldTitle
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setTitle(String title) {
        setAttribute("title", title);
    }

    /**
     * A title for this field, to display in the header of the listGrid object.  Alternately you can specify a {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getFieldTitle ListGridField.getFieldTitle} method on the field to return
     * the HTML for the field title.
     *
     *
     * @return String
     * @see com.smartgwt.client.widgets.grid.ListGridField#getFieldTitle
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getTitle()  {
        return getAttributeAsString("title");
    }

    /**
     * ListGrids picks a renderer for the view and edit mode of a field based on this attribute.
     *
     * @param type type Default value is "text"
     * @see com.smartgwt.client.types.ListGridFieldType
     * @see com.smartgwt.client.types.FieldType
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setType(ListGridFieldType type) {
        setAttribute("type", type.getValue());
    }

    /**
     * ListGrids picks a renderer for the view and edit mode of a field based on this attribute.
     *
     *
     * @return ListGridFieldType
     * @see com.smartgwt.client.types.ListGridFieldType
     * @see com.smartgwt.client.types.FieldType
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public ListGridFieldType getType()  {
        return EnumUtil.getEnum(ListGridFieldType.values(), getAttribute("type"));
    }

    /**
     * If set to true, any {@link com.smartgwt.client.widgets.grid.ListGridField#getValidators validators} for this field will
     * be run whenever the value of the field is changed. <P> Analogous to the {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getValidateOnChange validateOnChange} property.
     *
     * @param validateOnChange validateOnChange Default value is null
     * @see com.smartgwt.client.docs.GridValidation GridValidation overview and related methods
     */
    public void setValidateOnChange(Boolean validateOnChange) {
        setAttribute("validateOnChange", validateOnChange);
    }

    /**
     * If set to true, any {@link com.smartgwt.client.widgets.grid.ListGridField#getValidators validators} for this field will
     * be run whenever the value of the field is changed. <P> Analogous to the {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getValidateOnChange validateOnChange} property.
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.docs.GridValidation GridValidation overview and related methods
     */
    public Boolean getValidateOnChange()  {
        return getAttributeAsBoolean("validateOnChange");
    }

    /**
     * Specifies the {@link com.smartgwt.client.widgets.grid.ListGridField#getOptionDataSource optionDataSource} field used to
     * retrieve the stored values that are to be mapped to the display values (specified by {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getDisplayField displayField}). Note that if this field is editable this
     * will also be applied to this field's editors.
     *
     * @param valueField valueField Default value is null
     */
    public void setValueField(String valueField) {
        setAttribute("valueField", valueField);
    }

    /**
     * Specifies the {@link com.smartgwt.client.widgets.grid.ListGridField#getOptionDataSource optionDataSource} field used to
     * retrieve the stored values that are to be mapped to the display values (specified by {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getDisplayField displayField}). Note that if this field is editable this
     * will also be applied to this field's editors.
     *
     *
     * @return String
     */
    public String getValueField()  {
        return getAttributeAsString("valueField");
    }

    /**
     * Height for value icons for this listGrid field. Overrides {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getValueIconSize valueIconSize}, {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getValueIconHeight valueIconHeight}, and {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getValueIconSize valueIconSize}.
     *
     * @param valueIconHeight valueIconHeight Default value is null
     * @see com.smartgwt.client.docs.ImageColumns ImageColumns overview and related methods
     */
    public void setValueIconHeight(Integer valueIconHeight) {
        setAttribute("valueIconHeight", valueIconHeight);
    }

    /**
     * Height for value icons for this listGrid field. Overrides {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getValueIconSize valueIconSize}, {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getValueIconHeight valueIconHeight}, and {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getValueIconSize valueIconSize}.
     *
     *
     * @return Integer
     * @see com.smartgwt.client.docs.ImageColumns ImageColumns overview and related methods
     */
    public Integer getValueIconHeight()  {
        return getAttributeAsInt("valueIconHeight");
    }

    /**
     * How much padding should there be on the left of valueIcons for this field Overrides {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getValueIconLeftPadding valueIconLeftPadding}
     *
     * @param valueIconLeftPadding valueIconLeftPadding Default value is null
     * @see com.smartgwt.client.widgets.grid.ListGridField#setValueIcons
     * @see com.smartgwt.client.docs.ImageColumns ImageColumns overview and related methods
     */
    public void setValueIconLeftPadding(Integer valueIconLeftPadding) {
        setAttribute("valueIconLeftPadding", valueIconLeftPadding);
    }

    /**
     * How much padding should there be on the left of valueIcons for this field Overrides {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getValueIconLeftPadding valueIconLeftPadding}
     *
     *
     * @return Integer
     * @see com.smartgwt.client.widgets.grid.ListGridField#getValueIcons
     * @see com.smartgwt.client.docs.ImageColumns ImageColumns overview and related methods
     */
    public Integer getValueIconLeftPadding()  {
        return getAttributeAsInt("valueIconLeftPadding");
    }

    /**
     * If we're showing a valueIcon for this field should it appear to the left or the right of the text?  By default the icon
     * will appear to the left of the textual value -  set this to "right" to show the icon on the right of the text. Has no
     * effect if {@link com.smartgwt.client.widgets.grid.ListGridField#getShowValueIconOnly showValueIconOnly} is true
     *
     * @param valueIconOrientation valueIconOrientation Default value is null
     * @see com.smartgwt.client.docs.ImageColumns ImageColumns overview and related methods
     */
    public void setValueIconOrientation(String valueIconOrientation) {
        setAttribute("valueIconOrientation", valueIconOrientation);
    }

    /**
     * If we're showing a valueIcon for this field should it appear to the left or the right of the text?  By default the icon
     * will appear to the left of the textual value -  set this to "right" to show the icon on the right of the text. Has no
     * effect if {@link com.smartgwt.client.widgets.grid.ListGridField#getShowValueIconOnly showValueIconOnly} is true
     *
     *
     * @return String
     * @see com.smartgwt.client.docs.ImageColumns ImageColumns overview and related methods
     */
    public String getValueIconOrientation()  {
        return getAttributeAsString("valueIconOrientation");
    }

    /**
     * How much padding should there be on the right of valueIcons for this field Overrides {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getValueIconRightPadding valueIconRightPadding}
     *
     * @param valueIconRightPadding valueIconRightPadding Default value is null
     * @see com.smartgwt.client.widgets.grid.ListGridField#setValueIcons
     * @see com.smartgwt.client.docs.ImageColumns ImageColumns overview and related methods
     */
    public void setValueIconRightPadding(Integer valueIconRightPadding) {
        setAttribute("valueIconRightPadding", valueIconRightPadding);
    }

    /**
     * How much padding should there be on the right of valueIcons for this field Overrides {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getValueIconRightPadding valueIconRightPadding}
     *
     *
     * @return Integer
     * @see com.smartgwt.client.widgets.grid.ListGridField#getValueIcons
     * @see com.smartgwt.client.docs.ImageColumns ImageColumns overview and related methods
     */
    public Integer getValueIconRightPadding()  {
        return getAttributeAsInt("valueIconRightPadding");
    }

    /**
     * Default width and height of value icons in this field. Takes precedence over valueIconWidth, valueIconHeight and
     * valueIconSize specified at the ListGrid level. Can be overridden via {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getValueIconWidth valueIconWidth} and {ListGridField.valueIconHeight}
     *
     * @param valueIconSize valueIconSize Default value is null
     * @see com.smartgwt.client.widgets.grid.ListGrid#setValueIconSize
     * @see com.smartgwt.client.widgets.grid.ListGridField#setValueIconWidth
     * @see com.smartgwt.client.widgets.grid.ListGridField#setValueIconHeight
     * @see com.smartgwt.client.docs.ImageColumns ImageColumns overview and related methods
     */
    public void setValueIconSize(Integer valueIconSize) {
        setAttribute("valueIconSize", valueIconSize);
    }

    /**
     * Default width and height of value icons in this field. Takes precedence over valueIconWidth, valueIconHeight and
     * valueIconSize specified at the ListGrid level. Can be overridden via {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getValueIconWidth valueIconWidth} and {ListGridField.valueIconHeight}
     *
     *
     * @return Integer
     * @see com.smartgwt.client.widgets.grid.ListGrid#getValueIconSize
     * @see com.smartgwt.client.widgets.grid.ListGridField#getValueIconWidth
     * @see com.smartgwt.client.widgets.grid.ListGridField#getValueIconHeight
     * @see com.smartgwt.client.docs.ImageColumns ImageColumns overview and related methods
     */
    public Integer getValueIconSize()  {
        return getAttributeAsInt("valueIconSize");
    }

    /**
     * Width for value icons for this listGrid field. Overrides {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getValueIconSize valueIconSize}, {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getValueIconWidth valueIconWidth}, and {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getValueIconSize valueIconSize}.
     *
     * @param valueIconWidth valueIconWidth Default value is null
     * @see com.smartgwt.client.docs.ImageColumns ImageColumns overview and related methods
     */
    public void setValueIconWidth(Integer valueIconWidth) {
        setAttribute("valueIconWidth", valueIconWidth);
    }

    /**
     * Width for value icons for this listGrid field. Overrides {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getValueIconSize valueIconSize}, {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getValueIconWidth valueIconWidth}, and {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getValueIconSize valueIconSize}.
     *
     *
     * @return Integer
     * @see com.smartgwt.client.docs.ImageColumns ImageColumns overview and related methods
     */
    public Integer getValueIconWidth()  {
        return getAttributeAsInt("valueIconWidth");
    }

    // ********************* Methods ***********************
    /**
     * Add a editorEnter handler.
     * <p>
     * Callback fired when the user first starts editing a cell. <P> This callback is typically used to establish dynamic
     * default values via {@link com.smartgwt.client.widgets.grid.ListGrid#setEditValue ListGrid.setEditValue} or {@link
     * com.smartgwt.client.widgets.grid.ListGrid#setEditValues ListGrid.setEditValues}.
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
            obj.editorEnter = $entry(function(){
                var param = {"record" : arguments[0], "value" : arguments[1], "rowNum" : arguments[2], "colNum" : arguments[3], "grid" : arguments[4]};
                var event = @com.smartgwt.client.widgets.grid.events.EditorEnterEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                selfJ.@com.smartgwt.client.core.DataClass::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            });
   }-*/;
    /**
     * Add a editorExit handler.
     * <p>
     * Callback fired when the user attempts to navigate away from the current edit cell,  or complete the current edit.<br>
     * Return false from this method to cancel the default behavior (Saving / cancelling the current edit / moving to the next
     * edit cell)
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
            obj.editorExit = $debox($entry(function(){
                var param = {"editCompletionEvent" : arguments[0], "record" : arguments[1], "newValue" : arguments[2], "rowNum" : arguments[3], "colNum" : arguments[4], "grid" : arguments[5]};
                var event = @com.smartgwt.client.widgets.grid.events.EditorExitEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                selfJ.@com.smartgwt.client.core.DataClass::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                return !ret;
            }));
   }-*/;
            
    /**
     * If your derivation of the field title is more complex than specifying a static string, you can specify a getFieldTitle()
     * method on your field to return the title string. Otherwise you can use the {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getTitle title} attribute on the field to specify the title. <P> You can
     * use {@link com.smartgwt.client.widgets.grid.ListGrid#setFieldProperties setFieldProperties()} to dynamically update the
     * title.
     * @param viewer pointer back to the ListGrid
     * @param fieldNum index of this field in the grid's fields array.
     */
    public native void getFieldTitle(ListGrid viewer, int fieldNum) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.getFieldTitle(viewer.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()(), fieldNum);
    }-*/;
    /**
     * Add a recordClick handler.
     * <p>
     * Executed when this field is clicked on.  Note that if {@link
     * com.smartgwt.client.widgets.grid.ListGrid#addRecordClickHandler ListGrid.recordClick} is also defined, it will be fired
     * for fields that define a recordClick handler if the field-level handler returns true. Return false to prevent the
     * grid-level handler from firing.
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
            obj.recordClick = $debox($entry(function(){
                var param = {"viewer" : arguments[0], "record" : arguments[1], "recordNum" : arguments[2], "field" : arguments[3], "fieldNum" : arguments[4], "value" : arguments[5], "rawValue" : arguments[6]};
                var event = @com.smartgwt.client.widgets.grid.events.RecordClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                selfJ.@com.smartgwt.client.core.DataClass::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                return !ret;
            }));
   }-*/;

    // ********************* Static Methods ***********************
        
    // ***********************************************************        


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
     * @return DateDisplayFormat
     */
    public DateDisplayFormat getDateFormatter() {
        return EnumUtil.getEnum(DateDisplayFormat.values(), getAttribute("dateFormatter"));
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
     * @return the value map
     */
    public Map getGroupingModes() {
        return getAttributeAsMap("groupingModes");
    }

    /**
     * Return the HTML to display in cells of this field. <P> Given the raw value for this field as taken from the
     * record Formatter to apply to the static values displayed in cells for this field. <P> <i>Example usage</i>:
     * formatting a currency value stored in cents (so "100" to "$1.00")<br> The value passed to this method is the raw
     * value for the cell.<br> Takes precedence over <code>formatCellValue</code> defined at the grid level for cells in
     * this field. <P> Note: this formatter will not be applied to the values displayed in cells being edited. The
     * {@link com.smartgwt.client.widgets.grid.ListGridField#setEditValueFormatter} is provided for that purpose.
     *
     * @param formatter the formatter
     */
    public native void setCellFormatter(CellFormatter formatter) /*-{
            var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
            self.formatCellValue = $debox($entry(function(value, record, rowNum, colNum) {
                var recordJ = @com.smartgwt.client.widgets.grid.ListGridRecord::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(record);
                var valueJ = $wnd.SmartGWT.convertToJavaType(value);
                return formatter.@com.smartgwt.client.widgets.grid.CellFormatter::format(Ljava/lang/Object;Lcom/smartgwt/client/widgets/grid/ListGridRecord;II)(valueJ, recordJ, rowNum, colNum);
            }));
    }-*/;

    /**
     * Return the value to display in cells of this field which are being edited. <P> <i>Example usage</i>: converting a stored
     * value in cents (100) to a dollar-and-cents  value in the editor (1.00) <P> The value passed to this method is the raw
     * value for the cell.<P> To convert the formatted value displayed within an editor back to a raw value, implement {@link
     * com.smartgwt.client.widgets.grid.ListGridField#setEditorValueParser} as well.
     * @see com.smartgwt.client.docs.Editing Editing overview and related methods
     *
     * @param formatter the CellEditValueFormatter
     */
    public native void setEditValueFormatter(CellEditValueFormatter formatter) /*-{
	    var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
	    self.formatEditorValue = $debox($entry(function(value, record, rowNum, colNum) {
	        var recordJ = @com.smartgwt.client.widgets.grid.ListGridRecord::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(record);
	        var valueJ = $wnd.SmartGWT.convertToJavaType(value);
	        var val = formatter.@com.smartgwt.client.widgets.grid.CellEditValueFormatter::format(Ljava/lang/Object;Lcom/smartgwt/client/widgets/grid/ListGridRecord;II)(valueJ, recordJ, rowNum, colNum);
            if(val == null || @com.smartgwt.client.util.JSOHelper::isJavaString(Ljava/lang/Object;)(val) ) return val;
            if(@com.smartgwt.client.util.JSOHelper::isJavaInteger(Ljava/lang/Object;)(val)) return val.@java.lang.Integer::intValue()();
            if(@com.smartgwt.client.util.JSOHelper::isJavaNumber(Ljava/lang/Object;)(val)) return val.@java.lang.Number::floatValue()();
            if(@com.smartgwt.client.util.JSOHelper::isJavaDate(Ljava/lang/Object;)(val)) return @com.smartgwt.client.util.JSOHelper::convertToJavaScriptDate(Ljava/util/Date;)(val);
            $wnd.isc.logWarn('Unrecognized type of value ' + val + ' returned by the CellEditValueFormatter::format');
	    }));
	}-*/;


    /**
     * Method used to convert the value displayed in an editor for some cell in this field into a raw value for saving.
     * @see com.smartgwt.client.docs.Editing Editing overview and related methods
     *
     * @param parser the CellEditValueParser
     */
    public native void setEditValueParser(CellEditValueParser parser) /*-{
	    var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
	    self.parseEditorValue = $debox($entry(function(value, record, rowNum, colNum) {
	        var recordJ = @com.smartgwt.client.widgets.grid.ListGridRecord::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(record);
	        var valueJ = $wnd.SmartGWT.convertToJavaType(value);
	        var val = parser.@com.smartgwt.client.widgets.grid.CellEditValueParser::parse(Ljava/lang/Object;Lcom/smartgwt/client/widgets/grid/ListGridRecord;II)(valueJ, recordJ, rowNum, colNum);
            if(val == null || @com.smartgwt.client.util.JSOHelper::isJavaString(Ljava/lang/Object;)(val) ) return val;
            if(@com.smartgwt.client.util.JSOHelper::isJavaInteger(Ljava/lang/Object;)(val)) return val.@java.lang.Integer::intValue()();
            if(@com.smartgwt.client.util.JSOHelper::isJavaNumber(Ljava/lang/Object;)(val)) return val.@java.lang.Number::floatValue()();
            if(@com.smartgwt.client.util.JSOHelper::isJavaDate(Ljava/lang/Object;)(val)) return @com.smartgwt.client.util.JSOHelper::convertToJavaScriptDate(Ljava/util/Date;)(val);
            $wnd.isc.logWarn('Unrecognized type of value ' + val + ' returned by the CellEditValueParser::parse');
	    }));
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
            self.sortNormalizer = $debox($entry(function(record, fieldName) {
                var recordJ = @com.smartgwt.client.widgets.grid.ListGridRecord::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(record);
                var val = normalizer.@com.smartgwt.client.widgets.grid.SortNormalizer::normalize(Lcom/smartgwt/client/widgets/grid/ListGridRecord;Ljava/lang/String;)(recordJ, fieldName);
                if(val == null || @com.smartgwt.client.util.JSOHelper::isJavaString(Ljava/lang/Object;)(val) ) return val;
                if(@com.smartgwt.client.util.JSOHelper::isJavaInteger(Ljava/lang/Object;)(val)) return val.@java.lang.Integer::intValue()();
                if(@com.smartgwt.client.util.JSOHelper::isJavaNumber(Ljava/lang/Object;)(val)) return val.@java.lang.Number::floatValue()();
                if(@com.smartgwt.client.util.JSOHelper::isJavaDate(Ljava/lang/Object;)(val)) return @com.smartgwt.client.util.JSOHelper::convertToJavaScriptDate(Ljava/util/Date;)(val);
                $wnd.isc.logWarn('Unrecognized type of value ' + val + ' returned by the SortNormalizer::normalize');
            }));
    }-*/;

    /**
     * * HTML to be shown in hovers over cells in the column described by this field.
     *
     * @param hoverCustomizer the hover customizer
     */
    public native void setHoverCustomizer(HoverCustomizer hoverCustomizer) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.hoverHTML = $debox($entry(function(record, value, rowNum, colNum, grid) {
            var recordJ = @com.smartgwt.client.widgets.grid.ListGridRecord::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(record);            
            var valueJ = $wnd.SmartGWT.convertToJavaType(value);
            return hoverCustomizer.@com.smartgwt.client.widgets.grid.HoverCustomizer::hoverHTML(Ljava/lang/Object;Lcom/smartgwt/client/widgets/grid/ListGridRecord;II)(valueJ, recordJ, rowNum, colNum);
        }));
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
        return EnumUtil.getEnum(Alignment.values(), getAttribute("align"));
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

    /**
     * Control the list grid fields header wrap properties
     *
     * @param wrap true to wrap
     */
    public void setWrap(boolean wrap) {
        setAttribute("wrap", wrap);
    }

    /**
     * Marks a field as initially hidden for this ListGrid.  The user will be able to show the field via a context menu (unless canPickFields has been set false).
     * <p><br>
     * To mark a field as completely hidden (not shown to a user at all, in any component), set {@link com.smartgwt.client.data.DataSourceField#setHidden(Boolean) dataSourceField.hidden} instead.
     *
     * @param hidden true to mark the field as initially hidden
     */
    public void setHidden(boolean hidden) {
        setAttribute("showIf", hidden ? "false" : "true");
    }

    public void setImgDir(String imgDir) {
        setAttribute("imgDir", imgDir);
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
     * <p><br>
     * <b>Note>: When you supply a custom FormItem via setEditorType(), you're really providing properties which are then used to
     * create multiple FormItems (eg, in grids, forms and trees) and there's an underlying limitation here where event handlers have
     * to be written to dynamically receive the actual FormItem rather than relying on "this" (because there's more than one "this").
     *
     * @param editorType the editor type
     */
    public void setEditorType(FormItem editorType) {
        //only set the editorType attribute if the passed editorType is a concrete subclass of FormItem
        if(!editorType.getClass().getName().equals(FormItem.class.getName())) {
            String fiEditorType = editorType.getAttribute("editorType");
            //fallback to type if editorType is not specified
            if(fiEditorType == null) fiEditorType = editorType.getType();
            if (fiEditorType != null) setAttribute("editorType", fiEditorType);
        }
        JavaScriptObject editorConfig = editorType.getConfig();
        setAttribute("editorProperties", editorConfig);
    }

    /**
     * If this ListGrid is showing a filter row, this property can be used to specify the form item class to use
     * for the filter form item associated with this field (Only used if this field is not canFilter:false).
     * <br>
     * <p/>
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
     * If this ListGrid is showing a filter row (showFilterEditor : true), this property can be used to specify properties for the
     * appropriate filter form item.
     *
     * @param filterEditorProperties the filter editor properties
     */
    public void setFilterEditorProperties(FormItem filterEditorProperties) {
        JavaScriptObject editorConfig = filterEditorProperties.getConfig();
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
     * <p/>
     * <p/>
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
     * {@link com.smartgwt.client.widgets.form.fields.PickList#getOptionDataSource optionDataSource} for
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
     * {@link com.smartgwt.client.widgets.form.fields.PickList#getOptionDataSource optionDataSource} property to be used to provide paged valueMaps during inline
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
     * <p/>
     * Use 'showIf:"false"' to set a ListGrid field to initially hidden.
     * <p/>
     * Note that explicit calls to grid.showField() or hideField() will wipe out the showIf expression, as will the end
     * user showing and hiding columns via the header contextMenu.
     * <p/>
     * Also note that fields marked as detail:true will be hidden by default even if ListGrid.showDetailFields is true. To show detail fields inherited from a DataSource, include an explicit field definition for the field and set this property to return true.
     *
     * @param showIf showIf criteria
     */
    public native void setShowIfCondition(ListGridFieldIfFunction showIf) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.showIf = $debox($entry(function(grid, field, fieldNum) {
            var gridJ = @com.smartgwt.client.widgets.grid.ListGrid::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(grid);
            var fieldJ = @com.smartgwt.client.widgets.grid.ListGridField::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(field);        
            return showIf.@com.smartgwt.client.widgets.grid.ListGridFieldIfFunction::execute(Lcom/smartgwt/client/widgets/grid/ListGrid;Lcom/smartgwt/client/widgets/grid/ListGridField;I)(gridJ, fieldJ, fieldNum);
        }));
    }-*/;

    /**
     * Specifies the default sorting direction for this column. If specified on the {@link com.smartgwt.client.widgets.grid.ListGrid#getSortField sortField} for the listGrid, sorting occurs automatically, otherwise this will be the default direction when the user clicks the field header, or calls {@link com.smartgwt.client.widgets.grid.ListGrid#sort} without specifying an explicit sort direction. <P> Overrides ListGrid.sortDirection
     *
     * @param sortDirection sortDirection Default value is null
     */
    public void setSortDirection(SortDirection sortDirection) {
        if (sortDirection == null) {
            setAttribute("sortDirection", (Boolean) null);
        } else {
            setAttribute("sortDirection", sortDirection == SortDirection.ASCENDING);
        }
    }

    /**
     * Specifies the default sorting direction for this column. If specified on the {@link com.smartgwt.client.widgets.grid.ListGrid#getSortField sortField} for the listGrid, sorting occurs automatically, otherwise this will be the default direction when the user clicks the field header, or calls {@link com.smartgwt.client.widgets.grid.ListGrid#sort} without specifying an explicit sort direction. <P> Overrides ListGrid.sortDirection
     *
     * @return SortDirection
     */
    public SortDirection getSortDirection() {
        Boolean sortDir = getAttributeAsBoolean("sortDirection");
        if (sortDir == null) return null;
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
     */
    public DSRequest getOptionFilterContext() {
        JavaScriptObject jsObj = getAttributeAsJavaScriptObject("optionFilterContext");
        return jsObj == null ? null : new DSRequest(jsObj);
    }

    /**
     * Add a cellSaved handler.
     * <p/>
     * Callback fired when field changes value as the result of a cell edit.  Fired only on&#010  successful save of edit, when the new value doesn't match the value before editing.<br>&#010  <p>&#010  Same signature as {@link com.smartgwt.client.widgets.grid.ListGrid#addCellChangedHandler}, but defined on a per-field basis.&#010&#010
     *
     * @param handler the cellSaved handler
     * @return {@link com.google.gwt.event.shared.HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addCellSavedHandler(com.smartgwt.client.widgets.grid.events.CellSavedHandler handler) {
        if (getHandlerCount(com.smartgwt.client.widgets.grid.events.CellSavedEvent.getType()) == 0)
            setupCellSavedEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.grid.events.CellSavedEvent.getType());
    }

    private native void setupCellSavedEvent() /*-{
        var obj = null;
            obj = this.@com.smartgwt.client.core.DataClass::getJsObj()();
            var selfJ = this;
            obj.cellChanged = $debox($entry(function(){
                var param = {"record" : arguments[0], "newValue" : arguments[1], "oldValue" : arguments[2], "rowNum" : arguments[3], "colNum" : arguments[4]};
                var event = @com.smartgwt.client.widgets.grid.events.CellSavedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                selfJ.@com.smartgwt.client.core.DataClass::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            }));
    }-*/;

    /**
     * Add a change handler.
     * <p>
     * If this field is editable, any {@link com.smartgwt.client.widgets.form.fields.FormItem#addChangeHandler change} handler
     * specified on the ListGridField will be passed onto the editors for this field. <P> Note that if {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getCanToggle canToggle} is true, the user may change the value of a
     * boolean field without going into edit mode by single clicking on the field. In this  case the {@link
     * com.smartgwt.client.widgets.grid.ListGridField#addChangeHandler ListGridField.change} and {@link
     * com.smartgwt.client.widgets.grid.ListGridField#addChangedHandler ListGridField.changed} handlers will fire but the
     * <code>form</code> and <code>item</code> parameters will be null.
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
            obj.change = $debox($entry(function(){
                var param = {"form" : arguments[0], "item" : arguments[1], "value" : arguments[2], "oldValue" : arguments[3], "sourceJSO" : this};
                var event = @com.smartgwt.client.widgets.grid.events.ChangeEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                selfJ.@com.smartgwt.client.core.DataClass::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                return !ret;
            }));
   }-*/;
    /**
     * Add a changed handler.
     * <p>
     * If this field is editable, any {@link com.smartgwt.client.widgets.form.fields.FormItem#addChangedHandler changed}
     * handler specified on the ListGridField will be passed onto the editors for this field. Note that if {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getCanToggle canToggle} is true, the user may change the value of a
     * boolean field without going into edit mode by single clicking on the field. In this  case the {@link
     * com.smartgwt.client.widgets.grid.ListGridField#addChangeHandler ListGridField.change} and {@link
     * com.smartgwt.client.widgets.grid.ListGridField#addChangedHandler ListGridField.changed} handlers will fire but the
     * <code>form</code> and <code>item</code> parameters will be null.
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
            obj.changed = $entry(function(){
                var param = {"form" : arguments[0], "item" : arguments[1], "value" : arguments[2], "sourceJSO" : this};
                var event = @com.smartgwt.client.widgets.grid.events.ChangedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                selfJ.@com.smartgwt.client.core.DataClass::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            });
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
        self.getGroupTitle = $debox($entry(function(groupValue, groupNode, field, fieldName, grid) {
            var groupValueJ =  $wnd.SmartGWT.convertToJavaType(groupValue);
            var groupNodeJ = @com.smartgwt.client.widgets.grid.GroupNode::new(Lcom/google/gwt/core/client/JavaScriptObject;)(groupNode);
            var fieldJ = @com.smartgwt.client.widgets.grid.ListGridField::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(field);
            var gridJ = @com.smartgwt.client.widgets.grid.ListGrid::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(grid);
            return groupTitleRenderer.@com.smartgwt.client.widgets.grid.GroupTitleRenderer::getGroupTitle(Ljava/lang/Object;Lcom/smartgwt/client/widgets/grid/GroupNode;Lcom/smartgwt/client/widgets/grid/ListGridField;Ljava/lang/String;Lcom/smartgwt/client/widgets/grid/ListGrid;)(groupValueJ, groupNodeJ, fieldJ, fieldName, gridJ);
        }));
    }-*/;

    /**
     * Function that returns the value which records should be grouped by.
     * <p/>
     * All records that for which getGroupValue() returns the same value appear in the same group. Default is the result
     * of ListGrid.getCellValue().
     * <p/>
     * While any type of value may be returned, avoiding the use of string values may result in improved performance.
     * In this case, {@link GroupTitleRenderer#getGroupTitle(Object, GroupNode, ListGridField, String, ListGrid)}  may be implemented to map a numeric group value into a
     * legible string.
     *
     * @param groupValueFunction the group value function
     */
    public native void setGroupValueFunction(GroupValueFunction groupValueFunction) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.getGroupValue = $debox($entry(function(value, record, field, fieldName, grid) {
            var valueJ =  $wnd.SmartGWT.convertToJavaType(value);
            var recordJ = @com.smartgwt.client.widgets.grid.ListGridRecord::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(record);
            var fieldJ = @com.smartgwt.client.widgets.grid.ListGridField::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(field);
            var gridJ = @com.smartgwt.client.widgets.grid.ListGrid::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(grid);
            var val = groupValueFunction.@com.smartgwt.client.widgets.grid.GroupValueFunction::getGroupValue(Ljava/lang/Object;Lcom/smartgwt/client/widgets/grid/ListGridRecord;Lcom/smartgwt/client/widgets/grid/ListGridField;Ljava/lang/String;Lcom/smartgwt/client/widgets/grid/ListGrid;)(valueJ, recordJ, fieldJ, fieldName, gridJ);
            if(val == null || @com.smartgwt.client.util.JSOHelper::isJavaString(Ljava/lang/Object;)(val) ) return val;
            if(@com.smartgwt.client.util.JSOHelper::isJavaInteger(Ljava/lang/Object;)(val)) return val.@java.lang.Integer::intValue()();
            if(@com.smartgwt.client.util.JSOHelper::isJavaNumber(Ljava/lang/Object;)(val)) return val.@java.lang.Number::floatValue()();
            if(@com.smartgwt.client.util.JSOHelper::isJavaDate(Ljava/lang/Object;)(val)) return @com.smartgwt.client.util.JSOHelper::convertToJavaScriptDate(Ljava/util/Date;)(val);
        }));
    }-*/;

    /**
     * This function method will be called from ListGrid.getEditorValueMap() and the resulting valueMap will be used instead of any static specified valueMap for the field.
     *
     * @param editorValueMapFunction the editor value map function
     */
    public native void setEditorValueMapFunction(EditorValueMapFunction editorValueMapFunction) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.getEditorValueMap = $entry(function(values, field, grid) {
            var valuesJ =  @com.smartgwt.client.util.JSOHelper::convertToMap(Lcom/google/gwt/core/client/JavaScriptObject;)(values);
            var fieldJ = @com.smartgwt.client.widgets.grid.ListGridField::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(field);
            var gridJ = @com.smartgwt.client.widgets.grid.ListGrid::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(grid);
            var map = editorValueMapFunction.@com.smartgwt.client.widgets.grid.EditorValueMapFunction::getEditorValueMap(Ljava/util/Map;Lcom/smartgwt/client/widgets/grid/ListGridField;Lcom/smartgwt/client/widgets/grid/ListGrid;)(valuesJ, fieldJ, gridJ);
            return @com.smartgwt.client.util.JSOHelper::convertMapToJavascriptObject(Ljava/util/Map;)(map);
        });
    }-*/;

    /**
     * Set the properties of the header button used for this field.
     *
     * @param buttonProperties the header button properties
     */
    public void setHeaderButtonProperties(Button buttonProperties) {
        buttonProperties.setConfigOnly(true);
        JSOHelper.addProperties(getJsObj(), buttonProperties.getConfig());
    }

    /**
     * If {@link com.smartgwt.client.widgets.grid.ListGrid#getShowGridSummary showGridSummary} or {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getShowGroupSummary showGroupSummary} is true,  this attribute can be used to
     * specify an explicit {@link com.smartgwt.client.widgets.grid.SummaryFunction} for calculating the summary value to display.
     *
     * @param summaryFunction summaryFunction Default value is null
     */
    public void setSummaryFunction(SummaryFunctionType summaryFunction) {
        setAttribute("summaryFunction", summaryFunction);
    }

    /**
     * If {@link com.smartgwt.client.widgets.grid.ListGrid#getShowGridSummary showGridSummary} or {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getShowGroupSummary showGroupSummary} is true,  this attribute can be used to
     * specify an explicit {@link com.smartgwt.client.widgets.grid.SummaryFunction} for calculating the summary value to display.
     *
     *
     * @return SummaryFunctionType
     */
    public SummaryFunctionType getSummaryFunction()  {
        return EnumUtil.getEnum(SummaryFunctionType.values(), getAttribute("summaryFunction"));
    }

    /**
     * If {@link com.smartgwt.client.widgets.grid.ListGrid#getShowGridSummary showGridSummary} or {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getShowGroupSummary showGroupSummary} is true,  this attribute can be used to
     * specify an explicit {@link com.smartgwt.client.widgets.grid.SummaryFunction} for calculating the summary value to display.
     *
     * @param summaryFunction summaryFunction Default value is null
     */
    public native void setSummaryFunction(SummaryFunction summaryFunction) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.summaryFunction = $debox($entry(function(records, field) {
            var recordsJ =  @com.smartgwt.client.data.Record::convertToRecordArray(Lcom/google/gwt/core/client/JavaScriptObject;)(records);
            var fieldJ = @com.smartgwt.client.widgets.grid.ListGridField::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(field);
            var val = summaryFunction.@com.smartgwt.client.widgets.grid.SummaryFunction::getSummaryValue([Lcom/smartgwt/client/data/Record;Lcom/smartgwt/client/widgets/grid/ListGridField;)(recordsJ, fieldJ);
            if(val == null || $wnd.isc.isA.String(val) || $wnd.isc.isA.Number(val)) return val;
            if(@com.smartgwt.client.util.JSOHelper::isJavaNumber(Ljava/lang/Object;)(val)) return val.@java.lang.Number::doubleValue()();
            if(@com.smartgwt.client.util.JSOHelper::isJavaDate(Ljava/lang/Object;)(val)) return @com.smartgwt.client.util.JSOHelper::convertToJavaScriptDate(Ljava/util/Date;)(val);
            $wnd.isc.logWarn('Unrecognized type of value ' + val + ' returned by the summaryFunction');
        }));
    }-*/;

    /**
     * Only applies to fields of type <code>"summary"</code>. Fields of this type will display a calculated value based on the
     * other field values within the current record. <P> This attribute specifies how the summary field value will be
     * calculated. See  {@link com.smartgwt.client.types.RecordSummaryFunctionType} for valid options. <P> A subset of the
     * ListGrid's fields will be passed to the RecordSummaryFunction.  Which fields to include is determined based on {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getIncludeInRecordSummary includeInRecordSummary} <P> If {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getShowGridSummary showGridSummary} or {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getShowGroupSummary showGroupSummary} is true, this field's value in the
     * summary row[s] will still be calculated by calling this method. In this case, the record object passed in will contain
     * summary values for each field. If custom handling is required for this case, it may be detected by checking the record
     * object's {@link com.smartgwt.client.widgets.grid.ListGridRecord#getIsGroupSummary isGroupSummary} and {@link
     * com.smartgwt.client.widgets.grid.ListGridRecord#getIsGridSummary isGridSummary} attributes.
     *
     * @param recordSummaryFunction recordSummaryFunction Default value is null
     */
    public void setRecordSummaryFunction(RecordSummaryFunctionType recordSummaryFunction) {
        setAttribute("recordSummaryFunction", recordSummaryFunction.getValue());
    }

    /**
     * Only applies to fields of type <code>"summary"</code>. Fields of this type will display a calculated value based on the
     * other field values within the current record. <P> This attribute specifies how the summary field value will be
     * calculated. See  {@link com.smartgwt.client.types.RecordSummaryFunctionType} for valid options. <P> A subset of the
     * ListGrid's fields will be passed to the RecordSummaryFunction.  Which fields to include is determined based on {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getIncludeInRecordSummary includeInRecordSummary} <P> If {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getShowGridSummary showGridSummary} or {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getShowGroupSummary showGroupSummary} is true, this field's value in the
     * summary row[s] will still be calculated by calling this method. In this case, the record object passed in will contain
     * summary values for each field. If custom handling is required for this case, it may be detected by checking the record
     * object's {@link com.smartgwt.client.widgets.grid.ListGridRecord#getIsGroupSummary isGroupSummary} and {@link
     * com.smartgwt.client.widgets.grid.ListGridRecord#getIsGridSummary isGridSummary} attributes.
     *
     * @param recordSummaryFunction recordSummaryFunction Default value is null
     */
    public native void setRecordSummaryFunction(RecordSummaryFunction recordSummaryFunction) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.recordSummaryFunction = $debox($entry(function(record, fields, summaryField) {
            var recordJ =  @com.smartgwt.client.data.Record::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(record);
            var fieldsJ = @com.smartgwt.client.widgets.grid.ListGrid::convertToListGridFieldArray(Lcom/google/gwt/core/client/JavaScriptObject;)(fields);
            var summaryFieldJ = @com.smartgwt.client.widgets.grid.ListGridField::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(summaryField);
            var val = recordSummaryFunction.@com.smartgwt.client.widgets.grid.RecordSummaryFunction::getSummaryValue(Lcom/smartgwt/client/data/Record;[Lcom/smartgwt/client/widgets/grid/ListGridField;Lcom/smartgwt/client/widgets/grid/ListGridField;)(recordJ, fieldsJ, summaryFieldJ);
            if(val == null || @com.smartgwt.client.util.JSOHelper::isJavaString(Ljava/lang/Object;)(val) ) return val;
            if(@com.smartgwt.client.util.JSOHelper::isJavaInteger(Ljava/lang/Object;)(val)) return val.@java.lang.Integer::intValue()();
            if(@com.smartgwt.client.util.JSOHelper::isJavaNumber(Ljava/lang/Object;)(val)) return val.@java.lang.Number::floatValue()();
            if(@com.smartgwt.client.util.JSOHelper::isJavaDate(Ljava/lang/Object;)(val)) return @com.smartgwt.client.util.JSOHelper::convertToJavaScriptDate(Ljava/util/Date;)(val);
            $wnd.isc.logWarn('Unrecognized type of value ' + val + ' returned by the RecordSummaryFunction::getSummaryValue');
        }));
    }-*/;

    /**
     * Only applies to fields of type <code>"summary"</code>. Fields of this type will display a calculated value based on the
     * other field values within the current record. <P> This attribute specifies how the summary field value will be
     * calculated. See  {@link com.smartgwt.client.types.RecordSummaryFunctionType} for valid options. <P> A subset of the
     * ListGrid's fields will be passed to the RecordSummaryFunction.  Which fields to include is determined based on {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getIncludeInRecordSummary includeInRecordSummary} <P> If {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getShowGridSummary showGridSummary} or {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getShowGroupSummary showGroupSummary} is true, this field's value in the
     * summary row[s] will still be calculated by calling this method. In this case, the record object passed in will contain
     * summary values for each field. If custom handling is required for this case, it may be detected by checking the record
     * object's {@link com.smartgwt.client.widgets.grid.ListGridRecord#getIsGroupSummary isGroupSummary} and {@link
     * com.smartgwt.client.widgets.grid.ListGridRecord#getIsGridSummary isGridSummary} attributes.
     *
     *
     * @return RecordSummaryFunction
     */
    public RecordSummaryFunctionType getRecordSummaryFunction()  {
        return EnumUtil.getEnum(RecordSummaryFunctionType.values(), getAttribute("recordSummaryFunction"));
    }

}



