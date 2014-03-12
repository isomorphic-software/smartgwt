
package com.smartgwt.client.docs;

/**
 * <h3>Server Summaries</h3>
 * In Smart GWT, "summarization" refers to applying functions to DataSource fields to obtain
 *  <i>summary records</i> calculated from the values of multiple DataSource records.  
 *  <p>
 *  For example, by applying an "average" function to a DataSourceField representing the dollar
 *  value of an order, you can calculate the average dollar amount of a set of orders.
 *  <p>
 *  Client-side calculation of summary records is a 
 * {@link com.smartgwt.client.widgets.grid.ListGrid#getShowGridSummary listGrid feature}.  Server
 * Summaries is a feature of the
 *  Smart GWT Server allowing similar summaries to be computed server-side, generally by the
 *  database engine itself.  
 *  <p>
 *  See also the related feature which allows a single field to receive a value summarized from
 * several related records, {@link
 * com.smartgwt.client.docs.serverds.DataSourceField#includeSummaryFunction
 * includeSummaryFunction}.
 *  <p>
 *  <b>The Server Summaries feature is available with Power or better licenses only.</b>  See 
 *  <a href="http://smartclient.com/product">smartclient.com/product</a> for details.
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
 * summaryFunctions} and
 *  {@link com.smartgwt.client.docs.serverds.OperationBinding#groupBy groupBy}.  For example:
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
 *   max(order.orderData)
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
 * {@link com.smartgwt.client.data.DSRequest#getSummaryFunctions summaryFunctions} and {@link
 * com.smartgwt.client.data.DSRequest#getGroupBy groupBy} allow you to dynamically
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
 * allowClientRequestedSummaries}.
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
 *  <h3>Criteria, Sort &amp; Data Paging</h3>
 *  <p>
 *  Criteria and sort directions are supported for queries that involve server summarization.
 *  <p>
 *  Criteria apply to record <b>before</b> summaries are applied.  For example, if the "avg"
 *  function is being applied to a "price" field, criteria like "price &lt; 5" will eliminate
 *  records where price is less than 5 <i>before</i> the average price is calculated.  This
 *  means that client-side filtering may not work as expected with summarized results: 
 *  client-side filter criteria are necessarily applied <i>after</i> summary functions have been
 *  applied, so may not match the server's behavior.  You can set
 * {@link com.smartgwt.client.data.ResultSet#getUseClientFiltering useClientFiltering} to disable
 * client-side filtering on a grid via
 * {@link com.smartgwt.client.widgets.grid.ListGrid#getDataProperties dataProperties}.  Or
 * individual fields can be marked
 *  {@link com.smartgwt.client.widgets.grid.ListGridField#getCanFilter canFilter:false}.
 *  <p>
 *  Sort directions may only target fields that are returned by the query (only those fields
 *  included in <code>groupBy</code> or where a <code>summaryFunction</code> was applied).
 *  <p>
 *  Data paging is also supported, however, consider that for aggregated queries, when asked for
 *  a second page of data, the database is likely to have to repeat all the work of calculating
 * aggregated values.  Turning paging off or setting a generous {@link
 * com.smartgwt.client.widgets.grid.ListGrid#getDataPageSize dataPageSize} is
 *  advised.
 *  <p>
 *  <h3>SQL Templating</h3>
 *  <p>
 * {@link com.smartgwt.client.docs.CustomQuerying SQL Templating} is also supported with server
 * summaries.
 *  Clause-by-clause substitution works normally.
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
 * @see com.smartgwt.client.data.DSRequest#getSummaryFunctions
 * @see com.smartgwt.client.data.DSRequest#getGroupBy
 * @see com.smartgwt.client.docs.serverds.OperationBinding#summaryFunctions
 * @see com.smartgwt.client.docs.serverds.OperationBinding#groupBy
 * @see com.smartgwt.client.docs.serverds.DataSourceField#includeSummaryFunction
 * @see com.smartgwt.client.docs.serverds.DataSource#allowClientRequestedSummaries
 * @see com.smartgwt.client.docs.serverds.DataSourceField#allowClientRequestedSummaries
 * @see com.smartgwt.client.types.SummaryFunction
 */
public interface ServerSummaries {
}
