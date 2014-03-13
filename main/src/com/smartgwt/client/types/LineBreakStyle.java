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
 * The style of line-breaks to use when exporting data
 */
public enum LineBreakStyle implements ValueEnum {
    /**
     * Use the default line-break style of the server OS
     */
    DEFAULT("default"),
    /**
     * Use UNIX-style line-breaks (LF only)
     */
    UNIX("unix"),
    /**
     * Use MAC-style line-breaks (CR only)
     */
    MAC("mac"),
    /**
     * Use DOS-style line-breaks (both CR & LF)
     */
    DOS("dos");
    private String value;

    LineBreakStyle(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
