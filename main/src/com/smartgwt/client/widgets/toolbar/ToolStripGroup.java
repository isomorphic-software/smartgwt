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
 * A widget that groups other controls for use in {@link com.smartgwt.client.widgets.toolbar.ToolStrip tool-strips}.
 */
public class ToolStripGroup extends VLayout {

    public native static ToolStripGroup getOrCreateRef(JavaScriptObject jsObj) /*-{

    	if(jsObj == null) return null;
    	
    	var instance = jsObj["__ref"];
    	
    	if(instance==undefined) {
            return @com.smartgwt.client.util.ObjectFactory::createCanvas(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)("ToolStripGroup",jsObj);
        } else if(instance != null) {
            return instance;
        //} else {
        //    return @com.smartgwt.client.widgets.toolbar.ToolStripGroup::new(Lcom/google/gwt/core/client/JavaScriptObject;)(jsObj);
        }
    }-*/;

    public void setJavaScriptObject(JavaScriptObject jsObj) {
        id = JSOHelper.getAttribute(jsObj, "ID");
    }


    public ToolStripGroup(){
        scClassName = "ToolStripGroup";
    }

    public ToolStripGroup(JavaScriptObject jsObj){
        scClassName = "ToolStripGroup";
        setJavaScriptObject(jsObj);
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
     * By default, ToolStripGroups are assigned a minimum width that allows the entire title  to be visible.  To prevent this
     * bahavior and have group-titles cut off when they're  wider than the buttons they contain, set this attribute to false
     *
     * @param autoSizeToTitle autoSizeToTitle Default value is true
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setAutoSizeToTitle(Boolean autoSizeToTitle)  throws IllegalStateException {
        setAttribute("autoSizeToTitle", autoSizeToTitle, false);
    }

    /**
     * By default, ToolStripGroups are assigned a minimum width that allows the entire title  to be visible.  To prevent this
     * bahavior and have group-titles cut off when they're  wider than the buttons they contain, set this attribute to false
     *
     *
     * @return Boolean
     */
    public Boolean getAutoSizeToTitle()  {
        return getAttributeAsBoolean("autoSizeToTitle");
    }

    /**
     * Smart GWT class for the body.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param bodyConstructor . See {@link com.smartgwt.client.docs.String String}. Default value is "HLayout"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setBodyConstructor(String bodyConstructor)  throws IllegalStateException {
        setAttribute("bodyConstructor", bodyConstructor, false);
    }

    /**
     * Smart GWT class for the body.
     *
     *
     * @return . See {@link com.smartgwt.client.docs.String String}
     */
    public String getBodyConstructor()  {
        return getAttributeAsString("bodyConstructor");
    }

    /**
     * Smart GWT class for the title label.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param labelConstructor . See {@link com.smartgwt.client.docs.String String}. Default value is "Label"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setLabelConstructor(String labelConstructor)  throws IllegalStateException {
        setAttribute("labelConstructor", labelConstructor, false);
    }

    /**
     * Smart GWT class for the title label.
     *
     *
     * @return . See {@link com.smartgwt.client.docs.String String}
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
     * @param rowHeight rowHeight Default value is 26
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
     * @param styleName . See {@link com.smartgwt.client.docs.CSSClassName CSSClassName}. Default value is "toolStripGroup"
     */
    public void setStyleName(String styleName) {
        setAttribute("styleName", styleName, true);
    }

    /**
     * CSS class applied to this ToolStripGroup.
     *
     *
     * @return . See {@link com.smartgwt.client.docs.CSSClassName CSSClassName}
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
        setAttribute("titleAlign", titleAlign == null ? null : titleAlign.getValue(), true);
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
        setAttribute("titleOrientation", titleOrientation == null ? null : titleOrientation.getValue(), true);
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
     * @param titleStyle . See {@link com.smartgwt.client.docs.CSSClassName CSSClassName}. Default value is "toolStripGroupTitle"
     */
    public void setTitleStyle(String titleStyle) {
        setAttribute("titleStyle", titleStyle, true);
    }

    /**
     * CSS class applied to this ToolStripGroup.
     *
     *
     * @return . See {@link com.smartgwt.client.docs.CSSClassName CSSClassName}
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
    public native void addControl(Canvas control, Integer index) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.addControl(control.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()(), index == null ? null : index.@java.lang.Integer::intValue()());
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

    public LogicalStructureObject setLogicalStructure(ToolStripGroupLogicalStructure s) {
        super.setLogicalStructure(s);
        try {
            s.autoSizeToTitle = getAttributeAsString("autoSizeToTitle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "ToolStripGroup.autoSizeToTitle:" + t.getMessage() + "\n";
        }
        try {
            s.bodyConstructor = getAttributeAsString("bodyConstructor");
        } catch (Throwable t) {
            s.logicalStructureErrors += "ToolStripGroup.bodyConstructor:" + t.getMessage() + "\n";
        }
        try {
            s.controls = getAttributeAsStringArray("controls");
        } catch (Throwable t) {
            s.logicalStructureErrors += "ToolStripGroup.controlsArray:" + t.getMessage() + "\n";
        }
        try {
            s.labelConstructor = getAttributeAsString("labelConstructor");
        } catch (Throwable t) {
            s.logicalStructureErrors += "ToolStripGroup.labelConstructor:" + t.getMessage() + "\n";
        }
        try {
            s.numRows = getAttributeAsString("numRows");
        } catch (Throwable t) {
            s.logicalStructureErrors += "ToolStripGroup.numRows:" + t.getMessage() + "\n";
        }
        try {
            s.rowHeight = getAttributeAsString("rowHeight");
        } catch (Throwable t) {
            s.logicalStructureErrors += "ToolStripGroup.rowHeight:" + t.getMessage() + "\n";
        }
        try {
            s.styleName = getAttributeAsString("styleName");
        } catch (Throwable t) {
            s.logicalStructureErrors += "ToolStripGroup.styleName:" + t.getMessage() + "\n";
        }
        try {
            s.titleAlign = getAttributeAsString("titleAlign");
        } catch (Throwable t) {
            s.logicalStructureErrors += "ToolStripGroup.titleAlign:" + t.getMessage() + "\n";
        }
        try {
            s.titleHeight = getAttributeAsString("titleHeight");
        } catch (Throwable t) {
            s.logicalStructureErrors += "ToolStripGroup.titleHeight:" + t.getMessage() + "\n";
        }
        try {
            s.titleOrientation = getAttributeAsString("titleOrientation");
        } catch (Throwable t) {
            s.logicalStructureErrors += "ToolStripGroup.titleOrientation:" + t.getMessage() + "\n";
        }
        try {
            s.titleStyle = getAttributeAsString("titleStyle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "ToolStripGroup.titleStyle:" + t.getMessage() + "\n";
        }
        return s;
    }
    
    public LogicalStructureObject getLogicalStructure() {
        ToolStripGroupLogicalStructure s = new ToolStripGroupLogicalStructure();
        setLogicalStructure(s);
        return s;
    }
}

