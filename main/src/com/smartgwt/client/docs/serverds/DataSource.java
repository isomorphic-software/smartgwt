
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
 * A DataSource is data-provider-independent description of a set of objects that will be loaded,
 * edited and saved within the user interface of your application.<p>
 * <b>This class is not meant to be created and used, it is actually documentation of settings
 * allowed in a DataSource descriptor (.ds.xml file), for use with Smart GWT Pro Edition and
 * above.
 * See {@link com.smartgwt.client.docs.serverds} for how to use this documentation.</b>
 * <p>
 * <P> Each DataSource consists of a list of {@link
 * com.smartgwt.client.docs.serverds.DataSource#fields fields} that make up a DataSource
 * <code>record</code>, along with {@link com.smartgwt.client.docs.serverds.DataSourceField#type
 * field types},  {@link com.smartgwt.client.docs.serverds.DataSourceField#validators validation
 * rules},  {@link com.smartgwt.client.docs.serverds.DataSourceField#foreignKey relationships} to
 * other DataSources, and other metadata. <P> The abstract object description provided by a
 * DataSource is easily mapped to a variety of backend object models and storage schemes.  The
 * following table shows analogous terminology across systems. <table border=1 class="normal">
 * <tr>   <td>Isomorphic Smart GWT</td>   <td>Relational Database</td>   <td>Enterprise Java Beans
 * (EJB)</td>   <td>Entity/Relationship Modeling</td>   <td>OO/UML</td>   <td>XML Schema/WSDL</td>
 * <td>LDAP</td> </tr><tr>   <td>DataSource</td>   <td>Table</td>   <td>EJB class</td>  
 * <td>Entity</td>   <td>Class</td>   <td>Element Schema (ComplexType)</td>   <td>Objectclass</td>
 * </tr><tr>   <td>Record</td>   <td>Row</td>   <td>EJB instance</td>   <td>Entity instance</td>  
 * <td>Class instance/Object</td>   <td>Element instance (ComplexType)</td>   <td>Entry</td>
 * </tr><tr>   <td>Field</td>   <td>Column</td>   <td>Property</td>   <td>Attribute</td>  
 * <td>Property/Attribute</td>   <td>Attribute or Element (SimpleType)</td>   <td>Attribute</td>
 * </tr></table> <P> DataSources can be {@link com.smartgwt.client.docs.DataSourceDeclaration
 * declared} in either JavaScript or XML format, and can also be {@link metadataImport imported}
 * from existing metadata formats, including XML Schema. <P> <i>Data Binding</i> is the process by
 * which {@link com.smartgwt.client.widgets.DataBoundComponent Data Binding-capable UI components}
 * can automatically configure themselves for viewing, editing and saving data described by
 * DataSources.  DataBinding is covered in the 'QuickStart Guide', Chapter 6, <i>Data Binding</i>.
 * <P> {@link com.smartgwt.client.docs.ClientServerIntegration Data Integration} is the process by
 * which a DataSource can be connected to server systems such as SQL DataBases, Java Object
 * models, WSDL web services and other data providers.  Data Integration comes in two variants:
 * client-side and server-side.  {@link com.smartgwt.client.docs.ServerDataIntegration Server-side
 * integration} uses the Smart GWT Java-based server to connect to data represented by Java
 * Objects or JDBC-accessible databases.  {@link com.smartgwt.client.docs.ClientDataIntegration
 * Client-side integration} connects Smart GWT DataSources to XML, JSON or other formats
 * accessible via HTTP. <P> DataSources have a concept of {@link
 * com.smartgwt.client.docs.DataSourceOperations 4 core operations} ("fetch", "add", "update" and
 * "remove") that can be performed on the set of objects represented by a DataSource.  Once a
 * DataSource has been integrated with your data store, databinding-capable  UI components can
 * leverage the 4 core DataSource operations to provide many complete user interactions without
 * the need to configure how each individual component loads and saves data. <P> These
 * interactions include {@link com.smartgwt.client.widgets.grid.ListGrid grid views}, {@link
 * com.smartgwt.client.widgets.tree.TreeGrid tree views},  {@link
 * com.smartgwt.client.widgets.viewer.DetailViewer detail views}, {@link
 * com.smartgwt.client.widgets.form.DynamicForm form}-based  {@link
 * com.smartgwt.client.widgets.form.DynamicForm#editRecord editing} and {@link
 * com.smartgwt.client.widgets.form.DynamicForm#saveData saving}, grid-based {@link
 * com.smartgwt.client.widgets.grid.ListGrid#getCanEdit editing} and {@link
 * com.smartgwt.client.widgets.grid.ListGrid#getSaveByCell saving}, and custom interactions
 * provided by <a
 * href="http://www.smartclient.com/smartgwt/showcase/#pattern_reuse_grid_form_category"
 * target="examples">Pattern Reuse Example</a> custom databinding-capable components.
 * @see com.smartgwt.client.widgets.DataBoundComponent
 * @see com.smartgwt.client.docs.SqlDataSource SqlDataSource overview and related methods
 */
public class DataSource {

    /**
     * If explicitly set true or left null, causes the server to use a "hint" in the SQL we  generate
     * for paged queries.  If explicitly set false, forces off the use of hints.  This property can be
     * overridden per operationBinding - see  {@link
     * com.smartgwt.client.docs.serverds.OperationBinding#sqlUsePagingHint
     * OperationBinding.sqlUsePagingHint}. <p> Note this property is only applicable to {@link
     * com.smartgwt.client.docs.serverds.DataSource#serverType SQL} DataSources,  only when a {@link
     * com.smartgwt.client.docs.serverds.DataSource#sqlPaging paging strategy} of "sqlLimit" is in
     * force, and it only has an effect for those specific database products where we employ a native
     * hint in the generated SQL in an attempt to improve performance.
     *
     * <p>Default value is null
     * @see com.smartgwt.client.docs.serverds.OperationBinding#sqlUsePagingHint
     */
    public Boolean sqlUsePagingHint;

    /**
     * Whether a user must be authenticated in order to access this DataSource.  This establishes a
     * default for the DataSource as a whole; individual {@link
     * com.smartgwt.client.docs.serverds.DataSource#operationBindings operationBindings} within the
     * DataSource may still override this setting by explicitly setting {@link
     * com.smartgwt.client.docs.serverds.OperationBinding#requiresAuthentication
     * OperationBinding.requiresAuthentication}. <P> Whether the user is authenticated is determined
     * by calling <code>httpServletRequest.getRemoteUser()</code>, hence works with both simple J2EE
     * security (realms and form-based authentication) and JAAS (Java Authentication & Authorization
     * Service). <P> If you wish to use an authentication scheme that does not make use of the servlet
     * API's  standards, Smart GWT Server also implements the <code>setAuthenticated</code> method on
     * <code>RPCManager</code>.  You can use this API to tell Smart GWT that all the  requests in the
     * queue currently being processed are associated with an authenticated user; in this case, Smart
     * GWT will not attempt to authenticate the user via 
     * <code>httpServletRequest.getRemoteUser()</code> <P> You can set the default value for this
     * property via setting "authentication.defaultRequired" in {@link
     * com.smartgwt.client.docs.Server_properties server.properties}.  This allows you to, for
     * example, cause all DataSources to require authentication for all operations by default. <P>
     * Note that setting this property does not automatically cause an authentication mechanism to
     * appear - you still need to separately configure an authentication system.  Likewise, setting
     * requiresAuthentication="false" does not automatically allow users to bypass your authentication
     * mechanism - you need to set up a URL that will accept DSRequests and process them similar to
     * the default "IDACall" servlet, and which is not protected by the authentication system.  See
     * {@link com.smartgwt.client.docs.ServletDetails Deploying Smart GWT} for details on the IDACall
     * servlet.
     *
     * <p>Default value is null
     * @see com.smartgwt.client.docs.DeclarativeSecurity DeclarativeSecurity overview and related methods
     */
    public Boolean requiresAuthentication;

    /**
     * Very advanced: for servers that do not support paging, and must return large numbers of XML
     * records in one HTTP response, Smart GWT breaks up the processing of the response in order to
     * avoid the "script running slowly" dialog appearing for an end user. <P> If you have a
     * relatively small number of records with a great deal of properties or subobjects on each
     * record, and you have not set {@link
     * com.smartgwt.client.docs.serverds.DataSource#dropExtraFields dropExtraFields} to eliminate
     * unused data, and you see the "script running slowly" dialog, you may need to set this number
     * lower.
     *
     * <p>Default value is 150
     */
    public int resultBatchSize;

    /**
     * This property has different meanings depending on the {@link
     * com.smartgwt.client.docs.serverds.DataSource#serverType serverType}: <p> <b>For SQL DataSources
     * (DataSources with serverType "sql")</b><br> If set, results from the database will be used to
     * create one instance of the indicated Java bean per database row.  Otherwise a Map is used to
     * represent each row retrieved from SQL. <P> With this feature active, a DSResponse from this
     * DataSource will contain a Collection of instances of the indicated <code>beanClassName</code>,
     * available via DSResponse.getData(). This creates a couple of possibilities: <P> <dl> <dt>Add
     * business logic for derived properties, such as computed formulas</dt> <dd>For example, declare
     * a DataSourceField named "revenueProjection".  By default this field will call
     * getRevenueProjection() on your bean to retrieve the value to send to the client.  Your
     * implementation of getRevenueProjection() could apply some kind of formula to other values
     * loaded from the database.</dd> <dt>Call business logic on retrieved beans via DMI</dt> <dd>By
     * adding a {@link com.smartgwt.client.docs.DmiOverview DMI} method that calls DSRequest.execute()
     * to retrieve a DSResponse, you have an opportunity to call business logic methods on the beans
     * representing each row affected by the DSRequest.  For example, notify a related BPEL process of
     * changes to certain fields.</dd> </dl> <P> By using <code>beanClassName</code> on a specific
     * {@link com.smartgwt.client.docs.serverds.OperationBinding}, you can: <ul> <li>Use a bean to
     * represent your data only when it matters; for example, avoid the overhead     of using a bean
     * for "fetch" operations, but do use a bean for "update" operations so     that you can execute
     * relevant business logic after the update completes.</li> <li>Skip the use of beans for complex
     * reporting queries that produce results unrelated to     your persistent object model.  Set
     * beanClassName to blank ("") on a specific     operationBinding to override
     * DataSource.beanClassName for that specific operation.</li> <li>For SQL joins that produce
     * additional data fields, use a special, operation-specific     bean that represents a join of
     * multiple entities and contains business logic specific     to that joined dataset</li> </ul>
     * <P> Note that <code>beanClassName</code> affects what numeric field types will be used for 
     * inbound DSRequest data. For fields with numeric types, the {@link
     * com.smartgwt.client.data.DSRequest#getData record data}  in DSRequests will automatically be
     * converted to the type of the target field, before the  request is received in a DMI.  For
     * details, see {@link com.smartgwt.client.docs.DsRequestBeanTypes}. <p> Note that {@link
     * com.smartgwt.client.docs.DmiOverview DMI} also has a built-in facility for populating a bean 
     * with the inbound {@link com.smartgwt.client.data.DSRequest#getData DSRequest.data} - just
     * declare the bean as a method argument. <p> <b>For generic DataSources (DataSources with
     * serverType "generic")</b><br> {@link com.smartgwt.client.docs.VisualBuilder Visual Builder}
     * sets this property when it creates a generic  DataSource using the Javabean Wizard.  It has no
     * built-in server-side effects. <p> <b>For Hibernate DataSources (DataSources with serverType
     * "hibernate")</b><br> The name of the Java bean or POJO class that is mapped in Hibernate.  This
     * will typically  be the fully-qualified class name - eg <code>com.foo.MyClass</code> - but it
     * may be the  simple class name - just <code>MyClass</code> - or it may be some other value.  It
     * all  depends on how your classes have been mapped in Hibernate. <p> The declared Java bean will
     * affect how its properties will be mapped to built-in numeric  types, see {@link
     * com.smartgwt.client.docs.HibernateIntegration Hibernate Integration overview} for details. <p>
     * Note:  If you are intending to use Hibernate as a data-access layer only,  you do not need to
     * create Hibernate mappings or Java objects: Smart GWT will generate everything it needs on the
     * fly. <p> <b>For JPA DataSources (DataSources with serverType "jpa" or "jpa1")</b><br> The fully
     * qualified class name of the JPA annotated entity. <p> <b>NOTE for Hibernate and JPA users:</b>
     * When you use JPA, or use Hibernate as a full ORM system (ie, not just allowing Smart GWT Server
     * to drive Hibernate as a data access layer), the beans returned on the server-side are
     * <b>live</b>.  This means that if you make any  changes to them, the ORM system will persist
     * those changes.  This is true even if the beans were created as part of a fetch operation. <p>
     * This causes a problem in the common case where you want to use a DMI or custom DataSource 
     * implementation to apply some post-processing to the beans fetched from the persistent  store. 
     * If you change the values in the beans directly, those changes will be persisted. <p> If you
     * want to alter the data returned from a JPA or Hibernate persistent store as part of a fetch
     * request just so you can alter what gets sent to the client, you can use the  server-side
     * <code>DSResponse</code>'s <code>getRecords()</code> method.  This will return your bean data in
     * "record" format - ie, as a List of Maps.  You can alter these records  without affecting your
     * persistent store, and then call <code>setData()</code> on the  <code>DSResponse</code>),
     * passing the altered list of records.  See the server-side Javadocs for <code>DSResponse</code>
     * for details of these two methods.
     *
     * <p>Default value is null
     * @see com.smartgwt.client.docs.serverds.OperationBinding#beanClassName
     */
    public String beanClassName;

    /**
     * For DataSources with {@link com.smartgwt.client.docs.serverds.DataSource#audit auditing
     * enabled}, optionally specifies the ID of the audit DataSource.  If this property is not
     * specified, the ID of the audit DataSource will be <code>audit_[OriginalDSID] </code>
     *
     * <p>Default value is null
     */
    public String auditDataSourceID;

    /**
     * This property allows you to write and use custom DataSource subclasses on the server, by 
     * specifying either <ul> <li>the fully-qualified name of the DataSource subclass that should be
     * instantiated server-side for this dataSource, or</li> <li>the token "spring:" followed by a
     * valid Spring bean ID, if you wish to instantiate  your custom dataSource object using Spring
     * dependency injection.  For example,  <code>"spring:MyDataSourceBean"</code>.  See also {@link
     * com.smartgwt.client.docs.ServerInit} for special concerns with framework initialization when
     * using Spring.  It is also particularly important that you read the discussion of caching and
     * thread-safety linked to below, as there are  special considerations in this area when using
     * Spring.</li> <li>the token "cdi:" followed by a valid CDI bean name, if you wish to instantiate
     * your custom dataSource object using CDI dependency injection.  For example, 
     * <code>"cdi:MyDataSourceBean"</code>.</li> </ul> <p> One reason you might wish to do this would
     * be to override the validate() method to provide  some arbitrary custom validation (such as
     * complex database lookups, validation embedded in  legacy applications, etc).  It is also
     * possible - though obviously a more substantial task - to override the execute() method in your
     * custom DataSource.  This is one way of creating  a completely customized DataSource
     * implementation. <p> <b>Note:</b> If you use this property, you are responsible for making sure
     * that it refers to a valid server-side class that extends
     * <code>com.isomorphic.datasource.BasicDataSource</code>, or to a Spring bean of the same
     * description. If your implementation relies on methods or state only present in certain
     * specialized  subclasses of DataSource (for example, you want the normal behavior and features
     * of a  HibernateDataSource, but with a specialized validate() method), then you should extend
     * the  subclass rather than the base class. <P> NOTE: Please take note of the points made in 
     * {@link com.smartgwt.client.docs.ServerDataSourceImplementation this discussion} of caching and
     * thread-safety issues in server-side DataSources.
     *
     * <p>Default value is null
     */
    public String serverConstructor;

    /**
     * Indicates the format to be used for HTTP requests and responses when fulfilling DSRequests (eg,
     * when {@link com.smartgwt.client.data.DataSource#fetchData fetchData()} is called).
     *
     * <p>Default value is "iscServer"
     * @see com.smartgwt.client.docs.ServerDataIntegration ServerDataIntegration overview and related methods
     */
    public DSDataFormat dataFormat;

    /**
     * Allows you to specify an arbitrary suffix string to apply to all json format responses  sent
     * from the server to this application. <P> The inclusion of such a suffix ensures your code is
     * not directly executable outside of your application, as a preventative measure against <a
     * href='http://www.google.com/search?q=javascript+hijacking' target='_blank'>javascript
     * hijacking</a>. <P> Only applies to responses formatted as json objects. Does not apply to
     * responses returned via scriptInclude type transport.
     *
     * <p>Default value is null
     * @see com.smartgwt.client.data.OperationBinding#getDataFormat
     * @see com.smartgwt.client.data.OperationBinding#getDataTransport
     */
    public String jsonSuffix;

    /**
     * For fields of {@link com.smartgwt.client.docs.serverds.DataSourceField#type type} "sequence" in
     * a dataSource of 
     * {@link com.smartgwt.client.docs.serverds.DataSource#serverType serverType} "sql", indicates the
     * 
     * {@link com.smartgwt.client.types.SequenceMode} to use.  This property has no effect for fields
     * or dataSources of 
     *  other types.
     *  <p>
     *  You can set a default sequenceMode for all DataSources of a given database type by setting
     *  property "sql.{database_type}.default.sequence.mode" in <code>server.properties</code>.  
     *  You set a global default sequenceMode that applies to all database types by setting property
     *  "sql.default.sequence.mode".  For example:<pre>
     *    sql.mysql.default.sequence.mode: jdbcDriver
     *  </pre>
     *  <P>
     *
     * <p>Default value is "native"
     */
    public SequenceMode sequenceMode;

    /**
     * Best field to use for a user-visible title for an individual record from this dataSource. <p>
     * For example, for a DataSource of employees, a "full name" field would probably most clearly
     * label an employee record. <p> If not explicitly set, titleField looks for fields named "title",
     * "label", "name", and "id" in that order.  If a field exists with one of those names, it becomes
     * the titleField.  If not, then the first field is designated as the titleField.
     *
     * <p>Default value is see below
     * @see com.smartgwt.client.docs.DsSpecialFields DsSpecialFields overview and related methods
     */
    public String titleField;

    /**
     * The paging strategy to use for this DataSource.  If this property is not set, the  default
     * paging strategy, specified with the {@link com.smartgwt.client.docs.Server_properties
     * server.properties} setting <code>sql.defaultPaging</code>, is used.   <p> This setting can be
     * overridden with the {@link com.smartgwt.client.docs.serverds.OperationBinding#sqlPaging
     * OperationBinding.sqlPaging} property. <P> <b>NOTE:</b> Operations that involve a {@link
     * com.smartgwt.client.data.OperationBinding#getCustomSQL customSQL}  clause ignore this property,
     * because customSQL operations usually need to be treated as special cases.  For these
     * operations, the paging strategy comes from the  {@link
     * com.smartgwt.client.docs.Server_properties server.properties} setting
     * <code>sql.defaultCustomSQLPaging</code> or  <code>sql.defaultCustomSQLProgressivePaging</code>,
     * depending on whether or not  {@link
     * com.smartgwt.client.docs.serverds.DataSource#progressiveLoading progressiveLoading} is in
     * force.  Note that these can always be overridden by a <code>sqlPaging</code> setting on the
     * OperationBinding.
     *
     * <p>Default value is null
     * @see com.smartgwt.client.docs.serverds.OperationBinding#sqlPaging
     */
    public SQLPagingStrategy sqlPaging;

    /**
     * Default scriptlet to be executed on the server for each operation. If {@link
     * com.smartgwt.client.docs.serverds.OperationBinding#script OperationBinding.script} is
     * specified, it will be executed for the operation binding in question instead of running this
     * scriptlet.
     *  <P>
     * Scriptlets are used similarly to DMIs configured via {@link
     * com.smartgwt.client.docs.serverds.DataSource#serverObject serverObject} or
     * {@link com.smartgwt.client.docs.serverds.OperationBinding#serverObject
     * OperationBinding.serverObject} -
     *  they can add business logic by modifying the DSRequest before it's executed, modifying the
     *  default DSResponse, or taking other, unrelated actions.  
     *  <P>
     *  For example:
     *  <pre>
     *     &lt;DataSource&gt;
     *        &lt;script language="groovy"&gt;
     *           ... Groovy code ...
     *        &lt;/script&gt;
     *       ... other DataSource properties
     *     &lt;/DataSource&gt;
     *  </pre>
     *  <P>
     *  Scriptlets can be written in any language supported by the "JSR 223" standard, including Java
     * itself.  See the {@link com.smartgwt.client.docs.DmiOverview DMI Script Overview} for rules on
     * how to return data,
     *  add additional imports, and other settings.
     *  <P>
     *  The following variables are available for DMI scriptlets:
     *  <ul>
     *  <li><i>requestContext</i>: RequestContext (from com.isomorphic.servlet)
     *  <li><i>dataSource</i>: the current DataSource (same as DSRequest.getDataSource())
     *  <li><i>dsRequest</i>: the current DSRequest
     *  <li><i>criteria</i>: shortcut to DSRequest.getCriteria() (a Map)
     *  <li><i>values</i>: shortcut to DSRequest.getValues() (a Map)
     *  <li><i>oldValues</i>: shortcut to DSRequest.getOldValues() (a Map)
     *  <li><i>sqlConnection</i>: <b>SQLDataSource only</b>: the current SQLConnection object.  If
     * using {@link com.smartgwt.client.data.DataSource#getAutoJoinTransactions automatic
     * transactions} are enabled, this
     *  SQLConnection is in the context of the current transaction.
     *  <li><i>rpcManager</i>: the current RPCManager
     *  <li><i>applicationContext</i>: the Spring ApplicationContext (when applicable)
     *  <li><i>beanFactory</i>: the Spring BeanFactory (when applicable)
     *  </ul>
     *  <P>
     *  Scriptlets also have access to a set of contextual variables related to the Servlets
     *  API, as follows:
     *  <ul>
     *  <li><i>servletRequest</i>: the current ServletRequest
     *  <li><i>session</i>: the current HttpSession
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
     * The native field name used by this DataSource on the server to represent the
     * <code>fileName</code> for {@link com.smartgwt.client.docs.FileSource FileSource Operations}
     * operations. Any extensions to the fileName to indicate type or format (e.g. ".ds.xml") are
     * stored in the {@link com.smartgwt.client.docs.serverds.DataSource#fileTypeField fileTypeField}
     * and {@link com.smartgwt.client.docs.serverds.DataSource#fileFormatField fileFormatField}, if
     * specified for this DataSource. <p>If not specified for a DataSource, the fileNameField will be
     * inferred on the server as follows: <ul> <!-- <li>f the {@link
     * com.smartgwt.client.docs.serverds.DataSource#fileContentsField fileContentsField} is binary,
     * then we use     the filename field which corresponds to the binary field,     if it exists.
     * TODO: Not implemented yet.</li> --> <li>If there is a field named "fileName", "name", or
     * "title",     then that field is used.</li> <li>Otherwise, if there is a single primary key, and
     * it has the type "text",     then that field is used.</li> <li>Otherwise, an error is
     * logged</li> </ul>
     *
     * <p>Default value is null
     * @see com.smartgwt.client.docs.FileSource FileSource overview and related methods
     */
    public String fileNameField;

    /**
     * Indicates that declarative security rules are waived for rows that were created by the  current
     * user.  Practically, this means that when a security check fails, instead of a  security
     * exception being thrown, we alter the criteria to ensure that the request can  only return or
     * affect rows that were created by the current authenticated user.  This  allows you to create
     * security regimes whereby users can see and edit data they created,  but have access to other
     * users' data forbidden or limited. <p> In order for this to work, we require two things:<ul>
     * <li>The DataSource must specify a field of type "creator" - this field type is described     
     * on {@link com.smartgwt.client.types.FieldType this page}</li> <li>The authentication regime in
     * use must include the idea of a "current user".  The      authentication provided by the Servlet
     * API is an example of such a regime.</li> </ul> This setting can be overridden at
     * operationBinding and field level, allowing extremely fine-grained control.
     *
     * <p>Default value is null
     * @see com.smartgwt.client.docs.serverds.OperationBinding#creatorOverrides
     * @see com.smartgwt.client.docs.serverds.DataSourceField#creatorOverrides
     * @see com.smartgwt.client.docs.FieldLevelAuth FieldLevelAuth overview and related methods
     */
    public Boolean creatorOverrides;

    /**
     * Class for ResultSets used by this datasource.  If null, defaults to using {@link
     * com.smartgwt.client.data.ResultSet}. <P> This can be set to a custom subclass of ResultSet
     * that, for example, hangs onto to extra information necessary for integration with web services.
     *
     * <p>Default value is null
     */
    public Map resultSetClass;

    /**
     * For DataSources with {@link com.smartgwt.client.docs.serverds.DataSource#audit auditing
     * enabled}, specifies the field name used to store the user who performed the operation.  If
     * empty string is specified as the field name, the audit DataSource will not store this field.
     *
     * <p>Default value is "audit_modifier"
     */
    public String auditUserFieldName;

    /**
     * Optional array of OperationBindings, which provide instructions to the DataSource about how
     * each
     *  DSOperation is to be performed.
     *  <P>
     *  When using the Smart GWT Server, OperationBindings are specified in your DataSource
     *  descriptor (.ds.xml file) and control server-side behavior such as what Java object to route
     * DSRequest to ({@link com.smartgwt.client.docs.serverds.OperationBinding#serverObject
     * OperationBinding.serverObject}) or customizations to SQL, JQL and HQL queries
     * ({@link com.smartgwt.client.data.OperationBinding#getCustomSQL OperationBinding.customSQL},
     * {@link com.smartgwt.client.data.OperationBinding#getCustomJQL OperationBinding.customJQL} and
     * {@link com.smartgwt.client.data.OperationBinding#getCustomHQL OperationBinding.customHQL}).
     * See the @see <a href="http://www.smartclient.com/smartgwtee/showcase/#javaDataIntegration"
     * target="examples">Java Integration samples</a>.
     *  <P>
     *  For DataSources bound to WSDL-described web services using
     * {@link com.smartgwt.client.docs.serverds.DataSource#serviceNamespace serviceNamespace},
     * OperationBindings are used to bind each DataSource
     *  {@link com.smartgwt.client.docs.serverds.OperationBinding#operationType operationType} to an
     * {@link com.smartgwt.client.data.OperationBinding#getWsOperation operation} of a WSDL-described 
     * {@link com.smartgwt.client.data.WebService web service}, so that a DataSource can both fetch
     * and save data to a web
     *  service.
     *  <P>
     *  For example, this code accomplishes part of the binding to the 
     * <a href='http://www.google.com/search?q=sforce+partner+wsdl' target='_blank'>SalesForce partner
     * web services</a>
     *  
     *  
     *  <pre>
     *       DataSource dataSource = new DataSource();
     *       dataSource.setServiceNamespace("urn:partner.soap.sforce.com");
     *       OperationBinding fetch = new OperationBinding();
     *       fetch.setOperationType(DSOperationType.FETCH);
     *       fetch.setWsOperation("query");
     *       fetch.setRecordName("sObject");
     *       OperationBinding add = new OperationBinding();
     *       add.setOperationType(DSOperationType.ADD);
     *       add.setWsOperation("create");
     *       add.setRecordName("SaveResult");
     *       OperationBinding update = new OperationBinding();
     *       update.setOperationType(DSOperationType.UPDATE);
     *       update.setWsOperation("update");
     *       update.setRecordName("SaveResult");
     *       OperationBinding remove = new OperationBinding();
     *       remove.setOperationType(DSOperationType.REMOVE);
     *       remove.setWsOperation("delete");
     *       remove.setRecordName("DeleteResult");
     *       dataSource.setOperationBindings(fetch, add, update, remove);
     *  </pre>
     *  
     *  NOTE: additional code is required to handle authentication and other details, see the
     *  complete code in smartclientSDK/examples/databinding/SalesForce.
     *  <P>
     *  For DataSources that contact non-WSDL-described XML or JSON services, OperationBindings can
     *  be used to separately configure the URL, HTTP method, input and output processing for each
     *  operationType.  This makes it possible to fetch JSON data from one URL for the "fetch"
     *  operationType and save to a web service for the "update" operationType, while appearing as a
     * single integrated DataSource to a {@link com.smartgwt.client.widgets.DataBoundComponent} such
     * as an
     *  {@link com.smartgwt.client.widgets.grid.ListGrid#getCanEdit editable ListGrid}.
     *  <P>
     *  If no operationBinding is defined for a given DataSource operation, all of the properties
     *  which are valid on the operationBinding are checked for on the DataSource itself.  
     *  <P>
     *  This also means that for a read-only DataSource, that is, a DataSource only capable of fetch
     *  operations, operationBindings need not be specified, and instead all operationBinding
     * properties can be set on the DataSource itself. In the <a
     * href="http://www.smartclient.com/smartgwtee/showcase/#data_integration_server_rss"
     * target="examples">RSS Feed</a>
     *  sample, you can see an example of using OperationBinding properties directly on the 
     *  DataSource in order to read an RSS feed.
     *
     * <p>Default value is null
     * @see com.smartgwt.client.data.OperationBinding
     */
    public OperationBinding[] operationBindings;

    /**
     * The native field name used by this DataSource on the server to represent the
     * <code>fileType</code> for {@link com.smartgwt.client.docs.FileSource FileSource Operations}. 
     * <p>If the fileTypeField is not configured, then a field named "fileType" will be used, if it
     * exists. Otherwise, the DataSource will not track fileTypes -- this may be acceptable if, for
     * instance, you use a separate DataSource for each fileType. <p>The fileType is specified
     * according to the extension that would have been used in the filesystem -- for instance, the
     * fileType for employees.ds.xml would be "ds".
     *
     * <p>Default value is null
     * @see com.smartgwt.client.docs.FileSource FileSource overview and related methods
     */
    public String fileTypeField;

    /**
     * Designates a field of {@link com.smartgwt.client.types.FieldType type}:"image" as the field to
     * use when rendering a record as an image, for example, in a {@link
     * com.smartgwt.client.widgets.tile.TileGrid}. <p> For example, for a DataSource of employees, a
     * "photo" field of type "image" should be designated as the iconField. <p> If not explicitly set,
     * iconField looks for fields named "picture", "thumbnail", "icon", "image" and "img", in that
     * order, and will use any of these fields as the iconField if it exists and has type "image". 
     * <P> To avoid any field being used as the iconField, set iconField to <code>null</code>.
     *
     * <p>Default value is see below
     * @see com.smartgwt.client.docs.DsSpecialFields DsSpecialFields overview and related methods
     */
    public String iconField;

    /**
     * Like {@link com.smartgwt.client.widgets.DataBoundComponent#getUseFlatFields
     * DataBoundComponent.useFlatFields}, but applies to all DataBound components that bind to this
     * DataSource.
     *
     * <p>Default value is null
     */
    public Boolean useFlatFields;

    /**
     * Name of the field that has the second most pertinent piece of textual information in the
     * record, for use when a {@link com.smartgwt.client.widgets.DataBoundComponent} needs to show a
     * short summary of a record. <p> For example, for a DataSource of employees, a "job title" field
     * would probably be the second most pertinent text field aside from the employee's "full name".
     * <p> Unlike {@link com.smartgwt.client.docs.serverds.DataSource#titleField titleField},
     * infoField is not automatically determined in the absence of an explicit setting.
     *
     * <p>Default value is null
     * @see com.smartgwt.client.docs.DsSpecialFields DsSpecialFields overview and related methods
     */
    public String infoField;

    /**
     * Sets the XML namespace prefixes available for XPaths on a DataSource-wide basied.  See {@link
     * com.smartgwt.client.docs.serverds.OperationBinding#xmlNamespaces
     * OperationBinding.xmlNamespaces} for details.
     *
     * <p>Default value is See below
     * @see com.smartgwt.client.docs.ClientDataIntegration ClientDataIntegration overview and related methods
     */
    public Map xmlNamespaces;

    /**
     * Indicates that the specified {@link com.smartgwt.client.docs.VelocityExpression} must evaluate
     * to true for a user  to access this DataSource. <P> See also {@link
     * com.smartgwt.client.docs.serverds.OperationBinding#requires OperationBinding.requires}.
     *
     * <p>Default value is null
     * @see com.smartgwt.client.docs.DeclarativeSecurity DeclarativeSecurity overview and related methods
     */
    public VelocityExpression requires;

    /**
     * Unique identifier for this DataSource.  Required for all DataSources.
     *
     * <p>Default value is null
     */
    public String ID;

    /**
     * If {@link com.smartgwt.client.docs.serverds.DataSource#fileVersionField automatic file
     * versioning} is enabled for a FileSource DataSource, this property configures the maximum number
     * of versions to retain.
     *
     * <p>Default value is 20
     * @see com.smartgwt.client.docs.serverds.DataSource#fileVersionField
     * @see com.smartgwt.client.docs.FileSource FileSource overview and related methods
     */
    public Integer maxFileVersions;

    /**
     * Tag name to use when serializing to XML.  If unspecified, the <code>dataSource.ID</code> will
     * be used.
     *
     * <p>Default value is null
     * @see com.smartgwt.client.docs.ClientDataIntegration ClientDataIntegration overview and related methods
     */
    public String tagName;

    /**
     * For an {@link com.smartgwt.client.docs.serverds.DataSource#audit audited} DataSource, controls
     * whether the Framework will attempt to auto-generate the audit DataSource.  Note that this
     * property is independent of {@link
     * com.smartgwt.client.docs.serverds.DataSource#auditDataSourceID auditDataSourceID} so that, by
     * default, even when the audit DataSource is given a non-default ID, the Framework will still
     * attempt to auto-generate it.
     *
     * <p>Default value is true
     */
    public boolean generateAuditDS;

    /**
     * The list of fields that compose records from this DataSource. <P> Each DataSource field can
     * have type, user-visible title, validators, and other metadata attached.
     *
     * <p>Default value is null
     * @see com.smartgwt.client.data.DataSourceField
     */
    public DataSourceField[] fields;

    /**
     * If we are {@link com.smartgwt.client.docs.serverds.DataSource#progressiveLoading loading
     * progressively}, indicates the number of  extra records Smart GWT Server will advertise as being
     * available, if it detects that  there are more records to view (see {@link
     * com.smartgwt.client.docs.serverds.DataSource#lookAhead lookAhead}).  This property has no 
     * effect if we are not progressive-loading.
     *
     * <p>Default value is 20
     * @see com.smartgwt.client.docs.serverds.DataSource#progressiveLoading
     * @see com.smartgwt.client.docs.serverds.DataSource#lookAhead
     * @see com.smartgwt.client.docs.ProgressiveLoading ProgressiveLoading overview and related methods
     */
    public int endGap;

    /**
     * When true, and {@link com.smartgwt.client.docs.serverds.DataSource#noNullUpdates noNullUpdates}
     * is also true, indicates that "add"  requests on this DataSource will have null-valued fields
     * removed from the request  entirely before it is sent to the server, as opposed to the default
     * behavior of  replacing such null values with defaults.
     *
     * <p>Default value is false
     * @see com.smartgwt.client.docs.serverds.DataSource#noNullUpdates
     */
    public boolean omitNullDefaultsOnAdd;

    /**
     * If {@link com.smartgwt.client.docs.serverds.DataSource#noNullUpdates noNullUpdates} is set, the
     * value to use for any text field that has a null value assigned on an update operation, and does
     * not specify an explicit {@link
     * com.smartgwt.client.docs.serverds.DataSourceField#nullReplacementValue nullReplacementValue}.
     *
     * <p>Default value is ""
     * @see com.smartgwt.client.docs.serverds.DataSource#noNullUpdates
     * @see com.smartgwt.client.docs.serverds.DataSourceField#nullReplacementValue
     */
    public String nullStringValue;

    /**
     * Whether we store server responses for this DataSource into  {@link
     * com.smartgwt.client.util.Offline browser-based offline storage}, and then use those stored
     * responses at a later time if we are offline (ie, the application cannot connect to the server).
     *   Note that by default we do NOT use offline storage for a dataSource.
     *
     * <p>Default value is null
     */
    public Boolean useOfflineStorage;

    /**
     * If a {@link com.smartgwt.client.data.DSRequest} arrives from the client that requests {@link
     * com.smartgwt.client.docs.ServerSummaries server-calculated summaries}, should it be allowed?
     * <p> Note this setting <b>only</b> affects <code>dsRequests</code> that come from the browser
     * (or another client).  This setting has no effect on server summaries declared in .ds.xml files
     * or summaries configured in DSRequests created programmatically on the server side, which are
     * always allowed. <p> Default value of null means this DataSource will use the system-wide
     * default, which is set via <code>datasources.allowClientRequestedSummaries</code> in {@link
     * com.smartgwt.client.docs.Server_properties server.properties}, and defaults to allowing
     * client-requested summaries. <p> If client-requested summarization is allowed, but the
     * server-side &lt;operationBinding&gt; provides specific summarization settings, the
     * client-requested summarization is ignored.
     *
     * <p>Default value is null
     * @see com.smartgwt.client.docs.serverds.DataSourceField#allowClientRequestedSummaries
     * @see com.smartgwt.client.docs.ServerSummaries ServerSummaries overview and related methods
     */
    public Boolean allowClientRequestedSummaries;

    /**
     * For DataSources with type {@link com.smartgwt.client.types.DSServerType
     * <code>projectFile</code>}, looks up the locations to use as {@link
     * com.smartgwt.client.docs.serverds.DataSource#projectFileLocations projectFileLocations} from
     * the project's configuration (i.e. project.properties, {@link
     * com.smartgwt.client.docs.Server_properties server.properties} etc.). <p>For instance, to look
     * up the value of project.datasources and use it for <code>projectFileLocations</code>, use
     * "datasources" as the  <code>projectFileKey</code>. <p>If you specify both
     * <code>projectFileKey</code> and  <code>projectFileLocations</code>, then both with be used,
     * with the <code>projectFileLocations</code> applied last.
     *
     * <p>Default value is null
     * @see com.smartgwt.client.docs.serverds.DataSource#projectFileLocations
     * @see com.smartgwt.client.docs.FileSource FileSource overview and related methods
     */
    public String projectFileKey;

    /**
     * Whether to attempt validation on the client at all for this DataSource.  If unset (the
     * default), client-side validation is enabled. <p> Disabling client-side validation entirely is a
     * good way to test server-side validation.
     *
     * <p>Default value is null
     * @see com.smartgwt.client.docs.Validation Validation overview and related methods
     */
    public Boolean useLocalValidators;

    /**
     * Sets the strategy this DataSource uses to translate Java enumerated types (objects of type
     * enum) to and from Javascript.  This property is only applicable if you are using the Smart GWT
     * server
     *
     * <p>Default value is null
     */
    public EnumTranslateStrategy enumTranslateStrategy;

    /**
     * A clientOnly DataSource simulates the behavior of a remote data store by manipulating a static
     * dataset in memory as {@link com.smartgwt.client.data.DSRequest DSRequests} are executed on it. 
     * Any changes are lost when the user reloads the page or navigates away. <P> A clientOnly
     * DataSource will return responses asynchronously, just as a DataSource accessing remote data
     * does.  This allows a clientOnly DataSource to be used as a temporary placeholder while a real
     * DataSource is being implemented - if a clientOnly DataSource is replaced by a DataSource that
     * accesses a remote data store, UI code for components that used the clientOnly DataSource will
     * not need be changed. <P> A clientOnly DataSource can also be used as a shared cache of
     * modifiable data across multiple UI components when immediate saving is not desirable.  In this
     * case, several components may interact with a clientOnly DataSource and get the benefit of
     * {@link com.smartgwt.client.data.ResultSet} behaviors such as automatic cache sync and
     * in-browser data filtering and sorting.  When it's finally time to save, {@link
     * com.smartgwt.client.data.DataSource#getCacheData cacheData} can be inspected for changes and
     * data can be saved to the original DataSource via {@link
     * com.smartgwt.client.data.DataSource#addData addData()}, {@link
     * com.smartgwt.client.data.DataSource#updateData updateData()} and {@link
     * com.smartgwt.client.data.DataSource#removeData removeData()}, possibly in a {@link
     * com.smartgwt.client.rpc.RPCManager#startQueue transactional queue}.  Note that {@link
     * com.smartgwt.client.data.DataSource#getClientOnlyDataSource getClientOnlyDataSource()} lets you
     * easily obtain a <code>clientOnly</code> DataSource representing a subset of the data available
     * from a normal DataSource.   <P> See also {@link
     * com.smartgwt.client.data.DataSource#getCacheAllData cacheAllData} - a <code>cacheAllData</code>
     * behaves like a write-through cache, performing fetch and filter operations locally while still
     * performing remote save operations immediately. <P> ClientOnly DataSources can be populated
     * programmatically via {@link com.smartgwt.client.data.DataSource#getCacheData cacheData} - see
     * {@link com.smartgwt.client.docs.ClientOnlyDataSources this discussion} for other ways to
     * populate a client-only DataSource with data.
     *
     * <p>Default value is false
     * @see com.smartgwt.client.docs.ClientOnlyDataSources ClientOnlyDataSources overview and related methods
     */
    public Boolean clientOnly;

    /**
     * For {@link com.smartgwt.client.docs.serverds.DataSource#serverType serverType:"sql"}
     * DataSources, sets the default {@link
     * com.smartgwt.client.data.DataSourceField#getSqlStorageStrategy sqlStorageStrategy} to use for
     * boolean fields where no <code>sqlStorageStrategy</code> has been declared on the field. <P> Can
     * also be set system-wide via the {@link com.smartgwt.client.docs.Server_properties} setting
     * <code>sql.defaultBooleanStorageStrategy</code>, or for a particular database configuration by
     * setting <code>sql.<i>dbName</i>.defaultBooleanStorageStrategy</code> (see {@link
     * com.smartgwt.client.docs.AdminConsole Admin Console overview} for more information on SQL
     * configuration). <p> Note that when this property is unset, the default {@link
     * com.smartgwt.client.data.DataSourceField#getSqlStorageStrategy
     * DataSourceField.sqlStorageStrategy} strategy is effectively "string".
     *
     * <p>Default value is null
     * @see com.smartgwt.client.docs.ServerDataIntegration ServerDataIntegration overview and related methods
     */
    public String defaultBooleanStorageStrategy;

    /**
     * Controls when primary keys are required for "update" and "remove" server operations, when
     * allowMultiUpdate  has not been explicitly configured on either the {@link
     * com.smartgwt.client.docs.serverds.OperationBinding#allowMultiUpdate
     * operationBinding.allowMultiUpdate} or via the server-side API
     * <code>DSRequest.setAllowMultiUpdate()</code>. <p> Default value of null means this DataSource
     * will use the system-wide default, which is set via
     * <code>datasources.defaultMultiUpdatePolicy</code> in {@link
     * com.smartgwt.client.docs.Server_properties server.properties}, and defaults to not allowing
     * multi updates for  requests associated with an RPCManager, see {@link
     * com.smartgwt.client.types.MultiUpdatePolicy} for details.
     *
     * <p>Default value is null
     * @see com.smartgwt.client.docs.serverds.OperationBinding#allowMultiUpdate
     */
    public MultiUpdatePolicy defaultMultiUpdatePolicy;

    /**
     * For fields on this dataSource that specify  {@link
     * com.smartgwt.client.docs.serverds.DataSourceField#ignoreTextMatchStyle ignoreTextMatchStyle}
     * true, the prevailing textMatchStyle is ignored and Smart GWT matches exact values.  This
     * property dictates whether that match is case-sensitive like the "exactCase" textMatchStyle, or 
     * case-insensitive like the "exact" textMatchStyle (the default).  Please see the  {@link
     * com.smartgwt.client.types.TextMatchStyle TextMatchStyle documentation} for a discussion of the
     * nuances of case-sensitive matching.
     *
     * <p>Default value is false
     */
    public Boolean ignoreTextMatchStyleCaseSensitive;

    /**
     * For a DataSource that inherits {@link com.smartgwt.client.docs.serverds.DataSource#fields
     * fields} from another DataSource  (via {@link
     * com.smartgwt.client.docs.serverds.DataSource#inheritsFrom inheritsFrom}), indicates that the
     * parent's field order should be used instead of the order of the fields as declared in this
     * DataSource.  New fields, if any, are placed at the end.
     *
     * <p>Default value is null
     */
    public Boolean useParentFieldOrder;

    /**
     * For JPA and Hibernate DataSources this property indicates, that data source has composite
     * primary key and specifies fully-qualified Java class:<ul> <li>with
     * <b><code>@EmbeddedId</code></b> you have to specify class name of declared id</li> <li>with
     * <b><code>@IdClass</code></b> you have to specify class specified in annotation
     * declaration</li></ul>
     *
     * <p>Default value is null
     */
    public String idClassName;

    /**
     * For DataSources with {@link com.smartgwt.client.docs.serverds.DataSource#audit auditing
     * enabled}, specifies the field name used to store the names of the fields which were updated. 
     * If empty string is specified as the field name, the audit DataSource will not store this field.
     * <P> Note that this field will only be set for {@link com.smartgwt.client.types.DSOperationType
     * update} operations.
     *
     * <p>Default value is "audit_changedFields"
     */
    public String auditChangedFieldsFieldName;

    /**
     * Decides under what conditions the {@link com.smartgwt.client.data.ResultSet} cache should be
     * dropped when the {@link com.smartgwt.client.data.ResultSet#getCriteria ResultSet.criteria}
     * changes.
     *
     * <p>Default value is "dropOnShortening"
     * @see com.smartgwt.client.data.DataSource#compareCriteria
     */
    public CriteriaPolicy criteriaPolicy;

    /**
     * Applies only to dataFormat: "json" and {@link
     * com.smartgwt.client.docs.serverds.DataSource#dataTransport dataTransport}:"scriptInclude". 
     * Specifies the name of the query parameter that tells your JSON service what function to call as
     * part of the response.
     *
     * <p>Default value is "callback"
     * @see com.smartgwt.client.docs.serverds.DataSource#dataFormat
     * @see com.smartgwt.client.docs.serverds.DataSource#operationBindings
     * @see com.smartgwt.client.docs.serverds.OperationBinding#callbackParam
     * @see com.smartgwt.client.docs.ClientDataIntegration ClientDataIntegration overview and related methods
     */
    public String callbackParam;

    /**
     * For DataSources with {@link com.smartgwt.client.docs.serverds.DataSource#audit auditing
     * enabled}, specifies the field name used to store the timestamp when the operation was performed
     * (in a field of type "datetime").  If empty string is specified as the field name, the audit
     * DataSource will not store this field.
     *
     * <p>Default value is "audit_changeTime"
     */
    public String auditTimeStampFieldName;

    /**
     * When {@link com.smartgwt.client.data.DataSource#getMockMode mockMode} is enabled, criteria to
     * use in an initial "fetch" DSRequest to retrieve sample data.
     *
     * <p>Default value is null
     */
    public Criteria mockDataCriteria;

    /**
     * Indicates the dataset size that will cause Smart GWT Server to automatically switch into {@link
     * com.smartgwt.client.docs.serverds.DataSource#progressiveLoading progressive loading mode} for
     * this DataSource. To prevent automatic switching to progressive loading, set this property to
     * -1. This may also be prevented on a per-request basis by setting {@link
     * com.smartgwt.client.data.DSRequest#getProgressiveLoading DSRequest.progressiveLoading} to
     * <code>false</code>.
     *
     * <p>Default value is 200000
     * @see com.smartgwt.client.docs.serverds.DataSource#progressiveLoading
     * @see com.smartgwt.client.data.DSRequest#getProgressiveLoading
     * @see com.smartgwt.client.docs.ProgressiveLoading ProgressiveLoading overview and related methods
     */
    public int progressiveLoadingThreshold;

    /**
     * For a DataSource that inherits {@link com.smartgwt.client.docs.serverds.DataSource#fields
     * fields} from another DataSource  (via {@link
     * com.smartgwt.client.docs.serverds.DataSource#inheritsFrom inheritsFrom}), indicates that only
     * the fields listed in this DataSource should be shown.  All other inherited parent fields will
     * be marked "hidden:true".
     *
     * <p>Default value is null
     */
    public Boolean showLocalFieldsOnly;

    /**
     * This property allows you to specify that your DataSource's schema (field definitions) should
     *  be automatically derived from some kind of metadata.  This causes Smart GWT to create 
     *  a special super-DataSource, which is used purely as a source of default schema for this 
     *  DataSource; this is arranged by causing the autoDerived DataSource to automatically 
     * {@link com.smartgwt.client.docs.serverds.DataSource#inheritsFrom inherit from} the special
     * super-DataSource.  This allows you to 
     *  auto-derive schema from existing metadata, whilst still being able to override any or all
     *  of it as required.<p>
     *  This property has a different implementation depending upon the 
     * {@link com.smartgwt.client.docs.serverds.DataSource#serverType serverType} of the
     * DataSource:<ul>
     *  <li>For a DataSource with serverType: "sql", automatically derive the dataSource's schema 
     * from the Spring bean or Java class specified in {@link
     * com.smartgwt.client.docs.serverds.DataSource#schemaBean schemaBean}.  If 
     *  <code>schemaBean</code> is not specified, derive the schema from the columns in the SQL 
     * table specified in {@link com.smartgwt.client.docs.serverds.DataSource#tableName tableName}. 
     * More information on SQL DataSources 
     *  is {@link com.smartgwt.client.docs.SqlDataSource here}</li>  
     *  <li>For a DataSource with serverType: "hibernate", automatically derive the dataSource's
     *  schema from the Spring bean, Hibernate mapping or Java class named in the 
     * {@link com.smartgwt.client.docs.serverds.DataSource#schemaBean schemaBean} property.  If no
     * such thing exists, derive the schema from
     * the Hibernate mapping or Java class specified in the {@link
     * com.smartgwt.client.docs.serverds.DataSource#beanClassName beanClassName}
     *  property (this allows you to specify schema and mapping separately, in the unusual 
     *  circumstance that you have a need to do so).  Note that the "mappings" referred to here
     *  can mean either <code>.hbm.xml</code> files or annotated classes; both are supported.
     *  If neither of these is successful, derive the schema from the underlying SQL table 
     * specified in {@link com.smartgwt.client.docs.serverds.DataSource#tableName tableName}.  More
     * information on Hibernate DataSources is
     *  {@link com.smartgwt.client.docs.HibernateIntegration here}</li>  
     *  <li>For a DataSource with serverType: "jpa1" or "jpa", automatically derive the 
     * dataSource's schema from the annotated JPA class named in the {@link
     * com.smartgwt.client.docs.serverds.DataSource#schemaBean schemaBean} 
     *  property.  If the schemaBean property is not defined, derive the schema from the 
     * annotated JPA class named in the {@link
     * com.smartgwt.client.docs.serverds.DataSource#beanClassName beanClassName} property (as with 
     *  Hibernate, this allows you to specify schema and mapping separately if you need to do 
     *  so).  JPA DataSource generation relies on annotations (the orm.xml mapping file is not 
     * supported).  More information on JPA DataSources is {@link
     * com.smartgwt.client.docs.JpaIntegration here}</li>  
     *  <li>For other DataSource types, attempt to find a Spring bean with the name specified in
     * the {@link com.smartgwt.client.docs.serverds.DataSource#schemaBean schemaBean} property.  If no
     * such bean is found (or Spring is not 
     *  present), attempt to instantiate an object whose fully-qualified class name is the value
     *  in the <code>schemaBean</code> property.  If one of these approaches succeeds, we derive
     *  the schema from the discovered object (by treating it as a Java Bean and assuming that 
     *  each one of its getters corresponds to a like-named field in the DataSource).  More 
     * information on custom DataSource implementations is {@link
     * com.smartgwt.client.docs.WriteCustomDataSource here}.</li>
     *  </ul>
     *  Note that when dataSource schema is derived by introspecting the Java class or Spring bean the
     *  order of derived fields is non-deterministic, so you may find that it changes if you switch
     * JVMs, Java compilers or other parts of your Java toolchain. This means that you need to include
     *  the order of all fields that are ultimately client-visible.  Otherwise, if you bind a ListGrid
     *  or DynamicForm to this DataSource without specifying the order of fields in that grid or form,
     *  you could get fields in a different order on each application restart.
     *  <h4>Field types</h4>
     *  The following table shows how SQL types are derived into 
     * {@link com.smartgwt.client.types.FieldType DataSource types} when we use an SQL table as a
     * source of metadata
     *  for a SQL or Hibernate DataSource:
     *  <table border="1" class="normal">
     * <tr><th>SQL type</th><th>{@link com.smartgwt.client.docs.serverds.DataSourceField#type
     * DataSource type}</th></tr>
     *  <tr><td>CHAR, VARCHAR, LONGVARCHAR, TEXT, CLOB</td><td>text</td></tr>
     * <tr><td>BIT, TINYINT, SMALLINT, INTEGER, BIGINT, DECIMAL<sup>*</sup>,
     * NUMBER<sup>**</sup></td><td>integer</td></tr>
     *  <tr><td>REAL, FLOAT, DOUBLE, DECIMAL<sup>*</sup>, NUMBER<sup>**</sup></td><td>float</td></tr>
     *  <tr><td>DATE</td><td>date</td></tr>
     *  <tr><td>TIME</td><td>time</td></tr>
     *  <tr><td>TIMESTAMP</td><td>datetime</td></tr>
     *  <tr><td>BLOB, BINARY, VARBINARY, LONGVARBINARY</td><td>binary</td></tr>
     *  </table>
     *  <sup>*</sup>For DECIMAL types, we inspect the "DECIMAL_DIGITS" attribute of the JDBC 
     *  metadata and designate the field type "integer" if that attribute is 0, or "float" if
     *  it is some other value.<br>
     *  <sup>**</sup>NUMBER is an Oracle-only type that appears in the JDBC metadata as DECIMAL
     *  and is handled exactly the same way as DECIMAL
     *  <p>
     *  The following table shows how Java types are derived into DataSource types when we use
     *  an unannotated Java class (Spring bean, Hibernate mapping or POJO) as a source of 
     *  metadata for a SQL, Hibernate or custom DataSource:
     *  <table border="1" class="normal">
     * <tr><th>Java type</th><th>{@link com.smartgwt.client.docs.serverds.DataSourceField#type
     * DataSource type}</th></tr>
     *  <tr><td>boolean, Boolean</td><td>boolean</td></tr>
     *  <tr><td>char, Character, String, Reader</td><td>text</td></tr>
     * <tr><td>byte, short, int, long, Byte, Short, Integer, Long,
     * BigInteger</td><td>integer</td></tr>
     *  <tr><td>float, double, Float, Double, BigDecimal</td><td>float</td></tr>
     *  <tr><td>Enum</td><td>enum (see discussion below)</td></tr>
     *  <tr><td>InputStream</td><td>binary</td></tr>
     *  <tr><td>java.sql.Date, java.util.Date, java.util.Calendar</td><td>date</td></tr>
     *  <tr><td>java.sql.Time</td><td>time</td></tr>
     *  <tr><td>java.sql.Timestamp</td><td>datetime</td></tr>
     *  </table>
     *  <p>
     *  Finally, this table shows how Java types are derived into DataSource types when we use an 
     *  annotated class as a source of metadata.  Note annotated classes are necessary for JPA
     *  DataSources, but you can choose to use them for other types of DataSource as well.  
     *  For Hibernate DataSources, this is very worthwhile because Hibernate will also make use
     *  of the annotations as config, meaning you don't need to specify <code>.hbm.xml</code> 
     *  files.  For SQL and custom DataSources, there is no benefit at the persistence level, 
     *  but it may still be worthwhile because the use of an annotated class gives us better 
     *  metadata and allows us to generate a better, closer-fitting autoDerive DataSource than 
     *  we can from examination of SQL schema or plain Java Beans:
     *  <table border="1" class="normal">
     * <tr><th>Java type</th><th>{@link com.smartgwt.client.docs.serverds.DataSourceField#type
     * DataSource type}</th></tr>
     *  <tr><td>boolean, Boolean</td><td>boolean</td></tr>
     *  <tr><td>char, Character, String, Reader</td><td>text</td></tr>
     * <tr><td>byte, short, int, long, Byte, Short, Integer, Long,
     * BigInteger</td><td>integer</td></tr>
     *  <tr><td>float, double, Float, Double, BigDecimal</td><td>float</td></tr>
     *  <tr><td>InputStream</td><td>binary</td></tr>
     *  <tr><td>java.util.Date (with Temporal set to DATE), java.sql.Date</td><td>date</td></tr>
     *  <tr><td>java.util.Date (with Temporal set to TIME), java.sql.Time</td><td>time</td></tr>
     * <tr><td>java.util.Date (with Temporal set to TIMESTAMP), java.util.Calendar,
     * java.sql.Timestamp</td><td>datetime</td></tr>
     *  <tr><td>Enum (with Enumerated set to STRING)</td><td>enum (see discussion below)</td></tr>
     *  <tr><td>Enum (with Enumerated set to ORDINAL)</td><td>intEnum (see discussion below)</td></tr>
     *  <tr><td>Field with Lob annotation</td><td>binary</td></tr>
     * <tr><td>Field with GeneratedValue annotation</td><td>sequence, if the field is an integer type
     * (see discussion below)</td></tr>
     *  </table>
     *  <p>
     *  <h4>Primary keys, sequences and identity columns</h4>
     *  We attempt to derive information about primary keys from the metadata we have.
     *  <p>
     *  If the metadata source is an SQL table:
     *  <ul>
     *  <li>If the table does not have a native primary key constraint, no attempt is made to 
     *      identify primary key fields.  Otherwise:
     *  <li>The column or columns that make up the table's native primary key constraint are 
     *      identified using the JDBC <code>DatabaseMetaData.getPrimaryKeys()</code> API</li>
     *  <li>Each DataSource field that corresponds to one of these native primary key columns 
     *      is marked <code>primaryKey: true</code></li>
     *  <li>For each of these columns, the metadata returned by 
     *      <code>DatabaseMetaData.getColumns()</code> is inspected.  If the metadata includes
     *      <code>IS_AUTOINCREMENT=YES</code>, we mark the corresponding field as 
     *      <code>type="sequence"</code>.  This information should be reliably provided by 
     *      databases that implement "auto-increment" or "identity" column types, such as MySQL
     *      or Microsoft SQL Server</li>
     *  <li>If the previous step does not identify a column as a sequence, we inspect the 
     *      <code>ResultSetMetaData</code> obtained by running a dummy query on the table.  If 
     *      the <code>isAutoIncrement()</code> API returns true for that column, we mark the 
     *      corresponding field as <code>type="sequence"</code></li>
     *  <li>If the previous steps have not identified the column as a sequence, we check the 
     *      <code>TYPE_NAME</code> in the column metadata.  If it is "serial", this means the 
     *      column is a PostgreSQL "serial" or "serial8" type column.  Postgres does not 
     *      transparently implement auto-increment columns, but it does provide this serial 
     *      type, which causes the column to be implicitly bound to an underlying sequence.  So
     *      this type causes us to mark the field <code>type="sequence"</code>, and we also set
     * {@link com.smartgwt.client.docs.serverds.DataSourceField#implicitSequence implicitSequence}
     * true</li>
     *  <li>If the previous steps have not identified the column as a sequence, we check the 
     *      <code>COLUMN_DEF</code> in the column metadata.  If this contains the token "$$ISEQ"
     *      and ends with "NEXTVAL", this means the column is an Oracle "GENERATED AS IDENTITY" 
     *      column.  This type of column was introduced in Oracle 12c and is conceptually 
     *      exactly the same thing as the Postgres "serial" column described above.  We treat 
     *      it the same way: mark it <code>type="sequence"</code> and 
     *      <code>implicitSequence="true"</code></li>
     *  <li>If the previous steps have not identified the column as a sequence, then you may
     *      be using a pure sequence database, such as an Oracle version earlier than 12c, or 
     *      you may be using a database where both sequences and identity columns are available
     *      (Oracle, Postgres, DB2), and a sequence is being used either by design or because 
     *      the table was created before the database product supported identity columns.  In 
     *      this case, we cannot determine if the column should be a sequence or not.  However,
     *      in many applications, the fact that the column is an integer and is a primary key
     *      would imply that it is also a sequence.  Therefore, if the column is an integer and
     *     the <code>server.properties</code> flag <code>auto.derive.integer.pk.always.sequence</code>
     *      is true, we mark the field as <code>type="sequence"</code></li>
     *  <li>If, after all this, Smart GWT ends up incorrectly marking a primary key field as 
     *      a sequence (or vice versa), you can always override it on a per-field basis by 
     *      simply redeclaring the field with the correct type in your <code>.ds.xml</code> 
     *      file:<pre>
     *   &lt;DataSource serverType="sql" tableName="myTable" autoDeriveSchema="true"&gt;
     *     &lt;fields&gt;
     *       &lt;!-- This field was incorrectly marked as a sequence --&gt;
     *       &lt;field name="notASeq" type="integer" /&gt;
     *       &lt;!-- This field was incorrectly marked as an integer when it should be a sequence --&gt;
     *       &lt;field name="isASeq" type="sequence" /&gt;
     *     &lt;/fields&gt;
     *   &lt;/DataSource&gt;</pre></li>
     *  </ul>
     *  <p>  
     *  If the metadata source is Hibernate mappings described in a <code>.hbm.xml</code> file:
     *  <ul>
     *  <li>The first field we encounter that is described in the mapping with an &lt;id&gt; tag
     *      is marked as a primaryKey</li>
     *  <li>If that field is marked as being generated, we set its type to "sequence"</li>
     *  </ul>
     *  <p>  
     *  If the metadata source is an annotated object (whether JPA, Hibernate or just an 
     *  annotated POJO):
     *  <ul>
     *  <li>Any field with an <code>@Id</code> annotation is is marked as a primaryKey (this 
     *      differs from the Hibernate <code>.hbm.xml</code> file case because that is specific 
     *      to Hibernate, which does support composite keys, but not by specifying multiple 
     *      &lt;id&gt; tags.  Annotations are supported, via annotated POJOs, for any kind of 
     *      persistence strategy, so multiple <code>@Id</code> fields are perfectly valid)</li>
     *  <li>Any field with a <code>@GeneratedValue</code> annotation is either marked as 
     *      <code>type="sequence"</code> (if it is an integer type) or as 
     * <code>{@link com.smartgwt.client.docs.serverds.DataSourceField#autoGenerated
     * autoGenerated}="true"</code> (for other 
     *      field types)</li>
     *  </ul>
     *  Finally, if the metadata is a plain, unannotated Java object, no attempt is made to
     *  derive primary key fields.
     *  <h4>enums and valueMaps</h4>
     *  When we come across Java <code>Enum</code> properties in plain or annotated classes, 
     *  as well as setting the field type as noted in the above tables, we also generate a 
     *  valueMap for the field, based on the <code>Enum</code> members.  
     *  <p>
     *  For cases where we generate a field of Smart GWT type "enum" (see the above tables), 
     *  the keys of the valueMap are the result of calling <code>name()</code> on each member
     *  of the underlying Java Enum (in other words, its value exactly as declared in its 
     *  enum declaration).  For cases where we generate a field of Smart GWT type "intEnum",
     *  the keys of the valueMap are strings representing the ordinal number of each member 
     *  in the Java Enum - "0", "1", etc. Note that this behavior will be overriden by 
     * {@link com.smartgwt.client.docs.serverds.DataSource#enumTranslateStrategy
     * DataSource.enumTranslateStrategy} if both are set.
     *  <p>
     *  In both of these case, the display values generated for the valueMap are the result 
     *  of calling <code>toString()</code> on each Enum member.  If that gives the same 
     *  value as calling <code>name()</code>, the value is passed through 
     *  <code>DataTools.deriveTitleFromName()</code>, which applies the same processing rules
     * as {@link com.smartgwt.client.data.DataSource#getAutoTitle getAutoTitle()} to derive a more
     * user-friendly display value.
     *  <h4>Further notes</h4>
     *  <code>schemaBean</code> implies <code>autoDeriveSchema</code>, because it has no other 
     *  purpose than to name the bean to use for auto-derived schema.  Thus, if you specify
     *  <code>schemaBean</code> you do not need to specify <code>autoDeriveSchema</code> as well
     *  (though it does no harm to do so).  However, <code>tableName</code> and 
     *  <code>beanClassName</code> can be validly specified without implying 
     *  <code>autoDeriveSchema</code>, so in those cases you must explicitly specify 
     *  <code>autoDeriveSchema</code>.
     *  <p>
     *  The underlying super-DataSource is cached in server memory, so that it does 
     *  not have to be derived and created each time you need it.  However, the cache manager 
     *  will automatically refresh the cached copy if it detects that the deriving DataSource 
     *  has changed.  Thus, if you change the metadata your DataSource is deriving (if, for 
     *  example, you add a column to a table), all you need to do is touch the 
     *  <code>.ds.xml</code> file (ie, update its last changed timestamp - you don't actually
     *  have to change it) and the cached copy will be refreshed next time it is needed.
     *  <p>
     *  When autoDeriveSchema is set, SQLDataSource will automatically discover foreignKeys and
     *  deliver table and column name information to the client in hashed form so that two
     *  DataSources that are linked by native SQL foreign keys will automatically discover each
     *  other if loaded into the same application, and set 
     * {@link com.smartgwt.client.docs.serverds.DataSourceField#foreignKey foreignKey} automatically. 
     * Because the table and column 
     *  names are delivered as cryptohashes, there is no information leakage, but regardless,
     *  the feature can be disabled via setting <code>datasource.autoLinkFKs</code> to false in
     * {@link com.smartgwt.client.docs.Server_properties server.properties}.  This hashed linkage
     * information is
     * delivered to the client in properties {@link
     * com.smartgwt.client.docs.serverds.DataSource#tableCode tableCode} and
     * {@link com.smartgwt.client.docs.serverds.DataSourceField#fkTableCode
     * DataSourceField.fkTableCode}/{@link
     * com.smartgwt.client.docs.serverds.DataSourceField#fkColumnCode fkColumnCode}
     *
     * <p>Default value is null
     */
    public Boolean autoDeriveSchema;

    /**
     * For an XML DataSource, URN of the WebService to use to invoke operations.  This URN comes from
     * the "targetNamespace" attribute of the &lt;wsdl:definitions&gt; element in a WSDL (Web Service
     * Description Language) document, and serves as the unique identifier of the service. <P> Having
     * loaded a WebService using {@link com.smartgwt.client.data.XMLTools#loadWSDL
     * XMLTools.loadWSDL()}, setting <code>serviceNamespace</code> combined with specifying  {@link
     * com.smartgwt.client.docs.serverds.OperationBinding operationBindings} that set {@link
     * com.smartgwt.client.data.OperationBinding#getWsOperation OperationBinding.wsOperation} will
     * cause a DataSource to invoke web service operations to fulfill DataSource requests ({@link
     * com.smartgwt.client.data.DSRequest DSRequests}). <P> Setting <code>serviceNamespace</code> also
     * defaults {@link com.smartgwt.client.docs.serverds.DataSource#dataURL dataURL} to the service's
     * location, {@link com.smartgwt.client.docs.serverds.DataSource#dataFormat dataFormat} to "xml"
     * and {@link com.smartgwt.client.docs.serverds.OperationBinding#dataProtocol dataProtocol} to
     * "soap".
     *
     * <p>Default value is null
     * @see com.smartgwt.client.docs.ClientDataIntegration ClientDataIntegration overview and related methods
     */
    public String serviceNamespace;

    /**
     * The native field name used by this DataSource on the server to represent
     * <code>fileVersion</code> for {@link com.smartgwt.client.docs.FileSource FileSource Operations}.
     * <p> Automatic file versioning is configured by the presence of this property: if you want
     * automatic versioning for a FileSource DataSource, it is sufficient to simply define a 
     * <code>fileVersionField</code>.  When automatic versioning is on:<ul> <li>Calls to {@link
     * com.smartgwt.client.data.DataSource#saveFile saveFile()} will save a new version of the file,
     * retaining previous  versions up to the maximum configured by {@link
     * com.smartgwt.client.docs.serverds.DataSource#maxFileVersions maxFileVersions}; when that
     * maximum is reached, the oldest version is overwritten</li> <li>The {@link
     * com.smartgwt.client.data.DataSource#getFile getFile()} API always returns the most recent
     * version</li> <li>The {@link com.smartgwt.client.data.DataSource#listFiles listFiles()} API only
     * includes the most recent version of any file</li> <li>You can view and retrieve earlier
     * versions of a file with the  {@link com.smartgwt.client.data.DataSource#listFileVersions
     * listFileVersions()} and {@link com.smartgwt.client.data.DataSource#getFileVersion
     * getFileVersion()} APIs.  Note that retrieving a previous version of a file and then calling
     * <code>saveFile()</code> goes through the normal process of saving a new version</li> </ul> <p>
     * The <code>fileVersion</code> field is expected to be of type "datetime", and automatic 
     * versioning will not work otherwise.  Note, to minimize the possibility of version  timestamp
     * collisions, we recommend that <code>fileVersion</code> fields specify  {@link
     * com.smartgwt.client.docs.serverds.DataSourceField#storeMilliseconds storeMilliseconds}: true.
     * <p> If the fileVersionField is not configured, no automatic file versioning will be done.
     *
     * <p>Default value is null
     * @see com.smartgwt.client.docs.serverds.DataSource#maxFileVersions
     * @see com.smartgwt.client.data.DataSource#listFileVersions
     * @see com.smartgwt.client.data.DataSource#getFileVersion
     * @see com.smartgwt.client.data.DataSource#removeFileVersion
     * @see com.smartgwt.client.docs.FileSource FileSource overview and related methods
     */
    public String fileVersionField;

    /**
     * When true, indicates that fields in this DataSource will never be positively updated to the
     * null value; they may arrive at null values by being omitted, but we will  not send actual null
     * values in update requests.  When false (the default), null is  not treated in any special way.
     * <p> Setting this value causes null-assigned fields to be replaced with the field's {@link
     * com.smartgwt.client.docs.serverds.DataSourceField#nullReplacementValue nullReplacementValue},
     * if one is declared. If no <code>nullReplacementValue</code> is declared for the field, the null
     * assignment is replaced with the DataSource's {@link
     * com.smartgwt.client.docs.serverds.DataSource#nullStringValue nullStringValue},  {@link
     * com.smartgwt.client.docs.serverds.DataSource#nullIntegerValue nullIntegerValue}, {@link
     * com.smartgwt.client.docs.serverds.DataSource#nullFloatValue nullFloatValue}  or {@link
     * com.smartgwt.client.docs.serverds.DataSource#nullDateValue nullDateValue}, depending on the
     * field type. <p> For "add" operations, setting {@link
     * com.smartgwt.client.docs.serverds.DataSource#omitNullDefaultsOnAdd omitNullDefaultsOnAdd}
     * causes null-valued fields to be removed from the request entirely, rather than replaced with
     * default values as described above.
     *
     * <p>Default value is false
     */
    public boolean noNullUpdates;

    /**
     * By default, all DataSources are assumed to be capable of handling  {@link
     * com.smartgwt.client.docs.serverds.AdvancedCriteria} on fetch or filter type operations.  This
     * property may be set to <code>false</code> to indicate that this dataSource does not support 
     * advancedCriteria. See {@link com.smartgwt.client.data.DataSource#supportsAdvancedCriteria
     * supportsAdvancedCriteria()} for further information on this. <p> <b>NOTE:</b> If you specify
     * this property in a DataSource descriptor  (<code>.ds.xml</code> file), it is enforced on the
     * server.  This means that if you run  a request containing AdvancedCriteria against a DataSource
     * that advertises itself as  <code>allowAdvancedCriteria:false</code>, it will be rejected.
     *
     * <p>Default value is null
     * @see com.smartgwt.client.docs.serverds.OperationBinding#allowAdvancedCriteria
     */
    public Boolean allowAdvancedCriteria;

    /**
     * <b>This property only applies to the built-in SQL DataSource provided in Pro and better 
     * editions of Smart GWT</b> <p> Defines the name of the schema we use to qualify the {@link
     * com.smartgwt.client.docs.serverds.DataSource#tableName tableName} in generated SQL.  If you do
     * not provide this property, table names will not be qualified in generated  SQL, and thus the
     * default schema will be used.  Support for multiple schemas (or schemata) varies quite
     * significantly across the supported databases, as does the meaning of the  phrase "default
     * schema".  In addition, some databases allow you to override the default  schema in the JDBC
     * connection URL, which is a preferable approach if all your tables are  in the same
     * (non-default) schema. <p> The following table provides information by product: <p> <table
     * border="1" class="normal" width="90%"> <tr><td> Product</td><td width="90%"> Notes</td></tr>
     * <tr><td> DB2</td><td> Arbitrarily named schemas are supported.  The default schema is named
     * after the connecting user, though this can be overridden by specifying the "currentSchema"
     * property on the JDBC connection URL</td></tr> <tr><td> DB2 for iSeries</td><td> Arbitrarily
     * named schemas are supported.  "Schema" is synonymous with "library".  The  default schema
     * depends on the setting of the "naming" connection property.  When this is  set to "sql",
     * behavior is similar to other DB2 editions: the default schema is named after the connecting
     * user, unless overridden by specifying a library name in the JDBC connection  URL.  When
     * "naming" is set to "system", the schema of an unqualified table is resolved  using a
     * traditional search of the library list; the library list can be provided in the  "libraries"
     * property</td></tr> <tr><td> Firebird</td><td> Firebird does not support the concept of schema
     * at all - all "schema objects" like tables  and indexes belong directly to the database.  In
     * addition, Firebird actively rejects  qualified table names in queries as syntax errors;
     * therefore, you should <b>not</b> set the <code>schema</code> property for a DataSource that
     * will be backed by a Firebird database </td></tr> <tr><td> HSQLDB</td><td> Arbitrarily named
     * schemas are supported.  The default schema is auto-created when the database is created; by
     * default it is called "PUBLIC", but can be renamed.  It is not  possible to set the default
     * schema in the JDBC connection URL</td></tr> <tr><td> Informix</td><td> Informix databases can
     * be flagged as "ANSI mode" at creation time.  ANSI-mode databases  behave similarly to DB2 for
     * schema support: arbitrarily named schemas are supported, and the default schema is the one
     * named after the connected user.  Non-ANSI databases have no real schema support at all. It is
     * not possible to set the default schema in the JDBC  connection URL with either type of
     * database</td></tr> <tr><td> Microsoft SQL Server</td><td> Prior to SQL Server 2005, schema
     * support is similar to Oracle: "schema" is synonymous with  "owner".  As of SQL Server 2005,
     * schema is supported as a separate concept, and a user's  default schema can be configured
     * (though it still defaults to a schema with the same name as the user).  It is not possible to
     * set the default schema in the JDBC connection URL</td></tr> <tr><td> MySQL</td><td> MySQL does
     * not have a separate concept of "schema"; it treats the terms "schema" and  "database"
     * interchangeably.  In fact MySQL databases actually behave more like schemas, in  that a
     * connection to database X can refer to a table in database Y simply by qualifying  the name in
     * the query.  Also, because schema and database are the same concept in MySQL,  overriding the
     * "default schema" is done implicitly when you specify which database to  connect to in your JDBC
     * connection URL</td></tr> <tr><td> Oracle</td><td> Arbitrarily named schemas are not supported;
     * in Oracle, "schema" is synonymous with "user", so each valid user in the database is associated
     * implicitly with a schema of the same name, and there are no other schemas possible.  It is
     * possible to refer to tables in another user's schema (assuming you have the privileges to do
     * so) by simply qualifying the table name. The default schema is always implied by the connecting
     * user and cannot be overridden.</td></tr> <tr><td> Postgres</td><td> Arbitrarily named schemas
     * are supported. Rather than the concept of a "default schema", Postgres supports the idea of a
     * search path  of schemas, whereby unqualified table references cause a search of the list of
     * schemas in  order, and the first schema in the path is the "current" one for creation purposes.
     * Unfortunately, there is no way to specify this search path on the JDBC connection URL, so the
     * default schema comes from the user definition, ultimately defaulting to the default  "public"
     * schema</td></tr> </table>
     *
     * <p>Default value is null
     */
    public String schema;

    /**
     * If set to "false", transformation of values for {@link
     * com.smartgwt.client.docs.serverds.DataSourceField#multiple multiple:true} fields, normally
     * controlled by {@link com.smartgwt.client.docs.serverds.DataSourceField#multipleStorage
     * DataSourceField.multipleStorage}, is instead disabled for this entire DataSource.
     *
     * <p>Default value is null
     */
    public Boolean transformMultipleFields;

    /**
     * If {@link com.smartgwt.client.docs.serverds.DataSource#noNullUpdates noNullUpdates} is set, the
     * value to use for any integer field that has a null value assigned on an update operation, and
     * does not specify an explicit {@link
     * com.smartgwt.client.docs.serverds.DataSourceField#nullReplacementValue nullReplacementValue}.
     *
     * <p>Default value is 0
     * @see com.smartgwt.client.docs.serverds.DataSource#noNullUpdates
     * @see com.smartgwt.client.docs.serverds.DataSourceField#nullReplacementValue
     */
    public int nullIntegerValue;

    /**
     * The name of the property this DataSource uses for constant name when translating Java
     * enumerated types to and from Javascript, if the {@link
     * com.smartgwt.client.types.EnumTranslateStrategy} is set to "bean".  Defaults to "_constant" if
     * not set. <p>  This property is only applicable if you are using the Smart GWT server
     *
     * <p>Default value is null
     */
    public String enumConstantProperty;

    /**
     * Enables saving of a log of changes to this DataSource in a second DataSource with the same
     * fields, called the "audit DataSource".  <b>NOTE</b>: this feature applies to Enterprise Edition
     * only; for more information on edition-specific features, see <a
     * href='http://smartclient.com/product' target='_blank'>http://smartclient.com/product</a>. <p>
     * When auditing is enabled, every time a DSRequest modifies this DataSource, a Record is added to
     * the audit DataSource that shows the record as it existed after the change was made (or for a
     * "remove", the values of the record at the time of deletion).  In addition, the audit DataSource
     * has the following additional metadata fields: <ul> <li> {@link
     * com.smartgwt.client.docs.serverds.DataSource#auditTypeFieldName "audit_operationType"}: type of
     * the change ("update", "add" or "remove") <li> {@link
     * com.smartgwt.client.docs.serverds.DataSource#auditUserFieldName "audit_modifier"}: username of
     * the user that made the change.  The username is      determined in the same way that the      
     * {@link com.smartgwt.client.docs.serverds.OperationBinding#requiresRole Declarative Security}
     * subsystem determines the       current user. <li> {@link
     * com.smartgwt.client.docs.serverds.DataSource#auditTimeStampFieldName "audit_changeTime"}: a
     * field of type "datetime" recording      the timestamp of the change <li> {@link
     * com.smartgwt.client.docs.serverds.DataSource#auditRevisionFieldName "audit_revision"}: a field
     * of type "sequence" recording a      simple increasing integer value <li> {@link
     * com.smartgwt.client.docs.serverds.DataSource#auditChangedFieldsFieldName
     * "audit_changedFields"}: a      {@link
     * com.smartgwt.client.docs.serverds.DataSourceField#multiple "multiple"} field of type "string". 
     * For "update"      operations, records which fields have changed; otherwise, null </ul> <p> If
     * any of the field names above collide with field names of the DataSource being audited, an
     * integer suffix will also be added, starting with 2 (for example, "audit_modifier2", then
     * "audit_modifier3", etc). <p> To omit a data field from the automatically generated audit
     * DataSource, just set {@link com.smartgwt.client.docs.serverds.DataSourceField#audit
     * DataSourceField.audit} to false.  Audit can be disabled for a given DSRequest via the
     * server-side API <code>DSRequest.setSkipAudit()</code>, or for a specific operation  via the
     * {@link com.smartgwt.client.docs.serverds.OperationBinding#skipAudit operationBinding.skipAudit}
     * setting. <p> Note: The DataSource audit feature works only with single row operations;
     * operations with  {@link com.smartgwt.client.docs.serverds.OperationBinding#allowMultiUpdate
     * allowMultiUpdate} enabled are not supported. <p> <h4>Auto-generated Audit DataSources</h4> <p>
     * The audit DataSource is normally automatically generated, and unless otherwise specified with
     * {@link com.smartgwt.client.docs.serverds.DataSource#auditDataSourceID auditDataSourceID}, the
     * ID of the audit DataSource will be <code>audit_[OriginalDSID]</code>.   <p> By default, the
     * automatically generated audit DataSource will be of the same type as the DataSource being
     * audited, however, if the DataSource being audited is not already a SQLDataSource, we recommend
     * using {@link com.smartgwt.client.docs.serverds.DataSource#auditDSConstructor
     * auditDSConstructor:"sql"} to use a SQLDataSource as the audit DataSource.  This is because a
     * SQLDataSource used an audit DataSource will automatically generate a SQL table for storing
     * audit data the first time changes are made.  JPA would require manual creation of a Java Bean,
     * and Hibernate requires  <a href='http://www.google.com/search?q=hbm2ddl.auto'
     * target='_blank'>hbm2ddl.auto=update</a> to be set, which is widely considered unsafe for
     * production use. <p> Automatically created audit DataSources can be loaded and queried just like
     * other DataSources, using the DataSourceLoader, and using the server-side API
     * <code>DataSource.getAuditDataSource()</code>.  However, you <b>must</b> load the DataSource
     * being audited before loading its automatically created audit DataSource. <p> Note, that
     * automatic SQL tables creation can be disabled. See  {@link
     * com.smartgwt.client.docs.serverds.DataSource#autoCreateAuditTable autoCreateAuditTable} for
     * details. <p> <h4>Manually created Audit DataSources</h4> <p> The audit DataSource can also be
     * manually created.  In this case, you can  can either follow the naming conventions described
     * above for the ID of the audit DataSource and the names of metadata fields, or use the linked
     * properties to assign custom names.  If you omit any data fields from the tracked DataSource in
     * your audit DataSource, those fields will be ignored for auditing purposes, exactly as though
     * {@link com.smartgwt.client.docs.serverds.DataSourceField#audit DataSourceField.audit} had been
     * set to false for an automatically-generated audit DataSource. <p> Also, note that in case of
     * manually defined audit DataSource, if this DataSource is defined so it inherits the audited
     * DataSource, all the audited DataSource's fields will be inherited, this including the primary
     * keys. Since for the audit DataSource the primary key should be the revision field, in order to
     * prevent the audit DataSource having two primary keys, the inherited DataSource's primary key 
     * will have to be declared in audit DataSource, but with the primaryKey attribute  omitted (as
     * well not being of type "sequence") in the audit DataSource.
     *
     * <p>Default value is false
     * @see com.smartgwt.client.docs.ServerDataIntegration ServerDataIntegration overview and related methods
     */
    public boolean audit;

    /**
     * Class for ResultTrees used by this datasource.  If null, defaults to using {@link
     * com.smartgwt.client.widgets.tree.ResultTree}. <P> This can be set to a custom subclass of
     * ResultTree that, for example, hangs on to extra information necessary for integration with web
     * services.
     *
     * <p>Default value is null
     */
    public Map resultTreeClass;

    /**
     * Value to use for the {@link com.smartgwt.client.docs.serverds.DataSource#ownerIdField
     * ownerIdField} if no one  has authenticated. <p>This setting can be overridden at the
     * operationBinding level.
     *
     * <p>Default value is null
     * @see com.smartgwt.client.docs.serverds.DataSource#ownerIdField
     * @see com.smartgwt.client.docs.serverds.OperationBinding#guestUserId
     */
    public String guestUserId;

    /**
     * Provides a default value for {@link
     * com.smartgwt.client.docs.serverds.OperationBinding#recordName OperationBinding.recordName}.
     *
     * <p>Default value is null
     * @see com.smartgwt.client.docs.ClientDataIntegration ClientDataIntegration overview and related methods
     */
    public String recordName;

    /**
     * Setting <code>autoCreateAuditTable</code> to <code>true</code> indicates that audit DataSource 
     * will automatically create SQL table when {@link
     * com.smartgwt.client.docs.serverds.DataSource#audit auditing} is enabled. <p> Note, that
     * <code>autoCreateAuditTable</code> attribute takes effect only if framework setting 
     * <code>audit.autoCreateTables</code> in <code>server.properties</code> is set to
     * <code>false</code>, which by default is set to <code>true</code>.
     *
     * <p>Default value is true
     */
    public boolean autoCreateAuditTable;

    /**
     * Transport to use for all operations on this DataSource. Defaults to {@link
     * com.smartgwt.client.rpc.RPCManager#defaultTransport defaultTransport}.  This would typically
     * only be set to enable "scriptInclude" transport for contacting {@link
     * com.smartgwt.client.docs.serverds.DataSource#dataFormat JSON} web services hosted on servers
     * other than the origin server. <p> When using the "scriptInclude" transport, be sure to set
     * {@link com.smartgwt.client.docs.serverds.DataSource#callbackParam callbackParam} or {@link
     * com.smartgwt.client.docs.serverds.OperationBinding#callbackParam
     * OperationBinding.callbackParam} to match the name of the query parameter name expected by your
     * JSON service provider.
     *
     * <p>Default value is RPCManager.defaultTransport
     * @see com.smartgwt.client.types.RPCTransport
     * @see com.smartgwt.client.docs.serverds.DataSource#callbackParam
     * @see com.smartgwt.client.docs.ClientDataIntegration ClientDataIntegration overview and related methods
     */
    public RPCTransport dataTransport;

    /**
     * Setting a DataSource to be <code>serverOnly="true"</code> ensures that it will not be visible
     * to the client. Any request through IDACall to this DataSource will return a failure response.
     * Only requests which have been initiated on the server-side will be executed against this
     * DataSource.
     *
     * <p>Default value is null
     */
    public String serverOnly;

    /**
     * Indicates that for server responses, for any data being interpreted as DataSource records, 
     * only data that corresponds to declared fields should be retained; any extra fields should be
     * discarded. <P> For {@link com.smartgwt.client.docs.serverds.DataSource#dataFormat JSON} data,
     * this means extra properties in selected objects are dropped. <P> By default, for DMI
     * DSResponses, DSResponse.data is filtered on the server to just the set of fields defined on the
     * DataSource.  This type of filtering can also be enabled for non-DMI DSResponses (see the
     * overview in {@link com.smartgwt.client.docs.DmiOverview DMI}).  Setting this property to
     * <code>false</code> disables this filtering for this DataSource only.  This setting overrides
     * the configuration in {@link com.smartgwt.client.docs.Server_properties server.properties}. 
     * This setting can be overridden by {@link
     * com.smartgwt.client.docs.serverds.ServerObject#dropExtraFields ServerObject.dropExtraFields}.
     *
     * <p>Default value is null
     * @see com.smartgwt.client.docs.ClientDataIntegration ClientDataIntegration overview and related methods
     */
    public Boolean dropExtraFields;

    /**
     * For DataSources using the {@link com.smartgwt.client.docs.SqlDataSource Smart GWT SQL engine}
     * for persistence, which database configuration to use.  Database configurations can be created
     * using the {@link com.smartgwt.client.docs.AdminConsole Admin Console}.  If unset, the default
     * database configuration is used (which is also settable using the "Databases" tab).
     *
     * <p>Default value is null
     * @see com.smartgwt.client.docs.ServerDataIntegration ServerDataIntegration overview and related methods
     */
    public String dbName;

    /**
     * Similar to {@link com.smartgwt.client.docs.serverds.OperationBinding#requiresRole
     * OperationBinding.requiresRole}, but controls access to the DataSource as a whole.
     *
     * <p>Default value is null
     * @see com.smartgwt.client.docs.DeclarativeSecurity DeclarativeSecurity overview and related methods
     */
    public String requiresRole;

    /**
     * For SQL DataSources, tells the framework whether to surround the associated  {@link
     * com.smartgwt.client.docs.serverds.DataSource#tableName table name} with quotation marks
     * whenever it appears in generated queries.  This is only required if you have to connect to a
     * table with a name that is in breach of your database product's naming conventions.  For
     * example, some  products (eg, Oracle) internally convert all unquoted references to upper case,
     * so if you create a table called <code><b>myTest</b></code>, the database actually calls it 
     * <code><b>MYTEST</b></code> unless you quoted the name in the create command, like this: <p>
     * <code><b>&nbsp;&nbsp;CREATE TABLE "myTest"</b></code> <p> If you <em>do</em> quote the name
     * like this, or if you have to connect to a legacy table that has been named in this way, then
     * you must set this property to tell the SQL engine  that it must quote any references to this
     * table name (this requirement depends on the  database in use - as noted below, some are not
     * affected by this problem).  If you do  not, you will see exceptions along the lines of "Table
     * or view 'myTest' does not exist". <p> Note, other database products (eg, Postgres) convert
     * unquoted names to lower case, which leads to the same issues.  Still others (eg, SQL Server)
     * are not case sensitive and are  not affected by this issue. <p> Generally, we recommend that
     * you avoid using this property unless you have a specific  reason to do so.  It is preferable to
     * avoid the issue altogether by simply not quoting  table names at creation time, if you are able
     * to do so.
     *
     * <p>Default value is null
     * @see com.smartgwt.client.docs.serverds.DataSource#tableName
     * @see com.smartgwt.client.docs.serverds.DataSource#quoteColumnNames
     * @see com.smartgwt.client.docs.ServerDataIntegration ServerDataIntegration overview and related methods
     */
    public Boolean quoteTableName;

    /**
     * The native field name used by this DataSource on the server to represent
     * <code>fileLastModified</code> for {@link com.smartgwt.client.docs.FileSource FileSource
     * Operations}. <p>If the fileLastModifiedField is not configured, then a field named
     * "fileLastModified" will be used, if it exists. <!-- TODO: Binary fields? -->  Otherwise, the
     * server will look for a field with a "modifierTimestamp" type. If that is not found, the
     * DataSource will not keep track of the last modified date.
     *
     * <p>Default value is null
     * @see com.smartgwt.client.docs.FileSource FileSource overview and related methods
     */
    public String fileLastModifiedField;

    /**
     * Only applicable to {@link com.smartgwt.client.docs.BinaryFields binary fields} on {@link
     * com.smartgwt.client.docs.serverds.DataSource#audit audited} DataSources. <p> When determining
     * if a binary field has changed for auditing purposes, should we compare the metadata values (ie,
     * the associated <code>_filename</code> and <code>_filesize</code>  fields) or the actual binary
     * content?  If you set this flag to false, this will cause  Smart GWT to fetch the existing
     * content of any binary field from the database before any update, and then compare it byte by
     * byte to the new content.  You should consider if this  will have performance implications for
     * your application, particularly if you store large  binary values. <p> Note that value
     * comparison of any kind is only performed if the field's  {@link
     * com.smartgwt.client.docs.serverds.DataSourceField#audit DataSourceField.audit} setting is
     * "change"
     *
     * <p>Default value is true
     */
    public boolean compareMetadataForAuditChangeStatus;

    /**
     * Name of the field that has a long description of the record, or has the primary text data value
     * for a record that represents an email message, SMS, log or similar. <p> For example, for a
     * DataSource representing employees, a field containing the employee's "bio" might be a good
     * choice, or for an email message, the message body. <p> If descriptionField is unset, it
     * defaults to any field named "description" or "desc" in the record, or the first long text field
     * (greater than 255 characters) in the record, or null if no such field exists.
     *
     * <p>Default value is null
     * @see com.smartgwt.client.docs.DsSpecialFields DsSpecialFields overview and related methods
     */
    public String descriptionField;

    /**
     * If set, tells the SQL engine to quote column names in all generated DML and DDL  statements for
     * this dataSource.  This will ensure that queries generated against tables that do not follow the
     * database product's natural column-naming conventions  will still work. <p> In general we
     * recommend that you allow the database to use its natural naming scheme when creating tables
     * (put more simply, just do not quote column names in the  <code>CREATE TABLE</code> statement);
     * if you do this, you will not need to worry about  quoting column names when querying.  However,
     * if you are dealing with pre-existing  tables, or do not have control over the database naming
     * conventions used, this property may become necessary.  This property may also be necessary if
     * you are using field/column names that clash with reserved words in the underlying database
     * (these vary by database, but a field called "date" or "timestamp" would have problems with most
     * database products) <p> <b>Note:</b> Only applicable to dataSources of {@link
     * com.smartgwt.client.docs.serverds.DataSource#serverType serverType} "sql".
     *
     * <p>Default value is null
     */
    public Boolean quoteColumnNames;

    /**
     * The native field name used by this DataSource on the server to represent the
     * <code>fileFormat</code> for {@link com.smartgwt.client.docs.FileSource FileSource Operations}. 
     * <p>If the fileFormatField is not configured, then a field named "fileFormat" will be used, if
     * it exists. Otherwise, the DataSource will not track fileFormats -- this may be acceptable if,
     * for instance, the fileFormat is always the same. <p>The fileFormat is specified according to
     * the extension that would have been used in the filesystem -- for instance, the fileFormat for
     * employees.ds.xml would be "xml".
     *
     * <p>Default value is null
     * @see com.smartgwt.client.docs.FileSource FileSource overview and related methods
     */
    public String fileFormatField;

    /**
     * For this dataSource, should the millisecond portion of time and datetime values be  trimmed off
     * before before being sent from client to server or vice versa.  By default,  millisecond
     * information is preserved (ie, it is not trimmed).  You only need to consider trimming
     * millisecond values if their presence causes a problem - for example, a custom server that is
     * not expecting that extra information and so fails parsing. <p> Note that there is no inherent
     * support for millisecond precision in Smart GWT widgets; if you need millisecond-precise
     * visibility and editability of values in your client,  you must write custom formatters and
     * editors (or sponsor the addition of such things to the framework).  Server-side,
     * millisecond-precise values are delivered to and obtained from DataSources, so DataSource
     * implementations that are capable of persisting and  reading millisecond values should work
     * transparently.  Of the built-in DataSource types, the JPA and Hibernate DataSources will
     * transparently handle millisecond-precise values as long as the underlying database supports
     * millisecond precision, and the underlying  column is of an appropriate type.  The SQLDataSource
     * provides accuracy to the nearest second by default; you can switch on millisecond precision
     * per-field with the  {@link com.smartgwt.client.docs.serverds.DataSourceField#storeMilliseconds
     * storeMilliseconds} attribute.
     *
     * <p>Default value is null
     */
    public Boolean trimMilliseconds;

    /**
     * For Direct Method Invocation (DMI) binding, declares the ServerObject to use as the default
     * target for all {@link com.smartgwt.client.docs.serverds.DataSource#operationBindings
     * operationBindings}.  Specifying this attribute in an XML DataSource stored on the server
     * enables DMI for this DataSource. <P> <i>Note that if a dataSource configuration has both a
     * {@link com.smartgwt.client.docs.serverds.OperationBinding#script &lt;script&gt;} block and a
     * specified <code>serverObject</code> for some operation, the script block will be executed, and
     * the serverObject ignored.</i>
     *
     * <p>Default value is null
     * @see com.smartgwt.client.docs.ServerDataIntegration ServerDataIntegration overview and related methods
     */
    public ServerObject serverObject;

    /**
     * Additional properties to pass through to the {@link com.smartgwt.client.data.DSRequest}s made
     * by this DataSource.  This must be set before any {@link com.smartgwt.client.data.DSRequest}s
     * are issued and before any component is bound to the DataSource. <p> These properties are
     * applied before {@link com.smartgwt.client.data.DataSource#transformRequest transformRequest()}
     * is called.
     *
     * <p>Default value is null
     * @see com.smartgwt.client.data.DSRequest
     * @see com.smartgwt.client.docs.serverds.OperationBinding#requestProperties
     * @see com.smartgwt.client.docs.ServerDataIntegration ServerDataIntegration overview and related methods
     */
    public DSRequest requestProperties;

    /**
     * For DataSources with {@link com.smartgwt.client.docs.serverds.DataSource#audit auditing
     * enabled}, specifies the field name used to store the {@link
     * com.smartgwt.client.types.DSOperationType operationType} (in a field of type "text").  If empty
     * string is specified as the field name, the audit DataSource will not store this field.
     *
     * <p>Default value is "audit_operationType"
     */
    public String auditTypeFieldName;

    /**
     * If set, titles are automatically derived from {@link
     * com.smartgwt.client.docs.serverds.DataSourceField#name field.name} for any  field that does not
     * have a {@link com.smartgwt.client.docs.serverds.DataSourceField#title field.title} and is not
     * marked {@link com.smartgwt.client.docs.serverds.DataSourceField#hidden hidden}:true, by calling
     * the method {@link com.smartgwt.client.data.DataSource#getAutoTitle getAutoTitle()}.
     *
     * <p>Default value is true
     */
    public boolean autoDeriveTitles;

    /**
     * When true, indicates that any updates for this DataSource include only those fields  that have
     * actually changed (and primaryKey fields); when false (the default), all  field values are
     * included in updates, whether they have changed or not
     *
     * <p>Default value is false
     */
    public boolean sparseUpdates;

    /**
     * If set to true, both client and server-side advanced filtering used by Smart GWT will follow
     *  SQL99 behavior for dealing with NULL values, which is often counter-intuitive to users.
     *  Specifically, when a field has NULL value, all of the following expressions are false:
     *  <pre>
     *     field == "someValue"  (normally false)
     *     field != "someValue"  (normally true)
     *     not (field == "someValue")   (normally true)
     *     not (field != "someValue")   (normally false)
     *  </pre>
     *  This property can be overridden per-query by specifying <code>strictSQLFiltering</code>
     *  directly as a property on the {@link com.smartgwt.client.docs.serverds.AdvancedCriteria}.
     *  <p>
     *  <b>NOTE:</b> On the server side, this property is only applicable if you are using the 
     *  SQL DataSource; the other built-in types (Hibernate and JPA/JPA2) do not offer this mode.
     *
     * <p>Default value is false
     */
    public Boolean strictSQLFiltering;

    /**
     * If true, causes Smart GWT Server to use the "progressive loading" pattern for  fetches on this
     * dataSource, as described in the <b>Paging and total dataset length</b> section of the {@link
     * com.smartgwt.client.data.ResultSet ResultSet documentation}.  Essentially, this means that we
     * avoid issuing a row count query and instead advertise total rows as being slightly  more than
     * the number of rows we have already read (see {@link
     * com.smartgwt.client.docs.serverds.DataSource#endGap endGap}).  This  allows users to load more
     * of a dataset by scrolling past the end of the currently-loaded rows, but it prevents them from
     * scrolling directly to the end of the dataset. <p> Generally, progressive loading is appropriate
     * when you have to deal with very large  datasets. Note that by default, a dataSource will switch
     * into progressive loading mode  automatically when it detects that it is dealing with a dataset
     * beyond a certain size -  see {@link
     * com.smartgwt.client.docs.serverds.DataSource#progressiveLoadingThreshold
     * progressiveLoadingThreshold}. <p> This setting can be overridden for individual fetch
     * operations with the  {@link
     * com.smartgwt.client.docs.serverds.OperationBinding#progressiveLoading
     * OperationBinding.progressiveLoading} property, and also at the level of the individual {@link
     * com.smartgwt.client.data.DSRequest#getProgressiveLoading DSRequest}.  You can also specify 
     * <code>progressiveLoading</code> on  {@link
     * com.smartgwt.client.widgets.DataBoundComponent#getProgressiveLoading DataBoundComponents} and
     * certain types of  <code>FormItem</code> - {@link
     * com.smartgwt.client.widgets.form.fields.SelectItem#getProgressiveLoading SelectItem} and 
     * {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem#getProgressiveLoading
     * ComboBoxItem}. <p> Currently, this property only applies to users of the built-in
     * SQLDataSource, but you  could use it in custom DataSource implementations to trigger the server
     * behavior  described in the <code>ResultSet</code> documentation linked to above.
     *
     * <p>Default value is null
     * @see com.smartgwt.client.docs.serverds.OperationBinding#progressiveLoading
     * @see com.smartgwt.client.docs.serverds.DataSource#progressiveLoadingThreshold
     * @see com.smartgwt.client.docs.serverds.DataSource#lookAhead
     * @see com.smartgwt.client.docs.serverds.DataSource#endGap
     * @see com.smartgwt.client.docs.ProgressiveLoading ProgressiveLoading overview and related methods
     */
    public Boolean progressiveLoading;

    /**
     * For DataSources of {@link com.smartgwt.client.docs.serverds.DataSource#serverType serverType}
     * "hibernate", the name of a Spring  bean to query to obtain Hibernate Configuration for this
     * particular DataSource.  Note that this is intended for DataSource-specific configuration
     * overrides for unusual  circumstances, such as a DataSource whose physical data store is a
     * completely  different database to that used by other DataSources.  See the  {@link
     * com.smartgwt.client.docs.HibernateIntegration Integration with Hibernate} article for more 
     * information
     *
     * <p>Default value is null
     * @see com.smartgwt.client.docs.ServerDataIntegration ServerDataIntegration overview and related methods
     */
    public String configBean;

    /**
     * For DataSources that specify {@link
     * com.smartgwt.client.docs.serverds.DataSource#autoDeriveSchema autoDeriveSchema}, this property
     * indicates the name of the Spring bean, Hibernate mapping or fully-qualified Java class to use
     * as parent  schema.
     *
     * <p>Default value is null
     * @see com.smartgwt.client.docs.serverds.DataSource#autoDeriveSchema
     */
    public String schemaBean;

    /**
     * <b>Only applicable to the built-in SQL DataSource</b> <p> <code>tableCode</code> and the
     * related properties {@link com.smartgwt.client.docs.serverds.DataSourceField#columnCode
     * DataSourceField.columnCode}, {@link
     * com.smartgwt.client.docs.serverds.DataSourceField#fkTableCode DataSourceField.fkTableCode} and
     * {@link com.smartgwt.client.docs.serverds.DataSourceField#fkColumnCode
     * DataSourceField.fkColumnCode} are read-only attributes that are secure and unique cryptographic
     * hashes of table and column names used by this DataSource. <p> These properties are used
     * automatically by client-side framework code to  link dataSources together by {@link
     * com.smartgwt.client.docs.serverds.DataSourceField#foreignKey foreign key} when a
     * <code>foreignKey</code> is not explicitly declared, but is found in the SQL schema via the
     * {@link com.smartgwt.client.docs.serverds.DataSource#autoDeriveSchema autoDeriveSchema} feature.
     * <p> A secure hash is used rather than the actual SQL table or column name for security reasons
     * - sending the actual SQL table or column name to the client could aid in attempted SQL
     * injection attacks. <p> This feature can be disabled system-wide via setting
     * <code>datasource.autoLinkFKs</code> to <code>false</code> in {@link
     * com.smartgwt.client.docs.Server_properties server.properties}.
     *
     * <p>Default value is null
     */
    public String tableCode;

    /**
     * For DataSources with {@link com.smartgwt.client.docs.serverds.DataSource#audit auditing
     * enabled}, specifies the length of the field used 
     *  to store the names of the fields which were updated.  See also 
     * {@link com.smartgwt.client.docs.serverds.DataSource#auditChangedFieldsFieldName
     * auditChangedFieldsFieldName}
     *  <p>
     *  To set the changedFields field length for all DataSources that do not override the default,
     *  set <code>audit.auditChangedFieldsFieldLength</code> in your <code>server.properties</code>
     *  file.  For example <pre>
     *         audit.auditChangedFieldsFieldLength: 512
     *  </pre>
     *
     * <p>Default value is 255
     */
    public Integer auditChangedFieldsFieldLength;

    /**
     * For DataSources with {@link com.smartgwt.client.docs.serverds.DataSource#audit auditing
     * enabled}, optionally specifies the {@link
     * com.smartgwt.client.docs.serverds.DataSource#serverConstructor serverConstructor} for the
     * automatically generated audit DataSource.  The default is to use the same
     * <code>serverConstructor</code> as the DataSource where <code>audit="true"</code> was declared.
     * <p> This property is primarily intended to allow the use of SQLDataSource ({@link
     * com.smartgwt.client.docs.serverds.DataSource#serverType serverType:"sql"}) as an audit
     * DataSource for a DataSource that might be of another type.  For example, you might have a
     * DataSource that implements all CRUD operations via Java logic in {@link
     * com.smartgwt.client.docs.DmiOverview DMI declaration} methods, and so doesn't provide generic
     * storage; by using SQLDataSource as the type of your audit DataSource, you don't need to
     * implement your own scheme for storing and querying audit data, and the necessary audit tables
     * will be automatically generated in the database. <p> Similarly, even if you do use a reusable
     * DataSource type such as the built-in JPADataSource, using SQLDataSource for audit DataSources
     * means there's no need to write a JPA bean just to achieve storage of an audit trail. <p> To
     * simplify this intended usage, the string "sql" is allowed for <code>auditDSConstructor</code>
     * as a means of specifying that the built-in SQLDataSource class should be used.  For any other
     * type, use the fully qualified Java classname, as is normal for <code>serverConstructor</code>.
     *
     * <p>Default value is null
     */
    public String auditDSConstructor;

    /**
     * For dataSources of {@link com.smartgwt.client.docs.serverds.DataSource#serverType serverType}
     * "sql" and "hibernate", specifies the inheritance  mode to use.  This property has no effect for
     * any other type of DataSource.
     *
     * <p>Default value is "full"
     * @see com.smartgwt.client.docs.serverds.DataSource#inheritsFrom
     */
    public DSInheritanceMode inheritanceMode;

    /**
     * If {@link com.smartgwt.client.docs.serverds.DataSource#noNullUpdates noNullUpdates} is set, the
     * value to use for any float field that has a null value assigned on an update operation, and
     * does not specify an explicit {@link
     * com.smartgwt.client.docs.serverds.DataSourceField#nullReplacementValue nullReplacementValue}.
     *
     * <p>Default value is 0.0
     * @see com.smartgwt.client.docs.serverds.DataSource#noNullUpdates
     * @see com.smartgwt.client.docs.serverds.DataSourceField#nullReplacementValue
     */
    public float nullFloatValue;

    /**
     * The name of the property this DataSource uses for ordinal number when translating Java
     * enumerated types to and from Javascript, if the {@link
     * com.smartgwt.client.types.EnumTranslateStrategy} is set to "bean".  Defaults to "_ordinal" if
     * not set. <p>  This property is only applicable if you are using the Smart GWT server
     *
     * <p>Default value is null
     */
    public String enumOrdinalProperty;

    /**
     * For a DataSource derived from WSDL or XML schema, the XML namespace this schema belongs to. 
     * This is a read-only attribute automatically present on DataSources returned from 
     * SchemaSet.getSchema() and {@link com.smartgwt.client.data.WebService#getSchema
     * WebService.getSchema()}.
     *
     * <p>Default value is null
     * @see com.smartgwt.client.docs.ClientDataIntegration ClientDataIntegration overview and related methods
     */
    public String schemaNamespace;

    /**
     * For dataSources of {@link com.smartgwt.client.docs.serverds.DataSource#serverType serverType}
     * "sql", determines whether we qualify column names with table names in any SQL we generate. 
     * This property can be overridden on specific operationBindings.
     *
     * <p>Default value is true
     * @see com.smartgwt.client.docs.serverds.OperationBinding#qualifyColumnNames
     */
    public Boolean qualifyColumnNames;

    /**
     * For DataSources using the {@link com.smartgwt.client.docs.SqlDataSource Smart GWT SQL engine}
     * for persistence, whether to use ANSI-style joins (ie, joins implemented with JOIN directives in
     * the table clause, as opposed to additional join expressions in the where clause). The default
     * value of null has the same meaning as setting this flag to false. <P> Note, outer joins (see
     * {@link com.smartgwt.client.docs.serverds.DataSourceField#joinType joinType}) only work with
     * certain database products if you choose not to use ANSI joins.  Other than that, the join 
     * strategies are equivalent. <P> If you wish to switch on ANSI-style joins for every DataSource,
     * without the need to  manually set this property on all of them, set {@link
     * com.smartgwt.client.docs.Server_properties server.properties} flag 
     * <code>sql.useAnsiJoins</code> to true.
     *
     * <p>Default value is null
     * @see com.smartgwt.client.data.OperationBinding#getIncludeAnsiJoinsInTableClause
     * @see com.smartgwt.client.docs.ServerDataIntegration ServerDataIntegration overview and related methods
     */
    public Boolean useAnsiJoins;

    /**
     * For DataSources with {@link com.smartgwt.client.docs.serverds.DataSource#audit auditing
     * enabled}, specifies the field name used to store the revision number for the change (in a field
     * of type "sequence").  If empty string is specified as the field name, the audit DataSource will
     * not store this field.
     *
     * <p>Default value is "audit_revision"
     */
    public String auditRevisionFieldName;

    /**
     * Whether RPCRequests sent by this DataSource should enable {@link
     * com.smartgwt.client.rpc.RPCRequest#getShowPrompt RPCRequest.showPrompt} in order to block user
     * interactions until the request completes.   <p> DataSource requests default to blocking UI
     * interaction because, very often, if the user continues to interact with an application that is
     * waiting for a server response, some kind of invalid or ambiguous situation can arise. <p>
     * Examples include pressing a "Save" button a second time before the first save completes, making
     * further edits while edits are still being saved, or trying to initiate editing on a grid that
     * hasn't loaded data. <p> Defaulting to blocking the UI prevents these bad interactions, or
     * alternatively, avoids the developer having to write repetitive code to block invalid
     * interactions on every screen. <p> If an operation should ever be non-blocking, methods that
     * initiate DataSource requests (such as {@link com.smartgwt.client.data.DataSource#fetchData
     * fetchData()}) will generally have a <code>requestProperties</code> argument allowing
     * <code>showPrompt</code> to be set to false for a specific request.
     *
     * <p>Default value is true
     */
    public Boolean showPrompt;

    /**
     * Default URL to contact to fulfill all DSRequests.  Can also be set on a per-operationType basis
     * via {@link com.smartgwt.client.docs.serverds.OperationBinding#dataURL
     * OperationBinding.dataURL}. <P> NOTE: Best practice is to use the same <code>dataURL</code> for
     * all DataSources which fulfill DSRequests via the server-side RPCManager API.  Otherwise,
     * cross-DataSource {@link com.smartgwt.client.rpc.RPCManager#startQueue operation queuing} will
     * not be possible.
     *
     * <p>Default value is null
     * @see com.smartgwt.client.docs.ClientDataIntegration ClientDataIntegration overview and related methods
     */
    public String dataURL;

    /**
     * The default textMatchStyle to use for {@link com.smartgwt.client.data.DSRequest}s that do not
     * explicitly state  a {@link com.smartgwt.client.data.DSRequest#getTextMatchStyle
     * textMatchStyle}.    Note, however, that DSRequests  issued by {@link
     * com.smartgwt.client.widgets.grid.ListGrid}s and other {@link
     * com.smartgwt.client.widgets.DataBoundComponent components} will  generally have a setting for
     * textMatchStyle on the component itself (see {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getAutoFetchTextMatchStyle
     * ListGrid.autoFetchTextMatchStyle}, for example).
     *
     * <p>Default value is "exact"
     * @see com.smartgwt.client.docs.ServerDataIntegration ServerDataIntegration overview and related methods
     */
    public TextMatchStyle defaultTextMatchStyle;

    /**
     * Allows you to specify an arbitrary prefix string to apply to all json format responses  sent
     * from the server to this application. <P> The inclusion of such a prefix ensures your code is
     * not directly executable outside of your application, as a preventative measure against <a
     * href='http://www.google.com/search?q=javascript+hijacking' target='_blank'>javascript
     * hijacking</a>. <P> Only applies to responses formatted as json objects. Does not apply to
     * responses returned via scriptInclude type transport.<br> Note: If the prefix / suffix served by
     * your backend is not a constant, you can use  {@link
     * com.smartgwt.client.data.OperationBinding#getDataFormat dataFormat:"custom"} instead and
     * explicitly parse the prefix out as part of {@link
     * com.smartgwt.client.data.DataSource#transformResponse transformResponse()}.
     *
     * <p>Default value is null
     * @see com.smartgwt.client.data.OperationBinding#getDataFormat
     * @see com.smartgwt.client.data.OperationBinding#getDataTransport
     */
    public String jsonPrefix;

    /**
     * When {@link com.smartgwt.client.data.DataSource#getMockMode mockMode} is enabled, number of
     * rows of data to retrieve via an initial "fetch" DSRequest, for use as sample data.  Set to null
     * to retrieve all available rows.
     *
     * <p>Default value is 75
     */
    public Integer mockDataRows;

    /**
     * For DataSources with type {@link com.smartgwt.client.types.DSServerType
     * <code>projectFile</code>},
     *  specifies locations for the project files. In XML, each location is
     *  expressed with a <code>&lt;location&gt;</code> tag, e.g.:
     * 
     *  <pre>
     *      &lt;projectFileLocations&gt;
     *          &lt;location&gt;[WEBROOT]/shared/ds&lt;/location&gt;
     *          &lt;location&gt;ds://datasources&lt;/location&gt;
     *      &lt;/projectFileLocations&gt;
     *  </pre>
     * 
     *  Directories should be specified as absolute paths on the server.  If you
     *  want to construct a webroot-relative path, then prefix the path with
     *  <code>[WEBROOT]</code> (unlike in
     *  {@link com.smartgwt.client.docs.Server_properties server.properties}, where you would use
     *  <code>$webRoot</code> as the prefix).
     * 
     *  <p>To specify another DataSource to be used via 
     * {@link com.smartgwt.client.docs.FileSource fileSource operations}, use <code>ds://dsName</code>
     *  (where "dsName" is the name of the other DataSource).
     * 
     *  <p>A <code>projectFile</code> DataSource uses the standard
     *  {@link com.smartgwt.client.docs.FileSource fileSource} field names: <code>fileName</code>,
     *  <code>fileType</code>, <code>fileFormat</code>,
     *  <code>fileContents</code>, <code>fileSize</code> and
     *  <code>fileLastModified</code>. When defining a <code>projectFile</code>
     * DataSource, you can use {@link com.smartgwt.client.docs.serverds.DataSource#inheritsFrom
     * inheritsFrom} with
     *  a value of "ProjectFile" to inherit definitions for these fields -- e.g.:
     * 
     *  <pre>
     *      &lt;DataSource ID="MyDataSources" type="projectFile" inheritsFrom="ProjectFile"&gt;
     *          &lt;projectFileLocations&gt;
     *              &lt;location&gt;[WEBROOT]/shared/ds&lt;/location&gt;
     *              &lt;location&gt;ds://datasources&lt;/location&gt;
     *          &lt;/projectFileLocations&gt;
     *      &lt;/DataSource&gt; 
     *  </pre>
     * 
     *  <p>For directory locations, the
     *  <code>fileName</code> is relative to the directory specified. Note that
     *  the <code>fileName</code> does not include any extension for type or
     *  format.  For instance, for "employees.ds.xml", the <code>fileName</code>
     *  would be "employees", the <code>fileType</code> would be "ds" and the
     *  <code>fileFormat</code> would be "xml".
     * 
     *  <p>A projectFile DataSource executes the various 
     *  {@link com.smartgwt.client.docs.FileSource fileSource operations} in the following manner.
     *  The general rule is that <code>fileName</code>, <code>fileType</code>,
     *  and <code>fileFormat</code> are treated as primary keys. If files with the
     *  same combination of those attributes exist in more than one of the
     *  configured locations, the locations are considered in <b>reverse</b>
     *  order, with priority given to the location listed last. When modifying
     *  an existing file, the last location which contains the file will be
     *  used. When creating a new file, the file will be created in the last
     *  configured location.
     * 
     *  <dl>
     *  <dt>{@link com.smartgwt.client.data.DataSource#listFiles listFiles} 
     *  <dd>Returns a combined list of files from
     *      all configured locations. Note that <code>listFiles</code> does not 
     *      recurse into subdirectories. If the same combination of 
     *      <code>fileName / fileType / fileFormat</code> exists in more than
     *      one configured location, then the data for <code>fileSize</code> and
     *      <code>fileLastModified</code> will be taken from the last configured
     *      location which contains the file.
     * 
     *  <dt>{@link com.smartgwt.client.data.DataSource#hasFile hasFile}
     *  <dd>Indicates whether the file exists in any of the configured locations.
     * 
     *  <dt>{@link com.smartgwt.client.data.DataSource#getFile getFile}
     *  <dd>Returns file data by searching the locations in reverse order.
     * 
     *  <dt>{@link com.smartgwt.client.data.DataSource#saveFile saveFile}
     *  <dd>If the file exists, it will be saved in the last location in which
     *      it exists. If it is a new file, it will be saved in the last
     *      configured location.
     * 
     *  <dt>{@link com.smartgwt.client.data.DataSource#renameFile renameFile}
     *  <dd>The file will be renamed in the last location in which it exists.
     *      Note that if the file exists in more than one location, the rename
     *      will not affect other locations. Thus, a subsequent <code>listFiles</code>
     *      operation will return the file from the other location (as well
     *      as the renamed file).
     * 
     *  <dt>{@link com.smartgwt.client.data.DataSource#removeFile removeFile}
     *  <dd>The file will be removed from the last location in which it exists.
     *      Note that if the file exists in more than one location, the removal
     *      will not affect other locations. Thus, a subsequent <code>listFiles</code>
     *      operation will return the file from the other location.
     * 
     *  </dl>
     * 
     *  For convenience, a <code>projectFile</code> DataSource also responds to the standard
     *  DataSource operations, in the following manner:
     * 
     *  <dl>
     *  <dt>add
     *  <dd>Executes a <code>saveFile</code> operation, either adding the file or updating
     *      an existing file.
     * 
     *  <dt>fetch
     *  <dd>Executes a <code>listFiles</code> operation. Note that the results will not
     *      include the <code>fileContents</code>. In order to obtain the
     *      <code>fileContents</code>, you must use a
     *      {@link com.smartgwt.client.data.DataSource#getFile getFile operation}.
     * 
     *  <dt>update
     *  <dd>Executes a <code>renameFile</code> operation. Note that this will not update
     *      the <code>fileContents</code> -- for that, you need to use "add", or
     *      a {@link com.smartgwt.client.data.DataSource#saveFile saveFile operation}. 
     * 
     *  <dt>remove
     *  <dd>Executes a <code>removeFile</code> operation.
     * 
     *  </dl>
     * 
     * <p>If you specify both {@link com.smartgwt.client.docs.serverds.DataSource#projectFileKey
     * projectFileKey} and 
     *  <code>projectFileLocations</code>, then both with be used, with the
     *  <code>projectFileLocations</code> applied last.
     *
     * <p>Default value is null
     * @see com.smartgwt.client.docs.serverds.DataSource#projectFileKey
     * @see com.smartgwt.client.docs.FileSource FileSource overview and related methods
     */
    public String[] projectFileLocations;

    /**
     * Whether to convert relative date values to concrete date values before sending to the  server. 
     * Default value is true, which means that the server does not need to understand  how to filter
     * using relative dates - it receives all date values as absolute dates.
     *
     * <p>Default value is true
     */
    public Boolean autoConvertRelativeDates;

    /**
     * User-visible name for this DataSource. <P> For example, for the supplyItem DataSource, "Supply
     * Item". <P> If is unset, <code>getAutoTitle()</code> method will be used with
     * <code>dataSource.ID</code>. value in order to derive a default value for the title. <P> For
     * example "employee" ID will be derived to "Employee", "team_member" ID will be  derived to "Team
     * Member".
     *
     * <p>Default value is dataSource.ID
     */
    public String title;

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
     * ownerIdField matches the currently authenticated user can be read, updated or deleted.  <p>The
     * ownerIdField setting can be overridden at the {@link
     * com.smartgwt.client.docs.serverds.OperationBinding#ownerIdField OperationBinding.ownerIdField}
     * level. <p>If ownerIdField is specified, {@link
     * com.smartgwt.client.docs.serverds.DataSource#requiresAuthentication requiresAuthentication}
     * will default to <code>true</code>. If <code>requiresAuthentication</code> is explicitly set to
     * <code>false</code>, then unauthenticated users will be able to see all records. To avoid this,
     * you can use {@link com.smartgwt.client.docs.serverds.DataSource#guestUserId guestUserId} to
     * specify a default user to apply when no one has authenticated.
     *
     * <p>Default value is null
     * @see com.smartgwt.client.docs.serverds.OperationBinding#ownerIdField
     * @see com.smartgwt.client.docs.serverds.DataSource#guestUserId
     */
    public String ownerIdField;

    /**
     * If we are {@link com.smartgwt.client.docs.serverds.DataSource#progressiveLoading loading
     * progressively}, indicates the number of  extra records Smart GWT Server will read beyond the
     * end record requested by the client, in order to establish if there are more records to view. 
     * This property has no effect  if we are not progressive-loading. <p> This property can be
     * tweaked in conjunction with {@link com.smartgwt.client.docs.serverds.DataSource#endGap endGap}
     * to change behavior at the end of a dataset.  For example, with the default values of
     * <code>lookAhead: 1</code> and <code>endGap: 20</code>, we can end up with the viewport
     * shrinking if we get a case where there really was only one more record (because the client was
     * initially told there were 20 more).  This is not a problem per se, but it may be surprising to
     * the user. You could prevent this happening (at the cost of larger reads) by setting 
     * <code>lookAhead</code> to be <code>endGap+1</code>.
     *
     * <p>Default value is 1
     * @see com.smartgwt.client.docs.serverds.DataSource#progressiveLoading
     * @see com.smartgwt.client.docs.serverds.DataSource#endGap
     * @see com.smartgwt.client.docs.ProgressiveLoading ProgressiveLoading overview and related methods
     */
    public int lookAhead;

    /**
     * fieldName for a field in the dataSource expected to contain an explicit array of child nodes.
     *  Enables loading a databound tree as a hierarchical data structure, rather than a flat list of
     *  nodes linked by foreignKey.<br>
     * Note this is an alternative to setting {@link
     * com.smartgwt.client.docs.serverds.DataSourceField#childrenProperty
     * DataSourceField.childrenProperty} directly on
     *  the childrenField object.<P>
     * By default the children field will be assumed to be {@link
     * com.smartgwt.client.docs.serverds.DataSourceField#multiple multiple},
     *  for XML databinding. This implies that child data should be delivered in the format:
     *  <pre>
     *       &lt;childrenFieldName&gt;
     *           &lt;item name="firstChild" ...&gt;
     *           &lt;item name="secondChild" ...&gt;
     *       &lt;/childrenFieldName&gt;
     *  </pre>
     *  However data may also be delivered as a direct list of <code>childrenFieldName</code> 
     *  elements:
     *  <pre>
     *       &lt;childrenFieldName name="firstChild" ...&gt;
     *       &lt;childrenFieldName name="secondChild" ...&gt;
     *  </pre>
     *  If you want to return your data in this format, you will need to explicitly set 
     *  <code>multiple</code> to false in the appropriate dataSource field definition.
     *
     * <p>Default value is null
     * @see com.smartgwt.client.docs.serverds.DataSourceField#childrenProperty
     * @see com.smartgwt.client.docs.DataSourceRelations DataSourceRelations overview and related methods
     */
    public String childrenField;

    /**
     * Namespaces definitions to add to the root element of outbound XML messages sent to a web
     *  service, as a mapping from namespace prefix to namespace URI.
     *  <P>
     *  The default value is:
     *  <pre>
     *    globalNamespaces : {
     *       xsi: "http://www.w3.org/2001/XMLSchema-instance",
     *       xsd: "http://www.w3.org/2001/XMLSchema"
     *    },
     *  </pre>
     *  This default value allows the use of the xsi:type and xsi:nil attributes without further
     *  declarations.
     *  <P>
     *  Note that some web services will only accept specific revisions of the XML Schema URI.
     *  If xsi-namespaced attributes seem to be ignored by an older webservice, try the URI
     *  "http://www.w3.org/1999/XMLSchema-instance" instead.
     *
     * <p>Default value is ...
     */
    public Map globalNamespaces;

    /**
     * Analogous to {@link com.smartgwt.client.docs.serverds.DataSource#dropExtraFields
     * dropExtraFields}, for data sent to the server.  Setting this attribute to false ensures that
     * for any records in the data object, only fields that correspond to declared dataSource fields
     * will be present on the dsRequest data object passed to {@link
     * com.smartgwt.client.data.DataSource#transformRequest transformRequest()} and ultimately sent to
     * the server.
     *
     * <p>Default value is true
     * @see com.smartgwt.client.docs.ClientDataIntegration ClientDataIntegration overview and related methods
     */
    public Boolean sendExtraFields;

    /**
     * Criteria that are implicitly applied to all fetches made through this DataSource.  These
     * criteria are never shown to or edited by the user and are cumulative with any other  criteria
     * provided on the DSRequest. <P> For example, a DataSource might *always* implicitly limit its
     * fetch results to records  owned by the current user's department.  Components and ResultSets
     * requesting data  from the DataSource can then apply further implicitCriteria of their own,
     * separately  from their regular, user-editable criteria. <P> For instance, a grid bound to this
     * dataSource might be further limited to  implicitly show only the subset of records created by
     * the current user.  See  {@link
     * com.smartgwt.client.widgets.DataBoundComponent#getImplicitCriteria
     * DataBoundComponent.implicitCriteria} and {@link
     * com.smartgwt.client.data.ResultSet#getImplicitCriteria ResultSet.implicitCriteria} for  more on
     * these localized options. <P> Note that, while <code>implicitCriteria</code> can be declared in
     * a server DataSource  file using {@link com.smartgwt.client.docs.ComponentXML Component XML}, it
     * is an entirely client-side  feature, added by client-side components.  So it does not affect
     * server-side requests,  and will not be added to client-side requests that don't come from a
     * Smart GWT UI  (eg RestHandler).
     *
     * <p>Default value is null
     */
    public Criteria implicitCriteria;

    /**
     * ID of another DataSource this DataSource inherits its {@link
     * com.smartgwt.client.docs.serverds.DataSource#fields fields} from. <P> Local fields (fields
     * defined in this DataSource) are added to inherited fields  to form the full set of fields. 
     * Fields with the same name are merged in the same way that {@link
     * com.smartgwt.client.widgets.DataBoundComponent#getFields databound component fields} are merged
     * with DataSource fields. <P> The default order of the combined fields is new local fields first
     * (including any fields present in the parent DataSource which the local DataSource re-declares),
     * then parent fields.  You can set {@link
     * com.smartgwt.client.docs.serverds.DataSource#useParentFieldOrder useParentFieldOrder} to
     * instead use the parent's field order, with new local fields appearing last.  You can set {@link
     * com.smartgwt.client.docs.serverds.DataSource#showLocalFieldsOnly showLocalFieldsOnly} to have
     * all non-local fields hidden. <P> Note that <b>only fields are inherited</b> - other properties
     * such as dataURL and dataFormat are not.  You can use ordinary inheritance, that is, creating a
     * subclass of DataSource, in order to share properties such as dataURL across a series of
     * DataSources that also inherit fields from each other via <code>inheritsFrom</code>. <P> This
     * feature can be used for: <ul> <li>creating a customized view (eg, only certain fields shown)
     * which will be used by multiple {@link com.smartgwt.client.widgets.DataBoundComponent databound
     * components}. <li>adding presentation-specific attributes to metadata that has been
     * automatically derived from {@link com.smartgwt.client.data.XMLTools#loadXMLSchema XML Schema}
     * or other metadata formats <li>modeling object subclassing and extension in server-side code and
     * storage systems <li>modeling relational database joins, and the equivalents in other systems
     * <li>creating hooks for others to customize your application in a maintainable way.  For
     * example, if you have a dataSource "employee", you can create a dataSource "customizedEmployee"
     * which inherits from "employee" but does not initially define any fields, and bind all {@link
     * com.smartgwt.client.widgets.DataBoundComponent databound components} to "customizedEmployee". 
     * Customizations of fields (including appearance changes, field order, new fields, hiding of
     * fields, and custom validation rules) can be added to "customizedEmployee", so that they are
     * kept separately from the original field data and have the best possible chance of working with
     * future versions of the "employee" dataSource. </ul>
     *
     * <p>Default value is null
     */
    public String inheritsFrom;

    /**
     * User-visible plural name for this DataSource. <P> For example, for the supplyItem DataSource,
     * "Supply Items". <P> Defaults to <code>dataSource.title</code> + "s".
     *
     * <p>Default value is dataSource.ID
     */
    public String pluralTitle;

    /**
     * For audit DataSources, this required property specifies the ID of the {@link
     * com.smartgwt.client.docs.serverds.DataSource#audit audited} DataSource.  Automatically
     * populated for {@link com.smartgwt.client.docs.serverds.DataSource#generateAuditDS
     * auto-generated} audit DataSources.
     *
     * <p>Default value is varies
     */
    public String auditedDataSourceID;

    /**
     * For DataSources using the {@link com.smartgwt.client.docs.SqlDataSource Smart GWT SQL engine}
     * for persistence, what database table name to use.  The default is to use the DataSource ID as
     * the table name.
     *
     * <p>Default value is null
     * @see com.smartgwt.client.docs.serverds.DataSource#quoteTableName
     * @see com.smartgwt.client.docs.ServerDataIntegration ServerDataIntegration overview and related methods
     */
    public String tableName;

    /**
     * If {@link com.smartgwt.client.docs.serverds.DataSource#noNullUpdates noNullUpdates} is set, the
     * value to use for any boolean field that has a null value assigned on an update operation, and
     * does not specify an explicit {@link
     * com.smartgwt.client.docs.serverds.DataSourceField#nullReplacementValue nullReplacementValue}.
     *
     * <p>Default value is false
     * @see com.smartgwt.client.docs.serverds.DataSource#noNullUpdates
     * @see com.smartgwt.client.docs.serverds.DataSourceField#nullReplacementValue
     */
    public boolean nullBooleanValue;

    /**
     * See {@link com.smartgwt.client.docs.serverds.OperationBinding#recordXPath
     * OperationBinding.recordXPath}.  <code>recordXPath</code> can be specified directly on the
     * DataSource for a simple read-only DataSource only capable of "fetch" operations.
     *
     * <p>Default value is null
     * @see com.smartgwt.client.docs.ClientDataIntegration ClientDataIntegration overview and related methods
     */
    public XPathExpression recordXPath;

    /**
     * This property is only applicable to {@link
     * com.smartgwt.client.docs.serverds.DataSource#serverType SQL} DataSources, and  only for {@link
     * com.smartgwt.client.docs.serverds.OperationBinding operations} that express a  {@link
     * com.smartgwt.client.data.OperationBinding#getCustomSQL customSQL} clause.  In these
     * circumstances, we  generally switch off paging because we are unable to generate a "row count"
     * query that tells the framework the size of the complete, unpaged resultset. <p> The
     * <code>useSubselectForRowCount</code> flag causes the framework to derive a rowcount query by
     * simply wrapping the entire customSQL clause in a subselect, like so:<code><br>
     * &nbsp;&nbsp;&nbsp;&nbsp;SELECT COUNT(*) FROM ({customSQL clause here})</code> <p> However, this
     * is not guaranteed to give good results.  Because the customSQL clause can contain anything that
     * you can write in SQL, running it inside a subselect in order to  count the rows might not work,
     * might have unintended side-effects (if, for example, it  is a stored procedure call that
     * performs updates as part of its function), or it might  just be a bad idea - for example, if
     * the customSQL query is slow-running, you'll make  it twice as slow with this flag, simply
     * because you'll be running it twice.  We  recommend using this flag with care. <p> NOTE: This
     * setting can be overridden per-operation - see  {@link
     * com.smartgwt.client.docs.serverds.OperationBinding#useSubselectForRowCount
     * OperationBinding.useSubselectForRowCount}.  You can also set a global default for this setting,
     * so you don't have to specify it in every dataSource - define 
     * <code>useSubselectForRowCount</code> as true in your  {@link
     * com.smartgwt.client.docs.Server_properties server.properties} file.
     *
     * <p>Default value is null
     */
    public Boolean useSubselectForRowCount;

    /**
     * The native field name used by this DataSource on the server to represent the
     * <code>fileContents</code> for {@link com.smartgwt.client.docs.FileSource FileSource
     * Operations}. <p>If the fileContentsField is not configured, then a field named "fileContents"
     * or "contents" will be used, if it exists. <!-- If not found, the first field with a "binary"
     * type will be used. TODO: Binary field support not working yet. --> If not found, the longest
     * text field which is not the {@link com.smartgwt.client.docs.serverds.DataSource#fileNameField
     * fileNameField}, {@link com.smartgwt.client.docs.serverds.DataSource#fileTypeField
     * fileTypeField} or {@link com.smartgwt.client.docs.serverds.DataSource#fileFormatField
     * fileFormatField} will be used. <p>Note that the only method which will actually return the
     * fileContents is {@link com.smartgwt.client.data.DataSource#getFile getFile()} -- the other
     * {@link com.smartgwt.client.docs.FileSource FileSource} methods omit the fileContents for the
     * sake of efficiency.
     *
     * <p>Default value is null
     * @see com.smartgwt.client.docs.FileSource FileSource overview and related methods
     */
    public String fileContentsField;

    /**
     * If {@link com.smartgwt.client.docs.serverds.DataSource#noNullUpdates noNullUpdates} is set, the
     * value to use for any date or time field that has a null value assigned on an update operation,
     * and does not specify an explicit {@link
     * com.smartgwt.client.docs.serverds.DataSourceField#nullReplacementValue nullReplacementValue}.
     * <p> Unlike strings and numbers, there is no "natural" choice for a null replacement value  for
     * dates.  The default value we have chosen is midnight on January 1st 1970, simply  because this
     * is "the epoch" - the value that is returned by calling "new Date(0)"
     *
     * <p>Default value is See below
     * @see com.smartgwt.client.docs.serverds.DataSource#noNullUpdates
     * @see com.smartgwt.client.docs.serverds.DataSourceField#nullReplacementValue
     */
    public Date nullDateValue;

    /**
     * For a DataSource stored in .xml format on the Smart GWT server, indicates what server-side
     * connector to use to execute requests, that is, what happens if you call dsRequest.execute() in
     * server code.
     *
     * <p>Default value is "generic"
     * @see com.smartgwt.client.docs.ServerDataIntegration ServerDataIntegration overview and related methods
     */
    public DSServerType serverType;

    /**
     * Name of the field that has the most pertinent numeric, date, or enum value, for use when a
     * {@link com.smartgwt.client.widgets.DataBoundComponent} needs to show a short summary of a
     * record. <P> For example, for a DataSource of employees, good choices might be the "salary"
     * field, "hire date" or "status" (active, vacation, on leave, etc). <p> Unlike {@link
     * com.smartgwt.client.docs.serverds.DataSource#titleField titleField}, dataField is not
     * automatically determined in the absence of an explicit setting.
     *
     * <p>Default value is null
     * @see com.smartgwt.client.docs.DsSpecialFields DsSpecialFields overview and related methods
     */
    public String dataField;

    /**
     * If set, the DataSource will ensure that it never uses a cached HTTP response, even if the
     * server marks the response as cacheable. <P> Note that this does not disable caching at higher
     * levels in the framework, for example, the caching performed by {@link
     * com.smartgwt.client.data.ResultSet}.
     *
     * <p>Default value is true
     */
    public Boolean preventHTTPCaching;

    /**
     * When true, indicates that this DataSource supports multi-level sorting.
     *
     * <p>Default value is true
     */
    public boolean canMultiSort;

}
