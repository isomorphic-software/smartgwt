package com.smartgwt.sample.showcase.client.calendar;

import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.calendar.Calendar;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;
import com.smartgwt.sample.showcase.client.data.CalendarData;

public class SimpleEventComponentsSample extends ShowcasePanel {

    private static final String DESCRIPTION = " In this sample, Calendar.showEventCanvasComponents to set to true, "+
        "which causes eventCanvases to render a child component as their content, rather than the default header and body HTML."+
        "<p>"+
        "The child component is, by default, an instance of the calendar.eventCanvasComponent AutoChild, which can be configured via "+
        "the usual AutoChild mechanisms - eventCanvasComponentConstructor and eventCanvasComponentProperties. With default settings, "+
        "the child component is a DetailViewer, showing the values from the associated event."+
        "<p>"+
        "For deeper customization, such as providing custom component-content per-event, see the documentation for create/updateEventCanvasComponent().";


    public static class Factory implements PanelFactory {

        private String id;

        public ShowcasePanel create() {
            SimpleEventComponentsSample panel = new SimpleEventComponentsSample();
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
        calendar.setShowEventCanvasComponents(true);
        
        return calendar;
    }

    public String getIntro() {
        return DESCRIPTION;
    }

}
