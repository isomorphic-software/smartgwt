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
 * Standalone class providing a general interface for integration with Automated Testing Tools <p>
 */
@BeanFactory.FrameworkClass
public class AutoTest {


    // ********************* Properties / Attributes ***********************

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************



	/**
     * Returns the {@link com.smartgwt.client.util.QualityIndicatedLocator} associated with some DOM element in a Smart GWT
     * application page.  If coords, representing the page position, is passed in, the locator may be generated with a specific
     * trailing "target area" identifer that will map back to the appropriate, potentially different, physical coordinates,
     * even if the widget is moved.  The coords argument will only have an effect in cases where the mouse position over the
     * target could potentially change behavior.
     * @param DOMElement DOM element within in the page. If null the locator for  the last mouse event target will be generated
     *
     * @return Locator details allowing the AutoTest subsystem to find   an equivalent DOM element on subsequent page loads.
     */
    public static native QualityIndicatedLocator getLocatorWithIndicators(Element DOMElement) /*-{
        var ret = $wnd.isc.AutoTest.getLocatorWithIndicators(DOMElement);
        if(ret == null) return null;
        return @com.smartgwt.client.util.QualityIndicatedLocator::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

    /**
     * @see AutoTest#getLocatorWithIndicators
     */
    public static QualityIndicatedLocator getLocatorWithIndicators(Element DOMElement, boolean checkForNativeHandling){
        return getLocatorWithIndicators(DOMElement, checkForNativeHandling, null);
    }

	/**
     * Returns the {@link com.smartgwt.client.util.QualityIndicatedLocator} associated with some DOM element in a Smart GWT
     * application page.  If coords, representing the page position, is passed in, the locator may be generated with a specific
     * trailing "target area" identifer that will map back to the appropriate, potentially different, physical coordinates,
     * even if the widget is moved.  The coords argument will only have an effect in cases where the mouse position over the
     * target could potentially change behavior.
     * @param DOMElement DOM element within in the page. If null the locator for  the last mouse event target will be generated
     * @param checkForNativeHandling If this parameter is passed in, check whether  the target element responds to native browser events directly rather than
     * going through  the Smart GWT widget/event handling model. If we detect this case, return null rather  than a live
     * locator.  This allows us to differentiate between (for example) an event on  a Canvas handle, and an event occurring
     * directly on a simple   <code>&lt;a href=...&gt;</code> tag written inside a Canvas handle.
     * @param coords X, Y page position
     *
     * @return Locator details allowing the AutoTest subsystem to find   an equivalent DOM element on subsequent page loads.
     */
    public static native QualityIndicatedLocator getLocatorWithIndicators(Element DOMElement, boolean checkForNativeHandling, String[] coords) /*-{
        var ret = $wnd.isc.AutoTest.getLocatorWithIndicators(DOMElement, checkForNativeHandling, coords);
        if(ret == null) return null;
        return @com.smartgwt.client.util.QualityIndicatedLocator::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;
	

	/**
     * Returns a locator that's optimized to have minimal length while still trying to robustly represent that targeted canvas.
     * The returned locator may simply be an ID, if the target has a manually assigned ID, or it may consist of syntax starting
     * with <code>//:</code> that will search for a widget with the specified ID or defining property (e.g. "title"). A minimal
     * locator may also contain a second, interior search denoted by <code>//</code> that searches the hierarchy below the
     * preceding part of the locator. <p> A minimal locator should be passed to {@link
     * com.smartgwt.client.util.AutoTest#getObject getObject()} to retrieve the original target. <p> Note that when searching
     * by defining property, a breadth-first search of the widget hierarchy will be run looking for the first widget of the
     * appropriate framework class with the specified defining property.
     * @param canvas target canvas whose locator is needed
     *
     * @return minimal locator to the target canvas.
     * See {@link com.smartgwt.client.docs.AutoTestLocator AutoTestLocator}
     */
    public static native String getMinimalLocator(Canvas canvas) /*-{
        var ret = $wnd.isc.AutoTest.getMinimalLocator(canvas == null ? null : canvas.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()());
        return ret;
    }-*/;





	/**
     * This method allows developers to retrieve locators for elements on the page via a key-combo plus mouseDown on the
     * element in question.<br> It may be invoked from a bookmarklet stored in the browser, giving developers a one-click way
     * to retrieve locators for any Smart GWT application <P> When installLocatorShortcut() is invoked, it will register a
     * Page-level <code>mouseDown</code> handler which, if the Shift+Ctrl or Shift+Meta key-combo are being held down will
     * display the locator for the element under the mouse in a text-box and also copy it to clipboard. <P> As with the {@link
     * com.smartgwt.client.docs.Debugging isc.showConsole()} method, developers may wish to create a  bookmark in their browser
     * to quickly enable this functionality on any Smart GWT  application, without any changes to the application code: <ol>
     * <li>Create a new bookmark in your browser.</li> <li>Enter url "javascript:isc.AutoTest.installLocatorShortcut()".</li>
     * <li>Label the bookmark as "Locator Shortcut"</li> <li>Consider adding this to the Bookmarks Toolbar. This allows you to
     * enable the  feature with a single click from any Smart GWT application.</li> </ol> <P> To uninstall the locator
     * shortcut, call {@link com.smartgwt.client.util.AutoTest#uninstallLocatorShortcut uninstallLocatorShortcut()}
     */
    public static native void installLocatorShortcut() /*-{
        $wnd.isc.AutoTest.installLocatorShortcut();
    }-*/;


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
        var ret = $wnd.isc.AutoTest.isCanvasDone(canvas == null ? null : canvas.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()());
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(ret);
    }-*/;


	/**
     * Returns whether the instance is ready to be clicked on by a Selenium test.  Returns null if the  supplied instance is
     * not a valid canvas or form item. Otherwise, returns true or false according as the conditions below are all satisfied:
     * <ul>     <li> page has finished loading     <li> no network operations are outstanding (configurable,           see
     * {@link com.smartgwt.client.util.AutoTest#implicitNetworkWait implicitNetworkWait})     <li> canvas is visible, enabled,
     * and not masked,     <li> canvas satisfies {@link com.smartgwt.client.util.AutoTest#isCanvasDone isCanvasDone()}     <li>
     * if canvas is a TileGrid, it satisfies {@link com.smartgwt.client.util.AutoTest#isTileGridDone isTileGridDone()}     <li>
     * if canvas is a TileLayout, it satisfies {@link com.smartgwt.client.util.AutoTest#isTileLayoutDone isTileLayoutDone()}   
     * <li> if canvas is a ListGrid or body of a ListGrid, it satisfies {@link com.smartgwt.client.util.AutoTest#isGridDone
     * isGridDone()}     <li> if canvas is a DynamicForm, it satisfies {@link com.smartgwt.client.util.AutoTest#isFormDone
     * isFormDone()} </ul> Note that for a form item in a DynamicForm, the DynamicForm must satisfy the third condition above,
     * while the container widget of the element must satisfy the remaining conditions.
     * @param canvas instance to test
     *
     * @return whether  instance is 'clickable' as described above
     */
    public static native Boolean isElementClickable(Canvas canvas) /*-{
        var ret = $wnd.isc.AutoTest.isElementClickable(canvas == null ? null : canvas.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()());
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(ret);
    }-*/;

	/**
     * Returns whether the instance is ready to be clicked on by a Selenium test.  Returns null if the  supplied instance is
     * not a valid canvas or form item. Otherwise, returns true or false according as the conditions below are all satisfied:
     * <ul>     <li> page has finished loading     <li> no network operations are outstanding (configurable,           see
     * {@link com.smartgwt.client.util.AutoTest#implicitNetworkWait implicitNetworkWait})     <li> canvas is visible, enabled,
     * and not masked,     <li> canvas satisfies {@link com.smartgwt.client.util.AutoTest#isCanvasDone isCanvasDone()}     <li>
     * if canvas is a TileGrid, it satisfies {@link com.smartgwt.client.util.AutoTest#isTileGridDone isTileGridDone()}     <li>
     * if canvas is a TileLayout, it satisfies {@link com.smartgwt.client.util.AutoTest#isTileLayoutDone isTileLayoutDone()}   
     * <li> if canvas is a ListGrid or body of a ListGrid, it satisfies {@link com.smartgwt.client.util.AutoTest#isGridDone
     * isGridDone()}     <li> if canvas is a DynamicForm, it satisfies {@link com.smartgwt.client.util.AutoTest#isFormDone
     * isFormDone()} </ul> Note that for a form item in a DynamicForm, the DynamicForm must satisfy the third condition above,
     * while the container widget of the element must satisfy the remaining conditions.
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
     * Given a DOM element, returns whether the associated Smart GWT Canvas or FormItem is ready to receive keyPress events
     * from a Selenium test.  Returns null if the locator is not valid or doesn't represent a valid Canvas or FormItem. 
     * Otherwise, returns true or false  according as the conditions below are all satisfied: <ul>     <li> page has finished
     * loading     <li> if a {@link com.smartgwt.client.widgets.form.fields.TextItem}, {@link
     * com.smartgwt.client.widgets.form.fields.FileItem}, or {@link com.smartgwt.client.widgets.form.fields.TextAreaItem},     
     * it has native focus,     <li> the element satisfies {@link com.smartgwt.client.util.AutoTest#isElementClickable
     * isElementClickable()} </ul>
     * @param canvas DOM element to test     (element obtained from canvas, form item, or Smart GWT locator if provided)
     *
     * @return whether element is 'ready' as described above
     */
    public static native Boolean isElementReadyForKeyPresses(Canvas canvas) /*-{
        var ret = $wnd.isc.AutoTest.isElementReadyForKeyPresses(canvas == null ? null : canvas.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()());
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(ret);
    }-*/;

	/**
     * Given a DOM element, returns whether the associated Smart GWT Canvas or FormItem is ready to receive keyPress events
     * from a Selenium test.  Returns null if the locator is not valid or doesn't represent a valid Canvas or FormItem. 
     * Otherwise, returns true or false  according as the conditions below are all satisfied: <ul>     <li> page has finished
     * loading     <li> if a {@link com.smartgwt.client.widgets.form.fields.TextItem}, {@link
     * com.smartgwt.client.widgets.form.fields.FileItem}, or {@link com.smartgwt.client.widgets.form.fields.TextAreaItem},     
     * it has native focus,     <li> the element satisfies {@link com.smartgwt.client.util.AutoTest#isElementClickable
     * isElementClickable()} </ul>
     * @param item DOM element to test     (element obtained from canvas, form item, or Smart GWT locator if provided)
     *
     * @return whether element is 'ready' as described above
     */
    public static native Boolean isElementReadyForKeyPresses(FormItem item) /*-{
        var ret = $wnd.isc.AutoTest.isElementReadyForKeyPresses(item.@com.smartgwt.client.core.DataClass::getJsObj()());
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(ret);
    }-*/;


	/**
     * Returns whether the DynamicForm is in a consistent state with no pending operations.  Returns null if the supplied
     * argument is not a valid {@link com.smartgwt.client.widgets.form.DynamicForm}.  Otherwise, returns true or false
     * according as the conditions below are all satisfied: <ul>     <li> page has finished loading     <li> form has no
     * pending delayed "set values" or "set values focus" operations     <li> all contained items satisfy {@link
     * com.smartgwt.client.util.AutoTest#isItemDone isItemDone()} </ul>
     * @param canvas canvas to test
     *
     * @return whether  canvas is 'done' as described above
     */
    public static native Boolean isFormDone(Canvas canvas) /*-{
        var ret = $wnd.isc.AutoTest.isFormDone(canvas == null ? null : canvas.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()());
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
        var ret = $wnd.isc.AutoTest.isGridDone(canvas == null ? null : canvas.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()());
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(ret);
    }-*/;


	/**
     * Returns whether the FormItem is in a consistent state with no pending operations.  Returns null if the supplied argument
     * is not a valid {@link com.smartgwt.client.widgets.form.fields.FormItem}.  Otherwise, returns true or false according as
     * the conditions below are all satisfied: <ul>     <li> page has finished loading     <li> if the container widget of the
     * item isn't the parent DynamicForm, then the          container widget must satisfy {@link
     * com.smartgwt.client.util.AutoTest#isCanvasDone isCanvasDone()} (or {@link com.smartgwt.client.util.AutoTest#isGridDone
     * isGridDone()},          etc., as appropriate)     <li> the item cannot have any fetches in progress for missing
     * display/value field          values     <li> picklists ({@link com.smartgwt.client.widgets.form.fields.SelectItem} or
     * {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem}) cannot have any pending row          fetches     <li> any
     * contained {@link com.smartgwt.client.widgets.form.fields.FormItem}s must satisfy <code>isItemDone()</code> themselves   
     * <li> any contained {@link com.smartgwt.client.widgets.Canvas} must satisfy {@link
     * com.smartgwt.client.util.AutoTest#isCanvasDone isCanvasDone()} (or           {@link
     * com.smartgwt.client.util.AutoTest#isGridDone isGridDone()}, etc., as appropriate) </ul>
     * @param item canvas to test
     *
     * @return whether  item is 'done' as described above
     */
    public static native Boolean isItemDone(FormItem item) /*-{
        var ret = $wnd.isc.AutoTest.isItemDone(item.@com.smartgwt.client.core.DataClass::getJsObj()());
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(ret);
    }-*/;


	/**
     * Returns whether the loaded page is in a consistent state with no pending operations. Specifically, returns true or false
     * according as the conditions below are all satisfied: <ul>     <li> page has finished loading     <li> all ListGrids (as
     * defined by isc.isA.ListGrid) satisfy {@link com.smartgwt.client.util.AutoTest#isGridDone isGridDone()}     <li> all
     * TileGrids that are drawn satisfy {@link com.smartgwt.client.util.AutoTest#isTileGridDone isTileGridDone()}     <li> all
     * TileLayouts that are drawn satisfy {@link com.smartgwt.client.util.AutoTest#isTileLayoutDone isTileLayoutDone()}    
     * <li> all DynamicForms that are drawn satisfy {@link com.smartgwt.client.util.AutoTest#isFormDone isFormDone()}     <li>
     * all Canvii that are drawn satisfy {@link com.smartgwt.client.util.AutoTest#isCanvasDone isCanvasDone()}     <li> no
     * network operations are outstanding (configurable,           see {@link
     * com.smartgwt.client.util.AutoTest#implicitNetworkWait implicitNetworkWait})     <li> there are no pending Canvas redraws
     * (if includeRedraws parameter is true) </ul> Note: In a situation where messaging is being used to periodically refresh
     * components, or if the application contains a label updated every second to show the current time, it's possible that
     * this call might always return false if includeRedraws is true.
     *
     * @return whether loaded page is 'done' as described above
     */
    public static native boolean isSystemDone() /*-{
        var ret = $wnd.isc.AutoTest.isSystemDone();
        return ret == null ? false : ret;
    }-*/;

    /**
     * @see AutoTest#isSystemDone
     */
    public static boolean isSystemDone(boolean includeRedraws){
        return isSystemDone(includeRedraws, false);
    }

	/**
     * Returns whether the loaded page is in a consistent state with no pending operations. Specifically, returns true or false
     * according as the conditions below are all satisfied: <ul>     <li> page has finished loading     <li> all ListGrids (as
     * defined by isc.isA.ListGrid) satisfy {@link com.smartgwt.client.util.AutoTest#isGridDone isGridDone()}     <li> all
     * TileGrids that are drawn satisfy {@link com.smartgwt.client.util.AutoTest#isTileGridDone isTileGridDone()}     <li> all
     * TileLayouts that are drawn satisfy {@link com.smartgwt.client.util.AutoTest#isTileLayoutDone isTileLayoutDone()}    
     * <li> all DynamicForms that are drawn satisfy {@link com.smartgwt.client.util.AutoTest#isFormDone isFormDone()}     <li>
     * all Canvii that are drawn satisfy {@link com.smartgwt.client.util.AutoTest#isCanvasDone isCanvasDone()}     <li> no
     * network operations are outstanding (configurable,           see {@link
     * com.smartgwt.client.util.AutoTest#implicitNetworkWait implicitNetworkWait})     <li> there are no pending Canvas redraws
     * (if includeRedraws parameter is true) </ul> Note: In a situation where messaging is being used to periodically refresh
     * components, or if the application contains a label updated every second to show the current time, it's possible that
     * this call might always return false if includeRedraws is true.
     * @param includeRedraws whether to check for pending Canvas redraws
     * @param includeEdits whether to check for unsaved edits for ListGrids
     *
     * @return whether loaded page is 'done' as described above
     */
    public static native boolean isSystemDone(boolean includeRedraws, boolean includeEdits) /*-{
        var ret = $wnd.isc.AutoTest.isSystemDone(includeRedraws, includeEdits);
        return ret == null ? false : ret;
    }-*/;
	

	/**
     * Returns whether the TileGrid is in a consistent state with no pending operations.  Returns null if the supplied canvas
     * is not a valid TileGrid. Otherwise, returns true or false according as the conditions below are all satisfied: <ul>    
     * <li> page has finished loading     <li> the TileGrid (as a tileLayout) satisfies {@link
     * com.smartgwt.client.util.AutoTest#isTileLayoutDone isTileLayoutDone()}     <li> the TileGrid has no pending layout
     * animation operations queued </ul>
     * @param canvas TileGrid to test
     *
     * @return whether  TileGrid is 'done' as described above
     */
    public static native Boolean isTileGridDone(Canvas canvas) /*-{
        var ret = $wnd.isc.AutoTest.isTileGridDone(canvas == null ? null : canvas.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()());
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(ret);
    }-*/;


	/**
     * Returns whether the TileLayout is in a consistent state with no pending operations.  Returns null if the supplied canvas
     * is not a valid TileLayout. Otherwise, returns true or false according as the conditions below are all satisfied: <ul>   
     * <li> page has finished loading     <li> the TileLayout (as a canvas) satisfies {@link
     * com.smartgwt.client.util.AutoTest#isCanvasDone isCanvasDone()}     <li> the TileLayout is not currently animating any
     * layout operations </ul>
     * @param canvas TileLayout to test
     *
     * @return whether  TileLayout is 'done' as described above
     */
    public static native Boolean isTileLayoutDone(Canvas canvas) /*-{
        var ret = $wnd.isc.AutoTest.isTileLayoutDone(canvas == null ? null : canvas.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()());
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(ret);
    }-*/;


	/**
     * Given an element in the DOM, returns the canvas containing this element, or null if the element is not contained in any
     * canvas handle.
     * @param element DOM element within in the page
     *
     * @return canvas containing the element, or null if none apply
     */
    public static native Canvas locateCanvasFromDOMElement(Element element) /*-{
        var ret = $wnd.isc.AutoTest.locateCanvasFromDOMElement(element);
        return @com.smartgwt.client.widgets.Canvas::getByJSObject(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;


	/**
     * Sets the implicit root canvas available in scLocators starting "//testRoot[]". Setting this property may enable one to
     * use the same script to test identical widget hierarchies that are rooted under different base widgets.
     * @param canvas the implicit root
     */
    public static native void setTestRoot(Canvas canvas) /*-{
        $wnd.isc.AutoTest.setTestRoot(canvas == null ? null : canvas.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()());
    }-*/;


	/**
     * Uninstalls the locator shortcut installed by {@link com.smartgwt.client.util.AutoTest#installLocatorShortcut
     * installLocatorShortcut()}
     */
    public static native void uninstallLocatorShortcut() /*-{
        $wnd.isc.AutoTest.uninstallLocatorShortcut();
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
        if(ret == null) return null;
        return @com.smartgwt.client.widgets.Canvas::getByJSObject(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

}
