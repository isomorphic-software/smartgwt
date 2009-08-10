
package com.smartgwt.client.docs;

/**
 * Server Data Integration means: <ul> <li> You {@link com.smartgwt.client.docs.IscInstall 'install'} the {@link
 * com.smartgwt.client.docs.IscServer 'SmartGWT Java Server'} into any J2SE/J2EE environment <li> You {@link
 * com.smartgwt.client.docs.DataSourceDeclaration 'create DataSources'} in either XML or JavaScript, possibly on-the-fly
 * from {@link com.smartgwt.client.docs.MetadataImport 'existing metadata'}.   <li> When you bind {@link
 * com.smartgwt.client.widgets.DataBoundComponent} to these DataSources, the {@link com.smartgwt.client.data.DSRequest}
 * issued by these components will be transmitted to the server using a proprietary HTTP-based protocol, and the DataSource
 * responses likewise sent back via a proprietary protocol <li> You will use SmartGWT server APIs to receive the request
 * data as Java Objects, and you will provide response data as Java Objects </ul> This approach is in contrast to  {@link
 * com.smartgwt.client.docs.ClientDataIntegration 'Client-side Data Integration'}, which does not require the SmartGWT
 * server, and in which client-side DataSources are configured to directly send and receive HTTP messages containing XML,
 * JSON or other content. <P> <B>Server-side Request Processing</B> <P> Client-side {@link
 * com.smartgwt.client.widgets.DataBoundComponent} will send {@link com.smartgwt.client.data.DSRequest} to the SmartGWT
 * Server as background communications transparent to the user.  Integrating SmartGWT's DataSource layer with your data
 * model is a matter of handling these DSRequests and sending back DSResponses, in order to fulfill the 4 basic operations
 * of the {@link com.smartgwt.client.docs.DataSourceOperations 'DataSource Protocol'}. <P> Out of the box, SmartGWT is set
 * up to route all DSRequests through a special servlet called <code>IDACall</code>.  Requests that go through
 * <code>IDACall</code> have the  following lifecycle: <ul> <li>The overall HTTP request is received by the IDACall
 * servlet.  SmartGWT supports  queuing of transactions, so each HTTP request might contain multiple DSRequests.</li>
 * <li>IDACall sets up an instance of <code>RPCManager</code> to manage the processing of the entire queue of transactions.
 * For every DSRequest in the queue, this RPCManager:</li>   <ul>   <li>Validates the DSRequest</li>   <li>Sends the
 * DSRequest through {@link com.smartgwt.client..DMI} - in other words, your code - if this is        configured in the
 * DataSource.  As described later in this section, it is possible        for your code to perform some custom logic and
 * then call back into the normal,       non-DMI process flow</li>   <li>Calls the DataSource's <code>execute</code>
 * method</li>   <li>Creates a DSResponse object with an appropriate status and set of data</li>   </ul> <li>The RPCManager
 * now serializes all the DSResponses to Javascript and sends them back to the browser in one turnaround</li> </ul> <p> We
 * recommend that you do not customize this basic process flow; almost any customization you might need can be handled with
 * overrides at various points within or outside this flow: <ul> <li>If you need an overarching authentication service,
 * this is best implemented using  <a href=http://java.sun.com/products/servlet/Filters.html>servlet Filters</a> to
 * intercept unauthenticated requests before they reach the <code>IDACall</code> servlet</li> <li>If you are not using one
 * of the built-in persistence mechanisms (SQL and Hibernate),  hook into the <code>IDACall</code> flow by  {@link
 * com.smartgwt.client.docs.WriteCustomDataSource 'writing a custom DataSource'}.  This approach lets you write and  own
 * the minimal amount of customized code, whilst at the same time taking full advantage of DataSource-agnostic features of
 * the SmartGWT Server, like validation, queuing, transaction chaining, support for Velocity templating, and so on.</li>
 * <li>Custom validation can be added by writing a custom DataSource (extending SQLDataSource or HibernateDataSource if
 * appropriate) and overriding its <code>validate()</code> method,  as described {@link
 * com.smartgwt.client.data.DataSource#getServerConstructor 'here'}.</li> <li>General custom business logic can be added in
 * a number of ways, both declaratively and programmatically:</li> <ul>   <li>The &lt;criteria&gt; and &lt;values&gt;
 * properties of an {@link com.smartgwt.client.data.OperationBinding}        allow you to dynamically set data values at
 * transaction-processing time, using        built-in {@link com.smartgwt.client.docs.VelocitySupport 'Velocity
 * support'}</li>   <li>Override the <code>execute()</code> method of the DataSource to add extra processing       before
 * and/or after the SmartGWT processing</li>   <li>Use {@link com.smartgwt.client.data.DataSource#getValue 'Transaction
 * Chaining'} to dynamically set data values        according to the results of earlier transactions   <li>For SQL
 * DataSources, use {@link com.smartgwt.client.docs.CustomQuerying 'SQL Templating'} to change, add        to or even
 * completely replace the SQL sent to the database</li>   <li>Use {@link com.smartgwt.client..DMI} to call directly into
 * your own Java        classes.  As descibed in the DMI discussion linked to above, DMI calls can be used        in
 * conjunction with normal <code>DSRequest</code> process flow, thus enabling you       to add custom logic to built-in
 * DataSources without having to create your own        overridden versions of them</li> </ul><br> <li>If you need to use a
 * Front Controller servlet for some other reason than authentication - for example, you are using Spring, Struts, or some
 * other similar system which requires that  all requests go through some particular servlet - just call 
 * <code>RPCManager.processRequest()</code> within your Spring Controller, Struts Action, or  whatever the equivalent is in
 * the framework in use. <p> However, note carefully that taking this approach is often a sign that the SmartGWT 
 * architecture has not been correctly understood.  SmartGWT is architected for  <em>client-server</em> data communication,
 * as opposed to traditional MVC frameworks which  do everything on the server.  In particular, it is absolutely incorrect
 * to represent every  individual DataSource operation - or even every DataSource - as a separate Struts Action  or Spring
 * Controller, because this implies different URLs for different operations.  All  DataSource operations should go through
 * a single URL in order to allow  {@link com.smartgwt.client.rpc.RPCManager} - see these 
 * ${isc.DocUtils.linkForExampleId('transactionsFolder', 'Queuing examples')}.  Creating a single custom DataSource class
 * is the right approach.</li> </ul> <P> For more information on the DMI subsystem, see the {@link
 * com.smartgwt.client..DMI} class and the  ${isc.DocUtils.linkForExampleId('DMI', 'DMI example')} in the Feature Explorer.
 * <P> Note that, as you continue to integrate your prototype with your backend, you can use a mixture of DataSources that
 * have been fully integrated with your backend and DataSources that are running in "client-only" mode (see {@link
 * com.smartgwt.client.docs.ClientOnlyDataSources}). <P> <b>Important methods for handling DataSource requests</b> <P> The
 * basic flow of logic for handling DataSource requests is: <P> <table class="normal" border=1 width="700"> <tr> <td>1.
 * Determine operation type (Fetch, Add, Update, Remove) for a single request.  Not  necessary if you follow the
 * recommendations for  {@link com.smartgwt.client.docs.WriteCustomDataSource 'writing a custom DataSource'} and provide
 * your  implementation via <code>executeFetch(), executeAdd()</code>, et al.</td> <td>dsRequest.getOperationType()</td>
 * </tr> <tr> <td>2. Get inbound values (Add, Update) and/or criteria (Fetch, Update, Remove) for this request.</td>
 * <td>dsRequest.getFieldValue()<br> dsRequest.getValues()<br>  dsRequest.getCriteria()</td> </tr> <tr> <td>3. Business
 * logic, validation, calls to data and service tiers... anything you can code. </td> <td><b>execute custom logic</b></td>
 * </tr> <tr> <td>4. Set status and data for the response.</td> <td>dsResponse.setStatus()<br> dsResponse.setData()</td>
 * </tr> </table> <P> For more information, see the {@link com.smartgwt.client.rpc.RPCManager}, and the 
 * ${isc.DocUtils.linkForExampleId('ormDataSource', 'Custom ORM DataSource example')}.
 * @see com.smartgwt.client.data.DataSource#getDataFormat
 * @see com.smartgwt.client.data.DataSource#getDataProtocol
 * @see com.smartgwt.client.data.DataSource#getRequestProperties
 * @see com.smartgwt.client.data.DataSource#getServerType
 * @see com.smartgwt.client.data.DataSource#getTableName
 * @see com.smartgwt.client.data.DataSource#getDbName
 * @see com.smartgwt.client.data.DataSource#getServerObject
 * @see com.smartgwt.client.data.OperationBinding#getRequestProperties
 * @see com.smartgwt.client.types.DSDataFormat
 * @see com.smartgwt.client.types.DSServerType
 */
public interface ServerDataIntegration {
}
