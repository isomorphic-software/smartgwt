package com.smartgwt.sample.showcase.client.forms;

import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.ButtonItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ClickEvent;
import com.smartgwt.client.widgets.form.fields.events.ClickHandler;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

public class FormFocusFirstSample extends ShowcasePanel {
    private static final String DESCRIPTION = "<p>Setting the focus / cursor on the first field of a form is common requirement. Doing this in Smart GWT is as simple as setting <code>form.setAutoFocus(true)</code>.</p>" +
            "<p>This sample also has <code>setSelectOnFocus(true)</code> on the first field.</p>";

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
            FormFocusFirstSample panel = new FormFocusFirstSample();
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
        form.setAutoFocus(true);
        form.setNumCols(3);
        form.setWidth(300);

        TextItem firstName = new TextItem("fName");
        firstName.setTitle("First Name");
        firstName.setSelectOnFocus(true);
        firstName.setWrapTitle(false);
        firstName.setDefaultValue("[First Name]");

        TextItem lastName = new TextItem("lName");
        lastName.setTitle("Last Name");
        lastName.setDefaultValue("[Last Name]");
        lastName.setWrapTitle(false);

        ButtonItem button = new ButtonItem("hello", "Hello");
        button.setStartRow(false);
        button.setWidth(80);
        button.setIcon("icons/16/message.png");
        button.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                SC.say("Hello " + form.getValueAsString("fName") + " " + form.getValueAsString("lName"));
            }
        });

        form.setFields(firstName, lastName, button);

        return form;
    }

    public String getIntro() {
        return DESCRIPTION;
    }
}