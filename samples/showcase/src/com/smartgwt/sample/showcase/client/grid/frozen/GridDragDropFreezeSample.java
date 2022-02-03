package com.smartgwt.sample.showcase.client.grid.frozen;

import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.DragDataAction;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;
import com.smartgwt.sample.showcase.client.data.CountrySampleData;


public class GridDragDropFreezeSample extends ShowcasePanel {
    private static final String DESCRIPTION = "Smart GWT's drag and drop support works normally with frozen columns with no further configuration. " +
            "Drag countries within grids to reorder them, or between grids to move countries back and forth.";

    public static class Factory implements PanelFactory {
        private String id;

        public ShowcasePanel create() {
            GridDragDropFreezeSample panel = new GridDragDropFreezeSample();
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

        ListGridRecord[] countryRecords = CountrySampleData.getRecords();
        ListGridRecord[] countryData1 = new ListGridRecord[7];
        ListGridRecord[] countryData2 = new ListGridRecord[8];

        for (int i = 0; i < countryRecords.length; i++) {
        	ListGridRecord countryRecord = countryRecords[i];
            if (i < 7) {
                countryData1[i] = countryRecord;
            } else {
                countryData2[i - 7] = countryRecord;
            }
        }

        Canvas canvas = new Canvas();

        ListGrid countryGrid = new ListGrid();
        countryGrid.setWidth(325);
        countryGrid.setHeight(224);
        countryGrid.setCanDragRecordsOut(true);
        countryGrid.setCanAcceptDroppedRecords(true);
        countryGrid.setCanReorderRecords(true);
        countryGrid.setDragDataAction(DragDataAction.MOVE);

        ListGridField countryCodeField = new ListGridField("countryCode", "Flag", 50);
        countryCodeField.setAlign(Alignment.CENTER);
        countryCodeField.setType(ListGridFieldType.IMAGE);
        countryCodeField.setImageURLPrefix("flags/16/");
        countryCodeField.setImageURLSuffix(".png");
        countryCodeField.setFrozen(true);

        ListGridField nameField = new ListGridField("countryName", "Country", 100);
        nameField.setFrozen(true);

        ListGridField capitalField = new ListGridField("capital", "Capital", 100);
        ListGridField continentField = new ListGridField("continent", "Continent", 100);
        ListGridField governmentField = new ListGridField("government", "Government", 100);
        ListGridField independenceField = new ListGridField("independence", "Independence", 100);

        ListGridField populationField = new ListGridField("population", "Population", 100);
        populationField.setType(ListGridFieldType.INTEGER);

        countryGrid.setFields(countryCodeField, nameField, capitalField, continentField,
                governmentField, independenceField, populationField);
        countryGrid.setData(countryData1);
        canvas.addChild(countryGrid);

        ListGrid countryGrid2 = new ListGrid();
        countryGrid2.setWidth(225);
        countryGrid2.setHeight(224);
        countryGrid2.setLeft(350);
        countryGrid2.setEmptyMessage("Drop Rows Here");
        countryGrid2.setCanDragRecordsOut(true);
        countryGrid2.setCanAcceptDroppedRecords(true);
        countryGrid2.setCanReorderRecords(true);
        countryGrid2.setDragDataAction(DragDataAction.MOVE);
        countryGrid2.setFields(new ListGridField("countryName", "Country"));
        countryGrid2.setData(countryData2);
        canvas.addChild(countryGrid2);

        return canvas;
    }

    public String getIntro() {
        return DESCRIPTION;
    }

}