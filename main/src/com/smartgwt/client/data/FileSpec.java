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
 
package com.smartgwt.client.data;


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

/**
 * A record which specifies files for use with {@link com.smartgwt.client.docs.FileSource FileSource Operations}.
 * @see com.smartgwt.client.data.DataSource#makeFileSpec
 */
@BeanFactory.FrameworkClass
public class FileSpec extends DataClass {

    public static FileSpec getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        return new FileSpec(jsObj);
    }


    public FileSpec(){
        
    }

    public FileSpec(JavaScriptObject jsObj){
        
        setJavaScriptObject(jsObj);
    }


    public FileSpec(String fileName, String fileType, String fileFormat) {
        setFileName(fileName);
		setFileType(fileType);
		setFileFormat(fileFormat);
                
    }


    // ********************* Properties / Attributes ***********************

    /**
     * The format of the file, e.g. "xml" or "js"
     *
     * @param fileFormat  Default value is null
     */
    public void setFileFormat(String fileFormat) {
        setAttribute("fileFormat", fileFormat);
    }

    /**
     * The format of the file, e.g. "xml" or "js"
     *
     * @return String
     */
    public String getFileFormat()  {
        return getAttributeAsString("fileFormat");
    }
    

    /**
     * The name of the file, without any extension to indicate {@link com.smartgwt.client.data.FileSpec#getFileType type} or
     * {@link com.smartgwt.client.data.FileSpec#getFileFormat format}.
     *
     * @param fileName  Default value is null
     */
    public void setFileName(String fileName) {
        setAttribute("fileName", fileName);
    }

    /**
     * The name of the file, without any extension to indicate {@link com.smartgwt.client.data.FileSpec#getFileType type} or
     * {@link com.smartgwt.client.data.FileSpec#getFileFormat format}.
     *
     * @return String
     */
    public String getFileName()  {
        return getAttributeAsString("fileName");
    }
    

    /**
     * The type of the file, e.g. "ds" for datasource, or "proj" for project.
     *
     * @param fileType  Default value is null
     */
    public void setFileType(String fileType) {
        setAttribute("fileType", fileType);
    }

    /**
     * The type of the file, e.g. "ds" for datasource, or "proj" for project.
     *
     * @return String
     */
    public String getFileType()  {
        return getAttributeAsString("fileType");
    }
    

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************

    // ***********************************************************


    /** 
     * Constructs a FileSpec from a path. For instance, "employees.ds.xml" would
     * be converted to {fileName: "employees", fileType: "ds", fileFormat: "xml"}.
     * @param path The path to convert.
     */
    public FileSpec (String path) {
        this(parsePath(path));
    }

    protected static native JavaScriptObject parsePath (String path) /*-{
        return $wnd.isc.DataSource.makeFileSpec(path);
    }-*/;

}


