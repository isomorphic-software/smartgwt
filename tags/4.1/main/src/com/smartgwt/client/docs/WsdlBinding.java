
package com.smartgwt.client.docs;

/**
 * <h3>WSDL Binding</h3>
 * Smart GWT supports automated integration with WSDL-described web services.  This support
 *  consists of:
 *  <ul>
 *  <li> creation of SOAP XML messages from JavaScript application data, with automatic
 *  namespacing, and support for both "literal" and "encoded" SOAP messaging, and "document" and
 *  "rpc" WSDL-SOAP bindings
 *  <li> automatic decode of SOAP XML messages to JavaScript objects, with strong typing (eg an
 *  XML schema "date" type becomes a JavaScript Date object)
 * <li> {@link com.smartgwt.client.data.XMLTools#loadXMLSchema import of XML Schema} (contained in
 * WSDL, or external),
 * including translating XML Schema "restrictions" to ISC {@link
 * com.smartgwt.client.widgets.form.validator.Validator Validators}
 *  </ul>
 *  <P>
 * WSDL services can be contacted by using {@link com.smartgwt.client.data.XMLTools#loadWSDL
 * XMLTools.loadWSDL} or the
 *  {@link loadWSDLTag &lt;isc:loadWSDL&gt; JSP tag} to load the service definition, then
 *  invoking methods on the resulting {@link com.smartgwt.client.data.WebService} object.
 *  <P>
 * {@link com.smartgwt.client.data.WebService#callOperation WebService.callOperation} can be used
 * to manually invoke operations for
 * custom processing (example using <a
 * href="http://www.smartclient.com/smartgwtee/showcase/#data_integration_server_wsdl_generic"
 * target="examples">public zipcode service</a>,
 *  examples using .NET at
 * <a href='/examples/databinding/dotNET/temperatureConvert.jsp'
 * onclick="window.open('/examples/databinding/dotNET/temperatureConvert.jsp');return
 * false;">/examples/databinding/dotNET/temperatureConvert.jsp</a>).
 *  <P>
 *  <b>Fetch-only DataSource binding</b>
 *  <P>
 *  To bind a component to a web service operation, call
 *  <P>
 * &nbsp;&nbsp;{@link com.smartgwt.client.data.WebService#getFetchDS
 * WebService.getFetchDS(<i>operationName,elementName</i>)}
 *  <P>
 *  to obtain a DataSource which describes the structure of an XML element or XML Schema type
 *  named <i>elementName</i>, which appears in the response message for the operation named
 *  <i>operationName</i>.  A component bound to this DataSource will show fields corresponding
 *  to the structure of the chosen XML element or type, that is, one field per subelement or
 * attribute.  {@link com.smartgwt.client.widgets.grid.ListGrid#fetchData fetchData()} called on
 * this DataSource (or on a
 *  component bound to it) will invoke the specified web service operation, using the
 * {@link com.smartgwt.client.data.Criteria} passed to fetchData() to fill out the input message
 * via
 * {@link com.smartgwt.client.data.DataSource#xmlSerialize DataSource.xmlSerialize}, and using the
 * specified XML element from the response
 *  message as data.
 *  <P>
 * Similarly, {@link com.smartgwt.client.data.WebService#getInputDS
 * WebService.getInputDS(<i>operationName</i>)} returns
 *  a DataSource suitable for binding to a form that a user will fill out to provide inputs to
 *  the specified web service operation.  Typical use is to let the user fill in the form, then
 * pass the results of {@link com.smartgwt.client.widgets.form.DynamicForm#getValues
 * form.getValues()} to
 *  {@link com.smartgwt.client.widgets.grid.ListGrid#fetchData fetchData()} as criteria.
 *  <P>
 *  If the input message to the web service has extra nesting, consider using
 * the {@link com.smartgwt.client.data.OperationBinding#getUseFlatFields useFlatFields} property
 * to simplify the inputs
 *  required for <code>fetchData()</code>, and/or to simplify form databinding via
 * {@link com.smartgwt.client.widgets.DataBoundComponent#getUseFlatFields
 * component.useFlatFields}.
 *  <P>
 *  Note that the WSDL tab in the Developer Console can provide a clean, simplified view of any 
 *  WSDL file, making it easier to pick out the appropriate <code>operationName</code> and
 *  <code>elementName</code> parameters to pass to <code>getFetchDS()</code> and other
 *  {@link com.smartgwt.client.data.WebService} methods.
 *  
 *  <P>
 *  <b>Binding with Customized Presentation</b>
 *  <P>
 *  Because XML Schema lacks key presentation metadata such as user-viewable titles, typically
 *  you cannot directly use the DataSources derived from XML Schema embedded in a WSDL file to
 *  drive visual component DataBinding in your final application.
 *  <P>
 *  You can create a DataSource that has custom fields <b>and</b> invokes a web
 * service operation by setting {@link com.smartgwt.client.data.DataSource#getServiceNamespace
 * serviceNamespace} to match the targetNamespace
 * of the {@link com.smartgwt.client.data.WebService} (found on the
 * <code>&lt;definitions&gt;</code> element from the
 * WSDL file), and setting {@link com.smartgwt.client.data.OperationBinding#getWsOperation
 * wsOperation} to the name of the
 *  web service operation to invoke.  <code>fetchData()</code> called on such a DataSource will
 * invoke the web service operation named by {@link
 * com.smartgwt.client.data.OperationBinding#getWsOperation wsOperation},
 * just like a DataSource returned by {@link com.smartgwt.client.data.WebService#getFetchDS
 * WebService.getFetchDS}.
 *  <P>
 *  In contrast to <code>getFetchDS()</code>, creating a DataSource in this way gives you the
 *  opportunity to:
 *  <ul>
 *  <li> declare arbitrary fields, with Smart GWT presentation attributes such as titles and
 *  formatters
 *  <li> extract any data from the response message, via
 * {@link com.smartgwt.client.data.OperationBinding#getRecordXPath operationBinding.recordXPath}
 * and 
 * {@link com.smartgwt.client.data.DataSourceField#getValueXPath field.valueXPath}, and transform
 * it with
 *  {@link com.smartgwt.client.data.DataSource#transformResponse transformResponse()}
 *  <li> transform the inbound data, if necessary, in order to add metadata such as
 * {@link com.smartgwt.client.data.DSRequest#getStartRow startRow} for paging, or a sessionId for
 * a service requiring authentication
 *  </ul>
 * These techniques are shown in the <a
 * href="http://www.smartclient.com/smartgwtee/showcase/#data_integration_server_wsdl_generic"
 * target="examples">Google SOAP Search example</a>.
 *  <P>
 *  <b>XML Schema Reuse</b>
 *  <P>
 *  Having loaded a WSDL file, all of the XML Schema definitions within the service definition
 *  get translated to Smart GWT {@link com.smartgwt.client.data.DataSource DataSources} and
 * {@link com.smartgwt.client.data.SimpleType SimpleTypes} via the rules described by {@link
 * com.smartgwt.client.data.XMLTools#loadXMLSchema XMLTools.loadXMLSchema},
 * and are available to you via {@link com.smartgwt.client.data.WebService#getSchema
 * WebService.getSchema} and {@link com.smartgwt.client.data.DataSourceField#getType type}. 
 *  <P>
 * You can use the {@link com.smartgwt.client.data.DataSource#getInheritsFrom inheritsFrom}
 * property to create DataSources that extend
 *  from XML schema definitions, then add presentation metadata not found in XML schema.
 *  <P>
 *  Even if you choose to declare all fields manually, you can leverage XML Schema
 * &lt;simpleType&gt; definitions by setting {@link
 * com.smartgwt.client.data.DataSourceField#getType field.type} to the name
 *  of an XML Schema simple type embedded in the WSDL file.
 *  <P>
 *  <b>Round Trip Binding [fetch -> edit -> save]</b>
 *  <P>
 *  For full read-write integration with a service that supports the basic
 * {@link com.smartgwt.client.docs.DataSourceOperations DataSource operations} on persistent data,
 * 
 * {@link com.smartgwt.client.data.OperationBinding OperationBindings} can be declared for each
 * DataSource operation, and
 * the {@link com.smartgwt.client.data.OperationBinding#getWsOperation wsOperation} property can
 * be used to to bind each
 * {@link com.smartgwt.client.docs.DataSourceOperations DataSource operation} (fetch, update, add,
 * remove) to a
 *  corresponding web service operation.
 *  <P>
 *  For example, this code accomplishes part of the binding to the 
 * <a href='http://www.google.com/search?q=sforce+partner+wsdl'
 * onclick="window.open('http://www.google.com/search?q=sforce+partner+wsdl');return
 * false;">SalesForce partner web services</a>
 *  (additional code is required to handle authentication and other details):
 *  <pre>
 *  isc.DataSource.create({
 *     serviceNamespace : "urn:partner.soap.sforce.com",
 *     operationBindings : [
 *         { operationType:"fetch", wsOperation:"query", recordName: "sObject" },
 *         { operationType:"update", wsOperation:"update", recordName: "SaveResult" },
 *         { operationType:"add", wsOperation:"create", recordName: "SaveResult" },
 *         { operationType:"remove", wsOperation:"delete", recordName: "DeleteResult" }
 *     ],
 *     ...
 *  }); 
 *  </pre>
 *  NOTE: additional code is required to handle authentication and other details, see the
 *  complete code in smartclientSDK/examples/databinding/SalesForce.
 *  <P>
 *  In this usage, any DSRequest performed on this DataSource invokes the web service operation
 *  named by the <code>wsOperation</code> property on the corresponding operationBinding, and
 * {@link com.smartgwt.client.data.DSRequest#getData data} is serialized via {@link
 * com.smartgwt.client.data.DataSource#xmlSerialize DataSource.xmlSerialize} to form the input
 * message to send to the web service.  For example, if a {@link
 * com.smartgwt.client.widgets.form.DynamicForm#saveData DynamicForm.saveData} is
 *  invoked and triggers a DSRequest with operationType:"add", the DataSource above will invoke
 * the "create" operation, and {@link com.smartgwt.client.widgets.form.DynamicForm#getValues
 * form.values} will become
 * {@link com.smartgwt.client.data.DSRequest#getData data} and be serialized to form the input
 * message of the "create" web
 *  service operation.
 *  <P>
 *  Typical usage is:
 *  <ol>
 *  <li> declare a DataSource that represents the fields of the object as you want them
 *  represented in the UI.  This DataSource is considered the "entity DataSource".  It may
 * extend from an XML Schema complex type via {@link
 * com.smartgwt.client.data.DataSource#getInheritsFrom inheritsFrom}.
 * <li> use {@link com.smartgwt.client.data.OperationBinding operationBindings} to configure the
 * entity DataSource to
 *  call the appropriate web service operations for each DataSource operation, and extract
 *  results via
 * {@link com.smartgwt.client.data.OperationBinding#getRecordXPath recordXPath}/{@link
 * com.smartgwt.client.data.OperationBinding#getRecordName recordName}
 *  <li> bind components as follows:
 *  <ul>
 *  <li> bind {@link com.smartgwt.client.widgets.grid.ListGrid grids} to the entity DataSource
 * <li> bind {@link com.smartgwt.client.widgets.form.SearchForm SearchForms} to the input message
 * of the fetch operation
 * (obtained via {@link com.smartgwt.client.data.WebService#getInputDS
 * webService.getInputDS("operationName")}.  This is
 *  done because search inputs are frequently unrelated to the structure of the objects being
 *  searched for
 *  <li> bind forms use for editing ("add" and "update" operations) to the entity DataSource
 *  </ul>
 *  <li> use
 * {@link com.smartgwt.client.data.DataSource#transformRequest transformRequest}/{@link
 * com.smartgwt.client.data.DataSource#transformResponse transformResponse}, 
 * {@link com.smartgwt.client.data.OperationBinding#getUseFlatFields useFlatFields} and {@link
 * com.smartgwt.client.data.OperationBinding#getResponseDataSchema responseDataSchema} to
 *  handle inconsistencies between the WSDL operations and the data you want in the presentation
 *  layer.
 *  </ol>
 *  A complete example of binding to the SalesForce "partner" web service, including
 *  authentication via SOAP headers, saving data and cache sync, inline editing, validation
 *  error handling and data paging, can be found in [webroot]/examples/databinding/SalesForce.
 *  <P>
 *  This requires a SalesForce account.  SalesForce currently offers 
 * <a href='http://www.google.com/search?hl=en&q=salesforce+developer+account'
 * onclick="window.open('http://www.google.com/search?hl=en&q=salesforce+developer+account');return
 * false;">free developer accounts</a>.
 *  Please note: this application deals with <b>live data</b> and if you using inline editing
 *  <b>it will save to SalesForce</b>.
 *  <P>
 *  <b>Deployment</b>
 *  <P>
 *  For best performance, using the {@link loadWSDLTag &lt;isc:loadWSDL&gt; JSP tag}
 *  is recommended, as it automatically caches a translated form of the WSDL file.  If you are
 *  not using the Smart GWT server, the WSDL tab in the Developer Console allows you
 *  to save a .js file representing a WebService object, which can then be loaded and cached
 *  like a normal JavaScript file.
 *  <P>
 *  <B>Creating New WSDL Services</B>
 *  <P>
 *  If you have no existing WSDL web service but would like to use web services for integration,
 *  you can implement the "Smart GWTOperations" web service described by the
 * ${isc.DocUtils.externalLink(isc.Page.getIsomorphicDir()+"system/schema/Smart
 * GWTOperations.wsdl","WSDL file")} 
 *  included in the SDK.  This simple, 4 operation web service can support any number of
 *  DataSources.  In this case, you create your DataSources as client-side instances of
 * {@link com.smartgwt.client.data.WSDataSource} (general client-side DataSource creation is
 * described under
 * {@link com.smartgwt.client.docs.DataSourceDeclaration Creating DataSources}).  To change the
 * URL where ISC
 * expects to find the Smart GWTOperations web service, use {@link
 * com.smartgwt.client.data.WebService#setLocation WebService.setLocation}
 *  like so:<pre>
 *       var service = isc.WebService.get("urn:operations.smartclient.com");
 *       service.setLocation("myURL");
 *  </pre>
 *  <P>
 *  To implement a web service <b>starting from a WSDL file</b>:
 *  <ul>
 *  <li>In the .NET framework, you will use the Web Services Description Language Tool 
 * <a href='http://www.google.com/search?q=wsdl.exe'
 * onclick="window.open('http://www.google.com/search?q=wsdl.exe');return false;">(wsdl.exe)</a>
 * to generate C# stubs that
 *  you will add business logic to
 * <li>In Java, <a href='http://ws.apache.org/axis/'
 * onclick="window.open('http://ws.apache.org/axis/');return false;">Apache Axis</a> can be used
 * to generate
 *  Java stubs for implementing a web service
 * <li>In Perl, the <a href='http://soaplite.com'
 * onclick="window.open('http://soaplite.com');return false;">SOAP:Lite</a> module can be used to
 *  implement web services without code generation
 *  <li>for PHP, the NuSoap module can likewise be used to implement web services without code
 *  generation
 *  </ul>
 * @see com.smartgwt.client.data.DataSource#getServiceNamespace
 * @see com.smartgwt.client.data.DataSource#getSchemaNamespace
 */
public interface WsdlBinding {
}
