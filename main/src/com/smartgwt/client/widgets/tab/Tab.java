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
/* sgwtgen */
 
package com.smartgwt.client.widgets.tab;


import com.smartgwt.client.event.*;
import com.smartgwt.client.core.*;
import com.smartgwt.client.types.*;
import com.smartgwt.client.data.*;
import com.smartgwt.client.data.events.*;
import com.smartgwt.client.rpc.*;
import com.smartgwt.client.callbacks.*;
import com.smartgwt.client.tools.*;
import com.smartgwt.client.bean.*;
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
import com.smartgwt.client.widgets.rte.*;
import com.smartgwt.client.widgets.rte.events.*;
import com.smartgwt.client.widgets.ace.*;
import com.smartgwt.client.widgets.ace.events.*;
import com.smartgwt.client.widgets.tab.*;
import com.smartgwt.client.widgets.toolbar.*;
import com.smartgwt.client.widgets.tree.*;
import com.smartgwt.client.widgets.tree.events.*;
import com.smartgwt.client.widgets.tableview.*;
import com.smartgwt.client.widgets.viewer.*;
import com.smartgwt.client.widgets.calendar.*;
import com.smartgwt.client.widgets.calendar.events.*;
import com.smartgwt.client.widgets.cube.*;
import com.smartgwt.client.widgets.drawing.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;
import com.smartgwt.client.util.*;
import com.smartgwt.client.util.events.*;
import com.smartgwt.client.util.workflow.*;
import com.google.gwt.event.shared.*;
import com.google.gwt.event.shared.HasHandlers;

/**
 * Tab instances for use with {@link com.smartgwt.client.widgets.tab.TabSet}. Tab  instances specify the appearance ({@link
 * com.smartgwt.client.widgets.tab.Tab#setTitle setTitle},  {@link com.smartgwt.client.widgets.tab.Tab#setIcon setIcon}) of
 * the tab, and provide  the tab's {@link com.smartgwt.client.widgets.tab.Tab#getPane pane}. See  {@link
 * com.smartgwt.client.widgets.tab.TabSet#setTabs setTabs} for  further details.
 */
@BeanFactory.FrameworkClass
public class Tab extends RefDataClass implements com.smartgwt.client.widgets.tab.events.HasTabDeselectedHandlers, com.smartgwt.client.widgets.tab.events.HasTabSelectedHandlers {

    public static Tab getOrCreateRef(JavaScriptObject jsObj) {
        if (jsObj == null) return null;

        final RefDataClass existingObj = RefDataClass.getRef(jsObj);

        if (existingObj instanceof Tab) {
            existingObj.setJsObj(jsObj);
            return (Tab)existingObj;
        } else

        {
            return new Tab(jsObj);
        }
    }
        


    public Tab(){
        final String className = SC.getAUTOIDClass(getClass().getName());
                        setAttribute("AUTOIDClass", className);
                        internalSetID(SC.generateID(className), true, true);
    }

    public Tab(JavaScriptObject jsObj){
        
        setJavaScriptObject(jsObj);
    }


    public Tab(String title) {
        setTitle(title);
                final String className = SC.getAUTOIDClass(getClass().getName());
                        setAttribute("AUTOIDClass", className);
                        internalSetID(SC.generateID(className), true, true);
    }


    public Tab(String title, String icon) {
        setTitle(title);
		setIcon(icon);
                final String className = SC.getAUTOIDClass(getClass().getName());
                        setAttribute("AUTOIDClass", className);
                        internalSetID(SC.generateID(className), true, true);
    }


    // ********************* Properties / Attributes ***********************

    /**
     * If enabled, the tab will collapse to show just its icon when showing the title would cause overflow of a containing
     * {@link com.smartgwt.client.widgets.tab.TabBar}.
     *
     * @param canAdaptWidth New canAdaptWidth value. Default value is false
     * @see com.smartgwt.client.widgets.Button#setCanAdaptWidth
     * @see com.smartgwt.client.widgets.Canvas#setCanAdaptWidth
     */
    public void setCanAdaptWidth(Boolean canAdaptWidth) {
        setAttribute("canAdaptWidth", canAdaptWidth);
    }

    /**
     * If enabled, the tab will collapse to show just its icon when showing the title would cause overflow of a containing
     * {@link com.smartgwt.client.widgets.tab.TabBar}.
     *
     * @return Current canAdaptWidth value. Default value is false
     * @see com.smartgwt.client.widgets.Button#getCanAdaptWidth
     * @see com.smartgwt.client.widgets.Canvas#getCanAdaptWidth
     */
    public Boolean getCanAdaptWidth()  {
        Boolean result = getAttributeAsBoolean("canAdaptWidth", true);
        return result == null ? false : result;
    }
    

    /**
     * Determines whether this tab should show a close icon allowing the user to dismiss the tab by clicking on the close icon
     * directly. The URL for the close icon's image will be derived from  {@link
     * com.smartgwt.client.widgets.tab.TabSet#getCloseTabIcon TabSet.closeTabIcon} by default, but may be overridden by
     * explicitly specifying {@link com.smartgwt.client.widgets.tab.Tab#getCloseIcon closeIcon}. <p> If unset or null, this
     * property is derived from {@link com.smartgwt.client.widgets.tab.TabSet#getCanCloseTabs TabSet.canCloseTabs}. <p> Note
     * that setting <code>canClose</code> means that {@link com.smartgwt.client.widgets.tab.Tab#getIcon icon} cannot be used,
     * because it's used for the {@link com.smartgwt.client.widgets.tab.Tab#getCloseIcon closeIcon} - see {@link
     * com.smartgwt.client.widgets.tab.TabSet#getCanCloseTabs TabSet.canCloseTabs} for a workaround.
     *
     * @return Current canClose value. Default value is null
     * @see com.smartgwt.client.widgets.tab.TabSet#closeClick
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#layout_tabs_closeable" target="examples">Closeable Tabs Example</a>
     */
    public Boolean getCanClose()  {
        return getAttributeAsBoolean("canClose", true);
    }
    

    /**
     * If specified, overrides the {@link com.smartgwt.client.widgets.tab.TabSet#getCanEditTabTitles TabSet.canEditTabTitles}
     * setting, for this one tab only. <p> Note that the TabSet's {@link
     * com.smartgwt.client.widgets.tab.TabSet#getTitleEditEvent titleEditEvent} must be set to a supported {@link
     * com.smartgwt.client.types.TabTitleEditEvent} in order for users to be able to edit this tab's title.
     *
     * @return Current canEditTitle value. Default value is null
     * @see com.smartgwt.client.widgets.tab.TabSet#getCanEditTabTitles
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#layout_tabs_title_editable" target="examples">User-Editable Titles Example</a>
     */
    public Boolean getCanEditTitle()  {
        return getAttributeAsBoolean("canEditTitle", true);
    }
    

    /**
     * If {@link com.smartgwt.client.widgets.tab.TabSet#getCanReorderTabs TabSet.canReorderTabs} is set to <code>true</code>,
     * setting <code>canReorder</code> explicitly to <code>false</code> for some tab will disallow drag-reordering of this tab.
     * Has no effect if <code>canReorderTabs</code> is not true at the tabSet level. <P> Note that this setting also disallows
     * a reorder of another tab into the slot before or following this tab. This means for tabs located at the beginning or end
     * of the  tab-bar, users cannot changing the index of the tab by dropping another before or after it. However if you have
     * a <i><code>canReorder:false</code></i> tab which is not at the beginning or end of the tab bar, users can drag reorder
     * other tabs around it which may ultimately change its position.
     *
     * @param canReorder New canReorder value. Default value is null
     * @see com.smartgwt.client.widgets.tab.TabSet#setCanReorderTabs
     */
    public void setCanReorder(Boolean canReorder) {
        setAttribute("canReorder", canReorder);
    }

    /**
     * If {@link com.smartgwt.client.widgets.tab.TabSet#getCanReorderTabs TabSet.canReorderTabs} is set to <code>true</code>,
     * setting <code>canReorder</code> explicitly to <code>false</code> for some tab will disallow drag-reordering of this tab.
     * Has no effect if <code>canReorderTabs</code> is not true at the tabSet level. <P> Note that this setting also disallows
     * a reorder of another tab into the slot before or following this tab. This means for tabs located at the beginning or end
     * of the  tab-bar, users cannot changing the index of the tab by dropping another before or after it. However if you have
     * a <i><code>canReorder:false</code></i> tab which is not at the beginning or end of the tab bar, users can drag reorder
     * other tabs around it which may ultimately change its position.
     *
     * @return Current canReorder value. Default value is null
     * @see com.smartgwt.client.widgets.tab.TabSet#getCanReorderTabs
     */
    public Boolean getCanReorder()  {
        return getAttributeAsBoolean("canReorder", true);
    }
    

    /**
     * Custom src for the close icon for this tab to display if it is closeable. See {@link
     * com.smartgwt.client.widgets.tab.Tab#getCanClose canClose} and {@link
     * com.smartgwt.client.widgets.tab.TabSet#getCanCloseTabs TabSet.canCloseTabs}.
     *
     * @return Current closeIcon value. Default value is null
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     */
    public String getCloseIcon()  {
        return getAttributeAsString("closeIcon");
    }
    

    /**
     * Size of the {@link com.smartgwt.client.widgets.tab.Tab#getCloseIcon closeIcon} for this tab. If unspecified the icon
     * will be sized according to {@link com.smartgwt.client.widgets.tab.TabSet#getCloseTabIconSize TabSet.closeTabIconSize}
     *
     * @return Current closeIconSize value. Default value is null
     */
    public Integer getCloseIconSize()  {
        return getAttributeAsInt("closeIconSize");
    }
    

    /**
     * If specified, this tab will initially be rendered in a disabled state.  methods.
     *
     * @return Current disabled value. Default value is null
     */
    public Boolean getDisabled()  {
        return getAttributeAsBoolean("disabled", true);
    }
    

    /**
     * Criteria to be evaluated to determine whether this Tab should be enabled.  Re-evaluated whenever data in the {@link
     * com.smartgwt.client.widgets.Canvas#getRuleScope tab.ruleScope} changes. <P> It works the same as {@link
     * com.smartgwt.client.widgets.Canvas#getEnableWhen Canvas.enableWhen}
     *
     * @param enableWhen New enableWhen value. Default value is null
     * @see com.smartgwt.client.docs.RuleCriteria RuleCriteria overview and related methods
     */
    public void setEnableWhen(AdvancedCriteria enableWhen) {
        if (enableWhen instanceof Criterion) {
            enableWhen.setAttribute("_constructor", "AdvancedCriteria");
        }
        setAttribute("enableWhen", enableWhen == null ? null : enableWhen.getJsObj());
    }

    /**
     * Criteria to be evaluated to determine whether this Tab should be enabled.  Re-evaluated whenever data in the {@link
     * com.smartgwt.client.widgets.Canvas#getRuleScope tab.ruleScope} changes. <P> It works the same as {@link
     * com.smartgwt.client.widgets.Canvas#getEnableWhen Canvas.enableWhen}
     *
     * @return Current enableWhen value. Default value is null
     * @see com.smartgwt.client.docs.RuleCriteria RuleCriteria overview and related methods
     */
    public AdvancedCriteria getEnableWhen()  {
        return new AdvancedCriteria(getAttributeAsJavaScriptObject("enableWhen"));
    }
    

    /**
     * If specified, this tab will show an icon next to the tab title.   <p> <b>NOTE:</b> if you enable {@link
     * com.smartgwt.client.widgets.tab.TabSet#getCanCloseTabs closeable tabs}, <code>tab.icon</code> is used for the close
     * icon.  {@link com.smartgwt.client.widgets.tab.TabSet#getCanCloseTabs TabSet.canCloseTabs} describes a workaround to
     * enable both a <code>closeIcon</code> and a second icon to be shown. <p> Use {@link
     * com.smartgwt.client.widgets.tab.TabSet#addTabIconClickHandler TabSet.tabIconClick()} to add an event handler
     * specifically for clicks on the icon. <p> If a tab {@link com.smartgwt.client.widgets.tab.Tab#getDisabled becomes
     * disabled}, a different icon will be loaded by adding a suffix to the image name (see {@link
     * com.smartgwt.client.widgets.Button#getIcon Button.icon}). <p> You should specify a size for the icon via {@link
     * com.smartgwt.client.widgets.tab.Tab#getIconSize iconSize} or {@link com.smartgwt.client.widgets.tab.Tab#getIconWidth
     * iconWidth} and {@link com.smartgwt.client.widgets.tab.Tab#getIconHeight iconHeight}. Without an explicitly specified
     * size, tabs may be drawn overlapping or with gaps the first time a page is loaded, because the icon is not cached and
     * therefore its size isn't known.
     *
     * @return Current icon value. Default value is null
     * @see com.smartgwt.client.widgets.tab.events.TabClickEvent
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#layout_tabs_orientation" target="examples">Orientation Example</a>
     */
    public String getIcon()  {
        return getAttributeAsString("icon");
    }
    

    /**
     * If {@link com.smartgwt.client.widgets.tab.Tab#getIcon icon} is specified, this property may be used to specify a height
     * for the icon.
     *
     * @return Current iconHeight value. Default value is null
     */
    public Integer getIconHeight()  {
        return getAttributeAsInt("iconHeight");
    }
    

    /**
     * If {@link com.smartgwt.client.widgets.tab.Tab#getIcon icon} is specified, this property may be used to specify a size
     * for the icon. Per side sizing may be specified instead via {@link com.smartgwt.client.widgets.tab.Tab#getIconWidth
     * iconWidth} and {@link com.smartgwt.client.widgets.tab.Tab#getIconHeight iconHeight}.
     *
     * @return Current iconSize value. Default value is 16
     */
    public Integer getIconSize()  {
        return getAttributeAsInt("iconSize");
    }
    

    /**
     * If {@link com.smartgwt.client.widgets.tab.Tab#getIcon icon} is specified, this property may be used to specify a width
     * for the icon.
     *
     * @return Current iconWidth value. Default value is null
     */
    public Integer getIconWidth()  {
        return getAttributeAsInt("iconWidth");
    }
    
    

    /**
     * Optional name for the tab, which can later be used to reference the tab. APIs requiring a reference to a tab will accept
     * the tab's name [including  {@link com.smartgwt.client.widgets.tab.TabSet#selectTab TabSet.selectTab()}, {@link
     * com.smartgwt.client.widgets.tab.TabSet#updateTab TabSet.updateTab()}, {@link
     * com.smartgwt.client.widgets.tab.TabSet#removeTab TabSet.removeTab()}].<br> This name will also be passed to the {@link
     * com.smartgwt.client.widgets.tab.TabSet#addTabSelectedHandler TabSet.tabSelected()} and {@link
     * com.smartgwt.client.widgets.tab.TabSet#addTabDeselectedHandler TabSet.tabDeselected()} handler functions, if specified.
     * <p> This identifier is requred to be locally unique to the TabSet and cannot be used to get a global reference to the
     * Tab.  If you want a global reference, set {@link com.smartgwt.client.widgets.tab.Tab#getID ID} instead.
     *
     * @param name New name value. Default value is null
     * @see com.smartgwt.client.docs.TabName TabName 
     */
    public void setName(String name) {
        setAttribute("name", name);
    }

    /**
     * Optional name for the tab, which can later be used to reference the tab. APIs requiring a reference to a tab will accept
     * the tab's name [including  {@link com.smartgwt.client.widgets.tab.TabSet#selectTab TabSet.selectTab()}, {@link
     * com.smartgwt.client.widgets.tab.TabSet#updateTab TabSet.updateTab()}, {@link
     * com.smartgwt.client.widgets.tab.TabSet#removeTab TabSet.removeTab()}].<br> This name will also be passed to the {@link
     * com.smartgwt.client.widgets.tab.TabSet#addTabSelectedHandler TabSet.tabSelected()} and {@link
     * com.smartgwt.client.widgets.tab.TabSet#addTabDeselectedHandler TabSet.tabDeselected()} handler functions, if specified.
     * <p> This identifier is requred to be locally unique to the TabSet and cannot be used to get a global reference to the
     * Tab.  If you want a global reference, set {@link com.smartgwt.client.widgets.tab.Tab#getID ID} instead.
     *
     * @return Current name value. Default value is null
     * @see com.smartgwt.client.docs.TabName TabName 
     */
    public String getName()  {
        return getAttributeAsString("name");
    }
    

    /**
     * Specifies the pane associated with this tab.  You have two options for the value of the pane attribute: <ul>
     * <li><b>ID</b> - The global ID of an already created Canvas (or subclass). <li><b>Canvas</b> - A live instance of a
     * Canvas (or subclass). </ul>
     *
     * @return Current pane value. Default value is null
     * @see com.smartgwt.client.widgets.tab.TabSet#updateTab
     */
    public Canvas getPane()  {
        return (Canvas)Canvas.getByJSObject(getAttributeAsJavaScriptObject("pane"));
    }
    

    /**
     * Space to leave around the pane within this Tab. If specified, this property takes precedence over {@link
     * com.smartgwt.client.widgets.tab.TabSet#getPaneMargin TabSet.paneMargin}
     *
     * @param paneMargin New paneMargin value. Default value is null
     */
    public void setPaneMargin(Integer paneMargin) {
        setAttribute("paneMargin", paneMargin);
    }

    /**
     * Space to leave around the pane within this Tab. If specified, this property takes precedence over {@link
     * com.smartgwt.client.widgets.tab.TabSet#getPaneMargin TabSet.paneMargin}
     *
     * @return Current paneMargin value. Default value is null
     */
    public Integer getPaneMargin()  {
        return getAttributeAsInt("paneMargin");
    }
    

    /**
     * If {@link com.smartgwt.client.widgets.tab.TabSet#getShowTabPicker TabSet.showTabPicker} is true for this TabSet, if set
     * this property will determine the title of the picker menu item for this tab. If unset, {@link
     * com.smartgwt.client.widgets.tab.Tab#getTitle title} will be used instead.
     *
     * @return Current pickerTitle value. Default value is null
     * @see com.smartgwt.client.widgets.tab.TabSet#getShowTabPicker
     * @see com.smartgwt.client.widgets.tab.Tab#getTitle
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public String getPickerTitle()  {
        return getAttributeAsString("pickerTitle");
    }
    

    /**
     * Specifies the prompt to be displayed when the mouse hovers over the tab.
     *
     * @return Current prompt value. Default value is null
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public String getPrompt()  {
        return getAttributeAsString("prompt");
    }
    

    /**
     * Specifies the title of the this tab.
     *
     * @return Current title value. Default value is null
     * @see com.smartgwt.client.widgets.tab.TabSet#setTabTitle
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public String getTitle()  {
        return getAttributeAsString("title");
    }
    

    /**
     * You can specify an explicit width for the tab using this property.  Note that tabs automatically size to make room for
     * the full title, but if you want to e.g. specify a uniform width for all tabs in a TabSet, this property enables you to
     * do so. <p>
     *
     * @return Current width value. Default value is 100
     */
    public int getWidth()  {
        return getAttributeAsInt("width");
    }
    

    // ********************* Methods ***********************
    /**
     * Add a tabDeselected handler.
     * <p>
     * Optional handler to fire when a tab is deselected.  Calling {@link
     * com.smartgwt.client.widgets.tab.events.TabDeselectedEvent#cancel}  will cancel the new selection, leaving this tab
     * selected. As with {@link com.smartgwt.client.widgets.tab.TabSet#addTabSelectedHandler TabSet.tabSelected()} this method
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
        var obj;
        obj = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        var selfJ = this;
        var tabDeselected = $debox($entry(function(param){
            var event = @com.smartgwt.client.widgets.tab.events.TabDeselectedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.core.DataClass::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            selfJ.@com.smartgwt.client.widgets.tab.Tab::handleTearDownTabDeselectedEvent()();
            var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
            return !ret;
            }));
        obj.tabDeselected = 
            function () {
                var param = {"_this": this, "tabSet" : arguments[0], "tabNum" : arguments[1], "tabPane" : arguments[2], "ID" : arguments[3], "tab" : arguments[4], "newTab" : arguments[5], "name" : arguments[6]};
                return tabDeselected(param) == true;
            }
        ;
    }-*/;

    private void handleTearDownTabDeselectedEvent() {
        if (getHandlerCount(com.smartgwt.client.widgets.tab.events.TabDeselectedEvent.getType()) == 0) tearDownTabDeselectedEvent();
    }

    private native void tearDownTabDeselectedEvent() /*-{
        var obj;
        obj = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        if (obj && "tabDeselected" in obj) delete obj.tabDeselected;
    }-*/;

    /**
     * Add a tabSelected handler.
     * <p>
     * Optional handler to fire when a tab is selected. As with {@link
     * com.smartgwt.client.widgets.tab.TabSet#addTabSelectedHandler TabSet.tabSelected()} this method only fires when the
     * tabset is drawn.
     *
     * @param handler the tabSelected handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addTabSelectedHandler(com.smartgwt.client.widgets.tab.events.TabSelectedHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.tab.events.TabSelectedEvent.getType()) == 0) setupTabSelectedEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.tab.events.TabSelectedEvent.getType());
    }

    private native void setupTabSelectedEvent() /*-{
        var obj;
        obj = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        var selfJ = this;
        var tabSelected = $entry(function(){
            var param = {"_this": this, "tabSet" : arguments[0], "tabNum" : arguments[1], "tabPane" : arguments[2], "ID" : arguments[3], "tab" : arguments[4], "name" : arguments[5]};
            var event = @com.smartgwt.client.widgets.tab.events.TabSelectedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.core.DataClass::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            selfJ.@com.smartgwt.client.widgets.tab.Tab::handleTearDownTabSelectedEvent()();
            });
        obj.tabSelected =  tabSelected 
        ;
    }-*/;

    private void handleTearDownTabSelectedEvent() {
        if (getHandlerCount(com.smartgwt.client.widgets.tab.events.TabSelectedEvent.getType()) == 0) tearDownTabSelectedEvent();
    }

    private native void tearDownTabSelectedEvent() /*-{
        var obj;
        obj = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        if (obj && "tabSelected" in obj) delete obj.tabSelected;
    }-*/;


    // ********************* Static Methods ***********************

    // ***********************************************************


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
        internalSetID(ID, false, true);
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
        return this.id;
    }

    /**
     * Specifies the title of the this tab.  To change the title after the TabSet has been created, call {@link
     * com.smartgwt.client.widgets.tab.TabSet#setTabTitle TabSet.setTabTitle}.
     *
     * @param title title Default value is null
     */
    public void setTitle(String title) {
        if (tabSet == null || !tabSet.isCreated()) {
            setAttribute("title", title);
        } else {
            tabSet.setTabTitle(this, title);
        }
    }

    /**
     * If specified, this tab will initially be rendered in a disabled state.
     *
     * @param disabled disabled Default value is null
     */
    public void setDisabled(boolean disabled) {
        if (tabSet == null || !tabSet.isCreated()) {
            setAttribute("disabled", disabled);
        } else {
            if (disabled) {
                tabSet.disableTab(getID());
            } else {
                tabSet.enableTab(getID());
            }
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
        if (tabSet == null || !tabSet.isCreated()) {
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
     * @param icon icon Default value is null
     * @param iconWidth the icon width
     * @param iconHeight the icon height
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#layout_tabs_orientation" target="examples">Orientation Example</a>
     */
    public void setIcon(String icon, int iconWidth, int iconHeight) {
        setIcon(icon);
        setIconWidth(iconWidth);
        setIconHeight(iconHeight);
    }

    /**
     * If specified, this tab will show an icon next to the tab title.  Note that as with  {@link
     * com.smartgwt.client.widgets.Button#getIcon icon}, the URL of a tabs icon will be updated to reflect disabled state.<br>
     * If desired a click handler may be assigned to the icon, which will be fired when the user clicks the tab. This method
     * takes a single parameter <code>tab</code>, a pointer to the tab object.
     *
     * @param icon icon Default value is null
     * @param iconSize the icon size
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#layout_tabs_orientation" target="examples">Orientation Example</a>
     */
    public void setIcon(String icon, int iconSize) {
        setIcon(icon);
        setIconSize(iconSize);
    }

    /**
     * If {@link com.smartgwt.client.widgets.tab.Tab#getIcon icon} is specified, this property
     * may be used to specify a size for the icon. Per side sizing may be specified instead via
     * {@link com.smartgwt.client.widgets.tab.Tab#getIconWidth iconWidth} and 
     * {@link com.smartgwt.client.widgets.tab.Tab#getIconHeight iconHeight}.
     *
     * @param iconSize New iconSize value. Default value is 16
     */
    public void setIconSize(Integer iconSize) {
        if (tabSet == null || !tabSet.isCreated()) {
            setAttribute("iconSize", iconSize);
        } else {
            JavaScriptObject tabProperties = JSOHelper.createObject();
            JSOHelper.setAttribute(tabProperties, "iconSize", iconSize);
            tabSet.setTabProperties(this, tabProperties);
        }
    }

    /**
     * If {@link com.smartgwt.client.widgets.tab.Tab#getIcon icon} is specified, this property
     * may be used to specify a width for the icon.
     *
     * @param iconWidth New iconWidth value. Default value is null
     */
    public void setIconWidth(Integer iconWidth) {
        if (tabSet == null || !tabSet.isCreated()) {
            setAttribute("iconWidth", iconWidth);
        } else {
            JavaScriptObject tabProperties = JSOHelper.createObject();
            JSOHelper.setAttribute(tabProperties, "iconWidth", iconWidth);
            tabSet.setTabProperties(this, tabProperties);
        }
    }


    /**
     * If {@link com.smartgwt.client.widgets.tab.Tab#getIcon icon} is specified, this property
     * may be used to specify a height for the icon.
     *
     * @param iconHeight New iconHeight value. Default value is null
     */
    public void setIconHeight(Integer iconHeight) {
        if (tabSet == null || !tabSet.isCreated()) {
            setAttribute("iconHeight", iconHeight);
        } else {
            JavaScriptObject tabProperties = JSOHelper.createObject();
            JSOHelper.setAttribute(tabProperties, "iconHeight", iconHeight);
            tabSet.setTabProperties(this, tabProperties);
        }
    }

    /**
     * If {@link com.smartgwt.client.widgets.tab.TabSet#getShowTabPicker TabSet.showTabPicker}
     * is true for this TabSet, if set this property will determine the title of the picker menu
     * item for this tab. If unset, {@link com.smartgwt.client.widgets.tab.Tab#getTitle title}
     * will be used instead
     *
     * @param pickerTitle New pickerTitle value. Default value is null
     * @see com.smartgwt.client.widgets.tab.TabSet#setShowTabPicker
     * @see com.smartgwt.client.widgets.tab.Tab#setTitle
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public void setPickerTitle(String pickerTitle) {
        if (tabSet == null || !tabSet.isCreated()) {
            setAttribute("pickerTitle", pickerTitle);
        } else {
            JavaScriptObject tabProperties = JSOHelper.createObject();
            JSOHelper.setAttribute(tabProperties, "pickerTitle", pickerTitle);
            tabSet.setTabProperties(this, tabProperties);
        }
    }

    /**
     * You can specify an explicit width for the tab using this property.  Note that tabs
     * automatically size to make room for the full title, but if you want to e.g. specify a
     * uniform width for all tabs in a TabSet, this property enables you to do so.
     *
     * @param width New width value. Default value is 100
     */
    public void setWidth(int width) {
        if (tabSet == null || !tabSet.isCreated()) {
            setAttribute("width", width);
        } else {
            JavaScriptObject tabProperties = JSOHelper.createObject();
            JSOHelper.setAttribute(tabProperties, "width", width);
            tabSet.setTabProperties(this, tabProperties);
        }
    }

    /**
     * Specifies the prompt to be displayed when the mouse hovers over the tab.
     *
     * @param prompt New prompt value. Default value is null
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public void setPrompt(String prompt) {
        if (tabSet == null || !tabSet.isCreated()) {
            setAttribute("prompt", prompt);
        } else {
            JavaScriptObject tabProperties = JSOHelper.createObject();
            JSOHelper.setAttribute(tabProperties, "prompt", prompt);
            tabSet.setTabProperties(this, tabProperties);
        }
    }

    /**
     * If specified, overrides the 
     * {@link com.smartgwt.client.widgets.tab.TabSet#getCanEditTabTitles TabSet.canEditTabTitles}
     * setting, for this one tab only.
     * <p> 
     * Note that the TabSet's 
     * {@link com.smartgwt.client.widgets.tab.TabSet#getTitleEditEvent titleEditEvent} must be
     * set to a supported {@link com.smartgwt.client.types.TabTitleEditEvent} in order for users
     * to be able to edit this tab's title.
     *
     * @param canEditTitle New canEditTitle value. Default value is null
     * @see com.smartgwt.client.widgets.tab.TabSet#setCanEditTabTitles
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#layout_tabs_title_editable" target="examples">User-Editable Titles Example</a>
     */
    public void setCanEditTitle(Boolean canEditTitle) {
        if (tabSet == null || !tabSet.isCreated()) {
            setAttribute("canEditTitle", canEditTitle);
        } else {
            JavaScriptObject tabProperties = JSOHelper.createObject();
            JSOHelper.setAttribute(tabProperties, "canEditTitle", canEditTitle);
            tabSet.setTabProperties(this, tabProperties);
        }
    }

    /**
     * Determines whether this tab should show a close icon allowing the user to dismiss the tab
     * by clicking on the close icon directly. The URL for the close icon's image will be{M{
     * derived from
     * {@link com.smartgwt.client.widgets.tab.TabSet#getCloseTabIcon TabSet.closeTabIcon} by
     * default, but may be overridden by explicitly specifying
     * {@link com.smartgwt.client.widgets.tab.Tab#getCloseIcon closeIcon}.
     * <p> 
     * If unset or null, this property is derived from
     * {@link com.smartgwt.client.widgets.tab.TabSet#getCanCloseTabs TabSet.canCloseTabs}.
     * <p> 
     * Note that setting <code>canClose</code> means that
     * {@link com.smartgwt.client.widgets.tab.Tab#getIcon icon} cannot be used, because it's
     * used for the {@link com.smartgwt.client.widgets.tab.Tab#getCloseIcon closeIcon} - see
     * {@link com.smartgwt.client.widgets.tab.TabSet#getCanCloseTabs TabSet.canCloseTabs} for a
     * workaround.
     *
     * @param canClose New canClose value. Default value is null
     * @see com.smartgwt.client.widgets.tab.TabSet#closeClick
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#layout_tabs_closeable" target="examples">Closeable Tabs Example</a>
     */
    public void setCanClose(Boolean canClose) {
        if (tabSet == null || !tabSet.isCreated()) {
            setAttribute("canClose", canClose);
        } else {
            tabSet.setCanCloseTab(this, canClose);
        }
    }

    /**
     * See {@link #setCanClose(Boolean) setCanClose()}.
     * @param canClose New canClose value.
     */
    public void setCanClose(boolean canClose) {
        setCanClose((Boolean)canClose);
    }

    
    /**
     * Custom src for the close icon for this tab to display if it is closeable. See {@link
     * com.smartgwt.client.widgets.tab.Tab#getCanClose canClose} and {@link
     * com.smartgwt.client.widgets.tab.TabSet#getCanCloseTabs TabSet.canCloseTabs}.
     *
     * @param closeIcon New closeIcon value. Default value is null
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     */
    public void setCloseIcon(String closeIcon) {
        setAttribute("closeIcon", closeIcon);
        if (tabSet != null && tabSet.isCreated()) {
            // calls tabBar.getCloseIconProperties()
            tabSet.setCanCloseTab(this, getCanClose());
        }
    }

    /**
     * Size of the {@link com.smartgwt.client.widgets.tab.Tab#getCloseIcon closeIcon} for this
     * tab. If unspecified the icon will be sized according to 
     * {@link com.smartgwt.client.widgets.tab.TabSet#getCloseTabIconSize TabSet.closeTabIconSize}
     *
     * @param closeIconSize New closeIconSize value. Default value is null
     */
    public void setCloseIconSize(Integer closeIconSize) {
        setAttribute("closeIconSize", closeIconSize);
        if (tabSet != null && tabSet.isCreated()) {
            // calls tabBar.getCloseIconProperties()
            tabSet.setCanCloseTab(this, getCanClose());
        }
    }

    public void setPaneID(String paneID) {
        setAttribute("pane", paneID);
    }

    /**
     * Provide a separate style for the title text. If set and the ImgTab is vertical, a "v" will be automatically
     * prepended to the style name (hence "tabTitle" -> "vtabTitle").
     *
     * @param titleStyle the title style
     */
    public void setTitleStyle(String titleStyle) {
        setAttribute("titleStyle", titleStyle);
    }

    /**
     * A separate style for the title text. If set and the ImgTab is vertical, a "v" will be automatically
     * prepended to the style name (hence "tabTitle" -> "vtabTitle").
     *
     * @return the title style
     */
    public String getTitleStyle() {
        return getAttribute("titleStyle");
    }

    /**
     * Specifies the pane associated with this tab. You can change the pane associated with a given tab after the TabSet
     * has been created by calling {@link com.smartgwt.client.widgets.tab.TabSet#updateTab(int, com.smartgwt.client.widgets.Canvas)}
     *
     * @param pane the tab pane
     */
    public void setPane(Canvas pane) {
        if (tabSet == null || !tabSet.isCreated()) {
            setAttribute("pane", pane.getOrCreateJsObj());
        } else {
            tabSet.updateTab(this, pane);
        }
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
        return (Menu)Menu.getByJSObject(getAttributeAsJavaScriptObject("contextMenu"));
    }

    private TabSet tabSet;

    public TabSet getTabSet() {
        return tabSet;
    }

    public void setTabSet(TabSet tabSet) {
        this.tabSet = tabSet;
    }

    private static boolean isTab(Object object) {
        return object instanceof Tab;
    }

    private static boolean isTab(JavaScriptObject jsObj) {
        Object ref = JSOHelper.getAttributeAsObject((JavaScriptObject) jsObj, SC.REF);
        return ref instanceof Tab;
    }

    private static TabSet getTabSet(JavaScriptObject jsObj) {
        Object ref = JSOHelper.getAttributeAsObject((JavaScriptObject) jsObj, SC.REF);
        if (ref instanceof Tab) {
            return ((Tab) ref).getTabSet();
        } else {
            return null;
        }
    }

    /**
     * Returns the live Canvas used to represent this tab in a tabSet.
     * Will return null if this Tab has not been added to a TabSet or if the tabset is not yet drawn.
     * <P>
     * The underlying SmartClient class of the returned canvas depends on {@link #getUseSimpleTabs}.
     * If this property is false, the returned canvas will be a {@link com.smartgwt.client.widgets.tab.ImgTab} 
     * instance. If true the canvas will be a {@link com.smartgwt.client.widgets.tab.Button} instance. 
     * Note that you can make use of ImgTab APIs by using the <code>getJsObj()</code> and <code>create()</code>
     * APIs to "cast" to the appropriate type - for example:<br>
     * <code>ImgTab liveTab = ImgTab.create(myTabSet.getTabCanvas(2).getJsObj());</code>
     * @return live Canvas for this tab in a tabSet.
     */
    public StatefulCanvas getTabCanvas () {
        if (tabSet == null) return null;
        JavaScriptObject canvasJS = this.getTabCanvasJS(tabSet.getJsObj(), this.getJsObj());
        if (canvasJS == null) return null;
        
        return (StatefulCanvas)Canvas.getByJSObject(canvasJS);
    }
    private native JavaScriptObject getTabCanvasJS (JavaScriptObject tabSet, JavaScriptObject tabConfig) /*-{
        if (tabSet == null || tabConfig == null) return null;
        var tab = tabSet.getTab(tabConfig);
        if ($wnd.isc.isA.Canvas(tab)) return tab;
        return null;
    }-*/;
    

}
