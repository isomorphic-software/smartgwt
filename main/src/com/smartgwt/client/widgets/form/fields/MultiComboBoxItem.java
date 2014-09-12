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
 * A MultiComboBoxItem is a combo box that allows the user to select multiple options.  Each selected option is represented
 * as a button that can be clicked to deselect the option. The relative layout of the buttons to the combo box is specified
 * with the {@link com.smartgwt.client.widgets.form.fields.MultiComboBoxItem#getLayoutStyle layoutStyle} attribute.  The
 * buttons will be kept in the order that they were added, with the most recently added button being adjacent to the combo
 * box. <code>MultiComboBoxItem</code> uses the {@link com.smartgwt.client.types.AutoChild} pattern to construct the {@link
 * com.smartgwt.client.widgets.form.fields.MultiComboBoxItem#getComboBox comboBox} and the {@link
 * com.smartgwt.client.widgets.form.fields.MultiComboBoxItem#getButton buttons} so that they can be easily customized.  For
 * example, you can customize the criteria used to fetch by  <smartgwt>using
 * +sgwtLink{ComboBoxItem.setPickListFilterCriteriaFunction()} with
 * +sgwtLink{MultiComboBoxItem.setComboBoxProperties,setComboBoxProperties()}<smartgwt>.
 * @see com.smartgwt.client.widgets.form.fields.ComboBoxItem
 */
@BeanFactory.FrameworkClass
public class MultiComboBoxItem extends CanvasItem {

    public static MultiComboBoxItem getOrCreateRef(JavaScriptObject jsObj) {

        if(jsObj == null) return null;

        RefDataClass obj = RefDataClass.getRef(jsObj);

		if(obj != null && JSOHelper.getAttribute(jsObj,"__ref")==null) {
            return com.smartgwt.client.util.ObjectFactory.createFormItem("MultiComboBoxItem",jsObj);

        } else
        if(obj != null) {
            obj.setJsObj(jsObj);
            return (MultiComboBoxItem) obj;
        } else {
            return new MultiComboBoxItem(jsObj);
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
        $wnd.isc.MultiComboBoxItem.changeDefaults(autoChildName + "Defaults", defaults.@com.smartgwt.client.widgets.Canvas::getConfig()());
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
        $wnd.isc.MultiComboBoxItem.changeDefaults(autoChildName + "Defaults", defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getJsObj()());
    }-*/;
    /**
     * Changes the defaults for DrawItem AutoChildren named <code>autoChildName</code>.
     *
     * @param autoChildName name of an AutoChild to customize the defaults for.
     * @param defaults DrawItem defaults to apply. These defaults override any existing properties
     * without destroying or wiping out non-overridden properties.
     * @see com.smartgwt.client.docs.AutoChildUsage
     */
    public static native void changeAutoChildDefaults(String autoChildName, DrawItem defaults) /*-{
        $wnd.isc.MultiComboBoxItem.changeDefaults(autoChildName + "Defaults", defaults.@com.smartgwt.client.widgets.drawing.DrawItem::getJsObj()());
    }-*/;

    public static native void changePickerIconDefaults(FormItemIcon defaults) /*-{
        $wnd.isc.MultiComboBoxItem.changeDefaults("pickerIconDefaults", defaults.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;

    public MultiComboBoxItem(){
        setAttribute("editorType", "MultiComboBoxItem");
    }

    public MultiComboBoxItem(JavaScriptObject jsObj){
        
        setJavaScriptObject(jsObj);
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
     * Similar to {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem#getAddUnknownValues addUnknownValues}, controls
     * whether additional values can be added to the ComboBox or whether the user must choose from the available values in the
     * picklist only. <p> If this setting is changed after the MultiComboBoxItem has been created, the current value of the
     * item is reset to null and all buttons for non-default values (values not in the {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getDefaultValue defaultValue} array) are removed.
     *
     * @param addUnknownValues  Default value is false
     */
    public void setAddUnknownValues(Boolean addUnknownValues) {
        setAttribute("addUnknownValues", addUnknownValues);
    }

    /**
     * Similar to {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem#getAddUnknownValues addUnknownValues}, controls
     * whether additional values can be added to the ComboBox or whether the user must choose from the available values in the
     * picklist only. <p> If this setting is changed after the MultiComboBoxItem has been created, the current value of the
     * item is reset to null and all buttons for non-default values (values not in the {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getDefaultValue defaultValue} array) are removed.
     *
     * @return Boolean
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
     * @param alwaysExitOnTab  Default value is true
     */
    public void setAlwaysExitOnTab(Boolean alwaysExitOnTab) {
        setAttribute("alwaysExitOnTab", alwaysExitOnTab);
    }

    /**
     * If true, hitting tab always exits the field, and will also add a value to the list of selected values if there is match
     * (and depending on the setting for {@link com.smartgwt.client.widgets.form.fields.MultiComboBoxItem#getAddUnknownValues
     * addUnknownValues}). <p> If false, if the user has typed in a value and hits tab, focus remains in the field. If there is
     * a match or if {@link com.smartgwt.client.widgets.form.fields.MultiComboBoxItem#getAddUnknownValues addUnknownValues} is
     * true, a value will be added. Otherwise, the input cursor remains at the end of the entered value.
     *
     * @return Boolean
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
     * @param autoFetchData  Default value is false
     * @see com.smartgwt.client.widgets.form.fields.ComboBoxItem#setAutoFetchData
     */
    public void setAutoFetchData(Boolean autoFetchData) {
        setAttribute("autoFetchData", autoFetchData);
    }

    /**
     * Should the MultiComboBoxItem fetch data from the {@link
     * com.smartgwt.client.widgets.form.fields.MultiComboBoxItem#getOptionDataSource data source} immediately or wait until the
     * user first opens the pickList.
     *
     * @return Boolean
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
     */
    public void setAutoFitButtons(Boolean autoFitButtons) {
        setAttribute("autoFitButtons", autoFitButtons);
    }

    /**
     * Specifies whether to autofit the buttons in the MultiComboBoxItem.  The default value is true if {@link
     * com.smartgwt.client.widgets.form.fields.MultiComboBoxItem#getLayoutStyle layoutStyle} is "flow", but false for a
     * layoutStyle of "vertical" or "verticalReverse".  If the <code>layoutStyle</code> is "horizontal" or "horizontalReverse"
     * then the buttons will autofit regardless of the setting of this property.
     *
     * @return Boolean
     */
    public Boolean getAutoFitButtons()  {
        return getAttributeAsBoolean("autoFitButtons", true);
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
     * For an overview of how to use and configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return ComboBoxItem
     */
    public ComboBoxItem getComboBox()  {
        return ComboBoxItem.getOrCreateRef(getAttributeAsJavaScriptObject("comboBox"));
    }
    

    /**
     * Specifies the size of the combo box field. <P> Note that this attribute only has an effect in "flow", "horizontal", and
     * "horizontalReverse" {@link com.smartgwt.client.widgets.form.fields.MultiComboBoxItem#getLayoutStyle modes}.  In the
     * other modes, the combo box is as wide as the overall MultiComboBoxItem.
     *
     * @param comboBoxWidth  Default value is 130
     */
    public void setComboBoxWidth(int comboBoxWidth) {
        setAttribute("comboBoxWidth", comboBoxWidth);
    }

    /**
     * Specifies the size of the combo box field. <P> Note that this attribute only has an effect in "flow", "horizontal", and
     * "horizontalReverse" {@link com.smartgwt.client.widgets.form.fields.MultiComboBoxItem#getLayoutStyle modes}.  In the
     * other modes, the combo box is as wide as the overall MultiComboBoxItem.
     *
     * @return int
     */
    public int getComboBoxWidth()  {
        return getAttributeAsInt("comboBoxWidth");
    }
    

    /**
     * The {@link com.smartgwt.client.widgets.form.DynamicForm} holding the {@link
     * com.smartgwt.client.widgets.form.fields.MultiComboBoxItem#getComboBox comboBox}.
     * <p>
     * For an overview of how to use and configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return DynamicForm
     */
    public DynamicForm getComboForm()  {
        return (DynamicForm)DynamicForm.getByJSObject(getAttributeAsJavaScriptObject("comboForm"));
    }
    

    /**
     * The <code>displayField</code> of the combo box.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param displayField  Default value is null
     * @see com.smartgwt.client.widgets.form.fields.ComboBoxItem#setDisplayField
     */
    public void setDisplayField(String displayField) {
        setAttribute("displayField", displayField);
    }

    /**
     * The <code>displayField</code> of the combo box.
     *
     * @return String
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
     */
    public void setLayoutStyle(MultiComboBoxLayoutStyle layoutStyle) {
        setAttribute("layoutStyle", layoutStyle == null ? null : layoutStyle.getValue());
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
     * @return MultiComboBoxLayoutStyle
     */
    public MultiComboBoxLayoutStyle getLayoutStyle()  {
        return EnumUtil.getEnum(MultiComboBoxLayoutStyle.values(), getAttribute("layoutStyle"));
    }
    
    

    /**
     * Specifies whether to arrange the buttons of the MultiComboBoxItem in the order that they were selected (the default), or
     * to sort the buttons by {@link com.smartgwt.client.widgets.form.fields.MultiComboBoxItem#getDisplayField displayField}.
     *
     * @param useInsertionOrder  Default value is true
     */
    public void setUseInsertionOrder(Boolean useInsertionOrder) {
        setAttribute("useInsertionOrder", useInsertionOrder);
    }

    /**
     * Specifies whether to arrange the buttons of the MultiComboBoxItem in the order that they were selected (the default), or
     * to sort the buttons by {@link com.smartgwt.client.widgets.form.fields.MultiComboBoxItem#getDisplayField displayField}.
     *
     * @return Boolean
     */
    public Boolean getUseInsertionOrder()  {
        Boolean result = getAttributeAsBoolean("useInsertionOrder", true);
        return result == null ? true : result;
    }
    

    /**
     * The <code>valueField</code> of the combo box.
     *
     * @param valueField  Default value is null
     * @see com.smartgwt.client.widgets.form.fields.ComboBoxItem#setValueField
     */
    public void setValueField(String valueField) {
        setAttribute("valueField", valueField);
    }

    /**
     * The <code>valueField</code> of the combo box.
     *
     * @return String
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
     * This method will be called whenever this FormItem's value is being set via a programmatic call to e.g: {@link
     * com.smartgwt.client.widgets.form.DynamicForm#setValues DynamicForm.setValues} or {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#setValue FormItem.setValue} and may be overridden by CanvasItems
     * intended to support displaying data values to update the embedded Canvas to reflect the value passed in. <p> The value
     * of a MultiComboBoxItem to the form is an array of valueField values corresponding to the selected combo box options.
     * @param displayValue new display value for the item.  This is the value after applying   any custom formatter or valueMap
     * @param dataValue underlying data value for the item
     * @param form the dynamicForm in which this item is contained
     * @param item the live form item instance
     */
    public native void showValue(Object displayValue, Object dataValue, DynamicForm form, CanvasItem item) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.showValue(displayValue, dataValue, form.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()(), item.@com.smartgwt.client.core.DataClass::getJsObj()());
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
     */
    public static native void setDefaultProperties(MultiComboBoxItem multiComboBoxItemProperties) /*-{
    	var properties = $wnd.isc.addProperties({},multiComboBoxItemProperties.@com.smartgwt.client.core.RefDataClass::getJsObj()());
        @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(properties,false);
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
        setAttribute("buttonProperties", buttonProperties.getConfig());
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
     * @see com.smartgwt.client.widgets.form.fields.ComboBoxItem#setOptionDataSource
     */
    public void setOptionDataSource(DataSource optionDataSource) {
        setAttribute("optionDataSource", optionDataSource);
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



