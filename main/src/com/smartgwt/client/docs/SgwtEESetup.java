
package com.smartgwt.client.docs;

/**
 * <h3>Smart GWT Pro/EE Project Setup</h3>
 * The Smart GWT framework is distributed with both client and server components.  GWT components
 * run on the client, in the browser, and integrate with optional server components that run in a
 * standards-compliant <a href='https://docs.oracle.com/javaee/5/tutorial/doc/bnabo.html'
 * target='_blank'>web container</a>, like <a href='https://tomcat.apache.org/index.html'
 * target='_blank'>Tomcat</a>.  Client components don't necessarily require the server, but server
 * components are designed to make many complicated tasks trivial.  See the SmartGWT <a
 * href='https://www.smartclient.com/product/' target='_blank'>feature matrix</a> for details. <p>
 * In all cases, Isomorphic strongly recommends using some form of <a
 * href='https://devopedia.org/dependency-manager' target='_blank'>dependency management</a> in
 * your project, as it dramatically simplifies framework installation and upgrades.  Most teams
 * with Java experience are at least familiar with <a
 * href='https://maven.apache.org/guides/index.html' target='_blank'>Maven</a> so Smart GWT also
 * {@link com.smartgwt.client.docs.MavenSupport includes support} for publishing both client and
 * server components to a Maven repository.  Note that your project doesn't necessarily need to be
 * built with Maven, it just needs to be able to retrieve its dependencies from that repository.
 * <a href='https://gradle.org' target='_blank'>Gradle</a> and <a
 * href='http://ant.apache.org/ivy/index.html' target='_blank'>Ivy</a> are two popular
 * alternatives, for example. <p> Those who still wish to manage the installation manually should
 * refer to the separate documentation topic covering the {@link
 * com.smartgwt.client.docs.SgwtEEManualSetup manual installation}.  The rest of this overview
 * touches briefly on context, tips, and tricks for those who want to follow best practices but
 * may not necessarily have experience with Maven. <p> <a
 * href='https://maven.apache.org/what-is-maven.html' target='_blank'>"Maven is a software project
 * management and comprehension tool"</a>, whose key features include <a
 * href='https://maven.apache.org/guides/introduction/introduction-to-dependency-mechanism.html'
 * target='_blank'>a mechanism for dependency resolution</a> as recommended above.  In short,
 * Maven attempts to retrieve these resources first from a local <a
 * href='https://maven.apache.org/guides/introduction/introduction-to-repositories.html'
 * target='_blank'>repository</a>.  If the resource isn't found, it attempts to retrieve it from
 * one or more remote repositories, and caches it for subsequent attempts. <p> Most open source
 * Java libraries can be found on the (remote) <a href='https://search.maven.org'
 * target='_blank'>Maven Central</a> repository, which requires no configuration to use. 
 * Occasionally, however, the library you need isn't published to any public repository, and
 * you'll need to <a href='https://maven.apache.org/guides/mini/guide-3rd-party-jars-local.html'
 * target='_blank'>install it locally</a> or <a
 * href='https://maven.apache.org/guides/mini/guide-3rd-party-jars-remote.html'
 * target='_blank'>deploy it to a remote repository</a>. Most environments should be using a
 * remote repository <a href='https://maven.apache.org/repository-management.html'
 * target='_blank'>provided by a repository manager</a> set up and maintained by your
 * organization. <p> Smart GWT is not published to any public repository, and so will need to be
 * installed or deployed before you're able to use it in any project.  This can be quite tedious
 * when it has to be done for as many <a
 * href='https://www.smartclient.com/smartclient-release/isomorphic/system/reference/mavendoc/maven-usage.html'
 * target='_blank'>artifacts</a> as are provided in current distributions, so <a
 * href='http://github.smartclient.com/isc-maven-plugin/' target='_blank'>an open source Maven
 * "Plugin"</a> is made available with <a
 * href='http://github.smartclient.com/isc-maven-plugin/install-mojo.html'
 * target='_blank'>install</a> and <a
 * href='http://github.smartclient.com/isc-maven-plugin/deploy-mojo.html'
 * target='_blank'>deploy</a> goals that each are capable of downloading, unpacking, and
 * installing or deploying <a href='https://www.smartclient.com/builds/index.jsp'
 * target='_blank'>Patch &amp; Development Builds</a> in a single step. After Maven has been <a
 * href='https://maven.apache.org/download.cgi' target='_blank'>downloaded</a>, <a
 * href='https://maven.apache.org/install.html' target='_blank'>installed</a>, and <a
 * href='http://github.smartclient.com/isc-maven-plugin/examples/configuration.html'
 * target='_blank'>configured</a> (some configuration required for other than LGPL or EVAL Smart
 * GWT builds), this whole process takes no more than a few minutes on a reasonably fast network. 
 * Refer to {@link com.smartgwt.client.docs.MavenSupport} documentation for a command that you can
 * copy and paste to install the most recent evaluation version of Smart GWT, and another to get
 * you started by <a href='https://maven.apache.org/archetype/maven-archetype-plugin/usage.html'
 * target='_blank'>generating a skeleton project</a> from a <a
 * href='https://maven.apache.org/archetype/index.html' target='_blank'>Maven archetype</a>, or
 * template. <p> Having run both of those commands, your newly created project will contain a <a
 * href='https://maven.apache.org/guides/introduction/introduction-to-the-pom.html'
 * target='_blank'>pom.xml file</a>, which details among other things the libraries, or
 * dependencies, needed to compile, package, and run the app.  In this case, you'll find a
 * reference to the version of Smart GWT you used to create the project.  To upgrade, you'll just
 * change the value of the ${smartgwt.version} property to reflect another build number that
 * you've installed or deployed using the process outlined above and rebuild.  To add another JAR
 * to your project, you just add the dependency to your POM. To add one of the Smart GWT {@link
 * com.smartgwt.client.docs.LoadingOptionalModules optional modules}, for example, you'd first use
 * the plugin to install / deploy it to your own repository and then add the appropriate block to
 * your POM's dependencies section. <p> Your project will also contain a README file containing a
 * copy/paste command line for installing, deploying to and starting a local 'embedded' <a
 * href='https://www.eclipse.org/jetty/' target='_blank'>Jetty</a> server, as well as detailed
 * instructions for <a href='https://help.eclipse.org/latest/index.jsp'
 * target='_blank'>Eclipse</a> integration, and even automated conversion to an <a
 * href='https://ant.apache.org' target='_blank'>Ant</a> based build (complete with Ivy
 * configuration). Isomorphic generally recommends starting with the Jetty command to see things
 * working quickly before experimentation with other approaches.  The plugin provides an <a
 * href='http://github.smartclient.com/isc-maven-plugin/faq.html' target='_blank'>FAQ</a> for
 * reference, and posting questions / issues to the public <a
 * href='https://forums.smartclient.com' target='_blank'>forum</a> for help is always appropriate.
 */
public interface SgwtEESetup {
}
