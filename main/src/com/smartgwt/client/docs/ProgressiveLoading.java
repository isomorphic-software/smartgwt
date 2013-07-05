
package com.smartgwt.client.docs;

/**
 * Settings related to the "progressive loading" pattern, which causes data to be loaded 
 * progressively, so that users can request more rows by scrolling off the bottom of the currently
 * visible rows, but cannot cause direct movement to some arbitrary position in  the dataset (as
 * is the case with ordinary, non-progressive loading).  This pattern may give a better user
 * experience with large datasets.
 * @see com.smartgwt.client.widgets.form.fields.SelectItem#getProgressiveLoading
 * @see com.smartgwt.client.widgets.form.fields.ComboBoxItem#getProgressiveLoading
 * @see com.smartgwt.client.data.DataSource#getProgressiveLoading
 * @see com.smartgwt.client.docs.serverds.DataSource#progressiveLoadingThreshold
 * @see com.smartgwt.client.docs.serverds.DataSource#lookAhead
 * @see com.smartgwt.client.docs.serverds.DataSource#endGap
 * @see com.smartgwt.client.data.DSRequest#getProgressiveLoading
 * @see com.smartgwt.client.docs.serverds.OperationBinding#progressiveLoading
 */
public interface ProgressiveLoading {
}
