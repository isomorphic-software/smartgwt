package com.smartgwt.client.widgets.calendar;

import java.util.Date;

/**
 * Called whenever a Calender needs to show an EventEditor, to edit or create a CalendarEvent
 */
public abstract class EventEditorCustomizer {
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
     * showEventEditor() can be used to show some custom user interface for editing or creating calendar events.
     * To access the Calendar itself, use calendarView.getCalendar().
     * @param calendarEvent the event being rendered
     * @param calendarView the view in which the event is being rendered
     * @return false to prevent the default Event Editor from showing
     */
    public abstract boolean showEventEditor(CalendarEvent calendarEvent, Boolean isNewEvent);

}
