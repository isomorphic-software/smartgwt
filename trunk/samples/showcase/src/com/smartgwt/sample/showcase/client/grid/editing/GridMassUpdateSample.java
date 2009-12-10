package com.smartgwt.sample.showcase.client.grid.editing;

import com.google.gwt.i18n.client.NumberFormat;
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

public class GridMassUpdateSample extends ShowcasePanel {
    
    private static final String DESCRIPTION = "<p>Click on any cell to start editing, then <b>Tab</b> or <b>Down Arrow</b> past the last " +
            "row in the grid to create a new row.</p>" +
            "<p>Alternatively, click the Edit New button to create a new data-entry row at the end of the grid. Unlike the other editing examples, " +
            "none of your changes are being automatically saved to the server. Note how Smart GWT highlights changed values, and new rows.</p>" +
            "<p>Click the \"Save\" button to save all your changes at once, or click the \"Discard\" button to discard all your changes " +
            "(including any new rows) and revert to the data as it was before you started editing.</p>";

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
            GridMassUpdateSample panel = new GridMassUpdateSample();
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
        countryGrid.setCellHeight(22);
        countryGrid.setDataSource(CountryXmlDS.getInstance());

        ListGridField nameField = new ListGridField("countryName", "Country");
        ListGridField continentField = new ListGridField("continent", "Continent");
        ListGridField memberG8Field = new ListGridField("member_g8", "Member G8");
        ListGridField populationField = new ListGridField("population", "Population");
        populationField.setType(ListGridFieldType.INTEGER);
        populationField.setCellFormatter(new CellFormatter() {
            public String format(Object value, ListGridRecord record, int rowNum, int colNum) {
                if(value == null) {
                    return null;
                }
                NumberFormat nf = NumberFormat.getFormat("0,000");
                try {
                    return nf.format(((Number) value).longValue());
                } catch (Exception e) {
                    return value.toString();
                }
            }
        });
        ListGridField independenceField = new ListGridField("independence", "Independence");
        countryGrid.setFields(nameField,continentField, memberG8Field, populationField, independenceField);

        countryGrid.setAutoFetchData(true);
        countryGrid.setCanEdit(true);
        countryGrid.setModalEditing(true);
        countryGrid.setEditEvent(ListGridEditEvent.CLICK);
        countryGrid.setListEndEditAction(RowEndEditAction.NEXT);
        countryGrid.setAutoSaveEdits(false);
        canvas.addChild(countryGrid);

        IButton editButton = new IButton("Edit New");
        editButton.setTop(250);
        editButton.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                countryGrid.startEditingNew();
            }
        });
        canvas.addChild(editButton);

        IButton saveButton = new IButton("Save");
        saveButton.setTop(250);
        saveButton.setLeft(110);
        saveButton.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                countryGrid.saveAllEdits();
            }
        });
        canvas.addChild(saveButton);

        IButton discardButton = new IButton("Discard");
        discardButton.setTop(250);
        discardButton.setLeft(220);
        discardButton.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                countryGrid.discardAllEdits();
            }
        });
        canvas.addChild(discardButton);

        return canvas;
    }


    public String getIntro() {
        return DESCRIPTION;
    }
}