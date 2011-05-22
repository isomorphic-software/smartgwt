
package com.smartgwt.client.docs;

/**
 * <h3>Velocity context variables</h3>
 * The Smart GWT Server provides a number of standard context variables for use in the &#010 Velocity templates you write
 * to implement {@link com.smartgwt.client.docs.CustomQuerying custom queries}, &#010  transaction chaining,  &#010 {@link
 * com.smartgwt.client.docs.serverds.OperationBinding#requires dynamic security checking} and &#010 {@link
 * com.smartgwt.client.types.Mail templated mail messages}.  These are:&#010 <ul>&#010 <li><b>$currentDate</b>. The current
 * date/time with millisecond precision</li>&#010 <li><b>$transactionDate</b>. The date/time that this transaction started,
 * with millisecond &#010 precision.  If you are not using {@link com.smartgwt.client.rpc.RPCManager#startQueue queuing},
 * this value will be&#010 identical to <b>$currentDate</b></li>&#010 <li><b>$servletRequest</b>. The associated
 * <code>HttpServletRequest</code></li> &#010 <li><b>$dsRequest</b>. The associated {@link
 * com.smartgwt.client.data.DSRequest} (though of course this is a&#010 server-side <code>DSRequest</code> object, so
 * please also see the server-side Javadocs)</li> &#010 <li><b>$primaryDSRequest</b>. Only present on cache-sync
 * operations, this is the original&#010 update <code>DSRequest</code> that caused the cache-sync request to be
 * created</li> &#010 <li><b>$session</b>. The associated <code>HttpSession</code></li>&#010 <li><b>$httpParameters</b>.
 * This variable gives you access to the parameters Map of the &#010 associated <code>HttpServletRequest</code>; it is an
 * alternate form of &#010 <code>$servletRequest.getParameter</code></li>&#010 <li><b>$requestAttributes</b>. This variable
 * gives you access to the attributes Map of the &#010 associated <code>HttpServletRequest</code>; it is an alternate form
 * of &#010 <code>$servletRequest.getAttribute</code></li>&#010 <li><b>$sessionAttributes</b>. This variable gives you
 * access to the attributes Map of the &#010 associated <code>HttpSession</code>; it is an alternate form of &#010
 * <code>$session.getAttribute</code></li>&#010 <li><b>$dataSources</b>. This variable gives you access to Smart GWT {@link
 * com.smartgwt.client.data.DataSource}s.  &#010 You access a dataSource by suffixing its name to the
 * <code>$dataSources</code> designation.&#010 For example, <code>$dataSources.supplyItem</code> refers to the DataSource
 * object called &#010 "supplyItem".  You can use this approach to execute any valid DataSource method. One especially&#010
 * useful method in this context is <code>hasRecord(fieldName, value)</code> - see the &#010 server-side Javadocs for more
 * details.&#010 <li><b>$util</b> - A <code>DataTools</code> object, giving you access to all of that&#010     class's
 * useful helper functions</li>&#010 </ul>&#010 All of these variables (other than the two dates) represent objects that
 * can contain other &#010 objects (attributes or parameters or object properties).  The variables based on the
 * Servlet&#010 API (session, sessionAttributes, httpParameters, servletRequest and requestAttributes) all &#010 implement
 * the <code>Map</code> interface, so you can use the Velocity "property" shorthand &#010 notation to access them.  The
 * following usage examples show five equivalent ways to return &#010 the value of the session attribute named "foo":&#010
 * <pre>&#010    $session.foo&#010    $session.get("foo")&#010    $session.getAttribute("foo")&#010   
 * $sessionAttributes.foo&#010    $sessionAttributes.get("foo")&#010 </pre>&#010 In the case of
 * <code>$servletRequest</code>, the shorthand approach accesses the attributes &#010 - you need to use either
 * <code>$httpParameters</code> or <code>$servletRequest.getParameter</code>&#010 to access parameters. These examples all
 * return the value of the HTTP parameter named "bar":&#010 <pre>&#010    $httpParameters.bar&#010   
 * $httpParameters.get("bar")&#010    $servletRequest.getParameter("bar")&#010 </pre>&#010 When you use these Velocity
 * variables in a {@link com.smartgwt.client.docs.serverds.OperationBinding#customSQL customSQL} &#010 clause or SQL
 * snippet such as a {@link com.smartgwt.client.docs.serverds.OperationBinding#whereClause whereClause}, all of &#010 these
 * template variables return values that have been correctly quoted and escaped according&#010  to the syntax of the
 * underlying database.  We do this because "raw" values are vulnerable to &#010 <a
 * href="http://en.wikipedia.org/wiki/SQL_injection">SQL injection attacks</a>.&#010 If you need access to the raw value of
 * a variable in a SQL template, you can use the &#010 <b>$rawValue</b> qualifier in front of any of the template
 * variables, like this:<br><br><code>&#010 &nbsp;&nbsp;$rawValue.session.foo</code>&#010 <p>&#010 This also works for the
 * <b>$criteria</b> and <b>$values</b> context variables (see &#010 {@link com.smartgwt.client.docs.CustomQuerying} for
 * details of these variables).  So:<br><br><code>&#010 &nbsp;&nbsp;$rawValue.criteria.customerName</code>&#010 </p>&#010
 * Note that <code>$rawValue</code> is only available in SQL templates.  It is not needed in&#010 other contexts, such as
 * Transaction Chaining, because the value is not escaped and &#010 quoted in these contexts.&#010 <p>&#010 <b>Warning</b>:
 * Whenever you access a template variable for use in a SQL statement, bear &#010 in mind that it is <b>dangerous</b> to
 * use <code>$rawValue</code>.  There are some cases &#010 where using the raw value is necessary, but even so, all such
 * cases are likely to be vulnerable &#010 to injection attacks.  Generally, the presence of <code>$rawValue</code> in a
 * SQL template &#010 should be viewed as a red flag.&#010 <p>&#010 Finally, some example usages of these values.  &#010
 * These {@link com.smartgwt.client.docs.serverds.OperationBinding#values values} clauses set "price" to a value extracted
 * from the &#010 session, and "lastUpdated" to the date/time that this transaction started:<br><br><code>&#010
 * &nbsp;&nbsp;&lt;values fieldName="price" value="$session.somePrice" /&gt;<br>&#010 &nbsp;&nbsp;&lt;values
 * fieldName="lastUpdated" value="$transactionDate" /&gt;&#010 </code><p>&#010 This whereClause selects some users based on
 * various values passed in the criteria and &#010 as HTTP parameters:<br><br><code>&#010
 * &nbsp;&nbsp;&lt;whereClause&gt;department = $httpParameters.userDept AND dob &gt;=
 * $criteria.dateOfBirth&lt;/whereClause&gt;&#010 </code><p>&#010 This whereClause selects some users based on various
 * values obtained from the &#010 servletRequest's attributes, using a number of equivalent techniques for accessing the
 * &#010 attributes:<pre>&#010   &lt;whereClause&gt;&#010         department = $servletRequest.dept &#010     AND startDate
 * &gt;= $requestAttributes.dateOfBirth &#010     AND salary &lt; $servletRequest.getAttribute("userSalary")&#010  
 * &lt;/whereClause&gt;&#010 </pre><p>
 */
public interface VelocitySupport {
}
