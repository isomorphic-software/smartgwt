
package com.smartgwt.client.docs;

/**
 * <h3>Server Features and Custom Persistence</h3>
 * The vast majority of the Smart GWT Server framework's key features are not specific to the
 * built-in SQL and Hibernate connectors, and still apply even when using a custom persistence
 * mechanism. <P> See the listing below of major features and how to apply them with custom
 * persistence: <p> <b>Server Data Binding:</b> Using the Smart GWT Server framework means that
 * the starting point for connecting to custom persistence logic is a clean Java API.  Smart GWT
 * provides Java <code>DSRequest</code> and <code>DSResponse</code> objects with all of the
 * methods necessary to handle data paging, sorting, validation error reporting, and other
 * features. In most cases, you can fulfill a DSResponse by simply returning one of your Java
 * business objects rather than worrying about how to encode objects to XML or JSON. Communication
 * with the browser is automatically handled with an efficient, compressed protocol.   <a
 * href="http://www.smartclient.com/smartgwtee/showcase/#orm_ds" target="examples">Custom
 * DataSource example</a>,  <a href="http://www.smartclient.com/smartgwtee/showcase/#dmi"
 * target="examples">DMI example</a> <p> <b>Data Selection (No DTOs):</b> When using a DataSource,
 * Java data you return in your <code>DSResponse</code> is automatically trimmed to just the
 * fields declared in the DataSource before delivery to the browser (see {@link
 * com.smartgwt.client.data.DataSource#getDropExtraFields dropExtraFields}).  This eliminates the
 * need to create  redundant <a href='http://en.wikipedia.org/wiki/Data_transfer_object'
 * onclick="window.open('http://en.wikipedia.org/wiki/Data_transfer_object');return false;">Data
 * Transfer Objects</a>  to express the list of fields that need to be delivered to the UI - the
 * DataSource already has this information, and can serve two purposes by both configuring UI
 * components and trimming relevant data, from a single definition. <P> Furthermore, DataSources
 * can extract specific fields from complex nested  object graphs via XPath expressions, for both
 * loading and saving of data. <a href="http://www.smartclient.com/smartgwtee/showcase/#javabeans"
 * target="examples">XPath Binding example</a> <p> <b>Server Validation:</b> Both client and
 * server validation are driven from declarations in a single DataSource definition.  You already
 * have a need to declare validators to drive Smart GWT's client-side validation; when you use the
 * Smart GWT Server framework you get automatic server-side enforcement of the same validation
 * rules, without the need to write any additional code. @see <a
 * href="http://www.smartclient.com/smartgwtee/showcase/#serverValidation"
 * target="examples">Server Validation example</a> <p> <b>Queuing:</b> Queuing allows multiple
 * data load or save requests from different UI  components to be transparently combined into a
 * single HTTP request with guaranteed in-order execution.  The type of DataSource handling each
 * request is not important, so queuing will work with your custom DataSource; in fact, a single
 * queue could contain operations to be  handled by many different types of DataSource.   @see <a
 * href="http://www.smartclient.com/smartgwtee/showcase/#transactionsFolder"
 * target="examples">Queuing examples</a> <p> <b>Declarative security:</b> The server framework
 * provides robust authentication and  authorization integration, to allow you to secure both
 * DataSource operations (data fetch  and update requests) and individual DataSource fields at
 * various granularities.  The  declarative security rules are expressed directly in the
 * <code>.ds.xml</code> file, and  allow you declare rules as simple as "all operations on this
 * DataSource require an  authenticated user", or as complex as "a user can only update this field
 * if he has role  'admin' and a call to the <code>isAuthorized()</code> method on a security
 * checking object we have stored in the <code>HttpSession</code> returns true".  Security rules
 * are applied  by the framework before and after a DSRequest is executed, so they are applied
 * even to  operations on completely custom DataSources. See  {@link
 * com.smartgwt.client.docs.serverds.OperationBinding#requiresRole requiresRole} and the
 * properties it links to for more details on  operation-level security, and {@link
 * com.smartgwt.client.docs.serverds.DataSourceField#viewRequiresAuthentication
 * viewRequiresAuthentication} and the  properties it links to for more details on field-level
 * security. <p> <b>Transaction Chaining:</b> allows one request in a queue of operations to
 * incorporate values from previously executed requests in the same queue.  This allows a series
 * of dependent operations - such as fetching a value from one DataSource to be used in a query on
 * another - to be defined with simple declarations right in the DataSource definition, with no
 * need to write a custom Java class to manually pass data between the different operations. Since
 * Transaction Chaining works strictly in terms of DataSource requests and responses and knows
 * nothing about the underlying persistence mechanism, it works with any persistence strategy. <p>
 * <b>Java / JS Reflection:</b> Any Java object can be delivered to the browser as a JavaScript 
 * object, and vice versa.  As a developer of a custom DataSource, you do not need to concern 
 * yourself with dealing with translations to and from JSON or XML; you work directly with native
 * Java objects.  For example, a method you write to fulfill a "fetch" operation can simply return
 * a <code>Collection</code> of Java beans; the Smart GWT Server framework would  transparently
 * handle converting this into a matching Javascript structure. <a
 * href="http://www.smartclient.com/smartgwtee/showcase/#master_detail_batch"
 * target="examples">Saving nested objects example</a> <p> <b>Visual Builder:</b> The DataSource
 * Wizards in Visual Builder are pluggable; we provide wizards for SQL and Hibernate DataSources,
 * and it is easy to write a new wizard to integrate  your custom DataSource into Visual Builder. 
 * <a href="http://www.smartclient.com/smartgwtee/showcase/#tools_ds_wizard" target="examples">SQL
 * Wizard screenshots</a>, <a
 * href="http://www.smartclient.com/smartgwtee/showcase/#hibernate_wizard"
 * target="examples">Hibernate Wizard screenshots</a> <p> <b>Batch DataSource Generator:</b> If
 * the persistence scheme you are implementing your  custom DataSource for is based on collections
 * of Javabeans, the Batch DataSource Generator  can generate DataSource definition files for
 * instances of your custom DataSource.  This is out of the box behavior, but you can also alter
 * and extend the DataSource Generator to suit  your exact needs - we supply the source and it has
 * been specifically designed to be easy  to modify. <p> <b>Batch Uploader:</b> A user interface
 * for end-to-end batch upload of data as a pre-built,  customizable component.  This component -
 * like any Smart GWT databound component - only cares that a DataSource is a DataSource, so
 * custom DataSources will work just like built-in ones.  <a
 * href="http://www.smartclient.com/smartgwtee/showcase/#batch_uploader" target="examples">Batch
 * Uploader example</a> <p> <b>File Upload:</b> Single and multiple file uploads can be handled as
 * a normal DataSource  operation, including normal handling of validation errors. Optional
 * automatic storage to SQL  (no server code required) means you can upload to SQL tables for
 * holding files, which can be related to Java Objects by id (eg, a User's uploaded files).  <a
 * href="http://www.smartclient.com/smartgwtee/showcase/#upload" target="examples">File Upload
 * example</a> <p> <b>Export:</b> Allows any grid component to export its current dataset in CSV,
 * XML or JSON format.  This feature works by issuing the DataSource with an ordinary "fetch", and
 * then  changing the <code>DSResponse</code> to send back an import file rather than a resultset.
 * Accordingly, this just works with custom DataSources.  <a
 * href="http://www.smartclient.com/smartgwtee/showcase/#excel_export" target="examples">Export
 * example</a> <p> <b>HTTP Proxy:</b> The HTTP Proxy allows an application to access web services
 * hosted on  remote servers which are not normally accessible to web applications due to the  <a
 * href='http://www.google.com/search?q=same+origin+policy'
 * onclick="window.open('http://www.google.com/search?q=same+origin+policy');return false;">"same
 * origin policy"</a>). This is a general feature of the Smart GWT Server framework that does not
 * directly apply to DataSources.  <a
 * href="http://www.smartclient.com/smartgwtee/showcase/#data_integration_server_rss"
 * target="examples">HTTP Proxy example</a> <p> <b>Lightweight Persistence / Reporting:</b> Even
 * while using a custom DataSource to connect to a custom ORM system, you can still make use of
 * the SQL DataSource for simple storage-only entities where an object-based representation is a
 * waste of time.  You can also do this for reporting scenarios that don't correspond to the
 * object model.
 */
public interface FeaturesCustomPersistence {
}
