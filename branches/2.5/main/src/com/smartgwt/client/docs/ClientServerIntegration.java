
package com.smartgwt.client.docs;

/**
 * <h3>Client-Server Integration</h3>
 * Like client-server desktop applications, Smart GWT browser-based applications interact with remote data and services via
 * background communication channels. Background requests retrieve chunks of data rather than new HTML pages, and update
 * your visual components in place rather than rebuilding the entire user interface. <P> <b>DataSources</b> <p> First you
 * must create {@link com.smartgwt.client.data.DataSource DataSources} that describe the objects from your object model
 * that will be loaded or manipulated within your application.  All of  Smart GWT's most powerful functionality builds on
 * the concept of a DataSource, and because  of Smart GWT's databinding framework (see {@link
 * com.smartgwt.client.widgets.DataBoundComponent}), it's as easy to  create a DataSource that can configure an unlimited
 * number of components as it is to  configure a single component. <P> For background information on how to create
 * DataSources, {@link com.smartgwt.client.widgets.DataBoundComponent bind} components to DataSources and initiate {@link
 * com.smartgwt.client.data.DSRequest}s, please see the <em>Data  Binding</em> chapter of the <em>Smart GWT Quickstart
 * Guide</em>. <P> <b>Data Integration</b> <P> DataSources provide a data-provider agnostic API to Smart GWT Visual
 * Components that  allow them to perform the 4 CRUD operations (<b>C</b>reate, <b>R</b>etrieve,  <b>U</b>pdate,
 * <b>D</b>elete).  By "agnostic" we mean that the implementation details -  the nuts and bolts of how a given DataSource
 * actually retrieves or updates data - are  unknown to bound Smart GWT components.  One effect of this is that DataSources
 * are  "pluggable": they can be replaced without affecting the User Interface. <p> When a visual component, or your own
 * custom code, performs a CRUD operation on a DataSource, the DataSource creates a {@link
 * com.smartgwt.client.data.DSRequest} (DataSource Request) representing the operation. "Data Integration" is the process
 * of fulfilling that DSRequest by creating a corresponding {@link com.smartgwt.client.data.DSResponse} (DataSource
 * Response), by using a variety of possible approaches to  connect to the ultimate data provider.   <p> There are two main
 * approaches to integrating DataSources with your server technology:  <ul> <li><b>Server-side integration</b>: DataSource
 * requests from the browser arrive as Java  Objects on the server. You deliver responses to the browser by returning Java
 * Objects. The various server-side integration possibilities are discussed later in this article.</li> <li>{@link
 * com.smartgwt.client.docs.ClientDataIntegration Client-side integration}: DataSource requests arrive as  simple HTTP
 * requests which your server code receives directly (in Java, you use the  Servlet API or .jsps to handle the requests).
 * Responses are sent as XML or JSON which you  directly generate.</li> </ul> The possible approaches are summarized in the
 * diagram below. Paths 2, 3 and 4 are  client-side integration approaches, and path 1 includes all server-side integration
 * approaches.  <p> <img src="skin/ClientServerIntegration.png" width="866px" height="495px"> <p> Smart GWT supports, out
 * of the box, codeless connectivity to various kinds of common data providers, including SQL and Hibernate.  Smart GWT
 * also provides functionality and tools for accelerated integration with broad categories of data providers, such as Java
 * Object-based persistence mechanisms (JPA, EJB, Ibatis, in-house written systems), and REST  and WSDL web services in XML
 * or JSON formats.  Ultimately, a DataSource can be connected to  anything that is accessible via HTTP or HTTPS, and also
 * to in-browser persistence engines  such as <a href='http://gears.google.com'
 * onclick="window.open('http://gears.google.com');return false;">Google Gears</a>. <p> <b>Choosing a Data Integration
 * Approach</b><p> This section aims to help you decide which of the many possible data integration approaches is best for
 * your particular circumstances.  The recommendations given here will guide you to the approach that involves the least
 * effort.<p> <img src="skin/dataIntegrationFlowchart.png" width="640px" height="300px"> <p> <ul> <li>If you have a Java
 * server:</li> <ul>   <li>If your ultimate storage is a SQL database:</li>     <ul>       <li>Use the SQLDataSource unless
 * you have a very large amount of pre-existing           JPA or Hibernate code - small amounts of business logic can be
 * easily migrated.           Be sure to read the overview of {@link com.smartgwt.client.docs.SqlVsJPA SQLDataSource vs    
 * JPA/Hibernate} in order to understand the large benefits the SQLDataSource provides</li>       <li>Derive DataSource
 * definitions from existing tables or Hibernate mappings using the           {@link
 * com.smartgwt.client.docs.serverds.DataSource#autoDeriveSchema autoDeriveSchema} feature, or from Java Beans          
 * via the {@link com.smartgwt.client.docs.serverds.DataSource#schemaBean schemaBean} feature.           Or, use the {@link
 * com.smartgwt.client.docs.AdminConsole Admin Console} to generate tables from DataSource           definitions you create
 * by hand</li>     </ul>   <li>If your ultimate storage is not a SQL database:</li>     <ul>       <li>If your persistence
 * is based on Java Beans, use the           {@link com.smartgwt.client.docs.serverds.DataSource#schemaBean schemaBean}
 * feature to derive DataSource definitions from            any Java bean</li>       <li>write a {@link
 * com.smartgwt.client.docs.WriteCustomDataSource custom DataSource} that provides the           CRUD operations you want
 * to support.</li>     </ul>   <li>Whether or not your storage is SQL, add business logic either declaratively in the     
 * DataSource definition, via {@link com.smartgwt.client.docs.DmiOverview DMI}, or any combination of the two:     <ul>    
 * <li>The &lt;criteria&gt; and &lt;values&gt; properties of an {@link com.smartgwt.client.data.OperationBinding}          
 * allow you to dynamically set data values at transaction-processing time, using            built-in {@link
 * com.smartgwt.client.docs.VelocitySupport Velocity support}</li>       <li>Override the <code>validate()</code> method of
 * the DataSource to provide extra           custom validations - just call <code>super</code> to obtain the list of errors
 * derived from Smart GWT validations, then add to that list as required with your           own custom code</li>      
 * <li>Override the <code>execute()</code> method of the DataSource to add extra processing           either before or
 * after the Smart GWT processing</li>       <li>Use  Transaction Chaining to dynamically set           data values
 * according to the results of earlier transactions</li>       <li>For SQL DataSources, use {@link
 * com.smartgwt.client.docs.CustomQuerying SQL Templating} to change,            add to or even completely replace the SQL
 * sent to the database, and to implement           special query requirements</li>       <li>For Hibernate DataSources,
 * use {@link com.smartgwt.client.data.OperationBinding#getCustomHQL custom HQL queries}           to implement special
 * query requirements</li>      </ul>      Read more about the server-side request processing flow and how to customize it
 * in      {@link com.smartgwt.client.docs.ServerDataIntegration the server integration overview}. </ul> </ul> <ul> <li>If
 * you do not have a Java server:</li>   <ul><li>If you are not obliged to use a pre-existing network protocol, use the    
 * {@link com.smartgwt.client.data.RestDataSource}</li>       <li>Otherwise, use {@link
 * com.smartgwt.client.docs.ClientDataIntegration client-side data integration} features           to create a custom
 * client-side DataSource that adapts the DataSource protocol to            your existing services</li>   </ul> </ul>
 * <p><br> <b>RPCs: Unstructured Server Communication</b> <P> Smart GWT also supports "unstructured" client-server
 * operations.  These  {@link com.smartgwt.client.rpc.RPCRequest}s (Remote Procedure Call Requests) are a low-level, very
 * flexible  mechanism for custom client-server communications.  In an nutshell, RPCRequests: <ul> <li> may contain
 * arbitrary data <li> are always initiated by custom code (a call to {@link com.smartgwt.client.rpc.RPCManager#send
 * RPCManager.send}), and have their responses handled by custom code (the callback passed to <code>send()</code>) </ul>
 * <P> RPCRequests are relatively rare.  Most client-server communications are better done in a  structured fashion using a
 * {@link com.smartgwt.client.data.DSRequest} (DataSource Request).  Note that <em>any</em> RPCRequest can alternatively be
 * framed as a {@link com.smartgwt.client.data.DataSource#fetchData DataSource fetch};  depending on the circumstances,
 * this may be more convenient. <P> See the {@link com.smartgwt.client.rpc.RPCManager} documentation for further
 * information on RPCRequests.
 */
public interface ClientServerIntegration {
}
