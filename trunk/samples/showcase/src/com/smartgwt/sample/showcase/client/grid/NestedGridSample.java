package com.smartgwt.sample.showcase.client.grid;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.RecordDoubleClickEvent;
import com.smartgwt.client.widgets.grid.events.RecordDoubleClickHandler;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;
import com.smartgwt.sample.showcase.client.data.ItemSupplyXmlDS;
import com.smartgwt.sample.showcase.client.data.SupplyCategoryXmlDS;

public class NestedGridSample extends ShowcasePanel {
    
    private static final String DESCRIPTION =
            "<p>Select an entry in the grid below and click the 'Show Detail Grid' button to bring up the " +
                    "inline grid (you can also double-click a record).</p><p>Press the 'Hide Detail Grid' to dismiss the " +
                    "inline grid.</p>";

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
            NestedGridSample panel = new NestedGridSample();
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

    private ListGridRecord lastOpenedRecord;

    public Canvas getViewPanel() {

        VLayout layout = new VLayout(20);

        final ItemSupplyXmlDS itemSupplyXmlDS = ItemSupplyXmlDS.getInstance();

        final ListGrid categoryGrid = new ListGrid();
        categoryGrid.setWidth(600);
        categoryGrid.setHeight(400);
        categoryGrid.setDataSource(SupplyCategoryXmlDS.getInstance());

        categoryGrid.addRecordDoubleClickHandler(new RecordDoubleClickHandler() {
            public void onRecordDoubleClick(RecordDoubleClickEvent event) {
                showDetailGrid(categoryGrid, itemSupplyXmlDS);
            }
        });

        categoryGrid.fetchData();
        layout.addMember(categoryGrid);

        IButton showDetail = new IButton("Show Detail Grid");
        showDetail.setWidth(140);
        showDetail.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                showDetailGrid(categoryGrid, itemSupplyXmlDS);
            }
        });

        layout.addMember(showDetail);

        IButton hideDetail = new IButton("Hide Detail Grid");
        hideDetail.setWidth(140);
        hideDetail.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                if (lastOpenedRecord != null) {
                    categoryGrid.closeRecord(lastOpenedRecord);
                    lastOpenedRecord = null;
                }
            }
        });

        layout.addMember(hideDetail);
        return layout;
    }

    private void showDetailGrid(ListGrid categoryGrid, DataSource itemSupplyXmlDS) {
        ListGridRecord record = categoryGrid.getSelectedRecord();
        if (record != null) {
            categoryGrid.openRecordDetailGrid(record, itemSupplyXmlDS);
            lastOpenedRecord = record;
        }
    }

    public String getIntro() {
        return DESCRIPTION;
    }
}