
package com.smartgwt.client.docs;

/**
 * SmartGWT provides special client and server-side support for file upload that allows&#010 uploaded files to be treated like ordinary DataSource fields.  This includes:&#010 <ul>&#010 <li>the {@link com.smartgwt.client.widgets.form.fields.FileItem} and {@link com.smartgwt.client..MultiFileItem} FormItems that enable users to upload one or&#010 more files as a background operation, without leaving the current page&#010 <li>server-side support that allows binary uploads to be treated as a normal DataSource field&#010 values, with all other aspects of server-side integration unchanged&#010 <li>built-in SQL DataSource support that can store and retrieve uploaded files from SQL&#010 databases&#010 </ul>&#010 The following documentation assumes you are using the SmartGWT Java Server.  If you are&#010 not, skip to the sections near the end of this document.&#010 <P>&#010 <b>Single file upload: "binary" field type</b>&#010 <P>&#010 To use SmartGWT's client-server upload system, you use a DataSource field of&#010 {@link com.smartgwt.client.data.DataSourceField#getType type} "binary".  By default, a DynamicForm bound to a DataSource&#010 with a field of type "binary" will use the {@link com.smartgwt.client.widgets.form.fields.FileItem}, which displays a standard HTML&#010 &lt;input type="upload"&gt; form control.&#010 <P>&#010 When you call {@link com.smartgwt.client.widgets.form.DynamicForm#saveData} on a DynamicForm containing a FileItem,&#010 SmartGWT processes the save identically to a saveData() call that did not include a file&#010 upload:&#010 <ul>&#010 <li> if you are using the built-in SQL connectors via serverType:"sql", the file will be&#010 saved to SQL as described under ${isc.DocUtils.linkForRef('type:FieldType','field type "binary"')}.&#010 <li> if you have server-side business logic, the inbound request may be routed to your&#010 business logic via RPCManager dispatch or DMI declarations as normal, your business logic&#010 will receive a normal DSRequest, and you are expected to provide a normal DSResponse.&#010 </ul>&#010 <P>&#010 Client-side callbacks, such as the callback passed to saveData(), fire normally.&#010 <P>&#010 <b>Processing File Uploads with server-side business logic</b>&#010 <P>&#010 Server-side business logic that processes file uploads may retrieve upload files via the&#010 server side API dsRequest.getUploadedFile(<i>fieldName</i>).  The uploaded file is returned&#010 as an instance of ISCFileItem, which provides access to a Java InputStream as well as&#010 metadata about the file (size, name).  &#010 See the ${isc.DocUtils.linkForDocNode('javaServerReference', 'Java Server Reference')} for details.&#010 <P>&#010 <span style="color:red;font-weight:bold;">NOTE:</span> request processing engines such as&#010 Struts may parse the inbound request before SmartGWT receives it.  If you are creating an&#010 RPCManager object inside of a Struts Action and the file being uploaded is not available via&#010 <code>dsRequest.getUploadedFile()</code>, this is likely to be the problem, and you should&#010 use SmartGWT {@link com.smartgwt.client..DMI} instead.&#010 <P>&#010 Server-side validation errors may be provided, including validation errors for the uploaded&#010 file (such as too large or invalid content), and will be displayed in the form that&#010 attempted an upload.&#010 <P>&#010 Be aware of the following special concerns when processing file uploads:&#010 <ul>&#010 <li> if you provide your own Java Servlet or JSP that creates an instance of RPCManager in&#010 order process SmartGWT requests, many APIs of the HttpServletRequest are not safe to call&#010 before you have created the RPCManager, passing in the HttpServletRequest.  These include&#010 getReader(), getParameter() and other commonly called methods.  This is a limitation of&#010 Java Servlets, not specific to SmartGWT&#010 <li> unlike other DataSource "add" and "update" operations, you are not expected to return&#010 the file as part of the data returned in the DSResponse&#010 </ul>&#010 <P>&#010 <b>Multi file upload: MultiFileItem</b>&#010 <P>&#010 The MultiFileItem provides an interface for a user to save one or more files that are&#010 related to a DataSource record, where each file is represented by a record in a&#010 related DataSource.&#010 <P>&#010 See the {@link com.smartgwt.client..MultiFileItem} docs for details.&#010 <P>&#010 <b>Upload without the SmartGWT Server</b>&#010 <P>&#010 If it is acceptable that the application will do a full-page reload after the upload&#010 completes, you can simply:&#010 <ul>&#010 <li> set {@link com.smartgwt.client.widgets.form.DynamicForm#getEncoding encoding} to "multipart"&#010 <li> include an {@link com.smartgwt.client.widgets.form.fields.UploadItem} to get a basic HTML upload control&#010 <li> set {@link com.smartgwt.client.widgets.form.DynamicForm#getAction action} to a URL where you have deployed server-side code to&#010 handle the upload&#010 <li> call {@link com.smartgwt.client.widgets.form.DynamicForm#submitForm} to cause the form to be submitted&#010 </ul>&#010 This cause the DynamicForm component to submit to the form.action URL like an ordinary HTML&#010 &lt;form&gt; element.  Many &#010 <a href='http://www.google.com/search?q=html+file+upload+example' onclick="window.open('http://www.google.com/search?q=html+file+upload+example');return false;">online tutorials</a>&#010 are available which explain how to handle HTML form file upload in various server-side&#010 technologies.&#010 <P>&#010 Note that when you submitForm(), the only values that will be sent to your actionURL are &#010 values for which actual FormItems exist.  This differs from saveData(), in which the&#010 entire set of {@link com.smartgwt.client.widgets.form.DynamicForm#getValues values} are always sent.  To handle submitting&#010 extra values, use {@link com.smartgwt.client.widgets.form.fields.HiddenItem}s.&#010 <P>&#010 For further details, see the {@link com.smartgwt.client.widgets.form.fields.UploadItem} docs.&#010 <P>&#010 <b>Background upload without the SmartGWT Server</b>&#010 <P>&#010 Achieving background file upload without using the SmartGWT server is also possible&#010 although considerably more advanced.  In addition to the steps above, create a hidden&#010 &lt;iframe&gt; element in the page, and use {@link com.smartgwt.client.widgets.form.DynamicForm#getTarget target} to target the form&#010 submission at this IFRAME.  In order receive a callback notification when the upload&#010 completes, after processing the file upload, your server should output HTML content for the&#010 IFRAME that includes a &lt;SCRIPT&gt; block which will navigate out of the IFRAME (generally&#010 via the JavaScript global "top") and call a global method you have declared as a callback.
 * @see com.smartgwt.client.widgets.grid.ListGrid#getAutoFitMaxColumns
 * @see com.smartgwt.client.widgets.grid.ListGrid#getAutoFitMaxColumns
 * @see com.smartgwt.client.widgets.grid.ListGrid#getAutoFitMaxColumns
 * @see com.smartgwt.client.widgets.grid.ListGrid#getAutoFitMaxColumns
 */
public interface Upload {
}
