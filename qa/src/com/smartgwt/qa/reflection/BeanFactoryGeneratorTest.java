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

import com.smartgwt.qa.TestRunner;
import com.smartgwt.qa.TestCase;

import com.smartgwt.client.bean.BeanFactory;
import com.smartgwt.client.bean.BeanValueType;
import com.smartgwt.client.util.JSOHelper;
import com.smartgwt.client.widgets.Canvas;

// Tests various things that the BeanFactory generator 
// ought to take care of.
public class BeanFactoryGeneratorTest extends TestRunner {
    public static class TestCanvas extends Canvas {
        public String getSuperclassProperty () {
            return "string";
        }

        public int getOverriddenProperty () {
            return 17;
        }

        public int getOverloadedPropertyInSubclass () {
            return 42;
        }

        public String isDynamicPropertyWithoutGet () {
            return "is dynamic property";
        }

        public String isDynamicProperty () {
            return "is dynamic property";
        }

        public String getDynamicProperty () {
            return "get dynamic property";
        }
    }

    public static class TestCanvasSubclass extends TestCanvas {
        public int getSubclassProperty () {
            return 17;
        }

        @Override
        public int getOverriddenProperty () {
            return 34;
        }

        public String getOverloadedPropertyInSubclassAsString () {
            return "3.4";
        }
    }

    public static class ThirdLevelSubclass extends TestCanvasSubclass {

    }

    public static interface MyBeanFactories extends BeanFactory.MetaFactory {
        BeanFactory<TestCanvas> getTestCanvasFactory();
        BeanFactory<TestCanvasSubclass> getAnotherFactory();
        BeanFactory<ThirdLevelSubclass> getYetAnotherFactory();
    }

    static {
        // Actually generates the factories. We do it here as an example ...
        // you could create all of them in code that initializes the
        // application, rather than near the point of use like this. It
        // would be slightly more efficient to create them all at once.
        GWT.create(MyBeanFactories.class);
    }

    public BeanFactoryGeneratorTest () { 
        super(
            new TestCase("excluded properties") {
                public void doTest () {
                    TestCanvas canvas = new TestCanvas();
                    
                    assertNull(BeanFactory.getProperty(canvas, "logicalStructure"), "logicalStructure should be excluded by the generator");

                    setResult();
                }
            },

            new TestCase("subclasses") {
                public void doTest () {
                    TestCanvasSubclass canvas = new TestCanvasSubclass();

                    assertEqual(BeanFactory.getProperty(canvas, "subclassProperty"), 17, "should get property defined on subclass");
                    assertEqual(BeanFactory.getProperty(canvas, "superclassProperty"), "string", "should get property defined on superclass");

                    assertEqual(BeanFactory.getProperty(canvas, "overloadedPropertyInSubclass").toString(), "42", "should inherit property even if overloading one getter");
                    assertEqual(BeanFactory.getPropertyAsString(canvas, "overloadedPropertyInSubclass"),  "3.4", "should apply overloaded getter");

                    assertEqual(BeanFactory.getProperty(canvas, "overriddenProperty"), 34, "should use overridden version of property");

                    TestCanvas superclass = new TestCanvas();
                    assertEqual(BeanFactory.getProperty(superclass, "overriddenProperty"), 17, "should use superclass property on superclass");

                    ThirdLevelSubclass thirdLevel = new ThirdLevelSubclass();
                    assertEqual(BeanFactory.getProperty(thirdLevel, "superclassProperty"), "string", "superclass properties should work on third-level as well");

                    setResult();
                }
            },

            new TestCase("registration") {
                public native boolean isBaseWidgetRegistered () /*-{
                    return $wnd.isc.com.smartgwt.client.widgets.BaseWidget != null;
                }-*/;
                
                public native boolean isCanvasRegistered () /*-{
                    return $wnd.isc.com.smartgwt.client.widgets.Canvas != null;
                }-*/;
                
                public void doTest () {
                    assertFalse(isBaseWidgetRegistered(), "BaseWidgetFactory will be created as a superclass, but shouldn't be registered with SmartClient");
                    assertTrue(isCanvasRegistered(), "Canvas should be registered with SmartClient");

                    setResult();
                }
            },

            new TestCase("is vs. get") {
                public void doTest () {
                    TestCanvas canvas = new TestCanvas();

                    assertEqual(BeanFactory.getProperty(canvas, "dynamicPropertyWithoutGet"), "is dynamic property", "is... should work if no get...");
                    assertEqual(BeanFactory.getProperty(canvas, "dynamicProperty"), "get dynamic property", "get... should be preferred over is...");

                    setResult();
                }
            }
        );
    }
}
