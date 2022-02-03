
package com.smartgwt.client.docs;

/**
 * <h3>Server Summaries</h3>
 * In Smart GWT, "summarization" refers to applying functions to DataSource fields to obtain
 *  <i>summary records</i> calculated from the values of multiple DataSource records.  
 *  <p>
 *  For example, by applying an "average" function to a DataSourceField representing the dollar
 *  value of an order, you can calculate the average dollar amount of a set of orders.
 *  <p>
 *  Server Summaries is a feature of the
 *  Smart GWT Server allowing similar summaries to be computed server-side, generally by the
 *  database engine itself, or client-side for
 *  {@link com.smartgwt.client.docs.ClientOnlyDataSources clientOnly DataSources}.
 *  Client-side calculation of summary records is also supported on ListGrids via the
 *  {@link com.smartgwt.client.widgets.grid.ListGrid#getShowGridSummary showGridSummary feature}.
 *  <p>
 *  <b>Server-side calculation is available with Power or better licenses only.</b>  See
 *  <a href="http://smartclient.com/product">smartclient.com/product</a> for details.
 *  <p>
 *  See also the related feature which allows a single field to receive a value summarized from
 * several related records, {@link
 * com.smartgwt.client.docs.serverds.DataSourceField#includeSummaryFunction
 * DataSourceField.includeSummaryFunction}.
 *  <p>
 *  Summarization can be statically configured directly in a .ds.xml file, or can be dynamically
 * configured when sending a {@link com.smartgwt.client.data.DSRequest}, either client-side or
 * server-side.  The
 *  following examples all assume a DataSource with fields like this:
 *  <pre>
 *  &lt;DataSource ID="dsOrders" ...&gt;
 *   &lt;fields&gt;
 *    &lt;field name="customerName" type="text" /&gt;
 *    &lt;field name="orderDate" type="date" /&gt;
 *    &lt;field name="deliveryStatus" type="string" /&gt;
 *    ...
 *   &lt;/fields&gt;
 *  &lt;/DataSource&gt;
 *  </pre>
 *  <p>
 *  <h3>Summaries in DataSource .ds.xml files</h3>
 *  <p>
 * You can declare summarization directly on an {@link com.smartgwt.client.data.OperationBinding
 * operationBinding} in a
 * .ds.xml file, using {@link com.smartgwt.client.docs.serverds.OperationBinding#summaryFunctions
 * OperationBinding.summaryFunctions} and
 * {@link com.smartgwt.client.docs.serverds.OperationBinding#groupBy OperationBinding.groupBy}. 
 * For example:
 *  <pre>
 *  &lt;DataSource ID="dsOrders" ...&gt;
 *     ...
 *     &lt;operationBindings&gt;
 *       &lt;operationBinding operationType="fetch" operationId="lastOrderDateByCustomer"&gt;
 *         &lt;summaryFunctions&gt;
 *           &lt;orderDate&gt;max&lt;/orderDate&gt;
 *         &lt;/summaryFunctions&gt;
 *         &lt;groupBy&gt;customerName&lt;/groupBy&gt;
 *       &lt;/operationBinding&gt;
 *    &lt;/operationBindings&gt;
 *  &lt;/DataSource&gt;
 *  </pre>
 *  This would return summary records representing the most recent order per customer.
 *  Represented in JSON, the returned records would look like:
 *  <pre>
 *    { customerName: "JBar Struts", orderDate:"2012/02/05" },
 *    { customerName: "KFoo Widgets", orderDate:"2012/03/01" },
 *    ...
 *  </pre>
 *  This is analogous to the result of a SQL query like:
 *  <pre>
 *  SELECT
 *   max(order.orderDate)
 *   order.customerName
 *  FROM
 *   order
 *  GROUP BY
 *   order.customerName
 *  </pre>
 *  Note that, as with SQL, the returned records will <i>only</i> include the fields where summary
 *  functions were applied or which were used for grouping - "deliveryDate" and other fields are
 *  not included because in general, summary records may represent data from more than one
 *  record (there may be more than one record with the "max" value, and consider also "sum" or
 *  "avg" functions), so it's ambiguous which record's values should be returned for
 *  non-grouped, non-summarized fields.
 *  <p>
 *  <h3>Dynamically Requested Summaries</h3>
 *  <p>
 * {@link com.smartgwt.client.data.DSRequest#getSummaryFunctions DSRequest.summaryFunctions} and
 * {@link com.smartgwt.client.data.DSRequest#getGroupBy DSRequest.groupBy} allow you to
 * dynamically
 *  request a server summary from client-side code.  For example:
 *  
 *  
 *  <pre>
 *   DSRequest requestProperties = new DSRequest();
 *   requestProperties.setGroupBy("customerName");
 *   requestProperties.setSummaryFunctions(new HashMap() {{
 *      put("orderDate", SummaryFunctionType.MAX);
 *   }});
 *   dsOrders.fetchData(null, <i>callback</i>, request);
 *  </pre>
 *  
 *  By default such requests are allowed, but such requests can be disallowed on a
 *  per-DataSource or system-wide level if you have concerns - see
 * {@link com.smartgwt.client.docs.serverds.DataSource#allowClientRequestedSummaries
 * DataSource.allowClientRequestedSummaries}.
 *  <p>
 *  You can also dynamically request summaries from server-side code (for example, in a
 *  DMI method):
 *  <pre>
 *    DSRequest dsRequest = new DSRequest("dsOrders", "fetch");
 *    dsRequest.setSummaryFunctions(new HashMap() {{
 *      put("orderDate", SummaryFunctionType.MAX);
 *    }});
 *    dsRequest.setGroupBy("customerName");
 *    DSResponse dsResponse = dsRequest.execute();
 *  </pre>
 *  <p>
 *  <h3>Sort &amp; Data Paging</h3>
 *  <p>
 *  Sort directions are supported for queries that involve server summarization although may only
 * target fields that are returned by the query (only those fields included in
 * <code>groupBy</code>
 *  or where a <code>summaryFunction</code> was applied).
 *  <p>
 *  Data paging is also supported, however, consider that for aggregated queries, when asked for
 *  a second page of data, the database is likely to have to repeat all the work of calculating
 * aggregated values.  Turning paging off or setting a generous {@link
 * com.smartgwt.client.widgets.grid.ListGrid#getDataPageSize ListGrid.dataPageSize} is
 *  advised.
 *  <p>
 *  <h3>Criteria</h3>
 *  <p>
 *  <h4>SQL &amp; clientOnly DataSource</h4>
 *  <p>
 *  Criteria is automatically split into pre and post summarization parts:
 *  <ul>
 * <li/>Fields that are not summarized will have criteria applied to them before summarization.
 * This
 * includes {@link com.smartgwt.client.data.DSRequest#getGroupBy group by} fields and fields that
 * are there just for filtering
 *  purposes, i.e. might not be fetched at all. For example if a "price" field would be a regular
 *  field in a fetch, i.e. not summarized, criteria like "price &lt; 5" will eliminate records
 *  where price is less than 5, so such records would not affect the average or total computed.
 * <li/>Fields that are summarized will have criteria applied to them after summarization. For
 * example
 * if the "avg" summary function is being applied to a "price" field would, same criteria "price
 * &lt; 5"
 *  would eliminate records where summarized value "avg(price)" is less than 5.
 *  </ul>
 *  This post-summarization server filtering matches client-side filtering, since it is always
 * post-summarization on the client-side. Disabling filter for summarized fields on the
 * client-side
 *  is no longer necessary to get the same results, as it was in previous versions.
 *  <p>
 * Previous versions applied criteria on the server for all fields <b>before</b> summarization.
 * You can get that behavior back via
 * {@link com.smartgwt.client.docs.serverds.OperationBinding#applyCriteriaBeforeAggregation
 * OperationBinding.applyCriteriaBeforeAggregation} setting. Note that in that case you need to
 * turn off client-side
 * filtering for aggregated fields, because client-side filtering cannot replicate
 * pre-summarization filtering, as client
 * sees only the final computed aggregates. See {@link
 * com.smartgwt.client.docs.serverds.OperationBinding#applyCriteriaBeforeAggregation
 * OperationBinding.applyCriteriaBeforeAggregation} docs for more details.
 *  <p>
 *  <h4>HB and JPA DataSources</h4>
 *  <p>
 *  Criteria apply to record <b>before</b> summaries are applied.  For example, if the "avg"
 *  function is being applied to a "price" field, criteria like "price &lt; 5" will eliminate
 *  records where price is less than 5 <i>before</i> the average price is calculated.  This
 *  means that client-side filtering may not work as expected with summarized results:
 *  client-side filter criteria are necessarily applied <i>after</i> summary functions have been
 *  applied, so may not match the server's behavior.  You can set
 * {@link com.smartgwt.client.data.ResultSet#getUseClientFiltering ResultSet.useClientFiltering}
 * to disable client-side filtering on a grid via
 * {@link com.smartgwt.client.widgets.grid.ListGrid#getDataProperties ListGrid.dataProperties}. 
 * Or individual fields can be marked
 *  {@link com.smartgwt.client.widgets.grid.ListGridField#getCanFilter canFilter:false}.
 *  <p>
 *  <h3>SQL Templating & Aggregation</h3>
 *  <p>
 * With the {@link com.smartgwt.client.docs.CustomQuerying SQL Templating} feature you can
 * customize portions of the query without
 * ever having to re-create portions that the framework knows how to generate. This allows to
 * create partially
 * or entirely custom complex aggregation queries to use in a regular "fetch" operation. The SQL
 * Templating
 *  feature supports aggregated queries just as regular ones with some additions, see below.
 *  <p>
 *  In clause-by-clause substitution there are two additional aggregation specific clauses:
 * {@link com.smartgwt.client.data.OperationBinding#getGroupClause groupClause} providing "group
 * by" part of aggregated query and
 * {@link com.smartgwt.client.data.OperationBinding#getGroupWhereClause groupWhereClause}
 * providing "having" part of aggregated query (or outer
 * "where" part if sub-select approach is used, see {@link
 * com.smartgwt.client.docs.serverds.OperationBinding#useHavingClause
 * OperationBinding.useHavingClause} for more details). The
 * automatically generated <code>groupClause</code> and <code>groupWhereClause</code> clauses are
 * also available as
 *   $defaultGroupClause and  $defaultGroupWhereClause
 * SQL templating variables. Note that if {@link
 * com.smartgwt.client.docs.serverds.OperationBinding#applyCriteriaBeforeAggregation
 * OperationBinding.applyCriteriaBeforeAggregation} is set to
 *  <code>true</code>, <code>groupWhereClause</code> is not generated.
 *  <p>
 * <code>SQLDataSource.getSQLClause()</code> server-side API can generate the entire query, in
 * case you wanted
 * to use an aggregated query as just part of a larger query (perhaps a sub-select), or different
 * parts of a query,
 *  including <code>groupClause</code> and <code>groupWhereClause</code> aggregated query clauses.
 *  <p>
 * Also note <code>SQLDataSource.getPartialHaving()</code> and
 * <code>SQLDataSource.getHavingWithout()</code>
 * server-side APIs which generate partial SQL condition expressions to be used as a complete or
 * partial "having"
 *  or outer "where" clause. This is also can be accessed via <code>$sql.partialHaving</code> and
 * <code>$sql.havingWithout</code> functions in SQL templates, see <code>$sql</code> variable
 * description in
 *  {@link com.smartgwt.client.docs.VelocitySupport}.
 *  <p>
 * To see an example of wrapping the main query as a sub-select to achieve additional aggregation
 * level and
 * splitting provided criteria into different chunks of condition expressions to apply them to
 * specific parts
 *  of a completely customized aggregation query, see the
 * <a href='https://www.smartclient.com/smartclient-latest/showcase/?id=summariesCustomSQL2'
 * target='_blank'>Custom Aggregation Query</a> sample.
 *  <p>
 *  <h3>Fields with customSelectExpression</h3>
 *  <p>
 * Fields with {@link com.smartgwt.client.data.DataSourceField#getCustomSelectExpression
 * customSelectExpression} can be used 
 * with server summaries as both <code>groupBy</code> fields or fields with
 * <code>summaryFunction</code>. 
 * In case of <code>summaryFunction</code> requested on field with
 * <code>customSelectExpression</code> we 
 *  will wrap SQL function around the expression, which may or may not be correct.
 *  <p>
 *  <h3>Summarizing without Grouping</h3>
 *  <p>
 *  Declaring just &lt;summaryFunctions&gt; without declaring &lt;groupBy&gt; is allowed.  This
 *  will always give you exactly one summary record in the result, which will represent the
 *  summary functions as applied to all records that match the criteria in the DSRequest.
 *  <p>
 *  <h3>Grouping without Summarizing</h3>
 *  <p>
 *  Declaring just &lt;groupBy&gt; without &lt;summaryFunctions&gt; is also allowed.  This gives
 *  results similar to a SQL "select distinct": one record per distinct set of values for the
 *  grouped fields.  This kind of result can be used in various ways; one common use case is
 *  populating a ComboBoxItem with a list of existing values for a field that already appear in
 *  DataSource records.
 *  <p>
 * Check out <a href='https://www.smartclient.com/smartclient-latest/showcase/?id=loadedValues'
 * target='_blank'>this example</a>
 *  of grouping without summarizing being used to determine all unique values of a field.
 *  <p>
 *  <h3>Custom Aggregation</h3>
 *  <p>
 *  You can implement your own custom aggregation functions in addition to the built-in ones by
 *  providing custom DMI implementation for the "fetch" operation. To see the example of using
 *  custom function see
 * <a href='https://www.smartclient.com/smartclient-latest/showcase/?id=summariesCustom'
 * target='_blank'>Custom Aggregation</a>
 *  sample. Note, that in order to access custom summary function on the server-side you need to
 *  use <code>DSRequest.getRawSummaryFunctions()</code> API.
 * @see com.smartgwt.client.types.SummaryFunction
 * @see com.smartgwt.client.data.DSRequest#getSummaryFunctions
 * @see com.smartgwt.client.data.DSRequest#getGroupBy
 * @see com.smartgwt.client.docs.serverds.OperationBinding#summaryFunctions
 * @see com.smartgwt.client.docs.serverds.OperationBinding#groupBy
 * @see com.smartgwt.client.docs.serverds.DataSourceField#includeSummaryFunction
 * @see com.smartgwt.client.data.DataSourceField#getJoinPrefix
 * @see com.smartgwt.client.data.DataSourceField#getJoinString
 * @see com.smartgwt.client.data.DataSourceField#getJoinSuffix
 * @see com.smartgwt.client.docs.serverds.DataSource#allowClientRequestedSummaries
 * @see com.smartgwt.client.docs.serverds.DataSourceField#allowClientRequestedSummaries
 */
public interface ServerSummaries {
}
