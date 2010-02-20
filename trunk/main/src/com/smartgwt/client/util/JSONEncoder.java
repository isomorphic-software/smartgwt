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
 
package com.smartgwt.client.util;



import com.smartgwt.client.event.*;
import com.smartgwt.client.core.*;
import com.smartgwt.client.types.*;
import com.smartgwt.client.data.*;
import com.smartgwt.client.data.events.*;
import com.smartgwt.client.rpc.*;
import com.smartgwt.client.widgets.*;
import com.smartgwt.client.widgets.events.*;
import com.smartgwt.client.widgets.form.*;
import com.smartgwt.client.widgets.form.validator.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.tile.*;
import com.smartgwt.client.widgets.tile.events.*;
import com.smartgwt.client.widgets.grid.*;
import com.smartgwt.client.widgets.grid.events.*;
import com.smartgwt.client.widgets.layout.*;
import com.smartgwt.client.widgets.menu.*;
import com.smartgwt.client.widgets.tab.*;
import com.smartgwt.client.widgets.toolbar.*;
import com.smartgwt.client.widgets.tree.*;
import com.smartgwt.client.widgets.tree.events.*;
import com.smartgwt.client.widgets.viewer.*;
import com.smartgwt.client.widgets.calendar.*;
import com.smartgwt.client.widgets.calendar.events.*;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;
import com.smartgwt.client.util.*;
import com.google.gwt.event.shared.*;
import com.google.gwt.event.shared.HasHandlers;

/**
 * Class for encoding objects as JSON strings.
 */
public class JSONEncoder extends DataClass {

    public static JSONEncoder getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        return new JSONEncoder(jsObj);
    }

    public JSONEncoder(){
        
    }

    public JSONEncoder(JavaScriptObject jsObj){
        super(jsObj);
    }

    // ********************* Properties / Attributes ***********************

    /**
     * The string marker used to represent circular references.  See {@link
     * com.smartgwt.client.util.JSONEncoder#getCircularReferenceMode circularReferenceMode}.
     *
     * @param circularReferenceMarker circularReferenceMarker Default value is "$$BACKREF$$"
     */
    public void setCircularReferenceMarker(String circularReferenceMarker) {
        setAttribute("circularReferenceMarker", circularReferenceMarker);
    }

    /**
     * The string marker used to represent circular references.  See {@link
     * com.smartgwt.client.util.JSONEncoder#getCircularReferenceMode circularReferenceMode}.
     *
     *
     * @return String
     */
    public String getCircularReferenceMarker()  {
        return getAttributeAsString("circularReferenceMarker");
    }
 
    /**
     * What the JSONEncoder should do if it encounters a circular reference.
     *
     * @param circularReferenceMode circularReferenceMode Default value is "path"
     */
    public void setCircularReferenceMode(JSONCircularReferenceMode circularReferenceMode) {
        setAttribute("circularReferenceMode", circularReferenceMode.getValue());
    }

    /**
     * What the JSONEncoder should do if it encounters a circular reference.
     *
     *
     * @return JSONCircularReferenceMode
     */
    public JSONCircularReferenceMode getCircularReferenceMode()  {
        return EnumUtil.getEnum(JSONCircularReferenceMode.values(), getAttribute("circularReferenceMode"));
    }
 
    /**
     * Format for encoding JavaScript Date values in JSON.  See {@link com.smartgwt.client.types.JSONDateFormat} for valid
     * options, or override {@link com.smartgwt.client.util.JSONEncoder#encodeDate} to do something custom.
     *
     * @param dateFormat dateFormat Default value is "xmlSchema"
     */
    public void setDateFormat(JSONDateFormat dateFormat) {
        setAttribute("dateFormat", dateFormat.getValue());
    }

    /**
     * Format for encoding JavaScript Date values in JSON.  See {@link com.smartgwt.client.types.JSONDateFormat} for valid
     * options, or override {@link com.smartgwt.client.util.JSONEncoder#encodeDate} to do something custom.
     *
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
     * @param prettyPrint prettyPrint Default value is true
     */
    public void setPrettyPrint(Boolean prettyPrint) {
        setAttribute("prettyPrint", prettyPrint);
    }

    /**
     * Whether to add indentation to the returned JSON string.  This makes the returned JSON much easier to read but adds size.
     * Note that when delivering JSON responses compressed, the size difference between prettyPrinted JSON and normal JSON is
     * negligible.
     *
     *
     * @return Boolean
     */
    public Boolean getPrettyPrint()  {
        return getAttributeAsBoolean("prettyPrint");
    }

    /**
     * If false, output all Smart GWT objects with a call to ${isc.DocUtils.linkForRef('isc.echoLeaf')}
     *
     * @param serializeInstances serializeInstances Default value is true
     */
    public void setSerializeInstances(Boolean serializeInstances) {
        setAttribute("serializeInstances", serializeInstances);
    }

    /**
     * If false, output all Smart GWT objects with a call to ${isc.DocUtils.linkForRef('isc.echoLeaf')}
     *
     *
     * @return Boolean
     */
    public Boolean getSerializeInstances()  {
        return getAttributeAsBoolean("serializeInstances");
    }

    /**
     * Whether all property names should be quoted, or only those property names that are not valid&#010 identifiers or are
     * JavaScript reserved words (such as "true").&#010 <P>&#010 Encoding only where required produces slightly shorter, more
     * readable output which is still&#010 compatible with JavaScript's eval():&#010 <pre>&#010 {&#010     someProp :
     * "someValue",&#010     "true" : "otherValue",&#010     otherProp : "otherValue"&#010 }&#010 </pre>&#010 .. but is not
     * understood by many server-side JSON parser implementations.
     *
     * @param strictQuoting strictQuoting Default value is true
     */
    public void setStrictQuoting(Boolean strictQuoting) {
        setAttribute("strictQuoting", strictQuoting);
    }

    /**
     * Whether all property names should be quoted, or only those property names that are not valid&#010 identifiers or are
     * JavaScript reserved words (such as "true").&#010 <P>&#010 Encoding only where required produces slightly shorter, more
     * readable output which is still&#010 compatible with JavaScript's eval():&#010 <pre>&#010 {&#010     someProp :
     * "someValue",&#010     "true" : "otherValue",&#010     otherProp : "otherValue"&#010 }&#010 </pre>&#010 .. but is not
     * understood by many server-side JSON parser implementations.
     *
     *
     * @return Boolean
     */
    public Boolean getStrictQuoting()  {
        return getAttributeAsBoolean("strictQuoting");
    }

    // ********************* Methods ***********************
            
    /**
     * Serialize an object as a JSON string.
     * @param object object to serialize
     *
     * @return object encoded as a JSON String
     */
    public native String encode(Object object) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        return self.encode(object);
    }-*/;
            
    /**
     * Encode a JavaScript Date value. <P> By default, follows the {@link com.smartgwt.client.util.JSONEncoder#getDateFormat
     * dateFormat} setting.  Override to do custom encoding.
     * @param theDate JavaScript date object to be serialized
     *
     * @return value to be included in result.  <b>If this value is intended to appear                  as a String it should include
     * quotes (")</b>
     */
    public native String encodeDate(Date theDate) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        return self.encodeDate(@com.smartgwt.client.util.JSOHelper::convertToJavaScriptDate(Ljava/util/Date;)(theDate));
    }-*/;

    // ********************* Static Methods ***********************

}



