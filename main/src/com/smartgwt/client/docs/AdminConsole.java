
package com.smartgwt.client.docs;

/**
 * <h3>Admin Console</h3>
 * The admin console groups together heap of other tools into one user interface in order to
 *  make it easier to find and work with these tools. It also provides you with links to some
 *  tools which do not fit into the admin console but are standalone tools.
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
 *  If it's not clear what URL to use, you can add the following code to your onModuleLoad()
 *  method to create a button that opens the Admin Console:
 *  <pre>
 *    IButton adminButton = new IButton("Admin Console");
 *    adminButton.addClickHandler(new ClickHandler() {
 *      public void onClick(ClickEvent event) {
 *        com.smartgwtee.tools.client.SCEE.openDataSourceConsole();
 *      }
 *    });
 *    adminButton.draw();
 *  </pre>
 *  NOTE: if you are using Pro Edition, the method to call is
 *  com.smartgwtpro.tools.client.SCPRO.openDataSourceConsole(), and for Power Edition,
 *  com.smartgwtpower.tools.client.SCPower.openDataSourceConsole().
 *  
 *  <p>
 *  The Admin Console UI comes with a number of tabs at the top, each representing a different
 *  tool, below you will find a description of what each tab/tool offers.
 *  <p>
 *  <b>Database Configuration</b>
 *  <p>
 *  On this tab you will be able to see any available JNDI connections.
 *  If you aren't using JNDI, you can use the GUI to enter and test JDBC settings. Both
 *  ConnectionManager and JDBC DataSource settings are supported. Once you've got a working
 *  connection, set it as the default connection using the "Set as Default" button.
 *  <p>
 *  <b>Import DataSources</b>
 *  <p>
 *  The database configuration tool allows you to configure database access for DataSources that
 *  use Smart GWT's built-in {@link com.smartgwt.client.docs.SqlDataSource SQL engine}.
 * See {@link com.smartgwt.client.docs.DbConfigTool database configuration tool} for a more in
 * depth explaination
 *  of this tool.
 *  <p>
 *  <b>Server Logs</b>
 *  <p>
 * Just like in the {@link com.smartgwt.client.docs.Debugging Developer Console} this will allow
 * you to see the 500
 *  most recent server side log entries.
 *  <p>
 *  <b>SQL Browser</b>
 *  <p>
 *  On this tab you will be able to browse your SQL databases and see the data in their tables.
 *  <p>
 *  <b>Scheduler</b>
 *  <p>
 *  With the scheduler tool you can view, trigger and paus any of your Quartz jobs.
 *  <p>
 *  <b>Other Tools</b>
 *  <p>
 *  Here you will find links to other useful tools which are not appropriate to put into a tab
 *  in the Admin Console.
 *  <p>
     * @see com.smartgwt.client.docs.ToolsDeployment
 */
public interface AdminConsole {
}
