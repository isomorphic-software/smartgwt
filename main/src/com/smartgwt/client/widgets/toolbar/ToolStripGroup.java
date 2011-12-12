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

import java.util.*;

import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;
import com.smartgwt.client.util.*;
import com.google.gwt.event.shared.*;
import com.google.gwt.event.shared.HasHandlers;

/**
 * A widget that groups other controls for use in {@link com.smartgwt.client.widgets.toolbar.ToolStrip tool-strips}.
 */
public class ToolStripGroup extends VLayout {

    public static ToolStripGroup getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        BaseWidget obj = BaseWidget.getRef(jsObj);
        if(obj != null) {
            return (ToolStripGroup) obj;
        } else {
            return new ToolStripGroup(jsObj);
        }
    }

    public ToolStripGroup(){
        scClassName = "ToolStripGroup";
    }

    public ToolStripGroup(JavaScriptObject jsObj){
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
     * Smart GWT class for the body.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param bodyConstructor bodyConstructor Default value is "HLayout"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setBodyConstructor(String bodyConstructor)  throws IllegalStateException {
        setAttribute("bodyConstructor", bodyConstructor, false);
    }

    /**
     * Smart GWT class for the body.
     *
     *
     * @return String
     */
    public String getBodyConstructor()  {
        return getAttributeAsString("bodyConstructor");
    }

    /**
     * Smart GWT class for the title label.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param labelConstructor labelConstructor Default value is "Label"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setLabelConstructor(String labelConstructor)  throws IllegalStateException {
        setAttribute("labelConstructor", labelConstructor, false);
    }

    /**
     * Smart GWT class for the title label.
     *
     *
     * @return String
     */
    public String getLabelConstructor()  {
        return getAttributeAsString("labelConstructor");
    }

    /**
     * The number of rows of controls to display in each column.
     *
     * @param numRows numRows Default value is 1
     */
    public void setNumRows(int numRows) {
        setAttribute("numRows", numRows, true);
    }

    /**
     * The number of rows of controls to display in each column.
     *
     *
     * @return int
     */
    public int getNumRows()  {
        return getAttributeAsInt("numRows");
    }

    /**
     * The height of rows in each column.
     *
     * @param rowHeight rowHeight Default value is 20
     */
    public void setRowHeight(int rowHeight) {
        setAttribute("rowHeight", rowHeight, true);
    }

    /**
     * The height of rows in each column.
     *
     *
     * @return int
     */
    public int getRowHeight()  {
        return getAttributeAsInt("rowHeight");
    }

    /**
     * CSS class applied to this ToolStripGroup.
     *
     * @param styleName styleName Default value is "toolStripGroup"
     */
    public void setStyleName(String styleName) {
        setAttribute("styleName", styleName, true);
    }

    /**
     * CSS class applied to this ToolStripGroup.
     *
     *
     * @return String
     */
    public String getStyleName()  {
        return getAttributeAsString("styleName");
    }

    /**
     * Controls the horizontal alignment of the group-title in its label.  Setting this attribute overrides the default
     * specified by  {@link com.smartgwt.client.widgets.toolbar.ToolStrip#getGroupTitleAlign groupTitleAlign} on the containing
     *  {@link com.smartgwt.client.widgets.toolbar.ToolStrip ToolStrip}.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * This method forcibly sets the text-alignment of this group's title after initial draw.
     *
     * @param titleAlign the new alignment for the text, left or right. Default value is "center"
     */
    public void setTitleAlign(Alignment titleAlign) {
        setAttribute("titleAlign", titleAlign.getValue(), true);
    }

    /**
     * Controls the horizontal alignment of the group-title in its label.  Setting this attribute overrides the default
     * specified by  {@link com.smartgwt.client.widgets.toolbar.ToolStrip#getGroupTitleAlign groupTitleAlign} on the containing
     *  {@link com.smartgwt.client.widgets.toolbar.ToolStrip ToolStrip}.
     *
     *
     * @return Alignment
     */
    public Alignment getTitleAlign()  {
        return EnumUtil.getEnum(Alignment.values(), getAttribute("titleAlign"));
    }

    /**
     * The height of the {@link com.smartgwt.client.widgets.toolbar.ToolStripGroup#getLabel title label} in this group.
     *
     * @param titleHeight titleHeight Default value is 18
     */
    public void setTitleHeight(int titleHeight) {
        setAttribute("titleHeight", titleHeight, true);
    }

    /**
     * The height of the {@link com.smartgwt.client.widgets.toolbar.ToolStripGroup#getLabel title label} in this group.
     *
     *
     * @return int
     */
    public int getTitleHeight()  {
        return getAttributeAsInt("titleHeight");
    }

    /**
     * Controls the horizontal alignment of the group-title in its label.  Setting this attribute overrides the default
     * specified by  {@link com.smartgwt.client.widgets.toolbar.ToolStrip#getGroupTitleAlign groupTitleOrientation} on the
     * containing  {@link com.smartgwt.client.widgets.toolbar.ToolStrip ToolStrip}.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * This method forcibly sets the orientation of this group's title after initial draw.
     *
     * @param titleOrientation the new orientation for the title, either bottom or top. Default value is "top"
     */
    public void setTitleOrientation(VerticalAlignment titleOrientation) {
        setAttribute("titleOrientation", titleOrientation.getValue(), true);
    }

    /**
     * Controls the horizontal alignment of the group-title in its label.  Setting this attribute overrides the default
     * specified by  {@link com.smartgwt.client.widgets.toolbar.ToolStrip#getGroupTitleAlign groupTitleOrientation} on the
     * containing  {@link com.smartgwt.client.widgets.toolbar.ToolStrip ToolStrip}.
     *
     *
     * @return VerticalAlignment
     */
    public VerticalAlignment getTitleOrientation()  {
        return EnumUtil.getEnum(VerticalAlignment.values(), getAttribute("titleOrientation"));
    }

    /**
     * CSS class applied to this ToolStripGroup.
     *
     * @param titleStyle titleStyle Default value is "toolStripGroupTitle"
     */
    public void setTitleStyle(String titleStyle) {
        setAttribute("titleStyle", titleStyle, true);
    }

    /**
     * CSS class applied to this ToolStripGroup.
     *
     *
     * @return String
     */
    public String getTitleStyle()  {
        return getAttributeAsString("titleStyle");
    }

    // ********************* Methods ***********************
            
    /**
     * Adds a control to this toolStripGroup, creating a new column if necessary, according to the control's rowSpan attribute
     * and the group's {@link com.smartgwt.client.widgets.toolbar.ToolStripGroup#getNumRows numRows} attribute.
     * @param control a widget to add to this group
     */
    public native void addControl(Canvas control) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.addControl(control.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()());
    }-*/;

    /**
     * Adds a control to this toolStripGroup, creating a new column if necessary, according to the control's rowSpan attribute
     * and the group's {@link com.smartgwt.client.widgets.toolbar.ToolStripGroup#getNumRows numRows} attribute.
     * @param control a widget to add to this group
     * @param index optional insertion index for this control
     */
    public native void addControl(Canvas control, int index) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.addControl(control.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()(), index);
    }-*/;
            
    /**
     * Removes a control from this toolStripGroup, destroying an existing column if this is the last widget in that column.
     * @param control a widget to remove from this group
     */
    public native void removeControl(Canvas control) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.removeControl(control.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()());
    }-*/;
            
    /**
     * Return the column widget that contains the passed control.
     * @param control the control to find in this group
     */
    public native void setControlColumn(Canvas control) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setControlColumn(control.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()());
    }-*/;
            
    /**
     * This method forcibly shows or hides this group's title after initial draw.
     * @param showTitle should be show the title be shown or hidden?
     */
    public native void setShowTitle(boolean showTitle) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setShowTitle(showTitle);
    }-*/;
            
    /**
     * Sets the header-text for this group.
     * @param title The new title for this group
     */
    public native void setTitle(String title) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setTitle(title);
    }-*/;

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
     * @param toolStripGroupProperties properties that should be used as new defaults when instances of this class are created
     */
    public static native void setDefaultProperties(ToolStripGroup toolStripGroupProperties) /*-{
    	var properties = $wnd.isc.addProperties({},toolStripGroupProperties.@com.smartgwt.client.widgets.BaseWidget::getConfig()());
    	delete properties.ID;
        $wnd.isc.ToolStripGroup.addProperties(properties);
    }-*/;
        
    // ***********************************************************        


    /**
     * The array of controls to show in this group.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Clears the array of controls and then adds the passed array to this toolBarGroup,  creating new columns as necessary according to each control's rowSpan attribute and  the group's numRows attribute.
     *
     * @param controls an array of widgets to add to this group. Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setControls(Canvas... controls)  throws IllegalStateException {
        setAttribute("controls", controls, false);
    }

    /**
     * The array of controls to show in this group.
     *
     *
     * @return Unhandled-WidgetArray
     */
    public Canvas[] getControls()  {
        return Canvas.convertToCanvasArray(getAttributeAsJavaScriptObject("controls"));
    }

    /**
     * Adds an array of controls to this group, creating new columns as necessary according to each control's rowSpan attribute
     * and the group's numRows attribute.
     * @param controls an array of widgets to add to this group
     */
    public native void addControls(Canvas... controls) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var controlsJS = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(controls);
        self.addControls(controlsJS);
    }-*/;

}



