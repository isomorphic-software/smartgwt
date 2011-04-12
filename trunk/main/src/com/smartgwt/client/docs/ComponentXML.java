
package com.smartgwt.client.docs;

/**
 * <h3>Component XML</h3>
 * As covered in the <i>QuickStart Guide</i> Chapter 4, <i>Coding</i>, Smart GWT &#010 components can be created in either
 * XML or JavaScript format.  This section covers some of&#010 the details of using the XML format, called "Smart GWT
 * component XML".&#010 <P>&#010 <b>Referring to previously created components</b>&#010 <P>&#010 To refer to another
 * component by ID in XML, use &lt;Canvas ref=/&gt;.  For example:&#010 <pre>&#010 &lt;Canvas ID="myCanvas"/&gt;&#010
 * &lt;Canvas ID="myCanvas2"/&gt;&#010 &lt;VLayout&gt;&#010     &lt;members&gt;&#010         &lt;Canvas
 * ref="myCanvas"/&gt;&#010         &lt;Canvas ref="myCanvas2"/&gt;&#010     &lt;/members&gt;&#010 &lt;/VLayout&gt;&#010
 * </pre>&#010 <P>&#010 <b>JavaScript expressions</b>&#010 <P>&#010 To embed a JavaScript expression into component XML,
 * use the &lt;JS&gt; tag.  For example:&#010 <pre>&#010 &lt;VLayout&gt;&#010    
 * &lt;width&gt;&lt;JS&gt;isc.Page.getWidth() - 20&lt;/JS&gt;&lt;/width&gt;&#010 &lt;/VLayout&gt;&#010 </pre>&#010 Note
 * that, like all component XML properties, the <code>width</code> property can be&#010 specified either as an XML
 * attribute or as a subelement.  Expressing it as a subelement, as&#010 shown above, allows the &lt;JS&gt; tag to be
 * used.&#010 <P>&#010 <b>Embedding Methods</b>&#010 <P>&#010 For {@link com.smartgwt.client.docs.StringMethods
 * StringMethods} such as {@link com.smartgwt.client.widgets.grid.ListGrid#addRecordClickHandler
 * ListGrid.recordClick},&#010 JavaScript code can be used as an ordinary element value:&#010 <pre>&#010
 * &lt;ListGrid&gt;&#010     &lt;recordClick&gt;if (record.age > 65) doSomething()&lt;/recordClick&gt;&#010
 * &lt;/ListGrid&gt;&#010 </pre>&#010 To embed an actual function definition, use the &lt;JS&gt; tag described above. 
 * For&#010 example:&#010 <pre>&#010 &lt;ListGrid&gt;&#010     &lt;recordClick&gt;&lt;JS&gt;function (viewer, record,
 * recordNum, field) {&#010          if (record.age > 65) doSomething();&#010     }&lt;/JS&gt;&lt;/recordClick&gt;&#010
 * &lt;/ListGrid&gt;&#010 </pre>&#010 Unfortunately, characters commonly used in JavaScript code, such as ampersand
 * (&amp;), are&#010 not legal inside XML element or attribute values.  For example, the expression "record !=&#010 null &&
 * record.age > 65" must be written as shown below, or it is not considered valid XML:&#010 <P>&#010 <pre>&#010
 * &lt;ListGrid&gt;&#010     &lt;recordClick&gt;&#010         if (record.status != null &amp;amp;&amp;amp; record.age > 65)
 * doSomething()&#010     &lt;/recordClick&gt;&#010 &lt;/ListGrid&gt;&#010 </pre>&#010 An alternative, for larger blocks of
 * code, is to use the XML standard "CDATA" (character&#010 data) processing directive, which allows ampersand and other
 * characters to be used without&#010 special notation:&#010 <pre>&#010 &lt;ListGrid&gt;&#010    
 * &lt;recordClick&gt;&lt;![CDATA[&#010         if (record.status != null && record.age > 65) doSomething()&#010    
 * ]]&gt;&lt;/recordClick&gt;&#010 &lt;/ListGrid&gt;&#010 </pre>&#010 <P>&#010 Overall, embedding code in XML can be
 * awkward.  Isomorphic generally recommends that&#010 significant chunks of JavaScript code, such as non-trivial custom
 * components, be moved to&#010 separate, purely JavaScript files, while code embedded in component XML is limited to
 * simple&#010 expressions and short functions.&#010 <P>&#010 <b>Troubleshooting</b>&#010 <P>&#010 XML parsing errors,
 * which happen when XML is not well-formed and would be rejected by any&#010 standard XML parser, are reported in the
 * server-side log, and, when possible, also in the&#010 client-side log within the "Results" tab of the Developer
 * Console.&#010 <P>&#010 Other issues with component XML can result from incorrect use of Smart GWT component XML&#010
 * tags.  For example, you may specify a property and it may appear to have no effect even&#010 though it clearly works in
 * other, JavaScript-based examples.  If you get this symptom, you&#010 can troubleshoot by looking at the JavaScript code
 * Smart GWT generates from component XML.&#010 <P>&#010 Smart GWT always translates Smart GWT component XML to JavaScript
 * format before&#010 execution.  This is done automatically by the &lt;isomorphic:XML&gt; tag for XML embedded in&#010 a
 * .jsp file, and you can "View Source" with your browser to see the generated XML.  You can&#010 also use the "Eval XML"
 * section in the "Results" tab of the Developer Console to see&#010 the generated JavaScript ("Show JS" button) and to
 * dynamically execute component XML ("Eval&#010 XML" button).  These facilities will help you troubleshoot issues with
 * incorrectly specified&#010 XML.&#010 <P>&#010 <b>Custom Properties</b>&#010 <P>&#010 If you specify a custom property on
 * a component in XML, for example:&#010 <pre>&#010 &lt;Canvas myProperty="false"/&gt;&#010 </pre>&#010 The value of the
 * property will be a JavaScript String.  In the above example, it would be&#010 the string "false", which is considered a
 * boolean true value in the JavaScript language.&#010 If you want a different JavaScript type, you can force a property to
 * be interpreted as a&#010 given type by using the "xsi:type" attribute:&#010 <pre>&#010 &lt;Canvas&gt;&#010    
 * &lt;myProperty xsi:type="xsd:boolean"&gt;false&lt;/myProperty&gt;&#010 &lt;/Canvas&gt;&#010 </pre>&#010 The same
 * notation works when you want to declare that an entire subobject has a given type.&#010 For example, this would cause
 * the custom property "myListGrid" to have a live&#010 {@link com.smartgwt.client.widgets.grid.ListGrid} instance as it's
 * value.  All of the properties on the &lt;myListGrid&gt; tag&#010 will be correctly interpreted as ListGrid properties
 * and have the correct types.&#010 <pre>&#010 &lt;Canvas&gt;&#010     &lt;myListGrid xsi:type="ListGrid" width="500"
 * height="600"/&gt;&#010 &lt;/Canvas&gt;&#010 </pre>&#010 If you do not want an actual live ListGrid, but rather a
 * JavaScript Object containing&#010 properties for later construction of a ListGrid, use the
 * <code>propertiesOnly</code>&#010 attribute.  For example, this code would cause the property "listGridProperties" to be
 * a&#010 JavaScript Object with properties "width" and "height", whose values would be JavaScript&#010 Numbers.&#010
 * <pre>&#010 &lt;Canvas&gt;&#010     &lt;listGridProperties xsi:type="ListGrid" propertiesOnly="true" &#010               
 * width="500" height="600"/&gt;&#010 &lt;/Canvas&gt;&#010 </pre>&#010 For your reference: "xsi" stands for "XML Schema
 * Instance"; this notation derives from XML&#010 Schema standards for explicitly specifying type inline.&#010 <P>&#010
 * <B>Custom Components</B>&#010 <P>&#010 If you use  defineClass() to define a new component class&#010 "MyListGrid" which
 * is a subclass of the built-in component ListGrid, you can create it in&#010 XML as shown below:&#010 <pre>&#010
 * &lt;ListGrid constructor="MyListGrid" width="500"/&gt;&#010 </pre>&#010 By using the &lt;ListGrid&gt; tag you advertise
 * that properties should be interpreted &#010 as <code>ListGrid</code> properties.  By specifying
 * <code>constructor</code>&#010 you tell Smart GWT what class to  create().&#010 <P>&#010 <b>Component Schema</b>&#010
 * <P>&#010 Instead of using the <code>constructor</code> and <code>xsi:type</code> attributes for&#010 custom components
 * and custom properties, you can create a {@link com.smartgwt.client.docs.ComponentSchema} that&#010 describes the custom
 * component.  Declaring a component schema allows you to use your&#010 component just like the built-in Smart GWT
 * components, and also allows your component to&#010 be used within {@link com.smartgwt.client.docs.VisualBuilder}.
 */
public interface ComponentXML {
}
