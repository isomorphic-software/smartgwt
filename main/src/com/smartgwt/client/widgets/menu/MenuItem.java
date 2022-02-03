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
 
package com.smartgwt.client.widgets.menu;


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
 * Object specifying an item in a {@link com.smartgwt.client.widgets.menu.Menu}.  Each <code>MenuItem</code> can have a
 * {@link com.smartgwt.client.widgets.menu.MenuItem#getTitle title}, {@link
 * com.smartgwt.client.widgets.menu.MenuItem#getIcon icon}, {@link com.smartgwt.client.widgets.menu.MenuItem#getKeys
 * shortcut\n keys}, optional {@link com.smartgwt.client.widgets.menu.MenuItem#getSubmenu submenu} and various other
 * settings.  Alternatively, a
 * <code>MenuItem</code> can contain an arbitrary widget via {@link
 * com.smartgwt.client.widgets.menu.MenuItem#getEmbeddedComponent embeddedComponent}.
 *  
 *  
 * To create a Menu, create a series of MenuItems and call {@link com.smartgwt.client.widgets.menu.Menu#setItems
 * Menu.setItems()}.
 *  
 *  <p>
 *  Alternatively, Menus support binding to a {@link com.smartgwt.client.widgets.menu.Menu#getDataSource DataSource}.
 *  <p>
 *  As another option, here's a sample of a Menu in {@link com.smartgwt.client.docs.ComponentXML Component XML}:
 *  <pre>
 *  &lt;Menu&gt;
 *     &lt;items&gt;
 *         &lt;MenuItem title="item1" click="alert(1)"/&gt;
 *         &lt;MenuItem title="item2"/&gt;
 *     &lt;/items&gt;
 *  &lt;/Menu&gt;
 *  </pre>
 */
@BeanFactory.FrameworkClass
public class MenuItem extends ListGridRecord implements com.smartgwt.client.widgets.menu.events.HasClickHandlers {

    public static MenuItem getOrCreateRef(JavaScriptObject jsObj) {
        if (jsObj == null) return null;

        final RefDataClass existingObj = RefDataClass.getRef(jsObj);

        if (existingObj instanceof MenuItem) {
            existingObj.setJsObj(jsObj);
            return (MenuItem)existingObj;
        } else

        {
            return new MenuItem(jsObj);
        }
    }
        


    public MenuItem(){
        
    }

    public MenuItem(JavaScriptObject jsObj){
        
        setJavaScriptObject(jsObj);
    }


    public MenuItem(String title) {
        setTitle(title);
                
    }


    public MenuItem(String title, String icon) {
        setTitle(title);
		setIcon(icon);
                
    }


    public MenuItem(String title, String icon, String keyTitle) {
        setTitle(title);
		setIcon(icon);
		setKeyTitle(keyTitle);
                
    }


    // ********************* Properties / Attributes ***********************

    /**
     * Whether a click on this specific <code>menuItem</code> automatically dismisses the menu.  See {@link
     * com.smartgwt.client.widgets.menu.Menu#getAutoDismiss Menu.autoDismiss}.
     *
     * @param autoDismiss New autoDismiss value. Default value is null
     */
    public void setAutoDismiss(Boolean autoDismiss) {
        setAttribute("autoDismiss", autoDismiss);
    }

    /**
     * Whether a click on this specific <code>menuItem</code> automatically dismisses the menu.  See {@link
     * com.smartgwt.client.widgets.menu.Menu#getAutoDismiss Menu.autoDismiss}.
     *
     * @return Current autoDismiss value. Default value is null
     */
    public Boolean getAutoDismiss()  {
        return getAttributeAsBoolean("autoDismiss", true);
    }
    

    /**
     * A MenuItem that has a submenu normally cannot be selected, instead clicking or hitting Enter while keyboard focus is on
     * the item shows the submenu.  Setting canSelectParent:true allows a menu item with a submenu to be selected directly.
     *
     * @param canSelectParent New canSelectParent value. Default value is null
     */
    public void setCanSelectParent(Boolean canSelectParent) {
        setAttribute("canSelectParent", canSelectParent);
    }

    /**
     * A MenuItem that has a submenu normally cannot be selected, instead clicking or hitting Enter while keyboard focus is on
     * the item shows the submenu.  Setting canSelectParent:true allows a menu item with a submenu to be selected directly.
     *
     * @return Current canSelectParent value. Default value is null
     */
    public Boolean getCanSelectParent()  {
        return getAttributeAsBoolean("canSelectParent", true);
    }
    

    /**
     * If true, this item displays a standard checkmark image to the left of its title.  You can set the checkmark image URL by
     * setting {@link com.smartgwt.client.widgets.menu.Menu#getCheckmarkImage Menu.checkmarkImage}. <p> If you need to set this
     * state dynamically, use {@link com.smartgwt.client.widgets.menu.MenuItem#checkIf checkIf()} instead.
     *
     * @param checked New checked value. Default value is null
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#menus_category_appearance" target="examples">Appearance Example</a>
     */
    public void setChecked(Boolean checked) {
        setAttribute("checked", checked);
    }

    /**
     * If true, this item displays a standard checkmark image to the left of its title.  You can set the checkmark image URL by
     * setting {@link com.smartgwt.client.widgets.menu.Menu#getCheckmarkImage Menu.checkmarkImage}. <p> If you need to set this
     * state dynamically, use {@link com.smartgwt.client.widgets.menu.MenuItem#checkIf checkIf()} instead.
     *
     * @return Current checked value. Default value is null
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#menus_category_appearance" target="examples">Appearance Example</a>
     */
    public Boolean getChecked()  {
        return getAttributeAsBoolean("checked", true);
    }
    

    /**
     * The filename for this item's custom icon when the item is disabled. If both this property and {@link
     * com.smartgwt.client.widgets.menu.MenuItem#getChecked checked} are both specified, only the icon specified by this
     * property will be displayed. The path to the loaded skin directory and the skinImgDir are prepended to this filename to
     * form the full URL. <p> If you need to set this state dynamically, use {@link
     * com.smartgwt.client.widgets.menu.MenuItem#dynamicIcon dynamicIcon()} instead.
     *
     * @param disabledIcon New disabledIcon value. Default value is null
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#menus_category_appearance" target="examples">Appearance Example</a>
     */
    public void setDisabledIcon(String disabledIcon) {
        setAttribute("disabledIcon", disabledIcon);
    }

    /**
     * The filename for this item's custom icon when the item is disabled. If both this property and {@link
     * com.smartgwt.client.widgets.menu.MenuItem#getChecked checked} are both specified, only the icon specified by this
     * property will be displayed. The path to the loaded skin directory and the skinImgDir are prepended to this filename to
     * form the full URL. <p> If you need to set this state dynamically, use {@link
     * com.smartgwt.client.widgets.menu.MenuItem#dynamicIcon dynamicIcon()} instead.
     *
     * @return Current disabledIcon value. Default value is null
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#menus_category_appearance" target="examples">Appearance Example</a>
     */
    public String getDisabledIcon()  {
        return getAttributeAsString("disabledIcon");
    }
    

    /**
     * Arbitrary UI component that should appear in this MenuItem.  See {@link
     * com.smartgwt.client.widgets.grid.ListGridRecord#getEmbeddedComponent ListGridRecord.embeddedComponent} for an overview
     * and options for controlling placement. <p> When <code>embeddedComponent</code> is used in a MenuItem certain default
     * behaviors apply: <ul> <li> {@link com.smartgwt.client.widgets.menu.MenuItem#getAutoDismiss autoDismiss} defaults to
     * false and clicks on embeddedComponents are       not bubbled to the menuItem - if an interaction with an
     * embeddedComponent is       expected to dismiss the menu, custom code should call menu.{@link
     * com.smartgwt.client.widgets.menu.Menu#hide hide} or       {@link com.smartgwt.client.widgets.menu.Menu#hideAllMenus
     * hideAllMenus} as appropriate, before proceeding <li> the default behavior for {@link
     * com.smartgwt.client.widgets.menu.MenuItem#getEmbeddedComponentPosition embeddedComponentPosition} is "expand". <li> the
     * component is placed over the title and key fields by default - use {@link
     * com.smartgwt.client.widgets.menu.MenuItem#getEmbeddedComponentFields embeddedComponentFields} to override <li> rollOver
     * styling is disabled by default (as though {@link com.smartgwt.client.widgets.grid.ListGridRecord#getShowRollOver
     * ListGridRecord.showRollOver} were set to false) </ul>
     *
     * @param embeddedComponent New embeddedComponent value. Default value is null
     */
    public void setEmbeddedComponent(Canvas embeddedComponent) {
        setAttribute("embeddedComponent", embeddedComponent == null ? null : embeddedComponent.getOrCreateJsObj());
    }

    /**
     * Arbitrary UI component that should appear in this MenuItem.  See {@link
     * com.smartgwt.client.widgets.grid.ListGridRecord#getEmbeddedComponent ListGridRecord.embeddedComponent} for an overview
     * and options for controlling placement. <p> When <code>embeddedComponent</code> is used in a MenuItem certain default
     * behaviors apply: <ul> <li> {@link com.smartgwt.client.widgets.menu.MenuItem#getAutoDismiss autoDismiss} defaults to
     * false and clicks on embeddedComponents are       not bubbled to the menuItem - if an interaction with an
     * embeddedComponent is       expected to dismiss the menu, custom code should call menu.{@link
     * com.smartgwt.client.widgets.menu.Menu#hide hide} or       {@link com.smartgwt.client.widgets.menu.Menu#hideAllMenus
     * hideAllMenus} as appropriate, before proceeding <li> the default behavior for {@link
     * com.smartgwt.client.widgets.menu.MenuItem#getEmbeddedComponentPosition embeddedComponentPosition} is "expand". <li> the
     * component is placed over the title and key fields by default - use {@link
     * com.smartgwt.client.widgets.menu.MenuItem#getEmbeddedComponentFields embeddedComponentFields} to override <li> rollOver
     * styling is disabled by default (as though {@link com.smartgwt.client.widgets.grid.ListGridRecord#getShowRollOver
     * ListGridRecord.showRollOver} were set to false) </ul>
     *
     * @return Current embeddedComponent value. Default value is null
     */
    public Canvas getEmbeddedComponent()  {
        return (Canvas)Canvas.getByJSObject(getAttributeAsJavaScriptObject("embeddedComponent"));
    }
    

    /**
     * See {@link com.smartgwt.client.widgets.grid.ListGridRecord#getEmbeddedComponentFields
     * ListGridRecord.embeddedComponentFields}.  Default for a MenuItem is to cover the title and key fields, leaving the icon
     * and submenu fields visible.
     *
     * @param embeddedComponentFields New embeddedComponentFields value. Default value is null
     */
    public void setEmbeddedComponentFields(String... embeddedComponentFields) {
        setAttribute("embeddedComponentFields", embeddedComponentFields);
    }

    /**
     * See {@link com.smartgwt.client.widgets.grid.ListGridRecord#getEmbeddedComponentFields
     * ListGridRecord.embeddedComponentFields}.  Default for a MenuItem is to cover the title and key fields, leaving the icon
     * and submenu fields visible.
     *
     * @return Current embeddedComponentFields value. Default value is null
     */
    public String[] getEmbeddedComponentFields()  {
        return com.smartgwt.client.util.ConvertTo.arrayOfString(getAttributeAsJavaScriptObject("embeddedComponentFields"));
    }
    

    /**
     * See {@link com.smartgwt.client.widgets.grid.ListGridRecord#getEmbeddedComponentPosition
     * ListGridRecord.embeddedComponentPosition}, except that when used in a <code>menuItem</code>, default behavior is {@link
     * com.smartgwt.client.types.EmbeddedPosition} "expand".
     *
     * @param embeddedComponentPosition New embeddedComponentPosition value. Default value is null
     */
    public void setEmbeddedComponentPosition(EmbeddedPosition embeddedComponentPosition) {
        setAttribute("embeddedComponentPosition", embeddedComponentPosition == null ? null : embeddedComponentPosition.getValue());
    }

    /**
     * See {@link com.smartgwt.client.widgets.grid.ListGridRecord#getEmbeddedComponentPosition
     * ListGridRecord.embeddedComponentPosition}, except that when used in a <code>menuItem</code>, default behavior is {@link
     * com.smartgwt.client.types.EmbeddedPosition} "expand".
     *
     * @return Current embeddedComponentPosition value. Default value is null
     */
    public EmbeddedPosition getEmbeddedComponentPosition()  {
        return EnumUtil.getEnum(EmbeddedPosition.values(), getAttribute("embeddedComponentPosition"));
    }
    

    /**
     * Affects the visual style and interactivity of the menu item.  If set to <code>false</code>, the menu item will not
     * respond to mouse rollovers or clicks. <p> If you need to set this state dynamically, use {@link
     * com.smartgwt.client.widgets.menu.MenuItem#enableIf enableIf()} instead.
     *
     * @param enabled New enabled value. Default value is true
     */
    public void setEnabled(Boolean enabled) {
        setAttribute("enabled", enabled);
    }

    /**
     * Affects the visual style and interactivity of the menu item.  If set to <code>false</code>, the menu item will not
     * respond to mouse rollovers or clicks. <p> If you need to set this state dynamically, use {@link
     * com.smartgwt.client.widgets.menu.MenuItem#enableIf enableIf()} instead.
     *
     * @return Current enabled value. Default value is true
     */
    public Boolean getEnabled()  {
        Boolean result = getAttributeAsBoolean("enabled", true);
        return result == null ? true : result;
    }
    

    /**
     * Criteria to be evaluated to determine whether this MenuItem should be disabled.  Re-evaluated each time the menu is
     * shown. <P> A basic criteria uses textMatchStyle:"exact". When specified in {@link com.smartgwt.client.docs.ComponentXML
     * Component XML} this property allows {@link com.smartgwt.client.docs.XmlCriteriaShorthand shorthand formats} for defining
     * criteria.
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
     * Criteria to be evaluated to determine whether this MenuItem should be disabled.  Re-evaluated each time the menu is
     * shown. <P> A basic criteria uses textMatchStyle:"exact". When specified in {@link com.smartgwt.client.docs.ComponentXML
     * Component XML} this property allows {@link com.smartgwt.client.docs.XmlCriteriaShorthand shorthand formats} for defining
     * criteria.
     *
     * @return Current enableWhen value. Default value is null
     * @see com.smartgwt.client.docs.RuleCriteria RuleCriteria overview and related methods
     */
    public AdvancedCriteria getEnableWhen()  {
        return new AdvancedCriteria(getAttributeAsJavaScriptObject("enableWhen"));
    }
    

    /**
     * If false, no submenus will be fetched for this MenuItem. This can be set globally via {@link
     * com.smartgwt.client.widgets.menu.Menu#getFetchSubmenus Menu.fetchSubmenus}.
     *
     * @param fetchSubmenus New fetchSubmenus value. Default value is true
     */
    public void setFetchSubmenus(Boolean fetchSubmenus) {
        setAttribute("fetchSubmenus", fetchSubmenus);
    }

    /**
     * If false, no submenus will be fetched for this MenuItem. This can be set globally via {@link
     * com.smartgwt.client.widgets.menu.Menu#getFetchSubmenus Menu.fetchSubmenus}.
     *
     * @return Current fetchSubmenus value. Default value is true
     */
    public Boolean getFetchSubmenus()  {
        Boolean result = getAttributeAsBoolean("fetchSubmenus", true);
        return result == null ? true : result;
    }
    

    /**
     * The filename for this item's custom icon. If both this property and {@link
     * com.smartgwt.client.widgets.menu.MenuItem#getChecked checked} are both specified, only the icon specified by this
     * property will be displayed. The path to the loaded skin directory and the skinImgDir are prepended to this filename to
     * form the full URL. If this item is disabled, and {@link com.smartgwt.client.widgets.menu.MenuItem#getDisabledIcon
     * disabledIcon} is set, then that icon will be used instead. <p> If you need to set this state dynamically, use {@link
     * com.smartgwt.client.widgets.menu.MenuItem#dynamicIcon dynamicIcon()} instead.
     *
     * @param icon New icon value. Default value is null
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#menus_category_appearance" target="examples">Appearance Example</a>
     */
    public void setIcon(String icon) {
        setAttribute("icon", icon);
    }

    /**
     * The filename for this item's custom icon. If both this property and {@link
     * com.smartgwt.client.widgets.menu.MenuItem#getChecked checked} are both specified, only the icon specified by this
     * property will be displayed. The path to the loaded skin directory and the skinImgDir are prepended to this filename to
     * form the full URL. If this item is disabled, and {@link com.smartgwt.client.widgets.menu.MenuItem#getDisabledIcon
     * disabledIcon} is set, then that icon will be used instead. <p> If you need to set this state dynamically, use {@link
     * com.smartgwt.client.widgets.menu.MenuItem#dynamicIcon dynamicIcon()} instead.
     *
     * @return Current icon value. Default value is null
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#menus_category_appearance" target="examples">Appearance Example</a>
     */
    public String getIcon()  {
        return getAttributeAsString("icon");
    }
    

    /**
     * The height applied to this item's icon.  The default of <code>16</code> can be changed for all MenuItems by overriding
     * {@link com.smartgwt.client.widgets.menu.Menu#getIconHeight Menu.iconHeight}.
     *
     * @param iconHeight New iconHeight value. Default value is 16
     */
    public void setIconHeight(int iconHeight) {
        setAttribute("iconHeight", iconHeight);
    }

    /**
     * The height applied to this item's icon.  The default of <code>16</code> can be changed for all MenuItems by overriding
     * {@link com.smartgwt.client.widgets.menu.Menu#getIconHeight Menu.iconHeight}.
     *
     * @return Current iconHeight value. Default value is 16
     */
    public int getIconHeight()  {
        return getAttributeAsInt("iconHeight");
    }
    

    /**
     * The width applied to this item's icon.  The default of <code>16</code> can be changed for all MenuItems by overriding
     * {@link com.smartgwt.client.widgets.menu.Menu#getIconWidth Menu.iconWidth}.
     *
     * @param iconWidth New iconWidth value. Default value is 16
     */
    public void setIconWidth(int iconWidth) {
        setAttribute("iconWidth", iconWidth);
    }

    /**
     * The width applied to this item's icon.  The default of <code>16</code> can be changed for all MenuItems by overriding
     * {@link com.smartgwt.client.widgets.menu.Menu#getIconWidth Menu.iconWidth}.
     *
     * @return Current iconWidth value. Default value is 16
     */
    public int getIconWidth()  {
        return getAttributeAsInt("iconWidth");
    }
    

    /**
     * When set to <code>true</code>, this menu item shows a horizontal separator instead of the {@link
     * com.smartgwt.client.widgets.menu.MenuItem#getTitle title} text.  Typically specified as the only property of a menu
     * item, since the separator will not respond to mouse events.
     *
     * @param isSeparator New isSeparator value. Default value is false
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#menus_category_appearance" target="examples">Appearance Example</a>
     */
    public void setIsSeparator(Boolean isSeparator) {
        setAttribute("isSeparator", isSeparator);
    }

    /**
     * When set to <code>true</code>, this menu item shows a horizontal separator instead of the {@link
     * com.smartgwt.client.widgets.menu.MenuItem#getTitle title} text.  Typically specified as the only property of a menu
     * item, since the separator will not respond to mouse events.
     *
     * @return Current isSeparator value. Default value is false
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#menus_category_appearance" target="examples">Appearance Example</a>
     */
    public Boolean getIsSeparator()  {
        Boolean result = getAttributeAsBoolean("isSeparator", true);
        return result == null ? false : result;
    }
    
    

    /**
     * A string to display in the shortcut-key column for this item. If not specified, the first KeyName value in {@link
     * com.smartgwt.client.widgets.menu.MenuItem#getKeys keys} will be used by default.
     *
     * @param keyTitle New keyTitle value. Default value is see below
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#menus_category_appearance" target="examples">Appearance Example</a>
     */
    public void setKeyTitle(String keyTitle) {
        setAttribute("keyTitle", keyTitle);
    }

    /**
     * A string to display in the shortcut-key column for this item. If not specified, the first KeyName value in {@link
     * com.smartgwt.client.widgets.menu.MenuItem#getKeys keys} will be used by default.
     *
     * @return Current keyTitle value. Default value is see below
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#menus_category_appearance" target="examples">Appearance Example</a>
     */
    public String getKeyTitle()  {
        return getAttributeAsString("keyTitle");
    }
    

    /**
     * When used in an {@link com.smartgwt.client.widgets.menu.AdaptiveMenu}, should this MenuItem show only it's {@link
     * com.smartgwt.client.widgets.menu.MenuItem#getIcon icon} when displayed inline?
     *
     * @param showIconOnlyInline New showIconOnlyInline value. Default value is null
     */
    public void setShowIconOnlyInline(Boolean showIconOnlyInline) {
        setAttribute("showIconOnlyInline", showIconOnlyInline);
    }

    /**
     * When used in an {@link com.smartgwt.client.widgets.menu.AdaptiveMenu}, should this MenuItem show only it's {@link
     * com.smartgwt.client.widgets.menu.MenuItem#getIcon icon} when displayed inline?
     *
     * @return Current showIconOnlyInline value. Default value is null
     */
    public Boolean getShowIconOnlyInline()  {
        return getAttributeAsBoolean("showIconOnlyInline", true);
    }
    

    /**
     * A reference to another menu, to display as a submenu when the mouse cursor hovers over this menu item.
     *
     * @param submenu New submenu value. Default value is null
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#menus_category_appearance" target="examples">Appearance Example</a>
     */
    public void setSubmenu(Menu submenu) {
        setAttribute("submenu", submenu == null ? null : submenu.getOrCreateJsObj());
    }
    

    /**
     * The text displayed for the menu item
     *
     * @param title New title value. Default value is null
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public void setTitle(String title) {
        setAttribute("title", title);
    }

    /**
     * The text displayed for the menu item
     *
     * @return Current title value. Default value is null
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public String getTitle()  {
        return getAttributeAsString("title");
    }
    

    // ********************* Methods ***********************
    /**
     * Add a click handler.
     * <p>
     * Executed when this menu item is clicked by the user. The click handler must be specified as a function or string of
     * script.  Call {@link com.smartgwt.client.widgets.menu.events.MenuItemClickEvent#cancel()} from within {@link
     * com.smartgwt.client.widgets.menu.events.ClickHandler#onClick} to suppress the {@link
     * com.smartgwt.client.widgets.menu.Menu#addItemClickHandler Menu.itemClick()} handler if specified.
     *
     * @param handler the click handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addClickHandler(com.smartgwt.client.widgets.menu.events.ClickHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.menu.events.MenuItemClickEvent.getType()) == 0) setupClickEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.menu.events.MenuItemClickEvent.getType());
    }

    private native void setupClickEvent() /*-{
        var obj;
        obj = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        var selfJ = this;
        var click = $entry(function(){
            var param = {"_this": this, "target" : arguments[0], "item" : arguments[1], "menu" : arguments[2], "colNum" : arguments[3]};
            var event = @com.smartgwt.client.widgets.menu.events.MenuItemClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.core.DataClass::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            selfJ.@com.smartgwt.client.widgets.menu.MenuItem::handleTearDownClickEvent()();
            });
        obj.click =  click 
        ;
    }-*/;

    private void handleTearDownClickEvent() {
        if (getHandlerCount(com.smartgwt.client.widgets.menu.events.MenuItemClickEvent.getType()) == 0) tearDownClickEvent();
    }

    private native void tearDownClickEvent() /*-{
        var obj;
        obj = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        if (obj && "click" in obj) delete obj.click;
    }-*/;


    // ********************* Static Methods ***********************

    // ***********************************************************


    /**
     * Shortcut key(s) to fire the menu item action. Each key can be defined as a {@link KeyIdentifier}.
     * To apply multiple shortcut keys to this item, set this property to an array of such key identifiers.
     *
     * @param keys keys Default value is null
     */
    public void setKeys(KeyIdentifier... keys) {
        setAttribute("keys", keys);
    }

    /**
     * Contains the condition that will enable or disable the curent menuItem. The handler must be specified as a
     * function or string of script.  Return false to disable the menuItem or true to enable it <p> If you don't need to
     * set this state dynamically, use {@link com.smartgwt.client.widgets.menu.MenuItem#getEnabled enabled} instead.
     */
    public native void setEnableIfCondition(MenuItemIfFunction enableIf) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.enableIf = $debox($entry(function(target, menu, item) {
            var targetJ;
            if (target == null) {
                targetJ = null;
            } else if(@com.smartgwt.client.widgets.tab.Tab::isTab(Lcom/google/gwt/core/client/JavaScriptObject;)(target)) {
                targetJ = @com.smartgwt.client.widgets.tab.Tab::getTabSet(Lcom/google/gwt/core/client/JavaScriptObject;)(target);
            } else {
                targetJ = @com.smartgwt.client.widgets.BaseWidget::getRef(Lcom/google/gwt/core/client/JavaScriptObject;)(target);
            }
            var menuJ = @com.smartgwt.client.widgets.BaseWidget::getRef(Lcom/google/gwt/core/client/JavaScriptObject;)(menu);
            var itemJ = @com.smartgwt.client.widgets.menu.MenuItem::getRef(Lcom/google/gwt/core/client/JavaScriptObject;)(item);
            return enableIf.@com.smartgwt.client.widgets.menu.MenuItemIfFunction::execute(Lcom/smartgwt/client/widgets/Canvas;Lcom/smartgwt/client/widgets/menu/Menu;Lcom/smartgwt/client/widgets/menu/MenuItem;)(targetJ, menuJ, itemJ);
        }));
    }-*/;

    /**
     * Contains the condition that will check or uncheck the curent menuItem. The handler must be specified as a
     * function or string of script.  Return false to uncheck the menuItem or true to check it <p> If you don't need to
     * set this state dynamically, use {@link com.smartgwt.client.widgets.menu.MenuItem#getChecked checked} instead.
     */
    public native void setCheckIfCondition(MenuItemIfFunction checkIf) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.checkIf = $debox($entry(function(target, menu, item) {
            var targetJ;
            if (target == null) {
                targetJ = null;
            } else if(@com.smartgwt.client.widgets.tab.Tab::isTab(Lcom/google/gwt/core/client/JavaScriptObject;)(target)) {
                targetJ = @com.smartgwt.client.widgets.tab.Tab::getTabSet(Lcom/google/gwt/core/client/JavaScriptObject;)(target);
            } else {
                targetJ = @com.smartgwt.client.widgets.BaseWidget::getRef(Lcom/google/gwt/core/client/JavaScriptObject;)(target);
            }
            var menuJ = @com.smartgwt.client.widgets.BaseWidget::getRef(Lcom/google/gwt/core/client/JavaScriptObject;)(menu);
            var itemJ = @com.smartgwt.client.widgets.menu.MenuItem::getRef(Lcom/google/gwt/core/client/JavaScriptObject;)(item);
            return checkIf.@com.smartgwt.client.widgets.menu.MenuItemIfFunction::execute(Lcom/smartgwt/client/widgets/Canvas;Lcom/smartgwt/client/widgets/menu/Menu;Lcom/smartgwt/client/widgets/menu/MenuItem;)(targetJ, menuJ, itemJ);
         }));
    }-*/;

    /**
     * Contains the condition that will change the curent items' title when met. The handler must be specified as a
     * function or string of script.   <p> If you don't need to set this state dynamically, use {@link
     * com.smartgwt.client.widgets.menu.MenuItem#getTitle title} instead.
     */
    public native void setDynamicTitleFunction(MenuItemStringFunction handler) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.dynamicTitle = $debox($entry(function(target, menu, item) {
            var targetJ;
            if(target == null) {
                targetJ = null;
            } else if(@com.smartgwt.client.widgets.tab.Tab::isTab(Lcom/google/gwt/core/client/JavaScriptObject;)(target)) {
                targetJ = @com.smartgwt.client.widgets.tab.Tab::getTabSet(Lcom/google/gwt/core/client/JavaScriptObject;)(target);
            } else {
                targetJ = @com.smartgwt.client.widgets.BaseWidget::getRef(Lcom/google/gwt/core/client/JavaScriptObject;)(target);
            }
            var menuJ = @com.smartgwt.client.widgets.BaseWidget::getRef(Lcom/google/gwt/core/client/JavaScriptObject;)(menu);
            var itemJ = @com.smartgwt.client.widgets.menu.MenuItem::getRef(Lcom/google/gwt/core/client/JavaScriptObject;)(item);
            return handler.@com.smartgwt.client.widgets.menu.MenuItemStringFunction::execute(Lcom/smartgwt/client/widgets/Canvas;Lcom/smartgwt/client/widgets/menu/Menu;Lcom/smartgwt/client/widgets/menu/MenuItem;)(targetJ, menuJ, itemJ);
        }));
    }-*/;

    /**
     * Contains the condition that will change the curent items' icon when met. The handler must be specified as a
     * function or string of script. <p> If you don't need to set this state dynamically, use {@link
     * com.smartgwt.client.widgets.menu.MenuItem#getIcon icon} instead.
     */
    public native void setDynamicIconFunction(MenuItemStringFunction handler) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.dynamicIcon = $debox($entry(function(target, menu, item) {
            var targetJ;
            if(target == null) {
                targetJ = null;
            } else if(@com.smartgwt.client.widgets.tab.Tab::isTab(Lcom/google/gwt/core/client/JavaScriptObject;)(target)) {
                targetJ = @com.smartgwt.client.widgets.tab.Tab::getTabSet(Lcom/google/gwt/core/client/JavaScriptObject;)(target);
            } else {
                targetJ = @com.smartgwt.client.widgets.BaseWidget::getRef(Lcom/google/gwt/core/client/JavaScriptObject;)(target);
            }
            var menuJ = @com.smartgwt.client.widgets.BaseWidget::getRef(Lcom/google/gwt/core/client/JavaScriptObject;)(menu);
            var itemJ = @com.smartgwt.client.widgets.menu.MenuItem::getRef(Lcom/google/gwt/core/client/JavaScriptObject;)(item);
            return handler.@com.smartgwt.client.widgets.menu.MenuItemStringFunction::execute(Lcom/smartgwt/client/widgets/Canvas;Lcom/smartgwt/client/widgets/menu/Menu;Lcom/smartgwt/client/widgets/menu/MenuItem;)(targetJ, menuJ, itemJ);
        }));
    }-*/;

    /**
     * A reference to another menu, to display as a submenu when the mouse cursor hovers over
     * this menu item.
     *
     * @return Menu
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#menus_category_appearance" 
     * target="examples">Appearance Example</a>
     * @deprecated use {@link com.smartgwt.client.widgets.Menu#getSubmenu} instead
     */
    @Deprecated
    public Menu getSubmenu()  {
        SC.logWarn("MenuItem.getSubmenu() is deprecated in favor of Menu.getSubmenu()");
        return Menu.getOrCreateRef(getAttributeAsJavaScriptObject("submenu"), this);
    }

}
