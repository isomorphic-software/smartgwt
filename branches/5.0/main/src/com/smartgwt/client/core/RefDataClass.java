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
import com.smartgwt.client.bean.BeanFactory;


public class RefDataClass extends DataClass {

    public RefDataClass() {
        setAttribute(SC.REF, (Object) this);
        setAttribute(SC.MODULE, BeanFactory.getSGWTModule());
    }

    public RefDataClass(JavaScriptObject jsObj) {
        super(jsObj);
        //when we're being constructed using the JSO directly, make sure we clear out any other
        //SC.REF attributes to make sure this object is represented by a different GWT object ref
        JSOHelper.deleteAttribute(jsObj, SC.REF);
        JSOHelper.deleteAttribute(jsObj, SC.MODULE);
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
    //
    // Descendants of this class do not themselves wrap SC objects, but instead serve as
    // templates for SC objects with their own (separate) SGWT wrappers.  Since this object,
    // the SC object and its separate SGWT wrapper all share the same ID, don't register
    // this object with the SGWT ID Manager - instead merely verify availability of the ID.
    // When/if the separate SGWT wrapper is built, it will be registered with this ID.

    protected String id;

    protected void internalSetID(String id, boolean autoAssigned, boolean validateID) {
        if (this.id != null) {
            IDManager.unregisterID(this, this.id);
        }
        if (validateID) IDManager.validateID(id, false);
        this.id = id;
        setAttribute(     "ID",           id);
        setAttribute(SC.AUTOID, autoAssigned);
    }

	/**
	 * Destroy this object.
	 */
    private void clearID() {
        IDManager.unregisterID(this, this.id);
        this.id = null;
        setAttribute("ID", (String) null);
    }
    
}
