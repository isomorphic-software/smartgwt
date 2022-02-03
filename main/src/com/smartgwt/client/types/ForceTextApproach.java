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
 * Approach to force a text value to be interpreted as text rather than parsed as a date, time or other structured types,
 * as can happen with Microsoft Excel.  For background information, see {@link com.smartgwt.client.docs.ExcelPasting}.
 */
public enum ForceTextApproach implements ValueEnum {
    /**
     * a leading space character is added
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "leadingSpace".
     */
    LEADINGSPACE("leadingSpace"),
    /**
     * text value is turned into a trivial Excel formula (eg "car" becomes ="car"). In Excel, this renders just the value "car"
     * but editing the cell reveals the formula.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "formula".
     */
    FORMULA("formula");
    private String value;

    ForceTextApproach(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
