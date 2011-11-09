package com.smartgwt.sample.showcase.client.grid.appearance;

import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;
import com.smartgwt.sample.showcase.client.data.CountryData;

public class EmptyGridSample extends ShowcasePanel {
    private static final String DESCRIPTION = "Click the buttons to add or remove all data in the grid.";

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
            EmptyGridSample panel = new EmptyGridSample();
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
        countryGrid.setTop(50);
        countryGrid.setShowAllRecords(true);
        countryGrid.setShowEmptyMessage(true);
        countryGrid.setEmptyMessage("<br>Click the <b>Set data</b> button to populate this grid.");

        ListGridField nameField = new ListGridField("countryName", "Country", 120);
        ListGridField capitalField = new ListGridField("capital", "Capital");
        ListGridField continentField = new ListGridField("continent", "Continent");
        ListGridField countryCodeField = new ListGridField("countryCode", "Flag", 50);
        countryCodeField.setAlign(Alignment.CENTER);
        countryCodeField.setType(ListGridFieldType.IMAGE);
        countryCodeField.setImageURLPrefix("flags/16/");
        countryCodeField.setImageURLSuffix(".png");
        countryGrid.setFields(countryCodeField, nameField, capitalField, continentField);

        canvas.addChild(countryGrid);

        IButton setDataButton = new IButton("Set Data");
        setDataButton.setLeft(0);
        setDataButton.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                countryGrid.setData(CountryData.getRecords());
            }
        });
        canvas.addChild(setDataButton);

        IButton clearDataButton = new IButton("Clear Data");
        clearDataButton.setLeft(120);
        clearDataButton.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                countryGrid.setData(new ListGridRecord[]{});
            }
        });
        canvas.addChild(clearDataButton);

        return canvas;
    }

    public String getIntro() {
        return DESCRIPTION;
    }

}