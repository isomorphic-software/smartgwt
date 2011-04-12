
package com.smartgwt.client.docs;

/**
 * <h3>Google Application Engine (GAE)</h3>
 * <a href='http://code.google.com/appengine/' onclick="window.open('http://code.google.com/appengine/');return
 * false;">GAE</a> supports&#010 <a href='http://code.google.com/appengine/docs/java/overview.html'
 * onclick="window.open('http://code.google.com/appengine/docs/java/overview.html');return false;">Java
 * applications</a>.&#010 Google provides great infrastructure for web applications. It takes care of many web&#010
 * application developer's headaches: hardware, operating system support, backups, scaling,&#010 security, mail etc. To run
 * under GAE your application has to comply to GAE rules.&#010 Biggest difference is GAE datastore - it is not relational
 * database - it is&#010 <a href='http://en.wikipedia.org/wiki/BigTable'
 * onclick="window.open('http://en.wikipedia.org/wiki/BigTable');return false;">BigTable</a>. To simplify development&#010
 * Google has adopted&#010 <a href='http://www.datanucleus.org/products/accessplatform/'
 * onclick="window.open('http://www.datanucleus.org/products/accessplatform/');return false;">DataNucleus Access
 * Platform</a>&#010 to provide&#010 <a href='http://code.google.com/appengine/docs/java/datastore/usingjpa.html'
 * onclick="window.open('http://code.google.com/appengine/docs/java/datastore/usingjpa.html');return false;">JPA 1.0
 * support</a>.&#010 Because GAE datastore is not relational database&#010 <a
 * href='http://code.google.com/appengine/docs/java/datastore/usingjpa.html#Unsupported_Features_of_JPA'
 * onclick="window.open('http://code.google.com/appengine/docs/java/datastore/usingjpa.html#Unsupported_Features_of_JPA');return
 * false;">some JPA features</a>&#010 are not supported by this JPA implementation.&#010 <p/>&#010 <b>Setting up Smart GWT
 * application for GAE</b>&#010 <p/>&#010 Under <code>/WEB-INF</code> directory you have to create file&#010 <a
 * href='http://code.google.com/appengine/docs/java/config/appconfig.html'
 * onclick="window.open('http://code.google.com/appengine/docs/java/config/appconfig.html');return
 * false;"><code>appengine-web.xml</code></a>&#010 which will hold Google's specific settings.<br/>&#010 Important thing to
 * note: static and dynamic contents will be served from different servers.&#010 There are&#010 <a
 * href='http://code.google.com/appengine/docs/java/config/appconfig.html#Static_Files_and_Resource_Files'
 * onclick="window.open('http://code.google.com/appengine/docs/java/config/appconfig.html#Static_Files_and_Resource_Files');return
 * false;">special sections</a>&#010 in&#010 <a href='http://code.google.com/appengine/docs/java/config/appconfig.html'
 * onclick="window.open('http://code.google.com/appengine/docs/java/config/appconfig.html');return
 * false;"><code>appengine-web.xml</code></a>&#010 specifying static and dynamic resources. All resources are duplicated if
 * not specified.&#010 Single GAE application is limited to 3000 files. Smart GWT application consists of many&#010
 * resources and it exceeds limit when they are duplicated (even with single theme).&#010 To run Smart GWT application we
 * have to differ resources. Here is an example configuration:<pre>&#010 &lt;?xml version="1.0" encoding="UTF-8"?&gt;&#010
 * &lt;appengine-web-app xmlns="http://appengine.google.com/ns/1.0"&gt;&#010    
 * &lt;application&gt;GAE_APPLICATION_NAME&lt;/application&gt;&#010     &lt;version&gt;1&lt;/version&gt;&#010    
 * &lt;static-files&gt;&#010         &lt;include path="/index.jsp"/&gt;&#010         &lt;include
 * path="/[MODULE_NAME]/**"/&gt;&#010         &lt;exclude path="/[MODULE_NAME]/**.xml"/&gt;&#010         &lt;exclude
 * path="/[MODULE_NAME]/**.xsl"/&gt;&#010         &lt;exclude path="/[MODULE_NAME]/**.wsdl"/&gt;&#010    
 * &lt;/static-files&gt;&#010     &lt;resource-files&gt;&#010         &lt;include
 * path="/[PATH_TO_DATA_SOURCE_FILES]/**"/&gt;&#010         &lt;include path="/[MODULE_NAME]/**.xml"/&gt;&#010        
 * &lt;include path="/[MODULE_NAME]/**.xsl"/&gt;&#010         &lt;include path="/[MODULE_NAME]/**.wsdl"/&gt;&#010    
 * &lt;/resource-files&gt;&#010 &lt;/appengine-web-app&gt;&#010 </pre>&#010 To interact with DataSources additional servlet
 * mapping has to be added to&#010 <code>web.xml</code>:<pre>&#010 &lt;servlet-mapping&gt;&#010    
 * &lt;servlet-name&gt;IDACall&lt;/servlet-name&gt;&#010    
 * &lt;url-pattern&gt;/[MODULE_NAME]/sc/IDACall&lt;/url-pattern&gt;&#010 &lt;/servlet-mapping&gt;&#010 </pre>&#010
 * <p/>&#010 <b>Setting up DataSources</b>&#010 <p/>&#010 GAE supports only four types as primary keys:<ul>&#010
 * <li><code>java.lang.Long</code></li>&#010 <li><code>java.lang.String</code></li>&#010 <li><code>java.lang.String</code>
 * with additional annotations</li>&#010 <li><code>com.google.appengine.api.datastore.Key</code> <b>not supported by Smart
 * GWT</b></li>&#010 </ul>&#010 Primary key can not be altered after entity is saved.<br/>&#010 Entities with primary keys
 * <code>Long</code> or <code>String</code> can not participate in&#010 transactions and can not be used in relations.&#010
 * Here is an example how to declare primary key of type <code>String</code> with additional&#010 annotations:<pre>&#010
 * import java.io.Serializable;&#010 import javax.persistence.Entity;&#010 import javax.persistence.GeneratedValue;&#010
 * import javax.persistence.GenerationType;&#010 import javax.persistence.Id;&#010 import
 * org.datanucleus.jpa.annotations.Extension;&#010&#010 &#64;Entity&#010 public class Bar&#010     implements
 * Serializable&#010 {&#010    &#64;Id&#010    &#64;GeneratedValue (strategy = GenerationType.IDENTITY)&#010   
 * &#64;Extension (vendorName = "datanucleus", key = "gae.encoded-pk", value = "true")&#010    private String id;&#010
 * }&#010 </pre>&#010 DataSource creation is similar to {@link com.smartgwt.client.docs.JpaIntegration standard JPA} with
 * single&#010 difference: property <b><code>{@link com.smartgwt.client.docs.serverds.DataSource#serverConstructor
 * serverConstructor}</code></b>&#010 should be set to <b><code>com.isomorphic.jpa.GAEJPADataSource</code></b>.<br/>&#010
 * Because of&#010 <a
 * href='http://code.google.com/intl/en/appengine/docs/java/datastore/queriesandindexes.html#Restrictions_on_Queries'
 * onclick="window.open('http://code.google.com/intl/en/appengine/docs/java/datastore/queriesandindexes.html#Restrictions_on_Queries');return
 * false;">GAE queries limitations</a>&#010 this DataSource implementation supports only single inequality criteria in
 * filter.&#010 Only <code>TextMatchStyle.STARTS_WITH</code> filtering mode supported for text fields.<br/>&#010
 * <b><code>com.isomorphic.jpa.EMFProviderLMT</code></b> or&#010
 * <b><code>com.isomorphic.jpa.EMFProviderNoTransactions</code></b> should be used as&#010 transaction providers (depending
 * whether you use transactions or not).<br/>&#010 To participate in single transaction entities have&#010 to belong to
 * the&#010 <a href='http://code.google.com/intl/en/appengine/docs/java/datastore/transactions.html'
 * onclick="window.open('http://code.google.com/intl/en/appengine/docs/java/datastore/transactions.html');return
 * false;">same group</a>.<br/>&#010 Note: entities of different type can not participate in single transaction even if
 * these&#010 entities have GAE specific primary key (you can not even fetch (SELECT) entities belonging&#010 to different
 * groups).&#010 <p/>&#010 <b><a href='http://code.google.com/intl/en/appengine/docs/java/datastore/relationships.html'
 * onclick="window.open('http://code.google.com/intl/en/appengine/docs/java/datastore/relationships.html');return
 * false;">Relationships</a></b>&#010 <p/>&#010 Entities are grouped by establishing owned relationships (where dependent
 * entities are&#010 instantiated automatically by JPA provider) between them. Entities in groups can form kind&#010 of
 * chain:<pre>&#010 ClassA has reference to ClassB,&#010 ClassB has reference to ClassC&#010 </pre>&#010 But it is
 * impossible to have entity referencing two other entities:<pre>&#010 ClassD has reference to ClassE,&#010 ClassD has
 * reference to ClassF&#010 </pre>&#010 There is no foreign keys - actual reference is encoded into primary key of child
 * entity.<br/>&#010 GAE datastore does not support many-to-many relationship.<br/>&#010 Unidirectional one-to-many
 * relationship works only if parent has declaration of&#010 <code>List&lt;ChildEntityClass&gt;</code>.<br/>&#010
 * Unidirectional relationship does not work if only child entity has reference to parent.<br/>&#010 Bidirectional
 * relationship example:<pre>&#010 &#64;Entity&#010 public class Country&#010     implements Serializable&#010 {&#010    
 * &#64;Id&#010     &#64;Column (nullable = false)&#010     &#64;GeneratedValue (strategy = GenerationType.IDENTITY)&#010  
 * &#64;Extension (vendorName = "datanucleus", key = "gae.encoded-pk", value = "true")&#010     private String
 * countryId;&#010&#010     &#64;OneToMany&#010     private List<City> cities;&#010 //....&#010 }&#010&#010
 * &#64;Entity&#010 public class City&#010     implements Serializable&#010 {&#010     &#64;Id&#010     &#64;Column
 * (nullable = false)&#010     &#64;GeneratedValue (strategy = GenerationType.IDENTITY)&#010     &#64;Extension (vendorName
 * = "datanucleus", key = "gae.encoded-pk", value = "true")&#010     private String cityId;&#010&#010     // This is fake
 * column - it is calculated by provider and is not saved.&#010     // Actual reference to parent entity is encoded in
 * primary key.&#010     &#64;Column (nullable = false)&#010     &#64;Extension (vendorName = "datanucleus", key =
 * "gae.parent-pk", value = "true")&#010     private String countryId;&#010&#010     &#64;ManyToOne
 * (fetch=FetchType.LAZY)&#010     private Country country;&#010 //....&#010 }&#010 </pre>&#010 Note: GAE does not support
 * <code>FetchType.EAGER</code>.&#010 <p/> With&#010 <b><a
 * href='http://code.google.com/intl/en/appengine/docs/java/datastore/relationships.html#Unowned_Relationships'
 * onclick="window.open('http://code.google.com/intl/en/appengine/docs/java/datastore/relationships.html#Unowned_Relationships');return
 * false;">Unowned Relationships</a></b>&#010 (when you save parent's primary key as simple child's property) you can model
 * unsupported&#010 relationships. But this approach has drawbacks:<ul>&#010 <li>related entities are not instantiated
 * automatically</li>&#010 <li>transactions can not be used</li>&#010 <li>you have to manually keep track of changes in
 * case of bidirectional relationship</li>&#010 </ul>
 */
public interface GaeIntegration {
}
