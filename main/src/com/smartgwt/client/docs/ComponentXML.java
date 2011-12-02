
package com.smartgwt.client.docs;

/**
 * <h3>Component XML</h3>
 * As covered in the <i>QuickStart Guide</i> Chapter 4, <i>Coding</i>, Smart GWT 
 *  components can be created in either XML or JavaScript format.  This section covers some of
 *  the details of using the XML format, called "Smart GWT component XML".
 *  <P>
 *  <b>Referring to previously created components</b>
 *  <P>
 *  To refer to another component by ID in XML, use &lt;Canvas ref=/&gt;.  For example:
 *  <pre>
 *  &lt;Canvas ID="myCanvas"/&gt;
 *  &lt;Canvas ID="myCanvas2"/&gt;
 *  &lt;VLayout&gt;
 *      &lt;members&gt;
 *          &lt;Canvas ref="myCanvas"/&gt;
 *          &lt;Canvas ref="myCanvas2"/&gt;
 *      &lt;/members&gt;
 *  &lt;/VLayout&gt;
 *  </pre>
 *  <P>
 *  <b>JavaScript expressions</b>
 *  <P>
 *  To embed a JavaScript expression into component XML, use the &lt;JS&gt; tag.  For example:
 *  <pre>
 *  &lt;VLayout&gt;
 *      &lt;width&gt;&lt;JS&gt;isc.Page.getWidth() - 20&lt;/JS&gt;&lt;/width&gt;
 *  &lt;/VLayout&gt;
 *  </pre>
 *  Note that, like all component XML properties, the <code>width</code> property can be
 *  specified either as an XML attribute or as a subelement.  Expressing it as a subelement, as
 *  shown above, allows the &lt;JS&gt; tag to be used.
 *  <P>
 *  <b>Embedding Methods</b>
 *  <P>
 * For {@link com.smartgwt.client.docs.StringMethods StringMethods} such as {@link
 * com.smartgwt.client.widgets.grid.ListGrid#addRecordClickHandler ListGrid.recordClick},
 *  JavaScript code can be used as an ordinary element value:
 *  <pre>
 *  &lt;ListGrid&gt;
 *      &lt;recordClick&gt;if (record.age > 65) doSomething()&lt;/recordClick&gt;
 *  &lt;/ListGrid&gt;
 *  </pre>
 *  To embed an actual function definition, use the &lt;JS&gt; tag described above.  For
 *  example:
 *  <pre>
 *  &lt;ListGrid&gt;
 *      &lt;recordClick&gt;&lt;JS&gt;function (viewer, record, recordNum, field) {
 *           if (record.age > 65) doSomething();
 *      }&lt;/JS&gt;&lt;/recordClick&gt;
 *  &lt;/ListGrid&gt;
 *  </pre>
 *  Unfortunately, characters commonly used in JavaScript code, such as ampersand (&amp;), are
 *  not legal inside XML element or attribute values.  For example, the expression "record !=
 *  null && record.age > 65" must be written as shown below, or it is not considered valid XML:
 *  <P>
 *  <pre>
 *  &lt;ListGrid&gt;
 *      &lt;recordClick&gt;
 *          if (record.status != null &amp;amp;&amp;amp; record.age > 65) doSomething()
 *      &lt;/recordClick&gt;
 *  &lt;/ListGrid&gt;
 *  </pre>
 *  An alternative, for larger blocks of code, is to use the XML standard "CDATA" (character
 *  data) processing directive, which allows ampersand and other characters to be used without
 *  special notation:
 *  <pre>
 *  &lt;ListGrid&gt;
 *      &lt;recordClick&gt;&lt;![CDATA[
 *          if (record.status != null && record.age > 65) doSomething()
 *      ]]&gt;&lt;/recordClick&gt;
 *  &lt;/ListGrid&gt;
 *  </pre>
 *  <P>
 *  Overall, embedding code in XML can be awkward.  Isomorphic generally recommends that
 *  significant chunks of JavaScript code, such as non-trivial custom components, be moved to
 *  separate, purely JavaScript files, while code embedded in component XML is limited to simple
 *  expressions and short functions.
 *  <P>
 *  <b>Troubleshooting</b>
 *  <P>
 *  XML parsing errors, which happen when XML is not well-formed and would be rejected by any
 *  standard XML parser, are reported in the server-side log, and, when possible, also in the
 *  client-side log within the "Results" tab of the Developer Console.
 *  <P>
 *  Other issues with component XML can result from incorrect use of Smart GWT component XML
 *  tags.  For example, you may specify a property and it may appear to have no effect even
 *  though it clearly works in other, JavaScript-based examples.  If you get this symptom, you
 *  can troubleshoot by looking at the JavaScript code Smart GWT generates from component XML.
 *  <P>
 *  Smart GWT always translates Smart GWT component XML to JavaScript format before
 *  execution.  This is done automatically by the &lt;isomorphic:XML&gt; tag for XML embedded in
 *  a .jsp file, and you can "View Source" with your browser to see the generated XML.  You can
 *  also use the "Eval XML" section in the "Results" tab of the Developer Console to see
 *  the generated JavaScript ("Show JS" button) and to dynamically execute component XML ("Eval
 *  XML" button).  These facilities will help you troubleshoot issues with incorrectly specified
 *  XML.
 *  <P>
 *  <b>Custom Properties</b>
 *  <P>
 *  If you specify a custom property on a component in XML, for example:
 *  <pre>
 *  &lt;Canvas myProperty="false"/&gt;
 *  </pre>
 *  The value of the property will be a JavaScript String.  In the above example, it would be
 *  the string "false", which is considered a boolean true value in the JavaScript language.
 *  If you want a different JavaScript type, you can force a property to be interpreted as a
 *  given type by using the "xsi:type" attribute:
 *  <pre>
 *  &lt;Canvas&gt;
 *      &lt;myProperty xsi:type="xsd:boolean"&gt;false&lt;/myProperty&gt;
 *  &lt;/Canvas&gt;
 *  </pre>
 *  The same notation works when you want to declare that an entire subobject has a given type.
 *  For example, this would cause the custom property "myListGrid" to have a live
 * {@link com.smartgwt.client.widgets.grid.ListGrid} instance as it's value.  All of the properties on the
 * &lt;myListGrid&gt; tag
 *  will be correctly interpreted as ListGrid properties and have the correct types.
 *  <pre>
 *  &lt;Canvas&gt;
 *      &lt;myListGrid xsi:type="ListGrid" width="500" height="600"/&gt;
 *  &lt;/Canvas&gt;
 *  </pre>
 *  If you do not want an actual live ListGrid, but rather a JavaScript Object containing
 *  properties for later construction of a ListGrid, use the <code>propertiesOnly</code>
 *  attribute.  For example, this code would cause the property "listGridProperties" to be a
 *  JavaScript Object with properties "width" and "height", whose values would be JavaScript
 *  Numbers.
 *  <pre>
 *  &lt;Canvas&gt;
 *      &lt;listGridProperties xsi:type="ListGrid" propertiesOnly="true" 
 *                           width="500" height="600"/&gt;
 *  &lt;/Canvas&gt;
 *  </pre>
 *  For your reference: "xsi" stands for "XML Schema Instance"; this notation derives from XML
 *  Schema standards for explicitly specifying type inline.
 *  <P>
 *  <B>Custom Components</B>
 *  <P>
 *  If you use  defineClass() to define a new component class
 *  "MyListGrid" which is a subclass of the built-in component ListGrid, you can create it in
 *  XML as shown below:
 *  <pre>
 *  &lt;ListGrid constructor="MyListGrid" width="500"/&gt;
 *  </pre>
 *  By using the &lt;ListGrid&gt; tag you advertise that properties should be interpreted 
 *  as <code>ListGrid</code> properties.  By specifying <code>constructor</code>
 *  you tell Smart GWT what class to  create().
 *  <P>
 *  <b>Component Schema</b>
 *  <P>
 *  Instead of using the <code>constructor</code> and <code>xsi:type</code> attributes for
 *  custom components and custom properties, you can create a {@link com.smartgwt.client.docs.ComponentSchema} that
 *  describes the custom component.  Declaring a component schema allows you to use your
 *  component just like the built-in Smart GWT components, and also allows your component to
 *  be used within {@link com.smartgwt.client.docs.VisualBuilder}.
 */
public interface ComponentXML {
}
