
package com.smartgwt.client.docs;

/**
 * <h3>Admin Console</h3>
 * The Admin Console is a tool for configuring database access, importing and
 *  exporting server-backed Smart GWT DataSources, and performing other tasks.
 *  <p>
 *  
 *  
 *  To use the Admin Console, make sure you have followed the
 * {@link com.smartgwt.client.docs.SgwtEESetup full installation instructions} - double check that
 * you have the
 *  correct GWT &lt;inherits&gt; as shown in those instructions.  Then, launch your GWT project
 *  from your IDE, and open a web browser to <i>moduleBaseURL</i>/tools/adminConsole.jsp.  For
 *  example, if you load your application by going to a URL that ends in
 * builtinds/builtinds.html, the correct URL for the Admin Console is
 * builtinds/tools/adminConsole.jsp.
 *  <P>
 *  There is also a convenience method <code>openDataSourceConsole()</code> on the SC utility 
 *  class to open the Admin Console in a new browser window. To make use of this, 
 *  you can add the following code to your onModuleLoad():
 *  <pre>
 *    IButton adminButton = new IButton("Admin Console");
 *    adminButton.addClickHandler(new ClickHandler() {
 *      public void onClick(ClickEvent event) {
 *        SC.openDataSourceConsole();
 *      }
 *    });
 *    adminButton.draw();
 *  </pre>
 *  
 *  <p>
 *  <i>Features:</i>
 *  <p>
 *  <b>Database Configuration</b>
 *  <p>
 *  This tab allows you to configure SQL database connetions. This is an alternative to adding
 * SQL configuration blocks directly to {@link com.smartgwt.client.docs.Server_properties
 * server.properties} by hand.
 * See the {@link com.smartgwt.client.docs.DbConfigTool database configuration} documentation for
 * more 
 *  details.
 *  
 *  <P>
 *  Note that if you are using an IDE such as Eclipse to run your Web Project, the 
 *  definitive copy of <code>server.properties</code> under the <code><i>"src/"</i></code>
 *  directory will not be updated by this tool. Changes will be written to 
 * {@link com.smartgwt.client.docs.Server_properties server.properties} in your deployment
 * directory.<br>
 *  Use the "Download server.properties" button to download the settings and merge them to the
 *  server.properties file in your Eclipse (or other IDE) project.
 *  
 *  <p>
 *  <b>View DataSources</b>
 *  <p>
 * The {@link com.smartgwt.client.docs.DataSourcesTab DataSource Navigator} lets you view the
 * available DataSources in
 *  dedicated sections, where you can also edit and export records.
 *  <p>
 *  <b>Import DataSources</b>
 *  <p>
 *  This tab allows you to generate and populate database tables from DataSource definitions.
 *  <P>
 * All DataSources defined in XML (as described {@link
 * com.smartgwt.client.docs.DataSourceDeclaration here}) are
 * displayed in a list. Developers may select any dataSource to see details of the dataSource and
 * preview
 *  its data if any exists.
 *  <P>
 * For DataSources of {@link com.smartgwt.client.types.DSServerType type} <code>"sql"</code> or
 * <code>"hibernate"</code>,
 *  the buttons at the bottom of this tab allow users to create a new database table for the
 *  DataSources. Test data may be imported test data, either from an existing 
 *  {@link com.smartgwt.client.data.DataSource#getTestData test data file} or by uploading 
 *  String.
 *  <p>
 *  <b>Server Logs</b>
 *  <p>
 * Just like in the {@link com.smartgwt.client.docs.Debugging Developer Console} this will allow
 * you to see the 500
 *  most recent server side log entries.
 *  <p>
 *  <b>SQL Browser</b>
 *  <p>
 * On this tab you will be able to browse your SQL databases and see the data in their tables. 
 * You may also
 *  create DataSources from those tables and save them to disk, at the location specified by a
 * <code>project.datasources.generated</code> {@link com.smartgwt.client.docs.Server_properties
 * config property}
 *  (by default the same as the <code>project.datasources</code> property).
 *  <p>
 *  <b>Scheduler</b>
 *  <p>
 * With the {@link com.smartgwt.client.docs.QuartzAdapters scheduler tool} you can view, schedule,
 * trigger and pause arbitrary <a href='http://www.quartz-scheduler.org'
 * target='_blank'>Quartz</a> jobs.
 *  Requires the Isomorphic Scheduler server library and an
 * <a
 * href='https://www.quartz-scheduler.org/documentation/2.4.0-SNAPSHOT/cookbook/ServletInitScheduler.html'
 * target='_blank'>initialized</a> /
 * <a href='https://www.quartz-scheduler.org/documentation/2.4.0-SNAPSHOT/configuration.html'
 * target='_blank'>configured</a> Quartz Scheduler.
 *  <p>
 *  <b>Other Tools</b>
 *  <p>
 *  Here you will find links to some other standalone development tools.
 *  <p>
     * @see com.smartgwt.client.docs.ToolsDeployment
 */
public interface AdminConsole {
}
