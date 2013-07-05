package com.smartgwt.sample.showcase.client.grid.interaction;

import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.*;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;
import com.smartgwt.sample.showcase.client.data.CountrySampleData;

public class CellClicksSample extends ShowcasePanel {
    private static final String DESCRIPTION = "Click, double-click, or right-click any value in the grid.";

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
            CellClicksSample panel = new CellClicksSample();
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

        ListGridField countryCodeField = new ListGridField("countryCode", "Flag", 50);
        countryCodeField.setAlign(Alignment.CENTER);
        countryCodeField.setType(ListGridFieldType.IMAGE);
        countryCodeField.setImageURLPrefix("flags/16/");
        countryCodeField.setImageURLSuffix(".png");

        ListGridField nameField = new ListGridField("countryName", "Country");
        ListGridField capitalField = new ListGridField("capital", "Capital");
        ListGridField continentField = new ListGridField("continent", "Continent");
        countryGrid.setFields(countryCodeField, nameField, capitalField, continentField);

        countryGrid.setData(CountrySampleData.getRecords());
        canvas.addChild(countryGrid);

        final Label label = new Label("click a value in the grid");
        label.setWidth(300);
        label.setTop(250);
        label.setAlign(Alignment.CENTER);
        label.setBorder("1px solid #808080");
        canvas.addChild(label);

        countryGrid.addCellClickHandler(new CellClickHandler() {
            public void onCellClick(CellClickEvent event) {

                ListGridRecord record =  event.getRecord();
                int colNum = event.getColNum();
                ListGridField field = countryGrid.getField(colNum);
                String fieldName = countryGrid.getFieldName(colNum);
                String fieldTitle = field.getTitle();

                label.setContents("Clicked <b>" + fieldTitle + ":" + record.getAttribute(fieldName) +
                        "</b> (Country:" + record.getAttribute("countryName") + ")");
            }
        });

        countryGrid.addCellDoubleClickHandler(new CellDoubleClickHandler() {
            public void onCellDoubleClick(CellDoubleClickEvent event) {
                sayCellEvent(countryGrid, "Double-clicked", event.getRecord(), event.getColNum());
            }
        });

        countryGrid.addCellContextClickHandler(new CellContextClickHandler() {
            public void onCellContextClick(CellContextClickEvent event) {
                sayCellEvent(countryGrid, "Context-clicked", event.getRecord(), event.getColNum());
                event.cancel();
            }
        });

        return canvas;
    }

    private static void sayCellEvent(ListGrid countryGrid, String eventText, ListGridRecord record, int colNum) {
        ListGridField field = countryGrid.getField(colNum);
        String title = field.getTitle();
        String fieldName = countryGrid.getFieldName(colNum);
        SC.say(eventText + " <b>" +
                title + ":" + record.getAttribute(fieldName) +
                "</b> (Country:" + record.getAttribute("countryName") + ")");
    }

    public String getIntro() {
        return DESCRIPTION;
    }

}