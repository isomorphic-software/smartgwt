package com.smartgwt.sample.showcase.client.forms.details;

import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.FormItemIcon;
import com.smartgwt.client.widgets.form.fields.StaticTextItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.IconClickEvent;
import com.smartgwt.client.widgets.form.fields.events.IconClickHandler;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

public class FormHintsSample extends ShowcasePanel {
    private static final String DESCRIPTION = "Hints provide guidance to the user filling out the form. In this case, " + 
    "the MM/YYYY hint tells the user the expected format for the free-form date field. Hints can be displayed beside the field, or inside the field.";

    private static final String HELPTEXT = "<br><b>Severity 1</b> - Critical problem<br>System is unavailable in production or " +
		    "is corrupting data, and the error severely impacts the user's operations." +
		    "<br><br><b>Severity 2</b> - Major problem<br>An important function of the system " +
		    "is not available in production, and the user's operations are restricted." +
		    "<br><br><b>Severity 3</b> - Minor problem<br>Inability to use a function of the " +
		    "system occurs, but it does not seriously affect the user's operations.";

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
        	FormHintsSample panel = new FormHintsSample();
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

        TextItem caseNumber = new TextItem("case", "Case #");
        caseNumber.setWidth(130);
        caseNumber.setHint("Enter case number");
        caseNumber.setShowHintInField(true);

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

        final TextItem dueDate = new TextItem("dueDate", "Due Date");
        dueDate.setWidth(70);
        dueDate.setHint("MM/YYYY");
        
        form.setFields(caseNumber, severityLevel, dueDate);

        return form;
    }

    public String getIntro() {
        return DESCRIPTION;
    }

}