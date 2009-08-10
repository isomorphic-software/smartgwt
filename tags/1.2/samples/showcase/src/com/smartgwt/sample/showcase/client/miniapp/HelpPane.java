/*
 * SmartGWT (GWT for SmartClient)
 * Copyright 2008 and beyond, Isomorphic Software, Inc.
 *
 * SmartGWT is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License version 3
 * as published by the Free Software Foundation.  SmartGWT is also
 * available under typical commercial license terms - see
 * http://smartclient.com/license
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 */

package com.smartgwt.sample.showcase.client.miniapp;

import com.smartgwt.client.widgets.HTMLPane;
import com.smartgwt.client.types.Overflow;

public class HelpPane extends HTMLPane {
    public HelpPane() {
        setContentsURL("data/miniapp/demoApp_helpText.html");
        setOverflow(Overflow.AUTO);
        setStyleName("defaultBorder");
        setPadding(10);
    }
}