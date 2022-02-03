package com.smartgwt.sample.showcase.client.grid.databinding;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

public class GridDataBindingDataSourceFieldsSample extends ShowcasePanel {
    private static final String DESCRIPTION = "This ListGrid takes its field (column) settings" +
                                              " from the country DataSource specified in the" +
                                              " \"dataSource\" property of the component" +
                                              " definition. This technique is appropriate for" +
                                              " easy display of a shared data model with the" +
                                              " default UI appearance and behaviors.";

    public static class Factory implements PanelFactory {
        private String id;

        public ShowcasePanel create() {
            GridDataBindingDataSourceFieldsSample panel = new GridDataBindingDataSourceFieldsSample();
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
        countryGrid.setDataSource(CountryDS.getInstance());
        countryGrid.setAutoFetchData(true);

        return countryGrid;
    }

    private static class CountryDS extends DataSource {
        // The DataSource would normally be defined external to any classes that use it.

        private static CountryDS instance = null;
        
        public static CountryDS getInstance() {
            if (instance == null) {
              instance = new CountryDS("countryDS_DS");
            }
            return instance;
        }

        public CountryDS(String id) {
            setID(id);
            setRecordXPath("/List/country");
            DataSourceField countryNameField = new DataSourceField("countryName", FieldType.TEXT, "Country");
            DataSourceField countryCodeField = new DataSourceField("countryCode", FieldType.TEXT, "Code");
            DataSourceField independenceField = new DataSourceField("independence", FieldType.DATE, "Independence");
            DataSourceField populationField = new DataSourceField("population", FieldType.INTEGER, "Population");
            DataSourceField gdpField = new DataSourceField("gdp", FieldType.FLOAT, "GDP ($B)");

            setFields(countryNameField, countryCodeField, independenceField, populationField, gdpField);
            setDataURL("ds/test_data/country.data.xml");
        }

    }

    public String getIntro() {
        return DESCRIPTION;
    }


}