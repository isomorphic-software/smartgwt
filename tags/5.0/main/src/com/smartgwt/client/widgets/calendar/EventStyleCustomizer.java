package com.smartgwt.client.widgets.calendar;

import java.util.Date;

/**
 * Called to determine the CSS class name for a given event in a given view
 */
public abstract class EventStyleCustomizer {
    /**
     * getEventStyleStyle() should be implemented and return the CSS class name for the passed event in the passed view
     * To access the Calendar itself, use calendarView.getCalendar().
     * @param calendarEvent the event being rendered
     * @param calendarView the view in which the event is being rendered
     * @return CSS class to apply to the EventCanvas for the passed event in the passed view
     */
    public abstract String getEventStyle(CalendarEvent calendarEvent, CalendarView calendarView);
}
