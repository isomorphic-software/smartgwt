package com.smartgwt.sample.showcase.client.data;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class TeamMembersXmlDS extends DataSource {

    private static TeamMembersXmlDS instance = null;

    public static TeamMembersXmlDS getInstance() {
        if (instance == null) {
            instance = new TeamMembersXmlDS("teamMembersDS");
        }
        return instance;
    }

    public TeamMembersXmlDS(String id) {

        setID(id);
        setTitleField("employeeName");
        setRecordXPath("/List/teamMember");

        DataSourceIntegerField syntheticField = new DataSourceIntegerField("uniqueSeq");
        syntheticField.setHidden(true);
        syntheticField.setPrimaryKey(true);

        DataSourceTextField nameField = new DataSourceTextField("employeeName", "Name", 128);

        DataSourceIntegerField employeeIdField = new DataSourceIntegerField("employeeId", "Employee ID");
        employeeIdField.setForeignKey("employeesDS.EmployeeId");
        
        DataSourceTextField projectCodeField = new DataSourceTextField("projectCode", "Project Code", 30);

        setFields(syntheticField, nameField, employeeIdField, projectCodeField);

        setDataURL("ds/test_data/teamMembers.data.xml");
        setClientOnly(true);
    }
}