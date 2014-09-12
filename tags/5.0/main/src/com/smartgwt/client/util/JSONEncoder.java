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
 
package com.smartgwt.client.util;


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
 * Class for encoding objects as JSON strings.
 */
@BeanFactory.FrameworkClass
@BeanFactory.ScClassName("JSONEncoder")
public class JSONEncoder extends BaseClass {

    public static JSONEncoder getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        BaseClass obj = BaseClass.getRef(jsObj);
        if(obj != null) {
            return (JSONEncoder) obj;
        } else {
            return new JSONEncoder(jsObj);
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


    public JSONEncoder(){
        scClassName = "JSONEncoder";
    }

    public JSONEncoder(JavaScriptObject jsObj){
        scClassName = "JSONEncoder";
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
     * The string marker used to represent circular references.  See {@link
     * com.smartgwt.client.util.JSONEncoder#getCircularReferenceMode circularReferenceMode}.
     *
     * @param circularReferenceMarker  Default value is "$$BACKREF$$"
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setCircularReferenceMarker(String circularReferenceMarker)  throws IllegalStateException {
        setAttribute("circularReferenceMarker", circularReferenceMarker, false);
    }

    /**
     * The string marker used to represent circular references.  See {@link
     * com.smartgwt.client.util.JSONEncoder#getCircularReferenceMode circularReferenceMode}.
     *
     * @return String
     */
    public String getCircularReferenceMarker()  {
        return getAttributeAsString("circularReferenceMarker");
    }
    

    /**
     * What the JSONEncoder should do if it encounters a circular reference.
     *
     * @param circularReferenceMode  Default value is "path"
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setCircularReferenceMode(JSONCircularReferenceMode circularReferenceMode)  throws IllegalStateException {
        setAttribute("circularReferenceMode", circularReferenceMode == null ? null : circularReferenceMode.getValue(), false);
    }

    /**
     * What the JSONEncoder should do if it encounters a circular reference.
     *
     * @return JSONCircularReferenceMode
     */
    public JSONCircularReferenceMode getCircularReferenceMode()  {
        return EnumUtil.getEnum(JSONCircularReferenceMode.values(), getAttribute("circularReferenceMode"));
    }
    

    /**
     * Format for encoding JavaScript Date values in JSON.  See {@link com.smartgwt.client.types.JSONDateFormat} for valid
     * options, or override {@link com.smartgwt.client.util.JSONEncoder#encodeDate JSONEncoder.encodeDate} to do something
     * custom.
     *
     * @param dateFormat  Default value is "xmlSchema"
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setDateFormat(JSONDateFormat dateFormat)  throws IllegalStateException {
        setAttribute("dateFormat", dateFormat == null ? null : dateFormat.getValue(), false);
    }

    /**
     * Format for encoding JavaScript Date values in JSON.  See {@link com.smartgwt.client.types.JSONDateFormat} for valid
     * options, or override {@link com.smartgwt.client.util.JSONEncoder#encodeDate JSONEncoder.encodeDate} to do something
     * custom.
     *
     * @return JSONDateFormat
     */
    public JSONDateFormat getDateFormat()  {
        return EnumUtil.getEnum(JSONDateFormat.values(), getAttribute("dateFormat"));
    }
    

    /**
     * Whether to add indentation to the returned JSON string.  This makes the returned JSON much easier to read but adds size.
     * Note that when delivering JSON responses compressed, the size difference between prettyPrinted JSON and normal JSON is
     * negligible.
     *
     * @param prettyPrint  Default value is true
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setPrettyPrint(Boolean prettyPrint)  throws IllegalStateException {
        setAttribute("prettyPrint", prettyPrint, false);
    }

    /**
     * Whether to add indentation to the returned JSON string.  This makes the returned JSON much easier to read but adds size.
     * Note that when delivering JSON responses compressed, the size difference between prettyPrinted JSON and normal JSON is
     * negligible.
     *
     * @return Boolean
     */
    public Boolean getPrettyPrint()  {
        Boolean result = getAttributeAsBoolean("prettyPrint");
        return result == null ? true : result;
    }
    

    /**
     * Controls the output of the JSONEncoder when instances of Smart GWT classes (eg a ListGrid) are included in the data to
     * be serialized.  See {@link com.smartgwt.client.types.JSONInstanceSerializationMode}. <P> Note that the JSONEncoder does
     * not support a format that will recreate the instance if passed to decode() or eval().
     *
     * @param serializeInstances  Default value is "long"
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setSerializeInstances(JSONInstanceSerializationMode serializeInstances)  throws IllegalStateException {
        setAttribute("serializeInstances", serializeInstances == null ? null : serializeInstances.getValue(), false);
    }

    /**
     * Controls the output of the JSONEncoder when instances of Smart GWT classes (eg a ListGrid) are included in the data to
     * be serialized.  See {@link com.smartgwt.client.types.JSONInstanceSerializationMode}. <P> Note that the JSONEncoder does
     * not support a format that will recreate the instance if passed to decode() or eval().
     *
     * @return JSONInstanceSerializationMode
     */
    public JSONInstanceSerializationMode getSerializeInstances()  {
        return EnumUtil.getEnum(JSONInstanceSerializationMode.values(), getAttribute("serializeInstances"));
    }
    

    /**
     * If objects that cannot be serialized to JSON are encountered during serialization, show a placeholder rather than just
     * omitting them.  <P> The resulting String will not be valid JSON and so cannot be decoded/eval()'d
     *
     * @param showDebugOutput  Default value is false
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setShowDebugOutput(Boolean showDebugOutput)  throws IllegalStateException {
        setAttribute("showDebugOutput", showDebugOutput, false);
    }

    /**
     * If objects that cannot be serialized to JSON are encountered during serialization, show a placeholder rather than just
     * omitting them.  <P> The resulting String will not be valid JSON and so cannot be decoded/eval()'d
     *
     * @return Boolean
     */
    public Boolean getShowDebugOutput()  {
        Boolean result = getAttributeAsBoolean("showDebugOutput");
        return result == null ? false : result;
    }
    

    /**
     * If true, don't show Smart GWT internal properties when encoding and object.
     *
     * @param skipInternalProperties  Default value is false
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setSkipInternalProperties(Boolean skipInternalProperties)  throws IllegalStateException {
        setAttribute("skipInternalProperties", skipInternalProperties, false);
    }

    /**
     * If true, don't show Smart GWT internal properties when encoding and object.
     *
     * @return Boolean
     */
    public Boolean getSkipInternalProperties()  {
        Boolean result = getAttributeAsBoolean("skipInternalProperties");
        return result == null ? false : result;
    }
    

    /**
     * Whether all property names should be quoted, or only those property names that are not valid
     *  identifiers or are JavaScript reserved words (such as "true").
     *  <P>
     *  Encoding only where required produces slightly shorter, more readable output which is still
     *  compatible with JavaScript's eval():
     *  <pre>
     *  {
     *      someProp : "someValue",
     *      "true" : "otherValue",
     *      otherProp : "otherValue"
     *  }
     *  </pre>
     *  .. but is not understood by many server-side JSON parser implementations.
     *
     * @param strictQuoting  Default value is true
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setStrictQuoting(Boolean strictQuoting)  throws IllegalStateException {
        setAttribute("strictQuoting", strictQuoting, false);
    }

    /**
     * Whether all property names should be quoted, or only those property names that are not valid
     *  identifiers or are JavaScript reserved words (such as "true").
     *  <P>
     *  Encoding only where required produces slightly shorter, more readable output which is still
     *  compatible with JavaScript's eval():
     *  <pre>
     *  {
     *      someProp : "someValue",
     *      "true" : "otherValue",
     *      otherProp : "otherValue"
     *  }
     *  </pre>
     *  .. but is not understood by many server-side JSON parser implementations.
     *
     * @return Boolean
     */
    public Boolean getStrictQuoting()  {
        Boolean result = getAttributeAsBoolean("strictQuoting");
        return result == null ? true : result;
    }
    

    // ********************* Methods ***********************


	/**
     * Encode a JavaScript Date value. <P> By default, follows the {@link com.smartgwt.client.util.JSONEncoder#getDateFormat
     * dateFormat} setting.  Override to do custom encoding.
     * @param theDate JavaScript date object to be serialized
     *
     * @return value to be included in result.  <b>If this value is intended to appear                  as a String it should include
     * quotes (")</b>
     */
    public native String encodeDate(Date theDate) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.encodeDate(@com.smartgwt.client.util.JSOHelper::convertToJavaScriptDate(Ljava/util/Date;)(theDate));
        return ret;
    }-*/;



    // ********************* Static Methods ***********************

    // ***********************************************************


    
    /**
     * Serialize an object as a JSON string.
     * <P>
     * Because GWT does not support Java reflection, JSON encoding cannot
     * discover the properties of an arbitrary Java POJO.  The following 
     * objects are supported:
     * <ul>
     * <li> any primitive type (String, Date, Number, Boolean)
     * <li> any Map or Collection in any level of nesting
     * <li> DataClass (Record's superclass) and RecordList
     * <li> any widget (see +link{JSONEncoder.serializeInstances})
     * <li> JavaScriptObject
     * <li> an Array containing any of the above
     * </ul>
     * <P>
     * Note that using the String produced by this API with 
     * {@link com.smartgwt.client.util.JSON#decode JSON.decode} 
     * <b>will not successfully preserve dates</b>. Use 
     * {@link com.smartgwt.client.util.JSONEncoder#setDateFormat JSONEncoder.setDateFormat}
     * "dateConstructor" to have dates round-trip properly.
     *
     * @param object object to serialize
     * @return object encoded as a JSON String
     */
    public native String encode(Object object) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        return self.encode(object);
    }-*/;
    
    /**
     * Serialize an object as a JSON string.
     * <P>
     * Because GWT does not support Java reflection, JSON encoding cannot
     * discover the properties of an arbitrary Java POJO.  The following 
     * objects are supported:
     * <ul>
     * <li> any primitive type (String, Date, Number, Boolean)
     * <li> any Map or Collection in any level of nesting
     * <li> DataClass (Record's superclass) and RecordList
     * <li> any widget (see +link{JSONEncoder.serializeInstances})
     * <li> JavaScriptObject
     * <li> an Array containing any of the above
     * </ul>
     * <P>
     * Note that using the String produced by this API with 
     * {@link com.smartgwt.client.util.JSON#decode JSON.decode}
     * <b>will not successfully preserve dates</b>. Use 
     * {@link com.smartgwt.client.util.JSONEncoder#setDateFormat JSONEncoder.setDateFormat}
     * "dateConstructor" to have dates round-trip properly.
     *
     * @param object object to serialize
     * @return object encoded as a JSON String
     */
    public native String encode(DataClass object) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var jsObj = object.@com.smartgwt.client.core.DataClass::getJsObj()();
        return self.encode(jsObj);
    
    }-*/;
    
    /**
     * Serialize an object as a JSON string.
     * <P>
     * Because GWT does not support Java reflection, JSON encoding cannot
     * discover the properties of an arbitrary Java POJO.  The following 
     * objects are supported:
     * <ul>
     * <li> any primitive type (String, Date, Number, Boolean)
     * <li> any Map or Collection in any level of nesting
     * <li> DataClass (Record's superclass) and RecordList
     * <li> any widget (see +link{JSONEncoder.serializeInstances})
     * <li> JavaScriptObject
     * <li> an Array containing any of the above
     * </ul>
     * <P>
     * Note that using the String produced by this API with 
     * {@link com.smartgwt.client.util.JSON#decode JSON.decode}
     * <b>will not successfully preserve dates</b>. Use 
     * {@link com.smartgwt.client.util.JSONEncoder#setDateFormat JSONEncoder.setDateFormat}
     * "dateConstructor" to have dates round-trip properly.
     *
     * @param object object to serialize
     * @return object encoded as a JSON String
     */
    public native String encode (BaseClass object) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var jsObj = object.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        return self.encode(jsObj);
    }-*/;

    /**
     * Convert the passed string as Javascript
     *
     * @param stringToJs the string to convert
     * @return the JavaScriptObject upon evaluation
     */
    public static native JavaScriptObject decode(String stringToJs) /*-{
		if(!($wnd.isc.startsWith(stringToJs, '(') && $wnd.isc.endsWith(stringToJs, ')'))) {
            stringToJs = '(' + stringToJs + ')';
        }
        return $wnd.isc.Class.evaluate(stringToJs);
	}-*/;


}


