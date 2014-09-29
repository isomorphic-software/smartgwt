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

public class JsObject {
    
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

    public final void setJavaScriptObject(JavaScriptObject jsObj) {
        setJsObj(jsObj);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof JsObject)) return false;
        final JsObject other = (JsObject)obj;
        if (jsObj == null) return this == other;
        return jsObj.equals(other.jsObj);
    }

    @Override
    public int hashCode() {
        return (jsObj == null ? 0 : jsObj.hashCode());
    }

    /**
     * Simple Exception class for the sole purpose of having SmartClient logs being
     * also logged to the GWT Development Console as an ERROR log in red rather
     * than an INFO log which does not stand out as a warning.
     */
    private static class SGWT_WARN extends Exception {
        public SGWT_WARN(String message) {
            super(message);
        }
    }
}
