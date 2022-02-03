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
import com.smartgwt.client.data.Record;
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

import com.google.gwt.event.shared.*;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.core.client.JavaScriptObject;

import com.smartgwt.client.util.*;
import com.smartgwt.client.util.events.*;
import com.smartgwt.client.util.workflow.*;
import com.smartgwt.client.util.workflow.Process; // required to override java.lang.Process


/**
 * Settings for use with {@link com.smartgwt.client.data.DataSource#recordsFromText DataSource.recordsFromText()}.
 */
@BeanFactory.FrameworkClass
@BeanFactory.ScClassName("TextImportSettings")
public class TextImportSettings extends TextSettings {

    public static TextImportSettings getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        BaseClass obj = BaseClass.getRef(jsObj);
        if(obj != null) {
            return (TextImportSettings) obj;
        } else {
            return new TextImportSettings(jsObj);
        }
    }
        


    public TextImportSettings(){
        scClassName = "TextImportSettings";
    }

    public TextImportSettings(JavaScriptObject jsObj){
        scClassName = "TextImportSettings";
        setJavaScriptObject(jsObj);
    }

    public native JavaScriptObject create()/*-{
        var config = this.@com.smartgwt.client.core.BaseClass::getConfig()();
        var scClassName = this.@com.smartgwt.client.core.BaseClass::scClassName;
        return $wnd.isc[scClassName].create(config);
    }-*/;

    // ********************* Properties / Attributes ***********************

    /**
     * If set to true, the data is assumed to have a header line that lists titles for each field, which should be parsed.  
     * <P> <code>recordsFromText</code> will then try to find a same-named DataSourceField by checking parsed titles against
     * both {@link com.smartgwt.client.data.DataSourceField#getTitle DataSourceField.title} and {@link
     * com.smartgwt.client.data.DataSourceField#getName DataSourceField.name} (titles first), doing a case-insensitive
     * comparison with any leading or trailing whitespace removed from the title.  If no field matches, data will appear in the
     * returned Records under the exact title parsed from the header line. <P> If this approach will not find appropriate
     * DataSourceFields, parse the header line before calling <code>recordsFromText()</code>, and provide the list of field
     * names to use when parsing data as {@link com.smartgwt.client.data.TextSettings#getFieldList TextSettings.fieldList}.
     *
     * @param hasHeaderLine New hasHeaderLine value. Default value is false
     * @return {@link com.smartgwt.client.data.TextImportSettings TextImportSettings} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public TextImportSettings setHasHeaderLine(Boolean hasHeaderLine)  throws IllegalStateException {
        return (TextImportSettings)setAttribute("hasHeaderLine", hasHeaderLine, false);
    }

    /**
     * If set to true, the data is assumed to have a header line that lists titles for each field, which should be parsed.  
     * <P> <code>recordsFromText</code> will then try to find a same-named DataSourceField by checking parsed titles against
     * both {@link com.smartgwt.client.data.DataSourceField#getTitle DataSourceField.title} and {@link
     * com.smartgwt.client.data.DataSourceField#getName DataSourceField.name} (titles first), doing a case-insensitive
     * comparison with any leading or trailing whitespace removed from the title.  If no field matches, data will appear in the
     * returned Records under the exact title parsed from the header line. <P> If this approach will not find appropriate
     * DataSourceFields, parse the header line before calling <code>recordsFromText()</code>, and provide the list of field
     * names to use when parsing data as {@link com.smartgwt.client.data.TextSettings#getFieldList TextSettings.fieldList}.
     *
     * @return Current hasHeaderLine value. Default value is false
     */
    public Boolean getHasHeaderLine()  {
        Boolean result = getAttributeAsBoolean("hasHeaderLine");
        return result == null ? false : result;
    }
    

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************

    // ***********************************************************

}
