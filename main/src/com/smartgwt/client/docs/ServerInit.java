
package com.smartgwt.client.docs;

/**
 * <h3>Server Framework Initialization</h3>
 * The Smart GWT Server framework must be initialized from its config files at startup
 *  time, before user code invokes <em>any</em> framework functionality.  If you are running
 *  standalone (ie, outside of a servlet container), you should call the static utility method 
 *  <code>ISCInit.go()</code> early in your bootstrap code (eg, from the top of your 
 *  <code>main()</code> method).
 *  <p>
 *  If you are running inside a servlet engine, install the following listener in your web.xml.
 *  Ideally this should be the first listener registered in web.xml because part of the init
 *  logic exports database connections configured via server.properties via JNDI for consumption
 *  by other frameworks (Spring, Hibernate, etc).  See also below for other rationale related to
 *  Spring.
 *  <ul>
 *  <li>Install <code>InitListener</code>, which is a <code>ServletContextListener</code>:<br>
 *  <pre>   &lt;listener&gt;
 *         &lt;listener-class&gt;com.isomorphic.base.InitListener&lt;/listener-class&gt;
 *     &lt;/listener&gt;</pre></li>
 *  </ul>
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
