
package com.smartgwt.client.docs;

/**
 * <h3>Velocity context variables</h3>
 * The Smart GWT Server provides a number of standard context variables for use in the 
 *  Velocity templates you write to implement {@link com.smartgwt.client.docs.CustomQuerying custom queries}, 
 *   transaction chaining,  
 *  {@link com.smartgwt.client.docs.serverds.OperationBinding#requires dynamic security checking} and 
 *  {@link com.smartgwt.client.types.Mail templated mail messages}.  These are:
 *  <ul>
 *  <li><b>$currentDate</b>. The current date/time with millisecond precision</li>
 *  <li><b>$transactionDate</b>. The date/time that this transaction started, with millisecond 
 *  precision.  If you are not using {@link com.smartgwt.client.rpc.RPCManager#startQueue queuing}, this value will be
 *  identical to <b>$currentDate</b></li>
 *  <li><b>$servletRequest</b>. The associated <code>HttpServletRequest</code></li> 
 *  <li><b>$dsRequest</b>. The associated {@link com.smartgwt.client.data.DSRequest} (though of course this is a
 *  server-side <code>DSRequest</code> object, so please also see the server-side Javadocs)</li> 
 *  <li><b>$primaryDSRequest</b>. Only present on cache-sync operations, this is the original
 *  update <code>DSRequest</code> that caused the cache-sync request to be created</li> 
 *  <li><b>$session</b>. The associated <code>HttpSession</code></li>
 *  <li><b>$httpParameters</b>. This variable gives you access to the parameters Map of the 
 *  associated <code>HttpServletRequest</code>; it is an alternate form of 
 *  <code>$servletRequest.getParameter</code></li>
 *  <li><b>$requestAttributes</b>. This variable gives you access to the attributes Map of the 
 *  associated <code>HttpServletRequest</code>; it is an alternate form of 
 *  <code>$servletRequest.getAttribute</code></li>
 *  <li><b>$sessionAttributes</b>. This variable gives you access to the attributes Map of the 
 *  associated <code>HttpSession</code>; it is an alternate form of 
 *  <code>$session.getAttribute</code></li>
 *  <li><b>$dataSources</b>. This variable gives you access to Smart GWT {@link com.smartgwt.client.data.DataSource}s.  
 *  You access a dataSource by suffixing its name to the <code>$dataSources</code> designation.
 *  For example, <code>$dataSources.supplyItem</code> refers to the DataSource object called 
 *  "supplyItem".  You can use this approach to execute any valid DataSource method. One especially
 *  useful method in this context is <code>hasRecord(fieldName, value)</code> - see the 
 *  server-side Javadocs for more details.
 *  <li><b>$util</b> - A <code>DataTools</code> object, giving you access to all of that
 *      class's useful helper functions</li>
 *  </ul>
 *  All of these variables (other than the two dates) represent objects that can contain other 
 *  objects (attributes or parameters or object properties).  The variables based on the Servlet
 *  API (session, sessionAttributes, httpParameters, servletRequest and requestAttributes) all 
 *  implement the <code>Map</code> interface, so you can use the Velocity "property" shorthand 
 *  notation to access them.  The following usage examples show five equivalent ways to return 
 *  the value of the session attribute named "foo":
 *  <pre>
 *     $session.foo
 *     $session.get("foo")
 *     $session.getAttribute("foo")
 *     $sessionAttributes.foo
 *     $sessionAttributes.get("foo")
 *  </pre>
 *  In the case of <code>$servletRequest</code>, the shorthand approach accesses the attributes 
 *  - you need to use either <code>$httpParameters</code> or <code>$servletRequest.getParameter</code>
 *  to access parameters. These examples all return the value of the HTTP parameter named "bar":
 *  <pre>
 *     $httpParameters.bar
 *     $httpParameters.get("bar")
 *     $servletRequest.getParameter("bar")
 *  </pre>
 * When you use these Velocity variables in a {@link com.smartgwt.client.docs.serverds.OperationBinding#customSQL
 * customSQL} 
 * clause or SQL snippet such as a {@link com.smartgwt.client.docs.serverds.OperationBinding#whereClause whereClause}, all
 * of 
 *  these template variables return values that have been correctly quoted and escaped according
 *   to the syntax of the underlying database.  We do this because "raw" values are vulnerable to 
 *  <a href="http://en.wikipedia.org/wiki/SQL_injection">SQL injection attacks</a>.
 *  If you need access to the raw value of a variable in a SQL template, you can use the 
 *  <b>$rawValue</b> qualifier in front of any of the template variables, like this:<br><br><code>
 *  &nbsp;&nbsp;$rawValue.session.foo</code>
 *  <p>
 *  This also works for the <b>$criteria</b> and <b>$values</b> context variables (see 
 *  {@link com.smartgwt.client.docs.CustomQuerying} for details of these variables).  So:<br><br><code>
 *  &nbsp;&nbsp;$rawValue.criteria.customerName</code>
 *  </p>
 *  Note that <code>$rawValue</code> is only available in SQL templates.  It is not needed in
 *  other contexts, such as Transaction Chaining, because the value is not escaped and 
 *  quoted in these contexts.
 *  <p>
 *  <b>Warning</b>:  Whenever you access a template variable for use in a SQL statement, bear 
 *  in mind that it is <b>dangerous</b> to use <code>$rawValue</code>.  There are some cases 
 *  where using the raw value is necessary, but even so, all such cases are likely to be vulnerable 
 *  to injection attacks.  Generally, the presence of <code>$rawValue</code> in a SQL template 
 *  should be viewed as a red flag.
 *  <p>
 *  Finally, some example usages of these values.  
 * These {@link com.smartgwt.client.docs.serverds.OperationBinding#values values} clauses set "price" to a value extracted
 * from the 
 *  session, and "lastUpdated" to the date/time that this transaction started:<br><br><code>
 *  &nbsp;&nbsp;&lt;values fieldName="price" value="$session.somePrice" /&gt;<br>
 *  &nbsp;&nbsp;&lt;values fieldName="lastUpdated" value="$transactionDate" /&gt;
 *  </code><p>
 *  This whereClause selects some users based on various values passed in the criteria and 
 *  as HTTP parameters:<br><br><code>
 * &nbsp;&nbsp;&lt;whereClause&gt;department = $httpParameters.userDept AND dob &gt;=
 * $criteria.dateOfBirth&lt;/whereClause&gt;
 *  </code><p>
 *  This whereClause selects some users based on various values obtained from the 
 *  servletRequest's attributes, using a number of equivalent techniques for accessing the 
 *  attributes:<pre>
 *    &lt;whereClause&gt;
 *          department = $servletRequest.dept 
 *      AND startDate &gt;= $requestAttributes.dateOfBirth 
 *      AND salary &lt; $servletRequest.getAttribute("userSalary")
 *    &lt;/whereClause&gt;
 *  </pre><p>
 */
public interface VelocitySupport {
}
