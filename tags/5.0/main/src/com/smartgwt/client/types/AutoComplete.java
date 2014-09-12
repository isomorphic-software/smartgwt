package com.smartgwt.client.types;


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
/* sgwtgen */
 
/**
 * AutoComplete behavior for {@link com.smartgwt.client.widgets.form.fields.FormItem FormItems}.
 */
public enum AutoComplete implements ValueEnum {
    /**
     * Disable browser autoComplete. Note that some browsers will disregard this setting and still perform native autoComplete
     * for certain items - typically only for log in / password forms. See the discussion {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getAutoComplete here}.
     */
    NONE("none"),
    /**
     * Allow native browser autoComplete.
     */
    NATIVE("native");
    private String value;

    AutoComplete(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
