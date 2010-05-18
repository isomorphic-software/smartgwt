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

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;
import com.smartgwt.client.core.BaseClass;
import com.smartgwt.client.core.DataClass;
import com.smartgwt.client.core.Function;
import com.smartgwt.client.core.RefDataClass;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.data.ResultSet;
import com.smartgwt.client.types.ValueEnum;
import com.smartgwt.client.widgets.BaseWidget;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Internal helper class.
 */
public class JSOHelper {

    private JSOHelper() {
    }

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
        return eval(jsFrag);
	}-*/;

    public static boolean isJSO(Object object) {
        return object instanceof JavaScriptObject;
    }
    
    public static native String getAttribute(JavaScriptObject elem, String attr) /*-{
	    var ret = elem[attr];
	    return (ret === undefined || ret == null) ? null : String(ret);
    }-*/;

    public static native void setAttribute(JavaScriptObject elem, String attr, String value) /*-{
	    elem[attr] = value;
    }-*/;

    public static native JavaScriptObject getAttributeAsJavaScriptObject(JavaScriptObject elem, String attr) /*-{
	    var ret = elem[attr];
	    return (ret === undefined) ? null : ret;
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
        int length = getJavaScriptObjectArraySize(array);
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
        return $wnd.isA.Array(jsObj);
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

    public static void setAttribute(JavaScriptObject elem, String attr, Date[] values) {
        setAttribute(elem, attr, JSOHelper.convertToJavaScriptArray(values));
    }

    public static void setAttribute(JavaScriptObject elem, String attr, ValueEnum[] values) {
        setAttribute(elem, attr, JSOHelper.convertToJavaScriptArray(values));
    }

    public static native void setAttribute(JavaScriptObject elem, String attr, Object value) /*-{
        elem[attr] = value;
    }-*/;

    public static native void setAttribute(JavaScriptObject elem, String attr, JavaScriptObject value) /*-{
	    elem[attr] = value;
    }-*/;

    public static native void setAttribute(JavaScriptObject elem, String attr, int value) /*-{
	    elem[attr] = value;
    }-*/;

    public static void setAttribute(JavaScriptObject elem, String attr, Integer value) {
        if (value == null) {
            setNullAttribute(elem, attr);
        } else {
            setAttribute(elem, attr, value.intValue());
        }
    }


    public static void setAttribute(JavaScriptObject elem, String attr, Double value) {
        if (value == null) {
            setNullAttribute(elem, attr);
        } else {
            setAttribute(elem, attr, value.doubleValue());
        }
    }

    public static void setAttribute(JavaScriptObject elem, String attr, Float value) {
        if (value == null) {
            setNullAttribute(elem, attr);
        } else {
            setAttribute(elem, attr, value.floatValue());
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

    public static native void setAttribute(JavaScriptObject elem, String attr, float value) /*-{
	    elem[attr] = value;
    }-*/;


    public static native void setAttribute(JavaScriptObject elem, String attr, double value) /*-{
	    elem[attr] = value;
    }-*/;

    public static native void setAttribute(JavaScriptObject elem, String attr, Function handler) /*-{
	    elem[attr] = function() {
            handler.@com.smartgwt.client.core.Function::execute()();
        };
    }-*/;

    public static void setAttribute(JavaScriptObject elem, String attr, Date value) {
        if (value == null) {
            setAttribute(elem, attr, (String) null);
        } else {
            setDateAttribute(elem, attr, value.getTime());
        }
    }

    private static native void setDateAttribute(JavaScriptObject elem, String attr, double time) /*-{
        var dateJS = $wnd.Date.create();
        dateJS.setTime(time);
        elem[attr] = dateJS;
    }-*/;

    public static native void setObjectAttribute(JavaScriptObject elem, String attr, Object object) /*-{
            elem[attr] = object;
    }-*/;


    public static native Element getAttributeAsElement(JavaScriptObject elem, String attr) /*-{
	    var ret = elem[attr];
	    return (ret === undefined) ? null : ret;
    }-*/;

    public static native Integer getAttributeAsInt(JavaScriptObject elem, String attr) /*-{
	    var ret = elem[attr];
	    return (ret === undefined || ret == null) ? null : @com.smartgwt.client.util.JSOHelper::toInteger(I)(ret);
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
	    var ret = elem[attr];
	    return (ret === undefined || ret == null) ? null: @com.smartgwt.client.util.JSOHelper::toDate(D)(ret.getTime());
    }-*/;

    public static native Float getAttributeAsFloat(JavaScriptObject elem, String attr) /*-{
	    var ret = elem[attr];
	    return (ret === undefined || ret == null) ? null : @com.smartgwt.client.util.JSOHelper::toFloat(F)(ret);
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
        String[] rtn = null;
        JavaScriptObject hold = getAttributeAsJavaScriptObject(elem, attr);

        if (hold != null) {
            rtn = new String[getJavaScriptObjectArraySize(hold)];

            for (int i = 0; i < rtn.length; i++) {
                rtn[i] = getStringValueFromJavaScriptObjectArray(hold, i);
            }
        }
        return rtn;
    }

    public static native int getJavaScriptObjectArraySize(JavaScriptObject elem) /*-{
	    if (elem) return elem.length;
	    return 0;
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

    public static native boolean getAttributeAsBoolean(JavaScriptObject elem, String attr) /*-{
	    var ret = elem[attr];
	    return (ret == null || ret === undefined) ? false : ret;
    }-*/;

    public static native Object getAttributeAsObject(JavaScriptObject elem, String attr) /*-{
	    var ret = elem[attr];
	    return (ret === undefined) ? null : ret;
    }-*/;

    public static Map getAttributeAsMap(JavaScriptObject elem, String attr) {
	    JavaScriptObject value = getAttributeAsJavaScriptObject(elem, attr);
        return value == null ? null : convertToMap(value);
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

    public static JavaScriptObject convertToJavaScriptArray(int[] array) {
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

    public static native Map convertToMap(JavaScriptObject jsObj) /*-{
        var mapJ = @java.util.LinkedHashMap::new()();
        for(var k in jsObj) {
            if($wnd.isA.String(k)){
                var value = jsObj[k];               
                var valueJ = $wnd.SmartGWT.convertToJavaType(value);
                @com.smartgwt.client.util.JSOHelper::doAddToMap(Ljava/util/Map;Ljava/lang/String;Ljava/lang/Object;)(mapJ, k, valueJ);
            }
        }
        return mapJ;
    }-*/;
 
    public static JavaScriptObject convertToJavaScriptDate(Date date) {
        if(date == null) return null;
        JavaScriptObject dateJS = doConvertToJavaScriptDate(date.getTime());
        return dateJS;
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

    private static native JavaScriptObject doConvertToJavaScriptDate(double time) /*-{
        var dateJS = $wnd.Date.create();
        dateJS.setTime(time);
        return dateJS;
    }-*/;

    public static JavaScriptObject convertToJavaScriptArray(Object[] array) {
        if(array == null) return null;
        JavaScriptObject jsArray = createJavaScriptArray();
        for (int i = 0; i < array.length; i++) {
            Object val = array[i];
            if (val instanceof String) {
                JSOHelper.setArrayValue(jsArray, i, (String) val);
            } else if (val instanceof Integer) {
                JSOHelper.setArrayValue(jsArray, i, ((Integer) val).intValue());
            } else if (val instanceof Float) {
                JSOHelper.setArrayValue(jsArray, i, ((Float) val).floatValue());
            } else if (val instanceof Double) {
                JSOHelper.setArrayValue(jsArray, i, ((Double) val).doubleValue());
            } else if (val instanceof Boolean) {
                JSOHelper.setArrayValue(jsArray, i, ((Boolean) val).booleanValue());
            } else if (val instanceof Date) {
                JSOHelper.setArrayValue(jsArray, i, (Date) val);
            } else if (val instanceof ValueEnum) {
                JSOHelper.setArrayValue(jsArray, i, ((ValueEnum) val).getValue());
            } else if (val instanceof JavaScriptObject) {
                JSOHelper.setArrayValue(jsArray, i, ((JavaScriptObject) val));
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
            } else if (val instanceof Object[]) {
                JSOHelper.setArrayValue(jsArray, i, convertToJavaScriptArray((Object[]) val));
            } else if (val instanceof Object) {
                JSOHelper.setArrayValue(jsArray, i, ((Object) val));
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

    public static Date toDate(double millis) {
        return new Date((long) millis);
    }

    public static native JavaScriptObject toDateJS(Date date) /*-{
        var dateJS = $wnd.Date.create();
        dateJS.setTime(@com.smartgwt.client.util.JSOHelper::getTime(Ljava/util/Date;)(date));
        return dateJS;
    }-*/;

    public static Boolean toBoolean(boolean value) {
        return value;
    }

    public static native JavaScriptObject createJavaScriptArray() /*-{
        //Important : constructing an from JSNI array using [] or new Array() results in a
        //corrupted array object in the final javascript. The array ends up having the correct elements
        //but the test (myarr instaneof Array) fails because the jsni created array constructor is different.
        //Need to construct array within the scope of the applications iframe by using new $wnd.Array
        return $wnd.Array.create();
    }-*/;

    public static void setArrayValue(JavaScriptObject array, int index, Date value) {
        if(value == null) {
            setArrayValue(array, index, (String)null);
        } else {
            setArrayDateValue(array, index, value.getTime());
        }
    }

    private static native void setArrayDateValue(JavaScriptObject array, int index, double time) /*-{
        var dateJS = $wnd.Date.create();
        dateJS.setTime(time);
        array[index] = dateJS;
    }-*/;

    public static native void setArrayValue(JavaScriptObject array, int index, String value) /*-{
        array[index] = value;
    }-*/;

    public static native void setArrayValue(JavaScriptObject array, int index, double value) /*-{
        array[index] = value;
    }-*/;

    public static native void setArrayValue(JavaScriptObject array, int index, int value) /*-{
        array[index] = value;
    }-*/;

    public static native void setArrayValue(JavaScriptObject array, int index, float value) /*-{
        array[index] = value;
    }-*/;

    public static native void setArrayValue(JavaScriptObject array, int index, boolean value) /*-{
        array[index] = value;
    }-*/;

    public static native void setArrayValue(JavaScriptObject array, int index, JavaScriptObject value) /*-{
        array[index] = value;
    }-*/;

    public static native void setArrayValue(JavaScriptObject array, int index, Object value) /*-{
        array[index] = value;
    }-*/;

    public static native String getArrayValue(JavaScriptObject array, int index) /*-{
        var result = array[index];
        return (result == null || result === undefined) ? null : result;
    }-*/;

    public static native JavaScriptObject getJSOArrayValue(JavaScriptObject array, int index) /*-{
        var result = array[index];
        return (result == null || result === undefined) ? null : result;
    }-*/;

    public static native Object getObjectArrayValue(JavaScriptObject array, int index) /*-{
        var result = array[index];
        return (result == null || result === undefined) ? null : result;
    }-*/;

    public static native int getIntArrayValue(JavaScriptObject array, int index) /*-{
        return array[index];
    }-*/;

    public static native Integer getIntegerArrayValue(JavaScriptObject array, int index) /*-{
        var ret = array[index];
        return (ret === undefined || ret == null) ? null : @com.smartgwt.client.util.JSOHelper::toInteger(I)(ret);
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
    	
        if(valueMap == null) return null;
        JavaScriptObject valueJS = JSOHelper.createObject();
        for (Iterator iterator = valueMap.keySet().iterator(); iterator.hasNext();) {
            String key = (String) iterator.next();
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
            } else if (value instanceof Map) {
            	JavaScriptObject innerMapJS = convertMapToJavascriptObject((Map) value); 
            	setAttribute(valueJS, key, innerMapJS);
            } else {
                throw new IllegalArgumentException("Unsupported type for attribute " + key + " : " + value);
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
