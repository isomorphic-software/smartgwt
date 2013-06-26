
package com.smartgwt.client.docs;

/**
 * <h3>Binary Fields</h3>
 * When using the Smart GWT Server framework (included in Pro Edition or better) you can declare a
 * field of type "binary", or certain specific binary types such as "imageFile". <P> UI components
 * such as {@link com.smartgwt.client.widgets.grid.ListGrid} and {@link
 * com.smartgwt.client.widgets.form.fields.FileItem} will offer UIs to download, view and upload
 * files stored in a binary field.  {@link com.smartgwt.client.data.DataSource#downloadFile
 * DataSource.downloadFile} and {@link com.smartgwt.client.data.DataSource#viewFile
 * DataSource.viewFile} can be used to programmatically trigger download/viewing as well.  Note
 * that these automatic features, and components like {@link
 * com.smartgwt.client.widgets.tile.TileGrid}  that make use of them, only work correctly for
 * DataSources that declare a valid  {@link com.smartgwt.client.data.DataSourceField#getPrimaryKey
 * primaryKey} field. <P> As covered under the {@link com.smartgwt.client.types.FieldType "binary"
 * field type description}, binary fields imply 3 other related metadata fields named after the
 * binary field, which store the file size, file name and date of creation. <P> When using one of
 * the built-in server DataSource types (SQL, JPA, Hibernate), these metadata fields, UI controls
 * and APIs will work with no special effort - just declare a binary field.  For JPA or Hibernate
 * the Java getter/setter for the binary field must be of type byte[] or Byte[] (this is imposed
 * by the ORM system); if you  are using the SQL DataSource, no additional declarations are
 * required unless you are using  beanClassName, in which case you must added getters/setters of
 * type InputStream, or one of the types listed for JPA/Hibernate. <P> For metadata fields like
 * the file size, providing storage for the metadata fields (SQL columns or JPA/Hibernate
 * getter/setters) is optional but highly recommended.  If you don't want a particular metadata
 * field, you can declare a &lt;field&gt; for it explicitly and set ignore="true".  <b>Note:</b>
 * If you decide not to store the  "_filename" metadata element, the built-in binary UI controls
 * in components like ListGrid, mentioned above, do not work properly.  In the absence of a
 * filename metadata field,  it is necessary to set {@link
 * com.smartgwt.client.docs.serverds.DataSourceField#mimeType mime-type} on the binary field - 
 * otherwise, we can't make a reasonable guess at a MIME type, so the browser tends  not to know
 * what to do with the downloaded content. Omiting the file size metadata will  simply cause the
 * browser not to show a progress dialog during download, or not to show  an accurate one. <P>
 * <b>Downloading from binary fields</b> <P> If writing a custom DataSource or writing a DMI,
 * implement the "downloadFile" and "viewFile" operationTypes, and return data for a single Record
 * which has binary data  as the field value for the binary field - accepted types are
 * InputStream, byte[], java.sql.Blob or String. <P> For example, you could return a Java bean
 * with a getter method which returns a byte[], and which is named after the binaryField using
 * Java Beans conventions: <code>get<i>FieldName</i>()</code>.  Or, return a Java Map where a
 * byte[] is stored under a key named the same as the binary field's name. <P> As discussed under
 * {@link com.smartgwt.client.types.FieldType}, additional metadata fields are implied when you
 * declare a binary field.  Returning a value for the "_filesize" field will allow the browser to
 * show progress of the download.  Returning a value for the "_filename" field will cause the
 * downloaded file to be named after the "_filename" value. <P> <b>Uploading to binary fields</b>
 * <P> Again with the built-in server DataSource types, no special effort is required. <P> For a
 * custom DataSource, an upload from a {@link com.smartgwt.client.widgets.form.fields.FileItem}
 * control (the default upload control) is treated just like an ordinary "add" or "update"
 * DataSource operation.  The uploaded file(s), if any, are available from the server-side API
 * <code>dsRequest.getUploadedFile()</code>.  Metadata fields such as "_filename" can be populated
 * from the data in the returned ISCFileItem. <P> <b>Binary fields and normal "fetch"</b> <P> For
 * an ordinary "fetch" operation, it's generally useless to return data for a binary field,
 * because in most cases code running in the browser would not be able to do anything with a
 * binary value (such as invoke a PDF viewing plugin).  For this reason the  Smart GWT Server will
 * automatically omit values of type InputStream, byte[] or Blob during a normal "fetch". <p>
 * However you can deliver the binary data to the browser by transforming it to a Base64-encoded
 * String by setting {@link com.smartgwt.client.docs.serverds.DataSourceField#encodeInResponse
 * encodeInResponse} on your &lt;field&gt; declaration.  This can be used with certain browser
 * features such as  <a href='https://www.google.com/search?q=image+data+uri'
 * onclick="window.open('https://www.google.com/search?q=image+data+uri');return false;">image
 * data URIs</a>, but note that some older browsers (notably IE7 and earlier) do not support data
 * URIs.  <P> <b>Downloads unrelated to binary fields</b> <P> If you want to download or view a
 * file that is not stored in a DataSource record, for example, you want to dynamically generate a
 * report of some kind on the fly, any DMI can return a binary response by calling the server-side
 * API <code>RPCManager.doCustomResponse()</code> and writing binary data directly to the
 * ServletResponse outputStream. <P> It's typical to represent an operation that returns a binary
 * stream as a DataSource request with operationType "fetch", especially if it takes Criteria that
 * identify DataSource Records that will be used to create the binary stream.   <P> When
 * initiating such a download, set {@link com.smartgwt.client.rpc.RPCRequest#getDownloadResult
 * downloadResult} via the <code>requestProperties</code> argument of {@link
 * com.smartgwt.client.data.DataSource#fetchData DataSource.fetchData} so that the client-side
 * framework knows that a download will occur instead of a normal response.  In this case,
 * callbacks will not be fired because code in the browser does not receive notification that the
 * download has initiated or has completed. <P> <b>Binary handling without the Smart GWT
 * Server</b> <P> To download or view files with the Smart GWT Server, you can write a servlet
 * that streams back binary data.  For a download, you can then redirect the main page to the
 * servlet using by setting window.location - be sure the download can never fail if you this,
 * because any error message returned by the server in lieu of a file will replace the application
 * instead of triggering a "Save As.." dialog. <P> To view a file, you can open a new browser
 * window to the URL of the servlet.
 */
public interface BinaryFields {
}
