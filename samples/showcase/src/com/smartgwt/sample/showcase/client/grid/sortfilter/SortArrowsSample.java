package com.smartgwt.sample.showcase.client.grid.sortfilter;

import com.google.gwt.i18n.client.NumberFormat;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.types.SortArrow;
import com.smartgwt.client.types.SortDirection;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.grid.CellFormatter;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;
import com.smartgwt.sample.showcase.client.data.CountrySampleData;

public class SortArrowsSample extends ShowcasePanel {
    private static final String DESCRIPTION = "Click on any column header to sort or reverse-sort by that column. This grid shows the sort-direction arrow " +
            "in the top-right corner only.";

    public static class Factory implements PanelFactory {
        private String id;

        public ShowcasePanel create() {
            SortArrowsSample panel = new SortArrowsSample();
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

        ListGridField countryCodeField = new ListGridField("countryCode", "Flag", 50);
        countryCodeField.setAlign(Alignment.CENTER);
        countryCodeField.setType(ListGridFieldType.IMAGE);
        countryCodeField.setImageURLPrefix("flags/16/");
        countryCodeField.setImageURLSuffix(".png");

        final NumberFormat nf = NumberFormat.getFormat("0,000");

        ListGridField nameField = new ListGridField("countryName", "Country");
        ListGridField populationField = new ListGridField("population", "Population");
        populationField.setCellFormatter(new CellFormatter() {
            public String format(Object value, ListGridRecord record, int rowNum, int colNum) {
                if(value == null) return null;
                try {
                    return nf.format(((Number) value).longValue());
                } catch (Exception e) {
                    return value.toString();
                }
            }
        });
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

        countryGrid.setFields(countryCodeField, nameField, populationField, areaField);
        countryGrid.setData(CountrySampleData.getRecords());

        // initial sort on Population, high-to-low
        countryGrid.setSortField(2);
        countryGrid.setSortDirection(SortDirection.DESCENDING);
        countryGrid.setShowSortArrow(SortArrow.CORNER);

        return countryGrid;
    }

    public String getIntro() {
        return DESCRIPTION;
    }

}