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
 * onto an EditPane from a Palette will add an EditNode created from the dragged PaletteNode. <P> EditPane supports the
 * {@link com.smartgwt.client.tools.EditContext} public API although it is not an EditContext. The properties and method
 * calls are passed through to the EditContext instance.
 * @see com.smartgwt.client.docs.DevTools DevTools overview and related methods
 */
@BeanFactory.FrameworkClass
@BeanFactory.ScClassName("EditPane")
public class EditPane extends Canvas {

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
     * Can components be dropped into other components which support nesting? This mode is enabled unless explicitly disabled.
     *
     * @param allowNestedDrops  Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
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
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setAutoEditNewNodes(Boolean autoEditNewNodes)  throws IllegalStateException {
        setAttribute("autoEditNewNodes", autoEditNewNodes, false);
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
     * @throws IllegalStateException this property cannot be changed after the component has been created
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
     * An EditContext is automatically created to manage EditMode behavior. The public EditContext APIs exposed by the EditPane
     * are passed through to this object. <p> Additional <code>editContext</code> properties can be supplied as {@link
     * com.smartgwt.client.tools.EditPane#getEditContextProperties editContextProperties}.
     * <p>
     * For an overview of how to use and configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Returns the {@link com.smartgwt.client.tools.EditContext} instance managed by the EditPane.
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public EditContext getEditContext() throws IllegalStateException {
        errorIfNotCreated("editContext");
        return EditContext.getOrCreateRef(getAttributeAsJavaScriptObject("editContext"));
    }
    

    /**
     * Properties to be applied to the {@link com.smartgwt.client.tools.EditPane#getEditContext editContext} when created.
     *
     * @param editContextProperties  Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setEditContextProperties(EditContext editContextProperties)  throws IllegalStateException {
        JavaScriptObject config = editContextProperties == null ? null : editContextProperties.getConfig();
        setAttribute("editContextProperties", JSOHelper.cleanProperties(config, true), false);
    }

    /**
     * Properties to be applied to the {@link com.smartgwt.client.tools.EditPane#getEditContext editContext} when created.
     *
     * @return EditContext
     */
    public EditContext getEditContextProperties()  {
        return EditContext.getOrCreateRef(getAttributeAsJavaScriptObject("editContextProperties"));
    }
    

    /**
     * Additional {@link com.smartgwt.client.tools.Palette Palettes} to consult for metadata when deserializing {@link
     * com.smartgwt.client.tools.EditNode Edit Nodes}. Note that the {@link
     * com.smartgwt.client.tools.EditPane#getDefaultPalette defaultPalette} is always consulted and need not be provided again
     * here.
     *
     * @param extraPalettes  Default value is null
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
     * com.smartgwt.client.tools.EditPane#getDefaultPalette defaultPalette} is always consulted and need not be provided again
     * here.
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
     * @throws IllegalStateException this property cannot be changed after the component has been created
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
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setPersistCoordinates(Boolean persistCoordinates)  throws IllegalStateException {
        setAttribute("persistCoordinates", persistCoordinates, false);
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
     * node. <P> Can be retrieved at any time. Use {@link com.smartgwt.client.tools.EditPane#getRootEditNode
     * EditPane.getRootEditNode} to retrieve the {@link com.smartgwt.client.tools.EditNode} created from the rootComponent.
     *
     * @param rootComponent  Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.DevTools DevTools overview and related methods
     */
    public void setRootComponent(Record rootComponent)  throws IllegalStateException {
        setAttribute("rootComponent", rootComponent.getJsObj(), false);
    }

    /**
     * Root of data to edit.  Must contain the "type" property, with the name of a valid {@link
     * com.smartgwt.client.data.DataSource schema} or nothing will be able to be dropped on this EditContext. A "liveObject"
     * property representing the rootComponent is also suggested. Otherwise, a live object will be created from the palette
     * node. <P> Can be retrieved at any time. Use {@link com.smartgwt.client.tools.EditPane#getRootEditNode
     * EditPane.getRootEditNode} to retrieve the {@link com.smartgwt.client.tools.EditNode} created from the rootComponent.
     *
     * @return Record
     * @see com.smartgwt.client.docs.DevTools DevTools overview and related methods
     */
    public Record getRootComponent()  {
        return Record.getOrCreateRef(getAttributeAsJavaScriptObject("rootComponent"));
    }
    

    /**
     * Set the CSS border to be applied to the selection outline of the selected components. This property is used when {@link
     * com.smartgwt.client.tools.EditProxy#getSelectedAppearance selectedAppearance} is <code>outlineMask</code> or
     * <code>outlineEdges</code>. <P> This value is applied as a default to {@link
     * com.smartgwt.client.tools.EditProxy#getSelectedBorder selectedBorder}.
     *
     * @param selectedBorder  Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
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
     * @throws IllegalStateException this property cannot be changed after the component has been created
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
     * Should the selection outline show a label for selected components? A component may also be highlighted with the
     * selection outline and label to indicate the target of a drop. To suppress showing a label at any time set this property
     * to <code>false</code>. <P> To suppress labels during selection but still show them when targeted for a drop, see {@link
     * com.smartgwt.client.tools.EditContext#getShowSelectedLabelOnSelect showSelectedLabelOnSelect}. <P> NOTE: A selected
     * component label is only supported when {@link com.smartgwt.client.tools.EditProxy#getSelectedAppearance
     * selectedAppearance} is "outlineEdges".
     *
     * @param showSelectedLabel  Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
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
    

    // ********************* Methods ***********************


	/**
     * Creates a new EditNode from a PaletteNode, using the {@link com.smartgwt.client.tools.EditPane#getDefaultPalette
     * defaultPalette}.  If you have an array of possibly inter-related PaletteNodes, then you should use {@link
     * com.smartgwt.client.tools.EditPane#addFromPaletteNodes addFromPaletteNodes()} on the array instead, in order to preserve
     * the relationships.
     * @param paletteNode the palette node to use to create the new node
     *
     * @return the EditNode created from the paletteNode
     * @see com.smartgwt.client.tools.EditPane#addFromPaletteNodes
     */
    public native EditNode addFromPaletteNode(PaletteNode paletteNode) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.addFromPaletteNode(paletteNode.@com.smartgwt.client.core.DataClass::getJsObj()());
        if(ret == null) return null;
        return @com.smartgwt.client.tools.EditNode::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;


	/**
     * Creates a new EditNode from a PaletteNode, using the {@link com.smartgwt.client.tools.EditPane#getDefaultPalette
     * defaultPalette}.  If you have an array of possibly inter-related PaletteNodes, then you should use {@link
     * com.smartgwt.client.tools.EditPane#addFromPaletteNodes addFromPaletteNodes()} on the array instead, in order to preserve
     * the relationships.
     * @param paletteNode the palette node to use to create the new node
     * @param parentNode optional the parent node if the new node should appear                                under a specific parent
     *
     * @return the EditNode created from the paletteNode
     * @see com.smartgwt.client.tools.EditPane#addFromPaletteNodes
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
     * com.smartgwt.client.tools.EditPane#serializeAllEditNodes serializeAllEditNodes()}, rather than calling {@link
     * com.smartgwt.client.tools.EditPane#addFromPaletteNode addFromPaletteNode()} on each individual PaletteNode.
     * @param paletteNodes array of PaletteNodes
     *
     * @return an array of the EditNodes added to the parentNode
     * @see com.smartgwt.client.tools.EditPane#addFromPaletteNode
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
     * com.smartgwt.client.tools.EditPane#serializeAllEditNodes serializeAllEditNodes()}, rather than calling {@link
     * com.smartgwt.client.tools.EditPane#addFromPaletteNode addFromPaletteNode()} on each individual PaletteNode.
     * @param paletteNodes array of PaletteNodes
     * @param parentNode parent to add to (defaults to the root)
     *
     * @return an array of the EditNodes added to the parentNode
     * @see com.smartgwt.client.tools.EditPane#addFromPaletteNode
     */
    public native EditNode[] addFromPaletteNodes(PaletteNode[] paletteNodes, EditNode parentNode) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
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
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.addNode(newNode.@com.smartgwt.client.core.DataClass::getJsObj()());
        if(ret == null) return null;
        return @com.smartgwt.client.tools.EditNode::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;


    /**
     * @see EditPane#addNode
     */
    public EditNode addNode(EditNode newNode, EditNode parentNode){
        return addNode(newNode, parentNode, (Integer) null, null, null);
    }

    /**
     * @see EditPane#addNode
     */
    public EditNode addNode(EditNode newNode, EditNode parentNode, Integer index){
        return addNode(newNode, parentNode, index, null, null);
    }

    /**
     * @see EditPane#addNode
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
     * @see EditPane#addPaletteNodesFromJS
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
     * com.smartgwt.client.tools.EditPane#serializeAllEditNodesAsJSON EditPane.serializeAllEditNodesAsJSON} or {@link
     * com.smartgwt.client.tools.EditPane#serializeEditNodesAsJSON EditPane.serializeEditNodesAsJSON}. <P> By default,
     * components that have {@link com.smartgwt.client.widgets.Canvas#getID global IDs} will not actually be allowed to take
     * those global IDs - instead, only widgets that have one of the global IDs passed as the <code>globals</code> parameter
     * will actually receive their global IDs.  To override this behavior, pass the special value {@link
     * com.smartgwt.client.rpc.RPCManager#ALL_GLOBALS ALL_GLOBALS} for the <code>globals</code> parameter.
     * @param jsonString JSON string
     * @see com.smartgwt.client.tools.EditPane#serializeAllEditNodesAsJSON
     * @see com.smartgwt.client.tools.EditPane#serializeEditNodesAsJSON
     */
    public native void addPaletteNodesFromJSON(String jsonString) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.addPaletteNodesFromJSON(jsonString);
    }-*/;


    /**
     * @see EditPane#addPaletteNodesFromJSON
     */
    public void addPaletteNodesFromJSON(String jsonString, EditNode parentNode){
        addPaletteNodesFromJSON(jsonString, parentNode, null, null);
    }

    /**
     * @see EditPane#addPaletteNodesFromJSON
     */
    public void addPaletteNodesFromJSON(String jsonString, EditNode parentNode, String[] globals){
        addPaletteNodesFromJSON(jsonString, parentNode, globals, null);
    }

	/**
     * Recreate {@link com.smartgwt.client.tools.EditNode EditNodes} from a JSON representation of  {@link
     * com.smartgwt.client.tools.PaletteNode PaletteNodes} (possibly created by calling {@link
     * com.smartgwt.client.tools.EditPane#serializeAllEditNodesAsJSON EditPane.serializeAllEditNodesAsJSON} or {@link
     * com.smartgwt.client.tools.EditPane#serializeEditNodesAsJSON EditPane.serializeEditNodesAsJSON}. <P> By default,
     * components that have {@link com.smartgwt.client.widgets.Canvas#getID global IDs} will not actually be allowed to take
     * those global IDs - instead, only widgets that have one of the global IDs passed as the <code>globals</code> parameter
     * will actually receive their global IDs.  To override this behavior, pass the special value {@link
     * com.smartgwt.client.rpc.RPCManager#ALL_GLOBALS ALL_GLOBALS} for the <code>globals</code> parameter.
     * @param jsonString JSON string
     * @param parentNode parent node (defaults to the root)
     * @param globals widgets to allow to take their global IDs
     * @param callback Callback to fire after nodes have been added
     * @see com.smartgwt.client.tools.EditPane#serializeAllEditNodesAsJSON
     * @see com.smartgwt.client.tools.EditPane#serializeEditNodesAsJSON
     */
    public native void addPaletteNodesFromJSON(String jsonString, EditNode parentNode, String[] globals, Function callback) /*-{
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
     * com.smartgwt.client.tools.EditPane#serializeAllEditNodes EditPane.serializeAllEditNodes} or {@link
     * com.smartgwt.client.tools.EditPane#serializeEditNodes EditPane.serializeEditNodes}. <P> By default, components that have
     * {@link com.smartgwt.client.widgets.Canvas#getID global IDs} will not actually be allowed to take those global IDs -
     * instead, only widgets that have one of the global IDs passed as the <code>globals</code> parameter will actually receive
     * their global IDs.  To override this behavior, pass the special value {@link
     * com.smartgwt.client.rpc.RPCManager#ALL_GLOBALS ALL_GLOBALS} for the <code>globals</code> parameter.
     * @param xmlString XML string
     * @see com.smartgwt.client.tools.EditPane#serializeAllEditNodes
     * @see com.smartgwt.client.tools.EditPane#serializeEditNodes
     */
    public native void addPaletteNodesFromXML(String xmlString) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.addPaletteNodesFromXML(xmlString);
    }-*/;


    /**
     * @see EditPane#addPaletteNodesFromXML
     */
    public void addPaletteNodesFromXML(String xmlString, EditNode parentNode){
        addPaletteNodesFromXML(xmlString, parentNode, null, null);
    }

    /**
     * @see EditPane#addPaletteNodesFromXML
     */
    public void addPaletteNodesFromXML(String xmlString, EditNode parentNode, String[] globals){
        addPaletteNodesFromXML(xmlString, parentNode, globals, null);
    }

	/**
     * Recreate {@link com.smartgwt.client.tools.EditNode EditNodes} from an XML representation of  {@link
     * com.smartgwt.client.tools.PaletteNode PaletteNodes} (possibly created by calling {@link
     * com.smartgwt.client.tools.EditPane#serializeAllEditNodes EditPane.serializeAllEditNodes} or {@link
     * com.smartgwt.client.tools.EditPane#serializeEditNodes EditPane.serializeEditNodes}. <P> By default, components that have
     * {@link com.smartgwt.client.widgets.Canvas#getID global IDs} will not actually be allowed to take those global IDs -
     * instead, only widgets that have one of the global IDs passed as the <code>globals</code> parameter will actually receive
     * their global IDs.  To override this behavior, pass the special value {@link
     * com.smartgwt.client.rpc.RPCManager#ALL_GLOBALS ALL_GLOBALS} for the <code>globals</code> parameter.
     * @param xmlString XML string
     * @param parentNode parent node (defaults to the root)
     * @param globals widgets to allow to take their global IDs
     * @param callback Callback to fire after nodes have been added
     * @see com.smartgwt.client.tools.EditPane#serializeAllEditNodes
     * @see com.smartgwt.client.tools.EditPane#serializeEditNodes
     */
    public native void addPaletteNodesFromXML(String xmlString, EditNode parentNode, String[] globals, Function callback) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.addPaletteNodesFromXML(xmlString, parentNode == null ? null : parentNode.@com.smartgwt.client.core.DataClass::getJsObj()(), @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(globals), 
			$entry( function() { 
				if(callback!=null) callback.@com.smartgwt.client.core.Function::execute()(
				);
			}));
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
     * Enable edit mode for an {@link com.smartgwt.client.tools.EditNode}. This is a shortcut for calling {@link
     * com.smartgwt.client.widgets.Canvas#setEditMode Canvas.setEditMode}.
     * @param editNode the EditNode on which to enable editing
     * @see com.smartgwt.client.widgets.Canvas#setEditMode
     * @see com.smartgwt.client.tools.EditPane#isNodeEditingOn
     */
    public native void enableEditing(EditNode editNode) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.enableEditing(editNode.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;




	/**
     * Obtain {@link com.smartgwt.client.tools.PaletteNode PaletteNodes} from an XML representation, but do not add them to the
     * EditContext.
     * @param xmlString XML string
     * @param callback Callback used to return the PaletteNodes
     * @see com.smartgwt.client.tools.EditPane#serializeAllEditNodes
     * @see com.smartgwt.client.tools.EditPane#serializeEditNodes
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
     * Returns the root {@link com.smartgwt.client.tools.EditNode} of the EditContext typically created from {@link
     * com.smartgwt.client.tools.EditPane#getRootComponent rootComponent}.
     *
     * @return the root EditNode
     */
    public native EditNode getRootEditNode() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getRootEditNode();
        if(ret == null) return null;
        return @com.smartgwt.client.tools.EditNode::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

	/**
     * Returns an Array of {@link com.smartgwt.client.tools.PaletteNode}s representing all current {@link
     * com.smartgwt.client.tools.EditNode}s in this pane, suitable for saving and restoring via passing each paletteNode to
     * {@link com.smartgwt.client.tools.EditContext#addNode addNode()}.
     *
     * @return paletteNodes suitable for saving for subsequent restoration
     * @see com.smartgwt.client.tools.EditContext#serializeAllEditNodes
     * @see com.smartgwt.client.tools.EditContext#serializeAllEditNodesAsJSON
     */
    public native PaletteNode[] getSaveData() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getSaveData();
        if(ret == null) return null;
        return @com.smartgwt.client.util.ConvertTo::arrayOfPaletteNode(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;



	/**
     * Returns true if <code>editNode</code> is in edit mode.
     * @param editNode the EditNode
     *
     * @return true if node is in edit mode
     */
    public native boolean isNodeEditingOn(EditNode editNode) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.isNodeEditingOn(editNode.@com.smartgwt.client.core.DataClass::getJsObj()());
        return ret;
    }-*/;




	/**
     * Creates and returns an EditNode using the {@link com.smartgwt.client.tools.EditPane#getDefaultPalette defaultPalette}. 
     * Does not add the newly created EditNode to the EditContext.
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
     * Removes {@link com.smartgwt.client.tools.EditNode EditNode} from the EditContext. The editNode liveObject is not
     * destroyed.
     * @param editNode node to be removed
     */
    public native void removeNode(EditNode editNode) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.removeNode(editNode.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;




	/**
     * Removes the specified properties from an editNode's serializable "defaults". Note that the {@link
     * com.smartgwt.client.tools.EditNode#getLiveObject liveObject} is <u>not</u> updated by this method.  To set a property to
     * null (rather than removing it), use {@link com.smartgwt.client.tools.EditPane#setNodeProperties setNodeProperties()}
     * instead.
     * @param editNode the editNode to update
     * @param properties an array of property names to remove
     * @see com.smartgwt.client.tools.EditPane#setNodeProperties
     */
    public native void removeNodeProperties(EditNode editNode, String[] properties) /*-{
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
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.reorderNode(parentNode.@com.smartgwt.client.core.DataClass::getJsObj()(), index == null ? null : index.@java.lang.Integer::intValue()(), moveToIndex == null ? null : moveToIndex.@java.lang.Integer::intValue()());
    }-*/;


	/**
     * Serialize the tree of {@link com.smartgwt.client.tools.EditNode EditNodes} to an XML representation of {@link
     * com.smartgwt.client.tools.PaletteNode PaletteNodes}. The result can be supplied to  {@link
     * com.smartgwt.client.tools.EditPane#addPaletteNodesFromXML addPaletteNodesFromXML()} to recreate the EditNodes.
     *
     * @return an XML representation of PaletteNodes which can be used to                  recreate the tree of EditNodes.
     * @see com.smartgwt.client.tools.EditPane#addPaletteNodesFromXML
     */
    public native String serializeAllEditNodes() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.serializeAllEditNodes();
        return ret;
    }-*/;

	/**
     * Serialize the tree of {@link com.smartgwt.client.tools.EditNode EditNodes} to an XML representation of {@link
     * com.smartgwt.client.tools.PaletteNode PaletteNodes}. The result can be supplied to  {@link
     * com.smartgwt.client.tools.EditPane#addPaletteNodesFromXML addPaletteNodesFromXML()} to recreate the EditNodes.
     * @param settings Additional serialization settings
     *
     * @return an XML representation of PaletteNodes which can be used to                  recreate the tree of EditNodes.
     * @see com.smartgwt.client.tools.EditPane#addPaletteNodesFromXML
     */
    public native String serializeAllEditNodes(SerializationSettings settings) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.serializeAllEditNodes(settings == null ? null : settings.@com.smartgwt.client.core.DataClass::getJsObj()());
        return ret;
    }-*/;
	
	/**
     * Encode the tree of {@link com.smartgwt.client.tools.EditNode EditNodes} to a JSON representation of {@link
     * com.smartgwt.client.tools.PaletteNode PaletteNodes}. The result can be supplied to  {@link
     * com.smartgwt.client.tools.EditPane#addPaletteNodesFromJSON addPaletteNodesFromJSON()} to recreate the EditNodes.
     *
     * @return a JSON representation of PaletteNodes which can be used to                  recreate the tree of EditNodes.
     * @see com.smartgwt.client.tools.EditPane#addPaletteNodesFromJSON
     */
    public native String serializeAllEditNodesAsJSON() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.serializeAllEditNodesAsJSON();
        return ret;
    }-*/;

	/**
     * Encode the tree of {@link com.smartgwt.client.tools.EditNode EditNodes} to a JSON representation of {@link
     * com.smartgwt.client.tools.PaletteNode PaletteNodes}. The result can be supplied to  {@link
     * com.smartgwt.client.tools.EditPane#addPaletteNodesFromJSON addPaletteNodesFromJSON()} to recreate the EditNodes.
     * @param settings Additional serialization settings
     *
     * @return a JSON representation of PaletteNodes which can be used to                  recreate the tree of EditNodes.
     * @see com.smartgwt.client.tools.EditPane#addPaletteNodesFromJSON
     */
    public native String serializeAllEditNodesAsJSON(SerializationSettings settings) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.serializeAllEditNodesAsJSON(settings == null ? null : settings.@com.smartgwt.client.core.DataClass::getJsObj()());
        return ret;
    }-*/;
	


	/**
     * Serialize the provided {@link com.smartgwt.client.tools.EditNode EditNodes} to an XML representation of {@link
     * com.smartgwt.client.tools.PaletteNode PaletteNodes}. Note that the EditNodes must have been added to this EditContext.
     * The result can be supplied to {@link com.smartgwt.client.tools.EditPane#addPaletteNodesFromXML addPaletteNodesFromXML()}
     * to recreate the EditNodes.
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
     * The result can be supplied to {@link com.smartgwt.client.tools.EditPane#addPaletteNodesFromXML addPaletteNodesFromXML()}
     * to recreate the EditNodes.
     * @param nodes EditNodes to be serialized
     * @param settings Additional serialization settings
     *
     * @return an XML representtion of the provided EditNodes
     */
    public native String serializeEditNodes(EditNode[] nodes, SerializationSettings settings) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.serializeEditNodes(@com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(nodes), settings == null ? null : settings.@com.smartgwt.client.core.DataClass::getJsObj()());
        return ret;
    }-*/;
	


	/**
     * Serialize the provided {@link com.smartgwt.client.tools.EditNode EditNodes} to a JSON representation of {@link
     * com.smartgwt.client.tools.PaletteNode PaletteNodes}. Note that the EditNodes must have been added to this EditContext.
     * The result can be supplied to {@link com.smartgwt.client.tools.EditPane#addPaletteNodesFromJSON
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
     * The result can be supplied to {@link com.smartgwt.client.tools.EditPane#addPaletteNodesFromJSON
     * addPaletteNodesFromJSON()} to recreate the EditNodes.
     * @param nodes EditNodes to be serialized
     * @param settings Additional serialization settings
     *
     * @return a JSON representtion of the provided EditNodes
     */
    public native String serializeEditNodesAsJSON(EditNode[] nodes, SerializationSettings settings) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.serializeEditNodesAsJSON(@com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(nodes), settings == null ? null : settings.@com.smartgwt.client.core.DataClass::getJsObj()());
        return ret;
    }-*/;
	


	/**
     * Update an editNode's serializable "defaults" with the supplied properties. If you wish to remove a property from the
     * defaults (rather than setting it to null), then use {@link com.smartgwt.client.tools.EditPane#removeNodeProperties
     * removeNodeProperties()} instead.
     * @param editNode the editNode to update
     * @param properties the properties to apply
     * @see com.smartgwt.client.tools.EditPane#removeNodeProperties
     */
    public native void setNodeProperties(EditNode editNode, Canvas properties) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setNodeProperties(editNode.@com.smartgwt.client.core.DataClass::getJsObj()(), properties.@com.smartgwt.client.widgets.BaseWidget::getConfig()());
    }-*/;


	/**
     * Update an editNode's serializable "defaults" with the supplied properties. If you wish to remove a property from the
     * defaults (rather than setting it to null), then use {@link com.smartgwt.client.tools.EditPane#removeNodeProperties
     * removeNodeProperties()} instead.
     * @param editNode the editNode to update
     * @param properties the properties to apply
     * @param skipLiveObjectUpdate whether to skip updating the                                         {@link
     * com.smartgwt.client.tools.EditNode#getLiveObject liveObject},                                         e.g. if you have
     * already updated the liveObject
     * @see com.smartgwt.client.tools.EditPane#removeNodeProperties
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
        try {
            s.allowNestedDrops = getAttributeAsString("allowNestedDrops");
        } catch (Throwable t) {
            s.logicalStructureErrors += "EditPane.allowNestedDrops:" + t.getMessage() + "\n";
        }
        try {
            s.autoEditNewNodes = getAttributeAsString("autoEditNewNodes");
        } catch (Throwable t) {
            s.logicalStructureErrors += "EditPane.autoEditNewNodes:" + t.getMessage() + "\n";
        }
        try {
            s.canDragGroup = getAttributeAsString("canDragGroup");
        } catch (Throwable t) {
            s.logicalStructureErrors += "EditPane.canDragGroup:" + t.getMessage() + "\n";
        }
        try {
            s.canGroupSelect = getAttributeAsString("canGroupSelect");
        } catch (Throwable t) {
            s.logicalStructureErrors += "EditPane.canGroupSelect:" + t.getMessage() + "\n";
        }
        try {
            s.defaultPalette = getAttributeAsString("defaultPalette");
        } catch (Throwable t) {
            s.logicalStructureErrors += "EditPane.defaultPalette:" + t.getMessage() + "\n";
        }
        try {
            s.editContextProperties = getAttributeAsString("editContextProperties");
        } catch (Throwable t) {
            s.logicalStructureErrors += "EditPane.editContextProperties:" + t.getMessage() + "\n";
        }
        try {
            s.extraPalettes = getAttributeAsStringArray("extraPalettes");
        } catch (Throwable t) {
            s.logicalStructureErrors += "EditPane.extraPalettesArray:" + t.getMessage() + "\n";
        }
        try {
            s.hideGroupBorderOnDrag = getAttributeAsString("hideGroupBorderOnDrag");
        } catch (Throwable t) {
            s.logicalStructureErrors += "EditPane.hideGroupBorderOnDrag:" + t.getMessage() + "\n";
        }
        try {
            s.persistCoordinates = getAttributeAsString("persistCoordinates");
        } catch (Throwable t) {
            s.logicalStructureErrors += "EditPane.persistCoordinates:" + t.getMessage() + "\n";
        }
        try {
            s.rootComponent = getRootComponent();
        } catch (Throwable t) {
            s.logicalStructureErrors += "EditPane.rootComponent:" + t.getMessage() + "\n";
        }
        try {
            s.selectedBorder = getAttributeAsString("selectedBorder");
        } catch (Throwable t) {
            s.logicalStructureErrors += "EditPane.selectedBorder:" + t.getMessage() + "\n";
        }
        try {
            s.selectedLabelBackgroundColor = getAttributeAsString("selectedLabelBackgroundColor");
        } catch (Throwable t) {
            s.logicalStructureErrors += "EditPane.selectedLabelBackgroundColor:" + t.getMessage() + "\n";
        }
        try {
            s.showSelectedLabel = getAttributeAsString("showSelectedLabel");
        } catch (Throwable t) {
            s.logicalStructureErrors += "EditPane.showSelectedLabel:" + t.getMessage() + "\n";
        }
        return s;
    }

    public LogicalStructureObject getLogicalStructure() {
        EditPaneLogicalStructure s = new EditPaneLogicalStructure();
        setLogicalStructure(s);
        return s;
    }
}

