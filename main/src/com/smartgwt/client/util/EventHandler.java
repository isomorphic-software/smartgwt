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
 * <smartgwt> SmartGWT provides a predictable cross-browser event-handling mechanism for SmartGWT widgets, and the
 * EventHandler class provides various static APIs for retrieving details about events which have occurred. <P> Events may
 * be intercepted at the page level using standard GWT methods such as <i>addNativePreviewHandler()</i> on the 
 * <code>com.google.gwt.user.client.Event</code> class. <P> If the event occurred on an enabled widget it is sent to that
 * widget's event handler, if any. This handler can cancel further propagation of the event by returning false.  An
 * "enabled" widget is any widget that defines an event handler for one of the supported events. <p> The event is "bubbled"
 * up to the widget's parent in the containment hierarchy, if any. Again, the parent's handler for the event can cancel
 * further propagation by calling <code>event.cancel()</code>. This step is repeated, with the event "bubbling" up  through
 * the containment hierarchy, until a top-level widget is reached or the event is  explicitly canceled. <P>  Where
 * applicable, canceling an event will also typically suppress the native behavior (for example canceling a keypress while
 * focused in a form item may prevent the key character being inserted in the text box). <p> SmartGWT libraries will not
 * interfere with native event handling when events occur outside of a target widget. You can therefore have HTML that is
 * not ISC-based on the same page as widget objects that will react to native events as you would expect. <smartgwt>
 * @see com.smartgwt.client.types.PageEvent
 * @see com.smartgwt.client.util.Page#setEvent
 * @see com.smartgwt.client.util.Page#clearEvent
 */
@BeanFactory.FrameworkClass
public class EventHandler {


    // ********************* Properties / Attributes ***********************

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************
	/**
     * Return true if the alt (option) key is being held down.   Note that this is only set reliably for keyboard events.
     *
     * @return true == alt key is down
     */
    public static native Boolean altKeyDown() /*-{
        var ret = $wnd.isc.EventHandler.altKeyDown();
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(ret);
    }-*/;

	/**
     * Return true if the control key is being held down.   Note that this is only set reliably for keyboard events.
     *
     * @return true == control key is down
     */
    public static native Boolean ctrlKeyDown() /*-{
        var ret = $wnd.isc.EventHandler.ctrlKeyDown();
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(ret);
    }-*/;

	/**
     * Returns the current dragTarget.  This is the component on which the drag and drop interaction was initiated.  This only
     * returns something meaningful during a drag and drop interaction.
     *
     * @return The dragTarget.
     * @see com.smartgwt.client.widgets.Canvas#getDragTarget
     */
    public static native Canvas getDragTarget() /*-{
        var ret = $wnd.isc.EventHandler.getDragTarget();
        return @com.smartgwt.client.widgets.Canvas::getByJSObject(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

	/**
     * Return the character for the current key being pressed.   Note that this is only set reliably for keyPress events on
     * character keys.
     *
     * @return Character the user entered. May be null for non-character keys.
     */
    public static native String getKeyEventCharacter() /*-{
        var ret = $wnd.isc.EventHandler.getKeyEventCharacter();
        return ret;
    }-*/;

	/**
     * Returns the numeric characterValue reported by the browser.          Only available on keyPress events, and only for
     * character (or ascii control) keys
     *
     * @return Numeric character value reported by the browser                   (ASCII value of the key pressed)
     */
    public static native int getKeyEventCharacterValue() /*-{
        var ret = $wnd.isc.EventHandler.getKeyEventCharacterValue();
        return ret;
    }-*/;

	/**
     * Returns the natively reported target (or source) DOM element for the current mouse event. <b>NOTE:</b> Smart GWT cannot
     * guarantee that the same element will be reported in all browser/platform configurations for all event types. If you wish
     * to make use of this value, we recommend testing your use case  in all target browser configurations.
     *
     * @return native DOM element over which the mouse event occurred
     */
    public static native Element getNativeMouseTarget() /*-{
        var ret = $wnd.isc.EventHandler.getNativeMouseTarget();
        return ret;
    }-*/;

	/**
     * Return the canvas that is the target of the mouse event. Returns null if no canvas found.
     *
     * @return event target canvas
     */
    public static native Canvas getTarget() /*-{
        var ret = $wnd.isc.EventHandler.getTarget();
        return @com.smartgwt.client.widgets.Canvas::getByJSObject(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;


	/**
     * Applies to {@link com.smartgwt.client.widgets.Canvas#addMouseWheelHandler mouseWheel} events only. Returns a numeric
     * value indicating how far the mouse wheel was rotated. This value will be positive if the user scrolled the mousewheel
     * forward or up, or negative if scrolled in the other direction. For a standard wheel-mouse, an increment of 1 relates to
     * the smallest possible rotation of the mouse wheel. For other scrolling devices, such as scroll  gestures on a track pad,
     * wheel delta may be reported in finer grained increments  (causing this method to return a fractional value). <P> Note
     * that behavior for trackpad scroll-gestures may differ by browser, but where  separate vertical and horizontal scroll
     * information is available, this method refers to a vertical scroll gesture. <P> Developers should also be aware that some
     * browsers and operating systems allow the user to configure the sensitivity of the mouse wheel or trackpad, which may
     * change this value.
     *
     * @return numeric value indicating how far the mouse wheel was rotated.
     * @deprecated in favor of {@link com.smartgwt.client.util.EventHandler#getWheelDeltaY EventHandler.getWheelDeltaY}
     */
    public static native float getWheelDelta() /*-{
        var ret = $wnd.isc.EventHandler.getWheelDelta();
        return ret;
    }-*/;

	/**
     * Applies to {@link com.smartgwt.client.widgets.Canvas#addMouseWheelHandler mouseWheel} events only. Returns a numeric
     * value indicating how far the mouse wheel was rotated. This value will be positive if the user scrolled the mousewheel
     * forward or up, or negative if scrolled in the other direction. For a standard wheel-mouse, an increment of 1 relates to
     * the smallest possible rotation of the mouse wheel. For other scrolling devices, such as scroll  gestures on a track pad,
     * wheel delta may be reported in finer grained increments  (causing this method to return a fractional value). <P> Note
     * that behavior for trackpad scroll-gestures may differ by browser, but where  separate vertical and horizontal scroll
     * information is available, this method refers to a vertical scroll gesture. <P> Developers should also be aware that some
     * browsers and operating systems allow the user to configure the sensitivity of the mouse wheel or trackpad, which may
     * change this value.
     *
     * @return numeric value indicating how far the mouse wheel was rotated.
     * @deprecated in favor of {@link com.smartgwt.client.util.EventHandler#getWheelDeltaY EventHandler.getWheelDeltaY}
     */
    public static native double getWheelDeltaAsDouble() /*-{
        var ret = $wnd.isc.EventHandler.getWheelDelta();
        return ret;
    }-*/;


	/**
     * Horizontal scroll delta reported by a {@link com.smartgwt.client.widgets.Canvas#addMouseWheelHandler mouseWheel} event
     * (such as a horizontal swipe on a track-pad). <P> Returns a numeric value indicating how far the mouse wheel was rotated
     * / the magnitude of the scroll gesture. This value will be positive if the user scrolled the mousewheel to the right,
     * negative if scrolled in the other direction.
     *
     * @return numeric value indicating how far the mouse wheel was rotated.
     * @see com.smartgwt.client.util.EventHandler#getWheelDeltaY
     */
    public static native double getWheelDeltaX() /*-{
        var ret = $wnd.isc.EventHandler.getWheelDeltaX();
        return ret;
    }-*/;

	/**
     * Applies to {@link com.smartgwt.client.widgets.Canvas#addMouseWheelHandler mouseWheel} events only. Returns a numeric
     * value indicating how far the mouse wheel was rotated. This value will be positive if the user scrolled the mousewheel
     * forward or up, or negative if scrolled in the other direction. For a standard wheel-mouse, an increment of 1 relates to
     * the smallest possible rotation of the mouse wheel. For other scrolling devices, such as scroll  gestures on a track pad,
     * wheel delta may be reported in finer grained increments  (causing this method to return a fractional value). <P> Note
     * that behavior for trackpad scroll-gestures may differ by browser, but where  separate vertical and horizontal scroll
     * information is available, this method refers to a vertical scroll gesture. <P> Developers should also be aware that some
     * browsers and operating systems allow the user to configure the sensitivity of the mouse wheel or trackpad, which may
     * change this value.
     *
     * @return numeric value indicating how far the mouse wheel was rotated.
     * @see com.smartgwt.client.util.EventHandler#getWheelDeltaX
     */
    public static native double getWheelDeltaY() /*-{
        var ret = $wnd.isc.EventHandler.getWheelDeltaY();
        return ret;
    }-*/;

	/**
     * Return the page-relative X (horizontal) coordinate of an event.
     *
     * @return x-coordinate in page coordinate space
     */
    public static native int getX() /*-{
        var ret = $wnd.isc.EventHandler.getX();
        return ret;
    }-*/;

	/**
     * Return the page-relative Y (vertical) coordinate of an event.
     *
     * @return y-coordinate in page coordinate space
     */
    public static native int getY() /*-{
        var ret = $wnd.isc.EventHandler.getY();
        return ret;
    }-*/;

	/**
     * Returns true if the left mouse button is being pressed.
     *
     * @return true == left button is down, false == up
     */
    public static native Boolean leftButtonDown() /*-{
        var ret = $wnd.isc.EventHandler.leftButtonDown();
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(ret);
    }-*/;

	/**
     * Returns true if the right mouse button is being pressed.
     *
     * @return true == right button is down, false == up
     */
    public static native Boolean rightButtonDown() /*-{
        var ret = $wnd.isc.EventHandler.rightButtonDown();
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(ret);
    }-*/;


	/**
     * This API may be called to set the native HTML5 drag tracker image. The <code>x</code> and <code>y</code> parameters may
     * be specified to affect the placement of the drag tracker image relative to the mouse cursor. The size of the drag
     * tracker image is the intrinsic size of the image. Browsers may apply certain visual effects (such as a slight
     * transparency) to this image. <p> Can only be called during the {@link
     * com.smartgwt.client.widgets.Canvas#addDragStartHandler Canvas.dragStart} event (or methods called during the handling of
     * that event). <p> <b>NOTES:</b> <ul> <li>Not supported in Opera 12.x or Safari.</li> <li>For best results, this image
     * should be preloaded. Otherwise, the image might not appear for the first drag using this image.</li> <li>This API does
     * not work in Chrome or Firefox on Windows 7 if the "Use visual styles on windows and buttons" setting is turned off.</li>
     * </ul>
     * @param src image source. See {@link com.smartgwt.client.docs.SCImgURL SCImgURL}
     */
    public static native void setDragTrackerImage(String src) /*-{
        $wnd.isc.EventHandler.setDragTrackerImage(src);
    }-*/;


    /**
     * @see EventHandler#setDragTrackerImage
     */
    public static void setDragTrackerImage(String src, int x){
        setDragTrackerImage(src, x, (Integer) null);
    }

	/**
     * This API may be called to set the native HTML5 drag tracker image. The <code>x</code> and <code>y</code> parameters may
     * be specified to affect the placement of the drag tracker image relative to the mouse cursor. The size of the drag
     * tracker image is the intrinsic size of the image. Browsers may apply certain visual effects (such as a slight
     * transparency) to this image. <p> Can only be called during the {@link
     * com.smartgwt.client.widgets.Canvas#addDragStartHandler Canvas.dragStart} event (or methods called during the handling of
     * that event). <p> <b>NOTES:</b> <ul> <li>Not supported in Opera 12.x or Safari.</li> <li>For best results, this image
     * should be preloaded. Otherwise, the image might not appear for the first drag using this image.</li> <li>This API does
     * not work in Chrome or Firefox on Windows 7 if the "Use visual styles on windows and buttons" setting is turned off.</li>
     * </ul>
     * @param src image source. See {@link com.smartgwt.client.docs.SCImgURL SCImgURL}
     * @param x offset-x from the mouse cursor
     * @param y offset-y from the mouse cursor
     */
    public static native void setDragTrackerImage(String src, int x, int y) /*-{
        $wnd.isc.EventHandler.setDragTrackerImage(src, x, y);
    }-*/;
	
	/**
     * Return true if the shift key is being held down.   Note that this is only set reliably for keyboard events.
     *
     * @return true == shift key is down
     */
    public static native Boolean shiftKeyDown() /*-{
        var ret = $wnd.isc.EventHandler.shiftKeyDown();
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(ret);
    }-*/;


	/**
     * Return whether this Canvas is masked by a clickMask (see {@link com.smartgwt.client.widgets.Canvas#showClickMask
     * Canvas.showClickMask}).
     * @param target widget to check
     *
     * @return true if masked, false if not masked.
     */
    public static native Boolean targetIsMasked(Canvas target) /*-{
        var ret = $wnd.isc.EventHandler.targetIsMasked(target.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()());
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(ret);
    }-*/;



    // ***********************************************************


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
    public static native Rectangle getDragRect() /*-{
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

    public static native Object getNativeDragData() /*-{
        return $wnd.SmartGWT.convertToJavaObject($wnd.isc.EventHandler.getNativeDragData(), true, false);
    }-*/;

    public static void setNativeDragData(Object data) {
        setNativeDragData(data, null);
    }

    public static native void setNativeDragData(Object data, String strData) /*-{
        var dragDataHolder = {};
        @com.smartgwt.client.util.JSOHelper::setAttribute(Lcom/google/gwt/core/client/JavaScriptObject;Ljava/lang/String;Ljava/lang/Object;)(dragDataHolder, "data", data);
        $wnd.isc.EventHandler.setNativeDragData(dragDataHolder.data, strData);
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


