package com.smartgwt.sample.showcase.client.grid.appearance;

import com.smartgwt.client.types.*;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;
import com.smartgwt.sample.showcase.client.data.CountryData;

public class AnimatedSelectionSample extends ShowcasePanel {

    private static final String DESCRIPTION = "RollOver, and select the rows in the grid to see rollover and selection indicators fade into view. " +
            "This is achieved via the rollOverCanvas and selectionCanvas subsystem. Note that the opacity setting on the rollUnderCanvas allows true color layering.";

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
            AnimatedSelectionSample panel = new AnimatedSelectionSample();
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


        ListGrid countryGrid = new ListGrid();

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

        countryGrid.setSelectionType(SelectionStyle.SINGLE);
        countryGrid.setBaseStyle("simpleCell");

        countryGrid.setShowRollOverCanvas(true);
        countryGrid.setAnimateRollUnder(true);

        Canvas rollUnderCanvasProperties = new Canvas();
        rollUnderCanvasProperties.setAnimateFadeTime(1000);
        rollUnderCanvasProperties.setAnimateShowEffect(AnimationEffect.FADE);
        rollUnderCanvasProperties.setBackgroundColor("#00ffff");
        rollUnderCanvasProperties.setOpacity(50);
        //can also override ListGrid.getRollUnderCanvas(int rowNum, int colNum)
        countryGrid.setRollUnderCanvasProperties(rollUnderCanvasProperties);

        countryGrid.setShowSelectionCanvas(true);
        countryGrid.setAnimateSelectionUnder(true);

        Canvas selectionUnderCanvasProperties = new Canvas();
        selectionUnderCanvasProperties.setAnimateShowEffect(AnimationEffect.FADE);
        selectionUnderCanvasProperties.setAnimateFadeTime(1000);
        selectionUnderCanvasProperties.setBackgroundColor("#ffff40");
        countryGrid.setSelectionUnderCanvasProperties(selectionUnderCanvasProperties);

        
        return countryGrid;
    }


    public String getIntro() {
        return DESCRIPTION;
    }
}
