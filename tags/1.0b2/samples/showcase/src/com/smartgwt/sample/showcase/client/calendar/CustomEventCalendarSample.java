package com.smartgwt.sample.showcase.client.calendar;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.DataSourceDateField;
import com.smartgwt.client.data.fields.DataSourceSequenceField;
import com.smartgwt.client.data.fields.DataSourceTextField;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.calendar.Calendar;
import com.smartgwt.client.widgets.form.fields.HeaderItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.RadioGroupItem;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;
import com.smartgwt.sample.showcase.client.data.CalendarData;

import java.util.LinkedHashMap;

public class CustomEventCalendarSample extends ShowcasePanel {

    private static final String DESCRIPTION = "<p>Click in an empty cell or in an event to see custom fields in the quick event editor and in the full event editor.</p>" +
            "<p>Notice how the red event can't be edited; This was specified within the event data itself (see the 'eventData' tab below).</p>";


    public static class Factory implements PanelFactory {

        private String id;

        public Canvas create() {
            CustomEventCalendarSample panel = new CustomEventCalendarSample();
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
        calendar.setDataSource(eventDS);
        calendar.setAutoFetchData(true);

        //specify the last field from the default fields so that subsequent fields come after the
        //default fields
        TextItem descItem = new TextItem();
        descItem.setName("description");

        //custom fields below
        HeaderItem eventOptions = new HeaderItem();
        eventOptions.setDefaultValue("Event Options");

        SelectItem repeatsItem = new SelectItem();
        repeatsItem.setName("repeats");
        repeatsItem.setTitle("Repeats");
        repeatsItem.setColSpan(4);
        repeatsItem.setDefaultToFirstOption(true);
        repeatsItem.setValueMap("Does not repeat", "Daily", "Weekly", "Monthly", "Yearly");

        SelectItem reminderItem = new SelectItem();
        reminderItem.setName("reminderType");
        reminderItem.setTitle("Reminder");
        reminderItem.setWidth(70);
        reminderItem.setDefaultToFirstOption(true);
        reminderItem.setValueMap("Pop-up", "Email");

        TextItem reminderValue = new TextItem();
        reminderValue.setShowTitle(false);
        reminderValue.setWidth(60);
        //reminderValue.setDefaultValue(10);

        SelectItem reminderUnits = new SelectItem();
        reminderUnits.setShowTitle(false);
        reminderUnits.setWidth(70);
        reminderUnits.setDefaultToFirstOption(false);
        reminderUnits.setValueMap("minutes", "hours", "days");

        calendar.setEventEditorFields(descItem, eventOptions, repeatsItem, reminderItem, reminderValue, reminderUnits);

        TextItem nameItem = new TextItem();
        nameItem.setType("text");
        nameItem.setName("name");

        RadioGroupItem radioGroupItem = new RadioGroupItem("sharing");
        radioGroupItem.setTitle("Sharing");
        radioGroupItem.setVertical(false);
        radioGroupItem.setValueMap("Public", "Private");
        radioGroupItem.setWidth(50);
        
        calendar.setEventDialogFields(nameItem, radioGroupItem);

        return calendar;
    }

    public String getIntro() {
        return DESCRIPTION;
    }

}