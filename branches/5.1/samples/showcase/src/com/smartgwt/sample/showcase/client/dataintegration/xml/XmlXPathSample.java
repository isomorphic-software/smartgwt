package com.smartgwt.sample.showcase.client.dataintegration.xml;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.DataSourceTextField;
import com.smartgwt.client.types.DSDataFormat;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

public class XmlXPathSample extends ShowcasePanel {
    private static final String DESCRIPTION = "<p>DataSources can extract field values from complex XML documents via XPath expressions. Note how the address " +
            "fields, which are represented in the contacts data as a subelement, appear as columns in the grid.</p>" +
            "<p>This approach of loading simple XML data over HTTP can be used with PHP and other server technologies.</p>";

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
            XmlXPathSample panel = new XmlXPathSample();
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
        dataSource.setDataFormat(DSDataFormat.XML);
        dataSource.setRecordXPath("//contact");
        dataSource.setDataURL("data/dataIntegration/xml/contactsData.xml");

        DataSourceTextField nameField = new DataSourceTextField("name", "Name");
        DataSourceTextField emailField = new DataSourceTextField("email", "Email");
        DataSourceTextField orgField = new DataSourceTextField("organization", "Organization");
        DataSourceTextField phoneField = new DataSourceTextField("phone", "Phone");

        DataSourceTextField streetField = new DataSourceTextField("street", "Street");
        streetField.setValueXPath("address/street");

        DataSourceTextField cityField = new DataSourceTextField("city", "City");
        cityField.setValueXPath("address/city");

        DataSourceTextField stateField = new DataSourceTextField("state", "State");
        stateField.setValueXPath("address/state");

        DataSourceTextField zipField = new DataSourceTextField("zip", "Zip");
        zipField.setValueXPath("address/zip");

        dataSource.setFields(nameField, emailField, orgField, phoneField, streetField,cityField, stateField, zipField);

        ListGrid grid = new ListGrid();
        grid.setDataSource(dataSource);
        grid.setWidth100();
        grid.setHeight(100);
        grid.setAutoFetchData(true);
        return grid;

    }

    public String getIntro() {
        return DESCRIPTION;
    }
}