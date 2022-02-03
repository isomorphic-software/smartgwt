
package com.smartgwt.client.docs;

/**
 * <h3>Reify OnSite</h3>
 * <b>What is Reify OnSite?</b>
 *  <p>
 * {@link com.smartgwt.client.docs.ReifyForDevelopers Reify} is a cloud-based visual application
 * builder in which users
 *  can build screens via drag-and-drop, create DataSources from sample data or using wizards,
 *  and visually define standard event handlers and multi-step workflows.
 *  <p>
 *  Reify OnSite is a special version of Reify that can be installed on your own network, behind
 *  your firewall, so that your data and intellectual property never leave your secure site.
 *  Applications are deployed to your private cloud, also behind your firewall. The tool itself
 *  can be configured for your specific requirements. DataSources that connect to internal
 * enterprise data services are supported, {@link com.smartgwt.client.docs.Reify custom
 * components} can be
 *  added to the palette library, and the Reify design environment itself can even be customized
 *  on a per-user basis.
 *  <p>
 *  Reify OnSite is licensed separately from Reify.com accounts, and separately from Smart GWT
 *  developer licenses, generally purchased as a either a fixed number of seats or unlimited
 *  within a group, site or company-wide.
 * <a href='https://www.reify.com/getStarted.jsp' target='_blank'>Contact us here</a> to get
 * started,
 *  <p>
 *  <b>Installation</b>
 *  <p>
 *  The OnSite package comes with an Embedded Tomcat server and pre-populated
 * <a href='http://hsqldb.org/' target='_blank'>HSQL database</a> that's ready to be run with no
 * additional
 *  setup required.  If desired, it can be deployed to a separate servlet engine or run against
 *  a different database engine.
 *  <p>
 *  <b>Account Management</b>
 *  <p>
 * Reify Designer Accounts are managed via a plain SQLDataSource, named "isc_reifyUsers", which
 * you
 * can edit using the DataSources tab of the {@link com.smartgwt.client.docs.AdminConsole Admin
 * Console} or
 * {@link com.smartgwt.client.docs.Debugging Developer Console}.  Within the DataSources tab,
 * click on the "isc_reifyUsers"
 *  DataSource record to open a section for editing user records, and click "add record" to add
 *  additional users.  User records can be removed by clicking on the delete icon in the
 *  rightmost column of each record.
 *  <p>
 *  As shipped, a single user account, "admin" (password "reify"), is provided.  To grant
 *  superuser privileges to additional accounts, just enter "superuser" for the "roles" field in
 *  the record.
 *  <p>
 *  <b>How Reify Stores your Designs and Data</b>
 *  <p>
 * Reify uses {@link com.smartgwt.client.docs.FileSource FileSource} DataSources to store your
 * projects
 *  (<code>isc_hostedProjects</code> DS), screens (<code>isc_hostedScreens</code> DS), and
 * DataSources (<code>isc_hostedDataSources</code> DS), rather than writing them to disk as files.
 *  These DataSources are shared for all users of your organization, so project and screen names
 *  must be unique.
 *  <p>
 *  <b>Deployment</b>
 *  <p>
 *  Reify OnSite runs your application in a dedicated sandbox (a separate database in HQL),
 * with its own copy of each of your project {@link com.smartgwt.client.data.MockDataSource
 * MockDataSources} instantiated
 *  as real SQL DataSources in the HSQL database.  This process is called <i>deployment</i>.
 *  DataSources that are not MockDataSources are just deployed "as is" and will behave
 *  the same in all the different types of deployments.
 *  <p>
 *  During deployment, a unique database is created on the fly (one per deployment), named:
 *  <p><pre>
 *      sbx_&lt;deploymentType&gt;_deployment_&lt;deploymentId&gt;&#95;org_1</pre>
 *  where the deployment type is one of "test", "staging", or "production".  The following
 *  DataSources are created in the deployment database during deployment, with records related
 *  to the project being deployed copied from the common database, in the case of the FileSource
 *  DataSources:
 *  <p>
 *  <table class="normal" border=1>
 *  <tr><td><b>DataSource Name</b></td><td><b>Contents</b></td><td><b>Is FileSource?</b></td>
 *  </tr><tr><td>isc_hostedProjects</td><td>project definitions</td><td>Y</td></tr>
 *  <tr><td>isc_hostedScreens</td><td>screen definitions</td><td>Y</td></tr>
 *  <tr><td>isc_hostedDataSources</td><td>MockDataSource definitions</td><td>Y</td></tr>
 *  <tr><td>isc_hostedSettings</td><td>project-specific settings</td><td>Y</td></tr>
 *  <tr><td>isc_hostedUsers</td><td>users for deployment</td><td>N</td></tr>
 *  <tr><td>isc_hostedRoles</td><td>user roles for deployment</td><td>N</td></tr>
 *  <tr><td>isc_hostedSessions</td><td>tracks deployment sessions</td><td>N</td></tr>
 *  </table>
 *  <p>
 *  Your application's deployment URL will target the current host with a path like:
 *  <pre>
 *      /&lt;deploymentType&gt;/reify/&lt;deploymentName&gt;/</pre>
 *  where the deployment type is one of "app" (production), "test", or "staging", and the
 *  deployment name is one you choose during deployment, defaulting to the project name.  For
 *  example, the complete URL might look like:
 *  <pre>
 *      https://server1.bigco.com/staging/reify/vendor_evaluation/</pre>
 *  for a staging deployment of BigCo's "vendor evaluation" project to server1.
 *  <p>
 *  Future releases will support deployment to both private and public clouds, and
 *  multi-organization, allowing you to customize the middle path segment.
 *  <p>
 *  Note that using the "Export" option under the "Project" button, you can combine any created
 *  screen with a Smart GWT SDK, and thus deploy to any platform that supports Java servlets
 * and a database.  For more details, refer to {@link com.smartgwt.client.docs.ReifyForDevelopers
 * Reify for Developers}.
 *  <p>
 *  <p><b>Auditing</b></p>
 *  <p>
 *  Audit DataSources are automatically created during deployment for each DataSource in your
 * deployment.  You can open the {@link com.smartgwt.client.docs.DeploymentManagement Deployment
 * Management Console} to
 *  examine any DataSource in the deployment, view or edit users and roles, and analyze what
 *  sessions have hit the deployment, as well as what changes they've made to your DataSources.
 *  <p>
 *  <b>Custom Components</b>
 *  <p>
 *  Reify OnSite allows adding custom components to the palette, including components built on
 * new classes and {@link com.smartgwt.client.docs.ComponentSchema component schema}.  For an
 * overview of the files
 *  required (e.g. <code>globalDependencies.xml</code>) and where to place them, see
 *  {@link com.smartgwt.client.docs.ReifyCustomComponents "Adding Custom Components to Reify"}.
 *  <p>
 *  <b>Custom Workflow Tasks</b>
 *  <p>
 *  With Reify OnSite, custom workflow tasks and associated editors can be added to support
 * your special project needs. See {@link com.smartgwt.client.docs.ReifyAddWorkflowTask} for
 * details.
 *  <p>
 *  <b>Advanced Tasks</b>
 *  <p>
 *  Reify has various advanced tasks to be used in workflows, where  Send Email
 *  and  Send SMS are some of them.
 *  Take a look at the {@link com.smartgwt.client.docs.ReifyMessaging} to know more about them.
 *  <p>
 *  <b>Default Skin for the initial project</b>
 *  <P>
 *  Any skin, standard or custom, can be configured as the default skin for Reify and it will
 *  be applied to the initial, default project created the first time each user logs in.
 *  New projects created thereafter use the currently selected skin.
 *  <p>
 *  Call <code>isc.Reify.setDefaultSkin(skinName [, skinURL])</code>, typically from the
 *  Runtime Customization detailed below, to set the default skin for this instance of
 *  Reify. If the default skin is a custom skin it will not show up in the Project-&gt;Skin
 *  menu automatically. See the Custom Skins section below for details on adding that selection.
 *  <p>
 *  When using the Runtime Customization to register the default skin, set the
 *  load timing to <code>afterVBCreate</code>.
 *  <p>
 *  <b>Custom Skins</b>
 *  <P>
 *  Custom skins that are not hosted by the Skin Editor can be registered with Reify by calling
 * {@link com.smartgwt.client.tools.Reify#registerSkin Reify.registerSkin()}. The skin can then be
 * selected from Project-&gt;Skin-&gt;Custom
 *  Skins menu. This skin registration is typically done via Runtime Customization detailed
 *  below. An optional URL can be provided if the skin is not located in the standard location
 *  (i.e. isomorphic/skins) or is served by a different server. Note that the URL must include
 *  the skin name as its last component (ex. /mySkins/MyCustomSkin).
 *  <p>
 *  When using the Runtime Customization to register the custom skin, set the
 *  load timing to <code>afterVBCreate</code>.
 *  <p>
 *  <b>Runtime Customization</b>
 *  <P>
 * Reify OnSite provides a mechanism, the "isc_reifyCustomizations" {@link
 * com.smartgwt.client.data.DataSource},
 *  whereby you can customize the project runtime environment with your own JavaScript
 *  snippets.  Note that direct access to this dataSource
 * {@link com.smartgwt.client.docs.serverds.DataSource#requiresRole requies the <i>"superuser"</i>
 * role}.<br>
 * To add customizations, use the {@link com.smartgwt.client.docs.DataSourcesTab DataSources tab}
 * in the Admin or
 *  Developer Console. Select "isc_reifyCustomizations" in the DataSource List, and then 
 *  click "Add Record" at the bottom of the new section that appears to start editing a new 
 *  record.  The following fields should be populated:<ul>
 *  <li>Place the number 1 in the "Org Id" field, since Reify OnSite currently only supports a
 *  single organization.  If in the future, full organization support is added, this field will
 *  allow different customizations to be added for each organization.
 *  <li>In the "Load Style" field, we recommend selecting "externalFile", as then the contents
 *  you enter can be the URL of a JavaScript file rather than actual JS.  If you want to enter
 *  the JS directly in this table, select "inline" instead.
 *  <li>Enter the "Contents" that will be loaded, as either the URL of a JavaScript file (for
 *  "externalFile" mode), or the JS itself (for "inline" mode).  When entering a URL, note that
 *  both relative (e.g. <code>/foo.js</code>) and absolute (e.g.
 *  <code>http://mysite.com/cool/custom.js</code>) URLs are supported.</ul>
 *  <p>
 *  <b>Resolving Errors</b>
 *  <p>
 *  Errors encountered by Reify OnSite, which may raise a dialog with a countdown timer
 *  reloading the page, are logged to the "isc_hostedErrorReports" DataSource in the HSQL database
 *  <code>reifyNoSandbox</code>.  Records here are detailed, containing the click stream of
 *  events leading up to the crash, as well as the stack trace.  To help resolve any errors,
 *  VPN-based remote support can be purchased from Isomorphic.
 *  <p>
 *  <b>Switching Database Engines</b>
 *  <p>
 *  To switch Reify OnSite to use another database engine, such as MySQL, you can use the
 * "Database Configuration" tab of the {@link com.smartgwt.client.docs.AdminConsole Admin Console}
 * to change the default
 *  database, and then the "Import DataSources" tab to populate the required tables.  You'll
 *  need to import the following DataSource definitions to populate the <code>reify</code>
 *  database::<ul>
 *  <li>isc_hostedProjects
 *  <li>isc_hostedScreens
 *  <li>isc_hostedDataSources
 *  <li>isc_hostedSettings
 *  <li>isc_hostedUsers
 *  <li>isc_hostedRoles
 *  <li>isc_hostedSessions
 *  <li>isc_hostedDeployments
 *  <li>isc_userSkin</ul>
 *  <p>
 *  <b>Switching Servlet Engines</b>
 *  <p>
 *  To switch to another servlet engine, such as Jetty, you just need to remove the
 *  <code>bin/</code> and <code>embeddedTomcat/</code> subdirectories from the
 *  <code>WEB-INF/</code> directory inside the zip, and then repackage it as a war with
 *  <code>WEB-INF/</code> underneath the root by running something such as:
 *  <pre>
 *      cd reifyOnSite && jar -cvf reifyOnSite.war *</pre>
 *  in the directory where you originally expanded the Reify OnSite package.  This will produce
 *  a standard Java war file that can be deployed to any servlet engine / application server
 *  that supports at least J2SE.
 *  <P>
 */
public interface ReifyOnSite {
}
