/*
 * Smart GWT (GWT for SmartClient)
 * Copyright 2008 and beyond, Isomorphic Software, Inc.
 *
 * Smart GWT is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License version 3
 * as published by the Free Software Foundation.  Smart GWT is also
 * available under typical commercial license terms - see
 * http://smartclient.com/license
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 */
/* sgwtgen */
 
package com.smartgwt.client.widgets.grid;

import com.smartgwt.client.widgets.grid.ListGridField;

public interface DefaultFieldWidthCustomizer {

    /** 
     * Method to calculate and return the default width of a field. This method is called to calculate the size of each field's
     * content as part of the {@link com.smartgwt.client.widgets.grid.ListGrid#getAutoFitFieldWidths field auto fit} behavior.
     * Note that this method returns a size for <i>content</i>, so will not be consulted if {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getAutoFitWidthApproach autoFitWidthApproach} is set  to
     * <code>"title"</code>. <P> If {@link com.smartgwt.client.widgets.grid.ListGridField#getDefaultWidth
     * ListGridField.defaultWidth} is specified, this will be returned. <P> Otherwise, the default implementation varies by
     * {@link com.smartgwt.client.types.ListGridFieldType field type}. For fields of type <code>"icon"</code>, or fields which
     * show only a {@link com.smartgwt.client.widgets.grid.ListGridField#getValueIcons valueIcon} as a value, and for boolean
     * fields which show a checkbox value, the width will be calculated based on the icon size and {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getIconPadding iconPadding}. For other fields the {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getFieldContentWidth getFieldContentWidth()} method will be used to calculate
     * a width based on the rendered width of content. Note that for <code>"image"</code> type fields, this method will rely on
     * the {@link com.smartgwt.client.widgets.grid.ListGridField#getImageWidth ListGridField.imageWidth} being specified. <P>
     * Note that this width is the default width of "content" - it does not take into account the rendered size of the field
     * title.
     *
     * @param field Field for which the size should be determined
     * @return default size required for the field's content.
     */
	public int getWidth(ListGridField field);
} 
