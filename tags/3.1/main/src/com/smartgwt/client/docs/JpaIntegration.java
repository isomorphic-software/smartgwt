	    
package com.smartgwt.client.docs;

/**
 * <h3>Integration with JPA</h3>
 * To use JPA, set serverType="jpa" in your .ds.xml file, then set
 * {@link com.smartgwt.client.docs.serverds.DataSource#beanClassName beanClassName} to the fully
 * qualified class name of the
 *  JPA entity.  For example:
 *  <pre>
 *  &lt;DataSource
 *      ID="countryDS"
 *      serverType="jpa"
 *      beanClassName="com.smartgwt.sample.showcase.server.jpa.Country"
 *  &gt;
 *      &lt;fields&gt;
 *  &lt;!-- ... Fields definition ... --&gt;
 *      &lt;/fields&gt;
 *  &lt;/DataSource&gt;
 *  </pre>
 * {@link com.smartgwt.client.docs.serverds.DataSource#autoDeriveSchema autoDeriveSchema} is
 * supported for deriving DataSource fields from JPA
 *  entities automatically (except with JPA 1.0; see below).
 *  <p>
 * Full support is provided for executing simple {@link com.smartgwt.client.data.Criteria}, with
 * {@link com.smartgwt.client.data.AdvancedCriteria}
 * supported if you have Power Edition or above.  However, note that there are limitations with
 * case
 *  sensitive search in MySQL since MySQL automatically uses the 'like' operator in a
 *  case-insensitive manner and JPA does not correct this.  See <a
 *  href="http://dev.mysql.com/doc/refman/5.5/en/case-sensitivity.html">MySQL Reference Manual
 *  :: C.5.5.1 Case Sensitivity in String Searches</a> for more information.<p/>
 *  <p>
 *  If create a custom DataSource based on the built-in JPA functionality, subclass
 *  <code>com.isomorphic.jpa.JPA2DataSource</code>.
 *  <p>
 *  <h3>JPA configuration</h3>
 *  <p>
 * JPA configuration should be specified in the <code>persistence.xml</code> file as usual, and
 * placed
 *  in the <code>/WEB-INF/classes/META-INF</code> directory.  For JPA 2.0 make sure you correctly
 *  declare its usage in <code>persistence.xml</code>:<pre>
 *  &lt;persistence
 *      version="2.0"
 *      xmlns="http://java.sun.com/xml/ns/persistence"
 *      xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
 *      xsi:schemaLocation="http://java.sun.com/xml/ns/persistence 
 *                          http://java.sun.com/xml/ns/persistence/persistence_2_0.xsd"
 *  &gt;
 *  ...
 *  &lt;/persistence&gt;</pre><br/>
 *  <P>
 * JPADataSource supports operations with composite primary keys. Setting data source level
 * property
 * {@link com.smartgwt.client.docs.serverds.DataSource#idClassName idClassName} to fully qualified
 * class name indicates,
 *  that entity uses composite primary key.
 *  <P>
 *  JPADataSource supports automatic handling of JPA relations that don't declare a concrete
 *  field to hold ID values - see {@link com.smartgwt.client.docs.JpaHibernateRelations}.
 *  <P>
 *  <h3>JPA 1.0 compatibility</h3>
 *  <P>
 *  To use JPA 1.0, set serverType="jpa1" instead.  JPA 1.0 does not support
 * {@link com.smartgwt.client.docs.serverds.DataSource#autoDeriveSchema autoDeriveSchema}.  For
 * JPA 1.0, the concrete implementation class (for subclassing to
 *  create a custom DataSource) is <code>com.isomorphic.jpa.JPADataSource</code>.
 *  <p>
 *  <h3>JPA transactions</h3>
 *  <p>
 *  JPA provides three mechanisms for transactions: for JEE applications JPA provides integration
 * with JTA (Bean Managed Transactions and Container Managed Transactions); for JSE applications
 * JPA has a native
 * <code>EntityTransaction</code> implementation (Locally Managed Transactions). Spring framework
 * is another popular
 *  way for declaring transactions in application.
 * The transaction mechanism should be configured in the <code>server.properties</code> file by
 * setting
 *  property <b><code>jpa.emfProvider</code></b> to the fully qualified class name of the provider
 *  (implementation of <code>com.isomorphic.jpa.EMFProviderInterface</code>). Smart GWT comes
 *  with five implementations:<ul>
 *  <li><b><code>com.isomorphic.jpa.EMFProviderLMT</code></b> - for Locally Managed Transactions.
 *       Every fetch or DML operation starts a new transaction and commits after successful
 *       execution.<br/>
 *       This implementation reads the <b><code>jpa.persistenceUnitName</code></b> property from
 *       the <code>server.properties</code> file.  The value of this property needs to be set to
 * the name of the persistence unit configured in <code>persistence.xml</code> file. For
 * example:<pre>
 *  jpa.persistenceUnitName: PERSISTENCE_UNIT_NAME
 *       </pre></li>
 *  <li><b><code>com.isomorphic.jpa.EMFProviderBMT</code></b> - for Bean Managed Transactions.
 * Every fetch or DML operation acquires the transaction object from the container and starts
 * it.<br/>
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
 * <li><b><code>com.isomorphic.jpa.EMFProviderCMT</code></b> - for Container Managed Transactions.
 *       Every fetch or DML operation acquires the transaction object from the JEE container.
 *   After successful method execution the container commits the transaction. In case of execution
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
 * xsi:schemaLocation = "http://java.sun.com/xml/ns/javaee
 * http://java.sun.com/xml/ns/javaee/ejb-jar_3_0.xsd"&gt;
 *       &lt;enterprise-beans&gt;
 *           &lt;session&gt;
 *               &lt;ejb-name&gt;TestEJB&lt;/ejb-name&gt;
 *               &lt;persistence-context-ref&gt;
 *         &lt;persistence-context-ref-name&gt;persistence/em&lt;/persistence-context-ref-name&gt;
 *                &lt;persistence-unit-name&gt;PERSISTENCE_UNIT_NAME&lt;/persistence-unit-name&gt;
 *               &lt;/persistence-context-ref&gt;
 *               &lt;persistence-unit-ref&gt;
 *              &lt;persistence-unit-ref-name&gt;persistence/emf&lt;/persistence-unit-ref-name&gt;
 *                &lt;persistence-unit-name&gt;PERSISTENCE_UNIT_NAME&lt;/persistence-unit-name&gt;
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
 * <b><code>jpa.persistenceUnitName</code></b> property which must containt the name of
 * persistence unit
 *       configured in <code>persistence.xml</code> file. For example:<pre>
 *  jpa.persistenceUnitName: PERSISTENCE_UNIT_NAME
 *       </pre></li>
 * <li><b><code>com.isomorphic.jpa.EMFProviderSpring</code></b> - for Spring Framework managed
 * Transactions.
 * Every fetch or DML operation acquires the transaction object from the Spring Application
 * Context.<br/>
 *       This implementation reads two properties from the <code>server.properties</code> file:
 *       <b><code>jpa.entityManagerFactory</code></b> and <b><code>jpa.transaction</code></b>
 *       containing appropriate bean names configured in Spring Application Context.
 *       You have to declare additional bean in your Spring Application Context to allow Smart GWT
 *       to acquire reference to context.
 *       Configuration example:<pre>
 * &lt;!-- SpringApplicationContextProvider bean definition required to get access to application
 * context. --&gt;
 * &lt;bean id="springApplicationContextProvider"
 * class="com.isomorphic.spring.SpringApplicationContextProvider" /&gt;
 * 
 *  &lt;!-- Connection to data base --&gt;
 *  &lt;bean id="dataSource"
 *       class="org.springframework.jdbc.datasource.DriverManagerDataSource"
 *       p:driverClassName="DRIVER_CLASS"
 *       p:url="CONNECTION_URL"
 *       p:username="DB_USER_NAME"
 *       p:password="DB_USER_PASSWORD" /&gt;
 * 
 *  &lt;!-- Reference to JPA EntityManagerFactory --&gt;
 * &lt;bean id="entityManagerFactory"
 * class="org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean"&gt;
 *      &lt;property name="dataSource" ref="dataSource" /&gt;
 *      &lt;property name="jpaVendorAdapter"&gt;
 *         &lt;bean class="org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter"&gt;
 *             &lt;property name="database" value="DB_TYPE" /&gt;
 *         &lt;/bean&gt;
 *      &lt;/property&gt;
 *      &lt;property name="persistenceUnitName" value="PERSISTENCE_UNIT_NAME" /&gt;
 *  &lt;/bean&gt;
 * 
 *  &lt;!-- Reference to JpaTransactionManager --&gt;
 *  &lt;bean id="transactionManager" class="org.springframework.orm.jpa.JpaTransactionManager"&gt;
 *      &lt;property name="entityManagerFactory" ref="entityManagerFactory" /&gt;
 *  &lt;/bean&gt;
 * 
 *  #Property values for sample bean names:
 *  jpa.entityManagerFactory: entityManagerFactory
 *  jpa.transaction: transactionManager
 *       </pre></li>
 *  </ul>
 *  You can set <b><code>jpa.emfProvider</code></b> to your own implementation of
 *  <code>com.isomorphic.jpa.EMFProviderInterface</code> if you have specific requirements for
 * transaction handling. <code>EMF</code> will instantiate provided implementation on
 * initialization (static) and
 * will use same instance every time. By using own implementation you can have complete control
 * over creating/using
 *  <code>EntityManagerFactory</code> and <code>EntityManager</code> instances.<p/>
 *  <b>Additional configurations:</b><p/>
 * In case you have several persistence units defined in your <code>persistence.xml</code> you can
 * have additional
 *  configurations in <code>server.properties</code> file. Additional configurations
 * (prefixed with <b><code>jpa.</code></b>) should have name, <b><code>emfProvider</code></b>
 * property and other
 *  properties required by specified EMF provider implementation.
 *  For example:<pre>
 *  jpa.configName.emfProvider: com.isomorphic.jpa.EMFProviderLMT
 *  jpa.configName.persistenceUnitName: ANOTHER_PERSISTENCE_UNIT_NAME</pre>
 * To use additional JPA configuration you have to set <b><code>jpaConfig</code></b> property in
 * data source
 *  definition:<pre>
 *  &lt;DataSource
 *      ID="countryDS"
 *      serverType="jpa"
 *      beanClassName="com.smartgwt.sample.showcase.server.jpa.Country"
 *      jpaConfig="configName"
 *  &gt;</pre>
 *  <b>Transaction management:</b>
 *  <p/><ul>
 * <li>Operating under {@link com.smartgwt.client.rpc.RPCManager} (<code>{@link
 * com.smartgwt.client.data.DSRequest}</code> has reference to
 *    <code>{@link com.smartgwt.client.rpc.RPCManager}</code>):<ul>
 *       <li>If participating in automatic transactions:<ul>
 * <li>retrieves existing transaction from <code>{@link com.smartgwt.client.rpc.RPCManager}</code>
 * (if available);</li>
 * <li>starts new transaction (if not found in <code>{@link
 * com.smartgwt.client.rpc.RPCManager}</code>);</li></ul></li>
 *       <li>If one transaction per operation is used - starts new transaction;</li>
 * <li>Registers itself to <code>DSRequest.registerCallback()</code> for <code>onSuccess()</code>/
 *       <code>onFailure()</code> execution to commit/roll back transaction;</li>
 *  <li>Sets <code>DSRequest.setFreeOnExecute()</code> to <code>false</code> to postpone releasing
 *    of <code>EntityManager</code> avoiding lazy loading exceptions when creating JS response and
 *           traversing through persistent object tree;</li>
 * <li>Registers itself to <code>RPCManager.registerFreeResourcesHandler()</code> for
 * <code>freeResources()</code>
 *       execution to release <code>EntityManager</code>.</li></ul><br/>
 * If you want to use same <code>EntityManager</code> and transaction in your custom data source
 * implementation you can
 * acquire it by <pre>JPAConnectionHolder holder = DataSource.getTransactionObject(req,
 * EMF.TRANSACTION_ATTR);</pre>
 * <code>JPAConnectionHolder</code> instance contains references to entity manager and transaction
 * object
 *  used by <code>JPADataSource</code>. You should never commit/rollback automatic transaction.
 * Overall commit/rollback will be issued by <code>RPCManager</code> and will be handled by
 * <code>JPADataSource</code>
 *  object which started transaction.
 *  </li>
 *  <li>Operating without {@link com.smartgwt.client.rpc.RPCManager}:<ul>
 *       <li>starts new transaction;</li>
 *       <li>commits/rolls back transaction and releases <code>EntityManager</code> if
 *           <code>DSRequest.setFreeOnExecute()</code> is set to <code>true</code> (defalut);</li>
 * <li>relies on calling code to call <code>onSuccess()</code>/<code>onFailure()</code> to
 * commit/roll back
 * transaction and to call <code>freeResources()</code> to release
 * <code>EntityManager</code>.<br/>
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
 *  <p>
 *  <h3>Manual JPA Integration</h3>
 *  <p>
 *  In some cases you may not be able to immediately use the built-in JPADataSource - in
 * this case take a look at {@link com.smartgwt.client.docs.ManualJpaHibernate manual Hibernate
 * integration}.
 */
public interface JpaIntegration {
}
