
package com.smartgwt.client.docs;

/**
 * <h3>Deployment Management Console</h3>
 * The Deployment Management Console is a tool available in {@link
 * com.smartgwt.client.docs.ReifyOnSite Reify} that allows you to view and configure an existing
 * deployment.  From within Reify, it can be launched from the "Deploy" button, either through the
 * "Manage" dialog, or by clicking on the "Manage" button shown for one of the existing
 * deployments in the "Deploy To" flyout.  This tool is not part of the standard Smart GWT
 * licenses. <P> At the top of the tool, you can click on the deployment name to rename it, or
 * click on "Remove Deployment" to delete it.  Below the header are tabs to allow you to view and
 * edit users and roles, view and edit deployment DataSources, and examine sessions that have used
 * the deployment. <p> <b>Tabs Details</b> <p> In the "Users & Roles" tab, you can create new
 * users for the deployment, grant or revoke a user's superuser status, or change a user's
 * password.  Note that if this deployment was created by sharing another deployment's login
 * credentials, a warning will be initially shown that creating a new user will disconnect this
 * deployment from the other. <p> The "Data" tab shows a {@link
 * com.smartgwt.client.docs.DataSourcesTab DataSource Navigator} to allow you to view and edit
 * data from any of the DataSources in the deployment.  Changes will not affect the project or
 * other deployments. <p> In the "Usage" tab, a filterable grid of all deployment sessions is
 * shown, most recent first. For each session, the start, end, and last activity time is shown, as
 * well as whether the session is currently active.  Clicking on a session will open a new section
 * that lists in a filterable grid the changes made to DataSources by that session, with each row
 * showing the time of the change, the operation, and a summary of the record changes.
 */
public interface DeploymentManagement {
}
