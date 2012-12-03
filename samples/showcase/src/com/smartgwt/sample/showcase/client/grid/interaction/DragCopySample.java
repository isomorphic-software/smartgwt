package com.smartgwt.sample.showcase.client.grid.interaction;

import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.DragDataAction;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;
import com.smartgwt.sample.showcase.client.data.CountrySampleData;

public class DragCopySample extends ShowcasePanel {
    private static final String DESCRIPTION = "Drag and drop to copy rows between the two lists.";

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
            DragCopySample panel = new DragCopySample();
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

        ListGrid countryGrid = new ListGrid();
        countryGrid.setWidth(300);
        countryGrid.setHeight(224);
        countryGrid.setShowAllRecords(true);
        countryGrid.setCanReorderRecords(true);
        countryGrid.setCanDragRecordsOut(true);
        countryGrid.setCanAcceptDroppedRecords(true);
        countryGrid.setDragDataAction(DragDataAction.COPY);

        ListGridField countryCodeField = new ListGridField("countryCode", "Flag", 50);
        countryCodeField.setAlign(Alignment.CENTER);
        countryCodeField.setType(ListGridFieldType.IMAGE);
        countryCodeField.setImageURLPrefix("flags/16/");
        countryCodeField.setImageURLSuffix(".png");

        ListGridField nameField = new ListGridField("countryName", "Country");
        ListGridField capitalField = new ListGridField("capital", "Capital");

        countryGrid.setFields(countryCodeField, nameField, capitalField);
        countryGrid.setData(CountrySampleData.getRecords());
        canvas.addChild(countryGrid);

        ListGrid countryGrid2 = new ListGrid();
        countryGrid2.setWidth(200);
        countryGrid2.setHeight(224);
        countryGrid2.setLeft(350);
        countryGrid2.setShowAllRecords(true);
        countryGrid2.setEmptyMessage("Drop Rows Here");
        countryGrid2.setCanReorderFields(true);
        countryGrid2.setCanAcceptDroppedRecords(true);

        ListGridField countryCodeField2 = new ListGridField("countryCode", "Flag", 50);
        countryCodeField.setAlign(Alignment.CENTER);
        countryCodeField.setType(ListGridFieldType.IMAGE);
        countryCodeField.setImageURLPrefix("flags/16/");
        countryCodeField.setImageURLSuffix(".png");
        ListGridField nameField2 = new ListGridField("countryName", "Country");
                
        countryGrid2.setFields(countryCodeField2, nameField2);

        canvas.addChild(countryGrid2);

        return canvas;
    }

    public String getIntro() {
        return DESCRIPTION;
    }

}