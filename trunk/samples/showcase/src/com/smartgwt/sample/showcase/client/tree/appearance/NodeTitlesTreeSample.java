package com.smartgwt.sample.showcase.client.tree.appearance;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.menu.Menu;
import com.smartgwt.client.widgets.menu.MenuItem;
import com.smartgwt.client.widgets.grid.CellFormatter;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.CellContextClickEvent;
import com.smartgwt.client.widgets.grid.events.CellContextClickHandler;
import com.smartgwt.client.widgets.grid.events.CellClickHandler;
import com.smartgwt.client.widgets.grid.events.CellClickEvent;
import com.smartgwt.client.widgets.tree.TreeGrid;
import com.smartgwt.client.widgets.tree.TreeGridField;
import com.smartgwt.client.widgets.tree.Tree;
import com.smartgwt.client.widgets.tree.TreeNode;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;
import com.smartgwt.sample.showcase.client.data.EmployeeXmlDS;

public class NodeTitlesTreeSample extends ShowcasePanel {
    private static final String DESCRIPTION = "Formatter interfaces allow you to add custom tree titles.";

    public static class Factory implements PanelFactory {

        private String id;

        public Canvas create() {
            NodeTitlesTreeSample panel = new NodeTitlesTreeSample();
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

        DataSource employeeDS = EmployeeXmlDS.getInstance();

        final TreeGrid treeGrid = new TreeGrid();
        treeGrid.setLoadDataOnDemand(false);        
        treeGrid.setWidth(500);
        treeGrid.setHeight(400);
        treeGrid.setDataSource(employeeDS);
        treeGrid.setNodeIcon("icons/16/person.png");
        treeGrid.setFolderIcon("icons/16/person.png");
        treeGrid.setShowOpenIcons(false);
        treeGrid.setShowDropIcons(false);
        treeGrid.setClosedIconSuffix("");
        treeGrid.setAutoFetchData(true);


        final Menu contextMenu = new Menu();
        contextMenu.addItem(new MenuItem("Expand node"));
        contextMenu.addCellClickHandler(new CellClickHandler() {
            public void onCellClick(CellClickEvent event) {
                if (event.getRowNum() == 0) {
                    //open the selected node
                    Tree tree = treeGrid.getData();
                    ListGridRecord record = treeGrid.getSelectedRecord();
                    TreeNode node = (TreeNode) record;
                    TreeNode[] children = tree.getChildren(node);
                    tree.openFolder(node);

                }
            }
        });

        //treeGrid.setContextMenu(contextMenu);
        treeGrid.addCellClickHandler(new CellClickHandler() {
            public void onCellClick(CellClickEvent event) {
                //show the menu if the click happened on the first column
                if (event.getColNum() == 0) {
                    //treeGrid.getContextMenu().showContextMenu();
                    contextMenu.showContextMenu();
                }
            }
        });

        //don't allow right clicks on tree grid
        treeGrid.addCellContextClickHandler(new CellContextClickHandler(){
            public void onCellContextClick(CellContextClickEvent event) {
            event.cancel();
            }
        });

        TreeGridField field = new TreeGridField();
        field.setName("Name");
        field.setCellFormatter(new CellFormatter() {
            public String format(Object value, ListGridRecord record, int rowNum, int colNum) {
                return record.getAttribute("Job") + ":&nbsp;" + value;
            }
        });

        treeGrid.setFields(field);
        return treeGrid;
    }

    public String getIntro() {
        return DESCRIPTION;
    }

    public String getSourceUrl() {
        return "source/tree/appearance/NodeTitlesTreeSample.java.html";
    }
}