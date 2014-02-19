/*
 * Smart GWT (GWT for SmartClient)
 * Copyright 2008 and beyond, Isomorphic Software, Inc.
 *
 * Smart GWT is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License version 3
 * as published by the Free Software Foundation.  Smart GWT is also
 * available under typical commercial license terms - see
 * http://smartclient.com/license
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 */

package com.smartgwt.client.widgets.form;

import com.smartgwt.client.data.Criterion;
import com.smartgwt.client.widgets.form.fields.FormItem;

public interface FormItemCanEditCriterionPredicate {

    /**
     *
     * @param form the managing DynamicForm instance
     * @param item the form item itself
     * @param criterion sub-criterion from an AdvancedCriteria object
     *
     * @return return true if the item can edit the criterion in question.
     * @see com.smartgwt.client.docs.CriteriaEditing CriteriaEditing overview and related methods
     */
    public boolean canEditCriterion(DynamicForm form, FormItem item, Criterion criterion);
}
