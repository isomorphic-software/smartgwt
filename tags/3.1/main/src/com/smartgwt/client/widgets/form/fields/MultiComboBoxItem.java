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
 
package com.smartgwt.client.widgets.form.fields;



import com.smartgwt.client.event.*;
import com.smartgwt.client.core.*;
import com.smartgwt.client.types.*;
import com.smartgwt.client.data.*;
import com.smartgwt.client.data.events.*;
import com.smartgwt.client.rpc.*;
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
import com.smartgwt.client.widgets.tab.*;
import com.smartgwt.client.widgets.toolbar.*;
import com.smartgwt.client.widgets.tree.*;
import com.smartgwt.client.widgets.tree.events.*;
import com.smartgwt.client.widgets.viewer.*;
import com.smartgwt.client.widgets.calendar.*;
import com.smartgwt.client.widgets.calendar.events.*;
import com.smartgwt.client.widgets.cube.*;
import com.smartgwt.client.widgets.drawing.*;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashMap;

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
import com.smartgwt.logicalstructure.widgets.tab.*;
import com.smartgwt.logicalstructure.widgets.tableview.*;
import com.smartgwt.logicalstructure.widgets.toolbar.*;
import com.smartgwt.logicalstructure.widgets.tree.*;
import com.smartgwt.logicalstructure.widgets.viewer.*;
import com.smartgwt.logicalstructure.widgets.calendar.*;
import com.smartgwt.logicalstructure.widgets.cube.*;

/**
 * A MultiComboBoxItem is a combo box that allows the user to select multiple options.  Each selected option is represented
 * as a button that can be clicked to deselect the option. The relative layout of the buttons to the combo box is specified
 * with the {@link com.smartgwt.client.widgets.form.fields.MultiComboBoxItem#getLayoutStyle layoutStyle} attribute.  The
 * buttons will be kept in the order that they were added, with the most recently added button being adjacent to the combo
 * box. MultiComboBoxItem uses the AutoChild pattern to construct the combo box and the buttons so that they can be easily
 * customized.
 * @see com.smartgwt.client.widgets.form.fields.ComboBoxItem
 */
public class MultiComboBoxItem extends CanvasItem {

    public static MultiComboBoxItem getOrCreateRef(JavaScriptObject jsObj) {
    
        if(jsObj == null) return null;

        RefDataClass obj = RefDataClass.getRef(jsObj);

 
        if(obj != null) {
            obj.setJsObj(jsObj);
            return (MultiComboBoxItem) obj;
        } else {
            return new MultiComboBoxItem(jsObj);
        }
    }

    public void setJavaScriptObject(JavaScriptObject jsObj) {
        this.jsObj = jsObj;
    }


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
     * Should the MultiComboBoxItem fetch data from the {@link
     * com.smartgwt.client.widgets.form.fields.MultiComboBoxItem#getOptionDataSource data source} immediately or wait until the
     * user first opens the pickList.
     *
     * @param autoFetchData autoFetchData Default value is false
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
     *
     * @return Boolean
     * @see com.smartgwt.client.widgets.form.fields.ComboBoxItem#getAutoFetchData
     */
    public Boolean getAutoFetchData()  {
        return getAttributeAsBoolean("autoFetchData");
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
     *
     * @return Boolean
     */
    public Boolean getAutoFitButtons()  {
        return getAttributeAsBoolean("autoFitButtons");
    }

    /**
     * Specifies the size of the combo box field. <P> Note that this attribute only has an effect in "flow", "horizontal", and
     * "horizontalReverse" {@link com.smartgwt.client.widgets.form.fields.MultiComboBoxItem#getLayoutStyle modes}.  In the
     * other modes, the combo box is as wide as the overall MultiComboBoxItem.
     *
     * @param comboBoxWidth comboBoxWidth Default value is null
     */
    public void setComboBoxWidth(Integer comboBoxWidth) {
        setAttribute("comboBoxWidth", comboBoxWidth);
    }

    /**
     * Specifies the size of the combo box field. <P> Note that this attribute only has an effect in "flow", "horizontal", and
     * "horizontalReverse" {@link com.smartgwt.client.widgets.form.fields.MultiComboBoxItem#getLayoutStyle modes}.  In the
     * other modes, the combo box is as wide as the overall MultiComboBoxItem.
     *
     *
     * @return Integer
     */
    public Integer getComboBoxWidth()  {
        return getAttributeAsInt("comboBoxWidth");
    }

    /**
     * The <code>displayField</code> of the combo box.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param displayField . See {@link com.smartgwt.client.docs.String String}. Default value is null
     * @see com.smartgwt.client.widgets.form.fields.ComboBoxItem#setDisplayField
     */
    public void setDisplayField(String displayField) {
        setAttribute("displayField", displayField);
    }

    /**
     * The <code>displayField</code> of the combo box.
     *
     *
     * @return . See {@link com.smartgwt.client.docs.String String}
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
     * @param useInsertionOrder useInsertionOrder Default value is true
     */
    public void setUseInsertionOrder(Boolean useInsertionOrder) {
        setAttribute("useInsertionOrder", useInsertionOrder);
    }

    /**
     * Specifies whether to arrange the buttons of the MultiComboBoxItem in the order that they were selected (the default), or
     * to sort the buttons by {@link com.smartgwt.client.widgets.form.fields.MultiComboBoxItem#getDisplayField displayField}.
     *
     *
     * @return Boolean
     */
    public Boolean getUseInsertionOrder()  {
        return getAttributeAsBoolean("useInsertionOrder");
    }

    /**
     * The <code>valueField</code> of the combo box.
     *
     * @param valueField . See {@link com.smartgwt.client.docs.String String}. Default value is null
     * @see com.smartgwt.client.widgets.form.fields.ComboBoxItem#setValueField
     */
    public void setValueField(String valueField) {
        setAttribute("valueField", valueField);
    }

    /**
     * The <code>valueField</code> of the combo box.
     *
     *
     * @return . See {@link com.smartgwt.client.docs.String String}
     * @see com.smartgwt.client.widgets.form.fields.ComboBoxItem#getValueField
     */
    public String getValueField()  {
        return getAttributeAsString("valueField");
    }

    // ********************* Methods ***********************

    /**
     * This method will be called whenever this form item's value is being set via a programmatic call to e.g: {@link
     * com.smartgwt.client.widgets.form.DynamicForm#setValues DynamicForm.setValues} or {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#setValue FormItem.setValue} and may be overridden by CanvasItems
     * intended to support displaying data values to update the embedded Canvas to reflect the value passed in.
     * @param displayValue new display-value for the item. This is the value after applying   any custom formatter or valueMap
     * @param dataValue underlying data value for the item
     * @param form the dynamicForm in which this item is contained
     * @param item the live form item instance
     */
    public native void showValue(Object displayValue, Object dataValue, DynamicForm form, CanvasItem item) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.showValue(displayValue, dataValue, form.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()(), item.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;

    // ********************* Static Methods ***********************
        
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
    public void setButtonProperties(JavaScriptObject buttonProperties) {
        setAttribute("buttonProperties", withoutID(buttonProperties));
    }

    /**
     * Properties to be used in creating each option button.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param buttonProperties buttonProperties
     */
    public void setButtonProperties(IButton buttonProperties) {
        setButtonProperties(buttonProperties.getConfig());
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
    public void setComboBoxProperties(JavaScriptObject comboBoxProperties) {
        setAttribute("comboBoxProperties", withoutID(comboBoxProperties));
    }

    /**
     * Properties to be used in creating a {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem}.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param comboBoxProperties comboBoxProperties Default value is null
     */
    public void setComboBoxProperties(ComboBoxItem comboBoxProperties) {
        setComboBoxProperties(comboBoxProperties.getConfig());
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

    private static native JavaScriptObject withoutID(JavaScriptObject jsObj) /*-{
        var obj = $wnd.isc.addProperties({}, jsObj);
        delete obj.ID;
        return obj;
    }-*/;

}






