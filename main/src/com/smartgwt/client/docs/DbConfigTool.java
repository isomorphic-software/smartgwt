
package com.smartgwt.client.docs;

/**
 * <h3>Database Configuration</h3>
 * DataSources that use Smart GWT's built-in {@link com.smartgwt.client.docs.SqlDataSource SQL
 * engine} refer to
 * configuration settings from the {@link com.smartgwt.client.docs.Server_properties
 * server.properties} file for
 *  database access.
 *  <P>
 * Developers may make use of the {@link com.smartgwt.client.docs.AdminConsole Admin Console tool}
 * to set up
 *  database configuration blocks, or they may add configuration settings to
 *  <code>server.properties</code> by hand. Note that you should restart your servlet engine
 *  after changing this file.
 *  <P>
 *  <b>Manually specifying database connection settings</b>
 *  <p>
 * Within an application deployment, the {@link com.smartgwt.client.docs.Server_properties
 * server.properties} 
 *  file resides in the <code>WEB-INF/classes</code> directory.
 *  <p>
 *  For each database, configuration settings within this file are prefixed with 
 *  <code>"sql.<i>&lt;dbName&gt;</i>"</code>.<br>
 *  For example, the following settings are the defaults in a new Smart GWT installation for
 *  a MySQL server; they are approximately correct for a MySQL server running on the same
 *  machine as the servlet engine and listening on the default MySQL port.  For details of what
 * each of these properties means, check {@link com.smartgwt.client.docs.SqlSettings this
 * page}.<pre>
 *    sql.Mysql.database.type: mysql
 *    sql.Mysql.database.ansiMode: false
 *    sql.Mysql.interface.type: dataSource
 *    sql.Mysql.driver: com.mysql.jdbc.jdbc2.optional.MysqlDataSource
 *    # name of the database to use
 *    sql.Mysql.driver.databaseName: isomorphic
 *    # hostname and port where the database server is installed
 *    sql.Mysql.driver.serverName: localhost
 *    sql.Mysql.driver.portNumber: 3306
 *    # username and password that can create and modify tables in that database
 *    # this user must have the following privileges for the system to function
 *    # properly: create/alter/drop table; insert/update/replace/delete rows.
 *    sql.Mysql.driver.user: root
 *    sql.Mysql.driver.password:
 *  </pre>
 *  Note the distinction here between database <em>type</em> and database <em>name</em>.  Database
 *  type refers to the actual product - Oracle, DB2 or whatever.  In the above example, database
 *  type is "mysql" (all lowercase) - the value of property <code>sql.Mysql.database.type</code>.
 *  Database type is very important.  The type of a given database connection dictates whether
 *  features like SQL paging and transactions are supported; it even dictates the syntax of the
 *  SQL we generate.
 *  <p>
 *  Database name is just an arbitrary name for a particular database connection, and it is
 *  embedded in the property names immediately after the <code>sql</code> prefix. In this example
 *  it happens to be very similar to the database type - "Mysql" as opposed to "mysql" - but in
 *  fact the name has no significance and could be any string.  When referring to specific
 *  database connections in your {@link com.smartgwt.client.data.DataSource DataSources} with the
 * {@link com.smartgwt.client.docs.serverds.DataSource#dbName dbName} property, it is the database
 * <em>name</em> you use.
 *  <p>
 *  NOTE: It is common for DataSources to not specify <code>dbName</code>.  In this case, the
 *  default database is used.  To specify the default database manually in
 * {@link com.smartgwt.client.docs.Server_properties server.properties}, set
 * <code>sql.defaultDatabase</code>, using database
 *  name.  So, to set our example connection from above as the default:<pre>
 *    sql.defaultDatabase: Mysql
 *  </pre>
 *  <P>
 *  <b>Manually specifying JNDI settings</b>
 *  <p>
 *  Instead of specifying database connection parameters directly in
 *  {@link com.smartgwt.client.docs.Server_properties server.properties},
 *  it is possible to connect to a database that is configured as a JNDI resource in your
 *  application server.  Assume you have an Oracle JNDI resource with the name "jndiTest",
 *  configured similar to this in Tomcat:
 *  <pre>
 *    &lt;Resource name="jdbc/jndiTest"
 *                     auth="Container"
 *                     type="javax.sql.DataSource"
 *                     driverClassName="oracle.jdbc.driver.OracleDriver"
 *                     url="jdbc:oracle:thin:@192.168.132.152:1521:xe"
 *                     username="system"
 *                     password="manager"
 *                     initialSize="5"
 *                     maxActive="50" /&gt;
 *  </pre>
 *  The minimal set of properties required to create a Smart GWT database connection that
 *  attaches to this resource is as follows (Note that the <code>java:comp/env/</code> prelude
 *  in the first line is optional - the server will automatically look there if it can't find
 *  the resource in the absolute location)
 *  <pre>
 *    sql.myOracleConnection.driver.name: java:comp/env/jdbc/jndiTest
 *    sql.myOracleConnection.database.type: oracle
 *    sql.myOracleConnection.interface.type: jndi
 *  </pre>
     * @see com.smartgwt.client.docs.AdminConsole
     * @see com.smartgwt.client.docs.Server_properties
     * @see com.smartgwt.client.docs.SqlConnectionPooling
     * @see com.smartgwt.client.docs.TestData
 */
public interface DbConfigTool {
}