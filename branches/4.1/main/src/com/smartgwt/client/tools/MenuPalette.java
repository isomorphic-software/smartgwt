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
 * A Menu that implements the {@link com.smartgwt.client.tools.Palette} behavior, so it can be used as the source for  drag
 * and drop instantiation of components when combined with an {@link com.smartgwt.client.tools.EditContext} as  the drop
 * target. <P> Each {@link com.smartgwt.client.widgets.menu.MenuItem} can be a {@link
 * com.smartgwt.client.tools.PaletteNode}.
 * @see com.smartgwt.client.docs.DevTools DevTools overview and related methods
 */
@BeanFactory.FrameworkClass
@BeanFactory.ScClassName("MenuPalette")
public class MenuPalette extends Menu implements Palette {

    public static MenuPalette getOrCreateRef(JavaScriptObject jsObj) {
        if (jsObj == null) return null;
        final BaseWidget refInstance = BaseWidget.getRef(jsObj);
        if (refInstance == null) {
            return new MenuPalette(jsObj);
        } else {
            assert refInstance instanceof MenuPalette;
            return (MenuPalette)refInstance;
        }
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
        $wnd.isc.MenuPalette.changeDefaults(autoChildName + "Defaults", defaults.@com.smartgwt.client.widgets.Canvas::getConfig()());
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
        $wnd.isc.MenuPalette.changeDefaults(autoChildName + "Defaults", defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getJsObj()());
    }-*/;

    public MenuPalette(){
        scClassName = "MenuPalette";
    }

    public MenuPalette(JavaScriptObject jsObj){
        scClassName = "MenuPalette";
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
     * Default EditContext that this palette should use.  Palettes generally create components via drag and drop, but may also
     * support creation via double-click or other UI idioms when a defaultEditContext is set.
     *
     * <p>If this method is called after the component has been drawn/initialized:
     * Sets the default EditContext that this palette should use.  Palettes generally create components via drag and drop, but may also support creation via double-click or other UI idioms when a defaultEditContext is set.
     *
     * @param defaultEditContext the default EditContext used by this Palette. Default value is null
     */
    public void setDefaultEditContext(EditContext defaultEditContext) {
        // Since EditContext is an interface, we need to convert it to a
        // JavaScriptObject dynamically at run-time -- we don't know what class
        // is implementing the interface.
        JavaScriptObject jsoArray = JSOHelper.convertToJavaScriptArray(new Object[] {defaultEditContext});
        JavaScriptObject jso = JSOHelper.getValueFromJavaScriptObjectArray(jsoArray, 0);
        setAttribute("defaultEditContext", jso == null ? null : jso, true);
    }

    /**
     * Default EditContext that this palette should use.  Palettes generally create components via drag and drop, but may also
     * support creation via double-click or other UI idioms when a defaultEditContext is set.
     *
     * @return EditContext
     */
    public EditContext getDefaultEditContext()  {
        // We need to get or create the correct Java type, but we can't call
        // getOrCreateRef on an interface. The best simple thing we can do is
        // take advantage of ObjectFactory.createCanvas and friends to pick the
        // right type. Note that this will work for custom developer classes
        // so long as they descend from a SmartClient implementation of the
        // interface. It won't work for totally custom implementations, but
        // totally custom implementations would be hard to create properly anyway
        // (because they won't get the default methods implemented on the
        // SmartClient interface).
        JavaScriptObject jso = getAttributeAsJavaScriptObject("defaultEditContext");
        Object javaObj = null;
        if (JSOHelper.isScClassInstance(jso)) {
            String className = JSOHelper.getClassName(jso);
            javaObj = ObjectFactory.createCanvas(className, jso);

            // If it's not a Canvas, try the others
            if (javaObj == null) {
                javaObj = ObjectFactory.createInstance(className, jso);
            }
        }
        if (javaObj instanceof EditContext) {
            return (EditContext) javaObj;
        } else {
            return null;
        }
    }

    /**
     * Whether created components should have their "ID" or "name" property automatically set to a unique value based on the
     * component's type, eg, "ListGrid0".
     *
     * @param generateNames  Default value is true
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.DevTools DevTools overview and related methods
     */
    public void setGenerateNames(boolean generateNames)  throws IllegalStateException {
        setAttribute("generateNames", generateNames, false);
    }

    /**
     * Whether created components should have their "ID" or "name" property automatically set to a unique value based on the
     * component's type, eg, "ListGrid0".
     *
     * @return boolean
     * @see com.smartgwt.client.docs.DevTools DevTools overview and related methods
     */
    public boolean getGenerateNames()  {
        return getAttributeAsBoolean("generateNames");
    }

    // ********************* Methods ***********************

	/**
     * Given a {@link com.smartgwt.client.tools.PaletteNode}, make an {@link com.smartgwt.client.tools.EditNode} from it by
     * creating a  {@link com.smartgwt.client.tools.EditNode#getLiveObject liveObject} from the {@link
     * com.smartgwt.client.tools.PaletteNode#getDefaults defaults} and copying presentation properties (eg {@link
     * com.smartgwt.client.tools.PaletteNode#getTitle title} to the editNode. If <code>editNodeProperties</code> is specified
     * as an object on on the paletteNode, each property in this object will also be copied across to the editNode.
     * @param paletteNode paletteNode to create from
     *
     * @return created EditNode
     */
    public native EditNode makeEditNode(PaletteNode paletteNode) /*-{
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
     * @param menuPaletteProperties properties that should be used as new defaults when instances of this class are created
     */
    public static native void setDefaultProperties(MenuPalette menuPaletteProperties) /*-{
    	var properties = $wnd.isc.addProperties({},menuPaletteProperties.@com.smartgwt.client.widgets.BaseWidget::getConfig()());
        @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(properties,false);
        $wnd.isc.MenuPalette.addProperties(properties);
    }-*/;

    // ***********************************************************

    public LogicalStructureObject setLogicalStructure(MenuPaletteLogicalStructure s) {
        super.setLogicalStructure(s);
        return s;
    }

    public LogicalStructureObject getLogicalStructure() {
        MenuPaletteLogicalStructure s = new MenuPaletteLogicalStructure();
        setLogicalStructure(s);
        return s;
    }
}

