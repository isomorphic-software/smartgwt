package com.smartgwt.sample.showcase.client.calendar;

import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.calendar.Calendar;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;
import com.smartgwt.sample.showcase.client.data.CalendarOverlappingData;

public class OverlappingEventsCalendarSample extends ShowcasePanel {

    private static final String DESCRIPTION = "<p>When eventAutoArrange is true, you can have the Calendar overlap concurrent events slightly. " +
            "The z-order is from left to right and the overlap-size is a percentage of event-width </p>. " +
            "<p>If two events start at exactly the same time, the default behaviour is to reject the overlap to avoid the first " +
            "event's close button from being hidden by the second event. You can see this by dropping one event onto the start-time of another below.</p>";


    public static class Factory implements PanelFactory {

        private String id;

        public Canvas create() {
            OverlappingEventsCalendarSample panel = new OverlappingEventsCalendarSample();
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

    public Canvas getViewPanel() {

        Calendar calendar = new Calendar();
        calendar.setData(CalendarOverlappingData.getRecords());
        calendar.setAutoFetchData(true);

        //the following are the Calendar's defaults and would still have been set without this code
        calendar.setEventAutoArrange(true);
        calendar.setEventOverlap(true);
        calendar.setEventOverlapPercent(10);
        calendar.setEventOverlapIdenticalStartTimes(false);
        return calendar;
    }

    public String getIntro() {
        return DESCRIPTION;
    }
}