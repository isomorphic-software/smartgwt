package com.smartgwt.sample.showcase.client.dataintegration.xml;

import com.google.gwt.core.client.JavaScriptObject;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.XMLTools;
import com.smartgwt.client.data.fields.DataSourcePasswordField;
import com.smartgwt.client.data.fields.DataSourceTextField;
import com.smartgwt.client.rpc.RPCResponse;
import com.smartgwt.client.types.DSDataFormat;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.HeaderItem;
import com.smartgwt.client.widgets.form.fields.PasswordItem;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

public class FormServerXmlValidationSample extends ShowcasePanel {
    private static final String DESCRIPTION = "<p>Click \"Save\" to see validation errors derived from an XML response. Validation errors " +
            "expressed in application-specific XML formats can be communicated to visual components by implementing DataSource.setResponseTransformHandler(). " +
            "The resulting validation errors will be displayed and tracked by forms and editabled grids.</p>";

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
            FormServerXmlValidationSample panel = new FormServerXmlValidationSample();
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

        DataSource dataSource = new DataSource() {
            @Override
            protected void transformResponse(DSResponse response, DSRequest request, Object xmlData) {
                String status = XMLTools.selectString(xmlData, "/response/status");
                if(!status.equals("success")) {
                    response.setStatus(RPCResponse.STATUS_VALIDATION_ERROR);
                    Object errors = XMLTools.selectNodes(xmlData, "/response/errors");
                    JavaScriptObject errorsJS = XMLTools.toJS(errors);
                    response.setErrors(errorsJS);
                }
            }
        };
        dataSource.setDataFormat(DSDataFormat.XML);
        dataSource.setDataURL("data/dataIntegration/xml/serverValidationErrors/serverResponse.xml");
        DataSourceTextField userNameField = new DataSourceTextField("userName", "Username", 50, true);
        DataSourceTextField firstNameField = new DataSourceTextField("firstName", "First Name", 50, true);
        DataSourceTextField lastNameField = new DataSourceTextField("lastName", "Last Name", 50, true);
        DataSourceTextField emailField = new DataSourceTextField("email", "Email", 100, true);

        DataSourcePasswordField passwordField = new DataSourcePasswordField("password", "Password", 20, true);

        dataSource.setFields(userNameField, firstNameField, lastNameField, emailField, passwordField);


        final DynamicForm form = new DynamicForm();
        form.setDataSource(dataSource);
        form.setUseAllDataSourceFields(true);

        HeaderItem header = new HeaderItem();
        header.setDefaultValue("Registration Form");

        PasswordItem passwordItem = new PasswordItem();
        passwordItem.setName("password");


        IButton saveButton = new IButton("Save");
        saveButton.addClickHandler(new ClickHandler() {
            public void onClick(com.smartgwt.client.widgets.events.ClickEvent event) {
                if(form.validate()) {
                    form.saveData();
                }
            }
        });
        
        form.setFields(header, passwordItem);

        form.setValue("userName", "bsmith");
        form.setValue("firstName", "Bob");
        form.setValue("lastName", "Smith");
        form.setValue("email", "bob@.com");
        form.setValue("password", "sekrit");

        VLayout layout = new VLayout(10);
        layout.addMember(form);
        layout.addMember(saveButton);
        return layout;
    }

    public String getIntro() {
        return DESCRIPTION;
    }
}