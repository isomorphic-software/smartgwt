
package com.smartgwt.client.docs;

/**
 * <h3>Integration with Hibernate</h3>
 * Smart GWT can integrate with Hibernate in two main ways, both of which are enabled by
 *  creating a DataSource descriptor (.ds.xml file) with
 *  {@link com.smartgwt.client.docs.serverds.DataSource#serverType serverType="hibernate"}:
 *  <ul>
 *  <li> Pre-existing beans: a Smart GWT DataSource can be automatically derived from either a
 *  Hibernate-managed bean or the Hibernate mapping.  Use
 *  {@link com.smartgwt.client.docs.serverds.DataSource#schemaBean schemaBean} to derive from the bean or
 * {@link com.smartgwt.client.docs.serverds.DataSource#autoDeriveSchema autoDeriveSchema} to derive from the mapping.  In
 * this case you will
 *  initially have a very short .ds.xml per bean - no &lt;fields&gt; are required unless
 *  and until you want to override the automatically derived fields.
 *  <li> "Beanless" mode: Smart GWT can drive Hibernate as a storage layer only, automatically
 *  generating Hibernate configuration from a Smart GWT DataSource file
 *  (<i>dataSourceID</i>.ds.xml).  In this case, you do not write a Java bean or create
 *  Hibernate mappings; Hibernate's beanless
 * <a href='http://www.hibernate.org/hib_docs/v3/reference/en/html_single/#persistent-classes-dynamicmodels'
 * onclick="window.open('http://www.hibernate.org/hib_docs/v3/reference/en/html_single/#persistent-classes-dynamicmodels');return
 * false;">"dynamic model"</a>
 *  mode is used.
 *  </ul>
 *  <P>
 *  Which mode to use is primarily a matter of preference and pre-existing code.  However, if
 *  you do not have pre-existing code or other special circumstances, the following approach is
 *  the most productive:
 *  <ol> 
 *  <li> use "beanless" mode, specifying fields in Smart GWT's .ds.xml format (far more
 *  compact than a Java bean with a getter and setter for each field)
 *  <li> add business logic as needed via DMI, custom server validators, and other approaches
 *  covered in the QuickStart Guide
 *  <li> call any reusable DMI methods both via your Smart GWT UI and via other, non-UI
 *  related Java logic (the DMI methods are now a reusable "data services tier")
 *  <li> only create an actual Java bean if you discover re-usable, bean-specific business
 *  logic that cannot be encapsulated as a data service (rare)
 *  </ol>
 *  <P>
 *  <b>Hibernate Configuration</b>
 *  <P>
 *  You can provide Hibernate configuration to the Smart GWT server in three ways:
 *  <ul>
 *  <li>You can place a traditional <code>hibernate.cfg.xml</code> file somewhere on the 
 *      classpath</li>
 *  <li>You can have Smart GWT look up a Hibernate <code>Configuration</code> to use.  This 
 *      works in the same way as a {@link com.smartgwt.client.docs.serverds.ServerObject}, and in fact makes use of the 
 *      ServerObject code.  To do this, add ServerObject-compliant properties to your 
 *      <code>server.properties</code> file, prefixed with <code>hibernate.config</code>.  For
 *      example: <pre>
 *         hibernate.config.lookupStyle: spring
 *         hibernate.config.bean: mySessionFactory
 *  </pre></li>
 *  <li>You can provide a Hibernate configuration at the level of individual DataSources, by 
 * specifying a {@link com.smartgwt.client.docs.serverds.DataSource#configBean configBean} on the dataSource (this is only 
 *      applicable if you are using Spring; see below)</li>
 *  </ul>
 *  If you choose to have Smart GWT lookup the Hibernate configuration, and you specify a 
 * {@link com.smartgwt.client.docs.serverds.ServerObject#lookupStyle lookupStyle} of "spring", Smart GWT will make use of a
 *  Hibernate <code>SessionFactory</code> configured by Spring.  It is possible to set up multiple
 *  Hibernate configurations in Spring, and to map individual DataSources to different 
 *  configurations by making use of the <code>dataSource.configBean</code> property mentioned
 *  above.  Please note the following caveats:
 *  <ul>
 *  <li>DataSource-level Hibernate configuration is intended for unusual cases, such as when the
 *      physical data store for one DataSource is actually a different database.  Hibernate 
 *      relations between entities with different configurations do not work</li>
 *  <li>Whilst it is possible to have traditional mapped beans alongside Smart GWT "beanless" 
 *      on-the-fly mappings, we cannot share the Hibernate configuration because on-the-fly 
 *      mapping requires the <code>SessionFactory</code> to be rebuilt for each new mapping.
 *      Spring will not allow this, so we fall back to a second Hibernate configuration, 
 *      specified via a .cfg.xml file as described above, for on-the-fly mappings.
 *  </ul>
 *  <P>
 *  <b>Mapping DSRequest/DSResponse to Hibernate</b>
 *  <P>
 *  This integration strategy uses the server-side Java APIs described in
 *  {@link com.smartgwt.client.docs.ServerDataIntegration}.  Two complete examples of Hibernate integration are
 * provided in the SDK, one using {@link com.smartgwt.client.docs.DmiOverview DMI} and one using {@link
 * com.smartgwt.client.rpc.RPCManager} dispatch.  Both
 *  are accessible from the SDK Explorer as Examples->Server Integration, and both include
 *  sample Hibernate configuration as well as a sample UI capable of loading and saving data.
 *  <ul>
 *  <li>
 * <a href='/examples/server_integration/index.html#customDataSourceIntegrationHibernate'
 * onclick="window.open('/examples/server_integration/index.html#customDataSourceIntegrationHibernate');return
 * false;">"Custom DataSource Integration with Hibernate"</a> 
 *  shows how to create a .jsp that uses RPCManager dispatch to implement all four DataSource
 *  request {@link com.smartgwt.client.data.DSRequest#getOperationType operationType}s via Hibernate for a sample bean.
 *  <li>
 * <a href='/examples/server_integration/index.html#springDSHiberateDMI'
 * onclick="window.open('/examples/server_integration/index.html#springDSHiberateDMI');return false;">"Spring DataSource
 * Integration using DMI to Hibernate"</a>
 * shows how to use Smart GWT Direct Method Invocation ({@link com.smartgwt.client.docs.DmiOverview DMI}) to implement all
 * four
 *  DataSource operations with Hibernate.  This particular example uses
 *  {@link com.smartgwt.client.docs.SpringIntegration Spring}-based lookup of the target for DMI, however, the same
 *  approach will work without Spring - see other DMI examples on the same page for non-Spring
 *  methods of DMI target lookup.
 *  </ul>
 *  As discussed under DMI, whether to use DMI or RPCManager dispatch is largely a matter
 *  of preference, however if you are already using Spring, a DMI-based approach is probably
 *  a better fit.
 *  <P>
 *  <b>serverType:"hibernate"</b>
 *  <P>
 *  As with DataSources using Smart GWT's built-in {@link com.smartgwt.client.docs.SqlDataSource SQL engine}, you
 *  need only {@link com.smartgwt.client.docs.DataSourceDeclaration create a DataSource} in XML format - no Java
 *  classes or other configuration are required.  The {@link com.smartgwt.client.docs.AdminConsole Admin Console}'s
 *  "Import DataSources" section can be used to import test data into serverType:"hibernate"
 *  DataSources in the same manner as SQLDataSources.
 *  <p/>
 *  <b>Hibernate relations</b>
 *  <p/>
 *  Hibernate data sources transparently support relations:<ul>
 *  <li>To specify many-to-one relation you have to declare it in data source definition with property
 * {@link com.smartgwt.client.data.DataSourceField#getForeignKey foreignKey} pointing to releted data source's primary key:
 *           <pre>
 *               &lt;field name="country" foreignKey="countryManyToOne.countryId"/&gt;
 *           </pre>
 *  Client-side will recieve only ID of related entity while server-side will use real related entity loaded from data
 *  base.<p/>
 *  You can instruct data source to send encapsulated related entity by setting
 *  {@link com.smartgwt.client.data.DataSourceField#getType type} property to the name of related data source:
 *           <pre>
 *               &lt;field name="country" type="countryManyToOne" foreignKey="countryManyToOne.countryId"/&gt;
 *           </pre>
 *  </li>
 *  <li>To specify one-to-many relation you have to declare it in data source definition with property
 * {@link com.smartgwt.client.data.DataSourceField#getForeignKey foreignKey} pointing to releted data source's primary key
 * and
 *  property {@link com.smartgwt.client.data.DataSourceField#getMultiple multiple} set to <code>true<code>:
 *           <pre>
 *               &lt;field name="cities" multiple="true" foreignKey="cityOneToMany.cityId"/&gt;
 *           </pre>
 *  Client-side will recieve only list of related ID's while server-side will use real related entity list loaded from
 *  data base.<p/>
 *  You can instruct data source to send list of encapsulated related entities by setting
 *  {@link com.smartgwt.client.data.DataSourceField#getType type} property to the name of related data source:
 *           <pre>
 *               &lt;field name="cities" multiple="true" type="cityOneToMany" foreignKey="cityOneToMany.cityId"/&gt;
 *           </pre>
 *  Saving parent entity automatically makes all required Hibernate calls to synchronize underlying list.
 *  </li>
 *  </ul>
 *  <b>Notes on bidirectional relations</b>:<ul>
 *  <li>When encapsulated related entity is sent to client it will not have
 *  reference to parent object (avoided recursion).</li>
 *  <li>Make sure you are updating "owning" side of relation. All changes to "non-owning" relation side
 *  are silently discarded.</li></ul><p/>
 */
public interface HibernateIntegration {
}
