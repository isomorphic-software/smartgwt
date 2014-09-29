package com.smartgwt.client.widgets.calendar;

import java.util.Date;

/**
 * Called to determine the CSS class name for a given date in a given view
 */
public abstract class DateStyleCustomizer {
    /**
     * getDateStyleStyle() should be implemented and return the CSS class name for the passed event in the passed view
     * To access the Calendar itself, use calendarView.getCalendar().
     * @param date the date to return a style name for
     * @param rowNum the row number of the passed date in the passed view
     * @param colNum the column number of the passed date in the passed view
     * @param calendarView the view in which the date cell is being rendered
     * @return CSS class to apply to the cell associated with the passed date in the passed view
     */
    public abstract String getDateStyle(Date date, int rowNum, int colNum, CalendarView calendarView);
}
