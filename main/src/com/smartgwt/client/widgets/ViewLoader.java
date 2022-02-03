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
 * The ViewLoader component can be used to load new Smart GWT-based user interfaces into a running application. <P>
 * <b>NOTE:</b> before using a ViewLoader, be sure that you have read about and understood the {@link
 * com.smartgwt.client.docs.SmartArchitecture Smart GWT Architecture}.  The most responsive and scalable application
 * architecture preloads views rather than using ViewLoaders. <P> A ViewLoader is a Canvas, and can be provided anywhere a
 * Canvas can be provided: as a Tab pane, and Layout member, etc.  When a ViewLoader draws, it shows a {@link
 * com.smartgwt.client.widgets.ViewLoader#getLoadingMessage loading message}, then performs an RPC to the {@link
 * com.smartgwt.client.widgets.ViewLoader#getViewURL viewURL} to load components. <P> The response from the viewURL should
 * be Smart GWT components defined in JavaScript, with no surrounding &lt;SCRIPT&gt; tags or other HTML framing.  The
 * returned script can be dynamically generated, for example, it may be the result of a JSP containing an XML view
 * description enclosed in {@link com.smartgwt.client.docs.XmlTag &lt;isomorphicXML&gt;} tags. <P> In the returned script,
 * the special variable "viewLoader" is available to refer to the ViewLoader instance that is loading components.  The
 * intended usage is that the returned script creates a view consisting of Smart GWT components, then calls
 * <code>viewLoader.setView(myView)</code> to place the loaded view into the ViewLoader. If the view does not call
 * setView() explicitly, the viewLoader will find the last top-level UI component (Canvas subclass) created by the view and
 * set that as the current view. Top-level in this case means that the UI component is not contained in another UI
 * component as a member or child. <p> The ViewLoader relies on the XMLHttpRequest object which can be disabled by
 * end-users in some supported browsers.  See {@link com.smartgwt.client.docs.PlatformDependencies} for more information.
 * @see com.smartgwt.client.rpc.RPCRequest#getEvalResult
 */
@BeanFactory.FrameworkClass
@BeanFactory.ScClassName("ViewLoader")
public class ViewLoader extends Label {

    public static ViewLoader getOrCreateRef(JavaScriptObject jsObj) {
        if (jsObj == null) return null;
        final BaseWidget refInstance = BaseWidget.getRef(jsObj);
        if (refInstance == null) {
            return new ViewLoader(jsObj);
        } else {
            assert refInstance instanceof ViewLoader;
            return (ViewLoader)refInstance;
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(ViewLoader.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "Canvas");
        }
        defaults.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
        var cleanDefaultsJS = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(defaults.@com.smartgwt.client.widgets.BaseWidget::getConfig()(), true);
        $wnd.isc.ViewLoader.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(ViewLoader.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "FormItem");
        }
        defaults.@com.smartgwt.client.widgets.form.fields.FormItem::setConfigOnly(Z)(true);
    	var cleanDefaultsJS = defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getEditorTypeConfig()();
        $wnd.isc.ViewLoader.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
    }-*/;

    public ViewLoader(){
        scClassName = "ViewLoader";
    }

    public ViewLoader(JavaScriptObject jsObj){
        scClassName = "ViewLoader";
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
     * By default a ViewLoader will explicitly prevent browser caching. <P> Set to true to allow browser caching <b>if the
     * browser would normally do so</b>, in other words, if the HTTP headers returned with the response indicate that the
     * response can be cached.
     *
     * @param allowCaching New allowCaching value. Default value is false
     * @return {@link com.smartgwt.client.widgets.ViewLoader ViewLoader} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public ViewLoader setAllowCaching(Boolean allowCaching)  throws IllegalStateException {
        return (ViewLoader)setAttribute("allowCaching", allowCaching, false);
    }

    /**
     * By default a ViewLoader will explicitly prevent browser caching. <P> Set to true to allow browser caching <b>if the
     * browser would normally do so</b>, in other words, if the HTTP headers returned with the response indicate that the
     * response can be cached.
     *
     * @return Current allowCaching value. Default value is false
     */
    public Boolean getAllowCaching()  {
        Boolean result = getAttributeAsBoolean("allowCaching");
        return result == null ? false : result;
    }
    

    /**
     * Selects the HTTP method that will be used when fetching content.  Valid values are "POST" and "GET".
     *
     * @param httpMethod New httpMethod value. Default value is "GET"
     * @return {@link com.smartgwt.client.widgets.ViewLoader ViewLoader} instance, for chaining setter calls
     */
    public ViewLoader setHttpMethod(String httpMethod) {
        return (ViewLoader)setAttribute("httpMethod", httpMethod, true);
    }

    /**
     * Selects the HTTP method that will be used when fetching content.  Valid values are "POST" and "GET".
     *
     * @return Current httpMethod value. Default value is "GET"
     */
    public String getHttpMethod()  {
        return getAttributeAsString("httpMethod");
    }
    

    /**
     * Message to show while the view is loading. Use <code>"&#36;{loadingImage}"</code> to include {@link
     * com.smartgwt.client.widgets.Canvas#loadingImageSrc a loading image}.
     *
     * @param loadingMessage New loadingMessage value. Default value is "Loading View...&amp;nbsp;${loadingImage}"
     * @return {@link com.smartgwt.client.widgets.ViewLoader ViewLoader} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public ViewLoader setLoadingMessage(String loadingMessage)  throws IllegalStateException {
        return (ViewLoader)setAttribute("loadingMessage", loadingMessage, false);
    }

    /**
     * Message to show while the view is loading. Use <code>"&#36;{loadingImage}"</code> to include {@link
     * com.smartgwt.client.widgets.Canvas#loadingImageSrc a loading image}.
     *
     * @return Current loadingMessage value. Default value is "Loading View...&amp;nbsp;${loadingImage}"
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public String getLoadingMessage()  {
        return getAttributeAsString("loadingMessage");
    }
    
    

    /**
     * URL to load components from.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Change the URL this component loads a view from.  Triggers a fetch from the new URL. <P> Can also be called with no arguments to reload the view from the existing {@link com.smartgwt.client.widgets.ViewLoader#getViewURL viewURL}.
     *
     * @param viewURL URL to retrieve view from. Default value is null
     * @return {@link com.smartgwt.client.widgets.ViewLoader ViewLoader} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.URL URL 
     * 
     */
    public ViewLoader setViewURL(String viewURL)  throws IllegalStateException {
        return (ViewLoader)setAttribute("viewURL", viewURL, false);
    }

    /**
     * URL to load components from.
     *
     * @return Current viewURL value. Default value is null
     * @see com.smartgwt.client.docs.URL URL 
     * 
     */
    public String getViewURL()  {
        return getAttributeAsString("viewURL");
    }
    
    

    // ********************* Methods ***********************
	/**
     * Retrieve the current view.  May be null if the view has not yet been loaded, or has been explicitly set to null.
     *
     * @return the current view
     */
    public native Canvas getView() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getView", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getView();
        return @com.smartgwt.client.widgets.Canvas::getByJSObject(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

	/**
     * StringMethod fired when the view has been loaded. Has no default implementation.  Add a notification to fire custom
     * logic when loading completes.
     * @param view the view that was loaded
     */
    public native void viewLoaded(Canvas view) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "viewLoaded", "Canvas");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.viewLoaded(view == null ? null : view.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()());
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
     * @param viewLoaderProperties properties that should be used as new defaults when instances of this class are created
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public static native void setDefaultProperties(ViewLoader viewLoaderProperties) /*-{
        if (viewLoaderProperties.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Class;)(ViewLoader.@java.lang.Object::getClass()(), "setDefaultProperties", viewLoaderProperties.@java.lang.Object::getClass()());
        }
        viewLoaderProperties.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
    	var properties = viewLoaderProperties.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        properties = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(properties,true);
        $wnd.isc.ViewLoader.addProperties(properties);
    }-*/;

    // ***********************************************************

    /**
     * Setter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject setLogicalStructure(ViewLoaderLogicalStructure s) {
        super.setLogicalStructure(s);
        try {
            s.allowCaching = getAttributeAsString("allowCaching");
        } catch (Throwable t) {
            s.logicalStructureErrors += "ViewLoader.allowCaching:" + t.getMessage() + "\n";
        }
        try {
            s.httpMethod = getAttributeAsString("httpMethod");
        } catch (Throwable t) {
            s.logicalStructureErrors += "ViewLoader.httpMethod:" + t.getMessage() + "\n";
        }
        try {
            s.loadingMessage = getAttributeAsString("loadingMessage");
        } catch (Throwable t) {
            s.logicalStructureErrors += "ViewLoader.loadingMessage:" + t.getMessage() + "\n";
        }
        try {
            s.viewURL = getAttributeAsString("viewURL");
        } catch (Throwable t) {
            s.logicalStructureErrors += "ViewLoader.viewURL:" + t.getMessage() + "\n";
        }
        return s;
    }

    /**
     * Getter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject getLogicalStructure() {
        ViewLoaderLogicalStructure s = new ViewLoaderLogicalStructure();
        setLogicalStructure(s);
        return s;
    }
}
