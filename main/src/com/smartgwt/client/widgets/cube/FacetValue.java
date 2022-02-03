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
 * Facet value definition object made use of by the {@link com.smartgwt.client.widgets.cube.CubeGrid CubeGrid} and {@link
 * com.smartgwt.client.widgets.chart.FacetChart FacetChart} classes (contained by facets).
 */
@BeanFactory.FrameworkClass
public class FacetValue extends RefDataClass {

    public static FacetValue getOrCreateRef(JavaScriptObject jsObj) {
        if (jsObj == null) return null;

        final RefDataClass existingObj = RefDataClass.getRef(jsObj);

        if (existingObj instanceof FacetValue) {
            existingObj.setJsObj(jsObj);
            return (FacetValue)existingObj;
        } else
        if (existingObj != null) {
            final FacetValue newObj = new FacetValue();
            newObj.setJsObj(jsObj);
            return newObj;

        } else
        {
            return new FacetValue(jsObj);
        }
    }
        


    public FacetValue(){
        
    }

    public FacetValue(JavaScriptObject jsObj){
        
        setJavaScriptObject(jsObj);
        setAttribute(com.smartgwt.client.util.SC.REF, (Object) this);
        setAttribute(com.smartgwt.client.util.SC.MODULE, (Object) BeanFactory.getSGWTModule());
    }


    public FacetValue(String id) {
        setId(id);
                
    }


    public FacetValue(String id, String title) {
        setId(id);
		setTitle(title);
                
    }


    public FacetValue(String id, String title, String parentId) {
        setId(id);
		setTitle(title);
		setParentId(parentId);
                
    }


    // ********************* Properties / Attributes ***********************

    /**
     * Default alignment for facet label title and cells for this facetValue. Can be overridden by setting titleAlign or
     * cellAlign on the facetValue. <P> <b>Note:</b>  This property is specific to {@link
     * com.smartgwt.client.widgets.cube.CubeGrid CubeGrids} (see, for example, {@link
     * com.smartgwt.client.widgets.cube.CubeGrid#getFacetValueAlign CubeGrid.facetValueAlign}).
     *
     * @param align New align value. Default value is null
     */
    public void setAlign(Alignment align) {
        setAttribute("align", align == null ? null : align.getValue());
    }

    /**
     * Default alignment for facet label title and cells for this facetValue. Can be overridden by setting titleAlign or
     * cellAlign on the facetValue. <P> <b>Note:</b>  This property is specific to {@link
     * com.smartgwt.client.widgets.cube.CubeGrid CubeGrids} (see, for example, {@link
     * com.smartgwt.client.widgets.cube.CubeGrid#getFacetValueAlign CubeGrid.facetValueAlign}).
     *
     * @return Current align value. Default value is null
     */
    public Alignment getAlign()  {
        return EnumUtil.getEnum(Alignment.values(), getAttribute("align"));
    }
    

    /**
     * CSS line style to apply as a border after this facetValue. <P> <b>Note:</b>  This property is specific to {@link
     * com.smartgwt.client.widgets.cube.CubeGrid CubeGrids}.
     *
     * @param borderAfter New borderAfter value. Default value is null
     */
    public void setBorderAfter(String borderAfter) {
        setAttribute("borderAfter", borderAfter);
    }

    /**
     * CSS line style to apply as a border after this facetValue. <P> <b>Note:</b>  This property is specific to {@link
     * com.smartgwt.client.widgets.cube.CubeGrid CubeGrids}.
     *
     * @return Current borderAfter value. Default value is null
     */
    public String getBorderAfter()  {
        return getAttributeAsString("borderAfter");
    }
    

    /**
     * CSS line style to apply as a border before this facetValue. <P> <b>Note:</b>  This property is specific to {@link
     * com.smartgwt.client.widgets.cube.CubeGrid CubeGrids}.
     *
     * @param borderBefore New borderBefore value. Default value is null
     */
    public void setBorderBefore(String borderBefore) {
        setAttribute("borderBefore", borderBefore);
    }

    /**
     * CSS line style to apply as a border before this facetValue. <P> <b>Note:</b>  This property is specific to {@link
     * com.smartgwt.client.widgets.cube.CubeGrid CubeGrids}.
     *
     * @return Current borderBefore value. Default value is null
     */
    public String getBorderBefore()  {
        return getAttributeAsString("borderBefore");
    }
    

    /**
     * For individual parent facetValues within a hierarchical facet, this flag controls whether an expand/collapse control
     * will be shown. <P> <b>Note:</b>  This property is specific to {@link com.smartgwt.client.widgets.cube.CubeGrid
     * CubeGrids} (see, for example, {@link com.smartgwt.client.widgets.cube.CubeGrid#getCanCollapseFacets
     * CubeGrid.canCollapseFacets}).
     *
     * @param canCollapse New canCollapse value. Default value is true
     */
    public void setCanCollapse(Boolean canCollapse) {
        setAttribute("canCollapse", canCollapse);
    }

    /**
     * For individual parent facetValues within a hierarchical facet, this flag controls whether an expand/collapse control
     * will be shown. <P> <b>Note:</b>  This property is specific to {@link com.smartgwt.client.widgets.cube.CubeGrid
     * CubeGrids} (see, for example, {@link com.smartgwt.client.widgets.cube.CubeGrid#getCanCollapseFacets
     * CubeGrid.canCollapseFacets}).
     *
     * @return Current canCollapse value. Default value is true
     */
    public Boolean getCanCollapse()  {
        Boolean result = getAttributeAsBoolean("canCollapse", true);
        return result == null ? true : result;
    }
    

    /**
     * Whether cells for this facetValue can be edited.  Defaults to {@link
     * com.smartgwt.client.widgets.cube.CubeGrid#getCanEdit CubeGrid.canEdit}. <P> <b>Note:</b>  This property is specific to
     * {@link com.smartgwt.client.widgets.cube.CubeGrid CubeGrids}.
     *
     * @param canEdit New canEdit value. Default value is cubeGrid.canEdit
     */
    public void setCanEdit(Boolean canEdit) {
        setAttribute("canEdit", canEdit);
    }

    /**
     * Whether cells for this facetValue can be edited.  Defaults to {@link
     * com.smartgwt.client.widgets.cube.CubeGrid#getCanEdit CubeGrid.canEdit}. <P> <b>Note:</b>  This property is specific to
     * {@link com.smartgwt.client.widgets.cube.CubeGrid CubeGrids}.
     *
     * @return Current canEdit value. Default value is cubeGrid.canEdit
     */
    public Boolean getCanEdit()  {
        return getAttributeAsBoolean("canEdit", true);
    }
    

    /**
     * Default alignment of cells (in the body) for this facetValue. <P> <b>Note:</b>  This property is specific to {@link
     * com.smartgwt.client.widgets.cube.CubeGrid CubeGrids} (see, for example, {@link
     * com.smartgwt.client.widgets.cube.CubeGrid#getCellAlign CubeGrid.cellAlign}).
     *
     * @param cellAlign New cellAlign value. Default value is facet.cellAlign
     */
    public void setCellAlign(Alignment cellAlign) {
        setAttribute("cellAlign", cellAlign == null ? null : cellAlign.getValue());
    }

    /**
     * Default alignment of cells (in the body) for this facetValue. <P> <b>Note:</b>  This property is specific to {@link
     * com.smartgwt.client.widgets.cube.CubeGrid CubeGrids} (see, for example, {@link
     * com.smartgwt.client.widgets.cube.CubeGrid#getCellAlign CubeGrid.cellAlign}).
     *
     * @return Current cellAlign value. Default value is facet.cellAlign
     */
    public Alignment getCellAlign()  {
        return EnumUtil.getEnum(Alignment.values(), getAttribute("cellAlign"));
    }
    

    /**
     * For tree facets, initial collapse state for this node.  Defaults to {@link
     * com.smartgwt.client.widgets.cube.Facet#getCollapsed Facet.collapsed}. <P> <b>Note:</b>  This property is specific to
     * {@link com.smartgwt.client.widgets.cube.CubeGrid CubeGrids}.
     *
     * @param collapsed New collapsed value. Default value is facet.collapsed
     */
    public void setCollapsed(Boolean collapsed) {
        setAttribute("collapsed", collapsed);
    }

    /**
     * For tree facets, initial collapse state for this node.  Defaults to {@link
     * com.smartgwt.client.widgets.cube.Facet#getCollapsed Facet.collapsed}. <P> <b>Note:</b>  This property is specific to
     * {@link com.smartgwt.client.widgets.cube.CubeGrid CubeGrids}.
     *
     * @return Current collapsed value. Default value is facet.collapsed
     */
    public Boolean getCollapsed()  {
        return getAttributeAsBoolean("collapsed", true);
    }
    
    

    /**
     * Used to determine which facetValue is to be shown when the facet is minimized. <P> <b>Note:</b>  This property is
     * specific to {@link com.smartgwt.client.widgets.cube.CubeGrid CubeGrids}.  See {@link
     * com.smartgwt.client.widgets.cube.CubeGrid#getCanMinimizeFacets CubeGrid.canMinimizeFacets}.
     *
     * @param isMinimizeValue New isMinimizeValue value. Default value is false
     */
    public void setIsMinimizeValue(Boolean isMinimizeValue) {
        setAttribute("isMinimizeValue", isMinimizeValue);
    }

    /**
     * Used to determine which facetValue is to be shown when the facet is minimized. <P> <b>Note:</b>  This property is
     * specific to {@link com.smartgwt.client.widgets.cube.CubeGrid CubeGrids}.  See {@link
     * com.smartgwt.client.widgets.cube.CubeGrid#getCanMinimizeFacets CubeGrid.canMinimizeFacets}.
     *
     * @return Current isMinimizeValue value. Default value is false
     */
    public Boolean getIsMinimizeValue()  {
        Boolean result = getAttributeAsBoolean("isMinimizeValue", true);
        return result == null ? false : result;
    }
    

    /**
     * For tree facets ({@link com.smartgwt.client.widgets.cube.Facet#getIsTree facet.isTree}), id of this facetValue's parent
     * facetValue. <P> <b>Note:</b>  This property is specific to {@link com.smartgwt.client.widgets.cube.CubeGrid CubeGrids}.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param parentId New parentId value. Default value is null
     */
    public void setParentId(String parentId) {
        setAttribute("parentId", parentId);
    }

    /**
     * For tree facets ({@link com.smartgwt.client.widgets.cube.Facet#getIsTree facet.isTree}), id of this facetValue's parent
     * facetValue. <P> <b>Note:</b>  This property is specific to {@link com.smartgwt.client.widgets.cube.CubeGrid CubeGrids}.
     *
     * @return Current parentId value. Default value is null
     */
    public String getParentId()  {
        return getAttributeAsString("parentId");
    }

    /**
     * For tree facets ({@link com.smartgwt.client.widgets.cube.Facet#getIsTree facet.isTree}), id of this facetValue's parent
     * facetValue. <P> <b>Note:</b>  This property is specific to {@link com.smartgwt.client.widgets.cube.CubeGrid CubeGrids}.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param parentId New parentId value. Default value is null
     */
    public void setParentId(Integer parentId) {
        setAttribute("parentId", parentId);
    }

    /**
     * For tree facets ({@link com.smartgwt.client.widgets.cube.Facet#getIsTree facet.isTree}), id of this facetValue's parent
     * facetValue. <P> <b>Note:</b>  This property is specific to {@link com.smartgwt.client.widgets.cube.CubeGrid CubeGrids}.
     *
     * @return Current parentId value. Default value is null
     */
    public Integer getParentIdAsInt()  {
        return getAttributeAsInt("parentId");
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
     * User-visible title of this facetValue.  Shown on the field header.
     *
     * @param title New title value. Default value is null
     */
    public void setTitle(String title) {
        setAttribute("title", title);
    }

    /**
     * User-visible title of this facetValue.  Shown on the field header.
     *
     * @return Current title value. Default value is null
     */
    public String getTitle()  {
        return getAttributeAsString("title");
    }
    

    /**
     * Hilite style to apply to the title for this facetValue. <P> <b>Note:</b>  This property is specific to {@link
     * com.smartgwt.client.widgets.cube.CubeGrid CubeGrids}.  See {@link com.smartgwt.client.widgets.cube.CubeGrid#getHilites
     * CubeGrid.hilites}.
     *
     * @param titleHilite New titleHilite value. Default value is null
     */
    public void setTitleHilite(String titleHilite) {
        setAttribute("titleHilite", titleHilite);
    }

    /**
     * Hilite style to apply to the title for this facetValue. <P> <b>Note:</b>  This property is specific to {@link
     * com.smartgwt.client.widgets.cube.CubeGrid CubeGrids}.  See {@link com.smartgwt.client.widgets.cube.CubeGrid#getHilites
     * CubeGrid.hilites}.
     *
     * @return Current titleHilite value. Default value is null
     */
    public String getTitleHilite()  {
        return getAttributeAsString("titleHilite");
    }
    

    /**
     * Width of the cube grid facetValue in pixels. <P> <b>Note:</b>  This property is specific to {@link
     * com.smartgwt.client.widgets.cube.CubeGrid CubeGrids}.
     *
     * @param width New width value. Default value is facet.width
     */
    public void setWidth(int width) {
        setAttribute("width", width);
    }

    /**
     * Width of the cube grid facetValue in pixels. <P> <b>Note:</b>  This property is specific to {@link
     * com.smartgwt.client.widgets.cube.CubeGrid CubeGrids}.
     *
     * @return Current width value. Default value is facet.width
     */
    public int getWidth()  {
        return getAttributeAsInt("width");
    }
    

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************

    // ***********************************************************


    
    public FacetValue(Integer id) {
        setId(id);
    }


    public FacetValue(Integer id, String title) {
        setId(id);
        setTitle(title);
    }


    public FacetValue(Integer id, String title, Integer parentId) {
        setId(id);
        setTitle(title);
        setParentId(parentId);
    }

    /**
     * id of this facetValue.  Any string or number.
     *
     * @param id id Default value is null
     */
    public void setId(Integer id) {
        setAttribute("id", id);
    }

    /**
     * id of this facetValue.  Any string or number.
     *
     * @param id id Default value is null
     */
    public void setId(String id) {
        setAttribute("id", id);
    }

    /**
     * id of this facetValue.  Any string or number.
     *
     * @param id id Default value is null
     */
    public Object getId() {
        return getAttributeAsObject("id");
    }

    /**
     * id of this facetValue.  Any string or number.
     *
     * @param id id Default value is null
     */
    public String getIdAsString() {
        return getAttributeAsString("id");
    }

    /**
     * id of this facetValue.  Any string or number.
     *
     * @param id id Default value is null
     */
    public Integer getIdAsInt() {
        return getAttributeAsInt("id");
    }

    /**
     * See {@link #getParentIdAsInt}.
     * @deprecated in favor of {@link #getParentIdAsInt}.
     */
    public Integer getParentIdAsInteger()  {
        return getParentIdAsInt();
    }


}
