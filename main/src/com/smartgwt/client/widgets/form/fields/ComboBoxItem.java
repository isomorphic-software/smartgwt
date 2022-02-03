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
 * The Combobox is a text input field which can show a list of options via a drop-down PickList. <p> The set of options
 * will be filtered based on the current value in the text field, so only options that match what has been typed so far
 * will be displayed. The set of options can be derived from a ValueMap or dynamically retrieved from a dataSource.  See
 * the PickList interface for further settings. <P> The two most common use cases for ComboBoxItems are: <ul><li>With
 * {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem#getAddUnknownValues addUnknownValues} set to true, the
 * ComboBoxItem acts as a  freeform text entry field with the picklist providing essentially a set of suggested completions
 * similar to a URL bar in a web browser.</li>     <li>With {@link
 * com.smartgwt.client.widgets.form.fields.ComboBoxItem#getAddUnknownValues addUnknownValues} set to false, the
 * ComboBoxItem acts similarly  to a SelectItem where a fixed set of options is available to the user and the text entry
 * field  is essentially used to filter which of these options are visible</li></ul> <P> Other commonly used settings to
 * configure ComboBoxItem behavior are:<br> - {@link
 * com.smartgwt.client.widgets.form.fields.ComboBoxItem#getDefaultToFirstOption defaultToFirstOption} - this will select
 * the first option from the pickList as a default value for the item - and<br> - {@link
 * com.smartgwt.client.widgets.form.fields.ComboBoxItem#getCompleteOnTab completeOnTab} which causes the current selection
 * in the pickList (if there is one) to be chosen when the user tabs out of the field, allowing a user to type a few
 * characters and hit tab to auto-complete to the first matched option. <code>completeOnTab</code> is automatically set to
 * true if {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem#getAddUnknownValues addUnknownValues} is  false. <P>
 * ComboBoxItem does not provide built-in support for multiple selection.  For a Combobox that does provide such a
 * multiple-select feature use {@link com.smartgwt.client.widgets.form.fields.MultiComboBoxItem}.
 */
@BeanFactory.FrameworkClass
public class ComboBoxItem extends TextItem implements PickList, com.smartgwt.client.widgets.form.fields.events.HasDataArrivedHandlers {

    public static ComboBoxItem getOrCreateRef(JavaScriptObject jsObj) {
        if (jsObj == null) return null;

        final RefDataClass existingObj = RefDataClass.getRef(jsObj);

        if (existingObj instanceof ComboBoxItem) {
            existingObj.setJsObj(jsObj);
            return (ComboBoxItem)existingObj;
        } else

        {
            return new ComboBoxItem(jsObj);
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(ComboBoxItem.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "Canvas");
        }
        defaults.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
        var cleanDefaultsJS = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(defaults.@com.smartgwt.client.widgets.BaseWidget::getConfig()(), true);
        $wnd.isc.ComboBoxItem.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(ComboBoxItem.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "FormItem");
        }
        defaults.@com.smartgwt.client.widgets.form.fields.FormItem::setConfigOnly(Z)(true);
    	var cleanDefaultsJS = defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getEditorTypeConfig()();
        $wnd.isc.ComboBoxItem.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
    }-*/;

    public static native void changePickerIconDefaults(FormItemIcon defaults) /*-{
        $wnd.isc.ComboBoxItem.changeDefaults("pickerIconDefaults", defaults.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;

    public ComboBoxItem(){
        setAttribute("editorType", "ComboBoxItem");
    }

    public ComboBoxItem(JavaScriptObject jsObj){
        super(jsObj);
    }


    public ComboBoxItem(String name) {
        setName(name);
                setAttribute("editorType", "ComboBoxItem");
    }


    public ComboBoxItem(String name, String title) {
        setName(name);
		setTitle(title);
                setAttribute("editorType", "ComboBoxItem");
    }


    // ********************* Properties / Attributes ***********************

    /**
     * This property controls whether the user can enter a value that is not present in the set of options for this item. <P>
     * If set to false, the value the user enters in the text box is essentially used to filter the  set of options displayed
     * in the pickList. <P> In this mode, when focus is taken from the field, if the entered value does not match any entries
     * in the {@link com.smartgwt.client.types.ValueMap} or {@link
     * com.smartgwt.client.widgets.form.fields.ComboBoxItem#getOptionDataSource optionDataSource}, it will be discarded. Note 
     * that in this mode, {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem#getCompleteOnTab completeOnTab} behavior
     * is automatically enabled so if the user enters a valid partial value such that one or more options is displayed in  the
     * pickList, and hits the Tab key, the first matching option will be chosen automatically. In this mode the user may also
     * hit the <code>"Escape"</code> key to discard their edits. <P> Note also that when <code>addUnknownValues</code> is set
     * to false, the underlying value returned by {@link com.smartgwt.client.widgets.form.fields.FormItem#getValue getValue()}
     * will not be updated until a value is explicitly chosen. This means any change or changed handlers will not fire directly
     * in response to the user typing in the field - they will fire when the user actually selects a value, or takes focus from
     * the field. <P> If this property is set to true, the user is not limited to entering values present in the set of options
     * for the item. Instead the set of options essentially become a set of suggestions that may be used, or the user can enter
     * an entirely new value.
     *
     * @param addUnknownValues New addUnknownValues value. Default value is true
     * @return {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem ComboBoxItem} instance, for chaining setter calls
     */
    public ComboBoxItem setAddUnknownValues(Boolean addUnknownValues) {
        return (ComboBoxItem)setAttribute("addUnknownValues", addUnknownValues);
    }

    /**
     * This property controls whether the user can enter a value that is not present in the set of options for this item. <P>
     * If set to false, the value the user enters in the text box is essentially used to filter the  set of options displayed
     * in the pickList. <P> In this mode, when focus is taken from the field, if the entered value does not match any entries
     * in the {@link com.smartgwt.client.types.ValueMap} or {@link
     * com.smartgwt.client.widgets.form.fields.ComboBoxItem#getOptionDataSource optionDataSource}, it will be discarded. Note 
     * that in this mode, {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem#getCompleteOnTab completeOnTab} behavior
     * is automatically enabled so if the user enters a valid partial value such that one or more options is displayed in  the
     * pickList, and hits the Tab key, the first matching option will be chosen automatically. In this mode the user may also
     * hit the <code>"Escape"</code> key to discard their edits. <P> Note also that when <code>addUnknownValues</code> is set
     * to false, the underlying value returned by {@link com.smartgwt.client.widgets.form.fields.FormItem#getValue getValue()}
     * will not be updated until a value is explicitly chosen. This means any change or changed handlers will not fire directly
     * in response to the user typing in the field - they will fire when the user actually selects a value, or takes focus from
     * the field. <P> If this property is set to true, the user is not limited to entering values present in the set of options
     * for the item. Instead the set of options essentially become a set of suggestions that may be used, or the user can enter
     * an entirely new value.
     *
     * @return Current addUnknownValues value. Default value is true
     */
    public Boolean getAddUnknownValues()  {
        Boolean result = getAttributeAsBoolean("addUnknownValues", true);
        return result == null ? true : result;
    }
    

    /**
     * If {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem#getAddUnknownValues addUnknownValues} is
     * <code>false</code>, this property  determines whether the user can clear the comboBoxItem value, or whether they are
     * constrained to choosing one of the available options (in which case clearing the text box will simply revert to the last
     * picked value when the user leaves the field). <P> See also {@link
     * com.smartgwt.client.widgets.form.fields.ComboBoxItem#getSpecialValues specialValues} as a way of providing several
     * different special values in addition to an empty value, such as "Invalid".  Note that setting <code>specialValues</code>
     * disables the use of <code>allowEmptyValue</code> - see details of how to have an empty value while using
     * <code>specialValues</code> in  in {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem#getSpecialValues the
     * <code>specialValues</code> documentation}.
     *
     * @param allowEmptyValue New allowEmptyValue value. Default value is true
     * @return {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem ComboBoxItem} instance, for chaining setter calls
     */
    public ComboBoxItem setAllowEmptyValue(Boolean allowEmptyValue) {
        return (ComboBoxItem)setAttribute("allowEmptyValue", allowEmptyValue);
    }

    /**
     * If {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem#getAddUnknownValues addUnknownValues} is
     * <code>false</code>, this property  determines whether the user can clear the comboBoxItem value, or whether they are
     * constrained to choosing one of the available options (in which case clearing the text box will simply revert to the last
     * picked value when the user leaves the field). <P> See also {@link
     * com.smartgwt.client.widgets.form.fields.ComboBoxItem#getSpecialValues specialValues} as a way of providing several
     * different special values in addition to an empty value, such as "Invalid".  Note that setting <code>specialValues</code>
     * disables the use of <code>allowEmptyValue</code> - see details of how to have an empty value while using
     * <code>specialValues</code> in  in {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem#getSpecialValues the
     * <code>specialValues</code> documentation}.
     *
     * @return Current allowEmptyValue value. Default value is true
     */
    public Boolean getAllowEmptyValue()  {
        Boolean result = getAttributeAsBoolean("allowEmptyValue", true);
        return result == null ? true : result;
    }
    

    /**
     * The standard {@link com.smartgwt.client.widgets.form.fields.FormItem#getAllowExpressions FormItem.allowExpressions}
     * behavior is always disabled for  ComboBoxItem. <P> The interface is not compatible with the
     * <code>allowExpressions</code> feature. A ComboBoxItem normally starts fetching matches as you type, and that mixes  very
     * strangely with the idea of entering expressions like <code>"a..b"</code> - you will have the ComboBox seemingly
     * switching back and forth between treating the text as a normal search string vs as a special expression on a
     * per-keystroke basis. <P> We recommend a normal TextItem as the correct UI element to supply for users to enter filter
     * expressions.
     *
     * @param allowExpressions New allowExpressions value. Default value is null
     * @return {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem ComboBoxItem} instance, for chaining setter calls
     */
    public ComboBoxItem setAllowExpressions(Boolean allowExpressions) {
        return (ComboBoxItem)setAttribute("allowExpressions", allowExpressions);
    }

    /**
     * The standard {@link com.smartgwt.client.widgets.form.fields.FormItem#getAllowExpressions FormItem.allowExpressions}
     * behavior is always disabled for  ComboBoxItem. <P> The interface is not compatible with the
     * <code>allowExpressions</code> feature. A ComboBoxItem normally starts fetching matches as you type, and that mixes  very
     * strangely with the idea of entering expressions like <code>"a..b"</code> - you will have the ComboBox seemingly
     * switching back and forth between treating the text as a normal search string vs as a special expression on a
     * per-keystroke basis. <P> We recommend a normal TextItem as the correct UI element to supply for users to enter filter
     * expressions.
     *
     * @return Current allowExpressions value. Default value is null
     */
    public Boolean getAllowExpressions()  {
        return getAttributeAsBoolean("allowExpressions", true);
    }
    

    /**
     * If this combo box retrieves its options from a <code>dataSource</code>, should options be fetched from the server when
     * the item is first written out, or should this fetch be delayed until the user opens the pickList.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param autoFetchData New autoFetchData value. Default value is false
     * @return {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem ComboBoxItem} instance, for chaining setter calls
     */
    public ComboBoxItem setAutoFetchData(Boolean autoFetchData) {
        return (ComboBoxItem)setAttribute("autoFetchData", autoFetchData);
    }

    /**
     * If this combo box retrieves its options from a <code>dataSource</code>, should options be fetched from the server when
     * the item is first written out, or should this fetch be delayed until the user opens the pickList.
     *
     * @return Current autoFetchData value. Default value is false
     */
    public Boolean getAutoFetchData()  {
        Boolean result = getAttributeAsBoolean("autoFetchData", true);
        return result == null ? false : result;
    }
    

    /**
     * When this item is showing a  tree-based picker, which  nodes should be opened automatically.  Options are: <ul>
     * <li>"none" - no nodes are opened automatically</li> <li>"root" - opens the  top-level node - in databound              
     * tree-pickers, this node is always hidden</li> <li>"all" - when {@link
     * com.smartgwt.client.widgets.tree.ResultTree#getLoadDataOnDemand loading data on demand}, opens the             
     * top-level node and all of it's direct             descendants - otherwise, opens all loaded nodes </li> </ul>
     *
     * @param autoOpenTree New autoOpenTree value. Default value is "none"
     * @return {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem ComboBoxItem} instance, for chaining setter calls
     */
    public ComboBoxItem setAutoOpenTree(String autoOpenTree) {
        return (ComboBoxItem)setAttribute("autoOpenTree", autoOpenTree);
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
     * For databound pickLists (see  PickList.optionDataSource), by default Smart GWT will cache and re-use datasets shown by
     * different pickLists displayed by different SelectItems in an LRU (least recently used) caching pattern. <P> Setting this
     * flag to false avoids this caching for situations where it is too aggressive. <p> Note that this does not control re-use
     * of data <b>within a single pickList</b>.  To control when client-side filtering is used in ComboBoxItem, see {@link
     * com.smartgwt.client.widgets.form.fields.ComboBoxItem#getUseClientFiltering useClientFiltering} and {@link
     * com.smartgwt.client.widgets.form.fields.ComboBoxItem#getFilterLocally filterLocally}.
     *
     * @param cachePickListResults New cachePickListResults value. Default value is true
     * @return {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem ComboBoxItem} instance, for chaining setter calls
     */
    public ComboBoxItem setCachePickListResults(boolean cachePickListResults) {
        return (ComboBoxItem)setAttribute("cachePickListResults", cachePickListResults);
    }

    /**
     * For databound pickLists (see  PickList.optionDataSource), by default Smart GWT will cache and re-use datasets shown by
     * different pickLists displayed by different SelectItems in an LRU (least recently used) caching pattern. <P> Setting this
     * flag to false avoids this caching for situations where it is too aggressive. <p> Note that this does not control re-use
     * of data <b>within a single pickList</b>.  To control when client-side filtering is used in ComboBoxItem, see {@link
     * com.smartgwt.client.widgets.form.fields.ComboBoxItem#getUseClientFiltering useClientFiltering} and {@link
     * com.smartgwt.client.widgets.form.fields.ComboBoxItem#getFilterLocally filterLocally}.
     *
     * @return Current cachePickListResults value. Default value is true
     */
    public boolean getCachePickListResults()  {
        Boolean result = getAttributeAsBoolean("cachePickListResults", true);
        return result == null ? true : result;
    }
    

    /**
     * If true, when the pickList is showing, the user can select the current value by hitting the <code>Enter</code> key. <P>
     * If not explicitly set, completeOnEnter will default to false for items embedded in a {@link
     * com.smartgwt.client.widgets.form.SearchForm filtering interface}, true otherwise.
     *
     * @param completeOnEnter New completeOnEnter value. Default value is null
     * @return {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem ComboBoxItem} instance, for chaining setter calls
     */
    public ComboBoxItem setCompleteOnEnter(Boolean completeOnEnter) {
        return (ComboBoxItem)setAttribute("completeOnEnter", completeOnEnter);
    }

    /**
     * If true, when the pickList is showing, the user can select the current value by hitting the <code>Enter</code> key. <P>
     * If not explicitly set, completeOnEnter will default to false for items embedded in a {@link
     * com.smartgwt.client.widgets.form.SearchForm filtering interface}, true otherwise.
     *
     * @return Current completeOnEnter value. Default value is null
     */
    public Boolean getCompleteOnEnter()  {
        return getAttributeAsBoolean("completeOnEnter", true);
    }
    

    /**
     * If true, when the pickList is showing, the user can select the current value by hitting the <code>Tab</code> key. <P>
     * Note that <code>completeOnTab</code> is not compatible with {@link
     * com.smartgwt.client.widgets.form.fields.ComboBoxItem#getFormatOnBlur formatOnBlur}
     *
     * @param completeOnTab New completeOnTab value. Default value is null
     * @return {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem ComboBoxItem} instance, for chaining setter calls
     */
    public ComboBoxItem setCompleteOnTab(Boolean completeOnTab) {
        return (ComboBoxItem)setAttribute("completeOnTab", completeOnTab);
    }

    /**
     * If true, when the pickList is showing, the user can select the current value by hitting the <code>Tab</code> key. <P>
     * Note that <code>completeOnTab</code> is not compatible with {@link
     * com.smartgwt.client.widgets.form.fields.ComboBoxItem#getFormatOnBlur formatOnBlur}
     *
     * @return Current completeOnTab value. Default value is null
     */
    public Boolean getCompleteOnTab()  {
        return getAttributeAsBoolean("completeOnTab", true);
    }
    

    /**
     * Whether to show the picker as a flat list, or a collapsible tree. <p> The default value, "list", will use an instance of
     * the  pickListConstructor as the picker - "tree" will  show an instance of  pickTreeConstructor.
     *
     * @param dataSetType New dataSetType value. Default value is "list"
     * @return {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem ComboBoxItem} instance, for chaining setter calls
     */
    public ComboBoxItem setDataSetType(String dataSetType) {
        return (ComboBoxItem)setAttribute("dataSetType", dataSetType);
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
     * Select the first option as the default value for this ComboBoxItem. If options are derived from a dataSource, the first
     * value returned by the server will be used, otherwise the first value in the valueMap. If enabled, this setting overrides
     * {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem#getDefaultValue defaultValue} and {@link
     * com.smartgwt.client.widgets.form.fields.ComboBoxItem#defaultDynamicValue defaultDynamicValue()}.
     *
     * @param defaultToFirstOption New defaultToFirstOption value. Default value is false
     * @return {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem ComboBoxItem} instance, for chaining setter calls
     */
    public ComboBoxItem setDefaultToFirstOption(Boolean defaultToFirstOption) {
        return (ComboBoxItem)setAttribute("defaultToFirstOption", defaultToFirstOption);
    }

    /**
     * Select the first option as the default value for this ComboBoxItem. If options are derived from a dataSource, the first
     * value returned by the server will be used, otherwise the first value in the valueMap. If enabled, this setting overrides
     * {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem#getDefaultValue defaultValue} and {@link
     * com.smartgwt.client.widgets.form.fields.ComboBoxItem#defaultDynamicValue defaultDynamicValue()}.
     *
     * @return Current defaultToFirstOption value. Default value is false
     */
    public Boolean getDefaultToFirstOption()  {
        Boolean result = getAttributeAsBoolean("defaultToFirstOption", true);
        return result == null ? false : result;
    }
    

    /**
     * Static default value for this ComboBoxItem. To default to the first option use {@link
     * com.smartgwt.client.widgets.form.fields.ComboBoxItem#getDefaultToFirstOption defaultToFirstOption} instead.
     *
     * @return Current defaultValue value. Default value is null
     */
    public Object getDefaultValue()  {
        return getAttributeAsObject("defaultValue");
    }
    

    /**
     * If set, this item will display a value from another field to the user instead of showing the underlying data value for
     * the {@link com.smartgwt.client.widgets.form.fields.FormItem#getName field name}. <P> This property is used in two ways:
     * <P> The item will display the displayField value from the  {@link com.smartgwt.client.widgets.form.DynamicForm#getValues
     * record currently being edited} if  {@link com.smartgwt.client.widgets.form.fields.FormItem#getUseLocalDisplayFieldValue
     * FormItem.useLocalDisplayFieldValue} is true, (or if unset and the conditions outlined in the documentation for that
     * property are met). <P> If this field has an {@link com.smartgwt.client.widgets.form.fields.FormItem#getOptionDataSource
     * FormItem.optionDataSource}, this property is used by default to identify which value to use as a display value in
     * records from this related dataSource. In this usage the specified displayField must be  explicitly defined in the
     * optionDataSource to be used - see  {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem#getDisplayFieldName
     * getDisplayFieldName()} for more on this behavior.<br> If not using {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getUseLocalDisplayFieldValue local display values}, the display value
     * for this item will be derived by performing a fetch against the  {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getOptionDataSource option dataSource}  to find a record where the
     * {@link com.smartgwt.client.widgets.form.fields.FormItem#getValueFieldName value field} matches  this item's value, and
     * use the <code>displayField</code> value from that record.<br> In addition to this, PickList-based form items that
     * provide a list of possible options such as the {@link com.smartgwt.client.widgets.form.fields.SelectItem} or {@link
     * com.smartgwt.client.widgets.form.fields.ComboBoxItem} will show the  <code>displayField</code> values to the user by
     * default, allowing them to choose a new data value (see {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getValueField FormItem.valueField}) from a list of user-friendly
     * display values. <P> This essentially allows the specified <code>optionDataSource</code> to be used as a server based
     * {@link valueMap}. <P> If {@link com.smartgwt.client.widgets.form.fields.FormItem#getUseLocalDisplayFieldValue local
     * display values} are being used and {@link com.smartgwt.client.widgets.form.fields.FormItem#getStoreDisplayValues
     * FormItem.storeDisplayValues} is true, selecting a new value will update both the value for this field and the associated
     * display-field value on the record being edited. <P> Note: Developers may specify the {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getForeignDisplayField FormItem.foreignDisplayField} property  in
     * addition to <code>displayField</code>. This is useful for cases where the display field name in the local dataSource
     * differs from the display field name in the optionDataSource. See the documentation for {@link
     * com.smartgwt.client.data.DataSourceField#getForeignDisplayField DataSourceField.foreignDisplayField} for more on
     * this.<br> If a foreignDisplayField is specified, as with just displayField, if  {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getUseLocalDisplayFieldValue local display values} are being used and
     * {@link com.smartgwt.client.widgets.form.fields.FormItem#getStoreDisplayValues FormItem.storeDisplayValues} is true, when
     * the user  chooses a value the associated display-field value  on the record being edited will be updated. In this case
     * it would be set to the  foreignDisplayField value from the related record. This means foreignDisplayField  is always
     * expected to be set to the equivalent field in the related dataSources.<br> Developers looking to display some
     * <i>other</i> arbitrary field(s) from the related dataSource during editing should consider using custom 
     * PickList.pickListFields instead of setting a foreignDisplayField.  <P> Note that if <code>optionDataSource</code> is set
     * and no valid display field is specified, {@link com.smartgwt.client.widgets.form.fields.FormItem#getDisplayFieldName
     * FormItem.getDisplayFieldName()} will return the dataSource title  field by default. <P> If a displayField is specified
     * for a freeform text based item (such as a  {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem}), any
     * user-entered value will be treated as a display value. In this scenario, items will derive the data value for the item
     * from the first record where the displayField value matches the user-entered value. To avoid ambiguity, developers may
     * wish to avoid this usage if display values are not unique.
     *
     * @param displayField New displayField value. Default value is null
     * @return {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem ComboBoxItem} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.form.fields.FormItem#getDisplayFieldName
     * @see com.smartgwt.client.widgets.form.fields.FormItem#invalidateDisplayValueCache
     * @see com.smartgwt.client.docs.Databinding Databinding overview and related methods
     */
    public ComboBoxItem setDisplayField(String displayField) {
        return (ComboBoxItem)setAttribute("displayField", displayField);
    }

    /**
     * If set, this item will display a value from another field to the user instead of showing the underlying data value for
     * the {@link com.smartgwt.client.widgets.form.fields.FormItem#getName field name}. <P> This property is used in two ways:
     * <P> The item will display the displayField value from the  {@link com.smartgwt.client.widgets.form.DynamicForm#getValues
     * record currently being edited} if  {@link com.smartgwt.client.widgets.form.fields.FormItem#getUseLocalDisplayFieldValue
     * FormItem.useLocalDisplayFieldValue} is true, (or if unset and the conditions outlined in the documentation for that
     * property are met). <P> If this field has an {@link com.smartgwt.client.widgets.form.fields.FormItem#getOptionDataSource
     * FormItem.optionDataSource}, this property is used by default to identify which value to use as a display value in
     * records from this related dataSource. In this usage the specified displayField must be  explicitly defined in the
     * optionDataSource to be used - see  {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem#getDisplayFieldName
     * getDisplayFieldName()} for more on this behavior.<br> If not using {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getUseLocalDisplayFieldValue local display values}, the display value
     * for this item will be derived by performing a fetch against the  {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getOptionDataSource option dataSource}  to find a record where the
     * {@link com.smartgwt.client.widgets.form.fields.FormItem#getValueFieldName value field} matches  this item's value, and
     * use the <code>displayField</code> value from that record.<br> In addition to this, PickList-based form items that
     * provide a list of possible options such as the {@link com.smartgwt.client.widgets.form.fields.SelectItem} or {@link
     * com.smartgwt.client.widgets.form.fields.ComboBoxItem} will show the  <code>displayField</code> values to the user by
     * default, allowing them to choose a new data value (see {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getValueField FormItem.valueField}) from a list of user-friendly
     * display values. <P> This essentially allows the specified <code>optionDataSource</code> to be used as a server based
     * {@link valueMap}. <P> If {@link com.smartgwt.client.widgets.form.fields.FormItem#getUseLocalDisplayFieldValue local
     * display values} are being used and {@link com.smartgwt.client.widgets.form.fields.FormItem#getStoreDisplayValues
     * FormItem.storeDisplayValues} is true, selecting a new value will update both the value for this field and the associated
     * display-field value on the record being edited. <P> Note: Developers may specify the {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getForeignDisplayField FormItem.foreignDisplayField} property  in
     * addition to <code>displayField</code>. This is useful for cases where the display field name in the local dataSource
     * differs from the display field name in the optionDataSource. See the documentation for {@link
     * com.smartgwt.client.data.DataSourceField#getForeignDisplayField DataSourceField.foreignDisplayField} for more on
     * this.<br> If a foreignDisplayField is specified, as with just displayField, if  {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getUseLocalDisplayFieldValue local display values} are being used and
     * {@link com.smartgwt.client.widgets.form.fields.FormItem#getStoreDisplayValues FormItem.storeDisplayValues} is true, when
     * the user  chooses a value the associated display-field value  on the record being edited will be updated. In this case
     * it would be set to the  foreignDisplayField value from the related record. This means foreignDisplayField  is always
     * expected to be set to the equivalent field in the related dataSources.<br> Developers looking to display some
     * <i>other</i> arbitrary field(s) from the related dataSource during editing should consider using custom 
     * PickList.pickListFields instead of setting a foreignDisplayField.  <P> Note that if <code>optionDataSource</code> is set
     * and no valid display field is specified, {@link com.smartgwt.client.widgets.form.fields.FormItem#getDisplayFieldName
     * FormItem.getDisplayFieldName()} will return the dataSource title  field by default. <P> If a displayField is specified
     * for a freeform text based item (such as a  {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem}), any
     * user-entered value will be treated as a display value. In this scenario, items will derive the data value for the item
     * from the first record where the displayField value matches the user-entered value. To avoid ambiguity, developers may
     * wish to avoid this usage if display values are not unique.
     *
     * @return Returns the <code>displayField</code> for this item. <P> Behavior varies based on the configuration of this item, as
     * follows: <ul><li>If this item has an {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem#getOptionDataSource
     * optionDataSource} and an explicit   {@link com.smartgwt.client.widgets.form.fields.FormItem#getForeignDisplayField
     * FormItem.foreignDisplayField} is specified, this will be returned.</li> <li>Otherwise if an explicit {@link
     * com.smartgwt.client.widgets.form.fields.ComboBoxItem#getDisplayField displayField} is specified it will be returned   by
     * default. If the <code>displayField</code> was specified on the underlying   dataSource field, and no matching field is
     * present in the {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem#getOptionDataSource optionDataSource} for 
     * the item, we avoid returning the specified displayField value and instead return the  title field of the option
     * DataSource. We do this to  avoid confusion for the case where the displayField is intended as a display-field  value for
     * showing another field value within the same record in the underlying  dataSource only.</li> <li>If no explicit
     * foreignDisplayField or displayField   specification was found, and the {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getValueField FormItem.valueField} for this item is hidden in the  
     * {@link com.smartgwt.client.widgets.form.fields.FormItem#getOptionDataSource FormItem.optionDataSource}, this method will
     * return the title field for   the <code>optionDataSource</code>.</li></ul>. Default value is null
     * @see com.smartgwt.client.widgets.form.fields.FormItem#getDisplayFieldName
     * @see com.smartgwt.client.widgets.form.fields.FormItem#invalidateDisplayValueCache
     * @see com.smartgwt.client.docs.Databinding Databinding overview and related methods
     */
    public String getDisplayField()  {
        return getAttributeAsString("displayField");
    }
    

    /**
     * Default class used to construct the {@link com.smartgwt.client.tools.EditProxy} for this component when the component is
     * {@link com.smartgwt.client.widgets.Canvas#setEditMode first placed into edit mode}.
     *
     * @param editProxyConstructor New editProxyConstructor value. Default value is "SelectItemEditProxy"
     * @return {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem ComboBoxItem} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.SCClassName SCClassName 
     */
    public ComboBoxItem setEditProxyConstructor(String editProxyConstructor) {
        return (ComboBoxItem)setAttribute("editProxyConstructor", editProxyConstructor);
    }

    /**
     * Default class used to construct the {@link com.smartgwt.client.tools.EditProxy} for this component when the component is
     * {@link com.smartgwt.client.widgets.Canvas#setEditMode first placed into edit mode}.
     *
     * @return Current editProxyConstructor value. Default value is "SelectItemEditProxy"
     * @see com.smartgwt.client.docs.SCClassName SCClassName 
     */
    public String getEditProxyConstructor()  {
        return getAttributeAsString("editProxyConstructor");
    }
    

    /**
     * Empty message to display in the comboboxItem if  PickList.hideEmptyPickList is <code>false</code>.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param emptyPickListMessage New emptyPickListMessage value. Default value is "No items to show"
     * @return {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem ComboBoxItem} instance, for chaining setter calls
     */
    public ComboBoxItem setEmptyPickListMessage(String emptyPickListMessage) {
        return (ComboBoxItem)setAttribute("emptyPickListMessage", emptyPickListMessage);
    }

    /**
     * Empty message to display in the comboboxItem if  PickList.hideEmptyPickList is <code>false</code>.
     *
     * @return Current emptyPickListMessage value. Default value is "No items to show"
     */
    public String getEmptyPickListMessage()  {
        return getAttributeAsString("emptyPickListMessage");
    }
    

    /**
     * If this item has a specified <code>optionDataSource</code> and this property is <code>true</code>, the list of fields
     * used by this pickList will be passed to the datasource as {@link com.smartgwt.client.data.DSRequest#getOutputs
     * DSRequest.outputs}. If the datasource supports this feature the returned fields will be limited to this list. A custom
     * datasource will need to add code to implement field limiting. <P> This list of used fields consists of the values of
     * {@link com.smartgwt.client.widgets.form.fields.FormItem#getValueField valueField}, {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getDisplayField displayField} and {@link
     * com.smartgwt.client.widgets.form.fields.ComboBoxItem#getPickListFields pickListFields}. <P> NOTE: When enabled, {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getSelectedRecord getSelectedRecord} will only include the fetched
     * fields.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param fetchDisplayedFieldsOnly New fetchDisplayedFieldsOnly value. Default value is null
     * @return {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem ComboBoxItem} instance, for chaining setter calls
     */
    public ComboBoxItem setFetchDisplayedFieldsOnly(Boolean fetchDisplayedFieldsOnly) {
        return (ComboBoxItem)setAttribute("fetchDisplayedFieldsOnly", fetchDisplayedFieldsOnly);
    }

    /**
     * If this item has a specified <code>optionDataSource</code> and this property is <code>true</code>, the list of fields
     * used by this pickList will be passed to the datasource as {@link com.smartgwt.client.data.DSRequest#getOutputs
     * DSRequest.outputs}. If the datasource supports this feature the returned fields will be limited to this list. A custom
     * datasource will need to add code to implement field limiting. <P> This list of used fields consists of the values of
     * {@link com.smartgwt.client.widgets.form.fields.FormItem#getValueField valueField}, {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getDisplayField displayField} and {@link
     * com.smartgwt.client.widgets.form.fields.ComboBoxItem#getPickListFields pickListFields}. <P> NOTE: When enabled, {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getSelectedRecord getSelectedRecord} will only include the fetched
     * fields.
     *
     * @return Current fetchDisplayedFieldsOnly value. Default value is null
     */
    public Boolean getFetchDisplayedFieldsOnly()  {
        return getAttributeAsBoolean("fetchDisplayedFieldsOnly", true);
    }
    

    /**
     * As the user types into this item's textBox, a comboBoxItem will show the pick-list of options, and filter the set of
     * results displayed by the current value in the text box. For a databound comboBoxItem, by default the entered value is
     * filtered against the {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem#getDisplayField displayField} if one is
     * specified, otherwise the {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem#getValueField valueField}. <P> This
     * attribute allows the developer to explicitly change which fields to filter against, causing the user-entered text to be
     * matched against any of the specified set of fields from  the {@link
     * com.smartgwt.client.widgets.form.fields.ComboBoxItem#getOptionDataSource optionDataSource}. <P> This essentially causes
     * {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem#getPickListFilterCriteria getPickListFilterCriteria()} to
     * return an {@link com.smartgwt.client.data.AdvancedCriteria} object representing "field1 starts with value or field2
     * starts with value or ...".  The {@link com.smartgwt.client.types.OperatorId operator} used is controlled by {@link
     * com.smartgwt.client.types.TextMatchStyle} as usual, that is, "startsWith" implies the operator "iStartsWith, "substring"
     * implies "iContains" and "exact" implies "iEquals". <P> The most common use case for this setting would be when a
     * comboBoxItem is showing multiple {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem#getPickListFields
     * pickListFields} - if the same set of fields is specified as {@link
     * com.smartgwt.client.widgets.form.fields.ComboBoxItem#getFilterFields filterFields}, the user can use the text-box to
     * filter against whichever fields are visible in the pickList. <P>  For finer grained control over comboBoxItem filtering,
     * the  comboBoxItem.setPickListFilterCriteriaFunction() may be specified.
     *
     * @param filterFields New filterFields value. Default value is null
     * @return {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem ComboBoxItem} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.PickList PickList overview and related methods
     */
    public ComboBoxItem setFilterFields(String... filterFields) {
        return (ComboBoxItem)setAttribute("filterFields", filterFields);
    }

    /**
     * As the user types into this item's textBox, a comboBoxItem will show the pick-list of options, and filter the set of
     * results displayed by the current value in the text box. For a databound comboBoxItem, by default the entered value is
     * filtered against the {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem#getDisplayField displayField} if one is
     * specified, otherwise the {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem#getValueField valueField}. <P> This
     * attribute allows the developer to explicitly change which fields to filter against, causing the user-entered text to be
     * matched against any of the specified set of fields from  the {@link
     * com.smartgwt.client.widgets.form.fields.ComboBoxItem#getOptionDataSource optionDataSource}. <P> This essentially causes
     * {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem#getPickListFilterCriteria getPickListFilterCriteria()} to
     * return an {@link com.smartgwt.client.data.AdvancedCriteria} object representing "field1 starts with value or field2
     * starts with value or ...".  The {@link com.smartgwt.client.types.OperatorId operator} used is controlled by {@link
     * com.smartgwt.client.types.TextMatchStyle} as usual, that is, "startsWith" implies the operator "iStartsWith, "substring"
     * implies "iContains" and "exact" implies "iEquals". <P> The most common use case for this setting would be when a
     * comboBoxItem is showing multiple {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem#getPickListFields
     * pickListFields} - if the same set of fields is specified as {@link
     * com.smartgwt.client.widgets.form.fields.ComboBoxItem#getFilterFields filterFields}, the user can use the text-box to
     * filter against whichever fields are visible in the pickList. <P>  For finer grained control over comboBoxItem filtering,
     * the  comboBoxItem.setPickListFilterCriteriaFunction() may be specified.
     *
     * @return Current filterFields value. Default value is null
     * @see com.smartgwt.client.docs.PickList PickList overview and related methods
     */
    public String[] getFilterFields()  {
        return com.smartgwt.client.util.ConvertTo.arrayOfString(getAttributeAsJavaScriptObject("filterFields"));
    }
    

    /**
     * If <code>filterLocally</code> is set for this item, and this item is showing options  from a dataSource, fetch the
     * entire set of options from the server, and use these values to map the item value to the appropriate display value. Also
     * use <code>"local"</code> type filtering on drop down list of options. <P> This means data will only be fetched once from
     * the server, and then filtered on the client. <P> Note - when this property is set to <code>false</code>, filtering will
     * still be  performed on the client if a complete set of data for some criteria has been cached by a fetch, and a
     * subsequent fetch has more restrictive criteria. To explicitly disable client-side filtering set the {@link
     * com.smartgwt.client.widgets.form.fields.ComboBoxItem#getUseClientFiltering useClientFiltering} property to false.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param filterLocally New filterLocally value. Default value is false
     * @return {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem ComboBoxItem} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.form.fields.FormItem#setFilterLocally
     */
    public ComboBoxItem setFilterLocally(Boolean filterLocally) {
        return (ComboBoxItem)setAttribute("filterLocally", filterLocally);
    }

    /**
     * If <code>filterLocally</code> is set for this item, and this item is showing options  from a dataSource, fetch the
     * entire set of options from the server, and use these values to map the item value to the appropriate display value. Also
     * use <code>"local"</code> type filtering on drop down list of options. <P> This means data will only be fetched once from
     * the server, and then filtered on the client. <P> Note - when this property is set to <code>false</code>, filtering will
     * still be  performed on the client if a complete set of data for some criteria has been cached by a fetch, and a
     * subsequent fetch has more restrictive criteria. To explicitly disable client-side filtering set the {@link
     * com.smartgwt.client.widgets.form.fields.ComboBoxItem#getUseClientFiltering useClientFiltering} property to false.
     *
     * @return Current filterLocally value. Default value is false
     * @see com.smartgwt.client.widgets.form.fields.FormItem#getFilterLocally
     */
    public Boolean getFilterLocally()  {
        Boolean result = getAttributeAsBoolean("filterLocally", true);
        return result == null ? false : result;
    }
    

    /**
     * Read-only property set by the ComboBoxItem to indicate whether we should use the  current typed-in value as part of the
     * filter criteria returned by  {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem#getPickListFilterCriteria
     * getPickListFilterCriteria()}.  You can check this flag in order to mimic the ComboBoxItem's default behavior if you
     * provide a custom implementation of <code>getPickListFilterCriteria()</code>.
     *
     * @return Current filterWithValue value. Default value is varies
     * @see com.smartgwt.client.widgets.form.fields.ComboBoxItem#getPickListFilterCriteria
     * @see com.smartgwt.client.widgets.form.fields.ComboBoxItem#getFilterFields
     */
    public boolean getFilterWithValue()  {
        Boolean result = getAttributeAsBoolean("filterWithValue", true);
        return result == null ? false : result;
    }
    

    /**
     * With <code>formatOnBlur</code> enabled, this comboBoxItem will format its value according to the rules described in
     * {@link com.smartgwt.client.widgets.form.fields.FormItem#mapValueToDisplay FormItem.mapValueToDisplay()} as long as the 
     * item does not have focus.  Once the user puts focus into the item the formatter will be removed. This provides a simple
     * way for developers to show a nicely formatted display value in a freeform text field, without the need for an explicit
     * {@link com.smartgwt.client.widgets.form.fields.FormItem#formatEditorValue FormItem.formatEditorValue()}  and {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#parseEditorValue FormItem.parseEditorValue()} pair. <P> Note that this
     * attribute is not compatible with {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem#getCompleteOnTab
     * completeOnTab}
     *
     * @param formatOnBlur New formatOnBlur value. Default value is false
     * @return {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem ComboBoxItem} instance, for chaining setter calls
     */
    public ComboBoxItem setFormatOnBlur(Boolean formatOnBlur) {
        return (ComboBoxItem)setAttribute("formatOnBlur", formatOnBlur);
    }

    /**
     * With <code>formatOnBlur</code> enabled, this comboBoxItem will format its value according to the rules described in
     * {@link com.smartgwt.client.widgets.form.fields.FormItem#mapValueToDisplay FormItem.mapValueToDisplay()} as long as the 
     * item does not have focus.  Once the user puts focus into the item the formatter will be removed. This provides a simple
     * way for developers to show a nicely formatted display value in a freeform text field, without the need for an explicit
     * {@link com.smartgwt.client.widgets.form.fields.FormItem#formatEditorValue FormItem.formatEditorValue()}  and {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#parseEditorValue FormItem.parseEditorValue()} pair. <P> Note that this
     * attribute is not compatible with {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem#getCompleteOnTab
     * completeOnTab}
     *
     * @return Current formatOnBlur value. Default value is false
     */
    public Boolean getFormatOnBlur()  {
        Boolean result = getAttributeAsBoolean("formatOnBlur", true);
        return result == null ? false : result;
    }
    

    /**
     * When a comboBoxItem is used to generate search criteria in a SearchForm this property governs whether, if the user
     * explicitly chose an option from the pickList, we explicitly generate criteria that will search for an exact match
     * against the chosen value. <P> In order to achieve this, when this property is set to true, this item will generate
     * {@link com.smartgwt.client.data.AdvancedCriteria} in  the default <code>FormItemCriterionGetter</code>'s
     * <code>getCriterion()</code> method. <P> See {@link
     * com.smartgwt.client.widgets.form.fields.ComboBoxItem#shouldGenerateExactMatchCriteria
     * shouldGenerateExactMatchCriteria()} for behavior when this flag is unset.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param generateExactMatchCriteria New generateExactMatchCriteria value. Default value is null
     * @return {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem ComboBoxItem} instance, for chaining setter calls
     */
    public ComboBoxItem setGenerateExactMatchCriteria(Boolean generateExactMatchCriteria) {
        return (ComboBoxItem)setAttribute("generateExactMatchCriteria", generateExactMatchCriteria);
    }

    /**
     * When a comboBoxItem is used to generate search criteria in a SearchForm this property governs whether, if the user
     * explicitly chose an option from the pickList, we explicitly generate criteria that will search for an exact match
     * against the chosen value. <P> In order to achieve this, when this property is set to true, this item will generate
     * {@link com.smartgwt.client.data.AdvancedCriteria} in  the default <code>FormItemCriterionGetter</code>'s
     * <code>getCriterion()</code> method. <P> See {@link
     * com.smartgwt.client.widgets.form.fields.ComboBoxItem#shouldGenerateExactMatchCriteria
     * shouldGenerateExactMatchCriteria()} for behavior when this flag is unset.
     *
     * @return Current generateExactMatchCriteria value. Default value is null
     */
    public Boolean getGenerateExactMatchCriteria()  {
        return getAttributeAsBoolean("generateExactMatchCriteria", true);
    }
    

    /**
     * For PickList items with {@link com.smartgwt.client.types.PickListItemIconPlacement} set such that the pickList does not
     * render near-origin, should specified {@link com.smartgwt.client.widgets.form.fields.FormItem#getIcons icons} be rendered
     * inline within the formItem itself, or within the {@link
     * com.smartgwt.client.widgets.form.fields.ComboBoxItem#getPickerNavigationBar pickerNavigationBar}. <P> May be overridden
     * at the icon level via {@link com.smartgwt.client.widgets.form.fields.FormItemIcon#getIconPlacement
     * FormItemIcon.iconPlacement}. <P> For mobile browsing with limited available screen space, icons rendered in the
     * navigation bar may be easier for the user to interact with.
     *
     * @param iconPlacement New iconPlacement value. Default value is "both"
     * @return {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem ComboBoxItem} instance, for chaining setter calls
     */
    public ComboBoxItem setIconPlacement(PickListItemIconPlacement iconPlacement) {
        return (ComboBoxItem)setAttribute("iconPlacement", iconPlacement == null ? null : iconPlacement.getValue());
    }

    /**
     * For PickList items with {@link com.smartgwt.client.types.PickListItemIconPlacement} set such that the pickList does not
     * render near-origin, should specified {@link com.smartgwt.client.widgets.form.fields.FormItem#getIcons icons} be rendered
     * inline within the formItem itself, or within the {@link
     * com.smartgwt.client.widgets.form.fields.ComboBoxItem#getPickerNavigationBar pickerNavigationBar}. <P> May be overridden
     * at the icon level via {@link com.smartgwt.client.widgets.form.fields.FormItemIcon#getIconPlacement
     * FormItemIcon.iconPlacement}. <P> For mobile browsing with limited available screen space, icons rendered in the
     * navigation bar may be easier for the user to interact with.
     *
     * @return Current iconPlacement value. Default value is "both"
     */
    public PickListItemIconPlacement getIconPlacement()  {
        return EnumUtil.getEnum(PickListItemIconPlacement.values(), getAttribute("iconPlacement"));
    }
    

    /**
     * An array of {@link com.smartgwt.client.data.SortSpecifier} objects used to set up the initial sort configuration  for
     * this pickList. If specified, this will be used instead of any   PickList.sortField specified.
     *
     * @param initialSort New initialSort value. Default value is null
     * @return {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem ComboBoxItem} instance, for chaining setter calls
     */
    public ComboBoxItem setInitialSort(SortSpecifier... initialSort) {
        return (ComboBoxItem)setAttribute("initialSort", initialSort);
    }

    /**
     * An array of {@link com.smartgwt.client.data.SortSpecifier} objects used to set up the initial sort configuration  for
     * this pickList. If specified, this will be used instead of any   PickList.sortField specified.
     *
     * @return Current initialSort value. Default value is null
     */
    public SortSpecifier[] getInitialSort()  {
        return com.smartgwt.client.util.ConvertTo.arrayOfSortSpecifier(getAttributeAsJavaScriptObject("initialSort"));
    }
    

    /**
     * Not applicable to a ComboBoxItem.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param mask New mask value. Default value is null
     * @return {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem ComboBoxItem} instance, for chaining setter calls
     */
    public ComboBoxItem setMask(String mask) {
        return (ComboBoxItem)setAttribute("mask", mask);
    }

    /**
     * Not applicable to a ComboBoxItem.
     *
     * @return Current mask value. Default value is null
     */
    public String getMask()  {
        return getAttributeAsString("mask");
    }
    

    /**
     * Not applicable to a ComboBoxItem.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param maskOverwriteMode New maskOverwriteMode value. Default value is null
     * @return {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem ComboBoxItem} instance, for chaining setter calls
     */
    public ComboBoxItem setMaskOverwriteMode(Boolean maskOverwriteMode) {
        return (ComboBoxItem)setAttribute("maskOverwriteMode", maskOverwriteMode);
    }

    /**
     * Not applicable to a ComboBoxItem.
     *
     * @return Current maskOverwriteMode value. Default value is null
     */
    public Boolean getMaskOverwriteMode()  {
        return getAttributeAsBoolean("maskOverwriteMode", true);
    }
    

    /**
     * Not applicable to a ComboBoxItem.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param maskPadChar New maskPadChar value. Default value is " "
     * @return {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem ComboBoxItem} instance, for chaining setter calls
     */
    public ComboBoxItem setMaskPadChar(String maskPadChar) {
        return (ComboBoxItem)setAttribute("maskPadChar", maskPadChar);
    }

    /**
     * Not applicable to a ComboBoxItem.
     *
     * @return Current maskPadChar value. Default value is " "
     */
    public String getMaskPadChar()  {
        return getAttributeAsString("maskPadChar");
    }
    

    /**
     * Not applicable to a ComboBoxItem.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param maskPromptChar New maskPromptChar value. Default value is "_"
     * @return {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem ComboBoxItem} instance, for chaining setter calls
     */
    public ComboBoxItem setMaskPromptChar(String maskPromptChar) {
        return (ComboBoxItem)setAttribute("maskPromptChar", maskPromptChar);
    }

    /**
     * Not applicable to a ComboBoxItem.
     *
     * @return Current maskPromptChar value. Default value is "_"
     */
    public String getMaskPromptChar()  {
        return getAttributeAsString("maskPromptChar");
    }
    

    /**
     * Not applicable to a ComboBoxItem.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param maskSaveLiterals New maskSaveLiterals value. Default value is null
     * @return {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem ComboBoxItem} instance, for chaining setter calls
     */
    public ComboBoxItem setMaskSaveLiterals(Boolean maskSaveLiterals) {
        return (ComboBoxItem)setAttribute("maskSaveLiterals", maskSaveLiterals);
    }

    /**
     * Not applicable to a ComboBoxItem.
     *
     * @return Current maskSaveLiterals value. Default value is null
     */
    public Boolean getMaskSaveLiterals()  {
        return getAttributeAsBoolean("maskSaveLiterals", true);
    }
    

    /**
     * Minimum length in characters before a search is performed. If too few characters are entered the pick list shows {@link
     * com.smartgwt.client.widgets.form.fields.ComboBoxItem#getSearchStringTooShortMessage searchStringTooShortMessage}.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param minimumSearchLength New minimumSearchLength value. Default value is null
     * @return {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem ComboBoxItem} instance, for chaining setter calls
     */
    public ComboBoxItem setMinimumSearchLength(Integer minimumSearchLength) {
        return (ComboBoxItem)setAttribute("minimumSearchLength", minimumSearchLength);
    }

    /**
     * Minimum length in characters before a search is performed. If too few characters are entered the pick list shows {@link
     * com.smartgwt.client.widgets.form.fields.ComboBoxItem#getSearchStringTooShortMessage searchStringTooShortMessage}.
     *
     * @return Current minimumSearchLength value. Default value is null
     */
    public Integer getMinimumSearchLength()  {
        return getAttributeAsInt("minimumSearchLength");
    }
    
    
    

    /**
     * If this item has a specified <code>optionDataSource</code>, this attribute may be set to specify an explicit {@link
     * com.smartgwt.client.data.DSRequest#getOperationId DSRequest.operationId} when performing a fetch against the option
     * dataSource to pick up display value mapping.
     *
     * @param optionOperationId New optionOperationId value. Default value is null
     * @return {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem ComboBoxItem} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.Databinding Databinding overview and related methods
     */
    public ComboBoxItem setOptionOperationId(String optionOperationId) {
        return (ComboBoxItem)setAttribute("optionOperationId", optionOperationId);
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
     * Optional "pending" style for this item's text box. <P> If {@link
     * com.smartgwt.client.widgets.form.fields.ComboBoxItem#getAddUnknownValues addUnknownValues} is false, when the user
     * modifies the value displayed in the combobox item text box, the underlying data value (as returned from item.getValue())
     * is not immediately updated - instead the value is used to filter the set of results displayed in the comboBoxItem
     * pickList. <P> While the comboBoxItem is in this pending state (where the result of getEnteredValue() will not
     * necessarily match the display value for whatever is returned by getValue()), the  pendingTextBoxStyle may be applied to
     * the text box for the item. <P> When the element value is updated to display the actual value for the item (typically due
     * to the user selecting a value from the pickList), the standard  {@link
     * com.smartgwt.client.widgets.form.fields.TextItem#getTextBoxStyle TextItem.textBoxStyle} will be reapplied. <P> May be
     * left unset in which case the standard text box style is always applied. Has no effect if {@link
     * com.smartgwt.client.widgets.form.fields.ComboBoxItem#getAddUnknownValues addUnknownValues} is true.
     *
     * @param pendingTextBoxStyle New pendingTextBoxStyle value. Default value is null
     * @return {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem ComboBoxItem} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public ComboBoxItem setPendingTextBoxStyle(String pendingTextBoxStyle) {
        return (ComboBoxItem)setAttribute("pendingTextBoxStyle", pendingTextBoxStyle);
    }

    /**
     * Optional "pending" style for this item's text box. <P> If {@link
     * com.smartgwt.client.widgets.form.fields.ComboBoxItem#getAddUnknownValues addUnknownValues} is false, when the user
     * modifies the value displayed in the combobox item text box, the underlying data value (as returned from item.getValue())
     * is not immediately updated - instead the value is used to filter the set of results displayed in the comboBoxItem
     * pickList. <P> While the comboBoxItem is in this pending state (where the result of getEnteredValue() will not
     * necessarily match the display value for whatever is returned by getValue()), the  pendingTextBoxStyle may be applied to
     * the text box for the item. <P> When the element value is updated to display the actual value for the item (typically due
     * to the user selecting a value from the pickList), the standard  {@link
     * com.smartgwt.client.widgets.form.fields.TextItem#getTextBoxStyle TextItem.textBoxStyle} will be reapplied. <P> May be
     * left unset in which case the standard text box style is always applied. Has no effect if {@link
     * com.smartgwt.client.widgets.form.fields.ComboBoxItem#getAddUnknownValues addUnknownValues} is true.
     *
     * @return Current pendingTextBoxStyle value. Default value is null
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public String getPendingTextBoxStyle()  {
        return getAttributeAsString("pendingTextBoxStyle");
    }
    

    /**
     * {@link com.smartgwt.client.widgets.NavigationButton} to clear the picker value, created when {@link
     * com.smartgwt.client.widgets.form.fields.ComboBoxItem#getPickListPlacement pickListPlacement} indicates that the search
     * interface takes over the entire panel or screen. <P> This button will only be shown if {@link
     * com.smartgwt.client.widgets.form.fields.ComboBoxItem#getAddUnknownValues addUnknownValues} or {@link
     * com.smartgwt.client.widgets.form.fields.ComboBoxItem#getAllowEmptyValue allowEmptyValue} is true. <p> The following
     * {@link com.smartgwt.client.docs.AutoChildUsage passthroughs} apply: <ul> <li>{@link
     * com.smartgwt.client.widgets.form.fields.ComboBoxItem#getPickerClearButtonTitle pickerClearButtonTitle} for {@link
     * com.smartgwt.client.widgets.Button#getTitle Button.title}</li> </ul>
     * <p>
     * This component is an AutoChild named "pickerClearButton".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current pickerClearButton value. Default value is null
     */
    public NavigationButton getPickerClearButton()  {
        return (NavigationButton)NavigationButton.getByJSObject(getAttributeAsJavaScriptObject("pickerClearButton"));
    }
    

    /**
     * The title for the {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem#getPickerClearButton pickerClearButton}.
     *
     * @param pickerClearButtonTitle New pickerClearButtonTitle value. Default value is "Clear"
     * @return {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem ComboBoxItem} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public ComboBoxItem setPickerClearButtonTitle(String pickerClearButtonTitle) {
        return (ComboBoxItem)setAttribute("pickerClearButtonTitle", pickerClearButtonTitle);
    }

    /**
     * The title for the {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem#getPickerClearButton pickerClearButton}.
     *
     * @return Current pickerClearButtonTitle value. Default value is "Clear"
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public String getPickerClearButtonTitle()  {
        return getAttributeAsString("pickerClearButtonTitle");
    }
    

    /**
     * {@link com.smartgwt.client.widgets.NavigationButton} to dismiss the picker interface, created when  {@link
     * com.smartgwt.client.widgets.form.fields.ComboBoxItem#getPickListPlacement pickListPlacement} indicates that the search
     * interface takes over the entire panel or screen. <p> The following {@link com.smartgwt.client.docs.AutoChildUsage
     * passthroughs} apply: <ul> <li>{@link com.smartgwt.client.widgets.form.fields.ComboBoxItem#getPickerExitButtonTitle
     * pickerExitButtonTitle} for {@link com.smartgwt.client.widgets.Button#getTitle Button.title}</li> </ul>
     * <p>
     * This component is an AutoChild named "pickerExitButton".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current pickerExitButton value. Default value is null
     */
    public NavigationButton getPickerExitButton()  {
        return (NavigationButton)NavigationButton.getByJSObject(getAttributeAsJavaScriptObject("pickerExitButton"));
    }
    

    /**
     * The title for the {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem#getPickerExitButton pickerExitButton}.
     *
     * @param pickerExitButtonTitle New pickerExitButtonTitle value. Default value is "Cancel"
     * @return {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem ComboBoxItem} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public ComboBoxItem setPickerExitButtonTitle(String pickerExitButtonTitle) {
        return (ComboBoxItem)setAttribute("pickerExitButtonTitle", pickerExitButtonTitle);
    }

    /**
     * The title for the {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem#getPickerExitButton pickerExitButton}.
     *
     * @return Current pickerExitButtonTitle value. Default value is "Cancel"
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public String getPickerExitButtonTitle()  {
        return getAttributeAsString("pickerExitButtonTitle");
    }
    

    /**
     * Don't specify an explicit height for the picker icon - instead have it size to match the height of the combo box item.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param pickerIconHeight New pickerIconHeight value. Default value is null
     * @return {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem ComboBoxItem} instance, for chaining setter calls
     */
    public ComboBoxItem setPickerIconHeight(Integer pickerIconHeight) {
        return (ComboBoxItem)setAttribute("pickerIconHeight", pickerIconHeight);
    }

    /**
     * Don't specify an explicit height for the picker icon - instead have it size to match the height of the combo box item.
     *
     * @return Current pickerIconHeight value. Default value is null
     */
    public Integer getPickerIconHeight()  {
        return getAttributeAsInt("pickerIconHeight");
    }
    

    /**
     * If {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem#getShowPickerIcon showPickerIcon} is true for this item,
     * this property governs the {@link com.smartgwt.client.widgets.form.fields.FormItemIcon#getSrc src} of the picker icon
     * image to be displayed. <P> When {@link com.smartgwt.client.docs.Skinning spriting} is enabled, this property will not 
     * be used to locate an image, instead, the image is drawn via CSS based on the  {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getPickerIconStyle FormItem.pickerIconStyle} property.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param pickerIconSrc New pickerIconSrc value. Default value is "[SKIN]/DynamicForm/ComboBoxItem_PickButton_icon.gif"
     * @return {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem ComboBoxItem} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     */
    public ComboBoxItem setPickerIconSrc(String pickerIconSrc) {
        return (ComboBoxItem)setAttribute("pickerIconSrc", pickerIconSrc);
    }

    /**
     * If {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem#getShowPickerIcon showPickerIcon} is true for this item,
     * this property governs the {@link com.smartgwt.client.widgets.form.fields.FormItemIcon#getSrc src} of the picker icon
     * image to be displayed. <P> When {@link com.smartgwt.client.docs.Skinning spriting} is enabled, this property will not 
     * be used to locate an image, instead, the image is drawn via CSS based on the  {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getPickerIconStyle FormItem.pickerIconStyle} property.
     *
     * @return Current pickerIconSrc value. Default value is "[SKIN]/DynamicForm/ComboBoxItem_PickButton_icon.gif"
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     */
    public String getPickerIconSrc()  {
        return getAttributeAsString("pickerIconSrc");
    }
    
    

    /**
     * {@link com.smartgwt.client.widgets.layout.NavigationBar} created when {@link
     * com.smartgwt.client.widgets.form.fields.ComboBoxItem#getPickListPlacement pickListPlacement} indicates that the search
     * interface takes over the entire panel or screen.
     * <p>
     * This component is an AutoChild named "pickerNavigationBar".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current pickerNavigationBar value. Default value is null
     */
    public NavigationBar getPickerNavigationBar()  {
        return (NavigationBar)NavigationBar.getByJSObject(getAttributeAsJavaScriptObject("pickerNavigationBar"));
    }
    

    /**
     * "Accept" button for {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem#getAddUnknownValues
     * addUnknownValues:true} ComboBoxItems showing the mobile interface. <P> The pickerSaveButton is an automatically created
     * {@link com.smartgwt.client.widgets.NavigationButton} autoChild to dismiss the picker interface and store out the value
     * entered in the {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem#getPickerSearchField pickerSearchField},
     * created when  {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem#getPickListPlacement pickListPlacement}
     * indicates that the search interface takes over the entire panel or screen. <P> This button will only be shown when
     * {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem#getAddUnknownValues addUnknownValues} is true. Note that if
     * a user has entered a partial known value, the pickList will show a filtered list of possible matches. An "Enter"
     * keypress (or native keyboard "Done" button click on a mobile browser keyboard) will select the first match from the 
     * list. The pickerSaveButton provides a way for users to explicitly use the value as entered instead. <p> The following
     * {@link com.smartgwt.client.docs.AutoChildUsage passthroughs} apply: <ul> <li>{@link
     * com.smartgwt.client.widgets.form.fields.ComboBoxItem#getPickerSaveButtonTitle pickerSaveButtonTitle} for {@link
     * com.smartgwt.client.widgets.Button#getTitle Button.title}</li> </ul>
     * <p>
     * This component is an AutoChild named "pickerSaveButton".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current pickerSaveButton value. Default value is null
     */
    public NavigationButton getPickerSaveButton()  {
        return (NavigationButton)NavigationButton.getByJSObject(getAttributeAsJavaScriptObject("pickerSaveButton"));
    }
    

    /**
     * The title for the {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem#getPickerSaveButton pickerSaveButton}.
     *
     * @param pickerSaveButtonTitle New pickerSaveButtonTitle value. Default value is "Accept"
     * @return {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem ComboBoxItem} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public ComboBoxItem setPickerSaveButtonTitle(String pickerSaveButtonTitle) {
        return (ComboBoxItem)setAttribute("pickerSaveButtonTitle", pickerSaveButtonTitle);
    }

    /**
     * The title for the {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem#getPickerSaveButton pickerSaveButton}.
     *
     * @return Current pickerSaveButtonTitle value. Default value is "Accept"
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public String getPickerSaveButtonTitle()  {
        return getAttributeAsString("pickerSaveButtonTitle");
    }
    

    /**
     * The <code>pickerSearchField</code> is a separate {@link com.smartgwt.client.widgets.form.fields.TextItem} created for 
     * search string entry when {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem#getPickListPlacement
     * pickListPlacement} indicates that the search  interface takes over an entire panel or the entire screen. <p> The
     * following {@link com.smartgwt.client.docs.AutoChildUsage passthroughs} apply: <ul> <li>{@link
     * com.smartgwt.client.widgets.form.fields.ComboBoxItem#getPickerSearchFieldHint pickerSearchFieldHint} for {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getHint FormItem.hint}</li> </ul>
     * <p>
     * This component is an AutoChild named "pickerSearchField".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current pickerSearchField value. Default value is null
     */
    public TextItem getPickerSearchField()  {
        return TextItem.getOrCreateRef(getAttributeAsJavaScriptObject("pickerSearchField"));
    }
    

    /**
     * {@link com.smartgwt.client.widgets.form.fields.FormItem#getHint FormItem.hint} for the {@link
     * com.smartgwt.client.widgets.form.fields.ComboBoxItem#getPickerSearchField pickerSearchField}.
     *
     * @param pickerSearchFieldHint New pickerSearchFieldHint value. Default value is "Search"
     * @return {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem ComboBoxItem} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public ComboBoxItem setPickerSearchFieldHint(String pickerSearchFieldHint) {
        return (ComboBoxItem)setAttribute("pickerSearchFieldHint", pickerSearchFieldHint);
    }

    /**
     * {@link com.smartgwt.client.widgets.form.fields.FormItem#getHint FormItem.hint} for the {@link
     * com.smartgwt.client.widgets.form.fields.ComboBoxItem#getPickerSearchField pickerSearchField}.
     *
     * @return Current pickerSearchFieldHint value. Default value is "Search"
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public String getPickerSearchFieldHint()  {
        return getAttributeAsString("pickerSearchFieldHint");
    }
    

    /**
     * Form that contains the {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem#getPickerSearchField
     * pickerSearchField}.
     * <p>
     * This component is an AutoChild named "pickerSearchForm".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current pickerSearchForm value. Default value is null
     */
    public DynamicForm getPickerSearchForm()  {
        return (DynamicForm)DynamicForm.getByJSObject(getAttributeAsJavaScriptObject("pickerSearchForm"));
    }
    

    /**
     * {@link com.smartgwt.client.widgets.form.fields.FormItem#getHint FormItem.hint} for the {@link
     * com.smartgwt.client.widgets.form.fields.ComboBoxItem#getPickerSearchField pickerSearchField} when the combobox is
     * configured to  {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem#getAddUnknownValues allow unknown values}
     *
     * @param pickerSearchOrNewValueFieldHint New pickerSearchOrNewValueFieldHint value. Default value is "Search or enter new value"
     * @return {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem ComboBoxItem} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public ComboBoxItem setPickerSearchOrNewValueFieldHint(String pickerSearchOrNewValueFieldHint) {
        return (ComboBoxItem)setAttribute("pickerSearchOrNewValueFieldHint", pickerSearchOrNewValueFieldHint);
    }

    /**
     * {@link com.smartgwt.client.widgets.form.fields.FormItem#getHint FormItem.hint} for the {@link
     * com.smartgwt.client.widgets.form.fields.ComboBoxItem#getPickerSearchField pickerSearchField} when the combobox is
     * configured to  {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem#getAddUnknownValues allow unknown values}
     *
     * @return Current pickerSearchOrNewValueFieldHint value. Default value is "Search or enter new value"
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public String getPickerSearchOrNewValueFieldHint()  {
        return getAttributeAsString("pickerSearchOrNewValueFieldHint");
    }
    

    /**
     * The Class to use when creating a picker of  type "list" for  a FormItem.  Must be a subclass of the builtin default, 
     * {@link com.smartgwt.client.widgets.form.PickListMenu PickListMenu}.
     *
     * @param pickListConstructor New pickListConstructor value. Default value is "PickListMenu"
     * @return {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem ComboBoxItem} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.SCClassName SCClassName 
     * @see com.smartgwt.client.docs.PickList PickList overview and related methods
     */
    public ComboBoxItem setPickListConstructor(String pickListConstructor) {
        return (ComboBoxItem)setAttribute("pickListConstructor", pickListConstructor);
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
     * If this item has a databound pickList (for example  PickList.optionDataSource is set), this property can be used to
     * provide static filter criteria when retrieving the data for the pickList.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param pickListCriteria New pickListCriteria value. Default value is null
     * @return {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem ComboBoxItem} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.PickList PickList overview and related methods
     */
    public ComboBoxItem setPickListCriteria(Criteria pickListCriteria) {
        if (pickListCriteria instanceof Criterion) {
            pickListCriteria.setAttribute("_constructor", "AdvancedCriteria");
        }
        return (ComboBoxItem)setAttribute("pickListCriteria", pickListCriteria == null ? null : pickListCriteria.getJsObj());
    }

    /**
     * If this item has a databound pickList (for example  PickList.optionDataSource is set), this property can be used to
     * provide static filter criteria when retrieving the data for the pickList.
     *
     * @return Current pickListCriteria value. Default value is null
     * @see com.smartgwt.client.docs.PickList PickList overview and related methods
     */
    public Criteria getPickListCriteria()  {
        return new Criteria(getAttributeAsJavaScriptObject("pickListCriteria"));
    }
    

    /**
     * This property allows the developer to specify which field[s] will be displayed in the  drop down list of options. <P>
     * Only applies to databound pickLists (see  PickList.optionDataSource, or pickLists with custom data set up via the
     * advanced  PickList.getClientPickListData() method. <P> If this property is unset, we display the  PickList.displayField,
     * if specified,  otherwise the  PickList.valueField. <P> If there are multiple fields, column headers will be shown for
     * each field, the height of which can be customized via the  PickList.pickListHeaderHeight attribute. <P> Each field to
     * display should be specified as a {@link com.smartgwt.client.widgets.grid.ListGridField} object. Note that unlike in
     * {@link com.smartgwt.client.widgets.grid.ListGrid listGrids}, dataSource fields marked as  {@link
     * com.smartgwt.client.data.DataSourceField#getHidden hidden:true} will be hidden by default in pickLists. To override this
     * behavior, ensure that you specify an explicit value for  {@link com.smartgwt.client.widgets.grid.ListGridField#showIf
     * showIf}.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param pickListFields New pickListFields value. Default value is null
     * @return {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem ComboBoxItem} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.form.fields.ComboBoxItem#setValueField
     * @see com.smartgwt.client.docs.PickList PickList overview and related methods
     */
    public ComboBoxItem setPickListFields(ListGridField... pickListFields) {
        return (ComboBoxItem)setAttribute("pickListFields", pickListFields);
    }
    

    /**
     * Controls where the PickList is placed.   Can be specified as a {@link com.smartgwt.client.types.PanelPlacement} or a
     * specific widget that should be filled (by specifying an actual Canvas or {@link com.smartgwt.client.widgets.Canvas#getID
     * Canvas.ID}). <p> Default behavior is to <code>"fillPanel"</code> if {@link com.smartgwt.client.util.Browser#isHandset
     * isHandset} or {@link com.smartgwt.client.util.Browser#isTablet isTablet}, to better accomodate the smaller screen real
     * estate and  less precise pointing ability on such devices. <p> When filling the whole screen, part of the screen or a
     * specific panel, the expanded interface is created as a {@link com.smartgwt.client.widgets.form.fields.FormItem#getPicker
     * standard FormItem picker}, and  incorporates a {@link
     * com.smartgwt.client.widgets.form.fields.ComboBoxItem#getPickerNavigationBar navigation bar} and  {@link
     * com.smartgwt.client.widgets.form.fields.ComboBoxItem#getPickerExitButton cancel button} that hides the expanded
     * interface, as well  as a separate {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem#getPickerSearchField
     * search field}.
     *
     * @param pickListPlacement New pickListPlacement value. Default value is null
     * @return {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem ComboBoxItem} instance, for chaining setter calls
     */
    public ComboBoxItem setPickListPlacement(PanelPlacement pickListPlacement) {
        return (ComboBoxItem)setAttribute("pickListPlacement", pickListPlacement == null ? null : pickListPlacement.getValue());
    }

    /**
     * Controls where the PickList is placed.   Can be specified as a {@link com.smartgwt.client.types.PanelPlacement} or a
     * specific widget that should be filled (by specifying an actual Canvas or {@link com.smartgwt.client.widgets.Canvas#getID
     * Canvas.ID}). <p> Default behavior is to <code>"fillPanel"</code> if {@link com.smartgwt.client.util.Browser#isHandset
     * isHandset} or {@link com.smartgwt.client.util.Browser#isTablet isTablet}, to better accomodate the smaller screen real
     * estate and  less precise pointing ability on such devices. <p> When filling the whole screen, part of the screen or a
     * specific panel, the expanded interface is created as a {@link com.smartgwt.client.widgets.form.fields.FormItem#getPicker
     * standard FormItem picker}, and  incorporates a {@link
     * com.smartgwt.client.widgets.form.fields.ComboBoxItem#getPickerNavigationBar navigation bar} and  {@link
     * com.smartgwt.client.widgets.form.fields.ComboBoxItem#getPickerExitButton cancel button} that hides the expanded
     * interface, as well  as a separate {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem#getPickerSearchField
     * search field}.
     *
     * @return Current pickListPlacement value. Default value is null
     */
    public PanelPlacement getPickListPlacement()  {
        return EnumUtil.getEnum(PanelPlacement.values(), getAttribute("pickListPlacement"));
    }

    /**
     * Controls where the PickList is placed.   Can be specified as a {@link com.smartgwt.client.types.PanelPlacement} or a
     * specific widget that should be filled (by specifying an actual Canvas or {@link com.smartgwt.client.widgets.Canvas#getID
     * Canvas.ID}). <p> Default behavior is to <code>"fillPanel"</code> if {@link com.smartgwt.client.util.Browser#isHandset
     * isHandset} or {@link com.smartgwt.client.util.Browser#isTablet isTablet}, to better accomodate the smaller screen real
     * estate and  less precise pointing ability on such devices. <p> When filling the whole screen, part of the screen or a
     * specific panel, the expanded interface is created as a {@link com.smartgwt.client.widgets.form.fields.FormItem#getPicker
     * standard FormItem picker}, and  incorporates a {@link
     * com.smartgwt.client.widgets.form.fields.ComboBoxItem#getPickerNavigationBar navigation bar} and  {@link
     * com.smartgwt.client.widgets.form.fields.ComboBoxItem#getPickerExitButton cancel button} that hides the expanded
     * interface, as well  as a separate {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem#getPickerSearchField
     * search field}.
     *
     * @param pickListPlacement New pickListPlacement value. Default value is null
     * @return {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem ComboBoxItem} instance, for chaining setter calls
     */
    public ComboBoxItem setPickListPlacement(Canvas pickListPlacement) {
        return (ComboBoxItem)setAttribute("pickListPlacement", pickListPlacement == null ? null : pickListPlacement.getOrCreateJsObj());
    }

    /**
     * Controls where the PickList is placed.   Can be specified as a {@link com.smartgwt.client.types.PanelPlacement} or a
     * specific widget that should be filled (by specifying an actual Canvas or {@link com.smartgwt.client.widgets.Canvas#getID
     * Canvas.ID}). <p> Default behavior is to <code>"fillPanel"</code> if {@link com.smartgwt.client.util.Browser#isHandset
     * isHandset} or {@link com.smartgwt.client.util.Browser#isTablet isTablet}, to better accomodate the smaller screen real
     * estate and  less precise pointing ability on such devices. <p> When filling the whole screen, part of the screen or a
     * specific panel, the expanded interface is created as a {@link com.smartgwt.client.widgets.form.fields.FormItem#getPicker
     * standard FormItem picker}, and  incorporates a {@link
     * com.smartgwt.client.widgets.form.fields.ComboBoxItem#getPickerNavigationBar navigation bar} and  {@link
     * com.smartgwt.client.widgets.form.fields.ComboBoxItem#getPickerExitButton cancel button} that hides the expanded
     * interface, as well  as a separate {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem#getPickerSearchField
     * search field}.
     *
     * @return Current pickListPlacement value. Default value is null
     */
    public Canvas getPickListPlacementAsCanvas()  {
        return (Canvas)Canvas.getByJSObject(getAttributeAsJavaScriptObject("pickListPlacement"));
    }

    /**
     * Controls where the PickList is placed.   Can be specified as a {@link com.smartgwt.client.types.PanelPlacement} or a
     * specific widget that should be filled (by specifying an actual Canvas or {@link com.smartgwt.client.widgets.Canvas#getID
     * Canvas.ID}). <p> Default behavior is to <code>"fillPanel"</code> if {@link com.smartgwt.client.util.Browser#isHandset
     * isHandset} or {@link com.smartgwt.client.util.Browser#isTablet isTablet}, to better accomodate the smaller screen real
     * estate and  less precise pointing ability on such devices. <p> When filling the whole screen, part of the screen or a
     * specific panel, the expanded interface is created as a {@link com.smartgwt.client.widgets.form.fields.FormItem#getPicker
     * standard FormItem picker}, and  incorporates a {@link
     * com.smartgwt.client.widgets.form.fields.ComboBoxItem#getPickerNavigationBar navigation bar} and  {@link
     * com.smartgwt.client.widgets.form.fields.ComboBoxItem#getPickerExitButton cancel button} that hides the expanded
     * interface, as well  as a separate {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem#getPickerSearchField
     * search field}.
     *
     * @param pickListPlacement New pickListPlacement value. Default value is null
     * @return {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem ComboBoxItem} instance, for chaining setter calls
     */
    public ComboBoxItem setPickListPlacement(String pickListPlacement) {
        return (ComboBoxItem)setAttribute("pickListPlacement", pickListPlacement);
    }

    /**
     * Controls where the PickList is placed.   Can be specified as a {@link com.smartgwt.client.types.PanelPlacement} or a
     * specific widget that should be filled (by specifying an actual Canvas or {@link com.smartgwt.client.widgets.Canvas#getID
     * Canvas.ID}). <p> Default behavior is to <code>"fillPanel"</code> if {@link com.smartgwt.client.util.Browser#isHandset
     * isHandset} or {@link com.smartgwt.client.util.Browser#isTablet isTablet}, to better accomodate the smaller screen real
     * estate and  less precise pointing ability on such devices. <p> When filling the whole screen, part of the screen or a
     * specific panel, the expanded interface is created as a {@link com.smartgwt.client.widgets.form.fields.FormItem#getPicker
     * standard FormItem picker}, and  incorporates a {@link
     * com.smartgwt.client.widgets.form.fields.ComboBoxItem#getPickerNavigationBar navigation bar} and  {@link
     * com.smartgwt.client.widgets.form.fields.ComboBoxItem#getPickerExitButton cancel button} that hides the expanded
     * interface, as well  as a separate {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem#getPickerSearchField
     * search field}.
     *
     * @return Current pickListPlacement value. Default value is null
     */
    public String getPickListPlacementAsString()  {
        return getAttributeAsString("pickListPlacement");
    }
    
    

    /**
     * The Class to use when creating a picker of  type "tree" for  a FormItem.  Must be a subclass of the builtin default,  
     * PickTreeMenu.
     *
     * @param pickTreeConstructor New pickTreeConstructor value. Default value is "PickTreeMenu"
     * @return {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem ComboBoxItem} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.SCClassName SCClassName 
     */
    public ComboBoxItem setPickTreeConstructor(String pickTreeConstructor) {
        return (ComboBoxItem)setAttribute("pickTreeConstructor", pickTreeConstructor);
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
     * Indicates whether or not this ComboBoxItem will load its list of options  {@link
     * com.smartgwt.client.data.DataSource#getProgressiveLoading progressively}.  This property is copied onto the underlying
     * PickList.
     *
     * @param progressiveLoading New progressiveLoading value. Default value is true
     * @return {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem ComboBoxItem} instance, for chaining setter calls
     * @see com.smartgwt.client.data.DataSource#setProgressiveLoading
     * @see com.smartgwt.client.docs.ProgressiveLoading ProgressiveLoading overview and related methods
     */
    public ComboBoxItem setProgressiveLoading(Boolean progressiveLoading) {
        return (ComboBoxItem)setAttribute("progressiveLoading", progressiveLoading);
    }

    /**
     * Indicates whether or not this ComboBoxItem will load its list of options  {@link
     * com.smartgwt.client.data.DataSource#getProgressiveLoading progressively}.  This property is copied onto the underlying
     * PickList.
     *
     * @return Current progressiveLoading value. Default value is true
     * @see com.smartgwt.client.data.DataSource#getProgressiveLoading
     * @see com.smartgwt.client.docs.ProgressiveLoading ProgressiveLoading overview and related methods
     */
    public Boolean getProgressiveLoading()  {
        Boolean result = getAttributeAsBoolean("progressiveLoading", true);
        return result == null ? true : result;
    }
    

    /**
     * When this item is showing a  tree-based picker, this is  the {@link
     * com.smartgwt.client.widgets.form.fields.SelectItem#getValueField id} of the record to use as the  {@link
     * com.smartgwt.client.widgets.tree.Tree#getRootValue root} node.
     *
     * @param rootNodeId New rootNodeId value. Default value is null
     * @return {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem ComboBoxItem} instance, for chaining setter calls
     */
    public ComboBoxItem setRootNodeId(String rootNodeId) {
        return (ComboBoxItem)setAttribute("rootNodeId", rootNodeId);
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
     * @return {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem ComboBoxItem} instance, for chaining setter calls
     */
    public ComboBoxItem setRootNodeId(Integer rootNodeId) {
        return (ComboBoxItem)setAttribute("rootNodeId", rootNodeId);
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
     * ComboBox items will submit their containing form on enter keypress  if {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getSaveOnEnter saveOnEnter} is true. Setting this property to
     * <code>false</code> will disable this behavior. <P> Note that if the drop down list of options (pickList) is visible an
     * <code>Enter</code> keypress is used to select a value from the available set of options and will not automatically cause
     * form submission.
     *
     * @param saveOnEnter New saveOnEnter value. Default value is true
     * @return {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem ComboBoxItem} instance, for chaining setter calls
     */
    public ComboBoxItem setSaveOnEnter(Boolean saveOnEnter) {
        return (ComboBoxItem)setAttribute("saveOnEnter", saveOnEnter);
    }

    /**
     * ComboBox items will submit their containing form on enter keypress  if {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getSaveOnEnter saveOnEnter} is true. Setting this property to
     * <code>false</code> will disable this behavior. <P> Note that if the drop down list of options (pickList) is visible an
     * <code>Enter</code> keypress is used to select a value from the available set of options and will not automatically cause
     * form submission.
     *
     * @return Current saveOnEnter value. Default value is true
     */
    public Boolean getSaveOnEnter()  {
        Boolean result = getAttributeAsBoolean("saveOnEnter", true);
        return result == null ? true : result;
    }
    

    /**
     * Message to display in pick list when {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem#getMinimumSearchLength
     * minimumSearchLength} characters have not been entered.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param searchStringTooShortMessage New searchStringTooShortMessage value. Default value is "Enter a longer search string to search"
     * @return {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem ComboBoxItem} instance, for chaining setter calls
     */
    public ComboBoxItem setSearchStringTooShortMessage(String searchStringTooShortMessage) {
        return (ComboBoxItem)setAttribute("searchStringTooShortMessage", searchStringTooShortMessage);
    }

    /**
     * Message to display in pick list when {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem#getMinimumSearchLength
     * minimumSearchLength} characters have not been entered.
     *
     * @return Current searchStringTooShortMessage value. Default value is "Enter a longer search string to search"
     */
    public String getSearchStringTooShortMessage()  {
        return getAttributeAsString("searchStringTooShortMessage");
    }
    

    /**
     * If true, {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem#getSpecialValues specialValues} special values such
     * as the empty value will be shown in a separate non-scrolling area, in the {@link
     * com.smartgwt.client.widgets.form.fields.ComboBoxItem#getSeparateValuesList separateValuesList}.  Aside from making these
     * values more easily accessible, showing them in a separate list allows data paging to be used, which is disabled if the
     * separateValues are shown in the normal drop-down list along with other values.
     *
     * @param separateSpecialValues New separateSpecialValues value. Default value is null
     * @return {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem ComboBoxItem} instance, for chaining setter calls
     */
    public ComboBoxItem setSeparateSpecialValues(Boolean separateSpecialValues) {
        return (ComboBoxItem)setAttribute("separateSpecialValues", separateSpecialValues);
    }

    /**
     * If true, {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem#getSpecialValues specialValues} special values such
     * as the empty value will be shown in a separate non-scrolling area, in the {@link
     * com.smartgwt.client.widgets.form.fields.ComboBoxItem#getSeparateValuesList separateValuesList}.  Aside from making these
     * values more easily accessible, showing them in a separate list allows data paging to be used, which is disabled if the
     * separateValues are shown in the normal drop-down list along with other values.
     *
     * @return Current separateSpecialValues value. Default value is null
     */
    public Boolean getSeparateSpecialValues()  {
        return getAttributeAsBoolean("separateSpecialValues", true);
    }
    

    /**
     * AutoChild used to show {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem#getSpecialValues specialValues}.
     * <p>
     * This component is an AutoChild named "separateValuesList".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current separateValuesList value. Default value is null
     */
    public ListGrid getSeparateValuesList()  {
        return (ListGrid)ListGrid.getByJSObject(getAttributeAsJavaScriptObject("separateValuesList"));
    }
    

    /**
     * Array of records to show between matching and non-matching rows in the PickList. <P> Not valid for {@link
     * com.smartgwt.client.widgets.form.fields.ComboBoxItem#getOptionDataSource databound pickLists}.
     *
     * @param separatorRows New separatorRows value. Default value is [{isSeparator:true}]
     * @return {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem ComboBoxItem} instance, for chaining setter calls
     */
    public ComboBoxItem setSeparatorRows(ListGridRecord[] separatorRows) {
        return (ComboBoxItem)setAttribute("separatorRows", separatorRows);
    }
    

    /**
     * If true, even non-matching options will be shown, with configurable  {@link
     * com.smartgwt.client.widgets.form.fields.ComboBoxItem#getSeparatorRows separator rows} in between.  Not valid for {@link
     * com.smartgwt.client.widgets.form.fields.ComboBoxItem#getOptionDataSource databound pickLists}.
     *
     * @param showAllOptions New showAllOptions value. Default value is null
     * @return {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem ComboBoxItem} instance, for chaining setter calls
     */
    public ComboBoxItem setShowAllOptions(Boolean showAllOptions) {
        return (ComboBoxItem)setAttribute("showAllOptions", showAllOptions);
    }

    /**
     * If true, even non-matching options will be shown, with configurable  {@link
     * com.smartgwt.client.widgets.form.fields.ComboBoxItem#getSeparatorRows separator rows} in between.  Not valid for {@link
     * com.smartgwt.client.widgets.form.fields.ComboBoxItem#getOptionDataSource databound pickLists}.
     *
     * @return Current showAllOptions value. Default value is null
     */
    public Boolean getShowAllOptions()  {
        return getAttributeAsBoolean("showAllOptions", true);
    }
    

    /**
     * If showing a hint for this form item, should it be shown within the field? <P>CSS style for the hint is {@link
     * com.smartgwt.client.widgets.form.fields.SelectItem#getTextBoxStyle SelectItem.textBoxStyle} with the suffix "Hint"
     * appended to it.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param showHintInField New showHintInField value. Default value is null
     * @return {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem ComboBoxItem} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.form.fields.FormItem#setHint
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public ComboBoxItem setShowHintInField(Boolean showHintInField) {
        return (ComboBoxItem)setAttribute("showHintInField", showHintInField);
    }

    /**
     * If showing a hint for this form item, should it be shown within the field? <P>CSS style for the hint is {@link
     * com.smartgwt.client.widgets.form.fields.SelectItem#getTextBoxStyle SelectItem.textBoxStyle} with the suffix "Hint"
     * appended to it.
     *
     * @return Current showHintInField value. Default value is null
     * @see com.smartgwt.client.widgets.form.fields.FormItem#getHint
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Boolean getShowHintInField()  {
        return getAttributeAsBoolean("showHintInField", true);
    }
    

    /**
     * If this item is part of a databound form, and has a specified <code>valueMap</code>, by default we show the valueMap
     * options in the pickList for the item. Setting this property to true will ensure that the options displayed in our
     * pickList are derived from the form's <code>dataSource</code>.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param showOptionsFromDataSource New showOptionsFromDataSource value. Default value is null
     * @return {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem ComboBoxItem} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.Databinding Databinding overview and related methods
     */
    public ComboBoxItem setShowOptionsFromDataSource(Boolean showOptionsFromDataSource) {
        return (ComboBoxItem)setAttribute("showOptionsFromDataSource", showOptionsFromDataSource);
    }

    /**
     * If this item is part of a databound form, and has a specified <code>valueMap</code>, by default we show the valueMap
     * options in the pickList for the item. Setting this property to true will ensure that the options displayed in our
     * pickList are derived from the form's <code>dataSource</code>.
     *
     * @return Current showOptionsFromDataSource value. Default value is null
     * @see com.smartgwt.client.docs.Databinding Databinding overview and related methods
     */
    public Boolean getShowOptionsFromDataSource()  {
        return getAttributeAsBoolean("showOptionsFromDataSource", true);
    }
    

    /**
     * Should we show a special 'picker' {@link com.smartgwt.client.widgets.form.fields.FormItemIcon icon} for this form item?
     * Picker icons are customizable via {@link com.smartgwt.client.widgets.form.fields.FormItem#getPickerIconProperties
     * pickerIconProperties}. By default they will be rendered inside the form item's {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getControlStyle "control box"} area. By default clicking the pickerIcon
     * will call {@link com.smartgwt.client.widgets.form.fields.FormItem#showPicker FormItem.showPicker()}.
     *
     * @param showPickerIcon New showPickerIcon value. Default value is true
     * @return {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem ComboBoxItem} instance, for chaining setter calls
     */
    public ComboBoxItem setShowPickerIcon(Boolean showPickerIcon) {
        return (ComboBoxItem)setAttribute("showPickerIcon", showPickerIcon);
    }

    /**
     * Should we show a special 'picker' {@link com.smartgwt.client.widgets.form.fields.FormItemIcon icon} for this form item?
     * Picker icons are customizable via {@link com.smartgwt.client.widgets.form.fields.FormItem#getPickerIconProperties
     * pickerIconProperties}. By default they will be rendered inside the form item's {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getControlStyle "control box"} area. By default clicking the pickerIcon
     * will call {@link com.smartgwt.client.widgets.form.fields.FormItem#showPicker FormItem.showPicker()}.
     *
     * @return Current showPickerIcon value. Default value is true
     */
    public Boolean getShowPickerIcon()  {
        Boolean result = getAttributeAsBoolean("showPickerIcon", true);
        return result == null ? true : result;
    }
    

    /**
     * Should the list of options be displayed whenever the user types into the  combo-box textArea, or only when the user
     * clicks on the pick button or uses the  explicit <code>Alt+Arrow Down</code> key combination?
     *
     * @param showPickListOnKeypress New showPickListOnKeypress value. Default value is true
     * @return {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem ComboBoxItem} instance, for chaining setter calls
     */
    public ComboBoxItem setShowPickListOnKeypress(Boolean showPickListOnKeypress) {
        return (ComboBoxItem)setAttribute("showPickListOnKeypress", showPickListOnKeypress);
    }

    /**
     * Should the list of options be displayed whenever the user types into the  combo-box textArea, or only when the user
     * clicks on the pick button or uses the  explicit <code>Alt+Arrow Down</code> key combination?
     *
     * @return Current showPickListOnKeypress value. Default value is true
     */
    public Boolean getShowPickListOnKeypress()  {
        Boolean result = getAttributeAsBoolean("showPickListOnKeypress", true);
        return result == null ? true : result;
    }
    

    /**
     * When this item is showing a  tree-based picker, the default behavior is for folder open-state to be toggled by
     * double-clicking. Set this  attribute to true to toggle folders on a single-click instead. <P> Note: when set to true,
     * users can only choose leaf-nodes, since clicking folders would simply toggle them.
     *
     * @param singleClickFolderToggle New singleClickFolderToggle value. Default value is false
     * @return {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem ComboBoxItem} instance, for chaining setter calls
     */
    public ComboBoxItem setSingleClickFolderToggle(boolean singleClickFolderToggle) {
        return (ComboBoxItem)setAttribute("singleClickFolderToggle", singleClickFolderToggle);
    }

    /**
     * When this item is showing a  tree-based picker, the default behavior is for folder open-state to be toggled by
     * double-clicking. Set this  attribute to true to toggle folders on a single-click instead. <P> Note: when set to true,
     * users can only choose leaf-nodes, since clicking folders would simply toggle them.
     *
     * @return Current singleClickFolderToggle value. Default value is false
     */
    public boolean getSingleClickFolderToggle()  {
        Boolean result = getAttributeAsBoolean("singleClickFolderToggle", true);
        return result == null ? false : result;
    }
    

    /**
     * Specifies one or more fields by which this item should be initially sorted.  It can be  a {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getName field name}, or an array of field names - but note that, if
     * multiple fields are supplied, then each will be sorted in the same  {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getSortDirection direction}. <P> For full sorting control, set  initialSort to
     * a list of custom {@link com.smartgwt.client.data.SortSpecifier sortSpecifiers}. <P> This attribute can also be set to
     * the index of a field in the fields array, but note  that it will be converted to a string (field name) after
     * initialization.
     *
     * @param sortField New sortField value. Default value is null
     * @return {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem ComboBoxItem} instance, for chaining setter calls
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#grid_sort_sort" target="examples">Sort Example</a>
     */
    public ComboBoxItem setSortField(String sortField) {
        return (ComboBoxItem)setAttribute("sortField", sortField);
    }

    /**
     * Specifies one or more fields by which this item should be initially sorted.  It can be  a {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getName field name}, or an array of field names - but note that, if
     * multiple fields are supplied, then each will be sorted in the same  {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getSortDirection direction}. <P> For full sorting control, set  initialSort to
     * a list of custom {@link com.smartgwt.client.data.SortSpecifier sortSpecifiers}. <P> This attribute can also be set to
     * the index of a field in the fields array, but note  that it will be converted to a string (field name) after
     * initialization.
     *
     * @return Current sortField value. Default value is null
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#grid_sort_sort" target="examples">Sort Example</a>
     */
    public String getSortField()  {
        return getAttributeAsString("sortField");
    }

    /**
     * Specifies one or more fields by which this item should be initially sorted.  It can be  a {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getName field name}, or an array of field names - but note that, if
     * multiple fields are supplied, then each will be sorted in the same  {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getSortDirection direction}. <P> For full sorting control, set  initialSort to
     * a list of custom {@link com.smartgwt.client.data.SortSpecifier sortSpecifiers}. <P> This attribute can also be set to
     * the index of a field in the fields array, but note  that it will be converted to a string (field name) after
     * initialization.
     *
     * @param sortField New sortField value. Default value is null
     * @return {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem ComboBoxItem} instance, for chaining setter calls
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#grid_sort_sort" target="examples">Sort Example</a>
     */
    public ComboBoxItem setSortField(String... sortField) {
        return (ComboBoxItem)setAttribute("sortField", sortField);
    }

    /**
     * Specifies one or more fields by which this item should be initially sorted.  It can be  a {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getName field name}, or an array of field names - but note that, if
     * multiple fields are supplied, then each will be sorted in the same  {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getSortDirection direction}. <P> For full sorting control, set  initialSort to
     * a list of custom {@link com.smartgwt.client.data.SortSpecifier sortSpecifiers}. <P> This attribute can also be set to
     * the index of a field in the fields array, but note  that it will be converted to a string (field name) after
     * initialization.
     *
     * @return Current sortField value. Default value is null
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#grid_sort_sort" target="examples">Sort Example</a>
     */
    public String[] getSortFieldAsStringArray()  {
        return com.smartgwt.client.util.ConvertTo.arrayOfString(getAttributeAsJavaScriptObject("sortField"));
    }

    /**
     * Specifies one or more fields by which this item should be initially sorted.  It can be  a {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getName field name}, or an array of field names - but note that, if
     * multiple fields are supplied, then each will be sorted in the same  {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getSortDirection direction}. <P> For full sorting control, set  initialSort to
     * a list of custom {@link com.smartgwt.client.data.SortSpecifier sortSpecifiers}. <P> This attribute can also be set to
     * the index of a field in the fields array, but note  that it will be converted to a string (field name) after
     * initialization.
     *
     * @param sortField New sortField value. Default value is null
     * @return {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem ComboBoxItem} instance, for chaining setter calls
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#grid_sort_sort" target="examples">Sort Example</a>
     */
    public ComboBoxItem setSortField(Integer sortField) {
        return (ComboBoxItem)setAttribute("sortField", sortField);
    }

    /**
     * Specifies one or more fields by which this item should be initially sorted.  It can be  a {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getName field name}, or an array of field names - but note that, if
     * multiple fields are supplied, then each will be sorted in the same  {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getSortDirection direction}. <P> For full sorting control, set  initialSort to
     * a list of custom {@link com.smartgwt.client.data.SortSpecifier sortSpecifiers}. <P> This attribute can also be set to
     * the index of a field in the fields array, but note  that it will be converted to a string (field name) after
     * initialization.
     *
     * @return Current sortField value. Default value is null
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#grid_sort_sort" target="examples">Sort Example</a>
     */
    public Integer getSortFieldAsInt()  {
        return getAttributeAsInt("sortField");
    }
    
    

    /**
     * When applying filter criteria to pickList data, what type of matching to use. <P> For a databound pickList ({@link
     * com.smartgwt.client.widgets.form.fields.ComboBoxItem#getOptionDataSource optionDataSource} set),
     * <code>textMatchStyle</code> is sent to the server as {@link com.smartgwt.client.data.DSRequest#getTextMatchStyle
     * DSRequest.textMatchStyle}. <P> For a non-databound pickList, <code>textMatchStyle</code> is applied by  
     * filterClientPickListData().
     *
     * @param textMatchStyle New textMatchStyle value. Default value is "startsWith"
     * @return {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem ComboBoxItem} instance, for chaining setter calls
     */
    public ComboBoxItem setTextMatchStyle(TextMatchStyle textMatchStyle) {
        return (ComboBoxItem)setAttribute("textMatchStyle", textMatchStyle == null ? null : textMatchStyle.getValue());
    }

    /**
     * When applying filter criteria to pickList data, what type of matching to use. <P> For a databound pickList ({@link
     * com.smartgwt.client.widgets.form.fields.ComboBoxItem#getOptionDataSource optionDataSource} set),
     * <code>textMatchStyle</code> is sent to the server as {@link com.smartgwt.client.data.DSRequest#getTextMatchStyle
     * DSRequest.textMatchStyle}. <P> For a non-databound pickList, <code>textMatchStyle</code> is applied by  
     * filterClientPickListData().
     *
     * @return Current textMatchStyle value. Default value is "startsWith"
     */
    public TextMatchStyle getTextMatchStyle()  {
        return EnumUtil.getEnum(TextMatchStyle.values(), getAttribute("textMatchStyle"));
    }
    

    /**
     * For {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem#getOptionDataSource databound} items, this property will
     * be passed to the generated ResultSet data object for the pickList as {@link
     * com.smartgwt.client.data.ResultSet#getUseClientFiltering ResultSet.useClientFiltering}. Setting to false will disable
     * filtering on the client and ensure criteria are always passed to the DataSource directly.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param useClientFiltering New useClientFiltering value. Default value is null
     * @return {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem ComboBoxItem} instance, for chaining setter calls
     */
    public ComboBoxItem setUseClientFiltering(Boolean useClientFiltering) {
        return (ComboBoxItem)setAttribute("useClientFiltering", useClientFiltering);
    }

    /**
     * For {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem#getOptionDataSource databound} items, this property will
     * be passed to the generated ResultSet data object for the pickList as {@link
     * com.smartgwt.client.data.ResultSet#getUseClientFiltering ResultSet.useClientFiltering}. Setting to false will disable
     * filtering on the client and ensure criteria are always passed to the DataSource directly.
     *
     * @return Current useClientFiltering value. Default value is null
     */
    public Boolean getUseClientFiltering()  {
        return getAttributeAsBoolean("useClientFiltering", true);
    }
    

    /**
     * If this form item maps data values to display values by retrieving the  {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getDisplayField FormItem.displayField} values from an  {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getOptionDataSource optionDataSource}, this property  denotes the the
     * field to use as the underlying data value in records from the  optionDataSource.<br> If not explicitly supplied, the
     * valueField name will be derived as described in {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getValueFieldName FormItem.getValueFieldName()}.
     *
     * @param valueField New valueField value. Default value is null
     * @return {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem ComboBoxItem} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.Databinding Databinding overview and related methods
     */
    public ComboBoxItem setValueField(String valueField) {
        return (ComboBoxItem)setAttribute("valueField", valueField);
    }

    /**
     * If this form item maps data values to display values by retrieving the  {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getDisplayField FormItem.displayField} values from an  {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getOptionDataSource optionDataSource}, this property  denotes the the
     * field to use as the underlying data value in records from the  optionDataSource.<br> If not explicitly supplied, the
     * valueField name will be derived as described in {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getValueFieldName FormItem.getValueFieldName()}.
     *
     * @return Getter method to retrieve the {@link com.smartgwt.client.widgets.form.fields.FormItem#getValueField FormItem.valueField}
     * for this item. For items with a specified {@link com.smartgwt.client.widgets.form.fields.FormItem#getOptionDataSource
     * FormItem.optionDataSource}, this determines which field in that dataSource corresponds to the value for this item. <P>
     * If unset, if a {@link com.smartgwt.client.data.DataSourceField#getForeignKey foreignKey relationship} exists between
     * this field and the optionDataSource, this will be used, otherwise default behavior will return the {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getName FormItem.name} of this field. Default value is null
     * @see com.smartgwt.client.docs.Databinding Databinding overview and related methods
     */
    public String getValueField()  {
        return getAttributeAsString("valueField");
    }
    

    // ********************* Methods ***********************
    /**
     * Add a dataArrived handler.
     * <p>
     * If this item is showing a dataBound pickList, this notification method will be fired  when new data arrives from the
     * server.
     *
     * @param handler the dataArrived handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addDataArrivedHandler(com.smartgwt.client.widgets.form.fields.events.DataArrivedHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.form.fields.events.DataArrivedEvent.getType()) == 0) setupDataArrivedEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.form.fields.events.DataArrivedEvent.getType());
    }

    private native void setupDataArrivedEvent() /*-{
        var obj;
        obj = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        var selfJ = this;
        var dataArrived = $entry(function(){
            var param = {"_this": this, "startRow" : arguments[0], "endRow" : arguments[1], "data" : arguments[2]};
            var event = @com.smartgwt.client.widgets.form.fields.events.DataArrivedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.core.DataClass::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            selfJ.@com.smartgwt.client.widgets.form.fields.ComboBoxItem::handleTearDownDataArrivedEvent()();
            });
        obj.dataArrived =  dataArrived 
        ;
    }-*/;

    private void handleTearDownDataArrivedEvent() {
        if (getHandlerCount(com.smartgwt.client.widgets.form.fields.events.DataArrivedEvent.getType()) == 0) tearDownDataArrivedEvent();
    }

    private native void tearDownDataArrivedEvent() /*-{
        var obj;
        obj = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        if (obj && "dataArrived" in obj) delete obj.dataArrived;
    }-*/;

	/**
     * Expression evaluated to determine the {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem#getDefaultValue
     * defaultValue} when no value is  provided for this item. To default to the first option use {@link
     * com.smartgwt.client.widgets.form.fields.ComboBoxItem#getDefaultToFirstOption defaultToFirstOption} instead.
     */
    public native void defaultDynamicValue() /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.defaultDynamicValue();
    }-*/;

	/**
     * Only applies to databound items (see  PickList.optionDataSource).<br> Performs a fetch type operation on this item's
     * DataSource to retrieve the set of valid options for the item, based on the current  PickList.pickListCriteria.
     */
    public native void fetchData() /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.fetchData();
    }-*/;

    /**
     * @see ComboBoxItem#fetchData
     */
    public void fetchData(DSCallback callback){
        fetchData(callback, null);
    }

	/**
     * Only applies to databound items (see  PickList.optionDataSource).<br> Performs a fetch type operation on this item's
     * DataSource to retrieve the set of valid options for the item, based on the current  PickList.pickListCriteria.
     * @param callback Callback to fire when the fetch completes. Callback will               fire with 4 parameters:<ul> 
     * <li><code>item</code> a pointer to the form item  <li><code>dsResponse</code> the {@link
     * com.smartgwt.client.data.DSResponse} returned by the server  <li><code>data</code> the raw data returned by the server 
     * <li><code>dsRequest</code> the {@link com.smartgwt.client.data.DSRequest} sent to the server  </ul>
     * @param requestProperties properties to apply to the              dsRequest for this fetch.
     */
    public native void fetchData(DSCallback callback, DSRequest requestProperties) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.fetchData(
			$entry( function(dsResponse, data, dsRequest) { 
				if(callback!=null) callback.@com.smartgwt.client.data.DSCallback::execute(Lcom/smartgwt/client/data/DSResponse;Ljava/lang/Object;Lcom/smartgwt/client/data/DSRequest;)(
					@com.smartgwt.client.data.DSResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsResponse), 
					data, 
					@com.smartgwt.client.data.DSRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsRequest)
				);
			}), requestProperties == null ? null : requestProperties.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;
	
	/**
     * Returns the data to display in the pick list. <P> The default implementation applies the criteria returned by  
     * PickList.getPickListFilterCriteria() to the data returned by  PickList.getClientPickListData().  A record passes the
     * filter if it has a matching value for all fields in the criteria object.  Matching is performed according to {@link
     * com.smartgwt.client.types.TextMatchStyle}. <P> If  PickList.showAllOptions is set, all values are shown, with matching
     * values shown below a  separator.
     *
     * @return array of record objects to display in the pickList
     */
    public native ListGridRecord[] filterClientPickListData() /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        if (!this.@com.smartgwt.client.widgets.form.fields.FormItem::isCreated()()) return null;
        var ret = self.filterClientPickListData();
        if(ret == null) return null;
        return @com.smartgwt.client.util.ConvertTo::arrayOfListGridRecord(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

	/**
     * Returns the set of data to be displayed in this item's PickList.
     *  <P>
     *  This method will be called for non-databound form items implementing the PickList
     *  interface.  The default implementation will derive data from the item's valueMap - 
     *  can be overridden to allow a custom set of options to be displayed.
     *  <P>
     *  Note that for PickLists that filter data based on user input
     *  ({@link com.smartgwt.client.widgets.form.fields.ComboBoxItem ComboBox}), this method should return the data <b>before
     *  filtering</b>.  To customize the data returned after filtering, override
     * {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem#filterClientPickListData filterClientPickListData()}
     * instead.
     *  <P>
     * As an example, for a formItem with {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem#getValueField valueField}
     * set to "valueFieldName", the
     *  default implementation would take a valueMap like the following:
     *  <pre>
     *      valueMap: { value1: "display 1", value2: "display 2" }
     *  </pre>
     *  .. and returning the following set of records: 
     *  <pre>
     *      [
     *           { valueFieldName : "value1" },
     *           { valueFieldName : "value2" }
     *      ]
     *  </pre>
     *  Due to the valueMap, these records will appear as a two row pickList displayed as
     *  "display 1" and "display 2".
     * 
     * 
     *
     * @return Array of record objects to be displayed in the           pickList. Note that when a user picks a record from the list,
     * the value of the           field matching <code>item.valueField</code> will be picked. Also note that the          
     * fields to be displayed can be customized via <code>item.pickListFields</code>
     */
    public native ListGridRecord[] getClientPickListData() /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        if (!this.@com.smartgwt.client.widgets.form.fields.FormItem::isCreated()()) return null;
        var ret = self.getClientPickListData();
        if(ret == null) return null;
        return @com.smartgwt.client.util.ConvertTo::arrayOfListGridRecord(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

	/**
     * Returns the <code>displayField</code> for this item. <P> Behavior varies based on the configuration of this item, as
     * follows: <ul><li>If this item has an {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem#getOptionDataSource
     * optionDataSource} and an explicit   {@link com.smartgwt.client.widgets.form.fields.FormItem#getForeignDisplayField
     * FormItem.foreignDisplayField} is specified, this will be returned.</li> <li>Otherwise if an explicit {@link
     * com.smartgwt.client.widgets.form.fields.ComboBoxItem#getDisplayField displayField} is specified it will be returned   by
     * default. If the <code>displayField</code> was specified on the underlying   dataSource field, and no matching field is
     * present in the {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem#getOptionDataSource optionDataSource} for 
     * the item, we avoid returning the specified displayField value and instead return the  title field of the option
     * DataSource. We do this to  avoid confusion for the case where the displayField is intended as a display-field  value for
     * showing another field value within the same record in the underlying  dataSource only.</li> <li>If no explicit
     * foreignDisplayField or displayField   specification was found, and the {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getValueField FormItem.valueField} for this item is hidden in the  
     * {@link com.smartgwt.client.widgets.form.fields.FormItem#getOptionDataSource FormItem.optionDataSource}, this method will
     * return the title field for   the <code>optionDataSource</code>.</li></ul>
     *
     * @return display field name, or null if there is no separate display field to                     use.
     * See {@link com.smartgwt.client.docs.FieldName FieldName}
     */
    public native String getDisplayFieldName() /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        if (!this.@com.smartgwt.client.widgets.form.fields.FormItem::isCreated()()) return null;
        var ret = self.getDisplayFieldName();
        return ret;
    }-*/;

	/**
     * Returns the raw text value that currently appears in the text field, which can differ from  {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getValue FormItem.getValue()} in various cases - for example: <ul>
     * <li>for items that constrain the value range, such as a {@link com.smartgwt.client.widgets.form.fields.DateItem} with
     * {@link com.smartgwt.client.widgets.form.fields.DateItem#getEnforceDate enforceDate}:true, or a {@link
     * com.smartgwt.client.widgets.form.fields.ComboBoxItem} with {@link
     * com.smartgwt.client.widgets.form.fields.ComboBoxItem#getAddUnknownValues addUnknownValues}:false</li> <li>for items with
     * a defined valueMap or edit value formatter and parser functions which converts display value to data value</li>
     * <li>while the item has focus if {@link com.smartgwt.client.widgets.form.fields.TextItem#getChangeOnKeypress
     * changeOnKeypress} is false </li></ul>
     *
     * @return current entered value
     */
    public native String getEnteredValue() /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        if (!this.@com.smartgwt.client.widgets.form.fields.FormItem::isCreated()()) return null;
        var ret = self.getEnteredValue();
        return ret;
    }-*/;

	/**
     * Getter method to retrieve the {@link com.smartgwt.client.widgets.form.fields.FormItem#getValueField FormItem.valueField}
     * for this item. For items with a specified {@link com.smartgwt.client.widgets.form.fields.FormItem#getOptionDataSource
     * FormItem.optionDataSource}, this determines which field in that dataSource corresponds to the value for this item. <P>
     * If unset, if a {@link com.smartgwt.client.data.DataSourceField#getForeignKey foreignKey relationship} exists between
     * this field and the optionDataSource, this will be used, otherwise default behavior will return the {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getName FormItem.name} of this field.
     *
     * @return fieldName to use a "value field" in records from this items               {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getOptionDataSource FormItem.optionDataSource}
     */
    public native String getValueFieldName() /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        if (!this.@com.smartgwt.client.widgets.form.fields.FormItem::isCreated()()) return null;
        var ret = self.getValueFieldName();
        return ret;
    }-*/;

	/**
     * Will this item return advancedCriteria if {@link com.smartgwt.client.widgets.form.DynamicForm#getValuesAsCriteria
     * DynamicForm.getValuesAsCriteria()} is  called on this item's form? Overridden for ComboBoxItem to return true if {@link
     * com.smartgwt.client.widgets.form.fields.ComboBoxItem#getGenerateExactMatchCriteria generateExactMatchCriteria} is true -
     * in this case if an exact value is chosen from our set of options (always the case if <code>addUnkownValues</code> is
     * false), we will use advancedCriteria to ensure the generated search criteria exactly matches the chosen value for this
     * item. <P> Note that {@link com.smartgwt.client.data.AdvancedCriteria} are not supported by all dataSources. When a form
     * is bound to a dataSource, we therefore default <code>generateExactMatchCriteria</code> to false unless the dataSource is
     * known to support AdvancedCriteria. <P> As with formItem.hasAdvancedCriteria() this will also return true if a {@link
     * com.smartgwt.client.data.Operator} was explicitly specified for this item
     *
     * @return true if the result of getCriterion() will be an AdvancedCriteria object.
     * @see com.smartgwt.client.docs.CriteriaEditing CriteriaEditing overview and related methods
     */
    public native Boolean hasAdvancedCriteria() /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        if (!this.@com.smartgwt.client.widgets.form.fields.FormItem::isCreated()()) return null;
        var ret = self.hasAdvancedCriteria();
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(ret);
    }-*/;

	/**
     * When a comboBoxItem is used to generate search criteria in a SearchForm,  if the user explicitly chose an option from
     * the pickList, should the criterion generated by  the <code>FormItemCriterionGetter</code>'s <code>getCriterion()</code>
     * method enforce a search for an exact match against the chosen value? <P> In order to achieve this, when this property is
     * set to true, this item will generate {@link com.smartgwt.client.data.AdvancedCriteria} in  the default
     * <code>FormItemCriterionGetter</code>'s <code>getCriterion()</code> method. <P> Default implementation will return {@link
     * com.smartgwt.client.widgets.form.fields.ComboBoxItem#getGenerateExactMatchCriteria generateExactMatchCriteria} if
     * specified, otherwise true if the DataSource for this item  {@link
     * com.smartgwt.client.data.DataSource#supportsAdvancedCriteria supports advanced criteria}, false if it does not.
     *
     * @return should getCriterion() generate exact-match search criteria when   a value was explicitly chosen from this item's set of
     * options?
     */
    public native Boolean shouldGenerateExactMatchCriteria() /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        if (!this.@com.smartgwt.client.widgets.form.fields.FormItem::isCreated()()) return null;
        var ret = self.shouldGenerateExactMatchCriteria();
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(ret);
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
     * @param comboBoxItemProperties properties that should be used as new defaults when instances of this class are created
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public static native void setDefaultProperties(ComboBoxItem comboBoxItemProperties) /*-{
        if (comboBoxItemProperties.@com.smartgwt.client.widgets.form.fields.FormItem::isCreated()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Class;)(ComboBoxItem.@java.lang.Object::getClass()(), "setDefaultProperties", comboBoxItemProperties.@java.lang.Object::getClass()());
        }
        comboBoxItemProperties.@com.smartgwt.client.widgets.form.fields.FormItem::setConfigOnly(Z)(true);
    	var properties = comboBoxItemProperties.@com.smartgwt.client.widgets.form.fields.FormItem::getConfig()();
        $wnd.isc.ComboBoxItem.addProperties(properties);
    }-*/;

    // ***********************************************************


    static {
        init();
    }

    private static native void init()/*-{
        // Make getPickListFilterCriteria an override point. We recommend using setPickListFilterCriteriaFunction instead
        // but support both.
        if ($wnd.isc.ComboBoxItem.getPrototype().__getPickListFilterCriteria == null) {
            $wnd.isc.ComboBoxItem.getPrototype().__getPickListFilterCriteria = $wnd.isc.ComboBoxItem.getPrototype().getPickListFilterCriteria;
            $wnd.isc.ComboBoxItem.getPrototype().getPickListFilterCriteria = $entry(function() {
                var jObj = this.__ref;
                //if widget was not created in in java via smartgwt, fallback to old behavior
                if(jObj && @com.smartgwt.client.widgets.form.fields.ComboBoxItem::isComboBoxItem(Lcom/smartgwt/client/widgets/form/fields/FormItem;)(jObj)) {
                    jObj.@com.smartgwt.client.widgets.form.fields.ComboBoxItem::setJsObj(Lcom/google/gwt/core/client/JavaScriptObject;)(this);
                    var critJ = jObj.@com.smartgwt.client.widgets.form.fields.ComboBoxItem::getPickListFilterCriteria()();
                    return critJ == null ? {} : critJ.@com.smartgwt.client.data.Criteria::getJsObj()();
                } else {
                    return this.__getPickListFilterCriteria();
                }
            });
        }
    }-*/;

    private static boolean isComboBoxItem(FormItem formItem) {
        return formItem instanceof ComboBoxItem;
    }

    /**
     * Returns filter criteria for options displayed for this item.
     * <P>
     * See {@link com.smartgwt.client.docs.ComboBoxFiltering} for details on how pickList filter criteria
     * are calculated by default for a comboBoxItem.
     * <P>
     * Note : this is an override point - if overridden this method will be called by the live form item during filtering.
     * However it is recommended that developers use
     * {@link #setPickListFilterCriteriaFunction(FormItemCriteriaFunction)} to build custom criteria instead of overriding this method directly. This ensures that
     * the custom filter criteria generating code will be called even if the form item was automatically generated based on a template
     * passed to {@link com.smartgwt.client.widgets.grid.ListGridField#setEditorType}.
     *
     * @return criteria to be used for databound or local filtering
     */
    protected native Criteria getPickListFilterCriteria() /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        var critJS = self.__getPickListFilterCriteria();
        return critJS == null ? null : @com.smartgwt.client.data.Criteria::new(Lcom/google/gwt/core/client/JavaScriptObject;)(critJS);
    }-*/;

    /**
     * Set the specialValues for this item.
     *
     * @param values the special values
     */
    public void setSpecialValues(String... values) {
        if (!isCreated()) {
            setAttribute("specialValues", values);
        }
    }

    /**
     * Set the specialValues for this item.
     *
     * @param valueMap the special value map
     */
    public void setSpecialValues(java.util.LinkedHashMap valueMap) {
        if (!isCreated()) {
        	java.util.LinkedHashMap newMap = new java.util.LinkedHashMap();
        	for (Object key : valueMap.keySet()) {
        		newMap.put(key.toString(), valueMap.get(key));
        	}

            setAttribute("specialValues", newMap);
        }
    }

    //------------------- From PickList -------

    /**
     * Maximum height to show the pick list before it starts to scroll. Note that by default the pickList will be sized
     * to the height required by its content so it will be taller when more rows are available as selectable options
     *
     * @param pickListHeight pickListHeight Default value is 300
     */
    public void setPickListHeight(int pickListHeight) {
        setAttribute("pickListHeight", pickListHeight);
    }

    /**
     * Maximum height to show the pick list before it starts to scroll. Note that by default the pickList will be sized
     * to the height required by its content so it will be taller when more rows are available as selectable options
     *
     * @return int
     */
    public int getPickListHeight() {
        return getAttributeAsInt("pickListHeight");
    }

    /**
     * Height for an empty pick list (showing the empty message), if the pick list has no records and {@link
     * com.smartgwt.client.widgets.form.fields.PickList#getHideEmptyPickList hideEmptyPickList} is <code>false</code>.
     *
     * @param emptyPickListHeight emptyPickListHeight Default value is 100
     */
    public void setEmptyPickListHeight(int emptyPickListHeight) {
        setAttribute("emptyPickListHeight", emptyPickListHeight);
    }

    /**
     * Height for an empty pick list (showing the empty message), if the pick list has no records and {@link
     * com.smartgwt.client.widgets.form.fields.PickList#getHideEmptyPickList hideEmptyPickList} is <code>false</code>.
     *
     * @return int
     */
    public int getEmptyPickListHeight() {
        return getAttributeAsInt("emptyPickListHeight");
    }

    /**
     * If this pickList contains no options, should it be hidden? If unset, default behavior is to allow the empty
     * pickList to show if it is databound.
     *
     * @param hideEmptyPickList hideEmptyPickList Default value is null
     */
    public void setHideEmptyPickList(Boolean hideEmptyPickList) {
        setAttribute("hideEmptyPickList", hideEmptyPickList);
    }

    /**
     * If this pickList contains no options, should it be hidden? If unset, default behavior is to allow the empty
     * pickList to show if it is databound.
     *
     * @return Boolean
     */
    public Boolean getHideEmptyPickList() {
        return getAttributeAsBoolean("hideEmptyPickList");
    }

    /**
     * Default width to show the pickList. If not specified, the width of this form item's element will be used
     * instead.
     *
     * @param pickListWidth pickListWidth Default value is null
     */
    public void setPickListWidth(Integer pickListWidth) {
        setAttribute("pickListWidth", pickListWidth);
    }

    /**
     * Default width to show the pickList. If not specified, the width of this form item's element will be used
     * instead.
     *
     * @return Integer
     */
    public Integer getPickListWidth() {
        return getAttributeAsInt("pickListWidth");
    }

    /**
     * Maximum width for this item's pickList. By default if the values displayed in this pickList are wider 
     * than the specified {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem#setPickListWidth setPickListWidth} 
     * the pickList will render wide enough to accomodate them. This property 
     * allows the developer to limit how wide the pickList will render.
     *
     * @param pickListMaxWidth pickListMaxWidth Default value is 400
     */
    public void setPickListMaxWidth(Integer pickListMaxWidth) {
        setAttribute("pickListMaxWidth", pickListMaxWidth);
    }

    /**
     * Maximum width for this item's pickList. By default if the values displayed in this pickList are wider 
     * than the specified {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem#setPickListWidth setPickListWidth} 
     * the pickList will render wide enough to accomodate them. This property 
     * allows the developer to limit how wide the pickList will render.
     *
     * @return Integer
     */
    public Integer getPickListMaxWidth() {
        return getAttributeAsInt("pickListMaxWidth");
    }

    /**
     * Base Style for pickList cells.  As with ListGrid Cells, will have 'over', 'selected' and 'disabled' appended on
     * changes of state for the cells.
     *
     * @param pickListBaseStyle pickListBaseStyle Default value is "pickListCell"
     */
    public void setPickListBaseStyle(String pickListBaseStyle) {
        setAttribute("pickListBaseStyle", pickListBaseStyle);
    }

    /**
     * Base Style for pickList cells.  As with ListGrid Cells, will have 'over', 'selected' and 'disabled' appended on
     * changes of state for the cells.
     *
     * @return String
     */
    public String getPickListBaseStyle() {
        return getAttributeAsString("pickListBaseStyle");
    }

    /**
     * If true, when the pickList is shown, it will be shown via an animated reveal effect <p><b>Note : </b> This is an
     * advanced setting</p>
     *
     * @param animatePickList animatePickList Default value is null
     */
    public void setAnimatePickList(Boolean animatePickList) {
        setAttribute("animatePickList", animatePickList);
    }

    /**
     * If true, when the pickList is shown, it will be shown via an animated reveal effect
     *
     * @return Boolean
     */
    public Boolean getAnimatePickList() {
        return getAttributeAsBoolean("animatePickList");
    }

    /**
     * If this.animatePickList is true - this specifies the duration of the animation effect applied when showing the
     * pickList <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param animationTime animationTime Default value is 200
     */
    public void setAnimationTime(int animationTime) {
        setAttribute("animationTime", animationTime);
    }

    /**
     * If this.animatePickList is true - this specifies the duration of the animation effect applied when showing the
     * pickList
     *
     * @return int
     */
    public int getAnimationTime() {
        return getAttributeAsInt("animationTime");
    }

    /**
     * If this pick list is showing multiple fields, this property determines the height of the column headers for those
     * fields. Set to zero to suppress the headers entirely.
     *
     * @param pickListHeaderHeight pickListHeaderHeight Default value is 22
     */
    public void setPickListHeaderHeight(int pickListHeaderHeight) {
        setAttribute("pickListHeaderHeight", pickListHeaderHeight);
    }

    /**
     * If this pick list is showing multiple fields, this property determines the height of the column headers for those
     * fields. Set to zero to suppress the headers entirely.
     *
     * @return int
     */
    public int getPickListHeaderHeight() {
        return getAttributeAsInt("pickListHeaderHeight");
    }

    /**
     * Cell Height for this item's pickList.
     *
     * @param pickListCellHeight pickListCellHeight Default value is 16
     */
    public void setPickListCellHeight(int pickListCellHeight) {
        setAttribute("pickListCellHeight", pickListCellHeight);
    }

    /**
     * Cell Height for this item's pickList.
     *
     * @return int
     */
    public int getPickListCellHeight() {
        return getAttributeAsInt("pickListCellHeight");
    }
    
    /**
     * For Databound formItems, this property determines which column  {@link com.smartgwt.client.widgets.form.fields.FormItem#getValueIcons
     * valueIcons} should show up in for this formItem's pickList.<br> If unset valueIcons show up in the {@link
     * com.smartgwt.client.widgets.form.fields.PickList#getDisplayField displayField} column if specified,  otherwise
     * the {@link com.smartgwt.client.widgets.form.fields.PickList#getValueField valueField} column.<br> In most cases
     * only the <code>displayField</code> or <code>valueField</code> will be visible. This property is typically only
     * required if custom {@link com.smartgwt.client.widgets.form.fields.PickList#getPickListFields pickListFields}
     * have been specfied for this item. <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param valueIconField valueIconField Default value is null
     */
    public void setValueIconField(String valueIconField) {
        setAttribute("valueIconField", valueIconField);
    }

    /**
     * For Databound formItems, this property determines which column  {@link com.smartgwt.client.widgets.form.fields.FormItem#getValueIcons
     * valueIcons} should show up in for this formItem's pickList.<br> If unset valueIcons show up in the {@link
     * com.smartgwt.client.widgets.form.fields.PickList#getDisplayField displayField} column if specified,  otherwise
     * the {@link com.smartgwt.client.widgets.form.fields.PickList#getValueField valueField} column.<br> In most cases
     * only the <code>displayField</code> or <code>valueField</code> will be visible. This property is typically only
     * required if custom {@link com.smartgwt.client.widgets.form.fields.PickList#getPickListFields pickListFields}
     * have been specfied for this item.
     *
     * @return String
     */
    public String getValueIconField() {
        return getAttributeAsString("valueIconField");
    }

    public void setPickListCriteria(DSRequest optionFilterContext) {
        setAttribute("optionFilterContext", optionFilterContext);
    }

    public void setFetchDelay(Integer fetchDelay) {
        setAttribute("fetchDelay", fetchDelay);
    }

    public Integer getFetchDelay() {
        return getAttributeAsInt("fetchDelay");
    }

    /**
     * If set, this FormItem will derive data to show in the PickList by fetching records from the specified
     * <code>optionDataSource</code>.  The fetched data will be used as a {@link com.smartgwt.client.widgets.form.fields.FormItem#getValueMap
     * valueMap} by extracting the {@link com.smartgwt.client.widgets.form.fields.FormItem#getValueField valueField} and
     * {@link com.smartgwt.client.widgets.form.fields.FormItem#getDisplayField displayField} in the loaded records, to
     * derive one valueMap entry per record loaded from the optionDataSource.  Multiple fields from the fetched data may
     * be shown in the pickList by setting {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem#getPickListFields
     * pickListFields}. <P> The data will be retrieved via a "fetch" operation on the DataSource, passing the  {@link
     * com.smartgwt.client.widgets.form.fields.PickList#getPickListCriteria pickListCriteria} (if set) as criteria, and passing {@link
     * com.smartgwt.client.widgets.form.fields.ComboBoxItem#getOptionFilterContext optionFilterContext} (if set) as
     * DSRequest properties. <P> The fetch will be triggered when the pickList is first shown, or, you can set {@link
     * com.smartgwt.client.widgets.form.fields.SelectItem#getAutoFetchData autoFetchData} to fetch when the FormItem is
     * first drawn.  You can also call {@link com.smartgwt.client.widgets.form.fields.PickList#fetchData} at any time to manually  trigger
     * a fetch. <P> Data paging is automatically enabled if the optionDataSource supports it.  As the pickList is
     * scrolled by the user, requests for additional data will be automatically issued. <P> For a pickList attached to a
     * ComboBoxItem, new fetches are issued as the user types, with criteria set as described under {@link
     * com.smartgwt.client.widgets.form.fields.ComboBoxItem#getPickListFilterCriteria}. If your dataSource is not
     * capable of filtering results by search criteria (eg the dataSource is backed by an XML flat file), you can set
     * {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem#getFilterLocally filterLocally} to have the entire
     * dataset loaded up front and filtering performed in the browser.  This disables data paging. <P> Setting
     * optionDataSource also enables the basic {@link com.smartgwt.client.widgets.form.fields.FormItem#getOptionDataSource
     * optionDataSource} behaviors, eg, fetching individual display values before the pickList is shown. <P> Note that
     * if a normal, static {@link com.smartgwt.client.widgets.form.fields.FormItem#getValueMap valueMap} is <b>also</b>
     * specified for the field (either directly in the form item or as part of the field definition in the dataSource),
     * it will be preferred to the data derived from the optionDataSource for whatever mappings are present. <p><b>Note
     * : </b> This is an advanced setting</p>
     *
     * @param dataSource optionDataSource Default value is null
     * @return {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem ComboBoxItem}
     * instance, for chaining setter calls
     */
    public ComboBoxItem setOptionDataSource(DataSource dataSource) {
        return (ComboBoxItem)setAttribute("optionDataSource", dataSource);
    }

    public DataSource getOptionDataSource() {
        return DataSource.getOrCreateRef(getAttributeAsJavaScriptObject("optionDataSource"));
    }

    /**
     * Returns the entire record object associated with the current value for this item (or null if no matching record exists
     * in the PickList data). Most commonly used for databound pickListItems to retrieve the values of other fields in the record.
     *
     * @return the selected record or null
     */
    public native ListGridRecord getSelectedRecord() /*-{
	    var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
	    var ret = self.getSelectedRecord();
	    if(ret == null) return null;
	    var retVal = @com.smartgwt.client.core.RefDataClass::getRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
	    if(retVal == null) {
	        retVal = @com.smartgwt.client.widgets.grid.ListGridRecord::new(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
	    }
	    return retVal;
	}-*/;

    /**
     * Set the pick list filter criteria function / handler.
     *
     * @param filterCriteriaFunction the filter criteria function
     * @deprecated in favor of {@link #setPickListFilterCriteriaFunction(FormItemCriteriaFunction)}
     */
    public native void setPickListFilterCriteriaFunction(FilterCriteriaFunction filterCriteriaFunction) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.getPickListFilterCriteria = $entry(function() {
            var crit = filterCriteriaFunction.@com.smartgwt.client.widgets.form.fields.FilterCriteriaFunction::getCriteria()();
            return crit == null ? null : crit.@com.smartgwt.client.data.Criteria::getJsObj()();
        });
    }-*/;

    /**
     * Set up a method to return filter criteria for options displayed for this item.
     * <P>
     * See {@link com.smartgwt.client.docs.ComboBoxFiltering} for details on how pickListCriteria are
     * calcualted by default for a ComboBoxItem.
     */
    public native void setPickListFilterCriteriaFunction(FormItemCriteriaFunction filterCriteriaFunction) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.getPickListFilterCriteria = $entry(function() {
            var context = @com.smartgwt.client.widgets.form.fields.FormItemFunctionContext::new()();
            var itemJ = @com.smartgwt.client.widgets.form.fields.ComboBoxItem::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(this);
            context.@com.smartgwt.client.widgets.form.fields.FormItemFunctionContext::setFormItem(Lcom/smartgwt/client/widgets/form/fields/FormItem;)(itemJ);
            var crit = filterCriteriaFunction.@com.smartgwt.client.widgets.form.fields.FormItemCriteriaFunction::getCriteria(Lcom/smartgwt/client/widgets/form/fields/FormItemFunctionContext;)(context);
            return crit == null ? null : crit.@com.smartgwt.client.data.Criteria::getJsObj()();
        });
    }-*/;


    /**
     * Allows developers to designate a {@link com.smartgwt.client.widgets.form.PickListMenu} 
     * as a template containing arbitrary properties to apply to the pickList that will be
     * created for this FormItem.
     * <P>
     * <i>Note</i>: Not every PickListMenu / ListGrid property is supported when assigned to a pickList.
     * Where there is a dedicated API on the form item (such as
     * {@link com.smartgwt.client.widgets.form.fields.PickList#setPickListCellHeight}), we recommend
     * that be used in favor of setting the equivalent property directly using this API.
     * <P>
     * <i>PickLists and {@link com.smartgwt.client.widgets.grid.ListGrid#setShowFilterEditor}:</i>
     * {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem ComboBoxItems} do not support 
     * setting <code>showFilterEditor</code> to true on pickListProperties. 
     * This combination of settings leads to an ambiguous user experience as the two sets of
     * filter-criteria (those from the text-box and those from the pickList filter editor) interact 
     * with each other.<br>
     * Calling {@link com.smartgwt.client.widgets.grids.ListGrid#setShowFilterEditor setShowFilterEditor}
     * on the PickListMenu passed to {@link com.smartgwt.client.widgets.form.fields.SelectItem#setPickListProperties}
     * is a valid way to create a filterable pickList, on a SelectItem, but this setting is not 
     * supported on a SelectItem with {@link com.smartgwt.client.widgets.form.fields.SelectItem#setMultiple multiple set to true}
     * - this combination of settings can cause a selected value to be filtered out of view at which
     * point further selection changes will discard that value.<br>
     * In general we recommend the ComboBoxItem class (with 
     * {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem#setAddUnknownValues addUnknownValues set as appropriate})
     * as a better interface for filtering pickList data.
     * 
     * @param pickListProperties the pick list properties
     */
    public void setPickListProperties(ListGrid pickListProperties) {
        if (pickListProperties.isCreated()) {
            ConfigUtil.warnOfPreConfigInstantiation(this.getClass(), "setPickListProperties", "ListGrid");
        }                                                                       
        pickListProperties.setConfigOnly(true);

        JavaScriptObject configJS = pickListProperties.getConfig();
        if (configJS != null) {
            configJS = JSOHelper.cleanProperties(configJS, true);
            JSOHelper.deleteAttribute(configJS, "alternateRecordStyles");
        }
        setAttribute("pickListProperties", configJS);
    }

    public void setOptionFilterContext(DSRequest dsRequestProperties) {
        setAttribute("optionFilterContext", dsRequestProperties);
    }

    /**
     * Return the value tracked by this form item.
     *
     * @return value of this element
     */
    public native String getValueAsString() /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        var ret;
        if(self.setValue) {
             ret = self.getValue();
        } else {
            ret = self.value;
        }
        return ret == null ? null : ret.toString();
    }-*/;

    /**
     * The default <code>canEditCriterion()</code> predicate is overridden in comboBoxItem. When addUnknownValues is true,
     * comboBoxItems allow the user to edit substring match type criteria applied to the display field (if one is specified).
     * <P> The user can also edit criteria attempting to match exactly against the item's field name.
     * @param predicate the predicate to determine the form items that can edit the criterion in question
     * @see com.smartgwt.client.widgets.form.fields.FormItem#setCanEditCriterionPredicate FormItem.setCanEditCriterionPredicate
     * @see com.smartgwt.client.docs.CriteriaEditing CriteriaEditing overview and related methods
     */
    public void setCanEditCriterionPredicate(FormItemCanEditCriterionPredicate predicate) {
        super.setCanEditCriterionPredicate(predicate);
    }

    /**
     * The default <code>getCriterion()</code> implementation returns criterion derived from the current value of this item.
     * <P> If {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem#getAddUnknownValues addUnknownValues} is true for
     * this item, we implement the following behavior.<br> If the user explicitly selected an item from the pickList, we treat
     * this as an attempt to explicitly match the data value. In this case returned criteria will match the selected (data) value
     * against this item's fieldName.<br> If the user typed a value into the text field, we treat this as an attempt to do a substring
     * type filter. In this case returned criteria will match the entered text value against the displayField for this item if
     * one is specified. <P> If {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem#getAddUnknownValues
     * addUnknownValues} is false we always match the chosen data value against the item's  fieldName. <P> Note that {@link
     * com.smartgwt.client.widgets.form.fields.ComboBoxItem#shouldGenerateExactMatchCriteria
     * ComboBoxItem.shouldGenerateExactMatchCriteria} will be called in the case when a value was explicitly picked from the
     * set of options. If that method returns true, we will return AdvancedCriteria with an operator specified to ensure an
     * exact match occurs.
     * @param getter provides a method to get a criterion object based on this field's current edited value(s).
     *
     * @see com.smartgwt.client.widgets.form.fields.FormItem#setCriterionGetter
     * @see com.smartgwt.client.docs.CriteriaEditing CriteriaEditing overview and related methods
     */
    public void setCriterionGetter(FormItemCriterionGetter getter) {
        super.setCriterionGetter(getter);
    }

    /**
     * The default <code>setCriterion()</code> implementation is overridden to support editing criterion against the display field
     * or value field when {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem#getAddUnknownValues addUnknownValues} is true.
     * @param setter provides a method to update this field with the edited criterion
     */
    public void setCriterionSetter(FormItemCriterionSetter setter) {
        super.setCriterionSetter(setter);
    }

   /**
     * This method sorts the pickList on one or more fields, creating the underlying JS object
     * if needed. Pass in an array of SortSpecifiers to have the grid's data sorted by the fields in each
     * specifier.property and in the directions specified.  The grid can be sorted by any combination
     * of fields, including fields specified in the fields array, whether visible or hidden, and
     * {@link com.smartgwt.client.data.DataSource#getFields 'unused fields from the underlying dataSource'},
     * if there is one.  If multiple fields are sorted, those that are visible show a directional icon and a small
     * {@link com.smartgwt.client.widgets.grid.ListGrid#getSortNumeralStyle 'sort-numeral'} indicating that
     * field's index in the sort configuration.
     * <P>
     * See {@link com.smartgwt.client.widgets.grid.ListGrid#addSort}
     * and {@link com.smartgwt.client.widgets.grid.ListGrid#alterSort}
     * APIs for information on making changes to the current sort configuration.
     * @param sortSpecifiers Array of SortSpecifier objects
     */
    public native void setPickListSort(SortSpecifier[] sortSpecifiers) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()(),
            specifiers = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(sortSpecifiers);
        if (self != null && self.pickList != null) self.pickList.setSort(specifiers);
        else {
            // stick the sort-spec in a "preDrawConfig" block, so it can be applied later without
            // being clobbered by a direct call to setPickListProperties()
            var configJS = this.@com.smartgwt.client.core.DataClass::getAttributeAsJavaScriptObject(Ljava/lang/String;)("preDrawConfig");
            if (configJS == null) {
                configJS = {};
            }
            configJS.initialSort = specifiers;
            this.@com.smartgwt.client.core.DataClass::setAttribute(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)("preDrawConfig", configJS);
        }
    }-*/;

    /**
     * Sorts the pickList on one or more fields.
     *
     * @param sortSpecifiers Array of SortSpecifier objects
     * @deprecated in favor of {@link #setPickListSort(SortSpecifier[])} where
     * full documentation can be read.
     */
    public void setSort(SortSpecifier[] sortSpecifiers) {
        setPickListSort(sortSpecifiers);
    }

}
