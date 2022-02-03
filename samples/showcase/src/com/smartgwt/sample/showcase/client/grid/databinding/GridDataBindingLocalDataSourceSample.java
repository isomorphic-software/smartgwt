package com.smartgwt.sample.showcase.client.grid.databinding;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.DataSourceTextField;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;
import com.smartgwt.sample.showcase.client.data.CountrySampleData;

public class GridDataBindingLocalDataSourceSample extends ShowcasePanel {
    private static final String DESCRIPTION = "This ListGrid binds to a client-only DataSource that loads data from a local data array. This "+
        "technique is appropriate for client-only rapid prototyping when the production application will support add or update "+
        "(write operations),  switchable data providers (JSON, XML, WSDL, Java), arbitrarily large data sets (1000+ records), or "+
        "a data model that is shared by multiple components.";

    public static class Factory implements PanelFactory {
        private String id;

        public ShowcasePanel create() {
            GridDataBindingLocalDataSourceSample panel = new GridDataBindingLocalDataSourceSample();
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
        DataSource countryDS = CountryDS.getInstance();

        ListGrid countryGrid = new ListGrid();
        countryGrid.setWidth(500);
        countryGrid.setHeight(224);
        countryGrid.setAlternateRecordStyles(true);
        countryGrid.setShowAllRecords(true);
        countryGrid.setAutoFetchData(true);
        countryGrid.setDataSource(countryDS);

        return countryGrid;
    }

    private static class CountryDS extends DataSource {

        private static CountryDS instance = null;
        
        public static CountryDS getInstance() {
            if (instance == null) {
                instance = new CountryDS("localCountryDS");
            }
            return instance;
        }

        public CountryDS(String id) {
            setID(id);
    		
            DataSourceTextField countryCodeField = new DataSourceTextField("countryCode", "Code");
    	    DataSourceTextField countryNameField = new DataSourceTextField("countryName", "Country");
    	    DataSourceTextField capitalField = new DataSourceTextField("capital", "Capital");
    	    setFields(countryCodeField, countryNameField, capitalField);
    		
            setTestData(CountrySampleData.getNewRecords());
    	    setClientOnly(true);
        }
    }

    public String getIntro() {
        return DESCRIPTION;
    }


}