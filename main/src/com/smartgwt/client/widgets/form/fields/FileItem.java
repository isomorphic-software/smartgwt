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
import com.smartgwt.client.data.events.*;
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
import com.smartgwt.client.widgets.drawing.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;
import com.smartgwt.client.util.*;
import com.smartgwt.client.util.events.*;
import com.smartgwt.client.util.workflow.*;
import com.google.gwt.event.shared.*;
import com.google.gwt.event.shared.HasHandlers;

/**
 * Binary data interface for use in DynamicForms. Allows users to select a single file for upload. In read-only mode
 * (canEdit:false), can display the contents of "imageFile" fields. <P> <b>Editable mode</b> <P> The {@link
 * com.smartgwt.client.widgets.form.fields.FileItem#getEditForm editForm} will be automatically generated and displayed as 
 * {@link com.smartgwt.client.widgets.form.fields.CanvasItem#getCanvas this.canvas}, allowing the user to select file(s) to
 * upload. <P> See the {@link com.smartgwt.client.docs.Upload Upload Overview} for information on using this control. <P>
 * <b>Read-only mode</b> <P> For fields of type <code>"blob"</code> the raw data value will be displayed in the  generated
 * {@link com.smartgwt.client.widgets.form.fields.FileItem#getDisplayForm displayForm}. <P> For other fields, the {@link
 * com.smartgwt.client.widgets.form.fields.FileItem#getDisplayCanvas displayCanvas} will be displayed. <P> For
 * <code>"imageFile"</code> fields with {@link com.smartgwt.client.widgets.form.fields.FileItem#getShowFileInline
 * showFileInline} set to true, the image-file will be streamed and displayed inline within the displayCanvas. <P>
 * Otherwise, the displayCanvas will render out {@link com.smartgwt.client.widgets.form.fields.FileItem#getViewIconSrc
 * View} and  {@link com.smartgwt.client.widgets.form.fields.FileItem#getDownloadIconSrc Download} icons and the fileName.
 * @see com.smartgwt.client.docs.Upload Upload overview and related methods
 */
@BeanFactory.FrameworkClass
public class FileItem extends CanvasItem {

    public static FileItem getOrCreateRef(JavaScriptObject jsObj) {
        if (jsObj == null) return null;

        final RefDataClass existingObj = RefDataClass.getRef(jsObj);

        if (existingObj instanceof FileItem) {
            existingObj.setJsObj(jsObj);
            return (FileItem)existingObj;
        } else

        {
            return new FileItem(jsObj);
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(FileItem.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "Canvas");
        }
        defaults.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
        var cleanDefaultsJS = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(defaults.@com.smartgwt.client.widgets.BaseWidget::getConfig()(), true);
        $wnd.isc.FileItem.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(FileItem.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "FormItem");
        }
        defaults.@com.smartgwt.client.widgets.form.fields.FormItem::setConfigOnly(Z)(true);
    	var cleanDefaultsJS = defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getEditorTypeConfig()();
        $wnd.isc.FileItem.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
    }-*/;

    public static native void changePickerIconDefaults(FormItemIcon defaults) /*-{
        $wnd.isc.FileItem.changeDefaults("pickerIconDefaults", defaults.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;

    public FileItem(){
        setAttribute("editorType", "FileItem");
    }

    public FileItem(JavaScriptObject jsObj){
        super(jsObj);
    }


    public FileItem(String name) {
        setName(name);
                setAttribute("editorType", "FileItem");
    }


    public FileItem(String name, String title) {
        setName(name);
		setTitle(title);
                setAttribute("editorType", "FileItem");
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
     */
    public void setAccept(String accept) {
        setAttribute("accept", accept);
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
     * The {@link com.smartgwt.client.widgets.Canvas} created automatically when {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getCanEdit canEdit} is false and the field is of any type other than
     * "blob". <P> If the field is of type "imageFile", and {@link
     * com.smartgwt.client.widgets.form.fields.FileItem#getShowFileInline showFileInline}  is true, the contents of the canvas
     * are set to HTML that streams the image file for  display. Otherwise, the item renders icons that allow the file to be 
     * {@link com.smartgwt.client.widgets.form.fields.FileItem#getViewIconSrc viewed} or {@link
     * com.smartgwt.client.widgets.form.fields.FileItem#getDownloadIconSrc downloaded}. <P> This component is an {@link
     * com.smartgwt.client.types.AutoChild} and as such may be customized via  <code>fileItem.displayCanvasDefaults</code> and 
     * <code>fileItem.displayCanvasProperties</code>.
     * <p>
     * This component is an AutoChild named "displayCanvas".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current displayCanvas value. Default value is null
     * @see com.smartgwt.client.docs.Upload Upload overview and related methods
     */
    public Canvas getDisplayCanvas()  {
        return (Canvas)Canvas.getByJSObject(getAttributeAsJavaScriptObject("displayCanvas"));
    }
    

    /**
     * The {@link com.smartgwt.client.widgets.form.DynamicForm} created automatically when {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getCanEdit canEdit} is false and the field is of type "blob". Displays
     * a single  {@link com.smartgwt.client.widgets.form.fields.FileItem#getDisplayItem item} for viewing the content of a blob
     * file. <P> This component is an {@link com.smartgwt.client.types.AutoChild} and as such may be customized via 
     * <code>fileItem.displayFormDefaults</code> and <code>fileItem.displayFormProperties</code>.
     * <p>
     * This component is an AutoChild named "displayForm".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current displayForm value. Default value is null
     * @see com.smartgwt.client.docs.Upload Upload overview and related methods
     */
    public DynamicForm getDisplayForm()  {
        return (DynamicForm)DynamicForm.getByJSObject(getAttributeAsJavaScriptObject("displayForm"));
    }
    

    /**
     * The {@link com.smartgwt.client.widgets.form.fields.StaticTextItem} created automatically and displayed in the  {@link
     * com.smartgwt.client.widgets.form.fields.FileItem#getDisplayForm displayForm} when {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getCanEdit canEdit} is false and the field type is "blob". <P> This
     * component is an {@link com.smartgwt.client.types.AutoChild} and as such may be customized via 
     * <code>fileItem.displayItemDefaults</code> and <code>fileItem.displayItemProperties</code>.  <P>
     * <p>
     * This component is an AutoChild named "displayItem".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current displayItem value. Default value is null
     * @see com.smartgwt.client.docs.Upload Upload overview and related methods
     */
    public StaticTextItem getDisplayItem()  {
        return StaticTextItem.getOrCreateRef(getAttributeAsJavaScriptObject("displayItem"));
    }
    

    /**
     * Returns the URL for an Icon that will allow the file to be downloaded
     *
     * @param downloadIconSrc New downloadIconSrc value. Default value is "[SKIN]actions/download.png"
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     * @see com.smartgwt.client.docs.Images Images overview and related methods
     */
    public void setDownloadIconSrc(String downloadIconSrc) {
        setAttribute("downloadIconSrc", downloadIconSrc);
    }

    /**
     * Returns the URL for an Icon that will allow the file to be downloaded
     *
     * @return Current downloadIconSrc value. Default value is "[SKIN]actions/download.png"
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     * @see com.smartgwt.client.docs.Images Images overview and related methods
     */
    public String getDownloadIconSrc()  {
        return getAttributeAsString("downloadIconSrc");
    }
    

    /**
     * The {@link com.smartgwt.client.widgets.form.DynamicForm} created automatically when {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getCanEdit canEdit} is true. Displays a single {@link
     * com.smartgwt.client.widgets.form.fields.FileItem#getUploadItem item} for manipulating a file. <P> This component is an
     * {@link com.smartgwt.client.types.AutoChild} and as such may be customized via  <code>fileItem.editFormDefaults</code>
     * and <code>fileItem.editFormProperties</code>. <P>
     * <p>
     * This component is an AutoChild named "editForm".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current editForm value. Default value is null
     * @see com.smartgwt.client.docs.Upload Upload overview and related methods
     */
    public DynamicForm getEditForm()  {
        return (DynamicForm)DynamicForm.getByJSObject(getAttributeAsJavaScriptObject("editForm"));
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
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Updates the {@link com.smartgwt.client.widgets.form.fields.FileItem#getMultiple multiple} setting at runtime, propagating it to the Browser's file dialog.  Causes a redraw.
     *
     * @param multiple the HTML of the view link. Default value is true
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
     * @return Current multiple value. Default value is true
     */
    public Boolean getMultiple()  {
        Boolean result = getAttributeAsBoolean("multiple", true);
        return result == null ? true : result;
    }
    

    /**
     * Should this item's value be saved in the form's values and hence returned from {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getValues form.getValues()}? <p> <code>shouldSaveValue:false</code> is used
     * to mark formItems which do not correspond to the underlying data model and should not save a value into the form's
     * {@link com.smartgwt.client.widgets.form.DynamicForm#getValues values}.  Example includes visual separators, password
     * re-type fields, or checkboxes used to show/hide other form items. <p> A <code>shouldSaveValue:false</code> item should
     * be given a value either via {@link com.smartgwt.client.widgets.form.fields.FormItem#getDefaultValue
     * FormItem.defaultValue} or by calling {@link com.smartgwt.client.widgets.form.DynamicForm#setValue form.setValue(item,
     * value)} or  {@link com.smartgwt.client.widgets.form.fields.FormItem#setValue formItem.setValue(value)}.  Providing a
     * value via {@link com.smartgwt.client.widgets.form.DynamicForm#getValues form.values} or {@link
     * com.smartgwt.client.widgets.form.DynamicForm#setValues form.setValues()}  will automatically switch the item to
     * <code>shouldSaveValue:true</code>. <P> Note that <ul> <li>if an item is shouldSaveValue true, but has no name, a warning
     * is logged, and      shouldSaveValue will be set to false. </li></ul>
     *
     * @param shouldSaveValue New shouldSaveValue value. Default value is true
     */
    public void setShouldSaveValue(Boolean shouldSaveValue) {
        setAttribute("shouldSaveValue", shouldSaveValue);
    }

    /**
     * Should this item's value be saved in the form's values and hence returned from {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getValues form.getValues()}? <p> <code>shouldSaveValue:false</code> is used
     * to mark formItems which do not correspond to the underlying data model and should not save a value into the form's
     * {@link com.smartgwt.client.widgets.form.DynamicForm#getValues values}.  Example includes visual separators, password
     * re-type fields, or checkboxes used to show/hide other form items. <p> A <code>shouldSaveValue:false</code> item should
     * be given a value either via {@link com.smartgwt.client.widgets.form.fields.FormItem#getDefaultValue
     * FormItem.defaultValue} or by calling {@link com.smartgwt.client.widgets.form.DynamicForm#setValue form.setValue(item,
     * value)} or  {@link com.smartgwt.client.widgets.form.fields.FormItem#setValue formItem.setValue(value)}.  Providing a
     * value via {@link com.smartgwt.client.widgets.form.DynamicForm#getValues form.values} or {@link
     * com.smartgwt.client.widgets.form.DynamicForm#setValues form.setValues()}  will automatically switch the item to
     * <code>shouldSaveValue:true</code>. <P> Note that <ul> <li>if an item is shouldSaveValue true, but has no name, a warning
     * is logged, and      shouldSaveValue will be set to false. </li></ul>
     *
     * @return Current shouldSaveValue value. Default value is true
     */
    public Boolean getShouldSaveValue()  {
        Boolean result = getAttributeAsBoolean("shouldSaveValue", true);
        return result == null ? true : result;
    }
    

    /**
     * Indicates whether to stream the image and display it inline or to display the View and Download icons.
     *
     * @param showFileInline New showFileInline value. Default value is null
     */
    public void setShowFileInline(Boolean showFileInline) {
        setAttribute("showFileInline", showFileInline);
    }

    /**
     * Indicates whether to stream the image and display it inline or to display the View and Download icons.
     *
     * @return Current showFileInline value. Default value is null
     */
    public Boolean getShowFileInline()  {
        return getAttributeAsBoolean("showFileInline", true);
    }
    

    /**
     * The {@link com.smartgwt.client.widgets.form.fields.UploadItem} created automatically and displayed in the  {@link
     * com.smartgwt.client.widgets.form.fields.FileItem#getEditForm editForm} when {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getCanEdit canEdit} is true. <P> This component is an {@link
     * com.smartgwt.client.types.AutoChild} and as such may be customized via  <code>fileItem.uploadItemDefaults</code> and
     * <code>fileItem.uploadItemProperties</code>. <P>
     * <p>
     * This component is an AutoChild named "uploadItem".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current uploadItem value. Default value is null
     * @see com.smartgwt.client.docs.Upload Upload overview and related methods
     */
    public UploadItem getUploadItem()  {
        return UploadItem.getOrCreateRef(getAttributeAsJavaScriptObject("uploadItem"));
    }
    

    /**
     * Returns the URL for an Icon that will allow the file to be viewed.
     *
     * @param viewIconSrc New viewIconSrc value. Default value is "[SKIN]actions/view.png"
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     * @see com.smartgwt.client.docs.Images Images overview and related methods
     */
    public void setViewIconSrc(String viewIconSrc) {
        setAttribute("viewIconSrc", viewIconSrc);
    }

    /**
     * Returns the URL for an Icon that will allow the file to be viewed.
     *
     * @return Current viewIconSrc value. Default value is "[SKIN]actions/view.png"
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     * @see com.smartgwt.client.docs.Images Images overview and related methods
     */
    public String getViewIconSrc()  {
        return getAttributeAsString("viewIconSrc");
    }
    

    // ********************* Methods ***********************

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
     * @param fileItemProperties properties that should be used as new defaults when instances of this class are created
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public static native void setDefaultProperties(FileItem fileItemProperties) /*-{
        if (fileItemProperties.@com.smartgwt.client.widgets.form.fields.FormItem::isCreated()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Class;)(FileItem.@java.lang.Object::getClass()(), "setDefaultProperties", fileItemProperties.@java.lang.Object::getClass()());
        }
        fileItemProperties.@com.smartgwt.client.widgets.form.fields.FormItem::setConfigOnly(Z)(true);
    	var properties = fileItemProperties.@com.smartgwt.client.widgets.form.fields.FormItem::getConfig()();
        $wnd.isc.FileItem.addProperties(properties);
    }-*/;

    // ***********************************************************

}
