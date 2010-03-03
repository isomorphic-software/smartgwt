package com.smartgwt.sample.showcase.client.grid.databinding;

import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;
import com.smartgwt.sample.showcase.client.data.CountryData;

public class GridDataBindingListGridFieldsSample extends ShowcasePanel {
    private static final String DESCRIPTION = "This ListGrid takes its field (column) settings" +
                                              " from the \"fields\" property of the component" +
                                              " definition only. This technique is appropriate" +
                                              " for presentation-only grids that do not require" +
                                              " data binding.";

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
            GridDataBindingListGridFieldsSample panel = new GridDataBindingListGridFieldsSample();
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

        ListGridField countryCodeField = new ListGridField("countryCode", "Code", 40);
        ListGridField nameField = new ListGridField("countryName", "Country");
        ListGridField independenceField = new ListGridField("independence", "Nationhood", 225);
        independenceField.setType(ListGridFieldType.DATE);
        ListGridField populationField = new ListGridField("population", "Population");
        populationField.setType(ListGridFieldType.INTEGER);
        ListGridField gdpField = new ListGridField("gdp", "GDP ($B)");
        gdpField.setType(ListGridFieldType.FLOAT);

        countryGrid.setFields(new ListGridField[] {countryCodeField, nameField, independenceField,
                                                   populationField, gdpField});
        countryGrid.setCanResizeFields(true);
        countryGrid.setData(CountryData.getRecords());

        return countryGrid;
    }


    public String getIntro() {
        return DESCRIPTION;
    }

}