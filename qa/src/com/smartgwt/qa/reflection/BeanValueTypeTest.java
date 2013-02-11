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
 
package com.smartgwt.qa.reflection;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.core.client.GWT;

import com.smartgwt.qa.TestRunner;
import com.smartgwt.qa.TestCase;

import com.smartgwt.client.bean.BeanFactory;
import com.smartgwt.client.bean.BeanValueType;
import com.smartgwt.client.bean.BeanValueType.Convertability;
import com.smartgwt.client.widgets.Canvas;

import com.smartgwt.qa.reflection.widgets.CustomCanvas;

import java.util.Map;
import java.util.HashMap;
import java.util.Date;

// Tests general capabilities of BeanValueType
public class BeanValueTypeTest extends TestRunner {
    public static interface MyValueTypeFactory extends BeanValueType.MetaFactory {
        BeanValueType<Map> getMapValueType();
    }
    
    public BeanValueTypeTest () {
        super(
            new TestCase("using value type in java. namespace") { 
                public void doTest () {
                    GWT.create(BeanValueTypeTest.MyValueTypeFactory.class);

                    HashMap hash = new HashMap();

                    assertTrue(BeanValueType.isAssignableFrom(Map.class, hash), "a HashMap should be assignable to Map");
                    assertFalse(BeanValueType.isAssignableFrom(Map.class, 7), "an int should not be assignable to Map");
                    setResult();
                }
            },

            new TestCase("isAssignableFrom(Class, Object) with generated subclass") {
                public void doTest () {
                    HashMap map = new HashMap();

                    assertTrue(BeanValueType.isAssignableFrom(Map.class, map), "A HashMap should be assignable to a Map");
                    assertTrue(BeanValueType.isAssignableFrom(Map.class, null), "null is assignable to anything");
                    assertFalse(BeanValueType.isAssignableFrom(Map.class, "bob"), "A String is not assignable to a Map");

                    setResult();
                }
            },

            new TestCase("isAssignableFrom(Class, Object) with no generated subclass") {
                public void doTest () {
                    assertTrue(BeanValueType.isAssignableFrom(Integer.class, 7), "int is assignable to Integer");
                    assertTrue(BeanValueType.isAssignableFrom(Integer.class, null), "null is assignable to anything");
                    assertTrue(BeanValueType.isAssignableFrom(Number.class, Integer.valueOf(7)), "Integer is assignable to Number");
                    assertFalse(BeanValueType.isAssignableFrom(Integer.class, 7.0), "Float is not assignable to Integer");

                    setResult();
                }
            },

            new TestCase("isAssignableFrom(Class, Class) with arrays") {
                public void doTest() {
                    assertTrue(BeanValueType.isAssignableFrom(Integer[].class, Integer[].class), "an array class is assignable to itself");
                    assertFalse(BeanValueType.isAssignableFrom(Integer[].class, Integer.class), "a scalar is not assignable to an array");
                    assertTrue(BeanValueType.isAssignableFrom(Number[].class, Integer[].class), "arrays are covariant");
                    assertFalse(BeanValueType.isAssignableFrom(Integer[].class, Number[].class), "but this one is backwards");

                    setResult();
                }
            },

            new TestCase("isAssignableFrom(Class, Class) with scalars") {
                public void doTest() {
                    assertTrue(BeanValueType.isAssignableFrom(Integer.class, Integer.class), "a scalar class is assignable to itself");
                    assertFalse(BeanValueType.isAssignableFrom(Integer.class, Integer[].class), "an array is not assignable to a scalar");
                    assertTrue(BeanValueType.isAssignableFrom(Number.class, Integer.class), "standard subclass works");
                    assertFalse(BeanValueType.isAssignableFrom(Integer.class, Number.class), "but this one is backwards");

                    setResult();
                }
            },

            new TestCase("isA") {
                public void doTest () {
                    JavaScriptObject canvas = new Canvas().getOrCreateJsObj();
                    
                    assertTrue(BeanValueType.isA(canvas, "Canvas"), "a canvas should be a Canvas");
                    assertFalse(BeanValueType.isA(canvas, "ListGrid"), "a canvas is not a ListGrid");

                    setResult();
                }
            },

            new TestCase("convertToJava(null, undefined)") {
                public native JavaScriptObject jsNull () /*-{ return null; }-*/;
                public native JavaScriptObject jsUndefined () /*-{ return undefined; }-*/;
                
                public void doTest () {
                    assertNull(BeanValueType.convertToJava(jsNull()), "should convert null to null");
                    assertNull(BeanValueType.convertToJava(jsUndefined()), "should convert undefined to null");
                
                    setResult();
                }
            },

            new TestCase("convertToJava(String)") {
                public native JavaScriptObject jsString () /*-{ return "fred"; }-*/;
                public native JavaScriptObject jsStringObject () /*-{ return new String("joe"); }-*/;
                
                public void doTest () {
                    Object result;

                    result = BeanValueType.convertToJava(jsString());
                    assertTrue(result instanceof String, "primitive strings should convert to String");
                    assertEqual(result, "fred", "strings should keep their value");

                    result = BeanValueType.convertToJava(jsStringObject());
                    assertTrue(result instanceof String, "string objects should convert to String");
                    assertEqual(result, "joe", "string objects should keep their value");
                
                    setResult();
                }
            },

            new TestCase("convertToJava(Numbers)") {
                public native JavaScriptObject jsSmallInt () /*-{ return 7; }-*/;
                public native JavaScriptObject jsSmallNegativeInt () /*-{ return -6; }-*/;
                public native JavaScriptObject jsLargeInt () /*-{ return 9007199254740992; }-*/;
                public native JavaScriptObject jsLargeNegativeInt () /*-{ return -9007199254740992; }-*/;
                public native JavaScriptObject jsSmallDecimal () /*-{ return 27.4; }-*/;
                public native JavaScriptObject jsSmallNegativeDecimal () /*-{ return -30.2; }-*/;
                public native JavaScriptObject jsLargeDecimal () /*-{ return 25.3 * @java.lang.Float::MAX_VALUE; }-*/;
                public native JavaScriptObject jsLargeNegativeDecimal () /*-{ return -25.3 * @java.lang.Float::MAX_VALUE; }-*/;
                public native JavaScriptObject jsNumberObject () /*-{ return new Number(5); }-*/;
                
                public void doTest () {
                    Object result;

                    result = BeanValueType.convertToJava(jsSmallInt());
                    assertTrue(result instanceof Integer, "small integers should convert to Integer");
                    assertEqual(result, 7, "small integers should keep their value");
                    
                    result = BeanValueType.convertToJava(jsSmallNegativeInt());
                    assertTrue(result instanceof Integer, "small negative integers should convert to Integer");
                    assertEqual(result, -6, "small negative integers should keep their value");
                    
                    // We use toString for the comparison so we don't have to
                    // worry about what GWT does with large number constants
                    result = BeanValueType.convertToJava(jsLargeInt());
                    assertTrue(result instanceof Long, "large integers should convert to Long");
                    assertEqual(result.toString(), "9007199254740992", "large integers should keep their value");
                    
                    result = BeanValueType.convertToJava(jsLargeNegativeInt());
                    assertTrue(result instanceof Long, "large negative integers should convert to Long");
                    assertEqual(result.toString(), "-9007199254740992", "large negative integers should keep their value");

                    result = BeanValueType.convertToJava(jsSmallDecimal());
                    assertTrue(result instanceof Float, "small decimals should convert to Float");
                    assertWithin((Float) result, 27.4, 0.000001, "small decimals should keep their value");
                    
                    result = BeanValueType.convertToJava(jsSmallNegativeDecimal());
                    assertTrue(result instanceof Float, "small negative decimals should convert to Float");
                    assertWithin((Float) result, -30.2, 0.000001, "small negative decimals should keep their value");
                    
                    result = BeanValueType.convertToJava(jsLargeDecimal());
                    assertTrue(result instanceof Double, "large decimals should convert to Double"); 
                    assertWithin((Double) result, 25.3 * java.lang.Float.MAX_VALUE, 0.000001, "large decimals should keep their value");
                    
                    result = BeanValueType.convertToJava(jsLargeNegativeDecimal());
                    assertTrue(result instanceof Double, "large negative decimals should convert to Double");
                    assertWithin((Double) result, -25.3 * java.lang.Float.MAX_VALUE, 0.000001, "large negative decimals should keep their value");
               
                    result = BeanValueType.convertToJava(jsNumberObject());
                    assertTrue(result instanceof Number, "number objects should convert to Number");
                    assertEqual(result, 5, "number objects should keep their value");

                    setResult();
                }
            },

            new TestCase("convertToJava(Boolean)") {
                public native JavaScriptObject jsTrue () /*-{ return true; }-*/;
                public native JavaScriptObject jsFalse () /*-{ return false; }-*/;
                public native JavaScriptObject jsTrueObject () /*-{ return new Boolean(true); }-*/;
                public native JavaScriptObject jsFalseObject () /*-{ return new Boolean(false); }-*/;

                public void doTest () {
                    Object result = BeanValueType.convertToJava(jsTrue());
                    assertTrue(result instanceof Boolean, "primitive booleans should convert to Boolean");
                    assertEqual(result, true, "primitive true should convert to true");

                    result = BeanValueType.convertToJava(jsFalse());
                    assertTrue(result instanceof Boolean, "primitive booleans should convert to Boolean");
                    assertEqual(result, false, "primitive false should convert to false");
                
                    result = BeanValueType.convertToJava(jsTrueObject());
                    assertTrue(result instanceof Boolean, "object booleans should convert to Boolean");
                    assertEqual(result, true, "object true should convert to true");

                    result = BeanValueType.convertToJava(jsFalseObject());
                    assertTrue(result instanceof Boolean, "object booleans should convert to Boolean");
                    assertEqual(result, false, "object false should convert to false");
                
                    setResult();
                }
            },

            new TestCase("convertToJava(Date)") {
                // Note that createLogicalDate seems to use 0-based months ... that is, January is 0, not 1
                public native JavaScriptObject jsDate () /*-{ return $wnd.isc.Date.createLogicalDate(2012, 10, 29); }-*/;

                public void doTest () {
                    Object result = BeanValueType.convertToJava(jsDate());
                    assertTrue(result instanceof Date, "dates should convert to Date");

                    String formattedDate = DateTimeFormat.getFormat("yyyyMMdd").format((Date) result);
                    assertEqual(formattedDate, "20121129", "date should retain value");

                    setResult();
                }
            },

            new TestCase("convertToJava(array)") {
                public native JavaScriptObject jsArray () /*-{ 
                    var array = $wnd.Array.create();
                    array[0] = 7;
                    array[1] = 8;
                    return array;
                }-*/;

                public void doTest () {
                    Object result = BeanValueType.convertToJava(jsArray());

                    assertTrue(result instanceof Object[], "array should convert to Object[]");
                    assertEqual((Object[]) result, new Object[] {7, 8}, "arrays should convert each value");

                    setResult();
                }
            },

            new TestCase("convertToJava(smartclient instance)") {
                public native JavaScriptObject jsInstance () /*-{ return $wnd.isc.Canvas.create(); }-*/;

                public void doTest () {
                    JavaScriptObject instance = jsInstance();
                    Object result = BeanValueType.convertToJava(instance);
                    assertEqual(result, instance, "a smartclient instance without a __ref should convert to itself");

                    Canvas canvas = new Canvas();
                    instance = canvas.getOrCreateJsObj();
                    result = BeanValueType.convertToJava(instance);
                    assertEqual(result, canvas, "a smartclient instance with a __ref should convert to the __ref");
                    
                    setResult();
                }
            },

            new TestCase("convertToJava(config block)") {
                public native JavaScriptObject jsConfigBlock () /*-{
                    return {
                        _constructor: "Canvas",
                        width: 207
                    };
                }-*/;

                public void doTest () {
                    Object result = BeanValueType.convertToJava(jsConfigBlock());

                    assertTrue(result instanceof JavaScriptObject, "config blocks should convert to JavaScriptObjects");
                    assertTrue(BeanValueType.isA((JavaScriptObject) result, "Canvas"), "config blocks should use _constructor");

                    Canvas canvas = new Canvas((JavaScriptObject) result);
                    assertEqual(canvas.getWidth(), 207, "config block parameters should be used");

                    setResult();
                }
            },

            new TestCase("convertToJava(POJO)") {
                public native JavaScriptObject jsPOJO () /*-{
                    return {
                        property: "fred",
                        anotherProperty: 7
                    };
                }-*/;

                @SuppressWarnings("unchecked")
                public void doTest () {
                    Object result = BeanValueType.convertToJava(jsPOJO());

                    assertTrue(result instanceof Map, "POJO's should convert to Maps");

                    Map<String, Object> map = (Map<String, Object>) result;

                    assertEqual(map.get("property"), "fred", "POJO properties should be preserved");
                    assertEqual(map.get("anotherProperty"), 7, "POJO properties should be preserved");

                    setResult();
                }
            },

            new TestCase("convertabilityFrom") {
                public void doTest () {
                    // We'll just test that it works at all ... we'll do more
                    // detailed testing elsewhere
                    Convertability conversion = BeanValueType.convertabilityFrom(String.class, 7);
                    assertEqual(conversion, Convertability.SUPPORTED, "conversion from int to string should be supported");
                    setResult();
                }
            },

            new TestCase("convertFrom") {
                public void doTest () {
                    // We'll just test that it works at all ... we'll do more
                    // detailed testing elsewhere
                    Object result = BeanValueType.convertFrom(String.class, 7);
                    assertEqual(result, "7", "should convert int to string");
                    
                    result = BeanValueType.convertFrom(Integer.class, null);
                    assertNull(result, "should convert null to null");
                    
                    setResult();
                }
            },
            
            new TestCase("convertabilityToString") {
                public void doTest () {
                    // We'll just test that it works at all ... we'll do more
                    // detailed testing elsewhere
                    Convertability conversion = BeanValueType.convertabilityToString(Integer.class);
                    assertEqual(conversion, Convertability.SUPPORTED, "conversion from Integer to string should be supported");
                    setResult();
                }
            },

            new TestCase("convertToString") {
                public void doTest () {
                    // We'll just test that it works at all ... we'll do more
                    // detailed testing elsewhere
                    Object result = BeanValueType.convertToString(7);
                    assertEqual(result, "7", "should convert int to string");
                    
                    result = BeanValueType.convertToString(null);
                    assertNull(result, "should convert null to null");
                    
                    setResult();
                }
            }
        );
    }
}
