package com.smartgwt.sample.showcase.client.grid.sortfilter;

import com.google.gwt.user.client.Timer;
import com.smartgwt.client.data.Criteria;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.DSOperationType;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.CheckboxItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;
import com.smartgwt.sample.showcase.client.data.ItemSupplyXmlDS;

public class AdaptiveSortSample extends ShowcasePanel {

    private static final String DESCRIPTION = "<p>Smart GWT combines large dataset handling with adaptive use of client-side sort.</p>" +
            "<p>Click any header now and server-side sort will be used for this large dataset. Check \"Limit to Dictionaries\" to limit the " +
            "dataset and sort again: when the dataset becomes small enough, Smart GWT switches to client-side sorting automatically.</p>" +
            "<p>The label underneath the grid flashes briefly every time Smart GWT needs to visit the server.</p>";

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
            AdaptiveSortSample panel = new AdaptiveSortSample();
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

        Canvas canvas = new Canvas();

        final ServerCountLabel serverCountLabel = new ServerCountLabel();

        ItemSupplyXmlDS supplyXmlDS = new ItemSupplyXmlDS(SC.generateID()) {

            //this approach logs simulated server trips for DataSources with clientOnly:true
            //so that no server is required. Since this example has a clientOnly datasource that loads data
            //from a static xml, use the simulated server trips getClientOnlyResponse override point.
            //If working with a real server that returns data dynamically based on start/end row, override
            //transformResponse instead.

            @Override
            public DSResponse getClientOnlyResponse(DSRequest request, Record[] serverData) {
                DSResponse response = super.getClientOnlyResponse(request, serverData);
                if(request.getOperationType() == DSOperationType.FETCH)  {}
                int totalRows = response.getTotalRows();
                int startRow = response.getStartRow();
                int endRow = response.getEndRow();
                serverCountLabel.incrementAndUpdate(totalRows, startRow, endRow);
                serverCountLabel.setBackgroundColor("ffff77");
                new Timer() {
                    public void run() {
                        serverCountLabel.setBackgroundColor("ffffff");
                    }
                }.schedule(500);

                return response;
            }
        };

        //when working with a server that dynamically returns the response based on start row, end row,
        //use can override transformResponse instead of getClientOnlyResponse
        /*
        @Override 
        protected void transformResponse(DSResponse response, DSRequest request, Object data) {
            int totalRows = response.getTotalRows();
            int startRow = response.getStartRow();
            int endRow = response.getEndRow();
            serverCountLabel.incrementAndUpdate(totalRows, startRow, endRow);
            serverCountLabel.setBackgroundColor("ffff77");
            new Timer() {
                public void run() {
                    serverCountLabel.setBackgroundColor("ffffff");
                }
            }.schedule(500);
        }*/


        final ListGrid supplyItemGrid = new ListGrid();
        supplyItemGrid.setWidth(500);
        supplyItemGrid.setHeight(300);
        supplyItemGrid.setDataSource(supplyXmlDS);
        supplyItemGrid.setAutoFetchData(true);
        supplyItemGrid.setDataPageSize(20);

        ListGridField skuField = new ListGridField("SKU", 100);
        ListGridField nameField = new ListGridField("itemName", 150);
        ListGridField descriptionField = new ListGridField("description", 250);
        ListGridField categoryField = new ListGridField("category", 100);

        supplyItemGrid.setFields(skuField, nameField, descriptionField, categoryField);

        DynamicForm sortForm = new DynamicForm();
        sortForm.setWidth(300);
        sortForm.setTop(310);

        final CheckboxItem restrictItem = new CheckboxItem();
        restrictItem.setName("restrict");
        restrictItem.setTitle("Limit to Dictionaries");
        restrictItem.addChangedHandler(new ChangedHandler() {
            public void onChanged(ChangedEvent event) {
                Criteria criteria = new Criteria();
                Object value = restrictItem.getValue();
                boolean filter = value != null && (Boolean) value;
                if (filter) {
                    criteria.addCriteria("category", "Dictionaries");
                }
                supplyItemGrid.fetchData(criteria);
            }
        });
        sortForm.setFields(restrictItem);

        canvas.addChild(supplyItemGrid);
        canvas.addChild(sortForm);
        canvas.addChild(serverCountLabel);

        return canvas;
    }


    public String getIntro() {
        return DESCRIPTION;
    }

    class ServerCountLabel extends Label {
        private int count = 0;

        ServerCountLabel() {
            setContents("<b>Number of server trips : 0</b>");
            setTop(350);
            setPadding(10);
            setWidth(500);
            setHeight(30);
            setBorder("1px solid #6a6a6a");
        }

        public void incrementAndUpdate(int totalRows, int startRow, int endRow) {
            count++;
            setContents("<b>Number of server trips: " + count + "</b>");
        }
    }
}