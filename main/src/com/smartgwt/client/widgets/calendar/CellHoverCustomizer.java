package com.smartgwt.client.widgets.calendar;

import java.util.Date;

import com.smartgwt.client.widgets.grid.ListGridRecord;

/**
 * Called to determine the hover text for a given cell in a CalendarView
 */
public abstract class CellHoverCustomizer {
    
    private Calendar calendar;

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }    

    /**
     * Returns the Calendar over which the hover occurred
     * @return Calendar over which the hover occurred
     */
    public Calendar getCalendar() {
        return this.calendar;
    }
    
    /**
     * getHoverHTML() should be implemented and return the string of HTML to display in the hover for a given cell in a CalendarView
     * @param record ListGridRecord the record at the passed rowNum
     * @param rowNum Integer the row index of the cell being hovered
     * @param calNum Integer the column index of the cell being hovered
     * @param date Date the snap date at the mouse pointer
     * @param defaultValue String the default hover HTML
     * @param calendarView CalendarView a reference to the calendarView containing the hover
     * @return String The formatted hover text for the values passed in
     */
    public abstract String getHoverHTML(ListGridRecord record, int rowNum, int colNum, Date date, String defaultValue, CalendarView view);
}
