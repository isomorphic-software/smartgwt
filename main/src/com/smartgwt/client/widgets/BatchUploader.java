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
import com.smartgwt.logicalstructure.widgets.ace.*;
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
 * streamed back to the browser, along with any errors, for display in a ListGrid.   <P> The {@link
 * com.smartgwt.client.widgets.BatchUploader#addPreviewShownHandler BatchUploader.previewShown()} notification method will
 * be fired when the uploaded records are being displayed in this grid. <P> The user can then correct any errors and submit
 * the final dataset, which will be added to the DataSource via a series of "add" DSRequests, all submitted as a single
 * HTTP request via {@link com.smartgwt.client.rpc.RPCManager#startQueue request queuing}.<br> Developers may specify a
 * custom "add" operation to use on the target  {@link com.smartgwt.client.widgets.BatchUploader#getUploadDataSource
 * uploadDataSource} via the {@link com.smartgwt.client.widgets.BatchUploader#getUploadOperation uploadOperation} 
 * property. <P> Additional form fields can be added to the form that uploads the data file via  {@link
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
 * uploadDataSource}'s fields, the BatchUploader will use that name to map the uploaded file's content. <p> Note, that for
 * {@link com.smartgwt.client.widgets.BatchUploader#getDataFormat CSV data format} header line is optional. If  first
 * non-empty line in the uploaded file has no matching field names, it is assumed that  there's no header row, and all rows
 * (including the first one) are treated as data rows. <p> Imported data can be transformed during import, see {@link
 * com.smartgwt.client.docs.serverds.DataSourceField#importStrategy DataSourceField.importStrategy} for details. <p> A
 * couple of server-side techniques are interesting in conjunction with the BatchUploader. One is to set the {@link
 * com.smartgwt.client.docs.serverds.DataSource#serverConstructor DataSource.serverConstructor} property to point at your
 * own class that inherits from <code>com.isomorphic.datasource.BasicDataSource</code>.  The most interesting reason for
 * doing this is to override the <code>validate</code> method and provide complete custom validation - for example,
 * checking relations to other tables. <p> Another technique is to handle the initial Smart GWT call in your own servlet,
 * by setting the  {@link com.smartgwt.client.widgets.BatchUploader#getDataURL dataURL} property.  You then handle the add
 * requests with a combination of your own code and Smart GWT server API calls.  This is a  good way to add special pre-
 * and post-processing to the normal server-side flow. <p> <b>Note:</b> The special "batchUpload" DataSource, which should
 * reside in the shared/ds  folder of your application's webroot (see   {@link com.smartgwt.client.docs.SgwtEESetup
 * Installation Instructions}). is not part of your application's data flow, and it has nothing to do with the  {@link
 * com.smartgwt.client.widgets.BatchUploader#getUploadDataSource uploadDataSource} you use to actually persist the
 * validated and error-corrected data: it is simply a means to uploading the raw data in the first place. Normally, you
 * should simply ignore its presence and treat it as an internal detail of the  Smart GWT framework. <p> However, there are
 * circumstances in which you may wish to change it to achieve specific aims. For example, you may wish to override the
 * Java class it invokes, in order to insert your own security or other validation logic into the initial upload flow. 
 * This is entirely in keeping with the design, but we regard it as an out-of-the-ordinary use-case: normal usage is simply
 * to ignore the presence of the batchUpload DataSource. <p> BatchUploader is a {@link
 * com.smartgwt.client.widgets.layout.VStack}, that simply stacks members on the vertical axis without trying to manage
 * their height. If you need to control heights, you can set  {@link com.smartgwt.client.widgets.layout.Layout#getVPolicy
 * vPolicy} to "fill"
 */
@BeanFactory.FrameworkClass
@BeanFactory.ScClassName("BatchUploader")
public class BatchUploader extends VStack implements com.smartgwt.client.widgets.com.smartgwt.client.widgets.events.HasPreviewShownHandlers {

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
     * without destroying or wiping out non-overridden properties.  For usage tips on this
     * param, see {@link com.smartgwt.client.docs.SGWTProperties}.
     * @see com.smartgwt.client.docs.AutoChildUsage
     */
    public static native void changeAutoChildDefaults(String autoChildName, Canvas defaults) /*-{
        if (defaults.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(BatchUploader.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "Canvas");
        }
        defaults.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
        var cleanDefaultsJS = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(defaults.@com.smartgwt.client.widgets.BaseWidget::getConfig()(), true);
        $wnd.isc.BatchUploader.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(BatchUploader.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "FormItem");
        }
        defaults.@com.smartgwt.client.widgets.form.fields.FormItem::setConfigOnly(Z)(true);
    	var cleanDefaultsJS = defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getEditorTypeConfig()();
        $wnd.isc.BatchUploader.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
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
     * Message to display when the user clicks "Commit" but there is nothing we can commit because every row in the grid has
     * errors
     *
     * @param allRecordsInErrorMessage New allRecordsInErrorMessage value. Default value is "All records have errors; nothing to commit"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setAllRecordsInErrorMessage(String allRecordsInErrorMessage)  throws IllegalStateException {
        setAttribute("allRecordsInErrorMessage", allRecordsInErrorMessage, false);
    }

    /**
     * Message to display when the user clicks "Commit" but there is nothing we can commit because every row in the grid has
     * errors
     *
     * @return Current allRecordsInErrorMessage value. Default value is "All records have errors; nothing to commit"
     */
    public String getAllRecordsInErrorMessage()  {
        return getAttributeAsString("allRecordsInErrorMessage");
    }
    

    /**
     * Controls if server-side API <i>BatchUpload.parseUploadData(...)</i> will convert imported boolean fields values to
     * actual <i>Booleans</i> or will leave them as <i>Strings</i>. The default is true. <p> Default behavior would interpret
     * boolean values by following rules: <ul> <li>Accept all caps permutations of "true"/"false", "yes"/"no", and "null"
     * <li>"T" == true, "F" == false <li>"Y" == true, "N" == false <li>"0" is false <li>empty string is null <li>everything
     * else is true </ul>
     *
     * @param autoInterpretBooleans New autoInterpretBooleans value. Default value is true
     */
    public void setAutoInterpretBooleans(Boolean autoInterpretBooleans) {
        setAttribute("autoInterpretBooleans", autoInterpretBooleans, true);
    }

    /**
     * Controls if server-side API <i>BatchUpload.parseUploadData(...)</i> will convert imported boolean fields values to
     * actual <i>Booleans</i> or will leave them as <i>Strings</i>. The default is true. <p> Default behavior would interpret
     * boolean values by following rules: <ul> <li>Accept all caps permutations of "true"/"false", "yes"/"no", and "null"
     * <li>"T" == true, "F" == false <li>"Y" == true, "N" == false <li>"0" is false <li>empty string is null <li>everything
     * else is true </ul>
     *
     * @return Current autoInterpretBooleans value. Default value is true
     */
    public Boolean getAutoInterpretBooleans()  {
        Boolean result = getAttributeAsBoolean("autoInterpretBooleans");
        return result == null ? true : result;
    }
    

    /**
     * Button that cancels the uncommitted upload.
     * <p>
     * This component is an AutoChild named "cancelButton".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current cancelButton value. Default value is null
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public IButton getCancelButton() throws IllegalStateException {
        errorIfNotCreated("cancelButton");
        return (IButton)IButton.getByJSObject(getAttributeAsJavaScriptObject("cancelButton"));
    }
    

    /**
     * Title for the {@link com.smartgwt.client.widgets.BatchUploader#getCancelButton cancel button}.
     *
     * @param cancelButtonTitle New cancelButtonTitle value. Default value is "Cancel"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setCancelButtonTitle(String cancelButtonTitle)  throws IllegalStateException {
        setAttribute("cancelButtonTitle", cancelButtonTitle, false);
    }

    /**
     * Title for the {@link com.smartgwt.client.widgets.BatchUploader#getCancelButton cancel button}.
     *
     * @return Current cancelButtonTitle value. Default value is "Cancel"
     */
    public String getCancelButtonTitle()  {
        return getAttributeAsString("cancelButtonTitle");
    }
    

    /**
     * Confirmation message to show if the user clicks the "Cancel" button and {@link
     * com.smartgwt.client.widgets.BatchUploader#getWarnOnCancel warnOnCancel} is true.  Defaults to "You will lose any work
     * you have done on this data. Proceed anyway?"
     *
     * @param cancelConfirmMessage New cancelConfirmMessage value. Default value is See below
     */
    public void setCancelConfirmMessage(String cancelConfirmMessage) {
        setAttribute("cancelConfirmMessage", cancelConfirmMessage, true);
    }

    /**
     * Confirmation message to show if the user clicks the "Cancel" button and {@link
     * com.smartgwt.client.widgets.BatchUploader#getWarnOnCancel warnOnCancel} is true.  Defaults to "You will lose any work
     * you have done on this data. Proceed anyway?"
     *
     * @return Current cancelConfirmMessage value. Default value is See below
     */
    public String getCancelConfirmMessage()  {
        return getAttributeAsString("cancelConfirmMessage");
    }
    

    /**
     * Button that commits changes once the user is happy with the data.
     * <p>
     * This component is an AutoChild named "commitButton".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current commitButton value. Default value is null
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public IButton getCommitButton() throws IllegalStateException {
        errorIfNotCreated("commitButton");
        return (IButton)IButton.getByJSObject(getAttributeAsJavaScriptObject("commitButton"));
    }
    

    /**
     * Title for the {@link com.smartgwt.client.widgets.BatchUploader#getCommitButton commit button}.
     *
     * @param commitButtonTitle New commitButtonTitle value. Default value is "Commit"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setCommitButtonTitle(String commitButtonTitle)  throws IllegalStateException {
        setAttribute("commitButtonTitle", commitButtonTitle, false);
    }

    /**
     * Title for the {@link com.smartgwt.client.widgets.BatchUploader#getCommitButton commit button}.
     *
     * @return Current commitButtonTitle value. Default value is "Commit"
     */
    public String getCommitButtonTitle()  {
        return getAttributeAsString("commitButtonTitle");
    }
    

    /**
     * Message to display after data has been committed, when  {@link
     * com.smartgwt.client.widgets.BatchUploader#getShowCommitConfirmation showCommitConfirmation} is true.
     *
     * @param commitConfirmationMessage New commitConfirmationMessage value. Default value is "Records added"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setCommitConfirmationMessage(String commitConfirmationMessage)  throws IllegalStateException {
        setAttribute("commitConfirmationMessage", commitConfirmationMessage, false);
    }

    /**
     * Message to display after data has been committed, when  {@link
     * com.smartgwt.client.widgets.BatchUploader#getShowCommitConfirmation showCommitConfirmation} is true.
     *
     * @return Current commitConfirmationMessage value. Default value is "Records added"
     */
    public String getCommitConfirmationMessage()  {
        return getAttributeAsString("commitConfirmationMessage");
    }
    

    /**
     * Format to assume for user-provided data.  Use {@link com.smartgwt.client.types.ImportFormat} "auto" for auto-detection.
     *
     * @param dataFormat New dataFormat value. Default value is "csv"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setDataFormat(ImportFormat dataFormat)  throws IllegalStateException {
        setAttribute("dataFormat", dataFormat == null ? null : dataFormat.getValue(), false);
    }

    /**
     * Format to assume for user-provided data.  Use {@link com.smartgwt.client.types.ImportFormat} "auto" for auto-detection.
     *
     * @return Current dataFormat value. Default value is "csv"
     */
    public ImportFormat getDataFormat()  {
        return EnumUtil.getEnum(ImportFormat.values(), getAttribute("dataFormat"));
    }
    

    /**
     * If set, the batchUploader will copy this value to the queue of "add" requests it sends  to the server to actually
     * populate the data.  You can use this facility to route the  queue to your own server-side logic, for example to add pre-
     * or post-processing.
     *
     * @param dataURL New dataURL value. Default value is null
     */
    public void setDataURL(String dataURL) {
        setAttribute("dataURL", dataURL, true);
    }

    /**
     * If set, the batchUploader will copy this value to the queue of "add" requests it sends  to the server to actually
     * populate the data.  You can use this facility to route the  queue to your own server-side logic, for example to add pre-
     * or post-processing.
     *
     * @return Current dataURL value. Default value is null
     */
    public String getDataURL()  {
        return getAttributeAsString("dataURL");
    }
    

    /**
     * The delimiter to use when importing character-delimited files.  The default is comma (CSV).
     *
     * @param defaultDelimiter New defaultDelimiter value. Default value is ","
     * @deprecated in favor of {@link com.smartgwt.client.widgets.BatchUploader#getUploadDelimiter uploadDelimiter}
     */
    public void setDefaultDelimiter(String defaultDelimiter) {
        setAttribute("defaultDelimiter", defaultDelimiter, true);
    }

    /**
     * The delimiter to use when importing character-delimited files.  The default is comma (CSV).
     *
     * @return Current defaultDelimiter value. Default value is ","
     * @deprecated in favor of {@link com.smartgwt.client.widgets.BatchUploader#getUploadDelimiter uploadDelimiter}
     */
    public String getDefaultDelimiter()  {
        return getAttributeAsString("defaultDelimiter");
    }
    

    /**
     * The default character used to quote strings.
     *
     * @param defaultQuoteString New defaultQuoteString value. Default value is "\""
     * @deprecated in favor of {@link com.smartgwt.client.widgets.BatchUploader#getUploadQuoteString uploadQuoteString}
     */
    public void setDefaultQuoteString(String defaultQuoteString) {
        setAttribute("defaultQuoteString", defaultQuoteString, true);
    }

    /**
     * The default character used to quote strings.
     *
     * @return Current defaultQuoteString value. Default value is "\""
     * @deprecated in favor of {@link com.smartgwt.client.widgets.BatchUploader#getUploadQuoteString uploadQuoteString}
     */
    public String getDefaultQuoteString()  {
        return getAttributeAsString("defaultQuoteString");
    }
    

    /**
     * Message displayed when columns in the imported file were discarded and {@link
     * com.smartgwt.client.widgets.BatchUploader#getDisplayDiscardedColumns displayDiscardedColumns} is true.  Within this
     * message, ${discardedColumns} can be used to show a comma separated list of the column names that were discarded
     * (example: "price, saleDate, total"). <p> Default message is: "The following columns in your uploaded file were ignored
     * because they did not match any of the expected column names: ${discardedColumns}"
     *
     * @param discardedColumnsMessage New discardedColumnsMessage value. Default value is "..."
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setDiscardedColumnsMessage(String discardedColumnsMessage)  throws IllegalStateException {
        setAttribute("discardedColumnsMessage", discardedColumnsMessage, false);
    }

    /**
     * Message displayed when columns in the imported file were discarded and {@link
     * com.smartgwt.client.widgets.BatchUploader#getDisplayDiscardedColumns displayDiscardedColumns} is true.  Within this
     * message, ${discardedColumns} can be used to show a comma separated list of the column names that were discarded
     * (example: "price, saleDate, total"). <p> Default message is: "The following columns in your uploaded file were ignored
     * because they did not match any of the expected column names: ${discardedColumns}"
     *
     * @return Current discardedColumnsMessage value. Default value is "..."
     */
    public String getDiscardedColumnsMessage()  {
        return getAttributeAsString("discardedColumnsMessage");
    }
    

    /**
     * If columns were present in the imported data that were discarded because they could not be matched to any DataSource
     * fields, whether these should be displayed to the user, using the {@link
     * com.smartgwt.client.widgets.BatchUploader#getDiscardedColumnsMessage discardedColumnsMessage} shown within the {@link
     * com.smartgwt.client.widgets.BatchUploader#getUploadStatusMessages uploadStatusMessages} component.
     *
     * @param displayDiscardedColumns New displayDiscardedColumns value. Default value is true
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setDisplayDiscardedColumns(Boolean displayDiscardedColumns)  throws IllegalStateException {
        setAttribute("displayDiscardedColumns", displayDiscardedColumns, false);
    }

    /**
     * If columns were present in the imported data that were discarded because they could not be matched to any DataSource
     * fields, whether these should be displayed to the user, using the {@link
     * com.smartgwt.client.widgets.BatchUploader#getDiscardedColumnsMessage discardedColumnsMessage} shown within the {@link
     * com.smartgwt.client.widgets.BatchUploader#getUploadStatusMessages uploadStatusMessages} component.
     *
     * @return Current displayDiscardedColumns value. Default value is true
     */
    public Boolean getDisplayDiscardedColumns()  {
        Boolean result = getAttributeAsBoolean("displayDiscardedColumns");
        return result == null ? true : result;
    }
    

    /**
     * Error message to show when the uploading process detects a missing delimiter or end of line after quoted value in the
     * first line.
     *
     * @param errorMessageDelimiterOrEndOfLine New errorMessageDelimiterOrEndOfLine value. Default value is "Delimiter or end of line expected after quoted value - problem found in the first line at character position: ${errorOffset}."
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setErrorMessageDelimiterOrEndOfLine(String errorMessageDelimiterOrEndOfLine)  throws IllegalStateException {
        setAttribute("errorMessageDelimiterOrEndOfLine", errorMessageDelimiterOrEndOfLine, false);
    }

    /**
     * Error message to show when the uploading process detects a missing delimiter or end of line after quoted value in the
     * first line.
     *
     * @return Current errorMessageDelimiterOrEndOfLine value. Default value is "Delimiter or end of line expected after quoted value - problem found in the first line at character position: ${errorOffset}."
     */
    public String getErrorMessageDelimiterOrEndOfLine()  {
        return getAttributeAsString("errorMessageDelimiterOrEndOfLine");
    }
    

    /**
     * Error message to show when the uploading process detects an Excel File, which is not supported.
     *
     * @param errorMessageExcelFileDetected New errorMessageExcelFileDetected value. Default value is "You uploaded an Excel file. Please save your data as a csv file and re-upload"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setErrorMessageExcelFileDetected(String errorMessageExcelFileDetected)  throws IllegalStateException {
        setAttribute("errorMessageExcelFileDetected", errorMessageExcelFileDetected, false);
    }

    /**
     * Error message to show when the uploading process detects an Excel File, which is not supported.
     *
     * @return Current errorMessageExcelFileDetected value. Default value is "You uploaded an Excel file. Please save your data as a csv file and re-upload"
     */
    public String getErrorMessageExcelFileDetected()  {
        return getAttributeAsString("errorMessageExcelFileDetected");
    }
    

    /**
     * Error message to show when the uploading process detects a file with no data.
     *
     * @param errorMessageFileIsBlank New errorMessageFileIsBlank value. Default value is "The provided file is blank. Please, provide a file with data."
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setErrorMessageFileIsBlank(String errorMessageFileIsBlank)  throws IllegalStateException {
        setAttribute("errorMessageFileIsBlank", errorMessageFileIsBlank, false);
    }

    /**
     * Error message to show when the uploading process detects a file with no data.
     *
     * @return Current errorMessageFileIsBlank value. Default value is "The provided file is blank. Please, provide a file with data."
     */
    public String getErrorMessageFileIsBlank()  {
        return getAttributeAsString("errorMessageFileIsBlank");
    }
    

    /**
     * Error message to show when the uploading process detects an invalid inputType.
     *
     * @param errorMessageInputType New errorMessageInputType value. Default value is "Invalid inputType value was set!"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setErrorMessageInputType(String errorMessageInputType)  throws IllegalStateException {
        setAttribute("errorMessageInputType", errorMessageInputType, false);
    }

    /**
     * Error message to show when the uploading process detects an invalid inputType.
     *
     * @return Current errorMessageInputType value. Default value is "Invalid inputType value was set!"
     */
    public String getErrorMessageInputType()  {
        return getAttributeAsString("errorMessageInputType");
    }
    

    /**
     * Error message to show when the uploaded file has rows other than the first row that could not be parsed. <P> This is a
     * dynamic string - text within <code>&#36;{...}</code> will be evaluated as JS code when the message is displayed. <P> The
     * following variables are available to be used in this message: <ul> <li>goodRowCount: Total rows that were parsed
     * correctly.</li> <li>totalRows: Total rows to be parsed in the uploaded file.</li> <li>firstBadRow: First row that could
     * not be parsed.</li> <li>badRowCount: Total rows that could not be parsed.</li> </ul>
     *
     * @param errorMessageRowsNotParsed New errorMessageRowsNotParsed value. Default value is "Some rows could not be parsed; the grid below shows ${goodRowCount} of ${totalRows} data rows. Row number ${firstBadRow} was the first row to fail to be parsed."
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setErrorMessageRowsNotParsed(String errorMessageRowsNotParsed)  throws IllegalStateException {
        setAttribute("errorMessageRowsNotParsed", errorMessageRowsNotParsed, false);
    }

    /**
     * Error message to show when the uploaded file has rows other than the first row that could not be parsed. <P> This is a
     * dynamic string - text within <code>&#36;{...}</code> will be evaluated as JS code when the message is displayed. <P> The
     * following variables are available to be used in this message: <ul> <li>goodRowCount: Total rows that were parsed
     * correctly.</li> <li>totalRows: Total rows to be parsed in the uploaded file.</li> <li>firstBadRow: First row that could
     * not be parsed.</li> <li>badRowCount: Total rows that could not be parsed.</li> </ul>
     *
     * @return Current errorMessageRowsNotParsed value. Default value is "Some rows could not be parsed; the grid below shows ${goodRowCount} of ${totalRows} data rows. Row number ${firstBadRow} was the first row to fail to be parsed."
     */
    public String getErrorMessageRowsNotParsed()  {
        return getAttributeAsString("errorMessageRowsNotParsed");
    }
    

    /**
     * Error message to show when the uploading process is unable to detect the delimiter.
     *
     * @param errorMessageUndeterminedDelimiter New errorMessageUndeterminedDelimiter value. Default value is "We were unable to guess the delimiter"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setErrorMessageUndeterminedDelimiter(String errorMessageUndeterminedDelimiter)  throws IllegalStateException {
        setAttribute("errorMessageUndeterminedDelimiter", errorMessageUndeterminedDelimiter, false);
    }

    /**
     * Error message to show when the uploading process is unable to detect the delimiter.
     *
     * @return Current errorMessageUndeterminedDelimiter value. Default value is "We were unable to guess the delimiter"
     */
    public String getErrorMessageUndeterminedDelimiter()  {
        return getAttributeAsString("errorMessageUndeterminedDelimiter");
    }
    

    /**
     * Error message to show when the uploading process detects an unterminated quote string in the first line.
     *
     * @param errorMessageUnterminatedQuote New errorMessageUnterminatedQuote value. Default value is "Unterminated quote string - problem found in the first line at character position: ${errorOffset}."
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setErrorMessageUnterminatedQuote(String errorMessageUnterminatedQuote)  throws IllegalStateException {
        setAttribute("errorMessageUnterminatedQuote", errorMessageUnterminatedQuote, false);
    }

    /**
     * Error message to show when the uploading process detects an unterminated quote string in the first line.
     *
     * @return Current errorMessageUnterminatedQuote value. Default value is "Unterminated quote string - problem found in the first line at character position: ${errorOffset}."
     */
    public String getErrorMessageUnterminatedQuote()  {
        return getAttributeAsString("errorMessageUnterminatedQuote");
    }
    

    /**
     * Grid which will show a preview of data to be uploaded, with errors flagged
     * <p>
     * This component is an AutoChild named "grid".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current grid value. Default value is null
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public ListGrid getGrid() throws IllegalStateException {
        errorIfNotCreated("grid");
        return (ListGrid)ListGrid.getByJSObject(getAttributeAsJavaScriptObject("grid"));
    }
    

    /**
     * Fields to apply to {@link com.smartgwt.client.widgets.BatchUploader#getGrid grid}.  These will override the field
     * definitions in the {@link com.smartgwt.client.widgets.BatchUploader#getUploadDataSource uploadDataSource} on a field by
     * field basis, as described under {@link com.smartgwt.client.widgets.DataBoundComponent#getFields
     * DataBoundComponent.fields}.
     *
     * @param gridFields New gridFields value. Default value is null
     */
    public void setGridFields(ListGridField... gridFields) {
        setAttribute("gridFields", gridFields, true);
    }

    /**
     * Fields to apply to {@link com.smartgwt.client.widgets.BatchUploader#getGrid grid}.  These will override the field
     * definitions in the {@link com.smartgwt.client.widgets.BatchUploader#getUploadDataSource uploadDataSource} on a field by
     * field basis, as described under {@link com.smartgwt.client.widgets.DataBoundComponent#getFields
     * DataBoundComponent.fields}.
     *
     * @return Current gridFields value. Default value is null
     */
    public ListGridField[] getGridFields()  {
        return com.smartgwt.client.util.ConvertTo.arrayOfListGridField(getAttributeAsJavaScriptObject("gridFields"));
    }
    

    /**
     * Button that scrolls grid to the next error.
     * <p>
     * This component is an AutoChild named "nextButton".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current nextButton value. Default value is null
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public IButton getNextButton() throws IllegalStateException {
        errorIfNotCreated("nextButton");
        return (IButton)IButton.getByJSObject(getAttributeAsJavaScriptObject("nextButton"));
    }
    

    /**
     * Title for the {@link com.smartgwt.client.widgets.BatchUploader#getNextButton next error button}.
     *
     * @param nextButtonTitle New nextButtonTitle value. Default value is "Next error"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setNextButtonTitle(String nextButtonTitle)  throws IllegalStateException {
        setAttribute("nextButtonTitle", nextButtonTitle, false);
    }

    /**
     * Title for the {@link com.smartgwt.client.widgets.BatchUploader#getNextButton next error button}.
     *
     * @return Current nextButtonTitle value. Default value is "Next error"
     */
    public String getNextButtonTitle()  {
        return getAttributeAsString("nextButtonTitle");
    }
    

    /**
     * Specifies what action to take if the user attempts to commit a partially validated set of data (ie, one that still
     * contains some errors).
     *
     * @param partialCommit New partialCommit value. Default value is "prompt"
     */
    public void setPartialCommit(PartialCommitOption partialCommit) {
        setAttribute("partialCommit", partialCommit == null ? null : partialCommit.getValue(), true);
    }

    /**
     * Specifies what action to take if the user attempts to commit a partially validated set of data (ie, one that still
     * contains some errors).
     *
     * @return Current partialCommit value. Default value is "prompt"
     */
    public PartialCommitOption getPartialCommit()  {
        return EnumUtil.getEnum(PartialCommitOption.values(), getAttribute("partialCommit"));
    }
    

    /**
     * Message to display after data has been committed, when  {@link
     * com.smartgwt.client.widgets.BatchUploader#getShowCommitConfirmation showCommitConfirmation} is true.
     *
     * @param partialCommitConfirmationMessage New partialCommitConfirmationMessage value. Default value is "Valid records added; some records remain in error"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setPartialCommitConfirmationMessage(String partialCommitConfirmationMessage)  throws IllegalStateException {
        setAttribute("partialCommitConfirmationMessage", partialCommitConfirmationMessage, false);
    }

    /**
     * Message to display after data has been committed, when  {@link
     * com.smartgwt.client.widgets.BatchUploader#getShowCommitConfirmation showCommitConfirmation} is true.
     *
     * @return Current partialCommitConfirmationMessage value. Default value is "Valid records added; some records remain in error"
     */
    public String getPartialCommitConfirmationMessage()  {
        return getAttributeAsString("partialCommitConfirmationMessage");
    }
    

    /**
     * If {@link com.smartgwt.client.widgets.BatchUploader#getPartialCommit partialCommit} is set to "prevent", the text to
     * display to the user if they try  to commit a dataset containing errors.  By default, this text is "There are errors in
     * your  data.  Please correct all errors before clicking Commit"
     *
     * @param partialCommitError New partialCommitError value. Default value is See below
     */
    public void setPartialCommitError(String partialCommitError) {
        setAttribute("partialCommitError", partialCommitError, true);
    }

    /**
     * If {@link com.smartgwt.client.widgets.BatchUploader#getPartialCommit partialCommit} is set to "prevent", the text to
     * display to the user if they try  to commit a dataset containing errors.  By default, this text is "There are errors in
     * your  data.  Please correct all errors before clicking Commit"
     *
     * @return Current partialCommitError value. Default value is See below
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
     * @param partialCommitPrompt New partialCommitPrompt value. Default value is See below
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
     * @return Current partialCommitPrompt value. Default value is See below
     */
    public String getPartialCommitPrompt()  {
        return getAttributeAsString("partialCommitPrompt");
    }
    

    /**
     * Button that scrolls grid to the previous error.
     * <p>
     * This component is an AutoChild named "previousButton".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current previousButton value. Default value is null
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public IButton getPreviousButton() throws IllegalStateException {
        errorIfNotCreated("previousButton");
        return (IButton)IButton.getByJSObject(getAttributeAsJavaScriptObject("previousButton"));
    }
    

    /**
     * Title for the {@link com.smartgwt.client.widgets.BatchUploader#getPreviousButton previous error button}.
     *
     * @param previousButtonTitle New previousButtonTitle value. Default value is "Previous error"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setPreviousButtonTitle(String previousButtonTitle)  throws IllegalStateException {
        setAttribute("previousButtonTitle", previousButtonTitle, false);
    }

    /**
     * Title for the {@link com.smartgwt.client.widgets.BatchUploader#getPreviousButton previous error button}.
     *
     * @return Current previousButtonTitle value. Default value is "Previous error"
     */
    public String getPreviousButtonTitle()  {
        return getAttributeAsString("previousButtonTitle");
    }
    

    /**
     * Object containing properties to send with every "add" request this batchUploader sends.
     *
     * @param requestProperties New requestProperties value. Default value is null
     */
    public void setRequestProperties(DSRequest requestProperties) {
        JavaScriptObject config = JSOHelper.createObject();
        if (requestProperties != null) {
            JSOHelper.addProperties(config, requestProperties.getJsObj());
        }
        setAttribute("requestProperties", requestProperties == null ? null : config, true);
    }

    /**
     * Object containing properties to send with every "add" request this batchUploader sends.
     *
     * @return Current requestProperties value. Default value is null
     */
    public DSRequest getRequestProperties()  {
        return new DSRequest(getAttributeAsJavaScriptObject("requestProperties"));
    }
    

    /**
     * Whether to show the {@link com.smartgwt.client.widgets.BatchUploader#getCommitConfirmationMessage commit message} after
     * data is successfully committed.
     *
     * @param showCommitConfirmation New showCommitConfirmation value. Default value is true
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setShowCommitConfirmation(Boolean showCommitConfirmation)  throws IllegalStateException {
        setAttribute("showCommitConfirmation", showCommitConfirmation, false);
    }

    /**
     * Whether to show the {@link com.smartgwt.client.widgets.BatchUploader#getCommitConfirmationMessage commit message} after
     * data is successfully committed.
     *
     * @return Current showCommitConfirmation value. Default value is true
     */
    public Boolean getShowCommitConfirmation()  {
        Boolean result = getAttributeAsBoolean("showCommitConfirmation");
        return result == null ? true : result;
    }
    

    /**
     * Message to display if at least one update was rolled back due to errors in another row. See the {@link
     * com.smartgwt.client.data.DataSource#getAutoJoinTransactions transactions overview} for details of  Smart GWT's automatic
     * transactional updates feature
     *
     * @param updatesRolledBackMessage New updatesRolledBackMessage value. Default value is "One or more updates were rolled-back due to errors on other rows"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setUpdatesRolledBackMessage(String updatesRolledBackMessage)  throws IllegalStateException {
        setAttribute("updatesRolledBackMessage", updatesRolledBackMessage, false);
    }

    /**
     * Message to display if at least one update was rolled back due to errors in another row. See the {@link
     * com.smartgwt.client.data.DataSource#getAutoJoinTransactions transactions overview} for details of  Smart GWT's automatic
     * transactional updates feature
     *
     * @return Current updatesRolledBackMessage value. Default value is "One or more updates were rolled-back due to errors on other rows"
     */
    public String getUpdatesRolledBackMessage()  {
        return getAttributeAsString("updatesRolledBackMessage");
    }
    

    /**
     * Button that triggers the upload.
     * <p>
     * This component is an AutoChild named "uploadButton".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current uploadButton value. Default value is null
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public IButton getUploadButton() throws IllegalStateException {
        errorIfNotCreated("uploadButton");
        return (IButton)IButton.getByJSObject(getAttributeAsJavaScriptObject("uploadButton"));
    }
    

    /**
     * Title for the {@link com.smartgwt.client.widgets.BatchUploader#getUploadButton upload button}.
     *
     * @param uploadButtonTitle New uploadButtonTitle value. Default value is "Upload"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setUploadButtonTitle(String uploadButtonTitle)  throws IllegalStateException {
        setAttribute("uploadButtonTitle", uploadButtonTitle, false);
    }

    /**
     * Title for the {@link com.smartgwt.client.widgets.BatchUploader#getUploadButton upload button}.
     *
     * @return Current uploadButtonTitle value. Default value is "Upload"
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
     * @param uploadDataSource New uploadDataSource value. Default value is null
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
     * @return Current uploadDataSource value. Default value is null
     */
    public DataSource getUploadDataSource()  {
        return DataSource.getOrCreateRef(getAttributeAsJavaScriptObject("uploadDataSource"));
    }
    

    /**
     * The delimiter to use when importing character-delimited files.  The default is comma (CSV).
     *
     * @param uploadDelimiter New uploadDelimiter value. Default value is ","
     */
    public void setUploadDelimiter(String uploadDelimiter) {
        setAttribute("uploadDelimiter", uploadDelimiter, true);
    }

    /**
     * The delimiter to use when importing character-delimited files.  The default is comma (CSV).
     *
     * @return Current uploadDelimiter value. Default value is ","
     */
    public String getUploadDelimiter()  {
        return getAttributeAsString("uploadDelimiter");
    }
    

    /**
     * On server-side, BatchUploader uses <code>DataImport</code> to import uploaded files, specifically APIs taking
     * <code>java.io.Reader</code> parameter. <code>BatchUploader.uploadEncoding</code> setting defines the encoding, which
     * will be used to create a <code>java.io.Reader</code> instance to read data from uploaded files. The default is "UTF-8".
     *
     * @param uploadEncoding New uploadEncoding value. Default value is "UTF-8"
     */
    public void setUploadEncoding(String uploadEncoding) {
        setAttribute("uploadEncoding", uploadEncoding, true);
    }

    /**
     * On server-side, BatchUploader uses <code>DataImport</code> to import uploaded files, specifically APIs taking
     * <code>java.io.Reader</code> parameter. <code>BatchUploader.uploadEncoding</code> setting defines the encoding, which
     * will be used to create a <code>java.io.Reader</code> instance to read data from uploaded files. The default is "UTF-8".
     *
     * @return Current uploadEncoding value. Default value is "UTF-8"
     */
    public String getUploadEncoding()  {
        return getAttributeAsString("uploadEncoding");
    }
    

    /**
     * String to prepend to the names of the additional fields specified in {@link
     * com.smartgwt.client.widgets.BatchUploader#getUploadFormFields uploadFormFields}  before they are stored in the
     * HttpSession on the server.  This property provides a basic namespace facility, allowing you to avoid name collisions
     * with existing session attributes. <P> Example usage: if you have an additional field called "someDate" and you set 
     * uploadFieldPrefix to "myFields_", your additionalFormField will be available as an HttpSession attribute called
     * "myFields_someDate"
     *
     * @param uploadFieldPrefix New uploadFieldPrefix value. Default value is null
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
     * @return Current uploadFieldPrefix value. Default value is null
     */
    public String getUploadFieldPrefix()  {
        return getAttributeAsString("uploadFieldPrefix");
    }
    

    /**
     * FileItem for selecting the file to upload.
     * <p>
     * This component is an AutoChild named "uploadFileItem".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current uploadFileItem value. Default value is null
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public FileItem getUploadFileItem() throws IllegalStateException {
        errorIfNotCreated("uploadFileItem");
        return FileItem.getOrCreateRef(getAttributeAsJavaScriptObject("uploadFileItem"));
    }
    

    /**
     * Title to display next to the {@link com.smartgwt.client.widgets.form.fields.FileItem} field where the user enters a
     * filename to upload
     *
     * @param uploadFileLabel New uploadFileLabel value. Default value is "Upload File"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setUploadFileLabel(String uploadFileLabel)  throws IllegalStateException {
        setAttribute("uploadFileLabel", uploadFileLabel, false);
    }

    /**
     * Title to display next to the {@link com.smartgwt.client.widgets.form.fields.FileItem} field where the user enters a
     * filename to upload
     *
     * @return Current uploadFileLabel value. Default value is "Upload File"
     */
    public String getUploadFileLabel()  {
        return getAttributeAsString("uploadFileLabel");
    }
    

    /**
     * Form used to specify file to upload, and any additional fields required.
     * <p>
     * This component is an AutoChild named "uploadForm".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current uploadForm value. Default value is null
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public DynamicForm getUploadForm() throws IllegalStateException {
        errorIfNotCreated("uploadForm");
        return (DynamicForm)DynamicForm.getByJSObject(getAttributeAsJavaScriptObject("uploadForm"));
    }
    

    /**
     * Optional fields for the uploadForm.
     *
     * @param uploadFormFields New uploadFormFields value. Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setUploadFormFields(FormItem... uploadFormFields)  throws IllegalStateException {
        setAttribute("uploadFormFields", uploadFormFields, false);
    }

    /**
     * Optional fields for the uploadForm.
     *
     * @return Current uploadFormFields value. Default value is null
     */
    public FormItem[] getUploadFormFields()  {
        return com.smartgwt.client.util.ConvertTo.arrayOfFormItem(getAttributeAsJavaScriptObject("uploadFormFields"));
    }
    

    /**
     * Optional {@link com.smartgwt.client.data.DSRequest#getOperationId DSRequest.operationId} for the "add" operation used to
     * add new records to the {@link com.smartgwt.client.widgets.BatchUploader#getUploadDataSource uploadDataSource}.
     *
     * @param uploadOperation New uploadOperation value. Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setUploadOperation(String uploadOperation)  throws IllegalStateException {
        setAttribute("uploadOperation", uploadOperation, false);
    }

    /**
     * Optional {@link com.smartgwt.client.data.DSRequest#getOperationId DSRequest.operationId} for the "add" operation used to
     * add new records to the {@link com.smartgwt.client.widgets.BatchUploader#getUploadDataSource uploadDataSource}.
     *
     * @return Current uploadOperation value. Default value is null
     */
    public String getUploadOperation()  {
        return getAttributeAsString("uploadOperation");
    }
    

    /**
     * The character used to quote strings. The default is double quotes.
     *
     * @param uploadQuoteString New uploadQuoteString value. Default value is "\""
     */
    public void setUploadQuoteString(String uploadQuoteString) {
        setAttribute("uploadQuoteString", uploadQuoteString, true);
    }

    /**
     * The character used to quote strings. The default is double quotes.
     *
     * @return Current uploadQuoteString value. Default value is "\""
     */
    public String getUploadQuoteString()  {
        return getAttributeAsString("uploadQuoteString");
    }
    

    /**
     * Container for informational messages that are shown when a user attempts an upload. Appears above the {@link
     * com.smartgwt.client.widgets.BatchUploader#getGrid grid}.
     * <p>
     * This component is an AutoChild named "uploadStatusMessages".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current uploadStatusMessages value. Default value is null
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public HTMLFlow getUploadStatusMessages() throws IllegalStateException {
        errorIfNotCreated("uploadStatusMessages");
        return (HTMLFlow)HTMLFlow.getByJSObject(getAttributeAsJavaScriptObject("uploadStatusMessages"));
    }
    

    /**
     * If set, indicates that a warning dialog should be shown when Cancel is clicked, asking  the user to confirm that this is
     * really what they want to do. The actual warning message is specified with {@link
     * com.smartgwt.client.widgets.BatchUploader#getCancelConfirmMessage cancelConfirmMessage}
     *
     * @param warnOnCancel New warnOnCancel value. Default value is true
     */
    public void setWarnOnCancel(Boolean warnOnCancel) {
        setAttribute("warnOnCancel", warnOnCancel, true);
    }

    /**
     * If set, indicates that a warning dialog should be shown when Cancel is clicked, asking  the user to confirm that this is
     * really what they want to do. The actual warning message is specified with {@link
     * com.smartgwt.client.widgets.BatchUploader#getCancelConfirmMessage cancelConfirmMessage}
     *
     * @return Current warnOnCancel value. Default value is true
     */
    public Boolean getWarnOnCancel()  {
        Boolean result = getAttributeAsBoolean("warnOnCancel");
        return result == null ? true : result;
    }
    

    // ********************* Methods ***********************
    /**
     * Add a previewShown handler.
     * <p>
     * Notification method fired when the {@link com.smartgwt.client.widgets.BatchUploader#getGrid BatchUploader.grid} is
     * populated with a new set of data for the user to preview before commit. <P> This notification occurs after the user has
     * uploaded a new data file, the data has been processed on the server, and the preview grid populated with the data ready
     * for committing. Developers may use this notification to examine or modify the data set to be uploaded. The {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getData ListGrid.data} object will be populated with the array of uploaded
     * records, and standard grid APIs such as  {@link com.smartgwt.client.widgets.grid.ListGrid#getRowErrors
     * ListGrid.getRowErrors()}, {@link com.smartgwt.client.widgets.grid.ListGrid#setEditValue ListGrid.setEditValue()}, etc
     * may be used  to interact with this data. <P> Note that developers wishing to manipulate the uploaded data can also do
     * this on the server side when user hits the commit button to submit the data to the {@link
     * com.smartgwt.client.widgets.BatchUploader#getUploadDataSource BatchUploader.uploadDataSource}. This can be achieved by
     * setting the  {@link com.smartgwt.client.widgets.BatchUploader#getUploadOperation BatchUploader.uploadOperation} to call
     * a custom  {@link com.smartgwt.client.data.DataSource#getOperationBindings "add" type operation} on the target
     * dataSource.
     *
     * @param handler the previewShown handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addPreviewShownHandler(com.smartgwt.client.widgets.com.smartgwt.client.widgets.events.PreviewShownHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.com.smartgwt.client.widgets.events.PreviewShownEvent.getType()) == 0) setupPreviewShownEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.com.smartgwt.client.widgets.events.PreviewShownEvent.getType());
    }

    private native void setupPreviewShownEvent() /*-{
        var obj;
        var selfJ = this;
        var hasDefaultHandler;
        var previewShown = $entry(function(){
            var param = {"_this": this, "grid" : arguments[0]};
            var event = @com.smartgwt.client.widgets.com.smartgwt.client.widgets.events.PreviewShownEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            selfJ.@com.smartgwt.client.widgets.BatchUploader::handleTearDownPreviewShownEvent()();
            if (hasDefaultHandler) this.Super("previewShown", arguments);
        });
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            hasDefaultHandler = $wnd.isc.isA.Function(obj.getProperty("previewShown"));
            obj.addProperties({previewShown:  previewShown              });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
            hasDefaultHandler = $wnd.isc.isA.Function($wnd.isc[scClassName].getInstanceProperty("previewShown"));
            obj.previewShown =  previewShown             ;
        }
    }-*/;

    private void handleTearDownPreviewShownEvent() {
        if (getHandlerCount(com.smartgwt.client.widgets.com.smartgwt.client.widgets.events.PreviewShownEvent.getType()) == 0) tearDownPreviewShownEvent();
    }

    private native void tearDownPreviewShownEvent() /*-{
        var obj;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }
        if (obj && obj.hasOwnProperty("previewShown")) delete obj.previewShown;
    }-*/;


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
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public static native void setDefaultProperties(BatchUploader batchUploaderProperties) /*-{
        if (batchUploaderProperties.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Class;)(BatchUploader.@java.lang.Object::getClass()(), "setDefaultProperties", batchUploaderProperties.@java.lang.Object::getClass()());
        }
        batchUploaderProperties.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
    	var properties = batchUploaderProperties.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        properties = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(properties,true);
        $wnd.isc.BatchUploader.addProperties(properties);
    }-*/;

    // ***********************************************************



    /**
     * Synonym of {@link #setUploadFormFields(FormItem...)}.
     */
    public void setUploadFormItems(FormItem... items) throws IllegalStateException {
        setUploadFormFields(items);
    }

    /**
     * Setter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject setLogicalStructure(BatchUploaderLogicalStructure s) {
        super.setLogicalStructure(s);
        try {
            s.allRecordsInErrorMessage = getAttributeAsString("allRecordsInErrorMessage");
        } catch (Throwable t) {
            s.logicalStructureErrors += "BatchUploader.allRecordsInErrorMessage:" + t.getMessage() + "\n";
        }
        try {
            s.autoInterpretBooleans = getAttributeAsString("autoInterpretBooleans");
        } catch (Throwable t) {
            s.logicalStructureErrors += "BatchUploader.autoInterpretBooleans:" + t.getMessage() + "\n";
        }
        try {
            s.cancelButtonTitle = getAttributeAsString("cancelButtonTitle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "BatchUploader.cancelButtonTitle:" + t.getMessage() + "\n";
        }
        try {
            s.cancelConfirmMessage = getAttributeAsString("cancelConfirmMessage");
        } catch (Throwable t) {
            s.logicalStructureErrors += "BatchUploader.cancelConfirmMessage:" + t.getMessage() + "\n";
        }
        try {
            s.commitButtonTitle = getAttributeAsString("commitButtonTitle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "BatchUploader.commitButtonTitle:" + t.getMessage() + "\n";
        }
        try {
            s.commitConfirmationMessage = getAttributeAsString("commitConfirmationMessage");
        } catch (Throwable t) {
            s.logicalStructureErrors += "BatchUploader.commitConfirmationMessage:" + t.getMessage() + "\n";
        }
        try {
            s.dataFormat = getAttributeAsString("dataFormat");
        } catch (Throwable t) {
            s.logicalStructureErrors += "BatchUploader.dataFormat:" + t.getMessage() + "\n";
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
            s.discardedColumnsMessage = getAttributeAsString("discardedColumnsMessage");
        } catch (Throwable t) {
            s.logicalStructureErrors += "BatchUploader.discardedColumnsMessage:" + t.getMessage() + "\n";
        }
        try {
            s.displayDiscardedColumns = getAttributeAsString("displayDiscardedColumns");
        } catch (Throwable t) {
            s.logicalStructureErrors += "BatchUploader.displayDiscardedColumns:" + t.getMessage() + "\n";
        }
        try {
            s.errorMessageDelimiterOrEndOfLine = getAttributeAsString("errorMessageDelimiterOrEndOfLine");
        } catch (Throwable t) {
            s.logicalStructureErrors += "BatchUploader.errorMessageDelimiterOrEndOfLine:" + t.getMessage() + "\n";
        }
        try {
            s.errorMessageExcelFileDetected = getAttributeAsString("errorMessageExcelFileDetected");
        } catch (Throwable t) {
            s.logicalStructureErrors += "BatchUploader.errorMessageExcelFileDetected:" + t.getMessage() + "\n";
        }
        try {
            s.errorMessageFileIsBlank = getAttributeAsString("errorMessageFileIsBlank");
        } catch (Throwable t) {
            s.logicalStructureErrors += "BatchUploader.errorMessageFileIsBlank:" + t.getMessage() + "\n";
        }
        try {
            s.errorMessageInputType = getAttributeAsString("errorMessageInputType");
        } catch (Throwable t) {
            s.logicalStructureErrors += "BatchUploader.errorMessageInputType:" + t.getMessage() + "\n";
        }
        try {
            s.errorMessageRowsNotParsed = getAttributeAsString("errorMessageRowsNotParsed");
        } catch (Throwable t) {
            s.logicalStructureErrors += "BatchUploader.errorMessageRowsNotParsed:" + t.getMessage() + "\n";
        }
        try {
            s.errorMessageUndeterminedDelimiter = getAttributeAsString("errorMessageUndeterminedDelimiter");
        } catch (Throwable t) {
            s.logicalStructureErrors += "BatchUploader.errorMessageUndeterminedDelimiter:" + t.getMessage() + "\n";
        }
        try {
            s.errorMessageUnterminatedQuote = getAttributeAsString("errorMessageUnterminatedQuote");
        } catch (Throwable t) {
            s.logicalStructureErrors += "BatchUploader.errorMessageUnterminatedQuote:" + t.getMessage() + "\n";
        }
        try {
            s.nextButtonTitle = getAttributeAsString("nextButtonTitle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "BatchUploader.nextButtonTitle:" + t.getMessage() + "\n";
        }
        try {
            s.partialCommit = getAttributeAsString("partialCommit");
        } catch (Throwable t) {
            s.logicalStructureErrors += "BatchUploader.partialCommit:" + t.getMessage() + "\n";
        }
        try {
            s.partialCommitConfirmationMessage = getAttributeAsString("partialCommitConfirmationMessage");
        } catch (Throwable t) {
            s.logicalStructureErrors += "BatchUploader.partialCommitConfirmationMessage:" + t.getMessage() + "\n";
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
            s.previousButtonTitle = getAttributeAsString("previousButtonTitle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "BatchUploader.previousButtonTitle:" + t.getMessage() + "\n";
        }
        try {
            s.requestProperties = getRequestProperties();
        } catch (Throwable t) {
            s.logicalStructureErrors += "BatchUploader.requestProperties:" + t.getMessage() + "\n";
        }
        try {
            s.showCommitConfirmation = getAttributeAsString("showCommitConfirmation");
        } catch (Throwable t) {
            s.logicalStructureErrors += "BatchUploader.showCommitConfirmation:" + t.getMessage() + "\n";
        }
        try {
            s.updatesRolledBackMessage = getAttributeAsString("updatesRolledBackMessage");
        } catch (Throwable t) {
            s.logicalStructureErrors += "BatchUploader.updatesRolledBackMessage:" + t.getMessage() + "\n";
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
            s.uploadDelimiter = getAttributeAsString("uploadDelimiter");
        } catch (Throwable t) {
            s.logicalStructureErrors += "BatchUploader.uploadDelimiter:" + t.getMessage() + "\n";
        }
        try {
            s.uploadEncoding = getAttributeAsString("uploadEncoding");
        } catch (Throwable t) {
            s.logicalStructureErrors += "BatchUploader.uploadEncoding:" + t.getMessage() + "\n";
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
            s.uploadOperation = getAttributeAsString("uploadOperation");
        } catch (Throwable t) {
            s.logicalStructureErrors += "BatchUploader.uploadOperation:" + t.getMessage() + "\n";
        }
        try {
            s.uploadQuoteString = getAttributeAsString("uploadQuoteString");
        } catch (Throwable t) {
            s.logicalStructureErrors += "BatchUploader.uploadQuoteString:" + t.getMessage() + "\n";
        }
        try {
            s.warnOnCancel = getAttributeAsString("warnOnCancel");
        } catch (Throwable t) {
            s.logicalStructureErrors += "BatchUploader.warnOnCancel:" + t.getMessage() + "\n";
        }
        return s;
    }

    /**
     * Getter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject getLogicalStructure() {
        BatchUploaderLogicalStructure s = new BatchUploaderLogicalStructure();
        setLogicalStructure(s);
        return s;
    }
}
