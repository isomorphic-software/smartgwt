
package com.smartgwt.client.docs;

/**
 * <h3>Integration with JPA</h3>
 * JPA 1.0 and JPA 2.0 annotated entities can be used as Smart GWT data sources.&#010 The implementation class for JPA 1.0
 * is <code>com.isomorphic.jpa.JPADataSource</code>.&#010 The implementation class for JPA 2.0 is
 * <code>com.isomorphic.jpa.JPA2DataSource</code>.&#010 Both implementations support search with simple {@link
 * com.smartgwt.client.data.Criteria} and {@link com.smartgwt.client.data.AdvancedCriteria}.</br>&#010 The primary
 * difference between JPA 1.0 and JPA 2.0 implementations is how data is fetched:&#010 the JPA 1.0 implementation
 * creates&#010 a JPQL query string for fetching while the JPA 2.0 implementation uses Criteria API.&#010 <p/>&#010
 * <b>Tested JPA 2.0 providers</b>&#010 <p/><ul>&#010 <li>Hibernate 3.6.1 - <strong>PASS</strong>. <b>Minimum version
 * 3.6.1</b> - older versions&#010 have a bug in the Criteria API&#010 implementation which prevents correct negation of
 * conjunction and disjunction predicates.</li>&#010 <li>EclipseLink 2.2.0 - <strong>PASS</strong>.</li>&#010 <li>OpenJPA
 * 2.1.0 - <strong>FAIL</strong>. Does not support "lower(FIELD_NAME) LIKE lower('value')".&#010 According to the exception
 * message only "lower(FIELD_NAME) LIKE 'value'" is supported:&#010 <pre>org.apache.openjpa.persistence.ArgumentException:
 * The filter listener "matches" requires a constant argument.</pre></li>&#010 <li>DataNucleus 2.2.2 -
 * <strong>FAIL</strong>. Was not able to create even a simple query with Criteria API.</li>&#010 <li>ObjectDB 2.1.0 -
 * <strong>FAIL</strong>. Does not support Criteria API:&#010 <pre>java.lang.UnsupportedOperationException: Unsupported
 * feature - JPA Criteria Builder</pre></li>&#010 </ul>&#010 <b>Note:</b> MySQL DB - 'like' operator is used in a case
 * insensitive manner. Check&#010 <a href="http://dev.mysql.com/doc/refman/5.5/en/case-sensitivity.html">MySQL Reference
 * Manual :: C.5.5.1 Case Sensitivity in String Searches</a>&#010 for more information.&#010 <p/>&#010 <b>JPA
 * configuration</b>&#010 <p/>&#010 JPA configuration should be specified in the <code>persistence.xml</code> file and
 * placed&#010 in the <code>/WEB-INF/classes/META-INF</code> directory.<br/> For JPA 2.0 make sure you correctly&#010
 * declare its usage in <code>persistence.xml</code>:<pre>&#010 &lt;persistence&#010     version="2.0"&#010    
 * xmlns="http://java.sun.com/xml/ns/persistence"&#010     xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"&#010    
 * xsi:schemaLocation="http://java.sun.com/xml/ns/persistence
 * http://java.sun.com/xml/ns/persistence/persistence_2_0.xsd"&#010 &gt;&#010 ...&#010 &lt;/persistence&gt;</pre><br/>&#010
 * To use JPA annotated entities you have to&#010 {@link com.smartgwt.client.docs.DataSourceDeclaration create a
 * DataSource} with these properties<ul>&#010 <li><b><code>{@link
 * com.smartgwt.client.docs.serverds.DataSource#serverConstructor serverConstructor}</code></b> - either JPA 1.0&#010     
 * DataSource implementation: <code>com.isomorphic.jpa.JPADataSource</code> or JPA 2.0&#010      implementation:
 * <code>com.isomorphic.jpa.JPA2DataSource</code></li>.&#010 <li><b><code>{@link
 * com.smartgwt.client.docs.serverds.DataSource#beanClassName beanClassName}</code></b> - fully qualified&#010      class
 * name of JPA entity</li></ul>&#010 For example:<pre>&#010 &lt;DataSource&#010     ID="countryDS"&#010    
 * serverConstructor="com.isomorphic.jpa.JPA2DataSource"&#010    
 * beanClassName="com.smartgwt.sample.showcase.server.jpa.Country"&#010 &gt;&#010     &lt;fields&gt;&#010 &lt;!-- ...
 * Fields definition ... --&gt;&#010     &lt;/fields&gt;&#010 &lt;/DataSource&gt;&#010 </pre>&#010 Supports field
 * definitions with <code>{@link com.smartgwt.client.data.DataSourceField#getValueXPath valueXPath}</code> settings.&#010
 * Entity property is accessed (by priority):<ol>&#010 <li><code>{@link
 * com.smartgwt.client.data.DataSourceField#getValueXPath valueXPath}</code> - supports only simple XPath definitions:&#010
 * "property/subProperty/subSubProperty"</li>&#010 <li><code>{@link com.smartgwt.client.data.DataSourceField#getName
 * name}</code> - most often used when data source field name&#010   is the same as entity property name</li></ol>&#010
 * <p/>&#010 <b>JPA transactions</b>&#010 <p/>&#010 JPA provides two mechanisms for transactions: for JEE applications JPA
 * provides integration&#010 with JTA (Container Managed Transactions); for JSE applications JPA has a native&#010
 * <code>EntityTransaction</code> implementation (Locally Managed Transactions).&#010 The transaction mechanism should be
 * configured in the <code>server.properties</code> file by setting&#010 property <b><code>jpa.emfProvider</code></b> to
 * the fully qualified class name of the provider&#010 (implementation of
 * <code>com.isomorphic.jpa.EMFProviderInterface</code>). Smart GWT comes&#010 with three implementations:<ul>&#010
 * <li><b><code>com.isomorphic.jpa.EMFProviderLMT</code></b> - for Locally Managed Transactions.&#010      Every fetch or
 * DML operation starts a new transaction and commits after successful&#010      execution.<br/>&#010      This
 * implementation reads the <b><code>jpa.persistenceUnitName</code></b> property from&#010      the
 * <code>server.properties</code> file.  The value of this property needs to be set to&#010      the name of the
 * persistence unit configured in <code>persistence.xml</code> file. For example:<pre>&#010 jpa.persistenceUnitName:
 * PERSISTENCE_UNIT_NAME&#010      </pre></li>&#010 <li><b><code>com.isomorphic.jpa.EMFProviderCMT</code></b> - for
 * Container Managed Transactions.&#010      Every fetch or DML operation acquires the transaction object from the JEE
 * container.&#010      After successful method execution the container commits the transaction. In case of execution&#010 
 * failure <code>tx.setRollbackOnly()</code> is used to notify container to rollback the&#010      transaction.<br/>&#010  
 * This implementation reads two properties from the <code>server.properties</code> file:&#010     
 * <b><code>jpa.cmt.entityManager</code></b> and <b><code>jpa.cmt.transaction</code></b>&#010      containing appropriate
 * resource name references configured in&#010      <code>/WEB-INF/web.xml</code>. Configuration example:<pre>&#010 &lt;!--
 * EntityManager resource reference name declaration --&gt;&#010 &lt;persistence-context-ref&gt;&#010   
 * &lt;persistence-context-ref-name&gt;persistence/em&lt;/persistence-context-ref-name&gt;&#010   
 * &lt;persistence-unit-name&gt;PERSISTENCE_UNIT_NAME&lt;/persistence-unit-name&gt;&#010
 * &lt;/persistence-context-ref&gt;&#010&#010 &lt;!-- Transaction resource reference name declaration --&gt;&#010
 * &lt;resource-env-ref&gt;&#010     &lt;resource-env-ref-name&gt;persistence/tx&lt;/resource-env-ref-name&gt;&#010    
 * &lt;resource-env-ref-type&gt;javax.transaction.UserTransaction&lt;/resource-env-ref-type&gt;&#010
 * &lt;/resource-env-ref&gt;&#010&#010 #Property values for sample references:&#010 jpa.cmt.entityManager:
 * persistence/em&#010 jpa.cmt.transaction: persistence/tx&#010      </pre></li>&#010
 * <li><b><code>com.isomorphic.jpa.EMFProviderNoTransactions</code></b> - transactions are&#010      not used.<br/>&#010   
 * From the <code>server.properties</code> file this implementation reads the&#010     
 * <b><code>jpa.persistenceUnitName</code></b> property which must containt the name of persistence unit&#010     
 * configured in <code>persistence.xml</code> file. For example:<pre>&#010 jpa.persistenceUnitName:
 * PERSISTENCE_UNIT_NAME&#010      </pre></li>&#010 </ul>&#010 You can provide your own implementation of&#010
 * <code>com.isomorphic.jpa.EMFProviderInterface</code> if you have specific requirements for&#010 transaction
 * handling.&#010 <p/>&#010 <b>Transaction management:</b>&#010 <p/><ul>&#010 <li>Operating under {@link
 * com.smartgwt.client.rpc.RPCManager} (<code>{@link com.smartgwt.client.data.DSRequest}</code> has reference to&#010  
 * <code>{@link com.smartgwt.client.rpc.RPCManager}</code>):<ul>&#010      <li>If participating in automatic
 * transactions:<ul>&#010          <li>retrieves existing transaction from <code>{@link
 * com.smartgwt.client.rpc.RPCManager}</code> (if available);</li>&#010          <li>starts new transaction (if not found
 * in <code>{@link com.smartgwt.client.rpc.RPCManager}</code>);</li></ul></li>&#010      <li>If one transaction per
 * operation is used - starts new transaction;</li>&#010      <li>Registers itself to
 * <code>DSRequest.registerCallback()</code> for <code>onSuccess()</code>/&#010      <code>onFailure()</code> execution to
 * commit/roll back transaction;</li>&#010      <li>Sets <code>DSRequest.setFreeOnExecute()</code> to <code>false</code> to
 * postpone releasing&#010          of <code>EntityManager</code> avoiding lazy loading exceptions when creating JS
 * response and&#010          traversing through persistent object tree;</li>&#010      <li>Registers itself to
 * <code>RPCManager.registerFreeResourcesHandler()</code> for <code>freeResources()</code>&#010      execution to release
 * <code>EntityManager</code>.</li></ul></li>&#010 <li>Operating without {@link
 * com.smartgwt.client.rpc.RPCManager}:<ul>&#010      <li>starts new transaction;</li>&#010      <li>commits/rolls back
 * transaction and releases <code>EntityManager</code> if&#010          <code>DSRequest.setFreeOnExecute()</code> is set to
 * <code>true</code> (defalut);</li>&#010      <li>relies on calling code to call
 * <code>onSuccess()</code>/<code>onFailure()</code> to commit/roll back&#010          transaction and to call
 * <code>freeResources()</code> to release <code>EntityManager</code>.<br/>&#010          Example code for data source
 * operation execution with manual transaction handling:&#010          <pre>&#010              DSRequest req = new
 * DSRequest("myDS", "fetch");&#010              req.setFreeOnExecute(false);&#010              DSResponse resp =
 * req.execute();&#010              List dataList = resp.getDataList();&#010              //... traverse through persistent
 * object tree&#010              // Commit current transaction.&#010              ((JPADataSource)
 * r.getDataSource()).onSuccess();&#010              // Release entity manager.&#010              ((JPADataSource)
 * r.getDataSource()).freeResources(req);&#010          </pre></li></ul>&#010 </li></ul>&#010 <p/>&#010 <b>JPA
 * relations</b>&#010 <p/>&#010 JPA data sources transparently support JPA relations:<ul>&#010 <li>To specify many-to-one
 * relation you have to declare it in data source definition with property&#010 {@link
 * com.smartgwt.client.data.DataSourceField#getForeignKey foreignKey} pointing to releted data source's primary key:&#010  
 * <pre>&#010              &lt;field name="country" foreignKey="countryManyToOne.countryId"/&gt;&#010          </pre>&#010
 * Client-side will recieve only ID of related entity while server-side will use real related entity loaded from data&#010
 * base.<p/>&#010 You can instruct data source to send encapsulated related entity by setting&#010 {@link
 * com.smartgwt.client.data.DataSourceField#getType type} property to the name of related data source:&#010         
 * <pre>&#010              &lt;field name="country" type="countryManyToOne"
 * foreignKey="countryManyToOne.countryId"/&gt;&#010          </pre>&#010 </li>&#010 <li>To specify one-to-many relation
 * you have to declare it in data source definition with property&#010 {@link
 * com.smartgwt.client.data.DataSourceField#getForeignKey foreignKey} pointing to releted data source's primary key
 * and&#010 property {@link com.smartgwt.client.data.DataSourceField#getMultiple multiple} set to <code>true<code>:&#010   
 * <pre>&#010              &lt;field name="cities" multiple="true" foreignKey="cityOneToMany.cityId"/&gt;&#010         
 * </pre>&#010 Client-side will recieve only list of related ID's while server-side will use real related entity list
 * loaded from&#010 the database.<p/>&#010 You can instruct the datasource to send a list of encapsulated related entities
 * by setting&#010 {@link com.smartgwt.client.data.DataSourceField#getType type} property to the name of related
 * datasource:&#010          <pre>&#010              &lt;field name="cities" multiple="true" type="cityOneToMany"
 * foreignKey="cityOneToMany.cityId"/&gt;&#010          </pre>&#010 Saving parent entity automatically makes all required
 * JPA calls to synchronize the underlying list.&#010 </li>&#010 </ul>&#010 <b>Notes on bidirectional
 * relations</b>:<ul>&#010 <li>When the encapsulated related entity is sent to the client it will not have&#010 a reference
 * to the parent object (to avoid recursion).</li>&#010 <li>When performing updates, make sure you update the entity that
 * "owns" the relation. All&#010 changes to "non-owning" relations are silently discarded.</li></ul><p/>&#010
 * </p><strong>Implementations are not thread-safe. Datasource acquiring mechanism ensures&#010 that a single instance of
 * this class will be used in one thread only.</strong>
 */
public interface JpaIntegration {
}
