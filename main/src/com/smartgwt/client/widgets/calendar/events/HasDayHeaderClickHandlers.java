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

public interface HasDayHeaderClickHandlers extends HasHandlers {
    /**
     * Called when the header area of a day in the month view is clicked on. <P> By default, moves to the day tab and shows the
     * clicked days events. Call {@link com.smartgwt.client.widgets.calendar.events.DayHeaderClickEvent#cancel()} from within {@link DayHeaderClickHandler#onDayHeaderClick} to cancel this action. <P> Not called if the day falls outside the current month and
     * {@link com.smartgwt.client.widgets.calendar.Calendar#getShowOtherDays showOtherDays} is false.
     *
     * @param handler the dayHeaderClick handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    HandlerRegistration addDayHeaderClickHandler(DayHeaderClickHandler handler);
}
