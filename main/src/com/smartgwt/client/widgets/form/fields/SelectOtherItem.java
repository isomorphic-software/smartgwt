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
import com.smartgwt.client.widgets.layout.*;
import com.smartgwt.client.widgets.menu.*;
import com.smartgwt.client.widgets.tab.*;
import com.smartgwt.client.widgets.toolbar.*;
import com.smartgwt.client.widgets.tree.*;
import com.smartgwt.client.widgets.tree.events.*;
import com.smartgwt.client.widgets.viewer.*;
import com.smartgwt.client.widgets.calendar.*;
import com.smartgwt.client.widgets.calendar.events.*;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;
import com.smartgwt.client.util.*;
import com.google.gwt.event.shared.*;
import com.google.gwt.event.shared.HasHandlers;

/**
 * FormItem that shows a list of options, plus an "Other..." option that allows them to enter another value.
 */
public class SelectOtherItem extends SelectItem {

    public static SelectOtherItem getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        RefDataClass obj = RefDataClass.getRef(jsObj);
        if(obj != null) {
            obj.setJsObj(jsObj);
            return (SelectOtherItem) obj;
        } else {
            return new SelectOtherItem(jsObj);
        }
    }

    public SelectOtherItem(){
        setType("selectOther");
    }

    public SelectOtherItem(JavaScriptObject jsObj){
        super(jsObj);
    }

    public SelectOtherItem(String name) {
        setName(name);
        setType("selectOther");
    }

    public SelectOtherItem(String name, String title) {
        setName(name);
		setTitle(title);
        setType("selectOther");
    }

    // ********************* Properties / Attributes ***********************

    /**
     * Width for the "other value" prompt dialog.
     *
     * @param dialogWidth dialogWidth Default value is 250
     */
    public void setDialogWidth(int dialogWidth) {
        setAttribute("dialogWidth", dialogWidth);
    }

    /**
     * Width for the "other value" prompt dialog.
     *
     *
     * @return int
     */
    public int getDialogWidth()  {
        return getAttributeAsInt("dialogWidth");
    }

    /**
     * Title for the <code>Other...</code> item. When this item is selected, the user will be  shown a prompt allowing them to
     * enter a new value for the item.
     *
     * @param otherTitle otherTitle Default value is "Other..."
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setOtherTitle(String otherTitle) {
        setAttribute("otherTitle", otherTitle);
    }

    /**
     * Title for the <code>Other...</code> item. When this item is selected, the user will be  shown a prompt allowing them to
     * enter a new value for the item.
     *
     *
     * @return String
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
     * @param otherValue otherValue Default value is "***other***"
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setOtherValue(String otherValue) {
        setAttribute("otherValue", otherValue);
    }

    /**
     * Data value for the <code>Other...</code> item. If necessary this value may be changed to ensure it doesn't collide with
     * any data values in this item's {@link com.smartgwt.client.widgets.form.fields.FormItem#getValueMap valueMap}.
     *
     *
     * @return String
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getOtherValue()  {
        return getAttributeAsString("otherValue");
    }

    /**
     * Title to show in prompt for "other" value. Note this is a dynamic string. JavaScript content is supported within
     * <code>\${...}</code> tags, with local variables for <code>item</code> (a pointer to this item) and  <code>value</code> a
     * pointer to the currently selected item value.
     *
     * @param selectOtherPrompt selectOtherPrompt Default value is "Other value for <br>${item.getTitle()}?"
     */
    public void setSelectOtherPrompt(String selectOtherPrompt) {
        setAttribute("selectOtherPrompt", selectOtherPrompt);
    }

    /**
     * Title to show in prompt for "other" value. Note this is a dynamic string. JavaScript content is supported within
     * <code>\${...}</code> tags, with local variables for <code>item</code> (a pointer to this item) and  <code>value</code> a
     * pointer to the currently selected item value.
     *
     *
     * @return String
     */
    public String getSelectOtherPrompt()  {
        return getAttributeAsString("selectOtherPrompt");
    }

    /**
     * Title for the separator between normal items and the <code>Other...</code> item in the drop down list.  Selecting this
     * item will not change the FormItem's value.
     *
     * @param separatorTitle separatorTitle Default value is "--------------------"
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setSeparatorTitle(String separatorTitle) {
        setAttribute("separatorTitle", separatorTitle);
    }

    /**
     * Title for the separator between normal items and the <code>Other...</code> item in the drop down list.  Selecting this
     * item will not change the FormItem's value.
     *
     *
     * @return String
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
     * @param separatorValue separatorValue Default value is "----"
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
     *
     * @return String
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getSeparatorValue()  {
        return getAttributeAsString("separatorValue");
    }

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************

}



