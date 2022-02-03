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

import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;
import com.smartgwt.client.util.*;
import com.smartgwt.client.util.events.*;
import com.smartgwt.client.util.workflow.*;
import com.google.gwt.event.shared.*;
import com.google.gwt.event.shared.HasHandlers;

/**
 * An object representing a component that is currently being edited within an {@link
 * com.smartgwt.client.tools.EditContext}. <P> An EditNode is essentially a copy of a {@link
 * com.smartgwt.client.tools.PaletteNode}, initially with the same properties as the PaletteNode from which it was
 * generated.  However unlike a PaletteNode, an EditNode  always has a {@link
 * com.smartgwt.client.tools.EditNode#getLiveObject liveObject} - the object created from the  {@link
 * com.smartgwt.client.tools.PaletteNode#getDefaults PaletteNode.defaults} or other properties defined on a paletteNode.
 * <P> Like a Palette, an EditContext may use properties such as {@link com.smartgwt.client.tools.PaletteNode#getIcon
 * PaletteNode.icon} or  {@link com.smartgwt.client.tools.PaletteNode#getTitle PaletteNode.title} to display EditNodes. <P>
 * An EditContext generally offers some means of editing EditNodes and, as edits are made, updates {@link
 * com.smartgwt.client.tools.EditNode#getDefaults defaults} with the information required to re-create the component.
 */
@BeanFactory.FrameworkClass
public class EditNode extends PaletteNode {

    public static EditNode getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        return new EditNode(jsObj);
    }
        


    public EditNode(){
        
    }

    public EditNode(JavaScriptObject jsObj){
        
        setJavaScriptObject(jsObj);
    }


    // ********************* Properties / Attributes ***********************

    /**
     * See {@link com.smartgwt.client.tools.PaletteNode#getCanDuplicate PaletteNode.canDuplicate}.
     *
     * @param canDuplicate New canDuplicate value. Default value is null
     */
    public void setCanDuplicate(Boolean canDuplicate) {
        setAttribute("canDuplicate", canDuplicate);
    }

    /**
     * See {@link com.smartgwt.client.tools.PaletteNode#getCanDuplicate PaletteNode.canDuplicate}.
     *
     * @return Current canDuplicate value. Default value is null
     */
    public Boolean getCanDuplicate()  {
        return getAttributeAsBoolean("canDuplicate", true);
    }
    

    /**
     * Properties required to recreate the current {@link com.smartgwt.client.tools.EditNode#getLiveObject liveObject}.
     *
     * @param defaults New defaults value. Default value is null
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public void setCanvasDefaults(Canvas defaults) {
        if (defaults != null) {
            if (defaults.isCreated()) {
                ConfigUtil.warnOfPreConfigInstantiation(EditNode.class, "setCanvasDefaults", "Canvas");
            }                                                                       
            defaults.setConfigOnly(true);
        }
        JavaScriptObject config = defaults == null ? null : defaults.getConfig();
        setAttribute("defaults", JSOHelper.cleanProperties(config, true));
    }

    /**
     * Properties required to recreate the current {@link com.smartgwt.client.tools.EditNode#getLiveObject liveObject}.
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
     * Live version of the object created from the {@link com.smartgwt.client.tools.EditNode#getDefaults defaults}.  For
     * example,  if {@link com.smartgwt.client.tools.EditNode#getType type} is "ListGrid", <code>liveObject</code> would be a
     * ListGrid.
     *
     * @param liveObject New liveObject value. Default value is null
     */
    public void setCanvasLiveObject(Canvas liveObject) {
        setAttribute("liveObject", liveObject == null ? null : liveObject.getOrCreateJsObj());
    }

    /**
     * Live version of the object created from the {@link com.smartgwt.client.tools.EditNode#getDefaults defaults}.  For
     * example,  if {@link com.smartgwt.client.tools.EditNode#getType type} is "ListGrid", <code>liveObject</code> would be a
     * ListGrid.
     *
     * @return Current liveObject value. Default value is null
     */
    public Canvas getCanvasLiveObject()  {
        return (Canvas)Canvas.getByJSObject(getAttributeAsJavaScriptObject("liveObject"));
    }
    
    

    /**
     * Properties required to recreate the current {@link com.smartgwt.client.tools.EditNode#getLiveObject liveObject}.
     *
     * @param defaults New defaults value. Default value is null
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public void setDrawItemDefaults(DrawItem defaults) {
        if (defaults != null) {
            if (defaults.isCreated()) {
                ConfigUtil.warnOfPreConfigInstantiation(EditNode.class, "setDrawItemDefaults", "DrawItem");
            }                                                                       
            defaults.setConfigOnly(true);
        }
        JavaScriptObject config = defaults == null ? null : defaults.getConfig();
        setAttribute("defaults", JSOHelper.cleanProperties(config, true));
    }

    /**
     * Properties required to recreate the current {@link com.smartgwt.client.tools.EditNode#getLiveObject liveObject}.
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
     * Live version of the object created from the {@link com.smartgwt.client.tools.EditNode#getDefaults defaults}.  For
     * example,  if {@link com.smartgwt.client.tools.EditNode#getType type} is "ListGrid", <code>liveObject</code> would be a
     * ListGrid.
     *
     * @param liveObject New liveObject value. Default value is null
     */
    public void setDrawItemLiveObject(DrawItem liveObject) {
        setAttribute("liveObject", liveObject == null ? null : liveObject.getOrCreateJsObj());
    }

    /**
     * Live version of the object created from the {@link com.smartgwt.client.tools.EditNode#getDefaults defaults}.  For
     * example,  if {@link com.smartgwt.client.tools.EditNode#getType type} is "ListGrid", <code>liveObject</code> would be a
     * ListGrid.
     *
     * @return Current liveObject value. Default value is null
     */
    public DrawItem getDrawItemLiveObject()  {
        return (DrawItem)DrawItem.getByJSObject(getAttributeAsJavaScriptObject("liveObject"));
    }
    

    /**
     * Properties required to recreate the current {@link com.smartgwt.client.tools.EditNode#getLiveObject liveObject}.
     *
     * @param defaults New defaults value. Default value is null
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public void setDrawPaneDefaults(DrawPane defaults) {
        if (defaults != null) {
            if (defaults.isCreated()) {
                ConfigUtil.warnOfPreConfigInstantiation(EditNode.class, "setDrawPaneDefaults", "DrawPane");
            }                                                                       
            defaults.setConfigOnly(true);
        }
        JavaScriptObject config = defaults == null ? null : defaults.getConfig();
        setAttribute("defaults", JSOHelper.cleanProperties(config, true));
    }

    /**
     * Properties required to recreate the current {@link com.smartgwt.client.tools.EditNode#getLiveObject liveObject}.
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
     * Live version of the object created from the {@link com.smartgwt.client.tools.EditNode#getDefaults defaults}.  For
     * example,  if {@link com.smartgwt.client.tools.EditNode#getType type} is "ListGrid", <code>liveObject</code> would be a
     * ListGrid.
     *
     * @param liveObject New liveObject value. Default value is null
     */
    public void setDrawPaneLiveObject(DrawPane liveObject) {
        setAttribute("liveObject", liveObject == null ? null : liveObject.getOrCreateJsObj());
    }

    /**
     * Live version of the object created from the {@link com.smartgwt.client.tools.EditNode#getDefaults defaults}.  For
     * example,  if {@link com.smartgwt.client.tools.EditNode#getType type} is "ListGrid", <code>liveObject</code> would be a
     * ListGrid.
     *
     * @return Current liveObject value. Default value is null
     */
    public DrawPane getDrawPaneLiveObject()  {
        return (DrawPane)DrawPane.getByJSObject(getAttributeAsJavaScriptObject("liveObject"));
    }
    

    /**
     * Properties to be applied to the {@link com.smartgwt.client.tools.EditNode#getLiveObject liveObject}.{@link
     * com.smartgwt.client.widgets.Canvas#getEditProxy editProxy} when created. <p> Note that the <code>editProxy</code> is
     * created the first time a component is placed into editMode, so any <code>editProxyProperties</code> must be set before
     * then.
     *
     * @param editProxyProperties New editProxyProperties value. Default value is null
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public void setEditProxyProperties(EditProxy editProxyProperties) {
        if (editProxyProperties != null) {
            if (editProxyProperties.isCreated()) {
                ConfigUtil.warnOfPreConfigInstantiation(EditNode.class, "setEditProxyProperties", "EditProxy");
            }                                                                       
            editProxyProperties.setConfigOnly(true);
        }
        JavaScriptObject config = editProxyProperties == null ? null : editProxyProperties.getConfig();
        setAttribute("editProxyProperties", JSOHelper.cleanProperties(config, true));
    }

    /**
     * Properties to be applied to the {@link com.smartgwt.client.tools.EditNode#getLiveObject liveObject}.{@link
     * com.smartgwt.client.widgets.Canvas#getEditProxy editProxy} when created. <p> Note that the <code>editProxy</code> is
     * created the first time a component is placed into editMode, so any <code>editProxyProperties</code> must be set before
     * then.
     *
     * @return Current editProxyProperties value. Default value is null
     */
    public EditProxy getEditProxyProperties()  {
        return EditProxy.getOrCreateRef(getAttributeAsJavaScriptObject("editProxyProperties"));
    }
    

    /**
     * Properties required to recreate the current {@link com.smartgwt.client.tools.EditNode#getLiveObject liveObject}.
     *
     * @param defaults New defaults value. Default value is null
     */
    public void setFormItemDefaults(FormItem defaults) {
        setAttribute("defaults", defaults == null ? null : defaults.getJsObj());
    }

    /**
     * Properties required to recreate the current {@link com.smartgwt.client.tools.EditNode#getLiveObject liveObject}.
     *
     * @return Current defaults value. Default value is null
     */
    public FormItem getFormItemDefaults()  {
        return FormItem.getOrCreateRef(getAttributeAsJavaScriptObject("defaults"));
    }
    

    /**
     * Live version of the object created from the {@link com.smartgwt.client.tools.EditNode#getDefaults defaults}.  For
     * example,  if {@link com.smartgwt.client.tools.EditNode#getType type} is "ListGrid", <code>liveObject</code> would be a
     * ListGrid.
     *
     * @param liveObject New liveObject value. Default value is null
     */
    public void setFormItemLiveObject(FormItem liveObject) {
        setAttribute("liveObject", liveObject == null ? null : liveObject.getJsObj());
    }

    /**
     * Live version of the object created from the {@link com.smartgwt.client.tools.EditNode#getDefaults defaults}.  For
     * example,  if {@link com.smartgwt.client.tools.EditNode#getType type} is "ListGrid", <code>liveObject</code> would be a
     * ListGrid.
     *
     * @return Current liveObject value. Default value is null
     */
    public FormItem getFormItemLiveObject()  {
        return FormItem.getOrCreateRef(getAttributeAsJavaScriptObject("liveObject"));
    }
    
    

    /**
     * String of the  {@link com.smartgwt.client.tools.EditNode#getCanvasLiveObject canvasLiveObject}, for example, "ListGrid".
     *
     * @param type New type value. Default value is null
     * @see com.smartgwt.client.docs.SCClassName SCClassName 
     */
    public void setType(String type) {
        setAttribute("type", type);
    }

    /**
     * String of the  {@link com.smartgwt.client.tools.EditNode#getCanvasLiveObject canvasLiveObject}, for example, "ListGrid".
     *
     * @return Current type value. Default value is null
     * @see com.smartgwt.client.docs.SCClassName SCClassName 
     */
    public String getType()  {
        return getAttributeAsString("type");
    }
    

    /**
     * Shortcut property to be applied to the {@link com.smartgwt.client.tools.EditNode#getLiveObject liveObject}.{@link
     * com.smartgwt.client.widgets.Canvas#getEditProxy editProxy} when created.
     *
     * @param useEditMask New useEditMask value. Default value is null
     */
    public void setUseEditMask(Boolean useEditMask) {
        setAttribute("useEditMask", useEditMask);
    }

    /**
     * Shortcut property to be applied to the {@link com.smartgwt.client.tools.EditNode#getLiveObject liveObject}.{@link
     * com.smartgwt.client.widgets.Canvas#getEditProxy editProxy} when created.
     *
     * @return Current useEditMask value. Default value is null
     */
    public Boolean getUseEditMask()  {
        return getAttributeAsBoolean("useEditMask", true);
    }
    

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************

    // ***********************************************************


    /**
     * Live version of the object created from the 
     * {@link com.smartgwt.client.tools.EditNode#getDefaults defaults}.  For example, if 
     * {@link com.smartgwt.client.tools.EditNode#getType type} is "ListGrid", 
     * <code>liveObject</code> would be a ListGrid.  Use the more specific live object getter
     * API, such as 
     * {@link com.smartgwt.client.tools.EditNode#getCanvasLiveObject getCanvasLiveObject()}
     * if you are sure of the type.
     *
     * @return Object
     * @see #getCanvasLiveObject()
     * @see #getDrawItemLiveObject()
     * @see #getDrawPaneLiveObject()
     * @see #getFormItemLiveObject()
     */
    public Object getLiveObject()  {
        return super.getLiveObject();
    }

}
