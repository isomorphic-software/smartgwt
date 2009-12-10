package com.smartgwt.sample.showcase.client.grid.appearance;

import com.google.gwt.i18n.client.NumberFormat;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.grid.*;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;
import com.smartgwt.sample.showcase.client.data.CountryXmlDS;

public class GridHeaderSpansSample extends ShowcasePanel {

    private static final String DESCRIPTION = "<p>HeaderSpans are a second level of headers that appears above the normal " +
            "ListGrid headers, providing a visual cue for grouping.</p><p>Resize columns and note that the HeaderSpans change " +
            "accordingly. Right-click in the header and note that you can hide and display spanned columns as a group, " +
            "as well as individually.</p>";

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
            GridHeaderSpansSample panel = new GridHeaderSpansSample();
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

    @Override
    protected boolean isTopIntro() {
        return true;
    }

    public Canvas getViewPanel() {

        final ListGrid countryGrid = new ListGrid();
        countryGrid.setWidth(750);
        countryGrid.setHeight(224);
        countryGrid.setHeaderHeight(40);
        countryGrid.setDataSource(CountryXmlDS.getInstance());
        countryGrid.setAutoFetchData(true);

        ListGridField countryCodeField = new ListGridField("countryCode", "Flag", 50);
        countryCodeField.setAlign(Alignment.CENTER);
        countryCodeField.setType(ListGridFieldType.IMAGE);
        countryCodeField.setImageURLPrefix("flags/16/");
        countryCodeField.setImageURLSuffix(".png");
        countryCodeField.setCanSort(false);

        ListGridField nameField = new ListGridField("countryName", "Country");
        ListGridField capitalField = new ListGridField("capital", "Capital");
        ListGridField governmentField = new ListGridField("government", "Government");

        ListGridField independenceField = new ListGridField("independence", "NationHood");
        ListGridField populationField = new ListGridField("population", "Population");
        populationField.setCellFormatter(new CellFormatter() {
            public String format(Object value, ListGridRecord record, int rowNum, int colNum) {
                if (value == null) return null;
                try {
                    NumberFormat nf = NumberFormat.getFormat("0,000");
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
                if (value == null) return null;
                String val = null;
                try {
                    NumberFormat nf = NumberFormat.getFormat("0,000");
                    val = nf.format(((Number) value).longValue());
                } catch (Exception e) {
                    return value.toString();
                }
                return val + "km&sup2";
            }
        });

        ListGridField gdpField = new ListGridField("gdp", "GDP");
        gdpField.setAlign(Alignment.RIGHT);
        gdpField.setCellFormatter(new CellFormatter() {
            public String format(Object value, ListGridRecord record, int rowNum, int colNum) {
                if (value == null) return null;
                try {
                    NumberFormat nf = NumberFormat.getFormat("0,000");
                    return "$" + nf.format(((Number) value).longValue());
                } catch (Exception e) {
                    return value.toString();
                }
            }
        });

        countryGrid.setFields(countryCodeField, nameField, capitalField, governmentField,
                independenceField, populationField, areaField, gdpField);

        countryGrid.setHeaderSpans(
                new HeaderSpan("Identification", new String[]{"countryCode", "countryName"}),
                new HeaderSpan("Government & Politics", new String[]{"capital", "government", "independence"}),
                new HeaderSpan("Demographics", new String[]{"population", "area", "gdp"}));

        return countryGrid;
    }


    public String getIntro() {
        return DESCRIPTION;
    }
}