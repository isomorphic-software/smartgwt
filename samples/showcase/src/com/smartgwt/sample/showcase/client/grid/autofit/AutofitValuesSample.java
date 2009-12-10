package com.smartgwt.sample.showcase.client.grid.autofit;

import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;
import com.smartgwt.sample.showcase.client.data.CountryData;

public class AutofitValuesSample extends ShowcasePanel {
    private static final String DESCRIPTION = "Click and drag between the \"Background\" and \"Flag\" column headers, or resize your browser window to" +
            " change the size of the entire grid. The rows resize to fit the \"Background\" values.";

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
            AutofitValuesSample panel = new AutofitValuesSample();
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

        ListGrid countryGrid = new ListGrid();
        countryGrid.setWidth100();
        countryGrid.setHeight100();
        countryGrid.setShowAllRecords(true);
        countryGrid.setWrapCells(true);
        countryGrid.setFixedRecordHeights(false);

        ListGridField nameField = new ListGridField("countryName", "Country", 120);
        ListGridField backgroundField = new ListGridField("background", "Background");
        ListGridField countryCodeField = new ListGridField("countryCode", "Flag", 50);
        countryCodeField.setAlign(Alignment.CENTER);
        countryCodeField.setType(ListGridFieldType.IMAGE);
        countryCodeField.setImageSize(24);
        countryCodeField.setImageURLPrefix("flags/24/");
        countryCodeField.setImageURLSuffix(".png");

        countryGrid.setFields(nameField, backgroundField, countryCodeField);

        countryGrid.setData(CountryData.getRecords());
        return countryGrid;
    }

    public String getIntro() {
        return DESCRIPTION;
    }

}