package com.smartgwt.sample.showcase.client.grid.dataoperation;

import com.smartgwt.client.rpc.RPCManager;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.layout.HStack;
import com.smartgwt.client.widgets.layout.VLayout;
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

        public ShowcasePanel create() {
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
        VLayout vLayout = new VLayout();
        vLayout.setMembersMargin(15);

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
        
        IButton removeFirst = new IButton("Remove first");
        removeFirst.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				countryGrid.removeData(countryGrid.getRecord(0));				
			}        	
        });
        removeFirst.setWidth(140);

        IButton removeSelected = new IButton("Remove first selected");
        removeSelected.setAutoFit(true);
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
        removeSelected.setMinWidth(140);

        IButton removeAll = new IButton("Remove all selected");
        removeAll.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				ListGridRecord[] selectedRecords = countryGrid.getSelection();
                boolean wasQueuing = RPCManager.startQueue();
				for(ListGridRecord rec: selectedRecords) {
					countryGrid.removeData(rec);
				}
                if (!wasQueuing) RPCManager.sendQueue();
			}        	
        });
        removeAll.setWidth(140);

        HStack hStack = new HStack();
        hStack.setWidth100();
        hStack.setMembersMargin(20);
        hStack.addMember(removeFirst);
        hStack.addMember(removeSelected);
        hStack.addMember(removeAll);

        vLayout.addMember(countryGrid);
        vLayout.addMember(hStack);

        return vLayout;
    	
    }

    public String getIntro() {
        return DESCRIPTION;
    }
        
    @Override
    protected boolean shouldWrapViewPanel() {
        return true;
    }

}