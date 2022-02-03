
package com.smartgwt.client.docs;

/**
 * <h3>&lt;isomorphic:loadAssembly&gt;</h3>
 * <i>produces:</i> HTML
 *  <p>
 * This tag emits the files listed under a single FileAssemblyEntry in your {@link
 * com.smartgwt.client.docs.FileAssembly}
 * config file.  Note that as stated in the {@link com.smartgwt.client.docs.FileAssembly} docs,
 * you can always include a
 *  file assembly by writing out a properly formatted &lt;script&gt; or &lt;link&gt; HTML tag
 *  and referencing the same URI as listed in the FileAssemblyEntry that you wish to include,
 *  but the &lt;loadAssembly&gt; JSP tag provides a useful mechanism to easily switch between
 *  development and production mode (via the <b>assemble</b> attribute - see below) as well as a
 *  few other control points.
 *  <p>
 *  <b><u>Tag Attributes:</u></b>
 *  <p>
 *  <b>URI</b><br>
 *  <i>value format</i>: A URI that exactly matches one of the FileAsemblyEntry URIs in your
 *  {@link com.smartgwt.client.docs.FileAssembly} configuration file.<br>
 *  <i>default value</i>: NONE
 *  <p>
 *  This attribute selects the specific assembly that you wish to include from the file assembly
 *  config file and is required.  
 *  <p>
 *  <b>assemble</b><br>
 *  <i>value format</i>: boolean - acceptable values: "true" or "false"<br>
 *  <i>default value</i>: "true"
 *  <p>
 *  This attribute controls the manner in which the files listed in your FileAssemblyEntry are
 *  emitted onto the page.  When set to "true" (the default), the loadAssembly tag simply emits
 *  a &lt;script&gt; or &lt;link&gt; HTML tag (depending on the extension) and references the
 *  URI you specified.  This is what you want for production deployment.  
 *  <p>
 *  When set to "false",
 *  the loadAssembly tag emits separate  &lt;script&gt; or &lt;link&gt; HTML tags for each file
 *  listed under the FileAssemblyEntry.  This is what you frequently want for development
 *  because it allows browser tools like Firebug and native browser debuggers to properly report
 *  line numbers for errors in a manner that is easily traceable to the source file and
 *  location.
 *  <p>
 *  The recommended best practice is to parametrize the value of the assemble attribute based on
 *  the deployment target and use a rewrite mechanism either in your packaging script (e.g. Ant)
 *  or the deployment tool to conditionally set this value such that it is set to "false"
 *  in development and "true" in production.  For example, like so with Ant:
 *  <pre>
 *  assemble="&lt;%=\"prd\" == \"@app.server.target@\"%&gt;"
 *  </pre>
 *  Note that you then need corresponding logic in your Ant build.xml that does something like:
 *  <pre>
 *  &lt;property name="app.server.target" value="prd"/&gt;
 *  &lt;replace file="&#36;{war.dir}/your.jsp" token="@app.server.target@" value="\${app.server.target}"/&gt;
 *  </pre>
 *  <p>
 *  <b>locale</b><br>
 * <i>value format</i>: valid locale string - see {@link
 * com.smartgwt.client.docs.DataSourceLocalization} for more
 *  details and examples.<br>
 *  <i>default value</i>: as set by the OS/JVM defaults
 *  <p>
 *  <b>media</b><br>
 * <i>value format</i>: any valid value of the media attribute of the HTML &lt;link&gt;
 * element.<br>
 *  <i>default value</i>: NONE
 *  <p>
 *  This attribute is valid only for FileAssembly entries with a URI that ends with ".css".
 *  When set, the value of this attribute is output as the value of the <code>media</code>
 *  attribute of the &lt;link&gt; element that is emitted onto the page.  See
 * e.g. <a href='http://www.w3schools.com/tags/att_link_media.asp'
 * target='_blank'>http://www.w3schools.com/tags/att_link_media.asp</a> for valid values of the
 *  <code>media</code> attribute and a discussion of when/how to use them.
 *  <p>
 *  <b>configFile</b><br>
 * <i>value format</i>: Path to {@link com.smartgwt.client.docs.FileAssembly} configuration file
 * exactly as it would be
 *  supplied to the servlet config via the <code>configFile</code> init-param.<br>
 * <i>default value</i>: Automatically derived from {@link com.smartgwt.client.docs.FileAssembly}
 * servlet configuration.
 *  <p>
 * This attribute enables an explicit override of the {@link
 * com.smartgwt.client.docs.FileAssembly} config file use to
 *  match the URI entries.  Providing this value is not required - it is auto-derived
 * automatically from the settings you provide on the {@link
 * com.smartgwt.client.docs.FileAssembly} servlet.  But in rare
 *  instances (certain non-compliant servlet containers and/or extremely tight java security
 *  settings) this auto-derivation can fail and you can use this attribute to provide an
 *  explicit setting.
 */
public interface LoadAssemblyTag {
}
