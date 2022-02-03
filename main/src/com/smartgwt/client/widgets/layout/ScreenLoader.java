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
 * The ScreenLoader component can be used to load {@link com.smartgwt.client.docs.ComponentXML ComponentXML Screens} into a
 * running application. <P> A ScreenLoader is a VLayout, and can be provided anywhere a Canvas can be used: as a Tab pane,
 * and Layout member, etc.  When a ScreenLoader draws, it shows a {@link
 * com.smartgwt.client.widgets.layout.ScreenLoader#getLoadingMessage loading message} if {@link
 * com.smartgwt.client.widgets.layout.ScreenLoader#getShowLoadingMessage enabled}, performs an RPC to the {@link
 * com.smartgwt.client.rpc.RPCManager#screenLoaderURL screenLoaderURL} to load the screen, if necessary, and finally embeds
 * the {@link com.smartgwt.client.widgets.layout.ScreenLoader#getScreenName screen} within the layout. <P> The last
 * top-level UI component (Canvas subclass) defined by the screen is set as the layout contents. Top-level in this case
 * means that the UI component is not contained in another UI component as a member or child. <p> The ScreenLoader relies
 * on the XMLHttpRequest object which can be disabled by end-users in some supported browsers.  See {@link
 * com.smartgwt.client.docs.PlatformDependencies} for more information.
 */
@BeanFactory.FrameworkClass
@BeanFactory.ScClassName("ScreenLoader")
public class ScreenLoader extends VLayout {

    public static ScreenLoader getOrCreateRef(JavaScriptObject jsObj) {
        if (jsObj == null) return null;
        final BaseWidget refInstance = BaseWidget.getRef(jsObj);
        if (refInstance == null) {
            return new ScreenLoader(jsObj);
        } else {
            assert refInstance instanceof ScreenLoader;
            return (ScreenLoader)refInstance;
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(ScreenLoader.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "Canvas");
        }
        defaults.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
        var cleanDefaultsJS = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(defaults.@com.smartgwt.client.widgets.BaseWidget::getConfig()(), true);
        $wnd.isc.ScreenLoader.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(ScreenLoader.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "FormItem");
        }
        defaults.@com.smartgwt.client.widgets.form.fields.FormItem::setConfigOnly(Z)(true);
    	var cleanDefaultsJS = defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getEditorTypeConfig()();
        $wnd.isc.ScreenLoader.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
    }-*/;

    public ScreenLoader(){
        scClassName = "ScreenLoader";
    }

    public ScreenLoader(JavaScriptObject jsObj){
        scClassName = "ScreenLoader";
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
     * A {@link com.smartgwt.client.widgets.DataContextBinding} to be applied to the loaded screen via {@link
     * com.smartgwt.client.widgets.Canvas#setDataContext Canvas.setDataContext()}.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Set the dataContextBinding property.
     *
     * @param dataContextBinding the new DataContext binding. Default value is null
     * @return {@link com.smartgwt.client.widgets.layout.ScreenLoader ScreenLoader} instance, for chaining setter calls
     */
    public ScreenLoader setDataContextBinding(DataContextBinding dataContextBinding) {
        return (ScreenLoader)setAttribute("dataContextBinding", dataContextBinding == null ? null : dataContextBinding.getJsObj(), true);
    }

    /**
     * A {@link com.smartgwt.client.widgets.DataContextBinding} to be applied to the loaded screen via {@link
     * com.smartgwt.client.widgets.Canvas#setDataContext Canvas.setDataContext()}.
     *
     * @return Current dataContextBinding value. Default value is null
     */
    public DataContextBinding getDataContextBinding()  {
        return new DataContextBinding(getAttributeAsJavaScriptObject("dataContextBinding"));
    }
    

    /**
     * Default class used to construct the {@link com.smartgwt.client.tools.EditProxy} for this component when the component is
     * {@link com.smartgwt.client.widgets.Canvas#setEditMode first placed into edit mode}.
     *
     * @param editProxyConstructor New editProxyConstructor value. Default value is "ScreenLoaderEditProxy"
     * @return {@link com.smartgwt.client.widgets.layout.ScreenLoader ScreenLoader} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.SCClassName SCClassName 
     */
    public ScreenLoader setEditProxyConstructor(String editProxyConstructor)  throws IllegalStateException {
        return (ScreenLoader)setAttribute("editProxyConstructor", editProxyConstructor, false);
    }

    /**
     * Default class used to construct the {@link com.smartgwt.client.tools.EditProxy} for this component when the component is
     * {@link com.smartgwt.client.widgets.Canvas#setEditMode first placed into edit mode}.
     *
     * @return Current editProxyConstructor value. Default value is "ScreenLoaderEditProxy"
     * @see com.smartgwt.client.docs.SCClassName SCClassName 
     */
    public String getEditProxyConstructor()  {
        return getAttributeAsString("editProxyConstructor");
    }
    

    /**
     * Message to show while the screen is loading if {@link
     * com.smartgwt.client.widgets.layout.ScreenLoader#getShowLoadingMessage enabled}. Use <code>"&#36;{loadingImage}"</code>
     * to include {@link com.smartgwt.client.widgets.Canvas#loadingImageSrc a loading image}.
     *
     * @param loadingMessage New loadingMessage value. Default value is "Loading Screen...&amp;nbsp;${loadingImage}"
     * @return {@link com.smartgwt.client.widgets.layout.ScreenLoader ScreenLoader} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public ScreenLoader setLoadingMessage(String loadingMessage)  throws IllegalStateException {
        return (ScreenLoader)setAttribute("loadingMessage", loadingMessage, false);
    }

    /**
     * Message to show while the screen is loading if {@link
     * com.smartgwt.client.widgets.layout.ScreenLoader#getShowLoadingMessage enabled}. Use <code>"&#36;{loadingImage}"</code>
     * to include {@link com.smartgwt.client.widgets.Canvas#loadingImageSrc a loading image}.
     *
     * @return Current loadingMessage value. Default value is "Loading Screen...&amp;nbsp;${loadingImage}"
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public String getLoadingMessage()  {
        return getAttributeAsString("loadingMessage");
    }
    

    /**
     * Specifies the URL where ScreenLoaderServlet is installed. If not set, {@link
     * com.smartgwt.client.rpc.RPCManager#screenLoaderURL screenLoaderURL} is used.
     *
     * @param screenLoaderURL New screenLoaderURL value. Default value is null
     * @return {@link com.smartgwt.client.widgets.layout.ScreenLoader ScreenLoader} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.URL URL 
     */
    public ScreenLoader setScreenLoaderURL(String screenLoaderURL)  throws IllegalStateException {
        return (ScreenLoader)setAttribute("screenLoaderURL", screenLoaderURL, false);
    }

    /**
     * Specifies the URL where ScreenLoaderServlet is installed. If not set, {@link
     * com.smartgwt.client.rpc.RPCManager#screenLoaderURL screenLoaderURL} is used.
     *
     * @return Current screenLoaderURL value. Default value is null
     * @see com.smartgwt.client.docs.URL URL 
     */
    public String getScreenLoaderURL()  {
        return getAttributeAsString("screenLoaderURL");
    }
    

    /**
     * Name of screen to be loaded.
     *
     * @param screenName New screenName value. Default value is null
     * @return {@link com.smartgwt.client.widgets.layout.ScreenLoader ScreenLoader} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public ScreenLoader setScreenName(String screenName)  throws IllegalStateException {
        return (ScreenLoader)setAttribute("screenName", screenName, false);
    }

    /**
     * Name of screen to be loaded.
     *
     * @return Current screenName value. Default value is null
     */
    public String getScreenName()  {
        return getAttributeAsString("screenName");
    }
    

    /**
     * Should a {@link com.smartgwt.client.widgets.layout.ScreenLoader#getLoadingMessage loading message} be displayed while
     * screen is loading?
     *
     * @param showLoadingMessage New showLoadingMessage value. Default value is false
     * @return {@link com.smartgwt.client.widgets.layout.ScreenLoader ScreenLoader} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public ScreenLoader setShowLoadingMessage(Boolean showLoadingMessage)  throws IllegalStateException {
        return (ScreenLoader)setAttribute("showLoadingMessage", showLoadingMessage, false);
    }

    /**
     * Should a {@link com.smartgwt.client.widgets.layout.ScreenLoader#getLoadingMessage loading message} be displayed while
     * screen is loading?
     *
     * @return Current showLoadingMessage value. Default value is false
     */
    public Boolean getShowLoadingMessage()  {
        Boolean result = getAttributeAsBoolean("showLoadingMessage");
        return result == null ? false : result;
    }
    

    // ********************* Methods ***********************
	/**
     * Notification method fired when {@link com.smartgwt.client.widgets.DataContext} is bound on the embedded screen. This can
     * occur on the initial draw or by an explicit call to {@link com.smartgwt.client.widgets.Canvas#setDataContext
     * setDataContext()} either via this ScreenLoader or from other components including the screen itself.
     */
    public native void dataContextChanged() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "dataContextChanged", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.dataContextChanged();
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
     * @param screenLoaderProperties properties that should be used as new defaults when instances of this class are created
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public static native void setDefaultProperties(ScreenLoader screenLoaderProperties) /*-{
        if (screenLoaderProperties.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Class;)(ScreenLoader.@java.lang.Object::getClass()(), "setDefaultProperties", screenLoaderProperties.@java.lang.Object::getClass()());
        }
        screenLoaderProperties.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
    	var properties = screenLoaderProperties.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        properties = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(properties,true);
        $wnd.isc.ScreenLoader.addProperties(properties);
    }-*/;

    // ***********************************************************

    /**
     * Setter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject setLogicalStructure(ScreenLoaderLogicalStructure s) {
        super.setLogicalStructure(s);
        try {
            s.dataContextBinding = getDataContextBinding();
        } catch (Throwable t) {
            s.logicalStructureErrors += "ScreenLoader.dataContextBinding:" + t.getMessage() + "\n";
        }
        try {
            s.editProxyConstructor = getAttributeAsString("editProxyConstructor");
        } catch (Throwable t) {
            s.logicalStructureErrors += "ScreenLoader.editProxyConstructor:" + t.getMessage() + "\n";
        }
        try {
            s.loadingMessage = getAttributeAsString("loadingMessage");
        } catch (Throwable t) {
            s.logicalStructureErrors += "ScreenLoader.loadingMessage:" + t.getMessage() + "\n";
        }
        try {
            s.screenLoaderURL = getAttributeAsString("screenLoaderURL");
        } catch (Throwable t) {
            s.logicalStructureErrors += "ScreenLoader.screenLoaderURL:" + t.getMessage() + "\n";
        }
        try {
            s.screenName = getAttributeAsString("screenName");
        } catch (Throwable t) {
            s.logicalStructureErrors += "ScreenLoader.screenName:" + t.getMessage() + "\n";
        }
        try {
            s.showLoadingMessage = getAttributeAsString("showLoadingMessage");
        } catch (Throwable t) {
            s.logicalStructureErrors += "ScreenLoader.showLoadingMessage:" + t.getMessage() + "\n";
        }
        return s;
    }

    /**
     * Getter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject getLogicalStructure() {
        ScreenLoaderLogicalStructure s = new ScreenLoaderLogicalStructure();
        setLogicalStructure(s);
        return s;
    }
}
