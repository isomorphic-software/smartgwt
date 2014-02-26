package com.smartgwt.client.widgets.calendar;

import java.util.Date;

/**
 * Called to determine a particular event should be visible in the passed view
 */
public abstract class ShowEventCustomizer {
    /**
     * showEvent() should be implemented and return true if the passed event should be visible in the passed view
     * To access the Calendar itself, use calendarView.getCalendar().
     * @param event the event in question
     * @param calendarView the view in which the event will appear
     * @return true if the event should be rendered in the passed view, or false otherwise
     */
    public abstract boolean showEvent(CalendarEvent event, CalendarView calendarView);
}
