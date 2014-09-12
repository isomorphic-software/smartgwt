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
 * An EditContext provides an editing environment for a set of components. <P> An EditContext is typically populated by
 * adding a series of {@link com.smartgwt.client.tools.EditNode EditNodes} created via a {@link
 * com.smartgwt.client.tools.Palette}, either via drag and drop creation, or when loading from a saved version, via {@link
 * com.smartgwt.client.tools.EditContext#addFromPaletteNode addFromPaletteNode()} or  {@link
 * com.smartgwt.client.tools.EditContext#addPaletteNodesFromXML addPaletteNodesFromXML()}. <P> An EditContext then provides
 * interfaces for further editing of the components represented by EditNodes. <P> An EditContext is initialized by setting
 * {@link com.smartgwt.client.tools.EditContext#getRootComponent rootComponent}.
 * @see com.smartgwt.client.docs.DevTools DevTools overview and related methods
 */
@BeanFactory.FrameworkClass
@BeanFactory.ScClassName("EditContext")
public class EditContext extends BaseClass implements com.smartgwt.client.tools.HasNodeAddedHandlers, com.smartgwt.client.tools.HasSelectedEditNodesUpdatedHandlers {

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
     * Can components be dropped into other components which support nesting? This mode is enabled unless explicitly disabled.
     *
     * @param allowNestedDrops  Default value is null
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setAllowNestedDrops(Boolean allowNestedDrops)  throws IllegalStateException {
        setAttribute("allowNestedDrops", allowNestedDrops, false);
    }

    /**
     * Can components be dropped into other components which support nesting? This mode is enabled unless explicitly disabled.
     *
     * @return Boolean
     */
    public Boolean getAllowNestedDrops()  {
        return getAttributeAsBoolean("allowNestedDrops");
    }
    

    /**
     * New nodes added to the editContext are automatically placed into edit mode if the new node's parent is in edit mode. To
     * suppress this action set <code>autoEditNewNodes</code> to false.
     *
     * @param autoEditNewNodes  Default value is null
     */
    public void setAutoEditNewNodes(Boolean autoEditNewNodes) {
        setAttribute("autoEditNewNodes", autoEditNewNodes, true);
    }

    /**
     * New nodes added to the editContext are automatically placed into edit mode if the new node's parent is in edit mode. To
     * suppress this action set <code>autoEditNewNodes</code> to false.
     *
     * @return Boolean
     */
    public Boolean getAutoEditNewNodes()  {
        return getAttributeAsBoolean("autoEditNewNodes");
    }
    

    /**
     * Should the group selection box shown when {@link com.smartgwt.client.tools.EditContext#getCanGroupSelect canGroupSelect}
     * is true allow dragging the group as a whole? <P> Treated as <code>true</code> if not set and {@link
     * com.smartgwt.client.tools.EditContext#getCanGroupSelect canGroupSelect} is true.
     *
     * @param canDragGroup  Default value is null
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setCanDragGroup(Boolean canDragGroup)  throws IllegalStateException {
        setAttribute("canDragGroup", canDragGroup, false);
    }

    /**
     * Should the group selection box shown when {@link com.smartgwt.client.tools.EditContext#getCanGroupSelect canGroupSelect}
     * is true allow dragging the group as a whole? <P> Treated as <code>true</code> if not set and {@link
     * com.smartgwt.client.tools.EditContext#getCanGroupSelect canGroupSelect} is true.
     *
     * @return Boolean
     */
    public Boolean getCanDragGroup()  {
        return getAttributeAsBoolean("canDragGroup");
    }
    

    /**
     * Should a group selection outline covering the outermost bounding boxes of all selected components be shown in this
     * container? <P> Treated as <code>true</code> if not set and hoop selection is enabled (see {@link
     * com.smartgwt.client.tools.EditProxy#getCanSelectChildren canSelectChildren} and {@link
     * com.smartgwt.client.tools.EditContext#getSelectionType selectionType}.
     *
     * @param canGroupSelect  Default value is null
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setCanGroupSelect(Boolean canGroupSelect)  throws IllegalStateException {
        setAttribute("canGroupSelect", canGroupSelect, false);
    }

    /**
     * Should a group selection outline covering the outermost bounding boxes of all selected components be shown in this
     * container? <P> Treated as <code>true</code> if not set and hoop selection is enabled (see {@link
     * com.smartgwt.client.tools.EditProxy#getCanSelectChildren canSelectChildren} and {@link
     * com.smartgwt.client.tools.EditContext#getSelectionType selectionType}.
     *
     * @return Boolean
     */
    public Boolean getCanGroupSelect()  {
        return getAttributeAsBoolean("canGroupSelect");
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
     * The default parent {@link com.smartgwt.client.tools.EditNode} to be used when a new EditNode is added to the EditContext
     * without a specified parent. This commonly occurs when a paletteNode is double-clicked in a palette. <p> If not
     * specified, the root editNode (see {@link com.smartgwt.client.tools.EditContext#getRootEditNode
     * EditContext.getRootEditNode}) is used. <p> Note: this property is automatically cleared if node is removed from the
     * editTree such as on calls to {@link com.smartgwt.client.tools.EditContext#destroyAll EditContext.destroyAll} or {@link
     * com.smartgwt.client.tools.EditContext#removeNode EditContext.removeNode}.
     *
     * @param defaultParent  Default value is null
     */
    public void setDefaultParent(EditNode defaultParent) {
        setAttribute("defaultParent", defaultParent.getJsObj(), true);
    }

    /**
     * The default parent {@link com.smartgwt.client.tools.EditNode} to be used when a new EditNode is added to the EditContext
     * without a specified parent. This commonly occurs when a paletteNode is double-clicked in a palette. <p> If not
     * specified, the root editNode (see {@link com.smartgwt.client.tools.EditContext#getRootEditNode
     * EditContext.getRootEditNode}) is used. <p> Note: this property is automatically cleared if node is removed from the
     * editTree such as on calls to {@link com.smartgwt.client.tools.EditContext#destroyAll EditContext.destroyAll} or {@link
     * com.smartgwt.client.tools.EditContext#removeNode EditContext.removeNode}.
     *
     * @return EditNode
     */
    public EditNode getDefaultParent()  {
        return new EditNode(getAttributeAsJavaScriptObject("defaultParent"));
    }
    

    /**
     * Properties to apply to all {@link com.smartgwt.client.tools.EditProxy#getEditMask editMask}s created for components  in
     * edit mode. This mask can be modified when the node is selected by {@link
     * com.smartgwt.client.tools.EditContext#getSelectedBorder selectedBorder}, {@link
     * com.smartgwt.client.tools.EditContext#getSelectedTintColor selectedTintColor} and {@link
     * com.smartgwt.client.tools.EditContext#getSelectedTintOpacity selectedTintOpacity} depending on the {@link
     * com.smartgwt.client.tools.EditContext#getSelectedAppearance selectedAppearance} setting.
     *
     * @param editMaskProperties  Default value is null
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setEditMaskProperties(Map editMaskProperties)  throws IllegalStateException {
        setAttribute("editMaskProperties", editMaskProperties, false);
    }

    /**
     * Properties to apply to all {@link com.smartgwt.client.tools.EditProxy#getEditMask editMask}s created for components  in
     * edit mode. This mask can be modified when the node is selected by {@link
     * com.smartgwt.client.tools.EditContext#getSelectedBorder selectedBorder}, {@link
     * com.smartgwt.client.tools.EditContext#getSelectedTintColor selectedTintColor} and {@link
     * com.smartgwt.client.tools.EditContext#getSelectedTintOpacity selectedTintOpacity} depending on the {@link
     * com.smartgwt.client.tools.EditContext#getSelectedAppearance selectedAppearance} setting.
     *
     * @return Map
     */
    public Map getEditMaskProperties()  {
        return getAttributeAsMap("editMaskProperties");
    }
    

    /**
     * Whether inline editing should be enabled for any components that are added and are placed into editMode.  Enabling this
     * will turn on inline edit for any EditProxy where {@link com.smartgwt.client.tools.EditProxy#getSupportsInlineEdit
     * supportsInlineEdit} is true.
     *
     * @param enableInlineEdit  Default value is null
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setEnableInlineEdit(Boolean enableInlineEdit)  throws IllegalStateException {
        setAttribute("enableInlineEdit", enableInlineEdit, false);
    }

    /**
     * Whether inline editing should be enabled for any components that are added and are placed into editMode.  Enabling this
     * will turn on inline edit for any EditProxy where {@link com.smartgwt.client.tools.EditProxy#getSupportsInlineEdit
     * supportsInlineEdit} is true.
     *
     * @return Boolean
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
     * Should the group selection box shown when {@link com.smartgwt.client.tools.EditContext#getCanGroupSelect canGroupSelect}
     * is true be hidden during drag? <P> Treated as <code>true</code> if not explicitly set to false.
     *
     * @param hideGroupBorderOnDrag  Default value is null
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setHideGroupBorderOnDrag(Boolean hideGroupBorderOnDrag)  throws IllegalStateException {
        setAttribute("hideGroupBorderOnDrag", hideGroupBorderOnDrag, false);
    }

    /**
     * Should the group selection box shown when {@link com.smartgwt.client.tools.EditContext#getCanGroupSelect canGroupSelect}
     * is true be hidden during drag? <P> Treated as <code>true</code> if not explicitly set to false.
     *
     * @return Boolean
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
     * @param hoopSelectionMode  Default value is "encloses"
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     * @see com.smartgwt.client.types.HoopSelectionStyle
     */
    public void setHoopSelectionMode(HoopSelectionStyle hoopSelectionMode)  throws IllegalStateException {
        setAttribute("hoopSelectionMode", hoopSelectionMode == null ? null : hoopSelectionMode.getValue(), false);
    }

    /**
     * Defines the mode of inclusion for components encountered during hoop selection which is enabled when {@link
     * com.smartgwt.client.tools.EditContext#getSelectionType selectionType} is <code>multiple</code>. <code>encloses</code>
     * mode causes selection of components that are completely enclosed by the hoop. <code>intersects</code> mode selects
     * components that come into contact with the hoop.
     *
     * @return HoopSelectionStyle
     * @see com.smartgwt.client.types.HoopSelectionStyle
     */
    public HoopSelectionStyle getHoopSelectionMode()  {
        return EnumUtil.getEnum(HoopSelectionStyle.values(), getAttribute("hoopSelectionMode"));
    }
    

    /**
     * Properties to apply to {@link com.smartgwt.client.tools.EditProxy#getHoopSelector hoopSelector}.
     *
     * @param hoopSelectorProperties  Default value is null
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setHoopSelectorProperties(Map hoopSelectorProperties)  throws IllegalStateException {
        setAttribute("hoopSelectorProperties", hoopSelectorProperties, false);
    }

    /**
     * Properties to apply to {@link com.smartgwt.client.tools.EditProxy#getHoopSelector hoopSelector}.
     *
     * @return Map
     */
    public Map getHoopSelectorProperties()  {
        return getAttributeAsMap("hoopSelectorProperties");
    }
    

    /**
     * Changes to a {@link com.smartgwt.client.tools.EditNode#getLiveObject liveObject}'s position and size will be persisted
     * to their {@link com.smartgwt.client.tools.EditNode EditNodes} by default. This applies to both programmatic calls and
     * user interaction (drag reposition or drag resize). <p> This feature can be disabled by either setting this property or
     * {@link com.smartgwt.client.tools.EditProxy#getPersistCoordinates persistCoordinates} to <code>false</code>. This
     * property affects all nodes within the EditContext whereas the latter property affects children of a single node.  <p> In
     * some use-cases, like VisualBuilder, coordinates should not be persisted except when a component explicitly enables this
     * feature. By setting this property to <code>null</code> no component will persist coordinates of children unless
     * <code>EditProxy.persistCoordinates</code> is explicitly set to <code>true</code>.
     *
     * @param persistCoordinates  Default value is true
     */
    public void setPersistCoordinates(Boolean persistCoordinates) {
        setAttribute("persistCoordinates", persistCoordinates, true);
    }

    /**
     * Changes to a {@link com.smartgwt.client.tools.EditNode#getLiveObject liveObject}'s position and size will be persisted
     * to their {@link com.smartgwt.client.tools.EditNode EditNodes} by default. This applies to both programmatic calls and
     * user interaction (drag reposition or drag resize). <p> This feature can be disabled by either setting this property or
     * {@link com.smartgwt.client.tools.EditProxy#getPersistCoordinates persistCoordinates} to <code>false</code>. This
     * property affects all nodes within the EditContext whereas the latter property affects children of a single node.  <p> In
     * some use-cases, like VisualBuilder, coordinates should not be persisted except when a component explicitly enables this
     * feature. By setting this property to <code>null</code> no component will persist coordinates of children unless
     * <code>EditProxy.persistCoordinates</code> is explicitly set to <code>true</code>.
     *
     * @return Boolean
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
     * EditContext.getRootEditNode} to retrieve the {@link com.smartgwt.client.tools.EditNode} created from the rootComponent.
     *
     * @param rootComponent  Default value is null
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     * @see com.smartgwt.client.docs.DevTools DevTools overview and related methods
     */
    public void setRootComponent(PaletteNode rootComponent)  throws IllegalStateException {
        setAttribute("rootComponent", rootComponent.getJsObj(), false);
    }

    /**
     * Root of data to edit.  Must contain the "type" property, with the name of a valid {@link
     * com.smartgwt.client.data.DataSource schema} or nothing will be able to be dropped on this EditContext. A "liveObject"
     * property representing the rootComponent is also suggested. Otherwise, a live object will be created from the palette
     * node. <P> Can be retrieved at any time. Use {@link com.smartgwt.client.tools.EditContext#getRootEditNode
     * EditContext.getRootEditNode} to retrieve the {@link com.smartgwt.client.tools.EditNode} created from the rootComponent.
     *
     * @return PaletteNode
     * @see com.smartgwt.client.docs.DevTools DevTools overview and related methods
     */
    public PaletteNode getRootComponent()  {
        return new PaletteNode(getAttributeAsJavaScriptObject("rootComponent"));
    }
    

    /**
     * Appearance that is applied to selected component. <P> This value is applied as a default to {@link
     * com.smartgwt.client.tools.EditProxy#getSelectedAppearance selectedAppearance}.
     *
     * @param selectedAppearance  Default value is null
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     * @see com.smartgwt.client.tools.EditContext#setSelectedBorder
     * @see com.smartgwt.client.tools.EditContext#setSelectedTintColor
     * @see com.smartgwt.client.tools.EditContext#setSelectedTintOpacity
     */
    public void setSelectedAppearance(SelectedAppearance selectedAppearance)  throws IllegalStateException {
        setAttribute("selectedAppearance", selectedAppearance == null ? null : selectedAppearance.getValue(), false);
    }

    /**
     * Appearance that is applied to selected component. <P> This value is applied as a default to {@link
     * com.smartgwt.client.tools.EditProxy#getSelectedAppearance selectedAppearance}.
     *
     * @return SelectedAppearance
     * @see com.smartgwt.client.tools.EditContext#getSelectedBorder
     * @see com.smartgwt.client.tools.EditContext#getSelectedTintColor
     * @see com.smartgwt.client.tools.EditContext#getSelectedTintOpacity
     */
    public SelectedAppearance getSelectedAppearance()  {
        return EnumUtil.getEnum(SelectedAppearance.values(), getAttribute("selectedAppearance"));
    }
    

    /**
     * Set the CSS border to be applied to the selection outline of the selected components. This property is used when {@link
     * com.smartgwt.client.tools.EditProxy#getSelectedAppearance selectedAppearance} is <code>outlineMask</code> or
     * <code>outlineEdges</code>. <P> This value is applied as a default to {@link
     * com.smartgwt.client.tools.EditProxy#getSelectedBorder selectedBorder}.
     *
     * @param selectedBorder  Default value is "1px dashed #44ff44"
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setSelectedBorder(String selectedBorder)  throws IllegalStateException {
        setAttribute("selectedBorder", selectedBorder, false);
    }

    /**
     * Set the CSS border to be applied to the selection outline of the selected components. This property is used when {@link
     * com.smartgwt.client.tools.EditProxy#getSelectedAppearance selectedAppearance} is <code>outlineMask</code> or
     * <code>outlineEdges</code>. <P> This value is applied as a default to {@link
     * com.smartgwt.client.tools.EditProxy#getSelectedBorder selectedBorder}.
     *
     * @return String
     */
    public String getSelectedBorder()  {
        return getAttributeAsString("selectedBorder");
    }
    

    /**
     * The background color for the selection outline label. The default is defined on {@link
     * com.smartgwt.client.tools.SelectionOutline}. <P> This value is applied as a default to {@link
     * com.smartgwt.client.tools.EditProxy#getSelectedLabelBackgroundColor selectedLabelBackgroundColor}. <P> NOTE: A selected
     * component label is only supported when {@link com.smartgwt.client.tools.EditProxy#getSelectedAppearance
     * selectedAppearance} is "outlineEdges".
     *
     * @param selectedLabelBackgroundColor  Default value is null
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     * @see com.smartgwt.client.tools.EditContext#setShowSelectedLabel
     */
    public void setSelectedLabelBackgroundColor(String selectedLabelBackgroundColor)  throws IllegalStateException {
        setAttribute("selectedLabelBackgroundColor", selectedLabelBackgroundColor, false);
    }

    /**
     * The background color for the selection outline label. The default is defined on {@link
     * com.smartgwt.client.tools.SelectionOutline}. <P> This value is applied as a default to {@link
     * com.smartgwt.client.tools.EditProxy#getSelectedLabelBackgroundColor selectedLabelBackgroundColor}. <P> NOTE: A selected
     * component label is only supported when {@link com.smartgwt.client.tools.EditProxy#getSelectedAppearance
     * selectedAppearance} is "outlineEdges".
     *
     * @return String
     * @see com.smartgwt.client.tools.EditContext#getShowSelectedLabel
     */
    public String getSelectedLabelBackgroundColor()  {
        return getAttributeAsString("selectedLabelBackgroundColor");
    }
    

    /**
     * Mask color applied to {@link com.smartgwt.client.tools.EditProxy#getEditMask editMask} of selected component when {@link
     * com.smartgwt.client.tools.EditProxy#getSelectedAppearance selectedAppearance} is "tintMask". <P> This value is applied
     * as a default to {@link com.smartgwt.client.tools.EditProxy#getSelectedTintColor selectedTintColor}.
     *
     * @param selectedTintColor  See {@link com.smartgwt.client.docs.CSSColor CSSColor} . Default value is "#cccccc"
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     * @see com.smartgwt.client.tools.EditContext#setSelectedTintOpacity
     */
    public void setSelectedTintColor(String selectedTintColor)  throws IllegalStateException {
        setAttribute("selectedTintColor", selectedTintColor, false);
    }

    /**
     * Mask color applied to {@link com.smartgwt.client.tools.EditProxy#getEditMask editMask} of selected component when {@link
     * com.smartgwt.client.tools.EditProxy#getSelectedAppearance selectedAppearance} is "tintMask". <P> This value is applied
     * as a default to {@link com.smartgwt.client.tools.EditProxy#getSelectedTintColor selectedTintColor}.
     *
     * @return  See {@link com.smartgwt.client.docs.CSSColor CSSColor} 
     * @see com.smartgwt.client.tools.EditContext#getSelectedTintOpacity
     */
    public String getSelectedTintColor()  {
        return getAttributeAsString("selectedTintColor");
    }
    

    /**
     * Opacity applied to {@link com.smartgwt.client.tools.EditProxy#getEditMask editMask} of selected component when {@link
     * com.smartgwt.client.tools.EditProxy#getSelectedAppearance selectedAppearance} is "tintMask". <P> This value is applied
     * as a default to {@link com.smartgwt.client.tools.EditProxy#getSelectedTintOpacity selectedTintOpacity}.
     *
     * @param selectedTintOpacity  Default value is 25
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     * @see com.smartgwt.client.tools.EditContext#setSelectedTintColor
     */
    public void setSelectedTintOpacity(int selectedTintOpacity)  throws IllegalStateException {
        setAttribute("selectedTintOpacity", selectedTintOpacity, false);
    }

    /**
     * Opacity applied to {@link com.smartgwt.client.tools.EditProxy#getEditMask editMask} of selected component when {@link
     * com.smartgwt.client.tools.EditProxy#getSelectedAppearance selectedAppearance} is "tintMask". <P> This value is applied
     * as a default to {@link com.smartgwt.client.tools.EditProxy#getSelectedTintOpacity selectedTintOpacity}.
     *
     * @return int
     * @see com.smartgwt.client.tools.EditContext#getSelectedTintColor
     */
    public int getSelectedTintOpacity()  {
        return getAttributeAsInt("selectedTintOpacity");
    }
    

    /**
     * Defines selection behavior when in edit mode. Only two styles are supported: "single" and "multiple". Multiple enables
     * hoop selection.
     *
     * @param selectionType  Default value is Selection.MULTIPLE
     * @see com.smartgwt.client.types.SelectionStyle
     */
    public void setSelectionType(SelectionStyle selectionType) {
        setAttribute("selectionType", selectionType == null ? null : selectionType.getValue(), true);
    }

    /**
     * Defines selection behavior when in edit mode. Only two styles are supported: "single" and "multiple". Multiple enables
     * hoop selection.
     *
     * @return SelectionStyle
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
     * selectedAppearance} is "outlineEdges".
     *
     * @param showSelectedLabel  Default value is null
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setShowSelectedLabel(Boolean showSelectedLabel)  throws IllegalStateException {
        setAttribute("showSelectedLabel", showSelectedLabel, false);
    }

    /**
     * Should the selection outline show a label for selected components? A component may also be highlighted with the
     * selection outline and label to indicate the target of a drop. To suppress showing a label at any time set this property
     * to <code>false</code>. <P> To suppress labels during selection but still show them when targeted for a drop, see {@link
     * com.smartgwt.client.tools.EditContext#getShowSelectedLabelOnSelect showSelectedLabelOnSelect}. <P> NOTE: A selected
     * component label is only supported when {@link com.smartgwt.client.tools.EditProxy#getSelectedAppearance
     * selectedAppearance} is "outlineEdges".
     *
     * @return Boolean
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
     * com.smartgwt.client.tools.EditProxy#getSelectedAppearance selectedAppearance} is "outlineEdges".
     *
     * @param showSelectedLabelOnSelect  Default value is null
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setShowSelectedLabelOnSelect(Boolean showSelectedLabelOnSelect)  throws IllegalStateException {
        setAttribute("showSelectedLabelOnSelect", showSelectedLabelOnSelect, false);
    }

    /**
     * Should the selection outline show a label when the component is selected? This property is similar to {@link
     * com.smartgwt.client.tools.EditContext#getShowSelectedLabel showSelectedLabel}. Whereas {@link
     * com.smartgwt.client.tools.EditContext#getShowSelectedLabel showSelectedLabel} controls whether a label is shown at any
     * time, this property allows normal selection to suppress the label but still show a label during the drop process on the
     * target. Leave {@link com.smartgwt.client.tools.EditContext#getShowSelectedLabel showSelectedLabel} unset and set this
     * property to <code>false</code>. <P> NOTE: A selected component label is only supported when {@link
     * com.smartgwt.client.tools.EditProxy#getSelectedAppearance selectedAppearance} is "outlineEdges".
     *
     * @return Boolean
     */
    public Boolean getShowSelectedLabelOnSelect()  {
        return getAttributeAsBoolean("showSelectedLabelOnSelect");
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
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.addNode(newNode.@com.smartgwt.client.core.DataClass::getJsObj()());
        if(ret == null) return null;
        return @com.smartgwt.client.tools.EditNode::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;


    /**
     * @see EditContext#addNode
     */
    public EditNode addNode(EditNode newNode, EditNode parentNode){
        return addNode(newNode, parentNode, (Integer) null, null, null);
    }

    /**
     * @see EditContext#addNode
     */
    public EditNode addNode(EditNode newNode, EditNode parentNode, Integer index){
        return addNode(newNode, parentNode, index, null, null);
    }

    /**
     * @see EditContext#addNode
     */
    public EditNode addNode(EditNode newNode, EditNode parentNode, Integer index, String parentProperty){
        return addNode(newNode, parentNode, index, parentProperty, null);
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
     *
     * @return newNodenode added
     */
    public native EditNode addNode(EditNode newNode, EditNode parentNode, Integer index, String parentProperty, Boolean skipParentComponentAdd) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
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
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
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
     * com.smartgwt.client.tools.EditContext#serializeAllEditNodesAsJSON EditContext.serializeAllEditNodesAsJSON} or {@link
     * com.smartgwt.client.tools.EditContext#serializeEditNodesAsJSON EditContext.serializeEditNodesAsJSON}. <P> By default,
     * components that have {@link com.smartgwt.client.widgets.Canvas#getID global IDs} will not actually be allowed to take
     * those global IDs - instead, only widgets that have one of the global IDs passed as the <code>globals</code> parameter
     * will actually receive their global IDs.  To override this behavior, pass the special value {@link
     * com.smartgwt.client.rpc.RPCManager#ALL_GLOBALS ALL_GLOBALS} for the <code>globals</code> parameter.
     * @param jsonString JSON string
     * @param parentNode parent node (defaults to the root)
     * @param globals widgets to allow to take their global IDs
     * @param callback Callback to fire after nodes have been added
     * @see com.smartgwt.client.tools.EditContext#serializeAllEditNodesAsJSON
     * @see com.smartgwt.client.tools.EditContext#serializeEditNodesAsJSON
     */
    public native void addPaletteNodesFromJSON(String jsonString, EditNode parentNode, String[] globals, Function callback) /*-{
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
     * com.smartgwt.client.tools.EditContext#serializeAllEditNodes EditContext.serializeAllEditNodes} or {@link
     * com.smartgwt.client.tools.EditContext#serializeEditNodes EditContext.serializeEditNodes}. <P> By default, components
     * that have {@link com.smartgwt.client.widgets.Canvas#getID global IDs} will not actually be allowed to take those global
     * IDs - instead, only widgets that have one of the global IDs passed as the <code>globals</code> parameter will actually
     * receive their global IDs.  To override this behavior, pass the special value {@link
     * com.smartgwt.client.rpc.RPCManager#ALL_GLOBALS ALL_GLOBALS} for the <code>globals</code> parameter.
     * @param xmlString XML string
     * @param parentNode parent node (defaults to the root)
     * @param globals widgets to allow to take their global IDs
     * @param callback Callback to fire after nodes have been added
     * @see com.smartgwt.client.tools.EditContext#serializeAllEditNodes
     * @see com.smartgwt.client.tools.EditContext#serializeEditNodes
     */
    public native void addPaletteNodesFromXML(String xmlString, EditNode parentNode, String[] globals, Function callback) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.addPaletteNodesFromXML(xmlString, parentNode == null ? null : parentNode.@com.smartgwt.client.core.DataClass::getJsObj()(), @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(globals), 
			$entry( function() { 
				if(callback!=null) callback.@com.smartgwt.client.core.Function::execute()(
				);
			}));
    }-*/;
	
	/**
     * Deselect all EditNodes.
     */
    public native void deselectAllEditNodes() /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.deselectAllEditNodes();
    }-*/;



	/**
     * Deselect a list of EditNodes.
     * @param editNodes editNodes to deselect
     */
    public native void deselectEditNodes(List editNodes) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.deselectEditNodes(editNodes);
    }-*/;


	/**
     * Removes all {@link com.smartgwt.client.tools.EditNode EditNodes} from the EditContext, and calls {@link
     * com.smartgwt.client.widgets.Canvas#destroy destroy()} on the {@link com.smartgwt.client.tools.EditNode#getLiveObject
     * liveObjects}.
     */
    public native void destroyAll() /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.destroyAll();
    }-*/;



	/**
     * Enable edit mode for an {@link com.smartgwt.client.tools.EditNode}. This is a shortcut for calling {@link
     * com.smartgwt.client.widgets.Canvas#setEditMode Canvas.setEditMode}.
     * @param editNode the EditNode on which to enable editing
     * @see com.smartgwt.client.widgets.Canvas#setEditMode
     * @see com.smartgwt.client.tools.EditContext#isNodeEditingOn
     */
    public native void enableEditing(EditNode editNode) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.enableEditing(editNode.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;


	/**
     * Gets the tree of editNodes being edited by this editContext. Standard tree traversal methods can then be used to locate
     * desired editNodes for interaction. <P> <B>Note: the returned tree is read-only and must only be modified by calling
     * methods on EditContext like {@link com.smartgwt.client.tools.EditContext#addNode EditContext.addNode} or {@link
     * com.smartgwt.client.tools.EditContext#setNodeProperties EditContext.setNodeProperties}.</B>
     *
     * @return the tree of EditNodes
     */
    public native Tree getEditNodeTree() /*-{
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
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.isEditNodeSelected();
        return ret;
    }-*/;



	/**
     * Returns true if <code>editNode</code> is in edit mode.
     * @param editNode the EditNode
     *
     * @return true if node is in edit mode
     */
    public native boolean isNodeEditingOn(EditNode editNode) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.isNodeEditingOn(editNode.@com.smartgwt.client.core.DataClass::getJsObj()());
        return ret;
    }-*/;




	/**
     * Creates and returns an EditNode using the {@link com.smartgwt.client.tools.EditContext#getDefaultPalette
     * defaultPalette}.  Does not add the newly created EditNode to the EditContext.
     * @param paletteNode the palette node to use to create the new node
     *
     * @return the EditNode created from the paletteNode
     */
    public native EditNode makeEditNode(PaletteNode paletteNode) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.makeEditNode(paletteNode.@com.smartgwt.client.core.DataClass::getJsObj()());
        if(ret == null) return null;
        return @com.smartgwt.client.tools.EditNode::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
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
        var obj = null;
        var selfJ = this;
        var nodeAdded = $entry(function(){
            var param = {"newNode" : arguments[0], "parentNode" : arguments[1], "rootNode" : arguments[2]};
                var event = @com.smartgwt.client.tools.NodeAddedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                selfJ.@com.smartgwt.client.core.BaseClass::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            });
        if(this.@com.smartgwt.client.core.BaseClass::isCreated()()) {
            obj = this.@com.smartgwt.client.core.BaseClass::getJsObj()();
            obj.addProperties({nodeAdded:  nodeAdded              });
        } else {
            obj = this.@com.smartgwt.client.core.BaseClass::getConfig()();
            obj.nodeAdded =  nodeAdded             ;
        }
   }-*/;
	/**
     * Removes all {@link com.smartgwt.client.tools.EditNode EditNodes} from the EditContext, but does not destroy  the {@link
     * com.smartgwt.client.tools.EditNode#getLiveObject liveObjects}.
     */
    public native void removeAll() /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.removeAll();
    }-*/;



	/**
     * Removes {@link com.smartgwt.client.tools.EditNode EditNode} from the EditContext. The editNode liveObject is not
     * destroyed.
     * @param editNode node to be removed
     */
    public native void removeNode(EditNode editNode) /*-{
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
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.removeNodeProperties(editNode.@com.smartgwt.client.core.DataClass::getJsObj()(), @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(properties));
    }-*/;


	/**
     * Select all EditNodes.
     */
    public native void selectAllEditNodes() /*-{
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
        var obj = null;
        var selfJ = this;
        var selectedEditNodesUpdated = $entry(function(){
            var param = {"editNode" : arguments[0], "editNodeList" : arguments[1]};
                var event = @com.smartgwt.client.tools.SelectedEditNodesUpdatedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                selfJ.@com.smartgwt.client.core.BaseClass::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            });
        if(this.@com.smartgwt.client.core.BaseClass::isCreated()()) {
            obj = this.@com.smartgwt.client.core.BaseClass::getJsObj()();
            obj.addProperties({selectedEditNodesUpdated:  selectedEditNodesUpdated              });
        } else {
            obj = this.@com.smartgwt.client.core.BaseClass::getConfig()();
            obj.selectedEditNodesUpdated =  selectedEditNodesUpdated             ;
        }
   }-*/;


	/**
     * Select an EditNode.
     * @param editNode editNode to select
     */
    public native void selectEditNode(EditNode editNode) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.selectEditNode(editNode.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;




	/**
     * Select a single EditNode and deselect everything else.
     * @param editNode editNode to select
     */
    public native void selectSingleEditNode(EditNode editNode) /*-{
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
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.serializeEditNodesAsJSON(@com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(nodes), settings == null ? null : settings.@com.smartgwt.client.core.DataClass::getJsObj()());
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
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
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
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.setNodeProperties(editNode.@com.smartgwt.client.core.DataClass::getJsObj()(), properties.@com.smartgwt.client.widgets.BaseWidget::getConfig()(), skipLiveObjectUpdate == null ? null : skipLiveObjectUpdate.@java.lang.Boolean::booleanValue()());
    }-*/;
	

    // ********************* Static Methods ***********************

    // ***********************************************************


    /**
     * Update an editNode's serializable "defaults" with the supplied properties. If you wish to remove a property from the
     * defaults (rather than setting it to null), then use {@link com.smartgwt.client.tools.EditContext#removeNodeProperties
     * removeNodeProperties()} instead.
     * @param editNode the editNode to update
     * @param properties the properties to apply
     * @see com.smartgwt.client.tools.EditContext#removeNodeProperties
     */
    public void setNodeProperties(EditNode editNode, DrawItem properties) throws IllegalStateException {
        if (properties.isCreated()) {
            throw new IllegalStateException(JSOHelper.getClassName(properties.getJsObj()) + " passed as configuration properties has been initialized and/or drawn. Calling draw() and other methods or adding to a DrawPane will force a DrawItem to initialize, after which it cannot be used as configuration properties.");
        }
        JavaScriptObject rawProperties = JSOHelper.cleanProperties(properties.getConfig(), true);
        this.setNodeProperties(editNode, rawProperties);
    }


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
    public void setNodeProperties(EditNode editNode, DrawItem properties, Boolean skipLiveObjectUpdate) throws IllegalStateException {
        if (properties.isCreated()) {
            throw new IllegalStateException(JSOHelper.getClassName(properties.getJsObj()) + " passed as configuration properties has been initialized and/or drawn. Calling draw() and other methods or adding to a DrawPane will force a DrawItem to initialize, after which it cannot be used as configuration properties.");
        }
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


