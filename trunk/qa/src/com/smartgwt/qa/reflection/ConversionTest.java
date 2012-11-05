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
import com.google.gwt.core.client.GWT;
import com.google.gwt.i18n.client.DateTimeFormat;

import com.smartgwt.qa.TestRunner;
import com.smartgwt.qa.TestCase;

import com.smartgwt.client.bean.BeanFactory;
import com.smartgwt.client.bean.BeanValueType;
import com.smartgwt.client.util.DateUtil;
import com.smartgwt.client.util.JSOHelper;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.widgets.Canvas;

import com.smartgwt.qa.reflection.widgets.CustomCanvas;
import com.smartgwt.qa.reflection.widgets.TypesCanvas;

import java.util.Date;
import java.util.Map;
import java.util.HashMap;

// Tests various conversions that BeanFactory can perform, by
// calling on BeanValueType.
public class ConversionTest extends TestRunner {
    static interface MyBeanFactories extends BeanFactory.MetaFactory {
        BeanFactory<TypesCanvas> getTypesCanvasFactory();
    }

    static interface SubclassInterface extends TypesCanvas.TestInterface {

    }

    static {
        // Actually generates the factories. We do it here as an example ...
        // you could create all of them in code that initializes the
        // application, rather than near the point of use like this. It
        // would be slightly more efficient to create them all at once.
        GWT.create(MyBeanFactories.class);
    }

    public ConversionTest () {
        super(
            new TestCase("Boolean") {
                public void doTest () {
                    TypesCanvas canvas = new TypesCanvas();

                    canvas.setBoolean(null);
                    BeanFactory.setProperty(canvas, "boolean", true);
                    assertTrue(canvas.getBoolean(), "set Boolean with boolean");

                    canvas.setBoolean(null);
                    BeanFactory.setProperty(canvas, "boolean", 2);
                    assertTrue(canvas.getBoolean(), "set Boolean with number");

                    canvas.setBoolean(null);
                    BeanFactory.setProperty(canvas, "boolean", "true");
                    assertTrue(canvas.getBoolean(), "set Boolean with string true");
                    
                    canvas.setBoolean(true);
                    BeanFactory.setProperty(canvas, "boolean", "false");
                    assertFalse(canvas.getBoolean(), "set Boolean with string false");

                    canvas.setBoolean(true);
                    BeanFactory.setProperty(canvas, "boolean", null);
                    assertNull(canvas.getBoolean(), "set Boolean with null");

                    setResult();
                }
            },
                
            new TestCase("boolean") {
                public void doTest () {
                    TypesCanvas canvas = new TypesCanvas();

                    canvas.setPrBoolean(false);
                    BeanFactory.setProperty(canvas, "prBoolean", true);
                    assertTrue(canvas.getPrBoolean(), "set boolean with boolean");

                    canvas.setPrBoolean(false);
                    BeanFactory.setProperty(canvas, "prBoolean", 2);
                    assertTrue(canvas.getPrBoolean(), "set boolean with number");

                    canvas.setPrBoolean(false);
                    BeanFactory.setProperty(canvas, "prBoolean", "true");
                    assertTrue(canvas.getPrBoolean(), "set boolean with string true");

                    canvas.setPrBoolean(true);
                    BeanFactory.setProperty(canvas, "prBoolean", "false");
                    assertFalse(canvas.getPrBoolean(), "set boolean with string false");

                    canvas.setPrBoolean(true);
                    BeanFactory.setProperty(canvas, "prBoolean", null);
                    assertFalse(canvas.getPrBoolean(), "set boolean with null");

                    setResult();
                }
            },

            new TestCase("Number") {
                public void doTest () {
                    TypesCanvas canvas = new TypesCanvas();

                    canvas.setNumber(7);
                    BeanFactory.setProperty(canvas, "number", null);
                    assertNull(canvas.getNumber(), "set Number with null");

                    canvas.setNumber(null);
                    BeanFactory.setProperty(canvas, "number", true);
                    assertEqual(canvas.getNumber(), 1, "set Number with boolean true");

                    canvas.setNumber(null);
                    BeanFactory.setProperty(canvas, "number", false);
                    assertEqual(canvas.getNumber(), 0, "set Number with boolean false");

                    canvas.setNumber(null);
                    BeanFactory.setProperty(canvas, "number", 27.4F);
                    Number result = canvas.getNumber();
                    assertTrue(result instanceof Float, "27.4 should convert to Float");
                    assertWithin(result.floatValue(), 27.4, 0.000001, "set Number with float");
                    
                    canvas.setNumber(null);
                    BeanFactory.setProperty(canvas, "number", 26);
                    result = canvas.getNumber();
                    assertTrue(result instanceof Integer, "26 should convert to Integer");
                    assertEqual(result, 26, "set Number with int");
                    
                    canvas.setNumber(null);
                    BeanFactory.setProperty(canvas, "number", "28");
                    result = canvas.getNumber();
                    assertTrue(result instanceof Integer, "28 should convert to Integer");
                    assertEqual(result, 28, "set Number with String int");

                    canvas.setNumber(null);
                    BeanFactory.setProperty(canvas, "number", "28.4");
                    result = canvas.getNumber();
                    assertTrue(result instanceof Float, "28.4 should convert to Float");
                    assertWithin(result.floatValue(), 28.4, 0.000001, "set Number with String float");

                    canvas.setNumber(null);
                    BeanFactory.setProperty(canvas, "number", "-28.4");
                    result = canvas.getNumber();
                    assertTrue(result instanceof Float, "-28.4 should convert to Float");
                    assertWithin(result.floatValue(), -28.4, 0.000001, "set Number with String negative float");

                    Long positiveLong = (long) Integer.MAX_VALUE * 2L;
                    canvas.setNumber(null);
                    BeanFactory.setProperty(canvas, "number", positiveLong.toString());
                    result = canvas.getNumber();
                    assertTrue(result instanceof Long, "> max integer should convert to Long");
                    assertEqual(result, positiveLong, "set Number with String positive long");

                    Long negativeLong = (long) Integer.MIN_VALUE * 2L;
                    canvas.setNumber(null);
                    BeanFactory.setProperty(canvas, "number", negativeLong.toString());
                    result = canvas.getNumber();
                    assertTrue(result instanceof Long, "< min integer should convert to Long");
                    assertEqual(result, negativeLong, "set Number with String negative long");

                    Double positiveLargeDouble = (double) Float.MAX_VALUE * 3.54D;
                    canvas.setNumber(null);
                    BeanFactory.setProperty(canvas, "number", positiveLargeDouble.toString());
                    result = canvas.getNumber();
                    assertTrue(result instanceof Double, "> max positive float should convert to Double");
                    assertEqual(result, positiveLargeDouble, "set Number with String positive large double");
                    
                    Double positiveSmallDouble = (double) Float.MIN_VALUE / 3.54D;
                    canvas.setNumber(null);
                    BeanFactory.setProperty(canvas, "number", positiveSmallDouble.toString());
                    result = canvas.getNumber();
                    assertTrue(result instanceof Double, "< min positive float should convert to Double");
                    assertEqual(result, positiveSmallDouble, "set Number with String positive small double");
                    
                    Double negativeLargeDouble = (double) Float.MAX_VALUE * -3.54D;
                    canvas.setNumber(null);
                    BeanFactory.setProperty(canvas, "number", negativeLargeDouble.toString());
                    result = canvas.getNumber();
                    assertTrue(result instanceof Double, "< max negative float should convert to Double");
                    assertEqual(result, negativeLargeDouble, "set Number with String negative large double");
                    
                    Double negativeSmallDouble = (double) Float.MIN_VALUE / -3.54D;
                    canvas.setNumber(null);
                    BeanFactory.setProperty(canvas, "number", negativeSmallDouble.toString());
                    result = canvas.getNumber();
                    assertTrue(result instanceof Double, "> min negative float should convert to Double");
                    assertEqual(result, negativeSmallDouble, "set Number with String negative small double");
                    
                    setResult();
                }
            },

            new TestCase("Integer") {
                public void doTest () {
                    TypesCanvas canvas = new TypesCanvas();

                    canvas.setInteger(7);
                    BeanFactory.setProperty(canvas, "integer", null);
                    assertNull(canvas.getInteger(), "set Integer with null");

                    canvas.setInteger(null);
                    BeanFactory.setProperty(canvas, "integer", true);
                    assertEqual(canvas.getInteger(), 1, "set Integer with boolean true");

                    canvas.setInteger(null);
                    BeanFactory.setProperty(canvas, "integer", false);
                    assertEqual(canvas.getInteger(), 0, "set Integer with boolean false");

                    canvas.setInteger(null);
                    BeanFactory.setProperty(canvas, "integer", 27.4);
                    assertEqual(canvas.getInteger(), 27, "set Integer with float");
                    
                    canvas.setInteger(null);
                    BeanFactory.setProperty(canvas, "integer", 26);
                    assertEqual(canvas.getInteger(), 26, "set Integer with int");
                    
                    canvas.setInteger(null);
                    BeanFactory.setProperty(canvas, "integer", "28");
                    assertEqual(canvas.getInteger(), 28, "set Integer with String");

                    setResult();
                }
            },
            
            new TestCase("int") {
                public void doTest () {
                    TypesCanvas canvas = new TypesCanvas();

                    canvas.setPrInt(7);
                    BeanFactory.setProperty(canvas, "prInt", null);
                    assertEqual(canvas.getPrInt(), 0, "set int with null");

                    canvas.setPrInt(0);
                    BeanFactory.setProperty(canvas, "prInt", true);
                    assertEqual(canvas.getPrInt(), 1, "set int with boolean true");

                    canvas.setPrInt(1);
                    BeanFactory.setProperty(canvas, "prInt", false);
                    assertEqual(canvas.getPrInt(), 0, "set int with boolean false");

                    canvas.setPrInt(0);
                    BeanFactory.setProperty(canvas, "prInt", 27.4);
                    assertEqual(canvas.getPrInt(), 27, "set int with float");
                    
                    canvas.setPrInt(0);
                    BeanFactory.setProperty(canvas, "prInt", 26);
                    assertEqual(canvas.getPrInt(), 26, "set int with int");
                    
                    canvas.setPrInt(0);
                    BeanFactory.setProperty(canvas, "prInt", "28");
                    assertEqual(canvas.getPrInt(), 28, "set int with String");

                    setResult();
                }
            },

            new TestCase("Long") {
                public void doTest () {
                    TypesCanvas canvas = new TypesCanvas();

                    canvas.setLong((long) 7);
                    BeanFactory.setProperty(canvas, "long", null);
                    assertNull(canvas.getLong(), "set Long with null");

                    canvas.setLong(null);
                    BeanFactory.setProperty(canvas, "long", true);
                    assertEqual(canvas.getLong(), (long) 1, "set Long with boolean true");

                    canvas.setLong(null);
                    BeanFactory.setProperty(canvas, "long", false);
                    assertEqual(canvas.getLong(), (long) 0, "set Long with boolean false");

                    canvas.setLong(null);
                    BeanFactory.setProperty(canvas, "long", 27.4);
                    assertEqual(canvas.getLong(), (long) 27, "set Long with float");
                    
                    canvas.setLong(null);
                    BeanFactory.setProperty(canvas, "long", 26);
                    assertEqual(canvas.getLong(), (long) 26, "set Long with int");
                    
                    canvas.setLong(null);
                    BeanFactory.setProperty(canvas, "long", "28");
                    assertEqual(canvas.getLong(), (long) 28, "set Long with String");

                    setResult();
                }
            },
            
            new TestCase("long") {
                public void doTest () {
                    TypesCanvas canvas = new TypesCanvas();

                    canvas.setPrLong(7);
                    BeanFactory.setProperty(canvas, "prLong", null);
                    assertEqual(canvas.getPrLong(), (long) 0, "set long with null");

                    canvas.setPrLong(0);
                    BeanFactory.setProperty(canvas, "prLong", true);
                    assertEqual(canvas.getPrLong(), (long) 1, "set long with boolean true");

                    canvas.setPrLong(1);
                    BeanFactory.setProperty(canvas, "prLong", false);
                    assertEqual(canvas.getPrLong(), (long) 0, "set long with boolean false");

                    canvas.setPrLong(0);
                    BeanFactory.setProperty(canvas, "prLong", 27.4);
                    assertEqual(canvas.getPrLong(), (long) 27, "set long with float");
                    
                    canvas.setPrLong(0);
                    BeanFactory.setProperty(canvas, "prLong", 26);
                    assertEqual(canvas.getPrLong(), (long) 26, "set long with int");
                    
                    canvas.setPrLong(0);
                    BeanFactory.setProperty(canvas, "prLong", "28");
                    assertEqual(canvas.getPrLong(), (long) 28, "set long with String");

                    setResult();
                }
            },

            new TestCase("Float") {
                public void doTest () {
                    TypesCanvas canvas = new TypesCanvas();

                    canvas.setFloat((float) 7);
                    BeanFactory.setProperty(canvas, "float", null);
                    assertNull(canvas.getFloat(), "set Float with null");

                    canvas.setFloat(null);
                    BeanFactory.setProperty(canvas, "float", true);
                    assertEqual(canvas.getFloat(), (float) 1, "set Float with boolean true");

                    canvas.setFloat(null);
                    BeanFactory.setProperty(canvas, "float", false);
                    assertEqual(canvas.getFloat(), (float) 0, "set Float with boolean false");

                    canvas.setFloat(null);
                    BeanFactory.setProperty(canvas, "float", 27.4);
                    assertWithin(canvas.getFloat(), (float) 27.4, 0.000001, "set Float with float");
                    
                    canvas.setFloat(null);
                    BeanFactory.setProperty(canvas, "float", 26);
                    assertEqual(canvas.getFloat(), (float) 26, "set Float with int");
                    
                    canvas.setFloat(null);
                    BeanFactory.setProperty(canvas, "float", "28");
                    assertEqual(canvas.getFloat(), (float) 28, "set Float with String");

                    setResult();
                }
            },
            
            new TestCase("float") {
                public void doTest () {
                    TypesCanvas canvas = new TypesCanvas();

                    canvas.setPrFloat(7);
                    BeanFactory.setProperty(canvas, "prFloat", null);
                    assertEqual(canvas.getPrFloat(), (float) 0, "set float with null");

                    canvas.setPrFloat(0);
                    BeanFactory.setProperty(canvas, "prFloat", true);
                    assertEqual(canvas.getPrFloat(), (float) 1, "set float with boolean true");

                    canvas.setPrFloat(1);
                    BeanFactory.setProperty(canvas, "prFloat", false);
                    assertEqual(canvas.getPrFloat(), (float) 0, "set float with boolean false");

                    canvas.setPrFloat(0);
                    BeanFactory.setProperty(canvas, "prFloat", 27.4);
                    assertWithin(canvas.getPrFloat(), (float) 27.4, 0.00001, "set float with float");
                    
                    canvas.setPrFloat(0);
                    BeanFactory.setProperty(canvas, "prFloat", 26);
                    assertEqual(canvas.getPrFloat(), (float) 26, "set float with int");
                    
                    canvas.setPrFloat(0);
                    BeanFactory.setProperty(canvas, "prFloat", "28");
                    assertEqual(canvas.getPrFloat(), (float) 28, "set float with String");

                    setResult();
                }
            },

            new TestCase("Double") {
                public void doTest () {
                    TypesCanvas canvas = new TypesCanvas();

                    canvas.setDouble((double) 7);
                    BeanFactory.setProperty(canvas, "double", null);
                    assertNull(canvas.getDouble(), "set Double with null");

                    canvas.setDouble(null);
                    BeanFactory.setProperty(canvas, "double", true);
                    assertEqual(canvas.getDouble(), (double) 1, "set Double with boolean true");

                    canvas.setDouble(null);
                    BeanFactory.setProperty(canvas, "double", false);
                    assertEqual(canvas.getDouble(), (double) 0, "set Double with boolean false");

                    canvas.setDouble(null);
                    BeanFactory.setProperty(canvas, "double", 27.4);
                    assertWithin(canvas.getDouble(), (double) 27.4, 0.000001, "set Double with float");
                    
                    canvas.setDouble(null);
                    BeanFactory.setProperty(canvas, "double", 26);
                    assertEqual(canvas.getDouble(), (double) 26, "set Double with int");
                    
                    canvas.setDouble(null);
                    BeanFactory.setProperty(canvas, "double", "28");
                    assertEqual(canvas.getDouble(), (double) 28, "set Double with String");

                    setResult();
                }
            },
            
            new TestCase("double") {
                public void doTest () {
                    TypesCanvas canvas = new TypesCanvas();

                    canvas.setPrDouble(7);
                    BeanFactory.setProperty(canvas, "prDouble", null);
                    assertEqual(canvas.getPrDouble(), (double) 0, "set double with null");

                    canvas.setPrDouble(0);
                    BeanFactory.setProperty(canvas, "prDouble", true);
                    assertEqual(canvas.getPrDouble(), (double) 1, "set double with boolean true");

                    canvas.setPrDouble(1);
                    BeanFactory.setProperty(canvas, "prDouble", false);
                    assertEqual(canvas.getPrDouble(), (double) 0, "set double with boolean false");

                    canvas.setPrDouble(0);
                    BeanFactory.setProperty(canvas, "prDouble", 27.4);
                    assertWithin(canvas.getPrDouble(), (double) 27.4, 0.0000001, "set double with float");
                    
                    canvas.setPrDouble(0);
                    BeanFactory.setProperty(canvas, "prDouble", 26);
                    assertEqual(canvas.getPrDouble(), (double) 26, "set double with int");
                    
                    canvas.setPrDouble(0);
                    BeanFactory.setProperty(canvas, "prDouble", "28");
                    assertEqual(canvas.getPrDouble(), (double) 28, "set double with String");

                    setResult();
                }
            },

            new TestCase("String") {
                public void doTest () {
                    TypesCanvas canvas = new TypesCanvas();

                    canvas.setString("string");
                    BeanFactory.setProperty(canvas, "string", null);
                    assertNull(canvas.getString(), "set String with null");

                    canvas.setString(null);
                    BeanFactory.setProperty(canvas, "string", new Integer[] {7, 8, 9});
                    assertEqual(canvas.getString(), "[7, 8, 9]", "set String with Object[]");

                    canvas.setString(null);
                    BeanFactory.setProperty(canvas, "string", new boolean[] {true, false, true});
                    assertEqual(canvas.getString(), "[true, false, true]", "set String with boolean[]");

                    canvas.setString(null);
                    BeanFactory.setProperty(canvas, "string", new int[] {7, 8, 9});
                    assertEqual(canvas.getString(), "[7, 8, 9]", "set String with int[]");

                    canvas.setString(null);
                    BeanFactory.setProperty(canvas, "string", new long[] {7L, 8L, 9L});
                    assertEqual(canvas.getString(), "[7, 8, 9]", "set String with long[]");

                    canvas.setString(null);
                    BeanFactory.setProperty(canvas, "string", new float[] {7F, 8F, 9F});
                    assertEqual(canvas.getString(), "[7, 8, 9]", "set String with long[]");

                    canvas.setString(null);
                    BeanFactory.setProperty(canvas, "string", new double[] {7D, 8D, 9D});
                    assertEqual(canvas.getString(), "[7, 8, 9]", "set String with long[]");

                    canvas.setString(null);
                    BeanFactory.setProperty(canvas, "string", "string");
                    assertEqual(canvas.getString(), "string", "set String with String");

                    setResult();
                }
            },

            new TestCase("Date") {
                public void doTest () {
                    TypesCanvas canvas = new TypesCanvas();

                    canvas.setDate(new Date());
                    BeanFactory.setProperty(canvas, "date", null);
                    assertNull(canvas.getDate(), "set Date with null");

                    canvas.setDate(null);
                    Date date = new Date(2000000L);
                    BeanFactory.setProperty(canvas, "date", date);
                    assertEqual(canvas.getDate(), date, "set Date with Date");
                    
                    canvas.setDate(null);
                    BeanFactory.setProperty(canvas, "date", "10/29/2012");
                    String formattedDate = DateTimeFormat.getFormat("yyyyMMdd").format(canvas.getDate());
                    assertEqual(formattedDate, "20121029", "set Date with String");

                    setResult();
                }
            },

            new TestCase("JavaScriptObject") {
                public native JavaScriptObject jsObj () /*-{
                    return {
                        property: "property",
                        anotherProperty: "another property"
                    };
                }-*/;

                public void doTest () {
                    TypesCanvas canvas = new TypesCanvas();

                    canvas.setJavaScriptObject(jsObj());
                    BeanFactory.setProperty(canvas, "javaScriptObject", null);
                    assertNull(canvas.getJavaScriptObject(), "set JavaScriptObject with null");

                    canvas.setJavaScriptObject(null);
                    BeanFactory.setProperty(canvas, "javaScriptObject", jsObj());
                    JavaScriptObject jsObj = canvas.getJavaScriptObject();
                    assertEqual(JSOHelper.getAttribute(jsObj, "property"), "property", "set JavaScriptObject with JavaScriptObject");
                    assertEqual(JSOHelper.getAttribute(jsObj, "anotherProperty"), "another property", "set JavaScriptObject with JavaScriptObject");

                    canvas.setJavaScriptObject(null);
                    Map<String, Object> map = new HashMap<String, Object>();
                    map.put("property", "property");
                    map.put("anotherProperty", "another property");
                    BeanFactory.setProperty(canvas, "javaScriptObject", map);
                    jsObj = canvas.getJavaScriptObject();
                    assertEqual(JSOHelper.getAttribute(jsObj, "property"), "property", "set JavaScriptObject with map");
                    assertEqual(JSOHelper.getAttribute(jsObj, "anotherProperty"), "another property", "set JavaScriptObject with map");

                    setResult();
                }
            },

            new TestCase("enum") {
                public void doTest () {
                    TypesCanvas canvas = new TypesCanvas();

                    canvas.setEnum(TypesCanvas.TestEnum.VALUE1);
                    BeanFactory.setProperty(canvas, "enum", null);
                    assertNull(canvas.getEnum(), "set enum with null");

                    canvas.setEnum(null);
                    BeanFactory.setProperty(canvas, "enum", TypesCanvas.TestEnum.VALUE1);
                    assertEqual(canvas.getEnum(), TypesCanvas.TestEnum.VALUE1, "set enum with enum");
                    
                    canvas.setEnum(null);
                    BeanFactory.setProperty(canvas, "enum", "VALUE1");
                    assertEqual(canvas.getEnum(), TypesCanvas.TestEnum.VALUE1, "set enum with String");

                    setResult();
                }
            },
            
            new TestCase("ValueEnum") {
                public void doTest () {
                    TypesCanvas canvas = new TypesCanvas();

                    canvas.setValueEnum(Alignment.CENTER);
                    BeanFactory.setProperty(canvas, "valueEnum", null);
                    assertNull(canvas.getValueEnum(), "set ValueEnum with null");

                    canvas.setValueEnum(null);
                    BeanFactory.setProperty(canvas, "valueEnum", Alignment.CENTER);
                    assertEqual(canvas.getValueEnum(), Alignment.CENTER, "set ValueEnum with ValueEnum");
                    
                    canvas.setValueEnum(null);
                    BeanFactory.setProperty(canvas, "valueEnum", "center");
                    assertEqual(canvas.getValueEnum(), Alignment.CENTER, "set ValueEnum with String");

                    setResult();
                }
            },

            new TestCase("interface") {
                public void doTest () {
                    class TestImpl implements TypesCanvas.TestInterface {
                        public void testMethod () {}
                    }

                    class Subclass implements SubclassInterface {
                        public void testMethod () {}
                    }
                
                    TypesCanvas canvas = new TypesCanvas();
                    TestImpl impl = new TestImpl();
                    Subclass subclass = new Subclass();

                    canvas.setInterface(impl);
                    BeanFactory.setProperty(canvas, "interface", null);
                    assertNull(canvas.getInterface(), "set interface with null");

                    canvas.setInterface(null);
                    BeanFactory.setProperty(canvas, "interface", impl);
                    assertEqual(canvas.getInterface(), impl, "set interface with interface");

                    canvas.setInterface(null);
                    BeanFactory.setProperty(canvas, "interface", subclass);
                    assertEqual(canvas.getInterface(), subclass, "set interface with subclass");

                    setResult();
                }
            },

            new TestCase("interface[]") {
                class TestImpl implements TypesCanvas.TestInterface {
                    public void testMethod () {}
                }
                
                public void doTest () {
                    TypesCanvas canvas = new TypesCanvas();
                    TestImpl[] impl = new TestImpl[] {new TestImpl(), new TestImpl()};
                    TypesCanvas.TestInterface[] interfaceArray = new TypesCanvas.TestInterface[] {new TestImpl(), new TestImpl()};

                    canvas.setInterfaceArray(impl);
                    BeanFactory.setProperty(canvas, "interfaceArray", null);
                    assertNull(canvas.getInterfaceArray(), "set interface[] with null");

                    canvas.setInterfaceArray(null);
                    BeanFactory.setProperty(canvas, "interfaceArray", impl);
                    assertEqual(canvas.getInterfaceArray(), impl, "set interface[] with implementation[]");

                    canvas.setInterfaceArray(null);
                    BeanFactory.setProperty(canvas, "interfaceArray", interfaceArray);
                    assertEqual(canvas.getInterfaceArray(), interfaceArray, "set interface[] with interface[]");

                    setResult();
                }
            },

            new TestCase("JSOWrapperValue") {
                public native JavaScriptObject createCanvas () /*-{
                    return $wnd.isc.Canvas.create();
                }-*/;

                public native JavaScriptObject jsObj () /*-{
                    return {};
                }-*/;

                public void doTest () {
                    TypesCanvas canvas = new TypesCanvas();
                    Canvas value = new Canvas();

                    canvas.setCanvas(value);
                    BeanFactory.setProperty(canvas, "canvas", null);
                    assertNull(canvas.getCanvas(), "set JSOWrapper with null");

                    canvas.setCanvas(null);
                    BeanFactory.setProperty(canvas, "canvas", value);
                    assertEqual(canvas.getCanvas(), value, "set JSOWrapper with own type");

                    canvas.setCanvas(null);
                    JavaScriptObject jsCanvas = createCanvas();
                    BeanFactory.setProperty(canvas, "canvas", jsCanvas);
                    Canvas result = canvas.getCanvas();
                    assertTrue(result instanceof Canvas, "setting Canvas with JavaScript Canvas should create SmartGWT type");
                    assertEqual(result.getOrCreateJsObj(), jsCanvas, "setting Canvas with JavaScript Canvas should preserve the JavaScript Canvas");

                    boolean exceptionThrown = false;
                    canvas.setCanvas(null);
                    try {
                        BeanFactory.setProperty(canvas, "canvas", jsObj());
                    }
                    catch (IllegalArgumentException e) {
                        exceptionThrown = true;
                    }
                    assertTrue(exceptionThrown, "should throw an exception if JSO is wrong class");

                    setResult();
                }
            },

            new TestCase("OtherValue") {
                public void doTest () {
                    TypesCanvas canvas = new TypesCanvas();
                    TypesCanvas.OtherValue value = new TypesCanvas.OtherValue();
                    TypesCanvas.OtherValueSubclass subclass = new TypesCanvas.OtherValueSubclass(); 

                    canvas.setOtherValue(value);
                    BeanFactory.setProperty(canvas, "otherValue", null);
                    assertNull(canvas.getOtherValue(), "set OtherValue with null");

                    canvas.setOtherValue(null);
                    BeanFactory.setProperty(canvas, "otherValue", value);
                    assertEqual(canvas.getOtherValue(), value, "set OtherValue with its own type");

                    canvas.setOtherValue(null);
                    BeanFactory.setProperty(canvas, "otherValue", subclass);
                    assertEqual(canvas.getOtherValue(), subclass, "set OtherValue with a subclass");

                    boolean exceptionThrown = false;
                    canvas.setOtherValue(null);
                    try {
                        BeanFactory.setProperty(canvas, "otherValue", "");
                    }
                    catch (IllegalArgumentException e) {
                        exceptionThrown = true;
                    }
                    assertTrue(exceptionThrown, "should throw exception setting OtherValue with String");

                    setResult();
                }
            },

            new TestCase("int[]") {
                public void doTest () {
                    TypesCanvas canvas = new TypesCanvas();

                    canvas.setPrIntArray(new int[] {7, 8, 9});
                    BeanFactory.setProperty(canvas, "prIntArray", null);
                    assertNull(canvas.getPrIntArray(), "set int[] with null");

                    canvas.setPrIntArray(null);
                    BeanFactory.setProperty(canvas, "prIntArray", new int[] {8, 9, 10});
                    int[] result = canvas.getPrIntArray();
                    assertEqual(result.length, 3, "set int[] with int[]");
                    assertEqual(result[0], 8, "set int[] with int[]");
                    assertEqual(result[1], 9, "set int[] with int[]");
                    assertEqual(result[2], 10, "set int[] with int[]");

                    canvas.setPrIntArray(null);
                    BeanFactory.setProperty(canvas, "prIntArray", 7);
                    result = canvas.getPrIntArray();
                    assertEqual(result.length, 1, "set int[] with int");
                    assertEqual(result[0], 7, "set int[] with int");

                    canvas.setPrIntArray(null);
                    BeanFactory.setProperty(canvas, "prIntArray", new String[] {"8", "9", "10"});
                    result = canvas.getPrIntArray();
                    assertEqual(result.length, 3, "set int[] with String[]");
                    assertEqual(result[0], 8, "set int[] with String[]");
                    assertEqual(result[1], 9, "set int[] with String[]");
                    assertEqual(result[2], 10, "set int[] with String[]"); 

                    canvas.setPrIntArray(null);
                    BeanFactory.setProperty(canvas, "prIntArray", new float[] {8F, 9F, 10F});
                    result = canvas.getPrIntArray();
                    assertEqual(result.length, 3, "set int[] with float[]");
                    assertEqual(result[0], 8, "set int[] with float[]");
                    assertEqual(result[1], 9, "set int[] with float[]");
                    assertEqual(result[2], 10, "set int[] with float[]");

                    setResult();
                }
            },

            new TestCase("Number[]") {
                public void doTest () {
                    TypesCanvas canvas = new TypesCanvas();

                    canvas.setNumberArray(new Number[] {7, 8, 9});
                    BeanFactory.setProperty(canvas, "numberArray", null);
                    assertNull(canvas.getNumberArray(), "set Number[] with null");

                    canvas.setNumberArray(null);
                    BeanFactory.setProperty(canvas, "numberArray", new int[] {8, 9, 10});
                    Number[] result = canvas.getNumberArray();
                    assertEqual(result.length, 3, "set Number[] with int[]");
                    assertEqual(result[0], 8, "set Number[] with int[]");
                    assertEqual(result[1], 9, "set Number[] with int[]");
                    assertEqual(result[2], 10, "set Number[] with int[]");

                    canvas.setNumberArray(null);
                    BeanFactory.setProperty(canvas, "numberArray", 7);
                    result = canvas.getNumberArray();
                    assertEqual(result.length, 1, "set Number[] with int");
                    assertEqual(result[0], 7, "set Number[] with int");

                    canvas.setNumberArray(null);
                    BeanFactory.setProperty(canvas, "numberArray", new String[] {"8", "9", "10"});
                    result = canvas.getNumberArray();
                    assertEqual(result.length, 3, "set Number[] with String[]");
                    assertEqual(result[0], 8, "set Number[] with String[]");
                    assertEqual(result[1], 9, "set Number[] with String[]");
                    assertEqual(result[2], 10, "set Number[] with String[]"); 

                    setResult();
                }
            },

            new TestCase("boolean[]") {
                public void doTest () {
                    TypesCanvas canvas = new TypesCanvas();

                    canvas.setBooleanArray(new boolean[] {true, false, true});
                    BeanFactory.setProperty(canvas, "booleanArray", null);
                    assertNull(canvas.getBooleanArray(), "set boolean[] with null");

                    canvas.setBooleanArray(null);
                    BeanFactory.setProperty(canvas, "booleanArray", new boolean[] {true, false, true});
                    boolean[] result = canvas.getBooleanArray();
                    assertEqual(result.length, 3, "set boolean[] with boolean[]");
                    assertTrue(result[0], "set boolean[] with boolean[]");
                    assertFalse(result[1], "set boolean[] with boolean[]");
                    assertTrue(result[2], "set boolean[] with boolean[]");

                    canvas.setBooleanArray(null);
                    BeanFactory.setProperty(canvas, "booleanArray", new int[] {1, 0, 1});
                    result = canvas.getBooleanArray();
                    assertEqual(result.length, 3, "set boolean[] with int[]");
                    assertTrue(result[0], "set boolean[] with int[]");
                    assertFalse(result[1], "set boolean[] with int[]");
                    assertTrue(result[2], "set boolean[] with int[]");

                    canvas.setBooleanArray(null);
                    BeanFactory.setProperty(canvas, "booleanArray", new String[] {"true", "false", "true"});
                    result = canvas.getBooleanArray();
                    assertEqual(result.length, 3, "set boolean[] with String[]");
                    assertTrue(result[0], "set boolean[] with String[]");
                    assertFalse(result[1], "set boolean[] with String[]");
                    assertTrue(result[2], "set boolean[] with String[]");
                
                    setResult();
                }
            }
        );
    }
}
