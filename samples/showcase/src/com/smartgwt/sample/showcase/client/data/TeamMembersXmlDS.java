package com.smartgwt.sample.showcase.client.data;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.data.FieldValueExtractor;
import com.smartgwt.client.data.XMLTools;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;
import com.smartgwt.client.data.fields.DataSourceSequenceField;

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

        setRecordXPath("/List/teamMember");

        /*DataSourceSequenceField uniqueSeqField = new DataSourceSequenceField("uniqueSeq");
        uniqueSeqField.setHidden(true);
        uniqueSeqField.setPrimaryKey(true);*/

        DataSourceSequenceField syntheticField = new DataSourceSequenceField("uniqueField");
        syntheticField.setHidden(true);
        syntheticField.setPrimaryKey(true);
        syntheticField.setFieldValueExtractor(new FieldValueExtractor() {
            public Object execute(Object record, Object value, DataSourceField field, String fieldName) {
                String projectCode = XMLTools.selectString(record, "projectCode");
                String employeeID = XMLTools.selectString(record, "employeeId");
                return employeeID + "_" + projectCode.replace(" ", "_");
            }
        });

        DataSourceTextField nameField = new DataSourceTextField("employeeName", "Name", 128);

        DataSourceIntegerField employeeIdField = new DataSourceIntegerField("employeeId", "Employee ID");
        employeeIdField.setForeignKey("employeesDS.EmployeeId");
        
        DataSourceTextField projectCodeField = new DataSourceTextField("projectCode", "Project Code", 30);

        setFields(syntheticField, nameField, employeeIdField, projectCodeField);

        setDataURL("ds/test_data/teamMembers.data.xml");
        setClientOnly(true);
    }
}