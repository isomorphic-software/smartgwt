
package com.smartgwt.client.docs;

/**
 * <h3><code>server.properties</code> file</h3>
 * The <code>server.properties</code> file is a configuration file read by the Smart GWT server -
 * see the file itself for more information and default or sample settings.  <P> Note that this is
 * a standard Java Properties file, except it allows variable substitution from other properties
 * defined earlier in the file. <P> It's loaded from the <code>CLASSPATH</code>, so it can be
 * anywhere in the  <code>CLASSPATH</code>, but is typically either in the projects java "src"
 * directory or in <code>WEB-INF/classes</code>. <P> Server side code can access and modify the
 * properties specified in this file via the <code>com.isomorphic.base.Config</code> class. <P>
 * When modifying <code>server.properties</code> developers should restart the servlet engine
 * after changing this file to pick up changes. <P> The following settings are used by Smart GWT
 * server features.<br> <i>Note that this is not intended to be an exhaustive list</i>: <ul>
 * <li><code>project.datasources</code> specifies the location for      {@link
 * com.smartgwt.client.docs.DataSourceDeclaration server-backed DataSource configuration files
 * <i>(*.ds.xml files)</i>}     as well as {@link com.smartgwt.client.data.SimpleType
 * server-backed SimpleType declarations <i>(*.type.xml files)</i>} </li>
 * <li><code>project.ui</code> specifies the location for      {@link
 * com.smartgwt.client.rpc.RPCManager#loadScreen XML Screen definitions <i>(*.ui.xml
 * files)</i>}</li> <li><code>project.project</code> specifies the location for      {@link
 * com.smartgwt.client.rpc.RPCManager#loadProject XML Project definitions <i>(*.project.xml
 * files)</i>}</li> <li><code>project.apps</code> specifies the location for      {@link
 * com.smartgwt.client.docs.ApplicationDeclaration Application declarations <i>(*.app.xml
 * files)</i>}</li> <li><code>modulesDir</code> specifies the location for modules files if using
 * the     {@link loadISCTag loadISC} or {@link loadModulesTag loadModules} jsp tags.</li>
 * <li><code>authentication.defaultRequired</code> can be used to require     {@link
 * com.smartgwt.client.docs.serverds.DataSource#requiresAuthentication authentication} for all
 * dataSources by default</li> <li><code>authentication.superuserRole</code> can be used to
 * identify a      {@link com.smartgwt.client.docs.serverds.OperationBinding#requiresRole user
 * role} as the super user role.</li> <li>This file can contain {@link
 * com.smartgwt.client.docs.DbConfigTool DataBase configuration settings for SQL DataSources}.    
 * Note that the {@link com.smartgwt.client.docs.AdminConsole Admin Console tool} provides an
 * interface      for adding database configuration blocks to server.properties without the need
 * to      edit the file by hand.</li> <li>This file can contain {@link
 * com.smartgwt.client.docs.SqlConnectionPooling SQL Connection pooling} settings     for SQL
 * DataSources.</li> <li>This file can contain various configuration properties used for {@link
 * com.smartgwt.client.docs.JpaIntegration}</li> <li>This file can contain SMTP configuration
 * settings for the     {@link com.smartgwt.client.docs.serverds.Mail OperationBinding.mail}
 * feature.</li> <li>This file can contain configuration settings for the     {@link
 * com.smartgwt.client.docs.Messaging optional RealTimeMessaging module}.</li>
 * <li><code>enabledBuiltins</code> can be used to configure access to methods provided     by the
 * server side <code>BuiltInRPC</code> class. (See server side JavaDoc for that     class as well
 * as the {@link com.smartgwt.client.docs.ToolsDeployment tools deployment overview} for more     
 * information).</li> <li><code>domainSync.disabled</code> and <code>domainSync.baseDomains</code>
 * can be used to     {@link com.smartgwt.client.docs.XssAndCSRFSecurity configure domain synching
 * behavior}.</li> <li><code>import.consume.bom</code> can be set to false to switch off automatic
 * consumption     of Byte Order Markers when importing UTF data (see the server Javadocs for the
 * DataImport      class for more details)</li>
 * <li><code>datasources.autoConvertRelativeDates</code> can be used to change when relative dates
 * are converted or to entirely disable the automatic conversion     (see {@link
 * com.smartgwt.client.data.DataSource#getAutoConvertRelativeDates
 * DataSource.autoConvertRelativeDates} for more details)</li> </ul>
 */
public interface Server_properties {
}
