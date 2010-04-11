
package com.smartgwt.client.docs;

/**
 * <h3>Client Only DataSources</h3>
 * For prototyping purposes, a "client-only" DataSource can be created that has no permanent&#010 storage and never
 * contacts the server, instead using a set of test data to respond to&#010 requests in the same manner as a server-based
 * DataSource might.&#010 <P>&#010 The client-side interface to a client-only DataSource is identical to a
 * server-based&#010 DataSource, including asynchronous responses, so that a client-only DataSource can be&#010 replaced by
 * a server-based DataSource without code changes.  The only difference is that&#010 changes to records belonging to the
 * DataSource persist only until the page is reloaded.&#010 <p>&#010 Client-only DataSources allow you to create a complete
 * prototype application in an .html&#010 file that does not require a server.&#010 <p>&#010 The <code>clientOnly</code>
 * property is specified to create a client-only DataSource, and&#010 the <code>testData</code> property should contain the
 * test dataset, as an Array of Objects,&#010 one per DataSource record.  For example:&#010 <pre>&#010  
 * isc.DataSource.create({&#010       ID:"supplyItem",&#010       fields: ...,&#010       clientOnly:true,&#010      
 * testData:[&#010          {itemName:"Pencil", cost:5.50},&#010          ...&#010       ]&#010   });&#010 </pre>&#010 If
 * you have existing test data in XML (see the {@link com.smartgwt.client.docs.AdminConsole 'Admin Console'} for&#010
 * expected format),&#010 you can use the XML->JS translation engine to load it into a client-only DataSource, like
 * so:&#010 <pre>&#010   isc.DataSource.create({&#010     ID:"solutions",&#010     fields: ...,&#010     clientOnly :
 * true,&#010     testData : &#010         &lt;isomorphic:XML filename="shared/ds/test_data/solutions.data.xml"/&gt;&#010  
 * });&#010 </pre>&#010 Another useful practice is to specify both the clientOnly DataSource and it's test data in&#010
 * XML, so that the {@link com.smartgwt.client.docs.AdminConsole 'Admin Console'} can later be used to import the&#010
 * DataSource and its test data into a SQL Database.  An idiom for accomplishing this is:&#010 <pre>&#010  
 * &lt;isomorphic:loadDS name="solutions"/&gt;&#010   isc.DataSource.getDataSource("solutions").addProperties({&#010    
 * clientOnly : true,&#010     testData : &#010        &lt;isomorphic:XML
 * filename="shared/ds/test_data/solutions.data.xml"/&gt;&#010   });&#010 </pre>&#010 If you specify your DataSource as
 * <code>clientOnly: true</code>, omit testData&#010 entirely, and provide either a {@link
 * com.smartgwt.client.data.DataSource#getDataURL dataURL} or a <code>testFileName</code>, the&#010 DataSource will lazily
 * make a one-time fetch against the specified data file the first time&#010 an operation is called on it.  From then on,
 * the DataSource will work against the local&#010 cache created from this initial request.  This is a quick way to
 * prototype against some test&#010 data that may eventually be returned from an arbitrary back-end.&#010 <P>&#010 Finally,
 * it is possible to have a DataSource which initially fetches the entire dataset and&#010 performs all subsequent fetching
 * locally, while still visiting the server to perform all &#010 other operations.  See
 * ${isc.DocUtils.linkForRef('cacheAllData')}.
 * @see com.smartgwt.client.data.DataSource#getClientOnly
 * @see com.smartgwt.client.data.DataSource#getTestData
 */
public interface ClientOnlyDataSources {
}
