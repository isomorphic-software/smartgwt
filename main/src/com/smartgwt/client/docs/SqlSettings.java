
package com.smartgwt.client.docs;

/**
 * <h3>SQL Database Settings in <code>server.properties</code></h3>
 * Although the Admin Console provides a UI to let you to configure database access for 
 * DataSources that use Smart GWT's built-in {@link com.smartgwt.client.docs.SqlDataSource SQL
 * engine}, it is 
 *  also possible to configure these DataSources with manual entries in your 
 *  {@link com.smartgwt.client.docs.Server_properties server.properties} file.
 *  <p>
 *  When you manually configure a DataSource like this, you do so by maintaining a set of 
 *  properties with names structured like this:
 *  <pre>   sql.{dbName}.x.y
 *  </pre>
 *  where <code>{dbName}</code> is the name of the database configuration you are providing.
 *  Note that this database name is just an arbitrary name for a particular database 
 *  configuration; many of the default ones provided with Smart GWT are named after a database
 *  <em>type</em>, in order to make their intended use more immediately obvious, but this is 
 *  not by any means a requirement.
 *  <p>
 *  For the remainder of this discussion, we will assume we are configuring a database with a 
 *  name of "MyDatabase".
 *  <p>
 *  <h4>SQL configuration properties</h4><p>
 *  <b><code>sql.MyDatabase.database.type</code></b><br>
 *  This should be set to one of the supported database types.  These are:<p>
 *  <table style="font-size:10px">
 *  <tr><td><b>hsqldb</b></td><td>HSQLDB 1.7.x and greater</td></tr>
 *  <tr><td><b>db2</b></td><td>IBM DB2 8.x and greater</td></tr>
 *  <tr><td><b>db2iSeries</b></td><td>IBM DB2 for iSeries/i5, V5R4 and greater</td></tr>
 *  <tr><td><b>firebirdsql</b></td><td>Firebird 2.5 and greater</td></tr>
 *  <tr><td><b>informix</b></td><td>Informix 11.5 and greater</td></tr>
 *  <tr><td><b>sqlserver</b></td><td>Microsoft SQL Server 2000 and greater</td></tr>
 *  <tr><td><b>mysql</b></td><td>MySQL 3.2.x and greater</td></tr>
 *  <tr><td><b>mariadb</b></td><td>MariaDB 5.1 and greater</td></tr>
 *  <tr><td><b>oracle</b></td><td>Oracle 8.0.5, 8i and greater</td></tr>
 *  <tr><td><b>postgresql</b></td><td>PostgreSQL 7.x and greater</td></tr>
 *  <tr><td><b>generic</b></td><td>A generic SQL92 database, with limitations described in
 *  {@link com.smartgwt.client.docs.SqlDataSource this article}</td></tr>
 *  </table><p>
 *  <code><b>sql.MyDatabase.driver</b></code><br>
 *  The name of the JDBC driver implementation.  This depends upon your database product and 
 *  version, and the specific JDBC driver you are using (JDBC drivers can usually be downloaded
 *  from your database vendor's website).  Bearing in mind the caveat that this information can
 *  vary by release and JDBC implementation, here are some suggested values for our supported 
 *  databases:<p>
 *  <table style="font-size:10px">
 *  <tr><td><b>hsqldb</b></td><td><code>org.hsqldb.jdbcDriver</code></td></tr>
 *  <tr><td><b>db2</b></td><td><code>com.ibm.db2.jcc.DB2DataSource</code></td></tr>
 *  <tr><td><b>db2iSeries</b></td><td><code>com.ibm.as400.access.AS400JDBCDriver</code></td></tr>
 *  <tr><td><b>firebirdsql</b></td><td><code>org.firebirdsql.jdbc.FBDriver</code></td></tr>
 *  <tr><td><b>informix</b></td><td><code>com.informix.jdbc.IfxDriver</code></td></tr>
 *  <tr><td><b>sqlserver</b></td><td><code>com.microsoft.jdbc.sqlserver.SQLServerDriver</code> or 
 *  <code>com.microsoft.sqlserver.jdbc.SQLServerDriver</code> (Microsoft changed the order of 
 *  "jdbc" and "sqlserver" between the 2000 and 2005 editions of the product)</td></tr>
 * <tr><td><b>mysql</b></td><td><code>com.mysql.jdbc.jdbc2.optional.MysqlDataSource</code></td></tr>
 *  <tr><td><b>mariadb</b></td><td><code>org.mariadb.jdbc.MariaDbDataSource</code></td></tr>
 *  <tr><td><b>oracle</b></td><td><code>oracle.jdbc.driver.OracleDriver</code></td></tr>
 *  <tr><td><b>postgresql</b></td><td><code>org.postgresql.Driver</code></td></tr>
 *  </table><p>
 *  <code><b>sql.MyDatabase.driver.serverName</b></code><br>
 *  The name or IP address of the database server
 *  <p>
 *  <code><b>sql.MyDatabase.driver.portNumber</b></code><br>
 *  The port on which the database server is listening
 *  <p>
 *  <code><b>sql.MyDatabase.driver.user</b></code><br>
 *  The user to connect as
 *  <p>
 *  <code><b>sql.MyDatabase.driver.password</b></code><br>
 *  The user's password
 *  <p>
 *  <code><b>sql.MyDatabase.driver.databaseName</b></code><br>
 *  The database to connect to.  A "database" in this context is a named collection of tables
 *  and other database resources that are somehow grouped together by the database product.
 *  The specifics of how this is implemented vary by database.  Note that some database 
 *  products use the terms "catalog" or "schema" to refer to the same concept, and Oracle - 
 *  although it does also have a concept of catalog - uses the term "SID" for this concept.<p>
 *  <code><b>sql.MyDatabase.interface.type</b></code><br>
 *  Indicates how the JDBC connection will be created or looked up; the value of this setting 
 *  depends on the capabilities of the particular JDBC driver you are using, and is inherently
 *  connected to the value of <code>sql.MyDatabase.driver</code>.  The following settings are 
 *  supported:<p>
 *  <b>dataSource</b> - the driver is an instance of <code>javax.sql.DataSource</code> and 
 *  should be instantiated by Smart GWT Server<br>
 *  <b>driverManager</b> - the driver is an instance of <code>java.sql.DriverManager</code><br>
 *  <b>jndi</b> - the driver is an instance of <code>javax.sql.DataSource</code> and should be 
 *  looked up using JNDI<br>
 *  <b>spring</b> - the driver is an instance of <code>javax.sql.DataSource</code> and should
 *  be obtained from the Spring context using bean id defined in
 *  <code>sql.MyDatabase.spring.dataSourceBean</code> setting. For example:<br>
 *  <i>sql.MyDatabase.database.type: mysql</i><br>
 *  <i>sql.MyDatabase.interface.type: spring</i><br>
 *  <i>sql.MyDatabase.spring.dataSourceBean: springDataSourceBeanId</i><p>
 *  <code><b>sql.MyDatabase.driver.url</b></code><br>
 *  For configurations where <code>sql.MyDatabase.interface.type</code> is "driverManager", 
 *  this property allows you to manually enter the URL we use to connect to the database.  If 
 *  this property is not provided, we build the URL from other settings such as 
 *  <code>sql.MyDatabase.driver.serverName</code> and 
 *  <code>sql.MyDatabase.driver.databaseName</code>.<p>
 * 
 *  <b>Other properties</b><br>
 *  Different JDBC drivers support different properties to support product-specific quirks and
 *  features.  You can often specify these properties by embedding them as parameters in the 
 *  URL used to connect to the database.<p>
 * 
 *  Alternatively, any subproperty you set on the "driver" in server.properties is applied to 
 *  the JDBC driver object via Reflection. For example, the MySQL JDBC driver supports a property
 *  "useUnicode", which forces the database to use Unicode character encoding.  If 
 * <code>sql.MyDatabase.driver</code> is
 * <code>com.mysql.jdbc.jdbc2.optional.MysqlDataSource</code>,
 *  setting <code>sql.MyDatabase.driver.useUnicode</code> to true means we'll attempt to call 
 *  <code>setUseUnicode(true)</code> on this class.  This would have exactly the same effect as
 * defining the connection URL manually and specifying the parameter
 * <code>useUnicode=true</code>.<p>
 * 
 *  Mysql vs MariaDB: there is broad compatibility between these two databases as described in
 * <a href='https://mariadb.com/kb/en/library/mariadb-vs-mysql-compatibility/'
 * target='_blank'>https://mariadb.com/kb/en/library/mariadb-vs-mysql-compatibility/</a>.  Within
 *  the bounds of that compatibility matrix, you can use database.type 'mysql' and 'mariadb' 
 *  interchangeably, and likewise with the drivers that you use.  However for future compatibility
 * it is recommended that you use <code>database.type: mariadb</code> for MariaDB.  This will
 * ensure
 *  that as MariaDB implements new features and backompat breaking changes, your application won't
 * run into any gotchas because the Smart GWT server logic will automatically use the right
 * feature
 *  set to accomplish documented behavior.<p>
 * 
 *  <h4>Smartclient properties</h4><p>
 *  <b><code>sql.mysql.optimizeCaseSensitivityCriteria</code></b><br>
 * <i>This setting affects all <b>MySQL</b> connectors.</i> Depending on {@link
 * com.smartgwt.client.types.TextMatchStyle textMatchStyle} case
 * sensitivity in text criteria is achieved by using LIKE BINARY sql comparison operator, which
 * does not
 * use indexed search. Indexes are used with regular "=" comparison operator, which does not
 * ensure case
 * sensitivity. With big amounts of data indexes are critical, so in order to use them and still
 * have
 *  case sensitivity supported this setting must be set to <code>true</code>.
 *  This way we would generate comparison expression like:<br>
 *  <code>&lt;field&gt; = &lt;value&gt; AND &lt;field&gt; LIKE BINARY &lt;value&gt;</code><br>
 * where first part ensures efficient indexed search and second part adds case sensitivity to
 * significantly
 * reduced amounts of data. This would be more efficient without indexes as well, cause LIKE
 * BINARY
 *  conversion would be performed on less rows anyway.
 *  <p>
 *  <b><code>sql.MyDatabase.useHavingClause</code></b><br>
 *  By default SQL query is generated using traditional "having" clause approach:
 *  <pre>select <i>&lt;selectClause&gt;</i> from ... where ... group by <i>&lt;groupClause&gt;</i> <b>having <i>&lt;groupWhereClause&gt;</i></b></pre>
 * Setting <code>sql.MyDatabase.useHavingClause</code> to <code>false</code> makes SQL query use
 * subselect approach
 *  when main query becomes subselect and then it is filtered in outer "where" clause:
 *  <pre><b>select * from (</b>select <i>&lt;selectClause&gt;</i> from ... where ... group by <i>&lt;groupClause&gt;</i><b>) work where <i>&lt;groupWhereClause&gt;</i></b></pre>
 * This may be overridden by setting {@link
 * com.smartgwt.client.docs.serverds.OperationBinding#useHavingClause
 * OperationBinding.useHavingClause}.
 *  <p>
 * <b><code>sql.forceInsensitivity</code> and
 * <code>sql.MyDatabase.forceInsensitivity</code></b><br>
 * These properties control {@link com.smartgwt.client.types.OperatorId iContains} case
 * insensitive operator behavior.
 *  Set to <code>true</code> to force case insensitivity (see below) or <code>false</code> to rely
 *  on database <code>LIKE</code> operator directly. At the database level <code>iContains</code>
 *  comparison is performed by <code>LIKE</code> operator which may be case sensitive or case
 *  insensitive depending on the database or its configuration. For databases with case sensitive
 * <code>LIKE</code> operator we are forcing case insensitivity by changing case on both
 * comparison
 *  expression sides:
 *  <p/>
 *  <code> LOWER(table.column) LIKE LOWER('%Value%') </code>
 *  <p/>
 * This approach has a downside of not using indexes, which is not efficient with big amounts of
 * data.
 * So, it is recommended to use direct <code>LIKE</code> comparison when possible, which
 * Smartclient
 * does by default for SQL Server and MySQL drivers, since their <code>LIKE</code> is case
 * insensitive
 * by default. Although it may depend on DB setup, for example in SQL Server it is controlled via
 * database
 * collation. So, configure accordingly to the database setup you're using, which can be done via:
 *  <ul>
 *  <li/> system-wide <code>sql.forceInsensitive</code> property in server.properties
 *  <li/> Database config specific <code>sql.MyDatabase.forceInsensitive</code> property in
 *  server.properties
 * <li/> {@link com.smartgwt.client.docs.serverds.DataSourceField#sqlForceInsensitive
 * DataSourceField.sqlForceInsensitive} property for individual fields
 *  </ul>
 *  <p>
 *  <b><code>sql.aliasLengthLimit</code> and <code>sql.MyDatabase.aliasLengthLimit</code></b><br>
 *  These properties override the default table alias length limit when using features like
 * {@link com.smartgwt.client.docs.serverds.DataSourceField#includeVia DataSourceField.includeVia}
 * and {@link com.smartgwt.client.docs.serverds.DataSourceField#otherFKs
 * DataSourceField.otherFKs}.
 *  Default alias length limit is set accordingly to the documentation for supported databases
 *  and defaults to 128 characters, except these databases:<p>
 *  <table style="font-size:10px">
 *  <tr><td><b>firebirdsql</b></td>  <td>63</td></tr>
 *  <tr><td><b>mysql</b></td>        <td>256</td></tr>
 *  <tr><td><b>mariadb</b></td>      <td>256</td></tr>
 * <tr><td><b>oracle</b></td>       <td>automatically set to 128 since DB version 12.2 and to 30
 * for older versions</td></tr>
 *  <tr><td><b>postgresql</b></td>   <td>63</td></tr>
 *  </table><p>
 *  In order to support portability across databases it is advised to keep alias length limit at
 * the lowest supported value. Use global setting <code>sql.aliasLengthLimit</code> to apply limit
 *  across all DB drivers, or use DB specific setting <code>sql.MyDatabase.aliasLengthLimit</code>
 *  (overrides the global one).
 * @see com.smartgwt.client.docs.serverds.DataSourceField#sqlForceInsensitive
 */
public interface SqlSettings {
}
