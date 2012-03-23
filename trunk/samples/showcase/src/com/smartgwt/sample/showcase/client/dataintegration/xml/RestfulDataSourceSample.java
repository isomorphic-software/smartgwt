package com.smartgwt.sample.showcase.client.dataintegration.xml;

import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.OperationBinding;
import com.smartgwt.client.data.RestDataSource;
import com.smartgwt.client.data.fields.DataSourceTextField;
import com.smartgwt.client.types.ContentsType;
import com.smartgwt.client.types.DSOperationType;
import com.smartgwt.client.types.DSProtocol;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.HTMLPane;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.tab.Tab;
import com.smartgwt.client.widgets.tab.TabSet;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;
import com.smartgwt.sample.showcase.client.data.CountryRecord;

public class RestfulDataSourceSample extends ShowcasePanel {

    private static final String DESCRIPTION = "<p>The RestDataSource provides a simple protocol based on XML or JSON over HTTP.</p>" +
            "<p>This protocol can be implemented with any server technology (PHP, Ruby, ..) and includes all the features of Smart GWT's databinding " +
            "layer (data paging, server validation errors, cache sync, etc).</p>" +
            "<p>In this example, each DataSource operation is directed to a different XML file containing a sample response for that operationType. " +
            "The server returns the data-as-saved to allow the grid to update its cache.</p>";

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
            RestfulDataSourceSample panel = new RestfulDataSourceSample();
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

        VLayout layout = new VLayout(15);
        layout.setAutoHeight();

        //overrides here are for illustration purposes only 
        RestDataSource countryDS = new RestDataSource() {
            @Override
            protected Object transformRequest(DSRequest dsRequest) {
                return super.transformRequest(dsRequest);
            }
            @Override
            protected void transformResponse(DSResponse response, DSRequest request, Object data) {
                super.transformResponse(response, request, data);
            }
        };
        // These lines are not required for this sample to work, but they demonstrate how you can configure RestDataSource 
        // with OperationBindings in order to control settings such as whether to use the GET, POST or PUT HTTP methods,
        // and whether to send data as URL parameters vs as posted JSON or XML messages.
        DataSourceTextField countryCode = new DataSourceTextField("countryCode", "Code");
        OperationBinding fetch = new OperationBinding();
        fetch.setOperationType(DSOperationType.FETCH);
        fetch.setDataProtocol(DSProtocol.POSTMESSAGE);
        OperationBinding add = new OperationBinding();
        add.setOperationType(DSOperationType.ADD);
        add.setDataProtocol(DSProtocol.POSTMESSAGE);
        OperationBinding update = new OperationBinding();
        update.setOperationType(DSOperationType.UPDATE);
        update.setDataProtocol(DSProtocol.POSTMESSAGE);
        OperationBinding remove = new OperationBinding();
        remove.setOperationType(DSOperationType.REMOVE);
        remove.setDataProtocol(DSProtocol.POSTMESSAGE);
        countryDS.setOperationBindings(fetch, add, update, remove);


        countryCode.setPrimaryKey(true);
        countryCode.setCanEdit(false);

        DataSourceTextField countryName = new DataSourceTextField("countryName", "Country");
        DataSourceTextField capital = new DataSourceTextField("capital", "Capital");
        countryDS.setFields(countryCode, countryName, capital);
        countryDS.setFetchDataURL("data/dataIntegration/xml/responses/country_fetch_rest.xml");
        countryDS.setAddDataURL("data/dataIntegration/xml/responses/country_add_rest.xml");
        countryDS.setUpdateDataURL("data/dataIntegration/xml/responses/country_update_rest.xml");
        countryDS.setRemoveDataURL("data/dataIntegration/xml/responses/country_remove_rest.xml");

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

        layout.addMember(countryGrid);

        HLayout hLayout = new HLayout(15);

        final IButton addButton = new IButton("Add new Country");
        addButton.setWidth(150);
        addButton.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                countryGrid.addData(new CountryRecord("A1", "New Value", "New Value", "New Value"));
                addButton.disable();
            }
        });
        hLayout.addMember(addButton);

        final IButton updateButton = new IButton("Update Country (US)");
        updateButton.setWidth(150);
        updateButton.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                countryGrid.updateData(new CountryRecord("US", "Edited Value", "Edited Value", "Edited Value"));
                updateButton.disable();
            }
        });
        hLayout.addMember(updateButton);

        final IButton removeButton = new IButton("Remove Country (UK)");
        removeButton.setWidth(150);
        removeButton.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                CountryRecord record = new CountryRecord();
                record.setCountryCode("UK");
                countryGrid.removeData(record);
                removeButton.disable();
            }
        });
        hLayout.addMember(removeButton);

        layout.addMember(hLayout);

        TabSet tabSet = new TabSet();
        tabSet.setHeight(400);
        tabSet.setWidth(500);
        Tab fetchTab = new Tab("country_fetch.xml");
        final HTMLPane fetchPane = new HTMLPane();
        fetchPane.setContentsURL("source/rest/country_fetch_rest.xml.html");
        fetchPane.setContentsType(ContentsType.PAGE);
        fetchTab.setPane(fetchPane);

        Tab addTab = new Tab("country_add.xml");
        final HTMLPane addPane = new HTMLPane();
        addPane.setContentsURL("source/rest/country_add_rest.xml.html");
        addPane.setContentsType(ContentsType.PAGE);
        addTab.setPane(addPane);

        Tab updateTab = new Tab("country_update.xml");
        final HTMLPane updatePane = new HTMLPane();
        updatePane.setContentsURL("source/rest/country_update_rest.xml.html");
        updatePane.setContentsType(ContentsType.PAGE);
        updateTab.setPane(updatePane);

        Tab removeTab = new Tab("country_remove.xml");
        final HTMLPane removePane = new HTMLPane();
        removePane.setContentsURL("source/rest/country_remove_rest.xml.html");
        removePane.setContentsType(ContentsType.PAGE);
        removeTab.setPane(removePane);

        tabSet.setTabs(fetchTab, addTab, updateTab, removeTab);
        layout.addMember(tabSet);

        return layout;
    }

    public String getIntro() {
        return DESCRIPTION;
    }
}