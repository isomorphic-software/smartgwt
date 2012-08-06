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
import com.smartgwt.client.widgets.BaseWidget;

import com.smartgwt.qa.reflection.widgets.CustomCanvas;

// Tests the instance methods of BeanFactory
public class BeanFactoryInstanceTest extends TestRunner {
    public static interface MyBeanFactories extends BeanFactory.MetaFactory {
        BeanFactory<Canvas> getCanvasFactory();
        BeanFactory<BaseWidget> getBaseWidgetFactory();
        BeanFactory<CustomCanvas> getCustomCanvasFactory();
    }

    static {
        // Actually generates the factories. We do it here as an example ...
        // you could create all of them in code that initializes the
        // application, rather than near the point of use like this. It
        // would be slightly more efficient to create them all at once.
        GWT.create(MyBeanFactories.class);
    }

    public BeanFactoryInstanceTest () {
        super(
            new TestCase("getBeanClass()") {
                public void doTest () {
                    BeanFactory factory = BeanFactory.getFactory(Canvas.class);

                    assertEqual(factory.getBeanClass(), Canvas.class, "getBeanClass() should return the bean class");

                    setResult();
                }
            },

            new TestCase("getBeanClassName()") {
                public void doTest () {
                    BeanFactory factory = BeanFactory.getFactory(Canvas.class);

                    assertEqual(factory.getBeanClassName(), "com.smartgwt.client.widgets.Canvas", "should return correct class name");

                    setResult();
                }
            },

            new TestCase("newInstance()") {
                public void doTest () {
                    BeanFactory factory = BeanFactory.getFactory(Canvas.class);
                    Object newInstance = factory.newInstance();

                    assertTrue(newInstance instanceof Canvas, "new instance should be a Canvas");

                    setResult();
                }
            },

            new TestCase("newInstance() for abstract class") {
                public void doTest () {
                    BeanFactory factory = BeanFactory.getFactory(BaseWidget.class);
                    Object newInstance = factory.newInstance();

                    assertNull(newInstance, "newInstance() for abstract classes should return null");

                    setResult();
                }
            },

            new TestCase("doSetProperty() with known property") {
                public void doTest () {
                    BeanFactory factory = BeanFactory.getFactory(CustomCanvas.class);
                    CustomCanvas canvas = new CustomCanvas();
                    factory.doSetProperty(canvas, "customProperty", "a value");

                    assertEqual(canvas.getCustomProperty(), "a value", "custom property should have been set");

                    setResult();
                }
            },

            new TestCase("doSetProperty() with known property in superclass") {
                public void doTest () {
                    BeanFactory factory = BeanFactory.getFactory(CustomCanvas.class);
                    CustomCanvas canvas = new CustomCanvas();
                    factory.doSetProperty(canvas, "width", 607);

                    assertEqual(canvas.getWidth(), 607, "width should have been set");

                    setResult();
                }
            },

            new TestCase("doSetProperty() with unknown property, before isCreated()") {
                public void doTest () {
                    BeanFactory factory = BeanFactory.getFactory(CustomCanvas.class);
                    CustomCanvas canvas = new CustomCanvas();
                    factory.doSetProperty(canvas, "uknownProperty", 27);

                    final JavaScriptObject jsObj = canvas.getOrCreateJsObj();
                    final int property = JSOHelper.getAttributeAsInt(jsObj, "uknownProperty");
                    assertEqual(property, 27, "Should set unkown property on creation");

                    setResult();
                }
            },

            new TestCase("doSetProperty() with unknown property, after isCreated()") {
                public void doTest () {
                    BeanFactory factory = BeanFactory.getFactory(CustomCanvas.class);
                    CustomCanvas canvas = new CustomCanvas();
                    JavaScriptObject jsObj = canvas.getOrCreateJsObj();
                    factory.doSetProperty(canvas, "uknownProperty", 27);

                    final int property = JSOHelper.getAttributeAsInt(jsObj, "uknownProperty");
                    assertEqual(property, 27, "Should set unkown property after creation");

                    setResult();
                }
            },

            new TestCase("getAttributes()") {
                public void doTest () {
                    BeanFactory factory = BeanFactory.getFactory(CustomCanvas.class);
                    String[] attributes = factory.getAttributes();

                    assertContains(attributes, "customProperty", "Should return attribute defined on class itself");
                    assertContains(attributes, "width", "Should return attribute defined on superclass");

                    setResult();
                }
            },

            new TestCase("doGetProperty() with known property") {
                public void doTest () {
                    BeanFactory factory = BeanFactory.getFactory(CustomCanvas.class);
                    CustomCanvas canvas = new CustomCanvas();
                    canvas.setCustomProperty("custom value");
                    Object property = factory.doGetProperty(canvas, "customProperty");

                    assertEqual(property, "custom value", "should get known property");

                    setResult();
                }
            },

            new TestCase("doGetProperty() with known property in superclass") {
                public void doTest () {
                    BeanFactory factory = BeanFactory.getFactory(CustomCanvas.class);
                    CustomCanvas canvas = new CustomCanvas();
                    canvas.setWidth(651);
                    Object property = factory.doGetProperty(canvas, "width");

                    assertEqual(property, 651, "should get known property");

                    setResult();
                }
            },

            new TestCase("doGetProperty() with unknown property (post-creation)") {
                public void doTest () {
                    BeanFactory factory = BeanFactory.getFactory(CustomCanvas.class);
                    CustomCanvas canvas = new CustomCanvas();
                    canvas.getOrCreateJsObj();
                    canvas.setProperty("unknownProperty", "custom value");
                    
                    Object property = factory.doGetProperty(canvas, "unknownProperty");
                    assertEqual(property, "custom value", "should get unknown property");

                    setResult();
                }
            },

            new TestCase("doGetProperty() with unknown property (pre-creation)") {
                public void doTest () {
                    BeanFactory factory = BeanFactory.getFactory(CustomCanvas.class);
                    CustomCanvas canvas = new CustomCanvas();
                    JavaScriptObject config = canvas.getConfig();
                    JSOHelper.setAttribute(config, "unknownProperty", "custom value");
                    
                    Object property = factory.doGetProperty(canvas, "unknownProperty");
                    assertEqual(property, "custom value", "should get unknown property");

                    setResult();
                }
            },

            new TestCase("doGetProperty() with unknown property (default)") {
                public void doTest () {
                    BeanFactory factory = BeanFactory.getFactory(CustomCanvas.class);
                    CustomCanvas canvas = new CustomCanvas();
                    
                    // This is a default for Canvas, but not doc'd, so not known to SmartGWT
                    Object property = factory.doGetProperty(canvas, "refreshVariable");
                    assertEqual(property, "refresh", "should get unknown property");

                    setResult();
                }
            },

            new TestCase("doGetProperty() with unset and unknown property") {
                public void doTest () {
                    BeanFactory factory = BeanFactory.getFactory(CustomCanvas.class);
                    CustomCanvas canvas = new CustomCanvas();
                    
                    Object property = factory.doGetProperty(canvas, "notAPropertyName");
                    assertNull(property, "should get null for unset property");

                    setResult();
                }
            } 
        );
    }
}
