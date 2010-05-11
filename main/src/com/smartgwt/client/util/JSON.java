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
 
package com.smartgwt.client.util;



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
 * Utilities for working with JSON data.
 */
public class JSON {

    // ********************* Properties / Attributes ***********************

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************


    /**
     * Serialize an object as a JSON string. <P> Automatically handles circular references - see {@link
     * com.smartgwt.client.util.JSONEncoder#getCircularReferenceMode circularReferenceMode}.
     * @param object object to serialize
     *
     * @return object encoded as a JSON String
     */
    public static native String encode(JavaScriptObject object) /*-{
        return $wnd.isc.JSON.encode(object);
    }-*/;

    /**
     * Serialize an object as a JSON string. <P> Automatically handles circular references - see {@link
     * com.smartgwt.client.util.JSONEncoder#getCircularReferenceMode circularReferenceMode}.
     * @param object object to serialize
     * @param settings optional settings for encoding
     *
     * @return object encoded as a JSON String
     */
    public static native String encode(JavaScriptObject object, JSONEncoder settings) /*-{
        return $wnd.isc.JSON.encode(object, settings.@com.smartgwt.client.util.JSONEncoder::getJsObj()());
    }-*/;

    /**
     * De-serialize an object from JSON.  Currently, this is simply a JavaScript eval() and should be used for trusted data
     * only.
     * @param jsonString JSON data to be de-serialized
     *
     * @return object derived from JSON String
     */
    public static native JavaScriptObject decode(String jsonString) /*-{
        return $wnd.isc.JSON.decode(jsonString);
    }-*/;

}



