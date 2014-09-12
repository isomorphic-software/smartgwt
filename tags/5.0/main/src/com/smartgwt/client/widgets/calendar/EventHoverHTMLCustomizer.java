package com.smartgwt.client.widgets.calendar;

import java.util.Date;

/**
 * Called to determine the hover HTML to be displayed when the user hovers over a cell displayed in the calendar month view tab.
 */
public abstract class EventHoverHTMLCustomizer {
    
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
     * hoverHTML() should be implemented and return the string of HTML to display when the user hovers
     * over ListGrid cells
     * @param calendarEvent, the event being hovered over.
     * @param eventWindow, the event window being hovered
     * @return HTML to display
     */
    public abstract String getEventHoverHTML(CalendarEvent calendarEvent, EventWindow eventWindow);
}
