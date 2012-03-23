package com.smartgwt.sample.showcase.client.grid.dataoperation;

import com.smartgwt.client.types.SelectionStyle;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;
import com.smartgwt.sample.showcase.client.data.WorldXmlDS;

public class GridDataBoundUpdateSample extends ShowcasePanel {
    private static final String DESCRIPTION = "Click to select any record in the list, then click one of the buttons "
    	+ "to change the \"Continent\" value for that record on the server. Also see the Grids > Editing examples for "
    	+ "automatic databound Update operations triggered by user input.";

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
            GridDataBoundUpdateSample panel = new GridDataBoundUpdateSample();
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
		countryGrid.setDataSource(WorldXmlDS.getInstance());
        

        ListGridField countryCodeField = new ListGridField("countryCode", "Country Code");
        ListGridField nameField = new ListGridField("countryName", "Country");
        ListGridField capitalField = new ListGridField("capital", "Capital");
        ListGridField continentField = new ListGridField("continent", "Continent");
        countryGrid.setFields(countryCodeField, nameField, capitalField, continentField);
        
        countryGrid.setSortField(1);
        countryGrid.setDataPageSize(50);
        countryGrid.setAutoFetchData(true);
        countryGrid.setSelectionType(SelectionStyle.SINGLE);
        
        IButton changeEurope = new IButton("Continent -> Europe");
        changeEurope.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				ListGridRecord selectedRecord = countryGrid.getSelectedRecord();
				if(selectedRecord != null) {
                    ListGridRecord newRecord = new ListGridRecord();
                    newRecord.setAttribute("pk", selectedRecord.getAttribute("pk"));
                    newRecord.setAttribute("continent", "Europe");
					countryGrid.updateData(newRecord);
				}
			}        	
        });
        changeEurope.setLeft(0);
        changeEurope.setTop(240);
        changeEurope.setWidth(140);
        
        IButton changeAsia = new IButton("Continent -> Asia");
        changeAsia.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				ListGridRecord selectedRecord = countryGrid.getSelectedRecord();
				if(selectedRecord != null) {
                    ListGridRecord newRecord = new ListGridRecord();
                    newRecord.setAttribute("pk", selectedRecord.getAttribute("pk"));
                    newRecord.setAttribute("continent", "Asia");
					countryGrid.updateData(newRecord);
				}
			}        	
        });
        changeAsia.setLeft(160);
        changeAsia.setTop(240);
        changeAsia.setWidth(140);


        
        canvas.addChild(countryGrid);
        canvas.addChild(changeEurope);
        canvas.addChild(changeAsia);

        return canvas;
    	
    }

    public String getIntro() {
        return DESCRIPTION;
    }

}