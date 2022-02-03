
package com.smartgwt.client.docs;

/**
 * <h3>Uploading Files</h3>
 * Smart GWT provides special client and server-side support for file upload that allows uploaded
 * files to be treated like ordinary DataSource fields.  This includes: <ul> <li>the {@link
 * com.smartgwt.client.widgets.form.fields.FileItem} and {@link
 * com.smartgwt.client.widgets.form.fields.MultiFileItem} FormItems that enable users to upload
 * one or more files as a background operation, without leaving the current page <li>server-side
 * support that allows binary uploads to be treated as a normal DataSource field values, with all
 * other aspects of server-side integration unchanged <li>built-in SQL &amp; Hibernate DataSource
 * support that can store and retrieve uploaded files from SQL databases </ul> <P> The following
 * documentation assumes you are using the Smart GWT Java Server.  If you are not, skip to the
 * sections near the end of this document.<br> <i>Note: This documentation topic is concerned
 * specifically with file upload. Developers looking for a general discussion of how Binary fields
 * are handled with the Smart GWT server may also be interested in the {@link
 * com.smartgwt.client.docs.BinaryFields Binary Fields} overview.</i> <P> <b>Single file upload:
 * "binary" field type</b> <P> To use Smart GWT's client-server upload system, you use a
 * DataSource field of {@link com.smartgwt.client.data.DataSourceField#getType type} "binary".  By
 * default, a DynamicForm bound to a DataSource with a field of type "binary" will use the {@link
 * com.smartgwt.client.widgets.form.fields.FileItem}, which displays a standard HTML &lt;input
 * type="upload"&gt; form control. <P> When you call {@link
 * com.smartgwt.client.widgets.form.DynamicForm#saveData DynamicForm.saveData()} on a DynamicForm
 * containing a FileItem, Smart GWT processes the save identically to a saveData() call that did
 * not include a file upload: <ul> <li> if you are using the built-in SQL connectors via
 * serverType:"sql", the file will be saved to SQL as described under {@link
 * com.smartgwt.client.types.FieldType field type "binary"}. <li> if you have server-side business
 * logic, the inbound request may be routed to your business logic via RPCManager dispatch or DMI
 * declarations as normal, your business logic will receive a normal DSRequest, and you are
 * expected to provide a normal DSResponse. </ul> <P> Client-side callbacks, such as the callback
 * passed to saveData(), fire normally. <P> Note that FileItems cannot be programmatically
 * populated - this is a browser security restriction over which we have no control.  This
 * restriction means that we are unable to  populate a FileItem with the correct filename when a
 * form is editing an existing record. Also, when you call saveData() on a form that is editing a
 * new record, the FileItem will be cleared on successful completion of the saveData() call; this
 * is a side-effect of the form being placed into "edit" mode.  In both of these cases, the fact
 * that the FileItem  has been cleared will not cause the persisted binary data to be removed by
 * Smart GWT  Server on subsequent calls to setData().  If the user selects another file, it will 
 * overwrite the existing one; if the FileItem is left blank, the server simply ignores it. If you
 * actually wish to wipe out the value of a binary field, call  {@link
 * com.smartgwt.client.data.DataSource#updateData updateData()} on the underlying dataSource,
 * passing an  explicit null value for the binary field. <P> DataSources can have multiple binary
 * fields, but developers should be aware that you can not submit more than one FileItem in a
 * single form. Developers needing to upload multiple files can either use the {@link
 * com.smartgwt.client.widgets.form.fields.MultiFileItem}, or use multiple  DynamicForms (nested
 * in a {@link com.smartgwt.client.widgets.layout.VStack}, or similar), and submit them
 * separately. For an add operation, the pattern would be to perform the initial submission of
 * values for the record and then use the {@link com.smartgwt.client.data.DSRequest#getCallback
 * callback} to apply the primary key value for the new record to the forms with binary fields and
 * save them to the server separately. This approach has the advantage that if an error or timeout
 * occurs, users will not be caught waiting for files to complete uploading  before being notified
 * of the failure and having to repeat the entire transaction.<br> Note when adding a new record
 * using this pattern, if you have a binary field marked as <code>required="true"</code> it should
 * be submitted as part of the initial submission. <P> <b>Restricting upload sizes</b>  <p>  The
 * server framework includes mechanisms for setting maximum allowable file sizes. The  first,
 * applied using {@link com.smartgwt.client.docs.Server_properties global configuration
 * properties}, is meant to  prevent an end user from uploading a file large enough to cause
 * memory issues on the server. <p>  To configure the maximum allowed size of a single uploaded
 * file (disabled by default), set  the <b>fileUpload.maxFileSize</b> property's value (in bytes):
 * <p style="text-indent: 25px"> fileUpload.maxFileSize: 104857600  <p>  To configure the maximum
 * combined size of all files in a single request (disabled by  default), set the
 * <b>fileUpload.maxSize</b> property's value (also in bytes):   <p style="text-indent: 25px">
 * fileUpload.maxSize: 209715200  <p>  Another configuration property controls the default value
 * of a "binary" DataSourceField's  {@link
 * com.smartgwt.client.docs.serverds.DataSourceField#maxFileSize maxFileSize} attribute, suitable
 * for managing storage  requirements for a given DataSource over time (e.g., limiting images to
 * 10MB).  <p style="text-indent: 25px"> DSRequest.maxUploadFileSize: 104857600 <p> When a {@link
 * com.smartgwt.client.widgets.form.fields.FileItem} or {@link
 * com.smartgwt.client.widgets.form.fields.UploadItem} is bound to a "binary"
 * <code>DataSourceField</code> with a <code>maxFileSize</code> setting, a {@link
 * com.smartgwt.client.types.ValidatorType <code>maxFileSize</code>-type} validator is
 * automatically added to the item's {@link
 * com.smartgwt.client.widgets.form.fields.FormItem#getValidators validators}. In supported
 * browsers, a <code>maxFileSize</code> validator is a client-side check that the size of a file
 * selected for upload does not exceed the field's <code>maxFileSize</code>. Note, however, that
 * server-side enforcement of the <code>maxFileSize</code> is always required because the user's
 * browser might not support client-side file size checks. Also, any client-side check can be
 * bypassed by a malicious user. <p> <b>Processing File Uploads with server-side business
 * logic</b> <P> Server-side business logic that processes file uploads may retrieve upload files
 * via the server side API dsRequest.getUploadedFile(<i>fieldName</i>).  The uploaded file is
 * returned as an instance of ISCFileItem, which provides access to a Java InputStream as well as
 * metadata about the file (size, name).   See the server-side JavaDoc (com.isomorphic.*) for
 * details. <P> <span style="color:red;font-weight:bold;">NOTE:</span> request processing engines
 * such as Struts may parse the inbound request before Smart GWT receives it.  If you are creating
 * an RPCManager object inside of a Struts Action and the file being uploaded is not available via
 * <code>dsRequest.getUploadedFile()</code>, this is likely to be the problem, and you should
 * remove Struts from the processing of the upload. <P> Server-side validation errors may be
 * provided, including validation errors for the uploaded file (such as too large or invalid
 * content), and will be displayed in the form that attempted an upload. <P> Be aware of the
 * following special concerns when processing file uploads: <ul> <li> if you provide your own Java
 * Servlet or JSP that creates an instance of RPCManager in order process Smart GWT requests, many
 * APIs of the HttpServletRequest are not safe to call before you have created the RPCManager,
 * passing in the HttpServletRequest.  These include getReader(), getParameter() and other
 * commonly called methods.  This is a limitation of Java Servlets, not specific to Smart GWT <li>
 * unlike other DataSource "add" and "update" operations, you are not expected to return the file
 * as part of the data returned in the DSResponse </ul> <P> <b>Multi file upload:
 * MultiFileItem</b> <P> The MultiFileItem provides an interface for a user to save one or more
 * files that are related to a DataSource record, where each file is represented by a record in a
 * related DataSource. <P> See the {@link com.smartgwt.client.widgets.form.fields.MultiFileItem}
 * docs for details. <P> <b>Upload without the Smart GWT Server</b> <P> If it is acceptable that
 * the application will do a full-page reload after the upload completes, you can simply: <ul>
 * <li> set {@link com.smartgwt.client.widgets.form.DynamicForm#getEncoding DynamicForm.encoding}
 * to "multipart" <li> include an {@link com.smartgwt.client.widgets.form.fields.UploadItem} to
 * get a basic HTML upload control <li> set {@link
 * com.smartgwt.client.widgets.form.DynamicForm#getAction DynamicForm.action} to a URL where you
 * have deployed server-side code to handle the upload <li> call {@link
 * com.smartgwt.client.widgets.form.DynamicForm#submitForm DynamicForm.submitForm()} to cause the
 * form to be submitted </ul> This cause the DynamicForm component to submit to the form.action
 * URL like an ordinary HTML &lt;form&gt; element.  Many  <a
 * href='http://www.google.com/search?q=html+file+upload+example' target='_blank'>online
 * tutorials</a> are available which explain how to handle HTML form file upload in various
 * server-side technologies. <P> Note that when you submitForm(), the only values that will be
 * sent to your actionURL are  values for which actual FormItems exist.  This differs from
 * saveData(), in which the entire set of {@link
 * com.smartgwt.client.widgets.form.DynamicForm#getValues form values} are always sent.  To handle
 * submitting extra values, use {@link com.smartgwt.client.widgets.form.fields.HiddenItem}s. <P>
 * For further details, see the {@link com.smartgwt.client.widgets.form.fields.UploadItem} docs.
 * <P> <b>Background upload without the Smart GWT Server</b> <P> Achieving background file upload
 * without using the Smart GWT server is also possible although considerably more advanced.  In
 * addition to the steps above, create a hidden &lt;iframe&gt; element in the page, and use {@link
 * com.smartgwt.client.widgets.form.DynamicForm#getTarget DynamicForm.target} to target the form
 * submission at this IFRAME.  In order receive a callback notification when the upload completes,
 * after processing the file upload, your server should output HTML content for the IFRAME that
 * includes a &lt;SCRIPT&gt; block which will navigate out of the IFRAME (generally via the
 * JavaScript global "top") and call a global method you have declared as a callback.
 * @see com.smartgwt.client.widgets.form.fields.UploadItem
 * @see com.smartgwt.client.widgets.form.fields.FileItem
 * @see com.smartgwt.client.widgets.form.fields.MultiFileItem
 * @see com.smartgwt.client.widgets.MultiFilePicker
 * @see com.smartgwt.client.widgets.form.fields.ViewFileItem
 * @see com.smartgwt.client.widgets.form.fields.FileItem#getEditForm
 * @see com.smartgwt.client.widgets.form.fields.FileItem#getUploadItem
 * @see com.smartgwt.client.widgets.form.fields.FileItem#getDisplayForm
 * @see com.smartgwt.client.widgets.form.fields.FileItem#getDisplayItem
 * @see com.smartgwt.client.widgets.form.fields.FileItem#getDisplayCanvas
 */
public interface Upload {
}
