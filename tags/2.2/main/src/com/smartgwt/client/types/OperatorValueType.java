/*
 * SmartGWT (GWT for SmartClient)
 * Copyright 2008 and beyond, Isomorphic Software, Inc.
 *
 * SmartGWT is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License version 3
 * as published by the Free Software Foundation.  SmartGWT is also
 * available under typical commercial license terms - see
 * http://smartclient.com/license
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 */

package com.smartgwt.client.types;

/**
 * Indicates the kind of value expected in a {@link com.smartgwt.client.data.Criterion} that uses this operator.
 */
public enum OperatorValueType implements ValueEnum {
    /**
     * {@link com.smartgwt.client.data.Criterion#setValue(Object) Criterion.value} should contain a value of the same type as the field.
     */
    FIELD_TYPE("fieldType"),
    /**
     * {@link com.smartgwt.client.data.Criterion#setValue() Criterion.value} should be the name of another field in the record
     */
    FIELD_NAME("fieldName"),

    /**
     * no {@link com.smartgwt.client.data.Criterion#setValue() Criterion.value} or other setting required (used for operators like isNull)
     */
    NONE("none"),

    /**
     * {@link com.smartgwt.client.data.Criterion#setCriteria() Criterion.criteria} should be an Array of criteria (used for logical operators like "and")
     */
    CRITERIA("criteria"),

    /**
     * {@link com.smartgwt.client.data.Criterion#setStart() Criterion.start} Criterion.start and {@link com.smartgwt.client.data.Criterion#setEnd() Criterion.end} should
     * contain start and end values, both of the same type as the field.
     */
    VALUE_RANGE("valueRange"),

    /**
     * {@link com.smartgwt.client.data.Criterion#setValue() Criterion.value} should contain an Array of valid field values.
     */
    VALUE_SET("valueSet"),

    /**
     * {@link com.smartgwt.client.data.Criterion#setValue() Criterion.value} should contain a value which is not necessarily the same type as the field (used for regexp and similar operators).
     * OperatorOperator.editorType can be specified as a FormItem to use to enter a value for the criterion.
     */
    CUSTOM("right");

    private String value;

    OperatorValueType(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
