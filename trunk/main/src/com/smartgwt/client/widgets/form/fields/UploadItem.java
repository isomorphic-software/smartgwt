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
import com.smartgwt.client.util.JSOHelper;
import com.smartgwt.client.util.EnumUtil;
import com.google.gwt.event.shared.*;
import com.google.gwt.event.shared.HasHandlers;
   /**
    * FormItem that creates an HTML &lt;input type="upload"&gt; control, with an interface that&#010 allows a user to pick a file from his machine to upload to the server.&#010 <P>&#010 See the {@link com.smartgwt.client.docs.Upload 'Uploading Files'} overview for details.&#010 <P>&#010 Note: if a form containing an UploadItem is {@link com.smartgwt.client.widgets.Canvas#redraw} (which may&#010 happen if other form items are shown or hidden, the form is&#010 {@link com.smartgwt.client.widgets.Canvas#getRedrawOnResize redrawOnResize}, or other items show validation errors) then the value&#010 in the upload item is lost (because an HTML upload field may not be created with a value).&#010 For this reason, if you are building a form that combines an UploadItem with other FormItems&#010 that could trigger redraw()s, recommended practice is to place each UploadItem in a distinct&#010 DynamicForm instance and create the visual appearance of a single logical form via combining&#010 the DynamicForms in a {@link com.smartgwt.client.widgets.layout.Layout}.

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
        setType("UploadItem");
    }

    public UploadItem(JavaScriptObject jsObj){
        super(jsObj);
    }

    public UploadItem(String name) {
        setName(name);
        setType("UploadItem");
    }

    // ********************* Properties / Attributes ***********************

    // ********************* Methods ***********************

        /**
         * Attempting to set the value for an upload form item is disallowed for security reasons.&#010 Therefore this method will just log a warning, and not modify the value of the item.&#010
         */
        public native void setValue() /*-{
            var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
            self.setValue();
        }-*/;

    // ********************* Static Methods ***********************

}



