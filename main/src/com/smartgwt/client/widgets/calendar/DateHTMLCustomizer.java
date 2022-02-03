package com.smartgwt.client.widgets.calendar;

import java.util.Date;

/**
 * Called to determine the HTML to be displayed in a given date cell in a CalendarView
 */
public abstract class DateHTMLCustomizer {
    /**
     * getDateHTML() should be implemented and return the HTML string to display in the passed
     * date-cell in the passed view
     * To access the Calendar itself, use calendarView.getCalendar().
     * @param date the date to return HTML for
     * @param rowNum the row number of the passed date in the passed view
     * @param colNum the column number of the passed date in the passed view
     * @param calendarView the view in which the date cell is being rendered
     * @return HTML string to display in the passed date-cell in the passed view
     */
    public abstract String getDateHTML(Date date, int rowNum, int colNum, CalendarView calendarView);
}
