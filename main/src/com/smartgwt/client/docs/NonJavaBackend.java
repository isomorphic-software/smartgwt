	    
package com.smartgwt.client.docs;

/**
 * <h3>.NET, PHP, Serverless Integration</h3>
 * While Smart GWT's extensive server features are lost if you cannot install the Java-based
 *  server framework, Smart GWT UI components can be integrated with any server technology.
 *  This topic provides pointers to documentation that is most relevant for this type of
 *  integration.
 *  <P>
 *  <h4>Installation</h4>
 *  <P>
 *  As described in {@link iscInstall <i>Deploying Smart GWT</i>}, for a client-only
 *  integration, installation consists of just copying a directory of JavaScript and media files
 *  to your webserver.
 *  <P>
 *  <h4>Creating Components</h4>
 *  <P>
 *  Smart GWT components can be included in any .html page, including dynamically generated pages
 *  produced by .php or .asp files.  The Smart GWT libraries can be included in the page as
 *  follows:
 *  <pre>
 *  &lt;HTML&gt;&lt;HEAD&gt;
 *  &lt;SCRIPT&gt;var isomorphicDir="../isomorphic/";&lt;/SCRIPT&gt;
 *  &lt;SCRIPT SRC=../isomorphic/system/modules/ISC_Core.js&gt;&lt;/SCRIPT&gt;
 *  &lt;SCRIPT SRC=../isomorphic/system/modules/ISC_Foundation.js&gt;&lt;/SCRIPT&gt;
 *  &lt;SCRIPT SRC=../isomorphic/system/modules/ISC_Containers.js&gt;&lt;/SCRIPT&gt;
 *  &lt;SCRIPT SRC=../isomorphic/system/modules/ISC_Grids.js&gt;&lt;/SCRIPT&gt;
 *  &lt;SCRIPT SRC=../isomorphic/system/modules/ISC_Forms.js&gt;&lt;/SCRIPT&gt;
 *  &lt;SCRIPT SRC=../isomorphic/system/modules/ISC_DataBinding.js&gt;&lt;/SCRIPT&gt;
 *  &lt;SCRIPT SRC=../isomorphic/skins/Smart GWT/load_skin.js&gt;&lt;/SCRIPT&gt;
 *  &lt;/HEAD&gt;&lt;BODY&gt;
 *  ...</pre>
 *  Smart GWT components can then be created via normal JavaScript:
 *  <pre>
 *  &lt;SCRIPT&gt;
 *  isc.Button.create({
 *      title:"Button",
 *      click:"isc.say('Hello World')"
 *  });
 *  &lt;/SCRIPT&gt;</pre>
 *  This approach is discussed in more detail in the 
 * <a href='/docs/Smart GWT_Quick_Start_Guide.pdf' onclick="window.open('/docs/Smart
 * GWT_Quick_Start_Guide.pdf');return false;">QuickStart Guide</a>, Chapter 4, <i>Coding</i>.
 *  Note that JavaScript-based component instantiation is currently the recommended approach, and
 *  most examples are provided in the JavaScript format.
 *  <P>
 *  <h4>Data Loading / Data Binding</h4>
 *  <P>
 *  The primary focus of Smart GWT integration is connecting DataSource operations to your
 * server.  The {@link com.smartgwt.client.docs.ClientDataIntegration Client-side Data
 * Integration} chapter covers
 *  the key approaches, including cookbook approaches for REST-based integration with any server
 *  that can return XML or JSON over HTTP.
 *  <P>
 *  <h4>Simple RPCs (non-DataSource requests)</h4>
 *  <P>
 *  You can implement simple RPCs as web service operations: use
 * {@link com.smartgwt.client.data.XMLTools#loadWSDL XMLTools.loadWSDL} to load the service
 * definition, and then use
 * {@link com.smartgwt.client.data.WebService#callOperation WebService.callOperation} to call the
 * operations.  Note that some server frameworks
 *  allow the generation of WSDL from server method signatures.
 *  <P>
 *  Alternatively, if your backend is capable of outputting 
 * <a href='http://www.json.org/' onclick="window.open('http://www.json.org/');return
 * false;">JSON</a> (JavaScript Object Notation), you can use 
 * {@link com.smartgwt.client.rpc.RPCRequest#getEvalResult evalResult} to directly turn JSON
 * results into live JavaScript objects.
 * {@link com.smartgwt.client.rpc.RPCRequest#getServerOutputAsString serverOutputAsString} lets
 * you load arbitrary server results, including
 *  JSON results that need to be processed before they can be eval()'d.
 *  <P>
 *  <h4>HTTPProxy: Cross-site or cross-port data loading</h4>
 *  <P>
 *  If you develop a prototype using the Smart GWT SDK and Smart GWT Java Server, and then
 *  you migrate the prototype to another server technology, you need to be aware that the
 *  Smart GWT Java Server includes an HTTPProxy servlet that allows Smart GWT interfaces to
 *  contact servers other than the origin server (bypassing what is called the
 * <a href='http://www.google.com/search?q=same+origin+policy'
 * onclick="window.open('http://www.google.com/search?q=same+origin+policy');return false;">"same
 * origin policy"</a>).
 *  <P>
 *  Smart GWT uses the HttpProxy automatically when needed, so it may not be obvious that the
 *  HTTPProxy is in use.  Then, your migrated application will encounter errors attempting to
 *  contact the HTTPProxy servlet.
 *  <P>
 *  To avoid these errors, ensure that all services that your application uses are accessed
 *  using the same hostname and port as the page was loaded from.  In particular, watch for WSDL
 * files, which contain the service URL - you may need to use {@link
 * com.smartgwt.client.data.WebService#setLocation WebService.setLocation}
 *  to ensure that the web service URL and page URL match.
 *  <P>
 *  If your production application really does need to access services or content hosted on
 *  other servers, typical practice is to pursue normal Smart GWT integration with your
 *  server, then write server-side code that contacts other hosts on behalf of your Smart GWT
 *  interface.
 */
public interface NonJavaBackend {
}
