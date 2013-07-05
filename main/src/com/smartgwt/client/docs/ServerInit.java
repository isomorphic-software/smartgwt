
package com.smartgwt.client.docs;

/**
 * <h3>Server Framework Initialization</h3>
 * The Smart GWT Server framework must be initialized from its config files at startup
 *  time, before user code invokes <em>any</em> framework functionality.  If you are running
 *  standalone (ie, outside of a servlet container), you should call the static utility method 
 *  <code>ISCInit.go()</code> early in your bootstrap code (eg, from the top of your 
 *  <code>main()</code> method).
 *  <p>
 *  If you are running inside a servlet engine, there are two ways to initialize the framework:
 *  <ul>
 *  <li>Install <code>InitListener</code>, which is a <code>ServletContextListener</code>:<br>
 *  <pre>   &lt;listener&gt;
 *         &lt;listener-class&gt;com.isomorphic.base.InitListener&lt;/listener-class&gt;
 *     &lt;/listener&gt;</pre></li>
 *  <li>Install <code>Init</code>, which is a <code>Servlet</code>, to load at startup:<br>
 *  <pre>    &lt;servlet&gt;
 *         &lt;servlet-name&gt;Init&lt;/servlet-name&gt;
 *         &lt;servlet-class&gt;com.isomorphic.base.Init&lt;/servlet-class&gt;
 *         &lt;load-on-startup&gt;1&lt;/load-on-startup&gt;
 *     &lt;/servlet&gt;</pre></li>
 *  </ul>
 *  As shipped, the framework's <code>web.xml</code> file loads both of these classes, to ensure 
 *  the best chance of correct and early initialization.  The recommended approach is to use 
 *  <code>InitListener</code> if your servlet container implements the Servlet 2.4 API or 
 *  greater, because <code>ServletContextListener</code>s are guaranteed to run before any 
 *  servlets or filters are instantiated.  <code>ServletContextListener</code>s are available
 *  in Servlet API 2.3, but the requirement that they run before any filter or servlet is 
 *  initialized was not added until 2.4.  Some 2.3 servlet engines do enforce this behavior 
 *  even though it is not part of the spec; experimentation with your servlet container of 
 *  choice will be required if it only implements 2.3.
 *  <p>
 *  Note that it does no harm to leave the <code>web.xml</code> file with both <code>Init</code>
 *  and <code>InitListener</code> in place, because the framework simply ignores any request 
 *  to initialize once initialization has taken place.
 *  <p>
 *  <h4>Interaction with Spring initialization</h4>
 *  The Spring framework attempts to initialize itself in similar ways to the Smart GWT
 *  framework, and similarly it wants its own initialization to be the very first thing that 
 *  happens.  This can cause problems in certain cases.  For example, one known problem occurs
 *  when you define DataSource instances as Spring beans, and Spring gets to initialize itself 
 *  first: it attempts to instantiate a instance of the bean, which ultimately calls into 
 *  our framework code before the framework has been initialized.
 *  <p>
 *  The solution to this is to use the <code>InitListener</code>, and to ensure that it is 
 *  declared in your <code>web.xml</code> file before the Spring
 *  <code>ContextLoaderListener</code>.  The Servlet 2.3 spec states (SRV.10.3.3):<p>
 * <em>&nbsp;&nbsp;"During Web application execution, listeners are invoked in the order of their 
 *  registration."</em>
 *  <p>
 *  Therefore, declaring the Smart GWT listener before the Spring one ensures that
 *  things run in the correct order in Servlet 2.4-compatible containers, and in those Servlet
 *  2.3 containers that enforce the rule of running listeners before initializing filters or
 *  servlets.
 */
public interface ServerInit {
}
