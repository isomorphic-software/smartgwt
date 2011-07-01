
package com.smartgwt.sample.showcase.client.calendar;

import com.smartgwt.client.types.DateDisplayFormat;
import com.smartgwt.client.types.TimeFormatter;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.calendar.Calendar;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;
import com.smartgwt.sample.showcase.client.data.CalendarData;

public class CalendarDateTimeFormatSample extends ShowcasePanel {

    private static final String DESCRIPTION = "<p>In this sample the display formats for Calendar hours and dates have been customized to be 24 hour based " +
            "and to have a european date format of DD/MM/YYYY.</p>";

    public static class Factory implements PanelFactory {

        private String id;

        public Canvas create() {
            CalendarDateTimeFormatSample panel = new CalendarDateTimeFormatSample();
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
        //use 24 hr based times
        calendar.setTimeFormatter(TimeFormatter.TOSHORT24HOURTIME);

        //use european based DD/MM/YYYY date formats
        calendar.setDateFormatter(DateDisplayFormat.TOEUROPEANSHORTDATE);
        calendar.setData(CalendarData.getRecords());
        return calendar;
    }

    public String getIntro() {
        return DESCRIPTION;
    }

}