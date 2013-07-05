
package com.smartgwt.client.docs;

/**
 * <h3>Criteria Editing</h3>
 * DynamicForms may be used to edit {@link com.smartgwt.client.data.Criteria} or {@link
 * com.smartgwt.client.data.AdvancedCriteria} for filtering  data from a DataSource. <P> The main
 * APIs for this are {@link com.smartgwt.client.widgets.form.DynamicForm#getValuesAsCriteria
 * DynamicForm.getValuesAsCriteria} and {@link
 * com.smartgwt.client.widgets.form.DynamicForm#setValuesAsCriteria
 * DynamicForm.setValuesAsCriteria}. <P> <code>getValuesAsCriteria()</code> will return an
 * AdvancedCriteria object in the following cases: <ul> <li>The form was previously passed
 * AdvancedCriteria via <code>setValuesAsCriteria()</code></li> <li>The form has a specified
 * {@link com.smartgwt.client.widgets.form.DynamicForm#getOperator operator} of
 * <code>"or"</code></li> <li>{@link
 * com.smartgwt.client.widgets.form.fields.FormItem#hasAdvancedCriteria
 * FormItem.hasAdvancedCriteria} returns true for some item(s) within the form</li> </ul> <P>  
 * Note that at the form item level, individual items can support editing of advanced criteria by
 * registering <code>FormItemCanEditCriterionPredicate</code>,
 * <code>FormItemCriterionSetter</code>, and <code>FormItemCriterionGetter</code> objects to
 * implement the methods <code>canEditCriterion()</code>, <code>setCriterion()</code>, and
 * <code>getCriterion()</code>, respectively.  <P> The common pattern of using nested dynamicForms
 * to edit arbitrary advanced criteria has been implemented via overrides to these methods in the
 * {@link com.smartgwt.client.widgets.form.fields.CanvasItem} class. See  
 * <code>CanvasItem.setCriterionGetter()</code> for details. <P> For completely user-driven
 * advanced criteria editing see also the {@link com.smartgwt.client.widgets.form.FilterBuilder}
 * class.
 * @see com.smartgwt.client.widgets.form.DynamicForm#getValuesAsCriteria
 * @see com.smartgwt.client.widgets.form.DynamicForm#setValuesAsCriteria
 * @see com.smartgwt.client.widgets.form.DynamicForm#getValuesAsAdvancedCriteria
 * @see com.smartgwt.client.widgets.form.fields.FormItem#hasAdvancedCriteria
 * @see com.smartgwt.client.widgets.form.fields.FormItem#canEditCriterion
 * @see com.smartgwt.client.widgets.form.fields.FormItem#getCriterion
 * @see com.smartgwt.client.widgets.form.fields.FormItem#setCriterion
 * @see com.smartgwt.client.widgets.form.fields.CanvasItem#hasAdvancedCriteria
 * @see com.smartgwt.client.widgets.form.fields.CanvasItem#canEditCriterion
 * @see com.smartgwt.client.widgets.form.fields.CanvasItem#getCriterion
 * @see com.smartgwt.client.widgets.form.fields.CanvasItem#setCriterion
 * @see com.smartgwt.client.widgets.form.fields.ComboBoxItem#hasAdvancedCriteria
 * @see com.smartgwt.client.widgets.form.fields.ComboBoxItem#getCriterion
 * @see com.smartgwt.client.widgets.form.fields.ComboBoxItem#canEditCriterion
 * @see com.smartgwt.client.widgets.form.fields.ComboBoxItem#setCriterion
 * @see com.smartgwt.client.widgets.form.fields.DateRangeItem#hasAdvancedCriteria
 * @see com.smartgwt.client.widgets.form.fields.DateRangeItem#getCriterion
 * @see com.smartgwt.client.widgets.form.fields.DateRangeItem#canEditCriterion
 * @see com.smartgwt.client.widgets.form.fields.DateRangeItem#setCriterion
 * @see com.smartgwt.client.widgets.form.fields.MiniDateRangeItem#hasAdvancedCriteria
 * @see com.smartgwt.client.widgets.form.fields.MiniDateRangeItem#getCriterion
 * @see com.smartgwt.client.widgets.form.fields.MiniDateRangeItem#setCriterion
 * @see com.smartgwt.client.widgets.form.fields.MiniDateRangeItem#canEditCriterion
 * @see com.smartgwt.client.widgets.form.fields.FormItem#getOperator
 */
public interface CriteriaEditing {
}
