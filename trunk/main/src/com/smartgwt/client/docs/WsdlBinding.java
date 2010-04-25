
package com.smartgwt.client.docs;

/**
 * <h3>WSDL Binding</h3>
 * Smart GWT supports automated integration with WSDL-described web services.  This support&#010 consists of:&#010
 * <ul>&#010 <li> creation of SOAP XML messages from JavaScript application data, with automatic&#010 namespacing, and
 * support for both "literal" and "encoded" SOAP messaging, and "document" and&#010 "rpc" WSDL-SOAP bindings&#010 <li>
 * automatic decode of SOAP XML messages to JavaScript objects, with strong typing (eg an&#010 XML schema "date" type
 * becomes a JavaScript Date object)&#010 <li> {@link com.smartgwt.client.data.XMLTools#loadXMLSchema
 * XMLTools.loadXMLSchema} (contained in WSDL, or external),&#010 including translating XML Schema "restrictions" to ISC
 * {@link com.smartgwt.client.widgets.form.validator.Validator}&#010 </ul>&#010 <P>&#010 WSDL services can be contacted by
 * using {@link com.smartgwt.client.data.XMLTools#loadWSDL XMLTools.loadWSDL} or the&#010 {@link
 * com.smartgwt.client.docs.LoadWSDLTag '&lt;isc:loadWSDL&gt; JSP tag'} to load the service definition, then&#010 invoking
 * methods on the resulting {@link com.smartgwt.client.data.WebService} object.&#010 <P>&#010 {@link
 * com.smartgwt.client.data.WebService#callOperation WebService.callOperation} can be used to manually invoke operations
 * for&#010 custom processing (example using ${isc.DocUtils.linkForExampleId('wsdlOperation', 'public zipcode
 * service')},&#010 examples using .NET at&#010 <a href='/examples/databinding/dotNET/temperatureConvert.jsp'
 * onclick="window.open('/examples/databinding/dotNET/temperatureConvert.jsp');return
 * false;">/examples/databinding/dotNET/temperatureConvert.jsp</a>).&#010 <P>&#010 <b>Fetch-only DataSource
 * binding</b>&#010 <P>&#010 To bind a component to a web service operation, call&#010 <P>&#010 &nbsp;&nbsp;{@link
 * com.smartgwt.client.data.WebService#getFetchDS WebService.getFetchDS}&#010 <P>&#010 to obtain a DataSource which
 * describes the structure of an XML element or XML Schema type&#010 named <i>elementName</i>, which appears in the
 * response message for the operation named&#010 <i>operationName</i>.  A component bound to this DataSource will show
 * fields corresponding&#010 to the structure of the chosen XML element or type, that is, one field per subelement or&#010
 * attribute.  {@link com.smartgwt.client.widgets.grid.ListGrid#fetchData ListGrid.fetchData} called on this DataSource (or
 * on a&#010 component bound to it) will invoke the specified web service operation, using the&#010 {@link
 * com.smartgwt.client.data.Criteria} passed to fetchData() to fill out the input message via&#010 {@link
 * com.smartgwt.client.data.DataSource#xmlSerialize DataSource.xmlSerialize}, and using the specified XML element from the
 * response&#010 message as data.&#010 <P>&#010 Similarly, {@link com.smartgwt.client.data.WebService#getInputDS
 * WebService.getInputDS} returns&#010 a DataSource suitable for binding to a form that a user will fill out to provide
 * inputs to&#010 the specified web service operation.  Typical use is to let the user fill in the form, then&#010 pass the
 * results of {@link com.smartgwt.client.widgets.form.DynamicForm#getValues DynamicForm.getValues} to&#010 {@link
 * com.smartgwt.client.widgets.grid.ListGrid#fetchData ListGrid.fetchData} as criteria.&#010 <P>&#010 If the input message
 * to the web service has extra nesting, consider using&#010 the {@link
 * com.smartgwt.client.data.OperationBinding#getUseFlatFields 'useFlatFields'} property to simplify the inputs&#010
 * required for <code>fetchData()</code>, and/or to simplify form databinding via&#010 {@link
 * com.smartgwt.client.widgets.DataBoundComponent#getUseFlatFields 'component.useFlatFields'}.&#010 <P>&#010 Note that the
 * WSDL tab in the Developer Console can provide a clean, simplified view of any &#010 WSDL file, making it easier to pick
 * out the appropriate <code>operationName</code> and&#010 <code>elementName</code> parameters to pass to
 * <code>getFetchDS()</code> and other&#010 {@link com.smartgwt.client.data.WebService} methods.&#010 <P>&#010 Take a look
 * at the ${isc.DocUtils.linkForExampleId('wsdlBinding', 'Google SOAP Search example')} and the&#010 <a
 * href='/examples/databinding/dotNET/customerSearch.jsp'
 * onclick="window.open('/examples/databinding/dotNET/customerSearch.jsp');return false;">.NET example</a>&#010
 * (/examples/databinding/dotNET/customerSearch.jsp).&#010 <P>&#010 <b>Binding with Customized Presentation</b>&#010
 * <P>&#010 Because XML Schema lacks key presentation metadata such as user-viewable titles, typically&#010 you cannot
 * directly use the DataSources derived from XML Schema embedded in a WSDL file to&#010 drive visual component DataBinding
 * in your final application.&#010 <P>&#010 You can create a DataSource that has custom fields <b>and</b> invokes a
 * web&#010 service operation by setting {@link com.smartgwt.client.data.DataSource#getServiceNamespace serviceNamespace}
 * to match the targetNamespace&#010 of the {@link com.smartgwt.client.data.WebService} (found on the
 * <code>&lt;definitions&gt;</code> element from the&#010 WSDL file), and setting {@link
 * com.smartgwt.client.data.OperationBinding#getWsOperation 'wsOperation'} to the name of the&#010 web service operation to
 * invoke.  <code>fetchData()</code> called on such a DataSource will&#010 invoke the web service operation named by {@link
 * com.smartgwt.client.data.OperationBinding#getWsOperation 'wsOperation'},&#010 just like a DataSource returned by {@link
 * com.smartgwt.client.data.WebService#getFetchDS WebService.getFetchDS}.&#010 <P>&#010 In contrast to
 * <code>getFetchDS()</code>, creating a DataSource in this way gives you the&#010 opportunity to:&#010 <ul>&#010 <li>
 * declare arbitrary fields, with Smart GWT presentation attributes such as titles and&#010 formatters&#010 <li> extract
 * any data from the response message, via&#010 {@link com.smartgwt.client.data.OperationBinding#getRecordXPath
 * 'operationBinding.recordXPath'} and &#010 {@link com.smartgwt.client.data.DataSourceField#getValueXPath
 * 'field.valueXPath'}, and transform it with&#010 {@link com.smartgwt.client.data.DataSource#transformResponse
 * DataSource.transformResponse}&#010 <li> transform the inbound data, if necessary, in order to add metadata such as&#010
 * {@link com.smartgwt.client.data.DSRequest#getStartRow startRow} for paging, or a sessionId for a service requiring
 * authentication&#010 </ul>&#010 These techniques are shown in the ${isc.DocUtils.linkForExampleId('wsdlBinding', 'Google
 * SOAP Search example')}.&#010 <P>&#010 <b>XML Schema Reuse</b>&#010 <P>&#010 Having loaded a WSDL file, all of the XML
 * Schema definitions within the service definition&#010 get translated to Smart GWT {@link
 * com.smartgwt.client.data.DataSource} and&#010 {@link com.smartgwt.client.data.SimpleType} via the rules described by
 * {@link com.smartgwt.client.data.XMLTools#loadXMLSchema XMLTools.loadXMLSchema},&#010 and are available to you via {@link
 * com.smartgwt.client.data.WebService#getSchema WebService.getSchema} and {@link
 * com.smartgwt.client.data.DataSourceField#getType type}. &#010 <P>&#010 You can use the {@link
 * com.smartgwt.client.data.DataSource#getInheritsFrom inheritsFrom} property to create DataSources that extend&#010 from
 * XML schema definitions, then add presentation metadata not found in XML schema.&#010 <P>&#010 Even if you choose to
 * declare all fields manually, you can leverage XML Schema&#010 &lt;simpleType&gt; definitions by setting {@link
 * com.smartgwt.client.data.DataSourceField#getType 'field.type'} to the name&#010 of an XML Schema simple type embedded in
 * the WSDL file.&#010 <P>&#010 <b>Round Trip Binding [fetch -> edit -> save]</b>&#010 <P>&#010 For full read-write
 * integration with a service that supports the basic&#010 {@link com.smartgwt.client.docs.DataSourceOperations 'DataSource
 * operations'} on persistent data, &#010 {@link com.smartgwt.client.data.OperationBinding} can be declared for each
 * DataSource operation, and&#010 the {@link com.smartgwt.client.data.OperationBinding#getWsOperation 'wsOperation'}
 * property can be used to to bind each&#010 {@link com.smartgwt.client.docs.DataSourceOperations 'DataSource operation'}
 * (fetch, update, add, remove) to a&#010 corresponding web service operation.&#010 <P>&#010 For example, this code
 * accomplishes part of the binding to the &#010 <a href='http://www.google.com/search?q=sforce+partner+wsdl'
 * onclick="window.open('http://www.google.com/search?q=sforce+partner+wsdl');return false;">SalesForce partner web
 * services</a>&#010 (additional code is required to handle authentication and other details):&#010 <pre>&#010
 * isc.DataSource.create({&#010    serviceNamespace : "urn:partner.soap.sforce.com",&#010    operationBindings : [&#010    
 * { operationType:"fetch", wsOperation:"query", recordName: "sObject" },&#010        { operationType:"update",
 * wsOperation:"update", recordName: "SaveResult" },&#010        { operationType:"add", wsOperation:"create", recordName:
 * "SaveResult" },&#010        { operationType:"remove", wsOperation:"delete", recordName: "DeleteResult" }&#010    ],&#010
 * ...&#010 }); &#010 </pre>&#010 NOTE: additional code is required to handle authentication and other details, see
 * the&#010 complete code in smartclientSDK/examples/databinding/SalesForce.&#010 <P>&#010 In this usage, any DSRequest
 * performed on this DataSource invokes the web service operation&#010 named by the <code>wsOperation</code> property on
 * the corresponding operationBinding, and&#010 {@link com.smartgwt.client.data.DSRequest#getData data} is serialized via
 * {@link com.smartgwt.client.data.DataSource#xmlSerialize DataSource.xmlSerialize} to form the input&#010 message to send
 * to the web service.  For example, if a {@link com.smartgwt.client.widgets.form.DynamicForm#saveData
 * DynamicForm.saveData} is&#010 invoked and triggers a DSRequest with operationType:"add", the DataSource above will
 * invoke&#010 the "create" operation, and {@link com.smartgwt.client.widgets.form.DynamicForm#getValues
 * DynamicForm.getValues} will become&#010 {@link com.smartgwt.client.data.DSRequest#getData data} and be serialized to
 * form the input message of the "create" web&#010 service operation.&#010 <P>&#010 Typical usage is:&#010 <ol>&#010 <li>
 * declare a DataSource that represents the fields of the object as you want them&#010 represented in the UI.  This
 * DataSource is considered the "entity DataSource".  It may&#010 extend from an XML Schema complex type via {@link
 * com.smartgwt.client.data.DataSource#getInheritsFrom inheritsFrom}.&#010 <li> use {@link
 * com.smartgwt.client.data.OperationBinding} to configure the entity DataSource to&#010 call the appropriate web service
 * operations for each DataSource operation, and extract&#010 results via&#010 {@link
 * com.smartgwt.client.data.OperationBinding#getRecordXPath 'recordXPath'}/{@link
 * com.smartgwt.client.data.OperationBinding#getRecordName 'recordName'}&#010 <li> bind components as follows:&#010
 * <ul>&#010 <li> bind {@link com.smartgwt.client.widgets.grid.ListGrid} to the entity DataSource&#010 <li> bind {@link
 * com.smartgwt.client.widgets.form.SearchForm} to the input message of the fetch operation&#010 (obtained via {@link
 * com.smartgwt.client.data.WebService#getInputDS WebService.getInputDS}.  This is&#010 done because search inputs are
 * frequently unrelated to the structure of the objects being&#010 searched for&#010 <li> bind forms use for editing ("add"
 * and "update" operations) to the entity DataSource&#010 </ul>&#010 <li> use&#010 {@link
 * com.smartgwt.client.data.DataSource#transformRequest DataSource.transformRequest}/{@link
 * com.smartgwt.client.data.DataSource#transformResponse DataSource.transformResponse}, &#010 {@link
 * com.smartgwt.client.data.OperationBinding#getUseFlatFields useFlatFields} and {@link
 * com.smartgwt.client.data.OperationBinding#getResponseDataSchema responseDataSchema} to&#010 handle inconsistencies
 * between the WSDL operations and the data you want in the presentation&#010 layer.&#010 </ol>&#010 A complete example of
 * binding to the SalesForce "partner" web service, including&#010 authentication via SOAP headers, saving data and cache
 * sync, inline editing, validation&#010 error handling and data paging, can be found in
 * [webroot]/examples/databinding/SalesForce.&#010 <P>&#010 This requires a SalesForce account.  SalesForce currently
 * offers &#010 <a href='http://www.google.com/search?hl=en&q=salesforce+developer+account'
 * onclick="window.open('http://www.google.com/search?hl=en&q=salesforce+developer+account');return false;">free developer
 * accounts</a>.&#010 Please note: this application deals with <b>live data</b> and if you using inline editing&#010 <b>it
 * will save to SalesForce</b>.&#010 <P>&#010 <b>Deployment</b>&#010 <P>&#010 For best performance, using the {@link
 * com.smartgwt.client.docs.LoadWSDLTag '&lt;isc:loadWSDL&gt; JSP tag'}&#010 is recommended, as it automatically caches a
 * translated form of the WSDL file.  If you are&#010 not using the Smart GWT server, the WSDL tab in the Developer Console
 * allows you&#010 to save a .js file representing a WebService object, which can then be loaded and cached&#010 like a
 * normal JavaScript file.&#010 <P>&#010 <B>Creating New WSDL Services</B>&#010 <P>&#010 If you have no existing WSDL web
 * service but would like to use web services for integration,&#010 you can implement the "Smart GWTOperations" web service
 * described by the&#010 ${isc.DocUtils.externalLink(isc.Page.getIsomorphicDir()+"system/schema/Smart
 * GWTOperations.wsdl","WSDL file")} &#010 included in the SDK.  This simple, 4 operation web service can support any
 * number of&#010 DataSources.  In this case, you create your DataSources as client-side instances of&#010 {@link
 * com.smartgwt.client.data.WSDataSource} (general client-side DataSource creation is described under&#010 {@link
 * com.smartgwt.client.docs.DataSourceDeclaration 'Creating DataSources'}).  To change the URL where ISC&#010 expects to
 * find the Smart GWTOperations web service, use {@link com.smartgwt.client.data.WebService#setLocation
 * WebService.setLocation}&#010 like so:<pre>&#010      var service =
 * isc.WebService.get("urn:operations.smartclient.com");&#010      service.setLocation("myURL");&#010 </pre>&#010 <P>&#010
 * To implement a web service <b>starting from a WSDL file</b>:&#010 <ul>&#010 <li>In the .NET framework, you will use the
 * Web Services Description Language Tool &#010 <a href='http://www.google.com/search?q=wsdl.exe'
 * onclick="window.open('http://www.google.com/search?q=wsdl.exe');return false;">(wsdl.exe)</a> to generate C# stubs
 * that&#010 you will add business logic to&#010 <li>In Java, <a href='http://ws.apache.org/axis/'
 * onclick="window.open('http://ws.apache.org/axis/');return false;">Apache Axis</a> can be used to generate&#010 Java
 * stubs for implementing a web service&#010 <li>In Perl, the <a href='http://soaplite.com'
 * onclick="window.open('http://soaplite.com');return false;">SOAP:Lite</a> module can be used to&#010 implement web
 * services without code generation&#010 <li>for PHP, the NuSoap module can likewise be used to implement web services
 * without code&#010 generation&#010 </ul>
 * @see com.smartgwt.client.data.DataSource#getServiceNamespace
 * @see com.smartgwt.client.data.DataSource#getSchemaNamespace
 */
public interface WsdlBinding {
}
