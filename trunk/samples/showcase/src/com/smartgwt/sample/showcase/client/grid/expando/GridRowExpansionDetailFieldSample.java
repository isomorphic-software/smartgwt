package com.smartgwt.sample.showcase.client.grid.expando;

import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.ExpansionMode;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;
import com.smartgwt.sample.showcase.client.data.CountryData;

public class GridRowExpansionDetailFieldSample extends ShowcasePanel {
    private static final String DESCRIPTION =
            "<p>This grid displays some fields from the Countries dataSource. You can expand a row by clicking the special " +
                    "expansionField to see the details of the selected country's background in the expanded section.</p>";

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
            GridRowExpansionDetailFieldSample panel = new GridRowExpansionDetailFieldSample();
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

        ListGrid listGrid = new ListGrid() {
            @Override
            protected Canvas getExpansionComponent(ListGridRecord record) {
                Canvas canvas = super.getExpansionComponent(record);
                canvas.setMargin(5);
                return canvas;
            }
        };
        listGrid.setWidth(600);
        listGrid.setHeight(500);
        listGrid.setCanExpandRecords(true);
        listGrid.setExpansionMode(ExpansionMode.DETAIL_FIELD);
        listGrid.setDetailField("background");

        ListGridField nameField = new ListGridField("countryName", "Country");
        ListGridField capitalField = new ListGridField("capital", "Capital");
        ListGridField continentField = new ListGridField("continent", "Continent");
        listGrid.setFields(nameField, capitalField, continentField);

        listGrid.setData(CountryData.getRecords());

        return listGrid;
    }


    public String getIntro() {
        return DESCRIPTION;
    }
}
