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
import com.smartgwt.client.util.*;
import com.google.gwt.event.shared.*;
import com.google.gwt.event.shared.HasHandlers;

/**
 * Tabs are specified as objects, not class instances.  For example, when&#010 developing in JavaScript, a typical
 * initialization block for a TabSet would look like&#010 this:&#010 <pre>&#010 TabSet.create({&#010     tabs: [&#010      
 * {title: "tab1", pane: "pane1"},&#010         {title: "tab2"}&#010     ]&#010 });&#010 </pre>&#010 And in XML:&#010
 * <pre>&#010 &lt;TabSet&gt;&#010    &lt;tabs&gt;&#010        &lt;Tab title="tab1" pane="pane1"/&gt;&#010        &lt;Tab
 * title="tab2"/&gt;&#010    &lt;/tabs&gt;&#010 &lt;/TabSet&gt;&#010 </pre>
 */
public class Tab extends RefDataClass  implements com.smartgwt.client.widgets.tab.events.HasTabDeselectedHandlers, com.smartgwt.client.widgets.tab.events.HasTabSelectedHandlers {

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
        setID(com.smartgwt.client.util.SC.generateID(getClass().getName()));
    }

    public Tab(JavaScriptObject jsObj){
        super(jsObj);
    }

    public Tab(String title) {
        setTitle(title);
        setID(com.smartgwt.client.util.SC.generateID(getClass().getName()));
    }

    public Tab(String title, String icon) {
        setTitle(title);
		setIcon(icon);
        setID(com.smartgwt.client.util.SC.generateID(getClass().getName()));
    }

    // ********************* Properties / Attributes ***********************

    /**
     * Determines whether this tab should show an icon allowing the user to dismiss the tab by clicking on it directly. The URL
     * for this icon's image will be derived from  {@link com.smartgwt.client.widgets.tab.TabSet#getCloseTabIcon closeTabIcon}
     * by default, but may be overridden by explicitly specifying {@link com.smartgwt.client.widgets.tab.Tab#getCloseIcon
     * closeIcon}. <P> If unset, this property is derived from {@link com.smartgwt.client.widgets.tab.TabSet#getCanCloseTabs
     * canCloseTabs}
     *
     * @param canClose canClose Default value is null
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#layout_tabs_closeable" target="examples">Closeable Tabs Example</a>
     */
    public void setCanClose(Boolean canClose) {
        setAttribute("canClose", canClose);
    }

    /**
     * Determines whether this tab should show an icon allowing the user to dismiss the tab by clicking on it directly. The URL
     * for this icon's image will be derived from  {@link com.smartgwt.client.widgets.tab.TabSet#getCloseTabIcon closeTabIcon}
     * by default, but may be overridden by explicitly specifying {@link com.smartgwt.client.widgets.tab.Tab#getCloseIcon
     * closeIcon}. <P> If unset, this property is derived from {@link com.smartgwt.client.widgets.tab.TabSet#getCanCloseTabs
     * canCloseTabs}
     *
     *
     * @return Boolean
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#layout_tabs_closeable" target="examples">Closeable Tabs Example</a>
     */
    public Boolean getCanClose()  {
        return getAttributeAsBoolean("canClose");
    }

    /**
     * Custom src for the close icon for this tab to display if it is closeable. See {@link
     * com.smartgwt.client.widgets.tab.Tab#getCanClose canClose} and {@link
     * com.smartgwt.client.widgets.tab.TabSet#getCanCloseTabs canCloseTabs}.
     *
     * @param closeIcon closeIcon Default value is null
     */
    public void setCloseIcon(String closeIcon) {
        setAttribute("closeIcon", closeIcon);
    }

    /**
     * Custom src for the close icon for this tab to display if it is closeable. See {@link
     * com.smartgwt.client.widgets.tab.Tab#getCanClose canClose} and {@link
     * com.smartgwt.client.widgets.tab.TabSet#getCanCloseTabs canCloseTabs}.
     *
     *
     * @return String
     */
    public String getCloseIcon()  {
        return getAttributeAsString("closeIcon");
    }

    /**
     * Optional ID for the tab, which can later be used to reference the tab. APIs requiring a reference to a tab will accept
     * the tabs ID  [including  {@link com.smartgwt.client.widgets.tab.TabSet#selectTab TabSet.selectTab}, {@link
     * com.smartgwt.client.widgets.tab.TabSet#updateTab TabSet.updateTab}, {@link
     * com.smartgwt.client.widgets.tab.TabSet#removeTab TabSet.removeTab}].<br> The ID will also be passed to the {@link
     * com.smartgwt.client.widgets.tab.TabSet#addTabSelectedHandler TabSet.tabSelected} and {@link
     * com.smartgwt.client.widgets.tab.TabSet#addTabDeselectedHandler TabSet.tabDeselected} handler functions, if specified.
     * <p> Note that if you provide an ID, it must be globally unique.
     *
     * @param ID ID Default value is null
     */
    public void setID(String ID) {
        setAttribute("ID", ID);
    }

    /**
     * Optional ID for the tab, which can later be used to reference the tab. APIs requiring a reference to a tab will accept
     * the tabs ID  [including  {@link com.smartgwt.client.widgets.tab.TabSet#selectTab TabSet.selectTab}, {@link
     * com.smartgwt.client.widgets.tab.TabSet#updateTab TabSet.updateTab}, {@link
     * com.smartgwt.client.widgets.tab.TabSet#removeTab TabSet.removeTab}].<br> The ID will also be passed to the {@link
     * com.smartgwt.client.widgets.tab.TabSet#addTabSelectedHandler TabSet.tabSelected} and {@link
     * com.smartgwt.client.widgets.tab.TabSet#addTabDeselectedHandler TabSet.tabDeselected} handler functions, if specified.
     * <p> Note that if you provide an ID, it must be globally unique.
     *
     *
     * @return String
     */
    public String getID()  {
        return getAttributeAsString("ID");
    }

    /**
     * If {@link com.smartgwt.client.widgets.tab.TabSet#getShowTabPicker showTabPicker} is true for this TabSet, if set this
     * property will determine the title of the picker menu item for this tab. If unset, {@link
     * com.smartgwt.client.widgets.tab.Tab#getTitle title} will be used instead
     *
     * @param pickerTitle pickerTitle Default value is null
     */
    public void setPickerTitle(String pickerTitle) {
        setAttribute("pickerTitle", pickerTitle);
    }

    /**
     * If {@link com.smartgwt.client.widgets.tab.TabSet#getShowTabPicker showTabPicker} is true for this TabSet, if set this
     * property will determine the title of the picker menu item for this tab. If unset, {@link
     * com.smartgwt.client.widgets.tab.Tab#getTitle title} will be used instead
     *
     *
     * @return String
     */
    public String getPickerTitle()  {
        return getAttributeAsString("pickerTitle");
    }

    /**
     * You can specify an explicit width for the tab using this property.  Note that tabs automatically size to make room for
     * the full title, but if you want to e.g. specify a uniform width for all tabs in a TabSet, this property enables you to
     * do so.
     *
     * @param width width Default value is 100
     */
    public void setWidth(int width) {
        setAttribute("width", width);
    }

    /**
     * You can specify an explicit width for the tab using this property.  Note that tabs automatically size to make room for
     * the full title, but if you want to e.g. specify a uniform width for all tabs in a TabSet, this property enables you to
     * do so.
     *
     *
     * @return int
     */
    public int getWidth()  {
        return getAttributeAsInt("width");
    }

    // ********************* Methods ***********************
    /**
     * Add a tabDeselected handler.
     * <p>
     * Optional handler to fire when a tab is deselected. Returning false will cancel the new selection, leaving this tab
     * selected. As with {@link com.smartgwt.client.widgets.tab.TabSet#addTabSelectedHandler TabSet.tabSelected} this method
     * only fires when the tabset is drawn.
     *
     * @param handler the tabDeselected handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addTabDeselectedHandler(com.smartgwt.client.widgets.tab.events.TabDeselectedHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.tab.events.TabDeselectedEvent.getType()) == 0) setupTabDeselectedEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.tab.events.TabDeselectedEvent.getType());
    }

    private native void setupTabDeselectedEvent() /*-{
        var obj = null;
            obj = this.@com.smartgwt.client.core.DataClass::getJsObj()();
            var selfJ = this;
            obj.tabDeselected = $debox($entry(function(){
                var param = {"tabSet" : arguments[0], "tabNum" : arguments[1], "tabPane" : arguments[2], "ID" : arguments[3], "tab" : arguments[4], "newTab" : arguments[5]};
                var event = @com.smartgwt.client.widgets.tab.events.TabDeselectedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                selfJ.@com.smartgwt.client.core.DataClass::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                return !ret;
            }));
   }-*/;
    /**
     * Add a tabSelected handler.
     * <p>
     * Optional handler to fire when a tab is selected. As with {@link
     * com.smartgwt.client.widgets.tab.TabSet#addTabSelectedHandler TabSet.tabSelected} this method only fires when the tabset
     * is drawn.
     *
     * @param handler the tabSelected handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addTabSelectedHandler(com.smartgwt.client.widgets.tab.events.TabSelectedHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.tab.events.TabSelectedEvent.getType()) == 0) setupTabSelectedEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.tab.events.TabSelectedEvent.getType());
    }

    private native void setupTabSelectedEvent() /*-{
        var obj = null;
            obj = this.@com.smartgwt.client.core.DataClass::getJsObj()();
            var selfJ = this;
            obj.tabSelected = $entry(function(){
                var param = {"tabSet" : arguments[0], "tabNum" : arguments[1], "tabPane" : arguments[2], "ID" : arguments[3], "tab" : arguments[4]};
                var event = @com.smartgwt.client.widgets.tab.events.TabSelectedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                selfJ.@com.smartgwt.client.core.DataClass::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            });
   }-*/;

    // ********************* Static Methods ***********************
        
    // ***********************************************************        


    /**
     * Specifies the title of the this tab.  To change the title after the TabSet has been created, call {@link
     * com.smartgwt.client.widgets.tab.TabSet#setTabTitle TabSet.setTabTitle}.
     *
     * @param title title Default value is null
     */
    public void setTitle(String title) {
        if(tabSet == null || !tabSet.isDrawn()) {
            setAttribute("title", title);
        } else {
            tabSet.setTabTitle(this, title);
        }
    }

    /**
     * Specifies the title of the this tab.
     *
     * @return String
     */
    public String getTitle()  {
        if(tabSet == null || !tabSet.isDrawn()) {
            return getAttributeAsString("title");
        } else {
            return tabSet.getTab(getID()).getAttributeAsString("title");
        }
    }
    
    /**
     * If specified, this tab will initially be rendered in a disabled state.
     *
     * @param disabled disabled Default value is null
     */
    public void setDisabled(boolean disabled) {
        if(tabSet == null || !tabSet.isDrawn()) {
            setAttribute("disabled", disabled);
        } else {
            if(disabled) {
                tabSet.disableTab(getID());
            } else {
                tabSet.enableTab(getID());
            }
        }
    }

    /**
     * If specified, this tab will initially be rendered in a disabled state. To enable or disable tabs on the fly use the
     * {@link com.smartgwt.client.widgets.tab.TabSet#enableTab TabSet.enableTab}, and {@link
     * com.smartgwt.client.widgets.tab.TabSet#disableTab TabSet.disableTab} methods.
     *
     *
     * @return Boolean
     */
    public Boolean getDisabled()  {
        if(tabSet == null || !tabSet.isDrawn()) {
            return getAttributeAsBoolean("disabled");
        } else {
            return tabSet.getTab(getID()).getAttributeAsBoolean("disabled");
        }
    }

    /**
     * If specified, this tab will show an icon next to the tab title.  Note that as with  {@link
     * com.smartgwt.client.widgets.Button#getIcon icon}, the URL of a tabs icon will be updated to reflect disabled state.<br>
     * If desired a click handler may be assigned to the icon, which will be fired when the user clicks the tab. This method
     * takes a single parameter <code>tab</code>, a pointer to the tab object.
     *
     * @param icon icon Default value is null
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#layout_tabs_orientation" target="examples">Orientation Example</a>
     */
    public void setIcon(String icon) {
        if(tabSet == null || !tabSet.isDrawn()) {
            setAttribute("icon", icon);
        } else {
            tabSet.setTabIcon(getID(), icon);
        }
    }

    /**
     * If specified, this tab will show an icon next to the tab title.  Note that as with  {@link
     * com.smartgwt.client.widgets.Button#getIcon icon}, the URL of a tabs icon will be updated to reflect disabled state.<br>
     * If desired a click handler may be assigned to the icon, which will be fired when the user clicks the tab. This method
     * takes a single parameter <code>tab</code>, a pointer to the tab object.
     *
     *
     * @return String
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#layout_tabs_orientation" target="examples">Orientation Example</a>
     */
    public String getIcon()  {
        if(tabSet == null || !tabSet.isDrawn()) {
            return getAttributeAsString("icon");
        } else {
            return tabSet.getTab(getID()).getAttributeAsString("icon");
        }
    }
    
    public void setCanClose(boolean canClose) {
        setAttribute("canClose", canClose);
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

    /**
     * Context menu to show for this tab.
     *
     * @param contextMenu contextMenu Default value is null
     */
    public void setContextMenu(Menu contextMenu) {
        setAttribute("contextMenu", contextMenu.getOrCreateJsObj());
    }

    /**
     * Context menu to show for this object, an instance of the Menu widget.
     *
     * @return Menu
     */
    public Menu getContextMenu()  {
        return Menu.getOrCreateRef(getAttributeAsJavaScriptObject("contextMenu"));
    }

    private TabSet tabSet;

    public TabSet getTabSet() {
        return tabSet;
    }

    public void setTabSet(TabSet tabSet) {
        this.tabSet = tabSet;
    }

    private static boolean isTab(JavaScriptObject jsObj) {
        Object ref = JSOHelper.getAttributeAsObject((JavaScriptObject) jsObj, SC.REF);
        return ref instanceof Tab;
    }

    private static TabSet getTabSet(JavaScriptObject jsObj) {
        Object ref = JSOHelper.getAttributeAsObject((JavaScriptObject) jsObj, SC.REF);
        if(ref instanceof Tab) {
            return ((Tab) ref).getTabSet();
        } else {
            return null;
        }
    }

}





