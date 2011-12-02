
package com.smartgwt.client.docs;

/**
 * <h3>Smart GWT Server Summary</h3>
 * The Smart GWT Server is a set of Java libraries, servlets and tools that provide the key server-side components needed
 * to build a complete application in the modern web architecture. <P> The Smart GWT Server can be {@link iscInstall
 * integrated} into any pre-existing Java application, and is designed to rapidly connect Smart GWT visual components to
 * pre-existing Java business logic or persistence engines.  Smart GWT's Ajax request processing facilities can be easily
 * integrated into Struts Actions, {@link com.smartgwt.client.docs.SpringIntegration Spring controllers}, or custom
 * servlets and JSPs. <P> Alternatively, the Smart GWT Server provides a complete SQL and Hibernate-based persistence
 * engine for new applications, with out-of-the-box servlets for processing Ajax data requests. <P> The Smart GWT Server is
 * optional, and Smart GWT's client-side Ajax engine can be integrated with any server that provides HTTP access, using
 * XML, JSON, SOAP or proprietary data protocols.  However any server in a modern web application will be required to
 * provide most or all of the features of the Smart GWT Server (described below), and the Smart GWT Server represents a
 * best-of-breed implementation of these facilities with a long history of high-volume production deployments. <P>
 * <h4>Server enforcement of {@link com.smartgwt.client.widgets.form.validator.Validator Validators}</h4> <P> Data passed
 * from the browser can be automatically validated by the Smart GWT Server. In contrast, when using {@link
 * com.smartgwt.client.docs.ClientDataIntegration client-side integration}, data arrives as HTTP params or XML messages,
 * and you must parse values into the correct types (eg java.util.Date) and validate them, or use a server framework that
 * does so. <P> <h4>High Speed Data Delivery / Data Compression</h4> <P> The Smart GWT Server delivers data to and from the
 * browser using a proprietary, maximally efficient protocol, providing simple Java APIs for sending and receiving data.
 * <P> Smart GWT's data protocol is: <ul> <li> automatically compressed: provides 6-8x improvement in bandwidth utilization
 * <li> efficient on the server: high speed data serialization for any Java Object <li> efficient in the browser: faster
 * than ordinary XML or JSON data delivery <li> minimal: facilities for {@link
 * com.smartgwt.client.data.DataSource#getDropExtraFields trimming} and {@link
 * com.smartgwt.client.data.DataSourceField#getValueXPath extracting} only the data you want the browser to see </ul> <P>
 * <h4>Transparent upload support</h4> <P> Smart GWT provides special client and server-side support for {@link
 * com.smartgwt.client.docs.Upload file upload}, which allows single and multiple-file HTTP uploads to be performed as a
 * background Ajax request without reloading the page or launching sub-windows. <P> Uploaded files arrive at the Smart GWT
 * server as Java InputStreams accessible from the DSRequest object, and can optionally be automatically stored via Smart
 * GWT's SQL subsystem. <P> <h4>Transparent Queuing / "Batch" Operations</h4> <P> Any request transmitted to the Smart GWT
 * Server can be combined into a "queue" transmitted as a single HTTP request, with in-order execution for all queued
 * operations.  {@link com.smartgwt.client.rpc.RPCManager#startQueue startQueue()} starts a queue and {@link
 * com.smartgwt.client.rpc.RPCManager#sendQueue sendQueue()} transmits it; queuing is transparent to the code that
 * initiates the individual requests.  This enables: <ul> <li> re-use of data access operations across different screens
 * <li> easy implementation of transaction boundaries <li> simplified saving and loading of screens with complex,
 * master-detail views <li> guaranteed in-order processing of operations <li> more efficient network usage </ul> <P>
 * <h4>Visual Builder</h4> <P> {@link com.smartgwt.client.docs.VisualBuilder Visual Builder} is included with the Smart GWT
 * Server, and uses server features such as automatic SQL binding to provide a rapid prototyping environment. <P>
 * <h4>Automatic Bi-directional Java &lt; - &gt; JavaScript serialization and translation</h4> <P> Provides a powerful,
 * type-safe {@link com.smartgwt.client.rpc.RPCRequest#getData data transmission mechanism} for moving data between a Java
 * server and the browser.  <P> Any Java objects, including Java Beans, POJOs, Java Collections, XML DOMs and all Java
 * primitives, with any level of nesting, can be automatically serialized and delivered as JavaScript Objects to the Smart
 * GWT client-side components. <P> JavaScript Objects existing in the browser can likewise be automatically transmitted to
 * a Java Server and translated to Java Objects, with any level of nesting and automatic preservation of primitive types.
 * <P> <h4>SQL and Hibernate connectors</h4> <P> DataSources of serverType:"sql" or serverType:"hibernate" can generate and
 * execute queries against popular SQL engines or against the Hibernate ORM system, providing Smart GWT's {@link
 * com.smartgwt.client.widgets.DataBoundComponent}s with the four standard CRUD operations (create, retrieve, update,
 * delete) without writing any server-side code.  For rapid prototyping, these DataSources can even generate SQL tables
 * based on the DataSource declaration, using the {@link com.smartgwt.client.docs.AdminConsole} visual tool. <P>
 * Server-side APIs allow server-side modification of the request before it is executed (for example, to enforce security)
 * and post-processing of the request after execution (for example, to provide calculated values). <P> Both
 * serverType:"sql" and serverType:"hibernate" support the field-operator-value queries that can be generated by using the
 * {@link com.smartgwt.client.widgets.form.FilterBuilder} component (see <a
 * href="http://www.smartclient.com/smartgwt/showcase/#grid_nested_filter_builder" target="examples">example</a>). <P>
 * <h4>Rich, Standardized Request / Response protocol</h4> <P> The Smart GWT Server provides a standardized request and
 * response protocol designed for data-oriented "CRUD" operations (create, retrieve, update, delete). <P> This standardized
 * protocol automatically handles {@link com.smartgwt.client.data.DSRequest request metadata} (paging parameters, requested
 * sort order, original values of data being modified) and {@link com.smartgwt.client.data.DSResponse response metadata}
 * (error handling, cache management, session expiration etc). <P> Similar to the impact of Struts on early web
 * applications, this standardized protocol avoids developers in different groups inventing their own incompatible and
 * redundant request/response protocols, and allows developers to more easily learn code they didn't author. <P>
 * <h4>Bi-directional XPath binding to Java Objects</h4> <P> Most UI designs do not directly reflect the underlying Object
 * model and so some degree of translation is necessary in order to populate UI components with data and apply user changes
 * to the Java Object model.  This is often accomplished with brittle, difficult to understand data translation code
 * sprinkled throughout the system, done in a different way for every screen or component. <P> Smart GWT provides a
 * standard, {@link com.smartgwt.client.data.DataSourceField#getValueXPath XPath-based approach} to adapting any Java-based
 * Object model to the requirements of the UI design.  Data relevant to the application UI is centrally extracted in the
 * server-side {@link com.smartgwt.client.data.DataSource} layer, so that all UI components have a consistent, unified view
 * of the data model for both loading <b>and</b> saving data. <P> <h4>Broadest possible browser support</h4> <P> The Smart
 * GWT Server can compensate for facilities  {@link com.smartgwt.client.docs.PlatformDependencies missing or disabled in
 * certain browsers}, including ActiveX being disabled in IE6 and missing XML support in some versions of Apple's Safari
 * browser. <P> <h4>Transparent Proxying</h4> <P> {@link com.smartgwt.client.rpc.RPCManager#sendProxied Proxying} allows
 * Smart GWT applications to access web services, RSS feeds, HTML content and other data services in a secure manner
 * regardless of where they are located: across the enterprise or publicly available. <P> <h4>Optional {@link
 * com.smartgwt.client.docs.NetworkPerformance Network Performance} Module</h4> <P> Provides: <ul> <li> compressed delivery
 * of Smart GWT runtime, application logic and other assets such as CSS <li>  background download of Smart GWT and other
 * assets for zero user-perceived load time <li> on-the-fly stripping, combining and obfuscation of JavaScript (application
 * code and data) <li> browser cache control </ul> <P> <h4>Optional Messaging Module (aka server push)</h4> <P> The
 * ${isc.DocUtils.linkForDocNode('messaging', 'Messaging')} module allows the server to "push" messages to the client,
 * without client polling, for real-time monitoring/dashboarding applications.
 */
public interface IscServer {
}
