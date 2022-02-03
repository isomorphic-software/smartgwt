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
 
package com.smartgwt.client.widgets.cube;


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
 * Facet definition object made use of by the {@link com.smartgwt.client.widgets.cube.CubeGrid CubeGrid} and {@link
 * com.smartgwt.client.widgets.chart.FacetChart FacetChart} classes.
 */
@BeanFactory.FrameworkClass
public class Facet extends RefDataClass {

    public static Facet getOrCreateRef(JavaScriptObject jsObj) {
        if (jsObj == null) return null;

        final RefDataClass existingObj = RefDataClass.getRef(jsObj);

        if (existingObj instanceof Facet) {
            existingObj.setJsObj(jsObj);
            return (Facet)existingObj;
        } else
        if (existingObj != null) {
            final Facet newObj = new Facet();
            newObj.setJsObj(jsObj);
            return newObj;

        } else
        {
            return new Facet(jsObj);
        }
    }
        


    public Facet(){
        
    }

    public Facet(JavaScriptObject jsObj){
        
        setJavaScriptObject(jsObj);
        setAttribute(com.smartgwt.client.util.SC.REF, (Object) this);
        setAttribute(com.smartgwt.client.util.SC.MODULE, (Object) BeanFactory.getSGWTModule());
    }


    public Facet(String id) {
        setId(id);
                
    }


    public Facet(String id, String title) {
        setId(id);
		setTitle(title);
                
    }


    // ********************* Properties / Attributes ***********************

    /**
     * Default alignment for facet label title, and cells for this facet. Can be overridden at the facetValue level, or by
     * setting titleAlign or cellAlign on the facet. <P> <b>Note:</b>  This property is specific to {@link
     * com.smartgwt.client.widgets.cube.CubeGrid CubeGrids} (see, for example, {@link
     * com.smartgwt.client.widgets.cube.CubeGrid#getFacetValueAlign CubeGrid.facetValueAlign}).
     *
     * @param align New align value. Default value is null
     * @see com.smartgwt.client.widgets.cube.Facet#setTitleAlign
     * @see com.smartgwt.client.widgets.cube.Facet#setCellAlign
     */
    public void setAlign(Alignment align) {
        setAttribute("align", align == null ? null : align.getValue());
    }

    /**
     * Default alignment for facet label title, and cells for this facet. Can be overridden at the facetValue level, or by
     * setting titleAlign or cellAlign on the facet. <P> <b>Note:</b>  This property is specific to {@link
     * com.smartgwt.client.widgets.cube.CubeGrid CubeGrids} (see, for example, {@link
     * com.smartgwt.client.widgets.cube.CubeGrid#getFacetValueAlign CubeGrid.facetValueAlign}).
     *
     * @return Current align value. Default value is null
     * @see com.smartgwt.client.widgets.cube.Facet#getTitleAlign
     * @see com.smartgwt.client.widgets.cube.Facet#getCellAlign
     */
    public Alignment getAlign()  {
        return EnumUtil.getEnum(Alignment.values(), getAttribute("align"));
    }
    

    /**
     * CSS line style to apply as a border after this facet, eg "1px dashed blue" <P> <b>Note:</b>  This property is specific
     * to {@link com.smartgwt.client.widgets.cube.CubeGrid CubeGrids}.
     *
     * @param borderAfter New borderAfter value. Default value is null
     */
    public void setBorderAfter(String borderAfter) {
        setAttribute("borderAfter", borderAfter);
    }

    /**
     * CSS line style to apply as a border after this facet, eg "1px dashed blue" <P> <b>Note:</b>  This property is specific
     * to {@link com.smartgwt.client.widgets.cube.CubeGrid CubeGrids}.
     *
     * @return Current borderAfter value. Default value is null
     */
    public String getBorderAfter()  {
        return getAttributeAsString("borderAfter");
    }
    

    /**
     * CSS line style to apply as a border before this facet, eg "1px dashed blue" <P> <b>Note:</b>  This property is specific
     * to {@link com.smartgwt.client.widgets.cube.CubeGrid CubeGrids}.
     *
     * @param borderBefore New borderBefore value. Default value is null
     */
    public void setBorderBefore(String borderBefore) {
        setAttribute("borderBefore", borderBefore);
    }

    /**
     * CSS line style to apply as a border before this facet, eg "1px dashed blue" <P> <b>Note:</b>  This property is specific
     * to {@link com.smartgwt.client.widgets.cube.CubeGrid CubeGrids}.
     *
     * @return Current borderBefore value. Default value is null
     */
    public String getBorderBefore()  {
        return getAttributeAsString("borderBefore");
    }
    

    /**
     * For tree facets, whether expand/collapse controls should be shown. <P> <b>Note:</b>  This property is specific to {@link
     * com.smartgwt.client.widgets.cube.CubeGrid CubeGrids} (see, for example, {@link
     * com.smartgwt.client.widgets.cube.CubeGrid#getCanCollapseFacets CubeGrid.canCollapseFacets}).
     *
     * @param canCollapse New canCollapse value. Default value is facet.isTree
     */
    public void setCanCollapse(Boolean canCollapse) {
        setAttribute("canCollapse", canCollapse);
    }

    /**
     * For tree facets, whether expand/collapse controls should be shown. <P> <b>Note:</b>  This property is specific to {@link
     * com.smartgwt.client.widgets.cube.CubeGrid CubeGrids} (see, for example, {@link
     * com.smartgwt.client.widgets.cube.CubeGrid#getCanCollapseFacets CubeGrid.canCollapseFacets}).
     *
     * @return Current canCollapse value. Default value is facet.isTree
     */
    public Boolean getCanCollapse()  {
        return getAttributeAsBoolean("canCollapse", true);
    }
    

    /**
     * If facet minimizing is enabled, whether this facet should show controls to minimize the next facet.  Generally a tree
     * facet should not also allow minimizing the next facet - the interaction of the two types of collapsing can be confusing.
     * <P> <b>Note:</b>  This property is specific to {@link com.smartgwt.client.widgets.cube.CubeGrid CubeGrids}.  See {@link
     * com.smartgwt.client.widgets.cube.CubeGrid#getCanMinimizeFacets CubeGrid.canMinimizeFacets}.
     *
     * @param canMinimize New canMinimize value. Default value is cubeGrid.canMinimizeFacets
     */
    public void setCanMinimize(Boolean canMinimize) {
        setAttribute("canMinimize", canMinimize);
    }

    /**
     * If facet minimizing is enabled, whether this facet should show controls to minimize the next facet.  Generally a tree
     * facet should not also allow minimizing the next facet - the interaction of the two types of collapsing can be confusing.
     * <P> <b>Note:</b>  This property is specific to {@link com.smartgwt.client.widgets.cube.CubeGrid CubeGrids}.  See {@link
     * com.smartgwt.client.widgets.cube.CubeGrid#getCanMinimizeFacets CubeGrid.canMinimizeFacets}.
     *
     * @return Current canMinimize value. Default value is cubeGrid.canMinimizeFacets
     */
    public Boolean getCanMinimize()  {
        return getAttributeAsBoolean("canMinimize", true);
    }
    

    /**
     * Default alignment of cells (in the body) for this facet. <P> <b>Note:</b>  This property is specific to {@link
     * com.smartgwt.client.widgets.cube.CubeGrid CubeGrids}.
     *
     * @param cellAlign New cellAlign value. Default value is cubeGrid.cellAlign
     * @see com.smartgwt.client.widgets.cube.CubeGrid#setCellAlign
     */
    public void setCellAlign(Alignment cellAlign) {
        setAttribute("cellAlign", cellAlign == null ? null : cellAlign.getValue());
    }

    /**
     * Default alignment of cells (in the body) for this facet. <P> <b>Note:</b>  This property is specific to {@link
     * com.smartgwt.client.widgets.cube.CubeGrid CubeGrids}.
     *
     * @return Current cellAlign value. Default value is cubeGrid.cellAlign
     * @see com.smartgwt.client.widgets.cube.CubeGrid#getCellAlign
     */
    public Alignment getCellAlign()  {
        return EnumUtil.getEnum(Alignment.values(), getAttribute("cellAlign"));
    }
    

    /**
     * For tree facets, default collapse state for parent nodes. <P> <b>Note:</b>  This property is specific to {@link
     * com.smartgwt.client.widgets.cube.CubeGrid CubeGrids}.
     *
     * @param collapsed New collapsed value. Default value is false
     */
    public void setCollapsed(Boolean collapsed) {
        setAttribute("collapsed", collapsed);
    }

    /**
     * For tree facets, default collapse state for parent nodes. <P> <b>Note:</b>  This property is specific to {@link
     * com.smartgwt.client.widgets.cube.CubeGrid CubeGrids}.
     *
     * @return Current collapsed value. Default value is false
     */
    public Boolean getCollapsed()  {
        Boolean result = getAttributeAsBoolean("collapsed", true);
        return result == null ? false : result;
    }
    

    /**
     * Integer number of pixels.  For column facets, specifies the height of header. Has no effect on row facets. <P> If this
     * property conflicts with a {@link com.smartgwt.client.widgets.cube.Facet#getLabelHeight labelHeight}, the greater of the
     * two properties will be used for determining the height of the affected row. <P> <b>Note:</b>  This property is specific
     * to {@link com.smartgwt.client.widgets.cube.CubeGrid CubeGrids}.
     *
     * @param height New height value. Default value is null
     */
    public void setHeight(Integer height) {
        setAttribute("height", height);
    }

    /**
     * Integer number of pixels.  For column facets, specifies the height of header. Has no effect on row facets. <P> If this
     * property conflicts with a {@link com.smartgwt.client.widgets.cube.Facet#getLabelHeight labelHeight}, the greater of the
     * two properties will be used for determining the height of the affected row. <P> <b>Note:</b>  This property is specific
     * to {@link com.smartgwt.client.widgets.cube.CubeGrid CubeGrids}.
     *
     * @return Current height value. Default value is null
     */
    public Integer getHeight()  {
        return getAttributeAsInt("height");
    }
    
    

    /**
     * Controls indenting for a {@link com.smartgwt.client.widgets.cube.Facet#getIsTree hierarchical} column facet if set
     * non-null, overrriding the value of {@link com.smartgwt.client.widgets.cube.CubeGrid#getIndentVTreeFacets
     * CubeGrid.indentVTreeFacets}.
     *
     * @param indentVTree New indentVTree value. Default value is null
     * @see com.smartgwt.client.widgets.cube.CubeGrid#setVTreeFacetIndentDirection
     */
    public void setIndentVTree(Boolean indentVTree) {
        setAttribute("indentVTree", indentVTree);
    }

    /**
     * Controls indenting for a {@link com.smartgwt.client.widgets.cube.Facet#getIsTree hierarchical} column facet if set
     * non-null, overrriding the value of {@link com.smartgwt.client.widgets.cube.CubeGrid#getIndentVTreeFacets
     * CubeGrid.indentVTreeFacets}.
     *
     * @return Current indentVTree value. Default value is null
     * @see com.smartgwt.client.widgets.cube.CubeGrid#getVTreeFacetIndentDirection
     */
    public Boolean getIndentVTree()  {
        return getAttributeAsBoolean("indentVTree", true);
    }
    

    /**
     * When applied to a Chart, does the chart's data contain multiple values per record for this facet. See  Chart.data for a
     * full overview of <code>inlinedValues</code> behavior.
     *
     * @param inlinedValues New inlinedValues value. Default value is null
     */
    public void setInlinedValues(Boolean inlinedValues) {
        setAttribute("inlinedValues", inlinedValues);
    }

    /**
     * When applied to a Chart, does the chart's data contain multiple values per record for this facet. See  Chart.data for a
     * full overview of <code>inlinedValues</code> behavior.
     *
     * @return Current inlinedValues value. Default value is null
     */
    public Boolean getInlinedValues()  {
        return getAttributeAsBoolean("inlinedValues", true);
    }
    

    /**
     * Marks this facet as a hierarchical facet. <P> If set, {@link com.smartgwt.client.widgets.cube.Facet#getValues
     * facet.value} will be linked as for a {@link com.smartgwt.client.widgets.tree.Tree#getModelType modelType:"parent"} Tree,
     * using {@link com.smartgwt.client.widgets.cube.FacetValue#getId facetValue.id} and {@link
     * com.smartgwt.client.widgets.cube.FacetValue#getParentId facetValue.parentId}. Expand/collapse controls will be shown
     * allowing navigation of the facet's values. <P> The CubeGrid's {@link
     * com.smartgwt.client.widgets.cube.CubeGrid#getDataSource load on demand} system automatically avoids fetching data for
     * facetValues that are not currently visible due to the expand/collapse state of a tree facet. <P> Initial open/close
     * state can be controlled via {@link com.smartgwt.client.widgets.cube.Facet#getCollapsed facet.collapsed} and {@link
     * com.smartgwt.client.widgets.cube.FacetValue#getCollapsed FacetValue.collapsed}. <P> <b>Note:</b>  This property is
     * specific to {@link com.smartgwt.client.widgets.cube.CubeGrid CubeGrids}.
     *
     * @param isTree New isTree value. Default value is false
     */
    public void setIsTree(Boolean isTree) {
        setAttribute("isTree", isTree);
    }

    /**
     * Marks this facet as a hierarchical facet. <P> If set, {@link com.smartgwt.client.widgets.cube.Facet#getValues
     * facet.value} will be linked as for a {@link com.smartgwt.client.widgets.tree.Tree#getModelType modelType:"parent"} Tree,
     * using {@link com.smartgwt.client.widgets.cube.FacetValue#getId facetValue.id} and {@link
     * com.smartgwt.client.widgets.cube.FacetValue#getParentId facetValue.parentId}. Expand/collapse controls will be shown
     * allowing navigation of the facet's values. <P> The CubeGrid's {@link
     * com.smartgwt.client.widgets.cube.CubeGrid#getDataSource load on demand} system automatically avoids fetching data for
     * facetValues that are not currently visible due to the expand/collapse state of a tree facet. <P> Initial open/close
     * state can be controlled via {@link com.smartgwt.client.widgets.cube.Facet#getCollapsed facet.collapsed} and {@link
     * com.smartgwt.client.widgets.cube.FacetValue#getCollapsed FacetValue.collapsed}. <P> <b>Note:</b>  This property is
     * specific to {@link com.smartgwt.client.widgets.cube.CubeGrid CubeGrids}.
     *
     * @return Current isTree value. Default value is false
     */
    public Boolean getIsTree()  {
        Boolean result = getAttributeAsBoolean("isTree", true);
        return result == null ? false : result;
    }
    

    /**
     * Integer number of pixels.  For column facets other than the innermost, specifies the height of the header.  For row
     * facets, specifies the height of the row containing that row facet's label (which is the same row containing the 
     * innermost column facet if one or more column facets are present). <P> If this property conflicts with a {@link
     * com.smartgwt.client.widgets.cube.Facet#getHeight height}, the greater of the two properties will be used for determining
     * the height of the affected row. <P> <b>Note:</b>  This property is specific to {@link
     * com.smartgwt.client.widgets.cube.CubeGrid CubeGrids}.
     *
     * @param labelHeight New labelHeight value. Default value is null
     */
    public void setLabelHeight(Integer labelHeight) {
        setAttribute("labelHeight", labelHeight);
    }

    /**
     * Integer number of pixels.  For column facets other than the innermost, specifies the height of the header.  For row
     * facets, specifies the height of the row containing that row facet's label (which is the same row containing the 
     * innermost column facet if one or more column facets are present). <P> If this property conflicts with a {@link
     * com.smartgwt.client.widgets.cube.Facet#getHeight height}, the greater of the two properties will be used for determining
     * the height of the affected row. <P> <b>Note:</b>  This property is specific to {@link
     * com.smartgwt.client.widgets.cube.CubeGrid CubeGrids}.
     *
     * @return Current labelHeight value. Default value is null
     */
    public Integer getLabelHeight()  {
        return getAttributeAsInt("labelHeight");
    }
    

    /**
     * Default {@link com.smartgwt.client.widgets.cube.CubeGrid#getCanMinimizeFacets minimize state} for parent nodes. <P>
     * <b>Note:</b>  This property is specific to {@link com.smartgwt.client.widgets.cube.CubeGrid CubeGrids}.
     *
     * @param minimized New minimized value. Default value is false
     */
    public void setMinimized(Boolean minimized) {
        setAttribute("minimized", minimized);
    }

    /**
     * Default {@link com.smartgwt.client.widgets.cube.CubeGrid#getCanMinimizeFacets minimize state} for parent nodes. <P>
     * <b>Note:</b>  This property is specific to {@link com.smartgwt.client.widgets.cube.CubeGrid CubeGrids}.
     *
     * @return Current minimized value. Default value is false
     */
    public Boolean getMinimized()  {
        Boolean result = getAttributeAsBoolean("minimized", true);
        return result == null ? false : result;
    }
    

    /**
     * For {@link com.smartgwt.client.widgets.chart.FacetChart FacetCharts} only, this property specifies the value axis label
     * when a FacetChart is in {@link com.smartgwt.client.widgets.chart.FacetChart#getProportional proportional rendering mode}
     * and has this facet as its {@link com.smartgwt.client.widgets.chart.FacetChart#getLegendFacet legend facet}.  If the
     * <code>proportionalTitle</code> is not specified then {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getProportionalAxisLabel FacetChart.proportionalAxisLabel} is used as the
     * default title.
     *
     * @param proportionalTitle New proportionalTitle value. Default value is null
     */
    public void setProportionalTitle(String proportionalTitle) {
        setAttribute("proportionalTitle", proportionalTitle);
    }

    /**
     * For {@link com.smartgwt.client.widgets.chart.FacetChart FacetCharts} only, this property specifies the value axis label
     * when a FacetChart is in {@link com.smartgwt.client.widgets.chart.FacetChart#getProportional proportional rendering mode}
     * and has this facet as its {@link com.smartgwt.client.widgets.chart.FacetChart#getLegendFacet legend facet}.  If the
     * <code>proportionalTitle</code> is not specified then {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getProportionalAxisLabel FacetChart.proportionalAxisLabel} is used as the
     * default title.
     *
     * @return Current proportionalTitle value. Default value is null
     */
    public String getProportionalTitle()  {
        return getAttributeAsString("proportionalTitle");
    }
    

    /**
     * facetValueId of the rollup facetValue for this facet. <P> <b>Note:</b>  This property is specific to {@link
     * com.smartgwt.client.widgets.cube.CubeGrid CubeGrids}.  See {@link
     * com.smartgwt.client.widgets.cube.CubeGrid#getRollupValue CubeGrid.rollupValue}.
     *
     * @param rollupValue New rollupValue value. Default value is cubeGrid.rollupValue
     */
    public void setRollupValue(String rollupValue) {
        setAttribute("rollupValue", rollupValue);
    }

    /**
     * facetValueId of the rollup facetValue for this facet. <P> <b>Note:</b>  This property is specific to {@link
     * com.smartgwt.client.widgets.cube.CubeGrid CubeGrids}.  See {@link
     * com.smartgwt.client.widgets.cube.CubeGrid#getRollupValue CubeGrid.rollupValue}.
     *
     * @return Current rollupValue value. Default value is cubeGrid.rollupValue
     */
    public String getRollupValue()  {
        return getAttributeAsString("rollupValue");
    }
    

    /**
     * Selection boundary determining what facets / facetValues can be selected together by drag selection / shift+click
     * selection. <P> <b>Note:</b>  This property is specific to {@link com.smartgwt.client.widgets.cube.CubeGrid CubeGrids}.
     *
     * @param selectionBoundary New selectionBoundary value. Default value is null
     */
    public void setSelectionBoundary(SelectionBoundary selectionBoundary) {
        setAttribute("selectionBoundary", selectionBoundary == null ? null : selectionBoundary.getValue());
    }

    /**
     * Selection boundary determining what facets / facetValues can be selected together by drag selection / shift+click
     * selection. <P> <b>Note:</b>  This property is specific to {@link com.smartgwt.client.widgets.cube.CubeGrid CubeGrids}.
     *
     * @return Current selectionBoundary value. Default value is null
     */
    public SelectionBoundary getSelectionBoundary()  {
        return EnumUtil.getEnum(SelectionBoundary.values(), getAttribute("selectionBoundary"));
    }
    

    /**
     * Indicates internal hierarchy should be displayed in reverse of normal tree order (so that parents follow children). <P>
     * <b>Note:</b>  This property is specific to {@link com.smartgwt.client.widgets.cube.CubeGrid CubeGrids}.
     *
     * @param showParentsLast New showParentsLast value. Default value is false
     */
    public void setShowParentsLast(Boolean showParentsLast) {
        setAttribute("showParentsLast", showParentsLast);
    }

    /**
     * Indicates internal hierarchy should be displayed in reverse of normal tree order (so that parents follow children). <P>
     * <b>Note:</b>  This property is specific to {@link com.smartgwt.client.widgets.cube.CubeGrid CubeGrids}.
     *
     * @return Current showParentsLast value. Default value is false
     */
    public Boolean getShowParentsLast()  {
        Boolean result = getAttributeAsBoolean("showParentsLast", true);
        return result == null ? false : result;
    }
    

    /**
     * Title for facet summary. <P> <b>Note:</b>  This property is specific to {@link com.smartgwt.client.widgets.cube.CubeGrid
     * CubeGrids}.
     *
     * @param summaryTitle New summaryTitle value. Default value is cubeGrid.summaryTitle
     */
    public void setSummaryTitle(String summaryTitle) {
        setAttribute("summaryTitle", summaryTitle);
    }

    /**
     * Title for facet summary. <P> <b>Note:</b>  This property is specific to {@link com.smartgwt.client.widgets.cube.CubeGrid
     * CubeGrids}.
     *
     * @return Current summaryTitle value. Default value is cubeGrid.summaryTitle
     */
    public String getSummaryTitle()  {
        return getAttributeAsString("summaryTitle");
    }
    

    /**
     * Value for facet summary. <P> <b>Note:</b>  This property is specific to {@link com.smartgwt.client.widgets.cube.CubeGrid
     * CubeGrids}.
     *
     * @param summaryValue New summaryValue value. Default value is cubeGrid.summaryValue
     */
    public void setSummaryValue(String summaryValue) {
        setAttribute("summaryValue", summaryValue);
    }

    /**
     * Value for facet summary. <P> <b>Note:</b>  This property is specific to {@link com.smartgwt.client.widgets.cube.CubeGrid
     * CubeGrids}.
     *
     * @return Current summaryValue value. Default value is cubeGrid.summaryValue
     */
    public String getSummaryValue()  {
        return getAttributeAsString("summaryValue");
    }
    

    /**
     * If true, treat all values in this facet as a facetValueGroup - causes synched header reorder and resize. <P>
     * <b>Note:</b>  This property is specific to {@link com.smartgwt.client.widgets.cube.CubeGrid CubeGrids} and is only
     * supported when all of a facet's values are used.
     *
     * @param synchColumnLayout New synchColumnLayout value. Default value is true
     */
    public void setSynchColumnLayout(Boolean synchColumnLayout) {
        setAttribute("synchColumnLayout", synchColumnLayout);
    }

    /**
     * If true, treat all values in this facet as a facetValueGroup - causes synched header reorder and resize. <P>
     * <b>Note:</b>  This property is specific to {@link com.smartgwt.client.widgets.cube.CubeGrid CubeGrids} and is only
     * supported when all of a facet's values are used.
     *
     * @return Current synchColumnLayout value. Default value is true
     */
    public Boolean getSynchColumnLayout()  {
        Boolean result = getAttributeAsBoolean("synchColumnLayout", true);
        return result == null ? true : result;
    }
    

    /**
     * User-visible title of this facet.  Shown on the facet label in the CubeGrid.
     *
     * @param title New title value. Default value is null
     */
    public void setTitle(String title) {
        setAttribute("title", title);
    }

    /**
     * User-visible title of this facet.  Shown on the facet label in the CubeGrid.
     *
     * @return Current title value. Default value is null
     */
    public String getTitle()  {
        return getAttributeAsString("title");
    }
    

    /**
     * Alignment of facet label title. <P> <b>Note:</b>  This property is specific to {@link
     * com.smartgwt.client.widgets.cube.CubeGrid CubeGrids}.
     *
     * @param titleAlign New titleAlign value. Default value is cubeGrid.facetTitleAlign
     * @see com.smartgwt.client.widgets.cube.CubeGrid#setFacetTitleAlign
     */
    public void setTitleAlign(Alignment titleAlign) {
        setAttribute("titleAlign", titleAlign == null ? null : titleAlign.getValue());
    }

    /**
     * Alignment of facet label title. <P> <b>Note:</b>  This property is specific to {@link
     * com.smartgwt.client.widgets.cube.CubeGrid CubeGrids}.
     *
     * @return Current titleAlign value. Default value is cubeGrid.facetTitleAlign
     * @see com.smartgwt.client.widgets.cube.CubeGrid#getFacetTitleAlign
     */
    public Alignment getTitleAlign()  {
        return EnumUtil.getEnum(Alignment.values(), getAttribute("titleAlign"));
    }
    

    /**
     * Array of facetValue definitions.
     *
     * @param values New values value. Default value is null
     * @see com.smartgwt.client.widgets.cube.FacetValue
     */
    public void setValues(FacetValue... values) {
        setAttribute("values", values);
    }

    /**
     * Array of facetValue definitions.
     *
     * @return Current values value. Default value is null
     * @see com.smartgwt.client.widgets.cube.FacetValue
     */
    public FacetValue[] getValues()  {
        return com.smartgwt.client.util.ConvertTo.arrayOfFacetValue(getAttributeAsJavaScriptObject("values"));
    }
    

    /**
     * Integer number of pixels.  For row facets, width of headers. <P> <b>Note:</b>  This property is specific to {@link
     * com.smartgwt.client.widgets.cube.CubeGrid CubeGrids}.
     *
     * @param width New width value. Default value is cubeGrid.defaultFacetWidth
     * @see com.smartgwt.client.widgets.cube.CubeGrid#setDefaultFacetWidth
     */
    public void setWidth(int width) {
        setAttribute("width", width);
    }

    /**
     * Integer number of pixels.  For row facets, width of headers. <P> <b>Note:</b>  This property is specific to {@link
     * com.smartgwt.client.widgets.cube.CubeGrid CubeGrids}.
     *
     * @return Current width value. Default value is cubeGrid.defaultFacetWidth
     * @see com.smartgwt.client.widgets.cube.CubeGrid#getDefaultFacetWidth
     */
    public int getWidth()  {
        return getAttributeAsInt("width");
    }
    

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************

    // ***********************************************************


	
	/**
     * id of this facet.  Any string or number.
     *
     * @param id id Default value is null
     */
    public void setId(Integer id) {
        setAttribute("id", id);
    }
    
    /**
     * id of this facet.  Any string or number.
     *
     * @param id id Default value is null
     */
    public void setId(String id) {
        setAttribute("id", id);
    }
    
    /**
     * id of this facet.  Any string or number.
     *
     * @param id id Default value is null
     */
    public Object getId() {
    	return getAttributeAsObject("id");
    }
    
    /**
     * id of this facet.  Any string or number.
     *
     * @param id id Default value is null
     */
    public String getIdAsString() {
        return getAttributeAsString("id");
    }
    
    /**
     * id of this facet.  Any string or number.
     *
     * @param id id Default value is null
     */
    public Integer getIdAsInt() {
        return getAttributeAsInt("id");
    }


}
