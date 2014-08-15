package com.smartgwt.sample.showcase.client.other;

import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.DateChooser;
import com.smartgwt.client.widgets.events.DataChangedEvent;
import com.smartgwt.client.widgets.events.DataChangedHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.BlurbItem;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

public class DateChooserSample extends ShowcasePanel {

    private static final String DESCRIPTION = "This is an example of a DateChooser control";

    public static class Factory implements PanelFactory {
        private String id;

        public ShowcasePanel create() {
            DateChooserSample panel = new DateChooserSample();
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
        VLayout layout = new VLayout(10);

        DynamicForm form = new DynamicForm();
        form.setWidth(300);
        final BlurbItem blurbItem = new BlurbItem();
        form.setItems(blurbItem);

        final DateChooser dateChooser = new DateChooser();
        dateChooser.setWidth(100);
        dateChooser.addDataChangedHandler(new DataChangedHandler() {
            @Override
            public void onDataChanged(DataChangedEvent event) {
                blurbItem.setValue("Selected date : " + dateChooser.getData());
            }
        });

        layout.addMember(dateChooser);
        layout.addMember(form);
        return layout;
    }

    public String getIntro() {
        return DESCRIPTION;
    }
}