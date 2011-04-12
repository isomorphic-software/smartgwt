
package com.smartgwt.client.docs;

/**
 * <h3>The Core and Optional Smart GWT servlets</h3>
 * The following is a description of the servlets and filters you'll find in the web.xml file contained in the
 * smartclientRuntime and what they do: <p> <i>Core Functionality</i> <ul> <li>Init servlet- <b>required:</b> initializes
 * the Smart GWT server componentry from config files at container startup time.  Notice that this servlet has no mapping -
 * it's purely an initialization servlet. <li>IDACall servlet - <b>required</b> for {@link
 * com.smartgwt.client.docs.DmiOverview DMI}, built-in RPC operations and built-in DataSource operations to work.  All
 * databound examples in the SDK use this servlet.  If you're planning on using a custom actionURL for all your RPC
 * requests, then you don't need this servlet. <li>FileDownload servlet - required for serving the Isomorphic framework
 * code compressed and with caching headers as well as for serving skin images with caching headers.  It is highly
 * recommended that you use this for production but is not required.  <li>PreCache servlet - loads resources into memory on
 * container startup.  Not required, but if you exclude this servlet there may be a slow response to the very first
 * request. <li>jsp-config section - the iscTaglib registration block is required to use &lt;isomorphic&gt; tags, and the
 * *.isc and *.rpc mappings.  These are optional, if you want to use these as handy development tools. </ul> <p>
 * <i>Optional Functionality</i> <ul> <li>RESTHandler servlet - handles Smart GWT Server DataSource operations issued by 
 * REST clients: it's like IDACall, but for the REST protocol.  Typically,  the clients of this servlet would not be
 * ordinary Smart GWT/SmartGWT applications (though they  could be), but other client technologies that need to access
 * Smart GWT DataSource  operations as reusable services.  If you do not plan to connect to the server using the REST
 * protocol, then you don't need this servlet. <li>AxisServlet - exposes all DataSource operations via a WSDL service
 * described by  Smart GWTOperations.wsdl.  This is effectively the same as the RESTHandler servlet, but  for SOAP clients.
 * If you do not plan to connect to the server using webservice protocols, then you don't need this servlet. <li>HttpProxy
 * - used by the RPCManager when sending AJAX RPCs to a server other than the server that serves the main application page.
 * You need to install this servlet if, for example, your application will be querying web services exposed by servers
 * other than the server that is serving the rest of the application.  See the javadoc for this servlet for various
 * configuration options, such as how to restrict the URLs that are allowed to be proxied.  <li>MessagingServlet - used by
 * the realtime messaging system.  If you're planning on using this subsystem, you'll need this servlet.
 * <li>CompressionFilter - required if you want to use dynamic compression of html and js files. <li>JSSyntaxScannerFilter
 * - development tool that looks for trailing commas in JS source (scans html files for &lt;script&gt; tags and scans .js
 * files in their entirety). This is a useful development tool, but should not be included in production. <li>NoCacheFilter
 * - development tool that makes any content it intercepts non-cacheable in order to ensure developers are looking at the
 * latest version of a file when modifying examples.  Not for production use. <li>DataSourceLoader - a servlet that returns
 * the definition of one or more DataSources in JavaScript notation.  This servlet is provided as an alternative to using
 * the  <code>&lt;isomorphic:loadDS&gt;</code> JSP tag, and is particularly suitable in environments where JSP tags can't
 * be used for some reason (such as with SmartGWT).  See  {@link com.smartgwt.client.docs.DataSourceDeclaration Creating
 * DataSources} for more details. </ul> Note that not all of the servlets and filters listed under <i>Optional
 * Functionality</i> above are present in the web.xml that ships with the smartclientRuntime - if you need to use any of
 * these, copy their configuration from the web.xml available under the WEB-INF directory of smartclientSDK.  Other
 * servlets, filters and configuration files from the smartclientSDK should not be copied to your deployment, simply
 * because the SDK includes many developer tools that are not extensively audited from a security standpoint.
 */
public interface ServletDetails {
}
