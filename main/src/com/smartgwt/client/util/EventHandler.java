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
import com.google.gwt.event.logical.shared.HasHandlers;
   /**
    * The ISC system provides a predictable cross-browser event-handling mechanism for ISC widgets. Events can be handled both at the page level (i.e., globally), and at the level of individual widgets. <p> With the exception of a few page-specific events ('load', 'unload', 'idle' and 'resize'), events are processed in the following sequence: <p> 1. The event is sent to any global (page-level) event handlers. These handlers can cancel further propagation of the event by returning false.  You can register to listen for any of the events linked in the seeAlso section (below) by calling {@link com.smartgwt.client.util.Page#setEvent} method. <p> 2. If the event occurred on a form element or a link, it is passed on to the browser so that the element will perform its default action. No widget receives the event. <p> 3. If the event occurred on an enabled widget (but not on a form element or link inside the widget), it is sent to that widget's event handler, if any. This handler can cancel further propagation of the event by returning false.  An "enabled" widget is any widget that defines an event handler for one of the supported events.  Interceptable events are defined in the {@link com.smartgwt.client..Canvas#methods#events}. <p> 4. The event is "bubbled" up to the widget's parent in the containment hierarchy, if any. Again, the parent's handler for the event can cancel further propagation by returning false. This step is repeated, with the event "bubbling" up through the containment hierarchy, until a top-level widget is reached or the event is explicitly canceled. In brief, the ISC event model offers the best features of browser event models: <ul> <li> Page-first event handling allows you to reliably process or cancel any event before it      affects the objects on the page. <li> Event "bubbling" ensures that parent widgets receive events sent to their children,      and allows you to create generalized parent-level handlers rather than duplicating      code in each child. </ul> Note: Canceling propagation of an event may cancel its side effects as well, including the generation of other (synthetic) events. For example, if a global mouseDown handler returns false, drag-and-drop events will not be generated. Specific effects are discussed in the descriptions of the various events in the following sections. <p> SmartClient libraries will not interfere with native event handling when events occur outside of a target widget. You can therefore have HTML that is not ISC-based on the same page as widget objects that will react to native events as you would expect. <p> You can use isc.Event as an alias for isc.EventHandler.

    */
public class EventHandler {
    // ********************* Properties / Attributes ***********************

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************



        /**
         * Return the canvas that is the target of the mouse event. Returns null if no canvas found.
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
         * Returns the current dragTarget.  This is the component on which the drag and drop interaction was initiated.  This only returns something meaningful during a drag and drop interaction.
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
         * Return the page-relative X (horizontal) coordinate of an event.
         *
         * @return x-coordinate in page coordinate space
         */
        public static native int getX() /*-{
            return $wnd.isc.EventHandler.getX();
        }-*/;

        /**
         * Return the page-relative Y (vertical) coordinate of an event.
         *
         * @return y-coordinate in page coordinate space
         */
        public static native int getY() /*-{
            return $wnd.isc.EventHandler.getY();
        }-*/;

        /**
         * Returns true if the left mouse button is being pressed.
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
         * Returns true if the right mouse button is being pressed.
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
         * Return true if the shift key is being held down.   Note that this is only set reliably for keyboard events.
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
         * Return true if the control key is being held down.   Note that this is only set reliably for keyboard events.
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
         * Return true if the alt (option) key is being held down.   Note that this is only set reliably for keyboard events.
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




    public static native Integer getWheelDelta() /*-{
        return $wnd.isc.EH.lastEvent.wheelDelta;
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

}



