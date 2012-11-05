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
import com.smartgwt.client.widgets.Canvas;

// Tests the static methods of BeanFactory
public class BeanFactoryStaticTest extends TestRunner {
    static interface MyBeanFactories extends BeanFactory.MetaFactory {
        BeanFactory<Canvas> getCanvasFactory();
    }

    static {
        // Actually generates the factories. We do it here as an example ...
        // you could create all of them in code that initializes the
        // application, rather than near the point of use like this. It
        // would be slightly more efficient to create them all at once.
        GWT.create(MyBeanFactories.class);
    }

    public BeanFactoryStaticTest () {
        super(
            new TestCase("getFactory (String)") {
                public void doTest () {
                    BeanFactory factory = BeanFactory.getFactory("com.smartgwt.client.widgets.Canvas");

                    assertNotNull(factory, "factory should not be null");
                    assertEqual(factory.getBeanClassName(), "com.smartgwt.client.widgets.Canvas", "beanClassName should be correct");

                    setResult();
                }
            },

            new TestCase("getFactory (Class)") {
                public void doTest () {
                    BeanFactory factory = BeanFactory.getFactory(Canvas.class);

                    assertNotNull(factory, "factory should not be null");
                    assertEqual(factory.getBeanClassName(), "com.smartgwt.client.widgets.Canvas", "beanClassName should be correct");

                    setResult();
                }
            },

            new TestCase("newInstance (String) with registered class") {
                public void doTest () {
                    Object instance = BeanFactory.newInstance("com.smartgwt.client.widgets.Canvas");

                    assertTrue(instance instanceof Canvas, "instance should be a Canvas");

                    setResult();
                }
            },

            new TestCase("newInstance (String) with non-registered class") {
                public void doTest () {
                    boolean exceptionThrown = false;
                    
                    try {
                        Object instance = BeanFactory.newInstance("com.smartgwt.client.widgets.Nonexistent");
                    }
                    catch (IllegalStateException e) {
                        exceptionThrown = true;    
                    }

                    assertTrue(exceptionThrown, "should throw exception for non-registered class");

                    setResult();
                }
            },

            new TestCase("newInstance (Class) with registered class") {
                public void doTest () {
                    Object instance = BeanFactory.newInstance(com.smartgwt.client.widgets.Canvas.class);

                    assertTrue(instance instanceof Canvas, "instance should be a Canvas");

                    setResult();
                }
            },

            new TestCase("newInstance (Class) with non-registered class") {
                public void doTest () {
                    boolean exceptionThrown = false;
                    
                    try {
                        Object instance = BeanFactory.newInstance(String.class);
                    }
                    catch (IllegalStateException e) {
                        exceptionThrown = true;    
                    }

                    assertTrue(exceptionThrown, "should throw exception for non-registered class");

                    setResult();
                }
            },

            new TestCase("setProperty") {
                public void doTest () {
                    // We'll just test a very basic case here ... just to
                    // see that the actual static method is working
                    Canvas myCanvas = new Canvas();
                    BeanFactory.setProperty(myCanvas, "width", 501);
                    
                    assertEqual(myCanvas.getWidth(), 501, "width should have been set");

                    setResult();
                }
            },

            new TestCase("getProperty") {
                public void doTest () {
                    // We'll just test basic functionality here
                    Canvas myCanvas = new Canvas();
                    myCanvas.setWidth(502);
                    Object property = BeanFactory.getProperty(myCanvas, "width");

                    assertEqual(property, 502, "should get correct width");

                    setResult();
                }
            },

            new TestCase("getPropertyAsString") {
                public void doTest () {
                    Canvas myCanvas = new Canvas();
                    myCanvas.setWidth("80%");
                    Object property = BeanFactory.getPropertyAsString(myCanvas, "width");

                    assertTrue(property instanceof String, "property should be a String");
                    assertEqual(property, "80%", "property should have correct value");

                    setResult();
                }
            },

            new TestCase("getAttributes (String)") {
                public void doTest () {
                    String[] attributes = BeanFactory.getAttributes("com.smartgwt.client.widgets.Canvas");

                    assertContains(attributes, "width", "attributes should include 'width'");

                    setResult();
                }
            },

            new TestCase("getAttributes (Class)") {
                public void doTest () {
                    String[] attributes = BeanFactory.getAttributes(Canvas.class);

                    assertContains(attributes, "width", "attributes should include 'width'");

                    setResult();
                }
            },

            new TestCase("getOrCreateJsObj") {
                public void doTest () {
                    Canvas myCanvas = new Canvas();
                    JavaScriptObject jsObj = BeanFactory.getOrCreateJsObj(myCanvas);

                    assertTrue(BeanValueType.isA(jsObj, "Canvas"), "the jsObj should be a Canvas");

                    setResult();
                }
            }
        );
    }
}
