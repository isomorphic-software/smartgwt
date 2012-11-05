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
 
package com.smartgwt.qa;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.BaseWidget;
import com.smartgwt.client.util.JSOHelper;

import com.smartgwt.qa.TestCase;

// A class that wraps isc.TestRunner, so that it is possible to write tests in
// Java but have them integrate with the SmartClient QA framework. 
//
// See the test files for examples of usage.
public abstract class TestRunner extends Canvas {
    // This is a marker interface ... if you GWT.create() it (as QAEntryPoint
    // does), then a generator will find all the TestRunner subclasses in the
    // class path, and export them so that they can be called from JavaScript
    // test files.
    //
    // So, if you call ...
    //
    // GWT.create(TestRunner.Export.class);
    //
    // ... (as QAEntryPoint does) then after that you can call ...
    //
    // isc.com.smartgwt.qa.reflection.ConversionTest.create();
    //
    // ... to run the tests from the SmartClient side (where
    // "com.smartgwt.qa.reflection.ConversionTest" is the fully-qualified name
    // of the TestRunner subclass).
    public static interface Export {

    }

    public TestRunner () {
        scClassName = "TestRunner";
        
        // Need to do this early, due to autorun ... it's too late once create is called
        exportSetupAndTearDown();
    }

    // This would be the typical constructor for a subclass to invoke, given autorun.
    // Could provide the option to turn autorun off. See the reflection examples
    // for usage.
    public TestRunner (TestCase... tests) {
        this();
        setTests(tests);
    }

    private native void exportSetupAndTearDown () /*-{
        var config = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        
        config.setup = $entry(function () {
            var jObj = this.__ref;
            jObj.@com.smartgwt.qa.TestRunner::setup()();
        });

        config.tearDown = $entry(function () {
            var jObj = this.__ref;
            jObj.@com.smartgwt.qa.TestRunner::tearDown()();
        });
    }-*/;

    public TestRunner (JavaScriptObject jsObj) {
        super(jsObj);
    }
    
    // Called once before each TestCase is run ... subclasses may implement
    public void setup () {};
    
    // Called once after each TestCase is run ... subclasses may implement
    public void tearDown () {};

    // For the moment, you actually need to put the tests in the constructor,
    // given autorun is on by default and I haven't provided a way to turn it
    // off from here yet. 
    public void setTests (TestCase... tests) {
        JavaScriptObject[] jsTests = new JavaScriptObject[tests.length];
        for (int i = 0; i < tests.length; i++) {
            jsTests[i] = tests[i].getJsObj();        
        }
        setAttribute("tests", jsTests, true);
    }
}
