	    
package com.smartgwt.client.docs;

/**
 * <h3>Integration with Hibernate</h3>
 * Smart GWT can integrate with Hibernate in two main ways, both of which are enabled by
 *  creating a DataSource descriptor (.ds.xml file) with
 *  {@link com.smartgwt.client.docs.serverds.DataSource#serverType serverType="hibernate"}:
 *  <ul>
 *  <li> Pre-existing beans: a Smart GWT DataSource can be automatically derived from either a
 *  Hibernate-managed bean or the Hibernate mapping.  Use
 * {@link com.smartgwt.client.docs.serverds.DataSource#schemaBean schemaBean} to derive from the
 * bean or
 * {@link com.smartgwt.client.docs.serverds.DataSource#autoDeriveSchema autoDeriveSchema} to
 * derive from the mapping.  In this case you will
 *  initially have a very short .ds.xml per bean - no &lt;fields&gt; are required unless
 *  and until you want to override the automatically derived fields.
 *  <li> "Beanless" mode: Smart GWT can drive Hibernate as a storage layer only, automatically
 *  generating Hibernate configuration from a Smart GWT DataSource file
 *  (<i>dataSourceID</i>.ds.xml).  In this case, you do not write a Java bean or create
 *  Hibernate mappings; Hibernate's beanless
 * <a
 * href='http://www.hibernate.org/hib_docs/v3/reference/en/html_single/#persistent-classes-dynamicmodels'
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
 *  <li> add business logic as needed via DMI, Server Scripting, custom server validators, and
 *  other approaches covered in the QuickStart Guide
 *  <li> call any reusable DMI methods both via your Smart GWT UI and via other, non-UI
 *  related Java logic (the DMI methods are now a reusable "data services tier")
 *  <li> only create an actual Java bean if you discover re-usable, bean-specific business
 *  logic that cannot be encapsulated as a data service (rare)
 *  </ol>
 *  <P>
 *  Note that the {@link com.smartgwt.client.docs.AdminConsole Admin Console}'s
 *  "Import DataSources" section can be used to import test data into serverType:"hibernate"
 *  DataSources in the same manner as SQLDataSources.
 *  <p>
 * HibernateDataSource supports operations with composite primary keys. Setting data source level
 * property
 * {@link com.smartgwt.client.docs.serverds.DataSource#idClassName idClassName} to fully qualified
 * class name indicates,
 *  that entity uses composite primary key.
 *  <p>
 *  <h3>Hibernate relations</h3>
 *  <p>
 *  For Hibernate integration where Java beans have been explicitly declared,
 *  HibernateDataSource supports automatic handling of Hibernate relations that don't declare a
 *  concrete field to hold ID values - see {@link com.smartgwt.client.docs.JpaHibernateRelations}.
 *  <p>
 *  <h3>Hibernate Configuration</h3>
 *  <p>
 *  You can provide Hibernate configuration to the Smart GWT server in three ways:
 *  <ul>
 *  <li>You can place a traditional <code>hibernate.cfg.xml</code> file somewhere on the 
 *      classpath</li>
 *  <li>You can have Smart GWT look up a Hibernate <code>Configuration</code> to use.  This 
 * works in the same way as a {@link com.smartgwt.client.docs.serverds.ServerObject}, and in fact
 * makes use of the 
 *      ServerObject code, though note that lookupStyle "attribute" is not supported.  To look 
 *      up a configuration, add ServerObject-compliant properties to your 
 *      <code>server.properties</code> file, prefixed with <code>hibernate.config</code>.  For
 *      example: <pre>
 *         hibernate.config.lookupStyle: spring
 *         hibernate.config.bean: mySessionFactory
 *  </pre></li>
 *  <li>You can provide a Hibernate configuration at the level of individual DataSources, by 
 * specifying a {@link com.smartgwt.client.docs.serverds.DataSource#configBean configBean} on the
 * dataSource (this is only 
 *      applicable if you are using Spring; see below)</li>
 *  </ul>
 *  If you choose to have Smart GWT lookup the Hibernate configuration, and you specify a 
 * {@link com.smartgwt.client.docs.serverds.ServerObject#lookupStyle lookupStyle} of "spring",
 * Smart GWT will make use of a
 *  Hibernate <code>SessionFactory</code> configured by Spring.  It is possible to set up multiple
 *  Hibernate configurations in Spring, and to map individual DataSources to different 
 *  configurations by making use of the <code>dataSource.configBean</code> property mentioned
 *  above.  Please note the following caveats:
 *  <ul>
 *  <li>DataSource-level Hibernate configuration is intended for unusual cases, such as when the
 *      physical data store for one DataSource is actually a different database.  Hibernate 
 *      relations between entities with different configurations do not work</li>
 *  <li>If you choose to configure Hibernate via Spring, "beanless" on-the-fly 
 *      mappings are not supported; all entities must be hand-mapped to a bean, either in the 
 *      properties of the Spring bean providing the configuration, in a <code>.cfg.xml</code>
 *      file named in the Spring bean's <code>configLocation</code> property, or by use of 
 *      persistence annotations in the actual mapped beans themselves</li>
 *  </ul>
 *  <p>
 *  <h3>Manual Hibernate Integration</h3>
 *  <p>
 *  In some cases you may not be able to immediately use the built-in HibernateDataSource - in
 * this case take a look at {@link com.smartgwt.client.docs.ManualJpaHibernate manual Hibernate
 * integration}.
 */
public interface HibernateIntegration {
}
