package com.smartgwt.sample.showcase.client.tree;

import com.smartgwt.client.types.SelectionAppearance;
import com.smartgwt.client.types.TreeModelType;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.events.DrawEvent;
import com.smartgwt.client.widgets.events.DrawHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.CheckboxItem;
import com.smartgwt.client.widgets.form.fields.events.ChangeEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangeHandler;
import com.smartgwt.client.widgets.grid.CellFormatter;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.tree.Tree;
import com.smartgwt.client.widgets.tree.TreeGrid;
import com.smartgwt.client.widgets.tree.TreeGridField;
import com.smartgwt.client.widgets.tree.TreeNode;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

public class CheckboxTreeSample extends ShowcasePanel {

     private static final String DESCRIPTION = "<p>Tree selection can be automatically propagated up and down the tree. " +
             "Select a parent or child node to see how other nodes are affected.</p>";

    public static final TreeNode[] employeeData = new TreeNode[] {
            new EmployeeTreeNode("4", "1", "Charles Madigen", "Chief Operating Officer", true),
            new EmployeeTreeNode("189", "4", "Gene Porter", "Mgr Tech Plng IntIS T", false),
            new EmployeeTreeNode("265", "189", "Olivier Doucet", "Asset Spec Lines Stns", false),
            new EmployeeTreeNode("264", "189", "Cheryl Pearson", "Dsl Sys Rep", false),
            new EmployeeTreeNode("188", "4", "Rogine Leger", "Mgr Syst P P", true)
    };

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
            CheckboxTreeSample panel = new CheckboxTreeSample();
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


        final TreeGrid employeeTreeGrid = new TreeGrid();
        employeeTreeGrid.setWidth(200);
        employeeTreeGrid.setHeight(240);
        employeeTreeGrid.setNodeIcon("icons/16/person.png");
        employeeTreeGrid.setFolderIcon("icons/16/person.png");
        employeeTreeGrid.setShowOpenIcons(false);
        employeeTreeGrid.setShowDropIcons(false);
        employeeTreeGrid.setClosedIconSuffix("");
        employeeTreeGrid.setData(employeeTree);
        employeeTreeGrid.setSelectionAppearance(SelectionAppearance.CHECKBOX);
        employeeTreeGrid.setShowSelectedStyle(false);
        employeeTreeGrid.setShowPartialSelection(true);
        employeeTreeGrid.setCascadeSelection(true);

        employeeTreeGrid.addDrawHandler(new DrawHandler() {
            public void onDraw(DrawEvent event) {
                employeeTreeGrid.getTree().openAll();
            }
        });

        DynamicForm df = new DynamicForm();

        final CheckboxItem partialSelection = new CheckboxItem("partialSelect", "Allow Partial Selection");
        partialSelection.setDefaultValue(true);
        partialSelection.addChangeHandler(new ChangeHandler() {
            public void onChange(ChangeEvent event) {
                boolean selected = partialSelection.getValueAsBoolean();
                employeeTreeGrid.setShowPartialSelection(!selected);
                employeeTreeGrid.redraw();
            }
        });

        df.setFields(partialSelection);

        HLayout layout = new HLayout(20);
        layout.addMember(employeeTreeGrid);
        layout.addMember(df);

        return layout;
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
