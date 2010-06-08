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
        setType("color");
    }

    public ColorPickerItem(JavaScriptObject jsObj) {
        super(jsObj);
    }

    public ColorPickerItem(String name) {
        setName(name);
        setType("color");
    }

    public ColorPickerItem(String name, String title) {
        setName(name);
		setTitle(title);
        setType("color");
    }




}
