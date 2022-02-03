
package com.smartgwt.client.docs;

/**
 * <h3>Declarative Security</h3>
 * The Declarative Security system allows you to attach role based access control to DataSource
 * operations and DataSource fields, as well as create a mix of authenticated and non
 * authenticated operations for applications that support limited publicly accessible
 * functionality. <p> See the <a href='/docs/SmartGWT_Quick_Start_Guide.pdf'
 * target='_blank'>QuickStart Guide</a> for more in depth documentation on how declarative
 * security works and how to use it in your application. <p> See {@link
 * com.smartgwt.client.docs.StandaloneDataSourceUsage Standalone DataSource Usage} for information
 * on how to use declarative security in a standalone application. <p> <b>NOTE:</b> Declarative
 * security only works for DataSource operations (including DataSource DMI operations).  If you
 * want to limit access to an ordinary RPC-DMI method - so it can only  be called by authenticated
 * users, only users with a certain role, etc - you have two choices:<ul> <li>Have your DMI method
 * accept a parameter of type <code>HttpServletRequest</code>; that will cause Smart GWT to pass
 * the current servlet request into your method, and you can directly  call the
 * <code>getRemoteUser()</code> and <code>isUserInRole()</code> methods to implement  your own
 * security</li> <li>Migrate your RPC-DMIs to DataSource DMI operations and get full declarative
 * security  support that way.  Note that <b>any</b> plain RPC-DMI function can be reworked as a
 * DataSource DMI operation; even if your RPC-DMI manifestly is not fetching a dataset or updating
 * a  record, you can use a {@link com.smartgwt.client.data.DataSource#performCustomOperation
 * custom operation}</li> </ul> <p> Requests that fail to pass Declarative Security checks will
 * return response with  {@link com.smartgwt.client.rpc.RPCResponse#STATUS_AUTHORIZATION_FAILURE
 * special status set}.
     * @see com.smartgwt.client.docs.StandaloneDataSourceUsage
 * @see com.smartgwt.client.docs.serverds.DataSource#requiresAuthentication
 * @see com.smartgwt.client.docs.serverds.DataSource#requiresRole
 * @see com.smartgwt.client.docs.serverds.DataSource#requires
 * @see com.smartgwt.client.docs.serverds.DataSource#creatorOverrides
 * @see com.smartgwt.client.docs.serverds.DataSourceField#viewRequiresAuthentication
 * @see com.smartgwt.client.docs.serverds.DataSourceField#editRequiresAuthentication
 * @see com.smartgwt.client.docs.serverds.DataSourceField#initRequiresAuthentication
 * @see com.smartgwt.client.docs.serverds.DataSourceField#updateRequiresAuthentication
 * @see com.smartgwt.client.docs.serverds.DataSourceField#viewRequiresRole
 * @see com.smartgwt.client.docs.serverds.DataSourceField#editRequiresRole
 * @see com.smartgwt.client.docs.serverds.DataSourceField#initRequiresRole
 * @see com.smartgwt.client.docs.serverds.DataSourceField#updateRequiresRole
 * @see com.smartgwt.client.docs.serverds.DataSourceField#viewRequires
 * @see com.smartgwt.client.docs.serverds.DataSourceField#editRequires
 * @see com.smartgwt.client.docs.serverds.DataSourceField#initRequires
 * @see com.smartgwt.client.docs.serverds.DataSourceField#updateRequires
 * @see com.smartgwt.client.docs.serverds.DataSourceField#creatorOverrides
 * @see com.smartgwt.client.docs.serverds.OperationBinding#requiresAuthentication
 * @see com.smartgwt.client.docs.serverds.OperationBinding#requiresRole
 * @see com.smartgwt.client.docs.serverds.OperationBinding#requires
 * @see com.smartgwt.client.docs.serverds.OperationBinding#creatorOverrides
 */
public interface DeclarativeSecurity {
}
