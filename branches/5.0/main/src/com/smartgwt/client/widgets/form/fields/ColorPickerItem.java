/*
 * SmartGWT (GWT for SmartClient)
 * Copyright 2008 and beyond, Isomorphic Software, Inc.
 *
 * SmartGWT is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License version 3
 * as published by the Free Software Foundation.  SmartGWT is also
 * available under typical commercial license terms - see
 * http://smartclient.com/license
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 */

package com.smartgwt.client.widgets.form.fields;

import com.smartgwt.client.core.*;

import com.google.gwt.core.client.JavaScriptObject;


/**
 * The ColorPicker widget allows the user to select a color from anywhere in the color spectrum.
 */
public class ColorPickerItem extends FormItem {

    public static ColorPickerItem getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        RefDataClass obj = RefDataClass.getRef(jsObj);
        if(obj != null) {
            obj.setJsObj(jsObj);
            return (ColorPickerItem) obj;
        } else {
            return new ColorPickerItem(jsObj);
        }
    }

    public ColorPickerItem() {
        setAttribute("editorType", "ColorItem");
    }

    public ColorPickerItem(JavaScriptObject jsObj) {
        super(jsObj);
    }

    public ColorPickerItem(String name) {
        setName(name);
        setAttribute("editorType", "ColorItem");
    }

    public ColorPickerItem(String name, String title) {
        setName(name);
		setTitle(title);
        setAttribute("editorType", "ColorItem");
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
        return ret == null || ret === undefined ? null : ret.toString();
    }-*/;
}
