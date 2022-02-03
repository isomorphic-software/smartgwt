package com.smartgwt.client.types;


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
 
/**
 * One of the four basic operations that can be performed on DataSource data: "fetch", "add", "update", "remove". 
 * Elsewhere called CRUD operations, where CRUD stands for "create", "retrieve", "update", "delete", which correspond to
 * "add", "fetch", "update" and "remove" in Smart GWT terminology.  See {@link
 * com.smartgwt.client.docs.DataSourceOperations} for a full description. <p> There are also additional, non-CRUD
 * operations explained below.
 */
public enum DSOperationType implements ValueEnum {
    /**
     * Fetch one or more records that match a set of search criteria.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "fetch".
     */
    FETCH("fetch"),
    /**
     * Store new records
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "add".
     */
    ADD("add"),
    /**
     * Update an existing record
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "update".
     */
    UPDATE("update"),
    /**
     * Remove (delete) an existing record
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "remove".
     */
    REMOVE("remove"),
    /**
     * perform some arbitrary custom logic that is not a CRUD operation. Format of the inputs and outputs is unconstrained, and
     * the operation will be ignored for cache sync purposes by {@link com.smartgwt.client.data.ResultSet}s. See  {@link
     * com.smartgwt.client.data.DataSource#performCustomOperation DataSource.performCustomOperation()}.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "custom".
     */
    CUSTOM("custom"),
    /**
     * Run server-side validation for "add" or "update" without actually adding or updating anything. See {@link
     * com.smartgwt.client.data.DataSource#validateData DataSource.validateData()}.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "validate".
     */
    VALIDATE("validate"),
    /**
     * Retrieve a file stored in a binary field in a DataSource record, and allow the browser to choose whether to view it
     * directly or prompt the user to save. See {@link com.smartgwt.client.docs.BinaryFields}.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "viewFile".
     */
    VIEWFILE("viewFile"),
    /**
     * Like "viewFile", but the HTTP header Content-Disposition is used to suggest that the browser show a save dialog. See
     * {@link com.smartgwt.client.docs.BinaryFields}.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "downloadFile".
     */
    DOWNLOADFILE("downloadFile"),
    /**
     * Takes a List of Maps and stores the data in Admin Console XML test data format
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "storeTestData".
     */
    STORETESTDATA("storeTestData"),
    /**
     * Upload formatted client data and export it to Excel, XML and other formats. Used automatically by  {@link
     * com.smartgwt.client.data.DataSource#exportClientData exportClientData()}  and cannot be used directly. Usable only with
     * the Smart GWT server framework.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "clientExport".
     */
    CLIENTEXPORT("clientExport"),
    /**
     * Use the DataSource as a {@link com.smartgwt.client.docs.FileSource source for files}. Used automatically by {@link
     * com.smartgwt.client.data.DataSource#getFile DataSource.getFile()}, and would not normally be used directly. Usable only
     * with the Smart GWT server framework.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "getFile".
     */
    GETFILE("getFile"),
    /**
     * Use the DataSource as a {@link com.smartgwt.client.docs.FileSource source for files}. Used automatically by {@link
     * com.smartgwt.client.data.DataSource#hasFile DataSource.hasFile()}, and would not normally be used directly. Usable only
     * with the Smart GWT server framework.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "hasFile".
     */
    HASFILE("hasFile"),
    /**
     * Use the DataSource as a {@link com.smartgwt.client.docs.FileSource source for files}. Used automatically by {@link
     * com.smartgwt.client.data.DataSource#listFiles DataSource.listFiles()}, and would not normally be used directly. Usable
     * only with the Smart GWT server framework.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "listFiles".
     */
    LISTFILES("listFiles"),
    /**
     * Use the DataSource as a {@link com.smartgwt.client.docs.FileSource source for files}. Used automatically by {@link
     * com.smartgwt.client.data.DataSource#removeFile DataSource.removeFile()}, and would not normally be used directly. Usable
     * only with the Smart GWT server framework.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "removeFile".
     */
    REMOVEFILE("removeFile"),
    /**
     * Use the DataSource as a {@link com.smartgwt.client.docs.FileSource source for files}. Used automatically by {@link
     * com.smartgwt.client.data.DataSource#saveFile DataSource.saveFile()}, and would not normally be used directly. Usable
     * only with the Smart GWT server framework.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "saveFile".
     */
    SAVEFILE("saveFile"),
    /**
     * Use the DataSource as a {@link com.smartgwt.client.docs.FileSource source for files}. Used automatically by {@link
     * com.smartgwt.client.data.DataSource#renameFile DataSource.renameFile()}, and would not normally be used directly. Usable
     * only with the Smart GWT server framework.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "renameFile".
     */
    RENAMEFILE("renameFile"),
    /**
     * Use the DataSource as a {@link com.smartgwt.client.docs.FileSource source for files}. Used automatically by {@link
     * com.smartgwt.client.data.DataSource#getFileVersion DataSource.getFileVersion()}, and would not normally be used
     * directly. Usable only with the Smart GWT server framework.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "getFileVersion".
     */
    GETFILEVERSION("getFileVersion"),
    /**
     * Use the DataSource as a {@link com.smartgwt.client.docs.FileSource source for files}. Used automatically by {@link
     * com.smartgwt.client.data.DataSource#hasFileVersion DataSource.hasFileVersion()}, and would not normally be used
     * directly. Usable only with the Smart GWT server framework.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "hasFileVersion".
     */
    HASFILEVERSION("hasFileVersion"),
    /**
     * Use the DataSource as a {@link com.smartgwt.client.docs.FileSource source for files}. Used automatically by {@link
     * com.smartgwt.client.data.DataSource#listFileVersions DataSource.listFileVersions()}, and would not normally be used
     * directly. Usable only with the Smart GWT server framework.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "listFileVersions".
     */
    LISTFILEVERSIONS("listFileVersions"),
    /**
     * Use the DataSource as a {@link com.smartgwt.client.docs.FileSource source for files}. Used automatically by {@link
     * com.smartgwt.client.data.DataSource#removeFileVersion DataSource.removeFileVersion()}, and would not normally be used
     * directly. Usable only with the Smart GWT server framework.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "removeFileVersion".
     */
    REMOVEFILEVERSION("removeFileVersion");
    private String value;

    DSOperationType(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
