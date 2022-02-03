package com.smartgwt.sample.showcase.client.grid.appearance;

import java.util.Date;

import com.smartgwt.client.util.NumberUtil;
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


public class FormatValuesSample extends ShowcasePanel {
    private static final String DESCRIPTION = "This grid applies custom formatters to the \"Nationhood\" and \"Area\" columns. " + 
    		"Custom formatters are written in Java; they are useful when you have unusual formatting requirements that cannot be " +
    		"achieved with the built-in declarative formatting features (as is the case with the \"Nationhood\" formatting in this sample).<p>" +
    		"Click on the \"Nationhood\" or \"Area\" column headers to sort the underlying data values.";

    public static class Factory implements PanelFactory {
        private String id;

        public ShowcasePanel create() {
            FormatValuesSample panel = new FormatValuesSample();
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

        ListGridField countryCodeField = new ListGridField("countryCode", "Flag", 40);
        countryCodeField.setAlign(Alignment.CENTER);
        countryCodeField.setType(ListGridFieldType.IMAGE);
        countryCodeField.setImageURLPrefix("flags/16/");
        countryCodeField.setImageURLSuffix(".png");

        ListGridField nameField = new ListGridField("countryName", "Country");
        ListGridField nationHoodField = new ListGridField("independence", "Nationhood");
        nationHoodField.setType(ListGridFieldType.DATE);
        nationHoodField.setWidth("25%");

        nationHoodField.setCellFormatter(new CellFormatter() {
            public String format(Object value, ListGridRecord record, int rowNum, int colNum) {
                if (value != null) {

                    try {
                        Date dateValue = (Date) value;
                        return (new Date().getYear() - dateValue.getYear()) + " years ago";
                    } catch (Exception e) {
                        return value.toString();
                    }
                } else {
                    return "";
                }
            }
        });

        ListGridField areaField = new ListGridField("area", "Area (km&sup2;)");
        areaField.setType(ListGridFieldType.INTEGER);
        areaField.setCellFormatter(new CellFormatter() {
            public String format(Object value, ListGridRecord record, int rowNum, int colNum) {
                if(value == null) return null;
                return NumberUtil.format((Integer)value, ",0") + " km&sup2";
            }
        });

        countryGrid.setFields(countryCodeField, nameField, nationHoodField, areaField);
        countryGrid.setCanResizeFields(true);
        countryGrid.setData(CountrySampleData.getRecords());

        return countryGrid;
    }


    public String getIntro() {
        return DESCRIPTION;
    }

}