package com.smartgwt.client.widgets.calendar;

import java.util.Date;

import com.smartgwt.client.widgets.calendar.*;

/**
 * Called to determine whether a particular event should be visible in the passed view
 */
public abstract class ShowEventCustomizer {
    private Calendar calendar;

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }    

    /**
     * Returns the Calendar being customized
     * @return Calendar being customized
     */
    public Calendar getCalendar() {
        return this.calendar;
    }

    /**
     * Call executeDefault() to run the original method for default behavior
     */
    public native boolean executeDefault(CalendarEvent event, CalendarView calendarView) /*-{
        var calendarViewJS = calendarView == null ? null : calendarView.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var eventJS = event.@com.smartgwt.client.core.DataClass::getJsObj()();
        var calendarJ = this.@com.smartgwt.client.widgets.calendar.ShowEventCustomizer::getCalendar()();
        var calendarJS = calendarJ.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        if (calendarJS == null) {
            $wnd.isc.logWarn('no calendar');
            return null;
        }
        var ret = calendarJS._shouldShowEvent(eventJS, calendarViewJS);
        return ret;
    }-*/;
        
    /**
     * shouldShowEvent() should be implemented and return true if the passed event should be visible in the passed view
     * Use executeDefault() to run the original method to fall back on default behavior.
     * To access the Calendar itself, call getCalendar() on the event or the calendarView.
     * @param event the event in question
     * @param calendarView the view in which the event will appear
     * @return true if the event should be rendered in the passed view, or false otherwise
     */
    public abstract boolean shouldShowEvent(CalendarEvent event, CalendarView calendarView);
}
