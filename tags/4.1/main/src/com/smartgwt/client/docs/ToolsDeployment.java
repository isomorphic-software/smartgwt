
package com.smartgwt.client.docs;

/**
 * <h3>Tools Deployment</h3>
 * Smart GWT provides a number of tools: <ul>  <li> {@link com.smartgwt.client.docs.AdminConsole}
 * <li> {@link com.smartgwt.client.docs.VisualBuilder} <li> {@link
 * com.smartgwt.client.docs.BalsamiqImport} </ul> <P> To deploy the tools simply copy the
 * <code>tools</code> directory into your deployment. There are no additional settings to
 * configure. <P> <h4>Security</h4> <P> These tools are, by default, available to anyone and
 * enable access to all "BuiltinRPCs" and the Filesystem DataSource so they should only be
 * deployed into a trusted environment. Alternately, the tools can easily be restricted to
 * administrators or end users by protecting the <code>tools</code> path with normal
 * authentication and authorization mechanisms on the web server. <P> More fine-grained access
 * control can be installed by updating each tool's <code>xxxOperations.jsp</code> file (ex.
 * tools/adminConsoleOperations.jsp, tools/visualBuilder/vbOperations.jsp). These files are
 * responsible for enabling builtinRPC and FileSystem DataSource access. Individual BuiltinRPC
 * methods can be restricted, for example, such that some users are allowed to load screens but
 * not save any changes. See comments within each file for an example of restricting this access.
 * See the server-side Javadocs for methods provided by <code>BuiltinRPC</code>. <P> Note that the
 * tools provides a "live" interface to the provided DataSources. In other words, if a DataSource
 * supports saving and a tool enables editing, real saves will be initiated.
 */
public interface ToolsDeployment {
}
