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
 
package com.smartgwt.client.tools;


import com.smartgwt.client.event.*;
import com.smartgwt.client.core.*;
import com.smartgwt.client.types.*;
import com.smartgwt.client.data.*;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.data.events.*;
import com.smartgwt.client.browser.window.*;
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
import com.smartgwt.client.widgets.tour.*;
import com.smartgwt.client.widgets.notify.*;
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
import com.smartgwt.client.widgets.notify.*;
import com.smartgwt.client.widgets.drawing.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
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
import com.smartgwt.client.util.tour.*;


/**
 * {@link com.smartgwt.client.tools.EditProxy} that handles {@link com.smartgwt.client.widgets.grid.ListGrid} and {@link
 * com.smartgwt.client.widgets.tree.TreeGrid} components when editMode is enabled.
 * @see com.smartgwt.client.docs.DevTools DevTools overview and related methods
 */
@BeanFactory.FrameworkClass
@BeanFactory.ScClassName("GridEditProxy")
public class GridEditProxy extends LayoutEditProxy {

    public static GridEditProxy getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        BaseClass obj = BaseClass.getRef(jsObj);
        if(obj != null) {
            return (GridEditProxy) obj;
        } else {
            return new GridEditProxy(jsObj);
        }
    }
        


    public GridEditProxy(){
        scClassName = "GridEditProxy";
    }

    public GridEditProxy(JavaScriptObject jsObj){
        scClassName = "GridEditProxy";
        setJavaScriptObject(jsObj);
    }

    public native JavaScriptObject create()/*-{
        var config = this.@com.smartgwt.client.core.BaseClass::getConfig()();
        var scClassName = this.@com.smartgwt.client.core.BaseClass::scClassName;
        return $wnd.isc[scClassName].create(config);
    }-*/;

    // ********************* Properties / Attributes ***********************

    /**
     * Can new formula fields be created from header context menu? Overrides {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getCanAddFormulaFields ListGrid.canAddFormulaFields} when in edit mode.
     *
     * @param canAddFormulaFields New canAddFormulaFields value. Default value is true
     * @return {@link com.smartgwt.client.tools.GridEditProxy GridEditProxy} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public GridEditProxy setCanAddFormulaFields(Boolean canAddFormulaFields)  throws IllegalStateException {
        return (GridEditProxy)setAttribute("canAddFormulaFields", canAddFormulaFields, false);
    }

    /**
     * Can new formula fields be created from header context menu? Overrides {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getCanAddFormulaFields ListGrid.canAddFormulaFields} when in edit mode.
     *
     * @return Current canAddFormulaFields value. Default value is true
     */
    public Boolean getCanAddFormulaFields()  {
        Boolean result = getAttributeAsBoolean("canAddFormulaFields");
        return result == null ? true : result;
    }
    

    /**
     * Can new summary fields be created from header context menu? Overrides {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getCanAddSummaryFields ListGrid.canAddSummaryFields} when in edit mode.
     *
     * @param canAddSummaryFields New canAddSummaryFields value. Default value is true
     * @return {@link com.smartgwt.client.tools.GridEditProxy GridEditProxy} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public GridEditProxy setCanAddSummaryFields(Boolean canAddSummaryFields)  throws IllegalStateException {
        return (GridEditProxy)setAttribute("canAddSummaryFields", canAddSummaryFields, false);
    }

    /**
     * Can new summary fields be created from header context menu? Overrides {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getCanAddSummaryFields ListGrid.canAddSummaryFields} when in edit mode.
     *
     * @return Current canAddSummaryFields value. Default value is true
     */
    public Boolean getCanAddSummaryFields()  {
        Boolean result = getAttributeAsBoolean("canAddSummaryFields");
        return result == null ? true : result;
    }
    

    /**
     * Can highlights be edited from header context menu? Overrides {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getCanEditHilites ListGrid.canEditHilites} when in edit mode.
     *
     * @param canEditHilites New canEditHilites value. Default value is true
     * @return {@link com.smartgwt.client.tools.GridEditProxy GridEditProxy} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public GridEditProxy setCanEditHilites(Boolean canEditHilites)  throws IllegalStateException {
        return (GridEditProxy)setAttribute("canEditHilites", canEditHilites, false);
    }

    /**
     * Can highlights be edited from header context menu? Overrides {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getCanEditHilites ListGrid.canEditHilites} when in edit mode.
     *
     * @return Current canEditHilites value. Default value is true
     */
    public Boolean getCanEditHilites()  {
        Boolean result = getAttributeAsBoolean("canEditHilites");
        return result == null ? true : result;
    }
    

    /**
     * Can records be grouped from header context menu? Overrides {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getCanGroupBy ListGrid.canGroupBy} when in edit mode.
     *
     * @param canGroupBy New canGroupBy value. Default value is true
     * @return {@link com.smartgwt.client.tools.GridEditProxy GridEditProxy} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public GridEditProxy setCanGroupBy(Boolean canGroupBy)  throws IllegalStateException {
        return (GridEditProxy)setAttribute("canGroupBy", canGroupBy, false);
    }

    /**
     * Can records be grouped from header context menu? Overrides {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getCanGroupBy ListGrid.canGroupBy} when in edit mode.
     *
     * @return Current canGroupBy value. Default value is true
     */
    public Boolean getCanGroupBy()  {
        Boolean result = getAttributeAsBoolean("canGroupBy");
        return result == null ? true : result;
    }
    

    /**
     * Indicates whether fields in this listGrid can be reordered by dragging and dropping header fields.  Overrides {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getCanReorderFields ListGrid.canReorderFields} when in edit mode.
     *
     * @param canReorderFields New canReorderFields value. Default value is true
     * @return {@link com.smartgwt.client.tools.GridEditProxy GridEditProxy} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public GridEditProxy setCanReorderFields(Boolean canReorderFields)  throws IllegalStateException {
        return (GridEditProxy)setAttribute("canReorderFields", canReorderFields, false);
    }

    /**
     * Indicates whether fields in this listGrid can be reordered by dragging and dropping header fields.  Overrides {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getCanReorderFields ListGrid.canReorderFields} when in edit mode.
     *
     * @return Current canReorderFields value. Default value is true
     */
    public Boolean getCanReorderFields()  {
        Boolean result = getAttributeAsBoolean("canReorderFields");
        return result == null ? true : result;
    }
    

    /**
     * Indicates whether fields in this listGrid can be resized by dragging header fields. Overrides {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getCanResizeFields ListGrid.canResizeFields} when in edit mode.
     *
     * @param canResizeFields New canResizeFields value. Default value is true
     * @return {@link com.smartgwt.client.tools.GridEditProxy GridEditProxy} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public GridEditProxy setCanResizeFields(Boolean canResizeFields)  throws IllegalStateException {
        return (GridEditProxy)setAttribute("canResizeFields", canResizeFields, false);
    }

    /**
     * Indicates whether fields in this listGrid can be resized by dragging header fields. Overrides {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getCanResizeFields ListGrid.canResizeFields} when in edit mode.
     *
     * @return Current canResizeFields value. Default value is true
     */
    public Boolean getCanResizeFields()  {
        Boolean result = getAttributeAsBoolean("canResizeFields");
        return result == null ? true : result;
    }
    

    /**
     * Controls whether formula fields created while in edit mode are editable by end users at runtime (when the grid is no
     * longer in edit mode).  See {@link com.smartgwt.client.widgets.grid.ListGridField#getCanEditFormula
     * ListGridField.canEditFormula}.
     *
     * @param generateEditableFormulas New generateEditableFormulas value. Default value is true
     * @return {@link com.smartgwt.client.tools.GridEditProxy GridEditProxy} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public GridEditProxy setGenerateEditableFormulas(Boolean generateEditableFormulas)  throws IllegalStateException {
        return (GridEditProxy)setAttribute("generateEditableFormulas", generateEditableFormulas, false);
    }

    /**
     * Controls whether formula fields created while in edit mode are editable by end users at runtime (when the grid is no
     * longer in edit mode).  See {@link com.smartgwt.client.widgets.grid.ListGridField#getCanEditFormula
     * ListGridField.canEditFormula}.
     *
     * @return Current generateEditableFormulas value. Default value is true
     */
    public Boolean getGenerateEditableFormulas()  {
        Boolean result = getAttributeAsBoolean("generateEditableFormulas");
        return result == null ? true : result;
    }
    

    /**
     * Controls whether highlights created while in edit mode are editable by end users at runtime (when the grid is no longer
     * in edit mode).  See {@link com.smartgwt.client.data.Hilite#getCanEdit Hilite.canEdit}.
     *
     * @param generateEditableHilites New generateEditableHilites value. Default value is true
     * @return {@link com.smartgwt.client.tools.GridEditProxy GridEditProxy} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public GridEditProxy setGenerateEditableHilites(Boolean generateEditableHilites)  throws IllegalStateException {
        return (GridEditProxy)setAttribute("generateEditableHilites", generateEditableHilites, false);
    }

    /**
     * Controls whether highlights created while in edit mode are editable by end users at runtime (when the grid is no longer
     * in edit mode).  See {@link com.smartgwt.client.data.Hilite#getCanEdit Hilite.canEdit}.
     *
     * @return Current generateEditableHilites value. Default value is true
     */
    public Boolean getGenerateEditableHilites()  {
        Boolean result = getAttributeAsBoolean("generateEditableHilites");
        return result == null ? true : result;
    }
    

    /**
     * Controls whether summary fields created while in edit mode are editable by end users at runtime (when the grid is no
     * longer in edit mode).  See {@link com.smartgwt.client.widgets.grid.ListGridField#getCanEditSummary
     * ListGridField.canEditSummary}.
     *
     * @param generateEditableSummaries New generateEditableSummaries value. Default value is true
     * @return {@link com.smartgwt.client.tools.GridEditProxy GridEditProxy} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public GridEditProxy setGenerateEditableSummaries(Boolean generateEditableSummaries)  throws IllegalStateException {
        return (GridEditProxy)setAttribute("generateEditableSummaries", generateEditableSummaries, false);
    }

    /**
     * Controls whether summary fields created while in edit mode are editable by end users at runtime (when the grid is no
     * longer in edit mode).  See {@link com.smartgwt.client.widgets.grid.ListGridField#getCanEditSummary
     * ListGridField.canEditSummary}.
     *
     * @return Current generateEditableSummaries value. Default value is true
     */
    public Boolean getGenerateEditableSummaries()  {
        Boolean result = getAttributeAsBoolean("generateEditableSummaries");
        return result == null ? true : result;
    }
    

    /**
     * Should changes to which fields are {@link com.smartgwt.client.widgets.grid.ListGridField#getFrozen frozen} be persisted?
     * <p> Note that changes are saved directly into the ListGridFields not via fieldState or viewState settings. EditNodes
     * will also be introduced for fields as needed if they do not already exist. <p> Only valid with {@link
     * com.smartgwt.client.types.SelectedAppearance} settings that allow direct interactivity (such as "outlineEdges").
     *
     * @param saveFieldFrozenState New saveFieldFrozenState value. Default value is true
     * @return {@link com.smartgwt.client.tools.GridEditProxy GridEditProxy} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public GridEditProxy setSaveFieldFrozenState(Boolean saveFieldFrozenState)  throws IllegalStateException {
        return (GridEditProxy)setAttribute("saveFieldFrozenState", saveFieldFrozenState, false);
    }

    /**
     * Should changes to which fields are {@link com.smartgwt.client.widgets.grid.ListGridField#getFrozen frozen} be persisted?
     * <p> Note that changes are saved directly into the ListGridFields not via fieldState or viewState settings. EditNodes
     * will also be introduced for fields as needed if they do not already exist. <p> Only valid with {@link
     * com.smartgwt.client.types.SelectedAppearance} settings that allow direct interactivity (such as "outlineEdges").
     *
     * @return Current saveFieldFrozenState value. Default value is true
     */
    public Boolean getSaveFieldFrozenState()  {
        Boolean result = getAttributeAsBoolean("saveFieldFrozenState");
        return result == null ? true : result;
    }
    

    /**
     * Should changes to grid field order be persisted? <p> Note that changes are saved directly into the ListGridFields not
     * via fieldState or viewState settings. EditNodes will also be introduced for fields as needed if they do not already
     * exist. <p> Only valid with {@link com.smartgwt.client.types.SelectedAppearance} settings that allow direct interactivity
     * (such as "outlineEdges").
     *
     * @param saveFieldOrder New saveFieldOrder value. Default value is true
     * @return {@link com.smartgwt.client.tools.GridEditProxy GridEditProxy} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public GridEditProxy setSaveFieldOrder(Boolean saveFieldOrder)  throws IllegalStateException {
        return (GridEditProxy)setAttribute("saveFieldOrder", saveFieldOrder, false);
    }

    /**
     * Should changes to grid field order be persisted? <p> Note that changes are saved directly into the ListGridFields not
     * via fieldState or viewState settings. EditNodes will also be introduced for fields as needed if they do not already
     * exist. <p> Only valid with {@link com.smartgwt.client.types.SelectedAppearance} settings that allow direct interactivity
     * (such as "outlineEdges").
     *
     * @return Current saveFieldOrder value. Default value is true
     */
    public Boolean getSaveFieldOrder()  {
        Boolean result = getAttributeAsBoolean("saveFieldOrder");
        return result == null ? true : result;
    }
    

    /**
     * Should changes to grid field visibility be persisted? <p> Note that changes are saved directly into the ListGridFields
     * not via fieldState or viewState settings. EditNodes will also be introduced for fields as needed if they do not already
     * exist. <p> Only valid with {@link com.smartgwt.client.types.SelectedAppearance} settings that allow direct interactivity
     * (such as "outlineEdges").
     *
     * @param saveFieldVisibility New saveFieldVisibility value. Default value is true
     * @return {@link com.smartgwt.client.tools.GridEditProxy GridEditProxy} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public GridEditProxy setSaveFieldVisibility(Boolean saveFieldVisibility)  throws IllegalStateException {
        return (GridEditProxy)setAttribute("saveFieldVisibility", saveFieldVisibility, false);
    }

    /**
     * Should changes to grid field visibility be persisted? <p> Note that changes are saved directly into the ListGridFields
     * not via fieldState or viewState settings. EditNodes will also be introduced for fields as needed if they do not already
     * exist. <p> Only valid with {@link com.smartgwt.client.types.SelectedAppearance} settings that allow direct interactivity
     * (such as "outlineEdges").
     *
     * @return Current saveFieldVisibility value. Default value is true
     */
    public Boolean getSaveFieldVisibility()  {
        Boolean result = getAttributeAsBoolean("saveFieldVisibility");
        return result == null ? true : result;
    }
    

    /**
     * Should changes to filter criteria by end user editing of criteria in the {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getShowFilterEditor filter editor} by persisted? <p> Only valid with {@link
     * com.smartgwt.client.types.SelectedAppearance} settings that allow direct interactivity (such as "outlineEdges").
     *
     * @param saveFilterCriteria New saveFilterCriteria value. Default value is true
     * @return {@link com.smartgwt.client.tools.GridEditProxy GridEditProxy} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public GridEditProxy setSaveFilterCriteria(Boolean saveFilterCriteria)  throws IllegalStateException {
        return (GridEditProxy)setAttribute("saveFilterCriteria", saveFilterCriteria, false);
    }

    /**
     * Should changes to filter criteria by end user editing of criteria in the {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getShowFilterEditor filter editor} by persisted? <p> Only valid with {@link
     * com.smartgwt.client.types.SelectedAppearance} settings that allow direct interactivity (such as "outlineEdges").
     *
     * @return Current saveFilterCriteria value. Default value is true
     */
    public Boolean getSaveFilterCriteria()  {
        Boolean result = getAttributeAsBoolean("saveFilterCriteria");
        return result == null ? true : result;
    }
    

    /**
     * Should changes to grid grouping (including both grouping and ungrouping the grid) be persisted? <p> Only valid with
     * {@link com.smartgwt.client.types.SelectedAppearance} settings that allow direct interactivity (such as "outlineEdges").
     *
     * @param saveGroupBy New saveGroupBy value. Default value is true
     * @return {@link com.smartgwt.client.tools.GridEditProxy GridEditProxy} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public GridEditProxy setSaveGroupBy(Boolean saveGroupBy)  throws IllegalStateException {
        return (GridEditProxy)setAttribute("saveGroupBy", saveGroupBy, false);
    }

    /**
     * Should changes to grid grouping (including both grouping and ungrouping the grid) be persisted? <p> Only valid with
     * {@link com.smartgwt.client.types.SelectedAppearance} settings that allow direct interactivity (such as "outlineEdges").
     *
     * @return Current saveGroupBy value. Default value is true
     */
    public Boolean getSaveGroupBy()  {
        Boolean result = getAttributeAsBoolean("saveGroupBy");
        return result == null ? true : result;
    }
    

    /**
     * Should changes to which fields are sorted be persisted? <p> Only valid with {@link
     * com.smartgwt.client.types.SelectedAppearance} settings that allow direct interactivity (such as "outlineEdges").
     *
     * @param saveSort New saveSort value. Default value is true
     * @return {@link com.smartgwt.client.tools.GridEditProxy GridEditProxy} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public GridEditProxy setSaveSort(Boolean saveSort)  throws IllegalStateException {
        return (GridEditProxy)setAttribute("saveSort", saveSort, false);
    }

    /**
     * Should changes to which fields are sorted be persisted? <p> Only valid with {@link
     * com.smartgwt.client.types.SelectedAppearance} settings that allow direct interactivity (such as "outlineEdges").
     *
     * @return Current saveSort value. Default value is true
     */
    public Boolean getSaveSort()  {
        Boolean result = getAttributeAsBoolean("saveSort");
        return result == null ? true : result;
    }
    

    // ********************* Methods ***********************
	/**
     * Returns the text based on the current component state to be edited inline. Called by the {@link
     * com.smartgwt.client.tools.EditProxy#getInlineEditForm EditProxy.inlineEditForm} to obtain the starting edit value. <p>
     * Returns the grid's wiki-style data - see {@link com.smartgwt.client.data.MockDataSource#getMockData
     * MockDataSource.mockData} for a description of this format.
     */
    public native void getInlineEditText() /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getInlineEditText", "");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.getInlineEditText();
    }-*/;

	/**
     * Save the new value into the component's state. Called by the {@link
     * com.smartgwt.client.tools.EditProxy#getInlineEditForm EditProxy.inlineEditForm} to commit the change. <p> Updates the
     * grid's data and field configuration.
     * @param newValue the new grid configuration
     */
    public native void setInlineEditText(String newValue) /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "setInlineEditText", "String");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.setInlineEditText(newValue);
    }-*/;


    // ********************* Static Methods ***********************

    // ***********************************************************

}
