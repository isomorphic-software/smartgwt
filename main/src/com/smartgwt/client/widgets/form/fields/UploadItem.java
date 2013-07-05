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
import com.smartgwt.client.callbacks.*;
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
import com.smartgwt.client.widgets.drawing.*;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashMap;

import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;
import com.smartgwt.client.util.*;
import com.smartgwt.client.util.workflow.*;
import com.google.gwt.event.shared.*;
import com.google.gwt.event.shared.HasHandlers;
import com.smartgwt.logicalstructure.core.*;
import com.smartgwt.logicalstructure.widgets.*;
import com.smartgwt.logicalstructure.widgets.drawing.*;
import com.smartgwt.logicalstructure.widgets.plugins.*;
import com.smartgwt.logicalstructure.widgets.form.*;
import com.smartgwt.logicalstructure.widgets.tile.*;
import com.smartgwt.logicalstructure.widgets.grid.*;
import com.smartgwt.logicalstructure.widgets.chart.*;
import com.smartgwt.logicalstructure.widgets.layout.*;
import com.smartgwt.logicalstructure.widgets.menu.*;
import com.smartgwt.logicalstructure.widgets.tab.*;
import com.smartgwt.logicalstructure.widgets.tableview.*;
import com.smartgwt.logicalstructure.widgets.toolbar.*;
import com.smartgwt.logicalstructure.widgets.tree.*;
import com.smartgwt.logicalstructure.widgets.viewer.*;
import com.smartgwt.logicalstructure.widgets.calendar.*;
import com.smartgwt.logicalstructure.widgets.cube.*;

/**
 * FormItem that creates an HTML &lt;input type="file"&gt; control, with an interface that allows a user to pick a file
 * from his machine to upload to the server. <P> <b>NOTE:</b> use {@link com.smartgwt.client.widgets.form.fields.FileItem},
 * <b>not</b> UploadItem, if you are using the Smart GWT Server framework.  FileItem is much easier to use and addresses
 * all the limitations of UploadItem discussed below.  See the {@link com.smartgwt.client.docs.Upload Uploading Files}
 * overview for details. <P> If a form containing an UploadItem is {@link com.smartgwt.client.widgets.Canvas#redraw
 * redrawn} (which may happen if other form items are shown or hidden, the form is {@link
 * com.smartgwt.client.widgets.Canvas#getRedrawOnResize resized}, or other items show validation errors) then the value in
 * the upload item is lost (because an HTML upload field may not be created with a value). For this reason, if you are
 * building a form that combines an UploadItem with other FormItems that could trigger redraw()s, recommended practice is
 * to place each UploadItem in a distinct DynamicForm instance and create the visual appearance of a single logical form
 * via combining the DynamicForms in a {@link com.smartgwt.client.widgets.layout.Layout}. <P> <B>NOTE: Browser-specific
 * behaviors:</B>  <ul> <li> while getDisplayValue() can be used to retrieve the filesystem path of the uploaded file on
 * some browsers, different browsers will return either just the file name without path or the full path.  It is plausible
 * that some browsers may switch behavior in the future to not supply this value at all.  Do not rely on this value. <li>
 * the appearance of the UploadItem is not consistent across browsers and we do not recommend trying to make it consistent
 * or trying to apply styling to the upload control at all.  It is a potential security problem if an end user is unable to
 * reliably recognize the upload control, hence, all browsers limit what styling can be applied.  Various hacks exists to
 * get further control of styling, but it is likely these hacks will be broken by browser upgrades in the future. </ul>
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

    public void setJavaScriptObject(JavaScriptObject jsObj) {
        this.jsObj = jsObj;
    }



    /**
     * Changes the defaults for Canvas AutoChildren named <code>autoChildName</code>.
     *
     * @param autoChildName name of an AutoChild to customize the defaults for.
     * @param defaults Canvas defaults to apply. These defaults override any existing properties
     * without destroying or wiping out non-overridden properties.
     * @see com.smartgwt.client.docs.AutoChildUsage
     */
    public static native void changeAutoChildDefaults(String autoChildName, Canvas defaults) /*-{
        $wnd.isc["UploadItem"].changeDefaults(autoChildName + "Defaults", defaults.@com.smartgwt.client.widgets.Canvas::getConfig()());
    }-*/;

    /**
     * Changes the defaults for FormItem AutoChildren named <code>autoChildName</code>.
     *
     * @param autoChildName name of an AutoChild to customize the defaults for.
     * @param defaults FormItem defaults to apply. These defaults override any existing properties
     * without destroying or wiping out non-overridden properties.
     * @see com.smartgwt.client.docs.AutoChildUsage
     */
    public static native void changeAutoChildDefaults(String autoChildName, FormItem defaults) /*-{
        $wnd.isc["UploadItem"].changeDefaults(autoChildName + "Defaults", defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getJsObj()());
    }-*/;

    public UploadItem(){
        setAttribute("editorType", "UploadItem");
    }

    public UploadItem(JavaScriptObject jsObj){
        
        setJavaScriptObject(jsObj);
        
    }

    public UploadItem(String name) {
        setName(name);
        setAttribute("editorType", "UploadItem");
    }

    public UploadItem(String name, String title) {
        setName(name);
		setTitle(title);
        setAttribute("editorType", "UploadItem");
    }


    // ********************* Properties / Attributes ***********************


    /**
     * A comma-separated list of valid MIME types, used as a filter for the file picker window.
     *
     * @param accept . See {@link com.smartgwt.client.docs.String String}. Default value is null
     */
    public void setAccept(String accept) {
        setAttribute("accept", accept);
    }

    /**
     * A comma-separated list of valid MIME types, used as a filter for the file picker window.
     *
     * @return . See {@link com.smartgwt.client.docs.String String}
     */
    public String getAccept()  {
        return getAttributeAsString("accept");
    }


    /**
     * Height for this uploadItem. Note that Smart GWT will not apply this size to the native HTML &lt;input ...&gt; element
     * written out by this formItem as this leads to inconsistent appearance across different browsers. The specified height
     * acts as a minimum cell width for the item.
     *
     * @param height height Default value is 19
     */
    public void setHeight(int height) {
        setAttribute("height", height);
    }

    /**
     * Height for this uploadItem. Note that Smart GWT will not apply this size to the native HTML &lt;input ...&gt; element
     * written out by this formItem as this leads to inconsistent appearance across different browsers. The specified height
     * acts as a minimum cell width for the item.
     *
     * @return int
     */
    public int getHeight()  {
        return getAttributeAsInt("height");
    }


    /**
     * When true, allow the file-selection dialog shelled by the browser to select multiple 
     *  files.
     *  <P>
     *  Support is not full-cycle at the server - that is, there are server APIs for retrieving
     *  each file that was uploaded, but no built-in support for storing multiple files against
     *  a single DataSource field.  However, you can write custom server DMI code to do
     *  something with the files - for instance, you could create multiple new DataSource 
     *  records for each file via a server DMI like this below:
     * 
     *  <pre>
     *     String fileNameStr = (String)dsRequest.getValues().get("image_filename").toString();
     * 
     *     String[] fileNames = fileNameStr.split(", ");
     *     List files = dsRequest.getUploadedFiles();
     * 
     *     for (int i = 0; i < files.size(); i++) {
     *         ISCFileItem file = (ISCFileItem)files.get(i);
     *         InputStream fileData = file.getInputStream();
     *         DSRequest inner = new DSRequest("mediaLibrary", "add");
     *         Map values = new HashMap();
     *         values.put("title", dsRequest.getValues().get("title"));
     *         values.put("image", fileData);
     *         values.put("image_filename", fileNames[i]);
     *         values.put("image_filesize", file.getSize());
     *         values.put("image_date_created", new Date());
     *         
     *         inner.setValues(values);
     *         inner.execute();
     *     }
     *     
     *     DSResponse dsResponse = new DSResponse();
     *     
     *     dsResponse.setStatus(0);
     * 
     *     return dsResponse;
     *  </pre>
     *
     * @param multiple multiple Default value is true
     */
    public void setMultiple(Boolean multiple) {
        setAttribute("multiple", multiple);
    }

    /**
     * When true, allow the file-selection dialog shelled by the browser to select multiple 
     *  files.
     *  <P>
     *  Support is not full-cycle at the server - that is, there are server APIs for retrieving
     *  each file that was uploaded, but no built-in support for storing multiple files against
     *  a single DataSource field.  However, you can write custom server DMI code to do
     *  something with the files - for instance, you could create multiple new DataSource 
     *  records for each file via a server DMI like this below:
     * 
     *  <pre>
     *     String fileNameStr = (String)dsRequest.getValues().get("image_filename").toString();
     * 
     *     String[] fileNames = fileNameStr.split(", ");
     *     List files = dsRequest.getUploadedFiles();
     * 
     *     for (int i = 0; i < files.size(); i++) {
     *         ISCFileItem file = (ISCFileItem)files.get(i);
     *         InputStream fileData = file.getInputStream();
     *         DSRequest inner = new DSRequest("mediaLibrary", "add");
     *         Map values = new HashMap();
     *         values.put("title", dsRequest.getValues().get("title"));
     *         values.put("image", fileData);
     *         values.put("image_filename", fileNames[i]);
     *         values.put("image_filesize", file.getSize());
     *         values.put("image_date_created", new Date());
     *         
     *         inner.setValues(values);
     *         inner.execute();
     *     }
     *     
     *     DSResponse dsResponse = new DSResponse();
     *     
     *     dsResponse.setStatus(0);
     * 
     *     return dsResponse;
     *  </pre>
     *
     * @return Boolean
     */
    public Boolean getMultiple()  {
        return getAttributeAsBoolean("multiple");
    }


    /**
     * Width for this uploadItem. Note that Smart GWT will not apply this size to the native HTML &lt;input ...&gt; element
     * written out by this formItem as this leads to inconsistent appearance across different browsers. The specified width
     * acts as a minimum cell width for the item.
     *
     * @param width width Default value is 150
     */
    public void setWidth(int width) {
        setAttribute("width", width);
    }

    /**
     * Width for this uploadItem. Note that Smart GWT will not apply this size to the native HTML &lt;input ...&gt; element
     * written out by this formItem as this leads to inconsistent appearance across different browsers. The specified width
     * acts as a minimum cell width for the item.
     *
     * @return int
     */
    public int getWidth()  {
        return getAttributeAsInt("width");
    }

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
    /**
     * Class level method to set the default properties of this class. If set, then all subsequent instances of this
     * class will automatically have the default properties that were set when this method was called. This is a powerful
     * feature that eliminates the need for users to create a separate hierarchy of subclasses that only alter the default
     * properties of this class. Can also be used for skinning / styling purposes.
     * <P>
     * <b>Note:</b> This method is intended for setting default attributes only and will effect all instances of the
     * underlying class (including those automatically generated in JavaScript).
     * This method should not be used to apply standard EventHandlers or override methods for
     * a class - use a custom subclass instead.
     *
     * @param uploadItemProperties properties that should be used as new defaults when instances of this class are created
     */
    public static native void setDefaultProperties(UploadItem uploadItemProperties) /*-{
    	var properties = $wnd.isc.addProperties({},uploadItemProperties.@com.smartgwt.client.core.RefDataClass::getJsObj()());
    	delete properties.ID;
        $wnd.isc.UploadItem.addProperties(properties);
    }-*/;

    // ***********************************************************

}


