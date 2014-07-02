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
 
package com.smartgwt.client.widgets;


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
import com.smartgwt.client.widgets.tab.*;
import com.smartgwt.client.widgets.toolbar.*;
import com.smartgwt.client.widgets.tree.*;
import com.smartgwt.client.widgets.tree.events.*;
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
import com.smartgwt.logicalstructure.widgets.rte.*;
import com.smartgwt.logicalstructure.widgets.tab.*;
import com.smartgwt.logicalstructure.widgets.tableview.*;
import com.smartgwt.logicalstructure.widgets.toolbar.*;
import com.smartgwt.logicalstructure.widgets.tree.*;
import com.smartgwt.logicalstructure.widgets.viewer.*;
import com.smartgwt.logicalstructure.widgets.calendar.*;
import com.smartgwt.logicalstructure.widgets.cube.*;
import com.smartgwt.logicalstructure.widgets.tools.*;

/**
 * The BatchUploader handles the upload, validation, review and saving of a dataset expressed in CSV or other upload
 * formats. <P> <p><b>NOTE:</b> BatchUploader is only available with Smart GWT Power or better. <p> By default, a
 * BatchUploader consists of a single {@link com.smartgwt.client.widgets.form.fields.FileItem} form field. This form field
 * will upload a file using the special "batchUpload" built-in DataSource. The uploaded file data will be parsed and
 * validated using the {@link com.smartgwt.client.widgets.BatchUploader#getUploadDataSource uploadDataSource}, then
 * streamed back to the browser, along with any errors, for display in a ListGrid.   <P> The user can then correct any
 * errors and submit the final dataset, which will be added to the DataSource via a series of "add" DSRequests, all
 * submitted as a single HTTP request via {@link com.smartgwt.client.rpc.RPCManager#startQueue request queuing}. <P>
 * Additional form fields can be added to the form that uploads the data file via  {@link
 * com.smartgwt.client.widgets.BatchUploader#getUploadFormFields uploadFormFields}.  Values entered into these fields are
 * not included in the "add" DSRequests used to store the uploaded records.  Instead, they are stored as HttpSession
 * attributes with the names corresponding to the  names of the specified <code>uploadFormFields</code> (optionally with a 
 * {@link com.smartgwt.client.widgets.BatchUploader#getUploadFieldPrefix prefix} applied, in case this is necessary to
 * avoid name collisions in the session).  This allows any custom logic for the "add" operation to access these additional
 * fields via httpSession.getAttribute(). If {@link com.smartgwt.client.widgets.BatchUploader#getUploadFormFields
 * uploadFormFields} are not provided method  httpSession.getAttribute() will not be called. <P> Because all records are
 * saved in a single HTTP request, a similar strategy of  storing data as servletRequest or session attributes allows reuse
 * of objects required to perform the "add" operations (such as field values common to all added records, or a SQL
 * connection or transaction manager).  <p> If {@link com.smartgwt.client.data.DataSourceField#getUploadFieldName
 * uploadFieldName} is set on any of the  {@link com.smartgwt.client.widgets.BatchUploader#getUploadDataSource
 * uploadDataSource}'s fields, the BatchUploader will use that name to map the uploaded file's content. <p> A couple of
 * server-side techniques are interesting in conjunction with the BatchUploader. One is to set the {@link
 * com.smartgwt.client.docs.serverds.DataSource#serverConstructor serverConstructor} property to point at your own class
 * that inherits from <code>com.isomorphic.datasource.BasicDataSource</code>.  The most interesting reason for doing this
 * is to override the <code>validate</code> method and provide complete custom validation - for example, checking relations
 * to other tables. <p> Another technique is to handle the initial Smart GWT call in your own servlet, by setting the 
 * {@link com.smartgwt.client.widgets.BatchUploader#getDataURL dataURL} property.  You then handle the add requests with a
 * combination of your own code and Smart GWT server API calls.  This is a  good way to add special pre- and
 * post-processing to the normal server-side flow. <p> The BatchUploader sample, provided as one of the databinding
 * examples, demonstrates both of these techniques.  We use a special subclass of DataSource and override the validate
 * method as described above; we also set {@link com.smartgwt.client.widgets.BatchUploader#getDataURL dataURL} to point at
 * a JSP that wraps the queue of Smart GWT requests inside a single database transaction (a servlet would be more usual,
 * but we use a JSP for ease of modification) <p> <b>Note:</b> The special "batchUpload" DataSource, which should reside in
 * the shared/ds  folder of your application's webroot (see   {@link com.smartgwt.client.docs.SgwtEESetup Installation
 * Instructions}). is not part of your application's data flow, and it has nothing to do with the  {@link
 * com.smartgwt.client.widgets.BatchUploader#getUploadDataSource uploadDataSource} you use to actually persist the
 * validated and error-corrected data: it is simply a means to uploading the raw data in the first place. Normally, you
 * should simply ignore its presence and treat it as an internal detail of the  Smart GWT framework. <p> However, there are
 * circumstances in which you may wish to change it to achieve specific aims. For example, you may wish to override the
 * Java class it invokes, in order to insert your own security or other validation logic into the initial upload flow. 
 * This is entirely in keeping with the design, but we regard it as an out-of-the-ordinary use-case: normal usage is simply
 *  to ignore the presence of the batchUpload DataSource.
 */
@BeanFactory.FrameworkClass
@BeanFactory.ScClassName("BatchUploader")
public class BatchUploader extends Canvas {

    public static BatchUploader getOrCreateRef(JavaScriptObject jsObj) {
        if (jsObj == null) return null;
        final BaseWidget refInstance = BaseWidget.getRef(jsObj);
        if (refInstance == null) {
            // Instantiate the deprecated `BatchUploader' class to prevent a possible
            // `ClassCastException' until officially removed.
            if ("Power".equals(SC.getLicenseType())) {
                return new com.smartgwtpower.client.widgets.BatchUploader(jsObj);
            } else {
                return new com.smartgwtee.client.widgets.BatchUploader(jsObj);
            }
        } else {
            assert refInstance instanceof BatchUploader;
            return (BatchUploader)refInstance;
        }
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
        $wnd.isc.BatchUploader.changeDefaults(autoChildName + "Defaults", defaults.@com.smartgwt.client.widgets.Canvas::getConfig()());
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
        $wnd.isc.BatchUploader.changeDefaults(autoChildName + "Defaults", defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getJsObj()());
    }-*/;

    public BatchUploader(){
        scClassName = "BatchUploader";
    }

    public BatchUploader(JavaScriptObject jsObj){
        scClassName = "BatchUploader";
        setJavaScriptObject(jsObj);
    }

    protected native JavaScriptObject create()/*-{
        if (!$wnd.isc.BatchUploader) {
            var errorMessage = "Attempt to create BatchUploader. This class requires Smart GWT Enterprise or Eval.";
            @com.smartgwt.client.util.SC::logWarn(Ljava/lang/String;)(errorMessage);
            throw @java.lang.UnsupportedOperationException::new(Ljava/lang/String;)(errorMessage);
        }
        var config = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
        var widget = $wnd.isc[scClassName].create(config);
        if ($wnd.isc.keepGlobals) this.@com.smartgwt.client.widgets.BaseWidget::internalSetID(Lcom/google/gwt/core/client/JavaScriptObject;)(widget);
        this.@com.smartgwt.client.widgets.BaseWidget::doInit()();
        return widget;
    }-*/;

    // ********************* Properties / Attributes ***********************

    /**
     * Button that cancels the uncommitted upload.
     * <p>
     * For an overview of how to use and configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return IButton
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public IButton getCancelButton() throws IllegalStateException {
        errorIfNotCreated("cancelButton");
        return (IButton)IButton.getByJSObject(getAttributeAsJavaScriptObject("cancelButton"));
    }
    

    /**
     * Confirmation message to show if the user clicks the "Cancel" button and {@link
     * com.smartgwt.client.widgets.BatchUploader#getWarnOnCancel warnOnCancel} is true.  Defaults to "You will lose any work
     * you have done on this data. Proceed anyway?"
     *
     * @param cancelConfirmMessage  Default value is See below
     */
    public void setCancelConfirmMessage(String cancelConfirmMessage) {
        setAttribute("cancelConfirmMessage", cancelConfirmMessage, true);
    }

    /**
     * Confirmation message to show if the user clicks the "Cancel" button and {@link
     * com.smartgwt.client.widgets.BatchUploader#getWarnOnCancel warnOnCancel} is true.  Defaults to "You will lose any work
     * you have done on this data. Proceed anyway?"
     *
     * @return String
     */
    public String getCancelConfirmMessage()  {
        return getAttributeAsString("cancelConfirmMessage");
    }
    

    /**
     * Button that commits changes once the user is happy with the data.
     * <p>
     * For an overview of how to use and configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return IButton
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public IButton getCommitButton() throws IllegalStateException {
        errorIfNotCreated("commitButton");
        return (IButton)IButton.getByJSObject(getAttributeAsJavaScriptObject("commitButton"));
    }
    

    /**
     * Message to display after data has been committed, when  {@link
     * com.smartgwt.client.widgets.BatchUploader#getShowCommitConfirmation showCommitConfirmation} is true.
     *
     * @param commitConfirmationMessage  Default value is "Records added"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setCommitConfirmationMessage(String commitConfirmationMessage)  throws IllegalStateException {
        setAttribute("commitConfirmationMessage", commitConfirmationMessage, false);
    }

    /**
     * Message to display after data has been committed, when  {@link
     * com.smartgwt.client.widgets.BatchUploader#getShowCommitConfirmation showCommitConfirmation} is true.
     *
     * @return String
     */
    public String getCommitConfirmationMessage()  {
        return getAttributeAsString("commitConfirmationMessage");
    }
    

    /**
     * If set, the batchUploader will copy this value to the queue of "add" requests it sends  to the server to actually
     * populate the data.  You can use this facility to route the  queue to your own server-side logic, for example to add pre-
     * or post-processing.
     *
     * @param dataURL  Default value is null
     */
    public void setDataURL(String dataURL) {
        setAttribute("dataURL", dataURL, true);
    }

    /**
     * If set, the batchUploader will copy this value to the queue of "add" requests it sends  to the server to actually
     * populate the data.  You can use this facility to route the  queue to your own server-side logic, for example to add pre-
     * or post-processing.
     *
     * @return String
     */
    public String getDataURL()  {
        return getAttributeAsString("dataURL");
    }
    

    /**
     * The delimiter to use when importing character-delimited files.  The default is comma (CSV).
     *
     * @param defaultDelimiter  Default value is ","
     */
    public void setDefaultDelimiter(String defaultDelimiter) {
        setAttribute("defaultDelimiter", defaultDelimiter, true);
    }

    /**
     * The delimiter to use when importing character-delimited files.  The default is comma (CSV).
     *
     * @return String
     */
    public String getDefaultDelimiter()  {
        return getAttributeAsString("defaultDelimiter");
    }
    

    /**
     * The default character used to quote strings.
     *
     * @param defaultQuoteString  Default value is "\""
     */
    public void setDefaultQuoteString(String defaultQuoteString) {
        setAttribute("defaultQuoteString", defaultQuoteString, true);
    }

    /**
     * The default character used to quote strings.
     *
     * @return String
     */
    public String getDefaultQuoteString()  {
        return getAttributeAsString("defaultQuoteString");
    }
    

    /**
     * Grid which will show a preview of data to be uploaded, with errors flagged
     * <p>
     * For an overview of how to use and configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return ListGrid
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public ListGrid getGrid() throws IllegalStateException {
        errorIfNotCreated("grid");
        return (ListGrid)ListGrid.getByJSObject(getAttributeAsJavaScriptObject("grid"));
    }
    

    /**
     * Fields to apply to {@link com.smartgwt.client.widgets.BatchUploader#getGrid grid}.  These will override the field
     * definitions in the {@link com.smartgwt.client.widgets.BatchUploader#getUploadDataSource uploadDataSource} on a field by
     * field basis, as described under {@link com.smartgwt.client.widgets.DataBoundComponent#getFields fields}.
     *
     * @param gridFields  Default value is null
     */
    public void setGridFields(ListGridField... gridFields) {
        setAttribute("gridFields", gridFields, true);
    }

    /**
     * Fields to apply to {@link com.smartgwt.client.widgets.BatchUploader#getGrid grid}.  These will override the field
     * definitions in the {@link com.smartgwt.client.widgets.BatchUploader#getUploadDataSource uploadDataSource} on a field by
     * field basis, as described under {@link com.smartgwt.client.widgets.DataBoundComponent#getFields fields}.
     *
     * @return ListGridField...
     */
    public ListGridField[] getGridFields()  {
        return com.smartgwt.client.util.ConvertTo.arrayOfListGridField(getAttributeAsJavaScriptObject("gridFields"));
    }
    

    /**
     * Specifies what action to take if the user attempts to commit a partially validated set of data (ie, one that still
     * contains some errors).
     *
     * @param partialCommit  Default value is "prompt"
     */
    public void setPartialCommit(PartialCommitOption partialCommit) {
        setAttribute("partialCommit", partialCommit == null ? null : partialCommit.getValue(), true);
    }

    /**
     * Specifies what action to take if the user attempts to commit a partially validated set of data (ie, one that still
     * contains some errors).
     *
     * @return PartialCommitOption
     */
    public PartialCommitOption getPartialCommit()  {
        return EnumUtil.getEnum(PartialCommitOption.values(), getAttribute("partialCommit"));
    }
    

    /**
     * If {@link com.smartgwt.client.widgets.BatchUploader#getPartialCommit partialCommit} is set to "prevent", the text to
     * display to the user if they try  to commit a dataset containing errors.  By default, this text is "There are errors in
     * your  data.  Please correct all errors before clicking Commit"
     *
     * @param partialCommitError  Default value is See below
     */
    public void setPartialCommitError(String partialCommitError) {
        setAttribute("partialCommitError", partialCommitError, true);
    }

    /**
     * If {@link com.smartgwt.client.widgets.BatchUploader#getPartialCommit partialCommit} is set to "prevent", the text to
     * display to the user if they try  to commit a dataset containing errors.  By default, this text is "There are errors in
     * your  data.  Please correct all errors before clicking Commit"
     *
     * @return String
     */
    public String getPartialCommitError()  {
        return getAttributeAsString("partialCommitError");
    }
    

    /**
     * If {@link com.smartgwt.client.widgets.BatchUploader#getPartialCommit partialCommit} is set to "prompt", the text to
     * display to the user in the  confirmation dialog.  By default, this text is "There are errors in your data so it  cannot
     * all be saved.  If you proceed, you will lose the records with errors.  Click 'OK' to proceed anyway, or 'Cancel' to
     * return to your data"
     *
     * @param partialCommitPrompt  Default value is See below
     */
    public void setPartialCommitPrompt(String partialCommitPrompt) {
        setAttribute("partialCommitPrompt", partialCommitPrompt, true);
    }

    /**
     * If {@link com.smartgwt.client.widgets.BatchUploader#getPartialCommit partialCommit} is set to "prompt", the text to
     * display to the user in the  confirmation dialog.  By default, this text is "There are errors in your data so it  cannot
     * all be saved.  If you proceed, you will lose the records with errors.  Click 'OK' to proceed anyway, or 'Cancel' to
     * return to your data"
     *
     * @return String
     */
    public String getPartialCommitPrompt()  {
        return getAttributeAsString("partialCommitPrompt");
    }
    

    /**
     * Object containing properties to send with every "add" request this batchUploader sends.
     *
     * @param requestProperties  Default value is null
     */
    public void setRequestProperties(Map requestProperties) {
        setAttribute("requestProperties", requestProperties, true);
    }

    /**
     * Object containing properties to send with every "add" request this batchUploader sends.
     *
     * @return Map
     */
    public Map getRequestProperties()  {
        return getAttributeAsMap("requestProperties");
    }
    

    /**
     * Whether to show the {@link com.smartgwt.client.widgets.BatchUploader#getCommitConfirmationMessage commit message} after
     * data is successfully committed.
     *
     * @param showCommitConfirmation  Default value is true
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setShowCommitConfirmation(Boolean showCommitConfirmation)  throws IllegalStateException {
        setAttribute("showCommitConfirmation", showCommitConfirmation, false);
    }

    /**
     * Whether to show the {@link com.smartgwt.client.widgets.BatchUploader#getCommitConfirmationMessage commit message} after
     * data is successfully committed.
     *
     * @return Boolean
     */
    public Boolean getShowCommitConfirmation()  {
        return getAttributeAsBoolean("showCommitConfirmation");
    }
    

    /**
     * Button that triggers the upload.
     * <p>
     * For an overview of how to use and configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return IButton
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public IButton getUploadButton() throws IllegalStateException {
        errorIfNotCreated("uploadButton");
        return (IButton)IButton.getByJSObject(getAttributeAsJavaScriptObject("uploadButton"));
    }
    

    /**
     * Title for the {@link com.smartgwt.client.widgets.BatchUploader#getUploadButton upload button}.
     *
     * @param uploadButtonTitle  Default value is "Upload"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setUploadButtonTitle(String uploadButtonTitle)  throws IllegalStateException {
        setAttribute("uploadButtonTitle", uploadButtonTitle, false);
    }

    /**
     * Title for the {@link com.smartgwt.client.widgets.BatchUploader#getUploadButton upload button}.
     *
     * @return String
     */
    public String getUploadButtonTitle()  {
        return getAttributeAsString("uploadButtonTitle");
    }
    

    /**
     * DataSource used to save uploaded records.  Should have an operation of type "add". <p> Be careful to note that this is
     * the DataSource representing your data as it will be  persisted to your server.  It is completely different from the
     * special "batchUpload" DataSource which is used purely as a medium to upload the raw data to the server in the first
     * place.
     *
     * @param uploadDataSource  Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setUploadDataSource(DataSource uploadDataSource)  throws IllegalStateException {
        setAttribute("uploadDataSource", uploadDataSource == null ? null : uploadDataSource.getOrCreateJsObj(), false);
    }

    /**
     * DataSource used to save uploaded records.  Should have an operation of type "add". <p> Be careful to note that this is
     * the DataSource representing your data as it will be  persisted to your server.  It is completely different from the
     * special "batchUpload" DataSource which is used purely as a medium to upload the raw data to the server in the first
     * place.
     *
     * @return DataSource
     */
    public DataSource getUploadDataSource()  {
        return DataSource.getOrCreateRef(getAttributeAsJavaScriptObject("uploadDataSource"));
    }
    

    /**
     * String to prepend to the names of the additional fields specified in {@link
     * com.smartgwt.client.widgets.BatchUploader#getUploadFormFields uploadFormFields}  before they are stored in the
     * HttpSession on the server.  This property provides a basic namespace facility, allowing you to avoid name collisions
     * with existing session attributes. <P> Example usage: if you have an additional field called "someDate" and you set 
     * uploadFieldPrefix to "myFields_", your additionalFormField will be available as an HttpSession attribute called
     * "myFields_someDate"
     *
     * @param uploadFieldPrefix  Default value is null
     */
    public void setUploadFieldPrefix(String uploadFieldPrefix) {
        setAttribute("uploadFieldPrefix", uploadFieldPrefix, true);
    }

    /**
     * String to prepend to the names of the additional fields specified in {@link
     * com.smartgwt.client.widgets.BatchUploader#getUploadFormFields uploadFormFields}  before they are stored in the
     * HttpSession on the server.  This property provides a basic namespace facility, allowing you to avoid name collisions
     * with existing session attributes. <P> Example usage: if you have an additional field called "someDate" and you set 
     * uploadFieldPrefix to "myFields_", your additionalFormField will be available as an HttpSession attribute called
     * "myFields_someDate"
     *
     * @return String
     */
    public String getUploadFieldPrefix()  {
        return getAttributeAsString("uploadFieldPrefix");
    }
    

    /**
     * Title to display next to the {@link com.smartgwt.client.widgets.form.fields.FileItem} field where the user enters a
     * filename to upload
     *
     * @param uploadFileLabel  Default value is "Upload File"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setUploadFileLabel(String uploadFileLabel)  throws IllegalStateException {
        setAttribute("uploadFileLabel", uploadFileLabel, false);
    }

    /**
     * Title to display next to the {@link com.smartgwt.client.widgets.form.fields.FileItem} field where the user enters a
     * filename to upload
     *
     * @return String
     */
    public String getUploadFileLabel()  {
        return getAttributeAsString("uploadFileLabel");
    }
    

    /**
     * Form used to specify file to upload, and any additional fields required.
     * <p>
     * For an overview of how to use and configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return DynamicForm
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public DynamicForm getUploadForm() throws IllegalStateException {
        errorIfNotCreated("uploadForm");
        return (DynamicForm)DynamicForm.getByJSObject(getAttributeAsJavaScriptObject("uploadForm"));
    }
    

    /**
     * Optional fields for the uploadForm.
     *
     * @param uploadFormFields  Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setUploadFormFields(FormItem... uploadFormFields)  throws IllegalStateException {
        setAttribute("uploadFormFields", uploadFormFields, false);
    }

    /**
     * Optional fields for the uploadForm.
     *
     * @return FormItem...
     */
    public FormItem[] getUploadFormFields()  {
        return com.smartgwt.client.util.ConvertTo.arrayOfFormItem(getAttributeAsJavaScriptObject("uploadFormFields"));
    }
    

    /**
     * Optional {@link com.smartgwt.client.data.DSRequest#getOperationId operationId} for the "add" operation used to add new
     * records to the {@link com.smartgwt.client.widgets.BatchUploader#getUploadDataSource uploadDataSource}.
     *
     * @param uploadOperation  Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setUploadOperation(String uploadOperation)  throws IllegalStateException {
        setAttribute("uploadOperation", uploadOperation, false);
    }

    /**
     * Optional {@link com.smartgwt.client.data.DSRequest#getOperationId operationId} for the "add" operation used to add new
     * records to the {@link com.smartgwt.client.widgets.BatchUploader#getUploadDataSource uploadDataSource}.
     *
     * @return String
     */
    public String getUploadOperation()  {
        return getAttributeAsString("uploadOperation");
    }
    

    /**
     * If set, indicates that a warning dialog should be shown when Cancel is clicked, asking  the user to confirm that this is
     * really what they want to do. The actual warning message is specified with {@link
     * com.smartgwt.client.widgets.BatchUploader#getCancelConfirmMessage cancelConfirmMessage}
     *
     * @param warnOnCancel  Default value is true
     */
    public void setWarnOnCancel(Boolean warnOnCancel) {
        setAttribute("warnOnCancel", warnOnCancel, true);
    }

    /**
     * If set, indicates that a warning dialog should be shown when Cancel is clicked, asking  the user to confirm that this is
     * really what they want to do. The actual warning message is specified with {@link
     * com.smartgwt.client.widgets.BatchUploader#getCancelConfirmMessage cancelConfirmMessage}
     *
     * @return Boolean
     */
    public Boolean getWarnOnCancel()  {
        return getAttributeAsBoolean("warnOnCancel");
    }
    

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************

    /** 
     * Class level method to set the default properties of this class.  If set, then all
     * existing and subsequently created instances of this class will automatically have
     * default properties corresponding to
     * the properties set on the SmartGWT class instance passed to this function before its
     * underlying SmartClient JS object was created.
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
     * @param batchUploaderProperties properties that should be used as new defaults when instances of this class are created
     */
    public static native void setDefaultProperties(BatchUploader batchUploaderProperties) /*-{
    	var properties = $wnd.isc.addProperties({},batchUploaderProperties.@com.smartgwt.client.widgets.BaseWidget::getConfig()());
        @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(properties,false);
        $wnd.isc.BatchUploader.addProperties(properties);
    }-*/;

    // ***********************************************************



    /**
     * Synonym of {@link #setUploadFormFields(FormItem...)}.
     */
    public void setUploadFormItems(FormItem... items) throws IllegalStateException {
        setUploadFormFields(items);
    }

    public LogicalStructureObject setLogicalStructure(BatchUploaderLogicalStructure s) {
        super.setLogicalStructure(s);
        try {
            s.cancelConfirmMessage = getAttributeAsString("cancelConfirmMessage");
        } catch (Throwable t) {
            s.logicalStructureErrors += "BatchUploader.cancelConfirmMessage:" + t.getMessage() + "\n";
        }
        try {
            s.commitConfirmationMessage = getAttributeAsString("commitConfirmationMessage");
        } catch (Throwable t) {
            s.logicalStructureErrors += "BatchUploader.commitConfirmationMessage:" + t.getMessage() + "\n";
        }
        try {
            s.dataURL = getAttributeAsString("dataURL");
        } catch (Throwable t) {
            s.logicalStructureErrors += "BatchUploader.dataURL:" + t.getMessage() + "\n";
        }
        try {
            s.defaultDelimiter = getAttributeAsString("defaultDelimiter");
        } catch (Throwable t) {
            s.logicalStructureErrors += "BatchUploader.defaultDelimiter:" + t.getMessage() + "\n";
        }
        try {
            s.defaultQuoteString = getAttributeAsString("defaultQuoteString");
        } catch (Throwable t) {
            s.logicalStructureErrors += "BatchUploader.defaultQuoteString:" + t.getMessage() + "\n";
        }
        try {
            s.partialCommit = getAttributeAsString("partialCommit");
        } catch (Throwable t) {
            s.logicalStructureErrors += "BatchUploader.partialCommit:" + t.getMessage() + "\n";
        }
        try {
            s.partialCommitError = getAttributeAsString("partialCommitError");
        } catch (Throwable t) {
            s.logicalStructureErrors += "BatchUploader.partialCommitError:" + t.getMessage() + "\n";
        }
        try {
            s.partialCommitPrompt = getAttributeAsString("partialCommitPrompt");
        } catch (Throwable t) {
            s.logicalStructureErrors += "BatchUploader.partialCommitPrompt:" + t.getMessage() + "\n";
        }
        try {
            s.requestProperties = getAttributeAsString("requestProperties");
        } catch (Throwable t) {
            s.logicalStructureErrors += "BatchUploader.requestProperties:" + t.getMessage() + "\n";
        }
        try {
            s.showCommitConfirmation = getAttributeAsString("showCommitConfirmation");
        } catch (Throwable t) {
            s.logicalStructureErrors += "BatchUploader.showCommitConfirmation:" + t.getMessage() + "\n";
        }
        try {
            s.uploadButtonTitle = getAttributeAsString("uploadButtonTitle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "BatchUploader.uploadButtonTitle:" + t.getMessage() + "\n";
        }
        try {
            s.uploadDataSource = getUploadDataSource();
        } catch (Throwable t) {
            s.logicalStructureErrors += "BatchUploader.uploadDataSource:" + t.getMessage() + "\n";
        }
        try {
            s.uploadFieldPrefix = getAttributeAsString("uploadFieldPrefix");
        } catch (Throwable t) {
            s.logicalStructureErrors += "BatchUploader.uploadFieldPrefix:" + t.getMessage() + "\n";
        }
        try {
            s.uploadFileLabel = getAttributeAsString("uploadFileLabel");
        } catch (Throwable t) {
            s.logicalStructureErrors += "BatchUploader.uploadFileLabel:" + t.getMessage() + "\n";
        }
        try {
            s.uploadFormFields = getAttributeAsStringArray("uploadFormFields");
        } catch (Throwable t) {
            s.logicalStructureErrors += "BatchUploader.uploadFormFieldsArray:" + t.getMessage() + "\n";
        }
        try {
            s.uploadOperation = getAttributeAsString("uploadOperation");
        } catch (Throwable t) {
            s.logicalStructureErrors += "BatchUploader.uploadOperation:" + t.getMessage() + "\n";
        }
        try {
            s.warnOnCancel = getAttributeAsString("warnOnCancel");
        } catch (Throwable t) {
            s.logicalStructureErrors += "BatchUploader.warnOnCancel:" + t.getMessage() + "\n";
        }
        return s;
    }

    public LogicalStructureObject getLogicalStructure() {
        BatchUploaderLogicalStructure s = new BatchUploaderLogicalStructure();
        setLogicalStructure(s);
        return s;
    }
}

