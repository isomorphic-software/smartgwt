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
 
package com.smartgwt.client.data;



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
 * A DataSource preconfigured to use the {@link com.smartgwt.client.types.RPCTransport} transport&#010 for cross-domain
 * calls to JSON services, such as those provided by Yahoo!.  &#010 <P>&#010 To use this DataSource, provide the URL of the
 * service as {@link com.smartgwt.client.data.DataSource#getDataURL dataURL}, and&#010 provide {@link
 * com.smartgwt.client.data.DataSource#getFields 'fields'} that describe the structure of the data you want to&#010 extract
 * from the service's response.&#010 <P>&#010 {@link com.smartgwt.client.data.DataSource#getRecordXPath recordXPath} and
 * {@link com.smartgwt.client.data.DataSourceField#getValueXPath valueXPath} can be used to extract&#010 data from the JSON
 * structure returned by the service.  See&#010 {@link com.smartgwt.client.docs.ClientDataIntegration 'Client-Side Data
 * Integration'} for an overview of how to&#010 control what parts of the JSON structure are included in the {@link
 * com.smartgwt.client.data.DSResponse} object, and&#010 hence provided to {@link
 * com.smartgwt.client.widgets.DataBoundComponent}s that are bound to this DataSource.&#010 <P>&#010 This XJSONDataSource
 * is really a subclass of DataSource with just a few property settings:&#010 <pre>&#010    dataFormat : "json",&#010   
 * dataTransport : "scriptInclude"&#010    callbackParam : "callback"&#010 </pre>&#010 <P>&#010 If you are also writing the
 * server side code to respond to requests from this DataSource,&#010 see the &#010 <a
 * href='http://developer.yahoo.net/common/json.html#callbackparam'
 * onclick="window.open('http://developer.yahoo.net/common/json.html#callbackparam');return false;">tutorial provided by
 * Yahoo!</a> &#010 for a good overview of how this transport mechanism works.  Note, as indicated in the&#010 tutorial
 * above, the server is responsible for writing out not just the data, but also a&#010 JavaScript function call that tells
 * the client that the response has arrived.  The client&#010 passes the name of the function to call as the "callback" URL
 * parameter.&#010 <P>&#010 NOTE: if you use this DataSource to contact Yahoo web services, remember to include&#010
 * output=json in the dataURL, as well as a&#010 <a href='http://developer.yahoo.net/'
 * onclick="window.open('http://developer.yahoo.net/');return false;">Yahoo developer ID</a>.
 */
public class XJSONDataSource extends DataSource {

    public static XJSONDataSource getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        BaseClass obj = BaseClass.getRef(jsObj);
        if(obj != null) {
            return (XJSONDataSource) obj;
        } else {
            return new XJSONDataSource(jsObj);
        }
    }

    public XJSONDataSource(){
        scClassName = "XJSONDataSource";
    }

    public XJSONDataSource(JavaScriptObject jsObj){
        super(jsObj);
    }

    public native JavaScriptObject create()/*-{
        var config = this.@com.smartgwt.client.core.BaseClass::getConfig()();
        var scClassName = this.@com.smartgwt.client.core.BaseClass::scClassName;
        return $wnd.isc[scClassName].create(config);
    }-*/;
    // ********************* Properties / Attributes ***********************

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************

}




