
package com.smartgwt.client.docs;

/**
 * <h3>FileSource Operations</h3>
 * These APIs allow a {@link com.smartgwt.client.data.DataSource} to be used as a way to store
 * files in a DataSource that might otherwise be stored in a filesystem on the server. They are
 * implemented by sending requests to the server with a special {@link
 * com.smartgwt.client.types.DSOperationType operationType}. <p>FileSource operations use
 * standardized field names: fileName, fileType, fileFormat, fileContents, fileSize,
 * fileLastModified and optionally fileVersion. These are  translated on the server to native
 * field names for the {@link com.smartgwt.client.data.DataSource}, determined  according to the
 * DataSource configuration for  {@link com.smartgwt.client.docs.serverds.DataSource#fileNameField
 * fileNameField}, {@link com.smartgwt.client.docs.serverds.DataSource#fileTypeField
 * fileTypeField}, {@link com.smartgwt.client.docs.serverds.DataSource#fileFormatField
 * fileFormatField}, {@link com.smartgwt.client.docs.serverds.DataSource#fileContentsField
 * fileContentsField}, {@link com.smartgwt.client.docs.serverds.DataSource#fileLastModifiedField
 * fileLastModifiedField}, and {@link
 * com.smartgwt.client.docs.serverds.DataSource#fileVersionField fileVersionField}.
     * @see com.smartgwt.client.data.DataSource
 * @see com.smartgwt.client.data.DataSource#makeFileSpec
 * @see com.smartgwt.client.data.DataSource#getFile
 * @see com.smartgwt.client.data.DataSource#hasFile
 * @see com.smartgwt.client.data.DataSource#listFiles
 * @see com.smartgwt.client.data.DataSource#saveFile
 * @see com.smartgwt.client.data.DataSource#renameFile
 * @see com.smartgwt.client.data.DataSource#removeFile
 * @see com.smartgwt.client.data.DataSource#listFileVersions
 * @see com.smartgwt.client.data.DataSource#getFileVersion
 * @see com.smartgwt.client.data.DataSource#hasFileVersion
 * @see com.smartgwt.client.data.DataSource#removeFileVersion
 * @see com.smartgwt.client.data.FileSpec
 * @see com.smartgwt.client.docs.serverds.DataSource#fileNameField
 * @see com.smartgwt.client.docs.serverds.DataSource#fileTypeField
 * @see com.smartgwt.client.docs.serverds.DataSource#fileFormatField
 * @see com.smartgwt.client.docs.serverds.DataSource#fileContentsField
 * @see com.smartgwt.client.docs.serverds.DataSource#fileLastModifiedField
 * @see com.smartgwt.client.docs.serverds.DataSource#fileVersionField
 * @see com.smartgwt.client.docs.serverds.DataSource#maxFileVersions
 * @see com.smartgwt.client.docs.serverds.DataSource#projectFileKey
 * @see com.smartgwt.client.docs.serverds.DataSource#projectFileLocations
 */
public interface FileSource {
}
