	    
package com.smartgwt.client.docs;

/**
 * <h3>ComboBoxItem PickList Filtering</h3>
 * The criteria used to decide which options should appear in the drop-down PickList shown by a
 * ComboBox are determined as follows. <P> While the user is typing in a value, the {@link
 * com.smartgwt.client.widgets.form.fields.ComboBoxItem#getPickListFilterCriteria
 * ComboBoxItem.getPickListFilterCriteria} method will return the typed-in value as part of the
 * criteria, so that only matching values are shown.  Matching is determined by the {@link
 * com.smartgwt.client.widgets.form.fields.ComboBoxItem#getTextMatchStyle textMatchStyle}.  Note
 * that the  filterFields attribute may be used to determine which fields filtering is performed
 * against for databound comboBoxItems. <P> If the user explicitly shows the down-down pickList,
 * via either clicking on the drop down icon or using the <i>Ctrl+Arrow Down</i> key combination,
 * the typed-in value is  ignored for filtering. <P> If included in the criteria, the typed-in
 * value will be included as a value for the  {@link
 * com.smartgwt.client.widgets.form.fields.ComboBoxItem#getDisplayField displayField} (or for the
 * {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem#getValueField valueField} if
 * <code>this.displayField</code> is unspecified). <P> Static criteria, specified via {@link
 * com.smartgwt.client.widgets.form.fields.ComboBoxItem#getOptionCriteria optionCriteria} or
 * {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem#getPickListCriteria
 * pickListCriteria}, will always be included by the default implementation (combined with the
 * typed in value if appropriate). <P> For custom pick list filter criteria, we recommend  calling
 * the  {@link
 * com.smartgwt.client.widgets.form.fields.ComboBoxItem#setPickListFilterCriteriaFunction} method.
 * If you are implementing your own pickList filter criteria, the <b>read-only</b> property {@link
 * com.smartgwt.client.widgets.form.fields.ComboBoxItem#getFilterWithValue this.filterWithValue}
 * can be read to determine whether the ComboBox would ordinarily ignore the typed-in value for
 * filtering.  Note that in addition to cases where the user explicitly shows the pickList,
 * <code>filterWithValue</code> will also be <code>true</code> during a call to  {@link
 * com.smartgwt.client.widgets.form.fields.ComboBoxItem#fetchData ComboBoxItem.fetchData} on a
 * databound comboBox. <P> <b>NOTE:</b> The defaut implementation of this method will return an 
 * {@link com.smartgwt.client.data.AdvancedCriteria} object if multiple  filterFields are
 * specified, or if there are field collisions between any specified static  optionCriteria, 
 * pickListCriteria and the entered value. AdvancedCriteria are not supported by all DataSource
 * types, including the built-in server-side SQL dataSources in Smart GWT Pro edition (though they
 * are supported by SQL dataSources in Power and Enterprise editions). <P> <b>Client-Side
 * Filtering</b><br> By default, the ComboBoxItem will automatically use client-side filtering
 * whenever it receives a complete set of results for a given search string, and then the  user
 * types more letters (so reducing the results further). <p> Client-side filtering may malfunction
 * if the server filtering behavior can't be  replicated client-side (for example, Google Search).
 * To disable client-side  filtering so that the comboBox always contacts the server for data
 * whenever the  use changes the search string, set  useClientFiltering to false. <p> However,
 * disabling client-side filtering will slow down the UI and cause more  round-trips to the
 * server, so if client-side filtering is malfunctioning but <i>should work</i>, try to correct
 * the problem rather than disable the feature. <p> For example, if the initial search works
 * correctly but adding more letters always causes zero matches, most likely the Records returned
 * by the server lack values for the field(s) targeted by the filter criteria, or the field values
 * returned by the server don't match the criteria values.  <P> View the returned data in the RPC
 * tab in the Developer Console and enable the "ResultSet" log category in the "Results" tab to
 * troubleshoot how the filter  criteria are being applied to data, and look closely at your
 * settings for  valueField and  displayField.
 */
public interface ComboBoxFiltering {
}
