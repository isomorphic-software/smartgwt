/*
 * SmartGWT (GWT for SmartClient)
 * Copyright 2008 and beyond, Isomorphic Software, Inc.
 *
 * SmartGWT is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License version 3
 * as published by the Free Software Foundation.  SmartGWT is also
 * available under typical commercial license terms - see
 * http://smartclient.com/license
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 */
 
package com.smartgwt.client.util;



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
import com.smartgwt.client.widgets.layout.*;
import com.smartgwt.client.widgets.menu.*;
import com.smartgwt.client.widgets.tab.*;
import com.smartgwt.client.widgets.toolbar.*;
import com.smartgwt.client.widgets.tree.*;
import com.smartgwt.client.widgets.tree.events.*;
import com.smartgwt.client.widgets.viewer.*;
import com.smartgwt.client.widgets.calendar.*;
import com.smartgwt.client.widgets.calendar.events.*;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;
import com.smartgwt.client.util.JSOHelper;
import com.smartgwt.client.util.EnumUtil;
import com.google.gwt.event.shared.*;
import com.google.gwt.event.shared.HasHandlers;
   /**
    * The ISC system provides a predictable cross-browser event-handling mechanism for ISC&#010 widgets. Events can be handled both at the page level (i.e., globally), and at the level of&#010 individual widgets.&#010 <p>&#010 With the exception of a few page-specific events ('load', 'unload', 'idle' and 'resize'),&#010 events are processed in the following sequence:&#010 <p>&#010 1. The event is sent to any global (page-level) event handlers. These handlers can cancel&#010 further propagation of the event by returning false.  You can register to listen for any of the&#010 events linked in the seeAlso section (below) by calling {@link com.smartgwt.client.util.Page#setEvent}&#010 method.&#010 <p>&#010 2. If the event occurred on a form element or a link, it is passed on to the browser so that&#010 the element will perform its default action. No widget receives the event.&#010 <p>&#010 3. If the event occurred on an enabled widget (but not on a form element or link inside&#010 the widget), it is sent to that widget's event handler, if any. This handler can cancel&#010 further propagation of the event by returning false.  An "enabled" widget is any widget that&#010 defines an event handler for one of the supported events.  Interceptable events are defined in&#010 the {@link com.smartgwt.client..Canvas#methods#events}.&#010 <p>&#010 4. The event is "bubbled" up to the widget's parent in the containment hierarchy, if any.&#010 Again, the parent's handler for the event can cancel further propagation by returning&#010 false. This step is repeated, with the event "bubbling" up through the containment&#010 hierarchy, until a top-level widget is reached or the event is explicitly canceled.&#010 In brief, the ISC event model offers the best features of browser event models:&#010 <ul>&#010 <li> Page-first event handling allows you to reliably process or cancel any event before it&#010      affects the objects on the page.&#010 <li> Event "bubbling" ensures that parent widgets receive events sent to their children,&#010      and allows you to create generalized parent-level handlers rather than duplicating&#010      code in each child.&#010 </ul>&#010 Note: Canceling propagation of an event may cancel its side effects as well, including the&#010 generation of other (synthetic) events. For example, if a global mouseDown handler returns&#010 false, drag-and-drop events will not be generated. Specific effects are discussed in the&#010 descriptions of the various events in the following sections.&#010 <p>&#010 SmartGWT libraries will not interfere with native event handling when events occur&#010 outside of a target widget. You can therefore have HTML that is not ISC-based on the same&#010 page as widget objects that will react to native events as you would expect.&#010 <p>&#010 You can use isc.Event as an alias for isc.EventHandler.

    */
public class EventHandler {
    // ********************* Properties / Attributes ***********************

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************

        /**
         * Applies to {@link com.smartgwt.client.widgets.Canvas#addMouseWheelHandler} events only.&#010 Returns an integer indicating how far the mouse wheel was rotated. This value will be&#010 positive if the user scrolled the mousewheel forward or up, or negative if scrolled in the&#010 other direction and will be a multiple of 1 where 1 indicates the smallest possible rotation&#010 of the wheel.&#010
         *
         * @return integer indicating how far the mouse wheel was rotated.
         */
        public static native int getWheelDelta() /*-{
            return $wnd.isc.EventHandler.getWheelDelta();
        }-*/;



        /**
         * Return the canvas that is the target of the mouse event.&#010 Returns null if no canvas found.&#010&#010
         *
         * @return event target canvas
         */
        public static native Canvas getTarget() /*-{
            var ret = $wnd.isc.EventHandler.getTarget();
            if(ret == null || ret === undefined) return null;
            var retVal = @com.smartgwt.client.widgets.BaseWidget::getRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
            if(retVal == null) {
                retVal = @com.smartgwt.client.widgets.Canvas::new(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
            }
            return retVal;
        }-*/;

        /**
         * &#010 Returns the current dragTarget.  This is the component on which the drag and drop&#010 interaction was initiated.  This only returns something meaningful during a drag and drop&#010 interaction.&#010&#010
         *
         * @return The dragTarget.
         */
        public static native Canvas getDragTarget() /*-{
            var ret = $wnd.isc.EventHandler.getDragTarget();
            if(ret == null || ret === undefined) return null;
            var retVal = @com.smartgwt.client.widgets.BaseWidget::getRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
            if(retVal == null) {
                retVal = @com.smartgwt.client.widgets.Canvas::new(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
            }
            return retVal;
        }-*/;

        /**
         * Return the page-relative X (horizontal) coordinate of an event.&#010&#010
         *
         * @return x-coordinate in page coordinate space
         */
        public static native int getX() /*-{
            return $wnd.isc.EventHandler.getX();
        }-*/;

        /**
         * Return the page-relative Y (vertical) coordinate of an event.&#010&#010
         *
         * @return y-coordinate in page coordinate space
         */
        public static native int getY() /*-{
            return $wnd.isc.EventHandler.getY();
        }-*/;

        /**
         * Returns true if the left mouse button is being pressed.&#010&#010
         *
         * @return true == left button is down, false == up
         */
        public static native Boolean leftButtonDown() /*-{
            var retVal =$wnd.isc.EventHandler.leftButtonDown();
            if(retVal == null || retVal === undefined) {
                return null;
            } else {
                return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
            }
        }-*/;

        /**
         * Returns true if the right mouse button is being pressed.&#010&#010
         *
         * @return true == right button is down, false == up
         */
        public static native Boolean rightButtonDown() /*-{
            var retVal =$wnd.isc.EventHandler.rightButtonDown();
            if(retVal == null || retVal === undefined) {
                return null;
            } else {
                return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
            }
        }-*/;


        /**
         * Return true if the shift key is being held down.&#010   Note that this is only set reliably for keyboard events.&#010&#010
         *
         * @return true == shift key is down
         */
        public static native Boolean shiftKeyDown() /*-{
            var retVal =$wnd.isc.EventHandler.shiftKeyDown();
            if(retVal == null || retVal === undefined) {
                return null;
            } else {
                return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
            }
        }-*/;

        /**
         * Return true if the control key is being held down.&#010   Note that this is only set reliably for keyboard events.&#010&#010
         *
         * @return true == control key is down
         */
        public static native Boolean ctrlKeyDown() /*-{
            var retVal =$wnd.isc.EventHandler.ctrlKeyDown();
            if(retVal == null || retVal === undefined) {
                return null;
            } else {
                return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
            }
        }-*/;

        /**
         * Return true if the alt (option) key is being held down.&#010   Note that this is only set reliably for keyboard events.&#010&#010
         *
         * @return true == alt key is down
         */
        public static native Boolean altKeyDown() /*-{
            var retVal =$wnd.isc.EventHandler.altKeyDown();
            if(retVal == null || retVal === undefined) {
                return null;
            } else {
                return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
            }
        }-*/;




    /**
     * Set the HTML for the drag tracker that follows the mouse during a drag and drop interaction. <P> Your canvas
     * can use this routine to set the drag tracker to whatever HTML you want like so: <pre>    dragStart : function
     * () {        isc.EventHandler.setDragTracker('Your contents here');    } </pre>
     *
     * @param html HTML for the tracker
     */
    public static native void setDragTracker(String html) /*-{
            $wnd.isc.EventHandler.setDragTracker(html);
    }-*/;

    /**
     * Set the HTML for the drag tracker that follows the mouse during a drag and drop interaction. <P> Your canvas
     * can use this routine to set the drag tracker to whatever HTML you want like so: <pre>    dragStart : function
     * () {        isc.EventHandler.setDragTracker('Your contents here');    } </pre>
     *
     * @param html      HTML for the tracker
     * @param newWidth  new width for the tracker
     * @param newHeight new height for the tracker
     * @param offsetX   x-offset for the tracker
     * @param offsetY   y-offset for the tracker
     */
    public static native void setDragTracker(String html, int newWidth, int newHeight, int offsetX, int offsetY) /*-{
            $wnd.isc.EventHandler.setDragTracker(html, newWidth, newHeight, offsetX, offsetY);
    }-*/;

    /**
     * During a drag with dragAppearance of either "target" or "outline", returns the page-relative coordinates
     * of whatever element is being dragged.
     * Calling this method allows you to write drag and drop logic that works identically even if dragAppearance
     * is subsequently changed.
     *
     * @return lobal (page-relative) coordinates and size of the dragged element, as a 4-element array [left,top,width,height], or null if not dragging
     */
    public native Rectangle getDragRect() /*-{
         var rectJS = $wnd.isc.EventHandler.getDragRect();
         if(rectJS == null || rectJS === undefined) return null;
         return @com.smartgwt.client.core.Rectangle::new(IIII)(rectJS[0], rectJS[1], rectJS[2], rectJS[3]);
     }-*/;

    /**
     * Return the page-relative X (horizontal) coordinate of an event.
     *
     * @return x-coordinate in page coordinate space
     */
    public static native Integer getMouseDownX() /*-{
            if($wnd.isc.EventHandler.mouseDownEvent) {
                var x = $wnd.isc.EventHandler.mouseDownEvent.x;
                return x == null || x === undefined ? null : @com.smartgwt.client.util.JSOHelper::toInteger(I)(x);
            } else {
                return null;
            }
        }-*/;

    /**
     * Return the page-relative Y (vertical) coordinate of an event.
     *
     * @return y-coordinate in page coordinate space
     */
    public static native Integer getMouseDownY() /*-{
         if($wnd.isc.EventHandler.mouseDownEvent) {
            var y = $wnd.isc.EventHandler.mouseDownEvent.y;
            return y == null || y === undefined ? null : @com.smartgwt.client.util.JSOHelper::toInteger(I)(y);
        } else {
            return null;
        }
    }-*/;

    /**
     * Return the name of the key for the event passed in. Note that this is only set reliably for keyboard events.
     *      <pre>
     * Strings to identify the various keys on the keyboard.
     *
     * For alpha keys, the single (uppercase) character value is used, such as "Q"
     * For Numeric keys, the number is used as in a single character string, like "1"
     * Function keys are identified as "f1" - "f12"
     * Non alpha-numeric character keys (such as the key for "[" / "{") are identified by their unmodified character value (the value obtained by hitting the key without holding shift down), by default - exceptions are listed below.
     * Additional key names:
     * - Space
     * - Tab
     * - Enter
     * - Escape
     * - Backspace
     * - Insert
     * - Delete
     * - Arrow_Up
     * - Arrow_Down
     * - Arrow_Left
     * - Arrow_Right
     * - Home
     * - End
     * - Page_Up
     * - Page_Down
     * - Shift
     * - Ctrl
     * - Alt
     * [Note: Some keys may not be available for capture on every platform]
     * </pre>
     * @return the key name
     * @see com.smartgwt.client.types.KeyNames
     */
    public static native String getKey() /*-{
        var keyName = $wnd.isc.EventHandler.getKey();
        return keyName == undefined ? null : keyName;
    }-*/;

}



