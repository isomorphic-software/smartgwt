package com.smartgwt.sample.showcase.client.grid.databinding;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.DSDataFormat;
import com.smartgwt.client.types.FieldType;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

public class GridDataBindingJSONDataSourceSample extends ShowcasePanel {
    private static final String DESCRIPTION = "This ListGrid binds to a DataSource that loads" +
                                              " data from a remote JSON data provider. This" +
                                              " approach of loading simple JSON data over HTTP" +
                                              " can be used with PHP and other server" +
                                              " technologies.";

    public static class Factory implements PanelFactory {
        private String id;

        public ShowcasePanel create() {
            GridDataBindingJSONDataSourceSample panel = new GridDataBindingJSONDataSourceSample();
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
        countryGrid.setWidth(400);
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
              instance = new CountryDS("countryDS_JSON");
            }
            return instance;
        }

        public CountryDS(String id) {
            setID(id);
            setDataFormat(DSDataFormat.JSON);
            DataSourceField countryCodeField = new DataSourceField("countryCode", FieldType.TEXT,
                                                                   "Code");
            DataSourceField countryNameField = new DataSourceField("countryName", FieldType.TEXT,
                                                                   "Country");
            DataSourceField capitalField = new DataSourceField("capital", FieldType.TEXT,
                                                               "Capital");
            setFields(countryCodeField, countryNameField, capitalField);
            setDataURL("ds/test_data/countryData.json");
        }

    }

    public String getIntro() {
        return DESCRIPTION;
    }


}