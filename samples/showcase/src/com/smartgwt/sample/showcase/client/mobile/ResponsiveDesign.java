package com.smartgwt.sample.showcase.client.mobile;

import com.smartgwt.client.types.DeviceMode;
import com.smartgwt.client.types.PageOrientation;
import com.smartgwt.client.util.Page;
import com.smartgwt.client.widgets.Button;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.events.RecordClickEvent;
import com.smartgwt.client.widgets.grid.events.RecordClickHandler;
import com.smartgwt.client.widgets.layout.SplitPane;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.tab.Tab;
import com.smartgwt.client.widgets.tab.TabSet;
import com.smartgwt.client.widgets.tree.TreeGrid;
import com.smartgwt.client.widgets.tree.events.NodeClickEvent;
import com.smartgwt.client.widgets.tree.events.NodeClickHandler;
import com.smartgwt.client.widgets.viewer.DetailViewer;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;
import com.smartgwt.sample.showcase.client.data.ItemSupplyXmlDS;
import com.smartgwt.sample.showcase.client.data.SupplyCategoryXmlDS;

public class ResponsiveDesign extends ShowcasePanel {
    private static final String DESCRIPTION = "SplitPane displays up to 3 panes in a device- " +
            "and orientation-sensitive manner, automatically providing navigation controls " +
            "between panes for devices that don't have enough room to display panes " +
            "side-by-side." +
            "<p>" +
            "This example shows 3 SplitPanes in 3 different tabs, each demonstrating a " +
            "display and navigation behavior intended for a specific class of device." +
            "<p>" +
            "If you are using a tablet or handset to view this sample, you can flip it to " +
            "watch the SplitPane react.  Alternatively, use the \"Flip\" button in each tab, " +
            "but note that once you have manually set the orientation, the SplitPane will " +
            "stop responding to device orientation changes.";

    public static class Factory implements PanelFactory {
        private String id;

        public ShowcasePanel create() {
            ResponsiveDesign panel = new ResponsiveDesign();
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

    public Canvas createSplitPane(final DeviceMode deviceMode) {
        final SplitPane splitPane = new SplitPane();
        splitPane.setAutoDraw(Boolean.FALSE);
        splitPane.setNavigationTitle("Categories");
        splitPane.setShowLeftButton(false);
        splitPane.setShowRightButton(false);
        splitPane.setBorder("1px solid blue");
        splitPane.setDeviceMode(deviceMode);

        final DetailViewer detailPane = new DetailViewer();
        detailPane.setDataSource(ItemSupplyXmlDS.getInstance());
        detailPane.setAutoDraw(Boolean.FALSE);

        final ListGrid listPane = new ListGrid();
        listPane.setDataSource(ItemSupplyXmlDS.getInstance());
        listPane.setAutoDraw(Boolean.FALSE);
        listPane.addRecordClickHandler(new RecordClickHandler() {
            @Override
            public void onRecordClick(RecordClickEvent event) {
                detailPane.viewSelectedData(listPane);
                splitPane.setDetailTitle((event.getRecordNum() + 1) + " of " + listPane.getTotalRows());
                splitPane.showDetailPane();
            }
        });
        if (deviceMode.equals(DeviceMode.TABLET)) {
            ListGridField itemNameField = new ListGridField("itemName");
            ListGridField unitCostField = new ListGridField("unitCost");
            ListGridField inStockField = new ListGridField("inStock");
            listPane.setFields(itemNameField, unitCostField, inStockField);
        }
        
        final TreeGrid navigationPane = new TreeGrid();
        navigationPane.setAutoDraw(Boolean.TRUE);
        navigationPane.setDataSource(SupplyCategoryXmlDS.getInstance());
        navigationPane.setAutoFetchData(Boolean.TRUE);
        navigationPane.setShowHeader(deviceMode.equals(DeviceMode.DESKTOP));
        navigationPane.addNodeClickHandler(new NodeClickHandler() {
            
            @Override
            public void onNodeClick(NodeClickEvent event) {
                listPane.fetchRelatedData(event.getNode(), navigationPane);
                splitPane.setListTitle(event.getNode().getAttribute("categoryName"));
                splitPane.showListPane();
            }
        });
        
        splitPane.setDetailPane(detailPane);
        splitPane.setNavigationPane(navigationPane);
        splitPane.setListPane(listPane);

        final Button flipButton = new Button("Flip (" + Page.getOrientation().getValue() + ")");
        flipButton.setAutoFit(Boolean.TRUE);
        flipButton.addClickHandler(new ClickHandler() {
            
            @Override
            public void onClick(ClickEvent event) {
                PageOrientation newOrientation = splitPane.getPageOrientation() == PageOrientation.LANDSCAPE ?
                        PageOrientation.PORTRAIT : PageOrientation.LANDSCAPE;
                splitPane.setPageOrientation(newOrientation);
                flipButton.setTitle("Flip (" + newOrientation.getValue() + ")");
            }
        });
        VLayout container = new VLayout();
        container.setLayoutMargin(10);
        container.setMembersMargin(2);
        container.setMembers(flipButton, splitPane);
        return container;
    }

    public Canvas getViewPanel() {
        TabSet layout = new TabSet();
        layout.setWidth100();
        layout.setHeight100();
        Tab desktopTab = new Tab("desktop");
        desktopTab.setPane(createSplitPane(DeviceMode.DESKTOP));
        Tab tabletTab = new Tab("tablet");
        tabletTab.setPane(createSplitPane(DeviceMode.TABLET));
        Tab handsetTab = new Tab("handset");
        handsetTab.setPane(createSplitPane(DeviceMode.HANDSET));
        layout.setTabs(desktopTab , tabletTab, handsetTab);
        return layout;
    }

    public String getIntro() {
        return DESCRIPTION;
    }

}
