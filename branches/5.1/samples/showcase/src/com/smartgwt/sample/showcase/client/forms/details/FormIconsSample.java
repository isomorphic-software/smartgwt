package com.smartgwt.sample.showcase.client.forms.details;

import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.FormItemIcon;
import com.smartgwt.client.widgets.form.fields.StaticTextItem;
import com.smartgwt.client.widgets.form.fields.events.IconClickEvent;
import com.smartgwt.client.widgets.form.fields.events.IconClickHandler;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

public class FormIconsSample extends ShowcasePanel {

    private static final String DESCRIPTION = "Click on the help icon below to see a description " +
    		"for severity levels. Form items can show an arbitrary number of icons to do whatever you need.";

    private static final String HELPTEXT = "<br><b>Severity 1</b> - Critical problem<br>System is unavailable in production or " +
		    "is corrupting data, and the error severely impacts the user's operations." +
		    "<br><br><b>Severity 2</b> - Major problem<br>An important function of the system " +
		    "is not available in production, and the user's operations are restricted." +
		    "<br><br><b>Severity 3</b> - Minor problem<br>Inability to use a function of the " +
		    "system occurs, but it does not seriously affect the user's operations.";

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
            FormIconsSample panel = new FormIconsSample();
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
        form.setWidth(200);
        
        FormItemIcon icon = new FormItemIcon();
        icon.setSrc("[SKIN]/actions/help.png");
        
        final StaticTextItem severityLevel = new StaticTextItem();
        severityLevel.setName("severityLevel");
        severityLevel.setTitle("Severity Level");
        severityLevel.setDefaultValue("Severity 2");
        severityLevel.setIcons(icon);
        severityLevel.addIconClickHandler(new IconClickHandler() {
			public void onIconClick(IconClickEvent event) {
				SC.say(HELPTEXT);
			}
        });
        
        form.setFields(severityLevel);

        return form;
    }

    public String getIntro() {
        return DESCRIPTION;
    }
}