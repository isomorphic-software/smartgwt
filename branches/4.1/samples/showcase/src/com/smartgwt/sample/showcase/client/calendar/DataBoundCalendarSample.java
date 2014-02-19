package com.smartgwt.sample.showcase.client.calendar;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.DataSourceDateTimeField;
import com.smartgwt.client.data.fields.DataSourceSequenceField;
import com.smartgwt.client.data.fields.DataSourceTextField;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.calendar.Calendar;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;
import com.smartgwt.sample.showcase.client.data.CalendarData;

public class DataBoundCalendarSample extends ShowcasePanel {

    private static final String DESCRIPTION = "<p>This calendar is bound to a dataSource. Drag events to alter their start times, " +
            "and resize events to alter their durations.</p> <p>Click and drag in an empty cell to create new events, or click on " +
            "an existing event to edit it. Notice how the red event can't be edited; This was specified within the event data itself.</p>";


    public static class Factory implements PanelFactory {

        private String id;

        public Canvas create() {
            DataBoundCalendarSample panel = new DataBoundCalendarSample();
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
        DataSource eventDS = new DataSource();
        DataSourceSequenceField eventIdField = new DataSourceSequenceField("eventId");
        eventIdField.setPrimaryKey(true);

        DataSourceTextField nameField = new DataSourceTextField("name");
        DataSourceTextField descField = new DataSourceTextField("description");
        DataSourceDateTimeField startDateField = new DataSourceDateTimeField("startDate");
        DataSourceDateTimeField endDateField = new DataSourceDateTimeField("endDate");

        eventDS.setFields(eventIdField, nameField, descField, startDateField, endDateField);
        eventDS.setClientOnly(true);
        eventDS.setTestData(CalendarData.getRecords());

        Calendar calendar = new Calendar();
        calendar.setDataSource(eventDS);
        calendar.setAutoFetchData(true);

        return calendar;
    }

    public String getIntro() {
        return DESCRIPTION;
    }

}