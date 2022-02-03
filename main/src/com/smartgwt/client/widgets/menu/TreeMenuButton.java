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
 * Button used to display a hierarchical Menu group for representing / selecting tree data. <P> <i><b>Important Note:</b>
 * this class should not be used directly - it is exposed purely for {@link i18nMessages i18n reasons.}</i>
 * @see com.smartgwt.client.widgets.menu.SelectionTreeMenu
 */
@BeanFactory.FrameworkClass
@BeanFactory.ScClassName("TreeMenuButton")
public class TreeMenuButton extends MenuButton {

    public static TreeMenuButton getOrCreateRef(JavaScriptObject jsObj) {
        if (jsObj == null) return null;
        final BaseWidget refInstance = BaseWidget.getRef(jsObj);
        if (refInstance == null) {
            return new TreeMenuButton(jsObj);
        } else {
            assert refInstance instanceof TreeMenuButton;
            return (TreeMenuButton)refInstance;
        }
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(TreeMenuButton.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "Canvas");
        }
        defaults.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
        var cleanDefaultsJS = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(defaults.@com.smartgwt.client.widgets.BaseWidget::getConfig()(), true);
        $wnd.isc.TreeMenuButton.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(TreeMenuButton.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "FormItem");
        }
        defaults.@com.smartgwt.client.widgets.form.fields.FormItem::setConfigOnly(Z)(true);
    	var cleanDefaultsJS = defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getEditorTypeConfig()();
        $wnd.isc.TreeMenuButton.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
    }-*/;

    public TreeMenuButton(){
        scClassName = "TreeMenuButton";
    }

    public TreeMenuButton(JavaScriptObject jsObj){
        scClassName = "TreeMenuButton";
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
     * If this button's menu (or any of its submenus) are empty, this property can be used to specify the message to display
     * (as a disabled item) in the empty menu.
     *
     * @param emptyMenuMessage New emptyMenuMessage value. Default value is null
     * @return {@link com.smartgwt.client.widgets.menu.TreeMenuButton TreeMenuButton} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public TreeMenuButton setEmptyMenuMessage(String emptyMenuMessage) {
        return (TreeMenuButton)setAttribute("emptyMenuMessage", emptyMenuMessage, true);
    }

    /**
     * If this button's menu (or any of its submenus) are empty, this property can be used to specify the message to display
     * (as a disabled item) in the empty menu.
     *
     * @return Current emptyMenuMessage value. Default value is null
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public String getEmptyMenuMessage()  {
        return getAttributeAsString("emptyMenuMessage");
    }
    

    /**
     * If {@link com.smartgwt.client.widgets.menu.TreeMenuButton#getShowPath showPath} is true, this property specifies what
     * will  appear between the folders in the selected value's path.
     *
     * @param pathSeparatorString New pathSeparatorString value. Default value is "&amp;nbsp;&amp;gt;&amp;nbsp;"
     * @return {@link com.smartgwt.client.widgets.menu.TreeMenuButton TreeMenuButton} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public TreeMenuButton setPathSeparatorString(String pathSeparatorString) {
        return (TreeMenuButton)setAttribute("pathSeparatorString", pathSeparatorString, true);
    }

    /**
     * If {@link com.smartgwt.client.widgets.menu.TreeMenuButton#getShowPath showPath} is true, this property specifies what
     * will  appear between the folders in the selected value's path.
     *
     * @return Current pathSeparatorString value. Default value is "&amp;nbsp;&amp;gt;&amp;nbsp;"
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public String getPathSeparatorString()  {
        return getAttributeAsString("pathSeparatorString");
    }
    

    /**
     * Base style to apply to the selected path within the menu. (The "over" version of this style should also be defined in
     * the stylesheet applied to this widget).
     *
     * @param selectedBaseStyle New selectedBaseStyle value. Default value is "treeMenuSelected"
     * @return {@link com.smartgwt.client.widgets.menu.TreeMenuButton TreeMenuButton} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public TreeMenuButton setSelectedBaseStyle(String selectedBaseStyle) {
        return (TreeMenuButton)setAttribute("selectedBaseStyle", selectedBaseStyle, true);
    }

    /**
     * Base style to apply to the selected path within the menu. (The "over" version of this style should also be defined in
     * the stylesheet applied to this widget).
     *
     * @return Current selectedBaseStyle value. Default value is "treeMenuSelected"
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public String getSelectedBaseStyle()  {
        return getAttributeAsString("selectedBaseStyle");
    }
    

    /**
     * If {@link com.smartgwt.client.widgets.menu.TreeMenuButton#getTitle title} is null, when the user selects an item, should
     * we  show the full path to the item, or just the item's title as the button's title?
     *
     * @param showPath New showPath value. Default value is false
     * @return {@link com.smartgwt.client.widgets.menu.TreeMenuButton TreeMenuButton} instance, for chaining setter calls
     */
    public TreeMenuButton setShowPath(boolean showPath) {
        return (TreeMenuButton)setAttribute("showPath", showPath, true);
    }

    /**
     * If {@link com.smartgwt.client.widgets.menu.TreeMenuButton#getTitle title} is null, when the user selects an item, should
     * we  show the full path to the item, or just the item's title as the button's title?
     *
     * @return Current showPath value. Default value is false
     */
    public boolean getShowPath()  {
        Boolean result = getAttributeAsBoolean("showPath");
        return result == null ? false : result;
    }
    

    /**
     * Title for this button. If not specified, the selected value from the tree will be displayed instead.
     *
     * @param title New title value. Default value is null
     */
    public void setTitle(String title) {
        setAttribute("title", title, true);
    }

    /**
     * Title for this button. If not specified, the selected value from the tree will be displayed instead.
     *
     * @return Current title value. Default value is null
     */
    public String getTitle()  {
        return getAttributeAsString("title");
    }
    

    /**
     * AutoChild menu displayed when the button is clicked.
     * <p>
     * This component is an AutoChild named "treeMenu".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current treeMenu value. Default value is null
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public Menu getTreeMenu() throws IllegalStateException {
        errorIfNotCreated("treeMenu");
        return (Menu)Menu.getByJSObject(getAttributeAsJavaScriptObject("treeMenu"));
    }
    

    /**
     * Widget class for the menu created by this button.  The default is  {@link
     * com.smartgwt.client.widgets.menu.SelectionTreeMenu}.
     *
     * @param treeMenuConstructor New treeMenuConstructor value. Default value is "SelectionTreeMenu"
     * @return {@link com.smartgwt.client.widgets.menu.TreeMenuButton TreeMenuButton} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.SCClassName SCClassName 
     */
    public TreeMenuButton setTreeMenuConstructor(String treeMenuConstructor)  throws IllegalStateException {
        return (TreeMenuButton)setAttribute("treeMenuConstructor", treeMenuConstructor, false);
    }

    /**
     * Widget class for the menu created by this button.  The default is  {@link
     * com.smartgwt.client.widgets.menu.SelectionTreeMenu}.
     *
     * @return Current treeMenuConstructor value. Default value is "SelectionTreeMenu"
     * @see com.smartgwt.client.docs.SCClassName SCClassName 
     */
    public String getTreeMenuConstructor()  {
        return getAttributeAsString("treeMenuConstructor");
    }
    

    /**
     * If {@link com.smartgwt.client.widgets.menu.TreeMenuButton#getTitle title} is null, this value will be displayed as a
     * title  when the user has not selected any value from the hierachichal menu.
     *
     * @param unselectedTitle New unselectedTitle value. Default value is "Choose a value"
     * @return {@link com.smartgwt.client.widgets.menu.TreeMenuButton TreeMenuButton} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public TreeMenuButton setUnselectedTitle(String unselectedTitle) {
        return (TreeMenuButton)setAttribute("unselectedTitle", unselectedTitle, true);
    }

    /**
     * If {@link com.smartgwt.client.widgets.menu.TreeMenuButton#getTitle title} is null, this value will be displayed as a
     * title  when the user has not selected any value from the hierachichal menu.
     *
     * @return Current unselectedTitle value. Default value is "Choose a value"
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public String getUnselectedTitle()  {
        return getAttributeAsString("unselectedTitle");
    }
    

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************

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
     * @param treeMenuButtonProperties properties that should be used as new defaults when instances of this class are created
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public static native void setDefaultProperties(TreeMenuButton treeMenuButtonProperties) /*-{
        if (treeMenuButtonProperties.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Class;)(TreeMenuButton.@java.lang.Object::getClass()(), "setDefaultProperties", treeMenuButtonProperties.@java.lang.Object::getClass()());
        }
        treeMenuButtonProperties.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
    	var properties = treeMenuButtonProperties.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        properties = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(properties,true);
        $wnd.isc.TreeMenuButton.addProperties(properties);
    }-*/;

    // ***********************************************************


    /**
     * For a <code>TreeMenuButton</code> that uses a DataSource, these properties will be
     * passed to the automatically-created ResultTree.  This can be used for various
     * customizations such as modifying the automatically-chosen 
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
     * Setter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject setLogicalStructure(TreeMenuButtonLogicalStructure s) {
        super.setLogicalStructure(s);
        try {
            s.emptyMenuMessage = getAttributeAsString("emptyMenuMessage");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TreeMenuButton.emptyMenuMessage:" + t.getMessage() + "\n";
        }
        try {
            s.pathSeparatorString = getAttributeAsString("pathSeparatorString");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TreeMenuButton.pathSeparatorString:" + t.getMessage() + "\n";
        }
        try {
            s.selectedBaseStyle = getAttributeAsString("selectedBaseStyle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TreeMenuButton.selectedBaseStyle:" + t.getMessage() + "\n";
        }
        try {
            s.showPath = getAttributeAsString("showPath");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TreeMenuButton.showPath:" + t.getMessage() + "\n";
        }
        try {
            s.title = getAttributeAsString("title");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TreeMenuButton.title:" + t.getMessage() + "\n";
        }
        try {
            s.treeMenuConstructor = getAttributeAsString("treeMenuConstructor");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TreeMenuButton.treeMenuConstructor:" + t.getMessage() + "\n";
        }
        try {
            s.unselectedTitle = getAttributeAsString("unselectedTitle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TreeMenuButton.unselectedTitle:" + t.getMessage() + "\n";
        }
        return s;
    }

    /**
     * Getter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject getLogicalStructure() {
        TreeMenuButtonLogicalStructure s = new TreeMenuButtonLogicalStructure();
        setLogicalStructure(s);
        return s;
    }
}
