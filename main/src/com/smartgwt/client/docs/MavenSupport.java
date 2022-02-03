
package com.smartgwt.client.docs;

/**
 * <h3>Maven Support</h3>
 * SmartGWT artifacts are not 
 *  published to any public repository, but a POM for each is included in the SDK, and can be 
 *  used to install them to your own private Maven repository.  The official
 * <a href='http://github.smartclient.com/isc-maven-plugin/' target='_blank'>Isomorphic plugin for
 * Maven</a> 
 *  contains a handful of targets intended to simplify that process through automation.  Please
 *  refer to the plugin's documentation for usage and examples.
 *  <p />
 *  For a complete listing of artifacts installed in your environment, consult your repository
 *  manager.  Where no repository manager is in use, a directory listing of your local
 *  repository can often provide all the detail you need.  Once you've made an artifact
 *  available to your build, you can use it just like you'd use any other dependency.
 *  
 * 
 *  
 *  <p/>
 *  You can of course declare these dependencies in your existing project as you would any other.
 *  Should you be working with a single-module project (as opposed to the
 * <a href='https://maven.apache.org/guides/mini/guide-multiple-modules.html'
 * target='_blank'>multi-module</a>
 *  format recommended by authors of both
 *  <a href='https://tbroyer.github.io/gwt-maven-plugin/' target='_blank'>GWT</a> and
 * <a href='http://gwt-plugins.github.io/documentation/gwt-eclipse-plugin/maven/Maven.html'
 * target='_blank'>Eclipse</a>
 * plugins), you may find that you need to take steps to remove server-side dependencies from your
 *  client-side classpath.  The older releases of the asm library, included transitively
 *  with isomorphic-tools by way of Hibernate, has been known to cause problems for developers
 *  working in single module projects, for example.  This really is unrelated to SmartGWT itself,
 *  so you can work around it using standard classpath manipulation techniques.  In the case of
 *  asm, this can be as simple as an exclusion on the tools dependency:
 *  <pre>
 *  &lt;dependency&gt;
 *      &lt;groupId&gt;com.isomorphic.smartgwt.eval&lt;/groupId&gt;
 *      &lt;artifactId&gt;isomorphic-tools&lt;/artifactId&gt;
 *      &lt;version&gt;${smartgwt.version}&lt;/version&gt;
 *      &lt;exclusions&gt;
 *          &lt;exclusion&gt;
 *              &lt;groupId&gt;asm&lt;/groupId&gt;
 *              &lt;artifactId&gt;asm&lt;/artifactId&gt;
 *          &lt;/exclusion&gt;
 *      &lt;/exclusions&gt;
 *  &lt;/dependency&gt;
 *  </pre>
 *  <p/>
 *  Most users should at least consider converting existing projects to a multi-module format,
 *  and use one of the SmartGWT archetypes for new projects.  These archetypes are available
 *  following execution of the plugin's install or deploy goals.  To create a new project
 *  based on the smartgwt-quickstart archetype:
 *  <ol>
 *  <li><a href="https://maven.apache.org/install.html">Install Maven</a>, if necessary.</li>
 *  
 *  <li>Install SmartGWT, if necessary. <i>Note that when copy/pasting commands,
 *  you may need to substitute the backslash with the appropriate character to
 *  escape new lines in your command-line interface 
 *  (eg: <code>^</code> for Windows command-line, <code>`</code>
 *   for PowerShell, etc).</i>
 *  <pre>
 *  mvn com.isomorphic:isc-maven-plugin:1.4.5:install \
 *     -Dproduct=SMARTGWT -Dlicense=EVAL -DbuildNumber=13.0p
 *  </pre>
 *  </li>
 *  <li>
 *  Generate a project (using LATEST as below, or the version installed for you in step 2)
 *  <pre>
 *   mvn archetype:generate \
 *     -DartifactId=my-application \
 *     -Dmodule=MyApplication -Dmodule-short-name=myapp \
 *     -DgroupId=com.example -Dpackage=com.example.myapplication \
 *     -DarchetypeGroupId=com.isomorphic.archetype \
 *     -DarchetypeArtifactId=archetype-smartgwt-quickstart \
 *     -DarchetypeVersion=LATEST -DinteractiveMode=false
 *  </pre>
 *  </li>
 *  </ol>
 *  
 *  and refer to the README in the new 'my-application' directory for further instructions 
 *  around usage in Maven, Ant, and Eclipse environments.
 *  <p/>
 *  To generate a project from any of the following archetypes, provide its artifactId to the 
 *  above command's archetypeArtifactId parameter:
 *  <p/>
 *  <ul>  
 *    <li><b>archetype-smartgwt-quickstart</b>: 
 *        The recommended approach for most applications, using data access / databinding with 
 *        "sql" datasources
 *    </li> 
 *    <li><b>archetype-smartgwt-quickstart-relogin</b>: 
 *        Like archetype-smartgwt-quickstart, but includes integration with Spring 
 *        Security to illustrate the {@link com.smartgwt.client.docs.Relogin relogin} pattern.
 *    </li>
 *    <p/>
 *    <li><b>archetype-smartgwt-example-builtinds</b>:
 *        Illustrates how a single databound component can be used (and re-used) with many 
 *        datasources
 *    </li>
 *    <li><b>archetype-smartgwt-example-customds</b>:
 *        Illustrates setting up a DataSource accessing a servlet front controller (for example 
 *        Spring MVC controller) for the various DataSource operations
 *    </li>
 *    <li><b>archetype-smartgwt-example-dsdmi</b>: 
 *        llustrates setting up a DataSource that calls methods on your configured server bean 
 *        in response to DataSource operations (fetch, add, update, remove)
 *    </li>
 *    <li><b>archetype-smartgwt-example-dshibernate</b>: 
 *        llustrates the use of "hibernate" datasources in 'beanless mode'
 *    </li>
 *    <li><b>archetype-smartgwt-example-dshibernatederived</b>: 
 *        This example illustrates the use of "hibernate" datasources with 'autoDeriveSchema' 
 *        to inherit fields from a Hibernate mapping or bean
 *    </li>
 *    <li><b>archetype-smartgwt-example-dsjpa</b>: 
 *        llustrates the use of JPA DataSources
 *    </li>
 *    <li><b>archetype-smartgwt-example-gae</b>: 
 *        llustrates an approach to running a SmartGWT application on the Google App Engine 
 *        standard environment using SQL DataSources
 *    </li>
 *    <li><b>archetype-smartgwt-example-gaedatastore</b>: 
 *        llustrates an approach to running a SmartGWT application on the Google App Engine 
 *        standard environment using Google Cloud Datastore as a _limited_ JPA DataSource
 *    </li>
 *    <li><b>archetype-smartgwt-example-gaejpa</b>: 
 *        llustrates an approach to running a SmartGWT application on the Google App Engine 
 *        standard environment using JPA DataSources
 *    </li>
 *    <li><b>archetype-smartgwt-example-manualhibernate</b>: 
 *        llustrates setting up a DataSource that accesses your servlet controller, using 
 *        Hibernate to process the requests manually via a Spring MVC Controller class 
 *        (not recommended)
 *    </li>
 *    <li><b>archetype-smartgwt-example-restserver</b>: 
 * llustrates use of the Smart GWT {@link com.smartgwt.client.docs.ServletDetails RESTHandler
 * servlet} to 
 *        easily provide data access to clients other than Smart GWT / SmartGWT (mobile, 
 *        Swing, native, etc).
 *    </li>
 *    <li><b>archetype-smartgwt-example-spring-hibernate3-dmi</b>: 
 *        llustrates a DataSource accessing a Spring bean using Direct Method Invocation (DMI), 
 *        which then services the request manually via Hibernate.
 *    </li>
 *  </ul>
 * 
 *  
 * 
 */
public interface MavenSupport {
}
