package com.smartgwt.sample.showcase.client.calendar;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.DataSourceDateField;
import com.smartgwt.client.data.fields.DataSourceSequenceField;
import com.smartgwt.client.data.fields.DataSourceTextField;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.calendar.Calendar;
import com.smartgwt.client.widgets.calendar.CalendarEvent;
import com.smartgwt.client.widgets.calendar.events.DayBodyClickEvent;
import com.smartgwt.client.widgets.calendar.events.DayBodyClickHandler;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;
import com.smartgwt.sample.showcase.client.data.CalendarData;

import java.util.Date;

public class CompactCalendarSample extends ShowcasePanel {

    private static final String DESCRIPTION = "Hover over the days with the check icon in them to see the events for " +
            "those days. Use the 'next' and 'previous' arrows to change months. ";


    public static class Factory implements PanelFactory {

        private String id;

        public Canvas create() {
            CompactCalendarSample panel = new CompactCalendarSample();
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

        Calendar calendar = new Calendar() {
            @Override
            public String getDayBodyHTML(Date date, CalendarEvent[] events, Calendar calendar, int rowNum, int colNum) {
                String returnStr = date.getDate() + "";
                if(events != null && events.length > 0) {
                    returnStr += imgHTML("icons/16/approved.png", 16, 16, "image", "style='margin-top:6px'", null);
                }
                return returnStr;
            }
        };

        calendar.setWidth(500);
        calendar.setHeight(220);
        calendar.setShowDayView(false);
        calendar.setShowWeekView(false);
        calendar.setShowOtherDays(false);
        calendar.setShowDayHeaders(false);
        calendar.setShowDatePickerButton(false);
        calendar.setShowAddEventButton(false);
        calendar.setDisableWeekends(false);        
        calendar.setShowDateChooser(false);
        calendar.setCanCreateEvents(false);

        calendar.setDataSource(eventDS);
        calendar.setAutoFetchData(true);
        calendar.addDayBodyClickHandler(new DayBodyClickHandler() {
            public void onDayBodyClick(DayBodyClickEvent event) {
                String nameStr = "";
                CalendarEvent[] events = event.getEvents();
                if(events.length == 0) {
                    nameStr = "No events";
                } else {
                    for (CalendarEvent calEvent : events) {
                        nameStr += calEvent.getName() + "<br/>";
                    }
                }
                SC.say(nameStr);
            }
        });

        return calendar;
    }

    public String getIntro() {
        return DESCRIPTION;
    }

}
