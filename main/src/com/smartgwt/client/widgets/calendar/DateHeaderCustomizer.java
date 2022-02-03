package com.smartgwt.client.widgets.calendar;

import java.util.Date;

/**
 * Called to determine the HTML to be displayed in the header for a given date column in a CalendarView
 */
public abstract class DateHeaderCustomizer {
    /**
     * getHeaderTitle() should be implemented and return the HTML string to display in the
     * header for the passed date or dayOfWeek.
     * To access the Calendar itself, use calendarView.getCalendar().
     * @param date the date to return the header-title for - note that the month view passes a
     *        dayOfWeek value but not a date, because a single column represents multiple dates
     * @param dayOfWeek the week-day number of the passed date
     * @param defaultValue the default header title - returning null will also use this value
     * @param calendarView the view in which the date header is being rendered
     * @return HTML string to display in the header for the passed date or dayNum in the passed view
     */
    public abstract String getHeaderTitle(Date date, int dayOfWeek, String defaultValue, CalendarView calendarView);
}
