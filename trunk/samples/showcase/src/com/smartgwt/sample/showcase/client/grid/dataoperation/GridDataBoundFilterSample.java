package com.smartgwt.sample.showcase.client.grid.dataoperation;

import com.smartgwt.client.data.Criteria;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;
import com.smartgwt.sample.showcase.client.data.WorldXmlDS;

public class GridDataBoundFilterSample extends ShowcasePanel {
    private static final String DESCRIPTION = "Click the buttons to filter (partial match) records from the server. "
    	                                      + "Also see the Grids > Sort & filter > Filter example for automatic databound  "
    	                                      + "Filter operations triggered by user input.";

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
            GridDataBoundFilterSample panel = new GridDataBoundFilterSample();
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
        
        IButton filterUnited = new IButton("Filter Country:United");
        filterUnited.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				countryGrid.filterData(new Criteria("countryName", "United"));				
			}        	
        });
        filterUnited.setLeft(0);
        filterUnited.setTop(240);
        filterUnited.setWidth(140);
        
        IButton filterPort = new IButton("Filter Capital:port");
        filterPort.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				countryGrid.filterData(new Criteria("capital", "port"));				
			}
        	
        });
        filterPort.setLeft(160);
        filterPort.setTop(240);
        filterPort.setWidth(140);

        IButton clearFilter = new IButton("Clear Filter");
        clearFilter.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				countryGrid.clearCriteria();			
			}
        	
        });
        clearFilter.setLeft(320);
        clearFilter.setTop(240);
        clearFilter.setWidth(140);
        
        canvas.addChild(countryGrid);
        canvas.addChild(filterUnited);
        canvas.addChild(filterPort);
        canvas.addChild(clearFilter);

        return canvas;
    	
    }

    public String getIntro() {
        return DESCRIPTION;
    }

}