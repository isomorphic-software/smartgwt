package com.smartgwt.sample.showcase.client.grid.autofit;

import com.smartgwt.client.types.Autofit;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;
import com.smartgwt.sample.showcase.client.data.WorldXmlDS;

public class AutofitFilterSample extends ShowcasePanel {
    private static final String DESCRIPTION = "<p>Change the filter to show the grid resizing within the constraint of its " +
            "maximum autofit rows.</p><p>Enter a country filter of \"cook island\" to see the grid shrink down to minimum size. " +
            "</p><p>Change the country filter to \"island\" to show the grid at almost maximum size, but not scrolling." +
            "</p><p>Change the country filter to \"land\" to show the grid scrolling because its maximum autofit size (10)" +
            " isn't large enough to display all rows.</p>";

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
            AutofitFilterSample panel = new AutofitFilterSample();
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
        countryGrid.setTop(50);

        countryGrid.setAutoFitData(Autofit.VERTICAL);
        countryGrid.setShowFilterEditor(true);
        countryGrid.setAutoFitMaxRecords(10);
        countryGrid.setDataSource(WorldXmlDS.getInstance());
        countryGrid.setAutoFetchData(true);

        ListGridField nameField = new ListGridField("countryName", "Country");
        ListGridField capitalField = new ListGridField("capital", "Capital");
        ListGridField continentField = new ListGridField("continent", "Continent");
        countryGrid.setFields(nameField, capitalField, continentField);

        canvas.addChild(countryGrid);
        return canvas;
    }


    public String getIntro() {
        return DESCRIPTION;
    }
}