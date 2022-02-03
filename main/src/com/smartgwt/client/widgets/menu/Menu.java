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
import com.smartgwt.client.data.Record;
import com.smartgwt.client.data.events.*;
import com.smartgwt.client.browser.window.*;
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
import com.smartgwt.client.widgets.tour.*;
import com.smartgwt.client.widgets.notify.*;
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
import com.smartgwt.client.widgets.notify.*;
import com.smartgwt.client.widgets.drawing.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.gwt.event.shared.*;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.core.client.JavaScriptObject;

import com.smartgwt.client.util.*;
import com.smartgwt.client.util.events.*;
import com.smartgwt.client.util.workflow.*;
import com.smartgwt.client.util.workflow.Process; // required to override java.lang.Process
import com.smartgwt.client.util.tour.*;

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
import com.smartgwt.logicalstructure.widgets.ace.*;
import com.smartgwt.logicalstructure.widgets.tab.*;
import com.smartgwt.logicalstructure.widgets.tableview.*;
import com.smartgwt.logicalstructure.widgets.toolbar.*;
import com.smartgwt.logicalstructure.widgets.tree.*;
import com.smartgwt.logicalstructure.widgets.viewer.*;
import com.smartgwt.logicalstructure.widgets.calendar.*;
import com.smartgwt.logicalstructure.widgets.cube.*;
import com.smartgwt.logicalstructure.widgets.tools.*;
import com.smartgwt.logicalstructure.widgets.tour.*;

/**
 * The Menu widget class implements interactive menu widgets, with optional icons, submenus, and shortcut keys. <p> A Menu
 * is initialized with a set of {@link com.smartgwt.client.widgets.menu.MenuItem}s specified as {@link
 * com.smartgwt.client.widgets.menu.Menu#getItems items}, each of which represents one row in the menu's display and
 * specifies the action to take when that menu item is selected. <p> Each <code>MenuItem</code> can have a {@link
 * com.smartgwt.client.widgets.menu.MenuItem#getTitle title}, {@link com.smartgwt.client.widgets.menu.MenuItem#getIcon
 * icon}, {@link com.smartgwt.client.widgets.menu.MenuItem#getKeys shortcut keys}, optional {@link
 * com.smartgwt.client.widgets.menu.MenuItem#getSubmenu MenuItem.submenu} and various other settings.  Alternatively, a
 * <code>MenuItem</code> can contain an arbitrary widget via {@link
 * com.smartgwt.client.widgets.menu.MenuItem#getEmbeddedComponent MenuItem.embeddedComponent}. <p> To create a context menu
 * for a component, provide a Menu instance for the {@link com.smartgwt.client.widgets.Canvas#getContextMenu
 * Canvas.contextMenu} property.  Note that some components like {@link com.smartgwt.client.widgets.grid.ListGrid} have
 * more specific properties because they have distinct regions or because they have a default set of context menu actions
 * available (for example: {@link com.smartgwt.client.widgets.grid.ListGrid#getHeaderContextMenu
 * ListGrid.headerContextMenu} and related APIs). <p> If you want a button that pops up a menu when clicked, or a bar of
 * such buttons, see the {@link com.smartgwt.client.widgets.menu.MenuButton} and {@link
 * com.smartgwt.client.widgets.menu.MenuBar} classes. <p> To create a pop-up panel interface that looks nothing like a
 * <code>Menu</code> (but still dismisses automatically on an outside click), use {@link
 * com.smartgwt.client.widgets.Canvas#showClickMask Canvas.showClickMask()} to arrange for automatic dismissal, and the
 * {@link com.smartgwt.client.widgets.Canvas#showNextTo Canvas.showNextTo()} utility method to place the component near
 * whatever triggered it, while automatically staying on-screen.
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
     * without destroying or wiping out non-overridden properties.  For usage tips on this
     * param, see {@link com.smartgwt.client.docs.SGWTProperties}.
     * @see com.smartgwt.client.docs.AutoChildUsage
     */
    public static native void changeAutoChildDefaults(String autoChildName, Canvas defaults) /*-{
        if (defaults.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(Menu.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "Canvas");
        }
        defaults.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
        var cleanDefaultsJS = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(defaults.@com.smartgwt.client.widgets.BaseWidget::getConfig()(), true);
        $wnd.isc.Menu.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
    }-*/;

    /**
     * Changes the defaults for FormItem AutoChildren named <code>autoChildName</code>.
     *
     * @param autoChildName name of an AutoChild to customize the defaults for.
     * @param defaults FormItem defaults to apply. These defaults override any existing properties
     * without destroying or wiping out non-overridden properties.  For usage tips on this
     * param, see {@link com.smartgwt.client.docs.SGWTProperties}.
     * @see com.smartgwt.client.docs.AutoChildUsage
     */
    public static native void changeAutoChildDefaults(String autoChildName, FormItem defaults) /*-{
        if (defaults.@com.smartgwt.client.widgets.form.fields.FormItem::isCreated()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(Menu.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "FormItem");
        }
        defaults.@com.smartgwt.client.widgets.form.fields.FormItem::setConfigOnly(Z)(true);
    	var cleanDefaultsJS = defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getEditorTypeConfig()();
        $wnd.isc.Menu.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
    }-*/;

    public Menu(){
        scClassName = "Menu";
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
     * @param alternateRecordStyles New alternateRecordStyles value. Default value is false
     * @return {@link com.smartgwt.client.widgets.menu.Menu Menu} instance, for chaining setter calls
     */
    public Menu setAlternateRecordStyles(Boolean alternateRecordStyles) {
        return (Menu)setAttribute("alternateRecordStyles", alternateRecordStyles, true);
    }

    /**
     * Explicitly disable alternateRecordStyles at the menu level by default so setting to true for all ListGrids will not
     * impact menus' appearance.
     *
     * @return Current alternateRecordStyles value. Default value is false
     */
    public Boolean getAlternateRecordStyles()  {
        Boolean result = getAttributeAsBoolean("alternateRecordStyles");
        return result == null ? false : result;
    }
    

    /**
     * When false, when a menu item is chosen (via mouse click or keyboard), the menu is not automatically hidden, staying in
     * place for further interactivity
     *
     * @param autoDismiss New autoDismiss value. Default value is true
     * @return {@link com.smartgwt.client.widgets.menu.Menu Menu} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.menu.Menu#setCascadeAutoDismiss
     */
    public Menu setAutoDismiss(Boolean autoDismiss) {
        return (Menu)setAttribute("autoDismiss", autoDismiss, true);
    }

    /**
     * When false, when a menu item is chosen (via mouse click or keyboard), the menu is not automatically hidden, staying in
     * place for further interactivity
     *
     * @return Current autoDismiss value. Default value is true
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
     * @param autoDismissOnBlur New autoDismissOnBlur value. Default value is true
     * @return {@link com.smartgwt.client.widgets.menu.Menu Menu} instance, for chaining setter calls
     */
    public Menu setAutoDismissOnBlur(Boolean autoDismissOnBlur) {
        return (Menu)setAttribute("autoDismissOnBlur", autoDismissOnBlur, true);
    }

    /**
     * When false, when a user clicks outside the menu, or hits the Escape key, this menu will not be automatically hidden,
     * staying in place for further interactivity.
     *
     * @return Current autoDismissOnBlur value. Default value is true
     */
    public Boolean getAutoDismissOnBlur()  {
        Boolean result = getAttributeAsBoolean("autoDismissOnBlur");
        return result == null ? true : result;
    }
    

    /**
     * Menus will not draw on initialization, until they're explicitly show()n
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param autoDraw New autoDraw value. Default value is false
     * @return {@link com.smartgwt.client.widgets.menu.Menu Menu} instance, for chaining setter calls
     */
    public Menu setAutoDraw(Boolean autoDraw) {
        return (Menu)setAttribute("autoDraw", autoDraw, true);
    }

    /**
     * Menus will not draw on initialization, until they're explicitly show()n
     *
     * @return Current autoDraw value. Default value is false
     */
    public Boolean getAutoDraw()  {
        Boolean result = getAttributeAsBoolean("autoDraw");
        return result == null ? false : result;
    }
    
    

    /**
     * CSS style for a normal cell
     *
     * @param baseStyle New baseStyle value. Default value is "menu"
     * @return {@link com.smartgwt.client.widgets.menu.Menu Menu} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public Menu setBaseStyle(String baseStyle) {
        return (Menu)setAttribute("baseStyle", baseStyle, true);
    }

    /**
     * CSS style for a normal cell
     *
     * @return Current baseStyle value. Default value is "menu"
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
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
     * @param bodyStyleName New bodyStyleName value. Default value is "normal"
     * @return {@link com.smartgwt.client.widgets.menu.Menu Menu} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.menu.Menu#setFillSpaceStyleName
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Menu setBodyStyleName(String bodyStyleName) {
        return (Menu)setAttribute("bodyStyleName", bodyStyleName, true);
    }

    /**
     * CSS style used for the body of this menu when there is no icon field. When there is an icon field, then {@link
     * com.smartgwt.client.widgets.menu.Menu#getIconBodyStyleName iconBodyStyleName}, if set, will override this setting. <p>
     * If applying a background-color to the body via a CSS style applied using this property, be sure to set {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getBodyBackgroundColor bodyBackgroundColor} to <code>null</code>.
     *
     * @return Current bodyStyleName value. Default value is "normal"
     * @see com.smartgwt.client.widgets.menu.Menu#getFillSpaceStyleName
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getBodyStyleName()  {
        return getAttributeAsString("bodyStyleName");
    }
    

    /**
     * Title for the "Done" button shown when the {@link com.smartgwt.client.widgets.layout.NavigationBar} is present.
     *
     * @param cancelButtonTitle New cancelButtonTitle value. Default value is "Done"
     * @return {@link com.smartgwt.client.widgets.menu.Menu Menu} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public Menu setCancelButtonTitle(String cancelButtonTitle)  throws IllegalStateException {
        return (Menu)setAttribute("cancelButtonTitle", cancelButtonTitle, false);
    }

    /**
     * Title for the "Done" button shown when the {@link com.smartgwt.client.widgets.layout.NavigationBar} is present.
     *
     * @return Current cancelButtonTitle value. Default value is "Done"
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public String getCancelButtonTitle()  {
        return getAttributeAsString("cancelButtonTitle");
    }
    

    /**
     * Option to save searches is disabled for menus
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param canSaveSearches New canSaveSearches value. Default value is false
     * @return {@link com.smartgwt.client.widgets.menu.Menu Menu} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public Menu setCanSaveSearches(boolean canSaveSearches)  throws IllegalStateException {
        return (Menu)setAttribute("canSaveSearches", canSaveSearches, false);
    }

    /**
     * Option to save searches is disabled for menus
     *
     * @return Current canSaveSearches value. Default value is false
     */
    public boolean getCanSaveSearches()  {
        Boolean result = getAttributeAsBoolean("canSaveSearches");
        return result == null ? false : result;
    }
    

    /**
     * If true, clicking or pressing Enter on a menu item that has a submenu will select that item (with standard behavior of
     * hiding the menus, calling click handlers, etc) instead of showing the submenu.
     *
     * @param canSelectParentItems New canSelectParentItems value. Default value is null
     * @return {@link com.smartgwt.client.widgets.menu.Menu Menu} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.Selection Selection overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#menus_category_treebinding" target="examples">Tree Binding Example</a>
     */
    public Menu setCanSelectParentItems(Boolean canSelectParentItems) {
        return (Menu)setAttribute("canSelectParentItems", canSelectParentItems, true);
    }

    /**
     * If true, clicking or pressing Enter on a menu item that has a submenu will select that item (with standard behavior of
     * hiding the menus, calling click handlers, etc) instead of showing the submenu.
     *
     * @return Current canSelectParentItems value. Default value is null
     * @see com.smartgwt.client.docs.Selection Selection overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#menus_category_treebinding" target="examples">Tree Binding Example</a>
     */
    public Boolean getCanSelectParentItems()  {
        return getAttributeAsBoolean("canSelectParentItems");
    }
    

    /**
     * Option to show filter editor is disabled for menus
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param canShowFilterEditor New canShowFilterEditor value. Default value is false
     * @return {@link com.smartgwt.client.widgets.menu.Menu Menu} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public Menu setCanShowFilterEditor(boolean canShowFilterEditor)  throws IllegalStateException {
        return (Menu)setAttribute("canShowFilterEditor", canShowFilterEditor, false);
    }

    /**
     * Option to show filter editor is disabled for menus
     *
     * @return Current canShowFilterEditor value. Default value is false
     */
    public boolean getCanShowFilterEditor()  {
        Boolean result = getAttributeAsBoolean("canShowFilterEditor");
        return result == null ? false : result;
    }
    

    /**
     * When true any generated submenus will inherit {@link com.smartgwt.client.widgets.menu.Menu#getAutoDismiss autoDismiss}
     * from this menu.
     *
     * @param cascadeAutoDismiss New cascadeAutoDismiss value. Default value is true
     * @return {@link com.smartgwt.client.widgets.menu.Menu Menu} instance, for chaining setter calls
     */
    public Menu setCascadeAutoDismiss(Boolean cascadeAutoDismiss) {
        return (Menu)setAttribute("cascadeAutoDismiss", cascadeAutoDismiss, true);
    }

    /**
     * When true any generated submenus will inherit {@link com.smartgwt.client.widgets.menu.Menu#getAutoDismiss autoDismiss}
     * from this menu.
     *
     * @return Current cascadeAutoDismiss value. Default value is true
     */
    public Boolean getCascadeAutoDismiss()  {
        Boolean result = getAttributeAsBoolean("cascadeAutoDismiss");
        return result == null ? true : result;
    }
    

    /**
     * The height of each item in the menu, in pixels.
     *
     * @param cellHeight New cellHeight value. Default value is 20
     * @return {@link com.smartgwt.client.widgets.menu.Menu Menu} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.Sizing Sizing overview and related methods
     */
    public Menu setCellHeight(int cellHeight) {
        return (Menu)setAttribute("cellHeight", cellHeight, true);
    }

    /**
     * The height of each item in the menu, in pixels.
     *
     * @return Current cellHeight value. Default value is 20
     * @see com.smartgwt.client.docs.Sizing Sizing overview and related methods
     */
    public int getCellHeight()  {
        return getAttributeAsInt("cellHeight");
    }
    

    /**
     * Default image to display for disabled checkmarked items. See {@link com.smartgwt.client.widgets.ImgProperties} for
     * format. Valid src, width and height must be specified.
     *
     * @param checkmarkDisabledImage New checkmarkDisabledImage value. Default value is {...}
     * @return {@link com.smartgwt.client.widgets.menu.Menu Menu} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public Menu setCheckmarkDisabledImage(Img checkmarkDisabledImage)  throws IllegalStateException {
        if (checkmarkDisabledImage != null) {
            if (checkmarkDisabledImage.isCreated()) {
                ConfigUtil.warnOfPreConfigInstantiation(Menu.class, "setCheckmarkDisabledImage", "Img");
            }                                                                       
            checkmarkDisabledImage.setConfigOnly(true);
        }
        JavaScriptObject config = checkmarkDisabledImage == null ? null : checkmarkDisabledImage.getConfig();
        return (Menu)setAttribute("checkmarkDisabledImage", JSOHelper.cleanProperties(config, true), false);
    }

    /**
     * Default image to display for disabled checkmarked items. See {@link com.smartgwt.client.widgets.ImgProperties} for
     * format. Valid src, width and height must be specified.
     *
     * @return Current checkmarkDisabledImage value. Default value is {...}
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
     * @param checkmarkImage New checkmarkImage value. Default value is {...}
     * @return {@link com.smartgwt.client.widgets.menu.Menu Menu} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public Menu setCheckmarkImage(Img checkmarkImage)  throws IllegalStateException {
        if (checkmarkImage != null) {
            if (checkmarkImage.isCreated()) {
                ConfigUtil.warnOfPreConfigInstantiation(Menu.class, "setCheckmarkImage", "Img");
            }                                                                       
            checkmarkImage.setConfigOnly(true);
        }
        JavaScriptObject config = checkmarkImage == null ? null : checkmarkImage.getConfig();
        return (Menu)setAttribute("checkmarkImage", JSOHelper.cleanProperties(config, true), false);
    }

    /**
     * Default image to display for checkmarked items. See {@link com.smartgwt.client.widgets.ImgProperties} for format. Valid
     * src, width and height must be specified.
     *
     * @return Current checkmarkImage value. Default value is {...}
     */
    public Img getCheckmarkImage()  {
        Img properties = new Img();
        properties.setConfigOnly(true);
        properties.setConfig(getAttributeAsJavaScriptObject("checkmarkImage"));
        return properties;
    }
    

    /**
     * An array of menuItem objects, specifying the menu items this menu should show. <P> Data may also be set to a {@link
     * com.smartgwt.client.widgets.tree.Tree} in which case a hierarchy of menus and submenus will automatically be generated
     * to match the tree structure.  See also {@link com.smartgwt.client.widgets.menu.Menu#getDataSource dataSource} for
     * dynamically fetching menuItems and submenus from a hierarchical DataSource. <P> Note that items that are marked as
     * {@link com.smartgwt.client.widgets.menu.MenuItem#getHidden hidden} will be automatically filtered out of the data
     * dispayed to the user. To retrieve the full set of items at  runtime, including hidden items, use {@link
     * com.smartgwt.client.widgets.menu.Menu#getAllItems getAllItems()}.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Change the set of items to display in this menu. Note that if  {@link com.smartgwt.client.widgets.menu.Menu#getFilterHiddenItems filterHiddenItems} is true and any items are {@link com.smartgwt.client.widgets.menu.MenuItem#getHidden hidden},  data supplied as an Array will be converted to a {@link com.smartgwt.client.data.FilteredList} in order to filter out  hidden items.  To get the full specified data set as an array, including hidden items, use {@link com.smartgwt.client.widgets.menu.Menu#getAllItems getAllItems()}.
     *
     * @param data new items for this menu. Default value is null
     * @return {@link com.smartgwt.client.widgets.menu.Menu Menu} instance, for chaining setter calls
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#menus_category_appearance" target="examples">Appearance Example</a>
     */
    public Menu setData(MenuItem... data) {
        return (Menu)setAttribute("data", data, true);
    }

    /**
     * An array of menuItem objects, specifying the menu items this menu should show. <P> Data may also be set to a {@link
     * com.smartgwt.client.widgets.tree.Tree} in which case a hierarchy of menus and submenus will automatically be generated
     * to match the tree structure.  See also {@link com.smartgwt.client.widgets.menu.Menu#getDataSource dataSource} for
     * dynamically fetching menuItems and submenus from a hierarchical DataSource. <P> Note that items that are marked as
     * {@link com.smartgwt.client.widgets.menu.MenuItem#getHidden hidden} will be automatically filtered out of the data
     * dispayed to the user. To retrieve the full set of items at  runtime, including hidden items, use {@link
     * com.smartgwt.client.widgets.menu.Menu#getAllItems getAllItems()}.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Change the set of items to display in this menu. Note that if  {@link com.smartgwt.client.widgets.menu.Menu#getFilterHiddenItems filterHiddenItems} is true and any items are {@link com.smartgwt.client.widgets.menu.MenuItem#getHidden hidden},  data supplied as an Array will be converted to a {@link com.smartgwt.client.data.FilteredList} in order to filter out  hidden items.  To get the full specified data set as an array, including hidden items, use {@link com.smartgwt.client.widgets.menu.Menu#getAllItems getAllItems()}.
     *
     * @param data new items for this menu. Default value is null
     * @return {@link com.smartgwt.client.widgets.menu.Menu Menu} instance, for chaining setter calls
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#menus_category_appearance" target="examples">Appearance Example</a>
     */
    public Menu setData(Record[] data) {
        return (Menu)setAttribute("data", data, true);
    }

    /**
     * An array of menuItem objects, specifying the menu items this menu should show. <P> Data may also be set to a {@link
     * com.smartgwt.client.widgets.tree.Tree} in which case a hierarchy of menus and submenus will automatically be generated
     * to match the tree structure.  See also {@link com.smartgwt.client.widgets.menu.Menu#getDataSource dataSource} for
     * dynamically fetching menuItems and submenus from a hierarchical DataSource. <P> Note that items that are marked as
     * {@link com.smartgwt.client.widgets.menu.MenuItem#getHidden hidden} will be automatically filtered out of the data
     * dispayed to the user. To retrieve the full set of items at  runtime, including hidden items, use {@link
     * com.smartgwt.client.widgets.menu.Menu#getAllItems getAllItems()}.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Change the set of items to display in this menu. Note that if  {@link com.smartgwt.client.widgets.menu.Menu#getFilterHiddenItems filterHiddenItems} is true and any items are {@link com.smartgwt.client.widgets.menu.MenuItem#getHidden hidden},  data supplied as an Array will be converted to a {@link com.smartgwt.client.data.FilteredList} in order to filter out  hidden items.  To get the full specified data set as an array, including hidden items, use {@link com.smartgwt.client.widgets.menu.Menu#getAllItems getAllItems()}.
     *
     * @param data new items for this menu. Default value is null
     * @return {@link com.smartgwt.client.widgets.menu.Menu Menu} instance, for chaining setter calls
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#menus_category_appearance" target="examples">Appearance Example</a>
     */
    public Menu setData(Tree data) {
        return (Menu)setAttribute("data", data == null ? null : data.getOrCreateJsObj(), true);
    }

    /**
     * An array of menuItem objects, specifying the menu items this menu should show. <P> Data may also be set to a {@link
     * com.smartgwt.client.widgets.tree.Tree} in which case a hierarchy of menus and submenus will automatically be generated
     * to match the tree structure.  See also {@link com.smartgwt.client.widgets.menu.Menu#getDataSource dataSource} for
     * dynamically fetching menuItems and submenus from a hierarchical DataSource. <P> Note that items that are marked as
     * {@link com.smartgwt.client.widgets.menu.MenuItem#getHidden hidden} will be automatically filtered out of the data
     * dispayed to the user. To retrieve the full set of items at  runtime, including hidden items, use {@link
     * com.smartgwt.client.widgets.menu.Menu#getAllItems getAllItems()}.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Change the set of items to display in this menu. Note that if  {@link com.smartgwt.client.widgets.menu.Menu#getFilterHiddenItems filterHiddenItems} is true and any items are {@link com.smartgwt.client.widgets.menu.MenuItem#getHidden hidden},  data supplied as an Array will be converted to a {@link com.smartgwt.client.data.FilteredList} in order to filter out  hidden items.  To get the full specified data set as an array, including hidden items, use {@link com.smartgwt.client.widgets.menu.Menu#getAllItems getAllItems()}.
     *
     * @param data new items for this menu. Default value is null
     * @return {@link com.smartgwt.client.widgets.menu.Menu Menu} instance, for chaining setter calls
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#menus_category_appearance" target="examples">Appearance Example</a>
     */
    public Menu setData(RecordList data) {
        return (Menu)setAttribute("data", data == null ? null : data.getOrCreateJsObj(), true);
    }
    
    

    /**
     * Optional DataSource to fetch menuItems and submenus from, instead of using {@link
     * com.smartgwt.client.widgets.menu.Menu#getItems items}. <P> Data is tree-based in menus, so the provided DataSource
     * should be set up for hierarchical fetching - see the {@link com.smartgwt.client.docs.TreeDataBinding Tree Data Binding
     * overview}. <P> Note that, although Menu is a subclass of {@link com.smartgwt.client.widgets.grid.ListGrid}, some APIs,
     * like  {@link com.smartgwt.client.widgets.grid.ListGrid#setCriteria setCriteria} and {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getAutoFetchData autoFetchData} are not supported in menus.  If a dataSource
     * is supplied, it is automatically fetched  against as required, without the need for autoFetchData.  To apply criteria to
     * the  fetches made in this way, see {@link com.smartgwt.client.widgets.menu.Menu#getInitialCriteria initialCriteria}.<br>
     * Moreover, fetchData() is also an example of a ListGrid API that doesn't apply to menu, and, as  was done for
     * setCriteria() and other APIs like setCriteria().
     *
     * @param dataSource New dataSource value. Default value is null
     * @return {@link com.smartgwt.client.widgets.menu.Menu Menu} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public Menu setDataSource(DataSource dataSource)  throws IllegalStateException {
        return (Menu)setAttribute("dataSource", dataSource == null ? null : dataSource.getOrCreateJsObj(), false);
    }

    /**
     * Optional DataSource to fetch menuItems and submenus from, instead of using {@link
     * com.smartgwt.client.widgets.menu.Menu#getItems items}. <P> Data is tree-based in menus, so the provided DataSource
     * should be set up for hierarchical fetching - see the {@link com.smartgwt.client.docs.TreeDataBinding Tree Data Binding
     * overview}. <P> Note that, although Menu is a subclass of {@link com.smartgwt.client.widgets.grid.ListGrid}, some APIs,
     * like  {@link com.smartgwt.client.widgets.grid.ListGrid#setCriteria setCriteria} and {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getAutoFetchData autoFetchData} are not supported in menus.  If a dataSource
     * is supplied, it is automatically fetched  against as required, without the need for autoFetchData.  To apply criteria to
     * the  fetches made in this way, see {@link com.smartgwt.client.widgets.menu.Menu#getInitialCriteria initialCriteria}.<br>
     * Moreover, fetchData() is also an example of a ListGrid API that doesn't apply to menu, and, as  was done for
     * setCriteria() and other APIs like setCriteria().
     *
     * @return Current dataSource value. Default value is null
     */
    public DataSource getDataSource()  {
        return DataSource.getOrCreateRef(getAttributeAsJavaScriptObject("dataSource"));
    }
    

    /**
     * The default menu width.
     *
     * @param defaultWidth New defaultWidth value. Default value is 150
     * @return {@link com.smartgwt.client.widgets.menu.Menu Menu} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.Sizing Sizing overview and related methods
     */
    public Menu setDefaultWidth(int defaultWidth) {
        return (Menu)setAttribute("defaultWidth", defaultWidth, true);
    }

    /**
     * The default menu width.
     *
     * @return Current defaultWidth value. Default value is 150
     * @see com.smartgwt.client.docs.Sizing Sizing overview and related methods
     */
    public int getDefaultWidth()  {
        return getAttributeAsInt("defaultWidth");
    }
    

    /**
     * Default class used to construct the {@link com.smartgwt.client.tools.EditProxy} for this component when the component is
     * {@link com.smartgwt.client.widgets.Canvas#setEditMode first placed into edit mode}.
     *
     * @param editProxyConstructor New editProxyConstructor value. Default value is "MenuEditProxy"
     * @return {@link com.smartgwt.client.widgets.menu.Menu Menu} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.SCClassName SCClassName 
     */
    public Menu setEditProxyConstructor(String editProxyConstructor)  throws IllegalStateException {
        return (Menu)setAttribute("editProxyConstructor", editProxyConstructor, false);
    }

    /**
     * Default class used to construct the {@link com.smartgwt.client.tools.EditProxy} for this component when the component is
     * {@link com.smartgwt.client.widgets.Canvas#setEditMode first placed into edit mode}.
     *
     * @return Current editProxyConstructor value. Default value is "MenuEditProxy"
     * @see com.smartgwt.client.docs.SCClassName SCClassName 
     */
    public String getEditProxyConstructor()  {
        return getAttributeAsString("editProxyConstructor");
    }
    

    /**
     * Message to show when a menu is shown with no items.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param emptyMessage New emptyMessage value. Default value is "[Empty menu]"
     * @return {@link com.smartgwt.client.widgets.menu.Menu Menu} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public Menu setEmptyMessage(String emptyMessage) {
        return (Menu)setAttribute("emptyMessage", emptyMessage, true);
    }

    /**
     * Message to show when a menu is shown with no items.
     *
     * @return Current emptyMessage value. Default value is "[Empty menu]"
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public String getEmptyMessage()  {
        return getAttributeAsString("emptyMessage");
    }
    

    /**
     * When using a Tree or hierarchical DataSource as the menu's data, submenus are automatically generated from child nodes. 
     * <code>fetchSubmenus</code> can be set to false to disable this for the whole menu, or can be set false on a per-item
     * basis via {@link com.smartgwt.client.widgets.menu.MenuItem#getFetchSubmenus MenuItem.fetchSubmenus}.
     *
     * @param fetchSubmenus New fetchSubmenus value. Default value is true
     * @return {@link com.smartgwt.client.widgets.menu.Menu Menu} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public Menu setFetchSubmenus(Boolean fetchSubmenus)  throws IllegalStateException {
        return (Menu)setAttribute("fetchSubmenus", fetchSubmenus, false);
    }

    /**
     * When using a Tree or hierarchical DataSource as the menu's data, submenus are automatically generated from child nodes. 
     * <code>fetchSubmenus</code> can be set to false to disable this for the whole menu, or can be set false on a per-item
     * basis via {@link com.smartgwt.client.widgets.menu.MenuItem#getFetchSubmenus MenuItem.fetchSubmenus}.
     *
     * @return Current fetchSubmenus value. Default value is true
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
     * @param fillSpaceStyleName New fillSpaceStyleName value. Default value is null
     * @return {@link com.smartgwt.client.widgets.menu.Menu Menu} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Menu setFillSpaceStyleName(String fillSpaceStyleName)  throws IllegalStateException {
        return (Menu)setAttribute("fillSpaceStyleName", fillSpaceStyleName, false);
    }

    /**
     * If set, alternative body style for the menu used when there is no icon field and the {@link
     * com.smartgwt.client.widgets.menu.Menu#getPlacement placement} settings indicate the menu will be filling a portion of
     * the screen or a panel.  Generally this alternative style should not have rounded or excessively large edges.  If unset,
     * then {@link com.smartgwt.client.widgets.menu.Menu#getBodyStyleName bodyStyleName} is used instead. <p> When there is an
     * icon field, {@link com.smartgwt.client.widgets.menu.Menu#getIconFillSpaceStyleName iconFillSpaceStyleName}, if set,
     * overrides this setting.
     *
     * @return Current fillSpaceStyleName value. Default value is null
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getFillSpaceStyleName()  {
        return getAttributeAsString("fillSpaceStyleName");
    }
    

    /**
     * Does this hide menu items marked as {@link com.smartgwt.client.widgets.menu.MenuItem#getHidden hidden menu items} by
     * filtering them out of the data set? <P> In order to support hiding items marked as hidden, if any items are hidden or
     * marked with {@link com.smartgwt.client.widgets.menu.MenuItem#getVisibleWhen visibleWhen rules}, Menus convert the
     * specified  {@link com.smartgwt.client.widgets.menu.Menu#getData array of items} to a {@link
     * com.smartgwt.client.data.FilteredList} with criteria set to filter out items marked with the {@link
     * com.smartgwt.client.widgets.menu.Menu#getItemHiddenProperty itemHiddenProperty}. <P> Note that this means for
     * <code>filterHiddenItems:true</code> menus, developers wishing to interact with the menu data set must use List APIs such
     * as  {@link com.smartgwt.client.data.List#getLength menu.getData().getLength()} and {@link
     * com.smartgwt.client.data.List#get menu.getData().get(<i>index</i>)}, rather than accessing simple array attributes such
     * as <code>menu.getData().length</code> or <code>menu.getData()[<i>index</i>]</code> <P> To get the full specified data
     * set as an array, including hidden items, use {@link com.smartgwt.client.widgets.menu.Menu#getAllItems getAllItems()}.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param filterHiddenItems New filterHiddenItems value. Default value is true
     * @return {@link com.smartgwt.client.widgets.menu.Menu Menu} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public Menu setFilterHiddenItems(Boolean filterHiddenItems)  throws IllegalStateException {
        return (Menu)setAttribute("filterHiddenItems", filterHiddenItems, false);
    }

    /**
     * Does this hide menu items marked as {@link com.smartgwt.client.widgets.menu.MenuItem#getHidden hidden menu items} by
     * filtering them out of the data set? <P> In order to support hiding items marked as hidden, if any items are hidden or
     * marked with {@link com.smartgwt.client.widgets.menu.MenuItem#getVisibleWhen visibleWhen rules}, Menus convert the
     * specified  {@link com.smartgwt.client.widgets.menu.Menu#getData array of items} to a {@link
     * com.smartgwt.client.data.FilteredList} with criteria set to filter out items marked with the {@link
     * com.smartgwt.client.widgets.menu.Menu#getItemHiddenProperty itemHiddenProperty}. <P> Note that this means for
     * <code>filterHiddenItems:true</code> menus, developers wishing to interact with the menu data set must use List APIs such
     * as  {@link com.smartgwt.client.data.List#getLength menu.getData().getLength()} and {@link
     * com.smartgwt.client.data.List#get menu.getData().get(<i>index</i>)}, rather than accessing simple array attributes such
     * as <code>menu.getData().length</code> or <code>menu.getData()[<i>index</i>]</code> <P> To get the full specified data
     * set as an array, including hidden items, use {@link com.smartgwt.client.widgets.menu.Menu#getAllItems getAllItems()}.
     *
     * @return Current filterHiddenItems value. Default value is true
     */
    public Boolean getFilterHiddenItems()  {
        Boolean result = getAttributeAsBoolean("filterHiddenItems");
        return result == null ? true : result;
    }
    

    /**
     * If set, the CSS style used for the body of this menu when there <em>is</em> an icon field. In RTL mode, the
     * <code>iconBodyStyleName</code> is suffixed with "RTL", which allows skins to apply different styles in LTR and RTL
     * modes. <p> Note: Any skin which uses <code>iconBodyStyleName</code> should add "RTL" styles as well, even if identical
     * to LTR styles. Otherwise, menus may lose their styling in RTL mode.
     *
     * @param iconBodyStyleName New iconBodyStyleName value. Default value is null
     * @return {@link com.smartgwt.client.widgets.menu.Menu Menu} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.menu.Menu#setIconFillSpaceStyleName
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Menu setIconBodyStyleName(String iconBodyStyleName)  throws IllegalStateException {
        return (Menu)setAttribute("iconBodyStyleName", iconBodyStyleName, false);
    }

    /**
     * If set, the CSS style used for the body of this menu when there <em>is</em> an icon field. In RTL mode, the
     * <code>iconBodyStyleName</code> is suffixed with "RTL", which allows skins to apply different styles in LTR and RTL
     * modes. <p> Note: Any skin which uses <code>iconBodyStyleName</code> should add "RTL" styles as well, even if identical
     * to LTR styles. Otherwise, menus may lose their styling in RTL mode.
     *
     * @return Current iconBodyStyleName value. Default value is null
     * @see com.smartgwt.client.widgets.menu.Menu#getIconFillSpaceStyleName
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getIconBodyStyleName()  {
        return getAttributeAsString("iconBodyStyleName");
    }
    
    

    /**
     * Custom properties for the automatically generated icon column. <P> See {@link
     * com.smartgwt.client.widgets.menu.Menu#getShowIcons showIcons} for an overview of the icon column.
     *
     * @param iconFieldProperties New iconFieldProperties value. Default value is null
     * @return {@link com.smartgwt.client.widgets.menu.Menu Menu} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public Menu setIconFieldProperties(ListGridField iconFieldProperties)  throws IllegalStateException {
        JavaScriptObject config = JSOHelper.createObject();
        if (iconFieldProperties != null) {
            JSOHelper.addProperties(config, iconFieldProperties.getJsObj());
        }
        return (Menu)setAttribute("iconFieldProperties", iconFieldProperties == null ? null : config, false);
    }

    /**
     * Custom properties for the automatically generated icon column. <P> See {@link
     * com.smartgwt.client.widgets.menu.Menu#getShowIcons showIcons} for an overview of the icon column.
     *
     * @return Current iconFieldProperties value. Default value is null
     */
    public ListGridField getIconFieldProperties()  {
        return ListGridField.getOrCreateRef(getAttributeAsJavaScriptObject("iconFieldProperties"));
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
     * @param iconFillSpaceStyleName New iconFillSpaceStyleName value. Default value is null
     * @return {@link com.smartgwt.client.widgets.menu.Menu Menu} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Menu setIconFillSpaceStyleName(String iconFillSpaceStyleName)  throws IllegalStateException {
        return (Menu)setAttribute("iconFillSpaceStyleName", iconFillSpaceStyleName, false);
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
     * @return Current iconFillSpaceStyleName value. Default value is null
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getIconFillSpaceStyleName()  {
        return getAttributeAsString("iconFillSpaceStyleName");
    }
    

    /**
     * The default height applied to custom icons in this menu. This is used whenever          item.iconHeight is not
     * specified.
     *
     * @param iconHeight New iconHeight value. Default value is 16
     * @return {@link com.smartgwt.client.widgets.menu.Menu Menu} instance, for chaining setter calls
     */
    public Menu setIconHeight(int iconHeight) {
        return (Menu)setAttribute("iconHeight", iconHeight, true);
    }

    /**
     * The default height applied to custom icons in this menu. This is used whenever          item.iconHeight is not
     * specified.
     *
     * @return Current iconHeight value. Default value is 16
     */
    public int getIconHeight()  {
        return getAttributeAsInt("iconHeight");
    }
    

    /**
     * The default width applied to custom icons in this menu. This is used whenever          item.iconWidth is not specified.
     *
     * @param iconWidth New iconWidth value. Default value is 16
     * @return {@link com.smartgwt.client.widgets.menu.Menu Menu} instance, for chaining setter calls
     */
    public Menu setIconWidth(int iconWidth) {
        return (Menu)setAttribute("iconWidth", iconWidth, true);
    }

    /**
     * The default width applied to custom icons in this menu. This is used whenever          item.iconWidth is not specified.
     *
     * @return Current iconWidth value. Default value is 16
     */
    public int getIconWidth()  {
        return getAttributeAsInt("iconWidth");
    }
    

    /**
     * Criteria to be used when fetching items for this Menu.  Note that  {@link
     * com.smartgwt.client.widgets.grid.ListGrid#setCriteria setCriteria} is not supported in Menus.
     *
     * @param initialCriteria New initialCriteria value. Default value is null
     * @return {@link com.smartgwt.client.widgets.menu.Menu Menu} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.Databinding Databinding overview and related methods
     */
    public Menu setInitialCriteria(Criteria initialCriteria)  throws IllegalStateException {
        if (initialCriteria instanceof Criterion) {
            initialCriteria.setAttribute("_constructor", "AdvancedCriteria");
        }
        return (Menu)setAttribute("initialCriteria", initialCriteria == null ? null : initialCriteria.getJsObj(), false);
    }

    /**
     * Criteria to be used when fetching items for this Menu.  Note that  {@link
     * com.smartgwt.client.widgets.grid.ListGrid#setCriteria setCriteria} is not supported in Menus.
     *
     * @return Current initialCriteria value. Default value is null
     * @see com.smartgwt.client.docs.Databinding Databinding overview and related methods
     */
    public Criteria getInitialCriteria()  {
        return new Criteria(getAttributeAsJavaScriptObject("initialCriteria"));
    }
    

    /**
     * Items with this property set to true will be hidden within the menu.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param itemHiddenProperty New itemHiddenProperty value. Default value is "hidden"
     * @return {@link com.smartgwt.client.widgets.menu.Menu Menu} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.menu.Menu#setFilterHiddenItems
     */
    public Menu setItemHiddenProperty(String itemHiddenProperty) {
        return (Menu)setAttribute("itemHiddenProperty", itemHiddenProperty, true);
    }

    /**
     * Items with this property set to true will be hidden within the menu.
     *
     * @return Current itemHiddenProperty value. Default value is "hidden"
     * @see com.smartgwt.client.widgets.menu.Menu#getFilterHiddenItems
     */
    public String getItemHiddenProperty()  {
        return getAttributeAsString("itemHiddenProperty");
    }
    

    /**
     * Synonym for {@link com.smartgwt.client.widgets.menu.Menu#getData data}
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Synonym for {@link com.smartgwt.client.widgets.menu.Menu#setData setData()}.
     *
     * @param items new items for this menu. Default value is null
     * @return {@link com.smartgwt.client.widgets.menu.Menu Menu} instance, for chaining setter calls
     */
    public Menu setItems(MenuItem... items) {
        return (Menu)setAttribute("items", items, true);
    }
    
    

    /**
     * Custom properties for the automatically generated key column. <P> See {@link
     * com.smartgwt.client.widgets.menu.Menu#getShowKeys showKeys} for an overview of the key column.
     *
     * @param keyFieldProperties New keyFieldProperties value. Default value is null
     * @return {@link com.smartgwt.client.widgets.menu.Menu Menu} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public Menu setKeyFieldProperties(ListGridField keyFieldProperties)  throws IllegalStateException {
        JavaScriptObject config = JSOHelper.createObject();
        if (keyFieldProperties != null) {
            JSOHelper.addProperties(config, keyFieldProperties.getJsObj());
        }
        return (Menu)setAttribute("keyFieldProperties", keyFieldProperties == null ? null : config, false);
    }

    /**
     * Custom properties for the automatically generated key column. <P> See {@link
     * com.smartgwt.client.widgets.menu.Menu#getShowKeys showKeys} for an overview of the key column.
     *
     * @return Current keyFieldProperties value. Default value is null
     */
    public ListGridField getKeyFieldProperties()  {
        return ListGridField.getOrCreateRef(getAttributeAsJavaScriptObject("keyFieldProperties"));
    }
    

    /**
     * For a menu that has a {@link com.smartgwt.client.widgets.menu.MenuButton} generated for it automatically (for example
     * when included in a {@link com.smartgwt.client.widgets.menu.MenuBar}, the width that the MenuButton should have.  If
     * unset, the MenuButton will be as wide as <code>menu.width</code>.
     *
     * @param menuButtonWidth New menuButtonWidth value. Default value is null
     * @return {@link com.smartgwt.client.widgets.menu.Menu Menu} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public Menu setMenuButtonWidth(Integer menuButtonWidth)  throws IllegalStateException {
        return (Menu)setAttribute("menuButtonWidth", menuButtonWidth, false);
    }

    /**
     * For a menu that has a {@link com.smartgwt.client.widgets.menu.MenuButton} generated for it automatically (for example
     * when included in a {@link com.smartgwt.client.widgets.menu.MenuBar}, the width that the MenuButton should have.  If
     * unset, the MenuButton will be as wide as <code>menu.width</code>.
     *
     * @return Current menuButtonWidth value. Default value is null
     */
    public Integer getMenuButtonWidth()  {
        return getAttributeAsInt("menuButtonWidth");
    }
    

    /**
     * Navigation bar shown when {@link com.smartgwt.client.widgets.menu.Menu#getPlacement placement} setting indicates that
     * the menu should be shown filling a portion of the screen or a panel.
     * <p>
     * This component is an AutoChild named "navigationBar".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current navigationBar value. Default value is null
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
     * This component is an AutoChild named "navStack".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current navStack value. Default value is null
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
     * @param placement New placement value. Default value is null
     * @return {@link com.smartgwt.client.widgets.menu.Menu Menu} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public Menu setPlacement(PanelPlacement placement)  throws IllegalStateException {
        return (Menu)setAttribute("placement", placement == null ? null : placement.getValue(), false);
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
     * @return Current placement value. Default value is null
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
     * @param showAnimationEffect New showAnimationEffect value. Default value is null
     * @return {@link com.smartgwt.client.widgets.menu.Menu Menu} instance, for chaining setter calls
     */
    public Menu setShowAnimationEffect(String showAnimationEffect) {
        return (Menu)setAttribute("showAnimationEffect", showAnimationEffect, true);
    }

    /**
     * When this menu is shown how should it animate into view? By default the menu will just show at the specified
     * size/position. Options for animated show effects are <code>"fade"</code> to fade from transparent to visible,
     * <code>"slide"</code> to slide the menu into view, or <code>"wipe"</code> to have the menu grow into view, revealing its
     * content as it grows. Can be overridden by passing the 'animationEffect' parameter to 'menu.show()'
     *
     * @return Current showAnimationEffect value. Default value is null
     */
    public String getShowAnimationEffect()  {
        return getAttributeAsString("showAnimationEffect");
    }
    

    /**
     * <code>showEdges</code> dynamically defaults to false when the {@link com.smartgwt.client.widgets.menu.Menu#getPlacement
     * placement} setting indicates the Menu will be filling a portion of the screen or a panel.
     *
     * @param showEdges New showEdges value. Default value is null
     * @return {@link com.smartgwt.client.widgets.menu.Menu Menu} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public Menu setShowEdges(Boolean showEdges)  throws IllegalStateException {
        return (Menu)setAttribute("showEdges", showEdges, false);
    }

    /**
     * <code>showEdges</code> dynamically defaults to false when the {@link com.smartgwt.client.widgets.menu.Menu#getPlacement
     * placement} setting indicates the Menu will be filling a portion of the screen or a panel.
     *
     * @return Current showEdges value. Default value is null
     */
    public Boolean getShowEdges()  {
        return getAttributeAsBoolean("showEdges");
    }
    

    /**
     * A boolean, indicating whether the checkmark/custom icon column should be displayed.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Show or hide the checkmark/custom icon column at runtime.
     *
     * @param showIcons whether the icon column should be displayed. Default value is true
     * @return {@link com.smartgwt.client.widgets.menu.Menu Menu} instance, for chaining setter calls
     */
    public Menu setShowIcons(Boolean showIcons) {
        return (Menu)setAttribute("showIcons", showIcons, true);
    }

    /**
     * A boolean, indicating whether the checkmark/custom icon column should be displayed.
     *
     * @return Current showIcons value. Default value is true
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
     * @param showKeys New showKeys value. Default value is true
     * @return {@link com.smartgwt.client.widgets.menu.Menu Menu} instance, for chaining setter calls
     */
    public Menu setShowKeys(Boolean showKeys) {
        return (Menu)setAttribute("showKeys", showKeys, true);
    }

    /**
     * A boolean, indicating whether the shortcut key column should be displayed. If showKeys is not set, the menu will show
     * the key column only if one of its items specifies a keys property. If showKeys is false, the keys will not be displayed,
     * but will still function.
     *
     * @return Current showKeys value. Default value is true
     */
    public Boolean getShowKeys()  {
        Boolean result = getAttributeAsBoolean("showKeys");
        return result == null ? true : result;
    }
    

    /**
     * Whether to show a drop shadow for this Canvas.  <P> Developers should be aware that the drop shadow is drawn outside the
     * specified width and height of the widget meaning a widget with shadows  takes up a little more space than it otherwise
     * would. A full screen canvas with showShadow set  to true as this would be likely to cause browser scrollbars to appear -
     * developers can handle this by either setting this property to false on full-screen widgets, or by setting overflow to
     * "hidden" on the &lt;body&gt; element browser-level scrolling is never intended to occur. <P> <code>showShadow</code>
     * dynamically defaults to false when the {@link com.smartgwt.client.widgets.menu.Menu#getPlacement placement} setting
     * indicates the Menu will be filling a portion of the screen or a panel.
     *
     * @param showShadow New showShadow value. Default value is null
     * @return {@link com.smartgwt.client.widgets.menu.Menu Menu} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public Menu setShowShadow(Boolean showShadow)  throws IllegalStateException {
        return (Menu)setAttribute("showShadow", showShadow, false);
    }

    /**
     * Whether to show a drop shadow for this Canvas.  <P> Developers should be aware that the drop shadow is drawn outside the
     * specified width and height of the widget meaning a widget with shadows  takes up a little more space than it otherwise
     * would. A full screen canvas with showShadow set  to true as this would be likely to cause browser scrollbars to appear -
     * developers can handle this by either setting this property to false on full-screen widgets, or by setting overflow to
     * "hidden" on the &lt;body&gt; element browser-level scrolling is never intended to occur. <P> <code>showShadow</code>
     * dynamically defaults to false when the {@link com.smartgwt.client.widgets.menu.Menu#getPlacement placement} setting
     * indicates the Menu will be filling a portion of the screen or a panel.
     *
     * @return Current showShadow value. Default value is null
     */
    public Boolean getShowShadow()  {
        return getAttributeAsBoolean("showShadow");
    }
    

    /**
     * A boolean, indicating whether the submenu indicator column should be displayed. If showSubmenus is not set, the menu
     * will show the indicator column only if one of its items specifies a submenu property. If showSubmenus is false, the
     * submenu arrows will not be displayed, but submenus will still appear on rollover.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Show or hide the submenu indicator column at runtime.
     *
     * @param showSubmenus whether the submenu indicator column should be displayed. Default value is true
     * @return {@link com.smartgwt.client.widgets.menu.Menu Menu} instance, for chaining setter calls
     */
    public Menu setShowSubmenus(Boolean showSubmenus) {
        return (Menu)setAttribute("showSubmenus", showSubmenus, true);
    }

    /**
     * A boolean, indicating whether the submenu indicator column should be displayed. If showSubmenus is not set, the menu
     * will show the indicator column only if one of its items specifies a submenu property. If showSubmenus is false, the
     * submenu arrows will not be displayed, but submenus will still appear on rollover.
     *
     * @return Current showSubmenus value. Default value is true
     */
    public Boolean getShowSubmenus()  {
        Boolean result = getAttributeAsBoolean("showSubmenus");
        return result == null ? true : result;
    }
    

    /**
     * When using a Tree or hierarchical DataSource as the menu's data, optional subclass of Menu that should be used when
     * generating submenus.
     *
     * @param submenuConstructor New submenuConstructor value. Default value is null
     * @return {@link com.smartgwt.client.widgets.menu.Menu Menu} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.SCClassName SCClassName 
     */
    public Menu setSubmenuConstructor(String submenuConstructor)  throws IllegalStateException {
        return (Menu)setAttribute("submenuConstructor", submenuConstructor, false);
    }

    /**
     * When using a Tree or hierarchical DataSource as the menu's data, optional subclass of Menu that should be used when
     * generating submenus.
     *
     * @return Current submenuConstructor value. Default value is null
     * @see com.smartgwt.client.docs.SCClassName SCClassName 
     */
    public String getSubmenuConstructor()  {
        return getAttributeAsString("submenuConstructor");
    }
    

    /**
     * Should submenus show up on our left or right. Can validly be set to <code>"left"</code> or <code>"right"</code>. If
     * unset, submenus show up on the right by default in Left-to-right text mode, or on the left in Right-to-left text mode
     * (see {@link com.smartgwt.client.util.Page#isRTL Page.isRTL()}).
     *
     * @param submenuDirection New submenuDirection value. Default value is null
     * @return {@link com.smartgwt.client.widgets.menu.Menu Menu} instance, for chaining setter calls
     */
    public Menu setSubmenuDirection(String submenuDirection) {
        return (Menu)setAttribute("submenuDirection", submenuDirection, true);
    }

    /**
     * Should submenus show up on our left or right. Can validly be set to <code>"left"</code> or <code>"right"</code>. If
     * unset, submenus show up on the right by default in Left-to-right text mode, or on the left in Right-to-left text mode
     * (see {@link com.smartgwt.client.util.Page#isRTL Page.isRTL()}).
     *
     * @return Current submenuDirection value. Default value is null
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
     * @param submenuDisabledImage New submenuDisabledImage value. Default value is {...}
     * @return {@link com.smartgwt.client.widgets.menu.Menu Menu} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public Menu setSubmenuDisabledImage(Img submenuDisabledImage)  throws IllegalStateException {
        if (submenuDisabledImage != null) {
            if (submenuDisabledImage.isCreated()) {
                ConfigUtil.warnOfPreConfigInstantiation(Menu.class, "setSubmenuDisabledImage", "Img");
            }                                                                       
            submenuDisabledImage.setConfigOnly(true);
        }
        JavaScriptObject config = submenuDisabledImage == null ? null : submenuDisabledImage.getConfig();
        return (Menu)setAttribute("submenuDisabledImage", JSOHelper.cleanProperties(config, true), false);
    }

    /**
     * Default image to use for the submenu indicator when item is disabled. Valid src, width and height must be specified. See
     * {@link com.smartgwt.client.widgets.ImgProperties} for format.<br> If {@link
     * com.smartgwt.client.widgets.menu.Menu#getSubmenuDirection submenuDirection} is set to <code>"left"</code>, the image src
     * will have the suffix <code>"_left"</code> appended to it.
     *
     * @return Current submenuDisabledImage value. Default value is {...}
     */
    public Img getSubmenuDisabledImage()  {
        Img properties = new Img();
        properties.setConfigOnly(true);
        properties.setConfig(getAttributeAsJavaScriptObject("submenuDisabledImage"));
        return properties;
    }
    
    

    /**
     * Custom properties for the automatically generated submenu column. <P> See {@link
     * com.smartgwt.client.widgets.menu.Menu#getShowSubmenus showSubmenus} for an overview of the submenu column.
     *
     * @param submenuFieldProperties New submenuFieldProperties value. Default value is null
     * @return {@link com.smartgwt.client.widgets.menu.Menu Menu} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public Menu setSubmenuFieldProperties(ListGridField submenuFieldProperties)  throws IllegalStateException {
        JavaScriptObject config = JSOHelper.createObject();
        if (submenuFieldProperties != null) {
            JSOHelper.addProperties(config, submenuFieldProperties.getJsObj());
        }
        return (Menu)setAttribute("submenuFieldProperties", submenuFieldProperties == null ? null : config, false);
    }

    /**
     * Custom properties for the automatically generated submenu column. <P> See {@link
     * com.smartgwt.client.widgets.menu.Menu#getShowSubmenus showSubmenus} for an overview of the submenu column.
     *
     * @return Current submenuFieldProperties value. Default value is null
     */
    public ListGridField getSubmenuFieldProperties()  {
        return ListGridField.getOrCreateRef(getAttributeAsJavaScriptObject("submenuFieldProperties"));
    }
    

    /**
     * Default image to use for the submenu indicator. Valid src, width and height must be specified. See {@link
     * com.smartgwt.client.widgets.ImgProperties} for format.<br> If {@link
     * com.smartgwt.client.widgets.menu.Menu#getSubmenuDirection submenuDirection} is set to <code>"left"</code>, the image src
     * will have the suffix <code>"_left"</code> appended to it.
     *
     * @param submenuImage New submenuImage value. Default value is {...}
     * @return {@link com.smartgwt.client.widgets.menu.Menu Menu} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public Menu setSubmenuImage(Img submenuImage)  throws IllegalStateException {
        if (submenuImage != null) {
            if (submenuImage.isCreated()) {
                ConfigUtil.warnOfPreConfigInstantiation(Menu.class, "setSubmenuImage", "Img");
            }                                                                       
            submenuImage.setConfigOnly(true);
        }
        JavaScriptObject config = submenuImage == null ? null : submenuImage.getConfig();
        return (Menu)setAttribute("submenuImage", JSOHelper.cleanProperties(config, true), false);
    }

    /**
     * Default image to use for the submenu indicator. Valid src, width and height must be specified. See {@link
     * com.smartgwt.client.widgets.ImgProperties} for format.<br> If {@link
     * com.smartgwt.client.widgets.menu.Menu#getSubmenuDirection submenuDirection} is set to <code>"left"</code>, the image src
     * will have the suffix <code>"_left"</code> appended to it.
     *
     * @return Current submenuImage value. Default value is {...}
     */
    public Img getSubmenuImage()  {
        Img properties = new Img();
        properties.setConfigOnly(true);
        properties.setConfig(getAttributeAsJavaScriptObject("submenuImage"));
        return properties;
    }
    

    /**
     * Optional target canvas for this menu.  Available as a parameter to dynamic menuItem configuration methods such as {@link
     * com.smartgwt.client.widgets.menu.MenuItem#checkIf MenuItem.checkIf()}. <P> Whenever a Menu is shown as a contextMenu by
     * a widget due to {@link com.smartgwt.client.widgets.Canvas#getContextMenu Canvas.contextMenu} being set,
     * <code>menu.target</code> is automatically set to the widget that showed the contextMenu. <P> If this item has any {@link
     * com.smartgwt.client.widgets.menu.MenuItem#getSubmenu submenus} the <code>target</code> will be propagated down to these
     * child menus.
     *
     * @param target New target value. Default value is null
     * @return {@link com.smartgwt.client.widgets.menu.Menu Menu} instance, for chaining setter calls
     */
    public Menu setTarget(Canvas target) {
        return (Menu)setAttribute("target", target == null ? null : target.getOrCreateJsObj(), true);
    }

    /**
     * Optional target canvas for this menu.  Available as a parameter to dynamic menuItem configuration methods such as {@link
     * com.smartgwt.client.widgets.menu.MenuItem#checkIf MenuItem.checkIf()}. <P> Whenever a Menu is shown as a contextMenu by
     * a widget due to {@link com.smartgwt.client.widgets.Canvas#getContextMenu Canvas.contextMenu} being set,
     * <code>menu.target</code> is automatically set to the widget that showed the contextMenu. <P> If this item has any {@link
     * com.smartgwt.client.widgets.menu.MenuItem#getSubmenu submenus} the <code>target</code> will be propagated down to these
     * child menus.
     *
     * @return Current target value. Default value is null
     */
    public Canvas getTarget()  {
        return (Canvas)Canvas.getByJSObject(getAttributeAsJavaScriptObject("target"));
    }
    
    

    /**
     * Custom properties for the automatically generated title column.
     *
     * @param titleFieldProperties New titleFieldProperties value. Default value is null
     * @return {@link com.smartgwt.client.widgets.menu.Menu Menu} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public Menu setTitleFieldProperties(ListGridField titleFieldProperties)  throws IllegalStateException {
        JavaScriptObject config = JSOHelper.createObject();
        if (titleFieldProperties != null) {
            JSOHelper.addProperties(config, titleFieldProperties.getJsObj());
        }
        return (Menu)setAttribute("titleFieldProperties", titleFieldProperties == null ? null : config, false);
    }

    /**
     * Custom properties for the automatically generated title column.
     *
     * @return Current titleFieldProperties value. Default value is null
     */
    public ListGridField getTitleFieldProperties()  {
        return ListGridField.getOrCreateRef(getAttributeAsJavaScriptObject("titleFieldProperties"));
    }
    

    /**
     * A boolean indicating whether this menu should use shortcut keys. Set useKeys to false in a menu's initialization block
     * to explicitly disable shortcut keys.
     *
     * @param useKeys New useKeys value. Default value is true
     * @return {@link com.smartgwt.client.widgets.menu.Menu Menu} instance, for chaining setter calls
     */
    public Menu setUseKeys(Boolean useKeys) {
        return (Menu)setAttribute("useKeys", useKeys, true);
    }

    /**
     * A boolean indicating whether this menu should use shortcut keys. Set useKeys to false in a menu's initialization block
     * to explicitly disable shortcut keys.
     *
     * @return Current useKeys value. Default value is true
     */
    public Boolean getUseKeys()  {
        Boolean result = getAttributeAsBoolean("useKeys");
        return result == null ? true : result;
    }
    

    // ********************* Methods ***********************
	/**
     * This DataBoundComponent method does not apply to Menu.
     */
    public native void fetchData() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "fetchData", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.fetchData();
    }-*/;

    /**
     * @see Menu#fetchData
     */
    public void fetchData(Criteria criteria){
        fetchData(criteria, null, null);
    }

    /**
     * @see Menu#fetchData
     */
    public void fetchData(Criteria criteria, DSCallback callback){
        fetchData(criteria, callback, null);
    }

	/**
     * This DataBoundComponent method does not apply to Menu.
     * @param criteria Search criteria. If a {@link com.smartgwt.client.widgets.form.DynamicForm} is passed                                    
     * in as this argument instead of a raw criteria                                           object, will be derived by
     * calling                                          {@link com.smartgwt.client.widgets.form.DynamicForm#getValuesAsCriteria
     * DynamicForm.getValuesAsCriteria()}
     * @param callback callback to invoke when a fetch is complete. Fires                                          only if server contact was
     * required
     * @param requestProperties additional properties to set on the DSRequest                                          that will be issued
     */
    public native void fetchData(Criteria criteria, DSCallback callback, DSRequest requestProperties) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "fetchData", "Criteria,DSCallback,DSRequest");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
	    if(@com.smartgwt.client.data.Criterion::instanceOf(Ljava/lang/Object;)(criteria)){
	    	@com.smartgwt.client.util.JSOHelper::setAttribute(Lcom/google/gwt/core/client/JavaScriptObject;Ljava/lang/String;Ljava/lang/String;)(criteria.@com.smartgwt.client.data.Criterion::getJsObj()(),"_constructor","AdvancedCriteria");
	    }
        self.fetchData(criteria == null ? null : criteria.@com.smartgwt.client.core.DataClass::getJsObj()(), 
			$entry( function(dsResponse, data, dsRequest) { 
				if(callback!=null) callback.@com.smartgwt.client.data.DSCallback::execute(Lcom/smartgwt/client/data/DSResponse;Ljava/lang/Object;Lcom/smartgwt/client/data/DSRequest;)(
					@com.smartgwt.client.data.DSResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsResponse), 
					data, 
					@com.smartgwt.client.data.DSRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsRequest)
				);
			}), requestProperties == null ? null : requestProperties.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;
	
	/**
     * Retrieves the full set of items for this menu, including {@link com.smartgwt.client.widgets.menu.MenuItem#getHidden
     * hidden items}
     *
     * @return 
     */
    public native List getAllItems() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getAllItems", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getAllItems();
        return ret;
    }-*/;

	/**
     * Return the CSS class for a cell. By default this method has the following implementation:<br> - return any custom style
     * for the record ({@link com.smartgwt.client.widgets.grid.GridRenderer#getRecordCustomStyleProperty
     * GridRenderer.recordCustomStyleProperty})    if defined.<br> - create a style name based on the result of {@link
     * com.smartgwt.client.widgets.grid.GridRenderer#getBaseStyle GridRenderer.getBaseStyle()} and the    state of the record
     * using the rules described in {@link com.smartgwt.client.docs.CellStyleSuffixes}. <p> Cell Styles are customizable by:
     * <ul> <li>attaching a custom style to a record by setting     <code>record[this.recordCustomStyleProperty]</code> to some
     * valid CSS style name.   <li>modifying the base style returned by getBaseStyle() [see that method for further     
     * documentation on this] <li>overriding this function </ul> <p> In addition to this, {@link
     * com.smartgwt.client.widgets.grid.GridRenderer#getCellCSSText getCellCSSText()} may be overriden to provide custom
     * cssText to apply on top of the styling attributes derived from the named style. <p> <b>Note: This is an override
     * point.</b>
     * @param record record object for this row and column
     * @param rowNum number of the row
     * @param colNum number of the column
     *
     * @return CSS style for this cell.
     * See {@link com.smartgwt.client.docs.CSSStyleName CSSStyleName}
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public native String getCellStyle(ListGridRecord record, int rowNum, int colNum) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getCellStyle", "ListGridRecord,int,int");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getCellStyle(record.@com.smartgwt.client.core.DataClass::getJsObj()(), rowNum, colNum);
        return ret;
    }-*/;

	/**
     * Get a particular MenuItem by index. <P> If passed a MenuItem, returns it.
     * @param item index of the MenuItem
     *
     * @return the MenuItem, Pointer to the item, or null if not defined
     */
    public native MenuItem getItem(int item) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getItem", "int");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getItem(item);
        if(ret == null) return null;
        return @com.smartgwt.client.widgets.menu.MenuItem::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

	/**
     * Given a MenuItem, return its index in the currently visible set of items. <P> To get the index of the item in the {@link
     * com.smartgwt.client.widgets.menu.Menu#getAllItems full set of items}, including {@link
     * com.smartgwt.client.widgets.menu.MenuItem#getHidden hidden items}, use {@link
     * com.smartgwt.client.widgets.menu.Menu#getItemNum getItemNum()} instead
     * @param item Menu Item to find
     *
     * @return index of the item in the visible items, or -1 if not found.
     * @see com.smartgwt.client.widgets.menu.Menu#getFilterHiddenItems
     */
    public native int getVisibleItemNum(MenuItem item) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getVisibleItemNum", "MenuItem");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getVisibleItemNum(item.@com.smartgwt.client.core.DataClass::getJsObj()());
        return ret;
    }-*/;

	/**
     * Hide the context menu - alias for hide()
     * @see com.smartgwt.client.docs.Visibility Visibility overview and related methods
     */
    public native void hideContextMenu() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "hideContextMenu", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.hideContextMenu();
    }-*/;

    /**
     * Add a itemClick handler.
     * <p>
     * Executed when a menu item with no click handler is clicked by the user. This itemClick handler must be specified as a
     * function. It is passed an item parameter that is a reference to the clicked menu item.
     *
     * @param handler the itemClick handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addItemClickHandler(com.smartgwt.client.widgets.menu.events.ItemClickHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.menu.events.ItemClickEvent.getType()) == 0) setupItemClickEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.menu.events.ItemClickEvent.getType());
    }

    private native void setupItemClickEvent() /*-{
        var obj;
        var selfJ = this;
        var hasDefaultHandler;
        var itemClick = $debox($entry(function(param){
            var event = @com.smartgwt.client.widgets.menu.events.ItemClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            selfJ.@com.smartgwt.client.widgets.menu.Menu::handleTearDownItemClickEvent()();
            var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
            return !ret;
        }));
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            hasDefaultHandler = $wnd.isc.isA.Function(obj.getProperty("itemClick"));
            obj.addProperties({itemClick: 
                function () {
                    var param = {"_this": this, "item" : arguments[0], "colNum" : arguments[1]};
                    var ret = itemClick(param) == true;
                    if (ret && hasDefaultHandler) {
                        ret = this.Super("itemClick", arguments);
                    }
                    return ret;
                }
             });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
            hasDefaultHandler = $wnd.isc.isA.Function($wnd.isc[scClassName].getInstanceProperty("itemClick"));
            obj.itemClick = 
                function () {
                    var param = {"_this": this, "item" : arguments[0], "colNum" : arguments[1]};
                    var ret = itemClick(param) == true;
                    if (ret && hasDefaultHandler) {
                        ret = this.Super("itemClick", arguments);
                    }
                    return ret;
                }
            ;
        }
    }-*/;

    private void handleTearDownItemClickEvent() {
        if (getHandlerCount(com.smartgwt.client.widgets.menu.events.ItemClickEvent.getType()) == 0) tearDownItemClickEvent();
    }

    private native void tearDownItemClickEvent() /*-{
        var obj;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }
        if (obj && obj.hasOwnProperty("itemClick")) delete obj.itemClick;
    }-*/;

	/**
     * This DataBoundComponent method is not supported - use {@link com.smartgwt.client.widgets.menu.Menu#getInitialCriteria
     * initialCriteria} to apply criteria to the fetches made by  menus.
     * @param criteria new criteria to show
     */
    public native void setCriteria(Criteria criteria) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "setCriteria", "Criteria");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
	    if(@com.smartgwt.client.data.Criterion::instanceOf(Ljava/lang/Object;)(criteria)){
	    	@com.smartgwt.client.util.JSOHelper::setAttribute(Lcom/google/gwt/core/client/JavaScriptObject;Ljava/lang/String;Ljava/lang/String;)(criteria.@com.smartgwt.client.data.Criterion::getJsObj()(),"_constructor","AdvancedCriteria");
	    }
        self.setCriteria(criteria == null ? null : criteria.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;

	/**
     * This DataBoundComponent method is not supported - use {@link com.smartgwt.client.widgets.menu.Menu#getInitialCriteria
     * initialCriteria} to apply criteria to the fetches made by  menus.
     * @param criteria new criteria to show
     */
    public native void setCriteria(AdvancedCriteria criteria) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "setCriteria", "AdvancedCriteria");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
	    if(@com.smartgwt.client.data.Criterion::instanceOf(Ljava/lang/Object;)(criteria)){
	    	@com.smartgwt.client.util.JSOHelper::setAttribute(Lcom/google/gwt/core/client/JavaScriptObject;Ljava/lang/String;Ljava/lang/String;)(criteria.@com.smartgwt.client.data.Criterion::getJsObj()(),"_constructor","AdvancedCriteria");
	    }
        self.setCriteria(criteria.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;

	/**
     * Hides or shows the menu item according to the value of newState, and redraws the menu if necessary. Returns true if
     * there's a change in the hidden state.
     * @param item MenuItem in question, or its index
     *
     * @return true if the hidden state was changed
     * @see com.smartgwt.client.widgets.menu.Menu#getFilterHiddenItems
     */
    public native boolean setItemHidden(MenuItem item) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "setItemHidden", "MenuItem");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.setItemHidden(item.@com.smartgwt.client.core.DataClass::getJsObj()());
        return ret == null ? false : ret;
    }-*/;

	/**
     * Hides or shows the menu item according to the value of newState, and redraws the menu if necessary. Returns true if
     * there's a change in the hidden state.
     * @param item MenuItem in question, or its index
     *
     * @return true if the hidden state was changed
     * @see com.smartgwt.client.widgets.menu.Menu#getFilterHiddenItems
     */
    public native boolean setItemHidden(int item) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "setItemHidden", "int");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.setItemHidden(item);
        return ret == null ? false : ret;
    }-*/;

	/**
     * Hides or shows the menu item according to the value of newState, and redraws the menu if necessary. Returns true if
     * there's a change in the hidden state.
     * @param item MenuItem in question, or its index
     * @param newState true to hide the menu item, false to show it.
     *
     * @return true if the hidden state was changed
     * @see com.smartgwt.client.widgets.menu.Menu#getFilterHiddenItems
     */
    public native boolean setItemHidden(MenuItem item, boolean newState) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "setItemHidden", "MenuItem,boolean");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.setItemHidden(item.@com.smartgwt.client.core.DataClass::getJsObj()(), newState);
        return ret == null ? false : ret;
    }-*/;
	
	/**
     * Show this menu as a context menu, that is, immediately adjacent to the current mouse position.
     *
     * @return false == stop processing this event
     * @see com.smartgwt.client.docs.Visibility Visibility overview and related methods
     */
    public native Boolean showContextMenu() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "showContextMenu", "");
        }
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
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public static native void setDefaultProperties(Menu menuProperties) /*-{
        if (menuProperties.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Class;)(Menu.@java.lang.Object::getClass()(), "setDefaultProperties", menuProperties.@java.lang.Object::getClass()());
        }
        menuProperties.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
    	var properties = menuProperties.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        properties = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(properties,true);
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
        if (dataProperties.isCreated()) {
            ConfigUtil.warnOfPreConfigInstantiation(this.getClass(), "setDataProperties", "Tree");
        }                                                                       
        dataProperties.setConfigOnly(true);

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
        self.setItemProperties(item, $wnd.isc.addProperties({}, props));
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
        if(retVal == null) {
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
        if(retVal == null) {
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
        if(retVal == null) {
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
        if(retVal == null) {
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
        if(retVal == null) {
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
        if(retVal == null) {
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
        if(retVal == null) {
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
        if(retVal == null) {
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
        if(retVal == null) {
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
        if(retVal == null) {
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
        if(retVal == null) {
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
        if(retVal == null) {
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
        if(retVal == null) {
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
        if(retVal == null) {
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

    /**
     * Default properties for the automatically generated icon column. Default object includes
     * properties to set width and to show icon for this column.
     * <P> 
     * To modify the behavior or appearance of this column, developers may set {@link
     * com.smartgwt.client.widgets.menu.Menu#setIconFieldProperties iconFieldProperties} at the
     * instance level, or {@link com.smartgwt.client.widgets.menu.Menu#setIconFieldDefaults 
     * iconFieldDefaults} to affect all instances of the class.  See {@link 
     * com.smartgwt.client.widgets.menu.Menu#getShowIcons showIcons} for an overview of the icon
     * column.
     *
     * @param iconFieldDefaults
     */
    public native static void setIconFieldDefaults(ListGridField iconFieldDefaults) /*-{
        var iconFieldDefaultsJS = iconFieldDefaults.@com.smartgwt.client.core.DataClass::getJsObj()();
        $wnd.isc.Menu.changeDefaults("iconFieldDefaults", iconFieldDefaultsJS);
    }-*/;

    /**
     * Default properties for the automatically generated icon column. Default object includes
     * properties to set width and to show icon for this column.
     * <P> 
     * To modify the behavior or appearance of this column, developers may set {@link
     * com.smartgwt.client.widgets.menu.Menu#setIconFieldProperties iconFieldProperties} at the
     * instance level, or {@link com.smartgwt.client.widgets.menu.Menu#setIconFieldDefaults 
     * iconFieldDefaults} to affect all instances of the class.  See {@link 
     * com.smartgwt.client.widgets.menu.Menu#getShowIcons showIcons} for an overview of the icon
     * column.
     *
     * @param iconFieldDefaults  Default value is object
     */
    public native static ListGridField getIconFieldDefaults()  /*-{
        var fieldJS = $wnd.isc.Menu.getInstanceProperty("iconFieldDefaults", true);
        return @com.smartgwt.client.widgets.grid.ListGridField::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(fieldJS);
    }-*/;

    /**
     * Default properties for the automatically generated key column. Default object includes
     * properties to set width and to show key for this column.
     * <P> 
     * To modify the behavior or appearance of this column, developers may set {@link
     * com.smartgwt.client.widgets.menu.Menu#getKeyFieldProperties keyFieldProperties} at the
     * instance level, or {@link com.smartgwt.client.widgets.menu.Menu#setKeyFieldDefaults 
     * keyFieldDefaults} to affect all instances of the class.  See {@link 
     * com.smartgwt.client.widgets.menu.Menu#getShowKeys showKeys} for an overview of the key
     * column.
     *
     * @param keyFieldDefaults  Default value is object
     */
    public native static void setKeyFieldDefaults(ListGridField keyFieldDefaults) /*-{
        var keyFieldDefaultsJS = keyFieldDefaults.@com.smartgwt.client.core.DataClass::getJsObj()();
        $wnd.isc.Menu.changeDefaults("keyFieldDefaults", keyFieldDefaultsJS);
    }-*/;

    /**
     * Default properties for the automatically generated key column. Default object includes
     * properties to set width and to show key for this column.
     * <P> 
     * To modify the behavior or appearance of this column, developers may set {@link
     * com.smartgwt.client.widgets.menu.Menu#getKeyFieldProperties keyFieldProperties} at the
     * instance level, or {@link com.smartgwt.client.widgets.menu.Menu#setKeyFieldDefaults 
     * keyFieldDefaults} to affect all instances of the class.  See {@link 
     * com.smartgwt.client.widgets.menu.Menu#getShowKeys showKeys} for an overview of the key
     * column.
     *
     * @param keyFieldDefaults  Default value is object
     */
    public native static ListGridField getKeyFieldDefaults()  /*-{
        var fieldJS = $wnd.isc.Menu.getInstanceProperty("keyFieldDefaults", true);
        return @com.smartgwt.client.widgets.grid.ListGridField::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(fieldJS);
    }-*/;

    /**
     * Default properties for the automatically generated submenu column. Default object
     * includes properties to set width, align and to show submenu icon for this column.
     * <P>
     * To modify the behavior or appearance of this column, developers may set {@link
     * com.smartgwt.client.widgets.menu.Menu#getSubmenuFieldProperties submenuFieldProperties}
     * at the instance level, or {@link 
     * com.smartgwt.client.widgets.menu.Menu#setSubmenuFieldDefaults submenuFieldDefaults} to
     * affect all instances of the class.  See {@link 
     * com.smartgwt.client.widgets.menu.Menu#getShowSubmenus showSubmenus} for an overview of
     * the submenu column.
     *
     * @param submenuFieldDefaults  Default value is object
     */
    public native static void setSubmenuFieldDefaults(ListGridField submenuFieldDefaults) /*-{
        var submenuFieldDefaultsJS = submenuFieldDefaults.@com.smartgwt.client.core.DataClass::getJsObj()();
        $wnd.isc.Menu.changeDefaults("submenuFieldDefaults", submenuFieldDefaultsJS);
    }-*/;

    /**
     * Default properties for the automatically generated submenu column. Default object
     * includes properties to set width, align and to show submenu icon for this column.
     * <P>
     * To modify the behavior or appearance of this column, developers may set {@link
     * com.smartgwt.client.widgets.menu.Menu#getSubmenuFieldProperties submenuFieldProperties}
     * at the instance level, or {@link 
     * com.smartgwt.client.widgets.menu.Menu#setSubmenuFieldDefaults submenuFieldDefaults} to
     * affect all instances of the class.  See {@link 
     * com.smartgwt.client.widgets.menu.Menu#getShowSubmenus showSubmenus} for an overview of
     * the submenu column.
     *
     * @param submenuFieldDefaults  Default value is object
     */
    public native static ListGridField getSubmenuFieldDefaults()  /*-{
        var fieldJS = $wnd.isc.Menu.getInstanceProperty("submenuFieldDefaults", true);
        return @com.smartgwt.client.widgets.grid.ListGridField::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(fieldJS);
    }-*/;

    /** 
     * Default properties for the automatically generated title column. Default object includes
     * properties to set width and to show title for this column.
     * <P>
     * To modify the behavior or appearance of this column, developers may set {@link
     * com.smartgwt.client.widgets.menu.Menu#getTitleFieldProperties titleFieldProperties} at
     * the instance level, or {@link 
     * com.smartgwt.client.widgets.menu.Menu#setTitleFieldDefaults titleFieldDefaults} to
     * affect all instances of the class
     *
     * @param titleFieldDefaults  Default value is object
     */
    public native static void setTitleFieldDefaults(ListGridField titleFieldDefaults) /*-{
        var titleFieldDefaultsJS = titleFieldDefaults.@com.smartgwt.client.core.DataClass::getJsObj()();
        $wnd.isc.Menu.changeDefaults("titleFieldDefaults", titleFieldDefaultsJS);
    }-*/;

    /** 
     * Default properties for the automatically generated title column. Default object includes
     * properties to set width and to show title for this column.
     * <P>
     * To modify the behavior or appearance of this column, developers may set {@link
     * com.smartgwt.client.widgets.menu.Menu#getTitleFieldProperties titleFieldProperties} at
     * the instance level, or {@link 
     * com.smartgwt.client.widgets.menu.Menu#setTitleFieldDefaults titleFieldDefaults} to
     * affect all instances of the class
     *
     * @param titleFieldDefaults  Default value is object
     */
    public native static ListGridField getTitleFieldDefaults()  /*-{
        var fieldJS = $wnd.isc.Menu.getInstanceProperty("titleFieldDefaults", true);
        return @com.smartgwt.client.widgets.grid.ListGridField::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(fieldJS);
    }-*/;


    /**
     * Setter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
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
            s.canSaveSearches = getAttributeAsString("canSaveSearches");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Menu.canSaveSearches:" + t.getMessage() + "\n";
        }
        try {
            s.canSelectParentItems = getAttributeAsString("canSelectParentItems");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Menu.canSelectParentItems:" + t.getMessage() + "\n";
        }
        try {
            s.canShowFilterEditor = getAttributeAsString("canShowFilterEditor");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Menu.canShowFilterEditor:" + t.getMessage() + "\n";
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
            s.editProxyConstructor = getAttributeAsString("editProxyConstructor");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Menu.editProxyConstructor:" + t.getMessage() + "\n";
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
            s.fieldsAsListGridFieldArray = getFields();
        } catch (Throwable t) {
            s.logicalStructureErrors += "Menu.fieldsAsListGridFieldArray:" + t.getMessage() + "\n";
        }
        try {
            s.fillSpaceStyleName = getAttributeAsString("fillSpaceStyleName");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Menu.fillSpaceStyleName:" + t.getMessage() + "\n";
        }
        try {
            s.filterHiddenItems = getAttributeAsString("filterHiddenItems");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Menu.filterHiddenItems:" + t.getMessage() + "\n";
        }
        try {
            s.iconBodyStyleName = getAttributeAsString("iconBodyStyleName");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Menu.iconBodyStyleName:" + t.getMessage() + "\n";
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
            s.initialCriteria = getInitialCriteria();
        } catch (Throwable t) {
            s.logicalStructureErrors += "Menu.initialCriteria:" + t.getMessage() + "\n";
        }
        try {
            s.itemHiddenProperty = getAttributeAsString("itemHiddenProperty");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Menu.itemHiddenProperty:" + t.getMessage() + "\n";
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
            s.target = getTarget();
        } catch (Throwable t) {
            s.logicalStructureErrors += "Menu.target:" + t.getMessage() + "\n";
        }
        try {
            s.useKeys = getAttributeAsString("useKeys");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Menu.useKeys:" + t.getMessage() + "\n";
        }
        return s;
    }

    /**
     * Getter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject getLogicalStructure() {
        MenuLogicalStructure s = new MenuLogicalStructure();
        setLogicalStructure(s);
        return s;
    }
}
