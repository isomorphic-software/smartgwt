
/*
 * Isomorphic Smart GWT web presentation layer
 * Copyright 2000 and beyond Isomorphic Software, Inc.
 *
 * OWNERSHIP NOTICE
 * Isomorphic Software owns and reserves all rights not expressly granted in this source code,
 * including all intellectual property rights to the structure, sequence, and format of this code
 * and to all designs, interfaces, algorithms, schema, protocols, and inventions expressed herein.
 *
 *  If you have any questions, please email <sourcecode@isomorphic.com>.
 *
 *  This entire comment must accompany any portion of Isomorphic Software source code that is
 *  copied or moved from this file.
 */
/* sgwtgen */
package com.smartgwt.client.docs.serverds;

import com.smartgwt.client.types.*;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.docs.*;
import com.smartgwt.client.callbacks.*;
import com.smartgwt.client.widgets.form.fields.FormItem;
import java.util.List;
import java.util.Map;

/**
 * Specification of an operator for use in filtering, for example "equals".<p>
 * <b>This class is not meant to be created and used, it is actually documentation of settings
 * allowed in a DataSource descriptor (.ds.xml file), for use with Smart GWT Pro Edition and
 * above.
 * See {@link com.smartgwt.client.docs.serverds} for how to use this documentation.</b>
 * <p>
 * Use with {@link com.smartgwt.client.data.DataSource#addSearchOperator
 * DataSource.addSearchOperator()} to define custom filtering behaviors for client-side filtering.
 */
public class Operator {

    /**
     * The text use when using this operator as an  {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getAllowExpressions expression} in a FormItem.
     *
     * <p>Default value is null
     * @see com.smartgwt.client.docs.AdvancedFilter AdvancedFilter overview and related methods
     */
    public String symbol;

    /**
     * Whether this operator should be offered to users by default in interfaces such as the {@link
     * com.smartgwt.client.widgets.form.FilterBuilder}.   <P> Setting hidden:true means the operator
     * can be used in a programmatic search, for example, by calling {@link
     * com.smartgwt.client.data.ResultSet#setCriteria ResultSet.setCriteria()}, but does not appear in
     * the UI.
     *
     * <p>Default value is false
     * @see com.smartgwt.client.docs.AdvancedFilter AdvancedFilter overview and related methods
     */
    public boolean hidden;

    /**
     * List of types that this Operator is valid for. <P> If omitted, the operator is assumed to be
     * valid for all FieldTypes unless a list of  FieldTypes is passed to {@link
     * com.smartgwt.client.data.DataSource#addSearchOperator DataSource.addSearchOperator()}.
     *
     * <p>Default value is null
     * @see com.smartgwt.client.docs.AdvancedFilter AdvancedFilter overview and related methods
     */
    public FieldType[] fieldTypes;

    /**
     * Name of a property on the Operators class that provides the title for this operator.
     *
     * <p>Default value is null
     * @see com.smartgwt.client.docs.AdvancedFilter AdvancedFilter overview and related methods
     */
    public Identifier titleProperty;

    /**
     * Whether this operator needs to be executed on the server side. <P> This implies that if a
     * {@link com.smartgwt.client.docs.serverds.Criterion} using this operator is either introduced
     * into {@link com.smartgwt.client.docs.serverds.AdvancedCriteria criteria} or is changed, the
     * server will need to be contacted to perform filtering.
     *
     * <p>Default value is false
     * @see com.smartgwt.client.docs.AdvancedFilter AdvancedFilter overview and related methods
     */
    public boolean requiresServer;

    /**
     * Unique id for an operator, which appears within {@link
     * com.smartgwt.client.docs.serverds.AdvancedCriteria} as the {@link
     * com.smartgwt.client.docs.serverds.Operator} property. <P> A list of built-in identifiers is
     * {@link com.smartgwt.client.types.OperatorId here}.
     *
     * <p>Default value is null
     * @see com.smartgwt.client.docs.AdvancedFilter AdvancedFilter overview and related methods
     */
    public OperatorId ID;

    /**
     * User-visible title for this operator when used with text-based fields - eg,  "equals (match
     * case)" rather than just "equals". <P> To simplify internationalization by separating titles
     * from operator code, you can use specify {@link
     * com.smartgwt.client.docs.serverds.Operator#textTitleProperty textTitleProperty} instead of this
     * property.
     *
     * <p>Default value is null
     * @see com.smartgwt.client.docs.AdvancedFilter AdvancedFilter overview and related methods
     */
    public String textTitle;

    /**
     * User-visible title for this operator, such as "doesn't contain". <P> To simplify
     * internationalization by separating titles from operator code, you can use specify {@link
     * com.smartgwt.client.docs.serverds.Operator#titleProperty titleProperty} instead of this
     * property.
     *
     * <p>Default value is null
     * @see com.smartgwt.client.docs.AdvancedFilter AdvancedFilter overview and related methods
     */
    public String title;

    /**
     * Indicates the kind of value expected in a {@link com.smartgwt.client.docs.serverds.Criterion}
     * that uses this operator. {@link com.smartgwt.client.types.OperatorValueType} lists
     * possibilities. <P> The default of <code>null</code> is equivalent to "fieldType", indicating
     * that {@link com.smartgwt.client.docs.serverds.Criterion#value Criterion.value} is expected to
     * contain a value of the same type as the field indicated by {@link
     * com.smartgwt.client.docs.serverds.Criterion#fieldName Criterion.fieldName}.
     *
     * <p>Default value is null
     * @see com.smartgwt.client.docs.AdvancedFilter AdvancedFilter overview and related methods
     */
    public OperatorValueType valueType;

    /**
     * Name of a property on the Operators class that provides the title for this operator when used
     * with text-based fields.
     *
     * <p>Default value is null
     * @see com.smartgwt.client.docs.AdvancedFilter AdvancedFilter overview and related methods
     */
    public Identifier textTitleProperty;

    /**
     * For an operator with {@link com.smartgwt.client.docs.serverds.Operator#valueType
     * valueType}:"custom", indicates what kind of FormItem to use to provide a user interface for
     * creating a valid {@link com.smartgwt.client.docs.serverds.Criterion}.  The default of
     * <code>null</code> means an ordinary TextItem is fine.
     *
     * <p>Default value is null
     * @see com.smartgwt.client.docs.AdvancedFilter AdvancedFilter overview and related methods
     */
    public FormItem editorType;

}
