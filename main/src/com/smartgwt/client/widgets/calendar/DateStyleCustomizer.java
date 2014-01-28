package com.smartgwt.client.widgets.calendar;

import java.util.Date;

/**
 * Called to determine the CSS class name for a given date in a given view
 */
public abstract class DateStyleCustomizer {
    
    private Calendar calendar;

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }    
    /**
     * Returns the Calendar in which the event is being rendered
     * @return Calendar in which the event is being rendered
     */
    public Calendar getCalendar() {
        return this.calendar;
    }
    

    /**
     * getDateStyleStyle() should be implemented and return the CSS class name for the passed event in the passed view
     * @param date the date to return a style name for
     * @param rowNum the row number of the passed date in the passed view
     * @param colNum the column number of the passed date in the passed view
     * @param calendarView the view in which the date cell is being rendered
     * @return CSS class to apply to the cell associated with the passed date in the passed view
     */
    public abstract String getDateStyle(Date date, int rowNum, int colNum, CalendarView calendarView);
}
