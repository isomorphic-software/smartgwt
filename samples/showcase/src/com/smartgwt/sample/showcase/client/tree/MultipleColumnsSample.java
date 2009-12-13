package com.smartgwt.sample.showcase.client.tree;

import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.tree.TreeGrid;
import com.smartgwt.client.widgets.tree.TreeGridField;
import com.smartgwt.client.widgets.tree.events.DataArrivedEvent;
import com.smartgwt.client.widgets.tree.events.DataArrivedHandler;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;
import com.smartgwt.sample.showcase.client.data.EmployeeXmlDS;

public class MultipleColumnsSample extends ShowcasePanel {
    private static final String DESCRIPTION = "<p>Trees can show multiple columns of data for each node. Each column has the styling, formatting, and data " +
            "type awareness features of columns in a normal grid.</p><p>Try drag reordering columns, or sorting by the Salary field.</p>";

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
            MultipleColumnsSample panel = new MultipleColumnsSample();
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

        EmployeeXmlDS employeesDS = EmployeeXmlDS.getInstance();

        final TreeGrid treeGrid = new TreeGrid();
        treeGrid.setCanEdit(true);
        treeGrid.setLoadDataOnDemand(false);
        treeGrid.setWidth(360);
        treeGrid.setHeight(400);
        treeGrid.setDataSource(employeesDS);
        treeGrid.setNodeIcon("icons/16/person.png");
        treeGrid.setFolderIcon("icons/16/person.png");
        treeGrid.setShowOpenIcons(false);
        treeGrid.setShowDropIcons(false);
        treeGrid.setClosedIconSuffix("");
        treeGrid.setAutoFetchData(true);

        TreeGridField nameField = new TreeGridField("Name");
        TreeGridField jobField = new TreeGridField("Job");
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