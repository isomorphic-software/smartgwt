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


public enum OperatorId implements ValueEnum {
    /**
     * exactly equal to
     */
    EQUALS("equals"),

    /**
     * not equal to
     */
    NOT_EQUAL("notEqual"),
    /**
     * Greater than
     */
    GREATER_THAN("greaterThan"),
    /**
     * Less than
     */
    LESS_THAN("lessThan"),
    /**
     * Greater than or equal to
     */
    GREATER_OR_EQUAL("greaterOrEqual"),
    /**
     * Less than or equal to
     */
    LESS_OR_EQUAL("lessOrEqual"),
    /**
     * Contains as sub-string (match case)
     */
    CONTAINS("contains"),
    /**
     * Starts with (match case)
     */
    STARTS_WITH("startsWith"),
    /**
     * Ends with (match case)
     */
    ENDS_WITH("endsWith"),
    /**
     * Contains as sub-string (case insensitive)
     */
    ICONTAINS("iContains"),

    /**
     * Starts with (case insensitive)
     */
    ISTARTS_WITH("iStartsWith"),
    /**
     * Ends with (case insensitive)
     */
    IENDS_WITH("iEndsWith"),
    /**
     * Does not contain as sub-string (match case)
     */
    NOT_CONTAINS("notContains"),
    /**
     * Does not start with (match case)
     */
    NOT_STARTS_WITH("notStartsWith"),
    /**
     * Does not end with (match case)
     */
    NOT_ENDS_WITH("notEndsWith"),
    /**
     * Does not contain as sub-string (case insensitive)
     */
    INOT_CONTAINS("iNotContains"),
    /**
     * Does not start with (case insensitive)
     */
    INOT_STARTS_WITH("iNotStartsWith"),
    /**
     * Does not end with (case insensitive)
     */
    INOT_ENDS_WITH("iNotEndsWith"),
    /**
     * Regular expression match
     */
    REGEXP("regexp"),
    /**
     * Regular expression match (case insensitive)
     */
    IREGEXP("iregexp"),
    /**
     * value is null
     */
    IS_NULL("isNull"),
    /**
     * value is non-null. Note empty string ("") is non-null
     */
    NOT_NULL("notNull"),
    /**
     * value is in a set of values. Specify criterion.value as an Array
     */
    IN_SET("inSet"),
    /**
     * value is not in a set of values. Specify criterion.value as an Array
     */
    NOT_IN_SET("notInSet"),
    /**
     * matches another field (specify fieldName as criterion.value)
     */
    EQUALS_FIELD("equalsField"),
    /**
     * does not match another field (specified fieldName as criterion.value)
     */
    NOT_EQUAL_FIELD("notEqualField"),
    /**
     * all subcriteria (criterion.criteria) are true
     */
    AND("and"),
    /**
     * all subcriteria (criterion.criteria) are false
     */
    NOT("not"),
    /**
     * at least one subcriteria (criterion.criteria) is true
     */
    OR("or"),
    /**
     * shortcut for "greaterThan" + "lessThan" + "and". Specify criterion.start and criterion.end
     */
    BETWEEN("between"),

    /**
     * shortcut for "greaterOrEqual" + "lessOrEqual" + "and". Specify criterion.start and criterion.end
     */
    BETWEEN_INCLUSIVE("betweenInclusive");

    private String value;

    OperatorId(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
