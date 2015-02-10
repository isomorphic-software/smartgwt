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
     * Returns the Calendar in which the EventEditor is being displayed.  To access the current 
     * view, use getCalendar().getSelectedView().
     * @return Calendar in which the EventEditor is being displayed
     */
    public Calendar getCalendar() {
        return this.calendar;
    }

    /**
     * showEventEditor() can be used to show some custom user interface for editing or creating calendar events.
     * @param calendarEvent the event to edit
     * @param isNewEvent true for a new event - if true, calendarEvent represents defaults for the new event
     * @return false to prevent the default Event Editor from showing
     */
    public abstract boolean showEventEditor(CalendarEvent calendarEvent, Boolean isNewEvent);

}
