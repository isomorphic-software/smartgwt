/*
 * SmartGWT (GWT for SmartClient)
 * Copyright 2008 and beyond, Isomorphic Software, Inc.
 *
 * SmartGWT is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License version 3
 * as published by the Free Software Foundation.  SmartGWT is also
 * available under typical commercial license terms - see
 * http://smartclient.com/license
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 */

package com.smartgwt.client.core;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.GWT;
import com.smartgwt.client.util.LogUtil;
import com.smartgwt.client.util.I18nUtil;

public class JsObject {

    static {
        LogUtil.setJSNIErrorHandler();
        init();
        I18nUtil.init();
    }

    private static native void init() /*-{

        //allow lazy loading of grids to work in hosted mode
        if(!@com.google.gwt.core.client.GWT::isScript()()){
            $wnd.Array.LOADING = new Object();
        }

        //handle OSX hosted mode
        if($wnd.isc.Browser.isSafari && @com.google.gwt.core.client.GWT::isScript()) {
            $wnd.isc.Browser.safariVersion = 525;
        }

        //convert javascript data types into corresponding Java wrapper types
        //int -> Integer, float -> Float, boolean -> Boolean and date - > java.util.Date
        $wnd.SmartGWT ={};
        $wnd.SmartGWT.convertToJavaType = function(obj) {
                if(obj == null || obj === undefined) return null;
                var objType = typeof obj;
                if(objType == 'string') {
                    return obj;
                } else if (objType == 'number') {
                    if(obj.toString().indexOf('.') == -1) {
                        if(obj <= @java.lang.Integer::MAX_VALUE) {
                            return @com.smartgwt.client.util.JSOHelper::toInteger(I)(obj);
                        } else {
                          return @com.smartgwt.client.util.JSOHelper::toLong(D)(obj);
                        }
                    } else {
                        if(obj <= @java.lang.Float::MAX_VALUE) {
                            return @com.smartgwt.client.util.JSOHelper::toFloat(F)(obj);
                        } else {
                            return @com.smartgwt.client.util.JSOHelper::toDouble(D)(obj);
                        }
                    }
                } else if(objType == 'boolean') {
                    return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(obj);
                } else if($wnd.isA.Date(obj)) {
                    return @com.smartgwt.client.util.JSOHelper::toDate(D)(obj.getTime());
                } else if(@com.smartgwt.client.util.JSOHelper::isJSO(Ljava/lang/Object;)(obj)) {
                    return obj;
                } else {
                    throw 'Unrecognized type ' + (objType) + ' for value ' + obj.toString();
                }
        };
    }-*/;

    protected JavaScriptObject jsObj;

    protected JsObject() {
    }

    public JsObject(JavaScriptObject jsObj) {
        this.jsObj = jsObj;
    }

    protected boolean isCreated() {
        return jsObj != null;
    }

    public JavaScriptObject getJsObj() {
        return jsObj;
    }

    public void setJsObj(JavaScriptObject jsObj) {
        this.jsObj = jsObj;
    }
}
