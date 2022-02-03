
package com.smartgwt.client.docs;

/**
 * <h3>Tools Deployment</h3>
 * Smart GWT provides a number of tools: <ul>  <li> {@link com.smartgwt.client.docs.AdminConsole}
 * <li> {@link com.smartgwt.client.docs.DbConfigTool} <li> {@link com.smartgwt.client.docs.Reify}
 * <li> {@link com.smartgwt.client.docs.BalsamiqImport} <li> {@link
 * com.smartgwt.client.docs.Debugging Developer Console} </ul> <P> To deploy the tools simply  
 * inherit the <code>com.smartgwtee.tools.Tools</code> module.  There are no additional settings
 * to configure.  <P> <h4>Security</h4> <P> These tools are, by default, available to anyone and
 * enable access to all "BuiltinRPCs" and the Filesystem DataSource so they should only be
 * deployed into a trusted environment. Alternately, the tools can easily be restricted to
 * administrators or end users by protecting the <code>tools</code> path with normal
 * authentication and authorization mechanisms on the web server.   <P> More fine-grained access
 * control can be installed by updating each tool's <code>xxxOperations.jsp</code> file (ex.
 * tools/adminConsoleOperations.jsp). These files are responsible for enabling builtinRPC and
 * FileSystem DataSource access. Individual BuiltinRPC methods can be restricted, for example,
 * such that some users are allowed to load screens but not save any changes. See comments within
 * each file for an example of restricting this access. See the server-side Javadocs for methods
 * provided by <code>BuiltinRPC</code>. <P> Note that the tools provides a "live" interface to the
 * provided DataSources. In other words, if a DataSource supports saving and a tool enables
 * editing, real saves will be initiated.  <P> <h4>Developer Console</h4> Unlike the other tools,
 * the Developer Console is always safe to deploy to production environments.   On its own, it
 * only exposes the kind of information that  an end user is already able to get using browser
 * tools such as Firebug.  By default then, it  is always available at   
 * [webroot]/[gwtModuleName]/sc/system/helpers/Log.html.  <P> When loaded, the Developer Console
 * will attempt to reach the page at tools/developerConsoleOperations.jsp  and, if available, will
 * provide access to additional functionality that should normally be  restricted in production
 * environments (ex. server logs). <P> For production deployment of the Developer Console with
 * full functionailty available to admins,  just deploy the tools module with password protection
 * as described above.  The method for finer- grained access control described above is also
 * supported by developerConsoleOperations.jsp.
 */
public interface ToolsDeployment {
}
