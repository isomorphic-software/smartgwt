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
 * Enum used within the {@link com.smartgwt.client.widgets.form.FilterBuilder} class to indicate the role of a particular 
 * value-field form item within a filter clause.
 */
public enum ValueItemType implements ValueEnum {
    /**
     * This is the single form item that will populate the generated {@link com.smartgwt.client.data.Criterion#getValue
     * Criterion.value} for this clause. This applies for operators with {@link com.smartgwt.client.data.Operator#getValueType
     * Operator.valueType} of <code>"fieldType"</code> or <code>"custom"</code>.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "value".
     */
    VALUE("value"),
    /**
     * This is the single form item that will populate the generated {@link com.smartgwt.client.data.Criterion#getValue
     * Criterion.value} for {@link com.smartgwt.client.data.Operator#getValueType Operator.valueType} of
     * <code>"fieldName"</code>.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "name".
     */
    NAME("name"),
    /**
     * Indicates this item will generate the lower-bound value (or "start") when generating criteria with {@link
     * com.smartgwt.client.data.Operator#getValueType Operator.valueType} <code>"valueRange"</code>.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "start".
     */
    START("start"),
    /**
     * Indicates this item will generate the higher-bound value (or "end") when generating criteria with {@link
     * com.smartgwt.client.data.Operator#getValueType Operator.valueType} <code>"valueRange"</code>.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "end".
     */
    END("end");
    private String value;

    ValueItemType(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
