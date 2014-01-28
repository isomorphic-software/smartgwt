package com.smartgwt.client.widgets.calendar;

import java.util.Date;

/**
 * Called to determine a particular date should be visible in the passed view
 */
public abstract class ShowDateCustomizer {
    /**
     * showDate() should be implemented and return true if the passed date should be visible in the passed view
     * To access the Calendar itself, use calendarView.getCalendar().
     * @param date the date in question
     * @param calendarView the view in which the date cell exists
     * @return true if the date should be visible in the passed view, or false otherwise
     */
    public abstract boolean showDate(Date date, CalendarView calendarView);
}
