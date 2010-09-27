/*
 * Smart GWT (GWT for SmartClient)
 * Copyright 2008 and beyond, Isomorphic Software, Inc.
 *
 * Smart GWT is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License version 3
 * is published by the Free Software Foundation.  Smart GWT is also
 * available under typical commercial license terms - see
 * http://smartclient.com/license
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 */

package com.smartgwt.client.widgets.form;

import com.google.gwt.core.client.JavaScriptObject;
import com.smartgwt.client.core.DataClass;
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.form.fields.FormItemFactory;

/**
 * A class containing details for mouse events occurring over a FormItem.
 *
 * @see com.smartgwt.client.widgets.form.DynamicForm#getEventItemInfo(String)
 */
public class FormItemEventInfo extends DataClass {

    public FormItemEventInfo(JavaScriptObject jsObj) {
        super(jsObj);
    }

    /**
     * Item over which the event occurred.
     *
     * @return item over which the event occurred.
     */
    public FormItem getItem() {
        JavaScriptObject jso = getAttributeAsJavaScriptObject("item");
        return FormItemFactory.getFormItem(jso);
    }

    /**
     * True if the event occurred over the main body of the item (for example the text-box), rather
     * than over the title or within the form item's cell in the DynamicForm but outside the text box area.
     *
     * @return true if the event occurred over the main body of the item
     */
    public Boolean isOverItem() {
        return getAttributeAsBoolean("overItem");
    }

    /**
     * True if the event occurred over the items title.
     *
     * @return true if the event occurred over the items title.
     */
    public Boolean isOverTitle() {
        return getAttributeAsBoolean("overItem");
    }

    /**
     * If this event occurred over a formItemIcon this attribute contains the
     * {@link com.smartgwt.client.widgets.form.fields.FormItemIcon#setName(String) name} of the icon.
     *
     * @return the form item icon name
     */
    public String getIcon() {
        return getAttribute("icon");
    }
}
