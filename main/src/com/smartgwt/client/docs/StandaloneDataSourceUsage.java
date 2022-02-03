
package com.smartgwt.client.docs;

/**
 * <h3>Standalone DataSource Usage</h3>
 * The DataSource layer can be used in a standalone application separate from a servlet engine,
 *  for use cases like offline batch data processing, sending emails based on database
 *  state, or integration of Smart GWT Server logic into a standalone Java Swing application.
 *  <p>
 *  In addition, the section below on "Transactions in standalone applications" also applies to
 *  any transaction that is initiated separately from an RPCManager and/or the HttpServletRequest
 *  lifecycle.  This includes use cases like non-servlet web apps (using NIO servers like
 *  Grizzly), web apps that set timers to perform delayed actions (using frameworks such as
 * Quartz), as well JMS or other Java frameworks that may introduce non-HttpServletRequest threads
 *  within a servlet container.
 *  <p>
 *  Note that we do still require <code>servlet-api.jar</code> to be on the classpath of 
 *  standalone applications.  This is only to satisfy class-loading requirements; there are 
 *  cases where running inside a servlet engine allows us to provide extra functionality, such
 *  as declarative authentication and authorization features, so some classes do have member 
 *  variables or method parameters of types in the Servlet API.  They all operate correctly 
 *  when these variables or parameters are null, but the JVM will still try to load the classes 
 *  and will crash if they are missing.
 *  <p> 
 *  Using the DataSource layer to run DataSource operations in your standalone applications is
 *  extremely straightforward.  This example fetches and prints every record from the 
 *  "customers" DataSource:
 *  <pre>
 *    public static void main(String[] args) {
 *      DataSource ds = DataSourceManager.get("customers");
 *      List records = ds.fetch();
 *      for (Iterator i = records.iterator; i.hasNext(); ) {
 *        System.out.println(i.next());
 *      }
 *    }
 *  </pre>
 *  To make this example fetch just customers in the United States:
 *  <pre>
 *      Map criteria = new HashMap();
 *      criteria.put("countryCode", "US");
 *      List records = ds.fetch(criteria);
 *  </pre>
 *  This example shows how to run a specific fetch operation, specifying both selection 
 * criteria and a sort order, using a <code>DSRequest</code> rather than a <code>DataSource</code>
 * 
 *  convenience method:
 *  <pre>
 *    public static void main(String[] args) {
 *      DSRequest dsReq = new DSRequest("customers", "fetch");
 *      dsReq.setOperationId("specialFetch");
 *      Map criteria = new HashMap();
 *      criteria.put("countryCode", "US");
 *      criteria.put("region", "CA");
 *      dsReq.setCriteria(criteria);
 *      dsReq.setSortBy("customerName");
 *      List records = dsReq.execute().getDataList();
 *    }
 *  </pre>
 *  This example shows how to do a simple update:
 *  <pre>
 *    public static void main(String[] args) {
 *      DataSource ds = DataSourceManager.get("customers");
 *      Map criteria = new HashMap();
 *      criteria.put("customerNo", 12345);
 *      Map values = new HashMap();
 *      values.put("creditLimit", 10000);
 *      values.put("currencyCode", "USD");
 *      ds.update(criteria, values);
 *    }
 *  </pre>
 *  Finally, this example shows how to perform a specific update operation via a 
 *  <code>DSRequest</code>:
 *  <pre>
 *    public static void main(String[] args) {
 *      DSRequest dsReq = new DSRequest("customers", "update");
 *      dsReq.setOperationId("specialUpdate");
 *      Map criteria = new HashMap();
 *      criteria.put("customerNo", 12345);
 *      Map values = new HashMap();
 *      values.put("creditLimit", 10000);
 *      values.put("currencyCode", "USD");
 *      dsReq.setCriteria(criteria);
 *      dsReq.setValues(values);
 *      dsReq.execute();
 *    }
 *  </pre>
 *  <b>NOTES</b>
 *  <p>
 *  Because we are not running inside a servlet container, Smart GWT's built-in logic to 
 *  work out where its application root is does not work.  Therefore, you need to manually 
 * set a "webRoot" in your {@link com.smartgwt.client.docs.Server_properties server.properties}
 * file. 
 *  The webRoot should point
 *  to the root folder of your application (note for SmartGWT applications, this is typically
 *  the "war" subfolder of your project).  Example entries:<p>
 *  <code>    webRoot: /home/testUser/myProject</code><p>
 *  or:<p>
 *  <code>    webRoot: C:\Projects\MyProject\war</code><p>
 *  Again in {@link com.smartgwt.client.docs.Server_properties server.properties}, 
 *  you may need to set <code>isomorphicPathRootRelative</code>
 *  to match the standalone project's layout if you make the standalone mode separate:<p>
 *  <code>    isomorphicPathRootRelative: myProject/sc</code>
 *  <p>
 *  
 *  Note that the directory structure that normally appears in "war/<i>myProject</i>/sc" in your
 *  GWT project is required to be present under the configured
 * <i>webRoot</i>+<i>isomorphicPathRootRelative</i> directory when running standalone.  This
 * structure is
 *  normally created by the GWT compiler, by processing &lt;inherits&gt; tags in your .gwt.xml
 *  that cause resources to be copied from smartgwtee.jar.  If your build/deployment scripts do
 *  not invoke the GWT compiler these files will not be present, so you will need to either add
 *  a step to invoke the GWT compiler or manually copy the files.
 *  
 * You should place the {@link com.smartgwt.client.docs.Server_properties server.properties} file
 * somewhere on your classpath.  
 *  Typically, the root of your <code>bin</code> or <code>classes</code> folder structure is 
 *  the most suitable place for it.
 *  <p>
 *  Both the built-in DataSources and custom DataSources can be used in standalone
 *  applications, <b>but only if you do not introduce dependencies on the servlet container in
 *  your DataSource code</b>. For example, if you have a security check in a DMI or custom
 *  DataSource that depends on checking the current logged-in user, code in a means of bypassing
 *  this, or create a parallel operationBinding that is accessible only to the superuser.
 *  <br>
 *  <h3>Declarative Security</h3>
 *  <p>
 *  When you use the DataSource layer in a standalone application,
 * {@link com.smartgwt.client.docs.serverds.DataSource#requiresAuthentication Declarative
 * Security} has to be explicitly controlled.
 *  <p>
 * To enable a request for security checks you simply need to call
 * <code>dsRequest.setUserId()</code>
 * or <code>dsRequest.setUserRoles()</code>. If the request is apart of a transaction then
 * security
 *  can also be defaulted using <code>dsTransaction.setClientRequest(true/false)</code>, however
 *  any value set on an individual request will still take priority. For instance if you call
 * <code>dsTransaction.setClientRequest(false)</code> but then also call
 * <code>dsRequest.setUserId(id)</code>,
 * then security checks will still take place for that request as it has had security enabled
 * which
 *  takes priority over the value on <code>DSTransaction</code>.
 *  <p>
 *  Note: If you have Declarative Security checks in your DataSources and/or enabled via your Java
 *  code, and you want to completely disable such checks system-wide, you can  set
 * <code>security.disabled: true</code> in {@link com.smartgwt.client.docs.Server_properties}. 
 * This causes API calls
 *  like <code>dsRequest.setClientRequest()</code> to be completely ignored.
 * 
 *  <h3>Transactions</h3>
 *  <p>
 * In standalone mode, transactions cannot be automatically initiated with the HTTP request
 * lifecyle,
 * however you can still manually initiate and commit transactions (note, only available with a
 * Power
 *  or better license).  To do so, create a <code>DSTransaction</code> object and associated each
 *  <code>DSRequest</code> with it via <code>dsRequest.setDSTransaction()</code>.  At the end of
 *  processing, call <code>DSTransaction.complete()</code> to ensure commits and rollbacks are
 *  executed and that resources are freed up.
 *  <p>
 *  Usage Example:
 *  <pre>
 *      DSTransaction dst = new DSTransaction();
 *      DSRequest req1 = new DSRequest("myDataSource", "update");
 *      req1.setDsTransaction(dst);
 * 
 *      DSRequest req2 = new DSRequest("myDataSource", "add");
 *      req2.setDsTransaction(dst);
 * 
 *      DSRequest req3 = new DSRequest("myDataSource", "update");
 *      req3.setDsTransaction(dst);
 * 
 *      try {
 *          // This will process the queue of requests which have been registered with the transaction.
 *          dst.processQueue();
 *      } finally {
 *          // We put this in a "finally" block to ensure it always runs even on exceptions.
 *          dst.complete();
 *      }
 *  </pre>
 *  <p>
 * You can also handle the requests manually instead of using
 * <code>dsTransaction.processQueue()</code>.
 *  This can be handy if you wish to perform another operation in between each request or if one
 *  request depends on data from the other.  At the end of processing, call
 *  <code>DSTransaction.complete()</code> to ensure commits and rollbacks are executed and that
 *  resources are freed up.
 *  <p>
 *  Usage Example:
 *  <pre>
 *      DSTransaction dst = new DSTransaction();
 * 
 *      try {
 *          DSRequest req1 = new DSRequest("myDataSource", "fetch");
 *          req1.setDsTransaction(dst);
 * 
 *          DSRequest req2 = new DSRequest("myDataSource", "update");
 *          req2.setDsTransaction(dst);
 * 
 *          req1.execute();
 *          // Use the response from req1 to modify req2 here
 *          req2.execute();
 *      } catch (Exception e) {
 *          throw new RuntimeException(e);
 *      } finally {
 *          // We put this in a "finally" block to ensure it always runs even on exceptions.
 *          dst.complete();
 *      }
 *  </pre>
 *  <p>
 * Please note that {@link com.smartgwt.client.docs.TransactionChaining Transaction chaining} is
 * supported while
 *  using transactions in a standalone use case - expressions such as <code>$responseData</code>
 *  will refer to results from previous <code>DSRequests</code> that are part of the same
 *  <code>DSTransaction</code>.
 *  <p>
 *  <b>Note the following about standalone transactions:</b>
 *  <ul>
 *  <li>DSRequests that have not had <code>setDSTransaction()</code> called will be outside of
 *  any transactional processing - they will be auto-committed at the end of request
 *  processing.</li>
 *  <li>You may partition your updates into multiple transactions, simply by creating multiple
 *  <code>DSTransaction</code> objects and assigning them to DSRequests as required.  Note, this
 *  will tie up a database connection per <code>DSTransaction</code> until the transactions are
 *  committed or rolled back.</li>
 *  <li>When using the DSTransaction's built in <code>processQueue()</code> method, error handling
 *  will be taken care of automatically for each <code>DSRequest.execute()</code> call and a
 *  proper <code>DSResponse</code> will always be returned.</li>
 *  <li>Your code is responsible for calling the <code>complete()</code> method, which will
 *  commit the transaction if every DSRequest was successful, or roll it back if there were any
 *  failures, and then release the database connection. If you do not call
 *  <code>complete()</code>, you will leak database connections, so consider placing the call
 *  inside a <code>finally</code> block</li>
 *  <li>If you do not want Smart GWT Server's default behavior of automatically rolling back
 *  if any DSRequest failed, you can manually take over the transaction management by calling
 *  <code>commit()</code> or <code>rollback()</code> instead of <code>complete()</code>.  Note,
 *  if you do this you also take on responsibility for releasing the database connection by
 *  calling <code>freeQueueResources()</code> or <code>freeAllResources()</code>.  If you fail
 *  to do this, you will leak database connections</li>
 *  <li>A DSTransaction object can be re-used after <code>complete()</code> has been called.
 *  When you do this, a new database connection is borrowed or established, and a new
 *  transaction is started</li>
 *  </ul>
 * 
 *  <h3>Spring Framework</h3>
 *  <p>
 *  In a typical web application, Spring configuration is picked up from an "applicationContext"
 *  file by a servlet or listener, and then made available to the rest of the app via the
 *  servletContext.  When running standalone, this is not possible, so instead we read the
 *  applicationContext file manually when we need to, eg, create a DataSource object that is
 *  configured as a Spring bean.
 *  <p>
 *  By default, the framework will look in the "normal" place for for this configuration:
 *  <code>WEB-INF/applicationContext.xml</code>.  If you have changed the location or name
 *  of this file, and you want to run the application outside of a servlet engine, you can tell
 *  the framework where to find the configuration file by specifying property
 * <code>standalone.spring.applicationContext</code> in your {@link
 * com.smartgwt.client.docs.Server_properties server.properties}.
 *  The default setting for this property looks like this:<pre>
 *     standalone.spring.applicationContext: $webRoot/WEB-INF/applicationContext.xml
 *  </pre>
     * @see com.smartgwt.client.docs.TransactionChaining
 */
public interface StandaloneDataSourceUsage {
}
