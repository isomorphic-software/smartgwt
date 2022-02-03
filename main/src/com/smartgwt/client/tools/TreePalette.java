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
 
package com.smartgwt.client.tools;


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
 * A TreeGrid that implements the Palette behavior, so it can be used as the source for  drag and drop instantiation of
 * components when combined with an {@link com.smartgwt.client.tools.EditContext} as  the drop target. <P> Each {@link
 * com.smartgwt.client.widgets.tree.TreeNode} within {@link com.smartgwt.client.widgets.tree.TreeGrid#getData
 * TreeGrid.data} can be a {@link com.smartgwt.client.tools.PaletteNode}.
 * @see com.smartgwt.client.docs.DevTools DevTools overview and related methods
 */
@BeanFactory.FrameworkClass
@BeanFactory.ScClassName("TreePalette")
public class TreePalette extends TreeGrid implements Palette {

    public static TreePalette getOrCreateRef(JavaScriptObject jsObj) {
        if (jsObj == null) return null;
        final BaseWidget refInstance = BaseWidget.getRef(jsObj);
        if (refInstance == null) {
            return new TreePalette(jsObj);
        } else {
            assert refInstance instanceof TreePalette;
            return (TreePalette)refInstance;
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(TreePalette.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "Canvas");
        }
        defaults.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
        var cleanDefaultsJS = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(defaults.@com.smartgwt.client.widgets.BaseWidget::getConfig()(), true);
        $wnd.isc.TreePalette.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(TreePalette.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "FormItem");
        }
        defaults.@com.smartgwt.client.widgets.form.fields.FormItem::setConfigOnly(Z)(true);
    	var cleanDefaultsJS = defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getEditorTypeConfig()();
        $wnd.isc.TreePalette.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
    }-*/;

    public TreePalette(){
        scClassName = "TreePalette";
    }

    public TreePalette(JavaScriptObject jsObj){
        scClassName = "TreePalette";
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
     * Option to save searches is disabled for treePalettes
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param canSaveSearches New canSaveSearches value. Default value is false
     * @return {@link com.smartgwt.client.tools.TreePalette TreePalette} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public TreePalette setCanSaveSearches(boolean canSaveSearches)  throws IllegalStateException {
        return (TreePalette)setAttribute("canSaveSearches", canSaveSearches, false);
    }

    /**
     * Option to save searches is disabled for treePalettes
     *
     * @return Current canSaveSearches value. Default value is false
     */
    public boolean getCanSaveSearches()  {
        Boolean result = getAttributeAsBoolean("canSaveSearches");
        return result == null ? false : result;
    }
    

    /**
     * Option to show filter editor is disabled for treePalettes
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param canShowFilterEditor New canShowFilterEditor value. Default value is false
     * @return {@link com.smartgwt.client.tools.TreePalette TreePalette} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public TreePalette setCanShowFilterEditor(boolean canShowFilterEditor)  throws IllegalStateException {
        return (TreePalette)setAttribute("canShowFilterEditor", canShowFilterEditor, false);
    }

    /**
     * Option to show filter editor is disabled for treePalettes
     *
     * @return Current canShowFilterEditor value. Default value is false
     */
    public boolean getCanShowFilterEditor()  {
        Boolean result = getAttributeAsBoolean("canShowFilterEditor");
        return result == null ? false : result;
    }
    

    /**
     * Defaults to apply to all components originating from this palette.
     *
     * @param componentDefaults New componentDefaults value. Default value is null
     * @return {@link com.smartgwt.client.tools.TreePalette TreePalette} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.DevTools DevTools overview and related methods
     */
    public TreePalette setComponentDefaults(Record componentDefaults)  throws IllegalStateException {
        return (TreePalette)setAttribute("componentDefaults", componentDefaults == null ? null : componentDefaults.getJsObj(), false);
    }

    /**
     * Defaults to apply to all components originating from this palette.
     *
     * @return Current componentDefaults value. Default value is null
     * @see com.smartgwt.client.docs.DevTools DevTools overview and related methods
     */
    public Record getComponentDefaults()  {
        return Record.getOrCreateRef(getAttributeAsJavaScriptObject("componentDefaults"));
    }
    

    /**
     * Default EditContext that this palette should use.  Palettes generally create components via drag and drop, but may also
     * support creation via double-click or other UI idioms when a defaultEditContext is set.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets the default EditContext that this palette should use.  Palettes generally create components via drag and drop, but may also support creation via double-click or other UI idioms when a defaultEditContext is set.
     *
     * @param defaultEditContext the default EditContext used by this Palette. Default value is null
     * @return {@link com.smartgwt.client.tools.TreePalette TreePalette} instance, for chaining setter calls
     */
    public native TreePalette setDefaultEditContext(EditContext defaultEditContext) /*-{
        var defaultEditContextJS = (
                defaultEditContext == null ?
                null :
                defaultEditContext.@com.smartgwt.client.tools.EditContext::getOrCreateJsObj()());

        // If an EditTree (or similar) component is passed which contains an EditContext
        // rather than being one, grab the actual EditContext.
        if (defaultEditContextJS &&
            !$wnd.isc.isAn.EditContext(defaultEditContextJS) &&
            defaultEditContextJS.getEditContext)
        {
            defaultEditContextJS = defaultEditContextJS.getEditContext();
        }

        return this.@com.smartgwt.client.widgets.BaseWidget::setAttribute(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;Z)("defaultEditContext", defaultEditContextJS, true);
    }-*/;

    /**
     * Default EditContext that this palette should use.  Palettes generally create components via drag and drop, but may also
     * support creation via double-click or other UI idioms when a defaultEditContext is set.
     *
     * @return Current defaultEditContext value. Default value is null
     */
    public EditContext getDefaultEditContext()  {
        return EditContext.getOrCreateRef(getAttributeAsJavaScriptObject("defaultEditContext"));
    }

    /**
     * Default EditContext that this palette should use.  Palettes generally create components via drag and drop, but may also
     * support creation via double-click or other UI idioms when a defaultEditContext is set.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets the default EditContext that this palette should use.  Palettes generally create components via drag and drop, but may also support creation via double-click or other UI idioms when a defaultEditContext is set.
     *
     * @param defaultEditContext the default EditContext used by this Palette. Default value is null
     * @return {@link com.smartgwt.client.tools.TreePalette TreePalette} instance, for chaining setter calls
     */
    public native TreePalette setDefaultEditContext(EditTree defaultEditContext) /*-{
        var defaultEditContextJS = (
                defaultEditContext == null ?
                null :
                defaultEditContext.@com.smartgwt.client.tools.EditTree::getOrCreateJsObj()());

        // If an EditTree (or similar) component is passed which contains an EditContext
        // rather than being one, grab the actual EditContext.
        if (defaultEditContextJS &&
            !$wnd.isc.isAn.EditContext(defaultEditContextJS) &&
            defaultEditContextJS.getEditContext)
        {
            defaultEditContextJS = defaultEditContextJS.getEditContext();
        }

        return this.@com.smartgwt.client.widgets.BaseWidget::setAttribute(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;Z)("defaultEditContext", defaultEditContextJS, true);
    }-*/;

    /**
     * Default EditContext that this palette should use.  Palettes generally create components via drag and drop, but may also
     * support creation via double-click or other UI idioms when a defaultEditContext is set.
     *
     * @return Current defaultEditContext value. Default value is null
     */
    public EditTree getDefaultEditContextAsEditTree()  {
        return (EditTree)EditTree.getByJSObject(getAttributeAsJavaScriptObject("defaultEditContext"));
    }

    /**
     * Default EditContext that this palette should use.  Palettes generally create components via drag and drop, but may also
     * support creation via double-click or other UI idioms when a defaultEditContext is set.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets the default EditContext that this palette should use.  Palettes generally create components via drag and drop, but may also support creation via double-click or other UI idioms when a defaultEditContext is set.
     *
     * @param defaultEditContext the default EditContext used by this Palette. Default value is null
     * @return {@link com.smartgwt.client.tools.TreePalette TreePalette} instance, for chaining setter calls
     */
    public native TreePalette setDefaultEditContext(EditPane defaultEditContext) /*-{
        var defaultEditContextJS = (
                defaultEditContext == null ?
                null :
                defaultEditContext.@com.smartgwt.client.tools.EditPane::getOrCreateJsObj()());

        // If an EditTree (or similar) component is passed which contains an EditContext
        // rather than being one, grab the actual EditContext.
        if (defaultEditContextJS &&
            !$wnd.isc.isAn.EditContext(defaultEditContextJS) &&
            defaultEditContextJS.getEditContext)
        {
            defaultEditContextJS = defaultEditContextJS.getEditContext();
        }

        return this.@com.smartgwt.client.widgets.BaseWidget::setAttribute(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;Z)("defaultEditContext", defaultEditContextJS, true);
    }-*/;

    /**
     * Default EditContext that this palette should use.  Palettes generally create components via drag and drop, but may also
     * support creation via double-click or other UI idioms when a defaultEditContext is set.
     *
     * @return Current defaultEditContext value. Default value is null
     */
    public EditPane getDefaultEditContextAsEditPane()  {
        return (EditPane)EditPane.getByJSObject(getAttributeAsJavaScriptObject("defaultEditContext"));
    }

    /**
     * Whether created components should have their "ID" or "name" property automatically set to a unique value based on the
     * component's type, eg, "ListGrid0".
     *
     * @param generateNames New generateNames value. Default value is true
     * @return {@link com.smartgwt.client.tools.TreePalette TreePalette} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.DevTools DevTools overview and related methods
     */
    public TreePalette setGenerateNames(boolean generateNames)  throws IllegalStateException {
        return (TreePalette)setAttribute("generateNames", generateNames, false);
    }

    /**
     * Whether created components should have their "ID" or "name" property automatically set to a unique value based on the
     * component's type, eg, "ListGrid0".
     *
     * @return Current generateNames value. Default value is true
     * @see com.smartgwt.client.docs.DevTools DevTools overview and related methods
     */
    public boolean getGenerateNames()  {
        Boolean result = getAttributeAsBoolean("generateNames");
        return result == null ? true : result;
    }

    // ********************* Methods ***********************
	/**
     * Given a {@link com.smartgwt.client.tools.PaletteNode}, make an {@link com.smartgwt.client.tools.EditNode} from it by
     * creating a  {@link com.smartgwt.client.tools.EditNode#getLiveObject liveObject} from the {@link
     * com.smartgwt.client.tools.PaletteNode#getDefaults PaletteNode.defaults} and copying presentation properties (eg {@link
     * com.smartgwt.client.tools.PaletteNode#getTitle title} to the editNode. <P> If <code>editNodeProperties</code> is
     * specified as an object on on the paletteNode, each property in this object will also be copied across to the editNode.
     * @param paletteNode paletteNode to create from
     *
     * @return created EditNode
     */
    public native EditNode makeEditNode(PaletteNode paletteNode) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "makeEditNode", "PaletteNode");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.makeEditNode(paletteNode.@com.smartgwt.client.core.DataClass::getJsObj()());
        if(ret == null) return null;
        return @com.smartgwt.client.tools.EditNode::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;


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
     * @param treePaletteProperties properties that should be used as new defaults when instances of this class are created
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public static native void setDefaultProperties(TreePalette treePaletteProperties) /*-{
        if (treePaletteProperties.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Class;)(TreePalette.@java.lang.Object::getClass()(), "setDefaultProperties", treePaletteProperties.@java.lang.Object::getClass()());
        }
        treePaletteProperties.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
    	var properties = treePaletteProperties.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        properties = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(properties,true);
        $wnd.isc.TreePalette.addProperties(properties);
    }-*/;

    // ***********************************************************

    /**
     * Setter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject setLogicalStructure(TreePaletteLogicalStructure s) {
        super.setLogicalStructure(s);
        try {
            s.canSaveSearches = getAttributeAsString("canSaveSearches");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TreePalette.canSaveSearches:" + t.getMessage() + "\n";
        }
        try {
            s.canShowFilterEditor = getAttributeAsString("canShowFilterEditor");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TreePalette.canShowFilterEditor:" + t.getMessage() + "\n";
        }
        try {
            s.componentDefaults = getComponentDefaults();
        } catch (Throwable t) {
            s.logicalStructureErrors += "TreePalette.componentDefaults:" + t.getMessage() + "\n";
        }
        return s;
    }

    /**
     * Getter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject getLogicalStructure() {
        TreePaletteLogicalStructure s = new TreePaletteLogicalStructure();
        setLogicalStructure(s);
        return s;
    }
}
