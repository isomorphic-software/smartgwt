
package com.smartgwt.client.docs;

/**
 * <h3>DataSource Localization</h3>
 * 
 *  DataSources which are declared in XML (.ds.xml files) and are read by the Smart GWT 
 *  server, which are normally loaded 
 *  by the <code>DataSourceLoader</code> servlet, can instead be 
 *  loaded and interpreted as .jsp files via the technique described below.  This allows JSTL
 *  and other JSP tags to be used to internationalize the titles and validation error messages 
 *  in XML DataSources.
 *  <P>
 *  For example, given the following DataSource located in /shared/ds/supplyItem.ds.xml:
 *  <pre>
 *  &lt;DataSource&gt;
 *      &lt;fields&gt;
 *          &lt;field name="itemName"&gt;
 *              &lt;title&gt;Item Name&lt;/title&gt;
 *              &lt;validators&gt;
 *                  &lt;Validator type="lengthRange" max="40"&gt;
 *                      &lt;errorMessage&gt;Must be 40 characters or less.&lt;/errorMessage&gt;
 *                  &lt;/Validator&gt;
 *              &lt;/validators&gt;
 *          &lt;/field&gt;
 *      &lt;/fields&gt;
 *  &lt;/DataSource&gt;
 *  </pre>
 *  To localize the title and validator error string of the <code>itemName</code> field 
 *  via standard JSTL tags, first add the following to your web.xml to allow DataSource files to
 *  be interpreted as JSPs:
 *  <pre>
 *  &lt;jsp-config&gt;
 *      &lt;jsp-property-group&gt;
 *        &lt;url-pattern&gt;/shared/ds/*&lt;/url-pattern&gt;
 *      &lt;/jsp-property-group&gt;     
 *  &lt;/jsp-config&gt;
 *  </pre>
 *  Next change the DataSource definition as follows:
 *  <pre>
 *  &lt;!--
 *  &lt;%@ taglib prefix="fmt" uri="/WEB-INF/fmt.tld" %&gt;
 *  --&gt;
 *  &lt;DataSource xmlns:fmt="urn:jsptld:/WEB-INF/fmt.tld"&gt;
 *      &lt;fields&gt;
 *          &lt;field name="itemName"&gt;
 *              &lt;title&gt;&lt;fmt:message key="itemTitle"&gt;&lt;/title&gt;
 *              &lt;validators&gt;
 *                  &lt;Validator type="lengthRange" max="40"&gt;
 *                      &lt;errorMessage&gt;&lt;fmt:message key="itemLengthRangeValidator"/&gt;&lt;/errorMessage&gt;
 *                  &lt;/Validator&gt;
 *              &lt;/validators&gt;
 *          &lt;/field&gt;
 *      &lt;/fields&gt;
 *  &lt;/DataSource&gt;
 *  </pre>
 *  Note that the XML comment around the taglib declaration is intentional.  It is there to make
 *  sure the JSP parser sees the tag library declaration, while the file remains valid XML.
 *  If you need to use multiple JSP tag libraries to achieve your goals, simply add additional
 *  taglib declarations inside the XML comment and be sure to register the tag namespace in the
 *  DataSource tag via <code>xmlns:tagName</code> as done above for the <code>fmt</code>
 *  namespace. 
 *  
 *  
 *  Instead of using the <code>DataSourceLoader</code> servlet to load this DataSource, you
 *  should create a JSP that uses SmartGWT Server's XML conversion tag to return Javascript
 *  DataSource definitions to the browser (exactly like <code>DataSourceLoader</code> does):
 *  Using this example as a base, just add a <code>jsp:include</code> line for each of your
 *  DataSources that requires i18n support:
 *  <pre>
 *  &lt;%@ taglib uri="/WEB-INF/iscTaglib.xml" prefix="isomorphic" %&gt;
 *  &lt;isomorphic:XML&gt;
 *  &lt;jsp:include page="/shared/ds/supplyItem.ds.xml"&gt;&lt;/jsp:include&gt;
 *  &lt;jsp:include page="/shared/ds/supplyCategory.ds.xml"&gt;&lt;/jsp:include&gt;
 *  &lt;/isomorphic:XML&gt;
 *  </pre>
 *  You then refer to this JSP in a <code>&lt;script src=...&gt;</code> tag, in place of 
 *  the <code>DataSourceLoader</code> reference.  For example, if you named the file
 *  "dataSourceLoader.jsp":
 *  <p><code>
 *  &lt;script src=dataSourceLoader.jsp&gt;&lt;/script&gt;
 *  </code><p>
 *  
 *  This makes it possible to internationalize field titles as well as validation error messages
 *  for built-in validators.  To internationalize custom server-side validation errors, simply
 *  provide internationalized strings when calling <code>DSResponse.setErrorReport()</code> to
 *  report validation errors (see the JavaDoc for that documentation).
 */
public interface DataSourceLocalization {
}
