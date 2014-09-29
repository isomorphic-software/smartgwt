
package com.smartgwt.client.docs;

/**
 * Various subsystems have a need to compare DataSource requests and understand if they are equivalent or affect the same
 * data (examples include  {@link com.smartgwt.client.data.ResultSet automatic cache synchronization} and  {@link
 * com.smartgwt.client.data.DataSource#getUseOfflineCache offline caching and synchronization}).   <P> Aside from basic
 * properties that would clearly make two DSRequests non-equivalent (dataSource, operationType and data, as well as sortBy,
 * startRow, endRow and textMatchStyle for a "fetch"), {@link com.smartgwt.client.data.DSRequest#getOperationId
 * operationId} is the only property that will cause two DSRequests to be considered distinct (non-equivalent) requests. 
 * <P> Bearing this in mind, the best practice is: <ul> <li> everything that will be treated as criteria or as values on
 * the server side should be part of {@link com.smartgwt.client.data.DSRequest#getData data}.  Do not "smuggle" data that
 * will ultimately be used as criteria or values in other dsRequest properties, such as  {@link
 * com.smartgwt.client.rpc.RPCRequest#getParams HTTP parameters}. <li> use {@link
 * com.smartgwt.client.data.DSRequest#getOperationId operationId} as the sole piece of information in the request that
 * modifies how the request as a whole is executed.  If two or more pieces of information are required, combine or encode
 * them into a single operationId String.  If this becomes awkward because there are many operation variants, consider
 * including additional fields in {@link com.smartgwt.client.data.DSRequest#getData data} instead. </ul>
 */
public interface DsRequestEquivalence {
}
