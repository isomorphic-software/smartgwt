
package com.smartgwt.client.docs;

/**
 * <h3>Custom Server DataSources</h3>
 * Out of the box, and with no code to write, Smart GWT supports SQL, JPA and Hibernate for 
 * persistence, which includes EJB 3.0, EclipseLink and other Java persistence systems accessible
 * via JPA.  For other Java-based persistence systems, such as legacy EJBs or systems proprietary
 * to your company, you write a custom DataSource class in Java.  In most cases, it is possible to
 * write a single, generic DataSource class that provides access to all data that is a available
 * from a given persistence mechanism; for example, a single DataSource class can typically be
 * written for accessing all data accessible via legacy EJB. <p> Note that a majority of the
 * features of the Smart GWT Server framework apply even when using your own persistence
 * mechanism.  As with the features supported by Smart GWT's browser-based visual components,
 * Smart GWT's server-side features rely only on the  concept of a DataSource and not on the
 * details of the ultimate persistence mechanism.  Hence they are usable with a custom DataSource
 * regardless of the final data provider. <p> We provide a complete working example of a custom
 * DataSource in the Smart GWT Feature Explorer; you can see it in action <a
 * href="http://www.smartclient.com/smartgwtee/showcase/#orm_ds" target="examples">here</a>.  This
 * example  "ormDataSource" is an adaptor for Hibernate which supports the 4 CRUD operations, 
 * data paging, server-side sort and filter, and which participates correctly in  {@link
 * com.smartgwt.client.data.ResultSet cache synchronization}.  The code required is minimal, and
 * the approaches taken generalize to any ORM system.  Studying the Java source code for this
 * DataSource - which is available in the "ORMDataSource.java" tab in the example linked to above
 * - is the best way to get a start on implementing your own custom DataSource. <p> <ul>
 * <li><code>ORMDataSource</code> extends <code>BasicDataSource</code>.
 * <li><code>ORMDataSource</code> is primarily an implementation of four key methods:    
 * <code>executeFetch</code>, <code>executeAdd</code>, <code>executeUpdate</code> and     
 * <code>executeRemove</code>.  All the logic related to the actual CRUD data operation     takes
 * place in one of these methods.  This is the recommended approach.</li> <li>The class also
 * implements the <code>execute</code> method.  This is an override of the     method that is
 * actually called by the framework, and as such is an appropriate place to     set up shared
 * objects that will be used in more than one CRUD operation, and to perform     shared pre- and
 * post-processing.  As you can see, the example is setting up a Hibernate     session and
 * transaction, and then calling <code>super.execute</code> - this calls back     into the
 * framework and ultimately leads to the appropriate data operation method being     called.</li>
 * <li>Note how each of the <code>executeXxx</code> methods conforms to the      {@link
 * com.smartgwt.client.docs.DataSourceOperations DataSource protocol}.  To take
 * <code>executeFetch</code> as      an example, note how it:     <ul><li>Retrieves the criteria
 * for the fetch from the supplied <code>DSRequest</code></li>         <li>Implements logic to
 * obey the <code>startRow</code>, <code>endRow</code> and              <code>batchSize</code>
 * values.  This is only necessary for a DataSource that              intends to support automatic
 * data paging.</li>         <li>Retrieves <code>sortByFields</code> from the supplied
 * <code>DSrequest</code>,              and uses that value to change the order of the resultset. 
 * This is only              necessary for a DataSource that intends to support server-side
 * sorting.</li>         <li>Populates <code>startRow</code>, <code>endRow</code> and
 * <code>totalRows</code>             on the <code>DSResponse</code>.</li>         <li>Populates
 * the <code>DSResponse</code>'s <code>data</code> member with the list of              objects
 * retrieved by the Hibernate call.</li>     </ul><br>     These are the only parts of this method
 * that are of significance as far as Smart GWT      is concerned - the rest of the method is
 * concerned with communicating with the      data provider, which is of no interest to Smart GWT
 * as long as the method conforms to     the DataSource protocol for a "fetch" operation.</li>
 * </ul> <p><br> <b>The DataSource descriptor</b> <p> Once your custom DataSource is implemented,
 * you need to to create a descriptor for each  instance of the DataSource.  As noted above, it is
 * generally possible to write one custom  DataSource class that is capable of handling all data
 * access for a particular persistence  mechanism.  DataSource descriptors, on the other hand, are
 * written per entity. <p> A DataSource descriptor is an XML file with the special suffix
 * <code>.ds.xml</code>.  The  descriptor for a custom DataSource is, for the most part, identical
 * to the descriptor for  a built-in DataSource: it is the central place where you describe the
 * DataSource instance to the system - its fields, validations, security constraints, special data
 * operations,  transaction chaining expressions and so on (see the {@link
 * com.smartgwt.client.data.DataSource DataSource docs}  for full details). <p> One property that
 * is always required for a custom DataSource is  {@link
 * com.smartgwt.client.docs.serverds.DataSource#serverConstructor serverConstructor}.  This
 * fully-qualified class  name tells Smart GWT what to instantiate when data operations for this
 * DataSource arrive on the server - in other words, it is how you tell Smart GWT to use your
 * custom class.   In the <a href="http://www.smartclient.com/smartgwtee/showcase/#orm_ds"
 * target="examples">ORM DataSource example</a>, on the  <code>ormDataSource_country</code> tab,
 * you will see how we use this property to tie the <code>ormDataSource_country</code> DataSource
 * <em>instance</em> to the  <code>ormDataSource</code> DataSource <em>implementation</em>. <p>
 * Finally, if your data model is based on Javabeans, or on POJOs that broadly follow the 
 * Javabean conventions (basically, if they have private state variables accessible via public 
 * getters and setters), Smart GWT can automatically generate basic DataSource definitions  for
 * your beans that will only need minimal change (ie, specifying a 
 * <code>serverConstructor</code>) to be fully operational.  Both the  <a
 * href="http://www.smartclient.com/smartgwtee/showcase/#javabeanWizard" target="examples">Visual
 * Builder Javabean Wizard</a> and the Batch DataSource  Generator can create DataSource
 * descriptors from existing beans. <p> <b>Server framework features relevant to custom
 * DataSources</b> <P> The vast majority of the Smart GWT Server framework's key features are not
 * specific to the built-in SQL and Hibernate connectors, and still apply even when using a custom
 * persistence mechanism.  See {@link com.smartgwt.client.docs.FeaturesCustomPersistence this
 * overview} of which features apply when using a custom persistence mechanism and how best to
 * leverage those features.
 */
public interface WriteCustomDataSource {
}
