package com.smartgwt.sample.showcase.client.grid.interaction;

import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;
import com.smartgwt.sample.showcase.client.data.CountryData;

public class HeaderHoverTipsSample extends ShowcasePanel {
    private static final String DESCRIPTION = "Move the mouse over a column header and pause (hover) for a longer description of that column.";

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
            HeaderHoverTipsSample panel = new HeaderHoverTipsSample();
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
        countryCodeField.setPrompt("Small image of national flag");

        ListGridField nameField = new ListGridField("countryName", "Country");
        nameField.setPrompt("Conventional short form of country name");

        ListGridField capitalField = new ListGridField("capital", "Capital");
        capitalField.setPrompt("Location of seat of government");

        ListGridField nationHoodField = new ListGridField("independence", "Nationhood");
        nationHoodField.setType(ListGridFieldType.DATE);
        nationHoodField.setPrompt("Date of sovereignty, founding, or other significant nationhood event");

        countryGrid.setFields(countryCodeField, nameField, capitalField, nationHoodField);
        countryGrid.setCanResizeFields(true);
        countryGrid.setData(CountryData.getRecords());

        return countryGrid;
    }


    public String getIntro() {
        return DESCRIPTION;
    }

}