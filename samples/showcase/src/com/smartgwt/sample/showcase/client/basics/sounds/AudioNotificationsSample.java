package com.smartgwt.sample.showcase.client.basics.sounds;

import com.smartgwt.client.util.SC;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.DataSourceTextField;
import com.smartgwt.client.data.fields.DataSourceSequenceField;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.Sound;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.validator.RegExpValidator;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.SubmitItem;
import com.smartgwt.client.widgets.form.fields.events.ClickEvent;
import com.smartgwt.client.widgets.form.fields.events.ClickHandler;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

public class AudioNotificationsSample extends ShowcasePanel {
    private static final String DESCRIPTION = "The Sound class can add valuable user "+
        "feedback to an interaction. This sample uses sound to notify a user whether their "+
        "interaction was successful."+
        "<P>"+
        "Leave the \"Email\" field empty and click the \"Submit\" button to perform an "+
        "invalid submission. The sample will play an error sound and show a dialog indicating "+
        "what went wrong. Dismiss the error and populate both fields before submitting to get "+
        "a successful submission notification."; 

    public static class Factory implements PanelFactory {
        private String id;

        public ShowcasePanel create() {
        	AudioNotificationsSample panel = new AudioNotificationsSample();
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
        DataSource ds = new DataSource();
        DataSourceSequenceField pkField = new DataSourceSequenceField("pk");
        pkField.setPrimaryKey(true);
        DataSourceTextField nameField = new DataSourceTextField("name", "Name");
        RegExpValidator regExpValidator = new RegExpValidator();
        regExpValidator.setExpression("^([a-zA-Z0-9_.\\-+])+@(([a-zA-Z0-9\\-])+\\.)+[a-zA-Z0-9]{2,4}$");
        DataSourceTextField emailField = new DataSourceTextField("email", "Email");
        emailField.setValidators(regExpValidator);
        ds.setClientOnly(true);          
        ds.setFields(pkField, nameField, emailField);  
		
        final DynamicForm registrationForm = new DynamicForm();
        registrationForm.setWidth(150);
        registrationForm.setDataSource(ds);
        TextItem nameItem = new TextItem("name");
        nameItem.setRequired(true);
        nameItem.setValue("John Smith");
        TextItem emailItem = new TextItem("email");
        emailItem.setRequired(true);
        SubmitItem submitButton = new SubmitItem();
        submitButton.setTitle("Submit");
        submitButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                boolean audioIsSupported = Sound.isSupported();
                if (registrationForm.validate()) {
                    if (audioIsSupported) Sound.play("audios/success.wav");
                    SC.say("Submission accepted");
                } else {
                    if (audioIsSupported) Sound.play("audios/error.wav");
                    SC.warn("Submission Error", "Please complete all fields");
                    registrationForm.focus();
                }
            }
        });
        registrationForm.setFields(nameItem, emailItem, submitButton);

        return registrationForm;
    }

    public String getIntro() {
        return DESCRIPTION;
    }

}