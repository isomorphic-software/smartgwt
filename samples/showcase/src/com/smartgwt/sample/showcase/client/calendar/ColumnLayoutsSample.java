package com.smartgwt.sample.showcase.client.calendar;

import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.calendar.Calendar;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;
import com.smartgwt.sample.showcase.client.data.CalendarData;

public class ColumnLayoutsSample extends ShowcasePanel {

    private static final String DESCRIPTION = "In this sample, Calendar.showColumnLayouts to set to true, which causes eventCanvases " +
        "to be sized to content and stacked vertically in each day, rather then being sized according to event-dates and potentially " +
        "overlapped by other events.";


    public static class Factory implements PanelFactory {

        private String id;

        public ShowcasePanel create() {
            ColumnLayoutsSample panel = new ColumnLayoutsSample();
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
        calendar.setStartDate(CalendarData.getDataStartDate());
        calendar.setData(CalendarData.getRecords());
        calendar.setShowColumnLayouts(true);

        return calendar;
    }

    public String getIntro() {
        return DESCRIPTION;
    }

}
