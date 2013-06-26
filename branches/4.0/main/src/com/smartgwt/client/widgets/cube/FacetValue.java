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
 
package com.smartgwt.client.widgets.cube;


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
 * Facet value definition object made use of by the CubeGrid class (contained by facets)
 */
public class FacetValue extends RefDataClass {

    public static FacetValue getOrCreateRef(JavaScriptObject jsObj) {

        if(jsObj == null) return null;

        RefDataClass obj = RefDataClass.getRef(jsObj);


        if(obj != null) {
            obj.setJsObj(jsObj);
            return (FacetValue) obj;
        } else {
            return new FacetValue(jsObj);
        }
    }

    public void setJavaScriptObject(JavaScriptObject jsObj) {
        this.jsObj = jsObj;
    }



    public FacetValue(){
        
    }

    public FacetValue(JavaScriptObject jsObj){
        
        setJavaScriptObject(jsObj);
        setAttribute(com.smartgwt.client.util.SC.REF, (Object) this);
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
     * cellAlign on the facetValue.
     *
     * @param align align Default value is null
     */
    public void setAlign(Alignment align) {
        setAttribute("align", align == null ? null : align.getValue());
    }

    /**
     * Default alignment for facet label title and cells for this facetValue. Can be overridden by setting titleAlign or
     * cellAlign on the facetValue.
     *
     * @return Alignment
     */
    public Alignment getAlign()  {
        return EnumUtil.getEnum(Alignment.values(), getAttribute("align"));
    }


    /**
     * CSS line style to apply as a border after this facetValue.
     *
     * @param borderAfter . See {@link com.smartgwt.client.docs.String String}. Default value is null
     */
    public void setBorderAfter(String borderAfter) {
        setAttribute("borderAfter", borderAfter);
    }

    /**
     * CSS line style to apply as a border after this facetValue.
     *
     * @return . See {@link com.smartgwt.client.docs.String String}
     */
    public String getBorderAfter()  {
        return getAttributeAsString("borderAfter");
    }


    /**
     * CSS line style to apply as a border before this facetValue.
     *
     * @param borderBefore . See {@link com.smartgwt.client.docs.String String}. Default value is null
     */
    public void setBorderBefore(String borderBefore) {
        setAttribute("borderBefore", borderBefore);
    }

    /**
     * CSS line style to apply as a border before this facetValue.
     *
     * @return . See {@link com.smartgwt.client.docs.String String}
     */
    public String getBorderBefore()  {
        return getAttributeAsString("borderBefore");
    }


    /**
     * For individual parent facetValues within a hierarchical facet, this flag controls whether an expand/collapse control
     * will be shown.
     *
     * @param canCollapse canCollapse Default value is true
     */
    public void setCanCollapse(Boolean canCollapse) {
        setAttribute("canCollapse", canCollapse);
    }

    /**
     * For individual parent facetValues within a hierarchical facet, this flag controls whether an expand/collapse control
     * will be shown.
     *
     * @return Boolean
     */
    public Boolean getCanCollapse()  {
        return getAttributeAsBoolean("canCollapse");
    }


    /**
     * Whether cells for this facetValue can be edited.  Defaults to cubeGrid.canEdit
     *
     * @param canEdit canEdit Default value is cubeGrid.canEdit
     */
    public void setCanEdit(Boolean canEdit) {
        setAttribute("canEdit", canEdit);
    }

    /**
     * Whether cells for this facetValue can be edited.  Defaults to cubeGrid.canEdit
     *
     * @return Boolean
     */
    public Boolean getCanEdit()  {
        return getAttributeAsBoolean("canEdit");
    }


    /**
     * Default alignment of cells (in the body) for this facetValue.
     *
     * @param cellAlign cellAlign Default value is facet.cellAlign
     */
    public void setCellAlign(Alignment cellAlign) {
        setAttribute("cellAlign", cellAlign == null ? null : cellAlign.getValue());
    }

    /**
     * Default alignment of cells (in the body) for this facetValue.
     *
     * @return Alignment
     */
    public Alignment getCellAlign()  {
        return EnumUtil.getEnum(Alignment.values(), getAttribute("cellAlign"));
    }


    /**
     * For tree facets, initial collapse state for this node.  Defaults to facet.collapsed.
     *
     * @param collapsed collapsed Default value is facet.collapsed
     */
    public void setCollapsed(Boolean collapsed) {
        setAttribute("collapsed", collapsed);
    }

    /**
     * For tree facets, initial collapse state for this node.  Defaults to facet.collapsed.
     *
     * @return Boolean
     */
    public Boolean getCollapsed()  {
        return getAttributeAsBoolean("collapsed");
    }



    /**
     * Used to determine which facetValue is to be shown when the facet is minimized. <P> See {@link
     * com.smartgwt.client.widgets.cube.CubeGrid#getCanMinimizeFacets canMinimizeFacets}.
     *
     * @param isMinimizeValue isMinimizeValue Default value is false
     */
    public void setIsMinimizeValue(Boolean isMinimizeValue) {
        setAttribute("isMinimizeValue", isMinimizeValue);
    }

    /**
     * Used to determine which facetValue is to be shown when the facet is minimized. <P> See {@link
     * com.smartgwt.client.widgets.cube.CubeGrid#getCanMinimizeFacets canMinimizeFacets}.
     *
     * @return Boolean
     */
    public Boolean getIsMinimizeValue()  {
        return getAttributeAsBoolean("isMinimizeValue");
    }


    /**
     * For tree facets ({@link com.smartgwt.client.widgets.cube.Facet#getIsTree facet.isTree}), id of this facetValue's parent
     * facetValue.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param parentId . See {@link com.smartgwt.client.docs.String String}. Default value is null
     */
    public void setParentId(String parentId) {
        setAttribute("parentId", parentId);
    }

    /**
     * For tree facets ({@link com.smartgwt.client.widgets.cube.Facet#getIsTree facet.isTree}), id of this facetValue's parent
     * facetValue.
     *
     * @return . See {@link com.smartgwt.client.docs.String String}
     */
    public String getParentId()  {
        return getAttributeAsString("parentId");
    }


    /**
     * Selection boundary determining what facets / facetValues can be selected together by drag selection / shift+click
     * selection.
     *
     * @param selectionBoundary selectionBoundary Default value is null
     */
    public void setSelectionBoundary(SelectionBoundary selectionBoundary) {
        setAttribute("selectionBoundary", selectionBoundary == null ? null : selectionBoundary.getValue());
    }

    /**
     * Selection boundary determining what facets / facetValues can be selected together by drag selection / shift+click
     * selection.
     *
     * @return SelectionBoundary
     */
    public SelectionBoundary getSelectionBoundary()  {
        return EnumUtil.getEnum(SelectionBoundary.values(), getAttribute("selectionBoundary"));
    }


    /**
     * User-visible title of this facetValue.  Shown on the field header.
     *
     * @param title . See {@link com.smartgwt.client.docs.String String}. Default value is null
     */
    public void setTitle(String title) {
        setAttribute("title", title);
    }

    /**
     * User-visible title of this facetValue.  Shown on the field header.
     *
     * @return . See {@link com.smartgwt.client.docs.String String}
     */
    public String getTitle()  {
        return getAttributeAsString("title");
    }


    /**
     * Hilite style to apply to the title for this facetValue.  See {@link com.smartgwt.client.widgets.cube.CubeGrid#getHilites
     * hilites}.
     *
     * @param titleHilite . See {@link com.smartgwt.client.docs.String String}. Default value is null
     */
    public void setTitleHilite(String titleHilite) {
        setAttribute("titleHilite", titleHilite);
    }

    /**
     * Hilite style to apply to the title for this facetValue.  See {@link com.smartgwt.client.widgets.cube.CubeGrid#getHilites
     * hilites}.
     *
     * @return . See {@link com.smartgwt.client.docs.String String}
     */
    public String getTitleHilite()  {
        return getAttributeAsString("titleHilite");
    }


    /**
     * Width of the cube grid facetValue in pixels.
     *
     * @param width width Default value is facet.width
     */
    public void setWidth(int width) {
        setAttribute("width", width);
    }

    /**
     * Width of the cube grid facetValue in pixels.
     *
     * @return int
     */
    public int getWidth()  {
        return getAttributeAsInt("width");
    }

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************

    // ***********************************************************


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

}


