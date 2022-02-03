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

import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;
import com.smartgwt.client.util.*;
import com.smartgwt.client.util.events.*;
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
 * An application that allows developers to create and manage Smart GWT screens and  datasources.  This is an <b>internal
 * only</b> class - do not try to use it directly  in your applications.  If you want to create visual tools similar to
 * VisualBuilder,  see {@link com.smartgwt.client.docs.DevTools the Dashboards & Tools framework overview}
 * @see com.smartgwt.client.docs.VisualBuilder VisualBuilder overview and related methods
 */
@BeanFactory.FrameworkClass
@BeanFactory.ScClassName("VisualBuilder")
public class VisualBuilder extends VLayout {

    public static VisualBuilder getOrCreateRef(JavaScriptObject jsObj) {
        if (jsObj == null) return null;
        final BaseWidget refInstance = BaseWidget.getRef(jsObj);
        if (refInstance == null) {
            return new VisualBuilder(jsObj);
        } else {
            assert refInstance instanceof VisualBuilder;
            return (VisualBuilder)refInstance;
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(VisualBuilder.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "Canvas");
        }
        defaults.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
        var cleanDefaultsJS = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(defaults.@com.smartgwt.client.widgets.BaseWidget::getConfig()(), true);
        $wnd.isc.VisualBuilder.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(VisualBuilder.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "FormItem");
        }
        defaults.@com.smartgwt.client.widgets.form.fields.FormItem::setConfigOnly(Z)(true);
    	var cleanDefaultsJS = defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getEditorTypeConfig()();
        $wnd.isc.VisualBuilder.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
    }-*/;

    public VisualBuilder(){
        scClassName = "VisualBuilder";
    }

    public VisualBuilder(JavaScriptObject jsObj){
        scClassName = "VisualBuilder";
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
     * Relative URL to Visual Builder's customComponents.xml configuration file. The  default value makes the framework look
     * wherever Visual Builder itself was loaded from
     *
     * @param customComponentsURL New customComponentsURL value. Default value is "customComponents.xml"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setCustomComponentsURL(String customComponentsURL)  throws IllegalStateException {
        setAttribute("customComponentsURL", customComponentsURL, false);
    }

    /**
     * Relative URL to Visual Builder's customComponents.xml configuration file. The  default value makes the framework look
     * wherever Visual Builder itself was loaded from
     *
     * @return Current customComponentsURL value. Default value is "customComponents.xml"
     */
    public String getCustomComponentsURL()  {
        return getAttributeAsString("customComponentsURL");
    }
    

    /**
     * The default application mode.  Note, this can be changed through the UI - see  {@link
     * com.smartgwt.client.tools.VisualBuilder#getShowModeSwitcher showModeSwitcher}
     *
     * @param defaultApplicationMode New defaultApplicationMode value. Default value is "edit"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setDefaultApplicationMode(ApplicationMode defaultApplicationMode)  throws IllegalStateException {
        setAttribute("defaultApplicationMode", defaultApplicationMode == null ? null : defaultApplicationMode.getValue(), false);
    }

    /**
     * The default application mode.  Note, this can be changed through the UI - see  {@link
     * com.smartgwt.client.tools.VisualBuilder#getShowModeSwitcher showModeSwitcher}
     *
     * @return Current defaultApplicationMode value. Default value is "edit"
     */
    public ApplicationMode getDefaultApplicationMode()  {
        return EnumUtil.getEnum(ApplicationMode.values(), getAttribute("defaultApplicationMode"));
    }
    

    /**
     * Relative URL to Visual Builder's defaultComponents.xml configuration file. The  default value makes the framework look
     * wherever Visual Builder itself was loaded from
     *
     * @param defaultComponentsURL New defaultComponentsURL value. Default value is "defaultComponents.xml"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setDefaultComponentsURL(String defaultComponentsURL)  throws IllegalStateException {
        setAttribute("defaultComponentsURL", defaultComponentsURL, false);
    }

    /**
     * Relative URL to Visual Builder's defaultComponents.xml configuration file. The  default value makes the framework look
     * wherever Visual Builder itself was loaded from
     *
     * @return Current defaultComponentsURL value. Default value is "defaultComponents.xml"
     */
    public String getDefaultComponentsURL()  {
        return getAttributeAsString("defaultComponentsURL");
    }
    

    /**
     * Relative URL to Visual Builder's defaultMockupComponents.xml configuration file. The  default value makes the framework
     * look wherever Visual Builder itself was loaded from
     *
     * @param defaultMockupComponentsURL New defaultMockupComponentsURL value. Default value is "defaultMockupComponents.xml"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setDefaultMockupComponentsURL(String defaultMockupComponentsURL)  throws IllegalStateException {
        setAttribute("defaultMockupComponentsURL", defaultMockupComponentsURL, false);
    }

    /**
     * Relative URL to Visual Builder's defaultMockupComponents.xml configuration file. The  default value makes the framework
     * look wherever Visual Builder itself was loaded from
     *
     * @return Current defaultMockupComponentsURL value. Default value is "defaultMockupComponents.xml"
     */
    public String getDefaultMockupComponentsURL()  {
        return getAttributeAsString("defaultMockupComponentsURL");
    }
    

    /**
     * If set to true, allows the built-in save file and load file operations to access the server filesystem.  Note, this also
     * requires appropriate server-side permission - your  <code>server.properties</code> file must specify 
     * <code>FilesystemDataSource.enabled: true</code>. <p> If this property is false, saving and loading (if enabled) will be
     * to and from local  {@link com.smartgwt.client.util.Offline offline storage}.
     *
     * @param filesystemDataSourceEnabled New filesystemDataSourceEnabled value. Default value is false
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.tools.VisualBuilder#setSaveFileBuiltinIsEnabled
     * @see com.smartgwt.client.tools.VisualBuilder#setLoadFileBuiltinIsEnabled
     */
    public void setFilesystemDataSourceEnabled(Boolean filesystemDataSourceEnabled)  throws IllegalStateException {
        setAttribute("filesystemDataSourceEnabled", filesystemDataSourceEnabled, false);
    }

    /**
     * If set to true, allows the built-in save file and load file operations to access the server filesystem.  Note, this also
     * requires appropriate server-side permission - your  <code>server.properties</code> file must specify 
     * <code>FilesystemDataSource.enabled: true</code>. <p> If this property is false, saving and loading (if enabled) will be
     * to and from local  {@link com.smartgwt.client.util.Offline offline storage}.
     *
     * @return Current filesystemDataSourceEnabled value. Default value is false
     * @see com.smartgwt.client.tools.VisualBuilder#getSaveFileBuiltinIsEnabled
     * @see com.smartgwt.client.tools.VisualBuilder#getLoadFileBuiltinIsEnabled
     */
    public Boolean getFilesystemDataSourceEnabled()  {
        Boolean result = getAttributeAsBoolean("filesystemDataSourceEnabled");
        return result == null ? false : result;
    }
    

    /**
     * Relative URL to Visual Builder's globalDependencies.xml configuration file. The  default value makes the framework look
     * wherever Visual Builder itself was loaded from
     *
     * @param globalDependenciesURL New globalDependenciesURL value. Default value is "globalDependencies.xml"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setGlobalDependenciesURL(String globalDependenciesURL)  throws IllegalStateException {
        setAttribute("globalDependenciesURL", globalDependenciesURL, false);
    }

    /**
     * Relative URL to Visual Builder's globalDependencies.xml configuration file. The  default value makes the framework look
     * wherever Visual Builder itself was loaded from
     *
     * @return Current globalDependenciesURL value. Default value is "globalDependencies.xml"
     */
    public String getGlobalDependenciesURL()  {
        return getAttributeAsString("globalDependenciesURL");
    }
    

    /**
     * A PaletteNode describing a component to add to an empty screen as an initial container.
     *
     * @param initialComponent New initialComponent value. Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setInitialComponent(PaletteNode initialComponent)  throws IllegalStateException {
        setAttribute("initialComponent", initialComponent == null ? null : initialComponent.getJsObj(), false);
    }

    /**
     * A PaletteNode describing a component to add to an empty screen as an initial container.
     *
     * @return Current initialComponent value. Default value is null
     */
    public PaletteNode getInitialComponent()  {
        return new PaletteNode(getAttributeAsJavaScriptObject("initialComponent"));
    }
    

    /**
     * If set to true the built-in load file mechanism is enabled, allowing you to load files from offline storage or the
     * server filesystem (if enabled)
     *
     * @param loadFileBuiltinIsEnabled New loadFileBuiltinIsEnabled value. Default value is false
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.tools.VisualBuilder#setFilesystemDataSourceEnabled
     */
    public void setLoadFileBuiltinIsEnabled(Boolean loadFileBuiltinIsEnabled)  throws IllegalStateException {
        setAttribute("loadFileBuiltinIsEnabled", loadFileBuiltinIsEnabled, false);
    }

    /**
     * If set to true the built-in load file mechanism is enabled, allowing you to load files from offline storage or the
     * server filesystem (if enabled)
     *
     * @return Current loadFileBuiltinIsEnabled value. Default value is false
     * @see com.smartgwt.client.tools.VisualBuilder#getFilesystemDataSourceEnabled
     */
    public Boolean getLoadFileBuiltinIsEnabled()  {
        Boolean result = getAttributeAsBoolean("loadFileBuiltinIsEnabled");
        return result == null ? false : result;
    }
    

    /**
     * If true, starts Visual Builder in mockup mode
     *
     * @param mockupMode New mockupMode value. Default value is false
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setMockupMode(Boolean mockupMode)  throws IllegalStateException {
        setAttribute("mockupMode", mockupMode, false);
    }

    /**
     * If true, starts Visual Builder in mockup mode
     *
     * @return Current mockupMode value. Default value is false
     */
    public Boolean getMockupMode()  {
        Boolean result = getAttributeAsBoolean("mockupMode");
        return result == null ? false : result;
    }
    

    /**
     * Whether to use the existing browser window or a new one when opening a Mockup Mode screen converted to standard
     * Component XML via "Go to Visual Builder".
     *
     * @param openFullBuilderSeparately New openFullBuilderSeparately value. Default value is true
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setOpenFullBuilderSeparately(boolean openFullBuilderSeparately)  throws IllegalStateException {
        setAttribute("openFullBuilderSeparately", openFullBuilderSeparately, false);
    }

    /**
     * Whether to use the existing browser window or a new one when opening a Mockup Mode screen converted to standard
     * Component XML via "Go to Visual Builder".
     *
     * @return Current openFullBuilderSeparately value. Default value is true
     */
    public boolean getOpenFullBuilderSeparately()  {
        Boolean result = getAttributeAsBoolean("openFullBuilderSeparately");
        return result == null ? true : result;
    }
    

    /**
     * If set to true the built-in save file mechanism is enabled, allowing you to save files to offline storage or the server
     * filesystem (if enabled)
     *
     * @param saveFileBuiltinIsEnabled New saveFileBuiltinIsEnabled value. Default value is false
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.tools.VisualBuilder#setFilesystemDataSourceEnabled
     */
    public void setSaveFileBuiltinIsEnabled(Boolean saveFileBuiltinIsEnabled)  throws IllegalStateException {
        setAttribute("saveFileBuiltinIsEnabled", saveFileBuiltinIsEnabled, false);
    }

    /**
     * If set to true the built-in save file mechanism is enabled, allowing you to save files to offline storage or the server
     * filesystem (if enabled)
     *
     * @return Current saveFileBuiltinIsEnabled value. Default value is false
     * @see com.smartgwt.client.tools.VisualBuilder#getFilesystemDataSourceEnabled
     */
    public Boolean getSaveFileBuiltinIsEnabled()  {
        Boolean result = getAttributeAsBoolean("saveFileBuiltinIsEnabled");
        return result == null ? false : result;
    }
    

    /**
     * If this property is not explicitly set to false, Visual Builder shows a UI to allow the  {@link
     * com.smartgwt.client.types.ApplicationMode application mode} to be toggled at runtime.
     *
     * @param showModeSwitcher New showModeSwitcher value. Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setShowModeSwitcher(Boolean showModeSwitcher)  throws IllegalStateException {
        setAttribute("showModeSwitcher", showModeSwitcher, false);
    }

    /**
     * If this property is not explicitly set to false, Visual Builder shows a UI to allow the  {@link
     * com.smartgwt.client.types.ApplicationMode application mode} to be toggled at runtime.
     *
     * @return Current showModeSwitcher value. Default value is null
     */
    public Boolean getShowModeSwitcher()  {
        return getAttributeAsBoolean("showModeSwitcher");
    }
    

    /**
     * The name of a skin to use.  Note that Visual Builder may use two skins - the skin specified here, for the elements of
     * the application you are building, and a high-contrast,  white-on-black "ToolSkin" for the elements of Visual Builder
     * itself.  When in "Toolskin"  mode (which is switchable at runtime through the UI), the <code>skin</code> property only
     * affects the skin used by the visual elements of the application you are building.
     *
     * @param skin New skin value. Default value is "Graphite"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setSkin(String skin)  throws IllegalStateException {
        setAttribute("skin", skin, false);
    }

    /**
     * The name of a skin to use.  Note that Visual Builder may use two skins - the skin specified here, for the elements of
     * the application you are building, and a high-contrast,  white-on-black "ToolSkin" for the elements of Visual Builder
     * itself.  When in "Toolskin"  mode (which is switchable at runtime through the UI), the <code>skin</code> property only
     * affects the skin used by the visual elements of the application you are building.
     *
     * @return Current skin value. Default value is "Graphite"
     */
    public String getSkin()  {
        return getAttributeAsString("skin");
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
     * @param visualBuilderProperties properties that should be used as new defaults when instances of this class are created
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public static native void setDefaultProperties(VisualBuilder visualBuilderProperties) /*-{
        if (visualBuilderProperties.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Class;)(VisualBuilder.@java.lang.Object::getClass()(), "setDefaultProperties", visualBuilderProperties.@java.lang.Object::getClass()());
        }
        visualBuilderProperties.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
    	var properties = visualBuilderProperties.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        properties = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(properties,true);
        $wnd.isc.VisualBuilder.addProperties(properties);
    }-*/;

    // ***********************************************************



    public JavaScriptObject getOrCreateJsObj() {
        String missing = this.requiredModulesMissing();
        if (missing != null) {
            SC.logWarn("ERROR: The following modules are required by VisualBuilder and " +
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
                DSBrowser: "ISC_DSBrowser.js",
                DocViewer: "ISC_DocViewer.js",
                FileLoader: "ISC_FileLoader.js",
                FileBrowser: "ISC_FileBrowser.js",
                VisualBuilder: "ISC_VisualBuilder.js"
            };
        
        for (var module in required) {
            if (!$wnd.isc[module]) {
                missing = missing ? missing + ", " + required[module] : required[module];
            }
        }
        return missing;
    }-*/;
    

    /**
     * Setter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject setLogicalStructure(VisualBuilderLogicalStructure s) {
        super.setLogicalStructure(s);
        try {
            s.customComponentsURL = getAttributeAsString("customComponentsURL");
        } catch (Throwable t) {
            s.logicalStructureErrors += "VisualBuilder.customComponentsURL:" + t.getMessage() + "\n";
        }
        try {
            s.defaultApplicationMode = getAttributeAsString("defaultApplicationMode");
        } catch (Throwable t) {
            s.logicalStructureErrors += "VisualBuilder.defaultApplicationMode:" + t.getMessage() + "\n";
        }
        try {
            s.defaultComponentsURL = getAttributeAsString("defaultComponentsURL");
        } catch (Throwable t) {
            s.logicalStructureErrors += "VisualBuilder.defaultComponentsURL:" + t.getMessage() + "\n";
        }
        try {
            s.defaultMockupComponentsURL = getAttributeAsString("defaultMockupComponentsURL");
        } catch (Throwable t) {
            s.logicalStructureErrors += "VisualBuilder.defaultMockupComponentsURL:" + t.getMessage() + "\n";
        }
        try {
            s.filesystemDataSourceEnabled = getAttributeAsString("filesystemDataSourceEnabled");
        } catch (Throwable t) {
            s.logicalStructureErrors += "VisualBuilder.filesystemDataSourceEnabled:" + t.getMessage() + "\n";
        }
        try {
            s.globalDependenciesURL = getAttributeAsString("globalDependenciesURL");
        } catch (Throwable t) {
            s.logicalStructureErrors += "VisualBuilder.globalDependenciesURL:" + t.getMessage() + "\n";
        }
        try {
            s.initialComponent = getInitialComponent();
        } catch (Throwable t) {
            s.logicalStructureErrors += "VisualBuilder.initialComponent:" + t.getMessage() + "\n";
        }
        try {
            s.loadFileBuiltinIsEnabled = getAttributeAsString("loadFileBuiltinIsEnabled");
        } catch (Throwable t) {
            s.logicalStructureErrors += "VisualBuilder.loadFileBuiltinIsEnabled:" + t.getMessage() + "\n";
        }
        try {
            s.mockupMode = getAttributeAsString("mockupMode");
        } catch (Throwable t) {
            s.logicalStructureErrors += "VisualBuilder.mockupMode:" + t.getMessage() + "\n";
        }
        try {
            s.openFullBuilderSeparately = getAttributeAsString("openFullBuilderSeparately");
        } catch (Throwable t) {
            s.logicalStructureErrors += "VisualBuilder.openFullBuilderSeparately:" + t.getMessage() + "\n";
        }
        try {
            s.saveFileBuiltinIsEnabled = getAttributeAsString("saveFileBuiltinIsEnabled");
        } catch (Throwable t) {
            s.logicalStructureErrors += "VisualBuilder.saveFileBuiltinIsEnabled:" + t.getMessage() + "\n";
        }
        try {
            s.showModeSwitcher = getAttributeAsString("showModeSwitcher");
        } catch (Throwable t) {
            s.logicalStructureErrors += "VisualBuilder.showModeSwitcher:" + t.getMessage() + "\n";
        }
        try {
            s.skin = getAttributeAsString("skin");
        } catch (Throwable t) {
            s.logicalStructureErrors += "VisualBuilder.skin:" + t.getMessage() + "\n";
        }
        return s;
    }

    /**
     * Getter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject getLogicalStructure() {
        VisualBuilderLogicalStructure s = new VisualBuilderLogicalStructure();
        setLogicalStructure(s);
        return s;
    }
}
