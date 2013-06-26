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
import com.smartgwt.client.callbacks.*;
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

    public void setJavaScriptObject(JavaScriptObject jsObj) {
        this.jsObj = jsObj;
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
        $wnd.isc["SelectOtherItem"].changeDefaults(autoChildName + "Defaults", defaults.@com.smartgwt.client.widgets.Canvas::getConfig()());
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
        $wnd.isc["SelectOtherItem"].changeDefaults(autoChildName + "Defaults", defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getJsObj()());
    }-*/;

    public SelectOtherItem(){
        setAttribute("editorType", "SelectOtherItem");
    }

    public SelectOtherItem(JavaScriptObject jsObj){
        
        setJavaScriptObject(jsObj);
        
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
     * @param dialogWidth dialogWidth Default value is 250
     */
    public void setDialogWidth(int dialogWidth) {
        setAttribute("dialogWidth", dialogWidth);
    }

    /**
     * Width for the "other value" prompt dialog.
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
     * @param otherTitle . See {@link com.smartgwt.client.docs.String String}. Default value is "Other..."
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setOtherTitle(String otherTitle) {
        setAttribute("otherTitle", otherTitle);
    }

    /**
     * Title for the <code>Other...</code> item. When this item is selected, the user will be  shown a prompt allowing them to
     * enter a new value for the item.
     *
     * @return . See {@link com.smartgwt.client.docs.String String}
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
     * @param otherValue . See {@link com.smartgwt.client.docs.String String}. Default value is "***other***"
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setOtherValue(String otherValue) {
        setAttribute("otherValue", otherValue);
    }

    /**
     * Data value for the <code>Other...</code> item. If necessary this value may be changed to ensure it doesn't collide with
     * any data values in this item's {@link com.smartgwt.client.widgets.form.fields.FormItem#getValueMap valueMap}.
     *
     * @return . See {@link com.smartgwt.client.docs.String String}
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
     * @param selectOtherPrompt . See {@link com.smartgwt.client.docs.String String}. Default value is "Other value for <br>${item.getTitle()}?"
     */
    public void setSelectOtherPrompt(String selectOtherPrompt) {
        setAttribute("selectOtherPrompt", selectOtherPrompt);
    }

    /**
     * Title to show in prompt for "other" value. Note this is a dynamic string. JavaScript content is supported within
     * <code>\${...}</code> tags, with local variables for <code>item</code> (a pointer to this item) and  <code>value</code> a
     * pointer to the currently selected item value.
     *
     * @return . See {@link com.smartgwt.client.docs.String String}
     */
    public String getSelectOtherPrompt()  {
        return getAttributeAsString("selectOtherPrompt");
    }


    /**
     * Title for the separator between normal items and the <code>Other...</code> item in the drop down list.  Selecting this
     * item will not change the FormItem's value.
     *
     * @param separatorTitle . See {@link com.smartgwt.client.docs.String String}. Default value is "--------------------"
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setSeparatorTitle(String separatorTitle) {
        setAttribute("separatorTitle", separatorTitle);
    }

    /**
     * Title for the separator between normal items and the <code>Other...</code> item in the drop down list.  Selecting this
     * item will not change the FormItem's value.
     *
     * @return . See {@link com.smartgwt.client.docs.String String}
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
     * @param separatorValue . See {@link com.smartgwt.client.docs.String String}. Default value is "----"
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
     * @return . See {@link com.smartgwt.client.docs.String String}
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getSeparatorValue()  {
        return getAttributeAsString("separatorValue");
    }

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************
    /**
     * Class level method to set the default properties of this class. If set, then all subsequent instances of this
     * class will automatically have the default properties that were set when this method was called. This is a powerful
     * feature that eliminates the need for users to create a separate hierarchy of subclasses that only alter the default
     * properties of this class. Can also be used for skinning / styling purposes.
     * <P>
     * <b>Note:</b> This method is intended for setting default attributes only and will effect all instances of the
     * underlying class (including those automatically generated in JavaScript).
     * This method should not be used to apply standard EventHandlers or override methods for
     * a class - use a custom subclass instead.
     *
     * @param selectOtherItemProperties properties that should be used as new defaults when instances of this class are created
     */
    public static native void setDefaultProperties(SelectOtherItem selectOtherItemProperties) /*-{
    	var properties = $wnd.isc.addProperties({},selectOtherItemProperties.@com.smartgwt.client.core.RefDataClass::getJsObj()());
    	delete properties.ID;
        $wnd.isc.SelectOtherItem.addProperties(properties);
    }-*/;

    // ***********************************************************

}



