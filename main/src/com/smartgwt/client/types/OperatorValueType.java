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
 * Indicates the kind of value expected in a {@link com.smartgwt.client.data.Criterion} that uses this operator.
 */
public enum OperatorValueType implements ValueEnum {
    /**
     * {@link com.smartgwt.client.data.Criterion#getValue Criterion.value} should contain a value of the same type as the
     * field.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "fieldType".
     */
    FIELD_TYPE("fieldType"),
    /**
     * {@link com.smartgwt.client.data.Criterion#getValue Criterion.value} should be the name of another field in the record
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "fieldName".
     */
    FIELD_NAME("fieldName"),
    /**
     * no criterion.value or other setting required (used for operators like isBlank or isNull).
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "none".
     */
    NONE("none"),
    /**
     * {@link com.smartgwt.client.data.Criterion#getCriteria Criterion.criteria} should be an Array of criteria (used for
     * logical operators like "and").
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "criteria".
     */
    CRITERIA("criteria"),
    /**
     * {@link com.smartgwt.client.data.Criterion#getStart Criterion.start} and {@link com.smartgwt.client.data.Criterion#getEnd
     * Criterion.end} should contain start and end values, both of the same type as the field.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "valueRange".
     */
    VALUE_RANGE("valueRange"),
    /**
     * {@link com.smartgwt.client.data.Criterion#getValue Criterion.value} should contain an Array of valid field values.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "valueSet".
     */
    VALUE_SET("valueSet"),
    /**
     * {@link com.smartgwt.client.data.Criterion#getValue Criterion.value} should contain a value which is not necessarily the
     * same type as the field (used for regexp and similar operators).  {@link com.smartgwt.client.data.Operator#getEditorType
     * Operator.editorType} can be specified as a FormItem to use to enter a value for the criterion.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "custom".
     */
    CUSTOM("custom");
    private String value;

    OperatorValueType(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
