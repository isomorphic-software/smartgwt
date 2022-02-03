
package com.smartgwt.client.docs;

/**
 * <h3>OpenAPI Specification (OAS) Support</h3>
 * If you allow access to your server-side DataSources via the
 * {@link com.smartgwt.client.docs.ServletDetails RESTHandler servlet}, the Smart GWT server can
 * also generate
 * a standard <a href='https://github.com/OAI/OpenAPI-Specification' target='_blank'>OpenAPI
 * specification</a>
 *  of the REST interface supported by <code>RestHandler</code>. This allows any client system
 *  that supports OpenAPI to access the operations supported by your DataSources. Because details
 * like {@link com.smartgwt.client.types.FieldType field types} and {@link
 * com.smartgwt.client.widgets.form.validator.Validator validators}) are automatically
 *  translated to OpenAPI, the OpenAPI specification (OAS) of your DataSource operations is much
 * more specific and detailed than the general {@link com.smartgwt.client.data.RestDataSource}
 * protocol spec, and
 *  can allow automatically generated UIs or automatically generated communication stubs to be
 *  much richer and easier to use.
 *  <p>
 *  Very often, a reasonably simple DataSource expresses more than can be easily translated to
 *  the current OpenAPI specification.  In such cases, efforts are made to use the OpenAPI
 * <a href='https://swagger.io/docs/specification/openapi-extensions/'
 * target='_blank'>extensions</a>
 *  mechanism to provide that level of detail.  Validators are one common area of interest.
 *  It is worthwhile to inspect the raw YAML output at least once before relying solely on
 *  visual tooling, unless said tooling
 * supports vendor extensions.  <a href='https://github.com/Redocly/redoc'
 * target='_blank'>ReDoc</a>,
 *  for example, is able to render the generated spec well, and in fact powers the example
 *  specification (see link below), but leaves out important details found in the extensions,
 * like the RESTHandler's JSON {@link com.smartgwt.client.data.RestDataSource#getJsonPrefix
 * prefix} and
 *  {@link com.smartgwt.client.data.RestDataSource#getJsonSuffix suffix}.
 * 
 *  <h4>Tooling</h4>
 *  The generated specification makes extensive use of
 * <a href='https://swagger.io/docs/specification/using-ref/' target='_blank'>remote
 * references</a> to make
 *  the spec more readable without tooling.  Unfortunately, a number of popular
 *  tools do not yet support the use of this OAS feature. Postman, for example, has at
 * least one <a href='https://github.com/postmanlabs/openapi-to-postman/issues/38'
 * target='_blank'>issue</a>
 *  that you can watch for progress.  In the meantime, we've found that the hosted
 * <a href='http://editor.swagger.io/' target='_blank'>Swagger</a> tools seem to work well, if you
 * make
 *  allowances for
 * <a href='https://developer.mozilla.org/en-US/docs/Web/HTTP/CORS' target='_blank'>Cross-Origin
 * Resource Sharing</a>.
 *  One very simple way of doing so with Swagger Editor, for example, is to enable a CORS filter
 *  (perhaps temporarily) like the one provided by
 * <a
 * href='https://www.eclipse.org/jetty/javadoc/jetty-9/org/eclipse/jetty/servlets/CrossOriginFilter.html'
 * target='_blank'>Jetty</a>:
 * 
 *  <pre>
 *      &lt;filter&gt;
 *          &lt;filter-name&gt;cross-origin&lt;/filter-name&gt;
 *          &lt;filter-class&gt;org.eclipse.jetty.servlets.CrossOriginFilter&lt;/filter-class&gt;
 *      &lt;/filter&gt;
 *      &lt;filter-mapping&gt;
 *          &lt;filter-name&gt;cross-origin&lt;/filter-name&gt;
 *          &lt;url-pattern&gt;/restapi/*&lt;/url-pattern&gt;
 *      &lt;/filter-mapping&gt;
 *  </pre>
 * 
 *  allowing the Swagger Editor to access the YAML generated for you by Smart GWT, through
 *  the use of its <code>url</code> query parameter.  e.g.,
 * <a href='http://editor.swagger.io/?url=http://localhost:8080/api/Customer.yaml'
 * target='_blank'>http://editor.swagger.io/?url=http://localhost:8080/api/Customer.yaml</a>
 * 
 *  <h4>Usage</h4>
 *  Configure the RESTHandler endpoint as usual (refer to server
 * <a href='../../../../../server/javadoc/com/isomorphic/servlet/RESTHandler.html'
 * target='_blank'>javadoc</a> for details), and
 *  submit a GET request there for the <code>openapi.yaml</code> resource.
 *  For example, if your servlet is configured to respond to requests at <code>/restapi</code>
 * 
 *  <pre>
 *    &lt;servlet-mapping&gt;
 *        &lt;servlet-name&gt;RESTHandler&lt;/servlet-name&gt;
 *        &lt;url-pattern&gt;/restapi/&lt;/url-pattern&gt;
 *    &lt;/servlet-mapping&gt;
 *  </pre>
 * 
 *  then a GET request to <code>/restapi/openapi.yaml</code> will yield the automatically
 *  generated documentation, based on your application's DataSource (ds.xml) configurations.
 *  This specification is generated dynamically, so that each new request for the specification
 *  includes any changes made to new or updated DataSources since the last request.
 *  Alternatively, save the file to disk, with modifications if desired, and serve it statically
 *  from another location if that's more in line with your requirement.
 * 
 *  <h4>Structure</h4>
 *  By design, <code>openapi.yaml</code> by default includes a reference to every path exposed
 *  by every DataSource.ds.xml file found in your project.  The paths exposed by your DataSource
 *  are determined by the rules documented in the
 * {@link com.smartgwt.client.docs.ServletDetails RESTHandler servlet's} SimplifiedREST protocol. 
 * For an Order
 *  DataSource with only default operationBindings, these references would look something like
 *  the following:
 * 
 *  <pre>
 *  paths:
 *    /:
 *      post:
 *        summary: DataSource-agnostic POSTMessage protocol
 *        # and so on... remainder clipped for brevity
 * 
 *    /RESTDataSource/Order/fetch:
 *      $ref: Order.yaml#/paths/~1RESTDataSource~1Order~1fetch
 *    /RESTDataSource/Order/add:
 *      $ref: Order.yaml#/paths/~1RESTDataSource~1Order~1add
 *    /RESTDataSource/Order/update:
 *      $ref: Order.yaml#/paths/~1RESTDataSource~1Order~1update
 *    /RESTDataSource/Order/remove:
 *      $ref: Order.yaml#/paths/~1RESTDataSource~1Order~1remove
 *    /RESTDataSource/Order/batch:
 *      $ref: Order.yaml#/paths/~1RESTDataSource~1Order~1batch
 *    /Order:
 *      $ref: Order.yaml#/paths/~1Order
 *    /Order/{orderId}:
 *      $ref: Order.yaml#/paths/~1Order~1%7BorderId%7D
 *  </pre>
 * 
 *  The first path in the above listing documents RESTHandler's singular AdvancedREST endpoint,
 * described by the {@link com.smartgwt.client.data.RestDataSource RESTDataSource's} postMessage
 * protocol and found in
 *  our example configuration at <code>/restapi/</code>.  As documented elsewhere, this should
 *  normally be the endpoint preferred by all but the simplest of integrations.
 *  <p>
 *  On the other hand, it is also the endpoint most difficult to document effectively,
 *  due in part to a handful of restrictions found in the OAS 3.x specification.  One such
 *  restriction is documented in an open issue around
 * <a href='https://github.com/OAI/OpenAPI-Specification/issues/2031'
 * target='_blank'>request/response correlation</a>,
 *  which in short points out that there is no good way to correlate a variation of some request
 *  to the matching variation on the response.  In the case of the AdvancedREST endpoint,
 *  of course, request and response formats both depend entirely on the values provided in
 *  <code>dataSource</code>, <code>operationType</code>, and <code>operationId</code> arguments.
 *  Ideally, we could document the inputs and outputs of a resource like
 *  <code>/restapi/?dataSource=Order&operationType=fetch&operationId=fetchByCustomer</code>
 *  separately from one like
 *  <code>/restapi/?dataSource=Order&operationType=fetch&operationId=fetchByUser</code>,
 *  but this is expressly
 * <a href='https://swagger.io/docs/specification/paths-and-operations/'
 * target='_blank'>disallowed</a>.
 *  <p>
 *  In the absence of any spec-compliant mechanism like
 * <a href='https://github.com/OAI/OpenAPI-Specification/issues/256#issuecomment-583476857'
 * target='_blank'>supporting interdependencies between query parameters</a>
 *  then, we also provide simplified variations of the AdvancedREST endpoint on each
 *  DataSource's specification, seen alongside the other SimplifiedREST endpoints with the
 *  <code>RESTDataSource</code> path.  These 'SimplifiedPOST' endpoints do allow for Criteria
 *  &amp; AdvancedCriteria, as well as batching of multiple operations against the same
 *  DataSource.
 *  <p>
 *  You can easily view all of the operations for a single DataSource by making the request to
 *  <code>{id}.yaml</code> instead of openapi.yaml, where <code>{id}</code> is the ID of any
 *  DataSource in your project.  Building on the examples above, a request for
 *  <code>/restapi/Order.yaml</code>would include every path except '/'.  Again, prefer
 *  the RestHandler's AdvancedREST endpoint to SimplifiedREST, with the caveat that
 *  SimplifiedREST documentation my be more explicit until a future version of the OAS spec
 *  addresses some of the issues discussed here.
 *  <p>
 *  A full example specification is too lengthy to include in documentation, so it is left to
 *  the reader to experiment with their own DataSources (sample DataSources are included with
 * the SDK and in {@link com.smartgwt.client.docs.MavenSupport Maven archetypes} or with the
 * example specification
 *  bundled in the SDK (link below), using this documentation as guidance.  Most of what is
 *  generated for you can be pretty easily traced back to your DataSource -
 * {@link com.smartgwt.client.data.DataSource#getDescription description}, field names,
 * required/optional attributes, and
 *  type mappings are all pretty straightforward, and the rest of it really should work the
 *  way you might expect it to.  A few specific examples include:
 * 
 *  <ul>
 *      <li>A field's valueMaps are expressed as an enum and appended to the
 *      {@link com.smartgwt.client.data.DataSourceField#getDescription description}, complete with
 * {@link com.smartgwt.client.docs.DataSourceLocalization i18n translations} as applicable, when a
 * locale
 *          can be derived from the servlet request or is specified explicitly with a 'locale'
 *          query parameter (e.g., ?locale=es).
 *      </li>
 *      <li>
 *        A note about authorization constraints is also appended, when any
 * {@link com.smartgwt.client.docs.serverds.DataSource#requiresAuthentication Declarative
 * Security} rules are found
 *        (rules themselves are not disclosed, by design).
 *      </li>
 *      <li>Any operationBinding with an explicit operationId is exposed on its own
 * path, where its binding-specific {@link
 * com.smartgwt.client.docs.serverds.OperationBinding#criteria criteria},
 *          {@link com.smartgwt.client.data.OperationBinding#getDescription description},
 * {@link com.smartgwt.client.docs.serverds.OperationBinding#outputs outputs}, etc. are respected.
 *      </li>
 *  </ul>
 * 
 *  Note that multiple operations of the same operationType are supported.  The example below
 *  illustrates the same DataSource with multiple add operations:
 *  <h5>DataSource</h5>
 *  <pre>
 *  &lt;DataSource serverType="sql" schema="PUBLIC" dbName="ClassicModels"
 *    ID="Order"
 *    tableName="orders"&gt;
 * 
 *    &lt;serverObject className="com.example.classicmodels.OrderOperations" /&gt;
 * 
 *    &lt;fields&gt;
 *      &lt;field name="orderNumber" type="sequence" primaryKey="true" /&gt;
 *      &lt;field name="orderDate" type="date" required="true" /&gt;
 *      &lt;field name="requiredDate" type="date" required="true" /&gt;
 *      &lt;field name="shippedDate" type="date" /&gt;
 *      &lt;field name="status" type="enum" length="15" required="true"&gt;
 *        &lt;valueMap&gt;
 *          &lt;value&gt;In Process&lt;/value&gt;
 *          &lt;value&gt;Shipped&lt;/value&gt;
 *          &lt;value&gt;Cancelled&lt;/value&gt;
 *          &lt;value&gt;Disputed&lt;/value&gt;
 *          &lt;value&gt;Resolved&lt;/value&gt;
 *          &lt;value&gt;On Hold&lt;/value&gt;
 *        &lt;/valueMap&gt;
 *      &lt;/field&gt;
 *      &lt;field name="comments" type="text" length="16777216" /&gt;
 *      &lt;field name="customerNumber" title="Customer" type="integer" required="true"
 *           foreignKey="Customer.customerNumber"
 *           displayField="customerName" /&gt;
 *      &lt;field name="customerName" includeFrom="Customer.customerName" hidden="true" /&gt;
 *    &lt;/fields&gt;
 *    &lt;operationBindings&gt;
 *      &lt;binding operationType="add" operationId="addWithDiscountCode" serverMethod="addWithDiscountCode" /&gt;
 *      &lt;binding operationType="add" operationId="addWithManualAdjustment" serverMethod="addWithManualAdjustment" /&gt;
 *    &lt;/operationBindings&gt;
 *  &lt;/DataSource&gt;
 *  </pre>
 *  <h5>Paths</h5>
 *  <pre>
 *    /Order:
 *      $ref: Order.yaml#/paths/~1Order
 *    /Order/{orderId}:
 *      $ref: Order.yaml#/paths/~1Order~1%7BorderId%7D
 *    /Order/add/addWithDiscountCode:
 *      $ref: Order.yaml#/paths/~1Order~1add~1addWithDiscountCode
 *    /Order/add/addWithManualAdjustment:
 *      $ref: Order.yaml#/paths/~1Order~1add~1addWithManualAdjustment
 *  </pre>
 * 
 *  <h4>Customization</h4>
 *  A complete specification will normally require at least some content that cannot be derived,
 *  so most users will at minimum want to replace default values for things like application
 *  title, description, and version number attributes.
 *  <p>
 *  The simplest means for this kind of minimal customization is through
 *  {@link com.smartgwt.client.docs.Server_properties server.properties} configuration.  Example
 *  values for supported properties include:
 * 
 *  <pre>
 *    openapi.info.version: 1.0.0
 *    openapi.info.title: New Application
 *    openapi.info.description: A short description of New Application
 * 
 *    ## default value derived from servlet context &amp; httpRequest
 *    openapi.servers.servletUrl: http://localhost:8080/restapi
 *  </pre>
 * 
 *  You may also use configuration to control which DataSources are exposed to your
 *  specification. Three strategies are supported:
 * 
 *  <ul>
 *    <li>Exclusion: Set an 'apidoc' attribute value to false on any DataSource definition to
 *        exclude it from the list of documented DataSource operations.
 *        <pre>&lt;DataSource ID="Order" tableName="orders" apidoc="false"&gt;</pre>
 *    </li>
 *    <li>Blacklisting: Exclude a (comma-separated) list of DataSources through server.properties
 *        configuration:
 *        <pre>openapi.ds.blacklisted: Order, OrderDetail</pre>
 *    </li>
 *    <li>Whitelisting: Exclude everything <strong>but</strong> a (comma-separated) list of
 *        DataSources, also through server.properties configuration:
 *        <pre>openapi.ds.whitelisted: Order, OrderDetail</pre>
 *    </li>
 *  </ul>
 * 
 *  No matter which strategy you use,
 * <a href='../../../../../server/javadoc/com/isomorphic/datasource/DynamicDSGenerator.html'
 * target='_blank'>Dynamic DataSources</a>
 *  must always be allowed explicitly, and are added to the list after whitelisting /
 *  blacklisting rules are applied.  Your DynamicDSGenerator must be able to resolve the given
 *  names, which may be supplied either through server.properties configuration or via
 *  an HttpServletRequest attribute, usually set by a filter that intercepts requests for the
 *  RESTHandler servlet.  The mechanism you use will depend on your requirement -
 *  DynamicDSGenerators registered using a simple
 * <a
 * href='../../../../../server/javadoc/com/isomorphic/datasource/DataSource.html#addDynamicDSGenerator-com.isomorphic.datasource.DynamicDSGenerator-java.lang.String-'
 * target='_blank'>prefix</a>
 *  may be easily configured using the former, while those registered using
 * <a
 * href='../../../../../server/javadoc/com/isomorphic/datasource/DataSource.html#addDynamicDSGenerator-com.isomorphic.datasource.DynamicDSGenerator-java.util.regex.Pattern'
 * target='_blank'>patterns</a>
 *  may need to be a little more dynamic, and better suited to the latter approach.
 *  The following are examples of both approaches, which work equally well:
 * 
 *  <pre>openapi.ds.dynamics: DYN_Environment, DYN_Status</pre>
 *  <pre>request.setAttribute("openapi.ds.dynamics", "DynamicOrder$Foo_0123, DynamicOrderItem$Foo_0123,");</pre>
 * 
 *  Finally, a DataSource is automatically excluded from the specification under the
 *  following circumstances:
 *  <ul>
 *    <li>It is marked with serverOnly="true"</li>
 *    <li>It is marked with requires="false"</li>
 *    <li>It is marked with its type="component"</li>
 *    <li>It has no fields (and inherits no fields)</li>
 *  </ul>
 * 
 *  Similarly, an explicitly defined operationBinding may also be excluded from the
 *  specification, if one or more of the following conditions are true:
 *  <ul>
 *      <li>It is configured for exclusion with an 'apidoc' attribute value of false.
 *        <pre>&lt;binding apidoc="false" operationType="add" operationId="addWithDiscountCode" serverMethod="addWithDiscountCode" /&gt;</pre>
 *      </li>
 *      <li>The operationType is 'update' or 'remove' and (neither of these are common scenarios):
 *          <ul>
 *              <li>No primaryKeys have been defined AND the binding is not configured to
 *    {@link com.smartgwt.client.docs.serverds.OperationBinding#allowMultiUpdate allowMultiUpdate}
 *              </li>
 *              <li>OR there are no non-key fields at all</li>
 *          </ul>
 *      </li>
 *  </ul>
 * 
 * 
 *  For very advanced customizations, a handful of
 *  <a href='https://freemarker.apache.org/' target='_blank'>Freemarker</a>
 *  templates are bundled with the server runtime, and can be found in the
 *  <code>com.isomorphic.openapi</code> package of the isomorphic-core-rpc module.  Any of these
 *  templates may be overridden by placing a copy in a location known to the RESTHandler servlet
 *  (again, refer to server javadoc), but this kind of thing should normally be considered the
 *  last course of action.
 *  <p>
 * 
 *  <h4>FAQ</h4>
 *  As always, the SmartGWT
 *  <a href='https://forums.smartclient.com/' target='_blank'>forums</a>
 *  are an appropriate place to seek guidance in unusual circumstances.
 * 
 *  <h4>Examples</h4>
 *  <ul>
 * <li> <a target="_blank" href="../../../docs/resources/openapi.html">Example OpenAPI
 * Specification</a>
 *  </ul>
 */
public interface OpenapiSupport {
}
