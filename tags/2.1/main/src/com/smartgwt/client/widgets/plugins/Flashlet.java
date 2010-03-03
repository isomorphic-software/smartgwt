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
 
package com.smartgwt.client.widgets.plugins;



import com.smartgwt.client.event.*;
import com.smartgwt.client.core.*;
import com.smartgwt.client.types.*;
import com.smartgwt.client.data.*;
import com.smartgwt.client.data.events.*;
import com.smartgwt.client.rpc.*;
import com.smartgwt.client.widgets.*;
import com.smartgwt.client.widgets.events.*;
import com.smartgwt.client.widgets.form.*;
import com.smartgwt.client.widgets.form.validator.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.tile.*;
import com.smartgwt.client.widgets.tile.events.*;
import com.smartgwt.client.widgets.grid.*;
import com.smartgwt.client.widgets.grid.events.*;
import com.smartgwt.client.widgets.layout.*;
import com.smartgwt.client.widgets.menu.*;
import com.smartgwt.client.widgets.tab.*;
import com.smartgwt.client.widgets.toolbar.*;
import com.smartgwt.client.widgets.tree.*;
import com.smartgwt.client.widgets.tree.events.*;
import com.smartgwt.client.widgets.viewer.*;
import com.smartgwt.client.widgets.calendar.*;
import com.smartgwt.client.widgets.calendar.events.*;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;
import com.smartgwt.client.util.*;
import com.google.gwt.event.shared.*;
import com.google.gwt.event.shared.HasHandlers;

/**
 * ISC abstraction for Flashlets.
 */
public class Flashlet extends BrowserPlugin {

    public static Flashlet getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        BaseWidget obj = BaseWidget.getRef(jsObj);
        if(obj != null) {
            return (Flashlet) obj;
        } else {
            return new Flashlet(jsObj);
        }
    }

    public Flashlet(){
        scClassName = "Flashlet";
    }

    public Flashlet(JavaScriptObject jsObj){
        super(jsObj);
    }

    protected native JavaScriptObject create()/*-{
        var config = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
        var widget = $wnd.isc[scClassName].create(config);
        this.@com.smartgwt.client.widgets.BaseWidget::doInit()();
        return widget;
    }-*/;
    // ********************* Properties / Attributes ***********************

    /**
     * This attribute specifies the clsid of the outer &lt;object&gt; tag.  <p>  The default classID is:
     * "clsid:D27CDB6E-AE6D-11cf-96B8-444553540000"  <p>
     *
     * @param classID classID Default value is see below
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setClassID(String classID)  throws IllegalStateException {
        setAttribute("classID", classID, false);
    }

    /**
     * This attribute specifies the clsid of the outer &lt;object&gt; tag.  <p>  The default classID is:
     * "clsid:D27CDB6E-AE6D-11cf-96B8-444553540000"  <p>
     *
     *
     * @return String
     */
    public String getClassID()  {
        return getAttributeAsString("classID");
    }

    /**
     * This attribute specifies the minimum version of the flash player required to show this  flashlet.  <p>  The default
     * codeBase is: "http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=5,0,0,0"  <p>
     *
     * @param codeBase codeBase Default value is see below
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setCodeBase(String codeBase)  throws IllegalStateException {
        setAttribute("codeBase", codeBase, false);
    }

    /**
     * This attribute specifies the minimum version of the flash player required to show this  flashlet.  <p>  The default
     * codeBase is: "http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=5,0,0,0"  <p>
     *
     *
     * @return String
     */
    public String getCodeBase()  {
        return getAttributeAsString("codeBase");
    }

    /**
     * Sets the 'name' attribute on the flashlet object.  If a name is not provided it will be  auto-generated.  Note that in
     * general you don't need to set this.  If you have a handle to  your ISC Flashlet object you can simply call {@link
     * com.smartgwt.client.widgets.plugins.Flashlet#getPluginHandle} to get a  handle to the element.
     *
     * @param name name Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setName(String name)  throws IllegalStateException {
        setAttribute("name", name, false);
    }

    /**
     * Sets the 'name' attribute on the flashlet object.  If a name is not provided it will be  auto-generated.  Note that in
     * general you don't need to set this.  If you have a handle to  your ISC Flashlet object you can simply call {@link
     * com.smartgwt.client.widgets.plugins.Flashlet#getPluginHandle} to get a  handle to the element.
     *
     *
     * @return String
     */
    public String getName()  {
        return getAttributeAsString("name");
    }

    /**
     * This attribute specifies the page the user should go to to get the plugin required to view  this flashlet.  <p>  The
     * default pluginsPage is: "http://www.macromedia.com/shockwave/download/index.cgi?P1_Prod_Version=ShockwaveFlash"  <p>
     *
     * @param pluginsPage pluginsPage Default value is see below
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setPluginsPage(String pluginsPage)  throws IllegalStateException {
        setAttribute("pluginsPage", pluginsPage, false);
    }

    /**
     * This attribute specifies the page the user should go to to get the plugin required to view  this flashlet.  <p>  The
     * default pluginsPage is: "http://www.macromedia.com/shockwave/download/index.cgi?P1_Prod_Version=ShockwaveFlash"  <p>
     *
     *
     * @return String
     */
    public String getPluginsPage()  {
        return getAttributeAsString("pluginsPage");
    }

    /**
     * Location from which to load the Flashlet.
     * Sets the source file for the flash component
     *
     * @param src src Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setSrc(String src)  throws IllegalStateException {
        setAttribute("src", src, false);
    }

    /**
     * Location from which to load the Flashlet.
     *
     *
     * @return String
     */
    public String getSrc()  {
        return getAttributeAsString("src");
    }

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************
            
    /**
     * Is Shockwave flash installed on this browser?
     *
     * @return true if Flash is installed.
     */
    public static native Boolean flashAvailable() /*-{
        var retVal =$wnd.isc.Flashlet.flashAvailable();
        if(retVal == null || retVal === undefined) {
            return null;
        } else {
            return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
        }
    }-*/;
            
    /**
     * Which version of Flash is installed on this browser?
     *
     * @return flash version number, or null if flash is not installed
     */
    public static native int getFlashVersion() /*-{
        return $wnd.isc.Flashlet.getFlashVersion();
    }-*/;



    /**
     * A map of key/value pairs to pass to the flashlet as parameters.  Note that these will be set  on the outer
     * &lt;object&gt; element as well as the inner &lt;embed&gt; element.
     *
     * @param params params Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setParams(Map params)  throws IllegalStateException {
        JavaScriptObject paramsJS = JSOHelper.convertMapToJavascriptObject(params);
        setAttribute("params", paramsJS, false);
   }

    /**
     * A map of key/value pairs to pass to the flashlet as parameters.  Note that these will be set  on the outer
     * &lt;object&gt; element as well as the inner &lt;embed&gt; element.
     *
     *
     * @return params for this flashlet
     */
    public native Map getParams()  /*-{
		var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
	    var paramsJS = self.params;
	    return paramsJS == null ? null : @com.smartgwt.client.util.JSOHelper::convertToMap(Lcom/google/gwt/core/client/JavaScriptObject;)(paramsJS);
	    
	}-*/;
    
    /**
     * Returns a handle to the flashlet DOM element (valid only after the component has been drawn).
     *
     * @return pointer to the plugin element in the DOM
     */
    public native Element getPluginHandle() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        return self.getPluginHandle();
    }-*/;


}



