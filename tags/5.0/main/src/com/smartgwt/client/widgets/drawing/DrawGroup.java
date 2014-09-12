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
 
package com.smartgwt.client.widgets.drawing;


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
 * DrawItem subclass to manage a group of other DrawItem instances. <P>  A DrawGroup has no local visual representation
 * other than that of its drawItems. Adding items to a drawGroup allows for central event handling, and allows them to be
 * manipulated (drawn, scaled, etc) together. <P> DrawItems are added to a DrawGroup by creating the DrawItems with {@link
 * com.smartgwt.client.widgets.drawing.DrawItem#getDrawGroup drawGroup} set to a drawGroup, or by creating a DrawGroup with
 * {@link com.smartgwt.client.widgets.drawing.DrawGroup#getDrawItems drawItems}. <P> DrawGroups handle events by having an
 * explicitly specified group rectangle  (see {@link com.smartgwt.client.widgets.drawing.DrawGroup#getGroupRect
 * DrawGroup.getGroupRect}). This rectangle has no visual representation within the draw pane (is not visible) but any
 * user-interactions within the specified coordinates will trigger group level events. <P> DrawGroups may contain other
 * DrawGroups.
 */
@BeanFactory.FrameworkClass
@BeanFactory.ScClassName("DrawGroup")
public class DrawGroup extends DrawItem {

    public static DrawGroup getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        BaseClass obj = BaseClass.getRef(jsObj);
        if(obj != null) {
            return (DrawGroup) obj;
        } else {
            return new DrawGroup(jsObj);
        }
    }


    public DrawGroup(){
        scClassName = "DrawGroup";
    }

    public DrawGroup(JavaScriptObject jsObj){
        scClassName = "DrawGroup";
        setJavaScriptObject(jsObj);
    }

    public native JavaScriptObject create()/*-{
        var config = this.@com.smartgwt.client.core.BaseClass::getConfig()();
        var scClassName = this.@com.smartgwt.client.core.BaseClass::scClassName;
        return $wnd.isc[scClassName].create(config);
    }-*/;

    // ********************* Properties / Attributes ***********************
    

    /**
     * Height of the {@link com.smartgwt.client.widgets.drawing.DrawGroup#getGroupRect group rectangle} in pixels relative to
     * the DrawPane.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets the height of this <code>DrawGroup</code>'s {@link com.smartgwt.client.widgets.drawing.DrawGroup#getGroupRect group rectangle}. Note that setting the height will not move or resize the items in this <code>DrawGroup</code>.
     *
     * @param height new height for the group rectangle. Default value is 1
     */
    public void setHeight(int height) {
        setAttribute("height", height, true);
    }

    /**
     * Height of the {@link com.smartgwt.client.widgets.drawing.DrawGroup#getGroupRect group rectangle} in pixels relative to
     * the DrawPane.
     *
     * @return int
     */
    public int getHeight()  {
        return getAttributeAsInt("height");
    }
    

    /**
     * <b>NOTE:</b> DrawGroups do not support knobs.
     *
     * @param knobs  Default value is null
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     * @see com.smartgwt.client.widgets.drawing.DrawItem#setKnobs
     * @see <a href="http://www.smartclient.com/smartgwtee/showcase/#diagramming" target="examples">Diagramming Example</a>
     * 
     */
    public void setKnobs(KnobType... knobs)  throws IllegalStateException {
        setAttribute("knobs", knobs, false);
    }

    /**
     * <b>NOTE:</b> DrawGroups do not support knobs.
     *
     * @return KnobType...
     * @see com.smartgwt.client.widgets.drawing.DrawItem#getKnobs
     * @see <a href="http://www.smartclient.com/smartgwtee/showcase/#diagramming" target="examples">Diagramming Example</a>
     * 
     */
    public KnobType[] getKnobs()  {
        final String[] strings = getAttributeAsStringArray("knobs");
        return EnumUtil.getEnums(KnobType.values(), strings, strings == null ? null : new KnobType[strings.length]);
    }
    

    /**
     * Left coordinate of the {@link com.smartgwt.client.widgets.drawing.DrawGroup#getGroupRect group rectangle} in pixels
     * relative to the DrawPane.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets the left coordinate of this <code>DrawGroup</code>'s {@link com.smartgwt.client.widgets.drawing.DrawGroup#getGroupRect group rectangle}. Note that setting the left coordinate will not move the items in this <code>DrawGroup</code>.
     *
     * @param left new left coordinate. Default value is 0
     */
    public void setLeft(int left) {
        setAttribute("left", left, true);
    }

    /**
     * Left coordinate of the {@link com.smartgwt.client.widgets.drawing.DrawGroup#getGroupRect group rectangle} in pixels
     * relative to the DrawPane.
     *
     * @return int
     */
    public int getLeft()  {
        return getAttributeAsInt("left");
    }
    

    /**
     * Top coordinate of the {@link com.smartgwt.client.widgets.drawing.DrawGroup#getGroupRect group rectangle} in pixels
     * relative to the DrawPane.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets the top coordinate of this <code>DrawGroup</code>'s {@link com.smartgwt.client.widgets.drawing.DrawGroup#getGroupRect group rectangle}. Note that setting the top coordinate will not move the items in this <code>DrawGroup</code>.
     *
     * @param top new top coordinate in pixels. Default value is 0
     */
    public void setTop(int top) {
        setAttribute("top", top, true);
    }

    /**
     * Top coordinate of the {@link com.smartgwt.client.widgets.drawing.DrawGroup#getGroupRect group rectangle} in pixels
     * relative to the DrawPane.
     *
     * @return int
     */
    public int getTop()  {
        return getAttributeAsInt("top");
    }
    

    /**
     * When should this drawGroup receive event notifications? If set to <code>true</code>, the developer can specify an
     * explicit  {@link com.smartgwt.client.widgets.drawing.DrawGroup#getGroupRect set of coordinates}. Whenever the user
     * interacts with this rectangle, the drawGroup will be notified and the appropriate event handlers will be fired. Note
     * that rectangle need not contain all DrawItems within the group, and  is manually managed by the developer.<br> If set to
     * <code>false</code>, the {@link com.smartgwt.client.widgets.drawing.DrawGroup#getGroupRect event rectangle}  coordinates
     * are unused - instead as a user interacts with specific drawItems within this group, the appropriate event handler would
     * be fired on the item, then the event would "bubble" to the drawGroup, firing the appropriate event handler at the group
     * level as well.
     *
     * @param useGroupRect  Default value is false
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setUseGroupRect(boolean useGroupRect)  throws IllegalStateException {
        setAttribute("useGroupRect", useGroupRect, false);
    }

    /**
     * When should this drawGroup receive event notifications? If set to <code>true</code>, the developer can specify an
     * explicit  {@link com.smartgwt.client.widgets.drawing.DrawGroup#getGroupRect set of coordinates}. Whenever the user
     * interacts with this rectangle, the drawGroup will be notified and the appropriate event handlers will be fired. Note
     * that rectangle need not contain all DrawItems within the group, and  is manually managed by the developer.<br> If set to
     * <code>false</code>, the {@link com.smartgwt.client.widgets.drawing.DrawGroup#getGroupRect event rectangle}  coordinates
     * are unused - instead as a user interacts with specific drawItems within this group, the appropriate event handler would
     * be fired on the item, then the event would "bubble" to the drawGroup, firing the appropriate event handler at the group
     * level as well.
     *
     * @return boolean
     */
    public boolean getUseGroupRect()  {
        Boolean result = getAttributeAsBoolean("useGroupRect");
        return result == null ? false : result;
    }
    

    /**
     * Width of the {@link com.smartgwt.client.widgets.drawing.DrawGroup#getGroupRect group rectangle} in pixels relative to
     * the DrawPane.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets the width of this <code>DrawGroup</code>'s {@link com.smartgwt.client.widgets.drawing.DrawGroup#getGroupRect group rectangle}. Note that setting the width will not move or resize the items in this <code>DrawGroup</code>.
     *
     * @param width new width for the group rectangle. Default value is 1
     */
    public void setWidth(int width) {
        setAttribute("width", width, true);
    }

    /**
     * Width of the {@link com.smartgwt.client.widgets.drawing.DrawGroup#getGroupRect group rectangle} in pixels relative to
     * the DrawPane.
     *
     * @return int
     */
    public int getWidth()  {
        return getAttributeAsInt("width");
    }
    

    // ********************* Methods ***********************
	/**
     * Notification fired when the user clicks on this DrawGroup. <p> Note that if {@link
     * com.smartgwt.client.widgets.drawing.DrawGroup#getUseGroupRect useGroupRect} is true, this notification will be triggered
     * by the user interacting with the specified {@link com.smartgwt.client.widgets.drawing.DrawGroup#getGroupRect group
     * rectangle} for the group. If {@link com.smartgwt.client.widgets.drawing.DrawGroup#getUseGroupRect useGroupRect} is
     * false, the notification will bubble up from interactions with individual items within the group.
     *
     * @return false to prevent this event from bubbling to this widget's parent, true or undefined to bubble.
     * @see com.smartgwt.client.widgets.Canvas#getOffsetX
     * @see com.smartgwt.client.widgets.Canvas#getOffsetY
     */
    public native Boolean click() /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.click();
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(ret);
    }-*/;

	/**
     * Notification fired for every mouseMove event triggered while the user is dragging this DrawGroup. Will only fire if
     * {@link com.smartgwt.client.widgets.drawing.DrawItem#getCanDrag canDrag} is true for this group. <P> Note that if {@link
     * com.smartgwt.client.widgets.drawing.DrawGroup#getUseGroupRect useGroupRect} is true, this notification will be triggered
     * by the user interacting with the specified {@link com.smartgwt.client.widgets.drawing.DrawGroup#getGroupRect group
     * rectangle} for the group. If {@link com.smartgwt.client.widgets.drawing.DrawGroup#getUseGroupRect useGroupRect} is
     * false, the notification will bubble up from interactions with individual items within the group. <P> Default drag
     * behavior will be to reposition all items in the group (and update the group rectangle).
     *
     * @return false to cancel drag interaction.
     * @see com.smartgwt.client.widgets.Canvas#getOffsetX
     * @see com.smartgwt.client.widgets.Canvas#getOffsetY
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#effects_dd_pan" target="examples">Drag pan Example</a>
     */
    public native boolean dragMove() /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.dragMove();
        return ret;
    }-*/;

	/**
     * Notification fired when the user starts to drag this DrawGroup. Will only fire if {@link
     * com.smartgwt.client.widgets.drawing.DrawItem#getCanDrag canDrag} is true for this group. <P> Note that if {@link
     * com.smartgwt.client.widgets.drawing.DrawGroup#getUseGroupRect useGroupRect} is true, this notification will be triggered
     * by the user interacting with the specified {@link com.smartgwt.client.widgets.drawing.DrawGroup#getGroupRect group
     * rectangle} for the group. If {@link com.smartgwt.client.widgets.drawing.DrawGroup#getUseGroupRect useGroupRect} is
     * false, the notification will bubble up from interactions with individual items within the group. <P> Default drag
     * behavior will be to reposition all items in the group (and update the group rectangle).
     *
     * @return false to cancel drag action.
     * @see com.smartgwt.client.widgets.Canvas#getOffsetX
     * @see com.smartgwt.client.widgets.Canvas#getOffsetY
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#effects_dd_pan" target="examples">Drag pan Example</a>
     */
    public native boolean dragStart() /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.dragStart();
        return ret;
    }-*/;

	/**
     * Notification fired when the user stops dragging this DrawGroup. Will only fire if {@link
     * com.smartgwt.client.widgets.drawing.DrawItem#getCanDrag canDrag} is true for this group. <P> Note that if {@link
     * com.smartgwt.client.widgets.drawing.DrawGroup#getUseGroupRect useGroupRect} is true, this notification will be triggered
     * by the user interacting with the specified {@link com.smartgwt.client.widgets.drawing.DrawGroup#getGroupRect group
     * rectangle} for the group. If {@link com.smartgwt.client.widgets.drawing.DrawGroup#getUseGroupRect useGroupRect} is
     * false, the notification will bubble up from interactions with individual items within the group.
     *
     * @return false to cancel drag interaction.
     * @see com.smartgwt.client.widgets.Canvas#getOffsetX
     * @see com.smartgwt.client.widgets.Canvas#getOffsetY
     */
    public native boolean dragStop() /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.dragStop();
        return ret;
    }-*/;

	/**
     * Erases all DrawItems in the DrawGroup.
     */
    public native void erase() /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.erase();
    }-*/;

	/**
     * Get the center point of the {@link com.smartgwt.client.widgets.drawing.DrawGroup#getGroupRect group rectangle}.
     *
     * @return the center point
     */
    public native Point getCenter() /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.getCenter();
        if(ret == null) return null;
        return @com.smartgwt.client.widgets.drawing.Point::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

	/**
     * Notification fired when the user presses the left mouse button on this DrawGroup. <p> Note that if {@link
     * com.smartgwt.client.widgets.drawing.DrawGroup#getUseGroupRect useGroupRect} is true, this notification will be triggered
     * by the user interacting with the specified {@link com.smartgwt.client.widgets.drawing.DrawGroup#getGroupRect group
     * rectangle} for the group. If {@link com.smartgwt.client.widgets.drawing.DrawGroup#getUseGroupRect useGroupRect} is
     * false, the notification will bubble up from interactions with individual items within the group.
     *
     * @return false to prevent this event from bubbling to this widget's parent, true or undefined to bubble.
     * @see com.smartgwt.client.widgets.Canvas#getOffsetX
     * @see com.smartgwt.client.widgets.Canvas#getOffsetY
     */
    public native Boolean mouseDown() /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.mouseDown();
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(ret);
    }-*/;

	/**
     * Notification fired when the user moves the mouse over this DrawGroup. <p> Note that if {@link
     * com.smartgwt.client.widgets.drawing.DrawGroup#getUseGroupRect useGroupRect} is true, this notification will be triggered
     * by the user interacting with the specified {@link com.smartgwt.client.widgets.drawing.DrawGroup#getGroupRect group
     * rectangle} for the group. If {@link com.smartgwt.client.widgets.drawing.DrawGroup#getUseGroupRect useGroupRect} is
     * false, the notification will bubble up from interactions with individual items within the group.
     *
     * @return false to prevent this event from bubbling to this widget's parent, true or undefined to bubble.
     * @see com.smartgwt.client.widgets.Canvas#getOffsetX
     * @see com.smartgwt.client.widgets.Canvas#getOffsetY
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#basics_interaction_mouse_events" target="examples">Mouse events Example</a>
     */
    public native Boolean mouseMove() /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.mouseMove();
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(ret);
    }-*/;

	/**
     * Notification fired when the mouse leaves this DrawGroup. <p> Note that if {@link
     * com.smartgwt.client.widgets.drawing.DrawGroup#getUseGroupRect useGroupRect} is true, this notification will be triggered
     * by the user interacting with the specified {@link com.smartgwt.client.widgets.drawing.DrawGroup#getGroupRect group
     * rectangle} for the group. If {@link com.smartgwt.client.widgets.drawing.DrawGroup#getUseGroupRect useGroupRect} is
     * false, the notification will bubble up from interactions with individual items within the group.
     *
     * @return false to prevent this event from bubbling to this widget's parent, true or undefined to bubble.
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#basics_interaction_mouse_events" target="examples">Mouse events Example</a>
     */
    public native Boolean mouseOut() /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.mouseOut();
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(ret);
    }-*/;

	/**
     * Notification fired when the mouse enters this DrawGroup. <p> Note that if {@link
     * com.smartgwt.client.widgets.drawing.DrawGroup#getUseGroupRect useGroupRect} is true, this notification will be triggered
     * by the user interacting with the specified {@link com.smartgwt.client.widgets.drawing.DrawGroup#getGroupRect group
     * rectangle} for the group. If {@link com.smartgwt.client.widgets.drawing.DrawGroup#getUseGroupRect useGroupRect} is
     * false, the notification will bubble up from interactions with individual items within the group.
     *
     * @return false to prevent this event from bubbling to this widget's parent, true or undefined to bubble.
     * @see com.smartgwt.client.widgets.Canvas#getOffsetX
     * @see com.smartgwt.client.widgets.Canvas#getOffsetY
     */
    public native Boolean mouseOver() /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.mouseOver();
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(ret);
    }-*/;

	/**
     * Notification fired when the user releases the left mouse button on this DrawGroup. <p> Note that if {@link
     * com.smartgwt.client.widgets.drawing.DrawGroup#getUseGroupRect useGroupRect} is true, this notification will be triggered
     * by the user interacting with the specified {@link com.smartgwt.client.widgets.drawing.DrawGroup#getGroupRect group
     * rectangle} for the group. If {@link com.smartgwt.client.widgets.drawing.DrawGroup#getUseGroupRect useGroupRect} is
     * false, the notification will bubble up from interactions with individual items within the group.
     *
     * @return false to prevent this event from bubbling to this widget's parent, true or undefined to bubble.
     * @see com.smartgwt.client.widgets.Canvas#getOffsetX
     * @see com.smartgwt.client.widgets.Canvas#getOffsetY
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#basics_interaction_mouse_events" target="examples">Mouse events Example</a>
     */
    public native Boolean mouseUp() /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.mouseUp();
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(ret);
    }-*/;



	/**
     * Updates the <code>DrawGroup</code>'s left coordinate by <code>dX</code> and the top coordinate by <code>dY</code>. Note
     * that this does not move or resize the items in this <code>DrawGroup</code>.
     * @param dX change to left coordinate in pixels
     * @param dY change to top coordinate in pixels
     */
    public native void moveBy(int dX, int dY) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.moveBy(dX, dY);
    }-*/;




	/**
     * Sets both the left and top coordinates of this <code>DrawGroup</code>'s {@link
     * com.smartgwt.client.widgets.drawing.DrawGroup#getGroupRect group rectangle}. Note that this does not move or resize the
     * items in this <code>DrawGroup</code>.
     * @param left new left coordinate in pixels
     * @param top new top coordinate in pixels
     */
    public native void moveTo(Integer left, Integer top) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.moveTo(left == null ? null : left.@java.lang.Integer::intValue()(), top == null ? null : top.@java.lang.Integer::intValue()());
    }-*/;




	/**
     * Scale all drawItem[] shapes by the x, y multipliers
     * @param x scale in the x direction
     * @param y scale in the y direction
     * @deprecated  {@link com.smartgwt.client.docs.GwtFloatVsDouble GwtFloatVsDouble}
     */
    public native void scaleBy(float x, float y) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.scaleBy(x, y);
    }-*/;

	/**
     * Scale all drawItem[] shapes by the x, y multipliers
     * @param x scale in the x direction
     * @param y scale in the y direction
     */
    public native void scaleBy(double x, double y) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.scaleBy(x, y);
    }-*/;




	/**
     * Scale the each item in the drawGroup by the x, y multipliers
     * @param x scale in the x direction
     * @param y scale in the y direction
     * @deprecated  {@link com.smartgwt.client.docs.GwtFloatVsDouble GwtFloatVsDouble}
     */
    public native void scaleTo(float x, float y) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.scaleTo(x, y);
    }-*/;

	/**
     * Scale the each item in the drawGroup by the x, y multipliers
     * @param x scale in the x direction
     * @param y scale in the y direction
     */
    public native void scaleTo(double x, double y) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.scaleTo(x, y);
    }-*/;



    // ********************* Static Methods ***********************

    /** 
     * Class level method to set the default properties of this class.  If set, then all
     * existing and subsequently created instances of this class will automatically have
     * default properties corresponding to
     * the properties set on the SmartGWT class instance passed to this function before its
     * underlying SmartClient JS object was created.
     * This is a powerful feature that eliminates the need for users to create a separate
     * hierarchy of subclasses that only alter the default properties of this class. Can also
     * be used for skinning / styling purposes.  <P> <b>Note:</b> This method is intended for
     * setting default attributes only and will affect all instances of the underlying class
     * (including those automatically generated in JavaScript).  This method should not be used
     * to apply standard EventHandlers or override methods for a class - use a custom subclass
     * instead.  Calling this method after instances have been created can result in undefined
     * behavior, since it bypasses any setters and a class instance may have already examined 
     * a particular property and not be expecting any changes through this route.
     *
     * @param drawGroupProperties properties that should be used as new defaults when instances of this class are created
     */
    public static native void setDefaultProperties(DrawGroup drawGroupProperties) /*-{
    	var properties = $wnd.isc.addProperties({},drawGroupProperties.@com.smartgwt.client.core.BaseClass::getConfig()());
        @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(properties,false);
        $wnd.isc.DrawGroup.addProperties(properties);
    }-*/;

    // ***********************************************************



    /**
     * Rotate the group by degrees. This is a relative rotation based on any current rotation
     * @param degrees
     */
    public native void rotateBy(String degrees) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.rotateBy(degrees);
    }-*/;

    /**
     * Rotate the group to degrees. This is an absolute rotation and does not consider any existing rotation
     * @param degrees
     */
    public native void rotateTo(String degrees) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.rotateTo(degrees);
    }-*/;

    /**
     * Initial list of DrawItems for this DrawGroup. <P> DrawItems can be added to a DrawGroup after initialization by setting
     * {@link com.smartgwt.client.widgets.drawing.DrawItem#getDrawGroup drawGroup}.
     *
     * @param drawItems drawItems Default value is null
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setDrawItems(DrawItem... drawItems)  throws IllegalStateException {
        for (int i = 0; i < drawItems.length; i++) {
            if (!drawItems[i].isCreated()) drawItems[i].create();
        }
        setAttribute("drawItems", drawItems, false);
    }

    /**
     * Initial list of DrawItems for this DrawGroup. <P> DrawItems can be added to a DrawGroup after initialization by setting
     * {@link com.smartgwt.client.widgets.drawing.DrawItem#getDrawGroup drawGroup}.
     *
     *
     * @return DrawItem
     */
    public DrawItem[] getDrawItems()  {
        return com.smartgwt.client.util.ConvertTo.arrayOfDrawItem(getAttributeAsJavaScriptObject("drawItems"));
    }

    /**
     * This method will return an array of integers mapping out the coordinates (left, top, width, height) of the "group
     * rectangle" for the group. This is the area of the drawPane where user interactions will fire event notifications on this
     * drawGroup. <P> Developers may also use {@link com.smartgwt.client.widgets.drawing.DrawGroup#getLeft left}, {@link
     * com.smartgwt.client.widgets.drawing.DrawGroup#getTop top}, {@link com.smartgwt.client.widgets.drawing.DrawGroup#getWidth
     * width} and {@link com.smartgwt.client.widgets.drawing.DrawGroup#getHeight height} to manage each coordinate directly.
     *
     * @return 4 element array containing left, top, width, height of the group rectangle.
     */
    public native Rectangle getGroupRect() /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var rect = self.getGroupRect();
        return @com.smartgwt.client.core.Rectangle::new(IIII)(rect[0], rect[1],rect[2],rect[3]);
    }-*/;



}


