
package com.smartgwt.client.docs;

/**
 * <h3>SQL DataSources</h3>
 * The Smart GWT Server supports comprehensive, codeless SQL connectivity for DataSources defined in XML.  Our SQL
 * connectivity is mature, feature-rich, protected against injection attacks and easily customizable to support
 * user-written SQL and additional business logic of any complexity.  {@link com.smartgwt.client.docs.SqlVsJPA This
 * article} compares the built-in SQL DataSource to other persistence approaches based on Javabeans. <P> To use the
 * built-in SQL engine, declare a {@link com.smartgwt.client.data.DataSource} in XML format with {@link
 * com.smartgwt.client.docs.serverds.DataSource#serverType serverType} set to "sql", and place it in the shared dataSources
 * directory ([webroot]/shared/ds by default) in a file called "[dataSourceId].ds.xml". <p> You can then use the {@link
 * com.smartgwt.client.docs.AdminConsole Admin Console} to configure database access, as well as to automatically create
 * and populate a database table based on your DataSource. By default, DataSources will use the "default database" from the
 * admin console, however you can set {@link com.smartgwt.client.docs.serverds.DataSource#dbName dbName} to the name of a
 * specific database configuration you have configured via the Admin Console. <P> The list of databases known to work with
 * the the built-in SQL logic is as follows: <p> <table class='normal'> <tr><td width=40></td><td width=200><i>HSQLDB
 * 1.7.x, 1.8.x, 2.x</i></td><td></td></tr> <tr><td></td><td><i>IBM DB2 8.x, 9.x</i></td><td></td></tr>
 * <tr><td></td><td><i>IBM DB2 on i5 (aka iSeries, AS/400) - V5R4M0 onwards</i></td><td></td></tr>
 * <tr><td></td><td><i>Firebird 2.5</i></td><td></td></tr> <tr><td></td><td><i>MS SQL Server 2000, 2005,
 * 2008</i></td><td></td></tr> <tr><td></td><td><i>MySQL 3.2.x, 4.0.x, 4.1.x, 5.0.x, 5.1.x, 5.5.x</i></td><td></td></tr>
 * <tr><td></td><td><i>Oracle 8.0.5, 8i, 9i, 10g, 11g</i></td><td></td></tr> <tr><td></td><td><i>PostgreSQL 7.x, 8.x,
 * 9.x</i></td><td></td></tr> </table> <p>We also support a generic SQL92 database connection which works for basic CRUD
 * operations with any database product that supports standard SQL92 syntax and data types, plus a couple  of
 * widely-implemented features that are not actually part of the standard.  Specifically, this means we do not support:<ul>
 * <li>Sequences</li> <li>Paging via SQL limit queries</li> <li>{@link
 * com.smartgwt.client.data.DataSource#getAutoJoinTransactions Automatic transaction management} <li>Long text values
 * (there is no real definition of "long" here - we try to use a standard VARCHAR, but different databases will support
 * different maximum values for this)</li> <li>Databases that do not implement the widely-supported LOWER() function</li>
 * <li>Databases that do not support the ability to perform string-type operations on numeric columns - for example,
 * <code>myNumericColumn LIKE '%5%'</code></li> </ul> <p>You will also need a JDBC driver for your specific database.
 * Licensing restrictions prevent us including any JDBC driver other than the one for HSQLDB.  However, you can download
 * these drivers for free from the vendors' websites.  If your specific database server or version is not listed above,
 * please go to the <a href="http://forums.smartclient.com">Smart GWT forums</a> for assistance. <P> You can also connect
 * to an existing database table - the Visual Builder DataSource Wizard ("New" button in DataSources pane) allows you to
 * pick an existing database table and have a DataSource generated from it.  The Batch DataSource Generator tool will allow
 * you to generate DataSources for any number of SQL DataSources, and customize the process so that organization-specific
 * rules are applied (eg ignoring certain columns, or using naming conventions to generate more complete DataSources). <P>
 * Once you have your SQL DataSource connected to a table, in a default SDK installation, DSRequests for your DataSource
 * will be sent to the default {@link com.smartgwt.client.rpc.RPCManager#actionURL actionURL}, and hence handled
 * automatically, without you having to write any Java code, by the {@link com.smartgwt.client.docs.ServletDetails IDACall
 * servlet registered in web.xml}. IDACall is a very simple servlet that just calls the server-side method
 * dsRequest.execute() for all inbound requests.  For more details on how DataSource requests are processed by Smart GWT
 * Server, and how you can alter and add to this processing, see this description of {@link
 * com.smartgwt.client.docs.ServerDataIntegration server data integration}.
 * @see com.smartgwt.client.data.DataSourceField#getSequenceName
 */
public interface SqlDataSource {
}
