package com.smartgwt.sample.showcase.client.data;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class ShowcaseDS extends DataSource {

    public ShowcaseDS(String id) {
        setID(id);
        DataSourceTextField nameField = new DataSourceTextField("name", "Name");

        DataSourceTextField nodeIdField = new DataSourceTextField("nodeID", "Node ID");
        nodeIdField.setPrimaryKey(true);
        nodeIdField.setRequired(true);

        DataSourceTextField parentNodeIdField = new DataSourceTextField("parentNodeID", "Parent Node ID");
        parentNodeIdField.setRequired(true);
        parentNodeIdField.setForeignKey(id + ".nodeID");

        String idSuffix = "_" + id;
        parentNodeIdField.setRootValue("root" + idSuffix);

        DataSourceTextField iconField = new DataSourceTextField("icon", "Icon");

        DataSourceTextField descriptionField = new DataSourceTextField("description", "Description");
        addField(descriptionField);

        setFields(nameField, parentNodeIdField, nodeIdField, nodeIdField, iconField);
        setClientOnly(true);
        setTestData(ShowcaseData.getData(idSuffix));
    }
}
