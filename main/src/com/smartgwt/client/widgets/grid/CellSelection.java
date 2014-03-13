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
import com.smartgwt.client.widgets.tab.*;
import com.smartgwt.client.widgets.toolbar.*;
import com.smartgwt.client.widgets.tree.*;
import com.smartgwt.client.widgets.tree.events.*;
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
import com.smartgwt.client.util.workflow.*;
import com.google.gwt.event.shared.*;
import com.google.gwt.event.shared.HasHandlers;

/**
 * Maintains a representation of selection over a 2-dimensional grid of objects.<br>  Automatically created to manage
 * cell-selection on {@link com.smartgwt.client.widgets.cube.CubeGrid} widgets.
 */
@BeanFactory.FrameworkClass
@BeanFactory.ScClassName("CellSelection")
public class CellSelection extends BaseClass {

    public static CellSelection getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        BaseClass obj = BaseClass.getRef(jsObj);
        if(obj != null) {
            return (CellSelection) obj;
        } else {
            return new CellSelection(jsObj);
        }
    }

    public void setJavaScriptObject(JavaScriptObject jsObj) {
        internalSetID(jsObj);
        JSOHelper.setObjectAttribute(jsObj, SC.REF, this);
        JSOHelper.setObjectAttribute(jsObj, SC.MODULE, BeanFactory.getSGWTModule());
        if (!JSOHelper.isScClassInstance(jsObj)) {
            setConfig(jsObj);
            return;
        }
        JSOHelper.setObjectAttribute(getConfig(), SC.REF, this);
        JSOHelper.setObjectAttribute(getConfig(), SC.MODULE, BeanFactory.getSGWTModule());
        this.jsObj = jsObj;
    }


    public CellSelection(){
        scClassName = "CellSelection";
    }

    public CellSelection(JavaScriptObject jsObj){
        scClassName = "CellSelection";
        setJavaScriptObject(jsObj);
    }

    public native JavaScriptObject create()/*-{
        var config = this.@com.smartgwt.client.core.BaseClass::getConfig()();
        var scClassName = this.@com.smartgwt.client.core.BaseClass::scClassName;
        return $wnd.isc[scClassName].create(config);
    }-*/;

    private JavaScriptObject jsObj;
    
    @Override
    public boolean isCreated(){
        return this.jsObj != null;
    }

    @Override
    public JavaScriptObject getJsObj(){
        return this.jsObj;
    }

    @Override
    public JavaScriptObject getOrCreateJsObj() {
        if (!isCreated()) {
            this.jsObj = createJsObj();
            doInit();
        }
        return this.jsObj;
    }


    // ********************* Properties / Attributes ***********************

    // ********************* Methods ***********************
	/**
     * Is anything in the list selected?
     *
     * @return true == at least one item is selected                   false == nothing at all is selected
     * @see com.smartgwt.client.docs.Selection Selection overview and related methods
     */
    public native Boolean anySelected() /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.anySelected();
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(ret);
    }-*/;


	/**
     * Return true if a particular item is selected
     * @param rowNum row index of the cell to check
     * @param colNum column index of the cell to check
     *
     * @return true == object is selected                      false == object is not selected
     * @see com.smartgwt.client.docs.Selection Selection overview and related methods
     */
    public native Boolean cellIsSelected(int rowNum, int colNum) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.cellIsSelected(rowNum, colNum);
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(ret);
    }-*/;


	/**
     * Deselect a particular cell
     * @param rowNum row index of the cell to select
     * @param colNum column index of the cell to select
     *
     * @return true == selection actually changed, false == no change
     * @see com.smartgwt.client.docs.Selection Selection overview and related methods
     */
    public native Boolean deselectCell(int rowNum, int colNum) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.deselectCell(rowNum, colNum);
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(ret);
    }-*/;

	/**
     * Returns the first record that has any cells selected.
     *
     * @return first selected record, or null if nothing selected
     * @see com.smartgwt.client.docs.Selection Selection overview and related methods
     */
    public native ListGridRecord getSelectedRecord() /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.getSelectedRecord();
        if(ret == null) return null;
        return @com.smartgwt.client.widgets.grid.ListGridRecord::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;


	/**
     * Select a particular cell
     * @param rowNum row index of cell to select
     * @param colNum column index of cell to select
     *
     * @return true == selection actually changed, false == no change
     * @see com.smartgwt.client.docs.Selection Selection overview and related methods
     */
    public native Boolean selectCell(int rowNum, int colNum) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.selectCell(rowNum, colNum);
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(ret);
    }-*/;

	/**
     * Observable handler fired whenever the cell selection is modified
     * @see com.smartgwt.client.docs.Selection Selection overview and related methods
     */
    public native void selectionChanged() /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.selectionChanged();
    }-*/;


	/**
     * select a single cell and deselect everything else
     * @param rowNum row index of cell to select
     * @param colNum column index of cell to select
     *
     * @return true == selection actually changed, false == no change
     * @see com.smartgwt.client.docs.Selection Selection overview and related methods
     */
    public native Boolean selectSingleCell(int rowNum, int colNum) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.selectSingleCell(rowNum, colNum);
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(ret);
    }-*/;


    // ********************* Static Methods ***********************

    // ***********************************************************



    
    /**
     * Returns an array of the currently selected cells.  Each cell is returned as a 2 element
     * array in the form <code>[rowNum, colNum]</code>.
     *
     * @return an array of the selected cells, as 2 element arrays
     * @see com.smartgwt.client.docs.Selection Selection overview and related methods
     */
    public int[][] getSelectedCells() {
        JavaScriptObject jsCells = getSelectedCellsJS();
        if (jsCells == null) return null;
        return JSOHelper.getCellArray(jsCells);
    }
    
    private native JavaScriptObject getSelectedCellsJS () /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getJsObj()();
        if (self == null) return null;
        return self.getSelectedCells();;
    }-*/;
    
    /**
     * deselect an array of cells
     *
     * @return true == selection actually changed, false == no change
     * @see com.smartgwt.client.docs.Selection Selection overview and related methods
     */
    public Boolean deselectCellList() {
        return deselectCellListJS(null);
    }
    public Boolean deselectCellList(int[][] cells) {
        JavaScriptObject jsCells = cells == null ? null : JSOHelper.convertToCellArray(cells);
        return deselectCellListJS(jsCells);
    }
    private native Boolean deselectCellListJS (JavaScriptObject jsCells) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getJsObj()();
        if (self == null) return null;
        var retVal = self.deselectCellList(jsCells);
        if (retVal == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
    }-*/;
            
    /**
     * select an array of cells
     *
     * @return true == selection actually changed, false == no change
     * @see com.smartgwt.client.docs.Selection Selection overview and related methods
     */
    public Boolean selectCellList() {
        return selectCellListJS(null);
    }
    public Boolean selectCellList(int[][] cells) {
        JavaScriptObject jsCells = cells == null ? null : JSOHelper.convertToCellArray(cells);
        return selectCellListJS(jsCells);
    }
    private native Boolean selectCellListJS(JavaScriptObject jsCells) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getJsObj()();
        if (self == null) return null;
        var retVal = self.selectCellList(jsCells);
        if (retVal == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
    }-*/;

}


