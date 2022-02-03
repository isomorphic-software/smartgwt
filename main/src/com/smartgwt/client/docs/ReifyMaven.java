
package com.smartgwt.client.docs;

/**
 * <h3>Importing from Reify</h3>
 * SmartGWT 
 *  {@link com.smartgwt.client.docs.MavenSupport support for Maven} includes the ability to 
 * <a href='http://github.smartclient.com/isc-maven-plugin/reify-import-mojo.html'
 * target='_blank'>import</a>
 *  (and optionally, 
 * <a href='http://github.smartclient.com/isc-maven-plugin/reify-validate-mojo.html'
 * target='_blank'>verify</a>
 * ) assets from <a href='http://reify.com' target='_blank'>reify.com</a> into your project either
 * on-demand 
 *  or during your build process.  Using the 
 * <a href='http://github.smartclient.com/isc-maven-plugin/examples/configuration.html'
 * target='_blank'>example configuration</a>, 
 *  the import command might look something like the following:
 *  <p>
 *  <pre>
 *    mvn com.isomorphic:isc-maven-plugin:1.4.5:reify-import -Pisc
 *  </pre>
 *  <strong>Important:</strong> This flow is unidirectional.  That is, whatever changes are to 
 *  be made to these resources should be made using the collaborative Reify environment and then
 *  re-imported.  There is, by design, no reason to modify them locally, and the plugin takes
 *  steps to notify you when that happens.
 * Refer to the {@link com.smartgwt.client.docs.ReifyForDevelopers Reify for Developers}
 * documentation topic for 
 *  further discussion.
 */
public interface ReifyMaven {
}
