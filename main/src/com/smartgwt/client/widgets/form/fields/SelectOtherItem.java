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

/**
 * FormItem that shows a list of options, plus an "Other..." option that allows them to enter another value. <p> Note -
 * SelectOtherItem does not support using an {@link com.smartgwt.client.widgets.form.fields.SelectItem#getOptionDataSource
 * optionDataSource}, instead, use a normal {@link com.smartgwt.client.widgets.form.fields.SelectItem} and use the {@link
 * com.smartgwt.client.widgets.form.fields.SelectItem#getSpecialValues specialValues}  to implement a way to add new
 * DataSource records to the {@link com.smartgwt.client.widgets.form.fields.SelectItem#getOptionDataSource
 * optionDataSource}. This creates a UI more appropriate to {@link
 * com.smartgwt.client.widgets.form.fields.SelectItem#getOptionDataSource optionDataSource}:  the {@link
 * com.smartgwt.client.widgets.form.fields.SelectOtherItem#getOtherValue otherValue} option or options  can be placed at
 * the top of the list, so that scrolling to the bottom of a long list is not required. In addition, the {@link
 * com.smartgwt.client.widgets.form.fields.SelectItem#getSpecialValues specialValues} system allows you  to open a custom
 * form or other UI for adding new DataSource records, rather than just  the simple single-value input dialog of
 * SelectOtherItem.
 */
@BeanFactory.FrameworkClass
public class SelectOtherItem extends SelectItem {

    public static SelectOtherItem getOrCreateRef(JavaScriptObject jsObj) {
        if (jsObj == null) return null;

        final RefDataClass existingObj = RefDataClass.getRef(jsObj);

        if (existingObj instanceof SelectOtherItem) {
            existingObj.setJsObj(jsObj);
            return (SelectOtherItem)existingObj;
        } else

        {
            return new SelectOtherItem(jsObj);
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(SelectOtherItem.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "Canvas");
        }
        defaults.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
        var cleanDefaultsJS = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(defaults.@com.smartgwt.client.widgets.BaseWidget::getConfig()(), true);
        $wnd.isc.SelectOtherItem.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(SelectOtherItem.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "FormItem");
        }
        defaults.@com.smartgwt.client.widgets.form.fields.FormItem::setConfigOnly(Z)(true);
    	var cleanDefaultsJS = defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getEditorTypeConfig()();
        $wnd.isc.SelectOtherItem.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
    }-*/;

    public static native void changePickerIconDefaults(FormItemIcon defaults) /*-{
        $wnd.isc.SelectOtherItem.changeDefaults("pickerIconDefaults", defaults.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;

    public SelectOtherItem(){
        setAttribute("editorType", "SelectOtherItem");
    }

    public SelectOtherItem(JavaScriptObject jsObj){
        super(jsObj);
    }


    public SelectOtherItem(String name) {
        setName(name);
                setAttribute("editorType", "SelectOtherItem");
    }


    public SelectOtherItem(String name, String title) {
        setName(name);
		setTitle(title);
                setAttribute("editorType", "SelectOtherItem");
    }


    // ********************* Properties / Attributes ***********************

    /**
     * Width for the "other value" prompt dialog.
     *
     * @param dialogWidth New dialogWidth value. Default value is 250
     */
    public void setDialogWidth(int dialogWidth) {
        setAttribute("dialogWidth", dialogWidth);
    }

    /**
     * Width for the "other value" prompt dialog.
     *
     * @return Current dialogWidth value. Default value is 250
     */
    public int getDialogWidth()  {
        return getAttributeAsInt("dialogWidth");
    }
    

    /**
     * Title for the <code>Other...</code> item. When this item is selected, the user will be  shown a prompt allowing them to
     * enter a new value for the item.
     *
     * @param otherTitle New otherTitle value. Default value is "Other..."
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setOtherTitle(String otherTitle) {
        setAttribute("otherTitle", otherTitle);
    }

    /**
     * Title for the <code>Other...</code> item. When this item is selected, the user will be  shown a prompt allowing them to
     * enter a new value for the item.
     *
     * @return Current otherTitle value. Default value is "Other..."
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getOtherTitle()  {
        return getAttributeAsString("otherTitle");
    }
    

    /**
     * Data value for the <code>Other...</code> item. If necessary this value may be changed to ensure it doesn't collide with
     * any data values in this item's {@link com.smartgwt.client.widgets.form.fields.FormItem#getValueMap valueMap}.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param otherValue New otherValue value. Default value is "***other***"
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setOtherValue(String otherValue) {
        setAttribute("otherValue", otherValue);
    }

    /**
     * Data value for the <code>Other...</code> item. If necessary this value may be changed to ensure it doesn't collide with
     * any data values in this item's {@link com.smartgwt.client.widgets.form.fields.FormItem#getValueMap valueMap}.
     *
     * @return Current otherValue value. Default value is "***other***"
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getOtherValue()  {
        return getAttributeAsString("otherValue");
    }
    

    /**
     * Title to show in prompt for "other" value. Note this is a dynamic string. JavaScript content is supported within
     * <code>&#36;{...}</code> tags, with local variables for <code>item</code> (a pointer to this item) and 
     * <code>value</code> a pointer to the currently selected item value.
     *
     * @param selectOtherPrompt New selectOtherPrompt value. Default value is "Other value for &lt;br&gt;${item.getTitle()}?"
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public void setSelectOtherPrompt(String selectOtherPrompt) {
        setAttribute("selectOtherPrompt", selectOtherPrompt);
    }

    /**
     * Title to show in prompt for "other" value. Note this is a dynamic string. JavaScript content is supported within
     * <code>&#36;{...}</code> tags, with local variables for <code>item</code> (a pointer to this item) and 
     * <code>value</code> a pointer to the currently selected item value.
     *
     * @return Current selectOtherPrompt value. Default value is "Other value for &lt;br&gt;${item.getTitle()}?"
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public String getSelectOtherPrompt()  {
        return getAttributeAsString("selectOtherPrompt");
    }
    

    /**
     * Title for the separator between normal items and the <code>Other...</code> item in the drop down list.  Selecting this
     * item will not change the FormItem's value.
     *
     * @param separatorTitle New separatorTitle value. Default value is "--------------------"
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setSeparatorTitle(String separatorTitle) {
        setAttribute("separatorTitle", separatorTitle);
    }

    /**
     * Title for the separator between normal items and the <code>Other...</code> item in the drop down list.  Selecting this
     * item will not change the FormItem's value.
     *
     * @return Current separatorTitle value. Default value is "--------------------"
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getSeparatorTitle()  {
        return getAttributeAsString("separatorTitle");
    }
    

    /**
     * Value for the separator item between normal items and the <code>Other...</code> value.  If necessary the value may be
     * changed to ensure it doesn't collide with any data values in this item's {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getValueMap valueMap}.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param separatorValue New separatorValue value. Default value is "----"
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setSeparatorValue(String separatorValue) {
        setAttribute("separatorValue", separatorValue);
    }

    /**
     * Value for the separator item between normal items and the <code>Other...</code> value.  If necessary the value may be
     * changed to ensure it doesn't collide with any data values in this item's {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getValueMap valueMap}.
     *
     * @return Current separatorValue value. Default value is "----"
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getSeparatorValue()  {
        return getAttributeAsString("separatorValue");
    }
    

    // ********************* Methods ***********************

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
     * @param selectOtherItemProperties properties that should be used as new defaults when instances of this class are created
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public static native void setDefaultProperties(SelectOtherItem selectOtherItemProperties) /*-{
        if (selectOtherItemProperties.@com.smartgwt.client.widgets.form.fields.FormItem::isCreated()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Class;)(SelectOtherItem.@java.lang.Object::getClass()(), "setDefaultProperties", selectOtherItemProperties.@java.lang.Object::getClass()());
        }
        selectOtherItemProperties.@com.smartgwt.client.widgets.form.fields.FormItem::setConfigOnly(Z)(true);
    	var properties = selectOtherItemProperties.@com.smartgwt.client.widgets.form.fields.FormItem::getConfig()();
        $wnd.isc.SelectOtherItem.addProperties(properties);
    }-*/;

    // ***********************************************************

}
