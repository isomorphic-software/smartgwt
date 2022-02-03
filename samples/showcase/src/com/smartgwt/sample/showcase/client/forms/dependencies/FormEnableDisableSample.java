package com.smartgwt.sample.showcase.client.forms.dependencies;

import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.ButtonItem;
import com.smartgwt.client.widgets.form.fields.CheckboxItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ChangeEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangeHandler;
import com.smartgwt.client.widgets.form.fields.events.ClickEvent;
import com.smartgwt.client.widgets.form.fields.events.ClickHandler;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

public class FormEnableDisableSample extends ShowcasePanel {

    private static final String DESCRIPTION = "Check \"I accept the agreement\" to enable the \"Proceed\" button.";

    public static class Factory implements PanelFactory {
        private String id;

        public ShowcasePanel create() {
            FormEnableDisableSample panel = new FormEnableDisableSample();
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
        
        TextItem fullName = new TextItem();
        fullName.setName("fullName");
        fullName.setTitle("Full Name");
        fullName.setDefaultValue("Billy Bob");

        final ButtonItem buttonItem = new ButtonItem();
        buttonItem.setName("proceed");
        buttonItem.setTitle("Proceed");
        buttonItem.setDisabled(true);
        buttonItem.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				SC.say("OK");
			}
        });
        
        CheckboxItem licenseAccept = new CheckboxItem();
        licenseAccept.setName("licenseAccept");
        licenseAccept.setTitle("I accept the agreement");
        licenseAccept.setValue(false);
        licenseAccept.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {
				buttonItem.setDisabled(!((Boolean) event.getValue()));
			}
        });
        
        form.setFields(fullName, licenseAccept, buttonItem);

        return form;
    }

    public String getIntro() {
        return DESCRIPTION;
    }
}