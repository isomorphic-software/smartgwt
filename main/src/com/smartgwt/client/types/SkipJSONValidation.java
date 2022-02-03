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
 */
public enum SkipJSONValidation implements ValueEnum {
    /**
     * Skip validation for all fields. In this mode, valueXPaths and getFieldValue implementations are skipped.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "full".
     */
    FULL("full"),
    /**
     * Skip validation for fields with boolean, numeric, or string-drived types. Note that you must deliver all  {@link
     * com.smartgwt.client.data.DataSourceField#getMultiple DataSourceField.multiple}:true values as arrays.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "partial".
     */
    PARTIAL("partial"),
    /**
     * Always do validation.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "none".
     */
    NONE("none");
    private String value;

    SkipJSONValidation(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
