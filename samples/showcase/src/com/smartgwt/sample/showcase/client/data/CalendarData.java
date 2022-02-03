package com.smartgwt.sample.showcase.client.data;

import java.util.Date;

import com.smartgwt.client.widgets.calendar.CalendarEvent;

public class CalendarData {

    private static CalendarEvent[] records;
    // for this release, the data start date is May 23, 2021
    private static int year = 121;
    private static int month = 4;
    private static int start = 23;

    public static Date getDataStartDate() {
        // return the start date of the data - called from samples that use CalendarData
        return new Date(year, month, start);
    }

    public static CalendarEvent[] getRecords() {
        if (records == null) {
            records = getNewRecords();
        }
        return records;
    }

    public static CalendarEvent[] getNewRecords() {
        return new CalendarEvent[]{
                new CalendarEvent(1, "Meeting", "Shareholders meeting: monthly forecast report", new Date(year, month, start + 2, 9, 0, 0), new Date(year, month, start + 2, 14, 0, 0)),
                getStyledEvent(2, "Realtor", "This canvas is styled by color settings on the CalendarEvent", new Date(year, month, start + 3, 8, 0, 0), new Date(year, month, start + 3, 10, 0, 0)),
                new CalendarEvent(3, "Soccer", "Little league soccer finals", new Date(year, month, start + 4, 13, 0, 0), new Date(year, month, start + 4, 16, 0, 0)),
                new CalendarEvent(4, "Sleep", "Catch up on sleep", new Date(year, month, start + 4, 5, 0, 0), new Date(year, month, start + 4, 9, 0, 0)),
                new CalendarEvent(5, "Inspection", "This canvas is styled and disabled by custom styleName and canEdit settings on the CalendarEvent", new Date(year, month, start + 4, 10, 0, 0), new Date(year, month, start + 4, 12, 0, 0), false, "testStyle"),
                getStyledEvent(6, "Airport run", "This canvas is styled by color settings on the CalendarEvent", new Date(year, month, start + 4, 1, 0, 0), new Date(year, month, start + 4, 3, 0, 0)),
                new CalendarEvent(7, "Dinner Party", "Prepare elaborate meal for friends", new Date(year, month, start + 4, 17, 0, 0), new Date(year, month, start + 4, 20, 0, 0)),
                new CalendarEvent(8, "Poker", "Poker at Steve's house", new Date(year, month, start + 4, 21, 0, 0), new Date(year, month, start + 4, 23, 0, 0)),
                new CalendarEvent(9, "Meeting", "Board of directors meeting: discussion of next months strategy", new Date(year, month, start + 5, 11, 0, 0), new Date(year, month, start + 5, 15, 0, 0))
        };
    }
    
    public static CalendarEvent getStyledEvent(int eventId, String name, String description, Date startDate, Date endDate) {
    	CalendarEvent event = new CalendarEvent(eventId, name, description, startDate, endDate);
    	if (name == "Realtor") {
	    	event.setHeaderTextColor("black");
	    	event.setHeaderBackgroundColor("orange");
	    	event.setHeaderBorderColor("darkorange");
    	    event.setTextColor("darkgreen");
    		event.setBorderColor("darkorange");
    		event.setBackgroundColor("#ffffcc");
    	} else if (name == "Airport Run") {
    	    // green header (and headerBorder) with white text, on lighgreen body with darkgreen text and border
    		event.setHeaderTextColor("white");
    	    event.setHeaderBackgroundColor("green");
    	    event.setHeaderBorderColor("green");
    	    event.setTextColor("darkgreen");
    		event.setBorderColor("darkgreen");
    		event.setBackgroundColor("lightgreen");
    	}
    	return event;
    }
}