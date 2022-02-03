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
import com.smartgwt.client.data.Record;
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
import com.smartgwt.client.widgets.drawing.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
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
 * com.smartgwt.client.widgets.tree.TreeGrid#getCustomIconDropProperty showDropIcon}).  Likewise a PaletteNode in a
 * MenuPalette can have the properties of a {@link com.smartgwt.client.widgets.menu.MenuItem}, such as {@link
 * com.smartgwt.client.widgets.menu.MenuItem#enableIf MenuItem.enableIf()}.
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
     * If set to false, indicates that this node cannot be  {@link com.smartgwt.client.tools.EditProxy#getUseCopyPasteShortcuts
     * copy &amp; pasted}, including disallowing calls to {@link com.smartgwt.client.tools.EditContext#makePaletteNode
     * EditContext.makePaletteNode()} for {@link com.smartgwt.client.tools.EditNode EditNodes} created from this {@link
     * com.smartgwt.client.tools.PaletteNode PaletteNode}.
     *
     * @param canDuplicate New canDuplicate value. Default value is null
     * @return {@link com.smartgwt.client.tools.PaletteNode PaletteNode} instance, for chaining setter calls
     */
    public PaletteNode setCanDuplicate(Boolean canDuplicate) {
        return (PaletteNode)setAttribute("canDuplicate", canDuplicate);
    }

    /**
     * If set to false, indicates that this node cannot be  {@link com.smartgwt.client.tools.EditProxy#getUseCopyPasteShortcuts
     * copy &amp; pasted}, including disallowing calls to {@link com.smartgwt.client.tools.EditContext#makePaletteNode
     * EditContext.makePaletteNode()} for {@link com.smartgwt.client.tools.EditNode EditNodes} created from this {@link
     * com.smartgwt.client.tools.PaletteNode PaletteNode}.
     *
     * @return Current canDuplicate value. Default value is null
     */
    public Boolean getCanDuplicate()  {
        return getAttributeAsBoolean("canDuplicate", true);
    }
    

    /**
     * Defaults for the component to be created from this palette.   <p> For example, if {@link
     * com.smartgwt.client.tools.PaletteNode#getType type} is "ListGrid", properties valid to pass to  ListGrid.create(). <p>
     * Note that event handlers or method overrides cannot be configured as <code>defaults</code>, as they cannot be serialized
     * or restored.  Instead, create a subclass that implements the desired behaviors, and use that subclass as {@link
     * com.smartgwt.client.tools.PaletteNode#getType type}.   <p>See also {@link com.smartgwt.client.docs.Reflection} for
     * special concerns when making a GWT subclass usable in {@link com.smartgwt.client.docs.ComponentXML Component XML} and 
     * {@link com.smartgwt.client.docs.DevTools Dashboards &amp; Tools} in general.
     *
     * @param defaults New defaults value. Default value is null
     * @return {@link com.smartgwt.client.tools.PaletteNode PaletteNode} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public PaletteNode setCanvasDefaults(Canvas defaults) {
        if (defaults != null) {
            if (defaults.isCreated()) {
                ConfigUtil.warnOfPreConfigInstantiation(PaletteNode.class, "setCanvasDefaults", "Canvas");
            }                                                                       
            defaults.setConfigOnly(true);
        }
        JavaScriptObject config = defaults == null ? null : defaults.getConfig();
        return (PaletteNode)setAttribute("defaults", JSOHelper.cleanProperties(config, true));
    }

    /**
     * Defaults for the component to be created from this palette.   <p> For example, if {@link
     * com.smartgwt.client.tools.PaletteNode#getType type} is "ListGrid", properties valid to pass to  ListGrid.create(). <p>
     * Note that event handlers or method overrides cannot be configured as <code>defaults</code>, as they cannot be serialized
     * or restored.  Instead, create a subclass that implements the desired behaviors, and use that subclass as {@link
     * com.smartgwt.client.tools.PaletteNode#getType type}.   <p>See also {@link com.smartgwt.client.docs.Reflection} for
     * special concerns when making a GWT subclass usable in {@link com.smartgwt.client.docs.ComponentXML Component XML} and 
     * {@link com.smartgwt.client.docs.DevTools Dashboards &amp; Tools} in general.
     *
     * @return Current defaults value. Default value is null
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
     * com.smartgwt.client.tools.EditNode#getLiveObject EditNode.liveObject} for the created editNode.
     *
     * @param liveObject New liveObject value. Default value is null
     * @return {@link com.smartgwt.client.tools.PaletteNode PaletteNode} instance, for chaining setter calls
     */
    public PaletteNode setCanvasLiveObject(Canvas liveObject) {
        return (PaletteNode)setAttribute("liveObject", liveObject == null ? null : liveObject.getOrCreateJsObj());
    }

    /**
     * For a paletteNode which should be a "singleton", that is, always provides the exact same object (==) rather than a
     * dynamically created copy, provide the singleton object as <code>liveObject</code>. <P> Instead of dynamically creating
     * an object from defaults, the <code>liveObject</code> will simply be assigned to {@link
     * com.smartgwt.client.tools.EditNode#getLiveObject EditNode.liveObject} for the created editNode.
     *
     * @return Current liveObject value. Default value is null
     */
    public Canvas getCanvasLiveObject()  {
        return (Canvas)Canvas.getByJSObject(getAttributeAsJavaScriptObject("liveObject"));
    }
    
    

    /**
     * Defaults for the component to be created from this palette.   <p> For example, if {@link
     * com.smartgwt.client.tools.PaletteNode#getType type} is "ListGrid", properties valid to pass to  ListGrid.create(). <p>
     * Note that event handlers or method overrides cannot be configured as <code>defaults</code>, as they cannot be serialized
     * or restored.  Instead, create a subclass that implements the desired behaviors, and use that subclass as {@link
     * com.smartgwt.client.tools.PaletteNode#getType type}.   <p>See also {@link com.smartgwt.client.docs.Reflection} for
     * special concerns when making a GWT subclass usable in {@link com.smartgwt.client.docs.ComponentXML Component XML} and 
     * {@link com.smartgwt.client.docs.DevTools Dashboards &amp; Tools} in general.
     *
     * @param defaults New defaults value. Default value is null
     * @return {@link com.smartgwt.client.tools.PaletteNode PaletteNode} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public PaletteNode setDrawItemDefaults(DrawItem defaults) {
        if (defaults != null) {
            if (defaults.isCreated()) {
                ConfigUtil.warnOfPreConfigInstantiation(PaletteNode.class, "setDrawItemDefaults", "DrawItem");
            }                                                                       
            defaults.setConfigOnly(true);
        }
        JavaScriptObject config = defaults == null ? null : defaults.getConfig();
        return (PaletteNode)setAttribute("defaults", JSOHelper.cleanProperties(config, true));
    }

    /**
     * Defaults for the component to be created from this palette.   <p> For example, if {@link
     * com.smartgwt.client.tools.PaletteNode#getType type} is "ListGrid", properties valid to pass to  ListGrid.create(). <p>
     * Note that event handlers or method overrides cannot be configured as <code>defaults</code>, as they cannot be serialized
     * or restored.  Instead, create a subclass that implements the desired behaviors, and use that subclass as {@link
     * com.smartgwt.client.tools.PaletteNode#getType type}.   <p>See also {@link com.smartgwt.client.docs.Reflection} for
     * special concerns when making a GWT subclass usable in {@link com.smartgwt.client.docs.ComponentXML Component XML} and 
     * {@link com.smartgwt.client.docs.DevTools Dashboards &amp; Tools} in general.
     *
     * @return Current defaults value. Default value is null
     */
    public DrawItem getDrawItemDefaults()  {
        DrawItem properties = new DrawItem();
        properties.setConfigOnly(true);
        properties.setConfig(getAttributeAsJavaScriptObject("defaults"));
        return properties;
    }
    

    /**
     * For a paletteNode which should be a "singleton", that is, always provides the exact same object (==) rather than a
     * dynamically created copy, provide the singleton object as <code>liveObject</code>. <P> Instead of dynamically creating
     * an object from defaults, the <code>liveObject</code> will simply be assigned to {@link
     * com.smartgwt.client.tools.EditNode#getLiveObject EditNode.liveObject} for the created editNode.
     *
     * @param liveObject New liveObject value. Default value is null
     * @return {@link com.smartgwt.client.tools.PaletteNode PaletteNode} instance, for chaining setter calls
     */
    public PaletteNode setDrawItemLiveObject(DrawItem liveObject) {
        return (PaletteNode)setAttribute("liveObject", liveObject == null ? null : liveObject.getOrCreateJsObj());
    }

    /**
     * For a paletteNode which should be a "singleton", that is, always provides the exact same object (==) rather than a
     * dynamically created copy, provide the singleton object as <code>liveObject</code>. <P> Instead of dynamically creating
     * an object from defaults, the <code>liveObject</code> will simply be assigned to {@link
     * com.smartgwt.client.tools.EditNode#getLiveObject EditNode.liveObject} for the created editNode.
     *
     * @return Current liveObject value. Default value is null
     */
    public DrawItem getDrawItemLiveObject()  {
        return (DrawItem)DrawItem.getByJSObject(getAttributeAsJavaScriptObject("liveObject"));
    }
    

    /**
     * Defaults for the component to be created from this palette.   <p> For example, if {@link
     * com.smartgwt.client.tools.PaletteNode#getType type} is "ListGrid", properties valid to pass to  ListGrid.create(). <p>
     * Note that event handlers or method overrides cannot be configured as <code>defaults</code>, as they cannot be serialized
     * or restored.  Instead, create a subclass that implements the desired behaviors, and use that subclass as {@link
     * com.smartgwt.client.tools.PaletteNode#getType type}.   <p>See also {@link com.smartgwt.client.docs.Reflection} for
     * special concerns when making a GWT subclass usable in {@link com.smartgwt.client.docs.ComponentXML Component XML} and 
     * {@link com.smartgwt.client.docs.DevTools Dashboards &amp; Tools} in general.
     *
     * @param defaults New defaults value. Default value is null
     * @return {@link com.smartgwt.client.tools.PaletteNode PaletteNode} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public PaletteNode setDrawPaneDefaults(DrawPane defaults) {
        if (defaults != null) {
            if (defaults.isCreated()) {
                ConfigUtil.warnOfPreConfigInstantiation(PaletteNode.class, "setDrawPaneDefaults", "DrawPane");
            }                                                                       
            defaults.setConfigOnly(true);
        }
        JavaScriptObject config = defaults == null ? null : defaults.getConfig();
        return (PaletteNode)setAttribute("defaults", JSOHelper.cleanProperties(config, true));
    }

    /**
     * Defaults for the component to be created from this palette.   <p> For example, if {@link
     * com.smartgwt.client.tools.PaletteNode#getType type} is "ListGrid", properties valid to pass to  ListGrid.create(). <p>
     * Note that event handlers or method overrides cannot be configured as <code>defaults</code>, as they cannot be serialized
     * or restored.  Instead, create a subclass that implements the desired behaviors, and use that subclass as {@link
     * com.smartgwt.client.tools.PaletteNode#getType type}.   <p>See also {@link com.smartgwt.client.docs.Reflection} for
     * special concerns when making a GWT subclass usable in {@link com.smartgwt.client.docs.ComponentXML Component XML} and 
     * {@link com.smartgwt.client.docs.DevTools Dashboards &amp; Tools} in general.
     *
     * @return Current defaults value. Default value is null
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
     * com.smartgwt.client.tools.EditNode#getLiveObject EditNode.liveObject} for the created editNode.
     *
     * @param liveObject New liveObject value. Default value is null
     * @return {@link com.smartgwt.client.tools.PaletteNode PaletteNode} instance, for chaining setter calls
     */
    public PaletteNode setDrawPaneLiveObject(DrawPane liveObject) {
        return (PaletteNode)setAttribute("liveObject", liveObject == null ? null : liveObject.getOrCreateJsObj());
    }

    /**
     * For a paletteNode which should be a "singleton", that is, always provides the exact same object (==) rather than a
     * dynamically created copy, provide the singleton object as <code>liveObject</code>. <P> Instead of dynamically creating
     * an object from defaults, the <code>liveObject</code> will simply be assigned to {@link
     * com.smartgwt.client.tools.EditNode#getLiveObject EditNode.liveObject} for the created editNode.
     *
     * @return Current liveObject value. Default value is null
     */
    public DrawPane getDrawPaneLiveObject()  {
        return (DrawPane)DrawPane.getByJSObject(getAttributeAsJavaScriptObject("liveObject"));
    }
    

    /**
     * Properties to be applied to the {@link com.smartgwt.client.tools.EditNode editNode} when created.
     *
     * @param editNodeProperties New editNodeProperties value. Default value is null
     * @return {@link com.smartgwt.client.tools.PaletteNode PaletteNode} instance, for chaining setter calls
     */
    public PaletteNode setEditNodeProperties(EditNode editNodeProperties) {
        JavaScriptObject config = JSOHelper.createObject();
        if (editNodeProperties != null) {
            JSOHelper.addProperties(config, editNodeProperties.getJsObj());
        }
        return (PaletteNode)setAttribute("editNodeProperties", editNodeProperties == null ? null : config);
    }

    /**
     * Properties to be applied to the {@link com.smartgwt.client.tools.EditNode editNode} when created.
     *
     * @return Current editNodeProperties value. Default value is null
     */
    public EditNode getEditNodeProperties()  {
        return new EditNode(getAttributeAsJavaScriptObject("editNodeProperties"));
    }
    

    /**
     * Properties to be applied to the  {@link com.smartgwt.client.tools.PaletteNode#getLiveObject liveObject}.{@link
     * com.smartgwt.client.widgets.Canvas#getEditProxy editProxy} when created.
     *
     * @param editProxyProperties New editProxyProperties value. Default value is null
     * @return {@link com.smartgwt.client.tools.PaletteNode PaletteNode} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public PaletteNode setEditProxyProperties(EditProxy editProxyProperties) {
        if (editProxyProperties != null) {
            if (editProxyProperties.isCreated()) {
                ConfigUtil.warnOfPreConfigInstantiation(PaletteNode.class, "setEditProxyProperties", "EditProxy");
            }                                                                       
            editProxyProperties.setConfigOnly(true);
        }
        JavaScriptObject config = editProxyProperties == null ? null : editProxyProperties.getConfig();
        return (PaletteNode)setAttribute("editProxyProperties", JSOHelper.cleanProperties(config, true));
    }

    /**
     * Properties to be applied to the  {@link com.smartgwt.client.tools.PaletteNode#getLiveObject liveObject}.{@link
     * com.smartgwt.client.widgets.Canvas#getEditProxy editProxy} when created.
     *
     * @return Current editProxyProperties value. Default value is null
     */
    public EditProxy getEditProxyProperties()  {
        return EditProxy.getOrCreateRef(getAttributeAsJavaScriptObject("editProxyProperties"));
    }
    

    /**
     * Defaults for the component to be created from this palette.   <p> For example, if {@link
     * com.smartgwt.client.tools.PaletteNode#getType type} is "ListGrid", properties valid to pass to  ListGrid.create(). <p>
     * Note that event handlers or method overrides cannot be configured as <code>defaults</code>, as they cannot be serialized
     * or restored.  Instead, create a subclass that implements the desired behaviors, and use that subclass as {@link
     * com.smartgwt.client.tools.PaletteNode#getType type}.   <p>See also {@link com.smartgwt.client.docs.Reflection} for
     * special concerns when making a GWT subclass usable in {@link com.smartgwt.client.docs.ComponentXML Component XML} and 
     * {@link com.smartgwt.client.docs.DevTools Dashboards &amp; Tools} in general.
     *
     * @param defaults New defaults value. Default value is null
     * @return {@link com.smartgwt.client.tools.PaletteNode PaletteNode} instance, for chaining setter calls
     */
    public PaletteNode setFormItemDefaults(FormItem defaults) {
        return (PaletteNode)setAttribute("defaults", defaults == null ? null : defaults.getJsObj());
    }

    /**
     * Defaults for the component to be created from this palette.   <p> For example, if {@link
     * com.smartgwt.client.tools.PaletteNode#getType type} is "ListGrid", properties valid to pass to  ListGrid.create(). <p>
     * Note that event handlers or method overrides cannot be configured as <code>defaults</code>, as they cannot be serialized
     * or restored.  Instead, create a subclass that implements the desired behaviors, and use that subclass as {@link
     * com.smartgwt.client.tools.PaletteNode#getType type}.   <p>See also {@link com.smartgwt.client.docs.Reflection} for
     * special concerns when making a GWT subclass usable in {@link com.smartgwt.client.docs.ComponentXML Component XML} and 
     * {@link com.smartgwt.client.docs.DevTools Dashboards &amp; Tools} in general.
     *
     * @return Current defaults value. Default value is null
     */
    public FormItem getFormItemDefaults()  {
        return FormItem.getOrCreateRef(getAttributeAsJavaScriptObject("defaults"));
    }
    

    /**
     * For a paletteNode which should be a "singleton", that is, always provides the exact same object (==) rather than a
     * dynamically created copy, provide the singleton object as <code>liveObject</code>. <P> Instead of dynamically creating
     * an object from defaults, the <code>liveObject</code> will simply be assigned to {@link
     * com.smartgwt.client.tools.EditNode#getLiveObject EditNode.liveObject} for the created editNode.
     *
     * @param liveObject New liveObject value. Default value is null
     * @return {@link com.smartgwt.client.tools.PaletteNode PaletteNode} instance, for chaining setter calls
     */
    public PaletteNode setFormItemLiveObject(FormItem liveObject) {
        return (PaletteNode)setAttribute("liveObject", liveObject == null ? null : liveObject.getJsObj());
    }

    /**
     * For a paletteNode which should be a "singleton", that is, always provides the exact same object (==) rather than a
     * dynamically created copy, provide the singleton object as <code>liveObject</code>. <P> Instead of dynamically creating
     * an object from defaults, the <code>liveObject</code> will simply be assigned to {@link
     * com.smartgwt.client.tools.EditNode#getLiveObject EditNode.liveObject} for the created editNode.
     *
     * @return Current liveObject value. Default value is null
     */
    public FormItem getFormItemLiveObject()  {
        return FormItem.getOrCreateRef(getAttributeAsJavaScriptObject("liveObject"));
    }
    

    /**
     * Icon for this paletteNode.
     *
     * @param icon New icon value. Default value is null
     * @return {@link com.smartgwt.client.tools.PaletteNode PaletteNode} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     */
    public PaletteNode setIcon(String icon) {
        return (PaletteNode)setAttribute("icon", icon);
    }

    /**
     * Icon for this paletteNode.
     *
     * @return Current icon value. Default value is null
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     */
    public String getIcon()  {
        return getAttributeAsString("icon");
    }
    

    /**
     * Name used to create unique component ID. If not specified, {@link com.smartgwt.client.tools.PaletteNode#getType type} is
     * used. <p> Note: idName must follow all rules for a {@link com.smartgwt.client.docs.Identifier}.
     *
     * @param idName New idName value. Default value is null
     * @return {@link com.smartgwt.client.tools.PaletteNode PaletteNode} instance, for chaining setter calls
     */
    public PaletteNode setIdName(String idName) {
        return (PaletteNode)setAttribute("idName", idName);
    }

    /**
     * Name used to create unique component ID. If not specified, {@link com.smartgwt.client.tools.PaletteNode#getType type} is
     * used. <p> Note: idName must follow all rules for a {@link com.smartgwt.client.docs.Identifier}.
     *
     * @return Current idName value. Default value is null
     */
    public String getIdName()  {
        return getAttributeAsString("idName");
    }
    

    /**
     * Prefix used to create unique component ID. If not specified, {@link com.smartgwt.client.tools.PaletteNode#getType type}
     * is used.
     *
     * @param idPrefix New idPrefix value. Default value is null
     * @return {@link com.smartgwt.client.tools.PaletteNode PaletteNode} instance, for chaining setter calls
     * @deprecated As of Smart GWT version 12.1, deprecated in favor of {@link com.smartgwt.client.tools.PaletteNode#getIdName idName}
     */
    public PaletteNode setIdPrefix(String idPrefix) {
        return (PaletteNode)setAttribute("idPrefix", idPrefix);
    }

    /**
     * Prefix used to create unique component ID. If not specified, {@link com.smartgwt.client.tools.PaletteNode#getType type}
     * is used.
     *
     * @return Current idPrefix value. Default value is null
     * @deprecated As of Smart GWT version 12.1, deprecated in favor of {@link com.smartgwt.client.tools.PaletteNode#getIdName idName}
     */
    public String getIdPrefix()  {
        return getAttributeAsString("idPrefix");
    }
    
    

    /**
     * Textual title for this paletteNode.
     *
     * @param title New title value. Default value is null
     * @return {@link com.smartgwt.client.tools.PaletteNode PaletteNode} instance, for chaining setter calls
     */
    public PaletteNode setTitle(String title) {
        return (PaletteNode)setAttribute("title", title);
    }

    /**
     * Textual title for this paletteNode.
     *
     * @return Current title value. Default value is null
     */
    public String getTitle()  {
        return getAttributeAsString("title");
    }
    

    /**
     * String this paletteNode creates, for example, "ListGrid".
     *
     * @param type New type value. Default value is null
     * @return {@link com.smartgwt.client.tools.PaletteNode PaletteNode} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.SCClassName SCClassName 
     */
    public PaletteNode setType(String type) {
        return (PaletteNode)setAttribute("type", type);
    }

    /**
     * String this paletteNode creates, for example, "ListGrid".
     *
     * @return Current type value. Default value is null
     * @see com.smartgwt.client.docs.SCClassName SCClassName 
     */
    public String getType()  {
        return getAttributeAsString("type");
    }
    

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************

    // ***********************************************************


    /**
     * For a paletteNode which should be a "singleton", that is, always provides the exact same
     * object (==) rather than a dynamically created copy, provide the singleton object as
     * <code>liveObject</code>. 
     * <P> 
     * Instead of dynamically creating an object from defaults, the <code>liveObject</code> will
     * simply be assigned to 
     * {@link com.smartgwt.client.tools.EditNode#getLiveObject EditNode.liveObject} for the
     * created editNode.
     * <P>
     * Use the more specific live object getter API, such as 
     * {@link com.smartgwt.client.tools.PaletteNode#getCanvasLiveObject getCanvasLiveObject()}
     * if you are sure of the type.
     *
     * @return Object
     * @see #getCanvasLiveObject()
     * @see #getDrawItemLiveObject()
     * @see #getDrawPaneLiveObject()
     * @see #getFormItemLiveObject()
     */
    public Object getLiveObject()  {
        JavaScriptObject liveObjectJS = getAttributeAsJavaScriptObject("liveObject");
        // actual Java class should be either a BaseWidget or FormItem
        Object liveObject = BaseWidget.getByJSObject(liveObjectJS);
        return liveObject == null ? FormItem.getOrCreateRef(liveObjectJS) : liveObject;
    }

}
