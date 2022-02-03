package com.smartgwt.sample.showcase.client.tree;

import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.tree.TreeGrid;
import com.smartgwt.client.widgets.tree.TreeGridField;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;
import com.smartgwt.sample.showcase.client.data.EmployeeXmlDS;

public class FrozenColumnsSample extends ShowcasePanel {
    private static final String DESCRIPTION = "<p>Grids and multi-column trees can set a  " +
            "column to frozen by setting <code>frozen:true</code>.</p><p>" +
            "Reordering, drag and drop and load on demand all function normally. Double click " +
            "a cell to edit.</p>";

    public static class Factory implements PanelFactory {
        private String id;

        public ShowcasePanel create() {
            FrozenColumnsSample panel = new FrozenColumnsSample();
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
        treeGrid.setLoadDataOnDemand(false);
        treeGrid.setWidth(500);
        treeGrid.setHeight(400);
        treeGrid.setDataSource(employeesDS);
        treeGrid.setCanEdit(true);
        treeGrid.setNodeIcon("icons/16/person.png");
        treeGrid.setFolderIcon("icons/16/person.png");
        treeGrid.setAutoFetchData(true);
        treeGrid.setCanFreezeFields(true);
        treeGrid.setCanReparentNodes(true);       
        treeGrid.setShowSelectedIcons(true);

        TreeGridField nameField = new TreeGridField("Name", 150);
        nameField.setFrozen(true);

        TreeGridField jobField = new TreeGridField("Job", 150);
        TreeGridField employeeTypeField = new TreeGridField("EmployeeType", 150);
        TreeGridField employeeStatusField = new TreeGridField("EmployeeStatus", 150);
        TreeGridField salaryField = new TreeGridField("Salary", 100);
        TreeGridField genderField = new TreeGridField("Gender", 100);
        TreeGridField maritalStatusField = new TreeGridField("MaritalStatus", 100);

        treeGrid.setFields(nameField, jobField, employeeTypeField,employeeStatusField,
                salaryField, genderField, maritalStatusField);

        return treeGrid;
    }

    public String getIntro() {
        return DESCRIPTION;
    }
}