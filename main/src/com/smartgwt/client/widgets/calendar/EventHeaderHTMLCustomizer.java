package com.smartgwt.client.widgets.calendar;

import java.util.Date;

/**
 * Called to determine the header/title HTML to be displayed in an event's EventCanvas
 */
public abstract class EventHeaderHTMLCustomizer {
    /**
     * getEventHeaderHTML() should be implemented and return the string of HTML to display as
     * the title/header text for the passed event.
     * To access the Calendar itself, use calendarView.getCalendar().
     * @param calendarEvent the event being rendered
     * @param calendarView the view in which the event is being rendered
     * @return HTML to display
     */
    public abstract String getEventHeaderHTML(CalendarEvent calendarEvent, CalendarView calendarView);
}
