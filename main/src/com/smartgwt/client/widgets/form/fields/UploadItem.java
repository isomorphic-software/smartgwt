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
/* sgwtgen */
 
package com.smartgwt.client.widgets.form.fields;


import com.smartgwt.client.event.*;
import com.smartgwt.client.core.*;
import com.smartgwt.client.types.*;
import com.smartgwt.client.data.*;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.data.events.*;
import com.smartgwt.client.browser.window.*;
import com.smartgwt.client.rpc.*;
import com.smartgwt.client.callbacks.*;
import com.smartgwt.client.tools.*;
import com.smartgwt.client.bean.*;
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
import com.smartgwt.client.widgets.tour.*;
import com.smartgwt.client.widgets.notify.*;
import com.smartgwt.client.widgets.rte.*;
import com.smartgwt.client.widgets.rte.events.*;
import com.smartgwt.client.widgets.ace.*;
import com.smartgwt.client.widgets.ace.events.*;
import com.smartgwt.client.widgets.tab.*;
import com.smartgwt.client.widgets.toolbar.*;
import com.smartgwt.client.widgets.tree.*;
import com.smartgwt.client.widgets.tree.events.*;
import com.smartgwt.client.widgets.tableview.*;
import com.smartgwt.client.widgets.viewer.*;
import com.smartgwt.client.widgets.calendar.*;
import com.smartgwt.client.widgets.calendar.events.*;
import com.smartgwt.client.widgets.cube.*;
import com.smartgwt.client.widgets.notify.*;
import com.smartgwt.client.widgets.drawing.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.gwt.event.shared.*;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.core.client.JavaScriptObject;

import com.smartgwt.client.util.*;
import com.smartgwt.client.util.events.*;
import com.smartgwt.client.util.workflow.*;
import com.smartgwt.client.util.workflow.Process; // required to override java.lang.Process
import com.smartgwt.client.util.tour.*;


/**
 * FormItem that creates an HTML &lt;input type="file"&gt; control, with an interface that allows a user to pick a file
 * from his machine to upload to the server. <P> <b>NOTE:</b> use {@link com.smartgwt.client.widgets.form.fields.FileItem},
 * <b>not</b> UploadItem, if you are using the Smart GWT Server framework.  FileItem is much easier to use and addresses
 * all the limitations of UploadItem discussed below.  See the {@link com.smartgwt.client.docs.Upload Uploading Files}
 * overview for details. <P> If a form containing an UploadItem is {@link com.smartgwt.client.widgets.Canvas#redraw
 * redrawn} (which may happen if other form items are shown or hidden, the form is {@link
 * com.smartgwt.client.widgets.Canvas#getRedrawOnResize resized}, or this or other items show validation errors) then  the
 * value in the upload item is lost (because an HTML upload field may not be created with a value).  For this reason, if
 * you are building a form that combines an UploadItem with other FormItems that could trigger redraw()s, recommended
 * practice is to place each UploadItem in a distinct DynamicForm instance and create the visual appearance of a single
 * logical form  via combining the DynamicForms in a {@link com.smartgwt.client.widgets.layout.Layout}.  For the same
 * reason, do not apply  {@link com.smartgwt.client.widgets.form.validator.Validator validators} to UploadItems: if such a
 * validator fails, it will  cause the form to be redrawn and the UploadItem's value to be lost. <P> <B>NOTE:
 * Browser-specific behaviors:</B>  <ul> <li> while getDisplayValue() can be used to retrieve the filesystem path of the
 * uploaded file on some browsers, different browsers will return either just the file name without path or the full path. 
 * It is plausible that some browsers may switch behavior in the future to not supply this value at all.  Do not rely on
 * this value. <li> the appearance of the UploadItem is not consistent across browsers and we do not recommend trying to
 * make it consistent or trying to apply styling to the upload control at all.  It is a potential security problem if an
 * end user is unable to reliably recognize the upload control, hence, all browsers limit what styling can be applied. 
 * Various hacks exists to get further control of styling, but it is likely these hacks will be broken by browser upgrades
 * in the future. </ul>
 * @see com.smartgwt.client.docs.Upload Upload overview and related methods
 */
@BeanFactory.FrameworkClass
public class UploadItem extends TextItem {

    public static UploadItem getOrCreateRef(JavaScriptObject jsObj) {
        if (jsObj == null) return null;

        final RefDataClass existingObj = RefDataClass.getRef(jsObj);

        if (existingObj instanceof UploadItem) {
            existingObj.setJsObj(jsObj);
            return (UploadItem)existingObj;
        } else

        {
            return new UploadItem(jsObj);
        }
    }
        


    /**
     * Changes the defaults for Canvas AutoChildren named <code>autoChildName</code>.
     *
     * @param autoChildName name of an AutoChild to customize the defaults for.
     * @param defaults Canvas defaults to apply. These defaults override any existing properties
     * without destroying or wiping out non-overridden properties.  For usage tips on this
     * param, see {@link com.smartgwt.client.docs.SGWTProperties}.
     * @see com.smartgwt.client.docs.AutoChildUsage
     */
    public static native void changeAutoChildDefaults(String autoChildName, Canvas defaults) /*-{
        if (defaults.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(UploadItem.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "Canvas");
        }
        defaults.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
        var cleanDefaultsJS = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(defaults.@com.smartgwt.client.widgets.BaseWidget::getConfig()(), true);
        $wnd.isc.UploadItem.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
    }-*/;

    /**
     * Changes the defaults for FormItem AutoChildren named <code>autoChildName</code>.
     *
     * @param autoChildName name of an AutoChild to customize the defaults for.
     * @param defaults FormItem defaults to apply. These defaults override any existing properties
     * without destroying or wiping out non-overridden properties.  For usage tips on this
     * param, see {@link com.smartgwt.client.docs.SGWTProperties}.
     * @see com.smartgwt.client.docs.AutoChildUsage
     */
    public static native void changeAutoChildDefaults(String autoChildName, FormItem defaults) /*-{
        if (defaults.@com.smartgwt.client.widgets.form.fields.FormItem::isCreated()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(UploadItem.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "FormItem");
        }
        defaults.@com.smartgwt.client.widgets.form.fields.FormItem::setConfigOnly(Z)(true);
    	var cleanDefaultsJS = defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getEditorTypeConfig()();
        $wnd.isc.UploadItem.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
    }-*/;

    public static native void changePickerIconDefaults(FormItemIcon defaults) /*-{
        $wnd.isc.UploadItem.changeDefaults("pickerIconDefaults", defaults.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;

    public UploadItem(){
        setAttribute("editorType", "UploadItem");
    }

    public UploadItem(JavaScriptObject jsObj){
        super(jsObj);
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
     * A comma-separated list of valid MIME types, used as a filter for the file picker window. <P> Note that this property
     * makes use of the HTML <code>accept</code> attribute, and so relies on the browser to perform the desired filtering.  For
     * further study, see:<ul> <li><a href='https://www.w3schools.com/TAGS/att_input_accept.asp' target='_blank'>HTML
     * &lt;input&gt; accept Attribute</a> <li><a href='https://developer.mozilla.org/en-US/docs/Web/HTML/Element/Input'
     * target='_blank'>The Input (Form Input) element</a> <li><a
     * href='https://stackoverflow.com/questions/181214/file-input-accept-attribute-is-it-useful' target='_blank'>File input
     * 'accept' attribute - is it useful?</a> </ul>
     *
     * @param accept New accept value. Default value is null
     * @return {@link com.smartgwt.client.widgets.form.fields.UploadItem UploadItem} instance, for chaining setter calls
     */
    public UploadItem setAccept(String accept) {
        return (UploadItem)setAttribute("accept", accept);
    }

    /**
     * A comma-separated list of valid MIME types, used as a filter for the file picker window. <P> Note that this property
     * makes use of the HTML <code>accept</code> attribute, and so relies on the browser to perform the desired filtering.  For
     * further study, see:<ul> <li><a href='https://www.w3schools.com/TAGS/att_input_accept.asp' target='_blank'>HTML
     * &lt;input&gt; accept Attribute</a> <li><a href='https://developer.mozilla.org/en-US/docs/Web/HTML/Element/Input'
     * target='_blank'>The Input (Form Input) element</a> <li><a
     * href='https://stackoverflow.com/questions/181214/file-input-accept-attribute-is-it-useful' target='_blank'>File input
     * 'accept' attribute - is it useful?</a> </ul>
     *
     * @return Current accept value. Default value is null
     */
    public String getAccept()  {
        return getAttributeAsString("accept");
    }
    

    /**
     * Default class used to construct the {@link com.smartgwt.client.tools.EditProxy} for this component when the component is
     * {@link com.smartgwt.client.widgets.Canvas#setEditMode first placed into edit mode}.
     *
     * @param editProxyConstructor New editProxyConstructor value. Default value is "FileItemEditProxy"
     * @return {@link com.smartgwt.client.widgets.form.fields.UploadItem UploadItem} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.SCClassName SCClassName 
     */
    public UploadItem setEditProxyConstructor(String editProxyConstructor) {
        return (UploadItem)setAttribute("editProxyConstructor", editProxyConstructor);
    }

    /**
     * Default class used to construct the {@link com.smartgwt.client.tools.EditProxy} for this component when the component is
     * {@link com.smartgwt.client.widgets.Canvas#setEditMode first placed into edit mode}.
     *
     * @return Current editProxyConstructor value. Default value is "FileItemEditProxy"
     * @see com.smartgwt.client.docs.SCClassName SCClassName 
     */
    public String getEditProxyConstructor()  {
        return getAttributeAsString("editProxyConstructor");
    }
    

    /**
     * Height for this uploadItem. Note that Smart GWT will not apply this size to the native HTML &lt;input ...&gt; element
     * written out by this formItem as this leads to inconsistent appearance across different browsers. The specified height
     * acts as a minimum cell width for the item.
     *
     * @param height New height value. Default value is 19
     * @return {@link com.smartgwt.client.widgets.form.fields.UploadItem UploadItem} instance, for chaining setter calls
     */
    public UploadItem setHeight(int height) {
        return (UploadItem)setAttribute("height", height);
    }

    /**
     * Height for this uploadItem. Note that Smart GWT will not apply this size to the native HTML &lt;input ...&gt; element
     * written out by this formItem as this leads to inconsistent appearance across different browsers. The specified height
     * acts as a minimum cell width for the item.
     *
     * @return Current height value. Default value is 19
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
     * @param multiple New multiple value. Default value is true
     * @return {@link com.smartgwt.client.widgets.form.fields.UploadItem UploadItem} instance, for chaining setter calls
     */
    public UploadItem setMultiple(Boolean multiple) {
        return (UploadItem)setAttribute("multiple", multiple);
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
     * @return Current multiple value. Default value is true
     */
    public Boolean getMultiple()  {
        Boolean result = getAttributeAsBoolean("multiple", true);
        return result == null ? true : result;
    }
    

    /**
     * Base CSS class name for this <code>UploadItem</code>'s native file input element. <p> Note that the customization via
     * CSS of a native file input element allowable by the browser varies widely; in some browsers on certain platforms, it may
     * be possible to customize certain CSS properties, but not in others; or, it may be that the CSS property (e.g. border) is
     * applied differently in some browsers. <p> If the textBoxStyle is changed at runtime, {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#updateState FormItem.updateState()} must be called to update the visual
     * state. However, calling updateState() will clear any file selected by the user to be uploaded.
     *
     * @param textBoxStyle New textBoxStyle value. Default value is "uploadItem"
     * @return {@link com.smartgwt.client.widgets.form.fields.UploadItem UploadItem} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.form.fields.FormItem#setCellStyle
     * @see com.smartgwt.client.docs.FormItemBaseStyle FormItemBaseStyle 
     * @see com.smartgwt.client.docs.FormItemStyling FormItemStyling overview and related methods
     */
    public UploadItem setTextBoxStyle(String textBoxStyle) {
        return (UploadItem)setAttribute("textBoxStyle", textBoxStyle);
    }

    /**
     * Base CSS class name for this <code>UploadItem</code>'s native file input element. <p> Note that the customization via
     * CSS of a native file input element allowable by the browser varies widely; in some browsers on certain platforms, it may
     * be possible to customize certain CSS properties, but not in others; or, it may be that the CSS property (e.g. border) is
     * applied differently in some browsers. <p> If the textBoxStyle is changed at runtime, {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#updateState FormItem.updateState()} must be called to update the visual
     * state. However, calling updateState() will clear any file selected by the user to be uploaded.
     *
     * @return Current textBoxStyle value. Default value is "uploadItem"
     * @see com.smartgwt.client.widgets.form.fields.FormItem#getCellStyle
     * @see com.smartgwt.client.docs.FormItemBaseStyle FormItemBaseStyle 
     * @see com.smartgwt.client.docs.FormItemStyling FormItemStyling overview and related methods
     */
    public String getTextBoxStyle()  {
        return getAttributeAsString("textBoxStyle");
    }
    

    /**
     * Width for this uploadItem. Note that Smart GWT will not apply this size to the native HTML &lt;input ...&gt; element
     * written out by this formItem as this leads to inconsistent appearance across different browsers. The specified width
     * acts as a minimum cell width for the item.
     *
     * @param width New width value. Default value is 150
     * @return {@link com.smartgwt.client.widgets.form.fields.UploadItem UploadItem} instance, for chaining setter calls
     */
    public UploadItem setWidth(int width) {
        return (UploadItem)setAttribute("width", width);
    }

    /**
     * Width for this uploadItem. Note that Smart GWT will not apply this size to the native HTML &lt;input ...&gt; element
     * written out by this formItem as this leads to inconsistent appearance across different browsers. The specified width
     * acts as a minimum cell width for the item.
     *
     * @return Current width value. Default value is 150
     */
    public int getWidth()  {
        return getAttributeAsInt("width");
    }
    

    // ********************* Methods ***********************
	/**
     * <strong>This method is not supported</strong> by <code>UploadItem</code>.
     */
    public native void deselectValue() /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.deselectValue();
    }-*/;

	/**
     * <strong>This method is not supported</strong> by <code>UploadItem</code>.
     * @param start By default the text insertion cursor will be moved to the end of the   current value - pass in this parameter to move to
     * the start instead
     */
    public native void deselectValue(Boolean start) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.deselectValue(start == null ? null : start.@java.lang.Boolean::booleanValue()());
    }-*/;
	
	/**
     * <strong>This method is not supported</strong> by <code>UploadItem</code>.
     *
     * @return <code>null</code>
     */
    public native int[] getSelectionRange() /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        if (!this.@com.smartgwt.client.widgets.form.fields.FormItem::isCreated()()) return null;
        var ret = self.getSelectionRange();
        if(ret == null) return null;
        return @com.smartgwt.client.util.ConvertTo::arrayOfint(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

	/**
     * <strong>This method is not supported</strong> by <code>UploadItem</code>.
     */
    public native void selectValue() /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.selectValue();
    }-*/;

	/**
     * <strong>This method is not supported</strong> by <code>UploadItem</code>.
     */
    public native void setSelectionRange() /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.setSelectionRange();
    }-*/;

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
     * Class level method to set the default properties of this class.  If set, then all
     * existing and subsequently created instances of this class will automatically have
     * default properties corresponding to
     * the properties of the class instance passed to this function.
     * This is a powerful feature that eliminates the need for users to create a separate
     * hierarchy of subclasses that only alter the default properties of this class. Can also
     * be used for skinning / styling purposes.  <P> <b>Note:</b> This method is intended for
     * setting default attributes only and will affect all instances of the underlying class
     * (including those automatically generated in JavaScript).  This method should not be used
     * to apply standard EventHandlers or override methods for a class - use a custom subclass
     * instead.  Calling this method after instances have been created can result in undefined
     * behavior, since it bypasses any setters and a class instance may have already examined 
     * a particular property and not be expecting any changes through this route.
     *
     * @param uploadItemProperties properties that should be used as new defaults when instances of this class are created
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public static native void setDefaultProperties(UploadItem uploadItemProperties) /*-{
        if (uploadItemProperties.@com.smartgwt.client.widgets.form.fields.FormItem::isCreated()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Class;)(UploadItem.@java.lang.Object::getClass()(), "setDefaultProperties", uploadItemProperties.@java.lang.Object::getClass()());
        }
        uploadItemProperties.@com.smartgwt.client.widgets.form.fields.FormItem::setConfigOnly(Z)(true);
    	var properties = uploadItemProperties.@com.smartgwt.client.widgets.form.fields.FormItem::getConfig()();
        $wnd.isc.UploadItem.addProperties(properties);
    }-*/;

    // ***********************************************************

}
