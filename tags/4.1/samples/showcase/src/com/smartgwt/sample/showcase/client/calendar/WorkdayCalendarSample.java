package com.smartgwt.sample.showcase.client.calendar;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.DataSourceDateField;
import com.smartgwt.client.data.fields.DataSourceSequenceField;
import com.smartgwt.client.data.fields.DataSourceTextField;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.calendar.Calendar;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;
import com.smartgwt.sample.showcase.client.data.CalendarData;

public class WorkdayCalendarSample extends ShowcasePanel {

    private static final String DESCRIPTION = "The calendar can focus in on workday hours, giving a clearer view of events that occur durring " +
            "the work day. The boundaries of the workday itself can also be customized.";


    public static class Factory implements PanelFactory {

        private String id;

        public Canvas create() {
            WorkdayCalendarSample panel = new WorkdayCalendarSample();
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
        DataSourceDateField startDateField = new DataSourceDateField("startDate");
        DataSourceDateField endDateField = new DataSourceDateField("endDate");

        eventDS.setFields(eventIdField, nameField, descField, startDateField, endDateField);
        eventDS.setClientOnly(true);
        eventDS.setTestData(CalendarData.getRecords());

        Calendar calendar = new Calendar();
        calendar.setShowWeekends(false);
        calendar.setShowWorkday(true);
        calendar.setScrollToWorkday(true);
        calendar.setDataSource(eventDS);
        calendar.setAutoFetchData(true);

        return calendar;
    }

    public String getIntro() {
        return DESCRIPTION;
    }

}