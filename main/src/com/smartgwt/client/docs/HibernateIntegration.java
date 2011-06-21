
package com.smartgwt.client.docs;

/**
 * <h3>Integration with Hibernate</h3>
 * Smart GWT can integrate with Hibernate in two main ways, both of which are enabled by&#010 creating a DataSource
 * descriptor (.ds.xml file) with&#010 {@link com.smartgwt.client.docs.serverds.DataSource#serverType
 * serverType="hibernate"}:&#010 <ul>&#010 <li> Pre-existing beans: a Smart GWT DataSource can be automatically derived
 * from either a&#010 Hibernate-managed bean or the Hibernate mapping.  Use&#010 {@link
 * com.smartgwt.client.docs.serverds.DataSource#schemaBean schemaBean} to derive from the bean or&#010 {@link
 * com.smartgwt.client.docs.serverds.DataSource#autoDeriveSchema autoDeriveSchema} to derive from the mapping.  In this
 * case you will&#010 initially have a very short .ds.xml per bean - no &lt;fields&gt; are required unless&#010 and until
 * you want to override the automatically derived fields.&#010 <li> "Beanless" mode: Smart GWT can drive Hibernate as a
 * storage layer only, automatically&#010 generating Hibernate configuration from a Smart GWT DataSource file&#010
 * (<i>dataSourceID</i>.ds.xml).  In this case, you do not write a Java bean or create&#010 Hibernate mappings; Hibernate's
 * beanless&#010 <a href='http://www.hibernate.org/hib_docs/v3/reference/en/html_single/#persistent-classes-dynamicmodels'
 * onclick="window.open('http://www.hibernate.org/hib_docs/v3/reference/en/html_single/#persistent-classes-dynamicmodels');return
 * false;">"dynamic model"</a>&#010 mode is used.&#010 </ul>&#010 <P>&#010 Which mode to use is primarily a matter of
 * preference and pre-existing code.  However, if&#010 you do not have pre-existing code or other special circumstances,
 * the following approach is&#010 the most productive:&#010 <ol> &#010 <li> use "beanless" mode, specifying fields in Smart
 * GWT's .ds.xml format (far more&#010 compact than a Java bean with a getter and setter for each field)&#010 <li> add
 * business logic as needed via DMI, custom server validators, and other approaches&#010 covered in the QuickStart
 * Guide&#010 <li> call any reusable DMI methods both via your Smart GWT UI and via other, non-UI&#010 related Java logic
 * (the DMI methods are now a reusable "data services tier")&#010 <li> only create an actual Java bean if you discover
 * re-usable, bean-specific business&#010 logic that cannot be encapsulated as a data service (rare)&#010 </ol>&#010
 * <P>&#010 <b>Hibernate Configuration</b>&#010 <P>&#010 You can provide Hibernate configuration to the Smart GWT server in
 * three ways:&#010 <ul>&#010 <li>You can place a traditional <code>hibernate.cfg.xml</code> file somewhere on the &#010   
 * classpath</li>&#010 <li>You can have Smart GWT look up a Hibernate <code>Configuration</code> to use.  This &#010    
 * works in the same way as a {@link com.smartgwt.client.docs.serverds.ServerObject}, and in fact makes use of the &#010   
 * ServerObject code.  To do this, add ServerObject-compliant properties to your &#010     <code>server.properties</code>
 * file, prefixed with <code>hibernate.config</code>.  For&#010     example: <pre>&#010       
 * hibernate.config.lookupStyle: spring&#010        hibernate.config.bean: mySessionFactory&#010 </pre></li>&#010 <li>You
 * can provide a Hibernate configuration at the level of individual DataSources, by &#010     specifying a {@link
 * com.smartgwt.client.docs.serverds.DataSource#configBean configBean} on the dataSource (this is only &#010     applicable
 * if you are using Spring; see below)</li>&#010 </ul>&#010 If you choose to have Smart GWT lookup the Hibernate
 * configuration, and you specify a &#010 {@link com.smartgwt.client.docs.serverds.ServerObject#lookupStyle lookupStyle} of
 * "spring", Smart GWT will make use of a&#010 Hibernate <code>SessionFactory</code> configured by Spring.  It is possible
 * to set up multiple&#010 Hibernate configurations in Spring, and to map individual DataSources to different &#010
 * configurations by making use of the <code>dataSource.configBean</code> property mentioned&#010 above.  Please note the
 * following caveats:&#010 <ul>&#010 <li>DataSource-level Hibernate configuration is intended for unusual cases, such as
 * when the&#010     physical data store for one DataSource is actually a different database.  Hibernate &#010    
 * relations between entities with different configurations do not work</li>&#010 <li>Whilst it is possible to have
 * traditional mapped beans alongside Smart GWT "beanless" &#010     on-the-fly mappings, we cannot share the Hibernate
 * configuration because on-the-fly &#010     mapping requires the <code>SessionFactory</code> to be rebuilt for each new
 * mapping.&#010     Spring will not allow this, so we fall back to a second Hibernate configuration, &#010     specified
 * via a .cfg.xml file as described above, for on-the-fly mappings.&#010 </ul>&#010 <P>&#010 <b>Mapping
 * DSRequest/DSResponse to Hibernate</b>&#010 <P>&#010 This integration strategy uses the server-side Java APIs described
 * in&#010 {@link com.smartgwt.client.docs.ServerDataIntegration}.  Two complete examples of Hibernate integration are&#010
 * provided in the SDK, one using {@link com.smartgwt.client.docs.DmiOverview DMI} and one using {@link
 * com.smartgwt.client.rpc.RPCManager} dispatch.  Both&#010 are accessible from the SDK Explorer as Examples->Server
 * Integration, and both include&#010 sample Hibernate configuration as well as a sample UI capable of loading and saving
 * data.&#010 <ul>&#010 <li>&#010 <a href='/examples/server_integration/index.html#customDataSourceIntegrationHibernate'
 * onclick="window.open('/examples/server_integration/index.html#customDataSourceIntegrationHibernate');return
 * false;">"Custom DataSource Integration with Hibernate"</a> &#010 shows how to create a .jsp that uses RPCManager
 * dispatch to implement all four DataSource&#010 request {@link com.smartgwt.client.data.DSRequest#getOperationType
 * operationType}s via Hibernate for a sample bean.&#010 <li>&#010 <a
 * href='/examples/server_integration/index.html#springDSHiberateDMI'
 * onclick="window.open('/examples/server_integration/index.html#springDSHiberateDMI');return false;">"Spring DataSource
 * Integration using DMI to Hibernate"</a>&#010 shows how to use Smart GWT Direct Method Invocation ({@link
 * com.smartgwt.client.docs.DmiOverview DMI}) to implement all four&#010 DataSource operations with Hibernate.  This
 * particular example uses&#010 {@link com.smartgwt.client.docs.SpringIntegration Spring}-based lookup of the target for
 * DMI, however, the same&#010 approach will work without Spring - see other DMI examples on the same page for
 * non-Spring&#010 methods of DMI target lookup.&#010 </ul>&#010 As discussed under DMI, whether to use DMI or RPCManager
 * dispatch is largely a matter&#010 of preference, however if you are already using Spring, a DMI-based approach is
 * probably&#010 a better fit.&#010 <P>&#010 <b>serverType:"hibernate"</b>&#010 <P>&#010 As with DataSources using Smart
 * GWT's built-in {@link com.smartgwt.client.docs.SqlDataSource SQL engine}, you&#010 need only {@link
 * com.smartgwt.client.docs.DataSourceDeclaration create a DataSource} in XML format - no Java&#010 classes or other
 * configuration are required.  The {@link com.smartgwt.client.docs.AdminConsole Admin Console}'s&#010 "Import DataSources"
 * section can be used to import test data into serverType:"hibernate"&#010 DataSources in the same manner as
 * SQLDataSources.&#010 <p/>&#010 <b>Hibernate relations</b>&#010 <p/>&#010 Hibernate data sources transparently support
 * relations:<ul>&#010 <li>To specify many-to-one relation you have to declare it in data source definition with
 * property&#010 {@link com.smartgwt.client.data.DataSourceField#getForeignKey foreignKey} pointing to releted data
 * source's primary key:&#010          <pre>&#010              &lt;field name="country"
 * foreignKey="countryManyToOne.countryId"/&gt;&#010          </pre>&#010 Client-side will recieve only ID of related
 * entity while server-side will use real related entity loaded from data&#010 base.<p/>&#010 You can instruct data source
 * to send encapsulated related entity by setting&#010 {@link com.smartgwt.client.data.DataSourceField#getType type}
 * property to the name of related data source:&#010          <pre>&#010              &lt;field name="country"
 * type="countryManyToOne" foreignKey="countryManyToOne.countryId"/&gt;&#010          </pre>&#010 </li>&#010 <li>To specify
 * one-to-many relation you have to declare it in data source definition with property&#010 {@link
 * com.smartgwt.client.data.DataSourceField#getForeignKey foreignKey} pointing to releted data source's primary key
 * and&#010 property {@link com.smartgwt.client.data.DataSourceField#getMultiple multiple} set to <code>true<code>:&#010   
 * <pre>&#010              &lt;field name="cities" multiple="true" foreignKey="cityOneToMany.cityId"/&gt;&#010         
 * </pre>&#010 Client-side will recieve only list of related ID's while server-side will use real related entity list
 * loaded from&#010 data base.<p/>&#010 You can instruct data source to send list of encapsulated related entities by
 * setting&#010 {@link com.smartgwt.client.data.DataSourceField#getType type} property to the name of related data
 * source:&#010          <pre>&#010              &lt;field name="cities" multiple="true" type="cityOneToMany"
 * foreignKey="cityOneToMany.cityId"/&gt;&#010          </pre>&#010 Saving parent entity automatically makes all required
 * Hibernate calls to synchronize underlying list.&#010 </li>&#010 </ul>&#010 <b>Notes on bidirectional
 * relations</b>:<ul>&#010 <li>When encapsulated related entity is sent to client it will not have&#010 reference to parent
 * object (avoided recursion).</li>&#010 <li>Make sure you are updating "owning" side of relation. All changes to
 * "non-owning" relation side&#010 are silently discarded.</li></ul><p/>
 */
public interface HibernateIntegration {
}
