
package com.smartgwt.client.docs;

/**
 * <h3>SQL Connection Pooling</h3>
 * <b>This discussion applies primarily to the built-in SQL DataSource provided in Pro and 
 *  better editions of Smart GWT, though elements of it also apply to the built-in Hibernate
 *  and JPA DataSources</b>
 *  <p>
 *  SQLDataSource communicates with database products using 
 *  <a href=http://docs.oracle.com/javase/7/docs/api/java/sql/Connection.html>JDBC Connection
 *  objects</a>.  These Connections are provided by the individual database products' JDBC 
 *  drivers; they either wrap the database's native mechanism for a client-server connection,
 *  or they implement a pure Java equivalent of the same thing.  All read and update operations
 *  performed by SQL DataSource take place via one of these connections.  Also, 
 * {@link com.smartgwt.client.data.DataSource#getAutoJoinTransactions SQL transactions} are
 * implemented by having the queue
 *  of related updates take place through the same connection, with a single commit (or 
 *  rollback) at the end of the queue.
 *  <p>
 *  Database connections are a limited resource, and they can also be expensive to acquire.  For
 *  both of these reasons, Smart GWT by default uses the Apache DBCP pooling library to 
 *  maintain a pool of resuable connections.  Connections are borrowed from the pool as required,
 *  and returned to the pool when they are no longer needed, and the pooling library ensures that
 *  connections are only lent out to one borrowing process at any given time.  This arrangement
 *  is efficient in terms of both connection acquisition speed and the number of connections 
 *  required<ul>
 *  <li>Reusing an existing connection is typically faster than asking the database for a new 
 *  one; depending on the database, it can be much faster</li>
 *  <li>Reusing the same connections over and over means that applications require fewer 
 *  connections to handle the same workload.  Even busy applications handling hundreds of 
 *  concurrent users typically require a much smaller number of pooled connections than might 
 *  be thought at first glance</li>
 *  </ul>
 *  For these reasons, we ship Smart GWT with connection pooling switched on, and we recommend
 *  you leave it that way.
 *  <h3>Connection pool settings</h3>
 *  You configure the behavior of SQL connection pooling with the following 
 *  <code>server.properties</code> settings (note, many of these settings map directly to 
 *  settings in the underlying DBCP library; you can find out more about their effects in the
 *  <a href=http://commons.apache.org/proper/commons-dbcp/configuration.html>DBCP docs</a>):
 *  <p>
 *  <table border="1">
 *  <tr><td><code>sql.pool.enabled</code></td><td>Set true/false to enable or disable the entire  
 *  SQL connection pooling feature.  Defaults to true</td></tr>
 *  <tr><td><code>sql.pool.maxActive</code></td><td>Maximum number of "active" (ie, currently
 *  lent out) connections.  Defaults to -1, which means "no limit"</td></tr>
 *  <tr><td><code>sql.pool.maxIdle</code></td><td>Maximum number of "idle" (ie, currently 
 * sitting in the pool, not lent out) connections.  Defaults to -1, which means "no
 * limit"</td></tr>
 *  <tr><td><code>sql.pool.minIdle</code></td><td>Minimum number of "idle" (ie, currently
 *  sitting in the pool, not lent out) connections.  If the pool drops below this number of 
 * idle connections, new ones will be created.  Defaults to -1, which means "no minimum"</td></tr>
 *  <tr><td><code>sql.pool.whenExhaustedAction</code></td><td>Specifies what the pool should do
 *  if the system attempts to borrow a connection and there are no idle connections to lend.<ul>
 *  <li>"fail" will throw an Exception and the SQL operation will fail</li>
 *  <li>"block" will cause the borrowing thread to block until a connection becomes available</li>
 *  <li>"grow" will create a new connection, add it to the pool, and then return it to the 
 *  borrowing thread.  Note, if you use this strategy, the "maxActive" setting has no effect</li>
 *  </ul>The default value is "grow"</td></tr>
 *  <tr><td><code>sql.pool.testOnBorrow</code></td><td>If true, we attempt to validate the 
 *  connection before lending it out.  This validation involves checking if the connection is 
 *  marked as closed, and also running a "pingTest" query if one is defined (see the section on
 *  per-database configuration, below).  If validation fails, the connection is discarded and 
 *  another one selected from the pool.  Defaults to true</td></tr>
 *  <tr><td><code>sql.pool.testOnReturn</code></td><td>The same as <code>testOnBorrow</code>, 
 *  but the checking occurs when the connection is returned to the pool rather than when we are 
 *  about to lend it out.  Defaults to false</td></tr>
 *  <tr><td><code>sql.pool.testWhileIdle</code></td><td>The same as <code>testOnBorrow</code>, 
 *  but the checking is done by the idle connection evictor (see below) during its periodic 
 *  inspection of the idle objects in the pool.  Defaults to false</td></tr>
 *  <tr><td><code>sql.pool.timeBetweenEvictionRunsMillis</code></td><td>DBCP can optionally run
 *  an "idle connection evictor" thread, which periodically checks the pool for connections 
 *  that have been idle for more than a threshold time, and "evicts" them from the pool (ie,
 *  closes and then discards them).  The purpose of this is to keep the connection pool at the 
 *  intended size, instead of allowing it to remain at whatever size it reached during the 
 *  system's busiest time.  Without an evictor, it would not be unusual to see the number of 
 *  connections in the pool grow towards <code>maxActive</code> over time, or even beyond it 
 *  if the pool is configured to grow when exhausted.  If this is not what you want, configure
 *  an eviction thread.  However, note that the eviction thread contends with the main pooling
 *  code for access to the idle connections; if you set the evictor to run very frequently, it
 *  can introduce performance issues.
 *  <p>
 *  This property specifies the number of milliseconds to sleep between runs of the idle 
 *  connection evictor.  If set to a negative value, no evictor will be run.  Defaults to -1 
 *  (ie, no eviction thread)</td></tr>
 *  <tr><td><code>sql.pool.minEvictableIdleTimeMillis</code></td><td>The minimum time a
 *  connection may sit idle in the pool before it is eligible for eviction.  If set to a 
 *  negative value, connections will never be evicted due to the length of time they have sat 
 *  idle (a connection will only be evicted if <code>testWhileIdle</code> is true and it 
 *  fails validation).  Defaults to -1</td></tr>
 *  <tr><td><code>sql.pool.numTestsPerEvictionRun</code></td><td>The number of connections to
 *  check during each eviction run.  Defaults to -1, which means check all objects in the pool
 *  (this is not documented by Apache, but negative values are treated as the denominator in 
 *  determining a fraction of the pool size, so -2 means check half the connections, -3 means 
 *  check a third, etc)</td></tr>
 *  </table>
 *  <p>
 *  In addition to the <code>sql.pool</code> configuration subtree, you can specify per-database
 * configuration by adding the {@link com.smartgwt.client.docs.serverds.DataSource#dbName dbName}
 * to the property, like so:<pre>
 *      sql.mydatabase.pool.enabled: true
 *      sql.mydatabase.pool.numTestsPerEvictionRun: 10
 *      # etc...
 *  </pre>
 *  There is also a configuration property outside the <code>sql.pool</code> and 
 *  <code>sql.{DBNAME}.pool</code> trees that is nevertheless part of SQL connection pooling 
 *  configuration.  This property, <code>sql.{DBNAME}.pingTest</code>, should be a small SQL 
 *  fetch query, ideally a dummy fetch that runs very quickly and returns a single row.  As 
 *  discussed above, this "pingTest", if configured, is used to determine if a connection is 
 *  valid before lending it out.  Most databases have a traditional, proprietary query that fits 
 *  the bill, but it varies by database. Some example pingTest queries:<pre>
 *      # Oracle
 *      sql.OracleDatabase.pingTest: select 1 from dual
 *      # SQL Server
 *      sql.mssqlserverdb.pingTest: select 'x'
 *      # DB2
 *      sql.db2database.pingTest: select 'x' from SYSIBM.SYSDUMMY1
 *  </pre>
 *  <h3>Troubleshooting issues related to connection pooling</h3>
 *  Many databases will automatically close inactive connections, which can interfere with
 *  connection pooling: if an application is not constantly using all of the connections in its
 *  pool, it may retrieve a closed connection from the pool.
 *  <P>
 *  In some cases you can disable the behavior of closing inactive connections.  For MySQL it's
 *  controlled by the
 * <a
 * href='http://dev.mysql.com/doc/refman/5.0/en/server-system-variables.html#sysvar_wait_timeout'
 * target='_blank'>wait_timeout</a>
 *  setting in your my.cnf file).  However, this could potentially cause leaked connections if
 *  applications terminate without cleaning up their database connections.
 *  <P>
 *  Intelligent connection pools compensate for unexpectedly closed connections automatically:
 *  <ul>
 *  <li>J2EE containers generally implement internal keepalives or staleness checks - this is
 *  the preferred solution if available.  If using SQLDataSource, use JNDI-based
 *  configuration as described {@link com.smartgwt.client.docs.DbConfigTool here}.
 *  <li>SQLDataSource uses DBCP (Apache Commons) pooling, which also compensates for connection
 *  closure automatically.  This is enabled by default with appropriate settings, but can be
 *  disabled system wide via setting <b>sql.pool.enabled</b> to false in
 *  {@link com.smartgwt.client.docs.Server_properties server.properties}, or
 *  disabled for a specific database configuration via <b>sql.<i>dbName</i>.pool.enabled</b>.
 *  The following properties can also be set on sql.pool / sql.<i>dbName</i>.pool and control
 *  same-named DBCP properties, however, it is not recommended to set these properties unless
 *  you have experience with DBCP and are troubleshooting a specific pool-related performance
 *  problem: testOnBorrow, testOnReturn, testWhileIdle, timeBetweenEvictionRunsMillis,
 *  minEvictableIdleTimeMillis, numTestsPerEvictionRun.
 *  <p>
 *  When the pool is configured for connection validation, as it is by default, a SQL statement 
 * is run to verify the condition of its connection.  To control the timeout value on this
 * statement, 
 * set the sql.validationQueryTimeout / sql.dbName.validationQueryTimeout property (in seconds,
 * default value is 10).
 *  <p>
 *  If you are trying to diagnose an issue related to SQL connection pooling, you can enable
 *  DEBUG logging for the following classes in <code>log4j.isc.config.xml</code> (see
 *  installation instructions for details about this file).  All of these classes are in package
 *  <code>com.isomorphic.sql</code>:
 *  <ul>
 *  <li> PoolableSQLConnectionFactory: logs connection creation, and whether or not the
 *       connections are pooled
 *  <li> SQLConnectionManager: logs when connections are borrowed
 *  <li> SQLDriver: logs the hashCode of the connection when SQL statements are executed
 *  <li> SQLTransaction: logs transactional open, commit, rollback and close.
 *  </ul>
 *  <li>JPA/Hibernate: Hibernate's built-in connection pool is <b>not</b> intended for
 *  production use according to Hibernate's own documentation.  This includes using JPA with
 *  Hibernate as the provider. If you get dead connections during development you can disable
 *  Hibernate's built-in connection pool by setting "hibernate.connection.pool_size" to 0. For
 *  production use you must use production-ready connection pool libraries for example
 *  C3P0. Here are recommended settings for C3P0 properties:
 *  <ul>
 *  <li>c3p0.acquireRetryDelay=1000</li>
 *  <li>c3p0.acquireRetryAttempts=60</li>
 *  <li>c3p0.breakAfterAcquireFailure=false</li>
 *  </ul>
 *  </li>
 *  </ul>
 */
public interface SqlConnectionPooling {
}
