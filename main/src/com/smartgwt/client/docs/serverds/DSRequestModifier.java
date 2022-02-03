
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
 * An object that modifies a dsRequest based on several available 
 *  values, including preceding responses from the same queue.<p>
 * <b>This class is not meant to be created and used, it is actually documentation of settings
 * allowed in a DataSource descriptor (.ds.xml file), for use with Smart GWT Pro Edition and
 * above.
 * See {@link com.smartgwt.client.docs.serverds} for how to use this documentation.</b>
 * <p>
 *  <p>
 *  <b>Some elements of this feature are only available with Power or better licenses.</b> See
 *  <a href=http://smartclient.com/product>smartclient.com/product</a> for details.
 *  <p>
 *  You provide a list of DSRequestModifiers as the 
 * {@link com.smartgwt.client.docs.serverds.OperationBinding#criteria OperationBinding.criteria}
 * or {@link com.smartgwt.client.docs.serverds.OperationBinding#values OperationBinding.values}
 * of an {@link com.smartgwt.client.docs.serverds.OperationBinding}.  The ability to modify a
 * request based on responses to 
 * earlier requests in the same queue is called {@link
 * com.smartgwt.client.docs.TransactionChaining}.
 *  <P>
 * A DSRequestModifier consists of a {@link
 * com.smartgwt.client.docs.serverds.DSRequestModifier#fieldName fieldName}, usually a
 * {@link com.smartgwt.client.docs.serverds.DSRequestModifier#value value} and possibly an {@link
 * com.smartgwt.client.docs.serverds.DSRequestModifier#operator operator}
 * and {@link com.smartgwt.client.docs.serverds.DSRequestModifier#start start} and/or {@link
 * com.smartgwt.client.docs.serverds.DSRequestModifier#end end} values 
 * (applicable to advanced criteria only).  The value, start and end settings can be static, or - 
 *  with Power or better licenses - they can be expressions in the Velocity template language, 
 *  which will be resolved at runtime, immediately before the DSRequest is executed.
 *  <p>
 * In addition to the standard {@link com.smartgwt.client.docs.VelocitySupport Velocity
 * variables}, special Velocity 
 * variables are available for the <i>value</i> field when used in a &lt;values&gt; declaration - 
 *  see {@link com.smartgwt.client.docs.serverds.DSRequestModifier#value value} for details.
 *  <p>
 * See below some examples of {@link com.smartgwt.client.docs.serverds.OperationBinding#criteria
 * OperationBinding.criteria} declarations:
 *  <pre>
 *   &lt;operationBindings&gt;
 *       &lt;operationBinding operationType="fetch" operationId="..."&gt;
 *           &lt;criteria fieldName="lifeSpan" value="10"/&gt;
 *           &lt;criteria fieldName="scientificName" value="Gazella thomsoni"/&gt;
 *       &lt;/operationBinding&gt;
 *       
 *       &lt;operationBinding operationType="fetch" operationId="..."&gt;
 *           &lt;criteria fieldName="lifeSpan" operator="greaterThan" value="10" /&gt;
 *       &lt;/operationBinding&gt;
 *   
 *       &lt;operationBinding operationType="fetch" operationId="..."&gt;
 *           &lt;criteria _constructor="AdvancedCriteria" operator="or"&gt;
 *               &lt;criteria&gt;
 *                   &lt;Criterion fieldName="lifeSpan" operator="greaterThan" value="10" /&gt;
 *                   &lt;Criterion fieldName="scientificName" operator="contains" value="Octopus" /&gt;
 *               &lt;/criteria&gt;
 *           &lt;/criteria&gt;
 *       &lt;/operationBinding&gt;
 *   &lt;/operationBindings&gt;
 *  </pre>
 *  <p>
 * And an example of {@link com.smartgwt.client.docs.serverds.OperationBinding#values
 * OperationBinding.values} declarations:
 *  <pre>
 *  &lt;operationBinding operationType="add"&gt;
 *      &lt;values fieldName="orderID" value="$responseData.last('queuedAdd_order','add').orderID" /&gt;
 *  &lt;/operationBinding&gt;
 *  </pre>
 *  <p>
 * DSRequestModifiers are intended partly as a security mechanism, so like {@link
 * com.smartgwt.client.docs.DeclarativeSecurity Declarative Security} 
 * features, they apply to requests from browsers, but by default do not apply to requests
 * initiated by server code.  
 * To have DSRequestModifiers apply to a server-initiated DSRequest, use either setRPCManager() or
 * setClientRequest().
 *  <p>
 * See the <a href='https://www.smartclient.com/smartclient-latest/showcase/?id=queuedAdd'
 * target='_blank'>Master/Detail Add Example</a> 
 *  to see this in action.
 */
public class DSRequestModifier {

    /**
     * The name of the field to add or replace on the DSRequest - whether this appears in the
     * DSRequest's values or criteria depends on whether this is part of a {@link
     * com.smartgwt.client.docs.serverds.OperationBinding#values OperationBinding.values} or {@link
     * com.smartgwt.client.docs.serverds.OperationBinding#criteria OperationBinding.criteria}
     * attribute.
     *
     * <p>Default value is null
     */
    public FieldName fieldName;

    /**
     * The name of the operator to apply when constructing criteria.  This property only applies  to
     * criteria; it is ignored if specified as part of a {@link
     * com.smartgwt.client.docs.serverds.OperationBinding#values OperationBinding.values}  attribute.
     *
     * <p>Default value is null
     */
    public String operator;

    /**
     * The value to use for the start of a range.  This property only applies to criteria, and it 
     * only applies to operators of type "rangeCheck" - for example, the "between" operator. It is
     * ignored if specified as part of a {@link
     * com.smartgwt.client.docs.serverds.OperationBinding#values OperationBinding.values} attribute,
     * or for  an inapplicable operator type. <p> The same rules apply to this attribute as apply to
     * {@link com.smartgwt.client.docs.serverds.DSRequestModifier#value value}, so you can use
     * Velocity expressions if you have a Power or better license.
     *
     * <p>Default value is null
     * @see com.smartgwt.client.docs.TransactionChaining TransactionChaining overview and related methods
     */
    public VelocityExpression start;

    /**
     * The value to use for the end of a range.  This property only applies to criteria, and it  only
     * applies to operators of type "rangeCheck" - for example, the "between" operator. It is ignored
     * if specified as part of a {@link com.smartgwt.client.docs.serverds.OperationBinding#values
     * OperationBinding.values} attribute, or for  an inapplicable operator type. <p> The same rules
     * apply to this attribute as apply to {@link
     * com.smartgwt.client.docs.serverds.DSRequestModifier#value value}, so you can use Velocity
     * expressions if you have a Power or better license.
     *
     * <p>Default value is null
     * @see com.smartgwt.client.docs.TransactionChaining TransactionChaining overview and related methods
     */
    public VelocityExpression end;

    /**
     * The value to assign to the field named by {@link
     * com.smartgwt.client.docs.serverds.DSRequestModifier#fieldName fieldName}.  This value can be
     * static, and for Pro licenses that is the only option.  With Power and better licenses, this
     * value can be an expression in the Velocity template language.  In this latter case, all the
     * standard {@link com.smartgwt.client.docs.VelocitySupport Velocity context variables} provided
     * by Smart GWT Server are available to you. <p> Note, <code>dsRequestModifier</code> values are
     * evaluated during {@link com.smartgwt.client.data.DSRequest}  setup, before the request's
     * <code>execute()</code> method is called.  This means that  variables added to the Velocity
     * context by calling <code>addToTemplateContext()</code> from a {@link
     * com.smartgwt.client.docs.DmiOverview DMI} method or  {@link
     * com.smartgwt.client.docs.serverds.DataSource#serverConstructor custom DataSource
     * implementation} will not be available. In this case, you can either<ul> <li>Apply the variable
     * values directly to the <code>DSRequest</code>'s criteria and values from your Java code.  See
     * the server-side Javadoc for <code>DSRequest</code></li> <li>Add your template variables to the
     * <code>DSRequest</code>'s template context before  <code>dsRequestModifier</code> evaluation
     * takes place, in a custom override of  {@link com.smartgwt.client.docs.ServerDataIntegration the
     * IDACall servlet}</li> </ul> <h3>masterId and responseData</h3> There is also one additional
     * Velocity context variable available in this specific case:  <b>$masterId</b>. If there is a
     * {@link com.smartgwt.client.docs.serverds.DataSourceField#foreignKey foreignKey} from the 
     * DataSource for the current operation to another DataSource for which an add or update 
     * operation has taken place earlier in the queue, this is the value of the target field of  the
     * foreign key, taken from the response data of that earlier operation (the most recent  one, if
     * there are several).  This is useful because it will typically yield the (possibly  just
     * generated) primary key of the "master" record. <p> Consider a queued batch of "add" operations
     * for an order header and its details.  The  detail additions need to know the unique primary key
     * that was assigned to the order, but  this will typically be generated at the time of inserting
     * the order row into the database, so it is not known up-front.  However, this value will be in
     * the response to the DSRequest that added the order header, so it is accessible via
     * <b>$responseData</b>; if there is a  declared foreign key relationship from the detail
     * DataSource to the header DataSource, the  header's unique key value will also be accesible as
     * <b>$masterId</b>.  See this example:  <a
     * href="http://www.smartclient.com/smartgwtee/showcase/#transactions_queued_md"
     * target="examples">Master/Detail Add Example</a>. <p> <code>$responseData</code> - which is an
     * instance of  <code>com.isomorphic.velocity.ResponseDataHandler</code> - exposes various
     * overloads of <code>first()</code> and <code>last()</code> APIs that can be called to obtain the
     * actual  record data of prior responses.  These methods return an instance of 
     * <code>com.isomorphic.velocity.ResponseDataWrapper</code>, which allows convenient handling of
     * response data whether it is a single record or a list.  Response data can be treated as a
     * single record even if it is a List, so you can access the response data directly, with no need
     * for an index; when you do this, and the data is actually a List or array, you get the  first
     * record.  If the response data is a list or array, you can also access individual  records in
     * that list using Velocity index notation, and you can use the special value  "last" to access
     * the last element of a List or array. <p> Examples of the Velocity syntax needed: <p>
     * <code>$responseData.first.myField</code> is the myField property of the first response in the
     * queue. Note, this works whether that response returned a single record or a list. If it
     * returned a list, this Velocity expression gets the first record in the list.  This is a
     * particularly useful shorthand for 'add' and 'update' operations, where the response data  is
     * typically a List containing a single record <p>
     * <code>$responseData.first('order').myField</code> is the myField property of the first response
     * to an  operation (any operation) on the "order" DataSource <p>
     * <code>$responseData.first('order', 'add').myField</code> is the myField property of the first 
     * response to an "add" operation on the "order" DataSource <p> <code>$responseData.first('order',
     * 'fetch').last.myField</code> is the myField property of the last record in the response data of
     * the first fetch in the  queue (fetch operations always return a List of records) <p>
     * <code>$responseData.first('order', 'fetch')[0].myField</code> is the myField property of a
     * specific record (in this case, the first) in the response data of the first response in the 
     * queue.  Note that this is shown for completeness only: there is no need to use index  notation
     * to explicitly request the first record, unless you are iterating over the entire  list or have
     * some other out-of-the-ordinary use case.  The first record is assumed if you  omit the index
     * notation, so this example is equivalent to the simpler:  <code>$responseData.first('order',
     * 'fetch')[0].myField</code> <p> All of these syntactic variations are also available on the
     * <code>$responseData.last</code> object -  "last" here meaning the most recent response matching
     * the DataSource and operation type (if  applicable).  Note, "last" potentially has three
     * different meanings, depending on context: If your DataSource contains a field that is actually
     * called "last", the following expression  would be the correct way to obtain the value of the
     * field called "last", on the last record of the last (most recent) response:
     * <code>$responseData.last.last.last</code> <p> Please see the server-side Javadoc for the 
     * <code>com.isomorphic.velocity.ResponseDataHandler</code> class.
     *
     * <p>Default value is null
     * @see com.smartgwt.client.docs.TransactionChaining TransactionChaining overview and related methods
     */
    public VelocityExpression value;

}
