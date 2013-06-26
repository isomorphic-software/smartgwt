
package com.smartgwt.client.docs;

/**
 * <h3>DataSource Operations</h3>
 * A DataSource Operation is a type of {@link com.smartgwt.client.docs.Operations operation} that
 * acts on the set of stored objects represented by a {@link com.smartgwt.client.data.DataSource},
 * performing one of the basic actions that makes sense on a set of similar records: "fetch",
 * "add", "update" or "remove".  There is also a fifth DataSource Operation, "custom", which is
 * intended for arbitrary server operations that are more complex than a fetch of some records, or
 * an update to a single record. <P> Each DataSource operation has specific request and response
 * data, for example, in the "fetch" DataSource operation, the request data is expected to be
 * search criteria, and the response data is expected to be a list of matching DataSource records.
 * Listed below are the request data and response data for each DataSource operation type, and
 * what they mean.   <P> DataSource records are represented on the client by a JavaScript Object,
 * where each property in the Object maps a DataSource field name to the field value - hence the
 * DataSource operations below are in essence a way of exchanging records from client to server
 * and back. <P> If you are using {@link com.smartgwt.client.docs.ServerDataIntegration
 * server-side data integration} with the Smart GWT Java server, see the
 * ${isc.DocUtils.linkForDocNode('javaServerReference', 'Java Server Reference')} for information
 * about how DataSource Requests arrive on the server (specifically
 * com.isomorphic.datasource.DSRequest) and how to provide responses  (specifically
 * com.isomorphic.datasource.DSResponse.setData()). <P> If you are using {@link
 * com.smartgwt.client.docs.ClientDataIntegration client-side data integration} to directly
 * consume services that use XML, JSON or other formats, see the "Editing and Saving" section of
 * the {@link com.smartgwt.client.docs.ClientDataIntegration client-side data integration} topic.
 * <P> <b>fetch</b> <ul> <li>Request data: filter criteria, as an Object <li>Response data:
 * matching records, as an Array of Objects </ul> <b>add</b> <ul> <li>Request data: new record, as
 * an Object <li>Response data: new record as stored, as an Object </ul> <b>update</b> <ul>
 * <li>Request data: primary keys of record to update, and new values (or just complete updated
 * record), as an Object <li>Response data: new record as stored, as an Object </ul> <b>remove</b>
 * <ul> <li>Request data: primary keys of record to delete, as an Object <li>Response data:
 * minimally the primary keys of deleted record (can be complete record), as an Object </ul>
 * <b>custom</b> <ul> <li>Request data: whatever the custom operation requires <li>Response data:
 * custom operations can return whatever they like, including nothing.   Custom operations are
 * like RPC calls in this respect - the exchanged data is unstructured,  so it is up to you to
 * make sure the client and server agree.  Note also that, because of this unstructured data
 * exchange, cache synchronization does not work with custom operations. </ul>
 */
public interface DataSourceOperations {
}
