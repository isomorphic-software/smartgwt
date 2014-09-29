package com.smartgwt.client.widgets.calendar;

import java.util.Date;

import com.smartgwt.client.widgets.calendar.*;

/**
 * Called to determine whether the passed date should be considered disabled in the passed view
 */
public abstract class DisableDateCustomizer {
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
    public native boolean executeDefault(Date date, CalendarView calendarView) /*-{
        var calendarViewJS = calendarView == null ? null : calendarView.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
	    var dateJS = date == null ? null : @com.smartgwt.client.util.JSOHelper::convertToJavaScriptDate(Ljava/util/Date;)(date);
        var calendarJ = this.@com.smartgwt.client.widgets.calendar.DisableDateCustomizer::getCalendar()();
        var calendarJS = calendarJ.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        if (calendarJS == null) {
            $wnd.isc.logWarn('no calendar');
            return null;
        }
        var ret = calendarJS._shouldDisableDate(dateJS, calendarViewJS);
        return ret;
    }-*/;

    /**
     * shouldDisableDate() should be implemented and return true if the passed date should be considered disabled in the passed view
     * Use executeDefault() to run the original method to fall back on default behavior.
     * @param date the date in question
     * @param calendarView the view in which the date cell exists
     * @return true if the date should be considered disabled, or false otherwise
     */
    public abstract boolean shouldDisableDate(Date date, CalendarView calendarView);
}
