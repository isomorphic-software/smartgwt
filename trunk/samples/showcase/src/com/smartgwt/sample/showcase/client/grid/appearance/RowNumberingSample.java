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

public class RowNumberingSample extends ShowcasePanel {

    private static final String DESCRIPTION = "This sample illustrates the display of row numbers. This is done by calling ListGrid.setShowRowNumbers(true)";

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
            RowNumberingSample panel = new RowNumberingSample();
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
        countryGrid.setShowRowNumbers(true);

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

        IButton hideCapital = new IButton("Hide Capitals");
        hideCapital.setLeft(0);
        hideCapital.setTop(240);
        hideCapital.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                countryGrid.hideField("capital");
            }
        });
        canvas.addChild(hideCapital);

        IButton showCapitals = new IButton("Show Capitals");
        showCapitals.setLeft(120);
        showCapitals.setTop(240);
        showCapitals.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                countryGrid.showField("capital");
            }
        });
        canvas.addChild(showCapitals);

        return canvas;
    }

    public String getIntro() {
        return DESCRIPTION;
    }
}
