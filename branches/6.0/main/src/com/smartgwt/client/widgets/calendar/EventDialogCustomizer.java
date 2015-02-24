package com.smartgwt.client.widgets.calendar;

import java.util.Date;

/**
 * Called whenever a Calender needs to show the EventDialog, to view or create a CalendarEvent
 */
public abstract class EventDialogCustomizer {
    private Calendar calendar;

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }
    /**
     * Returns the Calendar in which the EventDialog is being displayed.  To access the current 
     * view, use getCalendar().getSelectedView().
     * @return Calendar in which the EventDialog is being displayed
     */
    public Calendar getCalendar() {
        return this.calendar;
    }

    /**
     * showEventDialog() can be used to show some custom user interface for viewing or creating calendar events.
     * @param calendarEvent the event to edit
     * @param isNewEvent true for a new event - if true, calendarEvent represents defaults for the new event
     * @return false to prevent the default Event Dialog from showing
     */
    public abstract boolean showEventDialog(CalendarEvent calendarEvent, Boolean isNewEvent);
}
