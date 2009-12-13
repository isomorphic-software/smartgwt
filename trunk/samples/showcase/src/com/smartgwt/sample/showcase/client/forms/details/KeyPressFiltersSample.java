package com.smartgwt.sample.showcase.client.forms.details;

import com.smartgwt.client.types.CharacterCasing;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

public class KeyPressFiltersSample extends ShowcasePanel {
    private static final String DESCRIPTION = "KeyPress filters help prevent the user from entering invalid characters. Additionally, character casing can be forced to either upper or lowercase.";

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
        	KeyPressFiltersSample panel = new KeyPressFiltersSample();
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
        DynamicForm form = new DynamicForm();
        TextItem nameField = new TextItem("name", "Name");
        nameField.setWidth(200);
        nameField.setHint("Mapped to uppercase");
        nameField.setCharacterCasing(CharacterCasing.UPPER);

        TextItem commisionField = new TextItem("commission", "Commission");
        commisionField.setWidth(100);
        commisionField.setHint("Numeric&nbsp;only<br>[0-9.]");        
        commisionField.setKeyPressFilter("[0-9.]");

        form.setFields(nameField, commisionField);
        
        return form;
    }

    public String getIntro() {
        return DESCRIPTION;
    }
}