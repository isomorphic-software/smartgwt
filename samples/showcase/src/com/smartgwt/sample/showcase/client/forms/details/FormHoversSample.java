package com.smartgwt.sample.showcase.client.forms.details;

import java.util.HashMap;

import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.ButtonItem;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.events.ClickEvent;
import com.smartgwt.client.widgets.form.fields.events.ClickHandler;
import com.smartgwt.client.widgets.form.fields.events.ItemHoverEvent;
import com.smartgwt.client.widgets.form.fields.events.ItemHoverHandler;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

public class FormHoversSample extends ShowcasePanel {
    private static final String DESCRIPTION = "Hover anywhere over the field to see what the current value means. " + 
    "Change the value or disable the field to see different hovers. Note that the hovers contain HTML formatting.";
	private static HashMap hoverText = null;

    public static class Factory implements PanelFactory {
        private String id;

        public ShowcasePanel create() {
        	FormHoversSample panel = new FormHoversSample();
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
        form.setID("severityForm");
        form.setWidth(200);
        form.setItemHoverWidth(200);

        final ComboBoxItem severityLevel = new ComboBoxItem();
        severityLevel.setTitle("Severity Level");
        severityLevel.setValueMap("Severity 1", "Severity 2", "Severity 3");
        severityLevel.setDefaultValue("Severity 2");
        severityLevel.addItemHoverHandler(new ItemHoverHandler() {
			public void onItemHover(ItemHoverEvent event) {
				String prompt = "Status can only be changed by the bug's owner";
	        	if (!severityLevel.isDisabled()) {
	        		prompt = getHoverText((String) severityLevel.getValue());
	        	}
				severityLevel.setPrompt(prompt);
			}
        });
        
        final ButtonItem buttonItem = new ButtonItem();
        buttonItem.setTop(40);
        buttonItem.setWidth(150);
        buttonItem.setTitle("Enable/disable field");
        buttonItem.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				severityLevel.setDisabled(!severityLevel.isDisabled());
			}
        });

        form.setFields(severityLevel, buttonItem);

        return form;
    }

    public String getIntro() {
        return DESCRIPTION;
    }

    private static String getHoverText(String key) {
    	if (hoverText == null) {
    		hoverText = new HashMap<String, String>();
        	hoverText.put("Severity 1", "<b>Severity 1</b><p>Critical problem.  System is unavailable in production or is corrupting data, and the error severely impacts the user's operations.");
        	hoverText.put("Severity 2", "<b>Severity 2</b><p> Major problem.  An important function of the system is not available in production, and the user's operations are restricted.");
        	hoverText.put("Severity 3", "<b>Severity 3</b><p> Minor problem.  Inability to use a function of the system occurs, but it does not seriously affect the user's operations.");
    	}
    	
    	return (String) hoverText.get(key);
    }
}