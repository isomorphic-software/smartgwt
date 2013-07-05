package com.smartgwt.sample.showcase.client.tree.databinding;

import com.smartgwt.client.types.TreeModelType;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.tree.Tree;
import com.smartgwt.client.widgets.tree.TreeGrid;
import com.smartgwt.client.widgets.tree.TreeGridField;
import com.smartgwt.client.widgets.tree.TreeNode;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

public class ChildrenArraysTreeSample extends ShowcasePanel {
    
    private static final String DESCRIPTION = "Tree data can be specified as a tree of nodes where each node lists its children.";
    
    public static final TreeNode employeeRoot = new EmployeeTreeNode("1", "Root", 
            new EmployeeTreeNode("4", "Charles Madigen", 
                    new EmployeeTreeNode("188", "Rogine Leger"),
                    new EmployeeTreeNode("189", "Gene Porter", 
                            new EmployeeTreeNode("265", "Olivier Doucet"),
                            new EmployeeTreeNode("264", "Cheryl Pearson")
                    )
            )
    );

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
            ChildrenArraysTreeSample panel = new ChildrenArraysTreeSample();
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
        employeeTree.setModelType(TreeModelType.CHILDREN);
        employeeTree.setNameProperty("Name");
        employeeTree.setChildrenProperty("directReports");
        employeeTree.setRoot(employeeRoot);
        
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
        public EmployeeTreeNode(String employeeId, String name) {
            this(employeeId, name, new EmployeeTreeNode[] {});
        }

        public EmployeeTreeNode(String employeeId, String name, EmployeeTreeNode... children) {
            setAttribute("EmployeeId", employeeId);
            setAttribute("Name", name);
            setAttribute("directReports", children);
        }
    }

    public String getIntro() {
        return DESCRIPTION;
    }
}