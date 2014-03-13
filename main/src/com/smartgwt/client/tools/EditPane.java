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
import com.smartgwt.logicalstructure.widgets.tab.*;
import com.smartgwt.logicalstructure.widgets.tableview.*;
import com.smartgwt.logicalstructure.widgets.toolbar.*;
import com.smartgwt.logicalstructure.widgets.tree.*;
import com.smartgwt.logicalstructure.widgets.viewer.*;
import com.smartgwt.logicalstructure.widgets.calendar.*;
import com.smartgwt.logicalstructure.widgets.cube.*;
import com.smartgwt.logicalstructure.widgets.tools.*;

/**
 * A container that allows drag and drop instantiation of visual components from a {@link
 * com.smartgwt.client.tools.Palette}, and direct manipulation of the position and size of those components. <P> Any drag
 * onto an EditPane from a Palette will add an EditNode created from the dragged PaletteNode.
 * @see com.smartgwt.client.docs.DevTools DevTools overview and related methods
 */
@BeanFactory.FrameworkClass
@BeanFactory.ScClassName("EditPane")
public class EditPane extends Canvas implements EditContext {

    public static EditPane getOrCreateRef(JavaScriptObject jsObj) {
        if (jsObj == null) return null;
        final BaseWidget refInstance = BaseWidget.getRef(jsObj);
        if (refInstance == null) {
            return new EditPane(jsObj);
        } else {
            assert refInstance instanceof EditPane;
            return (EditPane)refInstance;
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
        $wnd.isc.EditPane.changeDefaults(autoChildName + "Defaults", defaults.@com.smartgwt.client.widgets.Canvas::getConfig()());
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
        $wnd.isc.EditPane.changeDefaults(autoChildName + "Defaults", defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getJsObj()());
    }-*/;

    public EditPane(){
        scClassName = "EditPane";
    }

    public EditPane(JavaScriptObject jsObj){
        scClassName = "EditPane";
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
     * {@link com.smartgwt.client.tools.Palette} to use when an {@link com.smartgwt.client.tools.EditNode} is being created
     * directly by this EditContext, instead of being created due to a user interaction with a palette (eg dragging from a
     * {@link com.smartgwt.client.tools.TreePalette}, or clicking on {@link com.smartgwt.client.tools.MenuPalette}). <P> If no
     * defaultPalette is provided, the EditContext uses an automatically created {@link
     * com.smartgwt.client.tools.HiddenPalette}.
     *
     * <p>If this method is called after the component has been drawn/initialized:
     * {@link com.smartgwt.client.tools.Palette} to use when an {@link com.smartgwt.client.tools.EditNode} is being created directly by this EditContext, instead of being created due to a user interaction with a palette (eg dragging from a {@link com.smartgwt.client.tools.TreePalette}, or clicking on {@link com.smartgwt.client.tools.MenuPalette}). <P> If no defaultPalette is provided, the EditContext uses an automatically created {@link com.smartgwt.client.tools.HiddenPalette}.
     *
     * @param defaultPalette the default Palette. Default value is null
     */
    public void setDefaultPalette(Palette defaultPalette) {
        // Since Palette is an interface, we need to convert it to a
        // JavaScriptObject dynamically at run-time -- we don't know what class
        // is implementing the interface.
        JavaScriptObject jsoArray = JSOHelper.convertToJavaScriptArray(new Object[] {defaultPalette});
        JavaScriptObject jso = JSOHelper.getValueFromJavaScriptObjectArray(jsoArray, 0);
        setAttribute("defaultPalette", jso == null ? null : jso, true);
    }

    /**
     * {@link com.smartgwt.client.tools.Palette} to use when an {@link com.smartgwt.client.tools.EditNode} is being created
     * directly by this EditContext, instead of being created due to a user interaction with a palette (eg dragging from a
     * {@link com.smartgwt.client.tools.TreePalette}, or clicking on {@link com.smartgwt.client.tools.MenuPalette}). <P> If no
     * defaultPalette is provided, the EditContext uses an automatically created {@link
     * com.smartgwt.client.tools.HiddenPalette}.
     *
     * @return {@link com.smartgwt.client.tools.Palette} to use when an {@link com.smartgwt.client.tools.EditNode} is being created
     * directly by this EditContext, instead of being created due to a user interaction with a palette (eg dragging from a
     * {@link com.smartgwt.client.tools.TreePalette}, or clicking on {@link com.smartgwt.client.tools.MenuPalette}). <P> If no
     * defaultPalette is provided, the EditContext uses an automatically created {@link
     * com.smartgwt.client.tools.HiddenPalette}.
     */
    public Palette getDefaultPalette()  {
        // We need to get or create the correct Java type, but we can't call
        // getOrCreateRef on an interface. The best simple thing we can do is
        // take advantage of ObjectFactory.createCanvas and friends to pick the
        // right type. Note that this will work for custom developer classes
        // so long as they descend from a SmartClient implementation of the
        // interface. It won't work for totally custom implementations, but
        // totally custom implementations would be hard to create properly anyway
        // (because they won't get the default methods implemented on the
        // SmartClient interface).
        JavaScriptObject jso = getAttributeAsJavaScriptObject("defaultPalette");
        Object javaObj = null;
        if (JSOHelper.isScClassInstance(jso)) {
            String className = JSOHelper.getClassName(jso);
            javaObj = ObjectFactory.createCanvas(className, jso);

            // If it's not a Canvas, try the others
            if (javaObj == null) {
                javaObj = ObjectFactory.createInstance(className, jso);
            }
        }
        if (javaObj instanceof Palette) {
            return (Palette) javaObj;
        } else {
            return null;
        }
    }

    /**
     * Additional {@link com.smartgwt.client.tools.Palette Palettes} to consult for metadata when deserializing {@link
     * com.smartgwt.client.tools.EditNode Edit Nodes}. Note that the {@link
     * com.smartgwt.client.tools.EditContext#getDefaultPalette defaultPalette} is always consulted and need not be provided
     * again here.
     *
     * @param extraPalettes  Default value is null
     */
    public void setExtraPalettes(Palette... extraPalettes) {
        // Since Palette... is an interface, we need to convert it to a
        // JavaScriptObject dynamically at run-time -- we don't know what class
        // is implementing the interface.
        JavaScriptObject jsoArray = JSOHelper.convertToJavaScriptArray(new Object[] {extraPalettes});
        JavaScriptObject jso = JSOHelper.getValueFromJavaScriptObjectArray(jsoArray, 0);
        setAttribute("extraPalettes", jso == null ? null : jso, true);
    }

    /**
     * Additional {@link com.smartgwt.client.tools.Palette Palettes} to consult for metadata when deserializing {@link
     * com.smartgwt.client.tools.EditNode Edit Nodes}. Note that the {@link
     * com.smartgwt.client.tools.EditContext#getDefaultPalette defaultPalette} is always consulted and need not be provided
     * again here.
     *
     * @return Palette...
     */
    public Palette[] getExtraPalettes()  {
        return com.smartgwt.client.util.ConvertTo.arrayOfPalette(getAttributeAsJavaScriptObject("extraPalettes"));
    }

    /**
     * If enabled, changes to a {@link com.smartgwt.client.tools.EditNode#getLiveObject liveObject}'s position and size will be
     * persisted to their {@link com.smartgwt.client.tools.EditNode EditNodes}.  This applies to both programmatic calls and
     * user interaction (drag reposition or drag resize).
     *
     * @param persistCoordinates  Default value is true
     */
    public void setPersistCoordinates(boolean persistCoordinates) {
        setAttribute("persistCoordinates", persistCoordinates, true);
    }

    /**
     * If enabled, changes to a {@link com.smartgwt.client.tools.EditNode#getLiveObject liveObject}'s position and size will be
     * persisted to their {@link com.smartgwt.client.tools.EditNode EditNodes}.  This applies to both programmatic calls and
     * user interaction (drag reposition or drag resize).
     *
     * @return boolean
     */
    public boolean getPersistCoordinates()  {
        return getAttributeAsBoolean("persistCoordinates");
    }

    // ********************* Methods ***********************
	/**
     * Returns an Array of {@link com.smartgwt.client.tools.PaletteNode}s representing all current {@link
     * com.smartgwt.client.tools.EditNode}s in this pane, suitable for saving and restoring via passing each paletteNode to
     * {@link com.smartgwt.client.tools.EditContext#addNode addNode()}.
     *
     * @return paletteNodes suitable for saving for subsequent restoration
     */
    public native PaletteNode[] getSaveData() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getSaveData();
        if(ret == null) return null;
        return @com.smartgwt.client.util.ConvertTo::arrayOfPaletteNode(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;


	/**
     * Creates a new EditNode from a PaletteNode, using the {@link com.smartgwt.client.tools.EditContext#getDefaultPalette
     * defaultPalette}.  If you have an array of possibly inter-related PaletteNodes, then you should use {@link
     * com.smartgwt.client.tools.EditContext#addFromPaletteNodes addFromPaletteNodes()} on the array instead, in order to
     * preserve the relationships.
     * @param paletteNode the palette node to use to create the new node
     *
     * @return the EditNode created from the paletteNode
     * @see com.smartgwt.client.tools.EditContext#addFromPaletteNodes
     */
    public native EditNode addFromPaletteNode(PaletteNode paletteNode) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.addFromPaletteNode(paletteNode.@com.smartgwt.client.core.DataClass::getJsObj()());
        if(ret == null) return null;
        return @com.smartgwt.client.tools.EditNode::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

	/**
     * Creates a new EditNode from a PaletteNode, using the {@link com.smartgwt.client.tools.EditContext#getDefaultPalette
     * defaultPalette}.  If you have an array of possibly inter-related PaletteNodes, then you should use {@link
     * com.smartgwt.client.tools.EditContext#addFromPaletteNodes addFromPaletteNodes()} on the array instead, in order to
     * preserve the relationships.
     * @param paletteNode the palette node to use to create the new node
     * @param parentNode optional the parent node if the new node should appear                                under a specific parent
     *
     * @return the EditNode created from the paletteNode
     * @see com.smartgwt.client.tools.EditContext#addFromPaletteNodes
     */
    public native EditNode addFromPaletteNode(PaletteNode paletteNode, EditNode parentNode) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.addFromPaletteNode(paletteNode.@com.smartgwt.client.core.DataClass::getJsObj()(), parentNode == null ? null : parentNode.@com.smartgwt.client.core.DataClass::getJsObj()());
        if(ret == null) return null;
        return @com.smartgwt.client.tools.EditNode::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;


	/**
     * Add the supplied {@link com.smartgwt.client.tools.PaletteNode PaletteNodes} to the parentNode, preserving internal
     * references from one supplied PaletteNode to another. This method should be used with an array of possibly inter-related
     * PaletteNodes (for instance, those produced as a result of serialization via {@link
     * com.smartgwt.client.tools.EditContext#serializeAllEditNodes serializeAllEditNodes()}, rather than calling {@link
     * com.smartgwt.client.tools.EditContext#addFromPaletteNode addFromPaletteNode()} on each individual PaletteNode.
     * @param paletteNodes array of PaletteNodes
     *
     * @return an array of the EditNodes added to the parentNode
     * @see com.smartgwt.client.tools.EditContext#addFromPaletteNode
     */
    public native EditNode[] addFromPaletteNodes(PaletteNode[] paletteNodes) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.addFromPaletteNodes(@com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(paletteNodes));
        if(ret == null) return null;
        return @com.smartgwt.client.util.ConvertTo::arrayOfEditNode(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

	/**
     * Add the supplied {@link com.smartgwt.client.tools.PaletteNode PaletteNodes} to the parentNode, preserving internal
     * references from one supplied PaletteNode to another. This method should be used with an array of possibly inter-related
     * PaletteNodes (for instance, those produced as a result of serialization via {@link
     * com.smartgwt.client.tools.EditContext#serializeAllEditNodes serializeAllEditNodes()}, rather than calling {@link
     * com.smartgwt.client.tools.EditContext#addFromPaletteNode addFromPaletteNode()} on each individual PaletteNode.
     * @param paletteNodes array of PaletteNodes
     * @param parentNode parent to add to (defaults to the root)
     *
     * @return an array of the EditNodes added to the parentNode
     * @see com.smartgwt.client.tools.EditContext#addFromPaletteNode
     */
    public native EditNode[] addFromPaletteNodes(PaletteNode[] paletteNodes, EditNode parentNode) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.addFromPaletteNodes(@com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(paletteNodes), parentNode == null ? null : parentNode.@com.smartgwt.client.core.DataClass::getJsObj()());
        if(ret == null) return null;
        return @com.smartgwt.client.util.ConvertTo::arrayOfEditNode(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;


	/**
     * Add a new {@link com.smartgwt.client.tools.EditNode} to the EditContext, under the specified parent. <P> The EditContext
     * will interrogate the parent and new nodes to determine what field  within the parent allows a child of this type, and to
     * find a method to add the newNode's  liveObject to the parentNode's liveObject.  The new relationship will then be stored
     * in the tree of EditNodes. <P> For example, when a Tab is dropped on a TabSet, the field TabSet.tabs is discovered as the
     * correct target field via naming conventions, and the method TabSet.addTab() is likewise  discovered as the correct
     * method to add a Tab to a TabSet.
     * @param newNode new node to be added
     *
     * @return newNodenode added
     */
    public native EditNode addNode(EditNode newNode) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.addNode(newNode.@com.smartgwt.client.core.DataClass::getJsObj()());
        if(ret == null) return null;
        return @com.smartgwt.client.tools.EditNode::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

    /**
     * @see {@link EditPane#addNode()}
     */
    public EditNode addNode(EditNode newNode, EditNode parentNode){
        return addNode(newNode, parentNode, (Integer) null, null, null);
    }

    /**
     * @see {@link EditPane#addNode()}
     */
    public EditNode addNode(EditNode newNode, EditNode parentNode, Integer index){
        return addNode(newNode, parentNode, index, null, null);
    }

    /**
     * @see {@link EditPane#addNode()}
     */
    public EditNode addNode(EditNode newNode, EditNode parentNode, Integer index, String parentProperty){
        return addNode(newNode, parentNode, index, parentProperty, null);
    }

	/**
     * Add a new {@link com.smartgwt.client.tools.EditNode} to the EditContext, under the specified parent. <P> The EditContext
     * will interrogate the parent and new nodes to determine what field  within the parent allows a child of this type, and to
     * find a method to add the newNode's  liveObject to the parentNode's liveObject.  The new relationship will then be stored
     * in the tree of EditNodes. <P> For example, when a Tab is dropped on a TabSet, the field TabSet.tabs is discovered as the
     * correct target field via naming conventions, and the method TabSet.addTab() is likewise  discovered as the correct
     * method to add a Tab to a TabSet.
     * @param newNode new node to be added
     * @param parentNode parent to add the new node under.
     * @param index index within the parent's children array
     * @param parentProperty the property of the liveParent to which the new node should                                  be added, if not
     * auto-discoverable from the schema
     * @param skipParentComponentAdd whether to skip adding the liveObject to the liveParent                                           (default false)
     *
     * @return newNodenode added
     */
    public native EditNode addNode(EditNode newNode, EditNode parentNode, Integer index, String parentProperty, Boolean skipParentComponentAdd) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.addNode(newNode.@com.smartgwt.client.core.DataClass::getJsObj()(), parentNode == null ? null : parentNode.@com.smartgwt.client.core.DataClass::getJsObj()(), index == null ? null : index.@java.lang.Integer::intValue()(), parentProperty, skipParentComponentAdd == null ? null : skipParentComponentAdd.@java.lang.Boolean::booleanValue()());
        if(ret == null) return null;
        return @com.smartgwt.client.tools.EditNode::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;


	/**
     * Add {@link com.smartgwt.client.tools.PaletteNode PaletteNodes} from a JavaScript source representation. <P> By default,
     * components that have {@link com.smartgwt.client.widgets.Canvas#getID global IDs} will not actually be allowed to take
     * those global IDs - instead, only widgets that have one of the global IDs passed as the <code>globals</code> parameter
     * will actually receive their global IDs.  To override this behavior, pass the special value {@link
     * com.smartgwt.client.rpc.RPCManager#ALL_GLOBALS ALL_GLOBALS} for the <code>globals</code> parameter.
     * @param jsCode JavaScript code to eval.
     */
    public native void addPaletteNodesFromJS(String jsCode) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.addPaletteNodesFromJS(jsCode);
    }-*/;

    /**
     * @see {@link EditPane#addPaletteNodesFromJS()}
     */
    public void addPaletteNodesFromJS(String jsCode, EditNode parentNode){
        addPaletteNodesFromJS(jsCode, parentNode, null);
    }

	/**
     * Add {@link com.smartgwt.client.tools.PaletteNode PaletteNodes} from a JavaScript source representation. <P> By default,
     * components that have {@link com.smartgwt.client.widgets.Canvas#getID global IDs} will not actually be allowed to take
     * those global IDs - instead, only widgets that have one of the global IDs passed as the <code>globals</code> parameter
     * will actually receive their global IDs.  To override this behavior, pass the special value {@link
     * com.smartgwt.client.rpc.RPCManager#ALL_GLOBALS ALL_GLOBALS} for the <code>globals</code> parameter.
     * @param jsCode JavaScript code to eval.
     * @param parentNode parent node (defaults to the root)
     * @param globals widgets to allow to take their global IDs
     */
    public native void addPaletteNodesFromJS(String jsCode, EditNode parentNode, String[] globals) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.addPaletteNodesFromJS(jsCode, parentNode == null ? null : parentNode.@com.smartgwt.client.core.DataClass::getJsObj()(), @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(globals));
    }-*/;


	/**
     * Recreate {@link com.smartgwt.client.tools.EditNode EditNodes} from a JSON representation of  {@link
     * com.smartgwt.client.tools.PaletteNode PaletteNodes} (possibly created by calling {@link
     * com.smartgwt.client.tools.EditContext#serializeAllEditNodesAsJSON EditContext.serializeAllEditNodesAsJSON} or {@link
     * com.smartgwt.client.tools.EditContext#serializeEditNodesAsJSON EditContext.serializeEditNodesAsJSON}. <P> By default,
     * components that have {@link com.smartgwt.client.widgets.Canvas#getID global IDs} will not actually be allowed to take
     * those global IDs - instead, only widgets that have one of the global IDs passed as the <code>globals</code> parameter
     * will actually receive their global IDs.  To override this behavior, pass the special value {@link
     * com.smartgwt.client.rpc.RPCManager#ALL_GLOBALS ALL_GLOBALS} for the <code>globals</code> parameter.
     * @param jsonString JSON string
     * @see com.smartgwt.client.tools.EditContext#serializeAllEditNodesAsJSON
     * @see com.smartgwt.client.tools.EditContext#serializeEditNodesAsJSON
     */
    public native void addPaletteNodesFromJSON(String jsonString) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.addPaletteNodesFromJSON(jsonString);
    }-*/;

    /**
     * @see {@link EditPane#addPaletteNodesFromJSON()}
     */
    public void addPaletteNodesFromJSON(String jsonString, EditNode parentNode){
        addPaletteNodesFromJSON(jsonString, parentNode, null);
    }

	/**
     * Recreate {@link com.smartgwt.client.tools.EditNode EditNodes} from a JSON representation of  {@link
     * com.smartgwt.client.tools.PaletteNode PaletteNodes} (possibly created by calling {@link
     * com.smartgwt.client.tools.EditContext#serializeAllEditNodesAsJSON EditContext.serializeAllEditNodesAsJSON} or {@link
     * com.smartgwt.client.tools.EditContext#serializeEditNodesAsJSON EditContext.serializeEditNodesAsJSON}. <P> By default,
     * components that have {@link com.smartgwt.client.widgets.Canvas#getID global IDs} will not actually be allowed to take
     * those global IDs - instead, only widgets that have one of the global IDs passed as the <code>globals</code> parameter
     * will actually receive their global IDs.  To override this behavior, pass the special value {@link
     * com.smartgwt.client.rpc.RPCManager#ALL_GLOBALS ALL_GLOBALS} for the <code>globals</code> parameter.
     * @param jsonString JSON string
     * @param parentNode parent node (defaults to the root)
     * @param globals widgets to allow to take their global IDs
     * @see com.smartgwt.client.tools.EditContext#serializeAllEditNodesAsJSON
     * @see com.smartgwt.client.tools.EditContext#serializeEditNodesAsJSON
     */
    public native void addPaletteNodesFromJSON(String jsonString, EditNode parentNode, String[] globals) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.addPaletteNodesFromJSON(jsonString, parentNode == null ? null : parentNode.@com.smartgwt.client.core.DataClass::getJsObj()(), @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(globals));
    }-*/;


	/**
     * Recreate {@link com.smartgwt.client.tools.EditNode EditNodes} from an XML representation of  {@link
     * com.smartgwt.client.tools.PaletteNode PaletteNodes} (possibly created by calling {@link
     * com.smartgwt.client.tools.EditContext#serializeAllEditNodes EditContext.serializeAllEditNodes} or {@link
     * com.smartgwt.client.tools.EditContext#serializeEditNodes EditContext.serializeEditNodes}. <P> By default, components
     * that have {@link com.smartgwt.client.widgets.Canvas#getID global IDs} will not actually be allowed to take those global
     * IDs - instead, only widgets that have one of the global IDs passed as the <code>globals</code> parameter will actually
     * receive their global IDs.  To override this behavior, pass the special value {@link
     * com.smartgwt.client.rpc.RPCManager#ALL_GLOBALS ALL_GLOBALS} for the <code>globals</code> parameter.
     * @param xmlString XML string
     * @see com.smartgwt.client.tools.EditContext#serializeAllEditNodes
     * @see com.smartgwt.client.tools.EditContext#serializeEditNodes
     */
    public native void addPaletteNodesFromXML(String xmlString) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.addPaletteNodesFromXML(xmlString);
    }-*/;

    /**
     * @see {@link EditPane#addPaletteNodesFromXML()}
     */
    public void addPaletteNodesFromXML(String xmlString, EditNode parentNode){
        addPaletteNodesFromXML(xmlString, parentNode, null);
    }

	/**
     * Recreate {@link com.smartgwt.client.tools.EditNode EditNodes} from an XML representation of  {@link
     * com.smartgwt.client.tools.PaletteNode PaletteNodes} (possibly created by calling {@link
     * com.smartgwt.client.tools.EditContext#serializeAllEditNodes EditContext.serializeAllEditNodes} or {@link
     * com.smartgwt.client.tools.EditContext#serializeEditNodes EditContext.serializeEditNodes}. <P> By default, components
     * that have {@link com.smartgwt.client.widgets.Canvas#getID global IDs} will not actually be allowed to take those global
     * IDs - instead, only widgets that have one of the global IDs passed as the <code>globals</code> parameter will actually
     * receive their global IDs.  To override this behavior, pass the special value {@link
     * com.smartgwt.client.rpc.RPCManager#ALL_GLOBALS ALL_GLOBALS} for the <code>globals</code> parameter.
     * @param xmlString XML string
     * @param parentNode parent node (defaults to the root)
     * @param globals widgets to allow to take their global IDs
     * @see com.smartgwt.client.tools.EditContext#serializeAllEditNodes
     * @see com.smartgwt.client.tools.EditContext#serializeEditNodes
     */
    public native void addPaletteNodesFromXML(String xmlString, EditNode parentNode, String[] globals) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.addPaletteNodesFromXML(xmlString, parentNode == null ? null : parentNode.@com.smartgwt.client.core.DataClass::getJsObj()(), @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(globals));
    }-*/;

	/**
     * Removes all {@link com.smartgwt.client.tools.EditNode EditNodes} from the EditContext, and calls {@link
     * com.smartgwt.client.widgets.Canvas#destroy destroy()} on the {@link com.smartgwt.client.tools.EditNode#getLiveObject
     * liveObjects}.
     */
    public native void destroyAll() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.destroyAll();
    }-*/;


	/**
     * Obtain {@link com.smartgwt.client.tools.PaletteNode PaletteNodes} from a JavaScript source representation. <P> By
     * default, components that have {@link com.smartgwt.client.widgets.Canvas#getID global IDs} will not actually be allowed
     * to take those global IDs - instead, only widgets that have one of the global IDs passed as the <code>globals</code>
     * parameter will actually receive their global IDs.  To override this behavior, pass the special value {@link
     * com.smartgwt.client.rpc.RPCManager#ALL_GLOBALS ALL_GLOBALS} for the <code>globals</code> parameter.
     * @param jsCode JavaScript code to eval.
     * @param callback Callback used to return the PaletteNodes
     */
    public native void getPaletteNodesFromJS(String jsCode, PaletteNodeCallback callback) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.getPaletteNodesFromJS(jsCode, 
			$entry( function(paletteNodes) { 
				if(callback!=null) callback.@com.smartgwt.client.callbacks.PaletteNodeCallback::execute([Lcom/smartgwt/client/tools/PaletteNode;)(@com.smartgwt.client.util.ConvertTo::arrayOfPaletteNode(Lcom/google/gwt/core/client/JavaScriptObject;)(paletteNodes)
				);
			}));
    }-*/;

	/**
     * Obtain {@link com.smartgwt.client.tools.PaletteNode PaletteNodes} from a JavaScript source representation. <P> By
     * default, components that have {@link com.smartgwt.client.widgets.Canvas#getID global IDs} will not actually be allowed
     * to take those global IDs - instead, only widgets that have one of the global IDs passed as the <code>globals</code>
     * parameter will actually receive their global IDs.  To override this behavior, pass the special value {@link
     * com.smartgwt.client.rpc.RPCManager#ALL_GLOBALS ALL_GLOBALS} for the <code>globals</code> parameter.
     * @param jsCode JavaScript code to eval.
     * @param callback Callback used to return the PaletteNodes
     * @param globals widgets to allow to take their global IDs
     */
    public native void getPaletteNodesFromJS(String jsCode, PaletteNodeCallback callback, String[] globals) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.getPaletteNodesFromJS(jsCode, 
			$entry( function(paletteNodes) { 
				if(callback!=null) callback.@com.smartgwt.client.callbacks.PaletteNodeCallback::execute([Lcom/smartgwt/client/tools/PaletteNode;)(@com.smartgwt.client.util.ConvertTo::arrayOfPaletteNode(Lcom/google/gwt/core/client/JavaScriptObject;)(paletteNodes)
				);
			}), @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(globals));
    }-*/;


	/**
     * Obtain {@link com.smartgwt.client.tools.PaletteNode PaletteNodes} from an XML representation, but do not add them to the
     * EditContext.
     * @param xmlString XML string
     * @param callback Callback used to return the PaletteNodes
     * @see com.smartgwt.client.tools.EditContext#serializeAllEditNodes
     * @see com.smartgwt.client.tools.EditContext#serializeEditNodes
     */
    public native void getPaletteNodesFromXML(String xmlString, PaletteNodeCallback callback) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.getPaletteNodesFromXML(xmlString, 
			$entry( function(paletteNodes) { 
				if(callback!=null) callback.@com.smartgwt.client.callbacks.PaletteNodeCallback::execute([Lcom/smartgwt/client/tools/PaletteNode;)(@com.smartgwt.client.util.ConvertTo::arrayOfPaletteNode(Lcom/google/gwt/core/client/JavaScriptObject;)(paletteNodes)
				);
			}));
    }-*/;


	/**
     * Creates and returns an EditNode using the {@link com.smartgwt.client.tools.EditContext#getDefaultPalette
     * defaultPalette}.  Does not add the newly created EditNode to the EditContext.
     * @param paletteNode the palette node to use to create the new node
     *
     * @return the EditNode created from the paletteNode
     */
    public native EditNode makeEditNode(PaletteNode paletteNode) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.makeEditNode(paletteNode.@com.smartgwt.client.core.DataClass::getJsObj()());
        if(ret == null) return null;
        return @com.smartgwt.client.tools.EditNode::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

	/**
     * Removes all {@link com.smartgwt.client.tools.EditNode EditNodes} from the EditContext, but does not destroy  the {@link
     * com.smartgwt.client.tools.EditNode#getLiveObject liveObjects}.
     */
    public native void removeAll() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.removeAll();
    }-*/;


	/**
     * Removes the specified properties from an editNode's serializable "defaults". Note that the {@link
     * com.smartgwt.client.tools.EditNode#getLiveObject liveObject} is <u>not</u> updated by this method.  To set a property to
     * null (rather than removing it), use {@link com.smartgwt.client.tools.EditContext#setNodeProperties setNodeProperties()}
     * instead.
     * @param editNode the editNode to update
     * @param properties an array of property names to remove
     * @see com.smartgwt.client.tools.EditContext#setNodeProperties
     */
    public native void removeNodeProperties(EditNode editNode, String[] properties) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.removeNodeProperties(editNode.@com.smartgwt.client.core.DataClass::getJsObj()(), @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(properties));
    }-*/;

	/**
     * Serialize the tree of {@link com.smartgwt.client.tools.EditNode EditNodes} to an XML representation of {@link
     * com.smartgwt.client.tools.PaletteNode PaletteNodes}. The result can be supplied to  {@link
     * com.smartgwt.client.tools.EditContext#addPaletteNodesFromXML addPaletteNodesFromXML()} to recreate the EditNodes.
     *
     * @return an XML representation of PaletteNodes which can be used to                  recreate the tree of EditNodes.
     * @see com.smartgwt.client.tools.EditContext#addPaletteNodesFromXML
     */
    public native String serializeAllEditNodes() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.serializeAllEditNodes();
        return ret;
    }-*/;

	/**
     * Serialize the tree of {@link com.smartgwt.client.tools.EditNode EditNodes} to an XML representation of {@link
     * com.smartgwt.client.tools.PaletteNode PaletteNodes}. The result can be supplied to  {@link
     * com.smartgwt.client.tools.EditContext#addPaletteNodesFromXML addPaletteNodesFromXML()} to recreate the EditNodes.
     * @param serverless If true, specify DataSources in full rather than                               assuming they can be downloaded from the
     * server.                               Defaults to false.
     *
     * @return an XML representation of PaletteNodes which can be used to                  recreate the tree of EditNodes.
     * @see com.smartgwt.client.tools.EditContext#addPaletteNodesFromXML
     */
    public native String serializeAllEditNodes(Boolean serverless) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.serializeAllEditNodes(serverless == null ? null : serverless.@java.lang.Boolean::booleanValue()());
        return ret;
    }-*/;

	/**
     * Encode the tree of {@link com.smartgwt.client.tools.EditNode EditNodes} to a JSON representation of {@link
     * com.smartgwt.client.tools.PaletteNode PaletteNodes}. The result can be supplied to  {@link
     * com.smartgwt.client.tools.EditContext#addPaletteNodesFromJSON addPaletteNodesFromJSON()} to recreate the EditNodes.
     *
     * @return a JSON representation of PaletteNodes which can be used to                  recreate the tree of EditNodes.
     * @see com.smartgwt.client.tools.EditContext#addPaletteNodesFromJSON
     */
    public native String serializeAllEditNodesAsJSON() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.serializeAllEditNodesAsJSON();
        return ret;
    }-*/;

	/**
     * Encode the tree of {@link com.smartgwt.client.tools.EditNode EditNodes} to a JSON representation of {@link
     * com.smartgwt.client.tools.PaletteNode PaletteNodes}. The result can be supplied to  {@link
     * com.smartgwt.client.tools.EditContext#addPaletteNodesFromJSON addPaletteNodesFromJSON()} to recreate the EditNodes.
     * @param serverless If true, specify DataSources in full rather than                               assuming they can be downloaded from the
     * server.                               Defaults to false.
     *
     * @return a JSON representation of PaletteNodes which can be used to                  recreate the tree of EditNodes.
     * @see com.smartgwt.client.tools.EditContext#addPaletteNodesFromJSON
     */
    public native String serializeAllEditNodesAsJSON(Boolean serverless) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.serializeAllEditNodesAsJSON(serverless == null ? null : serverless.@java.lang.Boolean::booleanValue()());
        return ret;
    }-*/;


	/**
     * Serialize the provided {@link com.smartgwt.client.tools.EditNode EditNodes} to an XML representation of {@link
     * com.smartgwt.client.tools.PaletteNode PaletteNodes}. Note that the EditNodes must have been added to this EditContext.
     * The result can be supplied to {@link com.smartgwt.client.tools.EditContext#addPaletteNodesFromXML
     * addPaletteNodesFromXML()} to recreate the EditNodes.
     * @param nodes EditNodes to be serialized
     *
     * @return an XML representtion of the provided EditNodes
     */
    public native String serializeEditNodes(EditNode[] nodes) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.serializeEditNodes(@com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(nodes));
        return ret;
    }-*/;

	/**
     * Serialize the provided {@link com.smartgwt.client.tools.EditNode EditNodes} to an XML representation of {@link
     * com.smartgwt.client.tools.PaletteNode PaletteNodes}. Note that the EditNodes must have been added to this EditContext.
     * The result can be supplied to {@link com.smartgwt.client.tools.EditContext#addPaletteNodesFromXML
     * addPaletteNodesFromXML()} to recreate the EditNodes.
     * @param nodes EditNodes to be serialized
     * @param serverless If true, specify DataSources in full rather than                               assuming they can be downloaded from the
     * server.                               Defaults to false.
     *
     * @return an XML representtion of the provided EditNodes
     */
    public native String serializeEditNodes(EditNode[] nodes, Boolean serverless) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.serializeEditNodes(@com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(nodes), serverless == null ? null : serverless.@java.lang.Boolean::booleanValue()());
        return ret;
    }-*/;


	/**
     * Serialize the provided {@link com.smartgwt.client.tools.EditNode EditNodes} to a JSON representation of {@link
     * com.smartgwt.client.tools.PaletteNode PaletteNodes}. Note that the EditNodes must have been added to this EditContext.
     * The result can be supplied to {@link com.smartgwt.client.tools.EditContext#addPaletteNodesFromJSON
     * addPaletteNodesFromJSON()} to recreate the EditNodes.
     * @param nodes EditNodes to be serialized
     *
     * @return a JSON representtion of the provided EditNodes
     */
    public native String serializeEditNodesAsJSON(EditNode[] nodes) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.serializeEditNodesAsJSON(@com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(nodes));
        return ret;
    }-*/;

	/**
     * Serialize the provided {@link com.smartgwt.client.tools.EditNode EditNodes} to a JSON representation of {@link
     * com.smartgwt.client.tools.PaletteNode PaletteNodes}. Note that the EditNodes must have been added to this EditContext.
     * The result can be supplied to {@link com.smartgwt.client.tools.EditContext#addPaletteNodesFromJSON
     * addPaletteNodesFromJSON()} to recreate the EditNodes.
     * @param nodes EditNodes to be serialized
     * @param serverless If true, specify DataSources in full rather than                               assuming they can be downloaded from the
     * server.                               Defaults to false.
     *
     * @return a JSON representtion of the provided EditNodes
     */
    public native String serializeEditNodesAsJSON(EditNode[] nodes, Boolean serverless) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.serializeEditNodesAsJSON(@com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(nodes), serverless == null ? null : serverless.@java.lang.Boolean::booleanValue()());
        return ret;
    }-*/;


	/**
     * Update an editNode's serializable "defaults" with the supplied properties. If you wish to remove a property from the
     * defaults (rather than setting it to null), then use {@link com.smartgwt.client.tools.EditContext#removeNodeProperties
     * removeNodeProperties()} instead.
     * @param editNode the editNode to update
     * @param properties the properties to apply
     * @see com.smartgwt.client.tools.EditContext#removeNodeProperties
     */
    public native void setNodeProperties(EditNode editNode, Canvas properties) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setNodeProperties(editNode.@com.smartgwt.client.core.DataClass::getJsObj()(), properties.@com.smartgwt.client.widgets.BaseWidget::getConfig()());
    }-*/;

	/**
     * Update an editNode's serializable "defaults" with the supplied properties. If you wish to remove a property from the
     * defaults (rather than setting it to null), then use {@link com.smartgwt.client.tools.EditContext#removeNodeProperties
     * removeNodeProperties()} instead.
     * @param editNode the editNode to update
     * @param properties the properties to apply
     * @param skipLiveObjectUpdate whether to skip updating the                                         {@link
     * com.smartgwt.client.tools.EditNode#getLiveObject liveObject},                                         e.g. if you have
     * already updated the liveObject
     * @see com.smartgwt.client.tools.EditContext#removeNodeProperties
     */
    public native void setNodeProperties(EditNode editNode, Canvas properties, Boolean skipLiveObjectUpdate) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setNodeProperties(editNode.@com.smartgwt.client.core.DataClass::getJsObj()(), properties.@com.smartgwt.client.widgets.BaseWidget::getConfig()(), skipLiveObjectUpdate == null ? null : skipLiveObjectUpdate.@java.lang.Boolean::booleanValue()());
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
     * @param editPaneProperties properties that should be used as new defaults when instances of this class are created
     */
    public static native void setDefaultProperties(EditPane editPaneProperties) /*-{
    	var properties = $wnd.isc.addProperties({},editPaneProperties.@com.smartgwt.client.widgets.BaseWidget::getConfig()());
        @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(properties,false);
        $wnd.isc.EditPane.addProperties(properties);
    }-*/;

    // ***********************************************************

    public LogicalStructureObject setLogicalStructure(EditPaneLogicalStructure s) {
        super.setLogicalStructure(s);
        return s;
    }

    public LogicalStructureObject getLogicalStructure() {
        EditPaneLogicalStructure s = new EditPaneLogicalStructure();
        setLogicalStructure(s);
        return s;
    }
}

