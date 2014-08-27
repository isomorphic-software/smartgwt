package com.smartgwt.client.widgets.calendar;

import java.util.Date;

import com.smartgwt.client.widgets.calendar.*;

/**
 * Called to determine whether a particular event should be visible in the passed view
 */
public abstract class ShowEventCustomizer {
    /**
     * Call cancel() to prevent the customization, and have the customizer return the result of the original method being customized
     */
    public boolean cancelled = false;
    public void cancel () {
        this.cancelled = true;
    }
    public boolean isCancelled () {
        return this.cancelled;
    }
    protected void setCancelled (boolean cancel) {
        this.cancelled = cancel;
    }
        
    /**
     * showEvent() should be implemented and return true if the passed event should be visible in the passed view
     * To access the Calendar itself, use calendarView.getCalendar().
     * @param event the event in question
     * @param calendarView the view in which the event will appear
     * @return true if the event should be rendered in the passed view, or false otherwise - return null to fall back on default behavior
     */
    public abstract boolean shouldShowEvent(CalendarEvent event, CalendarView calendarView);
}
