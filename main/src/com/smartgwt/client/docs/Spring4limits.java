
package com.smartgwt.client.docs;

/**
 * <h3>Spring 4 / Java Compatibility</h3>
 * The <a href='https://spring.io/projects/spring-framework#learn' target='_blank'>Spring</a> 4
 * framework
 *  integrated with Smart GWT is no longer supported by Spring and is incompatible with
 * <a href='https://www.oracle.com/java/technologies/downloads/' target='_blank'>Java</a> 16+, so
 * you need
 *  to either use an older version of Java
 * (<a
 * href='https://www.oracle.com/java/technologies/javase/javase8u211-later-archive-downloads.html'
 * target='_blank'>Java 8</a> or
 * <a href='https://www.oracle.com/java/technologies/javase/jdk11-archive-downloads.html'
 * target='_blank'>Java 11 (LTS)</a>),
 *  or not use Spring.
 *  <p>
 *  If you absolutely need to use Java 16+, you can remove Spring from the Smart GWT server by
 *   removing all of the Spring JARs from your WEB-INF/lib server directory:
 *  <li>spring-beans-4.3.26.RELEASE.jar
 *  <li>spring-core-4.3.26.RELEASE.jar
 *  <li>spring-jdbc-4.3.26.RELEASE.jar
 *  <li>spring-tx-4.3.26.RELEASE.jar
 *  <li>spring-webmvc-4.3.26.RELEASE.jar
 *  <li>spring-aop-4.3.26.RELEASE.jar
 *  <li>spring-context-4.3.26.RELEASE.jar
 *  <li>spring-expression-4.3.26.RELEASE.jar
 *  <li>spring-orm-4.3.26.RELEASE.jar
 *  <li>spring-web-4.3.26.RELEASE.jar
 *  <li>isomorphic_spring.jar</ul>
 *  <p>
 *  and then removing the Spring configuration from your WEB-INF/web.xml:
 *  <pre>
 *  &lt;!-- standard spring configuration --&gt;
 *  &lt;context-param&gt;
 *      &lt;param-name&gt;contextConfigLocation&lt;/param-name&gt;
 *      &lt;param-value&gt;/WEB-INF/applicationContext.xml&lt;/param-value&gt;
 *  &lt;/context-param&gt;    
 *  &lt;listener&gt;
 *      &lt;listener-class&gt;org.springframework.web.context.ContextLoaderListener&lt;/listener-class&gt;
 *  &lt;/listener&gt;</pre>
 *  Note that Spring 5, which is compatible with JDK 16+, can be used in your application.  You
 * just can't use {@link com.smartgwt.client.docs.SpringIntegration Smart GWT's built-in Spring
 * support},
 *  such as the "spring:" DMI target.
     * @see com.smartgwt.client.docs.SpringIntegration
 */
public interface Spring4limits {
}
