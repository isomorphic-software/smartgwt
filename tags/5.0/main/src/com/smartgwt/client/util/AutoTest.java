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
 
package com.smartgwt.client.util;


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
 * Standalone class providing a general interface for integration with Automated Testing Tools <p>
 */
@BeanFactory.FrameworkClass
public class AutoTest {


    // ********************* Properties / Attributes ***********************

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************


	/**
     * Returns whether the canvas is in a consistent state with no pending operations.  Returns null if the supplied argument
     * is not a valid canvas. Otherwise, returns true or false according as the conditions below are all satisfied: <ul>    
     * <li> page has finished loading     <li> canvas is drawn     <li> canvas isn't dirty     <li> canvas has no queued
     * overflow operations     <li> canvas is not animating </ul>
     * @param canvas canvas to test
     *
     * @return whether  canvas is 'done' as described above
     */
    public static native Boolean isCanvasDone(Canvas canvas) /*-{
        var ret = $wnd.isc.AutoTest.isCanvasDone(canvas.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()());
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(ret);
    }-*/;




	/**
     * Returns whether the instance is ready to be clicked on by a Selenium test.  Returns null if the  supplied instance is
     * not a valid canvas or form item. Otherwise, returns true or false according as the conditions below are all satisfied:
     * <ul>     <li> page has finished loading     <li> no network operations are outstanding (configurable,           see
     * {@link com.smartgwt.client.util.AutoTest#implicitNetworkWait implicitNetworkWait})     <li> canvas is visible, enabled,
     * and not masked,     <li> canvas satisfies isCanvasDone()     <li> if canvas is a TileGrid, it satisfies isTileGridDone()
     * <li> if canvas is a TileLayout, it satisfies isTileLayoutDone()     <li> if canvas is a ListGrid or body of a ListGrid,
     * it satisfies isGridDone() </ul> Note that for a form item in a DynamicForm, the DynamicForm must satisfy the third
     * condition above, while the container widget of the element must satisfy the remaining conditions.
     * @param canvas instance to test
     *
     * @return whether  instance is 'clickable' as described above
     */
    public static native Boolean isElementClickable(Canvas canvas) /*-{
        var ret = $wnd.isc.AutoTest.isElementClickable(canvas.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()());
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(ret);
    }-*/;

	/**
     * Returns whether the instance is ready to be clicked on by a Selenium test.  Returns null if the  supplied instance is
     * not a valid canvas or form item. Otherwise, returns true or false according as the conditions below are all satisfied:
     * <ul>     <li> page has finished loading     <li> no network operations are outstanding (configurable,           see
     * {@link com.smartgwt.client.util.AutoTest#implicitNetworkWait implicitNetworkWait})     <li> canvas is visible, enabled,
     * and not masked,     <li> canvas satisfies isCanvasDone()     <li> if canvas is a TileGrid, it satisfies isTileGridDone()
     * <li> if canvas is a TileLayout, it satisfies isTileLayoutDone()     <li> if canvas is a ListGrid or body of a ListGrid,
     * it satisfies isGridDone() </ul> Note that for a form item in a DynamicForm, the DynamicForm must satisfy the third
     * condition above, while the container widget of the element must satisfy the remaining conditions.
     * @param item instance to test
     *
     * @return whether  instance is 'clickable' as described above
     */
    public static native Boolean isElementClickable(FormItem item) /*-{
        var ret = $wnd.isc.AutoTest.isElementClickable(item.@com.smartgwt.client.core.DataClass::getJsObj()());
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(ret);
    }-*/;




	/**
     * Returns whether the ListGrid supplied or containing the supplied canvas is in a consistent state with no pending
     * operations.  Returns null if the supplied canvas is not a ListGrid or contained in a ListGrid.  Otherwise, returns true
     * or false according as the conditions below are all satisfied: <ul>     <li> page has finished loading     <li> no
     * pending scroll operations     <li> no pending filter editor operations     <li> no unsaved edits to the grid records    
     * <li> no asynchronous regrouping operations are in progress     <li> no outstanding fetch/filter operations are present
     * for the ResultSet     <li> no outstanding sort operations are present that will update the ListGrid </ul>
     * @param canvas canvas to test
     *
     * @return whether  canvas is 'done' as described above
     */
    public static native Boolean isGridDone(Canvas canvas) /*-{
        var ret = $wnd.isc.AutoTest.isGridDone(canvas.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()());
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(ret);
    }-*/;




	/**
     * Returns whether the loaded page is in a consistent state with no pending operations. Specifically, returns true of false
     * according as the conditions below are all satisfied: <ul>     <li> page has finished loading     <li> all ListGrids (as
     * defined by isc.isA.ListGrid) satisfy isGridDone()     <li> all TileGrids that are drawn satisfy isTileGridDone()    
     * <li> all TileLayouts that are drawn satisfy isTileLayoutDone()     <li> all Canvii that are drawn satisfy isCanvasDone()
     * <li> no network operations are outstanding (configurable,           see {@link
     * com.smartgwt.client.util.AutoTest#implicitNetworkWait implicitNetworkWait})     <li> there are no pending Canvas redraws
     * (if includeRedraws parameter is true) </ul> Note: In a situation where messaging is being used to periodically refresh
     * components, or if the application contains a label updated every second to show the current time, it's possible that
     * this call might always return false if includeRedraws is true.
     * @param includeRedraws whether to check for pending Canvas redraws
     *
     * @return whether loaded page is 'done' as described above
     */
    public static native boolean isSystemDone(boolean includeRedraws) /*-{
        var ret = $wnd.isc.AutoTest.isSystemDone(includeRedraws == null ? false : includeRedraws);
        return ret;
    }-*/;




	/**
     * Returns whether the TileGrid is in a consistent state with no pending operations.  Returns null if the supplied canvas
     * is not a valid TileGrid. Otherwise, returns true or false according as the conditions below are all satisfied: <ul>    
     * <li> page has finished loading     <li> the TileGrid (as a tileLayout) satisfies autoTest.isTileLayoutDone()     <li>
     * the TileGrid has no pending layout animation operations queued </ul>
     * @param canvas TileGrid to test
     *
     * @return whether  TileGrid is 'done' as described above
     */
    public static native Boolean isTileGridDone(Canvas canvas) /*-{
        var ret = $wnd.isc.AutoTest.isTileGridDone(canvas.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()());
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(ret);
    }-*/;




	/**
     * Returns whether the TileLayout is in a consistent state with no pending operations.  Returns null if the supplied canvas
     * is not a valid TileLayout. Otherwise, returns true or false according as the conditions below are all satisfied: <ul>   
     * <li> page has finished loading     <li> the TileLayout (as a canvas) satisfies autoTest.isCanvasDone()     <li> the
     * TileLayout is not currently animating any layout operations </ul>
     * @param canvas TileLayout to test
     *
     * @return whether  TileLayout is 'done' as described above
     */
    public static native Boolean isTileLayoutDone(Canvas canvas) /*-{
        var ret = $wnd.isc.AutoTest.isTileLayoutDone(canvas.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()());
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(ret);
    }-*/;




	/**
     * Sets the implicit root canvas available in scLocators starting "//testRoot[]". Setting this property may enable one to
     * use the same script to test identical widget hierarchies that are rooted under different base widgets.
     * @param canvas the implicit root
     */
    public static native void setTestRoot(Canvas canvas) /*-{
        $wnd.isc.AutoTest.setTestRoot(canvas.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()());
    }-*/;



    // ***********************************************************


	/**
     * Gets the implicit root canvas available in scLocators starting "//testRoot[]". Setting this property may enable one to
     * use the same script to test identical widget hierarchies that are rooted under different base widgets.
     *
     * @return the canvas currently set as the test root
     */
    public static native Canvas getTestRoot() /*-{
        var ret = $wnd.isc.AutoTest.testRoot;
        if(ret == null || ret === undefined) return null;
        return @com.smartgwt.client.widgets.Canvas::getByJSObject(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

}


