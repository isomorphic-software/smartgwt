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
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.bean.BeanFactory;
import com.smartgwt.client.util.IDManager;
import com.smartgwt.client.util.JSOHelper;
import com.smartgwt.client.util.SC;

public class RefDataClass extends DataClass {

    public RefDataClass() {
        setAttribute(SC.REF, (Object) this);
        setAttribute(SC.MODULE, BeanFactory.getSGWTModule());
    }

    public RefDataClass(JavaScriptObject jsObj) {
        super(jsObj);
        // For non-FormItem RefDataClass objects, clear out the SC.REF/sc.MODULE attirbutes to
        // ensure that new values are installed that reference this instance and module:
        // - The wiping was originally added to deal with handling the switch between Record
        //   and ListGridRecord wrappers for the same underlying JSO.
        // - For a FormItem, these two attributes are manually set in the FormItem constructor.
        if (!(this instanceof FormItem)) {
            JSOHelper.deleteAttribute(jsObj, SC.REF);
            JSOHelper.deleteAttribute(jsObj, SC.MODULE);
        }
    }

    public static RefDataClass getRef(String jsObj) {
        return null;
    }

    public static RefDataClass getRef(JavaScriptObject jsObj) {
        if (jsObj == null) {
            return null;
        } else {
            Object ref = JSOHelper.getAttributeAsObject((JavaScriptObject) jsObj, SC.REF);
            if (ref instanceof RefDataClass) {
                return (RefDataClass) ref;
            } else {
                return null;
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
        if (!autoAssigned) setAttribute(SC.AUTOIDCLASS, (String)null);
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
