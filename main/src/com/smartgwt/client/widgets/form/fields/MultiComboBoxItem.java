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
 
package com.smartgwt.client.widgets.form.fields;


import com.smartgwt.client.event.*;
import com.smartgwt.client.core.*;
import com.smartgwt.client.types.*;
import com.smartgwt.client.data.*;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.data.events.*;
import com.smartgwt.client.browser.window.*;
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
import com.smartgwt.client.widgets.tour.*;
import com.smartgwt.client.widgets.notify.*;
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
import com.smartgwt.client.widgets.notify.*;
import com.smartgwt.client.widgets.drawing.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
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
import com.smartgwt.client.util.tour.*;


/**
 * A MultiComboBoxItem is a combo box that allows the user to select multiple options.  Each selected option is represented
 * as a button that can be clicked to deselect the option. The relative layout of the buttons to the combo box is specified
 * with the {@link com.smartgwt.client.widgets.form.fields.MultiComboBoxItem#getLayoutStyle layoutStyle} attribute.  The
 * buttons will be kept in the order that they were added, with the most recently added button being adjacent to the combo
 * box. <code>MultiComboBoxItem</code> uses the {@link com.smartgwt.client.types.AutoChild} pattern to construct the {@link
 * com.smartgwt.client.widgets.form.fields.MultiComboBoxItem#getComboBox comboBox} and the {@link
 * com.smartgwt.client.widgets.form.fields.MultiComboBoxItem#getButton buttons} so that they can be easily customized.  For
 * example, you can customize the criteria used to fetch by  using {@link
 * com.smartgwt.client.widgets.form.fields.ComboBoxItem#setPickListFilterCriteriaFunction
 * ComboBoxItem.setPickListFilterCriteriaFunction()} with {@link
 * com.smartgwt.client.widgets.form.fields.MultiComboBoxItem#setComboBoxProperties setComboBoxProperties()}.
 * @see com.smartgwt.client.widgets.form.fields.ComboBoxItem
 */
@BeanFactory.FrameworkClass
public class MultiComboBoxItem extends CanvasItem {

    public static MultiComboBoxItem getOrCreateRef(JavaScriptObject jsObj) {
        if (jsObj == null) return null;

        final RefDataClass existingObj = RefDataClass.getRef(jsObj);

        if (existingObj instanceof MultiComboBoxItem) {
            existingObj.setJsObj(jsObj);
            return (MultiComboBoxItem)existingObj;
        } else

        {
            return new MultiComboBoxItem(jsObj);
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(MultiComboBoxItem.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "Canvas");
        }
        defaults.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
        var cleanDefaultsJS = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(defaults.@com.smartgwt.client.widgets.BaseWidget::getConfig()(), true);
        $wnd.isc.MultiComboBoxItem.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(MultiComboBoxItem.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "FormItem");
        }
        defaults.@com.smartgwt.client.widgets.form.fields.FormItem::setConfigOnly(Z)(true);
    	var cleanDefaultsJS = defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getEditorTypeConfig()();
        $wnd.isc.MultiComboBoxItem.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
    }-*/;

    public static native void changePickerIconDefaults(FormItemIcon defaults) /*-{
        $wnd.isc.MultiComboBoxItem.changeDefaults("pickerIconDefaults", defaults.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;

    public MultiComboBoxItem(){
        setAttribute("editorType", "MultiComboBoxItem");
    }

    public MultiComboBoxItem(JavaScriptObject jsObj){
        super(jsObj);
    }


    public MultiComboBoxItem(String name) {
        setName(name);
                setAttribute("editorType", "MultiComboBoxItem");
    }


    public MultiComboBoxItem(String name, String title) {
        setName(name);
		setTitle(title);
                setAttribute("editorType", "MultiComboBoxItem");
    }


    // ********************* Properties / Attributes ***********************

    /**
     * Similar to {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem#getAddUnknownValues
     * ComboBoxItem.addUnknownValues}, controls whether additional values can be added to the ComboBox or whether the user must
     * choose from the available values in the picklist only. <p> If this setting is changed after the MultiComboBoxItem has
     * been created, the current value of the item is reset to null and all buttons for non-default values (values not in the
     * {@link com.smartgwt.client.widgets.form.fields.FormItem#getDefaultValue FormItem.defaultValue} array) are removed.
     *
     * @param addUnknownValues New addUnknownValues value. Default value is false
     * @return {@link com.smartgwt.client.widgets.form.fields.MultiComboBoxItem MultiComboBoxItem} instance, for chaining setter calls
     */
    public MultiComboBoxItem setAddUnknownValues(Boolean addUnknownValues) {
        return (MultiComboBoxItem)setAttribute("addUnknownValues", addUnknownValues);
    }

    /**
     * Similar to {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem#getAddUnknownValues
     * ComboBoxItem.addUnknownValues}, controls whether additional values can be added to the ComboBox or whether the user must
     * choose from the available values in the picklist only. <p> If this setting is changed after the MultiComboBoxItem has
     * been created, the current value of the item is reset to null and all buttons for non-default values (values not in the
     * {@link com.smartgwt.client.widgets.form.fields.FormItem#getDefaultValue FormItem.defaultValue} array) are removed.
     *
     * @return Current addUnknownValues value. Default value is false
     */
    public Boolean getAddUnknownValues()  {
        Boolean result = getAttributeAsBoolean("addUnknownValues", true);
        return result == null ? false : result;
    }
    

    /**
     * If true, hitting tab always exits the field, and will also add a value to the list of selected values if there is match
     * (and depending on the setting for {@link com.smartgwt.client.widgets.form.fields.MultiComboBoxItem#getAddUnknownValues
     * addUnknownValues}). <p> If false, if the user has typed in a value and hits tab, focus remains in the field. If there is
     * a match or if {@link com.smartgwt.client.widgets.form.fields.MultiComboBoxItem#getAddUnknownValues addUnknownValues} is
     * true, a value will be added. Otherwise, the input cursor remains at the end of the entered value.
     *
     * @param alwaysExitOnTab New alwaysExitOnTab value. Default value is true
     * @return {@link com.smartgwt.client.widgets.form.fields.MultiComboBoxItem MultiComboBoxItem} instance, for chaining setter calls
     */
    public MultiComboBoxItem setAlwaysExitOnTab(Boolean alwaysExitOnTab) {
        return (MultiComboBoxItem)setAttribute("alwaysExitOnTab", alwaysExitOnTab);
    }

    /**
     * If true, hitting tab always exits the field, and will also add a value to the list of selected values if there is match
     * (and depending on the setting for {@link com.smartgwt.client.widgets.form.fields.MultiComboBoxItem#getAddUnknownValues
     * addUnknownValues}). <p> If false, if the user has typed in a value and hits tab, focus remains in the field. If there is
     * a match or if {@link com.smartgwt.client.widgets.form.fields.MultiComboBoxItem#getAddUnknownValues addUnknownValues} is
     * true, a value will be added. Otherwise, the input cursor remains at the end of the entered value.
     *
     * @return Current alwaysExitOnTab value. Default value is true
     */
    public Boolean getAlwaysExitOnTab()  {
        Boolean result = getAttributeAsBoolean("alwaysExitOnTab", true);
        return result == null ? true : result;
    }
    

    /**
     * Should the MultiComboBoxItem fetch data from the {@link
     * com.smartgwt.client.widgets.form.fields.MultiComboBoxItem#getOptionDataSource data source} immediately or wait until the
     * user first opens the pickList.
     *
     * @param autoFetchData New autoFetchData value. Default value is false
     * @return {@link com.smartgwt.client.widgets.form.fields.MultiComboBoxItem MultiComboBoxItem} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.form.fields.ComboBoxItem#setAutoFetchData
     */
    public MultiComboBoxItem setAutoFetchData(Boolean autoFetchData) {
        return (MultiComboBoxItem)setAttribute("autoFetchData", autoFetchData);
    }

    /**
     * Should the MultiComboBoxItem fetch data from the {@link
     * com.smartgwt.client.widgets.form.fields.MultiComboBoxItem#getOptionDataSource data source} immediately or wait until the
     * user first opens the pickList.
     *
     * @return Current autoFetchData value. Default value is false
     * @see com.smartgwt.client.widgets.form.fields.ComboBoxItem#getAutoFetchData
     */
    public Boolean getAutoFetchData()  {
        Boolean result = getAttributeAsBoolean("autoFetchData", true);
        return result == null ? false : result;
    }
    

    /**
     * Specifies whether to autofit the buttons in the MultiComboBoxItem.  The default value is true if {@link
     * com.smartgwt.client.widgets.form.fields.MultiComboBoxItem#getLayoutStyle layoutStyle} is "flow", but false for a
     * layoutStyle of "vertical" or "verticalReverse".  If the <code>layoutStyle</code> is "horizontal" or "horizontalReverse"
     * then the buttons will autofit regardless of the setting of this property.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets the {@link com.smartgwt.client.widgets.form.fields.MultiComboBoxItem#getAutoFitButtons autoFitButtons} property.
     *
     * @param autoFitButtons whether to autofit the buttons. Default value is null
     * @return {@link com.smartgwt.client.widgets.form.fields.MultiComboBoxItem MultiComboBoxItem} instance, for chaining setter calls
     */
    public MultiComboBoxItem setAutoFitButtons(Boolean autoFitButtons) {
        return (MultiComboBoxItem)setAttribute("autoFitButtons", autoFitButtons);
    }

    /**
     * Specifies whether to autofit the buttons in the MultiComboBoxItem.  The default value is true if {@link
     * com.smartgwt.client.widgets.form.fields.MultiComboBoxItem#getLayoutStyle layoutStyle} is "flow", but false for a
     * layoutStyle of "vertical" or "verticalReverse".  If the <code>layoutStyle</code> is "horizontal" or "horizontalReverse"
     * then the buttons will autofit regardless of the setting of this property.
     *
     * @return Current autoFitButtons value. Default value is null
     */
    public Boolean getAutoFitButtons()  {
        return getAttributeAsBoolean("autoFitButtons", true);
    }
    

    /**
     * When this item is showing a  tree-based picker, which  nodes should be opened automatically.  Options are: <ul>
     * <li>"none" - no nodes are opened automatically</li> <li>"root" - opens the  top-level node - in databound              
     * tree-pickers, this node is always hidden</li> <li>"all" - when {@link
     * com.smartgwt.client.widgets.tree.ResultTree#getLoadDataOnDemand loading data on demand}, opens the             
     * top-level node and all of it's direct             descendants - otherwise, opens all loaded nodes </li> </ul>
     *
     * @param autoOpenTree New autoOpenTree value. Default value is "none"
     * @return {@link com.smartgwt.client.widgets.form.fields.MultiComboBoxItem MultiComboBoxItem} instance, for chaining setter calls
     */
    public MultiComboBoxItem setAutoOpenTree(String autoOpenTree) {
        return (MultiComboBoxItem)setAttribute("autoOpenTree", autoOpenTree);
    }

    /**
     * When this item is showing a  tree-based picker, which  nodes should be opened automatically.  Options are: <ul>
     * <li>"none" - no nodes are opened automatically</li> <li>"root" - opens the  top-level node - in databound              
     * tree-pickers, this node is always hidden</li> <li>"all" - when {@link
     * com.smartgwt.client.widgets.tree.ResultTree#getLoadDataOnDemand loading data on demand}, opens the             
     * top-level node and all of it's direct             descendants - otherwise, opens all loaded nodes </li> </ul>
     *
     * @return Current autoOpenTree value. Default value is "none"
     */
    public String getAutoOpenTree()  {
        return getAttributeAsString("autoOpenTree");
    }
    

    /**
     * <b>Note :</b> This API is non-functional (always returns null) and exists only to make
     * you aware that this MultiAutoChild exists.  See {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}
     * for details.
     * <p>
     * An {@link com.smartgwt.client.types.AutoChild} attribute used to create the buttons in the MultiComboBoxItem.
     *
     * @return null
     */
    public IButton getButton()  {
        return null;
    }
    

    /**
     * An {@link com.smartgwt.client.types.AutoChild} attribute to create the combo box in a MultiComboBoxItem.
     * <p>
     * This component is an AutoChild named "comboBox".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current comboBox value. Default value is null
     */
    public ComboBoxItem getComboBox()  {
        return ComboBoxItem.getOrCreateRef(getAttributeAsJavaScriptObject("comboBox"));
    }
    

    /**
     * Specifies the size of the combo box field. <P> Note that this attribute only has an effect in "flow", "horizontal", and
     * "horizontalReverse" {@link com.smartgwt.client.widgets.form.fields.MultiComboBoxItem#getLayoutStyle modes}.  In the
     * other modes, the combo box is as wide as the overall MultiComboBoxItem.
     *
     * @param comboBoxWidth New comboBoxWidth value. Default value is 130
     * @return {@link com.smartgwt.client.widgets.form.fields.MultiComboBoxItem MultiComboBoxItem} instance, for chaining setter calls
     */
    public MultiComboBoxItem setComboBoxWidth(int comboBoxWidth) {
        return (MultiComboBoxItem)setAttribute("comboBoxWidth", comboBoxWidth);
    }

    /**
     * Specifies the size of the combo box field. <P> Note that this attribute only has an effect in "flow", "horizontal", and
     * "horizontalReverse" {@link com.smartgwt.client.widgets.form.fields.MultiComboBoxItem#getLayoutStyle modes}.  In the
     * other modes, the combo box is as wide as the overall MultiComboBoxItem.
     *
     * @return Current comboBoxWidth value. Default value is 130
     */
    public int getComboBoxWidth()  {
        return getAttributeAsInt("comboBoxWidth");
    }
    

    /**
     * The {@link com.smartgwt.client.widgets.form.DynamicForm} holding the {@link
     * com.smartgwt.client.widgets.form.fields.MultiComboBoxItem#getComboBox comboBox}.
     * <p>
     * This component is an AutoChild named "comboForm".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current comboForm value. Default value is null
     */
    public DynamicForm getComboForm()  {
        return (DynamicForm)DynamicForm.getByJSObject(getAttributeAsJavaScriptObject("comboForm"));
    }
    

    /**
     * Whether to show the picker as a flat list, or a collapsible tree. <p> The default value, "list", will use an instance of
     * the  pickListConstructor as the picker - "tree" will  show an instance of  pickTreeConstructor.
     *
     * @param dataSetType New dataSetType value. Default value is "list"
     * @return {@link com.smartgwt.client.widgets.form.fields.MultiComboBoxItem MultiComboBoxItem} instance, for chaining setter calls
     */
    public MultiComboBoxItem setDataSetType(String dataSetType) {
        return (MultiComboBoxItem)setAttribute("dataSetType", dataSetType);
    }

    /**
     * Whether to show the picker as a flat list, or a collapsible tree. <p> The default value, "list", will use an instance of
     * the  pickListConstructor as the picker - "tree" will  show an instance of  pickTreeConstructor.
     *
     * @return Current dataSetType value. Default value is "list"
     */
    public String getDataSetType()  {
        return getAttributeAsString("dataSetType");
    }
    

    /**
     * When {@link com.smartgwt.client.widgets.form.fields.FormItem#getShowDeletions showDeletions} is <code>true</code>, the
     * {@link com.smartgwt.client.widgets.Button#getBaseStyle Button.baseStyle} used on {@link
     * com.smartgwt.client.widgets.form.fields.MultiComboBoxItem#getButton buttons} for values that have been deleted (also
     * called "deselected buttons"). <p> If unset, then the <code>baseStyle</code> of deselected buttons is not changed. <p>
     * <strong>NOTE:</strong> Deselected buttons are also disabled, so styling should be provided for the
     * <code>deselectedButtonStyle</code>&nbsp;+&nbsp;"Disabled" style name.
     *
     * @param deselectedButtonStyle New deselectedButtonStyle value. Default value is "buttonDeselected"
     * @return {@link com.smartgwt.client.widgets.form.fields.MultiComboBoxItem MultiComboBoxItem} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.form.fields.MultiComboBoxItem#setPendingButtonStyle
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public MultiComboBoxItem setDeselectedButtonStyle(String deselectedButtonStyle) {
        return (MultiComboBoxItem)setAttribute("deselectedButtonStyle", deselectedButtonStyle);
    }

    /**
     * When {@link com.smartgwt.client.widgets.form.fields.FormItem#getShowDeletions showDeletions} is <code>true</code>, the
     * {@link com.smartgwt.client.widgets.Button#getBaseStyle Button.baseStyle} used on {@link
     * com.smartgwt.client.widgets.form.fields.MultiComboBoxItem#getButton buttons} for values that have been deleted (also
     * called "deselected buttons"). <p> If unset, then the <code>baseStyle</code> of deselected buttons is not changed. <p>
     * <strong>NOTE:</strong> Deselected buttons are also disabled, so styling should be provided for the
     * <code>deselectedButtonStyle</code>&nbsp;+&nbsp;"Disabled" style name.
     *
     * @return Current deselectedButtonStyle value. Default value is "buttonDeselected"
     * @see com.smartgwt.client.widgets.form.fields.MultiComboBoxItem#getPendingButtonStyle
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public String getDeselectedButtonStyle()  {
        return getAttributeAsString("deselectedButtonStyle");
    }
    

    /**
     * The <code>displayField</code> of the combo box.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param displayField New displayField value. Default value is null
     * @return {@link com.smartgwt.client.widgets.form.fields.MultiComboBoxItem MultiComboBoxItem} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.form.fields.ComboBoxItem#setDisplayField
     */
    public MultiComboBoxItem setDisplayField(String displayField) {
        return (MultiComboBoxItem)setAttribute("displayField", displayField);
    }

    /**
     * The <code>displayField</code> of the combo box.
     *
     * @return Current displayField value. Default value is null
     * @see com.smartgwt.client.widgets.form.fields.ComboBoxItem#getDisplayField
     */
    public String getDisplayField()  {
        return getAttributeAsString("displayField");
    }
    

    /**
     * Specifies the layout style of the combo box and the buttons in the MultiComboBoxItem. Available values are "flow" (the
     * default), "horizontal", "horizontalReverse", "vertical", and "verticalReverse". <ul> <li><b>"flow"</b>:&nbsp; The
     * buttons appear to the left of the combo box.  When there is no more room, the combo box and/or buttons flow onto a new
     * line.  The buttons autoFit by default.</li> <li><b>"horizontal"</b>:&nbsp; The combo box appears on right and buttons
     * are horizontally stacked directly left of it.  The buttons must autofit.</li> <li><b>"horizontalReverse"</b>:&nbsp; Like
     * "horizontal" but the combo box appears on the left. The buttons must autofit.</li> <li><b>"vertical"</b>:&nbsp; The
     * combo box appears on top and buttons are stacked beneath it. Buttons do not autofit by default.</li>
     * <li><b>"verticalReverse"</b>:&nbsp; Like "vertical" but the combo box appears at bottom. The buttons do not autofit by
     * default.</li> </ul>
     *
     * @param layoutStyle the new layout style. Default value is "flow"
     * @return {@link com.smartgwt.client.widgets.form.fields.MultiComboBoxItem MultiComboBoxItem} instance, for chaining setter calls
     */
    public MultiComboBoxItem setLayoutStyle(MultiComboBoxLayoutStyle layoutStyle) {
        return (MultiComboBoxItem)setAttribute("layoutStyle", layoutStyle == null ? null : layoutStyle.getValue());
    }

    /**
     * Specifies the layout style of the combo box and the buttons in the MultiComboBoxItem. Available values are "flow" (the
     * default), "horizontal", "horizontalReverse", "vertical", and "verticalReverse". <ul> <li><b>"flow"</b>:&nbsp; The
     * buttons appear to the left of the combo box.  When there is no more room, the combo box and/or buttons flow onto a new
     * line.  The buttons autoFit by default.</li> <li><b>"horizontal"</b>:&nbsp; The combo box appears on right and buttons
     * are horizontally stacked directly left of it.  The buttons must autofit.</li> <li><b>"horizontalReverse"</b>:&nbsp; Like
     * "horizontal" but the combo box appears on the left. The buttons must autofit.</li> <li><b>"vertical"</b>:&nbsp; The
     * combo box appears on top and buttons are stacked beneath it. Buttons do not autofit by default.</li>
     * <li><b>"verticalReverse"</b>:&nbsp; Like "vertical" but the combo box appears at bottom. The buttons do not autofit by
     * default.</li> </ul>
     *
     * @return Current layoutStyle value. Default value is "flow"
     */
    public MultiComboBoxLayoutStyle getLayoutStyle()  {
        return EnumUtil.getEnum(MultiComboBoxLayoutStyle.values(), getAttribute("layoutStyle"));
    }
    
    

    /**
     * If this item has a specified <code>optionDataSource</code>, this attribute may be set to specify an explicit {@link
     * com.smartgwt.client.data.DSRequest#getOperationId DSRequest.operationId} when performing a fetch against the option
     * dataSource to pick up display value mapping.
     *
     * @param optionOperationId New optionOperationId value. Default value is null
     * @return {@link com.smartgwt.client.widgets.form.fields.MultiComboBoxItem MultiComboBoxItem} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.Databinding Databinding overview and related methods
     */
    public MultiComboBoxItem setOptionOperationId(String optionOperationId) {
        return (MultiComboBoxItem)setAttribute("optionOperationId", optionOperationId);
    }

    /**
     * If this item has a specified <code>optionDataSource</code>, this attribute may be set to specify an explicit {@link
     * com.smartgwt.client.data.DSRequest#getOperationId DSRequest.operationId} when performing a fetch against the option
     * dataSource to pick up display value mapping.
     *
     * @return Current optionOperationId value. Default value is null
     * @see com.smartgwt.client.docs.Databinding Databinding overview and related methods
     */
    public String getOptionOperationId()  {
        return getAttributeAsString("optionOperationId");
    }
    

    /**
     * When {@link com.smartgwt.client.widgets.form.fields.FormItem#getShowPending showPending} is <code>true</code>, the
     * {@link com.smartgwt.client.widgets.Button#getBaseStyle Button.baseStyle} used on {@link
     * com.smartgwt.client.widgets.form.fields.MultiComboBoxItem#getButton buttons} that are in the "Pending" visual state. <p>
     * If unset, then the <code>baseStyle</code> of pending buttons is not changed.
     *
     * @param pendingButtonStyle New pendingButtonStyle value. Default value is "buttonPending"
     * @return {@link com.smartgwt.client.widgets.form.fields.MultiComboBoxItem MultiComboBoxItem} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.form.fields.MultiComboBoxItem#setDeselectedButtonStyle
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public MultiComboBoxItem setPendingButtonStyle(String pendingButtonStyle) {
        return (MultiComboBoxItem)setAttribute("pendingButtonStyle", pendingButtonStyle);
    }

    /**
     * When {@link com.smartgwt.client.widgets.form.fields.FormItem#getShowPending showPending} is <code>true</code>, the
     * {@link com.smartgwt.client.widgets.Button#getBaseStyle Button.baseStyle} used on {@link
     * com.smartgwt.client.widgets.form.fields.MultiComboBoxItem#getButton buttons} that are in the "Pending" visual state. <p>
     * If unset, then the <code>baseStyle</code> of pending buttons is not changed.
     *
     * @return Current pendingButtonStyle value. Default value is "buttonPending"
     * @see com.smartgwt.client.widgets.form.fields.MultiComboBoxItem#getDeselectedButtonStyle
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public String getPendingButtonStyle()  {
        return getAttributeAsString("pendingButtonStyle");
    }
    

    /**
     * The Class to use when creating a picker of  type "list" for  a FormItem.  Must be a subclass of the builtin default, 
     * {@link com.smartgwt.client.widgets.form.PickListMenu PickListMenu}.
     *
     * @param pickListConstructor New pickListConstructor value. Default value is "PickListMenu"
     * @return {@link com.smartgwt.client.widgets.form.fields.MultiComboBoxItem MultiComboBoxItem} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.SCClassName SCClassName 
     * @see com.smartgwt.client.docs.PickList PickList overview and related methods
     */
    public MultiComboBoxItem setPickListConstructor(String pickListConstructor) {
        return (MultiComboBoxItem)setAttribute("pickListConstructor", pickListConstructor);
    }

    /**
     * The Class to use when creating a picker of  type "list" for  a FormItem.  Must be a subclass of the builtin default, 
     * {@link com.smartgwt.client.widgets.form.PickListMenu PickListMenu}.
     *
     * @return Current pickListConstructor value. Default value is "PickListMenu"
     * @see com.smartgwt.client.docs.SCClassName SCClassName 
     * @see com.smartgwt.client.docs.PickList PickList overview and related methods
     */
    public String getPickListConstructor()  {
        return getAttributeAsString("pickListConstructor");
    }
    

    /**
     * The Class to use when creating a picker of  type "tree" for  a FormItem.  Must be a subclass of the builtin default,  
     * PickTreeMenu.
     *
     * @param pickTreeConstructor New pickTreeConstructor value. Default value is "PickTreeMenu"
     * @return {@link com.smartgwt.client.widgets.form.fields.MultiComboBoxItem MultiComboBoxItem} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.SCClassName SCClassName 
     */
    public MultiComboBoxItem setPickTreeConstructor(String pickTreeConstructor) {
        return (MultiComboBoxItem)setAttribute("pickTreeConstructor", pickTreeConstructor);
    }

    /**
     * The Class to use when creating a picker of  type "tree" for  a FormItem.  Must be a subclass of the builtin default,  
     * PickTreeMenu.
     *
     * @return Current pickTreeConstructor value. Default value is "PickTreeMenu"
     * @see com.smartgwt.client.docs.SCClassName SCClassName 
     */
    public String getPickTreeConstructor()  {
        return getAttributeAsString("pickTreeConstructor");
    }
    

    /**
     * When this item is showing a  tree-based picker, this is  the {@link
     * com.smartgwt.client.widgets.form.fields.SelectItem#getValueField id} of the record to use as the  {@link
     * com.smartgwt.client.widgets.tree.Tree#getRootValue root} node.
     *
     * @param rootNodeId New rootNodeId value. Default value is null
     * @return {@link com.smartgwt.client.widgets.form.fields.MultiComboBoxItem MultiComboBoxItem} instance, for chaining setter calls
     */
    public MultiComboBoxItem setRootNodeId(String rootNodeId) {
        return (MultiComboBoxItem)setAttribute("rootNodeId", rootNodeId);
    }

    /**
     * When this item is showing a  tree-based picker, this is  the {@link
     * com.smartgwt.client.widgets.form.fields.SelectItem#getValueField id} of the record to use as the  {@link
     * com.smartgwt.client.widgets.tree.Tree#getRootValue root} node.
     *
     * @return Current rootNodeId value. Default value is null
     */
    public String getRootNodeId()  {
        return getAttributeAsString("rootNodeId");
    }

    /**
     * When this item is showing a  tree-based picker, this is  the {@link
     * com.smartgwt.client.widgets.form.fields.SelectItem#getValueField id} of the record to use as the  {@link
     * com.smartgwt.client.widgets.tree.Tree#getRootValue root} node.
     *
     * @param rootNodeId New rootNodeId value. Default value is null
     * @return {@link com.smartgwt.client.widgets.form.fields.MultiComboBoxItem MultiComboBoxItem} instance, for chaining setter calls
     */
    public MultiComboBoxItem setRootNodeId(Integer rootNodeId) {
        return (MultiComboBoxItem)setAttribute("rootNodeId", rootNodeId);
    }

    /**
     * When this item is showing a  tree-based picker, this is  the {@link
     * com.smartgwt.client.widgets.form.fields.SelectItem#getValueField id} of the record to use as the  {@link
     * com.smartgwt.client.widgets.tree.Tree#getRootValue root} node.
     *
     * @return Current rootNodeId value. Default value is null
     */
    public Integer getRootNodeIdAsInt()  {
        return getAttributeAsInt("rootNodeId");
    }
    

    /**
     * Should this item's value be saved in the form's values and hence returned from {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getValues form.getValues()}? <p> <code>shouldSaveValue:false</code> is used
     * to mark formItems which do not correspond to the underlying data model and should not save a value into the form's
     * {@link com.smartgwt.client.widgets.form.DynamicForm#getValues values}.  Example includes visual separators, password
     * re-type fields, or checkboxes used to show/hide other form items. <p> A <code>shouldSaveValue:false</code> item should
     * be given a value either via {@link com.smartgwt.client.widgets.form.fields.FormItem#getDefaultValue
     * FormItem.defaultValue} or by calling {@link com.smartgwt.client.widgets.form.DynamicForm#setValue form.setValue(item,
     * value)} or  {@link com.smartgwt.client.widgets.form.fields.FormItem#setValue formItem.setValue(value)}.  Providing a
     * value via {@link com.smartgwt.client.widgets.form.DynamicForm#getValues form.values} or {@link
     * com.smartgwt.client.widgets.form.DynamicForm#setValues form.setValues()}  will automatically switch the item to
     * <code>shouldSaveValue:true</code>. <P> Note that <ul> <li>if an item is shouldSaveValue true, but has no name, a warning
     * is logged, and      shouldSaveValue will be set to false. </li></ul>
     *
     * @param shouldSaveValue New shouldSaveValue value. Default value is true
     * @return {@link com.smartgwt.client.widgets.form.fields.MultiComboBoxItem MultiComboBoxItem} instance, for chaining setter calls
     */
    public MultiComboBoxItem setShouldSaveValue(Boolean shouldSaveValue) {
        return (MultiComboBoxItem)setAttribute("shouldSaveValue", shouldSaveValue);
    }

    /**
     * Should this item's value be saved in the form's values and hence returned from {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getValues form.getValues()}? <p> <code>shouldSaveValue:false</code> is used
     * to mark formItems which do not correspond to the underlying data model and should not save a value into the form's
     * {@link com.smartgwt.client.widgets.form.DynamicForm#getValues values}.  Example includes visual separators, password
     * re-type fields, or checkboxes used to show/hide other form items. <p> A <code>shouldSaveValue:false</code> item should
     * be given a value either via {@link com.smartgwt.client.widgets.form.fields.FormItem#getDefaultValue
     * FormItem.defaultValue} or by calling {@link com.smartgwt.client.widgets.form.DynamicForm#setValue form.setValue(item,
     * value)} or  {@link com.smartgwt.client.widgets.form.fields.FormItem#setValue formItem.setValue(value)}.  Providing a
     * value via {@link com.smartgwt.client.widgets.form.DynamicForm#getValues form.values} or {@link
     * com.smartgwt.client.widgets.form.DynamicForm#setValues form.setValues()}  will automatically switch the item to
     * <code>shouldSaveValue:true</code>. <P> Note that <ul> <li>if an item is shouldSaveValue true, but has no name, a warning
     * is logged, and      shouldSaveValue will be set to false. </li></ul>
     *
     * @return Current shouldSaveValue value. Default value is true
     */
    public Boolean getShouldSaveValue()  {
        Boolean result = getAttributeAsBoolean("shouldSaveValue", true);
        return result == null ? true : result;
    }
    

    /**
     * Specifies whether to arrange the buttons of the MultiComboBoxItem in the order that they were selected (the default), or
     * to sort the buttons by {@link com.smartgwt.client.widgets.form.fields.MultiComboBoxItem#getDisplayField displayField}.
     *
     * @param useInsertionOrder New useInsertionOrder value. Default value is true
     * @return {@link com.smartgwt.client.widgets.form.fields.MultiComboBoxItem MultiComboBoxItem} instance, for chaining setter calls
     */
    public MultiComboBoxItem setUseInsertionOrder(Boolean useInsertionOrder) {
        return (MultiComboBoxItem)setAttribute("useInsertionOrder", useInsertionOrder);
    }

    /**
     * Specifies whether to arrange the buttons of the MultiComboBoxItem in the order that they were selected (the default), or
     * to sort the buttons by {@link com.smartgwt.client.widgets.form.fields.MultiComboBoxItem#getDisplayField displayField}.
     *
     * @return Current useInsertionOrder value. Default value is true
     */
    public Boolean getUseInsertionOrder()  {
        Boolean result = getAttributeAsBoolean("useInsertionOrder", true);
        return result == null ? true : result;
    }
    

    /**
     * The <code>valueField</code> of the combo box.
     *
     * @param valueField New valueField value. Default value is null
     * @return {@link com.smartgwt.client.widgets.form.fields.MultiComboBoxItem MultiComboBoxItem} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.form.fields.ComboBoxItem#setValueField
     */
    public MultiComboBoxItem setValueField(String valueField) {
        return (MultiComboBoxItem)setAttribute("valueField", valueField);
    }

    /**
     * The <code>valueField</code> of the combo box.
     *
     * @return Current valueField value. Default value is null
     * @see com.smartgwt.client.widgets.form.fields.ComboBoxItem#getValueField
     */
    public String getValueField()  {
        return getAttributeAsString("valueField");
    }
    

    /**
     * <b>Note :</b> This API is non-functional (always returns null) and exists only to make
     * you aware that this MultiAutoChild exists.  See {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}
     * for details.
     * <p>
     * The layout used to arrange the {@link com.smartgwt.client.widgets.form.fields.MultiComboBoxItem#getComboForm comboForm}
     * and the buttons representing the values of the MultiComboBoxItem. Note that the constructor cannot be changed (setting a
     * valueLayoutConstructor has no effect) because the exact layout class used depends on the current {@link
     * com.smartgwt.client.widgets.form.fields.MultiComboBoxItem#getLayoutStyle layout style}.
     *
     * @return null
     */
    public Layout getValueLayout()  {
        return null;
    }
    
    

    // ********************* Methods ***********************
	/**
     * Notification method called when {@link com.smartgwt.client.widgets.form.fields.FormItem#getShowPending showPending} is
     * enabled and this <code>MultiComboBoxItem</code> should either clear or show its pending visual state. <p> The default
     * behavior is that the {@link com.smartgwt.client.widgets.form.fields.FormItem#getTitleStyle titleStyle} and {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getCellStyle cellStyle} are updated to include/exclude the "Pending"
     * suffix. In addition, when displayed in the pending state and a {@link
     * com.smartgwt.client.widgets.form.fields.MultiComboBoxItem#getPendingButtonStyle pendingButtonStyle} is set, then: <ul>
     * <li>If {@link com.smartgwt.client.widgets.form.fields.MultiComboBoxItem#getUseInsertionOrder useInsertionOrder} is
     * <code>false</code>, buttons for     any new values will have their {@link
     * com.smartgwt.client.widgets.Button#getBaseStyle baseStyle} set to     <code>pendingButtonStyle</code>; otherwise
     * <li>(<code>useInsertionOrder</code> is <code>true</code>) buttons for values will have their     {@link
     * com.smartgwt.client.widgets.Button#getBaseStyle baseStyle} set to <code>pendingButtonStyle</code> if either the    
     * value is new or it is in a different place within the value array. </ul> Returning <code>false</code> will cancel this
     * default behavior.
     * @param form the managing <code>DynamicForm</code> instance.
     * @param item the form item itself (also available as "this").
     * @param pendingStatus <code>true</code> if the item should show its pending visual state; <code>false</code> otherwise.
     * @param newValue the current form item value.
     * @param value the value that would be restored by a call to {@link com.smartgwt.client.widgets.form.DynamicForm#resetValues
     * DynamicForm.resetValues()}.
     *
     * @return <code>false</code> to cancel the default behavior.
     * 
     */
    public native boolean pendingStatusChanged(DynamicForm form, FormItem item, boolean pendingStatus, Object newValue, Object value) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        var ret = self.pendingStatusChanged(form == null ? null : form.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()(), item.@com.smartgwt.client.core.DataClass::getJsObj()(), pendingStatus, newValue, value);
        return ret == null ? false : ret;
    }-*/;

	/**
     * This method will be called whenever this FormItem's value is being set via a programmatic call to e.g: {@link
     * com.smartgwt.client.widgets.form.DynamicForm#setValues DynamicForm.setValues()} or {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#setValue FormItem.setValue()} and may be overridden by CanvasItems
     * intended to support displaying data values to update the embedded Canvas to reflect the value passed in. <p> The value
     * of a MultiComboBoxItem to the form is an array of valueField values corresponding to the selected combo box options.
     * @param displayValue new display value for the item.  This is the value after applying   any custom formatter or valueMap
     * @param dataValue underlying data value for the item
     * @param form the dynamicForm in which this item is contained
     * @param item the live form item instance
     */
    public native void showValue(Object displayValue, Object dataValue, DynamicForm form, CanvasItem item) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.showValue(displayValue, dataValue, form == null ? null : form.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()(), item.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;


    // ********************* Static Methods ***********************

    /** 
     * Class level method to set the default properties of this class.  If set, then all
     * existing and subsequently created instances of this class will automatically have
     * default properties corresponding to
     * the properties of the class instance passed to this function.
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
     * @param multiComboBoxItemProperties properties that should be used as new defaults when instances of this class are created
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public static native void setDefaultProperties(MultiComboBoxItem multiComboBoxItemProperties) /*-{
        if (multiComboBoxItemProperties.@com.smartgwt.client.widgets.form.fields.FormItem::isCreated()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Class;)(MultiComboBoxItem.@java.lang.Object::getClass()(), "setDefaultProperties", multiComboBoxItemProperties.@java.lang.Object::getClass()());
        }
        multiComboBoxItemProperties.@com.smartgwt.client.widgets.form.fields.FormItem::setConfigOnly(Z)(true);
    	var properties = multiComboBoxItemProperties.@com.smartgwt.client.widgets.form.fields.FormItem::getConfig()();
        $wnd.isc.MultiComboBoxItem.addProperties(properties);
    }-*/;

    // ***********************************************************



    /**
     * Default properties to be used in creating each {@link com.smartgwt.client.widgets.IButton}.
     *
     *
     * @return IButton
     */
    public IButton getButtonDefaults()  {
        return new IButton(getAttributeAsJavaScriptObject("buttonDefaults"));
    }

    /**
     * Properties to be used in creating each option button.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param buttonProperties buttonProperties
     */
    public void setButtonProperties(IButton buttonProperties) {
        if (buttonProperties.isCreated()) {
            ConfigUtil.warnOfPreConfigInstantiation(this.getClass(), "setButtonProperties", "IButton");
        }                                                                       
        buttonProperties.setConfigOnly(true);
        setAttribute("buttonProperties", JSOHelper.cleanProperties(buttonProperties.getConfig(), true));
    }

    /**
     * Properties to be used in creating each option button.
     *
     *
     * @return IButton
     */
    public IButton getButtonProperties()  {
        return new IButton(getAttributeAsJavaScriptObject("buttonProperties"));
    }

    /**
     * Default properties for the {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem} in a MultiComboBoxItem.
     *
     *
     * @return ComboBoxItem
     */
    public ComboBoxItem getComboBoxDefaults()  {
        return new ComboBoxItem(getAttributeAsJavaScriptObject("comboBoxDefaults"));
    }

    /**
     * Properties to be used in creating a {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem}.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param comboBoxProperties comboBoxProperties Default value is null
     */
    public void setComboBoxProperties(ComboBoxItem comboBoxProperties) {
        setAutoChildProperties("comboBox", comboBoxProperties);
    }

    /**
     * Properties to be used in creating a {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem}.
     *
     *
     * @return ComboBoxItem
     */
    public ComboBoxItem getComboBoxProperties()  {
        return new ComboBoxItem(getAttributeAsJavaScriptObject("comboBoxProperties"));
    }

    /**
     * The <code>optionDataSource</code> of the combo box.
     *
     * @param optionDataSource optionDataSource Default value is null
     * @return {@link com.smartgwt.client.widgets.form.fields.MultiComboBoxItem MultiComboBoxItem}
     * instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.form.fields.ComboBoxItem#setOptionDataSource
     */
    public MultiComboBoxItem setOptionDataSource(DataSource optionDataSource) {
        return (MultiComboBoxItem)setAttribute("optionDataSource", optionDataSource);
    }

    /**
     * The <code>optionDataSource</code> of the combo box.
     *
     *
     * @return DataSource
     * @see com.smartgwt.client.widgets.form.fields.ComboBoxItem#getOptionDataSource
     */
    public DataSource getOptionDataSource()  {
        return DataSource.getOrCreateRef(getAttributeAsJavaScriptObject("optionDataSource"));
    }

    public final native String[] getValues() /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        var value;
        if (self.getValue) {
             value = self.getValue();
        } else {
            value = self.value;
        }
        if (value == null) {
            value = [];
        } else if (!$wnd.isc.isA.Array(value)) {
            value = [value];
        }
        return @com.smartgwt.client.util.JSOHelper::convertToJavaStringArray(Lcom/google/gwt/core/client/JavaScriptObject;)(value);
    }-*/;

    public native void setValues(Object... values) /*-{
        var jsArray = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;Z)(values, true);
        this.@com.smartgwt.client.widgets.form.fields.FormItem::doSetValue(Ljava/lang/Object;)(jsArray);
    }-*/;

}
