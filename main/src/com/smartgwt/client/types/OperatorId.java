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
 * An operator is used as part of a {@link com.smartgwt.client.data.Criterion} when specifying {@link
 * com.smartgwt.client.data.AdvancedCriteria}. <P> This list of operators indicates the set of operators built into Smart
 * GWT DataSources, which can be used for both client and server-side filtering.   You can extend the list of operators
 * with {@link com.smartgwt.client.data.DataSource#addSearchOperator DataSource.addSearchOperator()}.
 */
public enum OperatorId implements ValueEnum {
    /**
     * exactly equal to
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "equals".
     */
    EQUALS("equals"),
    /**
     * not equal to
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "notEqual".
     */
    NOT_EQUAL("notEqual"),
    /**
     * exactly equal to, if case is disregarded
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "iEquals".
     */
    IEQUALS("iEquals"),
    /**
     * not equal to, if case is disregarded
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "iNotEqual".
     */
    INOT_EQUAL("iNotEqual"),
    /**
     * Greater than
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "greaterThan".
     */
    GREATER_THAN("greaterThan"),
    /**
     * Less than
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "lessThan".
     */
    LESS_THAN("lessThan"),
    /**
     * Greater than or equal to
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "greaterOrEqual".
     */
    GREATER_OR_EQUAL("greaterOrEqual"),
    /**
     * Less than or equal to
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "lessOrEqual".
     */
    LESS_OR_EQUAL("lessOrEqual"),
    /**
     * Contains as sub-string (match case)
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "contains".
     */
    CONTAINS("contains"),
    /**
     * Starts with (match case)
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "startsWith".
     */
    STARTS_WITH("startsWith"),
    /**
     * Ends with (match case)
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "endsWith".
     */
    ENDS_WITH("endsWith"),
    /**
     * Contains as sub-string (case insensitive)
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "iContains".
     */
    ICONTAINS("iContains"),
    /**
     * Starts with (case insensitive)
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "iStartsWith".
     */
    ISTARTS_WITH("iStartsWith"),
    /**
     * Ends with (case insensitive)
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "iEndsWith".
     */
    IENDS_WITH("iEndsWith"),
    /**
     * Does not contain as sub-string (match case)
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "notContains".
     */
    NOT_CONTAINS("notContains"),
    /**
     * Does not start with (match case)
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "notStartsWith".
     */
    NOT_STARTS_WITH("notStartsWith"),
    /**
     * Does not end with (match case)
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "notEndsWith".
     */
    NOT_ENDS_WITH("notEndsWith"),
    /**
     * Does not contain as sub-string (case insensitive)
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "iNotContains".
     */
    INOT_CONTAINS("iNotContains"),
    /**
     * Does not start with (case insensitive)
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "iNotStartsWith".
     */
    INOT_STARTS_WITH("iNotStartsWith"),
    /**
     * Does not end with (case insensitive)
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "iNotEndsWith".
     */
    INOT_ENDS_WITH("iNotEndsWith"),
    /**
     * shortcut for "greaterThan" + "and" + "lessThan" (case insensitive)
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "iBetween".
     */
    IBETWEEN("iBetween"),
    /**
     * shortcut for "greaterOrEqual" + "and" + "lessOrEqual" (case insensitive)
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "iBetweenInclusive".
     */
    IBETWEEN_INCLUSIVE("iBetweenInclusive"),
    /**
     * Basic GLOB matching using wildcards (see {@link com.smartgwt.client.data.DataSource#getTranslatePatternOperators
     * DataSource.translatePatternOperators} for more information on available patterns)
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "matchesPattern".
     */
    MATCHES_PATTERN("matchesPattern"),
    /**
     * Basic GLOB matching using wildcards (case insensitive) (see {@link
     * com.smartgwt.client.data.DataSource#getTranslatePatternOperators DataSource.translatePatternOperators} for more
     * information on available patterns)
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "iMatchesPattern".
     */
    IMATCHES_PATTERN("iMatchesPattern"),
    /**
     * GLOB matching using wildcards. Value is considered to meet the criterion if it contains the pattern. See {@link
     * com.smartgwt.client.data.DataSource#getTranslatePatternOperators DataSource.translatePatternOperators} for more
     * information on available patterns)
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "containsPattern".
     */
    CONTAINS_PATTERN("containsPattern"),
    /**
     * GLOB mathcing using wildcards. Value is considered to meet the criterion if it starts with the pattern.See {@link
     * com.smartgwt.client.data.DataSource#getTranslatePatternOperators DataSource.translatePatternOperators} for more
     * information on available patterns)
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "startsWithPattern".
     */
    STARTS_WITH_PATTERN("startsWithPattern"),
    /**
     * GLOB mathcing using wildcards. Value is considered to meet the criterion if it starts with the pattern.See {@link
     * com.smartgwt.client.data.DataSource#getTranslatePatternOperators DataSource.translatePatternOperators} for more
     * information on available patterns)
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "endsWithPattern".
     */
    ENDS_WITH_PATTERN("endsWithPattern"),
    /**
     * GLOB matching using wildcards. Value is considered to meet the criterion if it contains the pattern. Matching is case
     * insensitive. See {@link com.smartgwt.client.data.DataSource#getTranslatePatternOperators
     * DataSource.translatePatternOperators} for more information on available patterns)
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "iContainsPattern".
     */
    ICONTAINS_PATTERN("iContainsPattern"),
    /**
     * GLOB matching using wildcards. Value is considered to meet the criterion if it starts with the pattern. Matching is case
     * insensitive.See  {@link com.smartgwt.client.data.DataSource#getTranslatePatternOperators
     * DataSource.translatePatternOperators} for more information on available patterns)
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "iStartsWithPattern".
     */
    ISTARTS_WITH_PATTERN("iStartsWithPattern"),
    /**
     * GLOB matching using wildcards.Value is considered to meet the criterion if it ends with the pattern. Matching is case
     * insensitive. See  {@link com.smartgwt.client.data.DataSource#getTranslatePatternOperators
     * DataSource.translatePatternOperators} for more information on available patterns)
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "iEndsWithPattern".
     */
    IENDS_WITH_PATTERN("iEndsWithPattern"),
    /**
     * Regular expression match
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "regexp".
     */
    REGEXP("regexp"),
    /**
     * Regular expression match (case insensitive)
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "iregexp".
     */
    IREGEXP("iregexp"),
    /**
     * value is either null or the empty string. For numeric fields it behaves as isNull
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "isBlank".
     */
    IS_BLANK("isBlank"),
    /**
     * value is neither null nor the empty string ("")
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "notBlank".
     */
    NOT_BLANK("notBlank"),
    /**
     * value is null
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "isNull".
     */
    IS_NULL("isNull"),
    /**
     * value is non-null. Note empty string ("") is non-null
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "notNull".
     */
    NOT_NULL("notNull"),
    /**
     * value is in a set of values. Specify criterion.value as an Array
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "inSet".
     */
    IN_SET("inSet"),
    /**
     * value is not in a set of values. Specify criterion.value as an Array
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "notInSet".
     */
    NOT_IN_SET("notInSet"),
    /**
     * matches another field (match case, specify fieldName as criterion.value)
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "equalsField".
     */
    EQUALS_FIELD("equalsField"),
    /**
     * does not match another field (match case, specify fieldName as criterion.value)
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "notEqualField".
     */
    NOT_EQUAL_FIELD("notEqualField"),
    /**
     * matches another field (case insensitive, specify fieldName as criterion.value)
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "iEqualsField".
     */
    IEQUALS_FIELD("iEqualsField"),
    /**
     * does not match another field (case insensitive, specify fieldName as criterion.value)
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "iNotEqualField".
     */
    INOT_EQUAL_FIELD("iNotEqualField"),
    /**
     * Greater than another field (specify fieldName as criterion.value)
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "greaterThanField".
     */
    GREATER_THAN_FIELD("greaterThanField"),
    /**
     * Less than another field (specify fieldName as criterion.value)
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "lessThanField".
     */
    LESS_THAN_FIELD("lessThanField"),
    /**
     * Greater than or equal to another field (specify fieldName as criterion.value)
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "greaterOrEqualField".
     */
    GREATER_OR_EQUAL_FIELD("greaterOrEqualField"),
    /**
     * Less than or equal to another field (specify fieldName as criterion.value)
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "lessOrEqualField".
     */
    LESS_OR_EQUAL_FIELD("lessOrEqualField"),
    /**
     * Contains as sub-string (match case) another field value (specify fieldName as criterion.value)
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "containsField".
     */
    CONTAINS_FIELD("containsField"),
    /**
     * Starts with (match case) another field value (specify fieldName as criterion.value)
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "startsWithField".
     */
    STARTS_WITH_FIELD("startsWithField"),
    /**
     * Ends with (match case) another field value (specify fieldName as criterion.value)
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "endsWithField".
     */
    ENDS_WITH_FIELD("endsWithField"),
    /**
     * Contains as sub-string (case insensitive) another field value (specify fieldName as criterion.value)
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "iContainsField".
     */
    ICONTAINS_FIELD("iContainsField"),
    /**
     * Starts with (case insensitive) another field value (specify fieldName as criterion.value)
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "iStartsWithField".
     */
    ISTARTS_WITH_FIELD("iStartsWithField"),
    /**
     * Ends with (case insensitive) another field value (specify fieldName as criterion.value)
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "iEndsWithField".
     */
    IENDS_WITH_FIELD("iEndsWithField"),
    /**
     * Does not contain as sub-string (match case) another field value (specify fieldName as criterion.value)
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "notContainsField".
     */
    NOT_CONTAINS_FIELD("notContainsField"),
    /**
     * Does not start with (match case) another field value (specify fieldName as criterion.value)
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "notStartsWithField".
     */
    NOT_STARTS_WITH_FIELD("notStartsWithField"),
    /**
     * Does not end with (match case) another field value (specify fieldName as criterion.value)
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "notEndsWithField".
     */
    NOT_ENDS_WITH_FIELD("notEndsWithField"),
    /**
     * Does not contain as sub-string (case insensitive) another field value (specify fieldName as criterion.value)
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "iNotContainsField".
     */
    INOT_CONTAINS_FIELD("iNotContainsField"),
    /**
     * Does not start with (case insensitive) another field value (specify fieldName as criterion.value)
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "iNotStartsWithField".
     */
    INOT_STARTS_WITH_FIELD("iNotStartsWithField"),
    /**
     * Does not end with (case insensitive) another field value (specify fieldName as criterion.value)
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "iNotEndsWithField".
     */
    INOT_ENDS_WITH_FIELD("iNotEndsWithField"),
    /**
     * all subcriteria (criterion.criteria) are true
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "and".
     */
    AND("and"),
    /**
     * all subcriteria (criterion.criteria) are false
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "not".
     */
    NOT("not"),
    /**
     * at least one subcriteria (criterion.criteria) is true
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "or".
     */
    OR("or"),
    /**
     * shortcut for "greaterThan" + "lessThan" + "and". Specify criterion.start and criterion.end
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "between".
     */
    BETWEEN("between"),
    /**
     * shortcut for "greaterOrEqual" + "lessOrEqual" + "and". Specify criterion.start and criterion.end
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "betweenInclusive".
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
