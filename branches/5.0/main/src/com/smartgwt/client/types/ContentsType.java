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
 * What type of content is found at the {@link com.smartgwt.client.widgets.HTMLFlow}'s {@link
 * com.smartgwt.client.widgets.HTMLFlow#getContentsURL contentsURL}?
 */
public enum ContentsType implements ValueEnum {
    /**
     * the <code>contentsURL</code> is assumed to be a standalone HTML page, and is loaded in an IFRAME.
     */
    PAGE("page"),
    /**
     * the default setting - indicates that HTML loaded from the <code>contentsURL</code> is assumed to be an HTML fragment
     * rather than a complete page.
     */
    FRAGMENT("fragment");
    private String value;

    ContentsType(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
