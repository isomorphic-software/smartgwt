package com.smartgwt.client.widgets.form.fields;

import com.smartgwt.client.data.Criteria;

/**
 * Interface containing a method to return filter criteria for use by some form item.
 * @see com.smartgwt.client.widgets.form.fields.ComboBoxItem#setPickListFilterCriteriaFunction(FormItemCriteriaFunction)
 *   for an example usage.
 *
 */
public interface FormItemCriteriaFunction {
    public Criteria getCriteria(FormItemFunctionContext itemContext);

}
