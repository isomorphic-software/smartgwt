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
 * Common base class of {@link com.smartgwt.client.data.TextImportSettings}.
 */
@BeanFactory.FrameworkClass
@BeanFactory.ScClassName("TextSettings")
public class TextSettings extends BaseClass {

    public static TextSettings getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        BaseClass obj = BaseClass.getRef(jsObj);
        if(obj != null) {
            return (TextSettings) obj;
        } else {
            return new TextSettings(jsObj);
        }
    }

    public void setJavaScriptObject(JavaScriptObject jsObj) {
        internalSetID(jsObj);
        JSOHelper.setObjectAttribute(jsObj, SC.REF, this);
        JSOHelper.setObjectAttribute(jsObj, SC.MODULE, BeanFactory.getSGWTModule());
        if (!JSOHelper.isScClassInstance(jsObj)) {
            setConfig(jsObj);
            return;
        }
        JSOHelper.setObjectAttribute(getConfig(), SC.REF, this);
        JSOHelper.setObjectAttribute(getConfig(), SC.MODULE, BeanFactory.getSGWTModule());
        this.jsObj = jsObj;
    }


    public TextSettings(){
        scClassName = "TextSettings";
    }

    public TextSettings(JavaScriptObject jsObj){
        scClassName = "TextSettings";
        setJavaScriptObject(jsObj);
    }

    public native JavaScriptObject create()/*-{
        var config = this.@com.smartgwt.client.core.BaseClass::getConfig()();
        var scClassName = this.@com.smartgwt.client.core.BaseClass::scClassName;
        return $wnd.isc[scClassName].create(config);
    }-*/;

    private JavaScriptObject jsObj;
    
    @Override
    public boolean isCreated(){
        return this.jsObj != null;
    }

    @Override
    public JavaScriptObject getJsObj(){
        return this.jsObj;
    }

    @Override
    public JavaScriptObject getOrCreateJsObj() {
        if (!isCreated()) {
            this.jsObj = createJsObj();
            doInit();
        }
        return this.jsObj;
    }


    // ********************* Properties / Attributes ***********************

    /**
     * {@link com.smartgwt.client.types.EscapingMode} expected for escaping special characters embedded in text values.
     *
     * @param escapingMode  Default value is "backslash"
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setEscapingMode(EscapingMode escapingMode)  throws IllegalStateException {
        setAttribute("escapingMode", escapingMode == null ? null : escapingMode.getValue(), false);
    }

    /**
     * {@link com.smartgwt.client.types.EscapingMode} expected for escaping special characters embedded in text values.
     *
     * @return EscapingMode
     */
    public EscapingMode getEscapingMode()  {
        return EnumUtil.getEnum(EscapingMode.values(), getAttribute("escapingMode"));
    }
    

    /**
     * For export, a set of fields to export.  Default is to export all DataSource fields.   <P> Fields may be specified that
     * are not in the DataSource but for which data values are present in the provided Records.  In this case the field is
     * assumed to be of type "text". <p>                                For import, names of DataSource fields to use to parse
     * values, in order. <P> If <code>fieldList</code> is unset, DataSource fields are used, in order. <P> If more values exist
     * in a given Record than the listed fields or than all DataSource fields, remaining values are ignored.
     *
     * @param fieldList  Default value is null
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setFieldList(String... fieldList)  throws IllegalStateException {
        setAttribute("fieldList", fieldList, false);
    }

    /**
     * For export, a set of fields to export.  Default is to export all DataSource fields.   <P> Fields may be specified that
     * are not in the DataSource but for which data values are present in the provided Records.  In this case the field is
     * assumed to be of type "text". <p>                                For import, names of DataSource fields to use to parse
     * values, in order. <P> If <code>fieldList</code> is unset, DataSource fields are used, in order. <P> If more values exist
     * in a given Record than the listed fields or than all DataSource fields, remaining values are ignored.
     *
     * @return String...
     */
    public String[] getFieldList()  {
        return com.smartgwt.client.util.ConvertTo.arrayOfString(getAttributeAsJavaScriptObject("fieldList"));
    }
    

    /**
     * Separator between field values.  Default is a comma character, producing CSV  (comma-separated values) format.
     *
     * @param fieldSeparator  Default value is ","
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setFieldSeparator(String fieldSeparator)  throws IllegalStateException {
        setAttribute("fieldSeparator", fieldSeparator, false);
    }

    /**
     * Separator between field values.  Default is a comma character, producing CSV  (comma-separated values) format.
     *
     * @return String
     */
    public String getFieldSeparator()  {
        return getAttributeAsString("fieldSeparator");
    }
    

    /**
     * Separator between Records.  For import, default of null means that either the Unix/Mac format of just a newline ("\n")
     * or the typical DOS/Windows format of a carriage return and newline ("\r\n") will be accepted.  For export, overridden in
     * {@link com.smartgwt.client.data.TextExportSettings}.
     *
     * @param lineSeparator  Default value is null
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setLineSeparator(String lineSeparator)  throws IllegalStateException {
        setAttribute("lineSeparator", lineSeparator, false);
    }

    /**
     * Separator between Records.  For import, default of null means that either the Unix/Mac format of just a newline ("\n")
     * or the typical DOS/Windows format of a carriage return and newline ("\r\n") will be accepted.  For export, overridden in
     * {@link com.smartgwt.client.data.TextExportSettings}.
     *
     * @return String
     */
    public String getLineSeparator()  {
        return getAttributeAsString("lineSeparator");
    }
    

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************

    // ***********************************************************

}


