
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
 * An object representing a criterion to apply to a record.<p>
 * <b>This class is not meant to be created and used, it is actually documentation of settings
 * allowed in a DataSource descriptor (.ds.xml file), for use with Smart GWT Pro Edition and
 * above.
 * See {@link com.smartgwt.client.docs.serverds} for how to use this documentation.</b>
 * <p>
 * <P> A criterion is part of the definition of an {@link
 * com.smartgwt.client.docs.serverds.AdvancedCriteria} object, which is used to filter records
 * according to search criteria.  <P> A criterion consists of an {@link
 * com.smartgwt.client.docs.serverds.Criterion#operator operator} and typically a {@link
 * com.smartgwt.client.docs.serverds.DataSourceField#name fieldName} from a {@link
 * com.smartgwt.client.data.Record} and a {@link com.smartgwt.client.docs.serverds.Criterion#value
 * value} to compare to.  However some operators either don't require a value (eg, isNull) or act
 * on other criteria rather than directly on a {@link com.smartgwt.client.data.Record}'s fields
 * (eg, the "and" and "or" logical operators). <P> A shortcut form is also allowed where only
 * <code>fieldName</code> and <code>value</code> values are provided. In this case the
 * <code>operator</code> is assumed to be "equals".
 */
public class Criterion {

    /**
     * Operator this criterion applies.
     *
     * <p>Default value is null
     * @see com.smartgwt.client.docs.AdvancedFilter AdvancedFilter overview and related methods
     */
    public OperatorId operator;

    /**
     * Name of the field in each {@link com.smartgwt.client.data.Record} that this criterion applies
     * to.  Not applicable for a criterion with {@link
     * com.smartgwt.client.docs.serverds.Criterion#criteria sub-criteria}. Can be specified as a
     * dataPath to  allow matching nested objects. Use '/' as delimiters for dataPath. See  {@link
     * com.smartgwt.client.docs.DataPath dataPath} for more information.
     *
     * <p>Default value is null
     * @see com.smartgwt.client.docs.AdvancedFilter AdvancedFilter overview and related methods
     */
    public String fieldName;

    /**
     * End value of a criterion with an operator of type <code>"valueRange"</code>.
     *
     * <p>Default value is null
     * @see com.smartgwt.client.docs.AdvancedFilter AdvancedFilter overview and related methods
     */
    public Object end;

    /**
     * Start value of a criterion with an operator of type <code>"valueRange"</code>.
     *
     * <p>Default value is null
     * @see com.smartgwt.client.docs.AdvancedFilter AdvancedFilter overview and related methods
     */
    public Object start;

    /**
     * For a criterion with an operator that acts on other criteria (eg "and", "or"), a list of
     * sub-criteria that are grouped together by the operator.
     *
     * <p>Default value is null
     * @see com.smartgwt.client.docs.AdvancedFilter AdvancedFilter overview and related methods
     */
    public Criterion[] criteria;

    /**
     * Value to be used in the application of this criterion. <P> Value may be required or not
     * required, or may be an Array, according to the {@link
     * com.smartgwt.client.types.OperatorValueType} of the operator.
     *
     * <p>Default value is null
     * @see com.smartgwt.client.docs.AdvancedFilter AdvancedFilter overview and related methods
     */
    public Object value;

}
