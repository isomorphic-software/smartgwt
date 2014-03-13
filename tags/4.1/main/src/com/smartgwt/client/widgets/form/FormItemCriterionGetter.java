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
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.fields.FormItem;

public interface FormItemCriterionGetter {

    /**
     *
     * @param form the managing DynamicForm instance
     * @param item the form item itself
     *
     * @return criterion object based on the item's current edited value(s).
     * @see com.smartgwt.client.docs.CriteriaEditing CriteriaEditing overview and related methods
     */
    public Criterion getCriterion(DynamicForm form, FormItem item);

    /**
     *
     * @param form the managing DynamicForm instance
     * @param item the form item itself
     * @param textMatchStyle If passed assume the textMatchStyle will be used when performing a fetch operation with these criteria. This may
     * impact the criterion's operator property.
     *
     * @return criterion object based on the item's current edited value(s).
     * @see com.smartgwt.client.docs.CriteriaEditing CriteriaEditing overview and related methods
     */
    public Criterion getCriterion(DynamicForm form, FormItem item, TextMatchStyle textMatchStyle);
}
