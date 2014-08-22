package com.smartgwt.sample.showcase.client.calendar;

import java.util.Date;

import com.smartgwt.client.types.TimeUnit;
import com.smartgwt.client.widgets.calendar.CalendarEvent;
import com.smartgwt.client.widgets.calendar.HeaderLevel;
import com.smartgwt.client.widgets.calendar.Timeline;
import com.smartgwt.client.widgets.grid.ListGridField;

import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;
import com.smartgwt.sample.showcase.client.data.TimelineData;
import com.smartgwt.sample.showcase.client.data.TimelineLaneData;

public class TimelineZonesAndIndicatorsSample extends ShowcasePanel {

    private static final String DESCRIPTION = "<p>This example shows Calendar Zones and " +
            "Indicators.  Zones are semi-transparent styled areas that sit behind event " +
            "canvases and span all lanes.  Indicators are vertical lines that represents a " +
            "specific moment in time and also span all lanes.</p>";


    public static class Factory implements PanelFactory {

        private String id;

        public ShowcasePanel create() {
            TimelineZonesAndIndicatorsSample panel = new TimelineZonesAndIndicatorsSample();
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
        HeaderLevel[] headerLevels = new HeaderLevel[]{
            new HeaderLevel(TimeUnit.WEEK), 
            new HeaderLevel(TimeUnit.DAY)
        };
        
        Timeline calendar = new Timeline();
        calendar.setHeight(451);
        calendar.setStartDate(new Date(112, 5, 2));
        calendar.setEndDate(new Date(112, 5, 22));
        calendar.setCanEditLane(true);
        calendar.setShowEventDescriptions(false);
        calendar.setEventSnapGap(1); // snap to 1 minute intervals
        calendar.setLaneEventPadding(2); // add a little space around events
        // zone settings
        calendar.setShowZones(true);
        calendar.setZones(
        	new CalendarEvent(-1, "June 3-6", "", new Date(112, 5, 3), new Date(112, 5, 6)),
        	new CalendarEvent(-2, "June 10-14", "", new Date(112, 5, 10), new Date(112, 5, 14))
        );
        // indicator settings
        calendar.setShowIndicators(true);
        calendar.setIndicators(
        	new CalendarEvent(-3, "June 15 - noon", "Team Lunch", new Date(112, 5, 15, 12, 0), null)
        );
        // set up the grid 
        calendar.setHeaderLevels(headerLevels);
        calendar.setLanes(TimelineLaneData.getRecords());
        calendar.setLaneFields(new ListGridField[]{ new ListGridField("title", "Developer", 120)});
        calendar.setData(TimelineData.getRecords());

        return calendar;
    }
    
    public String getIntro() {
        return DESCRIPTION;
    }

}