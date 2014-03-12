
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
 *  <span class="client">countryRecord.cities</span>
 *  <p>
 *  If loading all related "city" records is desirable in some circumstances and not others, you
 * can use {@link com.smartgwt.client.docs.serverds.OperationBinding#outputs outputs} to avoid
 * loading "city" records for certain
 *  operations.
 *  <p>
 *  <h3>Many-To-Many Relations</h3>
 * An example of Many-To-Many relation is that Students have multiple Courses and each Course has 
 *  multiple Students. In Java each Student bean has a list of Courses and each Course bean has a 
 *  list of Students. In database tables are linked using additional table holding references to 
 *  both students and courses.
 *  <P>
 * To set up Many-To-Many relation between data sources you need to set up One-To-Many relation on
 * 
 *  both sides.
 *  <P>
 *  For example students DataSourceField for CourseDS data source:
 *  <pre>
 *      &lt;field name="students" type="integer" foreignKey="StudentDS.id" multiple="true" /&gt;
 *  </pre>
 *  and courses DataSourceField for StudentDS data source:
 *  <pre>
 *      &lt;field name="courses" type="integer" foreignKey="CourseDS.id" multiple="true" /&gt;
 *  </pre>
 *  Note that type attribute can be safely omitted here.
 *  <P>
 *  <b>Note</b> that alternative type declaration to be ID of related data source (as in regular 
 * One-To-Many relation case) would work as expected, but is <b>not recommended</b> to use, cause 
 * it would result in getting lots of copies of same data. Smartclient server will prevent
 * infinite 
 *  loops, but still lots of unnecessary data will be sent to client.
 *  <P>
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
 *  .
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
 *  <p>
 *  <h3>Search criteria on One-to-Many and Many-to-Many relations</h3>
 *  <p>
 *  The following  search operators are supported with the behaviors listed
 *  below.  For simple Criteria, criteria values are treated identically to the "equals"
 * operator and the {@link com.smartgwt.client.data.DSRequest#getTextMatchStyle textMatchStyle} is
 * ignored.
 *  <P>
 * Examples are given in terms of a "country" DataSource that has a one-to-many relation with a
 * "city"
 *  DataSource through a relation field called "cities"
 *  <p>
 *  <table border=1 class="normal">
 *  <tr>
 *  <td>Operator</td><td>Behavior</td>
 *  </tr>
 *  <tr>
 *  <td><code>isNull</code></td><td>matches country records which have no related cities</td>
 *  </tr>
 *  <tr>
 * <td><code>notNull</code></td><td>matches country records which have at least one related
 * city</td>
 *  </tr>
 *  <tr>
 *  <td><code>equals, notEqual</code></td><td>
 *  <code>criterion.value</code> should be a primaryKey value for the related
 *  city DataSource.  This criterion matches any country which
 *  contains the passed city (or for "notEqual", matches any country which
 *  <b>does not</b> contain the passed city.  
 *  </td>
 *  </tr>
 *  <tr>
 *  <td><code>inSet, notInSet</code></td><td>
 *  <code>criterion.value</code> should an array of primaryKey values for the
 *  related city DataSource.  This criterion matches any country which
 *  contains <b>any</b> of the passed cities (or for "notInSet", which
 *  contains <b>none</b> of the passed cities).</td>
 *  </tr>
 *  </table>
 *  The following is an example of a criterion for matching a "country" records which have related
 *  cities with primaryKey values 1, 2 or 3 (shown serialized as JSON):
 *  <pre>
 *    {fieldName:"cities", operator:"inSet", value:[1,2,3]}
 *  </pre>
 *  As an alternative syntax, "equals", "notEqual", "inSet" and "notInSet" will also allow
 *  <code>criterion.value</code> to be specified as a list of Objects, each containing the
 *  primaryKey field and its value:
 *  <pre>
 *       {fieldName:"cities",operator:"inSet",value:[{cityId:1},{cityId:2},cityId:3]}
 *  </pre>
 *  The operators explained above work the same way for Many-To-Many relation fields.
 *  <p>
 *  Any other operator applied to a relation field will cause a warning to be logged, and will be
 *  treated as though the criterion were not present (matches all records).
 */
public interface JpaHibernateRelations {
}
