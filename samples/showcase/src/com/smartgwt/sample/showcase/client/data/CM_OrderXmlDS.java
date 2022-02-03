package com.smartgwt.sample.showcase.client.data;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.DataSourceDateField;
import com.smartgwt.client.data.fields.DataSourceEnumField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class CM_OrderXmlDS extends DataSource {  
  
    private static CM_OrderXmlDS instance = null;  
  
    public static CM_OrderXmlDS getInstance() {  
        if (instance == null) {  
            instance = new CM_OrderXmlDS("CM_Order");  
        }  
        return instance;  
    }  
  
    public CM_OrderXmlDS(String id) {  
    	setID(id);  
        setRecordXPath("/List/Object");  
        DataSourceIntegerField pkField = new DataSourceIntegerField("orderNumber");  
        pkField.setHidden(true);  
        pkField.setPrimaryKey(true);  
  
        DataSourceDateField orderDateField = new DataSourceDateField("orderDate", "Order Date", 30, true);  
        DataSourceDateField requiredDateField = new DataSourceDateField("requiredDate", "Required Date", 30, true);
        DataSourceDateField shippedDateField = new DataSourceDateField("shippedDate", "Shipped Date", 30);
        
        DataSourceEnumField statusField = new DataSourceEnumField("status", "Status", 25, true);  
        statusField.setValueMap("In Process", "Shipped", "Cancelled", "Disputed", "Resolved", "On Hold");  
        
        DataSourceTextField commentsField = new DataSourceTextField("comments", "Comments", 200); 
        
        DataSourceIntegerField customerNumberField = new DataSourceIntegerField("customerNumber", "Customer", 100, true);
        customerNumberField.setForeignKey("CM_Customer.customerNumber");
        customerNumberField.setDisplayField("customerName");
        
        DataSourceTextField customerNameField = new DataSourceTextField("customerName", "Customer Name", 50);
        customerNameField.setAttribute("includeFrom", "CM_Customer.customerName");
        customerNameField.setHidden(true);

        setFields(pkField, orderDateField, requiredDateField, shippedDateField, statusField, commentsField,
        		customerNumberField, customerNameField);  
  
        setDataURL("ds/test_data/CM_Order.data.xml");  
        setClientOnly(true);  
    }

}
