
package com.smartgwt.client.docs;

/**
 * <h3>Creating DataSources</h3>
 * DataSources can be specified in XML format, in which case the ISC server is used to load the
 *  DataSource in a JSP file, or DataSources can be directly created on the client via
 *  JavaScript.
 *  <P>
 *  Whether a DataSource is specified in XML or JS, identical requests will ultimately be
 *  submitted to the server, so the server integration pattern is the same.  However,
 *  DataSources created in XML can be loaded and used by the Smart GWT Server,
 *  enabling many features including synchronized client-server validation, request bundling, 
 *  file upload, and optional automatic SQL/Hibernate connectivity (see the
 *  {@link com.smartgwt.client.docs.IscServer Server Summary} for details).
 *  <P>
 *  DataSources created on the client use the same style of creation as DataBound components:
 *  <pre>
 *     isc.DataSource.create({
 *         ID:"supplyItem",
 *         fields:[
 *             {name:"itemName", ... }
 *             ...
 *         ]
 *     });
 *  </pre>
 *  Reference for all properties that can be set for DataSources, their fields and validators is
 *  given in the {@link com.smartgwt.client.data.DataSource} class reference.
 *  <P>
 *  XML DataSources use a direct analogue of this format:
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
 *  XML DataSources are loaded via a special JSP tag supported by the Smart GWT Server:
 *  <pre>
 *      &lt;%&#64; taglib uri="/WEB-INF/iscTaglib.xml" prefix="isomorphic" %&gt;
 *      ...
 *      &lt;SCRIPT&gt;
 *      &lt;isomorphic:loadDS ID="supplyItem"/&gt;
 *      &lt;/SCRIPT&gt;
 *  </pre>
 *  Alternatively, XML DataSources can be loaded by targeting a special servlet provided by 
 *  the Smart GWT Server.  This servlet yields exactly the same Javascript as the equivalent
 *  <code>&lt;isomorphic:loadDS/&gt;</code>, so the two methods are interchangeable.  The
 *  servlet-based method is ideal in environments where JSP tags cannot be used (SmartGWT is 
 *  one such environment).  Example usage:
 *  <pre>
 *      &lt;SCRIPT SRC=isomorphic/DataSourceLoader?dataSource=supplyItem,employees,worldDS&lt;/SCRIPT&gt;
 *  </pre>
 *  When loading an XML DataSource, by default, the ISC Server will look for a file named
 *  <code>&lt;dataSourceId&gt;.ds.xml</code> in the <code>/shared/ds</code> subdirectory under
 *  webroot.  The location of this directory can be changed, or individual DataSources can be
 *  placed in arbitrary locations.  For more information, see
 *  <code>[webroot]/WEB-INF/classes/server.properties</code>.
 *  <p>
 */
public interface DataSourceDeclaration {
}
