
/*
 * Isomorphic Smart GWT web presentation layer
 * Copyright 2000 and beyond Isomorphic Software, Inc.
 *
 * OWNERSHIP NOTICE
 * Isomorphic Software owns and reserves all rights not expressly granted in this source code,
 * including all intellectual property rights to the structure, sequence, and format of this code
 * and to all designs, interfaces, algorithms, schema, protocols, and inventions expressed herein.
 *
 *  If you have any questions, please email <sourcecode@isomorphic.com>.
 *
 *  This entire comment must accompany any portion of Isomorphic Software source code that is
 *  copied or moved from this file.
 */
/* sgwtgen */
package com.smartgwt.client.docs.serverds;

import com.smartgwt.client.types.*;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.docs.*;
import com.smartgwt.client.callbacks.*;
import com.smartgwt.client.widgets.form.fields.FormItem;
import java.util.List;
import java.util.Map;

/**
 * An operationBinding tells a DataSource how to execute one of the basic DS operations: fetch,
 * add, update, remove.<p>
 * <b>This class is not meant to be created and used, it is actually documentation of settings
 * allowed in a DataSource descriptor (.ds.xml file), for use with Smart GWT Pro Edition and
 * above.
 * See {@link com.smartgwt.client.docs.serverds} for how to use this documentation.</b>
 * <p>
 * See {@link com.smartgwt.client.docs.serverds.DataSource#operationBindings
 * DataSource.operationBindings}.
 */
public class OperationBinding {

    /**
     * A comma-separated list of field names that must be present in criteria / advancedCriteria
     * provided by the caller. Failure to provide any one of these will yield a {@link
     * com.smartgwt.client.rpc.RPCResponse#STATUS_CRITERIA_REQUIRED_ERROR
     * STATUS_CRITERIA_REQUIRED_ERROR} from the server.
     *
     * <p>Default value is null
     * @see com.smartgwt.client.docs.ClientDataIntegration ClientDataIntegration overview and related methods
     */
    public String requiredCriterion;

    /**
     * If set, every invocation of this operationBinding will invalidate the local cache, forcing a
     * server visit to refresh the data.
     *
     * <p>Default value is null
     */
    public Boolean invalidateCache;

    /**
     * Comma-separated list of user roles that are allowed to invoke the operation described by
     *  this operationBinding. If the current user has any of the roles listed, they can
     *  invoke the operation. Also note that <code>authentication.superuserRole</code> can be 
     * specified in the {@link com.smartgwt.client.docs.Server_properties server.properties} file. If
     * set this denotes a "super user" 
     *  role - any user with that role will have access to all operations, regardless of the
     *  "requiresRole" settings for the operation.
     *  <P>
     *  Whether the current user has a given role is determined by calling the standard Java
     *  servlets method <code>httpServletRequest.isUserInRole()</code>, hence works with both simple
     *  J2EE security (realms and form-based authentication) and JAAS (Java Authentication &
     *  Authorization Service).
     *  <P>
     *  If you wish to use a role-based security scheme that does not make use of the servlet API's 
     *  standards, Smart GWT Server also implements the <code>setAuthenticated</code> and
     *  <code>setUserRoles</code> methods on <code>RPCManager</code>. 
     *  You can use this API to tell Smart GWT that all the requests in the queue currently 
     *  being processed are associated with a user who has the roles you supply; in this case,
     *  Smart GWT will not attempt to resolve the user's roles via 
     *  <code>httpServletRequest.isUserInRole()</code>. When taking this approach, the 
     *  <code>rpcManager.setUserRoles()</code> method should be called on the server for 
     *  each transaction received from the client. We recommend doing this by overriding the 
     *  special IDACall servlet and checking server side state to determine the current user's 
     *  roles, calling the API, and then calling <code>handleDSRequest()</code> or
     *  <code>handleRPCRequest()</code> directly to handle the request(s) passed in.<br>
     *  Here's an example of this approach which assumes the current user's roles has been
     *  set directly on the HttpSession object as a comma-separated-string attribute "roles":
     *  <pre><code>
     *   public class SecureIDACall extends IDACall {
     *   
     *       public void processRequest(HttpServletRequest request,
     *               HttpServletResponse response)
     *        throws ServletException, IOException
     *       {
     *           HttpSession session = request.getSession();
     *           Object roles = session == null ? null : session.getAttribute("roles");
     *  
     *           if (roles != null) {
     *               try {
     *                   RequestContext context = RequestContext.instance(this, request, response);   
     *                   RPCManager rpc = new RPCManager(request, response);
     *                   rpc.setAuthenticated(true);
     *                   rpc.setUserRoles((String) roles); 
     *                   
     *                   // call processRPCTransaction() to iterate through all RPCRequests and
     *                   // DSRequests and execute them
     *                   processRPCTransaction(rpc, context);
     *  
     *               } catch (Throwable e) {
     *                   handleError(response, e);
     *               }
     *           } else {
     *               super.processRequest(request, response);
     *           } 
     *       }
     *   }
     *  </code></pre>
     *  <P>
     *  If there is an operationBinding declared for a given operationType which does not have an
     * {@link com.smartgwt.client.docs.serverds.OperationBinding#operationId operationId}, that is, it
     * is the default operationBinding for the type, then any other
     *  operationBinding of the same type is assumed to have the same setting for
     *  <code>requiresRole</code> as the default operationBinding for the operationType.  For
     *  example, given these declarations:
     *  <pre>
     *      &lt;operationBinding operationType="fetch" requiresRole="manager"&gt;
     *            ... settings ...
     *       &lt;/operationBinding&gt;
     *      &lt;operationBinding operationType="fetch" operationId="fetchWithExtraFields"&gt;
     *            ... settings ...
     *       &lt;/operationBinding&gt;
     *  </pre>
     *  The second operationBinding requires the "manager" role even though there is no explicit
     *  <code>requiresRole</code> declaration.  To prevent the "manager" role being required by the
     *  second operationBinding, add <code>requireRole=""</code>.
     *  <P>
     * Note that if {@link com.smartgwt.client.docs.serverds.DataSource#requiresRole
     * DataSource.requiresRole} is set, all operations on the DataSource require
     *  the roles set for the DataSource as a whole, even if they declare individual
     *  <code>requiresRole</code> attributes.
     *  <P>
     *  This property is valid only for a server-side DataSource when using the Smart GWT Server.
     *  <P>
     *  <h3>Special rules for cache sync</h3>
     *  <P>
     *  After successfull "add" or "update" operation cache sync request is performed, which is using 
     * "fetch" operation of the same datasource. It may happen that user is allowed to add records,
     * but 
     *  is not allowed to fetch them, for example:
     *  <pre>
     *      &lt;operationBinding operationType="fetch" requiresRole="admin"&gt;
     *            ... settings ...
     *      &lt;/operationBinding&gt;
     *      &lt;operationBinding operationType="add"&gt;
     *            ... settings ...
     *      &lt;/operationBinding&gt;
     *  </pre>
     * User without "admin" role will be able to successfully add record, but the cache sync operation
     * 
     * will fail due to security violation. In this case the record will be saved to database, but the
     * 
     * added record will not be fetched from database, instead just {@link
     * com.smartgwt.client.data.DSRequest#getOldValues old values} 
     * overlaid with submitted values will be returned. So, any changes made to the new record during 
     * request execution, including generated values for primary key fields of "sequence" type, will
     * not 
     *  be returned to the client.
     *  <p>
     * However, if "add" or "update" operation explicitly declares {@link
     * com.smartgwt.client.data.OperationBinding#getCacheSyncOperation cacheSyncOperation},
     * cache sync request will be executed even if the user does not meet the security checks for the 
     * operationBinding. Note that field-level security still will be respected and disallowed fields
     * will 
     *  be excluded from returned data.
     *
     * <p>Default value is null
     * @see com.smartgwt.client.docs.DeclarativeSecurity DeclarativeSecurity overview and related methods
     */
    public String requiresRole;

    /**
     * For an XML DataSource, tagName of the elements to be used as records. <p> This is a simple
     * alternative to {@link com.smartgwt.client.docs.serverds.OperationBinding#recordXPath
     * recordXPath} when the elements to be used as records all share a tagName. <p> When a DataSource
     * has a WebService, <code>recordName</code> can also be set to the name of any
     * <code>complexType</code> declared within the WebService's WSDL file.
     *
     * <p>Default value is null
     * @see com.smartgwt.client.docs.ClientDataIntegration ClientDataIntegration overview and related methods
     */
    public String recordName;

    /**
     * The name of the file to save the exported data into.
     *
     * <p>Default value is null
     */
    public String exportFilename;

    /**
     * Setting <code>useFlatFields</code> on an operationBinding is equivalent to setting {@link
     * com.smartgwt.client.data.DSRequest#getUseFlatFields DSRequest.useFlatFields} on all DataSource
     * requests with the same {@link com.smartgwt.client.docs.serverds.OperationBinding#operationType
     * operationType} as this <code>operationBinding</code>. <P> Typical usage is to combine
     * operationBinding.useFlatFields with  {@link
     * com.smartgwt.client.widgets.DataBoundComponent#getUseFlatFields searchForm.useFlatFields}, with
     * the {@link com.smartgwt.client.widgets.form.SearchForm} bound to the {@link
     * com.smartgwt.client.data.WebService#getInputDS input message} of the web service operation set
     * as {@link com.smartgwt.client.data.OperationBinding#getWsOperation wsOperation}.  This allows
     * gratuitous nesting to be consistently bypassed in both the user presentation and in the actual
     * XML messaging. <P> Note that <code>useFlatFields</code> is not generally recommended for use
     * with input messages where multiple simple type fields exist with the same name, however if used
     * in this way, the first field to use a given name wins.  "first" means the first field
     * encountered in a depth first search.  "wins" means only the first field will be available in
     * data binding, and only the first field will be populated in the generated XML message.
     *
     * <p>Default value is false
     * @see com.smartgwt.client.docs.ClientDataIntegration ClientDataIntegration overview and related methods
     */
    public boolean useFlatFields;

    /**
     * Specifies, for this operationBinding only, the list of field names that should be returned to
     * the client.  Typically this will be a subset of the {@link
     * com.smartgwt.client.docs.serverds.DataSource#fields DataSource.fields}, but note  that this is
     * not a requirement; <code>outputs</code> can include fields that are not defined in the
     * DataSource's field list.  In this case, the server will return extra fields even if  {@link
     * com.smartgwt.client.docs.serverds.DataSource#dropExtraFields DataSource.dropExtraFields} is
     * true. <p> You specify this property as a string containing a comma-separated list of field
     * names  (eg, "foo, bar, baz")
     *
     * <p>Default value is null
     */
    public String outputs;

    /**
     * Configures {@link com.smartgwt.client.docs.serverds.DataSource#preventHTTPCaching
     * DataSource.preventHTTPCaching} on a per-operationType basis.
     *
     * <p>Default value is null
     */
    public Boolean preventHTTPCaching;

    /**
     * Specifies, for this specific operationBinding, whether to qualify column names with table names
     * in any SQL we generate.  Overrides the {@link
     * com.smartgwt.client.docs.serverds.DataSource#qualifyColumnNames DataSource.qualifyColumnNames}
     * property. Only applicable to dataSources of {@link
     * com.smartgwt.client.docs.serverds.DataSource#serverType serverType} "sql".
     *
     * <p>Default value is true
     */
    public boolean qualifyColumnNames;

    /**
     * Scriptlet to be executed prior to the DataSource operation which is configured by this
     *  operationBinding. This setting overrides any 
     * {@link com.smartgwt.client.docs.serverds.DataSource#script script specified at the DataSource
     * level}
     *  for this operation.
     *  <P>
     * Scriptlets are used similarly to DMIs configured via {@link
     * com.smartgwt.client.docs.serverds.OperationBinding#serverObject serverObject} -
     *  they can add business logic by modifying the DSRequest before it's executed, modifying the
     *  default DSResponse, or taking other, unrelated actions.  
     *  <P>
     * Scriptlets are used similarly to DMIs configured via {@link
     * com.smartgwt.client.docs.serverds.DataSource#serverObject DataSource.serverObject} or
     *  {@link com.smartgwt.client.docs.serverds.OperationBinding#serverObject serverObject} -
     *  they can add business logic by modifying the DSRequest before it's executed, modifying the
     *  default DSResponse, or taking other, unrelated actions.  
     *  <P>
     *  For example:
     *  <pre>
     *     &lt;operationBindings&gt;
     *        &lt;operationBinding operationType="add"&gt;
     *            &lt;script language="groovy"&gt;
     *               ... Groovy code ...
     *            &lt;/script&gt;
     *        &lt;/operationBinding&gt;
     *     &lt;/operationBindings&gt;
     *  </pre>
     *  <P>
     *  Scriptlets can be written in any language supported by the "JSR 223" standard, including Java
     * itself.  See the {@link com.smartgwt.client.docs.DmiOverview DMI Script Overview} for rules on
     * how to return data,
     *  add additional imports, and other settings.
     *  <P>
     *  The following variables are available for DMI scriptlets:
     *  <ul>
     *  <li><i>dataSource</i>: the current DataSource
     *  <li><i>dsRequest</i>: the current DSRequest
     *  <li><i>criteria</i>: shortcut to DSRequest.getCriteria() (a Map)
     *  <li><i>values</i>: shortcut to DSRequest.getValues() (a Map)
     *  <li><i>oldValues</i>: shortcut to DSRequest.getOldValues() (a Map)
     *  <li><i>sqlConnection</i>: <b>SQLDataSource only</b>: the current SQLConnection object.  If
     * using {@link com.smartgwt.client.data.DataSource#getAutoJoinTransactions automatic
     * transactions} are enabled, this
     *  SQLConnection is in the context of the current transaction.
     *  <li><i>beanFactory</i>: the spring BeanFactory (when applicable)
     *  <li><i>cdiBeanManager</i>: the CDI BeanManager (when applicable)
     *  </ul>
     *  <P>
     *  Scriptlets also have access to a set of contextual variables related to the Servlets
     *  API, as follows:
     *  <ul>
     *  <li><i>servletRequest</i>: the current ServletRequest
     *  <li><i>session</i>: the current HttpSession
     *  <li><i>rpcManager</i>: the current RPCManager
     *  <li><i>servletResponse</i>: the current ServletResponse <b>(advanced use only)</b>
     *  <li><i>servletContext</i>: the current ServletContext<b>(advanced use only)</b>
     *  </ul>
     * As with DMI in general, be aware that if you write scriptlets that depend upon these variables,
     *  you preclude your DataSource from being used in the widest possible variety of
     *  circumstances.  For example, adding a scriptlet that relies on the <code>HttpSession</code>
     *  prevents your DataSource from being used in a command-line process.
     *  <P>
     *  <i>Note that if a dataSource configuration has both a <code>&lt;script&gt;</code> block and
     * a specified {@link com.smartgwt.client.docs.serverds.OperationBinding#serverObject
     * serverObject} for some operation, the
     *  script block will be executed, and the serverObject ignored.</i>
     *
     * <p>Default value is null
     */
    public String script;

    /**
     * Sets {@link com.smartgwt.client.docs.serverds.DataSource#progressiveLoading progressive loading
     * mode} for this particular  operation, overriding the DataSource-level setting.  Note that this
     * setting applies only to fetch operations - it has no effect if specified on any other kind of
     * operation.
     *
     * <p>Default value is null
     * @see com.smartgwt.client.docs.serverds.DataSource#progressiveLoading
     * @see com.smartgwt.client.docs.ProgressiveLoading ProgressiveLoading overview and related methods
     */
    public Boolean progressiveLoading;

    /**
     * List of fields to group by when using {@link com.smartgwt.client.docs.ServerSummaries
     * server-side summarization}. <p> Valid only for an operation of type "fetch".  See the  {@link
     * com.smartgwt.client.docs.ServerSummaries Server Summaries overview} for details and examples of
     * usage.
     *
     * <p>Default value is null
     * @see com.smartgwt.client.docs.serverds.OperationBinding#summaryFunctions
     * @see com.smartgwt.client.docs.ServerSummaries ServerSummaries overview and related methods
     */
    public String[] groupBy;

    /**
     * The style of line-breaks to use in the exported output.  See {@link
     * com.smartgwt.client.types.LineBreakStyle} for more information.
     *
     * <p>Default value is null
     */
    public String lineBreakStyle;

    /**
     * Definition of an email message that will be sent as an after-effect of selecting or updating
     * data. <p> Note that if a fixed number of different messages need to be sent, multiple 
     * <code>&lt;mail&gt;</code> tags may be specified.  For example, one mail could be sent to an 
     * admin address, and a different message to every member of a user group.
     *
     * <p>Default value is null
     */
    public Mail mail;

    /**
     * Controls the format in which inputs are sent to the dataURL. <p> When a DataSource operation
     * such as fetchData() is invoked on this DataSource or a component bound to this DataSource, the
     * data passed to the operation, if any, will be sent to the <code>dataURL</code>.  The
     * <code>dataProtocol</code> property controls the format in which the data is sent: SOAP message,
     * HTTP GET or POST of parameters, etc. <P> The <code>dataProtocol</code> property need not be set
     * for a DataSource with a WebService ( {@link
     * com.smartgwt.client.docs.serverds.DataSource#serviceNamespace DataSource.serviceNamespace} is
     * set), in this case, SOAP messaging is used by default. <P> Developers may completely bypass the
     * Smart GWT comm system by setting dataProtocol to <code>"clientCustom"</code>. In this case
     * Smart GWT will not attempt to send any data to the server after calling {@link
     * com.smartgwt.client.data.DataSource#transformRequest DataSource.transformRequest()}. Instead
     * the developer is expected to implement <code>transformRequest()</code> such that it performs
     * the necessary data action outside of Smart GWT, and then calls {@link
     * com.smartgwt.client.data.DataSource#processResponse DataSource.processResponse()},  passing in
     * the {@link com.smartgwt.client.data.DSRequest#getRequestId DSRequest.requestId} and an
     * appropriate set of DSResponse properties to indicate the result of the action. <P> NOTE: when
     * {@link com.smartgwt.client.data.OperationBinding#getDataFormat dataFormat} is "iscServer",
     * <code>dataProtocol</code> is not consulted. Instead, Smart GWT uses a proprietary wire format
     * to communicate with the Smart GWT server, and the server-side DSRequest and DSResponse objects
     * should be used to access request data and form responses.
     *
     * <p>Default value is "getParams"
     * @see com.smartgwt.client.types.DSProtocol
     * @see com.smartgwt.client.docs.ClientDataIntegration ClientDataIntegration overview and related methods
     */
    public DSProtocol dataProtocol;

    /**
     * Which operationType this operationBinding is for.  This property is only settable on an
     * operationBinding, not a DataSource as a whole.
     *
     * <p>Default value is null
     * @see com.smartgwt.client.docs.ClientDataIntegration ClientDataIntegration overview and related methods
     */
    public DSOperationType operationType;

    /**
     * Whether a user must be authenticated in order to access this operation.  For details of  what
     * is meant by "authenticated", see {@link
     * com.smartgwt.client.docs.serverds.DataSource#requiresAuthentication
     * DataSource.requiresAuthentication}. <P> To protect access to an entire operationType (eg, all
     * "fetch" operations), declare an operationBinding with
     * <code>requiresAuthentication="true"</code>, {@link
     * com.smartgwt.client.docs.serverds.OperationBinding#operationType operationType} set to the
     * operationType to be protected, but no {@link
     * com.smartgwt.client.docs.serverds.OperationBinding#operationId operationId}.  This will then
     * prevent access to the "fetch" operationType unless another {@link
     * com.smartgwt.client.docs.serverds.OperationBinding} declares requiresAuthentication="false"
     * with a specific {@link com.smartgwt.client.docs.serverds.OperationBinding#operationId
     * operationId}.
     *
     * <p>Default value is null
     * @see com.smartgwt.client.docs.DeclarativeSecurity DeclarativeSecurity overview and related methods
     */
    public Boolean requiresAuthentication;

    /**
     * Whether to use the subselect technique (see {@link
     * com.smartgwt.client.docs.serverds.DataSource#useSubselectForRowCount
     * DataSource.useSubselectForRowCount} for details) to derive a rowcount query for this operation.
     * If this property is not set, we fall back to the <code>useSubselectForRowCount</code> setting
     * on the DataSource,  and the defaults described in the documentation for that property.
     *
     * <p>Default value is null
     * @see com.smartgwt.client.docs.serverds.DataSource#useSubselectForRowCount
     * @see com.smartgwt.client.data.OperationBinding#getCustomSQL
     */
    public Boolean useSubselectForRowCount;

    /**
     * <b>Elements of this feature are only available with Power or better licenses.</b> See 
     *  <a href=http://smartclient.com/product>smartclient.com/product</a> for details.
     *  <p>
     * A list of {@link com.smartgwt.client.docs.serverds.DSRequestModifier}s that will be used to
     * modify the criteria of each 
     * {@link com.smartgwt.client.data.DSRequest} that uses this operationBinding.  Note that the
     * criteria elements are 
     *  applied to DSRequest criteria as follows:
     *  <ul>
     *  <li><b>Simple criteria:</b> The field and value are just applied as an extra key/value 
     * pair in the criteria map, as long as the {@link
     * com.smartgwt.client.docs.serverds.DSRequestModifier#operator operator} 
     *  attribute is left unset, or is set to "equals".  For any other setting of 
     *  <code>operator</code>, the criteria is first converted to the equivalent AdvancedCriteria 
     *  and then processed as described below</li>
     *  <li><b>AdvancedCriteria:</b> If the topmost operator is "and", we add the new criterion 
     *  as an additional criterion directly in the existing list.  Otherwise, we create a new 
     *  top-level AdvancedCriteria with an operator of "and".  This is then set to have two 
     *  elements in its criteria: the previous top-level criteria and the new criterion.</li>
     *  </ul>
     *  The effect of this is to apply any criteria specifed here as additional constraints on top
     *  of what the user has specified, and of course, the user is unable to affect this.  Thus, 
     *  this is a suitable and convenient place to enforce rules such as "Users can only ever see
     *  their own records". 
     *  <p>Below is an example of the XML as it should be defined in your ds.xml, datasource 
     *  definitions. <pre><code>
     *  &lt;operationBindings&gt;
     *    &lt;operationBinding operationType="fetch" operationId="..."&gt;
     *      &lt;criteria fieldName="USER_ROLE" value="ADMIN" operator="equals" /&gt;
     *    &lt;/operationBinding&gt;
     *  &lt;/operationBindings&gt;</code>
     *  </pre>
     *
     * <p>Default value is null
     * @see com.smartgwt.client.docs.serverds.OperationBinding#values
     * @see com.smartgwt.client.docs.TransactionChaining TransactionChaining overview and related methods
     */
    public DSRequestModifier[] criteria;

    /**
     * If set to "false", transformation of values for {@link
     * com.smartgwt.client.docs.serverds.DataSourceField#multiple multiple:true} fields, normally
     * controlled by {@link com.smartgwt.client.docs.serverds.DataSourceField#multipleStorage
     * DataSourceField.multipleStorage}, is instead disabled for this OperationBinding.
     *
     * <p>Default value is null
     */
    public Boolean transformMultipleFields;

    /**
     * Setting <code>skipAudit</code> to <code>true</code> indicates that {@link
     * com.smartgwt.client.docs.serverds.DataSource#audit auditing}  must be skipped for this
     * operationBinding. <p> Note, that this setting can be overrided by server-side API
     * <code>DSRequest.setSkipAudit()</code>.
     *
     * <p>Default value is null
     */
    public Boolean skipAudit;

    /**
     * A per-operationBinding setting for beanClassName, otherwise also settable at the top-level
     * DataSource configuration.
     *
     * <p>Default value is null
     * @see com.smartgwt.client.docs.serverds.DataSource#beanClassName
     * @see com.smartgwt.client.docs.ClientDataIntegration ClientDataIntegration overview and related methods
     */
    public String beanClassName;

    /**
     * The name of the method to invoke on the {@link com.smartgwt.client.docs.serverds.ServerObject}
     * for this operationBinding. <p> <b>NOTE:</b> If you have a {@link
     * com.smartgwt.client.docs.serverds.DataSource#serverObject DataSource-level ServerObject} and
     * wish to override this operation so that it simply calls a different method on the same  server
     * object, it is sufficient to specify just this property on the operationBinding: there is no
     * need to redefine the serverObject at the operationBinding level.
     *
     * <p>Default value is null
     */
    public String serverMethod;

    /**
     * Applies only to dataFormat: "json".  Specifies the name of the query parameter that tells your
     * JSON service what function to call as part of the response for this operation. <P> Typically
     * set once for the DataSource as a whole via {@link
     * com.smartgwt.client.docs.serverds.DataSource#callbackParam DataSource.callbackParam}.
     *
     * <p>Default value is "callback"
     * @see com.smartgwt.client.docs.serverds.DataSource#callbackParam
     * @see com.smartgwt.client.docs.ClientDataIntegration ClientDataIntegration overview and related methods
     */
    public String callbackParam;

    /**
     * When set, causes the results of the DataSource Operation to be exported to a file, whose 
     * name and format are indicated by {@link
     * com.smartgwt.client.docs.serverds.OperationBinding#exportFilename exportFilename} and 
     * {@link com.smartgwt.client.docs.serverds.OperationBinding#exportAs exportAs} respectively. 
     * When no exportFilename is provided, the 
     * default is <i>Results</i> and the default value of exportAs is <i>csv</i>.  Once the Operation 
     * completes, {@link com.smartgwt.client.data.DSRequest#getExportDisplay DSRequest.exportDisplay}
     * specifies whether the 
     *  exported data will be downloaded to the file-system or displayed in a new window.   The 
     *  default value of exportDisplay is "download" which displays the Save As dialog.  See 
     *  {@link com.smartgwt.client.types.ExportDisplay} for more information.
     *  <P>
     * The export field-list can also be configured, see {@link
     * com.smartgwt.client.data.DSRequest#getExportFields DSRequest.exportFields}.
     *  <P>
     *  You can also configure the style of line-breaks to use when generating the output.  See
     *  {@link com.smartgwt.client.types.LineBreakStyle} for more information.
     *  <P>
     * As well as setting this and other properties on the {@link
     * com.smartgwt.client.docs.serverds.OperationBinding}, Exports can be 
     *  initiated in two other ways.  You can set properties on the dsRequest by passing 
     * <i>requestProperties</i> into {@link com.smartgwt.client.data.DataSource#exportData
     * DataSource.exportData()}.  Note that this method does
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
     * <p>Default value is false
     */
    public boolean exportResults;

    /**
     * Optional ServerObject declaration that specifies the ServerObject configuration for this
     * operationBinding.  In the absence of a serverObject specification here, the one specified on
     * the DataSource itself is used by default, if present ({@link
     * com.smartgwt.client.docs.serverds.DataSource#serverObject DataSource.serverObject}).  If
     * neither is present, then Direct Method Invocation will not be enabled for this
     * operationBinding. <P> <i>Note that if a dataSource configuration has both a {@link
     * com.smartgwt.client.docs.serverds.OperationBinding#script &lt;script&gt;} block and a specified
     * <code>serverObject</code> for some operation, the script block will be executed, and the
     * serverObject ignored.</i>
     *
     * <p>Default value is null
     * @see com.smartgwt.client.docs.serverds.DataSource#serverObject
     */
    public ServerObject serverObject;

    /**
     * Additional properties to pass through to the {@link com.smartgwt.client.data.DSRequest} created
     * for this operation. Note that these will be cumulative with and will override on a per-property
     * basis any properties set via {@link
     * com.smartgwt.client.docs.serverds.DataSource#requestProperties DataSource.requestProperties}.
     * <p> These properties are applied before {@link
     * com.smartgwt.client.data.DataSource#transformRequest DataSource.transformRequest()} is called.
     *
     * <p>Default value is null
     * @see com.smartgwt.client.data.DSRequest
     * @see com.smartgwt.client.docs.serverds.DataSource#requestProperties
     * @see com.smartgwt.client.docs.ServerDataIntegration ServerDataIntegration overview and related methods
     */
    public DSRequest requestProperties;

    /**
     * The format in which the data should be exported.  Default is "csv". See {@link
     * com.smartgwt.client.types.ExportFormat} for more information.
     *
     * <p>Default value is "csv"
     */
    public ExportFormat exportAs;

    /**
     * A mapping from field names to {@link com.smartgwt.client.types.SummaryFunctionType summary
     * functions} to be applied to each field. <p> Valid only for an operation of type "fetch".  See
     * the  {@link com.smartgwt.client.docs.ServerSummaries Server Summaries overview} for examples of
     * usage.
     *
     * <p>Default value is null
     * @see com.smartgwt.client.docs.serverds.OperationBinding#groupBy
     * @see com.smartgwt.client.docs.ServerSummaries ServerSummaries overview and related methods
     */
    public Map summaryFunctions;

    /**
     * HTTP parameters that should be submitted with every DSRequest. <P> Useful for authenticated
     * services that require a sessionId with every request. <P> Can be set for all operations of a
     * given DataSource as DataSource.defaultParams.
     *
     * <p>Default value is null
     * @see com.smartgwt.client.docs.ClientDataIntegration ClientDataIntegration overview and related methods
     */
    public Map defaultParams;

    /**
     * <b>Elements of this feature are only available with Power or better licenses.</b> See  <a
     * href=http://smartclient.com/product>smartclient.com/product</a> for details. <p> A list of
     * {@link com.smartgwt.client.docs.serverds.DSRequestModifier}s that will be used to modify the
     * values object of each  {@link com.smartgwt.client.data.DSRequest} that uses this
     * operationBinding. See this example: <a
     * href="http://www.smartclient.com/smartgwtee/showcase/#transactions_queued_md"
     * target="examples">Master/Detail Add Example</a>.  <p>Below example of the xml as it should be
     * defined in ds.xml: <code>  &lt;operationBinding operationType="add"&gt;   &lt;values
     * fieldName="orderID" value="$responseData.last('queuedAdd_order','add').orderID" /&gt;  
     * &lt;/operationBinding&gt;</code>
     *
     * <p>Default value is null
     * @see com.smartgwt.client.docs.serverds.OperationBinding#criteria
     * @see com.smartgwt.client.docs.TransactionChaining TransactionChaining overview and related methods
     */
    public DSRequestModifier[] values;

    /**
     * Value to use for the {@link com.smartgwt.client.docs.serverds.OperationBinding#ownerIdField
     * ownerIdField} if no one  has authenticated. <p>Overrides the same setting at the {@link
     * com.smartgwt.client.docs.serverds.DataSource#guestUserId DataSource} level.
     *
     * <p>Default value is null
     * @see com.smartgwt.client.docs.serverds.OperationBinding#ownerIdField
     * @see com.smartgwt.client.docs.serverds.DataSource#guestUserId
     */
    public String guestUserId;

    /**
     * For an XML or JSON DataSource, XPath expression used to retrieve the objects that will become
     * DataSource records. <p> For example, an "ItemSearch" web service might return a "Results"
     * structure containing metadata along with the set of Items that one might want to display in a
     * grid.  An XPath expression like "/Results/Items" could be used to retrieve just the Items,
     * which would then become DataSource records. <p> For a JSON web service, the
     * <code>recordXPath</code> is applied to the returned JSON data via {@link
     * com.smartgwt.client.data.XMLTools#selectObjects XMLTools.selectObjects()}.  Only limited XPath
     * syntax is allowed; see  {@link com.smartgwt.client.data.XMLTools#selectObjects selectObjects()}
     * for details. <P> For processing XML results, see {@link
     * com.smartgwt.client.docs.serverds.OperationBinding#xmlNamespaces xmlNamespaces} for information
     * on the namespaces that are available in this XPath expression.  If you are contacting a WSDL
     * web service, note that {@link com.smartgwt.client.docs.serverds.OperationBinding#recordName
     * recordName} is an alternative way to specify which records should be selected by their tagName
     * or type, and this is usually simpler. <P> To learn about XPath, try the following search: <a
     * href="http://www.google.com/search?q=xpath+tutorial" target="_blank"
     * >http://www.google.com/search?q=xpath+tutorial</a>
     *
     * <p>Default value is null
     * @see com.smartgwt.client.docs.ClientDataIntegration ClientDataIntegration overview and related methods
     */
    public XPathExpression recordXPath;

    /**
     * You can explicitly declare the arguments to be passed to {@link
     * com.smartgwt.client.docs.serverds.OperationBinding#serverMethod serverMethod} using this
     * attribute.  This isn't required - in the absence of <code>methodArguments</code>, the DMI
     * implementation will still automatically pass a stock set of arguments to your method (see the
     * overview in {@link com.smartgwt.client.docs.serverds.ServerObject}), but specifying arguments
     * gives you the ability to call pre-existing methods without adding Smart GWT-specific code. <p>
     * The format for specifying <code>methodArguments</code> is as a comma separated list of VTL
     * (Velocity Template Language) expressions.  See the <a
     * href='http://jakarta.apache.org/velocity/docs/vtl-reference-guide.html' target='_blank'>VTL
     * Reference</a> and <a href='http://jakarta.apache.org/velocity/docs/user-guide.html'
     * target='_blank'>Velocity User Guide</a>  for an overview of how to use VTL. <p> The Velocity
     * context is pre-populated with the following variables - you can pass these verbatim as
     * arguments, or call methods on these objects and pass the resulting values: <ul> <li>dsRequest:
     * instance of the current DSRequest <li>request: the current HttpServletRequest <li>response: the
     * current HttpServletResponse <li>rpcManager: the instance of RPCManager for this request
     * <li>dataSource: a DataSource instance for this request </ul> So, for example, if you had a
     * method signature like the following: <p><code> public DSResponse fetch(SupplyItem criteria,
     * long startRow, long endRow) </code><p> You can invoke it by specifying
     * <code>methodArguments</code> as follows: <p><code> methodArguments="$dsRequest.criteria,
     * $dsRequest.startRow, $dsRequest.endRow" </code></p> Without <code>methodArguments</code>, there
     * would be no way for you to specify <code>startRow/endRow</code> as arguments.  You could, of
     * course, simply declare the method to take a <code>DSRequest</code> object and call
     * <code>getStartRow()/getEndRow()</code> in the body of the method.
     *
     * <p>Default value is null
     * @see com.smartgwt.client.docs.serverds.ServerObject
     */
    public String methodArguments;

    /**
     * Indicates that the specified {@link com.smartgwt.client.docs.VelocityExpression} must be true
     * for a user to access this operationBinding. <P> As with {@link
     * com.smartgwt.client.docs.serverds.OperationBinding#requiresRole requiresRole}, if there an
     * operationBinding that is the default operationBinding for the operationType, its
     * <code>requires</code> expression is assumed to apply to all other operationBindings of the same
     * type unless they explicitly set <code>requires=""</code> <P> {@link
     * com.smartgwt.client.docs.serverds.DataSource#requires DataSource.requires}, if specified,
     * applies before <code>operationBinding.requires</code> is evaluated.  In this case, both
     * <code>requires</code> expressions must be true for the request to be accepted.
     *
     * <p>Default value is null
     * @see com.smartgwt.client.docs.DeclarativeSecurity DeclarativeSecurity overview and related methods
     */
    public VelocityExpression requires;

    /**
     * Ordinarily, "update" and "remove" operations are only allowed for {@link
     * com.smartgwt.client.docs.serverds.DataSource}s that have a {@link
     * com.smartgwt.client.docs.serverds.DataSourceField#primaryKey primaryKey}, and all primary key
     * values are present in the request.  This is because an update of a DataSource with no primary
     * key,  or an update request that has missing primary key values, cannot be guaranteed to affect 
     * only one record. <p> Setting this property on an operationBinding circumvents this restriction
     * for that operation only. <p> <b>Warning:</b> Be aware that this is a potentially dangerous
     * setting and should be used with care.  With this flag set, you have no guarantee that an update
     * will not change or  remove every row in a table. <p> Note, in the case of doing an update or
     * delete operation with a primary key  <b><i>and additional criteria</i></b>, allowMultiUpdate
     * must be set or additional criteria  will be dropped and just the primary key fields will be
     * used in criteria. <p> Also, running <code>allowMultiUpdate</code> operations directly from the
     * client is not  straightforward because it requires the ability to specify criteria and values
     * separately in the request, which is not currently supported.  This can be worked around in
     * various ways, but really <code>allowMultiUpdate</code> is primarily intended for server-side 
     * operations.  Therefore, the recommended pattern is to use a  {@link
     * com.smartgwt.client.data.DataSource#performCustomOperation custom operation} from the client to
     * invoke a DMI on the server which performs the multi-update operation via a second, server-side
     * DSRequest.   <p> In any case, it's normally a good idea to set {@link
     * com.smartgwt.client.docs.serverds.OperationBinding#requiredCriterion requiredCriterion}  on the
     * multi-update operation to ensure that the alternative criteria is present as expected.
     *
     * <p>Default value is null
     * @see com.smartgwt.client.docs.serverds.OperationBinding#providesMissingKeys
     * @see com.smartgwt.client.docs.serverds.DataSource#defaultMultiUpdatePolicy
     */
    public Boolean allowMultiUpdate;

    /**
     * For a DataSource contacting a {@link
     * com.smartgwt.client.docs.serverds.DataSource#serviceNamespace WSDL web service}, setting this
     * flag means the DataSource doesn't actually attempt to contact the server but generates a sample
     * response instead, based on the XML Schema of the response message embedded in the WSDL. <P> The
     * spoofed response will include all complexType elements and will fill in appropriate values by
     * type for all simpleType elements, although the spoofed data will not conform to all
     * xs:restriction declarations (eg xs:pattern). <P> Note that if your WSDL does not fully describe
     * the response format (some WSDL services just have a placeholder &lt;xs:any&gt; element), Smart
     * GWT can only produce a partial response.  To use a hand-generated sample response, just save an
     * XML file to disk and use the {@link com.smartgwt.client.docs.serverds.OperationBinding#dataURL
     * dataURL} setting to point to it.
     *
     * <p>Default value is false
     * @see com.smartgwt.client.docs.ClientDataIntegration ClientDataIntegration overview and related methods
     */
    public boolean spoofResponses;

    /**
     * If explicitly set true or false, forces the use of a "hint" in the SQL we generate for paged 
     * queries on or off as appropriate.  If not set, defaults to the  {@link
     * com.smartgwt.client.docs.serverds.DataSource#sqlUsePagingHint DataSource.sqlUsePagingHint}
     * value.  Note this property is only applicable to  {@link
     * com.smartgwt.client.docs.serverds.DataSource#serverType SQL} DataSources, only when a  {@link
     * com.smartgwt.client.docs.serverds.DataSource#sqlPaging paging strategy} of "sqlLimit" is in
     * force, and it only has an  effect for those specific database products where we employ a native
     * hint in the generated  SQL in an attempt to improve performance.
     *
     * <p>Default value is null
     * @see com.smartgwt.client.docs.serverds.DataSource#sqlUsePagingHint
     */
    public Boolean sqlUsePagingHint;

    /**
     * Optional object declaring namespace prefixes for use in {@link
     * com.smartgwt.client.docs.serverds.OperationBinding#recordXPath recordXPath} and
     * {@link com.smartgwt.client.docs.serverds.DataSourceField#valueXPath DataSourceField.valueXPath}
     * XPath expressions.
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
     * that is, the "targetNamespace" on the &lt;definitions&gt; element from the WSDL file.  The
     * prefix
     *  "schema" means the namespace of the outermost element in the output message for the current
     *  operation.  "default" will be the schema namespace if there is one, otherwise the service
     *  namespace.
     *  <P>
     *  For basic information on XML Namespaces and their use in XPath, try the following search:
     *  <a href="http://www.google.com/search?q=XPath+xml+namespaces" target="_blank"
     *  >http://www.google.com/search?q=XPath+xml+namespaces</a>
     *
     * <p>Default value is null
     * @see com.smartgwt.client.docs.ClientDataIntegration ClientDataIntegration overview and related methods
     */
    public Map xmlNamespaces;

    /**
     * URL to contact to fulfill DSRequests for this operationBinding. <P> <code>dataURL</code> is
     * typically set as DataSource.dataURL rather than on each individual operationBinding. <P>
     * <code>dataURL</code> can be omitted for a DataSource using a Web Service ({@link
     * com.smartgwt.client.docs.serverds.DataSource#serviceNamespace DataSource.serviceNamespace} is
     * set).
     *
     * <p>Default value is null
     * @see com.smartgwt.client.docs.ClientDataIntegration ClientDataIntegration overview and related methods
     */
    public String dataURL;

    /**
     * Optional operationId if this DataSource supports two or more variants of one of the basic
     * DataSource operations, for instance, a "fetch" that uses full text search and a "fetch" that
     * accepts per-field search criteria.  See {@link
     * com.smartgwt.client.data.DSRequest#getOperationId DSRequest.operationId} for usage.
     *
     * <p>Default value is null
     * @see com.smartgwt.client.docs.ClientDataIntegration ClientDataIntegration overview and related methods
     */
    public String operationId;

    /**
     * Requires that the currently authenticated user match the contents of this field, for
     * client-initiated requests (i.e., where <code>DSRequest.isClientRequest()</code> returns true on
     * the server). <p>When a new row is added by a client-initiated {@link
     * com.smartgwt.client.data.DSRequest}, the ownerIdField will be automatically populated with the
     * currently authenticated user (clobbering any value supplied by the client). Client-initiated
     * attempts to update the ownerIdField will also be prevented. <p>If you wish to set the
     * ownerIdField to a different value via an "add" or "update" operation, you can do so in
     * server-side DMI code (possibly consulting <code>DSRequest.getClientSuppliedValues()</code> to
     * get the value that was clobbered). <p>For client-initiated "fetch", "update" or "remove"
     * operations, the server will modify client-supplied criteria so that only rows whose
     * ownerIdField matches the currently authenticated user can be read, updated or deleted.  
     * <p>Overrides the same setting at the {@link
     * com.smartgwt.client.docs.serverds.DataSource#ownerIdField DataSource} level. <p>If ownerIdField
     * is specified, {@link com.smartgwt.client.docs.serverds.DataSource#requiresAuthentication
     * requiresAuthentication} will default to <code>true</code>. If
     * <code>requiresAuthentication</code> is explicitly set to <code>false</code>, then
     * unauthenticated users will be able to see all records. To avoid this, you can use {@link
     * com.smartgwt.client.docs.serverds.DataSource#guestUserId guestUserId} to specify a default user
     * to apply when no one has authenticated.
     *
     * <p>Default value is null
     * @see com.smartgwt.client.docs.serverds.DataSource#ownerIdField
     * @see com.smartgwt.client.docs.serverds.OperationBinding#guestUserId
     */
    public String ownerIdField;

    /**
     * Indicates that field-level declarative security rules are waived for rows that were  created by
     * the current user, as described in the discussion of  {@link
     * com.smartgwt.client.docs.serverds.DataSource#creatorOverrides dataSource.creatorOverrides}. 
     * This setting overrides  <code>dataSource.creatorOverrides</code>, for this operation only.
     *
     * <p>Default value is null
     * @see com.smartgwt.client.docs.serverds.DataSourceField#editRequires
     * @see com.smartgwt.client.docs.serverds.DataSourceField#viewRequires
     * @see com.smartgwt.client.docs.serverds.DataSource#creatorOverrides
     * @see com.smartgwt.client.docs.FieldLevelAuth FieldLevelAuth overview and related methods
     */
    public Boolean creatorOverrides;

    /**
     * Ordinarily, "update" and "remove" operations are only allowed if all primary key values are
     * present in the request.  This is because an update request that has missing primary  key values
     * cannot be guaranteed to affect only one record. <p> Setting this property on an
     * operationBinding circumvents this restriction for that operation only.  Note, this property
     * differs from {@link com.smartgwt.client.docs.serverds.OperationBinding#allowMultiUpdate
     * allowMultiUpdate} in its  intent: <code>allowMultiUpdate</code> tells the framework that this
     * operation deliberately  affects multiple records; <code>providesMissingKeys</code> tells the
     * framework that this  operation will only affect one record, and will ensure this by providing
     * values for missing keys during its operation.  Unlike <code>allowMultiUpdate</code>, setting
     * this flag does not cause component caches to be {@link
     * com.smartgwt.client.widgets.grid.ListGrid#invalidateCache invalidated} <p> Providing values for
     * missing keys can be done in various ways:<ul> <li>Operations that specify <code>&lt;{@link
     * com.smartgwt.client.data.OperationBinding#getCustomSQL customSQL}&gt;</code> or     
     * <code>&lt;{@link com.smartgwt.client.data.OperationBinding#getWhereClause
     * whereClause}&gt;</code> can provide missing     key values from session storage or elsewhere in
     * the provided record</li> <li>Operations that specify <code>&lt;{@link
     * com.smartgwt.client.docs.ServerScript script}&gt;</code> can provide     arbitrary code to
     * manipulate the record in whatever way they like before executing the      underlying built-in
     * functionality</li> <li>Operations can specify <code>&lt;{@link
     * com.smartgwt.client.docs.serverds.OperationBinding#criteria criteria}&gt;</code>      to
     * provide missing keys</li> <li>A request can contain {@link
     * com.smartgwt.client.data.DSRequest#getFieldValueExpressions fieldValueExpressions},      which
     * can be used to provide values for missing keys</li> </ul> Note, you can also use a regular
     * {@link com.smartgwt.client.docs.DmiOverview DMI} to arbitrarily manipulate the record sent from
     * the client, including providing values for any missing keys.  If you do  this, you do not need
     * to specify <code>providesMissingKeys</code> because the request is  not validated for the
     * presence of key values until after the DMI has run. <p> <b>Warning:</b> Be aware that this is a
     * potentially dangerous setting and should be used with care.  With this flag set, the framework
     * cannot guarantee that an update will not  change or remove every row in a table: it becomes
     * your code's responsibility to ensure  that all PK values are provided to the operation by the
     * time it actually needs them.
     *
     * <p>Default value is null
     * @see com.smartgwt.client.docs.serverds.OperationBinding#allowMultiUpdate
     * @see com.smartgwt.client.docs.serverds.DataSourceField#autoGenerated
     */
    public Boolean providesMissingKeys;

    /**
     * The list of field-names to export.  If provided, the field-list in the exported output is 
     * limited and sorted as per the list. <P> If exportFields is not provided, the exported output
     * includes all visible fields  from the DataSource (field.hidden=false), sorted in the order
     * they're defined.
     *
     * <p>Default value is null
     */
    public String[] exportFields;

    /**
     * Optional schema describing how to extract DataSource records from the XML elements selected.
     * <P> Once a set of XML elements have been selected via <code>recordXPath</code> or
     * <code>recordName</code>, those elements are normally transformed to JavaScript objects using
     * the <code>fields</code> of the DataSource that owns the operationBinding.  A
     * <code>responseDataSchema</code> can be specified instead if the XML differs in some way between
     * different DataSource operations, such that different values for {@link
     * com.smartgwt.client.docs.serverds.DataSourceField#valueXPath field.valueXPath} may be necessary
     * to extract the same DataSource record from slightly different XML structures.
     *
     * <p>Default value is null
     * @see com.smartgwt.client.docs.ClientDataIntegration ClientDataIntegration overview and related methods
     */
    public DataSource responseDataSchema;

    /**
     * The paging strategy to use for this specific OperationBinding.  If this property is not set, we
     * fall back to the {@link com.smartgwt.client.docs.serverds.DataSource#sqlPaging
     * DataSource.sqlPaging} value, and the defaults described in the documentation for that property.
     *
     * <p>Default value is null
     * @see com.smartgwt.client.docs.serverds.DataSource#sqlPaging
     */
    public SQLPagingStrategy sqlPaging;

    /**
     * This property indicates whether this operation supports AdvancedCriteria. This setting 
     * overrides {@link com.smartgwt.client.docs.serverds.DataSource#allowAdvancedCriteria
     * DataSource.allowAdvancedCriteria} for this operation only. See {@link
     * com.smartgwt.client.data.DataSource#supportsAdvancedCriteria
     * DataSource.supportsAdvancedCriteria()} for further information. <p> <b>NOTE:</b> If you specify
     * this property in a DataSource descriptor  (<code>.ds.xml</code> file), it is enforced on the
     * server.  This means that if you run  a request containing AdvancedCriteria against an
     * OperationBinding that advertises itself as <code>allowAdvancedCriteria:false</code>, it will be
     * rejected.
     *
     * <p>Default value is null
     * @see com.smartgwt.client.docs.serverds.DataSource#allowAdvancedCriteria
     */
    public Boolean allowAdvancedCriteria;

}
