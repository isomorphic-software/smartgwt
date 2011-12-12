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
 * Base class for graphical elements drawn in a DrawPane.  All properties and methods documented here are available on all
 * DrawItems unless otherwise specified.   <P> Note that DrawItems as such should never be created, only concrete
 * subclasses such as {@link com.smartgwt.client.widgets.drawing.DrawGroup} and {@link
 * com.smartgwt.client.widgets.drawing.DrawLine}. <P> See {@link com.smartgwt.client.widgets.drawing.DrawPane} for the
 * different approaches to create DrawItems.
 */
public class DrawItem extends BaseClass  implements com.smartgwt.client.widgets.drawing.events.HasClickHandlers, com.smartgwt.client.widgets.drawing.events.HasMouseDownHandlers, com.smartgwt.client.widgets.drawing.events.HasMouseUpHandlers, com.smartgwt.client.widgets.drawing.events.HasMouseMoveHandlers, com.smartgwt.client.widgets.drawing.events.HasMouseOutHandlers, com.smartgwt.client.widgets.drawing.events.HasMouseOverHandlers {

    public static DrawItem getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        BaseClass obj = BaseClass.getRef(jsObj);
        if(obj != null) {
            return (DrawItem) obj;
        } else {
            return new DrawItem(jsObj);
        }
    }

    public DrawItem(){
        scClassName = "DrawItem";
    }

    public DrawItem(JavaScriptObject jsObj){
        super(jsObj);
    }

    public native JavaScriptObject create()/*-{
        var config = this.@com.smartgwt.client.core.BaseClass::getConfig()();
        var scClassName = this.@com.smartgwt.client.core.BaseClass::scClassName;
        return $wnd.isc[scClassName].create(config);
    }-*/;
    // ********************* Properties / Attributes ***********************


    /**
     * Flag indicating a drawItem has been destroyed, similar to {@link com.smartgwt.client.widgets.Canvas#getDestroyed
     * destroyed}.
     *
     * <b>Note :</b> This method should be called only after the underlying component has been created.
     *
     * @return Boolean
     * @throws IllegalStateException if underlying component has not yet been created.
     */
    public Boolean getDestroyed() throws IllegalStateException {
        errorIfNotCreated("destroyed");
        return getAttributeAsBoolean("destroyed");
    }


    /**
     * Flag indicating a drawItem is mid-destruction, similar to {@link com.smartgwt.client.widgets.Canvas#getDestroying
     * destroying}.
     *
     * <b>Note :</b> This method should be called only after the underlying component has been created.
     *
     * @return Boolean
     * @throws IllegalStateException if underlying component has not yet been created.
     */
    public Boolean getDestroying() throws IllegalStateException {
        errorIfNotCreated("destroying");
        return getAttributeAsBoolean("destroying");
    }

    /**
     * Number of pixels the cursor needs to move before the EventHandler starts a drag operation.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param dragStartDistance dragStartDistance Default value is 5
     * @see com.smartgwt.client.docs.Dragdrop Dragdrop overview and related methods
     */
    public void setDragStartDistance(int dragStartDistance) {
        setAttribute("dragStartDistance", dragStartDistance, true);
    }

    /**
     * Number of pixels the cursor needs to move before the EventHandler starts a drag operation.
     *
     *
     * @return int
     * @see com.smartgwt.client.docs.Dragdrop Dragdrop overview and related methods
     */
    public int getDragStartDistance()  {
        return getAttributeAsInt("dragStartDistance");
    }

    /**
     * {@link com.smartgwt.client.widgets.drawing.DrawGroup} this drawItem is a member of. <P> Coordinates for a drawItem that
     * has a drawGroup are relative to that drawGroup. DrawItems that are part of a drawGroup with translate, scale and rotate
     * with their DrawGroup.
     *
     * @param drawGroup drawGroup Default value is null
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setDrawGroup(DrawGroup drawGroup)  throws IllegalStateException {
        setAttribute("drawGroup", drawGroup == null ? null : drawGroup.getOrCreateJsObj(), false);
    }

    /**
     * {@link com.smartgwt.client.widgets.drawing.DrawGroup} this drawItem is a member of. <P> Coordinates for a drawItem that
     * has a drawGroup are relative to that drawGroup. DrawItems that are part of a drawGroup with translate, scale and rotate
     * with their DrawGroup.
     *
     *
     * @return DrawGroup
     */
    public DrawGroup getDrawGroup()  {
        return DrawGroup.getOrCreateRef(getAttributeAsJavaScriptObject("drawGroup"));
    }

    /**
     * {@link com.smartgwt.client.widgets.drawing.DrawPane} this drawItem should draw in. <P> If this item has a {@link
     * com.smartgwt.client.widgets.drawing.DrawGroup}, the drawGroup's drawPane is automatically used.
     *
     * @param drawPane drawPane Default value is null
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setDrawPane(DrawPane drawPane)  throws IllegalStateException {
        setAttribute("drawPane", drawPane == null ? null : drawPane.getOrCreateJsObj(), false);
    }

    /**
     * {@link com.smartgwt.client.widgets.drawing.DrawPane} this drawItem should draw in. <P> If this item has a {@link
     * com.smartgwt.client.widgets.drawing.DrawGroup}, the drawGroup's drawPane is automatically used.
     *
     *
     * @return DrawPane
     */
    public DrawPane getDrawPane()  {
        return DrawPane.getOrCreateRef(getAttributeAsJavaScriptObject("drawPane"));
    }

    /**
     * Style of arrowhead to draw at the end of the line or path.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Set the arrowhead at the end of this path.
     *
     * @param endArrow style of arrow to use. Default value is null
     */
    public void setEndArrow(ArrowStyle endArrow) {
        setAttribute("endArrow", endArrow.getValue(), true);
    }

    /**
     * Style of arrowhead to draw at the end of the line or path.
     *
     *
     * @return ArrowStyle
     */
    public ArrowStyle getEndArrow()  {
        return EnumUtil.getEnum(ArrowStyle.values(), getAttribute("endArrow"));
    }

    /**
     * Fill color to use for shapes.  The default of 'null' is transparent.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Update fillColor for this drawItem.
     *
     * @param fillColor new fillColor to use.  Pass null for transparent.. Default value is null
     */
    public void setFillColor(String fillColor) {
        setAttribute("fillColor", fillColor, true);
    }

    /**
     * Fill color to use for shapes.  The default of 'null' is transparent.
     *
     *
     * @return String
     */
    public String getFillColor()  {
        return getAttributeAsString("fillColor");
    }

    /**
     * Opacity of the fillColor, as a number between 0 (transparent) and 1 (opaque).
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Update fillOpacity for this drawItem.
     *
     * @param fillOpacity new opacity, as a number between 0 (transparent) and 1 (opaque).. Default value is 1.0
     */
    public void setFillOpacity(float fillOpacity) {
        setAttribute("fillOpacity", fillOpacity, true);
    }

    /**
     * Opacity of the fillColor, as a number between 0 (transparent) and 1 (opaque).
     *
     *
     * @return float
     */
    public float getFillOpacity()  {
        return getAttributeAsFloat("fillOpacity");
    }

    /**
     * Array of control knobs to display for this item. Each {@link com.smartgwt.client.types.KnobType} specified in this will
     * turn on UI allowing the user to manipulate this drawItem.  To update the set of knobs at runtime use {@link
     * com.smartgwt.client.widgets.drawing.DrawItem#showKnobs DrawItem.showKnobs} and {@link
     * com.smartgwt.client.widgets.drawing.DrawItem#hideKnobs DrawItem.hideKnobs}
     *
     * @param knobs knobs Default value is null
     */
    public void setKnobs(KnobType... knobs) {
        setAttribute("knobs", knobs, true);
    }

    /**
     * Array of control knobs to display for this item. Each {@link com.smartgwt.client.types.KnobType} specified in this will
     * turn on UI allowing the user to manipulate this drawItem.  To update the set of knobs at runtime use {@link
     * com.smartgwt.client.widgets.drawing.DrawItem#showKnobs DrawItem.showKnobs} and {@link
     * com.smartgwt.client.widgets.drawing.DrawItem#hideKnobs DrawItem.hideKnobs}
     *
     *
     * @return KnobType
     */
    public KnobType[] getKnobs()  {
        return (KnobType[]) EnumUtil.getEnums(KnobType.values(), getAttributeAsStringArray("knobs"));
    }

    /**
     * Style of drawing the endpoints of a line. <P> Note that for dashed and dotted lines, the lineCap style affects each dash
     * or dot.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Update lineCap for this drawItem.
     *
     * @param lineCap new lineCap to use. Default value is "round"
     */
    public void setLineCap(LineCap lineCap) {
        setAttribute("lineCap", lineCap.getValue(), true);
    }

    /**
     * Style of drawing the endpoints of a line. <P> Note that for dashed and dotted lines, the lineCap style affects each dash
     * or dot.
     *
     *
     * @return LineCap
     */
    public LineCap getLineCap()  {
        return EnumUtil.getEnum(LineCap.values(), getAttribute("lineCap"));
    }

    /**
     * Line color
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Update lineColor for this drawItem.
     *
     * @param lineColor new line color.  Pass null for transparent.. Default value is "#808080"
     */
    public void setLineColor(String lineColor) {
        setAttribute("lineColor", lineColor, true);
    }

    /**
     * Line color
     *
     *
     * @return String
     */
    public String getLineColor()  {
        return getAttributeAsString("lineColor");
    }

    /**
     * Opacity for lines, as a number between 0 (transparent) and 1 (opaque).
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Update lineOpacity for this drawItem.
     *
     * @param lineOpacity new opacity, as a number between 0 (transparent) and 1 (opaque).. Default value is 1.0
     */
    public void setLineOpacity(float lineOpacity) {
        setAttribute("lineOpacity", lineOpacity, true);
    }

    /**
     * Opacity for lines, as a number between 0 (transparent) and 1 (opaque).
     *
     *
     * @return float
     */
    public float getLineOpacity()  {
        return getAttributeAsFloat("lineOpacity");
    }

    /**
     * Pattern for lines, eg "solid" or "dash"
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Update linePattern for this drawItem.
     *
     * @param linePattern new linePattern to use. Default value is "solid"
     */
    public void setLinePattern(LinePattern linePattern) {
        setAttribute("linePattern", linePattern.getValue(), true);
    }

    /**
     * Pattern for lines, eg "solid" or "dash"
     *
     *
     * @return LinePattern
     */
    public LinePattern getLinePattern()  {
        return EnumUtil.getEnum(LinePattern.values(), getAttribute("linePattern"));
    }

    /**
     * Pixel width for lines.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Update lineWidth for this drawItem.
     *
     * @param lineWidth new pixel lineWidth. Default value is 3
     */
    public void setLineWidth(int lineWidth) {
        setAttribute("lineWidth", lineWidth, true);
    }

    /**
     * Pixel width for lines.
     *
     *
     * @return int
     */
    public int getLineWidth()  {
        return getAttributeAsInt("lineWidth");
    }

    /**
     * If this item is showing a <code>"move"</code> {@link com.smartgwt.client.widgets.drawing.DrawItem#getKnobs control
     * knob}, this attribute
     *  specifies where the knob should appear with respect to the drawItem. Valid options are:
     *  <pre>
     *   <code>"TL"</code> Top Left corner
     *   <code>"TR"</code> Top Right corner
     *   <code>"BL"</code> Bottom Left corner
     *   <code>"BR"</code> Bottom Right corner
     *   <code>"T"</code> Centered on the top edge
     *   <code>"B"</code> Centered on the bottom edge
     *   <code>"L"</code> Centered on the left edge
     *   <code>"R"</code> Centered on thie right edge
     *   <code>"C"</code> positioned over the center of the drawItem
     *  </pre>
     *
     * @param moveKnobPoint moveKnobPoint Default value is "TL"
     */
    public void setMoveKnobPoint(String moveKnobPoint) {
        setAttribute("moveKnobPoint", moveKnobPoint, true);
    }

    /**
     * If this item is showing a <code>"move"</code> {@link com.smartgwt.client.widgets.drawing.DrawItem#getKnobs control
     * knob}, this attribute
     *  specifies where the knob should appear with respect to the drawItem. Valid options are:
     *  <pre>
     *   <code>"TL"</code> Top Left corner
     *   <code>"TR"</code> Top Right corner
     *   <code>"BL"</code> Bottom Left corner
     *   <code>"BR"</code> Bottom Right corner
     *   <code>"T"</code> Centered on the top edge
     *   <code>"B"</code> Centered on the bottom edge
     *   <code>"L"</code> Centered on the left edge
     *   <code>"R"</code> Centered on thie right edge
     *   <code>"C"</code> positioned over the center of the drawItem
     *  </pre>
     *
     *
     * @return String
     */
    public String getMoveKnobPoint()  {
        return getAttributeAsString("moveKnobPoint");
    }

    /**
     * rotation in degrees.
     *
     * @param rotate rotate Default value is 0.0
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setRotate(float rotate)  throws IllegalStateException {
        setAttribute("rotate", rotate, false);
    }

    /**
     * rotation in degrees.
     *
     *
     * @return float
     */
    public float getRotate()  {
        return getAttributeAsFloat("rotate");
    }

    /**
     * Shadow used for all DrawItem subtypes.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Update shadow for this drawItem.
     *
     * @param shadow new shadow. Default value is null
     */
    public void setShadow(Shadow shadow) {
        setAttribute("shadow", shadow.getJsObj(), true);
    }

    /**
     * Shadow used for all DrawItem subtypes.
     *
     *
     * @return Shadow
     */
    public Shadow getShadow()  {
        return new Shadow(getAttributeAsJavaScriptObject("shadow"));
    }

    /**
     * Style of arrowhead to draw at the beginning of the line or path.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Set the arrowhead at the beginning of this path.
     *
     * @param startArrow style of arrow to use. Default value is null
     */
    public void setStartArrow(ArrowStyle startArrow) {
        setAttribute("startArrow", startArrow.getValue(), true);
    }

    /**
     * Style of arrowhead to draw at the beginning of the line or path.
     *
     *
     * @return ArrowStyle
     */
    public ArrowStyle getStartArrow()  {
        return EnumUtil.getEnum(ArrowStyle.values(), getAttribute("startArrow"));
    }

    // ********************* Methods ***********************
    /**
     * Add a click handler.
     * <p>
     * Executed when the left mouse is clicked (pressed and then released) on this widget.  No default implementation.
     *
     * @param handler the click handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addClickHandler(com.smartgwt.client.widgets.drawing.events.ClickHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.drawing.events.ClickEvent.getType()) == 0) setupClickEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.drawing.events.ClickEvent.getType());
    }

    private native void setupClickEvent() /*-{
        var obj = null;
        var selfJ = this;
            if(this.@com.smartgwt.client.core.BaseClass::isCreated()()) {
                obj = this.@com.smartgwt.client.core.BaseClass::getJsObj()();
                obj.addProperties({click:$debox($entry(function(){
                        var param = {};
                        var event = @com.smartgwt.client.widgets.drawing.events.ClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.core.BaseClass::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                        var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                        return !ret;
                    }))
                });
            } else {
                obj = this.@com.smartgwt.client.core.BaseClass::getConfig()();
                obj.click = $debox($entry(function(){
                    var param = {};
                    var event = @com.smartgwt.client.widgets.drawing.events.ClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    selfJ.@com.smartgwt.client.core.BaseClass::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                    return !ret;
                }));
            }
   }-*/;
            
    /**
     * Permanently destroys this DrawItem, similar to {@link com.smartgwt.client.widgets.Canvas#destroy Canvas.destroy}.
     */
    public native void destroy() /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.destroy();
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
     * Draw this item into it's current {@link com.smartgwt.client.widgets.drawing.DrawPane}.
     */
    public native void draw() /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.draw();
    }-*/;
            
    /**
     * Erase this drawItem's visual representation and remove it from it's DrawGroup (if any) and DrawPane.
     */
    public native void erase() /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.erase();
    }-*/;
            
    /**
     * Returns the page-relative left coordinate of the widget on the page, in pixels.
     *
     * @return global left coordinate
     * @see com.smartgwt.client.docs.Positioning Positioning overview and related methods
     */
    public native int getPageLeft() /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        return self.getPageLeft();
    }-*/;
            
    /**
     * Returns the page-relative top coordinate of the widget on the page, in pixels
     *
     * @return GLOBAL top coordinate
     * @see com.smartgwt.client.docs.Positioning Positioning overview and related methods
     */
    public native int getPageTop() /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        return self.getPageTop();
    }-*/;
            
    /**
     * Hide this drawItem.
     */
    public native void hide() /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.hide();
    }-*/;
            
    /**
     * returns true if point is in getBoundingBox()
     * @param x 
     * @param y 
     *
     * @return 
     */
    public native Boolean isInBounds(int x, int y) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var retVal =self.isInBounds(x, y);
        if(retVal == null || retVal === undefined) {
            return null;
        } else {
            return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
        }
    }-*/;
            
    /**
     * returns true if point is in path
     * @param x 
     * @param y 
     *
     * @return 
     */
    public native Boolean isPointInPath(int x, int y) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var retVal =self.isPointInPath(x, y);
        if(retVal == null || retVal === undefined) {
            return null;
        } else {
            return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
        }
    }-*/;
    /**
     * Add a mouseDown handler.
     * <p>
     * Executed when the left mouse down is pressed on this widget.  No default implementation.
     *
     * @param handler the mouseDown handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addMouseDownHandler(com.smartgwt.client.widgets.drawing.events.MouseDownHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.drawing.events.MouseDownEvent.getType()) == 0) setupMouseDownEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.drawing.events.MouseDownEvent.getType());
    }

    private native void setupMouseDownEvent() /*-{
        var obj = null;
        var selfJ = this;
            if(this.@com.smartgwt.client.core.BaseClass::isCreated()()) {
                obj = this.@com.smartgwt.client.core.BaseClass::getJsObj()();
                obj.addProperties({mouseDown:$debox($entry(function(){
                        var param = {};
                        var event = @com.smartgwt.client.widgets.drawing.events.MouseDownEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.core.BaseClass::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                        var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                        return !ret;
                    }))
                });
            } else {
                obj = this.@com.smartgwt.client.core.BaseClass::getConfig()();
                obj.mouseDown = $debox($entry(function(){
                    var param = {};
                    var event = @com.smartgwt.client.widgets.drawing.events.MouseDownEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    selfJ.@com.smartgwt.client.core.BaseClass::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                    return !ret;
                }));
            }
   }-*/;
    /**
     * Add a mouseMove handler.
     * <p>
     * Executed when the mouse moves within this widget.  No default implementation.
     *
     * @param handler the mouseMove handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addMouseMoveHandler(com.smartgwt.client.widgets.drawing.events.MouseMoveHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.drawing.events.MouseMoveEvent.getType()) == 0) setupMouseMoveEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.drawing.events.MouseMoveEvent.getType());
    }

    private native void setupMouseMoveEvent() /*-{
        var obj = null;
        var selfJ = this;
            if(this.@com.smartgwt.client.core.BaseClass::isCreated()()) {
                obj = this.@com.smartgwt.client.core.BaseClass::getJsObj()();
                obj.addProperties({mouseMove:$debox($entry(function(){
                        var param = {};
                        var event = @com.smartgwt.client.widgets.drawing.events.MouseMoveEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.core.BaseClass::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                        var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                        return !ret;
                    }))
                });
            } else {
                obj = this.@com.smartgwt.client.core.BaseClass::getConfig()();
                obj.mouseMove = $debox($entry(function(){
                    var param = {};
                    var event = @com.smartgwt.client.widgets.drawing.events.MouseMoveEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    selfJ.@com.smartgwt.client.core.BaseClass::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                    return !ret;
                }));
            }
   }-*/;
    /**
     * Add a mouseOut handler.
     * <p>
     * Executed when the mouse leaves this widget.  No default implementation.
     *
     * @param handler the mouseOut handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addMouseOutHandler(com.smartgwt.client.widgets.drawing.events.MouseOutHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.drawing.events.MouseOutEvent.getType()) == 0) setupMouseOutEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.drawing.events.MouseOutEvent.getType());
    }

    private native void setupMouseOutEvent() /*-{
        var obj = null;
        var selfJ = this;
            if(this.@com.smartgwt.client.core.BaseClass::isCreated()()) {
                obj = this.@com.smartgwt.client.core.BaseClass::getJsObj()();
                obj.addProperties({mouseOut:$debox($entry(function(){
                        var param = {};
                        var event = @com.smartgwt.client.widgets.drawing.events.MouseOutEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.core.BaseClass::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                        var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                        return !ret;
                    }))
                });
            } else {
                obj = this.@com.smartgwt.client.core.BaseClass::getConfig()();
                obj.mouseOut = $debox($entry(function(){
                    var param = {};
                    var event = @com.smartgwt.client.widgets.drawing.events.MouseOutEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    selfJ.@com.smartgwt.client.core.BaseClass::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                    return !ret;
                }));
            }
   }-*/;
    /**
     * Add a mouseOver handler.
     * <p>
     * Executed when mouse enters this widget.  No default implementation.
     *
     * @param handler the mouseOver handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addMouseOverHandler(com.smartgwt.client.widgets.drawing.events.MouseOverHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.drawing.events.MouseOverEvent.getType()) == 0) setupMouseOverEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.drawing.events.MouseOverEvent.getType());
    }

    private native void setupMouseOverEvent() /*-{
        var obj = null;
        var selfJ = this;
            if(this.@com.smartgwt.client.core.BaseClass::isCreated()()) {
                obj = this.@com.smartgwt.client.core.BaseClass::getJsObj()();
                obj.addProperties({mouseOver:$debox($entry(function(){
                        var param = {};
                        var event = @com.smartgwt.client.widgets.drawing.events.MouseOverEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.core.BaseClass::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                        var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                        return !ret;
                    }))
                });
            } else {
                obj = this.@com.smartgwt.client.core.BaseClass::getConfig()();
                obj.mouseOver = $debox($entry(function(){
                    var param = {};
                    var event = @com.smartgwt.client.widgets.drawing.events.MouseOverEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    selfJ.@com.smartgwt.client.core.BaseClass::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                    return !ret;
                }));
            }
   }-*/;
    /**
     * Add a mouseUp handler.
     * <p>
     * Executed when the left mouse is released on this widget.  No default implementation.
     *
     * @param handler the mouseUp handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addMouseUpHandler(com.smartgwt.client.widgets.drawing.events.MouseUpHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.drawing.events.MouseUpEvent.getType()) == 0) setupMouseUpEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.drawing.events.MouseUpEvent.getType());
    }

    private native void setupMouseUpEvent() /*-{
        var obj = null;
        var selfJ = this;
            if(this.@com.smartgwt.client.core.BaseClass::isCreated()()) {
                obj = this.@com.smartgwt.client.core.BaseClass::getJsObj()();
                obj.addProperties({mouseUp:$debox($entry(function(){
                        var param = {};
                        var event = @com.smartgwt.client.widgets.drawing.events.MouseUpEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.core.BaseClass::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                        var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                        return !ret;
                    }))
                });
            } else {
                obj = this.@com.smartgwt.client.core.BaseClass::getConfig()();
                obj.mouseUp = $debox($entry(function(){
                    var param = {};
                    var event = @com.smartgwt.client.widgets.drawing.events.MouseUpEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    selfJ.@com.smartgwt.client.core.BaseClass::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                    return !ret;
                }));
            }
   }-*/;
            
    /**
     * Move the shape by the specified deltas for the left and top coordinate.
     * @param dX change to left coordinate in pixels
     * @param dY change to top coordinate in pixels
     */
    public native void moveBy(int dX, int dY) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.moveBy(dX, dY);
    }-*/;
            
    /**
     * Resize the shape by the specified deltas for the left and top coordinate.
     * @param dX change to left coordinate in pixels
     * @param dY change to top coordinate in pixels
     */
    public native void resizeBy(int dX, int dY) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.resizeBy(dX, dY);
    }-*/;
            
    /**
     * Rotate the shape by the relative rotation in degrees
     * @param degrees number of degrees to rotate from current orientation.
     */
    public native void rotateBy(float degrees) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.rotateBy(degrees);
    }-*/;
            
    /**
     * Rotate the shape by the absolute rotation in degrees
     * @param degrees number of degrees to rotate
     */
    public native void rotateTo(float degrees) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.rotateTo(degrees);
    }-*/;
            
    /**
     * Scale the shape by the x, y multipliers
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
            
    /**
     * Make this drawItem visible.
     */
    public native void show() /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.show();
    }-*/;

    // ********************* Static Methods ***********************
        
    // ***********************************************************        



    public static DrawItem[] convertToDrawItemArray(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new DrawItem[]{};
        }
        JavaScriptObject[] componentsj = JSOHelper.toArray(nativeArray);
        DrawItem[] objects = new DrawItem[componentsj.length];
        for (int i = 0; i < componentsj.length; i++) {
            JavaScriptObject componentJS = componentsj[i];
            DrawItem obj = (DrawItem) getRef(componentJS);
            if (obj == null) obj = new DrawItem(componentJS);
            objects[i] = obj;
        }
        return objects;
    }

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
     * Returns the startPoint endPoint
     *
     * @return x1, y1, x2, y2 coordinates
     */
    public native int[] getBoundingBox() /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var selection = self.getBoundingBox();
        return selection == null || selection === undefined ? null : @com.smartgwt.client.util.JSOHelper::convertToJavaIntArray(Lcom/google/gwt/core/client/JavaScriptObject;)(selection);
    }-*/;

    public static DrawItem getRef(JavaScriptObject jsObj) {

        if (jsObj == null) {
            return null;
        } else {
            Object ref = JSOHelper.getAttributeAsObject((JavaScriptObject) jsObj, SC.REF);
            if (ref != null && !(ref instanceof DrawItem)) {
                return null;
            } else {
                return (DrawItem) ref;
            }
        }
    }

    protected native String[] getAttributeAsStringArray(String property)/*-{
        var ret;
        if(this.@com.smartgwt.client.core.BaseClass::isCreated()()) {
            var widget = this.@com.smartgwt.client.core.BaseClass::getJsObj()();
            ret = widget.getProperty(property);
        } else {
            var config = this.@com.smartgwt.client.core.BaseClass::config;
            if(config[property] != undefined) {
                ret = config[property];
            } else {
               var scClassName = this.@com.smartgwt.client.core.BaseClass::scClassName;
               ret = $wnd.isc[scClassName].getInstanceProperty(property);
            }
        }
        return ret === undefined ? null : @com.smartgwt.client.util.JSOHelper::convertToJavaStringArray(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

    protected native int[] getAttributeAsIntArray(String property)/*-{
        var ret;
        if(this.@com.smartgwt.client.core.BaseClass::isCreated()()) {
            var widget = this.@com.smartgwt.client.core.BaseClass::getJsObj()();
            ret = widget.getProperty(property);
        } else {
            var config = this.@com.smartgwt.client.core.BaseClass::config;
            if(config[property] != undefined) {
                ret = config[property];
            } else {
               var scClassName = this.@com.smartgwt.client.core.BaseClass::scClassName;
               ret = $wnd.isc[scClassName].getInstanceProperty(property);
            }
        }
        return ret === undefined ? null : @com.smartgwt.client.util.JSOHelper::convertToJavaIntArray(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;
    
    /**
     * Hides a set of control knobs for this drawItem. Updates {@link com.smartgwt.client.widgets.drawing.DrawItem#getKnobs
     * knobs} to remove the specified knobType, and clears any drawn knobs for this knobType.
     * @param knobType knobs to hide
     */
    public native void hideKnobs(KnobType... knobType) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.hideKnobs(@com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(knobType));
    }-*/;

    /**
     * Shows a set of control knobs for this drawItem. Updates {@link com.smartgwt.client.widgets.drawing.DrawItem#getKnobs
     * knobs} to include the specified knobType, and if necessary draws out the appropriate control knobs.
     * @param knobType knobs to show
     */
    public native void showKnobs(KnobType... knobType) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.showKnobs(@com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(knobType));
    }-*/;

    /**
     * If this item is showing <code>"resize"</code> {@link com.smartgwt.client.widgets.drawing.DrawItem#getKnobs control
     * knobs}, this attribute
     *  specifies which sides / edges should show knobs. May include any of the following values:
     *  <pre>
     *   <code>"TL"</code> Top Left corner
     *   <code>"TR"</code> Top Right corner
     *   <code>"BL"</code> Bottom Left corner
     *   <code>"BR"</code> Bottom Right corner
     *  </pre>
     *
     * @param resizeKnobPoints resizeKnobPoints Default value is ["TL","TR","BL","BR"]
     */
    public void setResizeKnobPoints(String[] resizeKnobPoints) {
        setAttribute("resizeKnobPoints", resizeKnobPoints, true);
    }

    /**
     * If this item is showing <code>"resize"</code> {@link com.smartgwt.client.widgets.drawing.DrawItem#getKnobs control
     * knobs}, this attribute
     *  specifies which sides / edges should show knobs. May include any of the following values:
     *  <pre>
     *   <code>"TL"</code> Top Left corner
     *   <code>"TR"</code> Top Right corner
     *   <code>"BL"</code> Bottom Left corner
     *   <code>"BR"</code> Bottom Right corner
     *  </pre>
     *
     *
     * @return Unhandled-array
     */
    public String[] getResizeKnobPoints()  {
        return getAttributeAsStringArray("resizeKnobPoints");
    }

    /**
     * Array holds 2 values representing scaling along x and y dimensions.
     *
     * @param scale scale Default value is null
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setScale(int[] scale)  throws IllegalStateException {
        setAttribute("scale", scale, false);
    }

    /**
     * Array holds 2 values representing scaling along x and y dimensions.
     *
     *
     * @return Unhandled-Array
     */
    public int[] getScale()  {
        return getAttributeAsIntArray("scale");
    }

    /**
     * Array holds 2 values representing the x and y offset from moveKnobPoint.
     *
     * @param scale scale Default value is null
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setMoveKnobOffset(int[] offset)  throws IllegalStateException {
        setAttribute("moveKnobOffset", offset, false);
    }

    /**
     * Array holds 2 values representing the x and y offset from moveKnobPoint.
     *
     *
     * @return Unhandled-Array
     */
    public int[] getMoveKnobOffset()  {
        return getAttributeAsIntArray("moveKnobOffset");
    }

    /**
     * Fill gradient to use for shapes.  If a string it uses the gradient identifier parameter provided in  {@link
     * com.smartgwt.client.widgets.drawing.DrawPane#createSimpleGradient drawPane.createSimpleGradient},  {@link
     * com.smartgwt.client.widgets.drawing.DrawPane#createRadialGradient drawPane.createRadialGradient} or  {@link
     * com.smartgwt.client.widgets.drawing.DrawPane#createLinearGradient drawPane.createLinearGradient}. Otherwise  it expects
     * one of {@link com.smartgwt.client.widgets.drawing.SimpleGradient SimpleGradient}, {@link
     * com.smartgwt.client.widgets.drawing.LinearGradient LinearGradient} or  {@link
     * com.smartgwt.client.widgets.drawing.RadialGradient RadialGradient}.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Update fillGradient for this drawItem.
     *
     * @param fillGradient new gradient to use.  Pass null for transparent.. Default value is null
     * @see com.smartgwt.client.widgets.drawing.Gradient
     */
    public void setFillGradient(Gradient fillGradient) {
        setAttribute("fillGradient", fillGradient.getJsObj(), true);
    }

    /**
     * Fill gradient to use for shapes.  If a string it uses the gradient identifier parameter provided in  {@link
     * com.smartgwt.client.widgets.drawing.DrawPane#createSimpleGradient drawPane.createSimpleGradient},  {@link
     * com.smartgwt.client.widgets.drawing.DrawPane#createRadialGradient drawPane.createRadialGradient} or  {@link
     * com.smartgwt.client.widgets.drawing.DrawPane#createLinearGradient drawPane.createLinearGradient}. Otherwise  it expects
     * one of {@link com.smartgwt.client.widgets.drawing.SimpleGradient SimpleGradient}, {@link
     * com.smartgwt.client.widgets.drawing.LinearGradient LinearGradient} or  {@link
     * com.smartgwt.client.widgets.drawing.RadialGradient RadialGradient}.
     *
     *
     * @return Gradient
     * @see com.smartgwt.client.widgets.drawing.Gradient
     */
    public Gradient getFillGradient()  {
        return new Gradient(getAttributeAsJavaScriptObject("fillGradient"));
    }

}



