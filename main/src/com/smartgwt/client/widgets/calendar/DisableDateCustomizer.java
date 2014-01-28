package com.smartgwt.client.widgets.calendar;

import java.util.Date;

/**
 * Called to determine whether the passed date should be considered disabled in the passed view
 */
public abstract class DisableDateCustomizer {
    
    private Calendar calendar;

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }
    /**
     * Returns the Calendar in which the cell for the passed date exists
     * @return Calendar in which the date is being rendered
     */
    public Calendar getCalendar() {
        return this.calendar;
    }
    

    /**
     * disableDate() should be implemented and return true if the passed date should be considered disabled in the passed view
     * @param date the date in question
     * @param calendarView the view in which the date cell exists
     * @return true if the date should be considered disabled, or false otherwise
     */
    public abstract boolean disableDate(Date date, CalendarView calendarView);
}
