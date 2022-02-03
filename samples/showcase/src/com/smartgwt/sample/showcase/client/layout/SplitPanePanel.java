package com.smartgwt.sample.showcase.client.layout;

import com.smartgwt.client.data.Record;
import com.smartgwt.client.util.Browser;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.events.SelectionUpdatedEvent;
import com.smartgwt.client.widgets.grid.events.SelectionUpdatedHandler;
import com.smartgwt.client.widgets.grid.events.RecordClickEvent;    
import com.smartgwt.client.widgets.grid.events.RecordClickHandler;
import com.smartgwt.client.widgets.tree.events.NodeClickEvent;    
import com.smartgwt.client.widgets.tree.events.NodeClickHandler;
import com.smartgwt.client.widgets.layout.SplitPane;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.tree.TreeGrid;
import com.smartgwt.client.widgets.viewer.DetailViewer;
import com.smartgwt.sample.showcase.client.data.ItemSupplyXmlDS;
import com.smartgwt.sample.showcase.client.data.SupplyCategoryXmlDS;

public class SplitPanePanel extends VLayout {

    public Canvas createSplitPane() {
        final SplitPane splitPane = new SplitPane();

        final DetailViewer detailPane = new DetailViewer();
        detailPane.setDataSource(ItemSupplyXmlDS.getInstance());

        final ListGrid listPane = new ListGrid();
        listPane.setDataSource(ItemSupplyXmlDS.getInstance());
        listPane.addRecordClickHandler(new RecordClickHandler() {    
            @Override    
            public void onRecordClick(RecordClickEvent event) {    
                detailPane.viewSelectedData(listPane);    
                splitPane.setDetailTitle((event.getRecordNum() + 1) + " of " + listPane.getTotalRows());    
                splitPane.showDetailPane();    
            }    
        }); 
        
        if (Browser.getIsTablet()) {
            ListGridField itemNameField = new ListGridField("itemName");
            ListGridField unitCostField = new ListGridField("unitCost");
            ListGridField inStockField = new ListGridField("inStock");
            listPane.setFields(itemNameField, unitCostField, inStockField);
        }

        final TreeGrid navigationPane = new TreeGrid();
        navigationPane.setDataSource(SupplyCategoryXmlDS.getInstance());
        navigationPane.setAutoFetchData(true);
        navigationPane.setShowHeader(Browser.getIsDesktop());
        navigationPane.addNodeClickHandler(new NodeClickHandler() {    
                
            @Override    
            public void onNodeClick(NodeClickEvent event) {    
                listPane.fetchRelatedData(event.getNode(), navigationPane);    
                splitPane.setListTitle(event.getNode().getAttribute("categoryName"));    
                splitPane.showListPane();    
            }    
        }); 
        navigationPane.addSelectionUpdatedHandler(new SelectionUpdatedHandler() {
            @Override
            public void onSelectionUpdated(SelectionUpdatedEvent event) {
                splitPane.setDetailTitle(null);
                detailPane.setData(new Record[0]);
            }
        });

        splitPane.setNavigationTitle("Categories");
        splitPane.setShowLeftButton(false);
        splitPane.setShowRightButton(false);
        splitPane.setBorder("1px solid blue");
        splitPane.setDetailPane(detailPane);
        splitPane.setListPane(listPane);
        splitPane.setNavigationPane(navigationPane);
        splitPane.setAutoNavigate(false);
        return splitPane;
    }

    public SplitPanePanel() {
        setWidth100();
        setHeight100();
        addMember(createSplitPane());
    }
}
