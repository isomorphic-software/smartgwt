package com.smartgwt.client.widgets.calendar;

import java.util.Date;

/**
 * Called to determine the header/title HTML to be displayed in an event's EventCanvas
 */
public abstract class EventHeaderHTMLCustomizer {
    
    private Calendar calendar;

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }    
    /**
     * Returns the Calendar in which the event is being rendered
     * @return Calendar in which the event is being rendered
     */
    public Calendar getCalendar() {
        return this.calendar;
    }
    

    /**
     * getEventHeaderHTML() should be implemented and return the string of HTML to display as
     * the title/header text for the passed event.
     * @param calendarEvent the event being rendered
     * @param calendarView the view in which the event is being rendered
     * @return HTML to display
     */
    public abstract String getEventHeaderHTML(CalendarEvent calendarEvent, CalendarView calendarView);
}
