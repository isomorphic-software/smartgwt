package com.smartgwt.sample.showcase.client.grid.dataoperation;

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

public class GridDataBoundAddSample extends ShowcasePanel {
    private static final String DESCRIPTION = "Click the \"Add new country\" button to create a new country record on the server. "
    	                                      + "Also see the Grids > Editing > Enter new rows example for automatic databound Add operations triggered by user input.";

    public static class Factory implements PanelFactory {
        private String id;

        public ShowcasePanel create() {
            GridDataBoundAddSample panel = new GridDataBoundAddSample();
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
        countryGrid.setEmptyCellValue("-");
        countryGrid.setDataSource(WorldXmlDS.getInstance());

        ListGridField countryCodeField = new ListGridField("countryCode", "Country Code");
        ListGridField nameField = new ListGridField("countryName", "Country");
        ListGridField capitalField = new ListGridField("capital", "Capital");
        ListGridField continentField = new ListGridField("continent", "Continent");
        countryGrid.setFields(countryCodeField, nameField, capitalField, continentField);
        
        countryGrid.setSortField(0);
        countryGrid.setDataPageSize(50);
        countryGrid.setAutoFetchData(true);
        
        IButton addCountry = new IButton("Add new country");
        addCountry.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				ListGridRecord rec = new ListGridRecord();
				int number = getNextNumber();
				rec.setAttribute("countryCode", "A" + number);
				rec.setAttribute("countryName", "Country " + number);
				rec.setAttribute("capital", "Capital " + number);				
				countryGrid.addData(rec);				
			}        	
        });
        addCountry.setLeft(0);
        addCountry.setTop(240);
        addCountry.setWidth(140);
        
        
        canvas.addChild(countryGrid);
        canvas.addChild(addCountry);

        return canvas;
    	
    }
    
    private int counter = 1;
    
    private int getNextNumber() {
    	return counter++;
    }

    public String getIntro() {
        return DESCRIPTION;
    }

}