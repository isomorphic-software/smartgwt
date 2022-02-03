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
 
package com.smartgwt.client.widgets.events;

import com.smartgwt.client.event.*;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;
public interface HasRuleContextChangedHandlers extends HasHandlers {
    /**
     * Notification that the rule context gathered by the {@link com.smartgwt.client.widgets.Canvas#getRuleScope ruleScope} has
     * changed.   <p> This notification fires only on the component designated as the {@link
     * com.smartgwt.client.widgets.Canvas#getRuleScope ruleScope}; components that are merely contributing data to the rule
     * context do not fire <code>ruleContextChanged</code>.
     *
     * @param handler the ruleContextChanged handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    HandlerRegistration addRuleContextChangedHandler(RuleContextChangedHandler handler);
}
