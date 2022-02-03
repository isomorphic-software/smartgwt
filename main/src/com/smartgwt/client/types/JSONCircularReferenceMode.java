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
 * What the {@link com.smartgwt.client.util.JSONEncoder} should do when it encounters a circular reference in an object
 * structure.
 */
public enum JSONCircularReferenceMode implements ValueEnum {
    /**
     * circular references in Arrays will be represented as a null entry, and objects will have a property with a null value
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "omit".
     */
    OMIT("omit"),
    /**
     * leave a string marker, the {@link com.smartgwt.client.util.JSONEncoder#getCircularReferenceMarker
     * JSONEncoder.circularReferenceMarker}, wherever a circular reference is found
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "marker".
     */
    MARKER("marker"),
    /**
     * leave a string marker <i>followed by</i> the path to the first occurrence of the circular reference from the top of the
     * object tree that was serialized. This potentially allows the original object graph to be reconstructed.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "path".
     */
    PATH("path");
    private String value;

    JSONCircularReferenceMode(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
