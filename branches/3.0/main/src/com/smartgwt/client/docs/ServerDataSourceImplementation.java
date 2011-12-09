
package com.smartgwt.client.docs;

/**
 * <h3>Notes on Server-side DataSource Implementations</h3>
 * NOTE: This section includes references to server-side classes and methods; you can find the documentation for these in
 * the server-side Javadocs. <p> Bear in mind the following points when working with DataSources (whether custom or 
 * built-in) on the Smart GWT Server:<ul> <li>There is no requirement or expectation that DataSource subclasses be
 * threadsafe.  As  long as you use documented techniques for creating DataSource instances, the server framework will
 * ensure that no single instance is used concurrently by more than one thread.</li> <li>DataSource instances can safely be
 * retained for use multiple times in a given HTTP  request; this presents no thread-safety issues unless you specifically
 * introduce them by, eg, creating a new DSRequest and executing it in its own thread</li> <li>If the
 * <code>server.properties</code> attribute <code>datasources.pool.enabled</code> is set, DataSource instances are
 * automatically cached in an in-memory pool</li> <li>If pooling is not switched on, DataSource instances are constructed
 * new as required,  but they are constructed using cached configuration for better performance.  The configuration file
 * (<code>.ds.xml</code> file) is read the first time the DataSource is  requested; thereafter, we will only re-read the
 * configuration file if its last-changed  timestamp changes.  This scheme combines the performance benefits of caching
 * with the  with the convenience of being able to change a <code>.ds.xml</code> file and pick up the  changes without
 * restarting the server.</li> <li>The safe way to obtain a DataSource instance is to use 
 * <code>RPCManager.getDataSource</code>.  If pooling is enabled, this is the only way to  obtain a DataSource instance
 * with the guarantee that it will be returned to the pool at  the end of request processing.</li> <li>If you are using the
 * <code>DynamicDSGenerator</code> to provide DataSources to the  framework dynamically:<ul> <li>You are expected to use
 * one of the <code>DataSource.fromXML()</code> APIs to construct your DataSources from an XML document or String of XML
 * text</li> <li>Do not use normal Java instantiation techniques like <code>new DataSource()</code>, as  this will
 * introduce thread-safety issues</li> <li>Return a new DataSource instance each time - returning the same DataSource twice
 * will introduce thread-safety issues.  If you are concerned about performance, ensure pooling is enabled as described
 * above - this will mean that the DataSource you return will be automatically cached and re-used, so your
 * DynamicDSGenerator will only be called enough times to populate the pool.  If you are still concerned about performance,
 * cache the XML String that you pass to <code>DataSource.fromXML()</code>. </li></ul> </li></ul>
 */
public interface ServerDataSourceImplementation {
}
