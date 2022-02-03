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
 
package com.smartgwt.client.widgets.form.fields;



import com.smartgwt.client.event.*;
import com.smartgwt.client.core.*;
import com.smartgwt.client.types.*;
import com.smartgwt.client.data.*;
import com.smartgwt.client.data.Record;
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

import java.util.*;

import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Element;
import com.smartgwt.client.util.*;
import com.google.gwt.event.shared.*;
import com.google.gwt.event.shared.HasHandlers;

/**
 * Button that cancels any changes in the form, by calling {@link
 * com.smartgwt.client.widgets.form.DynamicForm#cancelEditing DynamicForm.cancelEditing}  when clicked. See {@link
 * com.smartgwt.client.widgets.form.DynamicForm#cancelEditing DynamicForm.cancelEditing} for details on what happens when a
 * form editing is  cancelled.
 */
public class CancelItem extends ButtonItem {

    public static CancelItem getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        RefDataClass obj = RefDataClass.getRef(jsObj);
        if(obj != null) {
            obj.setJsObj(jsObj);
            return (CancelItem) obj;
        } else {
            return new CancelItem(jsObj);
        }
    }

    public CancelItem(){
        setAttribute("editorType", "CancelItem");
    }

    public CancelItem(JavaScriptObject jsObj){
        super(jsObj);
    }

    public CancelItem(String name) {
        setName(name);
        setAttribute("editorType", "CancelItem");
    }

    public CancelItem(String name, String title) {
        setName(name);
		setTitle(title);
        setAttribute("editorType", "CancelItem");
    }

    // ********************* Properties / Attributes ***********************

    /**
     * CancelItems show a title of <code>"Cancel"</code> by default. May be overridden.
     *
     * @param title title Default value is "Cancel"
     * @return {com.smartgwt.client.widgets.form.fields.CancelItem CancelItem} instance, for
     * chaining setter calls
     */
    public CancelItem setTitle(String title) {
        return (CancelItem)setAttribute("title", title);
    }

    /**
     * CancelItems show a title of <code>"Cancel"</code> by default. May be overridden.
     *
     *
     * @return String
     */
    public String getTitle()  {
        return getAttributeAsString("title");
    }

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************
        
    // ***********************************************************        

}
