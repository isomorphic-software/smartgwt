	    
package com.smartgwt.client.docs;

/**
 * <h3>JPA &amp; Hibernate Relations</h3>
 * JPA and Hibernate allow relations to be declared between entities where there is no actual
 *  Java field for storing the ID of a related entity, even though such a column exists in the
 *  database.  For example:
 *  <pre>
 *     &#64;ManyToOne
 *     &#64;JoinColumn(name="countryId", referencedColumnName="countryId")
 *     private Country country;
 *  </pre>
 *  JPADataSource and HibernateDataSource support this style of declaration and will
 *  automatically handle mapping between IDs and entities.
 *  <p>
 *  The example above and the following examples assume a DataSource "country" for a
 *  JPA/Hibernate entity "Country" with an Id field of "countryId", and a DataSource "city" for a
 *  JPA/Hibernate entity "City" with an Id field of "cityId".
 *  <p>
 *  <h3>Many-To-One Relations</h3>
 *  <p>
 *  An example of Many-To-One is that Many "City"s belong to One "Country".  In Java, each City
 *  bean has a field of type Country.  In the database, rows for cities and countries are linked
 *  by ID.
 *  <p>
 *  To specify a many-to-one relation, declare a DataSourceField named after the Java field that
 *  declares the relation ("country" above) with the property
 * {@link com.smartgwt.client.data.DataSourceField#getForeignKey foreignKey} pointing to related
 * DataSource's primary key:
 *  <pre>
 *     &lt;field name="country" foreignKey="country.countryId"/&gt;
 *  </pre>
 *  When delivered to the browser, the value of the <code>country</code> field will be the ID of
 *  the related Country entity.  The <code>country</code> field can be treated as a normal text
 * or integer field value, for example, you can use a {@link
 * com.smartgwt.client.widgets.form.fields.SelectItem} that uses
 * {@link com.smartgwt.client.widgets.form.fields.SelectItem#getOptionDataSource optionDataSource}
 * to allow selecting the ID of a different related
 *  entity.  Then, when the new ID is saved to the server, JPADataSource automatically looks up
 *  the related object and persists the new relation to JPA.
 *  <p>
 *  <b>NOTE:</b>: do not declare a "type" attribute for such a field - these fields provide
 *  specialized mapping between IDs and JPA/Hibernate entities, so don't really have a single
 *  concrete type.
 *  <p>
 *  If you want fields from a related entity to be included whenever your entity is fetched, for
 *  example, whenever a city is fetched you want the <code>countryName</code> fetched from the
 * related <code>country</code> entity, use {@link
 * com.smartgwt.client.docs.serverds.DataSourceField#includeFrom includeFrom}.
 *  <p>
 *  <b>Automatic Criteria translation</b>
 *  <p>
 *  If criteria are submitted for a ManyToOne relation field containing an ID value, this will
 *  correctly return Records that are associated with the related object that has that ID.
 *  <p>
 *  For example, given a countryId of "1", you can fetch all city Records that are related to
 *  that countryId as follows:
 *  
 *  
 *  <pre>
 *     DataSource.get("city").fetchData(new Criteria("countryId", "1"), <callback>);
 *  </pre>
 *  
 *  <p>
 *  <h3>One-to-Many Relations</h3>
 *  <p>
 *  An example of One-To-Many relation is that One "Country" has Many "City"'s.  Each "Country"
 *  has a list of cities within it, which may be declared as a Java bean property of Collection
 *  type (or List, Set, etc).
 *  <p>
 *  To specify a one-to-many relation, declare a DataSourceField that:
 *  <ul>
 *  <li> is named after the Java field that declares the OneToMany relation (whose type is a
 *       Collection of the related entities)
 *  <li> declares its "type" to be the ID of the related DataSource
 * <li> declares a {@link com.smartgwt.client.data.DataSourceField#getForeignKey foreignKey}
 * pointing to the related
 *       DataSource's primaryKey field
 *  <li> sets multiple="true"
 *  </ul>
 *  For example, for a Country bean that has a Collection of City beans:
 *  <pre>
 *      &lt;field name="cities" type="city" multiple="true" foreignKey="city.cityId"/&gt;
 *  </pre>
 *  With this declaration, whenever Records are loaded from the Country DataSource, they will
 *  contain a list of City Records as subobjects, accessible via 
 *  <code>countryRecord.getAttributeAsRecordList("cities")</code>
 *  <var class="client">countryRecord.cities</var>
 *  <p>
 *  If loading all related "city" records is desirable in some circumstances and not others, you
 * can use {@link com.smartgwt.client.docs.serverds.OperationBinding#outputs outputs} to avoid
 * loading "city" records for certain
 *  operations.
 *  <p>
 *  <h3>Alternative: Many-To-One loading complete related object</h3>
 *  <p>
 *  For a Many-To-One relation, instead of loading just the ID of the related object, you can
 *  load the entire related object as a nested Record.  To do so, just declare the type of the
 *  field to be the ID of the related DataSource, rather than leaving type unset:
 *  <pre>
 *      &lt;field name="country" type="country" foreignKey="country.countryId"/&gt;
 *  </pre>
 *  The nested "country" Record will be available on a "city" record via 
 *  <code>cityRecord.getAttributeAsRecord("country")</code>
 *  <var class="client">cityRecord.country</var>.
 *  Saving a City record that contains a nested Country record in the "country"
 *  attribute will result in the Country being updated in JPA/Hibernate.
 *  <P>
 *  This mode is not typically used, since loading just the ID of the related Country object is
 *  more efficient if many cities are being loaded, and the related Country object can always be
 *  loaded with a second fetchData() data, which can still be done in a single HTTP request via
 *  {@link com.smartgwt.client.rpc.RPCManager#startQueue queuing}.
 *  <P>
 *  <h3>Alternative: One-To-Many loading related IDs</h3>
 *  <p>
 *  For a One-To-Many relation, instead of loading the complete list of related objects, you can
 *  load just a list of their IDs.  To do so, just omit the type declaration when declaring the
 *  relation:
 *  <pre>
 *     &lt;field name="cities" multiple="true" foreignKey="city.cityId"/&gt;
 *  </pre>
 *  When saving, if a replacement list of IDs is included in the Record, the appropriate
 *  JPA/Hibernate relationships will be updated.
 *  <P>
 *  This is very rarely used, and would typically only be used by client-side code that plans to
 *  programmatically work with the list of related IDs rather than display them in a UI
 *  component.
 *  <p>
 *  <h3><b>NOTE:</b> Bidirectional relations</h3>
 *  <p>
 *  When relations are declared, JPA and Hibernate consider only one of the two entities to be
 *  the "owner" of the relation, meaning essentially that the references that make up the
 *  relationship are stored with that entity.  When performing updates, make sure you update the
 *  entity that "owns" the relation.  All changes to relations on "non-owning" entities are
 *  silently discarded.
 */
public interface JpaHibernateRelations {
}
