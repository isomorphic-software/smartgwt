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
 
package com.smartgwt.client.widgets;


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
 * Specially styled Button subclass used by the {@link com.smartgwt.client.widgets.layout.NavigationBar} class.
 */
@BeanFactory.FrameworkClass
@BeanFactory.ScClassName("NavigationButton")
public class NavigationButton extends Button {

    public static NavigationButton getOrCreateRef(JavaScriptObject jsObj) {
        if (jsObj == null) return null;
        final BaseWidget refInstance = BaseWidget.getRef(jsObj);
        if (refInstance == null) {
            return new NavigationButton(jsObj);
        } else {
            assert refInstance instanceof NavigationButton;
            return (NavigationButton)refInstance;
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(NavigationButton.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "Canvas");
        }
        defaults.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
        var cleanDefaultsJS = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(defaults.@com.smartgwt.client.widgets.BaseWidget::getConfig()(), true);
        $wnd.isc.NavigationButton.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(NavigationButton.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "FormItem");
        }
        defaults.@com.smartgwt.client.widgets.form.fields.FormItem::setConfigOnly(Z)(true);
    	var cleanDefaultsJS = defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getEditorTypeConfig()();
        $wnd.isc.NavigationButton.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
    }-*/;

    public NavigationButton(){
        scClassName = "NavigationButton";
    }

    public NavigationButton(JavaScriptObject jsObj){
        scClassName = "NavigationButton";
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
     * Base style for navigation buttons where {@link com.smartgwt.client.types.Direction} is set to <code>"back"</code>
     *
     * @param backBaseStyle New backBaseStyle value. Default value is "navBackButton"
     * @return {@link com.smartgwt.client.widgets.NavigationButton NavigationButton} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public NavigationButton setBackBaseStyle(String backBaseStyle) {
        return (NavigationButton)setAttribute("backBaseStyle", backBaseStyle, true);
    }

    /**
     * Base style for navigation buttons where {@link com.smartgwt.client.types.Direction} is set to <code>"back"</code>
     *
     * @return Current backBaseStyle value. Default value is "navBackButton"
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public String getBackBaseStyle()  {
        return getAttributeAsString("backBaseStyle");
    }
    

    /**
     * Default baseStyle for navigation buttons. Note that the special {@link
     * com.smartgwt.client.widgets.NavigationButton#getBackBaseStyle backBaseStyle} and {@link
     * com.smartgwt.client.widgets.NavigationButton#getForwardBaseStyle forwardBaseStyle} are applied if {@link
     * com.smartgwt.client.widgets.NavigationButton#getDirection direction} is set.
     *
     * @param baseStyle New baseStyle value. Default value is "navButton"
     * @return {@link com.smartgwt.client.widgets.NavigationButton NavigationButton} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public NavigationButton setBaseStyle(String baseStyle) {
        return (NavigationButton)setAttribute("baseStyle", baseStyle, true);
    }

    /**
     * Default baseStyle for navigation buttons. Note that the special {@link
     * com.smartgwt.client.widgets.NavigationButton#getBackBaseStyle backBaseStyle} and {@link
     * com.smartgwt.client.widgets.NavigationButton#getForwardBaseStyle forwardBaseStyle} are applied if {@link
     * com.smartgwt.client.widgets.NavigationButton#getDirection direction} is set.
     *
     * @return Current baseStyle value. Default value is "navButton"
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public String getBaseStyle()  {
        return getAttributeAsString("baseStyle");
    }
    

    /**
     * Navigation direction for this button. If set to <code>"forward"</code> or <code>"back"</code> the special {@link
     * com.smartgwt.client.widgets.NavigationButton#getForwardBaseStyle forwardBaseStyle} or {@link
     * com.smartgwt.client.widgets.NavigationButton#getBackBaseStyle backBaseStyle} will be applied.
     *
     * @param direction New direction value. Default value is "none"
     * @return {@link com.smartgwt.client.widgets.NavigationButton NavigationButton} instance, for chaining setter calls
     */
    public NavigationButton setDirection(NavigationDirection direction) {
        return (NavigationButton)setAttribute("direction", direction == null ? null : direction.getValue(), true);
    }

    /**
     * Navigation direction for this button. If set to <code>"forward"</code> or <code>"back"</code> the special {@link
     * com.smartgwt.client.widgets.NavigationButton#getForwardBaseStyle forwardBaseStyle} or {@link
     * com.smartgwt.client.widgets.NavigationButton#getBackBaseStyle backBaseStyle} will be applied.
     *
     * @return Current direction value. Default value is "none"
     */
    public NavigationDirection getDirection()  {
        return EnumUtil.getEnum(NavigationDirection.values(), getAttribute("direction"));
    }
    

    /**
     * Base style for navigation buttons where {@link com.smartgwt.client.types.Direction} is set to <code>"forward"</code>
     *
     * @param forwardBaseStyle New forwardBaseStyle value. Default value is "navForwardButton"
     * @return {@link com.smartgwt.client.widgets.NavigationButton NavigationButton} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public NavigationButton setForwardBaseStyle(String forwardBaseStyle) {
        return (NavigationButton)setAttribute("forwardBaseStyle", forwardBaseStyle, true);
    }

    /**
     * Base style for navigation buttons where {@link com.smartgwt.client.types.Direction} is set to <code>"forward"</code>
     *
     * @return Current forwardBaseStyle value. Default value is "navForwardButton"
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public String getForwardBaseStyle()  {
        return getAttributeAsString("forwardBaseStyle");
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
     * @param navigationButtonProperties properties that should be used as new defaults when instances of this class are created
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public static native void setDefaultProperties(NavigationButton navigationButtonProperties) /*-{
        if (navigationButtonProperties.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Class;)(NavigationButton.@java.lang.Object::getClass()(), "setDefaultProperties", navigationButtonProperties.@java.lang.Object::getClass()());
        }
        navigationButtonProperties.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
    	var properties = navigationButtonProperties.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        properties = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(properties,true);
        $wnd.isc.NavigationButton.addProperties(properties);
    }-*/;

    // ***********************************************************

    /**
     * Setter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject setLogicalStructure(NavigationButtonLogicalStructure s) {
        super.setLogicalStructure(s);
        try {
            s.backBaseStyle = getAttributeAsString("backBaseStyle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "NavigationButton.backBaseStyle:" + t.getMessage() + "\n";
        }
        try {
            s.baseStyle = getAttributeAsString("baseStyle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "NavigationButton.baseStyle:" + t.getMessage() + "\n";
        }
        try {
            s.direction = getAttributeAsString("direction");
        } catch (Throwable t) {
            s.logicalStructureErrors += "NavigationButton.direction:" + t.getMessage() + "\n";
        }
        try {
            s.forwardBaseStyle = getAttributeAsString("forwardBaseStyle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "NavigationButton.forwardBaseStyle:" + t.getMessage() + "\n";
        }
        return s;
    }

    /**
     * Getter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject getLogicalStructure() {
        NavigationButtonLogicalStructure s = new NavigationButtonLogicalStructure();
        setLogicalStructure(s);
        return s;
    }
}
