package com.smartgwt.sample.showcase.client.calendar;

import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.calendar.Calendar;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;
import com.smartgwt.sample.showcase.client.data.CalendarData;

public class SimpleCalendarSample extends ShowcasePanel {

    private static final String DESCRIPTION = "<p>This calendar is bound to an array of event data. Drag events to alter " +
            "their start times, and resize events to alter their durations.</p><p>Click and drag in an empty cell to create new " +
            "events, or click on an existing event to edit it. Notice how the red event can't be edited; This was " +
            "specified within the event data itself.</p>";


    public static class Factory implements PanelFactory {

        private String id;

        public Canvas create() {
            SimpleCalendarSample panel = new SimpleCalendarSample();
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
        calendar.setData(CalendarData.getRecords());
        return calendar;
    }

    public String getIntro() {
        return DESCRIPTION;
    }

}