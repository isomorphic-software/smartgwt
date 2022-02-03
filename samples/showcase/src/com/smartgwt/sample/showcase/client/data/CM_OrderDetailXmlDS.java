package com.smartgwt.sample.showcase.client.data;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class CM_OrderDetailXmlDS extends DataSource {  
  
    private static CM_OrderDetailXmlDS instance = null;  
  
    public static CM_OrderDetailXmlDS getInstance() {  
        if (instance == null) {  
            instance = new CM_OrderDetailXmlDS("CM_OrderDetail");  
        }  
        return instance;  
    }  
  
    public CM_OrderDetailXmlDS(String id) {  
    	setID(id);  
        setRecordXPath("/List/Object");  
        DataSourceIntegerField pkOrderNumberField = new DataSourceIntegerField("orderNumber");  
        pkOrderNumberField.setHidden(true);  
        pkOrderNumberField.setPrimaryKey(true);  
        pkOrderNumberField.setForeignKey("CM_Order.orderNumber");

        DataSourceTextField pkProductCodeField = new DataSourceTextField("productCode");  
        pkProductCodeField.setHidden(true);  
        pkProductCodeField.setPrimaryKey(true);  
        pkProductCodeField.setForeignKey("CM_Product.productCode");
        pkProductCodeField.setDisplayField("productName");

        DataSourceTextField productNameField = new DataSourceTextField("productName", "Product Name", 50);
        productNameField.setAttribute("includeFrom", "CM_Product.productName");
        productNameField.setHidden(true);
        
        DataSourceIntegerField orderLineNumberField = new DataSourceIntegerField("orderLineNumber", "Order Line Number", 100, true);
        DataSourceIntegerField quantityOrderedField = new DataSourceIntegerField("quantityOrdered", "Quantity Ordered", 100, true);
        DataSourceFloatField priceEachField = new DataSourceFloatField("priceEach", "Price Each", 100, true);
        priceEachField.setDecimalPad(2);
        priceEachField.setDecimalPrecision(2);
        
        setFields(pkOrderNumberField, pkProductCodeField, productNameField, orderLineNumberField, 
                quantityOrderedField, priceEachField);  
  
        setDataURL("ds/test_data/CM_OrderDetail.data.xml");  
        setClientOnly(true);  
    }

}
