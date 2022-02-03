package com.smartgwt.sample.showcase.client.grid.editing;

import com.google.gwt.i18n.client.NumberFormat;
import com.smartgwt.client.types.ListGridEditEvent;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.form.fields.SpinnerItem;
import com.smartgwt.client.widgets.form.fields.TextAreaItem;
import com.smartgwt.client.widgets.grid.CellFormatter;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;
import com.smartgwt.sample.showcase.client.data.CountryXmlDS;

public class GridCustomEditorsSample extends ShowcasePanel {
    private static final String DESCRIPTION = "<b>Click</b> on any cell to start editing. The \"Government\", \"Population\", "+
        "and \"Nationhood\" columns specify custom editors. In this example, they are a multiple-line Text Area, a Numeric "+
        "Spinner and a Compound Date Control.";

    public static class Factory implements PanelFactory {
        private String id;

        public ShowcasePanel create() {
            GridCustomEditorsSample panel = new GridCustomEditorsSample();
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
        countryGrid.setWidth(620);
        countryGrid.setHeight(224);
        countryGrid.setShowAllRecords(true);
        countryGrid.setCellHeight(42);
        countryGrid.setWrapCells(true);
        countryGrid.setDataSource(CountryXmlDS.getInstance());

        ListGridField nameField = new ListGridField("countryName", "Country", 100);


        ListGridField governmentField = new ListGridField("government", "Government", 175);

        TextAreaItem textAreaItem = new TextAreaItem();
        textAreaItem.setHeight(70);
        governmentField.setEditorProperties(textAreaItem);

        ListGridField populationField = new ListGridField("population", "Population", 100);
        populationField.setEditorProperties(new SpinnerItem());
        populationField.setType(ListGridFieldType.INTEGER);

        ListGridField independenceField = new ListGridField("independence", "Independence", 225);
        DateItem dateItem = new DateItem();
        dateItem.setUseTextField(false);
        independenceField.setEditorProperties(dateItem);

        countryGrid.setFields(nameField, governmentField, populationField, independenceField);

        countryGrid.setAutoFetchData(true);
        countryGrid.setCanEdit(true);
        countryGrid.setEditEvent(ListGridEditEvent.CLICK);

        return countryGrid;
    }


    public String getIntro() {
        return DESCRIPTION;
    }
}
