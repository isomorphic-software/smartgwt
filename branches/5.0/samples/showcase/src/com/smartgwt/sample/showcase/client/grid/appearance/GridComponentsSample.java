package com.smartgwt.sample.showcase.client.grid.appearance;

import com.smartgwt.client.data.RecordList;
import com.smartgwt.client.data.ResultSet;
import com.smartgwt.client.data.events.DataChangedEvent;
import com.smartgwt.client.data.events.DataChangedHandler;
import com.smartgwt.client.types.ListGridComponent;
import com.smartgwt.client.types.ListGridEditEvent;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.LayoutSpacer;
import com.smartgwt.client.widgets.toolbar.ToolStrip;
import com.smartgwt.client.widgets.toolbar.ToolStripButton;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;
import com.smartgwt.sample.showcase.client.data.CountryXmlDS;

public class GridComponentsSample extends ShowcasePanel {

    private static final String DESCRIPTION = "ListGrids can be customized by changing the order of " +
            "standard components, and adding entirely custom components. In this example the filter " +
            "row is showing below the ListGrid header bar, and a custom set of controls has been " +
            "added underneath the body. ";
    public static class Factory implements PanelFactory {
        private String id;

        public ShowcasePanel create() {
            GridComponentsSample panel = new GridComponentsSample();
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
    
    private ListGrid countryGrid;
    private Label totalsLabel;
    
    public Canvas getViewPanel() {
        ToolStrip gridEditControls = new ToolStrip();
        gridEditControls.setWidth100();
        gridEditControls.setHeight(24);
        
        totalsLabel = new Label();
        totalsLabel.setPadding(5);
        
        LayoutSpacer spacer = new LayoutSpacer();
        spacer.setWidth("*");
        
        ToolStripButton editButton = new ToolStripButton();
        editButton.setIcon("[SKIN]/actions/edit.png");
        editButton.setPrompt("Edit selected record");
        editButton.addClickHandler(new ClickHandler() {
            
            @Override
            public void onClick(ClickEvent event) {
                ListGridRecord record = countryGrid.getSelectedRecord();
                if (record == null) return;
                countryGrid.startEditing(countryGrid.getDataAsRecordList().indexOf(record), 0, false);
                
            }
        });
        
        ToolStripButton removeButton = new ToolStripButton();
        removeButton.setIcon("[SKIN]/actions/remove.png");
        removeButton.setPrompt("Remove selected record");
        removeButton.addClickHandler(new ClickHandler() {
            
            @Override
            public void onClick(ClickEvent event) {
                countryGrid.removeSelectedData();
                
            }
        });
        
        gridEditControls.setMembers(totalsLabel, spacer, editButton, removeButton);
        
        ListGridField countryCode = new ListGridField("countryCode");
        ListGridField countryName = new ListGridField("countryName");
        ListGridField capital = new ListGridField("capital");
        ListGridField continent = new ListGridField("continent");

        countryGrid = new ListGrid();
        countryGrid.setFields(new ListGridField[] { countryCode, countryName, capital, continent });
        countryGrid.setWidth(500);
        countryGrid.setHeight(425);
        countryGrid.setDataSource(CountryXmlDS.getInstance());
        countryGrid.setAutoFetchData(true);
        countryGrid.setShowFilterEditor(true);
        countryGrid.setCanEdit(true);
        countryGrid.setEditEvent(ListGridEditEvent.NONE);
        
        ResultSet dataProperties = new ResultSet();
        dataProperties.addDataChangedHandler(new DataChangedHandler() {
            
            @Override
            public void onDataChanged(DataChangedEvent event) {
                RecordList data = countryGrid.getDataAsRecordList();
                
                if (data != null && data instanceof ResultSet && ((ResultSet)data).lengthIsKnown() && data.getLength() > 0) {
                    totalsLabel.setContents(data.getLength() + " Records");
                } else {
                    totalsLabel.setContents("&nbsp;");
                }
            }
        });
        countryGrid.setDataProperties(dataProperties);
        
        countryGrid.setGridComponents(new Object[] {
                ListGridComponent.HEADER, 
                ListGridComponent.FILTER_EDITOR, 
                ListGridComponent.BODY, 
                gridEditControls
        });
        
        return countryGrid;
    }

    public String getIntro() {
        return DESCRIPTION;
    }
}
