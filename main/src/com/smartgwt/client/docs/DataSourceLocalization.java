
package com.smartgwt.client.docs;

/**
 * <h3>DataSource Localization</h3>
 * &#010 DataSources which are declared in XML (.ds.xml files) and are read by the Smart GWT &#010 server, which are
 * normally loaded &#010 by the <code>DataSourceLoader</code> servlet, can instead be &#010 loaded and interpreted as .jsp
 * files via the technique described below.  This allows JSTL&#010 and other JSP tags to be used to internationalize the
 * titles and validation error messages &#010 in XML DataSources.&#010 <P>&#010 For example, given the following DataSource
 * located in /shared/ds/supplyItem.ds.xml:&#010 <pre>&#010 &lt;DataSource&gt;&#010     &lt;fields&gt;&#010        
 * &lt;field name="itemName"&gt;&#010             &lt;title&gt;Item Name&lt;/title&gt;&#010            
 * &lt;validators&gt;&#010                 &lt;Validator type="lengthRange" max="40"&gt;&#010                    
 * &lt;errorMessage&gt;Must be 40 characters or less.&lt;/errorMessage&gt;&#010                 &lt;/Validator&gt;&#010    
 * &lt;/validators&gt;&#010         &lt;/field&gt;&#010     &lt;/fields&gt;&#010 &lt;/DataSource&gt;&#010 </pre>&#010 To
 * localize the title and validator error string of the <code>itemName</code> field &#010 via standard JSTL tags, first add
 * the following to your web.xml to allow DataSource files to&#010 be interpreted as JSPs:&#010 <pre>&#010
 * &lt;jsp-config&gt;&#010     &lt;jsp-property-group&gt;&#010      
 * &lt;url-pattern&gt;/shared/ds/*&lt;/url-pattern&gt;&#010     &lt;/jsp-property-group&gt;     &#010
 * &lt;/jsp-config&gt;&#010 </pre>&#010 Next change the DataSource definition as follows:&#010 <pre>&#010 &lt;!--&#010
 * &lt;%@ taglib prefix="fmt" uri="/WEB-INF/fmt.tld" %&gt;&#010 --&gt;&#010 &lt;DataSource
 * xmlns:fmt="urn:jsptld:/WEB-INF/fmt.tld"&gt;&#010     &lt;fields&gt;&#010         &lt;field name="itemName"&gt;&#010     
 * &lt;title&gt;&lt;fmt:message key="itemTitle"&gt;&lt;/title&gt;&#010             &lt;validators&gt;&#010                
 * &lt;Validator type="lengthRange" max="40"&gt;&#010                     &lt;errorMessage&gt;&lt;fmt:message
 * key="itemLengthRangeValidator"/&gt;&lt;/errorMessage&gt;&#010                 &lt;/Validator&gt;&#010            
 * &lt;/validators&gt;&#010         &lt;/field&gt;&#010     &lt;/fields&gt;&#010 &lt;/DataSource&gt;&#010 </pre>&#010 Note
 * that the XML comment around the taglib declaration is intentional.  It is there to make&#010 sure the JSP parser sees
 * the tag library declaration, while the file remains valid XML.&#010 If you need to use multiple JSP tag libraries to
 * achieve your goals, simply add additional&#010 taglib declarations inside the XML comment and be sure to register the
 * tag namespace in the&#010 DataSource tag via <code>xmlns:tagName</code> as done above for the <code>fmt</code>&#010
 * namespace. &#010 &#010 &#010 Instead of using the <code>DataSourceLoader</code> servlet to load this DataSource,
 * you&#010 should create a JSP that uses SmartGWT Server's XML conversion tag to return Javascript&#010 DataSource
 * definitions to the browser (exactly like <code>DataSourceLoader</code> does):&#010 Using this example as a base, just
 * add a <code>jsp:include</code> line for each of your&#010 DataSources that requires i18n support:&#010 <pre>&#010 &lt;%@
 * taglib uri="/WEB-INF/iscTaglib.xml" prefix="isomorphic" %&gt;&#010 &lt;isomorphic:XML&gt;&#010 &lt;jsp:include
 * page="/shared/ds/supplyItem.ds.xml"&gt;&lt;/jsp:include&gt;&#010 &lt;jsp:include
 * page="/shared/ds/supplyCategory.ds.xml"&gt;&lt;/jsp:include&gt;&#010 &lt;/isomorphic:XML&gt;&#010 </pre>&#010 You then
 * refer to this JSP in a <code>&lt;script src=...&gt;</code> tag, in place of &#010 the <code>DataSourceLoader</code>
 * reference.  For example, if you named the file&#010 "dataSourceLoader.jsp":&#010 <p><code>&#010 &lt;script
 * src=dataSourceLoader.jsp&gt;&lt;/script&gt;&#010 </code><p>&#010 &#010 This makes it possible to internationalize field
 * titles as well as validation error messages&#010 for built-in validators.  To internationalize custom server-side
 * validation errors, simply&#010 provide internationalized strings when calling <code>DSResponse.setErrorReport()</code>
 * to&#010 report validation errors (see the JavaDoc for that documentation).
 */
public interface DataSourceLocalization {
}
