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
 
package com.smartgwt.client.widgets.toolbar;



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
 * Base class for creating toolstrips like those found in browsers and office applications: a mixed set of controls
 * including {@link com.smartgwt.client.widgets.ImgButton},  {@link com.smartgwt.client.widgets.Button#getRadioGroup 'radio
 * button groups'}, {@link com.smartgwt.client.widgets.menu.MenuButton}, {@link
 * com.smartgwt.client.widgets.form.fields.ComboBoxItem}, {@link com.smartgwt.client.widgets.layout.LayoutSpacer}, {@link
 * com.smartgwt.client.widgets.Label} and  {@link com.smartgwt.client.widgets.form.fields.SelectItem}.   <P> All of the
 * above components are placed in the {@link com.smartgwt.client.widgets.toolbar.ToolStrip#getMembers 'members array'} to
 * form a ToolStrip.  Note that the {@link com.smartgwt.client.widgets.form.fields.FormItem} mentioned above (ComboBox and
 * drop-down selects) need to be placed within a {@link com.smartgwt.client.widgets.form.DynamicForm} as usual. <P> The
 * special strings "separator" and "resizer" can be placed in the members array to create separators and resizers
 * respectively. <P> Also see the ${isc.DocUtils.linkForExampleId('toolstrip')} example in the Feature Explorer.
 */
public class ToolStrip extends Layout {

    public static ToolStrip getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        BaseWidget obj = BaseWidget.getRef(jsObj);
        if(obj != null) {
            return (ToolStrip) obj;
        } else {
            return new ToolStrip(jsObj);
        }
    }

    public ToolStrip(){
        scClassName = "ToolStrip";
    }

    public ToolStrip(JavaScriptObject jsObj){
        super(jsObj);
    }

    protected native JavaScriptObject create()/*-{
        var config = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        var widget = $wnd.isc.ToolStrip.create(config);
        this.@com.smartgwt.client.widgets.BaseWidget::doInit()();
        return widget;
    }-*/;
    // ********************* Properties / Attributes ***********************

    /**
     * Customized resizeBar with typical appearance for a ToolStrip
     *
     * @param resizeBarClass resizeBarClass Default value is "ToolStripResizer"
     */
    public void setResizeBarClass(String resizeBarClass) {
        setAttribute("resizeBarClass", resizeBarClass, true);
    }

    /**
     * Customized resizeBar with typical appearance for a ToolStrip
     *
     *
     * @return String
     */
    public String getResizeBarClass()  {
        return getAttributeAsString("resizeBarClass");
    }

    /**
     * Thickness of the resizeBars in pixels
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param resizeBarSize resizeBarSize Default value is 14
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setResizeBarSize(int resizeBarSize)  throws IllegalStateException {
        setAttribute("resizeBarSize", resizeBarSize, false);
    }

    /**
     * Thickness of the resizeBars in pixels
     *
     *
     * @return int
     */
    public int getResizeBarSize()  {
        return getAttributeAsInt("resizeBarSize");
    }

    /**
     * Class to create when the string "separator" appears in {@link com.smartgwt.client.widgets.toolbar.ToolStrip#getMembers
     * members}.
     *
     * @param separatorClass separatorClass Default value is "ToolStripSeparator"
     */
    public void setSeparatorClass(String separatorClass) {
        setAttribute("separatorClass", separatorClass, true);
    }

    /**
     * Class to create when the string "separator" appears in {@link com.smartgwt.client.widgets.toolbar.ToolStrip#getMembers
     * members}.
     *
     *
     * @return String
     */
    public String getSeparatorClass()  {
        return getAttributeAsString("separatorClass");
    }

    /**
     * Separator thickness in pixels
     *
     * @param separatorSize separatorSize Default value is 8
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setSeparatorSize(int separatorSize)  throws IllegalStateException {
        setAttribute("separatorSize", separatorSize, false);
    }

    /**
     * Separator thickness in pixels
     *
     *
     * @return int
     */
    public int getSeparatorSize()  {
        return getAttributeAsInt("separatorSize");
    }

    /**
     * The CSS class applied to this widget as a whole.
     *
     * @param styleName styleName Default value is "toolStrip"
     */
    public void setStyleName(String styleName) {
        setAttribute("styleName", styleName, true);
    }

    /**
     * The CSS class applied to this widget as a whole.
     *
     *
     * @return String
     */
    public String getStyleName()  {
        return getAttributeAsString("styleName");
    }

    /**
     * Indicates whether the components are drawn horizontally from left to right (false), or vertically from top to bottom
     * (true).
     *
     * @param vertical vertical Default value is false
     */
    public void setVertical(Boolean vertical) {
        setAttribute("vertical", vertical, true);
    }

    /**
     * Indicates whether the components are drawn horizontally from left to right (false), or vertically from top to bottom
     * (true).
     *
     *
     * @return Boolean
     */
    public Boolean getVertical()  {
        return getAttributeAsBoolean("vertical");
    }

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************



    /**
     * Add a FormItem to the ToolStrip.
     *
     * @param formItem the formItem
     */
    public void addFormItem(FormItem formItem) {
        DynamicForm dynamicForm = new DynamicForm();
        dynamicForm.setWidth(formItem.getWidth());
        dynamicForm.setCellPadding(3);
        dynamicForm.setWidth("*");
        dynamicForm.setMinWidth(50);
        dynamicForm.setNumCols(1);
        dynamicForm.setFields(formItem);

        addMember(dynamicForm);
    }

    /**
     * Add a FormItem to the ToolStrip.
     *
     * @param formItem the FormItem
     * @param position the position in the layout to place newMember (starts with 0); if omitted, it will be added at
     *                  the last position
     */
    public void addFormItem(FormItem formItem, int position) {
        DynamicForm dynamicForm = new DynamicForm();
        dynamicForm.setWidth(formItem.getWidth());
        dynamicForm.setCellPadding(3);
        dynamicForm.setWidth(formItem.getWidth());
        dynamicForm.setMinWidth(50);
        dynamicForm.setNumCols(1);
        dynamicForm.setFields(formItem);
        addMember(dynamicForm, position);
    }

    /**
     * Add a button to the ToolStrip.
     *
     * @param button the toolstrip button
     */
    public void addButton(ToolStripButton button) {
        addMember(button);
    }

    /**
     * Add a button to the ToolStrip.
     *
     * @param button the button
     * @param position the position in the layout to place newMember (starts with 0); if omitted, it will be added at
     *                  the last position
     */
    public void addButton(ToolStripButton button, int position) {
        addMember(button, position);
    }

    /**
     * Add an extra space to the right of the previously added ToolStrip element.
     *
     * @param toolStripSpacer the toolstip spacer.
     */
    public void addSpacer(ToolStripSpacer toolStripSpacer) {
        Canvas canvas = new Canvas();
        canvas.setWidth(1);
        canvas.setHeight(1);
        canvas.setBorder("none");
        canvas.setExtraSpace(toolStripSpacer.getSpace());
        addMember(canvas);
    }

    /**
     * Adds a LayoutSpacer to the ToolStrip to take up space such like a normal member, without actually drawing anything.
     * This causes the "next" member added to the toolstip to be right / bottom justified depending on the
     * {@link com.smartgwt.client.widgets.toolbar.ToolStrip#setAlign(com.smartgwt.client.types.VerticalAlignment) alignment}
     * of the ToolStrip.
     */
    public void addFill() {
        addMember(new LayoutSpacer());
    }

    /**
     * Add a canvas to the layout, optionally at a specific position.
     *
     * @param component the canvas object to be added to the layout
     * @param position  the position in the layout to place newMember (starts with 0); if omitted, it will be added at
     *                  the last position
     */
    public void addMember(Canvas component, int position) {
        Object componentJS;
        if (component instanceof ToolStripSeparator) {
            componentJS = "separator";
        } else if (component instanceof ToolStripResizer) {
            componentJS = "resizer";
        } else {
            componentJS = component.getOrCreateJsObj();
        }

        if (isCreated()) {
            addMemberPostCreate(componentJS, position);

        } else {
            addMemberPreCreate(componentJS, position);
        }
    }

    /**
     * Add a canvas to the layout, optionally at a specific position.
     *
     * @param component the canvas object to be added to the layout
     */
    public void addMember(Canvas component) {
        Object componentJS;
        if (component instanceof ToolStripSeparator) {
            componentJS = "separator";
        } else if (component instanceof ToolStripResizer) {
            componentJS = "resizer";
        } else {
            componentJS = component.getOrCreateJsObj();
        }

        if (isCreated()) {
            addMemberPostCreate(componentJS);
        } else {
            addMemberPreCreate(componentJS);
        }
    }

}





