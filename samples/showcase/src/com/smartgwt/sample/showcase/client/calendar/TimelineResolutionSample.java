package com.smartgwt.sample.showcase.client.calendar;

import java.util.Date;

import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.calendar.*;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.toolbar.ToolStrip;
import com.smartgwt.client.widgets.toolbar.ToolStripButton;
import com.smartgwt.client.types.TimeUnit;

import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;
import com.smartgwt.sample.showcase.client.data.TimelineData;
import com.smartgwt.sample.showcase.client.data.TimelineLaneData;

public class TimelineResolutionSample extends ShowcasePanel {

    private static final String DESCRIPTION = "<p>This example demonstrates switching the " +
            "resolution of a Timeline at runtime.  Click the various buttons to see the " +
            "Timeline rebuilt with appropriate columns, range and granularity.</p>";


    public static class Factory implements PanelFactory {

        private String id;

        public ShowcasePanel create() {
            TimelineResolutionSample panel = new TimelineResolutionSample();
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

    public Timeline calendar;
    
    public Canvas getViewPanel() {
        VLayout layout = new VLayout();
        layout.setWidth100();
        layout.setHeight100();
        layout.addMember(getToolStrip());
        layout.addMember(getTimeline());
        
        return layout;
    }
    
    public Timeline getTimeline () {
        HeaderLevel[] headerLevels = new HeaderLevel[]{
            new HeaderLevel(TimeUnit.WEEK), 
            new HeaderLevel(TimeUnit.DAY)
        };
        
        calendar = new Timeline();
        calendar.setHeight(451);
        calendar.setStartDate(new Date(116, 5, 2));
        calendar.setEndDate(new Date(116, 5, 22));
        calendar.setCanEditLane(true);
        calendar.setShowEventDescriptions(false);
        calendar.setEventSnapGap(60); // snap to 1 hour intervals
        calendar.setLaneEventPadding(2); // add a little space around events
        // set up the grid 
        calendar.setHeaderLevels(headerLevels);
        calendar.setLanes(TimelineLaneData.getRecords());
        calendar.setLaneFields(new ListGridField[]{ new ListGridField("title", "Developer", 120)});
        calendar.setData(TimelineData.getRecords());
        return calendar;
    }
    
    public ToolStrip getToolStrip() {
        ToolStrip toolStrip = new ToolStrip();
        toolStrip.addButton(
            getButton("minuteDay", "Minutes (12 hours, every 15 minute)",
                new HeaderLevel[] { new HeaderLevel(TimeUnit.HOUR), new HeaderLevel(TimeUnit.MINUTE) }, TimeUnit.HOUR, 12, 15
            )
        );
        toolStrip.addButton(
                getButton("hourDay", "Hours (1 day)",
                    new HeaderLevel[] { new HeaderLevel(TimeUnit.DAY), new HeaderLevel(TimeUnit.HOUR) }, TimeUnit.HOUR, 24, null
                )
            );
        toolStrip.addButton(
                getButton("dayWeek", "Days (3 weeks)",
                    new HeaderLevel[] { new HeaderLevel(TimeUnit.WEEK), new HeaderLevel(TimeUnit.DAY) }, TimeUnit.DAY, 21, null
                )
            );
        toolStrip.addButton(
                getButton("week6Month", "Weeks (6 months)",
                    new HeaderLevel[] { new HeaderLevel(TimeUnit.MONTH), new HeaderLevel(TimeUnit.WEEK) }, TimeUnit.MONTH, 6, null
                )
            );
        toolStrip.addButton(
                getButton("monthYear", "Months (1 year)",
                    new HeaderLevel[] { new HeaderLevel(TimeUnit.YEAR), new HeaderLevel(TimeUnit.MONTH) }, TimeUnit.MONTH, 12, null
                )
            );
        toolStrip.addButton(
                getButton("monthQuarterYear", "Months (2 years, with quarters)",
                    new HeaderLevel[] { new HeaderLevel(TimeUnit.YEAR), new HeaderLevel(TimeUnit.QUARTER), new HeaderLevel(TimeUnit.MONTH) }, TimeUnit.MONTH, 24, null
                )
            );
        
        return toolStrip;
    }
    public ToolStripButton getButton(String ID, String title, final HeaderLevel[] headerLevels, final TimeUnit unit, final Integer columnCount, final Integer minutesPerColumn) {
        ToolStripButton button = new ToolStripButton(title);
        button.setID(ID);
        button.setAutoFit(true);
        button.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                calendar.setResolution(headerLevels, unit, columnCount, minutesPerColumn);
            }
        });
        return button;
    }

    public String getIntro() {
        return DESCRIPTION;
    }

}