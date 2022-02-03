package com.smartgwt.sample.showcase.client.grid.interaction;

import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.types.SelectionAppearance;
import com.smartgwt.client.types.SelectionStyle;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.events.SelectionUpdatedEvent;
import com.smartgwt.client.widgets.grid.events.SelectionUpdatedHandler;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;
import com.smartgwt.sample.showcase.client.data.CountrySampleData;

public class CheckboxSelectSample extends ShowcasePanel {
    private static final String DESCRIPTION = "By setting selectionAppearance to SelectionAppearance.CHECKBOX, the ListGrid can use checkboxes to indicate the selected state of records. " +
            "Only by clicking on a checkbox will the corresponding record be selected or unselected. ";

    public static class Factory implements PanelFactory {
        private String id;

        public ShowcasePanel create() {
            CheckboxSelectSample panel = new CheckboxSelectSample();
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

        final ListGrid selectedCountriesGrid = new ListGrid();
        selectedCountriesGrid.setWidth(250);
        selectedCountriesGrid.setHeight(100);
        selectedCountriesGrid.setTop(250);
        selectedCountriesGrid.setShowAllRecords(true);
        ListGridField selectedCountriesField = new ListGridField("countryName", "Selected Countries");
        selectedCountriesGrid.setFields(selectedCountriesField);

        final ListGrid countryGrid = new ListGrid();
        countryGrid.setWidth(500);
        countryGrid.setHeight(224);
        countryGrid.setShowAllRecords(true);
        countryGrid.setSelectionType(SelectionStyle.SIMPLE);
        countryGrid.setSelectionAppearance(SelectionAppearance.CHECKBOX);

        ListGridField countryCodeField = new ListGridField("countryCode", "Flag", 40);
        countryCodeField.setAlign(Alignment.CENTER);
        countryCodeField.setType(ListGridFieldType.IMAGE);
        countryCodeField.setImageURLPrefix("flags/16/");
        countryCodeField.setImageURLSuffix(".png");

        ListGridField nameField = new ListGridField("countryName", "Country");
        ListGridField capitalField = new ListGridField("capital", "Capital");
        ListGridField continentField = new ListGridField("continent", "Continent");
        countryGrid.setFields(countryCodeField, nameField, capitalField, continentField);

        countryGrid.setData(CountrySampleData.getRecords());
        countryGrid.addSelectionUpdatedHandler(new SelectionUpdatedHandler() {
            public void onSelectionUpdated(SelectionUpdatedEvent event) {
                selectedCountriesGrid.setData(countryGrid.getSelection());
            }
        });

        canvas.addChild(countryGrid);
        canvas.addChild(selectedCountriesGrid);

        return canvas;
    }

    public String getIntro() {
        return DESCRIPTION;
    }

}