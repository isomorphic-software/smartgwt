package com.smartgwt.client.widgets.calendar;

import java.util.Date;

/**
 * Called to determine additional CSS text for a given date in a given view
 */
public abstract class DateCSSTextCustomizer {
    
    private Calendar calendar;

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }    
    /**
     * Returns the Calendar in which the date is being rendered
     * @return Calendar in which the date is being rendered
     */
    public Calendar getCalendar() {
        return this.calendar;
    }
    

    /**
     * getDateCSSText() should be implemented and return additional CSS text to apply to the passed date in the passed view
     * @param date the date to return CSS text for
     * @param rowNum the row number of the passed date in the passed view
     * @param colNum the column number of the passed date in the passed view
     * @param calendarView the view in which the date cell appears
     * @return CSS class to apply to the cell associated with the passed date in the passed view
     */
    public abstract String getDateCSSText(Date date, int rowNum, int colNum, CalendarView calendarView);
}
