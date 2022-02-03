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


/**
 * LoadProjectSettings is the bundle of settings that can be passed to loadProject() as the "settings" argument, including
 * optional http parameters for the request to  {@link com.smartgwt.client.docs.ServletDetails ProjectLoaderServlet}. <P>
 * There is no need to instatiate an LoadProjectSettings instance.  Just pass a normal JavaScript object with the desired
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
     * The name of the screen within the project to draw after loading.   A null value means to use the currentScreenName as
     * specified in the project file of the first project specified in the projectNames argument to {@link
     * com.smartgwt.client.rpc.RPCManager#loadProject RPCManager.loadProject()}.
     *
     * @param currentScreenName New currentScreenName value. Default value is null
     * @return {@link com.smartgwt.client.rpc.LoadProjectSettings LoadProjectSettings} instance, for chaining setter calls
     */
    public LoadProjectSettings setCurrentScreenName(String currentScreenName) {
        return (LoadProjectSettings)setAttribute("currentScreenName", currentScreenName);
    }

    /**
     * The name of the screen within the project to draw after loading.   A null value means to use the currentScreenName as
     * specified in the project file of the first project specified in the projectNames argument to {@link
     * com.smartgwt.client.rpc.RPCManager#loadProject RPCManager.loadProject()}.
     *
     * @return Current currentScreenName value. Default value is null
     */
    public String getCurrentScreenName()  {
        return getAttributeAsString("currentScreenName");
    }
    

    /**
     * Determines whether the {@link com.smartgwt.client.rpc.LoadProjectSettings#getCurrentScreenName currentScreenName} screen
     * is drawn after all screens have been loaded.
     *
     * @param drawFirstScreen New drawFirstScreen value. Default value is true
     * @return {@link com.smartgwt.client.rpc.LoadProjectSettings LoadProjectSettings} instance, for chaining setter calls
     */
    public LoadProjectSettings setDrawFirstScreen(boolean drawFirstScreen) {
        return (LoadProjectSettings)setAttribute("drawFirstScreen", drawFirstScreen);
    }

    /**
     * Determines whether the {@link com.smartgwt.client.rpc.LoadProjectSettings#getCurrentScreenName currentScreenName} screen
     * is drawn after all screens have been loaded.
     *
     * @return Current drawFirstScreen value. Default value is true
     */
    public boolean getDrawFirstScreen()  {
        Boolean result = getAttributeAsBoolean("drawFirstScreen", true);
        return result == null ? true : result;
    }
    

    /**
     * The name of a locale to use for resolving i18n tags in the component XML of the screen.  The default value of null omits
     * locale loading, which effectively means the framework default "en" locale is used.
     *
     * @param locale New locale value. Default value is null
     * @return {@link com.smartgwt.client.rpc.LoadProjectSettings LoadProjectSettings} instance, for chaining setter calls
     */
    public LoadProjectSettings setLocale(String locale) {
        return (LoadProjectSettings)setAttribute("locale", locale);
    }

    /**
     * The name of a locale to use for resolving i18n tags in the component XML of the screen.  The default value of null omits
     * locale loading, which effectively means the framework default "en" locale is used.
     *
     * @return Current locale value. Default value is null
     */
    public String getLocale()  {
        return getAttributeAsString("locale");
    }
    

    /**
     * Use this attribute to specify a project owner.  Only applicable if project source supports owner identification.
     *
     * @param ownerId New ownerId value. Default value is null
     * @return {@link com.smartgwt.client.rpc.LoadProjectSettings LoadProjectSettings} instance, for chaining setter calls
     */
    public LoadProjectSettings setOwnerId(String ownerId) {
        return (LoadProjectSettings)setAttribute("ownerId", ownerId);
    }

    /**
     * Use this attribute to specify a project owner.  Only applicable if project source supports owner identification.
     *
     * @return Current ownerId value. Default value is null
     */
    public String getOwnerId()  {
        return getAttributeAsString("ownerId");
    }
    

    /**
     * A comma-separated string containing the names of screens within the project that should be loaded.   A null value causes
     * all screens to be loaded.
     *
     * @param screenNames New screenNames value. Default value is null
     * @return {@link com.smartgwt.client.rpc.LoadProjectSettings LoadProjectSettings} instance, for chaining setter calls
     */
    public LoadProjectSettings setScreenNames(String screenNames) {
        return (LoadProjectSettings)setAttribute("screenNames", screenNames);
    }

    /**
     * A comma-separated string containing the names of screens within the project that should be loaded.   A null value causes
     * all screens to be loaded.
     *
     * @return Current screenNames value. Default value is null
     */
    public String getScreenNames()  {
        return getAttributeAsString("screenNames");
    }
    

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************

    // ***********************************************************

}
