package com.smartgwt.sample.showcase.client.grid.autofit;

import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;
import com.smartgwt.sample.showcase.client.data.CountryData;
import com.smartgwt.sample.showcase.client.data.CountryRecord;

public class AutofitRowsSample extends ShowcasePanel {
    private static final String DESCRIPTION = "Click the buttons to show different numbers of records. The grid resizes to fit all rows without scrolling.";

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
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

        ListGridField nameField = new ListGridField("countryName", "Country", 120);
        ListGridField backgroundField = new ListGridField("background", "Background");
        ListGridField countryCodeField = new ListGridField("countryCode", "Flag", 50);
        countryCodeField.setAlign(Alignment.CENTER);
        countryCodeField.setType(ListGridFieldType.IMAGE);
        countryCodeField.setImageURLPrefix("flags/16/");
        countryCodeField.setImageURLSuffix(".png");

        countryGrid.setFields(nameField, backgroundField, countryCodeField);

        canvas.addChild(countryGrid);

        final CountryRecord[] records = CountryData.getRecords();

        final CountryRecord[] records5 = new CountryRecord[5];
        System.arraycopy(records, 0, records5, 0, 5);

        final CountryRecord[] records10 = new CountryRecord[10];
        System.arraycopy(records, 0, records10, 0, 10);

        IButton show5Button = new IButton("Show 5");
        show5Button.setLeft(0);
        show5Button.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                countryGrid.setData(records5);
            }
        });
        canvas.addChild(show5Button);

        IButton show10Button = new IButton("Show 10");
        show10Button.setLeft(120);
        show10Button.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                countryGrid.setData(records10);
            }
        });
        canvas.addChild(show10Button);

        IButton showAllButton = new IButton("Show All");
        showAllButton.setLeft(240);
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