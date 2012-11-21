	    
package com.smartgwt.client.docs;

/**
 * <h3>Client Only DataSources</h3>
 * For prototyping purposes, a "client-only" DataSource can be created that has no permanent
 *  storage and never contacts the server, instead using a set of test data to respond to
 *  requests in the same manner as a server-based DataSource might.
 *  <P>
 *  The client-side interface to a client-only DataSource is identical to a server-based
 *  DataSource, including asynchronous responses, so that a client-only DataSource can be
 *  replaced by a server-based DataSource without code changes.  The only difference is that
 *  changes to records belonging to the DataSource persist only until the page is reloaded.
 *  <p>
 *  Client-only DataSources allow you to create a complete prototype application in an .html
 *  file that does not require a server.
 *  <p>
 *  
 *  
 *  The setClientOnly method is specified to create a client-only DataSource. For example:
 *  <pre>
 *   DataSource dataSource = new DataSource();
 *   dataSource.setID("stockQuotesDS");
 *   DataSourceField idField = new DataSourceField("id", FieldType.INTEGER, "Id");
 *   ........
 *   dataSource.setFields(idField,.....);
 *   dataSource.setClientOnly(true);
 *  </pre>
 *  If you have existing test data in XML (see the Admin Console for expected format), 
 *  you can load it into a client-only DataSource using setDataURL method, like so:
 *  <pre>
 *   DataSource dataSource = new DataSource();
 *   dataSource.setID("stockQuotesDS");
 *   dataSource.setRecordXPath("/List/stockQuotes");
 *   DataSourceField idField = new DataSourceField("id", FieldType.INTEGER, "Id");
 *   ........
 *   dataSource.setFields(idField,.....);
 *   dataSource.setDataURL("ds/test_data/stockQuotes.data.xml");
 *   dataSource.setClientOnly(true);
 *  </pre>
 *  The
 *  
 *  DataSource will lazily make a one-time fetch against the specified data file the first time
 *  an operation is called on it.  From then on, the DataSource will work against the local
 *  cache created from this initial request.  This is a quick way to prototype against some test
 *  data that may eventually be returned from an arbitrary back-end.
 *  <P>
 *  Finally, it is possible to have a DataSource which initially fetches the entire dataset and
 *  performs all subsequent fetching locally, while still visiting the server to perform all 
 * other operations.  See {@link com.smartgwt.client.data.DataSource#getCacheAllData
 * cacheAllData}.
 * @see com.smartgwt.client.data.DataSource#getClientOnly
 */
public interface ClientOnlyDataSources {
}
