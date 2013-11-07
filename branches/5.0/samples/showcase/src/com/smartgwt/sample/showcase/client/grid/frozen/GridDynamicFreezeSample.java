package com.smartgwt.sample.showcase.client.grid.frozen;

import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;
import com.smartgwt.sample.showcase.client.data.ItemSupplyXmlDS;

public class GridDynamicFreezeSample extends ShowcasePanel {
    private static final String DESCRIPTION = "<p>Right click on any column header to show a menu that allows you to freeze that column." +
            "Multiple columns may be frozen, and frozen columns may be reordered.</p><p>" +
            "Right click on a frozen column to unfreeze it.</p>";

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
            GridDynamicFreezeSample panel = new GridDynamicFreezeSample();
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
        supplyItemGrid.setAutoFetchData(true);
        supplyItemGrid.setCanFreezeFields(true);

        ListGridField nameField = new ListGridField("itemName", 150);
        ListGridField categoryField = new ListGridField("category", 100);
        ListGridField skuField = new ListGridField("SKU", 100);
        ListGridField unitsField = new ListGridField("units", 80);
        ListGridField descriptionField = new ListGridField("description", 250);

        supplyItemGrid.setFields(nameField, categoryField, skuField, unitsField, descriptionField);

        return supplyItemGrid;
    }


    public String getIntro() {
        return DESCRIPTION;
    }


}