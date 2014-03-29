package com.smartgwt.sample.showcase.client.grid.appearance;

import com.google.gwt.i18n.client.DateTimeFormat;
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

import java.util.Date;


public class FormatValuesBuiltinSample extends ShowcasePanel {
    private static final String DESCRIPTION = "This grid applies formatters to the \"Nationhood\" and \"Area\" columns using SmartGWT's " +
        "built-in declarative formatting feature, which can format dates and numbers using format strings like \"MMM dd yyyy\".  " +
    	"If you have Pro+, this formatting will also be exported to Excel.<p>" + 
        "Click on the \"Nationhood\" or \"Area\" column headers to sort the underlying data values.";

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
            FormatValuesBuiltinSample panel = new FormatValuesBuiltinSample();
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
        nationHoodField.setFormat("MMM d, yyyy");
        nationHoodField.setWidth("25%");
        
        ListGridField areaField = new ListGridField("area", "Area (km&sup2;)");
        areaField.setType(ListGridFieldType.INTEGER);
        areaField.setFormat(",0 km&sup2;");

        countryGrid.setFields(countryCodeField, nameField, nationHoodField, areaField);
        countryGrid.setCanResizeFields(true);
        countryGrid.setData(CountrySampleData.getRecords());

        return countryGrid;
    }


    public String getIntro() {
        return DESCRIPTION;
    }

}