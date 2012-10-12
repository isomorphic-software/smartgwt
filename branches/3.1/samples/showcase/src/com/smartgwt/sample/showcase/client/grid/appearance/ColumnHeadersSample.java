package com.smartgwt.sample.showcase.client.grid.appearance;

import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;
import com.smartgwt.sample.showcase.client.data.CountryData;

public class ColumnHeadersSample extends ShowcasePanel {

    private static String DESCRIPTION = "Click the buttons to show or hide the column headers.";

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
            ColumnHeadersSample panel = new ColumnHeadersSample();
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
        countryGrid.setShowHeader(false);

        ListGridField countryCodeField = new ListGridField("countryCode", "Flag", 40);
        countryCodeField.setAlign(Alignment.CENTER);
        countryCodeField.setType(ListGridFieldType.IMAGE);
        countryCodeField.setImageURLPrefix("flags/16/");
        countryCodeField.setImageURLSuffix(".png");

        ListGridField nameField = new ListGridField("countryName", "Country");
        ListGridField capitalField = new ListGridField("capital", "Capital");
        ListGridField continentField = new ListGridField("continent", "Continent");
        countryGrid.setFields(countryCodeField, nameField, capitalField, continentField);
        countryGrid.setCanResizeFields(true);
        countryGrid.setData(CountryData.getRecords());
        canvas.addChild(countryGrid);

        IButton hideHeader = new IButton("Hide Header");
        hideHeader.setLeft(120);
        hideHeader.setTop(240);
        hideHeader.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                countryGrid.setShowHeader(false);
            }
        });
        canvas.addChild(hideHeader);

        IButton showHeader = new IButton("Show Header");
        showHeader.setLeft(0);
        showHeader.setTop(240);
        showHeader.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                countryGrid.setShowHeader(true);
            }
        });
        canvas.addChild(showHeader);
        
        return canvas;
    }


    public String getIntro() {
        return DESCRIPTION;
    }

}