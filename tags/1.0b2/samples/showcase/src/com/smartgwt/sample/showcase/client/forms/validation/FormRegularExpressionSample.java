package com.smartgwt.sample.showcase.client.forms.validation;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.DataSourceTextField;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.validator.RegExpValidator;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

public class FormRegularExpressionSample extends ShowcasePanel {
    private static final String DESCRIPTION = "Enter a bad email address (eg just \"mike\") and press \"Validate\" " + 
    "to receive a validation error. The regular expression validator allows simple custom field types, with " + 
    "automatic enforcement on client on server."; 

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
        	FormRegularExpressionSample panel = new FormRegularExpressionSample();
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
    	
        DataSource dataSource = new DataSource();
        dataSource.setID("regularExpression");
        
        RegExpValidator regExpValidator = new RegExpValidator();
        regExpValidator.setExpression("^([a-zA-Z0-9_.\\-+])+@(([a-zA-Z0-9\\-])+\\.)+[a-zA-Z0-9]{2,4}$");
        
        DataSourceTextField dsTextField = new DataSourceTextField("email");
        dsTextField.setTitle("Email");
        dsTextField.setValidators(regExpValidator);
        
        dataSource.setFields(dsTextField);
        
        final DynamicForm form = new DynamicForm();
        form.setWidth(300);
        form.setDataSource(dataSource);
        
        IButton validateButton = new IButton();
        validateButton.setTitle("Validate");
        validateButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				form.validate();
			}
        });
        
        VLayout vLayout = new VLayout();
        vLayout.setMembersMargin(10);
        vLayout.addMember(form);
        vLayout.addMember(validateButton);
        
        return vLayout;
    }

    public String getIntro() {
        return DESCRIPTION;
    }

}