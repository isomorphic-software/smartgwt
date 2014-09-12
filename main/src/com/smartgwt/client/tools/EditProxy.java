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
 * An EditProxy is attached to an editable component when editMode is enabled. This proxy has methods and properties which
 * affect the component during editing.
 * @see com.smartgwt.client.docs.DevTools DevTools overview and related methods
 */
@BeanFactory.FrameworkClass
@BeanFactory.ScClassName("EditProxy")
public class EditProxy extends BaseClass {

    public static EditProxy getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        BaseClass obj = BaseClass.getRef(jsObj);
        if(obj != null) {
            return (EditProxy) obj;
        } else {
            return new EditProxy(jsObj);
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


    public EditProxy(){
        scClassName = "EditProxy";
    }

    public EditProxy(JavaScriptObject jsObj){
        scClassName = "EditProxy";
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
     * When child nodes are added to an EditContext, should they be masked by setting {@link
     * com.smartgwt.client.tools.EditNode#getUseEditMask useEditMask} <code>true</code> if not explicitly set?
     *
     * @param autoMaskChildren  Default value is null
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setAutoMaskChildren(Boolean autoMaskChildren)  throws IllegalStateException {
        setAttribute("autoMaskChildren", autoMaskChildren, false);
    }

    /**
     * When child nodes are added to an EditContext, should they be masked by setting {@link
     * com.smartgwt.client.tools.EditNode#getUseEditMask useEditMask} <code>true</code> if not explicitly set?
     *
     * @return Boolean
     */
    public Boolean getAutoMaskChildren()  {
        return getAttributeAsBoolean("autoMaskChildren");
    }
    

    /**
     * Should component be brought to front when selected? Applies when {@link
     * com.smartgwt.client.tools.EditNode#getUseEditMask useEditMask}:true.
     *
     * @param bringToFrontOnSelect  Default value is null
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setBringToFrontOnSelect(Boolean bringToFrontOnSelect)  throws IllegalStateException {
        setAttribute("bringToFrontOnSelect", bringToFrontOnSelect, false);
    }

    /**
     * Should component be brought to front when selected? Applies when {@link
     * com.smartgwt.client.tools.EditNode#getUseEditMask useEditMask}:true.
     *
     * @return Boolean
     */
    public Boolean getBringToFrontOnSelect()  {
        return getAttributeAsBoolean("bringToFrontOnSelect");
    }
    

    /**
     * Can this component be selected? Selection is allowed unless this property is set to <code>false</code>.
     *
     * @param canSelect  Default value is null
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setCanSelect(Boolean canSelect)  throws IllegalStateException {
        setAttribute("canSelect", canSelect, false);
    }

    /**
     * Can this component be selected? Selection is allowed unless this property is set to <code>false</code>.
     *
     * @return Boolean
     */
    public Boolean getCanSelect()  {
        return getAttributeAsBoolean("canSelect");
    }
    

    /**
     * Should Canvas-based component selection be used for component selection, positioning and resizing? Individual components
     * can disallow selection by setting {@link com.smartgwt.client.tools.EditProxy#getCanSelect canSelect} <code>false</code>.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Setter for {@link com.smartgwt.client.tools.EditProxy#getCanSelectChildren canSelectChildren}.
     *
     * @param canSelectChildren the new canSelectChildren. Default value is false
     */
    public void setCanSelectChildren(Boolean canSelectChildren) {
        setAttribute("canSelectChildren", canSelectChildren, true);
    }

    /**
     * Should Canvas-based component selection be used for component selection, positioning and resizing? Individual components
     * can disallow selection by setting {@link com.smartgwt.client.tools.EditProxy#getCanSelect canSelect} <code>false</code>.
     *
     * @return Boolean
     */
    public Boolean getCanSelectChildren()  {
        Boolean result = getAttributeAsBoolean("canSelectChildren");
        return result == null ? false : result;
    }
    

    /**
     * If not null the {@link com.smartgwt.client.widgets.Canvas#getChildrenSnapResizeToGrid childrenSnapResizeToGrid} on the
     * component represented by this EditProxy is set to this value only while in edit mode. This allows snapResizeToGrid
     * functionality to be enforced during edit mode but not when live.
     *
     * @param childrenSnapResizeToGrid  Default value is null
     */
    public void setChildrenSnapResizeToGrid(Boolean childrenSnapResizeToGrid) {
        setAttribute("childrenSnapResizeToGrid", childrenSnapResizeToGrid, true);
    }

    /**
     * If not null the {@link com.smartgwt.client.widgets.Canvas#getChildrenSnapResizeToGrid childrenSnapResizeToGrid} on the
     * component represented by this EditProxy is set to this value only while in edit mode. This allows snapResizeToGrid
     * functionality to be enforced during edit mode but not when live.
     *
     * @return Boolean
     */
    public Boolean getChildrenSnapResizeToGrid()  {
        return getAttributeAsBoolean("childrenSnapResizeToGrid");
    }
    

    /**
     * If not null the {@link com.smartgwt.client.widgets.Canvas#getChildrenSnapToGrid childrenSnapToGrid} on the component
     * represented by this EditProxy is set to this value only while in edit mode. This allows snapToGrid functionality to be
     * enforced during edit mode but not when live.
     *
     * @param childrenSnapToGrid  Default value is null
     */
    public void setChildrenSnapToGrid(Boolean childrenSnapToGrid) {
        setAttribute("childrenSnapToGrid", childrenSnapToGrid, true);
    }

    /**
     * If not null the {@link com.smartgwt.client.widgets.Canvas#getChildrenSnapToGrid childrenSnapToGrid} on the component
     * represented by this EditProxy is set to this value only while in edit mode. This allows snapToGrid functionality to be
     * enforced during edit mode but not when live.
     *
     * @return Boolean
     */
    public Boolean getChildrenSnapToGrid()  {
        return getAttributeAsBoolean("childrenSnapToGrid");
    }
    

    /**
     * An editMask is created for any component placed into editMode with {@link
     * com.smartgwt.client.tools.EditNode#getUseEditMask useEditMask}:true. <P> Common customization properties can be provided
     * by {@link com.smartgwt.client.tools.EditContext#getEditMaskProperties editMaskProperties}.
     * <p>
     * For an overview of how to use and configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Canvas
     * @throws IllegalStateException if the underlying component has not yet been created.
     */
    public Canvas getEditMask() throws IllegalStateException {
        errorIfNotCreated("editMask");
        return (Canvas)Canvas.getByJSObject(getAttributeAsJavaScriptObject("editMask"));
    }
    

    /**
     * Hoop selector canvas used for selecting multiple components. <P> Common customization properties can be provided by
     * {@link com.smartgwt.client.tools.EditContext#getHoopSelectorProperties hoopSelectorProperties}.
     * <p>
     * For an overview of how to use and configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Canvas
     * @throws IllegalStateException if the underlying component has not yet been created.
     */
    public Canvas getHoopSelector() throws IllegalStateException {
        errorIfNotCreated("hoopSelector");
        return (Canvas)Canvas.getByJSObject(getAttributeAsJavaScriptObject("hoopSelector"));
    }
    

    /**
     * Event that triggers inline editing, showing the {@link com.smartgwt.client.tools.EditProxy#getInlineEditForm
     * inlineEditForm}, which consists of a single text input (single or multi-line according to {@link
     * com.smartgwt.client.tools.EditProxy#getInlineEditMultiline inlineEditMultiline}) shown in the {@link
     * com.smartgwt.client.tools.EditProxy#getInlineEditForm inlineEditForm} AutoChild. <p> The initial value in the form comes
     * from {@link com.smartgwt.client.tools.EditProxy#getInlineEditText EditProxy.getInlineEditText} and is applied via {@link
     * com.smartgwt.client.tools.EditProxy#setInlineEditText EditProxy.setInlineEditText}. <p> Many EditProxy subclasses have
     * built-in modes for inline editing.
     *
     * @param inlineEditEvent  Default value is null
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setInlineEditEvent(InlineEditEvent inlineEditEvent)  throws IllegalStateException {
        setAttribute("inlineEditEvent", inlineEditEvent == null ? null : inlineEditEvent.getValue(), false);
    }

    /**
     * Event that triggers inline editing, showing the {@link com.smartgwt.client.tools.EditProxy#getInlineEditForm
     * inlineEditForm}, which consists of a single text input (single or multi-line according to {@link
     * com.smartgwt.client.tools.EditProxy#getInlineEditMultiline inlineEditMultiline}) shown in the {@link
     * com.smartgwt.client.tools.EditProxy#getInlineEditForm inlineEditForm} AutoChild. <p> The initial value in the form comes
     * from {@link com.smartgwt.client.tools.EditProxy#getInlineEditText EditProxy.getInlineEditText} and is applied via {@link
     * com.smartgwt.client.tools.EditProxy#setInlineEditText EditProxy.setInlineEditText}. <p> Many EditProxy subclasses have
     * built-in modes for inline editing.
     *
     * @return InlineEditEvent
     */
    public InlineEditEvent getInlineEditEvent()  {
        return EnumUtil.getEnum(InlineEditEvent.values(), getAttribute("inlineEditEvent"));
    }
    

    /**
     * <b>Note :</b> This API is non-functional (always returns null) and exists only to make
     * you aware that this MultiAutoChild exists.  See {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}
     * for details.
     * <p>
     * See {@link com.smartgwt.client.tools.EditProxy#getInlineEditEvent inlineEditEvent}.
     *
     * @return null
     */
    public DynamicForm getInlineEditForm()  {
        return null;
    }
    

    /**
     * Label AutoChild used to display {@link com.smartgwt.client.tools.EditProxy#getInlineEditInstructions
     * inlineEditInstructions} below the text entry area if provided. Defaults to the same styling as the system {@link
     * com.smartgwt.client.widgets.Hover}.
     * <p>
     * For an overview of how to use and configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Label
     * @throws IllegalStateException if the underlying component has not yet been created.
     */
    public Label getInlineEditInstructionLabel() throws IllegalStateException {
        errorIfNotCreated("inlineEditInstructionLabel");
        return (Label)Label.getByJSObject(getAttributeAsJavaScriptObject("inlineEditInstructionLabel"));
    }
    

    /**
     * Instructions that appear below the text entry area if inline editing is enabled.  See {@link
     * com.smartgwt.client.tools.EditProxy#getInlineEditEvent inlineEditEvent} and {@link
     * com.smartgwt.client.tools.EditProxy#getInlineEditInstructionLabel inlineEditInstructionLabel}.
     *
     * @param inlineEditInstructions  See {@link com.smartgwt.client.docs.HTMLString HTMLString} . Default value is null
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setInlineEditInstructions(String inlineEditInstructions)  throws IllegalStateException {
        setAttribute("inlineEditInstructions", inlineEditInstructions, false);
    }

    /**
     * Instructions that appear below the text entry area if inline editing is enabled.  See {@link
     * com.smartgwt.client.tools.EditProxy#getInlineEditEvent inlineEditEvent} and {@link
     * com.smartgwt.client.tools.EditProxy#getInlineEditInstructionLabel inlineEditInstructionLabel}.
     *
     * @return  See {@link com.smartgwt.client.docs.HTMLString HTMLString} 
     */
    public String getInlineEditInstructions()  {
        return getAttributeAsString("inlineEditInstructions");
    }
    

    /**
     * Whether inline editing should be single or multi-line. <p> Single-line input appears at the control's top-left corner,
     * multiline covers the control.
     *
     * @param inlineEditMultiline  Default value is false
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setInlineEditMultiline(Boolean inlineEditMultiline)  throws IllegalStateException {
        setAttribute("inlineEditMultiline", inlineEditMultiline, false);
    }

    /**
     * Whether inline editing should be single or multi-line. <p> Single-line input appears at the control's top-left corner,
     * multiline covers the control.
     *
     * @return Boolean
     */
    public Boolean getInlineEditMultiline()  {
        Boolean result = getAttributeAsBoolean("inlineEditMultiline");
        return result == null ? false : result;
    }
    

    /**
     * Should the inline editor be shown when new component is first dropped?
     *
     * @param inlineEditOnDrop  Default value is null
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setInlineEditOnDrop(Boolean inlineEditOnDrop)  throws IllegalStateException {
        setAttribute("inlineEditOnDrop", inlineEditOnDrop, false);
    }

    /**
     * Should the inline editor be shown when new component is first dropped?
     *
     * @return Boolean
     */
    public Boolean getInlineEditOnDrop()  {
        return getAttributeAsBoolean("inlineEditOnDrop");
    }
    

    /**
     * Changes to all child {@link com.smartgwt.client.tools.EditNode#getLiveObject liveObject}'s position and size can be
     * persisted to their {@link com.smartgwt.client.tools.EditNode EditNodes} based on this attribute setting and {@link
     * com.smartgwt.client.tools.EditContext#getPersistCoordinates persistCoordinates}. This applies to both programmatic calls
     * and user interaction (drag reposition or drag resize). <p> The default value of <code>null</code> allows {@link
     * com.smartgwt.client.tools.EditContext#getPersistCoordinates persistCoordinates} to control all coordinate persistence.
     * An explicit value of <code>false</code> overrides the EditContext setting so that no children of the component save
     * coordinates. <p> All coordinate persisting can be disabled with {@link
     * com.smartgwt.client.tools.EditContext#getPersistCoordinates persistCoordinates}. Additionally, all control of
     * persistence can be deferred to each EditProxy by setting {@link
     * com.smartgwt.client.tools.EditContext#getPersistCoordinates persistCoordinates} to <code>null</code>.
     *
     * @param persistCoordinates  Default value is null
     */
    public void setPersistCoordinates(Boolean persistCoordinates) {
        setAttribute("persistCoordinates", persistCoordinates, true);
    }

    /**
     * Changes to all child {@link com.smartgwt.client.tools.EditNode#getLiveObject liveObject}'s position and size can be
     * persisted to their {@link com.smartgwt.client.tools.EditNode EditNodes} based on this attribute setting and {@link
     * com.smartgwt.client.tools.EditContext#getPersistCoordinates persistCoordinates}. This applies to both programmatic calls
     * and user interaction (drag reposition or drag resize). <p> The default value of <code>null</code> allows {@link
     * com.smartgwt.client.tools.EditContext#getPersistCoordinates persistCoordinates} to control all coordinate persistence.
     * An explicit value of <code>false</code> overrides the EditContext setting so that no children of the component save
     * coordinates. <p> All coordinate persisting can be disabled with {@link
     * com.smartgwt.client.tools.EditContext#getPersistCoordinates persistCoordinates}. Additionally, all control of
     * persistence can be deferred to each EditProxy by setting {@link
     * com.smartgwt.client.tools.EditContext#getPersistCoordinates persistCoordinates} to <code>null</code>.
     *
     * @return Boolean
     */
    public Boolean getPersistCoordinates()  {
        return getAttributeAsBoolean("persistCoordinates");
    }
    

    /**
     * Appearance that is applied to selected component. Default value is determined from {@link
     * com.smartgwt.client.tools.EditContext#getSelectedAppearance selectedAppearance}. <P> When value is <code>null</code> the
     * appearance is determined by: <ul> <li>If multiple selection is enabled, "tintMask" is used</li> <li>Otherwise,
     * "outlineMask" is used  </ul>
     *
     * @param selectedAppearance  Default value is null
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     * @see com.smartgwt.client.tools.EditProxy#setSelectedBorder
     * @see com.smartgwt.client.tools.EditProxy#setSelectedTintColor
     * @see com.smartgwt.client.tools.EditProxy#setSelectedTintOpacity
     */
    public void setSelectedAppearance(SelectedAppearance selectedAppearance)  throws IllegalStateException {
        setAttribute("selectedAppearance", selectedAppearance == null ? null : selectedAppearance.getValue(), false);
    }

    /**
     * Appearance that is applied to selected component. Default value is determined from {@link
     * com.smartgwt.client.tools.EditContext#getSelectedAppearance selectedAppearance}. <P> When value is <code>null</code> the
     * appearance is determined by: <ul> <li>If multiple selection is enabled, "tintMask" is used</li> <li>Otherwise,
     * "outlineMask" is used  </ul>
     *
     * @return SelectedAppearance
     * @see com.smartgwt.client.tools.EditProxy#getSelectedBorder
     * @see com.smartgwt.client.tools.EditProxy#getSelectedTintColor
     * @see com.smartgwt.client.tools.EditProxy#getSelectedTintOpacity
     */
    public SelectedAppearance getSelectedAppearance()  {
        return EnumUtil.getEnum(SelectedAppearance.values(), getAttribute("selectedAppearance"));
    }
    

    /**
     * Set the CSS border to be applied to the selection outline of the selected components. Default value is determined from
     * {@link com.smartgwt.client.tools.EditContext#getSelectedBorder selectedBorder}. This property is used when {@link
     * com.smartgwt.client.tools.EditProxy#getSelectedAppearance selectedAppearance} is <code>outlineMask</code> or
     * <code>outlineEdges</code>.
     *
     * @param selectedBorder  Default value is null
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setSelectedBorder(String selectedBorder)  throws IllegalStateException {
        setAttribute("selectedBorder", selectedBorder, false);
    }

    /**
     * Set the CSS border to be applied to the selection outline of the selected components. Default value is determined from
     * {@link com.smartgwt.client.tools.EditContext#getSelectedBorder selectedBorder}. This property is used when {@link
     * com.smartgwt.client.tools.EditProxy#getSelectedAppearance selectedAppearance} is <code>outlineMask</code> or
     * <code>outlineEdges</code>.
     *
     * @return String
     */
    public String getSelectedBorder()  {
        return getAttributeAsString("selectedBorder");
    }
    

    /**
     * The background color for the selection outline label. The default is defined on {@link
     * com.smartgwt.client.tools.SelectionOutline} or {@link
     * com.smartgwt.client.tools.EditContext#getSelectedLabelBackgroundColor selectedLabelBackgroundColor}. <P> NOTE: A
     * selected component label is only supported when {@link com.smartgwt.client.tools.EditProxy#getSelectedAppearance
     * selectedAppearance} is "outlineEdges".
     *
     * @param selectedLabelBackgroundColor  Default value is null
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setSelectedLabelBackgroundColor(String selectedLabelBackgroundColor)  throws IllegalStateException {
        setAttribute("selectedLabelBackgroundColor", selectedLabelBackgroundColor, false);
    }

    /**
     * The background color for the selection outline label. The default is defined on {@link
     * com.smartgwt.client.tools.SelectionOutline} or {@link
     * com.smartgwt.client.tools.EditContext#getSelectedLabelBackgroundColor selectedLabelBackgroundColor}. <P> NOTE: A
     * selected component label is only supported when {@link com.smartgwt.client.tools.EditProxy#getSelectedAppearance
     * selectedAppearance} is "outlineEdges".
     *
     * @return String
     */
    public String getSelectedLabelBackgroundColor()  {
        return getAttributeAsString("selectedLabelBackgroundColor");
    }
    

    /**
     * Mask color applied to {@link com.smartgwt.client.tools.EditProxy#getEditMask editMask} of selected component when {@link
     * com.smartgwt.client.tools.EditProxy#getSelectedAppearance selectedAppearance} is "tintMask". Default value is determined
     * from {@link com.smartgwt.client.tools.EditContext#getSelectedTintColor selectedTintColor}.
     *
     * @param selectedTintColor  See {@link com.smartgwt.client.docs.CSSColor CSSColor} . Default value is null
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     * @see com.smartgwt.client.tools.EditProxy#setSelectedTintOpacity
     */
    public void setSelectedTintColor(String selectedTintColor)  throws IllegalStateException {
        setAttribute("selectedTintColor", selectedTintColor, false);
    }

    /**
     * Mask color applied to {@link com.smartgwt.client.tools.EditProxy#getEditMask editMask} of selected component when {@link
     * com.smartgwt.client.tools.EditProxy#getSelectedAppearance selectedAppearance} is "tintMask". Default value is determined
     * from {@link com.smartgwt.client.tools.EditContext#getSelectedTintColor selectedTintColor}.
     *
     * @return  See {@link com.smartgwt.client.docs.CSSColor CSSColor} 
     * @see com.smartgwt.client.tools.EditProxy#getSelectedTintOpacity
     */
    public String getSelectedTintColor()  {
        return getAttributeAsString("selectedTintColor");
    }
    

    /**
     * Opacity applied to {@link com.smartgwt.client.tools.EditProxy#getEditMask editMask} of selected component when {@link
     * com.smartgwt.client.tools.EditProxy#getSelectedAppearance selectedAppearance} is "tintMask".
     *
     * @param selectedTintOpacity  Default value is null
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     * @see com.smartgwt.client.tools.EditProxy#setSelectedTintColor
     */
    public void setSelectedTintOpacity(Integer selectedTintOpacity)  throws IllegalStateException {
        setAttribute("selectedTintOpacity", selectedTintOpacity, false);
    }

    /**
     * Opacity applied to {@link com.smartgwt.client.tools.EditProxy#getEditMask editMask} of selected component when {@link
     * com.smartgwt.client.tools.EditProxy#getSelectedAppearance selectedAppearance} is "tintMask".
     *
     * @return Integer
     * @see com.smartgwt.client.tools.EditProxy#getSelectedTintColor
     */
    public Integer getSelectedTintOpacity()  {
        return getAttributeAsInt("selectedTintOpacity");
    }
    

    /**
     * Whether this EditProxy has an inline edit behavior.
     *
     * @param supportsInlineEdit  Default value is true
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setSupportsInlineEdit(Boolean supportsInlineEdit)  throws IllegalStateException {
        setAttribute("supportsInlineEdit", supportsInlineEdit, false);
    }

    /**
     * Whether this EditProxy has an inline edit behavior.
     *
     * @return Boolean
     */
    public Boolean getSupportsInlineEdit()  {
        Boolean result = getAttributeAsBoolean("supportsInlineEdit");
        return result == null ? true : result;
    }
    

    // ********************* Methods ***********************
	/**
     * Returns the text based on the current component state to be edited inline. Called by the {@link
     * com.smartgwt.client.tools.EditProxy#getInlineEditForm inlineEditForm} to obtain the starting edit value. <p> For a
     * canvas with <code>isGroup</code> enabled, the <code>groupTitle</code> is returned. Otherwise the <code>contents</code>
     * is returned.
     */
    public native void getInlineEditText() /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.getInlineEditText();
    }-*/;



	/**
     * Save the new value into the component's state. Called by the {@link
     * com.smartgwt.client.tools.EditProxy#getInlineEditForm inlineEditForm} to commit the change. <p> For a canvas with
     * <code>isGroup</code> enabled, the <code>groupTitle</code> is updated. Otherwise the <code>contents</code> is updated.
     * @param newValue the new component state
     */
    public native void setInlineEditText(String newValue) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.setInlineEditText(newValue);
    }-*/;




	/**
     * This method applies the {@link com.smartgwt.client.tools.EditProxy#getSelectedAppearance selectedAppearance} to the
     * selected component or resets it to the non-selected appearance. Override this method to create a custom appearance.
     * @param show true to show component as selected, false otherwise
     */
    public native void showSelectedAppearance(boolean show) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.showSelectedAppearance(show == null ? false : show);
    }-*/;




	/**
     * Manual means of triggering inline editing.  See {@link com.smartgwt.client.types.InlineEditEvent}.
     * @param appendChar character to initially append to current value
     */
    public native void startInlineEditing(String appendChar) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.startInlineEditing(appendChar);
    }-*/;



    // ********************* Static Methods ***********************

    // ***********************************************************

}


