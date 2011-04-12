
package com.smartgwt.client.docs;

/**
 * <h3>.NET, PHP, Serverless Integration</h3>
 * While Smart GWT's extensive server features are lost if you cannot install the Java-based&#010 server framework, Smart
 * GWT UI components can be integrated with any server technology.&#010 This topic provides pointers to documentation that
 * is most relevant for this type of&#010 integration.&#010 <P>&#010 <h4>Installation</h4>&#010 <P>&#010 As described in
 * {@link iscInstall <i>Deploying Smart GWT</i>}, for a client-only&#010 integration, installation consists of just copying
 * a directory of JavaScript and media files&#010 to your webserver.&#010 <P>&#010 <h4>Creating Components</h4>&#010
 * <P>&#010 Smart GWT components can be included in any .html page, including dynamically generated pages&#010 produced by
 * .php or .asp files.  The Smart GWT libraries can be included in the page as&#010 follows:&#010 <pre>&#010
 * &lt;HTML&gt;&lt;HEAD&gt;&#010 &lt;SCRIPT&gt;var isomorphicDir="../isomorphic/";&lt;/SCRIPT&gt;&#010 &lt;SCRIPT
 * SRC=../isomorphic/system/modules/ISC_Core.js&gt;&lt;/SCRIPT&gt;&#010 &lt;SCRIPT
 * SRC=../isomorphic/system/modules/ISC_Foundation.js&gt;&lt;/SCRIPT&gt;&#010 &lt;SCRIPT
 * SRC=../isomorphic/system/modules/ISC_Containers.js&gt;&lt;/SCRIPT&gt;&#010 &lt;SCRIPT
 * SRC=../isomorphic/system/modules/ISC_Grids.js&gt;&lt;/SCRIPT&gt;&#010 &lt;SCRIPT
 * SRC=../isomorphic/system/modules/ISC_Forms.js&gt;&lt;/SCRIPT&gt;&#010 &lt;SCRIPT
 * SRC=../isomorphic/system/modules/ISC_DataBinding.js&gt;&lt;/SCRIPT&gt;&#010 &lt;SCRIPT SRC=../isomorphic/skins/Smart
 * GWT/load_skin.js&gt;&lt;/SCRIPT&gt;&#010 &lt;/HEAD&gt;&lt;BODY&gt;&#010 ...</pre>&#010 Smart GWT components can then be
 * created via normal JavaScript:&#010 <pre>&#010 &lt;SCRIPT&gt;&#010 isc.Button.create({&#010     title:"Button",&#010    
 * click:"isc.say('Hello World')"&#010 });&#010 &lt;/SCRIPT&gt;</pre>&#010 This approach is discussed in more detail in the
 * &#010 <a href='/docs/Smart GWT_Quick_Start_Guide.pdf' onclick="window.open('/docs/Smart
 * GWT_Quick_Start_Guide.pdf');return false;">QuickStart Guide</a>, Chapter 4, <i>Coding</i>.&#010 Note that
 * JavaScript-based component instantiation is currently the recommended approach, and&#010 most examples are provided in
 * the JavaScript format.&#010 <P>&#010 <h4>Data Loading / Data Binding</h4>&#010 <P>&#010 The primary focus of Smart GWT
 * integration is connecting DataSource operations to your&#010 server.  The {@link
 * com.smartgwt.client.docs.ClientDataIntegration Client-side Data Integration} chapter covers&#010 the key approaches,
 * including cookbook approaches for REST-based integration with any server&#010 that can return XML or JSON over
 * HTTP.&#010 <P>&#010 <h4>Simple RPCs (non-DataSource requests)</h4>&#010 <P>&#010 You can implement simple RPCs as web
 * service operations: use&#010 {@link com.smartgwt.client.data.XMLTools#loadWSDL XMLTools.loadWSDL} to load the service
 * definition, and then use&#010 {@link com.smartgwt.client.data.WebService#callOperation WebService.callOperation} to call
 * the operations.  Note that some server frameworks&#010 allow the generation of WSDL from server method signatures.&#010
 * <P>&#010 Alternatively, if your backend is capable of outputting &#010 <a href='http://www.json.org/'
 * onclick="window.open('http://www.json.org/');return false;">JSON</a> (JavaScript Object Notation), you can use &#010
 * {@link com.smartgwt.client.rpc.RPCRequest#getEvalResult evalResult} to directly turn JSON results into live JavaScript
 * objects.&#010 {@link com.smartgwt.client.rpc.RPCRequest#getServerOutputAsString serverOutputAsString} lets you load
 * arbitrary server results, including&#010 JSON results that need to be processed before they can be eval()'d.&#010
 * <P>&#010 <h4>HTTPProxy: Cross-site or cross-port data loading</h4>&#010 <P>&#010 If you develop a prototype using the
 * Smart GWT SDK and Smart GWT Java Server, and then&#010 you migrate the prototype to another server technology, you need
 * to be aware that the&#010 Smart GWT Java Server includes an HTTPProxy servlet that allows Smart GWT interfaces to&#010
 * contact servers other than the origin server (bypassing what is called the&#010 <a
 * href='http://www.google.com/search?q=same+origin+policy'
 * onclick="window.open('http://www.google.com/search?q=same+origin+policy');return false;">"same origin policy"</a>).&#010
 * <P>&#010 Smart GWT uses the HttpProxy automatically when needed, so it may not be obvious that the&#010 HTTPProxy is in
 * use.  Then, your migrated application will encounter errors attempting to&#010 contact the HTTPProxy servlet.&#010
 * <P>&#010 To avoid these errors, ensure that all services that your application uses are accessed&#010 using the same
 * hostname and port as the page was loaded from.  In particular, watch for WSDL&#010 files, which contain the service URL
 * - you may need to use {@link com.smartgwt.client.data.WebService#setLocation WebService.setLocation}&#010 to ensure that
 * the web service URL and page URL match.&#010 <P>&#010 If your production application really does need to access services
 * or content hosted on&#010 other servers, typical practice is to pursue normal Smart GWT integration with your&#010
 * server, then write server-side code that contacts other hosts on behalf of your Smart GWT&#010 interface.
 */
public interface NonJavaBackend {
}
