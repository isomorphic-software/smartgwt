package com.smartgwt.sample.showcase.client.layout;

import com.smartgwt.client.data.Record;
import com.smartgwt.client.util.Browser;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.events.SelectionUpdatedEvent;
import com.smartgwt.client.widgets.grid.events.SelectionUpdatedHandler;
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
        detailPane.setAutoDraw(false);
        detailPane.setDataSource(ItemSupplyXmlDS.getInstance());

        final ListGrid listPane = new ListGrid();
        listPane.setAutoDraw(false);
        listPane.setDataSource(ItemSupplyXmlDS.getInstance());
        if (Browser.getIsTablet()) {
            ListGridField itemNameField = new ListGridField("itemName");
            ListGridField unitCostField = new ListGridField("unitCost");
            ListGridField inStockField = new ListGridField("inStock");
            listPane.setFields(itemNameField, unitCostField, inStockField);
        }

        final TreeGrid navigationPane = new TreeGrid();
        navigationPane.setAutoDraw(false);
        navigationPane.setDataSource(SupplyCategoryXmlDS.getInstance());
        navigationPane.setAutoFetchData(true);
        navigationPane.setShowHeader(Browser.getIsDesktop());
        navigationPane.addSelectionUpdatedHandler(new SelectionUpdatedHandler() {
            @Override
            public void onSelectionUpdated(SelectionUpdatedEvent event) {
                splitPane.setDetailTitle(null);
                detailPane.setData(new Record[0]);
            }
        });

        splitPane.setAutoDraw(false);
        splitPane.setNavigationTitle("Categories");
        splitPane.setShowLeftButton(false);
        splitPane.setShowRightButton(false);
        splitPane.setBorder("1px solid blue");
        splitPane.setDetailPane(detailPane);
        splitPane.setListPane(listPane);
        splitPane.setNavigationPane(navigationPane);
        splitPane.setAutoNavigate(true);
        splitPane.setListPaneTitleTemplate("${record.categoryName}");
        splitPane.setDetailPaneTitleTemplate("${index + 1} of ${totalRows}");
        return splitPane;
    }

    public SplitPanePanel() {
        setWidth100();
        setHeight100();
        addMember(createSplitPane());
    }
}
