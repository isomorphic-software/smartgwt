/*
 * Smart GWT (GWT for SmartClient)
 * Copyright 2008 and beyond, Isomorphic Software, Inc.
 *
 * Smart GWT is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License version 3
 * is published by the Free Software Foundation.  Smart GWT is also
 * available under typical commercial license terms - see
 * http://smartclient.com/license
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 */

package com.smartgwt.client.widgets.form;

/**
 * FormItem Value Icon mapper that allows the developer to specify the image source for an icon to be displayed for the current form item value.
 * Takes precedence over {@link com.smartgwt.client.widgets.form.fields.FormItem#setValueIcons(java.util.Map)}.
 *
 * @see com.smartgwt.client.widgets.form.fields.FormItem#setValueIconMapper(ValueIconMapper)
 */
public interface ValueIconMapper {
    /**
     * Method that allows the developer to specify the image source for an icon to be displayed for the current form item value. Takes precedence over
     * {@link com.smartgwt.client.widgets.form.fields.FormItem#setValueIcons(java.util.Map)}
     *
     * @param value the value of the item for which an item should be returned
     * @return the icon
     */
    String getValueIcon(Object value);
}
