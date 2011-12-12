
package com.smartgwt.client.docs;

/**
 * <h3>Direct Method Invocation</h3>
 * Direct Method Invocation (DMI) allows background HTTP requests to directly
 *  invoke methods on server-side objects via XML configuration. This feature requires the
 *  {@link com.smartgwt.client.docs.IscServer Smart GWT Server}.<br>
 *  Note that Smart GWT also supports several approaches for interacting with
 *  {@link com.smartgwt.client.docs.NonJavaBackend non-Java backends} and/or Java backends not
 *  running the ISC server.
 *  <p>
 *  When using DMI, inbound request data is translated to Java objects and passed as method
 *  parameters to the designated method, with available request data matched to each declared
 *  parameter by Java type. The return value of your method is automatically wrapped as a valid
 *  response and delivered to the browser.
 *  <P>
 *  <u><b>DataSource DMI</b></u>
 *  <br>
 *  See also {@link com.smartgwt.client.docs.ServerDataIntegration Server DataSource Integration} overview.<br>
 *  To enable DMI for a given DataSource, simply include a <code>&lt;serverObject&gt;</code>
 *  configuration block in that DataSource's configuration either at
 *  {@link com.smartgwt.client.data.DataSource#getServerObject serverObject} or on a particular operationBinding via
 * {@link com.smartgwt.client.docs.serverds.OperationBinding#serverObject serverObject}.  The ServerObject specifies the
 * target of the method
 * invocation and {@link com.smartgwt.client.docs.serverds.OperationBinding#serverMethod serverMethod} specifies the method
 * that will be
 *  called.
 *  <P>
 *  For example, the following Datasource DMI declaration would route "fetch" operations for
 *  this DataSource to the method "fetch" on an object stored in the servlet session under the
 *  name "beanFetcher":
 *  <pre>
 *  &lt;DataSource&gt;
 *    &lt;operationBindings&gt;
 *        &lt;binding operationType="fetch" serverMethod="fetch"&gt;
 *            &lt;serverObject  
 *                 lookupStyle="attribute" 
 *                 attributeScope="session" 
 *                 attributeName="beanFetcher"/&gt;
 *        &lt;/binding&gt;
 *    &lt;/operationBindings&gt;
 *    ...
 *  &lt;/DataSource&gt;
 *  </pre>
 *  Method overloading is not supported - there must be exactly one method on the target class
 * with the name specified in {@link com.smartgwt.client.docs.serverds.OperationBinding#serverMethod serverMethod}.  The
 * method must be public,
 *  but can be either an instance or static method.  If no operationBinding is specified or the
 *  operationBinding does not specify a <code>serverMethod</code> then it defaults to the name of
 *  the operation (eg "fetch").
 *  <p>
 *  By default, the DSResponse data sent back by DataSource DMIs is filtered to just the set of
 *  fields specified on the DataSource.  This allows you to simply return beans that potentially
 *  have getter methods for fields other than are defined in the DataSource without that
 *  (potentially private) data being sent to the client.  If you want to disable this
 *  functionality, you can do so on a per-operation basis by setting
 * {@link com.smartgwt.client.docs.serverds.ServerObject#dropExtraFields dropExtraFields}, on a per-DataSource level by
 * setting
 * {@link com.smartgwt.client.data.DataSource#getDropExtraFields dropExtraFields}, or globally by setting the config
 * parameter
 *  <code>DMI.dropExtraFields</code> to <code>false</code> in
 *  <code>[webroot]/WEB-INF/classes/server.properties</code>.  Non-DMI DSResponse data is, by
 *  default, not filtered in this manner for backward compatibility reasons.  If you want to
 *  enable this type of filtering for non-DMI DSResponse data, you can do so by setting the
 *  config parameter <code>DSResponse.dropExtraFields</code> to <code>true</code> in
 *  <code>[webroot]/WEB-INF/classes/server.properties</code>.  <code>DMI.dropExtraFields</code>
 *  and <code>DSResponse.dropExtraFields</code> can be enabled/disabled independently of each
 *  other - that is, setting one does not side-effect the other.  <code>server.properties</code>
 * settings can be overridden by an explicit setting in {@link com.smartgwt.client.data.DataSource#getDropExtraFields
 * dropExtraFields} which
 * in turn can be overridden by an explicit setting in {@link
 * com.smartgwt.client.docs.serverds.ServerObject#dropExtraFields dropExtraFields} (this
 *  last one for DMI only since non-DMI operations don't have a serverObject context).
 *  <p>
 *  <u><b>DataSource DMI and regular RPCManager dispatch</b></u><br>
 *  It is possible to use DMI to incorporate your own code into what is otherwise the regular 
 *  process flow of an ordinary, non-DMI DataSource request.  This is particularly valuable if
 *  you are using the built-in SQL or Hibernate DataSources, because it allows you to inject
 *  extra functionality (validations, processing steps, messages to other systems, anything you
 *  can code) into a fetch or update request that is otherwise handled for you by the Smart GWT 
 *  Server.
 *  <p>
 *  To do this, just configure an operationBinding for DMI, as described above.  Then, in your
 *  server-side method, invoke <code>execute()</code> on the <code>DSRequest</code> your method
 *  is passed.  If you create a DMI method that does nothing <b>but</b> invoke
 *  <code>dsRequest.execute()</code>, then you have a DMI method that behaves exactly like the
 *  normal RPCManager dispatch code.  Customizing "normal RPCManager dispatch code" is now a 
 *  simple matter of adding logic to your DMI method.  See 
 * <a href="http://www.smartclient.com/smartgwtee/showcase/#sql_user_specific_data" target="examples">this example</a> of
 * this technique in the Feature Explorer.
 *  <p>
 *  <u><b>RPC DMI</b></u>
 *  <br>
 *  RPC DMI makes a set of methods from a server-side class available as client-side methods for
 *  direct invocation (via  DMI.call). This provides a way to perform arbitrary
 *  client/server interactions outside of the DataSource subsystem.
 *  <P>
 *  RPC DMI is an alternative approach to using the {@link com.smartgwt.client.rpc.RPCManager} class directly to send
 *  requests to some <code>actionURL</code> where your server code would receive a generalized
 *  {@link com.smartgwt.client.rpc.RPCRequest request object}, to be routed to appropriate
 *  methods yourself.  Which interface (DMI or RPCManager) you choose is largely a matter of
 *  preference - they provide equivalent functionality.
 *  <P>
 *  RPC DMI also uses a {@link com.smartgwt.client.docs.serverds.ServerObject} configuration block to specify
 * the server-side DMI end-point, but in the case of RPCs, the {@link com.smartgwt.client.docs.serverds.ServerObject}
 * definition
 *  goes into an <code>rpcBindings</code> section of an
 *  {@link com.smartgwt.client.docs.ApplicationDeclaration Application definition} in a <code>*.app.xml</code> file. 
 *  
 *  The only difference between the RPC DMI
 *  ServerObject definition and the DataSource DMI version is the addition of the
 * {@link com.smartgwt.client.docs.serverds.ServerObject#visibleMethods visibleMethods} block that specifies which methods
 * are callable on this
 *  ServerObject.  This section is not consulted for DataSource DMIs because the
 * {@link com.smartgwt.client.docs.serverds.OperationBinding#serverMethod serverMethod} is used to specify the callable
 * method in that case.
 *  <p>
 *  <u><b>Method Invocation</b></u>
 *  <br>
 *  Smart GWT can pass a set of stock context variables to your DMI method and also performs
 *  some type adaptation logic to make this interface more flexible.  For DataSource DMI, you
 *  can declare your method to take any number of the following types of arguments and they will
 *  be passed to you:
 *  <ul>
 *  <li>HttpServletRequest
 *  <li>HttpServletResponse
 *  <li>ServletContext
 *  <li>HttpSession
 *  <li>RPCManager
 *  <li>DSRequest
 *  <li>RequestContext (from com.isomorphic.servlet)
 *  <li>DataSource (same as DSRequest.getDataSource())
 *  <li>Map (same as DSRequest.getValues())
 *  <li>Bean (auto-populated from DSRequest.getValues())
 *  </ul>
 *  DataSource DMI methods can return any of the following types of values:
 *  <ul>
 *  <li>DSResponse (used as the DSResponse verbatim)
 *  <li>List (valid response to a fetch operation - gets auto-popuplated into a DSResponse for
 *  you via setData())
 *  <li>Map or Bean (valid response to add, update, remove operations - gets auto-populated
 *  into a DSResponse for you via setData()).
 *  </ul>
 *  Note that to take advantage of some Smart GWT features like paging and custom validation,
 *  you need to return a DSResponse and provide the required metadata (like
 *  startRow/endRow/totalRows for paging).  You can simply return a <code>List</code> instead,
 *  but this won't work for large datasets.
 *  <p>
 *  So, for example, all of the following DataSource DMI method signatures are valid:
 *  <pre>
 *  public List myFetch(Map criteria)
 *  public List myFetch(SupplyItem criteria)
 *  public DSResponse myAdd(HttpSession session, 
 *                          DataSource ds, 
 *                          DSRequest dsRequest)
 *  </pre>
 *  <p>
 *  See
 * <a href='/examples/server_integration/#customDataSourceIntegrationDMI'
 * onclick="window.open('/examples/server_integration/#customDataSourceIntegrationDMI');return false;">the supplyItemDMI
 * example</a>
 *  for an example of DataSource DMI.
 *  <p>
 *  <p>
 *  RPC DMIs work slightly differently.  Unlike DataSource DMIs, RPC DMIs can have an arbitrary
 *  number of required arguments, and also some optional context arguments.  For example, let's
 *  say you call a method from the client like so 
 *  :
 *  <br>
 *  
 *  <pre>
 *   List someList = new ArrayList();
 *   someList.add(1);
 *   someList.add(2);
 *   DMI.call("myApp", "com.sample.MyClass", "doSomething", new RPCCallback() {
 *    
 *    &#64;Override
 *    public void execute(RPCResponse response, Object rawData, RPCRequest request) {
 *     
 *     SC.say("raw data from server method:" + rawData.toString());
 *     
 *     
 *    }
 *   }, new Object[] {1, "zoo", someList});
 *  </pre>
 *  
 *  The server-side implementation of the method invoked must have a signature that
 *  will accept the arguments passed in from the client. In the example above 
 *  <code>com.sample.MyClass.doSomething</code> should accept a Number, String, 
 *  and a List as arguments.  Smart GWT will try to adapt arguments where possible - 
 *  so for example the first argument can be a Long or an Integer, or a native type 
 *  (<code>long</code> or <code>int</code>) instead and the
 *  invocation will still work. 
 *  
 *  
 *  If a Map is passed from the client to the server it will
 *  be automatically applied to a bean if the method argument takes a Bean in that position.
 *  
 *  See {@link com.smartgwt.client.rpc.RPCRequest#getData data} for a table of type conversions.
 *  <P>
 *  In addition to the parameters explicitly passed from the client, your method signature
 *  can include some additional arguments to pick up information about the request passed in.
 *  If your server side method is declared with arguments of the following type they will
 *  be passed to your DMI method.
 *  <ul>
 *  <li>HttpServletRequest
 *  <li>HttpServletResponse
 *  <li>HttpSession
 *  <li>RPCManager
 *  <li>RPCRequest
 *  </ul>
 *  <P>
 *  Your server side method can return a <code>RPCResponse</code> object giving you full
 *  control over the response sent to the server. If your method does not return a response,
 *  one will be created automatically and the return value from the server method will become the
 *  <code>data</code> value on the response. <br>
 * See {@link com.smartgwt.client.rpc.RPCRequest#getData data} for an overview of how server side java data types are
 * mapped 
 *  to client side values.
 * 
 */
public interface DmiOverview {
}
