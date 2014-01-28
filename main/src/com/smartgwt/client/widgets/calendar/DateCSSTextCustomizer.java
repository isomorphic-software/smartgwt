package com.smartgwt.client.widgets.calendar;

import java.util.Date;

/**
 * Called to determine additional CSS text for a given date in a given view
 */
public abstract class DateCSSTextCustomizer {
    /**
     * getDateCSSText() should be implemented and return additional CSS text to apply to the passed date in the passed view.
     * To access the Calendar itself, use calendarView.getCalendar().
     * @param date the date to return CSS text for
     * @param rowNum the row number of the passed date in the passed view
     * @param colNum the column number of the passed date in the passed view
     * @param calendarView the view in which the date cell appears
     * @return CSS class to apply to the cell associated with the passed date in the passed view
     */
    public abstract String getDateCSSText(Date date, int rowNum, int colNum, CalendarView calendarView);
}
