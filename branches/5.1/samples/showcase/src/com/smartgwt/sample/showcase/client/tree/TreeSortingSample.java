package com.smartgwt.sample.showcase.client.tree;

import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.tree.TreeGrid;
import com.smartgwt.client.widgets.tree.TreeGridField;
import com.smartgwt.client.widgets.tree.events.DataArrivedEvent;
import com.smartgwt.client.widgets.tree.events.DataArrivedHandler;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;
import com.smartgwt.sample.showcase.client.data.EmployeeXmlDS;

public class TreeSortingSample extends ShowcasePanel {
    private static final String DESCRIPTION = "Trees sort per folder. Click on the \"Name\"" +
                                              " column header to sort alphabetically by folder" +
                                              " name, or on the \"Salary\" column header to sort" +
                                              " by Salary.";

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
            TreeSortingSample panel = new TreeSortingSample();
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
        //TODO fix sample
        final TreeGrid treeGrid = new TreeGrid();
        treeGrid.setLoadDataOnDemand(false);
        treeGrid.setWidth(500);
        treeGrid.setHeight(400);
        treeGrid.setDataSource(EmployeeXmlDS.getInstance());
        treeGrid.setNodeIcon("icons/16/person.png");
        treeGrid.setFolderIcon("icons/16/person.png");
        treeGrid.setAutoFetchData(true);


        TreeGridField nameField = new TreeGridField("Name", 150);
        TreeGridField jobField = new TreeGridField("Job", 150);
        TreeGridField salaryField = new TreeGridField("Salary");

        treeGrid.setFields(nameField, jobField, salaryField);
        
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