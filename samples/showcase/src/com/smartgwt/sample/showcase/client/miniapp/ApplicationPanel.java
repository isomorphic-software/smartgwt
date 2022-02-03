/*
 * Smart GWT (GWT for SmartClient)
 * Copyright 2008 and beyond, Isomorphic Software, Inc.
 *
 * Smart GWT is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License version 3
 * as published by the Free Software Foundation.  Smart GWT is also
 * available under typical commercial license terms - see
 * http://smartclient.com/license
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 */

package com.smartgwt.sample.showcase.client.miniapp;

import com.smartgwt.client.data.Criteria;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.CurrentPane;
import com.smartgwt.client.types.DeviceMode;
import com.smartgwt.client.types.VisibilityMode;
import com.smartgwt.client.util.Browser;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.FormItemCriteriaFunction;
import com.smartgwt.client.widgets.form.fields.FormItemFunctionContext;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.CellContextClickEvent;
import com.smartgwt.client.widgets.grid.events.CellContextClickHandler;
import com.smartgwt.client.widgets.grid.events.CellSavedEvent;
import com.smartgwt.client.widgets.grid.events.CellSavedHandler;
import com.smartgwt.client.widgets.grid.events.RecordClickEvent;
import com.smartgwt.client.widgets.grid.events.RecordClickHandler;
import com.smartgwt.client.widgets.grid.events.SelectionUpdatedEvent;
import com.smartgwt.client.widgets.grid.events.SelectionUpdatedHandler;
import com.smartgwt.client.widgets.layout.SectionStack;
import com.smartgwt.client.widgets.layout.SectionStackSection;
import com.smartgwt.client.widgets.layout.SplitPane;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.menu.Menu;
import com.smartgwt.client.widgets.menu.MenuItem;
import com.smartgwt.client.widgets.menu.events.MenuItemClickEvent;
import com.smartgwt.client.widgets.tree.TreeNode;
import com.smartgwt.client.widgets.tree.events.NodeClickEvent;
import com.smartgwt.client.widgets.tree.events.NodeClickHandler;
import com.smartgwt.sample.showcase.client.ShowcaseConfiguration;
import com.smartgwt.sample.showcase.client.data.ItemSupplyXmlDS;
import com.smartgwt.sample.showcase.client.data.SupplyCategoryXmlDS;

class ApplicationPanel extends SplitPane {

    private SearchForm searchForm;
    private CategoryTreeGrid categoryTree;
    private ItemListGrid itemList;
    private ItemDetailTabPane detailPane;
    private Menu itemListMenu;
	final boolean useDesktopMode = ShowcaseConfiguration.getSingleton().isOpenForTesting() || Browser.getIsDesktop();

    public ApplicationPanel() {
    	if (useDesktopMode) setDeviceMode(DeviceMode.DESKTOP);

        setWidth100();
        setHeight100();

        DataSource supplyCategoryDS = SupplyCategoryXmlDS.getInstance();
        DataSource supplyItemDS = ItemSupplyXmlDS.getInstance();

        categoryTree = new CategoryTreeGrid(supplyCategoryDS);
        categoryTree.setAutoFetchData(true);
        categoryTree.addSelectionUpdatedHandler(new SelectionUpdatedHandler() {
            @Override
            public void onSelectionUpdated(SelectionUpdatedEvent event) {
                if (categoryTree.getSelectedRecord() == null) {
                    itemList.setData(new Record[0]);
                    detailPane.clearDetails(null);
                }
            }
        });
        categoryTree.addNodeClickHandler(new NodeClickHandler() {
            public void onNodeClick(NodeClickEvent event) {
                TreeNode node = event.getNode();
                if (categoryTree.isSelected(node)) {
                    String category = node.getAttribute("categoryName");
                    findItems(category);
                    setCurrentPane(CurrentPane.LIST);
                }
            }
        });

        // Navigation
        SectionStack navigationPane = new SectionStack();
        navigationPane.setWidth(280);
        navigationPane.setVisibilityMode(VisibilityMode.MULTIPLE);
        navigationPane.setAnimateSections(true);

        SectionStackSection suppliesCategorySection = new SectionStackSection("");
        suppliesCategorySection.setShowHeader(false);
        suppliesCategorySection.setExpanded(true);
        suppliesCategorySection.setItems(categoryTree);

        SectionStackSection instructionsSection = new SectionStackSection("Instructions");
        instructionsSection.setItems(new HelpPane());
        instructionsSection.setExpanded(true);
        instructionsSection.setHidden(getDeviceMode()!=DeviceMode.DESKTOP);

        navigationPane.setSections(suppliesCategorySection, instructionsSection);

        // List
        VLayout listPane = new VLayout();

        searchForm = new SearchForm(supplyItemDS);
        searchForm.setHeight(60);
        searchForm.addFindListener(new com.smartgwt.client.widgets.form.fields.events.ClickHandler() {
        	public void onClick(com.smartgwt.client.widgets.form.fields.events.ClickEvent event) {
        		findItems(null);
        	}
        });

        //when showing options in the combo-box, only show the options from the selected category if appropriate
        final ComboBoxItem itemNameCB = searchForm.getItemNameField();
        itemNameCB.setPickListFilterCriteriaFunction(new FormItemCriteriaFunction() {
            @Override
            public Criteria getCriteria(FormItemFunctionContext itemContext) {
                ListGridRecord record = categoryTree.getSelectedRecord();
                if ((itemNameCB.getValue() != null) && record != null) {
                    Criteria criteria = new Criteria();
                    criteria.addCriteria("category", record.getAttribute("categoryName"));
                    return criteria;
                }
                return null;
            }
        });

        setupContextMenu();

        itemList = new ItemListGrid(supplyItemDS);
        itemList.addSelectionUpdatedHandler(new SelectionUpdatedHandler() {
            @Override
            public void onSelectionUpdated(SelectionUpdatedEvent event) {
                if (itemList.getSelectedRecord() == null) {
                    detailPane.clearDetails(categoryTree.getSelectedRecord());
                }
            }
        });
        itemList.addRecordClickHandler(new RecordClickHandler() {
            public void onRecordClick(RecordClickEvent event) {
            	detailPane.updateDetails();
            	setCurrentPane(CurrentPane.DETAIL);
            }
        });

        itemList.addCellSavedHandler(new CellSavedHandler() {
            public void onCellSaved(CellSavedEvent event) {
            	detailPane.updateDetails();
            }
        });

        itemList.addCellContextClickHandler(new CellContextClickHandler() {
            public void onCellContextClick(CellContextClickEvent event) {
                itemListMenu.showContextMenu();
                event.cancel();
            }
        });

        listPane.addMembers(searchForm, itemList);        

        // Detail
        detailPane = new ItemDetailTabPane(supplyItemDS, supplyCategoryDS, itemList);

        // Layout
        setDetailPane(detailPane);
        setDetailTitle("Item Details");
        setListPane(listPane);
        setListTitle("Items");
        setNavigationPane(navigationPane);
        setNavigationTitle("Categories");
    }

    private void setupContextMenu() {
        itemListMenu = new Menu();
        itemListMenu.setCellHeight(22);

        MenuItem detailsMenuItem = new MenuItem("Show Details", "silk/application_form.png");
        detailsMenuItem.addClickHandler(new com.smartgwt.client.widgets.menu.events.ClickHandler() {
            public void onClick(MenuItemClickEvent event) {
            	detailPane.selectTab(0);
            	detailPane.updateDetails();
            }
        });

        final MenuItem editMenuItem = new MenuItem("Edit Item", "demoApp/icon_edit.png");
        editMenuItem.addClickHandler(new com.smartgwt.client.widgets.menu.events.ClickHandler() {
            public void onClick(MenuItemClickEvent event) {
            	detailPane.selectTab(1);
            	detailPane.updateDetails();
            }
        });

        final MenuItem deleteMenuItem = new MenuItem("Delete Item", "silk/delete.png");
        deleteMenuItem.addClickHandler(new com.smartgwt.client.widgets.menu.events.ClickHandler() {
            public void onClick(MenuItemClickEvent event) {
                itemList.removeSelectedData();
                detailPane.clearDetails(null);
            }
        });

        itemListMenu.setData(detailsMenuItem, editMenuItem, deleteMenuItem);
    }


    public void findItems(String categoryName) {

        Criteria findValues;

        String formValue = searchForm.getValueAsString("findInCategory");
        ListGridRecord selectedCategory = categoryTree.getSelectedRecord();
        if (formValue != null && selectedCategory != null) {
            categoryName = selectedCategory.getAttribute("categoryName");
            findValues = searchForm.getValuesAsCriteria();
            findValues.addCriteria("category", categoryName);

        } else if (categoryName == null) {
            findValues = searchForm.getValuesAsCriteria();
        } else {
            findValues = new Criteria();
            findValues.addCriteria("category", categoryName);
        }

        itemList.filterData(findValues);
        detailPane.clearDetails(categoryTree.getSelectedRecord());
    }
}