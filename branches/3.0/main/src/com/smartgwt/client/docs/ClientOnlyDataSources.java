
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
 *  The <code>clientOnly</code> property is specified to create a client-only DataSource, and
 *  the <code>testData</code> property should contain the test dataset, as an Array of Objects,
 *  one per DataSource record.  For example:
 *  <pre>
 *    isc.DataSource.create({
 *        ID:"supplyItem",
 *        fields: ...,
 *        clientOnly:true,
 *        testData:[
 *           {itemName:"Pencil", cost:5.50},
 *           ...
 *        ]
 *    });
 *  </pre>
 *  If you have existing test data in XML (see the {@link com.smartgwt.client.docs.AdminConsole Admin Console} for
 *  expected format),
 *  you can use the XML->JS translation engine to load it into a client-only DataSource, like so:
 *  <pre>
 *    isc.DataSource.create({
 *      ID:"solutions",
 *      fields: ...,
 *      clientOnly : true,
 *      testData : 
 *          &lt;isomorphic:XML filename="shared/ds/test_data/solutions.data.xml"/&gt;
 *    });
 *  </pre>
 *  Another useful practice is to specify both the clientOnly DataSource and it's test data in
 *  XML, so that the {@link com.smartgwt.client.docs.AdminConsole Admin Console} can later be used to import the
 *  DataSource and its test data into a SQL Database.  An idiom for accomplishing this is:
 *  <pre>
 *    &lt;isomorphic:loadDS name="solutions"/&gt;
 *    isc.DataSource.getDataSource("solutions").addProperties({
 *      clientOnly : true,
 *      testData : 
 *         &lt;isomorphic:XML filename="shared/ds/test_data/solutions.data.xml"/&gt;
 *    });
 *  </pre>
 *  If you specify your DataSource as <code>clientOnly: true</code>, omit testData
 * entirely, and provide either a {@link com.smartgwt.client.data.DataSource#getDataURL dataURL} or a
 * <code>testFileName</code>, the
 *  DataSource will lazily make a one-time fetch against the specified data file the first time
 *  an operation is called on it.  From then on, the DataSource will work against the local
 *  cache created from this initial request.  This is a quick way to prototype against some test
 *  data that may eventually be returned from an arbitrary back-end.
 *  <P>
 *  Finally, it is possible to have a DataSource which initially fetches the entire dataset and
 *  performs all subsequent fetching locally, while still visiting the server to perform all 
 *  other operations.  See {@link com.smartgwt.client.data.DataSource#getCacheAllData cacheAllData}.
 * @see com.smartgwt.client.data.DataSource#getClientOnly
 * @see com.smartgwt.client.data.DataSource#getTestData
 */
public interface ClientOnlyDataSources {
}
