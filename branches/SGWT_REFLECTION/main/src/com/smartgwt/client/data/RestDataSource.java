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
 
package com.smartgwt.client.data;



import com.smartgwt.client.event.*;
import com.smartgwt.client.core.*;
import com.smartgwt.client.types.*;
import com.smartgwt.client.data.*;
import com.smartgwt.client.data.events.*;
import com.smartgwt.client.rpc.*;
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
import com.smartgwt.client.widgets.tab.*;
import com.smartgwt.client.widgets.toolbar.*;
import com.smartgwt.client.widgets.tree.*;
import com.smartgwt.client.widgets.tree.events.*;
import com.smartgwt.client.widgets.viewer.*;
import com.smartgwt.client.widgets.calendar.*;
import com.smartgwt.client.widgets.calendar.events.*;
import com.smartgwt.client.widgets.cube.*;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;
import com.smartgwt.client.util.*;
import com.google.gwt.event.shared.*;
import com.google.gwt.event.shared.HasHandlers;

/**
 * The RestDataSource implements the 4 core DataSource operations using a simple protocol of
 *  XML or JSON requests and responses sent over HTTP, which can be easily fulfilled by any HTTP
 *  server technology.
 *  <P>
 *  RestDataSource is named for the
 * <a href='http://www.google.com/search?hl=en&q=REST+HTTP'
 * onclick="window.open('http://www.google.com/search?hl=en&q=REST+HTTP');return false;">REST</a> (REpresentational State
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
 *  formats of your existing services.
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
 *  {@link com.smartgwt.client.data.DataSource#getPreventHTTPCaching preventHTTPCaching}.
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
 * error causes all response processing to be skipped and {@link com.smartgwt.client.rpc.RPCManager#handleError
 * RPCManager.handleError} to be
 *  invoked, which by default will show the provided error message as an alert using
 *  {@link com.smartgwt.client.util.isc#warn isc.warn}.
 *  <p>
 *  <b>JSON formatted responses:</b>
 *  <P>
 *  JSON format responses are expected to contain the same data / meta-data as XMLresponses,
 *  encapsulated a simple object with a <code>"response"</code> attribute.<br>
 *  The response to a "fetch" request would therefore have this format:<br>
 *  <pre>
 *  {    
 *     response:{
 *        status:0,
 *        startRow:0,
 *        endRow:76,
 *        totalRows:546,
 *        data:[
 *            {field1:"value", field2:"value"},
 *            {field1:"value", field2:"value"},
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
 *  {    response:
 *       {   status:-4,
 *           errors: 
 *               {   field1:{errorMessage:"A validation error on field1"},
 *                   field2:{errorMessage:"A validation error on field2"}
 *               }
 *       }
 *  }
 *  </pre>
 *  An array of errors may also be returned for a single field, like this:
 *  <pre>
 *  {    response:
 *       {   status:-4,
 *           errors: 
 *               {   field1:[
 *                       {errorMessage:"First error on field1"},
 *                       {errorMessage:"Second error on field1"}
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
 * com.smartgwt.client.data.OperationBinding#getDataProtocol dataProtocol}
 *  specified for the operation. Request data is sent as parameters if the format is 
 *  specified as <code>"getParams"</code> or <code>"postParams"</code>.
 *  <P>
 *  In this case, the parameters sent to the server will consist of the DSRequest's data, and any
 * parameters explicitly specified on the DSRequest object (as {@link com.smartgwt.client.rpc.RPCRequest#getParams
 * params}.<br> 
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
 * server had been passed to {@link com.smartgwt.client.data.DataSource#xmlSerialize DataSource.xmlSerialize} or {@link
 * com.smartgwt.client.util.JSON#encode JSON.encode}
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
 *                     &lt;operator&gt;equals&lt;/continent&gt;
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
 *  JSON messages are just the plain JSON form of the structures shown in the above XML 
 *  examples.  To show the last of the three XML examples in JSON form:
 *  <pre>
 *  {
 *      data: {
 *          _constructor: "AdvancedCriteria",
 *          operator: "or",
 *          criteria: [
 *              { fieldName: "continent", operator: "equals", value: "North America },
 *              { operator: "and", criteria: [
 *                  { fieldName: "continent", operator: "equals", value: "Europe" },
 *                  { fieldName: "population", operator: "greaterThan", value: 50000000 }
 *              ] }
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
 *  add and remove operations.
 *  <P>
 *  <b>Date, time and datetime values</b>
 *  <P>
 *  Date, time and datetime values must be communicated using XML Schema format, as in the 
 *  following examples:<br>
 *  <code>&nbsp;&nbsp;&lt;dateField&gt;2007-04-22&lt;/dateField&gt;</code><br>
 *  <code>&nbsp;&nbsp;&lt;timeField&gt;11:07:13&lt;/timeField&gt;</code><br>
 *  <code>&nbsp;&nbsp;&lt;dateTimeField&gt;2007-04-22T11:07:13&lt;/dateTimeField&gt;</code>
 *  <P>
 *  And the equivalent in JSON:<br>
 *  <code>&nbsp;&nbsp;dateField: "2007-04-22"<br>
 *  <code>&nbsp;&nbsp;timeField: "11:07:13"<br>
 *  <code>&nbsp;&nbsp;dateTimeField: "2007-04-22T11:07:13"</code>
 *  <P>
 *  Both RestDataSource on the client-side and the RESTHandler servlet on the server side 
 *  automatically handle encoding and decoding temporal values using these formats.
 *  <P>
 *  Fields of type "date" and "time" are considered to hold logical date and time values, as 
 *  discussed in the {@link com.smartgwt.client.docs.DateFormatAndStorage date and time handling article}, and are 
 *  not affected by timezones.  Fields of type "datetime" will be converted to UTC on the 
 *  client side by RestDataSource, and will be sent back down to the client as UTC by the 
 *  server-side RESTHandler.  We recommend that your own REST client and/or server code do the
 *  same thing (ie, transmit all datetime values in both directions as UTC).
 *  <P>
 *  <b>RestDataSource queuing support</b>
 *  <P>
 *  RestDataSource supports {@link com.smartgwt.client.rpc.RPCManager#startQueue queuing} of DSRequests.  This allows 
 *  you to send multiple requests to the server in a single HTTP turnaround, thus minimizing 
 *  network traffic and allowing the server to treat multiple requests as a single transaction,
 *  if the server is able to do so (in Power Edition and above, the Smart GWT Server
 *  transparently supports grouping multiple REST requests in a queue into a single database
 *  transaction when using one of the built-in DataSource types).
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
 *  <code>queueStatus</code>.  This allows each individual response to determine whether the 
 *  queue as a whole succeeded.  For example, if the first update succeeded but the second 
 *  failed validation, the first response would have a <code>status</code> of 0, but a 
 *  <code>queueStatus</code> of -1, while the second response would have both properties set
 *  to -1.
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
 *      response: {
 *          queueStatus: 0,
 *          status: 0, 
 *          data: [{
 *              countryName: "Edited Value",
 *              gdp: 1700.0,
 *              continent":"Edited Value",
 *              capital: "Edited Value",
 *              pk: 1
 *          }]
 *      }
 *  },
 *  {
 *      response: {
 *          queueStatus: 0,
 *          status: 0,
 *          data: [{
 *              countryName:"United States",
 *              gdp: 7247700.0,
 *              continent":"North America,
 *              independence: Date.parseServerDate(1776,6,4),
 *              capital: "Washington DC",
 *              pk: 2,
 *              population: 123456
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
 *  This can be achieved by setting the {@link com.smartgwt.client.data.DataSourceField#getForeignKey foreignKey} and the 
 * {@link com.smartgwt.client.data.DataSourceField#getRootValue rootValue} attributes on the field definition. For example:
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
 *  automatically create a ResultTree data object, which requests data directly
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
        super(jsObj);
    }

    public native JavaScriptObject create()/*-{
        var config = this.@com.smartgwt.client.core.BaseClass::getConfig()();
        var scClassName = this.@com.smartgwt.client.core.BaseClass::scClassName;
        return $wnd.isc[scClassName].create(config);
    }-*/;
    // ********************* Properties / Attributes ***********************

    /**
     * Custom dataURL for add type operations
     *
     * @param addDataURL addDataURL Default value is null
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setAddDataURL(String addDataURL)  throws IllegalStateException {
        setAttribute("addDataURL", addDataURL, false);
    }

    /**
     * Custom dataURL for add type operations
     *
     *
     * @return String
     */
    public String getAddDataURL()  {
        return getAttributeAsString("addDataURL");
    }

    /**
     * Default URL to contact to fulfill all DSRequests.   RestDataSources also allow per-operationType dataURLs to be set via
     * <ul> <li>{@link com.smartgwt.client.data.RestDataSource#getFetchDataURL fetchDataURL}</li> <li>{@link
     * com.smartgwt.client.data.RestDataSource#getAddDataURL addDataURL}</li>  <li>{@link
     * com.smartgwt.client.data.RestDataSource#getUpdateDataURL updateDataURL}</li> <li>{@link
     * com.smartgwt.client.data.RestDataSource#getRemoveDataURL removeDataURL}</li> </ul>
     *
     * @param dataURL dataURL Default value is null
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
     * com.smartgwt.client.data.RestDataSource#getRemoveDataURL removeDataURL}</li> </ul>
     *
     *
     * @return String
     */
    public String getDataURL()  {
        return getAttributeAsString("dataURL");
    }

    /**
     * Custom dataURL for fetch type operations
     *
     * @param fetchDataURL fetchDataURL Default value is null
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setFetchDataURL(String fetchDataURL)  throws IllegalStateException {
        setAttribute("fetchDataURL", fetchDataURL, false);
    }

    /**
     * Custom dataURL for fetch type operations
     *
     *
     * @return String
     */
    public String getFetchDataURL()  {
        return getAttributeAsString("fetchDataURL");
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
     * @param jsonRecordXPath jsonRecordXPath Default value is "/response/data"
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
     *
     * @return String
     */
    public String getJsonRecordXPath()  {
        return getAttributeAsString("jsonRecordXPath");
    }

    /**
     * If {@link com.smartgwt.client.data.RestDataSource#getSendMetaData sendMetaData} is true, this attribute is used to
     * specify the prefix to apply to 'meta data' properties when assembling parameters to send to the  server.  Applies to
     * operations where OperationBinding.dataProtocol is set to  <code>"getParams"</code> or <code>"postParams"</code> only.
     *
     * @param metaDataPrefix metaDataPrefix Default value is "_"
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
     *
     * @return String
     */
    public String getMetaDataPrefix()  {
        return getAttributeAsString("metaDataPrefix");
    }

    /**
     * When using dataFormat:"json" and dataProtocol:"postMessage" should we use the {@link
     * com.smartgwt.client.util.JSONEncoder#getPrettyPrint prettyPrint} feature to enable indented, highly readable JSON
     * messages. <P> True by default because the bandwidth involved is generally negligible and the benefits for
     * troubleshooting are key.
     *
     * @param prettyPrintJSON prettyPrintJSON Default value is true
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setPrettyPrintJSON(Boolean prettyPrintJSON)  throws IllegalStateException {
        setAttribute("prettyPrintJSON", prettyPrintJSON, false);
    }

    /**
     * When using dataFormat:"json" and dataProtocol:"postMessage" should we use the {@link
     * com.smartgwt.client.util.JSONEncoder#getPrettyPrint prettyPrint} feature to enable indented, highly readable JSON
     * messages. <P> True by default because the bandwidth involved is generally negligible and the benefits for
     * troubleshooting are key.
     *
     *
     * @return Boolean
     */
    public Boolean getPrettyPrintJSON()  {
        return getAttributeAsBoolean("prettyPrintJSON");
    }

    /**
     * For RestDataSources, by default, either the {@link com.smartgwt.client.data.RestDataSource#getXmlRecordXPath
     * xmlRecordXPath} or  {@link com.smartgwt.client.data.RestDataSource#getJsonRecordXPath jsonRecordXPath} is used based on
     * the {@link com.smartgwt.client.data.RestDataSource#getDataFormat dataFormat} setting. <P> Note that you can also apply
     * record xpath binding via {@link com.smartgwt.client.data.OperationBinding#getRecordXPath recordXPath}.
     *
     * @param recordXPath recordXPath Default value is null
     */
    public void setRecordXPath(String recordXPath) {
        setAttribute("recordXPath", recordXPath, true);
    }

    /**
     * For RestDataSources, by default, either the {@link com.smartgwt.client.data.RestDataSource#getXmlRecordXPath
     * xmlRecordXPath} or  {@link com.smartgwt.client.data.RestDataSource#getJsonRecordXPath jsonRecordXPath} is used based on
     * the {@link com.smartgwt.client.data.RestDataSource#getDataFormat dataFormat} setting. <P> Note that you can also apply
     * record xpath binding via {@link com.smartgwt.client.data.OperationBinding#getRecordXPath recordXPath}.
     *
     *
     * @return String
     */
    public String getRecordXPath()  {
        return getAttributeAsString("recordXPath");
    }

    /**
     * Custom dataURL for remove type operations
     *
     * @param removeDataURL removeDataURL Default value is null
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setRemoveDataURL(String removeDataURL)  throws IllegalStateException {
        setAttribute("removeDataURL", removeDataURL, false);
    }

    /**
     * Custom dataURL for remove type operations
     *
     *
     * @return String
     */
    public String getRemoveDataURL()  {
        return getAttributeAsString("removeDataURL");
    }

    /**
     * Should operation meta data be included when assembling parameters to send  to the server? If true, meta data parameters
     * will be prefixed with the  {@link com.smartgwt.client.data.RestDataSource#getMetaDataPrefix metaDataPrefix}.<br> Applies
     * to operations where OperationBinding.dataProtocol is set to  <code>"getParams"</code> or <code>"postParams"</code> only.
     *
     * @param sendMetaData sendMetaData Default value is true
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
     *
     * @return Boolean
     */
    public Boolean getSendMetaData()  {
        return getAttributeAsBoolean("sendMetaData");
    }

    /**
     * Custom dataURL for update type operations
     *
     * @param updateDataURL updateDataURL Default value is null
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setUpdateDataURL(String updateDataURL)  throws IllegalStateException {
        setAttribute("updateDataURL", updateDataURL, false);
    }

    /**
     * Custom dataURL for update type operations
     *
     *
     * @return String
     */
    public String getUpdateDataURL()  {
        return getAttributeAsString("updateDataURL");
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
     * @param xmlRecordXPath xmlRecordXPath Default value is "/response/data/*"
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
     *
     * @return String
     */
    public String getXmlRecordXPath()  {
        return getAttributeAsString("xmlRecordXPath");
    }

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************
        
    // ***********************************************************        

}



