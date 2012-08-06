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
 
package com.smartgwt.qa.reflection.widgets;

import com.smartgwt.client.widgets.Canvas;
import java.util.Map;
import java.util.HashMap;

// Sample Canvas subclass for tests.
public class CustomCanvas extends Canvas {
    private String customProperty;
    private String setterTest;

    public String getSetterTest () {
        return setterTest;
    }

    public void setSetterTest (String value) {
        setterTest = "String " + value;
    }

    public void setSetterTest (int value) {
        setterTest = "int " + String.valueOf(value);
    }

    public String getCustomProperty () {
        return customProperty;
    }

    public void setCustomProperty (String newValue) {
        customProperty = newValue;
    }

    public int getTestProperty () {
        return 7;
    }

    public String getTestPropertyAsString () {
        return "Seven";
    }

    public int getAnotherProperty () {
        return 14;
    }

    // This is just here to make sure that the generator will generate
    // a BeanValueType for Map.
    public Map getMapProperty () {
        return new HashMap();
    }
}
