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
 
package com.smartgwt.client.widgets.grid;


import com.smartgwt.client.event.*;
import com.smartgwt.client.core.*;
import com.smartgwt.client.types.*;
import com.smartgwt.client.data.*;
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

import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;
import com.smartgwt.client.util.*;
import com.smartgwt.client.util.events.*;
import com.smartgwt.client.util.workflow.*;
import com.google.gwt.event.shared.*;
import com.google.gwt.event.shared.HasHandlers;

/**
 * An ordinary JavaScript object containing properties that configures the display of and interaction with the columns of a
 * {@link com.smartgwt.client.widgets.grid.ListGrid}.
 * @see com.smartgwt.client.widgets.grid.ListGrid#getFields
 * @see com.smartgwt.client.widgets.grid.ListGrid#setFields
 */
@BeanFactory.FrameworkClass
public class ListGridField extends DBCField implements com.smartgwt.client.widgets.grid.events.HasCellSavedHandlers,  com.smartgwt.client.widgets.grid.events.HasChangedHandlers,  com.smartgwt.client.widgets.grid.events.HasChangeHandlers, com.smartgwt.client.widgets.grid.events.HasEditorEnterHandlers, com.smartgwt.client.widgets.grid.events.HasEditorExitHandlers, com.smartgwt.client.widgets.grid.events.HasRecordClickHandlers, com.smartgwt.client.widgets.grid.events.HasValueIconClickHandlers {

    public static ListGridField getOrCreateRef(JavaScriptObject jsObj) {
        if (jsObj == null) return null;

        final RefDataClass existingObj = RefDataClass.getRef(jsObj);

        if (existingObj instanceof ListGridField) {
            existingObj.setJsObj(jsObj);
            return (ListGridField)existingObj;
        } else

        {
            return new ListGridField(jsObj);
        }
    }
        


    public ListGridField(){
        
    }

    public ListGridField(JavaScriptObject jsObj){
        
        setJavaScriptObject(jsObj);
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
     * Field-level setting for {@link com.smartgwt.client.widgets.grid.ListGrid#getAllowFilterExpressions
     * ListGrid.allowFilterExpressions}:true - controls whether search  expressions can be entered directly into the filter
     * item for this field.  You can also have parsing of the expression remove the operator symbol and apply it to an  {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getAllowFilterOperators icon} in the editor., <P> This attribute can also be
     * set at the {@link com.smartgwt.client.widgets.grid.ListGrid#getAllowFilterExpressions ListGrid level}.
     *
     * @param allowFilterExpressions New allowFilterExpressions value. Default value is null
     * @see com.smartgwt.client.docs.AdvancedFilter AdvancedFilter overview and related methods
     */
    public void setAllowFilterExpressions(Boolean allowFilterExpressions) {
        setAttribute("allowFilterExpressions", allowFilterExpressions);
    }

    /**
     * Field-level setting for {@link com.smartgwt.client.widgets.grid.ListGrid#getAllowFilterExpressions
     * ListGrid.allowFilterExpressions}:true - controls whether search  expressions can be entered directly into the filter
     * item for this field.  You can also have parsing of the expression remove the operator symbol and apply it to an  {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getAllowFilterOperators icon} in the editor., <P> This attribute can also be
     * set at the {@link com.smartgwt.client.widgets.grid.ListGrid#getAllowFilterExpressions ListGrid level}.
     *
     * @return Current allowFilterExpressions value. Default value is null
     * @see com.smartgwt.client.docs.AdvancedFilter AdvancedFilter overview and related methods
     */
    public Boolean getAllowFilterExpressions()  {
        return getAttributeAsBoolean("allowFilterExpressions", true);
    }
    

    /**
     * Per-field setting for {@link com.smartgwt.client.widgets.grid.ListGrid#getAllowFilterOperators
     * ListGrid.allowFilterOperators}.  Can be used to enable the filter operators UI for a particular field if the
     * ListGrid-level setting is not enabled, or to disable filter operators for a particular field if the ListGrid-level
     * setting is enabled.
     *
     * @param allowFilterOperators New allowFilterOperators value. Default value is null
     */
    public void setAllowFilterOperators(Boolean allowFilterOperators) {
        setAttribute("allowFilterOperators", allowFilterOperators);
    }

    /**
     * Per-field setting for {@link com.smartgwt.client.widgets.grid.ListGrid#getAllowFilterOperators
     * ListGrid.allowFilterOperators}.  Can be used to enable the filter operators UI for a particular field if the
     * ListGrid-level setting is not enabled, or to disable filter operators for a particular field if the ListGrid-level
     * setting is enabled.
     *
     * @return Current allowFilterOperators value. Default value is null
     */
    public Boolean getAllowFilterOperators()  {
        return getAttributeAsBoolean("allowFilterOperators", true);
    }
    

    /**
     * Per-field setting for {@link com.smartgwt.client.widgets.grid.ListGrid#getAlwaysShowOperatorIcon
     * ListGrid.alwaysShowOperatorIcon}. Can be used to force a particular field to always show it's {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getOperatorIcon operatorIcon}, even if it has no  filter-value, or is using
     * the default {@link com.smartgwt.client.widgets.grid.ListGridField#getFilterOperator search operator}.
     *
     * @param alwaysShowOperatorIcon New alwaysShowOperatorIcon value. Default value is null
     */
    public void setAlwaysShowOperatorIcon(Boolean alwaysShowOperatorIcon) {
        setAttribute("alwaysShowOperatorIcon", alwaysShowOperatorIcon);
    }

    /**
     * Per-field setting for {@link com.smartgwt.client.widgets.grid.ListGrid#getAlwaysShowOperatorIcon
     * ListGrid.alwaysShowOperatorIcon}. Can be used to force a particular field to always show it's {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getOperatorIcon operatorIcon}, even if it has no  filter-value, or is using
     * the default {@link com.smartgwt.client.widgets.grid.ListGridField#getFilterOperator search operator}.
     *
     * @return Current alwaysShowOperatorIcon value. Default value is null
     */
    public Boolean getAlwaysShowOperatorIcon()  {
        return getAttributeAsBoolean("alwaysShowOperatorIcon", true);
    }
    

    /**
     * If {@link com.smartgwt.client.widgets.grid.ListGridField#getUserFormula userFormula} is set for this field, and this
     * grid is showing {@link com.smartgwt.client.widgets.grid.ListGrid#getShowGroupSummary group summaries} or a {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getShowGridSummary grid summary}, this property determines what field value
     * should be present in those summary rows. Should the field apply the user-formula to the calculated summary row, or
     * should it apply a standard grid or group summary to the user-formula values displayed in the grid? <P> Default behavior
     * may be specified at the grid level via {@link com.smartgwt.client.widgets.grid.ListGrid#getApplyFormulaAfterSummary
     * ListGrid.applyFormulaAfterSummary}
     *
     * @param applyAfterSummary New applyAfterSummary value. Default value is null
     */
    public void setApplyAfterSummary(Boolean applyAfterSummary) {
        setAttribute("applyAfterSummary", applyAfterSummary);
    }

    /**
     * If {@link com.smartgwt.client.widgets.grid.ListGridField#getUserFormula userFormula} is set for this field, and this
     * grid is showing {@link com.smartgwt.client.widgets.grid.ListGrid#getShowGroupSummary group summaries} or a {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getShowGridSummary grid summary}, this property determines what field value
     * should be present in those summary rows. Should the field apply the user-formula to the calculated summary row, or
     * should it apply a standard grid or group summary to the user-formula values displayed in the grid? <P> Default behavior
     * may be specified at the grid level via {@link com.smartgwt.client.widgets.grid.ListGrid#getApplyFormulaAfterSummary
     * ListGrid.applyFormulaAfterSummary}
     *
     * @return Current applyAfterSummary value. Default value is null
     */
    public Boolean getApplyAfterSummary()  {
        return getAttributeAsBoolean("applyAfterSummary", true);
    }
    

    /**
     * What to do when a user hits arrow key while editing this field?<br> See {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getArrowKeyEditAction ListGrid.getArrowKeyEditAction()}.
     *
     * @param arrowKeyEditAction New arrowKeyEditAction value. Default value is null
     * @see com.smartgwt.client.docs.Editing Editing overview and related methods
     */
    public void setArrowKeyEditAction(ArrowKeyEditAction arrowKeyEditAction) {
        setAttribute("arrowKeyEditAction", arrowKeyEditAction == null ? null : arrowKeyEditAction.getValue());
    }

    /**
     * What to do when a user hits arrow key while editing this field?<br> See {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getArrowKeyEditAction ListGrid.getArrowKeyEditAction()}.
     *
     * @return Current arrowKeyEditAction value. Default value is null
     * @see com.smartgwt.client.docs.Editing Editing overview and related methods
     */
    public ArrowKeyEditAction getArrowKeyEditAction()  {
        return EnumUtil.getEnum(ArrowKeyEditAction.values(), getAttribute("arrowKeyEditAction"));
    }
    

    /**
     * Whether to allow browser autoComplete when editing this field. <p> If unset, defaults to listGrid.autoComplete
     *
     * @param autoComplete New autoComplete value. Default value is null
     * @see com.smartgwt.client.widgets.grid.ListGrid#setAutoComplete
     */
    public void setAutoComplete(AutoComplete autoComplete) {
        setAttribute("autoComplete", autoComplete == null ? null : autoComplete.getValue());
    }

    /**
     * Whether to allow browser autoComplete when editing this field. <p> If unset, defaults to listGrid.autoComplete
     *
     * @return Current autoComplete value. Default value is null
     * @see com.smartgwt.client.widgets.grid.ListGrid#getAutoComplete
     */
    public AutoComplete getAutoComplete()  {
        return EnumUtil.getEnum(AutoComplete.values(), getAttribute("autoComplete"));
    }
    

    /**
     * If true, automatically fetches records and derives a valueMap from {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getOptionDataSource optionDataSource}. <p> Same as {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getAutoFetchDisplayMap ListGrid.autoFetchDisplayMap}, but defined on a
     * per-field basis.
     *
     * @param autoFetchDisplayMap New autoFetchDisplayMap value. Default value is null
     * @see com.smartgwt.client.widgets.grid.ListGrid#setAutoFetchDisplayMap
     */
    public void setAutoFetchDisplayMap(Boolean autoFetchDisplayMap) {
        setAttribute("autoFetchDisplayMap", autoFetchDisplayMap);
    }

    /**
     * If true, automatically fetches records and derives a valueMap from {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getOptionDataSource optionDataSource}. <p> Same as {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getAutoFetchDisplayMap ListGrid.autoFetchDisplayMap}, but defined on a
     * per-field basis.
     *
     * @return Current autoFetchDisplayMap value. Default value is null
     * @see com.smartgwt.client.widgets.grid.ListGrid#getAutoFetchDisplayMap
     */
    public Boolean getAutoFetchDisplayMap()  {
        return getAttributeAsBoolean("autoFetchDisplayMap", true);
    }
    

    /**
     * Should this listGrid field autofit its width to either titles or content? <P> This overrides the {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getAutoFitFieldWidths ListGrid.autoFitFieldWidths} attribute on a per-field
     * basis. <P> Note that if {@link com.smartgwt.client.widgets.grid.ListGrid#getShowRecordComponents showing record
     * components}, per-cell record components are not taken into account when determining the size for column auto fit. The
     * default {@link com.smartgwt.client.widgets.grid.ListGrid#getDefaultFieldWidth ListGrid.getDefaultFieldWidth()}
     * implementation looks at cell content only. We typically recommend that, for fields showing record-components,  {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getAutoFitWidth autoFitWidth} and {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getCanAutoFitWidth canAutoFitWidth} be disabled, or if  the record
     * components are of a predictable size, a {@link com.smartgwt.client.widgets.grid.ListGridField#getDefaultWidth
     * defaultWidth} be specified.<br> This is particularly pertinent where {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getRecordComponentPosition ListGrid.recordComponentPosition} is set to
     * "within", in which case cells' content is often empty or completely covered by record-components.
     *
     * @param autoFitWidth New autoFitWidth value. Default value is null
     * @see com.smartgwt.client.widgets.grid.ListGrid#setAutoFitDateFields
     * @see com.smartgwt.client.widgets.grid.ListGrid#setAutoFitTimeFields
     */
    public void setAutoFitWidth(Boolean autoFitWidth) {
        setAttribute("autoFitWidth", autoFitWidth);
    }

    /**
     * Should this listGrid field autofit its width to either titles or content? <P> This overrides the {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getAutoFitFieldWidths ListGrid.autoFitFieldWidths} attribute on a per-field
     * basis. <P> Note that if {@link com.smartgwt.client.widgets.grid.ListGrid#getShowRecordComponents showing record
     * components}, per-cell record components are not taken into account when determining the size for column auto fit. The
     * default {@link com.smartgwt.client.widgets.grid.ListGrid#getDefaultFieldWidth ListGrid.getDefaultFieldWidth()}
     * implementation looks at cell content only. We typically recommend that, for fields showing record-components,  {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getAutoFitWidth autoFitWidth} and {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getCanAutoFitWidth canAutoFitWidth} be disabled, or if  the record
     * components are of a predictable size, a {@link com.smartgwt.client.widgets.grid.ListGridField#getDefaultWidth
     * defaultWidth} be specified.<br> This is particularly pertinent where {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getRecordComponentPosition ListGrid.recordComponentPosition} is set to
     * "within", in which case cells' content is often empty or completely covered by record-components.
     *
     * @return Current autoFitWidth value. Default value is null
     * @see com.smartgwt.client.widgets.grid.ListGrid#getAutoFitDateFields
     * @see com.smartgwt.client.widgets.grid.ListGrid#getAutoFitTimeFields
     */
    public Boolean getAutoFitWidth()  {
        return getAttributeAsBoolean("autoFitWidth", true);
    }
    

    /**
     * When a user requests column autofitting via the {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getHeaderContextMenuItems header contextMenu} or via a {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getHeaderAutoFitEvent mouse gesture}, what autofit approach is used. If set,
     * this setting overrides the autoFitWidthApproach specified at the ListGrid level.
     *
     * @param autoFitWidthApproach New autoFitWidthApproach value. Default value is null
     */
    public void setAutoFitWidthApproach(AutoFitWidthApproach autoFitWidthApproach) {
        setAttribute("autoFitWidthApproach", autoFitWidthApproach == null ? null : autoFitWidthApproach.getValue());
    }

    /**
     * When a user requests column autofitting via the {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getHeaderContextMenuItems header contextMenu} or via a {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getHeaderAutoFitEvent mouse gesture}, what autofit approach is used. If set,
     * this setting overrides the autoFitWidthApproach specified at the ListGrid level.
     *
     * @return Current autoFitWidthApproach value. Default value is null
     */
    public AutoFitWidthApproach getAutoFitWidthApproach()  {
        return EnumUtil.getEnum(AutoFitWidthApproach.values(), getAttribute("autoFitWidthApproach"));
    }
    

    /**
     * Whether this field should be automatically frozen when other fields are frozen.  When true, the field will be
     * automatically frozen to the extreme of the grid.  The automatically generated {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getCheckboxField checkbox}, {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getExpansionField expansion} and {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getRowNumberField rowNumber} fields are examples of fields that specify
     * <code>autoFreeze: true</code>. <P> You can control the position of this field in the array of frozen fields by providing
     * a {@link com.smartgwt.client.widgets.grid.ListGridField#getAutoFreezePosition getAutoFreezePosition()} implementation.
     *
     * @param autoFreeze New autoFreeze value. Default value is null
     * @see com.smartgwt.client.docs.FrozenFields FrozenFields overview and related methods
     */
    public void setAutoFreeze(Boolean autoFreeze) {
        setAttribute("autoFreeze", autoFreeze);
    }

    /**
     * Whether this field should be automatically frozen when other fields are frozen.  When true, the field will be
     * automatically frozen to the extreme of the grid.  The automatically generated {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getCheckboxField checkbox}, {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getExpansionField expansion} and {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getRowNumberField rowNumber} fields are examples of fields that specify
     * <code>autoFreeze: true</code>. <P> You can control the position of this field in the array of frozen fields by providing
     * a {@link com.smartgwt.client.widgets.grid.ListGridField#getAutoFreezePosition getAutoFreezePosition()} implementation.
     *
     * @return Current autoFreeze value. Default value is null
     * @see com.smartgwt.client.docs.FrozenFields FrozenFields overview and related methods
     */
    public Boolean getAutoFreeze()  {
        return getAttributeAsBoolean("autoFreeze", true);
    }
    

    /**
     * Custom base style to apply to all cells in this field instead of {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getBaseStyle ListGrid.baseStyle}  To override the baseStyle at the row level,
     * use  {@link com.smartgwt.client.widgets.grid.ListGrid#getRecordBaseStyleProperty
     * record[listGrid.recordBaseStyleProperty]}  instead.
     *
     * @param baseStyle New baseStyle value. Default value is null
     * @see com.smartgwt.client.widgets.grid.ListGrid#setRecordBaseStyleProperty
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#effects_lf_grid_cells" target="examples">Grid cells Example</a>
     */
    public void setBaseStyle(String baseStyle) {
        setAttribute("baseStyle", baseStyle);
    }

    /**
     * Custom base style to apply to all cells in this field instead of {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getBaseStyle ListGrid.baseStyle}  To override the baseStyle at the row level,
     * use  {@link com.smartgwt.client.widgets.grid.ListGrid#getRecordBaseStyleProperty
     * record[listGrid.recordBaseStyleProperty]}  instead.
     *
     * @return Current baseStyle value. Default value is null
     * @see com.smartgwt.client.widgets.grid.ListGrid#getRecordBaseStyleProperty
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#effects_lf_grid_cells" target="examples">Grid cells Example</a>
     */
    public String getBaseStyle()  {
        return getAttributeAsString("baseStyle");
    }
    

    /**
     * Should the user be allowed to perform one-time autofitting of this field via a header context-menu option? <P> When
     * enabled, the default header context menu for this field will include an item to auto-fit the field and users will be
     * able to autofit the field via the {@link com.smartgwt.client.widgets.grid.ListGrid#getHeaderAutoFitEvent
     * ListGrid.headerAutoFitEvent}. <P> If unset, these behaviors are enabled when {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getCanAutoFitFields ListGrid.canAutoFitFields} is true. <P> If this property
     * is set to false, and {@link com.smartgwt.client.widgets.grid.ListGrid#getCanAutoFitFields ListGrid.canAutoFitFields} is
     * true, this field will be ommitted from auto-fit when the user selects the header menu  option to {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getAutoFitAllText auto fit all fields}. <P> Note - this property governs
     * user-initiated auto-fit only. It has no impact on autoFit set up via {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getAutoFitWidth autoFitWidth} and {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getAutoFitFieldWidths ListGrid.autoFitFieldWidths}. <P> Note that if {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getShowRecordComponents showing record components}, per-cell record components
     * are not taken into account when determining the size for column auto fit. The default {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getDefaultFieldWidth ListGrid.getDefaultFieldWidth()} implementation looks at
     * cell content only. We typically recommend that, for fields showing record-components,  {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getAutoFitWidth autoFitWidth} and {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getCanAutoFitFields ListGrid.canAutoFitFields} be disabled, or if  the record
     * components are of a predictable size, a {@link com.smartgwt.client.widgets.grid.ListGridField#getDefaultWidth
     * defaultWidth} be specified.<br> This is particularly pertinent where {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getRecordComponentPosition ListGrid.recordComponentPosition} is set to
     * "within", in which case cells' content is often empty or completely covered by record-components.
     *
     * @param canAutoFitWidth New canAutoFitWidth value. Default value is null
     * @see com.smartgwt.client.widgets.grid.ListGrid#setAutoFitDateFields
     * @see com.smartgwt.client.widgets.grid.ListGrid#setAutoFitTimeFields
     */
    public void setCanAutoFitWidth(Boolean canAutoFitWidth) {
        setAttribute("canAutoFitWidth", canAutoFitWidth);
    }

    /**
     * Should the user be allowed to perform one-time autofitting of this field via a header context-menu option? <P> When
     * enabled, the default header context menu for this field will include an item to auto-fit the field and users will be
     * able to autofit the field via the {@link com.smartgwt.client.widgets.grid.ListGrid#getHeaderAutoFitEvent
     * ListGrid.headerAutoFitEvent}. <P> If unset, these behaviors are enabled when {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getCanAutoFitFields ListGrid.canAutoFitFields} is true. <P> If this property
     * is set to false, and {@link com.smartgwt.client.widgets.grid.ListGrid#getCanAutoFitFields ListGrid.canAutoFitFields} is
     * true, this field will be ommitted from auto-fit when the user selects the header menu  option to {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getAutoFitAllText auto fit all fields}. <P> Note - this property governs
     * user-initiated auto-fit only. It has no impact on autoFit set up via {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getAutoFitWidth autoFitWidth} and {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getAutoFitFieldWidths ListGrid.autoFitFieldWidths}. <P> Note that if {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getShowRecordComponents showing record components}, per-cell record components
     * are not taken into account when determining the size for column auto fit. The default {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getDefaultFieldWidth ListGrid.getDefaultFieldWidth()} implementation looks at
     * cell content only. We typically recommend that, for fields showing record-components,  {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getAutoFitWidth autoFitWidth} and {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getCanAutoFitFields ListGrid.canAutoFitFields} be disabled, or if  the record
     * components are of a predictable size, a {@link com.smartgwt.client.widgets.grid.ListGridField#getDefaultWidth
     * defaultWidth} be specified.<br> This is particularly pertinent where {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getRecordComponentPosition ListGrid.recordComponentPosition} is set to
     * "within", in which case cells' content is often empty or completely covered by record-components.
     *
     * @return Current canAutoFitWidth value. Default value is null
     * @see com.smartgwt.client.widgets.grid.ListGrid#getAutoFitDateFields
     * @see com.smartgwt.client.widgets.grid.ListGrid#getAutoFitTimeFields
     */
    public Boolean getCanAutoFitWidth()  {
        return getAttributeAsBoolean("canAutoFitWidth", true);
    }
    

    /**
     * Whether this field can be dragResized using the mouse.  If unset, the default behavior is governed by {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getCanResizeFields ListGrid.canResizeFields}.
     *
     * @param canDragResize New canDragResize value. Default value is null
     */
    public void setCanDragResize(Boolean canDragResize) {
        setAttribute("canDragResize", canDragResize);
    }

    /**
     * Whether this field can be dragResized using the mouse.  If unset, the default behavior is governed by {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getCanResizeFields ListGrid.canResizeFields}.
     *
     * @return Current canDragResize value. Default value is null
     */
    public Boolean getCanDragResize()  {
        return getAttributeAsBoolean("canDragResize", true);
    }
    

    /**
     * This property establishes default editability for the field.  May be overridden by setting the 'canEdit' property at the
     * listGrid level. If not explicitly set and this grid is bound to a dataSource, the {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getCanEditFieldAttribute ListGrid.canEditFieldAttribute} may be used to set
     * default editability at the field level. <p> An override of {@link com.smartgwt.client.widgets.grid.ListGrid#canEditCell
     * ListGrid.canEditCell()} can be used for more dynamic control over whether fields can be edited. <P>Note that this
     * property may validly be <code>null</code> as a distinct state from <code>false</code>.  See {@link
     * com.smartgwt.client.widgets.grid.ListGrid#fieldIsEditable ListGrid.fieldIsEditable()} for an API that will always return
     * <code>true</code> or <code>false</code> as to whether editing is possible by default.
     *
     * @param canEdit New canEdit value. Default value is null
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
     * This property establishes default editability for the field.  May be overridden by setting the 'canEdit' property at the
     * listGrid level. If not explicitly set and this grid is bound to a dataSource, the {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getCanEditFieldAttribute ListGrid.canEditFieldAttribute} may be used to set
     * default editability at the field level. <p> An override of {@link com.smartgwt.client.widgets.grid.ListGrid#canEditCell
     * ListGrid.canEditCell()} can be used for more dynamic control over whether fields can be edited. <P>Note that this
     * property may validly be <code>null</code> as a distinct state from <code>false</code>.  See {@link
     * com.smartgwt.client.widgets.grid.ListGrid#fieldIsEditable ListGrid.fieldIsEditable()} for an API that will always return
     * <code>true</code> or <code>false</code> as to whether editing is possible by default.
     *
     * @return Current canEdit value. Default value is null
     * @see com.smartgwt.client.widgets.grid.ListGrid#getCanEdit
     * @see com.smartgwt.client.widgets.grid.ListGrid#getRecordEditProperty
     * @see com.smartgwt.client.widgets.grid.ListGrid#canEditCell
     * @see com.smartgwt.client.docs.Editing Editing overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#grid_editing_disable" target="examples">Disable editing Example</a>
     */
    public Boolean getCanEdit()  {
        return getAttributeAsBoolean("canEdit", true);
    }
    

    /**
     * Can formula be edited from header context menu? Setting attribute to <code>false</code> prevents editing. A
     * <code>null</code> or <code>true</code> value allows editing. <P> Has no effect when {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getCanAddFormulaFields ListGrid.canAddFormulaFields} is <code>false</code>.
     *
     * @param canEditFormula New canEditFormula value. Default value is null
     */
    public void setCanEditFormula(Boolean canEditFormula) {
        setAttribute("canEditFormula", canEditFormula);
    }

    /**
     * Can formula be edited from header context menu? Setting attribute to <code>false</code> prevents editing. A
     * <code>null</code> or <code>true</code> value allows editing. <P> Has no effect when {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getCanAddFormulaFields ListGrid.canAddFormulaFields} is <code>false</code>.
     *
     * @return Current canEditFormula value. Default value is null
     */
    public Boolean getCanEditFormula()  {
        return getAttributeAsBoolean("canEditFormula", true);
    }
    

    /**
     * Can summary be edited from header context menu? Setting attribute to <code>false</code> prevents editing. A
     * <code>null</code> or <code>true</code> value allows editing. <P> Has no effect when {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getCanAddSummaryFields ListGrid.canAddSummaryFields} is <code>false</code>.
     *
     * @param canEditSummary New canEditSummary value. Default value is null
     */
    public void setCanEditSummary(Boolean canEditSummary) {
        setAttribute("canEditSummary", canEditSummary);
    }

    /**
     * Can summary be edited from header context menu? Setting attribute to <code>false</code> prevents editing. A
     * <code>null</code> or <code>true</code> value allows editing. <P> Has no effect when {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getCanAddSummaryFields ListGrid.canAddSummaryFields} is <code>false</code>.
     *
     * @return Current canEditSummary value. Default value is null
     */
    public Boolean getCanEditSummary()  {
        return getAttributeAsBoolean("canEditSummary", true);
    }
    

    /**
     * Dictates whether the data in this field be exported.  Explicitly set this  to false to prevent exporting.  Has no effect
     * if the underlying  {@link com.smartgwt.client.data.DataSourceField#getCanExport dataSourceField} is explicitly set to 
     * canExport: false.
     *
     * @param canExport New canExport value. Default value is null
     */
    public void setCanExport(Boolean canExport) {
        setAttribute("canExport", canExport);
    }

    /**
     * Dictates whether the data in this field be exported.  Explicitly set this  to false to prevent exporting.  Has no effect
     * if the underlying  {@link com.smartgwt.client.data.DataSourceField#getCanExport dataSourceField} is explicitly set to 
     * canExport: false.
     *
     * @return Current canExport value. Default value is null
     */
    public Boolean getCanExport()  {
        return getAttributeAsBoolean("canExport", true);
    }
    

    /**
     * If showing a filter row for this ListGrid, should the filter criteria for this      field be editable
     *
     * @param canFilter New canFilter value. Default value is null
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#grid_sortfilter_disable_filter" target="examples">Disable filter Example</a>
     */
    public void setCanFilter(Boolean canFilter) {
        setAttribute("canFilter", canFilter);
    }

    /**
     * If showing a filter row for this ListGrid, should the filter criteria for this      field be editable
     *
     * @return Current canFilter value. Default value is null
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#grid_sortfilter_disable_filter" target="examples">Disable filter Example</a>
     */
    public Boolean getCanFilter()  {
        return getAttributeAsBoolean("canFilter", true);
    }
    

    /**
     * Whether this field should display freezing/unfreezing options in its header context menu. See {@link
     * com.smartgwt.client.docs.FrozenFields}.
     *
     * @param canFreeze New canFreeze value. Default value is null
     * @see com.smartgwt.client.widgets.grid.ListGrid#getHeaderContextMenuItems
     * @see com.smartgwt.client.docs.FrozenFields FrozenFields overview and related methods
     */
    public void setCanFreeze(Boolean canFreeze) {
        setAttribute("canFreeze", canFreeze);
    }

    /**
     * Whether this field should display freezing/unfreezing options in its header context menu. See {@link
     * com.smartgwt.client.docs.FrozenFields}.
     *
     * @return Current canFreeze value. Default value is null
     * @see com.smartgwt.client.widgets.grid.ListGrid#getHeaderContextMenuItems
     * @see com.smartgwt.client.docs.FrozenFields FrozenFields overview and related methods
     */
    public Boolean getCanFreeze()  {
        return getAttributeAsBoolean("canFreeze", true);
    }
    

    /**
     * Determines whether this field will be groupable in the header context menu.
     *
     * @param canGroupBy New canGroupBy value. Default value is true
     * @see com.smartgwt.client.widgets.grid.ListGrid#groupBy
     */
    public void setCanGroupBy(Boolean canGroupBy) {
        setAttribute("canGroupBy", canGroupBy);
    }

    /**
     * Determines whether this field will be groupable in the header context menu.
     *
     * @return Current canGroupBy value. Default value is true
     * @see com.smartgwt.client.widgets.grid.ListGrid#groupBy
     */
    public Boolean getCanGroupBy()  {
        Boolean result = getAttributeAsBoolean("canGroupBy", true);
        return result == null ? true : result;
    }
    

    /**
     * If set to false, this field will be omitted from the column picker that appears in the header context menu when {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getCanPickFields ListGrid.canPickFields} is enabled.  This means that the end
     * user will not be able to hide it if it's currently shown, or show it if it's currently hidden. <P> If this property is
     * set to <code>false</code>, and the  {@link com.smartgwt.client.widgets.grid.ListGrid#getUseAdvancedFieldPicker advanced
     * field picker} is shown, if the field is {@link com.smartgwt.client.widgets.grid.ListGridField#getHidden hidden}, the
     * field will not show in the list of available fields. If the field is visible, it will be displayed in the list of
     * currently visible fields, but the advanced field picker user interface will disallow hiding it.
     *
     * @param canHide New canHide value. Default value is null
     * @see com.smartgwt.client.widgets.grid.ListGrid#getHeaderContextMenuItems
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setCanHide(Boolean canHide) {
        setAttribute("canHide", canHide);
    }

    /**
     * If set to false, this field will be omitted from the column picker that appears in the header context menu when {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getCanPickFields ListGrid.canPickFields} is enabled.  This means that the end
     * user will not be able to hide it if it's currently shown, or show it if it's currently hidden. <P> If this property is
     * set to <code>false</code>, and the  {@link com.smartgwt.client.widgets.grid.ListGrid#getUseAdvancedFieldPicker advanced
     * field picker} is shown, if the field is {@link com.smartgwt.client.widgets.grid.ListGridField#getHidden hidden}, the
     * field will not show in the list of available fields. If the field is visible, it will be displayed in the list of
     * currently visible fields, but the advanced field picker user interface will disallow hiding it.
     *
     * @return Current canHide value. Default value is null
     * @see com.smartgwt.client.widgets.grid.ListGrid#getHeaderContextMenuItems
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Boolean getCanHide()  {
        return getAttributeAsBoolean("canHide", true);
    }
    

    /**
     * Determines whether this field can be hilited.  Set to false to prevent this field from appearing in HiliteEditor.
     *
     * @param canHilite New canHilite value. Default value is null
     */
    public void setCanHilite(Boolean canHilite) {
        setAttribute("canHilite", canHilite);
    }

    /**
     * Determines whether this field can be hilited.  Set to false to prevent this field from appearing in HiliteEditor.
     *
     * @return Current canHilite value. Default value is null
     */
    public Boolean getCanHilite()  {
        return getAttributeAsBoolean("canHilite", true);
    }
    

    /**
     * Whether this field can be reordered using the mouse.  If unset, the default behavior is governed by {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getCanReorderFields ListGrid.canReorderFields}.  Note that setting this
     * property to <code>false</code> will lock this field from being moved - that is, the user is prevented from moving this
     * field directly by dragging with the mouse, or by dropping another field onto this field. <P> Note that setting
     * <code>canReorder:false</code> on a field in the middle of a grid is mostly useless, since it's possible that such a
     * "locked" field may still be reordered automatically, as a result of the user dragging one unlocked field onto another
     * unlocked field. <P> Fields in {@link com.smartgwt.client.widgets.grid.ListGrid#getHeaderSpans headerSpans} are treated
     * as if they have <code>canReorder:false</code> to keep the fields in the span together, except that unlocked fields not
     * in a span may be drag-reordered across them, even if they're at the header's extreme left or right.  HeaderSpans
     * themselves may not be drag-reordered.
     *
     * @param canReorder New canReorder value. Default value is null
     */
    public void setCanReorder(Boolean canReorder) {
        setAttribute("canReorder", canReorder);
    }

    /**
     * Whether this field can be reordered using the mouse.  If unset, the default behavior is governed by {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getCanReorderFields ListGrid.canReorderFields}.  Note that setting this
     * property to <code>false</code> will lock this field from being moved - that is, the user is prevented from moving this
     * field directly by dragging with the mouse, or by dropping another field onto this field. <P> Note that setting
     * <code>canReorder:false</code> on a field in the middle of a grid is mostly useless, since it's possible that such a
     * "locked" field may still be reordered automatically, as a result of the user dragging one unlocked field onto another
     * unlocked field. <P> Fields in {@link com.smartgwt.client.widgets.grid.ListGrid#getHeaderSpans headerSpans} are treated
     * as if they have <code>canReorder:false</code> to keep the fields in the span together, except that unlocked fields not
     * in a span may be drag-reordered across them, even if they're at the header's extreme left or right.  HeaderSpans
     * themselves may not be drag-reordered.
     *
     * @return Current canReorder value. Default value is null
     */
    public Boolean getCanReorder()  {
        return getAttributeAsBoolean("canReorder", true);
    }
    

    /**
     * Enables or disables sorting by this column. If false, interactive  sorting via header-clicks or menu-items will have no
     * effect, but direct scripted calls  to {@link com.smartgwt.client.widgets.grid.ListGrid#sort sort()} or {@link
     * com.smartgwt.client.widgets.grid.ListGrid#setSort setSort()} will work as  expected.
     *
     * @param canSort New canSort value. Default value is true
     * @see com.smartgwt.client.widgets.grid.ListGrid#sort
     * @see com.smartgwt.client.widgets.grid.ListGrid#setCanSort
     */
    public void setCanSort(Boolean canSort) {
        setAttribute("canSort", canSort);
    }

    /**
     * Enables or disables sorting by this column. If false, interactive  sorting via header-clicks or menu-items will have no
     * effect, but direct scripted calls  to {@link com.smartgwt.client.widgets.grid.ListGrid#sort sort()} or {@link
     * com.smartgwt.client.widgets.grid.ListGrid#setSort setSort()} will work as  expected.
     *
     * @return Current canSort value. Default value is true
     * @see com.smartgwt.client.widgets.grid.ListGrid#sort
     * @see com.smartgwt.client.widgets.grid.ListGrid#getCanSort
     */
    public Boolean getCanSort()  {
        Boolean result = getAttributeAsBoolean("canSort", true);
        return result == null ? true : result;
    }
    

    /**
     * When true, this field can only be used for sorting if the data is entirely client-side.
     *
     * @param canSortClientOnly New canSortClientOnly value. Default value is false
     */
    public void setCanSortClientOnly(Boolean canSortClientOnly) {
        setAttribute("canSortClientOnly", canSortClientOnly);
    }

    /**
     * When true, this field can only be used for sorting if the data is entirely client-side.
     *
     * @return Current canSortClientOnly value. Default value is false
     */
    public Boolean getCanSortClientOnly()  {
        Boolean result = getAttributeAsBoolean("canSortClientOnly", true);
        return result == null ? false : result;
    }
    

    /**
     * Allows a boolean or {@link com.smartgwt.client.types.ValueMap valueMapped} field to be edited without going into edit
     * mode. When this attribute is set, clicking on the field will change the value - for boolean fields toggling between
     * <code>true</code> and <code>false</code>, and for valueMapped fields, advancing the value to the next option in the
     * valueMap. <P> To enable this feature, {@link com.smartgwt.client.widgets.grid.ListGrid#getCanEdit ListGrid.canEdit} must
     * be set to true. For boolean type fields <code>canToggle</code> is true by default, meaning setting <code>canEdit</code>
     * to true implies the user can toggle the value via a single click without going into edit mode. You can disable this by
     * explicitly setting <code>canToggle</code> to false for a boolean field.<br> Note that you can enable toggling only
     * (without allowing the user to edit other fields) by just setting {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getEditEvent grid.editEvent:"none"}. <P> If {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getEditEvent ListGrid.editEvent} is set to "click", when the user clicks on
     * the field, the value will be toggled, and inline editing will be triggered as usual. Otherwise the toggled value will be
     * saved immediately to the server, or if {@link com.smartgwt.client.widgets.grid.ListGrid#getAutoSaveEdits
     * ListGrid.autoSaveEdits} has been set to false, will be stored as an edit value for the record.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param canToggle New canToggle value. Default value is varies
     * @see com.smartgwt.client.docs.Editing Editing overview and related methods
     */
    public void setCanToggle(Boolean canToggle) {
        setAttribute("canToggle", canToggle);
    }

    /**
     * Allows a boolean or {@link com.smartgwt.client.types.ValueMap valueMapped} field to be edited without going into edit
     * mode. When this attribute is set, clicking on the field will change the value - for boolean fields toggling between
     * <code>true</code> and <code>false</code>, and for valueMapped fields, advancing the value to the next option in the
     * valueMap. <P> To enable this feature, {@link com.smartgwt.client.widgets.grid.ListGrid#getCanEdit ListGrid.canEdit} must
     * be set to true. For boolean type fields <code>canToggle</code> is true by default, meaning setting <code>canEdit</code>
     * to true implies the user can toggle the value via a single click without going into edit mode. You can disable this by
     * explicitly setting <code>canToggle</code> to false for a boolean field.<br> Note that you can enable toggling only
     * (without allowing the user to edit other fields) by just setting {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getEditEvent grid.editEvent:"none"}. <P> If {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getEditEvent ListGrid.editEvent} is set to "click", when the user clicks on
     * the field, the value will be toggled, and inline editing will be triggered as usual. Otherwise the toggled value will be
     * saved immediately to the server, or if {@link com.smartgwt.client.widgets.grid.ListGrid#getAutoSaveEdits
     * ListGrid.autoSaveEdits} has been set to false, will be stored as an edit value for the record.
     *
     * @return Current canToggle value. Default value is varies
     * @see com.smartgwt.client.docs.Editing Editing overview and related methods
     */
    public Boolean getCanToggle()  {
        return getAttributeAsBoolean("canToggle", true);
    }
    

    /**
     * Horizontal alignment for cells in this field's column: "left", "right" or "center".<br> If null, alignment is derived
     * from {@link com.smartgwt.client.widgets.grid.ListGridField#getAlign align}. If this field is editable, the alignment of
     * cells in the body will also be reflected in any editors for the field.
     *
     * @param cellAlign New cellAlign value. Default value is null
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setCellAlign(Alignment cellAlign) {
        setAttribute("cellAlign", cellAlign == null ? null : cellAlign.getValue());
    }

    /**
     * Horizontal alignment for cells in this field's column: "left", "right" or "center".<br> If null, alignment is derived
     * from {@link com.smartgwt.client.widgets.grid.ListGridField#getAlign align}. If this field is editable, the alignment of
     * cells in the body will also be reflected in any editors for the field.
     *
     * @return Current cellAlign value. Default value is null
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Alignment getCellAlign()  {
        return EnumUtil.getEnum(Alignment.values(), getAttribute("cellAlign"));
    }
    

    /**
     * For a field of type:"icon" only, set the icon that appears in body cells.  Unless setting {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getIcon field.icon}, setting field.cellIcon will not show an icon in the
     * header. <p> To change this property after fields have been passed to {@link
     * com.smartgwt.client.widgets.grid.ListGrid#setFields ListGrid.setFields()}, use {@link
     * com.smartgwt.client.widgets.grid.ListGrid#setFieldCellIcon ListGrid.setFieldCellIcon()}.
     *
     * @param cellIcon New cellIcon value. Default value is null
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     */
    public void setCellIcon(String cellIcon) {
        setAttribute("cellIcon", cellIcon);
    }

    /**
     * For a field of type:"icon" only, set the icon that appears in body cells.  Unless setting {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getIcon field.icon}, setting field.cellIcon will not show an icon in the
     * header. <p> To change this property after fields have been passed to {@link
     * com.smartgwt.client.widgets.grid.ListGrid#setFields ListGrid.setFields()}, use {@link
     * com.smartgwt.client.widgets.grid.ListGrid#setFieldCellIcon ListGrid.setFieldCellIcon()}.
     *
     * @return Current cellIcon value. Default value is null
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     */
    public String getCellIcon()  {
        return getAttributeAsString("cellIcon");
    }
    

    /**
     * dataPath for this field. This property allows the grid to display details of nested data structures in a flat list of
     * columns.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param dataPath New dataPath value. Default value is null
     */
    public void setDataPath(String dataPath) {
        setAttribute("dataPath", dataPath);
    }

    /**
     * dataPath for this field. This property allows the grid to display details of nested data structures in a flat list of
     * columns.
     *
     * @return Current dataPath value. Default value is null
     */
    public String getDataPath()  {
        return getAttributeAsString("dataPath");
    }
    

    /**
     * Display format to use for date type values within this field. <P> The {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getTimeFormatter timeFormatter} may also be used to format underlying
     * Date values as times (omitting the date part entirely). If both <code>dateFormatter</code> and
     * <code>timeFormatter</code> are specified on a field, for fields specified as {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getType type "time"} the <code>timeFormatter</code> will be used,
     * otherwise the <code>dateFormatter</code> <P> If <code>field.dateFormatter</code> and <code>field.timeFormatter</code> is
     * unspecified, date display format may be defined at the component level via {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getDateFormatter ListGrid.dateFormatter}, or for fields of type
     * <code>"datetime"</code> {@link com.smartgwt.client.widgets.grid.ListGrid#getDatetimeFormatter
     * ListGrid.datetimeFormatter}. Otherwise the default is to use the system-wide default short date format, configured via
     * {@link com.smartgwt.client.util.DateUtil#setShortDisplayFormat DateUtil.setShortDisplayFormat()}.  Specify any valid
     * {@link com.smartgwt.client.types.DateDisplayFormat} to change the format used by this item. <P> If this field is
     * editable the dateFormatter will also be passed to the editor created to edit this field. Note that you can also specify
     * an explicit {@link com.smartgwt.client.widgets.grid.ListGridField#getInputFormat inputFormat} which will be passed
     * through to the editor as well, though this is not typically required as the input format should be automatically derived
     * by the Smart GWT system for standard DateDisplayFormats.
     *
     * @param dateFormatter New dateFormatter value. Default value is null
     * @see com.smartgwt.client.widgets.grid.ListGrid#setDateFormatter
     * @see com.smartgwt.client.widgets.grid.ListGrid#setDatetimeFormatter
     * @see com.smartgwt.client.widgets.grid.ListGridField#setTimeFormatter
     */
    public void setDateFormatter(DateDisplayFormat dateFormatter) {
        setAttribute("dateFormatter", dateFormatter == null ? null : dateFormatter.getValue());
    }

    /**
     * Display format to use for date type values within this field. <P> The {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getTimeFormatter timeFormatter} may also be used to format underlying
     * Date values as times (omitting the date part entirely). If both <code>dateFormatter</code> and
     * <code>timeFormatter</code> are specified on a field, for fields specified as {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getType type "time"} the <code>timeFormatter</code> will be used,
     * otherwise the <code>dateFormatter</code> <P> If <code>field.dateFormatter</code> and <code>field.timeFormatter</code> is
     * unspecified, date display format may be defined at the component level via {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getDateFormatter ListGrid.dateFormatter}, or for fields of type
     * <code>"datetime"</code> {@link com.smartgwt.client.widgets.grid.ListGrid#getDatetimeFormatter
     * ListGrid.datetimeFormatter}. Otherwise the default is to use the system-wide default short date format, configured via
     * {@link com.smartgwt.client.util.DateUtil#setShortDisplayFormat DateUtil.setShortDisplayFormat()}.  Specify any valid
     * {@link com.smartgwt.client.types.DateDisplayFormat} to change the format used by this item. <P> If this field is
     * editable the dateFormatter will also be passed to the editor created to edit this field. Note that you can also specify
     * an explicit {@link com.smartgwt.client.widgets.grid.ListGridField#getInputFormat inputFormat} which will be passed
     * through to the editor as well, though this is not typically required as the input format should be automatically derived
     * by the Smart GWT system for standard DateDisplayFormats.
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
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setDecimalPrecision(Integer decimalPrecision) {
        setAttribute("decimalPrecision", decimalPrecision);
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
     * Default groupingMode used when the user does not specify a mode or grouping is triggered programmatically and {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getGroupingMode field.groupingMode} is unset. See {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getGroupingModes field.groupingModes}.
     *
     * @param defaultGroupingMode New defaultGroupingMode value. Default value is null
     * @see com.smartgwt.client.docs.Identifier Identifier 
     */
    public void setDefaultGroupingMode(String defaultGroupingMode) {
        setAttribute("defaultGroupingMode", defaultGroupingMode);
    }

    /**
     * Default groupingMode used when the user does not specify a mode or grouping is triggered programmatically and {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getGroupingMode field.groupingMode} is unset. See {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getGroupingModes field.groupingModes}.
     *
     * @return Current defaultGroupingMode value. Default value is null
     * @see com.smartgwt.client.docs.Identifier Identifier 
     */
    public String getDefaultGroupingMode()  {
        return getAttributeAsString("defaultGroupingMode");
    }
    

    /**
     * If this field is editable, this property will be passed to editors displayed for cells within this field as {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getDefaultIconSrc FormItem.defaultIconSrc}.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param defaultIconSrc New defaultIconSrc value. Default value is null
     * @see com.smartgwt.client.widgets.grid.ListGridField#setIcons
     * @see com.smartgwt.client.docs.Editing Editing overview and related methods
     */
    public void setDefaultIconSrc(String defaultIconSrc) {
        setAttribute("defaultIconSrc", defaultIconSrc);
    }

    /**
     * If this field is editable, this property will be passed to editors displayed for cells within this field as {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getDefaultIconSrc FormItem.defaultIconSrc}.
     *
     * @return Current defaultIconSrc value. Default value is null
     * @see com.smartgwt.client.widgets.grid.ListGridField#getIcons
     * @see com.smartgwt.client.docs.Editing Editing overview and related methods
     */
    public String getDefaultIconSrc()  {
        return getAttributeAsString("defaultIconSrc");
    }
    
    

    /**
     * Optional "default width" for this field. If set, this value will be returned by the {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getDefaultFieldWidth ListGrid.getDefaultFieldWidth()} method, and used as the
     * autoFit size for the field's content.
     *
     * @param defaultWidth New defaultWidth value. Default value is null
     */
    public void setDefaultWidth(Integer defaultWidth) {
        setAttribute("defaultWidth", defaultWidth);
    }

    /**
     * Optional "default width" for this field. If set, this value will be returned by the {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getDefaultFieldWidth ListGrid.getDefaultFieldWidth()} method, and used as the
     * autoFit size for the field's content.
     *
     * @return Current defaultWidth value. Default value is null
     */
    public Integer getDefaultWidth()  {
        return getAttributeAsInt("defaultWidth");
    }
    

    /**
     * Specifies the {@link com.smartgwt.client.widgets.grid.ListGridField#getOptionDataSource optionDataSource} field used to
     * retrieve the display values that are to be mapped from the internal values specified by {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getValueField valueField}. <P> If no <code>optionDataSource</code> is
     * defined for the field, the cell will display the displayField value for the current record instead of the underlying
     * value for this field.  This approach can be used for situations where field values need a stored value to displayed
     * value mapping, but the set of all possible values is too large to load as a {@link com.smartgwt.client.types.ValueMap} -
     * see {@link com.smartgwt.client.widgets.grid.ListGridField#getOptionDataSource optionDataSource} for more details on this
     * approach.  Note that if this field is editable this will also be applied to this field's editors.  <a
     * href="http://www.smartclient.com/smartgwtee/showcase/#large_valuemap_sql" target="examples">This sample</a> illustrates
     * this approach achieved via a server-side SQL join. <p> The display value for a record with a specified
     * <code>displayField</code> can be picked up via {@link com.smartgwt.client.widgets.grid.ListGrid#getDisplayValue
     * ListGrid.getDisplayValue()}.
     *
     * @param displayField New displayField value. Default value is null
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
     * value mapping, but the set of all possible values is too large to load as a {@link com.smartgwt.client.types.ValueMap} -
     * see {@link com.smartgwt.client.widgets.grid.ListGridField#getOptionDataSource optionDataSource} for more details on this
     * approach.  Note that if this field is editable this will also be applied to this field's editors.  <a
     * href="http://www.smartclient.com/smartgwtee/showcase/#large_valuemap_sql" target="examples">This sample</a> illustrates
     * this approach achieved via a server-side SQL join. <p> The display value for a record with a specified
     * <code>displayField</code> can be picked up via {@link com.smartgwt.client.widgets.grid.ListGrid#getDisplayValue
     * ListGrid.getDisplayValue()}.
     *
     * @return Current displayField value. Default value is null
     */
    public String getDisplayField()  {
        return getAttributeAsString("displayField");
    }
    
    

    /**
     * If a {@link com.smartgwt.client.widgets.grid.ListGridField#getDisplayField displayField} is set, should this field show
     * record values from the <code>displayField</code>? <P> If {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getDisplayField displayField} is specified, and there is no separate
     * {@link com.smartgwt.client.widgets.grid.ListGridField#getOptionDataSource optionDataSource}, by default we will show
     * display-field values from the same record. Setting this property to false would disable this behavior. <P>
     * Alternatively, if there is a {@link com.smartgwt.client.widgets.grid.ListGridField#getOptionDataSource optionDataSource}
     * (and {@link com.smartgwt.client.widgets.grid.ListGridField#getAutoFetchDisplayMap autoFetchDisplayMap} is false), the
     * displayField would be ignored for the field and the underlying {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getName record[fieldName] value} would be displayed to the user. This
     * property may be set to true to override this behavior and pick up values from the <code>displayField</code> for display
     * in this field even when there is an optionDataSource set. <P> Note that this property has no effect on fields with an
     * explicitly specified valueMap, or with an optionDataSource where {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getAutoFetchDisplayMap autoFetchDisplayMap} is true.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param displayValueFromRecord New displayValueFromRecord value. Default value is null
     */
    public void setDisplayValueFromRecord(Boolean displayValueFromRecord) {
        setAttribute("displayValueFromRecord", displayValueFromRecord);
    }

    /**
     * If a {@link com.smartgwt.client.widgets.grid.ListGridField#getDisplayField displayField} is set, should this field show
     * record values from the <code>displayField</code>? <P> If {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getDisplayField displayField} is specified, and there is no separate
     * {@link com.smartgwt.client.widgets.grid.ListGridField#getOptionDataSource optionDataSource}, by default we will show
     * display-field values from the same record. Setting this property to false would disable this behavior. <P>
     * Alternatively, if there is a {@link com.smartgwt.client.widgets.grid.ListGridField#getOptionDataSource optionDataSource}
     * (and {@link com.smartgwt.client.widgets.grid.ListGridField#getAutoFetchDisplayMap autoFetchDisplayMap} is false), the
     * displayField would be ignored for the field and the underlying {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getName record[fieldName] value} would be displayed to the user. This
     * property may be set to true to override this behavior and pick up values from the <code>displayField</code> for display
     * in this field even when there is an optionDataSource set. <P> Note that this property has no effect on fields with an
     * explicitly specified valueMap, or with an optionDataSource where {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getAutoFetchDisplayMap autoFetchDisplayMap} is true.
     *
     * @return Current displayValueFromRecord value. Default value is null
     */
    public Boolean getDisplayValueFromRecord()  {
        return getAttributeAsBoolean("displayValueFromRecord", true);
    }
    

    /**
     * Shortcut to configure a {@link com.smartgwt.client.widgets.form.fields.FormItem#getFormula FormItem.formula} for the
     * {@link com.smartgwt.client.widgets.grid.ListGridField#getEditorType editor} used when this field is {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getCanEdit edited}.
     *
     * @param editorFormula New editorFormula value. Default value is null
     */
    public void setEditorFormula(UserFormula editorFormula) {
        setAttribute("editorFormula", editorFormula == null ? null : editorFormula.getJsObj());
    }

    /**
     * Shortcut to configure a {@link com.smartgwt.client.widgets.form.fields.FormItem#getFormula FormItem.formula} for the
     * {@link com.smartgwt.client.widgets.grid.ListGridField#getEditorType editor} used when this field is {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getCanEdit edited}.
     *
     * @return Current editorFormula value. Default value is null
     */
    public UserFormula getEditorFormula()  {
        return new UserFormula(getAttributeAsJavaScriptObject("editorFormula"));
    }
    

    /**
     * If this field is editable, this property will be passed to editors displayed for cells within this field as {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getIconHeight FormItem.iconHeight}.<br> If this property unset, the
     * iconHeight property from the editor can be picked up from {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getIconHeight iconHeight} instead.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param editorIconHeight New editorIconHeight value. Default value is null
     * @see com.smartgwt.client.widgets.grid.ListGridField#setIcons
     * @see com.smartgwt.client.docs.Editing Editing overview and related methods
     */
    public void setEditorIconHeight(Integer editorIconHeight) {
        setAttribute("editorIconHeight", editorIconHeight);
    }

    /**
     * If this field is editable, this property will be passed to editors displayed for cells within this field as {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getIconHeight FormItem.iconHeight}.<br> If this property unset, the
     * iconHeight property from the editor can be picked up from {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getIconHeight iconHeight} instead.
     *
     * @return Current editorIconHeight value. Default value is null
     * @see com.smartgwt.client.widgets.grid.ListGridField#getIcons
     * @see com.smartgwt.client.docs.Editing Editing overview and related methods
     */
    public Integer getEditorIconHeight()  {
        return getAttributeAsInt("editorIconHeight");
    }
    

    /**
     * If this field is editable, this property will be passed to editors displayed for cells within this field as {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getIconWidth FormItem.iconWidth}.<br> If this property unset, the
     * iconWidth property from the editor can be picked up from {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getIconWidth iconWidth} instead.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param editorIconWidth New editorIconWidth value. Default value is null
     * @see com.smartgwt.client.widgets.grid.ListGridField#setIcons
     * @see com.smartgwt.client.docs.Editing Editing overview and related methods
     */
    public void setEditorIconWidth(Integer editorIconWidth) {
        setAttribute("editorIconWidth", editorIconWidth);
    }

    /**
     * If this field is editable, this property will be passed to editors displayed for cells within this field as {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getIconWidth FormItem.iconWidth}.<br> If this property unset, the
     * iconWidth property from the editor can be picked up from {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getIconWidth iconWidth} instead.
     *
     * @return Current editorIconWidth value. Default value is null
     * @see com.smartgwt.client.widgets.grid.ListGridField#getIcons
     * @see com.smartgwt.client.docs.Editing Editing overview and related methods
     */
    public Integer getEditorIconWidth()  {
        return getAttributeAsInt("editorIconWidth");
    }
    

    /**
     * When some cell in this field is being edited, this property can be used to apply an explicit {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getImageURLPrefix FormItem.imageURLPrefix} to the editor in question.
     * This can be used to modify the valueIcons within the editor.<br> If unset, but {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getImageURLPrefix imageURLPrefix} is specified, that will be used
     * instead.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param editorImageURLPrefix New editorImageURLPrefix value. Default value is null
     * @see com.smartgwt.client.docs.Editing Editing overview and related methods
     */
    public void setEditorImageURLPrefix(String editorImageURLPrefix) {
        setAttribute("editorImageURLPrefix", editorImageURLPrefix);
    }

    /**
     * When some cell in this field is being edited, this property can be used to apply an explicit {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getImageURLPrefix FormItem.imageURLPrefix} to the editor in question.
     * This can be used to modify the valueIcons within the editor.<br> If unset, but {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getImageURLPrefix imageURLPrefix} is specified, that will be used
     * instead.
     *
     * @return Current editorImageURLPrefix value. Default value is null
     * @see com.smartgwt.client.docs.Editing Editing overview and related methods
     */
    public String getEditorImageURLPrefix()  {
        return getAttributeAsString("editorImageURLPrefix");
    }
    

    /**
     * When some cell in this field is being edited, this property can be used to apply an explicit {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getImageURLSuffix FormItem.imageURLSuffix} to the editor in question.
     * This can be used to modify the valueIcons within the editor.<br> If unset, but {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getImageURLPrefix imageURLPrefix} is specified, that will be used
     * instead.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param editorImageURLSuffix New editorImageURLSuffix value. Default value is null
     * @see com.smartgwt.client.docs.Editing Editing overview and related methods
     */
    public void setEditorImageURLSuffix(String editorImageURLSuffix) {
        setAttribute("editorImageURLSuffix", editorImageURLSuffix);
    }

    /**
     * When some cell in this field is being edited, this property can be used to apply an explicit {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getImageURLSuffix FormItem.imageURLSuffix} to the editor in question.
     * This can be used to modify the valueIcons within the editor.<br> If unset, but {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getImageURLPrefix imageURLPrefix} is specified, that will be used
     * instead.
     *
     * @return Current editorImageURLSuffix value. Default value is null
     * @see com.smartgwt.client.docs.Editing Editing overview and related methods
     */
    public String getEditorImageURLSuffix()  {
        return getAttributeAsString("editorImageURLSuffix");
    }
    
    

    /**
     * Shortcut to configure a {@link com.smartgwt.client.widgets.form.fields.FormItem#getTextFormula FormItem.textFormula} for
     * the {@link com.smartgwt.client.widgets.grid.ListGridField#getEditorType editor} used when this field is {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getCanEdit edited}.
     *
     * @param editorTextFormula New editorTextFormula value. Default value is null
     */
    public void setEditorTextFormula(UserSummary editorTextFormula) {
        setAttribute("editorTextFormula", editorTextFormula == null ? null : editorTextFormula.getJsObj());
    }

    /**
     * Shortcut to configure a {@link com.smartgwt.client.widgets.form.fields.FormItem#getTextFormula FormItem.textFormula} for
     * the {@link com.smartgwt.client.widgets.grid.ListGridField#getEditorType editor} used when this field is {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getCanEdit edited}.
     *
     * @return Current editorTextFormula value. Default value is null
     */
    public UserSummary getEditorTextFormula()  {
        return new UserSummary(getAttributeAsJavaScriptObject("editorTextFormula"));
    }
    
    

    /**
     * When some cell in this field is being edited, setting this property will specify the height for value icons in the
     * cell's editor. If unset, the editor's valueIcon width and height will be determined in the same way as it would be for a
     * static cell.
     *
     * @param editorValueIconHeight New editorValueIconHeight value. Default value is null
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
     * @return Current editorValueIconHeight value. Default value is null
     * @see com.smartgwt.client.docs.ImageColumns ImageColumns overview and related methods
     */
    public Integer getEditorValueIconHeight()  {
        return getAttributeAsInt("editorValueIconHeight");
    }
    

    /**
     * When some cell in this field is being edited, setting this property will specify the value icons to display in the
     * cell's editor. If unset, the editor's valueIcons will be determined in the same way as it would be for a static cell.
     *
     * @param editorValueIcons New editorValueIcons value. Default value is null
     * @see com.smartgwt.client.docs.ImageColumns ImageColumns overview and related methods
     */
    public void setEditorValueIcons(Map<String,String> editorValueIcons) {
        setAttribute("editorValueIcons", editorValueIcons);
    }
    

    /**
     * When some cell in this field is being edited, setting this property will specify the width for value icons in the cell's
     * editor. If unset, the editor's valueIcon width and height will be determined in the same way as it would be for a static
     * cell.
     *
     * @param editorValueIconWidth New editorValueIconWidth value. Default value is null
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
     * @return Current editorValueIconWidth value. Default value is null
     * @see com.smartgwt.client.docs.ImageColumns ImageColumns overview and related methods
     */
    public Integer getEditorValueIconWidth()  {
        return getAttributeAsInt("editorValueIconWidth");
    }
    

    /**
     * A valueMap to use for editors shown for this field.  By default if this is not specified {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getValueMap field.valueMap} will be used instead. <P> Dynamic valueMaps
     * can be provided by implementing {@link com.smartgwt.client.widgets.grid.ListGrid#getEditorValueMap
     * ListGrid.getEditorValueMap()}.
     *
     * @param editorValueMap New editorValueMap value. Default value is null
     * @see com.smartgwt.client.widgets.grid.ListGrid#getEditorValueMap
     * @see com.smartgwt.client.widgets.grid.ListGrid#setEditorValueMap
     * @see com.smartgwt.client.docs.Editing Editing overview and related methods
     */
    public void setEditorValueMap(Map editorValueMap) {
        setAttribute("editorValueMap", editorValueMap);
    }
    

    /**
     * The value to display for a cell whose value is null or the empty string after applying {@link
     * com.smartgwt.client.widgets.grid.ListGridField#setCellFormatter formatting} and valueMap (if any). <p> This is the
     * field-specific attribute.  You may also set the emptyCellValue at the grid level to define the emptyCellValue for all
     * empty fields in the grid.
     *
     * @param emptyCellValue New emptyCellValue value. Default value is "&amp;nbsp;"
     * @see com.smartgwt.client.widgets.grid.ListGrid#setEmptyCellValue
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#grid_appearance_empty_values" target="examples">Empty values Example</a>
     */
    public void setEmptyCellValue(String emptyCellValue) {
        setAttribute("emptyCellValue", emptyCellValue);
    }

    /**
     * The value to display for a cell whose value is null or the empty string after applying {@link
     * com.smartgwt.client.widgets.grid.ListGridField#setCellFormatter formatting} and valueMap (if any). <p> This is the
     * field-specific attribute.  You may also set the emptyCellValue at the grid level to define the emptyCellValue for all
     * empty fields in the grid.
     *
     * @return Current emptyCellValue value. Default value is "&amp;nbsp;"
     * @see com.smartgwt.client.widgets.grid.ListGrid#getEmptyCellValue
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#grid_appearance_empty_values" target="examples">Empty values Example</a>
     */
    public String getEmptyCellValue()  {
        return getAttributeAsString("emptyCellValue");
    }
    

    /**
     * What to do when a user hits enter while editing this field?<br> Overrides the <code>enterKeyEditAction</code> as
     * specified at the listGrid level while focus is in this field.
     *
     * @param enterKeyEditAction New enterKeyEditAction value. Default value is "done"
     * @see com.smartgwt.client.docs.Editing Editing overview and related methods
     */
    public void setEnterKeyEditAction(EnterKeyEditAction enterKeyEditAction) {
        setAttribute("enterKeyEditAction", enterKeyEditAction == null ? null : enterKeyEditAction.getValue());
    }

    /**
     * What to do when a user hits enter while editing this field?<br> Overrides the <code>enterKeyEditAction</code> as
     * specified at the listGrid level while focus is in this field.
     *
     * @return Current enterKeyEditAction value. Default value is "done"
     * @see com.smartgwt.client.docs.Editing Editing overview and related methods
     */
    public EnterKeyEditAction getEnterKeyEditAction()  {
        return EnumUtil.getEnum(EnterKeyEditAction.values(), getAttribute("enterKeyEditAction"));
    }
    

    /**
     * By default HTML values in ListGrid cells will be interpreted by the browser. Setting this flag to true will causes HTML
     * characters to be escaped, meaning the raw value of the field (for example <code>"&lt;b&gt;AAA&lt;/b&gt;"</code>) is
     * displayed to the user rather than the interpreted HTML (for example <code>"<b>AAA</b>"</code>)
     *
     * @param escapeHTML New escapeHTML value. Default value is null
     * @see com.smartgwt.client.widgets.grid.ListGridField#setSkipLineBreaks
     */
    public void setEscapeHTML(Boolean escapeHTML) {
        setAttribute("escapeHTML", escapeHTML);
    }

    /**
     * By default HTML values in ListGrid cells will be interpreted by the browser. Setting this flag to true will causes HTML
     * characters to be escaped, meaning the raw value of the field (for example <code>"&lt;b&gt;AAA&lt;/b&gt;"</code>) is
     * displayed to the user rather than the interpreted HTML (for example <code>"<b>AAA</b>"</code>)
     *
     * @return Current escapeHTML value. Default value is null
     * @see com.smartgwt.client.widgets.grid.ListGridField#getSkipLineBreaks
     */
    public Boolean getEscapeHTML()  {
        return getAttributeAsBoolean("escapeHTML", true);
    }
    

    /**
     * What to do when a user hits escape while editing this field?<br> Overrides the <code>escapeKeyEditAction</code> as
     * specified at the listGrid level while focus is in this field.
     *
     * @param escapeKeyEditAction New escapeKeyEditAction value. Default value is "cancel"
     * @see com.smartgwt.client.docs.Editing Editing overview and related methods
     */
    public void setEscapeKeyEditAction(EscapeKeyEditAction escapeKeyEditAction) {
        setAttribute("escapeKeyEditAction", escapeKeyEditAction == null ? null : escapeKeyEditAction.getValue());
    }

    /**
     * What to do when a user hits escape while editing this field?<br> Overrides the <code>escapeKeyEditAction</code> as
     * specified at the listGrid level while focus is in this field.
     *
     * @return Current escapeKeyEditAction value. Default value is "cancel"
     * @see com.smartgwt.client.docs.Editing Editing overview and related methods
     */
    public EscapeKeyEditAction getEscapeKeyEditAction()  {
        return EnumUtil.getEnum(EscapeKeyEditAction.values(), getAttribute("escapeKeyEditAction"));
    }
    

    /**
     * If true, then this field is excluded from the bound component's view state. In addition, the field will not be selected
     * as the default title field by {@link com.smartgwt.client.widgets.DataBoundComponent#getTitleField
     * DataBoundComponent.getTitleField()} if {@link com.smartgwt.client.widgets.DataBoundComponent#getTitleField
     * DataBoundComponent.titleField} is not provided.
     *
     * @param excludeFromState New excludeFromState value. Default value is null
     * @see com.smartgwt.client.widgets.grid.ListGrid#getViewState
     */
    public void setExcludeFromState(Boolean excludeFromState) {
        setAttribute("excludeFromState", excludeFromState);
    }

    /**
     * If true, then this field is excluded from the bound component's view state. In addition, the field will not be selected
     * as the default title field by {@link com.smartgwt.client.widgets.DataBoundComponent#getTitleField
     * DataBoundComponent.getTitleField()} if {@link com.smartgwt.client.widgets.DataBoundComponent#getTitleField
     * DataBoundComponent.titleField} is not provided.
     *
     * @return Current excludeFromState value. Default value is null
     * @see com.smartgwt.client.widgets.grid.ListGrid#getViewState
     */
    public Boolean getExcludeFromState()  {
        return getAttributeAsBoolean("excludeFromState", true);
    }
    

    /**
     * When exporting data to Excel/OpenOffice format using {@link com.smartgwt.client.widgets.grid.ListGrid#exportData
     * ListGrid.exportData()} or {@link com.smartgwt.client.widgets.grid.ListGrid#exportClientData ListGrid.exportClientData()}
     * with {@link com.smartgwt.client.widgets.grid.ListGrid#getExportFieldWidths ListGrid.exportFieldWidths} set, set this
     * flag false to cause this field to "opt out" of width export.  Fields that opt out in this way have the corresponding
     * spreadsheet column autosized (ie, made just wide enough that content is not clipped). <p> This setting has no effect if
     * <code>listGrid.exportFieldWidths</code> is not set.
     *
     * @param exportFieldWidth New exportFieldWidth value. Default value is true
     */
    public void setExportFieldWidth(boolean exportFieldWidth) {
        setAttribute("exportFieldWidth", exportFieldWidth);
    }

    /**
     * When exporting data to Excel/OpenOffice format using {@link com.smartgwt.client.widgets.grid.ListGrid#exportData
     * ListGrid.exportData()} or {@link com.smartgwt.client.widgets.grid.ListGrid#exportClientData ListGrid.exportClientData()}
     * with {@link com.smartgwt.client.widgets.grid.ListGrid#getExportFieldWidths ListGrid.exportFieldWidths} set, set this
     * flag false to cause this field to "opt out" of width export.  Fields that opt out in this way have the corresponding
     * spreadsheet column autosized (ie, made just wide enough that content is not clipped). <p> This setting has no effect if
     * <code>listGrid.exportFieldWidths</code> is not set.
     *
     * @return Current exportFieldWidth value. Default value is true
     */
    public boolean getExportFieldWidth()  {
        Boolean result = getAttributeAsBoolean("exportFieldWidth", true);
        return result == null ? true : result;
    }
    

    /**
     * {@link com.smartgwt.client.docs.FormatString} used during exports for numeric or date formatting.  See {@link
     * com.smartgwt.client.data.DataSourceField#getExportFormat DataSourceField.exportFormat}.
     *
     * @param exportFormat New exportFormat value. Default value is null
     * @see com.smartgwt.client.docs.FormatString FormatString 
     * @see com.smartgwt.client.docs.ExportFormatting ExportFormatting overview and related methods
     */
    public void setExportFormat(String exportFormat) {
        setAttribute("exportFormat", exportFormat);
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
     * Dictates whether numeric values should be exported as raw numbers instead of formatted values when using {@link
     * com.smartgwt.client.widgets.grid.ListGrid#exportClientData exportClientData()}. <P> This property is only consulted if
     * <code>exportRawValues</code> is not set to true at the {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getExportRawValues grid} or {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getExportRawValues field} level. That property causes all values,
     * including numeric values, to be exported unformatted. <P> This is useful for cases where an explicit ListGrid formatter
     * function simply displays the number as a formatted string for the user (for example "1,234"). Exporting that formatted
     * string rather than the underlying numeric value causes spreadsheet applications such as Excel to lose some
     * functionality. <P> If this property is not explicitly set, numeric values will be exported as raw numbers for {@link
     * com.smartgwt.client.data.DSRequest#getExportAs XLS and OOXML export} only. <P> This property overrides the setting at
     * the {@link com.smartgwt.client.widgets.grid.ListGrid#getExportRawNumbers grid} level.
     *
     * @param exportRawNumbers New exportRawNumbers value. Default value is null
     */
    public void setExportRawNumbers(Boolean exportRawNumbers) {
        setAttribute("exportRawNumbers", exportRawNumbers);
    }

    /**
     * Dictates whether numeric values should be exported as raw numbers instead of formatted values when using {@link
     * com.smartgwt.client.widgets.grid.ListGrid#exportClientData exportClientData()}. <P> This property is only consulted if
     * <code>exportRawValues</code> is not set to true at the {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getExportRawValues grid} or {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getExportRawValues field} level. That property causes all values,
     * including numeric values, to be exported unformatted. <P> This is useful for cases where an explicit ListGrid formatter
     * function simply displays the number as a formatted string for the user (for example "1,234"). Exporting that formatted
     * string rather than the underlying numeric value causes spreadsheet applications such as Excel to lose some
     * functionality. <P> If this property is not explicitly set, numeric values will be exported as raw numbers for {@link
     * com.smartgwt.client.data.DSRequest#getExportAs XLS and OOXML export} only. <P> This property overrides the setting at
     * the {@link com.smartgwt.client.widgets.grid.ListGrid#getExportRawNumbers grid} level.
     *
     * @return Current exportRawNumbers value. Default value is null
     */
    public Boolean getExportRawNumbers()  {
        return getAttributeAsBoolean("exportRawNumbers", true);
    }
    

    /**
     * Dictates whether the data in this field should be exported raw by {@link
     * com.smartgwt.client.widgets.grid.ListGrid#exportClientData exportClientData()}.  If set to true for a field, the values
     * in the field-formatters will not be executed for data in this field. Decreases the time taken for large exports.
     *
     * @param exportRawValues New exportRawValues value. Default value is null
     */
    public void setExportRawValues(Boolean exportRawValues) {
        setAttribute("exportRawValues", exportRawValues);
    }

    /**
     * Dictates whether the data in this field should be exported raw by {@link
     * com.smartgwt.client.widgets.grid.ListGrid#exportClientData exportClientData()}.  If set to true for a field, the values
     * in the field-formatters will not be executed for data in this field. Decreases the time taken for large exports.
     *
     * @return Current exportRawValues value. Default value is null
     */
    public Boolean getExportRawValues()  {
        return getAttributeAsBoolean("exportRawValues", true);
    }
    
    
    

    /**
     * If this listGrid is showing a filter row, this property can be used to specify a  mapping of internal data to/from
     * display values to be in the appropriate filter  row form item.
     *
     * @param filterEditorValueMap New filterEditorValueMap value. Default value is null
     */
    public void setFilterEditorValueMap(Map filterEditorValueMap) {
        setAttribute("filterEditorValueMap", filterEditorValueMap);
    }
    

    /**
     * If we're showing the filterEditor (listGrid.showFilterEditor is true), this property determines whether this list should
     * be filtered every time the user edits the value of the filter editor for this field. <P> The {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getFetchDelay ListGrid.fetchDelay} governs the delay in milliseconds between
     * the user editing the filter editor value, and the new filter being applied to the grid.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param filterOnKeypress New filterOnKeypress value. Default value is null
     */
    public void setFilterOnKeypress(Boolean filterOnKeypress) {
        setAttribute("filterOnKeypress", filterOnKeypress);
    }

    /**
     * If we're showing the filterEditor (listGrid.showFilterEditor is true), this property determines whether this list should
     * be filtered every time the user edits the value of the filter editor for this field. <P> The {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getFetchDelay ListGrid.fetchDelay} governs the delay in milliseconds between
     * the user editing the filter editor value, and the new filter being applied to the grid.
     *
     * @return Current filterOnKeypress value. Default value is null
     */
    public Boolean getFilterOnKeypress()  {
        return getAttributeAsBoolean("filterOnKeypress", true);
    }
    

    /**
     * With the {@link com.smartgwt.client.widgets.grid.ListGrid#getShowFilterEditor FilterEditor} showing, the {@link
     * com.smartgwt.client.data.Operator} to use when matching values for this field. <P> Note that you can set all
     * FilterEditor fields to default to either substring or exact match via {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getAutoFetchTextMatchStyle autoFetchTextMatchStyle}, but if you  want a mix of
     * exact vs substring match on different fields, you need to use this  property, and your ListGrid will produce {@link
     * com.smartgwt.client.data.AdvancedCriteria} rather than the  simpler {@link com.smartgwt.client.data.Criteria} format. 
     * This is automatically and transparently handled by the  Smart GWT Server's SQLDataSource and HibernateDataSource in
     * Power Edition or above,  but if you have your own filtering implementation, it will need to be able to handle 
     * AdvancedCriteria.
     *
     * @param filterOperator New filterOperator value. Default value is null
     * @see com.smartgwt.client.widgets.grid.ListGridField#setOperator
     */
    public void setFilterOperator(OperatorId filterOperator) {
        setAttribute("filterOperator", filterOperator == null ? null : filterOperator.getValue());
    }

    /**
     * With the {@link com.smartgwt.client.widgets.grid.ListGrid#getShowFilterEditor FilterEditor} showing, the {@link
     * com.smartgwt.client.data.Operator} to use when matching values for this field. <P> Note that you can set all
     * FilterEditor fields to default to either substring or exact match via {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getAutoFetchTextMatchStyle autoFetchTextMatchStyle}, but if you  want a mix of
     * exact vs substring match on different fields, you need to use this  property, and your ListGrid will produce {@link
     * com.smartgwt.client.data.AdvancedCriteria} rather than the  simpler {@link com.smartgwt.client.data.Criteria} format. 
     * This is automatically and transparently handled by the  Smart GWT Server's SQLDataSource and HibernateDataSource in
     * Power Edition or above,  but if you have your own filtering implementation, it will need to be able to handle 
     * AdvancedCriteria.
     *
     * @return Current filterOperator value. Default value is null
     * @see com.smartgwt.client.widgets.grid.ListGridField#getOperator
     */
    public OperatorId getFilterOperator()  {
        return EnumUtil.getEnum(OperatorId.values(), getAttribute("filterOperator"));
    }
    

    /**
     * {@link com.smartgwt.client.docs.FormatString} for numeric or date formatting.  See {@link
     * com.smartgwt.client.data.DataSourceField#getFormat DataSourceField.format}.
     *
     * @param format New format value. Default value is null
     * @see com.smartgwt.client.docs.FormatString FormatString 
     * @see com.smartgwt.client.docs.ExportFormatting ExportFormatting overview and related methods
     */
    public void setFormat(String format) {
        setAttribute("format", format);
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
     * Whether this field should be "frozen" for the purposes of horizontal scrolling.  See {@link
     * com.smartgwt.client.docs.FrozenFields}.
     *
     * @param frozen New frozen value. Default value is null
     * @see com.smartgwt.client.docs.FrozenFields FrozenFields overview and related methods
     */
    public void setFrozen(Boolean frozen) {
        setAttribute("frozen", frozen);
    }

    /**
     * Whether this field should be "frozen" for the purposes of horizontal scrolling.  See {@link
     * com.smartgwt.client.docs.FrozenFields}.
     *
     * @return Current frozen value. Default value is null
     * @see com.smartgwt.client.docs.FrozenFields FrozenFields overview and related methods
     */
    public Boolean getFrozen()  {
        return getAttributeAsBoolean("frozen", true);
    }
    

    /**
     * Granularity of grouping for numeric fields. <P> Groups will be formed based on ranges of values of size
     * <code>groupGranularity</code>.  For example, if groupGranularity were 1000, groups would be 0-1000, 1000-2000, etc.
     *
     * @param groupGranularity New groupGranularity value. Default value is null
     */
    public void setGroupGranularity(Integer groupGranularity) {
        setAttribute("groupGranularity", groupGranularity);
    }

    /**
     * Granularity of grouping for numeric fields. <P> Groups will be formed based on ranges of values of size
     * <code>groupGranularity</code>.  For example, if groupGranularity were 1000, groups would be 0-1000, 1000-2000, etc.
     *
     * @return Current groupGranularity value. Default value is null
     */
    public Integer getGroupGranularity()  {
        return getAttributeAsInt("groupGranularity");
    }
    

    /**
     * For a field that allows multiple {@link com.smartgwt.client.widgets.grid.ListGridField#getGroupingModes grouping modes},
     * the current grouping mode. <P> This property is set when a user chooses a particular grouping mode, and may be set on
     * ListGrid creation to affect the initial grouping.
     *
     * @param groupingMode New groupingMode value. Default value is null
     * @see com.smartgwt.client.docs.Identifier Identifier 
     */
    public void setGroupingMode(String groupingMode) {
        setAttribute("groupingMode", groupingMode);
    }

    /**
     * For a field that allows multiple {@link com.smartgwt.client.widgets.grid.ListGridField#getGroupingModes grouping modes},
     * the current grouping mode. <P> This property is set when a user chooses a particular grouping mode, and may be set on
     * ListGrid creation to affect the initial grouping.
     *
     * @return Current groupingMode value. Default value is null
     * @see com.smartgwt.client.docs.Identifier Identifier 
     */
    public String getGroupingMode()  {
        return getAttributeAsString("groupingMode");
    }
    

    /**
     * If this field can be grouped, this attribute represents the set of grouping styles that  are available.  For example, a
     * "date" field might be able to be  grouped by week or month, as well as by the date itself. <P> If
     * <code>groupingModes</code> are present and {@link com.smartgwt.client.widgets.grid.ListGrid#getCanGroupBy grouping is
     * enabled}, the menu for this field includes a submenu of possible grouping modes generated from the
     * <code>groupingModes</code> valueMap. When the user selects a particular grouping mode, {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getGroupingMode field.groupingMode} is set to the user's chosen mode, and
     * this choice can be detected via the <code>field</code> parameter to {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getGroupValue getGroupValue()} in order to provide different modes of
     * grouping. <P> The user may also choose to group records without specifying a grouping mode, in this case, the {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getDefaultGroupingMode defaultGroupingMode} is used. <P> Note that
     * <code>getGroupValue</code>, <code>groupingModes</code> et al can be specified on {@link
     * com.smartgwt.client.data.SimpleType} declarations.  See this list of {@link
     * com.smartgwt.client.docs.BuiltinGroupingModes builtin grouping modes} for more information.
     *
     * @param groupingModes New groupingModes value. Default value is null
     */
    public void setGroupingModes(Map groupingModes) {
        setAttribute("groupingModes", groupingModes);
    }

    /**
     * If this field can be grouped, this attribute represents the set of grouping styles that  are available.  For example, a
     * "date" field might be able to be  grouped by week or month, as well as by the date itself. <P> If
     * <code>groupingModes</code> are present and {@link com.smartgwt.client.widgets.grid.ListGrid#getCanGroupBy grouping is
     * enabled}, the menu for this field includes a submenu of possible grouping modes generated from the
     * <code>groupingModes</code> valueMap. When the user selects a particular grouping mode, {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getGroupingMode field.groupingMode} is set to the user's chosen mode, and
     * this choice can be detected via the <code>field</code> parameter to {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getGroupValue getGroupValue()} in order to provide different modes of
     * grouping. <P> The user may also choose to group records without specifying a grouping mode, in this case, the {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getDefaultGroupingMode defaultGroupingMode} is used. <P> Note that
     * <code>getGroupValue</code>, <code>groupingModes</code> et al can be specified on {@link
     * com.smartgwt.client.data.SimpleType} declarations.  See this list of {@link
     * com.smartgwt.client.docs.BuiltinGroupingModes builtin grouping modes} for more information.
     *
     * @return Current groupingModes value. Default value is null
     */
    public Map getGroupingModes()  {
        return getAttributeAsMap("groupingModes");
    }
    

    /**
     * For fields of type:"float" or derived from float, number of digits after the decimal point to consider when grouping.
     * <P> For example, <code>groupPrecision:2</code> indicates that 45.238 and 45.231 group together, but 45.22 and 45.27 are
     * separate. <P> See also {@link com.smartgwt.client.widgets.grid.ListGridField#getGroupGranularity groupGranularity} for
     * grouping by broader ranges.
     *
     * @param groupPrecision New groupPrecision value. Default value is null
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
     * @return Current groupPrecision value. Default value is null
     */
    public Integer getGroupPrecision()  {
        return getAttributeAsInt("groupPrecision");
    }
    

    /**
     * Custom base style to apply to this field's header button instead of {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getHeaderBaseStyle ListGrid.headerBaseStyle}.<br> Note that depending on the
     * header button constructor, you may have to override {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getHeaderTitleStyle headerTitleStyle} as well.
     *
     * @param headerBaseStyle New headerBaseStyle value. Default value is null
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setHeaderBaseStyle(String headerBaseStyle) {
        setAttribute("headerBaseStyle", headerBaseStyle);
    }

    /**
     * Custom base style to apply to this field's header button instead of {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getHeaderBaseStyle ListGrid.headerBaseStyle}.<br> Note that depending on the
     * header button constructor, you may have to override {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getHeaderTitleStyle headerTitleStyle} as well.
     *
     * @return Current headerBaseStyle value. Default value is null
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getHeaderBaseStyle()  {
        return getAttributeAsString("headerBaseStyle");
    }
    

    /**
     * Delay in ms for hovers shown over this field's header. <P> If unset, any {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getHoverDelay hoverDelay} will be used for both header hovers and hovers
     * shown over cells in the grid's body.
     *
     * @param headerHoverDelay New headerHoverDelay value. Default value is null
     */
    public void setHeaderHoverDelay(Integer headerHoverDelay) {
        setAttribute("headerHoverDelay", headerHoverDelay);
    }

    /**
     * Delay in ms for hovers shown over this field's header. <P> If unset, any {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getHoverDelay hoverDelay} will be used for both header hovers and hovers
     * shown over cells in the grid's body.
     *
     * @return Current headerHoverDelay value. Default value is null
     */
    public Integer getHeaderHoverDelay()  {
        return getAttributeAsInt("headerHoverDelay");
    }
    

    /**
     * Optional title for the header button for this field. If specified this will be displayed in the header button instead of
     * {@link com.smartgwt.client.widgets.grid.ListGridField#getTitle title} or {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getName name}. Set to an empty string to suppress the title in the header
     * button entirely.
     *
     * @param headerTitle New headerTitle value. Default value is null
     * @see com.smartgwt.client.widgets.grid.ListGridField#setTitle
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setHeaderTitle(String headerTitle) {
        setAttribute("headerTitle", headerTitle);
    }

    /**
     * Optional title for the header button for this field. If specified this will be displayed in the header button instead of
     * {@link com.smartgwt.client.widgets.grid.ListGridField#getTitle title} or {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getName name}. Set to an empty string to suppress the title in the header
     * button entirely.
     *
     * @return Current headerTitle value. Default value is null
     * @see com.smartgwt.client.widgets.grid.ListGridField#getTitle
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getHeaderTitle()  {
        return getAttributeAsString("headerTitle");
    }
    

    /**
     * Custom titleStyle to apply to this field's header button instead of {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getHeaderTitleStyle ListGrid.headerTitleStyle}.<br> Note that this will
     * typically only have an effect if {@link com.smartgwt.client.widgets.grid.ListGrid#getHeaderButtonConstructor
     * ListGrid.headerButtonConstructor} is set to {@link com.smartgwt.client.widgets.StretchImgButton} or a subclass thereof.
     *
     * @param headerTitleStyle New headerTitleStyle value. Default value is null
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setHeaderTitleStyle(String headerTitleStyle) {
        setAttribute("headerTitleStyle", headerTitleStyle);
    }

    /**
     * Custom titleStyle to apply to this field's header button instead of {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getHeaderTitleStyle ListGrid.headerTitleStyle}.<br> Note that this will
     * typically only have an effect if {@link com.smartgwt.client.widgets.grid.ListGrid#getHeaderButtonConstructor
     * ListGrid.headerButtonConstructor} is set to {@link com.smartgwt.client.widgets.StretchImgButton} or a subclass thereof.
     *
     * @return Current headerTitleStyle value. Default value is null
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getHeaderTitleStyle()  {
        return getAttributeAsString("headerTitleStyle");
    }
    

    /**
     * Marks field as initially hidden.<br> The user will still be able to show the field via a context menu.  This may be
     * suppressed by setting {@link com.smartgwt.client.widgets.grid.ListGridField#getCanHide canHide} to false, or by  setting
     * {@link com.smartgwt.client.widgets.grid.ListGrid#getCanPickFields ListGrid.canPickFields} to false to suppress the
     * field-picker entirely. <p> To mark a field as completely hidden (not shown to a user at all, in any component), set
     * {@link com.smartgwt.client.data.DataSourceField#getHidden DataSourceField.hidden} instead.
     *
     * @param hidden New hidden value. Default value is null
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setHidden(Boolean hidden) {
        setAttribute("hidden", hidden);
    }

    /**
     * Marks field as initially hidden.<br> The user will still be able to show the field via a context menu.  This may be
     * suppressed by setting {@link com.smartgwt.client.widgets.grid.ListGridField#getCanHide canHide} to false, or by  setting
     * {@link com.smartgwt.client.widgets.grid.ListGrid#getCanPickFields ListGrid.canPickFields} to false to suppress the
     * field-picker entirely. <p> To mark a field as completely hidden (not shown to a user at all, in any component), set
     * {@link com.smartgwt.client.data.DataSourceField#getHidden DataSourceField.hidden} instead.
     *
     * @return Current hidden value. Default value is null
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Boolean getHidden()  {
        return getAttributeAsBoolean("hidden", true);
    }
    

    /**
     * If set to true, custom HTML applied as part of hiliting will be applied after {@link
     * com.smartgwt.client.widgets.grid.ListGrid#setCellFormatter formatting} for each cell in this column. If false, hilite
     * HTML will be applied before formatting. <P> This attribute overrides {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getHiliteHTMLAfterFormat ListGrid.hiliteHTMLAfterFormat} as defined at the
     * component level.
     *
     * @param hiliteHTMLAfterFormat New hiliteHTMLAfterFormat value. Default value is null
     */
    public void setHiliteHTMLAfterFormat(Boolean hiliteHTMLAfterFormat) {
        setAttribute("hiliteHTMLAfterFormat", hiliteHTMLAfterFormat);
    }

    /**
     * If set to true, custom HTML applied as part of hiliting will be applied after {@link
     * com.smartgwt.client.widgets.grid.ListGrid#setCellFormatter formatting} for each cell in this column. If false, hilite
     * HTML will be applied before formatting. <P> This attribute overrides {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getHiliteHTMLAfterFormat ListGrid.hiliteHTMLAfterFormat} as defined at the
     * component level.
     *
     * @return Current hiliteHTMLAfterFormat value. Default value is null
     */
    public Boolean getHiliteHTMLAfterFormat()  {
        return getAttributeAsBoolean("hiliteHTMLAfterFormat", true);
    }
    

    /**
     * Height for hilite icons for this field. Overrides {@link com.smartgwt.client.widgets.grid.ListGrid#getHiliteIconSize
     * ListGrid.hiliteIconSize}, {@link com.smartgwt.client.widgets.grid.ListGrid#getHiliteIconHeight
     * ListGrid.hiliteIconHeight}, and {@link com.smartgwt.client.widgets.grid.ListGridField#getHiliteIconSize hiliteIconSize}.
     *
     * @param hiliteIconHeight New hiliteIconHeight value. Default value is null
     * @see com.smartgwt.client.docs.Hiliting Hiliting overview and related methods
     */
    public void setHiliteIconHeight(Integer hiliteIconHeight) {
        setAttribute("hiliteIconHeight", hiliteIconHeight);
    }

    /**
     * Height for hilite icons for this field. Overrides {@link com.smartgwt.client.widgets.grid.ListGrid#getHiliteIconSize
     * ListGrid.hiliteIconSize}, {@link com.smartgwt.client.widgets.grid.ListGrid#getHiliteIconHeight
     * ListGrid.hiliteIconHeight}, and {@link com.smartgwt.client.widgets.grid.ListGridField#getHiliteIconSize hiliteIconSize}.
     *
     * @return Current hiliteIconHeight value. Default value is null
     * @see com.smartgwt.client.docs.Hiliting Hiliting overview and related methods
     */
    public Integer getHiliteIconHeight()  {
        return getAttributeAsInt("hiliteIconHeight");
    }
    

    /**
     * How much padding should there be on the left of {@link com.smartgwt.client.widgets.DataBoundComponent#getHiliteIcons
     * hilite icons} for this field? Overrides {@link com.smartgwt.client.widgets.grid.ListGrid#getHiliteIconLeftPadding
     * ListGrid.hiliteIconLeftPadding}
     *
     * @param hiliteIconLeftPadding New hiliteIconLeftPadding value. Default value is null
     * @see com.smartgwt.client.docs.Hiliting Hiliting overview and related methods
     */
    public void setHiliteIconLeftPadding(Integer hiliteIconLeftPadding) {
        setAttribute("hiliteIconLeftPadding", hiliteIconLeftPadding);
    }

    /**
     * How much padding should there be on the left of {@link com.smartgwt.client.widgets.DataBoundComponent#getHiliteIcons
     * hilite icons} for this field? Overrides {@link com.smartgwt.client.widgets.grid.ListGrid#getHiliteIconLeftPadding
     * ListGrid.hiliteIconLeftPadding}
     *
     * @return Current hiliteIconLeftPadding value. Default value is null
     * @see com.smartgwt.client.docs.Hiliting Hiliting overview and related methods
     */
    public Integer getHiliteIconLeftPadding()  {
        return getAttributeAsInt("hiliteIconLeftPadding");
    }
    

    /**
     * When {@link com.smartgwt.client.widgets.grid.ListGrid#getHiliteIcons ListGrid.hiliteIcons} are present, where the hilite
     * icon will be placed relative to the field value.  See {@link com.smartgwt.client.types.HiliteIconPosition}. Overrides
     * {@link com.smartgwt.client.widgets.grid.ListGrid#getHiliteIconPosition ListGrid.hiliteIconPosition}.
     *
     * @param hiliteIconPosition New hiliteIconPosition value. Default value is null
     * @see com.smartgwt.client.docs.Hiliting Hiliting overview and related methods
     */
    public void setHiliteIconPosition(HiliteIconPosition hiliteIconPosition) {
        setAttribute("hiliteIconPosition", hiliteIconPosition == null ? null : hiliteIconPosition.getValue());
    }

    /**
     * When {@link com.smartgwt.client.widgets.grid.ListGrid#getHiliteIcons ListGrid.hiliteIcons} are present, where the hilite
     * icon will be placed relative to the field value.  See {@link com.smartgwt.client.types.HiliteIconPosition}. Overrides
     * {@link com.smartgwt.client.widgets.grid.ListGrid#getHiliteIconPosition ListGrid.hiliteIconPosition}.
     *
     * @return Current hiliteIconPosition value. Default value is null
     * @see com.smartgwt.client.docs.Hiliting Hiliting overview and related methods
     */
    public HiliteIconPosition getHiliteIconPosition()  {
        return EnumUtil.getEnum(HiliteIconPosition.values(), getAttribute("hiliteIconPosition"));
    }
    

    /**
     * How much padding should there be on the right of {@link com.smartgwt.client.widgets.DataBoundComponent#getHiliteIcons
     * hilite icons} for this field? Overrides {@link com.smartgwt.client.widgets.grid.ListGrid#getHiliteIconRightPadding
     * ListGrid.hiliteIconRightPadding}
     *
     * @param hiliteIconRightPadding New hiliteIconRightPadding value. Default value is null
     * @see com.smartgwt.client.docs.Hiliting Hiliting overview and related methods
     */
    public void setHiliteIconRightPadding(Integer hiliteIconRightPadding) {
        setAttribute("hiliteIconRightPadding", hiliteIconRightPadding);
    }

    /**
     * How much padding should there be on the right of {@link com.smartgwt.client.widgets.DataBoundComponent#getHiliteIcons
     * hilite icons} for this field? Overrides {@link com.smartgwt.client.widgets.grid.ListGrid#getHiliteIconRightPadding
     * ListGrid.hiliteIconRightPadding}
     *
     * @return Current hiliteIconRightPadding value. Default value is null
     * @see com.smartgwt.client.docs.Hiliting Hiliting overview and related methods
     */
    public Integer getHiliteIconRightPadding()  {
        return getAttributeAsInt("hiliteIconRightPadding");
    }
    

    /**
     * Default width and height of {@link com.smartgwt.client.widgets.grid.ListGrid#getHiliteIcons hilite icons} in this field.
     * Takes precedence over hiliteIconWidth, hiliteIconHeight and hiliteIconSize specified at the component level. Can be
     * overridden via {@link com.smartgwt.client.widgets.grid.ListGridField#getHiliteIconWidth hiliteIconWidth} and {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getHiliteIconHeight hiliteIconHeight}
     *
     * @param hiliteIconSize New hiliteIconSize value. Default value is null
     * @see com.smartgwt.client.widgets.grid.ListGrid#setHiliteIconSize
     * @see com.smartgwt.client.widgets.grid.ListGridField#setHiliteIconWidth
     * @see com.smartgwt.client.widgets.grid.ListGridField#setHiliteIconHeight
     * @see com.smartgwt.client.docs.Hiliting Hiliting overview and related methods
     */
    public void setHiliteIconSize(Integer hiliteIconSize) {
        setAttribute("hiliteIconSize", hiliteIconSize);
    }

    /**
     * Default width and height of {@link com.smartgwt.client.widgets.grid.ListGrid#getHiliteIcons hilite icons} in this field.
     * Takes precedence over hiliteIconWidth, hiliteIconHeight and hiliteIconSize specified at the component level. Can be
     * overridden via {@link com.smartgwt.client.widgets.grid.ListGridField#getHiliteIconWidth hiliteIconWidth} and {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getHiliteIconHeight hiliteIconHeight}
     *
     * @return Current hiliteIconSize value. Default value is null
     * @see com.smartgwt.client.widgets.grid.ListGrid#getHiliteIconSize
     * @see com.smartgwt.client.widgets.grid.ListGridField#getHiliteIconWidth
     * @see com.smartgwt.client.widgets.grid.ListGridField#getHiliteIconHeight
     * @see com.smartgwt.client.docs.Hiliting Hiliting overview and related methods
     */
    public Integer getHiliteIconSize()  {
        return getAttributeAsInt("hiliteIconSize");
    }
    

    /**
     * Width for hilite icons for this field. Overrides {@link com.smartgwt.client.widgets.grid.ListGrid#getHiliteIconSize
     * ListGrid.hiliteIconSize}, {@link com.smartgwt.client.widgets.grid.ListGrid#getHiliteIconWidth ListGrid.hiliteIconWidth},
     * and {@link com.smartgwt.client.widgets.grid.ListGridField#getHiliteIconSize hiliteIconSize}.
     *
     * @param hiliteIconWidth New hiliteIconWidth value. Default value is null
     * @see com.smartgwt.client.docs.Hiliting Hiliting overview and related methods
     */
    public void setHiliteIconWidth(Integer hiliteIconWidth) {
        setAttribute("hiliteIconWidth", hiliteIconWidth);
    }

    /**
     * Width for hilite icons for this field. Overrides {@link com.smartgwt.client.widgets.grid.ListGrid#getHiliteIconSize
     * ListGrid.hiliteIconSize}, {@link com.smartgwt.client.widgets.grid.ListGrid#getHiliteIconWidth ListGrid.hiliteIconWidth},
     * and {@link com.smartgwt.client.widgets.grid.ListGridField#getHiliteIconSize hiliteIconSize}.
     *
     * @return Current hiliteIconWidth value. Default value is null
     * @see com.smartgwt.client.docs.Hiliting Hiliting overview and related methods
     */
    public Integer getHiliteIconWidth()  {
        return getAttributeAsInt("hiliteIconWidth");
    }
    

    /**
     * Delay in ms for hovers shown for cells in this field. If unset, the grid's hoverDelay will be used. <p> This property
     * also governes the hoverDelay for the header button. Developers wishing to have a different delay for hovers on the
     * header can use {@link com.smartgwt.client.widgets.grid.ListGridField#getHeaderHoverDelay headerHoverDelay} in addition
     * to this property.
     *
     * @param hoverDelay New hoverDelay value. Default value is null
     */
    public void setHoverDelay(Integer hoverDelay) {
        setAttribute("hoverDelay", hoverDelay);
    }

    /**
     * Delay in ms for hovers shown for cells in this field. If unset, the grid's hoverDelay will be used. <p> This property
     * also governes the hoverDelay for the header button. Developers wishing to have a different delay for hovers on the
     * header can use {@link com.smartgwt.client.widgets.grid.ListGridField#getHeaderHoverDelay headerHoverDelay} in addition
     * to this property.
     *
     * @return Current hoverDelay value. Default value is null
     */
    public Integer getHoverDelay()  {
        return getAttributeAsInt("hoverDelay");
    }
    

    /**
     * Specifies the width of the canvas shown when the mouse hovers over cells in this field.  <P> If unset, default behavior
     * is derived from {@link com.smartgwt.client.widgets.grid.ListGrid#getHeaderHoverWidth ListGrid.headerHoverWidth}.
     *
     * @param hoverWidth New hoverWidth value. Default value is null
     */
    public void setHoverWidth(Integer hoverWidth) {
        setAttribute("hoverWidth", hoverWidth);
    }

    /**
     * Specifies the width of the canvas shown when the mouse hovers over cells in this field.  <P> If unset, default behavior
     * is derived from {@link com.smartgwt.client.widgets.grid.ListGrid#getHeaderHoverWidth ListGrid.headerHoverWidth}.
     *
     * @return Current hoverWidth value. Default value is null
     */
    public Integer getHoverWidth()  {
        return getAttributeAsInt("hoverWidth");
    }
    

    /**
     * This property may be set to customize the <code>wrap</code> attribute for the canvas shown when the mouse hovers over
     * cells in this field. Note that this causes a  soft-wrap - if set, the hover text will wrap at word boundaries. <P> If
     * unset, default behavior is derived from {@link com.smartgwt.client.widgets.grid.ListGrid#getHeaderHoverWrap
     * ListGrid.headerHoverWrap}.
     *
     * @param hoverWrap New hoverWrap value. Default value is null
     */
    public void setHoverWrap(Boolean hoverWrap) {
        setAttribute("hoverWrap", hoverWrap);
    }

    /**
     * This property may be set to customize the <code>wrap</code> attribute for the canvas shown when the mouse hovers over
     * cells in this field. Note that this causes a  soft-wrap - if set, the hover text will wrap at word boundaries. <P> If
     * unset, default behavior is derived from {@link com.smartgwt.client.widgets.grid.ListGrid#getHeaderHoverWrap
     * ListGrid.headerHoverWrap}.
     *
     * @return Current hoverWrap value. Default value is null
     */
    public Boolean getHoverWrap()  {
        return getAttributeAsBoolean("hoverWrap", true);
    }
    

    /**
     * Optional icon to show next to the title for this field. Should be set to a URL to an image. Relative paths will be
     * evaluated starting at the imgDir of this component. This URL is partial - it may be updated to indicate the current
     * disabled (etc) state of the field. <p> If {@link com.smartgwt.client.widgets.grid.ListGridField#getType field.type} is
     * set to "icon", this icon will also be shown in every cell of this field - see also {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getCellIcon field.cellIcon}. <p> To change this property after fields
     * have been passed to {@link com.smartgwt.client.widgets.grid.ListGrid#setFields ListGrid.setFields()}, use {@link
     * com.smartgwt.client.widgets.grid.ListGrid#setFieldIcon ListGrid.setFieldIcon()}.
     *
     * @param icon New icon value. Default value is null
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     */
    public void setIcon(String icon) {
        setAttribute("icon", icon);
    }

    /**
     * Optional icon to show next to the title for this field. Should be set to a URL to an image. Relative paths will be
     * evaluated starting at the imgDir of this component. This URL is partial - it may be updated to indicate the current
     * disabled (etc) state of the field. <p> If {@link com.smartgwt.client.widgets.grid.ListGridField#getType field.type} is
     * set to "icon", this icon will also be shown in every cell of this field - see also {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getCellIcon field.cellIcon}. <p> To change this property after fields
     * have been passed to {@link com.smartgwt.client.widgets.grid.ListGrid#setFields ListGrid.setFields()}, use {@link
     * com.smartgwt.client.widgets.grid.ListGrid#setFieldIcon ListGrid.setFieldIcon()}.
     *
     * @return Current icon value. Default value is null
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     */
    public String getIcon()  {
        return getAttributeAsString("icon");
    }
    

    /**
     * If {@link com.smartgwt.client.widgets.grid.ListGridField#getIcon icon} is specified, this property can be used to
     * specify the height of the icon to be displayed in the ListGrid header button. (See {@link
     * com.smartgwt.client.widgets.StatefulCanvas#getIconHeight StatefulCanvas.iconHeight})<br> If this field is editable, and
     * {@link com.smartgwt.client.widgets.grid.ListGridField#getEditorIconHeight editorIconHeight} is unset, this property will
     * be passed onto the editors for this field as {@link com.smartgwt.client.widgets.form.fields.FormItem#getIconWidth
     * FormItem.iconWidth}, which will effect the default size for {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getIcons icons} displayed in the editor.
     *
     * @param iconHeight New iconHeight value. Default value is null
     * @see com.smartgwt.client.widgets.grid.ListGridField#setIcon
     * @see com.smartgwt.client.widgets.grid.ListGridField#setIcons
     */
    public void setIconHeight(Integer iconHeight) {
        setAttribute("iconHeight", iconHeight);
    }

    /**
     * If {@link com.smartgwt.client.widgets.grid.ListGridField#getIcon icon} is specified, this property can be used to
     * specify the height of the icon to be displayed in the ListGrid header button. (See {@link
     * com.smartgwt.client.widgets.StatefulCanvas#getIconHeight StatefulCanvas.iconHeight})<br> If this field is editable, and
     * {@link com.smartgwt.client.widgets.grid.ListGridField#getEditorIconHeight editorIconHeight} is unset, this property will
     * be passed onto the editors for this field as {@link com.smartgwt.client.widgets.form.fields.FormItem#getIconWidth
     * FormItem.iconWidth}, which will effect the default size for {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getIcons icons} displayed in the editor.
     *
     * @return Current iconHeight value. Default value is null
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
     * @param iconOrientation New iconOrientation value. Default value is "left"
     * @see com.smartgwt.client.widgets.grid.ListGridField#setIcon
     */
    public void setIconOrientation(String iconOrientation) {
        setAttribute("iconOrientation", iconOrientation);
    }

    /**
     * If this field is showing an icon, should it appear to the left or right of the title?<br> Valid options are
     * <code>"left"</code> or <code>"right"</code>
     *
     * @return Current iconOrientation value. Default value is "left"
     * @see com.smartgwt.client.widgets.grid.ListGridField#getIcon
     */
    public String getIconOrientation()  {
        return getAttributeAsString("iconOrientation");
    }
    

    /**
     * If this field is editable, this property can be used to specify {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getIcons icons} to be displayed in the editors displayed for this field
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param icons New icons value. Default value is null
     * @see com.smartgwt.client.docs.Editing Editing overview and related methods
     */
    public void setIcons(FormItemIcon... icons) {
        setAttribute("icons", icons);
    }
    

    /**
     * If {@link com.smartgwt.client.widgets.grid.ListGridField#getIcon icon} is specified, this property can be used to
     * specify the size of the icon to be displayed in the ListGrid header button. (See {@link
     * com.smartgwt.client.widgets.StatefulCanvas#getIconSize StatefulCanvas.iconSize})
     *
     * @param iconSize New iconSize value. Default value is null
     * @see com.smartgwt.client.widgets.grid.ListGridField#setIcon
     */
    public void setIconSize(Integer iconSize) {
        setAttribute("iconSize", iconSize);
    }

    /**
     * If {@link com.smartgwt.client.widgets.grid.ListGridField#getIcon icon} is specified, this property can be used to
     * specify the size of the icon to be displayed in the ListGrid header button. (See {@link
     * com.smartgwt.client.widgets.StatefulCanvas#getIconSize StatefulCanvas.iconSize})
     *
     * @return Current iconSize value. Default value is null
     * @see com.smartgwt.client.widgets.grid.ListGridField#getIcon
     */
    public Integer getIconSize()  {
        return getAttributeAsInt("iconSize");
    }
    

    /**
     * Pixels between icon and title text.
     *
     * @param iconSpacing New iconSpacing value. Default value is 6
     * @see com.smartgwt.client.widgets.grid.ListGridField#setIcon
     * @see com.smartgwt.client.docs.ButtonIcon ButtonIcon overview and related methods
     */
    public void setIconSpacing(int iconSpacing) {
        setAttribute("iconSpacing", iconSpacing);
    }

    /**
     * Pixels between icon and title text.
     *
     * @return Current iconSpacing value. Default value is 6
     * @see com.smartgwt.client.widgets.grid.ListGridField#getIcon
     * @see com.smartgwt.client.docs.ButtonIcon ButtonIcon overview and related methods
     */
    public int getIconSpacing()  {
        return getAttributeAsInt("iconSpacing");
    }
    

    /**
     * If this field is editable, this property will be passed to editors displayed for cells within this field as {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getIconVAlign FormItem.iconVAlign}.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param iconVAlign New iconVAlign value. Default value is null
     * @see com.smartgwt.client.widgets.grid.ListGridField#setIcons
     * @see com.smartgwt.client.docs.Editing Editing overview and related methods
     */
    public void setIconVAlign(String iconVAlign) {
        setAttribute("iconVAlign", iconVAlign);
    }

    /**
     * If this field is editable, this property will be passed to editors displayed for cells within this field as {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getIconVAlign FormItem.iconVAlign}.
     *
     * @return Current iconVAlign value. Default value is null
     * @see com.smartgwt.client.widgets.grid.ListGridField#getIcons
     * @see com.smartgwt.client.docs.Editing Editing overview and related methods
     */
    public String getIconVAlign()  {
        return getAttributeAsString("iconVAlign");
    }
    

    /**
     * If {@link com.smartgwt.client.widgets.grid.ListGridField#getIcon icon} is specified, this property can be used to
     * specify the width of the icon to be displayed in the ListGrid header button. (See {@link
     * com.smartgwt.client.widgets.StatefulCanvas#getIconWidth StatefulCanvas.iconWidth})<br> If this field is editable, and
     * {@link com.smartgwt.client.widgets.grid.ListGridField#getEditorIconWidth editorIconWidth} is unset, this property will
     * be passed onto the editors for this field as {@link com.smartgwt.client.widgets.form.fields.FormItem#getIconWidth
     * FormItem.iconWidth}, which will effect the default size for {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getIcons icons} displayed in the editor.
     *
     * @param iconWidth New iconWidth value. Default value is null
     * @see com.smartgwt.client.widgets.grid.ListGridField#setIcon
     * @see com.smartgwt.client.widgets.grid.ListGridField#setIcons
     */
    public void setIconWidth(Integer iconWidth) {
        setAttribute("iconWidth", iconWidth);
    }

    /**
     * If {@link com.smartgwt.client.widgets.grid.ListGridField#getIcon icon} is specified, this property can be used to
     * specify the width of the icon to be displayed in the ListGrid header button. (See {@link
     * com.smartgwt.client.widgets.StatefulCanvas#getIconWidth StatefulCanvas.iconWidth})<br> If this field is editable, and
     * {@link com.smartgwt.client.widgets.grid.ListGridField#getEditorIconWidth editorIconWidth} is unset, this property will
     * be passed onto the editors for this field as {@link com.smartgwt.client.widgets.form.fields.FormItem#getIconWidth
     * FormItem.iconWidth}, which will effect the default size for {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getIcons icons} displayed in the editor.
     *
     * @return Current iconWidth value. Default value is null
     * @see com.smartgwt.client.widgets.grid.ListGridField#getIcon
     * @see com.smartgwt.client.widgets.grid.ListGridField#getIcons
     */
    public Integer getIconWidth()  {
        return getAttributeAsInt("iconWidth");
    }
    

    /**
     * If the user is navigating through the grid using the keyboard, record click or double click events may be generated via
     * keyboard interactions (see {@link com.smartgwt.client.widgets.grid.ListGrid#getGenerateClickOnSpace
     * ListGrid.generateClickOnSpace}, {@link com.smartgwt.client.widgets.grid.ListGrid#getGenerateClickOnEnter
     * ListGrid.generateClickOnEnter}, {@link com.smartgwt.client.widgets.grid.ListGrid#getGenerateDoubleClickOnSpace
     * ListGrid.generateDoubleClickOnSpace}, {@link com.smartgwt.client.widgets.grid.ListGrid#getGenerateDoubleClickOnEnter
     * ListGrid.generateDoubleClickOnEnter} and {@link com.smartgwt.client.widgets.grid.ListGrid#getArrowKeyAction
     * ListGrid.arrowKeyAction}). <P> These synthetic events have both a target row and column. Setting this flag to true
     * ensures that this field will never be considered the target for a keyboard click event.
     *
     * @param ignoreKeyboardClicks New ignoreKeyboardClicks value. Default value is null
     */
    public void setIgnoreKeyboardClicks(Boolean ignoreKeyboardClicks) {
        setAttribute("ignoreKeyboardClicks", ignoreKeyboardClicks);
    }

    /**
     * If the user is navigating through the grid using the keyboard, record click or double click events may be generated via
     * keyboard interactions (see {@link com.smartgwt.client.widgets.grid.ListGrid#getGenerateClickOnSpace
     * ListGrid.generateClickOnSpace}, {@link com.smartgwt.client.widgets.grid.ListGrid#getGenerateClickOnEnter
     * ListGrid.generateClickOnEnter}, {@link com.smartgwt.client.widgets.grid.ListGrid#getGenerateDoubleClickOnSpace
     * ListGrid.generateDoubleClickOnSpace}, {@link com.smartgwt.client.widgets.grid.ListGrid#getGenerateDoubleClickOnEnter
     * ListGrid.generateDoubleClickOnEnter} and {@link com.smartgwt.client.widgets.grid.ListGrid#getArrowKeyAction
     * ListGrid.arrowKeyAction}). <P> These synthetic events have both a target row and column. Setting this flag to true
     * ensures that this field will never be considered the target for a keyboard click event.
     *
     * @return Current ignoreKeyboardClicks value. Default value is null
     */
    public Boolean getIgnoreKeyboardClicks()  {
        return getAttributeAsBoolean("ignoreKeyboardClicks", true);
    }
    

    /**
     * Height of image shown for fieldTypes image and imageFile in this field. <P> If set to a String, assumed to be a property
     * on each record that specifies the image height.  For example, if <code>field.imageHeight</code> is "logoHeight",
     * <code>record.logoHeight</code> will control the height of the image.
     *
     * @param imageHeight New imageHeight value. Default value is 16
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
     * @return Current imageHeight value. Default value is 16
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
     * default {@link com.smartgwt.client.widgets.grid.ListGrid#getImageSize ListGrid.imageSize}. <P> If set to a String,
     * assumed to be a property on each record that specifies the image height.  For example, if <code>field.imageSize</code>
     * is "logoSize", <code>record.logoSize</code> will control the size of the image.
     *
     * @param imageSize New imageSize value. Default value is 16
     * @see com.smartgwt.client.widgets.grid.ListGridField#setImageWidth
     * @see com.smartgwt.client.widgets.grid.ListGridField#setImageHeight
     * @see com.smartgwt.client.docs.ImageColumns ImageColumns overview and related methods
     */
    public void setImageSize(int imageSize) {
        setAttribute("imageSize", imageSize);
    }

    /**
     * Size of images shown for fieldTypes image and imageFile in this field. This setting overrides the global ListGrid
     * default {@link com.smartgwt.client.widgets.grid.ListGrid#getImageSize ListGrid.imageSize}. <P> If set to a String,
     * assumed to be a property on each record that specifies the image height.  For example, if <code>field.imageSize</code>
     * is "logoSize", <code>record.logoSize</code> will control the size of the image.
     *
     * @return Current imageSize value. Default value is 16
     * @see com.smartgwt.client.widgets.grid.ListGridField#getImageWidth
     * @see com.smartgwt.client.widgets.grid.ListGridField#getImageHeight
     * @see com.smartgwt.client.docs.ImageColumns ImageColumns overview and related methods
     */
    public int getImageSize()  {
        return getAttributeAsInt("imageSize");
    }
    

    /**
     * If this field has type [{@link com.smartgwt.client.types.ListGridFieldType}] set to <code>"image"</code> and the URL for
     * the image displayed is not absolute, the path of the URL will be relative to this string<br> Alternatively, if this
     * field displays any valueIcons, this prefix will be applied to the beginning of any {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getValueIcons valueIcons} when determining the URL for the image.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param imageURLPrefix New imageURLPrefix value. Default value is null
     * @see com.smartgwt.client.docs.ImageColumns ImageColumns overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#grid_datatypes_image" target="examples">Image Example</a>
     */
    public void setImageURLPrefix(String imageURLPrefix) {
        setAttribute("imageURLPrefix", imageURLPrefix);
    }

    /**
     * If this field has type [{@link com.smartgwt.client.types.ListGridFieldType}] set to <code>"image"</code> and the URL for
     * the image displayed is not absolute, the path of the URL will be relative to this string<br> Alternatively, if this
     * field displays any valueIcons, this prefix will be applied to the beginning of any {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getValueIcons valueIcons} when determining the URL for the image.
     *
     * @return Current imageURLPrefix value. Default value is null
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
     * any editors as {@link com.smartgwt.client.widgets.form.fields.FormItem#getImageURLSuffix FormItem.imageURLSuffix}.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param imageURLSuffix New imageURLSuffix value. Default value is null
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
     * any editors as {@link com.smartgwt.client.widgets.form.fields.FormItem#getImageURLSuffix FormItem.imageURLSuffix}.
     *
     * @return Current imageURLSuffix value. Default value is null
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
     * @param imageWidth New imageWidth value. Default value is 16
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
     * @return Current imageWidth value. Default value is 16
     * @see com.smartgwt.client.widgets.grid.ListGrid#getImageSize
     * @see com.smartgwt.client.widgets.grid.ListGridField#getImageSize
     * @see com.smartgwt.client.widgets.grid.ListGridField#getImageHeight
     * @see com.smartgwt.client.docs.ImageColumns ImageColumns overview and related methods
     */
    public int getImageWidth()  {
        return getAttributeAsInt("imageWidth");
    }
    

    /**
     * Indicates this field's values should be fetched from another, related DataSource. The individual field will inherit
     * settings such as {@link com.smartgwt.client.widgets.grid.ListGridField#getType field.type} and {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getTitle field.title} from the related DataSource just like fields from
     * the primary DataSource. <P> When {@link com.smartgwt.client.widgets.grid.ListGrid#fetchData fechData()} is called, the
     * automatically created {@link com.smartgwt.client.data.DSRequest} will specify {@link
     * com.smartgwt.client.data.DSRequest#getAdditionalOutputs DSRequest.additionalOutputs} requesting the field, and any
     * {@link com.smartgwt.client.data.Criteria} generated by the component will likewise refer to the field from the related
     * DataSource. <P> It's an error to use this property if the ListGrid does not have a DataSource at all. The related
     * DataSource must be loaded or a warning will be logged and the field definition ignored. <P> This value is expected to be
     * set to the following format <code>dataSourceID.fieldName</code> where <i>dataSourceID</i> is the ID of the related
     * dataSource and <i>fieldName</i> is the name of the field from that dataSource from which you wish to retrieve values.
     * Note that if this property is set and {@link com.smartgwt.client.widgets.grid.ListGridField#getName field.name} is not
     * explicitly specified, this field's <code>name</code> will default to the <i>fieldName</i> value from this property. <p>
     * Note about automatic cache updates: "update" and "add" operations submitted automatically by this ListGrid will include
     * <code>dsRequest.additionalOutputs</code> to ensure all data necessary for cache updates is returned by the server. <p>
     * If your grid shows data that can be edited elsewhere in the UI (not by inline editing), to avoid problems with {@link
     * com.smartgwt.client.data.ResultSet} automatic cache synchronization, you may need to switch from using
     * <code>listGridField.includeFrom</code> to <code>dataSourceField.includeFrom</code>.  This is because server responses to
     * "add" and "update" operations which are initiated outside of this grid do not know about the
     * <code>listGridField.includeFrom</code> setting, and so will not automatically return data for fields included in this
     * way.  Switching to <code>dataSourceField.includeFrom</code> ensures the field is always included in server responses,
     * avoiding the issue.
     *
     * @param includeFrom New includeFrom value. Default value is null
     */
    public void setIncludeFrom(String includeFrom) {
        setAttribute("includeFrom", includeFrom);
    }

    /**
     * Indicates this field's values should be fetched from another, related DataSource. The individual field will inherit
     * settings such as {@link com.smartgwt.client.widgets.grid.ListGridField#getType field.type} and {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getTitle field.title} from the related DataSource just like fields from
     * the primary DataSource. <P> When {@link com.smartgwt.client.widgets.grid.ListGrid#fetchData fechData()} is called, the
     * automatically created {@link com.smartgwt.client.data.DSRequest} will specify {@link
     * com.smartgwt.client.data.DSRequest#getAdditionalOutputs DSRequest.additionalOutputs} requesting the field, and any
     * {@link com.smartgwt.client.data.Criteria} generated by the component will likewise refer to the field from the related
     * DataSource. <P> It's an error to use this property if the ListGrid does not have a DataSource at all. The related
     * DataSource must be loaded or a warning will be logged and the field definition ignored. <P> This value is expected to be
     * set to the following format <code>dataSourceID.fieldName</code> where <i>dataSourceID</i> is the ID of the related
     * dataSource and <i>fieldName</i> is the name of the field from that dataSource from which you wish to retrieve values.
     * Note that if this property is set and {@link com.smartgwt.client.widgets.grid.ListGridField#getName field.name} is not
     * explicitly specified, this field's <code>name</code> will default to the <i>fieldName</i> value from this property. <p>
     * Note about automatic cache updates: "update" and "add" operations submitted automatically by this ListGrid will include
     * <code>dsRequest.additionalOutputs</code> to ensure all data necessary for cache updates is returned by the server. <p>
     * If your grid shows data that can be edited elsewhere in the UI (not by inline editing), to avoid problems with {@link
     * com.smartgwt.client.data.ResultSet} automatic cache synchronization, you may need to switch from using
     * <code>listGridField.includeFrom</code> to <code>dataSourceField.includeFrom</code>.  This is because server responses to
     * "add" and "update" operations which are initiated outside of this grid do not know about the
     * <code>listGridField.includeFrom</code> setting, and so will not automatically return data for fields included in this
     * way.  Switching to <code>dataSourceField.includeFrom</code> ensures the field is always included in server responses,
     * avoiding the issue.
     *
     * @return Current includeFrom value. Default value is null
     */
    public String getIncludeFrom()  {
        return getAttributeAsString("includeFrom");
    }
    

    /**
     * If a listGrid is showing a field of type summary, should this field be passed to the recordSummaryFunction when
     * calculating the summary value to display. If unset, fields are included if they are of type "integer" or "float" only
     * (since most summary functions perform numeric calculations). See also {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getIncludeInRecordSummaryFields includeInRecordSummaryFields}.
     *
     * @param includeInRecordSummary New includeInRecordSummary value. Default value is null
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
     * @return Current includeInRecordSummary value. Default value is null
     */
    public Boolean getIncludeInRecordSummary()  {
        return getAttributeAsBoolean("includeInRecordSummary", true);
    }
    

    /**
     * If this listGrid has any fields of type <code>"summary"</code> and this field will be {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getIncludeInRecordSummary included} in summary calculations by default,
     * this attribute provides an opportunity to explicitly specify which summary fields the record should be displayed in. <P>
     * Specified as an array of fieldNames. If set, this field value will only be included for record summary value
     * calculations for summary fields who's name is included in this array.
     *
     * @param includeInRecordSummaryFields New includeInRecordSummaryFields value. Default value is null
     * @see com.smartgwt.client.docs.FieldName FieldName 
     */
    public void setIncludeInRecordSummaryFields(String... includeInRecordSummaryFields) {
        setAttribute("includeInRecordSummaryFields", includeInRecordSummaryFields);
    }

    /**
     * If this listGrid has any fields of type <code>"summary"</code> and this field will be {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getIncludeInRecordSummary included} in summary calculations by default,
     * this attribute provides an opportunity to explicitly specify which summary fields the record should be displayed in. <P>
     * Specified as an array of fieldNames. If set, this field value will only be included for record summary value
     * calculations for summary fields who's name is included in this array.
     *
     * @return Current includeInRecordSummaryFields value. Default value is null
     * @see com.smartgwt.client.docs.FieldName FieldName 
     */
    public String[] getIncludeInRecordSummaryFields()  {
        return com.smartgwt.client.util.ConvertTo.arrayOfString(getAttributeAsJavaScriptObject("includeInRecordSummaryFields"));
    }
    

    /**
     * In an editable ListGrid, initial value for this field when the user begins editing a new record. <p>
     * <code>initialValue</code> applies only if a new record is created by end user action (such as navigating past the end of
     * the data when {@link com.smartgwt.client.widgets.grid.ListGrid#getListEndEditAction ListGrid.listEndEditAction} is
     * "next") or by a call to {@link com.smartgwt.client.widgets.grid.ListGrid#startEditingNew ListGrid.startEditingNew()}
     * that <i>does not specify the <code>initialValues</code></i> argument.
     *
     * @param initialValue New initialValue value. Default value is null
     * @see com.smartgwt.client.docs.Editing Editing overview and related methods
     */
    public void setInitialValue(Object initialValue) {
        setAttribute("initialValue", initialValue);
    }

    /**
     * In an editable ListGrid, initial value for this field when the user begins editing a new record. <p>
     * <code>initialValue</code> applies only if a new record is created by end user action (such as navigating past the end of
     * the data when {@link com.smartgwt.client.widgets.grid.ListGrid#getListEndEditAction ListGrid.listEndEditAction} is
     * "next") or by a call to {@link com.smartgwt.client.widgets.grid.ListGrid#startEditingNew ListGrid.startEditingNew()}
     * that <i>does not specify the <code>initialValues</code></i> argument.
     *
     * @return Current initialValue value. Default value is null
     * @see com.smartgwt.client.docs.Editing Editing overview and related methods
     */
    public Object getInitialValue()  {
        return getAttributeAsObject("initialValue");
    }
    
    

    /**
     * If set to true and {@link com.smartgwt.client.widgets.grid.ListGrid#getCanRemoveRecords ListGrid.canRemoveRecords} is
     * true, this field will be rendered as the remove-field for this grid. In most common usage scenarios this field will
     * essentially be a placeholder indicating where the remove field should be rendered, meaning properties other than
     * <code>isRemoveField</code>, such as <code>name</code> or <code>title</code>, may be left unset.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param isRemoveField New isRemoveField value. Default value is null
     * @see com.smartgwt.client.widgets.grid.ListGrid#setCanRemoveRecords
     */
    public void setIsRemoveField(Boolean isRemoveField) {
        setAttribute("isRemoveField", isRemoveField);
    }

    /**
     * If set to true and {@link com.smartgwt.client.widgets.grid.ListGrid#getCanRemoveRecords ListGrid.canRemoveRecords} is
     * true, this field will be rendered as the remove-field for this grid. In most common usage scenarios this field will
     * essentially be a placeholder indicating where the remove field should be rendered, meaning properties other than
     * <code>isRemoveField</code>, such as <code>name</code> or <code>title</code>, may be left unset.
     *
     * @return Current isRemoveField value. Default value is null
     * @see com.smartgwt.client.widgets.grid.ListGrid#getCanRemoveRecords
     */
    public Boolean getIsRemoveField()  {
        return getAttributeAsBoolean("isRemoveField", true);
    }
    

    /**
     * If {@link com.smartgwt.client.widgets.grid.ListGrid#getShowHeaderMenuButton ListGrid.showHeaderMenuButton} is true, when
     * auto-fitting fields to the title width via {@link com.smartgwt.client.widgets.grid.ListGrid#getAutoFitFieldWidths
     * ListGrid.autoFitFieldWidths} or {@link com.smartgwt.client.widgets.grid.ListGridField#getAutoFitWidth autoFitWidth},
     * should the button be sized such that there is enough space for the header menu button to show without covering the field
     * title? <P> May be explicitly specified at the {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getLeaveHeaderMenuButtonSpace field level} or at the {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getLeaveHeaderMenuButtonSpace grid level}. If not explicitly specified space
     * will be left for fields with {@link com.smartgwt.client.widgets.grid.ListGridField#getAlign align} set to
     * <code>"left"</code> or <code>"right"</code>, but not for fields with align set to <code>"center"</code>.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param leaveHeaderMenuButtonSpace New leaveHeaderMenuButtonSpace value. Default value is null
     */
    public void setLeaveHeaderMenuButtonSpace(Boolean leaveHeaderMenuButtonSpace) {
        setAttribute("leaveHeaderMenuButtonSpace", leaveHeaderMenuButtonSpace);
    }
    

    /**
     * The HTML to display in cells of this field if the fieldType is set to link. <P> This property sets linkText that will be
     * the same for all records.  You can set linkText on a per-record basis via {@link
     * com.smartgwt.client.widgets.grid.ListGridRecord#getLinkText ListGridRecord.linkText}.
     *
     * @param linkText New linkText value. Default value is null
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
     * The HTML to display in cells of this field if the fieldType is set to link. <P> This property sets linkText that will be
     * the same for all records.  You can set linkText on a per-record basis via {@link
     * com.smartgwt.client.widgets.grid.ListGridRecord#getLinkText ListGridRecord.linkText}.
     *
     * @return Current linkText value. Default value is null
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
     * Name of the property in a ListGridRecord that holds the HTML to display in cells of this field if the fieldType is set
     * to "link".
     *
     * @param linkTextProperty New linkTextProperty value. Default value is null
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
     * Name of the property in a ListGridRecord that holds the HTML to display in cells of this field if the fieldType is set
     * to "link".
     *
     * @return Current linkTextProperty value. Default value is null
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
     * @param linkURLPrefix New linkURLPrefix value. Default value is null
     */
    public void setLinkURLPrefix(String linkURLPrefix) {
        setAttribute("linkURLPrefix", linkURLPrefix);
    }

    /**
     * If this field has type [{@link com.smartgwt.client.types.ListGridFieldType}] set to <code>"link"</code>, setting this
     * property will apply a standard prefix to the link URL for cells in this field.
     *
     * @return Current linkURLPrefix value. Default value is null
     */
    public String getLinkURLPrefix()  {
        return getAttributeAsString("linkURLPrefix");
    }
    

    /**
     * If this field has type [{@link com.smartgwt.client.types.ListGridFieldType}] set to <code>"link"</code>, setting this
     * property will apply a standard suffix to the link URL for cells in this field.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param linkURLSuffix New linkURLSuffix value. Default value is null
     */
    public void setLinkURLSuffix(String linkURLSuffix) {
        setAttribute("linkURLSuffix", linkURLSuffix);
    }

    /**
     * If this field has type [{@link com.smartgwt.client.types.ListGridFieldType}] set to <code>"link"</code>, setting this
     * property will apply a standard suffix to the link URL for cells in this field.
     *
     * @return Current linkURLSuffix value. Default value is null
     */
    public String getLinkURLSuffix()  {
        return getAttributeAsString("linkURLSuffix");
    }
    

    /**
     * When {@link com.smartgwt.client.widgets.grid.ListGrid#getShowHeader ListGrid.showHeader} is false and a field is subject
     * to autofitting (see {@link com.smartgwt.client.widgets.grid.ListGrid#getAutoFitFieldWidths
     * ListGrid.autoFitFieldWidths}), sets the maximum width of the field.  The actual effective maximum will be the largest of
     * this property, {@link com.smartgwt.client.widgets.grid.ListGridField#getMinWidth minWidth}, and  {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getMinFieldWidth ListGrid.minFieldWidth}.  That is, {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getMinWidth minWidth} and  {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getMinFieldWidth ListGrid.minFieldWidth} dominate this property.
     *
     * @param maxWidth New maxWidth value. Default value is null
     * @see com.smartgwt.client.widgets.grid.ListGridField#setWidth
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setMaxWidth(Integer maxWidth) {
        setAttribute("maxWidth", maxWidth);
    }

    /**
     * When {@link com.smartgwt.client.widgets.grid.ListGrid#getShowHeader ListGrid.showHeader} is false and a field is subject
     * to autofitting (see {@link com.smartgwt.client.widgets.grid.ListGrid#getAutoFitFieldWidths
     * ListGrid.autoFitFieldWidths}), sets the maximum width of the field.  The actual effective maximum will be the largest of
     * this property, {@link com.smartgwt.client.widgets.grid.ListGridField#getMinWidth minWidth}, and  {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getMinFieldWidth ListGrid.minFieldWidth}.  That is, {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getMinWidth minWidth} and  {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getMinFieldWidth ListGrid.minFieldWidth} dominate this property.
     *
     * @return Current maxWidth value. Default value is null
     * @see com.smartgwt.client.widgets.grid.ListGridField#getWidth
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Integer getMaxWidth()  {
        return getAttributeAsInt("maxWidth");
    }
    

    /**
     * When a field is subject to autofitting (see {@link com.smartgwt.client.widgets.grid.ListGrid#getAutoFitFieldWidths
     * ListGrid.autoFitFieldWidths}), sets the minimum width of the field.  The actual allowed minimum will be the maximum
     * of:<ul> <li> this property, <li> {@link com.smartgwt.client.widgets.grid.ListGridField#getWidth width} (if a number),
     * <li> the aufofit value determined by the widest value content in this field's column <li> {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getMinFieldWidth ListGrid.minFieldWidth} </ul>
     *
     * @param minWidth New minWidth value. Default value is null
     * @see com.smartgwt.client.widgets.grid.ListGridField#setWidth
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setMinWidth(Integer minWidth) {
        setAttribute("minWidth", minWidth);
    }

    /**
     * When a field is subject to autofitting (see {@link com.smartgwt.client.widgets.grid.ListGrid#getAutoFitFieldWidths
     * ListGrid.autoFitFieldWidths}), sets the minimum width of the field.  The actual allowed minimum will be the maximum
     * of:<ul> <li> this property, <li> {@link com.smartgwt.client.widgets.grid.ListGridField#getWidth width} (if a number),
     * <li> the aufofit value determined by the widest value content in this field's column <li> {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getMinFieldWidth ListGrid.minFieldWidth} </ul>
     *
     * @return Current minWidth value. Default value is null
     * @see com.smartgwt.client.widgets.grid.ListGridField#getWidth
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Integer getMinWidth()  {
        return getAttributeAsInt("minWidth");
    }
    

    /**
     * Indicates that this field should always be Array-valued. This property will be passed through to the generated edit-item
     * when editing the field - so if {@link com.smartgwt.client.widgets.grid.ListGridField#getValueMap valueMap} is set, the
     * default editor will be a {@link com.smartgwt.client.widgets.form.fields.SelectItem} with {@link
     * com.smartgwt.client.widgets.form.fields.SelectItem#getMultiple SelectItem.multiple} set to true. <P> Note that for
     * databound grids it typically makes sense to set {@link com.smartgwt.client.data.DataSourceField#getMultiple
     * DataSourceField.multiple} rather than setting the property directly on the ListGridField object.
     *
     * @param multiple New multiple value. Default value is false
     * @see com.smartgwt.client.docs.Editing Editing overview and related methods
     */
    public void setMultiple(Boolean multiple) {
        setAttribute("multiple", multiple);
    }

    /**
     * Indicates that this field should always be Array-valued. This property will be passed through to the generated edit-item
     * when editing the field - so if {@link com.smartgwt.client.widgets.grid.ListGridField#getValueMap valueMap} is set, the
     * default editor will be a {@link com.smartgwt.client.widgets.form.fields.SelectItem} with {@link
     * com.smartgwt.client.widgets.form.fields.SelectItem#getMultiple SelectItem.multiple} set to true. <P> Note that for
     * databound grids it typically makes sense to set {@link com.smartgwt.client.data.DataSourceField#getMultiple
     * DataSourceField.multiple} rather than setting the property directly on the ListGridField object.
     *
     * @return Current multiple value. Default value is false
     * @see com.smartgwt.client.docs.Editing Editing overview and related methods
     */
    public Boolean getMultiple()  {
        Boolean result = getAttributeAsBoolean("multiple", true);
        return result == null ? false : result;
    }
    

    /**
     * Name of this field.  Must be unique within this ListGrid as well as a valid JavaScript identifier - see {@link
     * com.smartgwt.client.docs.FieldName} for details and how to check for validity. <P> The name of field is also the
     * property in each record which holds the value for that field. <P> If a {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getDataSource ListGrid.dataSource} is specified and the DataSource has a field
     * with the same name, the ListGridField and DataSourceField are merged, with any properties on the ListGridField
     * overriding those on the DataSourceField.
     *
     * @param name New name value. Default value is null
     * @see com.smartgwt.client.docs.FieldName FieldName 
     */
    public void setName(String name) {
        setAttribute("name", name);
    }

    /**
     * Name of this field.  Must be unique within this ListGrid as well as a valid JavaScript identifier - see {@link
     * com.smartgwt.client.docs.FieldName} for details and how to check for validity. <P> The name of field is also the
     * property in each record which holds the value for that field. <P> If a {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getDataSource ListGrid.dataSource} is specified and the DataSource has a field
     * with the same name, the ListGridField and DataSourceField are merged, with any properties on the ListGridField
     * overriding those on the DataSourceField.
     *
     * @return Current name value. Default value is null
     * @see com.smartgwt.client.docs.FieldName FieldName 
     */
    public String getName()  {
        return getAttributeAsString("name");
    }
    

    /**
     * This value is managed by the menu item titled {@link com.smartgwt.client.widgets.grid.ListGrid#getFilterUsingText
     * "Filter using"}
     *  in the {@link com.smartgwt.client.widgets.grid.ListGrid#getShowHeaderContextMenu headerContextMenu} that appears when  
     *  {@link com.smartgwt.client.widgets.grid.ListGrid#getAllowFilterOperators allowFilterOperators} has been set to true.
     *  <p>
     * If you need to reset this filter operator you should call {@link
     * com.smartgwt.client.widgets.grid.ListGrid#setFieldProperties listGrid.setFieldProperties}, as in this example:
     *  <pre>
     *     listGrid.setFieldProperties(fieldName, {operator: null});</pre>
     *  Note that this property is not listed as "initializable" and is not intended as a means
     *  of applying a default operator to the field.  Rather, it simply reflects any non-default
     * operator already applied to menu item {@link com.smartgwt.client.widgets.grid.ListGrid#getFilterUsingText "Filter
     * using"}.
     * Use {@link com.smartgwt.client.widgets.grid.ListGridField#getFilterOperator filterOperator} to specify the default
     * operator for the field.
     *
     * @return Current operator value. Default value is null
     * @see com.smartgwt.client.widgets.grid.ListGridField#getFilterOperator
     */
    public String getOperator()  {
        return getAttributeAsString("operator");
    }
    

    /**
     * If {@link com.smartgwt.client.widgets.grid.ListGridField#getOptionDataSource optionDataSource} is set for this
     * ListGridField, criteria specified in this attribute will be passed to the dataSource when performing the fetch operation
     * to determine data-value to display-value mappings
     *
     * @param optionCriteria New optionCriteria value. Default value is null
     */
    public void setOptionCriteria(Criteria optionCriteria) {
        if (optionCriteria instanceof Criterion) {
            optionCriteria.setAttribute("_constructor", "AdvancedCriteria");
        }
        setAttribute("optionCriteria", optionCriteria == null ? null : optionCriteria.getJsObj());
    }

    /**
     * If {@link com.smartgwt.client.widgets.grid.ListGridField#getOptionDataSource optionDataSource} is set for this
     * ListGridField, criteria specified in this attribute will be passed to the dataSource when performing the fetch operation
     * to determine data-value to display-value mappings
     *
     * @return Current optionCriteria value. Default value is null
     */
    public Criteria getOptionCriteria()  {
        return new Criteria(getAttributeAsJavaScriptObject("optionCriteria"));
    }
    
    
    

    /**
     * If this field has an optionDataSource specified and {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getAutoFetchDisplayMap autoFetchDisplayMap} is set, this attribute
     * provides a way to customize the {@link com.smartgwt.client.data.DSRequest#getOperationId DSRequest.operationId} passed
     * to <code>dataSource.fetchData()</code> when retrieving the display map from the option dataSource.
     *
     * @param optionOperationId New optionOperationId value. Default value is null
     */
    public void setOptionOperationId(String optionOperationId) {
        setAttribute("optionOperationId", optionOperationId);
    }

    /**
     * If this field has an optionDataSource specified and {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getAutoFetchDisplayMap autoFetchDisplayMap} is set, this attribute
     * provides a way to customize the {@link com.smartgwt.client.data.DSRequest#getOperationId DSRequest.operationId} passed
     * to <code>dataSource.fetchData()</code> when retrieving the display map from the option dataSource.
     *
     * @return Current optionOperationId value. Default value is null
     */
    public String getOptionOperationId()  {
        return getAttributeAsString("optionOperationId");
    }
    

    /**
     * For fields with an {@link com.smartgwt.client.widgets.grid.ListGridField#getOptionDataSource optionDataSource}, where
     * {@link com.smartgwt.client.widgets.grid.ListGridField#getAutoFetchDisplayMap autoFetchDisplayMap} is true, this property
     * will govern the <code>textMatchStyle</code> attribute of the {@link com.smartgwt.client.data.DSRequest} parameter passed
     * to {@link com.smartgwt.client.data.DataSource#fetchData DataSource.fetchData()} when retrieving the remote data set to
     * be used as a basis for this field's valueMap.
     *
     * @param optionTextMatchStyle New optionTextMatchStyle value. Default value is null
     */
    public void setOptionTextMatchStyle(TextMatchStyle optionTextMatchStyle) {
        setAttribute("optionTextMatchStyle", optionTextMatchStyle == null ? null : optionTextMatchStyle.getValue());
    }

    /**
     * For fields with an {@link com.smartgwt.client.widgets.grid.ListGridField#getOptionDataSource optionDataSource}, where
     * {@link com.smartgwt.client.widgets.grid.ListGridField#getAutoFetchDisplayMap autoFetchDisplayMap} is true, this property
     * will govern the <code>textMatchStyle</code> attribute of the {@link com.smartgwt.client.data.DSRequest} parameter passed
     * to {@link com.smartgwt.client.data.DataSource#fetchData DataSource.fetchData()} when retrieving the remote data set to
     * be used as a basis for this field's valueMap.
     *
     * @return Current optionTextMatchStyle value. Default value is null
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
     * @param partialSummary New partialSummary value. Default value is null
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
     * @return Current partialSummary value. Default value is null
     */
    public Boolean getPartialSummary()  {
        return getAttributeAsBoolean("partialSummary", true);
    }
    

    /**
     * Causes a tooltip hover to appear on the header generated for this field (effectively sets {@link
     * com.smartgwt.client.widgets.Canvas#getPrompt Canvas.prompt} for the header).
     *
     * @param prompt New prompt value. Default value is null
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public void setPrompt(String prompt) {
        setAttribute("prompt", prompt);
    }

    /**
     * Causes a tooltip hover to appear on the header generated for this field (effectively sets {@link
     * com.smartgwt.client.widgets.Canvas#getPrompt Canvas.prompt} for the header).
     *
     * @return Current prompt value. Default value is null
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public String getPrompt()  {
        return getAttributeAsString("prompt");
    }
    
    

    /**
     * When the user edits cells in this field, is this value required to be non-empty in order for validation to pass.<br>
     * Note: for databound listGrids, this property may be specified on the {@link com.smartgwt.client.data.DataSourceField},
     * enabling both client and server side validation.
     *
     * @param required New required value. Default value is false
     * @see com.smartgwt.client.widgets.grid.ListGridField#setValidators
     * @see com.smartgwt.client.docs.GridValidation GridValidation overview and related methods
     */
    public void setRequired(Boolean required) {
        setAttribute("required", required);
    }

    /**
     * When the user edits cells in this field, is this value required to be non-empty in order for validation to pass.<br>
     * Note: for databound listGrids, this property may be specified on the {@link com.smartgwt.client.data.DataSourceField},
     * enabling both client and server side validation.
     *
     * @return Current required value. Default value is false
     * @see com.smartgwt.client.widgets.grid.ListGridField#getValidators
     * @see com.smartgwt.client.docs.GridValidation GridValidation overview and related methods
     */
    public Boolean getRequired()  {
        Boolean result = getAttributeAsBoolean("required", true);
        return result == null ? false : result;
    }
    

    /**
     * Whether to rotate the field's title so it's rendered vertically from bottom to top. If unset, default behavior is
     * derived from {@link com.smartgwt.client.widgets.grid.ListGrid#getRotateHeaderTitles ListGrid.rotateHeaderTitles}.
     *
     * @param rotateTitle New rotateTitle value. Default value is null
     * @see com.smartgwt.client.widgets.grid.ListGrid#setRotateHeaderTitles
     */
    public void setRotateTitle(Boolean rotateTitle) {
        setAttribute("rotateTitle", rotateTitle);
    }

    /**
     * Whether to rotate the field's title so it's rendered vertically from bottom to top. If unset, default behavior is
     * derived from {@link com.smartgwt.client.widgets.grid.ListGrid#getRotateHeaderTitles ListGrid.rotateHeaderTitles}.
     *
     * @return Current rotateTitle value. Default value is null
     * @see com.smartgwt.client.widgets.grid.ListGrid#getRotateHeaderTitles
     */
    public Boolean getRotateTitle()  {
        return getAttributeAsBoolean("rotateTitle", true);
    }
    

    /**
     * Should the cell content be natively selected (ready for copying to clip-board)  on click? <P> See {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getSelectCellTextOnClick ListGrid.selectCellTextOnClick} for more information.
     *
     * @param selectCellTextOnClick New selectCellTextOnClick value. Default value is null
     */
    public void setSelectCellTextOnClick(Boolean selectCellTextOnClick) {
        setAttribute("selectCellTextOnClick", selectCellTextOnClick);
    }

    /**
     * Should the cell content be natively selected (ready for copying to clip-board)  on click? <P> See {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getSelectCellTextOnClick ListGrid.selectCellTextOnClick} for more information.
     *
     * @return Current selectCellTextOnClick value. Default value is null
     */
    public Boolean getSelectCellTextOnClick()  {
        return getAttributeAsBoolean("selectCellTextOnClick", true);
    }
    

    /**
     * Whether this field should be included in the printable representation of the grid.
     *
     * @param shouldPrint New shouldPrint value. Default value is null
     * @see com.smartgwt.client.docs.Printing Printing overview and related methods
     */
    public void setShouldPrint(Boolean shouldPrint) {
        setAttribute("shouldPrint", shouldPrint);
    }

    /**
     * Whether this field should be included in the printable representation of the grid.
     *
     * @return Current shouldPrint value. Default value is null
     * @see com.smartgwt.client.docs.Printing Printing overview and related methods
     */
    public Boolean getShouldPrint()  {
        return getAttributeAsBoolean("shouldPrint", true);
    }
    

    /**
     * When set to false, don't apply alternate-row styling to this field.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param showAlternateStyle New showAlternateStyle value. Default value is null
     */
    public void setShowAlternateStyle(Boolean showAlternateStyle) {
        setAttribute("showAlternateStyle", showAlternateStyle);
    }

    /**
     * When set to false, don't apply alternate-row styling to this field.
     *
     * @return Current showAlternateStyle value. Default value is null
     */
    public Boolean getShowAlternateStyle()  {
        return getAttributeAsBoolean("showAlternateStyle", true);
    }
    

    /**
     * When set to false, this field will not show a context menu in its header.
     *
     * @param showDefaultContextMenu New showDefaultContextMenu value. Default value is true
     */
    public void setShowDefaultContextMenu(Boolean showDefaultContextMenu) {
        setAttribute("showDefaultContextMenu", showDefaultContextMenu);
    }

    /**
     * When set to false, this field will not show a context menu in its header.
     *
     * @return Current showDefaultContextMenu value. Default value is true
     */
    public Boolean getShowDefaultContextMenu()  {
        Boolean result = getAttributeAsBoolean("showDefaultContextMenu", true);
        return result == null ? true : result;
    }
    

    /**
     * If using an icon for this button, whether to switch the icon image if the button becomes disabled.
     *
     * @param showDisabledIcon New showDisabledIcon value. Default value is true
     * @see com.smartgwt.client.widgets.grid.ListGridField#setIcon
     * @see com.smartgwt.client.docs.ButtonIcon ButtonIcon overview and related methods
     */
    public void setShowDisabledIcon(Boolean showDisabledIcon) {
        setAttribute("showDisabledIcon", showDisabledIcon);
    }

    /**
     * If using an icon for this button, whether to switch the icon image if the button becomes disabled.
     *
     * @return Current showDisabledIcon value. Default value is true
     * @see com.smartgwt.client.widgets.grid.ListGridField#getIcon
     * @see com.smartgwt.client.docs.ButtonIcon ButtonIcon overview and related methods
     */
    public Boolean getShowDisabledIcon()  {
        Boolean result = getAttributeAsBoolean("showDisabledIcon", true);
        return result == null ? true : result;
    }
    

    /**
     * If using an icon for this button, whether to switch the icon image when the mouse goes down on the button.
     *
     * @param showDownIcon New showDownIcon value. Default value is false
     * @see com.smartgwt.client.widgets.grid.ListGridField#setIcon
     * @see com.smartgwt.client.docs.ButtonIcon ButtonIcon overview and related methods
     */
    public void setShowDownIcon(Boolean showDownIcon) {
        setAttribute("showDownIcon", showDownIcon);
    }

    /**
     * If using an icon for this button, whether to switch the icon image when the mouse goes down on the button.
     *
     * @return Current showDownIcon value. Default value is false
     * @see com.smartgwt.client.widgets.grid.ListGridField#getIcon
     * @see com.smartgwt.client.docs.ButtonIcon ButtonIcon overview and related methods
     */
    public Boolean getShowDownIcon()  {
        Boolean result = getAttributeAsBoolean("showDownIcon", true);
        return result == null ? false : result;
    }
    

    /**
     * Should ellipses be displayed when this field's cell content is clipped? To set this  property at the grid level, use
     * {@link com.smartgwt.client.widgets.grid.ListGrid#getShowEllipsisWhenClipped ListGrid.showEllipsisWhenClipped}
     *
     * @param showEllipsisWhenClipped New showEllipsisWhenClipped value. Default value is null
     */
    public void setShowEllipsisWhenClipped(Boolean showEllipsisWhenClipped) {
        setAttribute("showEllipsisWhenClipped", showEllipsisWhenClipped);
    }

    /**
     * Should ellipses be displayed when this field's cell content is clipped? To set this  property at the grid level, use
     * {@link com.smartgwt.client.widgets.grid.ListGrid#getShowEllipsisWhenClipped ListGrid.showEllipsisWhenClipped}
     *
     * @return Current showEllipsisWhenClipped value. Default value is null
     */
    public Boolean getShowEllipsisWhenClipped()  {
        return getAttributeAsBoolean("showEllipsisWhenClipped", true);
    }
    

    /**
     * For a field of type:"imageFile", indicates whether to stream the image and display it inline or to display the View and
     * Download icons.
     *
     * @param showFileInline New showFileInline value. Default value is null
     */
    public void setShowFileInline(Boolean showFileInline) {
        setAttribute("showFileInline", showFileInline);
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
     * If using an icon for this button, whether to switch the icon image when the button receives focus. <P> If {@link
     * com.smartgwt.client.widgets.StatefulCanvas#getShowFocusedAsOver StatefulCanvas.showFocusedAsOver} is true, the
     * <code>"Over"</code> icon will be displayed when the canvas has focus, otherwise a separate <code>"Focused"</code> icon
     * will be displayed
     *
     * @param showFocusedIcon New showFocusedIcon value. Default value is false
     * @see com.smartgwt.client.widgets.grid.ListGridField#setIcon
     * @see com.smartgwt.client.docs.ButtonIcon ButtonIcon overview and related methods
     */
    public void setShowFocusedIcon(Boolean showFocusedIcon) {
        setAttribute("showFocusedIcon", showFocusedIcon);
    }

    /**
     * If using an icon for this button, whether to switch the icon image when the button receives focus. <P> If {@link
     * com.smartgwt.client.widgets.StatefulCanvas#getShowFocusedAsOver StatefulCanvas.showFocusedAsOver} is true, the
     * <code>"Over"</code> icon will be displayed when the canvas has focus, otherwise a separate <code>"Focused"</code> icon
     * will be displayed
     *
     * @return Current showFocusedIcon value. Default value is false
     * @see com.smartgwt.client.widgets.grid.ListGridField#getIcon
     * @see com.smartgwt.client.docs.ButtonIcon ButtonIcon overview and related methods
     */
    public Boolean getShowFocusedIcon()  {
        Boolean result = getAttributeAsBoolean("showFocusedIcon", true);
        return result == null ? false : result;
    }
    

    /**
     * If {@link com.smartgwt.client.widgets.grid.ListGrid#getShowGridSummary ListGrid.showGridSummary} is true, should this
     * field show a summary value. If unset, this field will show a summary value in the summary row if an explicit {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getSummaryFunction summaryFunction} is specified or if a {@link
     * com.smartgwt.client.data.SimpleType#getDefaultSummaryFunction default summary function} is defined for the specified
     * field type.
     *
     * @param showGridSummary New showGridSummary value. Default value is null
     */
    public void setShowGridSummary(Boolean showGridSummary) {
        setAttribute("showGridSummary", showGridSummary);
    }

    /**
     * If {@link com.smartgwt.client.widgets.grid.ListGrid#getShowGridSummary ListGrid.showGridSummary} is true, should this
     * field show a summary value. If unset, this field will show a summary value in the summary row if an explicit {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getSummaryFunction summaryFunction} is specified or if a {@link
     * com.smartgwt.client.data.SimpleType#getDefaultSummaryFunction default summary function} is defined for the specified
     * field type.
     *
     * @return Current showGridSummary value. Default value is null
     */
    public Boolean getShowGridSummary()  {
        return getAttributeAsBoolean("showGridSummary", true);
    }
    

    /**
     * If {@link com.smartgwt.client.widgets.grid.ListGrid#getShowGroupSummary ListGrid.showGroupSummary} is true, should this
     * field show a summary value in a summary row when the grid is grouped? If unset, this field will show a summary value in
     * the summary row if an explicit {@link com.smartgwt.client.widgets.grid.ListGridField#getSummaryFunction summaryFunction}
     * is specified or if a {@link com.smartgwt.client.data.SimpleType#getDefaultSummaryFunction default summary function} is
     * defined for the specified field type.
     *
     * @param showGroupSummary New showGroupSummary value. Default value is null
     */
    public void setShowGroupSummary(Boolean showGroupSummary) {
        setAttribute("showGroupSummary", showGroupSummary);
    }

    /**
     * If {@link com.smartgwt.client.widgets.grid.ListGrid#getShowGroupSummary ListGrid.showGroupSummary} is true, should this
     * field show a summary value in a summary row when the grid is grouped? If unset, this field will show a summary value in
     * the summary row if an explicit {@link com.smartgwt.client.widgets.grid.ListGridField#getSummaryFunction summaryFunction}
     * is specified or if a {@link com.smartgwt.client.data.SimpleType#getDefaultSummaryFunction default summary function} is
     * defined for the specified field type.
     *
     * @return Current showGroupSummary value. Default value is null
     */
    public Boolean getShowGroupSummary()  {
        return getAttributeAsBoolean("showGroupSummary", true);
    }
    

    /**
     * Determines whether hiliting for this field is shown in a group summary. Set to false to prevent this field from showing
     * hilite in a group summary. <P> All hilites in group summary rows can be controlled with the {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getShowHilitesInGroupSummary ListGrid.showHilitesInGroupSummary} property.
     *
     * @param showHilitesInGroupSummary New showHilitesInGroupSummary value. Default value is null
     */
    public void setShowHilitesInGroupSummary(Boolean showHilitesInGroupSummary) {
        setAttribute("showHilitesInGroupSummary", showHilitesInGroupSummary);
    }

    /**
     * Determines whether hiliting for this field is shown in a group summary. Set to false to prevent this field from showing
     * hilite in a group summary. <P> All hilites in group summary rows can be controlled with the {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getShowHilitesInGroupSummary ListGrid.showHilitesInGroupSummary} property.
     *
     * @return Current showHilitesInGroupSummary value. Default value is null
     */
    public Boolean getShowHilitesInGroupSummary()  {
        return getAttributeAsBoolean("showHilitesInGroupSummary", true);
    }
    

    /**
     * Whether to show hovers for this field.  The default hover will be the contents of the cell the user is hovering over,
     * and can be customized via {@link com.smartgwt.client.widgets.grid.ListGridField#hoverHTML field.hoverHTML()}. <P> {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getCanHover ListGrid.canHover} can be set to true to cause hovers to be shown
     * for all fields by default.  In this case, <code>field.showHover</code> can be set to false to suppress hovers for an
     * individual field. <P> All hovers can be disabled, regardless of other settings, by setting {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getShowHover ListGrid.showHover} to false.
     *
     * @param showHover New showHover value. Default value is null
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#grid_interaction_value_hover" target="examples">Value hover tips Example</a>
     */
    public void setShowHover(Boolean showHover) {
        setAttribute("showHover", showHover);
    }

    /**
     * Whether to show hovers for this field.  The default hover will be the contents of the cell the user is hovering over,
     * and can be customized via {@link com.smartgwt.client.widgets.grid.ListGridField#hoverHTML field.hoverHTML()}. <P> {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getCanHover ListGrid.canHover} can be set to true to cause hovers to be shown
     * for all fields by default.  In this case, <code>field.showHover</code> can be set to false to suppress hovers for an
     * individual field. <P> All hovers can be disabled, regardless of other settings, by setting {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getShowHover ListGrid.showHover} to false.
     *
     * @return Current showHover value. Default value is null
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#grid_interaction_value_hover" target="examples">Value hover tips Example</a>
     */
    public Boolean getShowHover()  {
        return getAttributeAsBoolean("showHover", true);
    }
    

    /**
     * When set to true and showHover is also true for the field, shows a widget hovering at  the mouse point. <P> A number of
     * builtin modes are provided - see {@link com.smartgwt.client.types.HoverMode}. <P> Also supported at the {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getShowHoverComponents ListGrid-level}.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param showHoverComponents New showHoverComponents value. Default value is null
     */
    public void setShowHoverComponents(Boolean showHoverComponents) {
        setAttribute("showHoverComponents", showHoverComponents);
    }

    /**
     * When set to true and showHover is also true for the field, shows a widget hovering at  the mouse point. <P> A number of
     * builtin modes are provided - see {@link com.smartgwt.client.types.HoverMode}. <P> Also supported at the {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getShowHoverComponents ListGrid-level}.
     *
     * @return Current showHoverComponents value. Default value is null
     */
    public Boolean getShowHoverComponents()  {
        return getAttributeAsBoolean("showHoverComponents", true);
    }
    

    /**
     * If using an icon for this button, whether to switch the icon image on mouse rollover.
     *
     * @param showRollOverIcon New showRollOverIcon value. Default value is false
     * @see com.smartgwt.client.widgets.grid.ListGridField#setIcon
     * @see com.smartgwt.client.docs.ButtonIcon ButtonIcon overview and related methods
     */
    public void setShowRollOverIcon(Boolean showRollOverIcon) {
        setAttribute("showRollOverIcon", showRollOverIcon);
    }

    /**
     * If using an icon for this button, whether to switch the icon image on mouse rollover.
     *
     * @return Current showRollOverIcon value. Default value is false
     * @see com.smartgwt.client.widgets.grid.ListGridField#getIcon
     * @see com.smartgwt.client.docs.ButtonIcon ButtonIcon overview and related methods
     */
    public Boolean getShowRollOverIcon()  {
        Boolean result = getAttributeAsBoolean("showRollOverIcon", true);
        return result == null ? false : result;
    }
    

    /**
     * If using an icon for this button, whether to switch the icon image when the button becomes selected.
     *
     * @param showSelectedIcon New showSelectedIcon value. Default value is false
     * @see com.smartgwt.client.widgets.grid.ListGridField#setIcon
     * @see com.smartgwt.client.docs.ButtonIcon ButtonIcon overview and related methods
     */
    public void setShowSelectedIcon(Boolean showSelectedIcon) {
        setAttribute("showSelectedIcon", showSelectedIcon);
    }

    /**
     * If using an icon for this button, whether to switch the icon image when the button becomes selected.
     *
     * @return Current showSelectedIcon value. Default value is false
     * @see com.smartgwt.client.widgets.grid.ListGridField#getIcon
     * @see com.smartgwt.client.docs.ButtonIcon ButtonIcon overview and related methods
     */
    public Boolean getShowSelectedIcon()  {
        Boolean result = getAttributeAsBoolean("showSelectedIcon", true);
        return result == null ? false : result;
    }
    

    /**
     * This property may be set to <code>false</code> to explicitly suppress display of the field title in the column header
     * button for the field.
     *
     * @param showTitle New showTitle value. Default value is null
     */
    public void setShowTitle(Boolean showTitle) {
        setAttribute("showTitle", showTitle);
    }

    /**
     * This property may be set to <code>false</code> to explicitly suppress display of the field title in the column header
     * button for the field.
     *
     * @return Current showTitle value. Default value is null
     */
    public Boolean getShowTitle()  {
        return getAttributeAsBoolean("showTitle", true);
    }
    

    /**
     * If this field has a valueIcons property specified, setting this property causes the valueIcon for each value to be
     * displayed in the cell without also showing the record's value for the field. <P> If unset the default behavior is to
     * show the icon only if an explicit valueMap is specified as well in addition to a valueIcons map, otherwise show both the
     * valueIcon and value for the cell. <P> Note that if this field is editable {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getShowValueIconOnly FormItem.showValueIconOnly} will be passed through
     * to editors displayed in this field.
     *
     * @param showValueIconOnly New showValueIconOnly value. Default value is null
     * @see com.smartgwt.client.widgets.grid.ListGridField#setValueIcons
     * @see com.smartgwt.client.widgets.grid.ListGridField#setSuppressValueIcon
     * @see com.smartgwt.client.docs.ImageColumns ImageColumns overview and related methods
     */
    public void setShowValueIconOnly(Boolean showValueIconOnly) {
        setAttribute("showValueIconOnly", showValueIconOnly);
    }

    /**
     * If this field has a valueIcons property specified, setting this property causes the valueIcon for each value to be
     * displayed in the cell without also showing the record's value for the field. <P> If unset the default behavior is to
     * show the icon only if an explicit valueMap is specified as well in addition to a valueIcons map, otherwise show both the
     * valueIcon and value for the cell. <P> Note that if this field is editable {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getShowValueIconOnly FormItem.showValueIconOnly} will be passed through
     * to editors displayed in this field.
     *
     * @return Current showValueIconOnly value. Default value is null
     * @see com.smartgwt.client.widgets.grid.ListGridField#getValueIcons
     * @see com.smartgwt.client.widgets.grid.ListGridField#getSuppressValueIcon
     * @see com.smartgwt.client.docs.ImageColumns ImageColumns overview and related methods
     */
    public Boolean getShowValueIconOnly()  {
        return getAttributeAsBoolean("showValueIconOnly", true);
    }
    

    /**
     * By default, when {@link com.smartgwt.client.widgets.grid.ListGridField#getEscapeHTML escaping HTML}, we convert line
     * breaks (\r\n, \r, and \n) to HTML &lt;br&gt tags so that visible cell content respects the original break characters.
     * Set this property true to instead show the content as a single line (or potentially wrapped to avoid clipping if {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getWrapCells ListGrid.wrapCells} is true). <P> If defaulted to null, behavior
     * is determined by {@link com.smartgwt.client.widgets.grid.ListGrid#getSkipLineBreaks ListGrid.skipLineBreaks}.
     *
     * @param skipLineBreaks New skipLineBreaks value. Default value is null
     * @see com.smartgwt.client.widgets.grid.ListGridField#setEscapeHTML
     */
    public void setSkipLineBreaks(Boolean skipLineBreaks) {
        setAttribute("skipLineBreaks", skipLineBreaks);
    }

    /**
     * By default, when {@link com.smartgwt.client.widgets.grid.ListGridField#getEscapeHTML escaping HTML}, we convert line
     * breaks (\r\n, \r, and \n) to HTML &lt;br&gt tags so that visible cell content respects the original break characters.
     * Set this property true to instead show the content as a single line (or potentially wrapped to avoid clipping if {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getWrapCells ListGrid.wrapCells} is true). <P> If defaulted to null, behavior
     * is determined by {@link com.smartgwt.client.widgets.grid.ListGrid#getSkipLineBreaks ListGrid.skipLineBreaks}.
     *
     * @return Current skipLineBreaks value. Default value is null
     * @see com.smartgwt.client.widgets.grid.ListGridField#getEscapeHTML
     */
    public Boolean getSkipLineBreaks()  {
        return getAttributeAsBoolean("skipLineBreaks", true);
    }
    

    /**
     * For a field with <code>displayField</code> configured, should client-side sorting be performed on the display field
     * value? Unless explicitly set to <code>false</code> the display field value is used.
     *
     * @param sortByDisplayField New sortByDisplayField value. Default value is null
     */
    public void setSortByDisplayField(Boolean sortByDisplayField) {
        setAttribute("sortByDisplayField", sortByDisplayField);
    }

    /**
     * For a field with <code>displayField</code> configured, should client-side sorting be performed on the display field
     * value? Unless explicitly set to <code>false</code> the display field value is used.
     *
     * @return Current sortByDisplayField value. Default value is null
     */
    public Boolean getSortByDisplayField()  {
        return getAttributeAsBoolean("sortByDisplayField", true);
    }
    

    /**
     * If {@link com.smartgwt.client.widgets.grid.ListGridField#getValueMap valueMap} is set, and the grid is {@link
     * com.smartgwt.client.widgets.grid.ListGrid#setSort sorted} by this field, should the data be sorted by the underlying
     * data value or the mapped display value. If unset, will sort by display value. Set to <code>false</code> to sort by
     * underlying data value. Note that this has no effect if a {@link
     * com.smartgwt.client.widgets.grid.ListGridField#sortNormalizer sortNormalizer()} has been specified.
     *
     * @param sortByMappedValue New sortByMappedValue value. Default value is null
     */
    public void setSortByMappedValue(Boolean sortByMappedValue) {
        setAttribute("sortByMappedValue", sortByMappedValue);
    }

    /**
     * If {@link com.smartgwt.client.widgets.grid.ListGridField#getValueMap valueMap} is set, and the grid is {@link
     * com.smartgwt.client.widgets.grid.ListGrid#setSort sorted} by this field, should the data be sorted by the underlying
     * data value or the mapped display value. If unset, will sort by display value. Set to <code>false</code> to sort by
     * underlying data value. Note that this has no effect if a {@link
     * com.smartgwt.client.widgets.grid.ListGridField#sortNormalizer sortNormalizer()} has been specified.
     *
     * @return Current sortByMappedValue value. Default value is null
     */
    public Boolean getSortByMappedValue()  {
        return getAttributeAsBoolean("sortByMappedValue", true);
    }
    

    /**
     * Specifies the default sorting direction for this column. If specified on the {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getSortField default sort field} for the listGrid, sorting occurs
     * automatically, otherwise this will be the default direction when the user clicks the field header, or calls {@link
     * com.smartgwt.client.widgets.grid.ListGrid#sort ListGrid.sort()} without specifying an explicit sort direction. <P>
     * Overrides ListGrid.sortDirection
     *
     * @param sortDirection New sortDirection value. Default value is null
     * @see com.smartgwt.client.types.SortDirection
     */
    public void setSortDirection(SortDirection sortDirection) {
        setAttribute("sortDirection", sortDirection == null ? null : sortDirection.getValue());
    }

    /**
     * Specifies the default sorting direction for this column. If specified on the {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getSortField default sort field} for the listGrid, sorting occurs
     * automatically, otherwise this will be the default direction when the user clicks the field header, or calls {@link
     * com.smartgwt.client.widgets.grid.ListGrid#sort ListGrid.sort()} without specifying an explicit sort direction. <P>
     * Overrides ListGrid.sortDirection
     *
     * @return Current sortDirection value. Default value is null
     * @see com.smartgwt.client.types.SortDirection
     */
    public SortDirection getSortDirection()  {
        return EnumUtil.getEnum(SortDirection.values(), getAttribute("sortDirection"));
    }
    

    /**
     * Custom base style to apply to this field's header button instead of {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getSpannedHeaderBaseStyle ListGrid.spannedHeaderBaseStyle} when the grid is
     * showing header spans.<br>
     *
     * @param spannedHeaderBaseStyle New spannedHeaderBaseStyle value. Default value is null
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setSpannedHeaderBaseStyle(String spannedHeaderBaseStyle) {
        setAttribute("spannedHeaderBaseStyle", spannedHeaderBaseStyle);
    }

    /**
     * Custom base style to apply to this field's header button instead of {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getSpannedHeaderBaseStyle ListGrid.spannedHeaderBaseStyle} when the grid is
     * showing header spans.<br>
     *
     * @return Current spannedHeaderBaseStyle value. Default value is null
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getSpannedHeaderBaseStyle()  {
        return getAttributeAsString("spannedHeaderBaseStyle");
    }
    
    

    /**
     * Optional long summary title for this field, provided in addition to {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getTitle title}. This gives the developer an option to use a very short,
     * or empty title for the ListGrid column (where space may be a factor), but have a longer value available to be used
     * elsewhere. <p> By default this value will be used for the title of the context-menu item for showing/hiding the listGrid
     * field when the user right-clicks on the ListGrid header.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param summaryTitle New summaryTitle value. Default value is null
     * @see com.smartgwt.client.widgets.grid.ListGridField#setTitle
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     * @deprecated Rather than customizing the summaryTitle developers should typically use  the {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getHeaderTitle headerTitle} attribute to show a different  title in the
     * column header button than the title used elsewhere.
     */
    public void setSummaryTitle(String summaryTitle) {
        setAttribute("summaryTitle", summaryTitle);
    }

    /**
     * Optional long summary title for this field, provided in addition to {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getTitle title}. This gives the developer an option to use a very short,
     * or empty title for the ListGrid column (where space may be a factor), but have a longer value available to be used
     * elsewhere. <p> By default this value will be used for the title of the context-menu item for showing/hiding the listGrid
     * field when the user right-clicks on the ListGrid header.
     *
     * @return Optional string method to return a long summary title for this field, if a dynamic summary title is required for this
     * field. Default value is null
     * @see com.smartgwt.client.widgets.grid.ListGridField#getTitle
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     * @deprecated Rather than customizing the summaryTitle developers should typically use  the {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getHeaderTitle headerTitle} attribute to show a different  title in the
     * column header button than the title used elsewhere.
     */
    public String getSummaryTitle()  {
        return getAttributeAsString("summaryTitle");
    }
    

    /**
     * The value to display for a ListGridField when it appears in the {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getSummaryRow summaryRow}.  The default for normal fields is null and for
     * special fields, like the {@link com.smartgwt.client.widgets.grid.ListGrid#getCheckboxField checkboxField}, the default
     * is to show a blank value (a non-breaking space).
     *
     * @param summaryValue New summaryValue value. Default value is null
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public void setSummaryValue(String summaryValue) {
        setAttribute("summaryValue", summaryValue);
    }

    /**
     * The value to display for a ListGridField when it appears in the {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getSummaryRow summaryRow}.  The default for normal fields is null and for
     * special fields, like the {@link com.smartgwt.client.widgets.grid.ListGrid#getCheckboxField checkboxField}, the default
     * is to show a blank value (a non-breaking space).
     *
     * @return Current summaryValue value. Default value is null
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public String getSummaryValue()  {
        return getAttributeAsString("summaryValue");
    }
    

    /**
     * If {@link com.smartgwt.client.widgets.grid.ListGrid#getShowGridSummary ListGrid.showGridSummary} or {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getShowGroupSummary ListGrid.showGroupSummary} is true and the {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getSummaryFunction summaryFunction} is set to <code>"title"</code>, this
     * attribute may be set to a string to display in the group and/or grid summary. If unspecified the {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getTitle title} will show up in the summary.
     *
     * @param summaryValueTitle New summaryValueTitle value. Default value is null
     */
    public void setSummaryValueTitle(String summaryValueTitle) {
        setAttribute("summaryValueTitle", summaryValueTitle);
    }

    /**
     * If {@link com.smartgwt.client.widgets.grid.ListGrid#getShowGridSummary ListGrid.showGridSummary} or {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getShowGroupSummary ListGrid.showGroupSummary} is true and the {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getSummaryFunction summaryFunction} is set to <code>"title"</code>, this
     * attribute may be set to a string to display in the group and/or grid summary. If unspecified the {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getTitle title} will show up in the summary.
     *
     * @return Current summaryValueTitle value. Default value is null
     */
    public String getSummaryValueTitle()  {
        return getAttributeAsString("summaryValueTitle");
    }
    

    /**
     * If this field has a valueIcons property specified, setting this property to true will prevent the valueIcon being
     * written out into this field's cells. <P> Note this property may also be set to false to avoid showing the standard
     * {@link com.smartgwt.client.widgets.grid.ListGrid#getBooleanTrueImage ListGrid.booleanTrueImage} and {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getBooleanFalseImage ListGrid.booleanFalseImage} for fields of type
     * <code>boolean</code>.
     *
     * @param suppressValueIcon New suppressValueIcon value. Default value is null
     * @see com.smartgwt.client.widgets.grid.ListGridField#setValueIcons
     * @see com.smartgwt.client.widgets.grid.ListGridField#setShowValueIconOnly
     * @see com.smartgwt.client.docs.ImageColumns ImageColumns overview and related methods
     */
    public void setSuppressValueIcon(Boolean suppressValueIcon) {
        setAttribute("suppressValueIcon", suppressValueIcon);
    }

    /**
     * If this field has a valueIcons property specified, setting this property to true will prevent the valueIcon being
     * written out into this field's cells. <P> Note this property may also be set to false to avoid showing the standard
     * {@link com.smartgwt.client.widgets.grid.ListGrid#getBooleanTrueImage ListGrid.booleanTrueImage} and {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getBooleanFalseImage ListGrid.booleanFalseImage} for fields of type
     * <code>boolean</code>.
     *
     * @return Current suppressValueIcon value. Default value is null
     * @see com.smartgwt.client.widgets.grid.ListGridField#getValueIcons
     * @see com.smartgwt.client.widgets.grid.ListGridField#getShowValueIconOnly
     * @see com.smartgwt.client.docs.ImageColumns ImageColumns overview and related methods
     */
    public Boolean getSuppressValueIcon()  {
        return getAttributeAsBoolean("suppressValueIcon", true);
    }
    

    /**
     * By default, clicking a link rendered by this item opens it in a new browser window.  You can alter this behavior by
     * setting this property.  The value of this property will be passed as the value to the <code>target</code> attribute of
     * the anchor tag used to render the link. <P> If you set listGridField.target to "javascript", the default behavior is to
     * catch and consume mouse-clicks that would result in the link being followed.  Instead, the {@link
     * com.smartgwt.client.widgets.grid.ListGrid#addCellClickHandler ListGrid.cellClick()} event is fired for the containing
     * cell.
     *
     * @param target New target value. Default value is "_blank"
     */
    public void setTarget(String target) {
        setAttribute("target", target);
    }

    /**
     * By default, clicking a link rendered by this item opens it in a new browser window.  You can alter this behavior by
     * setting this property.  The value of this property will be passed as the value to the <code>target</code> attribute of
     * the anchor tag used to render the link. <P> If you set listGridField.target to "javascript", the default behavior is to
     * catch and consume mouse-clicks that would result in the link being followed.  Instead, the {@link
     * com.smartgwt.client.widgets.grid.ListGrid#addCellClickHandler ListGrid.cellClick()} event is fired for the containing
     * cell.
     *
     * @return Current target value. Default value is "_blank"
     */
    public String getTarget()  {
        return getAttributeAsString("target");
    }
    

    /**
     * Time-format to apply to date type values within this field.  If specified, any dates displayed in this field will be
     * formatted as times using the appropriate format. This is most commonly only applied to fields specified as type
     * <code>"time"</code> though if no explicit {@link com.smartgwt.client.widgets.grid.ListGridField#getDateFormatter
     * dateFormatter} is specified it will be respected for other fields as well. <P> If unspecified, a timeFormatter may be
     * defined {@link com.smartgwt.client.widgets.grid.ListGrid#getTimeFormatter at the component level} and will be respected
     * by fields of type <code>"time"</code>. <P> If this field is editable, the timeFormatter will also be passed to the
     * editor created to edit this field as {@link com.smartgwt.client.widgets.form.fields.FormItem#getTimeFormatter
     * FormItem.timeFormatter}.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param timeFormatter New timeFormatter value. Default value is null
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setTimeFormatter(TimeDisplayFormat timeFormatter) {
        setAttribute("timeFormatter", timeFormatter == null ? null : timeFormatter.getValue());
    }

    /**
     * Time-format to apply to date type values within this field.  If specified, any dates displayed in this field will be
     * formatted as times using the appropriate format. This is most commonly only applied to fields specified as type
     * <code>"time"</code> though if no explicit {@link com.smartgwt.client.widgets.grid.ListGridField#getDateFormatter
     * dateFormatter} is specified it will be respected for other fields as well. <P> If unspecified, a timeFormatter may be
     * defined {@link com.smartgwt.client.widgets.grid.ListGrid#getTimeFormatter at the component level} and will be respected
     * by fields of type <code>"time"</code>. <P> If this field is editable, the timeFormatter will also be passed to the
     * editor created to edit this field as {@link com.smartgwt.client.widgets.form.fields.FormItem#getTimeFormatter
     * FormItem.timeFormatter}.
     *
     * @return Current timeFormatter value. Default value is null
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public TimeDisplayFormat getTimeFormatter()  {
        return EnumUtil.getEnum(TimeDisplayFormat.values(), getAttribute("timeFormatter"));
    }
    

    /**
     * A title for this field, to display in the header for the field and in other contexts such as the {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getCanPickFields menu for picking visible fields}. <P> Note: if you want to
     * use HTML tags to affect the display of the header, you should do so via {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getHeaderTitle headerTitle} instead so that other places where the title
     * appears in the UI are not affected.  For example, you might set <code>headerTitle</code> to an empty string to suppress
     * the header title on a narrow column, but you would retain the normal title in the <code>title</code> property to avoid a
     * blank menu item in the field picker menu, {@link com.smartgwt.client.widgets.DataBoundComponent#editHilites hilite
     * editor} and other contexts. <P> Alternately you can specify a {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getFieldTitle getFieldTitle()} method on the field to return the HTML for
     * the field title.
     *
     * @param title New title value. Default value is null
     * @see com.smartgwt.client.widgets.grid.ListGridField#getFieldTitle
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setTitle(String title) {
        setAttribute("title", title);
    }

    /**
     * A title for this field, to display in the header for the field and in other contexts such as the {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getCanPickFields menu for picking visible fields}. <P> Note: if you want to
     * use HTML tags to affect the display of the header, you should do so via {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getHeaderTitle headerTitle} instead so that other places where the title
     * appears in the UI are not affected.  For example, you might set <code>headerTitle</code> to an empty string to suppress
     * the header title on a narrow column, but you would retain the normal title in the <code>title</code> property to avoid a
     * blank menu item in the field picker menu, {@link com.smartgwt.client.widgets.DataBoundComponent#editHilites hilite
     * editor} and other contexts. <P> Alternately you can specify a {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getFieldTitle getFieldTitle()} method on the field to return the HTML for
     * the field title.
     *
     * @return Current title value. Default value is null
     * @see com.smartgwt.client.widgets.grid.ListGridField#getFieldTitle
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getTitle()  {
        return getAttributeAsString("title");
    }
    

    /**
     * ListGrids picks a renderer for the view and edit mode of a field based on this attribute.  See {@link
     * com.smartgwt.client.types.ListGridFieldType} for a summary of how types are rendered.
     *
     * @param type New type value. Default value is "text"
     * @see com.smartgwt.client.types.ListGridFieldType
     * @see com.smartgwt.client.types.FieldType
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setType(ListGridFieldType type) {
        setAttribute("type", type == null ? null : type.getValue());
    }

    /**
     * ListGrids picks a renderer for the view and edit mode of a field based on this attribute.  See {@link
     * com.smartgwt.client.types.ListGridFieldType} for a summary of how types are rendered.
     *
     * @return Current type value. Default value is "text"
     * @see com.smartgwt.client.types.ListGridFieldType
     * @see com.smartgwt.client.types.FieldType
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public ListGridFieldType getType()  {
        return EnumUtil.getEnum(ListGridFieldType.values(), getAttribute("type"));
    }
    

    /**
     * Formula definition for this field. <P> Advanced applications that wish to save formulas separately from a grid's {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getViewState viewState} can provide a {@link
     * com.smartgwt.client.widgets.UserFormula} as part of the field definition, and may subsequently access the formula is
     * updated via the {@link com.smartgwt.client.widgets.grid.ListGrid#addFormulaUpdatedHandler ListGrid.formulaUpdated()}
     * notification.
     *
     * @param userFormula New userFormula value. Default value is null
     */
    public void setUserFormula(UserFormula userFormula) {
        setAttribute("userFormula", userFormula == null ? null : userFormula.getJsObj());
    }

    /**
     * Formula definition for this field. <P> Advanced applications that wish to save formulas separately from a grid's {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getViewState viewState} can provide a {@link
     * com.smartgwt.client.widgets.UserFormula} as part of the field definition, and may subsequently access the formula is
     * updated via the {@link com.smartgwt.client.widgets.grid.ListGrid#addFormulaUpdatedHandler ListGrid.formulaUpdated()}
     * notification.
     *
     * @return Current userFormula value. Default value is null
     */
    public UserFormula getUserFormula()  {
        return new UserFormula(getAttributeAsJavaScriptObject("userFormula"));
    }
    

    /**
     * Summary definition for this field. <P> Advanced applications that wish to save summaries separately from a grid's {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getViewState viewState} can provide a {@link
     * com.smartgwt.client.widgets.UserSummary} as part of the field definition, and may subsequently access the summary is
     * updated via the {@link com.smartgwt.client.widgets.grid.ListGrid#summaryUpdated ListGrid.summaryUpdated()} notification.
     *
     * @param userSummary New userSummary value. Default value is null
     */
    public void setUserSummary(UserSummary userSummary) {
        setAttribute("userSummary", userSummary == null ? null : userSummary.getJsObj());
    }

    /**
     * Summary definition for this field. <P> Advanced applications that wish to save summaries separately from a grid's {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getViewState viewState} can provide a {@link
     * com.smartgwt.client.widgets.UserSummary} as part of the field definition, and may subsequently access the summary is
     * updated via the {@link com.smartgwt.client.widgets.grid.ListGrid#summaryUpdated ListGrid.summaryUpdated()} notification.
     *
     * @return Current userSummary value. Default value is null
     */
    public UserSummary getUserSummary()  {
        return new UserSummary(getAttributeAsJavaScriptObject("userSummary"));
    }
    

    /**
     * If set to true, any {@link com.smartgwt.client.widgets.grid.ListGridField#getValidators validators} for this field will
     * be run whenever the value of the field is changed. <P> Analogous to the {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getValidateOnChange FormItem.validateOnChange} property.
     *
     * @param validateOnChange New validateOnChange value. Default value is null
     * @see com.smartgwt.client.docs.GridValidation GridValidation overview and related methods
     */
    public void setValidateOnChange(Boolean validateOnChange) {
        setAttribute("validateOnChange", validateOnChange);
    }

    /**
     * If set to true, any {@link com.smartgwt.client.widgets.grid.ListGridField#getValidators validators} for this field will
     * be run whenever the value of the field is changed. <P> Analogous to the {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getValidateOnChange FormItem.validateOnChange} property.
     *
     * @return Current validateOnChange value. Default value is null
     * @see com.smartgwt.client.docs.GridValidation GridValidation overview and related methods
     */
    public Boolean getValidateOnChange()  {
        return getAttributeAsBoolean("validateOnChange", true);
    }
    

    /**
     * Array of {@link com.smartgwt.client.widgets.form.validator.Validator} objects for this field.  When the user edits cells
     * in this field, these validators will be applied to the edited value.<br> Note: for databound listGrids, this property
     * may be specified on the {@link com.smartgwt.client.data.DataSourceField}, enabling both client and server side
     * validation.
     *
     * @param validators New validators value. Default value is null
     * @see com.smartgwt.client.widgets.form.validator.Validator
     * @see com.smartgwt.client.widgets.grid.ListGridField#setRequired
     * @see com.smartgwt.client.docs.GridValidation GridValidation overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#grid_editing_data_validation" target="examples">Data validation Example</a>
     */
    public void setValidators(Validator... validators) {
        setAttribute("validators", validators);
    }
    

    /**
     * Specifies vertical alignment in the column header for a  {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getRotateTitle rotated title}: "top", "center", or "bottom".  If unset,
     * default behavior is derived from {@link com.smartgwt.client.widgets.grid.ListGrid#getHeaderTitleVAlign
     * ListGrid.headerTitleVAlign}.
     *
     * @param valign New valign value. Default value is null
     * @see com.smartgwt.client.widgets.grid.ListGrid#setRotateHeaderTitles
     */
    public void setValign(VerticalAlignment valign) {
        setAttribute("valign", valign == null ? null : valign.getValue());
    }

    /**
     * Specifies vertical alignment in the column header for a  {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getRotateTitle rotated title}: "top", "center", or "bottom".  If unset,
     * default behavior is derived from {@link com.smartgwt.client.widgets.grid.ListGrid#getHeaderTitleVAlign
     * ListGrid.headerTitleVAlign}.
     *
     * @return Current valign value. Default value is null
     * @see com.smartgwt.client.widgets.grid.ListGrid#getRotateHeaderTitles
     */
    public VerticalAlignment getValign()  {
        return EnumUtil.getEnum(VerticalAlignment.values(), getAttribute("valign"));
    }
    

    /**
     * Specifies the {@link com.smartgwt.client.widgets.grid.ListGridField#getOptionDataSource optionDataSource} field used to
     * retrieve the stored values that are to be mapped to the display values (specified by {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getDisplayField displayField}). Note that if this field is editable this
     * will also be applied to this field's editors.
     *
     * @param valueField New valueField value. Default value is null
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
     * @return Current valueField value. Default value is null
     */
    public String getValueField()  {
        return getAttributeAsString("valueField");
    }
    

    /**
     * Height for value icons for this listGrid field. Overrides {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getValueIconSize ListGrid.valueIconSize}, {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getValueIconHeight ListGrid.valueIconHeight}, and {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getValueIconSize valueIconSize}.
     *
     * @param valueIconHeight New valueIconHeight value. Default value is null
     * @see com.smartgwt.client.docs.ImageColumns ImageColumns overview and related methods
     */
    public void setValueIconHeight(Integer valueIconHeight) {
        setAttribute("valueIconHeight", valueIconHeight);
    }

    /**
     * Height for value icons for this listGrid field. Overrides {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getValueIconSize ListGrid.valueIconSize}, {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getValueIconHeight ListGrid.valueIconHeight}, and {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getValueIconSize valueIconSize}.
     *
     * @return Current valueIconHeight value. Default value is null
     * @see com.smartgwt.client.docs.ImageColumns ImageColumns overview and related methods
     */
    public Integer getValueIconHeight()  {
        return getAttributeAsInt("valueIconHeight");
    }
    

    /**
     * How much padding should there be on the left of valueIcons for this field Overrides {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getValueIconLeftPadding ListGrid.valueIconLeftPadding}
     *
     * @param valueIconLeftPadding New valueIconLeftPadding value. Default value is null
     * @see com.smartgwt.client.widgets.grid.ListGridField#setValueIcons
     * @see com.smartgwt.client.docs.ImageColumns ImageColumns overview and related methods
     */
    public void setValueIconLeftPadding(Integer valueIconLeftPadding) {
        setAttribute("valueIconLeftPadding", valueIconLeftPadding);
    }

    /**
     * How much padding should there be on the left of valueIcons for this field Overrides {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getValueIconLeftPadding ListGrid.valueIconLeftPadding}
     *
     * @return Current valueIconLeftPadding value. Default value is null
     * @see com.smartgwt.client.widgets.grid.ListGridField#getValueIcons
     * @see com.smartgwt.client.docs.ImageColumns ImageColumns overview and related methods
     */
    public Integer getValueIconLeftPadding()  {
        return getAttributeAsInt("valueIconLeftPadding");
    }
    

    /**
     * If we're showing a valueIcon for this field should it appear to the left or the right of the text?  By default the icon
     * will appear to the left of the textual value - set this to "right" to show the icon on the right of the text. Has no
     * effect if {@link com.smartgwt.client.widgets.grid.ListGridField#getShowValueIconOnly showValueIconOnly} is true
     *
     * @param valueIconOrientation New valueIconOrientation value. Default value is null
     * @see com.smartgwt.client.docs.ImageColumns ImageColumns overview and related methods
     */
    public void setValueIconOrientation(String valueIconOrientation) {
        setAttribute("valueIconOrientation", valueIconOrientation);
    }

    /**
     * If we're showing a valueIcon for this field should it appear to the left or the right of the text?  By default the icon
     * will appear to the left of the textual value - set this to "right" to show the icon on the right of the text. Has no
     * effect if {@link com.smartgwt.client.widgets.grid.ListGridField#getShowValueIconOnly showValueIconOnly} is true
     *
     * @return Current valueIconOrientation value. Default value is null
     * @see com.smartgwt.client.docs.ImageColumns ImageColumns overview and related methods
     */
    public String getValueIconOrientation()  {
        return getAttributeAsString("valueIconOrientation");
    }
    

    /**
     * How much padding should there be on the right of valueIcons for this field Overrides {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getValueIconRightPadding ListGrid.valueIconRightPadding}
     *
     * @param valueIconRightPadding New valueIconRightPadding value. Default value is null
     * @see com.smartgwt.client.widgets.grid.ListGridField#setValueIcons
     * @see com.smartgwt.client.docs.ImageColumns ImageColumns overview and related methods
     */
    public void setValueIconRightPadding(Integer valueIconRightPadding) {
        setAttribute("valueIconRightPadding", valueIconRightPadding);
    }

    /**
     * How much padding should there be on the right of valueIcons for this field Overrides {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getValueIconRightPadding ListGrid.valueIconRightPadding}
     *
     * @return Current valueIconRightPadding value. Default value is null
     * @see com.smartgwt.client.widgets.grid.ListGridField#getValueIcons
     * @see com.smartgwt.client.docs.ImageColumns ImageColumns overview and related methods
     */
    public Integer getValueIconRightPadding()  {
        return getAttributeAsInt("valueIconRightPadding");
    }
    

    /**
     * This property is a mapping from data values for this field to {@link com.smartgwt.client.docs.SCImgURL urls} for
     *  icons to display for those data values.  
     *  <p>
     *  For example, given a field named "status" with possible values
     *  "Normal", "Slow", "Offline", the follow definition would show various icons for that
     *  field:
     *  <P>
     *  
     *  
     *  <pre>
     *  ListGridField statusField = new ListGridField("status");
     *  statusField.setValueIcons(new HashMap&lt;String, String>() {{
     *     put("Normal", "greenIcon.png");
     *     put("Slow", "yellowIcon.png");
     *     put("Offline", "redIcon.png");
     *  }});
     *  </pre>
     *  
     *  <p>
     * If a simple value-to-URL mapping is not enough, you can override {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getValueIcon ListGrid.getValueIcon()}
     *  to customize the behavior.  You can even specify an empty <code>valueIcons</code> map
     * and use {@link com.smartgwt.client.widgets.grid.ListGrid#getValueIcon ListGrid.getValueIcon()} to return arbitrary icons
     * with no fixed mapping.
     *  <p>
     *  <code>valueIcons</code> can either be displayed alongside the normal value or can
     *  replace the normal field value so that only the icon is shown.  See
     * {@link com.smartgwt.client.widgets.grid.ListGridField#getShowValueIconOnly showValueIconOnly}.  When placed alongside
     * the value, use
     * {@link com.smartgwt.client.widgets.grid.ListGridField#getValueIconOrientation valueIconOrientation} to control left- vs
     * right-side placement.
     *  <P>
     *  If inline editing is enabled for this field, editors displayed for this field will also
     *  show valueIcons.  This may be overridden by explicitly setting
     *  {@link com.smartgwt.client.widgets.grid.ListGridField#getEditorValueIcons editorValueIcons}.
     *  <P>
     *  Note that the following attributes related to valueIcon styling will also be picked up
     *  by the editor from the ListGridField object unless explicitly specified via the
     *  equivalent <code>editor_</code> attributes:<br>
     *  {@link com.smartgwt.client.widgets.grid.ListGridField#getValueIconWidth valueIconWidth}<br>
     *  {@link com.smartgwt.client.widgets.grid.ListGridField#getValueIconHeight valueIconHeight}<br>
     *  {@link com.smartgwt.client.widgets.grid.ListGridField#getValueIconSize valueIconSize}<br>
     *  {@link com.smartgwt.client.widgets.grid.ListGridField#getValueIconLeftPadding valueIconLeftPadding}<br>
     *  {@link com.smartgwt.client.widgets.grid.ListGridField#getValueIconRightPadding valueIconRightPadding}<br>
     *  {@link com.smartgwt.client.widgets.grid.ListGridField#getImageURLPrefix imageURLPrefix}<br>
     *  {@link com.smartgwt.client.widgets.grid.ListGridField#getImageURLSuffix imageURLSuffix}
     *  <P>
     * If {@link com.smartgwt.client.widgets.grid.ListGridField#addValueIconClickHandler ListGridField.valueIconClick()} is
     * defined for the field, a pointer
     *  cursor will be shown when the user rolls over the valueIcon, and the valueIconClick
     *  method will execute when the user clicks the icon.
     *
     * @param valueIcons New valueIcons value. Default value is null
     * @see com.smartgwt.client.docs.ImageColumns ImageColumns overview and related methods
     */
    public void setValueIcons(Map<String,String> valueIcons) {
        setAttribute("valueIcons", valueIcons);
    }
    

    /**
     * Default width and height of value icons in this field. Takes precedence over valueIconWidth, valueIconHeight and
     * valueIconSize specified at the ListGrid level. Can be overridden via {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getValueIconWidth valueIconWidth} and {ListGridField.valueIconHeight}
     *
     * @param valueIconSize New valueIconSize value. Default value is null
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
     * @return Current valueIconSize value. Default value is null
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
     * com.smartgwt.client.widgets.grid.ListGrid#getValueIconSize ListGrid.valueIconSize}, {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getValueIconWidth ListGrid.valueIconWidth}, and {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getValueIconSize valueIconSize}.
     *
     * @param valueIconWidth New valueIconWidth value. Default value is null
     * @see com.smartgwt.client.docs.ImageColumns ImageColumns overview and related methods
     */
    public void setValueIconWidth(Integer valueIconWidth) {
        setAttribute("valueIconWidth", valueIconWidth);
    }

    /**
     * Width for value icons for this listGrid field. Overrides {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getValueIconSize ListGrid.valueIconSize}, {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getValueIconWidth ListGrid.valueIconWidth}, and {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getValueIconSize valueIconSize}.
     *
     * @return Current valueIconWidth value. Default value is null
     * @see com.smartgwt.client.docs.ImageColumns ImageColumns overview and related methods
     */
    public Integer getValueIconWidth()  {
        return getAttributeAsInt("valueIconWidth");
    }
    

    /**
     * Array of legal values for this field, or an Object where each property maps a stored value to a user-displayable
     * value.<br> Note that if this field is editable (see {@link com.smartgwt.client.widgets.grid.ListGrid#getCanEdit
     * ListGrid.canEdit}, {@link com.smartgwt.client.widgets.grid.ListGridField#getCanEdit canEdit}), editors displayed for
     * this field will pick up their valueMap either from this value or from {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getEditorValueMap editorValueMap}. <P> See also {@link
     * com.smartgwt.client.data.DataSourceField#getValueMap DataSourceField.valueMap}.
     *
     * @param valueMap New valueMap value. Default value is null
     * @see com.smartgwt.client.widgets.grid.ListGrid#setValueMap
     * @see com.smartgwt.client.widgets.grid.ListGrid#getDisplayValue
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#grid_datatypes_list" target="examples">List Example</a>
     */
    public void setValueMap(Map valueMap) {
        setAttribute("valueMap", valueMap);
    }

    /**
     * Array of legal values for this field, or an Object where each property maps a stored value to a user-displayable
     * value.<br> Note that if this field is editable (see {@link com.smartgwt.client.widgets.grid.ListGrid#getCanEdit
     * ListGrid.canEdit}, {@link com.smartgwt.client.widgets.grid.ListGridField#getCanEdit canEdit}), editors displayed for
     * this field will pick up their valueMap either from this value or from {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getEditorValueMap editorValueMap}. <P> See also {@link
     * com.smartgwt.client.data.DataSourceField#getValueMap DataSourceField.valueMap}.
     *
     * @param valueMap New valueMap value. Default value is null
     * @see com.smartgwt.client.widgets.grid.ListGrid#setValueMap
     * @see com.smartgwt.client.widgets.grid.ListGrid#getDisplayValue
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#grid_datatypes_list" target="examples">List Example</a>
     */
    public void setValueMap(String... valueMap) {
        setAttribute("valueMap", valueMap);
    }
    
    

    /**
     * Should the field title wrap if there is not enough space horizontally to accommodate it. If unset, default behavior is
     * derived from {@link com.smartgwt.client.widgets.grid.ListGrid#getWrapHeaderTitles ListGrid.wrapHeaderTitles}.  (This is
     * a soft-wrap - if set the title will wrap at word boundaries.) <P> <b>Notes:</b><ul> <li>If autofitting is active, {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getWidth width} and {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getMinWidth minWidth} can be set to control the minimum field width - see
     * the links for details. <li>This feature is incompatible with {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getClipHeaderTitles ListGrid.clipHeaderTitles}, and
     * <code>clipHeaderTitles</code> will be disabled for wrapping fields.</ul>
     *
     * @param wrap New wrap value. Default value is null
     * @see com.smartgwt.client.widgets.grid.ListGrid#setMinFieldWidth
     */
    public void setWrap(Boolean wrap) {
        setAttribute("wrap", wrap);
    }

    /**
     * Should the field title wrap if there is not enough space horizontally to accommodate it. If unset, default behavior is
     * derived from {@link com.smartgwt.client.widgets.grid.ListGrid#getWrapHeaderTitles ListGrid.wrapHeaderTitles}.  (This is
     * a soft-wrap - if set the title will wrap at word boundaries.) <P> <b>Notes:</b><ul> <li>If autofitting is active, {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getWidth width} and {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getMinWidth minWidth} can be set to control the minimum field width - see
     * the links for details. <li>This feature is incompatible with {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getClipHeaderTitles ListGrid.clipHeaderTitles}, and
     * <code>clipHeaderTitles</code> will be disabled for wrapping fields.</ul>
     *
     * @return Current wrap value. Default value is null
     * @see com.smartgwt.client.widgets.grid.ListGrid#getMinFieldWidth
     */
    public Boolean getWrap()  {
        return getAttributeAsBoolean("wrap", true);
    }
    

    // ********************* Methods ***********************
    /**
     * Add a editorEnter handler.
     * <p>
     * Callback fired when the user first starts editing a cell. <P> This callback is typically used to establish dynamic
     * default values via {@link com.smartgwt.client.widgets.grid.ListGrid#setEditValue ListGrid.setEditValue()} or {@link
     * com.smartgwt.client.widgets.grid.ListGrid#setEditValues ListGrid.setEditValues()}.
     *
     * @param handler the editorEnter handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addEditorEnterHandler(com.smartgwt.client.widgets.grid.events.EditorEnterHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.grid.events.EditorEnterEvent.getType()) == 0) setupEditorEnterEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.grid.events.EditorEnterEvent.getType());
    }

    private native void setupEditorEnterEvent() /*-{
        var obj;
        obj = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        var selfJ = this;
        var editorEnter = $entry(function(){
            var param = {"_this": this, "record" : arguments[0], "value" : arguments[1], "rowNum" : arguments[2], "colNum" : arguments[3], "grid" : arguments[4]};
            var event = @com.smartgwt.client.widgets.grid.events.EditorEnterEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.core.DataClass::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            selfJ.@com.smartgwt.client.widgets.grid.ListGridField::handleTearDownEditorEnterEvent()();
            });
        obj.editorEnter =  editorEnter 
        ;
    }-*/;

    private void handleTearDownEditorEnterEvent() {
        if (getHandlerCount(com.smartgwt.client.widgets.grid.events.EditorEnterEvent.getType()) == 0) tearDownEditorEnterEvent();
    }

    private native void tearDownEditorEnterEvent() /*-{
        var obj;
        obj = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        if (obj && "editorEnter" in obj) delete obj.editorEnter;
    }-*/;

    /**
     * Add a editorExit handler.
     * <p>
     * Callback fired when the user attempts to navigate away from the current edit cell, or complete the current edit.<br>
     * Call {@link com.smartgwt.client.widgets.grid.events.EditorExitEvent#cancel()} from within {@link
     * com.smartgwt.client.widgets.grid.events.EditorExitHandler#onEditorExit} from this method to cancel the default behavior
     * (Saving / cancelling the current edit / moving to the next edit cell)
     *
     * @param handler the editorExit handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addEditorExitHandler(com.smartgwt.client.widgets.grid.events.EditorExitHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.grid.events.EditorExitEvent.getType()) == 0) setupEditorExitEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.grid.events.EditorExitEvent.getType());
    }

    private native void setupEditorExitEvent() /*-{
        var obj;
        obj = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        var selfJ = this;
        var editorExit = $debox($entry(function(param){
            var event = @com.smartgwt.client.widgets.grid.events.EditorExitEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.core.DataClass::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            selfJ.@com.smartgwt.client.widgets.grid.ListGridField::handleTearDownEditorExitEvent()();
            var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
            return !ret;
            }));
        obj.editorExit = 
            function () {
                var param = {"_this": this, "editCompletionEvent" : arguments[0], "record" : arguments[1], "newValue" : arguments[2], "rowNum" : arguments[3], "colNum" : arguments[4], "grid" : arguments[5]};
                return editorExit(param) == true;
            }
        ;
    }-*/;

    private void handleTearDownEditorExitEvent() {
        if (getHandlerCount(com.smartgwt.client.widgets.grid.events.EditorExitEvent.getType()) == 0) tearDownEditorExitEvent();
    }

    private native void tearDownEditorExitEvent() /*-{
        var obj;
        obj = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        if (obj && "editorExit" in obj) delete obj.editorExit;
    }-*/;

	/**
     * Return the HTML to display in cells of this field. <P> Given the raw value for this field as taken from the record
     * Formatter to apply to the static values displayed in cells for this field. <P> <i>Example usage</i>: formatting a
     * currency value stored in cents (so "100" to "$1.00")<br> The value passed to this method is the raw value for the
     * cell.<br> Takes precedence over <code>formatCellValue</code> defined at the grid level for cells in this field. <P>
     * Note: this formatter will not be applied to the values displayed in cells being edited. The {@link
     * com.smartgwt.client.widgets.grid.ListGridField#formatEditorValue formatEditorValue()} is provided for that purpose.
     * @param value raw value for the cell, from the record for the row
     * @param record Record object for the cell. Note: If this is a new row that has not been saved, in an   editable grid, it has no
     * associated record object. In this case the edit values will   be passed in as this parameter (see {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getEditValues ListGrid.getEditValues()})
     * @param rowNum row number for the cell
     * @param colNum column number for the cell.
     * @param grid the ListGrid displaying the cell
     *
     * @return HTML to display in the cell.
     * See {@link com.smartgwt.client.docs.HTMLString HTMLString}
     * @see com.smartgwt.client.widgets.grid.ListGrid#setCellFormatter
     * @see com.smartgwt.client.widgets.grid.ListGridField#formatEditorValue
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#grid_appearance_format_values" target="examples">Format values Example</a>
     * @deprecated Use {@link com.smartgwt.client.widgets.grid.ListGridField#setCellFormatter setCellFormatter()} or  {@link
     * com.smartgwt.client.widgets.grid.ListGrid#setCellFormatter ListGrid.setCellFormatter()} to install a {@link
     * com.smartgwt.client.widgets.grid.CellFormatter}.  This method is not a valid override point for the default behavior.
     */
    public native String formatCellValue(Object value, ListGridRecord record, int rowNum, int colNum, ListGrid grid) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        var ret = self.formatCellValue(value, record.@com.smartgwt.client.core.DataClass::getJsObj()(), rowNum, colNum, grid == null ? null : grid.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()());
        return ret;
    }-*/;

	/**
     * When a field has {@link com.smartgwt.client.widgets.grid.ListGridField#getAutoFreeze autoFreeze} set to true, developers
     * can implement this method to indicate where in the frozen-fields array this field should appear. <P> Some automatically
     * generated fields, such as {@link com.smartgwt.client.widgets.grid.ListGrid#getRowNumberField rowNumberField}, {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getExpansionField expansionField} and {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getCheckboxField checkboxField}, provide default implementations of this
     * method.
     *
     * @return the index at which this autoFreeze field should appear in the frozen body
     * @see com.smartgwt.client.docs.FrozenFields FrozenFields overview and related methods
     */
    public native int getAutoFreezePosition() /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        var ret = self.getAutoFreezePosition();
        return ret;
    }-*/;

	/**
     * If your derivation of the field title is more complex than specifying a static string, you can specify a getFieldTitle()
     * method on your field to return the title string. Otherwise you can use the {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getTitle title} attribute on the field to specify the title. <P> You can
     * use {@link com.smartgwt.client.widgets.grid.ListGrid#setFieldProperties setFieldProperties()} to dynamically update the
     * title.
     * @param viewer pointer back to the ListGrid
     * @param fieldNum index of this field in the grid's fields array.
     *
     * @return Field title.
     * @see com.smartgwt.client.widgets.grid.ListGridField#getTitle
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public native String getFieldTitle(ListGrid viewer, int fieldNum) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        var ret = self.getFieldTitle(viewer == null ? null : viewer.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()(), fieldNum);
        return ret;
    }-*/;

    /**
     * Add a recordClick handler.
     * <p>
     * Executed when this field is clicked on.  Note that if {@link com.smartgwt.client.widgets.grid.ListGrid#recordClick
     * ListGrid.recordClick()} is also defined, it will be fired for fields that define a recordClick handler if the
     * field-level handler returns true. Call {@link com.smartgwt.client.widgets.grid.events.RecordClickEvent#cancel()} from
     * within {@link com.smartgwt.client.widgets.grid.events.RecordClickHandler#onRecordClick} to prevent the grid-level
     * handler from firing.
     *
     * @param handler the recordClick handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addRecordClickHandler(com.smartgwt.client.widgets.grid.events.RecordClickHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.grid.events.RecordClickEvent.getType()) == 0) setupRecordClickEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.grid.events.RecordClickEvent.getType());
    }

    private native void setupRecordClickEvent() /*-{
        var obj;
        obj = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        var selfJ = this;
        var recordClick = $debox($entry(function(param){
            var event = @com.smartgwt.client.widgets.grid.events.RecordClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.core.DataClass::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            selfJ.@com.smartgwt.client.widgets.grid.ListGridField::handleTearDownRecordClickEvent()();
            var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
            return !ret;
            }));
        obj.recordClick = 
            function () {
                var param = {"_this": this, "viewer" : arguments[0], "record" : arguments[1], "recordNum" : arguments[2], "field" : arguments[3], "fieldNum" : arguments[4], "value" : arguments[5], "rawValue" : arguments[6]};
                return recordClick(param) == true;
            }
        ;
    }-*/;

    private void handleTearDownRecordClickEvent() {
        if (getHandlerCount(com.smartgwt.client.widgets.grid.events.RecordClickEvent.getType()) == 0) tearDownRecordClickEvent();
    }

    private native void tearDownRecordClickEvent() /*-{
        var obj;
        obj = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        if (obj && "recordClick" in obj) delete obj.recordClick;
    }-*/;

    /**
     * Add a valueIconClick handler.
     * <p>
     * Executed when the user clicks on a {@link com.smartgwt.client.widgets.grid.ListGridField#getValueIcons value icon}
     * within this field. Call {@link com.smartgwt.client.widgets.grid.events.ValueIconClickEvent#cancel()} from within {@link
     * com.smartgwt.client.widgets.grid.events.ValueIconClickHandler#onValueIconClick} to suppress default behavior of firing
     * {@link com.smartgwt.client.widgets.grid.ListGridField#addRecordClickHandler ListGridField.recordClick()}  handlers, etc.
     *
     * @param handler the valueIconClick handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addValueIconClickHandler(com.smartgwt.client.widgets.grid.events.ValueIconClickHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.grid.events.ValueIconClickEvent.getType()) == 0) setupValueIconClickEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.grid.events.ValueIconClickEvent.getType());
    }

    private native void setupValueIconClickEvent() /*-{
        var obj;
        obj = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        var selfJ = this;
        var valueIconClick = $debox($entry(function(param){
            var event = @com.smartgwt.client.widgets.grid.events.ValueIconClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.core.DataClass::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            selfJ.@com.smartgwt.client.widgets.grid.ListGridField::handleTearDownValueIconClickEvent()();
            var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
            return !ret;
            }));
        obj.valueIconClick = 
            function () {
                var param = {"_this": this, "viewer" : arguments[0], "record" : arguments[1], "recordNum" : arguments[2], "field" : arguments[3], "rawValue" : arguments[4], "editor" : arguments[5]};
                return valueIconClick(param) == true;
            }
        ;
    }-*/;

    private void handleTearDownValueIconClickEvent() {
        if (getHandlerCount(com.smartgwt.client.widgets.grid.events.ValueIconClickEvent.getType()) == 0) tearDownValueIconClickEvent();
    }

    private native void tearDownValueIconClickEvent() /*-{
        var obj;
        obj = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        if (obj && "valueIconClick" in obj) delete obj.valueIconClick;
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
     * Sets a formatter that returns the HTML to display in each cell of the field, 
     * given the raw cell value.  Overrides 
     * {@link com.smartgwt.client.widgets.grid.ListGrid#setCellFormatter}.
     * @see com.smartgwt.client.widgets.grid.CellFormatter
     * @param formatter formatter to apply to the cell values
     */
    public native void setCellFormatter(CellFormatter formatter) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.formatCellValue = $debox($entry(function(value, record, rowNum, colNum) {
            var recordJ = @com.smartgwt.client.widgets.grid.ListGridRecord::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(record);
            var valueJ = $wnd.SmartGWT.convertToJavaType(value, self.type);
            return formatter.@com.smartgwt.client.widgets.grid.CellFormatter::format(Ljava/lang/Object;Lcom/smartgwt/client/widgets/grid/ListGridRecord;II)(valueJ, recordJ, rowNum, colNum);
        }));
    }-*/;
    
	/**
     * Field-level formatter for inactive content. <P> If present, this method will be invoked instead of {@link
     * com.smartgwt.client.widgets.grid.ListGridField#setCellFormatter setCellFormatter()} in cases  where the grid is
     * rendering non-interactive content outside.  See {@link com.smartgwt.client.widgets.grid.ListGrid#setInactiveCellFormatter} for more details. <P>
     * @param formatter formatter to apply to  inactive cell values
     * @see com.smartgwt.client.widgets.grid.ListGrid#setInactiveCellFormatter
     */
    public native void setInactiveCellFormatter(CellFormatter formatter) /*-{
	    var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
	    self.formatInactiveCellValue = $debox($entry(function(value, record, rowNum, colNum) {
	        var recordJ = @com.smartgwt.client.widgets.grid.ListGridRecord::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(record);
	        var valueJ = $wnd.SmartGWT.convertToJavaType(value, self.type);
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
	        var valueJ = $wnd.SmartGWT.convertToJavaType(value, self.type);
	        var val = formatter.@com.smartgwt.client.widgets.grid.CellEditValueFormatter::format(Ljava/lang/Object;Lcom/smartgwt/client/widgets/grid/ListGridRecord;II)(valueJ, recordJ, rowNum, colNum);
            return $wnd.SmartGWT.convertToPrimitiveType(val);
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
	        var valueJ = $wnd.SmartGWT.convertToJavaType(value, self.type);
	        var val = parser.@com.smartgwt.client.widgets.grid.CellEditValueParser::parse(Ljava/lang/Object;Lcom/smartgwt/client/widgets/grid/ListGridRecord;II)(valueJ, recordJ, rowNum, colNum);
            return $wnd.SmartGWT.convertToPrimitiveType(val);
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
                return $wnd.SmartGWT.convertToPrimitiveType(val);
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
            var valueJ = $wnd.SmartGWT.convertToJavaType(value, self.type);
            return hoverCustomizer.@com.smartgwt.client.widgets.grid.HoverCustomizer::hoverHTML(Ljava/lang/Object;Lcom/smartgwt/client/widgets/grid/ListGridRecord;II)(valueJ, recordJ, rowNum, colNum);
        }));
    }-*/;
    
    /**
     *
     * @param groupSummaryCustomizer the group summary customizer
     */
    public native void setGroupSummaryCustomizer(GroupSummaryCustomizer groupSummaryCustomizer) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.getGroupSummary = $debox($entry(function(records, field, groupNode) {
           
            var recordsJ        = @com.smartgwt.client.util.ConvertTo::arrayOfListGridRecord(Lcom/google/gwt/core/client/JavaScriptObject;)(records);
            var fieldJ          = @com.smartgwt.client.widgets.grid.ListGridField::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(field);
            var groupNodeJ      = groupNode == null ? null : @com.smartgwt.client.widgets.grid.GroupNode::new(Lcom/google/gwt/core/client/JavaScriptObject;)(groupNode);
            
            var returnValue     = groupSummaryCustomizer.@com.smartgwt.client.widgets.grid.GroupSummaryCustomizer::getGroupSummary([Lcom/smartgwt/client/widgets/grid/ListGridRecord;Lcom/smartgwt/client/widgets/grid/ListGridField;Lcom/smartgwt/client/widgets/grid/GroupNode;)(recordsJ,fieldJ,groupNodeJ);

            return @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(returnValue);
        }));
    }-*/;

    /**
     *
     * @param gridSummaryCustomizer the grid summary customizer
     */
    public native void setGridSummaryCustomizer(GridSummaryCustomizer gridSummaryCustomizer) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.getGridSummary = $debox($entry(function(records, field, groupSummaries) {
        
            var recordJ         = @com.smartgwt.client.util.ConvertTo::arrayOfListGridRecord(Lcom/google/gwt/core/client/JavaScriptObject;)(records);
            var fieldJ          = @com.smartgwt.client.widgets.grid.ListGridField::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(field);
            var groupSummariesJ = groupSummaries == null ? null : @com.smartgwt.client.util.ConvertTo::arrayOfGroupSummary(Lcom/google/gwt/core/client/JavaScriptObject;)(groupSummaries);
            var returnValue     = gridSummaryCustomizer.@com.smartgwt.client.widgets.grid.GridSummaryCustomizer::getGridSummary([Lcom/smartgwt/client/widgets/grid/ListGridRecord;Lcom/smartgwt/client/widgets/grid/ListGridField;[Lcom/smartgwt/client/widgets/grid/GroupSummary;)(recordJ,fieldJ,groupSummariesJ);
            
            return @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(returnValue);
        }));
    }-*/;

    /**
     * Horizontal alignment for field's column header: "left", "right" or "center". Applied to the column header title
     * and cells by default. A separate alignment for cells can be specified via {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getCellAlign cellAlign}.<br><br> If null, default alignment depends 
     * on the field's declared {@link com.smartgwt.client.widgets.grid.ListGridField#setType type} - generally "left" 
     * except for numbers which are "right" - and if {@link com.smartgwt.client.widgets.grid.ListGridField#setRotateTitle rotateTitle}
     * has been specified, the default is always "center". <br><br>
     * Note that if this field is editable, the alignment of cells in the body will also be reflected in any editors for the field.
     *
     * @param align align Default value is null
     */
    public void setAlign(Alignment align) {
        setAttribute("align", align.getValue());
    }

    /**
     * Horizontal alignment for field's column header: "left", "right" or "center". Applied to the column header title
     * and cells by default. A separate alignment for cells can be specified via {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getCellAlign cellAlign}.<br> If null, default alignment depends 
     * on the field's declared {@link com.smartgwt.client.widgets.grid.ListGridField#getType type} - generally "left" 
     * except for numbers which are "right" - and if {@link com.smartgwt.client.widgets.grid.ListGridField#getRotateTitle rotateTitle}
     * has been specified, the default is always "center". <br><br>
     * Note that if this field is editable, the alignment of cells in the body will also be reflected in any editors for the field.
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
     * Synonym for {@link setImageURLPrefix(String)}.
     *
     * @param imgDir the imageURLPrefix
     * @deprecated Renamed to {@link setImageURLPrefix(String)}
     */    
    public void setImgDir(String imgDir) {
        setAttribute("imgDir", imgDir);
    }
    
    /**
     * If this field {@link com.smartgwt.client.widgets.grid.ListGrid#getCanEdit can be edited}, 
     * this property can be used to specify a default value for this field's editor when adding 
     * new rows to the grid.
     * 
     * @see ListGrid#startEditingNew()
     */
    public void setDefaultValue(String defaultValue) {
        setAttribute("defaultValue", defaultValue);
    }

    /**
     * @see #setDefaultValue(String)
     */
    public void setDefaultValue(Integer defaultValue) {
        setAttribute("defaultValue", defaultValue);
    }

    /**
     * @see #setDefaultValue(String)
     */
    public void setDefaultValue(Long defaultValue) {
        setAttribute("defaultValue", defaultValue);
    }

    /**
     * @see #setDefaultValue(String)
     */
    public void setDefaultValue(Boolean defaultValue) {
        setAttribute("defaultValue", defaultValue);
    }

    /**
     * @see #setDefaultValue(String)
     */
    public void setDefaultValue(Float defaultValue) {
        setAttribute("defaultValue", defaultValue);
    }

    /**
     * @see #setDefaultValue(String)
     */
    public void setDefaultValue(Date defaultValue) {
        setAttribute("defaultValue", defaultValue);
    }

    /**
     * FormItem properties to use as a template for the form item created to edit this field. (Only used if this field is
     * editable). Note: If this is not specified, the edit-form item type be the appropriate form item for
     * the data-type of the field.
     * <p>
     * The {@link com.smartgwt.client.widgets.grid.ListGrid#setEditorCustomizer(ListGridEditorCustomizer)} 
     * API allows the developer to supply dynamic properties for the
     * item based on the row as well as the field being edited.
     * <p>
     * <b>Note</b>: The FormItem passed to setEditorProperties() is used as a "template" to create a FormItem whenever
     * the ListGrid needs to show an interface for editing this field. See
     * {@link com.smartgwt.client.data.DataSourceField#setEditorProperties(FormItem)} for a discussion of the limitations this
     * pattern imposes upon event handling within the passed in item.
     * As an alternative, you can use {@link setEditorType(String)} or
     * {@link setEditorType(Class)} to avoid these limitations, if you register
     * the FormItem subclass with the {@link com.smartgwt.client.docs.Reflection reflection mechanism}.
     *
     * @param editorProperties the editor properties
     */
    public void setEditorProperties(FormItem editorProperties) {
        if (editorProperties.isCreated()) {
            ConfigUtil.warnOfPreConfigInstantiation(this.getClass(), "setEditorProperties", "FormItem");
        }                                                                       
        editorProperties.setConfigOnly(true);

        // only set the editorType attribute if the passed editorType is a concrete subclass of FormItem
        if (editorProperties.getClass() != FormItem.class) {
            String fiEditorType = editorProperties.getAttribute("editorType");
            // fallback to type if editorType is not specified
            if (fiEditorType == null) fiEditorType = editorProperties.getType();
            if (fiEditorType != null && !fiEditorType.equals("FormItem")) setAttribute("editorType", fiEditorType);
        }
        JavaScriptObject editorConfig = editorProperties.getConfig();
        setAttribute("editorProperties", editorConfig);
    }

    /**
     * Synonym for {@link setEditorProperties(FormItem)}.
     *
     * @param editorType FormItem with default properties to be applied when editing
     * @deprecated Renamed to {@link setEditorProperties(FormItem)}. You can also consider using 
     *             {@link setEditorType(Class)} or {@link setEditorType(String)} instead.
     */
    public void setEditorType(FormItem editorType) {
        setEditorProperties(editorType);
    }
    
    /**
     * The {@link FormItem} class to be used when this field is edited.
     * <p>
     * If unset, a FormItem will be automatically chosen.
     * <p>
     * By using the {@link com.smartgwt.client.docs.Reflection reflection mechanism}, 
     * this method avoids the limitations described in {@link setEditorProperties(FormItem)}.
     *
     * @param editorType the fully-qualified class name of a {@link com.smartgwt.client.widgets.form.fields.FormItem}
     *                   subclass, which must have been registered with the 
     *                   {@link com.smartgwt.client.docs.Reflection reflection mechanism}. 
     * @throws IllegalArgumentException if the editorType class has not beeen registered for use with the 
     *                                  {@link com.smartgwt.client.docs.Reflection reflection mechanism},
     *                                  or if it does not inherit from 
     *                                  {@link com.smartgwt.client.widgets.form.fields.FormItem}.
    **/
    public void setEditorType(String editorType) {
        com.smartgwt.client.bean.BeanFactory factory = com.smartgwt.client.bean.BeanFactory.getFactory(editorType);
        if (factory == null) {
            throw new IllegalArgumentException("No BeanFactory has been registered for: " + editorType);
        } else if (!com.smartgwt.client.bean.BeanValueType.isAssignableFrom(FormItem.class, factory.getBeanClass())) {
            throw new IllegalArgumentException("The editorType: " + editorType + " does not inherit from FormItem");
        }
        setAttribute("editorType", editorType);
    }

    /**
     * The {@link FormItem} class to be used when this field is edited.
     * <p>
     * If unset, a FormItem will be automatically chosen.
     * <p>
     * By using the {@link com.smartgwt.client.docs.Reflection reflection mechanism}, 
     * this method avoids the limitations described in {@link setEditorProperties(FormItem)}.
     *
     * @param editorType a {@link com.smartgwt.client.widgets.form.fields.FormItem}
     *                   subclass, which must have been registered with the 
     *                   {@link com.smartgwt.client.docs.Reflection reflection mechanism}. 
     * @throws IllegalArgumentException if the editorType class has not beeen registered for use with the 
     *                                  {@link com.smartgwt.client.docs.Reflection reflection mechanism},
     *                                  or if it does not inherit from 
     *                                  {@link com.smartgwt.client.widgets.form.fields.FormItem}.
    **/
    public void setEditorType(Class<? extends FormItem> editorType) {
        setEditorType(editorType.getName());
    }

    /**
     * Synonym for {@link setFilterEditorProperties(FormItem)}.
     *
     * @param filterEditorType FormItem with default properties to be applied when editing in the filter row
     * @deprecated Renamed to {@link setFilterEditorProperties(FormItem)}. You can also consider using 
     *             {@link setFilterEditorType(Class)} or {@link setFilterEditorType(String)} instead.
     */
    public void setFilterEditorType(FormItem filterEditorType) {
        setFilterEditorProperties(filterEditorType);
    }

    /**
     * If this ListGrid is showing a filter row, this property can be used to specify the {@link FormItem} class to use
     * for the filter form item associated with this field. (Only used if this field is not canFilter:false).
     * <p>
     * <b>Note</b>: If this is not specified, the edit-form item type may be derived from the 'editorType' property,
     * typically inherited from datasource fields, or from the 'type' of the field (showing the appropriate form item for the data-type).
     * <p>
     * By using the {@link com.smartgwt.client.docs.Reflection reflection mechanism}, 
     * this method avoids the limitations described in {@link setFilterEditorProperties(FormItem)}.
     *
     * @param editorType the fully-qualified class name of a {@link com.smartgwt.client.widgets.form.fields.FormItem}
     *                   subclass, which must have been registered with the 
     *                   {@link com.smartgwt.client.docs.Reflection reflection mechanism}. 
     * @throws IllegalArgumentException if the editorType class has not beeen registered for use with the 
     *                                  {@link com.smartgwt.client.docs.Reflection reflection mechanism},
     *                                  or if it does not inherit from 
     *                                  {@link com.smartgwt.client.widgets.form.fields.FormItem}.
     */
    public void setFilterEditorType(String editorType) {
        com.smartgwt.client.bean.BeanFactory factory = com.smartgwt.client.bean.BeanFactory.getFactory(editorType);
        if (factory == null) {
            throw new IllegalArgumentException("No BeanFactory has been registered for: " + editorType);
        } else if (!com.smartgwt.client.bean.BeanValueType.isAssignableFrom(FormItem.class, factory.getBeanClass())) {
            throw new IllegalArgumentException("The editorType: " + editorType + " does not inherit from FormItem");
        }
        setAttribute("filterEditorType", editorType);
    }

    /**
     * If this ListGrid is showing a filter row, this property can be used to specify the {@link FormItem} class to use
     * for the filter form item associated with this field. (Only used if this field is not canFilter:false).
     * <p>
     * <b>Note</b>: If this is not specified, the edit-form item type may be derived from the 'editorType' property,
     * typically inherited from datasource fields, or from the 'type' of the field (showing the appropriate form item for the data-type).
     * <p>
     * By using the {@link com.smartgwt.client.docs.Reflection reflection mechanism}, 
     * this method avoids the limitations described in {@link setFilterEditorProperties(FormItem)}.
     *
     * @param editorType a {@link com.smartgwt.client.widgets.form.fields.FormItem}
     *                   subclass, which must have been registered with the 
     *                   {@link com.smartgwt.client.docs.Reflection reflection mechanism}. 
     * @throws IllegalArgumentException if the editorType class has not beeen registered for use with the 
     *                                  {@link com.smartgwt.client.docs.Reflection reflection mechanism},
     *                                  or if it does not inherit from 
     *                                  {@link com.smartgwt.client.widgets.form.fields.FormItem}.
     */
    public void setFilterEditorType(Class<? extends FormItem> editorType) {
        setFilterEditorType(editorType.getName());
    }

    /**
     * If this ListGrid is showing a filter row (showFilterEditor : true), this
     * property can be used to specify properties for the appropriate filter
     * form item. If this is not specified, the edit-form item type may be
     * derived from the 'editorType' property, typically inherited from
     * datasource fields, or from the 'type' of the field (showing the
     * appropriate form item for the data-type).
     * <p>
     * <b>Note</b>: The FormItem passed to setFilterEditorProperties() is used
     * as a "template" to create a FormItem whenever the ListGrid needs to show
     * an interface for editing this field. See
     * {@link com.smartgwt.client.data.DataSourceField#setEditorProperties(FormItem)} 
     * for a discussion of the limitations this pattern imposes upon event
     * handling within the passed in item.  As an alternative, you can use
     * {@link setFilterEditorType(String)} or {@link setFilterEditorType(Class)} to avoid
     * these limitations, if you register the FormItem subclass with the 
     * {@link com.smartgwt.client.docs.Reflection reflection mechanism}.
     *
     * @param filterEditorProperties the filter editor properties
     */
    public void setFilterEditorProperties(FormItem filterEditorProperties) {
        if (filterEditorProperties.isCreated()) {
            ConfigUtil.warnOfPreConfigInstantiation(this.getClass(), "setFilterEditorProperties",
                                                    "FormItem");
        }                                                                       
        filterEditorProperties.setConfigOnly(true);

        // Only set the filterEditorType if the passed type is a concrete subclass of FormItem
        if (filterEditorProperties.getClass() != FormItem.class) {
            String type = filterEditorProperties.getAttribute("editorType");
            if (type == null) type = filterEditorProperties.getType();
            if (type != null && !type.equals("FormItem")) setAttribute("filterEditorType", type);
        }
        JavaScriptObject editorConfig = filterEditorProperties.getConfig();
        setAttribute("filterEditorProperties", editorConfig);
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
                var param = {"_this": this, "form" : arguments[0], "item" : arguments[1], "value" : arguments[2], "oldValue" : arguments[3], "sourceJSO" : this};
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
                var param = {"_this": this, "form" : arguments[0], "item" : arguments[1], "value" : arguments[2], "sourceJSO" : this};
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
            var valueJ =  $wnd.SmartGWT.convertToJavaType(value, self.type);
            var recordJ = @com.smartgwt.client.widgets.grid.ListGridRecord::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(record);
            var fieldJ = @com.smartgwt.client.widgets.grid.ListGridField::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(field);
            var gridJ = @com.smartgwt.client.widgets.grid.ListGrid::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(grid);
            var val = groupValueFunction.@com.smartgwt.client.widgets.grid.GroupValueFunction::getGroupValue(Ljava/lang/Object;Lcom/smartgwt/client/widgets/grid/ListGridRecord;Lcom/smartgwt/client/widgets/grid/ListGridField;Ljava/lang/String;Lcom/smartgwt/client/widgets/grid/ListGrid;)(valueJ, recordJ, fieldJ, fieldName, gridJ);
            return $wnd.SmartGWT.convertToPrimitiveType(val);
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
     * The buttonProperties parameter should be the same class as the headerButtonConstructor for
     * the ListGrid (most commonly Button, ImgButton or StretchImgButton, and typically set up
     * in the load_skin.js file for the loaded theme).
     *
     * @param buttonProperties the header button properties.
     */
    public void setHeaderButtonProperties(Canvas buttonProperties) {
        if (buttonProperties.isCreated()) {
            ConfigUtil.warnOfPreConfigInstantiation(this.getClass(), "setHeaderButtonProperties",
                                                    "Canvas");
        }                                                                       
        buttonProperties.setConfigOnly(true);
        JSOHelper.addProperties(getJsObj(), 
                                JSOHelper.cleanProperties(buttonProperties.getConfig(), true));
    }

    /**
     * If {@link com.smartgwt.client.widgets.grid.ListGrid#getShowGridSummary showGridSummary} or {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getShowGroupSummary showGroupSummary} is true,
     * this method can be used to
     * specify a {@link com.smartgwt.client.types.SummaryFunctionType}
     * for calculating the summary value to display.
     *
     * @param summaryFunction summaryFunction
     */
    public void setSummaryFunction(SummaryFunctionType summaryFunction) {
        setAttribute("summaryFunction", summaryFunction);
    }


    /**
     * If {@link com.smartgwt.client.widgets.grid.ListGrid#getShowGridSummary showGridSummary} or {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getShowGroupSummary showGroupSummary} is true,
     * this method can be used to
     * specify the name of a summary function registered via {@link com.smartgwt.client.data.SimpleType#registerSummaryFunction}
     * for calculating the summary value to display.
     *
     * @param summaryFunction summaryFunction
     */
    public void setSummaryFunction(String summaryFunction) {
        setAttribute("summaryFunction", summaryFunction);
    }

    /**
     * If {@link com.smartgwt.client.widgets.grid.ListGrid#getShowGridSummary showGridSummary} or {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getShowGroupSummary showGroupSummary} is true,
     * this method can be used to
     * specify a {@link com.smartgwt.client.widgets.grid.SummaryFunction}
     * for calculating the summary value to display.
     *
     * @param summaryFunction summaryFunctio
     */
    public native void setSummaryFunction(SummaryFunction summaryFunction) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        if (summaryFunction == null) self.summaryFunction = null;
        else {

            self.summaryFunction = $debox($entry(function(records, field) {
                var recordsJ =  @com.smartgwt.client.util.ConvertTo::arrayOfRecord(Lcom/google/gwt/core/client/JavaScriptObject;)(records);
                var fieldJ = @com.smartgwt.client.widgets.grid.ListGridField::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(field);
                var val = summaryFunction.@com.smartgwt.client.widgets.grid.SummaryFunction::getSummaryValue([Lcom/smartgwt/client/data/Record;Lcom/smartgwt/client/widgets/grid/ListGridField;)(recordsJ, fieldJ);
                if(val == null || $wnd.isc.isA.String(val) || $wnd.isc.isA.Number(val)) return val;
                if(@com.smartgwt.client.util.JSOHelper::isJavaNumber(Ljava/lang/Object;)(val)) return val.@java.lang.Number::doubleValue()();
                if(@com.smartgwt.client.util.JSOHelper::isJavaDate(Ljava/lang/Object;)(val)) return @com.smartgwt.client.util.JSOHelper::convertToJavaScriptDate(Ljava/util/Date;)(val);
                $wnd.isc.logWarn('Unrecognized type of value ' + val + ' returned by the summaryFunction');
            }));
        }
    }-*/;

    /**
     * If {@link com.smartgwt.client.widgets.grid.ListGrid#getShowGridSummary showGridSummary} or {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getShowGroupSummary showGroupSummary} is true,
     * this method can be used to specify a {@link com.smartgwt.client.widgets.grid.SummaryFunction}
     * for calculating the summary value to display.
     * Note that by calling this method repeatedly, you can apply more than one summary function to a field. This allows
     * the developer to set up multi-line summaries - each specified summary function result will show up in a separate
     * summary row (either at the bottom of the grid or at the end of each group).
     * <P>
     * Note also that multiple-line summary functions are not compatible with the
     * {@link com.smartgwt.client.widgets.grid.ListGrid#setShowGroupSummaryInHeader} feature. If this property is set only the
     * first summary value will be visible to the user (displayed in the group header node).
     *
     * @param summaryFunction
     */
    public native void addSummaryFunction(SummaryFunction summaryFunction) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        if (!$wnd.isc.isAn.Array(self.summaryFunction)) {
            self.summaryFunction = self.summaryFunction == null ? $wnd.Array.newInstance() :
                                        $wnd.Array.createFromItemArgs(self.summaryFunction);
        }
        // support being passed null - this will allow multi line summaries with gaps in some rows for some fields.
        if (summaryFunction == null) {
            self.summaryFunction[self.summaryFunction.length] = null;
        } else {
            self.summaryFunction[self.summaryFunction.length] = $debox($entry(function(records, field) {
                var recordsJ =  @com.smartgwt.client.util.ConvertTo::arrayOfRecord(Lcom/google/gwt/core/client/JavaScriptObject;)(records);
                var fieldJ = @com.smartgwt.client.widgets.grid.ListGridField::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(field);
                var val = summaryFunction.@com.smartgwt.client.widgets.grid.SummaryFunction::getSummaryValue([Lcom/smartgwt/client/data/Record;Lcom/smartgwt/client/widgets/grid/ListGridField;)(recordsJ, fieldJ);
                if(val == null || $wnd.isc.isA.String(val) || $wnd.isc.isA.Number(val)) return val;
                if(@com.smartgwt.client.util.JSOHelper::isJavaNumber(Ljava/lang/Object;)(val)) return val.@java.lang.Number::doubleValue()();
                if(@com.smartgwt.client.util.JSOHelper::isJavaDate(Ljava/lang/Object;)(val)) return @com.smartgwt.client.util.JSOHelper::convertToJavaScriptDate(Ljava/util/Date;)(val);
                $wnd.isc.logWarn('Unrecognized type of value ' + val + ' returned by the summaryFunction');
            }));
        }
    }-*/;

    /**
     * If {@link com.smartgwt.client.widgets.grid.ListGrid#getShowGridSummary showGridSummary} or {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getShowGroupSummary showGroupSummary} is true,
     * this method can be used to specify a {@link com.smartgwt.client.types.SummaryFunctionType}
     * for calculating the summary value to display.
     * Note that by calling this method repeatedly, you can apply more than one summary function to a field. This allows
     * the developer to set up multi-line summaries - each specified summary function result will show up in a separate
     * summary row (either at the bottom of the grid or at the end of each group).
     * <P>
     * Note also that multiple-line summary functions are not compatible with the
     * {@link com.smartgwt.client.widgets.grid.ListGrid#setShowGroupSummaryInHeader} feature. If this property is set only the
     * first summary value will be visible to the user (displayed in the group header node).
     *
     * @param summaryFunction
     */
    public native void addSummaryFunction(SummaryFunctionType summaryFunction) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        if (!$wnd.isc.isAn.Array(self.summaryFunction)) {
            self.summaryFunction = self.summaryFunction == null ? $wnd.Array.newInstance() :
                                        $wnd.Array.createFromItemArgs(self.summaryFunction);
        }
        // support being passed null - this will allow multi line summaries with gaps in some rows for some fields.
        if (summaryFunction == null) {
            self.summaryFunction[self.summaryFunction.length] = null;
        } else {
            self.summaryFunction[self.summaryFunction.length] = summaryFunction.@com.smartgwt.client.types.SummaryFunctionType::value;
        }
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
            var fieldsJ = @com.smartgwt.client.util.ConvertTo::arrayOfListGridField(Lcom/google/gwt/core/client/JavaScriptObject;)(fields);
            var summaryFieldJ = @com.smartgwt.client.widgets.grid.ListGridField::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(summaryField);
            var val = recordSummaryFunction.@com.smartgwt.client.widgets.grid.RecordSummaryFunction::getSummaryValue(Lcom/smartgwt/client/data/Record;[Lcom/smartgwt/client/widgets/grid/ListGridField;Lcom/smartgwt/client/widgets/grid/ListGridField;)(recordJ, fieldsJ, summaryFieldJ);
            return $wnd.SmartGWT.convertToPrimitiveType(val);
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
    
    /**
     * Return the live ListGrid instance to which this ListGridField is assigned.  May return 
     * null, if not yet assigned to a grid, or if the live grid instance has not yet been
     * created, or has already been destroyed.
     *
     * @return ListGrid instance
     */
    public native ListGrid getListGrid() /*-{
        var fieldJS = this.@com.smartgwt.client.core.DataClass::getJsObj()();
    	
        // bail if there's no field js object or no componentID
        if (fieldJS == null || fieldJS.componentID == null) return null;
        
        var gridJS = $wnd[fieldJS.componentID];
        // bail if there's no grid, or the passed field isn't available in the grid (fields or completeFields)
        if (gridJS == null || gridJS.destroyed == true) return null;
        if (gridJS.getSpecifiedField(fieldJS.name) == null) return null;
        
	    return @com.smartgwt.client.widgets.grid.ListGrid::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(gridJS);
	}-*/;

    /**
     * Set the type directly to a defined SimpleType.
     *
     * @param type the SimpleType
     */
    public void setType(SimpleType type) {
        //ensure that the simple type is created and registered
        type.getOrCreateJsObj();
        setAttribute("type", type.getName());
    }
    
    private static boolean isListGridField(JavaScriptObject jsObj) {
        Object ref = JSOHelper.getAttributeAsObject(jsObj, SC.REF);
        return ref != null && ref instanceof ListGridField;
    }


}
