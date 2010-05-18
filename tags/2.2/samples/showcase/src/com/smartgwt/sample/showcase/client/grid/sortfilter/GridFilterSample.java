package com.smartgwt.sample.showcase.client.grid.sortfilter;

import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;
import com.smartgwt.sample.showcase.client.data.WorldXmlDS;

public class GridFilterSample extends ShowcasePanel {
    private static final String DESCRIPTION = "<p>Type \"island\" above the Country column, then press Enter or click the filter button (top-right corner " +
            "of the grid) to show only countries with \"island\" in their name.</p><p>Select \"North America\" above the " +
            "Continent column to filter countries by that continent.<p>";

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
            GridFilterSample panel = new GridFilterSample();
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
        countryGrid.setDataSource(WorldXmlDS.getInstance());

        ListGridField countryCodeField = new ListGridField("countryCode", "Code", 50);
        ListGridField nameField = new ListGridField("countryName", "Country");
        ListGridField capitalField = new ListGridField("capital", "Capital");
        ListGridField continentField = new ListGridField("continent", "Continent");

        countryGrid.setFields(countryCodeField, nameField, capitalField, continentField);

        countryGrid.setAutoFetchData(true);
        countryGrid.setShowFilterEditor(true);

        return countryGrid;
    }

    public String getIntro() {
        return DESCRIPTION;
    }
}