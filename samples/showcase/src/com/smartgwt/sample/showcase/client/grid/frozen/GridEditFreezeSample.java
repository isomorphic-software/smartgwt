package com.smartgwt.sample.showcase.client.grid.frozen;

import com.smartgwt.client.data.Criteria;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;
import com.smartgwt.sample.showcase.client.data.ItemSupplyXmlDS;

public class GridEditFreezeSample extends ShowcasePanel {
    private static final String DESCRIPTION = "Smart GWT's inline editing support works normally with frozen columns with no further configuration.";

    public static class Factory implements PanelFactory {
        private String id;

        public ShowcasePanel create() {
            GridEditFreezeSample panel = new GridEditFreezeSample();
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

        final ListGrid supplyItemGrid = new ListGrid();
        supplyItemGrid.setWidth(500);
        supplyItemGrid.setHeight(224);
        supplyItemGrid.setDataSource(ItemSupplyXmlDS.getInstance());
        supplyItemGrid.setCanEdit(true);
        supplyItemGrid.setCanFreezeFields(true);

        ListGridField nameField = new ListGridField("itemName", 150);
        nameField.setFrozen(true);

        ListGridField categoryField = new ListGridField("category", 100);
        ListGridField skuField = new ListGridField("SKU", 100);
        ListGridField unitsField = new ListGridField("units", 80);
        ListGridField descriptionField = new ListGridField("description", 250);

        supplyItemGrid.setFields(nameField, categoryField, skuField, unitsField, descriptionField);

        supplyItemGrid.fetchData(new Criteria(), new DSCallback() {

            public void execute(DSResponse response, Object rawData, DSRequest request) {
                supplyItemGrid.startEditing(0, 0, false);
            }
        });
        return supplyItemGrid;
    }

    public String getIntro() {
        return DESCRIPTION;
    }
}