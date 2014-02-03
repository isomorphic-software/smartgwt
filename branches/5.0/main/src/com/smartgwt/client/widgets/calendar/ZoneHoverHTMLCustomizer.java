package com.smartgwt.client.widgets.calendar;

import java.util.Date;

/**
 * Called to determine the hover HTML to be displayed when the user hovers over an ZoneCanvas in a calendar.
 */
public abstract class ZoneHoverHTMLCustomizer {
    
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
     * getZoneHoverHTML() should be implemented and return the string of HTML to display when the user hovers
     * over a ZoneCanvas
     * @param zone the Zone being hovered over.
     * @param zoneCanvas the zoneCanvas being hovered
     * @return HTML to display
     */
    public abstract String getZoneHoverHTML(CalendarEvent zone, ZoneCanvas zoneCanvas);

}
