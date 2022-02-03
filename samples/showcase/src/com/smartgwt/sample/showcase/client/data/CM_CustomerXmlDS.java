package com.smartgwt.sample.showcase.client.data;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class CM_CustomerXmlDS extends DataSource {  
  
    private static CM_CustomerXmlDS instance = null;  
  
    public static CM_CustomerXmlDS getInstance() {  
        if (instance == null) {  
            instance = new CM_CustomerXmlDS("CM_Customer");  
        }  
        return instance;  
    }  
  
    public CM_CustomerXmlDS(String id) {  
    	setID(id);  
        setRecordXPath("/List/Object");  
        DataSourceIntegerField pkField = new DataSourceIntegerField("customerNumber");  
        pkField.setHidden(true);  
        pkField.setPrimaryKey(true);  
  
        DataSourceTextField customerNameField = new DataSourceTextField("customerName", "Customer Name", 128, true);  
        DataSourceTextField contactLastNameField = new DataSourceTextField("contactLastName", "Contact Last Name", 128, true);    
        DataSourceTextField contactFirstNameField = new DataSourceTextField("contactFirstName", "Contact First Name", 128);  
        
        DataSourceTextField phoneField = new DataSourceTextField("phone", "Phone", 50, true);
        DataSourceTextField addressLine1Field = new DataSourceTextField("addressLine1", "Address Line1", 150, true);
        DataSourceTextField addressLine2Field = new DataSourceTextField("addressLine2", "Address Line2", 150);
        DataSourceTextField cityField = new DataSourceTextField("city", "City", 50, true);
        DataSourceTextField stateField = new DataSourceTextField("state", "State", 50);
        DataSourceTextField postalCodeField = new DataSourceTextField("postalCode", "Postal Code", 50);
        DataSourceTextField countryField = new DataSourceTextField("country", "Country", 50, true);
        
        DataSourceFloatField creditLimitField = new DataSourceFloatField("creditLimit", "Credit Limit", 20);

        setFields(pkField, customerNameField, contactLastNameField, contactFirstNameField, phoneField, addressLine1Field,
        		addressLine2Field, cityField, stateField, postalCodeField, countryField, creditLimitField);  
  
        setDataURL("ds/test_data/CM_Customer.data.xml");  
        setClientOnly(true);   
    }

}
