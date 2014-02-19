package com.smartgwt.sample.showcase.client.tree;

import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.tree.TreeGrid;
import com.smartgwt.client.widgets.tree.TreeGridField;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;
import com.smartgwt.sample.showcase.client.data.EmployeeXmlDS;

public class FrozenColumnsSample extends ShowcasePanel {
    private static final String DESCRIPTION = "<p>Setting frozen:true enables frozen columns for Trees.</p><p>Columns can be frozen and unfrozen by right-clicking on column headers." +
            "Column resize, column reorder, drag and drop and load on demand all function normally. Double click a cell to edit.</p>";

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
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

        TreeGridField nameField = new TreeGridField("Name", 150);
        nameField.setFrozen(true);

        TreeGridField jobField = new TreeGridField("Job", 150);
        TreeGridField employeeTypeField = new TreeGridField("EmployeeType", 150);
        TreeGridField employeeStatusField = new TreeGridField("EmployeeStatus", 150);
        TreeGridField salaryField = new TreeGridField("Salary");
        TreeGridField genderField = new TreeGridField("Gender");
        TreeGridField maritalStatusField = new TreeGridField("MaritalStatus");

        treeGrid.setFields(nameField, jobField, employeeTypeField,employeeStatusField,
                salaryField, genderField, maritalStatusField);

        return treeGrid;
    }

    public String getIntro() {
        return DESCRIPTION;
    }
}