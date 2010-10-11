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
 * FormItem that creates an HTML &lt;input type="upload"&gt; control, with an interface that allows a user to pick a file
 * from his machine to upload to the server. <P> See the {@link com.smartgwt.client.docs.Upload Uploading Files} overview
 * for details. <P> Note: if a form containing an UploadItem is {@link com.smartgwt.client.widgets.Canvas#redraw redrawn}
 * (which may happen if other form items are shown or hidden, the form is {@link
 * com.smartgwt.client.widgets.Canvas#getRedrawOnResize resized}, or other items show validation errors) then the value in
 * the upload item is lost (because an HTML upload field may not be created with a value). For this reason, if you are
 * building a form that combines an UploadItem with other FormItems that could trigger redraw()s, recommended practice is
 * to place each UploadItem in a distinct DynamicForm instance and create the visual appearance of a single logical form
 * via combining the DynamicForms in a {@link com.smartgwt.client.widgets.layout.Layout}.
 * @see com.smartgwt.client.docs.Upload Upload overview and related methods
 */
public class UploadItem extends TextItem {

    public static UploadItem getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        RefDataClass obj = RefDataClass.getRef(jsObj);
        if(obj != null) {
            obj.setJsObj(jsObj);
            return (UploadItem) obj;
        } else {
            return new UploadItem(jsObj);
        }
    }

    public UploadItem(){
        setType("upload");
    }

    public UploadItem(JavaScriptObject jsObj){
        super(jsObj);
    }

    public UploadItem(String name) {
        setName(name);
        setType("upload");
    }

    public UploadItem(String name, String title) {
        setName(name);
		setTitle(title);
        setType("upload");
    }

    // ********************* Properties / Attributes ***********************

    // ********************* Methods ***********************
            
    /**
     * Attempting to set the value for an upload form item is disallowed for security reasons. Therefore this method will just
     * log a warning, and not modify the value of the item.
     */
    public native void setValue() /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.setValue();
    }-*/;

    // ********************* Static Methods ***********************
        
    // ***********************************************************        

}



