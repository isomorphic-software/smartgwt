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

import static com.smartgwt.client.bean.BeanValueType.Convertability.EXACT;
import static com.smartgwt.client.bean.BeanValueType.Convertability.PREFERRED;
import static com.smartgwt.client.bean.BeanValueType.Convertability.SUPPORTED;
import static com.smartgwt.client.bean.BeanValueType.Convertability.UNSUPPORTED;

import com.smartgwt.client.util.DateUtil;
import com.smartgwt.client.util.JSOHelper;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.grid.ListGrid;

import com.smartgwt.qa.reflection.widgets.CustomCanvas;
import com.smartgwt.qa.reflection.widgets.TypesCanvas;

import java.util.Date;
import java.util.Map;
import java.util.HashMap;

// Tests the convertabilityFrom method in various BeanValueType subclasses.
// This set of tests is probably too unit-test oriented, but to do the
// equivalent functional testing on BeanFactory itself would be even more
// tedious -- one would have to set up Canvas subclasses with multiple setters
// for a property, and then test which one won in various cases. That would be
// a good idea, but this will do for now.
public class ConvertabilityTest extends TestRunner {
    enum TestEnum {
        VALUE1,
        VALUE2
    }

    static interface TestInterface {
        public void testMethod();
    }

    static interface TestInterfaceSubclass extends TestInterface {
        public void anotherMethod();
    }
    
    public static class TestImpl implements TestInterface {
        public void testMethod () {
        
        }
    }

    public static class TestSubclassImpl implements TestInterfaceSubclass {
        public void testMethod () {

        }

        public void anotherMethod () {

        }
    }

    // This tests JSO wrappers that don't have scClassName set
    public static class JsoWrapperTest {
        JsoWrapperTest (JavaScriptObject obj) {

        }
    }

    public static class OtherValue {

    }

    interface MyBeanValueTypes extends BeanValueType.MetaFactory {
        BeanValueType<TestEnum> getTestEnumValueType();
        BeanValueType<Date> getDateValueType();
        BeanValueType<TestInterface> getTestInterfaceValueType();
        BeanValueType<TestInterface[]> getTestInterfaceArrayValueType();
        BeanValueType<JavaScriptObject> getJSOValueType();
        BeanValueType<JsoWrapperTest> getJSOWrapperValueType();
        BeanValueType<Canvas> getCanvasValueType();
        BeanValueType<OtherValue> getOtherValueType();
        BeanValueType<Alignment> getAlignmentValueType();
        BeanValueType<int[]> getIntArrayValueType();
    };

    static {
        GWT.create(MyBeanValueTypes.class);
        BeanValueType.registerBasicValueTypes();
    }

    public ConvertabilityTest () { 
        super(
            new TestCase("boolean") {
                public void doTest () {
                    BeanValueType bvt = BeanValueType.getBeanValueType(boolean.class);

                    assertEqual(bvt.convertabilityFrom(null), SUPPORTED, "boolean / null");
                    assertEqual(bvt.convertabilityFrom(true), EXACT, "boolean / boolean");
                    assertEqual(bvt.convertabilityFrom(7), SUPPORTED, "boolean / int");
                    assertEqual(bvt.convertabilityFrom("true"), SUPPORTED, "boolean / string");

                    setResult();
                }
            },

            new TestCase("Boolean") {
                public void doTest () {
                    BeanValueType bvt = BeanValueType.getBeanValueType(Boolean.class);

                    assertEqual(bvt.convertabilityFrom(null), PREFERRED, "Boolean / null");
                    assertEqual(bvt.convertabilityFrom(true), EXACT, "Boolean / boolean");
                    assertEqual(bvt.convertabilityFrom(7), SUPPORTED, "Boolean / int");
                    assertEqual(bvt.convertabilityFrom("true"), SUPPORTED, "Boolean / String");

                    setResult();
                }
            },

            new TestCase("Date") {
                public void doTest () {
                    BeanValueType bvt = BeanValueType.getBeanValueType(Date.class);

                    assertEqual(bvt.convertabilityFrom(null), PREFERRED, "Date / null");
                    assertEqual(bvt.convertabilityFrom(new Date()), EXACT, "Date / Date");
                    assertEqual(bvt.convertabilityFrom("10/10/2012"), SUPPORTED, "Date / String");

                    setResult();
                }
            },
            
            new TestCase("double") {
                public void doTest () {
                    BeanValueType bvt = BeanValueType.getBeanValueType(double.class);

                    assertEqual(bvt.convertabilityFrom(null), SUPPORTED, "double / null");
                    assertEqual(bvt.convertabilityFrom(true), SUPPORTED, "double / boolean");
                    assertEqual(bvt.convertabilityFrom(7), PREFERRED, "double / int");
                    assertEqual(bvt.convertabilityFrom(7.1d), EXACT, "double / double");
                    assertEqual(bvt.convertabilityFrom("27.1"), SUPPORTED, "double / string");

                    setResult();
                }
            },

            new TestCase("Double") {
                public void doTest () {
                    BeanValueType bvt = BeanValueType.getBeanValueType(Double.class);

                    assertEqual(bvt.convertabilityFrom(null), PREFERRED, "Double / null");
                    assertEqual(bvt.convertabilityFrom(true), SUPPORTED, "Double / boolean");
                    assertEqual(bvt.convertabilityFrom(7), PREFERRED, "Double / int");
                    assertEqual(bvt.convertabilityFrom(7.1d), EXACT, "Double / double");
                    assertEqual(bvt.convertabilityFrom("27.1"), SUPPORTED, "Double / string");

                    setResult();
                }
            },

            new TestCase("float") {
                public void doTest () {
                    BeanValueType bvt = BeanValueType.getBeanValueType(float.class);

                    assertEqual(bvt.convertabilityFrom(null), SUPPORTED, "float / null");
                    assertEqual(bvt.convertabilityFrom(true), SUPPORTED, "float / boolean");
                    assertEqual(bvt.convertabilityFrom(7), PREFERRED, "float / int");
                    assertEqual(bvt.convertabilityFrom(7.1f), EXACT, "float / float");
                    assertEqual(bvt.convertabilityFrom("27.1"), SUPPORTED, "float / string");

                    setResult();
                }
            },

            new TestCase("Float") {
                public void doTest () {
                    BeanValueType bvt = BeanValueType.getBeanValueType(Float.class);

                    assertEqual(bvt.convertabilityFrom(null), PREFERRED, "Float / null");
                    assertEqual(bvt.convertabilityFrom(true), SUPPORTED, "Float / boolean");
                    assertEqual(bvt.convertabilityFrom(7), PREFERRED, "Float / int");
                    assertEqual(bvt.convertabilityFrom(7.1f), EXACT, "Float / float");
                    assertEqual(bvt.convertabilityFrom("27.1"), SUPPORTED, "Float / string");

                    setResult();
                }
            },
            
            new TestCase("int") {
                public void doTest () {
                    BeanValueType bvt = BeanValueType.getBeanValueType(int.class);

                    assertEqual(bvt.convertabilityFrom(null), SUPPORTED, "int / null");
                    assertEqual(bvt.convertabilityFrom(true), SUPPORTED, "int / boolean");
                    assertEqual(bvt.convertabilityFrom(7.1f), PREFERRED, "int / float");
                    assertEqual(bvt.convertabilityFrom(7), EXACT, "int / int");
                    assertEqual(bvt.convertabilityFrom("27"), SUPPORTED, "int / string");

                    setResult();
                }
            },

            new TestCase("Integer") {
                public void doTest () {
                    BeanValueType bvt = BeanValueType.getBeanValueType(Integer.class);

                    assertEqual(bvt.convertabilityFrom(null), PREFERRED, "Integer / null");
                    assertEqual(bvt.convertabilityFrom(true), SUPPORTED, "Integer / boolean");
                    assertEqual(bvt.convertabilityFrom(7.1f), PREFERRED, "Integer / float");
                    assertEqual(bvt.convertabilityFrom(7), EXACT, "Integer, int");
                    assertEqual(bvt.convertabilityFrom("27"), SUPPORTED, "Integer, string");

                    setResult();
                }
            },
            
            new TestCase("long") {
                public void doTest () {
                    BeanValueType bvt = BeanValueType.getBeanValueType(long.class);

                    assertEqual(bvt.convertabilityFrom(null), SUPPORTED, "long / null");
                    assertEqual(bvt.convertabilityFrom(true), SUPPORTED, "long / boolean");
                    assertEqual(bvt.convertabilityFrom(7.1f), PREFERRED, "long / float");
                    assertEqual(bvt.convertabilityFrom(7L), EXACT, "long / long");
                    assertEqual(bvt.convertabilityFrom("27"), SUPPORTED, "long / String");

                    setResult();
                }
            },

            new TestCase("Long") {
                public void doTest () {
                    BeanValueType bvt = BeanValueType.getBeanValueType(Long.class);

                    assertEqual(bvt.convertabilityFrom(null), PREFERRED, "Long / null");
                    assertEqual(bvt.convertabilityFrom(true), SUPPORTED, "Long / boolean");
                    assertEqual(bvt.convertabilityFrom(7.1f), PREFERRED, "Long / float");
                    assertEqual(bvt.convertabilityFrom(7L), EXACT, "Long / long");
                    assertEqual(bvt.convertabilityFrom("27"), SUPPORTED, "Long / String");

                    setResult();
                }
            },
            
            new TestCase("Number") {
                public void doTest () {
                    BeanValueType bvt = BeanValueType.getBeanValueType(Number.class);

                    assertEqual(bvt.convertabilityFrom(null), PREFERRED, "Number / null");
                    assertEqual(bvt.convertabilityFrom(true), SUPPORTED, "Number / boolean");
                    assertEqual(bvt.convertabilityFrom(7.1f), EXACT, "Number / float");
                    assertEqual(bvt.convertabilityFrom(7L), EXACT, "Number / long");
                    assertEqual(bvt.convertabilityFrom("27"), SUPPORTED, "Number / String");

                    setResult();
                }
            },
            
            new TestCase("enum") {
                public void doTest () {
                    BeanValueType bvt = BeanValueType.getBeanValueType(TestEnum.class);

                    assertEqual(bvt.convertabilityFrom(null), SUPPORTED, "enum / null");
                    assertEqual(bvt.convertabilityFrom(TestEnum.VALUE1), EXACT, "enum, enum");
                    assertEqual(bvt.convertabilityFrom("VALUE1"), SUPPORTED, "enum, string");

                    setResult();
                }
            },
            
            new TestCase("ValueEnum") {
                public void doTest () {
                    BeanValueType bvt = BeanValueType.getBeanValueType(Alignment.class);

                    assertEqual(bvt.convertabilityFrom(null), SUPPORTED, "ValueEnum / null");
                    assertEqual(bvt.convertabilityFrom(Alignment.CENTER), EXACT, "ValueEnum / ValueEnum");
                    assertEqual(bvt.convertabilityFrom("center"), SUPPORTED, "ValueEnum / string");
                    assertEqual(bvt.convertabilityFrom(TestEnum.VALUE1), UNSUPPORTED, "ValueEnum / enum");

                    setResult();
                }
            },
            
            new TestCase("OtherValue") {
                public void doTest () {
                    class OtherSubclass extends OtherValue {

                    }

                    BeanValueType bvt = BeanValueType.getBeanValueType(OtherValue.class);

                    assertEqual(bvt.convertabilityFrom(null), SUPPORTED, "OtherValue / null");
                    assertEqual(bvt.convertabilityFrom(new OtherValue()), EXACT, "OtherValue / OtherValue");
                    assertEqual(bvt.convertabilityFrom(new OtherSubclass()), PREFERRED, "OtherValue / subclass");
                    assertEqual(bvt.convertabilityFrom(""), UNSUPPORTED, "OtherValue / not subclass");

                    setResult();
                }
            },
            
            new TestCase("String") {
                public void doTest () {
                    BeanValueType bvt = BeanValueType.getBeanValueType(String.class);

                    assertEqual(bvt.convertabilityFrom(null), SUPPORTED, "String / null");
                    assertEqual(bvt.convertabilityFrom("string"), EXACT, "String / string");
                    assertEqual(bvt.convertabilityFrom(76), SUPPORTED, "String / int");

                    setResult();
                }
            },

            new TestCase("interface") {
                public void doTest () {
                    BeanValueType bvt = BeanValueType.getBeanValueType(TestInterface.class);
                    
                    assertEqual(bvt.convertabilityFrom(null), SUPPORTED, "interface / null");
                    assertEqual(bvt.convertabilityFrom(new TestImpl()), PREFERRED, "interface / impl");
                    assertEqual(bvt.convertabilityFrom(new TestSubclassImpl()), PREFERRED, "interface / subclass");
                    assertEqual(bvt.convertabilityFrom(new Canvas()), UNSUPPORTED, "interface / not impl");
                
                    setResult();
                }
            },

            new TestCase("interface[]") {
                public void doTest () {
                    BeanValueType bvt = BeanValueType.getBeanValueType(TestInterface[].class);
                    
                    assertEqual(bvt.convertabilityFrom(null), SUPPORTED, "interface[] / null");
                    assertEqual(bvt.convertabilityFrom(new TestImpl[] {new TestImpl()}), PREFERRED, "interface[], impl[]");
                    assertEqual(bvt.convertabilityFrom(new TestSubclassImpl[] {new TestSubclassImpl()}), PREFERRED, "interface[] / subclass[]");
                    assertEqual(bvt.convertabilityFrom(new Canvas[] {new Canvas()}), UNSUPPORTED, "interface[] / not subclass[]");
                
                    setResult();
                }
            },

            new TestCase("int[]") {
                public void doTest () {
                    BeanValueType bvt = BeanValueType.getBeanValueType(int[].class);
                    
                    assertEqual(bvt.convertabilityFrom(null), SUPPORTED, "int[] / null");
                    assertEqual(bvt.convertabilityFrom(new int[] {7, 8}), EXACT, "int[] / int[]");
                    assertEqual(bvt.convertabilityFrom(7), PREFERRED, "int[] / int");
                    assertEqual(bvt.convertabilityFrom(new float[] {7f, 8f}), PREFERRED, "int[] / float[]");
                    assertEqual(bvt.convertabilityFrom(new String[] {"7", "8"}), SUPPORTED, "int[] / String[]");
                    assertEqual(bvt.convertabilityFrom(new Canvas[] {new Canvas()}), UNSUPPORTED, "int[] / Canvas[]");
                
                    setResult();
                }
            },

            new TestCase("JavaScriptObject") {
                public native JavaScriptObject jsObj () /*-{
                    return {};
                }-*/;
                
                public void doTest () {
                    BeanValueType bvt = BeanValueType.getBeanValueType(JavaScriptObject.class);
                    
                    assertEqual(bvt.convertabilityFrom(null), SUPPORTED, "JSO / null");
                    assertEqual(bvt.convertabilityFrom(jsObj()), EXACT, "JSO / JSO");

                    Map<String, Object> map = new HashMap<String, Object>();
                    assertEqual(bvt.convertabilityFrom(map), SUPPORTED, "JSO / Map");
                
                    setResult();
                }
            },

            new TestCase("JSOWrapper") {
                public native JavaScriptObject jsCanvas () /*-{
                    return $wnd.isc.Canvas.create();
                }-*/;

                public native JavaScriptObject jsObj () /*-{
                    return {};
                }-*/;

                public void doTest () {
                    BeanValueType bvt = BeanValueType.getBeanValueType(Canvas.class);

                    assertEqual(bvt.convertabilityFrom(null), SUPPORTED, "Canvas / null");
                    assertEqual(bvt.convertabilityFrom(jsObj()), UNSUPPORTED, "Canvas / JSO");
                    assertEqual(bvt.convertabilityFrom(jsCanvas()), SUPPORTED, "Canvas / JsoCanvas");
                    assertEqual(bvt.convertabilityFrom(new Canvas()), EXACT, "Canvas / Canvas");
                    assertEqual(bvt.convertabilityFrom(new ListGrid()), PREFERRED, "Canvas / ListGrid");
                    
                    bvt = BeanValueType.getBeanValueType(JsoWrapperTest.class);

                    assertEqual(bvt.convertabilityFrom(null), SUPPORTED, "JSOWrapper / null");
                    assertEqual(bvt.convertabilityFrom(jsObj()), SUPPORTED, "JSOWrapper / JSO");
                    assertEqual(bvt.convertabilityFrom(jsCanvas()), SUPPORTED, "JSOWrapper / JsoCanvas");
                    assertEqual(bvt.convertabilityFrom(new Canvas()), UNSUPPORTED, "JSOWrapper / Canvas");
                    assertEqual(bvt.convertabilityFrom(new ListGrid()), UNSUPPORTED, "JSOWrapper / ListGrid");
                
                    setResult();
                }
            }
        );
    }
}
