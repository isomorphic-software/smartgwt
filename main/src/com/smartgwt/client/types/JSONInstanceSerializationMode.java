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
 * Controls the output of the JSONEncoder when instances of Smart GWT classes (eg a ListGrid) are included in the data to
 * be serialized.
 */
public enum JSONInstanceSerializationMode implements ValueEnum {
    /**
     * instances will be shown as a specially formatted JSON listing the most relevant properties of the instance. Result is
     * not expected to decode()/eval() successfully if instances are included.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "long".
     */
    LONG("long"),
    /**
     * instances will be shown in a shorter format via a call to {@link com.smartgwt.client.util.isc#echoLeaf isc.echoLeaf()}.
     * Result is not expected to decode()/eval() successfully if instances are included.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "short".
     */
    SHORT("short"),
    /**
     * no output will be shown for instances (as though they were not present in the data). Result should decode()/eval()
     * successfully (depending on other settings)
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "skip".
     */
    SKIP("skip");
    private String value;

    JSONInstanceSerializationMode(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
