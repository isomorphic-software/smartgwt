package com.smartgwt.client.widgets.calendar;

import java.util.Date;

/**
 * Called to determine a particular lane should be visible in the passed view
 */
public abstract class ShowLaneCustomizer {
    
    private Calendar calendar;

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }
    /**
     * Returns the Calendar in which the passed lane exists
     * @return Calendar in which the lane is being rendered
     */
    public Calendar getCalendar() {
        return this.calendar;
    }
    

    /**
     * showLane() should be implemented and return true if the passed lane should be visible in the passed view
     * @param lane the lane in question
     * @param calendarView the view in which the lane exists
     * @return true if the lane should be visible in the passed view, or false otherwise
     */
    public abstract boolean showLane(Lane lane, CalendarView calendarView);
}
