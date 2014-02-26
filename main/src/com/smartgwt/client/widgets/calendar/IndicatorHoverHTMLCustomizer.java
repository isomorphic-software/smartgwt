package com.smartgwt.client.widgets.calendar;

import java.util.Date;

/**
 * Called to determine the hover HTML to be displayed when the user hovers over an IndicatorCanvas in a calendar.
 */
public abstract class IndicatorHoverHTMLCustomizer {
    
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
     * getIndicatorHoverHTML() should be implemented and return the string of HTML to display when the user hovers
     * over an IndicatorCanvas
     * @param indicator the Indicator being hovered over.
     * @param indicatorCanvas the indicatorCanvas being hovered
     * @return HTML to display
     */
    public abstract String getIndicatorHoverHTML(CalendarEvent indicator, IndicatorCanvas indicatorCanvas);

}
