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
import com.smartgwt.client.widgets.tab.*;
import com.smartgwt.client.widgets.toolbar.*;
import com.smartgwt.client.widgets.tree.*;
import com.smartgwt.client.widgets.tree.events.*;
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
import com.smartgwt.logicalstructure.widgets.rte.*;
import com.smartgwt.logicalstructure.widgets.tab.*;
import com.smartgwt.logicalstructure.widgets.tableview.*;
import com.smartgwt.logicalstructure.widgets.toolbar.*;
import com.smartgwt.logicalstructure.widgets.tree.*;
import com.smartgwt.logicalstructure.widgets.viewer.*;
import com.smartgwt.logicalstructure.widgets.calendar.*;
import com.smartgwt.logicalstructure.widgets.cube.*;
import com.smartgwt.logicalstructure.widgets.tools.*;

/**
 * The Menu widget class implements interactive menu widgets, with optional icons, submenus, and shortcut keys. <p> A Menu
 * is initialized with a set of {@link com.smartgwt.client.widgets.menu.MenuItem}s specified as {@link
 * com.smartgwt.client.widgets.menu.Menu#getItems items}, each of which represents one row in the menu's display and
 * specifies the action to take when that menu item is selected. <p> Each <code>MenuItem</code> can have a {@link
 * com.smartgwt.client.widgets.menu.MenuItem#getTitle title}, {@link com.smartgwt.client.widgets.menu.MenuItem#getIcon
 * icon}, {@link com.smartgwt.client.widgets.menu.MenuItem#getKeys shortcut keys}, optional {@link
 * com.smartgwt.client.widgets.menu.MenuItem#getSubmenu submenu} and various other settings. <p> To create a context menu
 * for a component, provide a Menu instance for the {@link com.smartgwt.client.widgets.Canvas#getContextMenu contextMenu}
 * property.  Note that some components like {@link com.smartgwt.client.widgets.grid.ListGrid} have more specific
 * properties because they have distinct regions or because they have a default set of context menu actions available (for
 * example: {@link com.smartgwt.client.widgets.grid.ListGrid#getHeaderContextMenu headerContextMenu} and related APIs). <p>
 * If you want a button that pops up a menu when clicked, or a bar of such buttons, see the {@link
 * com.smartgwt.client.widgets.menu.MenuButton} and {@link com.smartgwt.client.widgets.menu.MenuBar} classes. <p> To create
 * a pop-up panel interface that looks nothing like a <code>Menu</code> (but still dismisses automatically on an outside
 * click), use {@link com.smartgwt.client.widgets.Canvas#showClickMask Canvas.showClickMask} to arrange for automatic
 * dismissal, and the {@link com.smartgwt.client.widgets.Canvas#showNextTo Canvas.showNextTo} utility method to place the
 * component near whatever triggered it, while automatically staying on-screen.
 */
@BeanFactory.FrameworkClass
@BeanFactory.ScClassName("Menu")
public class Menu extends ListGrid implements com.smartgwt.client.widgets.menu.events.HasItemClickHandlers {

    public static Menu getOrCreateRef(JavaScriptObject jsObj) {
        if (jsObj == null) return null;
        final BaseWidget refInstance = BaseWidget.getRef(jsObj);
        if (refInstance == null) {
            return new Menu(jsObj);
        } else {
            assert refInstance instanceof Menu;
            return (Menu)refInstance;
        }
    }

    private static final Menu TEST_INSTANCE = new Menu();
    static {
        TEST_INSTANCE.setID("isc_Menu_testInstance");
    }

    @Override
    protected Menu getTestInstance() {
        return TEST_INSTANCE;
    }


    /**
     * Changes the defaults for Canvas AutoChildren named <code>autoChildName</code>.
     *
     * @param autoChildName name of an AutoChild to customize the defaults for.
     * @param defaults Canvas defaults to apply. These defaults override any existing properties
     * without destroying or wiping out non-overridden properties.
     * @see com.smartgwt.client.docs.AutoChildUsage
     */
    public static native void changeAutoChildDefaults(String autoChildName, Canvas defaults) /*-{
        $wnd.isc.Menu.changeDefaults(autoChildName + "Defaults", defaults.@com.smartgwt.client.widgets.Canvas::getConfig()());
    }-*/;

    /**
     * Changes the defaults for FormItem AutoChildren named <code>autoChildName</code>.
     *
     * @param autoChildName name of an AutoChild to customize the defaults for.
     * @param defaults FormItem defaults to apply. These defaults override any existing properties
     * without destroying or wiping out non-overridden properties.
     * @see com.smartgwt.client.docs.AutoChildUsage
     */
    public static native void changeAutoChildDefaults(String autoChildName, FormItem defaults) /*-{
        $wnd.isc.Menu.changeDefaults(autoChildName + "Defaults", defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getJsObj()());
    }-*/;

    public Menu(){
        setAlternateRecordStyles(false);scClassName = "Menu";
    }

    public Menu(JavaScriptObject jsObj){
        scClassName = "Menu";
        setJavaScriptObject(jsObj);
    }

    protected native JavaScriptObject create()/*-{
        var config = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
        var widget = $wnd.isc[scClassName].create(config);
        if ($wnd.isc.keepGlobals) this.@com.smartgwt.client.widgets.BaseWidget::internalSetID(Lcom/google/gwt/core/client/JavaScriptObject;)(widget);
        this.@com.smartgwt.client.widgets.BaseWidget::doInit()();
        return widget;
    }-*/;

    // ********************* Properties / Attributes ***********************

    /**
     * Explicitly disable alternateRecordStyles at the menu level by default so setting to true for all ListGrids will not
     * impact menus' appearance.
     *
     * @param alternateRecordStyles  Default value is false
     */
    public void setAlternateRecordStyles(Boolean alternateRecordStyles) {
        setAttribute("alternateRecordStyles", alternateRecordStyles, true);
    }

    /**
     * Explicitly disable alternateRecordStyles at the menu level by default so setting to true for all ListGrids will not
     * impact menus' appearance.
     *
     * @return Boolean
     */
    public Boolean getAlternateRecordStyles()  {
        Boolean result = getAttributeAsBoolean("alternateRecordStyles");
        return result == null ? false : result;
    }
    

    /**
     * When false, when a menu item is chosen (via mouse click or keyboard), the menu is not automatically hidden, staying in
     * place for further interactivity
     *
     * @param autoDismiss  Default value is true
     * @see com.smartgwt.client.widgets.menu.Menu#setCascadeAutoDismiss
     */
    public void setAutoDismiss(Boolean autoDismiss) {
        setAttribute("autoDismiss", autoDismiss, true);
    }

    /**
     * When false, when a menu item is chosen (via mouse click or keyboard), the menu is not automatically hidden, staying in
     * place for further interactivity
     *
     * @return Boolean
     * @see com.smartgwt.client.widgets.menu.Menu#getCascadeAutoDismiss
     */
    public Boolean getAutoDismiss()  {
        Boolean result = getAttributeAsBoolean("autoDismiss");
        return result == null ? true : result;
    }
    

    /**
     * When false, when a user clicks outside the menu, or hits the Escape key, this menu will not be automatically hidden,
     * staying in place for further interactivity.
     *
     * @param autoDismissOnBlur  Default value is true
     */
    public void setAutoDismissOnBlur(Boolean autoDismissOnBlur) {
        setAttribute("autoDismissOnBlur", autoDismissOnBlur, true);
    }

    /**
     * When false, when a user clicks outside the menu, or hits the Escape key, this menu will not be automatically hidden,
     * staying in place for further interactivity.
     *
     * @return Boolean
     */
    public Boolean getAutoDismissOnBlur()  {
        Boolean result = getAttributeAsBoolean("autoDismissOnBlur");
        return result == null ? true : result;
    }
    

    /**
     * Menus will not draw on initialization, until they're explicitly show()n
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param autoDraw  Default value is false
     */
    public void setAutoDraw(Boolean autoDraw) {
        setAttribute("autoDraw", autoDraw, true);
    }

    /**
     * Menus will not draw on initialization, until they're explicitly show()n
     *
     * @return Boolean
     */
    public Boolean getAutoDraw()  {
        Boolean result = getAttributeAsBoolean("autoDraw");
        return result == null ? false : result;
    }
    

    /**
     * CSS style for a normal cell
     *
     * @param baseStyle  See {@link com.smartgwt.client.docs.CSSStyleName CSSStyleName} . Default value is "menu"
     */
    public void setBaseStyle(String baseStyle) {
        setAttribute("baseStyle", baseStyle, true);
    }

    /**
     * CSS style for a normal cell
     *
     * @return  See {@link com.smartgwt.client.docs.CSSStyleName CSSStyleName} 
     */
    public String getBaseStyle()  {
        return getAttributeAsString("baseStyle");
    }
    

    /**
     * CSS style used for the body of this menu when there is no icon field. When there is an icon field, then {@link
     * com.smartgwt.client.widgets.menu.Menu#getIconBodyStyleName iconBodyStyleName}, if set, will override this setting. <p>
     * If applying a background-color to the body via a CSS style applied using this property, be sure to set {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getBodyBackgroundColor bodyBackgroundColor} to <code>null</code>.
     *
     * @param bodyStyleName  See {@link com.smartgwt.client.docs.CSSStyleName CSSStyleName} . Default value is "normal"
     * @see com.smartgwt.client.widgets.menu.Menu#setFillSpaceStyleName
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setBodyStyleName(String bodyStyleName) {
        setAttribute("bodyStyleName", bodyStyleName, true);
    }

    /**
     * CSS style used for the body of this menu when there is no icon field. When there is an icon field, then {@link
     * com.smartgwt.client.widgets.menu.Menu#getIconBodyStyleName iconBodyStyleName}, if set, will override this setting. <p>
     * If applying a background-color to the body via a CSS style applied using this property, be sure to set {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getBodyBackgroundColor bodyBackgroundColor} to <code>null</code>.
     *
     * @return  See {@link com.smartgwt.client.docs.CSSStyleName CSSStyleName} 
     * @see com.smartgwt.client.widgets.menu.Menu#getFillSpaceStyleName
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getBodyStyleName()  {
        return getAttributeAsString("bodyStyleName");
    }
    

    /**
     * Title for the "Done" button shown when the {@link com.smartgwt.client.widgets.layout.NavigationBar} is present.
     *
     * @param cancelButtonTitle  See {@link com.smartgwt.client.docs.HTMLString HTMLString} . Default value is "Done"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setCancelButtonTitle(String cancelButtonTitle)  throws IllegalStateException {
        setAttribute("cancelButtonTitle", cancelButtonTitle, false);
    }

    /**
     * Title for the "Done" button shown when the {@link com.smartgwt.client.widgets.layout.NavigationBar} is present.
     *
     * @return  See {@link com.smartgwt.client.docs.HTMLString HTMLString} 
     */
    public String getCancelButtonTitle()  {
        return getAttributeAsString("cancelButtonTitle");
    }
    

    /**
     * If true, clicking or pressing Enter on a menu item that has a submenu will  select that item (with standard behavior of
     * hiding the menus, calling click  handlers, etc) instead of showing the submenu.
     *
     * @param canSelectParentItems  Default value is null
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
     * @return Boolean
     * @see com.smartgwt.client.docs.Selection Selection overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#menus_category_treebinding" target="examples">Tree Binding Example</a>
     */
    public Boolean getCanSelectParentItems()  {
        return getAttributeAsBoolean("canSelectParentItems");
    }
    

    /**
     * When true any generated submenus will inherit {@link com.smartgwt.client.widgets.menu.Menu#getAutoDismiss autoDismiss}
     * from this menu.
     *
     * @param cascadeAutoDismiss  Default value is true
     */
    public void setCascadeAutoDismiss(Boolean cascadeAutoDismiss) {
        setAttribute("cascadeAutoDismiss", cascadeAutoDismiss, true);
    }

    /**
     * When true any generated submenus will inherit {@link com.smartgwt.client.widgets.menu.Menu#getAutoDismiss autoDismiss}
     * from this menu.
     *
     * @return Boolean
     */
    public Boolean getCascadeAutoDismiss()  {
        Boolean result = getAttributeAsBoolean("cascadeAutoDismiss");
        return result == null ? true : result;
    }
    

    /**
     * The height of each item in the menu, in pixels.
     *
     * @param cellHeight  Default value is 20
     * @see com.smartgwt.client.docs.Sizing Sizing overview and related methods
     */
    public void setCellHeight(int cellHeight) {
        setAttribute("cellHeight", cellHeight, true);
    }

    /**
     * The height of each item in the menu, in pixels.
     *
     * @return int
     * @see com.smartgwt.client.docs.Sizing Sizing overview and related methods
     */
    public int getCellHeight()  {
        return getAttributeAsInt("cellHeight");
    }
    

    /**
     * Default image to display for disabled checkmarked items. See {@link com.smartgwt.client.widgets.ImgProperties} for
     * format. Valid src, width and height must be specified.
     *
     * @param checkmarkDisabledImage  Default value is {...}
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setCheckmarkDisabledImage(Img checkmarkDisabledImage)  throws IllegalStateException {
        JavaScriptObject config = checkmarkDisabledImage == null ? null : checkmarkDisabledImage.getConfig();
        setAttribute("checkmarkDisabledImage", JSOHelper.cleanProperties(config, true), false);
    }

    /**
     * Default image to display for disabled checkmarked items. See {@link com.smartgwt.client.widgets.ImgProperties} for
     * format. Valid src, width and height must be specified.
     *
     * @return Img
     */
    public Img getCheckmarkDisabledImage()  {
        Img properties = new Img();
        properties.setConfigOnly(true);
        properties.setConfig(getAttributeAsJavaScriptObject("checkmarkDisabledImage"));
        return properties;
    }
    

    /**
     * Default image to display for checkmarked items. See {@link com.smartgwt.client.widgets.ImgProperties} for format. Valid
     * src, width and height must be specified.
     *
     * @param checkmarkImage  Default value is {...}
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setCheckmarkImage(Img checkmarkImage)  throws IllegalStateException {
        JavaScriptObject config = checkmarkImage == null ? null : checkmarkImage.getConfig();
        setAttribute("checkmarkImage", JSOHelper.cleanProperties(config, true), false);
    }

    /**
     * Default image to display for checkmarked items. See {@link com.smartgwt.client.widgets.ImgProperties} for format. Valid
     * src, width and height must be specified.
     *
     * @return Img
     */
    public Img getCheckmarkImage()  {
        Img properties = new Img();
        properties.setConfigOnly(true);
        properties.setConfig(getAttributeAsJavaScriptObject("checkmarkImage"));
        return properties;
    }
    

    /**
     * An array of menuItem objects, specifying the menu items this menu should show. Data may also be set to a {@link
     * com.smartgwt.client.widgets.tree.Tree} in which case a hierarchy of menus and submenus will automatically be generated
     * to match the tree structure.  See also {@link com.smartgwt.client.widgets.menu.Menu#getDataSource dataSource} for
     * dynamically fetching menuItems and submenus from a hierachical DataSource.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Change the set of items to display in this menu
     *
     * @param data new items for this menu. Default value is null
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#menus_category_appearance" target="examples">Appearance Example</a>
     */
    public void setData(MenuItem... data) {
        setAttribute("data", data, true);
    }

    /**
     * An array of menuItem objects, specifying the menu items this menu should show. Data may also be set to a {@link
     * com.smartgwt.client.widgets.tree.Tree} in which case a hierarchy of menus and submenus will automatically be generated
     * to match the tree structure.  See also {@link com.smartgwt.client.widgets.menu.Menu#getDataSource dataSource} for
     * dynamically fetching menuItems and submenus from a hierachical DataSource.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Change the set of items to display in this menu
     *
     * @param data new items for this menu. Default value is null
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#menus_category_appearance" target="examples">Appearance Example</a>
     */
    public void setData(Record[] data) {
        setAttribute("data", data, true);
    }

    /**
     * An array of menuItem objects, specifying the menu items this menu should show. Data may also be set to a {@link
     * com.smartgwt.client.widgets.tree.Tree} in which case a hierarchy of menus and submenus will automatically be generated
     * to match the tree structure.  See also {@link com.smartgwt.client.widgets.menu.Menu#getDataSource dataSource} for
     * dynamically fetching menuItems and submenus from a hierachical DataSource.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Change the set of items to display in this menu
     *
     * @param data new items for this menu. Default value is null
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#menus_category_appearance" target="examples">Appearance Example</a>
     */
    public void setData(Tree data) {
        setAttribute("data", data == null ? null : data.getOrCreateJsObj(), true);
    }

    /**
     * An array of menuItem objects, specifying the menu items this menu should show. Data may also be set to a {@link
     * com.smartgwt.client.widgets.tree.Tree} in which case a hierarchy of menus and submenus will automatically be generated
     * to match the tree structure.  See also {@link com.smartgwt.client.widgets.menu.Menu#getDataSource dataSource} for
     * dynamically fetching menuItems and submenus from a hierachical DataSource.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Change the set of items to display in this menu
     *
     * @param data new items for this menu. Default value is null
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#menus_category_appearance" target="examples">Appearance Example</a>
     */
    public void setData(RecordList data) {
        setAttribute("data", data == null ? null : data.getOrCreateJsObj(), true);
    }
    
    

    /**
     * Optional DataSource to fetch menuItems and submenus from, instead of using {@link
     * com.smartgwt.client.widgets.menu.Menu#getItems items}. <P> The provided DataSource must be set up for hierarchical
     * fetching - see the {@link com.smartgwt.client.docs.TreeDataBinding Tree Data Binding overview}.
     *
     * @param dataSource  Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setDataSource(DataSource dataSource)  throws IllegalStateException {
        setAttribute("dataSource", dataSource == null ? null : dataSource.getOrCreateJsObj(), false);
    }

    /**
     * Optional DataSource to fetch menuItems and submenus from, instead of using {@link
     * com.smartgwt.client.widgets.menu.Menu#getItems items}. <P> The provided DataSource must be set up for hierarchical
     * fetching - see the {@link com.smartgwt.client.docs.TreeDataBinding Tree Data Binding overview}.
     *
     * @return DataSource
     */
    public DataSource getDataSource()  {
        return DataSource.getOrCreateRef(getAttributeAsJavaScriptObject("dataSource"));
    }
    

    /**
     * The default menu width.
     *
     * @param defaultWidth  Default value is 150
     * @see com.smartgwt.client.docs.Sizing Sizing overview and related methods
     */
    public void setDefaultWidth(int defaultWidth) {
        setAttribute("defaultWidth", defaultWidth, true);
    }

    /**
     * The default menu width.
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
     * @param emptyMessage  See {@link com.smartgwt.client.docs.HTMLString HTMLString} . Default value is "[Empty menu]"
     */
    public void setEmptyMessage(String emptyMessage) {
        setAttribute("emptyMessage", emptyMessage, true);
    }

    /**
     * Message to show when a menu is shown with no items.
     *
     * @return  See {@link com.smartgwt.client.docs.HTMLString HTMLString} 
     */
    public String getEmptyMessage()  {
        return getAttributeAsString("emptyMessage");
    }
    

    /**
     * When using a Tree or hierarchical DataSource as the menu's data, submenus are automatically generated from child nodes. 
     * <code>fetchSubmenus</code> can be set to false to disable this for the whole menu, or can be set false on a per-item
     * basis via {@link com.smartgwt.client.widgets.menu.MenuItem#getFetchSubmenus fetchSubmenus}.
     *
     * @param fetchSubmenus  Default value is true
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setFetchSubmenus(Boolean fetchSubmenus)  throws IllegalStateException {
        setAttribute("fetchSubmenus", fetchSubmenus, false);
    }

    /**
     * When using a Tree or hierarchical DataSource as the menu's data, submenus are automatically generated from child nodes. 
     * <code>fetchSubmenus</code> can be set to false to disable this for the whole menu, or can be set false on a per-item
     * basis via {@link com.smartgwt.client.widgets.menu.MenuItem#getFetchSubmenus fetchSubmenus}.
     *
     * @return Boolean
     */
    public Boolean getFetchSubmenus()  {
        Boolean result = getAttributeAsBoolean("fetchSubmenus");
        return result == null ? true : result;
    }
    
    

    /**
     * If set, alternative body style for the menu used when there is no icon field and the {@link
     * com.smartgwt.client.widgets.menu.Menu#getPlacement placement} settings indicate the menu will be filling a portion of
     * the screen or a panel.  Generally this alternative style should not have rounded or excessively large edges.  If unset,
     * then {@link com.smartgwt.client.widgets.menu.Menu#getBodyStyleName bodyStyleName} is used instead. <p> When there is an
     * icon field, {@link com.smartgwt.client.widgets.menu.Menu#getIconFillSpaceStyleName iconFillSpaceStyleName}, if set,
     * overrides this setting.
     *
     * @param fillSpaceStyleName  See {@link com.smartgwt.client.docs.CSSStyleName CSSStyleName} . Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setFillSpaceStyleName(String fillSpaceStyleName)  throws IllegalStateException {
        setAttribute("fillSpaceStyleName", fillSpaceStyleName, false);
    }

    /**
     * If set, alternative body style for the menu used when there is no icon field and the {@link
     * com.smartgwt.client.widgets.menu.Menu#getPlacement placement} settings indicate the menu will be filling a portion of
     * the screen or a panel.  Generally this alternative style should not have rounded or excessively large edges.  If unset,
     * then {@link com.smartgwt.client.widgets.menu.Menu#getBodyStyleName bodyStyleName} is used instead. <p> When there is an
     * icon field, {@link com.smartgwt.client.widgets.menu.Menu#getIconFillSpaceStyleName iconFillSpaceStyleName}, if set,
     * overrides this setting.
     *
     * @return  See {@link com.smartgwt.client.docs.CSSStyleName CSSStyleName} 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getFillSpaceStyleName()  {
        return getAttributeAsString("fillSpaceStyleName");
    }
    

    /**
     * If set, the CSS style used for the body of this menu when there <em>is</em> an icon field. In RTL mode, the
     * <code>iconBodyStyleName</code> is suffixed with "RTL", which allows skins to apply different styles in LTR and RTL
     * modes. <p> Note: Any skin which uses <code>iconBodyStyleName</code> should add "RTL" styles as well, even if identical
     * to LTR styles. Otherwise, menus may lose their styling in RTL mode.
     *
     * @param iconBodyStyleName  See {@link com.smartgwt.client.docs.CSSStyleName CSSStyleName} . Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.menu.Menu#setIconFillSpaceStyleName
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setIconBodyStyleName(String iconBodyStyleName)  throws IllegalStateException {
        setAttribute("iconBodyStyleName", iconBodyStyleName, false);
    }

    /**
     * If set, the CSS style used for the body of this menu when there <em>is</em> an icon field. In RTL mode, the
     * <code>iconBodyStyleName</code> is suffixed with "RTL", which allows skins to apply different styles in LTR and RTL
     * modes. <p> Note: Any skin which uses <code>iconBodyStyleName</code> should add "RTL" styles as well, even if identical
     * to LTR styles. Otherwise, menus may lose their styling in RTL mode.
     *
     * @return  See {@link com.smartgwt.client.docs.CSSStyleName CSSStyleName} 
     * @see com.smartgwt.client.widgets.menu.Menu#getIconFillSpaceStyleName
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getIconBodyStyleName()  {
        return getAttributeAsString("iconBodyStyleName");
    }
    

    /**
     * Default properties for the automatically generated icon column. Default object includes properties to set width and to
     * show icon for this column. <P> To modify the behavior or appearance of this column, developers may set {@link
     * com.smartgwt.client.widgets.menu.Menu#getIconFieldProperties iconFieldProperties} at the instance level, or override
     * this object at the class level. If overriding this object, we recommend using  Class.changeDefaults rather than
     * replacing this object entirely. <P> See {@link com.smartgwt.client.widgets.menu.Menu#getShowIcons showIcons} for an
     * overview of the icon column.
     *
     * @param iconFieldDefaults  Default value is object
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setIconFieldDefaults(ListGridField iconFieldDefaults)  throws IllegalStateException {
        setAttribute("iconFieldDefaults", iconFieldDefaults.getJsObj(), false);
    }

    /**
     * Default properties for the automatically generated icon column. Default object includes properties to set width and to
     * show icon for this column. <P> To modify the behavior or appearance of this column, developers may set {@link
     * com.smartgwt.client.widgets.menu.Menu#getIconFieldProperties iconFieldProperties} at the instance level, or override
     * this object at the class level. If overriding this object, we recommend using  Class.changeDefaults rather than
     * replacing this object entirely. <P> See {@link com.smartgwt.client.widgets.menu.Menu#getShowIcons showIcons} for an
     * overview of the icon column.
     *
     * @return ListGridField
     */
    public ListGridField getIconFieldDefaults()  {
        return new ListGridField(getAttributeAsJavaScriptObject("iconFieldDefaults"));
    }
    

    /**
     * Custom properties for the automatically generated icon column. <P> See {@link
     * com.smartgwt.client.widgets.menu.Menu#getShowIcons showIcons} for an overview of the icon column.
     *
     * @param iconFieldProperties  Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setIconFieldProperties(ListGridField iconFieldProperties)  throws IllegalStateException {
        setAttribute("iconFieldProperties", iconFieldProperties.getJsObj(), false);
    }

    /**
     * Custom properties for the automatically generated icon column. <P> See {@link
     * com.smartgwt.client.widgets.menu.Menu#getShowIcons showIcons} for an overview of the icon column.
     *
     * @return ListGridField
     */
    public ListGridField getIconFieldProperties()  {
        return new ListGridField(getAttributeAsJavaScriptObject("iconFieldProperties"));
    }
    

    /**
     * If set, alternative body style for the menu used when there is an icon field and the {@link
     * com.smartgwt.client.widgets.menu.Menu#getPlacement placement} settings indicate the menu will be filling a portion of
     * the screen or a panel.  Generally this alternative style should not have rounded or excessively large edges.  In RTL
     * mode, the <code>iconFillSpaceStyleName</code> is suffixed with "RTL", which allows skins to apply different styles in
     * LTR and RTL modes.  If unset, then {@link com.smartgwt.client.widgets.menu.Menu#getIconBodyStyleName iconBodyStyleName}
     * is used instead. <p> Note: Like <code>iconBodyStyleName</code>, any skin which uses <code>iconFillSpaceStyleName</code>
     * should add "RTL" styles as well, even if identical to LTR styles. Otherwise, menus may lose their styling in RTL mode.
     *
     * @param iconFillSpaceStyleName  See {@link com.smartgwt.client.docs.CSSStyleName CSSStyleName} . Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setIconFillSpaceStyleName(String iconFillSpaceStyleName)  throws IllegalStateException {
        setAttribute("iconFillSpaceStyleName", iconFillSpaceStyleName, false);
    }

    /**
     * If set, alternative body style for the menu used when there is an icon field and the {@link
     * com.smartgwt.client.widgets.menu.Menu#getPlacement placement} settings indicate the menu will be filling a portion of
     * the screen or a panel.  Generally this alternative style should not have rounded or excessively large edges.  In RTL
     * mode, the <code>iconFillSpaceStyleName</code> is suffixed with "RTL", which allows skins to apply different styles in
     * LTR and RTL modes.  If unset, then {@link com.smartgwt.client.widgets.menu.Menu#getIconBodyStyleName iconBodyStyleName}
     * is used instead. <p> Note: Like <code>iconBodyStyleName</code>, any skin which uses <code>iconFillSpaceStyleName</code>
     * should add "RTL" styles as well, even if identical to LTR styles. Otherwise, menus may lose their styling in RTL mode.
     *
     * @return  See {@link com.smartgwt.client.docs.CSSStyleName CSSStyleName} 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getIconFillSpaceStyleName()  {
        return getAttributeAsString("iconFillSpaceStyleName");
    }
    

    /**
     * The default height applied to custom icons in this menu. This is used whenever          item.iconHeight is not
     * specified.
     *
     * @param iconHeight  Default value is 16
     */
    public void setIconHeight(int iconHeight) {
        setAttribute("iconHeight", iconHeight, true);
    }

    /**
     * The default height applied to custom icons in this menu. This is used whenever          item.iconHeight is not
     * specified.
     *
     * @return int
     */
    public int getIconHeight()  {
        return getAttributeAsInt("iconHeight");
    }
    

    /**
     * The default width applied to custom icons in this menu. This is used whenever          item.iconWidth is not specified.
     *
     * @param iconWidth  Default value is 16
     */
    public void setIconWidth(int iconWidth) {
        setAttribute("iconWidth", iconWidth, true);
    }

    /**
     * The default width applied to custom icons in this menu. This is used whenever          item.iconWidth is not specified.
     *
     * @return int
     */
    public int getIconWidth()  {
        return getAttributeAsInt("iconWidth");
    }
    

    /**
     * Synonym for {@link com.smartgwt.client.widgets.menu.Menu#getData data}
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Synonym for {@link com.smartgwt.client.widgets.menu.Menu#setData Menu.setData}.
     *
     * @param items new items for this menu. Default value is null
     */
    public void setItems(MenuItem... items) {
        setAttribute("items", items, true);
    }
    

    /**
     * Default properties for the automatically generated icon column. Default object includes properties to set width and to
     * show key for this column. <P> To modify the behavior or appearance of this column, developers may set {@link
     * com.smartgwt.client.widgets.menu.Menu#getKeyFieldProperties keyFieldProperties} at the instance level, or override this
     * object at the class level. If overriding this object, we recommend using  Class.changeDefaults rather than replacing
     * this object entirely. <P> See {@link com.smartgwt.client.widgets.menu.Menu#getShowKeys showKeys} for an overview of the
     * key column.
     *
     * @param keyFieldDefaults  Default value is object
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setKeyFieldDefaults(ListGridField keyFieldDefaults)  throws IllegalStateException {
        setAttribute("keyFieldDefaults", keyFieldDefaults.getJsObj(), false);
    }

    /**
     * Default properties for the automatically generated icon column. Default object includes properties to set width and to
     * show key for this column. <P> To modify the behavior or appearance of this column, developers may set {@link
     * com.smartgwt.client.widgets.menu.Menu#getKeyFieldProperties keyFieldProperties} at the instance level, or override this
     * object at the class level. If overriding this object, we recommend using  Class.changeDefaults rather than replacing
     * this object entirely. <P> See {@link com.smartgwt.client.widgets.menu.Menu#getShowKeys showKeys} for an overview of the
     * key column.
     *
     * @return ListGridField
     */
    public ListGridField getKeyFieldDefaults()  {
        return new ListGridField(getAttributeAsJavaScriptObject("keyFieldDefaults"));
    }
    

    /**
     * Custom properties for the automatically generated key column. <P> See {@link
     * com.smartgwt.client.widgets.menu.Menu#getShowKeys showKeys} for an overview of the key column.
     *
     * @param keyFieldProperties  Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setKeyFieldProperties(ListGridField keyFieldProperties)  throws IllegalStateException {
        setAttribute("keyFieldProperties", keyFieldProperties.getJsObj(), false);
    }

    /**
     * Custom properties for the automatically generated key column. <P> See {@link
     * com.smartgwt.client.widgets.menu.Menu#getShowKeys showKeys} for an overview of the key column.
     *
     * @return ListGridField
     */
    public ListGridField getKeyFieldProperties()  {
        return new ListGridField(getAttributeAsJavaScriptObject("keyFieldProperties"));
    }
    

    /**
     * For a menu that has a {@link com.smartgwt.client.widgets.menu.MenuButton} generated for it automatically (for example
     * when included in a {@link com.smartgwt.client.widgets.menu.MenuBar}, the width that the MenuButton should have.  If
     * unset, the MenuButton will be as wide as <code>menu.width</code>.
     *
     * @param menuButtonWidth  Default value is null
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
     * @return Integer
     */
    public Integer getMenuButtonWidth()  {
        return getAttributeAsInt("menuButtonWidth");
    }
    

    /**
     * Navigation bar shown when {@link com.smartgwt.client.widgets.menu.Menu#getPlacement placement} setting indicates that
     * the menu should be shown filling a portion of the screen or a panel.
     * <p>
     * For an overview of how to use and configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return NavigationBar
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public NavigationBar getNavigationBar() throws IllegalStateException {
        errorIfNotCreated("navigationBar");
        return (NavigationBar)NavigationBar.getByJSObject(getAttributeAsJavaScriptObject("navigationBar"));
    }
    

    /**
     * When the {@link com.smartgwt.client.widgets.menu.Menu#getPlacement placement} setting indicates that the menu should be
     * shown filling a portion of the screen or a panel, <code>navStack</code> is a container element created to hold the
     * {@link com.smartgwt.client.widgets.layout.NavigationBar} and any submenus that are shown by the menu.
     * <p>
     * For an overview of how to use and configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Canvas
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public Canvas getNavStack() throws IllegalStateException {
        errorIfNotCreated("navStack");
        return (Canvas)Canvas.getByJSObject(getAttributeAsJavaScriptObject("navStack"));
    }
    

    /**
     * Where should the menu be placed on the screen? <p> Default is to use {@link com.smartgwt.client.types.PanelPlacement}
     * "fillScreen" if {@link com.smartgwt.client.util.Browser#isHandset isHandset}.  In any non-handset device,
     * <code>placement</code> is unset, so the menu defaults to normal placement (near the originating MenuButton, or the mouse
     * for a context menu, or according to left/top/width/height for a manually created Menu). <p> When using any
     * <code>placement</code> setting that fills a portion of the screen or a  panel, submenus are displayed by sliding them
     * into place on top of the currently active menu, and a {@link com.smartgwt.client.widgets.layout.NavigationBar
     * menu.navigationBar} is used to manage navigation to the main menu (and provide dismissal, via a {@link
     * com.smartgwt.client.widgets.menu.Menu#getCancelButtonTitle cancel button}.
     *
     * @param placement  Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setPlacement(PanelPlacement placement)  throws IllegalStateException {
        setAttribute("placement", placement == null ? null : placement.getValue(), false);
    }

    /**
     * Where should the menu be placed on the screen? <p> Default is to use {@link com.smartgwt.client.types.PanelPlacement}
     * "fillScreen" if {@link com.smartgwt.client.util.Browser#isHandset isHandset}.  In any non-handset device,
     * <code>placement</code> is unset, so the menu defaults to normal placement (near the originating MenuButton, or the mouse
     * for a context menu, or according to left/top/width/height for a manually created Menu). <p> When using any
     * <code>placement</code> setting that fills a portion of the screen or a  panel, submenus are displayed by sliding them
     * into place on top of the currently active menu, and a {@link com.smartgwt.client.widgets.layout.NavigationBar
     * menu.navigationBar} is used to manage navigation to the main menu (and provide dismissal, via a {@link
     * com.smartgwt.client.widgets.menu.Menu#getCancelButtonTitle cancel button}.
     *
     * @return PanelPlacement
     */
    public PanelPlacement getPlacement()  {
        return EnumUtil.getEnum(PanelPlacement.values(), getAttribute("placement"));
    }
    

    /**
     * When this menu is shown how should it animate into view? By default the menu will just show at the specified
     * size/position. Options for animated show effects are <code>"fade"</code> to fade from transparent to visible,
     * <code>"slide"</code> to slide the menu into view, or <code>"wipe"</code> to have the menu grow into view, revealing its
     * content as it grows. Can be overridden by passing the 'animationEffect' parameter to 'menu.show()'
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param showAnimationEffect  Default value is null
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
     * @return String
     */
    public String getShowAnimationEffect()  {
        return getAttributeAsString("showAnimationEffect");
    }
    

    /**
     * <code>showEdges</code> dynamically defaults to false when the {@link com.smartgwt.client.widgets.menu.Menu#getPlacement
     * placement} setting indicates the Menu will be filling a portion of the screen or a panel.
     *
     * @param showEdges  Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setShowEdges(Boolean showEdges)  throws IllegalStateException {
        setAttribute("showEdges", showEdges, false);
    }

    /**
     * <code>showEdges</code> dynamically defaults to false when the {@link com.smartgwt.client.widgets.menu.Menu#getPlacement
     * placement} setting indicates the Menu will be filling a portion of the screen or a panel.
     *
     * @return Boolean
     */
    public Boolean getShowEdges()  {
        return getAttributeAsBoolean("showEdges");
    }
    

    /**
     * A boolean, indicating whether the checkmark/custom icon column should be displayed. If showIcons is not set, the menu
     * will show the icon column only if one of its items specifies an icon, checked, checkIf, or dynamicIcon property.
     *
     * @param showIcons  Default value is true
     */
    public void setShowIcons(Boolean showIcons) {
        setAttribute("showIcons", showIcons, true);
    }

    /**
     * A boolean, indicating whether the checkmark/custom icon column should be displayed. If showIcons is not set, the menu
     * will show the icon column only if one of its items specifies an icon, checked, checkIf, or dynamicIcon property.
     *
     * @return Boolean
     */
    public Boolean getShowIcons()  {
        Boolean result = getAttributeAsBoolean("showIcons");
        return result == null ? true : result;
    }
    

    /**
     * A boolean, indicating whether the shortcut key column should be displayed. If showKeys is not set, the menu will show
     * the key column only if one of its items specifies a keys property. If showKeys is false, the keys will not be displayed,
     * but will still function.
     *
     * @param showKeys  Default value is true
     */
    public void setShowKeys(Boolean showKeys) {
        setAttribute("showKeys", showKeys, true);
    }

    /**
     * A boolean, indicating whether the shortcut key column should be displayed. If showKeys is not set, the menu will show
     * the key column only if one of its items specifies a keys property. If showKeys is false, the keys will not be displayed,
     * but will still function.
     *
     * @return Boolean
     */
    public Boolean getShowKeys()  {
        Boolean result = getAttributeAsBoolean("showKeys");
        return result == null ? true : result;
    }
    

    /**
     * <code>showShadow</code> dynamically defaults to false when the {@link com.smartgwt.client.widgets.menu.Menu#getPlacement
     * placement} setting indicates the Menu will be filling a portion of the screen or a panel.
     *
     * @param showShadow  Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setShowShadow(Boolean showShadow)  throws IllegalStateException {
        setAttribute("showShadow", showShadow, false);
    }

    /**
     * <code>showShadow</code> dynamically defaults to false when the {@link com.smartgwt.client.widgets.menu.Menu#getPlacement
     * placement} setting indicates the Menu will be filling a portion of the screen or a panel.
     *
     * @return Boolean
     */
    public Boolean getShowShadow()  {
        return getAttributeAsBoolean("showShadow");
    }
    

    /**
     * A boolean, indicating whether the submenu indicator column should be displayed. If showSubmenus is not set, the menu
     * will show the indicator column only if one of its items specifies a submenu property. If showSubmenus is false, the
     * submenu arrows will not be displayed, but submenus will still appear on rollover.
     *
     * @param showSubmenus  Default value is true
     */
    public void setShowSubmenus(Boolean showSubmenus) {
        setAttribute("showSubmenus", showSubmenus, true);
    }

    /**
     * A boolean, indicating whether the submenu indicator column should be displayed. If showSubmenus is not set, the menu
     * will show the indicator column only if one of its items specifies a submenu property. If showSubmenus is false, the
     * submenu arrows will not be displayed, but submenus will still appear on rollover.
     *
     * @return Boolean
     */
    public Boolean getShowSubmenus()  {
        Boolean result = getAttributeAsBoolean("showSubmenus");
        return result == null ? true : result;
    }
    

    /**
     * When using a Tree or hierarchical DataSource as the menu's data, optional subclass of Menu that should be used when
     * generating submenus.
     *
     * @param submenuConstructor  See {@link com.smartgwt.client.docs.SCClassName SCClassName} . Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setSubmenuConstructor(String submenuConstructor)  throws IllegalStateException {
        setAttribute("submenuConstructor", submenuConstructor, false);
    }

    /**
     * When using a Tree or hierarchical DataSource as the menu's data, optional subclass of Menu that should be used when
     * generating submenus.
     *
     * @return  See {@link com.smartgwt.client.docs.SCClassName SCClassName} 
     */
    public String getSubmenuConstructor()  {
        return getAttributeAsString("submenuConstructor");
    }
    

    /**
     * Should submenus show up on our left or right. Can validly be set to <code>"left"</code> or <code>"right"</code>. If
     * unset, submenus show up on the right by default in Left-to-right text mode, or on the left in Right-to-left text mode
     * (see {@link com.smartgwt.client.util.Page#isRTL Page.isRTL}).
     *
     * @param submenuDirection  Default value is null
     */
    public void setSubmenuDirection(String submenuDirection) {
        setAttribute("submenuDirection", submenuDirection, true);
    }

    /**
     * Should submenus show up on our left or right. Can validly be set to <code>"left"</code> or <code>"right"</code>. If
     * unset, submenus show up on the right by default in Left-to-right text mode, or on the left in Right-to-left text mode
     * (see {@link com.smartgwt.client.util.Page#isRTL Page.isRTL}).
     *
     * @return String
     */
    public String getSubmenuDirection()  {
        return getAttributeAsString("submenuDirection");
    }
    

    /**
     * Default image to use for the submenu indicator when item is disabled. Valid src, width and height must be specified. See
     * {@link com.smartgwt.client.widgets.ImgProperties} for format.<br> If {@link
     * com.smartgwt.client.widgets.menu.Menu#getSubmenuDirection submenuDirection} is set to <code>"left"</code>, the image src
     * will have the suffix <code>"_left"</code> appended to it.
     *
     * @param submenuDisabledImage  Default value is {...}
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setSubmenuDisabledImage(Img submenuDisabledImage)  throws IllegalStateException {
        JavaScriptObject config = submenuDisabledImage == null ? null : submenuDisabledImage.getConfig();
        setAttribute("submenuDisabledImage", JSOHelper.cleanProperties(config, true), false);
    }

    /**
     * Default image to use for the submenu indicator when item is disabled. Valid src, width and height must be specified. See
     * {@link com.smartgwt.client.widgets.ImgProperties} for format.<br> If {@link
     * com.smartgwt.client.widgets.menu.Menu#getSubmenuDirection submenuDirection} is set to <code>"left"</code>, the image src
     * will have the suffix <code>"_left"</code> appended to it.
     *
     * @return Img
     */
    public Img getSubmenuDisabledImage()  {
        Img properties = new Img();
        properties.setConfigOnly(true);
        properties.setConfig(getAttributeAsJavaScriptObject("submenuDisabledImage"));
        return properties;
    }
    

    /**
     * Default properties for the automatically generated submenu column. Default object includes properties to set width,
     * align and to show submenu icon for this column. <P> To modify the behavior or appearance of this column, developers may
     * set {@link com.smartgwt.client.widgets.menu.Menu#getSubmenuFieldProperties submenuFieldProperties} at the instance
     * level, or override this object at the class level. If overriding this object, we recommend using  Class.changeDefaults
     * rather than replacing this object entirely. <P> See {@link com.smartgwt.client.widgets.menu.Menu#getShowSubmenus
     * showSubmenus} for an overview of the submenu column.
     *
     * @param submenuFieldDefaults  Default value is object
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setSubmenuFieldDefaults(ListGridField submenuFieldDefaults)  throws IllegalStateException {
        setAttribute("submenuFieldDefaults", submenuFieldDefaults.getJsObj(), false);
    }

    /**
     * Default properties for the automatically generated submenu column. Default object includes properties to set width,
     * align and to show submenu icon for this column. <P> To modify the behavior or appearance of this column, developers may
     * set {@link com.smartgwt.client.widgets.menu.Menu#getSubmenuFieldProperties submenuFieldProperties} at the instance
     * level, or override this object at the class level. If overriding this object, we recommend using  Class.changeDefaults
     * rather than replacing this object entirely. <P> See {@link com.smartgwt.client.widgets.menu.Menu#getShowSubmenus
     * showSubmenus} for an overview of the submenu column.
     *
     * @return ListGridField
     */
    public ListGridField getSubmenuFieldDefaults()  {
        return new ListGridField(getAttributeAsJavaScriptObject("submenuFieldDefaults"));
    }
    

    /**
     * Custom properties for the automatically generated submenu column. <P> See {@link
     * com.smartgwt.client.widgets.menu.Menu#getShowSubmenus showSubmenus} for an overview of the submenu column.
     *
     * @param submenuFieldProperties  Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setSubmenuFieldProperties(ListGridField submenuFieldProperties)  throws IllegalStateException {
        setAttribute("submenuFieldProperties", submenuFieldProperties.getJsObj(), false);
    }

    /**
     * Custom properties for the automatically generated submenu column. <P> See {@link
     * com.smartgwt.client.widgets.menu.Menu#getShowSubmenus showSubmenus} for an overview of the submenu column.
     *
     * @return ListGridField
     */
    public ListGridField getSubmenuFieldProperties()  {
        return new ListGridField(getAttributeAsJavaScriptObject("submenuFieldProperties"));
    }
    

    /**
     * Default image to use for the submenu indicator. Valid src, width and height must be specified. See {@link
     * com.smartgwt.client.widgets.ImgProperties} for format.<br> If {@link
     * com.smartgwt.client.widgets.menu.Menu#getSubmenuDirection submenuDirection} is set to <code>"left"</code>, the image src
     * will have the suffix <code>"_left"</code> appended to it.
     *
     * @param submenuImage  Default value is {...}
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setSubmenuImage(Img submenuImage)  throws IllegalStateException {
        JavaScriptObject config = submenuImage == null ? null : submenuImage.getConfig();
        setAttribute("submenuImage", JSOHelper.cleanProperties(config, true), false);
    }

    /**
     * Default image to use for the submenu indicator. Valid src, width and height must be specified. See {@link
     * com.smartgwt.client.widgets.ImgProperties} for format.<br> If {@link
     * com.smartgwt.client.widgets.menu.Menu#getSubmenuDirection submenuDirection} is set to <code>"left"</code>, the image src
     * will have the suffix <code>"_left"</code> appended to it.
     *
     * @return Img
     */
    public Img getSubmenuImage()  {
        Img properties = new Img();
        properties.setConfigOnly(true);
        properties.setConfig(getAttributeAsJavaScriptObject("submenuImage"));
        return properties;
    }
    

    /**
     * Optional target canvas for this menu.  Available as a parameter to dynamic menuItem configuration methods such as {@link
     * com.smartgwt.client.widgets.menu.MenuItem#checkIf MenuItem.checkIf}. <P> Whenever a Menu is shown as a contextMenu by a
     * widget due to {@link com.smartgwt.client.widgets.Canvas#getContextMenu contextMenu} being set, <code>menu.target</code>
     * is automatically set to the widget that showed the contextMenu. <P> If this item has any {@link
     * com.smartgwt.client.widgets.menu.MenuItem#getSubmenu submenus} the <code>target</code> will be propagated down to these
     * child menus.
     *
     * @param target  Default value is null
     */
    public void setTarget(Canvas target) {
        setAttribute("target", target == null ? null : target.getOrCreateJsObj(), true);
    }

    /**
     * Optional target canvas for this menu.  Available as a parameter to dynamic menuItem configuration methods such as {@link
     * com.smartgwt.client.widgets.menu.MenuItem#checkIf MenuItem.checkIf}. <P> Whenever a Menu is shown as a contextMenu by a
     * widget due to {@link com.smartgwt.client.widgets.Canvas#getContextMenu contextMenu} being set, <code>menu.target</code>
     * is automatically set to the widget that showed the contextMenu. <P> If this item has any {@link
     * com.smartgwt.client.widgets.menu.MenuItem#getSubmenu submenus} the <code>target</code> will be propagated down to these
     * child menus.
     *
     * @return Canvas
     */
    public Canvas getTarget()  {
        return (Canvas)Canvas.getByJSObject(getAttributeAsJavaScriptObject("target"));
    }
    

    /**
     * Default properties for the automatically generated title column. Default object includes properties to set width and to
     * show title for this column. <P> To modify the behavior or appearance of this column, developers may set {@link
     * com.smartgwt.client.widgets.menu.Menu#getTitleFieldProperties titleFieldProperties} at the instance level, or override
     * this object at the class level. If overriding this object, we recommend using  Class.changeDefaults rather than
     * replacing this object entirely.
     *
     * @param titleFieldDefaults  Default value is object
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setTitleFieldDefaults(ListGridField titleFieldDefaults)  throws IllegalStateException {
        setAttribute("titleFieldDefaults", titleFieldDefaults.getJsObj(), false);
    }

    /**
     * Default properties for the automatically generated title column. Default object includes properties to set width and to
     * show title for this column. <P> To modify the behavior or appearance of this column, developers may set {@link
     * com.smartgwt.client.widgets.menu.Menu#getTitleFieldProperties titleFieldProperties} at the instance level, or override
     * this object at the class level. If overriding this object, we recommend using  Class.changeDefaults rather than
     * replacing this object entirely.
     *
     * @return ListGridField
     */
    public ListGridField getTitleFieldDefaults()  {
        return new ListGridField(getAttributeAsJavaScriptObject("titleFieldDefaults"));
    }
    

    /**
     * Custom properties for the automatically generated title column.
     *
     * @param titleFieldProperties  Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setTitleFieldProperties(ListGridField titleFieldProperties)  throws IllegalStateException {
        setAttribute("titleFieldProperties", titleFieldProperties.getJsObj(), false);
    }

    /**
     * Custom properties for the automatically generated title column.
     *
     * @return ListGridField
     */
    public ListGridField getTitleFieldProperties()  {
        return new ListGridField(getAttributeAsJavaScriptObject("titleFieldProperties"));
    }
    

    /**
     * A boolean indicating whether this menu should use shortcut keys. Set useKeys to false in a menu's initialization block
     * to explicitly disable shortcut keys.
     *
     * @param useKeys  Default value is true
     */
    public void setUseKeys(Boolean useKeys) {
        setAttribute("useKeys", useKeys, true);
    }

    /**
     * A boolean indicating whether this menu should use shortcut keys. Set useKeys to false in a menu's initialization block
     * to explicitly disable shortcut keys.
     *
     * @return Boolean
     */
    public Boolean getUseKeys()  {
        Boolean result = getAttributeAsBoolean("useKeys");
        return result == null ? true : result;
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
        if(ret == null) return null;
        return @com.smartgwt.client.widgets.menu.MenuItem::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;


	/**
     * Hide the context menu - alias for hide()
     * @see com.smartgwt.client.docs.Visibility Visibility overview and related methods
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
        var itemClick = $debox($entry(function(param){
                var event = @com.smartgwt.client.widgets.menu.events.ItemClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                return !ret;
            }));
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            obj.addProperties({itemClick: 
                function () {
                    var param = {"item" : arguments[0], "colNum" : arguments[1]};
                    return itemClick(param) == true;
                }
             });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.itemClick = 
                function () {
                    var param = {"item" : arguments[0], "colNum" : arguments[1]};
                    return itemClick(param) == true;
                }
            ;
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
        var ret = self.showContextMenu();
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(ret);
    }-*/;


    // ********************* Static Methods ***********************
	/**
     * Hide all menus that are currently open. This method is useful to hide the current set of menus including submenus, and
     * dismiss the menu's clickMask.
     */
    public static native void hideAllMenus() /*-{
        $wnd.isc.Menu.hideAllMenus();
    }-*/;


    /** 
     * Class level method to set the default properties of this class.  If set, then all
     * existing and subsequently created instances of this class will automatically have
     * default properties corresponding to
     * the properties set on the SmartGWT class instance passed to this function before its
     * underlying SmartClient JS object was created.
     * This is a powerful feature that eliminates the need for users to create a separate
     * hierarchy of subclasses that only alter the default properties of this class. Can also
     * be used for skinning / styling purposes.  <P> <b>Note:</b> This method is intended for
     * setting default attributes only and will affect all instances of the underlying class
     * (including those automatically generated in JavaScript).  This method should not be used
     * to apply standard EventHandlers or override methods for a class - use a custom subclass
     * instead.  Calling this method after instances have been created can result in undefined
     * behavior, since it bypasses any setters and a class instance may have already examined 
     * a particular property and not be expecting any changes through this route.
     *
     * @param menuProperties properties that should be used as new defaults when instances of this class are created
     */
    public static native void setDefaultProperties(Menu menuProperties) /*-{
    	var properties = $wnd.isc.addProperties({},menuProperties.@com.smartgwt.client.widgets.BaseWidget::getConfig()());
        @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(properties,false);
        $wnd.isc.Menu.addProperties(properties);
    }-*/;

    // ***********************************************************


    public static final ListGridField ICON_FIELD = new ListGridField("menuBuiltin_icon");
    public static final ListGridField TITLE_FIELD = new ListGridField("menuBuiltin_title");
    public static final ListGridField KEY_FIELD = new ListGridField("menuBuiltin_key");
    public static final ListGridField SUBMENU_FIELD = new ListGridField("menuBuiltin_submenu");

    //override to avoid ListGrid's onInit behavior
    protected void onInit_ListGrid() {
    }

    /**
     * Creates and returns the submenu associated with the provided MenuItem.
     *
     * @param menuItem to target
     * @return submenu for that menuItem
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#menus_category_appearance" 
     * target="examples">Appearance Example</a>
     */
    public native Menu getSubmenu(MenuItem item) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()(),
            itemJS = item.@com.smartgwt.client.core.DataClass::getJsObj()();
        if (itemJS == null) return null;
        var ret = self.getSubmenu(itemJS);
        if (ret == null) return null;
        return @com.smartgwt.client.widgets.menu.Menu::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

    /**
     * For a <code>Menu</code> that uses a DataSource, these properties will be passed to the
     * automatically-created ResultTree.  This can be used for various customizations such as
     * modifying the automatically-chosen 
     * {@link com.smartgwt.client.widgets.tree.Tree#getParentIdField parentIdField}.
     *
     * @param dataProperties dataProperties Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.Databinding Databinding overview and related methods
     */
    public void setDataProperties(Tree dataProperties)  throws IllegalStateException {
        JavaScriptObject config = dataProperties.getConfig();
        setAttribute("dataProperties", JSOHelper.cleanProperties(config, true), true);
    }

    /**
     * Return the menu items.
     *
     * @return the menu items
     */
    public MenuItem[] getItems() {
        JavaScriptObject dataJS;
        if (!this.isCreated()) {
            dataJS = getAttributeAsJavaScriptObject("items");
        } else {
            dataJS = getAttributeAsJavaScriptObject("data");
        }
        if (dataJS == null) return null;
        MenuItem[] data = com.smartgwt.client.util.ConvertTo.arrayOfMenuItem(dataJS);
        return data;
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

    /**
     * Checks or unchecks the menu item according to the value of newState, and redraws the menu if necessary. Returns true if
     * there's a change in the checked state.
     * @param item MenuItem in question, or it's index
     *
     * @return true if the checked state was changed
     */
    public native Boolean setItemChecked(MenuItem item) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var itemJS = item.@com.smartgwt.client.core.DataClass::getJsObj()();
        var retVal =self.setItemChecked(itemJS);
        if(retVal == null || retVal === undefined) {
            return null;
        } else {
            return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
        }
    }-*/;

    /**
     * Checks or unchecks the menu item according to the value of newState, and redraws the menu if necessary. Returns true if
     * there's a change in the checked state.
     * @param item MenuItem in question, or it's index
     *
     * @return true if the checked state was changed
     */
    public native Boolean setItemChecked(int item) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var retVal =self.setItemChecked(item);
        if(retVal == null || retVal === undefined) {
            return null;
        } else {
            return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
        }
    }-*/;


    /**
     * Checks or unchecks the menu item according to the value of newState, and redraws the menu if necessary. Returns true if
     * there's a change in the checked state.
     * @param item MenuItem in question, or it's index
     * @param newState true to check the menu item, false to uncheck it.  If not                             passed, true is assumed
     *
     * @return true if the checked state was changed
     */
    public native Boolean setItemChecked(MenuItem item, boolean newState) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var itemJS = item.@com.smartgwt.client.core.DataClass::getJsObj()();
        var retVal =self.setItemChecked(itemJS, newState);
        if(retVal == null || retVal === undefined) {
            return null;
        } else {
                return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
        }
    }-*/;

    /**
     * Checks or unchecks the menu item according to the value of newState, and redraws the menu if necessary. Returns true if
     * there's a change in the checked state.
     * @param item MenuItem in question, or it's index
     * @param newState true to check the menu item, false to uncheck it.  If not                             passed, true is assumed
     *
     * @return true if the checked state was changed
     */
    public native Boolean setItemChecked(int item, boolean newState) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var retVal =self.setItemChecked(item, newState);
        if(retVal == null || retVal === undefined) {
            return null;
        } else {
                return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
        }
    }-*/;

    /**
     * Enables or disables the menu item according to the value of newState, and redraws the menu if necessary. Returns true if
     * there's a change in the enabled state.
     * @param item MenuItem in question, or it's index
     *
     * @return true if the enabled state was changed
     */
    public native Boolean setItemEnabled(MenuItem item) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var itemJS = item.@com.smartgwt.client.core.DataClass::getJsObj()();
        var retVal =self.setItemEnabled(itemJS);
        if(retVal == null || retVal === undefined) {
            return null;
        } else {
            return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
        }
    }-*/;

    /**
     * Enables or disables the menu item according to the value of newState, and redraws the menu if necessary. Returns true if
     * there's a change in the enabled state.
     * @param item MenuItem in question, or it's index
     *
     * @return true if the enabled state was changed
     */
    public native Boolean setItemEnabled(int item) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var retVal =self.setItemEnabled(item);
        if(retVal == null || retVal === undefined) {
            return null;
        } else {
            return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
        }
    }-*/;


    /**
     * Enables or disables the menu item according to the value of newState, and redraws the menu if necessary. Returns true if
     * there's a change in the enabled state.
     * @param item MenuItem in question, or it's index
     * @param newState true to enable the menu item, false to disable it.  If not                             passed, true is assumed
     *
     * @return true if the enabled state was changed
     */
    public native Boolean setItemEnabled(MenuItem item, boolean newState) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var itemJS = item.@com.smartgwt.client.core.DataClass::getJsObj()();
        var retVal =self.setItemEnabled(itemJS, newState);
        if(retVal == null || retVal === undefined) {
            return null;
        } else {
                return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
        }
    }-*/;

    /**
     * Enables or disables the menu item according to the value of newState, and redraws the menu if necessary. Returns true if
     * there's a change in the enabled state.
     * @param item MenuItem in question, or it's index
     * @param newState true to enable the menu item, false to disable it.  If not                             passed, true is assumed
     *
     * @return true if the enabled state was changed
     */
    public native Boolean setItemEnabled(int item, boolean newState) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var retVal =self.setItemEnabled(item, newState);
        if(retVal == null || retVal === undefined) {
            return null;
        } else {
                return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
        }
    }-*/;


    /**
     * Sets the icon and disabled icon (if specified) for a particular menu item and redraws the menu if necessary. Returns
     * true if the icon changed.
     * @param item MenuItem in question, or it's index
     * @param newIcon new icon URL
     *
     * @return true == something changed, redraw is called for
     */
    public native Boolean setItemIcon(MenuItem item, String newIcon) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var itemJS = item.@com.smartgwt.client.core.DataClass::getJsObj()();
        var retVal =self.setItemIcon(itemJS, newIcon);
        if(retVal == null || retVal === undefined) {
            return null;
        } else {
            return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
        }
    }-*/;

    /**
     * Sets the icon and disabled icon (if specified) for a particular menu item and redraws the menu if necessary. Returns
     * true if the icon changed.
     * @param item MenuItem in question, or it's index
     * @param newIcon new icon URL
     *
     * @return true == something changed, redraw is called for
     */
    public native Boolean setItemIcon(int item, String newIcon) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var retVal =self.setItemIcon(item, newIcon);
        if(retVal == null || retVal === undefined) {
            return null;
        } else {
            return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
        }
    }-*/;

    /**
     * Sets the icon and disabled icon (if specified) for a particular menu item and redraws the menu if necessary. Returns
     * true if the icon changed.
     * @param item MenuItem in question, or it's index
     * @param newIcon new icon URL
     * @param newDisabledIcon new icon URL for disabled image
     *
     * @return true == something changed, redraw is called for
     */
    public native Boolean setItemIcon(MenuItem item, String newIcon, String newDisabledIcon) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var itemJS = item.@com.smartgwt.client.core.DataClass::getJsObj()();
        var retVal =self.setItemIcon(itemJS, newIcon, newDisabledIcon);
        if(retVal == null || retVal === undefined) {
            return null;
        } else {
                return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
        }
    }-*/;

    /**
     * Sets the icon and disabled icon (if specified) for a particular menu item and redraws the menu if necessary. Returns
     * true if the icon changed.
     * @param item MenuItem in question, or it's index
     * @param newIcon new icon URL
     * @param newDisabledIcon new icon URL for disabled image
     *
     * @return true == something changed, redraw is called for
     */
    public native Boolean setItemIcon(int item, String newIcon, String newDisabledIcon) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var retVal =self.setItemIcon(item, newIcon, newDisabledIcon);
        if(retVal == null || retVal === undefined) {
            return null;
        } else {
                return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
        }
    }-*/;

    /**
     * Sets the title of a particular menu item to the string specified by newTitle and redraws the menu if necessary.
     * @param item MenuItem in question, or it's index
     * @param newTitle new title
     *
     * @return true if the title was changed, and false otherwise
     */
    public native Boolean setItemTitle(MenuItem item, String newTitle) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var itemJS = item.@com.smartgwt.client.core.DataClass::getJsObj()();
        var retVal =self.setItemTitle(itemJS, newTitle);
        if(retVal == null || retVal === undefined) {
            return null;
        } else {
            return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
        }
    }-*/;

    /**
     * Sets the title of a particular menu item to the string specified by newTitle and redraws the menu if necessary.
     * @param item MenuItem in question, or it's index
     * @param newTitle new title
     *
     * @return true if the title was changed, and false otherwise
     */
    public native Boolean setItemTitle(int item, String newTitle) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var retVal =self.setItemTitle(item, newTitle);
        if(retVal == null || retVal === undefined) {
            return null;
        } else {
            return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
        }
    }-*/;

    /**
     * SmartClient-driven Instantiation
     *
     * Provide a mechanism whereby a SGWT wrapper, created with a properties object contained
     * in a SmartClient object rather than a class instance, can be updated to "see" the
     * correct class instance when that instance is created by the SmartClient Framework.
     * Required for cases where, due to ordering constraints or availability of configuration,
     * the SC class instance can only be created on the SmartClient side and not by SGWT.
     */
    MenuItem parentItem;

    public static Menu getOrCreateRef(JavaScriptObject jsObj, MenuItem parentItem) {
        Menu menu = getOrCreateRef(jsObj);
        if (menu != null && !menu.isCreated()) menu.parentItem = parentItem;
        return menu;
    }

    public void relinkJavaScriptObject(JavaScriptObject jsObj) {
        parentItem = null;
        internalSetID(jsObj);
        onBind();
    }

    public JavaScriptObject getOrCreateJsObj() {
        if (isCreated()) return getJsObj();
        JavaScriptObject jsObj = super.getOrCreateJsObj();
        if (parentItem != null) parentItem.setSubmenu(this);
        return jsObj;
    }

    public native void setConfig(JavaScriptObject config) /*-{
        if ($wnd.isAn.Array(config)) config = {items: config};
        if (!$wnd.isAn.Instance(config)) config.__sgwtRelink = $entry(function(jsObj) {
            var jObj = this.__ref;
            jObj.@com.smartgwt.client.widgets.menu.Menu::relinkJavaScriptObject(Lcom/google/gwt/core/client/JavaScriptObject;)(this);
        })
        this.@com.smartgwt.client.widgets.BaseWidget::config = config;
    }-*/;

    public LogicalStructureObject setLogicalStructure(MenuLogicalStructure s) {
        super.setLogicalStructure(s);
        try {
            s.alternateRecordStyles = getAttributeAsString("alternateRecordStyles");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Menu.alternateRecordStyles:" + t.getMessage() + "\n";
        }
        try {
            s.autoDismiss = getAttributeAsString("autoDismiss");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Menu.autoDismiss:" + t.getMessage() + "\n";
        }
        try {
            s.autoDismissOnBlur = getAttributeAsString("autoDismissOnBlur");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Menu.autoDismissOnBlur:" + t.getMessage() + "\n";
        }
        try {
            s.autoDraw = getAttributeAsString("autoDraw");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Menu.autoDraw:" + t.getMessage() + "\n";
        }
        try {
            s.baseStyle = getAttributeAsString("baseStyle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Menu.baseStyle:" + t.getMessage() + "\n";
        }
        try {
            s.bodyStyleName = getAttributeAsString("bodyStyleName");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Menu.bodyStyleName:" + t.getMessage() + "\n";
        }
        try {
            s.cancelButtonTitle = getAttributeAsString("cancelButtonTitle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Menu.cancelButtonTitle:" + t.getMessage() + "\n";
        }
        try {
            s.canSelectParentItems = getAttributeAsString("canSelectParentItems");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Menu.canSelectParentItems:" + t.getMessage() + "\n";
        }
        try {
            s.cascadeAutoDismiss = getAttributeAsString("cascadeAutoDismiss");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Menu.cascadeAutoDismiss:" + t.getMessage() + "\n";
        }
        try {
            s.cellHeight = getAttributeAsString("cellHeight");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Menu.cellHeight:" + t.getMessage() + "\n";
        }
        try {
            s.checkmarkDisabledImage = getAttributeAsString("checkmarkDisabledImage");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Menu.checkmarkDisabledImage:" + t.getMessage() + "\n";
        }
        try {
            s.checkmarkImage = getAttributeAsString("checkmarkImage");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Menu.checkmarkImage:" + t.getMessage() + "\n";
        }
        try {
            s.dataSource = getDataSource();
        } catch (Throwable t) {
            s.logicalStructureErrors += "Menu.dataSource:" + t.getMessage() + "\n";
        }
        try {
            s.defaultWidth = getAttributeAsString("defaultWidth");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Menu.defaultWidth:" + t.getMessage() + "\n";
        }
        try {
            s.emptyMessage = getAttributeAsString("emptyMessage");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Menu.emptyMessage:" + t.getMessage() + "\n";
        }
        try {
            s.fetchSubmenus = getAttributeAsString("fetchSubmenus");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Menu.fetchSubmenus:" + t.getMessage() + "\n";
        }
        try {
            s.fieldsAsStringArrayArray = getAttributeAsStringArray("fields");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Menu.fieldsAsStringArrayArray:" + t.getMessage() + "\n";
        }
        try {
            s.fillSpaceStyleName = getAttributeAsString("fillSpaceStyleName");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Menu.fillSpaceStyleName:" + t.getMessage() + "\n";
        }
        try {
            s.iconBodyStyleName = getAttributeAsString("iconBodyStyleName");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Menu.iconBodyStyleName:" + t.getMessage() + "\n";
        }
        try {
            s.iconFieldDefaults = getAttributeAsString("iconFieldDefaults");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Menu.iconFieldDefaults:" + t.getMessage() + "\n";
        }
        try {
            s.iconFieldProperties = getAttributeAsString("iconFieldProperties");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Menu.iconFieldProperties:" + t.getMessage() + "\n";
        }
        try {
            s.iconFillSpaceStyleName = getAttributeAsString("iconFillSpaceStyleName");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Menu.iconFillSpaceStyleName:" + t.getMessage() + "\n";
        }
        try {
            s.iconHeight = getAttributeAsString("iconHeight");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Menu.iconHeight:" + t.getMessage() + "\n";
        }
        try {
            s.iconWidth = getAttributeAsString("iconWidth");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Menu.iconWidth:" + t.getMessage() + "\n";
        }
        try {
            s.keyFieldDefaults = getAttributeAsString("keyFieldDefaults");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Menu.keyFieldDefaults:" + t.getMessage() + "\n";
        }
        try {
            s.keyFieldProperties = getAttributeAsString("keyFieldProperties");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Menu.keyFieldProperties:" + t.getMessage() + "\n";
        }
        try {
            s.menuButtonWidth = getAttributeAsString("menuButtonWidth");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Menu.menuButtonWidth:" + t.getMessage() + "\n";
        }
        try {
            s.placement = getAttributeAsString("placement");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Menu.placement:" + t.getMessage() + "\n";
        }
        try {
            s.showAnimationEffect = getAttributeAsString("showAnimationEffect");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Menu.showAnimationEffect:" + t.getMessage() + "\n";
        }
        try {
            s.showEdges = getAttributeAsString("showEdges");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Menu.showEdges:" + t.getMessage() + "\n";
        }
        try {
            s.showIcons = getAttributeAsString("showIcons");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Menu.showIcons:" + t.getMessage() + "\n";
        }
        try {
            s.showKeys = getAttributeAsString("showKeys");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Menu.showKeys:" + t.getMessage() + "\n";
        }
        try {
            s.showShadow = getAttributeAsString("showShadow");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Menu.showShadow:" + t.getMessage() + "\n";
        }
        try {
            s.showSubmenus = getAttributeAsString("showSubmenus");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Menu.showSubmenus:" + t.getMessage() + "\n";
        }
        try {
            s.submenuConstructor = getAttributeAsString("submenuConstructor");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Menu.submenuConstructor:" + t.getMessage() + "\n";
        }
        try {
            s.submenuDirection = getAttributeAsString("submenuDirection");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Menu.submenuDirection:" + t.getMessage() + "\n";
        }
        try {
            s.submenuDisabledImage = getAttributeAsString("submenuDisabledImage");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Menu.submenuDisabledImage:" + t.getMessage() + "\n";
        }
        try {
            s.submenuFieldDefaults = getAttributeAsString("submenuFieldDefaults");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Menu.submenuFieldDefaults:" + t.getMessage() + "\n";
        }
        try {
            s.submenuFieldProperties = getAttributeAsString("submenuFieldProperties");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Menu.submenuFieldProperties:" + t.getMessage() + "\n";
        }
        try {
            s.submenuImage = getAttributeAsString("submenuImage");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Menu.submenuImage:" + t.getMessage() + "\n";
        }
        try {
            s.target = getTarget();
        } catch (Throwable t) {
            s.logicalStructureErrors += "Menu.target:" + t.getMessage() + "\n";
        }
        try {
            s.titleFieldDefaults = getAttributeAsString("titleFieldDefaults");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Menu.titleFieldDefaults:" + t.getMessage() + "\n";
        }
        try {
            s.titleFieldProperties = getAttributeAsString("titleFieldProperties");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Menu.titleFieldProperties:" + t.getMessage() + "\n";
        }
        try {
            s.useKeys = getAttributeAsString("useKeys");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Menu.useKeys:" + t.getMessage() + "\n";
        }
        return s;
    }

    public LogicalStructureObject getLogicalStructure() {
        MenuLogicalStructure s = new MenuLogicalStructure();
        setLogicalStructure(s);
        return s;
    }
}

