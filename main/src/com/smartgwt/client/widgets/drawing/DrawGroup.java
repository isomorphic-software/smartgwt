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
 
package com.smartgwt.client.widgets.drawing;


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
 * DrawItem subclass to manage a group of other DrawItem instances. <P>  A DrawGroup has no local visual representation
 * other than that of its drawItems. Adding items to a drawGroup allows for central event handling, and allows them to be
 * manipulated (drawn, scaled, etc) together. <P> DrawItems are added to a DrawGroup by creating the DrawItems with {@link
 * com.smartgwt.client.widgets.drawing.DrawItem#getDrawGroup drawGroup} set to a drawGroup, or by calling {@link
 * com.smartgwt.client.widgets.drawing.DrawGroup#getAddItem addItem}. <P> DrawGroups handle events by having an explicitly
 * specified group rectangle  (see {@link com.smartgwt.client.widgets.drawing.DrawGroup#getGetGroupRect getGroupRect}).
 * This rectangle has no visual representation within the draw pane (is not visible) but any user-interactions within the
 * specified coordinates will trigger group level events. <P> DrawGroups may contain other DrawGroups.
 */
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

    public void setJavaScriptObject(JavaScriptObject jsObj) {
        id = JSOHelper.getAttribute(jsObj, "ID");
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
     * Set the height of his drawGrop {@link com.smartgwt.client.widgets.drawing.DrawGroup#getGroupRect group rectangle}. Note that setting this attribute will not move or resize the drawItems in this group.
     *
     * @param height new height for the event rect. Default value is 1
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
     * Left coordinate of the {@link com.smartgwt.client.widgets.drawing.DrawGroup#getGroupRect group rectangle} in pixels
     * relative to the DrawPane.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Set the left coordinate of this drawGroup {@link com.smartgwt.client.widgets.drawing.DrawGroup#getGroupRect group rectangle}. Note that setting this attribute will not move the drawItems in this group.
     *
     * @param left new left coordinate in pixels. Default value is 0
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
     * Set the top coordinate of this drawGroup {@link com.smartgwt.client.widgets.drawing.DrawGroup#getGroupRect group rectangle}. Note that setting this attribute will not move the drawItems in this group.
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
     * Width of the {@link com.smartgwt.client.widgets.drawing.DrawGroup#getGroupRect group rectangle} in pixels relative to
     * the DrawPane.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Set the width of his drawGrop {@link com.smartgwt.client.widgets.drawing.DrawGroup#getGroupRect group rectangle}. Note that setting this attribute will not move or resize the drawItems in this group.
     *
     * @param width new width for the event rect. Default value is 1
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
     * Executed when the left mouse is clicked (pressed and then released) on this widget.  No default implementation.
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
     * Erases all DrawItems in the DrawGroup.
     */
    public native void erase() /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.erase();
    }-*/;
	/**
     * Executed when the left mouse down is pressed on this widget.  No default implementation.
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
     * Executed when the mouse moves within this widget.  No default implementation.
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
     * Executed when the mouse leaves this widget.  No default implementation.
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
     * Executed when mouse enters this widget.  No default implementation.
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
     * Executed when the left mouse is released on this widget.  No default implementation.
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
     * Move all member drawItems by the specified number of pixels. Also updates the {@link
     * com.smartgwt.client.widgets.drawing.DrawGroup#getGroupRect group rectangle}, moving it by the same offset.
     * @param left change to left coordinate in pixels
     * @param top change to top coordinate in pixels
     */
    public native void moveBy(int left, int top) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.moveBy(left, top);
    }-*/;
	/**
     * Set both the left and top coordinate of this drawGroup {@link com.smartgwt.client.widgets.drawing.DrawGroup#getGroupRect
     * group rectangle}.  Unlike {@link com.smartgwt.client.widgets.drawing.DrawGroup#moveBy DrawGroup.moveBy}, this will not
     * move the drawItems in this group.
     * @param left new left coordinate in pixels
     * @param top new top coordinate in pixels
     */
    public native void moveTo(int left, int top) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.moveTo(left, top);
    }-*/;
	/**
     * Scale all drawItem[] shapes by the x, y multipliers
     * @param x scale in the x direction
     * @param y scale in the y direction
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
     * Class level method to set the default properties of this class. If set, then all subsequent instances of this
     * class will automatically have the default properties that were set when this method was called. This is a powerful
     * feature that eliminates the need for users to create a separate hierarchy of subclasses that only alter the default
     * properties of this class. Can also be used for skinning / styling purposes.
     * <P>
     * <b>Note:</b> This method is intended for setting default attributes only and will effect all instances of the
     * underlying class (including those automatically generated in JavaScript).
     * This method should not be used to apply standard EventHandlers or override methods for
     * a class - use a custom subclass instead.
     *
     * @param drawGroupProperties properties that should be used as new defaults when instances of this class are created
     */
    public static native void setDefaultProperties(DrawGroup drawGroupProperties) /*-{
    	var properties = $wnd.isc.addProperties({},drawGroupProperties.@com.smartgwt.client.core.BaseClass::getConfig()());
    	delete properties.ID;
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
     * Returns the top, left, top+height, left+width
     *
     * @return x1, y1, x2, y2 coordinates
     */
    public native int[] getBoundingBox() /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var selection = self.getBoundingBox();
        return selection == null || selection === undefined ? null : @com.smartgwt.client.util.JSOHelper::convertToJavaIntArray(Lcom/google/gwt/core/client/JavaScriptObject;)(selection);
    }-*/;

    /**
     * Get the center coordinates of the rectangle
     *
     * @return x, y coordinates
     */
    public native int[] getCenter() /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var selection = self.getCenter();
        return selection == null || selection === undefined ? null : @com.smartgwt.client.util.JSOHelper::convertToJavaIntArray(Lcom/google/gwt/core/client/JavaScriptObject;)(selection);
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


