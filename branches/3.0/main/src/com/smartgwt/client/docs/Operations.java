
package com.smartgwt.client.docs;

/**
 * <h3>Operations Overview</h3>
 * Smart GWT Operations are dynamic, transparent communications made from the client-side Smart GWT system running in the
 * browser, to the server-side Smart GWT system running in a servlet engine, or to other non-Smart GWT servers available
 * via HTTP. Operations are used to load new data or new behavior into a running Smart GWT application. Operations are also
 * used to save data entered by users, and in general, to get the result of any process which must be run on the server for
 * security reasons. <br><br> <b>RPC Operations</b> <br><br> RPC Operations are low-level communications that send and
 * retrieve arbitrary data.  RPC Operations are supported by the {@link com.smartgwt.client.rpc.RPCManager} class, which
 * when used with the Smart GWT server, provides Java to JavaScript {@link com.smartgwt.client.rpc.RPCRequest#getData 2-way
 * translation} of basic data structures.  The RPCManager also provides a mechanism for client-side code to be invoked when
 * an operation completes (called a "callback").  RPC Operations are intended for unstructured data; data that is
 * ultimately destined for display in Smart GWT components will generally come from DataSource operations. <br><br>
 * <b>DataSource Operations and DataBound Components</b> <br><br> A {@link com.smartgwt.client.docs.DataSourceOperations
 * DataSource Operation} is an operation that acts on a DataSource, performing one of the basic actions that makes sense on
 * a set of similar records: "fetch", "add", "update" or "remove".  Unlike RPC operations, DataSource operations have
 * specific request data and response data, for example, in the "fetch" DataSource operation, the request data is expected
 * to be search criteria, and the response data is expected to be a list of matching DataSource records.  Although
 * DataSource operations can be invoked manually from the client, they are generally automatically invoked by DataBound
 * components. <br><br> DataBound Components are components that understand DataSources.  Databound components configured
 * with a DataSource are able to offer complete user interactions without further configuration (extensive customization is
 * also supported). <br><br> For example, given a DataSource, the ListGrid component supports a sophisticated inline
 * editing interaction, complete with automatically chosen editors like date pickers for dates, type-aware validation,
 * saving, and error reporting.  <br><br> A DataBound component supporting an interaction such as inline editing will
 * automatically submit DataSource operations to the server at appropriate times. <br><br> <b>DataSource Operation
 * Integration</b> <br><br> Integrating DataSource operations with an existing system is best approached by implementing
 * the the 4 basic DataSource operations in terms of your existing object model or data store. With these 4 operations
 * implemented, the entire range of user interactions supported by Smart GWT {@link
 * com.smartgwt.client.widgets.DataBoundComponent databinding-capable components} becomes applicable to your server.  At
 * that point authentication, authorization and other business rules can be layered on top. <br><br> <b>Built-in SQL
 * Connectivity</b> <br><br> The Smart GWT Server comes with a built-in {@link com.smartgwt.client.docs.SqlDataSource
 * SQLDataSource} which can be used without any server-side code needing to be written.  In contrast, any operation which
 * uses custom server-side code is called a "Custom Operation". <br><br> Generally it makes sense to prototype an
 * application using Built-in DataSource Operations, then on the backend, create Custom DataSource Operations to retrieve
 * data from the data store you will use in production (though don't rule out using the SQL DataSource in  production - see
 * {@link com.smartgwt.client.docs.SqlVsJPA this discussion} of the advantages of doing so}.   As you switch from using
 * Built-in DataSources to Custom Operations, no client-side code  changes will be required, because the client cares only
 * about the DataSource definition,  not the data store which the data is ultimately retrieved from. <br><br> <b>Data
 * Managers: ResultSet and ResultTree</b> <br><br> Data Managers manage datasets retrieved from DataSources.  Data Managers
 * are automatically created by DataBound components, but can be created directly when more control is needed. <br><br>
 * Data Managers provide load-on-demand for datasets too large to be loaded on the client, automatically invoking
 * DataSource operations as necessary to retrieve data as it is requested, and optionally fetching ahead to anticipate
 * further requests.   Data Managers will automatically perform actions locally when it is possible, for example, a sort
 * action can be performed locally with a complete cache.  Data Managers also automatically manage the consistency of the
 * client-side cache, observing update operations performed against DataSources and integrating updated rows automatically.
 * <br><br>
 * @see com.smartgwt.client.data.DataSource#fetchData
 * @see com.smartgwt.client.data.DataSource#filterData
 * @see com.smartgwt.client.data.DataSource#exportData
 * @see com.smartgwt.client.data.DataSource#addData
 * @see com.smartgwt.client.data.DataSource#updateData
 * @see com.smartgwt.client.data.DataSource#removeData
 * @see com.smartgwt.client.data.DataSource#validateData
 * @see com.smartgwt.client.data.DataSource#performCustomOperation
 * @see com.smartgwt.client.rpc.RPCManager#handleError
 * @see com.smartgwt.client.data.DSRequest#getOperationId
 */
public interface Operations {
}
