package com.smartgwt.sample.showcase.client.grid.interaction;

import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.*;
import com.smartgwt.client.widgets.viewer.DetailViewer;
import com.smartgwt.client.widgets.viewer.DetailViewerField;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;
import com.smartgwt.sample.showcase.client.data.CountrySampleData;

public class RecordClicksSample extends ShowcasePanel {
    private static final String DESCRIPTION = "<p>Click to select a single row in the grid. Shift-click to select a continuous range of rows.</p><p>Ctrl-click " +
            "to add or remove individual rows from the selection.</p>";

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
            RecordClicksSample panel = new RecordClicksSample();
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


        final DetailViewer detailViewer = new DetailViewer();
        detailViewer.setWidth(500);
        detailViewer.setTop(250);
        detailViewer.setFields(
                new DetailViewerField("countryName", "Country"),
                new DetailViewerField("countryCode", "Code"),
                new DetailViewerField("government", "Government"));

        detailViewer.setEmptyMessage("Click a row in the grid");
        canvas.addChild(detailViewer);

        countryGrid.addRecordClickHandler(new RecordClickHandler() {
            public void onRecordClick(RecordClickEvent event) {
                detailViewer.setData(countryGrid.getSelection());
            }
        });

        countryGrid.addRecordDoubleClickHandler(new RecordDoubleClickHandler() {
            public void onRecordDoubleClick(RecordDoubleClickEvent event) {
                ListGridRecord record = (ListGridRecord)event.getRecord();
                SC.say("Double-clicked country: <b>" + record.getAttribute("countryName") + "</b>");
            }
        });

        countryGrid.addRowContextClickHandler(new RowContextClickHandler() {
            public void onRowContextClick(RowContextClickEvent event) {
                ListGridRecord record = (ListGridRecord)event.getRecord();
                SC.say("Context-clicked country: <b>" + record.getAttribute("countryName") + "</b>");
                //prevent default browser context menu
                event.cancel();
            }
        });
        return canvas;
    }

    public String getIntro() {
        return DESCRIPTION;
    }

}