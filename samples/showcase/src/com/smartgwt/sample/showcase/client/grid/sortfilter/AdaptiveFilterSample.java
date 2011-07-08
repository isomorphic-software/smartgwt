package com.smartgwt.sample.showcase.client.grid.sortfilter;

import com.google.gwt.user.client.Timer;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;
import com.smartgwt.sample.showcase.client.data.ItemSupplyXmlDS;

public class AdaptiveFilterSample extends ShowcasePanel {

    private static final String DESCRIPTION = "<p>Smart GWT combines large dataset handling with adaptive use of client-side filtering.</p>" +
            "<p>Begin typing an Item name in the filter box above the \"Item\" column (for example type \"Pens\") . When the dataset becomes small enough, Smart GWT switches to client-side filtering automatically.</p>" +
            "<p>Delete part of the item name to see SmartClient automatically switch back to server-side filtering. " +
            "The label underneath the grid flashes briefly every time Smart GWT needs to visit the server.</p>";

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
            AdaptiveFilterSample panel = new AdaptiveFilterSample();
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
        supplyItemGrid.setAutoFetchData(true);
        supplyItemGrid.setShowFilterEditor(true);
        supplyItemGrid.setFilterOnKeypress(true);
        supplyItemGrid.setFetchDelay(500);
        supplyItemGrid.setDataSource(supplyXmlDS);

        ListGridField skuField = new ListGridField("SKU", 100);
        ListGridField nameField = new ListGridField("itemName", 150);
        ListGridField descriptionField = new ListGridField("description", 250);
        ListGridField categoryField = new ListGridField("category", 100);

        supplyItemGrid.setFields(skuField, nameField, descriptionField, categoryField );
                
        canvas.addChild(supplyItemGrid);
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
        setTop(320);
        setPadding(10);
        setWidth(500);
        setHeight(30);
        setBorder("1px solid #6a6a6a");
        }

        public void incrementAndUpdate(int totalRows, int startRow, int endRow) {
            count++;
            setContents("<b>Number of server trips: " + count +
                    "<br/>Total rows in this filter set: " + totalRows +
                    "<br/>Last range of records returned: " + startRow + " to " + endRow + "</b>");
        }
    }
}