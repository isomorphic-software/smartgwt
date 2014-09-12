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
 
package com.smartgwt.client.widgets.chart;

import com.smartgwt.client.event.*;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;
public interface HasDataLabelClickHandlers extends HasHandlers {
    /**
     * Fires when the user clicks on a data label, that is, a text label showing values from the first facet.  For example, the
     * labels underneath the X-axis of a column chart, labelling each column.
     *
     * @param handler the dataLabelClick handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    HandlerRegistration addDataLabelClickHandler(DataLabelClickHandler handler);
}

