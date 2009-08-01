
package com.smartgwt.client.docs;

/**
 * <i>produces:</i> JavaScript&#010 <p>&#010 This tag convers SmartGWT UI components declaratively specified in the body of
 * the tag to&#010 JavaScript for execution in the browser.&#010 <p>&#010 The XML->JS translation works just like with
 * loadUITag, except the XML is read&#010 from the body of the tag instead of an external file.&#010 <p>&#010 Note that
 * this JSP tag must be surrounded by &lt;SCRIPT&gt; tags in the JSP because it&#010 generates JavaScript code.  Like other
 * tags that generate JavaScript code, this tag can be&#010 used in a JSP that is included from your main page in order to
 * create separate&#010 cacheability.  For example:<pre>&#010     &lt;SCRIPT
 * SRC="myUIDefinitions.jsp"&gt;&lt;/SCRIPT&gt;&#010 </pre>&#010 <p>&#010 Example of using this tag :&#010 <pre>&#010
 * &lt;isomorphic:XML&gt;&#010 &lt;Canvas&nbsp;backgroundColor="black"/&gt;&#010 &lt;/isomorphic:XML&gt;&#010 </pre>&#010
 * Would output the following JavaScript code:&#010 <pre>&#010 Canvas.create({&#010   backgroundColor: "black"&#010
 * });&#010 </pre>
 */
public interface XmlTag {
}
