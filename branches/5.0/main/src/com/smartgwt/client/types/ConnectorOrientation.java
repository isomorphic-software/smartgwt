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
 * Supported styles of connector orientations.
 */
public enum ConnectorOrientation implements ValueEnum {
    /**
     * Tail segments are always horizontal; best for left-to-right connectors
     */
    HORIZONTAL("horizontal"),
    /**
     * Tail segments are always vertical; best for top-to-bottom connectors
     */
    VERTICAL("vertical"),
    /**
     * Tail segments flip orientation according to longer axis of bounding box: if the bounding box is wider than it is tall,
     * center segment is vertical
     */
    AUTO("auto");
    private String value;

    ConnectorOrientation(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
