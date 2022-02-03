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
 * An EditContext provides an editing environment for a set of components. <P> An EditContext is typically populated by
 * adding a series of {@link com.smartgwt.client.tools.EditNode EditNodes} created via a {@link
 * com.smartgwt.client.tools.Palette}, either via drag and drop creation, or when loading from a saved version, via {@link
 * com.smartgwt.client.tools.EditContext#addFromPaletteNode addFromPaletteNode()} or  {@link
 * com.smartgwt.client.tools.EditContext#addPaletteNodesFromXML addPaletteNodesFromXML()}. <P> An EditContext then provides
 * interfaces for further editing of the components represented by EditNodes. <P> Developers may explicitly define an edit
 * context and initialize it with a {@link com.smartgwt.client.tools.EditContext#getRootComponent rootComponent} - the root
 * of the user interface being created. The EditContext itself is not visible to the user, but the root component's  {@link
 * com.smartgwt.client.tools.EditNode#getLiveObject liveObject} may be.<br> As child editNodes are added to the
 * rootComponent node or its descendants, liveObjects in the user will update to reflect these changes. The live objects
 * for the edit nodes will be nested using the appropriate parent-child relationships, for  the types of node in question.
 * For example Canvases will be added as {@link com.smartgwt.client.widgets.layout.Layout#getMembers members} of layouts
 * and FormItems will be added as  {@link com.smartgwt.client.widgets.form.DynamicForm#getFields fields} of DynamicForms.
 * <P> To enable drag and drop creation of widgets from a {@link com.smartgwt.client.tools.Palette}, a developer can use
 * {@link com.smartgwt.client.widgets.Canvas#setEditMode Canvas.setEditMode()} to enable editing behaviors on the live
 * object of the desired drop target (typically the root component).<br> To enable editNode creation via double-click on a
 * {@link com.smartgwt.client.tools.Palette}, developers can set the {@link
 * com.smartgwt.client.tools.Palette#getDefaultEditContext Palette.defaultEditContext}. <P> Developers can also make use of
 * {@link com.smartgwt.client.tools.EditPane} or {@link com.smartgwt.client.tools.EditTree} classes which provide a visual
 * interface for managing an EditContext.
 * @see com.smartgwt.client.docs.DevTools DevTools overview and related methods
 */
@BeanFactory.FrameworkClass
@BeanFactory.ScClassName("EditContext")
public class EditContext extends BaseClass implements com.smartgwt.client.tools.HasEditMaskClickedHandlers, com.smartgwt.client.tools.HasEditNodeUpdatedHandlers, com.smartgwt.client.tools.HasNodeAddedHandlers, com.smartgwt.client.tools.HasSelectedEditNodesUpdatedHandlers {

    public static EditContext getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        BaseClass obj = BaseClass.getRef(jsObj);
        if(obj != null) {
            return (EditContext) obj;
        } else {
            return new EditContext(jsObj);
        }
    }

    public void setJavaScriptObject(JavaScriptObject jsObj) {
        internalSetID(jsObj);
        JSOHelper.setObjectAttribute(jsObj, SC.REF, this);
        JSOHelper.setObjectAttribute(jsObj, SC.MODULE, BeanFactory.getSGWTModule());
        if (!JSOHelper.isScClassInstance(jsObj)) {
            setConfig(jsObj);
            return;
        }
        JSOHelper.setObjectAttribute(getConfig(), SC.REF, this);
        JSOHelper.setObjectAttribute(getConfig(), SC.MODULE, BeanFactory.getSGWTModule());
        this.jsObj = jsObj;
        onBind();
    }
        


    public EditContext(){
        scClassName = "EditContext";
    }

    public EditContext(JavaScriptObject jsObj){
        scClassName = "EditContext";
        setJavaScriptObject(jsObj);
    }

    public native JavaScriptObject create()/*-{
        var config = this.@com.smartgwt.client.core.BaseClass::getConfig()();
        var scClassName = this.@com.smartgwt.client.core.BaseClass::scClassName;
        return $wnd.isc[scClassName].create(config);
    }-*/;

    private JavaScriptObject jsObj;
    
    @Override
    public boolean isCreated(){
        return this.jsObj != null;
    }

    @Override
    public JavaScriptObject getJsObj(){
        return this.jsObj;
    }

    @Override
    public JavaScriptObject getOrCreateJsObj() {
        if (!isCreated()) {
            this.jsObj = createJsObj();
            doInit();
        }
        return this.jsObj;
    }


    // ********************* Properties / Attributes ***********************

    /**
     * Controls whether components can be dropped into other components which support child components.  <p> When enabled,
     * during a drop interaction in which a {@link com.smartgwt.client.tools.PaletteNode} or {@link
     * com.smartgwt.client.tools.EditNode} is the drop data, the {@link com.smartgwt.client.docs.ComponentSchema Component
     * Schema} of the current candidate drop target is inspected to see whether that parent allows children of the type being
     * dropped.  If it does, the drop will result in a call to {@link com.smartgwt.client.tools.EditContext#addNode addNode()}
     * for a paletteNode or for an existing {@link com.smartgwt.client.tools.EditNode} in the same tree. <p> Specific
     * components can disable nested drops by explicitly setting {@link com.smartgwt.client.tools.EditProxy#getAllowNestedDrops
     * EditProxy.allowNestedDrops} to false. <p> This mode is enabled by default unless explicitly disabled by setting this
     * property to false.
     *
     * @param allowNestedDrops New allowNestedDrops value. Default value is null
     * @return {@link com.smartgwt.client.tools.EditContext EditContext} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public EditContext setAllowNestedDrops(Boolean allowNestedDrops)  throws IllegalStateException {
        return (EditContext)setAttribute("allowNestedDrops", allowNestedDrops, false);
    }

    /**
     * Controls whether components can be dropped into other components which support child components.  <p> When enabled,
     * during a drop interaction in which a {@link com.smartgwt.client.tools.PaletteNode} or {@link
     * com.smartgwt.client.tools.EditNode} is the drop data, the {@link com.smartgwt.client.docs.ComponentSchema Component
     * Schema} of the current candidate drop target is inspected to see whether that parent allows children of the type being
     * dropped.  If it does, the drop will result in a call to {@link com.smartgwt.client.tools.EditContext#addNode addNode()}
     * for a paletteNode or for an existing {@link com.smartgwt.client.tools.EditNode} in the same tree. <p> Specific
     * components can disable nested drops by explicitly setting {@link com.smartgwt.client.tools.EditProxy#getAllowNestedDrops
     * EditProxy.allowNestedDrops} to false. <p> This mode is enabled by default unless explicitly disabled by setting this
     * property to false.
     *
     * @return Current allowNestedDrops value. Default value is null
     */
    public Boolean getAllowNestedDrops()  {
        return getAttributeAsBoolean("allowNestedDrops");
    }
    

    /**
     * New nodes added to the editContext are automatically placed into edit mode if the new node's parent is in edit mode. To
     * suppress this action set <code>autoEditNewNodes</code> to false.
     *
     * @param autoEditNewNodes New autoEditNewNodes value. Default value is null
     * @return {@link com.smartgwt.client.tools.EditContext EditContext} instance, for chaining setter calls
     */
    public EditContext setAutoEditNewNodes(Boolean autoEditNewNodes) {
        return (EditContext)setAttribute("autoEditNewNodes", autoEditNewNodes, true);
    }

    /**
     * New nodes added to the editContext are automatically placed into edit mode if the new node's parent is in edit mode. To
     * suppress this action set <code>autoEditNewNodes</code> to false.
     *
     * @return Current autoEditNewNodes value. Default value is null
     */
    public Boolean getAutoEditNewNodes()  {
        return getAttributeAsBoolean("autoEditNewNodes");
    }
    

    /**
     * Should the group selection box shown when {@link com.smartgwt.client.tools.EditContext#getCanGroupSelect canGroupSelect}
     * is true allow dragging the group as a whole? <P> Treated as <code>true</code> if not set and {@link
     * com.smartgwt.client.tools.EditContext#getCanGroupSelect canGroupSelect} is true.
     *
     * @param canDragGroup New canDragGroup value. Default value is null
     * @return {@link com.smartgwt.client.tools.EditContext EditContext} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public EditContext setCanDragGroup(Boolean canDragGroup)  throws IllegalStateException {
        return (EditContext)setAttribute("canDragGroup", canDragGroup, false);
    }

    /**
     * Should the group selection box shown when {@link com.smartgwt.client.tools.EditContext#getCanGroupSelect canGroupSelect}
     * is true allow dragging the group as a whole? <P> Treated as <code>true</code> if not set and {@link
     * com.smartgwt.client.tools.EditContext#getCanGroupSelect canGroupSelect} is true.
     *
     * @return Current canDragGroup value. Default value is null
     */
    public Boolean getCanDragGroup()  {
        return getAttributeAsBoolean("canDragGroup");
    }
    

    /**
     * Should a group selection outline covering the outermost bounding boxes of all selected components be shown in this
     * container? <P> Treated as <code>true</code> if not set and hoop selection is enabled (see {@link
     * com.smartgwt.client.tools.EditProxy#getCanSelectChildren EditProxy.canSelectChildren} and {@link
     * com.smartgwt.client.tools.EditContext#getSelectionType selectionType}.
     *
     * @param canGroupSelect New canGroupSelect value. Default value is null
     * @return {@link com.smartgwt.client.tools.EditContext EditContext} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public EditContext setCanGroupSelect(Boolean canGroupSelect)  throws IllegalStateException {
        return (EditContext)setAttribute("canGroupSelect", canGroupSelect, false);
    }

    /**
     * Should a group selection outline covering the outermost bounding boxes of all selected components be shown in this
     * container? <P> Treated as <code>true</code> if not set and hoop selection is enabled (see {@link
     * com.smartgwt.client.tools.EditProxy#getCanSelectChildren EditProxy.canSelectChildren} and {@link
     * com.smartgwt.client.tools.EditContext#getSelectionType selectionType}.
     *
     * @return Current canGroupSelect value. Default value is null
     */
    public Boolean getCanGroupSelect()  {
        return getAttributeAsBoolean("canGroupSelect");
    }
    

    /**
     * Should editNodes added to this EditContext be selectable? When <code>true</code>, each {@link
     * com.smartgwt.client.tools.EditProxy#getCanSelectChildren EditProxy.canSelectChildren} property is enabled unless
     * explicitly set to <code>false</code>. This allows an individual component to override this setting.
     *
     * @param canSelectEditNodes New canSelectEditNodes value. Default value is null
     * @return {@link com.smartgwt.client.tools.EditContext EditContext} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public EditContext setCanSelectEditNodes(Boolean canSelectEditNodes)  throws IllegalStateException {
        return (EditContext)setAttribute("canSelectEditNodes", canSelectEditNodes, false);
    }

    /**
     * Should editNodes added to this EditContext be selectable? When <code>true</code>, each {@link
     * com.smartgwt.client.tools.EditProxy#getCanSelectChildren EditProxy.canSelectChildren} property is enabled unless
     * explicitly set to <code>false</code>. This allows an individual component to override this setting.
     *
     * @return Current canSelectEditNodes value. Default value is null
     */
    public Boolean getCanSelectEditNodes()  {
        return getAttributeAsBoolean("canSelectEditNodes");
    }
    

    /**
     * {@link com.smartgwt.client.tools.Palette} to use when an {@link com.smartgwt.client.tools.EditNode} is being created
     * directly by this EditContext, instead of being created due to a user interaction with a palette (eg dragging from a
     * {@link com.smartgwt.client.tools.TreePalette}, or clicking on {@link com.smartgwt.client.tools.MenuPalette}). <P> If no
     * defaultPalette is provided, the EditContext uses an automatically created {@link
     * com.smartgwt.client.tools.HiddenPalette}.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * {@link com.smartgwt.client.tools.Palette} to use when an {@link com.smartgwt.client.tools.EditNode} is being created directly by this EditContext, instead of being created due to a user interaction with a palette (eg dragging from a {@link com.smartgwt.client.tools.TreePalette}, or clicking on {@link com.smartgwt.client.tools.MenuPalette}). <P> If no defaultPalette is provided, the EditContext uses an automatically created {@link com.smartgwt.client.tools.HiddenPalette}.
     *
     * @param defaultPalette the default Palette. Default value is null
     * @return {@link com.smartgwt.client.tools.EditContext EditContext} instance, for chaining setter calls
     */
    public EditContext setDefaultPalette(Palette defaultPalette) {
        // Since Palette is an interface, we need to convert it to a
        // JavaScriptObject dynamically at run-time -- we don't know what class
        // is implementing the interface.
        JavaScriptObject jsoArray = JSOHelper.convertToJavaScriptArray(new Object[] {defaultPalette});
        JavaScriptObject jso = JSOHelper.getValueFromJavaScriptObjectArray(jsoArray, 0);
        return (EditContext)setAttribute("defaultPalette", jso == null ? null : jso, true);
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
     * com.smartgwt.client.tools.HiddenPalette}. Default value is null
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
     * The default parent {@link com.smartgwt.client.tools.EditNode} to be used when a new EditNode is added to the EditContext
     * without a specified parent. This commonly occurs when a paletteNode is double-clicked in a palette. <p> If not
     * specified, the root editNode (see {@link com.smartgwt.client.tools.EditContext#getRootEditNode getRootEditNode()}) is
     * used. <p> Note: this property is automatically cleared if node is removed from the editTree such as on calls to {@link
     * com.smartgwt.client.tools.EditContext#destroyAll destroyAll()} or {@link
     * com.smartgwt.client.tools.EditContext#removeNode removeNode()}.
     *
     * @param defaultParent New defaultParent value. Default value is null
     * @return {@link com.smartgwt.client.tools.EditContext EditContext} instance, for chaining setter calls
     */
    public EditContext setDefaultParent(EditNode defaultParent) {
        return (EditContext)setAttribute("defaultParent", defaultParent == null ? null : defaultParent.getJsObj(), true);
    }

    /**
     * The default parent {@link com.smartgwt.client.tools.EditNode} to be used when a new EditNode is added to the EditContext
     * without a specified parent. This commonly occurs when a paletteNode is double-clicked in a palette. <p> If not
     * specified, the root editNode (see {@link com.smartgwt.client.tools.EditContext#getRootEditNode getRootEditNode()}) is
     * used. <p> Note: this property is automatically cleared if node is removed from the editTree such as on calls to {@link
     * com.smartgwt.client.tools.EditContext#destroyAll destroyAll()} or {@link
     * com.smartgwt.client.tools.EditContext#removeNode removeNode()}.
     *
     * @return Current defaultParent value. Default value is null
     */
    public EditNode getDefaultParent()  {
        return new EditNode(getAttributeAsJavaScriptObject("defaultParent"));
    }
    

    /**
     * Properties to apply to all {@link com.smartgwt.client.tools.EditProxy#getEditMask EditProxy.editMask}s created for
     * components  in edit mode. This mask can be modified when the node is selected by {@link
     * com.smartgwt.client.tools.EditContext#getSelectedBorder selectedBorder}, {@link
     * com.smartgwt.client.tools.EditContext#getSelectedTintColor selectedTintColor} and {@link
     * com.smartgwt.client.tools.EditContext#getSelectedTintOpacity selectedTintOpacity} depending on the {@link
     * com.smartgwt.client.tools.EditContext#getSelectedAppearance selectedAppearance} setting.
     *
     * @param editMaskProperties New editMaskProperties value. Default value is null
     * @return {@link com.smartgwt.client.tools.EditContext EditContext} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public EditContext setEditMaskProperties(Map editMaskProperties)  throws IllegalStateException {
        return (EditContext)setAttribute("editMaskProperties", editMaskProperties, false);
    }

    /**
     * Properties to apply to all {@link com.smartgwt.client.tools.EditProxy#getEditMask EditProxy.editMask}s created for
     * components  in edit mode. This mask can be modified when the node is selected by {@link
     * com.smartgwt.client.tools.EditContext#getSelectedBorder selectedBorder}, {@link
     * com.smartgwt.client.tools.EditContext#getSelectedTintColor selectedTintColor} and {@link
     * com.smartgwt.client.tools.EditContext#getSelectedTintOpacity selectedTintOpacity} depending on the {@link
     * com.smartgwt.client.tools.EditContext#getSelectedAppearance selectedAppearance} setting.
     *
     * @return Current editMaskProperties value. Default value is null
     */
    public Map getEditMaskProperties()  {
        return getAttributeAsMap("editMaskProperties");
    }
    

    /**
     * Whether inline editing should be enabled for any components that are added and are placed into editMode.  Enabling this
     * will turn on inline edit for any EditProxy where {@link com.smartgwt.client.tools.EditProxy#getSupportsInlineEdit
     * EditProxy.supportsInlineEdit} is true.
     *
     * @param enableInlineEdit New enableInlineEdit value. Default value is null
     * @return {@link com.smartgwt.client.tools.EditContext EditContext} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public EditContext setEnableInlineEdit(Boolean enableInlineEdit)  throws IllegalStateException {
        return (EditContext)setAttribute("enableInlineEdit", enableInlineEdit, false);
    }

    /**
     * Whether inline editing should be enabled for any components that are added and are placed into editMode.  Enabling this
     * will turn on inline edit for any EditProxy where {@link com.smartgwt.client.tools.EditProxy#getSupportsInlineEdit
     * EditProxy.supportsInlineEdit} is true.
     *
     * @return Current enableInlineEdit value. Default value is null
     */
    public Boolean getEnableInlineEdit()  {
        return getAttributeAsBoolean("enableInlineEdit");
    }
    

    /**
     * Additional {@link com.smartgwt.client.tools.Palette Palettes} to consult for metadata when deserializing {@link
     * com.smartgwt.client.tools.EditNode Edit Nodes}. Note that the {@link
     * com.smartgwt.client.tools.EditContext#getDefaultPalette defaultPalette} is always consulted and need not be provided
     * again here.
     *
     * @param extraPalettes New extraPalettes value. Default value is null
     * @return {@link com.smartgwt.client.tools.EditContext EditContext} instance, for chaining setter calls
     */
    public EditContext setExtraPalettes(Palette... extraPalettes) {
        // Since Palette... is an interface, we need to convert it to a
        // JavaScriptObject dynamically at run-time -- we don't know what class
        // is implementing the interface.
        JavaScriptObject jsoArray = JSOHelper.convertToJavaScriptArray(new Object[] {extraPalettes});
        JavaScriptObject jso = JSOHelper.getValueFromJavaScriptObjectArray(jsoArray, 0);
        return (EditContext)setAttribute("extraPalettes", jso == null ? null : jso, true);
    }

    /**
     * Additional {@link com.smartgwt.client.tools.Palette Palettes} to consult for metadata when deserializing {@link
     * com.smartgwt.client.tools.EditNode Edit Nodes}. Note that the {@link
     * com.smartgwt.client.tools.EditContext#getDefaultPalette defaultPalette} is always consulted and need not be provided
     * again here.
     *
     * @return Current extraPalettes value. Default value is null
     */
    public Palette[] getExtraPalettes()  {
        return com.smartgwt.client.util.ConvertTo.arrayOfPalette(getAttributeAsJavaScriptObject("extraPalettes"));
    }
    

    /**
     * Should the group selection box shown when {@link com.smartgwt.client.tools.EditContext#getCanGroupSelect canGroupSelect}
     * is true be hidden during drag? <P> Treated as <code>true</code> if not explicitly set to false.
     *
     * @param hideGroupBorderOnDrag New hideGroupBorderOnDrag value. Default value is null
     * @return {@link com.smartgwt.client.tools.EditContext EditContext} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public EditContext setHideGroupBorderOnDrag(Boolean hideGroupBorderOnDrag)  throws IllegalStateException {
        return (EditContext)setAttribute("hideGroupBorderOnDrag", hideGroupBorderOnDrag, false);
    }

    /**
     * Should the group selection box shown when {@link com.smartgwt.client.tools.EditContext#getCanGroupSelect canGroupSelect}
     * is true be hidden during drag? <P> Treated as <code>true</code> if not explicitly set to false.
     *
     * @return Current hideGroupBorderOnDrag value. Default value is null
     */
    public Boolean getHideGroupBorderOnDrag()  {
        return getAttributeAsBoolean("hideGroupBorderOnDrag");
    }
    

    /**
     * Defines the mode of inclusion for components encountered during hoop selection which is enabled when {@link
     * com.smartgwt.client.tools.EditContext#getSelectionType selectionType} is <code>multiple</code>. <code>encloses</code>
     * mode causes selection of components that are completely enclosed by the hoop. <code>intersects</code> mode selects
     * components that come into contact with the hoop.
     *
     * @param hoopSelectionMode New hoopSelectionMode value. Default value is "encloses"
     * @return {@link com.smartgwt.client.tools.EditContext EditContext} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     * @see com.smartgwt.client.types.HoopSelectionStyle
     */
    public EditContext setHoopSelectionMode(HoopSelectionStyle hoopSelectionMode)  throws IllegalStateException {
        return (EditContext)setAttribute("hoopSelectionMode", hoopSelectionMode == null ? null : hoopSelectionMode.getValue(), false);
    }

    /**
     * Defines the mode of inclusion for components encountered during hoop selection which is enabled when {@link
     * com.smartgwt.client.tools.EditContext#getSelectionType selectionType} is <code>multiple</code>. <code>encloses</code>
     * mode causes selection of components that are completely enclosed by the hoop. <code>intersects</code> mode selects
     * components that come into contact with the hoop.
     *
     * @return Current hoopSelectionMode value. Default value is "encloses"
     * @see com.smartgwt.client.types.HoopSelectionStyle
     */
    public HoopSelectionStyle getHoopSelectionMode()  {
        return EnumUtil.getEnum(HoopSelectionStyle.values(), getAttribute("hoopSelectionMode"));
    }
    

    /**
     * Properties to apply to {@link com.smartgwt.client.tools.EditProxy#getHoopSelector EditProxy.hoopSelector}.
     *
     * @param hoopSelectorProperties New hoopSelectorProperties value. Default value is null
     * @return {@link com.smartgwt.client.tools.EditContext EditContext} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public EditContext setHoopSelectorProperties(Map hoopSelectorProperties)  throws IllegalStateException {
        return (EditContext)setAttribute("hoopSelectorProperties", hoopSelectorProperties, false);
    }

    /**
     * Properties to apply to {@link com.smartgwt.client.tools.EditProxy#getHoopSelector EditProxy.hoopSelector}.
     *
     * @return Current hoopSelectorProperties value. Default value is null
     */
    public Map getHoopSelectorProperties()  {
        return getAttributeAsMap("hoopSelectorProperties");
    }
    

    /**
     * When enabled, changes to a {@link com.smartgwt.client.tools.EditNode#getLiveObject liveObject}'s position and size will
     * be persisted to their {@link com.smartgwt.client.tools.EditNode EditNodes} by default. This applies to both programmatic
     * calls and user interaction (drag reposition or drag resize). <p> This feature can be disabled by either setting this
     * property or {@link com.smartgwt.client.tools.EditProxy#getPersistCoordinates EditProxy.persistCoordinates} to
     * <code>false</code>. This property affects all nodes within the EditContext whereas the latter property affects children
     * of a single node.  <p> In some use-cases, like VisualBuilder, coordinates should not be persisted except when a
     * component explicitly enables this feature. By setting this property to <code>null</code> no component will persist
     * coordinates of children unless <code>EditProxy.persistCoordinates</code> is explicitly set to <code>true</code>.
     *
     * @param persistCoordinates New persistCoordinates value. Default value is true
     * @return {@link com.smartgwt.client.tools.EditContext EditContext} instance, for chaining setter calls
     */
    public EditContext setPersistCoordinates(Boolean persistCoordinates) {
        return (EditContext)setAttribute("persistCoordinates", persistCoordinates, true);
    }

    /**
     * When enabled, changes to a {@link com.smartgwt.client.tools.EditNode#getLiveObject liveObject}'s position and size will
     * be persisted to their {@link com.smartgwt.client.tools.EditNode EditNodes} by default. This applies to both programmatic
     * calls and user interaction (drag reposition or drag resize). <p> This feature can be disabled by either setting this
     * property or {@link com.smartgwt.client.tools.EditProxy#getPersistCoordinates EditProxy.persistCoordinates} to
     * <code>false</code>. This property affects all nodes within the EditContext whereas the latter property affects children
     * of a single node.  <p> In some use-cases, like VisualBuilder, coordinates should not be persisted except when a
     * component explicitly enables this feature. By setting this property to <code>null</code> no component will persist
     * coordinates of children unless <code>EditProxy.persistCoordinates</code> is explicitly set to <code>true</code>.
     *
     * @return Current persistCoordinates value. Default value is true
     */
    public Boolean getPersistCoordinates()  {
        Boolean result = getAttributeAsBoolean("persistCoordinates");
        return result == null ? true : result;
    }
    

    /**
     * Root of data to edit.  Must contain the "type" property, with the name of a valid {@link
     * com.smartgwt.client.data.DataSource schema} or nothing will be able to be dropped on this EditContext. A "liveObject"
     * property representing the rootComponent is also suggested. Otherwise, a live object will be created from the palette
     * node. <P> Can be retrieved at any time. Use {@link com.smartgwt.client.tools.EditContext#getRootEditNode
     * getRootEditNode()} to retrieve the {@link com.smartgwt.client.tools.EditNode} created from the rootComponent.
     *
     * @param rootComponent New rootComponent value. Default value is null
     * @return {@link com.smartgwt.client.tools.EditContext EditContext} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     * @see com.smartgwt.client.docs.DevTools DevTools overview and related methods
     */
    public EditContext setRootComponent(PaletteNode rootComponent)  throws IllegalStateException {
        return (EditContext)setAttribute("rootComponent", rootComponent == null ? null : rootComponent.getJsObj(), false);
    }

    /**
     * Root of data to edit.  Must contain the "type" property, with the name of a valid {@link
     * com.smartgwt.client.data.DataSource schema} or nothing will be able to be dropped on this EditContext. A "liveObject"
     * property representing the rootComponent is also suggested. Otherwise, a live object will be created from the palette
     * node. <P> Can be retrieved at any time. Use {@link com.smartgwt.client.tools.EditContext#getRootEditNode
     * getRootEditNode()} to retrieve the {@link com.smartgwt.client.tools.EditNode} created from the rootComponent.
     *
     * @return Current rootComponent value. Default value is null
     * @see com.smartgwt.client.docs.DevTools DevTools overview and related methods
     */
    public PaletteNode getRootComponent()  {
        return new PaletteNode(getAttributeAsJavaScriptObject("rootComponent"));
    }
    

    /**
     * Appearance that is applied to selected component. <P> This value is applied as a default to {@link
     * com.smartgwt.client.tools.EditProxy#getSelectedAppearance EditProxy.selectedAppearance}.
     *
     * @param selectedAppearance New selectedAppearance value. Default value is null
     * @return {@link com.smartgwt.client.tools.EditContext EditContext} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     * @see com.smartgwt.client.tools.EditContext#setSelectedBorder
     * @see com.smartgwt.client.tools.EditContext#setSelectedTintColor
     * @see com.smartgwt.client.tools.EditContext#setSelectedTintOpacity
     */
    public EditContext setSelectedAppearance(SelectedAppearance selectedAppearance)  throws IllegalStateException {
        return (EditContext)setAttribute("selectedAppearance", selectedAppearance == null ? null : selectedAppearance.getValue(), false);
    }

    /**
     * Appearance that is applied to selected component. <P> This value is applied as a default to {@link
     * com.smartgwt.client.tools.EditProxy#getSelectedAppearance EditProxy.selectedAppearance}.
     *
     * @return Current selectedAppearance value. Default value is null
     * @see com.smartgwt.client.tools.EditContext#getSelectedBorder
     * @see com.smartgwt.client.tools.EditContext#getSelectedTintColor
     * @see com.smartgwt.client.tools.EditContext#getSelectedTintOpacity
     */
    public SelectedAppearance getSelectedAppearance()  {
        return EnumUtil.getEnum(SelectedAppearance.values(), getAttribute("selectedAppearance"));
    }
    

    /**
     * Set the CSS border to be applied to the selection outline of the selected components. This property is used when {@link
     * com.smartgwt.client.tools.EditProxy#getSelectedAppearance EditProxy.selectedAppearance} is <code>outlineMask</code> or
     * <code>outlineEdges</code>. <P> This value is applied as a default to {@link
     * com.smartgwt.client.tools.EditProxy#getSelectedBorder EditProxy.selectedBorder}.
     *
     * @param selectedBorder New selectedBorder value. Default value is "1px dashed #44ff44"
     * @return {@link com.smartgwt.client.tools.EditContext EditContext} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public EditContext setSelectedBorder(String selectedBorder)  throws IllegalStateException {
        return (EditContext)setAttribute("selectedBorder", selectedBorder, false);
    }

    /**
     * Set the CSS border to be applied to the selection outline of the selected components. This property is used when {@link
     * com.smartgwt.client.tools.EditProxy#getSelectedAppearance EditProxy.selectedAppearance} is <code>outlineMask</code> or
     * <code>outlineEdges</code>. <P> This value is applied as a default to {@link
     * com.smartgwt.client.tools.EditProxy#getSelectedBorder EditProxy.selectedBorder}.
     *
     * @return Current selectedBorder value. Default value is "1px dashed #44ff44"
     */
    public String getSelectedBorder()  {
        return getAttributeAsString("selectedBorder");
    }
    

    /**
     * The background color for the selection outline label. The default is defined on {@link
     * com.smartgwt.client.tools.SelectionOutline}. <P> This value is applied as a default to {@link
     * com.smartgwt.client.tools.EditProxy#getSelectedLabelBackgroundColor EditProxy.selectedLabelBackgroundColor}. <P> NOTE: A
     * selected component label is only supported when {@link com.smartgwt.client.tools.EditProxy#getSelectedAppearance
     * EditProxy.selectedAppearance} is "outlineEdges".
     *
     * @param selectedLabelBackgroundColor New selectedLabelBackgroundColor value. Default value is null
     * @return {@link com.smartgwt.client.tools.EditContext EditContext} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     * @see com.smartgwt.client.tools.EditContext#setShowSelectedLabel
     */
    public EditContext setSelectedLabelBackgroundColor(String selectedLabelBackgroundColor)  throws IllegalStateException {
        return (EditContext)setAttribute("selectedLabelBackgroundColor", selectedLabelBackgroundColor, false);
    }

    /**
     * The background color for the selection outline label. The default is defined on {@link
     * com.smartgwt.client.tools.SelectionOutline}. <P> This value is applied as a default to {@link
     * com.smartgwt.client.tools.EditProxy#getSelectedLabelBackgroundColor EditProxy.selectedLabelBackgroundColor}. <P> NOTE: A
     * selected component label is only supported when {@link com.smartgwt.client.tools.EditProxy#getSelectedAppearance
     * EditProxy.selectedAppearance} is "outlineEdges".
     *
     * @return Current selectedLabelBackgroundColor value. Default value is null
     * @see com.smartgwt.client.tools.EditContext#getShowSelectedLabel
     */
    public String getSelectedLabelBackgroundColor()  {
        return getAttributeAsString("selectedLabelBackgroundColor");
    }
    

    /**
     * Mask color applied to {@link com.smartgwt.client.tools.EditProxy#getEditMask editMask} of selected component when {@link
     * com.smartgwt.client.tools.EditProxy#getSelectedAppearance EditProxy.selectedAppearance} is "tintMask". <P> This value is
     * applied as a default to {@link com.smartgwt.client.tools.EditProxy#getSelectedTintColor EditProxy.selectedTintColor}.
     *
     * @param selectedTintColor New selectedTintColor value. Default value is "#cccccc"
     * @return {@link com.smartgwt.client.tools.EditContext EditContext} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     * @see com.smartgwt.client.tools.EditContext#setSelectedTintOpacity
     * @see com.smartgwt.client.docs.CSSColor CSSColor 
     */
    public EditContext setSelectedTintColor(String selectedTintColor)  throws IllegalStateException {
        return (EditContext)setAttribute("selectedTintColor", selectedTintColor, false);
    }

    /**
     * Mask color applied to {@link com.smartgwt.client.tools.EditProxy#getEditMask editMask} of selected component when {@link
     * com.smartgwt.client.tools.EditProxy#getSelectedAppearance EditProxy.selectedAppearance} is "tintMask". <P> This value is
     * applied as a default to {@link com.smartgwt.client.tools.EditProxy#getSelectedTintColor EditProxy.selectedTintColor}.
     *
     * @return Current selectedTintColor value. Default value is "#cccccc"
     * @see com.smartgwt.client.tools.EditContext#getSelectedTintOpacity
     * @see com.smartgwt.client.docs.CSSColor CSSColor 
     */
    public String getSelectedTintColor()  {
        return getAttributeAsString("selectedTintColor");
    }
    

    /**
     * Opacity applied to {@link com.smartgwt.client.tools.EditProxy#getEditMask editMask} of selected component when {@link
     * com.smartgwt.client.tools.EditProxy#getSelectedAppearance EditProxy.selectedAppearance} is "tintMask". <P> This value is
     * applied as a default to {@link com.smartgwt.client.tools.EditProxy#getSelectedTintOpacity
     * EditProxy.selectedTintOpacity}.
     *
     * @param selectedTintOpacity New selectedTintOpacity value. Default value is 25
     * @return {@link com.smartgwt.client.tools.EditContext EditContext} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     * @see com.smartgwt.client.tools.EditContext#setSelectedTintColor
     */
    public EditContext setSelectedTintOpacity(int selectedTintOpacity)  throws IllegalStateException {
        return (EditContext)setAttribute("selectedTintOpacity", selectedTintOpacity, false);
    }

    /**
     * Opacity applied to {@link com.smartgwt.client.tools.EditProxy#getEditMask editMask} of selected component when {@link
     * com.smartgwt.client.tools.EditProxy#getSelectedAppearance EditProxy.selectedAppearance} is "tintMask". <P> This value is
     * applied as a default to {@link com.smartgwt.client.tools.EditProxy#getSelectedTintOpacity
     * EditProxy.selectedTintOpacity}.
     *
     * @return Current selectedTintOpacity value. Default value is 25
     * @see com.smartgwt.client.tools.EditContext#getSelectedTintColor
     */
    public int getSelectedTintOpacity()  {
        return getAttributeAsInt("selectedTintOpacity");
    }
    

    /**
     * Defines selection behavior when in edit mode. Only two styles are supported: "single" and "multiple". Multiple enables
     * hoop selection.
     *
     * @param selectionType New selectionType value. Default value is "multiple"
     * @return {@link com.smartgwt.client.tools.EditContext EditContext} instance, for chaining setter calls
     * @see com.smartgwt.client.types.SelectionStyle
     */
    public EditContext setSelectionType(SelectionStyle selectionType) {
        return (EditContext)setAttribute("selectionType", selectionType == null ? null : selectionType.getValue(), true);
    }

    /**
     * Defines selection behavior when in edit mode. Only two styles are supported: "single" and "multiple". Multiple enables
     * hoop selection.
     *
     * @return Current selectionType value. Default value is "multiple"
     * @see com.smartgwt.client.types.SelectionStyle
     */
    public SelectionStyle getSelectionType()  {
        return EnumUtil.getEnum(SelectionStyle.values(), getAttribute("selectionType"));
    }
    

    /**
     * Should the selection outline show a label for selected components? A component may also be highlighted with the
     * selection outline and label to indicate the target of a drop. To suppress showing a label at any time set this property
     * to <code>false</code>. <P> To suppress labels during selection but still show them when targeted for a drop, see {@link
     * com.smartgwt.client.tools.EditContext#getShowSelectedLabelOnSelect showSelectedLabelOnSelect}. <P> NOTE: A selected
     * component label is only supported when {@link com.smartgwt.client.tools.EditProxy#getSelectedAppearance
     * EditProxy.selectedAppearance} is "outlineEdges".
     *
     * @param showSelectedLabel New showSelectedLabel value. Default value is null
     * @return {@link com.smartgwt.client.tools.EditContext EditContext} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public EditContext setShowSelectedLabel(Boolean showSelectedLabel)  throws IllegalStateException {
        return (EditContext)setAttribute("showSelectedLabel", showSelectedLabel, false);
    }

    /**
     * Should the selection outline show a label for selected components? A component may also be highlighted with the
     * selection outline and label to indicate the target of a drop. To suppress showing a label at any time set this property
     * to <code>false</code>. <P> To suppress labels during selection but still show them when targeted for a drop, see {@link
     * com.smartgwt.client.tools.EditContext#getShowSelectedLabelOnSelect showSelectedLabelOnSelect}. <P> NOTE: A selected
     * component label is only supported when {@link com.smartgwt.client.tools.EditProxy#getSelectedAppearance
     * EditProxy.selectedAppearance} is "outlineEdges".
     *
     * @return Current showSelectedLabel value. Default value is null
     */
    public Boolean getShowSelectedLabel()  {
        return getAttributeAsBoolean("showSelectedLabel");
    }
    

    /**
     * Should the selection outline show a label when the component is selected? This property is similar to {@link
     * com.smartgwt.client.tools.EditContext#getShowSelectedLabel showSelectedLabel}. Whereas {@link
     * com.smartgwt.client.tools.EditContext#getShowSelectedLabel showSelectedLabel} controls whether a label is shown at any
     * time, this property allows normal selection to suppress the label but still show a label during the drop process on the
     * target. Leave {@link com.smartgwt.client.tools.EditContext#getShowSelectedLabel showSelectedLabel} unset and set this
     * property to <code>false</code>. <P> NOTE: A selected component label is only supported when {@link
     * com.smartgwt.client.tools.EditProxy#getSelectedAppearance EditProxy.selectedAppearance} is "outlineEdges".
     *
     * @param showSelectedLabelOnSelect New showSelectedLabelOnSelect value. Default value is null
     * @return {@link com.smartgwt.client.tools.EditContext EditContext} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public EditContext setShowSelectedLabelOnSelect(Boolean showSelectedLabelOnSelect)  throws IllegalStateException {
        return (EditContext)setAttribute("showSelectedLabelOnSelect", showSelectedLabelOnSelect, false);
    }

    /**
     * Should the selection outline show a label when the component is selected? This property is similar to {@link
     * com.smartgwt.client.tools.EditContext#getShowSelectedLabel showSelectedLabel}. Whereas {@link
     * com.smartgwt.client.tools.EditContext#getShowSelectedLabel showSelectedLabel} controls whether a label is shown at any
     * time, this property allows normal selection to suppress the label but still show a label during the drop process on the
     * target. Leave {@link com.smartgwt.client.tools.EditContext#getShowSelectedLabel showSelectedLabel} unset and set this
     * property to <code>false</code>. <P> NOTE: A selected component label is only supported when {@link
     * com.smartgwt.client.tools.EditProxy#getSelectedAppearance EditProxy.selectedAppearance} is "outlineEdges".
     *
     * @return Current showSelectedLabelOnSelect value. Default value is null
     */
    public Boolean getShowSelectedLabelOnSelect()  {
        return getAttributeAsBoolean("showSelectedLabelOnSelect");
    }
    

    /**
     * If set, auto-enables {@link com.smartgwt.client.tools.EditProxy#getUseCopyPasteShortcuts
     * EditProxy.useCopyPasteShortcuts} on the {@link com.smartgwt.client.tools.EditProxy} for the {@link
     * com.smartgwt.client.tools.EditContext#getRootEditNode root editNode}.  This works whether there is currently a root
     * editNode or one is added later.
     *
     * @param useCopyPasteShortcuts New useCopyPasteShortcuts value. Default value is null
     * @return {@link com.smartgwt.client.tools.EditContext EditContext} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public EditContext setUseCopyPasteShortcuts(Boolean useCopyPasteShortcuts)  throws IllegalStateException {
        return (EditContext)setAttribute("useCopyPasteShortcuts", useCopyPasteShortcuts, false);
    }

    /**
     * If set, auto-enables {@link com.smartgwt.client.tools.EditProxy#getUseCopyPasteShortcuts
     * EditProxy.useCopyPasteShortcuts} on the {@link com.smartgwt.client.tools.EditProxy} for the {@link
     * com.smartgwt.client.tools.EditContext#getRootEditNode root editNode}.  This works whether there is currently a root
     * editNode or one is added later.
     *
     * @return Current useCopyPasteShortcuts value. Default value is null
     */
    public Boolean getUseCopyPasteShortcuts()  {
        return getAttributeAsBoolean("useCopyPasteShortcuts");
    }
    

    // ********************* Methods ***********************
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
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "addFromPaletteNode", "PaletteNode");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
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
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "addFromPaletteNode", "PaletteNode,EditNode");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
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
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "addFromPaletteNodes", "PaletteNode[]");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
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
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "addFromPaletteNodes", "PaletteNode[],EditNode");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.addFromPaletteNodes(@com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(paletteNodes), parentNode == null ? null : parentNode.@com.smartgwt.client.core.DataClass::getJsObj()());
        if(ret == null) return null;
        return @com.smartgwt.client.util.ConvertTo::arrayOfEditNode(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;
	
	/**
     * Add a new {@link com.smartgwt.client.tools.EditNode} to the EditContext, under the specified parent. If the parentNode
     * is not provided it will be determined from {@link com.smartgwt.client.tools.EditContext#getDefaultParent defaultParent}.
     * <P> The EditContext will interrogate the parent and new nodes to determine what field  within the parent allows a child
     * of this type, and to find a method to add the newNode's  liveObject to the parentNode's liveObject.  The new
     * relationship will then be stored in the tree of EditNodes. <P> For example, when a Tab is dropped on a TabSet, the field
     * TabSet.tabs is discovered as the correct target field via naming conventions, and the method TabSet.addTab() is likewise
     *  discovered as the correct method to add a Tab to a TabSet.
     * @param newNode new node to be added
     *
     * @return newNodenode added
     */
    public native EditNode addNode(EditNode newNode) /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "addNode", "EditNode");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.addNode(newNode.@com.smartgwt.client.core.DataClass::getJsObj()());
        if(ret == null) return null;
        return @com.smartgwt.client.tools.EditNode::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

    /**
     * @see EditContext#addNode
     */
    public EditNode addNode(EditNode newNode, EditNode parentNode){
        return addNode(newNode, parentNode, (Integer) null, null, null, null);
    }

    /**
     * @see EditContext#addNode
     */
    public EditNode addNode(EditNode newNode, EditNode parentNode, Integer index){
        return addNode(newNode, parentNode, index, null, null, null);
    }

    /**
     * @see EditContext#addNode
     */
    public EditNode addNode(EditNode newNode, EditNode parentNode, Integer index, String parentProperty){
        return addNode(newNode, parentNode, index, parentProperty, null, null);
    }

    /**
     * @see EditContext#addNode
     */
    public EditNode addNode(EditNode newNode, EditNode parentNode, Integer index, String parentProperty, Boolean skipParentComponentAdd){
        return addNode(newNode, parentNode, index, parentProperty, skipParentComponentAdd, null);
    }

	/**
     * Add a new {@link com.smartgwt.client.tools.EditNode} to the EditContext, under the specified parent. If the parentNode
     * is not provided it will be determined from {@link com.smartgwt.client.tools.EditContext#getDefaultParent defaultParent}.
     * <P> The EditContext will interrogate the parent and new nodes to determine what field  within the parent allows a child
     * of this type, and to find a method to add the newNode's  liveObject to the parentNode's liveObject.  The new
     * relationship will then be stored in the tree of EditNodes. <P> For example, when a Tab is dropped on a TabSet, the field
     * TabSet.tabs is discovered as the correct target field via naming conventions, and the method TabSet.addTab() is likewise
     *  discovered as the correct method to add a Tab to a TabSet.
     * @param newNode new node to be added
     * @param parentNode parent to add the new node under.
     * @param index index within the parent's children array
     * @param parentProperty the property of the liveParent to which the new node should                                  be added, if not
     * auto-discoverable from the schema
     * @param skipParentComponentAdd whether to skip adding the liveObject to the liveParent                                           (default false)
     * @param forceSingularFieldReplace whether to replace existing single field node                                              if newNode liveObject is the
     * same (default false)
     *
     * @return newNodenode added
     */
    public native EditNode addNode(EditNode newNode, EditNode parentNode, Integer index, String parentProperty, Boolean skipParentComponentAdd, Boolean forceSingularFieldReplace) /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "addNode", "EditNode,EditNode,Integer,String,Boolean,Boolean");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.addNode(newNode.@com.smartgwt.client.core.DataClass::getJsObj()(), parentNode == null ? null : parentNode.@com.smartgwt.client.core.DataClass::getJsObj()(), index == null ? null : index.@java.lang.Integer::intValue()(), parentProperty, skipParentComponentAdd == null ? null : skipParentComponentAdd.@java.lang.Boolean::booleanValue()(), forceSingularFieldReplace == null ? null : forceSingularFieldReplace.@java.lang.Boolean::booleanValue()());
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
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "addPaletteNodesFromJS", "String");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.addPaletteNodesFromJS(jsCode);
    }-*/;

    /**
     * @see EditContext#addPaletteNodesFromJS
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
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "addPaletteNodesFromJS", "String,EditNode,String[]");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.addPaletteNodesFromJS(jsCode, parentNode == null ? null : parentNode.@com.smartgwt.client.core.DataClass::getJsObj()(), @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(globals));
    }-*/;
	
	/**
     * Recreate {@link com.smartgwt.client.tools.EditNode EditNodes} from a JSON representation of  {@link
     * com.smartgwt.client.tools.PaletteNode PaletteNodes} (possibly created by calling {@link
     * com.smartgwt.client.tools.EditContext#serializeAllEditNodesAsJSON serializeAllEditNodesAsJSON()} or {@link
     * com.smartgwt.client.tools.EditContext#serializeEditNodesAsJSON serializeEditNodesAsJSON()}. <P> By default, components
     * that have {@link com.smartgwt.client.widgets.Canvas#getID global IDs} will not actually be allowed to take those global
     * IDs - instead, only widgets that have one of the global IDs passed as the <code>globals</code> parameter will actually
     * receive their global IDs.  To override this behavior, pass the special value {@link
     * com.smartgwt.client.rpc.RPCManager#ALL_GLOBALS ALL_GLOBALS} for the <code>globals</code> parameter.
     * @param jsonString JSON string representing an array of PaletteNodes
     * @see com.smartgwt.client.tools.EditContext#addFromPaletteNodes
     * @see com.smartgwt.client.tools.EditContext#serializeAllEditNodesAsJSON
     * @see com.smartgwt.client.tools.EditContext#serializeEditNodesAsJSON
     */
    public native void addPaletteNodesFromJSON(String jsonString) /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "addPaletteNodesFromJSON", "String");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.addPaletteNodesFromJSON(jsonString);
    }-*/;

    /**
     * @see EditContext#addPaletteNodesFromJSON
     */
    public void addPaletteNodesFromJSON(String jsonString, EditNode parentNode){
        addPaletteNodesFromJSON(jsonString, parentNode, null, null);
    }

    /**
     * @see EditContext#addPaletteNodesFromJSON
     */
    public void addPaletteNodesFromJSON(String jsonString, EditNode parentNode, String[] globals){
        addPaletteNodesFromJSON(jsonString, parentNode, globals, null);
    }

	/**
     * Recreate {@link com.smartgwt.client.tools.EditNode EditNodes} from a JSON representation of  {@link
     * com.smartgwt.client.tools.PaletteNode PaletteNodes} (possibly created by calling {@link
     * com.smartgwt.client.tools.EditContext#serializeAllEditNodesAsJSON serializeAllEditNodesAsJSON()} or {@link
     * com.smartgwt.client.tools.EditContext#serializeEditNodesAsJSON serializeEditNodesAsJSON()}. <P> By default, components
     * that have {@link com.smartgwt.client.widgets.Canvas#getID global IDs} will not actually be allowed to take those global
     * IDs - instead, only widgets that have one of the global IDs passed as the <code>globals</code> parameter will actually
     * receive their global IDs.  To override this behavior, pass the special value {@link
     * com.smartgwt.client.rpc.RPCManager#ALL_GLOBALS ALL_GLOBALS} for the <code>globals</code> parameter.
     * @param jsonString JSON string representing an array of PaletteNodes
     * @param parentNode parent to add to (defaults to the root)
     * @param globals widgets to allow to take their global IDs
     * @param callback Callback to fire after nodes have been added
     * @see com.smartgwt.client.tools.EditContext#addFromPaletteNodes
     * @see com.smartgwt.client.tools.EditContext#serializeAllEditNodesAsJSON
     * @see com.smartgwt.client.tools.EditContext#serializeEditNodesAsJSON
     */
    public native void addPaletteNodesFromJSON(String jsonString, EditNode parentNode, String[] globals, Function callback) /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "addPaletteNodesFromJSON", "String,EditNode,String[],Function");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.addPaletteNodesFromJSON(jsonString, parentNode == null ? null : parentNode.@com.smartgwt.client.core.DataClass::getJsObj()(), @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(globals), 
			$entry( function() { 
				if(callback!=null) callback.@com.smartgwt.client.core.Function::execute()(
				);
			}));
    }-*/;
	
	/**
     * Recreate {@link com.smartgwt.client.tools.EditNode EditNodes} from an XML representation of  {@link
     * com.smartgwt.client.tools.PaletteNode PaletteNodes} (possibly created by calling {@link
     * com.smartgwt.client.tools.EditContext#serializeAllEditNodes serializeAllEditNodes()} or {@link
     * com.smartgwt.client.tools.EditContext#serializeEditNodes serializeEditNodes()}. <P> By default, components that have
     * {@link com.smartgwt.client.widgets.Canvas#getID global IDs} will not actually be allowed to take those global IDs -
     * instead, only widgets that have one of the global IDs passed as the <code>globals</code> parameter will actually receive
     * their global IDs.  To override this behavior, pass the special value {@link
     * com.smartgwt.client.rpc.RPCManager#ALL_GLOBALS ALL_GLOBALS} for the <code>globals</code> parameter.
     * @param xmlString XML string
     * @see com.smartgwt.client.tools.EditContext#serializeAllEditNodes
     * @see com.smartgwt.client.tools.EditContext#serializeEditNodes
     */
    public native void addPaletteNodesFromXML(String xmlString) /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "addPaletteNodesFromXML", "String");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.addPaletteNodesFromXML(xmlString);
    }-*/;

    /**
     * @see EditContext#addPaletteNodesFromXML
     */
    public void addPaletteNodesFromXML(String xmlString, EditNode parentNode){
        addPaletteNodesFromXML(xmlString, parentNode, null, null);
    }

    /**
     * @see EditContext#addPaletteNodesFromXML
     */
    public void addPaletteNodesFromXML(String xmlString, EditNode parentNode, String[] globals){
        addPaletteNodesFromXML(xmlString, parentNode, globals, null);
    }

	/**
     * Recreate {@link com.smartgwt.client.tools.EditNode EditNodes} from an XML representation of  {@link
     * com.smartgwt.client.tools.PaletteNode PaletteNodes} (possibly created by calling {@link
     * com.smartgwt.client.tools.EditContext#serializeAllEditNodes serializeAllEditNodes()} or {@link
     * com.smartgwt.client.tools.EditContext#serializeEditNodes serializeEditNodes()}. <P> By default, components that have
     * {@link com.smartgwt.client.widgets.Canvas#getID global IDs} will not actually be allowed to take those global IDs -
     * instead, only widgets that have one of the global IDs passed as the <code>globals</code> parameter will actually receive
     * their global IDs.  To override this behavior, pass the special value {@link
     * com.smartgwt.client.rpc.RPCManager#ALL_GLOBALS ALL_GLOBALS} for the <code>globals</code> parameter.
     * @param xmlString XML string
     * @param parentNode parent node (defaults to the root)
     * @param globals widgets to allow to take their global IDs
     * @param callback Callback to fire after nodes have been added
     * @see com.smartgwt.client.tools.EditContext#serializeAllEditNodes
     * @see com.smartgwt.client.tools.EditContext#serializeEditNodes
     */
    public native void addPaletteNodesFromXML(String xmlString, EditNode parentNode, String[] globals, Function callback) /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "addPaletteNodesFromXML", "String,EditNode,String[],Function");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.addPaletteNodesFromXML(xmlString, parentNode == null ? null : parentNode.@com.smartgwt.client.core.DataClass::getJsObj()(), @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(globals), 
			$entry( function() { 
				if(callback!=null) callback.@com.smartgwt.client.core.Function::execute()(
				);
			}));
    }-*/;
	
	/**
     * Copies the passed editNode or editNodes to an internal "clipboard" space, for later application via {@link
     * com.smartgwt.client.tools.EditContext#pasteEditNodes pasteEditNodes()}.
     * @param editNode 
     */
    public native void copyEditNodes(EditNode editNode) /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "copyEditNodes", "EditNode");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.copyEditNodes(editNode.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;

	/**
     * Copies the passed editNode or editNodes to an internal "clipboard" space, for later application via {@link
     * com.smartgwt.client.tools.EditContext#pasteEditNodes pasteEditNodes()}.
     * @param editNode 
     */
    public native void copyEditNodes(EditNode... editNode) /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "copyEditNodes", "EditNode...");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.copyEditNodes(@com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(editNode));
    }-*/;

	/**
     * Deselect all EditNodes.
     */
    public native void deselectAllEditNodes() /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "deselectAllEditNodes", "");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.deselectAllEditNodes();
    }-*/;

	/**
     * Deselect a list of EditNodes.
     * @param editNodes editNodes to deselect
     */
    public native void deselectEditNodes(List editNodes) /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "deselectEditNodes", "List");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.deselectEditNodes(editNodes);
    }-*/;

	/**
     * Removes all {@link com.smartgwt.client.tools.EditNode EditNodes} from the EditContext, and calls {@link
     * com.smartgwt.client.widgets.Canvas#destroy destroy()} on the {@link com.smartgwt.client.tools.EditNode#getLiveObject
     * liveObjects}.
     */
    public native void destroyAll() /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "destroyAll", "");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.destroyAll();
    }-*/;

    /**
     * Add a editMaskClicked handler.
     * <p>
     * Executed when the left mouse is clicked (pressed and then released) on any selectable component with {@link
     * com.smartgwt.client.tools.EditProxy#getEditMask EditProxy.editMask} enabled. implementation.
     *
     * @param handler the editMaskClicked handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addEditMaskClickedHandler(com.smartgwt.client.tools.EditMaskClickedHandler handler) {
        if(getHandlerCount(com.smartgwt.client.tools.EditMaskClickedEvent.getType()) == 0) setupEditMaskClickedEvent();
        return doAddHandler(handler, com.smartgwt.client.tools.EditMaskClickedEvent.getType());
    }

    private native void setupEditMaskClickedEvent() /*-{
        var obj;
        var selfJ = this;
        var editMaskClicked = $entry(function(){
            var param = {"_this": this, "editNode" : arguments[0], "liveObject" : arguments[1]};
                var event = @com.smartgwt.client.tools.EditMaskClickedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                selfJ.@com.smartgwt.client.core.BaseClass::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                selfJ.@com.smartgwt.client.tools.EditContext::handleTearDownEditMaskClickedEvent()();
            });
        if(this.@com.smartgwt.client.core.BaseClass::isCreated()()) {
            obj = this.@com.smartgwt.client.core.BaseClass::getJsObj()();
            obj.addProperties({editMaskClicked:  editMaskClicked              });
        } else {
            obj = this.@com.smartgwt.client.core.BaseClass::getConfig()();
            obj.editMaskClicked =  editMaskClicked             ;
        }
    }-*/;

    private void handleTearDownEditMaskClickedEvent() {
        if (getHandlerCount(com.smartgwt.client.tools.EditMaskClickedEvent.getType()) == 0) tearDownEditMaskClickedEvent();
    }

    private native void tearDownEditMaskClickedEvent() /*-{
        var obj;
        if(this.@com.smartgwt.client.core.BaseClass::isCreated()()) {
            obj = this.@com.smartgwt.client.core.BaseClass::getJsObj()();
        } else {
            obj = this.@com.smartgwt.client.core.BaseClass::getConfig()();
        }
        if (obj && obj.hasOwnProperty("editMaskClicked")) delete obj.editMaskClicked;
    }-*/;

    /**
     * Add a editNodeUpdated handler.
     * <p>
     * Fires whenever editNode.defaults are modified by setNodeProperties() and/or editProxy features
     *
     * @param handler the editNodeUpdated handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addEditNodeUpdatedHandler(com.smartgwt.client.tools.EditNodeUpdatedHandler handler) {
        if(getHandlerCount(com.smartgwt.client.tools.EditNodeUpdatedEvent.getType()) == 0) setupEditNodeUpdatedEvent();
        return doAddHandler(handler, com.smartgwt.client.tools.EditNodeUpdatedEvent.getType());
    }

    private native void setupEditNodeUpdatedEvent() /*-{
        var obj;
        var selfJ = this;
        var editNodeUpdated = $entry(function(){
            var param = {"_this": this, "editNode" : arguments[0], "editContext" : arguments[1], "modifiedProperties" : arguments[2]};
                var event = @com.smartgwt.client.tools.EditNodeUpdatedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                selfJ.@com.smartgwt.client.core.BaseClass::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                selfJ.@com.smartgwt.client.tools.EditContext::handleTearDownEditNodeUpdatedEvent()();
            });
        if(this.@com.smartgwt.client.core.BaseClass::isCreated()()) {
            obj = this.@com.smartgwt.client.core.BaseClass::getJsObj()();
            obj.addProperties({editNodeUpdated:  editNodeUpdated              });
        } else {
            obj = this.@com.smartgwt.client.core.BaseClass::getConfig()();
            obj.editNodeUpdated =  editNodeUpdated             ;
        }
    }-*/;

    private void handleTearDownEditNodeUpdatedEvent() {
        if (getHandlerCount(com.smartgwt.client.tools.EditNodeUpdatedEvent.getType()) == 0) tearDownEditNodeUpdatedEvent();
    }

    private native void tearDownEditNodeUpdatedEvent() /*-{
        var obj;
        if(this.@com.smartgwt.client.core.BaseClass::isCreated()()) {
            obj = this.@com.smartgwt.client.core.BaseClass::getJsObj()();
        } else {
            obj = this.@com.smartgwt.client.core.BaseClass::getConfig()();
        }
        if (obj && obj.hasOwnProperty("editNodeUpdated")) delete obj.editNodeUpdated;
    }-*/;

	/**
     * Enable edit mode for an {@link com.smartgwt.client.tools.EditNode}. This is a shortcut for calling {@link
     * com.smartgwt.client.widgets.Canvas#setEditMode Canvas.setEditMode()}.
     * @param editNode the EditNode on which to enable editing
     * @see com.smartgwt.client.widgets.Canvas#setEditMode
     * @see com.smartgwt.client.tools.EditContext#isNodeEditingOn
     */
    public native void enableEditing(EditNode editNode) /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "enableEditing", "EditNode");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.enableEditing(editNode.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;

	/**
     * Gets the tree of editNodes being edited by this editContext. Standard tree traversal methods can then be used to locate
     * desired editNodes for interaction. <P> <B>Note: the returned tree is read-only and must only be modified by calling
     * methods on EditContext like {@link com.smartgwt.client.tools.EditContext#addNode addNode()} or {@link
     * com.smartgwt.client.tools.EditContext#setNodeProperties setNodeProperties()}.</B>
     *
     * @return the tree of EditNodes
     */
    public native Tree getEditNodeTree() /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getEditNodeTree", "");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.getEditNodeTree();
        if(ret == null) return null;
        return @com.smartgwt.client.widgets.tree.Tree::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
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
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getPaletteNodesFromJS", "String,PaletteNodeCallback");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
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
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getPaletteNodesFromJS", "String,PaletteNodeCallback,String[]");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
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
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getPaletteNodesFromXML", "String,PaletteNodeCallback");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.getPaletteNodesFromXML(xmlString, 
			$entry( function(paletteNodes) { 
				if(callback!=null) callback.@com.smartgwt.client.callbacks.PaletteNodeCallback::execute([Lcom/smartgwt/client/tools/PaletteNode;)(@com.smartgwt.client.util.ConvertTo::arrayOfPaletteNode(Lcom/google/gwt/core/client/JavaScriptObject;)(paletteNodes)
				);
			}));
    }-*/;

	/**
     * Returns the root {@link com.smartgwt.client.tools.EditNode} of the EditContext typically created from {@link
     * com.smartgwt.client.tools.EditContext#getRootComponent rootComponent}.
     *
     * @return the root EditNode
     */
    public native EditNode getRootEditNode() /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getRootEditNode", "");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.getRootEditNode();
        if(ret == null) return null;
        return @com.smartgwt.client.tools.EditNode::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

	/**
     * Returns selected EditNode or first selected EditNode if multiple nodes are selected.
     *
     * @return the selected or first edit node
     */
    public native EditNode getSelectedEditNode() /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getSelectedEditNode", "");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.getSelectedEditNode();
        if(ret == null) return null;
        return @com.smartgwt.client.tools.EditNode::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

	/**
     * Returns all selected EditNodes as an Array.
     *
     * @return the selected edit nodes
     */
    public native EditNode[] getSelectedEditNodes() /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getSelectedEditNodes", "");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.getSelectedEditNodes();
        if(ret == null) return null;
        return @com.smartgwt.client.util.ConvertTo::arrayOfEditNode(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

	/**
     * Returns true if the editNode is selected.
     *
     * @return true if editNode is selected; false otherwise
     */
    public native boolean isEditNodeSelected() /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "isEditNodeSelected", "");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.isEditNodeSelected();
        return ret == null ? false : ret;
    }-*/;

	/**
     * Returns true if <code>editNode</code> is in edit mode.
     * @param editNode the EditNode
     *
     * @return true if node is in edit mode
     */
    public native boolean isNodeEditingOn(EditNode editNode) /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "isNodeEditingOn", "EditNode");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.isNodeEditingOn(editNode.@com.smartgwt.client.core.DataClass::getJsObj()());
        return ret == null ? false : ret;
    }-*/;

	/**
     * Creates and returns an EditNode using the {@link com.smartgwt.client.tools.EditContext#getDefaultPalette
     * defaultPalette}.  Does not add the newly created EditNode to an EditContext.
     * @param paletteNode the palette node to use to create the new node
     *
     * @return the EditNode created from the paletteNode
     */
    public native EditNode makeEditNode(PaletteNode paletteNode) /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "makeEditNode", "PaletteNode");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.makeEditNode(paletteNode.@com.smartgwt.client.core.DataClass::getJsObj()());
        if(ret == null) return null;
        return @com.smartgwt.client.tools.EditNode::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

	/**
     * Creates a {@link com.smartgwt.client.tools.PaletteNode} from an {@link com.smartgwt.client.tools.EditNode} in this
     * context's {@link com.smartgwt.client.tools.EditContext#getEditNodeTree editNodeTree}. <p> This essentially creates a new
     * {@link com.smartgwt.client.tools.PaletteNode} with the {@link com.smartgwt.client.tools.EditNode#getDefaults
     * EditNode.defaults} from the passed <code>editNode</code>.  The returned <code>paletteNode</code> could then be used with
     * {@link com.smartgwt.client.tools.EditContext#addFromPaletteNode addFromPaletteNode()} to effectively create a copy of
     * the original editNode - specifically a new editNode with a new {@link com.smartgwt.client.tools.EditNode#getLiveObject
     * EditNode.liveObject} created from the same defaults. <p> However note that <code>makePaletteNode()</code> does not copy
     * descendant nodes - use {@link com.smartgwt.client.tools.EditContext#makePaletteNodeTree makePaletteNodeTree()} for that.
     * <p> May return null if the passed editNode cannot validly by transformed into a paletteNode, for example if {@link
     * com.smartgwt.client.tools.EditNode#getCanDuplicate EditNode.canDuplicate} was set false.
     * @param editNode the editNode to use to make a paletteNode
     *
     * @return paletteNode derived from the editNode or null
     */
    public native PaletteNode makePaletteNode(EditNode editNode) /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "makePaletteNode", "EditNode");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.makePaletteNode(editNode.@com.smartgwt.client.core.DataClass::getJsObj()());
        if(ret == null) return null;
        return @com.smartgwt.client.tools.PaletteNode::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

	/**
     * Creates a {@link com.smartgwt.client.widgets.tree.Tree} of {@link com.smartgwt.client.tools.PaletteNode PaletteNodes}
     * from an {@link com.smartgwt.client.tools.EditNode} in this context's {@link
     * com.smartgwt.client.tools.EditContext#getEditNodeTree editNodeTree}, by using {@link
     * com.smartgwt.client.tools.EditContext#makePaletteNode makePaletteNode()} on the passed <code>EditNode</code> and its
     * descendents within the {@link com.smartgwt.client.tools.EditContext#getEditNodeTree editNodeTree}. <p> The root node of
     * the returned {@link com.smartgwt.client.widgets.tree.Tree} will be a PaletteNode derived from the passed
     * <code>EditNode</code>.
     * @param editNode root editNode to make Tree of PaletteNodes from
     *
     * @return a Tree of paletteNodes or null
     */
    public native Tree makePaletteNodeTree(EditNode editNode) /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "makePaletteNodeTree", "EditNode");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.makePaletteNodeTree(editNode.@com.smartgwt.client.core.DataClass::getJsObj()());
        if(ret == null) return null;
        return @com.smartgwt.client.widgets.tree.Tree::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

    /**
     * Add a nodeAdded handler.
     * <p>
     * Notification fired when an {@link com.smartgwt.client.tools.EditNode} has been added to the EditContext
     *
     * @param handler the nodeAdded handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addNodeAddedHandler(com.smartgwt.client.tools.NodeAddedHandler handler) {
        if(getHandlerCount(com.smartgwt.client.tools.NodeAddedEvent.getType()) == 0) setupNodeAddedEvent();
        return doAddHandler(handler, com.smartgwt.client.tools.NodeAddedEvent.getType());
    }

    private native void setupNodeAddedEvent() /*-{
        var obj;
        var selfJ = this;
        var nodeAdded = $entry(function(){
            var param = {"_this": this, "newNode" : arguments[0], "parentNode" : arguments[1], "rootNode" : arguments[2]};
                var event = @com.smartgwt.client.tools.NodeAddedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                selfJ.@com.smartgwt.client.core.BaseClass::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                selfJ.@com.smartgwt.client.tools.EditContext::handleTearDownNodeAddedEvent()();
            });
        if(this.@com.smartgwt.client.core.BaseClass::isCreated()()) {
            obj = this.@com.smartgwt.client.core.BaseClass::getJsObj()();
            obj.addProperties({nodeAdded:  nodeAdded              });
        } else {
            obj = this.@com.smartgwt.client.core.BaseClass::getConfig()();
            obj.nodeAdded =  nodeAdded             ;
        }
    }-*/;

    private void handleTearDownNodeAddedEvent() {
        if (getHandlerCount(com.smartgwt.client.tools.NodeAddedEvent.getType()) == 0) tearDownNodeAddedEvent();
    }

    private native void tearDownNodeAddedEvent() /*-{
        var obj;
        if(this.@com.smartgwt.client.core.BaseClass::isCreated()()) {
            obj = this.@com.smartgwt.client.core.BaseClass::getJsObj()();
        } else {
            obj = this.@com.smartgwt.client.core.BaseClass::getConfig()();
        }
        if (obj && obj.hasOwnProperty("nodeAdded")) delete obj.nodeAdded;
    }-*/;

	/**
     * Notification fired when an {@link com.smartgwt.client.tools.EditNode} has been moved to a new position in the component
     * tree.
     * @param oldNode node that was removed
     * @param oldParentNode parent node of the node that was removed
     * @param newNode node that was added
     * @param newParentNode parent node of the node that was added
     * @param rootNode root node of the edit context
     */
    public native void nodeMoved(EditNode oldNode, EditNode oldParentNode, EditNode newNode, EditNode newParentNode, EditNode rootNode) /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "nodeMoved", "EditNode,EditNode,EditNode,EditNode,EditNode");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.nodeMoved(oldNode.@com.smartgwt.client.core.DataClass::getJsObj()(), oldParentNode.@com.smartgwt.client.core.DataClass::getJsObj()(), newNode.@com.smartgwt.client.core.DataClass::getJsObj()(), newParentNode.@com.smartgwt.client.core.DataClass::getJsObj()(), rootNode.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;

	/**
     * Notification fired when an {@link com.smartgwt.client.tools.EditNode} has been removed from the EditContext
     * @param removedNode node that was removed
     * @param parentNode parent node of the node that was removed
     * @param rootNode root node of the edit context
     */
    public native void nodeRemoved(EditNode removedNode, EditNode parentNode, EditNode rootNode) /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "nodeRemoved", "EditNode,EditNode,EditNode");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.nodeRemoved(removedNode.@com.smartgwt.client.core.DataClass::getJsObj()(), parentNode.@com.smartgwt.client.core.DataClass::getJsObj()(), rootNode.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;

	/**
     * "Pastes" <code>editNodes</code> previously captured via {@link com.smartgwt.client.tools.EditContext#copyEditNodes
     * copyEditNodes()}. <p> New editNodes will be added as root-level nodes of the {@link
     * com.smartgwt.client.tools.EditContext#getEditNodeTree editNodeTree} unless a <code>targetEditNode</code> is passed.
     */
    public native void pasteEditNodes() /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "pasteEditNodes", "");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.pasteEditNodes();
    }-*/;

	/**
     * "Pastes" <code>editNodes</code> previously captured via {@link com.smartgwt.client.tools.EditContext#copyEditNodes
     * copyEditNodes()}. <p> New editNodes will be added as root-level nodes of the {@link
     * com.smartgwt.client.tools.EditContext#getEditNodeTree editNodeTree} unless a <code>targetEditNode</code> is passed.
     * @param targetEditNode 
     */
    public native void pasteEditNodes(EditNode targetEditNode) /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "pasteEditNodes", "EditNode");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.pasteEditNodes(targetEditNode == null ? null : targetEditNode.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;
	
	/**
     * Removes all {@link com.smartgwt.client.tools.EditNode EditNodes} from the EditContext, but does not destroy  the {@link
     * com.smartgwt.client.tools.EditNode#getLiveObject liveObjects}.
     */
    public native void removeAll() /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "removeAll", "");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.removeAll();
    }-*/;

	/**
     * Removes {@link com.smartgwt.client.tools.EditNode EditNode} from the EditContext. The editNode liveObject is not
     * destroyed.
     * @param editNode node to be removed
     */
    public native void removeNode(EditNode editNode) /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "removeNode", "EditNode");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.removeNode(editNode.@com.smartgwt.client.core.DataClass::getJsObj()());
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
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "removeNodeProperties", "EditNode,String[]");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.removeNodeProperties(editNode.@com.smartgwt.client.core.DataClass::getJsObj()(), @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(properties));
    }-*/;

	/**
     * Select all EditNodes.
     */
    public native void selectAllEditNodes() /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "selectAllEditNodes", "");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.selectAllEditNodes();
    }-*/;

    /**
     * Add a selectedEditNodesUpdated handler.
     * <p>
     * Called when editMode selection changes. Note this method fires exactly once for any given change. <P> This event is
     * fired once after selection/deselection has completed. The result is one event per mouse-down event. For a drag selection
     * there will be one event fired when the range is completed.
     *
     * @param handler the selectedEditNodesUpdated handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addSelectedEditNodesUpdatedHandler(com.smartgwt.client.tools.SelectedEditNodesUpdatedHandler handler) {
        if(getHandlerCount(com.smartgwt.client.tools.SelectedEditNodesUpdatedEvent.getType()) == 0) setupSelectedEditNodesUpdatedEvent();
        return doAddHandler(handler, com.smartgwt.client.tools.SelectedEditNodesUpdatedEvent.getType());
    }

    private native void setupSelectedEditNodesUpdatedEvent() /*-{
        var obj;
        var selfJ = this;
        var selectedEditNodesUpdated = $entry(function(){
            var param = {"_this": this, "editNode" : arguments[0], "editNodeList" : arguments[1]};
                var event = @com.smartgwt.client.tools.SelectedEditNodesUpdatedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                selfJ.@com.smartgwt.client.core.BaseClass::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                selfJ.@com.smartgwt.client.tools.EditContext::handleTearDownSelectedEditNodesUpdatedEvent()();
            });
        if(this.@com.smartgwt.client.core.BaseClass::isCreated()()) {
            obj = this.@com.smartgwt.client.core.BaseClass::getJsObj()();
            obj.addProperties({selectedEditNodesUpdated:  selectedEditNodesUpdated              });
        } else {
            obj = this.@com.smartgwt.client.core.BaseClass::getConfig()();
            obj.selectedEditNodesUpdated =  selectedEditNodesUpdated             ;
        }
    }-*/;

    private void handleTearDownSelectedEditNodesUpdatedEvent() {
        if (getHandlerCount(com.smartgwt.client.tools.SelectedEditNodesUpdatedEvent.getType()) == 0) tearDownSelectedEditNodesUpdatedEvent();
    }

    private native void tearDownSelectedEditNodesUpdatedEvent() /*-{
        var obj;
        if(this.@com.smartgwt.client.core.BaseClass::isCreated()()) {
            obj = this.@com.smartgwt.client.core.BaseClass::getJsObj()();
        } else {
            obj = this.@com.smartgwt.client.core.BaseClass::getConfig()();
        }
        if (obj && obj.hasOwnProperty("selectedEditNodesUpdated")) delete obj.selectedEditNodesUpdated;
    }-*/;

	/**
     * Select an EditNode.
     * @param editNode editNode to select
     */
    public native void selectEditNode(EditNode editNode) /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "selectEditNode", "EditNode");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.selectEditNode(editNode.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;

	/**
     * Select a single EditNode and deselect everything else.
     * @param editNode editNode to select
     */
    public native void selectSingleEditNode(EditNode editNode) /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "selectSingleEditNode", "EditNode");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.selectSingleEditNode(editNode.@com.smartgwt.client.core.DataClass::getJsObj()());
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
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "serializeAllEditNodes", "");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.serializeAllEditNodes();
        return ret;
    }-*/;

	/**
     * Serialize the tree of {@link com.smartgwt.client.tools.EditNode EditNodes} to an XML representation of {@link
     * com.smartgwt.client.tools.PaletteNode PaletteNodes}. The result can be supplied to  {@link
     * com.smartgwt.client.tools.EditContext#addPaletteNodesFromXML addPaletteNodesFromXML()} to recreate the EditNodes.
     * @param settings Additional serialization settings
     *
     * @return an XML representation of PaletteNodes which can be used to                  recreate the tree of EditNodes.
     * @see com.smartgwt.client.tools.EditContext#addPaletteNodesFromXML
     */
    public native String serializeAllEditNodes(SerializationSettings settings) /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "serializeAllEditNodes", "SerializationSettings");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.serializeAllEditNodes(settings == null ? null : settings.@com.smartgwt.client.core.DataClass::getJsObj()());
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
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "serializeAllEditNodesAsJSON", "");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.serializeAllEditNodesAsJSON();
        return ret;
    }-*/;

	/**
     * Encode the tree of {@link com.smartgwt.client.tools.EditNode EditNodes} to a JSON representation of {@link
     * com.smartgwt.client.tools.PaletteNode PaletteNodes}. The result can be supplied to  {@link
     * com.smartgwt.client.tools.EditContext#addPaletteNodesFromJSON addPaletteNodesFromJSON()} to recreate the EditNodes.
     * @param settings Additional serialization settings
     *
     * @return a JSON representation of PaletteNodes which can be used to                  recreate the tree of EditNodes.
     * @see com.smartgwt.client.tools.EditContext#addPaletteNodesFromJSON
     */
    public native String serializeAllEditNodesAsJSON(SerializationSettings settings) /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "serializeAllEditNodesAsJSON", "SerializationSettings");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.serializeAllEditNodesAsJSON(settings == null ? null : settings.@com.smartgwt.client.core.DataClass::getJsObj()());
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
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "serializeEditNodes", "EditNode[]");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.serializeEditNodes(@com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(nodes));
        return ret;
    }-*/;

	/**
     * Serialize the provided {@link com.smartgwt.client.tools.EditNode EditNodes} to an XML representation of {@link
     * com.smartgwt.client.tools.PaletteNode PaletteNodes}. Note that the EditNodes must have been added to this EditContext.
     * The result can be supplied to {@link com.smartgwt.client.tools.EditContext#addPaletteNodesFromXML
     * addPaletteNodesFromXML()} to recreate the EditNodes.
     * @param nodes EditNodes to be serialized
     * @param settings Additional serialization settings
     *
     * @return an XML representtion of the provided EditNodes
     */
    public native String serializeEditNodes(EditNode[] nodes, SerializationSettings settings) /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "serializeEditNodes", "EditNode[],SerializationSettings");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.serializeEditNodes(@com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(nodes), settings == null ? null : settings.@com.smartgwt.client.core.DataClass::getJsObj()());
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
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "serializeEditNodesAsJSON", "EditNode[]");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.serializeEditNodesAsJSON(@com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(nodes));
        return ret;
    }-*/;

	/**
     * Serialize the provided {@link com.smartgwt.client.tools.EditNode EditNodes} to a JSON representation of {@link
     * com.smartgwt.client.tools.PaletteNode PaletteNodes}. Note that the EditNodes must have been added to this EditContext.
     * The result can be supplied to {@link com.smartgwt.client.tools.EditContext#addPaletteNodesFromJSON
     * addPaletteNodesFromJSON()} to recreate the EditNodes.
     * @param nodes EditNodes to be serialized
     * @param settings Additional serialization settings
     *
     * @return a JSON representtion of the provided EditNodes
     */
    public native String serializeEditNodesAsJSON(EditNode[] nodes, SerializationSettings settings) /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "serializeEditNodesAsJSON", "EditNode[],SerializationSettings");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.serializeEditNodesAsJSON(@com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(nodes), settings == null ? null : settings.@com.smartgwt.client.core.DataClass::getJsObj()());
        return ret;
    }-*/;
	
	/**
     * Update an editNode's {@link com.smartgwt.client.tools.EditProxy} properties. If editProxy has not yet been created,
     * <code>editProxyProperties</code> is updated or created instead.
     * @param editNode the editNode to update
     * @param properties the properties to apply
     */
    public native void setEditProxyProperties(EditNode editNode, EditProxy properties) /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "setEditProxyProperties", "EditNode,EditProxy");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        if (properties != null) {
            if (properties.@com.smartgwt.client.core.BaseClass::isCreated()()) {
                @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "setEditProxyProperties", "EditProxy");
            }
            properties.@com.smartgwt.client.core.BaseClass::setConfigOnly(Z)(true);
        }
        self.setEditProxyProperties(editNode.@com.smartgwt.client.core.DataClass::getJsObj()(),
			properties == null ? null : @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(properties.@com.smartgwt.client.core.BaseClass::getConfig()(),true));
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
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "setNodeProperties", "EditNode,Canvas");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        if (properties != null) {
            if (properties.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
                @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "setNodeProperties", "Canvas");
            }
            properties.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
        }
        self.setNodeProperties(editNode.@com.smartgwt.client.core.DataClass::getJsObj()(),
			properties == null ? null : @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(properties.@com.smartgwt.client.widgets.BaseWidget::getConfig()(),true));
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
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "setNodeProperties", "EditNode,Canvas,Boolean");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        if (properties != null) {
            if (properties.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
                @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "setNodeProperties", "Canvas");
            }
            properties.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
        }
        self.setNodeProperties(editNode.@com.smartgwt.client.core.DataClass::getJsObj()(),
			properties == null ? null : @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(properties.@com.smartgwt.client.widgets.BaseWidget::getConfig()(),true),
			skipLiveObjectUpdate == null ? null : skipLiveObjectUpdate.@java.lang.Boolean::booleanValue()());
    }-*/;
	

    // ********************* Static Methods ***********************

    // ***********************************************************


    /**
     * Update an editNode's serializable "defaults" with the supplied properties. If you wish
     * to remove a property from the defaults (rather than setting it to null), then use 
     * {@link com.smartgwt.client.tools.EditContext#removeNodeProperties removeNodeProperties()}
     * instead.
     * @param editNode the editNode to update
     * @param properties the properties to apply
     * @see com.smartgwt.client.tools.EditContext#removeNodeProperties
     */
    public void setNodeProperties(EditNode editNode, DrawItem properties) 
        throws IllegalStateException 
    {
        if (properties.isCreated()) {
            ConfigUtil.warnOfPreConfigInstantiation(this.getClass(), "setNodeProperties",
                                                    properties.getClass());
        }
        properties.setConfigOnly(true);

        JavaScriptObject rawProperties = JSOHelper.cleanProperties(properties.getConfig(), true);
        this.setNodeProperties(editNode, rawProperties);
    }


    /**
     * Update an editNode's serializable "defaults" with the supplied properties. If you wish
     * to remove a property from the defaults (rather than setting it to null), then use 
     * {@link com.smartgwt.client.tools.EditContext#removeNodeProperties removeNodeProperties()}
     * instead.
     * @param editNode the editNode to update
     * @param properties the properties to apply
     * @param skipLiveObjectUpdate whether to skip updating the 
     *     {@link com.smartgwt.client.tools.EditNode#getLiveObject liveObject}, 
     *     e.g. if you have already updated the liveObject
     * @see com.smartgwt.client.tools.EditContext#removeNodeProperties
     */
    public void setNodeProperties(EditNode editNode, DrawItem properties, 
                                  Boolean skipLiveObjectUpdate) 
        throws IllegalStateException 
    {
        if (properties.isCreated()) {
            ConfigUtil.warnOfPreConfigInstantiation(this.getClass(), "setNodeProperties",
                                                    properties.getClass());
        }
        properties.setConfigOnly(true);

        JavaScriptObject rawProperties = JSOHelper.cleanProperties(properties.getConfig(), true);
        this.setNodeProperties(editNode, rawProperties, skipLiveObjectUpdate);
    }


    protected native void setNodeProperties(EditNode editNode, JavaScriptObject properties) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.setNodeProperties(editNode.@com.smartgwt.client.core.DataClass::getJsObj()(), properties);
    }-*/;

    protected native void setNodeProperties(EditNode editNode, JavaScriptObject properties, Boolean skipLiveObjectUpdate) /*-{
	    var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
	    self.setNodeProperties(editNode.@com.smartgwt.client.core.DataClass::getJsObj()(), properties, skipLiveObjectUpdate == null ? null : skipLiveObjectUpdate.@java.lang.Boolean::booleanValue()());
	}-*/;

}
