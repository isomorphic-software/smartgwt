	    
package com.smartgwt.client.docs;

/**
 * <h3>Creating DataSources</h3>
 * DataSources can be specified in XML format, in which case the Smart GWT server is used to
 *  load the DataSource, or DataSources can be programmatically created on the client.
 *  <P>
 *  Whether a DataSource is loaded via the Smart GWT server or programmatically created
 *  client-side, identical requests will ultimately be submitted to the server.  However,
 *  DataSources defined in XML are loaded and used by the Smart GWT Server, enabling many
 *  features including synchronized client-server validation, request bundling, file upload, and
 *  optional automatic SQL/JPA/Hibernate connectivity (see the 
 *  {@link com.smartgwt.client.docs.IscServer Server Summary} for details).
 *  <P>
 *  
 *  
 *  DataSources can be programmatically created on the client like so:
 *  <pre>
 *     DataSource ds = new DataSource();
 *     ds.setID("supplyItem");
 *     DataSourceTextField nameField = new DataSourceTextField("itemName", "Name");
 *     // create other fields
 *     ds.setFields(nameField, ...);
 *  </pre>
 *  
 *  Reference for all properties that can be set for DataSources, their fields and validators is
 *  given in the {@link com.smartgwt.client.data.DataSource} class reference.
 *  <P>
 *  DataSources defined in XML declare fields, validators and other settings using XML tags:
 *  <pre>
 *      &lt;DataSource ID="supplyItem"&gt;
 *          &lt;fields&gt;
 *              &lt;field name="itemName" type="text" title="Item"/&gt;
 *              &lt;field name="SKU"      type="text" title="SKU"&gt;
 *                  &lt;validators&gt;
 *                      &lt;validator type="integerRange" ... /&gt;
 *                  &lt;/validators&gt;
 *              &lt;/field&gt;
 *          &lt;/fields&gt;
 *      &lt;/DataSource&gt;
 *  </pre>
 *  DataSources defined in XML are loaded by using the <code>DataSourceLoader</code>
 *  servlet provided by the Smart GWT Server.  This can be done as an ordinary HTML
 *  &lt;script&gt; tag as you application first loads:
 *  <pre>
 * &lt;SCRIPT
 * SRC=isomorphic/DataSourceLoader?dataSource=supplyItem,employees,worldDS&lt;/SCRIPT&gt;
 *  </pre>
 * .. or can be done on the fly via {@link com.smartgwt.client.data.DataSource#load
 * DataSource.load}.
 *  <P>
 *  Alternatively, in JSP environments, XML DataSources can be loaded via a special JSP tag
 *  supported by the Smart GWT Server:
 *  <pre>
 *      &lt;%&#64; taglib uri="/WEB-INF/iscTaglib.xml" prefix="isomorphic" %&gt;
 *      ...
 *      &lt;SCRIPT&gt;
 *      &lt;isomorphic:loadDS ID="supplyItem"/&gt;
 *      &lt;/SCRIPT&gt;
 *  </pre>
 *  <P>
 *  When loading an XML DataSource, by default, the ISC Server will look for a file named
 *  <code>&lt;dataSourceId&gt;.ds.xml</code> in the <code>/shared/ds</code> subdirectory under
 *  webroot.  The location of this directory can be changed, or individual DataSources can be
 *  placed in arbitrary locations.  For more information, see
 *  <code>[webroot]/WEB-INF/classes/server.properties</code>.
 *  <P>
 *  XML DataSources can also be generated on the fly in case the entire DataSource or portions
 *  of it are based on dynamic data.  See the server API
 *  com.isomorphic.DataSource.addDynamicDSGenerator().
 */
public interface DataSourceDeclaration {
}
