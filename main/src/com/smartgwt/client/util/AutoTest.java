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
     * Returns whether the loaded page is in a consistent state with no pending operations. Specifically, returns true of false
     * according as the conditions below are all satisfied: <ul>     <li> all ListGrids (as defined by isc.isA.ListGrid)
     * satisfy isGridDone()     <li> all TileGrids that are drawn satisfy isTileGridDone()     <li> all Canvii that are drawn
     * satisfy isCanvasDone()     <li> no network operations are outstanding (configurable,           see {@link
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

    /**
     * Returns whether the supplied ListGrid is in a consistent state with no pending
     * operations.  Returns null if the supplied canvas isn't a valid ListGrid and isn't
     * contained in a valid ListGrid. Otherwise, returns true or false according as associated
     * ListGrid meets all the conditions below
     * <ul>     
     *     <li> no pending filter editor operations     
     *     <li> no unsaved edits to the grid records     
     *     <li> no outstanding fetch/filter operations are present for the ResultSet
     *     <li> no outstanding sort operations are present that will update the ListGrid 
     * </ul>
     * @param grid canvas to test
     * @return whether grid is 'done' as described above
     */
    public static native boolean isGridDone(Canvas grid) /*-{
        var that = grid.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        return $wnd.isc.AutoTest.isGridDone(that);
    }-*/;

}


