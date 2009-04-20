
package com.smartgwt.client.docs;

/**
 * <i>produces:</i> JavaScript <p> This tag convers SmartClient UI components declaratively specified in the body of the tag to JavaScript for execution in the browser. <p> The XML->JS translation works just like with loadUITag, except the XML is read from the body of the tag instead of an external file. <p> Note that this JSP tag must be surrounded by &lt;SCRIPT&gt; tags in the JSP because it generates JavaScript code.  Like other tags that generate JavaScript code, this tag can be used in a JSP that is included from your main page in order to create separate cacheability.  For example:<pre>     &lt;SCRIPT SRC="myUIDefinitions.jsp"&gt;&lt;/SCRIPT&gt; </pre> <p> Example of using this tag : <pre> &lt;isomorphic:XML&gt; &lt;Canvas&nbsp;backgroundColor="black"/&gt; &lt;/isomorphic:XML&gt; </pre> Would output the following JavaScript code: <pre> Canvas.create({   backgroundColor: "black" }); </pre>
 */
public interface XmlTag {
}
