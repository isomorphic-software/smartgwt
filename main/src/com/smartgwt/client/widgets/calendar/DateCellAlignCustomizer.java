package com.smartgwt.client.widgets.calendar;

import java.util.Date;
import com.smartgwt.client.types.Alignment;

/**
 * Called to determine the horizontal Alignment of the content in s given date cell in a CalendarView
 */
public abstract class DateCellAlignCustomizer {
    /**
     * getDateCellAlign() should be implemented and return the horizontal Alignment for the content in the passed
     * date-cell in the passed view
     * To access the Calendar itself, use calendarView.getCalendar().
     * @param date the date to return the horizontal Alignment for
     * @param rowNum the row number of the passed date in the passed view
     * @param colNum the column number of the passed date in the passed view
     * @param calendarView the view in which the date cell is being rendered
     * @return Alignment horizontal Alignment of the content in the passed date-cell in the passed view
     */
    public abstract Alignment getDateCellAlign(Date date, int rowNum, int colNum, CalendarView calendarView);
}
