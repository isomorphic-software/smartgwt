package com.smartgwt.client.widgets.calendar;

import java.util.Date;

/**
 * Called to determine the hover HTML to be displayed when the user hovers over an eventCanvas in a calendar.
 */
public abstract class EventHoverHTMLCustomizer {
    
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
     * getEventHoverHTML() should be implemented and return the string of HTML to display when the user hovers
     * over an event
     * @param calendarEvent the event being hovered over.
     * @param eventWindow the event window being hovered
     * @return HTML to display
     */
    public abstract String getEventHoverHTML(CalendarEvent calendarEvent, EventWindow eventWindow);
    
    /**
     * getEventHoverHTML() should be implemented and return the string of HTML to display when the user hovers
     * over an event
     * @param calendarEvent the event being hovered over.
     * @param eventCanvas the eventCanvas being hovered
     * @return HTML to display
     */
    public abstract String getEventHoverHTML(CalendarEvent calendarEvent, EventCanvas eventCanvas);
    
    /**
     * getZoneHoverHTML() should be implemented and return the string of HTML to display when the user hovers
     * over a ZoneCanvas
     * @param zone the Zone being hovered over.
     * @param zoneCanvas the zoneCanvas being hovered
     * @return HTML to display
     */
    public abstract String getZoneHoverHTML(CalendarEvent zone, ZoneCanvas zoneCanvas);
    
    /**
     * getIndicatorHoverHTML() should be implemented and return the string of HTML to display when the user hovers
     * over an IndicatorCanvas
     * @param indicator the Indicator being hovered over.
     * @param indicatorCanvas the indicatorCanvas being hovered
     * @return HTML to display
     */
    public abstract String getIndicatorHoverHTML(CalendarEvent indicator, IndicatorCanvas indicatorCanvas);

}
