/*
 * Isomorphic SmartClient
 * Version 7.0beta3 (2008-12-31)
 * Copyright(c) 1998-2007 Isomorphic Software, Inc. All rights reserved.
 * "SmartClient" is a trademark of Isomorphic Software, Inc.
 *
 * licensing@smartclient.com
 *
 * http://smartclient.com/license
 */

 
// Visit http://www.smartclient.com for more information on Isomorphic SmartClient 

//> @class RestDataSource
// The RestDataSource implements the 4 core DataSource operations using a simple protocol of
// XML or JSON requests and responses sent over HTTP, which can be easily fulfilled by any HTTP
// server technology.
// <P>
// RestDataSource is named for the
// +externalLink{http://www.google.com/search?hl=en&q=REST+HTTP,REST} (REpresentational State
// Transfer) pattern, which in brief says that simple messages passed over HTTP is a sufficient
// protocol for many web applications, without the need for further protocols such as WSDL or
// SOAP.
// <P>
// A RestDataSource is used just like a normal DataSource.  RestDataSources are configured,
// using the general-purpose databinding facilities of DataSources, to expect a particular
// format for responses and to send requests in a specific format.   These request and
// response formats represent Isomorphic's recommended best practices for binding SmartClient
// to backends which do not already support a similar, pre-existing request and response
// format.
// <P>
// Full source code to the RestDataSource is provided (see 
// /examples/databinding/RestDataSource.js), intended for possible further modification and an
// extended example of how to use SmartClient's general databinding engine.
// <P>
// RestDataSource is typically used with PHP, Ruby, Python, Perl or custom server technologies,
// and represents an alternative to installing the SmartClient Server in a Java technology
// stack, or using +link{group:wsdlBinding,WSDL-based binding} with .NET or other WSDL-capable
// technologies.
// <P>
// <span style="font-weight:bold;font-size:16px;">Examples</span>
// <p>
// <b>XML formatted responses:</b>
// <P>
// RestDataSource expects a response to like the following in response to a "fetch" request:
// <pre>
// &lt;response&gt;
//    &lt;status&gt;0&lt;/status&gt;
//    &lt;data&gt;
//      &lt;record&gt;
//          &lt;field1&gt;value&lt;/field1&gt;
//          &lt;field2&gt;value&lt;/field2&gt;
//      &lt;/record&gt;
//      &lt;record&gt;
//          &lt;field1&gt;value&lt;/field1&gt;
//          &lt;field2&gt;value&lt;/field2&gt;
//      &lt;/record&gt;
//    &lt;/data&gt;
// &lt;/response&gt;
// </pre>
// The status element indicates whether the fetch operation was successful 
// (see +link{group:statusCodes}).
// <P>
// The data element contains a list of record nodes, each of which represents a record returned
// by the server.  Additional elements for totalRows returned, startRow and endRow may
// also be included.
// <P>
// Note: for a more compact format, simple field values may be specified on record 
// nodes directly as attributes - in this case a record element might be structured like this:
// <pre>
//     &lt;record field1="value" field2="value" /&gt;
// </pre>
// <p>
// Successful "add" or "update" request responses are similar in format - in this case the data
// element would be expected to contain a single record object containing the details of the
// record, as saved on the server.
// <P>
// The response from a "remove" operation would again include status and data elements, but in
// this case, only the primary key field value(s) of the removed record would be expected to be 
// present under the data element.
// <p>
// If a validation failure occurred on the server, the response would
// have status set to +link{RPCResponse.STATUS_VALIDATION_ERROR} [<code>-4</code> by default],
// and any validation errors could be included as per-field sub-elements of an "errors"
// element.
// <P>
// Note that in this case the response would not be expected to contain any data element.  
// A response showing a validation error might look like this:
// <pre>
// &lt;response&gt;
//    &lt;status&gt;-4&lt;/status&gt;
//    &lt;errors&gt;
//      &lt;field1&gt;
//          &lt;errorMessage&gt;A validation error occurred for this field&lt;/errorMessage&gt;
//      &lt;/field1&gt;
//    &lt;/errors&gt;
// &lt;/response&gt;
// </pre>
// <p>
// <b>JSON formatted responses:</b>
// <P>
// JSON format responses are expected to contain the same data / meta-data as XMLresponses,
// encapsulated a simple object with a <code>"response"</code> attribute.<br>
// The response to a "fetch" request would therefore have this format:<br>
// <pre>
// {    response:
//      {   status:0,
//          data:[
//              {field1:"value", field2:"value"},
//              {field1:"value", field2:"value"}
//          ]
//      }
// }
// </pre>
// The structure successful for "add", "update" and "remove" responses would be similar, though
// the data array would be expected to contain the single edited record only.<br>
// For a remove, only the value for the primaryKey field[s] would be required.
// <p>
// If an error occurred on the server, this would be indicated in the <code>status</code> 
// attribute.  For a validation error, the status would be set to 
// +link{RPCResponse.STATUS_VALIDATION_ERROR} [<code>-4</code> by default], and errors would
// be specified in the <code>errors</code> attribute of the response. For example:
// <pre>
// {    response:
//      {   status:-4,
//          errors: 
//              {   field1:{errorMessage:"A validation error on field1"},
//                  field2:{errorMessage:"A validation error on field2"}
//              }
//      }
// }
// </pre>
// An array of errors may also be returned for a single field, like this:
// <pre>
// {    response:
//      {   status:-4,
//          errors: 
//              {   field1:[
//                      {errorMessage:"First error on field1"},
//                      {errorMessage:"Second error on field1"}
//                  ]
//              }
//      }
// }
// </pre>
// <b>Server inbound data formats</b>
// <P>
// The format of data sent to the server is determined by the +link{OperationBinding.dataProtocol}
// specified for the operation. Request data is sent as parameters if the format is 
// specified as <code>"getParams"</code> or <code>"postParams"</code>.
// <P>
// In this case, the parameters sent to the server will consist of the DSRequest's data, and any
// parameters explicitly specified on the DSRequest object (as +link{RPCRequest.params}.<br> 
// If +link{RestDataSource.sendMetaData} is true, the DSRequest meta 
// data properties will also be present as parameters, prefixed with 
// +link{RestDataSource.metaDataPrefix}.
// <P>
// Example URL constructed with the metaDataPrefix set to <code>"_"</code> (the default):
// <p>
// <code>
// &nbsp;&nbsp;&nbsp;<i>[dataURL]</i>?field1=value1&_operationType=fetch&_startRow=0&_endRow=50&_sortBy=-field2&_dataSource=dsName
// </code>
// <p>
// In this case the server would be able to separate the request's data from the meta data 
// via the <code>"_"</code> prefix.
// <P>
// If data is sent to the server via the <code>"postMessage"</code> dataProtocol, the data will
// be sent as a serialized XML message.  In this case the created XML document will contain 
// nodes for each relevant property of the request (including a <code>"data"</code> node 
// containing the request's data).
// <P>
// An example of an XML message might look like this:
// <pre>
//    &lt;data&gt;
//        &lt;countryDS&gt;
//            &lt;countryCode&gt;US&lt;/countryCode&gt;
//            &lt;countryName&gt;Edited Value&lt;/countryName&gt;
//            &lt;capital&gt;Edited Value&lt;/capital&gt;
//            &lt;continent&gt;Edited Value&lt;/continent&gt;
//        &lt;/countryDS&gt;
//    &lt;/data&gt;
//    &lt;dataSource&gt;countryDS&lt;/dataSource&gt;
//    &lt;operationType&gt;update&lt;/operationType&gt;
// </pre>
// The +link{restDataSource.operationBindings,default OperationBindings} for a RestDataSource
// specify dataProtocol as "getParams" for the fetch operation, and "postParams" for update,
// add and remove operations.
// <P>
// <b>Hierachical (Tree) data:</b>
// <P>
// To create a hierachical DataSource, in the DataSource's <code>fields</code> array, a field 
// must be specified as the parent id field - the field which will contain a pointer to the
// id of each node's parent. 
// This can be achieved by setting the +link{DataSourceField.foreignKey} and the 
// +link{DataSourceField.rootValue} attributes on the field definition. For example:
// <pre>
// RestDataSource.create({
//    ID:"supplyItem",
//    fields : [
//        {name:"itemId", type:"sequence", primaryKey:true},
//        {name:"parentId", type:"integer", foreignKey:"supplyItem.itemId", rootValue:0},
//        ...
//    ]
// });
// </pre>
// Tree Data is then treated on the server as a flat list of records linked by parent id.<br>
// Tree data is typically displayed using a dataBound +link{class:TreeGrid} component. TreeGrids
// automatically create a +link{class:ResultTree} data object, which requests data directly
// from the DataSource.  ResultTrees load data on demand, only requesting currently visible 
// (open) nodes from the server. This is handled by including a specified value for the parent 
// id field in the request criteria.<br>
// To implement a standard load-on-demand tree RestDataSource back end, you should therefore 
// simply return the set of nodes that match the criteria passed in. 
// For example, if your DataSource was defined as the "supplyItem" code snippet above, 
// a fetch request for all children of a node with <code>itemId</code> set to <code>12</code> 
// would have <code>"parentId"</code> set to <code>12</code> in the request criteria.
// A valid response would then contain all the records that matched this criteria. For example:
// <pre>
// &lt;response&gt;
//    &lt;status&gt;0&lt;/status&gt;
//    &lt;data&gt;
//      &lt;record&gt;
//          &lt;itemId&gt;15&lt;/itemId&gt;
//          &lt;parentId&gt;12&lt;/parentId&gt;
//      &lt;/record&gt;
//      &lt;record&gt;
//          &lt;itemId&gt;16&lt;/itemId&gt;
//          &lt;parentId&gt;12&lt;/parentId&gt;
//      &lt;/record&gt;
//    &lt;/data&gt;
// &lt;/response&gt;
// </pre>
// The structure of responses for Add, Update and Delete type requests will be the 
// same regardless of whether the data is hierachical. However you should be aware that 
// the underlying data storage may need to be managed slightly differently in some cases.<br>
// Specifically, Add and Update operations may change the structure of the tree by returning a 
// new parent id field value for the modified node. Depending on how your data is stored you 
// may need to include special back-end logic to handle this.<br>
// Also, if a user deletes a folder within a databound tree, any children of that folder will 
// also be dropped from the tree, and can be removed from the back-end data storage.<br>
// Note: For a general overview of binding components to Tree structured data, see 
// +link{group:treeDataBinding, Tree Databinding}.
// 
// @treeLocation Client Reference/Data Binding
// @visibility external
// @example restEditSave
//<
isc.defineClass("RestDataSource", "DataSource");


isc.RestDataSource.addProperties({
    serverType:"generic",

    //> @attr    RestDataSource.dataFormat   (string : "xml" : IR)
    // Expected format for server responses. RestDataSources handle <code>"json"</code> and
    // <code>"xml"</code> format responses by default. See class overview documentation for 
    // examples of responses in each format.
    // @visibility external
    //<
    dataFormat:"xml",
    
    //> @attr RestDataSource.xmlRecordXPath    (string : "/response/data/*" : IR)
    // <code>recordXPath</code> mapping to the data node of XML returned by the server.
    // Applies if this.dataFormat is set to <code>"xml"</code>.<br>
    // The default value will pick up data from a response structured as follows:<br>
    // <pre>
    // &lt;response&gt;
    //    &lt;status&gt;0&lt;/status&gt;
    //    &lt;data&gt;
    //      &lt;record&gt;
    //          &lt;field1&gt;value&lt;/field1&gt;
    //          &lt;field2&gt;value&lt;/field2&gt;
    //      &lt;/record&gt;
    //      &lt;record&gt;
    //          &lt;field1&gt;value&lt;/field1&gt;
    //          &lt;field2&gt;value&lt;/field2&gt;
    //      &lt;/record&gt;
    //    &lt;/data&gt;
    // &lt;/response&gt;
    // </pre>
    // @visibility external
    //<
    xmlRecordXPath:"/response/data/*",
    
    //> @attr RestDataSource.jsonRecordXPath    (string : "/response/data" : IR)
    // <code>recordXPath</code> mapping to the data node of json returned by the server.
    // Applies if this.dataFormat is set to <code>"json"</code><br>
    // The default value will pick up data from a response structured as follows:<br>
    // <pre>
    // {response:
    //  {status:0,
    //   data:[
    //      {field1:"value", field2:"value"},
    //      {field1:"value", field2:"value"}
    //   ]
    // }
    // </pre>
    // @visibility external
    //<
    jsonRecordXPath:"/response/data",
    
    // Overrid init to pick up these paths
    init : function () {
        this.recordXPath = (this.dataFormat == "xml" ? this.xmlRecordXPath : this.jsonRecordXPath);
        return this.Super("init", arguments);
    },
    
    //> @attr RestDataSource.operationBindings (Array of OperationBinding : [...] : IR)
    // RestDataSource OperationBindings set to specify default dataProtocol per operationType.
    // Default databindings are:
    // <pre>
    //   operationBindings : [
    //     {operationType:"fetch", dataProtocol:"getParams"},
    //     {operationType:"add", dataProtocol:"postParams"},
    //     {operationType:"remove", dataProtocol:"postParams"},
    //     {operationType:"update", dataProtocol:"postParams"} 
    //   ],
    // </pre>
    // If you are integrating with a +link{RestDataSource,REST} server that requires the more
    // obscure +link{rpcRequest.httpMethod}s of "PUT", "DELETE" or "HEAD", you can specify these
    // httpMethod settings via +link{operationBinding.requestProperties}.  dataProtocol settings
    // that mention "GET" or "POST" are compatible with these additional HTTP methods as well.
    // Typical +link{dataSource.operationBindings,operationBindings} for a REST server that uses
    // "PUT" and "DELETE" are as follows:
    // <pre>
    //   operationBindings:[
    //     {operationType:"fetch", dataProtocol:"getParams"},
    //     {operationType:"add", dataProtocol:"postParams"},
    //     {operationType:"remove", dataProtocol:"getParams", requestProperties:{httpMethod:"DELETE"}},
    //     {operationType:"update", dataProtocol:"postParams", requestProperties:{httpMethod:"PUT"}}
    //   ],
    // </pre>
    // 
    // @visibility external
    //<
    operationBindings:[
       {operationType:"fetch", dataProtocol:"getParams"},
       {operationType:"add", dataProtocol:"postParams"},
       {operationType:"remove", dataProtocol:"postParams"},
       {operationType:"update", dataProtocol:"postParams"}
    ],
    
    //> @attr RestDataSource.dataURL  (string : null : IR)
    // Default URL to contact to fulfill all DSRequests.  
    // RestDataSources also allow per-operationType dataURLs to be set via
    // <ul>
    // <li>+link{RestDataSource.fetchDataURL}</li>
    // <li>+link{RestDataSource.addDataURL}</li> 
    // <li>+link{RestDataSource.updateDataURL}</li>
    // <li>+link{RestDataSource.removeDataURL}</li>
    // </ul>
    // @visibility external
    //<
    
    //> @attr RestDataSource.fetchDataURL    (string : null : IR)
    // Custom dataURL for fetch type operations
    // @visibility external
    //<

    //> @attr RestDataSource.updateDataURL    (string : null : IR)
    // Custom dataURL for update type operations
    // @visibility external
    //<
    
    //> @attr RestDataSource.addDataURL    (string : null : IR)
    // Custom dataURL for add type operations
    // @visibility external
    //<
    
    //> @attr RestDataSource.removeDataURL    (string : null : IR)
    // dataURL for fetch type operations
    // @visibility external
    //<
    
    //> @attr RestDataSource.sendMetaData (boolean : true : IR)
    // Should  operation meta data be included when assmebling parameters to send 
    // to the server? If true, meta data parameters will be prefixed with the 
    // +link{RestDataSource.metaDataPrefix}.<br>
    // Applies to operations where OperationBinding.dataProtocol is set to 
    // <code>"getParams"</code> or <code>"postParams"</code> only.
    // @visibility external
    //<
    sendMetaData:true,

    //> @attr RestDataSource.metaDataPrefix   (string : "_" :IR)
    // I +link{RestDataSource.sendMetaData} is true, this attribute is used to specify
    // the prefix to apply to 'meta data' properties when assembling parameters to send to the 
    // server.  Applies to operations where OperationBinding.dataProtocol is set to 
    // <code>"getParams"</code> or <code>"postParams"</code> only.
    // @visibility external
    //<
    metaDataPrefix:"_",
    
    //> @attr RestDataSource.sendClientContext (boolean : null : IRW)
    // If true the +link{dsRequest.clientContext} will be sent to the server as a parameter
    // along with the request.
    // @visibility internal
    //<
    // only has an effect for "postMessage" data protocol
    
    // sendClientContext:null,
    
    // getDataURL() 
    // overridden to respect fetchDataURL et al.
    getDataURL : function (dsRequest) { 
        var type = dsRequest.operationType;

        if (type == "fetch" && this.fetchDataURL != null) 
            return this.fetchDataURL;
        if (type == "update" && this.updateDataURL != null)
            return this.updateDataURL;
        if (type == "add" && this.addDataURL != null) 
            return this.addDataURL;
        if (type == "remove" && this.removeDataURL != null)
            return this.removeDataURL;
        return this.Super("getDataURL", arguments);
    },
    
    // Override getDataProtocol - treat postXML dataProtocol specification as postMessage.
    getDataProtocol : function (dsRequest) {
        var protocol = this.Super("getDataProtocol", arguments);
        if (protocol == "postXML") protocol = "postMessage";
        return protocol;
    },

    //> @method RestDataSource.transformRequest()
    // RestDataSource overrides transformRequest in order to implement behaviors such as 
    // +link{metaDataPrefix} and serializing of data as XML for dataProcol:"postMessage".
    // <P>
    // If you override this method in order to add additional data to the DSRequest, you must
    // call +link{Class.Super,Super()} or you will remove the functionality provided by
    // RestDataSource.  For example:
    // <pre>
    //    transformRequest : function (dsRequest) {
    //        // modify dsRequest.data here, for example, add fixed criteria
    //        dsRequest.data.userId = myApplication.getCurrentUserId();
    //  
    //        return this.Super("transformRequest", arguments);
    //    }
    // </pre>
    // <P>
    // See +link{class:RestDataSource,RestDataSource overview} for a description of the 
    // standard formatting applied to requests.
    //
    // @visibility external
    //<
    transformRequest : function (dsRequest) {
        var protocol = this.getDataProtocol(dsRequest);
        // "postMessage": Post data as XML serialized message
        if (protocol == "postMessage") {
        
            if (this.dataFormat == "json") {
                this.logWarn('DataSource dataProtocol specified for operation as "postMessage". ' +
                             'Data will be sent to the server as a serialized xml message' +
                             ' even though dataFormat is set to "json"'); 
            }
            var params = {
                dataSource:this.getID(),
                operationType:dsRequest.operationType,
                operationId:dsRequest.operationId,
                startRow:dsRequest.startRow,
                endRow:dsRequest.endRow,
                sortBy:dsRequest.sortBy,
                textMatchStyle:dsRequest.textMatchStyle
            };
            if (this.sendClientContext) params.clientContext = dsRequest.clientContext;

            // send the componentId if present
            if (dsRequest.componentId) params.componentId = dsRequest.componentId;

            var ds = isc.DataSource.create({
                fields:[
                    {name:"data", multiple:true, type:this.getID()},
                    {name:"oldValues", type:this.getID()}
                ]
            });
            
            params.data = dsRequest.data;
            params.oldValues = dsRequest.oldValues;
            
            return ds.xmlSerialize(params, null, null, "request");
            

        // "getParams" / "postParams": HTTP Parameters format            
        } else {            
            if (protocol != "getParams" && protocol != "postParams") {
                this.logWarn("RestDataSource operation:"+ dsRequest.operationID + ", of type " 
                             + dsRequest.operationType + " has dataProtocol specified as '" 
                             + protocol + "'. Supported protocols are 'postParams', 'getParams' "
                             + "and 'postMessage' only. Defaulting to 'getParams'.");
                dsRequest.dataProtocol = 'getParams';                             
            }
            
            // All fields passed in as 'data' will be available directly as parameters
            // Also include any explicit parameters present on the dsRequest
            var params = isc.addProperties({}, dsRequest.data, dsRequest.params);
        
            // Attach meta data parameters to the transaction
            if (this.sendMetaData) {
                if (!this.parameterNameMap) {
                    var map = {};
                    
                    map[this.metaDataPrefix + "operationType"] = "operationType";
                    map[this.metaDataPrefix + "operationId"] = "operationId";
                    map[this.metaDataPrefix + "startRow"] = "startRow";
                    map[this.metaDataPrefix + "endRow"] = "endRow";
                    map[this.metaDataPrefix + "sortBy"] = "sortBy";
                    map[this.metaDataPrefix + "textMatchStyle"] = "textMatchStyle";
                    map[this.metaDataPrefix + "oldValues"] = "oldValues";
                    map[this.metaDataPrefix + "componentId"] = "componentId";

                    this.parameterNameMap = map;
                }
                
                // Meta data will be available as parameters with the metaDataPrefix applied
                for (var parameterName in this.parameterNameMap) {
                    var value = dsRequest[this.parameterNameMap[parameterName]];
                    if (value != null) params[parameterName] = value;
                }
                params[this.metaDataPrefix + "dataSource"] = this.getID();
            }
            return params;
        }
        
        
    },
    
    // Helper method to verify the status returned by the server is valid
    getValidStatus : function (status) {
        if (isc.isA.String(status)) {
            if (parseInt(status) == status) status = parseInt(status);
            else {
                status = isc.DSResponse[status];
                if (status == null) {
                    this.logWarn("Unable to map response code: " + status
                                  + " to a DSResponse code, setting status to DSResponse.STATUS_FAILURE.");
                    status = isc.DSResponse.STATUS_FAILURE;
                }
            }
        }
        if (status == null) status = isc.DSResponse.STATUS_SUCCESS;
        return status;
    },
    
    //> @method RestDataSource.transformResponse()
    // RestDataSource implements transformResponse in order to extract data and meta-data
    // properties from server responses, as described in the 
    // +link{class:RestDataSource,RestDataSource overview}.
    // <P>
    // You can override <code>transformResponse()</code> in order to further modify the
    // response, but if you do so, call +link{class.Super,Super()} as shown below or you will
    // wipe out the built-in response processing behavior of RestDataSource.
    // <pre>
    // transformResponse : function (dsResponse, dsRequest, data) {        
    //     var dsResponse = this.Super("transformResponse", arguments);
    //     // ... do something to dsResponse ...
    //     return dsResponse;
    // }
    // </pre> 
    // 
    // @visibility external
    //<
    transformResponse : function (dsResponse, dsRequest, data) {        
        if (dsResponse.status < 0) return dsResponse;
        if (this.dataFormat == "json") {
            var rawResponse = data.response || {};
        
            dsResponse.status = this.getValidStatus(rawResponse.status);     

            // if the status is a validation error, convert the errors from XML
            if (dsResponse.status == isc.DSResponse.STATUS_VALIDATION_ERROR) {
                var errors = rawResponse.errors;
                // Handle being returned an array of errors (per row) or a single error object
                // for the modified row.
                if (isc.isAn.Array(errors)) {
                    if (errors.length > 1) {
                        this.logWarn("server returned an array of errors - ignoring all but the first one");
                    }
                    errors = errors[0];   
                }
                dsResponse.errors = errors;
            // handle being passed a failure status with 'data' being an error string to display
            } else if (dsResponse.status < 0) {

                dsResponse.data = rawResponse.data;
            }
              
            if (rawResponse.totalRows != null) dsResponse.totalRows = rawResponse.totalRows;
            if (rawResponse.startRow != null) dsResponse.startRow = rawResponse.startRow;
            if (rawResponse.endRow != null) dsResponse.endRow = rawResponse.endRow;
            
        } else {
            dsResponse.status = this.getValidStatus(data.selectString("//status"));
            // if the status is a validation error, convert the errors from XML
            if (dsResponse.status == isc.DSResponse.STATUS_VALIDATION_ERROR) {
                var errors = data.selectNodes("//errors");
                errors = isc.xml.toJS(errors);
                if (errors.length > 1) {
                    this.logWarn("server returned an array of errors - ignoring all but the first one");
                }
                errors = errors[0];   
                dsResponse.errors = errors;
            // handle being passed a raw response where 'data' is an error string to display                            
            } else if (dsResponse.status < 0) {
                dsResponse.data = data.selectString("//data");
            }
              
            var totalRows = data.selectNumber("//totalRows");
            if (totalRows != null) dsResponse.totalRows = totalRows;
            
            var startRow = data.selectNumber("//startRow");
            if (startRow != null) dsResponse.startRow = startRow;
            
            var endRow = data.selectNumber("//endRow");
            if (endRow != null) dsResponse.endRow = endRow;
        }
        
        return dsResponse;
    }

});
