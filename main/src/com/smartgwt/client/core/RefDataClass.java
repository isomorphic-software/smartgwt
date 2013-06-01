/*
 * SmartGWT (GWT for SmartClient)
 * Copyright 2008 and beyond, Isomorphic Software, Inc.
 *
 * SmartGWT is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License version 3
 * as published by the Free Software Foundation.  SmartGWT is also
 * available under typical commercial license terms - see
 * smartclient.com/license.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 */

package com.smartgwt.client.core;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.smartgwt.client.util.IDManager;
import com.smartgwt.client.util.JSOHelper;
import com.smartgwt.client.util.SC;


public class RefDataClass extends DataClass {

    public RefDataClass() {
        setAttribute(SC.REF, (Object) this);
    }

    public RefDataClass(JavaScriptObject jsObj) {
        super(jsObj);
        //when we're being constructed using the JSO directly, make sure we clear out any other
        //SC.REF attributes to make sure this object is represented by a different GWT object ref
        JSOHelper.deleteAttribute(jsObj, SC.REF);
    }

    public static RefDataClass getRef(String jsObj) {
        return null;
    }

    public static RefDataClass getRef(JavaScriptObject jsObj) {

        if (jsObj == null) {
            return null;
        } else {
            Object ref = JSOHelper.getAttributeAsObject((JavaScriptObject) jsObj, SC.REF);
            if (ref != null && !(ref instanceof RefDataClass)) {
                return null;
            } else {
                return (RefDataClass) ref;
            }
        }
    }

    // IDManager support

    protected String id;

    protected void internalSetID(String id, boolean autoAssigned, boolean addIDToRegistry) {
        if (this.id != null) {
            IDManager.unregisterID(this, this.id);
        }
        if (addIDToRegistry) IDManager.registerID(this, id);
        this.id = id;
        setAttribute("ID",                        id);
        setAttribute("_autoAssignedID", autoAssigned);
    }

	/**
	 * Destroy this object.
	 */
    public native void destroy()/*-{
		var self = this.@com.smartgwt.client.core.RefDataClass::getJsObj()();
		if (self != null && self.__destroy) self.__destroy();
		var id = this.@com.smartgwt.client.core.RefDataClass::id
		if (id != null) {
            this.@com.smartgwt.client.core.RefDataClass::clearID()();
        }
    }-*/;

    private void clearID() {
        IDManager.unregisterID(this, this.id);
        this.id = null;
        setAttribute("ID", (String) null);
    }

    protected final native void doInit()/*-{
        var self = this.@com.smartgwt.client.core.RefDataClass::getJsObj()();
        if (self) {
            self.__destroy = self.destroy;
            self.destroy = function() {
                var jObj = this.__ref;
                jObj.@com.smartgwt.client.core.RefDataClass::destroy()();
            };
        };
    }-*/;
    
}
