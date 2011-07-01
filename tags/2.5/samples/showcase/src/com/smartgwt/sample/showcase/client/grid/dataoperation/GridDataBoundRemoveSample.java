package com.smartgwt.sample.showcase.client.grid.dataoperation;

import com.smartgwt.client.util.SC;
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

public class GridDataBoundRemoveSample extends ShowcasePanel {
    private static final String DESCRIPTION = "Click \"Remove first\" to remove (delete) the first record in the list from the server. " 
    	                                     + "Click the other buttons to remove records based on your selection (click, Ctrl-click, or Shift-click " 
    	                                     + "in the list to select records).";

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
            GridDataBoundRemoveSample panel = new GridDataBoundRemoveSample();
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
        
        IButton removeFirst = new IButton("Remove First");
        removeFirst.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				countryGrid.removeData(countryGrid.getRecord(0));				
			}        	
        });
        removeFirst.setLeft(0);
        removeFirst.setTop(240);
        removeFirst.setWidth(145);

        IButton removeSelected = new IButton("Remove First Selected");
        removeSelected.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				ListGridRecord selectedRecord = countryGrid.getSelectedRecord();
				if(selectedRecord != null) {
					countryGrid.removeData(selectedRecord);
				} else {
					SC.say("Select a record before performing this action");
				}
			}
        	
        });
        removeSelected.setLeft(160);
        removeSelected.setTop(240);
        removeSelected.setWidth(150);

        IButton removeAll = new IButton("Remove All Selected");
        removeAll.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				ListGridRecord[] selectedRecords = countryGrid.getSelection();
				for(ListGridRecord rec: selectedRecords) {
					countryGrid.removeData(rec);
				}
			}        	
        });
        removeAll.setLeft(320);
        removeAll.setTop(240);
        removeAll.setWidth(140);
        
        canvas.addChild(countryGrid);
        canvas.addChild(removeFirst);
        canvas.addChild(removeSelected);
        canvas.addChild(removeAll);

        return canvas;
    	
    }

    public String getIntro() {
        return DESCRIPTION;
    }

}