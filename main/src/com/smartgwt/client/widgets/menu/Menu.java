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
 
package com.smartgwt.client.widgets.menu;



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
 * The Menu widget class implements interactive menu widgets, with optional icons, submenus, and shortcut keys. <p> A Menu
 * is initialized with an Array of items, specified as menu.data, each of which represents one row in the menu's display
 * and specifies the action to take when that menu item is selected. <p> Generally to create a context menu for a
 * component, provide a Menu instance for the  <code>contextMenu</code> property.  Note that some components have special
 * context menu support because they have distinct regions or because they have a default set of context menu actions
 * available. <p> If you want a button that pops up a menu when clicked, or a bar of such buttons, see the MenuButton and
 * MenuBar classes.
 */
public class Menu extends ListGrid  implements com.smartgwt.client.widgets.menu.events.HasItemClickHandlers {

    public static Menu getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        BaseWidget obj = BaseWidget.getRef(jsObj);
        if(obj != null) {
            return (Menu) obj;
        } else {
            return new Menu(jsObj);
        }
    }

    public Menu(){
        setAlternateRecordStyles(false);scClassName = "Menu";
    }

    public Menu(JavaScriptObject jsObj){
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
     * When true, when a menu item is chosen (via mouse click or keyboard), the menu is not  automatically hidden, staying in
     * place for further interactivity
     *
     * @param autoDismiss autoDismiss Default value is true
     */
    public void setAutoDismiss(Boolean autoDismiss) {
        setAttribute("autoDismiss", autoDismiss, true);
    }

    /**
     * When true, when a menu item is chosen (via mouse click or keyboard), the menu is not  automatically hidden, staying in
     * place for further interactivity
     *
     *
     * @return Boolean
     */
    public Boolean getAutoDismiss()  {
        return getAttributeAsBoolean("autoDismiss");
    }

    /**
     * Menus will not draw on initialization, until they're explicitly show()n
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param autoDraw autoDraw Default value is false
     */
    public void setAutoDraw(Boolean autoDraw) {
        setAttribute("autoDraw", autoDraw, true);
    }

    /**
     * Menus will not draw on initialization, until they're explicitly show()n
     *
     *
     * @return Boolean
     */
    public Boolean getAutoDraw()  {
        return getAttributeAsBoolean("autoDraw");
    }

    /**
     * If true, clicking or pressing Enter on a menu item that has a submenu will  select that item (with standard behavior of
     * hiding the menus, calling click  handlers, etc) instead of showing the submenu.
     *
     * @param canSelectParentItems canSelectParentItems Default value is null
     * @see com.smartgwt.client.docs.Selection Selection overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#menus_category_treebinding" target="examples">Tree Binding Example</a>
     */
    public void setCanSelectParentItems(Boolean canSelectParentItems) {
        setAttribute("canSelectParentItems", canSelectParentItems, true);
    }

    /**
     * If true, clicking or pressing Enter on a menu item that has a submenu will  select that item (with standard behavior of
     * hiding the menus, calling click  handlers, etc) instead of showing the submenu.
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.docs.Selection Selection overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#menus_category_treebinding" target="examples">Tree Binding Example</a>
     */
    public Boolean getCanSelectParentItems()  {
        return getAttributeAsBoolean("canSelectParentItems");
    }

    /**
     * The height of each item in the menu, in pixels.
     *
     * @param cellHeight cellHeight Default value is 20
     * @see com.smartgwt.client.docs.Sizing Sizing overview and related methods
     */
    public void setCellHeight(int cellHeight) {
        setAttribute("cellHeight", cellHeight, true);
    }

    /**
     * The height of each item in the menu, in pixels.
     *
     *
     * @return int
     * @see com.smartgwt.client.docs.Sizing Sizing overview and related methods
     */
    public int getCellHeight()  {
        return getAttributeAsInt("cellHeight");
    }

    /**
     * The default menu width.
     *
     * @param defaultWidth defaultWidth Default value is 150
     * @see com.smartgwt.client.docs.Sizing Sizing overview and related methods
     */
    public void setDefaultWidth(int defaultWidth) {
        setAttribute("defaultWidth", defaultWidth, true);
    }

    /**
     * The default menu width.
     *
     *
     * @return int
     * @see com.smartgwt.client.docs.Sizing Sizing overview and related methods
     */
    public int getDefaultWidth()  {
        return getAttributeAsInt("defaultWidth");
    }

    /**
     * Message to show when a menu is shown with no items.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param emptyMessage emptyMessage Default value is "[Empty menu]"
     */
    public void setEmptyMessage(String emptyMessage) {
        setAttribute("emptyMessage", emptyMessage, true);
    }

    /**
     * Message to show when a menu is shown with no items.
     *
     *
     * @return String
     */
    public String getEmptyMessage()  {
        return getAttributeAsString("emptyMessage");
    }

    /**
     * If false, submenus will not be fetched for this menu. This can be set on a per-item basis via {@link
     * com.smartgwt.client.widgets.menu.MenuItem#getFetchSubmenus fetchSubmenus}.
     *
     * @param fetchSubmenus fetchSubmenus Default value is true
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setFetchSubmenus(Boolean fetchSubmenus)  throws IllegalStateException {
        setAttribute("fetchSubmenus", fetchSubmenus, false);
    }

    /**
     * If false, submenus will not be fetched for this menu. This can be set on a per-item basis via {@link
     * com.smartgwt.client.widgets.menu.MenuItem#getFetchSubmenus fetchSubmenus}.
     *
     *
     * @return Boolean
     */
    public Boolean getFetchSubmenus()  {
        return getAttributeAsBoolean("fetchSubmenus");
    }

    /**
     * The default height applied to custom icons in this menu. This is used whenever          item.iconHeight is not
     * specified.
     *
     * @param iconHeight iconHeight Default value is 16
     */
    public void setIconHeight(int iconHeight) {
        setAttribute("iconHeight", iconHeight, true);
    }

    /**
     * The default height applied to custom icons in this menu. This is used whenever          item.iconHeight is not
     * specified.
     *
     *
     * @return int
     */
    public int getIconHeight()  {
        return getAttributeAsInt("iconHeight");
    }

    /**
     * The default width applied to custom icons in this menu. This is used whenever          item.iconWidth is not specified.
     *
     * @param iconWidth iconWidth Default value is 16
     */
    public void setIconWidth(int iconWidth) {
        setAttribute("iconWidth", iconWidth, true);
    }

    /**
     * The default width applied to custom icons in this menu. This is used whenever          item.iconWidth is not specified.
     *
     *
     * @return int
     */
    public int getIconWidth()  {
        return getAttributeAsInt("iconWidth");
    }

    /**
     * For a menu that has a {@link com.smartgwt.client.widgets.menu.MenuButton} generated for it automatically (for example
     * when included in a {@link com.smartgwt.client.widgets.menu.MenuBar}, the width that the MenuButton should have.  If
     * unset, the MenuButton will be as wide as <code>menu.width</code>.
     *
     * @param menuButtonWidth menuButtonWidth Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setMenuButtonWidth(Integer menuButtonWidth)  throws IllegalStateException {
        setAttribute("menuButtonWidth", menuButtonWidth, false);
    }

    /**
     * For a menu that has a {@link com.smartgwt.client.widgets.menu.MenuButton} generated for it automatically (for example
     * when included in a {@link com.smartgwt.client.widgets.menu.MenuBar}, the width that the MenuButton should have.  If
     * unset, the MenuButton will be as wide as <code>menu.width</code>.
     *
     *
     * @return Integer
     */
    public Integer getMenuButtonWidth()  {
        return getAttributeAsInt("menuButtonWidth");
    }

    /**
     * When this menu is shown how should it animate into view? By default the menu will just show at the specified
     * size/position. Options for animated show effects are <code>"fade"</code> to fade from transparent to visible,
     * <code>"slide"</code> to slide the menu into view, or <code>"wipe"</code> to have the menu grow into view, revealing its
     * content as it grows. Can be overridden by passing the 'animationEffect' parameter to 'menu.show()'
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param showAnimationEffect showAnimationEffect Default value is null
     */
    public void setShowAnimationEffect(String showAnimationEffect) {
        setAttribute("showAnimationEffect", showAnimationEffect, true);
    }

    /**
     * When this menu is shown how should it animate into view? By default the menu will just show at the specified
     * size/position. Options for animated show effects are <code>"fade"</code> to fade from transparent to visible,
     * <code>"slide"</code> to slide the menu into view, or <code>"wipe"</code> to have the menu grow into view, revealing its
     * content as it grows. Can be overridden by passing the 'animationEffect' parameter to 'menu.show()'
     *
     *
     * @return String
     */
    public String getShowAnimationEffect()  {
        return getAttributeAsString("showAnimationEffect");
    }

    /**
     * A boolean, indicating whether the checkmark/custom icon column should be displayed. If showIcons is not set, the menu
     * will show the icon column only if one of its items specifies an icon, checked, checkIf, or dynamicIcon property.
     *
     * @param showIcons showIcons Default value is true
     */
    public void setShowIcons(Boolean showIcons) {
        setAttribute("showIcons", showIcons, true);
    }

    /**
     * A boolean, indicating whether the checkmark/custom icon column should be displayed. If showIcons is not set, the menu
     * will show the icon column only if one of its items specifies an icon, checked, checkIf, or dynamicIcon property.
     *
     *
     * @return Boolean
     */
    public Boolean getShowIcons()  {
        return getAttributeAsBoolean("showIcons");
    }

    /**
     * A boolean, indicating whether the shortcut key column should be displayed. If showKeys is not set, the menu will show
     * the key column only if one of its items specifies a keys property. If showKeys is false, the keys will not be displayed,
     * but will still function.
     *
     * @param showKeys showKeys Default value is true
     */
    public void setShowKeys(Boolean showKeys) {
        setAttribute("showKeys", showKeys, true);
    }

    /**
     * A boolean, indicating whether the shortcut key column should be displayed. If showKeys is not set, the menu will show
     * the key column only if one of its items specifies a keys property. If showKeys is false, the keys will not be displayed,
     * but will still function.
     *
     *
     * @return Boolean
     */
    public Boolean getShowKeys()  {
        return getAttributeAsBoolean("showKeys");
    }

    /**
     * A boolean, indicating whether the submenu indicator column should be displayed. If showSubmenus is not set, the menu
     * will show the indicator column only if one of its items specifies a submenu property. If showSubmenus is false, the
     * submenu arrows will not be displayed, but submenus will still appear on rollover.
     *
     * @param showSubmenus showSubmenus Default value is true
     */
    public void setShowSubmenus(Boolean showSubmenus) {
        setAttribute("showSubmenus", showSubmenus, true);
    }

    /**
     * A boolean, indicating whether the submenu indicator column should be displayed. If showSubmenus is not set, the menu
     * will show the indicator column only if one of its items specifies a submenu property. If showSubmenus is false, the
     * submenu arrows will not be displayed, but submenus will still appear on rollover.
     *
     *
     * @return Boolean
     */
    public Boolean getShowSubmenus()  {
        return getAttributeAsBoolean("showSubmenus");
    }

    /**
     * Should submenus show up on our left or right. Can validly be set to <code>"left"</code>  or <code>"right"</code>
     *
     * @param submenuDirection submenuDirection Default value is "right"
     */
    public void setSubmenuDirection(String submenuDirection) {
        setAttribute("submenuDirection", submenuDirection, true);
    }

    /**
     * Should submenus show up on our left or right. Can validly be set to <code>"left"</code>  or <code>"right"</code>
     *
     *
     * @return String
     */
    public String getSubmenuDirection()  {
        return getAttributeAsString("submenuDirection");
    }

    /**
     * Optional target canvas for this menu.  Available as a parameter to dynamic menuItem configuration methods such as {@link
     * com.smartgwt.client.widgets.menu.MenuItem#checkIf MenuItem.checkIf}. <P> Whenever a Menu is shown as a contextMenu by a
     * widget due to {@link com.smartgwt.client.widgets.Canvas#getContextMenu contextMenu} being set, <code>menu.target</code>
     * is automatically set to the widget that showed the contextMenu. <P> If this item has any {@link
     * com.smartgwt.client.widgets.menu.MenuItem#getSubmenu submenus} the <code>target</code> will be propagated down to these
     * child menus.
     *
     * @param target target Default value is null
     */
    public void setTarget(Canvas target) {
        setAttribute("target", target.getOrCreateJsObj(), true);
    }

    /**
     * Optional target canvas for this menu.  Available as a parameter to dynamic menuItem configuration methods such as {@link
     * com.smartgwt.client.widgets.menu.MenuItem#checkIf MenuItem.checkIf}. <P> Whenever a Menu is shown as a contextMenu by a
     * widget due to {@link com.smartgwt.client.widgets.Canvas#getContextMenu contextMenu} being set, <code>menu.target</code>
     * is automatically set to the widget that showed the contextMenu. <P> If this item has any {@link
     * com.smartgwt.client.widgets.menu.MenuItem#getSubmenu submenus} the <code>target</code> will be propagated down to these
     * child menus.
     *
     *
     * @return Canvas
     */
    public Canvas getTarget()  {
        return Canvas.getOrCreateRef(getAttributeAsJavaScriptObject("target"));
    }

    /**
     * A boolean indicating whether this menu should use shortcut keys. Set useKeys to false in a menu's initialization block
     * to explicitly disable shortcut keys.
     *
     * @param useKeys useKeys Default value is true
     */
    public void setUseKeys(Boolean useKeys) {
        setAttribute("useKeys", useKeys, true);
    }

    /**
     * A boolean indicating whether this menu should use shortcut keys. Set useKeys to false in a menu's initialization block
     * to explicitly disable shortcut keys.
     *
     *
     * @return Boolean
     */
    public Boolean getUseKeys()  {
        return getAttributeAsBoolean("useKeys");
    }

    // ********************* Methods ***********************
            
    /**
     * Get a particular MenuItem by index. <P> If passed a MenuItem, returns it.
     * @param item index of the MenuItem
     *
     * @return the MenuItem, Pointer to the item, or null if not defined
     */
    public native MenuItem getItem(int item) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getItem(item);
        if(ret == null || ret === undefined) return null;
        var retVal = @com.smartgwt.client.core.RefDataClass::getRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
        if(retVal == null) {
            retVal = @com.smartgwt.client.widgets.menu.MenuItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
        }
        return retVal;
    }-*/;
            
    /**
     * Hide the context menu - alias for hide()
     */
    public native void hideContextMenu() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.hideContextMenu();
    }-*/;
    /**
     * Add a itemClick handler.
     * <p>
     * Executed when a menu item with no click handler is clicked by the user. This          itemClick handler must be
     * specified as a function. It is passed an item parameter that          is a reference to the clicked menu item.
     *
     * @param handler the itemClick handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addItemClickHandler(com.smartgwt.client.widgets.menu.events.ItemClickHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.menu.events.ItemClickEvent.getType()) == 0) setupItemClickEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.menu.events.ItemClickEvent.getType());
    }

    private native void setupItemClickEvent() /*-{
        var obj = null;
        var selfJ = this;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            obj.addProperties({itemClick:$debox($entry(function(){
                        var param = {"item" : arguments[0], "colNum" : arguments[1]};
                        var event = @com.smartgwt.client.widgets.menu.events.ItemClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                        var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                        return !ret;
                    }))
             });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.itemClick = $debox($entry(function(){
                   var param = {"item" : arguments[0], "colNum" : arguments[1]};
                   var event = @com.smartgwt.client.widgets.menu.events.ItemClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                   selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                   var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                   return !ret;
               }));
        }
   }-*/;
            
    /**
     * Show this menu as a context menu, that is, immediately adjacent to the current mouse position.
     *
     * @return false == stop processing this event
     * @see com.smartgwt.client.docs.Visibility Visibility overview and related methods
     */
    public native Boolean showContextMenu() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var retVal =self.showContextMenu();
        if(retVal == null || retVal === undefined) {
            return null;
        } else {
            return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
        }
    }-*/;

    // ********************* Static Methods ***********************
    /**
     * Class level method to set the default properties of this class. If set, then all subsequent instances of this
     * class will automatically have the default properties that were set when this method was called. This is a powerful
     * feature that eliminates the need for users to create a separate hierarchy of subclasses that only alter the default
     * properties of this class. Can also be used for skinning / styling purposes. 
     *
     * @param menuProperties properties that should be used as new defaults when instances of this class are created
     */
    public static native void setDefaultProperties(Menu menuProperties) /*-{
        $wnd.isc.Menu.addProperties(menuProperties.@com.smartgwt.client.widgets.BaseWidget::getConfig()());
    }-*/;
        
    // ***********************************************************        


    //override to avoid ListGrid's onInit behavior
    protected void onInit_ListGrid() {
    }

    /**
     * An array of menuItem objects, specifying the menu items this menu should show.
     *
     * @param data menu items
     */
    public void setData(MenuItem... data) {
        setAttribute("data", data, true);
    }

    /**
     * An array of Record objects, specifying the data to be used to populate the DataBoundComponent. Note that not
     * all DataBoundComponents observe the changes to the data to redraw themselves. Refer to the version of setData
     * that accepts component specific records.
     *
     * @param data array of Record objects.
     * @see #setData(MenuItem[])
     */
    public void setData(Record[] data) {
        setAttribute("data", data, true);
    }

    /**
     * An List of Record objects, specifying the data to be used to populate the DataBoundComponent. Note that not
     * all DataBoundComponents observe the changes to the data to redraw themselves. Refer to the version of setData
     * that accepts component specific records.
     *
     * @param data List of Records
     */
    public void setData(RecordList data) {
        setAttribute("data", data == null ? null : data.getOrCreateJsObj(), true);
    }
    
    /**
     * Synonym for {@link com.smartgwt.client.widgets.menu.Menu#getData data} Synonym for {@link
     * com.smartgwt.client.widgets.menu.Menu#setData}.
     *
     * @param items new items for this menu. Default value is null
     */
    public void setItems(MenuItem... items) {
        setAttribute("items", items, true);
    }

    /**
     * Return the menu items.
     *
     * @return the menu items
     */
    public MenuItem[] getItems() {
        JavaScriptObject dataJS = getAttributeAsJavaScriptObject("data");
        MenuItem[] data = convertToMenuItemArray(dataJS);
        return data;
    }

    private static MenuItem[] convertToMenuItemArray(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new MenuItem[]{};
        }
        JavaScriptObject[] componentsj = JSOHelper.toArray(nativeArray);
        MenuItem[] objects = new MenuItem[componentsj.length];
        for (int i = 0; i < componentsj.length; i++) {
            JavaScriptObject componentJS = componentsj[i];
            MenuItem obj = MenuItem.getOrCreateRef(componentJS);
            objects[i] = obj;
        }
        return objects;
    }

    /**
     * When used in a MenuBar, the title of the menu button create will be the title of the Menu.
     *
     * @param title the title
     */
    public void setTitle(String title) {
        setAttribute("title", title, true);
    }

    public native void removeItem(MenuItem item) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var itemJS = item.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.removeItem(itemJS);
    }-*/;

    public void addItem(MenuItem item) {
        JavaScriptObject itemJS = item.getJsObj();

        if (isCreated()) {
            addItemPostCreate(itemJS);

        } else {
            addItemPreCreate(itemJS);
        }
    }

    private native void addItemPreCreate(JavaScriptObject itemJS) /*-{
		var config = this.@com.smartgwt.client.widgets.BaseWidget::config;

        if(!config.items) {
            config.items = @com.smartgwt.client.util.JSOHelper::createJavaScriptArray()();
        }
        config.items.push(itemJS);
    }-*/;

    private native void addItemPostCreate(JavaScriptObject itemJS) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.addItem(itemJS);
    }-*/;

    public native void addItem(MenuItem item, int index) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var itemJS = item.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.addItem(itemJS, index);
    }-*/;

    /**
     * Given a MenuItem, return it's index in the items array.
     * @param item the MenuItem
     *
     * @return index of the item, or -1 if not defined.
     */
    public native int getItemNum(MenuItem  item) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var itemJS = item.@com.smartgwt.client.core.DataClass::getJsObj()();
        return self.getItemNum(itemJS);
    }-*/;

    /**
     * Set arbitrary properties for a particular menu item.
     * @param item index of the MenuItem
     * @param properties properties to apply to the item
     */
    public native void setItemProperties(int item, MenuItem properties) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var props = properties.@com.smartgwt.client.widgets.menu.MenuItem::getJsObj()();
        self.setItemProperties(item, props);
    }-*/;

}





