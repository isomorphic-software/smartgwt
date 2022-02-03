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
 * The MultiFileItem provides an interface for a user to save one or more files that are
 *  related to a DataSource record, where each file is represented by a record in a
 *  related DataSource.
 *  <P>
 *  Use MultiFileItem when a record may have one or more files associated with it (such as
 *  attachments to an email message) where no information about the files needs to be stored other
 *  than the files themselves.  If you have several fields associated with each file (such as an
 *  uploaded document with a version, comments and processes associated with it), consider
 * instead an ordinary DataSource with on field of type "binary", and using the {@link
 * com.smartgwt.client.widgets.form.fields.FileItem}
 *  for upload.
 *  <P>
 *  See the {@link com.smartgwt.client.docs.Upload Uploading Files} overview for more information on upload.
 *  <P>
 *  <b>DataSource Setup</B>
 *  <P>
 *  In a relationship sometimes called a "master-detail" relationship, the MultiFileItem stores
 *  files in a "detail" DataSource which are related to a "master" DataSource record being
 *  edited by the form which contains the MultiFileItem.
 *  <P>
 *  To use a MultiFileItem:
 *  <ul>
 *  <li> declare a "detail" DataSource to store the related files.  At a minimum, this
 *  DataSource must have:
 *  <ul>
 *  <li> a {@link com.smartgwt.client.data.DataSourceField#getPrimaryKey primaryKey} field
 *  <li> a field declaring a {@link com.smartgwt.client.data.DataSourceField#getForeignKey foreignKey} relationship to the
 *  primaryKey of the "master" DataSource
 *  <li> a field of type "binary"
 *  </ul>
 * <li> {@link com.smartgwt.client.widgets.DataBoundComponent#getDataSource bind} a DynamicForm to the "master" DataSource 
 *  <li> in the DynamicForm bound to the "master" DataSource, declare a field with
 * {@link com.smartgwt.client.widgets.form.fields.FormItem#getEditorType editorType}:"MultiFileItem" and a
 * <code>dataSource</code>
 *  property set to the ID of the "detail" DataSource
 *  </ul>
 *  An example "detail" DataSource for storing files is shown below.  This "detail" DataSource
 * assumes a "master" DataSource with {@link com.smartgwt.client.data.DataSource#getID DataSource.ID} "masterRecord" and
 * with a primaryKey
 *  field "id".
 *  <pre>
 *  <code>
 *    &lt;DataSource ID="uploadedFiles" serverType="sql"&gt;
 *      &lt;fields&gt;
 *         &lt;field name="fileId" type="sequence" primaryKey="true" hidden="true"/&gt;
 *         &lt;field name="masterRecordId" type="number" foreignKey="masterRecord.id" hidden="true"/&gt;
 *         &lt;field name="file" type="binary" title="File"/&gt;
 *      &lt;/fields&gt;
 *    &lt;/DataSource&gt;
 *  </code>
 *  </pre>
 *  <P>
 *  Aside from a single "binary" field, the "detail" DataSource should generally have only
 *  hidden fields, as shown above.  Additional internal fields (such as a "lastUpdated" field)
 *  may be added, but will not be editable via MultiFileItem. 
 *  <P>
 *  <b>Display</b>
 *  <P>
 *  The MultiFileItem appears as a list of files related to the current record.  An optional
 * button, the {@link com.smartgwt.client.widgets.form.fields.MultiFileItem#getRemoveButton removeButton} allows removing
 * files.  A
 * second optional button, the {@link com.smartgwt.client.widgets.form.fields.MultiFileItem#getEditButton editButton},
 * launches a
 *  picker for uploading further files.
 *  <P>
 *  <b>Saving</b>
 *  <P>
 *  In all cases, uploading a new file is an "add" DSRequest against the
 *  {@link com.smartgwt.client.widgets.form.fields.MultiFileItem#getDataSource dataSource}.
 *  <P>
 *  The MultiFileItem has two modes, according to whether the "master" record is being newly created
 *  via an "add" operation or whether the master record is pre-existing ("update" operation).
 *  <P>
 *  If the master record is pre-existing, each file added by the user is uploaded as soon as the
 *  user exits the picker launched from the edit button, and the list of files shown in the main
 *  form reflects the actual list of stored files.  
 *  <P>
 *  If the master record is being newly created, files are not actually uploaded until
 *  <b>after</b> the master record is confirmed saved, and the list of fields shown in the main
 *  form reflects files which will be uploaded after the master record is saved.
 *  <P>
 *  In both cases, if there are multiple files to upload, they are uploaded one at a time, as a
 * series of separate "add" DSRequests against the {@link
 * com.smartgwt.client.widgets.form.fields.MultiFileItem#getDataSource dataSource}.
 *  <P>
 *  Also in both cases, deletion of any file is immediate.  In the case of a pre-existing master
 *  record, all files shown actually exist as DataSource records, and deletion is performed as a
 *  "remove" DSRequest against the {@link com.smartgwt.client.widgets.form.fields.MultiFileItem#getDataSource dataSource}.
 * @see com.smartgwt.client.docs.Upload Upload overview and related methods
 */
@BeanFactory.FrameworkClass
public class MultiFileItem extends CanvasItem {

    public static MultiFileItem getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        return new MultiFileItem(jsObj);
    }
        


    public MultiFileItem(){
        setAttribute("editorType", "MultiFileItem");
    }

    public MultiFileItem(JavaScriptObject jsObj){
        
        setJavaScriptObject(jsObj);
    }


    public MultiFileItem(String name) {
        setName(name);
                setAttribute("editorType", "MultiFileItem");
    }


    public MultiFileItem(String name, String title) {
        setName(name);
		setTitle(title);
                setAttribute("editorType", "MultiFileItem");
    }


    // ********************* Properties / Attributes ***********************
    
    

    /**
     * The {@link com.smartgwt.client.widgets.form.fields.FormItemIcon#getPrompt prompt} of the {@link
     * com.smartgwt.client.widgets.form.fields.MultiFileItem#getEditButton edit button}.
     *
     * @param editButtonPrompt New editButtonPrompt value. Default value is "Add files"
     * @return {@link com.smartgwt.client.widgets.form.fields.MultiFileItem MultiFileItem} instance, for chaining setter calls
     */
    public MultiFileItem setEditButtonPrompt(String editButtonPrompt) {
        return (MultiFileItem)setAttribute("editButtonPrompt", editButtonPrompt);
    }

    /**
     * The {@link com.smartgwt.client.widgets.form.fields.FormItemIcon#getPrompt prompt} of the {@link
     * com.smartgwt.client.widgets.form.fields.MultiFileItem#getEditButton edit button}.
     *
     * @return Current editButtonPrompt value. Default value is "Add files"
     */
    public String getEditButtonPrompt()  {
        return getAttributeAsString("editButtonPrompt");
    }
    

    /**
     * Empty message to display when there are no files listed.
     *
     * @param emptyMessage New emptyMessage value. Default value is "Click icon to add..."
     * @return {@link com.smartgwt.client.widgets.form.fields.MultiFileItem MultiFileItem} instance, for chaining setter calls
     */
    public MultiFileItem setEmptyMessage(String emptyMessage) {
        return (MultiFileItem)setAttribute("emptyMessage", emptyMessage);
    }

    /**
     * Empty message to display when there are no files listed.
     *
     * @return Current emptyMessage value. Default value is "Click icon to add..."
     */
    public String getEmptyMessage()  {
        return getAttributeAsString("emptyMessage");
    }
    

    /**
     * The contents of the "Add another" file button in the picker launched by the {@link
     * com.smartgwt.client.widgets.form.fields.MultiFileItem#getEditButton edit button}.
     *
     * @param pickerAddAnotherFileButtonTitle New pickerAddAnotherFileButtonTitle value. Default value is "&lt;u&gt;Add&amp;nbsp;another&lt;/u&gt;"
     * @return {@link com.smartgwt.client.widgets.form.fields.MultiFileItem MultiFileItem} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public MultiFileItem setPickerAddAnotherFileButtonTitle(String pickerAddAnotherFileButtonTitle) {
        return (MultiFileItem)setAttribute("pickerAddAnotherFileButtonTitle", pickerAddAnotherFileButtonTitle);
    }

    /**
     * The contents of the "Add another" file button in the picker launched by the {@link
     * com.smartgwt.client.widgets.form.fields.MultiFileItem#getEditButton edit button}.
     *
     * @return Current pickerAddAnotherFileButtonTitle value. Default value is "&lt;u&gt;Add&amp;nbsp;another&lt;/u&gt;"
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public String getPickerAddAnotherFileButtonTitle()  {
        return getAttributeAsString("pickerAddAnotherFileButtonTitle");
    }
    

    /**
     * The title of the cancel button in the picker lauched by the {@link
     * com.smartgwt.client.widgets.form.fields.MultiFileItem#getEditButton edit button}.
     *
     * @param pickerCancelButtonTitle New pickerCancelButtonTitle value. Default value is "Cancel"
     * @return {@link com.smartgwt.client.widgets.form.fields.MultiFileItem MultiFileItem} instance, for chaining setter calls
     */
    public MultiFileItem setPickerCancelButtonTitle(String pickerCancelButtonTitle) {
        return (MultiFileItem)setAttribute("pickerCancelButtonTitle", pickerCancelButtonTitle);
    }

    /**
     * The title of the cancel button in the picker lauched by the {@link
     * com.smartgwt.client.widgets.form.fields.MultiFileItem#getEditButton edit button}.
     *
     * @return Current pickerCancelButtonTitle value. Default value is "Cancel"
     */
    public String getPickerCancelButtonTitle()  {
        return getAttributeAsString("pickerCancelButtonTitle");
    }
    

    /**
     * MultiFileItems use a {@link com.smartgwt.client.widgets.MultiFilePicker} instance as their picker. The generated
     * <code>picker</code> autoChild may be customized via the standard  {@link com.smartgwt.client.types.AutoChild} pattern.
     *
     * @param pickerConstructor New pickerConstructor value. Default value is "MultiFilePicker"
     * @return {@link com.smartgwt.client.widgets.form.fields.MultiFileItem MultiFileItem} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.SCClassName SCClassName 
     */
    public MultiFileItem setPickerConstructor(String pickerConstructor) {
        return (MultiFileItem)setAttribute("pickerConstructor", pickerConstructor);
    }

    /**
     * MultiFileItems use a {@link com.smartgwt.client.widgets.MultiFilePicker} instance as their picker. The generated
     * <code>picker</code> autoChild may be customized via the standard  {@link com.smartgwt.client.types.AutoChild} pattern.
     *
     * @return Current pickerConstructor value. Default value is "MultiFilePicker"
     * @see com.smartgwt.client.docs.SCClassName SCClassName 
     */
    public String getPickerConstructor()  {
        return getAttributeAsString("pickerConstructor");
    }
    

    /**
     * The initial title of the upload button in the picker lauched by the {@link
     * com.smartgwt.client.widgets.form.fields.MultiFileItem#getEditButton edit button} that is used before the form is saved.
     *
     * @param pickerUploadButtonInitialTitle New pickerUploadButtonInitialTitle value. Default value is "OK"
     * @return {@link com.smartgwt.client.widgets.form.fields.MultiFileItem MultiFileItem} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.form.fields.MultiFileItem#setPickerUploadButtonTitle
     */
    public MultiFileItem setPickerUploadButtonInitialTitle(String pickerUploadButtonInitialTitle) {
        return (MultiFileItem)setAttribute("pickerUploadButtonInitialTitle", pickerUploadButtonInitialTitle);
    }

    /**
     * The initial title of the upload button in the picker lauched by the {@link
     * com.smartgwt.client.widgets.form.fields.MultiFileItem#getEditButton edit button} that is used before the form is saved.
     *
     * @return Current pickerUploadButtonInitialTitle value. Default value is "OK"
     * @see com.smartgwt.client.widgets.form.fields.MultiFileItem#getPickerUploadButtonTitle
     */
    public String getPickerUploadButtonInitialTitle()  {
        return getAttributeAsString("pickerUploadButtonInitialTitle");
    }
    

    /**
     * The title of the upload button in the picker lauched by the {@link
     * com.smartgwt.client.widgets.form.fields.MultiFileItem#getEditButton edit button} that is used after the form is saved.
     *
     * @param pickerUploadButtonTitle New pickerUploadButtonTitle value. Default value is "Save"
     * @return {@link com.smartgwt.client.widgets.form.fields.MultiFileItem MultiFileItem} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.form.fields.MultiFileItem#setPickerUploadButtonInitialTitle
     */
    public MultiFileItem setPickerUploadButtonTitle(String pickerUploadButtonTitle) {
        return (MultiFileItem)setAttribute("pickerUploadButtonTitle", pickerUploadButtonTitle);
    }

    /**
     * The title of the upload button in the picker lauched by the {@link
     * com.smartgwt.client.widgets.form.fields.MultiFileItem#getEditButton edit button} that is used after the form is saved.
     *
     * @return Current pickerUploadButtonTitle value. Default value is "Save"
     * @see com.smartgwt.client.widgets.form.fields.MultiFileItem#getPickerUploadButtonInitialTitle
     */
    public String getPickerUploadButtonTitle()  {
        return getAttributeAsString("pickerUploadButtonTitle");
    }
    

    /**
     * Specifies the label of the progress meter in the picker lauched by the {@link
     * com.smartgwt.client.widgets.form.fields.MultiFileItem#getEditButton edit button}.  This property is a dynamic string,
     * similar to the {@link com.smartgwt.client.widgets.Canvas#getDynamicContents Canvas.dynamicContents} feature, with the
     * variables <code>fileName</code> and <code>formattedFileSize</code>.
     *
     * @param pickerUploadProgressLabel New pickerUploadProgressLabel value. Default value is "Saving ${fileName} ${formattedFileSize}"
     * @return {@link com.smartgwt.client.widgets.form.fields.MultiFileItem MultiFileItem} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public MultiFileItem setPickerUploadProgressLabel(String pickerUploadProgressLabel) {
        return (MultiFileItem)setAttribute("pickerUploadProgressLabel", pickerUploadProgressLabel);
    }

    /**
     * Specifies the label of the progress meter in the picker lauched by the {@link
     * com.smartgwt.client.widgets.form.fields.MultiFileItem#getEditButton edit button}.  This property is a dynamic string,
     * similar to the {@link com.smartgwt.client.widgets.Canvas#getDynamicContents Canvas.dynamicContents} feature, with the
     * variables <code>fileName</code> and <code>formattedFileSize</code>.
     *
     * @return Current pickerUploadProgressLabel value. Default value is "Saving ${fileName} ${formattedFileSize}"
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public String getPickerUploadProgressLabel()  {
        return getAttributeAsString("pickerUploadProgressLabel");
    }
    
    

    /**
     * The {@link com.smartgwt.client.widgets.form.fields.FormItemIcon#getPrompt prompt} of the {@link
     * com.smartgwt.client.widgets.form.fields.MultiFileItem#getRemoveButton remove button}.
     *
     * @param removeButtonPrompt New removeButtonPrompt value. Default value is "Remove selected files"
     * @return {@link com.smartgwt.client.widgets.form.fields.MultiFileItem MultiFileItem} instance, for chaining setter calls
     */
    public MultiFileItem setRemoveButtonPrompt(String removeButtonPrompt) {
        return (MultiFileItem)setAttribute("removeButtonPrompt", removeButtonPrompt);
    }

    /**
     * The {@link com.smartgwt.client.widgets.form.fields.FormItemIcon#getPrompt prompt} of the {@link
     * com.smartgwt.client.widgets.form.fields.MultiFileItem#getRemoveButton remove button}.
     *
     * @return Current removeButtonPrompt value. Default value is "Remove selected files"
     */
    public String getRemoveButtonPrompt()  {
        return getAttributeAsString("removeButtonPrompt");
    }
    

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************

    // ***********************************************************

}
