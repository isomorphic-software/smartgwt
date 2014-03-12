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
 * The method of pooling to employ for {@link com.smartgwt.client.widgets.grid.ListGrid#getCanExpandRecords
 * expansionComponents}. <P>
 */
public enum ExpansionComponentPoolingMode implements ValueEnum {
    /**
     * auto-created, built-in components are destroyed when record are {@link
     * com.smartgwt.client.widgets.grid.ListGrid#collapseRecord collapsed}.
     */
    DESTROY("destroy"),
    /**
     * all expansion components are deparented from the grid when a record is {@link
     * com.smartgwt.client.widgets.grid.ListGrid#collapseRecord collapsed} but are not destroyed. It is the responsibility of
     * the developer to handle component destruction
     */
    NONE("none");
    private String value;

    ExpansionComponentPoolingMode(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
