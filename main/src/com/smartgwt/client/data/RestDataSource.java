/*
 * Smart GWT (GWT for SmartClient)
 * Copyright 2008 and beyond, Isomorphic Software, Inc.
 *
 * Smart GWT is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License version 3
 * as published by the Free Software Foundation.  Smart GWT is also
 * available under typical commercial license terms - see
 * http://smartclient.com/license
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 */
/* sgwtgen */
 
package com.smartgwt.client.data;


import com.smartgwt.client.event.*;
import com.smartgwt.client.core.*;
import com.smartgwt.client.types.*;
import com.smartgwt.client.data.*;
import com.smartgwt.client.data.events.*;
import com.smartgwt.client.rpc.*;
import com.smartgwt.client.callbacks.*;
import com.smartgwt.client.tools.*;
import com.smartgwt.client.bean.*;
import com.smartgwt.client.widgets.*;
import com.smartgwt.client.widgets.events.*;
import com.smartgwt.client.widgets.form.*;
import com.smartgwt.client.widgets.form.validator.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.tile.*;
import com.smartgwt.client.widgets.tile.events.*;
import com.smartgwt.client.widgets.grid.*;
import com.smartgwt.client.widgets.grid.events.*;
import com.smartgwt.client.widgets.chart.*;
import com.smartgwt.client.widgets.layout.*;
import com.smartgwt.client.widgets.layout.events.*;
import com.smartgwt.client.widgets.menu.*;
import com.smartgwt.client.widgets.rte.*;
import com.smartgwt.client.widgets.rte.events.*;
import com.smartgwt.client.widgets.ace.*;
import com.smartgwt.client.widgets.ace.events.*;
import com.smartgwt.client.widgets.tab.*;
import com.smartgwt.client.widgets.toolbar.*;
import com.smartgwt.client.widgets.tree.*;
import com.smartgwt.client.widgets.tree.events.*;
import com.smartgwt.client.widgets.tableview.*;
import com.smartgwt.client.widgets.viewer.*;
import com.smartgwt.client.widgets.calendar.*;
import com.smartgwt.client.widgets.calendar.events.*;
import com.smartgwt.client.widgets.cube.*;
import com.smartgwt.client.widgets.drawing.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;
import com.smartgwt.client.util.*;
import com.smartgwt.client.util.events.*;
import com.smartgwt.client.util.workflow.*;
import com.google.gwt.event.shared.*;
import com.google.gwt.event.shared.HasHandlers;

/**
 * The RestDataSource implements the 4 core DataSource operations using a simple protocol of
 *  XML or JSON requests and responses sent over HTTP, which can be easily fulfilled by any HTTP
 *  server technology.
 *  <P>
 *  RestDataSource is named for the
 *  <a href='http://www.google.com/search?hl=en&q=REST+HTTP' target='_blank'>REST</a> (REpresentational State
 *  Transfer) pattern, which in brief says that simple messages passed over HTTP is a sufficient
 *  protocol for many web applications, without the need for further protocols such as WSDL or
 *  SOAP.
 *  <P>
 *  A RestDataSource is used just like a normal DataSource.  RestDataSources are pre-configured,
 *  using the general-purpose databinding facilities of DataSources, to expect a particular
 *  format for responses and to send requests in a specific format.   These request and
 *  response formats represent Isomorphic's recommended best practices for binding Smart GWT
 *  to backends which do not already support a similar, pre-existing request and response
 *  format and where the Smart GWT Java Server cannot be used.  
 *  <P>
 *  If you have a pre-existing REST or WSDL service which is difficult to change, consider
 *  adapting Smart GWT to the existing service instead, by starting with a normal
 *  {@link com.smartgwt.client.data.DataSource} and using the 
 *  {@link com.smartgwt.client.docs.ClientDataIntegration client-side data integration} facilities to create a
 * mapping between Smart GWT's {@link com.smartgwt.client.data.DSRequest} and {@link com.smartgwt.client.data.DSResponse}
 * objects and the message
 *  formats of your existing services.  <b>NOTE</b>: do <b>not</b> begin this process by
 *  creating or subclassing RestDataSource; for a <b>pre-existing</b> service which is unrelated
 *  to the protocol documented for RestDataSource, start by configuring or subclassing
 *  {@link com.smartgwt.client.data.DataSource} instead.
 *  <P>
 *  RestDataSource is typically used with PHP, Ruby, Python, Perl or custom server technologies,
 *  and represents an alternative to installing the Smart GWT Server in a Java technology
 *  stack, or using {@link com.smartgwt.client.docs.WsdlBinding WSDL-based binding} with .NET or other WSDL-capable
 *  technologies.  Note that Smart GWT Server also provides built-in support for the REST
 *  protocol via its RESTHandler servlet; this is primarily to allow non-Smart GWT clients
 *  to make use of DataSource operations.  If you particularly wished to do so, you could use
 *  RestDataSource to make a Smart GWT app talk to the Smart GWT Server using REST rather 
 *  than the proprietary wire format normally used when communicating with Smart GWT Server
 *  (this is how we are able to write automated tests for the RESTHandler servlet).  However,
 *  doing this provides no benefit, imposes a number of inconveniences, and makes a handful 
 *  of server-based features less useful 
 * ({@link com.smartgwt.client.docs.serverds.DataSourceField#viewRequiresAuthentication field-level declarative security},
 * for 
 *  example), so we strongly recommend that you do <em>not</em> do this; it is only mentioned
 *  here for completeness while we are discussing REST.
 *  <P>
 *  The request and response formats used by the RestDataSource allow for many of the available
 *  features of Smart GWT's databinding system to be used, including data paging, searching &
 *  sorting, {@link com.smartgwt.client.data.DSRequest#getOldValues long transactions}, 
 *  {@link com.smartgwt.client.data.ResultSet automatic cache sync}, {@link com.smartgwt.client.docs.Relogin relogin} and 
 *  {@link com.smartgwt.client.rpc.RPCManager#startQueue queuing}.  However,  advanced
 *  features such as {@link com.smartgwt.client.docs.Upload uploading / binary fields} and  
 * {@link com.smartgwt.client.widgets.grid.ListGrid#exportData export} aren't available with RestDataSource and need to be 
 *  re-implemented as needed.  Most, though not all, {@link com.smartgwt.client.docs.IscServer server-based features}
 *  are still available when using RestDataSource, as long as you are also using the RESTHandler 
 *  servlet that is part of Smart GWT Server.  However, as noted above, this approach is not 
 *  recommended; if you are using Isomorphic technology both client- and server-side, it makes
 *  more sense to use the proprietary wire format.
 *  <P>
 *  <b>RestDataSource and binary data</b>
 *  <P>
 *  Binary data in a response provided to a RestDataSource must be delivered as valid XML or
 *  JSON Strings.  Once delivered to the browser as Strings, there is no way to trigger the
 *  browser's "Save As" dialog to download the data, and in most cases no way to trigger other
 *  helper applications that might be launched to handle binary data (such as Excel or a PDF
 *  viewer).  Hence for binary it usually makes sense to make a direct request via
 *  RPCManager.sendRequest() with downloadResult:true, separate from RestDataSource.
 *  <P>
 *  If you are using the Smart GWT Server included in Pro, Power end Enterprise to handle your
 *  REST requests server-side, there is transparent support for conversion between Java 
 *  <code>InputStream</code>s representing binary data, and Strings containing that binary 
 *  data encoded using the <a href=http://en.wikipedia.org/wiki/Base64>Base64 algorithm</a>.
 *  Thus, on the server, the binary data is in its raw binary form, with transparent conversion
 *  to or from Base64 for messages to or from the REST client.
 *  <P>
 *  <span style="font-weight:bold;font-size:16px;">Examples</span>
 *  <p>
 *  <b>XML formatted responses:</b>
 *  <P>
 *  RestDataSource expects a response like the following in response to a "fetch" request:
 *  <pre>
 *  &lt;response&gt;
 *     &lt;status&gt;0&lt;/status&gt;
 *     &lt;startRow&gt;0&lt;/startRow&gt;
 *     &lt;endRow&gt;76&lt;/endRow&gt;
 *     &lt;totalRows&gt;546&lt;/totalRows&gt;
 *     &lt;data&gt;
 *       &lt;record&gt;
 *           &lt;field1&gt;value&lt;/field1&gt;
 *           &lt;field2&gt;value&lt;/field2&gt;
 *       &lt;/record&gt;
 *       &lt;record&gt;
 *           &lt;field1&gt;value&lt;/field1&gt;
 *           &lt;field2&gt;value&lt;/field2&gt;
 *       &lt;/record&gt;
 *       <i>... 76 total records ... </i>
 *     &lt;/data&gt;
 *  &lt;/response&gt;
 *  </pre>
 *  The &lt;status&gt; element indicates whether the fetch operation was successful 
 *  (see {@link com.smartgwt.client.docs.StatusCodes}).
 *  <P>
 *  The &lt;data&gt; element contains a list of record nodes, each of which represents a record
 *  returned by the server.  The optional &lt;startRow&gt;, &lt;endRow&gt; and &lt;totalRows&gt;
 *  elements are needed only if data paging is in use, and populate the
 * {@link com.smartgwt.client.data.DSResponse#getStartRow startRow}, {@link com.smartgwt.client.data.DSResponse#getEndRow
 * endRow} and
 * {@link com.smartgwt.client.data.DSResponse#getTotalRows totalRows} properties of the {@link
 * com.smartgwt.client.data.DSResponse}.
 *  <P>
 *  Note: for a more compact format, simple field values may be specified on record 
 *  nodes directly as attributes - in this case a record element might be structured like this:
 *  <pre>
 *      &lt;record field1="value" field2="value" /&gt;
 *  </pre>
 *  <p>
 *  Note that a RestDataSource will bypass browser caching of all responses by default.  See
 *  {@link com.smartgwt.client.data.DataSource#getPreventHTTPCaching DataSource.preventHTTPCaching}.
 *  <p>
 *  Successful "add" or "update" request responses are similar in format - in this case the data
 *  element would be expected to contain a single record object containing the details of the
 *  record, as saved on the server.
 *  <P>
 *  The response from a "remove" operation would again include status and data elements, but in
 *  this case, only the primary key field value(s) of the removed record would be expected to be 
 *  present under the data element.
 *  <p>
 *  If a validation failure occurred on the server, the response would
 * have status set to {@link com.smartgwt.client.rpc.RPCResponse#STATUS_VALIDATION_ERROR STATUS_VALIDATION_ERROR}
 * [<code>-4</code>],
 *  and any validation errors could be included as per-field sub-elements of an "errors"
 *  element.  For a validation error, the response is not expected to contain any
 *  &lt;data&gt; element.  
 *  <P>
 *  A response showing a validation error might look like this:
 *  <pre>
 *  &lt;response&gt;
 *     &lt;status&gt;-4&lt;/status&gt;
 *     &lt;errors&gt;
 *       &lt;field1&gt;
 *           &lt;errorMessage&gt;A validation error occurred for this field&lt;/errorMessage&gt;
 *       &lt;/field1&gt;
 *     &lt;/errors&gt;
 *  &lt;/response&gt;
 *  </pre>
 *  <P>
 *  An unrecoverable error, such as an unexpected server failure, can be flagged by setting
 *  &lt;status&gt; to -1 and setting &lt;data&gt; to an error message.  In this case the
 *  &lt;errors&gt; element is not used (it's specific to validation errors).  An unrecoverable
 * error causes all response processing to be skipped and {@link com.smartgwt.client.rpc.HandleErrorCallback#handleError
 * HandleErrorCallback.handleError()} to be
 *  invoked, which by default will show the provided error message as an alert using
 *  
 *  {@link com.smartgwt.client.util.SC#warn SC.warn()}.
 *  <p>
 *  <b>JSON formatted responses:</b>
 *  <P>
 *  JSON format responses are expected to contain the same data / meta-data as XMLresponses,
 *  encapsulated in a simple object with a <code>"response"</code> attribute.<br>
 *  The response to a "fetch" request would therefore have this format:<br>
 *  <pre>
 *  {
 *     "response": {
 *        "status": 0,
 *        "startRow": 0,
 *        "endRow": 76,
 *        "totalRows": 546,
 *        "data": [
 *            {"field1": "value", "field2": "value"},
 *            {"field1": "value", "field2": "value"},
 *            <i>... 76 total records ...</i>
 *        ]
 *     }
 *  }
 *  </pre>
 *  The structure successful for "add", "update" and "remove" responses would be similar, though
 *  the data array would be expected to contain only a single object, representing the values as
 *  saved.  This allows the server to return values such as an auto-generated sequence
 *  primaryKey, a last modified timestamp, or similar server-generated field values.
 *  <P>
 *  For a remove, only the value for the primaryKey field[s] would be required.
 *  <p>
 *  For a validation error, the <code>status</code> attribute would be set to 
 * {@link com.smartgwt.client.rpc.RPCResponse#STATUS_VALIDATION_ERROR STATUS_VALIDATION_ERROR} [<code>-4</code>], and
 * errors would
 *  be specified in the <code>errors</code> attribute of the response. For example:
 *  <pre>
 *  {    "response":
 *       {   "status": -4,
 *           "errors":
 *               {   "field1": {"errorMessage": "A validation error on field1"},
 *                   "field2": {"errorMessage": "A validation error on field2"}
 *               }
 *       }
 *  }
 *  </pre>
 *  An array of errors may also be returned for a single field, like this:
 *  <pre>
 *  {    "response":
 *       {   "status": -4,
 *           "errors":
 *               {   "field1": [
 *                       {"errorMessage": "First error on field1"},
 *                       {"errorMessage": "Second error on field1"}
 *                   ]
 *               }
 *       }
 *  }
 *  </pre>
 *  <P>
 *  As with the XML format above, an unrecoverable error is indicated by setting the
 *  <code>status</code> attribute to -1 and the <code>data</code> property to the error message.
 *  <P>
 *  <b>Server inbound data formats</b>
 *  <P>
 * The format of data sent to the server is determined by the {@link
 * com.smartgwt.client.data.OperationBinding#getDataProtocol OperationBinding.dataProtocol}
 *  specified for the operation. Request data is sent as parameters if the format is 
 *  specified as <code>"getParams"</code> or <code>"postParams"</code>.
 *  <P>
 *  In this case, the parameters sent to the server will consist of the DSRequest's data, and any
 * parameters explicitly specified on the DSRequest object (as {@link com.smartgwt.client.rpc.RPCRequest#getParams
 * RPCRequest.params}.<br> 
 *  If {@link com.smartgwt.client.data.RestDataSource#getSendMetaData sendMetaData} is true, the DSRequest meta 
 *  data properties will also be present as parameters, prefixed with 
 *  {@link com.smartgwt.client.data.RestDataSource#getMetaDataPrefix metaDataPrefix}.
 *  <P>
 *  Example URL constructed with the metaDataPrefix set to <code>"_"</code> (the default):
 *  <p>
 *  <code>
 * &nbsp;&nbsp;&nbsp;<i>[dataURL]</i>?field1=value1&_operationType=fetch&_startRow=0&_endRow=50&_sortBy=-field2&_dataSource=dsName
 *  </code>
 *  <p>
 *  In this case the server would be able to separate the request's data from the meta data 
 *  via the <code>"_"</code> prefix.
 *  <P>
 *  If data is sent to the server via the <code>"postMessage"</code> dataProtocol, the data will
 *  be serialized as an XML or JSON message according to the <code>dataFormat</code> setting.
 *  Both XML and JSON messages will contain request metadata such as startRow and endRow, and
 *  will appear exactly as though the subset of the {@link com.smartgwt.client.data.DSRequest} that is meaningful to the
 * server had been passed to {@link com.smartgwt.client.data.DataSource#xmlSerialize DataSource.xmlSerialize()} or {@link
 * com.smartgwt.client.util.JSON#encode JSON.encode()}
 *  respectively.
 *  <P>
 *  An example of an XML message might look like this:
 *  <pre>
 *     &lt;request&gt;
 *         &lt;data&gt;
 *             &lt;countryCode&gt;US&lt;/countryCode&gt;
 *             &lt;countryName&gt;Edited Value&lt;/countryName&gt;
 *             &lt;capital&gt;Edited Value&lt;/capital&gt;
 *             &lt;continent&gt;Edited Value&lt;/continent&gt;
 *         &lt;/data&gt;
 *         &lt;dataSource&gt;countryDS&lt;/dataSource&gt;
 *         &lt;operationType&gt;update&lt;/operationType&gt;
 *     &lt/request&gt;
 *  </pre>
 *  An example of an XML message for a fetch operation passing simple criteria:
 *  <pre>
 *     &lt;request&gt;
 *         &lt;data&gt;
 *             &lt;continent&gt;North America&lt;/continent&gt;
 *         &lt;/data&gt;
 *         &lt;dataSource&gt;countryDS&lt;/dataSource&gt;
 *         &lt;operationType&gt;fetch&lt;/operationType&gt;
 *         &lt;startRow&gt;0&lt;/startRow&gt;
 *         &lt;endRow&gt;75&lt;/endRow&gt;
 *         &lt;componentId&gt;worldGrid&lt;/componentId&gt;
 *         &lt;textMatchStyle&gt;exact&lt;/textMatchStyle&gt;
 *     &lt/request&gt;
 *  </pre>
 *  And an example of an XML message for a fetch operation passing AdvancedCriteria:
 *  <pre>
 *     &lt;request&gt;
 *         &lt;data&gt;
 *             &lt;_constructor&gt;AdvancedCriteria&lt;/_constructor&gt;
 *             &lt;operator&gt;or&lt;/operator&gt;
 *             &lt;criteria&gt;
 *                 &lt;criterion&gt;
 *                     &lt;fieldName&gt;continent&lt;/fieldName&gt;
 *                     &lt;operator&gt;equals&lt;/operator&gt;
 *                     &lt;value&gt;North America&lt;/value&gt;
 *                 &lt;/criterion&gt;
 *                 &lt;criterion&gt;
 *                     &lt;operator&gt;and&lt;/operator&gt;
 *                     &lt;criteria&gt;
 *                         &lt;criterion&gt;
 *                             &lt;fieldName&gt;continent&lt;/fieldName&gt;
 *                             &lt;operator&gt;equals&lt;/operator&gt;
 *                             &lt;value&gt;Europe&lt;/value&gt;
 *                         &lt;/criterion&gt;
 *                         &lt;criterion&gt;
 *                             &lt;fieldName&gt;population&lt;/fieldName&gt;
 *                             &lt;operator&gt;greaterThan&lt;/operator&gt;
 *                             &lt;value&gt;50000000&lt;/value&gt;
 *                         &lt;/criterion&gt;
 *                     &lt;/criteria&gt;
 *                 &lt;/criterion&gt;
 *             &lt;/criteria&gt;
 *         &lt;/data&gt;
 *         &lt;dataSource&gt;countryDS&lt;/dataSource&gt;
 *         &lt;operationType&gt;fetch&lt;/operationType&gt;
 *         &lt;startRow&gt;0&lt;/startRow&gt;
 *         &lt;endRow&gt;75&lt;/endRow&gt;
 *         &lt;componentId&gt;worldGrid&lt;/componentId&gt;
 *     &lt/request&gt;
 *  </pre>
 * An example of an XML message for a fetch operation when using {@link com.smartgwt.client.docs.ServerSummaries
 * server-side summaries}:
 *  <pre>
 *     &lt;request&gt;
 *         &lt;data&gt;&lt;/data&gt;
 *         &lt;dataSource&gt;countryDS&lt;/dataSource&gt;
 *         &lt;operationType&gt;fetch&lt;/operationType&gt;
 *         &lt;summaryFunctions&gt;
 *             &lt;pk&gt;count&lt;/pk&gt;
 *         &lt;/summaryFunctions&gt;
 *         &lt;groupBy&gt;member_g8&lt;/groupBy&gt;
 *     &lt/request&gt;
 *  </pre>
 *  JSON messages are just the plain JSON form of the structures shown in the above XML
 *  examples. The advanced criteria XML example above but in JSON form:
 *  <pre>
 *  {
 *      data: {
 *          _constructor: "AdvancedCriteria",
 *          operator: "or",
 *          criteria: [
 *              {
 *                  fieldName: "continent",
 *                  operator: "equals",
 *                  value: "North America
 *              },
 *              {
 *                  operator: "and", criteria: [
 *                      {
 *                          fieldName: "continent",
 *                          operator: "equals",
 *                          value: "Europe"
 *                      },
 *                      {
 *                          fieldName: "population",
 *                          operator: "greaterThan",
 *                          value: 50000000
 *                      }
 *                  ]
 *              }
 *          ]
 *      }
 *      dataSource: "countryDS",
 *      operationType: "fetch",
 *      startRow: 0,
 *      endRow: 75,
 *      componentId: "worldGrid"
 *  }
 *  </pre>
 *  The {@link com.smartgwt.client.data.RestDataSource#getOperationBindings default OperationBindings} for a RestDataSource
 *  specify dataProtocol as "getParams" for the fetch operation, and "postParams" for update,
 *  add and remove operations.  Note that most webservers impose a limit on the maximum size 
 *  of GET requests (specifically, on the size of the request URL + HTTP headers).  Using
 *  dataProtocol:"getParams" for "fetch" operations that involve complex AdvancedCriteria
 *  will result in a JSON serialization of the AdvancedCriteria in the request URL, and when
 *  combined with large cookies this can easily overflow the default limits on certain
 *  webservers (see
 * <a href='http://stackoverflow.com/questions/686217/maximum-on-http-header-values'
 * target='_blank'>http://stackoverflow.com/questions/686217/maximum-on-http-header-values</a>).
 *  For this reason, we recommend that you use the "postMessage" protocol whenever you are
 *  intending to use AdvancedCriteria with RestDataSource.
 * 
 *  <P>
 *  <b>Date, time and datetime values</b>
 *  <P>
 *  Date, time and datetime values must be communicated using XML Schema format, as in the 
 *  following examples:
 *  <pre>
 *  &nbsp;&nbsp;&lt;dateField&gt;2007-04-22&lt;/dateField&gt;
 *  &nbsp;&nbsp;&lt;timeField&gt;11:07:13&lt;/timeField&gt;
 *  &nbsp;&nbsp;&lt;dateTimeField&gt;2007-04-22T11:07:13&lt;/dateTimeField&gt;
 *  &nbsp;&nbsp;&lt;dateTimeField&gt;2007-04-22T11:07:13.582&lt;/dateTimeField&gt;
 *  </pre>
 *  <P>
 *  And the equivalent in JSON:
 *  <pre>
 *  &nbsp;&nbsp;dateField: "2007-04-22"
 *  &nbsp;&nbsp;timeField: "11:07:13"
 *  &nbsp;&nbsp;dateTimeField: "2007-04-22T11:07:13"
 *  &nbsp;&nbsp;dateTimeField: "2007-04-22T11:07:13.582"
 *  </pre>
 *  <P>
 *  Both RestDataSource on the client-side and the RESTHandler servlet on the server side 
 *  automatically handle encoding and decoding temporal values using these formats.  Both also
 *  handle datetime formats including or excluding milliseconds automatically.  When encoding,
 * both honor the {@link com.smartgwt.client.data.DataSource#getTrimMilliseconds DataSource.trimMilliseconds} setting on
 * the DataSource, falling back
 *  to the <code>server.properties</code> setting <code>rest.trimMilliseconds</code>; when
 *  decoding, both detect whether or not to try to parse milliseconds based on the string they 
 *  receive.
 *  <P>
 *  Fields of type "date" and "time" are considered to hold logical date and time values, as 
 *  discussed in the {@link com.smartgwt.client.docs.DateFormatAndStorage date and time handling article}, and are 
 *  not affected by timezones.  Fields of type "datetime" will be converted to UTC on the 
 *  client side by RestDataSource, and will be sent back down to the client as UTC by the 
 *  server-side RESTHandler.  We recommend that your own REST client and/or server code do the
 *  same thing (ie, transmit all datetime values in both directions as UTC).  Note that the 
 *  examples given above give no timezone information, and will be treated by the Smart GWT
 *  Server as UTC values.  If you wish to work with datetime values in a particular timezone,
 *  use a format like this:
 *  <pre>
 *  &nbsp;&nbsp;&lt;dateField&gt;2007-04-22T11:07:13-0800&lt;/dateField&gt;
 *  &nbsp;&nbsp;&lt;dateField&gt;2012-11-19T22:12:04+0100&lt;/dateField&gt;
 *  </pre>
 *  <p>
 *  And the equivalent in JSON:
 *  <pre>
 *  &nbsp;&nbsp;dateTimeField: "2007-04-22T11:07:13-0800"
 *  &nbsp;&nbsp;dateTimeField: "2012-11-19T22:12:04+0100"
 *  </pre>
 *  <P>
 *  <b>NOTE:</b> Although we refer above to XML Schema format, the format used for specifying
 *  timezone offset is slightly different from XML Schema - as shown in the above examples, you
 *  specify "+HHMM" or "-HHMM", as opposed to the XML Schema format which requires a ":" character
 *  between the hours and minutes.  The reason for this difference is simply that the Java 
 *  SimpleDateFormat class imposes it.
 *  <p>
 *  <b>RestDataSource queuing support</b>
 *  <P>
 *  RestDataSource supports {@link com.smartgwt.client.rpc.RPCManager#startQueue queuing} of DSRequests.  This allows 
 *  you to send multiple requests to the server in a single HTTP turnaround, thus minimizing 
 *  network traffic and allowing the server to treat multiple requests as a single transaction,
 *  if the server is able to do so (in Power Edition and above, the Smart GWT Server
 *  transparently supports grouping multiple REST requests in a queue into a single database
 *  transaction when using one of the built-in DataSource types).  Note that you can disable 
 *  queuing support with the {@link com.smartgwt.client.data.RestDataSource#getDisableQueuing disableQueuing} flag.
 *  <P>
 *  If you want to use queuing with RestDataSource, you must use the "postMessage" dataProtocol
 *  with either XML or JSON dataFormat.  Message format is similar to the non-queued examples 
 *  shown earlier: it is simply extended to cope with the idea of multiple DSRequests 
 *  encapsulated in the message.
 *  <P>
 *  An example of the XML message sent from RestDataSource to the server for two update requests
 *  combined into a queue, using XML dataFormat:
 *  <pre>
 *  &lt;transaction&gt;
 *      &lt;operations&gt;
 *          &lt;request&gt;
 *              &lt;data&gt;
 *                  &lt;pk&gt;1&lt;/pk&gt;
 *                  &lt;countryName&gt;Edited Value&lt;/countryName&gt;
 *                  &lt;capital&gt;Edited Value&lt;/capital&gt;
 *                  &lt;continent&gt;Edited Value&lt;/continent&gt;
 *              &lt;/data&gt;
 *              &lt;dataSource&gt;countryDS&lt;/dataSource&gt;
 *              &lt;operationType&gt;update&lt;/operationType&gt;
 *          &lt/request&gt;
 *          &lt;request&gt;
 *              &lt;data&gt;
 *                  &lt;pk&gt;2&lt;/pk&gt;
 *                  &lt;capital&gt;Edited Value&lt;/capital&gt;
 *                  &lt;population&gt;123456&lt;/population&gt;
 *              &lt;/data&gt;
 *              &lt;dataSource&gt;countryDS&lt;/dataSource&gt;
 *              &lt;operationType&gt;update&lt;/operationType&gt;
 *          &lt/request&gt;
 *      &lt;/operations&gt;
 *  &lt;transaction&gt;
 *  </pre>
 *  And the same message in JSON format:
 *  <pre>
 *  { 
 *      transaction: { 
 *          operations: [{
 *              dataSource:"countryDS", 
 *              operationType:"update", 
 *              data: {
 *                  pk: 1
 *                  countryName: "Edited Value",
 *                  capital: "Edited Value",
 *                  continent: "Edited Value"
 *              }
 *          }, {
 *              dataSource:"countryDS", 
 *              operationType:"update", 
 *              data: {
 *                  pk: 2,
 *                  capital: "Edited Value",
 *                  popuilation: 123456
 *              }
 *          }]
 *      }
 *  }
 *  </pre>
 *  RestDataSource expects the response to a queue of requests to be a queue of responses in 
 *  the same order as the original requests.  Again, the message format is very similar to the 
 *  unqueued REST format, it just has an outer container construct.  Note also that the 
 *  individual DSResponses in a queued response have an extra property, 
 *  {@link com.smartgwt.client.data.DSResponse#getQueueStatus <code>queueStatus</code>}.  This allows each individual
 *  response to determine whether the queue as a whole succeeded.  For example, if the first
 *  update succeeded but the second failed validation, the first response would have a
 *  <code>status</code> of 0, but a <code>queueStatus</code> of -1, while the second response
 *  would have both properties set to -1.
 *  <P>
 *  The update queue example given above would expect a response like this (in XML):
 *  <pre>
 *  &lt;responses&gt;
 *      &lt;response&gt;
 *          &lt;status&gt;0&lt;/status&gt;
 *          &lt;queueStatus&gt;0&lt;/queueStatus&gt;
 *          &lt;data&gt;
 *              &lt;record&gt;
 *                  &lt;countryName&gt;Edited Value&lt;/countryName&gt;
 *                  &lt;gdp&gt;1700.0&lt;/gdp&gt;
 *                  &lt;continent&gt;Edited Value&lt;/continent&gt;
 *                  &lt;capital&gt;Edited Value&lt;/capital&gt;
 *                  &lt;pk&gt;1&lt;/pk&gt;
 *              &lt;/record&gt;
 *          &lt;/data&gt;
 *      &lt;/response&gt;
 *      &lt;response&gt;
 *          &lt;status&gt;0&lt;/status&gt;
 *          &lt;queueStatus&gt;0&lt;/queueStatus&gt;
 *          &lt;data&gt;
 *              &lt;record&gt;
 *                  &lt;countryName&gt;United States&lt;/countryName&gt;
 *                  &lt;gdp&gt;7247700.0&lt;/gdp&gt;
 *                  &lt;continent&gt;North America&lt;/continent&gt;
 *                  &lt;independence&gt;1776-07-04&lt;/independence&gt;
 *                  &lt;capital&gt;Washington DC&lt;/capital&gt;
 *                  &lt;pk&gt;2&lt;/pk&gt;
 *                  &lt;population&gt;123456&lt;/population&gt;
 *              &lt;/record&gt;
 *          &lt;/data&gt;
 *      &lt;/response&gt;
 *  &lt;/responses&gt;
 *  </pre>
 *  And in JSON:
 *  <pre>
 *  [
 *  {
 *      "response": {
 *          "queueStatus": 0,
 *          "status": 0, 
 *          "data": [{
 *              "countryName": "Edited Value",
 *              "gdp": 1700.0,
 *              "continent": "Edited Value",
 *              "capital": "Edited Value",
 *              "pk": 1
 *          }]
 *      }
 *  },
 *  {
 *      "response": {
 *          "queueStatus": 0,
 *          "status": 0,
 *          "data": [{
 *              "countryName": "United States",
 *              "gdp": 7247700.0,
 *              "continent": "North America",
 *              "independence": "1776-07-04",
 *              "capital": "Washington DC",
 *              "pk": 2,
 *              "population": 123456
 *          }]
 *      }
 *  }
 *  ]
 *  </pre>
 *  <b>Hierarchical (Tree) data:</b>
 *  <P>
 *  To create a hierarchical DataSource, in the DataSource's <code>fields</code> array, a field 
 *  must be specified as the parent id field - the field which will contain a pointer to the
 *  id of each node's parent. 
 * This can be achieved by setting the {@link com.smartgwt.client.data.DataSourceField#getForeignKey
 * DataSourceField.foreignKey} and the 
 * {@link com.smartgwt.client.data.DataSourceField#getRootValue DataSourceField.rootValue} attributes on the field
 * definition. For example:
 *  <pre>
 *  RestDataSource.create({
 *     ID:"supplyItem",
 *     fields : [
 *         {name:"itemId", type:"sequence", primaryKey:true},
 *         {name:"parentId", type:"integer", foreignKey:"supplyItem.itemId", rootValue:0},
 *         ...
 *     ]
 *  });
 *  </pre>
 *  Tree Data is then treated on the server as a flat list of records linked by parent id.
 *  <P>
 * Tree data is typically displayed using a dataBound {@link com.smartgwt.client.widgets.tree.TreeGrid} component.
 * TreeGrids
 *  automatically create a {@link com.smartgwt.client.widgets.tree.ResultTree} data object, which requests data directly
 *  from the DataSource.  ResultTrees load data on demand, only requesting currently visible 
 *  (open) nodes from the server. This is handled by including a specified value for the parent 
 *  id field in the request criteria.<br>
 *  To implement a standard load-on-demand tree RestDataSource back end, you should therefore 
 *  simply return the set of nodes that match the criteria passed in. 
 *  For example, if your DataSource was defined as the "supplyItem" code snippet above, 
 *  a fetch request for all children of a node with <code>itemId</code> set to <code>12</code> 
 *  would have <code>"parentId"</code> set to <code>12</code> in the request criteria.
 *  A valid response would then contain all the records that matched this criteria. For example:
 *  <pre>
 *  &lt;response&gt;
 *     &lt;status&gt;0&lt;/status&gt;
 *     &lt;data&gt;
 *       &lt;record&gt;
 *           &lt;itemId&gt;15&lt;/itemId&gt;
 *           &lt;parentId&gt;12&lt;/parentId&gt;
 *       &lt;/record&gt;
 *       &lt;record&gt;
 *           &lt;itemId&gt;16&lt;/itemId&gt;
 *           &lt;parentId&gt;12&lt;/parentId&gt;
 *       &lt;/record&gt;
 *     &lt;/data&gt;
 *  &lt;/response&gt;
 *  </pre>
 *  The structure of responses for Add, Update and Delete type requests will be the 
 *  same regardless of whether the data is hierarchical. However you should be aware that 
 *  the underlying data storage may need to be managed slightly differently in some cases.
 *  <P>
 *  Specifically, Add and Update operations may change the structure of the tree by returning a 
 *  new parent id field value for the modified node. Depending on how your data is stored you 
 *  may need to include special back-end logic to handle this.
 *  <P>
 *  Also, if a user deletes a folder within a databound tree, any children of that folder will 
 *  also be dropped from the tree, and can be removed from the back-end data storage.
 *  <P>
 *  Note: For a general overview of binding components to Tree structured data, see 
 *  {@link com.smartgwt.client.docs.TreeDataBinding Tree Databinding}.
 */
@BeanFactory.FrameworkClass
@BeanFactory.ScClassName("RestDataSource")
public class RestDataSource extends DataSource {

    public static RestDataSource getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        BaseClass obj = BaseClass.getRef(jsObj);
        if(obj != null) {
            return (RestDataSource) obj;
        } else {
            return new RestDataSource(jsObj);
        }
    }
        


    public RestDataSource(){
        scClassName = "RestDataSource";
    }

    public RestDataSource(JavaScriptObject jsObj){
        scClassName = "RestDataSource";
        setJavaScriptObject(jsObj);
    }

    public native JavaScriptObject create()/*-{
        var config = this.@com.smartgwt.client.core.BaseClass::getConfig()();
        var scClassName = this.@com.smartgwt.client.core.BaseClass::scClassName;
        return $wnd.isc[scClassName].create(config);
    }-*/;

    // ********************* Properties / Attributes ***********************

    /**
     * Custom {@link com.smartgwt.client.data.DataSource#getDataURL dataURL} for {@link com.smartgwt.client.data.DSRequest
     * DSRequests} with {@link com.smartgwt.client.data.DSRequest#getOperationType operationType} "add". <p> See {@link
     * com.smartgwt.client.data.RestDataSource#getDataURL dataURL} to configure a single URL for all requests, which is
     * required to support {@link com.smartgwt.client.rpc.RPCManager#startQueue RPCManager.startQueue()}.
     *
     * @param addDataURL New addDataURL value. Default value is null
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setAddDataURL(String addDataURL)  throws IllegalStateException {
        setAttribute("addDataURL", addDataURL, false);
    }

    /**
     * Custom {@link com.smartgwt.client.data.DataSource#getDataURL dataURL} for {@link com.smartgwt.client.data.DSRequest
     * DSRequests} with {@link com.smartgwt.client.data.DSRequest#getOperationType operationType} "add". <p> See {@link
     * com.smartgwt.client.data.RestDataSource#getDataURL dataURL} to configure a single URL for all requests, which is
     * required to support {@link com.smartgwt.client.rpc.RPCManager#startQueue RPCManager.startQueue()}.
     *
     * @return Current addDataURL value. Default value is null
     */
    public String getAddDataURL()  {
        return getAttributeAsString("addDataURL");
    }
    

    /**
     * Expected format for server responses. RestDataSources handle <code>"json"</code> and <code>"xml"</code> format responses
     * by default. See class overview documentation for  examples of responses in each format.
     *
     * @param dataFormat New dataFormat value. Default value is "xml"
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setDataFormat(DSDataFormat dataFormat)  throws IllegalStateException {
        setAttribute("dataFormat", dataFormat == null ? null : dataFormat.getValue(), false);
    }

    /**
     * Expected format for server responses. RestDataSources handle <code>"json"</code> and <code>"xml"</code> format responses
     * by default. See class overview documentation for  examples of responses in each format.
     *
     * @return Current dataFormat value. Default value is "xml"
     */
    public DSDataFormat getDataFormat()  {
        return EnumUtil.getEnum(DSDataFormat.values(), getAttribute("dataFormat"));
    }
    

    /**
     * Rather than setting {@link com.smartgwt.client.data.DataSource#getDataProtocol DataSource.dataProtocol}, to control the
     * format in which  inputs are sent to the dataURL, you must specify a replacement {@link
     * com.smartgwt.client.data.OperationBinding}  and specify {@link com.smartgwt.client.data.OperationBinding#getDataProtocol
     * OperationBinding.dataProtocol} on that <code>operationBinding</code>. <P> This is because <code>RestDataSource</code>
     * specifies default <code>operationBindings</code> for all operationTypes - see {@link
     * com.smartgwt.client.data.RestDataSource#getOperationBindings operationBindings}.
     *
     * @param dataProtocol New dataProtocol value. Default value is null
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     * @see com.smartgwt.client.docs.ServerDataIntegration ServerDataIntegration overview and related methods
     */
    public void setDataProtocol(DSProtocol dataProtocol)  throws IllegalStateException {
        setAttribute("dataProtocol", dataProtocol == null ? null : dataProtocol.getValue(), false);
    }

    /**
     * Rather than setting {@link com.smartgwt.client.data.DataSource#getDataProtocol DataSource.dataProtocol}, to control the
     * format in which  inputs are sent to the dataURL, you must specify a replacement {@link
     * com.smartgwt.client.data.OperationBinding}  and specify {@link com.smartgwt.client.data.OperationBinding#getDataProtocol
     * OperationBinding.dataProtocol} on that <code>operationBinding</code>. <P> This is because <code>RestDataSource</code>
     * specifies default <code>operationBindings</code> for all operationTypes - see {@link
     * com.smartgwt.client.data.RestDataSource#getOperationBindings operationBindings}.
     *
     * @return Current dataProtocol value. Default value is null
     * @see com.smartgwt.client.docs.ServerDataIntegration ServerDataIntegration overview and related methods
     */
    public DSProtocol getDataProtocol()  {
        return EnumUtil.getEnum(DSProtocol.values(), getAttribute("dataProtocol"));
    }
    

    /**
     * Default URL to contact to fulfill all DSRequests.   RestDataSources also allow per-operationType dataURLs to be set via
     * <ul> <li>{@link com.smartgwt.client.data.RestDataSource#getFetchDataURL fetchDataURL}</li> <li>{@link
     * com.smartgwt.client.data.RestDataSource#getAddDataURL addDataURL}</li>  <li>{@link
     * com.smartgwt.client.data.RestDataSource#getUpdateDataURL updateDataURL}</li> <li>{@link
     * com.smartgwt.client.data.RestDataSource#getRemoveDataURL removeDataURL}</li> </ul> <b>NOTE:</b>: when using {@link
     * com.smartgwt.client.rpc.RPCManager#startQueue queuing} with RestDataSource, an HTTP request containing mixed {@link
     * com.smartgwt.client.data.DSRequest#getOperationType operationTypes} (such as a mixture of "add", "update" and "remove"
     * operations resulting from {@link com.smartgwt.client.widgets.grid.ListGrid#getAutoSaveEdits Grid Mass Editing}) can only
     * go to one URL, so you should not set distinct URLs for each <code>operationType</code>; doing so will break queuing of
     * mixed operationTypes: multiple requests will be sent to distinct URLs, and a warning logged.
     *
     * @param dataURL New dataURL value. Default value is null
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setDataURL(String dataURL)  throws IllegalStateException {
        setAttribute("dataURL", dataURL, false);
    }

    /**
     * Default URL to contact to fulfill all DSRequests.   RestDataSources also allow per-operationType dataURLs to be set via
     * <ul> <li>{@link com.smartgwt.client.data.RestDataSource#getFetchDataURL fetchDataURL}</li> <li>{@link
     * com.smartgwt.client.data.RestDataSource#getAddDataURL addDataURL}</li>  <li>{@link
     * com.smartgwt.client.data.RestDataSource#getUpdateDataURL updateDataURL}</li> <li>{@link
     * com.smartgwt.client.data.RestDataSource#getRemoveDataURL removeDataURL}</li> </ul> <b>NOTE:</b>: when using {@link
     * com.smartgwt.client.rpc.RPCManager#startQueue queuing} with RestDataSource, an HTTP request containing mixed {@link
     * com.smartgwt.client.data.DSRequest#getOperationType operationTypes} (such as a mixture of "add", "update" and "remove"
     * operations resulting from {@link com.smartgwt.client.widgets.grid.ListGrid#getAutoSaveEdits Grid Mass Editing}) can only
     * go to one URL, so you should not set distinct URLs for each <code>operationType</code>; doing so will break queuing of
     * mixed operationTypes: multiple requests will be sent to distinct URLs, and a warning logged.
     *
     * @return Current dataURL value. Default value is null
     */
    public String getDataURL()  {
        return getAttributeAsString("dataURL");
    }
    

    /**
     * If set, disables {@link com.smartgwt.client.rpc.RPCManager#startQueue request queuing} for this RestDataSource.
     *
     * @param disableQueuing New disableQueuing value. Default value is false
     */
    public void setDisableQueuing(Boolean disableQueuing) {
        setAttribute("disableQueuing", disableQueuing, true);
    }

    /**
     * If set, disables {@link com.smartgwt.client.rpc.RPCManager#startQueue request queuing} for this RestDataSource.
     *
     * @return Current disableQueuing value. Default value is false
     */
    public Boolean getDisableQueuing()  {
        Boolean result = getAttributeAsBoolean("disableQueuing");
        return result == null ? false : result;
    }
    

    /**
     * Custom {@link com.smartgwt.client.data.DataSource#getDataURL dataURL} for {@link com.smartgwt.client.data.DSRequest
     * DSRequests} with {@link com.smartgwt.client.data.DSRequest#getOperationType operationType} "fetch". <p> Use {@link
     * com.smartgwt.client.data.RestDataSource#getDataURL dataURL} to configure a single URL for all requests, which is
     * required to support {@link com.smartgwt.client.rpc.RPCManager#startQueue RPCManager.startQueue()}.
     *
     * @param fetchDataURL New fetchDataURL value. Default value is null
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setFetchDataURL(String fetchDataURL)  throws IllegalStateException {
        setAttribute("fetchDataURL", fetchDataURL, false);
    }

    /**
     * Custom {@link com.smartgwt.client.data.DataSource#getDataURL dataURL} for {@link com.smartgwt.client.data.DSRequest
     * DSRequests} with {@link com.smartgwt.client.data.DSRequest#getOperationType operationType} "fetch". <p> Use {@link
     * com.smartgwt.client.data.RestDataSource#getDataURL dataURL} to configure a single URL for all requests, which is
     * required to support {@link com.smartgwt.client.rpc.RPCManager#startQueue RPCManager.startQueue()}.
     *
     * @return Current fetchDataURL value. Default value is null
     */
    public String getFetchDataURL()  {
        return getAttributeAsString("fetchDataURL");
    }
    

    /**
     * Allows you to specify an arbitrary prefix string to apply to all json format responses  sent from the server to this
     * application.  The client will expect to find this prefix  on any JSON response received for this DataSource, and will
     * strip it off before evaluating the response text. <p> The default prefix is
     * "&lt;SCRIPT&gt;//'\"]]&gt;&gt;isc_JSONResponseStart&gt;&gt;". <p> The inclusion of such a prefix ensures your code is
     * not directly executable outside of  your application, as a preventative measure against  <a
     * href='http://www.google.com/search?q=javascript+hijacking'>javascript hijacking</a>. <p> You can switch off JSON
     * wrapping altogether by setting both this and {@link com.smartgwt.client.data.RestDataSource#getJsonSuffix jsonSuffix} to
     * empty strings.   <p> If you are using Smart GWT Server's RESTHandler servlet, see the server-side Javadocs for details
     * of how to change the way JSON wrapping works on the server side.
     *
     * @param jsonPrefix New jsonPrefix value. Default value is See below
     * @see com.smartgwt.client.data.RestDataSource#setJsonSuffix
     */
    public void setJsonPrefix(String jsonPrefix) {
        setAttribute("jsonPrefix", jsonPrefix, true);
    }

    /**
     * Allows you to specify an arbitrary prefix string to apply to all json format responses  sent from the server to this
     * application.  The client will expect to find this prefix  on any JSON response received for this DataSource, and will
     * strip it off before evaluating the response text. <p> The default prefix is
     * "&lt;SCRIPT&gt;//'\"]]&gt;&gt;isc_JSONResponseStart&gt;&gt;". <p> The inclusion of such a prefix ensures your code is
     * not directly executable outside of  your application, as a preventative measure against  <a
     * href='http://www.google.com/search?q=javascript+hijacking'>javascript hijacking</a>. <p> You can switch off JSON
     * wrapping altogether by setting both this and {@link com.smartgwt.client.data.RestDataSource#getJsonSuffix jsonSuffix} to
     * empty strings.   <p> If you are using Smart GWT Server's RESTHandler servlet, see the server-side Javadocs for details
     * of how to change the way JSON wrapping works on the server side.
     *
     * @return Current jsonPrefix value. Default value is See below
     * @see com.smartgwt.client.data.RestDataSource#getJsonSuffix
     */
    public String getJsonPrefix()  {
        return getAttributeAsString("jsonPrefix");
    }
    

    /**
     * <code>recordXPath</code> mapping to the data node of json returned by the server.
     *  Applies if this.dataFormat is set to <code>"json"</code><br>
     *  The default value will pick up data from a response structured as follows:<br>
     *  <pre>
     *  {response:
     *   {status:0,
     *    data:[
     *       {field1:"value", field2:"value"},
     *       {field1:"value", field2:"value"}
     *    ]
     *  }
     *  </pre>
     *
     * @param jsonRecordXPath New jsonRecordXPath value. Default value is "/response/data"
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setJsonRecordXPath(String jsonRecordXPath)  throws IllegalStateException {
        setAttribute("jsonRecordXPath", jsonRecordXPath, false);
    }

    /**
     * <code>recordXPath</code> mapping to the data node of json returned by the server.
     *  Applies if this.dataFormat is set to <code>"json"</code><br>
     *  The default value will pick up data from a response structured as follows:<br>
     *  <pre>
     *  {response:
     *   {status:0,
     *    data:[
     *       {field1:"value", field2:"value"},
     *       {field1:"value", field2:"value"}
     *    ]
     *  }
     *  </pre>
     *
     * @return Current jsonRecordXPath value. Default value is "/response/data"
     */
    public String getJsonRecordXPath()  {
        return getAttributeAsString("jsonRecordXPath");
    }
    

    /**
     * Allows you to specify an arbitrary suffix string to apply to all json format responses  sent from the server to this
     * application.  The client will expect to find this suffix  on any JSON response received for this DataSource, and will
     * strip it off before evaluating the response text. <p> The default suffix is "//isc_JSONResponseEnd".
     *
     * @param jsonSuffix New jsonSuffix value. Default value is See below
     * @see com.smartgwt.client.data.RestDataSource#setJsonPrefix
     */
    public void setJsonSuffix(String jsonSuffix) {
        setAttribute("jsonSuffix", jsonSuffix, true);
    }

    /**
     * Allows you to specify an arbitrary suffix string to apply to all json format responses  sent from the server to this
     * application.  The client will expect to find this suffix  on any JSON response received for this DataSource, and will
     * strip it off before evaluating the response text. <p> The default suffix is "//isc_JSONResponseEnd".
     *
     * @return Current jsonSuffix value. Default value is See below
     * @see com.smartgwt.client.data.RestDataSource#getJsonPrefix
     */
    public String getJsonSuffix()  {
        return getAttributeAsString("jsonSuffix");
    }
    

    /**
     * If {@link com.smartgwt.client.data.RestDataSource#getSendMetaData sendMetaData} is true, this attribute is used to
     * specify the prefix to apply to 'meta data' properties when assembling parameters to send to the  server.  Applies to
     * operations where OperationBinding.dataProtocol is set to  <code>"getParams"</code> or <code>"postParams"</code> only.
     *
     * @param metaDataPrefix New metaDataPrefix value. Default value is "_"
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setMetaDataPrefix(String metaDataPrefix)  throws IllegalStateException {
        setAttribute("metaDataPrefix", metaDataPrefix, false);
    }

    /**
     * If {@link com.smartgwt.client.data.RestDataSource#getSendMetaData sendMetaData} is true, this attribute is used to
     * specify the prefix to apply to 'meta data' properties when assembling parameters to send to the  server.  Applies to
     * operations where OperationBinding.dataProtocol is set to  <code>"getParams"</code> or <code>"postParams"</code> only.
     *
     * @return Current metaDataPrefix value. Default value is "_"
     */
    public String getMetaDataPrefix()  {
        return getAttributeAsString("metaDataPrefix");
    }
    

    /**
     * RestDataSource OperationBindings set to specify default dataProtocol per operationType.
     *  Default databindings are:
     *  <pre>
     *    operationBindings : [
     *      {operationType:"fetch", dataProtocol:"getParams"},
     *      {operationType:"add", dataProtocol:"postParams"},
     *      {operationType:"remove", dataProtocol:"postParams"},
     *      {operationType:"update", dataProtocol:"postParams"} 
     *    ],
     *  </pre>
     *  If you are integrating with a {@link com.smartgwt.client.data.RestDataSource REST} server that requires the more
     * obscure {@link com.smartgwt.client.rpc.RPCRequest#getHttpMethod RPCRequest.httpMethod}s of "PUT", "DELETE" or "HEAD",
     * you can specify these
     * httpMethod settings via {@link com.smartgwt.client.data.OperationBinding#getRequestProperties
     * OperationBinding.requestProperties}.  dataProtocol settings
     *  that mention "GET" or "POST" are compatible with these additional HTTP methods as well.
     *  Typical {@link com.smartgwt.client.data.DataSource#getOperationBindings operationBindings} for a REST server that uses
     *  "PUT" and "DELETE" are as follows:
     *  <pre>
     *    operationBindings:[
     *      {operationType:"fetch", dataProtocol:"getParams"},
     *      {operationType:"add", dataProtocol:"postParams"},
     *      {operationType:"remove", dataProtocol:"getParams", requestProperties:{httpMethod:"DELETE"}},
     *      {operationType:"update", dataProtocol:"postParams", requestProperties:{httpMethod:"PUT"}}
     *    ],
     *  </pre>
     *  <p>
     *  Note that dataProtocol:"postMessage" is always used when
     *  {@link com.smartgwt.client.rpc.RPCManager#startQueue queuing} is used to send multiple DSRequests to the server
     *  as a single HttpRequest.  See {@link com.smartgwt.client.data.RestDataSource} docs, "queuing support".  We also 
     *  recommend that you use the "postMessage" protocol whenever you are intending to use 
     *  AdvancedCriteria with RestDataSource - this is discussed in the section "Server inbound
     *  data format" in the {@link com.smartgwt.client.data.RestDataSource RestDataSource overview}.
     *  <p>
     *
     * @param operationBindings New operationBindings value. Default value is [...]
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setOperationBindings(OperationBinding... operationBindings)  throws IllegalStateException {
        setAttribute("operationBindings", operationBindings, false);
    }

    /**
     * RestDataSource OperationBindings set to specify default dataProtocol per operationType.
     *  Default databindings are:
     *  <pre>
     *    operationBindings : [
     *      {operationType:"fetch", dataProtocol:"getParams"},
     *      {operationType:"add", dataProtocol:"postParams"},
     *      {operationType:"remove", dataProtocol:"postParams"},
     *      {operationType:"update", dataProtocol:"postParams"} 
     *    ],
     *  </pre>
     *  If you are integrating with a {@link com.smartgwt.client.data.RestDataSource REST} server that requires the more
     * obscure {@link com.smartgwt.client.rpc.RPCRequest#getHttpMethod RPCRequest.httpMethod}s of "PUT", "DELETE" or "HEAD",
     * you can specify these
     * httpMethod settings via {@link com.smartgwt.client.data.OperationBinding#getRequestProperties
     * OperationBinding.requestProperties}.  dataProtocol settings
     *  that mention "GET" or "POST" are compatible with these additional HTTP methods as well.
     *  Typical {@link com.smartgwt.client.data.DataSource#getOperationBindings operationBindings} for a REST server that uses
     *  "PUT" and "DELETE" are as follows:
     *  <pre>
     *    operationBindings:[
     *      {operationType:"fetch", dataProtocol:"getParams"},
     *      {operationType:"add", dataProtocol:"postParams"},
     *      {operationType:"remove", dataProtocol:"getParams", requestProperties:{httpMethod:"DELETE"}},
     *      {operationType:"update", dataProtocol:"postParams", requestProperties:{httpMethod:"PUT"}}
     *    ],
     *  </pre>
     *  <p>
     *  Note that dataProtocol:"postMessage" is always used when
     *  {@link com.smartgwt.client.rpc.RPCManager#startQueue queuing} is used to send multiple DSRequests to the server
     *  as a single HttpRequest.  See {@link com.smartgwt.client.data.RestDataSource} docs, "queuing support".  We also 
     *  recommend that you use the "postMessage" protocol whenever you are intending to use 
     *  AdvancedCriteria with RestDataSource - this is discussed in the section "Server inbound
     *  data format" in the {@link com.smartgwt.client.data.RestDataSource RestDataSource overview}.
     *  <p>
     *
     * @return Current operationBindings value. Default value is [...]
     */
    public OperationBinding[] getOperationBindings()  {
        return com.smartgwt.client.util.ConvertTo.arrayOfOperationBinding(getAttributeAsJavaScriptObject("operationBindings"));
    }
    

    /**
     * When using dataFormat:"json" and dataProtocol:"postMessage" should we use the {@link
     * com.smartgwt.client.util.JSONEncoder#getPrettyPrint JSONEncoder.prettyPrint} feature to enable indented, highly readable
     * JSON messages. <P> True by default because the bandwidth involved is generally negligible and the benefits for
     * troubleshooting are key.
     *
     * @param prettyPrintJSON New prettyPrintJSON value. Default value is true
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setPrettyPrintJSON(Boolean prettyPrintJSON)  throws IllegalStateException {
        setAttribute("prettyPrintJSON", prettyPrintJSON, false);
    }

    /**
     * When using dataFormat:"json" and dataProtocol:"postMessage" should we use the {@link
     * com.smartgwt.client.util.JSONEncoder#getPrettyPrint JSONEncoder.prettyPrint} feature to enable indented, highly readable
     * JSON messages. <P> True by default because the bandwidth involved is generally negligible and the benefits for
     * troubleshooting are key.
     *
     * @return Current prettyPrintJSON value. Default value is true
     */
    public Boolean getPrettyPrintJSON()  {
        Boolean result = getAttributeAsBoolean("prettyPrintJSON");
        return result == null ? true : result;
    }
    

    /**
     * For RestDataSources, by default, either the {@link com.smartgwt.client.data.RestDataSource#getXmlRecordXPath
     * xmlRecordXPath} or  {@link com.smartgwt.client.data.RestDataSource#getJsonRecordXPath jsonRecordXPath} is used based on
     * the {@link com.smartgwt.client.data.RestDataSource#getDataFormat dataFormat} setting. <P> Note that you can also apply
     * record xpath binding via {@link com.smartgwt.client.data.OperationBinding#getRecordXPath OperationBinding.recordXPath}.
     *
     * @param recordXPath New recordXPath value. Default value is null
     */
    public void setRecordXPath(String recordXPath) {
        setAttribute("recordXPath", recordXPath, true);
    }

    /**
     * For RestDataSources, by default, either the {@link com.smartgwt.client.data.RestDataSource#getXmlRecordXPath
     * xmlRecordXPath} or  {@link com.smartgwt.client.data.RestDataSource#getJsonRecordXPath jsonRecordXPath} is used based on
     * the {@link com.smartgwt.client.data.RestDataSource#getDataFormat dataFormat} setting. <P> Note that you can also apply
     * record xpath binding via {@link com.smartgwt.client.data.OperationBinding#getRecordXPath OperationBinding.recordXPath}.
     *
     * @return Current recordXPath value. Default value is null
     */
    public String getRecordXPath()  {
        return getAttributeAsString("recordXPath");
    }
    

    /**
     * Custom {@link com.smartgwt.client.data.DataSource#getDataURL dataURL} for {@link com.smartgwt.client.data.DSRequest
     * DSRequests} with {@link com.smartgwt.client.data.DSRequest#getOperationType operationType} "remove". <p> See {@link
     * com.smartgwt.client.data.RestDataSource#getDataURL dataURL} to configure a single URL for all requests, which is
     * required to support {@link com.smartgwt.client.rpc.RPCManager#startQueue RPCManager.startQueue()}.
     *
     * @param removeDataURL New removeDataURL value. Default value is null
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setRemoveDataURL(String removeDataURL)  throws IllegalStateException {
        setAttribute("removeDataURL", removeDataURL, false);
    }

    /**
     * Custom {@link com.smartgwt.client.data.DataSource#getDataURL dataURL} for {@link com.smartgwt.client.data.DSRequest
     * DSRequests} with {@link com.smartgwt.client.data.DSRequest#getOperationType operationType} "remove". <p> See {@link
     * com.smartgwt.client.data.RestDataSource#getDataURL dataURL} to configure a single URL for all requests, which is
     * required to support {@link com.smartgwt.client.rpc.RPCManager#startQueue RPCManager.startQueue()}.
     *
     * @return Current removeDataURL value. Default value is null
     */
    public String getRemoveDataURL()  {
        return getAttributeAsString("removeDataURL");
    }
    

    /**
     * Should operation meta data be included when assembling parameters to send  to the server? If true, meta data parameters
     * will be prefixed with the  {@link com.smartgwt.client.data.RestDataSource#getMetaDataPrefix metaDataPrefix}.<br> Applies
     * to operations where OperationBinding.dataProtocol is set to  <code>"getParams"</code> or <code>"postParams"</code> only.
     *
     * @param sendMetaData New sendMetaData value. Default value is true
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setSendMetaData(Boolean sendMetaData)  throws IllegalStateException {
        setAttribute("sendMetaData", sendMetaData, false);
    }

    /**
     * Should operation meta data be included when assembling parameters to send  to the server? If true, meta data parameters
     * will be prefixed with the  {@link com.smartgwt.client.data.RestDataSource#getMetaDataPrefix metaDataPrefix}.<br> Applies
     * to operations where OperationBinding.dataProtocol is set to  <code>"getParams"</code> or <code>"postParams"</code> only.
     *
     * @return Current sendMetaData value. Default value is true
     */
    public Boolean getSendMetaData()  {
        Boolean result = getAttributeAsBoolean("sendMetaData");
        return result == null ? true : result;
    }
    

    /**
     * Custom {@link com.smartgwt.client.data.DataSource#getDataURL dataURL} for {@link com.smartgwt.client.data.DSRequest
     * DSRequests} with {@link com.smartgwt.client.data.DSRequest#getOperationType operationType} "update". <p> See {@link
     * com.smartgwt.client.data.RestDataSource#getDataURL dataURL} to configure a single URL for all requests, which is
     * required to support {@link com.smartgwt.client.rpc.RPCManager#startQueue RPCManager.startQueue()}.
     *
     * @param updateDataURL New updateDataURL value. Default value is null
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setUpdateDataURL(String updateDataURL)  throws IllegalStateException {
        setAttribute("updateDataURL", updateDataURL, false);
    }

    /**
     * Custom {@link com.smartgwt.client.data.DataSource#getDataURL dataURL} for {@link com.smartgwt.client.data.DSRequest
     * DSRequests} with {@link com.smartgwt.client.data.DSRequest#getOperationType operationType} "update". <p> See {@link
     * com.smartgwt.client.data.RestDataSource#getDataURL dataURL} to configure a single URL for all requests, which is
     * required to support {@link com.smartgwt.client.rpc.RPCManager#startQueue RPCManager.startQueue()}.
     *
     * @return Current updateDataURL value. Default value is null
     */
    public String getUpdateDataURL()  {
        return getAttributeAsString("updateDataURL");
    }
    

    /**
     * When {@link com.smartgwt.client.data.RestDataSource#getDataFormat dataFormat} is "xml", <code>xmlNamespaces</code>
     * configures the set of namespace prefixes that are added to the document element of the XML message sent to the server. 
     * Format is the same as {@link com.smartgwt.client.data.DataSource#getXmlNamespaces DataSource.xmlNamespaces}. <P> By
     * default, the "xsi" prefix is bound to "http://www.w3.org/2001/XMLSchema-instance" in order to allow explicit null values
     * in Records to be sent for {@link com.smartgwt.client.data.DataSourceField#getNillable fields declared nillable}.  Set to
     * null to avoid any prefixes being added.
     *
     * @param xmlNamespaces New xmlNamespaces value. Default value is See below
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     * @see com.smartgwt.client.data.DataSourceField#setNillable
     */
    public void setXmlNamespaces(XmlNamespaces xmlNamespaces)  throws IllegalStateException {
        setAttribute("xmlNamespaces", xmlNamespaces == null ? null : xmlNamespaces.getJsObj(), false);
    }

    /**
     * When {@link com.smartgwt.client.data.RestDataSource#getDataFormat dataFormat} is "xml", <code>xmlNamespaces</code>
     * configures the set of namespace prefixes that are added to the document element of the XML message sent to the server. 
     * Format is the same as {@link com.smartgwt.client.data.DataSource#getXmlNamespaces DataSource.xmlNamespaces}. <P> By
     * default, the "xsi" prefix is bound to "http://www.w3.org/2001/XMLSchema-instance" in order to allow explicit null values
     * in Records to be sent for {@link com.smartgwt.client.data.DataSourceField#getNillable fields declared nillable}.  Set to
     * null to avoid any prefixes being added.
     *
     * @return Current xmlNamespaces value. Default value is See below
     * @see com.smartgwt.client.data.DataSourceField#getNillable
     */
    public XmlNamespaces getXmlNamespaces()  {
        return new XmlNamespaces(getAttributeAsJavaScriptObject("xmlNamespaces"));
    }
    

    /**
     * <code>recordXPath</code> mapping to the data node of XML returned by the server.
     *  Applies if this.dataFormat is set to <code>"xml"</code>.<br>
     *  The default value will pick up data from a response structured as follows:<br>
     *  <pre>
     *  &lt;response&gt;
     *     &lt;status&gt;0&lt;/status&gt;
     *     &lt;data&gt;
     *       &lt;record&gt;
     *           &lt;field1&gt;value&lt;/field1&gt;
     *           &lt;field2&gt;value&lt;/field2&gt;
     *       &lt;/record&gt;
     *       &lt;record&gt;
     *           &lt;field1&gt;value&lt;/field1&gt;
     *           &lt;field2&gt;value&lt;/field2&gt;
     *       &lt;/record&gt;
     *     &lt;/data&gt;
     *  &lt;/response&gt;
     *  </pre>
     *
     * @param xmlRecordXPath New xmlRecordXPath value. Default value is "/response/data/*"
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setXmlRecordXPath(String xmlRecordXPath)  throws IllegalStateException {
        setAttribute("xmlRecordXPath", xmlRecordXPath, false);
    }

    /**
     * <code>recordXPath</code> mapping to the data node of XML returned by the server.
     *  Applies if this.dataFormat is set to <code>"xml"</code>.<br>
     *  The default value will pick up data from a response structured as follows:<br>
     *  <pre>
     *  &lt;response&gt;
     *     &lt;status&gt;0&lt;/status&gt;
     *     &lt;data&gt;
     *       &lt;record&gt;
     *           &lt;field1&gt;value&lt;/field1&gt;
     *           &lt;field2&gt;value&lt;/field2&gt;
     *       &lt;/record&gt;
     *       &lt;record&gt;
     *           &lt;field1&gt;value&lt;/field1&gt;
     *           &lt;field2&gt;value&lt;/field2&gt;
     *       &lt;/record&gt;
     *     &lt;/data&gt;
     *  &lt;/response&gt;
     *  </pre>
     *
     * @return Current xmlRecordXPath value. Default value is "/response/data/*"
     */
    public String getXmlRecordXPath()  {
        return getAttributeAsString("xmlRecordXPath");
    }
    

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************

    /** 
     * Class level method to set the default properties of this class.  If set, then all
     * existing and subsequently created instances of this class will automatically have
     * default properties corresponding to
     * the properties set on the SmartGWT class instance passed to this function before its
     * underlying SmartClient JS object was created.
     * This is a powerful feature that eliminates the need for users to create a separate
     * hierarchy of subclasses that only alter the default properties of this class. Can also
     * be used for skinning / styling purposes.  <P> <b>Note:</b> This method is intended for
     * setting default attributes only and will affect all instances of the underlying class
     * (including those automatically generated in JavaScript).  This method should not be used
     * to apply standard EventHandlers or override methods for a class - use a custom subclass
     * instead.  Calling this method after instances have been created can result in undefined
     * behavior, since it bypasses any setters and a class instance may have already examined 
     * a particular property and not be expecting any changes through this route.
     *
     * @param restDataSourceProperties properties that should be used as new defaults when instances of this class are created
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public static native void setDefaultProperties(RestDataSource restDataSourceProperties) /*-{
        if (restDataSourceProperties.@com.smartgwt.client.core.BaseClass::isCreated()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Class;)(RestDataSource.@java.lang.Object::getClass()(), "setDefaultProperties", restDataSourceProperties.@java.lang.Object::getClass()());
        }
        restDataSourceProperties.@com.smartgwt.client.core.BaseClass::setConfigOnly(Z)(true);
    	var properties = restDataSourceProperties.@com.smartgwt.client.core.BaseClass::getConfig()();
        properties = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(properties,true);
        $wnd.isc.RestDataSource.addProperties(properties);
    }-*/;

    // ***********************************************************

}
