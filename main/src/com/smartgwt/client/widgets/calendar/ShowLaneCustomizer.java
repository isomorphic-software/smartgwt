package com.smartgwt.client.widgets.calendar;

import java.util.Date;

import com.smartgwt.client.widgets.calendar.*;

/**
 * Called to determine a particular lane should be visible in the passed view
 */
public abstract class ShowLaneCustomizer {
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
    public native boolean executeDefault(Lane lane, CalendarView calendarView) /*-{
        var calendarViewJS = calendarView == null ? null : calendarView.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var laneJS = lane.@com.smartgwt.client.core.DataClass::getJsObj()();
        var calendarJ = this.@com.smartgwt.client.widgets.calendar.ShowLaneCustomizer::getCalendar()();
        var calendarJS = calendarJ.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        if (calendarJS == null) {
            $wnd.isc.logWarn('no calendar');
            return null;
        }
        var ret = calendarJS._shouldShowLane(laneJS, calendarViewJS);
        return ret;
    }-*/;
        
    /**
     * shouldShowLane() should be implemented and return true if the passed lane should be visible in the passed view
     * Use executeDefault() to run the original method to fall back on default behavior.
     * To access the Calendar itself, call getCalendar() on the event or the calendarView.
     * @param lane the lane in question
     * @param calendarView the view in which the lane exists
     * @return true if the lane should be visible in the passed view, or false otherwise
     */
    public abstract boolean shouldShowLane(Lane lane, CalendarView calendarView);
}
