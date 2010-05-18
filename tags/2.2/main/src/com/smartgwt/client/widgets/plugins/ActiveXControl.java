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
 * ISC Abstraction for ActiveX controls
 */
public class ActiveXControl extends BrowserPlugin {

    public static ActiveXControl getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        BaseWidget obj = BaseWidget.getRef(jsObj);
        if(obj != null) {
            return (ActiveXControl) obj;
        } else {
            return new ActiveXControl(jsObj);
        }
    }

    public ActiveXControl(){
        scClassName = "ActiveXControl";
    }

    public ActiveXControl(JavaScriptObject jsObj){
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
     * This sets the value of the classID property on the object.  This is meant to give you  complete control over the
     * generated HTML.  In practice it may be more handy to set the uuid  property on this object and let the classID be
     * generated from that.
     *
     * @param classID classID Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setClassID(String classID)  throws IllegalStateException {
        setAttribute("classID", classID, false);
    }

    /**
     * This sets the value of the classID property on the object.  This is meant to give you  complete control over the
     * generated HTML.  In practice it may be more handy to set the uuid  property on this object and let the classID be
     * generated from that.
     *
     *
     * @return String
     */
    public String getClassID()  {
        return getAttributeAsString("classID");
    }

    /**
     * Specifies the URL from which to load the ActiveX control.
     *
     * @param codeBase codeBase Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setCodeBase(String codeBase)  throws IllegalStateException {
        setAttribute("codeBase", codeBase, false);
    }

    /**
     * Specifies the URL from which to load the ActiveX control.
     *
     *
     * @return String
     */
    public String getCodeBase()  {
        return getAttributeAsString("codeBase");
    }

    /**
     * Sets the 'id' attribute on the object.  If a name is not provided it will be  auto-generated.  Note that in general you
     * don't need to set this.  If you have a reference to  your ISC ActiveX control object you can simply call  {@link
     * com.smartgwt.client.widgets.plugins.ActiveXControl#getPluginHandle ActiveXControl.getPluginHandle} to get a handle to
     * the element.
     *
     * @param id id Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setId(String id)  throws IllegalStateException {
        setAttribute("id", id, false);
    }

    /**
     * Sets the 'id' attribute on the object.  If a name is not provided it will be  auto-generated.  Note that in general you
     * don't need to set this.  If you have a reference to  your ISC ActiveX control object you can simply call  {@link
     * com.smartgwt.client.widgets.plugins.ActiveXControl#getPluginHandle ActiveXControl.getPluginHandle} to get a handle to
     * the element.
     *
     *
     * @return String
     */
    public String getId()  {
        return getAttributeAsString("id");
    }

    /**
     * Set this to the uuid of your Active X control - ISC will then generate the appropriate  classID entry for you.
     *
     * @param uuid uuid Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setUuid(String uuid)  throws IllegalStateException {
        setAttribute("uuid", uuid, false);
    }

    /**
     * Set this to the uuid of your Active X control - ISC will then generate the appropriate  classID entry for you.
     *
     *
     * @return String
     */
    public String getUuid()  {
        return getAttributeAsString("uuid");
    }

    // ********************* Methods ***********************
            
    /**
     * Returns the ID for this ISC ActiveX control object.  If the <code>id</code> property was specified for the object, that
     * will be used, otherwise   the ID will be auto-generated.
     */
    public native void getPluginID() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.getPluginID();
    }-*/;

    // ********************* Static Methods ***********************
    /**
     * Class level method to set the default properties of this class. If set, then all subsequent instances of this
     * class will automatically have the default properties that were set when this method was called. This is a powerful
     * feature that eliminates the need for users to create a separate hierarchy of subclasses that only alter the default
     * properties of this class. Can also be used for skinning / styling purposes. 
     *
     * @param activeXControlProperties properties that should be used as new defaults when instances of this class are created
     */
    public static native void setDefaultProperties(ActiveXControl activeXControlProperties) /*-{
        $wnd.isc.ActiveXControl.addProperties(activeXControlProperties.@com.smartgwt.client.widgets.BaseWidget::getConfig()());
    }-*/;
        
    // ***********************************************************        



    /**
     * A map of key/value pairs to pass to the Active X control as parameters.
     *
     * @param params Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setParams(Map params)  throws IllegalStateException {
         JavaScriptObject paramsJS = JSOHelper.convertMapToJavascriptObject(params);
         setAttribute("params", paramsJS, false);
    }

    /**
     * A map of key/value pairs to pass to the Active X control as parameters.
     *
     *
     * @return Map
     */
    public native Map getParams()  /*-{
    	var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var paramsJS = self.params;
        return paramsJS == null ? null : @com.smartgwt.client.util.JSOHelper::convertToMap(Lcom/google/gwt/core/client/JavaScriptObject;)(paramsJS);
        
    }-*/;
    
    /**
     * Returns a handle to the element for this ISC ActiveX control object.
     *
     * @return pointer to the plugin element in the DOM
     */
    public native Element getPluginHandle() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        return self.getPluginHandle();
    }-*/;
            

}



