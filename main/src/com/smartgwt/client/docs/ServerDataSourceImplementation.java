
package com.smartgwt.client.docs;

/**
 * <h3>Notes on Server-side DataSource Implementations</h3>
 * NOTE: This section includes references to server-side classes and methods; you can find the
 * documentation for these in the server-side Javadocs. <p> Bear in mind the following points when
 * working with DataSources (whether custom or  built-in) on the Smart GWT Server:<ul> <li>There
 * is no requirement or expectation that DataSource subclasses be threadsafe.  As  long as you use
 * documented techniques for creating DataSource instances, the server framework will ensure that
 * no single instance is used concurrently by more than one thread.</li> <p> <li>If you are using
 * {@link com.smartgwt.client.docs.SpringIntegration Spring-injected dataSources}, note that the
 * default scope for a Spring bean is "singleton".  This means that a single instance of  the bean
 * is cached by Spring and returned every time the framework code asks for that  DataSource.  This
 * pattern prevents the Smart GWT framework from making the above-mentioned guarantee that no
 * single instance will be used by multiple threads, and can lead to unpleasant concurrency bugs. 
 * The solution is to mark your Spring beans with a scope of  "prototype" (you could also use
 * "request", but Smart GWT caches DataSource instances  per-HttpServletRequest anyway, so nothing
 * is gained by doing that).  See the  <a
 * href=http://docs.spring.io/spring/docs/3.2.5.RELEASE/spring-framework-reference/html/beans.html#beans-factory-scopes>
 * Spring documentation</a> for further information about bean scope.  <p> <li>DataSource
 * instances can safely be retained for use multiple times in a given HTTP  request; this presents
 * no thread-safety issues unless you specifically introduce them by, eg, creating a new DSRequest
 * and executing it in its own thread.  However, note that mixing {@link
 * com.smartgwt.client.data.DataSource#getAutoJoinTransactions transactional} and
 * non-transactional operations on the  same DataSource instance in a single HTTP request can lead
 * to connection leaks if you are  using the built-in Hibernate or JPA DataSource.</li> <p> <li>If
 * the {@link com.smartgwt.client.docs.Server_properties server.properties} attribute
 * <code>datasources.pool.enabled</code> is set, DataSource instances are automatically cached in
 * an in-memory pool.  This caching is smart: if the underlying <code>.ds.xml</code> file changes,
 * cached instances are  discarded and rebuilt.</li> <p> <li>If pooling is not switched on,
 * DataSource instances are constructed new as required. Whether or not pooling is enabled, new
 * DataSource instances are always constructed using cached configuration for better performance. 
 * The configuration file (<code>.ds.xml</code> file) is read the first time the DataSource is
 * requested; thereafter, we will only re-read the configuration file if its last-changed
 * timestamp changes.  This scheme combines the  performance benefits of caching with the with the
 * convenience of being able to change a  <code>.ds.xml</code> file and pick up the changes
 * without restarting the server.</li> <p> <li>The safe way to obtain a DataSource instance is to
 * use  <code>RPCManager.getDataSource()</code>.  If pooling is enabled, this is the only way to 
 * obtain a DataSource instance with the guarantee that it will be returned to the pool at  the
 * end of request processing.</li> <p> <li>If you are using the <code>DynamicDSGenerator</code> to
 * provide DataSources to the  framework dynamically:<ul> <p> <li>You are expected to use one of
 * the <code>DataSource.fromXML()</code> APIs to construct your DataSources from an XML document
 * or String of XML text</li> <p> <li>Do not use normal Java instantiation techniques like
 * <code>new DataSource()</code>, as  this will introduce thread-safety issues</li> <p> <li>Return
 * a new DataSource instance each time - returning the same DataSource twice will introduce
 * thread-safety issues.  If you are concerned about performance, ensure pooling is enabled as
 * described above - this will mean that the DataSource you return will be automatically cached
 * and re-used, so your DynamicDSGenerator will only be called enough times to populate the pool. 
 * If you are still concerned about performance, cache the XML String that you pass to
 * <code>DataSource.fromXML()</code>.</li> <p> <li>For many applications of
 * <code>DynamicDSGenerator</code>, pooling is inappropriate because the returned DataSource for a
 * given name might be different each time the generator is called.  For this reason, pooling of
 * dynamic DataSources is disabled by default.  To enable pooling for dynamically-generated
 * DataSources, set the {@link com.smartgwt.client.docs.Server_properties server.properties}  flag
 * <code>poolDynamicDataSources</code> to true.  NOTE: Here, "dynamic DataSource" means  a
 * DataSource whose name would cause the framework to invoke a DynamicDSGenerator, which  doesn't
 * necessarily mean that the generator would actually create a dynamic DataSource.  As the
 * server-side documentation for <code>DynamicDSGenerator.getDataSource()</code> states, a
 * generator can simply return null to decline the opportunity to create a dynamic DataSource.
 * Therefore, if the proper operation of pooling is important to you, avoid patterns of 
 * <code>DynamicDSGenerator</code> usage that involve registering more generically than you  need
 * to.  In particular, avoid the <code>addDynamicDSGenerator()</code> signature that  does not
 * take a prefix or regex parameter - this will cause the pooling subsystem to regard <b>all</b>
 * DataSources as dynamic, and will effectively disable all DataSource pooling. </li></ul>
 * </li></ul>
 */
public interface ServerDataSourceImplementation {
}
