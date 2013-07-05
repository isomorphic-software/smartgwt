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
 
/**
 */
public enum TextAreaWrap implements ValueEnum {
    /**
     * don't allow wrapping at all
     */
    OFF("off"),
    /**
     * when the entered text reaches the edge of the text area, wrap visibly but don't include line breaks in the textarea
     * value
     */
    SOFT("soft"),
    /**
     * when the entered text reaches the edge of the text area, insert a line break
     */
    HARD("hard");
    private String value;

    TextAreaWrap(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
