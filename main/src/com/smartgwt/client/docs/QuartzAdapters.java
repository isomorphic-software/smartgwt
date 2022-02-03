
package com.smartgwt.client.docs;

/**
 * <h3>Quartz DataSources</h3>
 * Occasionally, it can be useful to provide a user interface to facilitate the management of
 * background jobs. <a href='http://www.quartz-scheduler.org' target='_blank'>Quartz</a> is a very
 * capable job scheduling library but does not bundle any user interface. <p> The Scheduler tab of
 * the {@link com.smartgwt.client.docs.AdminConsole Admin Console} provides such a  user interface
 * by way of {@link com.smartgwt.client.docs.ServerDataIntegration server-side integration} that
 * accepts standard fetch, add, update, and remove requests and translates them into the
 * appropriate Quartz API calls. <p> Note that only cron schedules are supported at this time. <p>
 * The Quartz*.ds.xml DataSources found in the system/datasources directory use a {@link
 * com.smartgwt.client.docs.DeclarativeSecurity declarative security} feature to limit access
 * based on the presence of a special request attribute, and could be be used in your own
 * application if desired by controlling how that attribute is set.  Refer to the
 * adminConsoleOperations JSP documented at {@link com.smartgwt.client.docs.ToolsDeployment} for
 * detail.
 */
public interface QuartzAdapters {
}
