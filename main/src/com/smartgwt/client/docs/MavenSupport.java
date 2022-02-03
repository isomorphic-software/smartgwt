
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
 *  <p />
 *  That said, typical installations of the current build will include the artifacts documented 
 * <a target="_blank" href="./mavendoc/maven-usage.html">here</a>, where coordinates in most cases
 * will vary slightly by date and license.  
 * A sample configuration using a few artifacts from an eval build released on November 14, 2016
 * follows:
 *  <p/>
 *  
 *  
 * 
 *  <pre>
 *  &lt;?xml version="1.0" encoding="UTF-8"?&gt;
 *  &lt;project  xmlns="http://maven.apache.org/POM/4.0.0" 
 *               xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
 *               xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/maven-v4_0_0.xsd"&gt;
 *  
 *       &lt;modelVersion&gt;4.0.0&lt;/modelVersion&gt;
 *  
 *       &lt;groupId&gt;com.isomorphic.smartgwt.samples&lt;/groupId&gt;
 *       &lt;artifactId&gt;builtinds&lt;/artifactId&gt;
 *       &lt;version&gt;1.0.0&lt;/version&gt;
 *       &lt;packaging&gt;war&lt;/packaging&gt;
 *  
 *       &lt;dependencies&gt;
 *  
 *           &lt;!-- Standard GWT depdendency --&gt;
 *           &lt;dependency&gt;
 *               &lt;groupId&gt;com.google.gwt&lt;/groupId&gt;
 *               &lt;artifactId&gt;gwt-user&lt;/artifactId&gt;
 *               &lt;version&gt;2.7.0&lt;/version&gt;
 *               &lt;scope&gt;provided&lt;/scope&gt;
 *           &lt;/dependency&gt;
 *    
 *           &lt;!-- The SmartGWT Evaluation edition --&gt;
 *           &lt;dependency&gt;
 *               &lt;groupId&gt;com.isomorphic.smartgwt.eval&lt;/groupId&gt;
 *               &lt;artifactId&gt;smartgwt-eval&lt;/artifactId&gt;
 *               &lt;version&gt;6.0-p20161114&lt;/version&gt;
 *           &lt;/dependency&gt;
 *    
 *           &lt;!-- Add support for SQLDataSources --&gt;
 *           &lt;dependency&gt;
 *               &lt;groupId&gt;com.isomorphic.smartgwt.eval&lt;/groupId&gt;
 *               &lt;artifactId&gt;isomorphic-sql&lt;/artifactId&gt;
 *               &lt;version&gt;6.0-p20161114&lt;/version&gt;
 *           &lt;/dependency&gt;
 *  
 *       &lt;/dependencies&gt;
 *  
 *       &lt;build&gt;
 *           &lt;plugins&gt;
 *               &lt;!-- Standard GWT Compile --&gt;
 *               &lt;plugin&gt;
 *                   &lt;groupId&gt;org.codehaus.mojo&lt;/groupId&gt;
 *                   &lt;artifactId&gt;gwt-maven-plugin&lt;/artifactId&gt;
 *                   &lt;version&gt;2.7.0&lt;/version&gt;
 *                   &lt;executions&gt;
 *                       &lt;execution&gt;
 *                           &lt;goals&gt;
 *                               &lt;goal&gt;compile&lt;/goal&gt;
 *                           &lt;/goals&gt;
 *                       &lt;/execution&gt;
 *                   &lt;/executions&gt;
 *               &lt;/plugin&gt;
 *           &lt;/plugins&gt;
 *      &lt;/build&gt;
 *  &lt;/project&gt;
 *  </pre>
 */
public interface MavenSupport {
}
