
package com.smartgwt.client.docs;

/**
 * <h3>Server Scripting</h3>
 * Smart GWT allows you to embed "scriptlets" directly in your .ds.xml file to take care of
 *  simple business logic without having to create a separate file or class to hold the logic.
 *  <P>
 *  These scriptlets can be written in any language supported by the Java "JSR 223" standard,
 * including Java itself, as well as languages such as Groovy, JavaScript, Velocity, Python, Ruby,
 *  Scala and Clojure.
 *  <P>
 * Scriptlets are automatically recompiled when you change the .ds.xml file - just reload the page
 *  and the Smart GWT Server Framework automatically notices the modified DataSource file and
 *  uses the new scriptlets.
 *  <P>
 *  <b>Declaring Scriptlet Language</b>
 *  <P>
 *  You can set the default system-wide language in server.properties by setting
 *  <code>script.defaultLanguage</code>:
 *  <pre>
 *      script.defaultLangauge: "groovy"
 *  </pre>
 * Alternatively, anywhere a scriptlet is allowed, you can use the "language" attribute to declare
 *  the language.  For example:
 *  <pre>
 *     &lt;operationBindings&gt;
 *        &lt;operationBinding operationType="add"&gt;
 *            &lt;script language="groovy"&gt;
 *               ... Groovy code ...
 *            &lt;/script&gt;
 *        &lt;/operationBinding&gt;
 *     &lt;/operationBindings&gt;
 *  </pre>
 *  <h3>Error Reporting</h3>
 *  <P>
 *  If your scriptlet crashes, this is reported in the server-side log along with the line number
 *  of the crash.  
 *  <pre>
 *       &lt;!-- crash will be reported at line 1 --&gt;
 *       &lt;script&gt;crash()&lt;/script&gt;
 * 
 *       &lt;!-- crash will be reported at line 2 --&gt;
 *       &lt;script&gt;
 *           crash()
 *       &lt;/script&gt;
 *  </pre>
 * It's common practice to use a CDATA tag so that XML-special characters such as &lt; do not have
 * to be
 * quoted as &amp;lt;.  When doing this, be aware that the line numbering will still start <b>from
 * the
 *  &lt;script&gt; tag</b>, not the CDATA tag.  For example:
 *  <pre>
 *       &lt;!-- crash will be reported at line 3 --&gt;
 *       &lt;script&gt;
 *           &lt;![CDATA[ 
 *              5 < crash()
 *           ]]&gt;
 *       &lt;/script&gt;
 * 
 *       &lt;!-- crash will be reported at line 2 --&gt;
 *       &lt;script&gt;&lt;![CDATA[ 
 *            5 < crash()
 *       ]]&gt;&lt;/script&gt;
 *  </pre>
 *  <P>
 *  <h3>Java Imports</h3>
 *  <P>
 *  You can import Java libraries by placing a &lt;scriptImport&gt; tag immediately before a
 *  &lt;script&gt; or &lt;serverCondition&gt; tag, like so:
 *  <pre>
 *      &lt;scriptImport&gt;javax.servlet.http.*&lt;/scriptImport&gt;
 *      &lt;script language="groovy"&gt;
 *          String sessionId = session.getId();
 *          ...
 *  </pre>
 *  There is also a system-wide set of default imports:
 *  <pre>
 *  java.util.*
 *  javax.servlet.http.*
 *  com.isomorphic.base.Config
 *  com.isomorphic.util.*
 *  com.isomorphic.datasource.*
 *  com.isomorphic.rpc.RPCManager
 *  </pre>
 *  You can override these in server.properties via the property
 * <code>script.defaultImports</code>, which takes a comma- or space-separated list of packages or
 *  classes (like the above).
 *  <P>
 *  Dynamic languages such as Groovy or JavaScript allow you to place an import inside the script
 *  itself as well.
 *  <P>
 *  <h3>Available Languages</h3>
 *  <P>
 *  The Oracle JDK and JRE include support for JavaScript scripting via the Rhino engine.
 * Alternatively, you may wish to consider <a href='http://code.google.com/p/jav8/'
 * onclick="window.open('http://code.google.com/p/jav8/');return false;">jav8</a>,
 *  which is a Javascript JSR223 scripting implementation based on the V8 engine, giving 
 *  Javascript execution speeds comparable to Google Chrome.
 *  <p>
 *  For convenience, Smart GWT also bundles a .jar providing Groovy support from 
 * <a href='http://groovy.codehaus.org' onclick="window.open('http://groovy.codehaus.org');return
 * false;">http://groovy.codehaus.org</a>, which uses the Apache license.  We also include
 *  a .jar file providing Java language support.  This implementation is based on the BSD-licensed
 * <a href='http://java.net/projects/scripting/'
 * onclick="window.open('http://java.net/projects/scripting/');return false;">Java.net</a>
 * implementation, but enhanced by
 *  Isomorphic to work around container-specific classloader issues that arise when running Java
 *  language scripting inside a servlet container and trying to reference common objects of the
 *  servlet API itself.  See {@link com.smartgwt.client.docs.SunNotice} for licensing information.
 *  <P>
 *  There are <b>many</b> other languages available, sometimes with multiple implementations, and
 *  they are best found via web search.
 *  <P>
 *  <h3>Standard Headers &amp; Footers</h3>
 *  <P>
 *  You can define system-wide headers and footers for each language - code that is added before
 *  and after scriptlets wherever it is defined, and can set up variables or functions you use
 *  often.  To define the location of header and footer files, set
 * <code>script.<i>languageName</i>.header</code> and
 * <code>script.<i>languageName</i>.footer</code>
 *  in server.properties.  For example, these settings:
 *  <pre>
 *    script.java.header: $webRoot/shared/header.java
 *    script.java.footer: $webRoot/shared/footer.java
 *  </pre>
 * would add the Java fragments found in header.java and footer.java to beginning and end of every
 *  scriptlet that declares language="java" (or declares no language if the default engine is
 *  "java").
 *  <P>
 *  <b>NOTE</b>: most scripting engines are available under several language names.  For example,
 *  the Rhino JavaScript engine registers both "javascript" and "ecmascript" as well as a few
 * variations on letter case.  When using the "language" attribute on script tags, the exact value
 *  supplied is used to look up header and footer files via server.properties.  This means a
 * language setting of "javascript" will find different header and footer files from a language of
 *  "JavaScript" even though both will execute via Rhino.
 *  <P>
 *  <h3>Java scriptlets and the default script wrapper</h3>
 *  <P>
 *  Although it's not usually considered a "scripting language", using the Java language for
 * scriplets has the advantage that developers do not need to understand two languages in order to
 *  modify server-side code.  However, using Java for scripting presents special challenges,
 *  because unlike true scripting languages, in Java a piece of code cannot be compiled unless it
 *  forms a valid class definition.  
 *  <P>
 *  For this reason, by default every Java scriplet has an implicit wrapper added around it which
 *  makes it into a class definition of a trivial class with one method, and your scriptlet code
 *  forms the body of that method, after a series of local variables have been set up to allow
 *  convenient access to context variables.  The header and footer files you've defined, if any,
 *  appear before and after your scriptlet, still within the method body.
 *  <P>
 *  This makes Java viable as a scripting language despite its verbosity - if the actual business
 *  logic to be executed consists of just a few lines of Java, your overall scriptlet will be only
 *  that long instead of being forced to contain a complete class definition.
 *  <P>
 *  The automatic wrapping of Java code can be disabled by setting
 *  <code>script.java.useDefaultScriptWrapper</code> to false in server.properties.  In this case
 *  any scriptlet must contain a valid class definition like the below - context variables need to
 *  be manually retrieved from the ScriptContext object instead of being automatically
 *  available as local variables, and the attribute "evalResult" is used to return data in lieu of
 *  using a <code>return</code> statement.
 *  <P>
 *  <pre>
 *  class Temp {
 *      private static ScriptContext ctx;
 *      public static void setScriptContext(ScriptContext context) {
 *          ctx = context;
 *      }
 *      public static void main(String[] args) {
 *          String result = "Hello World!";
 *          ctx.setAttribute("evalResult", result, 
 *                           ScriptContext.ENGINE_SCOPE);
 *      }
 *  }
 *  </pre>
 *  All scriptlets must also import javax.script.ScriptContext.  For obvious reasons setting
 *  <code>useDefaultScriptWrapper</code> to false is not recommended.
 *  <P>
 *  <h3>Returning values and JavaScript</h3>
 *  <P>
 *  Scriptlets written in Java <b>must</b> use a <code>return</code> statement to return a
 *  result from the scriptlet.  Scriptlets written in JavaScript <code>must not</code> use a
 *  <code>return</code> as Rhino will report this as an error - the JavaScript code is not
 *  executed in the scope of a function, and only functions can <code>return</code>.
 *  <P>
 *  Instead, JavaScript scriptlets should simply end with a statement indicating the value
 *  they would like to return.  For example:
 *  <pre>
 *      // if used as the last line, the scriptlet 
 *      // returns the result of dsRequest.execute();
 *      dsRequest.execute();
 * 
 *      // if you already have the value as a variable,
 *      // just end with the variable name plus semicolon
 *      var dsResponse = dsRequest.execute();
 *      dsResponse;
 * 
 *      // add a line like this to force returning null 
 *      // instead of the result of the previous line of code
 *      null;
 *  </pre>
 *  Groovy makes the <code>return</code> statement optional, and like JavaScript, will take the
 *  value of the last statement as the returned value if there is no explicit
 *  <code>return</code>.
 *  <P>
 *  Other languages supported by JSR223 may have other special semantics for returning data - see
 *  their documentation for details.
 *  <P>
 *  <h3>Available context variables for scriptlets</h3>
 *  <P>
 *  Context variables that are available to a scriptlet are explained in the documentation for the
 *  particular property where a scriptlet may be declared, for example,
 * {@link com.smartgwt.client.docs.serverds.OperationBinding#script script} and {@link
 * com.smartgwt.client.docs.serverds.Validator#serverCondition serverCondition}.
 *  <P>
 *  In most JSR223 languages, context variables are available as ordinary local variables and you
 *  can simply refer to them directly in your scriptlet.  This includes Java, so long as
 *  useDefaultScriptWrapper is left in it's default setting (see above).
 */
public interface ServerScript {
}
