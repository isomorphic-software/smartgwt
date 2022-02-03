package com.smartgwt.sample.showcase.client.calendar;

import java.util.Date;

import com.smartgwt.client.types.TimeUnit;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.calendar.CalendarEvent;
import com.smartgwt.client.widgets.calendar.HeaderLevel;
import com.smartgwt.client.widgets.calendar.Timeline;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;
import com.smartgwt.sample.showcase.client.data.TimelineData;
import com.smartgwt.sample.showcase.client.data.TimelineLaneData;

public class SimpleTimelineSample extends ShowcasePanel {

    private static final String DESCRIPTION = "<p>This example uses a Timeline, a simple subclass of Calendar, to show a variety of " +
            "development tasks assigned to developers over a 3-week period.  This timeline is bound " +
            "to an array of event data. Drag events to alter their start dates, and resize events to " +
            "alter their durations. Hover over an event to see it's details or click to edit them.</p>";


    public static class Factory implements PanelFactory {

        private String id;

        public ShowcasePanel create() {
            SimpleTimelineSample panel = new SimpleTimelineSample();
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
        Timeline calendar = new Timeline();
        calendar.setHeight(451);
        calendar.setStartDate(new Date(116, 5, 2));
        calendar.setEndDate(new Date(116, 5, 22));
        calendar.setCanEditLane(true);
        calendar.setShowEventDescriptions(false);

        HeaderLevel[] headerLevels = new HeaderLevel[]{
            new HeaderLevel(TimeUnit.WEEK), 
            new HeaderLevel(TimeUnit.DAY)
        };
        calendar.setHeaderLevels(headerLevels);
        calendar.setLaneFields(new ListGridField[]{ new ListGridField("title", "Developer", 120)});
        calendar.setLanes(TimelineLaneData.getRecords());
        calendar.setData(TimelineData.getRecords());

        return calendar;
    }

    public String getIntro() {
        return DESCRIPTION;
    }

}