package com.smartgwt.sample.showcase.client.grid.databinding;

import com.google.gwt.i18n.client.NumberFormat;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.FieldType;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.grid.CellFormatter;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

public class GridDataBindingMergedFieldsSample extends ShowcasePanel {
    private static final String DESCRIPTION = "This ListGrid merges field settings from both the" +
                                              " component \"fields\" (for presentation" +
                                              " attributes) and the countryDS DataSource (for" +
                                              " data model attributes). This is the usual" +
                                              " approach to customize the look and feel of a" +
                                              " data-bound component.";

    public static class Factory implements PanelFactory {
        private String id;

        public ShowcasePanel create() {
            GridDataBindingMergedFieldsSample panel = new GridDataBindingMergedFieldsSample();
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

        ListGridField countryCodeField = new ListGridField("countryCode", "Flag", 50);
        countryCodeField.setType(ListGridFieldType.IMAGE);
        countryCodeField.setAlign(Alignment.CENTER);
        countryCodeField.setImageURLPrefix("flags/16/");
        countryCodeField.setImageURLSuffix(".png");
        ListGridField nameField = new ListGridField("countryName", "Country", 100);
        ListGridField independenceField = new ListGridField("independence", "Nationhood", 100);
        independenceField.setType(ListGridFieldType.DATE);
        ListGridField populationField = new ListGridField("population", "Population", 100);
        populationField.setType(ListGridFieldType.INTEGER);
        populationField.setCellFormatter(new CellFormatter() {
            public String format(Object value, ListGridRecord record, int rowNum, int colNum) {
                NumberFormat nf = NumberFormat.getFormat("0,000");
                try {
                    return nf.format(((Number)value).longValue());
                } catch (Exception e) {
                    return value.toString();
                }
            }
        });
        ListGridField gdpField = new ListGridField("gdp", "GDP ($M)");
        gdpField.setType(ListGridFieldType.INTEGER);
        gdpField.setCellFormatter(new CellFormatter() {
            public String format(Object value, ListGridRecord record, int rowNum, int colNum) {
                NumberFormat nf = NumberFormat.getFormat("#,##0");
                try {
                    return nf.format(((Number)value).longValue());
                } catch (Exception e) {
                    return value.toString();
                }
            }
        });

        countryGrid.setFields(countryCodeField, nameField, independenceField, populationField, gdpField);

        return countryGrid;
    }

    private static class CountryDS extends DataSource {
        // The DataSource would normally be defined external to any classes that use it.

        private static CountryDS instance = null;

        public static CountryDS getInstance() {
            if (instance == null) {
              instance = new CountryDS("countryDS_Merged");
            }
            return instance;
        }

        public CountryDS(String id) {
            setID(id);
            setRecordXPath("/List/country");
            DataSourceField countryNameField = new DataSourceField("countryName", FieldType.TEXT,
                                                                   "Country");
            DataSourceField countryCodeField = new DataSourceField("countryCode", FieldType.TEXT,
                                                                   "Code");
            DataSourceField independenceField = new DataSourceField("independence", FieldType.DATE,
                                                                    "Independence");
            DataSourceField populationField = new DataSourceField("population", FieldType.INTEGER,
                                                                  "Population");
            DataSourceField gdpField = new DataSourceField("gdp", FieldType.FLOAT, "GDP ($B)");
            setFields(countryNameField, countryCodeField, independenceField, populationField,
                      gdpField);
            setDataURL("ds/test_data/country.data.xml");
        }

    }

    public String getIntro() {
        return DESCRIPTION;
    }


}