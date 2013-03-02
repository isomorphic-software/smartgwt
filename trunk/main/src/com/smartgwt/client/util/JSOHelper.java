/*
 * SmartGWT (GWT for SmartClient)
 * Copyright 2008 and beyond, Isomorphic Software, Inc.
 *
 * SmartGWT is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License version 3
 * as published by the Free Software Foundation.  SmartGWT is also
 * available under typical commercial license terms - see
 * http://smartclient.com/license
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 */

package com.smartgwt.client.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsDate;
import com.google.gwt.user.client.Element;
import com.smartgwt.client.core.BaseClass;
import com.smartgwt.client.core.DataClass;
import com.smartgwt.client.core.Function;
import com.smartgwt.client.core.RefDataClass;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.data.RelativeDate;
import com.smartgwt.client.types.ValueEnum;
import com.smartgwt.client.widgets.BaseWidget;

/**
 * Internal helper class.
 */
public class JSOHelper {

    private JSOHelper() {
    }

    /**
     * Returns the javascript class name.
     * @return
     */
    public static native String getClassName(JavaScriptObject javaScriptObject)/*-{
        return javaScriptObject.getClassName();
    }-*/;

    /**
     * Evaluate the passed string as Javascript
     *
     * @param jsFrag the string to evaluate
     * @return the JavaScriptObject upon evaluation
     */
    public static native JavaScriptObject eval(String jsFrag) /*-{
		if(!($wnd.isc.startsWith(jsFrag, '(') && $wnd.isc.endsWith(jsFrag, ')'))) {
            jsFrag = '(' + jsFrag + ')';
        }
        return $wnd.isc.Class.evaluate(jsFrag);
	}-*/;

    public static boolean isJSO(Object object) {
        return object instanceof JavaScriptObject;
    }

    public static native String getAttribute(JavaScriptObject elem, String attr) /*-{
        var ret = elem[attr];
        return (ret == null ? null : String(ret));
    }-*/;

    public static native void setAttribute(JavaScriptObject elem, String attr, String value) /*-{
        // When setting a string attribute, make sure to convert the value to a normal, non-wrapped
        // string as opposed to a String object (i.e. typeof is "string", not "object").
        // This is needed because an equality comparison of two String objects can fail even
        // though they represent the same string. For example, `new String("test") == new String("test")'
        // is `false'.
        //
        // Also, both $wnd.String() and String() called as functions on a value return the same thing,
        // a native browser string that is the result of calling the internal ToString() conversion function
        // (Sections 15.5.1.1 and 9.8, ECMA-262). Use String() because it is the fastest:
        // http://jsperf.com/cross-frame-tostring/2
        elem[attr] = (value == null ? null : String(value));
    }-*/;

    public static native JavaScriptObject getAttributeAsJavaScriptObject(JavaScriptObject elem, String attr) /*-{
        var ret = elem[attr];
        return (ret == null ? null : ret);
    }-*/;

    public static native JavaScriptObject[] getAttributeAsJavaScriptObjectArray(JavaScriptObject elem, String attr) /*-{
        var arrayJS = elem[attr];
	    return (arrayJS === undefined) ? null : @com.smartgwt.client.util.JSOHelper::toArray(Lcom/google/gwt/core/client/JavaScriptObject;)(arrayJS);
    }-*/;

    public static JavaScriptObject[] toArray(JavaScriptObject array) {
        //handle case where a ResultSet is passed
    	if (com.smartgwt.client.data.ResultSet.isResultSet(array)) {
    		array = JSOHelper.resultSetToArray(array);
    	}
        final int length = getJavaScriptObjectArraySize(array);
        JavaScriptObject[] recs = new JavaScriptObject[length];
        for (int i = 0; i < length; i++) {
            recs[i] = getValueFromJavaScriptObjectArray(array, i);
        }
        return recs;
    }
    private static native JavaScriptObject resultSetToArray(JavaScriptObject rs) /*-{
    	if (!rs.lengthIsKnown() || !rs.allMatchingRowsCached()) return $wnd.Array.create();
    	return rs.getRange(0, rs.getLength());

    }-*/;

    public static native boolean isArray(JavaScriptObject jsObj)/*-{
        return $wnd.isc.isA.Array(jsObj);
    }-*/;

    public static Element[] toElementArray(JavaScriptObject array) {
        int length = getJavaScriptObjectArraySize(array);
        Element[] recs = new Element[length];
        for (int i = 0; i < length; i++) {
            recs[i] = getElementValueFromJavaScriptObjectArray(array, i);
        }
        return recs;
    }

    public static native void setAttribute(JavaScriptObject elem, String attr, JavaScriptObject[] value) /*-{
	    elem[attr] = value;
    }-*/;

    public static void setAttribute(JavaScriptObject elem, String attr, int[] values) {
        setAttribute(elem, attr, JSOHelper.convertToJavaScriptArray(values));
    }

    public static void setAttribute(JavaScriptObject elem, String attr, float[] values) {
        setAttribute(elem, attr, JSOHelper.convertToJavaScriptArray(values));
    }

    public static void setAttribute(JavaScriptObject elem, String attr, double[] values) {
        setAttribute(elem, attr, JSOHelper.convertToJavaScriptArray(values));
    }

    public static void setAttribute(JavaScriptObject elem, String attr, String[] values) {
        setAttribute(elem, attr, JSOHelper.convertToJavaScriptArray(values));
    }

    public static void setAttribute(JavaScriptObject elem, String attr, Integer[] values) {
        setAttribute(elem, attr, JSOHelper.convertToJavaScriptArray(values));
    }

    public static void setAttribute(JavaScriptObject elem, String attr, Float[] values) {
        setAttribute(elem, attr, JSOHelper.convertToJavaScriptArray(values));
    }

    public static void setAttribute(JavaScriptObject elem, String attr, Boolean[] values) {
        setAttribute(elem, attr, JSOHelper.convertToJavaScriptArray(values));
    }

    public static void setAttribute(JavaScriptObject elem, String attr, Double[] values) {
        setAttribute(elem, attr, JSOHelper.convertToJavaScriptArray(values));
    }
    public static void setAttribute(JavaScriptObject elem, String attr, Long[] values) {
        setAttribute(elem, attr, JSOHelper.convertToJavaScriptArray(values));
    }

    public static void setAttribute(JavaScriptObject elem, String attr, Date[] values) {
        setAttribute(elem, attr, JSOHelper.convertToJavaScriptArray(values));
    }

    public static void setAttribute(JavaScriptObject elem, String attr, ValueEnum[] values) {
        setAttribute(elem, attr, JSOHelper.convertToJavaScriptArray(values));
    }

    public static void setAttribute(JavaScriptObject elem, String attr, Object value) {
        if (value == null) {
            setNullAttribute(elem, attr);
        } else if (value instanceof String || value instanceof Character) {
            setAttribute(elem, attr, value.toString());
        } else if (value instanceof Number) {
            setAttribute(elem, attr, (Number)value);
        } else if (value instanceof Boolean) {
            setAttribute(elem, attr, ((Boolean)value).booleanValue());
        } else if (value instanceof Date) {
            setAttribute(elem, attr, (Date)value);
        } else if (value instanceof RelativeDate) {
            setAttribute(elem, attr, ((RelativeDate)value).getValue());
        } else if (value instanceof ValueEnum) {
            setAttribute(elem, attr, ((ValueEnum)value).getValue());
        } else if (value.getClass().isArray()) {
            if (value instanceof Object[]) {
                setAttribute(elem, attr, convertToJavaScriptArray((Object[])value, true));
            } else if (value instanceof int[]) {
                setAttribute(elem, attr, convertToJavaScriptArray((int[])value));
            } else if (value instanceof double[]) {
                setAttribute(elem, attr, convertToJavaScriptArray((double[])value));
            } else if (value instanceof float[]) {
                setAttribute(elem, attr, convertToJavaScriptArray((float[])value));
            } else if (value instanceof boolean[]) {
                setAttribute(elem, attr, convertToJavaScriptArray((boolean[])value));
            } else if (value instanceof char[]) {
                setAttribute(elem, attr, convertToJavaScriptArray((char[])value));
            } else if (value instanceof byte[]) {
                setAttribute(elem, attr, convertToJavaScriptArray((byte[])value));
            } else if (value instanceof short[]) {
                setAttribute(elem, attr, convertToJavaScriptArray((short[])value));
            } else if (value instanceof long[]) {
                setAttribute(elem, attr, convertToJavaScriptArray((long[])value));
            } else {
                assert false : value.getClass() + " should not be an array class.";
                setObjectAttribute(elem, attr, value);
            }
        } else if (value instanceof List) {
            setAttribute(elem, attr, convertToJavaScriptArray(((List<?>)value).toArray(), true));
        } else if (value instanceof Map) {
            setAttribute(elem, attr, convertMapToJavascriptObject((Map<?, ?>) value, true));
        } else {
            setObjectAttribute(elem, attr, value);
        }
    }

    public static native void setAttribute(JavaScriptObject elem, String attr, JavaScriptObject value) /*-{
	    elem[attr] = value;
    }-*/;

    public static native void setAttribute(JavaScriptObject elem, String attr, int value) /*-{
	    elem[attr] = value;
    }-*/;

    public static void setAttribute(JavaScriptObject elem, String attr, Number value) {
        if (value == null) {
            setNullAttribute(elem, attr);
        } else {
            if (value instanceof Long) setAttribute(elem, attr, (Long)value);
            else setAttribute(elem, attr, value.doubleValue());
        }
    }

    public static void setAttribute(JavaScriptObject elem, String attr, Long value) {
        if (value == null) {
            setNullAttribute(elem, attr);
        } else {
            final long l = value.longValue();
            final double d = (double)l;
            if (Math.abs(l) > 9007199254740992L) {
                SC.logWarn("The long value " + Long.toString(l) + " cannot be exactly represented in JavaScript. It will be truncated to: " + Long.toString((long)d));
            }
            setAttribute(elem, attr, d);
        }
    }

    public static void setAttribute(JavaScriptObject elem, String attr, Boolean value) {
        if (value == null) {
            setNullAttribute(elem, attr);
        } else {
            setAttribute(elem, attr, value.booleanValue());
        }
    }

    public static native void setNullAttribute(JavaScriptObject elem, String attr) /*-{
	    elem[attr] = null;
    }-*/;

    public static native void deleteAttribute(JavaScriptObject elem, String attr) /*-{
	      delete elem[attr];
    }-*/;

    public static native void deleteAttributeIfExists(JavaScriptObject elem, String attr) /*-{
          var undef;
	      if (elem[attr] !== undef) delete elem[attr];
    }-*/;

    public static native void setAttribute(JavaScriptObject elem, String attr, boolean value) /*-{
	    elem[attr] = value;
    }-*/;

    public static native void setAttribute(JavaScriptObject elem, String attr, double value) /*-{
        elem[attr] = value;
    }-*/;

    public static native void setAttribute(JavaScriptObject elem, String attr, Function handler) /*-{
	    elem[attr] = $entry(function() {
            handler.@com.smartgwt.client.core.Function::execute()();
        });
    }-*/;

    public static void setAttribute(JavaScriptObject elem, String attr, Date value) {
        setAttribute(elem, attr, convertToJavaScriptDate(value));
    }

    public static native void setObjectAttribute(JavaScriptObject elem, String attr, Object object) /*-{
        elem[attr] = object;
    }-*/;


    public static native Element getAttributeAsElement(JavaScriptObject elem, String attr) /*-{
	    var ret = elem[attr];
	    return (ret === undefined) ? null : ret;
    }-*/;

    public static native Integer getAttributeAsInt(JavaScriptObject elem, String attr) /*-{
        var ret = elem[attr];
        return (ret == null ? null : @com.smartgwt.client.util.JSOHelper::toInteger(I)(ret));
    }-*/;

    public static native Double getAttributeAsDouble(JavaScriptObject elem, String attr) /*-{
	    var ret = elem[attr];
	    if (ret === undefined || ret == null) {
	        return null;
        } else {
            if(typeof ret == "object") {
                return ret;
            } else {
	            return  @com.smartgwt.client.util.JSOHelper::toDouble(D)(ret);
            }
        }
    }-*/;

    public static native Date getAttributeAsDate(JavaScriptObject elem, String attr) /*-{
        var val = elem[attr];
        return @com.smartgwt.client.util.JSOHelper::convertToJavaDate(Lcom/google/gwt/core/client/JavaScriptObject;)(val);
    }-*/;

    public static native Float getAttributeAsFloat(JavaScriptObject elem, String attr) /*-{
        var ret = elem[attr];
        return (ret == null ? null : @com.smartgwt.client.util.JSOHelper::toFloat(F)(ret));
    }-*/;

    public static int[] getAttributeAsIntArray(JavaScriptObject elem, String attr) {
        int[] rtn = null;
        JavaScriptObject hold = getAttributeAsJavaScriptObject(elem, attr);

        if (hold != null) {
            rtn = new int[getJavaScriptObjectArraySize(hold)];

            for (int i = 0; i < rtn.length; i++) {
                rtn[i] = getIntValueFromJavaScriptObjectArray(hold, i);
            }
        }
        return rtn;
    }

    public static double[] getAttributeAsDoubleArray(JavaScriptObject elem, String attr) {
        double[] rtn = null;
        JavaScriptObject hold = getAttributeAsJavaScriptObject(elem, attr);

        if (hold != null) {
            rtn = new double[getJavaScriptObjectArraySize(hold)];

            for (int i = 0; i < rtn.length; i++) {
                rtn[i] = getDoubleValueFromJavaScriptObjectArray(hold, i);
            }
        }
        return rtn;
    }

    public static String[] getAttributeAsStringArray(JavaScriptObject elem, String attr) {
        final JavaScriptObject hold = getAttributeAsJavaScriptObject(elem, attr);

        final String[] rtn;
        if (hold == null) rtn = null;
        else {
            rtn = new String[getJavaScriptObjectArraySize(hold)];

            for (int i = 0; i < rtn.length; i++) {
                rtn[i] = getStringValueFromJavaScriptObjectArray(hold, i);
            }
        }
        return rtn;
    }

    public static native int getJavaScriptObjectArraySize(JavaScriptObject elem) /*-{
        var length;
	    if (elem) length = elem.length;
	    if (length == null) length = 0;
	    return length;
    }-*/;

    public static native int getIntValueFromJavaScriptObjectArray(JavaScriptObject elem, int i) /*-{
	    return elem[i];
    }-*/;

    public static native double getDoubleValueFromJavaScriptObjectArray(JavaScriptObject elem, int i) /*-{
	    return elem[i];
    }-*/;

    public static native String getStringValueFromJavaScriptObjectArray(JavaScriptObject elem, int i) /*-{
	    return elem[i];
    }-*/;

    public static native JavaScriptObject getValueFromJavaScriptObjectArray(JavaScriptObject elem, int i) /*-{
	    return elem[i];
    }-*/;

    // Lists of cells are stored as arrays of 2 element arrays in JS.
    // Helpers to convert between this and the equivalent format in Java (int[][])
    public static int[][] getCellArray(JavaScriptObject jsCells) {
        if (jsCells == null) return null;

        int length = JSOHelper.getArrayLength(jsCells);
        int[][] cells = new int[length][];

        for (int i = 0; i < length; i++) {
            JavaScriptObject jsCell = JSOHelper.getValueFromJavaScriptObjectArray(jsCells, i);
            cells[i] = new int[2];
            cells[i][0] = JSOHelper.getIntArrayValue(jsCell, 0);
            cells[i][1] = JSOHelper.getIntArrayValue(jsCell, 1);
        }
        return cells;
    }

    public static JavaScriptObject convertToCellArray(int[][] cells) {
        if (cells == null) return null;
        JavaScriptObject jsCells = JSOHelper.createJavaScriptArray();
        for (int i = 0; i < cells.length; i++) {
            int[] cell = cells[i];
            JavaScriptObject jsCell = JSOHelper.convertToJavaScriptArray(cell);
            JSOHelper.setArrayValue(jsCells, i, jsCell);
        }
        return jsCells;
    }


    public static native boolean getAttributeAsBoolean(JavaScriptObject elem, String attr) /*-{
	    var ret = elem[attr];
	    return (ret == null || ret === undefined) ? false : ret;
    }-*/;

    public static native Object getAttributeAsObject(JavaScriptObject elem, String attr) /*-{
	    var ret = elem[attr];
	    if (ret === undefined) return null;
	    if ($wnd.isc.isA.Number(ret) || $wnd.isc.isA.Boolean(ret)) {
	        ret = $wnd.SmartGWT.convertToJavaType(ret);
	    }
	    return ret;
    }-*/;

    public static Map getAttributeAsMap(JavaScriptObject elem, String attr) {
	    JavaScriptObject value = getAttributeAsJavaScriptObject(elem, attr);
	    if (value == null) return null;
	    return convertToMap(value);
    }

    public static JavaScriptObject[] listToArray(List list) {
        JavaScriptObject[] array = new JavaScriptObject[list.size()];

        for (int i = 0; i < array.length; i++) {
            array[i] = (JavaScriptObject) list.get(i);
        }
        return array;
    }

    public static JavaScriptObject arrayConvert(Object[] array) {
        if(array == null) return null;
        JavaScriptObject result = newJSArray(array.length);

        for (int i = 0; i < array.length; i++) {
            arraySet(result, i, array[i]);
        }
        return result;
    }

    public static JavaScriptObject arrayConvert(JavaScriptObject[] array) {
        if(array == null) return null;
        JavaScriptObject result = newJSArray(array.length);

        for (int i = 0; i < array.length; i++) {
            arraySet(result, i, array[i]);
        }
        return result;
    }

    private static native JavaScriptObject newJSArray(int length) /*-{
	    if (length < 0) {
	        return $wnd.Array.create();
	    } else {
	        var arr = $wnd.Array.create();
            arr.setLength(length);
            return arr;
	    }
    }-*/;

    public static native int arrayLength(JavaScriptObject array) /*-{
	    return array.length;
    }-*/;

    public static native Object arrayGetObject(JavaScriptObject array, int index) /*-{
	    return array[index];
    }-*/;

    public static native void arraySet(JavaScriptObject array, int index, Object value) /*-{
	    array[index] = value;
    }-*/;

    public static native void arraySet(JavaScriptObject array, int index, JavaScriptObject value) /*-{
	    array[index] = value;
    }-*/;

    /**
     * This is used to access Element array as JavaScriptObject
     */
    public static native Element getElementValueFromJavaScriptObjectArray(JavaScriptObject elem, int i) /*-{
    	return elem[i];
	}-*/;

    public static native JavaScriptObject createObject() /*-{
        return new Object;
    }-*/;

    public static JavaScriptObject convertToJavaScriptArray(boolean[] array) {
        if (array == null) return null;
        final JavaScriptObject jsArray = createJavaScriptArray();
        for (int i = 0; i < array.length; ++i) {
            JSOHelper.setArrayValue(jsArray, i, array[i]);
        }
        return jsArray;
    }

    public static JavaScriptObject convertToJavaScriptArray(char[] array) {
        if (array == null) return null;
        final JavaScriptObject jsArray = createJavaScriptArray();
        for (int i = 0; i < array.length; ++i) {
            JSOHelper.setArrayValue(jsArray, i, Character.toString(array[i]));
        }
        return jsArray;
    }

    public static JavaScriptObject convertToJavaScriptArray(byte[] array) {
        if (array == null) return null;
        final JavaScriptObject jsArray = createJavaScriptArray();
        for (int i = 0; i < array.length; ++i) {
            JSOHelper.setArrayValue(jsArray, i, array[i]);
        }
        return jsArray;
    }

    public static JavaScriptObject convertToJavaScriptArray(short[] array) {
        if (array == null) return null;
        final JavaScriptObject jsArray = createJavaScriptArray();
        for (int i = 0; i < array.length; ++i) {
            JSOHelper.setArrayValue(jsArray, i, array[i]);
        }
        return jsArray;
    }

    public static JavaScriptObject convertToJavaScriptArray(int[] array) {
        if(array == null) return null;
        JavaScriptObject jsArray = createJavaScriptArray();
        for (int i = 0; i < array.length; i++) {
            JSOHelper.setArrayValue(jsArray, i, array[i]);
        }
        return jsArray;
    }

    public static JavaScriptObject convertToJavaScriptArray(float[] array) {
        if(array == null) return null;
        JavaScriptObject jsArray = createJavaScriptArray();
        for (int i = 0; i < array.length; i++) {
            JSOHelper.setArrayValue(jsArray, i, array[i]);
        }
        return jsArray;
    }

    public static JavaScriptObject convertToJavaScriptArray(double[] array) {
        if(array == null) return null;
        JavaScriptObject jsArray = createJavaScriptArray();
        for (int i = 0; i < array.length; i++) {
            JSOHelper.setArrayValue(jsArray, i, array[i]);
        }
        return jsArray;
    }

    public static JavaScriptObject convertToJavaScriptArray(long[] array) {
        if(array == null) return null;
        JavaScriptObject jsArray = createJavaScriptArray();
        for (int i = 0; i < array.length; i++) {
            JSOHelper.setArrayValue(jsArray, i, array[i]);
        }
        return jsArray;
    }

    private static void doAddToMap(Map map, String key, Object value) {
    	 map.put(key, value);
    }

    private native static Object convertToJava(JavaScriptObject object, boolean listAsArray, boolean forceMap) /*-{
        return $wnd.SmartGWT.convertToJavaObject(object, listAsArray, forceMap);
    }-*/;

    /**
     * Convert a JavaScriptObject to the appropriate type of JavaObject.
     * Simple JavaScript objects (key:value pairs) will be converted to Map instances.
     * JavaScript Arrays will be returned as a List or an Object Array depending on the listAsArray
     * parameter
     * Conversion is recursive, nested JavaScript objects and arrays will have their members converted
     * as well
     * JavaScript dates will be returned as Java Dates
     * Simple Javascript types such as integers, floats and strings will be returned as the equivalent
     * java object class (String, Integer, etc)
     *
     * @param object JavaScriptObject to convert
     * @param listAsArray Should arrays be converted to Object[] or List
     * @return converted Java object. May be a Map, a List or an Object[] depending on the underlying JS
     *   type.
     */
    public static Object convertToJava(JavaScriptObject object, boolean listAsArray) {
        return convertToJava(object, listAsArray, false);
    }

    public static Object convertToJava(JavaScriptObject object) {
        return convertToJava(object, false);
    }

    /**
     * Convert a Javascript object containing key:value pairs to a Map.
     * @param jsObj the javascript object
     * @param listAsArray Should arrays be converted to Object[] or List
     * @return the map
     * @throws IllegalArgumentException if unable to convert the passed JavaScript object to a map
     */
    public static Map convertToMap(JavaScriptObject jsObj, boolean listAsArray) {
    	Object javaObj = convertToJava(jsObj, listAsArray, true);
        if (javaObj == null) {
            return (Map) null;
        } else if (javaObj instanceof Map) {
    		return (Map) javaObj;
    	} else {
    		throw new IllegalArgumentException("convertToMap - unable to convert the passed "
                + "JavaScript object to a Map.  JavaScript is: " + SC.echo(jsObj));
    	}
    }

    /**
     * Convert a Javascript object containing key:value pairs to a Map.
     * @param jsObj the javascript object
     * @return the map
     * @throws IllegalArgumentException if unable to convert pass JavaScript object to a map
     */
    public static Map convertToMap(JavaScriptObject jsObj)  {
    	return convertToMap(jsObj, false);
    }

    /**
     * Convert a Javascript object to an Object[]. If the Javascript object is not an array
     * in Javascript, a new array will be created containing the converted object as the only entry.
     * @param object
     * @return
     */
    public static Object[] convertToArray(JavaScriptObject object) {
    	Object javaObj = convertToJava(object, true);
    	if (!(javaObj instanceof Object[])) {
    		javaObj = new Object[] {javaObj};
    	}
    	return (Object[])javaObj;
    }

    /**
     * Convert a Javascript object to a List. If the Javascript object is not an array
     * in Javascript, a new List will be created containing the converted object as the only entry.
     * @param object
     * @return
     */
    public static List convertToList(JavaScriptObject object) {
    	Object javaObj = convertToJava(object, false);
    	if (!(javaObj instanceof List)) {
    		List list = new ArrayList();
    		list.add(javaObj);
    		javaObj = list;
    	}
    	return (List)javaObj;
    }

    private static native JsDate createJavaScriptDate(double time) /*-{
        // Use $wnd.Date.create() instead of JsDate.create() so that instance methods like
        // duplicate() are added to the resulting JavaScript date object.
        var jsD = $wnd.Date.create();
        jsD.setTime(time);
        return jsD;
    }-*/;

    public static JsDate convertToJavaScriptDate(Date date) {
        if (date == null) return null;
        if (date instanceof LogicalDate) {
            return ((LogicalDate)date).toJavaScriptDate();
        } else if (date instanceof LogicalTime) {
            return ((LogicalTime)date).toJavaScriptDate();
        } else {
            return createJavaScriptDate(date.getTime());
        }
    }

    public static native Date convertToJavaDate(JavaScriptObject val) /*-{
        if (!$wnd.isc.isA.Date(val)) return null;
        if (val.logicalDate) {
            return @com.smartgwt.client.util.LogicalDate::new(D)(val.getTime());
        } else if (val.logicalTime) {
            return @com.smartgwt.client.util.LogicalTime::new(D)(val.getTime());
        } else {
            return @com.smartgwt.client.util.JSOHelper::toDate(D)(val.getTime());
        }
    }-*/;

    //explicitly cast Object to String to workaround GWT hosted mode but in certain browsers when originating string is obtained
    //by calling object.toString(). http://code.google.com/p/google-web-toolkit/issues/detail?id=4301
    public static String convertToString(Object obj) {
        if(obj instanceof String) {
            return (String) obj;
        } else {
            throw new IllegalArgumentException("Object " + obj + " is not of type String");
        }
    }

    /**
     * @param obj the object
     * @return true if object is a Java Date
     */
    public static boolean isJavaDate(Object obj) {
        return obj instanceof Date;
    }

    /**
     * @param obj the object
     * @return true if object is a Java Number
     */
    public static boolean isJavaNumber(Object obj) {
        return obj instanceof Number;
    }

    /**
     * @param obj the object
     * @return true if object is a Java Integer
     */
    public static boolean isJavaInteger(Object obj) {
        return obj instanceof Integer;
    }

    /**
     * @param obj the object
     * @return true if object is a Java Float
     */
    public static boolean isJavaFloat(Object obj) {
        return obj instanceof Float;
    }

    /**
     * @param obj the object
     * @return true if object is a Java Double
     */
    public static boolean isJavaDouble(Object obj) {
        return obj instanceof Double;
    }

    /**
     * @param obj the object
     * @return true if object is a Java String
     */
    public static boolean isJavaString(Object obj) {
        return obj instanceof String;
    }

    /**
     * @param obj the object
     * @return true if object is a Java Integer
     */
    public static boolean isJavaBoolean(Object obj) {
        return obj instanceof Boolean;
    }

    public static boolean isJavaList(Object obj) {
        return obj instanceof List;
    }

    public static boolean isJavaMap(Object obj) {
        return obj instanceof Map;
    }

    public static <O extends JavaScriptObject> JsArray<O> convertToJsArray(O[] array) {
        if (array == null) return null;
        else {
            final JsArray<O> ret = (JsArray<O>)JavaScriptObject.createArray();
            ret.setLength(array.length);
            for (int i = 0; i < array.length; ++i) {
                ret.set(i, array[i]);
            }
            return ret;
        }
    }

    public static JavaScriptObject convertToJavaScriptArray(Object[] array) {
        return convertToJavaScriptArray(array, false);
    }

    public static JavaScriptObject convertToJavaScriptArray(Object[] array, boolean strict) {
        if(array == null) return null;
        JavaScriptObject jsArray = createJavaScriptArray();
        for (int i = 0; i < array.length; i++) {
            Object val = array[i];

            if (val == null) {
                setArrayValue(jsArray, i, (JavaScriptObject) val);
            } else if (val instanceof String || val instanceof Character) {
                setArrayValue(jsArray, i, val.toString());
            } else if (val instanceof Number) {
                if (val instanceof Long) setArrayValue(jsArray, i, ((Long) val).longValue());
                else setArrayValue(jsArray, i, ((Number) val).doubleValue());
            } else if (val instanceof Boolean) {
                JSOHelper.setArrayValue(jsArray, i, ((Boolean) val).booleanValue());
            } else if (val instanceof Date) {
                JSOHelper.setArrayValue(jsArray, i, (Date) val);
            } else if (val instanceof ValueEnum) {
                JSOHelper.setArrayValue(jsArray, i, ((ValueEnum) val).getValue());
            } else if (val instanceof JavaScriptObject) {
                JSOHelper.setArrayValue(jsArray, i, (JavaScriptObject) val);
            } /*else if (val instanceof JsObject) {
                JSOHelper.setArrayValue(jsArray, i, ((JsObject) val).getJsObj());
            } */
            else if (val instanceof DataClass) {
                JSOHelper.setArrayValue(jsArray, i, ((DataClass) val).getJsObj());
            } else if (val instanceof BaseClass) {
                JSOHelper.setArrayValue(jsArray, i, ((BaseClass) val).getJsObj());
            } else if (val instanceof BaseWidget) {
                JSOHelper.setArrayValue(jsArray, i, ((BaseWidget) val).getOrCreateJsObj());
            } else if (val instanceof Record) {
                JSOHelper.setArrayValue(jsArray, i, ((Record) val).getJsObj());
            } else if (val.getClass().isArray()) {
                if (val instanceof Object[]) {
                    setArrayValue(jsArray, i, convertToJavaScriptArray((Object[])val, strict));
                } else if (val instanceof int[]) {
                    setArrayValue(jsArray, i, convertToJavaScriptArray((int[])val));
                } else if (val instanceof double[]) {
                    setArrayValue(jsArray, i, convertToJavaScriptArray((double[])val));
                } else if (val instanceof float[]) {
                    setArrayValue(jsArray, i, convertToJavaScriptArray((float[])val));
                } else if (val instanceof boolean[]) {
                    setArrayValue(jsArray, i, convertToJavaScriptArray((boolean[])val));
                } else if (val instanceof char[]) {
                    setArrayValue(jsArray, i, convertToJavaScriptArray((char[])val));
                } else if (val instanceof byte[]) {
                    setArrayValue(jsArray, i, convertToJavaScriptArray((byte[])val));
                } else if (val instanceof short[]) {
                    setArrayValue(jsArray, i, convertToJavaScriptArray((short[])val));
                } else if (val instanceof long[]) {
                    setArrayValue(jsArray, i, convertToJavaScriptArray((long[])val));
                } else {
                    assert false : val.getClass() + " should not be an array class.";
                    setArrayValue(jsArray, i, (JavaScriptObject) null);
                }
            } else if (val instanceof List) {
                setArrayValue(jsArray, i, JSOHelper.convertToJavaScriptArray(((List<?>)val).toArray(), strict));
            } else if (val instanceof Map) {
                setArrayValue(jsArray, i, convertMapToJavascriptObject((Map)val, strict));
            } else {
                assert val != null;
                assert !(val instanceof JavaScriptObject);
                if (strict) {
                    throw new UnsupportedOperationException("Can not convert element " + i + " of the array to a JavaScriptObject.  Instances of class `" + (val.getClass().getName()) + "' can not automatically be converted.  Please see the SmartClient documentation of RPCRequest.data for a table of Java types that can be converted automatically.");
                } else {
                    setArrayValue(jsArray, i, val);
                }
            }
        }
        return jsArray;
    }


    public static Integer toInteger(int value) {
        return value;
    }

    public static Long toLong(double value) {
        return (long) value;
    }

    public static Float toFloat(float value) {
        return value;
    }

    public static Double toDouble(double value) {
        return value;
    }

    private static double getTime(Date date) {
        return date.getTime();
    }

    /**
     * Converts a time to a Java {@link java.util.Date} object.
     * 
     * <p>Note: If needing to convert a JavaScript object, it is preferable to use
     * {@link #convertToJavaDate(JavaScriptObject)} instead because that function is able to
     * convert to {@link com.smartgwt.client.util.LogicalDate} and {@link com.smartgwt.client.util.LogicalTime}
     * instances as needed.
     * 
     * @param millis number of milliseconds since January 1, 1970, 00:00:00 GMT.
     * @return a new {@link java.util.Date} representing the given time.
     */
    public static Date toDate(double millis) {
        return new Date((long) millis);
    }

    public static JavaScriptObject toDateJS(Date date) {
        return convertToJavaScriptDate(date);
    }


    // Helper to get logical JS date / time objects. These objects will be recognized
    // as logical date / times for formatting / serialization purposes by the SmartClient system.
    public static JsDate getJSLogicalDate(Date date) {
        return getJSLogicalDate(date.getYear(), date.getMonth(), date.getDate());
    }
    public static native JsDate getJSLogicalDate(int year, int month, int date) /*-{
        return $wnd.Date.createLogicalDate(year, month, date);
    }-*/;

    public static native JsDate getJSLogicalTime(Date date) /*-{
        var time = @com.smartgwt.client.util.JSOHelper::getTime(Ljava/util/Date;)(date);
        var jsDate = $wnd.Date.create().setTime(time);
        return $wnd.Date.createLogicalTime(jsDate.getHours(), jsDate.getMinutes(), jsDate.getSeconds(), jsDate.getMilliseconds());
    }-*/;
    public static native JsDate getJSLogicalTime(int hour, int minute, int second, int millisecond) /*-{
        return $wnd.Date.createLogicalTime(hour, minute, second, millisecond);
    }-*/;

    public static Boolean toBoolean(boolean value) {
        return value;
    }

    public static native JavaScriptObject createJavaScriptArray() /*-{
        //Important : constructing an array from JSNI using [] or new Array() results in a
        //corrupted array object in the final javascript. The array ends up having the correct elements
        //but the test (myarr instanceof Array) fails because the JSNI-created array constructor is different.
        //Need to construct array within the scope of the application's IFRAME by using `new $wnd.Array'.
        return $wnd.Array.create();
    }-*/;

    public static void setArrayValue(JavaScriptObject array, int index, Date value) {
        setArrayValue(array, index, convertToJavaScriptDate(value));
    }

    public static native void setArrayValue(JavaScriptObject array, int index, String value) /*-{
        // See the comments in setAttribute(JavaScriptObject, String, String).
        array[index] = (value == null ? null : String(value));
    }-*/;

    public static native void setArrayValue(JavaScriptObject array, int index, double value) /*-{
        array[index] = value;
    }-*/;

    public static void setArrayValue(JavaScriptObject array, int index, long value) {
        final double d = (double)value;
        if (Math.abs(value) > 9007199254740992L) {
            SC.logWarn("The long value " + Long.toString(value) + " cannot be exactly represented in JavaScript. It will be truncated to: " + Long.toString((long)d));
        }
        setArrayValue(array, index, d);
    }

    public static native void setArrayValue(JavaScriptObject array, int index, boolean value) /*-{
        array[index] = value;
    }-*/;

    public static void setArrayValue(JavaScriptObject array, int index, char value) {
        setArrayValue(array, index, Character.toString(value));
    }

    public static native void setArrayValue(JavaScriptObject array, int index, JavaScriptObject value) /*-{
        array[index] = value;
    }-*/;

    public static native void setArrayValue(JavaScriptObject array, int index, Object value) /*-{
        array[index] = value;
    }-*/;

    public static native String getArrayValue(JavaScriptObject array, int index) /*-{
        var result = array[index];
        return (result == null ? null : String(result));
    }-*/;

    public static native JavaScriptObject getJSOArrayValue(JavaScriptObject array, int index) /*-{
        var result = array[index];
        return (result == null ? null : result);
    }-*/;

    public static native Object getObjectArrayValue(JavaScriptObject array, int index) /*-{
        var result = array[index];
        return (result == null ? null : result);
    }-*/;

    public static native int getIntArrayValue(JavaScriptObject array, int index) /*-{
        return array[index];
    }-*/;

    public static native float getfloatArrayValue(JavaScriptObject array, int index) /*-{
       return array[index];
    }-*/;

    public static native Integer getIntegerArrayValue(JavaScriptObject array, int index) /*-{
        var ret = array[index];
        return (ret == null ? null : @com.smartgwt.client.util.JSOHelper::toInteger(I)(ret));
    }-*/;

    public static native Float getFloatArrayValue(JavaScriptObject array, int index) /*-{
        var ret = array[index];
        return (ret == null ? null : @com.smartgwt.client.util.JSOHelper::toFloat(F)(ret));
    }-*/;

    public static native Date getDateArrayValue(JavaScriptObject array, int i) /*-{
        if (array == null || !$wnd.isc.isAn.Array(array)) return null;
        var val = array[i];
        return @com.smartgwt.client.util.JSOHelper::convertToJavaDate(Lcom/google/gwt/core/client/JavaScriptObject;)(val);
    }-*/;



    public static native int getArrayLength(JavaScriptObject array) /*-{
        return array.length;
    }-*/;

    public static int[] convertToJavaIntArray(JavaScriptObject array) {
        int length = getArrayLength(array);
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = getIntArrayValue(array, i);
        }
        return arr;
    }

    public static Integer[] convertToJavaInterArray(JavaScriptObject array) {
        int length = getArrayLength(array);
        Integer[] arr = new Integer[length];
        for (int i = 0; i < length; i++) {
            arr[i] = getIntegerArrayValue(array, i);
        }
        return arr;
    }

    public static String[] convertToJavaStringArray(JavaScriptObject array) {
        if (array == null) return new String[]{};
        int length = getArrayLength(array);
        String[] arr = new String[length];
        for (int i = 0; i < length; i++) {
            arr[i] = getArrayValue(array, i);
        }
        return arr;
    }

    public static Float[] convertToJavaFloatArray(JavaScriptObject array) {
        int length = getArrayLength(array);
        Float[] arr = new Float[length];
        for (int i = 0; i < length; i++) {
            arr[i] = getFloatArrayValue(array, i);
        }
        return arr;
    }

    public static Date[] convertToJavaDateArray(JavaScriptObject array) {
        int length = getArrayLength(array);
        Date[] arr = new Date[length];
        for (int i =0; i < length; i++) {
            arr[i] = getDateArrayValue(array, i);
        }
        return arr;
    }


    public static Object[] convertToJavaObjectArray(JavaScriptObject array) {
        if (array == null) return new Object[]{};
        int length = getArrayLength(array);
        Object[] arr = new Object[length];
        for (int i = 0; i < length; i++) {
            arr[i] = getObjectArrayValue(array, i);
        }
        return arr;
    }

    public static RefDataClass[] convertToJavaRefDataClassArray(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new RefDataClass[]{};
        }
        JavaScriptObject[] componentsj = JSOHelper.toArray(nativeArray);
        RefDataClass[] objects = new RefDataClass[componentsj.length];
        for (int i = 0; i < componentsj.length; i++) {
            JavaScriptObject componentJS = componentsj[i];
            RefDataClass obj = RefDataClass.getRef(componentJS);
            objects[i] = obj;
        }
        return objects;
    }

    public static native void apply(JavaScriptObject config, JavaScriptObject jsObj) /*-{
        for(var k in config) {
            jsObj[k] = config[k];
        }
    }-*/;

    public static void setAttribute(JavaScriptObject jsObj, String attr, Map valueMap) {
        JavaScriptObject valueJS = convertMapToJavascriptObject(valueMap);
        setAttribute(jsObj, attr, valueJS);
    }

    public static JavaScriptObject convertMapToJavascriptObject(Map valueMap) {
        return convertMapToJavascriptObject(valueMap, false);
    }

    public static JavaScriptObject convertMapToJavascriptObject(Map valueMap, boolean strict) {
        if(valueMap == null) return null;
        JavaScriptObject valueJS = JSOHelper.createObject();
        for (Iterator iterator = valueMap.keySet().iterator(); iterator.hasNext();) {
            String key = (String) iterator.next();
            if (key == null) {
                SC.logWarn("JSO::convertMapToJavascriptObject : Map contains null key - dropping this entry.");
                continue;
            }
            if(key.equals("__ref")) {
                SC.logWarn("JSO::convertMapToJavascriptObject : skipping __ref in map");
                continue;
            }
            Object value = valueMap.get(key);

            if (value instanceof JavaScriptObject) {
                setAttribute(valueJS, key, (JavaScriptObject) value);
            } else if (value instanceof Date) {
                setAttribute(valueJS, key, ((Date) value));
            } else if (value instanceof Number) {
                setAttribute(valueJS, key, ((Number) value).doubleValue());
            } else if (value instanceof String) {
                setAttribute(valueJS, key, ((String) value));
            } else if (value instanceof Boolean) {
                setAttribute(valueJS, key, ((Boolean) value).booleanValue());
            } else if (value == null) {
                setNullAttribute(valueJS, key);
            } else if(value instanceof String[]) {
                setAttribute(valueJS, key, convertToJavaScriptArray((String[]) value));
            } else if (value instanceof Object[]) {
                setAttribute(valueJS, key, convertToJavaScriptArray((Object[]) value, strict));
            } else if (value instanceof int[]) {
                setAttribute(valueJS, key, convertToJavaScriptArray((int[]) value));
            } else if (value instanceof float[]) {
                setAttribute(valueJS, key, convertToJavaScriptArray((float[]) value));
            } else if (value instanceof double[]) {
                setAttribute(valueJS, key, convertToJavaScriptArray((double[]) value));
            } else if (value instanceof long[]) {
                setAttribute(valueJS, key, convertToJavaScriptArray((long[]) value));
            } else if (value instanceof Map) {
            	JavaScriptObject innerMapJS = convertMapToJavascriptObject((Map) value, strict);
            	setAttribute(valueJS, key, innerMapJS);
            } else if (value instanceof List){
                setAttribute(valueJS, key, JSOHelper.convertToJavaScriptArray(((List)value).toArray(), strict));
            } else {
                assert value != null;
                if (strict) {
                    throw new UnsupportedOperationException("Unsupported type for attribute " + key + " : " + value + ".  Instances of class `" + (value.getClass().getName()) + "' can not automatically be converted.  Please see the SmartClient documentation of RPCRequest.data for a table of Java types that can be converted automatically.");
                } else {
                    setObjectAttribute(valueJS, key, value);
                }
            }
        }
        return valueJS;
    }

    public static native String[] getProperties(JavaScriptObject jsObj) /*-{
        var props = @com.smartgwt.client.util.JSOHelper::createJavaScriptArray()();
        for(var k in jsObj) {
            props.push(k);
        }
        return @com.smartgwt.client.util.JSOHelper::convertToJavaStringArray(Lcom/google/gwt/core/client/JavaScriptObject;)(props);
    }-*/;

    public static native String getPropertiesAsString(JavaScriptObject jsObj) /*-{
        var props = '{';
        for(var k in jsObj) {
            props += '\n' + k;
        }
        return props + '}';
    }-*/;

    /**
     * Adds all properties and methods from the propertiesObject to the destination object.
     *
     * @param destination the destination object
     * @param propertiesObject the propertiesObject
     */
    public static native void addProperties(JavaScriptObject destination, JavaScriptObject propertiesObject) /*-{
        $wnd.isc.addProperties(destination, propertiesObject);
    }-*/;
}
