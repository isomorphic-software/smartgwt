package com.smartgwt.sample.showcase.client.offline;

import com.smartgwt.client.data.Criteria;
import com.smartgwt.client.util.Offline;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.events.RecordDoubleClickEvent;
import com.smartgwt.client.widgets.grid.events.RecordDoubleClickHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.tree.TreeGrid;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;
import com.smartgwt.sample.showcase.client.data.ItemSupplyXmlDS;
import com.smartgwt.sample.showcase.client.data.SupplyCategoryXmlDS;

public class OfflineDataSourceSupportSample extends ShowcasePanel {

    private static final String DESCRIPTION = "<p>Smart GWT has support for caching server responses in browser storage, " +
            "allowing these cached responses to be returned to an application at some future point when the application is offline. " +
            "Offline support is automatic once enabled - if the user switches the application or browser into offline mode, or the browser " +
            "detects that it is offline, the framework automatically and transparently starts returning cached responses whenever it can " +
            "(application code can determine that responses have come from offline cache if necessary)</p>" + "" +
            "<p>Use the tree to navigate categories; double-click a category to load the grid with matching items. Now reload the page and click \"Go offline\" " +
            "(or switch your browser into offline mode). If you double-click a category that you selected before the reload, you will see that the grid is still populated " +
            "from the Offline cache; if you double-click a category you did not previously select, or attempt to open a node in the tree that you did not previously open, " +
            "you will get the \"Data not available while offline\" message.</p>";

    public static class Factory implements PanelFactory {
        private String id;

        public ShowcasePanel create() {
            OfflineDataSourceSupportSample panel = new OfflineDataSourceSupportSample();
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
        // Enable offline storage for the two DataSources
        ItemSupplyXmlDS itemSupplyXmlDS =  ItemSupplyXmlDS.getInstance();
        itemSupplyXmlDS.setUseOfflineStorage(true);

        SupplyCategoryXmlDS supplyCategoryXmlDS = SupplyCategoryXmlDS.getInstance();
        //supplyCategoryXmlDS.setUseOfflineStorage(true);

        final ListGrid itemListGrid = new ListGrid();
        itemListGrid.setWidth(350);
        itemListGrid.setHeight(224);
        itemListGrid.setDataSource(itemSupplyXmlDS);
        ListGridField itemIdField = new ListGridField("itemID");
        ListGridField itemNameField = new ListGridField("itemName");
        ListGridField unitCostField = new ListGridField("unitCost");
        ListGridField categoryField = new ListGridField("category");
        itemListGrid.setFields(itemIdField, itemNameField, unitCostField, categoryField);


        TreeGrid categoryTree = new TreeGrid();
        categoryTree.setWidth(250);
        categoryTree.setHeight(224);
        categoryTree.setDataSource(supplyCategoryXmlDS);
        categoryTree.setLoadDataOnDemand(true);
        categoryTree.setAutoFetchData(true);
        categoryTree.addRecordDoubleClickHandler(new RecordDoubleClickHandler() {
            @Override
            public void onRecordDoubleClick(RecordDoubleClickEvent event) {
                final String categoryName = event.getRecord().getAttribute("categoryName");
                Criteria criteria = new Criteria("category", categoryName);
                itemListGrid.filterData(criteria);
            }
        });

        HLayout hLayout = new HLayout(10);
        hLayout.setMembers(categoryTree, itemListGrid);

        VLayout layout = new VLayout(10);

        final IButton button = new IButton("Go Offline", new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                final IButton source = (IButton) event.getSource();
                if(source.getTitle().equals("Go Offline")) {
                    Offline.goOffline();
                    source.setTitle("Go Online");
                } else {
                    Offline.goOnline();
                    source.setTitle("Go Offline");
                }
            }
        });
        layout.setMembers(hLayout, button);
        layout.setAutoHeight();

        return layout;
    }

    public String getIntro() {
        return DESCRIPTION;
    }
}
