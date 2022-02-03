package com.smartgwt.sample.showcase.client.forms.validation;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.DataSourceTextField;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.validator.MaskValidator;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

public class FormValueTransformSample extends ShowcasePanel {
    private static final String DESCRIPTION = "Enter a 10 digit US phone number with any typical punctuation " + 
    "press \"Validate\" to see it transformed to a canonical format."; 

    public static class Factory implements PanelFactory {
        private String id;

        public ShowcasePanel create() {
        	FormValueTransformSample panel = new FormValueTransformSample();
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
        dataSource.setID("valueTransform");
        
        MaskValidator maskValidator = new MaskValidator();
        maskValidator.setMask("^\\s*(1?)\\s*\\(?\\s*(\\d{3})\\s*\\)?\\s*-?\\s*(\\d{3})\\s*-?\\s*(\\d{4})\\s*$");
        maskValidator.setTransformTo("$1($2) $3 - $4");
        
        DataSourceTextField dsTextField = new DataSourceTextField("phone");
        dsTextField.setTitle("Phone");
        dsTextField.setValidators(maskValidator);
        
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