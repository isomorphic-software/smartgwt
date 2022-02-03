
package com.smartgwt.client.docs;

/**
 * <h3>Transaction Chaining</h3>
 * <i>Transaction Chaining</i> allows {@link com.smartgwt.client.rpc.RPCManager#startQueue queues}
 * of
 * {@link com.smartgwt.client.data.DSRequest}s to be "chained" together, such that later
 * <code>DSRequests</code> in
 *  the queue can use the results of previous requests in the queue.  This allows you to
 *  declaratively handle various situations where information only becomes available during the
 *  processing of a queue.
 *  <p>
 *  Transaction Chaining is only available with Power Edition licenses or better.  See the
 * <a href='http://smartclient.com/product/' target='_blank'>Editions &amp; Pricing page</a> for
 * details.
 *  <p>
 *  As an example of Transaction Chaining, consider an application that needs to do a
 *  master-detail add, which involves saving a new Record representing a sales order to an
 *  <code>order</code> DataSource, and also saving several related Records representing
 *  individual items in the order to an <code>orderItem</code> DataSource.  The Records for the
 *  individual <code>orderItem</code>s need to set up foreign keys referencing the primary key
 *  assigned to the Record for the <code>order</code>, but the primary key of the
 *  <code>order</code> record is assigned only when the Record is inserted into the database; it
 *  cannot be known up-front.
 *  <p>
 *  You could resolve this programmatically - for example, you could use DMIs to store and
 *  retrieve the PK value using <code>servletRequest</code> attributes - but Transaction Chaining
 *  gives you an elegant, declarative, code-free alternative, giving you a way to declare that the
 *  foreignKey value for the <code>orderItem</code> records should use the primary key value
 *  resulting from the creation of the <code>order</code> record earlier in the same queue.
 *  <p>
 *  As another example, consider an application that allows a user to submit a free-form
 *  question which must be persisted to the database like a normal update, but which should
 *  initially show the user a list of previously-provided answers that appear to be relevant.
 *  The operation that handles the add of the question categorizes it by analyzing the text, and
 *  the category is added to the record inserted into the database, and thus to the record
 *  returned in the response.  Now, via transaction chaining, a "fetch" operation later in the
 *  queue can pick up the newly assigned category and use it in criteria to fetch the list of
 *  related answers.
 *  <p>
 * Transaction Chaining is implemented by specifying {@link
 * com.smartgwt.client.docs.serverds.DSRequestModifier}s in 
 * {@link com.smartgwt.client.docs.serverds.OperationBinding#values OperationBinding.values} and
 * {@link com.smartgwt.client.docs.serverds.OperationBinding#criteria OperationBinding.criteria}. 
 * These two properties
 *  provide a general means of declaratively modifying DSRequests server-side, and transaction
 *  chaining is only one of their uses.  They can also be used, for example, to implement security
 *  rules, by adding the currently-authorized user to the criteria of all fetch requests.
 *  <p>
 *  Specifically for transaction chaining, you specify <code>criteria</code> and/or 
 *  <code>values</code> entries on the <code>operationBinding</code> where the 
 * {@link com.smartgwt.client.docs.serverds.DSRequestModifier#value value} property references the
 * <b>$responseData</b>
 *  Velocity context variable - see the "value" link for more details.  
 *  Alternatively, you can use the <code>RPCManager</code> APIs <code>getFirstResponse()</code>
 *   and <code>getLastResponse()</code> to get access to the same information, either 
 *  programmatically from DMI or custom DataSource Java code, or in 
 * {@link com.smartgwt.client.docs.ServerScript JSR 223 scripts}, or in Velocity expressions via
 * the <b>$rpc</b> 
 *  context variable.
 *  <p>
 *  <h3>Client-driven Transaction Chaining</h3>
 *  A limited form of transaction chaining (limited for security reasons) is possible without 
 *  server-side operationBinding configuration, using 
 * {@link com.smartgwt.client.data.DSRequest#getFieldValueExpressions fieldValueExpressions}.  The
 * primary intended use 
 *  case is a master-detail add, where the detail records require the master's primary key for
 *  use as foreign keys, but that value is not known until the master record has been inserted.
 * In such a case, you create a {@link com.smartgwt.client.rpc.RPCManager#startQueue queue} of
 * requests, with the 
 *  add of the master record first, followed by the detail records, each of which has
 *  <code>fieldValueExpressions</code> set up to use <code>$masterId</code> like so:
 *  
 *  <pre>
 *      DSRequest properties = new DSRequest();
 *      Map fve = new HashMap();
 *      fve.put("fkField", "$masterId");
 *      properties.setFieldValueExpressions(fve);
 *      myDataSource.addData(record, callback, properties);
 *  </pre>
 *  It is also possible to achieve the same thing in a less compact but more flexible way by
 *  using the <code>$responseData</code> context variable (note that client-driven usages of 
 *  <code>$responseData</code> are limited for security reasons - see 
 * {@link com.smartgwt.client.data.DSRequest#getFieldValueExpressions fieldValueExpressions} for
 * details).  This approach
 *  allows you to reference values where there is no declared foreignKey relationship, and it 
 *  allows you to reference responses other than the most recent one.  For example:
 *  
 *  <pre>
 *      DSRequest properties = new DSRequest();
 *      Map fve = new HashMap();
 *      fve.put("anyField", "$responseData.first.anyOtherField");
 *      properties.setFieldValueExpressions(fve);
 *      myDataSource.addData(record, callback, properties);
 *  </pre>
 *  <p>
 *  <h3>Stand-alone Application Transaction Chaining</h3>
 *  Transaction chaining is supported when using transactions standalone. Every request within
 *  the same transaction will be eligible during the chaining. It works in the
 *  same way as it would if your application was a full blown Smart GWT application. See
 * {@link com.smartgwt.client.docs.StandaloneDataSourceUsage Standalone DataSource Usage} for
 * examples on how to
 *  do this.
 * @see com.smartgwt.client.docs.serverds.DSRequestModifier
 * @see com.smartgwt.client.data.DSRequest#getFieldValueExpressions
 * @see com.smartgwt.client.docs.serverds.DSRequestModifier#value
 * @see com.smartgwt.client.docs.serverds.DSRequestModifier#start
 * @see com.smartgwt.client.docs.serverds.DSRequestModifier#end
 * @see com.smartgwt.client.docs.serverds.OperationBinding#criteria
 * @see com.smartgwt.client.docs.serverds.OperationBinding#values
 */
public interface TransactionChaining {
}
