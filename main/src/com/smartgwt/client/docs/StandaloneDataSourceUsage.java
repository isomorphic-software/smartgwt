	    
package com.smartgwt.client.docs;

/**
 * <h3>Standalone DataSource Usage</h3>
 * The DataSource layer can be used in a standalone application separate from a servlet engine,
 *  for things like Java Swing applications, batch data processing or sending emails based on
 *  database state.
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
 *  set a "webRoot" in your <code>server.properties</code> file.  The webRoot should point
 *  to the root folder of your application (note for SmartGWT applications, this is typically
 *  the "war" subfolder of your project).  Example entries:<p>
 *  <code>    webRoot: /home/testUser/myProject</code><p>
 *  or:<p>
 *  <code>    webRoot: C:\Projects\MyProject\war</code><p>
 * Again in <code>server.properties</code>, you may need to set
 * <code>isomorphicPathRootRelative</code>
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
 *  You should place the <code>server.properties</code> file somewhere on your classpath.  
 *  Typically, the root of your <code>bin</code> or <code>classes</code> folder structure is 
 *  the most suitable place for it.
 *  <p>
 *  Both the built-in DataSources and custom DataSources can be used in standalone
 *  applications, <b>but only if you do not introduce dependencies on the servlet container in
 *  your DataSource code</b>. For example, if you have a security check in a DMI or custom
 *  DataSource that depends on checking the current logged-in user, code in a means of bypassing
 *  this, or create a parallel operationBinding that is accessible only to the superuser.
 *  <p>
 *  When you use the DataSource layer in a standalone application, 
 * {@link com.smartgwt.client.docs.serverds.DataSource#requiresAuthentication Declarative
 * Security} is disabled; all operations
 *  are considered to be valid for use in a standalone application.  Other DataSource features
 *  that are disabled because they are not relevant in a standalone context are:
 *  <ul>
 *  <li> Transaction Chaining</li>
 * <li>{@link com.smartgwt.client.docs.serverds.DataSource#autoJoinTransactions Transactional
 * persistence}</li>
 *  </ul>
 *  <br>
 *  <b>Using Spring in a standalone application</b>
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
 *  <code>standalone.spring.applicationContext</code> in your <code>server.properties</code>.
 *  The default setting for this property looks like this:<pre>
 *     standalone.spring.applicationContext: $webRoot/WEB-INF/applicationContext.xml
 *  </pre>
 */
public interface StandaloneDataSourceUsage {
}
