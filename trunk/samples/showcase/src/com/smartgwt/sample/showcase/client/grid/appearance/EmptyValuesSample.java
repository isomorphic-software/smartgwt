package com.smartgwt.sample.showcase.client.grid.appearance;

import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;
import com.smartgwt.sample.showcase.client.data.CountrySampleData;

public class EmptyValuesSample extends ShowcasePanel {
    private static final String DESCRIPTION = "Double-click any cell, delete its value, and press Enter or click outside the cell to save and display" +
            " the empty value. This grid shows \"--\" for empty date values, and \"unknown\" for other empty values.";

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
            EmptyValuesSample panel = new EmptyValuesSample();
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

        final ListGrid countryGrid = new ListGrid();
        countryGrid.setWidth(500);
        countryGrid.setHeight(224);
        countryGrid.setShowAllRecords(true);
        countryGrid.setCanEdit(true);
        countryGrid.setEditByCell(true);
        countryGrid.setModalEditing(true);
        countryGrid.setEmptyCellValue("unknown");

        ListGridField countryCodeField = new ListGridField("countryCode", "Flag", 40);
        countryCodeField.setAlign(Alignment.CENTER);
        countryCodeField.setType(ListGridFieldType.IMAGE);
        countryCodeField.setImageURLPrefix("flags/16/");
        countryCodeField.setImageURLSuffix(".png");

        ListGridField nameField = new ListGridField("countryName", "Country");
        ListGridField capitalField = new ListGridField("capital", "Capital");
        ListGridField nationHoodField = new ListGridField("independence", "Nationhood");
        nationHoodField.setType(ListGridFieldType.DATE);
        nationHoodField.setEmptyCellValue("--");

        countryGrid.setFields(countryCodeField, nameField, capitalField, nationHoodField);
        countryGrid.setCanResizeFields(true);
        countryGrid.setData(CountrySampleData.getRecords());

        return countryGrid;
    }

    public String getIntro() {
        return DESCRIPTION;
    }

}