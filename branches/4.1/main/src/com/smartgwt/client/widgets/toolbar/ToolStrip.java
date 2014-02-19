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
 * including {@link com.smartgwt.client.widgets.ImgButton icon buttons},  {@link
 * com.smartgwt.client.widgets.Button#getRadioGroup radio button groups}, {@link
 * com.smartgwt.client.widgets.menu.MenuButton menus}, {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem
 * comboBoxes}, {@link com.smartgwt.client.widgets.layout.LayoutSpacer spacers}, {@link com.smartgwt.client.widgets.Label
 * status displays} and  {@link com.smartgwt.client.widgets.form.fields.SelectItem drop-down selects}.   <P> All of the
 * above components are placed in the {@link com.smartgwt.client.widgets.toolbar.ToolStrip#getMembers members array} to
 * form a ToolStrip.  Note that the {@link com.smartgwt.client.widgets.form.fields.FormItem FormItems} mentioned above
 * (ComboBox and drop-down selects) need to be placed within a {@link com.smartgwt.client.widgets.form.DynamicForm} as
 * usual. <P> The special strings "separator" and "resizer" can be placed in the members array to create separators and
 * resizers respectively. <P> Also see the <a href="http://www.smartclient.com/smartgwt/showcase/#toolstrip"
 * target="examples">ToolStrips Example</a> example in the Feature Explorer.
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
        var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
        var widget = $wnd.isc[scClassName].create(config);
        this.@com.smartgwt.client.widgets.BaseWidget::doInit()();
        return widget;
    }-*/;
    // ********************* Properties / Attributes ***********************

    /**
     * If set, this attribute affects the alignment of the titles in  {@link com.smartgwt.client.widgets.toolbar.ToolStripGroup
     * ToolStripGroups}.  You can override this at the  {@link com.smartgwt.client.widgets.toolbar.ToolStripGroup#getTitleAlign
     * individual ToolStripGroup} level.
     *
     * @param groupTitleAlign groupTitleAlign Default value is "center"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setGroupTitleAlign(Alignment groupTitleAlign)  throws IllegalStateException {
        setAttribute("groupTitleAlign", groupTitleAlign == null ? null : groupTitleAlign.getValue(), false);
    }

    /**
     * If set, this attribute affects the alignment of the titles in  {@link com.smartgwt.client.widgets.toolbar.ToolStripGroup
     * ToolStripGroups}.  You can override this at the  {@link com.smartgwt.client.widgets.toolbar.ToolStripGroup#getTitleAlign
     * individual ToolStripGroup} level.
     *
     *
     * @return Alignment
     */
    public Alignment getGroupTitleAlign()  {
        return EnumUtil.getEnum(Alignment.values(), getAttribute("groupTitleAlign"));
    }

    /**
     * If set, this attribute affects the orientation of the titles in  {@link
     * com.smartgwt.client.widgets.toolbar.ToolStripGroup ToolStripGroups}.  You can override this at the  {@link
     * com.smartgwt.client.widgets.toolbar.ToolStripGroup#getTitleAlign individual ToolStripGroup} level.
     *
     * @param groupTitleOrientation groupTitleOrientation Default value is "top"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setGroupTitleOrientation(VerticalAlignment groupTitleOrientation)  throws IllegalStateException {
        setAttribute("groupTitleOrientation", groupTitleOrientation == null ? null : groupTitleOrientation.getValue(), false);
    }

    /**
     * If set, this attribute affects the orientation of the titles in  {@link
     * com.smartgwt.client.widgets.toolbar.ToolStripGroup ToolStripGroups}.  You can override this at the  {@link
     * com.smartgwt.client.widgets.toolbar.ToolStripGroup#getTitleAlign individual ToolStripGroup} level.
     *
     *
     * @return VerticalAlignment
     */
    public VerticalAlignment getGroupTitleOrientation()  {
        return EnumUtil.getEnum(VerticalAlignment.values(), getAttribute("groupTitleOrientation"));
    }

    /**
     * Customized resizeBar with typical appearance for a ToolStrip.
     *
     * @param resizeBarClass resizeBarClass Default value is "ToolStripResizer"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setResizeBarClass(String resizeBarClass)  throws IllegalStateException {
        setAttribute("resizeBarClass", resizeBarClass, false);
    }

    /**
     * Customized resizeBar with typical appearance for a ToolStrip.
     *
     *
     * @return String
     */
    public String getResizeBarClass()  {
        return getAttributeAsString("resizeBarClass");
    }

    /**
     * Thickness of the resizeBars in pixels.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param resizeBarSize resizeBarSize Default value is 14
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setResizeBarSize(int resizeBarSize)  throws IllegalStateException {
        setAttribute("resizeBarSize", resizeBarSize, false);
    }

    /**
     * Thickness of the resizeBars in pixels.
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
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setSeparatorClass(String separatorClass)  throws IllegalStateException {
        setAttribute("separatorClass", separatorClass, false);
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
     * If set, this attribute affects whether {@link com.smartgwt.client.widgets.toolbar.ToolStripGroup ToolStripGroups} in
     * this ToolStrip show their header control.  You can override this at the  {@link
     * com.smartgwt.client.widgets.toolbar.ToolStripGroup#getShowTitle individual ToolStripGroup} level.
     *
     * @param showGroupTitle showGroupTitle Default value is true
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setShowGroupTitle(Boolean showGroupTitle)  throws IllegalStateException {
        setAttribute("showGroupTitle", showGroupTitle, false);
    }

    /**
     * If set, this attribute affects whether {@link com.smartgwt.client.widgets.toolbar.ToolStripGroup ToolStripGroups} in
     * this ToolStrip show their header control.  You can override this at the  {@link
     * com.smartgwt.client.widgets.toolbar.ToolStripGroup#getShowTitle individual ToolStripGroup} level.
     *
     *
     * @return Boolean
     */
    public Boolean getShowGroupTitle()  {
        return getAttributeAsBoolean("showGroupTitle");
    }

    /**
     * Indicates whether the components are drawn horizontally from left to right (false), or vertically from top to bottom
     * (true).
     *
     * @param vertical vertical Default value is false
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setVertical(Boolean vertical)  throws IllegalStateException {
        setAttribute("vertical", vertical, false);
    }

    /**
     * Indicates whether the components are drawn horizontally from left to right (false), or vertically from top to bottom
     * (true).
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Boolean getVertical()  {
        return getAttributeAsBoolean("vertical");
    }

    /**
     * Default stylename to use if {@link com.smartgwt.client.widgets.toolbar.ToolStrip#getVertical this.vertical} is true. If
     * unset, the standard {@link com.smartgwt.client.widgets.toolbar.ToolStrip#getStyleName styleName} will be used for both
     * vertical and horizontal toolstrips. <P> Note that this property only applies to the widget at init time. To modify the 
     * styleName after this widget has been initialized, you should simply call {@link
     * com.smartgwt.client.widgets.Canvas#setStyleName setStyleName()} rather than updating this  property.
     *
     * @param verticalStyleName verticalStyleName Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setVerticalStyleName(String verticalStyleName)  throws IllegalStateException {
        setAttribute("verticalStyleName", verticalStyleName, false);
    }

    /**
     * Default stylename to use if {@link com.smartgwt.client.widgets.toolbar.ToolStrip#getVertical this.vertical} is true. If
     * unset, the standard {@link com.smartgwt.client.widgets.toolbar.ToolStrip#getStyleName styleName} will be used for both
     * vertical and horizontal toolstrips. <P> Note that this property only applies to the widget at init time. To modify the 
     * styleName after this widget has been initialized, you should simply call {@link
     * com.smartgwt.client.widgets.Canvas#setStyleName setStyleName()} rather than updating this  property.
     *
     *
     * @return String
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getVerticalStyleName()  {
        return getAttributeAsString("verticalStyleName");
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
     * @param toolStripProperties properties that should be used as new defaults when instances of this class are created
     */
    public static native void setDefaultProperties(ToolStrip toolStripProperties) /*-{
    	var properties = $wnd.isc.addProperties({},toolStripProperties.@com.smartgwt.client.widgets.BaseWidget::getConfig()());
    	delete properties.ID;
        $wnd.isc.ToolStrip.addProperties(properties);
    }-*/;
        
    // ***********************************************************        


    /**
     * Add a FormItem to the ToolStrip.
     *
     * @param formItem the formItem
     */
    public void addFormItem(FormItem formItem) {
        DynamicForm dynamicForm = new DynamicForm();
        dynamicForm.setCellPadding(3);
        dynamicForm.setMinWidth(50);
        dynamicForm.setNumCols(1);
        dynamicForm.setFields(formItem);
        applyWidth(dynamicForm.getConfig(), formItem.getJsObj());
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
        dynamicForm.setCellPadding(3);
        dynamicForm.setMinWidth(50);
        dynamicForm.setNumCols(1);
        dynamicForm.setFields(formItem);
        applyWidth(dynamicForm.getConfig(), formItem.getJsObj());
        addMember(dynamicForm, position);
    }

    //set the width of the form to match that of the form item. using native method because width can be int or String
    private static native void applyWidth(JavaScriptObject formJS, JavaScriptObject itemJS)/*-{
        formJS.width = itemJS.width;
    }-*/;

    /**
     * Add a button to the ToolStrip.
     *
     * @param button the toolstrip button
     */
    public void addButton(ToolStripButton button) {
        if(button.getTitle() == null) {
            button.setIconSpacing(0);
            button.setLabelHPad(3);
        } else if (button.getIcon() == null) {
            button.setLabelHPad(7);
        }

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
        if(button.getTitle() == null) {
            button.setIconSpacing(0);
            button.setLabelHPad(3);
        } else if (button.getIcon() == null) {
            button.setLabelHPad(7);
        }
        addMember(button, position);
    }

    /**
     * Add a menu button to the ToolStrip.
     *
     * @param button the toolstrip menu button
     */
    public void addMenuButton(ToolStripMenuButton button) {
        if(button.getTitle() == null) {
            button.setIconSpacing(0);
            button.setLabelHPad(3);
        } else if (button.getIcon() == null) {
            button.setLabelHPad(7);
        }
        addMember(button);
    }

    /**
     * Add a menu button to the ToolStrip.
     *
     * @param button the menu button
     * @param position the position in the layout to place newMember (starts with 0); if omitted, it will be added at
     *                  the last position
     */
    public void addMenuButton(ToolStripMenuButton button, int position) {
        if(button.getTitle() == null) {
            button.setIconSpacing(0);
            button.setLabelHPad(3);
        } else if (button.getIcon() == null) {
            button.setLabelHPad(7);
        }
        addMember(button, position);
    }

    /**
     * Add an extra space to the right of the previously added ToolStrip element. This is a shortcut for {@link #addSpacer(ToolStripSpacer)}.
     *
     * @param space space
     */
    public void addSpacer(int space) {
        addSpacer(new ToolStripSpacer(space));
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
     * Add a {@link com.smartgwt.client.widgets.toolbar.ToolStripSeparator separator}.
     */
    public void addSeparator() {
        addMember(new ToolStripSeparator());
    }

    /**
     * Add a {@link com.smartgwt.client.widgets.toolbar.ToolStripResizer resizer}
     */
    public void addResizer() {
        addMember(new ToolStripResizer());
    }

}



