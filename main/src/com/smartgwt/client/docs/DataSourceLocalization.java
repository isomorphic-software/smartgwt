
package com.smartgwt.client.docs;

/**
 * <h3>DataSource and Component XML Localization</h3>
 * 
 *  DataSources which are declared in XML (.ds.xml files) and are read by the Smart GWT 
 *  server, which are normally loaded 
 *  by the <code>DataSourceLoader</code> servlet, can instead be 
 *  internationalized using an approach similar to the internationalization of JSP files with
 *  JSTL tags.  This approach is also supported for screens defined using 
 *  {@link com.smartgwt.client.docs.ComponentXML Component XML}.
 *  <p>
 *  <b>Note: </b>The tags we use for internationalizing Smart GWT XML files look like 
 *  standard JSTL tags; this is intentional, simply because developers are familiar with JSTL.  
 *  However, the tags are being processed by Smart GWT code, <b>not</b> JSTL, so only the 
 *  specific tags documented here are supported.
 *  <P>
 *  Given the following DataSource located in /shared/ds/supplyItem.ds.xml:
 *  <pre>
 *  &lt;DataSource ID="supplyItem"&gt;
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
 *  To localize the title and validator error string of the <code>itemName</code> field, 
 *  change the DataSource definition as follows:
 *  <pre>
 *  &lt;DataSource ID="supplyItem" xmlns:fmt="WEB-INF/"&gt;
 *      &lt;fields&gt;
 *          &lt;field name="itemName"&gt;
 *              &lt;title&gt;&lt;fmt:message key="itemTitle"/&gt;&lt;/title&gt;
 *              &lt;validators&gt;
 *                  &lt;Validator type="lengthRange" max="40"&gt;
 *    &lt;errorMessage&gt;&lt;fmt:message key="itemLengthRangeValidator"/&gt;&lt;/errorMessage&gt;
 *                  &lt;/Validator&gt;
 *              &lt;/validators&gt;
 *          &lt;/field&gt;
 *      &lt;/fields&gt;
 *  &lt;/DataSource&gt;
 *  </pre>
 *  This will cause Smart GWT Server to look for a 
 * <a
 * href=http://docs.oracle.com/javase/1.4.2/docs/api/java/util/ResourceBundle.html#getBundle%28java.lang.String,%20java.util.Locale%29>ResourceBundle</a>
 * 
 *  called "supplyItem", containing keys "itemTitle" and "itemLengthRangeValidator", and 
 *  replace the <code>&lt;fmt:message&gt;</code> tags with the values from the resource bundle
 *  in the expected way.  It obtains the user's <code>Locale</code> from the servlet request, 
 *  but you can override this if you want to force an application-specific locale, regardless of 
 * the user's operating system settings.  To do this,  specify a "locale" parameter on HTTP
 * requests to the <code>DataSourceLoader</code>
 *  and <code>IDACall</code> servlets.
 *  <p>
 *  
 *  The  locale parameter should be an underscore-separated string
 *  conforming to the rules described in 
 *  <a href=http://docs.oracle.com/javase/1.4.2/docs/guide/intl/locale.doc.html>this article</a>
 *  on Java internationalization.  For example, "fr" (French language) or "en_US" (English 
 *  language, US location).
 *  <p>
 *  As mentioned, Smart GWT Server will look for a <code>ResourceBundle</code> called 
 *  "supplyItem" in this case because it defaults to the name of the DataSource.  It is 
 *  possible to override this default at both the DataSource and field levels:
 *  <ul>
 *  <li>Specify <code>&lt;fmt:bundle&gt;</code> as a top-level DataSource tag, like this:<br>
 *  <pre>   &lt;DataSource  xmlns:fmt="WEB-INF/" ID="supplyItem"&gt;
 *       &lt;fmt:bundle basename="com.isomorphic.test.i18n" /&gt;
 *       ...
 *  &lt;/DataSource&gt;</pre></li>
 * <li>Specify the bundle name in the individual <code>&lt;fmt:message&gt;</code> tags, like
 * this:<br>
 * <pre>   &lt;title&gt;&lt;fmt:message key='title1' bundle="com.mycompany.MyProperties"
 * /&gt;&lt;/title&gt;</pre></li>
 *  </ul>
 *  When you name a resource bundle manually like this, if you qualify the name it influences
 *  where we expect to find that resource bundle.  In the above example, we would look in the 
 *  <code>com.mycompany</code> package.  For unqualified names (including the default of the 
 *  DataSource name that we use in the absence of an override), we look in the so-called 
 *  "default package", which corresponds to the root of your classes directory or the root of 
 *  a .JAR file.
 *  <p>
 *  Note that the <code>xmlns:fmt</code> attribute in the DataSource definition is required by 
 *  the XML parser if you intend to use our <code>fmt:message</code> features.  However, the 
 *  actual value you use is unimportant as long as it is present.
 *  <p>
 *  Although these examples don't show it, note that it is also possible to internationalize
 *  DataSource-level values in the same way as field-level values - for example:<pre>
 *    &lt;DataSource  xmlns:fmt="WEB-INF/" ID="i18nTest"&gt; 
 *      &lt;title&gt;&lt;fmt:message key="dsTitle" /&gt;&lt;/title&gt;
 *       ...
 *  &lt;/DataSource&gt;
 *  </pre>
 *  <h4>Unicode support</h4>
 *  The Java language insists that <code>.properties</code> files be encoded with ISO-8859-1 -
 *  in other words, that they be plain ASCII files.  This means that any non-ASCII characters 
 *  have to be escaped, like so: <b>\u1234</b>.  For languages like Russian or Japanese, that 
 *  are based on completely non-ASCII character sets, this obviously leads to 
 *  <code>.properties</code> files that are entirely escaped references, and are not 
 *  human-readable.  Although the <code>nativetoascii</code> tool is provided with Java to make 
 *  the creation of these escaped files less tedious, it is still inconvenient that this 
 *  "compilation step" is required.
 *  <p>
 *  Smart GWT avoids the need for this when localizing DataSources and Component XML by 
 *  directly supporting <code>.properties</code> files encoded with UTF-8.  To make use of this:
 *  <ul>
 *  <li>Encode your <code>.properties</code> file with UTF-8, preferably without a BOM (Byte 
 *  Order Marker).  Smart GWT Server will simply ignore the BOM in a <code>.properties</code> 
 *  file if it is present, but you may see odd behavior from other software if the BOM is 
 *  present in other types of file - for example, JSP snippets that are included in other pages.
 *  The BOM has no meaning in a UTF-8 file anyway, so we recommend just omitting it from all 
 *  your UTF-8 files (though note that doing this may confuse some editing software, 
 *  particularly on Windows)</li>
 *  <li>Encode your bootstrap file(s) in UTF-8 and set headers or meta tags to inform the
 * browser that the file is UTF-8 encoded, as described in {@link com.smartgwt.client.docs.I18n
 * this article}</li>
 *  <li>In your <code>&lt;fmt:bundle&gt;</code> tag, specify an <code>encoding</code> attribute.
 *  There are only two supported values for this attribute: "utf-8" and "iso-8859"</li>
 *  <li>You can also override the encoding in individual <code>&lt;fmt:message&gt;</code> tags,
 *  just like to can override the bundle to use.  Again, just specify an <code>encoding</code>
 *  attribute</li>
 *  <li>You can make UTF-8 encoding the global default by setting attribute
 *  <code>i18n.resourceBundle.parse.utf-8</code> to true in your <code>server.properties</code>
 *  file.  This prevents you from having to explicitly specify <code>encoding="utf-8"</code>
 *  in all your <code>.ds.xml</code> and <code>.ui.xml</code> files</li>
 *  <li>Note that <code>.properties</code> files are located and parsed by Smart GWT framework
 *  code when <code>encoding="utf-8"</code> is in force.  Our parsing code only supports 
 *  the naming conventions explained in the article linked to above; specifically, it does not 
 *  support the additional "script" and "extension" elements introduced in Java 7.  File names
 *  must be of the form "basename_language_COUNTRY_VARIANT", where "COUNTRY" and "VARIANT" are
 *  optional.  Examples: "fr", "en_US", "en_GB_POSIX"</li>
 *  </ul>
 *  <h4>Component XML</h4>
 *  All of the above applies similarly for localizing screens defined using 
 *  {@link com.smartgwt.client.docs.ComponentXML Component XML}.  For example:<pre>
 *  &lt;isomorphicXML xmlns:fmt="WEB-INF/"&gt;
 *    &lt;fmt:bundle basename="com.isomorphic.test.i18n.test" /&gt;
 *    &lt;Window ID="testWin1"&gt;
 *      &lt;title&gt;&lt;fmt:message key='title1' /&gt;&lt;/title&gt;
 *    &lt;/Window&gt;
 *  &lt;/isomorphicXML&gt;
 *  </pre>
 *  Note the following differences between localizing <code>.ds.xml</code> (DataSource) files and
 *  localizing <code>.ui.xml</code> (component XML) files: <ul>
 *  <li>The <code>&lt;isomorphicXML&gt;</code> tag, which is ordinarily only used to wrap 
 *  multiple widget definitions to give a valid XML file, is required if you are using this 
 *  internationalization technique.</li>
 *  <li>Because there is no concept of an "ID" associated with a <code>.ui.xml</code> file, 
 *  there is no default bundle like there is with DataSource definitions.  Instead, you have to
 *  specify the bundle by hand, either by adding a <code>&lt;fmt:bundle&gt;</code> tag as an 
 *  immediate child of the <code>&lt;isomorphicXML&gt;</code> tag, or by specifying 
 *  <code>bundle</code> attributes in your individual <code>&lt;fmt:message&gt;</code> tags.</li>
 *  <li>Locale can be overridden, as described for DataSources above, by 
 *  specifying a "locale" parameter on HTTP requests to the <code>ScreenLoaderServlet</code> 
 * (this is done for you when you pass a locale to the {@link
 * com.smartgwt.client.rpc.RPCManager#loadScreen RPCManager.loadScreen} method).</li>
 *  </ul>
 */
public interface DataSourceLocalization {
}
