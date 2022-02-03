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
import com.smartgwt.logicalstructure.widgets.rte.*;
import com.smartgwt.logicalstructure.widgets.ace.*;
import com.smartgwt.logicalstructure.widgets.tab.*;
import com.smartgwt.logicalstructure.widgets.tableview.*;
import com.smartgwt.logicalstructure.widgets.toolbar.*;
import com.smartgwt.logicalstructure.widgets.tree.*;
import com.smartgwt.logicalstructure.widgets.viewer.*;
import com.smartgwt.logicalstructure.widgets.calendar.*;
import com.smartgwt.logicalstructure.widgets.cube.*;
import com.smartgwt.logicalstructure.widgets.tools.*;
import com.smartgwt.logicalstructure.widgets.tour.*;

/**
 * Base class for graphical elements drawn in a DrawPane.  All properties and methods documented here are available on all
 * DrawItems unless otherwise specified. <P> Each DrawItem has its own local transform that maps its  {@link
 * com.smartgwt.client.widgets.drawing.DrawItem local coordinate system} to the drawing coordinate system that is shared by
 * all DrawItems in the same DrawPane (explained {@link com.smartgwt.client.widgets.drawing.DrawPane here}).  The local
 * transform is a combination of rotation, scaling, and other affine transformations.  The DrawItem is first {@link
 * com.smartgwt.client.widgets.drawing.DrawItem#getTranslate translated}, then {@link
 * com.smartgwt.client.widgets.drawing.DrawItem#getScale scaled}, then {@link
 * com.smartgwt.client.widgets.drawing.DrawItem#getXShearFactor sheared} in the direction of the x-axis, then {@link
 * com.smartgwt.client.widgets.drawing.DrawItem#getYShearFactor sheared} in the directiton of the y-axis, and then finally
 * {@link com.smartgwt.client.widgets.drawing.DrawItem#getRotation rotated}. <P> Note that DrawItems as such should never
 * be created, only concrete subclasses such as {@link com.smartgwt.client.widgets.drawing.DrawGroup} and {@link
 * com.smartgwt.client.widgets.drawing.DrawLine}. <P> See {@link com.smartgwt.client.widgets.drawing.DrawPane} for the
 * different approaches to create DrawItems.
 */
@BeanFactory.FrameworkClass
@BeanFactory.ScClassName("DrawItem")
public class DrawItem extends BaseWidget implements com.smartgwt.client.widgets.drawing.events.HasClickHandlers, com.smartgwt.client.widgets.drawing.events.HasDrawEndHandlers, com.smartgwt.client.widgets.drawing.events.HasDrawStartHandlers, com.smartgwt.client.widgets.drawing.events.HasMouseDownHandlers, com.smartgwt.client.widgets.drawing.events.HasMouseMoveHandlers, com.smartgwt.client.widgets.drawing.events.HasMouseOutHandlers, com.smartgwt.client.widgets.drawing.events.HasMouseOverHandlers, com.smartgwt.client.widgets.drawing.events.HasMouseUpHandlers, com.smartgwt.client.widgets.drawing.events.HasMovedHandlers, com.smartgwt.client.widgets.drawing.events.HasDragMoveHandlers, com.smartgwt.client.widgets.drawing.events.HasDragResizeMoveHandlers, com.smartgwt.client.widgets.drawing.events.HasDragResizeStartHandlers, com.smartgwt.client.widgets.drawing.events.HasDragResizeStopHandlers, com.smartgwt.client.widgets.drawing.events.HasDragStartHandlers, com.smartgwt.client.widgets.drawing.events.HasDragStopHandlers, com.smartgwt.client.widgets.drawing.events.HasResizedHandlers, com.smartgwt.client.widgets.drawing.events.HasShowContextMenuHandlers {

    public static DrawItem getOrCreateRef(JavaScriptObject jsObj) {
        if (jsObj == null) return null;
        final BaseWidget refInstance = BaseWidget.getRef(jsObj);
        if (refInstance == null) {
            return new DrawItem(jsObj);
        } else {
            assert refInstance instanceof DrawItem;
            return (DrawItem)refInstance;
        }
    }
    /** 
     * This method returns a Map of config properties suitable for use as the "defaults" 
     * attribute of a {@link com.smartgwt.client.tools.PaletteNode}.  Use it when you need to
     * work with PaletteNodes indirectly, such when setting up 
     * {@link com.smartgwt.client.widgets.tile.TileRecord}s that will be used in a 
     * {@link com.smartgwt.client.tools.TilePalette}.  See 
     * {@link com.smartgwt.client.docs.DevTools the dev tools overview} for examples of how to
     * assemble and acquire a suitable defaults object when you are creating a PaletteNode 
     * indirectly
     */
    public Map getPaletteDefaults() {
        if (isCreated()) {
            ConfigUtil.warnOfPreConfigInstantiation(this.getClass(), "getPaletteDefaults", (String)null);
        }
        return JSOHelper.convertToMap(JSOHelper.cleanProperties(getConfig(), true));
    }
        


    /**
     * Changes the defaults for Canvas AutoChildren named <code>autoChildName</code>.
     *
     * @param autoChildName name of an AutoChild to customize the defaults for.
     * @param defaults Canvas defaults to apply. These defaults override any existing properties
     * without destroying or wiping out non-overridden properties.  For usage tips on this
     * param, see {@link com.smartgwt.client.docs.SGWTProperties}.
     * @see com.smartgwt.client.docs.AutoChildUsage
     */
    public static native void changeAutoChildDefaults(String autoChildName, Canvas defaults) /*-{
        if (defaults.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(DrawItem.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "Canvas");
        }
        defaults.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
        var cleanDefaultsJS = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(defaults.@com.smartgwt.client.widgets.BaseWidget::getConfig()(), true);
        $wnd.isc.DrawItem.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
    }-*/;

    /**
     * Changes the defaults for FormItem AutoChildren named <code>autoChildName</code>.
     *
     * @param autoChildName name of an AutoChild to customize the defaults for.
     * @param defaults FormItem defaults to apply. These defaults override any existing properties
     * without destroying or wiping out non-overridden properties.  For usage tips on this
     * param, see {@link com.smartgwt.client.docs.SGWTProperties}.
     * @see com.smartgwt.client.docs.AutoChildUsage
     */
    public static native void changeAutoChildDefaults(String autoChildName, FormItem defaults) /*-{
        if (defaults.@com.smartgwt.client.widgets.form.fields.FormItem::isCreated()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(DrawItem.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "FormItem");
        }
        defaults.@com.smartgwt.client.widgets.form.fields.FormItem::setConfigOnly(Z)(true);
    	var cleanDefaultsJS = defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getEditorTypeConfig()();
        $wnd.isc.DrawItem.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
    }-*/;
    /**
     * Changes the defaults for DrawItem AutoChildren named <code>autoChildName</code>.
     *
     * @param autoChildName name of an AutoChild to customize the defaults for.
     * @param defaults DrawItem defaults to apply. These defaults override any existing properties
     * without destroying or wiping out non-overridden properties.  For usage tips on this
     * param, see {@link com.smartgwt.client.docs.SGWTProperties}.
     * @see com.smartgwt.client.docs.AutoChildUsage
     */
    public static native void changeAutoChildDefaults(String autoChildName, DrawItem defaults) /*-{
        if (defaults.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(DrawItem.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "DrawItem");
        }
        defaults.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
        var cleanDefaultsJS = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(defaults.@com.smartgwt.client.widgets.BaseWidget::getConfig()(), true);
        $wnd.isc.DrawItem.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
    }-*/;

    public DrawItem(){
        scClassName = "DrawItem";
    }

    public DrawItem(JavaScriptObject jsObj){
        scClassName = "DrawItem";
        setJavaScriptObject(jsObj);
    }

    protected native JavaScriptObject create()/*-{
        var config = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
        var widget = $wnd.isc[scClassName].create(config);
        if ($wnd.isc.keepGlobals) this.@com.smartgwt.client.widgets.BaseWidget::internalSetID(Lcom/google/gwt/core/client/JavaScriptObject;)(widget);
        this.@com.smartgwt.client.widgets.BaseWidget::doInit()();
        return widget;
    }-*/;

    // ********************* Properties / Attributes ***********************

    /**
     * Is this DrawItem draggable? If true, then the DrawItem can be drag-repositioned by the user.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Setter for {@link com.smartgwt.client.widgets.drawing.DrawItem#getCanDrag canDrag}.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param canDrag new value for <code>this.canDrag</code>. Default value is false
     * @return {@link com.smartgwt.client.widgets.drawing.DrawItem DrawItem} instance, for chaining setter calls
     */
    public DrawItem setCanDrag(Boolean canDrag) {
        return (DrawItem)setAttribute("canDrag", canDrag, true);
    }

    /**
     * Is this DrawItem draggable? If true, then the DrawItem can be drag-repositioned by the user.
     *
     * @return Current canDrag value. Default value is false
     */
    public Boolean getCanDrag()  {
        Boolean result = getAttributeAsBoolean("canDrag");
        return result == null ? false : result;
    }
    

    /**
     * Will this DrawItem fire hover events when the user hovers over it?
     *
     * @param canHover New canHover value. Default value is null
     * @return {@link com.smartgwt.client.widgets.drawing.DrawItem DrawItem} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.drawing.DrawItem#setShowHover
     */
    public DrawItem setCanHover(Boolean canHover) {
        return (DrawItem)setAttribute("canHover", canHover, true);
    }

    /**
     * Will this DrawItem fire hover events when the user hovers over it?
     *
     * @return Current canHover value. Default value is null
     * @see com.smartgwt.client.widgets.drawing.DrawItem#getShowHover
     */
    public Boolean getCanHover()  {
        return getAttributeAsBoolean("canHover");
    }
    

    /**
     * Context menu to show for this object, an instance of the Menu widget. <P> Note: if {@link
     * com.smartgwt.client.widgets.Canvas#destroy Canvas.destroy()} is called on a canvas, any specified context menu is not
     * automatically destroyed as well. This is in contrast to {@link com.smartgwt.client.widgets.menu.MenuButton}s which
     * automatically destroy their specified {@link com.smartgwt.client.widgets.menu.MenuButton#getMenu MenuButton.menu} by
     * default. The behavior is intentional as context menus are commonly reused across components.
     *
     * @param contextMenu New contextMenu value. Default value is null
     * @return {@link com.smartgwt.client.widgets.drawing.DrawItem DrawItem} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.events.ShowContextMenuEvent
     * @see com.smartgwt.client.docs.Cues Cues overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#basics_interaction_contextmenu" target="examples">Context menus Example</a>
     */
    public DrawItem setContextMenu(Menu contextMenu) {
        return (DrawItem)setAttribute("contextMenu", contextMenu == null ? null : contextMenu.getOrCreateJsObj(), true);
    }

    /**
     * Context menu to show for this object, an instance of the Menu widget. <P> Note: if {@link
     * com.smartgwt.client.widgets.Canvas#destroy Canvas.destroy()} is called on a canvas, any specified context menu is not
     * automatically destroyed as well. This is in contrast to {@link com.smartgwt.client.widgets.menu.MenuButton}s which
     * automatically destroy their specified {@link com.smartgwt.client.widgets.menu.MenuButton#getMenu MenuButton.menu} by
     * default. The behavior is intentional as context menus are commonly reused across components.
     *
     * @return Current contextMenu value. Default value is null
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
     * located at corners of a bounding rectangle of current DrawItem. The default shape is a light teal circle.
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
     * @param cursor new cursor. Default value is null
     * @return {@link com.smartgwt.client.widgets.drawing.DrawItem DrawItem} instance, for chaining setter calls
     */
    public DrawItem setCursor(Cursor cursor) {
        return (DrawItem)setAttribute("cursor", cursor == null ? null : cursor.getValue(), true);
    }

    /**
     * If set, specifies the cursor to display when the mouse pointer is over this DrawItem.
     *
     * @return Current cursor value. Default value is null
     */
    public Cursor getCursor()  {
        return EnumUtil.getEnum(Cursor.values(), getAttribute("cursor"));
    }
    

    /**
     * Flag indicating a drawItem has been destroyed, similar to {@link com.smartgwt.client.widgets.Canvas#getDestroyed
     * Canvas.destroyed}.
     * <p>
     * <b>Note :</b> This method should be called only after the widget has been rendered.
     *
     * @return Current destroyed value. Default value is null
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public Boolean getDestroyed() throws IllegalStateException {
        errorIfNotCreated("destroyed");
        return getAttributeAsBoolean("destroyed");
    }
    

    /**
     * Flag indicating a drawItem is mid-destruction, similar to {@link com.smartgwt.client.widgets.Canvas#getDestroying
     * Canvas.destroying}.
     * <p>
     * <b>Note :</b> This method should be called only after the widget has been rendered.
     *
     * @return Current destroying value. Default value is null
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public Boolean getDestroying() throws IllegalStateException {
        errorIfNotCreated("destroying");
        return getAttributeAsBoolean("destroying");
    }
    

    /**
     * Number of pixels the cursor needs to move before the EventHandler starts a drag operation.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param dragStartDistance New dragStartDistance value. Default value is 5
     * @return {@link com.smartgwt.client.widgets.drawing.DrawItem DrawItem} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.Dragdrop Dragdrop overview and related methods
     */
    public DrawItem setDragStartDistance(int dragStartDistance) {
        return (DrawItem)setAttribute("dragStartDistance", dragStartDistance, true);
    }

    /**
     * Number of pixels the cursor needs to move before the EventHandler starts a drag operation.
     *
     * @return Current dragStartDistance value. Default value is 5
     * @see com.smartgwt.client.docs.Dragdrop Dragdrop overview and related methods
     */
    public int getDragStartDistance()  {
        return getAttributeAsInt("dragStartDistance");
    }
    

    /**
     * {@link com.smartgwt.client.widgets.drawing.DrawGroup} this drawItem is a member of.
     *
     * @param drawGroup New drawGroup value. Default value is null
     * @return {@link com.smartgwt.client.widgets.drawing.DrawItem DrawItem} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public DrawItem setDrawGroup(DrawGroup drawGroup)  throws IllegalStateException {
        return (DrawItem)setAttribute("drawGroup", drawGroup == null ? null : drawGroup.getOrCreateJsObj(), false);
    }

    /**
     * {@link com.smartgwt.client.widgets.drawing.DrawGroup} this drawItem is a member of.
     *
     * @return Current drawGroup value. Default value is null
     */
    public DrawGroup getDrawGroup()  {
        return (DrawGroup)DrawGroup.getByJSObject(getAttributeAsJavaScriptObject("drawGroup"));
    }
    

    /**
     * {@link com.smartgwt.client.widgets.drawing.DrawPane} this drawItem should draw in. <P> If this item has a {@link
     * com.smartgwt.client.widgets.drawing.DrawGroup}, the drawGroup's drawPane is automatically used.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Setter for {@link com.smartgwt.client.widgets.drawing.DrawItem#getDrawPane drawPane}.
     *
     * @param drawPane new value for <code>this.drawPane</code>. Default value is null
     * @return {@link com.smartgwt.client.widgets.drawing.DrawItem DrawItem} instance, for chaining setter calls
     */
    public DrawItem setDrawPane(DrawPane drawPane) {
        return (DrawItem)setAttribute("drawPane", drawPane == null ? null : drawPane.getOrCreateJsObj(), true);
    }

    /**
     * {@link com.smartgwt.client.widgets.drawing.DrawPane} this drawItem should draw in. <P> If this item has a {@link
     * com.smartgwt.client.widgets.drawing.DrawGroup}, the drawGroup's drawPane is automatically used.
     *
     * @return Current drawPane value. Default value is null
     */
    public DrawPane getDrawPane()  {
        return (DrawPane)DrawPane.getByJSObject(getAttributeAsJavaScriptObject("drawPane"));
    }
    

    /**
     * Default class used to construct the {@link com.smartgwt.client.tools.EditProxy} for this component when the component is
     * {@link com.smartgwt.client.widgets.Canvas#setEditMode first placed into edit mode}.
     *
     * @param editProxyConstructor New editProxyConstructor value. Default value is "DrawItemEditProxy"
     * @return {@link com.smartgwt.client.widgets.drawing.DrawItem DrawItem} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.SCClassName SCClassName 
     */
    public DrawItem setEditProxyConstructor(String editProxyConstructor)  throws IllegalStateException {
        return (DrawItem)setAttribute("editProxyConstructor", editProxyConstructor, false);
    }

    /**
     * Default class used to construct the {@link com.smartgwt.client.tools.EditProxy} for this component when the component is
     * {@link com.smartgwt.client.widgets.Canvas#setEditMode first placed into edit mode}.
     *
     * @return Current editProxyConstructor value. Default value is "DrawItemEditProxy"
     * @see com.smartgwt.client.docs.SCClassName SCClassName 
     */
    public String getEditProxyConstructor()  {
        return getAttributeAsString("editProxyConstructor");
    }
    

    /**
     * Style of arrow head to draw at the end of the line or path.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Set the arrowhead at the end of this path. <p> <b>NOTE:</b> Not all DrawItem classes support arrowheads. You can use {@link com.smartgwt.client.widgets.drawing.DrawItem#supportsEndArrow supportsEndArrow()} to dynamically check whether a DrawItem instance supports this method.
     *
     * @param endArrow style of arrow to use. Default value is null
     * @return {@link com.smartgwt.client.widgets.drawing.DrawItem DrawItem} instance, for chaining setter calls
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#lines_and_arrowheads" target="examples">Lines & Arrowheads Example</a>
     */
    public DrawItem setEndArrow(ArrowStyle endArrow) {
        return (DrawItem)setAttribute("endArrow", endArrow == null ? null : endArrow.getValue(), true);
    }

    /**
     * Style of arrow head to draw at the end of the line or path.
     *
     * @return Current endArrow value. Default value is null
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#lines_and_arrowheads" target="examples">Lines & Arrowheads Example</a>
     */
    public ArrowStyle getEndArrow()  {
        return EnumUtil.getEnum(ArrowStyle.values(), getAttribute("endArrow"));
    }
    

    /**
     * If this item is showing  {@link com.smartgwt.client.types.KnobType#ENDPOINT} {@link
     * com.smartgwt.client.widgets.drawing.DrawItem#getKnobs control knobs}, this attribute specifies the AutoChild for the
     * {@link com.smartgwt.client.widgets.drawing.DrawKnob} for end point of current drawItem.
     * <p>
     * This component is an AutoChild named "endKnob".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current endKnob value. Default value is null
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public DrawKnob getEndKnob() throws IllegalStateException {
        errorIfNotCreated("endKnob");
        return (DrawKnob)DrawKnob.getByJSObject(getAttributeAsJavaScriptObject("endKnob"));
    }
    

    /**
     * Should events inside this DrawItem be attributed to it regardless of which pixels are actually set, if no fill is
     * specified?  If set for DrawItems that aren't closed, will capture events occurring in the region that would filled if a
     * fill were specified. This property is true by default for closed shapes, and false for paths, lines, etc. <P>
     * <b>Note:</b> this property must be true if you're writing to an HTML5 &lt;canvas&gt; element directly in your code (only
     * applies to {@link com.smartgwt.client.types.DrawingType}  {@link com.smartgwt.client.types.DrawingType#BITMAP}).
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param eventOpaque New eventOpaque value. Default value is varies
     * @return {@link com.smartgwt.client.widgets.drawing.DrawItem DrawItem} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.drawing.DrawItem#setFillColor
     * @see com.smartgwt.client.widgets.drawing.DrawItem#setFillOpacity
     * @see com.smartgwt.client.widgets.drawing.DrawPane#getBitmap
     */
    public DrawItem setEventOpaque(boolean eventOpaque)  throws IllegalStateException {
        return (DrawItem)setAttribute("eventOpaque", eventOpaque, false);
    }

    /**
     * Should events inside this DrawItem be attributed to it regardless of which pixels are actually set, if no fill is
     * specified?  If set for DrawItems that aren't closed, will capture events occurring in the region that would filled if a
     * fill were specified. This property is true by default for closed shapes, and false for paths, lines, etc. <P>
     * <b>Note:</b> this property must be true if you're writing to an HTML5 &lt;canvas&gt; element directly in your code (only
     * applies to {@link com.smartgwt.client.types.DrawingType}  {@link com.smartgwt.client.types.DrawingType#BITMAP}).
     *
     * @return Current eventOpaque value. Default value is varies
     * @see com.smartgwt.client.widgets.drawing.DrawItem#getFillColor
     * @see com.smartgwt.client.widgets.drawing.DrawItem#getFillOpacity
     * @see com.smartgwt.client.widgets.drawing.DrawPane#getBitmap
     */
    public boolean getEventOpaque()  {
        Boolean result = getAttributeAsBoolean("eventOpaque");
        return result == null ? false : result;
    }
    

    /**
     * Fill color to use for shapes.  The default of 'null' is transparent.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Update fillColor for this drawItem.
     *
     * @param fillColor new fillColor to use.  Pass null for transparent. Default value is null
     * @return {@link com.smartgwt.client.widgets.drawing.DrawItem DrawItem} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.CSSColor CSSColor 
     */
    public DrawItem setFillColor(String fillColor) {
        return (DrawItem)setAttribute("fillColor", fillColor, true);
    }

    /**
     * Fill color to use for shapes.  The default of 'null' is transparent.
     *
     * @return Current fillColor value. Default value is null
     * @see com.smartgwt.client.docs.CSSColor CSSColor 
     */
    public String getFillColor()  {
        return getAttributeAsString("fillColor");
    }
    

    /**
     * Fill gradient to use for shapes.  If a string it uses the gradient identifier parameter provided in  {@link
     * com.smartgwt.client.widgets.drawing.DrawPane#addGradient DrawPane.addGradient()}. Otherwise it expects one of {@link
     * com.smartgwt.client.widgets.drawing.SimpleGradient SimpleGradient}, {@link
     * com.smartgwt.client.widgets.drawing.LinearGradient LinearGradient} or {@link
     * com.smartgwt.client.widgets.drawing.RadialGradient RadialGradient}.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Update fillGradient for this drawItem.
     *
     * @param fillGradient new gradient to use.  Pass null for transparent. Default value is null
     * @return {@link com.smartgwt.client.widgets.drawing.DrawItem DrawItem} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.drawing.Gradient
     */
    public DrawItem setFillGradient(Gradient fillGradient) {
        return (DrawItem)setAttribute("fillGradient", fillGradient == null ? null : fillGradient.getJsObj(), true);
    }

    /**
     * Fill gradient to use for shapes.  If a string it uses the gradient identifier parameter provided in  {@link
     * com.smartgwt.client.widgets.drawing.DrawPane#addGradient DrawPane.addGradient()}. Otherwise it expects one of {@link
     * com.smartgwt.client.widgets.drawing.SimpleGradient SimpleGradient}, {@link
     * com.smartgwt.client.widgets.drawing.LinearGradient LinearGradient} or {@link
     * com.smartgwt.client.widgets.drawing.RadialGradient RadialGradient}.
     *
     * @return Current fillGradient value. Default value is null
     * @see com.smartgwt.client.widgets.drawing.Gradient
     */
    public Gradient getFillGradient()  {
        return new Gradient(getAttributeAsJavaScriptObject("fillGradient"));
    }

    /**
     * Fill gradient to use for shapes.  If a string it uses the gradient identifier parameter provided in  {@link
     * com.smartgwt.client.widgets.drawing.DrawPane#addGradient DrawPane.addGradient()}. Otherwise it expects one of {@link
     * com.smartgwt.client.widgets.drawing.SimpleGradient SimpleGradient}, {@link
     * com.smartgwt.client.widgets.drawing.LinearGradient LinearGradient} or {@link
     * com.smartgwt.client.widgets.drawing.RadialGradient RadialGradient}.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Update fillGradient for this drawItem.
     *
     * @param fillGradient new gradient to use.  Pass null for transparent. Default value is null
     * @return {@link com.smartgwt.client.widgets.drawing.DrawItem DrawItem} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.drawing.Gradient
     */
    public DrawItem setFillGradient(String fillGradient) {
        return (DrawItem)setAttribute("fillGradient", fillGradient, true);
    }

    /**
     * Fill gradient to use for shapes.  If a string it uses the gradient identifier parameter provided in  {@link
     * com.smartgwt.client.widgets.drawing.DrawPane#addGradient DrawPane.addGradient()}. Otherwise it expects one of {@link
     * com.smartgwt.client.widgets.drawing.SimpleGradient SimpleGradient}, {@link
     * com.smartgwt.client.widgets.drawing.LinearGradient LinearGradient} or {@link
     * com.smartgwt.client.widgets.drawing.RadialGradient RadialGradient}.
     *
     * @return Current fillGradient value. Default value is null
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
     * @param fillOpacity new opacity, as a number between 0 (transparent) and 1 (opaque). Default value is 1.0
     * @return {@link com.smartgwt.client.widgets.drawing.DrawItem DrawItem} instance, for chaining setter calls
     */
    public DrawItem setFillOpacity(float fillOpacity) {
        return (DrawItem)setAttribute("fillOpacity", fillOpacity, true);
    }

    /**
     * Opacity of the fillColor, as a number between 0 (transparent) and 1 (opaque).
     *
     * @return Current fillOpacity value. Default value is 1.0
     */
    public float getFillOpacity()  {
        return getAttributeAsFloat("fillOpacity");
    }
    

    /**
     * If <code>this.canHover</code> is true, how long should the mouse be kept over this widget before the hover event is
     * fired
     *
     * @param hoverDelay New hoverDelay value. Default value is 300
     * @return {@link com.smartgwt.client.widgets.drawing.DrawItem DrawItem} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.drawing.DrawItem#setCanHover
     * @see com.smartgwt.client.widgets.drawing.DrawItem#hover
     */
    public DrawItem setHoverDelay(int hoverDelay) {
        return (DrawItem)setAttribute("hoverDelay", hoverDelay, true);
    }

    /**
     * If <code>this.canHover</code> is true, how long should the mouse be kept over this widget before the hover event is
     * fired
     *
     * @return Current hoverDelay value. Default value is 300
     * @see com.smartgwt.client.widgets.drawing.DrawItem#getCanHover
     * @see com.smartgwt.client.widgets.drawing.DrawItem#hover
     */
    public int getHoverDelay()  {
        return getAttributeAsInt("hoverDelay");
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
     * @param keepInParentRect New keepInParentRect value. Default value is null
     * @return {@link com.smartgwt.client.widgets.drawing.DrawItem DrawItem} instance, for chaining setter calls
     */
    public DrawItem setKeepInParentRect(Boolean keepInParentRect) {
        return (DrawItem)setAttribute("keepInParentRect", keepInParentRect, true);
    }

    /**
     * Constrains drag-resizing and drag-repositioning of this draw item to either the current visible area of the {@link
     * com.smartgwt.client.widgets.drawing.DrawPane draw pane} or an arbitrary bounding box (if set to an array of the form
     * <code>[left, top, left + width, top + height]</code>).  When using a bounding box-type argument the left/top values can
     * be negative, or the width/height values can be greater than the dimensions of the viewable area, to allow positioning or
     * resizing the draw item beyond the confines of the draw pane. <P> Note:  keepInParentRect affects only user drag
     * interactions, not programmatic moves or resizes.
     *
     * @return Current keepInParentRect value. Default value is null
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
     * @param keepInParentRect New keepInParentRect value. Default value is null
     * @return {@link com.smartgwt.client.widgets.drawing.DrawItem DrawItem} instance, for chaining setter calls
     */
    public DrawItem setKeepInParentRect(float... keepInParentRect) {
        return (DrawItem)setAttribute("keepInParentRect", keepInParentRect, true);
    }
    

    /**
     * Array of control knobs to display for this item. Each {@link com.smartgwt.client.types.KnobType} specified in this array
     * will turn on UI element(s) allowing the user to manipulate this drawItem.  To update the set of knobs at runtime use
     * {@link com.smartgwt.client.widgets.drawing.DrawItem#showKnobs showKnobs()} and {@link
     * com.smartgwt.client.widgets.drawing.DrawItem#hideKnobs hideKnobs()}. <p> <b>NOTE:</b> Unless otherwise documented,
     * DrawItem types only support  {@link com.smartgwt.client.types.KnobType#RESIZE} and {@link
     * com.smartgwt.client.types.KnobType#MOVE} knobs.
     *
     * @param knobs New knobs value. Default value is null
     * @return {@link com.smartgwt.client.widgets.drawing.DrawItem DrawItem} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * 
     * 
     */
    public DrawItem setKnobs(KnobType... knobs)  throws IllegalStateException {
        return (DrawItem)setAttribute("knobs", knobs, false);
    }

    /**
     * Array of control knobs to display for this item. Each {@link com.smartgwt.client.types.KnobType} specified in this array
     * will turn on UI element(s) allowing the user to manipulate this drawItem.  To update the set of knobs at runtime use
     * {@link com.smartgwt.client.widgets.drawing.DrawItem#showKnobs showKnobs()} and {@link
     * com.smartgwt.client.widgets.drawing.DrawItem#hideKnobs hideKnobs()}. <p> <b>NOTE:</b> Unless otherwise documented,
     * DrawItem types only support  {@link com.smartgwt.client.types.KnobType#RESIZE} and {@link
     * com.smartgwt.client.types.KnobType#MOVE} knobs.
     *
     * @return Current knobs value. Default value is null
     * 
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
     * @return {@link com.smartgwt.client.widgets.drawing.DrawItem DrawItem} instance, for chaining setter calls
     */
    public DrawItem setLineCap(LineCap lineCap) {
        return (DrawItem)setAttribute("lineCap", lineCap == null ? null : lineCap.getValue(), true);
    }

    /**
     * Style of drawing the endpoints of a line. <P> Note that for dashed and dotted lines, the lineCap style affects each dash
     * or dot.
     *
     * @return Current lineCap value. Default value is "round"
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
     * @param lineColor new line color.  Pass null for transparent. Default value is "#808080"
     * @return {@link com.smartgwt.client.widgets.drawing.DrawItem DrawItem} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.CSSColor CSSColor 
     */
    public DrawItem setLineColor(String lineColor) {
        return (DrawItem)setAttribute("lineColor", lineColor, true);
    }

    /**
     * Line color
     *
     * @return Current lineColor value. Default value is "#808080"
     * @see com.smartgwt.client.docs.CSSColor CSSColor 
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
     * @param lineOpacity new opacity, as a number between 0 (transparent) and 1 (opaque). Default value is 1.0
     * @return {@link com.smartgwt.client.widgets.drawing.DrawItem DrawItem} instance, for chaining setter calls
     */
    public DrawItem setLineOpacity(float lineOpacity) {
        return (DrawItem)setAttribute("lineOpacity", lineOpacity, true);
    }

    /**
     * Opacity for lines, as a number between 0 (transparent) and 1 (opaque).
     *
     * @return Current lineOpacity value. Default value is 1.0
     */
    public float getLineOpacity()  {
        return getAttributeAsFloat("lineOpacity");
    }
    

    /**
     * Pattern for lines, eg "solid" or "dash". <P> Note that support in old browsers, such as Internet Explorer versions
     * before IE11, is limited for {@link com.smartgwt.client.widgets.drawing.DrawPane#getDrawingType drawingType} "bitmap" to
     * items with straight edges - {@link com.smartgwt.client.widgets.drawing.DrawLine}s, {@link
     * com.smartgwt.client.widgets.drawing.DrawPath}s, and {@link com.smartgwt.client.widgets.drawing.DrawRect}s with no 
     * {@link com.smartgwt.client.widgets.drawing.DrawRect#getRounding rounding}.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Update linePattern for this drawItem.
     *
     * @param linePattern new linePattern to use. Default value is "solid"
     * @return {@link com.smartgwt.client.widgets.drawing.DrawItem DrawItem} instance, for chaining setter calls
     */
    public DrawItem setLinePattern(LinePattern linePattern) {
        return (DrawItem)setAttribute("linePattern", linePattern == null ? null : linePattern.getValue(), true);
    }

    /**
     * Pattern for lines, eg "solid" or "dash". <P> Note that support in old browsers, such as Internet Explorer versions
     * before IE11, is limited for {@link com.smartgwt.client.widgets.drawing.DrawPane#getDrawingType drawingType} "bitmap" to
     * items with straight edges - {@link com.smartgwt.client.widgets.drawing.DrawLine}s, {@link
     * com.smartgwt.client.widgets.drawing.DrawPath}s, and {@link com.smartgwt.client.widgets.drawing.DrawRect}s with no 
     * {@link com.smartgwt.client.widgets.drawing.DrawRect#getRounding rounding}.
     *
     * @return Current linePattern value. Default value is "solid"
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
     * @return {@link com.smartgwt.client.widgets.drawing.DrawItem DrawItem} instance, for chaining setter calls
     */
    public DrawItem setLineWidth(int lineWidth) {
        return (DrawItem)setAttribute("lineWidth", lineWidth, true);
    }

    /**
     * Pixel width for lines.
     *
     * @return Current lineWidth value. Default value is 3
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
     * This component is an AutoChild named "moveKnob".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current moveKnob value. Default value is null
     * @throws IllegalStateException if this widget has not yet been rendered.
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
     * 0}</code> is assumed. Default value is null
     * @return {@link com.smartgwt.client.widgets.drawing.DrawItem DrawItem} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.drawing.DrawItem#setMoveKnobPoint
     */
    public DrawItem setMoveKnobOffset(int[] moveKnobOffset) {
        return (DrawItem)setAttribute("moveKnobOffset", moveKnobOffset, true);
    }

    /**
     * If this item is showing a <code>"move"</code> {@link com.smartgwt.client.widgets.drawing.DrawItem#getKnobs control
     * knob}, this attribute allows you to specify an offset in pixels from the {@link
     * com.smartgwt.client.widgets.drawing.DrawItem#getMoveKnobPoint moveKnobPoint} for the move knob. Offset should be
     * specified as a 2-element array of [left offset, top offset]. <p> This offset overrides the built-in offset used when
     * showing both resize and move knobs.
     *
     * @return Current moveKnobOffset value. Default value is null
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
     * @param moveKnobPoint New moveKnobPoint value. Default value is "TL"
     * @return {@link com.smartgwt.client.widgets.drawing.DrawItem DrawItem} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.drawing.DrawItem#setMoveKnobOffset
     */
    public DrawItem setMoveKnobPoint(MoveKnobPoint moveKnobPoint)  throws IllegalStateException {
        return (DrawItem)setAttribute("moveKnobPoint", moveKnobPoint == null ? null : moveKnobPoint.getValue(), false);
    }

    /**
     * If this item is showing a  {@link com.smartgwt.client.types.KnobType#MOVE} {@link
     * com.smartgwt.client.widgets.drawing.DrawItem#getKnobs control knob}, this attribute specifies where the knob should
     * appear with respect to the draw item. <p> The resize and move knobs show at the same position by default. However, when
     * both knobs are shown the move knob is offset slightly to allow access to both. This position can be adjusted manually
     * with {@link com.smartgwt.client.widgets.drawing.DrawItem#getMoveKnobOffset moveKnobOffset}.
     *
     * @return Current moveKnobPoint value. Default value is "TL"
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
     * @param prompt New prompt value. Default value is null
     * @return {@link com.smartgwt.client.widgets.drawing.DrawItem DrawItem} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public DrawItem setPrompt(String prompt) {
        return (DrawItem)setAttribute("prompt", prompt, true);
    }

    /**
     * Default {@link com.smartgwt.client.widgets.drawing.DrawItem#getHoverHTML hover HTML} that is displayed in the global
     * hover canvas if the user hovers over this DrawItem and {@link com.smartgwt.client.widgets.drawing.DrawItem#getShowHover
     * showHover} is true.
     *
     * @return Current prompt value. Default value is null
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
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
     * @param proportionalResizing New proportionalResizing value. Default value is "modifier"
     * @return {@link com.smartgwt.client.widgets.drawing.DrawItem DrawItem} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public DrawItem setProportionalResizing(ProportionalResizeMode proportionalResizing)  throws IllegalStateException {
        return (DrawItem)setAttribute("proportionalResizing", proportionalResizing == null ? null : proportionalResizing.getValue(), false);
    }

    /**
     * This property specifies the conditions for when proportional resizing is used. <p> By default the DrawItem is forced to
     * only resize proportionally while any modifier key specified in {@link
     * com.smartgwt.client.widgets.drawing.DrawItem#getProportionalResizeModifiers proportionalResizeModifiers} is pressed. 
     * For example, the DrawItem will change its width and height by the same percentage as long as the "Shift" key is held
     * down. <p> Note that this property only has an effect if the DrawItem is showing  {@link
     * com.smartgwt.client.types.KnobType#RESIZE} {@link com.smartgwt.client.widgets.drawing.DrawItem#getKnobs control knobs}.
     *
     * @return Current proportionalResizing value. Default value is "modifier"
     */
    public ProportionalResizeMode getProportionalResizing()  {
        return EnumUtil.getEnum(ProportionalResizeMode.values(), getAttribute("proportionalResizing"));
    }
    

    /**
     * If this item is showing  {@link com.smartgwt.client.types.KnobType#RESIZE} {@link
     * com.smartgwt.client.widgets.drawing.DrawItem#getKnobs control knobs}, this attribute specifies the points with respect
     * to the draw item where resize knobs should appear.
     *
     * @param resizeKnobPoints New resizeKnobPoints value. Default value is ["TL","TR","BL","BR","T","R","B","L"]
     * @return {@link com.smartgwt.client.widgets.drawing.DrawItem DrawItem} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public DrawItem setResizeKnobPoints(ResizeKnobPoint... resizeKnobPoints)  throws IllegalStateException {
        return (DrawItem)setAttribute("resizeKnobPoints", resizeKnobPoints, false);
    }

    /**
     * If this item is showing  {@link com.smartgwt.client.types.KnobType#RESIZE} {@link
     * com.smartgwt.client.widgets.drawing.DrawItem#getKnobs control knobs}, this attribute specifies the points with respect
     * to the draw item where resize knobs should appear.
     *
     * @return Current resizeKnobPoints value. Default value is ["TL","TR","BL","BR","T","R","B","L"]
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
     * This component is an AutoChild named "resizeOutline".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current resizeOutline value. Default value is null
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public DrawRect getResizeOutline() throws IllegalStateException {
        errorIfNotCreated("resizeOutline");
        return (DrawRect)DrawRect.getByJSObject(getAttributeAsJavaScriptObject("resizeOutline"));
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
     * @param resizeViaLocalTransformOnly New resizeViaLocalTransformOnly value. Default value is false
     * @return {@link com.smartgwt.client.widgets.drawing.DrawItem DrawItem} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public DrawItem setResizeViaLocalTransformOnly(boolean resizeViaLocalTransformOnly)  throws IllegalStateException {
        return (DrawItem)setAttribute("resizeViaLocalTransformOnly", resizeViaLocalTransformOnly, false);
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
     * @return Current resizeViaLocalTransformOnly value. Default value is false
     */
    public boolean getResizeViaLocalTransformOnly()  {
        Boolean result = getAttributeAsBoolean("resizeViaLocalTransformOnly");
        return result == null ? false : result;
    }
    

    /**
     * If this item is showing  {@link com.smartgwt.client.types.KnobType#ROTATE} {@link
     * com.smartgwt.client.widgets.drawing.DrawItem#getKnobs control knobs}, this attribute specifies the AutoChild for the
     * {@link com.smartgwt.client.widgets.drawing.DrawKnob} that allows a user to rotate the DrawItem with help of a knob
     * located above. Default rotate knob shape is green circle.
     * <p>
     * This component is an AutoChild named "rotateKnob".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current rotateKnob value. Default value is null
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public DrawKnob getRotateKnob() throws IllegalStateException {
        errorIfNotCreated("rotateKnob");
        return (DrawKnob)DrawKnob.getByJSObject(getAttributeAsJavaScriptObject("rotateKnob"));
    }
    

    /**
     * Rotation in degrees about the {@link com.smartgwt.client.widgets.drawing.DrawItem#getCenter center point}. The positive
     * direction is clockwise.
     *
     * @param rotation New rotation value. Default value is 0.0
     * @return {@link com.smartgwt.client.widgets.drawing.DrawItem DrawItem} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @deprecated  {@link com.smartgwt.client.docs.GwtFloatVsDouble GwtFloatVsDouble}
     */
    public DrawItem setRotation(float rotation)  throws IllegalStateException {
        return (DrawItem)setAttribute("rotation", rotation, false);
    }

    /**
     * Rotation in degrees about the {@link com.smartgwt.client.widgets.drawing.DrawItem#getCenter center point}. The positive
     * direction is clockwise.
     *
     * @return Current rotation value. Default value is 0.0
     * @deprecated  {@link com.smartgwt.client.docs.GwtFloatVsDouble GwtFloatVsDouble}
     */
    public float getRotation()  {
        return getAttributeAsFloat("rotation");
    }

    /**
     * Rotation in degrees about the {@link com.smartgwt.client.widgets.drawing.DrawItem#getCenter center point}. The positive
     * direction is clockwise.
     *
     * @param rotation New rotation value. Default value is 0.0
     * @return {@link com.smartgwt.client.widgets.drawing.DrawItem DrawItem} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public DrawItem setRotation(double rotation)  throws IllegalStateException {
        return (DrawItem)setAttribute("rotation", rotation, false);
    }

    /**
     * Rotation in degrees about the {@link com.smartgwt.client.widgets.drawing.DrawItem#getCenter center point}. The positive
     * direction is clockwise.
     *
     * @return Current rotation value. Default value is 0.0
     */
    public double getRotationAsDouble()  {
        return getAttributeAsDouble("rotation");
    }
    

    /**
     * Array holds 2 values representing scaling along x and y dimensions.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param scale New scale value. Default value is null
     * @return {@link com.smartgwt.client.widgets.drawing.DrawItem DrawItem} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public DrawItem setScale(float[] scale)  throws IllegalStateException {
        return (DrawItem)setAttribute("scale", scale, false);
    }

    /**
     * Array holds 2 values representing scaling along x and y dimensions.
     *
     * @return Current scale value. Default value is null
     */
    public float[] getScale()  {
        return com.smartgwt.client.util.ConvertTo.arrayOffloat(getAttributeAsJavaScriptObject("scale"));
    }
    

    /**
     * Shadow used for all DrawItem subtypes.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Update shadow for this drawItem.
     *
     * @param shadow new shadow. Default value is null
     * @return {@link com.smartgwt.client.widgets.drawing.DrawItem DrawItem} instance, for chaining setter calls
     * 
     */
    public DrawItem setShadow(Shadow shadow) {
        return (DrawItem)setAttribute("shadow", shadow == null ? null : shadow.getJsObj(), true);
    }

    /**
     * Shadow used for all DrawItem subtypes.
     *
     * @return Current shadow value. Default value is null
     * 
     */
    public Shadow getShadow()  {
        return new Shadow(getAttributeAsJavaScriptObject("shadow"));
    }
    

    /**
     * An opaque object specifying the local transformation that should be applied to this <code>DrawItem</code>, obtained
     * through a call to {@link com.smartgwt.client.widgets.drawing.DrawItem#getShapeData getShapeData()}.<p> <b>Note:</b> if
     * this property is specified, you should avoid also specifying a {@link
     * com.smartgwt.client.widgets.drawing.DrawItem#getTranslate translate}, {@link
     * com.smartgwt.client.widgets.drawing.DrawItem#getScale scale}, {@link
     * com.smartgwt.client.widgets.drawing.DrawItem#getXShearFactor xShearFactor}, {@link
     * com.smartgwt.client.widgets.drawing.DrawItem#getYShearFactor yShearFactor}, or {@link
     * com.smartgwt.client.widgets.drawing.DrawItem#getRotation rotation}.
     *
     * @param shapeData New shapeData value. Default value is null
     * @return {@link com.smartgwt.client.widgets.drawing.DrawItem DrawItem} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public DrawItem setShapeData(Map shapeData)  throws IllegalStateException {
        return (DrawItem)setAttribute("shapeData", shapeData, false);
    }
    

    /**
     * If {@link com.smartgwt.client.widgets.drawing.DrawItem#getCanHover canHover} is true, should we show the global hover
     * canvas by default when the user hovers over this DrawItem?
     *
     * @param showHover New showHover value. Default value is true
     * @return {@link com.smartgwt.client.widgets.drawing.DrawItem DrawItem} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.drawing.DrawItem#getHoverHTML
     */
    public DrawItem setShowHover(boolean showHover) {
        return (DrawItem)setAttribute("showHover", showHover, true);
    }

    /**
     * If {@link com.smartgwt.client.widgets.drawing.DrawItem#getCanHover canHover} is true, should we show the global hover
     * canvas by default when the user hovers over this DrawItem?
     *
     * @return Current showHover value. Default value is true
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
     * @param showResizeOutline New showResizeOutline value. Default value is true
     * @return {@link com.smartgwt.client.widgets.drawing.DrawItem DrawItem} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.drawing.DrawItem#setResizeOutline
     */
    public DrawItem setShowResizeOutline(boolean showResizeOutline) {
        return (DrawItem)setAttribute("showResizeOutline", showResizeOutline, true);
    }

    /**
     * If this item is showing  {@link com.smartgwt.client.types.KnobType#RESIZE} {@link
     * com.smartgwt.client.widgets.drawing.DrawItem#getKnobs control knobs} will the resize outline be shown or not.
     *
     * @return Current showResizeOutline value. Default value is true
     * @see com.smartgwt.client.widgets.drawing.DrawItem#getResizeOutline
     */
    public boolean getShowResizeOutline()  {
        Boolean result = getAttributeAsBoolean("showResizeOutline");
        return result == null ? true : result;
    }
    

    /**
     * If the {@link com.smartgwt.client.widgets.drawing.DrawItem#getTitleLabel titleLabel} is showing, should the {@link
     * com.smartgwt.client.widgets.drawing.DrawItem#getTitleLabelBackground titleLabelBackground} be created and placed behind
     * the <code>titleLabel</code>? <p> This defaults to true for {@link com.smartgwt.client.widgets.drawing.DrawSector}s and
     * shapes that are not commonly filled (e.g. {@link com.smartgwt.client.widgets.drawing.DrawLine}s).
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param showTitleLabelBackground New showTitleLabelBackground value. Default value is false
     * @return {@link com.smartgwt.client.widgets.drawing.DrawItem DrawItem} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public DrawItem setShowTitleLabelBackground(boolean showTitleLabelBackground)  throws IllegalStateException {
        return (DrawItem)setAttribute("showTitleLabelBackground", showTitleLabelBackground, false);
    }

    /**
     * If the {@link com.smartgwt.client.widgets.drawing.DrawItem#getTitleLabel titleLabel} is showing, should the {@link
     * com.smartgwt.client.widgets.drawing.DrawItem#getTitleLabelBackground titleLabelBackground} be created and placed behind
     * the <code>titleLabel</code>? <p> This defaults to true for {@link com.smartgwt.client.widgets.drawing.DrawSector}s and
     * shapes that are not commonly filled (e.g. {@link com.smartgwt.client.widgets.drawing.DrawLine}s).
     *
     * @return Current showTitleLabelBackground value. Default value is false
     */
    public boolean getShowTitleLabelBackground()  {
        Boolean result = getAttributeAsBoolean("showTitleLabelBackground");
        return result == null ? false : result;
    }
    

    /**
     * <b>Note :</b> This API is non-functional (always returns null) and exists only to make
     * you aware that this MultiAutoChild exists.  See {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}
     * for details.
     * <p>
     * If this item is showing  {@link com.smartgwt.client.types.KnobType#RESIZE} {@link
     * com.smartgwt.client.widgets.drawing.DrawItem#getKnobs control knobs}, this attribute specifies the MultiAutoChild for
     * the {@link com.smartgwt.client.widgets.drawing.DrawKnob} that allows a user to resize the DrawItem with help of knobs
     * located at centers of edges of a bounding rectangle of current DrawItem. The default shape is a light teal square.
     *
     * @return null
     */
    public DrawKnob getSideResizeKnob()  {
        return null;
    }
    

    /**
     * Style of arrow head to draw at the beginning of the line or path.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Set the arrowhead at the beginning of this path. <p> <b>NOTE:</b> Not all DrawItem classes support arrowheads. You can use {@link com.smartgwt.client.widgets.drawing.DrawItem#supportsStartArrow supportsStartArrow()} to dynamically check whether a DrawItem instance supports this method.
     *
     * @param startArrow style of arrow to use. Default value is null
     * @return {@link com.smartgwt.client.widgets.drawing.DrawItem DrawItem} instance, for chaining setter calls
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#lines_and_arrowheads" target="examples">Lines & Arrowheads Example</a>
     */
    public DrawItem setStartArrow(ArrowStyle startArrow) {
        return (DrawItem)setAttribute("startArrow", startArrow == null ? null : startArrow.getValue(), true);
    }

    /**
     * Style of arrow head to draw at the beginning of the line or path.
     *
     * @return Current startArrow value. Default value is null
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#lines_and_arrowheads" target="examples">Lines & Arrowheads Example</a>
     */
    public ArrowStyle getStartArrow()  {
        return EnumUtil.getEnum(ArrowStyle.values(), getAttribute("startArrow"));
    }
    

    /**
     * If this item is showing  {@link com.smartgwt.client.types.KnobType#STARTPOINT} {@link
     * com.smartgwt.client.widgets.drawing.DrawItem#getKnobs control knobs}, this attribute specifies the AutoChild for the
     * {@link com.smartgwt.client.widgets.drawing.DrawKnob} for start point of current drawItem.
     * <p>
     * This component is an AutoChild named "startKnob".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current startKnob value. Default value is null
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public DrawKnob getStartKnob() throws IllegalStateException {
        errorIfNotCreated("startKnob");
        return (DrawKnob)DrawKnob.getByJSObject(getAttributeAsJavaScriptObject("startKnob"));
    }
    

    /**
     * A string to show at the {@link com.smartgwt.client.widgets.drawing.DrawItem#getCenter center point} of this
     * <code>DrawItem</code>. <p> When set to a non-null value (including an empty string), the {@link
     * com.smartgwt.client.widgets.drawing.DrawItem#getTitleLabel titleLabel} {@link
     * com.smartgwt.client.widgets.drawing.DrawLabel} AutoChild will be created automatically and positioned at the center of
     * this <code>DrawItem</code>.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Setter for the {@link com.smartgwt.client.widgets.drawing.DrawItem#getTitle title} of this <code>DrawItem</code>.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param title new <code>title</code>. Default value is null
     * @see com.smartgwt.client.widgets.drawing.DrawItem#setTitleRotationMode
     */
    public void setTitle(String title) {
        setAttribute("title", title, true);
    }

    /**
     * A string to show at the {@link com.smartgwt.client.widgets.drawing.DrawItem#getCenter center point} of this
     * <code>DrawItem</code>. <p> When set to a non-null value (including an empty string), the {@link
     * com.smartgwt.client.widgets.drawing.DrawItem#getTitleLabel titleLabel} {@link
     * com.smartgwt.client.widgets.drawing.DrawLabel} AutoChild will be created automatically and positioned at the center of
     * this <code>DrawItem</code>.
     *
     * @return Current title value. Default value is null
     * @see com.smartgwt.client.widgets.drawing.DrawItem#getTitleRotationMode
     */
    public String getTitle()  {
        return getAttributeAsString("title");
    }
    

    /**
     * Whether the {@link com.smartgwt.client.widgets.drawing.DrawItem#getTitleLabel titleLabel} should be scaled to the
     * maximum possible size that fits inside the bounds of this item.  Currently only {@link
     * com.smartgwt.client.widgets.drawing.DrawRect}s and {@link com.smartgwt.client.widgets.drawing.DrawPolygon}s with 90
     * degree angles are supported. <P> Note that {@link com.smartgwt.client.widgets.drawing.DrawItem#getTitleAutoFit
     * titleAutoFit} isn't supported for rotated, sheared, or scaled {@link com.smartgwt.client.widgets.drawing.DrawItem}s, and
     * that therefore the value of {@link com.smartgwt.client.types.TitleRotationMode}, which relates to rotation of the item,
     * is ignored when this property is set.  However, we do support having the label automatically rotate to run vertically if
     * there's more space - see {@link com.smartgwt.client.widgets.drawing.DrawItem#getTitleAutoFitRotationMode
     * titleAutoFitRotationMode}.
     *
     * @param titleAutoFit New titleAutoFit value. Default value is false
     * @return {@link com.smartgwt.client.widgets.drawing.DrawItem DrawItem} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.drawing.DrawItem#setTitleLabel
     */
    public DrawItem setTitleAutoFit(boolean titleAutoFit)  throws IllegalStateException {
        return (DrawItem)setAttribute("titleAutoFit", titleAutoFit, false);
    }

    /**
     * Whether the {@link com.smartgwt.client.widgets.drawing.DrawItem#getTitleLabel titleLabel} should be scaled to the
     * maximum possible size that fits inside the bounds of this item.  Currently only {@link
     * com.smartgwt.client.widgets.drawing.DrawRect}s and {@link com.smartgwt.client.widgets.drawing.DrawPolygon}s with 90
     * degree angles are supported. <P> Note that {@link com.smartgwt.client.widgets.drawing.DrawItem#getTitleAutoFit
     * titleAutoFit} isn't supported for rotated, sheared, or scaled {@link com.smartgwt.client.widgets.drawing.DrawItem}s, and
     * that therefore the value of {@link com.smartgwt.client.types.TitleRotationMode}, which relates to rotation of the item,
     * is ignored when this property is set.  However, we do support having the label automatically rotate to run vertically if
     * there's more space - see {@link com.smartgwt.client.widgets.drawing.DrawItem#getTitleAutoFitRotationMode
     * titleAutoFitRotationMode}.
     *
     * @return Current titleAutoFit value. Default value is false
     * @see com.smartgwt.client.widgets.drawing.DrawItem#getTitleLabel
     */
    public boolean getTitleAutoFit()  {
        Boolean result = getAttributeAsBoolean("titleAutoFit");
        return result == null ? false : result;
    }
    

    /**
     * Specifies margin between label and item edges when using {@link
     * com.smartgwt.client.widgets.drawing.DrawItem#getTitleAutoFit titleAutoFit}.
     *
     * @param titleAutoFitMargin New titleAutoFitMargin value. Default value is 2
     * @return {@link com.smartgwt.client.widgets.drawing.DrawItem DrawItem} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.drawing.DrawItem#setTitleLabel
     */
    public DrawItem setTitleAutoFitMargin(int titleAutoFitMargin)  throws IllegalStateException {
        return (DrawItem)setAttribute("titleAutoFitMargin", titleAutoFitMargin, false);
    }

    /**
     * Specifies margin between label and item edges when using {@link
     * com.smartgwt.client.widgets.drawing.DrawItem#getTitleAutoFit titleAutoFit}.
     *
     * @return Current titleAutoFitMargin value. Default value is 2
     * @see com.smartgwt.client.widgets.drawing.DrawItem#getTitleLabel
     */
    public int getTitleAutoFitMargin()  {
        return getAttributeAsInt("titleAutoFitMargin");
    }
    

    /**
     * Whether to rotate the {@link com.smartgwt.client.widgets.drawing.DrawItem#getTitleLabel titleLabel} 90 degrees clockwise
     * while trying to maximize its size in accordance with {@link com.smartgwt.client.widgets.drawing.DrawItem#getTitleAutoFit
     * titleAutoFit}.  If automatic rotation is specified, the default, the label will be rotated if and only if it allows the
     * label to become larger.
     *
     * @param titleAutoFitRotationMode New titleAutoFitRotationMode value. Default value is "auto"
     * @return {@link com.smartgwt.client.widgets.drawing.DrawItem DrawItem} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.drawing.DrawItem#setTitleLabel
     * @see com.smartgwt.client.widgets.drawing.DrawItem#setTitleAutoFit
     */
    public DrawItem setTitleAutoFitRotationMode(TitleAutoFitRotationMode titleAutoFitRotationMode)  throws IllegalStateException {
        return (DrawItem)setAttribute("titleAutoFitRotationMode", titleAutoFitRotationMode == null ? null : titleAutoFitRotationMode.getValue(), false);
    }

    /**
     * Whether to rotate the {@link com.smartgwt.client.widgets.drawing.DrawItem#getTitleLabel titleLabel} 90 degrees clockwise
     * while trying to maximize its size in accordance with {@link com.smartgwt.client.widgets.drawing.DrawItem#getTitleAutoFit
     * titleAutoFit}.  If automatic rotation is specified, the default, the label will be rotated if and only if it allows the
     * label to become larger.
     *
     * @return Current titleAutoFitRotationMode value. Default value is "auto"
     * @see com.smartgwt.client.widgets.drawing.DrawItem#getTitleLabel
     * @see com.smartgwt.client.widgets.drawing.DrawItem#getTitleAutoFit
     */
    public TitleAutoFitRotationMode getTitleAutoFitRotationMode()  {
        return EnumUtil.getEnum(TitleAutoFitRotationMode.values(), getAttribute("titleAutoFitRotationMode"));
    }
    

    /**
     * When a non-null {@link com.smartgwt.client.widgets.drawing.DrawItem#getTitle title} is set, this AutoChild is created 
     * automatically and positioned at the {@link com.smartgwt.client.widgets.drawing.DrawItem#getCenter center} of this
     * <code>DrawItem </code>. The <code>titleLabel</code> moves with this <code>DrawItem</code> and, depending  on {@link
     * com.smartgwt.client.types.TitleRotationMode titleRotationMode}, can rotate with this <code>DrawItem </code> as well. <p>
     * The following {@link com.smartgwt.client.docs.AutoChildUsage passthrough} applies:<br> {@link
     * com.smartgwt.client.widgets.drawing.DrawItem#getTitle title} for {@link
     * com.smartgwt.client.widgets.drawing.DrawLabel#getContents DrawLabel.contents}. <p> Related to the
     * <code>titleLabel</code> is the {@link com.smartgwt.client.widgets.drawing.DrawItem#getTitleLabelBackground
     * titleLabelBackground} which allows a border to be placed around the <code>titleLabel </code> and/or a background added.
     * By default, shapes that are commonly filled such as {@link com.smartgwt.client.widgets.drawing.DrawTriangle}s, with the
     * exception of {@link com.smartgwt.client.widgets.drawing.DrawSector}s, do not show the <code> titleLabelBackground</code>
     * (see {@link com.smartgwt.client.widgets.drawing.DrawItem#getShowTitleLabelBackground showTitleLabelBackground}).
     * <p>
     * This component is an AutoChild named "titleLabel".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current titleLabel value. Default value is null
     * @throws IllegalStateException if this widget has not yet been rendered.
     * @see com.smartgwt.client.widgets.drawing.DrawItem#getShowTitleLabelBackground
     */
    public DrawLabel getTitleLabel() throws IllegalStateException {
        errorIfNotCreated("titleLabel");
        return (DrawLabel)DrawLabel.getByJSObject(getAttributeAsJavaScriptObject("titleLabel"));
    }
    

    /**
     * When the {@link com.smartgwt.client.widgets.drawing.DrawItem#getTitleLabel titleLabel} is showing and {@link
     * com.smartgwt.client.widgets.drawing.DrawItem#getShowTitleLabelBackground showTitleLabelBackground} is <code>true</code>,
     * this {@link com.smartgwt.client.widgets.drawing.DrawRect} AutoChild is created and placed behind the
     * <code>titleLabel</code>.
     * <p>
     * This component is an AutoChild named "titleLabelBackground".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current titleLabelBackground value. Default value is null
     * @throws IllegalStateException if this widget has not yet been rendered.
     * @see com.smartgwt.client.widgets.drawing.DrawItem#getTitleLabelPadding
     */
    public DrawRect getTitleLabelBackground() throws IllegalStateException {
        errorIfNotCreated("titleLabelBackground");
        return (DrawRect)DrawRect.getByJSObject(getAttributeAsJavaScriptObject("titleLabelBackground"));
    }
    

    /**
     * If the {@link com.smartgwt.client.widgets.drawing.DrawItem#getTitleLabelBackground titleLabelBackground} is visible, how
     * much padding should be left between the bounds of the {@link com.smartgwt.client.widgets.drawing.DrawItem#getTitleLabel
     * titleLabel} and the edges of the <code>titleLabelBackground</code>?
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param titleLabelPadding New titleLabelPadding value. Default value is 2
     * @return {@link com.smartgwt.client.widgets.drawing.DrawItem DrawItem} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public DrawItem setTitleLabelPadding(int titleLabelPadding)  throws IllegalStateException {
        return (DrawItem)setAttribute("titleLabelPadding", titleLabelPadding, false);
    }

    /**
     * If the {@link com.smartgwt.client.widgets.drawing.DrawItem#getTitleLabelBackground titleLabelBackground} is visible, how
     * much padding should be left between the bounds of the {@link com.smartgwt.client.widgets.drawing.DrawItem#getTitleLabel
     * titleLabel} and the edges of the <code>titleLabelBackground</code>?
     *
     * @return Current titleLabelPadding value. Default value is 2
     */
    public int getTitleLabelPadding()  {
        return getAttributeAsInt("titleLabelPadding");
    }
    

    /**
     * The mode in which the {@link com.smartgwt.client.widgets.drawing.DrawItem#getTitleLabel titleLabel} (if shown) is
     * rotated with this draw item.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param titleRotationMode New titleRotationMode value. Default value is "neverRotate"
     * @return {@link com.smartgwt.client.widgets.drawing.DrawItem DrawItem} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.drawing.DrawItem#setTitle
     * 
     */
    public DrawItem setTitleRotationMode(TitleRotationMode titleRotationMode)  throws IllegalStateException {
        return (DrawItem)setAttribute("titleRotationMode", titleRotationMode == null ? null : titleRotationMode.getValue(), false);
    }

    /**
     * The mode in which the {@link com.smartgwt.client.widgets.drawing.DrawItem#getTitleLabel titleLabel} (if shown) is
     * rotated with this draw item.
     *
     * @return Current titleRotationMode value. Default value is "neverRotate"
     * @see com.smartgwt.client.widgets.drawing.DrawItem#getTitle
     * 
     */
    public TitleRotationMode getTitleRotationMode()  {
        return EnumUtil.getEnum(TitleRotationMode.values(), getAttribute("titleRotationMode"));
    }
    

    /**
     * Array holds two values representing translation along the x and y dimensions.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param translate New translate value. Default value is null
     * @return {@link com.smartgwt.client.widgets.drawing.DrawItem DrawItem} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public DrawItem setTranslate(float[] translate)  throws IllegalStateException {
        return (DrawItem)setAttribute("translate", translate, false);
    }

    /**
     * Array holds two values representing translation along the x and y dimensions.
     *
     * @return Current translate value. Default value is null
     */
    public float[] getTranslate()  {
        return com.smartgwt.client.util.ConvertTo.arrayOffloat(getAttributeAsJavaScriptObject("translate"));
    }
    

    /**
     * If true, when a DrawItem is {@link com.smartgwt.client.widgets.drawing.DrawItem#moveTo moved} or {@link
     * com.smartgwt.client.widgets.drawing.DrawItem#resizeTo resized}, the transform is applied by manipulating the shape
     * coordinates, if possible, rather than by introducing scaling, shearing, rotation, or translation.  This is only
     * supported currently for  {@link com.smartgwt.client.widgets.drawing.DrawRect}, {@link
     * com.smartgwt.client.widgets.drawing.DrawOval}, {@link com.smartgwt.client.widgets.drawing.DrawDiamond}, {@link
     * com.smartgwt.client.widgets.drawing.DrawImage}, and {@link com.smartgwt.client.widgets.drawing.DrawLabel}, and only if
     * no shearing is already present.  Further, it's only possible to keep the transform simple if both axes are scaled by the
     * same amount during the resize (or end up at the same scale if the DrawItem is already scaled unevenly), unless the
     * rotation angle is a multiple of 90 degrees. <P> For {@link com.smartgwt.client.widgets.drawing.DrawPolygon} and other
     * shapes not based on a box (top/left/width/height), we can't safely just modify coordinates to effect a resize as we can
     * do for {@link com.smartgwt.client.widgets.drawing.DrawRect} (and  similar), so resizing will normally introduce or
     * modify the transform, potentially  introducing scaling or shearing, rather than modifying coordinates.  For such  {@link
     * com.smartgwt.client.widgets.drawing.DrawItem}s, we avoid trying to manipulate the coordinates, in part, because there's
     * a danger that the floating point error may accumulate over time and warp the shape.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param useSimpleTransform New useSimpleTransform value. Default value is true
     * @return {@link com.smartgwt.client.widgets.drawing.DrawItem DrawItem} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.drawing.DrawItem#moveTo
     * @see com.smartgwt.client.widgets.drawing.DrawItem#moveBy
     * @see com.smartgwt.client.widgets.drawing.DrawItem#resizeTo
     * @see com.smartgwt.client.widgets.drawing.DrawItem#resizeBy
     */
    public DrawItem setUseSimpleTransform(boolean useSimpleTransform) {
        return (DrawItem)setAttribute("useSimpleTransform", useSimpleTransform, true);
    }

    /**
     * If true, when a DrawItem is {@link com.smartgwt.client.widgets.drawing.DrawItem#moveTo moved} or {@link
     * com.smartgwt.client.widgets.drawing.DrawItem#resizeTo resized}, the transform is applied by manipulating the shape
     * coordinates, if possible, rather than by introducing scaling, shearing, rotation, or translation.  This is only
     * supported currently for  {@link com.smartgwt.client.widgets.drawing.DrawRect}, {@link
     * com.smartgwt.client.widgets.drawing.DrawOval}, {@link com.smartgwt.client.widgets.drawing.DrawDiamond}, {@link
     * com.smartgwt.client.widgets.drawing.DrawImage}, and {@link com.smartgwt.client.widgets.drawing.DrawLabel}, and only if
     * no shearing is already present.  Further, it's only possible to keep the transform simple if both axes are scaled by the
     * same amount during the resize (or end up at the same scale if the DrawItem is already scaled unevenly), unless the
     * rotation angle is a multiple of 90 degrees. <P> For {@link com.smartgwt.client.widgets.drawing.DrawPolygon} and other
     * shapes not based on a box (top/left/width/height), we can't safely just modify coordinates to effect a resize as we can
     * do for {@link com.smartgwt.client.widgets.drawing.DrawRect} (and  similar), so resizing will normally introduce or
     * modify the transform, potentially  introducing scaling or shearing, rather than modifying coordinates.  For such  {@link
     * com.smartgwt.client.widgets.drawing.DrawItem}s, we avoid trying to manipulate the coordinates, in part, because there's
     * a danger that the floating point error may accumulate over time and warp the shape.
     *
     * @return Current useSimpleTransform value. Default value is true
     * @see com.smartgwt.client.widgets.drawing.DrawItem#moveTo
     * @see com.smartgwt.client.widgets.drawing.DrawItem#moveBy
     * @see com.smartgwt.client.widgets.drawing.DrawItem#resizeTo
     * @see com.smartgwt.client.widgets.drawing.DrawItem#resizeBy
     */
    public boolean getUseSimpleTransform()  {
        Boolean result = getAttributeAsBoolean("useSimpleTransform");
        return result == null ? true : result;
    }
    

    /**
     * The slope of an x-shearing transformation applied to this DrawItem.  Each point in the shape is moved along the x-axis a
     * distance that is proportional to the initial y-coordinate of the point.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param xShearFactor New xShearFactor value. Default value is 0.0
     * @return {@link com.smartgwt.client.widgets.drawing.DrawItem DrawItem} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public DrawItem setXShearFactor(double xShearFactor)  throws IllegalStateException {
        return (DrawItem)setAttribute("xShearFactor", xShearFactor, false);
    }

    /**
     * The slope of an x-shearing transformation applied to this DrawItem.  Each point in the shape is moved along the x-axis a
     * distance that is proportional to the initial y-coordinate of the point.
     *
     * @return Current xShearFactor value. Default value is 0.0
     */
    public double getXShearFactor()  {
        return getAttributeAsDouble("xShearFactor");
    }
    

    /**
     * The slope of a y-shearing transformation applied to this DrawItem.  Each point in the shape is moved along the y-axis a
     * distance that is proportional to the initial x-coordinate of the point.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param yShearFactor New yShearFactor value. Default value is 0.0
     * @return {@link com.smartgwt.client.widgets.drawing.DrawItem DrawItem} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public DrawItem setYShearFactor(double yShearFactor)  throws IllegalStateException {
        return (DrawItem)setAttribute("yShearFactor", yShearFactor, false);
    }

    /**
     * The slope of a y-shearing transformation applied to this DrawItem.  Each point in the shape is moved along the y-axis a
     * distance that is proportional to the initial x-coordinate of the point.
     *
     * @return Current yShearFactor value. Default value is 0.0
     */
    public double getYShearFactor()  {
        return getAttributeAsDouble("yShearFactor");
    }
    

    /**
     * Relative stacking order of this draw item with respect to other items in the same {@link
     * com.smartgwt.client.widgets.drawing.DrawPane} or {@link com.smartgwt.client.widgets.drawing.DrawGroup}. <p> null means
     * that the zIndex has not been resolved. Upon adding this draw item to a <code>DrawPane</code> or <code>DrawGroup</code>,
     * this item's zIndex will be resolved to the next higher auto-assigned zIndex. Note that this may still be less than
     * another item's zIndex if {@link com.smartgwt.client.widgets.drawing.DrawItem#bringToFront bringToFront()} was called on
     * that item. <p> If two items within the same <code>DrawPane</code> or <code>DrawGroup</code> have the same zIndex, then
     * they are stacked in the order in which they were added to the <code>DrawPane</code> or <code>DrawGroup</code>. <p> When
     * the <code>DrawPane</code>'s {@link com.smartgwt.client.widgets.drawing.DrawPane#getDrawingType drawingType} is  {@link
     * com.smartgwt.client.types.DrawingType#BITMAP}, zIndex, {@link com.smartgwt.client.widgets.drawing.DrawItem#bringToFront
     * bringToFront()}, and {@link com.smartgwt.client.widgets.drawing.DrawItem#sendToBack sendToBack()} are not supported for
     * {@link com.smartgwt.client.widgets.drawing.DrawLabel}s on iOS due to platform limitations.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Setter for {@link com.smartgwt.client.widgets.drawing.DrawItem#getZIndex zIndex}.
     *
     * @param zIndex new <code>zIndex</code>. If null and this draw item is already in a <code>DrawPane</code> or <code>DrawGroup</code>,
     * then this item's zIndex will be set to the next higher auto-assigned zIndex. <p> Note that when setting draw items'
     * zIndexes via this advanced API, the application should take over management of all draw items' zIndexes, and {@link
     * com.smartgwt.client.widgets.drawing.DrawItem#bringToFront bringToFront()} / {@link
     * com.smartgwt.client.widgets.drawing.DrawItem#sendToBack sendToBack()} should not be used, as those APIs assume automatic
     * management of zIndexes. Default value is null
     * @return {@link com.smartgwt.client.widgets.drawing.DrawItem DrawItem} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.ZIndex ZIndex overview and related methods
     */
    public DrawItem setZIndex(Integer zIndex)  throws IllegalStateException {
        return (DrawItem)setAttribute("zIndex", zIndex, false);
    }

    /**
     * Relative stacking order of this draw item with respect to other items in the same {@link
     * com.smartgwt.client.widgets.drawing.DrawPane} or {@link com.smartgwt.client.widgets.drawing.DrawGroup}. <p> null means
     * that the zIndex has not been resolved. Upon adding this draw item to a <code>DrawPane</code> or <code>DrawGroup</code>,
     * this item's zIndex will be resolved to the next higher auto-assigned zIndex. Note that this may still be less than
     * another item's zIndex if {@link com.smartgwt.client.widgets.drawing.DrawItem#bringToFront bringToFront()} was called on
     * that item. <p> If two items within the same <code>DrawPane</code> or <code>DrawGroup</code> have the same zIndex, then
     * they are stacked in the order in which they were added to the <code>DrawPane</code> or <code>DrawGroup</code>. <p> When
     * the <code>DrawPane</code>'s {@link com.smartgwt.client.widgets.drawing.DrawPane#getDrawingType drawingType} is  {@link
     * com.smartgwt.client.types.DrawingType#BITMAP}, zIndex, {@link com.smartgwt.client.widgets.drawing.DrawItem#bringToFront
     * bringToFront()}, and {@link com.smartgwt.client.widgets.drawing.DrawItem#sendToBack sendToBack()} are not supported for
     * {@link com.smartgwt.client.widgets.drawing.DrawLabel}s on iOS due to platform limitations.
     *
     * @return Returns the {@link com.smartgwt.client.widgets.drawing.DrawItem#getZIndex zIndex} of this draw item. Default value is null
     * @see com.smartgwt.client.docs.ZIndex ZIndex overview and related methods
     */
    public Integer getZIndex()  {
        return getAttributeAsInt("zIndex");
    }
    

    // ********************* Methods ***********************
	/**
     * Places this draw item at the top of the stacking order so that it appears in front of other draw items in the same
     * {@link com.smartgwt.client.widgets.drawing.DrawPane} or {@link com.smartgwt.client.widgets.drawing.DrawGroup}. <p> When
     * the <code>DrawPane</code>'s {@link com.smartgwt.client.widgets.drawing.DrawPane#getDrawingType drawingType} is  {@link
     * com.smartgwt.client.types.DrawingType#BITMAP}, {@link com.smartgwt.client.widgets.drawing.DrawItem#getZIndex zIndex},
     * bringToFront(), and {@link com.smartgwt.client.widgets.drawing.DrawItem#sendToBack sendToBack()} are not supported for
     * {@link com.smartgwt.client.widgets.drawing.DrawLabel}s on iOS due to platform limitations.
     * @see com.smartgwt.client.widgets.drawing.DrawItem#sendToBack
     * @see com.smartgwt.client.widgets.drawing.DrawItem#setZIndex
     * @see com.smartgwt.client.docs.ZIndex ZIndex overview and related methods
     */
    public native void bringToFront() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "bringToFront", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.bringToFront();
    }-*/;

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
        var obj;
        var selfJ = this;
        var hasDefaultHandler;
        var click = $debox($entry(function(param){
            var event = @com.smartgwt.client.widgets.drawing.events.ClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            selfJ.@com.smartgwt.client.widgets.drawing.DrawItem::handleTearDownClickEvent()();
            var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
            return !ret;
        }));
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            hasDefaultHandler = $wnd.isc.isA.Function(obj.getProperty("click"));
            obj.addProperties({click: 
                function () {
                    var param = {"_this": this};
                    var ret = click(param) == true;
                    if (ret && hasDefaultHandler) {
                        ret = this.Super("click", arguments);
                    }
                    return ret;
                }
             });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
            hasDefaultHandler = $wnd.isc.isA.Function($wnd.isc[scClassName].getInstanceProperty("click"));
            obj.click = 
                function () {
                    var param = {"_this": this};
                    var ret = click(param) == true;
                    if (ret && hasDefaultHandler) {
                        ret = this.Super("click", arguments);
                    }
                    return ret;
                }
            ;
        }
    }-*/;

    private void handleTearDownClickEvent() {
        if (getHandlerCount(com.smartgwt.client.widgets.drawing.events.ClickEvent.getType()) == 0) tearDownClickEvent();
    }

    private native void tearDownClickEvent() /*-{
        var obj;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }
        if (obj && obj.hasOwnProperty("click")) delete obj.click;
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
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "dragResizeMove", "String,Integer,Integer,Integer,Integer");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.dragResizeMove(position, x == null ? null : x.@java.lang.Integer::intValue()(), y == null ? null : y.@java.lang.Integer::intValue()(), dX == null ? null : dX.@java.lang.Integer::intValue()(), dY == null ? null : dY.@java.lang.Integer::intValue()());
    }-*/;

	/**
     * Draws this item into its current {@link com.smartgwt.client.widgets.drawing.DrawItem#getDrawPane drawPane}. <p> NOTE:
     * For performance reasons, the <code>DrawPane</code> may draw this item on a delay to allow multiple items to be added and
     * drawn at one time. The {@link com.smartgwt.client.widgets.drawing.DrawPane#refreshNow DrawPane.refreshNow()} API will
     * force this item to be drawn immediately.
     */
    public native void draw() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "draw", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.draw();
    }-*/;

    /**
     * Add a drawEnd handler.
     * <p>
     * Called when we finish drawing for this DrawItem to the {@link com.smartgwt.client.widgets.drawing.DrawItem#getDrawPane
     * DrawItem.drawPane}'s underlying HTML5 &lt;canvas&gt; element.  Only called if the {@link
     * com.smartgwt.client.types.DrawingType} is  {@link com.smartgwt.client.types.DrawingType#BITMAP}.
     *
     * @param handler the drawEnd handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addDrawEndHandler(com.smartgwt.client.widgets.drawing.events.DrawEndHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.drawing.events.DrawEndEvent.getType()) == 0) setupDrawEndEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.drawing.events.DrawEndEvent.getType());
    }

    private native void setupDrawEndEvent() /*-{
        var obj;
        var selfJ = this;
        var hasDefaultHandler;
        var drawEnd = $entry(function(){
            var param = {"_this": this};
            var event = @com.smartgwt.client.widgets.drawing.events.DrawEndEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            selfJ.@com.smartgwt.client.widgets.drawing.DrawItem::handleTearDownDrawEndEvent()();
            if (hasDefaultHandler) this.Super("drawEnd", arguments);
        });
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            hasDefaultHandler = $wnd.isc.isA.Function(obj.getProperty("drawEnd"));
            obj.addProperties({drawEnd:  drawEnd              });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
            hasDefaultHandler = $wnd.isc.isA.Function($wnd.isc[scClassName].getInstanceProperty("drawEnd"));
            obj.drawEnd =  drawEnd             ;
        }
    }-*/;

    private void handleTearDownDrawEndEvent() {
        if (getHandlerCount(com.smartgwt.client.widgets.drawing.events.DrawEndEvent.getType()) == 0) tearDownDrawEndEvent();
    }

    private native void tearDownDrawEndEvent() /*-{
        var obj;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }
        if (obj && obj.hasOwnProperty("drawEnd")) delete obj.drawEnd;
    }-*/;

    /**
     * Add a drawStart handler.
     * <p>
     * Called when we start drawing for this DrawItem to the {@link com.smartgwt.client.widgets.drawing.DrawItem#getDrawPane
     * DrawItem.drawPane}'s underlying HTML5 &lt;canvas&gt; element.  Only called if the {@link
     * com.smartgwt.client.types.DrawingType} is  {@link com.smartgwt.client.types.DrawingType#BITMAP}.
     *
     * @param handler the drawStart handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addDrawStartHandler(com.smartgwt.client.widgets.drawing.events.DrawStartHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.drawing.events.DrawStartEvent.getType()) == 0) setupDrawStartEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.drawing.events.DrawStartEvent.getType());
    }

    private native void setupDrawStartEvent() /*-{
        var obj;
        var selfJ = this;
        var hasDefaultHandler;
        var drawStart = $entry(function(){
            var param = {"_this": this};
            var event = @com.smartgwt.client.widgets.drawing.events.DrawStartEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            selfJ.@com.smartgwt.client.widgets.drawing.DrawItem::handleTearDownDrawStartEvent()();
            if (hasDefaultHandler) this.Super("drawStart", arguments);
        });
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            hasDefaultHandler = $wnd.isc.isA.Function(obj.getProperty("drawStart"));
            obj.addProperties({drawStart:  drawStart              });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
            hasDefaultHandler = $wnd.isc.isA.Function($wnd.isc[scClassName].getInstanceProperty("drawStart"));
            obj.drawStart =  drawStart             ;
        }
    }-*/;

    private void handleTearDownDrawStartEvent() {
        if (getHandlerCount(com.smartgwt.client.widgets.drawing.events.DrawStartEvent.getType()) == 0) tearDownDrawStartEvent();
    }

    private native void tearDownDrawStartEvent() /*-{
        var obj;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }
        if (obj && obj.hasOwnProperty("drawStart")) delete obj.drawStart;
    }-*/;

	/**
     * Erase this drawItem's visual representation and remove it from its DrawGroup (if any) and DrawPane. <P> To re-draw the
     * item within the DrawPane, call {@link com.smartgwt.client.widgets.drawing.DrawItem#draw draw()} again, or use {@link
     * com.smartgwt.client.widgets.drawing.DrawPane#addDrawItem DrawPane.addDrawItem()} to move to another DrawGroup.
     */
    public native void erase() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "erase", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.erase();
    }-*/;

	/**
     * Returns the center point of this draw item in local coordinates. Generally this is the center of the {@link
     * com.smartgwt.client.widgets.drawing.DrawItem#getBoundingBox bounding box}, but some item types may use a different
     * point. For example, {@link com.smartgwt.client.widgets.drawing.DrawTriangle} uses the <a
     * href='http://en.wikipedia.org/wiki/Incenter#Cartesian_coordinates' target='_blank'>incenter</a> of the triangle.
     *
     * @return the center point in local coordinates
     */
    public native Point getCenter() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getCenter", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
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
     * @return the HTML to show in the hover.
     * See {@link com.smartgwt.client.docs.HTMLString HTMLString}
     */
    public native String getHoverHTML() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getHoverHTML", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
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
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getPageLeft", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
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
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getPageTop", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getPageTop();
        return ret;
    }-*/;

	/**
     * Generates a string containing the SVG source of this DrawItem. <p><b>NOTE:</b> The generated SVG source assumes that the
     * default namespace is <code>http://www.w3.org/2000/svg</code> and that namespace prefix <code>xlink</code> refers to
     * namespace name <code>http://www.w3.org/1999/xlink</code>.
     */
    public native void getSvgString() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getSvgString", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.getSvgString();
    }-*/;

	/**
     * Hide this drawItem.
     */
    public native void hide() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "hide", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.hide();
    }-*/;

	/**
     * Hides all control knobs for this drawItem. Updates {@link com.smartgwt.client.widgets.drawing.DrawItem#getKnobs knobs}
     * to remove all knobTypes and clears any drawn knobs.
     */
    public native void hideAllKnobs() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "hideAllKnobs", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.hideAllKnobs();
    }-*/;

	/**
     * Hides a set of control knobs for this drawItem. Updates {@link com.smartgwt.client.widgets.drawing.DrawItem#getKnobs
     * knobs} to remove the specified knobType, and clears any drawn knobs for this knobType.
     * @param knobType knobs to hide
     */
    public native void hideKnobs(KnobType knobType) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "hideKnobs", "KnobType");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.hideKnobs(knobType.@com.smartgwt.client.types.KnobType::getValue()());
    }-*/;

	/**
     * Hides a set of control knobs for this drawItem. Updates {@link com.smartgwt.client.widgets.drawing.DrawItem#getKnobs
     * knobs} to remove the specified knobType, and clears any drawn knobs for this knobType.
     * @param knobType knobs to hide
     */
    public native void hideKnobs(KnobType... knobType) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "hideKnobs", "KnobType...");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
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
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "hover", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.hover();
        return ret == null ? false : ret;
    }-*/;

	/**
     * Returns true if the given point in the drawing coordinate system, when converted to coordinates in this DrawItem's local
     * coordinate system, is within the {@link com.smartgwt.client.widgets.drawing.DrawItem#getBoundingBox bounding box} of
     * this DrawItem's shape. <p> This method can be used to quickly check whether the given point is definitely <em>not</em>
     * within the DrawItem shape. To check whether the point is within the DrawItem shape, use the slower but exact {@link
     * com.smartgwt.client.widgets.drawing.DrawItem#isPointInPath isPointInPath()} method.
     * @param x X coordinate of the point in the drawing coordinate system.
     * @param y Y coordinate of the point in the drawing coordinate system.
     *
     * @return 
     */
    public native boolean isInBounds(int x, int y) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "isInBounds", "int,int");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.isInBounds(x, y);
        return ret == null ? false : ret;
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
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "isPointInPath", "int,int");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.isPointInPath(x, y);
        return ret == null ? false : ret;
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
        var obj;
        var selfJ = this;
        var hasDefaultHandler;
        var mouseDown = $debox($entry(function(param){
            var event = @com.smartgwt.client.widgets.drawing.events.MouseDownEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            selfJ.@com.smartgwt.client.widgets.drawing.DrawItem::handleTearDownMouseDownEvent()();
            var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
            return !ret;
        }));
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            hasDefaultHandler = $wnd.isc.isA.Function(obj.getProperty("mouseDown"));
            obj.addProperties({mouseDown: 
                function () {
                    var param = {"_this": this};
                    var ret = mouseDown(param) == true;
                    if (ret && hasDefaultHandler) {
                        ret = this.Super("mouseDown", arguments);
                    }
                    return ret;
                }
             });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
            hasDefaultHandler = $wnd.isc.isA.Function($wnd.isc[scClassName].getInstanceProperty("mouseDown"));
            obj.mouseDown = 
                function () {
                    var param = {"_this": this};
                    var ret = mouseDown(param) == true;
                    if (ret && hasDefaultHandler) {
                        ret = this.Super("mouseDown", arguments);
                    }
                    return ret;
                }
            ;
        }
    }-*/;

    private void handleTearDownMouseDownEvent() {
        if (getHandlerCount(com.smartgwt.client.widgets.drawing.events.MouseDownEvent.getType()) == 0) tearDownMouseDownEvent();
    }

    private native void tearDownMouseDownEvent() /*-{
        var obj;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }
        if (obj && obj.hasOwnProperty("mouseDown")) delete obj.mouseDown;
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
        var obj;
        var selfJ = this;
        var hasDefaultHandler;
        var mouseMove = $debox($entry(function(param){
            var event = @com.smartgwt.client.widgets.drawing.events.MouseMoveEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            selfJ.@com.smartgwt.client.widgets.drawing.DrawItem::handleTearDownMouseMoveEvent()();
            var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
            return !ret;
        }));
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            hasDefaultHandler = $wnd.isc.isA.Function(obj.getProperty("mouseMove"));
            obj.addProperties({mouseMove: 
                function () {
                    var param = {"_this": this};
                    var ret = mouseMove(param) == true;
                    if (ret && hasDefaultHandler) {
                        ret = this.Super("mouseMove", arguments);
                    }
                    return ret;
                }
             });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
            hasDefaultHandler = $wnd.isc.isA.Function($wnd.isc[scClassName].getInstanceProperty("mouseMove"));
            obj.mouseMove = 
                function () {
                    var param = {"_this": this};
                    var ret = mouseMove(param) == true;
                    if (ret && hasDefaultHandler) {
                        ret = this.Super("mouseMove", arguments);
                    }
                    return ret;
                }
            ;
        }
    }-*/;

    private void handleTearDownMouseMoveEvent() {
        if (getHandlerCount(com.smartgwt.client.widgets.drawing.events.MouseMoveEvent.getType()) == 0) tearDownMouseMoveEvent();
    }

    private native void tearDownMouseMoveEvent() /*-{
        var obj;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }
        if (obj && obj.hasOwnProperty("mouseMove")) delete obj.mouseMove;
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
        var obj;
        var selfJ = this;
        var hasDefaultHandler;
        var mouseOut = $debox($entry(function(param){
            var event = @com.smartgwt.client.widgets.drawing.events.MouseOutEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            selfJ.@com.smartgwt.client.widgets.drawing.DrawItem::handleTearDownMouseOutEvent()();
            var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
            return !ret;
        }));
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            hasDefaultHandler = $wnd.isc.isA.Function(obj.getProperty("mouseOut"));
            obj.addProperties({mouseOut: 
                function () {
                    var param = {"_this": this};
                    var ret = mouseOut(param) == true;
                    if (ret && hasDefaultHandler) {
                        ret = this.Super("mouseOut", arguments);
                    }
                    return ret;
                }
             });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
            hasDefaultHandler = $wnd.isc.isA.Function($wnd.isc[scClassName].getInstanceProperty("mouseOut"));
            obj.mouseOut = 
                function () {
                    var param = {"_this": this};
                    var ret = mouseOut(param) == true;
                    if (ret && hasDefaultHandler) {
                        ret = this.Super("mouseOut", arguments);
                    }
                    return ret;
                }
            ;
        }
    }-*/;

    private void handleTearDownMouseOutEvent() {
        if (getHandlerCount(com.smartgwt.client.widgets.drawing.events.MouseOutEvent.getType()) == 0) tearDownMouseOutEvent();
    }

    private native void tearDownMouseOutEvent() /*-{
        var obj;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }
        if (obj && obj.hasOwnProperty("mouseOut")) delete obj.mouseOut;
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
        var obj;
        var selfJ = this;
        var hasDefaultHandler;
        var mouseOver = $debox($entry(function(param){
            var event = @com.smartgwt.client.widgets.drawing.events.MouseOverEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            selfJ.@com.smartgwt.client.widgets.drawing.DrawItem::handleTearDownMouseOverEvent()();
            var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
            return !ret;
        }));
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            hasDefaultHandler = $wnd.isc.isA.Function(obj.getProperty("mouseOver"));
            obj.addProperties({mouseOver: 
                function () {
                    var param = {"_this": this};
                    var ret = mouseOver(param) == true;
                    if (ret && hasDefaultHandler) {
                        ret = this.Super("mouseOver", arguments);
                    }
                    return ret;
                }
             });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
            hasDefaultHandler = $wnd.isc.isA.Function($wnd.isc[scClassName].getInstanceProperty("mouseOver"));
            obj.mouseOver = 
                function () {
                    var param = {"_this": this};
                    var ret = mouseOver(param) == true;
                    if (ret && hasDefaultHandler) {
                        ret = this.Super("mouseOver", arguments);
                    }
                    return ret;
                }
            ;
        }
    }-*/;

    private void handleTearDownMouseOverEvent() {
        if (getHandlerCount(com.smartgwt.client.widgets.drawing.events.MouseOverEvent.getType()) == 0) tearDownMouseOverEvent();
    }

    private native void tearDownMouseOverEvent() /*-{
        var obj;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }
        if (obj && obj.hasOwnProperty("mouseOver")) delete obj.mouseOver;
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
        var obj;
        var selfJ = this;
        var hasDefaultHandler;
        var mouseUp = $debox($entry(function(param){
            var event = @com.smartgwt.client.widgets.drawing.events.MouseUpEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            selfJ.@com.smartgwt.client.widgets.drawing.DrawItem::handleTearDownMouseUpEvent()();
            var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
            return !ret;
        }));
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            hasDefaultHandler = $wnd.isc.isA.Function(obj.getProperty("mouseUp"));
            obj.addProperties({mouseUp: 
                function () {
                    var param = {"_this": this};
                    var ret = mouseUp(param) == true;
                    if (ret && hasDefaultHandler) {
                        ret = this.Super("mouseUp", arguments);
                    }
                    return ret;
                }
             });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
            hasDefaultHandler = $wnd.isc.isA.Function($wnd.isc[scClassName].getInstanceProperty("mouseUp"));
            obj.mouseUp = 
                function () {
                    var param = {"_this": this};
                    var ret = mouseUp(param) == true;
                    if (ret && hasDefaultHandler) {
                        ret = this.Super("mouseUp", arguments);
                    }
                    return ret;
                }
            ;
        }
    }-*/;

    private void handleTearDownMouseUpEvent() {
        if (getHandlerCount(com.smartgwt.client.widgets.drawing.events.MouseUpEvent.getType()) == 0) tearDownMouseUpEvent();
    }

    private native void tearDownMouseUpEvent() /*-{
        var obj;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }
        if (obj && obj.hasOwnProperty("mouseUp")) delete obj.mouseUp;
    }-*/;

	/**
     * Move the shape by the specified deltas for the left and top coordinate.
     * @param dX change to left coordinate in pixels
     * @param dY change to top coordinate in pixels
     */
    public native void moveBy(int dX, int dY) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "moveBy", "int,int");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
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
        var obj;
        var selfJ = this;
        var hasDefaultHandler;
        var moved = $entry(function(){
            var param = {"_this": this, "deltaX" : arguments[0], "deltaY" : arguments[1]};
            var event = @com.smartgwt.client.widgets.drawing.events.MovedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            selfJ.@com.smartgwt.client.widgets.drawing.DrawItem::handleTearDownMovedEvent()();
            if (hasDefaultHandler) this.Super("moved", arguments);
        });
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            hasDefaultHandler = $wnd.isc.isA.Function(obj.getProperty("moved"));
            obj.addProperties({moved:  moved              });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
            hasDefaultHandler = $wnd.isc.isA.Function($wnd.isc[scClassName].getInstanceProperty("moved"));
            obj.moved =  moved             ;
        }
    }-*/;

    private void handleTearDownMovedEvent() {
        if (getHandlerCount(com.smartgwt.client.widgets.drawing.events.MovedEvent.getType()) == 0) tearDownMovedEvent();
    }

    private native void tearDownMovedEvent() /*-{
        var obj;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }
        if (obj && obj.hasOwnProperty("moved")) delete obj.moved;
    }-*/;

	/**
     * Move the DrawItem to the specified coordinates in the global coordinate system.  The specified coordinates will become
     * the top-left point of the {@link com.smartgwt.client.widgets.drawing.DrawItem#getResizeBoundingBox resize bounding box}.
     * @param left new left coordinate in pixels
     * @param top new top coordinate in pixels
     */
    public native void moveTo(Integer left, Integer top) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "moveTo", "Integer,Integer");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.moveTo(left == null ? null : left.@java.lang.Integer::intValue()(), top == null ? null : top.@java.lang.Integer::intValue()());
    }-*/;

    /**
     * Add a dragMove handler.
     * <p>
     * If {@link com.smartgwt.client.widgets.drawing.DrawItem#getCanDrag DrawItem.canDrag} is true, this notification method
     * will be fired when the user drags the draw item.
     *
     * @param handler the dragMove handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addDragMoveHandler(com.smartgwt.client.widgets.drawing.events.DragMoveHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.drawing.events.DragMove.getType()) == 0) setupDragMoveEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.drawing.events.DragMove.getType());
    }

    private native void setupDragMoveEvent() /*-{
        var obj;
        var selfJ = this;
        var hasDefaultHandler;
        var onDragMove = $debox($entry(function(param){
            var event = @com.smartgwt.client.widgets.drawing.events.DragMove::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            selfJ.@com.smartgwt.client.widgets.drawing.DrawItem::handleTearDownDragMoveEvent()();
            var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
            return !ret;
        }));
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            hasDefaultHandler = $wnd.isc.isA.Function(obj.getProperty("onDragMove"));
            obj.addProperties({onDragMove: 
                function () {
                    var param = {"_this": this, "x" : arguments[0], "y" : arguments[1]};
                    var ret = onDragMove(param) == true;
                    if (ret && hasDefaultHandler) {
                        ret = this.Super("onDragMove", arguments);
                    }
                    return ret;
                }
             });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
            hasDefaultHandler = $wnd.isc.isA.Function($wnd.isc[scClassName].getInstanceProperty("onDragMove"));
            obj.onDragMove = 
                function () {
                    var param = {"_this": this, "x" : arguments[0], "y" : arguments[1]};
                    var ret = onDragMove(param) == true;
                    if (ret && hasDefaultHandler) {
                        ret = this.Super("onDragMove", arguments);
                    }
                    return ret;
                }
            ;
        }
    }-*/;

    private void handleTearDownDragMoveEvent() {
        if (getHandlerCount(com.smartgwt.client.widgets.drawing.events.DragMove.getType()) == 0) tearDownDragMoveEvent();
    }

    private native void tearDownDragMoveEvent() /*-{
        var obj;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }
        if (obj && obj.hasOwnProperty("onDragMove")) delete obj.onDragMove;
    }-*/;

    /**
     * Add a dragResizeMove handler.
     * <p>
     * If {@link com.smartgwt.client.widgets.drawing.DrawItem#getCanDrag DrawItem.canDrag} is true and the {@link
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
        var obj;
        var selfJ = this;
        var hasDefaultHandler;
        var onDragResizeMove = $debox($entry(function(param){
            var event = @com.smartgwt.client.widgets.drawing.events.DragResizeMoveEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            selfJ.@com.smartgwt.client.widgets.drawing.DrawItem::handleTearDownDragResizeMoveEvent()();
            var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
            return !ret;
        }));
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            hasDefaultHandler = $wnd.isc.isA.Function(obj.getProperty("onDragResizeMove"));
            obj.addProperties({onDragResizeMove: 
                function () {
                    var param = {"_this": this, "newX" : arguments[0], "newY" : arguments[1], "newWidth" : arguments[2], "newHeight" : arguments[3]};
                    var ret = onDragResizeMove(param) == true;
                    if (ret && hasDefaultHandler) {
                        ret = this.Super("onDragResizeMove", arguments);
                    }
                    return ret;
                }
             });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
            hasDefaultHandler = $wnd.isc.isA.Function($wnd.isc[scClassName].getInstanceProperty("onDragResizeMove"));
            obj.onDragResizeMove = 
                function () {
                    var param = {"_this": this, "newX" : arguments[0], "newY" : arguments[1], "newWidth" : arguments[2], "newHeight" : arguments[3]};
                    var ret = onDragResizeMove(param) == true;
                    if (ret && hasDefaultHandler) {
                        ret = this.Super("onDragResizeMove", arguments);
                    }
                    return ret;
                }
            ;
        }
    }-*/;

    private void handleTearDownDragResizeMoveEvent() {
        if (getHandlerCount(com.smartgwt.client.widgets.drawing.events.DragResizeMoveEvent.getType()) == 0) tearDownDragResizeMoveEvent();
    }

    private native void tearDownDragResizeMoveEvent() /*-{
        var obj;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }
        if (obj && obj.hasOwnProperty("onDragResizeMove")) delete obj.onDragResizeMove;
    }-*/;

    /**
     * Add a dragResizeStart handler.
     * <p>
     * If {@link com.smartgwt.client.widgets.drawing.DrawItem#getCanDrag DrawItem.canDrag} is true and the {@link
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
        var obj;
        var selfJ = this;
        var hasDefaultHandler;
        var onDragResizeStart = $debox($entry(function(param){
            var event = @com.smartgwt.client.widgets.drawing.events.DragResizeStartEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            selfJ.@com.smartgwt.client.widgets.drawing.DrawItem::handleTearDownDragResizeStartEvent()();
            var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
            return !ret;
        }));
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            hasDefaultHandler = $wnd.isc.isA.Function(obj.getProperty("onDragResizeStart"));
            obj.addProperties({onDragResizeStart: 
                function () {
                    var param = {"_this": this, "newX" : arguments[0], "newY" : arguments[1], "newWidth" : arguments[2], "newHeight" : arguments[3]};
                    var ret = onDragResizeStart(param) == true;
                    if (ret && hasDefaultHandler) {
                        ret = this.Super("onDragResizeStart", arguments);
                    }
                    return ret;
                }
             });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
            hasDefaultHandler = $wnd.isc.isA.Function($wnd.isc[scClassName].getInstanceProperty("onDragResizeStart"));
            obj.onDragResizeStart = 
                function () {
                    var param = {"_this": this, "newX" : arguments[0], "newY" : arguments[1], "newWidth" : arguments[2], "newHeight" : arguments[3]};
                    var ret = onDragResizeStart(param) == true;
                    if (ret && hasDefaultHandler) {
                        ret = this.Super("onDragResizeStart", arguments);
                    }
                    return ret;
                }
            ;
        }
    }-*/;

    private void handleTearDownDragResizeStartEvent() {
        if (getHandlerCount(com.smartgwt.client.widgets.drawing.events.DragResizeStartEvent.getType()) == 0) tearDownDragResizeStartEvent();
    }

    private native void tearDownDragResizeStartEvent() /*-{
        var obj;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }
        if (obj && obj.hasOwnProperty("onDragResizeStart")) delete obj.onDragResizeStart;
    }-*/;

    /**
     * Add a dragResizeStop handler.
     * <p>
     * If {@link com.smartgwt.client.widgets.drawing.DrawItem#getCanDrag DrawItem.canDrag} is true and the {@link
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
        var obj;
        var selfJ = this;
        var hasDefaultHandler;
        var onDragResizeStop = $entry(function(){
            var param = {"_this": this, "newX" : arguments[0], "newY" : arguments[1], "newWidth" : arguments[2], "newHeight" : arguments[3]};
            var event = @com.smartgwt.client.widgets.drawing.events.DragResizeStopEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            selfJ.@com.smartgwt.client.widgets.drawing.DrawItem::handleTearDownDragResizeStopEvent()();
            if (hasDefaultHandler) this.Super("onDragResizeStop", arguments);
        });
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            hasDefaultHandler = $wnd.isc.isA.Function(obj.getProperty("onDragResizeStop"));
            obj.addProperties({onDragResizeStop:  onDragResizeStop              });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
            hasDefaultHandler = $wnd.isc.isA.Function($wnd.isc[scClassName].getInstanceProperty("onDragResizeStop"));
            obj.onDragResizeStop =  onDragResizeStop             ;
        }
    }-*/;

    private void handleTearDownDragResizeStopEvent() {
        if (getHandlerCount(com.smartgwt.client.widgets.drawing.events.DragResizeStopEvent.getType()) == 0) tearDownDragResizeStopEvent();
    }

    private native void tearDownDragResizeStopEvent() /*-{
        var obj;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }
        if (obj && obj.hasOwnProperty("onDragResizeStop")) delete obj.onDragResizeStop;
    }-*/;

    /**
     * Add a dragStart handler.
     * <p>
     * If {@link com.smartgwt.client.widgets.drawing.DrawItem#getCanDrag DrawItem.canDrag} is true, this notification method
     * will be fired when the user starts to drag the draw item.
     *
     * @param handler the dragStart handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addDragStartHandler(com.smartgwt.client.widgets.drawing.events.DragStartHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.drawing.events.DragStart.getType()) == 0) setupDragStartEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.drawing.events.DragStart.getType());
    }

    private native void setupDragStartEvent() /*-{
        var obj;
        var selfJ = this;
        var hasDefaultHandler;
        var onDragStart = $debox($entry(function(param){
            var event = @com.smartgwt.client.widgets.drawing.events.DragStart::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            selfJ.@com.smartgwt.client.widgets.drawing.DrawItem::handleTearDownDragStartEvent()();
            var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
            return !ret;
        }));
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            hasDefaultHandler = $wnd.isc.isA.Function(obj.getProperty("onDragStart"));
            obj.addProperties({onDragStart: 
                function () {
                    var param = {"_this": this, "x" : arguments[0], "y" : arguments[1]};
                    var ret = onDragStart(param) == true;
                    if (ret && hasDefaultHandler) {
                        ret = this.Super("onDragStart", arguments);
                    }
                    return ret;
                }
             });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
            hasDefaultHandler = $wnd.isc.isA.Function($wnd.isc[scClassName].getInstanceProperty("onDragStart"));
            obj.onDragStart = 
                function () {
                    var param = {"_this": this, "x" : arguments[0], "y" : arguments[1]};
                    var ret = onDragStart(param) == true;
                    if (ret && hasDefaultHandler) {
                        ret = this.Super("onDragStart", arguments);
                    }
                    return ret;
                }
            ;
        }
    }-*/;

    private void handleTearDownDragStartEvent() {
        if (getHandlerCount(com.smartgwt.client.widgets.drawing.events.DragStart.getType()) == 0) tearDownDragStartEvent();
    }

    private native void tearDownDragStartEvent() /*-{
        var obj;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }
        if (obj && obj.hasOwnProperty("onDragStart")) delete obj.onDragStart;
    }-*/;

    /**
     * Add a dragStop handler.
     * <p>
     * If {@link com.smartgwt.client.widgets.drawing.DrawItem#getCanDrag DrawItem.canDrag} is true, this notification method
     * will be fired when the user completes a drag on the draw item.
     *
     * @param handler the dragStop handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addDragStopHandler(com.smartgwt.client.widgets.drawing.events.DragStopHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.drawing.events.DragStop.getType()) == 0) setupDragStopEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.drawing.events.DragStop.getType());
    }

    private native void setupDragStopEvent() /*-{
        var obj;
        var selfJ = this;
        var hasDefaultHandler;
        var onDragStop = $entry(function(){
            var param = {"_this": this, "x" : arguments[0], "y" : arguments[1]};
            var event = @com.smartgwt.client.widgets.drawing.events.DragStop::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            selfJ.@com.smartgwt.client.widgets.drawing.DrawItem::handleTearDownDragStopEvent()();
            if (hasDefaultHandler) this.Super("onDragStop", arguments);
        });
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            hasDefaultHandler = $wnd.isc.isA.Function(obj.getProperty("onDragStop"));
            obj.addProperties({onDragStop:  onDragStop              });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
            hasDefaultHandler = $wnd.isc.isA.Function($wnd.isc[scClassName].getInstanceProperty("onDragStop"));
            obj.onDragStop =  onDragStop             ;
        }
    }-*/;

    private void handleTearDownDragStopEvent() {
        if (getHandlerCount(com.smartgwt.client.widgets.drawing.events.DragStop.getType()) == 0) tearDownDragStopEvent();
    }

    private native void tearDownDragStopEvent() /*-{
        var obj;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }
        if (obj && obj.hasOwnProperty("onDragStop")) delete obj.onDragStop;
    }-*/;

	/**
     * Resize the shape by the specified deltas.
     * @param dX number of pixels to resize by horizontally
     * @param dY number of pixels to resize by vertically
     */
    public native void resizeBy(int dX, int dY) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "resizeBy", "int,int");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.resizeBy(dX, dY);
    }-*/;

    /**
     * Add a resized handler.
     * <p>
     * Method called whenever  a DrawItem changes size.
     *
     * @param handler the resized handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addResizedHandler(com.smartgwt.client.widgets.drawing.events.ResizedHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.drawing.events.ResizedEvent.getType()) == 0) setupResizedEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.drawing.events.ResizedEvent.getType());
    }

    private native void setupResizedEvent() /*-{
        var obj;
        var selfJ = this;
        var hasDefaultHandler;
        var resized = $entry(function(){
            var param = {"_this": this};
            var event = @com.smartgwt.client.widgets.drawing.events.ResizedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            selfJ.@com.smartgwt.client.widgets.drawing.DrawItem::handleTearDownResizedEvent()();
            if (hasDefaultHandler) this.Super("resized", arguments);
        });
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            hasDefaultHandler = $wnd.isc.isA.Function(obj.getProperty("resized"));
            obj.addProperties({resized:  resized              });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
            hasDefaultHandler = $wnd.isc.isA.Function($wnd.isc[scClassName].getInstanceProperty("resized"));
            obj.resized =  resized             ;
        }
    }-*/;

    private void handleTearDownResizedEvent() {
        if (getHandlerCount(com.smartgwt.client.widgets.drawing.events.ResizedEvent.getType()) == 0) tearDownResizedEvent();
    }

    private native void tearDownResizedEvent() /*-{
        var obj;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }
        if (obj && obj.hasOwnProperty("resized")) delete obj.resized;
    }-*/;

	/**
     * Resize to the specified size
     * @param width new width
     * @param height new height
     */
    public native void resizeTo(Integer width, Integer height) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "resizeTo", "Integer,Integer");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.resizeTo(width == null ? null : width.@java.lang.Integer::intValue()(), height == null ? null : height.@java.lang.Integer::intValue()());
    }-*/;

	/**
     * Rotate the shape by the relative rotation in degrees
     * @param degrees number of degrees to rotate from current orientation.
     */
    public native void rotateBy(double degrees) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "rotateBy", "double");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.rotateBy(degrees);
    }-*/;

	/**
     * Rotate the shape by the absolute rotation in degrees
     * @param degrees number of degrees to rotate
     */
    public native void rotateTo(double degrees) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "rotateTo", "double");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.rotateTo(degrees);
    }-*/;


	/**
     * Scale the shape by the x, y multipliers
     * @param x scale in the x direction
     * @param y scale in the y direction
     */
    public native void scaleBy(double x, double y) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "scaleBy", "double,double");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.scaleBy(x, y);
    }-*/;


	/**
     * Scale the shape by the x, y multipliers
     * @param x scale in the x direction
     * @param y scale in the y direction
     */
    public native void scaleTo(double x, double y) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "scaleTo", "double,double");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.scaleTo(x, y);
    }-*/;

	/**
     * Places this draw item at the bottom of the stacking order so that it appears behind other draw items in the same {@link
     * com.smartgwt.client.widgets.drawing.DrawPane} or {@link com.smartgwt.client.widgets.drawing.DrawGroup}. <p> When the
     * <code>DrawPane</code>'s {@link com.smartgwt.client.widgets.drawing.DrawPane#getDrawingType drawingType} is  {@link
     * com.smartgwt.client.types.DrawingType#BITMAP}, {@link com.smartgwt.client.widgets.drawing.DrawItem#getZIndex zIndex},
     * {@link com.smartgwt.client.widgets.drawing.DrawItem#bringToFront bringToFront()}, and sendToBack() are not supported for
     * {@link com.smartgwt.client.widgets.drawing.DrawLabel}s on iOS due to platform limitations.
     * @see com.smartgwt.client.widgets.drawing.DrawItem#bringToFront
     * @see com.smartgwt.client.widgets.drawing.DrawItem#setZIndex
     * @see com.smartgwt.client.docs.ZIndex ZIndex overview and related methods
     */
    public native void sendToBack() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "sendToBack", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.sendToBack();
    }-*/;

	/**
     * Change the center point for this DrawItem.
     * @param left X coordinate of the center point (in the global coordinate system).
     * @param top Y coordinate of the center point (in the global coordinate system).
     */
    public native void setCenterPoint(int left, int top) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "setCenterPoint", "int,int");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setCenterPoint(left, top);
    }-*/;

	/**
     * Sets a property on this DrawItem, calling the appropriate setter method if one is found and is  supported.
     * @param propertyName name of the property to set
     * @param newValue new value for the property
     */
    public native void setPropertyValue(String propertyName, Object newValue) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "setPropertyValue", "String,Object");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setPropertyValue(propertyName, newValue);
    }-*/;

	/**
     * Make this drawItem visible.
     */
    public native void show() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "show", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.show();
    }-*/;

	/**
     * Shows all supported control knobs for this drawItem. Updates {@link
     * com.smartgwt.client.widgets.drawing.DrawItem#getKnobs knobs} to include the supported knobTypes and if necessary draws
     * out the appropriate control knobs.
     */
    public native void showAllKnobs() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "showAllKnobs", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.showAllKnobs();
    }-*/;

    /**
     * Add a showContextMenu handler.
     * <p>
     * Executed when the right mouse button is clicked.  The default implementation of this method auto-creates a {@link
     * com.smartgwt.client.widgets.menu.Menu} from the {@link com.smartgwt.client.widgets.Canvas#getContextMenu
     * Canvas.contextMenu} property on this component and then calls {@link
     * com.smartgwt.client.widgets.menu.Menu#showContextMenu Menu.showContextMenu()} on it to show it. <p> If you want to show
     * a standard context menu, you can simply define your Menu and set it as the contextMenu property on your component - you
     * do not need to override this method. <p> If you want to do some other processing before showing a menu or do something
     * else entirely, then you should override this method.  Note that the return value from this method controls whether or
     * not the native browser context menu is shown.
     *
     * @param handler the showContextMenu handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addShowContextMenuHandler(com.smartgwt.client.widgets.drawing.events.ShowContextMenuHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.drawing.events.ShowContextMenuEvent.getType()) == 0) setupShowContextMenuEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.drawing.events.ShowContextMenuEvent.getType());
    }

    private native void setupShowContextMenuEvent() /*-{
        var obj;
        var selfJ = this;
        var hasDefaultHandler;
        var showContextMenu = $debox($entry(function(param){
            var event = @com.smartgwt.client.widgets.drawing.events.ShowContextMenuEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            selfJ.@com.smartgwt.client.widgets.drawing.DrawItem::handleTearDownShowContextMenuEvent()();
            var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
            return !ret;
        }));
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            hasDefaultHandler = $wnd.isc.isA.Function(obj.getProperty("showContextMenu"));
            obj.addProperties({showContextMenu: 
                function () {
                    var param = {"_this": this};
                    var ret = showContextMenu(param) == true;
                    if (ret && hasDefaultHandler) {
                        ret = this.Super("showContextMenu", arguments);
                    }
                    return ret;
                }
             });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
            hasDefaultHandler = $wnd.isc.isA.Function($wnd.isc[scClassName].getInstanceProperty("showContextMenu"));
            obj.showContextMenu = 
                function () {
                    var param = {"_this": this};
                    var ret = showContextMenu(param) == true;
                    if (ret && hasDefaultHandler) {
                        ret = this.Super("showContextMenu", arguments);
                    }
                    return ret;
                }
            ;
        }
    }-*/;

    private void handleTearDownShowContextMenuEvent() {
        if (getHandlerCount(com.smartgwt.client.widgets.drawing.events.ShowContextMenuEvent.getType()) == 0) tearDownShowContextMenuEvent();
    }

    private native void tearDownShowContextMenuEvent() /*-{
        var obj;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }
        if (obj && obj.hasOwnProperty("showContextMenu")) delete obj.showContextMenu;
    }-*/;

	/**
     * Shows a set of control knobs for this drawItem. Updates {@link com.smartgwt.client.widgets.drawing.DrawItem#getKnobs
     * knobs} to include the specified knobType, and if necessary draws out the appropriate control knobs.
     * @param knobType knobs to show
     */
    public native void showKnobs(KnobType knobType) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "showKnobs", "KnobType");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.showKnobs(knobType.@com.smartgwt.client.types.KnobType::getValue()());
    }-*/;

	/**
     * Shows a set of control knobs for this drawItem. Updates {@link com.smartgwt.client.widgets.drawing.DrawItem#getKnobs
     * knobs} to include the specified knobType, and if necessary draws out the appropriate control knobs.
     * @param knobType knobs to show
     */
    public native void showKnobs(KnobType... knobType) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "showKnobs", "KnobType...");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.showKnobs(@com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(knobType));
    }-*/;

	/**
     * Does this DrawItem  support {@link com.smartgwt.client.widgets.drawing.DrawItem#setEndArrow setEndArrow()}? For example,
     * this is false for {@link com.smartgwt.client.widgets.drawing.DrawRect} and {@link
     * com.smartgwt.client.widgets.drawing.DrawOval}, and true for {@link com.smartgwt.client.widgets.drawing.DrawLine}.
     *
     * @return whether setEndArrow() is supported by this DrawItem.
     */
    public native boolean supportsEndArrow() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "supportsEndArrow", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.supportsEndArrow();
        return ret == null ? false : ret;
    }-*/;

	/**
     * Does this DrawItem  support {@link com.smartgwt.client.widgets.drawing.DrawItem#setStartArrow setStartArrow()}? For
     * example, this is false for {@link com.smartgwt.client.widgets.drawing.DrawRect} and {@link
     * com.smartgwt.client.widgets.drawing.DrawOval}, and true for {@link com.smartgwt.client.widgets.drawing.DrawLine}.
     *
     * @return whether setStartArrow() is supported by this DrawItem.
     */
    public native boolean supportsStartArrow() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "supportsStartArrow", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.supportsStartArrow();
        return ret == null ? false : ret;
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
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public static native void setDefaultProperties(DrawItem drawItemProperties) /*-{
        if (drawItemProperties.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Class;)(DrawItem.@java.lang.Object::getClass()(), "setDefaultProperties", drawItemProperties.@java.lang.Object::getClass()());
        }
        drawItemProperties.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
    	var properties = drawItemProperties.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        properties = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(properties,true);
        $wnd.isc.DrawItem.addProperties(properties);
    }-*/;

    // ***********************************************************



    /**
     * Retrieve a DrawItem by its global {@link com.smartgwt.client.widgets.BaseWidget#getID ID}.
     * @param ID global ID of the DrawItem
     *
     * @return the DrawItem, or null if not found or not a DrawItem
     */
    public static DrawItem getById(String ID) {
        BaseWidget obj = BaseWidget.getById(ID);
        return obj instanceof DrawItem ? (DrawItem)obj : null;
    }

    /**
     * Retrieve a DrawItem from its {@link com.google.gwt.core.client.JavaScriptObject}.
     * @param jsObj SmartClient object associated with Canvas
     *
     * @return the DrawItem, or null if not found or not a DrawItem
     */
    public static DrawItem getByJSObject(JavaScriptObject jsObj) {
        BaseWidget obj = BaseWidget.getByJSObject(jsObj);
        return obj instanceof DrawItem ? (DrawItem)obj : null;
    }

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
        return selection == null ? null : @com.smartgwt.client.util.JSOHelper::convertToJavaDoubleArray(Lcom/google/gwt/core/client/JavaScriptObject;)(selection);
    }-*/;
    
    /**
     * Returns the startPoint endPoint
     *
     * @return x1, y1, x2, y2 coordinates
     */
    public native int[] getBoundingBox() /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var selection = self.getBoundingBox();
        return selection == null ? null : @com.smartgwt.client.util.JSOHelper::convertToJavaIntArray(Lcom/google/gwt/core/client/JavaScriptObject;)(selection);
    }-*/;

    /**
     * Returns the bounding box of the shape reflected by the {@link com.smartgwt.client.widgets.drawing.DrawItem#getShowResizeOutline resize outline} shown when dragging the {@link com.smartgwt.client.widgets.drawing.DrawItem#getResizeKnobPoints resize knobs}.  This method is similar to {@link com.smartgwt.client.widgets.drawing.DrawItem#getBoundingBoxAsDouble getBoundingBoxAsDouble} except that the coordinates returned by this method are in the global coordinate system (described {@link com.smartgwt.client.widgets.drawing.DrawPane here}).
     * @return The x1, y1, x2, y2 coordinates. When the width and height are both positive, point (x1, y1) is the top-left point of the bounding box and point (x2, y2) is the bottom-right point of the bounding box.
     * @see com.smartgwt.client.widgets.drawing.DrawItem#getBoundingBoxAsDouble
     */
    public native Double[] getResizeBoundingBoxAsDouble() /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var selection = self.getResizeBoundingBox();
        return selection == null ? null : @com.smartgwt.client.util.JSOHelper::convertToJavaDoubleArray(Lcom/google/gwt/core/client/JavaScriptObject;)(selection);
    }-*/;

    /**
     * Returns the bounding box of the shape reflected by the {@link com.smartgwt.client.widgets.drawing.DrawItem#getShowResizeOutline resize outline} shown when dragging the {@link com.smartgwt.client.widgets.drawing.DrawItem#getResizeKnobPoints resize knobs}.  This method is similar to {@link com.smartgwt.client.widgets.drawing.DrawItem#getBoundingBox getBoundingBox} except that the coordinates returned by this method are in the global coordinate system (described {@link com.smartgwt.client.widgets.drawing.DrawPane here}).
     * @return The x1, y1, x2, y2 coordinates. When the width and height are both positive, point (x1, y1) is the top-left point of the bounding box and point (x2, y2) is the bottom-right point of the bounding box.
     * @see com.smartgwt.client.widgets.drawing.DrawItem#getBoundingBox
     */
    public native int[] getResizeBoundingBox() /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var selection = self.getResizeBoundingBox();
        if (selection == null) {
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
     * <p><code>properties</code> must not have already been created 
     * ({@link com.smartgwt.client.widgets.BaseWidget#isCreated() properties.isCreated()}
     * must be <code>false</code>).
     *
     * <p><b>NOTE:</b> Overrides at override points are not applied to AutoChildren created from
     * <code>properties</code>; that is, if the Java {@link java.lang.Class} of <code>properties</code>
     * overrides a Smart&nbsp;GWT override point, the custom method implementation will not be called.
     *
     * @throws IllegalStateException if <code>properties</code> has been created.
     * @see com.smartgwt.client.docs.AutoChildUsage
     */
    public void setAutoChildProperties(String autoChildName, Canvas properties) 
        throws IllegalStateException 
    {
        if (properties.isCreated()) {
            ConfigUtil.warnOfPreConfigInstantiation(this.getClass(), "setAutoChildProperties",
                                                    properties.getClass());
        }
        properties.setConfigOnly(true);

        final JavaScriptObject selfJS = isCreated() ? getJsObj() : getConfig();
        JSOHelper.setAttribute(selfJS, autoChildName + "Properties",
                               JSOHelper.cleanProperties(properties.getConfig(), true));
    }

    /**
     * Sets the properties for creating a <code>FormItem</code> AutoChild named <code>autoChildName</code>.
     *
     * <p><code>properties</code> must not have already been created
     * ({@link com.smartgwt.client.widgets.form.fields.FormItem#isCreated() properties.isCreated()}
     * must be <code>false</code>).
     *
     * <p><b>NOTE:</b> Overrides at override points are not applied to AutoChildren created from
     * <code>properties</code>; that is, if the Java {@link java.lang.Class} of <code>properties</code>
     * overrides a Smart&nbsp;GWT override point, the custom method implementation will not be called.
     *
     * @throws IllegalStateException if <code>properties</code> has been created.
     * @see com.smartgwt.client.docs.AutoChildUsage
     */
    public void setAutoChildProperties(String autoChildName, FormItem properties) 
        throws IllegalStateException 
    {
        if (properties.isCreated()) {
            ConfigUtil.warnOfPreConfigInstantiation(this.getClass(), "setAutoChildProperties",
                                                    properties.getClass());
        }
        properties.setConfigOnly(true);

        final JavaScriptObject selfJS = isCreated() ? getJsObj() : getConfig();
        JSOHelper.setAttribute(selfJS, autoChildName + "Properties", 
                               properties.getEditorTypeConfig());
    }

    /**
     * Sets the properties for creating a <code>DrawItem</code> AutoChild named <code>autoChildName</code>.
     *
     * <p><code>properties</code> must not have already been created 
     * ({@link com.smartgwt.client.widgets.drawing.DrawItem#isCreated() properties.isCreated()}
     * must be <code>false</code>).
     *
     * <p><b>NOTE:</b> Overrides at override points are not applied to AutoChildren created from
     * <code>properties</code>; that is, if the Java {@link java.lang.Class} of <code>properties</code>
     * overrides a Smart&nbsp;GWT override point, the custom method implementation will not be called.
     *
     * @throws IllegalStateException if <code>properties</code> has been created.
     * @see com.smartgwt.client.docs.AutoChildUsage
     */
    public void setAutoChildProperties(String autoChildName, DrawItem properties) 
        throws IllegalStateException 
    {
        if (properties.isCreated()) {
            ConfigUtil.warnOfPreConfigInstantiation(this.getClass(), "setAutoChildProperties",
                                                    properties.getClass());
        }
        properties.setConfigOnly(true);

        final JavaScriptObject selfJS = isCreated() ? getJsObj() : getConfig();
        JSOHelper.setAttribute(selfJS, autoChildName + "Properties",
                               JSOHelper.cleanProperties(properties.getConfig(), true));
    }

    /**
     * Sets the properties for creating an AutoChild named <code>autoChildName</code>.
     *
     * <p><code>properties</code> must not have already been created
     * ({@link com.smartgwt.client.tools.EditProxy#isCreated() properties.isCreated()}
     * must be <code>false</code>).
     *
     * @throws IllegalStateException if <code>properties</code> has been created.
     * @see com.smartgwt.client.docs.AutoChildUsage
     */
    public void setAutoChildProperties(String autoChildName, EditProxy properties) 
        throws IllegalStateException 
    {
        if (properties.isCreated()) {
            ConfigUtil.warnOfPreConfigInstantiation(this.getClass(), "setAutoChildProperties",
                                                    properties.getClass());
        }
        properties.setConfigOnly(true);

        final JavaScriptObject selfJS = isCreated() ? getJsObj() : getConfig();
        JSOHelper.setAttribute(selfJS, autoChildName + "Properties",
                               JSOHelper.cleanProperties(properties.getConfig(), true));
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

    /** Expose as public the setAttribute() methods of BaseWidget **/

    public DrawItem setAttribute(String attribute, String value, boolean allowPostCreate) {
        return (DrawItem)super.setAttribute(attribute, value, allowPostCreate);
    }
    public DrawItem setAttribute(String attribute, Boolean value, boolean allowPostCreate) {
        return (DrawItem)super.setAttribute(attribute, value, allowPostCreate);
    }
    public DrawItem setAttribute(String attribute, Map value, boolean allowPostCreate) {
        return (DrawItem)super.setAttribute(attribute, value, allowPostCreate);
    }
    public DrawItem setAttribute(String attribute, int[] value, boolean allowPostCreate) {
        return (DrawItem)super.setAttribute(attribute, value, allowPostCreate);
    }
    public DrawItem setAttribute(String attribute, BaseClass[] value, boolean allowPostCreate) {
        return (DrawItem)super.setAttribute(attribute, value, allowPostCreate);
    }
    public DrawItem setAttribute(String attribute, DataClass[] value, boolean allowPostCreate) {
        return (DrawItem)super.setAttribute(attribute, value, allowPostCreate);
    }
    public DrawItem setAttribute(String attribute, double value, boolean allowPostCreate) {
        return (DrawItem)super.setAttribute(attribute, value, allowPostCreate);
    }
    public DrawItem setAttribute(String attribute, Date value, boolean allowPostCreate) {
        return (DrawItem)super.setAttribute(attribute, value, allowPostCreate);
    }
    public DrawItem setAttribute(String attribute, ValueEnum[] value, boolean allowPostCreate) {
        return (DrawItem)super.setAttribute(attribute, value, allowPostCreate);
    }
    public DrawItem setAttribute(String attribute, DataClass value, boolean allowPostCreate) {
        return (DrawItem)super.setAttribute(attribute, value, allowPostCreate);
    }
    public DrawItem setAttribute(String attribute, JavaScriptObject value, boolean allowPostCreate) {
        return (DrawItem)super.setAttribute(attribute, value, allowPostCreate);
    }
    public DrawItem setAttribute(String attribute, String[] value, boolean allowPostCreate) {
        return (DrawItem)super.setAttribute(attribute, value, allowPostCreate);
    }
    public DrawItem setAttribute(String attribute, Element value, boolean allowPostCreate) {
        return (DrawItem)super.setAttribute(attribute, value, allowPostCreate);
    }

    /** Expose as public the getAttributeAsXXX() methods of BaseWidget **/

    public String getAttributeAsString(String property) {
        return super.getAttributeAsString(property);
    }
    public Date getAttributeAsDate(String property) {
        return super.getAttributeAsDate(property);
    }
    public Integer getAttributeAsInt(String property) {
        return super.getAttributeAsInt(property);
    }
    public Double getAttributeAsDouble(String property){
        return super.getAttributeAsDouble(property);
    }
    public Element getAttributeAsElement(String property) {
        return super.getAttributeAsElement(property) ;
    }
    public JavaScriptObject getAttributeAsJavaScriptObject(String property) {
        return super.getAttributeAsJavaScriptObject(property) ;
    }
    public Float getAttributeAsFloat(String property) {
        return super.getAttributeAsFloat(property) ;
    }
    public Boolean getAttributeAsBoolean(String property) {
        return super.getAttributeAsBoolean(property) ;
    }
    public Map getAttributeAsMap(String property) {
        return super.getAttributeAsMap(property) ;
    }

    /**
     * Returns the GWT Canvas associated with this DrawItem.  Throws an InvalidDrawingTypeException if
     * the {@link com.smartgwt.client.types.DrawingType} isn't a 
     * {@link com.smartgwt.client.types.DrawingType#BITMAP}.
     * 
     * @return the GWT Canvas
     * @see addDrawStartHandler
     * @see addDrawEndHandler
     */
    public com.google.gwt.canvas.client.Canvas getUnderlyingGWTCanvas() {
        DrawPane drawPane = getDrawPane();
        return drawPane == null ? null : drawPane.getUnderlyingGWTCanvas();
    }

    /**
     * Setter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject setLogicalStructure(DrawItemLogicalStructure s) {
        super.setLogicalStructure(s);
        try {
            s.canDrag = getAttributeAsString("canDrag");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DrawItem.canDrag:" + t.getMessage() + "\n";
        }
        try {
            s.canHover = getAttributeAsString("canHover");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DrawItem.canHover:" + t.getMessage() + "\n";
        }
        try {
            s.contextMenu = getContextMenu();
        } catch (Throwable t) {
            s.logicalStructureErrors += "DrawItem.contextMenu:" + t.getMessage() + "\n";
        }
        try {
            s.cursor = getAttributeAsString("cursor");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DrawItem.cursor:" + t.getMessage() + "\n";
        }
        try {
            s.destroyed = getAttributeAsString("destroyed");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DrawItem.destroyed:" + t.getMessage() + "\n";
        }
        try {
            s.destroying = getAttributeAsString("destroying");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DrawItem.destroying:" + t.getMessage() + "\n";
        }
        try {
            s.dragStartDistance = getAttributeAsString("dragStartDistance");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DrawItem.dragStartDistance:" + t.getMessage() + "\n";
        }
        try {
            s.drawGroup = getDrawGroup();
        } catch (Throwable t) {
            s.logicalStructureErrors += "DrawItem.drawGroup:" + t.getMessage() + "\n";
        }
        try {
            s.drawPane = getDrawPane();
        } catch (Throwable t) {
            s.logicalStructureErrors += "DrawItem.drawPane:" + t.getMessage() + "\n";
        }
        try {
            s.editProxyConstructor = getAttributeAsString("editProxyConstructor");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DrawItem.editProxyConstructor:" + t.getMessage() + "\n";
        }
        try {
            s.endArrow = getAttributeAsString("endArrow");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DrawItem.endArrow:" + t.getMessage() + "\n";
        }
        try {
            s.eventOpaque = getAttributeAsString("eventOpaque");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DrawItem.eventOpaque:" + t.getMessage() + "\n";
        }
        try {
            s.fillColor = getAttributeAsString("fillColor");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DrawItem.fillColor:" + t.getMessage() + "\n";
        }
        try {
            s.fillGradientAsGradient = getFillGradient();
        } catch (Throwable t) {
            s.logicalStructureErrors += "DrawItem.fillGradientAsGradient:" + t.getMessage() + "\n";
        }
        try {
            s.fillGradientAsString = getAttributeAsString("fillGradient");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DrawItem.fillGradientAsString:" + t.getMessage() + "\n";
        }
        try {
            s.hoverDelay = getAttributeAsString("hoverDelay");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DrawItem.hoverDelay:" + t.getMessage() + "\n";
        }
        try {
            s.knobs = getAttributeAsStringArray("knobs");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DrawItem.knobsArray:" + t.getMessage() + "\n";
        }
        try {
            s.lineCap = getAttributeAsString("lineCap");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DrawItem.lineCap:" + t.getMessage() + "\n";
        }
        try {
            s.lineColor = getAttributeAsString("lineColor");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DrawItem.lineColor:" + t.getMessage() + "\n";
        }
        try {
            s.linePattern = getAttributeAsString("linePattern");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DrawItem.linePattern:" + t.getMessage() + "\n";
        }
        try {
            s.lineWidth = getAttributeAsString("lineWidth");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DrawItem.lineWidth:" + t.getMessage() + "\n";
        }
        try {
            s.moveKnobOffset = getAttributeAsStringArray("moveKnobOffset");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DrawItem.moveKnobOffsetArray:" + t.getMessage() + "\n";
        }
        try {
            s.moveKnobPoint = getAttributeAsString("moveKnobPoint");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DrawItem.moveKnobPoint:" + t.getMessage() + "\n";
        }
        try {
            s.prompt = getAttributeAsString("prompt");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DrawItem.prompt:" + t.getMessage() + "\n";
        }
        try {
            s.proportionalResizeModifiers = getAttributeAsStringArray("proportionalResizeModifiers");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DrawItem.proportionalResizeModifiersArray:" + t.getMessage() + "\n";
        }
        try {
            s.proportionalResizing = getAttributeAsString("proportionalResizing");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DrawItem.proportionalResizing:" + t.getMessage() + "\n";
        }
        try {
            s.resizeKnobPoints = getAttributeAsStringArray("resizeKnobPoints");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DrawItem.resizeKnobPointsArray:" + t.getMessage() + "\n";
        }
        try {
            s.resizeViaLocalTransformOnly = getAttributeAsString("resizeViaLocalTransformOnly");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DrawItem.resizeViaLocalTransformOnly:" + t.getMessage() + "\n";
        }
        try {
            s.scale = getAttributeAsStringArray("scale");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DrawItem.scaleArray:" + t.getMessage() + "\n";
        }
        try {
            s.shadow = getShadow();
        } catch (Throwable t) {
            s.logicalStructureErrors += "DrawItem.shadow:" + t.getMessage() + "\n";
        }
        try {
            s.showHover = getAttributeAsString("showHover");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DrawItem.showHover:" + t.getMessage() + "\n";
        }
        try {
            s.showResizeOutline = getAttributeAsString("showResizeOutline");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DrawItem.showResizeOutline:" + t.getMessage() + "\n";
        }
        try {
            s.showTitleLabelBackground = getAttributeAsString("showTitleLabelBackground");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DrawItem.showTitleLabelBackground:" + t.getMessage() + "\n";
        }
        try {
            s.startArrow = getAttributeAsString("startArrow");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DrawItem.startArrow:" + t.getMessage() + "\n";
        }
        try {
            s.title = getAttributeAsString("title");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DrawItem.title:" + t.getMessage() + "\n";
        }
        try {
            s.titleAutoFit = getAttributeAsString("titleAutoFit");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DrawItem.titleAutoFit:" + t.getMessage() + "\n";
        }
        try {
            s.titleAutoFitMargin = getAttributeAsString("titleAutoFitMargin");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DrawItem.titleAutoFitMargin:" + t.getMessage() + "\n";
        }
        try {
            s.titleAutoFitRotationMode = getAttributeAsString("titleAutoFitRotationMode");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DrawItem.titleAutoFitRotationMode:" + t.getMessage() + "\n";
        }
        try {
            s.titleLabelPadding = getAttributeAsString("titleLabelPadding");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DrawItem.titleLabelPadding:" + t.getMessage() + "\n";
        }
        try {
            s.titleRotationMode = getAttributeAsString("titleRotationMode");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DrawItem.titleRotationMode:" + t.getMessage() + "\n";
        }
        try {
            s.translate = getAttributeAsStringArray("translate");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DrawItem.translateArray:" + t.getMessage() + "\n";
        }
        try {
            s.useSimpleTransform = getAttributeAsString("useSimpleTransform");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DrawItem.useSimpleTransform:" + t.getMessage() + "\n";
        }
        try {
            s.xShearFactor = getAttributeAsString("xShearFactor");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DrawItem.xShearFactor:" + t.getMessage() + "\n";
        }
        try {
            s.yShearFactor = getAttributeAsString("yShearFactor");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DrawItem.yShearFactor:" + t.getMessage() + "\n";
        }
        try {
            s.zIndex = getAttributeAsString("zIndex");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DrawItem.zIndex:" + t.getMessage() + "\n";
        }
        return s;
    }

    /**
     * Getter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject getLogicalStructure() {
        DrawItemLogicalStructure s = new DrawItemLogicalStructure();
        setLogicalStructure(s);
        return s;
    }
}
