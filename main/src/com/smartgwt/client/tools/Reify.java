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
 * An application available within {@link com.smartgwt.client.docs.ReifyOnSite Reify OnSite} that allows developers to
 * create and manage Smart GWT screens and datasources.  Only <b>internal framework code</b> can create an instance of the
 * Reify tool -  do not try it directly in your applications.  If you want to create visual tools similar to Reify, see
 * {@link com.smartgwt.client.docs.DevTools the Dashboards & Tools framework overview}. <p> Note that in the Smart GWT SDK,
 * this class present only to provide {@link com.smartgwt.client.docs.ReifyForDevelopers Reify} utility class method APIs,
 * and is not an instantiable widget.  For example, you can call {@link com.smartgwt.client.tools.Reify#getMockDS
 * getMockDS()} to export a {@link com.smartgwt.client.data.DataSource} as XML-formatted values and metadata for importing
 * into Reify to create a {@link com.smartgwt.client.data.MockDataSource}.
 * @see com.smartgwt.client.docs.Reify Reify overview and related methods
 */
@BeanFactory.FrameworkClass
@BeanFactory.ScClassName("Reify")
public class Reify extends VLayout {

    public static Reify getOrCreateRef(JavaScriptObject jsObj) {
        if (jsObj == null) return null;
        final BaseWidget refInstance = BaseWidget.getRef(jsObj);
        if (refInstance == null) {
            return new Reify(jsObj);
        } else {
            assert refInstance instanceof Reify;
            return (Reify)refInstance;
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(Reify.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "Canvas");
        }
        defaults.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
        var cleanDefaultsJS = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(defaults.@com.smartgwt.client.widgets.BaseWidget::getConfig()(), true);
        $wnd.isc.Reify.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(Reify.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "FormItem");
        }
        defaults.@com.smartgwt.client.widgets.form.fields.FormItem::setConfigOnly(Z)(true);
    	var cleanDefaultsJS = defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getEditorTypeConfig()();
        $wnd.isc.Reify.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
    }-*/;

    public Reify(){
        setID("VB");
        scClassName = "Reify";
    }

    public Reify(JavaScriptObject jsObj){
        scClassName = "Reify";
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

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************

	/**
     * Exports or serializes the specified {@link com.smartgwt.client.data.DataSource DataSources} using the provided settings.
     * <P> The "reifyCSV" {@link com.smartgwt.client.util.MockDSExportSettings#getFormat format} generates comma-separated
     * values to paste into the DataSource creation wizard in {@link com.smartgwt.client.docs.ReifyForDevelopers Reify}.  The
     * use case for the other two formats is, if you have a Smart GWT application, and you plan to load {@link
     * com.smartgwt.client.data.MockDataSource MockDataSources} to enable people to add screens to your application using
     * Reify, you may want to test your application with the MockDataSources to ensure they have the right data to allow your
     * application to function (for example, that records in one MockDataSource that are related to another MockDataSource
     * match up).  Similarly, you may want to test any custom classes that you upload to Reify in a standalone file using
     * {@link com.smartgwt.client.data.MockDataSource MockDataSources}. <P> You can customize the <code>settings</code>, such
     * as {@link com.smartgwt.client.util.MockDSExportSettings#getNumRows numRows} (or {@link
     * com.smartgwt.client.util.MockDSExportSettings#getNumLevels numLevels} for tree-DataSources) to keep the data volume
     * returned by the export low.  When related DataSources are present, all related records will be included in the export,
     * even if <code>numRows</code> is exceeded.  If this is too much data, {@link
     * com.smartgwt.client.util.MockDSExportSettings#getCriteria criteria} can be used to further restrict exported records. 
     * Note that <code>settings</code> supports an array of {@link
     * com.smartgwt.client.util.MockDSExportSettings#getRequestProperties requestProperties}, so that you can provide unique
     * configuration for each DataSource being exported, rather than only global configuration. <P> Unless you need
     * programmatic or expert control over the settings, you will likely find it easier to use the "Reify Export" button in the
     * {@link com.smartgwt.client.docs.DataSourcesTab DataSources tab}. as when using that route, useful global and
     * per-DataSources settings can be configured in an intuitively-arranged popup dialog.
     * @param dsNames {@link com.smartgwt.client.data.DataSource#getID ID}s of the desired                                          
     * DataSources
     * @param callback called with the complete export or serialization
     * @param settings controls format and what records and metadata to                                        include
     * @see com.smartgwt.client.tools.Reify#showMockDS
     */
    public static native void getMockDS(String[] dsNames, MockDSExportCallback callback, MockDSExportSettings settings) /*-{
        $wnd.isc.Reify.getMockDS(@com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(dsNames), 
			$entry( function(allDSData, perDSData) { 
				if(callback!=null) callback.@com.smartgwt.client.callbacks.MockDSExportCallback::execute(Ljava/lang/String;[Ljava/lang/String;)(
					allDSData, 
					perDSData != null ? @com.smartgwt.client.util.ConvertTo::arrayOfString(Lcom/google/gwt/core/client/JavaScriptObject;)(perDSData) : null
				);
			}), settings.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;


	/**
     * Loads projects from the Reify server specified by {@link com.smartgwt.client.tools.Reify#serverURL serverURL} (or {@link
     * com.smartgwt.client.rpc.LoadProjectSettings#getServerURL LoadProjectSettings.serverURL}) using the  {@link
     * com.smartgwt.client.docs.ServletDetails ProjectLoaderServlet}, reachable at the relative path {@link
     * com.smartgwt.client.tools.Reify#projectLoaderPath projectLoaderPath} (or {@link
     * com.smartgwt.client.rpc.LoadProjectSettings#getProjectLoaderPath LoadProjectSettings.projectLoaderPath}) underneath the
     * server URL, and fires the given callback after the project has been cached.  When a project is loaded, all of its
     * DataSources and screens (except where explicitly overridden by settings) are also cached in the project. <P> See {@link
     * com.smartgwt.client.rpc.RPCManager#loadProject RPCManager.loadProject()} for further details.
     * @param projectNames Comma-separated string containing the names of                                           project(s) to load.
     * @param callback Callback for notification of completion of                                           project(s) loaded and screens
     * cached.
     * @param settings Settings applicable to the loadProject                                           operation.
     */
    public static native void loadProject(String projectNames, LoadProjectCallback callback, LoadProjectSettings settings) /*-{
        $wnd.isc.Reify.loadProject(projectNames, 
			$entry( function(project, projects, rpcResponse) { 
				if(callback!=null) callback.@com.smartgwt.client.callbacks.LoadProjectCallback::execute(Lcom/smartgwt/client/rpc/Project;[Lcom/smartgwt/client/rpc/Project;Lcom/smartgwt/client/rpc/RPCResponse;)(
					project != null ? @com.smartgwt.client.rpc.Project::new(Lcom/google/gwt/core/client/JavaScriptObject;)(project) : null, 
					projects != null ? @com.smartgwt.client.util.ConvertTo::arrayOfProject(Lcom/google/gwt/core/client/JavaScriptObject;)(projects) : null, 
					@com.smartgwt.client.rpc.RPCResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(rpcResponse)
				);
			}), settings.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;


	/**
     * Setter for {@link com.smartgwt.client.tools.Reify#password password}.
     * @param password 
     */
    public static native void setPassword(String password) /*-{
        $wnd.isc.Reify.setPassword(password);
    }-*/;


	/**
     * Setter for {@link com.smartgwt.client.tools.Reify#projectLoaderPath projectLoaderPath}.
     * @param path 
     */
    public static native void setProjectLoaderPath(String path) /*-{
        $wnd.isc.Reify.setProjectLoaderPath(path);
    }-*/;


	/**
     * Setter for {@link com.smartgwt.client.tools.Reify#serverURL serverURL}.
     * @param serverURL .
     * See {@link com.smartgwt.client.docs.URL URL}
     * @see com.smartgwt.client.docs.URL URL
     */
    public static native void setServerURL(String serverURL) /*-{
        $wnd.isc.Reify.setServerURL(serverURL);
    }-*/;


	/**
     * Setter for {@link com.smartgwt.client.tools.Reify#userName userName}.
     * @param userName 
     */
    public static native void setUserName(String userName) /*-{
        $wnd.isc.Reify.setUserName(userName);
    }-*/;


	/**
     * Shows the result of running {@link com.smartgwt.client.tools.Reify#getMockDS getMockDS()} in a  modal window so it can
     * be copied and pasted as needed into {@link com.smartgwt.client.docs.ReifyForDevelopers Reify} or elsewhere. <P> Note
     * that the callback is fired when the window is closed, not when it's populated.
     * @param dsNames {@link com.smartgwt.client.data.DataSource#getID ID}s of the desired                                          
     * DataSources
     * @param callback called with the complete export or serialization
     * @param settings controls format and what records and metadata to                                        include
     */
    public static native void showMockDS(String[] dsNames, MockDSExportCallback callback, MockDSExportSettings settings) /*-{
        $wnd.isc.Reify.showMockDS(@com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(dsNames), 
			$entry( function(allDSData, perDSData) { 
				if(callback!=null) callback.@com.smartgwt.client.callbacks.MockDSExportCallback::execute(Ljava/lang/String;[Ljava/lang/String;)(
					allDSData, 
					perDSData != null ? @com.smartgwt.client.util.ConvertTo::arrayOfString(Lcom/google/gwt/core/client/JavaScriptObject;)(perDSData) : null
				);
			}), settings.@com.smartgwt.client.core.DataClass::getJsObj()());
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
     * @param reifyProperties properties that should be used as new defaults when instances of this class are created
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public static native void setDefaultProperties(Reify reifyProperties) /*-{
        if (reifyProperties.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Class;)(Reify.@java.lang.Object::getClass()(), "setDefaultProperties", reifyProperties.@java.lang.Object::getClass()());
        }
        reifyProperties.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
    	var properties = reifyProperties.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        properties = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(properties,true);
        $wnd.isc.Reify.addProperties(properties);
    }-*/;

    // ***********************************************************



    public JavaScriptObject getOrCreateJsObj() {
        String missing = this.requiredModulesMissing();
        if (missing != null) {
            SC.logWarn("ERROR: The following modules are required by Reify and " +
                       "must be loaded in your bootstrap HTML file: " + missing);
        return null;
        }
        return super.getOrCreateJsObj();
    }

    private native String requiredModulesMissing() /*-{
        var missing,
            required = {
                ComponentEditor: "ISC_Tools.js",
                AdminConsole: "ISC_AdminConsole.js",
                DocViewer: "ISC_DocViewer.js",
                FileLoader: "ISC_FileLoader.js",
                FileBrowser: "ISC_FileBrowser.js",
                Reify: "ISC_Reify.js"
            };
        
        for (var module in required) {
            if (!$wnd.isc[module]) {
                missing = missing ? missing + ", " + required[module] : required[module];
            }
        }
        return missing;
    }-*/;


    // ------------------------------------------
    // Handle Post-create customization callbacks

    protected void onInit() {
		super.onInit();

        // widget created; call hook
        afterCreateHook();        

        // handle autoDraw:true case
        if (isDrawn()) {
            afterDrawHook();
            return;
        }    

        // otherwise, hook later draw
        addDrawHandler(new DrawHandler() {
            public void onDraw(DrawEvent event) {
                ((Reify)event.getFiringCanvas()).afterDrawHook();
            }
        });
    }

    private native void afterCreateHook() /*-{
        if ($wnd.window.hookAfterVBCreate) {
            $wnd.window.hookAfterVBCreate();
        }
    }-*/;

    private native void afterDrawHook() /*-{
        if ($wnd.window.hookAfterVBDraw) {
            $wnd.window.hookAfterVBDraw();
        }
    }-*/;



    /**
     * Setter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject setLogicalStructure(ReifyLogicalStructure s) {
        super.setLogicalStructure(s);
        return s;
    }

    /**
     * Getter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject getLogicalStructure() {
        ReifyLogicalStructure s = new ReifyLogicalStructure();
        setLogicalStructure(s);
        return s;
    }
}
