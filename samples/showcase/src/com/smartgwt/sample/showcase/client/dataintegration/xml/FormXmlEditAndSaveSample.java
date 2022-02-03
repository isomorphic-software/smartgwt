package com.smartgwt.sample.showcase.client.dataintegration.xml;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.OperationBinding;
import com.smartgwt.client.data.fields.DataSourceTextField;
import com.smartgwt.client.types.DSOperationType;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

public class FormXmlEditAndSaveSample extends ShowcasePanel {

    private static final String DESCRIPTION = "<p>Demonstrates Add, Update and Remove operations with a server that returns simple XML responses, " +
            "an integration strategy popular with PHP, Ruby and Perl backends.</p" +
            "<p>Each operation is directed to a different XML file containing a sample response for that operationType. " +
            "The server returns the data-as-saved to allow the grid to update its cache.</p>";

    public static class Factory implements PanelFactory {
        private String id;

        public ShowcasePanel create() {
            FormXmlEditAndSaveSample panel = new FormXmlEditAndSaveSample();
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

    public ListGridRecord createRecord(String countryCode, String countryName, String capital, String continent) {
        ListGridRecord record = new ListGridRecord();
    	record.setAttribute("continent", continent);
    	record.setAttribute("countryName", countryName);
    	record.setAttribute("countryCode", countryCode);
    	record.setAttribute("capital", capital);
        return record;
    }

    public Canvas getViewPanel() {

        Canvas canvas = new Canvas();

        DataSource countryDS = new DataSource();
        countryDS.setClientOnly(true);
        DataSourceTextField countryCode = new DataSourceTextField("countryCode", "Code");
        countryCode.setPrimaryKey(true);
        countryCode.setCanEdit(false);

        DataSourceTextField countryName = new DataSourceTextField("countryName", "Country");
        DataSourceTextField capital = new DataSourceTextField("capital", "Capital");
        countryDS.setFields(countryCode, countryName, capital);

        countryDS.setOperationBindings();

        OperationBinding fetch = new OperationBinding(DSOperationType.FETCH, "data/dataIntegration/xml/responses/country_fetch.xml");
        OperationBinding add = new OperationBinding(DSOperationType.ADD, "data/dataIntegration/xml/responses/country_add.xml");
        OperationBinding update = new OperationBinding(DSOperationType.UPDATE, "data/dataIntegration/xml/responses/country_update.xml");
        OperationBinding remove = new OperationBinding(DSOperationType.REMOVE, "data/dataIntegration/xml/responses/country_remove.xml");

        countryDS.setOperationBindings(fetch, add, update, remove);

        final ListGrid countryGrid = new ListGrid();
        countryGrid.setWidth(500);
        countryGrid.setHeight(224);
        countryGrid.setDataSource(countryDS);
        countryGrid.setEmptyCellValue("--");


        ListGridField codeField = new ListGridField("countryCode");
        ListGridField nameField = new ListGridField("countryName");
        ListGridField capitalField = new ListGridField("capital");
        ListGridField continentField = new ListGridField("continent", "Continent");
        countryGrid.setFields(codeField, nameField, capitalField, continentField);
        countryGrid.setSortField(0);
        countryGrid.setDataPageSize(50);
        countryGrid.setAutoFetchData(true);

        canvas.addChild(countryGrid);

        final IButton addButton = new IButton("Add new Country");
        addButton.setLeft(0);
        addButton.setTop(240);
        addButton.setWidth(150);
        addButton.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                countryGrid.addData(createRecord("A1", "New Value", "New Value", "New Value"));
                addButton.disable();
            }
        });
        canvas.addChild(addButton);

        final IButton updateButton = new IButton("Update Country (US)");
        updateButton.setLeft(175);
        updateButton.setTop(240);
        updateButton.setWidth(150);
        updateButton.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                countryGrid.updateData(createRecord("US", "Edited Value", "Edited Value", "Edited Value"));
                updateButton.disable();
            }
        });
        canvas.addChild(updateButton);

        final IButton removeButton = new IButton("Remove Country (UK)");
        removeButton.setLeft(350);
        removeButton.setTop(240);
        removeButton.setWidth(150);
        removeButton.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                ListGridRecord record = new ListGridRecord();
                record.setAttribute("countryCode", "UK");
                countryGrid.removeData(record);
                removeButton.disable();
            }
        });
        canvas.addChild(removeButton);

        return canvas;
    }


    public String getIntro() {
        return DESCRIPTION;
    }

}