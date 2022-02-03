package com.smartgwt.sample.showcase.client.forms.validation;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

public class FormTypeSample extends ShowcasePanel {
    private static final String DESCRIPTION = "Type a non-numeric value into the field and press \"Validate\" to " + 
    "receive a validation error. Declaring field type implies automatic validation anywhere a value is edited."; 

    public static class Factory implements PanelFactory {
        private String id;

        public ShowcasePanel create() {
        	FormTypeSample panel = new FormTypeSample();
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
        
        DataSourceIntegerField dsIntegerField = new DataSourceIntegerField("intField");
        dsIntegerField.setTitle("Integer");
        
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