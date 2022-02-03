
package com.smartgwt.client.docs;

/**
 * <h3>Server DataSource Integration</h3>
 * Server Data Integration means: <ul> <li> You {@link iscInstall install} the       {@link
 * com.smartgwt.client.docs.IscServer Smart GWT Java Server Framework} into any J2SE/J2EE     
 * environment, including any existing web application <li> You {@link
 * com.smartgwt.client.docs.DataSourceDeclaration create DataSources} via an XML declaration,
 * possibly on-the-fly from {@link metadataImport existing metadata}.   <li> Server communication
 * for components bound to these DataSources is handled automatically with a highly efficient,
 * compressed protocol.  You work with clean Java APIs instead of dealing with the details of XML
 * or JSON over HTTP. <li> You can use built-in connectors for SQL, Hibernate and other common
 * data providers without writing any code, or you can easily build your own connectors in Java.
 * <li> Whether using the built-in connectors or custom connectors, declarations in your
 * DataSource control a large set of server features that can make common types of business logic
 * entirely declarative </ul> This approach is in contrast to  {@link
 * com.smartgwt.client.docs.ClientDataIntegration Client-side Data Integration} in which
 * client-side DataSources are configured to send and receive HTTP messages containing XML, JSON
 * or other content. <P> <B>Server-side Request Processing</B> <P> Client-side {@link
 * com.smartgwt.client.widgets.DataBoundComponent DataBoundComponents} will send {@link
 * com.smartgwt.client.data.DSRequest DSRequests} to the Smart GWT Server as background
 * communications transparent to the user.  Integrating Smart GWT's DataSource layer with your
 * data model is a matter of handling these DSRequests and sending back DSResponses, in order to
 * fulfill the 4 basic operations of the {@link com.smartgwt.client.docs.DataSourceOperations
 * DataSource Protocol}. <P> Out of the box, Smart GWT is set up to route all DSRequests through a
 * special servlet called <code>IDACall</code>. <P> Note that the Smart GWT SDK includes detailed
 * Javadoc reference for this servlet and all shipped Smart GWT Java server classes. <P> Requests
 * that go through <code>IDACall</code> have the  following lifecycle: <ul> <li>The overall HTTP
 * request is received by the IDACall servlet.  Smart GWT supports  queuing of transactions, so
 * each HTTP request might contain multiple DSRequests.</li> <li>IDACall sets up an instance of
 * <code>RPCManager</code> to manage the processing of the entire queue of transactions.  For
 * every DSRequest in the queue, this RPCManager:</li>   <ul>   <li>Validates the DSRequest</li>  
 * <li>Checks the DataSource configuration for customizations implemented via        {@link
 * com.smartgwt.client.docs.ServerScript server scripting} or {@link
 * com.smartgwt.client.docs.DmiOverview DMI} - in other words, your code -       and passes the
 * request to this logic.       <p>       As described later in this section, your code can      
 * perform some custom logic here: either completely fulfilling the request, or      
 * alternatively modifying the request and causing the default       processing of the request to
 * continue</li>   <li>Calls the DataSource's <code>execute</code> method to obtain a
 * DSResponse.</li>   </ul> <li>Having processed all requests, the RPCManager now serializes all
 * the DSResponses  and sends them back to the browser as a single HTTP response</li> </ul> <p>
 * This basic request handling flow can be customized at a number of points: <ul> <li>If you need
 * an overarching authentication service, this is best implemented using  <a
 * href=http://java.sun.com/products/servlet/Filters.html>servlet Filters</a> to intercept
 * unauthenticated requests before they reach the <code>IDACall</code> servlet</li> <li>The {@link
 * com.smartgwt.client.docs.serverds.DataSource#serverType DataSource.serverType} specification
 * within your <code>.ds.xml</code> configuration     file is used to specify a standard
 * server-side connector to service your requests.</li> <li>General custom business logic can be
 * added in a number of ways, both declaratively and programmatically:</li> <ul>   <li>The
 * &lt;criteria&gt; and &lt;values&gt; properties of an {@link
 * com.smartgwt.client.data.OperationBinding}        allow you to modify the dataSource request
 * dynamically at transaction-processing time, using        built-in {@link
 * com.smartgwt.client.docs.VelocitySupport Velocity support}.<br>       Note this feature also
 * allows developers to use       {@link com.smartgwt.client.docs.TransactionChaining Transaction
 * Chaining} to dynamically set data values        according to the results of earlier
 * transactions.</li>   <li>For editing, standard {@link
 * com.smartgwt.client.data.DataSourceField#getValidators DataSourceField.validators} defined in
 * the <code>.ds.xml</code>        file will be processed on both the client and the server. In
 * addition to the built-in validator       types, entirely custom server validation logic may be
 * implemented using       {@link com.smartgwt.client.types.ValidatorType "serverCustom" type
 * validators}.</li>   <li>For SQL DataSources, use {@link com.smartgwt.client.docs.CustomQuerying
 * SQL Templating} to change, add        to or even completely replace the SQL sent to the
 * database, including calling       stored procedures</li>   <li>The {@link
 * com.smartgwt.client.docs.serverds.DataSource#serverConstructor DataSource.serverConstructor}
 * allows you to specify an explicit custom DataSource       subclass to create as your DataSource
 * instance. This must be a subclass of        <code>BasicDataSource</code>.<br>       When
 * requests are recieved by the        <code>IDACall</code> servlet, they will be passed to
 * standard methods on this DataSource, which       can be overridden for custom behavior.<br>    
 * Validation is performed via a call to the <code>validate()</code> method.<br>       The request
 * is processed by the <code>execute()</code>, method which can be overridden directly,       or
 * developers may override the operation-specific        methods <code>executeFetch()</code>,
 * <code>executeAdd()</code>, <code>executeUpdate</code>,       or <code>executeRemove()</code>
 * called from the standard <code>execute()</code> implementation.<br>       This approach allows
 * you to either extend one of the built-in persistence mechanisms       by subclassing a shipped
 * class such as <code>SQLDataSource</code>, or       create an entirely custom implementation
 * from scratch.<br>       A custom dataSource will still take full advantage of       
 * DataSource-agnostic features of the Smart GWT Server, like validation, queuing,      
 * transaction chaining, support for Velocity templating, and so on.<br>       For more
 * information see the {@link com.smartgwt.client.docs.WriteCustomDataSource custom server
 * dataSource overview}</li>   <li>Use {@link com.smartgwt.client.docs.DmiOverview Direct Method
 * Invocation} to call directly into your own Java        classes. An operation configured to use
 * DMI will invoke the specified method instead of       running through the standard DataSource
 * <code>execute()</code> method directly - the DMI       implementation can then use
 * <code>dsRequest.execute()</code> to call the default behavior.       This means DMIs allow you
 * to modify the <code>DSRequest</code> before it executes,       modify the
 * <code>DSResponse</code> before it returns, or replace the default behavior with       unrelated
 * actions. Note that DMI can be applied        {@link
 * com.smartgwt.client.data.DataSource#getServerObject to all operations}, or to        {@link
 * com.smartgwt.client.docs.serverds.OperationBinding#serverObject individual operation bindings},
 * and can be used       in conjunction with a {@link
 * com.smartgwt.client.data.DataSource#getServerObject custom dataSource}.</li>    <li>Use {@link
 * com.smartgwt.client.docs.ServerScript server scripting} to add small amounts of business logic 
 * right in your <code>.ds.xml</code> file (either        {@link
 * com.smartgwt.client.docs.serverds.OperationBinding#script per operation}, or as standard
 * handling for       {@link com.smartgwt.client.docs.serverds.DataSource#script all operations}).
 * DMI scripts allow you to add business       logic just like normal DMIs, but don't require the
 * logic to be in a separate .java       file.</li> </ul><br> <li>If you need to use a Front
 * Controller servlet for some other reason than authentication - for example, you are using
 * Spring some other similar system which requires that  all requests go through some particular
 * servlet - just call  <code>RPCManager.processRequest()</code> within your Spring Controller or 
 * whatever the equivalent is in the framework in use. <p> However, note carefully that taking
 * this approach is often a sign that the Smart GWT  architecture has not been correctly
 * understood.  Smart GWT is architected for  <em>client-server</em> data communication, as
 * opposed to early web MVC frameworks which  do everything on the server.  In particular, it is
 * absolutely incorrect to represent every  individual DataSource operation - or even every
 * DataSource - as a separate  Spring Controller because this implies different URLs for different
 * operations.  All  DataSource operations should go through a single URL in order to allow 
 * {@link com.smartgwt.client.rpc.RPCManager transaction queuing} - see these  @see <a
 * href="http://www.smartclient.com/smartgwtee/showcase/#transactionsFolder"
 * target="examples">Queuing examples</a>.</li> </ul> <P> For more information on the DMI
 * subsystem, see the {@link com.smartgwt.client.docs.DmiOverview DMI overview},  DMI class and
 * the  <a href="http://www.smartclient.com/smartgwtee/showcase/#dmi" target="examples">DMI
 * example</a> in the Feature Explorer. <P> Note that, as you continue to integrate your prototype
 * with your backend, you can use a mixture of DataSources that have been fully integrated with
 * your backend and DataSources that are running in "client-only" mode (see {@link
 * com.smartgwt.client.docs.ClientOnlyDataSources}). <P> <b>Important methods for handling
 * DataSource requests</b> <P> The basic flow of logic for handling DataSource requests is: <P>
 * <table class="normal" border=1 width="700"> <tr> <td>1. Determine operation type (Fetch, Add,
 * Update, Remove) for a single request.  Not  necessary if you follow the recommendations for 
 * {@link com.smartgwt.client.docs.WriteCustomDataSource writing a custom DataSource} and provide
 * your  implementation via <code>executeFetch(), executeAdd()</code>, et al.</td>
 * <td>dsRequest.getOperationType()</td> </tr> <tr> <td>2. Get inbound values (Add, Update) and/or
 * criteria (Fetch, Update, Remove) for this request.</td> <td>dsRequest.getFieldValue()<br>
 * dsRequest.getValues()<br>  dsRequest.getCriteria()</td> </tr> <tr> <td>3. Business logic,
 * validation, calls to data and service tiers... anything you can code. </td> <td><b>execute
 * custom logic</b></td> </tr> <tr> <td>4. Set status and data for the response.</td>
 * <td>dsResponse.setStatus()<br> dsResponse.setData()</td> </tr> </table> <P> For more
 * information, see the {@link com.smartgwt.client.rpc.RPCManager RPCManager documentation}, and
 * the  <a href="http://www.smartclient.com/smartgwtee/showcase/#orm_ds" target="examples">Custom
 * ORM DataSource example</a>.
 * @see com.smartgwt.client.types.DSDataFormat
 * @see com.smartgwt.client.types.DSServerType
 * @see com.smartgwt.client.data.DataSource#getDataFormat
 * @see com.smartgwt.client.data.DataSource#getDataProtocol
 * @see com.smartgwt.client.data.DataSource#getRequestProperties
 * @see com.smartgwt.client.docs.serverds.DataSource#serverType
 * @see com.smartgwt.client.docs.serverds.DataSource#tableName
 * @see com.smartgwt.client.docs.serverds.DataSource#quoteTableName
 * @see com.smartgwt.client.docs.serverds.DataSource#dbName
 * @see com.smartgwt.client.docs.serverds.DataSource#configBean
 * @see com.smartgwt.client.data.DataSource#getDefaultTextMatchStyle
 * @see com.smartgwt.client.docs.serverds.DataSource#defaultBooleanStorageStrategy
 * @see com.smartgwt.client.docs.serverds.DataSource#useAnsiJoins
 * @see com.smartgwt.client.docs.serverds.DataSource#audit
 * @see com.smartgwt.client.data.DataSource#getServerObject
 * @see com.smartgwt.client.data.OperationBinding#getRequestProperties
 * @see com.smartgwt.client.data.RestDataSource#getDataProtocol
 */
public interface ServerDataIntegration {
}
