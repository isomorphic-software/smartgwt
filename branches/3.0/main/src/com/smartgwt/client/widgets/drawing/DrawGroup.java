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

import java.util.*;

import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;
import com.smartgwt.client.util.*;
import com.google.gwt.event.shared.*;
import com.google.gwt.event.shared.HasHandlers;

/**
 * DrawItem subclass to manage a group of other DrawItem instances. <P>  A DrawGroup defines a local coordinate space, so a
 * group of DrawItems may be translated, scaled, or rotated together.  A DrawGroup has no visual representation other than
 * that of it's DrawItems. <P> DrawItems are added to a DrawGroup by creating the DrawItems with {@link
 * com.smartgwt.client.widgets.drawing.DrawItem#getDrawGroup drawGroup} set to a drawGroup. <P> DrawGroups may contain
 * other DrawGroups.
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

    public DrawGroup(){
        scClassName = "DrawGroup";
    }

    public DrawGroup(JavaScriptObject jsObj){
        super(jsObj);
    }

    public native JavaScriptObject create()/*-{
        var config = this.@com.smartgwt.client.core.BaseClass::getConfig()();
        var scClassName = this.@com.smartgwt.client.core.BaseClass::scClassName;
        return $wnd.isc[scClassName].create(config);
    }-*/;
    // ********************* Properties / Attributes ***********************

    /**
     * Initial list of DrawItems for this DrawGroup. <P> DrawItems can be added to a DrawGroup after initialization by setting
     * {@link com.smartgwt.client.widgets.drawing.DrawItem#getDrawGroup drawGroup}.
     *
     * @param drawItems drawItems Default value is null
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setDrawItems(DrawItem... drawItems)  throws IllegalStateException {
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
        return DrawItem.convertToDrawItemArray(getAttributeAsJavaScriptObject("drawItems"));
    }

    /**
     * Left coordinate in pixels relative to the DrawPane, or owning DrawGroup.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Set the left coordinate of this drawGroup.  Also moves all member drawItems.
     *
     * @param left new left coordinate in pixels. Default value is 0
     */
    public void setLeft(int left) {
        setAttribute("left", left, true);
    }

    /**
     * Left coordinate in pixels relative to the DrawPane, or owning DrawGroup.
     *
     *
     * @return int
     */
    public int getLeft()  {
        return getAttributeAsInt("left");
    }

    /**
     * Top coordinate in pixels relative to the DrawPane, or owning DrawGroup.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Set the top coordinate of this drawGroup.  Also moves all member drawItems.
     *
     * @param top new top coordinate in pixels. Default value is 0
     */
    public void setTop(int top) {
        setAttribute("top", top, true);
    }

    /**
     * Top coordinate in pixels relative to the DrawPane, or owning DrawGroup.
     *
     *
     * @return int
     */
    public int getTop()  {
        return getAttributeAsInt("top");
    }

    // ********************* Methods ***********************
            
    /**
     * Executed when the left mouse is clicked (pressed and then released) on this widget.  No default implementation.
     *
     * @return false to prevent this event from bubbling to this widget's parent, true or undefined to bubble.
     */
    public native Boolean click() /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var retVal =self.click();
        if(retVal == null || retVal === undefined) {
            return null;
        } else {
            return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
        }
    }-*/;
            
    /**
     * Executed every time the mouse moves while dragging this canvas.
     *
     * @return false to cancel drag interaction.
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#effects_dd_pan" target="examples">Drag pan Example</a>
     */
    public native Boolean dragMove() /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var retVal =self.dragMove();
        if(retVal == null || retVal === undefined) {
            return null;
        } else {
            return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
        }
    }-*/;
            
    /**
     * Executed when dragging first starts. Your widget can use this opportunity to set things up for the drag, such as setting
     * the drag tracker. Returning false from this event handler will cancel the drag action entirely. <p> A drag action is
     * considered to be begin when the mouse has moved {@link com.smartgwt.client.widgets.Canvas#getDragStartDistance
     * dragStartDistance} with the left mouse down.
     *
     * @return false to cancel drag action.
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#effects_dd_pan" target="examples">Drag pan Example</a>
     */
    public native Boolean dragStart() /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var retVal =self.dragStart();
        if(retVal == null || retVal === undefined) {
            return null;
        } else {
            return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
        }
    }-*/;
            
    /**
     * Executed when the mouse button is released at the end of the drag. Your widget can use this opportunity to fire code
     * based on the last location of the drag or reset any visual state that was sent.
     *
     * @return false to cancel drag interaction.
     */
    public native Boolean dragStop() /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var retVal =self.dragStop();
        if(retVal == null || retVal === undefined) {
            return null;
        } else {
            return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
        }
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
     */
    public native Boolean mouseDown() /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var retVal =self.mouseDown();
        if(retVal == null || retVal === undefined) {
            return null;
        } else {
            return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
        }
    }-*/;
            
    /**
     * Executed when the mouse moves within this widget.  No default implementation.
     *
     * @return false to prevent this event from bubbling to this widget's parent, true or undefined to bubble.
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#basics_interaction_mouse_events" target="examples">Mouse events Example</a>
     */
    public native Boolean mouseMove() /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var retVal =self.mouseMove();
        if(retVal == null || retVal === undefined) {
            return null;
        } else {
            return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
        }
    }-*/;
            
    /**
     * Executed when the mouse leaves this widget.  No default implementation.
     *
     * @return false to prevent this event from bubbling to this widget's parent, true or undefined to bubble.
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#basics_interaction_mouse_events" target="examples">Mouse events Example</a>
     */
    public native Boolean mouseOut() /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var retVal =self.mouseOut();
        if(retVal == null || retVal === undefined) {
            return null;
        } else {
            return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
        }
    }-*/;
            
    /**
     * Executed when mouse enters this widget.  No default implementation.
     *
     * @return false to prevent this event from bubbling to this widget's parent, true or undefined to bubble.
     */
    public native Boolean mouseOver() /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var retVal =self.mouseOver();
        if(retVal == null || retVal === undefined) {
            return null;
        } else {
            return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
        }
    }-*/;
            
    /**
     * Executed when the left mouse is released on this widget.  No default implementation.
     *
     * @return false to prevent this event from bubbling to this widget's parent, true or undefined to bubble.
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#basics_interaction_mouse_events" target="examples">Mouse events Example</a>
     */
    public native Boolean mouseUp() /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var retVal =self.mouseUp();
        if(retVal == null || retVal === undefined) {
            return null;
        } else {
            return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
        }
    }-*/;
            
    /**
     * Move this drawGroup by the specified deltas for the left and top coordinate.  Also moves all member drawItems.
     * @param left change to left coordinate in pixels
     * @param top change to top coordinate in pixels
     */
    public native void moveBy(int left, int top) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.moveBy(left, top);
    }-*/;
            
    /**
     * Set both the left and top coordinate of this drawGroup.  Also moves all member drawItems.
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
     * Scale the shape by the x, y multipliers
     * @param x scale in the x direction
     * @param y scale in the y direction
     */
    public native void scaleTo(float x, float y) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.scaleTo(x, y);
    }-*/;

    // ********************* Static Methods ***********************
        
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


}



