package com.smartgwt.sample.showcase.client.forms.dependencies;

import com.smartgwt.client.types.TitleOrientation;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.ButtonItem;
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.form.fields.RadioGroupItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ClickEvent;
import com.smartgwt.client.widgets.form.validator.RequiredIfFunction;
import com.smartgwt.client.widgets.form.validator.RequiredIfValidator;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

public class FormConditionallyRequiredSample extends ShowcasePanel {
    private static final String DESCRIPTION = "Select \"No\" and click the \"Validate\" button - the reason field becomes required.";

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
            FormConditionallyRequiredSample panel = new FormConditionallyRequiredSample();
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
        form.setTitleOrientation(TitleOrientation.TOP);

        final RadioGroupItem radioGroupItem = new RadioGroupItem();
        radioGroupItem.setName("willAttend");
        radioGroupItem.setColSpan("*");
        radioGroupItem.setRequired(true);
        radioGroupItem.setVertical(false);
        radioGroupItem.setValueMap("Yes", "No");
        radioGroupItem.setRedrawOnChange(true);
        radioGroupItem.setTitle("Will you be attending the meeting on April 4th? If no, please provide a reason");

        TextItem textItem = new TextItem();
        textItem.setName("reason");
        textItem.setTitle("Reason");
        RequiredIfValidator ifValidator = new RequiredIfValidator();
        ifValidator.setExpression(new RequiredIfFunction() {
            public boolean execute(FormItem formItem, Object value) {
                String valueStr = (String) radioGroupItem.getValue();
                return "No".equals(valueStr);
            }
        });
        ifValidator.setErrorMessage("Please provide a reason");

        textItem.setValidators(ifValidator);

        ButtonItem buttonItem = new ButtonItem("validate", "Validate");
        buttonItem.addClickHandler(new com.smartgwt.client.widgets.form.fields.events.ClickHandler() {
            public void onClick(ClickEvent event) {
                form.validate();
            }
        });

        form.setFields(radioGroupItem, textItem, buttonItem);
        return form;
    }

    public String getIntro() {
        return DESCRIPTION;
    }

}