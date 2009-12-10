package com.smartgwt.sample.showcase.client.grid.datatypes;

import com.google.gwt.i18n.client.NumberFormat;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.ListGridEditEvent;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.grid.*;
import com.smartgwt.client.widgets.grid.events.EditorExitEvent;
import com.smartgwt.client.widgets.grid.events.EditorExitHandler;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;
import com.smartgwt.sample.showcase.client.data.CountryData;
import com.smartgwt.sample.showcase.client.data.CountryRecord;

public class GridDataTypesCalculatedSample extends ShowcasePanel {
    private static final String DESCRIPTION = "Click on column headers to sort, or data values to" +
            " edit. \"GDP (per capita)\" is calculated from the" +
            " \"GDP\" and \"Population\" fields.";

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
            GridDataTypesCalculatedSample panel = new GridDataTypesCalculatedSample();
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
        Canvas canvas = new Canvas();

        final ListGrid countryGrid = new ListGrid();
        countryGrid.setWidth(500);
        countryGrid.setHeight(224);
        countryGrid.setShowAllRecords(true);
        countryGrid.setCanEdit(true);
        countryGrid.setEditEvent(ListGridEditEvent.CLICK);
        countryGrid.setModalEditing(true);

        ListGridField countryCodeField = new ListGridField("countryCode", "Flag", 50);
        countryCodeField.setAlign(Alignment.CENTER);
        countryCodeField.setType(ListGridFieldType.IMAGE);
        countryCodeField.setImageURLPrefix("flags/16/");
        countryCodeField.setImageURLSuffix(".png");
        countryCodeField.setCanEdit(false);

        ListGridField nameField = new ListGridField("countryName", "Country");

final ListGridField populationField = new ListGridField("population", "Population");
        populationField.setType(ListGridFieldType.INTEGER);
        populationField.setCellFormatter(new CellFormatter() {
            public String format(Object value, ListGridRecord record, int rowNum, int colNum) {
                if (value == null) {
                    return null;
                } else {
                    NumberFormat nf = NumberFormat.getFormat("0,000");
                    try {
                        return nf.format(((Number) value).longValue());
                    } catch (Exception e) {
                        return value.toString();
                    }
                }
            }
        });


        final ListGridField gdpField = new ListGridField("gdp", "GDP ($B)");
        gdpField.setType(ListGridFieldType.FLOAT);
        gdpField.setCellFormatter(new CellFormatter() {
            public String format(Object value, ListGridRecord record, int rowNum, int colNum) {
                if (value == null) {
                    return null;
                } else {
                    NumberFormat nf = NumberFormat.getFormat("#,##0.00");
                    try {
                        return nf.format(((Number) value).floatValue());
                    } catch (Exception e) {
                        return value.toString();
                    }
                }
            }
        });

        final ListGridField gdpPerCapitaField = new ListGridField("gdpPerCapita", "GDP (per capita)");
        gdpPerCapitaField.setCanEdit(false);
        gdpPerCapitaField.setAlign(Alignment.RIGHT);
        gdpPerCapitaField.setType(ListGridFieldType.FLOAT);
        gdpPerCapitaField.setCellFormatter(new CellFormatter() {
            public String format(Object value, ListGridRecord record, int rowNum, int colNum) {
                CountryRecord countryRecord = (CountryRecord) record;
                long gdpPerCapita = Math.round((countryRecord.getGdp() * 1000000000) / countryRecord.getPopulation());

                NumberFormat nf = NumberFormat.getFormat("0,000");
                return "$" + nf.format(gdpPerCapita);
            }
        });

        gdpPerCapitaField.setSortNormalizer(new SortNormalizer() {
            public Object normalize(ListGridRecord record, String fieldName) {
                CountryRecord countryRecord = (CountryRecord) record;
                return countryRecord.getGdp() / countryRecord.getPopulation();
            }
        });

        countryGrid.addEditorExitHandler(new EditorExitHandler() {
            public void onEditorExit(EditorExitEvent event) {
                String fieldName = countryGrid.getFieldName(event.getColNum());
                if("gdp".equals(fieldName) || "population".equals(fieldName)) {
                    int gdpFieldNum = countryGrid.getFieldNum("gdp_percap");
                    countryGrid.refreshCell(event.getRowNum(), gdpFieldNum, false, true);
                }
            }
        });

        countryGrid.setFields(countryCodeField, nameField, populationField, gdpField, gdpPerCapitaField);
        countryGrid.setData(CountryData.getRecords());
        canvas.addChild(countryGrid);

        return canvas;
    }

    public String getIntro() {
        return DESCRIPTION;
    }

}