
package com.smartgwt.client.docs;

/**
 * <h3>Form Rules</h3>
 * If a property says it supports "rule criteria" it means that the criteria will be evaluated in
 * the context of the current {@link com.smartgwt.client.widgets.Canvas#getRuleScope
 * Canvas.ruleScope}, so can set {@link com.smartgwt.client.data.Criterion#getFieldName
 * Criterion.fieldName} to a path that references state in the current rule context. <p> Because
 * this type of criteria are allowed to reference UI state (such as whether any records are
 * selected in an adjacent grid) they are not generally used to filter DataSource records, since
 * such criteria would not be able to be evaluated on the server. <p> All RuleCriteria are also
 * {@link com.smartgwt.client.docs.DynamicCriteria Dynamic Criteria} unless otherwise noted.
 * @see com.smartgwt.client.widgets.menu.MenuItem#getEnableWhen
 * @see com.smartgwt.client.widgets.Canvas#getVisibleWhen
 * @see com.smartgwt.client.widgets.Canvas#getEnableWhen
 * @see com.smartgwt.client.widgets.tab.Tab#getEnableWhen
 * @see com.smartgwt.client.widgets.form.fields.FormItem#getRequiredWhen
 * @see com.smartgwt.client.widgets.form.fields.FormItem#getVisibleWhen
 * @see com.smartgwt.client.widgets.form.fields.FormItem#getReadOnlyWhen
 * @see com.smartgwt.client.widgets.form.fields.FormItemIcon#getEnableWhen
 * @see com.smartgwt.client.widgets.form.fields.FormItemIcon#getVisibleWhen
 * @see com.smartgwt.client.widgets.form.fields.ButtonItem#getEnableWhen
 */
public interface RuleCriteria {
}
