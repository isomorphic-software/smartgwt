package com.smartgwt.sample.showcase.client.combobox;

import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.SelectOtherItem;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

public class SelectOtherFieldSample extends ShowcasePanel {

    private static final String DESCRIPTION = "<p>Select \"Other..\" from the drop down to enter a custom value.</p>";

    public static class Factory implements PanelFactory {
        private String id;

        public ShowcasePanel create() {
            SelectOtherFieldSample panel = new SelectOtherFieldSample();
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
        form.setWidth(300);

        SelectOtherItem selectOtherItem = new SelectOtherItem();
        selectOtherItem.setOtherTitle("Other..");
        selectOtherItem.setOtherValue("OtherVal");

        selectOtherItem.setTitle("Units");
        selectOtherItem.setValueMap("Ea", "Pkt", "Bag", "Ctn");
        form.setFields(selectOtherItem);

        return form;
    }

    public String getIntro() {
        return DESCRIPTION;
    }
}