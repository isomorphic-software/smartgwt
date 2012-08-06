package com.smartgwt.sample.showcase.client.data;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class SupplyCategoryXmlDS extends DataSource {

    private static SupplyCategoryXmlDS instance = null;

    public static SupplyCategoryXmlDS getInstance() {
        if (instance == null) {
            instance = new SupplyCategoryXmlDS("supplyCategoryDS");
        }
        return instance;
    }

    public SupplyCategoryXmlDS(String id) {

        setID(id);
        setRecordXPath("/List/supplyCategory");


        DataSourceTextField itemNameField = new DataSourceTextField("categoryName", "Item", 128, true);
        itemNameField.setPrimaryKey(true);

        DataSourceTextField parentField = new DataSourceTextField("parentID", null);
        parentField.setHidden(true);
        parentField.setRequired(true);
        parentField.setRootValue("root");
        parentField.setForeignKey("supplyCategoryDS.categoryName");


        setFields(itemNameField, parentField);

        setDataURL("ds/test_data/supplyCategory.data.xml");
        
        setClientOnly(true);

    }
}