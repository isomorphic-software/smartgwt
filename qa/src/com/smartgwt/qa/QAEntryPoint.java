/*
 * Smart GWT (GWT for SmartClient)
 * Copyright 2008 and beyond, Isomorphic Software, Inc.
 *
 * Smart GWT is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License version 3
 * is published by the Free Software Foundation.  Smart GWT is also
 * available under typical commercial license terms - see
 * http://smartclient.com/license
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 */

package com.smartgwt.qa;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;

import com.smartgwt.client.bean.BeanFactory;
import com.smartgwt.client.widgets.Canvas;

import com.smartgwt.qa.reflection.widgets.MyListGrid;
import com.smartgwt.qa.reflection.widgets.MyVLayout;
import com.smartgwt.qa.reflection.widgets.CustomCanvas;
import com.smartgwt.qa.reflection.widgets.MySplitbar;
import com.smartgwt.qa.reflection.widgets.MySectionHeader;

import com.smartgwt.qa.TestRunner;

import java.util.Arrays;
import java.util.List;

// This is the entry point for the testing code that supports the SmartClient
// QA system.
//
// Some of the code is to support tests written in JavaScript in the usual
// SmartClient .test files.
//
// However, there are also Java test files in this package, which are written
// in terms of a Java wrapper for TestRunner. There is a generator which
// exports each TestRunner subclass (see below).  Thus, the SmartClient .test
// files can pick out a single set of Java tests to run.
public class QAEntryPoint implements EntryPoint {
    // These are needed for the Javascript reflection tests that don't call
    // into SmartGWT directly.
    interface MyMetaFactory extends BeanFactory.MetaFactory {
        BeanFactory<MyListGrid> getMyListGridFactory ();
        BeanFactory<MyVLayout> getMyVLayoutFactory ();
        BeanFactory<CustomCanvas> getCustomCanvasFactory ();
        BeanFactory<MySplitbar> getMySplitbarFactory ();
        BeanFactory<MySectionHeader> getMySetionHeaderFactory ();
        BeanFactory<Canvas> getCanvasFactory();
    }

    public void onModuleLoad() {
        // Create only needed factories, to save space.
        GWT.create(MyMetaFactory.class);
    
        // Or create all canvas factories
        // GWT.create(BeanFactory.CanvasMetaFactory.class);

        // We export the SmartGWT tests so that we call call individual tests
        // from the Javascript side. That way, we can compile all the tests in,
        // but choose which to actually run in the .test file.
        GWT.create(TestRunner.Export.class);

        // The permutation gets loaded asynchronously *after* page load, so we
        // need to kick off the actual tests from here -- we just wrap them in
        // a function at the native Smartclient end. This won't be an issue in
        // ordinary SmartGWT apps.
        runSmartclientTests();
    }

    public native void runSmartclientTests () /*-{
        if ($wnd.runSmartclientTests) $wnd.runSmartclientTests();
    }-*/;
}
