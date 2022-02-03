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
        onBind();
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
     * This property acts as a component-specific override for the {@link
     * com.smartgwt.client.tools.EditContext#getAllowNestedDrops EditContext.allowNestedDrops} property. Unless explicitly set
     * to false, the {@link com.smartgwt.client.tools.EditContext#getAllowNestedDrops EditContext.allowNestedDrops} controls
     * whether a drop can be made into this component.
     *
     * @param allowNestedDrops New allowNestedDrops value. Default value is null
     * @return {@link com.smartgwt.client.tools.EditProxy EditProxy} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public EditProxy setAllowNestedDrops(Boolean allowNestedDrops)  throws IllegalStateException {
        return (EditProxy)setAttribute("allowNestedDrops", allowNestedDrops, false);
    }

    /**
     * This property acts as a component-specific override for the {@link
     * com.smartgwt.client.tools.EditContext#getAllowNestedDrops EditContext.allowNestedDrops} property. Unless explicitly set
     * to false, the {@link com.smartgwt.client.tools.EditContext#getAllowNestedDrops EditContext.allowNestedDrops} controls
     * whether a drop can be made into this component.
     *
     * @return Current allowNestedDrops value. Default value is null
     */
    public Boolean getAllowNestedDrops()  {
        return getAttributeAsBoolean("allowNestedDrops");
    }
    

    /**
     * When child nodes are added to an EditContext, should they be masked by setting {@link
     * com.smartgwt.client.tools.EditProxy#getUseEditMask useEditMask} <code>true</code> if not explicitly set?
     *
     * @param autoMaskChildren New autoMaskChildren value. Default value is null
     * @return {@link com.smartgwt.client.tools.EditProxy EditProxy} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public EditProxy setAutoMaskChildren(Boolean autoMaskChildren)  throws IllegalStateException {
        return (EditProxy)setAttribute("autoMaskChildren", autoMaskChildren, false);
    }

    /**
     * When child nodes are added to an EditContext, should they be masked by setting {@link
     * com.smartgwt.client.tools.EditProxy#getUseEditMask useEditMask} <code>true</code> if not explicitly set?
     *
     * @return Current autoMaskChildren value. Default value is null
     */
    public Boolean getAutoMaskChildren()  {
        return getAttributeAsBoolean("autoMaskChildren");
    }
    

    /**
     * Should component be brought to front when selected? Applies when {@link
     * com.smartgwt.client.tools.EditProxy#getUseEditMask useEditMask}:true.
     *
     * @param bringToFrontOnSelect New bringToFrontOnSelect value. Default value is null
     * @return {@link com.smartgwt.client.tools.EditProxy EditProxy} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public EditProxy setBringToFrontOnSelect(Boolean bringToFrontOnSelect)  throws IllegalStateException {
        return (EditProxy)setAttribute("bringToFrontOnSelect", bringToFrontOnSelect, false);
    }

    /**
     * Should component be brought to front when selected? Applies when {@link
     * com.smartgwt.client.tools.EditProxy#getUseEditMask useEditMask}:true.
     *
     * @return Current bringToFrontOnSelect value. Default value is null
     */
    public Boolean getBringToFrontOnSelect()  {
        return getAttributeAsBoolean("bringToFrontOnSelect");
    }
    

    /**
     * Can this component be selected? Selection is allowed unless this property is set to <code>false</code>.
     *
     * @param canSelect New canSelect value. Default value is null
     * @return {@link com.smartgwt.client.tools.EditProxy EditProxy} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public EditProxy setCanSelect(Boolean canSelect)  throws IllegalStateException {
        return (EditProxy)setAttribute("canSelect", canSelect, false);
    }

    /**
     * Can this component be selected? Selection is allowed unless this property is set to <code>false</code>.
     *
     * @return Current canSelect value. Default value is null
     */
    public Boolean getCanSelect()  {
        return getAttributeAsBoolean("canSelect");
    }
    

    /**
     * Whether to allow selection of the children of this {@link com.smartgwt.client.tools.EditNode}.  The appearance and
     * behavior of selected components is controlled by {@link com.smartgwt.client.types.SelectedAppearance}, or centrally
     * across an {@link com.smartgwt.client.tools.EditContext} via {@link
     * com.smartgwt.client.tools.EditContext#getSelectedAppearance EditContext.selectedAppearance}. <p> Individual children can
     * be marked non-selectable via setting {@link com.smartgwt.client.tools.EditProxy#getCanSelect canSelect} to
     * <code>false</code>. <p> Use the {@link com.smartgwt.client.tools.EditContext} to access and manipulate the currently
     * selected set of EditNodes, via APIs such as {@link com.smartgwt.client.tools.EditContext#getSelectedEditNode
     * EditContext.getSelectedEditNode()}, {@link com.smartgwt.client.tools.EditContext#selectSingleEditNode
     * EditContext.selectSingleEditNode()} and {@link com.smartgwt.client.tools.EditContext#addSelectedEditNodesUpdatedHandler
     * EditContext.selectedEditNodesUpdated()}.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Setter for {@link com.smartgwt.client.tools.EditProxy#getCanSelectChildren canSelectChildren}.
     *
     * @param canSelectChildren the new canSelectChildren. Default value is null
     * @return {@link com.smartgwt.client.tools.EditProxy EditProxy} instance, for chaining setter calls
     * @see com.smartgwt.client.tools.EditContext#setCanSelectEditNodes
     */
    public EditProxy setCanSelectChildren(Boolean canSelectChildren) {
        return (EditProxy)setAttribute("canSelectChildren", canSelectChildren, true);
    }

    /**
     * Whether to allow selection of the children of this {@link com.smartgwt.client.tools.EditNode}.  The appearance and
     * behavior of selected components is controlled by {@link com.smartgwt.client.types.SelectedAppearance}, or centrally
     * across an {@link com.smartgwt.client.tools.EditContext} via {@link
     * com.smartgwt.client.tools.EditContext#getSelectedAppearance EditContext.selectedAppearance}. <p> Individual children can
     * be marked non-selectable via setting {@link com.smartgwt.client.tools.EditProxy#getCanSelect canSelect} to
     * <code>false</code>. <p> Use the {@link com.smartgwt.client.tools.EditContext} to access and manipulate the currently
     * selected set of EditNodes, via APIs such as {@link com.smartgwt.client.tools.EditContext#getSelectedEditNode
     * EditContext.getSelectedEditNode()}, {@link com.smartgwt.client.tools.EditContext#selectSingleEditNode
     * EditContext.selectSingleEditNode()} and {@link com.smartgwt.client.tools.EditContext#addSelectedEditNodesUpdatedHandler
     * EditContext.selectedEditNodesUpdated()}.
     *
     * @return Current canSelectChildren value. Default value is null
     * @see com.smartgwt.client.tools.EditContext#getCanSelectEditNodes
     */
    public Boolean getCanSelectChildren()  {
        return getAttributeAsBoolean("canSelectChildren");
    }
    

    /**
     * If not null the {@link com.smartgwt.client.widgets.Canvas#getChildrenSnapResizeToGrid Canvas.childrenSnapResizeToGrid}
     * on the component represented by this EditProxy is set to this value only while in edit mode. This allows
     * snapResizeToGrid functionality to be enforced during edit mode but not when live.
     *
     * @param childrenSnapResizeToGrid New childrenSnapResizeToGrid value. Default value is null
     * @return {@link com.smartgwt.client.tools.EditProxy EditProxy} instance, for chaining setter calls
     */
    public EditProxy setChildrenSnapResizeToGrid(Boolean childrenSnapResizeToGrid) {
        return (EditProxy)setAttribute("childrenSnapResizeToGrid", childrenSnapResizeToGrid, true);
    }

    /**
     * If not null the {@link com.smartgwt.client.widgets.Canvas#getChildrenSnapResizeToGrid Canvas.childrenSnapResizeToGrid}
     * on the component represented by this EditProxy is set to this value only while in edit mode. This allows
     * snapResizeToGrid functionality to be enforced during edit mode but not when live.
     *
     * @return Current childrenSnapResizeToGrid value. Default value is null
     */
    public Boolean getChildrenSnapResizeToGrid()  {
        return getAttributeAsBoolean("childrenSnapResizeToGrid");
    }
    

    /**
     * If not null the {@link com.smartgwt.client.widgets.Canvas#getChildrenSnapToGrid Canvas.childrenSnapToGrid} on the
     * component represented by this EditProxy is set to this value only while in edit mode. This allows snapToGrid
     * functionality to be enforced during edit mode but not when live.
     *
     * @param childrenSnapToGrid New childrenSnapToGrid value. Default value is null
     * @return {@link com.smartgwt.client.tools.EditProxy EditProxy} instance, for chaining setter calls
     */
    public EditProxy setChildrenSnapToGrid(Boolean childrenSnapToGrid) {
        return (EditProxy)setAttribute("childrenSnapToGrid", childrenSnapToGrid, true);
    }

    /**
     * If not null the {@link com.smartgwt.client.widgets.Canvas#getChildrenSnapToGrid Canvas.childrenSnapToGrid} on the
     * component represented by this EditProxy is set to this value only while in edit mode. This allows snapToGrid
     * functionality to be enforced during edit mode but not when live.
     *
     * @return Current childrenSnapToGrid value. Default value is null
     */
    public Boolean getChildrenSnapToGrid()  {
        return getAttributeAsBoolean("childrenSnapToGrid");
    }
    

    /**
     * An editMask is created for any component placed into editMode with {@link
     * com.smartgwt.client.tools.EditProxy#getUseEditMask useEditMask}:true. <P> Common customization properties can be
     * provided by {@link com.smartgwt.client.tools.EditContext#getEditMaskProperties EditContext.editMaskProperties}.
     * <p>
     * This component is an AutoChild named "editMask".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current editMask value. Default value is null
     * @throws IllegalStateException if the underlying component has not yet been created.
     */
    public Canvas getEditMask() throws IllegalStateException {
        errorIfNotCreated("editMask");
        return (Canvas)Canvas.getByJSObject(getAttributeAsJavaScriptObject("editMask"));
    }
    

    /**
     * Hoop selector canvas used for selecting multiple components. <P> Common customization properties can be provided by
     * {@link com.smartgwt.client.tools.EditContext#getHoopSelectorProperties EditContext.hoopSelectorProperties}.
     * <p>
     * This component is an AutoChild named "hoopSelector".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current hoopSelector value. Default value is null
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
     * from {@link com.smartgwt.client.tools.EditProxy#getInlineEditText getInlineEditText()} and is applied via {@link
     * com.smartgwt.client.tools.EditProxy#setInlineEditText setInlineEditText()}. <p> Many {@link
     * com.smartgwt.client.tools.EditProxy} subclasses have built-in modes for inline editing.
     *
     * @param inlineEditEvent New inlineEditEvent value. Default value is null
     * @return {@link com.smartgwt.client.tools.EditProxy EditProxy} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public EditProxy setInlineEditEvent(InlineEditEvent inlineEditEvent)  throws IllegalStateException {
        return (EditProxy)setAttribute("inlineEditEvent", inlineEditEvent == null ? null : inlineEditEvent.getValue(), false);
    }

    /**
     * Event that triggers inline editing, showing the {@link com.smartgwt.client.tools.EditProxy#getInlineEditForm
     * inlineEditForm}, which consists of a single text input (single or multi-line according to {@link
     * com.smartgwt.client.tools.EditProxy#getInlineEditMultiline inlineEditMultiline}) shown in the {@link
     * com.smartgwt.client.tools.EditProxy#getInlineEditForm inlineEditForm} AutoChild. <p> The initial value in the form comes
     * from {@link com.smartgwt.client.tools.EditProxy#getInlineEditText getInlineEditText()} and is applied via {@link
     * com.smartgwt.client.tools.EditProxy#setInlineEditText setInlineEditText()}. <p> Many {@link
     * com.smartgwt.client.tools.EditProxy} subclasses have built-in modes for inline editing.
     *
     * @return Current inlineEditEvent value. Default value is null
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
     * This component is an AutoChild named "inlineEditInstructionLabel".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current inlineEditInstructionLabel value. Default value is null
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
     * @param inlineEditInstructions New inlineEditInstructions value. Default value is null
     * @return {@link com.smartgwt.client.tools.EditProxy EditProxy} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public EditProxy setInlineEditInstructions(String inlineEditInstructions)  throws IllegalStateException {
        return (EditProxy)setAttribute("inlineEditInstructions", inlineEditInstructions, false);
    }

    /**
     * Instructions that appear below the text entry area if inline editing is enabled.  See {@link
     * com.smartgwt.client.tools.EditProxy#getInlineEditEvent inlineEditEvent} and {@link
     * com.smartgwt.client.tools.EditProxy#getInlineEditInstructionLabel inlineEditInstructionLabel}.
     *
     * @return Current inlineEditInstructions value. Default value is null
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public String getInlineEditInstructions()  {
        return getAttributeAsString("inlineEditInstructions");
    }
    

    /**
     * Whether inline editing should be single or multi-line. <p> Single-line input appears at the control's top-left corner,
     * multiline covers the control.
     *
     * @param inlineEditMultiline New inlineEditMultiline value. Default value is false
     * @return {@link com.smartgwt.client.tools.EditProxy EditProxy} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public EditProxy setInlineEditMultiline(Boolean inlineEditMultiline)  throws IllegalStateException {
        return (EditProxy)setAttribute("inlineEditMultiline", inlineEditMultiline, false);
    }

    /**
     * Whether inline editing should be single or multi-line. <p> Single-line input appears at the control's top-left corner,
     * multiline covers the control.
     *
     * @return Current inlineEditMultiline value. Default value is false
     */
    public Boolean getInlineEditMultiline()  {
        Boolean result = getAttributeAsBoolean("inlineEditMultiline");
        return result == null ? false : result;
    }
    

    /**
     * Should the inline editor be shown when new component is first dropped?
     *
     * @param inlineEditOnDrop New inlineEditOnDrop value. Default value is null
     * @return {@link com.smartgwt.client.tools.EditProxy EditProxy} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public EditProxy setInlineEditOnDrop(Boolean inlineEditOnDrop)  throws IllegalStateException {
        return (EditProxy)setAttribute("inlineEditOnDrop", inlineEditOnDrop, false);
    }

    /**
     * Should the inline editor be shown when new component is first dropped?
     *
     * @return Current inlineEditOnDrop value. Default value is null
     */
    public Boolean getInlineEditOnDrop()  {
        return getAttributeAsBoolean("inlineEditOnDrop");
    }
    

    /**
     * Changes to all child {@link com.smartgwt.client.tools.EditNode#getLiveObject liveObject}'s position and size can be
     * persisted to their {@link com.smartgwt.client.tools.EditNode EditNodes} based on this attribute setting and {@link
     * com.smartgwt.client.tools.EditContext#getPersistCoordinates EditContext.persistCoordinates}. This applies to both
     * programmatic calls and user interaction (drag reposition or drag resize). <p> The default value of <code>null</code>
     * allows {@link com.smartgwt.client.tools.EditContext#getPersistCoordinates EditContext.persistCoordinates} to control all
     * coordinate persistence. An explicit value of <code>false</code> overrides the EditContext setting so that no children of
     * the component save coordinates. <p> All coordinate persisting can be disabled with {@link
     * com.smartgwt.client.tools.EditContext#getPersistCoordinates EditContext.persistCoordinates}. Additionally, all control
     * of persistence can be deferred to each EditProxy by setting {@link
     * com.smartgwt.client.tools.EditContext#getPersistCoordinates EditContext.persistCoordinates} to <code>null</code>.
     *
     * @param persistCoordinates New persistCoordinates value. Default value is null
     * @return {@link com.smartgwt.client.tools.EditProxy EditProxy} instance, for chaining setter calls
     */
    public EditProxy setPersistCoordinates(Boolean persistCoordinates) {
        return (EditProxy)setAttribute("persistCoordinates", persistCoordinates, true);
    }

    /**
     * Changes to all child {@link com.smartgwt.client.tools.EditNode#getLiveObject liveObject}'s position and size can be
     * persisted to their {@link com.smartgwt.client.tools.EditNode EditNodes} based on this attribute setting and {@link
     * com.smartgwt.client.tools.EditContext#getPersistCoordinates EditContext.persistCoordinates}. This applies to both
     * programmatic calls and user interaction (drag reposition or drag resize). <p> The default value of <code>null</code>
     * allows {@link com.smartgwt.client.tools.EditContext#getPersistCoordinates EditContext.persistCoordinates} to control all
     * coordinate persistence. An explicit value of <code>false</code> overrides the EditContext setting so that no children of
     * the component save coordinates. <p> All coordinate persisting can be disabled with {@link
     * com.smartgwt.client.tools.EditContext#getPersistCoordinates EditContext.persistCoordinates}. Additionally, all control
     * of persistence can be deferred to each EditProxy by setting {@link
     * com.smartgwt.client.tools.EditContext#getPersistCoordinates EditContext.persistCoordinates} to <code>null</code>.
     *
     * @return Current persistCoordinates value. Default value is null
     */
    public Boolean getPersistCoordinates()  {
        return getAttributeAsBoolean("persistCoordinates");
    }
    

    /**
     * Appearance that is applied to selected component. Default value is determined from {@link
     * com.smartgwt.client.tools.EditContext#getSelectedAppearance EditContext.selectedAppearance}. <P> When value is
     * <code>null</code> the appearance is determined by: <ul> <li>If multiple selection is enabled, "tintMask" is used</li>
     * <li>Otherwise, "outlineMask" is used  </ul>
     *
     * @param selectedAppearance New selectedAppearance value. Default value is null
     * @return {@link com.smartgwt.client.tools.EditProxy EditProxy} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     * @see com.smartgwt.client.tools.EditProxy#setSelectedBorder
     * @see com.smartgwt.client.tools.EditProxy#setSelectedTintColor
     * @see com.smartgwt.client.tools.EditProxy#setSelectedTintOpacity
     */
    public EditProxy setSelectedAppearance(SelectedAppearance selectedAppearance)  throws IllegalStateException {
        return (EditProxy)setAttribute("selectedAppearance", selectedAppearance == null ? null : selectedAppearance.getValue(), false);
    }

    /**
     * Appearance that is applied to selected component. Default value is determined from {@link
     * com.smartgwt.client.tools.EditContext#getSelectedAppearance EditContext.selectedAppearance}. <P> When value is
     * <code>null</code> the appearance is determined by: <ul> <li>If multiple selection is enabled, "tintMask" is used</li>
     * <li>Otherwise, "outlineMask" is used  </ul>
     *
     * @return Current selectedAppearance value. Default value is null
     * @see com.smartgwt.client.tools.EditProxy#getSelectedBorder
     * @see com.smartgwt.client.tools.EditProxy#getSelectedTintColor
     * @see com.smartgwt.client.tools.EditProxy#getSelectedTintOpacity
     */
    public SelectedAppearance getSelectedAppearance()  {
        return EnumUtil.getEnum(SelectedAppearance.values(), getAttribute("selectedAppearance"));
    }
    

    /**
     * Set the CSS border to be applied to the selection outline of the selected components. Default value is determined from
     * {@link com.smartgwt.client.tools.EditContext#getSelectedBorder EditContext.selectedBorder}. This property is used when
     * {@link com.smartgwt.client.tools.EditProxy#getSelectedAppearance selectedAppearance} is <code>outlineMask</code> or
     * <code>outlineEdges</code>.
     *
     * @param selectedBorder New selectedBorder value. Default value is null
     * @return {@link com.smartgwt.client.tools.EditProxy EditProxy} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public EditProxy setSelectedBorder(String selectedBorder)  throws IllegalStateException {
        return (EditProxy)setAttribute("selectedBorder", selectedBorder, false);
    }

    /**
     * Set the CSS border to be applied to the selection outline of the selected components. Default value is determined from
     * {@link com.smartgwt.client.tools.EditContext#getSelectedBorder EditContext.selectedBorder}. This property is used when
     * {@link com.smartgwt.client.tools.EditProxy#getSelectedAppearance selectedAppearance} is <code>outlineMask</code> or
     * <code>outlineEdges</code>.
     *
     * @return Current selectedBorder value. Default value is null
     */
    public String getSelectedBorder()  {
        return getAttributeAsString("selectedBorder");
    }
    

    /**
     * The background color for the selection outline label. The default is defined on {@link
     * com.smartgwt.client.tools.SelectionOutline} or {@link
     * com.smartgwt.client.tools.EditContext#getSelectedLabelBackgroundColor EditContext.selectedLabelBackgroundColor}. <P>
     * NOTE: A selected component label is only supported when {@link com.smartgwt.client.tools.EditProxy#getSelectedAppearance
     * selectedAppearance} is "outlineEdges".
     *
     * @param selectedLabelBackgroundColor New selectedLabelBackgroundColor value. Default value is null
     * @return {@link com.smartgwt.client.tools.EditProxy EditProxy} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public EditProxy setSelectedLabelBackgroundColor(String selectedLabelBackgroundColor)  throws IllegalStateException {
        return (EditProxy)setAttribute("selectedLabelBackgroundColor", selectedLabelBackgroundColor, false);
    }

    /**
     * The background color for the selection outline label. The default is defined on {@link
     * com.smartgwt.client.tools.SelectionOutline} or {@link
     * com.smartgwt.client.tools.EditContext#getSelectedLabelBackgroundColor EditContext.selectedLabelBackgroundColor}. <P>
     * NOTE: A selected component label is only supported when {@link com.smartgwt.client.tools.EditProxy#getSelectedAppearance
     * selectedAppearance} is "outlineEdges".
     *
     * @return Current selectedLabelBackgroundColor value. Default value is null
     */
    public String getSelectedLabelBackgroundColor()  {
        return getAttributeAsString("selectedLabelBackgroundColor");
    }
    

    /**
     * Mask color applied to {@link com.smartgwt.client.tools.EditProxy#getEditMask editMask} of selected component when {@link
     * com.smartgwt.client.tools.EditProxy#getSelectedAppearance selectedAppearance} is "tintMask". Default value is determined
     * from {@link com.smartgwt.client.tools.EditContext#getSelectedTintColor EditContext.selectedTintColor}.
     *
     * @param selectedTintColor New selectedTintColor value. Default value is null
     * @return {@link com.smartgwt.client.tools.EditProxy EditProxy} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     * @see com.smartgwt.client.tools.EditProxy#setSelectedTintOpacity
     * @see com.smartgwt.client.docs.CSSColor CSSColor 
     */
    public EditProxy setSelectedTintColor(String selectedTintColor)  throws IllegalStateException {
        return (EditProxy)setAttribute("selectedTintColor", selectedTintColor, false);
    }

    /**
     * Mask color applied to {@link com.smartgwt.client.tools.EditProxy#getEditMask editMask} of selected component when {@link
     * com.smartgwt.client.tools.EditProxy#getSelectedAppearance selectedAppearance} is "tintMask". Default value is determined
     * from {@link com.smartgwt.client.tools.EditContext#getSelectedTintColor EditContext.selectedTintColor}.
     *
     * @return Current selectedTintColor value. Default value is null
     * @see com.smartgwt.client.tools.EditProxy#getSelectedTintOpacity
     * @see com.smartgwt.client.docs.CSSColor CSSColor 
     */
    public String getSelectedTintColor()  {
        return getAttributeAsString("selectedTintColor");
    }
    

    /**
     * Opacity applied to {@link com.smartgwt.client.tools.EditProxy#getEditMask editMask} of selected component when {@link
     * com.smartgwt.client.tools.EditProxy#getSelectedAppearance selectedAppearance} is "tintMask".
     *
     * @param selectedTintOpacity New selectedTintOpacity value. Default value is null
     * @return {@link com.smartgwt.client.tools.EditProxy EditProxy} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     * @see com.smartgwt.client.tools.EditProxy#setSelectedTintColor
     */
    public EditProxy setSelectedTintOpacity(Integer selectedTintOpacity)  throws IllegalStateException {
        return (EditProxy)setAttribute("selectedTintOpacity", selectedTintOpacity, false);
    }

    /**
     * Opacity applied to {@link com.smartgwt.client.tools.EditProxy#getEditMask editMask} of selected component when {@link
     * com.smartgwt.client.tools.EditProxy#getSelectedAppearance selectedAppearance} is "tintMask".
     *
     * @return Current selectedTintOpacity value. Default value is null
     * @see com.smartgwt.client.tools.EditProxy#getSelectedTintColor
     */
    public Integer getSelectedTintOpacity()  {
        return getAttributeAsInt("selectedTintOpacity");
    }
    

    /**
     * Should drag handles or thumb be shown when this component is selected? These are shown unless this property is set to
     * <code>false</code>.
     *
     * @param showDragHandle New showDragHandle value. Default value is null
     * @return {@link com.smartgwt.client.tools.EditProxy EditProxy} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public EditProxy setShowDragHandle(Boolean showDragHandle)  throws IllegalStateException {
        return (EditProxy)setAttribute("showDragHandle", showDragHandle, false);
    }

    /**
     * Should drag handles or thumb be shown when this component is selected? These are shown unless this property is set to
     * <code>false</code>.
     *
     * @return Current showDragHandle value. Default value is null
     */
    public Boolean getShowDragHandle()  {
        return getAttributeAsBoolean("showDragHandle");
    }
    

    /**
     * Whether this EditProxy has an inline edit behavior, which allows an end user to configure a component by editing a
     * simple text representation of its configuration.   <p> For example, when inline edit is enabled, a {@link
     * com.smartgwt.client.widgets.form.fields.SelectItem} allows {@link
     * com.smartgwt.client.tools.SelectItemEditProxy#getInlineEditText editing its valueMap} as a comma-separated string, and a
     * {@link com.smartgwt.client.widgets.grid.ListGrid}'s columns and data can be edited as several lines of comma-separated
     * headings and data values. <p> See {@link com.smartgwt.client.tools.EditProxy#getInlineEditEvent inlineEditEvent} for
     * more details and configuration options.
     *
     * @param supportsInlineEdit New supportsInlineEdit value. Default value is true
     * @return {@link com.smartgwt.client.tools.EditProxy EditProxy} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public EditProxy setSupportsInlineEdit(Boolean supportsInlineEdit)  throws IllegalStateException {
        return (EditProxy)setAttribute("supportsInlineEdit", supportsInlineEdit, false);
    }

    /**
     * Whether this EditProxy has an inline edit behavior, which allows an end user to configure a component by editing a
     * simple text representation of its configuration.   <p> For example, when inline edit is enabled, a {@link
     * com.smartgwt.client.widgets.form.fields.SelectItem} allows {@link
     * com.smartgwt.client.tools.SelectItemEditProxy#getInlineEditText editing its valueMap} as a comma-separated string, and a
     * {@link com.smartgwt.client.widgets.grid.ListGrid}'s columns and data can be edited as several lines of comma-separated
     * headings and data values. <p> See {@link com.smartgwt.client.tools.EditProxy#getInlineEditEvent inlineEditEvent} for
     * more details and configuration options.
     *
     * @return Current supportsInlineEdit value. Default value is true
     */
    public Boolean getSupportsInlineEdit()  {
        Boolean result = getAttributeAsBoolean("supportsInlineEdit");
        return result == null ? true : result;
    }
    

    /**
     * Whether to enable keyboard shortcuts to {@link com.smartgwt.client.tools.EditContext#copyEditNodes copy} and {@link
     * com.smartgwt.client.tools.EditContext#pasteEditNodes paste} <code>editNodes</code>. <p> Enabled by default if {@link
     * com.smartgwt.client.tools.EditProxy#getCanSelectChildren selection of children} is also enabled. <p> For pasting, if
     * {@link com.smartgwt.client.tools.EditContext#getAllowNestedDrops EditContext.allowNestedDrops} is enabled, only one
     * editNode is selected and it is a valid container for the contents of the clipboard, editNodes will be pasted as new
     * children of the selected container.  Otherwise, they will be pasted at the root level of the {@link
     * com.smartgwt.client.tools.EditContext#getEditNodeTree editNodeTree}. <p> <code>useCopyPasteShortcuts</code> may only be
     * set on the root <code>editNode</code> within any one {@link com.smartgwt.client.tools.EditContext#getEditNodeTree
     * editNodeTree}.
     *
     * @param useCopyPasteShortcuts New useCopyPasteShortcuts value. Default value is null
     * @return {@link com.smartgwt.client.tools.EditProxy EditProxy} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public EditProxy setUseCopyPasteShortcuts(Boolean useCopyPasteShortcuts)  throws IllegalStateException {
        return (EditProxy)setAttribute("useCopyPasteShortcuts", useCopyPasteShortcuts, false);
    }

    /**
     * Whether to enable keyboard shortcuts to {@link com.smartgwt.client.tools.EditContext#copyEditNodes copy} and {@link
     * com.smartgwt.client.tools.EditContext#pasteEditNodes paste} <code>editNodes</code>. <p> Enabled by default if {@link
     * com.smartgwt.client.tools.EditProxy#getCanSelectChildren selection of children} is also enabled. <p> For pasting, if
     * {@link com.smartgwt.client.tools.EditContext#getAllowNestedDrops EditContext.allowNestedDrops} is enabled, only one
     * editNode is selected and it is a valid container for the contents of the clipboard, editNodes will be pasted as new
     * children of the selected container.  Otherwise, they will be pasted at the root level of the {@link
     * com.smartgwt.client.tools.EditContext#getEditNodeTree editNodeTree}. <p> <code>useCopyPasteShortcuts</code> may only be
     * set on the root <code>editNode</code> within any one {@link com.smartgwt.client.tools.EditContext#getEditNodeTree
     * editNodeTree}.
     *
     * @return Current useCopyPasteShortcuts value. Default value is null
     */
    public Boolean getUseCopyPasteShortcuts()  {
        return getAttributeAsBoolean("useCopyPasteShortcuts");
    }
    

    /**
     * When <code>true</code> an {@link com.smartgwt.client.tools.EditProxy#getEditMask editMask} will be auto-generated and
     * placed over the component to allow selection, positioning and resizing. <P> If this property is not set it will enabled
     * when added to an EditContext if its parent component has an editProxy and {@link
     * com.smartgwt.client.tools.EditProxy#getAutoMaskChildren autoMaskChildren} is <code>true</code>.
     *
     * @param useEditMask New useEditMask value. Default value is null
     * @return {@link com.smartgwt.client.tools.EditProxy EditProxy} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public EditProxy setUseEditMask(Boolean useEditMask)  throws IllegalStateException {
        return (EditProxy)setAttribute("useEditMask", useEditMask, false);
    }

    /**
     * When <code>true</code> an {@link com.smartgwt.client.tools.EditProxy#getEditMask editMask} will be auto-generated and
     * placed over the component to allow selection, positioning and resizing. <P> If this property is not set it will enabled
     * when added to an EditContext if its parent component has an editProxy and {@link
     * com.smartgwt.client.tools.EditProxy#getAutoMaskChildren autoMaskChildren} is <code>true</code>.
     *
     * @return Current useEditMask value. Default value is null
     */
    public Boolean getUseEditMask()  {
        return getAttributeAsBoolean("useEditMask");
    }
    

    // ********************* Methods ***********************
	/**
     * Returns the text based on the current component state to be edited inline. Called by the {@link
     * com.smartgwt.client.tools.EditProxy#getInlineEditForm inlineEditForm} to obtain the starting edit value. <p> For a
     * canvas with <code>isGroup</code> enabled, the <code>groupTitle</code> is returned. Otherwise the <code>contents</code>
     * is returned.
     */
    public native void getInlineEditText() /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getInlineEditText", "");
        }
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
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "setInlineEditText", "String");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.setInlineEditText(newValue);
    }-*/;

	/**
     * This method applies the {@link com.smartgwt.client.tools.EditProxy#getSelectedAppearance selectedAppearance} to the
     * selected component or resets it to the non-selected appearance. Override this method to create a custom appearance.
     * @param show true to show component as selected, false otherwise
     */
    public native void showSelectedAppearance(boolean show) /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "showSelectedAppearance", "boolean");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.showSelectedAppearance(show);
    }-*/;

	/**
     * Manual means of triggering inline editing.  See {@link com.smartgwt.client.types.InlineEditEvent}.
     */
    public native void startInlineEditing() /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "startInlineEditing", "");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.startInlineEditing();
    }-*/;

	/**
     * Manual means of triggering inline editing.  See {@link com.smartgwt.client.types.InlineEditEvent}.
     * @param appendChar optional String to append to current value as editing starts
     */
    public native void startInlineEditing(String appendChar) /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "startInlineEditing", "String");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.startInlineEditing(appendChar);
    }-*/;
	

    // ********************* Static Methods ***********************

    // ***********************************************************

}
