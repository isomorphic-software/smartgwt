	    
package com.smartgwt.client.docs;

/**
 * <h3>&lt;isomorphic:XML&gt;</h3>
 * <i>produces:</i> JavaScript
 *  <p>
 *  This tag converts Smart GWT UI components declaratively specified in the body of the tag to
 *  JavaScript for execution in the browser.
 *  <p>
 *  The XML->JS translation works just like with {@link loadUITag}, but the XML is read
 *  from the body of the tag.  If you wish, you can also specify an external filename, and XML
 *  will be read from that file, in addition to any XML encountered in the body of the tag.  If
 *  you do specify that an external file should be read, it is read from a path starting in 
 *  your webroot (as opposed to the <code>&lt;loadUI&gt;</code> tag, which looks in 
 *  <code>shared/ui</code>) 
 *  
 *  <p>
 *  Note that this JSP tag must be surrounded by &lt;SCRIPT&gt; tags in the JSP because it
 *  generates JavaScript code.  Like other tags that generate JavaScript code, this tag can be
 *  used in a JSP that is included from your main page in order to create separate
 *  cacheability.  For example:<pre>
 *      &lt;SCRIPT SRC="myUIDefinitions.jsp"&gt;&lt;/SCRIPT&gt;
 *  </pre>
 *  <p>
 *  Example of using this tag :
 *  <pre>
 *  &lt;isomorphic:XML&gt;
 *  &lt;Canvas&nbsp;backgroundColor="black"/&gt;
 *  &lt;/isomorphic:XML&gt;
 *  </pre>
 *  Would output the following JavaScript code:
 *  <pre>
 *  Canvas.create({
 *    backgroundColor: "black"
 *  });
 *  </pre>
 *  <p>
 *  <b><u>Tag Attributes:</u></b>
 *  <p>
 *  <b>filename</b><br>
 *  <i>value format</i>: String - name of XML file to load (including the "XML" extension)<br>
 *  <i>default value</i>: NONE
 *  <p>
 *  This optional attribute specifies the name of an XML file to read and convert.
 *  <p>
 *  An example that specifies both a filename and some XML in the tag body:
 *  <pre>
 *  &lt;isomorphic:XML name="test.xml"&gt;
 *    &lt;Canvas backgroundColor="red"/&gt;
 *  &lt;/isomorphic:XML&gt;
 *  </pre>
 */
public interface XmlTag {
}
