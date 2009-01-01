/*
 * Isomorphic SmartClient
 * Version 7.0beta3 (2008-12-31)
 * Copyright(c) 1998-2007 Isomorphic Software, Inc. All rights reserved.
 * "SmartClient" is a trademark of Isomorphic Software, Inc.
 *
 * licensing@smartclient.com
 *
 * http://smartclient.com/license
 */






//> @class Operators
// The Operators class provides a collection of class-level properties that can be used to
// modify the descriptions associated with the logical +link{operator}s used in 
// +link{AdvancedCriteria}. This is primarily intended for internationalization.
// <p>
// To add or override an operator's description, use
// Operators.+link{Class.addClassProperties,addClassProperties()}.  For example:
// <p>
// <code>Operators.addClassProperties({lessOrEqualTitle: "Less than or equal to"});</code>
// @treeLocation Client Reference/Data Binding/DataSource
// @visibility external
//<
isc.defineClass("Operators", "Class").addClassProperties({

    //> @classAttr Operators.equalsTitle (String : "equals" : IR)
    // Title for the "equals" operator
    // @group i18nMessages
    // @visibility external
    //<
    equalsTitle: "equals",

    //> @classAttr Operators.notEqualTitle (String : "not equal" : IR)
    // Title for the "notEqual" operator
    // @group i18nMessages
    // @visibility external
    //<
    notEqualTitle: "not equal",

    //> @classAttr Operators.greaterThanTitle (String : "greater than" : IR)
    // Title for the "greaterThan" operator
    // @group i18nMessages
    // @visibility external
    //<
    greaterThanTitle: "greater than",

    //> @classAttr Operators.lessThanTitle (String : "less than" : IR)
    // Title for the "lessThan" operator
    // @group i18nMessages
    // @visibility external
    //<
    lessThanTitle: "less than",

    //> @classAttr Operators.greaterOrEqualTitle (String : "greater than or equal to" : IR)
    // Title for the "greaterOrEqual" operator
    // @group i18nMessages
    // @visibility external
    //<
    greaterOrEqualTitle: "greater than or equal to",

    //> @classAttr Operators.lessOrEqualTitle (String : "less than or equal to" : IR)
    // Title for the "lessOrEqual" operator
    // @group i18nMessages
    // @visibility external
    //<
    lessOrEqualTitle: "less than or equal to",

    //> @classAttr Operators.betweenTitle (String : "between" : IR)
    // Title for the "between" operator
    // @group i18nMessages
    // @visibility external
    //<
    betweenTitle: "between",

    //> @classAttr Operators.betweenInclusiveTitle (String : "between (inclusive)" : IR)
    // Title for the "betweenInclusive" operator
    // @group i18nMessages
    // @visibility external
    //<
    betweenInclusiveTitle: "between (inclusive)",

    //> @classAttr Operators.iContainsTitle (String : "contains" : IR)
    // Title for the "iContains" operator
    // @group i18nMessages
    // @visibility external
    //<
    iContainsTitle: "contains",

    //> @classAttr Operators.iStartsWithTitle (String : "starts with" : IR)
    // Title for the "iStartsWith" operator
    // @group i18nMessages
    // @visibility external
    //<
    iStartsWithTitle: "starts with",

    //> @classAttr Operators.iEndsWithTitle (String : "ends with" : IR)
    // Title for the "iEndsWith" operator
    // @group i18nMessages
    // @visibility external
    //<
    iEndsWithTitle: "ends with",

    //> @classAttr Operators.containsTitle (String : "contains (match case)" : IR)
    // Title for the "contains" operator
    // @group i18nMessages
    // @visibility external
    //<
    containsTitle: "contains (match case)",

    //> @classAttr Operators.startsWithTitle (String : "starts with (match case)" : IR)
    // Title for the "startsWith" operator
    // @group i18nMessages
    // @visibility external
    //<
    startsWithTitle: "starts with (match case)",

    //> @classAttr Operators.endsWithTitle (String : "ends with (match case)" : IR)
    // Title for the "endsWith" operator
    // @group i18nMessages
    // @visibility external
    //<
    endsWithTitle: "ends with (match case)",

    //> @classAttr Operators.iNotContainsTitle (String : "does not contain" : IR)
    // Title for the "iNotContains" operator
    // @group i18nMessages
    // @visibility external
    //<
    iNotContainsTitle: "does not contain",

    //> @classAttr Operators.iNotStartsWithTitle (String : "does not start with" : IR)
    // Title for the "iNotStartsWith" operator
    // @group i18nMessages
    // @visibility external
    //<
    iNotStartsWithTitle: "does not start with",

    //> @classAttr Operators.iNotEndsWithTitle (String : "does not end with" : IR)
    // Title for the "iNotEndsWith" operator
    // @group i18nMessages
    // @visibility external
    //<
    iNotEndsWithTitle: "does not end with",

    //> @classAttr Operators.notContainsTitle (String : "does not contain (match case)" : IR)
    // Title for the "notContains" operator
    // @group i18nMessages
    // @visibility external
    //<
    notContainsTitle: "does not contain (match case)",

    //> @classAttr Operators.notStartsWithTitle (String : "does not start with (match case)" : IR)
    // Title for the "notStartsWith" operator
    // @group i18nMessages
    // @visibility external
    //<
    notStartsWithTitle: "does not start with (match case)",

    //> @classAttr Operators.notEndsWithTitle (String : "does not end with (match case)" : IR)
    // Title for the "notEndsWith" operator
    // @group i18nMessages
    // @visibility external
    //<
    notEndsWithTitle: "does not end with (match case)",

    //> @classAttr Operators.isNullTitle (String : "is null" : IR)
    // Title for the "isNull" operator
    // @group i18nMessages
    // @visibility external
    //<
    isNullTitle: "is null",

    //> @classAttr Operators.notNullTitle (String : "is not null" : IR)
    // Title for the "notNull" operator
    // @group i18nMessages
    // @visibility external
    //<
    notNullTitle: "not null",

    //> @classAttr Operators.regexpTitle (String : "matches expression (exact case)" : IR)
    // Title for the "regexp" operator
    // @group i18nMessages
    // @visibility external
    //<
    regexpTitle: "matches expression (exact case)",

    //> @classAttr Operators.iregexpTitle (String : "matches expression" : IR)
    // Title for the "iregexp" operator
    // @group i18nMessages
    // @visibility external
    //<
    iregexpTitle: "matches expression",

    //> @classAttr Operators.inSetTitle (String : "is one of" : IR)
    // Title for the "inSet" operator
    // @group i18nMessages
    // @visibility external
    //<
    inSetTitle: "is one of",

    //> @classAttr Operators.notInSetTitle (String : "is not one of" : IR)
    // Title for the "notInSet" operator
    // @group i18nMessages
    // @visibility external
    //<
    notInSetTitle: "is not one of",

    //> @classAttr Operators.equalsFieldTitle (String : "matches other field" : IR)
    // Title for the "equalsField" operator
    // @group i18nMessages
    // @visibility external
    //<
    equalsFieldTitle: "matches other field",

    //> @classAttr Operators.notEqualFieldTitle (String : "differs from field" : IR)
    // Title for the "notEqualField" operator
    // @group i18nMessages
    // @visibility external
    //<
    notEqualFieldTitle: "differs from field",

    //> @classAttr Operators.andTitle (String : "Match All" : IR)
    // Title for the "and" operator
    // @group i18nMessages
    // @visibility external
    //<
    andTitle: "Match All",

    //> @classAttr Operators.notTitle (String : "Match None" : IR)
    // Title for the "not" operator
    // @group i18nMessages
    // @visibility external
    //<
    notTitle: "Match None",

    //> @classAttr Operators.orTitle (String : "Match Any" : IR)
    // Title for the "or" operator
    // @group i18nMessages
    // @visibility external
    //<
    orTitle: "Match Any"
    
});
