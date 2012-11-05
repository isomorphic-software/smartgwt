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

import com.smartgwt.qa.reflection.widgets.CustomCanvas;

// Tests some things that BeanProperty should be taking care of.
public class BeanPropertyTest extends TestRunner {
    static interface MyBeanFactories extends BeanFactory.MetaFactory {
        BeanFactory<CustomCanvas> getCustomCanvasFactory();
    }
        
    static {
        // Actually generates the factories. We do it here as an example ...
        // you could create all of them in code that initializes the
        // application, rather than near the point of use like this. It
        // would be slightly more efficient to create them all at once.
        GWT.create(MyBeanFactories.class);
    }

    public BeanPropertyTest () {
        super(
            new TestCase("getProperty return main property, if choice") {
                public void doTest () {
                    CustomCanvas canvas = new CustomCanvas();
                    Object property = BeanFactory.getProperty(canvas, "testProperty");

                    assertEqual(property, 7, "should return int version as main property");

                    setResult();
                }
            },

            new TestCase("getPropertyAsString prefers String versions of getter") {
                public void doTest () {
                    CustomCanvas canvas = new CustomCanvas();
                    Object property = BeanFactory.getPropertyAsString(canvas, "testProperty");

                    assertEqual(property, "Seven", "should prefer string version");

                    setResult();
                }
            },

            new TestCase("getPropertyAsString converts to String if no string getter") {
                public void doTest () {
                    CustomCanvas canvas = new CustomCanvas();
                    Object property = BeanFactory.getPropertyAsString(canvas, "anotherProperty");

                    assertEqual(property, "14", "should convert to string");

                    setResult();
                }
            },

            new TestCase("setProperty prefers int setter with int") {
                public void doTest () {
                    CustomCanvas canvas = new CustomCanvas();
                    BeanFactory.setProperty(canvas, "setterTest", 7);
                    String property = canvas.getSetterTest();
                        
                    assertEqual(property, "int 7", "should prefer int setter");

                    setResult();
                } 
            },

            new TestCase("setProperty prefers String setter with String") {
                public void doTest () {
                    CustomCanvas canvas = new CustomCanvas();
                    BeanFactory.setProperty(canvas, "setterTest", "seven");
                    String property = canvas.getSetterTest();
                        
                    assertEqual(property, "String seven", "should prefer int setter");

                    setResult();
                } 
            },

            new TestCase("setProperty can convert floats to ints") {
                public void doTest () {
                    CustomCanvas canvas = new CustomCanvas();
                    BeanFactory.setProperty(canvas, "setterTest", (float) 2.1);
                    String property = canvas.getSetterTest();
                        
                    assertEqual(property, "int 2", "should convert float to int");

                    setResult();
                } 
            }
        );
    }
}
