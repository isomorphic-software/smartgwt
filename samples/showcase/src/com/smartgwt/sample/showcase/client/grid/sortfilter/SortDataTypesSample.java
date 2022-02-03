package com.smartgwt.sample.showcase.client.grid.sortfilter;

import com.google.gwt.i18n.client.NumberFormat;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.types.SortDirection;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.grid.CellFormatter;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.SortNormalizer;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;
import com.smartgwt.sample.showcase.client.data.CountrySampleData;

public class SortDataTypesSample extends ShowcasePanel {
    private static final String DESCRIPTION = "Click on any column header to sort by that column. The \"Nationhood\", \"Area\", and \"GDP (per capita)\" " +
            "columns are sorted as date, number, and calculated number values, respectively.";

    public static class Factory implements PanelFactory {
        private String id;

        public ShowcasePanel create() {
            SortDataTypesSample panel = new SortDataTypesSample();
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
        countryGrid.setWidth(550);
        countryGrid.setHeight(224);
        countryGrid.setShowAllRecords(true);

        ListGridField countryCodeField = new ListGridField("countryCode", "Flag", 50);
        countryCodeField.setAlign(Alignment.CENTER);
        countryCodeField.setType(ListGridFieldType.IMAGE);
        countryCodeField.setImageURLPrefix("flags/16/");
        countryCodeField.setImageURLSuffix(".png");
        countryCodeField.setCanSort(false);

        final NumberFormat nf = NumberFormat.getFormat("0,000");

        ListGridField nameField = new ListGridField("countryName", "Country");
        ListGridField independenceField = new ListGridField("independence", "NationHood", 100);
        independenceField.setType(ListGridFieldType.DATE);

        ListGridField areaField = new ListGridField("area", "Area (km&sup2;)");
        areaField.setType(ListGridFieldType.INTEGER);
        areaField.setCellFormatter(new CellFormatter() {
            public String format(Object value, ListGridRecord record, int rowNum, int colNum) {
                if(value == null) return null;
                NumberFormat nf = NumberFormat.getFormat("0,000");
                String val = null;
                try {
                    val = nf.format(((Number) value).longValue());
                } catch (Exception e) {
                    return value.toString();
                }
                return val + "km&sup2";
            }
        });

        ListGridField gdpPerCapitaField = new ListGridField("gdp_percap", "GDP (per capita)", 150);
        gdpPerCapitaField.setAlign(Alignment.RIGHT);
        gdpPerCapitaField.setCellFormatter(new CellFormatter() {
            public String format(Object value, ListGridRecord record, int rowNum, int colNum) {
                long gdpPerCapita = Math.round((record.getAttributeAsDouble("gdp") * 1000000000) / record.getAttributeAsInt("population"));

                NumberFormat nf = NumberFormat.getFormat("0,000");
                return "$" + nf.format(gdpPerCapita);
            }
        });

        gdpPerCapitaField.setSortNormalizer(new SortNormalizer() {
            public Object normalize(ListGridRecord record, String fieldName) {
                return record.getAttributeAsDouble("gdp") / record.getAttributeAsInt("population");
            }
        });

        countryGrid.setFields(countryCodeField, nameField, independenceField, areaField, gdpPerCapitaField);
        countryGrid.setData(CountrySampleData.getRecords());

        // initial sort on Area, high-to-low
        countryGrid.setSortField(3);
        countryGrid.setSortDirection(SortDirection.DESCENDING);

        return countryGrid;
    }

    public String getIntro() {
        return DESCRIPTION;
    }

}