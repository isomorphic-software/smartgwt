package com.smartgwt.client.widgets.calendar;

import java.util.Date;

import com.smartgwt.client.widgets.calendar.*;

/**
 * Called to determine a particular lane should be visible in the passed view
 */
public abstract class ShowLaneCustomizer {
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
     * showLane() should be implemented and return true if the passed lane should be visible in the passed view
     * To access the Calendar itself, use calendarView.getCalendar().
     * @param lane the lane in question
     * @param calendarView the view in which the lane exists
     * @return true if the lane should be visible in the passed view, or false otherwise - return null to fall back on default behavior
     */
    public abstract boolean shouldShowLane(Lane lane, CalendarView calendarView);
}
