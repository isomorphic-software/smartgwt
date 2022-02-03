package com.smartgwt.sample.showcase.client.mobile;

import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.SpinnerItem;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

public class SpinnerControlSample extends ShowcasePanel {
    private static final String DESCRIPTION = "On touch devices, the <code>SpinnerItem</code> changes appearance "+
                    "and behavior to make it easier to hit the increment and decrement buttons."+
                    "<P>"+
                    "In this sample, the appearance normally used only for touch devices is forced on for "+
                    "desktop browsers as well.";

    public static class Factory implements PanelFactory {
        private String id;

        public ShowcasePanel create() {
            SpinnerControlSample panel = new SpinnerControlSample();
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
        final DynamicForm form = new DynamicForm();

        SpinnerItem spinnerItem = new SpinnerItem();
        spinnerItem.setTitle("Unstacked Spinner");
        spinnerItem.setDefaultValue(5);
        spinnerItem.setMin(0);
        spinnerItem.setMax(10);
        spinnerItem.setStep(0.5f);
        spinnerItem.setWriteStackedIcons(false);

        form.setFields(spinnerItem);
 
        return form;
    }

    public String getIntro() {
        return DESCRIPTION;
    }

}
