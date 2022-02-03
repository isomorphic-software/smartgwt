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
import java.util.Set;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsDate;
import com.google.gwt.dom.client.Element;
import com.smartgwt.client.core.JsObject;
import com.smartgwt.client.core.BaseClass;
import com.smartgwt.client.core.DataClass;
import com.smartgwt.client.core.Function;
import com.smartgwt.client.core.RefDataClass;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.data.RecordList;
import com.smartgwt.client.data.RelativeDate;
import com.smartgwt.client.data.ResultSet;
import com.smartgwt.client.types.ValueEnum;
import com.smartgwt.client.widgets.BaseWidget;

/**
 * Utility class containing many useful static helper methods.
 * <p>
 **/
/*
 * NOTES - low-level detail of how the JS -> Java conversion works:
 * In SmartGwtEntryPoint, set up $wnd.SmartGWT.convertToJavaType():
 * - Converts simple and primitive JS types to Java equivalents:
 *   - string
 *     - the object itself is returned (presumably GWT can automap JS String to Java)
 *   - number
 *     - If the stringified number contains a ".", convert to Double
 *     - Otherwise, convert to Integer if the value is less than Integer.MAX_VALUE, otherwise Long
 *   - boolean -> Boolean
 *   - date -> java.util.Date (via JSOHelper.convertToJavaDate)
 *   - object where _constructor is "DateRange" -> com.smartgwt.client.data.DateRange
 *   - isJSO(object) == true -> return the object itself
 *   - array -> return the result of calling JSOHelper.convertToJavaObjectArray(object)
 *   - If none of the above, gives up and returns the object itself
 *
 * In SmartGwtEntryPoint, set up $wnd.SmartGWT.convertToJavaObject():
 * - Converts complex objects to Java equivalents:
 *   - null -> return null
 *   - isc.isA.Object() == false -> return the result of calling convertToJavaType(object) - see above
 *   - isc.isA.Date() == true -> return a java.util.Date (via JSOHelper.convertToJavaDate)
 *   - isc.isAn.Array:
 *     - Iterate over the array members and convert each by calling convertToJavaObject()
 *     - Add each converted member to a JS array
 *     - After the iteration, convert the JS array to either a Java array (via SOHelper.convertToJavaObjectArray)
 *       or an ArrayList, depending on the setting of the incoming "listAsArray" parameter (second param)
 *     - Return this array or ArrayList
 *   - If the incoming "forceMap" parameter (third param) is not true (using exact !== test)
 *     - isJSO(object) == true -> return the object itself
 *     - Object has a non-null "__ref" property -> return the value of the "__ref" property
 *     - isc.isA.Canvas() -> return the result of calling com.smartgwt.client.widgets.Canvas.getById()
 *       with the object's "ID" property
 *     - object has a "name" property of type String and a "form" property of type "DynamicForm"
 *       - Create a DynamicForm object by calling com.smartgwt.client.widgets.form.DynamicForm.getOrCreateRef()
 *         with the value of the object's "form" property
 *       - Return the result of calling getField() on that form, passing in the object's "name" property
 *     - object has a "_constructor" property of "RelativeDate" => return a new instance of 
 *       com.smartgwt.client.data.RelativeDate, passing the object to the constructor that accepts a JSO
 *     - isc.isAn.Instance() == true and the object has a getClassName() method -> return the result of
 *       calling com.smartgwt.client.util.ObjectFactory.createInstance(), passing the object to the 
 *       constructor that accepts a JSO
 *   - If the incoming "forceMap" param is true
 *     - The object has a "__ref" property, and it is a Java Map (checked with JSOHelper::isJavaMap()),
 *       return the value of the object's __ref property
 *   - If get to this point without having converted the object, we try to render it as a Map
 *     - If the object has a property named the same as isc.Tree.getPrototype().treeProperty, we assume
 *       it is a TreeNode and call isc.Tree.getCleanNodeData() on it
 *     - Create a new empty map to contain the converted properties
 *     - Iterate over the property names in object
 *       - If the property name is not a string, skip
 *       - If the property name is the same as isc.gwtModule, skip
 *       - If the property value is an object with a "__ref" property and that __ref property refers 
 *         to a native Java object (as defined by SmartGWT.isNativeJavaObject(), which ultimately calls
 *         on to isJSO()), add the __ref object to the converted map
 *       - Otherwise, convert the value by passing it to convertToJavaObject(), then add it to the 
 *         converted map
 *       - Return the converted map
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
     * Returns whether the supplied JavaScriptObject is a SmartClient class instance.
     * @param the object to evaluate
     * @return whether object is an instance
     */
    public static native boolean isScClassInstance(JavaScriptObject javaScriptObject)/*-{
        return $wnd.isc.isAn.Instance(javaScriptObject);
    }-*/;                                                                                     

    /**
     * Returns whether the supplied JavaScriptObject is a SmartClient class (a Class object
     * itself, rather than an instance of a class).
     * @param the object to evaluate
     * @return whether object is a Class object
     */
    public static native boolean isScClassObject(JavaScriptObject javaScriptObject)/*-{
        return $wnd.isc.isA.ClassObject(javaScriptObject);
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

    public static double doubleValue(Number num) {
        if (num == null) return Double.NaN;
        if (num instanceof Float) {
            // When a `float' is cast to a `double', the significand is zero-extended. This can
            // lead to the unexpected scenario where Double.toString((double)f) != Float.toString(f).
            // For example, Double.toString(Float.valueOf(0.15f).doubleValue()) is the string
            // "0.15000000596046448". This is because the significand of (double)f is
            // 0b0011001100110011001101000000000000000000000000000000, but the significand of
            // Double.parseDouble("0.15") is:
            // 0b0011001100110011001100110011001100110011001100110011
            return Double.parseDouble(num.toString());
        } else if (num instanceof Long) {
            long l = num.longValue();
            final double d = (double)l;
            if (Math.abs(l) > 9007199254740992L) {
                SC.logWarn("The long value " + Long.toString(l) + " cannot be exactly represented in JavaScript. It will be truncated to: " + Long.toString((long)d));
            }
            return d;
        } else {
            return num.doubleValue();
        }
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

    /**
     * Set the value of attribute "attr" in object "elem" to the Object "value"
     * <P> 
     * This method converts the value passed in to an equivalent 
     * object in JavaScript before storing on the underlying data object - see 
     * {@link com.smartgwt.client.docs.JavaToJavaScriptConversion} for details of the conversions
     * that take place.<br>
     * Developers can use {@link #setObjectAttribute(JavaScriptObject, String, Object)} 
     * to store Java objects without converting to JavaScript.
     *
     * @param elem the JavaScriptObject on which to set the attribute
     * @param attr the attribute name
     * @param value the attribute value.
     */
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
            	// The Object[] passed in may contain unconvertible elements (POJOs)
            	// In this case we'll end up with a JavaScript array which contains some
            	// unconverted sub objects
            	// We used to pass the extra "strict" parameter in to avoid this and
            	// instead throw an exception, but that's more intrusive than silently 
            	// storing some unconverted member.
            	setAttribute(elem, attr, convertToJavaScriptArray((Object[])value));
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

        // As with Object[]s, Java collections may contain unconvertible elements (POJOs)
    	// In this case we'll end up with a JavaScript array which contains some
    	// unconverted sub objects
    	} else if (value instanceof List) {
            setAttribute(elem, attr, convertToJavaScriptArray(((List<?>)value).toArray()));
        } else if (value instanceof Iterator) {
        	List listVal = new ArrayList();
        	while (((Iterator) value).hasNext()) listVal.add(((Iterator) value).next());
            setAttribute(elem, attr, convertToJavaScriptArray(((List<?>)listVal).toArray()));
        } else if (value instanceof Set) {
        	setAttribute(elem, attr, JSOHelper.convertToJavaScriptArray(((Set<?>)value).toArray()));
        } else if (value instanceof Map) {
            setAttribute(elem, attr, convertMapToJavascriptObject((Map<?, ?>) value));
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
            setAttribute(elem, attr, doubleValue(value));
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

    /**
     * Returns attribute value set as a Boolean.  For convenience in checking boolean
     * properties, <code>getAttributeAsBoolean</code> will return Boolean <code>false</code>
     * if the attribute value is <code>null</code> or not a Boolean.  Use the three parameter
     * variant of this API {@link #getAttributeAsBoolean(JavaScriptObject, String, boolean)}
     * if you want <code>null</code> returned for <code>null</code> attribute values.
     * @param elem the JavaScriptObject containing the property
     * @param attr the property name
     * @return the property value
     */
    public static boolean getAttributeAsBoolean(JavaScriptObject elem, String attr) {
        return getAttributeAsBoolean(elem, attr, false);
    }

    /**
     * Returns attribute value set as a Boolean.  If the attribute value is <code>null</code>
     * or not a Boolean, the return value depends upon <code>allowNull</code>.  If 
     * <code>allowNull</code> is true, <code>null</code> will be returned; otherwise Boolean
     * <code>false</code> will be returned.  For a simpler approach that never returns 
     * <codE>null</code>, use the two parameter variant of this API 
     * {@link #getAttributeAsBoolean(JavaScriptObject, String)}.
     * @param elem the JavaScriptObject containing the property
     * @param attr the property name
     * @param allowNull whether to permit a <code>null</code> return value
     * @return the property value
     */
    public static native Boolean getAttributeAsBoolean(JavaScriptObject elem, String attr, boolean allowNull) /*-{
        var ret = elem[attr];
        if ($wnd.isc.isA.Boolean(ret)) ret = ret.valueOf();
        else if (!allowNull)         ret = false;
        else                         return null;
        return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(ret);
    }-*/;

    public static native Object getAttributeAsObject(JavaScriptObject elem, String attr) /*-{
	    var ret = elem[attr];
	    if (ret === undefined) return null;
	    if ($wnd.isc.isA.Number(ret) || $wnd.isc.isA.Boolean(ret)) {
	        ret = $wnd.SmartGWT.convertToJavaType(ret);
	    }
	    return ret;
    }-*/;

    /**
     * Returns attribute "attr" of JavaScriptObject "elem", converted to a Map following the rules described
     * in the {@link com.smartgwt.client.docs.JavaScriptToJavaConversion JS -> Java conversion article}
     *
     * @param elem JavaScriptObject containing the attribute
     * @param attr The attribute name
     * @return The attribute converted to a Java Map
     */
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
     * Convert a JavaScriptObject to the appropriate type of Java Object, following the rules described
     * in the {@link com.smartgwt.client.docs.JavaScriptToJavaConversion JS -> Java conversion article}
     *
     * @param object JavaScriptObject to convert
     * @param listAsArray Should arrays be converted to Object[] or List
     * @return converted Java object. May be a Map, a List, an Object[], a JavaScriptObject, 
     *         a Canvas or a FormItem, depending on the underlying JavaScript type
     */
    public static Object convertToJava(JavaScriptObject object, boolean listAsArray) {
        return convertToJava(object, listAsArray, false);
    }


    /**
     * Convert a JavaScriptObject to the appropriate type of Java Object, following the rules described
     * in the {@link com.smartgwt.client.docs.JavaScriptToJavaConversion JS -> Java conversion article}.
     * Any arrays encountered during conversion will be converted to Java <code>ArrayList</code>s
     *
     * @param object JavaScriptObject to convert
     * @return converted Java object. May be a Map, a List, an Object[], a JavaScriptObject, 
     *         a Canvas or a FormItem, depending on the underlying JavaScript type
     */
    public static Object convertToJava(JavaScriptObject object) {
        return convertToJava(object, false);
    }

    /**
     * Convert a JavaScript object containing key:value pairs to a Java Map, following the rules described
     * in the {@link com.smartgwt.client.docs.JavaScriptToJavaConversion JS -> Java conversion article}
     * @param jsObj the JavaScript object to convert
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
     * Convert a JavaScript object containing key:value pairs to a Java Map, following the rules described
     * in the {@link com.smartgwt.client.docs.JavaScriptToJavaConversion JS -> Java conversion article}.
     * Any arrays encountered during the conversion process will be converted to Java <code>ArrayList</code>s
     * @param jsObj the JavaScript object to convert
     * @return the map
     * @throws IllegalArgumentException if unable to convert the passed JavaScript object to a map
     */
    public static Map convertToMap(JavaScriptObject jsObj)  {
    	return convertToMap(jsObj, false);
    }

    /**
     * Convert a JavaScript object to an Object[], following the rules described
     * in the {@link com.smartgwt.client.docs.JavaScriptToJavaConversion JS -> Java conversion article}. 
     * If the JavaScript object is not an array in Javascript, a new array will be created 
     * containing the converted object as the only entry.
     * @param object the JavaScript object to convert
     * @return the JavaScript object converted to a Java Object array
     */
    public static Object[] convertToArray(JavaScriptObject object) {
    	Object javaObj = convertToJava(object, true);
    	if (!(javaObj instanceof Object[])) {
    		javaObj = new Object[] {javaObj};
    	}
    	return (Object[])javaObj;
    }

    /**
     * Convert a JavaScript object to a List, following the rules described
     * in the {@link com.smartgwt.client.docs.JavaScriptToJavaConversion JS -> Java conversion article}. 
     * If the JavaScript object is not an array in JavaScript, a new List will be created containing 
     * the converted object as the only entry.
     * @param object the JavaScript object to convert
     * @return the JavaScript object converted to a Java List
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
        // Use $wnd.isc.DateUtil.create() instead of JsDate.create() so that instance methods
        // like duplicate() are added to the resulting JavaScript date object.
        var jsD = $wnd.isc.DateUtil.create();
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

    /**
     * @param obj the object
     * @return true if object is a Java Array
     */
    public static boolean isJavaArray(Object obj) {
        return obj == null ? false : obj.getClass().isArray();
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


    /**
     * Converts the parameter Object array to an equivalent Javascript array - see 
     * {@link com.smartgwt.client.docs.JavaToJavaScriptConversion} for details of the conversions
     * that take place.
     *
     * @param array the Java Object array to convert
     */
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
                else setArrayValue(jsArray, i, doubleValue((Number) val));
            } else if (val instanceof Boolean) {
                JSOHelper.setArrayValue(jsArray, i, ((Boolean) val).booleanValue());
            } else if (val instanceof Date) {
                JSOHelper.setArrayValue(jsArray, i, (Date) val);
            } else if (val instanceof ValueEnum) {
                JSOHelper.setArrayValue(jsArray, i, ((ValueEnum) val).getValue());
            } else if (val instanceof JavaScriptObject) {
                JSOHelper.setArrayValue(jsArray, i, (JavaScriptObject) val);
            } else if (val instanceof RecordList) {
            	if (val instanceof ResultSet) {
            		val = ((ResultSet)val).getAllCachedRows();
            	} 
        		val = ((RecordList) val).getRange(0,  ((RecordList) val).getLength());
        		setArrayValue(jsArray, i, convertToJavaScriptArray((Record[])val, strict));
            	
            } /*else if (val instanceof JsObject) {
                JSOHelper.setArrayValue(jsArray, i, ((JsObject) val).getJsObj());
            } */
            else if (val instanceof DataClass) {
                JSOHelper.setArrayValue(jsArray, i, ((DataClass) val).getJsObj());
            } else if (val instanceof BaseClass) {
                JSOHelper.setArrayValue(jsArray, i, ((BaseClass) val).getOrCreateJsObj());
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
            } else if (val instanceof Iterator) {
            	List listVal = new ArrayList();
            	while (((Iterator) val).hasNext()) listVal.add(((Iterator) val).next());
            	
            	setArrayValue(jsArray, i, JSOHelper.convertToJavaScriptArray(((List<?>)listVal).toArray(), strict));
            } else if (val instanceof Set) {
                setArrayValue(jsArray, i, JSOHelper.convertToJavaScriptArray(((Set<?>)val).toArray(), strict));
            } else if (val instanceof Map) {
                setArrayValue(jsArray, i, convertMapToJavascriptObject((Map)val, strict));
            } else {
                assert val != null;
                assert !(val instanceof JavaScriptObject);
                if (strict) {
                	throwUnconvertibleObjectException(val, 
                			"Object is a member of an Array being converted to JavaScript. " + 
                			"Please see the SmartClient documentation of " +
                    		"RPCRequest.data for a table of Java types that can be converted automatically.");
                } else {
                    setArrayValue(jsArray, i, val);
                }
            }
        }
        return jsArray;
    }
    
    // Helper to throw an exception if we want to convert a method to JS but it's not a convertible type
    // This is also called from JSNI when attempting to serialize a Java object as part of an RPC request
    // within the SmartClient JS code. See isc.SmartGWT.throwUnconvertibleObjectException() defined in
    // SmartGwtEntryPoint
    public static void throwUnconvertibleObjectException(Object object, String messageDetail) {
    	
    	String message;
    	if (object == null) message = "Null!!!";
    	else if (object.getClass() == null) message = "NO Class??!!";
    	else message = "Attempt to convert instance of class " + (object.getClass().getName()) + " to a JavaScript object failed.";
    	if (messageDetail != null) message += " " + messageDetail;
    	throw new UnsupportedOperationException(message);
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
        return $wnd.isc.DateUtil.createLogicalDate(year, month, date);
    }-*/;

    public static native JsDate getJSLogicalTime(Date date) /*-{
        var time = @com.smartgwt.client.util.JSOHelper::getTime(Ljava/util/Date;)(date);
        var jsDate = $wnd.isc.DateUtil.create().setTime(time);
        return $wnd.isc.DateUtil.createLogicalTime(jsDate.getHours(), jsDate.getMinutes(), jsDate.getSeconds(), jsDate.getMilliseconds());
    }-*/;
    public static native JsDate getJSLogicalTime(int hour, int minute, int second, int millisecond) /*-{
        return $wnd.isc.DateUtil.createLogicalTime(hour, minute, second, millisecond);
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
        var ret = array[index];
        return ret == null ? null : $wnd.SmartGWT.convertToJavaType(ret);
    }-*/;

    public static native Boolean getBooleanArrayValue(JavaScriptObject array, int index) /*-{
        var ret = array[index];
        return ret == null ? null : @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(ret);
    }-*/;

    public static native int getIntArrayValue(JavaScriptObject array, int index) /*-{
        return array[index];
    }-*/;

    public static native float getfloatArrayValue(JavaScriptObject array, int index) /*-{
       return array[index];
    }-*/;

    public static native double getdoubleArrayValue(JavaScriptObject array, int index) /*-{
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

    public static native Double getDoubleArrayValue(JavaScriptObject array, int index) /*-{
        var ret = array[index];
        return (ret == null ? null : @com.smartgwt.client.util.JSOHelper::toDouble(D)(ret));
    }-*/;

    public static native Date getDateArrayValue(JavaScriptObject array, int i) /*-{
        if (array == null || !$wnd.isc.isAn.Array(array)) return null;
        var val = array[i];
        return @com.smartgwt.client.util.JSOHelper::convertToJavaDate(Lcom/google/gwt/core/client/JavaScriptObject;)(val);
    }-*/;



    public static native int getArrayLength(JavaScriptObject array) /*-{
        return array.length;
    }-*/;

    public static Boolean[] convertToJavaBooleanArray(JavaScriptObject array) {
        int length = getArrayLength(array);
        Boolean[] arr = new Boolean[length];
        for (int i = 0; i < length; i++) {
            arr[i] = getBooleanArrayValue(array, i);
        }
        return arr;
    }

    public static int[] convertToJavaIntArray(JavaScriptObject array) {
        int length = getArrayLength(array);
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = getIntArrayValue(array, i);
        }
        return arr;
    }

    /**
     * @deprecated deprecated in favor of {@link #convertToJavaIntegerArray}
     */
    public static Integer[] convertToJavaInterArray(JavaScriptObject array) {
        return convertToJavaIntegerArray(array);
    }

    public static Integer[] convertToJavaIntegerArray(JavaScriptObject array) {
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

    public static Double[] convertToJavaDoubleArray(JavaScriptObject array) {
        int length = getArrayLength(array);
        Double[] arr = new Double[length];
        for (int i = 0; i < length; i++) {
            arr[i] = getDoubleArrayValue(array, i);
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

    /**
     * Sets attribute "attr" on Javascript object "jsObj" to the JavaScript equivalent of "valueMap".
     * See {@link com.smartgwt.client.docs.JavaToJavaScriptConversion} 
     * for details of the conversions that take place.
     *
     * @param jsObj the JavaScript object on which to set the attribute
     * @param attr the name of the attribute to set
     * @param valueMap the Java Map to convert and apply as the attribute value
     */
    public static void setAttribute(JavaScriptObject jsObj, String attr, Map valueMap) {
        JavaScriptObject valueJS = convertMapToJavascriptObject(valueMap);
        setAttribute(jsObj, attr, valueJS);
    }

    /**
     * Converts the parameter Map to an equivalent Javascript object - see 
     * {@link com.smartgwt.client.docs.JavaToJavaScriptConversion} 
     * for details of the conversions that take place.
     *
     * @param array the Java Map to convert
     */
    public static JavaScriptObject convertMapToJavascriptObject(Map valueMap) {
        return convertMapToJavascriptObject(valueMap, false);
    }

    public static JavaScriptObject convertMapToJavascriptObject(Map valueMap, boolean strict) {
        if(valueMap == null) return null;
        JavaScriptObject valueJS = JSOHelper.createObject();
        for (Iterator iterator = valueMap.keySet().iterator(); iterator.hasNext();) {
            Object objKey = iterator.next();

            // skip specific invalid keys
            if (objKey == null) {
                SC.logWarn("JSO::convertMapToJavascriptObject : Map contains null key - dropping this entry.");
                continue;
            }
            if(objKey.equals("__ref")) {
                SC.logWarn("JSO::convertMapToJavascriptObject : skipping __ref in map");
                continue;
            }
            if (objKey.equals("__module")) {
                SC.logWarn("JSO::convertMapToJavascriptObject : skipping __module in map");
                continue;
            }

            String key;

            // convert to String from integral types; skip other types
            if      (objKey instanceof String)  key =   (String)objKey;
            else if (objKey instanceof Integer) key = ((Integer)objKey).toString();
            else if (objKey instanceof Short)   key =   ((Short)objKey).toString();
            else if (objKey instanceof Byte)    key =    ((Byte)objKey).toString();
            else {
                SC.logWarn("JSO::convertMapToJavascriptObject : Value maps can only " + 
                           "map from integral or String stored key values to String " + 
                           "display values.  Key " + objKey + " is not allowed.");
                continue;
            }

            Object value = valueMap.get(objKey);

            if (value instanceof JavaScriptObject) {
                setAttribute(valueJS, key, (JavaScriptObject) value);
            } else if (value instanceof Date) {
                setAttribute(valueJS, key, ((Date) value));
            } else if (value instanceof Number) {
                setAttribute(valueJS, key, doubleValue((Number) value));
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

            // use the SC JS object as value for SGWT BaseWidget, BaseClass, DataClass/JsObject
            } else if (value instanceof JsObject) {
                setAttribute(valueJS, key, ((JsObject) value).getJsObj());
            } else if (value instanceof BaseClass) {
                setAttribute(valueJS, key, ((BaseClass) value).getOrCreateJsObj());
            } else if (value instanceof BaseWidget) {
                setAttribute(valueJS, key, ((BaseWidget) value).getOrCreateJsObj());

            } else if (value instanceof ValueEnum) {
                setAttribute(valueJS, key, ((ValueEnum) value).getValue());
            } else {
                assert value != null;
                if (strict) {
                	throwUnconvertibleObjectException(value, 
                			"Object is stored as attribute " + key + " of a Map being converted to JavaScript. " +
                			"Please see the SmartClient documentation of " +
                    		"RPCRequest.data for a table of Java types that can be converted automatically.");
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
    public static native void addProperties(JavaScriptObject destination,
                                            JavaScriptObject propertiesObject)
    /*-{
        $wnd.isc.addProperties(destination, propertiesObject);
    }-*/;

    /**
     * Removes non-transferable properties from the supplied object
     * (e.g. widget ID), performing a copy first if requested.
     *
     * @param properties the supplied object to clean
     * @param copyProperties whether to copy the object first
     * @return the cleaned properties object
     */
    public static native JavaScriptObject cleanProperties(JavaScriptObject properties,
                                                          boolean copyProperties)
    /*-{
        if (properties != null) {
            if (copyProperties) properties = $wnd.isc.addProperties({}, properties);
            delete properties.AUTOIDClass;
            delete properties.ID;
            delete properties.__ref;
            delete properties.__module;
            delete properties.__sgwtRelink;
            delete properties._autoAssignedID;
        }
        return properties;
    }-*/;
    
    
    // Invoking functions in JavaScript scope
    // Convert Java Object Array to JavaScript array of appropriate types and use function.apply()
    /**
     * Invoke a method on some JavaScript object, passing in the specified array of parameters.
     * <P> 
     * This method converts the specified parameters to a equivalent 
     * objects in JavaScript before calling the method in JavaScript scope, and will convert any return
     * value to Java before returning it - see 
     * {@link com.smartgwt.client.docs.JavaToJavaScriptConversion} for details of the conversions
     * that take place.<br>
     * If the invoked method has no return value, this method will return null.
     * 
     * @param target
     * @param methodName
     * @param arguments
     * @return
     */
    public static Object callMethod (JavaScriptObject target, String methodName, Object[] arguments) {
    	
    	JavaScriptObject argumentsJS =  convertToJavaScriptArray(arguments);
    	JavaScriptObject result = callMethodJS(target, methodName, argumentsJS);
    	if (result == null) return null;
    	// Use convertToJava to appropriately wrap things in the right object type.
    	return convertToJava(result);
    }
    private static native JavaScriptObject callMethodJS (JavaScriptObject target, String methodName, JavaScriptObject arguments) /*-{
    	var returnVal = null;
    	if (target != null && target[methodName] != null) {
    		returnVal = target[methodName].apply(target, arguments);
    	}
    	return returnVal;
    	
    }-*/;

}
