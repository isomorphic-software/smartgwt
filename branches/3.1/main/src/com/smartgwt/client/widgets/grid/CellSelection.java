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
 * Maintains a representation of selection over a 2-dimensional grid of objects.<br>  Automatically created to manage
 * cell-selection on {@link com.smartgwt.client.widgets.cube.CubeGrid} widgets.
 */
public class CellSelection extends RefDataClass {

    public static CellSelection getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        return new CellSelection(jsObj);
    }

    public void setJavaScriptObject(JavaScriptObject jsObj) {
        this.jsObj = jsObj;
    }


    public CellSelection(){
        
    }

    public CellSelection(JavaScriptObject jsObj){
        
        setJavaScriptObject(jsObj);
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
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        var retVal =self.anySelected();
        if(retVal == null || retVal === undefined) {
            return null;
        } else {
            return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
        }
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
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        var retVal =self.cellIsSelected(rowNum, colNum);
        if(retVal == null || retVal === undefined) {
            return null;
        } else {
            return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
        }
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
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        var retVal =self.deselectCell(rowNum, colNum);
        if(retVal == null || retVal === undefined) {
            return null;
        } else {
            return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
        }
    }-*/;

    /**
     * Returns the first record that has any cells selected.
     *
     * @return first selected record, or null if nothing selected
     * @see com.smartgwt.client.docs.Selection Selection overview and related methods
     */
    public native ListGridRecord getSelectedRecord() /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        var ret = self.getSelectedRecord();
        if(ret == null || ret === undefined) return null;
        var retVal = @com.smartgwt.client.core.RefDataClass::getRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
        if(retVal == null) {
            retVal = @com.smartgwt.client.widgets.grid.ListGridRecord::new(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
        }
        return retVal;
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
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        var retVal =self.selectCell(rowNum, colNum);
        if(retVal == null || retVal === undefined) {
            return null;
        } else {
            return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
        }
    }-*/;

    /**
     * Observable handler fired whenever the cell selection is modified
     */
    public native void selectionChanged() /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
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
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        var retVal =self.selectSingleCell(rowNum, colNum);
        if(retVal == null || retVal === undefined) {
            return null;
        } else {
            return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
        }
    }-*/;

    // ********************* Static Methods ***********************
        
    // ***********************************************************        



    
    /**
     * Returns an array of the currently selected cells.  Each cell is returned as a 2 element  array in the form
     * <code>[rowNum, colNum]</code>.
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
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        var cells = self.getSelectedCells();
        if (cells == null) return null;
        return cells;            
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
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        var retVal =self.deselectCellList(jsCells);
        if(retVal == null || retVal === undefined) {
            return null;
        } else {
            return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
        }
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
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        var retVal =self.selectCellList(jsCells);
        if(retVal == null || retVal === undefined) {
            return null;
        } else {
            return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
        }
    }-*/;

}



