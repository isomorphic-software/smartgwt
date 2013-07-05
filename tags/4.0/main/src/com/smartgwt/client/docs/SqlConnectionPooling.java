
package com.smartgwt.client.docs;

/**
 * <h3>SQL Connection Pooling</h3>
 * Many databases will automatically close inactive connections, which can interfere with
 * connection pooling: if an application is not constantly using all of the connections in its
 * pool, it may retrieve a closed connection from the pool. <P> In some cases you can disable the
 * behavior of closing inactive connections.  For MySQL it's controlled by the <a
 * href='http://dev.mysql.com/doc/refman/5.0/en/server-system-variables.html#sysvar_wait_timeout'
 * onclick="window.open('http://dev.mysql.com/doc/refman/5.0/en/server-system-variables.html#sysvar_wait_timeout');return
 * false;">wait_timeout</a> setting in your my.cnf file).  However, this could potentially cause
 * leaked connections if applications terminate without cleaning up their database connections.
 * <P> Intelligent connection pools compensate for unexpectedly closed connections automatically:
 * <ul> <li>J2EE containers generally implement internal keepalives or staleness checks - this is
 * the preferred solution if available.  If using SQLDataSource, use JNDI-based configuration as
 * described {@link com.smartgwt.client.docs.AdminConsole here}. <li>SQLDataSource uses DBCP
 * (Apache Commons) pooling, which also compensates for connection closure automatically.  This is
 * enabled by default with appropriate settings, but can be disabled system wide via setting
 * <b>sql.pool.enabled</b> to false in server.properties, or disabled for a specific database
 * configuration via <b>sql.<i>dbName</i>.pool.enabled</b>. The following properties can also be
 * set on sql.pool / sql.<i>dbName</i>.pool and control same-named DBCP properties, however, it is
 * not recommended to set these properties unless you have experience with DBCP and are
 * troubleshooting a specific pool-related performance problem: testOnBorrow, testOnReturn,
 * testWhileIdle, timeBetweenEvictionRunsMillis, minEvictableIdleTimeMillis,
 * numTestsPerEvictionRun. <li>JPA/Hibernate: Hibernate's built-in connection pool is <b>not</b>
 * intended for production use according to Hibernate's own documentation.  This includes using
 * JPA with Hibernate as the provider. If you get dead connections during development you can
 * disable Hibernate's built-in connection pool by setting "hibernate.connection.pool_size" to 0.
 * For production use you must use production-ready connection pool libraries for example C3P0.
 * Here are recommended settings for C3P0 properties: <ul> <li>c3p0.acquireRetryDelay=1000</li>
 * <li>c3p0.acquireRetryAttempts=60</li> <li>c3p0.breakAfterAcquireFailure=false</li> </ul> </li>
 * </ul>
 */
public interface SqlConnectionPooling {
}
