package com.smartgwt.sample.showcase.client.grid.editing;

import com.google.gwt.i18n.client.NumberFormat;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.ListGridEditEvent;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.grid.CellFormatter;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;
import com.smartgwt.sample.showcase.client.data.CountryXmlDS;

public class GridEditByCellSample extends ShowcasePanel {
    private static final String DESCRIPTION = "<p><b>Click</b> on any cell to start editing. Use <b>Tab</b>, <b>Shift-Tab</b>," +
            "<b>Up Arrow</b>, and <b>Down Arrow</b> to move between cells.</p><p>Press <b>Enter</b> to save the current row " +
            "and dismiss the editors, or <b>Esc</b> to discard changes for the current cell and dismiss" +
            "the editors.</p>";

    public static class Factory implements PanelFactory {
        private String id;

        public ShowcasePanel create() {
            GridEditByCellSample panel = new GridEditByCellSample();
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

        final ListGrid countryGrid = new ListGrid();
        countryGrid.setWidth(600);
        countryGrid.setHeight(224);
        countryGrid.setShowAllRecords(true);
        // use server-side dataSource so edits are retained across page transitions
        countryGrid.setDataSource(CountryXmlDS.getInstance());

        ListGridField countryCodeField = new ListGridField("countryCode", "Flag", 40);
        countryCodeField.setAlign(Alignment.CENTER);
        countryCodeField.setType(ListGridFieldType.IMAGE);
        countryCodeField.setImageURLPrefix("flags/16/");
        countryCodeField.setImageURLSuffix(".png");
        countryCodeField.setCanEdit(false);

        ListGridField nameField = new ListGridField("countryName", "Country");
        ListGridField continentField = new ListGridField("continent", "Continent");
        ListGridField memberG8Field = new ListGridField("member_g8", "Member G8");
        ListGridField populationField = new ListGridField("population", "Population");
        populationField.setType(ListGridFieldType.INTEGER);
        ListGridField independenceField = new ListGridField("independence", "Independence", 130);
        countryGrid.setFields(countryCodeField, nameField,continentField, memberG8Field, populationField, independenceField);

        countryGrid.setAutoFetchData(true);
        countryGrid.setCanEdit(true);
        countryGrid.setEditEvent(ListGridEditEvent.CLICK);
        countryGrid.setEditByCell(true);

        return countryGrid;
    }


    public String getIntro() {
        return DESCRIPTION;
    }


}