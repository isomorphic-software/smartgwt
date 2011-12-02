
package com.smartgwt.client.docs;

/**
 * <h3>Integration with JPA</h3>
 * JPA 1.0 and JPA 2.0 annotated entities can be used as Smart GWT data sources.
 *  The implementation class for JPA 1.0 is <code>com.isomorphic.jpa.JPADataSource</code>.
 *  The implementation class for JPA 2.0 is <code>com.isomorphic.jpa.JPA2DataSource</code>.
 * Both implementations support search with simple {@link com.smartgwt.client.data.Criteria} and {@link
 * com.smartgwt.client.data.AdvancedCriteria}.</br>
 * JPA 1.0 and JPA 2.0 implementations use JPQL for data fetch. <b>Note:</b> MySQL DB - 'like' operator is used in a case
 * insensitive manner. Check
 * <a href="http://dev.mysql.com/doc/refman/5.5/en/case-sensitivity.html">MySQL Reference Manual :: C.5.5.1 Case
 * Sensitivity in String Searches</a>
 *  for more information.<p/>
 *  JPA 2.0 implementation uses Metadata API for data source generation from mapped entities.
 *  <p/>
 *  <b>JPA configuration</b>
 *  <p/>
 *  JPA configuration should be specified in the <code>persistence.xml</code> file and placed
 *  in the <code>/WEB-INF/classes/META-INF</code> directory.<br/> For JPA 2.0 make sure you correctly
 *  declare its usage in <code>persistence.xml</code>:<pre>
 *  &lt;persistence
 *      version="2.0"
 *      xmlns="http://java.sun.com/xml/ns/persistence"
 *      xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
 *   xsi:schemaLocation="http://java.sun.com/xml/ns/persistence http://java.sun.com/xml/ns/persistence/persistence_2_0.xsd"
 *  &gt;
 *  ...
 *  &lt;/persistence&gt;</pre><br/>
 *  To use JPA annotated entities you have to
 *  {@link com.smartgwt.client.docs.DataSourceDeclaration create a DataSource} with these properties<ul>
 * <li><b><code>{@link com.smartgwt.client.docs.serverds.DataSource#serverConstructor serverConstructor}</code></b> -
 * either JPA 1.0
 *       DataSource implementation: <code>com.isomorphic.jpa.JPADataSource</code> or JPA 2.0
 *       implementation: <code>com.isomorphic.jpa.JPA2DataSource</code></li>.
 * <li><b><code>{@link com.smartgwt.client.docs.serverds.DataSource#beanClassName beanClassName}</code></b> - fully
 * qualified
 *       class name of JPA entity</li></ul>
 *  For example:<pre>
 *  &lt;DataSource
 *      ID="countryDS"
 *      serverConstructor="com.isomorphic.jpa.JPA2DataSource"
 *      beanClassName="com.smartgwt.sample.showcase.server.jpa.Country"
 *  &gt;
 *      &lt;fields&gt;
 *  &lt;!-- ... Fields definition ... --&gt;
 *      &lt;/fields&gt;
 *  &lt;/DataSource&gt;
 *  </pre>
 * Supports field definitions with <code>{@link com.smartgwt.client.data.DataSourceField#getValueXPath valueXPath}</code>
 * settings.
 *  Entity property is accessed (by priority):<ol>
 * <li><code>{@link com.smartgwt.client.data.DataSourceField#getValueXPath valueXPath}</code> - supports only simple XPath
 * definitions:
 *    "property/subProperty/subSubProperty"</li>
 * <li><code>{@link com.smartgwt.client.data.DataSourceField#getName name}</code> - most often used when data source field
 * name
 *    is the same as entity property name</li></ol>
 *  <p/>
 *  <b>JPA transactions</b>
 *  <p/>
 *  JPA provides three mechanisms for transactions: for JEE applications JPA provides integration
 *  with JTA (Bean Managed Transactions and Container Managed Transactions); for JSE applications JPA has a native
 *  <code>EntityTransaction</code> implementation (Locally Managed Transactions).
 *  The transaction mechanism should be configured in the <code>server.properties</code> file by setting
 *  property <b><code>jpa.emfProvider</code></b> to the fully qualified class name of the provider
 *  (implementation of <code>com.isomorphic.jpa.EMFProviderInterface</code>). Smart GWT comes
 *  with three implementations:<ul>
 *  <li><b><code>com.isomorphic.jpa.EMFProviderLMT</code></b> - for Locally Managed Transactions.
 *       Every fetch or DML operation starts a new transaction and commits after successful
 *       execution.<br/>
 *       This implementation reads the <b><code>jpa.persistenceUnitName</code></b> property from
 *       the <code>server.properties</code> file.  The value of this property needs to be set to
 *       the name of the persistence unit configured in <code>persistence.xml</code> file. For example:<pre>
 *  jpa.persistenceUnitName: PERSISTENCE_UNIT_NAME
 *       </pre></li>
 *  <li><b><code>com.isomorphic.jpa.EMFProviderBMT</code></b> - for Bean Managed Transactions.
 *       Every fetch or DML operation acquires the transaction object from the container and starts it.<br/>
 *       This implementation reads two properties from the <code>server.properties</code> file:
 *       <b><code>jpa.entityManager</code></b> and <b><code>jpa.entityManagerFactory</code></b>
 *       containing appropriate resource name references configured in
 *       <code>/WEB-INF/web.xml</code>. Configuration example:<pre>
 *  &lt;!-- EntityManager resource reference name declaration --&gt;
 *  &lt;persistence-context-ref&gt;
 *     &lt;persistence-context-ref-name&gt;persistence/em&lt;/persistence-context-ref-name&gt;
 *     &lt;persistence-unit-name&gt;PERSISTENCE_UNIT_NAME&lt;/persistence-unit-name&gt;
 *  &lt;/persistence-context-ref&gt;
 * 
 *  &lt;!-- EntityManagerFactory resource reference name declaration --&gt;
 *   &lt;persistence-unit-ref&gt;
 *       &lt;persistence-unit-ref-name&gt;persistence/emf&lt;/persistence-unit-ref-name&gt;
 *       &lt;persistence-unit-name&gt;PERSISTENCE_UNIT_NAME&lt;/persistence-unit-name&gt;
 *   &lt;/persistence-unit-ref&gt;
 * 
 *  #Property values for sample references:
 *  jpa.entityManager: persistence/em
 *  jpa.entityManagerFactory: persistence/emf
 *       </pre></li>
 *  <li><b><code>com.isomorphic.jpa.EMFProviderCMT</code></b> - for Container Managed Transactions.
 *       Every fetch or DML operation acquires the transaction object from the JEE container.
 *       After successful method execution the container commits the transaction. In case of execution
 *       failure <code>tx.setRollbackOnly()</code> is used to notify container to rollback the
 *       transaction.<br/>
 *       This implementation reads two properties from the <code>server.properties</code> file:
 *       <b><code>jpa.entityManager</code></b> and <b><code>jpa.entityManagerFactory</code></b>
 *       containing appropriate resource name references configured in
 *       <code>/META-INF/ejb-jar.xml</code>. Configuration example:<pre>
 *  &lt;?xml version="1.0" encoding="UTF-8"?&gt;
 *  &lt;ejb-jar
 *       version = "3.0"
 *       xmlns = "http://java.sun.com/xml/ns/javaee"
 *       xmlns:xsi = "http://www.w3.org/2001/XMLSchema-instance"
 *       xsi:schemaLocation = "http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/ejb-jar_3_0.xsd"&gt;
 *       &lt;enterprise-beans&gt;
 *           &lt;session&gt;
 *               &lt;ejb-name&gt;TestEJB&lt;/ejb-name&gt;
 *               &lt;persistence-context-ref&gt;
 *                   &lt;persistence-context-ref-name&gt;persistence/em&lt;/persistence-context-ref-name&gt;
 *                   &lt;persistence-unit-name&gt;PERSISTENCE_UNIT_NAME&lt;/persistence-unit-name&gt;
 *               &lt;/persistence-context-ref&gt;
 *               &lt;persistence-unit-ref&gt;
 *                   &lt;persistence-unit-ref-name&gt;persistence/emf&lt;/persistence-unit-ref-name&gt;
 *                   &lt;persistence-unit-name&gt;PERSISTENCE_UNIT_NAME&lt;/persistence-unit-name&gt;
 *               &lt;/persistence-unit-ref&gt;
 *          &lt;/session&gt;
 *      &lt;/enterprise-beans&gt;
 *  &lt;/ejb-jar&gt;
 * 
 *  #Property values for sample references:
 *  jpa.entityManager: persistence/em
 *  jpa.entityManagerFactory: persistence/emf
 *       </pre></li>
 *  <li><b><code>com.isomorphic.jpa.EMFProviderNoTransactions</code></b> - transactions are
 *       not used.<br/>
 *       From the <code>server.properties</code> file this implementation reads the
 *       <b><code>jpa.persistenceUnitName</code></b> property which must containt the name of persistence unit
 *       configured in <code>persistence.xml</code> file. For example:<pre>
 *  jpa.persistenceUnitName: PERSISTENCE_UNIT_NAME
 *       </pre></li>
 *  </ul>
 *  You can set <b><code>jpa.emfProvider</code></b> to your own implementation of
 *  <code>com.isomorphic.jpa.EMFProviderInterface</code> if you have specific requirements for
 *  transaction handling. <code>EMF</code> will instantiate provided implementation on initialization (static) and
 *  will use same instance every time. By using own implementation you can have complete control over creating/using
 *  <code>EntityManagerFactory</code> and <code>EntityManager</code> instances. For example: you can create
 *  <code>EMFProviderSpring</code> which will look-up <code>EntityManagerFactory</code> and <code>EntityManager</code>
 *  instances in Spring and will feed it to <code>JPADataSource</code>.<p/>
 *  <b>Additional configurations:</b><p/>
 *  In case you have several persistence units defined in your <code>persistence.xml</code> you can have additional
 *  configurations in <code>server.properties</code> file. Additional configurations
 *  (prefixed with <b><code>jpa.</code></b>) should have name, <b><code>emfProvider</code></b> property and other
 *  properties required by specified EMF provider implementation.
 *  For example:<pre>
 *  jpa.configName.emfProvider: com.isomorphic.jpa.EMFProviderLMT
 *  jpa.configName.persistenceUnitName: ANOTHER_PERSISTENCE_UNIT_NAME</pre>
 *  To use additional JPA configuration you have to set <b><code>jpaConfig</code></b> property in data source
 *  definition:<pre>
 *  &lt;DataSource
 *      ID="countryDS"
 *      serverConstructor="com.isomorphic.jpa.JPA2DataSource"
 *      beanClassName="com.smartgwt.sample.showcase.server.jpa.Country"
 *      jpaConfig="configName"
 *  &gt;</pre>
 *  <b>Transaction management:</b>
 *  <p/><ul>
 * <li>Operating under {@link com.smartgwt.client.rpc.RPCManager} (<code>{@link com.smartgwt.client.data.DSRequest}</code>
 * has reference to
 *    <code>{@link com.smartgwt.client.rpc.RPCManager}</code>):<ul>
 *       <li>If participating in automatic transactions:<ul>
 *     <li>retrieves existing transaction from <code>{@link com.smartgwt.client.rpc.RPCManager}</code> (if available);</li>
 *     <li>starts new transaction (if not found in <code>{@link com.smartgwt.client.rpc.RPCManager}</code>);</li></ul></li>
 *       <li>If one transaction per operation is used - starts new transaction;</li>
 *       <li>Registers itself to <code>DSRequest.registerCallback()</code> for <code>onSuccess()</code>/
 *       <code>onFailure()</code> execution to commit/roll back transaction;</li>
 *       <li>Sets <code>DSRequest.setFreeOnExecute()</code> to <code>false</code> to postpone releasing
 *           of <code>EntityManager</code> avoiding lazy loading exceptions when creating JS response and
 *           traversing through persistent object tree;</li>
 *       <li>Registers itself to <code>RPCManager.registerFreeResourcesHandler()</code> for <code>freeResources()</code>
 *       execution to release <code>EntityManager</code>.</li></ul><br/>
 *  If you want to use same <code>EntityManager</code> and transaction in your custom data source implementation you can
 *  acquire it by <pre>JPAConnectionHolder holder = DataSource.getTransactionObject(req, EMF.TRANSACTION_ATTR);</pre>
 *  <code>JPAConnectionHolder</code> instance contains references to entity manager and transaction object
 *  used by <code>JPADataSource</code>. You should never commit/rollback automatic transaction.
 *  Overall commit/rollback will be issued by <code>RPCManager</code> and will be handled by <code>JPADataSource</code>
 *  object which started transaction.
 *  </li>
 *  <li>Operating without {@link com.smartgwt.client.rpc.RPCManager}:<ul>
 *       <li>starts new transaction;</li>
 *       <li>commits/rolls back transaction and releases <code>EntityManager</code> if
 *           <code>DSRequest.setFreeOnExecute()</code> is set to <code>true</code> (defalut);</li>
 *       <li>relies on calling code to call <code>onSuccess()</code>/<code>onFailure()</code> to commit/roll back
 *           transaction and to call <code>freeResources()</code> to release <code>EntityManager</code>.<br/>
 *           Example code for data source operation execution with manual transaction handling:
 *           <pre>
 *               DSRequest req = new DSRequest("myDS", "fetch");
 *               req.setFreeOnExecute(false);
 *               DSResponse resp = req.execute();
 *               List dataList = resp.getDataList();
 *               //... traverse through persistent object tree
 *               // Commit current transaction.
 *               ((JPADataSource) r.getDataSource()).onSuccess();
 *               // Release entity manager.
 *               ((JPADataSource) r.getDataSource()).freeResources(req);
 *           </pre></li></ul>
 *  </li></ul>
 *  <p/>
 *  <b>JPA relations</b>
 *  <p/>
 *  JPA data sources transparently support JPA relations:<ul>
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
 *  the database.<p/>
 *  You can instruct the datasource to send a list of encapsulated related entities by setting
 *  {@link com.smartgwt.client.data.DataSourceField#getType type} property to the name of related datasource:
 *           <pre>
 *               &lt;field name="cities" multiple="true" type="cityOneToMany" foreignKey="cityOneToMany.cityId"/&gt;
 *           </pre>
 *  Saving parent entity automatically makes all required JPA calls to synchronize the underlying list.
 *  </li>
 *  </ul>
 *  <b>Notes on bidirectional relations</b>:<ul>
 *  <li>When the encapsulated related entity is sent to the client it will not have
 *  a reference to the parent object (to avoid recursion).</li>
 *  <li>When performing updates, make sure you update the entity that "owns" the relation. All
 *  changes to "non-owning" relations are silently discarded.</li></ul><p/>
 *  </p><strong>Implementations are not thread-safe. Datasource acquiring mechanism ensures
 *  that a single instance of this class will be used in one thread only.</strong>
 */
public interface JpaIntegration {
}
