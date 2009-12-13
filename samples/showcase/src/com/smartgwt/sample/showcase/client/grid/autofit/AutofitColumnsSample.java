package com.smartgwt.sample.showcase.client.grid.autofit;

import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.Autofit;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;
import com.smartgwt.sample.showcase.client.data.CountryData;

public class AutofitColumnsSample extends ShowcasePanel {
    private static final String DESCRIPTION = "Click and drag between the column headers to resize the columns. The grid " +
            "resizes to fit the new column widths. The width setting on the grid as a whole acts as a minimum.";

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
            AutofitColumnsSample panel = new AutofitColumnsSample();
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

        final ListGrid countryGrid = new ListGrid() ;

        countryGrid.setWidth(100);
        countryGrid.setHeight(224);
        countryGrid.setShowAllRecords(true);
        countryGrid.setAutoFitData(Autofit.HORIZONTAL);

        ListGridField countryCodeField = new ListGridField("countryCode", "Flag", 50);
        countryCodeField.setAlign(Alignment.CENTER);
        countryCodeField.setType(ListGridFieldType.IMAGE);
        countryCodeField.setImageURLPrefix("flags/16/");
        countryCodeField.setImageURLSuffix(".png");

        ListGridField nameField = new ListGridField("countryName", "Country", 100);
        ListGridField capitalField = new ListGridField("capital", "Capital", 100);
        ListGridField continentField = new ListGridField("continent", "Continent", 100);
        countryGrid.setFields(countryCodeField, nameField, capitalField, continentField);

        countryGrid.setData(CountryData.getRecords());

        return countryGrid;
    }


    public String getIntro() {
        return DESCRIPTION;
    }

}