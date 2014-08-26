package com.smartgwt.client.widgets.calendar;

import java.util.Date;

import com.smartgwt.client.widgets.calendar.*;

/**
 * Called to determine whether the passed date should be considered disabled in the passed view
 */
public abstract class DisableDateCustomizer {
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
     * disableDate() should be implemented and return true if the passed date should be considered disabled in the passed view
     * To access the Calendar itself, use calendarView.getCalendar().
     * @param date the date in question
     * @param calendarView the view in which the date cell exists
     * @return true if the date should be considered disabled, or false otherwise - return null to fall back on default behavior
     */
    public abstract boolean shouldDisableDate(Date date, CalendarView calendarView);
}
