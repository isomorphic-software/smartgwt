package com.smartgwt.sample.showcase.client.grid.interaction;

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

public class RolloverSample extends ShowcasePanel {
    private static final String DESCRIPTION = "Move the mouse over rows in the grid to see rollover highlights. Click the buttons to enable or disable this behavior.";

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
            RolloverSample panel = new RolloverSample();
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

        IButton rolloverOff = new IButton("Rollover Off");
        rolloverOff.setLeft(120);
        rolloverOff.setTop(240);
        rolloverOff.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                countryGrid.setShowRollOver(false);
            }
        });
        canvas.addChild(rolloverOff);
        
        IButton rolloverOn = new IButton("Rollover On");
        rolloverOn.setLeft(0);
        rolloverOn.setTop(240);
        rolloverOn.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                countryGrid.setShowRollOver(true);
            }
        });
        canvas.addChild(rolloverOn);

        return canvas;
    }

    public String getIntro() {
        return DESCRIPTION;
    }

}