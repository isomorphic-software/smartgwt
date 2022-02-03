package com.smartgwt.sample.showcase.client.forms.validation;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.validator.IntegerRangeValidator;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

public class FormBuiltinsSample extends ShowcasePanel {
    private static final String DESCRIPTION = "Type a number greater than 20 or less than 1 and press \"Validate\" " + 
    "to receive a validation error. Smart GWT implements the XML Schema set of validators on both client and server.";

    public static class Factory implements PanelFactory {
        private String id;

        public ShowcasePanel create() {
        	FormBuiltinsSample panel = new FormBuiltinsSample();
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
        
        IntegerRangeValidator integerRangeValidator = new IntegerRangeValidator();
        integerRangeValidator.setMin(1);
        integerRangeValidator.setMax(20);
        
        DataSourceIntegerField dsIntegerField = new DataSourceIntegerField("intField");
        dsIntegerField.setTitle("Integer");
        dsIntegerField.setValidators(integerRangeValidator);
        
        dataSource.setFields(dsIntegerField);
        
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
        
        HLayout hLayout = new HLayout();
        hLayout.setMembersMargin(10);
        hLayout.addMember(form);
        hLayout.addMember(validateButton);
        
        return hLayout;
    }

    public String getIntro() {
        return DESCRIPTION;
    }

}