
package com.smartgwt.client.docs;

/**
 * <h3>&lt;isomorphic:XML&gt;</h3>
 * <i>produces:</i> JavaScript&#010 <p>&#010 This tag converts Smart GWT UI components declaratively specified in the body
 * of the tag to&#010 JavaScript for execution in the browser.&#010 <p>&#010 The XML->JS translation works just like with
 * {@link loadUITag}, but the XML is read&#010 from the body of the tag.  If you wish, you can also specify an external
 * filename, and XML&#010 will be read from that file, in addition to any XML encountered in the body of the tag.  If&#010
 * you do specify that an external file should be read, it is read from a path starting in &#010 your webroot (as opposed
 * to the <code>&lt;loadUI&gt;</code> tag, which looks in &#010 <code>shared/ui</code>) &#010 &#010 <p>&#010 Note that this
 * JSP tag must be surrounded by &lt;SCRIPT&gt; tags in the JSP because it&#010 generates JavaScript code.  Like other tags
 * that generate JavaScript code, this tag can be&#010 used in a JSP that is included from your main page in order to
 * create separate&#010 cacheability.  For example:<pre>&#010     &lt;SCRIPT
 * SRC="myUIDefinitions.jsp"&gt;&lt;/SCRIPT&gt;&#010 </pre>&#010 <p>&#010 Example of using this tag :&#010 <pre>&#010
 * &lt;isomorphic:XML&gt;&#010 &lt;Canvas&nbsp;backgroundColor="black"/&gt;&#010 &lt;/isomorphic:XML&gt;&#010 </pre>&#010
 * Would output the following JavaScript code:&#010 <pre>&#010 Canvas.create({&#010   backgroundColor: "black"&#010
 * });&#010 </pre>&#010 <p>&#010 <b><u>Tag Attributes:</u></b>&#010 <p>&#010 <b>filename</b><br>&#010 <i>value format</i>:
 * String - name of XML file to load (including the "XML" extension)<br>&#010 <i>default value</i>: NONE&#010 <p>&#010 This
 * optional attribute specifies the name of an XML file to read and convert.&#010 <p>&#010 An example that specifies both a
 * filename and some XML in the tag body:&#010 <pre>&#010 &lt;isomorphic:XML name="test.xml"&gt;&#010   &lt;Canvas
 * backgroundColor="red"/&gt;&#010 &lt;/isomorphic:XML&gt;&#010 </pre>
 */
public interface XmlTag {
}
