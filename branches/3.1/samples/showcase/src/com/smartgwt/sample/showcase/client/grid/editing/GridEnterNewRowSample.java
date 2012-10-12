package com.smartgwt.sample.showcase.client.grid.editing;

import com.google.gwt.i18n.client.NumberFormat;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.ListGridEditEvent;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.types.RowEndEditAction;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.grid.CellFormatter;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;
import com.smartgwt.sample.showcase.client.data.CountryXmlDS;

public class GridEnterNewRowSample extends ShowcasePanel {
    private static final String DESCRIPTION = "<p><b>Click</b> on any cell to start editing, then <b>Tab</b> or <b>Down Arrow</b> past the" +
            " last row in the grid to create a new row.</p><p>Alternatively, click the <b>Edit New</b> button" +
            " to create a new data-entry row at the end of the grid.</p>";

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
            GridEnterNewRowSample panel = new GridEnterNewRowSample();
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
        countryGrid.setWidth(550);
        countryGrid.setHeight(224);
        countryGrid.setShowAllRecords(true);
        countryGrid.setCellHeight(22);
        countryGrid.setID("countryList");
        countryGrid.setDataSource(CountryXmlDS.getInstance());

        ListGridField countryCodeField = new ListGridField("countryCode", "Flag", 40);
        countryCodeField.setAlign(Alignment.CENTER);
        countryCodeField.setType(ListGridFieldType.IMAGE);
        countryCodeField.setImageURLPrefix("flags/16/");
        countryCodeField.setImageURLSuffix(".png");
        countryCodeField.setCanEdit(false);
        countryCodeField.setRequired(false);

        ListGridField nameField = new ListGridField("countryName", "Country");
        ListGridField continentField = new ListGridField("continent", "Continent");
        ListGridField memberG8Field = new ListGridField("member_g8", "Member G8");
        ListGridField populationField = new ListGridField("population", "Population");
        populationField.setType(ListGridFieldType.INTEGER);
        populationField.setCellFormatter(new CellFormatter() {
            public String format(Object value, ListGridRecord record, int rowNum, int colNum) {
                if(value != null) {
                    NumberFormat nf = NumberFormat.getFormat("0,000");
                    try {
                        return nf.format(((Number) value).longValue());
                    } catch (Exception e) {
                        return value.toString();
                    }
                } else {
                    return null;
                }
            }
        });
        ListGridField independenceField = new ListGridField("independence", "Independence");
        countryGrid.setFields(countryCodeField, nameField, continentField, memberG8Field, populationField, independenceField);

        countryGrid.setAutoFetchData(true);
        countryGrid.setCanEdit(true);
        countryGrid.setEditEvent(ListGridEditEvent.CLICK);
        countryGrid.setListEndEditAction(RowEndEditAction.NEXT);
        canvas.addChild(countryGrid);

        IButton button = new IButton("Edit New");
        button.setTop(250);
        button.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                countryGrid.startEditingNew();
            }
        });
        canvas.addChild(button);

        return canvas;
    }


    public String getIntro() {
        return DESCRIPTION;
    }
}