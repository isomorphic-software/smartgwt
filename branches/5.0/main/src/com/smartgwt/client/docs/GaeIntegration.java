
package com.smartgwt.client.docs;

/**
 * <h3>Google Application Engine (GAE)</h3>
 * <a href='http://code.google.com/appengine/' onclick="window.open('http://code.google.com/appengine/');return
 * false;">GAE</a> supports
 * <a href='http://code.google.com/appengine/docs/java/overview.html'
 * onclick="window.open('http://code.google.com/appengine/docs/java/overview.html');return false;">Java applications</a>.
 *  Google provides a great infrastructure for web applications. It takes care of many web
 *  application developer's headaches: hardware, operating system support, backups, scaling,
 *  security, mail etc. To run under GAE your application has to comply to GAE rules.
 *  The biggest difference is GAE datastore - it is not a relational database - instead they use
 * something called <a href='http://en.wikipedia.org/wiki/BigTable'
 * onclick="window.open('http://en.wikipedia.org/wiki/BigTable');return false;">BigTable</a>. To simplify development,
 *  Google has adopted
 * <a href='http://www.datanucleus.org/products/accessplatform/'
 * onclick="window.open('http://www.datanucleus.org/products/accessplatform/');return false;">DataNucleus Access
 * Platform</a>
 *  to provide
 * <a href='http://code.google.com/appengine/docs/java/datastore/usingjpa.html'
 * onclick="window.open('http://code.google.com/appengine/docs/java/datastore/usingjpa.html');return false;">JPA 1.0
 * support</a>.
 *  Because GAE datastore is not a relational database
 * <a href='http://code.google.com/appengine/docs/java/datastore/usingjpa.html#Unsupported_Features_of_JPA'
 * onclick="window.open('http://code.google.com/appengine/docs/java/datastore/usingjpa.html#Unsupported_Features_of_JPA');return
 * false;">some JPA features</a>
 *  are not supported by this JPA implementation.
 *  <p/>
 *  <b>Setting up Smart GWT application for GAE</b>
 *  <p/>
 *  Under the <code>/WEB-INF</code> directory you have to create a file named
 * <a href='http://code.google.com/appengine/docs/java/config/appconfig.html'
 * onclick="window.open('http://code.google.com/appengine/docs/java/config/appconfig.html');return
 * false;"><code>appengine-web.xml</code></a>
 *  which will hold Google's specific settings.<br/>
 *  One important thing to note: static and dynamic contents will be served from different servers.
 *  There are
 * <a href='http://code.google.com/appengine/docs/java/config/appconfig.html#Static_Files_and_Resource_Files'
 * onclick="window.open('http://code.google.com/appengine/docs/java/config/appconfig.html#Static_Files_and_Resource_Files');return
 * false;">special sections</a>
 *  in
 * <a href='http://code.google.com/appengine/docs/java/config/appconfig.html'
 * onclick="window.open('http://code.google.com/appengine/docs/java/config/appconfig.html');return
 * false;"><code>appengine-web.xml</code></a>
 *  specifying static and dynamic resources. All resources are duplicated if not specified.
 *  A single GAE application is limited to 3000 files. A typical Smart GWT application consists of many
 *  resources and it exceeds the limit when duplicated (even with a single theme).
 *  To run a Smart GWT application we have to split resources. Here is an example configuration:<pre>
 *  &lt;?xml version="1.0" encoding="UTF-8"?&gt;
 *  &lt;appengine-web-app xmlns="http://appengine.google.com/ns/1.0"&gt;
 *      &lt;application&gt;GAE_APPLICATION_NAME&lt;/application&gt;
 *      &lt;version&gt;1&lt;/version&gt;
 *      &lt;static-files&gt;
 *          &lt;include path="/index.jsp"/&gt;
 *          &lt;include path="/[MODULE_NAME]/**"/&gt;
 *          &lt;exclude path="/[MODULE_NAME]/**.xml"/&gt;
 *          &lt;exclude path="/[MODULE_NAME]/**.xsl"/&gt;
 *          &lt;exclude path="/[MODULE_NAME]/**.wsdl"/&gt;
 *      &lt;/static-files&gt;
 *      &lt;resource-files&gt;
 *          &lt;include path="/[PATH_TO_DATA_SOURCE_FILES]/**"/&gt;
 *          &lt;include path="/[MODULE_NAME]/**.xml"/&gt;
 *          &lt;include path="/[MODULE_NAME]/**.xsl"/&gt;
 *          &lt;include path="/[MODULE_NAME]/**.wsdl"/&gt;
 *      &lt;/resource-files&gt;
 *  &lt;/appengine-web-app&gt;
 *  </pre>
 *  To interact with DataSources an additional servlet mapping has to be added to
 *  <code>web.xml</code>:<pre>
 *  &lt;servlet-mapping&gt;
 *      &lt;servlet-name&gt;IDACall&lt;/servlet-name&gt;
 *      &lt;url-pattern&gt;/[MODULE_NAME]/sc/IDACall&lt;/url-pattern&gt;
 *  &lt;/servlet-mapping&gt;
 *  </pre>
 *  <p/>
 *  <b>Setting up DataSources</b>
 *  <p/>
 *  GAE supports only four types as primary keys:<ul>
 *  <li><code>java.lang.Long</code></li>
 *  <li><code>java.lang.String</code></li>
 *  <li><code>java.lang.String</code> with additional annotations</li>
 *  <li><code>com.google.appengine.api.datastore.Key</code> <b>not supported by Smart GWT</b></li>
 *  </ul>
 *  Primary key can not be altered after entity is saved.<br/>
 *  Entities with primary keys <code>Long</code> or <code>String</code> can not participate in
 *  transactions and can not be used in relations.
 *  Here is an example how to declare primary key of type <code>String</code> with additional
 *  annotations:<pre>
 *  import java.io.Serializable;
 *  import javax.persistence.Entity;
 *  import javax.persistence.GeneratedValue;
 *  import javax.persistence.GenerationType;
 *  import javax.persistence.Id;
 *  import org.datanucleus.jpa.annotations.Extension;
 * 
 *  &#64;Entity
 *  public class Bar
 *      implements Serializable
 *  {
 *     &#64;Id
 *     &#64;GeneratedValue (strategy = GenerationType.IDENTITY)
 *     &#64;Extension (vendorName = "datanucleus", key = "gae.encoded-pk", value = "true")
 *     private String id;
 *  }
 *  </pre>
 *  DataSource creation is similar to {@link com.smartgwt.client.docs.JpaIntegration standard JPA} with one
 * difference: property <b><code>{@link com.smartgwt.client.docs.serverds.DataSource#serverConstructor
 * serverConstructor}</code></b>
 *  should be set to <b><code>com.isomorphic.jpa.GAEJPADataSource</code></b>.<br/>
 *  Because of
 * <a href='http://code.google.com/intl/en/appengine/docs/java/datastore/queriesandindexes.html#Restrictions_on_Queries'
 * onclick="window.open('http://code.google.com/intl/en/appengine/docs/java/datastore/queriesandindexes.html#Restrictions_on_Queries');return
 * false;">GAE queries limitations</a>
 *  this DataSource implementation supports only single inequality criteria in filter.<br/>
 *  Only <code>TextMatchStyle.STARTS_WITH</code> filtering mode is supported for text fields.<br/>
 *  All queries are case sensitive because GAE does not support <code>upper()/lower()</code> functions in criterias.<br/>
 *  <code>TextMatchStyle.EXACT</code> is used for all number fields.<br/>
 *  <b><code>com.isomorphic.jpa.EMFProviderLMT</code></b> or
 *  <b><code>com.isomorphic.jpa.EMFProviderNoTransactions</code></b> should be used as
 *  transaction providers (depending whether you use transactions or not).<br/>
 *  To participate in a transaction, entities have
 *  to belong to the
 * <a href='http://code.google.com/intl/en/appengine/docs/java/datastore/transactions.html'
 * onclick="window.open('http://code.google.com/intl/en/appengine/docs/java/datastore/transactions.html');return
 * false;">same group</a>.<br/>
 *  Note: entities of different type can not participate in a transaction even if these
 *  entities have GAE specific primary key (you can not even fetch (SELECT) entities belonging
 *  to different groups).
 *  <p/>
 * <b><a href='http://code.google.com/intl/en/appengine/docs/java/datastore/relationships.html'
 * onclick="window.open('http://code.google.com/intl/en/appengine/docs/java/datastore/relationships.html');return
 * false;">Relationships</a></b>
 *  <p/>
 *  Entities are grouped by establishing owned relationships (where dependent entities are
 *  instantiated automatically by the JPA provider) between them. Entities in groups can form a
 *  chain of the following sort::<pre>
 *  ClassA has reference to ClassB,
 *  ClassB has reference to ClassC
 *  </pre>
 *  But it is impossible to have an entity referencing two other entities:<pre>
 *  ClassD has reference to ClassE,
 *  ClassD has reference to ClassF
 *  </pre>
 *  There are no foreign keys - the actual reference is encoded into the primary key of child entity.<br/>
 *  GAE datastore does not support many-to-many relationships.<br/>
 *  Unidirectional one-to-many relationships work only if the parent has a declaration of
 *  <code>List&lt;ChildEntityClass&gt;</code>.<br/>
 *  Unidirectional relationships do not work if only the child entity has reference to the parent.<br/>
 *  Bidirectional relationship example:<pre>
 *  &#64;Entity
 *  public class Country
 *      implements Serializable
 *  {
 *      &#64;Id
 *      &#64;Column (nullable = false)
 *      &#64;GeneratedValue (strategy = GenerationType.IDENTITY)
 *      &#64;Extension (vendorName = "datanucleus", key = "gae.encoded-pk", value = "true")
 *      private String countryId;
 * 
 *      &#64;OneToMany
 *      private List<City> cities;
 *  //....
 *  }
 * 
 *  &#64;Entity
 *  public class City
 *      implements Serializable
 *  {
 *      &#64;Id
 *      &#64;Column (nullable = false)
 *      &#64;GeneratedValue (strategy = GenerationType.IDENTITY)
 *      &#64;Extension (vendorName = "datanucleus", key = "gae.encoded-pk", value = "true")
 *      private String cityId;
 * 
 *      // This is fake column - it is calculated by provider and is not saved.
 *      // Actual reference to parent entity is encoded in primary key.
 *      &#64;Column (nullable = false)
 *      &#64;Extension (vendorName = "datanucleus", key = "gae.parent-pk", value = "true")
 *      private String countryId;
 * 
 *      &#64;ManyToOne (fetch=FetchType.LAZY)
 *      private Country country;
 *  //....
 *  }
 *  </pre>
 *  Note: GAE does not support <code>FetchType.EAGER</code>.
 *  <p/> With
 * <b><a href='http://code.google.com/intl/en/appengine/docs/java/datastore/relationships.html#Unowned_Relationships'
 * onclick="window.open('http://code.google.com/intl/en/appengine/docs/java/datastore/relationships.html#Unowned_Relationships');return
 * false;">Unowned Relationships</a></b>
 *  (when you save parent's primary key as simple child's property) you can model unsupported
 *  relationships. But this approach has drawbacks:<ul>
 *  <li>related entities are not instantiated automatically</li>
 *  <li>transactions can not be used</li>
 *  <li>you have to manually keep track of changes in case of bidirectional relationship</li>
 *  </ul>
 */
public interface GaeIntegration {
}
