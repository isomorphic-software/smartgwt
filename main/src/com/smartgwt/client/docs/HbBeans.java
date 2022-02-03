
package com.smartgwt.client.docs;

/**
 * <h3>Beans and the DSRequest / DSResponse</h3>
 * This section relates to JPA and Hibernate datasources and describes how submitted data  is used
 * and what to expect in <code>DSResponse</code> if Smartclient is integrated with  Hibernate
 * using "Pre-existing beans" approach (see {@link com.smartgwt.client.docs.HibernateIntegration}
 * for details). <p> Note that "beanless" integration mode is completely omitted here, since in
 * that case data is  represented by <code>Maps</code> instead of <code>Beans</code>. <p> <h3>Data
 * sent in DSRequest</h3> In case of add or update operations {@link
 * com.smartgwt.client.data.DSRequest#getData DSRequest data} is used to populate  associated
 * <code>Bean</code>: <ul>   <li>add - new <code>Bean</code> is created and filled with submitted
 * data</li>   <li>update - existing <code>Bean</code> is retrieved and then submitted data is set
 * overwriting  existing values</li> </ul> New values are applied using
 * <code>DataSource.setProperties(...)</code> server-side API, which performs  automatic
 * conversions of any types that can reasonably be auto-converted, supports inner beans and 
 * recursive data structures, see server-side javadocs for details. <p> <h3>Data returned in
 * DSResponse</h3> In case of getting access to DSResponse (for example, by manually executing
 * DSRequest in a DMI),  DSResponse data can be accessed by calling
 * <code>DSResponse.getData()</code> server-side API. See what  data will be returned depending on
 * {@link com.smartgwt.client.data.DSRequest#getOperationType operation type} and other
 * circumstances: <p> <table border="1" class="normal" width="90%" cellpadding="5"> <tr>  
 * <td>Operation type</td>   <td>DSResponse data</td> </tr><tr>   <td width="20%">Fetch</td>  
 * <td>Generally fetch operation will return <code>List</code> of <code>Beans</code> or empty 
 * <code>List</code> if no records were found. However some features, if used, do break this rule:
 * <ul>       <li>If {@link com.smartgwt.client.data.DSRequest#getOutputs DSRequest.outputs} (or
 * {@link com.smartgwt.client.docs.serverds.OperationBinding#outputs OperationBinding.outputs}) is
 * set, then only  fields listed in outputs are fetched from Database and, accordingly, DSResponse
 * data will return   <code>List</code> of <code>Maps</code> each <code>Map</code> holding only
 * requested set of  field/value pairs.</li>       <li>If Server Summaries feature is used, then
 * DSResponse data will also return  <code>List</code> of <code>Maps</code> each <code>Map</code>
 * holding only field/value pairs involved in summary query, i.e. only fields listed in {@link
 * com.smartgwt.client.data.DSRequest#getGroupBy DSRequest.groupBy} and  {@link
 * com.smartgwt.client.data.DSRequest#getSummaryFunctions DSRequest.summaryFunctions}, see {@link
 * com.smartgwt.client.docs.ServerSummaries Server Summaries overview} for details.<p>     </ul>  
 * </td> </tr><tr>   <td width="20%">Add</td>   <td>     Add operation will return created
 * <code>Bean</code>.   </td> </tr><tr>   <td width="20%">Update</td>   <td>     If multiple
 * records update is allowed (see {@link
 * com.smartgwt.client.docs.serverds.OperationBinding#allowMultiUpdate
 * OperationBinding.allowMultiUpdate} and  {@link com.smartgwt.client.types.MultiUpdatePolicy}}),
 * then update operation will return <code>List</code> of <code>Beans</code>, or empty
 * <code>List</code> if no records were actually updated. If multiple records update is not 
 * allowed, then update operation will return updated <code>Bean</code>, or <code>null</code> if 
 * record was not updated (for example, in case if it does not exist).   </td> </tr><tr>   <td
 * width="20%">Remove</td>   <td>     If multiple records update is allowed, then remove operation
 * will always return <code>null</code>. If  multi records update is not allowed, then remove
 * operation will return a <code>Map</code> holding field/value  pairs for {@link
 * com.smartgwt.client.data.DataSourceField#getPrimaryKey Primary Key fields} of the record
 * requested to be removed, no matter  if the record was actually removed. Consult
 * <code>DSResponse.getAffectedRows()</code> server-side API to see if  the record was removed, or
 * how many records were removed in case of multiple records removal.   </td> </tr> </table>
 */
public interface HbBeans {
}
