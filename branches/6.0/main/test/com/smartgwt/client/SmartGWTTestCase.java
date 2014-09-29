/*
 * SmartGWT (GWT for SmartClient)
 * Copyright 2008 and beyond, Isomorphic Software, Inc.
 *
 * SmartGWT is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License version 3
 * as published by the Free Software Foundation.  SmartGWT is also
 * available under typical commercial license terms - see
 * http://smartclient.com/license
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 */
package com.smartgwt.client;

import com.google.gwt.junit.client.GWTTestCase;
import com.smartgwt.client.widgets.form.fields.ButtonItem;

/**
 *
 */
public class SmartGWTTestCase extends GWTTestCase {

    /* (non-Javadoc)
     * @see com.google.gwt.junit.client.GWTTestCase#getModuleName()
     */
    @Override
    public String getModuleName() {
        return "com.smartgwt.SmartGwt";
    }
    
    @Override
    protected void gwtSetUp() throws Exception {
        new SmartGwtEntryPoint().onModuleLoad();
    }
    
    public native void clickButton(ButtonItem button) /*-{
        button.@com.smartgwt.client.widgets.form.fields.ButtonItem::getJsObj()().handleClick();
    }-*/;
}
