	    
package com.smartgwt.client.docs;

/**
 * <h3>Uploading Files</h3>
 * Smart GWT provides special client and server-side support for file upload that allows uploaded
 * files to be treated like ordinary DataSource fields.  This includes: <ul> <li>the {@link
 * com.smartgwt.client.widgets.form.fields.FileItem} and {@link
 * com.smartgwt.client.widgets.form.fields.MultiFileItem} FormItems that enable users to upload
 * one or more files as a background operation, without leaving the current page <li>server-side
 * support that allows binary uploads to be treated as a normal DataSource field values, with all
 * other aspects of server-side integration unchanged <li>built-in SQL DataSource support that can
 * store and retrieve uploaded files from SQL databases </ul> The following documentation assumes
 * you are using the Smart GWT Java Server.  If you are not, skip to the sections near the end of
 * this document. <P> <b>Single file upload: "binary" field type</b> <P> To use Smart GWT's
 * client-server upload system, you use a DataSource field of {@link
 * com.smartgwt.client.data.DataSourceField#getType type} "binary".  By default, a DynamicForm
 * bound to a DataSource with a field of type "binary" will use the {@link
 * com.smartgwt.client.widgets.form.fields.FileItem}, which displays a standard HTML &lt;input
 * type="upload"&gt; form control. <P> When you call {@link
 * com.smartgwt.client.widgets.form.DynamicForm#saveData DynamicForm.saveData} on a DynamicForm
 * containing a FileItem, Smart GWT processes the save identically to a saveData() call that did
 * not include a file upload: <ul> <li> if you are using the built-in SQL connectors via
 * serverType:"sql", the file will be saved to SQL as described under {@link
 * com.smartgwt.client.types.FieldType field type "binary"}. <li> if you have server-side business
 * logic, the inbound request may be routed to your business logic via RPCManager dispatch or DMI
 * declarations as normal, your business logic will receive a normal DSRequest, and you are
 * expected to provide a normal DSResponse. </ul> <P> Client-side callbacks, such as the callback
 * passed to saveData(), fire normally. <P> <b>Processing File Uploads with server-side business
 * logic</b> <P> Server-side business logic that processes file uploads may retrieve upload files
 * via the server side API dsRequest.getUploadedFile(<i>fieldName</i>).  The uploaded file is
 * returned as an instance of ISCFileItem, which provides access to a Java InputStream as well as
 * metadata about the file (size, name).   See the
 * ${isc.DocUtils.linkForDocNode('javaServerReference', 'Java Server Reference')} for details. <P>
 * <span style="color:red;font-weight:bold;">NOTE:</span> request processing engines such as
 * Struts may parse the inbound request before Smart GWT receives it.  If you are creating an
 * RPCManager object inside of a Struts Action and the file being uploaded is not available via
 * <code>dsRequest.getUploadedFile()</code>, this is likely to be the problem, and you should use
 * Smart GWT {@link com.smartgwt.client.docs.DmiOverview DMI} instead. <P> Server-side validation
 * errors may be provided, including validation errors for the uploaded file (such as too large or
 * invalid content), and will be displayed in the form that attempted an upload. <P> Be aware of
 * the following special concerns when processing file uploads: <ul> <li> if you provide your own
 * Java Servlet or JSP that creates an instance of RPCManager in order process Smart GWT requests,
 * many APIs of the HttpServletRequest are not safe to call before you have created the
 * RPCManager, passing in the HttpServletRequest.  These include getReader(), getParameter() and
 * other commonly called methods.  This is a limitation of Java Servlets, not specific to Smart
 * GWT <li> unlike other DataSource "add" and "update" operations, you are not expected to return
 * the file as part of the data returned in the DSResponse </ul> <P> <b>Multi file upload:
 * MultiFileItem</b> <P> The MultiFileItem provides an interface for a user to save one or more
 * files that are related to a DataSource record, where each file is represented by a record in a
 * related DataSource. <P> See the {@link com.smartgwt.client.widgets.form.fields.MultiFileItem}
 * docs for details. <P> <b>Upload without the Smart GWT Server</b> <P> If it is acceptable that
 * the application will do a full-page reload after the upload completes, you can simply: <ul>
 * <li> set {@link com.smartgwt.client.widgets.form.DynamicForm#getEncoding encoding} to
 * "multipart" <li> include an {@link com.smartgwt.client.widgets.form.fields.UploadItem} to get a
 * basic HTML upload control <li> set {@link
 * com.smartgwt.client.widgets.form.DynamicForm#getAction action} to a URL where you have deployed
 * server-side code to handle the upload <li> call {@link
 * com.smartgwt.client.widgets.form.DynamicForm#submitForm DynamicForm.submitForm} to cause the
 * form to be submitted </ul> This cause the DynamicForm component to submit to the form.action
 * URL like an ordinary HTML &lt;form&gt; element.  Many  <a
 * href='http://www.google.com/search?q=html+file+upload+example'
 * onclick="window.open('http://www.google.com/search?q=html+file+upload+example');return
 * false;">online tutorials</a> are available which explain how to handle HTML form file upload in
 * various server-side technologies. <P> Note that when you submitForm(), the only values that
 * will be sent to your actionURL are  values for which actual FormItems exist.  This differs from
 * saveData(), in which the entire set of {@link
 * com.smartgwt.client.widgets.form.DynamicForm#getValues form values} are always sent.  To handle
 * submitting extra values, use {@link com.smartgwt.client.widgets.form.fields.HiddenItem}s. <P>
 * For further details, see the {@link com.smartgwt.client.widgets.form.fields.UploadItem} docs.
 * <P> <b>Background upload without the Smart GWT Server</b> <P> Achieving background file upload
 * without using the Smart GWT server is also possible although considerably more advanced.  In
 * addition to the steps above, create a hidden &lt;iframe&gt; element in the page, and use {@link
 * com.smartgwt.client.widgets.form.DynamicForm#getTarget target} to target the form submission at
 * this IFRAME.  In order receive a callback notification when the upload completes, after
 * processing the file upload, your server should output HTML content for the IFRAME that includes
 * a &lt;SCRIPT&gt; block which will navigate out of the IFRAME (generally via the JavaScript
 * global "top") and call a global method you have declared as a callback.
 * @see com.smartgwt.client.widgets.form.fields.UploadItem
 * @see com.smartgwt.client.widgets.form.fields.FileItem
 * @see com.smartgwt.client.widgets.form.fields.MultiFileItem
 * @see com.smartgwt.client.widgets.MultiFilePicker
 * @see com.smartgwt.client.widgets.form.fields.ViewFileItem
 */
public interface Upload {
}
