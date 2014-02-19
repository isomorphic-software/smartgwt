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

public class GridDataBoundFetchSample extends ShowcasePanel {
    private static final String DESCRIPTION = "Click the buttons to fetch (exact match) country records from the server. "
    	                                      + "Click the \"Fetch All\" button to fetch the first \"page\" of 50 records, "
    	                                      + "then scroll the grid to fetch new pages of data on demand.";

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
            GridDataBoundFetchSample panel = new GridDataBoundFetchSample();
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
        countryGrid.setDrawAheadRatio(4);
        
        IButton fetchUS = new IButton("Fetch Code:US");
        fetchUS.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				countryGrid.fetchData(new Criteria("countryCode", "US"));				
			}        	
        });
        fetchUS.setLeft(0);
        fetchUS.setTop(240);
        fetchUS.setWidth(140);
        
        IButton fetchEurope = new IButton("Fetch Continent:Europe");
        fetchEurope.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				countryGrid.fetchData(new Criteria("continent", "Europe"));				
			}
        	
        });
        fetchEurope.setLeft(160);
        fetchEurope.setTop(240);
        fetchEurope.setWidth(140);

        IButton fetchAll = new IButton("Fetch All");
        fetchAll.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				countryGrid.fetchData();				
			}
        	
        });
        fetchAll.setLeft(320);
        fetchAll.setTop(240);
        fetchAll.setWidth(140);
        
        canvas.addChild(countryGrid);
        canvas.addChild(fetchUS);
        canvas.addChild(fetchEurope);
        canvas.addChild(fetchAll);

        return canvas;
    }

    public String getIntro() {
        return DESCRIPTION;
    }

}