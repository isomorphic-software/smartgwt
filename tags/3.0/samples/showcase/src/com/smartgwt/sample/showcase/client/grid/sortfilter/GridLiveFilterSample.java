package com.smartgwt.sample.showcase.client.grid.sortfilter;

import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;
import com.smartgwt.sample.showcase.client.data.WorldXmlDS;

public class GridLiveFilterSample extends ShowcasePanel {
    private static final String DESCRIPTION = "<p>Begin typing a country name into in the filter box for the Country column. " +
            "Grids can be configured to filter as you type..</p>";

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
            GridLiveFilterSample panel = new GridLiveFilterSample();
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
        countryGrid.setHeight(300);
        countryGrid.setShowFilterEditor(true);
        countryGrid.setFilterOnKeypress(true);
        countryGrid.setDataSource(WorldXmlDS.getInstance());
        countryGrid.setAutoFetchData(true);

        ListGridField countryCodeField = new ListGridField("countryCode", "Code", 50);
        ListGridField nameField = new ListGridField("countryName", "Country");
        ListGridField capitalField = new ListGridField("capital", "Capital");
        ListGridField continentField = new ListGridField("continent", "Continent");
        countryGrid.setFields(countryCodeField, nameField, capitalField, continentField);

        return countryGrid;
    }

    public String getIntro() {
        return DESCRIPTION;
    }
}