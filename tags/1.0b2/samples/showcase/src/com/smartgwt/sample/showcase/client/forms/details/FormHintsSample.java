package com.smartgwt.sample.showcase.client.forms.details;

import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

public class FormHintsSample extends ShowcasePanel {
    private static final String DESCRIPTION = "Hints provide guidance to the user filling out the form. In this case, " + 
    "the MM/YYYY hint tells the user the expected format for the free-form date field."; 

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

        final TextItem date = new TextItem();
        date.setTitle("Date");
        date.setWidth(70);
        date.setHint("MM/YYYY");
        
        form.setFields(date);

        return form;
    }

    public String getIntro() {
        return DESCRIPTION;
    }

}