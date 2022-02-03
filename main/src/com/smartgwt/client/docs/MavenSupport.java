
package com.smartgwt.client.docs;

/**
 * <h3>Maven Support</h3>
 * SmartGWT artifacts are not published to any public repository, but a
 * POM for each is included in the SDK, and can be used to install them to your own private Maven
 * repository.  The official
 * <a href='http://github.smartclient.com/isc-maven-plugin/' target='_blank'>Isomorphic plugin for
 * Maven</a> contains a handful of targets intended 
 * to simplify that process through automation.  Please refer to the plugin's documentation for
 * usage and examples.
 *  <p />
 * For a complete listing of artifacts installed in your environment, consult your repository
 * manager.  Where no repository manager 
 * is in use, a directory listing can often provide all the detail you need.  Once you've made an
 * artifact available to your build, 
 *  you can use it just like you'd use any other dependency.
 *  
 * 
 *  
 *  <p/>
 * Following execution of the plugin's install or deploy goal, your Maven repository will include
 * a handful of archetypes meant to 
 * jump start development with the SmartGWT framework.  Most users will want to start new projects
 * with either the 
 * <b>archetype-smartgwt-quickstart</b> or <b>archetype-smartgwt-quickstart-unprotected</b>
 * archetypes.  To generate a new project
 *  based on the former:
 *  
 *  <ol>
 *  <li><a href="https://maven.apache.org/install.html">Install Maven</a>, if necessary.</li>
 *  
 *  <li>Install SmartGWT, if necessary.
 *  <pre>
 *  mvn com.isomorphic:isc-maven-plugin:1.3.0:install \
 *     -Dproduct=SMARTGWT -Dlicense=EVAL -DbuildNumber=12.0p
 *  </pre>
 *  </li>
 *  
 *  <li>
 *  Generate a project (using LATEST as below, or the version installed for you in step 2)
 *  <pre>
 *   mvn archetype:generate \
 *     -DartifactId=my-application -Dmodule=MyApplication \
 *     -DgroupId=com.example -Dpackage=com.example.myapplication \
 *     -DarchetypeGroupId=com.isomorphic.archetype \
 *     -DarchetypeArtifactId=archetype-smartgwt-quickstart \
 *     -DarchetypeVersion=LATEST -DinteractiveMode=false
 *  </pre>
 *  </li>
 *  </ol>
 *  
 * and refer to the README in the new 'myapplication' directory for further instructions around
 * usage in Maven, Ant, and Eclipse environments.
 *  <p/>
 * To generate a project from any of the following archetypes, provide its artifactId to the above
 * command's archetypeArtifactId parameter:
 *  <p/>
 *  <ul>  
 * <li><b>archetype-smartgwt-quickstart-unprotected</b>: The recommended approach for most
 * applications, using data access / databinding with "sql" datasources</li> 
 * <li><b>archetype-smartgwt-quickstart</b>: Like archetype-smartgwt-quickstart-unprotected, but
 * includes integration with Spring Security</li>
 *    <p/>
 * <li><b>archetype-smartgwt-example-builtinds</b>: Illustrates how a single databound component
 * can be used (and re-used) with many datasources</li>
 * <li><b>archetype-smartgwt-example-customds</b>: Illustrates setting up a DataSource accessing a
 * servlet front controller (for example struts or Spring MVC controller) for the various
 * DataSource operations</li>
 * <li><b>archetype-smartgwt-example-dsdmi</b>: Illustrates setting up a DataSource that calls
 * methods on your configured server bean in response to DataSource operations (fetch, add,
 * update, remove)</li>
 * <li><b>archetype-smartgwt-example-dshibernate</b>: Illustrates the use of "hibernate"
 * datasources in 'beanless mode'</li>
 * <li><b>archetype-smartgwt-example-dshibernatederived</b>: This example illustrates the use of
 * "hibernate" datasources with 'autoDeriveSchema' to inherit fields from a Hibernate mapping or
 * bean</li>
 *    <li><b>archetype-smartgwt-example-dsjpa</b>: Illustrates the use of JPA DataSources</li>
 * <li><b>archetype-smartgwt-example-gae</b>: Illustrates an approach to running a SmartGWT
 * application on the Google App Engine standard environment using SQL DataSources</li>
 * <li><b>archetype-smartgwt-example-gaedatastore</b>: Illustrates an approach to running a
 * SmartGWT application on the Google App Engine standard environment using Google Cloud Datastore
 * as a _limited_ JPA DataSource</li>
 * <li><b>archetype-smartgwt-example-gaejpa</b>: Illustrates an approach to running a SmartGWT
 * application on the Google App Engine standard environment using JPA DataSources</li>
 * <li><b>archetype-smartgwt-example-manualhibernate</b>: Illustrates setting up a DataSource that
 * accesses your servlet controller, using Hibernate to process the requests manually via a Spring
 * MVC Controller class (not recommended)</li>
 * <li><b>archetype-smartgwt-example-restserver</b>: Illustrates use of the Smart GWT RESTHandler
 * servlet to easily provide data access to clients other than Smart GWT / SmartGWT (mobile,
 * Swing, native, etc).</li>
 * <li><b>archetype-smartgwt-example-spring-hibernate3-dmi</b>: Illustrates a DataSource accessing
 * a Spring bean using Direct Method Invocation (DMI), which then services the request manually
 * via Hibernate.</li>
 *  </ul>
 * 
 * 
 */
public interface MavenSupport {
}
