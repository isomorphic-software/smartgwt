package com.smartgwt.sample.showcase.client.forms.dependencies;

import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.ButtonItem;
import com.smartgwt.client.widgets.form.fields.PasswordItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ClickEvent;
import com.smartgwt.client.widgets.form.fields.events.ClickHandler;
import com.smartgwt.client.widgets.form.validator.MatchesFieldValidator;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

public class FormMatchValueSample extends ShowcasePanel {

    private static final String DESCRIPTION = "Try entering mismatched values for \"Password\" and \"Password Again\", " +
    											"then click \"Create Account\" to see a validation error.";

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
            FormMatchValueSample panel = new FormMatchValueSample();
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
        form.setWidth(250);

        TextItem username = new TextItem();
        username.setName("username");
        username.setTitle("Username");
        username.setRequired(true);
        username.setDefaultValue("bob");

        TextItem email = new TextItem();
        email.setName("email");
        email.setTitle("Email");
        email.setRequired(true);
        email.setDefaultValue("bob@isomorphic.com");

        MatchesFieldValidator validator = new MatchesFieldValidator();
        validator.setOtherField("password2");
        validator.setErrorMessage("Passwords do not match");
        
        PasswordItem password = new PasswordItem();
        password.setName("password");
        password.setTitle("Password");
        password.setRequired(true);
        password.setValidators(validator);

        PasswordItem password2 = new PasswordItem();
        password2.setName("password2");
        password2.setTitle("Password again");
        password2.setRequired(true);

        final ButtonItem createAccount = new ButtonItem();
        createAccount.setName("createAccount");
        createAccount.setTitle("Create Account");
        createAccount.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				form.validate();
			}
        });
        
        form.setFields(username, email, password, password2, createAccount);

        return form;
    }

    public String getIntro() {
        return DESCRIPTION;
    }
}