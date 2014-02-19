package com.smartgwt.sample.showcase.client.tree.databinding;

import com.smartgwt.client.types.TreeModelType;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.tree.Tree;
import com.smartgwt.client.widgets.tree.TreeGrid;
import com.smartgwt.client.widgets.tree.TreeGridField;
import com.smartgwt.client.widgets.tree.TreeNode;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

public class ParentLinkingTreeSample extends ShowcasePanel {
   
    private static final String DESCRIPTION = "Tree data can be specified as a flat list of nodes that refer to each other by ID. This format is also used for load on demand.";
    
    public static final TreeNode[] employeeData = new TreeNode[] {
        new EmployeeTreeNode("4", "1", "Charles Madigen"),
        new EmployeeTreeNode("189", "4", "Gene Porter"),
        new EmployeeTreeNode("265", "189", "Olivier Doucet"),
        new EmployeeTreeNode("264", "189", "Cheryl Pearson"),
        new EmployeeTreeNode("188", "4", "Rogine Leger")
    };

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
            ParentLinkingTreeSample panel = new ParentLinkingTreeSample();
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
        Tree employeeTree = new Tree();
        employeeTree.setModelType(TreeModelType.PARENT);
        employeeTree.setIdField("EmployeeId");
        employeeTree.setParentIdField("ReportsTo");
        employeeTree.setNameProperty("Name");
        employeeTree.setRootValue(1);
        employeeTree.setData(employeeData);
       
        TreeGrid employeeTreeGrid = new TreeGrid();
        employeeTreeGrid.setWidth(500);
        employeeTreeGrid.setHeight(400);
        employeeTreeGrid.setNodeIcon("icons/16/person.png");
        employeeTreeGrid.setFolderIcon("icons/16/person.png");
        employeeTreeGrid.setShowOpenIcons(false);
        employeeTreeGrid.setShowDropIcons(false);
        employeeTreeGrid.setClosedIconSuffix("");
        employeeTreeGrid.setFields(new TreeGridField("Name"));
        employeeTreeGrid.setData(employeeTree);
        
        employeeTreeGrid.getData().openAll();
        
        return employeeTreeGrid;
    }

    public static class EmployeeTreeNode extends TreeNode {
        public EmployeeTreeNode(String employeeId, String reportsTo, String name) {
            setAttribute("EmployeeId", employeeId);
            setAttribute("ReportsTo", reportsTo);
            setAttribute("Name", name);
        }
    }

    public String getIntro() {
        return DESCRIPTION;
    }
}