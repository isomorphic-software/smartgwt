
package com.smartgwt.client.docs;

/**
 * <h3>Creating DataSources</h3>
 * DataSources can be specified in XML format, in which case the ISC server is used to load the&#010 DataSource in a JSP
 * file, or DataSources can be directly created on the client via&#010 JavaScript.&#010 <P>&#010 Whether a DataSource is
 * specified in XML or JS, identical requests will ultimately be&#010 submitted to the server, so the server integration
 * pattern is the same.  However,&#010 DataSources created in XML can be loaded and used by the Smart GWT Server,&#010
 * enabling many features including synchronized client-server validation, request bundling, &#010 file upload, and
 * optional automatic SQL/Hibernate connectivity (see the&#010 {@link com.smartgwt.client.docs.IscServer 'Server Summary'}
 * for details).&#010 <P>&#010 DataSources created on the client use the same style of creation as DataBound
 * components:&#010 <pre>&#010    isc.DataSource.create({&#010        ID:"supplyItem",&#010        fields:[&#010           
 * {name:"itemName", ... }&#010            ...&#010        ]&#010    });&#010 </pre>&#010 Reference for all properties that
 * can be set for DataSources, their fields and validators is&#010 given in the {@link com.smartgwt.client.data.DataSource}
 * class reference.&#010 <P>&#010 XML DataSources use a direct analogue of this format:&#010 <pre>&#010     &lt;DataSource
 * ID="supplyItem"&gt;&#010         &lt;fields&gt;&#010             &lt;field name="itemName" type="text"
 * title="Item"/&gt;&#010             &lt;field name="SKU"      type="text" title="SKU"&gt;&#010                
 * &lt;validators&gt;&#010                     &lt;validator type="integerRange" ... /&gt;&#010                
 * &lt;/validators&gt;&#010             &lt;/field&gt;&#010         &lt;/fields&gt;&#010     &lt;/DataSource&gt;&#010
 * </pre>&#010 XML DataSources are loaded via a special JSP tag supported by the Smart GWT Server:&#010 <pre>&#010    
 * &lt;%&#64; taglib uri="/WEB-INF/iscTaglib.xml" prefix="isomorphic" %&gt;&#010     ...&#010     &lt;SCRIPT&gt;&#010    
 * &lt;isomorphic:loadDS ID="supplyItem"/&gt;&#010     &lt;/SCRIPT&gt;&#010 </pre>&#010 Alternatively, XML DataSources can
 * be loaded by targeting a special servlet provided by &#010 the Smart GWT Server.  This servlet yields exactly the same
 * Javascript as the equivalent&#010 <code>&lt;isomorphic:loadDS/&gt;</code>, so the two methods are interchangeable. 
 * The&#010 servlet-based method is ideal in environments where JSP tags cannot be used (SmartGWT is &#010 one such
 * environment).  Example usage:&#010 <pre>&#010     &lt;SCRIPT
 * SRC=isomorphic/DataSourceLoader?dataSource=supplyItem,employees,worldDS&lt;/SCRIPT&gt;&#010 </pre>&#010 When loading an
 * XML DataSource, by default, the ISC Server will look for a file named&#010 <code>&lt;dataSourceId&gt;.ds.xml</code> in
 * the <code>/shared/ds</code> subdirectory under&#010 webroot.  The location of this directory can be changed, or
 * individual DataSources can be&#010 placed in arbitrary locations.  For more information, see&#010
 * <code>[webroot]/WEB-INF/classes/server.properties</code>.&#010 <p>
 */
public interface DataSourceDeclaration {
}
