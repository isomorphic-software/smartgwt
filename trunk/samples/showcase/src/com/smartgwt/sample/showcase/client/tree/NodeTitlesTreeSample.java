package com.smartgwt.sample.showcase.client.tree;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.tree.TreeGrid;
import com.smartgwt.client.widgets.tree.TreeGridField;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

public class NodeTitlesTreeSample extends ShowcasePanel {
    private static final String DESCRIPTION = "Formatter interfaces allow you to add custom tree titles.";

    public static class Factory implements PanelFactory {

        private String id;

        public Canvas create() {
            NodeTitlesTreeSample panel = new NodeTitlesTreeSample();
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

        DataSource employeesDS = new DataSource();
        employeesDS.setID("employees");
        employeesDS.setRecordXPath("/List/employee");
        DataSourceTextField nameField = new DataSourceTextField("Name", "Name", 128);

        DataSourceIntegerField employeeIdField = new DataSourceIntegerField("EmployeeId", "Employee ID");
        employeeIdField.setPrimaryKey(true);
        employeeIdField.setRequired(true);

        DataSourceIntegerField reportsToField = new DataSourceIntegerField("ReportsTo", "Manager");
        reportsToField.setRequired(true);
        reportsToField.setForeignKey("employees.EmployeeId");
        reportsToField.setRootValue(1);

        DataSourceTextField jobField = new DataSourceTextField("Job", "Title", 128);
        DataSourceTextField emailField = new DataSourceTextField("Email", "Email", 128);
        DataSourceTextField statusField = new DataSourceTextField("EmployeeStatus", "Status", 40);
        DataSourceFloatField salaryField = new DataSourceFloatField("Salary", "Salary");
        DataSourceTextField orgField = new DataSourceTextField("OrgUnit", "Org Unit", 128);
        DataSourceTextField genderField = new DataSourceTextField("Gender", "Gender", 7);

        DataSourceTextField maritalStatusField = new DataSourceTextField("MaritalStatus", "Marital Status", 10);
        maritalStatusField.setValueMap("Single", "Married");
        
        employeesDS.setFields(nameField, employeeIdField, reportsToField, jobField, emailField,
                statusField, salaryField, orgField, genderField, maritalStatusField);

        employeesDS.setDataURL("ds/test_data/employees.data.xml");


        TreeGrid treeGrid = new TreeGrid();
        treeGrid.setLoadDataOnDemand(false);
        treeGrid.setID("employeeTree");
        treeGrid.setWidth(500);
        treeGrid.setHeight(400);
        treeGrid.setDataSource(employeesDS);
        treeGrid.setNodeIcon("icons/16/person.png");
        treeGrid.setFolderIcon("icons/16/person.png");
        treeGrid.setShowOpenIcons(false);
        treeGrid.setShowDropIcons(false);
        treeGrid.setClosedIconSuffix("");
        treeGrid.setAutoFetchData(true);

        TreeGridField field = new TreeGridField();
        field.setName("Name");
        //TODO assign formatter

        treeGrid.setFields(field);
        return treeGrid;
    }

    public String getIntro() {
        return DESCRIPTION;
    }
}