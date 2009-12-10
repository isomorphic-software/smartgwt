package com.smartgwt.sample.showcase.client.grid.datatypes;

import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.ListGridEditEvent;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;
import com.smartgwt.sample.showcase.client.data.CountryData;

public class GridDataTypesListSample extends ShowcasePanel {
    private static final String DESCRIPTION = "Click on column headers to sort, or data values to edit. \"Continent\" is a list (aka valueMapped) field.";

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
            GridDataTypesListSample panel = new GridDataTypesListSample();
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

        final ListGrid countryGrid = new ListGrid();
        countryGrid.setWidth(500);
        countryGrid.setHeight(224);
        countryGrid.setShowAllRecords(true);
        countryGrid.setCanEdit(true);
        countryGrid.setEditEvent(ListGridEditEvent.CLICK);
        countryGrid.setModalEditing(true);

        ListGridField countryCodeField = new ListGridField("countryCode", "Flag", 50);
        countryCodeField.setAlign(Alignment.CENTER);
        countryCodeField.setType(ListGridFieldType.IMAGE);
        countryCodeField.setImageURLPrefix("flags/16/");
        countryCodeField.setImageURLSuffix(".png");
        countryCodeField.setCanEdit(false);
        ListGridField nameField = new ListGridField("countryName", "Country");
        ListGridField continentField = new ListGridField("continent", "Continent");
        continentField.setValueMap("Europe", "Asia", "North America", "Australia/Oceania", "South America", "Africa");

        countryGrid.setFields(new ListGridField[] {countryCodeField, nameField, continentField});
        countryGrid.setData(CountryData.getRecords());
        canvas.addChild(countryGrid);

        return canvas;
    }

    public String getIntro() {
        return DESCRIPTION;
    }

}