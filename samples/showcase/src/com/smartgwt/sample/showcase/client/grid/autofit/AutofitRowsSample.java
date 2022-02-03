package com.smartgwt.sample.showcase.client.grid.autofit;

import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;
import com.smartgwt.sample.showcase.client.data.CountrySampleData;

public class AutofitRowsSample extends ShowcasePanel {
    private static final String DESCRIPTION = "Click the buttons to show different numbers of records. The grid resizes to fit all rows without scrolling.";

    public static class Factory implements PanelFactory {
        private String id;

        public ShowcasePanel create() {
            AutofitRowsSample panel = new AutofitRowsSample();
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
        countryGrid.setHeight(1);
        countryGrid.setTop(50);
        countryGrid.setShowAllRecords(true);
        countryGrid.setBodyOverflow(Overflow.VISIBLE);
        countryGrid.setOverflow(Overflow.VISIBLE);
        countryGrid.setLeaveScrollbarGap(false);

        ListGridField nameField = new ListGridField("countryName", "Country");
        ListGridField capitalField = new ListGridField("capital", "Capital");
        ListGridField continentField = new ListGridField("continent", "Continent");
        ListGridField countryCodeField = new ListGridField("countryCode", "Flag", 50);
        countryCodeField.setType(ListGridFieldType.IMAGE);
        countryCodeField.setImageURLPrefix("flags/16/");
        countryCodeField.setImageURLSuffix(".png");

        countryGrid.setFields(countryCodeField, nameField, capitalField, continentField);

        canvas.addChild(countryGrid);

        final ListGridRecord[] records = CountrySampleData.getRecords();
        countryGrid.setData(records);

        final ListGridRecord[] records5 = new ListGridRecord[5];
        System.arraycopy(records, 0, records5, 0, 5);

        final ListGridRecord[] records10 = new ListGridRecord[10];
        System.arraycopy(records, 0, records10, 0, 10);

        IButton show5Button = new IButton("Data set: 5 records");
        show5Button.setLeft(0);
        show5Button.setWidth(150);
        show5Button.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                countryGrid.setData(records5);
            }
        });
        canvas.addChild(show5Button);

        IButton show10Button = new IButton("Data set: 10 records");
        show10Button.setLeft(170);
        show10Button.setWidth(150);
        show10Button.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                countryGrid.setData(records10);
            }
        });
        canvas.addChild(show10Button);

        IButton showAllButton = new IButton("Data set: 15 records");
        showAllButton.setLeft(340);
        showAllButton.setWidth(150);
        showAllButton.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                countryGrid.setData(records);
            }
        });
        canvas.addChild(showAllButton);

        return canvas;
    }

    public String getIntro() {
        return DESCRIPTION;
    }

}