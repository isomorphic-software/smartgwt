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
import com.smartgwt.client.widgets.chart.*;
import com.smartgwt.client.widgets.layout.*;
import com.smartgwt.client.widgets.layout.events.*;
import com.smartgwt.client.widgets.menu.*;
import com.smartgwt.client.widgets.tab.*;
import com.smartgwt.client.widgets.toolbar.*;
import com.smartgwt.client.widgets.tree.*;
import com.smartgwt.client.widgets.tree.events.*;
import com.smartgwt.client.widgets.viewer.*;
import com.smartgwt.client.widgets.calendar.*;
import com.smartgwt.client.widgets.calendar.events.*;
import com.smartgwt.client.widgets.cube.*;
import com.smartgwt.client.widgets.drawing.*;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashMap;

import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;
import com.smartgwt.client.util.*;
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
import com.smartgwt.logicalstructure.widgets.tab.*;
import com.smartgwt.logicalstructure.widgets.tableview.*;
import com.smartgwt.logicalstructure.widgets.toolbar.*;
import com.smartgwt.logicalstructure.widgets.tree.*;
import com.smartgwt.logicalstructure.widgets.viewer.*;
import com.smartgwt.logicalstructure.widgets.calendar.*;
import com.smartgwt.logicalstructure.widgets.cube.*;

/**
 * ISC abstraction for Flashlets.
 */
public class Flashlet extends BrowserPlugin {

    public native static Flashlet getOrCreateRef(JavaScriptObject jsObj) /*-{

    	if(jsObj == null) return null;
    	
    	var instance = jsObj["__ref"];
    	
    	if(instance==undefined) {
            return @com.smartgwt.client.util.ObjectFactory::createCanvas(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)("Flashlet",jsObj);
        } else if(instance != null) {
            return instance;
        //} else {
        //    return @com.smartgwt.client.widgets.plugins.Flashlet::new(Lcom/google/gwt/core/client/JavaScriptObject;)(jsObj);
        }
    }-*/;

    public void setJavaScriptObject(JavaScriptObject jsObj) {
        id = JSOHelper.getAttribute(jsObj, "ID");
    }


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
        this.@com.smartgwt.client.widgets.BaseWidget::doInit()();
        return widget;
    }-*/;
    // ********************* Properties / Attributes ***********************

    /**
     * This attribute specifies the clsid of the outer &lt;object&gt; tag.  <p>  The default classID is:
     * "clsid:D27CDB6E-AE6D-11cf-96B8-444553540000"  <p>
     *
     * @param classID . See {@link com.smartgwt.client.docs.String String}. Default value is see below
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
     * @return . See {@link com.smartgwt.client.docs.String String}
     */
    public String getClassID()  {
        return getAttributeAsString("classID");
    }

    /**
     * This attribute specifies the minimum version of the flash player required to show this  flashlet.  <p>  The default
     * codeBase is: "http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=5,0,0,0"  <p>
     *
     * @param codeBase . See {@link com.smartgwt.client.docs.String String}. Default value is see below
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
     * @return . See {@link com.smartgwt.client.docs.String String}
     */
    public String getCodeBase()  {
        return getAttributeAsString("codeBase");
    }

    /**
     * Sets the 'name' attribute on the flashlet object.  If a name is not provided it will be  auto-generated.  Note that in
     * general you don't need to set this.  If you have a handle to  your ISC Flashlet object you can simply call {@link
     * com.smartgwt.client.widgets.plugins.Flashlet#getPluginHandle Flashlet.getPluginHandle} to get a  handle to the element.
     *
     * @param name . See {@link com.smartgwt.client.docs.String String}. Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.plugins.Flashlet#getPluginHandle
     */
    public void setName(String name)  throws IllegalStateException {
        setAttribute("name", name, false);
    }

    /**
     * Sets the 'name' attribute on the flashlet object.  If a name is not provided it will be  auto-generated.  Note that in
     * general you don't need to set this.  If you have a handle to  your ISC Flashlet object you can simply call {@link
     * com.smartgwt.client.widgets.plugins.Flashlet#getPluginHandle Flashlet.getPluginHandle} to get a  handle to the element.
     *
     *
     * @return . See {@link com.smartgwt.client.docs.String String}
     * @see com.smartgwt.client.widgets.plugins.Flashlet#getPluginHandle
     */
    public String getName()  {
        return getAttributeAsString("name");
    }

    /**
     * This attribute specifies the page the user should go to to get the plugin required to view  this flashlet.  <p>  The
     * default pluginsPage is: "http://www.macromedia.com/shockwave/download/index.cgi?P1_Prod_Version=ShockwaveFlash"  <p>
     *
     * @param pluginsPage . See {@link com.smartgwt.client.docs.String String}. Default value is see below
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
     * @return . See {@link com.smartgwt.client.docs.String String}
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
     * @param src . See {@link com.smartgwt.client.docs.String String}. Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setSrc(String src)  throws IllegalStateException {
        setAttribute("src", src, false);
    }

    /**
     * Location from which to load the Flashlet.
     *
     *
     * @return . See {@link com.smartgwt.client.docs.String String}
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
     * Class level method to set the default properties of this class. If set, then all subsequent instances of this
     * class will automatically have the default properties that were set when this method was called. This is a powerful
     * feature that eliminates the need for users to create a separate hierarchy of subclasses that only alter the default
     * properties of this class. Can also be used for skinning / styling purposes.
     * <P>
     * <b>Note:</b> This method is intended for setting default attributes only and will effect all instances of the
     * underlying class (including those automatically generated in JavaScript). 
     * This method should not be used to apply standard EventHandlers or override methods for
     * a class - use a custom subclass instead.
     *
     * @param flashletProperties properties that should be used as new defaults when instances of this class are created
     */
    public static native void setDefaultProperties(Flashlet flashletProperties) /*-{
    	var properties = $wnd.isc.addProperties({},flashletProperties.@com.smartgwt.client.widgets.BaseWidget::getConfig()());
    	delete properties.ID;
        $wnd.isc.Flashlet.addProperties(properties);
    }-*/;
        
    // ***********************************************************        



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
    
    public LogicalStructureObject getLogicalStructure() {
        FlashletLogicalStructure s = new FlashletLogicalStructure();
        setLogicalStructure(s);
        return s;
    }
}

