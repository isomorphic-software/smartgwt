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
 * This is the bundle of settings that can be passed to {@link com.smartgwt.client.rpc.RPCManager#loadScreen
 * RPCManager.loadScreen()} as the "settings" argument.  Some settings can also be passed as separate arguments; if these
 * are present both as separate arguments and in settings, loadScreen() will use the value from the settings. <P> There is
 * no need to instantiate a <code>LoadScreenSettings</code> instance.  Just pass a normal JavaScript object with the
 * desired properties.
 */
@BeanFactory.FrameworkClass
public class LoadScreenSettings extends DataClass {

    public static LoadScreenSettings getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        return new LoadScreenSettings(jsObj);
    }
        


    public LoadScreenSettings(){
        
    }

    public LoadScreenSettings(JavaScriptObject jsObj){
        
        setJavaScriptObject(jsObj);
    }


    // ********************* Properties / Attributes ***********************

    /**
     * Caches screen much like {@link com.smartgwt.client.rpc.RPCManager#cacheScreens RPCManager.cacheScreens()}, so {@link
     * com.smartgwt.client.rpc.RPCManager#isScreenCached RPCManager.isScreenCached()} reports true.
     *
     * @param cacheScreen New cacheScreen value. Default value is false
     * @return {@link com.smartgwt.client.rpc.LoadScreenSettings LoadScreenSettings} instance, for chaining setter calls
     */
    public LoadScreenSettings setCacheScreen(Boolean cacheScreen) {
        return (LoadScreenSettings)setAttribute("cacheScreen", cacheScreen);
    }

    /**
     * Caches screen much like {@link com.smartgwt.client.rpc.RPCManager#cacheScreens RPCManager.cacheScreens()}, so {@link
     * com.smartgwt.client.rpc.RPCManager#isScreenCached RPCManager.isScreenCached()} reports true.
     *
     * @return Current cacheScreen value. Default value is false
     */
    public Boolean getCacheScreen()  {
        Boolean result = getAttributeAsBoolean("cacheScreen", true);
        return result == null ? false : result;
    }
    

    /**
     * Should DataSources referenced by the screen clobber existing, globally-bound DataSources on the client when the screen
     * is loaded?  The default of false means that any DataSources defined in the screen will be discarded if they collide with
     * existing, globally-bound DataSources. <p> Note that here we consider a DataSource to be "globally bound" if it can be
     * retrieved by ID using the method {@link com.smartgwt.client.data.DataSource#get DataSource.get()}, regardless of whether
     * it's actually bound to the browser <code>window</code> object.
     *
     * @param clobberDataSources New clobberDataSources value. Default value is false
     * @return {@link com.smartgwt.client.rpc.LoadScreenSettings LoadScreenSettings} instance, for chaining setter calls
     */
    public LoadScreenSettings setClobberDataSources(Boolean clobberDataSources) {
        return (LoadScreenSettings)setAttribute("clobberDataSources", clobberDataSources);
    }

    /**
     * Should DataSources referenced by the screen clobber existing, globally-bound DataSources on the client when the screen
     * is loaded?  The default of false means that any DataSources defined in the screen will be discarded if they collide with
     * existing, globally-bound DataSources. <p> Note that here we consider a DataSource to be "globally bound" if it can be
     * retrieved by ID using the method {@link com.smartgwt.client.data.DataSource#get DataSource.get()}, regardless of whether
     * it's actually bound to the browser <code>window</code> object.
     *
     * @return Current clobberDataSources value. Default value is false
     */
    public Boolean getClobberDataSources()  {
        Boolean result = getAttributeAsBoolean("clobberDataSources", true);
        return result == null ? false : result;
    }
    

    /**
     * The name of a locale to use for resolving i18n tags in the component XML of the screen.
     *
     * @param locale New locale value. Default value is null
     * @return {@link com.smartgwt.client.rpc.LoadScreenSettings LoadScreenSettings} instance, for chaining setter calls
     */
    public LoadScreenSettings setLocale(String locale) {
        return (LoadScreenSettings)setAttribute("locale", locale);
    }

    /**
     * The name of a locale to use for resolving i18n tags in the component XML of the screen.
     *
     * @return Current locale value. Default value is null
     */
    public String getLocale()  {
        return getAttributeAsString("locale");
    }
    

    /**
     * If true, server logic does not crash out if it cannot load a DataSource specified in the screen definition.  Instead, a
     * stub DataSource is returned, which consists of nothing except the ID and an <code>unableToLoad</code> flag, which
     * client-side code can use to determine that the DataSource could not be loaded on the server.  Optional, defaults to
     * false (ie, a missing DataSource causes a crash by default)
     *
     * @param missingDSIsNotFatal New missingDSIsNotFatal value. Default value is null
     * @return {@link com.smartgwt.client.rpc.LoadScreenSettings LoadScreenSettings} instance, for chaining setter calls
     */
    public LoadScreenSettings setMissingDSIsNotFatal(Boolean missingDSIsNotFatal) {
        return (LoadScreenSettings)setAttribute("missingDSIsNotFatal", missingDSIsNotFatal);
    }

    /**
     * If true, server logic does not crash out if it cannot load a DataSource specified in the screen definition.  Instead, a
     * stub DataSource is returned, which consists of nothing except the ID and an <code>unableToLoad</code> flag, which
     * client-side code can use to determine that the DataSource could not be loaded on the server.  Optional, defaults to
     * false (ie, a missing DataSource causes a crash by default)
     *
     * @return Current missingDSIsNotFatal value. Default value is null
     */
    public Boolean getMissingDSIsNotFatal()  {
        return getAttributeAsBoolean("missingDSIsNotFatal", true);
    }
    

    /**
     * DataSource IDs in the screen to skip and not load when the screen is loaded.  It is assumed that these IDs represent
     * DataSources that are already globally-bound on the client. <P> The special value of "*" can be specified for this
     * property to indicate that <b>all</b> DataSources should be omitted. <P> Note that, unless {@link
     * com.smartgwt.client.rpc.LoadScreenSettings#getOmitLoadedDataSources omitLoadedDataSources} is false, all loaded
     * DataSources will by default be added to whatever value you provide (making that also the default for this property).
     *
     * @param omitDataSources New omitDataSources value. Default value is varies
     * @return {@link com.smartgwt.client.rpc.LoadScreenSettings LoadScreenSettings} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.Identifier Identifier 
     */
    public LoadScreenSettings setOmitDataSources(String... omitDataSources) {
        return (LoadScreenSettings)setAttribute("omitDataSources", omitDataSources);
    }

    /**
     * DataSource IDs in the screen to skip and not load when the screen is loaded.  It is assumed that these IDs represent
     * DataSources that are already globally-bound on the client. <P> The special value of "*" can be specified for this
     * property to indicate that <b>all</b> DataSources should be omitted. <P> Note that, unless {@link
     * com.smartgwt.client.rpc.LoadScreenSettings#getOmitLoadedDataSources omitLoadedDataSources} is false, all loaded
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
     * com.smartgwt.client.rpc.LoadScreenSettings#getOmitDataSources omitDataSources} in {@link
     * com.smartgwt.client.rpc.RPCManager#loadScreen RPCManager.loadScreen()}.  Setting this false would only make sense in
     * connection with setting {@link com.smartgwt.client.rpc.LoadScreenSettings#getClobberDataSources clobberDataSources}
     * true, and would create more potential work for the server since many more DataSources could be output. <P> Note that
     * here we consider the "loaded DataSources" to be those that are registered with the DataSource module (i.e. available by
     * ID via {@link com.smartgwt.client.data.DataSource#get DataSource.get()}), regardless of whether they're actually bound
     * to the browser <code>window</code> object.
     *
     * @param omitLoadedDataSources New omitLoadedDataSources value. Default value is true
     * @return {@link com.smartgwt.client.rpc.LoadScreenSettings LoadScreenSettings} instance, for chaining setter calls
     */
    public LoadScreenSettings setOmitLoadedDataSources(boolean omitLoadedDataSources) {
        return (LoadScreenSettings)setAttribute("omitLoadedDataSources", omitLoadedDataSources);
    }

    /**
     * Whether to implicitly add all DataSources currently loaded on the client to {@link
     * com.smartgwt.client.rpc.LoadScreenSettings#getOmitDataSources omitDataSources} in {@link
     * com.smartgwt.client.rpc.RPCManager#loadScreen RPCManager.loadScreen()}.  Setting this false would only make sense in
     * connection with setting {@link com.smartgwt.client.rpc.LoadScreenSettings#getClobberDataSources clobberDataSources}
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
     * Specifies optional {@link com.smartgwt.client.rpc.RPCRequest} properties for the request.
     *
     * @param requestProperties New requestProperties value. Default value is null
     * @return {@link com.smartgwt.client.rpc.LoadScreenSettings LoadScreenSettings} instance, for chaining setter calls
     */
    public LoadScreenSettings setRequestProperties(RPCRequest requestProperties) {
        JavaScriptObject config = JSOHelper.createObject();
        if (requestProperties != null) {
            JSOHelper.addProperties(config, requestProperties.getJsObj());
        }
        return (LoadScreenSettings)setAttribute("requestProperties", requestProperties == null ? null : config);
    }

    /**
     * Specifies optional {@link com.smartgwt.client.rpc.RPCRequest} properties for the request.
     *
     * @return Current requestProperties value. Default value is null
     */
    public RPCRequest getRequestProperties()  {
        return new RPCRequest(getAttributeAsJavaScriptObject("requestProperties"));
    }
    

    /**
     * If true, prevents any screen from being drawn when it's loaded, even if there's an explicit {@link
     * com.smartgwt.client.widgets.Canvas#getAutoDraw Canvas.autoDraw}:true setting on it.
     *
     * @param suppressAutoDraw New suppressAutoDraw value. Default value is true
     * @return {@link com.smartgwt.client.rpc.LoadScreenSettings LoadScreenSettings} instance, for chaining setter calls
     */
    public LoadScreenSettings setSuppressAutoDraw(Boolean suppressAutoDraw) {
        return (LoadScreenSettings)setAttribute("suppressAutoDraw", suppressAutoDraw);
    }

    /**
     * If true, prevents any screen from being drawn when it's loaded, even if there's an explicit {@link
     * com.smartgwt.client.widgets.Canvas#getAutoDraw Canvas.autoDraw}:true setting on it.
     *
     * @return Current suppressAutoDraw value. Default value is true
     */
    public Boolean getSuppressAutoDraw()  {
        Boolean result = getAttributeAsBoolean("suppressAutoDraw", true);
        return result == null ? true : result;
    }
    

    /**
     * Enable {@link com.smartgwt.client.rpc.RPCManager#verifyAsError verifyAsError} behavior only for requests using these
     * settings.
     *
     * @param verifyAsError New verifyAsError value. Default value is null
     * @return {@link com.smartgwt.client.rpc.LoadScreenSettings LoadScreenSettings} instance, for chaining setter calls
     * @see com.smartgwt.client.rpc.CreateScreenSettings#setVerifyAsError
     * @see com.smartgwt.client.rpc.LoadProjectSettings#setVerifyAsError
     */
    public LoadScreenSettings setVerifyAsError(Boolean verifyAsError) {
        return (LoadScreenSettings)setAttribute("verifyAsError", verifyAsError);
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
     * Enables verification that the created screen contains a component having a
     *  <code>localId</code> equal to the given key, and that it is an instance (or subclass)
     *  if the key's value.  Example:
     *  <pre>
     *    {customerListGrid: 'ListGrid'}
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
     *  Findings are always reported to the console, and may also be presented to the user
     *  with a warning dialog by setting {@link com.smartgwt.client.rpc.LoadScreenSettings#getVerifyAsError verifyAsError} or
     *  {@link com.smartgwt.client.rpc.RPCManager#verifyAsError verifyAsError}.
     *
     * @param verifyComponents New verifyComponents value. Default value is null
     * @return {@link com.smartgwt.client.rpc.LoadScreenSettings LoadScreenSettings} instance, for chaining setter calls
     * @see com.smartgwt.client.rpc.RPCManager#loadScreen
     */
    public LoadScreenSettings setVerifyComponents(Map<String,String> verifyComponents) {
        return (LoadScreenSettings)setAttribute("verifyComponents", verifyComponents);
    }

    /**
     * Enables verification that the created screen contains a component having a
     *  <code>localId</code> equal to the given key, and that it is an instance (or subclass)
     *  if the key's value.  Example:
     *  <pre>
     *    {customerListGrid: 'ListGrid'}
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
     *  Findings are always reported to the console, and may also be presented to the user
     *  with a warning dialog by setting {@link com.smartgwt.client.rpc.LoadScreenSettings#getVerifyAsError verifyAsError} or
     *  {@link com.smartgwt.client.rpc.RPCManager#verifyAsError verifyAsError}.
     *
     * @return Current verifyComponents value. Default value is null
     * @see com.smartgwt.client.rpc.RPCManager#loadScreen
     */
    public Map<String,String> getVerifyComponents()  {
        return getAttributeAsMap("verifyComponents");
    }
    

    /**
     * Whether to call the provided  callback even if an error was encountered trying to load the screen (or it was simply not
     * found), so that you can run your own error handling.  In this case, the screen and "suppressed globals" will be reported
     * as null. <P> Note that for backward compatibility, the default of null means that the callback will still happen if the
     * screen is not found, but not for a response with a server error. To have all such cases handled automatically, set this
     * property explicitly false.
     *
     * @param willHandleError New willHandleError value. Default value is null
     * @return {@link com.smartgwt.client.rpc.LoadScreenSettings LoadScreenSettings} instance, for chaining setter calls
     */
    public LoadScreenSettings setWillHandleError(Boolean willHandleError) {
        return (LoadScreenSettings)setAttribute("willHandleError", willHandleError);
    }

    /**
     * Whether to call the provided  callback even if an error was encountered trying to load the screen (or it was simply not
     * found), so that you can run your own error handling.  In this case, the screen and "suppressed globals" will be reported
     * as null. <P> Note that for backward compatibility, the default of null means that the callback will still happen if the
     * screen is not found, but not for a response with a server error. To have all such cases handled automatically, set this
     * property explicitly false.
     *
     * @return Current willHandleError value. Default value is null
     */
    public Boolean getWillHandleError()  {
        return getAttributeAsBoolean("willHandleError", true);
    }
    

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************

    // ***********************************************************

}
