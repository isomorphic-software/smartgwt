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
 
package com.smartgwt.client.widgets.grid.events;

import com.smartgwt.client.event.*;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;
public interface HasCriteriaChangedHandlers extends HasHandlers {
    /**
     * Callback fired when the end-user changes criteria. This occurs via the +{FilterEditor} or +{showFilterWindow,advanced
     * filtering} interface. It does not fire when a change is made via {@link
     * com.smartgwt.client.widgets.grid.ListGrid#setCriteria setCriteria()}, {@link
     * com.smartgwt.client.widgets.grid.ListGrid#fetchData fetchData()}, {@link
     * com.smartgwt.client.widgets.grid.ListGrid#setFilterWindowCriteria setFilterWindowCriteria()} or other APIs are called to
     * change the criteria.
     *
     * @param handler the criteriaChanged handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    HandlerRegistration addCriteriaChangedHandler(CriteriaChangedHandler handler);
}
