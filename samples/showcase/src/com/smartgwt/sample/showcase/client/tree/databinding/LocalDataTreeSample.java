package com.smartgwt.sample.showcase.client.tree.databinding;

import com.smartgwt.client.types.TreeModelType;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.events.DrawEvent;
import com.smartgwt.client.widgets.events.DrawHandler;
import com.smartgwt.client.widgets.tree.Tree;
import com.smartgwt.client.widgets.tree.TreeGrid;
import com.smartgwt.client.widgets.tree.TreeGridField;
import com.smartgwt.client.widgets.tree.TreeNode;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

public class LocalDataTreeSample extends ShowcasePanel {
    private static final String DESCRIPTION = "Load tree data from a collection of local beans.";

    public static class Factory implements PanelFactory {

        private String id;

        public ShowcasePanel create() {
            LocalDataTreeSample panel = new LocalDataTreeSample();
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
        TreeGrid treeGrid = new TreeGrid();
        treeGrid.setWidth(300);
        treeGrid.setHeight(400);

        TreeGridField field = new TreeGridField("Name", "Tree from local data");
        field.setCanSort(false);

        treeGrid.setFields(field);

        final Tree tree = new Tree();
        tree.setModelType(TreeModelType.PARENT);
        tree.setNameProperty("Name");
        tree.setIdField("EmployeeId");
        tree.setParentIdField("ReportsTo");
        tree.setShowRoot(true);

        EmployeeTreeNode root = new EmployeeTreeNode("4", "1", "Charles Madigen");
        EmployeeTreeNode node2 = new EmployeeTreeNode("188", "4", "Rogine Leger");
        EmployeeTreeNode node3 = new EmployeeTreeNode("189", "4", "Gene Porter");
        EmployeeTreeNode node4 = new EmployeeTreeNode("265", "189", "Olivier Doucet");
        EmployeeTreeNode node5 = new EmployeeTreeNode("264", "189", "Cheryl Pearson");
        tree.setData(new TreeNode[]{root, node2, node3, node4, node5});

        treeGrid.addDrawHandler(new DrawHandler() {
            public void onDraw(DrawEvent event) {
                tree.openAll();
            }
        });
        
        treeGrid.setData(tree);

        return treeGrid;
    }

    public static class EmployeeTreeNode extends TreeNode {

        public EmployeeTreeNode(String employeeId, String reportsTo, String name) {
            setEmployeeId(employeeId);
            setReportsTo(reportsTo);
            setName(name);
        }

        public void setEmployeeId(String value) {
            setAttribute("EmployeeId", value);
        }

        public void setReportsTo(String value) {
            setAttribute("ReportsTo", value);
        }

        public void setName(String name) {
            setAttribute("Name", name);
        }
    }

    public String getIntro() {
        return DESCRIPTION;
    }
}
