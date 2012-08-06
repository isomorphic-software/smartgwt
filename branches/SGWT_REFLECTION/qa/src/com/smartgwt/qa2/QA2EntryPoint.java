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

package com.smartgwt.qa2;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;

import com.smartgwt.client.bean.BeanFactory;

import com.smartgwt.qa2.reflection.widgets.OtherCanvas;

// This is the entry point for a second module, for cases where we want to test
// loading two SmartGWT modules. The loading of the module is done by the
// SmartClient .test file.
public class QA2EntryPoint implements EntryPoint {
    interface MyMetaFactory extends BeanFactory.MetaFactory {
        BeanFactory<OtherCanvas> getOtherCanvasFactory();
    }

    public void onModuleLoad() {
        GWT.create(MyMetaFactory.class);

        // The permutation gets loaded asynchronously *after* page load, so we need to
        // kick off the actual tests from here -- we just wrap them in a function
        // at the native Smartclient end. This won't be an issue in ordinary SmartGWT apps.
        this.runSmartclientTests();
    }

    public native void runSmartclientTests()/*-{
        if ($wnd.runSmartclientTests) $wnd.runSmartclientTests();
    }-*/;
}
