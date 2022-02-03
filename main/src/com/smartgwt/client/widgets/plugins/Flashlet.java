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
 
package com.smartgwt.client.widgets.plugins;


import com.smartgwt.client.event.*;
import com.smartgwt.client.core.*;
import com.smartgwt.client.types.*;
import com.smartgwt.client.data.*;
import com.smartgwt.client.data.Record;
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

import com.google.gwt.event.shared.*;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.core.client.JavaScriptObject;

import com.smartgwt.client.util.*;
import com.smartgwt.client.util.events.*;
import com.smartgwt.client.util.workflow.*;
import com.smartgwt.client.util.workflow.Process; // required to override java.lang.Process

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

/**
 * ISC abstraction for Flashlets.
 */
@BeanFactory.FrameworkClass
@BeanFactory.ScClassName("Flashlet")
public class Flashlet extends BrowserPlugin {

    public static Flashlet getOrCreateRef(JavaScriptObject jsObj) {
        if (jsObj == null) return null;
        final BaseWidget refInstance = BaseWidget.getRef(jsObj);
        if (refInstance == null) {
            return new Flashlet(jsObj);
        } else {
            assert refInstance instanceof Flashlet;
            return (Flashlet)refInstance;
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(Flashlet.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "Canvas");
        }
        defaults.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
        var cleanDefaultsJS = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(defaults.@com.smartgwt.client.widgets.BaseWidget::getConfig()(), true);
        $wnd.isc.Flashlet.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(Flashlet.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "FormItem");
        }
        defaults.@com.smartgwt.client.widgets.form.fields.FormItem::setConfigOnly(Z)(true);
    	var cleanDefaultsJS = defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getEditorTypeConfig()();
        $wnd.isc.Flashlet.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
    }-*/;

    public Flashlet(){
        scClassName = "Flashlet";
    }

    public Flashlet(JavaScriptObject jsObj){
        scClassName = "Flashlet";
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
     * This attribute specifies the clsid of the outer &lt;object&gt; tag.  <p>  The default classID is:
     * "clsid:D27CDB6E-AE6D-11cf-96B8-444553540000"  <p>
     *
     * @param classID New classID value. Default value is see below
     * @return {@link com.smartgwt.client.widgets.plugins.Flashlet Flashlet} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public Flashlet setClassID(String classID)  throws IllegalStateException {
        return (Flashlet)setAttribute("classID", classID, false);
    }

    /**
     * This attribute specifies the clsid of the outer &lt;object&gt; tag.  <p>  The default classID is:
     * "clsid:D27CDB6E-AE6D-11cf-96B8-444553540000"  <p>
     *
     * @return Current classID value. Default value is see below
     */
    public String getClassID()  {
        return getAttributeAsString("classID");
    }
    

    /**
     * This attribute specifies the minimum version of the flash player required to show this  flashlet.  <p>  The default
     * codeBase is: "http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=5,0,0,0"  <p>
     *
     * @param codeBase New codeBase value. Default value is see below
     * @return {@link com.smartgwt.client.widgets.plugins.Flashlet Flashlet} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.URL URL 
     */
    public Flashlet setCodeBase(String codeBase)  throws IllegalStateException {
        return (Flashlet)setAttribute("codeBase", codeBase, false);
    }

    /**
     * This attribute specifies the minimum version of the flash player required to show this  flashlet.  <p>  The default
     * codeBase is: "http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=5,0,0,0"  <p>
     *
     * @return Current codeBase value. Default value is see below
     * @see com.smartgwt.client.docs.URL URL 
     */
    public String getCodeBase()  {
        return getAttributeAsString("codeBase");
    }
    

    /**
     * Sets the 'name' attribute on the flashlet object.  If a name is not provided it will be  auto-generated.  Note that in
     * general you don't need to set this.  If you have a handle to  your ISC Flashlet object you can simply call {@link
     * com.smartgwt.client.widgets.plugins.Flashlet#getPluginHandle getPluginHandle()} to get a  handle to the element.
     *
     * @param name New name value. Default value is null
     * @return {@link com.smartgwt.client.widgets.plugins.Flashlet Flashlet} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.plugins.Flashlet#getPluginHandle
     */
    public Flashlet setName(String name)  throws IllegalStateException {
        return (Flashlet)setAttribute("name", name, false);
    }

    /**
     * Sets the 'name' attribute on the flashlet object.  If a name is not provided it will be  auto-generated.  Note that in
     * general you don't need to set this.  If you have a handle to  your ISC Flashlet object you can simply call {@link
     * com.smartgwt.client.widgets.plugins.Flashlet#getPluginHandle getPluginHandle()} to get a  handle to the element.
     *
     * @return Current name value. Default value is null
     * @see com.smartgwt.client.widgets.plugins.Flashlet#getPluginHandle
     */
    public String getName()  {
        return getAttributeAsString("name");
    }
    

    /**
     * A map of key/value pairs to pass to the flashlet as parameters.  Note that these will be set  on the outer
     * &lt;object&gt; element as well as the inner &lt;embed&gt; element.
     *
     * @param params New params value. Default value is null
     * @return {@link com.smartgwt.client.widgets.plugins.Flashlet Flashlet} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public Flashlet setParams(Map params)  throws IllegalStateException {
        return (Flashlet)setAttribute("params", params, false);
    }

    /**
     * A map of key/value pairs to pass to the flashlet as parameters.  Note that these will be set  on the outer
     * &lt;object&gt; element as well as the inner &lt;embed&gt; element.
     *
     * @return Current params value. Default value is null
     */
    public Map getParams()  {
        return getAttributeAsMap("params");
    }
    

    /**
     * This attribute specifies the page the user should go to to get the plugin required to view  this flashlet.  <p>  The
     * default pluginsPage is: "http://www.macromedia.com/shockwave/download/index.cgi?P1_Prod_Version=ShockwaveFlash"  <p>
     *
     * @param pluginsPage New pluginsPage value. Default value is see below
     * @return {@link com.smartgwt.client.widgets.plugins.Flashlet Flashlet} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.URL URL 
     */
    public Flashlet setPluginsPage(String pluginsPage)  throws IllegalStateException {
        return (Flashlet)setAttribute("pluginsPage", pluginsPage, false);
    }

    /**
     * This attribute specifies the page the user should go to to get the plugin required to view  this flashlet.  <p>  The
     * default pluginsPage is: "http://www.macromedia.com/shockwave/download/index.cgi?P1_Prod_Version=ShockwaveFlash"  <p>
     *
     * @return Current pluginsPage value. Default value is see below
     * @see com.smartgwt.client.docs.URL URL 
     */
    public String getPluginsPage()  {
        return getAttributeAsString("pluginsPage");
    }
    

    /**
     * Location from which to load the Flashlet.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets the source file for the flash component
     *
     * @param src New src value. Default value is null
     * @return {@link com.smartgwt.client.widgets.plugins.Flashlet Flashlet} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.URL URL 
     */
    public Flashlet setSrc(String src)  throws IllegalStateException {
        return (Flashlet)setAttribute("src", src, false);
    }

    /**
     * Location from which to load the Flashlet.
     *
     * @return Current src value. Default value is null
     * @see com.smartgwt.client.docs.URL URL 
     */
    public String getSrc()  {
        return getAttributeAsString("src");
    }
    

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************

	/**
     * Is Shockwave Flash installed on this browser?
     *
     * @return <code>true</code> if Flash is installed; <code>false</code> otherwise.
     */
    public static native boolean flashAvailable() /*-{
        var ret = $wnd.isc.Flashlet.flashAvailable();
        return ret == null ? false : ret;
    }-*/;


	/**
     * Which version of Flash is installed on this browser?
     *
     * @return flash version number, or null if flash is not installed
     */
    public static native int getFlashVersion() /*-{
        var ret = $wnd.isc.Flashlet.getFlashVersion();
        return ret;
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
     * @param flashletProperties properties that should be used as new defaults when instances of this class are created
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public static native void setDefaultProperties(Flashlet flashletProperties) /*-{
        if (flashletProperties.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Class;)(Flashlet.@java.lang.Object::getClass()(), "setDefaultProperties", flashletProperties.@java.lang.Object::getClass()());
        }
        flashletProperties.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
    	var properties = flashletProperties.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        properties = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(properties,true);
        $wnd.isc.Flashlet.addProperties(properties);
    }-*/;

    // ***********************************************************


    /**
     * Returns a handle to the flashlet DOM element (valid only after the component has been drawn).
     *
     * @return pointer to the plugin element in the DOM
     */
    public native Element getPluginHandle() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        return self.getPluginHandle();
    }-*/;


    /**
     * Setter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject setLogicalStructure(FlashletLogicalStructure s) {
        super.setLogicalStructure(s);
        try {
            s.classID = getAttributeAsString("classID");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Flashlet.classID:" + t.getMessage() + "\n";
        }
        try {
            s.codeBase = getAttributeAsString("codeBase");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Flashlet.codeBase:" + t.getMessage() + "\n";
        }
        try {
            s.name = getAttributeAsString("name");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Flashlet.name:" + t.getMessage() + "\n";
        }
        try {
            s.params = getAttributeAsString("params");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Flashlet.params:" + t.getMessage() + "\n";
        }
        try {
            s.pluginsPage = getAttributeAsString("pluginsPage");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Flashlet.pluginsPage:" + t.getMessage() + "\n";
        }
        try {
            s.src = getAttributeAsString("src");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Flashlet.src:" + t.getMessage() + "\n";
        }
        return s;
    }

    /**
     * Getter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject getLogicalStructure() {
        FlashletLogicalStructure s = new FlashletLogicalStructure();
        setLogicalStructure(s);
        return s;
    }
}
