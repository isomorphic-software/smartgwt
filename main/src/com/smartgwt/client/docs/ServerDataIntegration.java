
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
 * JSON or other content. <P> <B>Handling DataSource Requests</B> <P> Client-side {@link
 * com.smartgwt.client.widgets.DataBoundComponent} will send {@link com.smartgwt.client.data.DSRequest} to the ISC server
 * as background communications transparent to the user.  Integrating SmartGWT's DataSource layer with your data model is a
 * matter of handling these DSRequests and sending back DSResponses, in order to fulfill the 4 basic operations of the
 * {@link com.smartgwt.client.docs.DataSourceOperations 'DataSource Protocol'}. <P> There are two approaches for routing
 * inbound dsRequests to your business logic: <dl> <dt>RPCManager dispatch</dt> <dd>inbound requests are handled by a
 * single dispatcher implemented as a Java servlet or .jsp.  The {@link com.smartgwt.client.rpc.RPCManager} is used to
 * retrieve requests and provide responses</dd> <dt>{@link com.smartgwt.client..DMI}</dt> <dd>XML declarations route
 * requests to existing business logic methods.  Inbound request data is adapted to method parameters, and method return
 * values are delivered as responses</dd> </dl> <P> Which approach you use is largely a matter of preference.  Direct
 * Method Invocation (DMI) may allow simple integration without writing any SmartGWT-specific server code. RPCManager
 * dispatch integration provides an earlier point of control, allowing logic that applies across different DataSource
 * operations to be shared more easily. <P> Whether using RPCManager dispatch or DMI request routing, you must return data
 * which,  translated to JavaScript via the rules described in com.isomorphic.js.JSTranslater.toJS(), matches the {@link
 * com.smartgwt.client.docs.DataSourceOperations 'response data required for the operationType'}. <P> For example, for a
 * "fetch" request, your return data should translate to an Array of JavaScript objects.  Your backend may be capable of
 * returning data in a number of ways - you should compare each format you can readily retrieve against the capabilities of
 * the JSTranslater.  Common options are to pass an XML document fragment or a Collection of Java Beans/POJOs directly to
 * DSResponse.setData(). <p> For "update" and "add" DataSource requests, the inbound data is intended to be permanently
 * stored.  If you are using a DataSource specified in XML format, you can run the validators you declared in the
 * DataSource by calling the DSRequest.validate() method.  Assuming the declared validation is passed, you can run custom
 * validation logic, if any, and finally create or update objects in your object model.  If you are using Beans/POJOs, the
 * method DataSource.applyProperties(map, bean) is an easy way to apply the validated values to an Object tree or XML
 * structure. <P> For more information on the DMI subsystem, see the {@link com.smartgwt.client..DMI} class and the  <a
 * href='/examples/server_integration/#customDataSourceIntegrationDMI'
 * onclick="window.open('/examples/server_integration/#customDataSourceIntegrationDMI');return false;">DMI example</a> in
 * the SDK. <P> Note that, as you continue to integrate your prototype with your backend, you can use a mixture of
 * DataSources that have been fully integrated with your backend and DataSources that are either running in "client-only"
 * mode (see {@link com.smartgwt.client.docs.ClientOnlyDataSources}) or that use ISC's built-in SQL connectivity (see
 * {@link com.smartgwt.client.docs.SqlDataSource}). <P> <b>RPCManager dispatch</b> <P> The basic flow of logic for handling
 * DataSource requests using RPCManager dispatch is: <P> <table class="normal" border=1> <tr> <td>1. Get current list of
 * requests from the client.</td> <td>rpcManager.getRequests()</td> </tr> <tr> <td>2. Determine operation type (Fetch, Add,
 * Update, Remove) for a single request.</td> <td>dsRequest.getOperationType()</td> </tr> <tr> <td>3. Get inbound values
 * (Add, Update) and/or criteria (Fetch, Update, Remove) for this request.</td> <td>dsRequest.getFieldValue()<br>
 * dsRequest.getValues()<br>  dsRequest.getCriteria()</td> </tr> <tr> <td>4. Business logic, validation, calls to data and
 * service tiers... anything you can code. </td> <td><b>execute custom logic</b></td> </tr> <tr> <td>5. Set status and data
 * for the response.</td> <td>dsResponse.setStatus()<br> dsResponse.setData()</td> </tr> <tr> <td>6. Send response to the
 * client.</td> <td>rpcManager.send()</td> </tr> </table> <P> For more information, see the {@link
 * com.smartgwt.client.rpc.RPCManager}, and the  <a href='/examples/server_integration/#customDataSourceIntegration'
 * onclick="window.open('/examples/server_integration/#customDataSourceIntegration');return false;">RPCManager example</a>.
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
