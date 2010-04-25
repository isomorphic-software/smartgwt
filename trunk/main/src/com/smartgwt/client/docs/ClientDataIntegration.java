
package com.smartgwt.client.docs;

/**
 * <h3>Client-side Data Integration</h3>
 * Smart GWT supports declarative, XPath-based binding of visual components to any server&#010 capable of returning XML or
 * JSON responses over HTTP, without the need for the&#010 {@link com.smartgwt.client.docs.ServerDataIntegration 'Smart GWT
 * server'}.&#010 <P>&#010 This approach is called Client-Side Data Integration, which means:&#010 <ul>&#010 <li> You
 * {@link com.smartgwt.client.docs.DataSourceDeclaration 'create DataSources'} in JavaScript &#010 which describe the data
 * to be loaded and manipulated in the user interface. The&#010 JavaScript that creates these DataSources may be
 * dynamically generated and/or existing&#010 metadata may be {@link com.smartgwt.client.docs.MetadataImport
 * 'imported'}.&#010 <li> You configure DataSources, via property and method overrides, to send appropriate&#010 HTTP
 * requests to your server, and to parse HTTP responses from your server, in order to&#010 fulfill the 4 core operations of
 * the {@link com.smartgwt.client.docs.DataSourceOperations 'DataSource Protocol'}.&#010 <li> These DataSources are then
 * bound to &#010 {@link com.smartgwt.client.widgets.DataBoundComponent}, which can provide a variety of&#010 complete user
 * interactions (form-based editing, grid-based editing, load on demand, ..)&#010 based on these 4 core operations&#010
 * </ul>&#010 <P>&#010 <h4>Approaches and platforms</h4>&#010 <P>&#010 <B>WSDL integration (.NET and others)</B>&#010
 * <P>&#010 If you have pre-existing WSDL services or would like to generate web services for&#010 Smart GWT to consume,
 * the {@link com.smartgwt.client.docs.WsdlBinding 'WSDL Binding Overview'} covers possible&#010 approaches.&#010 <P>&#010
 * WSDL binding is the most popular approach for integration with the .NET platform.&#010 You can &#010 <a
 * href='http://www.google.com/search?q=create+web+service+visual+studio'
 * onclick="window.open('http://www.google.com/search?q=create+web+service+visual+studio');return false;">use Visual Studio
 * to create web services</a>&#010 from existing server-side methods, and then use Smart GWT's &#010 {@link
 * com.smartgwt.client.docs.WsdlBinding 'WSDL Binding'} system to connect to those web services.  &#010 <P>&#010 Here are a
 * couple of examples of integration with .NET web services:&#010 <a
 * href='/examples/databinding/dotNET/temperatureConvert.jsp'
 * onclick="window.open('/examples/databinding/dotNET/temperatureConvert.jsp');return false;">temperature conversion
 * service</a>,&#010 and <a href='/examples/databinding/dotNET/customerSearch.jsp'
 * onclick="window.open('/examples/databinding/dotNET/customerSearch.jsp');return false;">customer search service</a>.&#010
 * Both use the {@link com.smartgwt.client.data.WebService#callOperation WebService.callOperation} method to query the web
 * service. <b>Note:</b>&#010 These examples will only work if there's a web service running at the WSDL URLs used in the
 * examples.&#010 <P>&#010 <B>REST integration (PHP and others)</B>&#010 <P>&#010 For PHP and other server technologies
 * (Cold Fusion, Ruby, Python, Perl..), integration&#010 is based on simple XML or JSON delivered over HTTP, sometimes
 * called the&#010 <a href='http://www.google.com/search?hl=en&q=REST+HTTP'
 * onclick="window.open('http://www.google.com/search?hl=en&q=REST+HTTP');return false;">REST</a> (REpresentational
 * State&#010 Transfer) pattern.&#010 <P> &#010 When using this, you create a dynamic web page that generates XML or JSON
 * data for&#010 Smart GWT to consume.&#010 <P>&#010 Smart GWT DataSources can be configured to work with any pre-existing
 * XML or JSON formats&#010 your application is already using; see below.&#010 <P>&#010 For new applications, the {@link
 * com.smartgwt.client.data.RestDataSource} provides a complete XML or JSON-based&#010 protocol that supports all of the
 * features of Smart GWT's databinding layer (data paging,&#010 server-side validation errors, automatic cache
 * synchronization, etc).  To use the&#010 RestDataSource, simply write server code that can parse RestDataSource requests
 * and produce&#010 the required responses; example requests and responses are {@link
 * com.smartgwt.client.data.RestDataSource}.&#010 <P>&#010 <h4>Consuming Existing XML and JSON formats</h4>&#010 <p>&#010
 * For WSDL web services, see the {@link com.smartgwt.client.docs.WsdlBinding 'WSDL binding topic'} first.&#010 <P>&#010 To
 * display XML or JSON data in a visual component such as a ListGrid, you bind the component&#010 to a {@link
 * com.smartgwt.client.data.DataSource} which provides the {@link com.smartgwt.client.data.DataSource#getDataURL 'URL'} of
 * the service, as&#010 well as a declaration of how to form inputs to the service and how to interpret service&#010
 * responses as DataSource records.&#010 <P>&#010 An XPath expression, the {@link
 * com.smartgwt.client.data.OperationBinding#getRecordXPath 'recordXPath'}, is applied to&#010 the service response to
 * select the XML elements or JSON objects that should be interpreted&#010 as DataSource records.  Then, for each field of
 * the DataSource, an optional&#010 {@link com.smartgwt.client.data.DataSourceField#getValueXPath valueXPath} can be
 * declared which selects the value for the field&#010 from within each of the XML elements or JSON objects selected by the
 * recordXPath.  If no&#010 valueXPath is specified, the field name itself is taken as an XPath, which will select the&#010
 * same-named subelement or property from the record element or object.&#010 <P>&#010 For example, the following code
 * defines a DataSource that a ListGrid could bind to in order&#010 to display an RSS 2.0 feed.&#010 <PRE>&#010   
 * isc.DataSource.create({&#010        dataURL:feedURL,&#010        recordXPath:"//item",&#010        fields:[&#010        
 * { name:"title" },&#010            { name:"link" },&#010            { name:"description" }&#010        ]&#010    });&#010
 * </PRE>&#010 A representative slice of an RSS 2.0 feed follows:&#010 <pre>&#010     &lt;?xml version="1.0"
 * encoding="iso-8859-1" ?&gt; &#010     &lt;rss version="2.0"&gt;&#010     &lt;channel&gt;&#010       &lt;title&gt;feed
 * title&lt;/title&gt; &#010       ...&#010       &lt;item&gt;&#010         &lt;title&gt;article title&lt;/title&gt; &#010 
 * &lt;link&gt;url of article&lt;/link&gt; &#010         &lt;description&gt;&#010            article description&#010      
 * &lt;/description&gt; &#010       &lt;/item&gt;&#010       &lt;item&gt;&#010          ...&#010 </pre>&#010 Here, the
 * recordXPath selects a list of &lt;item&gt; elements.  Since the intended values&#010 for each DataSource field appear as
 * simple subelements of each &lt;item&gt; element (eg&#010 &lt;description&gt;), the field name is sufficient to select
 * the correct values, and no&#010 explicit valueXPath needs to be specified.&#010 <P>&#010 A running version of this
 * example is available here: ${isc.DocUtils.linkForExampleId('rssFeed')}.  Further&#010 examples of simple XML or JSON
 * data loading using files stored on disk as the&#010 "service" to contact: the
 * ${isc.DocUtils.linkForExampleId('simpleJSON', 'Simple JSON')} example shows loading&#010 data from a JSON file into a
 * databound grid, and the&#010 ${isc.DocUtils.linkForExampleId('xpathBinding', 'XPath Binding example')} shows loading XML
 * and processing it with&#010 XPaths.&#010 <P>&#010 <H4>Round Tripping: Loading, Editing and Saving</H4>&#010 <P>&#010 For
 * WSDL web services, see the {@link com.smartgwt.client.docs.WsdlBinding 'WSDL binding topic'} first.&#010 <P>&#010 When a
 * user triggers a DSRequest (eg, completes an inline edit in a grid), the request&#010 data will be sent to the dataURL. 
 * The {@link com.smartgwt.client.docs.DataSourceOperations 'DataSource protocol'}&#010 describes request and response data
 * expected for each operation type.  &#010 <P>&#010 By using settings such as {@link
 * com.smartgwt.client.data.OperationBinding#getDataProtocol dataProtocol}, you can control how&#010 DSRequests are sent to
 * your backend so that you can handle them most easily.  By using the&#010 same properties used to initially load data
 * (eg&#010 {@link com.smartgwt.client.data.OperationBinding#getRecordXPath 'recordXPath'}), you can control how Smart GWT
 * forms the&#010 DSResponses that are then interpreted by {@link com.smartgwt.client.widgets.DataBoundComponent}.&#010
 * <P>&#010 <b>Controlling how DSRequests are sent</b>&#010 <P>&#010 According to the {@link
 * com.smartgwt.client.data.OperationBinding#getDataProtocol 'protocol'} being used, the&#010 {@link
 * com.smartgwt.client.docs.DataSourceOperations 'DataSource request data'}, if any, either becomes HTTP&#010 params (sent
 * by GET or POST), or an XML message as put together by&#010 {@link com.smartgwt.client.data.DataSource#xmlSerialize
 * DataSource.xmlSerialize}.  For a DataSource invoking a WSDL-described web&#010 service, XML serialization automatically
 * handles namespacing and SOAP encoding.&#010 <P>&#010 Note that, by default, just {@link
 * com.smartgwt.client.data.DSRequest#getData data} is sent, not any of the metadata such&#010 as {@link
 * com.smartgwt.client.data.DSRequest#getStartRow startRow}.  This can be customized via&#010 {@link
 * com.smartgwt.client.data.DataSource#transformRequest DataSource.transformRequest}.&#010 <P>&#010 The URL to contact is
 * set via the {@link com.smartgwt.client.data.OperationBinding#getDataURL 'dataURL'}&#010 property.  If using a Web
 * Service, the <code>dataURL</code> defaults to the service location&#010 URL embedded in the WSDL file.&#010 <P>&#010 For
 * example, in the default configuration for non-WSDL binding, since&#010 {@link
 * com.smartgwt.client.data.OperationBinding#getDataProtocol 'dataProtocol'} is "getParams", {@link
 * com.smartgwt.client.data.DSRequest#getData data} is&#010 sent as HTTP params in an HTTP "GET" operation.  Given:&#010
 * <ul>&#010 <li> changes to an existing record, hence an "update" request&#010 <li> a {@link
 * com.smartgwt.client.data.DataSourceField#getPrimaryKey 'primaryKey'} field of "id" with value "5" on the&#010 record to
 * be updated&#010 <li> a field "age" being changed to "32"&#010 <li> "dataURL" of "save.php"&#010 </ul>&#010 You will see
 * an HTTP GET to the URL <code>save.php?id=5&age=32</code>.&#010 <P>&#010 <b>Forming a DSResponse from the response
 * data</b>&#010 <P>&#010 A {@link com.smartgwt.client.data.DSResponse} is created from the response data by using
 * XPath&#010 expressions declared in the schema ({@link com.smartgwt.client.data.OperationBinding#getRecordXPath
 * 'recordXPath'} and &#010 {@link com.smartgwt.client.data.DataSourceField#getValueXPath 'valueXPath'}) to extract
 * DataSource record and field&#010 values.&#010 <P>&#010 See the ${isc.DocUtils.linkForExampleId('xmlEditSave', '"Edit and
 * Save"')} example for sample XML responses for&#010 all four operationTypes.  &#010 <P>&#010 Similar to input processing,
 * by default DataSource layer metadata, such as&#010 {@link com.smartgwt.client.data.DSResponse#getStartRow startRow}, is
 * not extracted from the response data.  You can&#010 implement {@link
 * com.smartgwt.client.data.DataSource#transformResponse DataSource.transformResponse} to fill out the metadata fields
 * of&#010 the {@link com.smartgwt.client.data.DSResponse}, in order to allow more DataSource features, such as paging
 * and&#010 validation errors, to be used with a web service that supports such features.  &#010 <P>&#010 See the
 * ${isc.DocUtils.linkForExampleId('xmlServerValidationErrors', 'XML')} and &#010
 * ${isc.DocUtils.linkForExampleId('jsonServerValidationErrors', 'JSON')} versions of the transformResponse()&#010 example
 * for an example of providing validation errors in XML or JSON responses.
 * @see com.smartgwt.client.data.DataSourceField#getFieldValue
 * @see com.smartgwt.client.data.DataSource#getDataFormat
 * @see com.smartgwt.client.data.DataSource#getDataProtocol
 * @see com.smartgwt.client.data.DataSource#getUseHttpProxy
 * @see com.smartgwt.client.data.DataSource#getCallbackParam
 * @see com.smartgwt.client.data.DataSource#getRequestProperties
 * @see com.smartgwt.client.data.DataSource#getDataTransport
 * @see com.smartgwt.client.data.DataSource#getDropExtraFields
 * @see com.smartgwt.client.data.DataSource#getSendExtraFields
 * @see com.smartgwt.client.data.DataSource#getServiceNamespace
 * @see com.smartgwt.client.data.DataSource#getSchemaNamespace
 * @see com.smartgwt.client.data.DataSource#getRecordXPath
 * @see com.smartgwt.client.data.DataSource#getDataURL
 * @see com.smartgwt.client.data.DataSource#getTagName
 * @see com.smartgwt.client.data.DataSourceField#getValueXPath
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
 * @see com.smartgwt.client.types.DSDataFormat
 * @see com.smartgwt.client.types.DSProtocol
 */
public interface ClientDataIntegration {
}
