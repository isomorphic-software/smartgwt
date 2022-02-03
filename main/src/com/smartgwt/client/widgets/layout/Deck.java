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
 
package com.smartgwt.client.widgets.layout;


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
 * A simple container that implements the policy that at most one of its contained components is visible at any given time.
 * <p> The set of mutually exclusive components is specified by {@link com.smartgwt.client.widgets.layout.Deck#getPanes
 * panes}, and whichever component is visible fills the space of the <code>Deck</code> automatically. <p> To switch to a
 * new pane, call {@link com.smartgwt.client.widgets.layout.Deck#setCurrentPane setCurrentPane()}, or simply call {@link
 * com.smartgwt.client.widgets.Canvas#show show()} on the pane directly - the <code>Deck</code> will notice that you have
 * shown a different pane and hide other panes automatically. <p> {@link com.smartgwt.client.widgets.Canvas#getChildren
 * Deck.children} may also be used; any components that are specified as children are unmanaged by the <code>Deck</code>
 * and so can place themselves arbitrarily. <p> <code>Deck</code> achieves its mutually-exclusive display behavior by using
 * the superclass {@link com.smartgwt.client.widgets.layout.Layout#getMembers Layout.members} property, which means that
 * properties such as {@link com.smartgwt.client.widgets.layout.Layout#getLayoutMargin Layout.layoutMargin} and {@link
 * com.smartgwt.client.widgets.layout.Layout#getVPolicy Layout.vPolicy} do apply to deck.  However, trying to manipulate
 * <code>deck.members</code> with APIs such as {@link com.smartgwt.client.widgets.layout.Layout#addMember
 * Layout.addMember()} is not supported and will have undefined results.
 */
@BeanFactory.FrameworkClass
@BeanFactory.ScClassName("Deck")
public class Deck extends Layout {

    public static Deck getOrCreateRef(JavaScriptObject jsObj) {
        if (jsObj == null) return null;
        final BaseWidget refInstance = BaseWidget.getRef(jsObj);
        if (refInstance == null) {
            return new Deck(jsObj);
        } else {
            assert refInstance instanceof Deck;
            return (Deck)refInstance;
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(Deck.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "Canvas");
        }
        defaults.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
        var cleanDefaultsJS = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(defaults.@com.smartgwt.client.widgets.BaseWidget::getConfig()(), true);
        $wnd.isc.Deck.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(Deck.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "FormItem");
        }
        defaults.@com.smartgwt.client.widgets.form.fields.FormItem::setConfigOnly(Z)(true);
    	var cleanDefaultsJS = defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getEditorTypeConfig()();
        $wnd.isc.Deck.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
    }-*/;

    public Deck(){
        scClassName = "Deck";
    }

    public Deck(JavaScriptObject jsObj){
        scClassName = "Deck";
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
     * The pane currently shown in this <code>Deck</code>.  All other panes are hidden.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Change the {@link com.smartgwt.client.types.CurrentPane}. <p> If the passed pane is not contained in this <code>Deck</code>, logs a warning and does nothing.
     *
     * @param currentPane the pane to show, as either a <code>Canvas</code> or the {@link com.smartgwt.client.widgets.Canvas#getID Canvas.ID}. Default value is null
     * @return {@link com.smartgwt.client.widgets.layout.Deck Deck} instance, for chaining setter calls
     */
    public Deck setCurrentPane(Canvas currentPane) {
        return (Deck)setAttribute("currentPane", currentPane == null ? null : currentPane.getOrCreateJsObj(), true);
    }

    /**
     * The pane currently shown in this <code>Deck</code>.  All other panes are hidden.
     *
     * @return Current currentPane value. Default value is null
     */
    public Canvas getCurrentPane()  {
        return (Canvas)Canvas.getByJSObject(getAttributeAsJavaScriptObject("currentPane"));
    }
    

    /**
     * Set of mutually exclusive panes displayed in this <code>Deck</code>. <p> If {@link
     * com.smartgwt.client.widgets.layout.Deck#getCurrentPane currentPane} is not set, when the <code>Deck</code> is first
     * drawn, the first pane in this array becomes the <code>currentPane</code>.
     *
     * @param panes New panes value. Default value is null
     * @return {@link com.smartgwt.client.widgets.layout.Deck Deck} instance, for chaining setter calls
     */
    public Deck setPanes(Canvas... panes) {
        return (Deck)setAttribute("panes", panes, true);
    }

    /**
     * Set of mutually exclusive panes displayed in this <code>Deck</code>. <p> If {@link
     * com.smartgwt.client.widgets.layout.Deck#getCurrentPane currentPane} is not set, when the <code>Deck</code> is first
     * drawn, the first pane in this array becomes the <code>currentPane</code>.
     *
     * @return Current panes value. Default value is null
     */
    public Canvas[] getPanes()  {
        return com.smartgwt.client.util.ConvertTo.arrayOfCanvas(getAttributeAsJavaScriptObject("panes"));
    }
    

    // ********************* Methods ***********************
	/**
     * Add a pane to this deck. If the specified pane is already present in the deck, it will be moved to the specified
     * position.
     * @param pane pane to add
     */
    public native void addPane(Canvas pane) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "addPane", "Canvas");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.addPane(pane == null ? null : pane.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()());
    }-*/;

	/**
     * Add a pane to this deck. If the specified pane is already present in the deck, it will be moved to the specified
     * position.
     * @param pane pane to add
     * @param index position for the new pane in the {@link com.smartgwt.client.widgets.layout.Deck#getPanes panes} array.   If no index is
     * specified, the pane will be added to the end of the panes array.
     */
    public native void addPane(Canvas pane, Integer index) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "addPane", "Canvas,Integer");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.addPane(pane == null ? null : pane.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()(), index == null ? null : index.@java.lang.Integer::intValue()());
    }-*/;
	
	/**
     * Hides the current pane, without showing any other pane.
     */
    public native void hideCurrentPane() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "hideCurrentPane", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.hideCurrentPane();
    }-*/;

	/**
     * Remove a pane from this deck.
     * @param pane pane to remove
     */
    public native void removePane(Canvas pane) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "removePane", "Canvas");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.removePane(pane == null ? null : pane.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()());
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
     * @param deckProperties properties that should be used as new defaults when instances of this class are created
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public static native void setDefaultProperties(Deck deckProperties) /*-{
        if (deckProperties.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Class;)(Deck.@java.lang.Object::getClass()(), "setDefaultProperties", deckProperties.@java.lang.Object::getClass()());
        }
        deckProperties.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
    	var properties = deckProperties.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        properties = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(properties,true);
        $wnd.isc.Deck.addProperties(properties);
    }-*/;

    // ***********************************************************

    /**
     * Setter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject setLogicalStructure(DeckLogicalStructure s) {
        super.setLogicalStructure(s);
        try {
            s.currentPane = getCurrentPane();
        } catch (Throwable t) {
            s.logicalStructureErrors += "Deck.currentPane:" + t.getMessage() + "\n";
        }
        try {
            s.panes = getPanes();
        } catch (Throwable t) {
            s.logicalStructureErrors += "Deck.panesArray:" + t.getMessage() + "\n";
        }
        return s;
    }

    /**
     * Getter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject getLogicalStructure() {
        DeckLogicalStructure s = new DeckLogicalStructure();
        setLogicalStructure(s);
        return s;
    }
}
