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
 
package com.smartgwt.client.rpc;


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


/**
 * LoadProjectSettings is the bundle of settings that can be passed to loadProject() as the "settings" argument, including
 * optional http parameters for the request to  {@link com.smartgwt.client.docs.ServletDetails ProjectLoaderServlet}. <P>
 * There is no need to instantiate an LoadProjectSettings instance.  Just pass a normal JavaScript object with the desired
 * properties.
 */
@BeanFactory.FrameworkClass
public class LoadProjectSettings extends DataClass {

    public static LoadProjectSettings getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        return new LoadProjectSettings(jsObj);
    }
        


    public LoadProjectSettings(){
        
    }

    public LoadProjectSettings(JavaScriptObject jsObj){
        
        setJavaScriptObject(jsObj);
    }


    // ********************* Properties / Attributes ***********************

    /**
     * Should  Placeholders in loaded screens be rendered as placeholders? If property is not set actual components are created
     * instead of the Placeholders.
     *
     * @param allowPlaceholders New allowPlaceholders value. Default value is null
     * @return {@link com.smartgwt.client.rpc.LoadProjectSettings LoadProjectSettings} instance, for chaining setter calls
     */
    public LoadProjectSettings setAllowPlaceholders(Boolean allowPlaceholders) {
        return (LoadProjectSettings)setAttribute("allowPlaceholders", allowPlaceholders);
    }

    /**
     * Should  Placeholders in loaded screens be rendered as placeholders? If property is not set actual components are created
     * instead of the Placeholders.
     *
     * @return Current allowPlaceholders value. Default value is null
     */
    public Boolean getAllowPlaceholders()  {
        return getAttributeAsBoolean("allowPlaceholders", true);
    }
    

    /**
     * Should DataSources referenced by the {@link com.smartgwt.client.rpc.LoadProjectSettings#getDrawFirstScreen first screen}
     * clobber existing, globally-bound DataSources on the client if the screen is created?  The default of false means that
     * any DataSources defined in the screen will be discarded if they collide with existing, globally-bound DataSources. <p>
     * Here we consider a DataSource to be "globally bound" if it can be retrieved by ID using the method {@link
     * com.smartgwt.client.data.DataSource#get DataSource.get()}, regardless of whether it's actually bound to the browser
     * <code>window</code> object. <P> Note that this setting only has an impact if {@link
     * com.smartgwt.client.rpc.LoadProjectSettings#getDrawFirstScreen drawFirstScreen} is true.
     *
     * @param clobberDataSources New clobberDataSources value. Default value is false
     * @return {@link com.smartgwt.client.rpc.LoadProjectSettings LoadProjectSettings} instance, for chaining setter calls
     */
    public LoadProjectSettings setClobberDataSources(Boolean clobberDataSources) {
        return (LoadProjectSettings)setAttribute("clobberDataSources", clobberDataSources);
    }

    /**
     * Should DataSources referenced by the {@link com.smartgwt.client.rpc.LoadProjectSettings#getDrawFirstScreen first screen}
     * clobber existing, globally-bound DataSources on the client if the screen is created?  The default of false means that
     * any DataSources defined in the screen will be discarded if they collide with existing, globally-bound DataSources. <p>
     * Here we consider a DataSource to be "globally bound" if it can be retrieved by ID using the method {@link
     * com.smartgwt.client.data.DataSource#get DataSource.get()}, regardless of whether it's actually bound to the browser
     * <code>window</code> object. <P> Note that this setting only has an impact if {@link
     * com.smartgwt.client.rpc.LoadProjectSettings#getDrawFirstScreen drawFirstScreen} is true.
     *
     * @return Current clobberDataSources value. Default value is false
     */
    public Boolean getClobberDataSources()  {
        Boolean result = getAttributeAsBoolean("clobberDataSources", true);
        return result == null ? false : result;
    }
    

    /**
     * The name of the screen within the project to return first when loading.   A null value means to use the
     * currentScreenName as specified in the project file. <p> This setting only affects the first project specified in the
     * <code>projectNames</code> argument to {@link com.smartgwt.client.rpc.RPCManager#loadProject RPCManager.loadProject()}.
     *
     * @param currentScreenName New currentScreenName value. Default value is null
     * @return {@link com.smartgwt.client.rpc.LoadProjectSettings LoadProjectSettings} instance, for chaining setter calls
     */
    public LoadProjectSettings setCurrentScreenName(String currentScreenName) {
        return (LoadProjectSettings)setAttribute("currentScreenName", currentScreenName);
    }

    /**
     * The name of the screen within the project to return first when loading.   A null value means to use the
     * currentScreenName as specified in the project file. <p> This setting only affects the first project specified in the
     * <code>projectNames</code> argument to {@link com.smartgwt.client.rpc.RPCManager#loadProject RPCManager.loadProject()}.
     *
     * @return Current currentScreenName value. Default value is null
     */
    public String getCurrentScreenName()  {
        return getAttributeAsString("currentScreenName");
    }
    

    /**
     * {@link com.smartgwt.client.widgets.DataContext} that will be provided to the top-level component as {@link
     * com.smartgwt.client.widgets.Canvas#getDataContext dataContext} in each screen cached for the project. <P> To understand
     * how <code>dataContext</code> is used to automatically populate  {@link com.smartgwt.client.widgets.DataBoundComponent
     * DataBoundComponents}, see {@link com.smartgwt.client.widgets.Canvas#getAutoPopulateData Canvas.autoPopulateData}.
     *
     * @param dataContext New dataContext value. Default value is null
     * @return {@link com.smartgwt.client.rpc.LoadProjectSettings LoadProjectSettings} instance, for chaining setter calls
     */
    public LoadProjectSettings setDataContext(DataContext dataContext) {
        return (LoadProjectSettings)setAttribute("dataContext", dataContext == null ? null : dataContext.getJsObj());
    }

    /**
     * {@link com.smartgwt.client.widgets.DataContext} that will be provided to the top-level component as {@link
     * com.smartgwt.client.widgets.Canvas#getDataContext dataContext} in each screen cached for the project. <P> To understand
     * how <code>dataContext</code> is used to automatically populate  {@link com.smartgwt.client.widgets.DataBoundComponent
     * DataBoundComponents}, see {@link com.smartgwt.client.widgets.Canvas#getAutoPopulateData Canvas.autoPopulateData}.
     *
     * @return Current dataContext value. Default value is null
     */
    public DataContext getDataContext()  {
        return new DataContext(getAttributeAsJavaScriptObject("dataContext"));
    }
    

    /**
     * Determines whether the {@link com.smartgwt.client.rpc.LoadProjectSettings#getCurrentScreenName currentScreenName} screen
     * is drawn after all screens have been loaded.  If not drawn, the screen will not be created. <p> This setting only
     * affects the first project specified in the <code>projectNames</code> argument to {@link
     * com.smartgwt.client.rpc.RPCManager#loadProject RPCManager.loadProject()}.
     *
     * @param drawFirstScreen New drawFirstScreen value. Default value is false
     * @return {@link com.smartgwt.client.rpc.LoadProjectSettings LoadProjectSettings} instance, for chaining setter calls
     * @see com.smartgwt.client.rpc.Project#createScreen
     * @see com.smartgwt.client.rpc.RPCManager#createScreen
     */
    public LoadProjectSettings setDrawFirstScreen(boolean drawFirstScreen) {
        return (LoadProjectSettings)setAttribute("drawFirstScreen", drawFirstScreen);
    }

    /**
     * Determines whether the {@link com.smartgwt.client.rpc.LoadProjectSettings#getCurrentScreenName currentScreenName} screen
     * is drawn after all screens have been loaded.  If not drawn, the screen will not be created. <p> This setting only
     * affects the first project specified in the <code>projectNames</code> argument to {@link
     * com.smartgwt.client.rpc.RPCManager#loadProject RPCManager.loadProject()}.
     *
     * @return Current drawFirstScreen value. Default value is false
     * @see com.smartgwt.client.rpc.Project#createScreen
     * @see com.smartgwt.client.rpc.RPCManager#createScreen
     */
    public boolean getDrawFirstScreen()  {
        Boolean result = getAttributeAsBoolean("drawFirstScreen", true);
        return result == null ? false : result;
    }
    

    /**
     * The name of a locale to use for resolving i18n tags in the component XML of the screen. The default value of null omits
     * locale loading, which effectively means the framework default "en" locale is used.
     *
     * @param locale New locale value. Default value is null
     * @return {@link com.smartgwt.client.rpc.LoadProjectSettings LoadProjectSettings} instance, for chaining setter calls
     */
    public LoadProjectSettings setLocale(String locale) {
        return (LoadProjectSettings)setAttribute("locale", locale);
    }

    /**
     * The name of a locale to use for resolving i18n tags in the component XML of the screen. The default value of null omits
     * locale loading, which effectively means the framework default "en" locale is used.
     *
     * @return Current locale value. Default value is null
     */
    public String getLocale()  {
        return getAttributeAsString("locale");
    }
    

    /**
     * DataSource IDs in the project to skip and not load when the project is loaded.  It is assumed that these IDs represent
     * DataSources that are already globally-bound on the client. <P> The special value of "*" can be specified for this
     * property to indicate that <b>all</b> DataSources should be omitted. <P> Note that, unless {@link
     * com.smartgwt.client.rpc.LoadProjectSettings#getOmitLoadedDataSources omitLoadedDataSources} is false, all loaded
     * DataSources will by default be added to whatever value you provide (making that also the default for this property).
     *
     * @param omitDataSources New omitDataSources value. Default value is varies
     * @return {@link com.smartgwt.client.rpc.LoadProjectSettings LoadProjectSettings} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.Identifier Identifier 
     */
    public LoadProjectSettings setOmitDataSources(String... omitDataSources) {
        return (LoadProjectSettings)setAttribute("omitDataSources", omitDataSources);
    }

    /**
     * DataSource IDs in the project to skip and not load when the project is loaded.  It is assumed that these IDs represent
     * DataSources that are already globally-bound on the client. <P> The special value of "*" can be specified for this
     * property to indicate that <b>all</b> DataSources should be omitted. <P> Note that, unless {@link
     * com.smartgwt.client.rpc.LoadProjectSettings#getOmitLoadedDataSources omitLoadedDataSources} is false, all loaded
     * DataSources will by default be added to whatever value you provide (making that also the default for this property).
     *
     * @return Current omitDataSources value. Default value is varies
     * @see com.smartgwt.client.docs.Identifier Identifier 
     */
    public String[] getOmitDataSources()  {
        return com.smartgwt.client.util.ConvertTo.arrayOfString(getAttributeAsJavaScriptObject("omitDataSources"));
    }
    

    /**
     * Whether to implicitly add all DataSources currently loaded on the client to {@link
     * com.smartgwt.client.rpc.LoadProjectSettings#getOmitDataSources omitDataSources} in {@link
     * com.smartgwt.client.rpc.RPCManager#loadProject RPCManager.loadProject()}.  Setting this false would only make sense in
     * connection with setting {@link com.smartgwt.client.rpc.LoadProjectSettings#getClobberDataSources clobberDataSources}
     * true, and would create more potential work for the server since many more DataSources could be output. <P> Note that
     * here we consider the "loaded DataSources" to be those that are registered with the DataSource module (i.e. available by
     * ID via {@link com.smartgwt.client.data.DataSource#get DataSource.get()}), regardless of whether they're actually bound
     * to the browser <code>window</code> object.
     *
     * @param omitLoadedDataSources New omitLoadedDataSources value. Default value is true
     * @return {@link com.smartgwt.client.rpc.LoadProjectSettings LoadProjectSettings} instance, for chaining setter calls
     */
    public LoadProjectSettings setOmitLoadedDataSources(boolean omitLoadedDataSources) {
        return (LoadProjectSettings)setAttribute("omitLoadedDataSources", omitLoadedDataSources);
    }

    /**
     * Whether to implicitly add all DataSources currently loaded on the client to {@link
     * com.smartgwt.client.rpc.LoadProjectSettings#getOmitDataSources omitDataSources} in {@link
     * com.smartgwt.client.rpc.RPCManager#loadProject RPCManager.loadProject()}.  Setting this false would only make sense in
     * connection with setting {@link com.smartgwt.client.rpc.LoadProjectSettings#getClobberDataSources clobberDataSources}
     * true, and would create more potential work for the server since many more DataSources could be output. <P> Note that
     * here we consider the "loaded DataSources" to be those that are registered with the DataSource module (i.e. available by
     * ID via {@link com.smartgwt.client.data.DataSource#get DataSource.get()}), regardless of whether they're actually bound
     * to the browser <code>window</code> object.
     *
     * @return Current omitLoadedDataSources value. Default value is true
     */
    public boolean getOmitLoadedDataSources()  {
        Boolean result = getAttributeAsBoolean("omitLoadedDataSources", true);
        return result == null ? true : result;
    }
    

    /**
     * Use this attribute to specify a project owner. Only applicable if project source supports owner identification.
     *
     * @param ownerId New ownerId value. Default value is null
     * @return {@link com.smartgwt.client.rpc.LoadProjectSettings LoadProjectSettings} instance, for chaining setter calls
     */
    public LoadProjectSettings setOwnerId(String ownerId) {
        return (LoadProjectSettings)setAttribute("ownerId", ownerId);
    }

    /**
     * Use this attribute to specify a project owner. Only applicable if project source supports owner identification.
     *
     * @return Current ownerId value. Default value is null
     */
    public String getOwnerId()  {
        return getAttributeAsString("ownerId");
    }
    

    /**
     * Overrides {@link com.smartgwt.client.tools.Reify#password password} setting the account password for {@link
     * com.smartgwt.client.tools.Reify#loadProject Reify.loadProject()}. <P> Note that this setting only applies when using
     * {@link com.smartgwt.client.tools.Reify#loadProject Reify.loadProject()}.
     *
     * @param password New password value. Default value is varies
     * @return {@link com.smartgwt.client.rpc.LoadProjectSettings LoadProjectSettings} instance, for chaining setter calls
     */
    public LoadProjectSettings setPassword(String password) {
        return (LoadProjectSettings)setAttribute("password", password);
    }

    /**
     * Overrides {@link com.smartgwt.client.tools.Reify#password password} setting the account password for {@link
     * com.smartgwt.client.tools.Reify#loadProject Reify.loadProject()}. <P> Note that this setting only applies when using
     * {@link com.smartgwt.client.tools.Reify#loadProject Reify.loadProject()}.
     *
     * @return Current password value. Default value is varies
     */
    public String getPassword()  {
        return getAttributeAsString("password");
    }
    

    /**
     * Path relative to the {@link com.smartgwt.client.rpc.LoadProjectSettings#getServerURL server root}, to target to use the
     * project loader servlet, instead of {@link com.smartgwt.client.tools.Reify#projectLoaderPath projectLoaderPath}. <P> Note
     * that this setting only applies when using {@link com.smartgwt.client.tools.Reify#loadProject Reify.loadProject()}.
     *
     * @param projectLoaderPath New projectLoaderPath value. Default value is varies
     * @return {@link com.smartgwt.client.rpc.LoadProjectSettings LoadProjectSettings} instance, for chaining setter calls
     */
    public LoadProjectSettings setProjectLoaderPath(String projectLoaderPath) {
        return (LoadProjectSettings)setAttribute("projectLoaderPath", projectLoaderPath);
    }

    /**
     * Path relative to the {@link com.smartgwt.client.rpc.LoadProjectSettings#getServerURL server root}, to target to use the
     * project loader servlet, instead of {@link com.smartgwt.client.tools.Reify#projectLoaderPath projectLoaderPath}. <P> Note
     * that this setting only applies when using {@link com.smartgwt.client.tools.Reify#loadProject Reify.loadProject()}.
     *
     * @return Current projectLoaderPath value. Default value is varies
     */
    public String getProjectLoaderPath()  {
        return getAttributeAsString("projectLoaderPath");
    }
    

    /**
     * Allows customizing the projectLoader servlet request properties.  Properties that conflict with proper operation of the
     * servlet will be overridden by {@link com.smartgwt.client.rpc.RPCManager#loadProject RPCManager.loadProject()}.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param requestProperties New requestProperties value. Default value is null
     * @return {@link com.smartgwt.client.rpc.LoadProjectSettings LoadProjectSettings} instance, for chaining setter calls
     */
    public LoadProjectSettings setRequestProperties(RPCRequest requestProperties) {
        JavaScriptObject config = JSOHelper.createObject();
        if (requestProperties != null) {
            JSOHelper.addProperties(config, requestProperties.getJsObj());
        }
        return (LoadProjectSettings)setAttribute("requestProperties", requestProperties == null ? null : config);
    }

    /**
     * Allows customizing the projectLoader servlet request properties.  Properties that conflict with proper operation of the
     * servlet will be overridden by {@link com.smartgwt.client.rpc.RPCManager#loadProject RPCManager.loadProject()}.
     *
     * @return Current requestProperties value. Default value is null
     */
    public RPCRequest getRequestProperties()  {
        return new RPCRequest(getAttributeAsJavaScriptObject("requestProperties"));
    }
    

    /**
     * A comma-separated string containing the names of screens within the project that should be loaded.  A null value causes
     * all screens to be loaded. <p> This setting only affects the first project specified in the <code>projectNames</code>
     * argument to {@link com.smartgwt.client.rpc.RPCManager#loadProject RPCManager.loadProject()}.
     *
     * @param screenNames New screenNames value. Default value is null
     * @return {@link com.smartgwt.client.rpc.LoadProjectSettings LoadProjectSettings} instance, for chaining setter calls
     */
    public LoadProjectSettings setScreenNames(String screenNames) {
        return (LoadProjectSettings)setAttribute("screenNames", screenNames);
    }

    /**
     * A comma-separated string containing the names of screens within the project that should be loaded.  A null value causes
     * all screens to be loaded. <p> This setting only affects the first project specified in the <code>projectNames</code>
     * argument to {@link com.smartgwt.client.rpc.RPCManager#loadProject RPCManager.loadProject()}.
     *
     * @return Current screenNames value. Default value is null
     */
    public String getScreenNames()  {
        return getAttributeAsString("screenNames");
    }
    

    /**
     * URL of Reify server to use when calling {@link com.smartgwt.client.tools.Reify#loadProject Reify.loadProject()} instead
     * of {@link com.smartgwt.client.tools.Reify#serverURL serverURL}. <P> Note that this setting only applies when using
     * {@link com.smartgwt.client.tools.Reify#loadProject Reify.loadProject()}.
     *
     * @param serverURL New serverURL value. Default value is varies
     * @return {@link com.smartgwt.client.rpc.LoadProjectSettings LoadProjectSettings} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.URL URL 
     */
    public LoadProjectSettings setServerURL(String serverURL) {
        return (LoadProjectSettings)setAttribute("serverURL", serverURL);
    }

    /**
     * URL of Reify server to use when calling {@link com.smartgwt.client.tools.Reify#loadProject Reify.loadProject()} instead
     * of {@link com.smartgwt.client.tools.Reify#serverURL serverURL}. <P> Note that this setting only applies when using
     * {@link com.smartgwt.client.tools.Reify#loadProject Reify.loadProject()}.
     *
     * @return Current serverURL value. Default value is varies
     * @see com.smartgwt.client.docs.URL URL 
     */
    public String getServerURL()  {
        return getAttributeAsString("serverURL");
    }
    

    /**
     * Sets the timeout for the projectLoader servlet request.  This is a convenience property so that {@link
     * com.smartgwt.client.rpc.LoadProjectSettings#getRequestProperties requestProperties} need not be set.  If unset, the
     * timeout is determined by {@link com.smartgwt.client.rpc.RPCManager#defaultTimeout defaultTimeout}.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param timeout New timeout value. Default value is null
     * @return {@link com.smartgwt.client.rpc.LoadProjectSettings LoadProjectSettings} instance, for chaining setter calls
     */
    public LoadProjectSettings setTimeout(Integer timeout) {
        return (LoadProjectSettings)setAttribute("timeout", timeout);
    }

    /**
     * Sets the timeout for the projectLoader servlet request.  This is a convenience property so that {@link
     * com.smartgwt.client.rpc.LoadProjectSettings#getRequestProperties requestProperties} need not be set.  If unset, the
     * timeout is determined by {@link com.smartgwt.client.rpc.RPCManager#defaultTimeout defaultTimeout}.
     *
     * @return Current timeout value. Default value is null
     */
    public Integer getTimeout()  {
        return getAttributeAsInt("timeout");
    }
    

    /**
     * Overrides {@link com.smartgwt.client.tools.Reify#userName userName} setting the account name for {@link
     * com.smartgwt.client.tools.Reify#loadProject Reify.loadProject()}. <P> Note that this setting only applies when using
     * {@link com.smartgwt.client.tools.Reify#loadProject Reify.loadProject()}.
     *
     * @param userName New userName value. Default value is varies
     * @return {@link com.smartgwt.client.rpc.LoadProjectSettings LoadProjectSettings} instance, for chaining setter calls
     */
    public LoadProjectSettings setUserName(String userName) {
        return (LoadProjectSettings)setAttribute("userName", userName);
    }

    /**
     * Overrides {@link com.smartgwt.client.tools.Reify#userName userName} setting the account name for {@link
     * com.smartgwt.client.tools.Reify#loadProject Reify.loadProject()}. <P> Note that this setting only applies when using
     * {@link com.smartgwt.client.tools.Reify#loadProject Reify.loadProject()}.
     *
     * @return Current userName value. Default value is varies
     */
    public String getUserName()  {
        return getAttributeAsString("userName");
    }
    

    /**
     * Enable {@link com.smartgwt.client.rpc.RPCManager#verifyAsError verifyAsError} behavior only for requests using these
     * settings.
     *
     * @param verifyAsError New verifyAsError value. Default value is null
     * @return {@link com.smartgwt.client.rpc.LoadProjectSettings LoadProjectSettings} instance, for chaining setter calls
     * @see com.smartgwt.client.rpc.CreateScreenSettings#setVerifyAsError
     * @see com.smartgwt.client.rpc.LoadProjectSettings#setVerifyAsError
     */
    public LoadProjectSettings setVerifyAsError(Boolean verifyAsError) {
        return (LoadProjectSettings)setAttribute("verifyAsError", verifyAsError);
    }

    /**
     * Enable {@link com.smartgwt.client.rpc.RPCManager#verifyAsError verifyAsError} behavior only for requests using these
     * settings.
     *
     * @return Current verifyAsError value. Default value is null
     * @see com.smartgwt.client.rpc.CreateScreenSettings#getVerifyAsError
     * @see com.smartgwt.client.rpc.LoadProjectSettings#getVerifyAsError
     */
    public Boolean getVerifyAsError()  {
        return getAttributeAsBoolean("verifyAsError", true);
    }
    

    /**
     * Enables verification that any screen {@link com.smartgwt.client.rpc.LoadProjectSettings#getDrawFirstScreen created}
     *  on load contains a component having a <code>localId</code> equal to the given key,
     *  and that it is an instance (or subclass) of the key's value.  Example:
     *  <pre>
     *    {'customerListGrid': 'ListGrid'}
     *  </pre>
     *  You may verify the presence of Tabs, SectionStackSections, and FormItems by
     *  providing their names following the parent component's id in dot-separated notation.
     *  Example:
     *  <pre>
     *    {
     *      'mainTabSet.customersTab': 'ImgTab',
     *      'mainSectionStack.customerStackSection': 'SectionStackSection',
     *      'customerDetailsForm.customerNameItem': 'TextItem'
     *    }
     *  </pre>
     *  Findings are always reported
     *  to the console, and may also be presented to the user with a warning dialog by setting
     * {@link com.smartgwt.client.rpc.LoadProjectSettings#getVerifyAsError verifyAsError} or {@link
     * com.smartgwt.client.rpc.RPCManager#verifyAsError verifyAsError}.
     *
     * @param verifyComponents New verifyComponents value. Default value is null
     * @return {@link com.smartgwt.client.rpc.LoadProjectSettings LoadProjectSettings} instance, for chaining setter calls
     * @see com.smartgwt.client.rpc.LoadProjectSettings#setVerifyDataSources
     * @see com.smartgwt.client.rpc.RPCManager#loadProject
     */
    public LoadProjectSettings setVerifyComponents(Map<String,String> verifyComponents) {
        return (LoadProjectSettings)setAttribute("verifyComponents", verifyComponents);
    }

    /**
     * Enables verification that any screen {@link com.smartgwt.client.rpc.LoadProjectSettings#getDrawFirstScreen created}
     *  on load contains a component having a <code>localId</code> equal to the given key,
     *  and that it is an instance (or subclass) of the key's value.  Example:
     *  <pre>
     *    {'customerListGrid': 'ListGrid'}
     *  </pre>
     *  You may verify the presence of Tabs, SectionStackSections, and FormItems by
     *  providing their names following the parent component's id in dot-separated notation.
     *  Example:
     *  <pre>
     *    {
     *      'mainTabSet.customersTab': 'ImgTab',
     *      'mainSectionStack.customerStackSection': 'SectionStackSection',
     *      'customerDetailsForm.customerNameItem': 'TextItem'
     *    }
     *  </pre>
     *  Findings are always reported
     *  to the console, and may also be presented to the user with a warning dialog by setting
     * {@link com.smartgwt.client.rpc.LoadProjectSettings#getVerifyAsError verifyAsError} or {@link
     * com.smartgwt.client.rpc.RPCManager#verifyAsError verifyAsError}.
     *
     * @return Current verifyComponents value. Default value is null
     * @see com.smartgwt.client.rpc.LoadProjectSettings#getVerifyDataSources
     * @see com.smartgwt.client.rpc.RPCManager#loadProject
     */
    public Map<String,String> getVerifyComponents()  {
        return getAttributeAsMap("verifyComponents");
    }
    

    /**
     * Enables DataSource verification, causing warnings to be output about differences between DataSources loaded with a
     * project vs those that are already present in the page (if any are present).  Findings are always reported to the
     * console, and may also be presented to the user with a warning dialog by setting {@link
     * com.smartgwt.client.rpc.LoadProjectSettings#getVerifyAsError verifyAsError}.  For discussion of which issues will be
     * reported and how, see {@link com.smartgwt.client.data.DataSource#verifyDataSourcePair
     * DataSource.verifyDataSourcePair()}. <P> Setting this property will default {@link
     * com.smartgwt.client.rpc.LoadProjectSettings#getOmitLoadedDataSources omitLoadedDataSources} to false, and will cause the
     * special {@link com.smartgwt.client.rpc.LoadProjectSettings#getOmitDataSources omitDataSources} value of "*" to be
     * ignored (but not other ID values). It's important to keep in mind when using this property that loading a project with
     * all of its DataSources can be very slow, if there is a large amount of test data, for example. <P> Note that this
     * behavior can be enabled globally by setting {@link com.smartgwt.client.tools.Reify#verifyDataSources verifyDataSources}
     * to true.  It often makes sense to set it there during development, and turn off in production, since it slightly slows
     * down DataSource loading.
     *
     * @param verifyDataSources New verifyDataSources value. Default value is null
     * @return {@link com.smartgwt.client.rpc.LoadProjectSettings LoadProjectSettings} instance, for chaining setter calls
     * @see com.smartgwt.client.rpc.LoadProjectSettings#setVerifyComponents
     * @see com.smartgwt.client.rpc.RPCManager#loadProject
     */
    public LoadProjectSettings setVerifyDataSources(Boolean verifyDataSources) {
        return (LoadProjectSettings)setAttribute("verifyDataSources", verifyDataSources);
    }

    /**
     * Enables DataSource verification, causing warnings to be output about differences between DataSources loaded with a
     * project vs those that are already present in the page (if any are present).  Findings are always reported to the
     * console, and may also be presented to the user with a warning dialog by setting {@link
     * com.smartgwt.client.rpc.LoadProjectSettings#getVerifyAsError verifyAsError}.  For discussion of which issues will be
     * reported and how, see {@link com.smartgwt.client.data.DataSource#verifyDataSourcePair
     * DataSource.verifyDataSourcePair()}. <P> Setting this property will default {@link
     * com.smartgwt.client.rpc.LoadProjectSettings#getOmitLoadedDataSources omitLoadedDataSources} to false, and will cause the
     * special {@link com.smartgwt.client.rpc.LoadProjectSettings#getOmitDataSources omitDataSources} value of "*" to be
     * ignored (but not other ID values). It's important to keep in mind when using this property that loading a project with
     * all of its DataSources can be very slow, if there is a large amount of test data, for example. <P> Note that this
     * behavior can be enabled globally by setting {@link com.smartgwt.client.tools.Reify#verifyDataSources verifyDataSources}
     * to true.  It often makes sense to set it there during development, and turn off in production, since it slightly slows
     * down DataSource loading.
     *
     * @return Current verifyDataSources value. Default value is null
     * @see com.smartgwt.client.rpc.LoadProjectSettings#getVerifyComponents
     * @see com.smartgwt.client.rpc.RPCManager#loadProject
     */
    public Boolean getVerifyDataSources()  {
        return getAttributeAsBoolean("verifyDataSources", true);
    }
    

    /**
     * Whether to call the provided  callback even if an error was encountered trying to load the project, so that you can run
     * your own error handling.  In this case, the list of projects loaded by the callback will be reported as empty. <P> If
     * true, the framework won't log any messages specifically reporting the failure to load the requested projects, but
     * depending on the situation, the browser itself may report errors from the servlet request in the console.
     *
     * @param willHandleError New willHandleError value. Default value is false
     * @return {@link com.smartgwt.client.rpc.LoadProjectSettings LoadProjectSettings} instance, for chaining setter calls
     * @see com.smartgwt.client.rpc.RPCManager#getLoadProjectErrorStatus
     * @see com.smartgwt.client.rpc.RPCManager#getLoadProjectErrorMessage
     */
    public LoadProjectSettings setWillHandleError(boolean willHandleError) {
        return (LoadProjectSettings)setAttribute("willHandleError", willHandleError);
    }

    /**
     * Whether to call the provided  callback even if an error was encountered trying to load the project, so that you can run
     * your own error handling.  In this case, the list of projects loaded by the callback will be reported as empty. <P> If
     * true, the framework won't log any messages specifically reporting the failure to load the requested projects, but
     * depending on the situation, the browser itself may report errors from the servlet request in the console.
     *
     * @return Current willHandleError value. Default value is false
     * @see com.smartgwt.client.rpc.RPCManager#getLoadProjectErrorStatus
     * @see com.smartgwt.client.rpc.RPCManager#getLoadProjectErrorMessage
     */
    public boolean getWillHandleError()  {
        Boolean result = getAttributeAsBoolean("willHandleError", true);
        return result == null ? false : result;
    }
    

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************

    // ***********************************************************

}
