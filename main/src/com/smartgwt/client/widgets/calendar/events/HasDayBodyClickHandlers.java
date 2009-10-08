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
 
package com.smartgwt.client.widgets.calendar.events;

import com.smartgwt.client.event.*;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;

public interface HasDayBodyClickHandlers extends HasHandlers {
    /**
     * Called when the body area of a day in the month view is clicked on, outside of any links to a particular event. <P> By
     * default, if the user can add events, shows a dialog for adding a new event for that day.  Return false to cancel this
     * action. <P> Not called if the day falls outside the current month and {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getShowOtherDays showOtherDays} is false.
     *
     * @param handler the dayBodyClick handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    HandlerRegistration addDayBodyClickHandler(DayBodyClickHandler handler);
}
