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
 
package com.smartgwt.client.widgets.tab;



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
    * Tabs are specified as objects, not class instances.  For example, when&#010 developing in JavaScript, a typical initialization block for a TabSet would look like&#010 this:&#010 <pre>&#010 TabSet.create({&#010     tabs: [&#010         {title: "tab1", pane: "pane1"},&#010         {title: "tab2"}&#010     ]&#010 });&#010 </pre>&#010 And in XML:&#010 <pre>&#010 &lt;TabSet&gt;&#010    &lt;tabs&gt;&#010        &lt;Tab title="tab1" pane="pane1"/&gt;&#010        &lt;Tab title="tab2"/&gt;&#010    &lt;/tabs&gt;&#010 &lt;/TabSet&gt;&#010 </pre>

    */
public class Tab extends RefDataClass {

    public static Tab getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        RefDataClass obj = RefDataClass.getRef(jsObj);
        if(obj != null) {
            obj.setJsObj(jsObj);
            return (Tab) obj;
        } else {
            return new Tab(jsObj);
        }
    }


    public Tab(){
        setID(com.smartgwt.client.util.SC.generateID());
    }

    public Tab(JavaScriptObject jsObj){
        super(jsObj);
    }

    public Tab(String title) {
        setTitle(title);
        setID(com.smartgwt.client.util.SC.generateID());
    }

    public Tab(String title, String icon) {
        setTitle(title);
		setIcon(icon);
        setID(com.smartgwt.client.util.SC.generateID());
    }

    // ********************* Properties / Attributes ***********************

    /**
    * Specifies the title of the this tab.  To change the title after the TabSet has been&#010 created, call {@link com.smartgwt.client.widgets.tab.TabSet#setTabTitle}.
    *
    * @param title title Default value is null
    */
    public void setTitle(String title) {
        setAttribute("title", title);
    }
    /**
     * Specifies the title of the this tab.  To change the title after the TabSet has been&#010 created, call {@link com.smartgwt.client.widgets.tab.TabSet#setTabTitle}.
     *
     *
     * @return String
     *
     */
    public String getTitle()  {
        return getAttributeAsString("title");
    }

    /**
    * If {@link com.smartgwt.client.widgets.tab.TabSet#getShowTabPicker showTabPicker} is true for this TabSet, if set this property will determine&#010 the title of the picker menu item for this tab. If unset, {@link com.smartgwt.client.widgets.tab.Tab#getTitle title} will be used&#010 instead
    *
    * @param pickerTitle pickerTitle Default value is null
    */
    public void setPickerTitle(String pickerTitle) {
        setAttribute("pickerTitle", pickerTitle);
    }
    /**
     * If {@link com.smartgwt.client.widgets.tab.TabSet#getShowTabPicker showTabPicker} is true for this TabSet, if set this property will determine&#010 the title of the picker menu item for this tab. If unset, {@link com.smartgwt.client.widgets.tab.Tab#getTitle title} will be used&#010 instead
     *
     *
     * @return String
     *
     */
    public String getPickerTitle()  {
        return getAttributeAsString("pickerTitle");
    }

    /**
    * Optional ID for the tab, which can later be used to reference the tab.&#010 APIs requiring a referenct a tab will accept the tabs ID &#010 [including  {@link com.smartgwt.client.widgets.tab.TabSet#selectTab}, {@link com.smartgwt.client.widgets.tab.TabSet#updateTab}, {@link com.smartgwt.client.widgets.tab.TabSet#removeTab}].<br>&#010 The ID will also be passed to the {@link com.smartgwt.client.widgets.tab.TabSet#tabSelected} and {@link com.smartgwt.client.widgets.tab.TabSet#tabDeselected}&#010 handler functions, if specified.&#010 <p>&#010 Note that if you provide an ID, it must be globally unique.
    *
    * @param ID ID Default value is null
    */
    public void setID(String ID) {
        setAttribute("ID", ID);
    }
    /**
     * Optional ID for the tab, which can later be used to reference the tab.&#010 APIs requiring a referenct a tab will accept the tabs ID &#010 [including  {@link com.smartgwt.client.widgets.tab.TabSet#selectTab}, {@link com.smartgwt.client.widgets.tab.TabSet#updateTab}, {@link com.smartgwt.client.widgets.tab.TabSet#removeTab}].<br>&#010 The ID will also be passed to the {@link com.smartgwt.client.widgets.tab.TabSet#tabSelected} and {@link com.smartgwt.client.widgets.tab.TabSet#tabDeselected}&#010 handler functions, if specified.&#010 <p>&#010 Note that if you provide an ID, it must be globally unique.
     *
     *
     * @return String
     *
     */
    public String getID()  {
        return getAttributeAsString("ID");
    }

    /**
    * You can specify an explicit width for the tab using this property.  Note that tabs&#010 automatically size to make room for the full title, but if you want to e.g. specify a&#010 uniform width for all tabs in a TabSet, this property enables you to do so.
    *
    * @param width width Default value is 100
    */
    public void setWidth(int width) {
        setAttribute("width", width);
    }
    /**
     * You can specify an explicit width for the tab using this property.  Note that tabs&#010 automatically size to make room for the full title, but if you want to e.g. specify a&#010 uniform width for all tabs in a TabSet, this property enables you to do so.
     *
     *
     * @return int
     *
     */
    public int getWidth()  {
        return getAttributeAsInt("width");
    }

    /**
    * If specified, this tab will initially be rendered in a disabled state. To enable or&#010 disable tabs on the fly use the {@link com.smartgwt.client.widgets.tab.TabSet#enableTab}, and {@link com.smartgwt.client.widgets.tab.TabSet#disableTab}&#010 methods.
    *
    * @param disabled disabled Default value is null
    */
    public void setDisabled(Boolean disabled) {
        setAttribute("disabled", disabled);
    }
    /**
     * If specified, this tab will initially be rendered in a disabled state. To enable or&#010 disable tabs on the fly use the {@link com.smartgwt.client.widgets.tab.TabSet#enableTab}, and {@link com.smartgwt.client.widgets.tab.TabSet#disableTab}&#010 methods.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getDisabled()  {
        return getAttributeAsBoolean("disabled");
    }

    /**
    * If specified, this tab will show an icon next to the tab title.  Note that as with &#010 {@link com.smartgwt.client.widgets.Button#getIcon icon}, the URL of a tabs icon will be updated to reflect disabled state.<br>&#010 If desired a click handler may be assigned to the icon, which will be fired when the user&#010 clicks the tab. This method takes a single parameter <code>tab</code>, a pointer to the tab&#010 object.
    *
    * @param icon icon Default value is null
    */
    public void setIcon(String icon) {
        setAttribute("icon", icon);
    }
    /**
     * If specified, this tab will show an icon next to the tab title.  Note that as with &#010 {@link com.smartgwt.client.widgets.Button#getIcon icon}, the URL of a tabs icon will be updated to reflect disabled state.<br>&#010 If desired a click handler may be assigned to the icon, which will be fired when the user&#010 clicks the tab. This method takes a single parameter <code>tab</code>, a pointer to the tab&#010 object.
     *
     *
     * @return String
     *
     */
    public String getIcon()  {
        return getAttributeAsString("icon");
    }

    /**
    * Determines whether this tab should show an icon allowing the user to dismiss the tab by&#010 clicking on it directly. The URL for this icon's image will be derived from &#010 {@link com.smartgwt.client.widgets.tab.TabSet#getCloseTabIcon closeTabIcon} by default, but may be overridden by explicitly specifying&#010 {@link com.smartgwt.client.widgets.tab.Tab#getCloseIcon closeIcon}.<br>&#010 If unset, this property is derived from {@link com.smartgwt.client.widgets.tab.TabSet#getCanCloseTabs canCloseTabs}
    *
    * @param canClose canClose Default value is null
    */
    public void setCanClose(Boolean canClose) {
        setAttribute("canClose", canClose);
    }
    /**
     * Determines whether this tab should show an icon allowing the user to dismiss the tab by&#010 clicking on it directly. The URL for this icon's image will be derived from &#010 {@link com.smartgwt.client.widgets.tab.TabSet#getCloseTabIcon closeTabIcon} by default, but may be overridden by explicitly specifying&#010 {@link com.smartgwt.client.widgets.tab.Tab#getCloseIcon closeIcon}.<br>&#010 If unset, this property is derived from {@link com.smartgwt.client.widgets.tab.TabSet#getCanCloseTabs canCloseTabs}
     *
     *
     * @return Boolean
     *
     */
    public Boolean getCanClose()  {
        return getAttributeAsBoolean("canClose");
    }

    /**
    * Custom src for the close icon for this tab to display if it is closeable.&#010 See {@link com.smartgwt.client.widgets.tab.Tab#getCanClose canClose} and {@link com.smartgwt.client.widgets.tab.TabSet#getCanCloseTabs canCloseTabs}.
    *
    * @param closeIcon closeIcon Default value is null
    */
    public void setCloseIcon(String closeIcon) {
        setAttribute("closeIcon", closeIcon);
    }
    /**
     * Custom src for the close icon for this tab to display if it is closeable.&#010 See {@link com.smartgwt.client.widgets.tab.Tab#getCanClose canClose} and {@link com.smartgwt.client.widgets.tab.TabSet#getCanCloseTabs canCloseTabs}.
     *
     *
     * @return String
     *
     */
    public String getCloseIcon()  {
        return getAttributeAsString("closeIcon");
    }

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************




    public void setCanClose(boolean canClose) {
        setAttribute("canClose", canClose);
    }


    public void setDisabled(boolean disabled) {
        setAttribute("disabled", disabled);
    }


    public void setPaneID(String paneID) {
        setAttribute("pane", paneID);
    }

    /**
     * Specifies the pane associated with this tab. You can change the pane associated with a given tab after the TabSet
     * has been created by calling {@link com.smartgwt.client.widgets.tab.TabSet#updateTab(int, com.smartgwt.client.widgets.Canvas)}
     *
     * @param pane the tab pane
     */
    public void setPane(Canvas pane) {
        setAttribute("pane", pane.getOrCreateJsObj());
    }

    /**
     * The pane associated with the tab.
     *
     * @return the tab pane
     */
    public Canvas getPane() {
        return Canvas.getOrCreateRef(getAttributeAsJavaScriptObject("pane"));
    }

    /**
    * Size in pixels of the icon for closing tabs, displayed when {@link com.smartgwt.client.widgets.tab.TabSet#getCanCloseTabs canCloseTabs} is true.
    *
    * @param closeIconSize closeIconSize Default value is 16
    */
    public void setCloseIconSize(int closeIconSize) {
        setAttribute("closeIconSize", closeIconSize);
    }    

}





