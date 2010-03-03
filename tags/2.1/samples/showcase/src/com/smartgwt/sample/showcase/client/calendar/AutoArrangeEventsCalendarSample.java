package com.smartgwt.sample.showcase.client.calendar;

import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.calendar.Calendar;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;
import com.smartgwt.sample.showcase.client.data.CalendarOverlappingData;

public class AutoArrangeEventsCalendarSample extends ShowcasePanel {

    private static final String DESCRIPTION = "<p>The calendar can automatically arrange events that share time so that each is always fully visible at its proper location. " +
            "Drag one event onto or away from another to see the effect.</p>";


    public static class Factory implements PanelFactory {

        private String id;

        public Canvas create() {
            AutoArrangeEventsCalendarSample panel = new AutoArrangeEventsCalendarSample();
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
        calendar.setEventOverlap(false);
        return calendar;
    }

    public String getIntro() {
        return DESCRIPTION;
    }
}