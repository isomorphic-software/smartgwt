package com.smartgwt.sample.showcase.client.grid;

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

public class NestedFormSample extends ShowcasePanel {

    private static final String DESCRIPTION =
            "<p>Select an entry in the grid below and click the 'Show Embedded Form' button to bring up the inline form " +
                    "(you can also double-click a record).</p>" +
                    "<p>Press the 'Cancel' button on the form or the 'Hide Embedded Form' button to dismiss the inline form. Note that this feature is experimental.</p>";

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
            NestedFormSample panel = new NestedFormSample();
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

        final ListGrid itemGrid = new ListGrid();
        itemGrid.setWidth(600);
        itemGrid.setHeight(400);
        itemGrid.setDataSource(itemSupplyXmlDS);
        itemGrid.setAlternateRecordStyles(true);
        itemGrid.setUseAllDataSourceFields(true);

        itemGrid.addRecordDoubleClickHandler(new RecordDoubleClickHandler() {
            public void onRecordDoubleClick(RecordDoubleClickEvent event) {
                showFormEditor(itemGrid);
            }
        });

        itemGrid.fetchData();
        layout.addMember(itemGrid);

        IButton showDetail = new IButton("Show Embedded Form");
        showDetail.setWidth(140);
        showDetail.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                showFormEditor(itemGrid);
            }
        });

        layout.addMember(showDetail);

        IButton hideDetail = new IButton("Hide Embedded Form");
        hideDetail.setWidth(140);
        hideDetail.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                if (lastOpenedRecord != null) {
                    itemGrid.closeRecord(lastOpenedRecord);
                    lastOpenedRecord = null;
                }
            }
        });

        layout.addMember(hideDetail);
        return layout;
    }

    private void showFormEditor(ListGrid itemGrid) {
        ListGridRecord record = itemGrid.getSelectedRecord();
        if (record != null) {
            itemGrid.openRecordEditor(record);
            lastOpenedRecord = record;
        }
    }

    public String getIntro() {
        return DESCRIPTION;
    }
}