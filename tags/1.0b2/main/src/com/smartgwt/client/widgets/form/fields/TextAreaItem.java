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
import com.smartgwt.client.util.JSOHelper;
import com.smartgwt.client.util.EnumUtil;
import com.google.gwt.event.shared.*;
import com.google.gwt.event.shared.HasHandlers;
   /**
    * Class for editable multi-line text areas (uses HTML <code>&lt;TEXTAREA&gt;</code> object)

    */
public class TextAreaItem extends FormItem {

    public static TextAreaItem getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        RefDataClass obj = RefDataClass.getRef(jsObj);
        if(obj != null) {
            obj.setJsObj(jsObj);
            return (TextAreaItem) obj;
        } else {
            return new TextAreaItem(jsObj);
        }
    }


    public TextAreaItem(){
        setType("TextAreaItem");
    }

    public TextAreaItem(JavaScriptObject jsObj){
        super(jsObj);
    }

    public TextAreaItem(String name) {
        setName(name);
        setType("TextAreaItem");
    }

    // ********************* Properties / Attributes ***********************

    /**
    * default width of this item
    *
    * @param width width Default value is 150
    */
    public void setWidth(int width) {
        setAttribute("width", width);
    }
    /**
     * default width of this item
     *
     *
     * @return int
     *
     */
    public int getWidth()  {
        return getAttributeAsInt("width");
    }

    /**
    * default height of this item
    *
    * @param height height Default value is 100
    */
    public void setHeight(int height) {
        setAttribute("height", height);
    }
    /**
     * default height of this item
     *
     *
     * @return int
     *
     */
    public int getHeight()  {
        return getAttributeAsInt("height");
    }

    /**
    * Base CSS class to apply to this item's input element. NOTE: See the ${isc.DocUtils.linkForRef('group:CompoundFormItem_skinning')} discussion for special skinning considerations.
    *
    * @param textBoxStyle textBoxStyle Default value is "textItem"
    */
    public void setTextBoxStyle(String textBoxStyle) {
        setAttribute("textBoxStyle", textBoxStyle);
    }
    /**
     * Base CSS class to apply to this item's input element. NOTE: See the ${isc.DocUtils.linkForRef('group:CompoundFormItem_skinning')} discussion for special skinning considerations.
     *
     *
     * @return String
     *
     */
    public String getTextBoxStyle()  {
        return getAttributeAsString("textBoxStyle");
    }
             
    /**
    * Align icons with the top edge of text area icons by default.
    *
    * @param iconVAlign iconVAlign Default value is Canvas.TOP
    */
    public void setIconVAlign(VerticalAlignment iconVAlign) {
        setAttribute("iconVAlign", iconVAlign.getValue());
    }
    /**
     * Align icons with the top edge of text area icons by default.
     *
     *
     * @return VerticalAlignment
     *
     */
    public VerticalAlignment getIconVAlign()  {
        return (VerticalAlignment) EnumUtil.getEnum(VerticalAlignment.values(), getAttribute("iconVAlign"));
    }

    /**
    * If this property is set to true, whenever this item is given focus programmatically  (see {@link com.smartgwt.client.widgets.form.DynamicForm#focusInItem}), all text within the item will be selected.<br> If false, the selection is not modified on focus - any previous selection within the item will be restored.<br> If unset, this property is derived from {@link com.smartgwt.client.widgets.form.DynamicForm#getSelectOnFocus selectOnFocus}
    *
    * @param selectOnFocus selectOnFocus Default value is null
    */
    public void setSelectOnFocus(Boolean selectOnFocus) {
        setAttribute("selectOnFocus", selectOnFocus);
    }
    /**
     * If this property is set to true, whenever this item is given focus programmatically  (see {@link com.smartgwt.client.widgets.form.DynamicForm#focusInItem}), all text within the item will be selected.<br> If false, the selection is not modified on focus - any previous selection within the item will be restored.<br> If unset, this property is derived from {@link com.smartgwt.client.widgets.form.DynamicForm#getSelectOnFocus selectOnFocus}
     *
     *
     * @return Boolean
     *
     */
    public Boolean getSelectOnFocus()  {
        return getAttributeAsBoolean("selectOnFocus");
    }

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************





    /**
     * Set the length.
     *
     * @param length the length
     */
    public void setLength(Integer length) {
        setAttribute("length", length);
    }

    /**
     * Return the length.
     *
     * @return the length
     */
    public Integer getLength() {
        return getAttributeAsInt("length");
    }

    /**
     * Text wrapping style.
     *
     * @param wrap wrap Default value is TextAreaItem.VIRTUAL
     */
    public void setWrap(TextAreaWrap wrap) {
        setAttribute("wrap", wrap.getValue());
    }

    /**
     * Text wrapping style.
     *
     * @return TextAreaWrap
     */
    public TextAreaWrap getWrap() {
        return (TextAreaWrap) EnumUtil.getEnum(TextAreaWrap.values(), getAttribute("wrap"));
    }


}
