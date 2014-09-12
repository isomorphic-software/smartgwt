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
 
package com.smartgwt.client.tools;


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
 * An object representing a component which the user may create dynamically within an application. <P> A PaletteNode
 * expresses visual properties for how the palette will display it (eg {@link
 * com.smartgwt.client.tools.PaletteNode#getTitle title}, {@link com.smartgwt.client.tools.PaletteNode#getIcon icon}) as
 * well as instructions for creating the component the paletteNode represents ({@link
 * com.smartgwt.client.tools.PaletteNode#getType type}, {@link com.smartgwt.client.tools.PaletteNode#getDefaults
 * defaults}). <P> Various types of palettes ({@link com.smartgwt.client.tools.ListPalette}, {@link
 * com.smartgwt.client.tools.TreePalette}, {@link com.smartgwt.client.tools.MenuPalette}, {@link
 * com.smartgwt.client.tools.TilePalette}) render a PaletteNode in different ways, and allow the user to trigger creation
 * in different ways (eg drag and drop, or just click).  All share a common pattern for how components are created from
 * palettes. <P> Note that in a TreePalette, a PaletteNode is essentially a {@link
 * com.smartgwt.client.widgets.tree.TreeNode} and can have properties expected for a TreeNode (eg, {@link
 * com.smartgwt.client.widgets.tree.TreeGrid#getCustomIconDropProperty showDropIcon}.  Likewise a PaletteNode in a
 * MenuPalette can have the properties of a {@link com.smartgwt.client.widgets.menu.MenuItem}, such as {@link
 * com.smartgwt.client.widgets.menu.MenuItem#enableIf MenuItem.enableIf}.
 */
@BeanFactory.FrameworkClass
public class PaletteNode extends TreeNode {

    public static PaletteNode getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        return new PaletteNode(jsObj);
    }


    public PaletteNode(){
        
    }

    public PaletteNode(JavaScriptObject jsObj){
        
        setJavaScriptObject(jsObj);
    }


    // ********************* Properties / Attributes ***********************

    /**
     * Defaults for the component to be created from this palette.   <P> For example, if {@link
     * com.smartgwt.client.tools.PaletteNode#getType type} is "ListGrid", properties valid to pass to  ListGrid.create().
     *
     * @param defaults  Default value is null
     */
    public void setCanvasDefaults(Canvas defaults) {
        JavaScriptObject config = defaults == null ? null : defaults.getConfig();
        setAttribute("defaults", JSOHelper.cleanProperties(config, true));
    }

    /**
     * Defaults for the component to be created from this palette.   <P> For example, if {@link
     * com.smartgwt.client.tools.PaletteNode#getType type} is "ListGrid", properties valid to pass to  ListGrid.create().
     *
     * @return Canvas
     */
    public Canvas getCanvasDefaults()  {
        Canvas properties = new Canvas();
        properties.setConfigOnly(true);
        properties.setConfig(getAttributeAsJavaScriptObject("defaults"));
        return properties;
    }
    

    /**
     * For a paletteNode which should be a "singleton", that is, always provides the exact same object (==) rather than a
     * dynamically created copy, provide the singleton object as <code>liveObject</code>. <P> Instead of dynamically creating
     * an object from defaults, the <code>liveObject</code> will simply be assigned to {@link
     * com.smartgwt.client.tools.EditNode#getLiveObject liveObject} for the created editNode.
     *
     * @param liveObject  Default value is null
     */
    public void setCanvasLiveObject(Canvas liveObject) {
        setAttribute("liveObject", liveObject == null ? null : liveObject.getOrCreateJsObj());
    }

    /**
     * For a paletteNode which should be a "singleton", that is, always provides the exact same object (==) rather than a
     * dynamically created copy, provide the singleton object as <code>liveObject</code>. <P> Instead of dynamically creating
     * an object from defaults, the <code>liveObject</code> will simply be assigned to {@link
     * com.smartgwt.client.tools.EditNode#getLiveObject liveObject} for the created editNode.
     *
     * @return Canvas
     */
    public Canvas getCanvasLiveObject()  {
        return (Canvas)Canvas.getByJSObject(getAttributeAsJavaScriptObject("liveObject"));
    }
    
    

    /**
     * Defaults for the component to be created from this palette.   <P> For example, if {@link
     * com.smartgwt.client.tools.PaletteNode#getType type} is "ListGrid", properties valid to pass to  ListGrid.create().
     *
     * @param defaults  Default value is null
     */
    public void setDrawItemDefaults(DrawItem defaults) {
        JavaScriptObject config = defaults == null ? null : defaults.getConfig();
        setAttribute("defaults", JSOHelper.cleanProperties(config, true));
    }

    /**
     * Defaults for the component to be created from this palette.   <P> For example, if {@link
     * com.smartgwt.client.tools.PaletteNode#getType type} is "ListGrid", properties valid to pass to  ListGrid.create().
     *
     * @return DrawItem
     */
    public DrawItem getDrawItemDefaults()  {
        return DrawItem.getOrCreateRef(getAttributeAsJavaScriptObject("defaults"));
    }
    

    /**
     * For a paletteNode which should be a "singleton", that is, always provides the exact same object (==) rather than a
     * dynamically created copy, provide the singleton object as <code>liveObject</code>. <P> Instead of dynamically creating
     * an object from defaults, the <code>liveObject</code> will simply be assigned to {@link
     * com.smartgwt.client.tools.EditNode#getLiveObject liveObject} for the created editNode.
     *
     * @param liveObject  Default value is null
     */
    public void setDrawItemLiveObject(DrawItem liveObject) {
        setAttribute("liveObject", liveObject == null ? null : liveObject.getOrCreateJsObj());
    }

    /**
     * For a paletteNode which should be a "singleton", that is, always provides the exact same object (==) rather than a
     * dynamically created copy, provide the singleton object as <code>liveObject</code>. <P> Instead of dynamically creating
     * an object from defaults, the <code>liveObject</code> will simply be assigned to {@link
     * com.smartgwt.client.tools.EditNode#getLiveObject liveObject} for the created editNode.
     *
     * @return DrawItem
     */
    public DrawItem getDrawItemLiveObject()  {
        return DrawItem.getOrCreateRef(getAttributeAsJavaScriptObject("liveObject"));
    }
    

    /**
     * Defaults for the component to be created from this palette.   <P> For example, if {@link
     * com.smartgwt.client.tools.PaletteNode#getType type} is "ListGrid", properties valid to pass to  ListGrid.create().
     *
     * @param defaults  Default value is null
     */
    public void setDrawPaneDefaults(DrawPane defaults) {
        JavaScriptObject config = defaults == null ? null : defaults.getConfig();
        setAttribute("defaults", JSOHelper.cleanProperties(config, true));
    }

    /**
     * Defaults for the component to be created from this palette.   <P> For example, if {@link
     * com.smartgwt.client.tools.PaletteNode#getType type} is "ListGrid", properties valid to pass to  ListGrid.create().
     *
     * @return DrawPane
     */
    public DrawPane getDrawPaneDefaults()  {
        DrawPane properties = new DrawPane();
        properties.setConfigOnly(true);
        properties.setConfig(getAttributeAsJavaScriptObject("defaults"));
        return properties;
    }
    

    /**
     * For a paletteNode which should be a "singleton", that is, always provides the exact same object (==) rather than a
     * dynamically created copy, provide the singleton object as <code>liveObject</code>. <P> Instead of dynamically creating
     * an object from defaults, the <code>liveObject</code> will simply be assigned to {@link
     * com.smartgwt.client.tools.EditNode#getLiveObject liveObject} for the created editNode.
     *
     * @param liveObject  Default value is null
     */
    public void setDrawPaneLiveObject(DrawPane liveObject) {
        setAttribute("liveObject", liveObject == null ? null : liveObject.getOrCreateJsObj());
    }

    /**
     * For a paletteNode which should be a "singleton", that is, always provides the exact same object (==) rather than a
     * dynamically created copy, provide the singleton object as <code>liveObject</code>. <P> Instead of dynamically creating
     * an object from defaults, the <code>liveObject</code> will simply be assigned to {@link
     * com.smartgwt.client.tools.EditNode#getLiveObject liveObject} for the created editNode.
     *
     * @return DrawPane
     */
    public DrawPane getDrawPaneLiveObject()  {
        return (DrawPane)DrawPane.getByJSObject(getAttributeAsJavaScriptObject("liveObject"));
    }
    

    /**
     * Properties to be applied to the  {@link com.smartgwt.client.tools.PaletteNode#getLiveObject liveObject}.{@link
     * com.smartgwt.client.widgets.Canvas#getEditProxy editProxy} when created.
     *
     * @param editProxyProperties  Default value is null
     */
    public void setEditProxyProperties(EditProxy editProxyProperties) {
        JavaScriptObject config = editProxyProperties == null ? null : editProxyProperties.getConfig();
        setAttribute("editProxyProperties", JSOHelper.cleanProperties(config, true));
    }

    /**
     * Properties to be applied to the  {@link com.smartgwt.client.tools.PaletteNode#getLiveObject liveObject}.{@link
     * com.smartgwt.client.widgets.Canvas#getEditProxy editProxy} when created.
     *
     * @return EditProxy
     */
    public EditProxy getEditProxyProperties()  {
        return EditProxy.getOrCreateRef(getAttributeAsJavaScriptObject("editProxyProperties"));
    }
    

    /**
     * Defaults for the component to be created from this palette.   <P> For example, if {@link
     * com.smartgwt.client.tools.PaletteNode#getType type} is "ListGrid", properties valid to pass to  ListGrid.create().
     *
     * @param defaults  Default value is null
     */
    public void setFormItemDefaults(FormItem defaults) {
        setAttribute("defaults", defaults.getJsObj());
    }

    /**
     * Defaults for the component to be created from this palette.   <P> For example, if {@link
     * com.smartgwt.client.tools.PaletteNode#getType type} is "ListGrid", properties valid to pass to  ListGrid.create().
     *
     * @return FormItem
     */
    public FormItem getFormItemDefaults()  {
        return FormItem.getOrCreateRef(getAttributeAsJavaScriptObject("defaults"));
    }
    

    /**
     * For a paletteNode which should be a "singleton", that is, always provides the exact same object (==) rather than a
     * dynamically created copy, provide the singleton object as <code>liveObject</code>. <P> Instead of dynamically creating
     * an object from defaults, the <code>liveObject</code> will simply be assigned to {@link
     * com.smartgwt.client.tools.EditNode#getLiveObject liveObject} for the created editNode.
     *
     * @param liveObject  Default value is null
     */
    public void setFormItemLiveObject(FormItem liveObject) {
        setAttribute("liveObject", liveObject.getJsObj());
    }

    /**
     * For a paletteNode which should be a "singleton", that is, always provides the exact same object (==) rather than a
     * dynamically created copy, provide the singleton object as <code>liveObject</code>. <P> Instead of dynamically creating
     * an object from defaults, the <code>liveObject</code> will simply be assigned to {@link
     * com.smartgwt.client.tools.EditNode#getLiveObject liveObject} for the created editNode.
     *
     * @return FormItem
     */
    public FormItem getFormItemLiveObject()  {
        return FormItem.getOrCreateRef(getAttributeAsJavaScriptObject("liveObject"));
    }
    

    /**
     * Icon for this paletteNode.
     *
     * @param icon  See {@link com.smartgwt.client.docs.SCImgURL SCImgURL} . Default value is null
     */
    public void setIcon(String icon) {
        setAttribute("icon", icon);
    }

    /**
     * Icon for this paletteNode.
     *
     * @return  See {@link com.smartgwt.client.docs.SCImgURL SCImgURL} 
     */
    public String getIcon()  {
        return getAttributeAsString("icon");
    }
    
    

    /**
     * Textual title for this paletteNode.
     *
     * @param title  Default value is null
     */
    public void setTitle(String title) {
        setAttribute("title", title);
    }

    /**
     * Textual title for this paletteNode.
     *
     * @return String
     */
    public String getTitle()  {
        return getAttributeAsString("title");
    }
    

    /**
     * String this paletteNode creates, for example, "ListGrid".
     *
     * @param type  See {@link com.smartgwt.client.docs.SCClassName SCClassName} . Default value is null
     */
    public void setType(String type) {
        setAttribute("type", type);
    }

    /**
     * String this paletteNode creates, for example, "ListGrid".
     *
     * @return  See {@link com.smartgwt.client.docs.SCClassName SCClassName} 
     */
    public String getType()  {
        return getAttributeAsString("type");
    }
    

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************

    // ***********************************************************

}


