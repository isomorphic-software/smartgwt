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

/**
 * A TreeGrid that allows drag and drop creation and manipulation of a tree of  objects described by DataSources. <P> Nodes
 * can be added via drag and drop from a {@link com.smartgwt.client.tools.Palette} or may be programmatically  added via
 * {@link com.smartgwt.client.tools.EditContext#addNode addNode()}.  Nodes may be dragged within the tree to reparent 
 * them. <P> Eligibility to be dropped on any given node is determined by inspecting the DataSource of the parent node. 
 * Drop is allowed only if the parent schema has a field which accepts the type of the dropped node. <P> On successful
 * drop, the newly created component will be added to the parent node under the detected field.  Array fields, declared by
 * setting <code>dataSourceField.multiple:true</code>, are supported.   <P> An EditTree is initialized by setting {@link
 * com.smartgwt.client.tools.EditTree#getRootComponent rootComponent} or {@link
 * com.smartgwt.client.tools.EditTree#getEditContext editContext}.  EditTree.data (the Tree instance) should never be
 * directly set or looked at. <P> EditTree automatically creates an {@link com.smartgwt.client.tools.EditContext} and
 * provides several APIs and settings that are passthroughs to the underlying EditContext for convenience.
 * @see com.smartgwt.client.docs.DevTools DevTools overview and related methods
 */
@BeanFactory.FrameworkClass
@BeanFactory.ScClassName("EditTree")
public class EditTree extends TreeGrid {

    public static EditTree getOrCreateRef(JavaScriptObject jsObj) {
        if (jsObj == null) return null;
        final BaseWidget refInstance = BaseWidget.getRef(jsObj);
        if (refInstance == null) {
            return new EditTree(jsObj);
        } else {
            assert refInstance instanceof EditTree;
            return (EditTree)refInstance;
        }
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(EditTree.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "Canvas");
        }
        defaults.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
        var cleanDefaultsJS = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(defaults.@com.smartgwt.client.widgets.BaseWidget::getConfig()(), true);
        $wnd.isc.EditTree.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(EditTree.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "FormItem");
        }
        defaults.@com.smartgwt.client.widgets.form.fields.FormItem::setConfigOnly(Z)(true);
    	var cleanDefaultsJS = defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getEditorTypeConfig()();
        $wnd.isc.EditTree.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
    }-*/;

    public EditTree(){
        scClassName = "EditTree";
    }

    public EditTree(JavaScriptObject jsObj){
        scClassName = "EditTree";
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
     * Controls whether components can be dropped into other components which support child components.  <p> When enabled,
     * during a drop interaction in which a {@link com.smartgwt.client.tools.PaletteNode} or {@link
     * com.smartgwt.client.tools.EditNode} is the drop data, the {@link com.smartgwt.client.docs.ComponentSchema Component
     * Schema} of the current candidate drop target is inspected to see whether that parent allows children of the type being
     * dropped.  If it does, the drop will result in a call to {@link com.smartgwt.client.tools.EditTree#addNode addNode()} for
     * a paletteNode or for an existing {@link com.smartgwt.client.tools.EditNode} in the same tree. <p> Specific components
     * can disable nested drops by explicitly setting {@link com.smartgwt.client.tools.EditProxy#getAllowNestedDrops
     * EditProxy.allowNestedDrops} to false. <p> This mode is enabled by default unless explicitly disabled by setting this
     * property to false.
     *
     * @param allowNestedDrops New allowNestedDrops value. Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setAllowNestedDrops(Boolean allowNestedDrops)  throws IllegalStateException {
        setAttribute("allowNestedDrops", allowNestedDrops, false);
    }

    /**
     * Controls whether components can be dropped into other components which support child components.  <p> When enabled,
     * during a drop interaction in which a {@link com.smartgwt.client.tools.PaletteNode} or {@link
     * com.smartgwt.client.tools.EditNode} is the drop data, the {@link com.smartgwt.client.docs.ComponentSchema Component
     * Schema} of the current candidate drop target is inspected to see whether that parent allows children of the type being
     * dropped.  If it does, the drop will result in a call to {@link com.smartgwt.client.tools.EditTree#addNode addNode()} for
     * a paletteNode or for an existing {@link com.smartgwt.client.tools.EditNode} in the same tree. <p> Specific components
     * can disable nested drops by explicitly setting {@link com.smartgwt.client.tools.EditProxy#getAllowNestedDrops
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
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setAutoEditNewNodes(Boolean autoEditNewNodes)  throws IllegalStateException {
        setAttribute("autoEditNewNodes", autoEditNewNodes, false);
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
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setCanDragGroup(Boolean canDragGroup)  throws IllegalStateException {
        setAttribute("canDragGroup", canDragGroup, false);
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
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setCanGroupSelect(Boolean canGroupSelect)  throws IllegalStateException {
        setAttribute("canGroupSelect", canGroupSelect, false);
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
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setDefaultPalette(Palette defaultPalette)  throws IllegalStateException {
        // Since Palette is an interface, we need to convert it to a
        // JavaScriptObject dynamically at run-time -- we don't know what class
        // is implementing the interface.
        JavaScriptObject jsoArray = JSOHelper.convertToJavaScriptArray(new Object[] {defaultPalette});
        JavaScriptObject jso = JSOHelper.getValueFromJavaScriptObjectArray(jsoArray, 0);
        setAttribute("defaultPalette", jso == null ? null : jso, false);
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
     * The {@link com.smartgwt.client.tools.EditContext} managed by this EditTree. If not set an instance will be automatically
     * created.
     *
     * @param editContext New editContext value. Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setEditContext(EditContext editContext)  throws IllegalStateException {
        setAttribute("editContext", editContext == null ? null : editContext.getOrCreateJsObj(), false);
    }

    /**
     * The {@link com.smartgwt.client.tools.EditContext} managed by this EditTree. If not set an instance will be automatically
     * created.
     *
     * @return Returns the {@link com.smartgwt.client.tools.EditContext} instance managed by the EditTree. Default value is null
     */
    public EditContext getEditContext()  {
        return EditContext.getOrCreateRef(getAttributeAsJavaScriptObject("editContext"));
    }
    

    /**
     * Additional {@link com.smartgwt.client.tools.Palette Palettes} to consult for metadata when deserializing {@link
     * com.smartgwt.client.tools.EditNode Edit Nodes}. Note that the {@link
     * com.smartgwt.client.tools.EditTree#getDefaultPalette defaultPalette} is always consulted and need not be provided again
     * here.
     *
     * @param extraPalettes New extraPalettes value. Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setExtraPalettes(Palette... extraPalettes)  throws IllegalStateException {
        // Since Palette... is an interface, we need to convert it to a
        // JavaScriptObject dynamically at run-time -- we don't know what class
        // is implementing the interface.
        JavaScriptObject jsoArray = JSOHelper.convertToJavaScriptArray(new Object[] {extraPalettes});
        JavaScriptObject jso = JSOHelper.getValueFromJavaScriptObjectArray(jsoArray, 0);
        setAttribute("extraPalettes", jso == null ? null : jso, false);
    }

    /**
     * Additional {@link com.smartgwt.client.tools.Palette Palettes} to consult for metadata when deserializing {@link
     * com.smartgwt.client.tools.EditNode Edit Nodes}. Note that the {@link
     * com.smartgwt.client.tools.EditTree#getDefaultPalette defaultPalette} is always consulted and need not be provided again
     * here.
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
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setHideGroupBorderOnDrag(Boolean hideGroupBorderOnDrag)  throws IllegalStateException {
        setAttribute("hideGroupBorderOnDrag", hideGroupBorderOnDrag, false);
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
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setPersistCoordinates(Boolean persistCoordinates)  throws IllegalStateException {
        setAttribute("persistCoordinates", persistCoordinates, false);
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
     * node. <P> Can be retrieved at any time. Use {@link com.smartgwt.client.tools.EditTree#getRootEditNode getRootEditNode()}
     * to retrieve the {@link com.smartgwt.client.tools.EditNode} created from the rootComponent.
     *
     * @param rootComponent New rootComponent value. Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.DevTools DevTools overview and related methods
     */
    public void setRootComponent(Record rootComponent)  throws IllegalStateException {
        setAttribute("rootComponent", rootComponent == null ? null : rootComponent.getJsObj(), false);
    }

    /**
     * Root of data to edit.  Must contain the "type" property, with the name of a valid {@link
     * com.smartgwt.client.data.DataSource schema} or nothing will be able to be dropped on this EditContext. A "liveObject"
     * property representing the rootComponent is also suggested. Otherwise, a live object will be created from the palette
     * node. <P> Can be retrieved at any time. Use {@link com.smartgwt.client.tools.EditTree#getRootEditNode getRootEditNode()}
     * to retrieve the {@link com.smartgwt.client.tools.EditNode} created from the rootComponent.
     *
     * @return Current rootComponent value. Default value is null
     * @see com.smartgwt.client.docs.DevTools DevTools overview and related methods
     */
    public Record getRootComponent()  {
        return Record.getOrCreateRef(getAttributeAsJavaScriptObject("rootComponent"));
    }
    

    /**
     * Set the CSS border to be applied to the selection outline of the selected components. This property is used when {@link
     * com.smartgwt.client.tools.EditProxy#getSelectedAppearance EditProxy.selectedAppearance} is <code>outlineMask</code> or
     * <code>outlineEdges</code>. <P> This value is applied as a default to {@link
     * com.smartgwt.client.tools.EditProxy#getSelectedBorder EditProxy.selectedBorder}.
     *
     * @param selectedBorder New selectedBorder value. Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setSelectedBorder(String selectedBorder)  throws IllegalStateException {
        setAttribute("selectedBorder", selectedBorder, false);
    }

    /**
     * Set the CSS border to be applied to the selection outline of the selected components. This property is used when {@link
     * com.smartgwt.client.tools.EditProxy#getSelectedAppearance EditProxy.selectedAppearance} is <code>outlineMask</code> or
     * <code>outlineEdges</code>. <P> This value is applied as a default to {@link
     * com.smartgwt.client.tools.EditProxy#getSelectedBorder EditProxy.selectedBorder}.
     *
     * @return Current selectedBorder value. Default value is null
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
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.tools.EditContext#setShowSelectedLabel
     */
    public void setSelectedLabelBackgroundColor(String selectedLabelBackgroundColor)  throws IllegalStateException {
        setAttribute("selectedLabelBackgroundColor", selectedLabelBackgroundColor, false);
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
     * Should the selection outline show a label for selected components? A component may also be highlighted with the
     * selection outline and label to indicate the target of a drop. To suppress showing a label at any time set this property
     * to <code>false</code>. <P> To suppress labels during selection but still show them when targeted for a drop, see {@link
     * com.smartgwt.client.tools.EditContext#getShowSelectedLabelOnSelect EditContext.showSelectedLabelOnSelect}. <P> NOTE: A
     * selected component label is only supported when {@link com.smartgwt.client.tools.EditProxy#getSelectedAppearance
     * EditProxy.selectedAppearance} is "outlineEdges".
     *
     * @param showSelectedLabel New showSelectedLabel value. Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setShowSelectedLabel(Boolean showSelectedLabel)  throws IllegalStateException {
        setAttribute("showSelectedLabel", showSelectedLabel, false);
    }

    /**
     * Should the selection outline show a label for selected components? A component may also be highlighted with the
     * selection outline and label to indicate the target of a drop. To suppress showing a label at any time set this property
     * to <code>false</code>. <P> To suppress labels during selection but still show them when targeted for a drop, see {@link
     * com.smartgwt.client.tools.EditContext#getShowSelectedLabelOnSelect EditContext.showSelectedLabelOnSelect}. <P> NOTE: A
     * selected component label is only supported when {@link com.smartgwt.client.tools.EditProxy#getSelectedAppearance
     * EditProxy.selectedAppearance} is "outlineEdges".
     *
     * @return Current showSelectedLabel value. Default value is null
     */
    public Boolean getShowSelectedLabel()  {
        return getAttributeAsBoolean("showSelectedLabel");
    }
    

    /**
     * If set, auto-enables {@link com.smartgwt.client.tools.EditProxy#getUseCopyPasteShortcuts
     * EditProxy.useCopyPasteShortcuts} on the {@link com.smartgwt.client.tools.EditProxy} for the {@link
     * com.smartgwt.client.tools.EditTree#getRootEditNode root editNode}.  This works whether there is currently a root
     * editNode or one is added later.
     *
     * @param useCopyPasteShortcuts New useCopyPasteShortcuts value. Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setUseCopyPasteShortcuts(Boolean useCopyPasteShortcuts)  throws IllegalStateException {
        setAttribute("useCopyPasteShortcuts", useCopyPasteShortcuts, false);
    }

    /**
     * If set, auto-enables {@link com.smartgwt.client.tools.EditProxy#getUseCopyPasteShortcuts
     * EditProxy.useCopyPasteShortcuts} on the {@link com.smartgwt.client.tools.EditProxy} for the {@link
     * com.smartgwt.client.tools.EditTree#getRootEditNode root editNode}.  This works whether there is currently a root
     * editNode or one is added later.
     *
     * @return Current useCopyPasteShortcuts value. Default value is null
     */
    public Boolean getUseCopyPasteShortcuts()  {
        return getAttributeAsBoolean("useCopyPasteShortcuts");
    }
    

    // ********************* Methods ***********************
	/**
     * Creates a new EditNode from a PaletteNode, using the {@link com.smartgwt.client.tools.EditTree#getDefaultPalette
     * defaultPalette}.  If you have an array of possibly inter-related PaletteNodes, then you should use {@link
     * com.smartgwt.client.tools.EditTree#addFromPaletteNodes addFromPaletteNodes()} on the array instead, in order to preserve
     * the relationships.
     * @param paletteNode the palette node to use to create the new node
     *
     * @return the EditNode created from the paletteNode
     * @see com.smartgwt.client.tools.EditTree#addFromPaletteNodes
     */
    public native EditNode addFromPaletteNode(PaletteNode paletteNode) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "addFromPaletteNode", "PaletteNode");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.addFromPaletteNode(paletteNode.@com.smartgwt.client.core.DataClass::getJsObj()());
        if(ret == null) return null;
        return @com.smartgwt.client.tools.EditNode::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

	/**
     * Creates a new EditNode from a PaletteNode, using the {@link com.smartgwt.client.tools.EditTree#getDefaultPalette
     * defaultPalette}.  If you have an array of possibly inter-related PaletteNodes, then you should use {@link
     * com.smartgwt.client.tools.EditTree#addFromPaletteNodes addFromPaletteNodes()} on the array instead, in order to preserve
     * the relationships.
     * @param paletteNode the palette node to use to create the new node
     * @param parentNode optional the parent node if the new node should appear                                under a specific parent
     *
     * @return the EditNode created from the paletteNode
     * @see com.smartgwt.client.tools.EditTree#addFromPaletteNodes
     */
    public native EditNode addFromPaletteNode(PaletteNode paletteNode, EditNode parentNode) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "addFromPaletteNode", "PaletteNode,EditNode");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.addFromPaletteNode(paletteNode.@com.smartgwt.client.core.DataClass::getJsObj()(), parentNode == null ? null : parentNode.@com.smartgwt.client.core.DataClass::getJsObj()());
        if(ret == null) return null;
        return @com.smartgwt.client.tools.EditNode::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;
	
	/**
     * Add the supplied {@link com.smartgwt.client.tools.PaletteNode PaletteNodes} to the parentNode, preserving internal
     * references from one supplied PaletteNode to another. This method should be used with an array of possibly inter-related
     * PaletteNodes (for instance, those produced as a result of serialization via {@link
     * com.smartgwt.client.tools.EditTree#serializeAllEditNodes serializeAllEditNodes()}, rather than calling {@link
     * com.smartgwt.client.tools.EditTree#addFromPaletteNode addFromPaletteNode()} on each individual PaletteNode.
     * @param paletteNodes array of PaletteNodes
     *
     * @return an array of the EditNodes added to the parentNode
     * @see com.smartgwt.client.tools.EditTree#addFromPaletteNode
     */
    public native EditNode[] addFromPaletteNodes(PaletteNode[] paletteNodes) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "addFromPaletteNodes", "PaletteNode[]");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.addFromPaletteNodes(@com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(paletteNodes));
        if(ret == null) return null;
        return @com.smartgwt.client.util.ConvertTo::arrayOfEditNode(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

	/**
     * Add the supplied {@link com.smartgwt.client.tools.PaletteNode PaletteNodes} to the parentNode, preserving internal
     * references from one supplied PaletteNode to another. This method should be used with an array of possibly inter-related
     * PaletteNodes (for instance, those produced as a result of serialization via {@link
     * com.smartgwt.client.tools.EditTree#serializeAllEditNodes serializeAllEditNodes()}, rather than calling {@link
     * com.smartgwt.client.tools.EditTree#addFromPaletteNode addFromPaletteNode()} on each individual PaletteNode.
     * @param paletteNodes array of PaletteNodes
     * @param parentNode parent to add to (defaults to the root)
     *
     * @return an array of the EditNodes added to the parentNode
     * @see com.smartgwt.client.tools.EditTree#addFromPaletteNode
     */
    public native EditNode[] addFromPaletteNodes(PaletteNode[] paletteNodes, EditNode parentNode) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "addFromPaletteNodes", "PaletteNode[],EditNode");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.addFromPaletteNodes(@com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(paletteNodes), parentNode == null ? null : parentNode.@com.smartgwt.client.core.DataClass::getJsObj()());
        if(ret == null) return null;
        return @com.smartgwt.client.util.ConvertTo::arrayOfEditNode(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;
	
	/**
     * Add a new {@link com.smartgwt.client.tools.EditNode} to the EditContext, under the specified parent. If the parentNode
     * is not provided it will be determined from {@link com.smartgwt.client.tools.EditContext#getDefaultParent
     * EditContext.defaultParent}. <P> The EditContext will interrogate the parent and new nodes to determine what field 
     * within the parent allows a child of this type, and to find a method to add the newNode's  liveObject to the parentNode's
     * liveObject.  The new relationship will then be stored in the tree of EditNodes. <P> For example, when a Tab is dropped
     * on a TabSet, the field TabSet.tabs is discovered as the correct target field via naming conventions, and the method
     * TabSet.addTab() is likewise  discovered as the correct method to add a Tab to a TabSet.
     * @param newNode new node to be added
     *
     * @return newNodenode added
     */
    public native EditNode addNode(EditNode newNode) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "addNode", "EditNode");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.addNode(newNode.@com.smartgwt.client.core.DataClass::getJsObj()());
        if(ret == null) return null;
        return @com.smartgwt.client.tools.EditNode::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

    /**
     * @see EditTree#addNode
     */
    public EditNode addNode(EditNode newNode, EditNode parentNode){
        return addNode(newNode, parentNode, (Integer) null, null, null, null);
    }

    /**
     * @see EditTree#addNode
     */
    public EditNode addNode(EditNode newNode, EditNode parentNode, Integer index){
        return addNode(newNode, parentNode, index, null, null, null);
    }

    /**
     * @see EditTree#addNode
     */
    public EditNode addNode(EditNode newNode, EditNode parentNode, Integer index, String parentProperty){
        return addNode(newNode, parentNode, index, parentProperty, null, null);
    }

    /**
     * @see EditTree#addNode
     */
    public EditNode addNode(EditNode newNode, EditNode parentNode, Integer index, String parentProperty, Boolean skipParentComponentAdd){
        return addNode(newNode, parentNode, index, parentProperty, skipParentComponentAdd, null);
    }

	/**
     * Add a new {@link com.smartgwt.client.tools.EditNode} to the EditContext, under the specified parent. If the parentNode
     * is not provided it will be determined from {@link com.smartgwt.client.tools.EditContext#getDefaultParent
     * EditContext.defaultParent}. <P> The EditContext will interrogate the parent and new nodes to determine what field 
     * within the parent allows a child of this type, and to find a method to add the newNode's  liveObject to the parentNode's
     * liveObject.  The new relationship will then be stored in the tree of EditNodes. <P> For example, when a Tab is dropped
     * on a TabSet, the field TabSet.tabs is discovered as the correct target field via naming conventions, and the method
     * TabSet.addTab() is likewise  discovered as the correct method to add a Tab to a TabSet.
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
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "addNode", "EditNode,EditNode,Integer,String,Boolean,Boolean");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
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
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "addPaletteNodesFromJS", "String");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.addPaletteNodesFromJS(jsCode);
    }-*/;

    /**
     * @see EditTree#addPaletteNodesFromJS
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
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "addPaletteNodesFromJS", "String,EditNode,String[]");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.addPaletteNodesFromJS(jsCode, parentNode == null ? null : parentNode.@com.smartgwt.client.core.DataClass::getJsObj()(), @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(globals));
    }-*/;
	
	/**
     * Recreate {@link com.smartgwt.client.tools.EditNode EditNodes} from a JSON representation of  {@link
     * com.smartgwt.client.tools.PaletteNode PaletteNodes} (possibly created by calling {@link
     * com.smartgwt.client.tools.EditTree#serializeAllEditNodesAsJSON serializeAllEditNodesAsJSON()} or {@link
     * com.smartgwt.client.tools.EditTree#serializeEditNodesAsJSON serializeEditNodesAsJSON()}. <P> By default, components that
     * have {@link com.smartgwt.client.widgets.Canvas#getID global IDs} will not actually be allowed to take those global IDs -
     * instead, only widgets that have one of the global IDs passed as the <code>globals</code> parameter will actually receive
     * their global IDs.  To override this behavior, pass the special value {@link
     * com.smartgwt.client.rpc.RPCManager#ALL_GLOBALS ALL_GLOBALS} for the <code>globals</code> parameter.
     * @param jsonString JSON string representing an array of PaletteNodes
     * @see com.smartgwt.client.tools.EditTree#addFromPaletteNodes
     * @see com.smartgwt.client.tools.EditTree#serializeAllEditNodesAsJSON
     * @see com.smartgwt.client.tools.EditTree#serializeEditNodesAsJSON
     */
    public native void addPaletteNodesFromJSON(String jsonString) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "addPaletteNodesFromJSON", "String");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.addPaletteNodesFromJSON(jsonString);
    }-*/;

    /**
     * @see EditTree#addPaletteNodesFromJSON
     */
    public void addPaletteNodesFromJSON(String jsonString, EditNode parentNode){
        addPaletteNodesFromJSON(jsonString, parentNode, null, null);
    }

    /**
     * @see EditTree#addPaletteNodesFromJSON
     */
    public void addPaletteNodesFromJSON(String jsonString, EditNode parentNode, String[] globals){
        addPaletteNodesFromJSON(jsonString, parentNode, globals, null);
    }

	/**
     * Recreate {@link com.smartgwt.client.tools.EditNode EditNodes} from a JSON representation of  {@link
     * com.smartgwt.client.tools.PaletteNode PaletteNodes} (possibly created by calling {@link
     * com.smartgwt.client.tools.EditTree#serializeAllEditNodesAsJSON serializeAllEditNodesAsJSON()} or {@link
     * com.smartgwt.client.tools.EditTree#serializeEditNodesAsJSON serializeEditNodesAsJSON()}. <P> By default, components that
     * have {@link com.smartgwt.client.widgets.Canvas#getID global IDs} will not actually be allowed to take those global IDs -
     * instead, only widgets that have one of the global IDs passed as the <code>globals</code> parameter will actually receive
     * their global IDs.  To override this behavior, pass the special value {@link
     * com.smartgwt.client.rpc.RPCManager#ALL_GLOBALS ALL_GLOBALS} for the <code>globals</code> parameter.
     * @param jsonString JSON string representing an array of PaletteNodes
     * @param parentNode parent to add to (defaults to the root)
     * @param globals widgets to allow to take their global IDs
     * @param callback Callback to fire after nodes have been added
     * @see com.smartgwt.client.tools.EditTree#addFromPaletteNodes
     * @see com.smartgwt.client.tools.EditTree#serializeAllEditNodesAsJSON
     * @see com.smartgwt.client.tools.EditTree#serializeEditNodesAsJSON
     */
    public native void addPaletteNodesFromJSON(String jsonString, EditNode parentNode, String[] globals, Function callback) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "addPaletteNodesFromJSON", "String,EditNode,String[],Function");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.addPaletteNodesFromJSON(jsonString, parentNode == null ? null : parentNode.@com.smartgwt.client.core.DataClass::getJsObj()(), @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(globals), 
			$entry( function() { 
				if(callback!=null) callback.@com.smartgwt.client.core.Function::execute()(
				);
			}));
    }-*/;
	
	/**
     * Recreate {@link com.smartgwt.client.tools.EditNode EditNodes} from an XML representation of  {@link
     * com.smartgwt.client.tools.PaletteNode PaletteNodes} (possibly created by calling {@link
     * com.smartgwt.client.tools.EditTree#serializeAllEditNodes serializeAllEditNodes()} or {@link
     * com.smartgwt.client.tools.EditTree#serializeEditNodes serializeEditNodes()}. <P> By default, components that have {@link
     * com.smartgwt.client.widgets.Canvas#getID global IDs} will not actually be allowed to take those global IDs - instead,
     * only widgets that have one of the global IDs passed as the <code>globals</code> parameter will actually receive their
     * global IDs.  To override this behavior, pass the special value {@link com.smartgwt.client.rpc.RPCManager#ALL_GLOBALS
     * ALL_GLOBALS} for the <code>globals</code> parameter.
     * @param xmlString XML string
     * @see com.smartgwt.client.tools.EditTree#serializeAllEditNodes
     * @see com.smartgwt.client.tools.EditTree#serializeEditNodes
     */
    public native void addPaletteNodesFromXML(String xmlString) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "addPaletteNodesFromXML", "String");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.addPaletteNodesFromXML(xmlString);
    }-*/;

    /**
     * @see EditTree#addPaletteNodesFromXML
     */
    public void addPaletteNodesFromXML(String xmlString, EditNode parentNode){
        addPaletteNodesFromXML(xmlString, parentNode, null, null);
    }

    /**
     * @see EditTree#addPaletteNodesFromXML
     */
    public void addPaletteNodesFromXML(String xmlString, EditNode parentNode, String[] globals){
        addPaletteNodesFromXML(xmlString, parentNode, globals, null);
    }

	/**
     * Recreate {@link com.smartgwt.client.tools.EditNode EditNodes} from an XML representation of  {@link
     * com.smartgwt.client.tools.PaletteNode PaletteNodes} (possibly created by calling {@link
     * com.smartgwt.client.tools.EditTree#serializeAllEditNodes serializeAllEditNodes()} or {@link
     * com.smartgwt.client.tools.EditTree#serializeEditNodes serializeEditNodes()}. <P> By default, components that have {@link
     * com.smartgwt.client.widgets.Canvas#getID global IDs} will not actually be allowed to take those global IDs - instead,
     * only widgets that have one of the global IDs passed as the <code>globals</code> parameter will actually receive their
     * global IDs.  To override this behavior, pass the special value {@link com.smartgwt.client.rpc.RPCManager#ALL_GLOBALS
     * ALL_GLOBALS} for the <code>globals</code> parameter.
     * @param xmlString XML string
     * @param parentNode parent node (defaults to the root)
     * @param globals widgets to allow to take their global IDs
     * @param callback Callback to fire after nodes have been added
     * @see com.smartgwt.client.tools.EditTree#serializeAllEditNodes
     * @see com.smartgwt.client.tools.EditTree#serializeEditNodes
     */
    public native void addPaletteNodesFromXML(String xmlString, EditNode parentNode, String[] globals, Function callback) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "addPaletteNodesFromXML", "String,EditNode,String[],Function");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.addPaletteNodesFromXML(xmlString, parentNode == null ? null : parentNode.@com.smartgwt.client.core.DataClass::getJsObj()(), @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(globals), 
			$entry( function() { 
				if(callback!=null) callback.@com.smartgwt.client.core.Function::execute()(
				);
			}));
    }-*/;
	
	/**
     * Copies the passed editNode or editNodes to an internal "clipboard" space, for later application via {@link
     * com.smartgwt.client.tools.EditTree#pasteEditNodes pasteEditNodes()}.
     * @param editNode 
     */
    public native void copyEditNodes(EditNode editNode) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "copyEditNodes", "EditNode");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.copyEditNodes(editNode.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;

	/**
     * Copies the passed editNode or editNodes to an internal "clipboard" space, for later application via {@link
     * com.smartgwt.client.tools.EditTree#pasteEditNodes pasteEditNodes()}.
     * @param editNode 
     */
    public native void copyEditNodes(EditNode... editNode) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "copyEditNodes", "EditNode...");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.copyEditNodes(@com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(editNode));
    }-*/;

	/**
     * Removes all {@link com.smartgwt.client.tools.EditNode EditNodes} from the EditContext, and calls {@link
     * com.smartgwt.client.widgets.Canvas#destroy destroy()} on the {@link com.smartgwt.client.tools.EditNode#getLiveObject
     * liveObjects}.
     */
    public native void destroyAll() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "destroyAll", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.destroyAll();
    }-*/;

	/**
     * Enable edit mode for an {@link com.smartgwt.client.tools.EditNode}. This is a shortcut for calling {@link
     * com.smartgwt.client.widgets.Canvas#setEditMode Canvas.setEditMode()}.
     * @param editNode the EditNode on which to enable editing
     * @see com.smartgwt.client.widgets.Canvas#setEditMode
     * @see com.smartgwt.client.tools.EditTree#isNodeEditingOn
     */
    public native void enableEditing(EditNode editNode) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "enableEditing", "EditNode");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.enableEditing(editNode.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;

	/**
     * Gets the tree of editNodes being edited by this editContext. Standard tree traversal methods can then be used to locate
     * desired editNodes for interaction. <P> <B>Note: the returned tree is read-only and must only be modified by calling
     * methods on EditContext like {@link com.smartgwt.client.tools.EditContext#addNode EditContext.addNode()} or {@link
     * com.smartgwt.client.tools.EditContext#setNodeProperties EditContext.setNodeProperties()}.</B>
     *
     * @return the tree of EditNodes
     */
    public native Tree getEditNodeTree() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getEditNodeTree", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getEditNodeTree();
        if(ret == null) return null;
        return @com.smartgwt.client.widgets.tree.Tree::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

	/**
     * Obtain {@link com.smartgwt.client.tools.PaletteNode PaletteNodes} from an XML representation, but do not add them to the
     * EditContext.
     * @param xmlString XML string
     * @param callback Callback used to return the PaletteNodes
     * @see com.smartgwt.client.tools.EditTree#serializeAllEditNodes
     * @see com.smartgwt.client.tools.EditTree#serializeEditNodes
     */
    public native void getPaletteNodesFromXML(String xmlString, PaletteNodeCallback callback) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getPaletteNodesFromXML", "String,PaletteNodeCallback");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.getPaletteNodesFromXML(xmlString, 
			$entry( function(paletteNodes) { 
				if(callback!=null) callback.@com.smartgwt.client.callbacks.PaletteNodeCallback::execute([Lcom/smartgwt/client/tools/PaletteNode;)(@com.smartgwt.client.util.ConvertTo::arrayOfPaletteNode(Lcom/google/gwt/core/client/JavaScriptObject;)(paletteNodes)
				);
			}));
    }-*/;

	/**
     * Returns the root {@link com.smartgwt.client.tools.EditNode} of the EditContext typically created from {@link
     * com.smartgwt.client.tools.EditTree#getRootComponent rootComponent}.
     *
     * @return the root EditNode
     */
    public native EditNode getRootEditNode() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getRootEditNode", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getRootEditNode();
        if(ret == null) return null;
        return @com.smartgwt.client.tools.EditNode::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

	/**
     * Returns true if <code>editNode</code> is in edit mode.
     * @param editNode the EditNode
     *
     * @return true if node is in edit mode
     */
    public native boolean isNodeEditingOn(EditNode editNode) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "isNodeEditingOn", "EditNode");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.isNodeEditingOn(editNode.@com.smartgwt.client.core.DataClass::getJsObj()());
        return ret == null ? false : ret;
    }-*/;

	/**
     * Creates and returns an EditNode using the {@link com.smartgwt.client.tools.EditTree#getDefaultPalette defaultPalette}. 
     * Does not add the newly created EditNode to an EditContext.
     * @param paletteNode the palette node to use to create the new node
     *
     * @return the EditNode created from the paletteNode
     */
    public native EditNode makeEditNode(PaletteNode paletteNode) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "makeEditNode", "PaletteNode");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.makeEditNode(paletteNode.@com.smartgwt.client.core.DataClass::getJsObj()());
        if(ret == null) return null;
        return @com.smartgwt.client.tools.EditNode::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

	/**
     * Creates a {@link com.smartgwt.client.tools.PaletteNode} from an {@link com.smartgwt.client.tools.EditNode} in this
     * context's {@link com.smartgwt.client.tools.EditTree#getEditNodeTree editNodeTree}. <p> This essentially creates a new
     * {@link com.smartgwt.client.tools.PaletteNode} with the {@link com.smartgwt.client.tools.EditNode#getDefaults
     * EditNode.defaults} from the passed <code>editNode</code>.  The returned <code>paletteNode</code> could then be used with
     * {@link com.smartgwt.client.tools.EditContext#addFromPaletteNode EditContext.addFromPaletteNode()} to effectively create
     * a copy of the original editNode - specifically a new editNode with a new {@link
     * com.smartgwt.client.tools.EditNode#getLiveObject EditNode.liveObject} created from the same defaults. <p> However note
     * that <code>makePaletteNode()</code> does not copy descendant nodes - use {@link
     * com.smartgwt.client.tools.EditTree#makePaletteNodeTree makePaletteNodeTree()} for that. <p> May return null if the
     * passed editNode cannot validly by transformed into a paletteNode, for example if {@link
     * com.smartgwt.client.tools.EditNode#getCanDuplicate EditNode.canDuplicate} was set false.
     * @param editNode the editNode to use to make a paletteNode
     *
     * @return paletteNode derived from the editNode or null
     */
    public native PaletteNode makePaletteNode(EditNode editNode) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "makePaletteNode", "EditNode");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.makePaletteNode(editNode.@com.smartgwt.client.core.DataClass::getJsObj()());
        if(ret == null) return null;
        return @com.smartgwt.client.tools.PaletteNode::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

	/**
     * Creates a {@link com.smartgwt.client.widgets.tree.Tree} of {@link com.smartgwt.client.tools.PaletteNode PaletteNodes}
     * from an {@link com.smartgwt.client.tools.EditNode} in this context's {@link
     * com.smartgwt.client.tools.EditTree#getEditNodeTree editNodeTree}, by using {@link
     * com.smartgwt.client.tools.EditTree#makePaletteNode makePaletteNode()} on the passed <code>EditNode</code> and its
     * descendents within the {@link com.smartgwt.client.tools.EditContext#getEditNodeTree editNodeTree}. <p> The root node of
     * the returned {@link com.smartgwt.client.widgets.tree.Tree} will be a PaletteNode derived from the passed
     * <code>EditNode</code>.
     * @param editNode root editNode to make Tree of PaletteNodes from
     *
     * @return a Tree of paletteNodes or null
     */
    public native Tree makePaletteNodeTree(EditNode editNode) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "makePaletteNodeTree", "EditNode");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.makePaletteNodeTree(editNode.@com.smartgwt.client.core.DataClass::getJsObj()());
        if(ret == null) return null;
        return @com.smartgwt.client.widgets.tree.Tree::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

	/**
     * "Pastes" <code>editNodes</code> previously captured via {@link com.smartgwt.client.tools.EditTree#copyEditNodes
     * copyEditNodes()}. <p> New editNodes will be added as root-level nodes of the {@link
     * com.smartgwt.client.tools.EditTree#getEditNodeTree editNodeTree} unless a <code>targetEditNode</code> is passed.
     */
    public native void pasteEditNodes() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "pasteEditNodes", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.pasteEditNodes();
    }-*/;

	/**
     * "Pastes" <code>editNodes</code> previously captured via {@link com.smartgwt.client.tools.EditTree#copyEditNodes
     * copyEditNodes()}. <p> New editNodes will be added as root-level nodes of the {@link
     * com.smartgwt.client.tools.EditTree#getEditNodeTree editNodeTree} unless a <code>targetEditNode</code> is passed.
     * @param targetEditNode 
     */
    public native void pasteEditNodes(EditNode targetEditNode) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "pasteEditNodes", "EditNode");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.pasteEditNodes(targetEditNode == null ? null : targetEditNode.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;
	
	/**
     * Removes all {@link com.smartgwt.client.tools.EditNode EditNodes} from the EditContext, but does not destroy  the {@link
     * com.smartgwt.client.tools.EditNode#getLiveObject liveObjects}.
     */
    public native void removeAll() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "removeAll", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.removeAll();
    }-*/;

	/**
     * Removes {@link com.smartgwt.client.tools.EditNode EditNode} from the EditContext. The editNode liveObject is not
     * destroyed.
     * @param editNode node to be removed
     */
    public native void removeNode(EditNode editNode) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "removeNode", "EditNode");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.removeNode(editNode.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;

	/**
     * Removes the specified properties from an editNode's serializable "defaults". Note that the {@link
     * com.smartgwt.client.tools.EditNode#getLiveObject liveObject} is <u>not</u> updated by this method.  To set a property to
     * null (rather than removing it), use {@link com.smartgwt.client.tools.EditTree#setNodeProperties setNodeProperties()}
     * instead.
     * @param editNode the editNode to update
     * @param properties an array of property names to remove
     * @see com.smartgwt.client.tools.EditTree#setNodeProperties
     */
    public native void removeNodeProperties(EditNode editNode, String[] properties) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "removeNodeProperties", "EditNode,String[]");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.removeNodeProperties(editNode.@com.smartgwt.client.core.DataClass::getJsObj()(), @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(properties));
    }-*/;

	/**
     * Moves an {@link com.smartgwt.client.tools.EditNode} from one child index to another in the EditContext under the
     * specified parent. <P> No changes are made to the live objects.
     * @param parentNode parent to reorder child nodes
     * @param index index within the parent's children array to be moved
     * @param moveToIndex index within the parent's children array at which to place moved node
     */
    public native void reorderNode(EditNode parentNode, Integer index, Integer moveToIndex) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "reorderNode", "EditNode,Integer,Integer");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.reorderNode(parentNode.@com.smartgwt.client.core.DataClass::getJsObj()(), index == null ? null : index.@java.lang.Integer::intValue()(), moveToIndex == null ? null : moveToIndex.@java.lang.Integer::intValue()());
    }-*/;

	/**
     * Serialize the tree of {@link com.smartgwt.client.tools.EditNode EditNodes} to an XML representation of {@link
     * com.smartgwt.client.tools.PaletteNode PaletteNodes}. The result can be supplied to  {@link
     * com.smartgwt.client.tools.EditTree#addPaletteNodesFromXML addPaletteNodesFromXML()} to recreate the EditNodes.
     *
     * @return an XML representation of PaletteNodes which can be used to                  recreate the tree of EditNodes.
     * @see com.smartgwt.client.tools.EditTree#addPaletteNodesFromXML
     */
    public native String serializeAllEditNodes() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "serializeAllEditNodes", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.serializeAllEditNodes();
        return ret;
    }-*/;

	/**
     * Serialize the tree of {@link com.smartgwt.client.tools.EditNode EditNodes} to an XML representation of {@link
     * com.smartgwt.client.tools.PaletteNode PaletteNodes}. The result can be supplied to  {@link
     * com.smartgwt.client.tools.EditTree#addPaletteNodesFromXML addPaletteNodesFromXML()} to recreate the EditNodes.
     * @param settings Additional serialization settings
     *
     * @return an XML representation of PaletteNodes which can be used to                  recreate the tree of EditNodes.
     * @see com.smartgwt.client.tools.EditTree#addPaletteNodesFromXML
     */
    public native String serializeAllEditNodes(SerializationSettings settings) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "serializeAllEditNodes", "SerializationSettings");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.serializeAllEditNodes(settings == null ? null : settings.@com.smartgwt.client.core.DataClass::getJsObj()());
        return ret;
    }-*/;
	
	/**
     * Encode the tree of {@link com.smartgwt.client.tools.EditNode EditNodes} to a JSON representation of {@link
     * com.smartgwt.client.tools.PaletteNode PaletteNodes}. The result can be supplied to  {@link
     * com.smartgwt.client.tools.EditTree#addPaletteNodesFromJSON addPaletteNodesFromJSON()} to recreate the EditNodes.
     *
     * @return a JSON representation of PaletteNodes which can be used to                  recreate the tree of EditNodes.
     * @see com.smartgwt.client.tools.EditTree#addPaletteNodesFromJSON
     */
    public native String serializeAllEditNodesAsJSON() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "serializeAllEditNodesAsJSON", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.serializeAllEditNodesAsJSON();
        return ret;
    }-*/;

	/**
     * Encode the tree of {@link com.smartgwt.client.tools.EditNode EditNodes} to a JSON representation of {@link
     * com.smartgwt.client.tools.PaletteNode PaletteNodes}. The result can be supplied to  {@link
     * com.smartgwt.client.tools.EditTree#addPaletteNodesFromJSON addPaletteNodesFromJSON()} to recreate the EditNodes.
     * @param settings Additional serialization settings
     *
     * @return a JSON representation of PaletteNodes which can be used to                  recreate the tree of EditNodes.
     * @see com.smartgwt.client.tools.EditTree#addPaletteNodesFromJSON
     */
    public native String serializeAllEditNodesAsJSON(SerializationSettings settings) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "serializeAllEditNodesAsJSON", "SerializationSettings");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.serializeAllEditNodesAsJSON(settings == null ? null : settings.@com.smartgwt.client.core.DataClass::getJsObj()());
        return ret;
    }-*/;
	
	/**
     * Serialize the provided {@link com.smartgwt.client.tools.EditNode EditNodes} to an XML representation of {@link
     * com.smartgwt.client.tools.PaletteNode PaletteNodes}. Note that the EditNodes must have been added to this EditContext.
     * The result can be supplied to {@link com.smartgwt.client.tools.EditTree#addPaletteNodesFromXML addPaletteNodesFromXML()}
     * to recreate the EditNodes.
     * @param nodes EditNodes to be serialized
     *
     * @return an XML representtion of the provided EditNodes
     */
    public native String serializeEditNodes(EditNode[] nodes) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "serializeEditNodes", "EditNode[]");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.serializeEditNodes(@com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(nodes));
        return ret;
    }-*/;

	/**
     * Serialize the provided {@link com.smartgwt.client.tools.EditNode EditNodes} to an XML representation of {@link
     * com.smartgwt.client.tools.PaletteNode PaletteNodes}. Note that the EditNodes must have been added to this EditContext.
     * The result can be supplied to {@link com.smartgwt.client.tools.EditTree#addPaletteNodesFromXML addPaletteNodesFromXML()}
     * to recreate the EditNodes.
     * @param nodes EditNodes to be serialized
     * @param settings Additional serialization settings
     *
     * @return an XML representtion of the provided EditNodes
     */
    public native String serializeEditNodes(EditNode[] nodes, SerializationSettings settings) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "serializeEditNodes", "EditNode[],SerializationSettings");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.serializeEditNodes(@com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(nodes), settings == null ? null : settings.@com.smartgwt.client.core.DataClass::getJsObj()());
        return ret;
    }-*/;
	
	/**
     * Serialize the provided {@link com.smartgwt.client.tools.EditNode EditNodes} to a JSON representation of {@link
     * com.smartgwt.client.tools.PaletteNode PaletteNodes}. Note that the EditNodes must have been added to this EditContext.
     * The result can be supplied to {@link com.smartgwt.client.tools.EditTree#addPaletteNodesFromJSON
     * addPaletteNodesFromJSON()} to recreate the EditNodes.
     * @param nodes EditNodes to be serialized
     *
     * @return a JSON representtion of the provided EditNodes
     */
    public native String serializeEditNodesAsJSON(EditNode[] nodes) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "serializeEditNodesAsJSON", "EditNode[]");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.serializeEditNodesAsJSON(@com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(nodes));
        return ret;
    }-*/;

	/**
     * Serialize the provided {@link com.smartgwt.client.tools.EditNode EditNodes} to a JSON representation of {@link
     * com.smartgwt.client.tools.PaletteNode PaletteNodes}. Note that the EditNodes must have been added to this EditContext.
     * The result can be supplied to {@link com.smartgwt.client.tools.EditTree#addPaletteNodesFromJSON
     * addPaletteNodesFromJSON()} to recreate the EditNodes.
     * @param nodes EditNodes to be serialized
     * @param settings Additional serialization settings
     *
     * @return a JSON representtion of the provided EditNodes
     */
    public native String serializeEditNodesAsJSON(EditNode[] nodes, SerializationSettings settings) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "serializeEditNodesAsJSON", "EditNode[],SerializationSettings");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.serializeEditNodesAsJSON(@com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(nodes), settings == null ? null : settings.@com.smartgwt.client.core.DataClass::getJsObj()());
        return ret;
    }-*/;
	
	/**
     * Update an editNode's serializable "defaults" with the supplied properties. If you wish to remove a property from the
     * defaults (rather than setting it to null), then use {@link com.smartgwt.client.tools.EditTree#removeNodeProperties
     * removeNodeProperties()} instead.
     * @param editNode the editNode to update
     * @param properties the properties to apply
     * @see com.smartgwt.client.tools.EditTree#removeNodeProperties
     */
    public native void setNodeProperties(EditNode editNode, Canvas properties) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "setNodeProperties", "EditNode,Canvas");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
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
     * defaults (rather than setting it to null), then use {@link com.smartgwt.client.tools.EditTree#removeNodeProperties
     * removeNodeProperties()} instead.
     * @param editNode the editNode to update
     * @param properties the properties to apply
     * @param skipLiveObjectUpdate whether to skip updating the                                         {@link
     * com.smartgwt.client.tools.EditNode#getLiveObject liveObject},                                         e.g. if you have
     * already updated the liveObject
     * @see com.smartgwt.client.tools.EditTree#removeNodeProperties
     */
    public native void setNodeProperties(EditNode editNode, Canvas properties, Boolean skipLiveObjectUpdate) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "setNodeProperties", "EditNode,Canvas,Boolean");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
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
     * @param editTreeProperties properties that should be used as new defaults when instances of this class are created
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public static native void setDefaultProperties(EditTree editTreeProperties) /*-{
        if (editTreeProperties.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Class;)(EditTree.@java.lang.Object::getClass()(), "setDefaultProperties", editTreeProperties.@java.lang.Object::getClass()());
        }
        editTreeProperties.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
    	var properties = editTreeProperties.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        properties = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(properties,true);
        $wnd.isc.EditTree.addProperties(properties);
    }-*/;

    // ***********************************************************

    /**
     * Setter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject setLogicalStructure(EditTreeLogicalStructure s) {
        super.setLogicalStructure(s);
        try {
            s.allowNestedDrops = getAttributeAsString("allowNestedDrops");
        } catch (Throwable t) {
            s.logicalStructureErrors += "EditTree.allowNestedDrops:" + t.getMessage() + "\n";
        }
        try {
            s.autoEditNewNodes = getAttributeAsString("autoEditNewNodes");
        } catch (Throwable t) {
            s.logicalStructureErrors += "EditTree.autoEditNewNodes:" + t.getMessage() + "\n";
        }
        try {
            s.canDragGroup = getAttributeAsString("canDragGroup");
        } catch (Throwable t) {
            s.logicalStructureErrors += "EditTree.canDragGroup:" + t.getMessage() + "\n";
        }
        try {
            s.canGroupSelect = getAttributeAsString("canGroupSelect");
        } catch (Throwable t) {
            s.logicalStructureErrors += "EditTree.canGroupSelect:" + t.getMessage() + "\n";
        }
        try {
            s.defaultPalette = getAttributeAsString("defaultPalette");
        } catch (Throwable t) {
            s.logicalStructureErrors += "EditTree.defaultPalette:" + t.getMessage() + "\n";
        }
        try {
            s.extraPalettes = getAttributeAsStringArray("extraPalettes");
        } catch (Throwable t) {
            s.logicalStructureErrors += "EditTree.extraPalettesArray:" + t.getMessage() + "\n";
        }
        try {
            s.hideGroupBorderOnDrag = getAttributeAsString("hideGroupBorderOnDrag");
        } catch (Throwable t) {
            s.logicalStructureErrors += "EditTree.hideGroupBorderOnDrag:" + t.getMessage() + "\n";
        }
        try {
            s.persistCoordinates = getAttributeAsString("persistCoordinates");
        } catch (Throwable t) {
            s.logicalStructureErrors += "EditTree.persistCoordinates:" + t.getMessage() + "\n";
        }
        try {
            s.rootComponent = getRootComponent();
        } catch (Throwable t) {
            s.logicalStructureErrors += "EditTree.rootComponent:" + t.getMessage() + "\n";
        }
        try {
            s.selectedBorder = getAttributeAsString("selectedBorder");
        } catch (Throwable t) {
            s.logicalStructureErrors += "EditTree.selectedBorder:" + t.getMessage() + "\n";
        }
        try {
            s.selectedLabelBackgroundColor = getAttributeAsString("selectedLabelBackgroundColor");
        } catch (Throwable t) {
            s.logicalStructureErrors += "EditTree.selectedLabelBackgroundColor:" + t.getMessage() + "\n";
        }
        try {
            s.showSelectedLabel = getAttributeAsString("showSelectedLabel");
        } catch (Throwable t) {
            s.logicalStructureErrors += "EditTree.showSelectedLabel:" + t.getMessage() + "\n";
        }
        try {
            s.useCopyPasteShortcuts = getAttributeAsString("useCopyPasteShortcuts");
        } catch (Throwable t) {
            s.logicalStructureErrors += "EditTree.useCopyPasteShortcuts:" + t.getMessage() + "\n";
        }
        return s;
    }

    /**
     * Getter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject getLogicalStructure() {
        EditTreeLogicalStructure s = new EditTreeLogicalStructure();
        setLogicalStructure(s);
        return s;
    }
}
