
package com.smartgwt.client.docs;

/**
 * <h3>.NET, PHP, Serverless Integration</h3>
 * While Smart GWT's extensive server features are lost if you cannot install the Java-based
 * server framework, Smart GWT UI components can be integrated with any server technology. This
 * topic provides pointers to documentation that is most relevant for this type of integration.
 * <p>  If you are using a non-Java backend such as PHP or .NET, you may want to consider 
 * SmartGWT's sister product &#83;martClient, which has the same functionality but allows
 * programming in JavaScript instead of Java.  However if you prefer to use Java on the client,
 * this is fine - SmartGWT and Smart GWT have identical capabilities for integrating with non-Java
 * servers. <p> When run on a SmartGWT project, the GWT compiler produces ordinary web assets -
 * JavaScript files, .html files, images, etc - which can be deployed on any web server like any
 * other web assets.  How best to integrate GWT into your development workflow is outside the
 * scope of this documentation, however, consider using the SmartGWT server-side HttpProxy
 * (mentioned below) as a means of using a Java IDE to develop GWT Java code in the usual way,
 * while allowing your GWT application to contact services hosted on another server (which is
 * running your PHP, .NET or other server code).  The HttpProxy can then be eliminated from your
 * final deployment by deploying the web assets produced by GWT directly on the server running
 * your non-Java server code.   <P> <h4>Data Loading / Data Binding</h4> <P> The primary focus of
 * Smart GWT integration is connecting DataSource operations to your server.  The {@link
 * com.smartgwt.client.docs.ClientDataIntegration Client-side Data Integration} chapter covers the
 * key approaches, including cookbook approaches for REST-based integration with any server that
 * can return XML or JSON over HTTP. <P> <h4>Simple RPCs (non-DataSource requests)</h4> <P> You
 * can implement simple RPCs by having your server output  <a href='http://www.json.org/'
 * onclick="window.open('http://www.json.org/');return false;">JSON</a> (JavaScript Object
 * Notation) and using  {@link com.smartgwt.client.rpc.RPCRequest#getEvalResult evalResult} to
 * directly turn JSON results into live JavaScript objects. {@link
 * com.smartgwt.client.rpc.RPCRequest#getServerOutputAsString serverOutputAsString} lets you load
 * arbitrary server results, including JSON results that need to be processed before they can be
 * eval()'d. <P> Alternatively, if you are familiar with WSDL web services, you can implement
 * simple RPCs as web service operations: use {@link com.smartgwt.client.data.XMLTools#loadWSDL
 * XMLTools.loadWSDL} to load the service definition, and then use {@link
 * com.smartgwt.client.data.WebService#callOperation WebService.callOperation} to call the
 * operations.  We don't generally recommend this approach unless you are already deeply familiar
 * with WSDL - it's far more complicated that producing and consuming JSON. <P> <h4>HTTPProxy:
 * Cross-site or cross-port data loading</h4> <P> If you develop a prototype using the Smart GWT
 * SDK and Smart GWT Java Server, and then you migrate the prototype to another server technology,
 * you need to be aware that the Smart GWT Java Server includes an HTTPProxy servlet that allows
 * Smart GWT interfaces to contact servers other than the origin server (bypassing what is called
 * the <a href='http://www.google.com/search?q=same+origin+policy'
 * onclick="window.open('http://www.google.com/search?q=same+origin+policy');return false;">"same
 * origin policy"</a>). <P> Smart GWT uses the HttpProxy automatically when needed, so it may not
 * be obvious that the HTTPProxy is in use.  Then, your migrated application will encounter errors
 * attempting to contact the HTTPProxy servlet. <P> To avoid these errors, ensure that all
 * services that your application uses are accessed using the same hostname and port as the page
 * was loaded from.  In particular, watch for WSDL files, which contain the service URL - you may
 * need to use {@link com.smartgwt.client.data.WebService#setLocation WebService.setLocation} to
 * ensure that the web service URL and page URL match. <P> If your production application really
 * does need to access services or content hosted on other servers, typical practice is to pursue
 * normal Smart GWT integration with your server, then write server-side code that contacts other
 * hosts on behalf of your Smart GWT interface.
 */
public interface NonJavaBackend {
}
