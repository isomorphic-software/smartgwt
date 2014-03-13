package com.smartgwt.sample.showcase.client.tree.appearance;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.grid.CellFormatter;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.tree.TreeGrid;
import com.smartgwt.client.widgets.tree.TreeGridField;
import com.smartgwt.client.widgets.tree.events.DataArrivedEvent;
import com.smartgwt.client.widgets.tree.events.DataArrivedHandler;
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


        TreeGridField field = new TreeGridField();
        field.setName("Name");
        field.setCellFormatter(new CellFormatter() {
            public String format(Object value, ListGridRecord record, int rowNum, int colNum) {
                return record.getAttribute("Job") + ":&nbsp;" + value;
            }
        });

        treeGrid.setFields(field);

        treeGrid.addDataArrivedHandler(new DataArrivedHandler() {
            public void onDataArrived(DataArrivedEvent event) {
                treeGrid.getData().openAll();
            }
        });

        return treeGrid;
    }

    public String getIntro() {
        return DESCRIPTION;
    }

}