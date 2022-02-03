package com.smartgwt.sample.showcase.client.grid.appearance;

import com.google.gwt.i18n.client.NumberFormat;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.grid.CellFormatter;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;
import com.smartgwt.sample.showcase.client.data.CountrySampleData;


public class HiliteCellsReplaceStyleSample extends ShowcasePanel {
    private static final String DESCRIPTION = "<p>This grid hilites \"Population\" values greater than 1 billion or less than 50 million using a full set " +
            "of compound styles (with customized background colors).</p><p>Mouse over or click-drag rows to see how these" +
            " styles apply to different row states.</p>";

    public static class Factory implements PanelFactory {
        private String id;

        public ShowcasePanel create() {
            HiliteCellsReplaceStyleSample panel = new HiliteCellsReplaceStyleSample();
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

        final ListGrid countryGrid = new ListGrid() {
            @Override
            protected String getBaseStyle(ListGridRecord record, int rowNum, int colNum) {
                if (getFieldName(colNum).equals("population")) {
                    if (record.getAttributeAsInt("population") > 1000000000) {
                        return "myHighGridCell";
                    } else if (record.getAttributeAsInt("population") < 50000000) {
                        return "myLowGridCell";
                    } else {
                        return super.getBaseStyle(record, rowNum, colNum);
                    }
                } else {
                    return super.getBaseStyle(record, rowNum, colNum);
                }
            }
        };
        countryGrid.setWidth(500);
        countryGrid.setHeight(224);
        countryGrid.setCanDragSelect(true);
        countryGrid.setShowAllRecords(true);
        countryGrid.setSortField(1);

        ListGridField countryCodeField = new ListGridField("countryCode", "Flag", 40);
        countryCodeField.setAlign(Alignment.CENTER);
        countryCodeField.setType(ListGridFieldType.IMAGE);
        countryCodeField.setImageURLPrefix("flags/16/");
        countryCodeField.setImageURLSuffix(".png");

        ListGridField nameField = new ListGridField("countryName", "Country");
        ListGridField capitalField = new ListGridField("capital", "Capital");
        ListGridField populationField = new ListGridField("population", "Population");
        populationField.setType(ListGridFieldType.INTEGER);
        populationField.setCellFormatter(new CellFormatter() {
            public String format(Object value, ListGridRecord record, int rowNum, int colNum) {
                NumberFormat nf = NumberFormat.getFormat("0,000");
                try {
                    return nf.format(((Number) value).longValue());
                } catch (Exception e) {
                    return value.toString();
                }
            }
        });

        countryGrid.setFields(countryCodeField, nameField, capitalField, populationField);
        countryGrid.setCanResizeFields(true);
        countryGrid.setData(CountrySampleData.getRecords());

        return countryGrid;
    }


    public String getIntro() {
        return DESCRIPTION;
    }

}