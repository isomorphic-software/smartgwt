/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */
package com.smartgwt.sample.showcase.client.tree;

import com.smartgwt.client.types.TreeModelType;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.tree.Tree;
import com.smartgwt.client.widgets.tree.TreeGrid;
import com.smartgwt.client.widgets.tree.TreeGridField;
import com.smartgwt.client.widgets.tree.TreeNode;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

public class LocalDataTreePanel extends ShowcasePanel {

    private static String DESCRIPTION = "In this example the TreeNode's are loaded using local data.";

    public static class Factory implements PanelFactory {

        private String id;

        public ShowcasePanel create() {
            LocalDataTreePanel panel = new LocalDataTreePanel();
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

        TreeGridField field = new TreeGridField();
        field.setName("Name");
        field.setTitle("Tree from local data");
        field.setCanSort(false);

        treeGrid.setFields(field);

        Tree tree = new Tree();
        tree.setModelType(TreeModelType.PARENT);
        //tree.setRootValue("1");
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

        tree.setRoot(root);

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
