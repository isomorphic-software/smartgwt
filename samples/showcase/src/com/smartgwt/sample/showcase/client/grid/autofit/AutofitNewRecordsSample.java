package com.smartgwt.sample.showcase.client.grid.autofit;

import com.smartgwt.client.types.Autofit;
import com.smartgwt.client.types.ListGridEditEvent;
import com.smartgwt.client.types.RowEndEditAction;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

public class AutofitNewRecordsSample extends ShowcasePanel {

    private static final String DESCRIPTION = "Autofit to rows can be made subject to a maximum. Add new rows to the grid, " +
            "and note that the grid expands to show the new rows. It stops expanding once you have more than 6 rows.";

    public static class Factory implements PanelFactory {
        private String id;

        public ShowcasePanel create() {
            AutofitNewRecordsSample panel = new AutofitNewRecordsSample();
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

    public ListGridRecord createRecord(String countryCode, String countryName, int population) {
        ListGridRecord record = new ListGridRecord();
    	record.setAttribute("countryCode", countryCode);
    	record.setAttribute("countryName", countryName);
    	record.setAttribute("population", population);
        return record;
    }

    public Canvas getViewPanel() {

        ListGridRecord[] data = new ListGridRecord[]{
                createRecord("US", "United States", 298444215),
                createRecord("CH", "China", 1313973713),
                createRecord("JA", "Japan", 127463611)
        };

        final ListGrid countryGrid = new ListGrid();
        countryGrid.setWidth(500);
        countryGrid.setAutoFitMaxRecords(6);
        countryGrid.setAutoFitData(Autofit.VERTICAL);
        countryGrid.setCanEdit(true);
        countryGrid.setEditEvent(ListGridEditEvent.CLICK);
        countryGrid.setListEndEditAction(RowEndEditAction.NEXT);

        ListGridField countryCodeField = new ListGridField("countryCode", "Country Code");
        ListGridField nameField = new ListGridField("countryName", "Country");
        ListGridField populationField = new ListGridField("population", "Population");

        countryGrid.setFields(countryCodeField, nameField, populationField);
        countryGrid.setData(data);

        IButton button = new IButton("Edit New");
        button.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                countryGrid.startEditingNew();
            }
        });

        VLayout vLayout = new VLayout(20);
        vLayout.addMember(countryGrid);
        vLayout.addMember(button);

        return vLayout;

    }

    // match topology of SmartClient FE Sample
    @Override
    protected boolean shouldWrapViewPanel() {
        return true;
    }

    public String getIntro() {
        return DESCRIPTION;
    }
}