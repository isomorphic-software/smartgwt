
package com.smartgwt.client.docs;

/**
 * <h3>Client-side Data Integration</h3>
 * Smart GWT supports declarative, XPath-based binding of visual components to any server
 *  capable of returning XML or JSON responses over HTTP, without the need for the
 *  {@link com.smartgwt.client.docs.ServerDataIntegration Smart GWT server}.
 *  <P>
 *  This approach is called Client-Side Data Integration, which means:
 *  <ul>
 *  <li> You {@link com.smartgwt.client.docs.DataSourceDeclaration create DataSources} 
 *  
 *  programmatically in Java (with <code>new DataSource()</code>)
 *  which describe the data to be loaded and manipulated in the user interface. The
 *  JavaScript that creates these DataSources may be dynamically generated and/or existing
 *  metadata may be {@link metadataImport imported}.
 *  <li> You configure DataSources, via property and method overrides, to send appropriate
 *  HTTP requests to your server, and to parse HTTP responses from your server, in order to
 * fulfill the 4 core operations of the {@link com.smartgwt.client.docs.DataSourceOperations
 * DataSource Protocol}.
 *  <li> These DataSources are then bound to 
 * {@link com.smartgwt.client.widgets.DataBoundComponent databinding-capable UI components}, which
 * can provide a variety of
 *  complete user interactions (form-based editing, grid-based editing, load on demand, ..)
 *  based on these 4 core operations
 *  </ul>
 *  <P>
 *  <h4>Approaches and platforms</h4>
 *  <P>
 *  <B>REST integration with RestDataSource (preferred)</B>
 *  <P>
 * The {@link com.smartgwt.client.data.RestDataSource} provides a complete XML or JSON-based
 * protocol that supports all
 *  of the features of Smart GWT's databinding layer (data paging, queuing/batching of
 *  requests for transactions, nested AdvancedCriteria, server-side validation errors, automatic
 *  cache synchronization, etc).  To use the RestDataSource, simply write server code that can
 *  parse RestDataSource requests and produce the required responses; example requests and
 *  responses are {@link com.smartgwt.client.data.RestDataSource provided}.
 *  <P>
 *  The Smart GWT public wiki contains examples of integration with
 * <a href='http://wiki.smartclient.com/display/Main/Integrating+with+ASP.Net+MVC'
 * onclick="window.open('http://wiki.smartclient.com/display/Main/Integrating+with+ASP.Net+MVC');return
 * false;">.NET's ASP.NET MVC</a>
 *  as well as 
 * <a href='http://wiki.smartclient.com/pages/viewpage.action?pageId=1442411'
 * onclick="window.open('http://wiki.smartclient.com/pages/viewpage.action?pageId=1442411');return
 * false;">PHP with Doctrine</a>.
 *  <P>
 *  <h4>Consuming Existing XML and JSON formats</h4>
 *  <p>
 *  If you have pre-existing XML or JSON formats, Smart GWT DataSources can be configured to
 *  work with them.  However, <b>only use this approach if you are unable to modify a
 *  pre-existing protocol</b>.  If you have a choice, use RestDataSource.  
 *  <P>
 *  In particular, if you are choosing between tools that can automatically generate a REST
 *  service from an API vs using the pre-built RestDataSource protocol, <b>definitely use
 *  RestDataSource</b>.  Automatically generated REST interfaces will not handle the needs of a
 *  modern GUI, such as transactional/batched saves and user-ready validation error messages.
 *  For a deeper discussion, see 
 * <a href='http://forums.smartclient.com/showthread.php?t=8159#aExistingRest'
 * onclick="window.open('http://forums.smartclient.com/showthread.php?t=8159#aExistingRest');return
 * false;">this FAQ</a>.
 *  <P>
 *  Specifically for pre-existing WSDL web services, see the discussion of WSDL Integration
 *  below instead.
 *  <P>
 *  To display XML or JSON from a pre-existing service in a visual component such as a ListGrid,
 *  you bind the component to a {@link com.smartgwt.client.data.DataSource} which provides the
 * {@link com.smartgwt.client.data.DataSource#getDataURL URL} of the service, as well as a
 * declaration of how to form inputs
 *  to the service and how to interpret service responses as DataSource records.
 *  <P>
 * An XPath expression, the {@link com.smartgwt.client.data.OperationBinding#getRecordXPath
 * recordXPath}, is applied to
 *  the service response to select the XML elements or JSON objects that should be interpreted
 *  as DataSource records.  Then, for each field of the DataSource, an optional
 * {@link com.smartgwt.client.data.DataSourceField#getValueXPath valueXPath} can be declared which
 * selects the value for the field
 *  from within each of the XML elements or JSON objects selected by the recordXPath.  If no
 *  valueXPath is specified, the field name itself is taken as an XPath, which will select the
 *  same-named subelement or property from the record element or object.
 *  <P>
 *  For example, the following code defines a DataSource that a ListGrid could bind to in order
 *  to display an RSS 2.0 feed.
 *  <PRE>
 *     isc.DataSource.create({
 *         dataURL:feedURL,
 *         recordXPath:"//item",
 *         fields:[
 *             { name:"title" },
 *             { name:"link" },
 *             { name:"description" }
 *         ]
 *     });
 *  </PRE>
 *  A representative slice of an RSS 2.0 feed follows:
 *  <pre>
 *      &lt;?xml version="1.0" encoding="iso-8859-1" ?&gt; 
 *      &lt;rss version="2.0"&gt;
 *      &lt;channel&gt;
 *        &lt;title&gt;feed title&lt;/title&gt; 
 *        ...
 *        &lt;item&gt;
 *          &lt;title&gt;article title&lt;/title&gt; 
 *          &lt;link&gt;url of article&lt;/link&gt; 
 *          &lt;description&gt;
 *             article description
 *          &lt;/description&gt; 
 *        &lt;/item&gt;
 *        &lt;item&gt;
 *           ...
 *  </pre>
 *  Here, the recordXPath selects a list of &lt;item&gt; elements.  Since the intended values
 *  for each DataSource field appear as simple subelements of each &lt;item&gt; element (eg
 *  &lt;description&gt;), the field name is sufficient to select the correct values, and no
 *  explicit valueXPath needs to be specified.
 *  <P>
 * A running version of this example is available here: <a
 * href="http://www.smartclient.com/smartgwtee/showcase/#data_integration_server_rss"
 * target="examples">RSS Feed Example</a>.  Further
 *  examples of simple XML or JSON data loading using files stored on disk as the
 * "service" to contact: the <a
 * href="http://www.smartclient.com/smartgwt/showcase/#json_integration_category_simple"
 * target="examples">Simple JSON</a> example shows loading
 *  data from a JSON file into a databound grid, and the
 * <a href="http://www.smartclient.com/smartgwt/showcase/#xpath_xml_integration_category"
 * target="examples">XPath Binding example</a> shows loading XML and processing it with
 *  XPaths.
 *  <P>
 *  <B>WSDL integration</B>
 *  <P>
 *  If you have a choice between WSDL and REST integration, we recommend REST integration - it's
 *  simpler, requires less specialized knowledge, is easier to troubleshoot and is faster.  If
 * you need to use WSDL, see the {@link com.smartgwt.client.docs.WsdlBinding WSDL Binding
 * Overview}.
 *  <P>
 *  <H4>Round Tripping: Loading, Editing and Saving</H4>
 *  <P>
 * For WSDL web services, see the {@link com.smartgwt.client.docs.WsdlBinding WSDL binding topic}
 * first.
 *  <P>
 * When using RestDataSource, see the {@link com.smartgwt.client.data.RestDataSource} docs for
 * message formats for
 *  saving, as well as expected responses.
 *  <P>
 *  When a user triggers a DSRequest (eg, completes an inline edit in a grid), the request
 * data will be sent to the dataURL.  The {@link com.smartgwt.client.docs.DataSourceOperations
 * DataSource protocol}
 *  describes request and response data expected for each operation type.  
 *  <P>
 * By using settings such as {@link com.smartgwt.client.data.OperationBinding#getDataProtocol
 * dataProtocol}, you can control how
 *  DSRequests are sent to your backend so that you can handle them most easily.  By using the
 *  same properties used to initially load data (eg
 * {@link com.smartgwt.client.data.OperationBinding#getRecordXPath recordXPath}), you can control
 * how Smart GWT forms the
 * DSResponses that are then interpreted by {@link com.smartgwt.client.widgets.DataBoundComponent
 * databound components}.
 *  <P>
 *  <b>Controlling how DSRequests are sent</b>
 *  <P>
 * According to the {@link com.smartgwt.client.data.OperationBinding#getDataProtocol protocol}
 * being used, the
 * {@link com.smartgwt.client.docs.DataSourceOperations DataSource request data}, if any, either
 * becomes HTTP
 *  params (sent by GET or POST), or an XML message as put together by
 * {@link com.smartgwt.client.data.DataSource#xmlSerialize DataSource.xmlSerialize}.  For a
 * DataSource invoking a WSDL-described web
 *  service, XML serialization automatically handles namespacing and SOAP encoding.
 *  <P>
 * Note that, by default, just {@link com.smartgwt.client.data.DSRequest#getData data} is sent,
 * not any of the metadata such
 * as {@link com.smartgwt.client.data.DSRequest#getStartRow startRow}.  This can be customized via
 *  {@link com.smartgwt.client.data.DataSource#transformRequest DataSource.transformRequest}.
 *  <P>
 * The URL to contact is set via the {@link com.smartgwt.client.data.OperationBinding#getDataURL
 * dataURL}
 *  property.  If using a Web Service, the <code>dataURL</code> defaults to the service location
 *  URL embedded in the WSDL file.
 *  <P>
 *  For example, in the default configuration for non-WSDL binding, since
 * {@link com.smartgwt.client.data.OperationBinding#getDataProtocol dataProtocol} is "getParams",
 * {@link com.smartgwt.client.data.DSRequest#getData data} is
 *  sent as HTTP params in an HTTP "GET" operation.  Given:
 *  <ul>
 *  <li> changes to an existing record, hence an "update" request
 * <li> a {@link com.smartgwt.client.data.DataSourceField#getPrimaryKey primaryKey} field of "id"
 * with value "5" on the
 *  record to be updated
 *  <li> a field "age" being changed to "32"
 *  <li> "dataURL" of "save.php"
 *  </ul>
 *  You will see an HTTP GET to the URL <code>save.php?id=5&age=32</code>.
 *  <P>
 *  <b>Forming a DSResponse from the response data</b>
 *  <P>
 *  A {@link com.smartgwt.client.data.DSResponse} is created from the response data by using XPath
 * expressions declared in the schema ({@link
 * com.smartgwt.client.data.OperationBinding#getRecordXPath recordXPath} and 
 * {@link com.smartgwt.client.data.DataSourceField#getValueXPath valueXPath}) to extract
 * DataSource record and field
 *  values.
 *  <P>
 * See the <a
 * href="http://www.smartclient.com/smartgwt/showcase/#edit_save_xml_integration_category"
 * target="examples">"Edit and Save"</a> example for sample XML responses for
 *  all four operationTypes.  
 *  <P>
 *  Similar to input processing, by default DataSource layer metadata, such as
 * {@link com.smartgwt.client.data.DSResponse#getStartRow startRow}, is not extracted from the
 * response data.  You can
 * implement {@link com.smartgwt.client.data.DataSource#transformResponse
 * DataSource.transformResponse} to fill out the metadata fields of
 * the {@link com.smartgwt.client.data.DSResponse}, in order to allow more DataSource features,
 * such as paging and
 *  validation errors, to be used with a web service that supports such features.  
 *  <P>
 * See the <a href="http://www.smartclient.com/smartgwtee/showcase/#xmlServerValidationErrors"
 * target="examples">XML</a> and 
 * <a href="http://www.smartclient.com/smartgwt/showcase/#form_validation_server_json"
 * target="examples">JSON</a> versions of the transformResponse()
 *  example for an example of providing validation errors in XML or JSON responses.
 * @see com.smartgwt.client.data.DataSourceField#getFieldValue
 * @see com.smartgwt.client.data.DataSource#getDataFormat
 * @see com.smartgwt.client.data.DataSource#getDataProtocol
 * @see com.smartgwt.client.data.DataSource#getUseHttpProxy
 * @see com.smartgwt.client.data.DataSource#getCallbackParam
 * @see com.smartgwt.client.data.DataSource#getRequestProperties
 * @see com.smartgwt.client.data.DataSource#getDataTransport
 * @see com.smartgwt.client.data.DataSource#getDropExtraFields
 * @see com.smartgwt.client.data.DataSource#getSendExtraFields
 * @see com.smartgwt.client.data.DataSource#getXmlNamespaces
 * @see com.smartgwt.client.data.DataSource#getServiceNamespace
 * @see com.smartgwt.client.data.DataSource#getSchemaNamespace
 * @see com.smartgwt.client.data.DataSource#getRecordXPath
 * @see com.smartgwt.client.data.DataSource#getDataURL
 * @see com.smartgwt.client.data.DataSource#getTagName
 * @see com.smartgwt.client.data.DataSourceField#getValueXPath
 * @see com.smartgwt.client.docs.serverds.DataSourceField#valueWriteXPath
 * @see com.smartgwt.client.data.OperationBinding#getOperationType
 * @see com.smartgwt.client.data.OperationBinding#getOperationId
 * @see com.smartgwt.client.data.OperationBinding#getWsOperation
 * @see com.smartgwt.client.data.OperationBinding#getDataURL
 * @see com.smartgwt.client.data.OperationBinding#getDataProtocol
 * @see com.smartgwt.client.data.OperationBinding#getDataFormat
 * @see com.smartgwt.client.data.OperationBinding#getDataTransport
 * @see com.smartgwt.client.data.OperationBinding#getUseHttpProxy
 * @see com.smartgwt.client.data.OperationBinding#getCallbackParam
 * @see com.smartgwt.client.data.OperationBinding#getRequestProperties
 * @see com.smartgwt.client.data.OperationBinding#getDefaultParams
 * @see com.smartgwt.client.data.OperationBinding#getUseFlatFields
 * @see com.smartgwt.client.data.OperationBinding#getRecordXPath
 * @see com.smartgwt.client.data.OperationBinding#getRecordName
 * @see com.smartgwt.client.data.OperationBinding#getSpoofResponses
 * @see com.smartgwt.client.data.OperationBinding#getXmlNamespaces
 * @see com.smartgwt.client.data.OperationBinding#getResponseDataSchema
 * @see com.smartgwt.client.data.RestDataSource#getDataProtocol
 * @see com.smartgwt.client.types.DSDataFormat
 * @see com.smartgwt.client.types.DSProtocol
 */
public interface ClientDataIntegration {
}
