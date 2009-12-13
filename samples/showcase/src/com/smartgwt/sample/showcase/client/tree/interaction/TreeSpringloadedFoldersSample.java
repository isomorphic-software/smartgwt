package com.smartgwt.sample.showcase.client.tree.interaction;

import com.smartgwt.client.types.TreeModelType;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.grid.CellFormatter;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.tree.Tree;
import com.smartgwt.client.widgets.tree.TreeGrid;
import com.smartgwt.client.widgets.tree.TreeGridField;
import com.smartgwt.client.widgets.tree.TreeNode;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

public class TreeSpringloadedFoldersSample extends ShowcasePanel {
    
    private static final String DESCRIPTION = "<p>Try dragging employees under new managers. "
            + "Note that closed folders automatically open if you hover over them momentarily.</p>";
    
    public static final TreeNode[] employeeData = new TreeNode[] {
            new EmployeeTreeNode("4", "1", "Charles Madigen", "Chief Operating Officer", true),
            new EmployeeTreeNode("189", "4", "Gene Porter", "Mgr Tech Plng IntIS T", false),
            new EmployeeTreeNode("265", "189", "Olivier Doucet", "Asset Spec Lines Stns", false),
            new EmployeeTreeNode("264", "189", "Cheryl Pearson", "Dsl Sys Rep", false),
            new EmployeeTreeNode("263", "189", "Priya Sambhus", "Line Wrker A", false),
            new EmployeeTreeNode("188", "4", "Rogine Leger", "Mgr Syst P P", true),
            new EmployeeTreeNode("262", "188", "Jacques Desautels", "Line Wrker A", false),
            new EmployeeTreeNode("261", "188", "Kay Monroe", "Stn Opr", false),
            new EmployeeTreeNode("260", "188", "Francine Dugas", "Fire Sec Off", false),
            new EmployeeTreeNode("259", "188", "Jacques Leblanc", "Purch Clk", false),
            new EmployeeTreeNode("258", "188", "Ren Xian", "Mobile Eq Opr", false),
            new EmployeeTreeNode("257", "188", "Olivier Hebert", "Met Read/Coll", false),
            new EmployeeTreeNode("182", "4", "Tamara Kane", "Mgr Site Services", false),
            new EmployeeTreeNode("195", "182", "Kai Kong", "Stores Worker", false),
            new EmployeeTreeNode("194", "182", "Felicia Piper", "Dsl Sys Rep", false),
            new EmployeeTreeNode("193", "182", "Darcy Feeney", "Inventory Ck", false)
    };

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
            TreeSpringloadedFoldersSample panel = new TreeSpringloadedFoldersSample();
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
        employeeTree.setRootValue(1);
        employeeTree.setNameProperty("Name");
        employeeTree.setIdField("EmployeeId");
        employeeTree.setParentIdField("ReportsTo");
        employeeTree.setOpenProperty("isOpen");
        employeeTree.setData(employeeData);
        
        TreeGridField formattedField = new TreeGridField("Name");
        formattedField.setCellFormatter(new CellFormatter() {
            public String format(Object value, ListGridRecord record, int rowNum, int colNum) {
                return record.getAttributeAsString("Job") + ":&nbsp;" + value;
            }
        });
        
        TreeGrid employeeTreeGrid = new TreeGrid();

        employeeTreeGrid.setWidth(500);
        employeeTreeGrid.setHeight(400);
        employeeTreeGrid.setNodeIcon("icons/16/person.png");
        employeeTreeGrid.setFolderIcon("icons/16/person.png");
        employeeTreeGrid.setAutoFetchData(true);
        employeeTreeGrid.setCanReorderRecords(true);
        employeeTreeGrid.setCanAcceptDroppedRecords(true);
        employeeTreeGrid.setShowOpenIcons(false);
        employeeTreeGrid.setDropIconSuffix("into");
        employeeTreeGrid.setClosedIconSuffix("");
        employeeTreeGrid.setData(employeeTree);
        employeeTreeGrid.setFields(formattedField);
        
        return employeeTreeGrid;
    }

    public static class EmployeeTreeNode extends TreeNode {
        public EmployeeTreeNode(String employeeId, String reportsTo, String name, String job, boolean isOpen) {
            setAttribute("EmployeeId", employeeId);
            setAttribute("ReportsTo", reportsTo);
            setAttribute("Name", name);
            setAttribute("Job", job);
            setAttribute("isOpen", isOpen);
        }
    }

    public String getIntro() {
        return DESCRIPTION;
    }
}