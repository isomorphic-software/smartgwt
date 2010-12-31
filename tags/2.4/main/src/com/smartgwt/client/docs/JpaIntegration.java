
package com.smartgwt.client.docs;

/**
 * <h3>Integration with JPA</h3>
 * JPA 1.0 annotated entities can be used as Smart GWT data source. Data source&#010 implementation class
 * <code>com.isomorphic.jpa.JPADataSource</code> supports only simple&#010 search {@link
 * com.smartgwt.client.data.Criteria}. {@link com.smartgwt.client.data.AdvancedCriteria} is <b>not supported</b>.&#010
 * <p/>&#010 <b>JPA configuration</b>&#010 <p/>&#010 JPA configuration should be specified in file
 * <code>persistence.xml</code> file and placed&#010 in <code>/WEB-INF/classes/META-INF</code> directory.<br/>&#010 To use
 * JPA annotated entity you have to&#010 {@link com.smartgwt.client.docs.DataSourceDeclaration create a DataSource} with
 * these properties<ul>&#010 <li><b><code>{@link com.smartgwt.client.docs.serverds.DataSource#serverConstructor
 * serverConstructor}</code></b> - JPA&#010      DataSource implementation:
 * <code>com.isomorphic.jpa.JPADataSource</code></li>&#010 <li><b><code>{@link
 * com.smartgwt.client.docs.serverds.DataSource#beanClassName beanClassName}</code></b> - fully qualified&#010      class
 * name of JPA entity</li></ul>&#010 For example:<pre>&#010 &lt;DataSource&#010     ID="countryDS"&#010    
 * serverConstructor="com.isomorphic.jpa.JPADataSource"&#010    
 * beanClassName="com.smartgwt.sample.showcase.server.jpa.Country"&#010 &gt;&#010     &lt;fields&gt;&#010 &lt;!-- ...
 * Fields definition ... --&gt;&#010     &lt;/fields&gt;&#010 &lt;/DataSource&gt;&#010 </pre>&#010 <b>JPA
 * transactions</b>&#010 <p/>&#010 JPA provides two mechanisms for transactions: for JEE applications JPA provides
 * integration&#010 with JTA (Container Managed Transactions); for JSE applications JPA has own&#010
 * <code>EntityTransaction</code> implementation (Locally Managed Transactions).&#010 Transaction mechanism should be
 * configured in <code>server.properties</code> file by setting&#010 property <b><code>jpa.emfProvider</code></b> to fully
 * qualified class name of provider&#010 (implementation of <code>com.isomorphic.jpa.EMFProviderInterface</code>). Smart
 * GWT comes&#010 with three implementations:<ul>&#010 <li><b><code>com.isomorphic.jpa.EMFProviderLMT</code></b> - for
 * Locally Managed Transactions.&#010      Every fetch or DML operation starts new transaction and commits after
 * successful&#010      execution.<br/>&#010      From <code>server.properties</code> file this implementation reads
 * property&#010      <b><code>jpa.persistenceUnitName</code></b> containing name of persistence unit&#010      configured
 * in <code>persistence.xml</code> file. For example:<pre>&#010 jpa.persistenceUnitName: PERSISTENCE_UNIT_NAME&#010     
 * </pre></li>&#010 <li><b><code>com.isomorphic.jpa.EMFProviderCMT</code></b> - for Container Managed Transactions.&#010   
 * Every fetch or DML operation acquires transaction object from JEE container.&#010      After successful method execution
 * container commits transaction. In case of execution&#010      failure <code>tx.setRollbackOnly()</code> is used to
 * notify container to rollback&#010      transaction.<br/>&#010      This implementation reads two properties from
 * <code>server.properties</code> file:&#010      <b><code>jpa.cmt.entityManager</code></b> and
 * <b><code>jpa.cmt.transaction</code></b>&#010      containing appropriate resource name references configured in&#010    
 * <code>/WEB-INF/web.xml</code>. Configuration example:<pre>&#010 &lt;!-- EntityManager resource reference name
 * declaration --&gt;&#010 &lt;persistence-context-ref&gt;&#010   
 * &lt;persistence-context-ref-name&gt;persistence/em&lt;/persistence-context-ref-name&gt;&#010   
 * &lt;persistence-unit-name&gt;PERSISTENCE_UNIT_NAME&lt;/persistence-unit-name&gt;&#010
 * &lt;/persistence-context-ref&gt;&#010&#010 &lt;!-- Transaction resource reference name declaration --&gt;&#010
 * &lt;resource-env-ref&gt;&#010     &lt;resource-env-ref-name&gt;persistence/tx&lt;/resource-env-ref-name&gt;&#010    
 * &lt;resource-env-ref-type&gt;javax.transaction.UserTransaction&lt;/resource-env-ref-type&gt;&#010
 * &lt;/resource-env-ref&gt;&#010&#010 #Property values for sample references:&#010 jpa.cmt.entityManager:
 * persistence/em&#010 jpa.cmt.transaction: persistence/tx&#010      </pre></li>&#010
 * <li><b><code>com.isomorphic.jpa.EMFProviderNoTransactions</code></b> - transactions are&#010      not used.<br/>&#010   
 * From <code>server.properties</code> file this implementation reads property&#010     
 * <b><code>jpa.persistenceUnitName</code></b> containing name of persistence unit&#010      configured in
 * <code>persistence.xml</code> file. For example:<pre>&#010 jpa.persistenceUnitName: PERSISTENCE_UNIT_NAME&#010     
 * </pre></li>&#010 </ul>&#010 You can provide your own implementation of&#010
 * <code>com.isomorphic.jpa.EMFProviderInterface</code> in case of specific requirements for&#010 transaction handling.
 */
public interface JpaIntegration {
}
