
package com.smartgwt.client.docs;

/**
 * <h3>Integration with Hibernate</h3>
 * Smart GWT can integrate with Hibernate in two main ways: <ul> <li> With pre-existing Hibernate configuration and Java
 * beans, Smart GWT server-side DSRequests can be transformed into Hibernate <code>Criteria</code> objects, and results
 * returned via a Smart GWT DSResponse.   <li> Smart GWT can drive Hibernate as a storage layer only, automatically
 * generating Hibernate configuration from a Smart GWT DataSource file (<i>dataSourceID</i>.ds.xml).  In this case, you do
 * not write a Java bean; Hibernate's beanless  <a
 * href='http://www.hibernate.org/hib_docs/v3/reference/en/html_single/#persistent-classes-dynamicmodels'
 * onclick="window.open('http://www.hibernate.org/hib_docs/v3/reference/en/html_single/#persistent-classes-dynamicmodels');return
 * false;">"dynamic model"</a> mode is used.  This is enabled via {@link com.smartgwt.client.data.DataSource#getServerType
 * serverType}:"hibernate". </ul> <P> <b>Mapping DSRequest/DSResponse to Hibernate</b> <P> This integration strategy uses
 * the server-side Java APIs described in {@link com.smartgwt.client.docs.ServerDataIntegration}.  Two complete examples of
 * Hibernate integration are provided in the SDK, one using DMI and one using {@link com.smartgwt.client.rpc.RPCManager}
 * dispatch.  Both are accessible from the SDK Explorer as Examples->Server Integration, and both include sample Hibernate
 * configuration as well as a sample UI capable of loading and saving data. <ul> <li> <a
 * href='/examples/server_integration/index.html#customDataSourceIntegrationHibernate'
 * onclick="window.open('/examples/server_integration/index.html#customDataSourceIntegrationHibernate');return
 * false;">"Custom DataSource Integration with Hibernate"</a>  shows how to create a .jsp that uses RPCManager dispatch to
 * implement all four DataSource request {@link com.smartgwt.client.data.DSRequest#getOperationType operationType}s via
 * Hibernate for a sample bean. <li> <a href='/examples/server_integration/index.html#springDSHiberateDMI'
 * onclick="window.open('/examples/server_integration/index.html#springDSHiberateDMI');return false;">"Spring DataSource
 * Integration using DMI to Hibernate"</a> shows how to use Smart GWT Direct Method Invocation (DMI) to implement all four
 * DataSource operations with Hibernate.  This particular example uses {@link com.smartgwt.client.docs.SpringIntegration
 * Spring}-based lookup of the target for DMI, however, the same approach will work without Spring - see other DMI examples
 * on the same page for non-Spring methods of DMI target lookup. </ul> As discussed under DMI, whether to use DMI or
 * RPCManager dispatch is largely a matter of preference, however if you are already using Spring, a DMI-based approach is
 * probably a better fit. <P> <b>serverType:"hibernate"</b> <P> As with DataSources using Smart GWT's built-in {@link
 * com.smartgwt.client.docs.SqlDataSource SQL engine}, you need only {@link com.smartgwt.client.docs.DataSourceDeclaration
 * create a DataSource} in XML format - no Java classes or other configuration are required.  The {@link
 * com.smartgwt.client.docs.AdminConsole Admin Console}'s "Import DataSources" section can be used to import test data into
 * serverType:"hibernate" DataSources in the same manner as SQLDataSources.
 */
public interface HibernateIntegration {
}
