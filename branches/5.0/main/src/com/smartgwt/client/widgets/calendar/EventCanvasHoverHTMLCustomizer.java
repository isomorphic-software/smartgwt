package com.smartgwt.client.widgets.calendar;

import java.util.Date;

/**
 * Called to determine the hover HTML to be displayed when the user hovers over an eventCanvas in a calendar.
 */
public abstract class EventCanvasHoverHTMLCustomizer {
    
    private Calendar calendar;

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }    

    /**
     * Returns the Calendar over which the hover occurred
     * @return Calendar over which the hover occurred
     */
    public Calendar getCalendar() {
        return this.calendar;
    }
    
    /**
     * getHoverHTML() should be implemented and return the string of HTML to display when the user hovers
     * over an event
     * @param calendarEvent the event being hovered over.
     * @param eventCanvas the eventCanvas being hovered
     * @return HTML to display
     */
    public abstract String getHoverHTML(CalendarEvent calendarEvent, EventCanvas eventCanvas);
    
}
