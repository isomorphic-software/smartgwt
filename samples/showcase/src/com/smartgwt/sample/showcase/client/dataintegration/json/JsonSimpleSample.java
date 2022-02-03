package com.smartgwt.sample.showcase.client.dataintegration.json;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.DataSourceTextField;
import com.smartgwt.client.types.DSDataFormat;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

public class JsonSimpleSample extends ShowcasePanel {
    private static final String DESCRIPTION = "<p>DataSources can bind directly to JSON data where records appear as an Array of JavaScript Objects with field values as properties.</p>" +
            "<p>This approach of loading simple JSON data over HTTP can be used with PHP and other server technologies.</p>";

    public static class Factory implements PanelFactory {
        private String id;

        public ShowcasePanel create() {
            JsonSimpleSample panel = new JsonSimpleSample();
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
        DataSource dataSource = new DataSource();
        dataSource.setDataFormat(DSDataFormat.JSON);
        dataSource.setDataURL("data/dataIntegration/json/countries_small.js");

        DataSourceTextField nameField = new DataSourceTextField("name", "Name");
        DataSourceTextField populationfield = new DataSourceTextField("population", "Population");
        DataSourceTextField areaField = new DataSourceTextField("total_area", "Total Area");
        DataSourceTextField governmentField = new DataSourceTextField("government", "Government");

        dataSource.setFields(nameField, populationfield, areaField, governmentField);

        ListGrid grid = new ListGrid();
        grid.setDataSource(dataSource);
        grid.setWidth100();
        grid.setHeight(150);
        grid.setAutoFetchData(true);
        return grid;
    }

    public String getIntro() {
        return DESCRIPTION;
    }
}