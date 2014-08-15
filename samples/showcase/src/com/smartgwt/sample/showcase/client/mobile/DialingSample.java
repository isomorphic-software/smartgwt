package com.smartgwt.sample.showcase.client.mobile;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.DataSourceTextField;
import com.smartgwt.client.types.FieldType;
import com.smartgwt.client.types.ListGridEditEvent;
import com.smartgwt.client.widgets.Button;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.VStack;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

public class DialingSample extends ShowcasePanel {
    private static final String DESCRIPTION = "When viewed on a mobile device, fields " +
            "declared as type \"phoneNumber\" will render as links that can actually be " +
            "clicked to make a phone call (if the device is capable of this). " +
            "<p> " +
            "For devices that use a software keyboard, editing a <code>\"phoneNumber\"</code>" +
            " field will bring up a specialized keyboard that only contains digits and other " +
            "valid phone number characters.";

    public static class Factory implements PanelFactory {
        private String id;

        public ShowcasePanel create() {
            DialingSample panel = new DialingSample();
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

        DataSource phoneContactsDS = PhoneContactsDS.getInstance();

        final ListGrid phoneContactsGrid = new ListGrid();
        phoneContactsGrid.setWidth(500);
        phoneContactsGrid.setHeight(224);
        phoneContactsGrid.setAlternateRecordStyles(true);
        phoneContactsGrid.setShowAllRecords(true);
        phoneContactsGrid.setAutoFetchData(true);
        phoneContactsGrid.setDataSource(phoneContactsDS);
        phoneContactsGrid.setCanEdit(Boolean.TRUE);
        phoneContactsGrid.setModalEditing(Boolean.TRUE);
        phoneContactsGrid.setEditEvent(ListGridEditEvent.CLICK);

        Button addContactButton = new Button("Add contact");
        addContactButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                phoneContactsGrid.startEditingNew();
            }
        });

        VStack layout = new VStack();
        layout.setMembersMargin(10);
        layout.setMembers(phoneContactsGrid, addContactButton);
        return layout;
    }

    private static class PhoneContactsDS extends DataSource {

        private static PhoneContactsDS instance = null;

        public static PhoneContactsDS getInstance() {
            if (instance == null) {
                instance = new PhoneContactsDS("phoneContacts");
            }
            return instance;
        }

        public PhoneContactsDS(String id) {
            setID(id);

            DataSourceTextField firstNameField = new DataSourceTextField("firstName");
            DataSourceTextField lastNameField = new DataSourceTextField("lastName");
            DataSourceTextField phoneNumberField = new DataSourceTextField("mobile", "Mobile number");
            phoneNumberField.setType(FieldType.PHONENUMBER);
            setFields(firstNameField, lastNameField, phoneNumberField);

            ListGridRecord testRecord = new ListGridRecord();
            testRecord.setAttribute("firstName", "Jenny");
            testRecord.setAttribute("lastName", "Burns");
            testRecord.setAttribute("mobile", "5558675309");
            ListGridRecord[] testData = new ListGridRecord[]{testRecord};
            setTestData(testData);
            setClientOnly(true);
        }
    }

    public String getIntro() {
        return DESCRIPTION;
    }
}