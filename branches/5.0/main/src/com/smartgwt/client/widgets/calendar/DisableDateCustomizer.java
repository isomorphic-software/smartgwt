package com.smartgwt.client.widgets.calendar;

import java.util.Date;

/**
 * Called to determine whether the passed date should be considered disabled in the passed view
 */
public abstract class DisableDateCustomizer {

    /**
     * disableDate() should be implemented and return true if the passed date should be considered disabled in the passed view
     * To access the Calendar itself, use calendarView.getCalendar().
     * @param date the date in question
     * @param calendarView the view in which the date cell exists
     * @return true if the date should be considered disabled, or false otherwise
     */
    public abstract boolean disableDate(Date date, CalendarView calendarView);
}
