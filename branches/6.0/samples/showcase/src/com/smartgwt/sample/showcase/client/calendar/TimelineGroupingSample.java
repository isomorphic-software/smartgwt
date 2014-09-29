package com.smartgwt.sample.showcase.client.calendar;

import java.util.Date;

import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.calendar.*;
import com.smartgwt.client.types.TimeUnit;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;
import com.smartgwt.sample.showcase.client.data.TimelineData;
import com.smartgwt.sample.showcase.client.data.TimelineLaneData;

public class TimelineGroupingSample extends ShowcasePanel {

    private static final String DESCRIPTION = "<p>This example shows a Timeline with it's lanes " +
            "gathered into collapsible groups.  Events can be dragged among lanes in a group, " +
            "or across groups.</p>";


    public static class Factory implements PanelFactory {

        private String id;

        public ShowcasePanel create() {
            TimelineGroupingSample panel = new TimelineGroupingSample();
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
        
        // grouping fields must be specified as laneFields, but can be hidden as is done here
        ListGridField groupField = new ListGridField("devGroup");
        groupField.setHidden(true);
        ListGridField[] laneFields = new ListGridField[]{
            new ListGridField("title", "Developer", 120),
            groupField
        };
        
        Timeline calendar = new Timeline();
        calendar.setHeight(451);
        calendar.setStartDate(new Date(112, 5, 2));
        calendar.setEndDate(new Date(112, 5, 22));
        calendar.setCanEditLane(true);
        calendar.setShowEventDescriptions(false);
        // grouping settings
        calendar.setCanGroupLanes(true);
        calendar.setLaneGroupByField("devGroup");
        calendar.setLaneFields(laneFields);
        calendar.setHeaderLevels(headerLevels);
        calendar.setLanes(TimelineLaneData.getRecords());
        calendar.setData(TimelineData.getRecords());
        
        return calendar;
    }
    
    public String getIntro() {
        return DESCRIPTION;
    }

}