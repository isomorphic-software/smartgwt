package com.smartgwt.client.widgets.calendar;

import java.util.Date;

/**
 * Call whenever a Calender needs to show the EventDialog, to view or create a CalendarEvent
 */
public abstract class EventDialogCustomizer {
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
     * showEventDialog() can be used to show some custom user interface for viewing or creating calendar events.
     * @param calendarEvent the event being rendered
     * @param isNewEvent true for a new event - if true, calendarEvent represent defaults to apply to the new event
     * @return false to prevent the default Event Dialog from showing
     */
    public abstract Boolean showEventDialog(CalendarEvent calendarEvent, Boolean isNewEvent);
}
