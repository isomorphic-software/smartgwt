package com.smartgwt.sample.showcase.client.other;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.data.SimpleType;
import com.smartgwt.client.types.FieldType;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.validator.RegExpValidator;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

public class TypeReuseSample extends ShowcasePanel {

    private static final String DESCRIPTION = "<p>This example demonstrates a DataSourceField that is based on a user created <code>SimpleType</code>. As illustrated in this sample, " +
            "a user can create a reusable ZipCode SimpleType class with a regular expression based <code>com.smartgwt.client.widgets.form.validator.Validator</code> " +
            "and then use this SimpleType in various DataSourceField definitions across their application for use with any DataBoundComponent like a ListGrid, TreeGrid, DynamicForm etc.</p>" +
            "<p>This is a powerful feature allows creation and reuse of domain specific \"primitive\" data types or types in the enterprises Common Data Model (CDM)." +
            "<p>Enter a bad zip code (eg just \"123\") and press \"Validate\" to receive a validation error. Custom types can be declared based on built-in validators and re-used in multiple DataSources.</p>";

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
            TypeReuseSample panel = new TypeReuseSample();
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

    protected boolean isTopIntro() {
        return true;
    }

    public Canvas getViewPanel() {

        DataSource dataSource = new DataSource();

        DataSourceField zipCodeField = new DataSourceField();
        zipCodeField.setName("zipCode");
        zipCodeField.setTitle("Zip Code");
        zipCodeField.setType(new ZipCodeUSType());

        dataSource.setFields(zipCodeField);
        
        final DynamicForm boundForm = new DynamicForm();
        boundForm.setWidth(300);
        boundForm.setDataSource(dataSource);

        IButton button = new IButton("Validate");
        button.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                boundForm.validate();
            }
        });

        VLayout layout = new VLayout(10);
        layout.setMembers(boundForm, button);

        return layout;
    }

    public static class ZipCodeUSType extends SimpleType {
        public ZipCodeUSType() {
            super("zipCodeUS", FieldType.TEXT);

            RegExpValidator validator = new RegExpValidator("^\\d{5}(-\\d{4})?$");
            setValidators(validator);
        }
    }

    public String getIntro() {
        return DESCRIPTION;
    }
}