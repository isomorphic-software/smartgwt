package com.smartgwt.client.widgets.calendar;

import java.util.Date;

/**
 * Called to determine a particular lane should be visible in the passed view
 */
public abstract class ShowLaneCustomizer {
    /**
     * showLane() should be implemented and return true if the passed lane should be visible in the passed view
     * To access the Calendar itself, use calendarView.getCalendar().
     * @param lane the lane in question
     * @param calendarView the view in which the lane exists
     * @return true if the lane should be visible in the passed view, or false otherwise
     */
    public abstract boolean showLane(Lane lane, CalendarView calendarView);
}
