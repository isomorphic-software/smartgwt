package com.smartgwt.client.widgets.form.fields;

import com.smartgwt.client.data.Criteria;

/**
 * Criteria function for pick lists.
 *
 * @see com.smartgwt.client.widgets.form.fields.SelectItem#setPickListFilterCriteriaFunction(FilterCriteriaFunction)
 * @see com.smartgwt.client.widgets.form.fields.ComboBoxItem#setPickListFilterCriteriaFunction(FilterCriteriaFunction)
 */
public interface FilterCriteriaFunction {

    Criteria getCriteria();
}
