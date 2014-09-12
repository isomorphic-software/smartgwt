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
 * Base class for graphical elements drawn in a DrawPane.  All properties and methods documented here are available on all
 * DrawItems unless otherwise specified.   <P> Note that DrawItems as such should never be created, only concrete
 * subclasses such as {@link com.smartgwt.client.widgets.drawing.DrawGroup} and {@link
 * com.smartgwt.client.widgets.drawing.DrawLine}. <P> See {@link com.smartgwt.client.widgets.drawing.DrawPane} for the
 * different approaches to create DrawItems.
 */
@BeanFactory.FrameworkClass
@BeanFactory.ScClassName("DrawItem")
public class DrawItem extends BaseClass implements com.smartgwt.client.widgets.drawing.events.HasClickHandlers, com.smartgwt.client.widgets.drawing.events.HasMouseDownHandlers, com.smartgwt.client.widgets.drawing.events.HasMouseMoveHandlers, com.smartgwt.client.widgets.drawing.events.HasMouseOutHandlers, com.smartgwt.client.widgets.drawing.events.HasMouseOverHandlers, com.smartgwt.client.widgets.drawing.events.HasMouseUpHandlers, com.smartgwt.client.widgets.drawing.events.HasMovedHandlers, com.smartgwt.client.widgets.drawing.events.HasDragMoveHandlers, com.smartgwt.client.widgets.drawing.events.HasDragResizeMoveHandlers, com.smartgwt.client.widgets.drawing.events.HasDragResizeStartHandlers, com.smartgwt.client.widgets.drawing.events.HasDragResizeStopHandlers, com.smartgwt.client.widgets.drawing.events.HasDragStartHandlers, com.smartgwt.client.widgets.drawing.events.HasDragStopHandlers, com.smartgwt.client.widgets.drawing.events.HasResizedHandlers, com.smartgwt.client.widgets.drawing.events.HasShowContextMenuHandlers {

    public static DrawItem getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        BaseClass obj = BaseClass.getRef(jsObj);
        if(obj != null) {
            return (DrawItem) obj;
        } else {
            return new DrawItem(jsObj);
        }
    }


    /**
     * Changes the defaults for Canvas AutoChildren named <code>autoChildName</code>.
     *
     * @param autoChildName name of an AutoChild to customize the defaults for.
     * @param defaults Canvas defaults to apply. These defaults override any existing properties
     * without destroying or wiping out non-overridden properties.
     * @see com.smartgwt.client.docs.AutoChildUsage
     */
    public static native void changeAutoChildDefaults(String autoChildName, Canvas defaults) /*-{
        $wnd.isc.DrawItem.changeDefaults(autoChildName + "Defaults", defaults.@com.smartgwt.client.widgets.Canvas::getConfig()());
    }-*/;

    /**
     * Changes the defaults for FormItem AutoChildren named <code>autoChildName</code>.
     *
     * @param autoChildName name of an AutoChild to customize the defaults for.
     * @param defaults FormItem defaults to apply. These defaults override any existing properties
     * without destroying or wiping out non-overridden properties.
     * @see com.smartgwt.client.docs.AutoChildUsage
     */
    public static native void changeAutoChildDefaults(String autoChildName, FormItem defaults) /*-{
        $wnd.isc.DrawItem.changeDefaults(autoChildName + "Defaults", defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getJsObj()());
    }-*/;
    /**
     * Changes the defaults for DrawItem AutoChildren named <code>autoChildName</code>.
     *
     * @param autoChildName name of an AutoChild to customize the defaults for.
     * @param defaults DrawItem defaults to apply. These defaults override any existing properties
     * without destroying or wiping out non-overridden properties.
     * @see com.smartgwt.client.docs.AutoChildUsage
     */
    public static native void changeAutoChildDefaults(String autoChildName, DrawItem defaults) /*-{
        $wnd.isc.DrawItem.changeDefaults(autoChildName + "Defaults", defaults.@com.smartgwt.client.widgets.drawing.DrawItem::getJsObj()());
    }-*/;

    public DrawItem(){
        scClassName = "DrawItem";
    }

    public DrawItem(JavaScriptObject jsObj){
        scClassName = "DrawItem";
        setJavaScriptObject(jsObj);
    }

    public native JavaScriptObject create()/*-{
        var config = this.@com.smartgwt.client.core.BaseClass::getConfig()();
        var scClassName = this.@com.smartgwt.client.core.BaseClass::scClassName;
        return $wnd.isc[scClassName].create(config);
    }-*/;

    // ********************* Properties / Attributes ***********************

    /**
     * Is this DrawItem draggable? If true, then the DrawItem can be drag-repositioned by the user.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Setter for {@link com.smartgwt.client.widgets.drawing.DrawItem#getCanDrag canDrag}.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param canDrag new value for <code>this.canDrag</code>.. Default value is false
     */
    public void setCanDrag(Boolean canDrag) {
        setAttribute("canDrag", canDrag, true);
    }

    /**
     * Is this DrawItem draggable? If true, then the DrawItem can be drag-repositioned by the user.
     *
     * @return Boolean
     */
    public Boolean getCanDrag()  {
        Boolean result = getAttributeAsBoolean("canDrag");
        return result == null ? false : result;
    }
    

    /**
     * Will this DrawItem fire hover events when the user hovers over it?
     *
     * @param canHover  Default value is null
     * @see com.smartgwt.client.widgets.drawing.DrawItem#setShowHover
     */
    public void setCanHover(Boolean canHover) {
        setAttribute("canHover", canHover, true);
    }

    /**
     * Will this DrawItem fire hover events when the user hovers over it?
     *
     * @return Boolean
     * @see com.smartgwt.client.widgets.drawing.DrawItem#getShowHover
     */
    public Boolean getCanHover()  {
        return getAttributeAsBoolean("canHover");
    }
    

    /**
     * Context menu to show for this object, an instance of the Menu widget. <P> Note: if {@link
     * com.smartgwt.client.widgets.Canvas#destroy Canvas.destroy} is called on a canvas, any specified context menu is not
     * automatically destroyed as well. This is in contrast to {@link com.smartgwt.client.widgets.menu.MenuButton}s which
     * automatically destroy their specified {@link com.smartgwt.client.widgets.menu.MenuButton#getMenu menu} by default. The
     * behavior is intentional as context menus are commonly reused across components.
     *
     * @param contextMenu  Default value is null
     * @see com.smartgwt.client.widgets.events.ShowContextMenuEvent
     * @see com.smartgwt.client.docs.Cues Cues overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#basics_interaction_contextmenu" target="examples">Context menus Example</a>
     */
    public void setContextMenu(Menu contextMenu) {
        setAttribute("contextMenu", contextMenu == null ? null : contextMenu.getOrCreateJsObj(), true);
    }

    /**
     * Context menu to show for this object, an instance of the Menu widget. <P> Note: if {@link
     * com.smartgwt.client.widgets.Canvas#destroy Canvas.destroy} is called on a canvas, any specified context menu is not
     * automatically destroyed as well. This is in contrast to {@link com.smartgwt.client.widgets.menu.MenuButton}s which
     * automatically destroy their specified {@link com.smartgwt.client.widgets.menu.MenuButton#getMenu menu} by default. The
     * behavior is intentional as context menus are commonly reused across components.
     *
     * @return Menu
     * @see com.smartgwt.client.widgets.events.ShowContextMenuEvent
     * @see com.smartgwt.client.docs.Cues Cues overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#basics_interaction_contextmenu" target="examples">Context menus Example</a>
     */
    public Menu getContextMenu()  {
        return (Menu)Menu.getByJSObject(getAttributeAsJavaScriptObject("contextMenu"));
    }
    

    /**
     * <b>Note :</b> This API is non-functional (always returns null) and exists only to make
     * you aware that this MultiAutoChild exists.  See {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}
     * for details.
     * <p>
     * If this item is showing  {@link com.smartgwt.client.types.KnobType#RESIZE} {@link
     * com.smartgwt.client.widgets.drawing.DrawItem#getKnobs control knobs}, this attribute specifies the MultiAutoChild for
     * the {@link com.smartgwt.client.widgets.drawing.DrawKnob} that allows a user to resize the DrawItem with help of knobs
     * located at corners of a bounding rectangle of current DrawItem. Default shape is red circle.
     *
     * @return null
     */
    public DrawKnob getCornerResizeKnob()  {
        return null;
    }
    

    /**
     * If set, specifies the cursor to display when the mouse pointer is over this DrawItem.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param cursor new cursor.. Default value is null
     */
    public void setCursor(Cursor cursor) {
        setAttribute("cursor", cursor == null ? null : cursor.getValue(), true);
    }

    /**
     * If set, specifies the cursor to display when the mouse pointer is over this DrawItem.
     *
     * @return Cursor
     */
    public Cursor getCursor()  {
        return EnumUtil.getEnum(Cursor.values(), getAttribute("cursor"));
    }
    

    /**
     * Flag indicating a drawItem has been destroyed, similar to {@link com.smartgwt.client.widgets.Canvas#getDestroyed
     * destroyed}.
     * <p>
     * <b>Note :</b> This method should be called only after the underlying component has been created.
     *
     * @return Boolean
     * @throws IllegalStateException if the underlying component has not yet been created.
     */
    public Boolean getDestroyed() throws IllegalStateException {
        errorIfNotCreated("destroyed");
        return getAttributeAsBoolean("destroyed");
    }
    

    /**
     * Flag indicating a drawItem is mid-destruction, similar to {@link com.smartgwt.client.widgets.Canvas#getDestroying
     * destroying}.
     * <p>
     * <b>Note :</b> This method should be called only after the underlying component has been created.
     *
     * @return Boolean
     * @throws IllegalStateException if the underlying component has not yet been created.
     */
    public Boolean getDestroying() throws IllegalStateException {
        errorIfNotCreated("destroying");
        return getAttributeAsBoolean("destroying");
    }
    

    /**
     * Number of pixels the cursor needs to move before the EventHandler starts a drag operation.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param dragStartDistance  Default value is 5
     * @see com.smartgwt.client.docs.Dragdrop Dragdrop overview and related methods
     */
    public void setDragStartDistance(int dragStartDistance) {
        setAttribute("dragStartDistance", dragStartDistance, true);
    }

    /**
     * Number of pixels the cursor needs to move before the EventHandler starts a drag operation.
     *
     * @return int
     * @see com.smartgwt.client.docs.Dragdrop Dragdrop overview and related methods
     */
    public int getDragStartDistance()  {
        return getAttributeAsInt("dragStartDistance");
    }
    

    /**
     * {@link com.smartgwt.client.widgets.drawing.DrawGroup} this drawItem is a member of.
     *
     * @param drawGroup  Default value is null
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setDrawGroup(DrawGroup drawGroup)  throws IllegalStateException {
        setAttribute("drawGroup", drawGroup == null ? null : drawGroup.getOrCreateJsObj(), false);
    }

    /**
     * {@link com.smartgwt.client.widgets.drawing.DrawGroup} this drawItem is a member of.
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
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Setter for {@link com.smartgwt.client.widgets.drawing.DrawItem#getDrawPane drawPane}.
     *
     * @param drawPane new value for <code>this.drawPane</code>.. Default value is null
     */
    public void setDrawPane(DrawPane drawPane) {
        setAttribute("drawPane", drawPane == null ? null : drawPane.getOrCreateJsObj(), true);
    }

    /**
     * {@link com.smartgwt.client.widgets.drawing.DrawPane} this drawItem should draw in. <P> If this item has a {@link
     * com.smartgwt.client.widgets.drawing.DrawGroup}, the drawGroup's drawPane is automatically used.
     *
     * @return DrawPane
     */
    public DrawPane getDrawPane()  {
        return (DrawPane)DrawPane.getByJSObject(getAttributeAsJavaScriptObject("drawPane"));
    }
    

    /**
     * Default class used to construct {@link com.smartgwt.client.tools.EditProxy} for this component when editMode is enabled.
     *
     * @param editProxyConstructor  See {@link com.smartgwt.client.docs.SCClassName SCClassName} . Default value is "DrawItemEditProxy"
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setEditProxyConstructor(String editProxyConstructor)  throws IllegalStateException {
        setAttribute("editProxyConstructor", editProxyConstructor, false);
    }

    /**
     * Default class used to construct {@link com.smartgwt.client.tools.EditProxy} for this component when editMode is enabled.
     *
     * @return  See {@link com.smartgwt.client.docs.SCClassName SCClassName} 
     */
    public String getEditProxyConstructor()  {
        return getAttributeAsString("editProxyConstructor");
    }
    

    /**
     * Style of arrowhead to draw at the end of the line or path.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Set the arrowhead at the end of this path. <p> <b>NOTE:</b> Not all DrawItem classes support arrowheads. You can use {@link com.smartgwt.client.widgets.drawing.DrawItem#supportsEndArrow DrawItem.supportsEndArrow} to dynamically check whether a DrawItem instance supports this method.
     *
     * @param endArrow style of arrow to use. Default value is null
     */
    public void setEndArrow(ArrowStyle endArrow) {
        setAttribute("endArrow", endArrow == null ? null : endArrow.getValue(), true);
    }

    /**
     * Style of arrowhead to draw at the end of the line or path.
     *
     * @return ArrowStyle
     */
    public ArrowStyle getEndArrow()  {
        return EnumUtil.getEnum(ArrowStyle.values(), getAttribute("endArrow"));
    }
    

    /**
     * If this item is showing  {@link com.smartgwt.client.types.KnobType#ENDPOINT} {@link
     * com.smartgwt.client.widgets.drawing.DrawItem#getKnobs control knobs}, this attribute specifies the AutoChild for the
     * {@link com.smartgwt.client.widgets.drawing.DrawKnob} for end point of current drawItem.
     * <p>
     * For an overview of how to use and configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return DrawKnob
     * @throws IllegalStateException if the underlying component has not yet been created.
     */
    public DrawKnob getEndKnob() throws IllegalStateException {
        errorIfNotCreated("endKnob");
        return (DrawKnob)DrawKnob.getByJSObject(getAttributeAsJavaScriptObject("endKnob"));
    }
    

    /**
     * Fill color to use for shapes.  The default of 'null' is transparent.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Update fillColor for this drawItem.
     *
     * @param fillColor new fillColor to use.  Pass null for transparent. See {@link com.smartgwt.client.docs.CSSColor CSSColor} . Default value is null
     */
    public void setFillColor(String fillColor) {
        setAttribute("fillColor", fillColor, true);
    }

    /**
     * Fill color to use for shapes.  The default of 'null' is transparent.
     *
     * @return  See {@link com.smartgwt.client.docs.CSSColor CSSColor} 
     */
    public String getFillColor()  {
        return getAttributeAsString("fillColor");
    }
    

    /**
     * Fill gradient to use for shapes.  If a string it uses the gradient identifier parameter provided in  {@link
     * com.smartgwt.client.widgets.drawing.DrawPane#addGradient DrawPane.addGradient}. Otherwise it expects one of {@link
     * com.smartgwt.client.widgets.drawing.SimpleGradient SimpleGradient}, {@link
     * com.smartgwt.client.widgets.drawing.LinearGradient LinearGradient} or {@link
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
     * com.smartgwt.client.widgets.drawing.DrawPane#addGradient DrawPane.addGradient}. Otherwise it expects one of {@link
     * com.smartgwt.client.widgets.drawing.SimpleGradient SimpleGradient}, {@link
     * com.smartgwt.client.widgets.drawing.LinearGradient LinearGradient} or {@link
     * com.smartgwt.client.widgets.drawing.RadialGradient RadialGradient}.
     *
     * @return Gradient
     * @see com.smartgwt.client.widgets.drawing.Gradient
     */
    public Gradient getFillGradient()  {
        return new Gradient(getAttributeAsJavaScriptObject("fillGradient"));
    }

    /**
     * Fill gradient to use for shapes.  If a string it uses the gradient identifier parameter provided in  {@link
     * com.smartgwt.client.widgets.drawing.DrawPane#addGradient DrawPane.addGradient}. Otherwise it expects one of {@link
     * com.smartgwt.client.widgets.drawing.SimpleGradient SimpleGradient}, {@link
     * com.smartgwt.client.widgets.drawing.LinearGradient LinearGradient} or {@link
     * com.smartgwt.client.widgets.drawing.RadialGradient RadialGradient}.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Update fillGradient for this drawItem.
     *
     * @param fillGradient new gradient to use.  Pass null for transparent.. Default value is null
     * @see com.smartgwt.client.widgets.drawing.Gradient
     */
    public void setFillGradient(String fillGradient) {
        setAttribute("fillGradient", fillGradient, true);
    }

    /**
     * Fill gradient to use for shapes.  If a string it uses the gradient identifier parameter provided in  {@link
     * com.smartgwt.client.widgets.drawing.DrawPane#addGradient DrawPane.addGradient}. Otherwise it expects one of {@link
     * com.smartgwt.client.widgets.drawing.SimpleGradient SimpleGradient}, {@link
     * com.smartgwt.client.widgets.drawing.LinearGradient LinearGradient} or {@link
     * com.smartgwt.client.widgets.drawing.RadialGradient RadialGradient}.
     *
     * @return String
     * @see com.smartgwt.client.widgets.drawing.Gradient
     */
    public String getFillGradientAsString()  {
        return getAttributeAsString("fillGradient");
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
     * @return float
     */
    public float getFillOpacity()  {
        return getAttributeAsFloat("fillOpacity");
    }
    

    /**
     * Constrains drag-resizing and drag-repositioning of this draw item to either the current visible area of the {@link
     * com.smartgwt.client.widgets.drawing.DrawPane draw pane} or an arbitrary bounding box (if set to an array of the form
     * <code>[left, top, left + width, top + height]</code>).  When using a bounding box-type argument the left/top values can
     * be negative, or the width/height values can be greater than the dimensions of the viewable area, to allow positioning or
     * resizing the draw item beyond the confines of the draw pane. <P> Note:  keepInParentRect affects only user drag
     * interactions, not programmatic moves or resizes.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param keepInParentRect  Default value is null
     */
    public void setKeepInParentRect(Boolean keepInParentRect) {
        setAttribute("keepInParentRect", keepInParentRect, true);
    }

    /**
     * Constrains drag-resizing and drag-repositioning of this draw item to either the current visible area of the {@link
     * com.smartgwt.client.widgets.drawing.DrawPane draw pane} or an arbitrary bounding box (if set to an array of the form
     * <code>[left, top, left + width, top + height]</code>).  When using a bounding box-type argument the left/top values can
     * be negative, or the width/height values can be greater than the dimensions of the viewable area, to allow positioning or
     * resizing the draw item beyond the confines of the draw pane. <P> Note:  keepInParentRect affects only user drag
     * interactions, not programmatic moves or resizes.
     *
     * @return Boolean
     */
    public Boolean getKeepInParentRect()  {
        return getAttributeAsBoolean("keepInParentRect");
    }

    /**
     * Constrains drag-resizing and drag-repositioning of this draw item to either the current visible area of the {@link
     * com.smartgwt.client.widgets.drawing.DrawPane draw pane} or an arbitrary bounding box (if set to an array of the form
     * <code>[left, top, left + width, top + height]</code>).  When using a bounding box-type argument the left/top values can
     * be negative, or the width/height values can be greater than the dimensions of the viewable area, to allow positioning or
     * resizing the draw item beyond the confines of the draw pane. <P> Note:  keepInParentRect affects only user drag
     * interactions, not programmatic moves or resizes.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param keepInParentRect  Default value is null
     */
    public void setKeepInParentRect(float... keepInParentRect) {
        setAttribute("keepInParentRect", keepInParentRect, true);
    }
    

    /**
     * Array of control knobs to display for this item. Each {@link com.smartgwt.client.types.KnobType} specified in this array
     * will turn on UI element(s) allowing the user to manipulate this drawItem.  To update the set of knobs at runtime use
     * {@link com.smartgwt.client.widgets.drawing.DrawItem#showKnobs DrawItem.showKnobs} and {@link
     * com.smartgwt.client.widgets.drawing.DrawItem#hideKnobs DrawItem.hideKnobs}. <p> <b>NOTE:</b> Unless otherwise
     * documented, DrawItem types only support  {@link com.smartgwt.client.types.KnobType#RESIZE} and {@link
     * com.smartgwt.client.types.KnobType#MOVE} knobs.
     *
     * @param knobs  Default value is null
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     * @see <a href="http://www.smartclient.com/smartgwtee/showcase/#diagramming" target="examples">Diagramming Example</a>
     * 
     */
    public void setKnobs(KnobType... knobs)  throws IllegalStateException {
        setAttribute("knobs", knobs, false);
    }

    /**
     * Array of control knobs to display for this item. Each {@link com.smartgwt.client.types.KnobType} specified in this array
     * will turn on UI element(s) allowing the user to manipulate this drawItem.  To update the set of knobs at runtime use
     * {@link com.smartgwt.client.widgets.drawing.DrawItem#showKnobs DrawItem.showKnobs} and {@link
     * com.smartgwt.client.widgets.drawing.DrawItem#hideKnobs DrawItem.hideKnobs}. <p> <b>NOTE:</b> Unless otherwise
     * documented, DrawItem types only support  {@link com.smartgwt.client.types.KnobType#RESIZE} and {@link
     * com.smartgwt.client.types.KnobType#MOVE} knobs.
     *
     * @return KnobType...
     * @see <a href="http://www.smartclient.com/smartgwtee/showcase/#diagramming" target="examples">Diagramming Example</a>
     * 
     */
    public KnobType[] getKnobs()  {
        final String[] strings = getAttributeAsStringArray("knobs");
        return EnumUtil.getEnums(KnobType.values(), strings, strings == null ? null : new KnobType[strings.length]);
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
        setAttribute("lineCap", lineCap == null ? null : lineCap.getValue(), true);
    }

    /**
     * Style of drawing the endpoints of a line. <P> Note that for dashed and dotted lines, the lineCap style affects each dash
     * or dot.
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
     * @param lineColor new line color.  Pass null for transparent. See {@link com.smartgwt.client.docs.CSSColor CSSColor} . Default value is "#808080"
     */
    public void setLineColor(String lineColor) {
        setAttribute("lineColor", lineColor, true);
    }

    /**
     * Line color
     *
     * @return  See {@link com.smartgwt.client.docs.CSSColor CSSColor} 
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
        setAttribute("linePattern", linePattern == null ? null : linePattern.getValue(), true);
    }

    /**
     * Pattern for lines, eg "solid" or "dash"
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
     * @return int
     */
    public int getLineWidth()  {
        return getAttributeAsInt("lineWidth");
    }
    

    /**
     * If this item is showing  {@link com.smartgwt.client.types.KnobType#MOVE} {@link
     * com.smartgwt.client.widgets.drawing.DrawItem#getKnobs control knobs}, this attribute specifies the AutoChild for the
     * {@link com.smartgwt.client.widgets.drawing.DrawKnob} that allows a user to move the DrawItem with help of a knob located
     * at {@link com.smartgwt.client.widgets.drawing.DrawItem#getMoveKnobPoint moveKnobPoint}. Default move knob shape is green
     * circle.
     * <p>
     * For an overview of how to use and configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return DrawKnob
     * @throws IllegalStateException if the underlying component has not yet been created.
     */
    public DrawKnob getMoveKnob() throws IllegalStateException {
        errorIfNotCreated("moveKnob");
        return (DrawKnob)DrawKnob.getByJSObject(getAttributeAsJavaScriptObject("moveKnob"));
    }
    

    /**
     * If this item is showing a <code>"move"</code> {@link com.smartgwt.client.widgets.drawing.DrawItem#getKnobs control
     * knob}, this attribute allows you to specify an offset in pixels from the {@link
     * com.smartgwt.client.widgets.drawing.DrawItem#getMoveKnobPoint moveKnobPoint} for the move knob. Offset should be
     * specified as a 2-element array of [left offset, top offset]. <p> This offset overrides the built-in offset used when
     * showing both resize and move knobs.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Setter for {@link com.smartgwt.client.widgets.drawing.DrawItem#getMoveKnobOffset moveKnobOffset}.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param moveKnobOffset the new move knob offset. This is a 2-element array of [left offset, top offset]. If null, then  <code>new int[] {0,
     * 0}</code> is assumed.. Default value is null
     * @see com.smartgwt.client.widgets.drawing.DrawItem#setMoveKnobPoint
     */
    public void setMoveKnobOffset(int[] moveKnobOffset) {
        setAttribute("moveKnobOffset", moveKnobOffset, true);
    }

    /**
     * If this item is showing a <code>"move"</code> {@link com.smartgwt.client.widgets.drawing.DrawItem#getKnobs control
     * knob}, this attribute allows you to specify an offset in pixels from the {@link
     * com.smartgwt.client.widgets.drawing.DrawItem#getMoveKnobPoint moveKnobPoint} for the move knob. Offset should be
     * specified as a 2-element array of [left offset, top offset]. <p> This offset overrides the built-in offset used when
     * showing both resize and move knobs.
     *
     * @return int[]
     * @see com.smartgwt.client.widgets.drawing.DrawItem#getMoveKnobPoint
     */
    public int[] getMoveKnobOffset()  {
        return com.smartgwt.client.util.ConvertTo.arrayOfint(getAttributeAsJavaScriptObject("moveKnobOffset"));
    }
    

    /**
     * If this item is showing a  {@link com.smartgwt.client.types.KnobType#MOVE} {@link
     * com.smartgwt.client.widgets.drawing.DrawItem#getKnobs control knob}, this attribute specifies where the knob should
     * appear with respect to the draw item. <p> The resize and move knobs show at the same position by default. However, when
     * both knobs are shown the move knob is offset slightly to allow access to both. This position can be adjusted manually
     * with {@link com.smartgwt.client.widgets.drawing.DrawItem#getMoveKnobOffset moveKnobOffset}.
     *
     * @param moveKnobPoint  Default value is "TL"
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     * @see com.smartgwt.client.widgets.drawing.DrawItem#setMoveKnobOffset
     */
    public void setMoveKnobPoint(MoveKnobPoint moveKnobPoint)  throws IllegalStateException {
        setAttribute("moveKnobPoint", moveKnobPoint == null ? null : moveKnobPoint.getValue(), false);
    }

    /**
     * If this item is showing a  {@link com.smartgwt.client.types.KnobType#MOVE} {@link
     * com.smartgwt.client.widgets.drawing.DrawItem#getKnobs control knob}, this attribute specifies where the knob should
     * appear with respect to the draw item. <p> The resize and move knobs show at the same position by default. However, when
     * both knobs are shown the move knob is offset slightly to allow access to both. This position can be adjusted manually
     * with {@link com.smartgwt.client.widgets.drawing.DrawItem#getMoveKnobOffset moveKnobOffset}.
     *
     * @return MoveKnobPoint
     * @see com.smartgwt.client.widgets.drawing.DrawItem#getMoveKnobOffset
     */
    public MoveKnobPoint getMoveKnobPoint()  {
        return EnumUtil.getEnum(MoveKnobPoint.values(), getAttribute("moveKnobPoint"));
    }
    

    /**
     * Default {@link com.smartgwt.client.widgets.drawing.DrawItem#getHoverHTML hover HTML} that is displayed in the global
     * hover canvas if the user hovers over this DrawItem and {@link com.smartgwt.client.widgets.drawing.DrawItem#getShowHover
     * showHover} is true.
     *
     * @param prompt  See {@link com.smartgwt.client.docs.HTMLString HTMLString} . Default value is null
     */
    public void setPrompt(String prompt) {
        setAttribute("prompt", prompt, true);
    }

    /**
     * Default {@link com.smartgwt.client.widgets.drawing.DrawItem#getHoverHTML hover HTML} that is displayed in the global
     * hover canvas if the user hovers over this DrawItem and {@link com.smartgwt.client.widgets.drawing.DrawItem#getShowHover
     * showHover} is true.
     *
     * @return  See {@link com.smartgwt.client.docs.HTMLString HTMLString} 
     */
    public String getPrompt()  {
        return getAttributeAsString("prompt");
    }
    
    

    /**
     * This property specifies the conditions for when proportional resizing is used. <p> By default the DrawItem is forced to
     * only resize proportionally while any modifier key specified in {@link
     * com.smartgwt.client.widgets.drawing.DrawItem#getProportionalResizeModifiers proportionalResizeModifiers} is pressed. 
     * For example, the DrawItem will change its width and height by the same percentage as long as the "Shift" key is held
     * down. <p> Note that this property only has an effect if the DrawItem is showing  {@link
     * com.smartgwt.client.types.KnobType#RESIZE} {@link com.smartgwt.client.widgets.drawing.DrawItem#getKnobs control knobs}.
     *
     * @param proportionalResizing  Default value is "modifier"
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setProportionalResizing(ProportionalResizeMode proportionalResizing)  throws IllegalStateException {
        setAttribute("proportionalResizing", proportionalResizing == null ? null : proportionalResizing.getValue(), false);
    }

    /**
     * This property specifies the conditions for when proportional resizing is used. <p> By default the DrawItem is forced to
     * only resize proportionally while any modifier key specified in {@link
     * com.smartgwt.client.widgets.drawing.DrawItem#getProportionalResizeModifiers proportionalResizeModifiers} is pressed. 
     * For example, the DrawItem will change its width and height by the same percentage as long as the "Shift" key is held
     * down. <p> Note that this property only has an effect if the DrawItem is showing  {@link
     * com.smartgwt.client.types.KnobType#RESIZE} {@link com.smartgwt.client.widgets.drawing.DrawItem#getKnobs control knobs}.
     *
     * @return ProportionalResizeMode
     */
    public ProportionalResizeMode getProportionalResizing()  {
        return EnumUtil.getEnum(ProportionalResizeMode.values(), getAttribute("proportionalResizing"));
    }
    

    /**
     * If this item is showing  {@link com.smartgwt.client.types.KnobType#RESIZE} {@link
     * com.smartgwt.client.widgets.drawing.DrawItem#getKnobs control knobs}, this attribute specifies the points with respect
     * to the draw item where resize knobs should appear.
     *
     * @param resizeKnobPoints  Default value is ["TL","TR","BL","BR","T","R","B","L"]
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setResizeKnobPoints(ResizeKnobPoint... resizeKnobPoints)  throws IllegalStateException {
        setAttribute("resizeKnobPoints", resizeKnobPoints, false);
    }

    /**
     * If this item is showing  {@link com.smartgwt.client.types.KnobType#RESIZE} {@link
     * com.smartgwt.client.widgets.drawing.DrawItem#getKnobs control knobs}, this attribute specifies the points with respect
     * to the draw item where resize knobs should appear.
     *
     * @return ResizeKnobPoint...
     */
    public ResizeKnobPoint[] getResizeKnobPoints()  {
        final String[] strings = getAttributeAsStringArray("resizeKnobPoints");
        return EnumUtil.getEnums(ResizeKnobPoint.values(), strings, strings == null ? null : new ResizeKnobPoint[strings.length]);
    }
    

    /**
     * If this item is showing  {@link com.smartgwt.client.types.KnobType#RESIZE} {@link
     * com.smartgwt.client.widgets.drawing.DrawItem#getKnobs control knobs}, this attribute specifies the AutoChild for the
     * {@link com.smartgwt.client.widgets.drawing.DrawRect} that draws a rectangle frame which connects all resize knobs of
     * current DrawItem.
     * <p>
     * For an overview of how to use and configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return DrawRect
     * @throws IllegalStateException if the underlying component has not yet been created.
     */
    public DrawRect getResizeOutline() throws IllegalStateException {
        errorIfNotCreated("resizeOutline");
        return DrawRect.getOrCreateRef(getAttributeAsJavaScriptObject("resizeOutline"));
    }
    

    /**
     * If this DrawItem is showing  {@link com.smartgwt.client.types.KnobType#RESIZE} {@link
     * com.smartgwt.client.widgets.drawing.DrawItem#getKnobs control knobs}, should resizing the shape solely update the local
     * transform (for example, the DrawItem's {@link com.smartgwt.client.widgets.drawing.DrawItem#getScale scale} or {@link
     * com.smartgwt.client.widgets.drawing.DrawItem#getTranslate translation})?. <p> The default is <code>false</code>, which
     * means that the DrawItem is allowed to modify its shape properties in order to fit within a given width and height.  Some
     * examples: <ul> <li>A {@link com.smartgwt.client.widgets.drawing.DrawOval DrawOval} might decrease its {@link
     * com.smartgwt.client.widgets.drawing.DrawOval#getRadius radius} when resized to a smaller size.</li> <li>A {@link
     * com.smartgwt.client.widgets.drawing.DrawPath DrawPath} might change its {@link
     * com.smartgwt.client.widgets.drawing.DrawPath#getPoints points} to lengthen all line segments in the path by some
     * proportion so that it fits into a larger size.</li> </ul> This approach allows a DrawItem to maintain the same {@link
     * com.smartgwt.client.widgets.drawing.DrawItem#getLineWidth line width} even as it is being resized. <p> If this property
     * is set to <code>true</code> then all visual aspects of the DrawItem, including the line width and the fill, will be
     * magnified or reduced during resizes as if the DrawItem were placed under a lens.
     *
     * @param resizeViaLocalTransformOnly  Default value is false
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setResizeViaLocalTransformOnly(boolean resizeViaLocalTransformOnly)  throws IllegalStateException {
        setAttribute("resizeViaLocalTransformOnly", resizeViaLocalTransformOnly, false);
    }

    /**
     * If this DrawItem is showing  {@link com.smartgwt.client.types.KnobType#RESIZE} {@link
     * com.smartgwt.client.widgets.drawing.DrawItem#getKnobs control knobs}, should resizing the shape solely update the local
     * transform (for example, the DrawItem's {@link com.smartgwt.client.widgets.drawing.DrawItem#getScale scale} or {@link
     * com.smartgwt.client.widgets.drawing.DrawItem#getTranslate translation})?. <p> The default is <code>false</code>, which
     * means that the DrawItem is allowed to modify its shape properties in order to fit within a given width and height.  Some
     * examples: <ul> <li>A {@link com.smartgwt.client.widgets.drawing.DrawOval DrawOval} might decrease its {@link
     * com.smartgwt.client.widgets.drawing.DrawOval#getRadius radius} when resized to a smaller size.</li> <li>A {@link
     * com.smartgwt.client.widgets.drawing.DrawPath DrawPath} might change its {@link
     * com.smartgwt.client.widgets.drawing.DrawPath#getPoints points} to lengthen all line segments in the path by some
     * proportion so that it fits into a larger size.</li> </ul> This approach allows a DrawItem to maintain the same {@link
     * com.smartgwt.client.widgets.drawing.DrawItem#getLineWidth line width} even as it is being resized. <p> If this property
     * is set to <code>true</code> then all visual aspects of the DrawItem, including the line width and the fill, will be
     * magnified or reduced during resizes as if the DrawItem were placed under a lens.
     *
     * @return boolean
     */
    public boolean getResizeViaLocalTransformOnly()  {
        Boolean result = getAttributeAsBoolean("resizeViaLocalTransformOnly");
        return result == null ? false : result;
    }
    

    /**
     * Rotation in degrees about the {@link com.smartgwt.client.widgets.drawing.DrawItem#getCenter center point}. The positive
     * direction is clockwise.
     *
     * @param rotation  Default value is 0.0
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     * @deprecated  {@link com.smartgwt.client.docs.GwtFloatVsDouble GwtFloatVsDouble}
     */
    public void setRotation(float rotation)  throws IllegalStateException {
        setAttribute("rotation", rotation, false);
    }

    /**
     * Rotation in degrees about the {@link com.smartgwt.client.widgets.drawing.DrawItem#getCenter center point}. The positive
     * direction is clockwise.
     *
     * @return float
     * @deprecated  {@link com.smartgwt.client.docs.GwtFloatVsDouble GwtFloatVsDouble}
     */
    public float getRotation()  {
        return getAttributeAsFloat("rotation");
    }

    /**
     * Rotation in degrees about the {@link com.smartgwt.client.widgets.drawing.DrawItem#getCenter center point}. The positive
     * direction is clockwise.
     *
     * @param rotation  Default value is 0.0
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setRotation(double rotation)  throws IllegalStateException {
        setAttribute("rotation", rotation, false);
    }

    /**
     * Rotation in degrees about the {@link com.smartgwt.client.widgets.drawing.DrawItem#getCenter center point}. The positive
     * direction is clockwise.
     *
     * @return double
     */
    public double getRotationAsDouble()  {
        return getAttributeAsDouble("rotation");
    }
    

    /**
     * Array holds 2 values representing scaling along x and y dimensions.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param scale  Default value is null
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setScale(int[] scale)  throws IllegalStateException {
        setAttribute("scale", scale, false);
    }

    /**
     * Array holds 2 values representing scaling along x and y dimensions.
     *
     * @return int[]
     */
    public int[] getScale()  {
        return com.smartgwt.client.util.ConvertTo.arrayOfint(getAttributeAsJavaScriptObject("scale"));
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
     * @return Shadow
     */
    public Shadow getShadow()  {
        return new Shadow(getAttributeAsJavaScriptObject("shadow"));
    }
    

    /**
     * If {@link com.smartgwt.client.widgets.drawing.DrawItem#getCanHover canHover} is true, should we show the global hover
     * canvas by default when the user hovers over this DrawItem?
     *
     * @param showHover  Default value is true
     * @see com.smartgwt.client.widgets.drawing.DrawItem#getHoverHTML
     */
    public void setShowHover(boolean showHover) {
        setAttribute("showHover", showHover, true);
    }

    /**
     * If {@link com.smartgwt.client.widgets.drawing.DrawItem#getCanHover canHover} is true, should we show the global hover
     * canvas by default when the user hovers over this DrawItem?
     *
     * @return boolean
     * @see com.smartgwt.client.widgets.drawing.DrawItem#getHoverHTML
     */
    public boolean getShowHover()  {
        Boolean result = getAttributeAsBoolean("showHover");
        return result == null ? true : result;
    }
    

    /**
     * If this item is showing  {@link com.smartgwt.client.types.KnobType#RESIZE} {@link
     * com.smartgwt.client.widgets.drawing.DrawItem#getKnobs control knobs} will the resize outline be shown or not.
     *
     * @param showResizeOutline  Default value is true
     * @see com.smartgwt.client.widgets.drawing.DrawItem#setResizeOutline
     */
    public void setShowResizeOutline(boolean showResizeOutline) {
        setAttribute("showResizeOutline", showResizeOutline, true);
    }

    /**
     * If this item is showing  {@link com.smartgwt.client.types.KnobType#RESIZE} {@link
     * com.smartgwt.client.widgets.drawing.DrawItem#getKnobs control knobs} will the resize outline be shown or not.
     *
     * @return boolean
     * @see com.smartgwt.client.widgets.drawing.DrawItem#getResizeOutline
     */
    public boolean getShowResizeOutline()  {
        Boolean result = getAttributeAsBoolean("showResizeOutline");
        return result == null ? true : result;
    }
    

    /**
     * <b>Note :</b> This API is non-functional (always returns null) and exists only to make
     * you aware that this MultiAutoChild exists.  See {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}
     * for details.
     * <p>
     * If this item is showing  {@link com.smartgwt.client.types.KnobType#RESIZE} {@link
     * com.smartgwt.client.widgets.drawing.DrawItem#getKnobs control knobs}, this attribute specifies the MultiAutoChild for
     * the {@link com.smartgwt.client.widgets.drawing.DrawKnob} that allows a user to resize the DrawItem with help of knobs
     * located at centers of edges of a bounding rectangle of current DrawItem. Default shape is red square.
     *
     * @return null
     */
    public DrawKnob getSideResizeKnob()  {
        return null;
    }
    

    /**
     * Style of arrowhead to draw at the beginning of the line or path.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Set the arrowhead at the beginning of this path. <p> <b>NOTE:</b> Not all DrawItem classes support arrowheads. You can use {@link com.smartgwt.client.widgets.drawing.DrawItem#supportsStartArrow DrawItem.supportsStartArrow} to dynamically check whether a DrawItem instance supports this method.
     *
     * @param startArrow style of arrow to use. Default value is null
     */
    public void setStartArrow(ArrowStyle startArrow) {
        setAttribute("startArrow", startArrow == null ? null : startArrow.getValue(), true);
    }

    /**
     * Style of arrowhead to draw at the beginning of the line or path.
     *
     * @return ArrowStyle
     */
    public ArrowStyle getStartArrow()  {
        return EnumUtil.getEnum(ArrowStyle.values(), getAttribute("startArrow"));
    }
    

    /**
     * If this item is showing  {@link com.smartgwt.client.types.KnobType#STARTPOINT} {@link
     * com.smartgwt.client.widgets.drawing.DrawItem#getKnobs control knobs}, this attribute specifies the AutoChild for the
     * {@link com.smartgwt.client.widgets.drawing.DrawKnob} for start point of current drawItem.
     * <p>
     * For an overview of how to use and configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return DrawKnob
     * @throws IllegalStateException if the underlying component has not yet been created.
     */
    public DrawKnob getStartKnob() throws IllegalStateException {
        errorIfNotCreated("startKnob");
        return (DrawKnob)DrawKnob.getByJSObject(getAttributeAsJavaScriptObject("startKnob"));
    }
    

    /**
     * Array holds two values representing translation along the x and y dimensions.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param translate  Default value is null
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setTranslate(int[] translate)  throws IllegalStateException {
        setAttribute("translate", translate, false);
    }

    /**
     * Array holds two values representing translation along the x and y dimensions.
     *
     * @return int[]
     */
    public int[] getTranslate()  {
        return com.smartgwt.client.util.ConvertTo.arrayOfint(getAttributeAsJavaScriptObject("translate"));
    }
    

    /**
     * The slope of an x-shearing transformation applied to this DrawItem.  Each point in the shape is moved along the x-axis a
     * distance that is proportional to the initial y-coordinate of the point.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param xShearFactor  Default value is 0.0
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setXShearFactor(double xShearFactor)  throws IllegalStateException {
        setAttribute("xShearFactor", xShearFactor, false);
    }

    /**
     * The slope of an x-shearing transformation applied to this DrawItem.  Each point in the shape is moved along the x-axis a
     * distance that is proportional to the initial y-coordinate of the point.
     *
     * @return double
     */
    public double getXShearFactor()  {
        return getAttributeAsDouble("xShearFactor");
    }
    

    /**
     * The slope of a y-shearing transformation applied to this DrawItem.  Each point in the shape is moved along the y-axis a
     * distance that is proportional to the initial x-coordinate of the point.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param yShearFactor  Default value is 0.0
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setYShearFactor(double yShearFactor)  throws IllegalStateException {
        setAttribute("yShearFactor", yShearFactor, false);
    }

    /**
     * The slope of a y-shearing transformation applied to this DrawItem.  Each point in the shape is moved along the y-axis a
     * distance that is proportional to the initial x-coordinate of the point.
     *
     * @return double
     */
    public double getYShearFactor()  {
        return getAttributeAsDouble("yShearFactor");
    }
    

    // ********************* Methods ***********************
    /**
     * Add a click handler.
     * <p>
     * Notification fired when the user clicks on this DrawItem. <p> Note that if this item is part of a {@link
     * com.smartgwt.client.widgets.drawing.DrawGroup}, then the group's {@link
     * com.smartgwt.client.widgets.drawing.DrawGroup#getUseGroupRect useGroupRect} setting affects whether this item receives
     * the notification. If useGroupRect is true, then this item will <em>not</em> receive the notification. Otherwise, the
     * item receives the notification and notification bubbles up to the group.
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
        var click = $debox($entry(function(param){
                var event = @com.smartgwt.client.widgets.drawing.events.ClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                selfJ.@com.smartgwt.client.core.BaseClass::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                return !ret;
            }));
        if(this.@com.smartgwt.client.core.BaseClass::isCreated()()) {
            obj = this.@com.smartgwt.client.core.BaseClass::getJsObj()();
            obj.addProperties({click: 
                function () {
                    var param = {};
                    return click(param) == true;
                }
             });
        } else {
            obj = this.@com.smartgwt.client.core.BaseClass::getConfig()();
            obj.click = 
                function () {
                    var param = {};
                    return click(param) == true;
                }
            ;
        }
   }-*/;


	/**
     * If {@link com.smartgwt.client.widgets.drawing.DrawItem#getCanDrag canDrag} is true and the {@link
     * com.smartgwt.client.widgets.drawing.DrawItem#getKnobs control knobs} include "resize" knobs, then this notification
     * method will be fired when the user drag-resizes the draw item.
     * @param position provides which knob of the {@link com.smartgwt.client.widgets.drawing.DrawItem#getResizeKnobPoints resizeKnobPoints} was
     * dragged
     * @param x new x-coordinate of the knob
     * @param y new y-coordinate of the knob
     * @param dX horizontal distance moved
     * @param dY vertical distance moved
     */
    public native void dragResizeMove(String position, Integer x, Integer y, Integer dX, Integer dY) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.dragResizeMove(position, x == null ? null : x.@java.lang.Integer::intValue()(), y == null ? null : y.@java.lang.Integer::intValue()(), dX == null ? null : dX.@java.lang.Integer::intValue()(), dY == null ? null : dY.@java.lang.Integer::intValue()());
    }-*/;


	/**
     * Draw this item into its current {@link com.smartgwt.client.widgets.drawing.DrawPane}.
     */
    public native void draw() /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.draw();
    }-*/;

	/**
     * Erase this drawItem's visual representation and remove it from its DrawGroup (if any) and DrawPane. <P> To re-draw the
     * item within the DrawPane, call {@link com.smartgwt.client.widgets.drawing.DrawItem#draw DrawItem.draw} again, or use
     * {@link com.smartgwt.client.widgets.drawing.DrawPane#addDrawItem DrawPane.addDrawItem} to move to another DrawGroup.
     */
    public native void erase() /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.erase();
    }-*/;

	/**
     * Returns the center point of the {@link com.smartgwt.client.widgets.drawing.DrawItem#getBoundingBox bounding box}.
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
     * If {@link com.smartgwt.client.widgets.drawing.DrawItem#getShowHover showHover} is true, when the user holds the mouse
     * over this DrawItem for long enough to trigger a hover event, a hover canvas is shown by default. This method returns the
     * contents of that hover canvas. Default implementation returns {@link
     * com.smartgwt.client.widgets.drawing.DrawItem#getPrompt prompt} - override for custom hover HTML. Note that returning
     * <code>null</code> or an empty string will suppress the hover canvas altogether.
     *
     * @return the HTML to show in the hover
     */
    public native String getHoverHTML() /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.getHoverHTML();
        return ret;
    }-*/;

	/**
     * Returns the page-relative left coordinate of the widget on the page, in pixels.
     *
     * @return global left coordinate
     * @see com.smartgwt.client.docs.Positioning Positioning overview and related methods
     */
    public native int getPageLeft() /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.getPageLeft();
        return ret;
    }-*/;

	/**
     * Returns the page-relative top coordinate of the widget on the page, in pixels
     *
     * @return GLOBAL top coordinate
     * @see com.smartgwt.client.docs.Positioning Positioning overview and related methods
     */
    public native int getPageTop() /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.getPageTop();
        return ret;
    }-*/;

	/**
     * Generates a string containing the SVG source of this DrawItem. <p><b>NOTE:</b> The generated SVG source assumes that the
     * default namespace is <code>http://www.w3.org/2000/svg</code> and that namespace prefix <code>xlink</code> refers to
     * namespace name <code>http://www.w3.org/1999/xlink</code>.
     */
    public native void getSvgString() /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.getSvgString();
    }-*/;

	/**
     * Hide this drawItem.
     */
    public native void hide() /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.hide();
    }-*/;

	/**
     * Hides all control knobs for this drawItem. Updates {@link com.smartgwt.client.widgets.drawing.DrawItem#getKnobs knobs}
     * to remove all knobTypes and clears any drawn knobs.
     */
    public native void hideAllKnobs() /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.hideAllKnobs();
    }-*/;



	/**
     * Hides a set of control knobs for this drawItem. Updates {@link com.smartgwt.client.widgets.drawing.DrawItem#getKnobs
     * knobs} to remove the specified knobType, and clears any drawn knobs for this knobType.
     * @param knobType knobs to hide
     */
    public native void hideKnobs(KnobType knobType) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.hideKnobs(knobType.@com.smartgwt.client.types.KnobType::getValue()());
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
     * If {@link com.smartgwt.client.widgets.drawing.DrawItem#getCanHover canHover} is true for this DrawItem, the hover()
     * string method will be fired when the user hovers over this DrawItem. If this method returns false, it will suppress the
     * default behavior of showing a hover canvas if {@link com.smartgwt.client.widgets.drawing.DrawItem#getShowHover
     * showHover} is true.
     *
     * @return false to cancel the hover event.
     */
    public native boolean hover() /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.hover();
        return ret;
    }-*/;



	/**
     * Returns true if the given point in the drawing coordinate system, when converted to coordinates in this DrawItem's local
     * coordinate system, is within the {@link com.smartgwt.client.widgets.drawing.DrawItem#getBoundingBox bounding box} of
     * this DrawItem's shape. <p> This method can be used to quickly check whether the given point is definitely <em>not</em>
     * within the DrawItem shape. To check whether the point is within the DrawItem shape, use the slower but exact {@link
     * com.smartgwt.client.widgets.drawing.DrawItem#isPointInPath DrawItem.isPointInPath} method.
     * @param x X coordinate of the point in the drawing coordinate system.
     * @param y Y coordinate of the point in the drawing coordinate system.
     *
     * @return 
     */
    public native boolean isInBounds(int x, int y) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.isInBounds(x, y);
        return ret;
    }-*/;




	/**
     * Returns true if the given point in the drawing coordinate system is within this DrawItem's shape, taking into account
     * local transforms.
     * @param x X coordinate of the test point.
     * @param y Y coordinate of the test point.
     *
     * @return 
     */
    public native boolean isPointInPath(int x, int y) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.isPointInPath(x, y);
        return ret;
    }-*/;


    /**
     * Add a mouseDown handler.
     * <p>
     * Notification fired when the user presses the left mouse button on this DrawItem. <p> Note that if this item is part of a
     * {@link com.smartgwt.client.widgets.drawing.DrawGroup}, then the group's {@link
     * com.smartgwt.client.widgets.drawing.DrawGroup#getUseGroupRect useGroupRect} setting affects whether this item receives
     * the notification. If useGroupRect is true, then this item will <em>not</em> receive the notification. Otherwise, the
     * item receives the notification and notification bubbles up to the group.
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
        var mouseDown = $debox($entry(function(param){
                var event = @com.smartgwt.client.widgets.drawing.events.MouseDownEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                selfJ.@com.smartgwt.client.core.BaseClass::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                return !ret;
            }));
        if(this.@com.smartgwt.client.core.BaseClass::isCreated()()) {
            obj = this.@com.smartgwt.client.core.BaseClass::getJsObj()();
            obj.addProperties({mouseDown: 
                function () {
                    var param = {};
                    return mouseDown(param) == true;
                }
             });
        } else {
            obj = this.@com.smartgwt.client.core.BaseClass::getConfig()();
            obj.mouseDown = 
                function () {
                    var param = {};
                    return mouseDown(param) == true;
                }
            ;
        }
   }-*/;
    /**
     * Add a mouseMove handler.
     * <p>
     * Notification fired when the user moves the mouse over this DrawItem. <p> Note that if this item is part of a {@link
     * com.smartgwt.client.widgets.drawing.DrawGroup}, then the group's {@link
     * com.smartgwt.client.widgets.drawing.DrawGroup#getUseGroupRect useGroupRect} setting affects whether this item receives
     * the notification. If useGroupRect is true, then this item will <em>not</em> receive the notification. Otherwise, the
     * item receives the notification and notification bubbles up to the group.
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
        var mouseMove = $debox($entry(function(param){
                var event = @com.smartgwt.client.widgets.drawing.events.MouseMoveEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                selfJ.@com.smartgwt.client.core.BaseClass::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                return !ret;
            }));
        if(this.@com.smartgwt.client.core.BaseClass::isCreated()()) {
            obj = this.@com.smartgwt.client.core.BaseClass::getJsObj()();
            obj.addProperties({mouseMove: 
                function () {
                    var param = {};
                    return mouseMove(param) == true;
                }
             });
        } else {
            obj = this.@com.smartgwt.client.core.BaseClass::getConfig()();
            obj.mouseMove = 
                function () {
                    var param = {};
                    return mouseMove(param) == true;
                }
            ;
        }
   }-*/;
    /**
     * Add a mouseOut handler.
     * <p>
     * Notification fired when the mouse leaves this DrawItem. <p> Note that if this item is part of a {@link
     * com.smartgwt.client.widgets.drawing.DrawGroup}, then the group's {@link
     * com.smartgwt.client.widgets.drawing.DrawGroup#getUseGroupRect useGroupRect} setting affects whether this item receives
     * the notification. If useGroupRect is true, then this item will <em>not</em> receive the notification. Otherwise, the
     * item receives the notification and notification bubbles up to the group.
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
        var mouseOut = $debox($entry(function(param){
                var event = @com.smartgwt.client.widgets.drawing.events.MouseOutEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                selfJ.@com.smartgwt.client.core.BaseClass::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                return !ret;
            }));
        if(this.@com.smartgwt.client.core.BaseClass::isCreated()()) {
            obj = this.@com.smartgwt.client.core.BaseClass::getJsObj()();
            obj.addProperties({mouseOut: 
                function () {
                    var param = {};
                    return mouseOut(param) == true;
                }
             });
        } else {
            obj = this.@com.smartgwt.client.core.BaseClass::getConfig()();
            obj.mouseOut = 
                function () {
                    var param = {};
                    return mouseOut(param) == true;
                }
            ;
        }
   }-*/;
    /**
     * Add a mouseOver handler.
     * <p>
     * Notification fired when the mouse enters this DrawItem. <p> Note that if this item is part of a {@link
     * com.smartgwt.client.widgets.drawing.DrawGroup}, then the group's {@link
     * com.smartgwt.client.widgets.drawing.DrawGroup#getUseGroupRect useGroupRect} setting affects whether this item receives
     * the notification. If useGroupRect is true, then this item will <em>not</em> receive the notification. Otherwise, the
     * item receives the notification and notification bubbles up to the group.
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
        var mouseOver = $debox($entry(function(param){
                var event = @com.smartgwt.client.widgets.drawing.events.MouseOverEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                selfJ.@com.smartgwt.client.core.BaseClass::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                return !ret;
            }));
        if(this.@com.smartgwt.client.core.BaseClass::isCreated()()) {
            obj = this.@com.smartgwt.client.core.BaseClass::getJsObj()();
            obj.addProperties({mouseOver: 
                function () {
                    var param = {};
                    return mouseOver(param) == true;
                }
             });
        } else {
            obj = this.@com.smartgwt.client.core.BaseClass::getConfig()();
            obj.mouseOver = 
                function () {
                    var param = {};
                    return mouseOver(param) == true;
                }
            ;
        }
   }-*/;
    /**
     * Add a mouseUp handler.
     * <p>
     * Notification fired when the user releases the left mouse button on this DrawItem. <p> Note that if this item is part of
     * a {@link com.smartgwt.client.widgets.drawing.DrawGroup}, then the group's {@link
     * com.smartgwt.client.widgets.drawing.DrawGroup#getUseGroupRect useGroupRect} setting affects whether this item receives
     * the notification. If useGroupRect is true, then this item will <em>not</em> receive the notification. Otherwise, the
     * item receives the notification and notification bubbles up to the group.
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
        var mouseUp = $debox($entry(function(param){
                var event = @com.smartgwt.client.widgets.drawing.events.MouseUpEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                selfJ.@com.smartgwt.client.core.BaseClass::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                return !ret;
            }));
        if(this.@com.smartgwt.client.core.BaseClass::isCreated()()) {
            obj = this.@com.smartgwt.client.core.BaseClass::getJsObj()();
            obj.addProperties({mouseUp: 
                function () {
                    var param = {};
                    return mouseUp(param) == true;
                }
             });
        } else {
            obj = this.@com.smartgwt.client.core.BaseClass::getConfig()();
            obj.mouseUp = 
                function () {
                    var param = {};
                    return mouseUp(param) == true;
                }
            ;
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
     * Add a moved handler.
     * <p>
     * Notification method fired when this component is explicitly moved. Note that a component's position on the screen may
     * also be changed due to an ancestor being moved. The {@link com.smartgwt.client.widgets.Canvas#addParentMovedHandler
     * parentMoved()} method provides a notification entry point to catch that case as well.
     *
     * @param handler the moved handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addMovedHandler(com.smartgwt.client.widgets.drawing.events.MovedHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.drawing.events.MovedEvent.getType()) == 0) setupMovedEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.drawing.events.MovedEvent.getType());
    }

    private native void setupMovedEvent() /*-{
        var obj = null;
        var selfJ = this;
        var moved = $entry(function(){
            var param = {"deltaX" : arguments[0], "deltaY" : arguments[1]};
                var event = @com.smartgwt.client.widgets.drawing.events.MovedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                selfJ.@com.smartgwt.client.core.BaseClass::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            });
        if(this.@com.smartgwt.client.core.BaseClass::isCreated()()) {
            obj = this.@com.smartgwt.client.core.BaseClass::getJsObj()();
            obj.addProperties({moved:  moved              });
        } else {
            obj = this.@com.smartgwt.client.core.BaseClass::getConfig()();
            obj.moved =  moved             ;
        }
   }-*/;


	/**
     * Move the DrawItem to the specified coordinates in the global coordinate system.  The specified coordinates will become
     * the top-left point of the {@link com.smartgwt.client.widgets.drawing.DrawItem#getResizeBoundingBox resize bounding box}.
     * @param left new left coordinate in pixels
     * @param top new top coordinate in pixels
     */
    public native void moveTo(Integer left, Integer top) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.moveTo(left == null ? null : left.@java.lang.Integer::intValue()(), top == null ? null : top.@java.lang.Integer::intValue()());
    }-*/;


    /**
     * Add a dragMove handler.
     * <p>
     * If {@link com.smartgwt.client.widgets.drawing.DrawItem#getCanDrag canDrag} is true, this notification method will be
     * fired when the user drags the draw item.
     *
     * @param handler the dragMove handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addDragMoveHandler(com.smartgwt.client.widgets.drawing.events.DragMoveHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.drawing.events.DragMove.getType()) == 0) setupDragMoveEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.drawing.events.DragMove.getType());
    }

    private native void setupDragMoveEvent() /*-{
        var obj = null;
        var selfJ = this;
        var onDragMove = $debox($entry(function(param){
                var event = @com.smartgwt.client.widgets.drawing.events.DragMove::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                selfJ.@com.smartgwt.client.core.BaseClass::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                return !ret;
            }));
        if(this.@com.smartgwt.client.core.BaseClass::isCreated()()) {
            obj = this.@com.smartgwt.client.core.BaseClass::getJsObj()();
            obj.addProperties({onDragMove: 
                function () {
                    var param = {"x" : arguments[0], "y" : arguments[1]};
                    return onDragMove(param) == true;
                }
             });
        } else {
            obj = this.@com.smartgwt.client.core.BaseClass::getConfig()();
            obj.onDragMove = 
                function () {
                    var param = {"x" : arguments[0], "y" : arguments[1]};
                    return onDragMove(param) == true;
                }
            ;
        }
   }-*/;
    /**
     * Add a dragResizeMove handler.
     * <p>
     * If {@link com.smartgwt.client.widgets.drawing.DrawItem#getCanDrag canDrag} is true and the {@link
     * com.smartgwt.client.widgets.drawing.DrawItem#getKnobs control knobs} include "resize" knobs then this notification
     * method will be fired when the user drags the resize knobs of the draw item.
     *
     * @param handler the dragResizeMove handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addDragResizeMoveHandler(com.smartgwt.client.widgets.drawing.events.DragResizeMoveHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.drawing.events.DragResizeMoveEvent.getType()) == 0) setupDragResizeMoveEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.drawing.events.DragResizeMoveEvent.getType());
    }

    private native void setupDragResizeMoveEvent() /*-{
        var obj = null;
        var selfJ = this;
        var onDragResizeMove = $debox($entry(function(param){
                var event = @com.smartgwt.client.widgets.drawing.events.DragResizeMoveEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                selfJ.@com.smartgwt.client.core.BaseClass::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                return !ret;
            }));
        if(this.@com.smartgwt.client.core.BaseClass::isCreated()()) {
            obj = this.@com.smartgwt.client.core.BaseClass::getJsObj()();
            obj.addProperties({onDragResizeMove: 
                function () {
                    var param = {"newX" : arguments[0], "newY" : arguments[1], "newWidth" : arguments[2], "newHeight" : arguments[3]};
                    return onDragResizeMove(param) == true;
                }
             });
        } else {
            obj = this.@com.smartgwt.client.core.BaseClass::getConfig()();
            obj.onDragResizeMove = 
                function () {
                    var param = {"newX" : arguments[0], "newY" : arguments[1], "newWidth" : arguments[2], "newHeight" : arguments[3]};
                    return onDragResizeMove(param) == true;
                }
            ;
        }
   }-*/;
    /**
     * Add a dragResizeStart handler.
     * <p>
     * If {@link com.smartgwt.client.widgets.drawing.DrawItem#getCanDrag canDrag} is true and the {@link
     * com.smartgwt.client.widgets.drawing.DrawItem#getKnobs control knobs} include "resize" knobs then this notification
     * method will be fired when the user starts to drag the resize knobs of the draw item.
     *
     * @param handler the dragResizeStart handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addDragResizeStartHandler(com.smartgwt.client.widgets.drawing.events.DragResizeStartHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.drawing.events.DragResizeStartEvent.getType()) == 0) setupDragResizeStartEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.drawing.events.DragResizeStartEvent.getType());
    }

    private native void setupDragResizeStartEvent() /*-{
        var obj = null;
        var selfJ = this;
        var onDragResizeStart = $debox($entry(function(param){
                var event = @com.smartgwt.client.widgets.drawing.events.DragResizeStartEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                selfJ.@com.smartgwt.client.core.BaseClass::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                return !ret;
            }));
        if(this.@com.smartgwt.client.core.BaseClass::isCreated()()) {
            obj = this.@com.smartgwt.client.core.BaseClass::getJsObj()();
            obj.addProperties({onDragResizeStart: 
                function () {
                    var param = {"newX" : arguments[0], "newY" : arguments[1], "newWidth" : arguments[2], "newHeight" : arguments[3]};
                    return onDragResizeStart(param) == true;
                }
             });
        } else {
            obj = this.@com.smartgwt.client.core.BaseClass::getConfig()();
            obj.onDragResizeStart = 
                function () {
                    var param = {"newX" : arguments[0], "newY" : arguments[1], "newWidth" : arguments[2], "newHeight" : arguments[3]};
                    return onDragResizeStart(param) == true;
                }
            ;
        }
   }-*/;
    /**
     * Add a dragResizeStop handler.
     * <p>
     * If {@link com.smartgwt.client.widgets.drawing.DrawItem#getCanDrag canDrag} is true and the {@link
     * com.smartgwt.client.widgets.drawing.DrawItem#getKnobs control knobs} include "resize" knobs then this notification
     * method will be fired when the user completes a drag on the resize knobs of the draw item.
     *
     * @param handler the dragResizeStop handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addDragResizeStopHandler(com.smartgwt.client.widgets.drawing.events.DragResizeStopHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.drawing.events.DragResizeStopEvent.getType()) == 0) setupDragResizeStopEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.drawing.events.DragResizeStopEvent.getType());
    }

    private native void setupDragResizeStopEvent() /*-{
        var obj = null;
        var selfJ = this;
        var onDragResizeStop = $entry(function(){
            var param = {"newX" : arguments[0], "newY" : arguments[1], "newWidth" : arguments[2], "newHeight" : arguments[3]};
                var event = @com.smartgwt.client.widgets.drawing.events.DragResizeStopEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                selfJ.@com.smartgwt.client.core.BaseClass::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            });
        if(this.@com.smartgwt.client.core.BaseClass::isCreated()()) {
            obj = this.@com.smartgwt.client.core.BaseClass::getJsObj()();
            obj.addProperties({onDragResizeStop:  onDragResizeStop              });
        } else {
            obj = this.@com.smartgwt.client.core.BaseClass::getConfig()();
            obj.onDragResizeStop =  onDragResizeStop             ;
        }
   }-*/;
    /**
     * Add a dragStart handler.
     * <p>
     * If {@link com.smartgwt.client.widgets.drawing.DrawItem#getCanDrag canDrag} is true, this notification method will be
     * fired when the user starts to drag the draw item.
     *
     * @param handler the dragStart handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addDragStartHandler(com.smartgwt.client.widgets.drawing.events.DragStartHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.drawing.events.DragStart.getType()) == 0) setupDragStartEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.drawing.events.DragStart.getType());
    }

    private native void setupDragStartEvent() /*-{
        var obj = null;
        var selfJ = this;
        var onDragStart = $debox($entry(function(param){
                var event = @com.smartgwt.client.widgets.drawing.events.DragStart::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                selfJ.@com.smartgwt.client.core.BaseClass::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                return !ret;
            }));
        if(this.@com.smartgwt.client.core.BaseClass::isCreated()()) {
            obj = this.@com.smartgwt.client.core.BaseClass::getJsObj()();
            obj.addProperties({onDragStart: 
                function () {
                    var param = {"x" : arguments[0], "y" : arguments[1]};
                    return onDragStart(param) == true;
                }
             });
        } else {
            obj = this.@com.smartgwt.client.core.BaseClass::getConfig()();
            obj.onDragStart = 
                function () {
                    var param = {"x" : arguments[0], "y" : arguments[1]};
                    return onDragStart(param) == true;
                }
            ;
        }
   }-*/;
    /**
     * Add a dragStop handler.
     * <p>
     * If {@link com.smartgwt.client.widgets.drawing.DrawItem#getCanDrag canDrag} is true, this notification method will be
     * fired when the user completes a drag on the draw item.
     *
     * @param handler the dragStop handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addDragStopHandler(com.smartgwt.client.widgets.drawing.events.DragStopHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.drawing.events.DragStop.getType()) == 0) setupDragStopEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.drawing.events.DragStop.getType());
    }

    private native void setupDragStopEvent() /*-{
        var obj = null;
        var selfJ = this;
        var onDragStop = $entry(function(){
            var param = {"x" : arguments[0], "y" : arguments[1]};
                var event = @com.smartgwt.client.widgets.drawing.events.DragStop::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                selfJ.@com.smartgwt.client.core.BaseClass::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            });
        if(this.@com.smartgwt.client.core.BaseClass::isCreated()()) {
            obj = this.@com.smartgwt.client.core.BaseClass::getJsObj()();
            obj.addProperties({onDragStop:  onDragStop              });
        } else {
            obj = this.@com.smartgwt.client.core.BaseClass::getConfig()();
            obj.onDragStop =  onDragStop             ;
        }
   }-*/;


	/**
     * Resize the shape by the specified deltas.
     * @param dX number of pixels to resize by horizontally
     * @param dY number of pixels to resize by vertically
     */
    public native void resizeBy(int dX, int dY) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.resizeBy(dX, dY);
    }-*/;


    /**
     * Add a resized handler.
     * <p>
     * Observable method called whenever a DrawItem changes size.
     *
     * @param handler the resized handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addResizedHandler(com.smartgwt.client.widgets.drawing.events.ResizedHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.drawing.events.ResizedEvent.getType()) == 0) setupResizedEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.drawing.events.ResizedEvent.getType());
    }

    private native void setupResizedEvent() /*-{
        var obj = null;
        var selfJ = this;
        var resized = $entry(function(){
            var param = {};
                var event = @com.smartgwt.client.widgets.drawing.events.ResizedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                selfJ.@com.smartgwt.client.core.BaseClass::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            });
        if(this.@com.smartgwt.client.core.BaseClass::isCreated()()) {
            obj = this.@com.smartgwt.client.core.BaseClass::getJsObj()();
            obj.addProperties({resized:  resized              });
        } else {
            obj = this.@com.smartgwt.client.core.BaseClass::getConfig()();
            obj.resized =  resized             ;
        }
   }-*/;


	/**
     * Resize to the specified size
     * @param width new width
     * @param height new height
     */
    public native void resizeTo(Integer width, Integer height) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.resizeTo(width == null ? null : width.@java.lang.Integer::intValue()(), height == null ? null : height.@java.lang.Integer::intValue()());
    }-*/;




	/**
     * Rotate the shape by the relative rotation in degrees
     * @param degrees number of degrees to rotate from current orientation.
     */
    public native void rotateBy(double degrees) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.rotateBy(degrees);
    }-*/;




	/**
     * Rotate the shape by the absolute rotation in degrees
     * @param degrees number of degrees to rotate
     */
    public native void rotateTo(double degrees) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.rotateTo(degrees);
    }-*/;





	/**
     * Scale the shape by the x, y multipliers
     * @param x scale in the x direction
     * @param y scale in the y direction
     */
    public native void scaleBy(double x, double y) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.scaleBy(x, y);
    }-*/;





	/**
     * Scale the shape by the x, y multipliers
     * @param x scale in the x direction
     * @param y scale in the y direction
     */
    public native void scaleTo(double x, double y) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.scaleTo(x, y);
    }-*/;




	/**
     * Change the center point for this DrawItem.
     * @param left X coordinate of the center point (in the global coordinate system).
     * @param top Y coordinate of the center point (in the global coordinate system).
     */
    public native void setCenterPoint(int left, int top) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.setCenterPoint(left, top);
    }-*/;




	/**
     * Sets a property on this DrawItem, calling the appropriate setter method if one is found and is  supported.
     * @param propertyName name of the property to set
     * @param newValue new value for the property
     */
    public native void setPropertyValue(String propertyName, Object newValue) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.setPropertyValue(propertyName, newValue);
    }-*/;


	/**
     * Make this drawItem visible.
     */
    public native void show() /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.show();
    }-*/;

	/**
     * Shows all supported control knobs for this drawItem. Updates {@link
     * com.smartgwt.client.widgets.drawing.DrawItem#getKnobs knobs} to include the supported knobTypes and if necessary draws
     * out the appropriate control knobs.
     */
    public native void showAllKnobs() /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.showAllKnobs();
    }-*/;

    /**
     * Add a showContextMenu handler.
     * <p>
     * Executed when the right mouse button is clicked.  The default implementation of this method auto-creates a {@link
     * com.smartgwt.client.widgets.menu.Menu} from the {@link com.smartgwt.client.widgets.Canvas#getContextMenu contextMenu}
     * property on this component and then calls {@link com.smartgwt.client.widgets.menu.Menu#showContextMenu
     * Menu.showContextMenu} on it to show it. <p> If you want to show a standard context menu, you can simply define your Menu
     * and set it as the contextMenu property on your component - you do not need to override this method. <p> If you want to
     * do some other processing before showing a menu or do something else entirely, then you should override this method. 
     * Note that the return value from this method controls whether or not the native browser context menu is shown.
     *
     * @param handler the showContextMenu handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addShowContextMenuHandler(com.smartgwt.client.widgets.drawing.events.ShowContextMenuHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.drawing.events.ShowContextMenuEvent.getType()) == 0) setupShowContextMenuEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.drawing.events.ShowContextMenuEvent.getType());
    }

    private native void setupShowContextMenuEvent() /*-{
        var obj = null;
        var selfJ = this;
        var showContextMenu = $debox($entry(function(param){
                var event = @com.smartgwt.client.widgets.drawing.events.ShowContextMenuEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                selfJ.@com.smartgwt.client.core.BaseClass::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                return !ret;
            }));
        if(this.@com.smartgwt.client.core.BaseClass::isCreated()()) {
            obj = this.@com.smartgwt.client.core.BaseClass::getJsObj()();
            obj.addProperties({showContextMenu: 
                function () {
                    var param = {};
                    return showContextMenu(param) == true;
                }
             });
        } else {
            obj = this.@com.smartgwt.client.core.BaseClass::getConfig()();
            obj.showContextMenu = 
                function () {
                    var param = {};
                    return showContextMenu(param) == true;
                }
            ;
        }
   }-*/;


	/**
     * Shows a set of control knobs for this drawItem. Updates {@link com.smartgwt.client.widgets.drawing.DrawItem#getKnobs
     * knobs} to include the specified knobType, and if necessary draws out the appropriate control knobs.
     * @param knobType knobs to show
     */
    public native void showKnobs(KnobType knobType) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.showKnobs(knobType.@com.smartgwt.client.types.KnobType::getValue()());
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
     * Does this DrawItem  support {@link com.smartgwt.client.widgets.drawing.DrawItem#setEndArrow DrawItem.setEndArrow}? For
     * example, this is false for {@link com.smartgwt.client.widgets.drawing.DrawRect} and {@link
     * com.smartgwt.client.widgets.drawing.DrawOval}, and true for {@link com.smartgwt.client.widgets.drawing.DrawLine}.
     *
     * @return whether setEndArrow() is supported by this DrawItem.
     */
    public native boolean supportsEndArrow() /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.supportsEndArrow();
        return ret;
    }-*/;

	/**
     * Does this DrawItem  support {@link com.smartgwt.client.widgets.drawing.DrawItem#setStartArrow DrawItem.setStartArrow}?
     * For example, this is false for {@link com.smartgwt.client.widgets.drawing.DrawRect} and {@link
     * com.smartgwt.client.widgets.drawing.DrawOval}, and true for {@link com.smartgwt.client.widgets.drawing.DrawLine}.
     *
     * @return whether setStartArrow() is supported by this DrawItem.
     */
    public native boolean supportsStartArrow() /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.supportsStartArrow();
        return ret;
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
     * @param drawItemProperties properties that should be used as new defaults when instances of this class are created
     */
    public static native void setDefaultProperties(DrawItem drawItemProperties) /*-{
    	var properties = $wnd.isc.addProperties({},drawItemProperties.@com.smartgwt.client.core.BaseClass::getConfig()());
        @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(properties,false);
        $wnd.isc.DrawItem.addProperties(properties);
    }-*/;

    // ***********************************************************



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

    /**
     * Computes the angle in degrees from the positive X axis to the difference vector <nobr><b>v</b><sub>2</sub> -
     * <b>v</b><sub>1</sub></nobr> between the two given vectors.
     * @param px1 X coordinate of <b>v</b><sub>1</sub>
     * @param py1 Y coordinate of <b>v</b><sub>1</sub>
     * @param px2 X coordinate of <b>v</b><sub>2</sub>
     * @param py2 Y coordinate of <b>v</b><sub>2</sub>
     *
     * @return the angle in degrees, in the range [0, 360).
     * @deprecated {@link com.smartgwt.client.docs.GwtFloatVsDouble GwtFloatVsDouble}
     */
    public static native float computeAngle(double px1, double py1, double px2, double py2) /*-{
        var ret = $wnd.isc.DrawItem.computeAngle(px1, py1, px2, py2);
        return ret;
    }-*/;

    /**
     * Computes the angle in degrees from the positive X axis to the difference vector <nobr><b>v</b><sub>2</sub> -
     * <b>v</b><sub>1</sub></nobr> between the two given vectors.
     * @param px1 X coordinate of <b>v</b><sub>1</sub>
     * @param py1 Y coordinate of <b>v</b><sub>1</sub>
     * @param px2 X coordinate of <b>v</b><sub>2</sub>
     * @param py2 Y coordinate of <b>v</b><sub>2</sub>
     *
     * @return the angle in degrees, in the range [0, 360).
     */
    public static native double computeAngleAsDouble(double px1, double py1, double px2, double py2) /*-{
        var ret = $wnd.isc.DrawItem.computeAngle(px1, py1, px2, py2);
        return ret;
    }-*/;

    /**
     * Returns the startPoint endPoint
     *
     * @return x1, y1, x2, y2 coordinates
     */
    public native Double[] getBoundingBoxAsDouble() /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var selection = self.getBoundingBox();
        return selection == null || selection === undefined ? null : @com.smartgwt.client.util.JSOHelper::convertToJavaDoubleArray(Lcom/google/gwt/core/client/JavaScriptObject;)(selection);
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

    /**
     * Returns the bounding box of the shape reflected by the {@link com.smartgwt.client.widgets.drawing.DrawItem#getShowResizeOutline resize outline} shown when dragging the {@link com.smartgwt.client.widgets.drawing.DrawItem#getResizeKnobPoints resize knobs}.  This method is similar to {@link com.smartgwt.client.widgets.drawing.DrawItem#getBoundingBoxAsDouble getBoundingBoxAsDouble} except that the coordinates returned by this method are in the global coordinate system (described {@link com.smartgwt.client.widgets.drawing.DrawPane here}).
     * @return The x1, y1, x2, y2 coordinates. When the width and height are both positive, point (x1, y1) is the top-left point of the bounding box and point (x2, y2) is the bottom-right point of the bounding box.
     * @see com.smartgwt.client.widgets.drawing.DrawItem#getBoundingBoxAsDouble
     */
    public native Double[] getResizeBoundingBoxAsDouble() /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var selection = self.getResizeBoundingBox();
        return selection == null || selection === undefined ? null : @com.smartgwt.client.util.JSOHelper::convertToJavaDoubleArray(Lcom/google/gwt/core/client/JavaScriptObject;)(selection);
    }-*/;

    /**
     * Returns the bounding box of the shape reflected by the {@link com.smartgwt.client.widgets.drawing.DrawItem#getShowResizeOutline resize outline} shown when dragging the {@link com.smartgwt.client.widgets.drawing.DrawItem#getResizeKnobPoints resize knobs}.  This method is similar to {@link com.smartgwt.client.widgets.drawing.DrawItem#getBoundingBox getBoundingBox} except that the coordinates returned by this method are in the global coordinate system (described {@link com.smartgwt.client.widgets.drawing.DrawPane here}).
     * @return The x1, y1, x2, y2 coordinates. When the width and height are both positive, point (x1, y1) is the top-left point of the bounding box and point (x2, y2) is the bottom-right point of the bounding box.
     * @see com.smartgwt.client.widgets.drawing.DrawItem#getBoundingBox
     */
    public native int[] getResizeBoundingBox() /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var selection = self.getResizeBoundingBox();
        if (selection == null || selection === undefined) {
            return null;
        } else {
            // Guarantee that the entries of the resize-bounding-box are integers.
            selection[0] = Math.round(selection[0]);
            selection[1] = Math.round(selection[1]);
            selection[2] = Math.round(selection[2]);
            selection[3] = Math.round(selection[3]);
            return @com.smartgwt.client.util.JSOHelper::convertToJavaIntArray(Lcom/google/gwt/core/client/JavaScriptObject;)(selection);
        }
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

    protected void setAttribute(String attribute, Float[] value, boolean allowPostCreate) {
        if (!isCreated()) {
            JSOHelper.setAttribute(config, attribute, value);
        } else if (allowPostCreate) {
            setProperty(attribute, JSOHelper.convertToJavaScriptArray(value));
        } else {
            error(attribute, value.toString(), allowPostCreate);
        }
    }

    protected void setAttribute(String attribute, float[] value, boolean allowPostCreate) {
        if (!isCreated()) {
            JSOHelper.setAttribute(config, attribute, value);
        } else if (allowPostCreate) {
            setProperty(attribute, JSOHelper.convertToJavaScriptArray(value));
        } else {
            error(attribute, value.toString(), allowPostCreate);
        }
    }

    /**
     * Sets the SmartClient constructor for the AutoChild named <code>autoChildName</code>.
     *
     * @param autoChildName the name of the AutoChild
     * @param className the SmartClient class name to use when constructing the AutoChild.
     * @see com.smartgwt.client.docs.AutoChildUsage
     */
    public native void setAutoChildConstructor(String autoChildName, String className) /*-{
        var self = this.@com.smartgwt.client.widgets.drawing.DrawItem::getJsObj()();
        self[autoChildName + "Constructor"] = className;
    }-*/;

    /**
     * Sets the properties for creating a <code>Canvas</code> AutoChild named <code>autoChildName</code>.
     *
     * <p><code>properties</code> must not have already been created ({@link com.smartgwt.client.widgets.BaseWidget#isCreated() properties.isCreated()}
     * must be <code>false</code>).
     *
     * <p><b>NOTE:</b> Overrides at override points are not applied to AutoChildren created from
     * <code>properties</code>; that is, if the Java {@link java.lang.Class} of <code>properties</code>
     * overrides a Smart&nbsp;GWT override point, the custom method implementation will not be called.
     *
     * @throws IllegalStateException if <code>properties</code> has been created.
     * @see com.smartgwt.client.docs.AutoChildUsage
     */
    public void setAutoChildProperties(String autoChildName, Canvas properties) throws IllegalStateException {
        if (properties.isCreated()) {
            throw new IllegalStateException(JSOHelper.getClassName(properties.getJsObj()) + " passed as configuration properties has been initialized and/or drawn. Calling draw(), fetchData() and other methods will force a component to initialize, after which it cannot be used as configuration properties.");
        }
        final JavaScriptObject selfJS;
        if (isCreated()) selfJS = getJsObj();
        else selfJS = getConfig();
        JSOHelper.setAttribute(selfJS, autoChildName + "Properties", JSOHelper.cleanProperties(properties.getConfig(), true));
    }

    /**
     * Sets the properties for creating a <code>FormItem</code> AutoChild named <code>autoChildName</code>.
     *
     * <p><code>properties</code> must not have already been created ({@link com.smartgwt.client.widgets.form.fields.FormItem#isCreated() properties.isCreated()}
     * must be <code>false</code>).
     *
     * <p><b>NOTE:</b> Overrides at override points are not applied to AutoChildren created from
     * <code>properties</code>; that is, if the Java {@link java.lang.Class} of <code>properties</code>
     * overrides a Smart&nbsp;GWT override point, the custom method implementation will not be called.
     *
     * @throws IllegalStateException if <code>properties</code> has been created.
     * @see com.smartgwt.client.docs.AutoChildUsage
     */
    public void setAutoChildProperties(String autoChildName, FormItem properties) throws IllegalStateException {
        if (properties.isCreated()) {
            throw new IllegalStateException(JSOHelper.getClassName(properties.getJsObj()) + " passed as configuration properties has been created. Adding to a DynamicForm will force a form item to be created, after which it cannot be used as configuration properties.");
        }
        final JavaScriptObject selfJS;
        if (isCreated()) selfJS = getJsObj();
        else selfJS = getConfig();
        JSOHelper.setAttribute(selfJS, autoChildName + "Properties", JSOHelper.cleanProperties(properties.getJsObj(), true));
    }

    /**
     * Sets the properties for creating a <code>DrawItem</code> AutoChild named <code>autoChildName</code>.
     *
     * <p><code>properties</code> must not have already been created ({@link com.smartgwt.client.widgets.drawing.DrawItem#isCreated() properties.isCreated()}
     * must be <code>false</code>).
     *
     * <p><b>NOTE:</b> Overrides at override points are not applied to AutoChildren created from
     * <code>properties</code>; that is, if the Java {@link java.lang.Class} of <code>properties</code>
     * overrides a Smart&nbsp;GWT override point, the custom method implementation will not be called.
     *
     * @throws IllegalStateException if <code>properties</code> has been created.
     * @see com.smartgwt.client.docs.AutoChildUsage
     */
    public void setAutoChildProperties(String autoChildName, DrawItem properties) throws IllegalStateException {
        if (properties.isCreated()) {
            throw new IllegalStateException(JSOHelper.getClassName(properties.getJsObj()) + " passed as configuration properties has been initialized and/or drawn. Calling draw() and other methods or adding to a DrawPane will force a DrawItem to initialize, after which it cannot be used as configuration properties.");
        }
        final JavaScriptObject selfJS;
        if (isCreated()) selfJS = getJsObj();
        else selfJS = getConfig();
        JSOHelper.setAttribute(selfJS, autoChildName + "Properties", JSOHelper.cleanProperties(properties.getConfig(), true));
    }

    /**
     * Sets the properties for creating an AutoChild named <code>autoChildName</code>.
     *
     * <p><code>properties</code> must not have already been created ({@link com.smartgwt.client.tools.EditProxy#isCreated() properties.isCreated()}
     * must be <code>false</code>).
     *
     * @throws IllegalStateException if <code>properties</code> has been created.
     * @see com.smartgwt.client.docs.AutoChildUsage
     */
    public void setAutoChildProperties(String autoChildName, EditProxy properties) throws IllegalStateException {
        if (properties.isCreated()) {
            final String className = properties.getClassName();
            final int periodPos = className.lastIndexOf('.');
            final String simpleName;
            if (periodPos >= 0) simpleName = className.substring(periodPos + 1);
            else simpleName = className;
            throw new IllegalStateException("The " + simpleName + " has been created and cannot be used as configuration properties.");
        }
        final JavaScriptObject selfJS;
        if (isCreated()) selfJS = getJsObj();
        else selfJS = getConfig();
        JSOHelper.setAttribute(selfJS, autoChildName + "Properties", JSOHelper.cleanProperties(properties.getConfig(), true));
    }

    /**
     * Sets whether to create and show the AutoChild named <code>autoChildName</code>.
     * <p>
     * <b>NOTE:</b> This API is not valid for all AutoChildren because some AutoChildren cannot
     * be hidden without destroying the main functions of the component.
     *
     * @param autoChildName name of an AutoChild
     * @param visible whether to show the AutoChild
     */
    public void setAutoChildVisibility(String autoChildName, boolean visible) {
        setProperty("show" + Character.toUpperCase(autoChildName.charAt(0)) + autoChildName.substring(1), visible);
    }

    /**
     * Returns the <code>Canvas</code> AutoChild named <code>autoChildName</code> if already created.
     *
     * @param autoChildName name of an AutoChild to return.
     * @throws RuntimeException if the AutoChild is not a &#83;martClient <code>Canvas</code> object.
     */
    public native final Canvas getCanvasAutoChild(String autoChildName) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var autoChildJS = self[autoChildName];
        if (autoChildJS == null) return null;
        if (!$wnd.isc.isA.Canvas(autoChildJS)) throw @java.lang.RuntimeException::new(Ljava/lang/String;)("The '" + autoChildName + "' AutoChild is not a Canvas.");

        // getCanvasAutoChild() should return the same Object.
        if (autoChildJS.__ref !== undefined) return autoChildJS.__ref;
        return (autoChildJS.__ref = @com.smartgwt.client.util.ObjectFactory::createCanvas(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(autoChildJS.getClassName(), autoChildJS));
    }-*/;

    /**
     * Returns the <code>FormItem</code> AutoChild named <code>autoChildName</code> if already created.
     *
     * @param autoChildName name of an AutoChild to return.
     * @throws RuntimeException if the AutoChild is not a &#83;martClient <code>FormItem</code> object.
     */
    public native final FormItem getFormItemAutoChild(String autoChildName) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var autoChildJS = self[autoChildName];
        if (autoChildJS == null) return null;
        if (!$wnd.isc.isA.FormItem(autoChildJS)) throw @java.lang.RuntimeException::new(Ljava/lang/String;)("The '" + autoChildName + "' AutoChild is not a FormItem.");

        // getFormItemAutoChild() should return the same Object.
        if (autoChildJS.__ref !== undefined) return autoChildJS.__ref;
        return (autoChildJS.__ref = @com.smartgwt.client.util.ObjectFactory::createFormItem(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(autoChildJS.getClassName(), autoChildJS));
    }-*/;

    /**
     * Returns the <code>DrawItem</code> AutoChild named <code>autoChildName</code> if already created.
     *
     * @param autoChildName name of an AutoChild to return.
     * @throws RuntimeException if the AutoChild is not a &#83;martClient <code>DrawItem</code> object.
     */
    public native final DrawItem getDrawItemAutoChild(String autoChildName) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var autoChildJS = self[autoChildName];
        if (autoChildJS == null) return null;
        if (!$wnd.isc.isA.DrawItem(autoChildJS)) throw @java.lang.RuntimeException::new(Ljava/lang/String;)("The '" + autoChildName + "' AutoChild is not a DrawItem.");

        // getDrawItemAutoChild() should return the same Object.
        if (autoChildJS.__ref !== undefined) return autoChildJS.__ref;
        return (autoChildJS.__ref = @com.smartgwt.client.widgets.drawing.DrawPane::createDrawItem(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(autoChildJS.getClassName(), autoChildJS));
    }-*/;

    /**
     * If {@link com.smartgwt.client.widgets.drawing.DrawItem#getProportionalResizing proportionalResizing} is set to
     * {@link com.smartgwt.client.types.ProportionalResizeMode#MODIFIER} or
     * {@link com.smartgwt.client.types.ProportionalResizeMode#MODIFIER_OFF} then proportional resizing of the DrawItem
     * is activated or deactivated, respectively, whenever at least one key in this set of modifier keys is pressed.
     * <p>
     * The keys allowed in this set are:  "Alt", "Ctrl", and "Shift".  If this set of keys is empty then proportional
     * resizing is always used if <code>proportionalResizing</code> is <code>MODIFIER</code> and is never used if
     * <code>proportionalResizing</code> is <code>MODIFIER_OFF</code>.
     *
     * @param proportionalResizeModifiers  Default value is ["Shift"]
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setProportionalResizeModifiers(String... proportionalResizeModifiers) throws IllegalStateException {
        setAttribute("proportionalResizeModifiers", proportionalResizeModifiers, false);
    }

    /**
     * If {@link com.smartgwt.client.widgets.drawing.DrawItem#getProportionalResizing proportionalResizing} is set to
     * {@link com.smartgwt.client.types.ProportionalResizeMode#MODIFIER} or
     * {@link com.smartgwt.client.types.ProportionalResizeMode#MODIFIER_OFF} then proportional resizing of the DrawItem
     * is activated or deactivated, respectively, whenever at least one key in this set of modifier keys is pressed.
     * <p>
     * The keys allowed in this set are:  "Alt", "Ctrl", and "Shift".  If this set of keys is empty then proportional
     * resizing is always used if <code>proportionalResizing</code> is <code>MODIFIER</code> and is never used if
     * <code>proportionalResizing</code> is <code>MODIFIER_OFF</code>.
     *
     * @return String...
     */
    public String[] getProportionalResizeModifiers()  {
        return getAttributeAsStringArray("proportionalResizeModifiers");
    }

}


