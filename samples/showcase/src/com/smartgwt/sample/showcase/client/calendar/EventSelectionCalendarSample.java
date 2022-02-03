package com.smartgwt.sample.showcase.client.calendar;

import java.util.Date;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.calendar.Calendar;
import com.smartgwt.client.widgets.calendar.CalendarEvent;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

public class EventSelectionCalendarSample extends ShowcasePanel {

    private static final String DESCRIPTION = "Calendar events may be included in the page's tab "+
        "order using the <code>canSelectEvents</code> "+
        "property. In this sample, the user can give focus to events by clicking on them or using "+
        "\"Tab\" key to navigate to them. The user can use the Enter key to start editing an event, "+
        "or the Delete key to remove it from the calendar.";


    public static class Factory implements PanelFactory {

        private String id;

        public ShowcasePanel create() {
            EventSelectionCalendarSample panel = new EventSelectionCalendarSample();
            id = panel.getID();
            return panel;
        }

        public String getID() {
            return id;
        }

        public String getDescription() {
            return DESCRIPTION;
        }
    }

    private Date today = new Date();
    private int year = today.getYear();
    private int month = today.getMonth();
    private int start = today.getDate() - today.getDay();
    
    public Canvas getViewPanel() {
        Calendar calendar = new Calendar();
        calendar.setData(getRecords());
        calendar.setShowMonthView(false);
        calendar.setShowDayView(false);
        calendar.setCanSelectEvents(true);
        calendar.setRenderEventsOnDemand(false);
        return calendar;
    }
    
    private CalendarEvent[] getRecords() {
        return new CalendarEvent[]{
            new CalendarEvent(1, "Meeting", "Shareholders meeting: monthly forecast report", new Date(year, month, start + 2, 9, 0, 0), new Date(year, month, start + 2, 14, 0, 0)),
            new CalendarEvent(2, "Realtor", "Breakfast with realtor to discuss moving plans", new Date(year, month, start + 3, 8, 0, 0), new Date(year, month, start + 3, 10, 0, 0)),
            new CalendarEvent(3, "Soccer", "Little league soccer finals", new Date(year, month, start + 4, 13, 0, 0), new Date(year, month, start + 4, 16, 0, 0)),
            new CalendarEvent(4, "Sleep", "Catch up on sleep", new Date(year, month, start + 4, 5, 0, 0), new Date(year, month, start + 4, 9, 0, 0)),
            new CalendarEvent(5, "Airport run", "Pick James up from the airport", new Date(year, month, start + 4, 1, 0, 0), new Date(year, month, start + 4, 3, 0, 0)),
            new CalendarEvent(6, "Dinner Party", "Prepare elaborate meal for friends", new Date(year, month, start + 4, 17, 0, 0), new Date(year, month, start + 4, 20, 0, 0)),
            new CalendarEvent(7, "Poker", "Poker at Steve's house", new Date(year, month, start + 4, 21, 0, 0), new Date(year, month, start + 4, 23, 0, 0)),
            new CalendarEvent(8, "Meeting", "Board of directors meeting: discussion of next months strategy", new Date(year, month, start + 5, 11, 0, 0), new Date(year, month, start + 5, 15, 0, 0))
        };
    }
    
    public String getIntro() {
        return DESCRIPTION;
    }

}