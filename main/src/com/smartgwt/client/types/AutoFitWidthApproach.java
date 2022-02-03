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
 * How should field width be determined when {@link com.smartgwt.client.widgets.grid.ListGridField#getAutoFitWidth
 * ListGridField.autoFitWidth} is true?
 */
public enum AutoFitWidthApproach implements ValueEnum {
    /**
     * Size field to fit to the data value(s) contained in the field.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "value".
     */
    VALUE("value"),
    /**
     * Size field to fit the field title
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "title".
     */
    TITLE("title"),
    /**
     * Size field to fit either the field title or the data values in the field (whichever requires more space).
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "both".
     */
    BOTH("both");
    private String value;

    AutoFitWidthApproach(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
