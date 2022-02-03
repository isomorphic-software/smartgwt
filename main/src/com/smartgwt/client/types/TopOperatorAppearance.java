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
 * Interface to use for showing and editing the {@link com.smartgwt.client.widgets.form.FilterBuilder#getTopOperator
 * top-level operator}  of a FilterBuilder.
 */
public enum TopOperatorAppearance implements ValueEnum {
    /**
     * radio buttons appear at the top of the form
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "radio".
     */
    RADIO("radio"),
    /**
     * a SelectItem appears with a "bracket" spanning all top-level clauses, exactly the same appearance used for showing
     * {@link com.smartgwt.client.widgets.form.FilterBuilder#getShowSubClauseButton subClauses}, if enabled.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "bracket".
     */
    BRACKET("bracket"),
    /**
     * each line in the FilterBuilder is a top-level item, with a SelectItem shown on the left that allows the user to choose
     * between the main operator in force (either "and" or "or", depending on the setting of topOperator) and "and not".
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "inline".
     */
    INLINE("inline"),
    /**
     * no interface is shown. The top-level operator is expected to be shown to the user outside the FilterBuilder, and, if
     * editable, {@link com.smartgwt.client.widgets.form.FilterBuilder#setTopOperator FilterBuilder.setTopOperator()} should be
     * called to update it
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "none".
     */
    NONE("none");
    private String value;

    TopOperatorAppearance(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
