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
import com.smartgwt.client.data.Record;
import com.smartgwt.client.data.events.*;
import com.smartgwt.client.browser.window.*;
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
import com.smartgwt.client.widgets.tour.*;
import com.smartgwt.client.widgets.notify.*;
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
import com.smartgwt.client.widgets.notify.*;
import com.smartgwt.client.widgets.drawing.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.gwt.event.shared.*;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.core.client.JavaScriptObject;

import com.smartgwt.client.util.*;
import com.smartgwt.client.util.events.*;
import com.smartgwt.client.util.workflow.*;
import com.smartgwt.client.util.workflow.Process; // required to override java.lang.Process
import com.smartgwt.client.util.tour.*;


/**
 * An operationBinding tells a DataSource how to execute one of the basic DS operations: fetch, add, update, remove.  See
 * {@link com.smartgwt.client.data.DataSource#getOperationBindings DataSource.operationBindings}.
 */
@BeanFactory.FrameworkClass
public class OperationBinding extends DataClass {

    public static OperationBinding getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        return new OperationBinding(jsObj);
    }
        


    public OperationBinding(){
        
    }

    public OperationBinding(JavaScriptObject jsObj){
        
        setJavaScriptObject(jsObj);
    }


    public OperationBinding(DSOperationType operationType, String dataURL) {
        setOperationType(operationType);
		setDataURL(dataURL);
                
    }


    // ********************* Properties / Attributes ***********************

    /**
     * This property indicates whether this operation supports AdvancedCriteria. This setting  overrides {@link
     * com.smartgwt.client.data.DataSource#getAllowAdvancedCriteria DataSource.allowAdvancedCriteria} for this operation only.
     * See {@link com.smartgwt.client.data.DataSource#supportsAdvancedCriteria DataSource.supportsAdvancedCriteria()} for
     * further information. <p> <b>NOTE:</b> If you specify this property in a DataSource descriptor  (<code>.ds.xml</code>
     * file), it is enforced on the server.  This means that if you run  a request containing AdvancedCriteria against an
     * OperationBinding that advertises itself as <code>allowAdvancedCriteria:false</code>, it will be rejected.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param allowAdvancedCriteria New allowAdvancedCriteria value. Default value is null
     * @return {@link com.smartgwt.client.data.OperationBinding OperationBinding} instance, for chaining setter calls
     * @see com.smartgwt.client.data.DataSource#setAllowAdvancedCriteria
     */
    public OperationBinding setAllowAdvancedCriteria(Boolean allowAdvancedCriteria) {
        return (OperationBinding)setAttribute("allowAdvancedCriteria", allowAdvancedCriteria);
    }

    /**
     * This property indicates whether this operation supports AdvancedCriteria. This setting  overrides {@link
     * com.smartgwt.client.data.DataSource#getAllowAdvancedCriteria DataSource.allowAdvancedCriteria} for this operation only.
     * See {@link com.smartgwt.client.data.DataSource#supportsAdvancedCriteria DataSource.supportsAdvancedCriteria()} for
     * further information. <p> <b>NOTE:</b> If you specify this property in a DataSource descriptor  (<code>.ds.xml</code>
     * file), it is enforced on the server.  This means that if you run  a request containing AdvancedCriteria against an
     * OperationBinding that advertises itself as <code>allowAdvancedCriteria:false</code>, it will be rejected.
     *
     * @return Current allowAdvancedCriteria value. Default value is null
     * @see com.smartgwt.client.data.DataSource#getAllowAdvancedCriteria
     */
    public Boolean getAllowAdvancedCriteria()  {
        return getAttributeAsBoolean("allowAdvancedCriteria", true);
    }
    
    
    

    /**
     * A per-operationBinding setting for beanClassName, otherwise also settable at the top-level DataSource configuration.
     *
     * @param beanClassName New beanClassName value. Default value is null
     * @return {@link com.smartgwt.client.data.OperationBinding OperationBinding} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.serverds.DataSource#beanClassName
     * @see com.smartgwt.client.docs.ClientDataIntegration ClientDataIntegration overview and related methods
     */
    public OperationBinding setBeanClassName(String beanClassName) {
        return (OperationBinding)setAttribute("beanClassName", beanClassName);
    }

    /**
     * A per-operationBinding setting for beanClassName, otherwise also settable at the top-level DataSource configuration.
     *
     * @return Current beanClassName value. Default value is null
     * @see com.smartgwt.client.docs.serverds.DataSource#beanClassName
     * @see com.smartgwt.client.docs.ClientDataIntegration ClientDataIntegration overview and related methods
     */
    public String getBeanClassName()  {
        return getAttributeAsString("beanClassName");
    }
    

    /**
     * Applies only to dataFormat: "json".  Specifies the name of the query parameter that tells your JSON service what
     * function to call as part of the response for this operation. <P> Typically set once for the DataSource as a whole via
     * {@link com.smartgwt.client.data.DataSource#getCallbackParam DataSource.callbackParam}.
     *
     * @param callbackParam New callbackParam value. Default value is "callback"
     * @return {@link com.smartgwt.client.data.OperationBinding OperationBinding} instance, for chaining setter calls
     * @see com.smartgwt.client.data.DataSource#setCallbackParam
     * @see com.smartgwt.client.docs.ClientDataIntegration ClientDataIntegration overview and related methods
     */
    public OperationBinding setCallbackParam(String callbackParam) {
        return (OperationBinding)setAttribute("callbackParam", callbackParam);
    }

    /**
     * Applies only to dataFormat: "json".  Specifies the name of the query parameter that tells your JSON service what
     * function to call as part of the response for this operation. <P> Typically set once for the DataSource as a whole via
     * {@link com.smartgwt.client.data.DataSource#getCallbackParam DataSource.callbackParam}.
     *
     * @return Current callbackParam value. Default value is "callback"
     * @see com.smartgwt.client.data.DataSource#getCallbackParam
     * @see com.smartgwt.client.docs.ClientDataIntegration ClientDataIntegration overview and related methods
     */
    public String getCallbackParam()  {
        return getAttributeAsString("callbackParam");
    }
    
    
    

    /**
     * Format for response data for this operation. <P> Typically set once for the DataSource as a whole via {@link
     * com.smartgwt.client.data.DataSource#getDataFormat DataSource.dataFormat}.
     *
     * @param dataFormat New dataFormat value. Default value is "iscServer"
     * @return {@link com.smartgwt.client.data.OperationBinding OperationBinding} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.ClientDataIntegration ClientDataIntegration overview and related methods
     */
    public OperationBinding setDataFormat(DSDataFormat dataFormat) {
        return (OperationBinding)setAttribute("dataFormat", dataFormat == null ? null : dataFormat.getValue());
    }

    /**
     * Format for response data for this operation. <P> Typically set once for the DataSource as a whole via {@link
     * com.smartgwt.client.data.DataSource#getDataFormat DataSource.dataFormat}.
     *
     * @return Current dataFormat value. Default value is "iscServer"
     * @see com.smartgwt.client.docs.ClientDataIntegration ClientDataIntegration overview and related methods
     */
    public DSDataFormat getDataFormat()  {
        return EnumUtil.getEnum(DSDataFormat.values(), getAttribute("dataFormat"));
    }
    

    /**
     * Controls the format in which inputs are sent to the dataURL. <p> When a DataSource operation such as fetchData() is
     * invoked on this DataSource or a component bound to this DataSource, the data passed to the operation, if any, will be
     * sent to the <code>dataURL</code>.  The <code>dataProtocol</code> property controls the format in which the data is sent:
     * SOAP message, HTTP GET or POST of parameters, etc. <P> The <code>dataProtocol</code> property need not be set for a
     * DataSource with a WebService ( {@link com.smartgwt.client.data.DataSource#getServiceNamespace
     * DataSource.serviceNamespace} is set), in this case, SOAP messaging is used by default. <P> Developers may completely
     * bypass the Smart GWT comm system by setting dataProtocol to <code>"clientCustom"</code>. In this case Smart GWT will not
     * attempt to send any data to the server after calling {@link com.smartgwt.client.data.DataSource#transformRequest
     * DataSource.transformRequest()}. Instead the developer is expected to implement <code>transformRequest()</code> such that
     * it performs the necessary data action outside of Smart GWT, and then calls {@link
     * com.smartgwt.client.data.DataSource#processResponse DataSource.processResponse()},  passing in the {@link
     * com.smartgwt.client.data.DSRequest#getRequestId DSRequest.requestId} and an appropriate set of DSResponse properties to
     * indicate the result of the action. <P> NOTE: when {@link com.smartgwt.client.data.OperationBinding#getDataFormat
     * dataFormat} is "iscServer", <code>dataProtocol</code> is not consulted. Instead, Smart GWT uses a proprietary wire
     * format to communicate with the Smart GWT server, and the server-side DSRequest and DSResponse objects should be used to
     * access request data and form responses.
     *
     * @param dataProtocol New dataProtocol value. Default value is "getParams"
     * @return {@link com.smartgwt.client.data.OperationBinding OperationBinding} instance, for chaining setter calls
     * @see com.smartgwt.client.types.DSProtocol
     * @see com.smartgwt.client.docs.ClientDataIntegration ClientDataIntegration overview and related methods
     */
    public OperationBinding setDataProtocol(DSProtocol dataProtocol) {
        return (OperationBinding)setAttribute("dataProtocol", dataProtocol == null ? null : dataProtocol.getValue());
    }

    /**
     * Controls the format in which inputs are sent to the dataURL. <p> When a DataSource operation such as fetchData() is
     * invoked on this DataSource or a component bound to this DataSource, the data passed to the operation, if any, will be
     * sent to the <code>dataURL</code>.  The <code>dataProtocol</code> property controls the format in which the data is sent:
     * SOAP message, HTTP GET or POST of parameters, etc. <P> The <code>dataProtocol</code> property need not be set for a
     * DataSource with a WebService ( {@link com.smartgwt.client.data.DataSource#getServiceNamespace
     * DataSource.serviceNamespace} is set), in this case, SOAP messaging is used by default. <P> Developers may completely
     * bypass the Smart GWT comm system by setting dataProtocol to <code>"clientCustom"</code>. In this case Smart GWT will not
     * attempt to send any data to the server after calling {@link com.smartgwt.client.data.DataSource#transformRequest
     * DataSource.transformRequest()}. Instead the developer is expected to implement <code>transformRequest()</code> such that
     * it performs the necessary data action outside of Smart GWT, and then calls {@link
     * com.smartgwt.client.data.DataSource#processResponse DataSource.processResponse()},  passing in the {@link
     * com.smartgwt.client.data.DSRequest#getRequestId DSRequest.requestId} and an appropriate set of DSResponse properties to
     * indicate the result of the action. <P> NOTE: when {@link com.smartgwt.client.data.OperationBinding#getDataFormat
     * dataFormat} is "iscServer", <code>dataProtocol</code> is not consulted. Instead, Smart GWT uses a proprietary wire
     * format to communicate with the Smart GWT server, and the server-side DSRequest and DSResponse objects should be used to
     * access request data and form responses.
     *
     * @return Current dataProtocol value. Default value is "getParams"
     * @see com.smartgwt.client.types.DSProtocol
     * @see com.smartgwt.client.docs.ClientDataIntegration ClientDataIntegration overview and related methods
     */
    public DSProtocol getDataProtocol()  {
        return EnumUtil.getEnum(DSProtocol.values(), getAttribute("dataProtocol"));
    }
    

    /**
     * Transport to use for this operation.  Defaults to {@link com.smartgwt.client.data.DataSource#getDataTransport
     * DataSource.dataTransport}, which in turn defaults to {@link com.smartgwt.client.rpc.RPCManager#defaultTransport
     * defaultTransport}.  This would typically only be set to enable "scriptInclude" transport for contacting {@link
     * com.smartgwt.client.data.DataSource#getDataFormat JSON} web services hosted on servers other than the origin server. <p>
     * When using the "scriptInclude" transport, be sure to set {@link com.smartgwt.client.data.DataSource#getCallbackParam
     * DataSource.callbackParam} or {@link com.smartgwt.client.data.OperationBinding#getCallbackParam callbackParam} to match
     * the name of the query parameter name expected by your JSON service provider.
     *
     * @param dataTransport New dataTransport value. Default value is RPCManager.defaultTransport
     * @return {@link com.smartgwt.client.data.OperationBinding OperationBinding} instance, for chaining setter calls
     * @see com.smartgwt.client.types.RPCTransport
     * @see com.smartgwt.client.data.DataSource#setCallbackParam
     * @see com.smartgwt.client.docs.ClientDataIntegration ClientDataIntegration overview and related methods
     */
    public OperationBinding setDataTransport(RPCTransport dataTransport) {
        return (OperationBinding)setAttribute("dataTransport", dataTransport == null ? null : dataTransport.getValue());
    }

    /**
     * Transport to use for this operation.  Defaults to {@link com.smartgwt.client.data.DataSource#getDataTransport
     * DataSource.dataTransport}, which in turn defaults to {@link com.smartgwt.client.rpc.RPCManager#defaultTransport
     * defaultTransport}.  This would typically only be set to enable "scriptInclude" transport for contacting {@link
     * com.smartgwt.client.data.DataSource#getDataFormat JSON} web services hosted on servers other than the origin server. <p>
     * When using the "scriptInclude" transport, be sure to set {@link com.smartgwt.client.data.DataSource#getCallbackParam
     * DataSource.callbackParam} or {@link com.smartgwt.client.data.OperationBinding#getCallbackParam callbackParam} to match
     * the name of the query parameter name expected by your JSON service provider.
     *
     * @return Current dataTransport value. Default value is RPCManager.defaultTransport
     * @see com.smartgwt.client.types.RPCTransport
     * @see com.smartgwt.client.data.DataSource#getCallbackParam
     * @see com.smartgwt.client.docs.ClientDataIntegration ClientDataIntegration overview and related methods
     */
    public RPCTransport getDataTransport()  {
        return EnumUtil.getEnum(RPCTransport.values(), getAttribute("dataTransport"));
    }
    

    /**
     * URL to contact to fulfill DSRequests for this operationBinding. <P> <code>dataURL</code> is typically set as
     * DataSource.dataURL rather than on each individual operationBinding. <P> <code>dataURL</code> can be omitted for a
     * DataSource using a Web Service ({@link com.smartgwt.client.data.DataSource#getServiceNamespace
     * DataSource.serviceNamespace} is set).
     *
     * @param dataURL New dataURL value. Default value is null
     * @return {@link com.smartgwt.client.data.OperationBinding OperationBinding} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.URL URL 
     * @see com.smartgwt.client.docs.ClientDataIntegration ClientDataIntegration overview and related methods
     */
    public OperationBinding setDataURL(String dataURL) {
        return (OperationBinding)setAttribute("dataURL", dataURL);
    }

    /**
     * URL to contact to fulfill DSRequests for this operationBinding. <P> <code>dataURL</code> is typically set as
     * DataSource.dataURL rather than on each individual operationBinding. <P> <code>dataURL</code> can be omitted for a
     * DataSource using a Web Service ({@link com.smartgwt.client.data.DataSource#getServiceNamespace
     * DataSource.serviceNamespace} is set).
     *
     * @return Current dataURL value. Default value is null
     * @see com.smartgwt.client.docs.URL URL 
     * @see com.smartgwt.client.docs.ClientDataIntegration ClientDataIntegration overview and related methods
     */
    public String getDataURL()  {
        return getAttributeAsString("dataURL");
    }
    

    /**
     * HTTP parameters that should be submitted with every DSRequest. <P> Useful for authenticated services that require a
     * sessionId with every request. <P> Can be set for all operations of a given DataSource as DataSource.defaultParams.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param defaultParams New defaultParams value. Default value is null
     * @return {@link com.smartgwt.client.data.OperationBinding OperationBinding} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.ClientDataIntegration ClientDataIntegration overview and related methods
     */
    public OperationBinding setDefaultParams(Map defaultParams) {
        return (OperationBinding)setAttribute("defaultParams", defaultParams);
    }

    /**
     * HTTP parameters that should be submitted with every DSRequest. <P> Useful for authenticated services that require a
     * sessionId with every request. <P> Can be set for all operations of a given DataSource as DataSource.defaultParams.
     *
     * @return Current defaultParams value. Default value is null
     * @see com.smartgwt.client.docs.ClientDataIntegration ClientDataIntegration overview and related methods
     */
    public Map getDefaultParams()  {
        return getAttributeAsMap("defaultParams");
    }
    

    /**
     * An optional description of the operationBinding's behavior.  Not automatically exposed on any component, but useful for
     * developer documentation, and as such is included on any {@link com.smartgwt.client.docs.OpenapiSupport OpenAPI
     * specification} generated by the framework.  Markdown is a commonly used syntax, but you may also embed HTML content in a
     * CDATA tag.
     *
     * @param description New description value. Default value is null
     * @return {@link com.smartgwt.client.data.OperationBinding OperationBinding} instance, for chaining setter calls
     */
    public OperationBinding setDescription(String description) {
        return (OperationBinding)setAttribute("description", description);
    }

    /**
     * An optional description of the operationBinding's behavior.  Not automatically exposed on any component, but useful for
     * developer documentation, and as such is included on any {@link com.smartgwt.client.docs.OpenapiSupport OpenAPI
     * specification} generated by the framework.  Markdown is a commonly used syntax, but you may also embed HTML content in a
     * CDATA tag.
     *
     * @return Current description value. Default value is null
     */
    public String getDescription()  {
        return getAttributeAsString("description");
    }
    

    /**
     * The format in which the data should be exported.  Default is "csv". See {@link com.smartgwt.client.types.ExportFormat}
     * for more information.
     *
     * @param exportAs New exportAs value. Default value is "csv"
     * @return {@link com.smartgwt.client.data.OperationBinding OperationBinding} instance, for chaining setter calls
     */
    public OperationBinding setExportAs(ExportFormat exportAs) {
        return (OperationBinding)setAttribute("exportAs", exportAs == null ? null : exportAs.getValue());
    }

    /**
     * The format in which the data should be exported.  Default is "csv". See {@link com.smartgwt.client.types.ExportFormat}
     * for more information.
     *
     * @return Current exportAs value. Default value is "csv"
     */
    public ExportFormat getExportAs()  {
        return EnumUtil.getEnum(ExportFormat.values(), getAttribute("exportAs"));
    }
    

    /**
     * The list of field-names to export.  If provided, the field-list in the exported output is  limited and sorted as per the
     * list. <P> If exportFields is not provided, the exported output includes all visible fields  from the DataSource
     * (field.hidden=false), sorted in the order they're defined.
     *
     * @param exportFields New exportFields value. Default value is null
     * @return {@link com.smartgwt.client.data.OperationBinding OperationBinding} instance, for chaining setter calls
     */
    public OperationBinding setExportFields(String... exportFields) {
        return (OperationBinding)setAttribute("exportFields", exportFields);
    }

    /**
     * The list of field-names to export.  If provided, the field-list in the exported output is  limited and sorted as per the
     * list. <P> If exportFields is not provided, the exported output includes all visible fields  from the DataSource
     * (field.hidden=false), sorted in the order they're defined.
     *
     * @return Current exportFields value. Default value is null
     */
    public String[] getExportFields()  {
        return com.smartgwt.client.util.ConvertTo.arrayOfString(getAttributeAsJavaScriptObject("exportFields"));
    }
    

    /**
     * The name of the file to save the exported data into.
     *
     * @param exportFilename New exportFilename value. Default value is null
     * @return {@link com.smartgwt.client.data.OperationBinding OperationBinding} instance, for chaining setter calls
     */
    public OperationBinding setExportFilename(String exportFilename) {
        return (OperationBinding)setAttribute("exportFilename", exportFilename);
    }

    /**
     * The name of the file to save the exported data into.
     *
     * @return Current exportFilename value. Default value is null
     */
    public String getExportFilename()  {
        return getAttributeAsString("exportFilename");
    }
    

    /**
     * When set, causes the results of the DataSource Operation to be exported to a file, whose 
     * name and format are indicated by {@link com.smartgwt.client.data.OperationBinding#getExportFilename exportFilename} and 
     * {@link com.smartgwt.client.data.OperationBinding#getExportAs exportAs} respectively.  When no exportFilename is
     * provided, the 
     *  default is <i>Results</i> and the default value of exportAs is <i>csv</i>.  Once the Operation 
     *  completes, {@link com.smartgwt.client.data.DSRequest#getExportDisplay DSRequest.exportDisplay} specifies whether the 
     *  exported data will be downloaded to the file-system or displayed in a new window.   The 
     *  default value of exportDisplay is "download" which displays the Save As dialog.  See 
     *  {@link com.smartgwt.client.types.ExportDisplay} for more information.
     *  <P>
     * The export field-list can also be configured, see {@link com.smartgwt.client.data.DSRequest#getExportFields
     * DSRequest.exportFields}.
     *  <P>
     *  You can also configure the style of line-breaks to use when generating the output.  See
     *  {@link com.smartgwt.client.types.LineBreakStyle} for more information.
     *  <P>
     *  As well as setting this and other properties on the {@link com.smartgwt.client.data.OperationBinding}, Exports can be 
     *  initiated in two other ways.  You can set properties on the dsRequest by passing 
     * <i>requestProperties</i> into {@link com.smartgwt.client.data.DataSource#exportData DataSource.exportData()}.  Note that
     * this method does
     *  not support exporting to JSON format (see 
     *  <a href="http://forums.smartclient.com/showthread.php?t=235">this post</a> for more detail).
     *  Additionally, custom server code may set export-related properties on the 
     *  {@link com.smartgwt.client.data.DSResponse}.
     *  <P>
     *  <b>Format Examples</b>
     *  <P>
     *  XML format
     *  <pre>
     *      &lt;List&gt;
     *          &lt;Object&gt;
     *              &lt;id&gt;10101&lt;/id&gt;
     *              &lt;displayName&gt;Record 10101&lt;/displayName&gt;
     *          &lt;/Object&gt;
     *     &lt;/List&gt;
     *  </pre>
     *  JSON Format
     *  <pre>
     *      [
     *          { id: 10101, displayName: "Record 10101" }
     *      ]
     *  </pre>
     *  CSV Format
     *  <pre>
     *      id,displayName
     *      10101,"Record 10101"
     *  </pre>
     *
     * @param exportResults New exportResults value. Default value is false
     * @return {@link com.smartgwt.client.data.OperationBinding OperationBinding} instance, for chaining setter calls
     */
    public OperationBinding setExportResults(boolean exportResults) {
        return (OperationBinding)setAttribute("exportResults", exportResults);
    }

    /**
     * When set, causes the results of the DataSource Operation to be exported to a file, whose 
     * name and format are indicated by {@link com.smartgwt.client.data.OperationBinding#getExportFilename exportFilename} and 
     * {@link com.smartgwt.client.data.OperationBinding#getExportAs exportAs} respectively.  When no exportFilename is
     * provided, the 
     *  default is <i>Results</i> and the default value of exportAs is <i>csv</i>.  Once the Operation 
     *  completes, {@link com.smartgwt.client.data.DSRequest#getExportDisplay DSRequest.exportDisplay} specifies whether the 
     *  exported data will be downloaded to the file-system or displayed in a new window.   The 
     *  default value of exportDisplay is "download" which displays the Save As dialog.  See 
     *  {@link com.smartgwt.client.types.ExportDisplay} for more information.
     *  <P>
     * The export field-list can also be configured, see {@link com.smartgwt.client.data.DSRequest#getExportFields
     * DSRequest.exportFields}.
     *  <P>
     *  You can also configure the style of line-breaks to use when generating the output.  See
     *  {@link com.smartgwt.client.types.LineBreakStyle} for more information.
     *  <P>
     *  As well as setting this and other properties on the {@link com.smartgwt.client.data.OperationBinding}, Exports can be 
     *  initiated in two other ways.  You can set properties on the dsRequest by passing 
     * <i>requestProperties</i> into {@link com.smartgwt.client.data.DataSource#exportData DataSource.exportData()}.  Note that
     * this method does
     *  not support exporting to JSON format (see 
     *  <a href="http://forums.smartclient.com/showthread.php?t=235">this post</a> for more detail).
     *  Additionally, custom server code may set export-related properties on the 
     *  {@link com.smartgwt.client.data.DSResponse}.
     *  <P>
     *  <b>Format Examples</b>
     *  <P>
     *  XML format
     *  <pre>
     *      &lt;List&gt;
     *          &lt;Object&gt;
     *              &lt;id&gt;10101&lt;/id&gt;
     *              &lt;displayName&gt;Record 10101&lt;/displayName&gt;
     *          &lt;/Object&gt;
     *     &lt;/List&gt;
     *  </pre>
     *  JSON Format
     *  <pre>
     *      [
     *          { id: 10101, displayName: "Record 10101" }
     *      ]
     *  </pre>
     *  CSV Format
     *  <pre>
     *      id,displayName
     *      10101,"Record 10101"
     *  </pre>
     *
     * @return Current exportResults value. Default value is false
     */
    public boolean getExportResults()  {
        Boolean result = getAttributeAsBoolean("exportResults", true);
        return result == null ? false : result;
    }
    
    
    

    /**
     * If set, every invocation of this operationBinding will invalidate the local cache, forcing a server visit to refresh the
     * data.
     *
     * @param invalidateCache New invalidateCache value. Default value is null
     * @return {@link com.smartgwt.client.data.OperationBinding OperationBinding} instance, for chaining setter calls
     */
    public OperationBinding setInvalidateCache(Boolean invalidateCache) {
        return (OperationBinding)setAttribute("invalidateCache", invalidateCache);
    }

    /**
     * If set, every invocation of this operationBinding will invalidate the local cache, forcing a server visit to refresh the
     * data.
     *
     * @return Current invalidateCache value. Default value is null
     */
    public Boolean getInvalidateCache()  {
        return getAttributeAsBoolean("invalidateCache", true);
    }
    

    /**
     * The style of line-breaks to use in the exported output.  See {@link com.smartgwt.client.types.LineBreakStyle} for more
     * information.
     *
     * @param lineBreakStyle New lineBreakStyle value. Default value is null
     * @return {@link com.smartgwt.client.data.OperationBinding OperationBinding} instance, for chaining setter calls
     */
    public OperationBinding setLineBreakStyle(String lineBreakStyle) {
        return (OperationBinding)setAttribute("lineBreakStyle", lineBreakStyle);
    }

    /**
     * The style of line-breaks to use in the exported output.  See {@link com.smartgwt.client.types.LineBreakStyle} for more
     * information.
     *
     * @return Current lineBreakStyle value. Default value is null
     */
    public String getLineBreakStyle()  {
        return getAttributeAsString("lineBreakStyle");
    }
    
    
    

    /**
     * Optional operationId if this DataSource supports two or more variants of one of the basic DataSource operations, for
     * instance, a "fetch" that uses full text search and a "fetch" that accepts per-field search criteria.  See {@link
     * com.smartgwt.client.data.DSRequest#getOperationId DSRequest.operationId} for usage.
     *
     * @param operationId New operationId value. Default value is null
     * @return {@link com.smartgwt.client.data.OperationBinding OperationBinding} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.ClientDataIntegration ClientDataIntegration overview and related methods
     */
    public OperationBinding setOperationId(String operationId) {
        return (OperationBinding)setAttribute("operationId", operationId);
    }

    /**
     * Optional operationId if this DataSource supports two or more variants of one of the basic DataSource operations, for
     * instance, a "fetch" that uses full text search and a "fetch" that accepts per-field search criteria.  See {@link
     * com.smartgwt.client.data.DSRequest#getOperationId DSRequest.operationId} for usage.
     *
     * @return Current operationId value. Default value is null
     * @see com.smartgwt.client.docs.ClientDataIntegration ClientDataIntegration overview and related methods
     */
    public String getOperationId()  {
        return getAttributeAsString("operationId");
    }
    

    /**
     * Which operationType this operationBinding is for.  This property is only settable on an operationBinding, not a
     * DataSource as a whole.
     *
     * @param operationType New operationType value. Default value is null
     * @return {@link com.smartgwt.client.data.OperationBinding OperationBinding} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.ClientDataIntegration ClientDataIntegration overview and related methods
     */
    public OperationBinding setOperationType(DSOperationType operationType) {
        return (OperationBinding)setAttribute("operationType", operationType == null ? null : operationType.getValue());
    }

    /**
     * Which operationType this operationBinding is for.  This property is only settable on an operationBinding, not a
     * DataSource as a whole.
     *
     * @return Current operationType value. Default value is null
     * @see com.smartgwt.client.docs.ClientDataIntegration ClientDataIntegration overview and related methods
     */
    public DSOperationType getOperationType()  {
        return EnumUtil.getEnum(DSOperationType.values(), getAttribute("operationType"));
    }
    
    
    

    /**
     * Configures {@link com.smartgwt.client.data.DataSource#getPreventHTTPCaching DataSource.preventHTTPCaching} on a
     * per-operationType basis.
     *
     * @param preventHTTPCaching New preventHTTPCaching value. Default value is null
     * @return {@link com.smartgwt.client.data.OperationBinding OperationBinding} instance, for chaining setter calls
     */
    public OperationBinding setPreventHTTPCaching(Boolean preventHTTPCaching) {
        return (OperationBinding)setAttribute("preventHTTPCaching", preventHTTPCaching);
    }

    /**
     * Configures {@link com.smartgwt.client.data.DataSource#getPreventHTTPCaching DataSource.preventHTTPCaching} on a
     * per-operationType basis.
     *
     * @return Current preventHTTPCaching value. Default value is null
     */
    public Boolean getPreventHTTPCaching()  {
        return getAttributeAsBoolean("preventHTTPCaching", true);
    }
    
    
    
    

    /**
     * For an XML DataSource, tagName of the elements to be used as records. <p> This is a simple alternative to {@link
     * com.smartgwt.client.data.OperationBinding#getRecordXPath recordXPath} when the elements to be used as records all share
     * a tagName. <p> When a DataSource has a WebService, <code>recordName</code> can also be set to the name of any
     * <code>complexType</code> declared within the WebService's WSDL file.
     *
     * @param recordName New recordName value. Default value is null
     * @return {@link com.smartgwt.client.data.OperationBinding OperationBinding} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.ClientDataIntegration ClientDataIntegration overview and related methods
     */
    public OperationBinding setRecordName(String recordName) {
        return (OperationBinding)setAttribute("recordName", recordName);
    }

    /**
     * For an XML DataSource, tagName of the elements to be used as records. <p> This is a simple alternative to {@link
     * com.smartgwt.client.data.OperationBinding#getRecordXPath recordXPath} when the elements to be used as records all share
     * a tagName. <p> When a DataSource has a WebService, <code>recordName</code> can also be set to the name of any
     * <code>complexType</code> declared within the WebService's WSDL file.
     *
     * @return Current recordName value. Default value is null
     * @see com.smartgwt.client.docs.ClientDataIntegration ClientDataIntegration overview and related methods
     */
    public String getRecordName()  {
        return getAttributeAsString("recordName");
    }
    

    /**
     * For an XML or JSON DataSource, XPath expression used to retrieve the objects that will become DataSource records. <p>
     * For example, an "ItemSearch" web service might return a "Results" structure containing metadata along with the set of
     * Items that one might want to display in a grid.  An XPath expression like "/Results/Items" could be used to retrieve
     * just the Items, which would then become DataSource records. <p> For a JSON web service, the <code>recordXPath</code> is
     * applied to the returned JSON data via {@link com.smartgwt.client.data.XMLTools#selectObjects XMLTools.selectObjects()}. 
     * Only limited XPath syntax is allowed; see  {@link com.smartgwt.client.data.XMLTools#selectObjects selectObjects()} for
     * details. <P> For processing XML results, see {@link com.smartgwt.client.data.OperationBinding#getXmlNamespaces
     * xmlNamespaces} for information on the namespaces that are available in this XPath expression.  If you are contacting a
     * WSDL web service, note that {@link com.smartgwt.client.data.OperationBinding#getRecordName recordName} is an alternative
     * way to specify which records should be selected by their tagName or type, and this is usually simpler. <P> To learn
     * about XPath, try the following search: <a href="http://www.google.com/search?q=xpath+tutorial" target="_blank"
     * >http://www.google.com/search?q=xpath+tutorial</a>
     *
     * @param recordXPath New recordXPath value. Default value is null
     * @return {@link com.smartgwt.client.data.OperationBinding OperationBinding} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.XPathExpression XPathExpression 
     * @see com.smartgwt.client.docs.ClientDataIntegration ClientDataIntegration overview and related methods
     */
    public OperationBinding setRecordXPath(String recordXPath) {
        return (OperationBinding)setAttribute("recordXPath", recordXPath);
    }

    /**
     * For an XML or JSON DataSource, XPath expression used to retrieve the objects that will become DataSource records. <p>
     * For example, an "ItemSearch" web service might return a "Results" structure containing metadata along with the set of
     * Items that one might want to display in a grid.  An XPath expression like "/Results/Items" could be used to retrieve
     * just the Items, which would then become DataSource records. <p> For a JSON web service, the <code>recordXPath</code> is
     * applied to the returned JSON data via {@link com.smartgwt.client.data.XMLTools#selectObjects XMLTools.selectObjects()}. 
     * Only limited XPath syntax is allowed; see  {@link com.smartgwt.client.data.XMLTools#selectObjects selectObjects()} for
     * details. <P> For processing XML results, see {@link com.smartgwt.client.data.OperationBinding#getXmlNamespaces
     * xmlNamespaces} for information on the namespaces that are available in this XPath expression.  If you are contacting a
     * WSDL web service, note that {@link com.smartgwt.client.data.OperationBinding#getRecordName recordName} is an alternative
     * way to specify which records should be selected by their tagName or type, and this is usually simpler. <P> To learn
     * about XPath, try the following search: <a href="http://www.google.com/search?q=xpath+tutorial" target="_blank"
     * >http://www.google.com/search?q=xpath+tutorial</a>
     *
     * @return Current recordXPath value. Default value is null
     * @see com.smartgwt.client.docs.XPathExpression XPathExpression 
     * @see com.smartgwt.client.docs.ClientDataIntegration ClientDataIntegration overview and related methods
     */
    public String getRecordXPath()  {
        return getAttributeAsString("recordXPath");
    }
    

    /**
     * Additional properties to pass through to the {@link com.smartgwt.client.data.DSRequest} created for this operation. Note
     * that these will be cumulative with and will override on a per-property basis any properties set via {@link
     * com.smartgwt.client.data.DataSource#getRequestProperties DataSource.requestProperties}. <p> These properties are applied
     * before {@link com.smartgwt.client.data.DataSource#transformRequest DataSource.transformRequest()} is called.
     *
     * @param requestProperties New requestProperties value. Default value is null
     * @return {@link com.smartgwt.client.data.OperationBinding OperationBinding} instance, for chaining setter calls
     * @see com.smartgwt.client.data.DSRequest
     * @see com.smartgwt.client.data.DataSource#setRequestProperties
     * @see com.smartgwt.client.docs.ServerDataIntegration ServerDataIntegration overview and related methods
     */
    public OperationBinding setRequestProperties(DSRequest requestProperties) {
        JavaScriptObject config = JSOHelper.createObject();
        if (requestProperties != null) {
            JSOHelper.addProperties(config, requestProperties.getJsObj());
        }
        return (OperationBinding)setAttribute("requestProperties", requestProperties == null ? null : config);
    }

    /**
     * Additional properties to pass through to the {@link com.smartgwt.client.data.DSRequest} created for this operation. Note
     * that these will be cumulative with and will override on a per-property basis any properties set via {@link
     * com.smartgwt.client.data.DataSource#getRequestProperties DataSource.requestProperties}. <p> These properties are applied
     * before {@link com.smartgwt.client.data.DataSource#transformRequest DataSource.transformRequest()} is called.
     *
     * @return Current requestProperties value. Default value is null
     * @see com.smartgwt.client.data.DSRequest
     * @see com.smartgwt.client.data.DataSource#getRequestProperties
     * @see com.smartgwt.client.docs.ServerDataIntegration ServerDataIntegration overview and related methods
     */
    public DSRequest getRequestProperties()  {
        return new DSRequest(getAttributeAsJavaScriptObject("requestProperties"));
    }
    

    /**
     * A comma-separated list of field names that must be present in criteria / advancedCriteria provided by the caller.
     * Failure to provide any one of these will yield a {@link
     * com.smartgwt.client.rpc.RPCResponse#STATUS_CRITERIA_REQUIRED_ERROR STATUS_CRITERIA_REQUIRED_ERROR} from the server.
     *
     * @param requiredCriterion New requiredCriterion value. Default value is null
     * @return {@link com.smartgwt.client.data.OperationBinding OperationBinding} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.ClientDataIntegration ClientDataIntegration overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwtee/showcase/#required-criteria" target="examples">Required Criteria Example</a>
     */
    public OperationBinding setRequiredCriterion(String requiredCriterion) {
        return (OperationBinding)setAttribute("requiredCriterion", requiredCriterion);
    }

    /**
     * A comma-separated list of field names that must be present in criteria / advancedCriteria provided by the caller.
     * Failure to provide any one of these will yield a {@link
     * com.smartgwt.client.rpc.RPCResponse#STATUS_CRITERIA_REQUIRED_ERROR STATUS_CRITERIA_REQUIRED_ERROR} from the server.
     *
     * @return Current requiredCriterion value. Default value is null
     * @see com.smartgwt.client.docs.ClientDataIntegration ClientDataIntegration overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwtee/showcase/#required-criteria" target="examples">Required Criteria Example</a>
     */
    public String getRequiredCriterion()  {
        return getAttributeAsString("requiredCriterion");
    }
    
    
    
    

    /**
     * Optional schema describing how to extract DataSource records from the XML elements selected. <P> Once a set of XML
     * elements have been selected via <code>recordXPath</code> or <code>recordName</code>, those elements are normally
     * transformed to JavaScript objects using the <code>fields</code> of the DataSource that owns the operationBinding.  A
     * <code>responseDataSchema</code> can be specified instead if the XML differs in some way between different DataSource
     * operations, such that different values for {@link com.smartgwt.client.data.DataSourceField#getValueXPath
     * field.valueXPath} may be necessary to extract the same DataSource record from slightly different XML structures.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param responseDataSchema New responseDataSchema value. Default value is null
     * @return {@link com.smartgwt.client.data.OperationBinding OperationBinding} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.ClientDataIntegration ClientDataIntegration overview and related methods
     */
    public OperationBinding setResponseDataSchema(DataSource responseDataSchema) {
        return (OperationBinding)setAttribute("responseDataSchema", responseDataSchema == null ? null : responseDataSchema.getOrCreateJsObj());
    }

    /**
     * Optional schema describing how to extract DataSource records from the XML elements selected. <P> Once a set of XML
     * elements have been selected via <code>recordXPath</code> or <code>recordName</code>, those elements are normally
     * transformed to JavaScript objects using the <code>fields</code> of the DataSource that owns the operationBinding.  A
     * <code>responseDataSchema</code> can be specified instead if the XML differs in some way between different DataSource
     * operations, such that different values for {@link com.smartgwt.client.data.DataSourceField#getValueXPath
     * field.valueXPath} may be necessary to extract the same DataSource record from slightly different XML structures.
     *
     * @return Current responseDataSchema value. Default value is null
     * @see com.smartgwt.client.docs.ClientDataIntegration ClientDataIntegration overview and related methods
     */
    public DataSource getResponseDataSchema()  {
        return DataSource.getOrCreateRef(getAttributeAsJavaScriptObject("responseDataSchema"));
    }
    
    
    
    
    

    /**
     * For a DataSource contacting a {@link com.smartgwt.client.data.DataSource#getServiceNamespace WSDL web service}, setting
     * this flag means the DataSource doesn't actually attempt to contact the server but generates a sample response instead,
     * based on the XML Schema of the response message embedded in the WSDL. <P> The spoofed response will include all
     * complexType elements and will fill in appropriate values by type for all simpleType elements, although the spoofed data
     * will not conform to all xs:restriction declarations (eg xs:pattern). <P> Note that if your WSDL does not fully describe
     * the response format (some WSDL services just have a placeholder &lt;xs:any&gt; element), Smart GWT can only produce a
     * partial response.  To use a hand-generated sample response, just save an XML file to disk and use the {@link
     * com.smartgwt.client.data.OperationBinding#getDataURL dataURL} setting to point to it.
     *
     * @param spoofResponses New spoofResponses value. Default value is false
     * @return {@link com.smartgwt.client.data.OperationBinding OperationBinding} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.ClientDataIntegration ClientDataIntegration overview and related methods
     */
    public OperationBinding setSpoofResponses(boolean spoofResponses) {
        return (OperationBinding)setAttribute("spoofResponses", spoofResponses);
    }

    /**
     * For a DataSource contacting a {@link com.smartgwt.client.data.DataSource#getServiceNamespace WSDL web service}, setting
     * this flag means the DataSource doesn't actually attempt to contact the server but generates a sample response instead,
     * based on the XML Schema of the response message embedded in the WSDL. <P> The spoofed response will include all
     * complexType elements and will fill in appropriate values by type for all simpleType elements, although the spoofed data
     * will not conform to all xs:restriction declarations (eg xs:pattern). <P> Note that if your WSDL does not fully describe
     * the response format (some WSDL services just have a placeholder &lt;xs:any&gt; element), Smart GWT can only produce a
     * partial response.  To use a hand-generated sample response, just save an XML file to disk and use the {@link
     * com.smartgwt.client.data.OperationBinding#getDataURL dataURL} setting to point to it.
     *
     * @return Current spoofResponses value. Default value is false
     * @see com.smartgwt.client.docs.ClientDataIntegration ClientDataIntegration overview and related methods
     */
    public boolean getSpoofResponses()  {
        Boolean result = getAttributeAsBoolean("spoofResponses", true);
        return result == null ? false : result;
    }
    
    
    
    
    

    /**
     * Setting <code>useFlatFields</code> on an operationBinding is equivalent to setting {@link
     * com.smartgwt.client.data.DSRequest#getUseFlatFields DSRequest.useFlatFields} on all DataSource requests with the same
     * {@link com.smartgwt.client.data.OperationBinding#getOperationType operationType} as this <code>operationBinding</code>.
     * <P> Typical usage is to combine operationBinding.useFlatFields with  {@link
     * com.smartgwt.client.widgets.DataBoundComponent#getUseFlatFields searchForm.useFlatFields}, with the {@link
     * com.smartgwt.client.widgets.form.SearchForm} bound to the {@link com.smartgwt.client.data.WebService#getInputDS input
     * message} of the web service operation set as {@link com.smartgwt.client.data.OperationBinding#getWsOperation
     * wsOperation}.  This allows gratuitous nesting to be consistently bypassed in both the user presentation and in the
     * actual XML messaging. <P> Note that <code>useFlatFields</code> is not generally recommended for use with input messages
     * where multiple simple type fields exist with the same name, however if used in this way, the first field to use a given
     * name wins.  "first" means the first field encountered in a depth first search.  "wins" means only the first field will
     * be available in data binding, and only the first field will be populated in the generated XML message.
     *
     * @param useFlatFields New useFlatFields value. Default value is false
     * @return {@link com.smartgwt.client.data.OperationBinding OperationBinding} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.ClientDataIntegration ClientDataIntegration overview and related methods
     */
    public OperationBinding setUseFlatFields(boolean useFlatFields) {
        return (OperationBinding)setAttribute("useFlatFields", useFlatFields);
    }

    /**
     * Setting <code>useFlatFields</code> on an operationBinding is equivalent to setting {@link
     * com.smartgwt.client.data.DSRequest#getUseFlatFields DSRequest.useFlatFields} on all DataSource requests with the same
     * {@link com.smartgwt.client.data.OperationBinding#getOperationType operationType} as this <code>operationBinding</code>.
     * <P> Typical usage is to combine operationBinding.useFlatFields with  {@link
     * com.smartgwt.client.widgets.DataBoundComponent#getUseFlatFields searchForm.useFlatFields}, with the {@link
     * com.smartgwt.client.widgets.form.SearchForm} bound to the {@link com.smartgwt.client.data.WebService#getInputDS input
     * message} of the web service operation set as {@link com.smartgwt.client.data.OperationBinding#getWsOperation
     * wsOperation}.  This allows gratuitous nesting to be consistently bypassed in both the user presentation and in the
     * actual XML messaging. <P> Note that <code>useFlatFields</code> is not generally recommended for use with input messages
     * where multiple simple type fields exist with the same name, however if used in this way, the first field to use a given
     * name wins.  "first" means the first field encountered in a depth first search.  "wins" means only the first field will
     * be available in data binding, and only the first field will be populated in the generated XML message.
     *
     * @return Current useFlatFields value. Default value is false
     * @see com.smartgwt.client.docs.ClientDataIntegration ClientDataIntegration overview and related methods
     */
    public boolean getUseFlatFields()  {
        Boolean result = getAttributeAsBoolean("useFlatFields", true);
        return result == null ? false : result;
    }
    
    

    /**
     * Whether to use the {@link com.smartgwt.client.rpc.RPCManager#sendProxied HttpProxy} servlet to send requests described
     * by this operationBinding.  If unset, automatically detects whether using the HttpProxy is necessary based on the
     * same-origin policy. <P> Valid only with {@link com.smartgwt.client.data.OperationBinding#getDataProtocol dataProtocol}
     * settings other than ISCServer.
     *
     * @param useHttpProxy New useHttpProxy value. Default value is null
     * @return {@link com.smartgwt.client.data.OperationBinding OperationBinding} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.ClientDataIntegration ClientDataIntegration overview and related methods
     */
    public OperationBinding setUseHttpProxy(Boolean useHttpProxy) {
        return (OperationBinding)setAttribute("useHttpProxy", useHttpProxy);
    }

    /**
     * Whether to use the {@link com.smartgwt.client.rpc.RPCManager#sendProxied HttpProxy} servlet to send requests described
     * by this operationBinding.  If unset, automatically detects whether using the HttpProxy is necessary based on the
     * same-origin policy. <P> Valid only with {@link com.smartgwt.client.data.OperationBinding#getDataProtocol dataProtocol}
     * settings other than ISCServer.
     *
     * @return Current useHttpProxy value. Default value is null
     * @see com.smartgwt.client.docs.ClientDataIntegration ClientDataIntegration overview and related methods
     */
    public Boolean getUseHttpProxy()  {
        return getAttributeAsBoolean("useHttpProxy", true);
    }
    
    
    

    /**
     * Name of the web service operation that will be invoked in order to execute this DataSource operation. <P> Valid only for
     * a DataSource that has a WebService ({@link com.smartgwt.client.data.DataSource#getServiceNamespace
     * DataSource.serviceNamespace} is set).  Otherwise, use {@link com.smartgwt.client.data.OperationBinding#getDataURL
     * dataURL}. <P> Setting <code>wsOperation</code> means that {@link com.smartgwt.client.data.DSRequest#getData
     * DSRequest.data} will be serialized as the request message for the specified web service operation, with namespacing and
     * soap encoding handled automatically.  See {@link com.smartgwt.client.data.DataSource#transformRequest
     * DataSource.transformRequest()} for how to customize what data is sent to the server.
     *
     * @param wsOperation New wsOperation value. Default value is null
     * @return {@link com.smartgwt.client.data.OperationBinding OperationBinding} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.ClientDataIntegration ClientDataIntegration overview and related methods
     */
    public OperationBinding setWsOperation(String wsOperation) {
        return (OperationBinding)setAttribute("wsOperation", wsOperation);
    }

    /**
     * Name of the web service operation that will be invoked in order to execute this DataSource operation. <P> Valid only for
     * a DataSource that has a WebService ({@link com.smartgwt.client.data.DataSource#getServiceNamespace
     * DataSource.serviceNamespace} is set).  Otherwise, use {@link com.smartgwt.client.data.OperationBinding#getDataURL
     * dataURL}. <P> Setting <code>wsOperation</code> means that {@link com.smartgwt.client.data.DSRequest#getData
     * DSRequest.data} will be serialized as the request message for the specified web service operation, with namespacing and
     * soap encoding handled automatically.  See {@link com.smartgwt.client.data.DataSource#transformRequest
     * DataSource.transformRequest()} for how to customize what data is sent to the server.
     *
     * @return Current wsOperation value. Default value is null
     * @see com.smartgwt.client.docs.ClientDataIntegration ClientDataIntegration overview and related methods
     */
    public String getWsOperation()  {
        return getAttributeAsString("wsOperation");
    }
    

    /**
     * Optional object declaring namespace prefixes for use in {@link com.smartgwt.client.data.OperationBinding#getRecordXPath
     * recordXPath} and
     *  {@link com.smartgwt.client.data.DataSourceField#getValueXPath DataSourceField.valueXPath} XPath expressions.
     *  <P>
     *  <code>xmlNamespaces</code> should be specified as a mapping from namespace prefix to
     *  namespace URI, for example:
     *  <pre>
     *     xmlNamespaces : {
     *         az : "http://webservices.amazon.com/AWSECommerceService/2005-03-23"
     *     }
     *  </pre>
     *  By default, all namespaces declared on the document element (outermost element of the
     *  response) are made available with the prefix used in the document itself.
     *  <P>
     *  Then, for non-WSDL-described XML results, if there is a default namespace on the document
     *  element, it is made available with the special prefix "default".
     *  <P>
     *  For results of WSDL-described operations, the prefix "service" means the service namespace,
     *  that is, the "targetNamespace" on the &lt;definitions&gt; element from the WSDL file.  The prefix
     *  "schema" means the namespace of the outermost element in the output message for the current
     *  operation.  "default" will be the schema namespace if there is one, otherwise the service
     *  namespace.
     *  <P>
     *  For basic information on XML Namespaces and their use in XPath, try the following search:
     *  <a href="http://www.google.com/search?q=XPath+xml+namespaces" target="_blank"
     *  >http://www.google.com/search?q=XPath+xml+namespaces</a>
     *
     * @param xmlNamespaces New xmlNamespaces value. Default value is null
     * @return {@link com.smartgwt.client.data.OperationBinding OperationBinding} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.ClientDataIntegration ClientDataIntegration overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#yahoo_xml_integration_category" target="examples">Yahoo! XML Services Example</a>
     */
    public OperationBinding setXmlNamespaces(XmlNamespaces xmlNamespaces) {
        return (OperationBinding)setAttribute("xmlNamespaces", xmlNamespaces == null ? null : xmlNamespaces.getJsObj());
    }

    /**
     * Optional object declaring namespace prefixes for use in {@link com.smartgwt.client.data.OperationBinding#getRecordXPath
     * recordXPath} and
     *  {@link com.smartgwt.client.data.DataSourceField#getValueXPath DataSourceField.valueXPath} XPath expressions.
     *  <P>
     *  <code>xmlNamespaces</code> should be specified as a mapping from namespace prefix to
     *  namespace URI, for example:
     *  <pre>
     *     xmlNamespaces : {
     *         az : "http://webservices.amazon.com/AWSECommerceService/2005-03-23"
     *     }
     *  </pre>
     *  By default, all namespaces declared on the document element (outermost element of the
     *  response) are made available with the prefix used in the document itself.
     *  <P>
     *  Then, for non-WSDL-described XML results, if there is a default namespace on the document
     *  element, it is made available with the special prefix "default".
     *  <P>
     *  For results of WSDL-described operations, the prefix "service" means the service namespace,
     *  that is, the "targetNamespace" on the &lt;definitions&gt; element from the WSDL file.  The prefix
     *  "schema" means the namespace of the outermost element in the output message for the current
     *  operation.  "default" will be the schema namespace if there is one, otherwise the service
     *  namespace.
     *  <P>
     *  For basic information on XML Namespaces and their use in XPath, try the following search:
     *  <a href="http://www.google.com/search?q=XPath+xml+namespaces" target="_blank"
     *  >http://www.google.com/search?q=XPath+xml+namespaces</a>
     *
     * @return Current xmlNamespaces value. Default value is null
     * @see com.smartgwt.client.docs.ClientDataIntegration ClientDataIntegration overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#yahoo_xml_integration_category" target="examples">Yahoo! XML Services Example</a>
     */
    public XmlNamespaces getXmlNamespaces()  {
        return new XmlNamespaces(getAttributeAsJavaScriptObject("xmlNamespaces"));
    }
    

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************

    // ***********************************************************

}
