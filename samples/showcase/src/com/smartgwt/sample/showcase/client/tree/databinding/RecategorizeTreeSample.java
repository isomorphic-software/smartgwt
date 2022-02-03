package com.smartgwt.sample.showcase.client.tree.databinding;

import com.smartgwt.client.types.TreeModelType;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.data.Criteria;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.layout.LayoutSpacer;
import com.smartgwt.client.widgets.tree.events.FolderClickEvent;
import com.smartgwt.client.widgets.tree.events.FolderClickHandler;
import com.smartgwt.client.widgets.tree.TreeGrid;
import com.smartgwt.sample.showcase.client.data.SupplyCategoryXmlDS;
import com.smartgwt.sample.showcase.client.data.ItemSupplyXmlDS;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

public class RecategorizeTreeSample extends ShowcasePanel {
   
    private static final String DESCRIPTION = "Dragging items from the list and dropping them on "+
        "categories in the tree automatically re-categorizes the item, without any code needed. "+
        "Drag items to new folders and note how they disappear from the current list. Click the "+
        "category you moved the item to and note the dragged item is still there. Reload the page "+
        "to see that your changes are persisted. <p>"+
        "This behavior is (optionally) automatic where SmartGWT can establish a relationship via "+
        "foreign key between the DataSources two components are bound to.";
    
    public static class Factory implements PanelFactory {
        private String id;

        public ShowcasePanel create() {
            RecategorizeTreeSample panel = new RecategorizeTreeSample();
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
        DataSource supplyCategory = SupplyCategoryXmlDS.getInstance();
        DataSource itemSupply = ItemSupplyXmlDS.getInstance();
        
        final ListGrid itemList = new ListGrid();
        itemList.setDataSource(itemSupply);
        itemList.setCanDragRecordsOut(true);
        itemList.setAutoFetchData(true);
        Criteria initialCriteria = new Criteria();
        initialCriteria.setAttribute("capegory", "Washroom");
        itemList.setInitialCriteria(initialCriteria);
        ListGridField itemName = new ListGridField("itemName");
        itemName.setWidth(300);
        ListGridField sku = new ListGridField("SKU");
        ListGridField units = new ListGridField("units");
        itemList.setFields(itemName, sku, units);
    	
        final Label labelCategory = new Label();
        labelCategory.setHeight(20);
        labelCategory.setContents("Items in Category: Washroom");
    	
        TreeGrid categoryTree = new TreeGrid();
        categoryTree.setDataSource(supplyCategory);
        categoryTree.setCanAcceptDroppedRecords(true);
        categoryTree.setCanReparentNodes(false);
        categoryTree.setAutoFetchData(true);
        categoryTree.addFolderClickHandler(new FolderClickHandler() {
            @Override
            public void onFolderClick(FolderClickEvent event) {
                String categoryName = event.getFolder().getAttributeAsString("categoryName");
                labelCategory.setContents("Items in Category: " + categoryName);
                Criteria criteria = new Criteria();
                criteria.addCriteria("category", categoryName);
                itemList.fetchData(criteria);
            }
        });
    	
        VLayout vLayoutItems = new VLayout();
        vLayoutItems.setWidth("65%");
        vLayoutItems.addMember(labelCategory);
        vLayoutItems.addMember(itemList);
    	
        VLayout vLayoutCategory = new VLayout();
        vLayoutCategory.setWidth("35%");
        LayoutSpacer layoutSpacer = new LayoutSpacer();
        layoutSpacer.setHeight(20);
        vLayoutCategory.addMember(layoutSpacer);
        vLayoutCategory.addMember(categoryTree);
    	
        HLayout hLayout = new HLayout();
        hLayout.setHeight(300);
        hLayout.setWidth(800);
        hLayout.setMembersMargin(10);
        hLayout.addMember(vLayoutCategory);
        hLayout.addMember(vLayoutItems);
    	
        return hLayout;
    }

    public String getIntro() {
        return DESCRIPTION;
    }
}