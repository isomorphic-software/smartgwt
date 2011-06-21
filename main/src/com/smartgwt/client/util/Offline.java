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
 * The Offline class provides features for storing and retrieving values in persistent browser storage.  Because this
 * storage is both persistent (ie, it remains available after the  browser is closed and re-opened) and local to the
 * browser, it allows applications to operate when the client is not connected to a network, albeit with some obvious
 * limitations. <p> As well as providing straightforward APIs for storing, retrieving and removing values,  Offline support
 * is integrated into the normal request/response cycle.  You can configure  the framework so that server responses are
 * automatically cached in Offline storage.  Then, at some future point when the client is offline, responses for known
 * requests are returned  from the Offline cache. <p> Smart GWT makes use of various underlying storage techniques,
 * depending on what the  browser supports, but the API to a Smart GWT program is the same regardless of the  underlying
 * storage - simple key/value pairs.  Currently, we provide Offline support for all  HTML5-compliant browsers, plus earlier
 * versions of Internet Explorer (6 and 7).  The amount  of storage available is dictated by the browser, and varies from
 * approximately 500KB to  approximately 5MB.
 */
public class Offline {

    // ********************* Properties / Attributes ***********************

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************
            
    /**
     * Explicitly sets this session into offline mode.  This setting will override whatever  state the browser reports.  This
     * allows users to manually set an application into  offline or online state.
     */
    public static native void goOffline() /*-{
        $wnd.isc.Offline.goOffline();
    }-*/;
            
    /**
     * Explicitly sets this session into online mode.  This setting will override whatever  state the browser reports.  This
     * allows users to manually set an application into  offline or online state.
     */
    public static native void goOnline() /*-{
        $wnd.isc.Offline.goOnline();
    }-*/;
            
    /**
     * Returns true if the current browser session is offline (ie, not connected to a network). If an online/offline state has
     * been set explicitly (see {@link com.smartgwt.client.util.Offline#goOffline Offline.goOffline} and  {@link
     * com.smartgwt.client.util.Offline#goOnline Offline.goOnline}), the explicitly-set state will be returned.  Otherwise, the
     * offline state as reported by the browser will be returned.  See  {@link
     * com.smartgwt.client.util.Offline#useNativeOfflineDetection useNativeOfflineDetection} for important notes on  browser
     * detection of offline state.
     *
     * @return true if the current browser session is offline
     * @see com.smartgwt.client.util.Offline#goOffline
     * @see com.smartgwt.client.util.Offline#goOnline
     * @see com.smartgwt.client.util.Offline#useNativeOfflineDetection
     */
    public static native Boolean isOffline() /*-{
        var retVal =$wnd.isc.Offline.isOffline();
        if(retVal == null || retVal === undefined) {
            return null;
        } else {
            return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
        }
    }-*/;
            
    /**
     * Removes the key/value pair mapped by the passed-in key from browser-local storage
     * @param key The key to remove
     */
    public static native void remove(String key) /*-{
        $wnd.isc.Offline.remove(key);
    }-*/;
            
    /**
     * Tells the Offline system to query the browser for the current online/offline state. Calling this method switches off the
     * explicit offline mode setting switched on by  calling {@link com.smartgwt.client.util.Offline#goOnline Offline.goOnline}
     * or {@link com.smartgwt.client.util.Offline#goOffline Offline.goOffline}. <p> It is important to note that browsers vary
     * quite considerably in their ability to  detect that they are offline.  Many older browsers simply can't do it; HTML5
     * browsers expose the <code>navigator.onLine</code> property, but each browser's implementation  is different.  Some
     * browsers have a manual "Work Offline" mode which allows the user  to make the decision, and Smart GWT provides an
     * equivalent mechanism with the  <code>goOffline</code> and <code>goOnline</code> methods.  Generally speaking, these 
     * methods are more reliable than allowing the browser to decide whether your application is offline.
     */
    public static native void useNativeOfflineDetection() /*-{
        $wnd.isc.Offline.useNativeOfflineDetection();
    }-*/;
        
    // ***********************************************************        


    /**
     * Returns the value mapped to the passed-in key from browser-local storage, or null if  no such key exists.
     *
     * @param key The key to retrieve a value for
     * @return The value mapped to the passed in key, or null if no such key exists
     * @see com.smartgwt.client.util.Offline#put
     */
    public static native Object get(String key) /*-{
        var item = $wnd.isc.Offline.get(key);
        return item == null || item === undefined ? null : $wnd.SmartGWT.convertToJavaType(item);
    }-*/;

    /**
     * Stores the passed-in value in browser-local storage, mapped to the passed-in key.  If there is no room left to store the
     * value, we discard values from the offline store,  oldest first, until there is room to store the value.  If you don't
     * want this behavior, explicitly pass false in the <code>recycleEntries</code> parameter. <p> Note that limitations in the
     * underlying storage engines mean that only primitive  values - Strings, numbers and booleans - can be stored.  If you
     * wish to store an Array or Object, you will have to serialize it to JSON first, and then <code>eval</code> it  after
     * retrieval to turn it back into an object. <p> <b>Note:</b> This method throws an exception if it could not store the
     * value (either  because storage is full and recycleEntries was false, or because the value to store is simply too large)
     *
     * @param key   The key to use when storing the value
     * @param value The value to store
     */
    public static void put(String key, Object value) {
        put(key, value, true);
    }

    /**
     * Stores the passed-in value in browser-local storage, mapped to the passed-in key.  If there is no room left to store the
     * value, we discard values from the offline store,  oldest first, until there is room to store the value.  If you don't
     * want this behavior, explicitly pass false in the <code>recycleEntries</code> parameter. <p> Note that limitations in the
     * underlying storage engines mean that only primitive  values - Strings, numbers and booleans - can be stored.  If you
     * wish to store an Array or Object, you will have to serialize it to JSON first, and then <code>eval</code> it  after
     * retrieval to turn it back into an object. <p> <b>Note:</b> This method throws an exception if it could not store the
     * value (either  because storage is full and recycleEntries was false, or because the value to store is simply too large)
     *
     * @param key            The key to use when storing the value
     * @param value          The value to store
     * @param recycleEntries If false, suppresses the default behavior of repeatedly discarding the oldest entry if
     *                       there is insufficient space to store the value
     * @see com.smartgwt.client.util.Offline#get
     */
    public static void put(String key, Object value, boolean recycleEntries) {
        if (value == null || value instanceof String) {
            setValue(key, (String) value, recycleEntries);
        } else if (value instanceof Integer) {
            setValue(key, ((Integer) value).intValue(), recycleEntries);
        } else if (value instanceof Long) {
            //we officially do not support Long type, and GWT disallows passing long values to JSNI
            //casting to int, instead or erroring out, as it works in most cases
            setValue(key, ((Long) value).intValue(), recycleEntries);
        } else if (value instanceof Double) {
            setValue(key, ((Double) value).doubleValue(), recycleEntries);
        } else if (value instanceof Float) {
            setValue(key, ((Float) value).floatValue(), recycleEntries);
        } else if (value instanceof Boolean) {
            setValue(key, ((Boolean) value).booleanValue(), recycleEntries);
        } else if (value instanceof Date) {
            setValue(key, (Date) value, recycleEntries);
        } else {
            doSetValue(key, value, recycleEntries);
        }
    }

    private static native void doSetValue(String key, Object value, boolean recycleEntries) /*-{
        $wnd.isc.Offline.put(key, value, recycleEntries);
    }-*/;

    private static native void setValue(String key, String value, boolean recycleEntries) /*-{
        $wnd.isc.Offline.put(key, value, recycleEntries);
    }-*/;

    private static native void setValue(String key, int value, boolean recycleEntries) /*-{
        $wnd.isc.Offline.put(key, value, recycleEntries);
    }-*/;

    private static native void setValue(String key, float value, boolean recycleEntries) /*-{
        $wnd.isc.Offline.put(key, value, recycleEntries);
    }-*/;

    private static native void setValue(String key, double value, boolean recycleEntries) /*-{
        $wnd.isc.Offline.put(key, value, recycleEntries);
    }-*/;

    private static native void setValue(String key, boolean value, boolean recycleEntries) /*-{
        $wnd.isc.Offline.put(key, value, recycleEntries);
    }-*/;

    private static native void setValue(String key, Date value, boolean recycleEntries) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        var valueJS = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptDate(Ljava/util/Date;)(value);
        $wnd.isc.Offline.put(key, valueJS, recycleEntries);
    }-*/;

}




